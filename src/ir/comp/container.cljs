
(ns ir.comp.container
  (:require [hsl.core :refer [hsl]]
            [respo-ui.style :as ui]
            [respo.macros :refer [defcomp cursor-> <> div button textarea span]]
            [verbosely.core :refer [verbosely!]]
            [respo.comp.space :refer [=<]]
            [reel.comp.reel :refer [comp-reel]]
            [ir.example :as example]
            [favored-edn.core :refer [write-edn]]))

(defcomp
 comp-container
 (reel)
 (let [store (:store reel), states (:states store)]
   (div
    {:style (merge ui/global ui/row)}
    (textarea
     {:value (write-edn example/base-app),
      :placeholder "code",
      :style (merge
              ui/textarea
              {:width 640,
               :height 320,
               :font-size 12,
               :font-family "Source Code Pro, Menlo, monospace"}),
      :on-input (fn [e d! m!] (d! :content (:value e)))})
    (=< "8px" nil)
    (div
     {}
     (button
      {:style ui/button,
       :inner-text (str "run"),
       :on-click (fn [e d! m!] (println (:content store)))}))
    (cursor-> :reel comp-reel states reel {}))))
