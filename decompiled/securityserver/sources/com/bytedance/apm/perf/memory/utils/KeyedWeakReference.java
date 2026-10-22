package com.bytedance.apm.perf.memory.utils;

import a.a;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class KeyedWeakReference extends WeakReference<Object> {
    public final String key;
    public final String name;

    public KeyedWeakReference(Object r2, String r3, String r4, ReferenceQueue<Object> r5) {
        super(checkNotNull(r2, "referent"), (ReferenceQueue) checkNotNull(r5, "referenceQueue"));
        this.key = (String) checkNotNull(r3, "key");
        this.name = (String) checkNotNull(r4, "name");
    }

    public static <T> T checkNotNull(T r1, String r2) {
        if (r1 == null) goto L5;
        return r1;
    L5:
        throw new NullPointerException(a.j(r2, " must not be null"));
    }
}
