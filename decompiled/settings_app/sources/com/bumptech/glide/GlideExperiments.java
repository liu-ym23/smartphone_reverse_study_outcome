package com.bumptech.glide;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class GlideExperiments {
    private final Map<Class<?>, Experiment> experiments;

    static final class Builder {
        private final Map<Class<?>, Experiment> experiments;

        Builder() {
            this.experiments = new HashMap();
        }

        static /* synthetic */ Map access$000(Builder r0) {
            return r0.experiments;
        }

        Builder update(Experiment r1, boolean r2) {
            if (r2 == false) goto L4;
            add(r1);
        L5:
            return this;
        L4:
            this.experiments.remove(r1.getClass());
            goto L5
        }

        Builder add(Experiment r3) {
            this.experiments.put(r3.getClass(), r3);
            return this;
        }

        GlideExperiments build() {
            return new GlideExperiments(this);
        }
    }

    interface Experiment {
    }

    GlideExperiments(Builder r2) {
        this.experiments = Collections.unmodifiableMap(new HashMap(Builder.access$000(r2)));
    }

    <T extends Experiment> T get(Class<T> r1) {
        return (T) this.experiments.get(r1);
    }

    public boolean isEnabled(Class<? extends Experiment> r1) {
        return this.experiments.containsKey(r1);
    }
}
