package com.obric.matrix.q.h;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import androidx.annotation.RequiresApi;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.a0;
import kotlin.f0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.u;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rH\u0007J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u001e\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u001c2\u0006\u0010\u001d\u001a\u00020\u0016H\u0002J\b\u0010\u001e\u001a\u00020\u0012H\u0002J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\nH\u0002J\b\u0010!\u001a\u00020\u0012H\u0002J\u0010\u0010\"\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rH\u0007J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u0007H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006%"}, d2 = {"Lcom/obric/matrix/base/system/SystemStateMonitor;", "", "()V", "LAST_SCREEN_OFF_TIMESTAMP", "", "TAG", "appContext", "Landroid/content/Context;", "currentNetwork", "isDeviceOnline", "", "listeners", "", "Lcom/obric/matrix/base/system/ISystemStateListener;", "networkCallback", "com/obric/matrix/base/system/SystemStateMonitor$networkCallback$1", "Lcom/obric/matrix/base/system/SystemStateMonitor$networkCallback$1;", "addStateListener", "", "listener", "dispatchNetworkLostIfNeeded", "network", "Landroid/net/Network;", "reason", "getLastScreenOffTimestamp", "", "init", "isStillOnlineOnAnotherValidatedNetwork", "Lkotlin/Pair;", "lostNetwork", "onPowerSaveModeChanged", "onScreenStateChanged", "on", "onTimeZoneChanged", "removeStateListener", "startReceiver", "context", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f9885a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<com.obric.matrix.q.h.d> f9886b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Context f9887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile String f9888d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f9889e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final b f9890f = null;

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/matrix/base/system/ISystemStateListener;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends q implements kotlin.n0.c.l<com.obric.matrix.q.h.d, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Network f9891f;

        a(Network r1) {
            this.f9891f = r1;
            super(1);
        }

        public final void a(com.obric.matrix.q.h.d r2) {
            o.f(r2, "it");
            r2.f(this.f9891f);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(com.obric.matrix.q.h.d r1) {
            a(r1);
            return f0.f18324a;
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"com/obric/matrix/base/system/SystemStateMonitor$networkCallback$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "onAvailable", "", "network", "Landroid/net/Network;", "onCapabilitiesChanged", "networkCapabilities", "Landroid/net/NetworkCapabilities;", "onLost", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b extends ConnectivityManager.NetworkCallback {

        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/matrix/base/system/ISystemStateListener;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class a extends q implements kotlin.n0.c.l<com.obric.matrix.q.h.d, f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ Network f9892f;

            a(Network r1) {
                this.f9892f = r1;
                super(1);
            }

            public final void a(com.obric.matrix.q.h.d r2) {
                o.f(r2, "it");
                r2.d(this.f9892f);
            }

            @Override // kotlin.n0.c.l
            public /* bridge */ /* synthetic */ f0 invoke(com.obric.matrix.q.h.d r1) {
                a(r1);
                return f0.f18324a;
            }
        }

        /* JADX INFO: renamed from: com.obric.matrix.q.h.k$b$b, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/matrix/base/system/ISystemStateListener;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class C0281b extends q implements kotlin.n0.c.l<com.obric.matrix.q.h.d, f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ Network f9893f;

            C0281b(Network r1) {
                this.f9893f = r1;
                super(1);
            }

            public final void a(com.obric.matrix.q.h.d r2) {
                o.f(r2, "it");
                r2.a(this.f9893f);
            }

            @Override // kotlin.n0.c.l
            public /* bridge */ /* synthetic */ f0 invoke(com.obric.matrix.q.h.d r1) {
                a(r1);
                return f0.f18324a;
            }
        }

        b() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network r2) {
            o.f(r2, "network");
            com.obric.matrix.r.c.c.j("SystemStateMonitor", "onAvailable: " + r2 + ", currentNetwork: " + k.c());
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network r3, NetworkCapabilities r4) {
            o.f(r3, "network");
            o.f(r4, "networkCapabilities");
            super.onCapabilitiesChanged(r3, r4);
            boolean r2 = r4.hasCapability(16);
            boolean r5 = o.a(r3.toString(), k.c());
            if (r2 == true) goto L11;
            if (r5 == false) goto L35;
            k r6 = k.f9885a;
            u r7 = k.f(r6, r3);
            boolean r0 = ((Boolean) r7.a()).booleanValue();
            Network r8 = (Network) r7.b();
            if (r0 == true) goto L8;
            com.obric.matrix.r.c.c.j("SystemStateMonitor", "onCapabilitiesChanged: current network lost validation, dispatch offline");
            k.b(r6, r3, "capability_lost");
            return;
        L8:
            com.obric.matrix.r.c.c.j("SystemStateMonitor", "onCapabilitiesChanged: current network lost validation but switched to another validated network: " + r8);
            return;
        L35:
            return;
        L11:
            if (k.e() == true) goto L21;
            k r9 = k.f9885a;
            k.k(true);
            com.obric.matrix.r.c.c.j("SystemStateMonitor", "onCapabilitiesChanged (Offline->Online): " + r3);
            Set r10 = k.d();
            monitor-enter(r10);
            com.obric.matrix.r.e.f.f9940a.b(k.d(), new a(r3));     // Catch: Throwable -> L17
            f0 r11 = f0.f18324a;     // Catch: Throwable -> L17
            monitor-exit(r10);
        L17:
            th = move-exception;
            throw th;
        L21:
            if (o.a(r3.toString(), k.c()) == true) goto L30;
            com.obric.matrix.r.c.c.j("SystemStateMonitor", "onCapabilitiesChanged (Validated): " + r3);
            k r12 = k.f9885a;
            k.j(r3.toString());
            Set r13 = k.d();
            monitor-enter(r13);
            com.obric.matrix.r.e.f.f9940a.b(k.d(), new C0281b(r3));     // Catch: Throwable -> L27
            f0 r14 = f0.f18324a;     // Catch: Throwable -> L27
            monitor-exit(r13);
            return;
        L27:
            th = move-exception;
            throw th;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network r4) {
            o.f(r4, "network");
            com.obric.matrix.r.c.c.j("SystemStateMonitor", "onLost: " + r4);
            k r3 = k.f9885a;
            u r1 = k.f(r3, r4);
            boolean r2 = ((Boolean) r1.a()).booleanValue();
            Network r5 = (Network) r1.b();
            if (r2 == true) goto L5;
            k.b(r3, r4, "framework_onLost");
            return;
        L5:
            com.obric.matrix.r.c.c.j("SystemStateMonitor", "Network lost but switched to another validated network: " + r5);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/matrix/base/system/ISystemStateListener;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class c extends q implements kotlin.n0.c.l<com.obric.matrix.q.h.d, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f9894f;

        c(boolean r1) {
            this.f9894f = r1;
            super(1);
        }

        public final void a(com.obric.matrix.q.h.d r2) {
            o.f(r2, "it");
            r2.c(this.f9894f);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(com.obric.matrix.q.h.d r1) {
            a(r1);
            return f0.f18324a;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/matrix/base/system/ISystemStateListener;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class d extends q implements kotlin.n0.c.l<com.obric.matrix.q.h.d, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f9895f;

        d(boolean r1) {
            this.f9895f = r1;
            super(1);
        }

        public final void a(com.obric.matrix.q.h.d r2) {
            o.f(r2, "it");
            r2.b(this.f9895f);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(com.obric.matrix.q.h.d r1) {
            a(r1);
            return f0.f18324a;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0017¨\u0006\b"}, d2 = {"com/obric/matrix/base/system/SystemStateMonitor$startReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class e extends BroadcastReceiver {
        e() {
        }

        @Override // android.content.BroadcastReceiver
        @RequiresApi(33)
        public void onReceive(Context r2, Intent r3) {
            o.f(r2, "context");
            if (r3 == null) goto L5;
            String r1 = r3.getAction();
        L7:
            if (r1 != null) goto L10;
            com.obric.matrix.r.c.c.f("SystemStateMonitor", "onReceive: intent or action is null");
            return;
        L10:
            com.obric.matrix.r.c.c.j("SystemStateMonitor", "onReceive: action: " + r3.getAction());
            String r4 = r3.getAction();
            if (r4 != null) goto L13;
            return;
        L13:
            switch(r4.hashCode()) {
                case -2128145023: goto L31;
                case -1454123155: goto L27;
                case 498807504: goto L23;
                case 502473491: goto L19;
                case 870701415: goto L16;
                default: goto L39;
            };
        L39:
            return;
        L16:
            if (r4.equals("android.os.action.DEVICE_IDLE_MODE_CHANGED") == false) goto L40;
        L25:
            k.g(k.f9885a);
            return;
        L40:
            return;
        L19:
            if (r4.equals("android.intent.action.TIMEZONE_CHANGED") == false) goto L41;
            k.i(k.f9885a);
            return;
        L41:
            return;
        L23:
            if (r4.equals("android.os.action.LIGHT_DEVICE_IDLE_MODE_CHANGED") == true) goto L25;
            return;
        L27:
            if (r4.equals("android.intent.action.SCREEN_ON") == false) goto L43;
            k r5 = k.f9885a;
            boolean r6 = true;
        L34:
            k.h(r5, r6);
            return;
        L43:
            return;
        L31:
            if (r4.equals("android.intent.action.SCREEN_OFF") == false) goto L44;
            r5 = k.f9885a;
            r6 = false;
            goto L34
        L44:
            return;
        L5:
            r1 = null;
            goto L7
        }
    }

    static {
        f9885a = new k();
        f9886b = new LinkedHashSet();
        f9890f = new b();
    }

    private k() {
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

    public static final /* synthetic */ void b(k r0, Network r1, String r2) {
        r0.m(r1, r2);
    }

    public static final /* synthetic */ String c() {
        return f9888d;
    }

    public static final /* synthetic */ Set d() {
        return f9886b;
    }

    public static final /* synthetic */ boolean e() {
        return f9889e;
    }

    public static final /* synthetic */ u f(k r0, Network r1) {
        return r0.p(r1);
    }

    public static final /* synthetic */ void g(k r0) {
        r0.q();
    }

    public static final /* synthetic */ void h(k r0, boolean r1) {
        r0.r(r1);
    }

    public static final /* synthetic */ void i(k r0) {
        r0.s();
    }

    public static final /* synthetic */ void j(String r0) {
        f9888d = r0;
    }

    public static final /* synthetic */ void k(boolean r0) {
        f9889e = r0;
    }

    public static final void l(com.obric.matrix.q.h.d r1) {
        o.f(r1, "listener");
        Set<com.obric.matrix.q.h.d> r0 = f9886b;
        monitor-enter(r0);
        r0.add(r1);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private final void m(Network r3, String r4) {
        if (f9889e == false) goto L5;
    L8:
        f9888d = null;
        f9889e = false;
        com.obric.matrix.r.c.c.j("SystemStateMonitor", "Device is completely offline, reason=" + r4 + ", network=" + r3);
        Set<com.obric.matrix.q.h.d> r2 = f9886b;
        monitor-enter(r2);
        com.obric.matrix.r.e.f.f9940a.b(r2, new a(r3));     // Catch: Throwable -> L13
        f0 r5 = f0.f18324a;     // Catch: Throwable -> L13
        monitor-exit(r2);
        return;
    L13:
        th = move-exception;
        throw th;
    L5:
        if (f9888d != null) goto L8;
        com.obric.matrix.r.c.c.j("SystemStateMonitor", "skip duplicate onNetworkLost, reason=" + r4 + ", network=" + r3);
    }

    public static final void o(Context r3) {
        o.f(r3, "appContext");
        k r0 = f9885a;
        Context r1 = r3.getApplicationContext();
        o.e(r1, "appContext.applicationContext");
        f9887c = r1;
        r0.u(r3);
        ((ConnectivityManager) r3.getSystemService(ConnectivityManager.class)).registerDefaultNetworkCallback(f9890f);
    }

    private final u<Boolean, Network> p(Network r4) {
        Context r3 = f9887c;
        NetworkCapabilities r0 = null;
        if (r3 == null) goto L26;
        ConnectivityManager r5 = (ConnectivityManager) r3.getSystemService(ConnectivityManager.class);
        if (r5 == null) goto L7;
        Network r1 = r5.getActiveNetwork();
    L8:
        if (r1 == null) goto L10;
        r0 = r5.getNetworkCapabilities(r1);
    L10:
        boolean r6 = true;
        if (r1 != null) goto L13;
    L23:
        r6 = false;
    L25:
        return a0.a(Boolean.valueOf(r6), r1);
    L13:
        if (o.a(r1, r4) == true) goto L23;
        if (r0 != null) goto L16;
    L18:
        boolean r7 = false;
    L19:
        if (r7 == false) goto L23;
        if (r0.hasCapability(16) == false) goto L23;
    L16:
        if (r0.hasCapability(12) != true) goto L18;
        r7 = true;
        goto L19
    L7:
        r1 = null;
        goto L8
    L26:
        o.v("appContext");
        throw null;
    }

    private final void q() {
        boolean r3 = com.obric.matrix.r.e.j.b();
        com.obric.matrix.r.c.c.j("SystemStateMonitor", "onPowerSaveModeChanged: " + r3);
        Set<com.obric.matrix.q.h.d> r0 = f9886b;
        monitor-enter(r0);
        com.obric.matrix.r.e.f.f9940a.b(r0, new c(r3));     // Catch: Throwable -> L7
        f0 r4 = f0.f18324a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private final void r(boolean r8) {
        com.obric.matrix.r.c.c.j("SystemStateMonitor", "onScreenStateChanged: " + r8);
        Set<com.obric.matrix.q.h.d> r7 = f9886b;
        monitor-enter(r7);
        com.obric.matrix.r.e.f.f9940a.b(r7, new d(r8));     // Catch: Throwable -> L9
        f0 r0 = f0.f18324a;     // Catch: Throwable -> L9
        monitor-exit(r7);
        if (r8 == true) goto L14;
        com.obric.matrix.q.e.a.m(com.obric.matrix.q.e.a.f9851a, "last_screen_off_timestamp", Long.valueOf(System.currentTimeMillis()), null, 4, null);
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private final void s() {
        com.obric.matrix.r.c.c.j("SystemStateMonitor", "onTimeZoneChanged " + TimeZone.getDefault().getID());
    }

    public static final void t(com.obric.matrix.q.h.d r1) {
        o.f(r1, "listener");
        Set<com.obric.matrix.q.h.d> r0 = f9886b;
        monitor-enter(r0);
        r0.remove(r1);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @SuppressLint({"[ByDesign2.5]AddPermissionForDynamicReceiver"})
    private final void u(Context r3) {
        IntentFilter r2 = new IntentFilter();
        r2.addAction("android.intent.action.SCREEN_ON");
        r2.addAction("android.intent.action.SCREEN_OFF");
        r2.addAction("android.intent.action.TIMEZONE_CHANGED");
        r2.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
        if (Build.VERSION.SDK_INT < 33) goto L5;
        r2.addAction("android.os.action.LIGHT_DEVICE_IDLE_MODE_CHANGED");
    L5:
        a(r3, new e(), r2);
    }

    public final long n() {
        return com.obric.matrix.q.e.a.i(com.obric.matrix.q.e.a.f9851a, "last_screen_off_timestamp", Long.valueOf(System.currentTimeMillis()), null, 4, null);
    }
}
