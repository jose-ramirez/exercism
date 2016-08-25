(ns rna-transcription)

;;Necessary to get the join function:
(require '[clojure.string :as string])

(def codes {"C" "G", "G" "C", "A" "U", "T" "A"})

;; assert function throws AssertionError if
;; the value it receives is nil.
(defn transcribe [s]  
  (if (= nil (codes s))
      (assert (codes s))
      (codes s)))

(defn to-rna [dna]
  (string/join (map transcribe (map str (char-array dna)))))