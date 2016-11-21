(ns flatten-array)

(defn flatten [lst] (filter some? (clojure.core/flatten lst)))
