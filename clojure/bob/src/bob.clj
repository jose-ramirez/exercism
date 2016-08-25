(ns bob)

(defn is_normal_question [question]
  (and (.endsWith question "?")
  (not (= (.toUpperCase question) question))))

(defn is_forceful_question [question]
  (and (.endsWith question "?")
  (= (.toUpperCase question) question)))

(defn is_empty_question [question]
  (or (= question "") (= question "    ")))

(defn is_forceful_talking [phrase]
  (and (.endsWith phrase "!")
  (not (= (.toUpperCase phrase) phrase))))

(defn is_shouting_sans_exclamation [question]
  (and (= (.toUpperCase question) question)
  (not (.endsWith question "!"))))

(defn is_number_question [question]
  (= question "4?"))

(defn is_shouting [question]
  (and (= (.toUpperCase question) question)
  (.endsWith question "!")))

(defn is_1_2_3 [question]
  (= question "1, 2, 3"))

(defn response-for [question]
  (cond

    ;; Is it only numbers? 
    (is_1_2_3 question) "Whatever."

    ;;Number question.
    (is_number_question question) "Sure."

    ;;Normal question.
    (is_normal_question question) "Sure."

    ;;If the question has nothing:
    (is_empty_question question) "Fine. Be that way!"

    ;;If it's a forceful question:
    (is_forceful_question question) "Whoa, chill out!"

    ;;The question that ends in "DMV."
    (.endsWith question "DMV.") "Whatever."

    ;;If it's forceful talking:
    (is_forceful_talking question) "Whatever."

    ;;shouting as is:
    (is_shouting question) "Whoa, chill out!"

    ;;shouting sans exclamation:
    (is_shouting_sans_exclamation question) "Whoa, chill out!"

    ;;If none of the above:    
    :else "Whatever."))