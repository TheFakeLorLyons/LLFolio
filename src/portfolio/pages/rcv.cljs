(ns portfolio.pages.rcv
  (:require [reagent.core :as r]
            [portfolio.helpers.texts :as txt]
            [portfolio.helpers.pages :as page]))

(defn pdf-viewer []
  [:embed {:src "/assets/lor-lyons-resume-sep-2024.pdf#toolbar=0&navpanes=0" 
           :style {:width "85vw" 
                   :height "100vh"
                   :border "none"} 
           :type "application/pdf"}])

(defn mob-pdf-viewer []
  [:div 
   [:h4 "My Resumé"]
   [:div {:style {:display "flex"
                  :justify-content "center"} }
    [:p "Click "
     [:a {:href "https://docs.google.com/document/d/1ul8DfyrKvuX6mtJkTJwIT8iIgRVQygdOhmGlc-Mku7E/export?format=pdf"
              :target "_blank"
              :style {:color "rgb(255, 246, 120)"}
              :rel "noopener noreferrer"} "here"]
     " to view on mobile"]]])


(defn rcvs []
  [:div.rcv-content {:style {:width "100%"
                             :height "100vh"
                             :overflow "hidden"}}
   (if (@page/state :mobile) 
     [mob-pdf-viewer]
     [pdf-viewer])])