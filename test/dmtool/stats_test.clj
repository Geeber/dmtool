(ns dmtool.stats-test
  (:require [clojure.test :refer :all]
            [dmtool.stats :refer :all]
            [dmtool.dice :as dice]))

(deftest test-normal-stats
  (testing "Generate stats using the normal (4d6 drop 1) method."
    (dice/with-rolls {6 [1 2 3 5
                         6 3 3 4
                         1 3 4 2
                         4 6 3 4
                         2 1 1 4
                         6 2 5 6]}
      (is (= (normal-stats) [17 14 13 10 9 7])))))

(deftest test-hardcore-stats
  (testing "Generate stats using the hardcore method."
    (dice/with-rolls {6 [2 2 2 4 4 4 1 1 1 5 5 5 6 6 6 3 3 3]}
      (is (= (hardcore-stats) [18 15 12 9 6 3])))))
