(ns app.core
  (:require
   [reagent.dom :as rdom]
   [re-frame.core :refer [dispatch] :as rf]
   [app.reframe.events]
   [app.reframe.subs]
   [app.components.input :refer [todo-input]]
   [app.components.list :refer [todo-list]]))

(defn app []
  [:div.todos-container
   [:h1 "투두리스트"]
   [:div
    [todo-input]]
   [todo-list]])

(defn ^:dev/after-load render
  "Render the toplevel component for this app."
  []
  (dispatch [:initialize])
  (rdom/render [app] (.getElementById js/document "app")))

(defn ^:export main
  "Run application startup logic."
  []
  (render))
