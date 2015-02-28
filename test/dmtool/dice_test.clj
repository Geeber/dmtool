(ns dmtool.dice-test
  (:require [clojure.test :refer :all]
            [dmtool.dice :refer :all]))

(deftest roll-1d6
  (testing "Roll a d6."
    (with-rolls {6 [1 2 3 4 5 6]}
      (is (= 1 (roll 6)))
      (is (= 2 (roll 6)))
      (is (= 3 (roll 6)))
      (is (= 4 (roll 6)))
      (is (= 5 (roll 6)))
      (is (= 6 (roll 6)))
      (is (pos? (roll 6)))
      (is (<= (roll 6) 6)))))
