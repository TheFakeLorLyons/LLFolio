(ns portfolio.helpers.links)

(defn github []
  [:a.btn.btn-primary
   {:data-mdb-ripple-init true
    :style {:background-color "rgb(1, 0, 1, 0.6)"
            :border "none"}
    :href "https://github.com/TheFakeLorLyons"
    :role "button"}
   [:i.fab.fa-github]])

(defn linkedIn []
  [:a.btn.btn-primary
   {:data-mdb-ripple-init true
    :style {:background-color "rgb(1, 0, 1, 0.6)"
            :color "rgb(0, 130, 202, 0.6)"
            :border "none"
            :transform "scale(65%)translateY(2.2px)"}
    :href "https://www.linkedin.com/in/lor-lyons-a7a99824b/"
    :role "button"}
   [:i.fab.fa-linkedin-in.fa-2x]])

(defn soundCloud []
  [:a.btn.btn-primary
   {:data-mdb-ripple-init true
    :style {:background-color "rgb(1, 0, 1, 0.6)"
            :color "rgb(0, 130, 202, 0.6)"
            :border "none"}
    :href "https://soundcloud.com/lor-lyons"
    :role "button"}
   [:img {:src "/assets/scicon.png"
          :alt "SoundCloud"
          :width "22px"
          :height "22px"}]])

(defn noteFlight []
  [:a.btn.btn-primary
   {:data-mdb-ripple-init true
    :style {:background-color "rgb(1, 0, 1, 0.6)"
            :color "rgb(0, 130, 202, 0.6)"
            :border "none"}
    :href "https://www.noteflight.com/profile/b77eb5ec9a4143484cb9c2f48212e302d6c1ecde"
    :role "button"}
   [:img {:src "/assets/noteflight-icon.svg"
          :alt "noteFlight"
          :width "22px"
          :height "22px"}]])

(defn slack []
  [:a.btn.btn-primary
  {:data-mdb-ripple-init true
   :style {:background-color "rgb(1, 0, 1, 0.6)"
           :color "rgb(0, 130, 202, 0.6)"
           :border "none"
           :transform "scale(65%)translateY(2.2px)"}
   :href "https://www.linkedin.com/in/lor-lyons-a7a99824b/"
   :role "button"}
  [:i.fab.fa-slack-hash.fa-2x]])

(defn footer-links []
  [:div.footer-links
   [github]
   [linkedIn]
   [soundCloud]
   [noteFlight]
   [slack]])