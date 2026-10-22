package vk;

import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import nk.b;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HashMap f22586b;

    public a() {
        this.f22586b = new HashMap();
        this.f22585a = "webx_webkit";
    }

    public static Object a() {
        Constructor<?>[] r5 = sk.a.class.getDeclaredConstructors();     // Catch: Throwable -> L9
        int r10 = r5.length;     // Catch: Throwable -> L9
        int r11 = 0;
    L4:
        if (r11 >= r10) goto L11;
        Constructor<?> r12 = r5[r11];     // Catch: Throwable -> L9
        if (r12.getParameterTypes().length == 0) goto L12;
        r11 = r11 + 1;
    L12:
        if (r12 == null) goto L29;
        r12.setAccessible(true);     // Catch: Throwable -> L9 InvocationTargetException -> L16 InstantiationException -> L18 IllegalAccessException -> L20
        return r12.newInstance(null);
    L20:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L9
    L18:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L9
    L16:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L9
    L29:
        throw new RuntimeException();     // Catch: Throwable -> L9
    L11:
        r12 = null;
    L9:
        th = move-exception;
        Log.e(qo.a.a("WebXImpl"), sk.a.class + "'s new instance return null", th);
        b.f20270b.getClass();
        throw null;
    }
}
