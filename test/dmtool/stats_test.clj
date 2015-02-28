(ns dmtool.stats-test
  (:require [clojure.test :refer :all]
            [dmtool.stats :refer :all]
            [dmtool.dice :as dice]))

(deftest test-hardcore-stats
  (testing "Generate stats using the hardcore method."
    (dice/with-rolls {6 [2 2 2 4 4 4 1 1 1 5 5 5 6 6 6 3 3 3]}
      (is (= (hardcore-stats) [18 15 12 9 6 3])))))
