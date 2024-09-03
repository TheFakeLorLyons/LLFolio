(ns portfolio.home
  (:require [reagent.core :as r]
            [reagent.dom :as rdom]
            [portfolio.helpers.texts :as txt]
            [portfolio.helpers.links :as lnk]
            [portfolio.pages.bio :as b]
            [portfolio.pages.rcv :as rcv]
            [portfolio.pages.programming :as prg]
            [portfolio.pages.music :as mus]
            [portfolio.pages.art :as art]
            [portfolio.pages.writing :as wrt]
            [portfolio.helpers.pages :as page]
            [portfolio.helpers.email :as email]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                        ;            buttons/misc             ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn menu-button []
  [:button 
   {:class (when (not (:menu-open @page/state)) "visible")
    :on-click #(swap! page/state update :menu-open not)
    :style {:margin "20px"
            :border "1pt solid #312c36"}}
   ">>"])

(defn back-button []
  [:div
   [:button 
    {:on-click #(swap! page/state update :menu-open not)}
    "<<"]])

(defn menu []
  [:div
   [page/page-list]])

(defn sidebar []
  [:div.sidebar
   {:class (when (:menu-open @page/state) "visible")
     :style (:sidebar @page/current-styles)}
   [back-button]
   [menu]])

(defn footer []
  [:div.footer
   [:div "Lorelai Lyons - Updated Sep 2024"]
   [lnk/footer-links]])

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
   (case (:display-content @page/state)
     :landing [landing]
     :bio [b/bio]
     :rcv [rcv/rcvs]
     :prg [prg/programming-container]
     :mus [mus/music-container]
     :art [art/art-container]
     :wrt [wrt/writing-container]
     :contact [email/contact-form]
     [:div "Please select a page."])])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                        ;             main-frame              ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn frame []
  [:div.layout {:style (:main @page/current-styles)}
   [heading]
   [:div.interactivity
    (if (:menu-open @page/state)
      [sidebar]
      nil)
    [main-view-container]]
   [footer]])

(defn ^:dev/after-load start []
  (rdom/render [frame]
               (.getElementById js/document "app")))

(start)