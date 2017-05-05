(defproject {{raw-name}} "0.1.0-SNAPSHOT"
  :description "{{raw-name}}"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [
                  [com.climate/boomhauer "0.1.1"]
                  [com.amazon.alexa/alexa-skills-kit "1.2"]
                  [org.clojure/clojure "1.8.0"]
                  [proto-repl "0.3.1"]]
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  :aot [{{namespace}}.speechlet-request-handler])
