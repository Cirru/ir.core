
(ns ir.util (:require [bisection-key.core :as bisection] [ir.schema :as schema]))

(defn id-mock [prefix]
  (let [*id-base (atom 0)] (fn [] (swap! *id-base inc) (str prefix @*id-base))))

(defn cirru->tree [xs author timestamp id!]
  (if (vector? xs)
    (merge
     schema/expr
     {:time timestamp,
      :author author,
      :id (id!),
      :data (loop [result {}, ys xs, next-id bisection/mid-id]
        (if (empty? ys)
          result
          (let [y (first ys)]
            (recur
             (assoc result next-id (cirru->tree y author timestamp))
             (rest ys)
             (bisection/bisect next-id bisection/max-id)))))})
    (merge schema/leaf {:time timestamp, :author author, :text xs, :id (id!)})))
