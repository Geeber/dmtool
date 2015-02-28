(ns dmtool.dice
  (import
    java.util.Random))


(def ^:dynamic *roll-gen*
  "Function which returns a int from 1 to d"
  (let [rng (Random.)]
    #(inc (.nextInt rng %))))


(defn roll-dice
  [n d modifiers]
  (let [raw-rolls (take n (map *roll-gen* (repeat d)))]
    (reduce #(cons (%2 (first %1)) %1) (list raw-rolls) modifiers)))


(defn roll
  "Roll some dice and return the sum"
  ([d]
   (roll 1 d))
  ([n d & modifiers]
   (reduce + (first (roll-dice n d modifiers)))))


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


(defn drop-low
  ""
  [n]
  (fn [s] (drop n (sort s))))


(defn drop-high
  ""
  [n]
  (fn [s] (drop n (reverse (sort s)))))


(defn keep-low
  ""
  [n]
  (fn [s] (take n (sort s))) )


(defn keep-high
  ""
  [n]
  (fn [s] (take n (reverse (sort s)))))

