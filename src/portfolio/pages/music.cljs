(ns portfolio.pages.music
  (:require [portfolio.helpers.texts :as txt]))

(defn audio-player [src title]
  [:div.audio-player {:style {:margin-top "5vh"}}
   [:h4 title]
   [:audio {:controls true
            :style {:width "30vw"}}
    [:source {:src src :type "audio/mpeg"}]
    "Your browser does not support the audio element."]])

(def audio-files
  [{:src "/assets/ADayInTokyo.mp3" :title "\"A Day in Tokyo\""}
   {:src "/assets/CastlevaniaLike.mp3" :title "\"Castlevania-Like-Like\""}])

(defn audio-gallery []
  [:div
   (for [{:keys [src title]} audio-files]
     [audio-player src title])])

(defn music-container []
  [:div.mus-content
   [:h1 "Music"] 
   [audio-gallery]
   [:p txt/music-history]
   [:p txt/music-study]
   [:p txt/musical-influences]])