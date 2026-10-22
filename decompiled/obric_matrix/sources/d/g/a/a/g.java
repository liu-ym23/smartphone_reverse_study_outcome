package d.g.a.a;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static String a() {
        if (Build.VERSION.SDK_INT < 28) goto L39;
        return Application.getProcessName();
    L39:
        Method r1 = Class.forName("android.app.ActivityThread").getMethod("currentProcessName", new Class[0]);     // Catch: Exception -> L9
        r1.setAccessible(true);     // Catch: Exception -> L9
        return (String) r1.invoke(null, new Object[0]);
    L9:
        BufferedReader r2 = new BufferedReader(new FileReader("/proc/self/cmdline"));     // Catch: Throwable -> L20 Exception -> L25
        String r3 = r2.readLine();     // Catch: Throwable -> L18 Exception -> L32
        if (TextUtils.isEmpty(r3) == true) goto L33;
        String r4 = r3.trim();     // Catch: Throwable -> L18 Exception -> L32
        if (TextUtils.isEmpty(r4) == true) goto L33;
        r2.close();     // Catch: Exception -> L29
    L15:
        return r4;
    L33:
        r2.close();     // Catch: Exception -> L30
    L28:
        return null;
    L18:
        Throwable th = th;
    L22:
        if (r2 != null) goto L35;
    L24:
        throw th;
    L35:
        r2.close();     // Catch: Exception -> L31
    L26:
        if (r2 == null) goto L28;
    L25:
        r2 = null;
    L20:
        th = move-exception;
        r2 = null;
        th = th;
        goto L22
    }

    public static boolean b(Context r4) {
        String r0 = a();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.contains(":") == false) goto L9;
        return false;
    L9:
        if (r0.equals(r4.getPackageName()) == false) goto L12;
        return true;
    L12:
        if (r0.equals(r4.getApplicationInfo().processName) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public static boolean c() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }
}
