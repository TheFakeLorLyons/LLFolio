(ns portfolio.pages.bio
  (:require [reagent.core :as r]
            [portfolio.helpers.texts :as txt]
            [portfolio.helpers.pages :as page]))

(defonce display-text (r/atom :bio))

(defn r-icon []
  [:img {:src "/assets/images/ricon.png"
         :id "clj-icon"
         :style {:position "fixed"
                 :top "-2vh"
                 :right "2vw"
                 :margin "10px"
                 :scale "60%"
                 :opacity ".65"
                 :display (if (= (:display-content @page/state) :bio) "block" "none")}}])

(defn piano-picture []
  [:div
   (if (@page/state :mobile)
     [page/zoomable-image "/assets/biopics/me&piano.png" "me@piano" "100%"]
     [page/zoomable-image "/assets/biopics/me&piano.png" "me@piano" "20vw"])])
(defn hiking-worm []
  [:div
   (if (@page/state :mobile)
     [:div {:style {:transform "translateY(12vh)"}}
      [page/zoomable-image "/assets/biopics/hiking-worm.jpg" "hiking-worm" "100%"]]
     [page/zoomable-image "/assets/biopics/hiking-worm.jpg" "hiking-worm" "35vw"])])
(defn never-give-up []
  [:div
   (if (@page/state :mobile)
     [:div {:style {:transform "translateY(12vh)"}}
      [page/zoomable-image "/assets/biopics/nevergiveup.png" "give-up"  "100%"]]
     [page/zoomable-image "/assets/biopics/nevergiveup.png" "give-up" "45vw"])])
(defn second-picture-of-me []
  [:div
   (if (@page/state :mobile)
     [:div
      [page/zoomable-image "/assets/biopics/10-15.jpg" "second-picture-of-me" "100%"]]
     [page/zoomable-image "/assets/biopics/10-15.jpg" "second-picture-of-me" "20vw"])])


(defn text-content [project]
  (case project
    :bio txt/bio
    :now txt/current
    :goals txt/future
    "No content available"))

(defn vegan-btw []
  (if (@page/state :mobile)
    [:div {:style {:transform "translateY(12vh)"}}
     [:video {:controls true
              :style {:width "100%"}}
      [:source {:src "/assets/gifs/vegan-btw.mp4" :type "video/mp4"}]
      [:source {:src "/assets/gifs/vegan-btw.webm" :type "video/webm"}]
      "Your browser does not support the video tag."]]
    [:div
     [:video {:controls true
              :style {:width "100%"}}
      [:source {:src "/assets/gifs/vegan-btw.mp4" :type "video/mp4"}]
      [:source {:src "/assets/gifs/vegan-btw.webm" :type "video/webm"}]
      "Your browser does not support the video tag."]]))

(defn bio-carousel []
  [:div.carousel {:id "bioCarousel"
                  :data-ride "tcarousel"
                  :class "carousel slide"
                  :style {:display "flex"
                          :justify-content "center"
                          :align-items "center"}}
   [:div.carousel-inner {:style {:font-size "16pt"}}
    [:div.carousel-item.active
     [piano-picture]]
    [:div.carousel-item {:style {:margin-top "4.25vh"}}
     [never-give-up]]
    [:div.carousel-item {:style {:margin-top "3.5vh"}}
     [second-picture-of-me]]
    [:div.carousel-item {:style {:margin-top "3.5vh"}}
     [vegan-btw]]
    [:a.carousel-control-prev {:href "#bioCarousel"
                               :role "button"
                               :data-slide "prev"}
     [:span.carousel-control-prev-icon {:aria-hidden "true"}]
     [:span.sr-only "Previous"]]
    [:a.carousel-control-next {:href "#bioCarousel" :role "button" :data-slide "next"}
     [:span.carousel-control-next-icon {:aria-hidden "true"}]
     [:span.sr-only "Next"]]]])

(defn mob-bio-carousel []
  [:div.carousel {:id "mobioCarousel"
                  :data-ride "tcarousel"
                  :class "carousel slide"
                  :style {:display "flex"
                          :justify-content "center"
                          :align-items "center"}}
   [:div.carousel-inner {:style {:font-size "14pt"}}
    [:div.carousel-item.active
     [:div {:style {:text-align "center"
                    :padding "1rem"}}
      [:h6 {:style {:margin-top "1vh" :margin-bottom "1vh" :font-weight "bold"}}
       "I graduated in 2015..."]
      (doall (map (fn [paragraph] [:p paragraph]) txt/bio))]]
    [:div.carousel-item
     [piano-picture]]
    [:div.carousel-item {:style {:margin-top "1vh"}}
     [:div {:style {:text-align "center"
                    :padding "1rem"}}
      (doall (map (fn [paragraph] [:p paragraph]) txt/current))]]
    [:div.carousel-item {:style {:margin-top "3.5vh"}}
     [vegan-btw]]
    [:div.carousel-item {:style {:margin-top "3.5vh"}}
     [second-picture-of-me]]
    [:div.carousel-item {:style {:margin-top "1vh"}}
     [:div {:style {:text-align "center"
                    :padding "1rem"}}
      (doall (map (fn [paragraph] [:p paragraph]) txt/future))]]
    [:div.carousel-item {:style {:margin-top "4.25vh"}}
     [never-give-up]]
    [:a.carousel-control-prev {:href "#mobioCarousel"
                               :role "button"
                               :data-slide "prev"}
     [:span.carousel-control-prev-icon {:aria-hidden "true"}]
     [:span.sr-only "Previous"]]
    [:a.carousel-control-next {:href "#mobioCarousel" :role "button" :data-slide "next"}
     [:span.carousel-control-next-icon {:aria-hidden "true"}]
     [:span.sr-only "Next"]]]])

(defn bio-table []
  [:div.bio-container {:style {:align-items "center"
                               :width "90%"
                               :height "70vh"}}
   [:div.bio-table-wrapper
    [:div.table-row
     {:style {:display "flex"
              :width "100%"
              :height "100%"
              :gap "3vw"}}
     [:div.bio-table-cell
      {:style {:display "table-cell"}}
      [bio-carousel]]
     [:div.bio-table-cell {:style {:display "table-cell"}}
      [:div.bio-heading {:style
                         {:display "flex"
                          :gap "2vw"
                          :justify-content "center"}}
       [:a {:href "#college" :on-click #(reset! display-text :bio)
            :color "#fff678"} "Through College"]
       [:a {:href "#current" :on-click #(reset! display-text :now)
            :color "#fff678"} "Now"]
       [:a {:href "#future" :on-click #(reset! display-text :goals)
            :color "#fff678"} "Future Aspirations"]]
      (when (= @display-text :bio)
        [:h4 {:style {:margin-top "2vh" :margin-bottom "4vh" :font-weight "bold"}}
         "I graduated in 2015..."])
      (for [line (text-content @display-text)]
        ^{:key line}
        [:p {:style {:font-size 18}} line])]]]])

(defn bio []
  (if (@page/state :mobile)
    [:div.mob-bio-content
     [:h3 {:style {:align-items "center"
                   :font-weight "bold"}}
      "Bio"]
     [mob-bio-carousel]]
    [:div.bio-content
     [:h1 {:style {:align-items "center"}}
      "Bio"]
     [r-icon]
     [bio-table]]))