(ns robot-name)

(defn rand-char [] (char (+ (rand-int 26) 65)))

(defn rand-digit [] (rand-int 10))

(defn factory-name [s]
  (str
    (str (rand-char))
    (str (rand-char))
    (str (rand-digit))
    (str (rand-digit))
    (str (rand-digit))
  ))

(defn robot-name [r] (:name @r))

(defn robot [] (ref {:name (factory-name "")}))

(defn reset-name [r]
  (dosync (alter r update-in [:name] factory-name)))