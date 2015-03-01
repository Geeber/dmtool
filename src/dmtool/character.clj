(ns dmtool.character
  (:require [dmtool.dice :as dice]
            [dmtool.stats :as stats]))

(def classes #{:barbarian :bard :cleric :druid :fighter :monk :paladin
               :ranger :rogue :sorceror :warlock :wizard})

(def races #{:elf :dragonborn :dwarf :gnome :half-elf :half-orc
             :halfling :human :tiefling})


(defn pick-class
  [c]
  (if (:class c) c (assoc c :class (rand-nth (seq classes)))))


(defn pick-race
  [c]
  (if (:race c) c (assoc c :race (rand-nth (seq races)))))


(def character-generator
  (comp pick-class pick-race))


(defn character
  ([]
   (character {}))
  ([inputs]
   (character-generator inputs)))
