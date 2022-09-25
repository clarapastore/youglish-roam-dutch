(ns youglish
  (:require [roam.datascript.reactive :as dr]
            [roam.block :as block]))

;; utils 

(defn get-parent-string
  "Gets the string of the immediate parent block"
  [block-uid]
  (->> @(dr/pull '[{:block/_children [:block/string]}]
                  [:block/uid block-uid])
       :block/_children
       flatten
       (map :block/string)
       (apply identity)
       str))


(defn widget 
  "Returns a youglish widget that fetches videos for the string passed"
  [string]
  [:a#yg-widget-0.youglish-widget
    {:data-query string
     :data-lang "Dutch"} ;; change the value of :data-lang change the language
  "YouGlish"])

;; views

(defn start-view 
  "Returns a button that, when clicked, sets the state of the widget to running"
  [block-uid block-props]
  [:button.bp3-button {:on-click #(block/update {:block 
                                                  {:uid block-uid
                                                   :props (assoc block-props :widget-state :running)}})}
   "Search Youglish"])

(defn stop-button 
  "Returns a button that, when clicked, sets the state of the widget to stopped"
  [block-uid block-props]
  [:button.bp3-button {:on-click #(block/update {:block
                                                  {:uid block-uid
                                                   :props (assoc block-props :widget-state :stopped)}})}
   "Stop Youglish"])

(defn running-view 
  "Has the main functionality of the widget: adds the api js to the html document and returns the youglish widget"
  [block-uid block-props]
  (let [head js/document.head
        script (.createElement js/document "script")
        parent-block-string (get-parent-string block-uid)]
    (set! (.-type script) "text/javascript")
    (set! (.-src script) "https://youglish.com/public/emb/widget.js") 
    (.appendChild head script)
    [:div
     [:div [widget parent-block-string]]
     [:div [stop-button block-uid block-props]]]))

;; render function

(defn main [{:keys [block-uid]}]
  (let [*block-props (dr/f-entity :block/props [:block/uid block-uid])
        *state (dr/f-entity #(get-in % [:block/props :widget-state]) [:block/uid block-uid])]
    
    [:div
     (if (= @*state :running)
       [running-view block-uid @*block-props]
       [start-view block-uid @*block-props])]))
