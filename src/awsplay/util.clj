(ns awsplay.util
  (:require [clojure.pprint :refer [pprint]]
            [amazonica.aws.ec2 :refer [describe-instances]]
            [clojure.string :refer [lower-case]]))

(defn flatten-tags [b]
  (->> (:tags b)
       (map (juxt (comp keyword lower-case :key) :value))
       (into {})
       (assoc b :tags)))

(defn ainstances []
  (->> (describe-instances)
       (map :instances)
       (map first)
       (map #(select-keys % [:state :tags :public-ip-address :image-id :instance-id]))
       (map flatten-tags)))

(comment
  (pprint (ainstances))
  (flatten-tags {:tags [{:key "foo" :value "bar"}{:key "foo2" :value "bar2"}]})
  ((comp keyword :key) {:key "foo"})
)
