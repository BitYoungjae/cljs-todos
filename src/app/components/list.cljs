(ns app.components.list
  (:require [app.components.item :refer [todo-item]]
            [re-frame.core :refer [subscribe]]))

(defn todo-list []
  (let [todos (subscribe [:todos])]
    (fn []
      [:ul.todo-list
       (for [[id todo] @todos]
         ^{:key id} [todo-item todo id])])))