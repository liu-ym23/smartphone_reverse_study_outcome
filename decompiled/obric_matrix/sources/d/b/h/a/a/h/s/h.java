package d.b.h.a.a.h.s;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.common.utility.Logger;
import com.ttnet.org.chromium.base.TTProcessUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicInteger f13761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile String f13762b;

    static {
        f13761a = new AtomicInteger(0);
        f13762b = null;
    }

    public static String a(Context r1) {
        if (com.bytedance.common.utility.k.c(f13762b) == false) goto L5;
        f13762b = e();
        if (com.bytedance.common.utility.k.c(f13762b) == false) goto L9;
        f13762b = d();
        if (com.bytedance.common.utility.k.c(f13762b) == false) goto L13;
        f13762b = c();
        if (com.bytedance.common.utility.k.c(f13762b) == false) goto L17;
        f13762b = b(r1);
        return f13762b;
    L17:
        return f13762b;
    L13:
        return f13762b;
    L9:
        return f13762b;
    L5:
        return f13762b;
    }

    private static String b(Context r4) {
        String r0 = null;
        if (r4 != null) goto L14;
        return null;
    L14:
        int r1 = Process.myPid();     // Catch: Exception -> L13
        Iterator<ActivityManager.RunningAppProcessInfo> r5 = ((ActivityManager) r4.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L13
    L7:
        if (r5.hasNext() == false) goto L12;
        ActivityManager.RunningAppProcessInfo r2 = r5.next();     // Catch: Exception -> L13
        if (r2.pid != r1) goto L7;
        Logger.debug();     // Catch: Exception -> L13
        r0 = r2.processName;     // Catch: Exception -> L13
    L12:
        return r0;
    }

    private static String c() {
        BufferedReader r1 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L11
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L16
    L5:
        int r3 = r1.read();     // Catch: Throwable -> L16
        if (r3 <= 0) goto L8;
        r2.append((char) r3);     // Catch: Throwable -> L16
        goto L5
    L8:
        Logger.debug();     // Catch: Throwable -> L16
        String r0 = r2.toString();     // Catch: Throwable -> L16
        r1.close();     // Catch: Exception -> L15
    L10:
        return r0;
    L12:
        if (r1 != null) goto L18;
    L14:
        return null;
    L18:
        r1.close();     // Catch: Exception -> L17
    L11:
        r1 = null;
        goto L12
    }

    private static String d() {
        Method r1 = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);     // Catch: Throwable -> L8
        r1.setAccessible(true);     // Catch: Throwable -> L8
        Object r2 = r1.invoke(null, new Object[0]);     // Catch: Throwable -> L8
        if ((r2 instanceof String) == false) goto L11;
        return (String) r2;
    L11:
        return null;
    L12:
        return null;
    }

    private static String e() {
        if (Build.VERSION.SDK_INT >= 28) goto L9;
        return null;
    L9:
        return Application.getProcessName();
    L11:
        return null;
    }

    public static int f() {
        return f13761a.get();
    }

    public static boolean g(Context r3) {
        String r0 = a(r3);
        if (r0 != null) goto L5;
    L7:
        if (r0 != null) goto L9;
        return false;
    L9:
        if (r0.equals(r3.getPackageName()) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r0.contains(":") == false) goto L7;
        return false;
    }

    public static boolean h(Context r2) {
        Logger.debug();
        int r0 = f();
        if (r0 != 1) goto L5;
        return true;
    L5:
        if (r0 != 2) goto L7;
        return false;
    L7:
        return g(r2);
    }

    public static boolean i(Context r1) {
        String r2 = a(r1);
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.endsWith(TTProcessUtils.MESSAGE_PROCESS_SUFFIX) == false) goto L7;
        return true;
    L7:
        if (r2.endsWith(TTProcessUtils.MESSAGE_PROCESS_SERVICE_SUFFIX) == false) goto L13;
        return true;
    L13:
        return false;
    }

    public static void j(int r1) {
        f13761a.set(r1);
    }
}
