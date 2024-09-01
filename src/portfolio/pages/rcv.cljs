(ns portfolio.pages.rcv
  (:require [portfolio.helpers.texts :as txt]))

(defn pdf-viewer []
  [:embed {:src "/assets/lor-lyons-resume-sep-2024.pdf" :style {:width "85vw" :height "80vh"} :type "application/pdf"}])

(defn rcvs []
  [:div.bio-content
   [:h1 "Resume/CV"]
   [:p "Below is my current Resume"]
   [pdf-viewer]])