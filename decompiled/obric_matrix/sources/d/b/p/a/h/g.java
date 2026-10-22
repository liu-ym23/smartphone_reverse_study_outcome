package d.b.p.a.h;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f14312a;

    private static String a() {
        BufferedReader r1 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L11
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L16
    L5:
        int r3 = r1.read();     // Catch: Throwable -> L16
        if (r3 <= 0) goto L8;
        r2.append((char) r3);     // Catch: Throwable -> L16
        goto L5
    L8:
        String r0 = r2.toString();     // Catch: Throwable -> L16
        r1.close();     // Catch: Exception -> L15
    L10:
        return r0;
    L12:
        if (r1 != null) goto L22;
    L14:
        return null;
    L22:
        r1.close();     // Catch: Exception -> L17
    L11:
        r1 = null;
        goto L12
    }

    public static String b(Context r3) {
        if (TextUtils.isEmpty(f14312a) == false) goto L5;
        int r0 = Process.myPid();     // Catch: Exception -> L13
        Iterator<ActivityManager.RunningAppProcessInfo> r4 = ((ActivityManager) r3.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L13
    L8:
        if (r4.hasNext() == false) goto L15;
        ActivityManager.RunningAppProcessInfo r1 = r4.next();     // Catch: Exception -> L13
        if (r1.pid != r0) goto L8;
        String r5 = r1.processName;     // Catch: Exception -> L13
        f14312a = r5;     // Catch: Exception -> L13
        return r5;
    L15:
        String r6 = a();
        f14312a = r6;
        return r6;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L5:
        return f14312a;
    }

    public static boolean c(Context r3) {
        String r0 = b(r3);
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
}
