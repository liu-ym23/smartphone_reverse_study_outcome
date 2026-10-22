package com.google.crypto.tink.monitoring;

import com.google.errorprone.annotations.Immutable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class MonitoringAnnotations {
    public static final MonitoringAnnotations EMPTY = null;
    private final Map<String, String> entries;

    /* JADX INFO: renamed from: com.google.crypto.tink.monitoring.MonitoringAnnotations$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private HashMap<String, String> builderEntries;

        public Builder() {
            this.builderEntries = new HashMap();
        }

        public Builder addAll(Map<String, String> newEntries) {
            HashMap<String, String> r0 = this.builderEntries;
            if (r0 == null) goto L7;
            r0.putAll(newEntries);
            return this;
        L7:
            throw new IllegalStateException("addAll cannot be called after build()");
        }

        public Builder add(String name, String value) {
            HashMap<String, String> r0 = this.builderEntries;
            if (r0 == null) goto L7;
            r0.put(name, value);
            return this;
        L7:
            throw new IllegalStateException("add cannot be called after build()");
        }

        public MonitoringAnnotations build() {
            if (this.builderEntries == null) goto L7;
            MonitoringAnnotations r0 = new MonitoringAnnotations(Collections.unmodifiableMap(this.builderEntries), null);
            this.builderEntries = null;
            return r0;
        L7:
            throw new IllegalStateException("cannot call build() twice");
        }
    }

    /* synthetic */ MonitoringAnnotations(Map r1, AnonymousClass1 r2) {
        this(r1);
    }

    static {
        EMPTY = newBuilder().build();
    }

    private MonitoringAnnotations(Map<String, String> entries) {
        this.entries = entries;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Map<String, String> toMap() {
        return this.entries;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof MonitoringAnnotations) == true) goto L7;
        return false;
    L7:
        return this.entries.equals(((MonitoringAnnotations) obj).entries);
    }

    public int hashCode() {
        return this.entries.hashCode();
    }

    public String toString() {
        return this.entries.toString();
    }
}
