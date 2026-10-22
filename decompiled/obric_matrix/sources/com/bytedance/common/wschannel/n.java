package com.bytedance.common.wschannel;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.bytedance.common.wschannel.client.k f3631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<Integer, k> f3632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static AtomicBoolean f3633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f3634d;

    private static class a implements d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Application f3635a;

        a(Application r1) {
            this.f3635a = r1;
        }

        @Override // com.bytedance.common.wschannel.d.c
        public void onEnterToBackground() {
            n.b(true);
            if (n.c().get() == false) goto L6;
            n.d().d(this.f3635a);
            return;
        }

        @Override // com.bytedance.common.wschannel.d.c
        public void onEnterToForeground() {
            n.b(false);
            if (n.c().get() == false) goto L6;
            n.d().e(this.f3635a);
            return;
        }
    }

    static {
        f3631a = new com.bytedance.common.wschannel.client.m();
        f3632b = new ConcurrentHashMap();
        f3633c = new AtomicBoolean(false);
        f3634d = true;
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

    static /* synthetic */ boolean b(boolean r0) {
        f3634d = r0;
        return r0;
    }

    static /* synthetic */ AtomicBoolean c() {
        return f3633c;
    }

    static /* synthetic */ com.bytedance.common.wschannel.client.k d() {
        return f3631a;
    }

    @NonNull
    static SsWsApp e(com.bytedance.common.wschannel.a r10) {
        Map<String, String> r0 = r10.f3340d;
        ArrayList r1 = new ArrayList();
        Iterator<Map.Entry<String, String>> r2 = r0.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        Map.Entry<String, String> r3 = r2.next();
        if (r3 == null) goto L4;
        r1.add(r3.getKey() + "=" + Uri.encode(r3.getValue()));
        goto L4
    L9:
        int r4 = r10.f3344h;
        if (r4 <= 0) goto L38;
        String r5 = r10.f3338b;
        if (com.bytedance.common.utility.k.c(r5) == true) goto L36;
        String r6 = r10.f3339c;
        if (com.bytedance.common.utility.k.c(r6) == true) goto L34;
        int r7 = r10.f3343g;
        if (r7 <= 0) goto L32;
        String r8 = r10.f3345i;
        if (com.bytedance.common.utility.k.c(r8) == true) goto L30;
        int r9 = r10.f3346j;
        if (r9 <= 0) goto L28;
        int r11 = r10.f3337a;
        if (r11 <= 0) goto L26;
        int r12 = r10.n.a();
        SsWsApp.b r13 = new SsWsApp.b();
        r13.f(r4);
        r13.k(r5);
        r13.o(r6);
        r13.m(r7);
        r13.g(r8);
        r13.j(r10.f3342f);
        r13.h(r9);
        r13.p(0);
        r13.i(r11);
        r13.n(r10.f3341e);
        r13.l(TextUtils.join("&", r1.toArray()));
        r13.e(r10.f3347k);
        r13.r(r10.f3348l);
        r13.q(r10.m);
        r13.s(r12);
        r13.d(r10.o);
        return r13.b();
    L26:
        throw new IllegalArgumentException("channelId <= 0 ,please set channelId first");
    L28:
        throw new IllegalArgumentException("appVersion <= 0 ,please set appVersion first");
    L30:
        throw new IllegalArgumentException("appKey is empty,please set appKey first");
    L32:
        throw new IllegalArgumentException("fpid <= 0 ,please set fpid first");
    L34:
        throw new IllegalArgumentException("installId is empty ,please set installId first");
    L36:
        throw new IllegalArgumentException("deviceId is empty ,please set deviceId first");
    L38:
        throw new IllegalArgumentException("aid == 0 ,please set aid first");
    }

    static k f(int r1) {
        return f3632b.get(Integer.valueOf(r1));
    }

    static void g(Context r2) {
        Application r3 = (Application) r2.getApplicationContext();
        d r0 = new d();
        r0.d(new a(r3));
        r3.registerActivityLifecycleCallbacks(r0);
    }

    public static j h(Context r1, com.bytedance.common.wschannel.a r2, com.bytedance.common.wschannel.app.d r3) {
        return i(r1.getApplicationContext(), r2, r3, null, null);
    }

    public static j i(Context r8, com.bytedance.common.wschannel.a r9, com.bytedance.common.wschannel.app.d r10, com.bytedance.common.wschannel.app.e r11, com.bytedance.common.wschannel.app.c r12) {
        k(r8.getApplicationContext());
        k r0 = new k(r8.getApplicationContext(), f3631a, r9, r10, r11, r12);
        f3632b.put(Integer.valueOf(r9.f3337a), r0);
        r0.h();
        return r0;
    }

    private static void j(Context r3) {
        IntentFilter r0 = new IntentFilter();     // Catch: Exception -> L4
        r0.addAction("android.net.conn.CONNECTIVITY_CHANGE");     // Catch: Exception -> L4
        a(r3, new com.bytedance.common.wschannel.server.n(r3, com.bytedance.common.wschannel.server.h.b(r3)), r0);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    private static void k(Context r3) {
        if (f3633c.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        if (f3634d == false) goto L7;
        f3631a.d(r3);
    L8:
        j(r3);
        return;
    L7:
        f3631a.e(r3);
        goto L8
    }

    static void l(int r1) {
        f3632b.remove(Integer.valueOf(r1));
    }
}
