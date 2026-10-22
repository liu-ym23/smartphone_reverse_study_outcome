package com.bytedance.apm.q.k;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<b> f1812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f1813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f1814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static c f1815d;

    /* JADX INFO: renamed from: com.bytedance.apm.q.k.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0057a {
    }

    public interface b {
        void a(boolean r1);
    }

    private static class c extends BroadcastReceiver {
        private c() {
        }

        /* synthetic */ c(C0057a r1) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            String r0 = r2.getAction();
            if ("android.intent.action.ACTION_POWER_CONNECTED".equals(r0) == false) goto L9;
            a.c(true);
            Iterator r3 = a.d().iterator();
        L6:
            if (r3.hasNext() == false) goto L17;
            ((b) r3.next()).a(a.b());
            goto L6
        L17:
            return;
        L9:
            if ("android.intent.action.ACTION_POWER_DISCONNECTED".equals(r0) == false) goto L14;
            a.c(false);
            Iterator r4 = a.d().iterator();
        L12:
            if (r4.hasNext() == false) goto L18;
            ((b) r4.next()).a(a.b());
            goto L12
        L18:
            return;
        }
    }

    static {
        f1812a = new ArrayList();
        f1813b = false;
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent a(Context r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    static /* synthetic */ boolean b() {
        return f1814c;
    }

    static /* synthetic */ boolean c(boolean r0) {
        f1814c = r0;
        return r0;
    }

    static /* synthetic */ List d() {
        return f1812a;
    }

    public static boolean e(Context r1, b r2) {
        if (r2 == null) goto L9;
        f1812a.add(r2);
        if (f1813b == true) goto L7;
        g(r1);
        f1813b = true;
    L7:
        return f1814c;
    L9:
        throw new IllegalArgumentException("chargeListener can't be null");
    }

    public static boolean f(Context r3) {
        if (f1813b == true) goto L5;
        Intent r4 = a(r3, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (r4 == null) goto L15;
        int r5 = r4.getIntExtra("status", -1);
        if (r5 != 2) goto L11;
        return true;
    L11:
        if (r5 == 5) goto L17;
        return false;
    L17:
        return true;
    L15:
        return true;
    L5:
        return f1814c;
    }

    private static void g(Context r3) {
        IntentFilter r0 = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");     // Catch: Throwable -> L4
        r0.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");     // Catch: Throwable -> L4
        c r1 = new c(null);     // Catch: Throwable -> L4
        f1815d = r1;     // Catch: Throwable -> L4
        a(r3, r1, r0);     // Catch: Throwable -> L4
        f1814c = f(r3);     // Catch: Throwable -> L4
        return;
    L4:
        f1814c = true;
    }

    public static void h(Context r1, b r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        f1812a.remove(r2);
        if (f1812a.isEmpty() == false) goto L12;
        r1.unregisterReceiver(f1815d);     // Catch: Throwable -> L9
    L7:
        f1813b = false;
        return;
    }
}
