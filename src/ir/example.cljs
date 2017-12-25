
(ns ir.example (:require [ir.util :refer [id-mock cirru->tree]]))

(def base-app
  {:ns (let [expr ["ns" "app.core" [":require" [["hsl.core" ":refer" ["[]" "hsl"]]]]]]
     (cirru->tree expr "i" 0 (id-mock "NS"))),
   :proc (let [expr [["println" "|loaded"]]] (cirru->tree expr "i" 0 (id-mock "PROC")))})
