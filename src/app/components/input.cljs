(ns app.components.input
  (:require [reagent.core :as r]
            [re-frame.core :refer [dispatch]]))

(defn add-todo [input-value]
  (if-not (= @input-value "")
    (dispatch [:add-todo @input-value]))
  (reset! input-value ""))

(defn todo-input []
  (let [input-value (r/atom "")]
    (fn []
      [:<>
       [:input {:type "text"
                :value @input-value
                :on-change #(reset! input-value (-> % .-target .-value))
                :on-key-down (fn [e]
                               (let [keycode (-> e .-keyCode)]
                                 (when (= keycode 13)
                                   (add-todo input-value))))}]
       [:button {:on-click #(add-todo input-value)} "추가"]
       [:button {:on-click (fn []
                             (dispatch [:clear-todos])
                             (reset! input-value nil))} "초기화"]])))