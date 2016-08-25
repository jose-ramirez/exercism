(ns hello-world)

(require '[clojure.string :as string])

(defn hello
  ([] "Hello, World!")
  ([name] (string/join ["Hello, " name "!"])))
