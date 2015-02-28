(ns dmtool.core
  (:use compojure.core
        ring.middleware.json
        ring.util.response)
  (:require [compojure.route :as route]
            [dmtool.view :as view]))

(defn hello
  "I don't do a whole lot."
  [x]
  (str "Hello, " x "! Nice to meet you."))

(defroutes handler
  (GET "/" [] (view/index-page))
  (GET "/rest" [] (response {:email "kevin@kevinlitwack.com"}))
  (route/resources "/"))

(def app (wrap-json-response handler))
