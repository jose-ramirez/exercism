(ns grade-school)

;Applies f to each value of m, returning the resulting map.
(defn- map-values [f m]
  (into {} (for [[k v] m] [k (f v)])))

;Adds a student to the database, joining the names into a
;vector when they're at the same grade.
(defn add [students-db name grade]
  (-> students-db
    ((partial merge-with into) {grade [name]})))

;Returns all students at the specified grade.
(defn grade [students-db grade]
  (get students-db grade []))

;Sorts the students in the database by grade, then by name.
(defn sorted [students-db]
  (map-values sort (into (sorted-map) students-db)))
