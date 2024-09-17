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

(def more-about-me
  [:div
   "I have a broad background well suited to any development environment. My philosophical and artistic
    studies provide me unique perspectives into programming, and I am enthusiastic about creating beautiful
    and tangible user interfaces. I am excited for the future of software and looking forward to see how 
    in what ways I can contribute your team and projects."])

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
      [:p {:style {:margin-top "3vh"}}
       home-text]]]
    [:div.carousel-item
     [:div.mission {:style {:transform "translateY(4.5vh)"
                            :margin-left "1vw"}}
      [goals-list]]]
    [:div.carousel-item
     [:div.mission {:style {:transform "translateY(6.5vh)"
                            :margin-left "1vw"
                            :gap "4vh"}}
      [:h5 {:style {:font-weight "bold"}} "A little about me..."]
      more-about-me]]
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
    to people struggling with mental health issues, During this time I spent most of my personal time learning to code."

   "I joined a company called Revature that trained me in enterprise software development. 
    I created Angular applications as a leader of a team of ~20 people. I made
    the decision to return to school because I wanted to continue my formal education 
    in CS, and am now on track to begin my masters in August of 2025."

   "1/3"])

(def current
  [[:h4 {:style {:font-weight "bold"
                 :margin-top "2vh"}} "Currently"]
   "I am studying at Bristol Community College, as I am required to fulfill pre requisite math and science 
    courses prior to beginning a Masters in CS at may alma mater - Bridgewater State University. In this time I have
    studied C and Python in addition to Clojure and Clojurescript. I have also revisited math studies and have gotten 
    an A- and A+ in calculus and statistics respectively."

   "I have grown very fond of mathematics, and enjoyed learning statistics by writing an R package alongside my 
    studies. This semester (fall 2024) I am taking a 3 credit class in Discrete Structures and a second class called 
    'Software Specifications and Design'."

   "I am an active member of the Clojure Community, and both provide and receive mentorship from other
    well established programmers. I have been granted a scholarship to go to the Clojure 'Conj' this year, and I
    am looking very forward to meeting all of the different experts in this field and learning as much as I possibly
    can."

   "I am actively seeking any opportunityies to code on a team and am very interested in any internships
    or full-time opportunities for startup or enterprise environments. Please reach out at my email located in the
    site footer."

   "2/3"])


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
    I do I will be sure to update this site with that code."

   "3/3"])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                        ;            Programming              ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn links-format [url text]
  [:a {:href url
       :target "_blank"
       :rel "noopener noreferrer"}
   text])

(def clj-camp
  [:a {:href "https://my.clojure.camp/"} "Clojure community pairing/mentoring"])

(def lbgt-study-link
  [:A {:href "https://www.icpsr.umich.edu/web/ICPSR/studies/38421/summary"} "this link"])

(def clj-slack
  [:a {:href "https://clojurians.slack.com/ssb/redirect"} "Clojurians slack"])

(def prg-current-1
  ["This semester I am taking two courses while also completeing CompTIA A+ and Network+. While my academic and professional
    pursuits are in programming rather than IT work, my current job offered me the opportunity to take a 'Healthcare IT' 
    curriculum that covers both of these CompTIA courses as well as another 'Healthcare Information Management' certificate."

   [:div "I have been increasingly involved with the Clojure community in order to improve my skills and network with other
          developers in the Clojure community. It has been a wonderfully welcoming environment and I am actively participating
          in mentorships with very experienced developers who are pushing me to improve every day. I have also had the opportunity
          to help mentor other newer programmers, and most recently began holding a bi weekly application building group."
    clj-camp]

   "I have also been working on this website a lot lately. The mobile site is going to be up within the next couple weeks,
    and I plan on continuing to improve the appearance of the site and keep it updated with recent work as I complete new things.
    It has been a fun project to put all of my Clojure and CLJS/Reagent skills to use making this portfolio website, and I look
    forward to continue improving it over time with more content and an improved appearance."

   "1/3"])

(def prg-current-2
  ["I recently joined the Scicloj mentorship program and will be assisting them in documenting a data visualization
         tool that allows \"visual data exloration and documents from source code\" (from the site). I am currently practicing 
         reagent on several applications, including a data visualization app that will fetch information from steam, and similar,
         APIs in order to recommend games based on custom queries."

   [:div "The pictures in these slides are pictures of my recent explorations of data visualization. The bar charts are from a 2015
         study on lgbt health that can be seen at " lbgt-study-link ". When this project is complete I will likely share the
         results on this website in the form of a blog post with the interactive data attached."]

   "Scicloj mentoring has been a really fantastic opportunity so far, and I have gotten the chance to hear about some of
    the most modern applications of Clojure across multiple domains of physics, data science, algorithms and machine learning,
    and much more. I have also had the fortune to get to listen and provide feedback to multiple speakers for the Heart of Clojure.
    Meeting other Clojure experts and seeing how they work has increased my productivity and understanding of clean design tremendously
    and I look forward to improving my skills every day."

   "2/3"])

(def prg-current-3
  ["In addition to my school work and mentorships within the clojure community and sci-cloj group, I have also gotten involved
    with open-source development. Most recently I have been helping on an artistic website that takes user input of narritive
    experiences and through the use of novel algorithms produces surreal writing excerpts that are amalgamations of all those
    who have contributed to the site."

   "I am learning as much as I can about client-server communications, data structures and algorithms, and design principles.
    I want to ensure that my foundations are strong and that I am comfortable developing solutions in whatever language a problem
    calls for."

   "Clojure and CLJS are my favorite languages but I try to actively practice with all languages and explore new ones. I want
    to learn to use GO and RUST more, and have been employing Python along Clojure since I first started using the program. I
    found that learning multiple instruments helped me solidify my understanding of music, and so too has learning multiple programming
    languages made me much more fluent in programming as an entire discipline."
   "3/3"])

(def prg-future-1
  ["The most exciting thing in my immediate future is the Clojure Conj. This will be my first programming conference and I am
    very eager to meet so many other professionals in our field. If you are reading my website from conj, thanks for stopping by
    and please don't hesitate to reach out and connect about my work and/or interests and aspirations."

   "The main goal I have had since even before I started program is to make Brain-Computer interfaces. I have always been enthralled
    by how humans interact with computers, and wanted to be involved in developing novel ways of augementing our ease and enjoyment
    of use of these technologies."

   "I often tell people that I am still 'on my way to the starting line' with regard to these technologies - primarily due to the
    upfront financial barrier associated with the hardware. With no external funding, the earliest I can pursue my first experimentation
    with these devices will be this coming summer; but I am interested in trying to apply for funding to possibly expedite this process."

   "Whereas most people are interested in these technologies from a medical point of view, I am particularly interested in the commercial
    and recreational applications of these technologies. It makes my heart race with enthusiasm to think about all the possibilities, and
    I hope that you agree and feel compelled to learn more about these things as well."

   "1/3"])

(def prg-future-2
  ["I am currently practicing reagent on several applications, including (but not limited to) a data visualization app
    that will fetch information from steam and similar APIs in order to recommend games and other media based on custom 
    search filters."

   [:div "As part of my way to give back to the Clojure community,I am holding a biweekly clojure group as a part of the "
    clj-slack". The group I am running has an emphasis on building applications and debugging each others in-progress
    applications. Our first project is to make a GUI that helps manage dependencies in new Clojure projects. I look forward
    to this group as a way to improve myself and also help improve the other programmers around me."]
   
   "If the group sounds interesting or you have any questions about the Clojure community or anything you have read please
    contact me using the contact form on this website. I am very interested in teaching as much as I am improving myself, so
    if I can be helpful to any other programmers I would love to schedule a time to sit down and help on whatever problem you 
    may have."
   
   "2/3"])

(def prg-future-3
  ["In the long run, outside of developing state-of-the-art Brain-Computer interface applications, I have a plethora of other
    interests that I may or may not ever get the time to explore. I would love to continue working on my password manager that
    is on this page and turn it into a fully fledged consumer application; but I am focusing on other things for the time being
    and so that is tabled for now."

   "I will continue doing 3d Modeling and digital art and trying to incorporate those things into all of my projects. I love 
    inspiring and contributing to creative projects, and want to explore generative art using all sorts of digital tools and
    techniques."
   
   "Space has always fascinated me, and I have put a lot of thought recently into doing data visualization and thinking about 
    ways to create applications that use data involving great distances. It would be a dream to help contribute to any kind of 
    space exploration/research software."

   "Of course one last interest that seems impossible not to mention nowadays is of course AI and ML. While I am not specifically
    interested in contributing to these technologies (and would need many years I am sure to even begin to), I am certainly captivated
    by all of the different possible uses of AI and ML and will no doubt spend time in the future learning how to use basic tools
    to help automate my testing and CI/CD."

   "3/3"])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                        ;                Music                ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def teacher-links
  [{:url "http://www.phillipdefremery.com/bio.php" :text "Phillip de Fremery"}
   {:url "https://grotonhill.org/faculty/berit-strong/" :text "Berit Strong"}
   {:url "https://jeromemouffe.com/" :text "Jerome Mouffe"}
   {:url "https://danielacsadi.com/" :text "Daniel Ascadi"}])

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
  ["My second bachelors is in music performance, I studied pedagogy and analysis primarily.
   In university I mastered the fundamentals of guitar and obtained a degree in classical guitar performance.
   While I majored in guitar, I also studied the piano extensively in both class settings and private lessons.
   Additionally, Lorelai has performed both solo, and in groups, and in world premiers
   for the Boston Classical Guitar Society both for Roland Dyens, and as a soloist for Carlo Domeniconi"

   "After graduating, I moved to Denver, CO and began teaching a variety of instruments including
   piano, guitar, ukulele, and voice to a wide range of students of different background, ages, and abilities
   in both one-on-one and group settings. During this time I also played in several duets with another
   guitarist, a flute player, and a violinist playing  gigs for historical societies, churches, etc."

   "I still play music as often as I possibly can, but have been spending all my time trying to become as skilled
    a programmer as possible. I have a passion for pedagogy and am interested in programming applications to
    facilitate music education and community musical organizing via VR and AR."])


(def music-study
  [[:div
    [:h5 "I studied the guitar extensively with:"]
    [formatted-links-list teacher-links] "Jerome in particular has played a huge role in my life
                                          and acted as my biggest role mode musically and in general
                                          throughout my undergraduate experience. I am forever grateful
                                          for all he has taught me, and I look back upon our lessons
                                          every time I sit down to play music (which is daily)."]

   "I've also participated in public masterclasses and lessons with famed guitarists:
   Oscar Ghiglia, Elliot Fisk, Maarten Stragier, David Russel, Pavel Steidl, Duo Miles, and Frank Wallace."

   ""])

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