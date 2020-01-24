;; common definitions with public and private sidonie admin clojure application


;; db global definition for database info and web server authentification
(let [
      db-host "localhost"
      db-port 3306
      db-name "sidonie"
      ]
  
  (def db {
           :classname "com.mysql.jdbc.Driver" ; must be in classpath
           :subprotocol "mysql"
           :subname (str "//" db-host ":" db-port "/" db-name)
					; Any additional keys are passed to the driver
					; as driver-specific properties.
           ;;:user "mattei"
           :user "sidonie"
           ;;:password "sidonie2"
           :password "$1dOni3"
           }))


;;(def user-remote-browser (atom nil)) ;; will be user of remote browser
(def user-remote-browser "anonymous")


(defn create-html-body-red-centered [string-to-display]
  [:body
   [:p {:align "center"}
    [:br]
    [:br]
    [:br]
    [:br]
    [:br]
    [:br]
    [:br]
    [:br]
    [:font {:color "#ff0000"}
     [:font {:style "font-size: 24pt", :size "6"} string-to-display]]
    [:br]
    [:br]
    [:br]
    [:br]
    [:br]
    [:br]

    
    ;;[:a {:href "../adminDB/interface_nom.html"} "Retour vers la page de mise à jour."]

    ;;[:a {:href "http://localhost:8080/Sidonie/adminDB/interface_nom.html"} "Retour vers la page de mise à jour."]
    
    [:a {:href "https://sidonie.oca.eu/Sidonie/adminDB/interface_nom.html"} "Retour vers la page de mise à jour."]
    
    [:br]
    [:br]]])


;; eu.oca.jclojure=> (infix 3 + 5 * 8)
;; 43
;; eu.oca.jclojure=> (infix '(3 + 5 * 8))
;; (+ 3 (* 5 8))
;; eu.oca.jclojure=> (eval (infix '(3 + 5 * 8)))
;; 43
;; eu.oca.jclojure=> (def x 2)
;; #'eu.oca.jclojure/x
;; eu.oca.jclojure=> (infix x + 5 * 8)
;; 42
;; eu.oca.jclojure=> (infix '(x + 5 * 8))
;; (+ x (* 5 8))
;; eu.oca.jclojure=> (eval (infix '(x + 5 * 8)))
;; 42


;; right ascension
;;
;; eu.oca.jclojure=> (hh-mmDOTm2hhmmm 18 57.5)
;; 18575.0

(defn hh-mmDOTm2hhmmm [hh mmDOTm]

  (print "jclojure.clj :  hh-mmDOTm2hhmmm  : mmDOTm = ")
  (println mmDOTm)
  (print "jclojure.clj :  hh-mmDOTm2hhmmm  : (type mmDOTm) = ")
  (println (type mmDOTm))
  (print "jclojure.clj :  hh-mmDOTm2hhmmm  : hh = ")
  (println hh)
  (print "jclojure.clj :  hh-mmDOTm2hhmmm  : (type hh) = ")
  (println (type hh))
  
  (let [hhmmm  (infix

                hh * 1000 + mmDOTm * 10.0
                
                )

        hh1000 (* hh 1000)
        mmDOTm10 (* mmDOTm 10.0)
        pre-hhmmm (+ hh1000 mmDOTm10)
        ]
    (print "jclojure.clj :  hh-mmDOTm2hhmmm  : hh1000 = ")
    (println hh1000)
    (print "jclojure.clj :  hh-mmDOTm2hhmmm  : mmDOTm10 = ")
    (println mmDOTm10)
    (print "jclojure.clj :  hh-mmDOTm2hhmmm  : pre-hhmmm = ")
    (println pre-hhmmm)
    (print "jclojure.clj :  hh-mmDOTm2hhmmm  : hhmmm = ")
    (println hhmmm)
    hhmmm))


(defn signum [n]
  (if (< n 0)
    -1
    1))



;; declinaison

(defn dd-mm2ddmm [dd mm]

  (let [ddmm
        ;; (infix

        ;;  dd * 100.0 + mm
               
        ;;  )

        (+ (* dd 100.0) (* (signum dd) mm))
         
         ]
     
     (print "jclojure.clj : dd-mm2ddmm   : ddmm = ")
     (println ddmm)
     ddmm))





(defn =1?  [n]  (= 1 n))

;; MariaDB [sidonie]> describe Coordonnées;
;; +----------------+-------------+------+-----+---------+-------+
;; | Field          | Type        | Null | Key | Default | Extra |
;; +----------------+-------------+------+-----+---------+-------+
;; | N° Fiche       | int(11)     | NO   | PRI | 0       |       |
;; | Alpha 2000     | double      | YES  |     | NULL    |       |
;; | Delta 2000     | double      | YES  |     | NULL    |       |
;; | N° ADS         | varchar(50) | YES  |     | NULL    |       |
;; | NomSidonie     | varchar(50) | YES  |     | NULL    |       |
;; | mag1           | varchar(50) | YES  |     | NULL    |       |
;; | mag2           | varchar(50) | YES  |     | NULL    |       |
;; | N° BD          | varchar(50) | YES  |     | NULL    |       |
;; | Spectre        | varchar(50) | YES  |     | NULL    |       |
;; | N°Type         | float       | YES  |     | NULL    |       |
;; | N° HIP         | varchar(50) | YES  |     | NULL    |       |
;; | Orb            | varchar(50) | YES  |     | NULL    |       |
;; | Modif          | datetime    | YES  |     | NULL    |       |
;; | Date de saisie | datetime    | YES  |     | NULL    |       |
;; | Nom opérateur  | varchar(50) | YES  |     | NULL    |       |
;; | Nom            | varchar(50) | YES  |     | NULL    |       |
;; +----------------+-------------+------+-----+---------+-------+


(defn updateObject
  "Update the table Coordonnées given No_Fiche and other values in parameters, return the number of update objects, 1 or 0 if error."
  [ Nom No_Fiche Alpha_2000 Delta_2000 No_BD No_ADS No_HIP Spectre mag1 mag2 Orb NoType]
  
  (println "jclojure.clj : updateObject : updating Coordonnées...")

  (first
   (jdbc/update! db :Coordonnées
                 ;; verifier la casse des keywords
                 {
                  :Nom Nom
                  ;; when there is a space in column name of table i must use a call to keyword function
                  (keyword "Alpha 2000") Alpha_2000 ;; attention au typage !
                  (keyword "Delta 2000") Delta_2000
                  (keyword "N° BD") No_BD
                  (keyword "N° ADS") No_ADS
                  (keyword "N° HIP") No_HIP
                  :Spectre Spectre
                  :mag1 mag1
                  :mag2 mag2
                  :Orb Orb
                  :N°Type NoType
                  }
                 ;; verifier l'ordre des item suivant:
                 ["`N° Fiche` = ?" No_Fiche]
                 {:entities (jdbc/quoted \`)} ; or (jdbc/quoted :mysql)
                 ) ;; Update
   ) ;; first
 
  )






(defn string-set-lower-case-ending
  " a function upcasing the first x characters of a string"
  [ s x ]
  (if (>= x (count s))
      (clojure.string/upper-case str)
      (str (clojure.string/upper-case (subs str 0 x))
           (subs str x))))



(defn UpdateDBResourceClojure

  "A function that will launch object database update."

  ;;[ Nom No_Fiche Alpha_2000_hh Alpha_2000_mmDOTm Delta_2000_dd Delta_2000_mm No_BD No_ADS No_HIP Spectre mag1 mag2 Orb NoType adminCode confirm]
  [ Nom No_Fiche Alpha_2000_hh Alpha_2000_mmDOTm Delta_2000_dd Delta_2000_mm No_BD No_ADS No_HIP Spectre mag1 mag2 Orb NoType confirm]

  (print "sidonie-common.clj : UpdateDBResourceClojure   : (type Alpha_2000_hh) =")
  (println (type Alpha_2000_hh))
  
  (when (nil? No_Fiche)
    (println "sidonie-common.clj : UpdateDBResourceClojure   : ERROR : SEVERE : No_Fiche is NULL"))

  (print "sidonie-common.clj : UpdateDBResourceClojure : ")
  (println (time/now))

  (print "sidonie-common.clj : UpdateDBResourceClojure : user-remote-browser = ")
  (println user-remote-browser)
  

  ;;(try
    
    (let [

          Alpha_2000  (hh-mmDOTm2hhmmm
                       ;;(Float/parseFloat  Alpha_2000_hh)
                       (Double/parseDouble  Alpha_2000_hh)
                       (Double/parseDouble  Alpha_2000_mmDOTm))
          
          Delta_2000  (dd-mm2ddmm   (Double/parseDouble  Delta_2000_dd)
                                    (Double/parseDouble  Delta_2000_mm))

          NomUpperCaseFirst7Char (string-set-lower-case-ending Nom 7)

          string-to-display (cond
                              
                              (clojure.string/blank? confirm) "!!! OPERATION ANNULLEE, vous n'avez pas coché la case confirmation, pour recommencer sans perdre les données tapées cliquez sur 'retour' dans le navigateur. !!!"
                              
                              ;;(clojure.string/blank? adminCode) "!!! OPERATION ANNULLEE, vous n'avez pas entré de mot de passe, pour recommencer sans perdre les données tapées cliquez sur 'retour' dans le navigateur. !!!"
                              
                              
                              ;;(not (= adminCode "Stell@r7"))  "!!! OPERATION ANNULLEE, MAUVAIS MOT DE PASSE, pour recommencer sans perdre les données tapées cliquez sur 'retour' dans le navigateur. !!!"
                              
                              (=1?

                               (let [NoTypeFloat  (Float/parseFloat NoType)
                                     No_FicheInteger (Integer/parseInt No_Fiche)]

                                 (print "sidonie-common.clj : UpdateDBResourceClojure   : NoTypeFloat =")
                                 (println NoTypeFloat)

                                 (print "sidonie-common.clj : UpdateDBResourceClojure   : (type NoTypeFloat) =")
                                 (println (type NoTypeFloat))

                                 (print "sidonie-common.clj : UpdateDBResourceClojure   : No_FicheInteger =")
                                 (println No_FicheInteger)

                                 (print "sidonie-common.clj : UpdateDBResourceClojure   : (type No_FicheInteger) =")
                                 (println (type No_FicheInteger))
                                 
                                 ;; return the number of updated records in the database
                                 (updateObject NomUpperCaseFirst7Char
                                               No_FicheInteger
                                               Alpha_2000
                                               Delta_2000
                                               No_BD No_ADS No_HIP Spectre mag1 mag2 Orb
                                               NoTypeFloat))) ;; end =1?

                              "!!! Mise à jour de l&#39;objet dans la BDD Sidonie effectuée !!!"

                              
                              :else "!!! ERREUR d'écriture dans la BDD !!!") ;; end COND
          
          body-MAJ (create-html-body-red-centered string-to-display)
          
          ] ;; close LET definitions

      (print "sidonie-common.clj : UpdateDBResourceClojure")

      ;; generate the HTML 5 page
      (html5 {:lang "en"} [:head [:meta {:charset "UTF-8"}]] [:body body-MAJ])))

    ;; (catch Exception e (html5 {:lang "en"}
    ;;                           [:head [:meta {:charset "UTF-8"}]]
    ;;                           [:body (str "sidonie-common.clj : UpdateDBResourceClojure : An exception has occured " (with-out-str (clojure.stacktrace/print-stack-trace e)))]))))




(defn WrapperUpdateDBResourceClojure
  
  "A function that could be call from the internet by POST method and will launch object database update."

  [ params ]
  
  (print "sidonie-common.clj : WrapperUpdateDBResourceClojure  : params =")
  (println params)

  (print "sidonie-common.clj : WrapperUpdateDBResourceClojure  : (params :Nom) =")
  
  (println (params :Nom))
  
 
  (UpdateDBResourceClojure (params :Nom)
                           (params :No_Fiche)
                           (params :Alpha_2000_hh)
                           (params :Alpha_2000_mmDOTm)
                           (params :Delta_2000_dd)
                           (params :Delta_2000_mm)
                           (params :No_BD)
                           (params :No_ADS)
                           (params :No_HIP)
                           (params :Spectre)
                           (params :mag1)
                           (params :mag2)
                           (params :Orb)
                           (params :NoType)
                           ;;(params :adminCode)
                           (params :confirm)))

