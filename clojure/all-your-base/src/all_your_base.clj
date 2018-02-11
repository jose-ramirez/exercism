(ns all-your-base)

(defn calc [from_base digits]
  (if (empty? digits) 
    0 
    (reduce #(+ (* from_base %1) %2) digits)
  )
)

(defn get-digits [number to-base]
  (loop [n number l ()]
    (if (< n to-base)
      (conj l n)
      (recur 
        (quot n to-base) 
        (conj l (mod n to-base))
      )
    )
  )
)

(defn convert [from-base digits to-base]
  (let [n (calc from-base digits)]
    (cond 
      (or (< to-base 2) (< from-base 2)) nil
      (empty? digits) ()
      (or (not-every? #(>= % 0) digits) (not-every? #(< % from-base) digits)) nil
      :else (get-digits n to-base)
    )
  )
)
