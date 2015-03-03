(ns dmtool.view
  (:use hiccup.page hiccup.element)
  (:require [compojure.route :as route]
            [clojure.pprint :refer [pprint]]
            [clojure.string :as str]))


;;;;; TEMPLATE FUNCTIONS ;;;;;

(defn- head
  "Generates an html <head> section."
  [title & extra]
  [:head
   [:title title]
   [:meta {:charset "utf-8"}]
   [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge"}]
   [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0"}]
   [:link {:href "/css/bootstrap.min.css" :rel "stylesheet" :media "screen"}]
   [:link {:href "/css/site.css" :rel "stylesheet"}]
   [:script {:src "/js/jquery.min.js"}]
   [:script {:src "/js/site.js"}]
   extra])


(def ^:const ^:private navbar
  [:div.navbar.navbar-inverse.navbar-fixed-top
   [:div.container
    [:div.navbar-header
     [:a.navbar-brand {:href "/"} "DM Tools"]]
    [:div.collapse.navbar-collapse
     [:ul.nav.navbar-nav
      [:li [:a {:href "/about"} "About"]]
      [:li [:a {:href "mailto:kevin.litwack@gmail.com?subject=DM%20Tool%20Feedback"} "Send me feedback!"]]]]]])


(defn- page
  "Generates an html page based on the standard template."
  [head-content body-content]
  (html5
    head-content
    [:body {:style "padding-top: 50px;"}
     navbar
     [:div.container
      body-content]]))



;;;;; PAGE VIEWS ;;;;;

(defn- keyword-to-pretty-name
  [k]
  (str/capitalize (name k)))


(defn index-page
  []
  (page
    (head "DM Tools")
    [:p "This is the index; I haven't put anything here yet :p"]))


(defn render-character
  [c]
  (page
    (head "DM Tools - Random Character")
    [:div.character
      [:h1 "Character"]
      [:ul
       [:li (str "Race: " (keyword-to-pretty-name (:race c)))]
       [:li (str "Class: " (keyword-to-pretty-name (:class c)))]
       ]]))


(def about
  (page
    (head "DM Tools - About")
    [:div.about {:style "padding: 40px 15px;"}
     [:h1 "About these Dungeon Master Tools"]
     [:p
      "This is a project to help dungeon masters quickly generate characters
      and content for one-time adventures."]]))
