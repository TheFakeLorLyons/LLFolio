(ns portfolio.helpers.pages
  (:require [reagent.core :as r]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                        ;                state                ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def state (r/atom {:menu-open false
                    :display-content :landing
                    :display-extras false}))

(def pages
  [[:a {:href "#home" :on-click #(reset! state {:display-content :landing})} "Home"]
   [:a {:href "#rcv" :on-click #(reset! state {:display-content :rcv})} "Resume/CV"]
   [:a {:href "#bio" :on-click #(reset! state {:display-content :bio})} "Biography (so far)"]
   [:a {:href "#prg" :on-click #(reset! state {:display-content :prg})} "Programming"]
   [:a {:href "#contact" :on-click #(reset! state {:display-content :contact})} "Contact Me"]])

(def extra-pages
  [[:a {:href "#mus" :on-click #(reset! state {:display-content :mus})} "Music"]
   [:a {:href "#art" :on-click #(reset! state {:display-content :art})} "Art"]
   [:a {:href "#wrt" :on-click #(reset! state {:display-content :wrt})} "Writing"]])

(def page-styles
  {:landing {:main {:background "linear-gradient(205deg, rgba(187, 189, 174, 0.156) 0%, rgba(187, 189, 174, 0.156) 10%, rgba(25, 20, 10, 0.156) 40%, rgba(1, 0, 1, 0.5) 60%, rgba(0, 0, 0) 80%)"
                    :background-color "#150628"}
             :sidebar {:background "linear-gradient(135deg, rgba(187, 189, 174, 0.156),rgb(1, 0, 1, .45) 65%)"
                       :background-color "#1506288f"}}
   :rcv {:main {:background "linear-gradient(205deg, rgba(50, 50, 50, 0.156), rgb(20, 20, 20) 60%)"
                :background-color "#141414"}
         :sidebar {:background "linear-gradient(205deg, rgba(50, 50, 50, 0.156), rgb(20, 20, 20, .85) 60%)"
                   :background-color "#1414148f"}}
   :bio {:main {:background "linear-gradient(205deg, rgba(238, 144, 238, 0.156), rgb(0, 0, 0, .95) 60%)"
                :background-color "#093b09"}
         :sidebar {:background "linear-gradient(135deg, rgba(40, 60, 40, 0.5) 10%, rgba(0, 20, 27, .45) 50%, rgba(1, 0, 1, .95) 85%)"
                   :background-color "#093b0985"}}
   :prg {:main {:background "linear-gradient(205deg, rgba(0, 47.8, 87.1, 0.156) 0%, 
                                                     rgb(0, 47.8, 87.1, .8) 20%, 
                                                     rgb(0, 27, 45.75) 45%, 
                                                     rgb(0, 0, 10) 75%)"
                :background-color "#2c8bc985"}
         :sidebar {:background "linear-gradient(135deg, rgba(0, 47.8, 87.1, 0.156) 0%, rgba(0, 27, 45.75, .65), rgba(1, 0, 1, .85) 65%)"
                   :background-color "#2c8bc985"}}
   :mus {:main {:background "linear-gradient(205deg, rgba(52, 207, 139, 0.725) 5%, rgba(40, 186, 120, .9) 20%, rgba(1, 0, 1, .75) 70%,  rgba(0, 0, 0) 95%)"
                :background-color "#34cf8b"}
         :sidebar {:background "linear-gradient(135deg, rgba(52, 207, 139, 0.8) 10%, rgba(0, 20, 27, .45) 50%, rgba(1, 0, 1, .95) 85%)"
                   :background-color "#34cf8b85"}}
   :art {:main {:background "linear-gradient(205deg, rgba(254, 120, 130, 0.85) 3%, rgba(220, 62, 130, .45) 40%, rgba(1, 0, 1, .85) 90%)"
                :background-color "#f7abeb85"}
         :sidebar {:background "linear-gradient(135deg, rgba(255, 130, 130, 0.756), rgba(220, 62, 130, .45) 20%, rgba(1, 0, 1, .85) 85%)"
                   :background-color "#f7abeb85"}}
   :wrt {:main {:background "linear-gradient(205deg, rgba(255, 240, 200, 0.156), rgb(255, 235, 205) 60%)"
                :background-color "#FFFAF085"}
         :sidebar {:background "linear-gradient(135deg, rgba(255, 240, 200, 0.156), rgb(255, 235, 205) 60%)"
                   :background-color "#2a1d1285"}}
   :contact {:main {:background "linear-gradient(205deg, rgba(187, 189, 174, 0.156) 0%, rgba(187, 189, 174, 0.156) 10%, rgba(25, 20, 10, 0.156) 40%, rgba(1, 0, 1, 0.5) 60%, rgba(0, 0, 0) 80%)"
                    :background-color "#150628"}
             :sidebar {:background "linear-gradient(135deg, rgba(187, 189, 174, 0.156),rgb(1, 0, 1) 65%)"
                       :background-color "#150628"}}})

(defn toggle-extras []
  (swap! state update :display-extras not))

(defn page-list []
  [:div.page-list
   [:ol {:style {:list-style-type "none"}}
    (for [item pages]
      [:li.page-menu item])
    ;; "Extras" toggle button (fixed position)
    [:li.extras
     [:a {:href "#extras"
          :on-click #(toggle-extras)
          :style {:position "fixed"
                  :margin-top "5vh"
                  :color "#fff678"
                  :padding "5px 10px"
                  :border-radius "5px"}}
      (if (:display-extras @state) "Hide Extras" "Show Extras")]]
    ;Extra pages (conditionally rendered)
    (when (:display-extras @state)
      [:li
       [:ol {:style {:list-style-type "none"
                     :margin-top "10vh"
                     :font-size "12pt"}};Adjust spacing as needed
        (for [[index item] (map-indexed vector extra-pages)]
          [:li.page-menu {:key index} item]) ; Add :key here
        ]])]])

(def current-styles
  (r/reaction
   (let [current-page (:display-content @state)]
     (get page-styles current-page
          {:main {:background "linear-gradient(205deg, rgba(187, 189, 174, 0.156), rgb(1, 0, 1) 60%)"
                  :background-color "#150628"}
           :sidebar {:background "linear-gradient(135deg, rgba(187, 189, 174, 0.156),rgb(1, 0, 1) 65%)"
                     :background-color "#150628"}}))))

;for utility throughout
(defn zoomable-image [src alt width]
  (let [zoomed? (r/atom false)]
    (fn []
      [:div.image-container
       [:img {:src src
              :alt alt
              :class (when @zoomed? "zoomed")
              :style {:width width :height "auto"}
              :on-click #(swap! zoomed? not)}]])))