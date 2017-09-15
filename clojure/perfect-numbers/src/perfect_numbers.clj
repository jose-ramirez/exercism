(ns perfect-numbers)

(defn divisor-sum [n]
  (apply + (filter #(= 0 (mod n %)) (range 1 n))))

(defn classify [n]
  (if (> 0 n)
    (throw (IllegalArgumentException. ""))
    (let [ds (divisor-sum n)]
      (cond
        (> n ds) :deficient
        (< n ds) :abundant
        :else :perfect))))