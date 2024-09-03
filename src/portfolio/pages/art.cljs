(ns portfolio.pages.art
  (:require [portfolio.helpers.pages :as page]
            [portfolio.helpers.texts :as txt]
            [reagent.core :as r]))

(defonce current-drawings (r/atom :comp))

(defn restaurant []
  [:div
   [page/zoomable-image "/assets/restaurant.png" "restaurant" "40vw"]])
(defn mooncake []
  [:div
   [page/zoomable-image "/assets/mooncake.png" "mooncake" "30vw"]])
(defn shop-icon []
  [:div
   [page/zoomable-image "/assets/shop-icon.png" "shop" "20vw"]])

(defn comp-carousel []
  [:div.home.text.carousel {:id "artCarousel"
                            :data-ride "tcarousel"
                            :class "carousel slide"
                            :style {:display "flex"
                                    :justify-content "center"
                                    :align-items "center"
                                    :padding-right "5vw"}}
   [:div.carousel-inner {:style {:font-size "16pt"}}
    [:div.carousel-item.active
     [:div
      [restaurant]]]
    [:div.carousel-item 
      [mooncake]]
    [:div.carousel-item {:style {:align-self "center"}}
      [shop-icon]]
    [:a.carousel-control-prev {:href "#artCarousel"
                               :role "button"
                               :data-slide "prev"}
     [:span.carousel-control-prev-icon {:aria-hidden "true"}]
     [:span.sr-only "Previous"]]
    [:a.carousel-control-next {:href "#artCarousel" :role "button" :data-slide "next"}
     [:span.carousel-control-next-icon {:aria-hidden "true"}]
     [:span.sr-only "Next"]]]])


(defn carousel-component [project]
  (case project
    :comp [comp-carousel]
    #_#_:cos [cos-carousel]
    #_#_:cont [cont-carousel]
    #_#_:card [c-carousel]
    [:div "No carousel available"]))

(defn art-heading []
  [:div.art-heading-table
   [:div.art-heading-table-row
    {:style {:display "art-heading-table-row"}}
    [:div.sp-art-heading-column {:style {:margin-left "4vw"}}
     [:div.art-heading-table-row {:style {:gap "5vw"}}
      [:div.sp-art-heading-cell
       [:a {:href "#comp" :on-click #(reset! current-drawings :comp)}
        "Computer Art"]]]
     #_#_[:div.sp-art-heading-cell
          [:a {:href "#cos" :on-click #(reset! current-project :cos)}
           "\"Cosminis\""]]
       [:div.art-heading-table-row {:style {:gap "5vw"}}
        #_#_[:div.sp-art-heading-cell
             [:a {:href "#cont" :on-click #(reset! current-project :cont)}
              "Contacts Application"]]
          [:div.sp-art-heading-cell
           [:a {:href "#card" :on-click #(reset! current-project :card)}
            "C / Arduino / Java"]]]]]])

(defn art-table []
  [:div.art-container
   [:div.art-table-wrapper
    [:div.art-table
     [:div.table-row
      {:style {:display "table-row"}}
      [:div.table-cell
       {:style {:display "table-cell"
                :padding "10px"
                :text-align "center"}}
       [carousel-component @current-drawings]]
      [:div.table-cell
       {:style {:display "table-cell"
                :padding "10px"
                :text-align "center"}}
       [art-heading]
       [:p (nth txt/art-desc 1)]]]]]])

(defn art-container []
  [:div.art-canvas
   [:div.art-intro
    [:h1 "Art"]
    [:p (nth txt/art-desc 0)]]
   [:div.art-content
    [art-table]]])