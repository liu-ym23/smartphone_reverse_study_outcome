package d.b.p.a.f.a;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f14274b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f14275a;

    private a(Application r3) {
        this.f14275a = a(r3, "godzilla_launch_safe", 0);
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.ALL, value = "android.content.Context")
    public static SharedPreferences a(Application r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    public static String d(Thread r2, Throwable r3) {
        boolean r4 = "main".equals(r2.getName());
        StringBuilder r0 = new StringBuilder();
        r0.append(r4);
        r0.append("_");
        r0.append(r3.getClass().getName());
        r0.append("_");
        r0.append(r3.getMessage());
        r0.append("_");
        StackTraceElement[] r5 = r3.getStackTrace();
        if (r5 == null) goto L8;
        if (r5.length <= 0) goto L8;
        r0.append(r5[0].getClassName());
        r0.append(r5[0].getMethodName());
    L8:
        return r0.toString();
    }

    public static a f(Application r2) {
        if (f14274b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f14274b != null) goto L9;
        f14274b = new a(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f14274b;
    }

    synchronized void b() {
        monitor-enter(this);
        this.f14275a.edit().clear().apply();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @SuppressLint({"ApplySharedPref"})
    synchronized int c(Thread r4, Throwable r5) {
        monitor-enter(this);
        int r0 = e(r4, r5) + 1;     // Catch: Throwable -> L6
        int r1 = g() + 1;     // Catch: Throwable -> L6
        this.f14275a.edit().putInt(d(r4, r5), r0).putInt("total_crash_count", r1).commit();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized int e(Thread r3, Throwable r4) {
        monitor-enter(this);
        int r5 = this.f14275a.getInt(d(r3, r4), 0);     // Catch: Throwable -> L6
        Log.i("CrashRecord", "get crash count=" + r5);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized int g() {
        monitor-enter(this);
        int r0 = this.f14275a.getInt("total_crash_count", 0);     // Catch: Throwable -> L6
        Log.i("CrashRecord", "get crash count=" + r0);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }
}
