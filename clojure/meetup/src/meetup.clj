(ns meetup
  (:require [clj-time.core :as t]))

(defn day-arrays [month year]
  (let [
      num-days (t/number-of-days-in-the-month year month)
      first-day (t/day-of-week (t/date-time year month 1))
      day-range (range first-day (+ first-day num-days))
      day-codes (map #(if (= (mod % 7) 0) 7 (mod % 7)) day-range)
      mondays (keep-indexed #(if (= 1 %2) (inc %1) nil) day-codes)
      tuesdays (keep-indexed #(if (= 2 %2) (inc %1) nil) day-codes)
      wednesdays (keep-indexed #(if (= 3 %2) (inc %1) nil) day-codes)
      thursdays (keep-indexed #(if (= 4 %2) (inc %1) nil) day-codes)
      fridays (keep-indexed #(if (= 5 %2) (inc %1) nil) day-codes)
      saturdays (keep-indexed #(if (= 6 %2) (inc %1) nil) day-codes)
      sundays (keep-indexed #(if (= 7 %2) (inc %1) nil) day-codes)
    ]
    {
      :monday mondays
      :tuesday tuesdays
      :wednesday wednesdays
      :thursday thursdays
      :friday fridays
      :saturday saturdays
      :sunday sundays
    }
  )
)

(defn meetup [month year day special]
  (let [d1 (day-arrays month year) d2 (day d1)]
    (cond
      (= :last special) [year month (last d2)]
      (= :fourth special) [year month (nth d2 3)]
      (= :third special) [year month (nth d2 2)]
      (= :second special) [year month (nth d2 1)]
      (= :first special) [year month (nth d2 0)]
      (= :teenth special) [year month (first (filter #(and (< 12 %) (< % 20)) d2))])
  ))
