(ns app.reframe.events
  (:require [reagent.core :as r])
  (:require [re-frame.core :refer [reg-event-db reg-event-fx]]))

;; todo-id 용 atom
(def todo-id (r/atom 0))

;; 상태 초기화
(reg-event-db
 :initialize
 (fn []
   {:todos (sorted-map)}))

(reg-event-fx
 :add-todo
 (fn [{:keys [db]} [_ input-value]]
   (swap! todo-id inc)
   {:db (assoc db :todos (conj (:todos db) [@todo-id input-value]))}))

(reg-event-fx
 :clear-todos
 (fn [{:keys [db]} _]
   {:db (assoc db :todos (sorted-map))}))

(reg-event-fx
 :delete-todo
 (fn [{:keys [db]} [_ id]]
   {:db (assoc db :todos (dissoc (:todos db) id))}))