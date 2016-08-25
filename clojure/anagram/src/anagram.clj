(ns anagram)

(require '[clojure.string :as string])

;;return what will be our key for the hashmap:
(defn sort-chars [word]
  (string/join "" (sort word)))

;;Returns a hash key from a string.
(defn word2key [word] (keyword (sort-chars (string/lower-case word))))

(defn hash-element [word]
  {(word2key word) [word]})

(defn append [word s] (conj s word))

(defn add-to-hash [hash_ word]
  (let [mykey (word2key word)]
    (if (contains? hash_ mykey)
      (update-in hash_ [mykey] (partial append word))
      (conj hash_ (hash-element word)))))

;;create hash map
;;sort each word, forcing case
;;if it exists as key, add the word to its value (in this case, a list)
;; if not, create a key with an empty list
(defn create-dict [words] (reduce add-to-hash {} words))

;;to check if the anagram list only has the same word I'm looking for.
(defn has-own-anagram [word array]
  (and
    (= (count array) 1)
    (= word (nth array 0))))

;;true if y and lowercased x are different:
(defn unequals [x y] (not (= y (string/lower-case x))))

;;our main list
(defn anagrams-for [word string-coll]
  (let [
    new-string-coll (filter (partial unequals word) string-coll)
    ;;anagram dictionary
    anagram-dict (create-dict new-string-coll)
    ;;key for possible anagrams
    key_ (word2key word)
    ;;do we have any anagrams for this word?
    possible-anagrams (key_ anagram-dict)]
    (if
      (and
        (not (empty? possible-anagrams))
        (not (has-own-anagram word possible-anagrams)))
      possible-anagrams
      [])))
