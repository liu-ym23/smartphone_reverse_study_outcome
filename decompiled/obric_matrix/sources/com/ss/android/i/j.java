package com.ss.android.i;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.ss.android.ShowDialogActivity;
import com.ss.android.token.n;
import com.ss.android.token.p;
import com.ss.android.token.w;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import kotlin.f0;
import kotlin.n0.c.l;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Handler f11896a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile com.ss.android.d f11897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile com.ss.android.e f11898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile com.ss.android.c f11899d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f11900e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile boolean f11901f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile boolean f11902g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile boolean f11903h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile ExecutorService f11904i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final d.b.s.a.a0.d.e f11905j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static long f11906k;

    static class a implements d.b.s.a.d0.r.b {
        a() {
        }
    }

    static class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j.a(false);
        }
    }

    static class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j.b();
            com.ss.android.ug.bus.b.b(com.ss.android.ug.bus.c.a.class, com.ss.android.i.b.M());
        }
    }

    static class d implements l<List<d.b.s.a.e0.d.a>, f0> {
        d() {
        }

        public f0 a(List<d.b.s.a.e0.d.a> r2) {
            if (r2.isEmpty() == false) goto L5;
            d.b.s.a.a0.a.d("SafetyLibVersionChecker", "checkSdkVersions success");
        L7:
            return f0.f18324a;
        L5:
            String r1 = j.c(r2);
            d.b.s.a.a0.a.b("SafetyLibVersionChecker", r1);
            Message r3 = j.d().obtainMessage(2003);
            r3.obj = r1;
            j.d().sendMessage(r3);
            goto L7
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(List<d.b.s.a.e0.d.a> r1) {
            return a(r1);
        }
    }

    static class e extends Handler {
        public e(Looper r1) {
            super(r1);
        }

        private void a() {
            if (p.g0() == false) goto L5;
            return;
        L5:
            if (j.f().g() == false) goto L7;
            ShowDialogActivity.d(j.f().e(), "token sdk is not inited!", "please call TTTokenManager.initialize(context, config)!");
            return;
        L7:
            com.bytedance.sdk.account.monitor.c.l();
        }

        private void b(Object r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            d.b.s.a.t.c.a r1 = new d.b.s.a.t.c.a();
            r1.d("！！重要提醒！！");
            r1.c(r2.toString());
            r1.b(new d.b.s.a.t.a("我知道了"));
            d.b.s.a.t.c r3 = r1.a();
            d.b.s.a.l0.b.f14847a.b(r3);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r2) {
            switch(r2.what) {
                case 2001: goto L7;
                case 2002: goto L6;
                case 2003: goto L5;
                default: goto L11;
            };
        L5:
            b(r2.obj);
            return;
        L6:
            j.e();
            return;
        L7:
            a();
            return;
        }
    }

    static {
        f11896a = new e(Looper.getMainLooper());
        f11900e = false;
        f11905j = new com.ss.android.b("TTAccountInit");
        f11906k = 0;
    }

    public j() {
    }

    static /* synthetic */ void a(boolean r0) {
        t(r0);
    }

    static /* synthetic */ void b() {
        i();
    }

    static /* synthetic */ String c(List r0) {
        return g(r0);
    }

    static /* synthetic */ Handler d() {
        return f11896a;
    }

    static /* synthetic */ void e() {
        h();
    }

    static /* synthetic */ com.ss.android.d f() {
        return f11897b;
    }

    @NonNull
    private static String g(List<d.b.s.a.e0.d.a> r3) {
        StringBuilder r0 = new StringBuilder("安全规范基础依赖 SDK 版本检查失败：");
        Iterator<d.b.s.a.e0.d.a> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        d.b.s.a.e0.d.a r1 = r4.next();
        r0.append(r1.c());
        r0.append("，期望：");
        r0.append(r1.b());
        r0.append("，实际：");
        r0.append(r1.a());
        r0.append("；");
        goto L4
    L6:
        r0.append("【此通知由账号 SDK 在 DEBUG 模式发出，请及时升级】");
        return r0.toString();
    }

    private static void h() {
        if (f11897b.g() == false) goto L9;
        com.ss.android.e r0 = m();
        if (r0 != null) goto L7;
        d.b.s.a.e0.d.f14720c.d(f11897b.f(), new d());
        return;
    L7:
        r0.e();
        throw null;
    }

    private static void i() {
        f11905j.b("DoComponentReflectionStart");
        Class.forName("com.ss.android.account.adapter.InternalAccountAdapter").getMethod("init", new Class[]{Context.class}).invoke(null, new Object[]{f11897b.e()});     // Catch: Exception -> L6
    L4:
        f11905j.b("DoComponentReflectionEnd");
    }

    public static Context j() {
        if (f11897b != null) goto L7;
        return null;
    L7:
        return f11897b.e();
    }

    public static com.ss.android.d k() {
        if (f11897b == null) goto L7;
        return f11897b;
    L7:
        throw new IllegalStateException("not init TTAccount config");
    }

    @Nullable
    public static com.ss.android.d l() {
        return f11897b;
    }

    public static com.ss.android.e m() {
        return f11898c;
    }

    public static com.ss.android.c n() {
        return f11899d;
    }

    public static long o() {
        return f11906k;
    }

    public static void p(com.ss.android.d r1) {
        q(r1, false);
    }

    public static void q(com.ss.android.d r2, boolean r3) {
        r(r2, r3, false, false, null);
    }

    public static void r(com.ss.android.d r6, boolean r7, boolean r8, boolean r9, ExecutorService r10) {
        s(r6, r7, r8, r9, r10, null);
    }

    public static void s(com.ss.android.d r4, boolean r5, boolean r6, boolean r7, ExecutorService r8, com.ss.android.token.l r9) {
        if (f11900e == true) goto L48;
        if (r4 != null) goto L7;
        return;
    L7:
        monitor-enter(j.class);
    L45:
        th = move-exception;
        throw th;
    L9:
        if (f11900e == false) goto L12;
        monitor-exit(j.class);     // Catch: Throwable -> L45
        return;
    L12:
        f11906k = System.currentTimeMillis();     // Catch: Throwable -> L45
        f11897b = r4;     // Catch: Throwable -> L45
        f11901f = r5;     // Catch: Throwable -> L45
        f11902g = r6;     // Catch: Throwable -> L45
        f11903h = r7;     // Catch: Throwable -> L45
        f11904i = r8;     // Catch: Throwable -> L45
        d.b.s.a.a0.c.a r10 = f11897b.a();     // Catch: Throwable -> L45
        if (d.b.s.a.a0.a.e() == false) goto L15;
        if (r10 != null) goto L15;
    L16:
        d.b.s.a.a0.d.e r11 = f11905j;     // Catch: Throwable -> L45
        r11.a("Init");     // Catch: Throwable -> L45
        d.b.s.a.a0.d.e.a r12 = r11.c("AccountSDKStartInit");     // Catch: Throwable -> L45
        r12.a("sdkVersionName", "0.6.1-alpha.319-matrix");     // Catch: Throwable -> L45
        r12.a("sdkVersionCode", 601339);     // Catch: Throwable -> L45
        r12.a("buildType", "release");     // Catch: Throwable -> L45
        r12.a("flavor", "");     // Catch: Throwable -> L45
        r12.c();     // Catch: Throwable -> L45
        com.bytedance.sdk.account.impl.h.b().a();     // Catch: Throwable -> L45
        d.b.s.a.d0.s.c.b(d.b.s.a.d0.r.a.class, com.bytedance.sdk.account.impl.g.b(f11897b.e()));     // Catch: Throwable -> L45
        if (r9 != null) goto L19;
    L21:
        d.b.s.a.l0.c.a();     // Catch: Throwable -> L45
    L23:
        if (f11897b.b() != null) goto L25;
        d.b.s.a.a0.d.e.a r13 = r11.c("MonitorNull");     // Catch: Throwable -> L45
        r13.b();     // Catch: Throwable -> L45
        r13.c();     // Catch: Throwable -> L45
        throw new RuntimeException("IMonitor == null");     // Catch: Throwable -> L45
    L25:
        if (((d.b.s.a.d0.r.b) d.b.s.a.d0.s.c.a(d.b.s.a.d0.r.b.class)) != null) goto L28;
        d.b.s.a.d0.s.c.b(d.b.s.a.d0.r.b.class, new a());     // Catch: Throwable -> L45
    L28:
        if (f11902g == true) goto L31;
        g.b().c(f.a());     // Catch: Throwable -> L45
        r11.c("BdTuringInitSuccess").c();     // Catch: Throwable -> L45
    L31:
        if (f11903h == true) goto L34;
        i.a().b(com.ss.android.i.d.a());     // Catch: Throwable -> L45
        r11.c("AccountSecInitSuccess").c();     // Catch: Throwable -> L45
    L34:
        if (w.j(f11897b.e()) == false) goto L37;
        com.ss.android.j.a.f();     // Catch: Throwable -> L45
    L37:
        if (f11904i != null) goto L39;
        t(f11901f);     // Catch: Throwable -> L45
    L40:
        f11900e = true;     // Catch: Throwable -> L45
        r11.c("AccountInitSuccess").c();     // Catch: Throwable -> L45
        monitor-exit(j.class);     // Catch: Throwable -> L45
        return;
    L39:
        f11904i.execute(new b());     // Catch: Throwable -> L45
        goto L40
    L19:
        if (com.bytedance.sdk.account.ticketguard.f.j().e() == false) goto L21;
        d.b.s.a.a0.a.d("TTAccountInit", "trigger token preInit during sdk init");     // Catch: Throwable -> L45
        n.q(j(), r9, r4);     // Catch: Throwable -> L45
    L15:
        d.b.s.a.a0.a.f(r10);     // Catch: Throwable -> L45
        goto L16
    }

    private static void t(boolean r3) {
        if (r3 == false) goto L4;
        f11896a.postDelayed(new c(), CoroutineLiveDataKt.DEFAULT_TIMEOUT);
    L6:
        if (w.j(f11897b.e()) == false) goto L9;
        Handler r4 = f11896a;
        r4.sendEmptyMessageDelayed(2001, 60000);
        r4.sendEmptyMessageDelayed(2002, BDLocationConfig.sScanBleMaxInterval);
        com.ss.android.j.a.b();
        return;
    L9:
        return;
    L4:
        i();
        com.ss.android.ug.bus.b.b(com.ss.android.ug.bus.c.a.class, com.ss.android.i.b.M());
        goto L6
    }
}
