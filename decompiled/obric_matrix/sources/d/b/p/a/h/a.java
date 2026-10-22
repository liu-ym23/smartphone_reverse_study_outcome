package d.b.p.a.h;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Field> f14306a = null;

    static {
        f14306a = new HashMap();
    }

    public static Field a(Class<?> r4, String r5) {
        f.b(r4, "The class must not be null");
        f.c(!TextUtils.isEmpty(r5), "The field name must not be blank");
        String r0 = b(r4, r5);
        Map<String, Field> r2 = f14306a;
        monitor-enter(r2);
        Field r3 = r2.get(r0);     // Catch: Throwable -> L35
        monitor-exit(r2);     // Catch: Throwable -> L35
        if (r3 != null) goto L8;
    L11:
        if (r4 == null) goto L33;
    L32:
        r4 = r4.getSuperclass();
        goto L11
    L13:
        if (e.a() == true) goto L15;
    L18:
        Field r6 = r4.getDeclaredField(r5);     // Catch: NoSuchFieldException -> L32
    L19:
        if (r6 == null) goto L31;
        if (r6.isAccessible() == true) goto L23;
        r6.setAccessible(true);     // Catch: NoSuchFieldException -> L32
    L23:
        Map<String, Field> r7 = f14306a;     // Catch: NoSuchFieldException -> L32
        monitor-enter(r7);     // Catch: NoSuchFieldException -> L32
        r7.put(r0, r6);     // Catch: Throwable -> L28
        monitor-exit(r7);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;     // Catch: NoSuchFieldException -> L32
    L31:
        return r6;
    L15:
        if (c.a() == null) goto L18;
        r6 = c.a().b(r4, r5);     // Catch: NoSuchFieldException -> L32
        if (r6 != null) goto L19;
    L33:
        return null;
    L8:
        if (r3.isAccessible() == true) goto L10;
        r3.setAccessible(true);
    L10:
        return r3;
    L35:
        th = move-exception;
        throw th;
    }

    private static String b(Class<?> r1, String r2) {
        return r1.toString() + "#" + r2;
    }

    public static Object c(Field r3, Object r4) {
        if (r3 == null) goto L5;
        boolean r1 = true;
    L6:
        f.a(r1, "The field must not be null");
        if (r3.isAccessible() == true) goto L10;
        r3.setAccessible(true);
    L10:
        return r3.get(r4);
    L5:
        r1 = false;
        goto L6
    }

    public static Object d(Class<?> r0, String r1) {
        Field r2 = a(r0, r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return e(r2);
    }

    public static Object e(Field r1) {
        f.b(r1, "The field must not be null");
        return c(r1, null);
    }
}
