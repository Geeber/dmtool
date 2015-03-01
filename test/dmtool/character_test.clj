(ns dmtool.character-test
  (:require [clojure.test :refer :all]
            [dmtool.character :as character]
            [dmtool.dice :as dice]))

(deftest test-character
  (testing "Generate a random character."
    (let [c (character/character)]
      (is (contains? character/classes (:class (character/character))))
      (is (contains? character/races (:race (character/character)))))))
