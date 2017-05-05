(ns {{namespace}}.intent.sample-intent-test
  (:require [clojure.test :refer :all]
            [{{namespace}}.test-helper :as th]
            [{{namespace}}.intent.sample-intent :as intent]))

(deftest sample-intent-test
  (testing "Testing sample-intent"
    (is
      (=
        (.getText
          (.getOutputSpeech
            (intent/sample-intent (th/build-session) {})))
        "Hello"))))
