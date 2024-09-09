(ns portfolio.helpers.texts
  (:require [portfolio.helpers.pages :as page]))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                        ;               home                  ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def home-text
  [:div
   "My name is Lorelai (or Lor or Laura). 
   This website provides a glimpse into my life and work, 
   as well as a way to reach out for networking and partnership. 
   Enjoy perusing the examples of my wide ranging work, 
   feel free to reach out using the contact form on the "
   [:a {:href "#pw" :on-click #(swap! page/state update :menu-open not)
        :style {:color "#fff678"}}
    "menu"]

   ", or any of the links at the bottom of the page."])

(def goals
  ["Utilize emerging technologies in exciting, novel ways."
   "Ensure equity and accessibility of said technologies."
   "Develop emerging technologies with an emphasis on human rights and ecological sustainability."
   "Public relations regarding emerging technologies - communicating the opportunities,\n and ramifications of these technological developments."])

(defn goals-list []
  [:div 
   [:h5 {:style {:font-weight "bold"}} "My Mission"]
   [:ol {:style {:text-align "center"
                 :margin-left "3vw"}}
   (for [goal (map-indexed (fn [idx g] [idx g]) goals)]
    [:li {:key (first goal)} (second goal)])]])


(defn home-text-carousel []
  [:div.home.text.carousel {:id "homeCarousel"
                            :data-ride "tcarousel"
                            :class "carousel slide"
                            :style {:display "flex"
                                    :justify-content "center"
                                    :align-items "center"}}
   [:div.carousel-inner {:style {:font-size "16pt"}}
    [:div.carousel-item.active
     [:div.hometext {:style {:transform "translateY(7.5vh)"}}
      [:h6 {:style {:font-weight "bold"}} "Hello and welcome to my portfolio website!"]
      [:p {:style {:margin-top "5vh"}}
       home-text]]]
    [:div.carousel-item
     [:div.mission {:style {:transform "translateY(4.5vh)"
                            :margin-left "1vw"}}
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
  ["...with a double major in music and philosophy"

   "My whole life I knew I wanted to make games, and I began by going to school for computer programming
    in 2009. I learned the fundamentals of C# and the software development lifecycle, and I also had
    experience doing digital art and 3d Modeling from high school and my personal studies. I initally
    changed to a music major to make the music in video games, but found myself graduating with my double
    major and teaching private music lessons. I still programmed on the side and studied C#, C++, and basic
    web development with HTML, CSS, and Javascript."

   "I enjoyed teaching music, but found that I had a greater passion for connecting with the students and
    being a positive influence in their lives. In 2017 I decided to pursue a change and provide social support
    to people struggling with mental health issues, During this time I spent most of my time learning to code."
   
   "I reviewed the foundations of programming and joined a company called Revature that trained me in
    enterprise software development. I created Angular applications as a leader of a team of ~20 people. I made
    the decision to return to school because I wanted to continue my formal education in CS, and am now on track
    to begin my masters in August of 2025."])

(def current
  [[:h4 {:style {:font-weight "bold"
                 :margin-top "2vh"}} "Currently"]
   "I am studying at Bristol Community College, as I am required to fulfill pre requisite math and science 
    courses prior to beginning a Masters in CS at may alma mater - Bridgewater State University. In this time I have
    studied C and Python in addition to Clojure and Clojurescript. I have also had to revisit math studies and have gotten 
    an A- and A+ in calculus and statistics respectively."
    
    "I have grown very fond of mathematics, and enjoyed learning statistics by writing an R package alongside my 
    studies. This semester (fall 2024) I am taking a 3 credit class in Discrete Structures and a second class called 
    'Software Specifications and Design'."

   "I am an active member of the Clojure Community, and both provide and receive mentorship from other
    well established programmers. I have been granted a scholarship to go to the Clojure 'Conj' this year, and I
    am looking very forward to meeting all of the different experts in this field and learning as much as I possibly
    can."
    
    "I am actively seeking any opportunityies to code on a team and am very interested in any internships
    or junior/mid level roles in any startup or enterprise environment. Please reach out at my email located in the
    site footer."])


(def future
  [[:h4 {:style {:font-weight "bold"
                 :margin-top "2vh"}} "Future"]
   "As I look towards the future - I am trying to prepare myself to learn as much as I possibly can about 
    Brain-Computer Interfaces. I recently read Rajesh P N Rao's 'Brain-Computer Interfacing' textbook (featured
    on the 'programming' page and it has me inspired to pursue this technology with every moment I have."
    
    "I am particularly interested in user interfaces, and I want to be able to craft both hardware and software
    that enhances our ability to perform computational tasks, and experience the world in a different way than
    ever before. At first my study is going to be around the basics of communication with these technology; but my
    long term goal is to craft interactive experiences using these technologies."
    
    "Aside from Brain Computer Interfaces, I am very interested in code as a means of expression. I recently dipped
    my toes in 'Quil' - which is a 'Clojure package made for generating interactive drawings and animations'. This
    exposure to generating art through code was amazing and something I am sure to explore further in the future. When
    I do I will be sure to update this site with that code."])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                        ;                Music                ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def teacher-links
  [{:url "http://www.phillipdefremery.com/bio.php" :text "Phillip de Fremery"}
   {:url "https://grotonhill.org/faculty/berit-strong/" :text "Berit Strong"}
   {:url "https://jeromemouffe.com/" :text "Jerome Mouffe"}
   {:url "https://danielacsadi.com/" :text "Daniel Ascadi"}])

(defn links-format [url text]
  [:a {:href url
       :target "_blank"
       :rel "noopener noreferrer"}
   text])

(defn formatted-links-list [links]
  (let [count (count links)]
    [:div
     (for [[idx {:keys [url text]}] (map-indexed vector links)]
       [:span
        (when (not (zero? idx))
          (if (= (dec count) idx)
            (str ", and ")  ;; "and" before the last link
            ", "))
        [links-format url text]]) "."]))

(def music-history
  ["In addition to my philosophy degree, I have a second bachelors in music performance.
   In university I mastered the fundamentals of guitar and obtained a degree in classical guitar performance.
   While I majored in guitar, I also studied the piano extensively in both class settings and private lessons."

   "Upon graduating from BSU, I moved to Denver, CO and began teaching a variety of instruments including
   piano, guitar, ukulele, and voice to a wide range of students of different background, ages, and abilities
   in both one-on-one and group settings. During this time I also played in several duets with another
   guitarist, a flute player, and a violinist playing  gigs for historical societies, churches, and various events
   both to supplement my income and also for the fun of it."

   "I still play music as often as I possibly can, but have been spending all my time trying to become as skilled
    a programmer as possible. I have a passion for pedagogy and am interested in programming applications to
    facilitate music education and community musical organizing via VR and AR."])


(def music-study
  [[:div
    "Lorelai has studied the guitar extensively such teachers as:"
    [formatted-links-list teacher-links]]
   
   "She has participated in public masterclasses and lessons with famed guitarists:
   Oscar Ghiglia, Elliot Fisk, Maarten Stragier, David Russel, Pavel Steidl, Duo Miles, and Frank Wallace."

   "Additionally, Lorelai has performed both solo, and in groups, and in world premiers
   for the Boston Classical Guitar Society both for Roland Dyens, and as a soloist for Carlo Domeniconi"])

(def musical-influences
  ["A final note on influences:"
   
   "I am interested in all creative endeavors and appreciate music of all styles;
   but will always love classical and jazz music most of all.
   Casually I love listening to most music including electronic music (specifically ‘chiptune’),
   as well as punk rock, and alternative music."

   "Some of my favorite classical musicians are: Claude Debussy, Clara Schumann, Franz Schubert,
   Fernando Sor, Leopold Godowsky, Juaquin Rodrigo,   Astor Piazzolla, Augustine Barrios Mangore
   and of course - Johann Sebastian Bach…"

   "Some of my favorite jazz musicians are: Ryu Fukui, Art Tatum, Bill Evans,
   Joe Pass, Luiz Bonfa, Tom Jobim, Carlos Barbosa-Lima, and Paulinho Nogueira. "])


(def soundcloud-link
  "https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/1109952148&color=%23f681c5&auto_play=false&hide_related=false&show_comments=true&show_user=true&show_reposts=false&show_teaser=true&visual=true")

(def google-drive-link
  "https://drive.google.com/drive/folders/1XKOCVv3KPyip_rFcHnSmc-lnWkOVUlSt?usp=drive_link")

(def google-drive-link-text
  "If you enjoyed my music, please feel free to take a look at this google drive where I upload lots of my favorite pieces.")

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                        ;                  art                ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def art-desc
  ["Artistically I am primarily self taught with advice from friends and mentors, I'll often uses Pens
   to draw Scenes, Portraits, and Abstract works. I also utilize Charcoal, watercolor, oil pastels,
   and Pencil extensively."
  
  "Eventually, with the help of my new computer, I am very interested in virtual 
   environments and creating museums and experiences that utilize cross-sensory interaction to craft new
   forms of media and expression, including eventually helping to create a GUI for fully immersive 
   virtual experiences through the use of Brain-Computer Interfaces."])