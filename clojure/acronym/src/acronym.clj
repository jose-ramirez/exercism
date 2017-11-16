(ns acronym)
(use '[clojure.string :as s])

(defn acronym [phrase]
    (->> (-> phrase
        (s/replace #"-" " ")
        (s/replace #"HyperText" "Hyper Text")
        (s/split #" "))
        (map #(str (first %)))
        (s/join "")
        (s/upper-case)))