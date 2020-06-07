;; sidonie measure file for modifying measures

;; some definitions are indeed put in sidonie-common.clj for access at REPL for debugging
;; they ideally should be put back later here

;;(declare readObjectNoFiche)
(declare create-html-measures)

(defn read-modify-measures
  
  "Read and modify table measures of Sidonie database"

  [params]
  
  ;;(str "GET params=" params))

  (let [Nom (:NomFORM params)
        NoFiche (readObjectNoFiche Nom)
        messageNotFound "Objet non trouvé dans la Base de Données."
        messageNoMeasures "Objet sans mesures connues."]

    (if (nil? NoFiche)
      (create-html (create-html-body-red-centered messageNotFound))
      (let [measures (readMeasures NoFiche)
            measures-no-space-accessors (map despace measures)]
        (if (zero? (count measures))
          (create-html (create-html-body-red-centered messageNoMeasures))
          (create-html (create-html-measures Nom NoFiche measures-no-space-accessors)))))))



(defn create-html-measures [Nom NoFiche measures]

   [:p {:align "center"}
    [:br]
    [:br]
    [:br]
    [:br]
    ;;[:font {:color "#ff0000"}
    [:font {:style "font-size: 24pt", :size "6"} "Mesures trouvées pour l'objet dont le nom est " Nom "  ( N° Fiche :" NoFiche ")"];;]
    [:br]
    [:br]
    [:table {:width "100%", :cellspacing "0", :cellpadding "0", :border "1"}
     [:tr
      [:th [:font {:color "#000080"} " Date "]]
      [:th [:font {:color "#000080"} " Angle "]]
      [:th [:font {:color "#000080"} " Sépar. "]]
      [:th [:font {:color "#000080"} " Nuits "]]
      [:th [:font {:color "#000080"} " Code "]]
      [:th [:font {:color "#000080"} " Instr. "]]
      [:th [:font {:color "#000080"} " Dim. "]]
      [:th [:font {:color "#000080"} " Réf. "]]
      [:th [:font {:color "#000080"} " Notes "]]
      [:th [:font {:color "#000080"} " MODIFIER "]]
      [:th [:font {:color "#000080"} " RESET "]]
      [:th [:font {:color "#000080"} " SUPPRIMER "]]
      ] ;;  </tr>
     ;; for ....
     (for [m (vec measures)]
       [:tr
        [:form {:action "https://sidonie.oca.eu/sidonie-admin/ModifyMeasure" :method "POST"}
         ;; rajouter bouton reset pour chaque
         [:input {:name "no_fiche", :value (:n°_fiche m), :type "hidden"}]
         [:td
          [:input {:name "date", :value (:date m), :type "text"}]]
         [:td
          [:input {:name "angle", :value (:angle m), :type "text"}]]
         [:td
           [:input {:name "separ", :value (:sépar m), :type "text"}]]
         [:td
          [:input {:name "nb_nuits", :value (:nb_nuits m), :type "text"}]]
         [:td
          [:input {:name "codeobs", :value (:codeobs m), :type "text"}]]
         [:td
          [:input {:name "instrument", :value (:instrument m), :type "text"}]]
         [:td
          [:input {:name "dimension", :value (:dimension m), :type "text"}]]
         [:td
          [:input {:name "ref", :value (:réf m), :type "text"}]]
         [:td
          [:input {:name "nota", :value (:nota m), :type "text"}]]
         [:td
          [:input {:name "old_no_fiche", :value (:n°_fiche m), :type "hidden"}]
          [:input {:name "old_date", :value (:date m), :type "hidden"}]
          [:input {:name "old_angle", :value (:angle m), :type "hidden"}]
          [:input {:name "old_separ", :value (:sépar m), :type "hidden"}]
          [:input {:name "old_nb_nuits", :value (:nb_nuits m), :type "hidden"}]
          [:input {:name "old_codeobs", :value (:codeobs m), :type "hidden"}]
          [:input {:name "old_instrument", :value (:instrument m), :type "hidden"}]
          [:input {:name "old_dimension", :value (:dimension m), :type "hidden"}]
          [:input {:name "old_ref", :value (:réf m), :type "hidden"}]
          [:input {:name "old_nota", :value (:nota m), :type "hidden"}]
          [:input {:value "MODIFIER", :type "submit"}]]
         [:td
          [:input {:value "RESET", :type "reset"}]]
         ] ;; end form
        [:td
         [:form {:action "https://sidonie.oca.eu/sidonie-admin/DeleteMeasure" :method "POST"}
          [:input {:name "no_fiche", :value (:n°_fiche m), :type "hidden"}]
          [:input {:name "date", :value (:date m), :type "hidden"}]
          [:input {:name "angle", :value (:angle m), :type "hidden"}]
          [:input {:name "separ", :value (:sépar m), :type "hidden"}]
          [:input {:name "nb_nuits", :value (:nb_nuits m), :type "hidden"}]
          [:input {:name "codeobs", :value (:codeobs m), :type "hidden"}]
          [:input {:name "instrument", :value (:instrument m), :type "hidden"}]
          [:input {:name "dimension", :value (:dimension m), :type "hidden"}]
          [:input {:name "ref", :value (:réf m), :type "hidden"}]
          [:input {:name "nota", :value (:nota m), :type "hidden"}]
          [:input {:value "SUPPRIMER", :type "submit"}]
          ] ;; end form
         ] ;; end td     
        ]) ;;  </tr>  end for
     ] ;; end TABLE
    
    [:br]
    [:br]
    [:br]
    
    [:table {:width "100%", :cellspacing "0", :cellpadding "0", :border "1"}
     [:tr
      [:th [:font {:color "#000080"} " Date "]]
      [:th [:font {:color "#000080"} " Angle "]]
      [:th [:font {:color "#000080"} " Sépar. "]]
      [:th [:font {:color "#000080"} " Nuits "]]
      [:th [:font {:color "#000080"} " Code "]]
      [:th [:font {:color "#000080"} " Instr. "]]
      [:th [:font {:color "#000080"} " Dim. "]]
      [:th [:font {:color "#000080"} " Réf. "]]
      [:th [:font {:color "#000080"} " Notes "]]
      [:th [:font {:color "#000080"} " AJOUTER "]]] ;;  </tr>
     
     [:tr
      [:form {:action "https://sidonie.oca.eu/sidonie-admin/AddMeasure" :method "POST"}
       [:input {:name "no_fiche", :value NoFiche, :type "hidden"}]
       [:td
        [:input {:name "date", :type "text"}]]
       [:td
        [:input {:name "angle", :type "text"}]]
       [:td
        [:input {:name "separ", :type "text"}]]
       [:td
        [:input {:name "nb_nuits", :type "text"}]]
       [:td
        [:input {:name "codeobs",  :type "text"}]]
       [:td
        [:input {:name "instrument", :type "text"}]]
       [:td
        [:input {:name "dimension", :type "text"}]]
       [:td
        [:input {:name "ref", :type "text"}]]
       [:td
        [:input {:name "nota", :type "text"}]]
       [:td
        [:input {:value "AJOUTER", :type "submit"}]]
       ] ;; end form  
      ] ;;  </tr> 
     ] ;; end TABLE

    [:br]
    [:br]
    [:br]

    [:a {:href "https://sidonie.oca.eu/sidonie-admin/interfaces_acces.html"} "Retour vers la page de mise à jour."]

    [:br]
    [:br]
  ] ;; end paragraph

  ) ;; end function



(defn DeleteMeasure 

  "create a confirm delete page for measures"

  [m] ;; we get a measure inside params of POST method

  (println "sidonie-measures.clj : DeleteMeasure : m=")
  (println m)
  
  (create-html
   [:p {:align "center"}
    [:br]
    [:br]
    [:font {:style "font-size: 24pt", :size "6", :color "#ff0000"} "Confirmez vous la suppression de la mesure suivante ?"]
    [:br]
    [:br]
    [:center
     [:form {:action "https://sidonie.oca.eu/sidonie-admin/ConfirmDeleteMeasure" :method "POST"}
      [:input {:name "no_fiche", :value (:no_fiche m), :type "text", :readonly "true"}]
      [:br]
      [:input {:name "date", :value (:date m), :type "text", :readonly "true"}]
      [:br]
      [:input {:name "angle", :value (:angle m), :type "text", :readonly "true"}]
      [:br]
      [:input {:name "separ", :value (:separ m), :type "text", :readonly "true"}]
      [:br]
      [:input {:name "nb_nuits", :value (:nb_nuits m), :type "text", :readonly "true"}]
      [:br]
      [:input {:name "codeobs", :value (:codeobs m), :type "text", :readonly "true"}]
      [:br]
      [:input {:name "instrument", :value (:instrument m), :type "text", :readonly "true"}]
      [:br]
      [:input {:name "dimension", :value (:dimension m), :type "text", :readonly "true"}]
      [:br]
      [:input {:name "ref", :value (:ref m), :type "text", :readonly "true"}]
      [:br]
      [:input {:name "nota", :value (:nota m), :type "text", :readonly "true"}]
      [:br]
      [:br]
      [:input {:value "CONFIRMER SUPPRESSION", :type "submit"}]
      ] ;; end form

     [:br]
    [:br]
    [:br]

    [:a {:href "https://sidonie.oca.eu/sidonie-admin/interfaces_acces.html"} "Retour vers la page de mise à jour."]

    [:br]
    [:br]
     ] ;; end center
    ]))



(defn ConfirmDeleteMeasure 

  "handler for the POST method for confirm delete  measures"

  [m] ;; we get a measure inside params of POST method

  (println "sidonie-measures.clj : ConfirmDeleteMeasure : m=")
  (println m)

  (let [result (delete-measure m)
        n (first result)]
    
  
    (create-html
     [:p {:align "center"}
      [:br]
      [:br]
      [:br]
      [:font {:style "font-size: 24pt", :size "6", :color "#ff0000"} (str n " mesure(s) supprimée.")]
      [:br]
      [:br]
      [:br]
    [:br]
    [:br]

    [:a {:href "https://sidonie.oca.eu/sidonie-admin/interfaces_acces.html"} "Retour vers la page de mise à jour."]

    [:br]
    [:br]
      ])))
  

;;  une interface add measure, a rajouter dans la precedente (car tous les objets ont des mesures sauf un qui doit etre une erreur)
(defn AddMeasure 

  "handler for the POST method for add measure"

  [m] ;; we get a measure inside params of POST method

  (println "sidonie-measures.clj : AddMeasure : m=")
  (println m)

  
  (try

    (add-measure m)

    (create-html (create-html-parag-msg-red-centered "Mesure ajoutée."))

    (catch Exception e (let [msg (.toString e)
                             stack-trace (with-out-str (clojure.stacktrace/print-stack-trace e))
                             msg-html (str "ERROR <BR>" msg "<br>" stack-trace)]
                         println (str "sidonie-measures.clj : AddMeasure : caught exception: " msg)
                         println (str "sidonie-measures.clj : AddMeasure : stack trace: " stack-trace)
                         (create-html (create-html-parag-msg-red-centered msg-html)))))
  
  
  )



(defn ModifyMeasure 

  "handler for the POST method for modify measure"

  [post_data] ;; we get a measure inside params of POST method

  (println "sidonie-measures.clj : ModifyMeasure : post_data=")
  (println (str post_data)) ;; without str we loose quotation

  ;;(create-html (create-html-parag-msg-red-centered (str "post_data=" post_data)))
  
  (try

    (create-html (create-html-parag-msg-red-centered (str (update-measure post_data)
                                                          " mesure(s) modifiée(s)." )))

    (catch Exception e (let [msg (.toString e)
                             stack-trace (with-out-str (clojure.stacktrace/print-stack-trace e))
                             msg-html (str "ERROR <BR>" msg "<br>" stack-trace)]
                         println (str "sidonie-measures.clj : ModifyMeasure : caught exception: " msg)
                         println (str "sidonie-measures.clj : ModifyMeasure : stack trace: " stack-trace)
                         (create-html (create-html-parag-msg-red-centered msg-html)))))
  
  
  )
