(ns log-levels
  (:require [clojure.string :as str]))

(defn message
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s] (-> (str/split s #": ")
          last
          str/trim))

(defn log-level
  "Takes a string representing a log line
   and returns its level in lower-case."
  [s] (-> (str/split s #": ")
          first str/lower-case
          (str/replace #"\[" "")
          (str/replace #"\]" "")))

(defn reformat
  "Takes a string representing a log line and formats it
   with the message first and the log level in parentheses."
  [s] (let [level (log-level s)
            message (message s)]
        (str message " (" level ")")))
