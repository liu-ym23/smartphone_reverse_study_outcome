package com.bytedance.ttnet.s;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import androidx.annotation.RequiresApi;
import com.bytedance.common.utility.k;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import d.b.h.a.a.h.s.f;
import d.b.r.v;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class e {
    static {
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent a(Context r1, BroadcastReceiver r2, IntentFilter r3, String r4, Handler r5) {
        return r1.registerReceiver(r2, r3, r4, r5);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3, r4, r5);
    }

    @Proxy("registerReceiver")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @RequiresApi(api = 26)
    public static Intent b(Context r1, BroadcastReceiver r2, IntentFilter r3, String r4, Handler r5, int r6) {
        return r1.registerReceiver(r2, r3, r4, r5, r6);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3, r4, r5, r6);
    }

    public static void c(boolean r0) {
        d.b.h.a.a.h.s.c.b(r0);
    }

    public static boolean d(String r4, List<String> r5) {
        if (k.c(r4) == false) goto L5;
    L21:
        return false;
    L5:
        if (com.bytedance.common.utility.e.a(r5) == true) goto L21;
        Iterator<String> r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L21;
        String r0 = r6.next();
        if (k.c(r0) == true) goto L9;
        if (d.b.h.a.a.e.b.e() == true) goto L16;
        if (e(r4, r0) == false) goto L9;
        return true;
    L16:
        if (r4.endsWith(r0) == false) goto L9;
        return true;
    }

    public static boolean e(String r2, String r3) {
        if (k.c(r2) == false) goto L5;
        return false;
    L5:
        if (k.c(r3) == false) goto L8;
        return false;
    L8:
        if (r2.equalsIgnoreCase(r3) == false) goto L11;
        return true;
    L11:
        String r4 = r2.toLowerCase();
        if (r3.startsWith(".") == false) goto L16;
        String r5 = r3.toLowerCase();
    L15:
        return r4.endsWith(r5);
    L16:
        r5 = "." + r3.toLowerCase();
        goto L15
    }

    public static String f(Throwable r3) {
        String r0 = null;
        if (r3 != null) goto L18;
        return null;
    L18:
        StringWriter r1 = new StringWriter();     // Catch: Throwable -> L13
        PrintWriter r2 = new PrintWriter(r1);     // Catch: Throwable -> L13
        r3.printStackTrace(r2);     // Catch: Throwable -> L17
        Throwable r4 = r3.getCause();     // Catch: Throwable -> L17
        if (r4 == null) goto L11;
        r4.printStackTrace(r2);     // Catch: Throwable -> L17
        Throwable r5 = r4.getCause();     // Catch: Throwable -> L17
        if (r5 == null) goto L11;
        r5.printStackTrace(r2);     // Catch: Throwable -> L17
    L11:
        r0 = r1.toString();     // Catch: Throwable -> L17
    L12:
        r2.close();
    L16:
        return r0;
    L14:
        if (r2 == null) goto L16;
    L13:
        r2 = null;
        goto L14
    }

    public static void g(String r4, List<String> r5) {
        if (k.c(r4) == true) goto L14;
        if (r5 == null) goto L19;
        String[] r6 = r4.split(",");
        int r0 = r6.length;
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L20;
        String r2 = r6[r1];
        if (k.c(r2) == true) goto L13;
        if (d(r2, r5) == true) goto L13;
        r5.add(r2.trim());
    L13:
        r1 = r1 + 1;
        goto L7
    L20:
        return;
    L19:
        return;
    }

    private static Intent h(Context r2, BroadcastReceiver r3, IntentFilter r4, String r5, Handler r6, int r7) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return b(r2, r3, r4, r5, r6, r7);
    L7:
        return a(r2, r3, r4, r5, r6);
    }

    public static Intent i(Context r6, BroadcastReceiver r7, IntentFilter r8) {
        return h(r6, r7, r8, null, null, 4);
    }

    public static void j(f<String, v> r3, d.b.r.j0.a r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.i() <= 0) goto L30;
        Map<String, v> r5 = r3.e();
        Collection<v> r0 = r5.values();
        monitor-enter(r5);
        Iterator<v> r1 = r0.iterator();     // Catch: Throwable -> L17
    L9:
        if (r1.hasNext() == false) goto L15;
        List<d.b.r.j0.a> r2 = r1.next().i();     // Catch: Throwable -> L17
        if (r2 == null) goto L9;
        if (r2.contains(r4) == true) goto L9;
        r2.add(r4);     // Catch: Throwable -> L17
        goto L9
    L15:
        monitor-exit(r5);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public static void k(f<String, v> r2, d.b.r.j0.a r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.i() <= 0) goto L26;
        Map<String, v> r4 = r2.e();
        Collection<v> r0 = r4.values();
        monitor-enter(r4);
        Iterator<v> r1 = r0.iterator();     // Catch: Throwable -> L15
    L9:
        if (r1.hasNext() == false) goto L13;
        List<d.b.r.j0.a> r5 = r1.next().i();     // Catch: Throwable -> L15
        if (r5 == null) goto L9;
        r5.remove(r3);     // Catch: Throwable -> L15
        goto L9
    L13:
        monitor-exit(r4);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }
}
