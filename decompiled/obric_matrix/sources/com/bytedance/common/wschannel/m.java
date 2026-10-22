package com.bytedance.common.wschannel;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.Nullable;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.bytedance.common.wschannel.client.k f3546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f3547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Application f3548c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static a f3549d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static f f3550e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Map<Integer, com.bytedance.common.wschannel.s.a> f3551f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f3552g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static b f3553h;

    private static class a implements d.c {
        private a() {
        }

        /* synthetic */ a(l r1) {
            this();
        }

        @Override // com.bytedance.common.wschannel.d.c
        public void onEnterToBackground() {
            m.b(true);
            if (m.e() != null) goto L5;
        L6:
            m.d().d(m.c());
            return;
        L5:
            if (b.a(m.e()) == true) goto L6;
        }

        @Override // com.bytedance.common.wschannel.d.c
        public void onEnterToForeground() {
            m.b(false);
            if (m.e() != null) goto L5;
        L6:
            m.d().e(m.c());
            return;
        L5:
            if (b.a(m.e()) == true) goto L6;
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f3554a;

        private b() {
            this.f3554a = false;
            new ConcurrentHashMap();
        }

        /* synthetic */ b(l r1) {
            this();
        }

        static /* synthetic */ boolean a(b r0) {
            return r0.f3554a;
        }

        static /* synthetic */ boolean b(b r0, boolean r1) {
            r0.f3554a = r1;
            return r1;
        }
    }

    static {
        f3546a = new com.bytedance.common.wschannel.client.l();
        f3549d = new a(null);
        f3550e = null;
        new ConcurrentHashMap();
        f3551f = new ConcurrentHashMap();
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent a(Application r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    static /* synthetic */ boolean b(boolean r0) {
        return r0;
    }

    static /* synthetic */ Application c() {
        return f3548c;
    }

    static /* synthetic */ com.bytedance.common.wschannel.client.k d() {
        return f3546a;
    }

    static /* synthetic */ b e() {
        return f3553h;
    }

    private static void f(Application r1, @Nullable com.bytedance.common.wschannel.app.d r2, boolean r3, boolean r4, @Nullable com.bytedance.common.wschannel.app.b r5) {
        p.a r0 = new p.a();
        r0.a(r1);
        r0.g(r2);
        r0.e(r3);
        r0.d(r4);
        r0.f(false);
        r0.b(r5);
        g(r0.c());
    }

    private static void g(p r9) {
        if (f3547b == false) goto L5;
        return;
    L5:
        Application r0 = r9.a();
        com.bytedance.common.wschannel.app.d r1 = r9.b();
        boolean r2 = r9.d();
        boolean r3 = r9.e();
        com.bytedance.common.wschannel.app.b r4 = r9.f3645f;
        boolean r5 = r9.f();
        f3547b = true;
        f3548c = r0;
        String r7 = com.bytedance.common.wschannel.u.c.c(r0);
        f3552g = r7;
        boolean r8 = com.bytedance.common.wschannel.u.c.j(r0, r7);
        if (r3 == false) goto L9;
        if (r8 == false) goto L9;
        b r6 = new b(null);
        f3553h = r6;
        b.b(r6, false);
    L9:
        if (r8 == false) goto L18;
        if (r2 == false) goto L12;
        d r10 = new d();
        r10.d(f3549d);
        r0.registerActivityLifecycleCallbacks(r10);
    L12:
        WsConstants.setOnMessageReceiveListener(r1);
        WsConstants.setOptLogic(r9.c());
        WsConstants.setBindWsChannelServiceListener(r4);
        if (r0 == null) goto L21;
        o r11 = o.f(r0);
        if (r11 == null) goto L21;
        r11.k(r5);
    L21:
        if (f3553h != null) goto L24;
        f3546a.c(f3548c, r8, true);
        return;
    L24:
        return;
    L18:
        if (com.bytedance.common.wschannel.u.c.k(f3552g) == false) goto L21;
        k();
        goto L21
    }

    public static <T extends com.bytedance.common.wschannel.s.e.b> com.bytedance.common.wschannel.s.a<T> h(int r1) {
        return f3551f.get(Integer.valueOf(r1));
    }

    public static f i() {
        return f3550e;
    }

    public static void j(Application r3, @Nullable com.bytedance.common.wschannel.app.d r4) {
        f(r3, r4, false, true, null);
    }

    private static void k() {
        IntentFilter r0 = new IntentFilter();     // Catch: Exception -> L4
        r0.addAction("android.net.conn.CONNECTIVITY_CHANGE");     // Catch: Exception -> L4
        Application r1 = f3548c;     // Catch: Exception -> L4
        Application r3 = f3548c;     // Catch: Exception -> L4
        a(r1, new com.bytedance.common.wschannel.server.n(r3, com.bytedance.common.wschannel.server.k.b(r3)), r0);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
