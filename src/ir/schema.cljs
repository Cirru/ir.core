
(ns ir.schema )

(def store {:states {}, :content ""})

(def file {:ns [], :defs {}, :proc []})

(def expr {:type :expr, :author nil, :time nil, :data {}})

(def leaf {:type :leaf, :author nil, :time nil, :text "", :id nil})
