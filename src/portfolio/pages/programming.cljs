(ns portfolio.pages.programming
  (:require  [reagent.core :as r]
             [portfolio.helpers.pages :as page]))

(defonce current-project (r/atom :pw))

(defn calva-logo []
  [:img {:src "/assets/images/calvaicon.png"
         :id "clj-icon"
         :style {:position "fixed"
                 :top "3vh"
                 :right "2vw"
                 :margin "10px" 
                 :display (if (= (:display-content @page/state) :prg) "block" "none")}}])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                        ;            image assets             ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;pw-manager
(defn pw-login []
  [:div
  [page/zoomable-image "/assets/lpm.jpg" "pw-login" "35vw"]])
(defn pw-home []
    [:div
  [page/zoomable-image "/assets/lpmpwhome.jpg" "pw-home" "35vw"]])
(defn pw-encrypted []
  [:div
  [page/zoomable-image "/assets/encryptedpws.jpg" "pw-enc" "35vw"]])

;cosminis
(defn cos-erd []
  [:div
   [page/zoomable-image "/assets/cosminis-pics/Cosminis-ERD.png" "cos-erd" "35vw"]])
(defn cos-all-cos []
  [:div
   [page/zoomable-image "/assets/cosminis-pics/all-companions.png" "cos-all-cos" "35vw"]])
(defn cos-friends []
  [:div
   [page/zoomable-image "/assets/cosminis-pics/friends-page.png" "cos-friends" "35vw"]])
(defn cos-order-hist []
  [:div
   [page/zoomable-image "/assets/cosminis-pics/orderHistory.png" "cos-order-hist" "35vw"]])
(defn cos-purchase-conf []
  [:div
   [page/zoomable-image "/assets/cosminis-pics/purchaseConfirmation.png" "cos-purchase-conf" "35vw"]])
(defn cos-purchases []
  [:div
   [page/zoomable-image "/assets/cosminis-pics/purchases.png" "cos-purchases" "35vw"]])
(defn cos-filled-purch []
  [:div
   [page/zoomable-image "/assets/cosminis-pics/purchasespopulated.png" "cos-filled-purch" "35vw"]])

;contacts-application
(defn cont-main []
  [:div
   [page/zoomable-image "/assets/contacts/cont-main.png" "cont-main" "35vw"]])
(defn cont-edit-1 []
  [:div
   [page/zoomable-image "/assets/contacts/cont-edit-1.png" "cont-edit1" "35vw"]])
(defn cont-edit-2 []
  [:div
   [page/zoomable-image "/assets/contacts/cont-edit-2.png" "cont-edit2" "35vw"]])

(def clay-text
  (str "I recently joined the Scicloj mentorship program and will be assisting them in documenting a data visualization
      tool that allows \"visual data exloration and documents from source code\" (from the site). I am currently practicing 
      reagent on several applications, including a data visualization app that will fetch information from steam, and similar,
      APIs in order to recommend games based on custom queries."))

(def bci-text
  "I am very interested in Brain-Computer interfaces, and plan on continuing to aim to contribute to the development
      of BCI hardware and applications. I am particualrly interested in exploring BCI's and VR/AR experiences.
      I also have a passion for data visulizations and communications, and hope to present and speak on information
      pertaining to Clojure and BCIs in the future.")

(def school-study
  "Another thing I can place here")


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

(defn general-carousel []
  [:div.cont.text.carousel {:id "gCarousel"
                            :data-ride "tcarousel"
                            :class "carousel slide"
                            :style {:display "flex"
                                    :justify-content "center"
                                    :align-items "center"
                                    :padding-right "5vw"}}
   [:div.carousel-inner {:style {:font-size "16pt"}}
    [:div.carousel-item.active
     [:div.conttext
      [:p clay-text]]]
    [:div.carousel-item
     [:div
      [:p bci-text]]]
    [:div.carousel-item
     [:div
      [:p school-study]]]
    [:a.carousel-control-prev {:href "#gCarousel"
                               :role "button"
                               :data-slide "prev"
                               :style {:width "relative"}}
     [:span.carousel-control-prev-icon {:aria-hidden "true"}]
     [:span.sr-only "Previous"]]
    [:a.carousel-control-next {:href "#gCarousel" :role "button" :data-slide "next"}
     [:span.carousel-control-next-icon {:aria-hidden "true"}]
     [:span.sr-only "Next"]]]])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                        ;             table body              ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn carousel-component [project]
  (case project
    :pw [pw-carousel]
    :cos [cos-carousel]
    :cont [cont-carousel]
    :card [c-carousel]
    :in-prog [general-carousel]
    :future  [general-carousel]
    [:div "No carousel available"]))

(def pw-proj-info
  [[:a {:href "https://github.com/TheFakeLorLyons/password-manager" :target "_blank"} 
    [:h5 {:style {:font-weight "bold"}} "Password Manager"]]
   "This Application allows users to perform basic CRUD operations on any number of
    passwords. Users could choose to export the passwords to an encrypted csv for 
    secure access later on. Also features basic random password generation."
   "Clojure/CLJS, Reagent, BuddyHashers, Javax Cipher/Encryption, BouncyCastle, figwheel,
    Flowstorm, shadow-cljs, Hiccup, CSS, JS, Calva"])

(def cos-proj-info
  [[:div [:h5 {:style {:font-weight "bold"}}"\"Cosminis\""]]
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
         [:div.sp-prg-heading-column
          [:div.sp-prg-heading-cell
           [:h6 {:style {:font-weight "bold"}} "Completed MVP Applications"]]
          [:div.prg-heading-table-row {:style {:gap "5vw"}} 
           [:div.sp-prg-heading-cell
            [:a {:href "#pw" :on-click #(reset! current-project :pw)}
             "PW Manager"]]
           [:div.sp-prg-heading-cell
            [:a {:href "#cos" :on-click #(reset! current-project :cos)}
             "\"Cosminis\""]]]
          [:div.prg-heading-table-row {:style {:gap "5vw"}}
           [:div.sp-prg-heading-cell
            [:a {:href "#cont" :on-click #(reset! current-project :cont)}
             "Contacts Application"]]
           [:div.sp-prg-heading-cell
            [:a {:href "#card" :on-click #(reset! current-project :card)}
             "C / Arduino / Java"]]]
          [:div.sp-prg-heading-column
           [:div.sp-prg-heading-cell
            [:a {:href "#in-prog" :on-click #(reset! current-project :in-prog)}
             "Work Currently in Progress"]]
           [:div.sp-prg-heading-cell
            [:a {:href "#future" :on-click #(reset! current-project :future)}
             "Future Interests & Aspirations"]]]]]
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

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                        ;                content              ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn prg-heading []
  [:div.prg-heading-table
   [:div.prg-heading-table-row
    {:style {:display "prg-heading-table-row"}}
    [:div.prg-heading-cell
     {:style {:display "prg-heading-cell"
              :text-align "center"}}
     [:h4 (nth (text-content @current-project) 0)]
     [calva-logo]
     [:h6 "Below are examples of some of my work, alongside a description of the techniques and technologies involved."]
     [:h6 {:style {:font-size "16pt"}} " Use the links under \"completed applications\" to see my various projects."]]]])

(defn programming-container []
  [:div.prg-content
   [prg-heading]
   [prg-table]])