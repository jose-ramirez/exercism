(defproject meetup "0.1.0-SNAPSHOT"
  :description "meetup exercise."
  :url "https://github.com/exercism/xclojure/tree/master/exercises/meetup"
  :dependencies [
    [org.clojure/clojure "1.8.0"]
    [clj-time "0.12.0"]
  ]
  :profiles {
    :dev {
        :plugins [[lein-midje "3.2"]]
        :dependencies [[midje "1.8.3"]]
    }
  })
