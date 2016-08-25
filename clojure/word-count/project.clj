(defproject word-count "0.1.0-SNAPSHOT"
  :description "word-count exercise."
  :url "https://github.com/exercism/xclojure/tree/master/exercises/word-count"
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :profiles
  	{:dev 
  		{:dependencies [[midje "1.8.3"]]
  			:plugins [[lein-midje "3.2"]]}})
