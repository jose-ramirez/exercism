(ns etl)

(require '[clojure.string :as s])

(defn swapper [key values]
  (reduce #(merge %1 {(s/lower-case %2) key}) {} values))

(defn transform [dict]
  (reduce (fn [m1 [k1 v1]] (merge m1 (swapper k1 v1))) {} dict))
