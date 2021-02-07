(ns goodread.core
  (:gen-class)
  (:require [cheshire.core :refer :all]))

(def data-base
  {:nameHere {:allBooks ["harry potter" "twilight" "hunger games" "hunger games 2" "hunger games 3"]
              :horror ["hunger games" "hunger games 2" "hunger games 3"]
              :love ["twilight"]
              :count 3}
   :secondUser {:allBooks ["book 1" "book 2" "book 3"]
                :horror ["book 1" "book 2"]}})

(def empty-data-base {})

(def available-functions ["create-user" "create-catagory" "add-book-to-catagory" "delete-book-everywhere" "delete-book-in-catagory" "delete-user" "get-user" "get-user-catagory"])

(defn create-user
  [name]
  (hash-map (keyword name) (hash-map :allBooks [])))

(defn create-catagory
  [data user catagory]
  (update-in data [(keyword user)] #(conj % (hash-map (keyword catagory) []))))

(defn add-book-to-catagory
  [data user catagory book]
  (update-in data [(keyword user) (keyword catagory)] conj book))

(defn delete-user
  [data user]
  (dissoc data (keyword user)))

(defn delete-user-catagory
  [data user catagory]
  (update-in data [(keyword user)] #(dissoc % (keyword catagory))))

(defn delete-book-in-catagory
  [data user catagory book]
  (assoc-in data [(keyword user) (keyword catagory)]
    (into [] (remove #{book} (get-in data [(keyword user) (keyword catagory)])))))

(defn get-user
  [data user]
  ((keyword user) data))

(defn get-user-catagory
  [data user catagory]
  ((keyword catagory) ((keyword user) data)))

(defn call
  [this]
  (resolve (symbol this)))

(defn print-list
  [data user catagory]
  (run! println (get-in data [(keyword user)  (keyword catagory)])))

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

(defn what-to-print
  [input]
  (if (does-function-exists available-functions input)
    (println "proceeds to call function")
    (do
      (println "what would you like to do? - make sure of no spelling errors")
      (print-array available-functions)
      (println "please enter a valid function."))))

(defn main
  [data]
  (loop [data-base data
         input ""]
    (what-to-print input)
    (if (= input "e")
     (println (generate-string data {:pretty true}))
     (recur data (get-input)))))

(defn -main
   "I don't do a whole lot ... yet."
   [& args]
   (main))

(defn return-JSON
  [data]
  (generate-string data))





;need delete-book-everywhere
;given book
;get path to location
;ex. "book 1" secondUser
;returns idk some like [[:secondUser :allBooks] [:secondUser :horror]]



















  ; (defn mainV3
  ;   [data]
  ;   (loop [data-base data
  ;          input ""]
  ;     (print-array available-functions)
  ;     (println "what would you like to do? - make sure of no spelling errors")
  ;     (when (does-function-exists available-functions input) (return-JSON (get-user-catagory data-base "nameHere" "horror")))
  ;     (cond
  ;       (= input "e") (println (generate-string data {:pretty true}))
  ;       (= input "get-user") (return-JSON (get-user data-base (read-line)))
  ;       :else (recur data (get-input)))))
