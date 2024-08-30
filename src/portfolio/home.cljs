(ns portfolio.home
  (:require [reagent.core :as r]
            [reagent.dom :as rdom]
            [portfolio.texts :as txt]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                        ;                state                ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def state (r/atom {:menu-open false
                    :display-content :landing}))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                        ;            buttons/misc             ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn menu-button []
  [:button 
   {:class (when (not (:menu-open @state)) "visible")
    :on-click #(swap! state update :menu-open not)
    :style {:margin "20px"}}
   "Menu"])

(defn back-button []
  [:div
   [:button 
    {:on-click #(swap! state update :menu-open not)}
    "<<"]])

(defn menu []
  [:div
   [:p "Here is the list"]])

(defn sidebar []
  [:div.sidebar
   {:class (when (:menu-open @state) "visible")}
   [back-button]
   [menu]])

(defn footer []
  [:div.footer
   [:div "Lorelai Lyons 2024"]
   [:div {:style {:display "flex" :gap "1vh"}}
    [:a {:href "#home"} "Home"]
    [:a {:href "#bio"} "Bio"]]])

(defn heading []
  [:div.heading
     [menu-button]])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                        ;              content                ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn landing []
  [:div.landing-content
   [:div.title
    [:h1 {:style {:font-family "Fira Sans"}}
     "Lorelai Lyons"]
    [:h2
     "Programming"]]
   [:div.landing-container
    [:h "Multi-disciplinary creator, innovator, and educator. "]
    [:p txt/home-text]]])

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