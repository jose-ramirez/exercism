(ns word-count)

(require '[clojure.string :as string])

;;deletes a char from a string.
(defn delete [s c] (string/replace s c ""))

;;delets a vector of chars from a string.
(defn delete-list [s] (reduce delete s ["!" "&" "@" "$" "%" "^" "&" ","]))

;;counts how many words are there in a text after preprocessing the text:

;;removing unwanted strings in the text
;;removing chars from strings in the text
;;normalizing case for all remaining strings at this point
(defn word-count [text]
	(frequencies
    (map
      (comp string/lower-case delete-list)
      (remove #{":"} (string/split text #"\s")))))