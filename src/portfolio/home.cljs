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

(defn mobile-banner []
  [:img {:src "/assets/images/mobilebanner.png"
         :style {:position "absolute"
                 :height "25%"
                 :transform "translate(30vw, -23vh)"
                 :scale "60%"
                 :z-index 0}}])

(defn clj-logo []
  [:img {:src "/assets/images/cljicon.png"
         :id "clj-icon"
         :style {:position "fixed"
                 :top "0"
                 :right "0"
                 :margin "10px"
                 :scale "75%"
                 :display (if (= (:display-content @page/state) :landing) "block" "none")}}])

(defn reagent-icons []
  [:div
   [:img {:src "/assets/images/reagenticon2.png"
          :id "reagent-icon2"
          :style {:position "fixed"
                  :bottom "4vh"
                  :left "4vw"
                  :margin "10px"
                  :display (if (= (:display-content @page/state) :landing) "block" "none")}}]
   [:img {:src "/assets/images/reagenticon.png"
          :id "reagent-icon"
          :style {:position "fixed"
                  :bottom "4vh"
                  :left "4vw"
                  :margin "10px"
                  :display (if (= (:display-content @page/state) :landing) "block" "none")}}]])

(defn mob-reagent-icons []
  [:div
   [:img {:src "/assets/images/reagenticon2.png"
          :id "reagent-icon2"
          :style {:position "fixed"
                  :margin-left ".5vh"
                  :height "40px"
                  :width "40px"
                  :display (if (= (:display-content @page/state) :landing) "block" "none")}}]
   [:img {:src "/assets/images/reagenticon.png"
          :id "reagent-icon"
          :style {:position "fixed"
                  :margin-left ".5vh"
                  :height "40px"
                  :width "40px"
                  :display (if (= (:display-content @page/state) :landing) "block" "none")}}]])


(defn menu-button []
  [:button
   {:class (when (not (:menu-open @page/state)) "visible")
    :on-click #(swap! page/state update :menu-open not)
    :style {:margin "20px"
            :height "30px"
            :width "30px"
            :border "1pt solid #312c3685"}}
   "λ"])

(defn mob-clj-logo []
  [:img {:src "/assets/images/cljicon.png"
         :id "clj-icon"
         :on-click #(swap! page/state update :menu-open not)
         :style {:margin "2vh"
                 :cursor "pointer"
                 :height "40px"
                 :width "40px"
                 :opacity (if (not (:menu-open @page/state)) 1
                              0)}}])

(defn mob-r-logo []
  [:img {:src "/assets/images/ricon.png"
         :id "clj-icon"
         :on-click #(swap! page/state update :menu-open not)
         :style {:cursor "pointer"
                 :height "40px"
                 :width "40px"
                 :opacity (if (not (:menu-open @page/state)) 0
                              1)}}])
(defn back-button []
  [:div
   [:button.back-button
    {:on-click #(swap! page/state update :menu-open not)
     :style {:height "30px"
             :width "30px"
             :border "1pt solid #312c3685"}}
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

(defn mob-sidebar []
  [:div.mob-sidebar
   {:class (when (:menu-open @page/state) "visible")
    :style (:sidebar @page/current-styles)}
   [mob-r-logo]
   [menu]])

(defn footer []
  [:div.footer
   [:div "Lorelai Lyons - Updated Dec 2024"]
   [:div
    (when (@page/state :mobile)
      [mob-reagent-icons])
    [lnk/footer-links]]])

(defn heading []
  [:div.heading
   (if (@page/state :mobile) [mob-clj-logo]
       [menu-button])])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                        ;              content                ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn landing []
  [:div.landing-content
   [:div.title
    [:h1 {:style {:font-weight "bold"}}
     "Lorelai Lyons"]
    [:h4 {:style {:opacity "50%"}}
     "Programming / Design / Communication"]
    [clj-logo]]
   [:div.landing-container
    [txt/home-text-carousel]]
   [reagent-icons]])

(defn mob-landing []
  [:div.landing-content
   [:div.title
    [:h3 {:style {:font-weight "bold"}}
     "Lorelai Lyons"]
    [:h6 {:style {:opacity "50%"}}
     "Programming & Design"]]
   [:div.landing-container
    [txt/mob-home-text-carousel]]])

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

(defn mob-main-view-container []
  [:div.main-content
   (case (:display-content @page/state)
     :landing [mob-landing]
     :bio [b/bio]
     :rcv [rcv/rcvs]
     :prg [prg/programming-container]
     :mus [mus/music-container]
     :art [art/art-container]
     :wrt [wrt/writing-container]
     :contact [email/mob-contact-form]
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

(defn mob-frame []
  [:div.layout {:style (:main @page/current-styles)}
   [heading]
   (when (= (:display-content @page/state) :landing)
     [mobile-banner])
   [:div.interactivity
    (if (:menu-open @page/state)
      [mob-sidebar]
      nil)
    [mob-main-view-container]]
   [footer]])

(defn is-mobile? []
  (let [user-agent (.-userAgent js/navigator)]
    (println "User Agent:" user-agent)
    (cond
      (re-find #"Mobi" user-agent) true
      (re-find #"Android" user-agent) true
      (re-find #"iPhone" user-agent) true
      (re-find #"iPad" user-agent) true
      :else false)))

(defn ^:dev/after-load start []
  (reset! page/state (assoc @page/state :mobile (is-mobile?)))
  (js/console.log (str @page/state))
  (if (:mobile @page/state)
    (rdom/render [mob-frame] (.getElementById js/document "app"))
    (rdom/render [frame] (.getElementById js/document "app"))))

(start)