(ns portfolio.pages.music
  (:require [reagent.core :as r]
            [portfolio.helpers.pages :as page]
            [portfolio.helpers.texts :as txt]))

(defonce display-text (r/atom :m-history))

(defn audio-player [src title]
  [:div.audio-player
   [:h4 title]
   [:audio {:controls true
            :style {:width "30vw"}}
    [:source {:src src :type "audio/mpeg"}]
    "Your browser does not support the audio element."]])

(defn piano-guitar-drawing []
  [:div {:style {:width "10vw" ; Adjust width as needed
                 :height "auto" ; Keep aspect ratio
                 :display "block"}}
   [page/zoomable-image "/assets/drawings/guitar-piano.png" "gpd" "20vw"]])

(def audio-files
  [{:src "/assets/music/ADayInTokyo.mp3" :title "\"A Day in Tokyo\""}
   {:src "/assets/music/CastlevaniaLike.mp3" :title "\"Castlevania-Like-Like\""}])

(def guitar-recording
  [{:src "assets/music/senior-recital.mp3" :title "\"My senior Recital\""}
   {:src "assets/music/barrios-confesion.m4a" :title "\"Confesión - Barrios\""}])

(def other-songs
  [{:src "assets/music/vals-en-skai.m4a" :title "\"Vals en Skai - Roland Dyens\""}
   {:src "assets/music/tarantelle.m4a" :title "\"Tarantelle - Johann Mertz\""}])

(defn audio-gallery [music-to-play]
  [:div {:style {:display "flex"
                 :flex-direction "column"
                 :gap "4vh"
                 :margin-top "2vh"
                 :font-size 14}}
   (for [{:keys [src title]} music-to-play]
     [audio-player src title])])


(defn mus-carousel []
  [:div.carousel {:id "musCarousel"
                  :data-ride "tcarousel"
                  :class "carousel slide"
                  :style {:display "flex"
                          :justify-content "center"
                          :align-items "center"}}
   [:div.carousel-inner {:style {:display "flex"
                                 :font-size "16pt"
                                 :height "500px"}}
    [:div.carousel-item.active {:style {:margin-bottom "4vh"}}
     [:h5 {:style {:font-weight "bold"}} "Chiptune Clips"]
     [audio-gallery audio-files]]
    [:div.carousel-item
     [:iframe {:allow "autoplay"
               :allowfullscreen true
               :height "500px"
               :src "https://www.noteflight.com/music/title_embed/36aae8e7-b459-4b21-b093-2540ded4ddc5/et-la-lune-descend-sure-le-temple-qui-fut?"}
      "Your browser does not support iframes."]]
    [:div.carousel-item {:style {:margin-bottom "4vh"}}
     [:h6 {:style {:font-weight "bold"}} "Guitar music from my undergraduate studies"]
     [audio-gallery guitar-recording]]
    [:div.carousel-item
     [:iframe {:allow "autoplay"
               :width "80%"
               :height "350px"
               :scrolling "no"
               :frameborder "no"
               :src txt/soundcloud-link}
      "Your browser does not support iframes."]]
    [:div.carousel-item {:style {:margin-bottom "4vh"}}
     [:h5 {:style {:font-weight "bold"}} "Some other songs I love"]
     [audio-gallery other-songs]
     [:a {:href txt/google-drive-link
          :target "_blank"
          :rel "noopener noreferrer"
          :style {:font-size 14}}
      txt/google-drive-link-text]]
    [:a.carousel-control-prev {:href "#musCarousel"
                               :role "button"
                               :data-slide "prev"}
     [:span.carousel-control-prev-icon {:aria-hidden "true"}]
     [:span.sr-only "Previous"]]
    [:a.carousel-control-next {:href "#musCarousel" :role "button" :data-slide "next"}
     [:span.carousel-control-next-icon {:aria-hidden "true"}]
     [:span.sr-only "Next"]]]])

(defn text-content [project]
  (case project
    :m-history txt/music-history
    :m-teachers txt/music-study
    :m-influences txt/musical-influences
    "No content available"))

(defn mus-table []
  [:div.mus-container
   [:div.mus-table-wrapper
    [:div.table-row
     {:style {:display "flex"
              :width "100%"
              :height "100%"
              :gap "3vw"
              :align-items "center"}}
     [:div.mus-table-cell
      {:style {:display "table-cell"}}
      [mus-carousel]]
     [:div.mus-table-cell {:style {:display "table-cell"}}
      [:div.mus-heading {:style
                         {:display "flex"
                          :gap "2vw"
                          :justify-content "center"}}
       [:a {:href "#music-background" :on-click #(reset! display-text :m-history)
            :color "#fff678"} "Musical Background"]
       [:a {:href "#teachers" :on-click #(reset! display-text :m-teachers)
            :color "#fff678"} "Teachers"]
       [:a {:style {:margin-bottom "3vh"}
            :href "#influences" :on-click #(reset! display-text :m-influences)
            :color "#fff678"} "Musical Influences"]]
      (when (= @display-text :m-history)
        [:h4 {:style {:margin-top "1vh"}}
         "I studied classical guitar and piano..."])
      (for [line (text-content @display-text)]
        ^{:key line} ;; Use a unique key for each item
        [:p {:style {:font-size 18}} line])
      (when (= @display-text :m-teachers) 
        [:div {:style {:display "flex"
                       :justify-content "center"}}
         [piano-guitar-drawing]])]]]])

(defn music-container []
  [:div.mus-content 
   [:h1 "Music"] 
   #_[r-icon];maybe another language pic?
   [mus-table]])