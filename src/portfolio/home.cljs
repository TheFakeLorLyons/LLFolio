(ns portfolio.home
  (:require [reagent.core :as r]
            [reagent.dom :as rdom]
            [portfolio.helpers.texts :as txt]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                        ;                state                ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def state (r/atom {:menu-open false
                    :display-content :landing}))

(def pages [[:a {:href "#home"} "Home"]
            [:a {:href "#bio"} "Bio"]])

(defn page-list []
  [:div.page-list
   [:ol
    (for [item pages]
      [:li item])]])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                        ;            buttons/misc             ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn menu-button []
  [:button 
   {:class (when (not (:menu-open @state)) "visible")
    :on-click #(swap! state update :menu-open not)
    :style {:margin "20px"}}
   ">>"])

(defn back-button []
  [:div
   [:button 
    {:on-click #(swap! state update :menu-open not)}
    "<<"]])

(defn menu []
  [:div
   [page-list]])

(defn sidebar []
  [:div.sidebar
   {:class (when (:menu-open @state) "visible")}
   [back-button]
   [menu]])

(defn footer []
  [:div.footer
   [:div "Lorelai Lyons 2024"]])

(defn heading []
  [:div.heading
     [menu-button]])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                        ;              content                ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn landing []
  [:div.landing-content
   [:div.title
    [:h1 {:style {:font-weight "bold"}}
     "Lorelai Lyons"]
    [:h4 {:style {:opacity "50%"}}
     "Programming"]]
   [:div.landing-container
    [txt/home-text-carousel]]])

(defn main-view-container []
   [:div.main-content
    (when (= (:display-content @state) :landing)
      [landing])])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                        ;             main-frame              ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn frame []
  [:div.layout
   [heading]
   [:div.interactivity
    (if (:menu-open @state)
      [sidebar]
      nil)
    [main-view-container]]
   [footer]])

(defn ^:dev/after-load start []
  (rdom/render [frame]
               (.getElementById js/document "app")))

(start)