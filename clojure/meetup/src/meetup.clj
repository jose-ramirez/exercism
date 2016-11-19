(ns meetup)

(defn days-this-month-has [month year]
  (cond
    (= month 1) 31
    (and (= month 2) (not (leap-year? year))) 28
    (and (= month 2) (leap-year? year)) 29
    (= month 3) 31
    (= month 4) 30
    (= month 5) 31
    (= month 6) 30
    (= month 7) 31
    (= month 8) 31
    (= month 9) 30
    (= month 10) 31
    (= month 11) 30
    (= month 12) 31
    :else -1
  ))

(def month-map {
  :1 0
  :2 3
  :3 3
  :4 6
  :5 1
  :6 4
  :7 6
  :8 2
  :9 5
  :10 0
  :11 3
  :12 5
  })

(def day-map
  {:0 :sunday
 :1 :monday
 :2 :tuesday
 :3 :wednesday
 :4 :thursday
 :5 :friday
 :6 :saturday})

(defn leap-year? [year]
 (and
   (= 0 (mod year 4))
   (or (not= 0 (mod year 100)) (= 0 (mod year 400)))))

(defn year-code [year]
 (let [yy (mod year 100) yyd4 (quot yy 4)]
   (mod (+ yy yyd4) 7)))

(defn month-code [month]
  (month-map (keyword (str month))))

(defn century-code [year]
  (cond
    (and (<= 1900 year) (< year 2000)) 0
    (and (<= 2000 year) (< year 2100)) 6))

(defn leap-year-code [year]
  (if (leap-year? year) 1 0))

(defn day-keyword [day]
  (day-map (keyword (str day))))

(defn day-array [day month year]
  {(day-keyword (day-of-week day month year))
    (filter
      #(= (mod % 7) day)
      (range 1 (inc (days-this-month-has month year))))})

(defn day-arrays [month year]
    (apply merge (map #(day-array % month year) (range 0 7)))
)

(defn day-of-week [day month year]
  (let [
    yc (year-code year)
    mc (month-code month)
    cc (century-code year)
    lyc (leap-year-code year)]
    (mod (- (+ yc mc cc day) lyc) 7)
    ))

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
