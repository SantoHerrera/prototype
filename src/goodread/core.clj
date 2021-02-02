(ns goodread.core
  (:gen-class)
  (:require [cheshire.core :refer :all]))

; (ns my.ns
;   (:require [cheshire.core :refer :all]))

; (ns cp
;   (:require [lanterna]))
;

;needs create user fun
;create catagory
;add book
;create list
;

(def data-base
  {:nameHere {:allBooks ["harry potter" "twilight" "hunger games" "hunger games 2" "hunger games 3"]
              :horror ["hunger games" "hunger games 2" "hunger games 3"]
              :love ["twilight"]
              :count 3}})

(def empty-data-base {})

(def available-functions ["create-user" "create-catagory" "add-book-to-catagory" "delete-book" "delete-user" "get-user" "get-user-catagory"])


(defn create-user
  [name]
  (hash-map (keyword name) (hash-map :allBooks [])))

(defn create-catagory
  [data user catagory]
  (update-in data [(keyword user)] #(conj % (hash-map (keyword catagory) []))))


(defn add-book-to-catagory
  [data user catagory book]
  (update-in data [(keyword user) (keyword catagory)] conj book))





(defn call
  [this]
  (resolve (symbol this)))




(defn print-list
  [data user catagory]
  (run! println (get-in data [(keyword user)  (keyword catagory)])))


(defn get-input
  []
  (read-line))


(defn does-user-exist?
  "if user exist returns user, if not keep asking for a valid user"
  [data user?]
  (loop [user user?]
    (println "please enter a valid user")
    (if (not (nil? ((keyword user) data)))
      user
      (recur (read-line)))))

(defn does-catagory-exist?
  [data user catagory?]
  (loop [catagory catagory?]
    (println "please enter a valid catagory")
    (if (not (nil? ((keyword catagory) ((keyword user) data))))
      catagory
      (recur (read-line)))))

(defn get-input
  []
  (read-line))

(defn does-function-exists
  "true if coll contains elm"
  [coll elm]
  (some #(= elm %) coll))

(defn print-array
  [arr]
  (run! println arr))

(defn mainV2
  [data]
  (loop [data-base data
         input ""]
    (print-array available-functions)
    (println "what would you like to do? - make sure of no spelling errors")
    (when (does-function-exists available-functions input) (println "calls function"))
    (if (= input "e")
     (println (generate-string data {:pretty true}))
     (recur data (get-input)))))




(defn -main
   "I don't do a whole lot ... yet."
   [& args]
   (main))
