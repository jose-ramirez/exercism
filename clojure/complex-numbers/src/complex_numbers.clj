(ns complex-numbers
    (:require [clojure.math.numeric-tower :as math]))

(defn real [[a b]] a)

(defn imaginary [[a b]] b)

(defn abs [[a_ b_]]
    (let [a (float a_) b (float b_)]
        (math/sqrt (+ (* a a) (* b b)))))

(defn conjugate [[a b]] [a (* -1 b)])

(defn add [[a b] [c d]] [(+ a c) (+ b d)])

(defn sub [[a b] [c d]] [(- a c) (- b d)])

(defn mul [[a b] [c d]]
    [(- (* a c) (* b d)) (+ (* a d) (* b c))])

(defn div [[a b] [c d]]
    (let [
        x [a b]
        y [c d]
        m (/ 1 (abs y))
        z [(* m m) 0]
        [r s] (mul (mul x (conjugate y)) z)]
    [(float r) (float s)]))
