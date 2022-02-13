(ns collatz-conjecture)

(defn collatz [num]
  (if (<= num 0)
    (throw (IllegalArgumentException. "Number must be > 0"))
    (if (= num 1)
      0
      (if (even? num)
        (inc (collatz (/ num 2)))
        (inc (collatz (inc (* 3 num))))
      )
    )
  )
)
