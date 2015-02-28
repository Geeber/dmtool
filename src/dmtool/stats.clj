(ns dmtool.stats
  (:require [dmtool.dice :as dice]))

(defn hardcore-stats
  []
    (reverse (sort (take 6 (repeatedly #(dice/roll 3 6))))))
