(ns hamming)

(defn distance [c1 c2]
  (if (not (= (count c1) (count c2)))
    nil
    (reduce + (map
      #(if (= (nth % 0) (nth % 1)) 0 1)
      (map vector (char-array c1) (char-array c2))))
  ))
