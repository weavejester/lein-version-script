(ns lein-version-script.plugin
  (:require [clojure.java.shell :refer [sh]]
            [clojure.string :as str]
            [leiningen.core.main :as main]))

(defn- get-version [script]
  (let [ret (sh "bash" "-c" script)]
    (when-not (zero? (:exit ret))
      (main/abort "External script in :version-script failed with exit code" (:exit ret)))
    (when (str/blank? (:out ret))
      (main/abort "External script in :version-script did not output anything"))
    (str/trim (:out ret))))

(defn middleware [project]
  (if-let [version (some-> project :version-script get-version)]
    (assoc project :version version)
    project))
