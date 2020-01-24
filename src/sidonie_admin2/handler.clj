;; this is the file program for the private part of Sidonie admin web interface


;; compile and create war :
;; lein ring uberwar

;; mv sidonie-admin2-0.1.0-SNAPSHOT-standalone.war sidonie-admin.war

(ns sidonie-admin2.handler

  (:use compojure.core)
  
  (:require
   [clojure.java.jdbc :as jdbc]
   [clojure.string]
   [infix.macros :refer [infix]]
   ;;[compojure.core :refer :all]
   [compojure.handler :as handler]
   [compojure.route :as route]
   [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
   [ring.middleware.basic-authentication :refer :all]
   [clj-time.core :as time]
   )

  ;; warning: needs to do : lein deps
  ;; to get ring.middleware.basic-authentication

  (:use [hiccup.core] ;; core,form not needed
        [hiccup.page]
        [hiccup.form]))





;;(load-file "src/sidonie_admin2/sidonie-common.clj")
(load "sidonie-common")

;; nom utilisateur et mot de passe perso
;; log des connexion
(defn authenticated? [name pass]
  (print "handler.clj : authenticated? : name = ")
  (println name)
  
  (when (or (and (= name "bonneau")
                 (= pass "b0nne@u71"))
            
            (and (= name "thorel")
                 (= pass "th0rel70"))
            
            (and (= name "mattei")
                 (= pass "m@ttei68")))

    ;;(set! user-remote-browser name)
    ;;(defn user-remote-browser name)
    (alter-var-root #'user-remote-browser (constantly name))
    
    (println (str "handler.clj : authenticated? : authenticated user with good password: " name))
    true))

;;(defroutes protected-routes
  
(defroutes public-routes
  (GET "/" [] "You are on the site of the Sidonie Database modification.You will need authentification access to modify data.")
 ;; (POST "/test" {params :params} 
 ;;       (str "POST params=" params))
  
  )

(defroutes protected-routes
  ;;(GET "/index.html" [] "Hello World")
  (POST "/UpdateDB" {params :params} 
        (WrapperUpdateDBResourceClojure params))
  )


(defroutes app-routes
  public-routes
  (wrap-basic-authentication protected-routes authenticated?)
  (route/not-found "Not Found"))

(def app
  ;;(wrap-defaults app-routes site-defaults)
  ;;(wrap-basic-authentication app-routes authenticated?)
  (handler/site app-routes))
