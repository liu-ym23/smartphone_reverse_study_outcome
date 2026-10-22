package com.bytedance.sync.v2.i;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.sync.v2.f.i;
import com.bytedance.sync.v2.j.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.h;
import kotlin.i0.r;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.n0.d.y;
import kotlin.s0.l;

/* JADX INFO: loaded from: classes.dex */
public final class f implements i {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final /* synthetic */ l[] f5999h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f6001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h f6002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final h f6003d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final h f6004e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f6005f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final d.b.u.e f6006g;

    static final class a extends q implements kotlin.n0.c.a<List<com.bytedance.sync.v2.i.d<com.bytedance.sync.v2.j.i>>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f6007f = null;

        static {
            f6007f = new a();
        }

        a() {
            super(0);
        }

        public final List<com.bytedance.sync.v2.i.d<com.bytedance.sync.v2.j.i>> a() {
            ArrayList r1 = new ArrayList();
            r1.add(new com.bytedance.sync.v2.i.g.a());
            return r1;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ List<com.bytedance.sync.v2.i.d<com.bytedance.sync.v2.j.i>> invoke() {
            return a();
        }
    }

    static final class b extends q implements kotlin.n0.c.a<Handler> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f6008f = null;

        static {
            f6008f = new b();
        }

        b() {
            super(0);
        }

        public final Handler a() {
            return new Handler(((d.b.u.w.e) com.ss.android.ug.bus.b.a(d.b.u.w.e.class)).get());
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Handler invoke() {
            return a();
        }
    }

    static final class c extends q implements kotlin.n0.c.a<List<com.bytedance.sync.v2.i.d<j>>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f6009f = null;

        static {
            f6009f = new c();
        }

        c() {
            super(0);
        }

        public final List<com.bytedance.sync.v2.i.d<j>> a() {
            ArrayList r1 = new ArrayList();
            r1.add(new com.bytedance.sync.v2.i.h.e());
            r1.add(new com.bytedance.sync.v2.k.c());
            return r1;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ List<com.bytedance.sync.v2.i.d<j>> invoke() {
            return a();
        }
    }

    static final class d extends q implements kotlin.n0.c.a<List<com.bytedance.sync.v2.i.e<j>>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ f f6010f;

        d(f r1) {
            this.f6010f = r1;
            super(0);
        }

        public final List<com.bytedance.sync.v2.i.e<j>> a() {
            ArrayList r0 = new ArrayList();
            com.bytedance.sync.v2.i.e<j> r1 = ((com.bytedance.sync.v2.e.b) com.ss.android.ug.bus.b.a(com.bytedance.sync.v2.e.b.class)).y();
            o.b(r1, "UgBusFramework.getServic…istoryHandlerWithMethod()");
            r0.add(r1);
            r0.add(new com.bytedance.sync.v2.i.h.b(f.e(this.f6010f), f.d(this.f6010f)));
            return r0;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ List<com.bytedance.sync.v2.i.e<j>> invoke() {
            return a();
        }
    }

    static final class e implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ f f6011f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.bytedance.sync.v2.j.e f6012g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f6013h;

        e(f r1, com.bytedance.sync.v2.j.e r2, int r3) {
            this.f6011f = r1;
            this.f6012g = r2;
            this.f6013h = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.b.u.x.b.a(f.f(this.f6011f) + "receive package -> " + this.f6012g);
            com.bytedance.sync.v2.j.e r0 = this.f6012g;
            if (r0 != null) goto L6;
            d.b.u.x.b.e(f.f(this.f6011f) + "protocol is null");
            return;
        L6:
            List<com.bytedance.sync.v2.j.f> r1 = r0.f6071g;
            if (r1 != null) goto L9;
        L12:
            boolean r2 = true;
        L13:
            if (r2 == false) goto L16;
            d.b.u.x.b.e(f.f(this.f6011f) + "topics is null");
            return;
        L16:
            com.bytedance.sync.v2.j.b r3 = this.f6012g.f6070f;
            if (r3 != null) goto L21;
            d.b.u.x.b.b(f.f(this.f6011f) + "header is null");
            return;
        L21:
            if (r3.f6035f.compareTo(com.bytedance.sync.v2.j.q.f6142i) >= 0) goto L24;
            d.b.u.x.b.b(f.f(this.f6011f) + "version is " + this.f6012g.f6070f.f6035f + ",ignore");
            return;
        L24:
            com.bytedance.sync.v2.j.e r4 = this.f6012g;
            com.bytedance.sync.v2.j.i r5 = r4.f6070f.f6039j;
            if (r5 != null) goto L27;
        L30:
            f.c(this.f6011f, this.f6013h, r4);
            return;
        L27:
            if (r5 == com.bytedance.sync.v2.j.i.f6101g) goto L30;
            f.b(this.f6011f, r4);
            return;
        L9:
            if (r1.isEmpty() == true) goto L12;
            r2 = false;
            goto L13
        }
    }

    static {
        f5999h = new l[]{e0.g(new y(e0.b(f.class), "mMsgProcessors", "getMMsgProcessors()Ljava/util/List;")), e0.g(new y(e0.b(f.class), "mMsgProcessorsWithMethod", "getMMsgProcessorsWithMethod()Ljava/util/List;")), e0.g(new y(e0.b(f.class), "mCtrlMsgProcessors", "getMCtrlMsgProcessors()Ljava/util/List;")), e0.g(new y(e0.b(f.class), "mHandler", "getMHandler()Landroid/os/Handler;"))};
    }

    public f(Context r2, d.b.u.e r3) {
        o.g(r2, "context");
        o.g(r3, "configuration");
        this.f6005f = r2;
        this.f6006g = r3;
        this.f6000a = "[ProtocolProcessor] ";
        this.f6001b = kotlin.i.b(c.f6009f);
        this.f6002c = kotlin.i.b(new d(this));
        this.f6003d = kotlin.i.b(a.f6007f);
        this.f6004e = kotlin.i.b(b.f6008f);
    }

    public static final /* synthetic */ void b(f r0, com.bytedance.sync.v2.j.e r1) {
        r0.h(r1);
    }

    public static final /* synthetic */ void c(f r0, int r1, com.bytedance.sync.v2.j.e r2) {
        r0.i(r1, r2);
    }

    public static final /* synthetic */ d.b.u.e d(f r0) {
        return r0.f6006g;
    }

    public static final /* synthetic */ Context e(f r0) {
        return r0.f6005f;
    }

    public static final /* synthetic */ String f(f r0) {
        return r0.f6000a;
    }

    private final void g(int r4, j r5, com.bytedance.sync.v2.j.b r6, List<com.bytedance.sync.v2.j.f> r7) {
        Iterator<com.bytedance.sync.v2.i.d<j>> r0 = l().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        com.bytedance.sync.v2.i.d<j> r1 = r0.next();
        if (r1.a(r5) == false) goto L4;
        r1.b(r6, r7);
    L8:
        Iterator<com.bytedance.sync.v2.i.e<j>> r3 = m().iterator();
    L10:
        if (r3.hasNext() == false) goto L14;
        com.bytedance.sync.v2.i.e<j> r2 = r3.next();
        if (r2.a(r5) == false) goto L10;
        r2.b(r4, r6, r7);
        goto L10
    }

    private final void h(com.bytedance.sync.v2.j.e r4) {
        Iterator<T> r3 = j().iterator();
    L4:
        if (r3.hasNext() == false) goto L10;
        com.bytedance.sync.v2.i.d r0 = (com.bytedance.sync.v2.i.d) r3.next();
        com.bytedance.sync.v2.j.i r1 = r4.f6070f.f6039j;
        o.b(r1, "protocol.header.ctrl");
        if (r0.a(r1) == false) goto L4;
        com.bytedance.sync.v2.j.b r5 = r4.f6070f;
        o.b(r5, "protocol.header");
        List<com.bytedance.sync.v2.j.f> r6 = r4.f6071g;
        o.b(r6, "protocol.topics");
        r0.b(r5, r6);
        return;
    L10:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private final void i(int r10, com.bytedance.sync.v2.j.e r11) {
        List<com.bytedance.sync.v2.j.f> r0 = r11.f6071g;
        o.b(r0, "protocol.topics");
        j r1 = ((com.bytedance.sync.v2.j.f) r.P(r0)).f6074f;
        ArrayList r2 = new ArrayList();
        List<com.bytedance.sync.v2.j.f> r3 = r11.f6071g;
        o.b(r3, "protocol.topics");
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L17;
        com.bytedance.sync.v2.j.f r5 = (com.bytedance.sync.v2.j.f) r4.next();
        if (r5.f6074f == r1) goto L7;
        if (r1 != null) goto L10;
    L15:
        ArrayList r6 = new ArrayList();
        o.b(r5, "it");
        r6.add(r5);
        r2 = r6;
        r1 = r5.f6074f;
        goto L4
    L10:
        if (r2.isEmpty() == true) goto L15;
        if (r1 == null) goto L13;
        com.bytedance.sync.v2.j.b r7 = r11.f6070f;
        o.b(r7, "protocol.header");
        g(r10, r1, r7, r2);
        goto L15
    L13:
        o.p();
        throw null;
    L7:
        o.b(r5, "it");
        r2.add(r5);
        goto L4
    L17:
        if (r2.isEmpty() == true) goto L22;
        if (r1 == null) goto L20;
        com.bytedance.sync.v2.j.b r12 = r11.f6070f;
        o.b(r12, "protocol.header");
        g(r10, r1, r12, r2);
        return;
    L20:
        o.p();
        throw null;
    }

    private final List<com.bytedance.sync.v2.i.d<com.bytedance.sync.v2.j.i>> j() {
        h r2 = this.f6003d;
        l r0 = f5999h[2];
        return (List) r2.getValue();
    }

    private final Handler k() {
        h r2 = this.f6004e;
        l r0 = f5999h[3];
        return (Handler) r2.getValue();
    }

    private final List<com.bytedance.sync.v2.i.d<j>> l() {
        h r2 = this.f6001b;
        l r0 = f5999h[0];
        return (List) r2.getValue();
    }

    private final List<com.bytedance.sync.v2.i.e<j>> m() {
        h r2 = this.f6002c;
        l r0 = f5999h[1];
        return (List) r2.getValue();
    }

    @Override // com.bytedance.sync.v2.f.i
    public void a(int r2, com.bytedance.sync.v2.j.e r3) {
        e r0 = new e(this, r3, r2);
        if (o.a(Looper.myLooper(), k().getLooper()) == false) goto L5;
        r0.run();
        return;
    L5:
        k().post(r0);
    }
}
