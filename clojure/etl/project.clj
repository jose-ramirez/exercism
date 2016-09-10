(defproject etl "0.1.0-SNAPSHOT"
  :description "etl exercise."
  :url "https://github.com/exercism/xclojure/tree/master/exercises/etl"
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :profiles {
    :dev{
      :plugins [[lein-midje "3.2"]]
      :dependencies [[midje "1.8.3"]]
    }
  })
