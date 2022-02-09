(ns interest-is-interesting)

(defn abs [x] (if (> x 0) x (* -1 x)))

(defn interest-rate [balance]
  (cond
    (< balance 0.0M) -3.213
    (< balance 1000.0M) 0.5
    (< balance 5000.0M) 1.621
    :else 2.475))

(defn annual-balance-update [balance]
  (+  balance (* (bigdec (* (interest-rate balance) 0.01)) (abs balance))))

(defn amount-to-donate [balance tax-free-percentage]
  (max 0 (int (* 2 balance tax-free-percentage 0.01M))))
