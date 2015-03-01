(ns dmtool.view
  (:use hiccup.page hiccup.element)
  (:require [compojure.route :as route]
            [clojure.string :as str]))


(defn- keyword-to-pretty-name
  [k]
  (str/capitalize (name k)))


(defn index-page []
  (html5
    [:html
     [:head ]
     [:body "wow dude"]]))


(defn render-character
  [c]
  (html5
    [:html
     [:head
      [:link {:rel "stylesheet" :href "/css/bootstrap.min.css"}]
      [:link {:rel "stylesheet" :href "/css/site.css"}]
      ]
     [:body
      [:ul
       [:li (str "Race: " (keyword-to-pretty-name (:race c)))]
       [:li (str "Class: " (keyword-to-pretty-name (:class c)))]
       ]
      [:script {:src "/js/bootstrap.min.js"}]
      [:script {:src "/js/site.js"}] ]
     ]))
