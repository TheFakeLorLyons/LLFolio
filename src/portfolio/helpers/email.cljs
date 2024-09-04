(ns portfolio.helpers.email
  (:require [reagent.core :as r]
            [cljs-http.client :as http]))

(defonce form-state (r/atom {:name ""
                             :email ""
                             :message ""
                             :status nil}))

(defn handle-submit [e]
  (.preventDefault e)
  (let [{:keys [name email message]} @form-state
        form (.-target e)
        promise (js/emailjs.sendForm "service_483zklf" "template_8xy4py4" form "OfdZIq4ODS7xq6XUR")]
      (.then promise
             (fn [response]
               (reset! form-state (assoc @form-state :status {:type :success
                                                              :message "Your message has been sent!"})))
             (fn [error]
               ;; Log the error for debugging
               (js/console.error "EmailJS error: " error)
               (reset! form-state (assoc @form-state :status {:type :error
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