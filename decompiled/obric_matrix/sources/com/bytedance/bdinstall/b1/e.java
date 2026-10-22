package com.bytedance.bdinstall.b1;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<Class, Object> f2673a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<Class, d> f2674b = null;

    static {
        f2673a = new ConcurrentHashMap();
        f2674b = new ConcurrentHashMap();
    }

    public static <T> T a(Class<T> r4) {
        ConcurrentHashMap<Class, Object> r0 = f2673a;
        Object r1 = (T) r0.get(r4);
        if (r1 != null) goto L18;
        monitor-enter(r0);
        r1 = r0.get(r4);     // Catch: Throwable -> L15
        if (r1 != null) goto L13;
        ConcurrentHashMap<Class, d> r2 = f2674b;     // Catch: Throwable -> L15
        d r3 = r2.get(r4);     // Catch: Throwable -> L15
        if (r3 == null) goto L13;
        r1 = (T) r3.create(r4);
        if (r1 == null) goto L12;
        r0.put(r4, r1);     // Catch: Throwable -> L15
    L12:
        r2.remove(r4);     // Catch: Throwable -> L15
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    L18:
        return (T) r1;
    }

    public static <T> void b(Class<T> r1, T r2) {
        f2673a.put(r1, r2);
    }
}
