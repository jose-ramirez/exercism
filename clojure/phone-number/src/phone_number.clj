(ns phone-number)

(require '[clojure.string :as s])

(defn filter-number [number_string]
  (apply str (filter #(Character/isDigit %) number_string)))

(defn beautify [n]
  (format
    "(%s) %s-%s"
      (subs n 0 3)
      (subs n 3 6)
      (subs n 6 10)))

(defn number [number_string]
  (let
    [wo-signs (filter-number number_string)]
    (cond
      (= 10 (count wo-signs)) wo-signs
      (and (= 11 (count wo-signs)) (= \1 (first wo-signs))) (subs wo-signs 1)
      :else "0000000000")))

(defn area-code [number_string]
  (let
    [wo-signs (filter-number number_string)]
    (cond
      (= 10 (count wo-signs)) (subs wo-signs 0 3)
      (and (= 11 (count wo-signs)) (= \1 (first wo-signs))) (subs wo-signs 1 4))))

(defn pretty-print [number_string]
  (let
    [wo-signs (filter-number number_string)]
    (cond
      (= 10 (count wo-signs)) (beautify wo-signs)
      (and (= 11 (count wo-signs)) (= \1 (first wo-signs))) (beautify (subs wo-signs 1)))))