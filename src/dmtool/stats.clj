(ns dmtool.stats
  (:require [dmtool.dice :as dice]))

(defn hardcore-stats
  []
    (reverse (sort (take 6 (repeatedly #(dice/roll 3 6))))))

(defn normal-stats
  []
    (reverse (sort (take 6 (repeatedly #(dice/roll 4 6 (dice/drop-low 1)))))))
