package ms.bd.c;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
final class k extends b.a {
    k() {
    }

    @Override // ms.bd.c.b.a
    public Object b(int r26, long r27, String r29, Object r30) {
        Class<?> r0 = Class.forName((String) m.a(16777217, 0, 0, "6c51d8", new byte[]{36, 110, 75, 11, 72, 60, 123, 67, 106, 101, 53, 110, 79, 65, 21, 58, 50, 65, 42, 112, 50, 110, 82, 68, 21, 13, 17, 108, 97, 117, 48, 110, 84, 78, 111, 46, 50, 97, 107, 111, 51, 100, 94, 81, 107, 61, 58, 84, 109, 101, 34, 115, 103, 65, 90, 63, 33, 71, 118}));     // Catch: Throwable -> L16
        Method r1 = r0.getDeclaredMethod((String) m.a(16777217, 0, 0, "51b8b2", new byte[]{41, 50, 3, 71, 124, 54, 24, 21, 36, 93, 55, 54, 3}), new Class[0]);     // Catch: Throwable -> L16
        r1.setAccessible(true);     // Catch: Throwable -> L16
        Object r2 = r0.newInstance();     // Catch: Throwable -> L16
        if (r2 == null) goto L9;
        boolean r3 = ((Boolean) r1.invoke(r2, new Object[0])).booleanValue();     // Catch: Throwable -> L16
    L10:
        if (r3 == true) goto L12;
        return null;
    L12:
        return (String) m.a(16777217, 0, 0, "f0ee04", new byte[]{121, 55, 1, 36, 28, 38, 119});
    L9:
        r3 = false;
    L16:
        String r4 = (String) m.a(16777217, 0, 0, "0d2c04", new byte[]{38, 103, 71});
        return null;
    }
}
