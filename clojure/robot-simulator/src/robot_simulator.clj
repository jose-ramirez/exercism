(ns robot-simulator)

(defn robot [coordinates bearing] ;; <- arglist goes here
  {:coordinates coordinates :bearing bearing})

(defn turn-right [bearing] ;; <- arglist goes here
  (cond (= :north bearing) :east
        (= :south bearing) :west
        (= :east bearing) :south
        :else :north)
)

(defn turn-left [bearing] ;; <- arglist goes here;; your code goes here
  (cond (= :north bearing) :west
        (= :south bearing) :east
        (= :east bearing) :north
        :else :south))

(defn move [r bearing]
  (let [x (:x (:coordinates r)) y (:y (:coordinates r))]
    (cond (= :north bearing) {:x x :y (inc y)}
          (= :east bearing) {:x (inc x) :y y}
          (= :west bearing) {:x (dec x) :y y}
          (= :south bearing) {:x x :y (dec y)}))
  )

(defn simulation-step [r instruction]
  (let [c (:coordinates r) b (:bearing r)]
    (cond (= \L instruction) (robot c (turn-left b)) 
          (= \R instruction) (robot c (turn-right b))
          (= \A instruction) (robot (move r b) b))))

(defn simulate [directions r] ;; <- arglist goes here
  (reduce simulation-step r directions))
