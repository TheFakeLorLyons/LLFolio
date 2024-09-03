(ns portfolio.pages.bio
  (:require [reagent.core :as r]
            [portfolio.helpers.texts :as txt]
            [portfolio.helpers.pages :as page]))

(defonce display-text (r/atom :bio))

(defn piano-picture []
  [:div
   [page/zoomable-image "/assets/me&piano.png" "me@piano" "20vw"]])
(defn hiking-worm []
  [:div
   [page/zoomable-image "/assets/hiking-worm.jpg" "hiking-worm" "35vw"]])
(defn never-give-up []
  [:div
   [page/zoomable-image "/assets/nevergiveup.png" "give-up" "45vw"]])

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
     [hiking-worm]]
    [:a.carousel-control-prev {:href "#bioCarousel"
                               :role "button"
                               :data-slide "prev"}
     [:span.carousel-control-prev-icon {:aria-hidden "true"}]
     [:span.sr-only "Previous"]]
    [:a.carousel-control-next {:href "#bioCarousel" :role "button" :data-slide "next"}
     [:span.carousel-control-next-icon {:aria-hidden "true"}]
     [:span.sr-only "Next"]]]])

(defn text-content [project]
  (case project
    :bio txt/bio
    :now txt/current
    :goals txt/future
    "No content available"))

(defn bio-table []
  [:div.bio-container {:style {:align-items "center"
                               :width "90%"}}
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
        [:h4 {:style {:margin-top "1vh"}}
         "I graduated in 2015..."])
      (for [line (text-content @display-text)]
        ^{:key line} ;; Use a unique key for each item
        [:p {:style {:font-size 18}} line])]]]])

(defn bio []
  [:div.bio-content 
   [:h1 {:style {:align-items "center"}}
    "Bio"]
   [bio-table]])