package tmsdkobf;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public abstract class sf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashMap f511a;
    public static HashMap b;

    static {
        new HashMap();
        f511a = new HashMap();
        b = new HashMap();
    }

    public static Object a(Class r3, String r4, Object r5) {
        HashMap r1 = (HashMap) f511a.get(r3);     // Catch: Throwable -> L13
        if (r1 != null) goto L6;
        r1 = new HashMap();     // Catch: Throwable -> L13
        f511a.put(r3, r1);     // Catch: Throwable -> L13
    L6:
        Field r2 = (Field) r1.get(r4);     // Catch: Throwable -> L13
        if (r2 != null) goto L9;
        r2 = r3.getDeclaredField(r4);     // Catch: Throwable -> L13
    L9:
        if (r2 == null) goto L15;
        r2.setAccessible(true);     // Catch: Throwable -> L13
        r1.put(r4, r2);     // Catch: Throwable -> L13
    L16:
        if (r2 != null) goto L18;
        return null;
    L18:
        return r2.get(r5);
    L15:
        r2 = null;
    L20:
        th = move-exception;
        th.printStackTrace();
        return null;
    L13:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L20
        goto L15
    }

    public static Method a(Class r5, String r6, Class... r7) {
        if (r5 != null) goto L26;
    L25:
        return null;
    L26:
    L23:
        th = move-exception;
        th.printStackTrace();
        goto L25
    L5:
        if (TextUtils.isEmpty(r6) == true) goto L25;
        StringBuffer r1 = new StringBuffer(r6);     // Catch: Throwable -> L23
        if (r7 == null) goto L13;
        int r2 = 0;
    L11:
        if (r2 >= r7.length) goto L13;
        Class r3 = r7[r2];     // Catch: Throwable -> L23
        r1.append("+");     // Catch: Throwable -> L23
        r1.append(r3.getName());     // Catch: Throwable -> L23
        r2 = r2 + 1;     // Catch: Throwable -> L23
    L13:
        String r4 = r1.toString();     // Catch: Throwable -> L23
        HashMap r8 = (HashMap) b.get(r5);     // Catch: Throwable -> L23
        if (r8 != null) goto L16;
        r8 = new HashMap();     // Catch: Throwable -> L23
        b.put(r5, r8);     // Catch: Throwable -> L23
    L16:
        Method r9 = (Method) r8.get(r4);     // Catch: Throwable -> L23
        if (r9 != null) goto L19;
        r9 = r5.getDeclaredMethod(r6, r7);     // Catch: Throwable -> L23
    L19:
        if (r9 != null) goto L21;
        return null;
    L21:
        r9.setAccessible(true);     // Catch: Throwable -> L23
        r8.put(r4, r9);     // Catch: Throwable -> L23
        return r9;
    }
}
