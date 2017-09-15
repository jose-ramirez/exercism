(defproject triangle "0.1.0-SNAPSHOT"
  :description "triangle exercise."
  :url "https://github.com/exercism/xclojure/tree/master/exercises/triangle"
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :profiles {
    :dev{
        :dependencies [[midje "1.8.3"]]
        :plugins [[lein-midje "3.2"]]
    }})
