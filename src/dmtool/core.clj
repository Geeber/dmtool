(ns dmtool.core
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.route :as route]
            [dmtool.view :as view]
            (ring.middleware
              [json :refer [wrap-json-response]]
              [not-modified :refer [wrap-not-modified]]
              [content-type :refer [wrap-content-type]]
              [resource :refer [wrap-resource]])
            [ring.util.response]
            [dmtool.character :as character]))

(defroutes handler
  (GET "/" [] (view/index-page (character/character)))
  (GET "/character" [] (view/render-character (character/character)))
  (route/resources "/"))

(def app (-> handler
             (wrap-resource "public")
             wrap-content-type
             wrap-not-modified
             wrap-json-response))
