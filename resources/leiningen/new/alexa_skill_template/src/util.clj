(ns {{namespace}}.util
  (:import [com.amazon.speech.speechlet SpeechletResponse]
           [com.amazon.speech.ui PlainTextOutputSpeech]))

(defn mk-plain-speech [text]
  (doto
    (PlainTextOutputSpeech.) (.setText text)))

(defn mk-tell-response [text]
  (SpeechletResponse/newTellResponse (mk-plain-speech text)))
