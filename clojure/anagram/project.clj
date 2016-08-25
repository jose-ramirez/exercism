(defproject anagram "0.1.0-SNAPSHOT"
  :description "anagram exercise."
  :url "https://github.com/exercism/xclojure/tree/master/exercises/anagram"
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :profiles
  {:dev 
  	{:dependencies [[midje "1.8.3"]]
  	 :plugins [[lein-midje "3.2"]]}})
