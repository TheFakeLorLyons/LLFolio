(ns portfolio.helpers.assets)

(defn bio-image-carousel []
  [:div.bio.image.carousel {:id "imageCarousel" :data-ride "icarousel"}
   [:div.carousel-inner
    [:div.carousel-item.active
     [:img.d-block.w-100 {:src "assets/mepiano3.jpg" :alt "First slide"}]]
    [:div.carousel-it-liste
     [:img.d-block.w-100 {:src "assets/hiking-worm.jpg" :alt "Second slide"}]]]
   [:a.carousel-control-prev {:href "#carouselExampleControls" :role "button" :data-slide "prev"}
    [:span.carousel-control-prev-icon {:aria-hidden "true"}]
    [:span.sr-only "Previous"]]
   [:a.carousel-control-next {:href "#carouselExampleControls" :role "button" :data-slide "next"}
    [:span.carousel-control-next-icon {:aria-hidden "true"}]
    [:span.sr-only "Next"]]])

(comment
  ;drawings
  ;sisters and me

  )