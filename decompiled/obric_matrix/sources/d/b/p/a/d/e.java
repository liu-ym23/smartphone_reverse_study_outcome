package d.b.p.a.d;

import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static Field a(Class<?> r6, String r7) {
        Field r8 = (Field) Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(r6, new Object[]{r7});     // Catch: Throwable -> L4
        r8.setAccessible(true);     // Catch: Throwable -> L4
        return r8;
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }
}
