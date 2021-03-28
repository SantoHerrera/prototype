(ns goodread.view
  (:require [hiccup.page :as page])
  (:gen-class))

(defn home-page
  []
  (page/html5
    (gen-page-head "Home")
    header-links
    [:h1 "test 1. home page"]
    [:p "fuck"]))

(defn home-page2
  []
  (page/html5
   [:h1 "Home"]
   [:p "fuck"]))

(defn login-page
  []
  (page/html5
    [:h1 "Login"]
    [:form
      [:input {:type "text", :id "email", :value "email"}]
      [:br]
      [:input {:type "text" :id "password" :value "password"}]
      [:br]
      [:button {:type "submit"} "Submit"]]))


(defn register-account-page
  []
  (page/html5
    [:h1 "Register Account"]
    [:form
      [:input {:type "text", :id "email", :value "email"}]
      [:br]
      [:input {:type "text" :id "password" :value "password"}]
      [:br]
      [:button {:type "submit"} "Submit"]]))

; (defn display-user 
;   []
;   ())
