(ns {{namespace}}.speechlet-request-handler
  (:gen-class
    :name {{namespace}}.SpeechletRequestHandler
    :extends com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler
    :init "init"
    :constructors {[] [com.amazon.speech.speechlet.Speechlet java.util.Set]})

  (:use [{{namespace}}.intent.sample-intent])

  (:import [com.climate.boomhauer BoomhauerSpeechlet]))

(defn -init []
  [[(BoomhauerSpeechlet.), #{}] nil])
