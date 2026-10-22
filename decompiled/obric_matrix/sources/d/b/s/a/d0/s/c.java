package d.b.s.a.d0.s;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<Class, d.b.s.a.d0.r.c> f14712a;

    static {
        f14712a = new ConcurrentHashMap();
    }

    public static <T extends d.b.s.a.d0.r.c> T a(Class<T> r1) {
        return (T) f14712a.get(r1);
    }

    public static <T extends d.b.s.a.d0.r.c> void b(Class<T> r1, d.b.s.a.d0.r.c r2) {
        if (r2 == null) goto L5;
        f14712a.put(r1, r2);
        return;
    }
}
