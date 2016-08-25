(ns beer-song)
(require '[clojure.string :as string])

(defn string-verse [n]
  (cond
    (> n 1) (str n " bottles of beer")
    (= n 1) "1 bottle of beer"
    (= n 0) "no more bottles of beer"))

(defn course-of-action [number-of-beers]
  (cond
    (= number-of-beers 0) "Go to the store and buy some more, "
    (= number-of-beers 1) "Take it down and pass it around, "
    :else "Take one down and pass it around, "))

(defn current-state [number-of-beers]
  (str (string/capitalize
    (str (string-verse number-of-beers) " on the wall, "))
    (string-verse number-of-beers)
    ".\n"))

(defn results [number-of-beers]
  (cond
    (= number-of-beers 0) "no more bottles of beer on the wall.\n"
    (= number-of-beers 1) "1 bottle of beer on the wall.\n"
    (> number-of-beers 1) (str number-of-beers " bottles of beer on the wall.\n")
    :else "99 bottles of beer on the wall.\n"))

(defn verse [number]
  (str (current-state number)
       (course-of-action number) (results (dec number))))

(defn sing [start & finish]
  (string/join "\n"
    (for
      [x (range start (if (not (= finish nil)) (dec (nth finish 0)) -1) -1)]
      (verse x))))
