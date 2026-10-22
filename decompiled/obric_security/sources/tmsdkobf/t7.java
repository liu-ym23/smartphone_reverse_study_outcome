package tmsdkobf;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes5.dex */
public abstract class t7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Object f527a;
    private static Class b;
    private static Method c;
    private static Method d;
    private static Method e;
    private static Method f;

    static {
        Class<?> r0 = Class.forName("com.android.id.impl.IdProviderImpl");     // Catch: Exception -> L4
        b = r0;     // Catch: Exception -> L4
        f527a = r0.newInstance();     // Catch: Exception -> L4
        c = b.getMethod("getUDID", new Class[]{Context.class});     // Catch: Exception -> L4
        d = b.getMethod("getOAID", new Class[]{Context.class});     // Catch: Exception -> L4
        e = b.getMethod("getVAID", new Class[]{Context.class});     // Catch: Exception -> L4
        f = b.getMethod("getAAID", new Class[]{Context.class});     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("IdentifierManager", "reflect exception!", e);
    }

    public static String a(Context r1) {
        return a(r1, d);
    }

    private static String a(Context r3, Method r4) {
        Object r0 = f527a;
        if (r0 == null) goto L16;
        if (r4 != null) goto L14;
        return null;
    L14:
        Object r5 = r4.invoke(r0, new Object[]{r3});     // Catch: Exception -> L10
        if (r5 == null) goto L18;
        return (String) r5;
    L18:
        return null;
    L10:
        e = move-exception;
        Log.e("IdentifierManager", "invoke exception!", e);
        return null;
    L16:
        return null;
    }
}
