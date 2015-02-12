(ns awsplay.core
  (:gen-class)
  (:require [clojure.pprint :refer [pprint]]
            [amazonica.core :refer :all]
            [reply.main]))

(defn -main
  "Start up a repl."
  [& args]

  ; don't wrap in the root!
  (set-root-unwrapping! true)

  ; import amazonica subs into the 'user' ns, because reply doesn't support setting the ns to this one
  (create-ns 'user)
  (in-ns 'user)
  (require '[amazonica.aws.identitymanagement :refer :all])
  (require '[amazonica.aws.s3 :refer :all])
  (require '[amazonica.aws.ec2 :refer :all])

  ; start the repl!
  (reply.main/launch-standalone {
                                 :value-to-string (fn [v] (with-out-str (clojure.pprint/pprint v)))
                                 :print-err (fn [e] (clojure.pprint/pprint (if (instance? com.amazonaws.AmazonServiceException e) (ex->map e) e)))}))
