package ug;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f22353a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f22354b = null;

    static {
        f22353a = new ConcurrentHashMap();
        f22354b = new ConcurrentHashMap();
    }

    public static Object a(Class r5, c r10) {
        ConcurrentHashMap r11 = f22353a;
        Object r12 = r11.get(r5);
        if (r12 != null) goto L29;
        ConcurrentHashMap r13 = f22354b;
        monitor-enter(r13);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (r13.containsKey(r5) == false) goto L11;
        Object r14 = r13.get(r5);     // Catch: Throwable -> L9
    L12:
        if (r14 != null) goto L14;
        r14 = new Object();     // Catch: Throwable -> L9
        r13.put(r5, r14);     // Catch: Throwable -> L9
    L14:
        monitor-exit(r13);     // Catch: Throwable -> L9
        monitor-enter(r14);
        Object r15 = r11.get(r5);     // Catch: Throwable -> L21
        if (r15 != null) goto L23;
        r15 = r10.create(r5);     // Catch: Throwable -> L21
        if (r15 == null) goto L23;
        r11.put(r5, r15);     // Catch: Throwable -> L21
    L23:
        monitor-exit(r14);     // Catch: Throwable -> L21
        return r15;
    L21:
        th = move-exception;
        throw th;
    L11:
        r14 = null;
        goto L12
    L29:
        ConcurrentHashMap r16 = f22354b;
        if (r16.containsKey(r5) == false) goto L32;
        r16.remove(r5);
    L32:
        return r12;
    }
}
