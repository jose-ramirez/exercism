(ns grains
  (:require [clojure.math.numeric-tower :as math]))

(defn square [s] (math/expt 2 (dec s)))

(defn total [] (dec (math/expt 2 64)))
