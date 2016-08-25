(ns hamming)

(defn distance [c1 c2]
  (when (= (count c1) (count c2))
    (reduce +
      (map #(if (= (first %) (second %)) 0 1)
      (map vector c1 c2)))))