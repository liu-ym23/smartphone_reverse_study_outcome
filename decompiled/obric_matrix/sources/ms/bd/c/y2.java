package ms.bd.c;

import android.content.Context;
import android.location.LocationManager;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes2.dex */
public class y2 {
    private static z2 a(Context r9, String r10) {
        LocationManager r11 = (LocationManager) r9.getSystemService((String) m.a(16777217, 0, 0, "d7aa7c", new byte[]{121, 58, 17, 20, 28, 125, 104, 24}));     // Catch: Throwable -> L38
        if (r11 != null) goto L7;
        return z2.a(-10);
    L7:
        Field[] r0 = r11.getClass().getDeclaredFields();
        if (r0 != null) goto L12;
        int r12 = -20;
    L11:
        return z2.a(r12);
    L12:
        int r1 = r0.length;
        int r2 = 0;
    L13:
        Object r3 = null;
        if (r2 >= r1) goto L33;
        Field r4 = r0[r2];
        r4.setAccessible(true);
        Object r5 = r4.get(r11);     // Catch: IllegalAccessException -> L32
        if (r5 == null) goto L31;
        if ((r5 instanceof String) == true) goto L31;
        Class<?>[] r6 = r5.getClass().getInterfaces();
        if (r6 == null) goto L31;
        if (r6.length == 0) goto L31;
        if (r10.equals(r6[0].getName()) == false) goto L31;
        Field r13 = r4;
        r3 = r5;
    L34:
        if (r3 != null) goto L37;
        r12 = -22;
        goto L11
    L37:
        return new z2(r3 instanceof Proxy ? 1 : 0, r13.getName(), r3.getClass().getName());
    L31:
        r2 = r2 + 1;
    L32:
        r12 = -21;
        goto L11
    L33:
        r13 = null;
    L38:
        r12 = -11;
        goto L11
    }

    public static z2 b(Context r0, String r1) {
        return a(r0, r1);
    L4:
        th = move-exception;
        return z2.b(-100, th);
    }
}
