(ns dmtool.dice
  (import
    java.util.Random))

(def ^:dynamic *rng* (Random.))

(defn roll
  "Roll a die"
  ([]
   (roll 6))
  ([d]
   (inc (.nextInt *rng* d))))

(defn forced-rng
  [roll-map]
  (let [forced-rolls (atom roll-map)
        source-rng *rng*]
    (proxy [Random] []
      (nextInt
        [d]
        (if-let [rolls (seq (get @forced-rolls d))]
          (do
            (swap! forced-rolls update-in [d] (partial drop 1))
            (dec (first rolls)))
          (.nextInt source-rng d))
        )
      ))
  )

(defmacro with-rolls
  "Force the next rolls of the specified die"
  [roll-map & body]
  `(binding [*rng* (forced-rng ~roll-map)]
     ~@body))
