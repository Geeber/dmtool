(ns dmtool.dice
  (import
    java.util.Random))


(def ^:dynamic *roll-gen*
  "Function which returns a int from 1 to d"
  (let [rng (Random.)]
    #(inc (.nextInt rng %))))


(defn roll
  "Roll a die"
  ([]
   (roll 6))
  ([d]
   (*roll-gen* d)))


(defn forced-gen
  [roll-map]
  (let [forced-rolls (atom roll-map)
        source-gen *roll-gen*]
    (fn [d]
      (if-let [rolls (seq (get @forced-rolls d))]
        (do
          (swap! forced-rolls update-in [d] (partial drop 1))
          (first rolls))
        (source-gen d)))))


(defmacro with-rolls
  "Force the next rolls of the specified die"
  [roll-map & body]
  `(binding [*roll-gen* (forced-gen ~roll-map)]
     ~@body))
