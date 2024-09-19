(ns portfolio.helpers.email
  (:require [reagent.core :as r]
            [cljs-http.client :as http]))

(defonce form-state (r/atom {:name ""
                             :email ""
                             :message ""
                             :status nil}))
(defn validate-form [form]
  (cond
    (empty? (:name form)) "Name is required."
    (empty? (:email form)) "Email is required."
    (not (re-matches #"[^@]+@[^@]+\.[^@]+" (:email form))) "Please enter a valid email address."
    (empty? (:message form)) "Please enter a message."
    :else nil))

(defn handle-submit [e]
  (.preventDefault e)
  (if-let [error-message (validate-form @form-state)]
    (swap! form-state assoc :status {:type :error :message error-message})
    (let [form (.-target e)
          promise (js/emailjs.sendForm "service_483zklf" "template_8xy4py4" form "OfdZIq4ODS7xq6XUR")]
      (.then promise
             (fn [response]
               (reset! form-state {:name "" :email "" :message ""
                                   :status {:type :success
                                            :message "Your message has been sent!"}}))
             (fn [error]
               (js/console.error "EmailJS error: " error)
               (swap! form-state assoc :status {:type :error
                                                :message (str "Failed to send message. Please try again. " (.-message error))}))))))

(defn contact-form []
    [:div
     [:h2 "Contact Me"]
     [:form {:on-submit handle-submit
             :style {:border-radius "6%/15%"}}
      [:div {:style {:display "flex"
                     :flex-direction "column"
                     :justify-content "center"
                     :align-items "center"
                     :text-align "center"
                     :width "35vw"
                     :padding "5%"}}

       [:label {:style {:margin-top "2vh"
                        :display "flex"
                        :text-align "center"}} "Name:"
        [:input {:type "text"
                 :name "name"
                 :value (:name @form-state)
                 :on-change #(swap! form-state assoc :name (-> % .-target .-value))}]]

       [:label {:style {:display "flex"
                        :text-align "center"}} "Email:"
        [:input {:type "email"
                 :name "email"
                 :value (:email @form-state)
                 :on-change #(swap! form-state assoc :email (-> % .-target .-value))}]]

       [:label {:style {:display "flex"
                        :text-align "center"}} "Message:"
        [:textarea {:name "message"
                    :value (:message @form-state)
                    :on-change #(swap! form-state assoc :message (-> % .-target .-value))}]]
       [:button {:type "submit"} "Send"]

       (when (:status @form-state)
         [:div {:style {:margin-top "2vh"
                        :padding "1rem"
                        :border-radius "0.5rem"
                        :text-align "center"
                        :color (if (= (:type (:status @form-state)) :success) "green" "red")
                        :background-color (if (= (:type (:status @form-state)) :success) "#d4edda" "#f8d7da")
                        :border (str "1px solid " (if (= (:type (:status @form-state)) :success) "#c3e6cb" "#f5c6cb"))}}
          (:message (:status @form-state))])]]])

(defn mob-contact-form []
  [:div {:style {:display "flex"
                 :flex-direction "column"
                 :align-items "center"
                 :width "100%"
                 :padding "2rem"}}
   [:h4 "Contact Me"]
   [:form {:on-submit handle-submit
           :style {:width "100%"
                   :max-width "500px"
                   :border "1px solid #ccc"
                   :border-radius "10px"
                   :padding "2rem"
                   :box-shadow "0 2px 10px rgba(0, 0, 0, 0.1)"}}
    [:div {:style {:display "flex"
                   :flex-direction "column"
                   :gap "1rem"}}
     [:label {:style {:display "flex"
                      :flex-direction "column"}}
      "Name:"
      [:input {:type "text"
               :name "name"
               :value (:name @form-state)
               :on-change #(swap! form-state assoc :name (-> % .-target .-value))
               :style {:padding "0.5rem"
                       :border "1px solid #ccc"
                       :border-radius "4px"}}]]
     [:label {:style {:display "flex"
                      :flex-direction "column"}}
      "Email:"
      [:input {:type "email"
               :name "email"
               :value (:email @form-state)
               :on-change #(swap! form-state assoc :email (-> % .-target .-value))
               :style {:padding "0.5rem"
                       :border "1px solid #ccc"
                       :border-radius "4px"}}]]
     [:label {:style {:display "flex"
                      :flex-direction "column"}}
      "Message:"
      [:textarea {:name "message"
                  :value (:message @form-state)
                  :on-change #(swap! form-state assoc :message (-> % .-target .-value))
                  :style {:padding "0.5rem"
                          :border "1px solid #ccc"
                          :border-radius "4px"
                          :min-height "100px"
                          :resize "vertical"}}]]
     [:button {:type "submit"
               :style {:padding "0.5rem 1rem"
                       :background-color "#ef93f845"
                       :color "white" 
                       :border-radius "4px"
                       :cursor "pointer"}}
      "Send"]]
    (when (:status @form-state)
      [:div {:style {:margin-top "1rem"
                     :padding "1rem"
                     :border-radius "4px"
                     :text-align "center"
                     :color (if (= (:type (:status @form-state)) :success) "green" "red")
                     :background-color (if (= (:type (:status @form-state)) :success) "#d4edda" "#f8d7da")
                     :border (str "1px solid " (if (= (:type (:status @form-state)) :success) "#c3e6cb" "#f5c6cb"))}}
       (:message (:status @form-state))])]])