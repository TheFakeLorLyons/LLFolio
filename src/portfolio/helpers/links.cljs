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