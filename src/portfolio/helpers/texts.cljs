(ns portfolio.helpers.texts)


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                        ;               home                  ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

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
   "Develop emerging technologies with an emphasis on human rights and ecological sustainability."
   "Public relations regarding emerging technologies - speaking to the public about the opportunities,\n and ramifications of these technological developments."])

(defn goals-list []
  [:div {:style {:padding-left "15%"
                 :padding-right "15%"}}
   [:h4 {:style {:text-align "center%"}} "My Mission"]
   [:ol {:style {:margin-left "10vw"}}
    (for [item goals]
      [:li item])]])


(defn home-text-carousel []
  [:div.home.text.carousel {:id "homeCarousel"
                            :data-ride "tcarousel"
                            :class "carousel slide"}
   [:div.carousel-inner
    [:div.carousel-item.active
     [:div.hometext {:style {:padding-left "15%"
                             :padding-right "15%"}}
      [:h5 "Hello and welcome to my portfolio website!"]
      [:p {:style {:padding-left "15%"
                   :padding-right "15%"}}
       home-text]]]
    [:div.carousel-item
     [:div.mission {:style {:margin-left "13vw"}}
      [goals-list]]]
    [:a.carousel-control-prev {:href "#homeCarousel" :role "button" :data-slide "prev"}
     [:span.carousel-control-prev-icon {:aria-hidden "true"}]
     [:span.sr-only "Previous"]]
    [:a.carousel-control-next {:href "#homeCarousel" :role "button" :data-slide "next"}
     [:span.carousel-control-next-icon {:aria-hidden "true"}]
     [:span.sr-only "Next"]]]])







;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                        ;                Bio                  ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


(def bio 
  "Lorelai Lyons - general background
   I have a bachelors degree in music education.

   After my first year of college I decided to join the military as a way to fund the rest of my education. 
   In between this first year of college and my military enlistment I also changed from a programming major 
   to a music major at Holyoke Community College and began studying with the first university 
   guitar professor she would learn under: Phillip de Fremery. Phillip would be one of four teachers 
   I would learn from who was directly taught by prolific guitarist Andres Segovia.

   Lorelai uses her wide variety of skills in her current work with people struggling in the pursuit 
   of their individual flourishing by encouraging  and empowering creative expression and sharing 
   her own personal and professional experience in a mutual way to help people overcome addition, 
   trauma, and the gamut of mental health issues resultant from an oppressive society.")