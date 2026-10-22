package com.obric.matrix.q.i;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import h.a.b1;
import h.a.h;
import h.a.m0;
import h.a.q1;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.k0.d;
import kotlin.k0.j.a.f;
import kotlin.k0.j.a.l;
import kotlin.n0.c.p;
import kotlin.n0.d.o;
import kotlin.w;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u0004J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0004H\u0002J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u0004J\u0016\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\nJ\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0004J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/matrix/base/tunnel/ClientBinderManager;", "", "()V", "TAG", "", "sPackageName2ClientDiedCallbacks", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/matrix/base/tunnel/IClientDiedCallback;", "sPackageName2ServerCallback", "Lcom/obric/matrix/platform/server/IServerCallback;", "getServerCallbackByPackageName", "packageName", "notifyClientDiedAsync", "", "registerClientDiedCallbackByPackageName", "clientDiedCallback", LocationMonitorConst.TAG, "registerServerCallbackByPackageName", "serverCallback", "unregisterClientDiedCallbackByPackageName", "unregisterServerCallbackByPackageName", "needNotify", "", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9901a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, com.obric.matrix.platform.e.b> f9902b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap<String, CopyOnWriteArrayList<c>> f9903c = null;

    /* JADX INFO: renamed from: com.obric.matrix.q.i.a$a, reason: collision with other inner class name */
    @f(c = "com.obric.matrix.base.tunnel.ClientBinderManager$notifyClientDiedAsync$1", f = "ClientBinderManager.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class C0282a extends l implements p<m0, d<? super f0>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f9904f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f9905g;

        C0282a(String r1, d<? super C0282a> r2) {
            this.f9905g = r1;
            super(2, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final d<f0> create(Object r1, d<?> r2) {
            return new C0282a(this.f9905g, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(m0 r1, d<? super f0> r2) {
            return ((C0282a) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Object invoke(m0 r1, d<? super f0> r2) {
            return invoke2(r1, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r3) {
            kotlin.k0.i.b.c();
            if (this.f9904f != 0) goto L20;
            w.b(r3);
            CopyOnWriteArrayList r4 = (CopyOnWriteArrayList) a.a().get(this.f9905g);
            StringBuilder r0 = new StringBuilder();
            r0.append("the notifyClientDiedAsync list size ");
            if (r4 == null) goto L7;
            Integer r1 = kotlin.k0.j.a.b.b(r4.size());
        L8:
            r0.append(r1);
            r0.append(". ");
            com.obric.matrix.r.c.c.b("ClientBinderManager", r0.toString());
            if (r4 == null) goto L14;
            Iterator r2 = r4.iterator();
        L12:
            if (r2.hasNext() == false) goto L14;
            ((c) r2.next()).a();
        L14:
            a.a().remove(this.f9905g);
            if (r4 == null) goto L18;
            r4.clear();
        L18:
            return f0.f18324a;
        L7:
            r1 = null;
            goto L8
        L20:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        f9901a = new a();
        f9902b = new ConcurrentHashMap();
        f9903c = new ConcurrentHashMap();
    }

    private a() {
    }

    public static final /* synthetic */ ConcurrentHashMap a() {
        return f9903c;
    }

    private final void b(String r8) {
        com.obric.matrix.r.c.c.b("ClientBinderManager", "the notifyClientDiedAsync is invoked for " + r8 + '.');
        h.b(q1.f17560f, b1.b(), null, new C0282a(r8, null), 2, null);
    }

    public static /* synthetic */ void d(a r0, String r1, c r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = "";
    L5:
        r0.c(r1, r2, r3);
    }

    public static /* synthetic */ com.obric.matrix.platform.e.b g(a r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = true;
    L6:
        return r0.f(r1, r2);
    }

    public final void c(String r2, c r3, String r4) {
        o.f(r2, "packageName");
        o.f(r3, "clientDiedCallback");
        o.f(r4, LocationMonitorConst.TAG);
        ConcurrentHashMap<String, CopyOnWriteArrayList<c>> r1 = f9903c;
        if (r1.get(r2) != null) goto L5;
        r1.put(r2, new CopyOnWriteArrayList());
    L5:
        CopyOnWriteArrayList<c> r0 = r1.get(r2);
        if (r0 == null) goto L8;
        r0.add(r3);
    L8:
        StringBuilder r5 = new StringBuilder();
        r5.append("the clientDiedCallback is registered for ");
        r5.append(r2);
        r5.append(" and the current size is ");
        CopyOnWriteArrayList<c> r6 = r1.get(r2);
        if (r6 == null) goto L11;
        Integer r7 = Integer.valueOf(r6.size());
    L12:
        r5.append(r7);
        r5.append(". tag = ");
        r5.append(r4);
        com.obric.matrix.r.c.c.b("ClientBinderManager", r5.toString());
        return;
    L11:
        r7 = null;
        goto L12
    }

    public final void e(String r1, com.obric.matrix.platform.e.b r2) {
        o.f(r1, "packageName");
        o.f(r2, "serverCallback");
        f9902b.put(r1, r2);
        com.obric.matrix.r.c.c.b("ClientBinderManager", "the serverCallback is registered for " + r1 + '.');
    }

    public final com.obric.matrix.platform.e.b f(String r3, boolean r4) {
        o.f(r3, "packageName");
        com.obric.matrix.r.c.c.b("ClientBinderManager", "the serverCallback is unregistered for " + r3);
        com.obric.matrix.platform.e.b r0 = f9902b.remove(r3);
        if (r4 == false) goto L5;
        b(r3);
    L5:
        return r0;
    }
}
