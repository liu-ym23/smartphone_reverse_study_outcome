package d.b.a.a.a.c;

import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static Field a(String r0, String r1) {
        Field r2 = Class.forName(r0).getDeclaredField(r1);     // Catch: Exception -> L4
        r2.setAccessible(true);     // Catch: Exception -> L4
        return r2;
    L4:
        return null;
    }

    public static Object b(String r0, String r1, Object r2) {
        Field r3 = Class.forName(r0).getDeclaredField(r1);     // Catch: Exception -> L4
        r3.setAccessible(true);     // Catch: Exception -> L4
        return r3.get(r2);
    L4:
        return null;
    }
}
