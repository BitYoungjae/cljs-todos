(ns app.components.item
  (:require
   [re-frame.core :refer [dispatch]]))

(defn todo-item [todo id]
  [:li.todo-item todo
   [:button
    {:on-click #(dispatch [:delete-todo id])}
    "x"]])