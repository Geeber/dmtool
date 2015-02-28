(defproject dmtool "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[lein-ring "0.8.13"]]
  :ring {:handler dmtool.core/app
         :auto-reload? true
         :auto-refresh? false}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [ring/ring "1.3.2"]
                 [ring/ring-json "0.2.0"]
                 [hiccup "1.0.4"]
                 [compojure "1.3.1"]])
