package d.b.w.a.d;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f15254a;

    static {
        Method[] r0 = Class.forName("android.os.SystemProperties").getMethods();     // Catch: ClassNotFoundException -> L15
        int r1 = r0.length;     // Catch: ClassNotFoundException -> L15
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L25;
        Method r3 = r0[r2];     // Catch: ClassNotFoundException -> L15
        String r4 = r3.getName();     // Catch: ClassNotFoundException -> L15
        if (r4.equals("get") == false) goto L8;
        f15254a = r3;     // Catch: ClassNotFoundException -> L15
    L14:
        r2 = r2 + 1;
        goto L3
    L8:
        if (r4.equals("set") == true) goto L14;
        if (r4.equals("getLong") == true) goto L14;
        r4.equals("getInt");     // Catch: ClassNotFoundException -> L15
        goto L14
    L25:
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
    }

    public static String a(String r4, String r5) {
        Method r0 = f15254a;
        if (r0 != null) goto L15;
        return r5;
    L15:
        return (String) r0.invoke(null, new Object[]{r4, r5});
    L10:
        e = move-exception;
        e.printStackTrace();
    L14:
        return r5;
    L12:
        e = move-exception;
        e.printStackTrace();
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }
}
