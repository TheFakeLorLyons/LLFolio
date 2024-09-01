(ns portfolio.helpers.pages
  (:require [reagent.core :as r]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                        ;                state                ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def state (r/atom {:menu-open false
                    :display-content :art}))

(def pages [[:a {:href "#home" :on-click #(reset! state {:display-content :landing})} "Home"]
            [:a {:href "#rcv" :on-click #(reset! state {:display-content :rcv})} "Resume/CV"]
            [:a {:href "#bio" :on-click #(reset! state {:display-content :bio})} "Biography (so far)"]
            [:a {:href "#prg" :on-click #(reset! state {:display-content :prg})} "Programming"]
            [:a {:href "#mus" :on-click #(reset! state {:display-content :mus})} "Music"]
            [:a {:href "#art" :on-click #(reset! state {:display-content :art})} "Art"]
            [:a {:href "#wrt" :on-click #(reset! state {:display-content :wrt})} "Writing"]])

(defn page-list []
  [:div.page-list
   [:ol {:style {:list-style-type "none"}}
    (for [item pages]
      [:li item])]])

(def page-styles
  {:landing {:main {:background "linear-gradient(205deg, rgba(187, 189, 174, 0.156), rgb(1, 0, 1) 60%)"
                    :background-color "#150628"}
             :sidebar {:background "linear-gradient(135deg, rgba(187, 189, 174, 0.156),rgb(1, 0, 1) 65%)"
                       :background-color "#150628"}}
   :rcv {:main {:background "linear-gradient(205deg, rgba(50, 50, 50, 0.156), rgb(20, 20, 20) 60%)"
                :background-color "#141414"}
         :sidebar {:background "linear-gradient(205deg, rgba(50, 50, 50, 0.156), rgb(20, 20, 20) 60%)"
                   :background-color "#141414"}}
   :bio {:main {:background "linear-gradient(205deg, rgba(238, 144, 238, 0.156), rgb(0, 0, 0) 60%)"
                :background-color "#093b09"}
         :sidebar {:background "linear-gradient(135deg, rgba(238, 144, 238, 0.156), rgb(0, 0, 0) 60%)"
                   :background-color "#093b09"}}
   :prg {:main {:background "linear-gradient(205deg, rgba(0, 47.8, 87.1, 0.156) 0%, rgb(0, 47.8, 87.1, .8), rgb(0, 27, 45.75), rgb(1, 0, 1) 60%)"
                :background-color "#2c8bc985"}
         :sidebar {:background "linear-gradient(135deg, rgba(0, 47.8, 87.1, 0.156) 0%, rgb(0, 27, 45.75), rgb(1, 0, 1) 65%)"
                   :background-color "#2c8bc9"}}
   :mus {:main {:background "linear-gradient(205deg, rgba(0, 47.8, 87.1, 0.156) 0%, rgba(0, 178, 70) 5%, rgba(0, 122, 45), rgb(1, 0, 1) 60%)"
                :background-color "#14f550"}
         :sidebar {:background "linear-gradient(135deg, rgba(0, 47.8, 87.1, 0.125), rgb(1, 0, 1) 65%)"
                   :background-color "#14f55085"}}
   :art {:main {:background "linear-gradient(205deg, rgba(254, 120, 130, 0.85) 0%, rgba(220, 62, 130, .85), rgb(1, 0, 1) 60%)"
                :background-color "#f7abeb85"}
         :sidebar {:background "linear-gradient(135deg, rgba(255, 130, 0, 0.156), rgb(1, 0, 1) 65%)"
                   :background-color "#f7abeb85"}}
   :wrt {:main {:background "linear-gradient(205deg, rgba(255, 240, 200, 0.156), rgb(255, 235, 205) 60%)"
                :background-color "#FFFAF0"}
         :sidebar {:background "linear-gradient(135deg, rgba(255, 240, 200, 0.156), rgb(255, 235, 205) 60%)"
                   :background-color "#2a1d12"}}})

(def current-styles
  (r/reaction
   (let [current-page (:display-content @state)]
     (get page-styles current-page
          {:main {:background "linear-gradient(205deg, rgba(187, 189, 174, 0.156), rgb(1, 0, 1) 60%)"
                  :background-color "#150628"}
           :sidebar {:background "linear-gradient(135deg, rgba(187, 189, 174, 0.156),rgb(1, 0, 1) 65%)"
                     :background-color "#150628"}}))))