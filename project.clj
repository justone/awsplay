(defproject awsplay "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [amazonica "0.3.13"]
                 [aprint "0.1.3"]]
  :main ^:skip-aot awsplay.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
             :dev {:plugins [[mvxcvi/whidbey "1.0.0"]]}})
