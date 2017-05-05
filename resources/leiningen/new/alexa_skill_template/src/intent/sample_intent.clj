(ns {{namespace}}.intent.sample-intent
  (:require [com.climate.boomhauer.intent-handler :refer [defintent]]
          [{{namespace}}.util :as u]))

(defn sample-intent [session session-map]
  (u/mk-tell-response "Hello"))

(defintent :SampleIntent sample-intent)
