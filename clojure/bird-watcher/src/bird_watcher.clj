(ns bird-watcher)

(def last-week [0 2 5 3 7 8 4])

(defn today [birds] (last birds))

(defn inc-bird [birds]
  (let [len (count birds) last-count (last birds)]
    (assoc birds (dec len) (inc last-count))))

(defn day-without-birds? [birds]
  (let [res (some #(= 0 %) birds)]
    (cond (= res nil) false :else true)))

(defn n-days-count [birds n]
  (cond
    (> n (count birds)) (reduce + birds)
    :else (reduce + (subvec birds 0 n))))

(defn busy-days [birds]
  (count (filter #(>= % 5) birds)))

(defn odd-week? [birds]
  (cond (= (compare birds [1 0 1 0 1 0 1]) 0) true :else false))
