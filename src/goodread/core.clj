(ns goodread.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

;needs create user fun
;create catagory
;add book
;create list
;

(def data-base
  {:nameHere {:allBooks ["harry potter" "twilight" "hunger games" "hunger games 2" "hunger games 3"]}
             :horror ["hunger games" "hunger games 2" "hunger games 3"]
             :love ["twilight"]
             :count 3})




(def clean-data-base {})

(defn create-user
  [name]
  (hash-map (keyword name) (hash-map :allBooks [])))

(defn add-book
  [data user book]
  (update-in data [user] book))


(update-in data-base [:nameHere :allBooks] conj "worked")



(defn create-catagory
  [data user catagory]
  (update-in data [user] "fuck"))

(defn get-input
  []
  (read-line))

(defn main
  [data]
  (loop [data-base data
         name-of-event ""]
    (println "Enter date, format yyyy-mm-dd, followed by the name of Event")
    (if (or (= date-to-change "e") (= name-of-event "e"))
     (println (generate-string data {:pretty true}))
     (recur (update-calendar calendar date-to-change name-of-event) (get-input)))))


(defn -main
   "I don't do a whole lot ... yet."
   [& args]
   (main))
