(ns hexadecimal)
(require '[clojure.string :as str])

(def hex-values {"0" 0 "1" 1 "2" 2 "3" 3 "4" 4 "5" 5 "6" 6 "7" 7 "8" 8 "9" 9 "a" 10 "b" 11 "c" 12 "d" 13 "e" 14 "f" 15})

(defn in?
  "true if coll contains elm"
  [coll elm]
  (some #(= elm %) coll))

(defn reverse-hex [hex-string]
  (if (= (count hex-string) 1)
    (get hex-values hex-string)
    (let [s1 (subs hex-string 0 1) s2 (subs hex-string 1)]
      (+ (get hex-values s1) (* 16 (reverse-hex s2))))))

(defn hex-to-int [hex-string] ;; <- arglist goes here
  (if (some #(not (in? (keys hex-values) %)) (str/split hex-string #""))
    0
    (reverse-hex (apply str (reverse hex-string)))))
