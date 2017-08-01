(defproject grains "0.1.0-SNAPSHOT"
  :description "grains exercise."
  :url "https://github.com/exercism/xclojure/tree/master/exercises/grains"
  :dependencies [
    [org.clojure/clojure "1.8.0"]
    [org.clojure/math.numeric-tower "0.0.4"]]
  :plugins [[lein-midje "3.2"]]
  :profiles {
    :dev {:dependencies [[midje "1.8.3"]]}
  })