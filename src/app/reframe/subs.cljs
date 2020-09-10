(ns app.reframe.subs
  (:require [re-frame.core :refer [reg-sub]]))

;; 셀렉터들
(reg-sub
 :todos
 (fn [db _]
   (:todos db)))