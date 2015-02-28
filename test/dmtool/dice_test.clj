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

(deftest roll-4d6d1
  (testing "Roll 4d, drop the lowest")
    (with-rolls {6 [1 5 6 4]}
      (is (= 15 (roll 4 6 (drop-low 1))))))

(deftest roll-5d8
  (testing "Roll 5d8."
    (with-rolls {8 [2 8 5 2 3]}
      (is (= 20 (roll 5 8))))
    (with-rolls {8 [2 8 5 2 3]}
      (is (= [[2 8 5 2 3]] (roll-dice 5 8 nil))))))
