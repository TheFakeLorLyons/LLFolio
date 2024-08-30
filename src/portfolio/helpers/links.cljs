(ns portfolio.helpers.links)

(defn github []
  [:a.btn.btn-primary
   {:data-mdb-ripple-init true
    :style {:background-color "#333333"}
    :href "#!"
    :role "button"}
   [:i.fab.fa-github]])