package d.b.b.n;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<Class, Object> f13036a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<Class, a<?>> f13037b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap<Class, b> f13038c = null;

    static {
        f13036a = new ConcurrentHashMap();
        f13037b = new ConcurrentHashMap();
        f13038c = new ConcurrentHashMap();
    }

    public c() {
    }

    public static <T> T a(Class<T> r4) {
        T r0 = (T) f13036a.get(r4);
        if (r0 == null) goto L5;
    L18:
        return r0;
    L5:
        monitor-enter(c.class);
        ConcurrentHashMap<Class, a<?>> r2 = f13037b;     // Catch: Throwable -> L15
        a<?> r3 = r2.get(r4);     // Catch: Throwable -> L15
        if (r3 == null) goto L13;
        r0 = (T) r3.create();
        r2.remove(r4);     // Catch: Throwable -> L15
        if (r0 == null) goto L13;
        b(r4, r0);     // Catch: Throwable -> L15
        monitor-exit(c.class);     // Catch: Throwable -> L15
        return r0;
    L13:
        monitor-exit(c.class);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    private static <T> void b(Class<T> r2, T r3) {
        f13036a.put(r2, r3);
        ConcurrentHashMap<Class, b> r0 = f13038c;
        b r1 = r0.get(r2);
        if (r1 == null) goto L6;
        r1.a(r3);
        r0.remove(r2);
        return;
    }

    public static <T> void c(Class<T> r1, a<T> r2) {
        f13037b.put(r1, r2);
    }

    public static <T> void d(Class<T> r1, T r2) {
        f13036a.put(r1, r2);
    }
}
