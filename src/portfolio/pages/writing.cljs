(ns portfolio.pages.writing)

(def aerial-roots
  ["Branching paths lead souls
along roads worn by travelers
following assorted “Ways”."

   "Each claiming superiority,
innocent wanderers lost among the
twisted pathways
meander forward.
Holding conviction and doubt
equally within their heats."

   "Insecurity marks each step
of the soul venturing forth.
Feigning knowledge of their
ways of ignorance, or,
ways of pride."
    
"Throughout time;
two changeless ways
present themselves
to sages who wish to see."

   "Some follow the Way of Death,
Yearning to embrace Lord Yama.
Hopes of one day taking form
as the face of death,
and becoming death – remain; 
eternal at the edge of time."

   "Others follow the Way of Life,
becoming no one.
Avoiding form to sustain it.
Persistent eternally,
giving birth to form,
as to avoid being captured by it."
   
"Yet the great Way
remains unknown
to those who claim mastery
over birth and death.
Form or formlessness."
   
   "The Buddha sits upon a lotus,
fully engaged in inaction,
undisturbed by visions
of their own, or others
endless search for peace."

   "Tranquil, unstirred,
observing life and death
with compassion.
Having stopped looking,
finding the great peace
that marks the heart
of those who after many kalpas,
have relinquished all paths."])

(defn table-cell [text]
  [:div.table-cell
   {:style {:display "table-cell"
            :padding "10px"
            :text-align "center"}}
   [:p text]])
(defn table-row [texts]
  [:div.table-row
   {:style {:display "table-row"}}
   (map table-cell texts)])

(defn wrt-table2 []
  (let [rows (partition 3 aerial-roots)] ; Divide text into rows of 3 items each
    [:div.wrt-container
     [:div.wrt-table-wrapper
      [:div.wrt-table
       (map table-row rows)]]]))


(defn wrt-table []
  [:div.wrt-container
   [:div.wrt-table-wrapper
    [:div.wrt-table
     [:div.table-row
      {:style {:display "table-row"}}
      [:div.wrt-table-cell
       {:style {:display "table-cell"
                :padding "10px"
                :text-align "center"}}
       [:p (aerial-roots 0)]]
      [:div.wrt-table-cell
       {:style {:display "table-cell"
                :padding "10px"
                :text-align "center"}}
       [:p (aerial-roots 3)]]
      [:div.wrt-table-cell
       {:style {:display "table-cell"
                :padding "10px"
                :text-align "center"}}
       [:p (aerial-roots 6)]]]
     [:div.table-row
      {:style {:display "table-row"}}
      [:div.wrt-table-cell
       {:style {:display "table-cell"
                :padding "10px"
                :text-align "center"}}
       [:p (aerial-roots 1)]]
      [:div.wrt-table-cell
       {:style {:display "table-cell"
                :padding "10px"
                :text-align "center"}}
       [:p (aerial-roots 4)]]
      [:div.wrt-table-cell
       {:style {:display "table-cell"
                :padding "10px"
                :text-align "center"}}
       [:p (aerial-roots 7)]]]
     [:div.table-row
      {:style {:display "table-row"}}
      [:div.wrt-table-cell
       {:style {:display "table-cell"
                :padding "10px"
                :text-align "center"}}
       [:p (aerial-roots 2)]]
      [:div.wrt-table-cell
       {:style {:display "table-cell"
                :padding "10px"
                :text-align "center"}}
       [:p (aerial-roots 5)]]
      [:div.wrt-table-cell
       {:style {:display "table-cell"
                :padding "10px"
                :text-align "center"}}
       [:p (aerial-roots 8)]]]]]])

(defn writing-container []
  [:div.wrt-content
   [:h1 "Writing"]

   [wrt-table]])