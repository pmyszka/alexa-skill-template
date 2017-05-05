(ns leiningen.new.alexa-skill-template
  (:require [leiningen.new.templates :as tmpl]
            [leiningen.core.main :as main]))

(def render (tmpl/renderer "alexa-skill-template"))

(defn alexa-skill-template
  [name]
  (let [top-ns  (tmpl/sanitize-ns name)
        main-ns (tmpl/multi-segment top-ns)
        data {:raw-name      name
              :name          (tmpl/project-name name)
              :top-namespace top-ns
              :namespace     main-ns
              :top-dir       (tmpl/name-to-path top-ns)
              :nested-dirs   (tmpl/name-to-path main-ns)
              :year          (tmpl/year)
              :date          (tmpl/date)}]
    (main/info "Generating new alexa-skill-template project.")
    (tmpl/->files data
             ["LICENSE"  (render "LICENSE" data)]

             ["project.clj" (render "project.clj" data)]
             [".gitignore"  (render ".gitignore" data)]

             ["src/{{nested-dirs}}/speechlet_request_handler.clj" (render "src/speechlet_request_handler.clj" data)]
             ["src/{{nested-dirs}}/util.clj"  (render "src/util.clj" data)]
             ["src/{{nested-dirs}}/intent/sample_intent.clj"  (render "src/intent/sample_intent.clj" data)]

             ["test/{{nested-dirs}}/test_helper.clj" (render "test/test_helper.clj" data)]
             ["test/{{nested-dirs}}/intent/sample_intent_test.clj" (render "test/intent/sample_intent_test.clj" data)]

             ["resources/log4j.properties" (render "resources/log4j.properties" data)]
             ["resources/intents.json" (render "resources/intents.json" data)]
             ["resources/utterances.txt" (render "resources/utterances.txt" data)]

             ["scripts/{{raw-name}}-assume-role-policy.json" (render "scripts/assume-role-policy.json" data)]
             ["scripts/{{raw-name}}-execution-policy.json" (render "scripts/execution-policy.json" data)]
             ["scripts/{{raw-name}}-install" (render "scripts/lambda-install" data)]
             ["scripts/{{raw-name}}-uninstall" (render "scripts/lambda-uninstall" data)]
             "resources")))
