(ns portfolio.pages.bio
  (:require [portfolio.helpers.texts :as txt]))

(defn piano-picture []
  [:img {:src "/assets/me&piano.png" :alt "Logo" :style {:width "400px" :height "auto"}}])
(defn hiking-worm []
  [:img {:src "/assets/hiking-worm.jpg" :alt "Logo" :style {:width "400px" :height "auto"}}])
(defn never-give-up []
  [:img {:src "/assets/nevergiveup.png" :alt "Logo" :style {:width "300px" :height "auto"}}])

(defn bio-table []
  [:div.bio-container
   [:div.bio-table-wrapper
    [:div.bio-table
     [:div.table-row
      {:style {:display "table-row"}}
      [:div.table-cell
       {:style {:display "table-cell"
                :padding "10px"
                :text-align "center"}}
       [hiking-worm]]
      [:div.table-cell
       {:style {:display "table-cell"
                :padding "10px"
                :text-align "center"}}
       [:p "This is the bio page content."]]]
     [:div.table-row
      {:style {:display "table-row"}}
      [:div.table-cell
       {:style {:display "table-cell"
                :padding "10px"
                :text-align "center"}}
       [:p "This is the text for the second row."]]
      [:div.table-cell
       {:style {:display "table-cell"
                :padding "10px"
                :text-align "center"}}
       [never-give-up]]]
     [:div.table-row
      [:div.table-row
       {:style {:display "table-row"}}
       [:div.table-cell
        {:style {:display "table-cell"
                 :padding "10px"
                 :text-align "center"}}
        [piano-picture]]
       [:div.table-cell
        {:style {:display "table-cell"
                 :padding "10px"
                 :text-align "center"}}
        [:p "This is the text for the third row."]]]]]]])

(defn bio []
  [:div.bio-content {:style {:align-items "center"}}
   [:h1 "Bio"]
   [:p "This is the bio page content."]
   [bio-table]])