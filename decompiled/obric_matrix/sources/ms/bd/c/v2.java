package ms.bd.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class v2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile s2 f22524a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f22525b = false;

    @Proxy("getBundleExtra")
    @TargetClass("android.content.Intent")
    public static Bundle a(Intent r0, String r1) {
        Bundle r2 = r0.getBundleExtra(r1);
        Context r3 = BadParcelableCrashOptimizer.getContext();
        if (r2 == null) goto L6;
        if (r3 == null) goto L6;
        r2.setClassLoader(r3.getClassLoader());
    L6:
        return r2;
    }

    private static String b(Intent r8) {
        Bundle r9 = a(r8, (String) m.a(16777217, 0, 0, "5c06b7", new byte[]{40, 104, 85, 71, 98, 52, 51, 81}));
        if (r9 != null) goto L5;
        return null;
    L5:
        CharSequence r10 = r9.getCharSequence((String) m.a(16777217, 0, 0, "a24d37", new byte[]{113, 32, 87, 57, 40}));
        if (TextUtils.isEmpty(r10) == false) goto L9;
        return null;
    L9:
        return r10.toString();
    }

    public static void c() {
        if (f22524a != null) goto L5;
        return;
    L5:
        if (f22525b == false) goto L9;
        f22524a.f();
        f22525b = false;
        return;
    }

    public static synchronized void d(Context r4, Intent r5) {
        monitor-enter(v2.class);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (f22524a != null) goto L17;
        monitor-enter(s2.class);     // Catch: Throwable -> L21
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L9:
        if (f22524a != null) goto L11;
        String r6 = b(r5);     // Catch: Throwable -> L13
        f22524a = new s2(new u2(r4), r6);     // Catch: Throwable -> L13
    L11:
        monitor-exit(s2.class);     // Catch: Throwable -> L13
    L17:
        if (f22525b == true) goto L19;
        f22524a.d();     // Catch: Throwable -> L21
        f22525b = true;     // Catch: Throwable -> L21
    L19:
        monitor-exit(v2.class);
    }

    public static String e() {
        if (f22524a != null) goto L7;
        return "";
    L7:
        return f22524a.a();
    }
}
