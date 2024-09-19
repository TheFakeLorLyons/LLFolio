(ns portfolio.helpers.pages
  (:require [reagent.core :as r]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                        ;                state                ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def state (r/atom {:menu-open false
                    :display-content :prg
                    :display-extras false
                    :mobile false}))

(defn update-display-content [content]
  (swap! state assoc 
         :display-content content
         :menu-open false))

(def pages
  [[:a {:href "#home" :on-click #(update-display-content :landing)} "Home"]
   [:a {:href "#rcv" :on-click #(update-display-content :rcv)} "Resume/CV"]
   [:a {:href "#bio" :on-click #(update-display-content :bio)} "Biography (so far)"]
   [:a {:href "#prg" :on-click #(update-display-content :prg)} "Programming"]
   [:a {:href "#contact" :on-click #(update-display-content :contact)} "Contact Me"]])

(def extra-pages
  [[:a {:href "#mus" :on-click #(update-display-content :mus)} "Music"]
   [:a {:href "#art" :on-click #(update-display-content :art)} "Art"]
   [:a {:href "#wrt" :on-click #(update-display-content :wrt)} "Writing"]])

(def page-styles
  {:landing {:main {:background "linear-gradient(205deg, rgba(187, 189, 174, 0.156) 0%, rgba(187, 189, 174, 0.156) 10%, rgba(25, 20, 10, 0.156) 40%, rgba(1, 0, 1, 0.5) 60%, rgba(0, 0, 0) 80%)"
                    :background-color "#150628"}
             :sidebar {:background "linear-gradient(135deg, rgba(187, 189, 174, 0.156),rgb(1, 0, 1, .45) 65%)"
                       :background-color "#1506288f"}}
   :rcv {:main {:background "linear-gradient(205deg, rgba(50, 50, 50, 0.156), rgb(20, 20, 20) 60%)"
                :background-color "#141414"}
         :sidebar {:background "linear-gradient(205deg, rgba(50, 50, 50, 0.156), rgb(20, 20, 20, .85) 60%)"
                   :background-color "#1414148f"}}
   :bio {:main {:background-image "linear-gradient(115deg, rgba(238, 144, 238, 0.2) 5%, rgba(30, 50, 29, 0.26) 10%, rgba(9, 20, 0, 0.8) 35%, rgba(0, 0, 0, 0.93) 50%), url('/assets/pictures/fields-bio.jpg')"
                :background-size "cover"
                :background-position "center"
                :background-repeat "no-repeat"
                :background-color "#093b09e5"}
         :background-color "#093b09e5"
         :sidebar {:background "linear-gradient(215deg, rgba(40, 60, 40, 0.15) 10%, rgba(1, 0, 1, .75) 35%)"
           :background-color "#21471715"}}
   :prg {:main {:background-image "linear-gradient(165deg, rgba(10, 10, 0, 0.45) 5%, rgba(9, 9, 0, 0.75) 15%, rgba(0, 0, 0, 0.98) 50%), url('/assets/pictures/forest-ds-prg.jpg')"
                :background-size "cover"
                :background-position "center"
                :background-repeat "no-repeat"
                :background-color "#2c8bc985"}
         :background-color "#2c8bc985"
         :sidebar {:background "linear-gradient(135deg, rgba(0, 47.8, 87.1, 0.056) 0%, rgba(0, 27, 45.75, .25), rgba(1, 0, 1, .85) 65%)"
                   :background-color "#2c8bc925"}}
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
   :contact {:main {:background-image "linear-gradient(235deg, rgba(10, 10, 0, 0.15) 5%, rgba(9, 9, 0, 0.55) 35%, rgba(0, 0, 0, 0.98)95%), url('/assets/pictures/walk.jpg')"
                    :background-size "cover" 
                    :background-position "center"
                    :background-repeat "no-repeat"
                    :background-color "#2c8bc985"}
             :background-color "#2c8bc985"
             :sidebar {:background "linear-gradient(135deg, rgba(187, 189, 174, 0.156),rgb(1, 0, 1) 65%)"
                       :background-color "#15062885"}}})

(def mob-page-styles
  {:landing {:main {:background "linear-gradient(205deg, rgba(187, 189, 174, 0.156) 0%, rgba(187, 189, 174, 0.156) 10%, rgba(25, 20, 10, 0.156) 40%, rgba(1, 0, 1, 0.5) 60%, rgba(0, 0, 0) 80%)"
                    :background-color "#150628"}
             :sidebar {:background "linear-gradient(135deg, rgba(100, 115, 80, 0.356),rgba(1, 0, 1, .75) 65%)"
                       :background-color "#150628e5"}}
   :rcv {:main {:background "linear-gradient(205deg, rgba(50, 50, 50, 0.156), rgb(20, 20, 20) 60%)"
                :background-color "#141414"}
         :sidebar {:background "linear-gradient(205deg, rgba(50, 50, 50, 0.156), rgb(20, 20, 20, .85) 60%)"
                   :background-color "#1414148f"}}
   :bio {:main {:background-image "linear-gradient(215deg, rgba(238, 144, 238, 0.16), rgba(0, 0, 0, 0.75) 15%, rgba(0, 0, 0, 0.95) 55%), url('/assets/pictures/trail.jpg')"
                :background-size "cover"
                :background-position "center"
                :background-repeat "no-repeat"
                :background-color "#093b09e5"}
         :background-color "#093b09e5"
         :sidebar {:background "linear-gradient(215deg, rgba(1, 0, 1, .9), rgba(1, 0, 1, .94)"
                   :background-color "#21471715"}}
   :prg {:main {:background-image "linear-gradient(330deg, rgba(10, 15, 0, 0.985) 5%, rgba(9, 9, 0, 0.55) 40%, rgba(0, 0, 20, 0.88) 90%), 
                                   linear-gradient(165deg, rgba(10, 10, 50, 0.05) 5%, rgba(9, 9, 0, 0.15) 25%, rgba(0, 0, 0, 0.98) 70%),
                                   url('/assets/pictures/trees-mob-prg.jpg')"
                :background-size "cover"
                :background-position "center"
                :background-repeat "no-repeat"
                :background-color "#2c8bc985"}
         :background-color "#2c8bc985"
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
   :contact {:main {:background-image "linear-gradient(235deg, rgba(10, 10, 0, 0.15) 5%, rgba(9, 9, 0, 0.55) 35%, rgba(0, 0, 0, 0.98)95%), url('/assets/pictures/walk.jpg')"
                    :background-size "cover"
                    :background-position "center"
                    :background-repeat "no-repeat"
                    :background-color "#2c8bc985"}
             :background-color "#2c8bc985"
             :sidebar {:background "linear-gradient(215deg, rgba(187, 189, 174, 0.156), rgba(1, 0, 1, .85) 30%, rgba(1, 0, 1, .95) 65%)"
                       :background-color "#15062885"}}})

(defn toggle-extras []
  (swap! state update :display-extras not))

(defn page-list []
  [:div.page-list
   [:ol {:style {:list-style-type "none"}}
    (for [item pages]
      [:li.page-menu item]) 
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
     (if (@state :mobile)
       (get mob-page-styles current-page)
       (get page-styles current-page)))))

(defn zoomable-image [src alt width]
  (let [zoom-level (r/atom 1)
        position (r/atom {:x 0 :y 0})
        panning? (r/atom false)
        start-pos (r/atom nil)
        container-ref (r/atom nil)
        image-ref (r/atom nil)]
    (r/create-class
     {:component-did-mount
      (fn [_]
        (.addEventListener @container-ref "wheel"
                           (fn [e]
                             (.preventDefault e)
                             (let [delta (/ (- (.-deltaY e)) 1000)
                                   new-zoom (-> @zoom-level (+ delta) (max 1) (min 5))
                                   container-rect (.getBoundingClientRect @container-ref)
                                   image-rect (.getBoundingClientRect @image-ref)
                                   center-x (/ (.-width container-rect) 2)
                                   center-y (/ (.-height container-rect) 2)
                                   dx (- center-x (.-left image-rect) (/ (.-width image-rect) 2))
                                   dy (- center-y (.-top image-rect) (/ (.-height image-rect) 2))]
                               (reset! zoom-level new-zoom)
                               (reset! position {:x (* dx (- 1 (/ new-zoom @zoom-level)))
                                                 :y (* dy (- 1 (/ new-zoom @zoom-level)))})))))

      :component-will-unmount
      (fn [_]
        (.removeEventListener @container-ref "wheel"
                              (fn [e]
                                (.preventDefault e)
                                (let [delta (/ (- (.-deltaY e)) 1000)
                                      new-zoom (-> @zoom-level (+ delta) (max 1) (min 5))]
                                  (reset! zoom-level new-zoom)))))

      :reagent-render
      (fn [src alt width]
        [:div.image-container
         {:ref #(reset! container-ref %)
          :style {:overflow "hidden"
                  :cursor (if (> @zoom-level 1) "move" "default")
                  :display "flex"
                  :justify-content "center" }
          :on-mouse-down (fn [e]
                           (reset! panning? true)
                           (reset! start-pos {:x (.-clientX e) :y (.-clientY e)}))
          :on-mouse-move (fn [e]
                           (when @panning?
                             (let [dx (- (.-clientX e) (:x @start-pos))
                                   dy (- (.-clientY e) (:y @start-pos))
                                   container-rect (.getBoundingClientRect @container-ref)
                                   image-rect (.getBoundingClientRect @image-ref)
                                   max-x (/ (- (* (.-width image-rect) @zoom-level) (.-width container-rect)) 2)
                                   max-y (/ (- (* (.-height image-rect) @zoom-level) (.-height container-rect)) 2)]
                               (swap! position (fn [{:keys [x y]}]
                                                 {:x (-> (+ x dx)
                                                         (max (- max-x))
                                                         (min max-x))
                                                  :y (-> (+ y dy)
                                                         (max (- max-y))
                                                         (min max-y))}))
                               (reset! start-pos {:x (.-clientX e) :y (.-clientY e)}))))
          :on-mouse-up #(reset! panning? false)
          :on-mouse-leave #(reset! panning? false)}
         [:img {:ref #(reset! image-ref %)
                :src src
                :alt alt
                :style {:max-width width
                        :max-height "100%"
                        :object-fit "contain"
                        :transform (str "scale(" @zoom-level ") "
                                        "translate(" (/ (:x @position) @zoom-level) "px, "
                                        (/ (:y @position) @zoom-level) "px)")
                        :transition (if @panning? "none" "transform 0.1s ease-out")}}]])})))
