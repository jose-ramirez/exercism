(ns triangle)

(defn triangle? [x y z] (and (< z (+ x y)) (< x (+ y z)) (< y (+ x z))))

(defn type [a b c]
    (let [
        s (sort [a b c])
        x (first s)
        y (second s)
        z (last s)
        t (apply triangle? s)]
        (cond
            (and t (= x y) (= y z)) :equilateral
            (and t (or (and (= x y) (not= y z)) (and (= y z) (not= x y)))) :isosceles
            (and t (< x y) (< y z)) :scalene
            :else :illogical
        )
    )
)

