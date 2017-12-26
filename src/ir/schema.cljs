
(ns ir.schema )

(def expr {:type :expr, :author nil, :time nil, :data {}})

(def file {:ns [], :defs {}, :proc []})

(def leaf {:type :leaf, :author nil, :time nil, :text "", :id nil})

(def store {:states {}, :content ""})
