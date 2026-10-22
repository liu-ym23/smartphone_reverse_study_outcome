package com.bytedance.sync.v2.compensate;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import d.b.u.l;
import d.b.u.w.m;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
final class g implements m, com.bytedance.sync.v2.h.i.a, Handler.Callback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f5911f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicBoolean f5912g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final l<Handler> f5913h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final d.b.u.e f5914i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Context f5915j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final com.bytedance.sync.v2.j.m f5916k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile b f5917l;
    private boolean m;

    class a extends l<Handler> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f5918b;

        a(g r1) {
            this.f5918b = r1;
        }

        @Override // d.b.u.l
        protected /* bridge */ /* synthetic */ Handler a(Object[] r1) {
            return c(r1);
        }

        protected Handler c(Object... r2) {
            return new Handler(((d.b.u.w.e) com.ss.android.ug.bus.b.a(d.b.u.w.e.class)).get(), this.f5918b);
        }
    }

    interface b {
        void a(com.bytedance.sync.v2.j.e r1);

        void b();

        void c(boolean r1);

        void destroy();
    }

    private static class c implements b {
        private c() {
        }

        /* synthetic */ c(a r1) {
            this();
        }

        @Override // com.bytedance.sync.v2.compensate.g.b
        public void a(com.bytedance.sync.v2.j.e r1) {
        }

        @Override // com.bytedance.sync.v2.compensate.g.b
        public void b() {
        }

        @Override // com.bytedance.sync.v2.compensate.g.b
        public void c(boolean r1) {
        }

        @Override // com.bytedance.sync.v2.compensate.g.b
        public void destroy() {
        }
    }

    private static class d implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d.b.u.b0.a f5919a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final l<Handler> f5920b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.bytedance.sync.v2.j.m f5921c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private f f5922d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final com.bytedance.sync.v2.compensate.c f5923e;

        class a implements com.bytedance.sync.v2.compensate.c {
            a(d r1) {
            }

            @Override // com.bytedance.sync.v2.compensate.c
            public boolean isForeground() {
                return true;
            }
        }

        public d(l<Handler> r2, d.b.u.b0.a r3, com.bytedance.sync.v2.j.m r4) {
            this.f5923e = new a(this);
            this.f5920b = r2;
            this.f5919a = r3;
            this.f5921c = r4;
        }

        private f d(boolean r7, d.b.u.b0.a r8) {
            f.b r5 = new f.b();
            r5.f5909a = r8.k();
            if (r7 == false) goto L5;
            r5.f5910b = r8.k();
            return new com.bytedance.sync.v2.compensate.e("[SocketPoll] ", this.f5923e, this.f5921c, this.f5920b, r5);
        L5:
            r5.f5910b = r8.k();
            return new h("[SocketPoll] ", this.f5923e, this.f5921c, this.f5920b, r5);
        }

        @Override // com.bytedance.sync.v2.compensate.g.b
        public void a(com.bytedance.sync.v2.j.e r1) {
            f r0 = this.f5922d;
            if (r0 == null) goto L6;
            r0.j(r1);
            return;
        }

        @Override // com.bytedance.sync.v2.compensate.g.b
        public void b() {
            f r0 = this.f5922d;
            if (r0 != null) goto L5;
        L6:
            if (r0 == null) goto L8;
            r0.b();
        L8:
            f r1 = d(true, this.f5919a);
            r1.i(true);
            this.f5922d = r1;
            return;
        L5:
            if (r0.f() == 1) goto L6;
        }

        @Override // com.bytedance.sync.v2.compensate.g.b
        public void c(boolean r2) {
            f r3 = d(r2, this.f5919a);
            r3.i(true);
            this.f5922d = r3;
        }

        @Override // com.bytedance.sync.v2.compensate.g.b
        public void destroy() {
            f r0 = this.f5922d;
            if (r0 == null) goto L6;
            r0.b();
            return;
        }
    }

    private static class e implements com.bytedance.sync.v2.f.g {
        private e() {
        }

        /* synthetic */ e(a r1) {
            this();
        }

        @Override // com.bytedance.sync.v2.f.g
        public void W(com.bytedance.sync.v2.g.a r1) {
            r1.f5946b = false;
            r1.f5947c = false;
            r1.f5948d = new com.bytedance.sync.v2.h.g();
            ((com.bytedance.sync.v2.f.g) com.ss.android.ug.bus.b.a(com.bytedance.sync.v2.f.g.class)).W(r1);
        }

        @Override // com.bytedance.sync.v2.f.g
        public boolean c() {
            return false;
        }
    }

    g(Context r3, d.b.u.e r4) {
        this.f5911f = new AtomicBoolean(false);
        this.f5912g = new AtomicBoolean(false);
        this.f5915j = r3;
        this.f5914i = r4;
        this.f5916k = new com.bytedance.sync.v2.j.m(new e(null));
        this.f5913h = new a(this);
    }

    private b b(boolean r2, d.b.u.b0.a r3) {
        if (r2 == false) goto L7;
        if (r3.b() == false) goto L7;
        return new d(this.f5913h, r3, this.f5916k);
    L7:
        return new c(null);
    }

    private boolean d() {
        return this.f5911f.get();
    }

    private synchronized void h(d.b.u.b0.a r2, boolean r3) {
        monitor-enter(this);
        if (r2 != null) goto L15;
        monitor-exit(this);
        return;
    L15:
        d.b.u.x.b.e("[SocketPoll] start socket poll with settings.");     // Catch: Throwable -> L12
        if (this.f5917l == null) goto L9;
        this.f5917l.destroy();     // Catch: Throwable -> L12
        this.f5917l = null;     // Catch: Throwable -> L12
        d.b.u.x.b.e("[SocketPoll] destroy old one.");     // Catch: Throwable -> L12
    L9:
        b r4 = b(r3, r2);     // Catch: Throwable -> L12
        d.b.u.x.b.a("[SocketPoll] start new one. isReadyToPoll = " + r4);     // Catch: Throwable -> L12
        r4.c(d());     // Catch: Throwable -> L12
        this.f5917l = r4;     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.sync.v2.h.i.a
    public void M(boolean r2) {
        this.f5913h.b(new Object[0]).obtainMessage(102, Boolean.valueOf(r2)).sendToTarget();
    }

    @Override // d.b.u.w.m
    public void a(d.b.u.w.i.a r3) {
        Message r4 = this.f5913h.b(new Object[0]).obtainMessage(101);
        this.f5913h.b(new Object[0]).sendMessage(r4);
    }

    public void c() {
        d.b.u.b0.b.g(this.f5915j).h(this);
        this.f5913h.b(new Object[0]).removeMessages(101);
        this.f5913h.b(new Object[0]).removeMessages(102);
    }

    public void e() {
        this.f5911f.set(true);
        if (d() == false) goto L8;
        b r2 = this.f5917l;
        if (r2 == null) goto L9;
        r2.b();
        return;
    L9:
        return;
    }

    public void f(com.bytedance.sync.v2.j.e r3) {
        b r0 = this.f5917l;
        if (this.f5912g.get() == true) goto L5;
        return;
    L5:
        if (this.f5917l == null) goto L9;
        r0.a(r3);
        return;
    }

    public void g() {
        d.b.u.b0.a r0 = d.b.u.b0.b.g(this.f5915j).f();
        d.b.u.b0.b.g(this.f5915j).d(this);
        ((com.bytedance.sync.v2.f.m) com.ss.android.ug.bus.b.a(com.bytedance.sync.v2.f.m.class)).E(this);
        this.m = this.f5914i.f15025c.j();
        d.b.u.x.b.e("[SocketPoll] start socket poll.");
        h(r0, this.m);
        this.f5912g.set(true);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message r3) {
        if (r3.what != 101) goto L6;
        boolean r0 = this.f5914i.f15025c.j();
        h(d.b.u.b0.b.g(this.f5915j).f(), r0);
        this.m = r0;
    L6:
        if (r3.what != 102) goto L10;
        boolean r4 = this.f5914i.f15025c.j();
        h(d.b.u.b0.b.g(this.f5915j).f(), r4);
        this.m = r4;
        return false;
    L10:
        return false;
    }
}
