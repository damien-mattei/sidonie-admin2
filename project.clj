
;; create project:
;; lein new compojure sidonie-admin2

(defproject sidonie-admin2 "0.1.0-SNAPSHOT"
  :description "Sidonie Admin Site"
  :url "localhost:8080/sidonie-admin2-0.1.0-SNAPSHOT-standalone"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [mysql/mysql-connector-java "5.1.38"]
                 [org.clojure/java.jdbc "0.7.3"]
                 [hiccup "1.0.5"]
                 [compojure "1.6.1"]
                 [ring/ring-defaults "0.3.2"]
                 [ring-basic-authentication "1.0.2"]
                 [rm-hull/infix "0.3.3"]
                 [clj-time "0.15.2"] ]
  :plugins [[lein-ring "0.12.5"]]
  :ring {:handler sidonie-admin2.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.2"]]}})
