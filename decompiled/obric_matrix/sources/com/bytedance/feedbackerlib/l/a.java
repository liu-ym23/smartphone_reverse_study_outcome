package com.bytedance.feedbackerlib.l;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.bytedance.feedbackerlib.Feedbacker;
import com.bytedance.feedbackerlib.m.c;
import com.bytedance.feedbackerlib.m.k;
import com.bytedance.feedbackerlib.m.o;
import com.bytedance.feedbackerlib.m.r;
import com.bytedance.feedbackerlib.service.FloatWindowService;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class a extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4255a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f4256b;

    static {
        f4255a = o.d() + ".permission.dynamicreceiver";
    }

    private a() {
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

    public static void b(@NonNull Context r5, String r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.getApplicationContext() == null) goto L13;
        long r0 = FloatWindowService.o();
        long r2 = 0;
        if (r0 == 0) goto L10;
        r2 = System.currentTimeMillis() - r0;
    L10:
        r.n(r6, r2);
        Intent r7 = new Intent("action_lark_sso_bypassed");
        r7.setPackage(r5.getPackageName());
        r5.sendBroadcast(r7, f4255a);
        return;
    }

    public static void c(@NonNull Context r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.getApplicationContext() == null) goto L9;
        Intent r0 = new Intent("action_lark_sso_failed");
        r0.setPackage(r2.getPackageName());
        r2.sendBroadcast(r0);
        return;
    }

    public static void d(@NonNull Context r5, String r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.getApplicationContext() == null) goto L13;
        long r0 = FloatWindowService.o();
        long r2 = 0;
        if (r0 == 0) goto L10;
        r2 = System.currentTimeMillis() - r0;
    L10:
        r.n(r6, r2);
        Intent r7 = new Intent("action_lark_sso_success");
        r7.setPackage(r5.getPackageName());
        r5.sendBroadcast(r7, f4255a);
        return;
    }

    public static a e() {
        if (f4256b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f4256b != null) goto L9;
        f4256b = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f4256b;
    }

    private void f() {
        k.f(Feedbacker.class, "notifyLarkSSOBypassed", new Object[0]);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        c.a("DynamicReceiver", "cannot notify larksso bypassed", th);
    }

    private void g() {
        k.f(Feedbacker.class, "notifyLarkSSOFailed", new Object[0]);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        c.a("DynamicReceiver", "cannot notify larksso bypassed", th);
    }

    private void h() {
        k.f(Feedbacker.class, "notifyLarkSSOSuccess", new Object[0]);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        c.a("DynamicReceiver", "cannot notify larksso success", th);
    }

    public static void i(@NonNull Context r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        a r0 = e();
        IntentFilter r1 = new IntentFilter();
        r1.addAction("action_lark_sso_success");
        r1.addAction("action_lark_sso_bypassed");
        r1.addAction("action_lark_sso_failed");
        a(r4, r0, r1, f4255a, null);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r2, Intent r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.getAction() == null) goto L30;
        String r4 = r3.getAction();
        r4.hashCode();
        byte r5 = -1;
        switch(r4.hashCode()) {
            case -1528828203: goto L18;
            case -929613717: goto L14;
            case 1309537311: goto L10;
            default: goto L21;
        };
    L21:
        switch(r5) {
            case 0: goto L25;
            case 1: goto L24;
            case 2: goto L23;
            default: goto L31;
        };
    L23:
        f();
        return;
    L24:
        h();
        return;
    L25:
        g();
        return;
    L31:
        return;
    L10:
        if (r4.equals("action_lark_sso_bypassed") == false) goto L21;
        r5 = 2;
        goto L21
    L14:
        if (r4.equals("action_lark_sso_success") == false) goto L21;
        r5 = 1;
        goto L21
    L18:
        if (r4.equals("action_lark_sso_failed") == false) goto L21;
        r5 = 0;
        goto L21
    }
}
