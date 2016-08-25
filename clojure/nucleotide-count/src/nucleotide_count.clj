(ns nucleotide-count)

(require '[clojure.set :as set])
(require '[clojure.string :as string])

(defn count [nucleotide chain]
	(if (and (= (string/index-of chain nucleotide) nil) (not (string/blank? chain)))
		(throw (Throwable. "error"))
		(clojure.core/count (filter #{nucleotide} chain)))))

(defn nucleotide-counts [chain]
  (let [
    first-count (frequencies (char-array chain))
    missing-nucleotides (set/difference #{\A \T \G \C} (set (keys first-count)))]
    (conj first-count (reduce #(conj %1 {%2 0}) {} missing-nucleotides))))