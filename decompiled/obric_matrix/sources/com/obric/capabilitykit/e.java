package com.obric.capabilitykit;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import com.obric.capabilitykit.common.ICapabilityManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.o;
import kotlin.v;
import kotlin.w;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u0014J\u001c\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/capabilitykit/AgentServiceConnection;", "Landroid/content/ServiceConnection;", "()V", "SERVER_SERVICE", "", "TAG", "api", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "getApi", "()Lcom/obric/capabilitykit/AbstractCapabilityManager;", "setApi", "(Lcom/obric/capabilitykit/AbstractCapabilityManager;)V", "mBindState", "Lcom/obric/capabilitykit/AgentServiceConnection$BindState;", "getMBindState", "()Lcom/obric/capabilitykit/AgentServiceConnection$BindState;", "setMBindState", "(Lcom/obric/capabilitykit/AgentServiceConnection$BindState;)V", "stateLock", "", "getApi$capabilitykit_release", "onServiceConnected", "", "name", "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "BindState", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class e implements ServiceConnection {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f8124f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static com.obric.capabilitykit.b f8125g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Object f8126h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static a f8127i;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/capabilitykit/AgentServiceConnection$BindState;", "", "(Ljava/lang/String;I)V", "NotStart", "Started", "Connected", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f8128f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f8129g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f8130h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ a[] f8131i = null;

        static {
            f8128f = new a("NotStart", 0);
            f8129g = new a("Started", 1);
            f8130h = new a("Connected", 2);
            f8131i = a();
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{f8128f, f8129g, f8130h};
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) f8131i.clone();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/capabilitykit/AgentServiceConnection$onServiceConnected$1$1$binder$1$1", "Landroid/os/IBinder$DeathRecipient;", "binderDied", "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IBinder f8132a;

        b(IBinder r1) {
            this.f8132a = r1;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.f8132a.unlinkToDeath(this, 0);
            e.f8124f.b(null);
        }
    }

    static {
        f8124f = new e();
        f8126h = new Object();
        f8127i = a.f8128f;
    }

    private e() {
    }

    public final com.obric.capabilitykit.b a() {
        Object r0 = f8126h;
        monitor-enter(r0);
        com.obric.capabilitykit.b r1 = f8125g;     // Catch: Throwable -> L42
        if (r1 == null) goto L47;
        monitor-exit(r0);
        return r1;
    L47:
        v.a r2 = v.f21457g;     // Catch: Throwable -> L25
        if (f8127i != a.f8128f) goto L23;
        Intent r3 = new Intent("com.obric.aiagent.executionengine.CAPABILITY_REGISTER_SERVICE");     // Catch: Throwable -> L25
        com.obric.capabilitykit.j.c.a r4 = com.obric.capabilitykit.j.c.f8150a;     // Catch: Throwable -> L25
        List<ResolveInfo> r5 = r4.a().getPackageManager().queryIntentServices(r3, 0);     // Catch: Throwable -> L25
        o.e(r5, "packageManager.queryIntentServices(intent, 0)");     // Catch: Throwable -> L25
        if (r5 != null) goto L13;
    L16:
        boolean r6 = true;
    L17:
        if (r6 == true) goto L20;
        ServiceInfo r7 = r5.get(0).serviceInfo;     // Catch: Throwable -> L25
        r3.setComponent(new ComponentName(r7.packageName, r7.name));     // Catch: Throwable -> L25
    L20:
        if (r4.a().bindService(r3, this, 1) == false) goto L22;
        f8127i = a.f8129g;     // Catch: Throwable -> L25
        goto L23
    L22:
        com.obric.capabilitykit.k.c.f8155a.b("AgentServiceConnection", "bindService fail");     // Catch: Throwable -> L25
        r4.a().unbindService(this);     // Catch: Throwable -> L25
        goto L23
    L13:
        if (r5.isEmpty() == true) goto L16;
        r6 = false;
    L23:
        Object r8 = f0.f18324a;     // Catch: Throwable -> L25
        v.b(r8);     // Catch: Throwable -> L25
    L27:
        Throwable r9 = v.d(r8);     // Catch: Throwable -> L42
        if (r9 == null) goto L37;
        com.obric.capabilitykit.k.c.f8155a.c("AgentServiceConnection", "bindService throw exception: " + kotlin.a.b(r9));     // Catch: Throwable -> L42
        v.a r10 = v.f21457g;     // Catch: Throwable -> L32
        com.obric.capabilitykit.j.c.f8150a.a().unbindService(this);     // Catch: Throwable -> L32
        Object r11 = f0.f18324a;     // Catch: Throwable -> L32
        v.b(r11);     // Catch: Throwable -> L32
    L34:
        Throwable r12 = v.d(r11);     // Catch: Throwable -> L42
        if (r12 == null) goto L37;
        com.obric.capabilitykit.k.c.f8155a.c("AgentServiceConnection", "unbindService throw exception: " + kotlin.a.b(r12));     // Catch: Throwable -> L42
        goto L37
    L32:
        th = move-exception;
        v.a r13 = v.f21457g;     // Catch: Throwable -> L42
        r11 = w.a(th);     // Catch: Throwable -> L42
        v.b(r11);     // Catch: Throwable -> L42
    L37:
        monitor-exit(r0);
        com.obric.capabilitykit.b r14 = f8125g;
        if (r14 == null) goto L41;
        return r14;
    L41:
        return h.f8139a;
    L25:
        th = move-exception;
        v.a r15 = v.f21457g;     // Catch: Throwable -> L42
        r8 = w.a(th);     // Catch: Throwable -> L42
        v.b(r8);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        throw th;
    }

    public final void b(com.obric.capabilitykit.b r1) {
        f8125g = r1;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r4, IBinder r5) {
        com.obric.capabilitykit.k.c r3 = com.obric.capabilitykit.k.c.f8155a;
        r3.b("AgentServiceConnection", "onServiceConnected: " + Thread.currentThread().getName());
        Object r6 = f8126h;
        monitor-enter(r6);
        f8127i = a.f8130h;     // Catch: Throwable -> L18
        v.a r0 = v.f21457g;     // Catch: Throwable -> L11
        if (r5 == null) goto L8;
        r5.linkToDeath(new b(r5), 0);     // Catch: Throwable -> L11
    L9:
        ICapabilityManager r7 = ICapabilityManager.Stub.asInterface(r5);     // Catch: Throwable -> L11
        o.e(r7, "asInterface(binder)");     // Catch: Throwable -> L11
        g r1 = new g(r7);     // Catch: Throwable -> L11
        r3.b("AgentServiceConnection", "init binder api done");     // Catch: Throwable -> L11
        f8125g = r1;     // Catch: Throwable -> L11
        f.f8133a.g();     // Catch: Throwable -> L11
        Object r8 = f0.f18324a;     // Catch: Throwable -> L11
        v.b(r8);     // Catch: Throwable -> L11
    L13:
        Throwable r9 = v.d(r8);     // Catch: Throwable -> L18
        if (r9 == null) goto L16;
        com.obric.capabilitykit.k.c.f8155a.c("AgentServiceConnection", "onServiceConnected throw exception: " + kotlin.a.b(r9));     // Catch: Throwable -> L18
    L16:
        monitor-exit(r6);
        return;
    L8:
        r5 = null;
    L11:
        th = move-exception;
        v.a r10 = v.f21457g;     // Catch: Throwable -> L18
        r8 = w.a(th);     // Catch: Throwable -> L18
        v.b(r8);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r2) {
        com.obric.capabilitykit.k.c.f8155a.b("AgentServiceConnection", "onServiceDisconnected");
        f8127i = a.f8128f;
    }
}
