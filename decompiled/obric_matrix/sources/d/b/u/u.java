package d.b.u;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.sync.v2.WsMonitor;
import com.bytedance.sync.v2.presistence.DBServiceImplV2;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
final class u implements d.b.u.w.h, n.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f15083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.b.u.b f15084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bytedance.sync.v2.i.f f15085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bytedance.sync.v2.j.l f15086d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bytedance.sync.v2.a f15087e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.bytedance.sync.v2.d f15088f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicBoolean f15089g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final l<Handler> f15090h;

    class a extends l<Handler> {
        a(u r1) {
        }

        @Override // d.b.u.l
        protected /* bridge */ /* synthetic */ Handler a(Object[] r1) {
            return c(r1);
        }

        protected Handler c(Object... r1) {
            return new Handler(((d.b.u.w.e) com.ss.android.ug.bus.b.a(d.b.u.w.e.class)).get());
        }
    }

    class b implements d.b.u.w.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ u f15091a;

        b(u r1) {
            this.f15091a = r1;
        }

        @Override // d.b.u.w.n
        public /* bridge */ /* synthetic */ d.b.u.w.i a(Long r1) {
            return b(r1);
        }

        public o b(Long r2) {
            return new o(r2, u.f(this.f15091a));
        }
    }

    class c implements d.b.u.w.e {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final l<Looper> f15092f;

        class a extends l<Looper> {
            a(c r1) {
            }

            @Override // d.b.u.l
            protected /* bridge */ /* synthetic */ Looper a(Object[] r1) {
                return c(r1);
            }

            protected Looper c(Object... r1) {
                HandlerThread r0 = new HandlerThread("sync-sdk-v2");
                r0.start();
                return r0.getLooper();
            }
        }

        c(u r1) {
            this.f15092f = new a(this);
        }

        @Override // d.b.u.w.e
        public Looper get() {
            return this.f15092f.b(new Object[0]);
        }
    }

    class d implements com.bytedance.sync.v2.f.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ u f15093a;

        d(u r1) {
            this.f15093a = r1;
        }

        @Override // com.bytedance.sync.v2.f.i
        public void a(int r1, com.bytedance.sync.v2.j.e r2) {
            u.g(this.f15093a).a(r1, r2);
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ u f15094f;

        e(u r1) {
            this.f15094f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            r.h(u.h(this.f15094f));
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ WsChannelMsg f15095f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ u f15096g;

        f(u r1, WsChannelMsg r2) {
            this.f15096g = r1;
            this.f15095f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sync.v2.j.e r0 = u.i(this.f15096g).F(this.f15095f);
            u.g(this.f15096g).a(0, r0);
            ((com.bytedance.sync.v2.f.a) com.ss.android.ug.bus.b.a(com.bytedance.sync.v2.f.a.class)).a(r0);
            ((com.bytedance.sync.v2.f.f) com.ss.android.ug.bus.b.a(com.bytedance.sync.v2.f.f.class)).H(this.f15095f);
        }
    }

    public u(Context r8, d.b.u.e r9) {
        this.f15089g = new AtomicBoolean(false);
        this.f15090h = new a(this);
        this.f15083a = r8;
        d.b.u.b r0 = new d.b.u.b(this, new b(this));
        this.f15084b = r0;
        com.bytedance.sync.v2.a r1 = new com.bytedance.sync.v2.a(r9, r0);
        this.f15087e = r1;
        com.bytedance.sync.v2.j.l r2 = new com.bytedance.sync.v2.j.l(r9.f15027e, r9.f15028f);
        this.f15086d = r2;
        com.bytedance.sync.v2.i.f r3 = new com.bytedance.sync.v2.i.f(r8, r9);
        this.f15085c = r3;
        d.b.u.c0.a r4 = new d.b.u.c0.a(r8, r9.f15026d);
        com.ss.android.ug.bus.b.b(d.b.u.w.b.class, r4);
        com.ss.android.ug.bus.b.b(d.b.u.w.e.class, new c(this));
        com.ss.android.ug.bus.b.b(com.bytedance.sync.v2.f.e.class, r2);
        com.ss.android.ug.bus.b.b(com.bytedance.sync.v2.f.b.class, new DBServiceImplV2(r8));
        com.ss.android.ug.bus.b.b(com.bytedance.sync.v2.f.m.class, new com.bytedance.sync.v2.h.i(r9));
        com.ss.android.ug.bus.b.b(com.bytedance.sync.v2.f.a.class, new com.bytedance.sync.v2.compensate.a(r8, r9, new d(this)));
        com.ss.android.ug.bus.b.b(com.bytedance.sync.v2.f.f.class, new com.bytedance.sync.v2.b());
        com.ss.android.ug.bus.b.b(com.bytedance.sync.v2.f.g.class, new com.bytedance.sync.v2.h.d(r8, r9, r3));
        com.ss.android.ug.bus.b.b(com.bytedance.sync.v2.f.k.class, new com.bytedance.sync.v2.j.m());
        com.ss.android.ug.bus.b.b(h.class, r9.f15024b);
        com.ss.android.ug.bus.b.b(d.b.u.w.c.class, new d.b.u.f(r8));
        com.ss.android.ug.bus.b.b(com.bytedance.sync.v2.f.d.class, new com.bytedance.sync.v2.i.b(r8, r9, r1));
        com.ss.android.ug.bus.b.b(com.bytedance.sync.v2.f.h.class, new com.bytedance.sync.v2.k.b(r8, r9, r4, r0));
        com.ss.android.ug.bus.b.b(com.bytedance.sync.v2.f.c.class, new com.bytedance.sync.v2.i.a());
        com.ss.android.ug.bus.b.b(d.b.u.w.j.class, new d.b.u.z.b(r9));
        com.ss.android.ug.bus.b.b(com.bytedance.sync.v2.f.l.class, new com.bytedance.sync.v2.c());
        com.ss.android.ug.bus.b.b(i.class, new d.b.u.d(r8, r9));
        com.ss.android.ug.bus.b.b(com.bytedance.sync.v2.e.b.class, new com.bytedance.sync.v2.e.a(r8, r9));
    }

    static /* synthetic */ d.b.u.b f(u r0) {
        return r0.f15084b;
    }

    static /* synthetic */ com.bytedance.sync.v2.i.f g(u r0) {
        return r0.f15085c;
    }

    static /* synthetic */ Context h(u r0) {
        return r0.f15083a;
    }

    static /* synthetic */ com.bytedance.sync.v2.j.l i(u r0) {
        return r0.f15086d;
    }

    @Override // d.b.u.w.h
    public void a(WsChannelMsg r3) {
        this.f15090h.b(new Object[0]).post(new f(this, r3));
    }

    @Override // d.b.u.w.h
    public synchronized void b(String r5) {
        monitor-enter(this);
        d.b.u.w.b r0 = (d.b.u.w.b) com.ss.android.ug.bus.b.a(d.b.u.w.b.class);     // Catch: Throwable -> L12
        r0.D(r5);     // Catch: Throwable -> L12
        if (this.f15089g.compareAndSet(false, true) == false) goto L6;
        r0.V();     // Catch: Throwable -> L12
        new WsMonitor().f();     // Catch: Throwable -> L12
    L6:
        com.bytedance.sync.v2.d r6 = this.f15088f;     // Catch: Throwable -> L12
        if (r6 == null) goto L9;
        r6.c();     // Catch: Throwable -> L12
    L9:
        com.bytedance.sync.v2.d r7 = new com.bytedance.sync.v2.d(this.f15083a);     // Catch: Throwable -> L12
        this.f15088f = r7;     // Catch: Throwable -> L12
        r7.f();     // Catch: Throwable -> L12
        ((com.bytedance.sync.v2.f.h) com.ss.android.ug.bus.b.a(com.bytedance.sync.v2.f.h.class)).d0();     // Catch: Throwable -> L12
        this.f15090h.b(new Object[0]).postDelayed(new e(this), TimeUnit.MINUTES.toMillis(2));     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // d.b.u.w.h
    public Collection<n> c() {
        return this.f15084b.b();
    }

    @Override // d.b.u.n.a
    public void d(long r1) {
        this.f15087e.f(r1);
    }

    @Override // d.b.u.w.h
    public d.b.u.w.i e(m r4) {
        d.b.u.x.b.a("register business " + r4.f15057a);
        return this.f15084b.c(r4);
    }
}
