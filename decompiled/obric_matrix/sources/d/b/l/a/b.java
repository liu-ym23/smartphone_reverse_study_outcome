package d.b.l.a;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Field> f14090a = null;

    static {
        f14090a = new HashMap();
    }

    public static Field a(Class<?> r4, String r5) {
        String r0 = b(r4, r5);
        Map<String, Field> r1 = f14090a;
        monitor-enter(r1);
        Field r2 = r1.get(r0);     // Catch: Throwable -> L27
        monitor-exit(r1);     // Catch: Throwable -> L27
        if (r2 != null) goto L9;
    L12:
        if (r4 == null) goto L25;
        Field r3 = r4.getDeclaredField(r5);     // Catch: NoSuchFieldException -> L24
        if (r3.isAccessible() == true) goto L16;
        r3.setAccessible(true);     // Catch: NoSuchFieldException -> L24
    L16:
        Map<String, Field> r6 = f14090a;     // Catch: NoSuchFieldException -> L24
        monitor-enter(r6);     // Catch: NoSuchFieldException -> L24
        r6.put(r0, r3);     // Catch: Throwable -> L21
        monitor-exit(r6);     // Catch: Throwable -> L21
    L20:
        return r3;
    L21:
        th = move-exception;
        throw th;     // Catch: NoSuchFieldException -> L24
    L24:
        r4 = r4.getSuperclass();
        goto L12
    L25:
        return null;
    L9:
        if (r2.isAccessible() == true) goto L11;
        r2.setAccessible(true);
    L11:
        return r2;
    L27:
        th = move-exception;
        throw th;
    }

    private static String b(Class<?> r1, String r2) {
        return r1.toString() + "#" + r2;
    }

    public static Object c(Object r1, String r2) {
        Field r3 = a(r1.getClass(), r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return d(r3, r1);
    }

    public static Object d(Field r1, Object r2) {
        if (r1.isAccessible() == true) goto L6;
        r1.setAccessible(true);
    L6:
        return r1.get(r2);
    }
}
