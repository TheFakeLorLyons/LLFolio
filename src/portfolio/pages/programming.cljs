(ns portfolio.pages.programming
  (:require  [reagent.core :as r]
             [portfolio.helpers.pages :as page]
             [portfolio.helpers.texts :as txt]))

(defonce current-project (r/atom :pw))

(defn calva-logo []
  [:img {:src "/assets/images/calvaicon.png"
         :id "clj-icon"
         :style {:position "fixed"
                 :top "3vh"
                 :right "2vw"
                 :margin "10px"
                 :display (if (= (:display-content @page/state) :prg) "block" "none")}}])

(defn mob-calva-logo []
  [:img {:src "/assets/images/calvaicon.png"
         :id "clj-icon"
         :style {:position "fixed"
                 :top "0vh"
                 :right "0vw"
                 :height "80px"
                 :width "80px" 
                 :display (if (= (:display-content @page/state) :prg) "block" "none")}}])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                        ;            image assets             ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;pw-manager
(defn pw-login []
  [:div
   (if (@page/state :mobile)
     [page/zoomable-image "/assets/lpm.jpg" "pw-login" "140%"]
     [page/zoomable-image "/assets/lpm.jpg" "pw-login" "35vw"])])
(defn pw-home []
  [:div
   (if (@page/state :mobile)
     [page/zoomable-image "/assets/lpmpwhome.jpg" "pw-home" "100%"]
     [page/zoomable-image "/assets/lpmpwhome.jpg" "pw-home" "35vw"])])
(defn pw-encrypted []
  [:div
   (if (@page/state :mobile)
     [page/zoomable-image "/assets/encryptedpws.jpg" "pw-enc" "100%"]
     [page/zoomable-image "/assets/encryptedpws.jpg" "pw-enc" "35vw"])])

;cosminis
(defn cos-erd []
  [:div
   (if (@page/state :mobile)
     [page/zoomable-image "/assets/cosminis-pics/Cosminis-ERD.png" "cos-erd" "100%"]
     [page/zoomable-image "/assets/cosminis-pics/Cosminis-ERD.png" "cos-erd" "35vw"])])
(defn cos-all-cos []
  [:div
   (if (@page/state :mobile)
     [page/zoomable-image "/assets/cosminis-pics/all-companions.png" "cos-all-cos" "100%"]
     [page/zoomable-image "/assets/cosminis-pics/all-companions.png" "cos-all-cos" "35vw"])])
(defn cos-friends []
  [:div
   (if (@page/state :mobile)
     [page/zoomable-image "/assets/cosminis-pics/friends-page.png" "cos-friends" "100%"]
     [page/zoomable-image "/assets/cosminis-pics/friends-page.png" "cos-friends" "35vw"])])
(defn cos-order-hist []
  [:div
   (if (@page/state :mobile)
     [page/zoomable-image "/assets/cosminis-pics/orderHistory.png" "cos-order-hist" "100%"]
     [page/zoomable-image "/assets/cosminis-pics/orderHistory.png" "cos-order-hist" "35vw"])])
(defn cos-purchase-conf []
  [:div
   (if (@page/state :mobile)
     [page/zoomable-image "/assets/cosminis-pics/purchaseConfirmation.png" "cos-purchase-conf" "100%"]
     [page/zoomable-image "/assets/cosminis-pics/purchaseConfirmation.png" "cos-purchase-conf" "35vw"])])
(defn cos-purchases []
  [:div
   (if (@page/state :mobile)
     [page/zoomable-image "/assets/cosminis-pics/purchases.png" "cos-purchases" "100%"]
     [page/zoomable-image "/assets/cosminis-pics/purchases.png" "cos-purchases" "35vw"])])
(defn cos-filled-purch []
  [:div
   (if (@page/state :mobile)
     [page/zoomable-image "/assets/cosminis-pics/purchasespopulated.png" "cos-filled-purch" "100%"]
     [page/zoomable-image "/assets/cosminis-pics/purchasespopulated.png" "cos-filled-purch" "35vw"])])

;contacts-application
(defn cont-main []
  [:div
   (if (@page/state :mobile)
     [page/zoomable-image "/assets/contacts/cont-main.png" "cont-main" "100%"]
     [page/zoomable-image "/assets/contacts/cont-main.png" "cont-main" "35vw"])])
(defn cont-edit-1 []
  [:div
   (if (@page/state :mobile)
     [page/zoomable-image "/assets/contacts/cont-edit-1.png" "cont-edit1" "100%"]
     [page/zoomable-image "/assets/contacts/cont-edit-1.png" "cont-edit1" "35vw"])])
(defn cont-edit-2 []
  [:div
   (if (@page/state :mobile)
     [page/zoomable-image "/assets/contacts/cont-edit-2.png" "cont-edit2" "100%"]
     [page/zoomable-image "/assets/contacts/cont-edit-2.png" "cont-edit2" "35vw"])])

;data-vis
(defn apples3d []
  [:div
   (if (@page/state :mobile)
     [page/zoomable-image "/assets/data/apples3d.png" "apples3d" "100%"]
     [page/zoomable-image "/assets/data/apples3d.png" "apples3d" "35vw"])])
(defn apples2d []
  [:div
   (if (@page/state :mobile)
     [page/zoomable-image "/assets/data/apples2d.svg" "apples2d" "100%"]
     [page/zoomable-image "/assets/data/apples2d.svg" "apples2d" "35vw"])])
(defn lgbt-stats1 []
  [:div
   (if (@page/state :mobile)
     [page/zoomable-image "/assets/data/lgbt-stats1.png" "lgbt-stats1" "100%"]
     [page/zoomable-image "/assets/data/lgbt-stats1.png" "lgbt-stats1" "25vw"])])
(defn lgbt-stats2 []
  [:div
   (if (@page/state :mobile)
     [page/zoomable-image "/assets/data/lgbt-stats2.png" "lgbt-stats2" "100%"]
     [page/zoomable-image "/assets/data/lgbt-stats2.png" "lgbt-stats2" "30vw"])])
(defn lgbt-stats3 []
  [:div
   (if (@page/state :mobile)
     [page/zoomable-image "/assets/data/lgbt-stats3.png" "lgbt-stats3" "100%"]
     [page/zoomable-image "/assets/data/lgbt-stats3.png" "lgbt-stats3" "25vw"])])

;c-projects
(defn ard-buzz []
  [:video {:width "33%"
           :controls true}
   [:source {:src "/assets/vids/arduino-buzzer.mov"
             :type "video/mp4"}]
   "Your browser does not support the video tag."])
(defn ard-lights []
  [:video {:width "90%"
           :style {:transform "translateY(4.5vh)"}
           :controls true}
   [:source {:src "/assets/vids/arduino-lights.mov"
             :type "video/mp4"}]
   "Your browser does not support the video tag."])
(defn nbodies []
  [:video {:width "90%"
           :style {:transform "translateY(4.5vh)"}
           :controls true}
   [:source {:src "/assets/vids/nbodies.mov"
             :type "video/mp4"}]
   "Your browser does not support the video tag."])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                        ;             slideshows              ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn pw-carousel []
  [:div.home.text.carousel {:id "pwCarousel"
                            :data-ride "tcarousel"
                            :class "carousel slide"
                            :style {:display "flex"
                                    :justify-content "center"
                                    :align-items "center"
                                    :padding-right "5vw"}}
   [:div.carousel-inner {:style {:font-size "16pt"}}
    [:div.carousel-item.active
     [:div {:style {:transform "translateY(7.5vh)"}}
      [pw-login]]]
    [:div.carousel-item
     [:div {:style {:height "25vh"}}
      [pw-home]]]
    [:div.carousel-item
     [:div {:style {:transform "translateY(4.5vh)"}}
      [pw-encrypted]]]
    [:a.carousel-control-prev {:href "#pwCarousel"
                               :role "button"
                               :data-slide "prev"}
     [:span.carousel-control-prev-icon {:aria-hidden "true"}]
     [:span.sr-only "Previous"]]
    [:a.carousel-control-next {:href "#pwCarousel" :role "button" :data-slide "next"}
     [:span.carousel-control-next-icon {:aria-hidden "true"}]
     [:span.sr-only "Next"]]]])

(defn cos-carousel []
  [:div.cos.text.carousel {:id "cosCarousel"
                           :data-ride "tcarousel"
                           :class "carousel slide"
                           :style {:display "flex"
                                   :justify-content "center"
                                   :align-items "center"
                                   :padding-right "5vw"}}
   [:div.carousel-inner {:style {:font-size "16pt"}}
    [:div.carousel-item.active
     [:div.costext {:style {:transform "translateY(7.5vh)"}} [cos-erd]]]
    [:div.carousel-item
     [:div  {:style {:transform "translateY(4.5vh)"}} [cos-all-cos]]]
    [:div.carousel-item
     [:div {:style {:transform "translateY(4.5vh)"}} [cos-friends]]]
    [:div.carousel-item
     [:div {:style {:transform "translateY(4.5vh)"}} [cos-filled-purch]]]
    [:div.carousel-item
     [:div {:style {:transform "translateY(4.5vh)"}} [cos-order-hist]]]
    [:div.carousel-item
     [:div {:style {:transform "translateY(4.5vh)"}} [cos-purchase-conf]]]
    [:div.carousel-item
     [:div {:style {:transform "translateY(4.5vh)"}} [cos-purchases]]]
    [:a.carousel-control-prev {:href "#cosCarousel"
                               :role "button"
                               :data-slide "prev"
                               :style {:width "relative"}}
     [:span.carousel-control-prev-icon {:aria-hidden "true"}]
     [:span.sr-only "Previous"]]
    [:a.carousel-control-next {:href "#cosCarousel" :role "button" :data-slide "next"}
     [:span.carousel-control-next-icon {:aria-hidden "true"}]
     [:span.sr-only "Next"]]]])

(defn cont-carousel []
  [:div.cont.text.carousel {:id "contCarousel"
                            :data-ride "tcarousel"
                            :class "carousel slide"
                            :style {:display "flex"
                                    :justify-content "center"
                                    :align-items "center"
                                    :padding-right "5vw"}}
   [:div.carousel-inner {:style {:font-size "16pt"}}
    [:div.carousel-item.active
     [:div.conttext {:style {:transform "translateY(3vh)"}}
      [cont-main]]]
    [:div.carousel-item
     [:div {:style {:transform "translateY(3vh)"}}
      [cont-edit-1]]]
    [:div.carousel-item
     [:div {:style {:transform "translateY(3vh)"}}
      [cont-edit-2]]]
    [:a.carousel-control-prev {:href "#contCarousel"
                               :role "button"
                               :data-slide "prev"
                               :style {:width "relative"}}
     [:span.carousel-control-prev-icon {:aria-hidden "true"}]
     [:span.sr-only "Previous"]]
    [:a.carousel-control-next {:href "#contCarousel" :role "button" :data-slide "next"}
     [:span.carousel-control-next-icon {:aria-hidden "true"}]
     [:span.sr-only "Next"]]]])

(defn c-carousel []
  [:div.cont.text.carousel {:id "cCarousel"
                            :data-ride "tcarousel"
                            :class "carousel slide"
                            :style {:display "flex"
                                    :justify-content "center"
                                    :align-items "center"
                                    :padding-right "5vw"}}
   [:div.carousel-inner {:style {:font-size "16pt"}}
    [:div.carousel-item.active
     [:div.conttext
      [ard-buzz]]]
    [:div.carousel-item
     [:div
      [ard-lights]]]
    [:div.carousel-item
     [:div
      [nbodies]]]
    [:a.carousel-control-prev {:href "#cCarousel"
                               :role "button"
                               :data-slide "prev"
                               :style {:width "relative"}}
     [:span.carousel-control-prev-icon {:aria-hidden "true"}]
     [:span.sr-only "Previous"]]
    [:a.carousel-control-next {:href "#cCarousel" :role "button" :data-slide "next"}
     [:span.carousel-control-next-icon {:aria-hidden "true"}]
     [:span.sr-only "Next"]]]])

(defn prg-current-carousel []
  [:div.cont.text.carousel {:id "gCarousel"
                            :data-ride "tcarousel"
                            :class "carousel slide"
                            :style {:display "flex"
                                    :justify-content "center"
                                    :align-items "center"
                                    :padding-right "5vw"}}
   [:div.carousel-inner {:style {:font-size "16pt"}}
    [:div.carousel-item.active
     [lgbt-stats1]]
    [:div.carousel-item {:style {:padding-left "2.5vw"
                                 :padding-right "2.5vw"}}
     [:h6 {:style {:margin "1vh"}} "Works currently in progress"]
     [:div.conttext
      (for [line txt/prg-current-1]
        ^{:key line}
        [:p {:style {:font-size 18}} line])]]
    [:div.carousel-item {:style {:padding-left "2.5vw"
                                 :padding-right "2.5vw"}}
     [:h6 {:style {:margin "3vh"}} "Getting Involved with Sci-Cloj"]
     [:div
      (for [line txt/prg-current-2]
        ^{:key line}
        [:p {:style {:font-size 18}} line])]]
    [:div.carousel-item
     [lgbt-stats2]]
    [:div.carousel-item
     [lgbt-stats3]]
    [:div.carousel-item {:style {:padding-left "2.5vw"
                                 :padding-right "2.5vw"}}
     [:h6 {:style {:margin "3vh"}} "Things I'm studying"]
     [:div
      (for [line txt/prg-current-3]
        ^{:key line}
        [:p {:style {:font-size 18}} line])]]
    [:a.carousel-control-prev {:href "#gCarousel"
                               :role "button"
                               :data-slide "prev"
                               :style {:width "relative"}}
     [:span.carousel-control-prev-icon {:aria-hidden "true"}]
     [:span.sr-only "Previous"]]
    [:a.carousel-control-next {:href "#gCarousel" :role "button" :data-slide "next"}
     [:span.carousel-control-next-icon {:aria-hidden "true"}]
     [:span.sr-only "Next"]]]])

(defn prg-future-carousel []
  [:div.cont.text.carousel {:id "gCarousel"
                            :data-ride "tcarousel"
                            :class "carousel slide"
                            :style {:display "flex"
                                    :justify-content "center"
                                    :align-items "center"
                                    :padding-right "5vw"}}
   [:div.carousel-inner {:style {:font-size "16pt"}}
    [:div.carousel-item.active {:style {:margin-top "2.5vh"}}
     [apples3d]]
    [:div.carousel-item {:style {:padding-left "2.5vw"
                                 :padding-right "2.5vw"}}
     [:h6 {:style {:margin ".5vh"}} "Coming Attractions"]
     [:div.conttext {:style {:margin-top "1vh"}}
      (for [line txt/prg-future-1]
        ^{:key line}
        [:p {:style {:font-size 18}} line])]]
    [:div.carousel-item {:style {:margin-top "2.5vh"
                                 :padding-left "2.5vw"
                                 :padding-right "2.5vw"}}
     [:h6 {:style {:margin "3vh"}} "Mentoring and Volunteering"]
     [:div
      (for [line txt/prg-future-2]
        ^{:key line}
        [:p {:style {:font-size 18}} line])]]
    [:div.carousel-item {:style {:margin-top "2.5vh"}}
     [apples2d]]
    [:div.carousel-item {:style {:padding-left "2.5vw"
                                 :padding-right "2.5vw"}}
     [:h6 "Programming aspirations"]
     [:div
      (for [line txt/prg-future-3]
        ^{:key line}
        [:p {:style {:font-size 18}} line])]]
    [:a.carousel-control-prev {:href "#gCarousel"
                               :role "button"
                               :data-slide "prev"
                               :style {:width "relative"}}
     [:span.carousel-control-prev-icon {:aria-hidden "true"}]
     [:span.sr-only "Previous"]]
    [:a.carousel-control-next {:href "#gCarousel" :role "button" :data-slide "next"}
     [:span.carousel-control-next-icon {:aria-hidden "true"}]
     [:span.sr-only "Next"]]]])

(def pw-proj-info
  [[:a {:href "https://github.com/TheFakeLorLyons/password-manager" :target "_blank"}
    [:h5 {:style {:font-weight "bold"}} "Password Manager"]]
   "This Application allows users to perform basic CRUD operations on any number of
    passwords. Users could choose to export the passwords to an encrypted csv for 
    secure access later on. Also features basic random password generation."
   "Clojure/CLJS, Reagent, BuddyHashers, Javax Cipher/Encryption, BouncyCastle, figwheel,
    Flowstorm, shadow-cljs, Hiccup, CSS, JS, Calva"])

(def cos-proj-info
  [[:div [:h5 {:style {:font-weight "bold"}} "\"Cosminis\""]]
   "Cosminis is a gameified social media application that allowed users to interact
    with each other and their virtual companions in a digital metaverse. I was one of
    3 team leaders, and responsible for our payment screens and more."
   "C#, Typescript, Angular, Xunit, Moq, Jasmine, Karma, SonarCloud, Swagger
    SQL, Azure, NPM, Node.js, CSS, git/github, BASH, Notepad++"])

(def contacts-proj-info
  [[:a {:href "https://thefakelorlyons.github.io/contacts_manager.github.io/" :target "_blank"}
    [:h5 {:style {:font-weight "bold"}} "Contacts Application"]]
   "This is a contacts management appplication that I built using vanilla HTML and Javascript as well as CSS.
    It allows users to perform CRUD operations and have their entries stored in local storage, simulating a database."
   "Javascript, HTML, CSS, git/github, BASH, Notepad++"])

(def c-ard
  [[:a {:href "https://github.com/TheFakeLorLyons/C-Fall-2023" :target "_blank"}
    [:h5 {:style {:font-weight "bold"}} "C & Java Applications"]]
   "This is a collection of some of my academic work in C including dealing with bit manipulation and basic data
    structures including stacks and linked lists. Also included is my work in Java Data structures and arduino
    programming."
   "C, Java, JUnit, gcc, makefiles, vi, vim, github, PuTTY, VMs, IP addressing, Arduino, Arduino IDE, 
    Serial Data Processing, Sorting Algorithms, IntelliJ"])

(def in-prog
  [[:a {:href "https://github.com/TheFakeLorLyons/" :target "_blank"}
    [:h5 {:style {:font-weight "bold"}} "In Progress Applications and Study"]]
   "This website will continue to be a work in progress as I update it with alongside my education and career.
    I am currently continuing to practice my skills with Clojure and CLJSin several different applications mentioned
    in greater detail to the right."
   "Clojure/CLJS, Reagent, ReframeClay, Figwheel, Hiccup, Calva, Flowstorm, shadow-cljs, NPM, HTML, CSS, 
    git/github, BASH, Notepad++"])

(def fut-text
  [[:a {:href "https://github.com/TheFakeLorLyons/" :target "_blank"}
    [:h5 {:style {:font-weight "bold"}} "Future Interests and Goals"]]
   "My biggest passion is in constructing nice looking and user friendly interfaces for any client facing software.
    I am particularly interested in studying Brain-Computer interfaces and Brainflow, and hope to one day use Clojure
    to write BCI Applications."
   "Brainflow/OpenBCI, Unity/Gadot, Arduino, Clojures/CLJS, Reagent, Clay, shadow-cljs, NPM, HTML, CSS, Java, C++, C, 
    C#, Python, SQL"])


(defn text-content [project]
  (case project
    :pw pw-proj-info
    :cos cos-proj-info
    :cont contacts-proj-info
    :card c-ard
    :in-prog in-prog
    :future fut-text
    "No content available"))

(defn mob-pw-carousel []
  [:div.mob.prg.text.carousel {:id "mobpwCarousel"
                            :data-ride "tcarousel"
                            :class "carousel slide"
                            :style {:display "flex"
                                    :justify-content "center"
                                    :align-items "center"}}
   [:div.carousel-inner {:style {:font-size "16pt"
                                 :height "100%"
                                 :display "flex"
                                 :flex-direction "column"
                                 :justify-content "space-evenly"}}
    [:div.carousel-item.active {:style {:border-top "2pt solid #d8dcb1fb"}}
     [:div.mob-top-prg-inner-item
      [txt/pw-what-i-learned]]
     [:div.mob-top-prg-inner-item
      [pw-login]]]
    [:div.carousel-item {:style {:border-top "2pt solid #d8dcb1fb"}}
     [:div.mob-top-prg-inner-item
      [txt/pw-description]]
     [:div.mob-top-prg-inner-item
      [pw-home]]]
    [:div.carousel-item {:style {:border-top "2pt solid #d8dcb1fb"}}
     [:div.mob-top-prg-inner-item
      [txt/pw-tech-used]]
     [:div.mob-top-prg-inner-item
      [pw-encrypted]]]
    [:div.carousel-item {:style {:border-top "2pt solid #d8dcb1fb"}}
     [:div.mob-top-prg-inner-item
      [:h6 {:style {:font-weight "bold"}} "Link to Github"]
      [:a {:style {:font-size 36}
           :href "https://github.com/TheFakeLorLyons/password-manager"
           :target "_blank"
           :rel "noopener noreferrer"}
       "Password Manager GH"]]]
    [:a.carousel-control-prev {:href "#mobpwCarousel"
                               :role "button"
                               :data-slide "prev"}
     [:span.carousel-control-prev-icon {:aria-hidden "true"}]
     [:span.sr-only "Previous"]]
    [:a.carousel-control-next {:href "#mobpwCarousel" :role "button" :data-slide "next"}
     [:span.carousel-control-next-icon {:aria-hidden "true"}]
     [:span.sr-only "Next"]]]])

(defn mob-cos-carousel []
  [:div.cos.text.carousel {:id "mobcosCarousel"
                           :data-ride "tcarousel"
                           :class "carousel slide"
                           :style {:display "flex"
                                   :justify-content "center"
                                   :align-items "center"}}
   [:div.carousel-inner {:style {:font-size "16pt"
                                 :height "100%"
                                 :display "flex"
                                 :flex-direction "column"
                                 :justify-content "space-evenly"}}
    [:div.carousel-item.active {:style {:border-top "2pt solid #d8dcb1fb"}}
     [:div.mob-top-prg-inner-item
      [txt/cos-what-i-learned]]
     [:div.costext
      [cos-erd]]]
    [:div.carousel-item {:style {:border-top "2pt solid #d8dcb1fb"}}
     [:div.mob-top-prg-inner-item
      [txt/cos-description-1-3]]
     [:div
      [cos-all-cos]]]
    [:div.carousel-item {:style {:border-top "2pt solid #d8dcb1fb"}}
     [:div.mob-top-prg-inner-item
      [txt/cos-description-2-3]]
     [:div
      [cos-friends]]]
    [:div.carousel-item {:style {:border-top "2pt solid #d8dcb1fb"}}
     [:div.mob-top-prg-inner-item
      [txt/cos-description-3-3]]
     [:div
      [cos-filled-purch]]]
    [:div.carousel-item {:style {:border-top "2pt solid #d8dcb1fb"}}
     [:div.mob-top-prg-inner-item
      [txt/cos-description-3-3]]
     [:div
      [cos-order-hist]]]
    [:div.carousel-item {:style {:border-top "2pt solid #d8dcb1fb"}}
     [:div.mob-top-prg-inner-item
      [txt/cos-tech-used-1]]
     [:div
      [cos-purchase-conf]]]
    [:div.carousel-item {:style {:border-top "2pt solid #d8dcb1fb"}}
     [:div.mob-top-prg-inner-item
      [txt/cos-tech-used-2]]
     [:div
      [cos-purchases]]]
    [:a.carousel-control-prev {:href "#mobcosCarousel"
                               :role "button"
                               :data-slide "prev"
                               :style {:width "relative"}}
     [:span.carousel-control-prev-icon {:aria-hidden "true"}]
     [:span.sr-only "Previous"]]
    [:a.carousel-control-next {:href "#mobcosCarousel" :role "button" :data-slide "next"}
     [:span.carousel-control-next-icon {:aria-hidden "true"}]
     [:span.sr-only "Next"]]]])

(defn mob-cont-carousel []
  [:div.cont.text.carousel {:id "mobcontCarousel"
                            :data-ride "tcarousel"
                            :class "carousel slide"
                            :style {:display "flex"
                                    :justify-content "center"
                                    :align-items "center"}}
   [:div.carousel-inner {:style {:font-size "16pt"
                                 :height "100%"
                                 :display "flex"
                                 :flex-direction "column"
                                 :justify-content "space-evenly"}}
    [:div.carousel-item.active {:style {:border-top "2pt solid #d8dcb1fb"}}
     [:div.mob-top-prg-inner-item
      [txt/cont-what-i-learned]]
     [:div.conttext
      [cont-main]]]
    [:div.carousel-item {:style {:border-top "2pt solid #d8dcb1fb"}}
     [:div.mob-top-prg-inner-item
      [txt/cont-description]]
     [:div
      [cont-edit-1]]]
    [:div.carousel-item {:style {:border-top "2pt solid #d8dcb1fb"}}
     [:div.mob-top-prg-inner-item
      [txt/cont-tech-used]]
     [:div
      [cont-edit-2]]]
    [:div.carousel-item {:style {:border-top "2pt solid #d8dcb1fb"}}
     [:div.mob-top-prg-inner-item
      [:h6 {:style {:font-weight "bold"}} "Link to App"]
      [:a {:style {:font-size 16}} (nth (text-content :cont) 0)]
      [:h6 {:style {:font-weight "bold"}} "Link to Github"]
      [:a {:style {:font-size 36}
           :href "https://github.com/TheFakeLorLyons/contacts_manager.github.io"
           :target "_blank"
           :rel "noopener noreferrer"}
       "Contact App GH"]]]
    [:a.carousel-control-prev {:href "#mobcontCarousel"
                               :role "button"
                               :data-slide "prev"
                               :style {:width "relative"}}
     [:span.carousel-control-prev-icon {:aria-hidden "true"}]
     [:span.sr-only "Previous"]]
    [:a.carousel-control-next {:href "#mobcontCarousel" :role "button" :data-slide "next"}
     [:span.carousel-control-next-icon {:aria-hidden "true"}]
     [:span.sr-only "Next"]]]])

(defn mob-c-carousel []
  [:div.cont.text.carousel {:id "mobcCarousel"
                            :data-ride "tcarousel"
                            :class "carousel slide"
                            :style {:display "flex"
                                    :justify-content "center"
                                    :align-items "center"}}
   [:div.carousel-inner {:style {:font-size "16pt"
                                 :height "100%"
                                 :display "flex"
                                 :flex-direction "column"
                                 :justify-content "space-evenly"}}
    [:div.carousel-item.active {:style {:border-top "2pt solid #d8dcb1fb"}}
     [:div.mob-top-prg-inner-item
      [txt/c-what-i-learned]]
     [:div.conttext
      [ard-buzz]]]
    [:div.carousel-item {:style {:border-top "2pt solid #d8dcb1fb"}}
     [:div.mob-top-prg-inner-item
      [txt/c-description]]
     [:div
      [ard-lights]]]
    [:div.carousel-item {:style {:border-top "2pt solid #d8dcb1fb"}}
     [:div.mob-top-prg-inner-item
      [txt/c-tech-used]]
     [:div
      [nbodies]]]
    [:a.carousel-control-prev {:href "#mobcCarousel"
                               :role "button"
                               :data-slide "prev"
                               :style {:width "relative"}}
     [:span.carousel-control-prev-icon {:aria-hidden "true"}]
     [:span.sr-only "Previous"]]
    [:a.carousel-control-next {:href "#mobcCarousel" :role "button" :data-slide "next"}
     [:span.carousel-control-next-icon {:aria-hidden "true"}]
     [:span.sr-only "Next"]]]])

(defn mob-prg-current-carousel []
  [:div.cont.text.carousel {:id "mobgCarousel"
                            :data-ride "tcarousel"
                            :class "carousel slide"
                            :style {:display "flex"
                                    :justify-content "center"
                                    :align-items "center"}}
   [:div.carousel-inner {:style {:font-size "16pt"}}
    [:div.carousel-item.active {:style {:padding-left "2.5vw"
                                        :padding-right "2.5vw"}}
     [:h6 {:style {:margin "1vh"}} "Works currently in progress"]
     [:div.conttext
      (for [line txt/prg-current-1]
        ^{:key line}
        [:p {:style {:font-size 18}} line])]]
    [:div.carousel-item
     [lgbt-stats1]]
    [:div.carousel-item {:style {:padding-left "2.5vw"
                                 :padding-right "2.5vw"}}
     [:h6 {:style {:margin "3vh"}} "Getting Involved with Sci-Cloj"]
     [:div
      (for [line txt/prg-current-2]
        ^{:key line}
        [:p {:style {:font-size 18}} line])]]
    [:div.carousel-item
     [lgbt-stats2]]
    [:div.carousel-item
     [lgbt-stats3]]
    [:div.carousel-item {:style {:padding-left "2.5vw"
                                 :padding-right "2.5vw"}}
     [:h6 {:style {:margin "3vh"}} "Things I'm studying"]
     [:div
      (for [line txt/prg-current-3]
        ^{:key line}
        [:p {:style {:font-size 18}} line])]]
    [:a.carousel-control-prev {:href "#mobgCarousel"
                               :role "button"
                               :data-slide "prev"
                               :style {:width "relative"}}
     [:span.carousel-control-prev-icon {:aria-hidden "true"}]
     [:span.sr-only "Previous"]]
    [:a.carousel-control-next {:href "#mobgCarousel" :role "button" :data-slide "next"}
     [:span.carousel-control-next-icon {:aria-hidden "true"}]
     [:span.sr-only "Next"]]]])

(defn mob-prg-future-carousel []
  [:div.cont.text.carousel {:id "mobgCarousel"
                            :data-ride "tcarousel"
                            :class "carousel slide"
                            :style {:display "flex"
                                    :justify-content "center"
                                    :align-items "center"}}
   [:div.carousel-inner {:style {:font-size "16pt"}}
    [:div.carousel-item {:style {:padding-left "2.5vw"
                                 :padding-right "2.5vw"}}
     [:h6 {:style {:margin ".5vh"}} "Coming Attractions"]
     [:div.conttext {:style {:margin-top "1vh"}}
      (for [line txt/prg-future-1]
        ^{:key line}
        [:p {:style {:font-size 18}} line])]]
    [:div.carousel-item.active {:style {:margin-top "2.5vh"}}
     [apples3d]]
    [:div.carousel-item {:style {:margin-top "2.5vh"
                                 :padding-left "2.5vw"
                                 :padding-right "2.5vw"}}
     [:h6 {:style {:margin "3vh"}} "Mentoring and Volunteering"]
     [:div
      (for [line txt/prg-future-2]
        ^{:key line}
        [:p {:style {:font-size 18}} line])]]
    [:div.carousel-item {:style {:margin-top "2.5vh"}}
     [apples2d]]
    [:div.carousel-item {:style {:padding-left "2.5vw"
                                 :padding-right "2.5vw"}}
     [:h6 "Programming aspirations"]
     [:div
      (for [line txt/prg-future-3]
        ^{:key line}
        [:p {:style {:font-size 18}} line])]]
    [:a.carousel-control-prev {:href "#mobgCarousel"
                               :role "button"
                               :data-slide "prev"
                               :style {:width "relative"}}
     [:span.carousel-control-prev-icon {:aria-hidden "true"}]
     [:span.sr-only "Previous"]]
    [:a.carousel-control-next {:href "#mobgCarousel" :role "button" :data-slide "next"}
     [:span.carousel-control-next-icon {:aria-hidden "true"}]
     [:span.sr-only "Next"]]]])
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                        ;             table body              ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn heading []
  [:div
   [:h2 {:style {:font-weight "bold"}} "Projects"]
   [:h6 "Select a project below to view further details, click the title for relevant links."]])

(defn mob-heading []
  [:div
   [:h5 {:style {:font-weight "bold"
                 :margin-top "-5vh"}} "Projects"]
   [:p "Select a project below to view further details, click the title for relevant links."]])

(defn carousel-component [project]
  (case project
    :pw [pw-carousel]
    :cos [cos-carousel]
    :cont [cont-carousel]
    :card [c-carousel]
    :in-prog [prg-current-carousel]
    :future  [prg-future-carousel]
    [:div "No carousel available"]))

(defn projects []
  [:div.prg-left-subheading-buttons
   [:div.prg-heading-table-row {:style {:flex-direction "column"
                                        :gap "1.5ex"}}
    [:div.sp-prg-heading-cell
     [:a {:href "#pw" :on-click #(reset! current-project :pw)
          :id "prg-button"}
      "PW Manager"]]
    [:div.sp-prg-heading-cell
     [:a {:href "#cos" :on-click #(reset! current-project :cos)
          :id "prg-button"}
      "\"Cosminis\""]]]
   [:div.prg-heading-table-row {:style {:flex-direction "column"
                                        :gap "1.5ex"}}
    [:div.sp-prg-heading-cell
     [:a {:href "#cont" :on-click #(reset! current-project :cont)
          :id "prg-button"}
      "Contacts Application"]]
    [:div.sp-prg-heading-cell
     [:a {:href "#card" :on-click #(reset! current-project :card)
          :id "prg-button"}
      "C / Arduino / Java"]]]])

(defn current-fut-projects []
  [:div.prg-right-subheading-buttons
   [:div.sp-prg-heading-cell
    [:a {:href "#in-prog" :on-click #(reset! current-project :in-prog)
         :id "prg-button"}
     "Work Currently in Progress"]]
   [:div.sp-prg-heading-cell
    [:a {:href "#future" :on-click #(reset! current-project :future)
         :id "prg-button"}
     "Future Interests & Aspirations"]]])

(defn menu []
  [:div.menu-div {:style {:display "flex"
                          :justify-content "space-evenly"
                          :gap "10vw"
                          :margin-top "2vh"}}
   [:div.prg-menu-proj
    [projects]]
   [:div.prg-menu-fut {:style {:display "flex"
                               :justify-content "center"
                               :align-items "center"}}
    [current-fut-projects]]])

(defn prg-table []
  [:div.prg-container
   [:div.prg-table-wrapper
    [:div.prg-table
     [:div.prg-table-row
      {:style {:display "prg-table-row"}}
      [:div.prg-table-cell
       [:div.sp-prg-table-column
        [:div.sp-prg-table-cell {:style {:display "flex"
                                         :text-align "center"}}
         [:div.sp-prg-heading-cell
          [:h6 {:style {:font-weight "bold"}} "Title"]
          [:p (nth (text-content @current-project) 0)]]]
        [:div.sp-prg-table-cell
         {:style {:display "prg-table-cell"
                  :text-align "center"}}
         [:h6 {:style {:font-weight "bold"}} "Description"]
         [:p {:style {:font-size "14pt"}} (nth (text-content @current-project) 1)]]
        [:div.sp-prg-table-cell
         {:style {:display "prg-table-cell"
                  :text-align "center"}}
         [:h6 {:style {:font-weight "bold"}} "Technologies used"]
         [:p {:style {:font-size "14pt"}} (nth (text-content @current-project) 2)]]]]
      [:div.prg-table-cell
       {:style {:display "prg-table-cell"
                :text-align "center"}}
       [carousel-component @current-project]]]]]])

(defn mob-prg-table []
  (let [carousels {:pw [mob-pw-carousel "Password Manager"]
                   :cos [mob-cos-carousel "Cosminis"]
                   :cont [mob-cont-carousel "Contacts Manager"]
                   :c [mob-c-carousel "C/Java/Arduino"]
                   :current [mob-prg-current-carousel "Current Projects"]
                   :future [mob-prg-future-carousel "Goals & Interests"]}
        active-carousel (r/atom :pw)
        handle-wheel (fn [event]
                       (let [delta (.-deltaY event)
                             target (.-target event)
                             scroll-left (.-scrollLeft target)]
                         (.preventDefault event)
                         (set! (.-scrollLeft target) (+ scroll-left delta))))]
    (fn []
    [:div.prg-container
     [:div.mob-prg-table-wrapper
      [:div.mob-table-row
       [:div.mob-prg-heading-wrapper
        [:div.mob-prg-heading
         (for [[key [_ title]] carousels]
           ^{:key key}
           [:a.mob-prg-heading-links {:href (str "#" (name key))
                                      :on-click #(reset! active-carousel key)
                                      :class (when (= @active-carousel key) "active")}
            [:div {:style {:display "flex"
                           :gap "3vw"
                           :align-items "center"}}
             [:p title]
             (when (not (= title "Goals & Interests"))[:p.non-heading {:style {:color "#d8dcb1fb"}}" | "])]])]]
       [:div.mob-prg-carousel-container 
        (if-let [[carousel-component _] (get carousels @active-carousel)]
          [carousel-component]
          [:div (str "No carousel found for key: " @active-carousel)])]]]])))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                        ;                content              ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn prg-heading []
  [:div.prg-heading-table
   [:div.prg-heading-table-row
    [:div.prg-heading-cell
     [heading]
     [calva-logo]
     [menu]]]])

(defn mob-prg-heading []
  [:div.mob-prg-heading-table
   [:div.mob-prg-heading-table-row
    [:div.mob-prg-heading-cell
     [mob-calva-logo]
     [mob-heading]]]])

(defn programming-container []
  (if (@page/state :mobile)
    [:div.mob-prg-content
     [mob-prg-heading]
     [mob-prg-table]]
    [:div.prg-content
     [prg-heading]
     [prg-table]]))