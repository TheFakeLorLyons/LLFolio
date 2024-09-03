(ns portfolio.pages.rcv
  (:require [portfolio.helpers.texts :as txt]))

(defn pdf-viewer []
  [:embed {:src "/assets/lor-lyons-resume-sep-2024.pdf#toolbar=0&navpanes=0" 
           :style {:width "85vw" 
                   :height "100vh"
                   :border "none"} 
           :type "application/pdf"}])

(defn rcvs []
  [:div.bio-content
   [pdf-viewer]])