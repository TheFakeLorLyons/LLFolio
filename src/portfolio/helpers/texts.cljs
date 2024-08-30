(ns portfolio.helpers.texts)

(def home-text 
  "My name is Lorelai (or Lor or Laura). 
   This website provides a glimpse into my life and work, 
   as well as a way to reach out for networking and partnership. 
   Enjoy perusing the examples of my wide ranging work, 
   feel free to reach out using the contact form on the menu,
   or any of the links at the bottom of the page.")

(def goals
  ["Utilize emerging technologies in exciting, novel ways."
   "Ensure equity and accessibility of said technologies."
   "Assist in the oversight of emerging technologies with an emphasis on human rights and ecological sustainability."
   "Act as a spokesperson and educator regarding emerging technologies - speaking to the public about the opportunities, and ramifications of these technological developments."])

(defn goals-list []
  [:div
   [:ol
    (for [item goals]
      [:li item])]])


(defn home-text-carousel []
  [:div.home.text.carousel {:id "homeCarousel" :data-ride "tcarousel"}
   [:div.carousel-inner 
    [:div.carousel-item.active
     [:h4 {:style {:padding-bottom "10vh"}}
      "Welcome"]]
    [:div.carousel-it-list
     [:div.carousel-item
      [:div.hometext
       [:h5 "Hello and welcome to my portfolio website!"]
       [:p {:style {:padding-top "1vh"}}
        home-text]]]
     [:div.carousel-item
      [:div.mission
       [:h4 "My Mission"]
       [goals-list]]]]
    [:a.carousel-control-prev {:href "#homeCarousel" :role "button" :data-slide "prev"}
     [:span.carousel-control-prev-icon {:aria-hidden "true"}]
     [:span.sr-only "Previous"]]
    [:a.carousel-control-next {:href "#homeCarousel" :role "button" :data-slide "next"}
     [:span.carousel-control-next-icon {:aria-hidden "true"}]
     [:span.sr-only "Next"]]]])