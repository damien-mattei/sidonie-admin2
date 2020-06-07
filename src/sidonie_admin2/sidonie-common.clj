;; common definitions with public and private sidonie admin clojure application


;; db global definition for database info and web server authentification
(let [
      db-host "localhost"
      db-port 3306
      db-name "sidonie"
      host-name (.getCanonicalHostName (java.net.InetAddress/getLocalHost))
      db-user (if (= host-name "moita")
             ""
             "")
      db-password (if (= host-name "moita")
                 ""
                 "")
      ]
  
  (def db {
           :classname "com.mysql.jdbc.Driver" ; must be in classpath
           :subprotocol "mysql"
           :subname (str "//" db-host ":" db-port "/" db-name)
					; Any additional keys are passed to the driver
					; as driver-specific properties.
           :user db-user
           :password db-password
           }))


;;(def user-remote-browser (atom nil)) ;; will be user of remote browser
(def user-remote-browser "anonymous")

(def html-header [:p
                  [:table
                   {:border "0", :style "width: 100%;"}
                   [:tbody
                    [:tr
                     [:td
                      {:style "text-align: left; "}
                      [:a
                       {:href "https://www.oca.eu"}
                       [:img
                        {:src "img/OCAlogoQlarge_WEB_250px.png",
                         :alt "observatoire de la cote d azur logo",
                         :title "observatoire de la cote d azur logo"}]]
                      [:br]]
                     [:td
                      {:style "text-align: right;"}
                      [:a
                       {:href "http://lagrange.oca.eu"}
                       [:img
                        {:width "189",
                         :height "120",
                         :src "img/Logo_Lagrange_transp_800.png",
                         :alt "lagrange logo",
                         :title "lagrange logo"}]]
                      [:br]]]]]
                  [:br]
                  [:br]])
  
  
(def html-footer
  [:p
  [:br]
   [:br]
   [:br]
   [:br]
   [:br]
   [:center
    [:img {:src "img/lisplogo_128.png"}]
    [:br]
    [:br]
    [:br]
    [:br]]
   [:br]
   "\nQuelques technologies utilisées:\n       \n\n\n"
   [:table
    {:border "0", :style "width: 100%;"}
    [:tbody
     [:tr
      [:td
       {:style "text-align: left; "}
       [:a
        {:href "https://lambdaisland.com/episodes/compojure"}
        [:img
         {:height "144",
          :width "256",
          :src "img/compojure_1280x720.jpg"}]]
       [:br]]
      [:td
       {:style "text-align: center; "}
       [:a
        {:href "https://leiningen.org"}
        [:img
         {:height "125",
          :src "img/leiningen.png",
          :alt
          "for automating Clojure projects without setting your hair on fire"}]]
       [:br]]
      [:td
       {:style "text-align: right;"}
       [:a
        {:href "https://lambdaisland.com/episodes/ring-3"}
        [:img {:height "144", :src "img/ring_295x166.jpg"}]]
       [:br]]]]]
   [:br]
   [:br]
   [:table
    {:border "0", :style "width: 100%;"}
    [:tbody
     [:tr
      [:td
       {:style "text-align: left; "}
       [:a
        {:href "https://www.slideshare.net/mishadoff/dsl-in-clojure"}
        [:img {:height "144", :width "256", :src "img/hiccup.jpg"}]]]
      [:td
       {:style "text-align: right;"}
       [:a
        {:href "https://clojure.org"}
        [:img
         {:alt "Clojure",
          :title "Clojure web site",
          :height "58",
          :width "198",
          :src
          "https://sidonie.oca.eu/Sidonie/adminDB/images/Clojure-Logo.png"}]]]]
     " \n         "]]
   [:br]
  [:center [:img {:src "img/lisplogo_128.png"}]]])



(defn create-html [body]
  (html5 {:lang "en"}
         [:head
          [:meta {:charset "UTF-8"}]]
         [:body html-header body html-footer]))


(defn create-html-body-red-centered [string-to-display]
  ;;[:body
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
    [:br]];;])
)


(defn create-html-parag-msg-red-centered [string-to-display]

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

    [:a {:href "https://sidonie.oca.eu/sidonie-admin/interfaces_acces.html"} "Retour vers la page de mise à jour."]
    
    [:br]
    [:br]]
)


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
                 ;; verifier l'ordre des items suivant:
                 ["`N° Fiche` = ?" No_Fiche]
                 {:entities (jdbc/quoted \`)} ; or (jdbc/quoted :mysql)
                 ) ;; Update
   ) ;; first
 
  )





(defn string-set-lower-case-ending
  " a function upcasing the first x characters of a string"
  [ s x ]
  (if (>= x (count s))
      (clojure.string/upper-case s)
      (str (clojure.string/upper-case (subs s 0 x))
           (subs s x))))



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





;; eu.oca.jclojure=> (def rs (readObject "COU 123")) 
;; Reading Coordonnées...
;; #'eu.oca.jclojure/rs
;; eu.oca.jclojure=> (:delta_2000 (despace (first rs)))
;; 2248.0
;; eu.oca.jclojure=> (despace (first rs))
;; {:n°type 57.0, :nom "COU 123", :n°_hip "*", :n°_ads nil, :orb "*", :n°_fiche 5770, :date_de_saisie #inst "1996-03-20T23:00:00.000000000-00:00", :spectre "K0", :delta_2000 2248.0, :mag2 "08.9", :nomsidonie "COU 123", :mag1 "08.6", :nom_opérateur "Andrée", :n°_bd "22.3963", :alpha_2000 20123.0, :modif #inst "2002-07-17T22:00:00.000000000-00:00"}
;; eu.oca.jclojure=> (despace0 (first rs))
;; {:n°type 57.0, :nom "COU 123", :n°_hip "*", :n°_ads nil, :orb "*", :n°_fiche 5770, :date_de_saisie #inst "1996-03-20T23:00:00.000000000-00:00", :spectre "K0", :delta_2000 2248.0, :mag2 "08.9", :nomsidonie "COU 123", :mag1 "08.6", :nom_opérateur "Andrée", :n°_bd "22.3963", :alpha_2000 20123.0, :modif #inst "2002-07-17T22:00:00.000000000-00:00"}


;; remove spaces in accessor names
(defn despace [m] 
  (zipmap (map #(keyword (clojure.string/replace (name %) " " "_"))
               (keys m))
          (vals m)))

(defn despace0 [m] 
  (zipmap (map (fn [x] (keyword
                        (clojure.string/replace (name x)
                                                " "
                                                "_")))
               (keys m))
          (vals m)))

;; eu.oca.jclojure=> (def tst (readObjectNoFiche "COU 123"))
;; sidonie-measures.clj : readObjectNoFiche : Reading Coordonnées...
;; #'eu.oca.jclojure/tst
;; eu.oca.jclojure=> tst
;; 5770

(defn readObjectNoFiche
  "Read the table Coordonnées with Nom as input and return No Fiche if object exist or NIL."
  [name]
  
  (println "sidonie-common.clj : readObjectNoFiche : Reading Coordonnées...")

  (let [
        records (jdbc/query db
                            [(str "SELECT `N° Fiche` FROM Coordonnées WHERE Nom='" name "'")])
        record0 (first records)
        ]
    
    (if (nil? record0)
      record0
      (:n°_fiche (despace record0))))

 
  )


;; eu.oca.jclojure=> (def tst (readObjectNoFiche "COU 123"))
;; sidonie-measures.clj : readObjectNoFiche : Reading Coordonnées...
;; #'eu.oca.jclojure/tst
;; eu.oca.jclojure=> tst
;; 5770

;; eu.oca.jclojure=> (readMeasures tst)
;; sidonie-measures.clj : readMeasure : Reading Mesures...
;; ({:date "1966.74    ", :nota nil, :instrument "l", :angle "245.3   ", :nb nuits 3, :réf "303", :n° fiche 5770, :codeobs "COU  ", :dimension "38", :sépar "00.24    "} {:date "1967.76    ", :nota "", :instrument "l", :angle "243.0   ", :nb nuits 3, :réf "317", :n° fiche 5770, :codeobs "COU  ", :dimension "50", :sépar "00.29    "} {:date "1968.617   ", :nota nil, :instrument "l", :angle "245.7   ", :nb nuits 4, :réf "346", :n° fiche 5770, :codeobs "WOR  ", :dimension "26\"", :sépar "00.23    "} {:date "1969.75    ", :nota "", :instrument "l", :angle "231.8   ", :nb nuits 4, :réf "338", :n° fiche 5770, :codeobs "BAZ  ", :dimension "38", :sépar "00.28    "} {:date "1971.67    ", :nota nil, :instrument "l", :angle "227.7   ", :nb nuits 1, :réf "364", :n° fiche 5770, :codeobs "MLR  ", :dimension "83", :sépar "00.27    "} {:date "1971.79    ", :nota nil, :instrument "l", :angle "239.2   ", :nb nuits 3, :réf "356", :n° fiche 5770, :codeobs "COU  ", :dimension "74", :sépar "00.21    "} {:date "1973.64    ", :nota nil, :instrument "l", :angle "242.0   ", :nb nuits 2, :réf "356", :n° fiche 5770, :codeobs "COU  ", :dimension "74", :sépar "00.27    "} {:date "1978.73    ", :nota "", :instrument "l", :angle "241.4   ", :nb nuits 3, :réf "420", :n° fiche 5770, :codeobs "COU  ", :dimension "50", :sépar "00.26    "} {:date "1981.53    ", :nota nil, :instrument "l", :angle "240.8   ", :nb nuits 1, :réf "456", :n° fiche 5770, :codeobs "MRL  ", :dimension "50", :sépar "00.28    "} {:date "1982.70    ", :nota nil, :instrument "L", :angle "229.3   ", :nb nuits 2, :réf "456", :n° fiche 5770, :codeobs "MRL  ", :dimension "74", :sépar "00.22    "} {:date "1983.7155  ", :nota "interferometrie", :instrument "T", :angle "240.6   ", :nb nuits 1, :réf "491", :n° fiche 5770, :codeobs "CHR  ", :dimension "400", :sépar "00.251   "} {:date "1985.44    ", :nota nil, :instrument "l", :angle "240.1   ", :nb nuits 3, :réf "490", :n° fiche 5770, :codeobs "LBU  ", :dimension "50", :sépar "00.23    "} {:date "1985.4901  ", :nota "interferometrie", :instrument "T", :angle "239.8   ", :nb nuits 1, :réf "491", :n° fiche 5770, :codeobs "CHR  ", :dimension "400", :sépar "00.245   "} {:date "1985.68    ", :nota nil, :instrument "l", :angle "239.2   ", :nb nuits 1, :réf "489", :n° fiche 5770, :codeobs "COU  ", :dimension "50", :sépar "00.23    "} {:date "1985.74    ", :nota nil, :instrument "l", :angle "235.9   ", :nb nuits 1, :réf "489", :n° fiche 5770, :codeobs "COU  ", :dimension "74", :sépar "00.22    "} {:date "1989.758   ", :nota "dm=0.3                   ", :instrument "l", :angle "239.4   ", :nb nuits 2, :réf "557", :n° fiche 5770, :codeobs "GII", :dimension "74", :sépar "00.23    "} {:date "1989.6130", :nota "interferometrie", :instrument "T", :angle "238.7", :nb nuits nil, :réf "COU", :n° fiche 5770, :codeobs "CHR", :dimension "180", :sépar "00.251"} {:date "1984.7039", :nota "interferometrie", :instrument "T", :angle "238.3", :nb nuits 1, :réf "651", :n° fiche 5770, :codeobs "HRT", :dimension "380", :sépar "00.260"})

(defn readMeasures
  "Read the table Mesures and return measures if any or NIL."
  [NoFiche]
  
  (println "sidonie-common.clj : readMeasure : Reading Mesures...")

  (let [
        records (jdbc/query db
                            [(str "SELECT * FROM Mesures WHERE `N° Fiche`=" NoFiche )])
        record0 (first records)
        ]

    (print "sidonie-common.clj : readMeasures : records=")
    (println records)
    
    (if (nil? record0)
      record0
      records))

 
  )

;;  (dbg-rv (+ 1 2))
;; 3
;; 3

(defmacro dbg-rv
  "debug return value: use this macro for debugging in affectation of variables, displaying the value and returning it"
  [expression]
  (list 'let ['result expression]
        (list 'println 'result)
        'result))


;; eu.oca.jclojure=> (dbg-expr-rv (+ 1 2))
;; (+ 1 2) = 3
;; 3
(defmacro dbg-expr-rv
  "debug expression and return value: use this macro for debugging in affectation of variables, displaying the expression,it value and returning it"
  [expression]
  (list 'let ['result expression]
        (list 'print (list 'quote expression) "= ")
        (list 'println 'result)
        'result))

;; eu.oca.jclojure=> (def mes {:nb_nuits "3", :date "2020.2", :nota "tutu", :instrument "titi", :no_fiche "12380", :ref "357", :angle "3.4", :codeobs "toto", :dimension "0", :separ "2.1"})
;; #'eu.oca.jclojure/mes

;; eu.oca.jclojure=> (delete-measure mes)
;; sidonie-common.clj : delete-measure : Deleting measure...
;; sidonie-common.clj : delete-measure : result =(2)
;; (2)
(defn delete-measure
  "delete the measure from database, the argument is a mesure structure build by the POST HTML method."
  [mes]
  (println "sidonie-common.clj : delete-measure : mes=")
  (println mes)
  (println "sidonie-common.clj : delete-measure : (str mes)=")
  (println (str mes))
  (println "sidonie-common.clj : delete-measure : Deleting measure...")

       
  
  (let [;; query-str (str "DELETE FROM Mesures WHERE `N° Fiche`=" (:no_fiche mes)
        ;;                " AND Date=" (:date mes)
        ;;                " AND Angle=" (:angle mes)
        ;;                " AND Sépar=" (:separ mes)
        ;;                " AND `Nb Nuits`=" (:nb_nuits mes)
        ;;                " AND CodeObs=" (:codeobs mes)
        ;;                " AND dimension=" (:dimension mes)
        ;;                " AND Instrument=" (:instrument mes)
        ;;                " AND Réf=" (:ref mes)
        ;;                " AND Nota=" (:nota mes))
        ;; result (jdbc/query db
        ;;                    [query-str])
        ;;record0 (first records)
        no_fiche (dbg-expr-rv (:no_fiche mes))
        nota (dbg-expr-rv (:nota mes))
        result (jdbc/delete! db :Mesures             ;; Delete
                ["`N° Fiche`=? AND Date=? AND Angle=? AND Sépar=? AND `Nb Nuits`=? AND CodeObs=? AND dimension=? AND Instrument=? AND Réf=? AND Nota=?"
                 no_fiche
                 (:date mes)
                 (:angle mes)
                 (:separ mes)
                 (:nb_nuits mes)
                 (:codeobs mes)
                 (:dimension mes)
                 (:instrument mes)
                 (:ref mes)
                 nota])
        ]

    (print "sidonie-common.clj : delete-measure : result =")
    (println result)
    
    ;; (if (nil? record0)
    ;;   record0
    ;;   records)

    result

    )

 
  )

;; eu.oca.jclojure=> (def post_data {:nb_nuits "3", :old_separ "2", :date "2020.4", :nota "test", :instrument "Z", :old_ref "8", :ref "9", :old_nota "test", :old_dimension "7", :angle "1", :old_nb_nuits "3", :codeobs "DAM", :no_fiche "12380", :dimension "7", :separ "4", :old_codeobs "DAM", :old_date "2020.4", :old_instrument "Z", :old_no_fiche "12380", :old_angle "1"})
;; #'eu.oca.jclojure/post_data
;; eu.oca.jclojure=> (update-measure post_data)
;; jclojure.clj : update-measure : updating Mesures...
;; 1

(defn update-measure
  "Update the table Mesures ,take in argument post data containing old measure and new one, return the number of update objects, 1 or 0 if error."
  [ post_data]
  
  (println "jclojure.clj : update-measure : updating Mesures...")

  (first
   (jdbc/update! db :Mesures
                 ;; verifier la casse des keywords
                 {
                  (keyword "N° Fiche") (:no_fiche post_data)
                  :Date (:date post_data)
                  :Angle (:angle post_data)
                  (keyword "Sépar") (:separ post_data)
                  (keyword "Nb Nuits") (:nb_nuits post_data)
                  :CodeObs (:codeobs post_data)
                  :dimension (:dimension post_data)
                  :Instrument (:instrument post_data)
                  (keyword "Réf") (:ref post_data)
                  :Nota (:nota post_data)
                  }
                 ;; verifier l'ordre des items suivant:
                 ["`N° Fiche`=? AND Date=? AND Angle=? AND Sépar=? AND `Nb Nuits`=? AND CodeObs=? AND dimension=? AND Instrument=? AND Réf=? AND Nota=?"
                 (:old_no_fiche post_data)
                 (:old_date post_data)
                 (:old_angle post_data)
                 (:old_separ post_data)
                 (:old_nb_nuits post_data)
                 (:old_codeobs post_data)
                 (:old_dimension post_data)
                 (:old_instrument post_data)
                 (:old_ref post_data)
                 (:old_nota post_data)]
                 {:entities (jdbc/quoted \`)} ; or (jdbc/quoted :mysql)
                 ) ;; Update
   ) ;; first
 
  )



;; eu.oca.jclojure=> (def mes {:nb_nuits "3", :date "2020.2", :nota "tutu", :instrument "titi", :no_fiche "12380", :ref "357", :angle "3.4", :codeobs "toto", :dimension "70", :separ "2.1"})
;; #'eu.oca.jclojure/mes
;; eu.oca.jclojure=> (add-measure mes)
;; (nil)
(defn add-measure

  "add a measure in mesure table"

  [ mes ] ;; m={:nb_nuits "3", :date "2020.2", :nota "tutu", :instrument "titi", :no_fiche "12380", :ref "357", :angle "3.4", :codeobs "toto", :dimension "70", :separ "2.1"}

  (let [result (jdbc/insert! db :Mesures
                             ;; verifier la casse des keywords
                             {
                              (keyword "N° Fiche") (:no_fiche mes)
                              :Date (:date mes)
                              :Angle (:angle mes)
                              (keyword "Sépar") (:separ mes)
                              (keyword "Nb Nuits") (:nb_nuits mes)
                              :CodeObs (:codeobs mes)
                              :dimension (:dimension mes)
                              :Instrument (:instrument mes)
                              (keyword "Réf") (:ref mes)
                              :Nota (:nota mes)
                              }
                             {:entities (jdbc/quoted \`)} ; or (jdbc/quoted :mysql)
                             )]

    (print "sidonie-common.clj : add-measure : result =")
    (println result)
    
    result))
    


;; (defmacro get-sql-metadata [db method & args]
;;   `(with-connection
;;     ~db
;;     (doall
;;       (resultset-seq
;;         (~method
;;           (.getMetaData (connection))
;;           ~@args)))))



;; eu.oca.jclojure=> (def metadata (jdbc/with-db-metadata [md db]
;;              #_=>   (jdbc/metadata-result (.getTables md nil nil nil (into-array ["TABLE" "VIEW"])))))
;; #'eu.oca.jclojure/metadata
;; eu.oca.jclojure=> (map :table_name metadata)
;; ("AngularDistance" "Coordonnées" "DEBUG_DOUBLE" "Mesures" "Obs" "Références" "Sigles" "Table des erreurs" "TypeSpectral" "WDS" "WDS2" "orbite")

;; (jdbc/with-db-metadata [md db]   (jdbc/metadata-result (.getTables md nil nil nil (into-array ["TABLE" "VIEW"]))))


;;(jdbc/with-db-metadata [m db] (->> (.getColumns m "sidonie" nil "Mesures" nil) (jdbc/metadata-query) (map :column_name)))
;; ("N° Fiche" "Date" "Angle" "Sépar" "Nb Nuits" "CodeObs" "dimension" "Instrument" "Réf" "Nota")

;;(jdbc/with-db-metadata [m db] (jdbc/metadata-query (.getColumns m "sidonie" nil "Mesures" nil)))
;; eu.oca.jclojure=> (jdbc/with-db-metadata [m db] (jdbc/metadata-query (.getColumns m "sidonie" nil "Mesures" nil)))
;; ({:remarks "", :is_autoincrement "NO", :decimal_digits 0, :scope_table nil, :column_size 10, :scope_catalog nil, :is_nullable "YES", :scope_schema nil, :table_schem nil, :char_octet_length nil, :source_data_type nil, :buffer_length 65535, :num_prec_radix 10, :data_type 4, :column_name "N° Fiche", :column_def nil, :table_name "Mesures", :nullable 1, :type_name "INT", :table_cat "sidonie", :ordinal_position 1, :is_generatedcolumn "NO", :sql_data_type 0, :sql_datetime_sub 0} {:remarks "", :is_autoincrement "NO", :decimal_digits nil, :scope_table nil, :column_size 50, :scope_catalog nil, :is_nullable "YES", :scope_schema nil, :table_schem nil, :char_octet_length 50, :source_data_type nil, :buffer_length 65535, :num_prec_radix 10, :data_type 12, :column_name "Date", :column_def nil, :table_name "Mesures", :nullable 1, :type_name "VARCHAR", :table_cat "sidonie", :ordinal_position 2, :is_generatedcolumn "NO", :sql_data_type 0, :sql_datetime_sub 0} {:remarks "", :is_autoincrement "NO", :decimal_digits nil, :scope_table nil, :column_size 50, :scope_catalog nil, :is_nullable "YES", :scope_schema nil, :table_schem nil, :char_octet_length 50, :source_data_type nil, :buffer_length 65535, :num_prec_radix 10, :data_type 12, :column_name "Angle", :column_def nil, :table_name "Mesures", :nullable 1, :type_name "VARCHAR", :table_cat "sidonie", :ordinal_position 3, :is_generatedcolumn "NO", :sql_data_type 0, :sql_datetime_sub 0} {:remarks "", :is_autoincrement "NO", :decimal_digits nil, :scope_table nil, :column_size 50, :scope_catalog nil, :is_nullable "YES", :scope_schema nil, :table_schem nil, :char_octet_length 50, :source_data_type nil, :buffer_length 65535, :num_prec_radix 10, :data_type 12, :column_name "Sépar", :column_def nil, :table_name "Mesures", :nullable 1, :type_name "VARCHAR", :table_cat "sidonie", :ordinal_position 4, :is_generatedcolumn "NO", :sql_data_type 0, :sql_datetime_sub 0} {:remarks "", :is_autoincrement "NO", :decimal_digits 0, :scope_table nil, :column_size 3, :scope_catalog nil, :is_nullable "YES", :scope_schema nil, :table_schem nil, :char_octet_length nil, :source_data_type nil, :buffer_length 65535, :num_prec_radix 10, :data_type -6, :column_name "Nb Nuits", :column_def nil, :table_name "Mesures", :nullable 1, :type_name "TINYINT", :table_cat "sidonie", :ordinal_position 5, :is_generatedcolumn "NO", :sql_data_type 0, :sql_datetime_sub 0} {:remarks "", :is_autoincrement "NO", :decimal_digits nil, :scope_table nil, :column_size 50, :scope_catalog nil, :is_nullable "YES", :scope_schema nil, :table_schem nil, :char_octet_length 50, :source_data_type nil, :buffer_length 65535, :num_prec_radix 10, :data_type 12, :column_name "CodeObs", :column_def nil, :table_name "Mesures", :nullable 1, :type_name "VARCHAR", :table_cat "sidonie", :ordinal_position 6, :is_generatedcolumn "NO", :sql_data_type 0, :sql_datetime_sub 0} {:remarks "", :is_autoincrement "NO", :decimal_digits nil, :scope_table nil, :column_size 50, :scope_catalog nil, :is_nullable "YES", :scope_schema nil, :table_schem nil, :char_octet_length 50, :source_data_type nil, :buffer_length 65535, :num_prec_radix 10, :data_type 12, :column_name "dimension", :column_def nil, :table_name "Mesures", :nullable 1, :type_name "VARCHAR", :table_cat "sidonie", :ordinal_position 7, :is_generatedcolumn "NO", :sql_data_type 0, :sql_datetime_sub 0} {:remarks "", :is_autoincrement "NO", :decimal_digits nil, :scope_table nil, :column_size 50, :scope_catalog nil, :is_nullable "YES", :scope_schema nil, :table_schem nil, :char_octet_length 50, :source_data_type nil, :buffer_length 65535, :num_prec_radix 10, :data_type 12, :column_name "Instrument", :column_def nil, :table_name "Mesures", :nullable 1, :type_name "VARCHAR", :table_cat "sidonie", :ordinal_position 8, :is_generatedcolumn "NO", :sql_data_type 0, :sql_datetime_sub 0} {:remarks "", :is_autoincrement "NO", :decimal_digits nil, :scope_table nil, :column_size 50, :scope_catalog nil, :is_nullable "YES", :scope_schema nil, :table_schem nil, :char_octet_length 50, :source_data_type nil, :buffer_length 65535, :num_prec_radix 10, :data_type 12, :column_name "Réf", :column_def nil, :table_name "Mesures", :nullable 1, :type_name "VARCHAR", :table_cat "sidonie", :ordinal_position 9, :is_generatedcolumn "NO", :sql_data_type 0, :sql_datetime_sub 0} {:remarks "", :is_autoincrement "NO", :decimal_digits nil, :scope_table nil, :column_size 50, :scope_catalog nil, :is_nullable "YES", :scope_schema nil, :table_schem nil, :char_octet_length 50, :source_data_type nil, :buffer_length 65535, :num_prec_radix 10, :data_type 12, :column_name "Nota", :column_def nil, :table_name "Mesures", :nullable 1, :type_name "VARCHAR", :table_cat "sidonie", :ordinal_position 10, :is_generatedcolumn "NO", :sql_data_type 0, :sql_datetime_sub 0})
