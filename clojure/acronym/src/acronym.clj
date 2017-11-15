(ns acronym)
(use '[clojure.string :as s])

(defn map2 [l f] (map f l))
(defn join2 [l s] (s/join s l))

(defn acronym [phrase]
    (-> phrase
        (s/replace #"-" " ")
        (s/replace #"HyperText" "Hyper Text")
        (s/split #" ")
        (map2 #(str (first %)))
        (join2 "")
        (s/upper-case)
    )
)