(ns binary-search)

(defn middle [elements]
  (let [len (count elements)] (quot len 2)))

(defn search-for [val elements]
  (let [ans (java.util.Collections/binarySearch elements val)]
    (if (>= ans 0)
      ans
      (throw (Throwable. (format "Number not found: %d" val))))))
