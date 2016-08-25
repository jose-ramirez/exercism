(ns grade-school)

;Applies f to each value of m, returning the resulting map.
(defn f-on-vals [f m]
  (into {} (for [[k v] m] [k (f v)])))

;Adds a student to the database, joining the names into a
;vector when they're at the same grade.
(defn add [students_db name grade]
  (-> students_db
    ((partial merge-with into) {grade [name]})))

;Returns all students at the specified grade.
(defn grade [students_db grade]
  (let [students (get students_db grade)]
  (if (nil? students) [] students)))

;Sorts the students in the database by grade, then by name.
(defn sorted [students_db]
  (f-on-vals sort (into (sorted-map) students_db)))