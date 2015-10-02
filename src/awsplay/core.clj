(ns awsplay.core
  (:gen-class)
  (:require [clojure.pprint :refer :all]
            [amazonica.core :refer :all]
            [amazonica.aws.identitymanagement :refer :all]
            [amazonica.aws.s3 :refer :all]
            [amazonica.aws.ec2 :refer :all]
            [amazonica.core :refer :all]
            [awsplay.util :refer :all]
            [aprint.core :refer :all]))

; don't wrap in the root!
(set-root-unwrapping! true)
