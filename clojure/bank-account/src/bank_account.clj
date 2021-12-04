(ns bank-account)

(defn open-account [] ;; <- arglist goes here
  (atom 0)
)

(defn close-account [account] ;; <- arglist goes here
  (reset! account nil)
)

(defn get-balance [account] ;; <- arglist goes here
  (deref account))

(defn update-balance [account value] ;; <- arglist goes here
  (reset! account (+ (deref account) value))
)
