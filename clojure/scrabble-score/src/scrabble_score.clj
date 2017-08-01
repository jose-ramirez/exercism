(ns scrabble-score)
(use '[clojure.string :only (upper-case)])

(def letters {:W 4 :D 2 :X 8 :H 4 :N 1 :M 3 :U 1 :I 1 :J 8 :Q 10 :G 2 :L 1 :C 3 :K 5 :O 1 :R 1 :B 3 :S 1 :A 1 :P 3 :Z 10 :E 1 :F 4 :V 4 :T 1 :Y 4})

(defn get-value [s] ((keyword (upper-case s)) letters))

(defn score-letter [letter] (get-value letter))

(defn score-word [word] (apply + (map get-value word)))