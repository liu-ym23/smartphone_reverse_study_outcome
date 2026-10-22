package com.bytedance.news.common.settings.h;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<Class, Object> f5324a = null;

    static {
        f5324a = new ConcurrentHashMap();
    }

    public b() {
    }

    public static <T> T a(Class<T> r3, c r4) {
        ConcurrentHashMap<Class, Object> r0 = f5324a;
        Object r1 = (T) r0.get(r3);
        if (r1 == null) goto L5;
    L17:
        return (T) r1;
    L5:
        monitor-enter(b.class);
        r1 = r0.get(r3);     // Catch: Throwable -> L14
        if (r1 != null) goto L12;
        Object r5 = r4.create(r3);     // Catch: Throwable -> L14
        if (r5 == null) goto L11;
        r0.put(r3, r5);     // Catch: Throwable -> L14
    L11:
        r1 = (T) r5;
    L12:
        monitor-exit(b.class);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }
}
