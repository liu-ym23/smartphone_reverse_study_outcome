package d.c.i.g;

import android.content.ContentResolver;
import android.net.Uri;
import d.c.i.p.a1;
import d.c.i.p.b1;
import d.c.i.p.c1;
import d.c.i.p.g0;
import d.c.i.p.i0;
import d.c.i.p.j0;
import d.c.i.p.k0;
import d.c.i.p.o;
import d.c.i.p.p;
import d.c.i.p.p0;
import d.c.i.p.r0;
import d.c.i.p.s;
import d.c.i.p.s0;
import d.c.i.p.y0;
import d.c.i.p.z0;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    Map<k0<d.c.c.h.a<d.c.i.l.c>>, k0<d.c.c.h.a<d.c.i.l.c>>> A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ContentResolver f16130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l f16131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g0 f16132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f16133d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f16134e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f16135f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final z0 f16136g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f16137h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f16138i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f16139j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final d.c.i.s.c f16140k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    k0<d.c.c.h.a<d.c.i.l.c>> f16141l;
    k0<d.c.i.l.e> m;
    k0<d.c.i.l.e> n;
    k0<Void> o;
    k0<Void> p;
    private k0<d.c.i.l.e> q;
    k0<d.c.c.h.a<d.c.i.l.c>> r;
    k0<d.c.c.h.a<d.c.i.l.c>> s;
    k0<d.c.c.h.a<d.c.i.l.c>> t;
    k0<d.c.c.h.a<d.c.i.l.c>> u;
    k0<d.c.c.h.a<d.c.i.l.c>> v;
    k0<d.c.c.h.a<d.c.i.l.c>> w;
    k0<d.c.c.h.a<d.c.i.l.c>> x;
    k0<d.c.c.h.a<d.c.i.l.c>> y;
    Map<k0<d.c.c.h.a<d.c.i.l.c>>, k0<d.c.c.h.a<d.c.i.l.c>>> z;

    public m(ContentResolver r1, l r2, g0 r3, boolean r4, boolean r5, z0 r6, boolean r7, boolean r8, boolean r9, boolean r10, d.c.i.s.c r11) {
        this.f16130a = r1;
        this.f16131b = r2;
        this.f16132c = r3;
        this.f16133d = r4;
        this.f16134e = r5;
        this.z = new HashMap();
        new HashMap();
        this.A = new HashMap();
        this.f16136g = r6;
        this.f16137h = r7;
        this.f16138i = r8;
        this.f16135f = r9;
        this.f16139j = r10;
        this.f16140k = r11;
    }

    private k0<d.c.i.l.e> A(k0<d.c.i.l.e> r2) {
        if (d.c.i.r.b.d() == false) goto L6;
        d.c.i.r.b.a("ProducerSequenceFactory#newDiskCacheSequence");
    L6:
        if (this.f16135f == false) goto L8;
        r2 = this.f16131b.v(r2);
    L8:
        p r3 = this.f16131b.k(r2);
        o r1 = this.f16131b.j(r3);
        if (d.c.i.r.b.d() == false) goto L11;
        d.c.i.r.b.b();
    L11:
        return r1;
    }

    private k0<d.c.i.l.e> B(c1<d.c.i.l.e>[] r3) {
        b1 r4 = this.f16131b.F(r3);
        return this.f16131b.C(r4, true, this.f16140k);
    }

    private k0<d.c.i.l.e> C(k0<d.c.i.l.e> r2) {
        if (d.c.c.l.c.f15447a == false) goto L10;
        if (this.f16134e == true) goto L7;
    L8:
        r2 = this.f16131b.G(r2);
        goto L10
    L7:
        if (d.c.c.l.c.f15449c == null) goto L8;
    L10:
        if (this.f16139j == false) goto L12;
        r2 = A(r2);
    L12:
        s r3 = this.f16131b.m(r2);
        return this.f16131b.l(r3);
    }

    private k0<d.c.i.l.e> D(c1<d.c.i.l.e>[] r3) {
        b1 r4 = this.f16131b.F(r3);
        return this.f16131b.z(r4, true, this.f16140k);
    }

    private k0<d.c.i.l.e> E(k0<d.c.i.l.e> r4, c1<d.c.i.l.e>[] r5) {
        d.c.i.p.a r6 = l.a(r4);
        p0 r7 = this.f16131b.z(r6, true, this.f16140k);
        a1 r8 = this.f16131b.E(r7);
        return l.g(D(r5), r8);
    }

    private k0<d.c.i.l.e> F(k0<d.c.i.l.e> r4, c1<d.c.i.l.e>[] r5) {
        d.c.i.p.a r6 = l.a(r4);
        s0 r7 = this.f16131b.C(r6, true, this.f16140k);
        a1 r8 = this.f16131b.E(r7);
        d.c.i.p.j r9 = l.g(B(r5), r8);
        r0 r10 = this.f16131b.B(r9);
        return this.f16131b.A(r10);
    }

    private static void G(d.c.i.q.b r1) {
        d.c.c.d.i.g(r1);
        if (r1.i().b() > d.c.i.q.b.EnumC0435b.f16509i.b()) goto L5;
        boolean r2 = true;
    L6:
        d.c.c.d.i.b(r2);
        return;
    L5:
        r2 = false;
        goto L6
    }

    private synchronized k0<d.c.i.l.e> a() {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (d.c.i.r.b.d() == false) goto L7;
        d.c.i.r.b.a("ProducerSequenceFactory#getBackgroundLocalFileFetchToEncodeMemorySequence");     // Catch: Throwable -> L20
    L7:
        if (this.m != null) goto L15;
        if (d.c.i.r.b.d() == false) goto L11;
        d.c.i.r.b.a("ProducerSequenceFactory#getBackgroundLocalFileFetchToEncodeMemorySequence:init");     // Catch: Throwable -> L20
    L11:
        k0<d.c.i.l.e> r0 = C(this.f16131b.r());     // Catch: Throwable -> L20
        this.m = this.f16131b.b(r0, this.f16136g);     // Catch: Throwable -> L20
        if (d.c.i.r.b.d() == false) goto L15;
        d.c.i.r.b.b();     // Catch: Throwable -> L20
    L15:
        if (d.c.i.r.b.d() == false) goto L17;
        d.c.i.r.b.b();     // Catch: Throwable -> L20
    L17:
        k0<d.c.i.l.e> r1 = this.m;     // Catch: Throwable -> L20
        monitor-exit(this);
        return r1;
    }

    private synchronized k0<d.c.i.l.e> b() {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (d.c.i.r.b.d() == false) goto L7;
        d.c.i.r.b.a("ProducerSequenceFactory#getBackgroundNetworkFetchToEncodedMemorySequence");     // Catch: Throwable -> L20
    L7:
        if (this.n != null) goto L15;
        if (d.c.i.r.b.d() == false) goto L11;
        d.c.i.r.b.a("ProducerSequenceFactory#getBackgroundNetworkFetchToEncodedMemorySequence:init");     // Catch: Throwable -> L20
    L11:
        this.n = this.f16131b.b(e(), this.f16136g);     // Catch: Throwable -> L20
        if (d.c.i.r.b.d() == false) goto L15;
        d.c.i.r.b.b();     // Catch: Throwable -> L20
    L15:
        if (d.c.i.r.b.d() == false) goto L17;
        d.c.i.r.b.b();     // Catch: Throwable -> L20
    L17:
        k0<d.c.i.l.e> r0 = this.n;     // Catch: Throwable -> L20
        monitor-exit(this);
        return r0;
    }

    private k0<d.c.c.h.a<d.c.i.l.c>> c(d.c.i.q.b r3) {
    L69:
        th = move-exception;
        if (d.c.i.r.b.d() == false) goto L73;
        d.c.i.r.b.b();
    L73:
        throw th;
    L3:
        if (d.c.i.r.b.d() == false) goto L5;
        d.c.i.r.b.a("ProducerSequenceFactory#getBasicDecodedImageSequence");     // Catch: Throwable -> L69
    L5:
        d.c.c.d.i.g(r3);     // Catch: Throwable -> L69
        Uri r0 = r3.v();     // Catch: Throwable -> L69
        d.c.c.d.i.h(r0, "Uri is null.");     // Catch: Throwable -> L69
        int r1 = r3.w();     // Catch: Throwable -> L69
        if (r1 == 0) goto L64;
        switch(r1) {
            case 2: goto L59;
            case 3: goto L48;
            case 4: goto L36;
            case 5: goto L30;
            case 6: goto L25;
            case 7: goto L20;
            case 8: goto L15;
            case 9: goto L59;
            case 10: goto L10;
            default: goto L9;
        };     // Catch: Throwable -> L69
    L10:
        k0<d.c.c.h.a<d.c.i.l.c>> r2 = k();     // Catch: Throwable -> L69
        if (d.c.i.r.b.d() == false) goto L14;
        d.c.i.r.b.b();
    L14:
        return r2;
    L15:
        k0<d.c.c.h.a<d.c.i.l.c>> r4 = s();     // Catch: Throwable -> L69
        if (d.c.i.r.b.d() == false) goto L19;
        d.c.i.r.b.b();
    L19:
        return r4;
    L20:
        k0<d.c.c.h.a<d.c.i.l.c>> r5 = f();     // Catch: Throwable -> L69
        if (d.c.i.r.b.d() == false) goto L24;
        d.c.i.r.b.b();
    L24:
        return r5;
    L25:
        k0<d.c.c.h.a<d.c.i.l.c>> r6 = n();     // Catch: Throwable -> L69
        if (d.c.i.r.b.d() == false) goto L29;
        d.c.i.r.b.b();
    L29:
        return r6;
    L30:
        k0<d.c.c.h.a<d.c.i.l.c>> r7 = j();     // Catch: Throwable -> L69
        if (d.c.i.r.b.d() == false) goto L34;
        d.c.i.r.b.b();
    L34:
        return r7;
    L59:
        k0<d.c.c.h.a<d.c.i.l.c>> r8 = o();     // Catch: Throwable -> L69
        if (d.c.i.r.b.d() == false) goto L63;
        d.c.i.r.b.b();
    L63:
        return r8;
    L9:
        throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + t(r0));     // Catch: Throwable -> L69
    L36:
        if (d.c.c.f.a.d(this.f16130a.getType(r0)) == false) goto L42;
        k0<d.c.c.h.a<d.c.i.l.c>> r9 = o();     // Catch: Throwable -> L69
        if (d.c.i.r.b.d() == false) goto L41;
        d.c.i.r.b.b();
    L41:
        return r9;
    L42:
        k0<d.c.c.h.a<d.c.i.l.c>> r10 = k();     // Catch: Throwable -> L69
        if (d.c.i.r.b.d() == false) goto L46;
        d.c.i.r.b.b();
    L46:
        return r10;
    L48:
        if (r3.B() == false) goto L54;
        k0<d.c.c.h.a<d.c.i.l.c>> r11 = h();     // Catch: Throwable -> L69
        if (d.c.i.r.b.d() == false) goto L53;
        d.c.i.r.b.b();
    L53:
        return r11;
    L54:
        k0<d.c.c.h.a<d.c.i.l.c>> r12 = m();     // Catch: Throwable -> L69
        if (d.c.i.r.b.d() == false) goto L58;
        d.c.i.r.b.b();
    L58:
        return r12;
    L64:
        k0<d.c.c.h.a<d.c.i.l.c>> r13 = p();     // Catch: Throwable -> L69
        if (d.c.i.r.b.d() == false) goto L68;
        d.c.i.r.b.b();
    L68:
        return r13;
    }

    private synchronized k0<d.c.c.h.a<d.c.i.l.c>> d(k0<d.c.c.h.a<d.c.i.l.c>> r3) {
        monitor-enter(this);
        k0<d.c.c.h.a<d.c.i.l.c>> r0 = this.A.get(r3);     // Catch: Throwable -> L8
        if (r0 != null) goto L6;
        r0 = this.f16131b.f(r3);     // Catch: Throwable -> L8
        this.A.put(r3, r0);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return r0;
    L8:
        th = move-exception;
        throw th;
    }

    private synchronized k0<d.c.i.l.e> e() {
        monitor-enter(this);
    L26:
        th = move-exception;
        throw th;
    L4:
        if (d.c.i.r.b.d() == false) goto L7;
        d.c.i.r.b.a("ProducerSequenceFactory#getCommonNetworkFetchToEncodedMemorySequence");     // Catch: Throwable -> L26
    L7:
        if (this.q != null) goto L21;
        if (d.c.i.r.b.d() == false) goto L11;
        d.c.i.r.b.a("ProducerSequenceFactory#getCommonNetworkFetchToEncodedMemorySequence:init");     // Catch: Throwable -> L26
    L11:
        d.c.i.p.a r0 = l.a(C(this.f16131b.u(this.f16132c)));     // Catch: Throwable -> L26
        this.q = r0;     // Catch: Throwable -> L26
        l r1 = this.f16131b;     // Catch: Throwable -> L26
        if (this.f16133d == true) goto L14;
    L16:
        boolean r2 = false;
    L17:
        this.q = r1.z(r0, r2, this.f16140k);     // Catch: Throwable -> L26
        if (d.c.i.r.b.d() == false) goto L21;
        d.c.i.r.b.b();     // Catch: Throwable -> L26
        goto L21
    L14:
        if (this.f16137h == true) goto L16;
        r2 = true;
    L21:
        if (d.c.i.r.b.d() == false) goto L23;
        d.c.i.r.b.b();     // Catch: Throwable -> L26
    L23:
        k0<d.c.i.l.e> r3 = this.q;     // Catch: Throwable -> L26
        monitor-exit(this);
        return r3;
    }

    private synchronized k0<d.c.c.h.a<d.c.i.l.c>> f() {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.x != null) goto L13;
        k0<d.c.i.l.e> r0 = this.f16131b.h();     // Catch: Throwable -> L16
        if (d.c.c.l.c.f15447a == true) goto L8;
    L12:
        d.c.i.p.a r1 = l.a(r0);     // Catch: Throwable -> L16
        this.x = v(this.f16131b.z(r1, true, this.f16140k));     // Catch: Throwable -> L16
        goto L13
    L8:
        if (this.f16134e == true) goto L10;
    L11:
        r0 = this.f16131b.G(r0);     // Catch: Throwable -> L16
        goto L12
    L10:
        if (d.c.c.l.c.f15449c != null) goto L12;
    L13:
        k0<d.c.c.h.a<d.c.i.l.c>> r2 = this.x;     // Catch: Throwable -> L16
        monitor-exit(this);
        return r2;
    }

    private synchronized k0<d.c.c.h.a<d.c.i.l.c>> h() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.s != null) goto L6;
        this.s = w(this.f16131b.r());     // Catch: Throwable -> L9
    L6:
        k0<d.c.c.h.a<d.c.i.l.c>> r0 = this.s;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    private synchronized k0<d.c.c.h.a<d.c.i.l.c>> j() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.w != null) goto L6;
        this.w = y(this.f16131b.n());     // Catch: Throwable -> L9
    L6:
        k0<d.c.c.h.a<d.c.i.l.c>> r0 = this.w;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    private synchronized k0<d.c.c.h.a<d.c.i.l.c>> k() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.u != null) goto L6;
        this.u = z(this.f16131b.o(), new c1[]{this.f16131b.p(), this.f16131b.q()});     // Catch: Throwable -> L9
    L6:
        k0<d.c.c.h.a<d.c.i.l.c>> r0 = this.u;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    private synchronized k0<Void> l() {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (d.c.i.r.b.d() == false) goto L7;
        d.c.i.r.b.a("ProducerSequenceFactory#getLocalFileFetchToEncodedMemoryPrefetchSequence");     // Catch: Throwable -> L20
    L7:
        if (this.o != null) goto L15;
        if (d.c.i.r.b.d() == false) goto L11;
        d.c.i.r.b.a("ProducerSequenceFactory#getLocalFileFetchToEncodedMemoryPrefetchSequence:init");     // Catch: Throwable -> L20
    L11:
        this.o = l.D(a());     // Catch: Throwable -> L20
        if (d.c.i.r.b.d() == false) goto L15;
        d.c.i.r.b.b();     // Catch: Throwable -> L20
    L15:
        if (d.c.i.r.b.d() == false) goto L17;
        d.c.i.r.b.b();     // Catch: Throwable -> L20
    L17:
        k0<Void> r0 = this.o;     // Catch: Throwable -> L20
        monitor-exit(this);
        return r0;
    }

    private synchronized k0<d.c.c.h.a<d.c.i.l.c>> m() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.r != null) goto L6;
        this.r = y(this.f16131b.r());     // Catch: Throwable -> L9
    L6:
        k0<d.c.c.h.a<d.c.i.l.c>> r0 = this.r;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    private synchronized k0<d.c.c.h.a<d.c.i.l.c>> n() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.v != null) goto L6;
        this.v = y(this.f16131b.s());     // Catch: Throwable -> L9
    L6:
        k0<d.c.c.h.a<d.c.i.l.c>> r0 = this.v;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    private synchronized k0<d.c.c.h.a<d.c.i.l.c>> o() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.t != null) goto L6;
        this.t = u(this.f16131b.t());     // Catch: Throwable -> L9
    L6:
        k0<d.c.c.h.a<d.c.i.l.c>> r0 = this.t;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    private synchronized k0<d.c.c.h.a<d.c.i.l.c>> p() {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (d.c.i.r.b.d() == false) goto L7;
        d.c.i.r.b.a("ProducerSequenceFactory#getNetworkFetchSequence");     // Catch: Throwable -> L20
    L7:
        if (this.f16141l != null) goto L15;
        if (d.c.i.r.b.d() == false) goto L11;
        d.c.i.r.b.a("ProducerSequenceFactory#getNetworkFetchSequence:init");     // Catch: Throwable -> L20
    L11:
        this.f16141l = v(e());     // Catch: Throwable -> L20
        if (d.c.i.r.b.d() == false) goto L15;
        d.c.i.r.b.b();     // Catch: Throwable -> L20
    L15:
        if (d.c.i.r.b.d() == false) goto L17;
        d.c.i.r.b.b();     // Catch: Throwable -> L20
    L17:
        k0<d.c.c.h.a<d.c.i.l.c>> r0 = this.f16141l;     // Catch: Throwable -> L20
        monitor-exit(this);
        return r0;
    }

    private synchronized k0<Void> q() {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (d.c.i.r.b.d() == false) goto L7;
        d.c.i.r.b.a("ProducerSequenceFactory#getNetworkFetchToEncodedMemoryPrefetchSequence");     // Catch: Throwable -> L20
    L7:
        if (this.p != null) goto L15;
        if (d.c.i.r.b.d() == false) goto L11;
        d.c.i.r.b.a("ProducerSequenceFactory#getNetworkFetchToEncodedMemoryPrefetchSequence:init");     // Catch: Throwable -> L20
    L11:
        this.p = l.D(b());     // Catch: Throwable -> L20
        if (d.c.i.r.b.d() == false) goto L15;
        d.c.i.r.b.b();     // Catch: Throwable -> L20
    L15:
        if (d.c.i.r.b.d() == false) goto L17;
        d.c.i.r.b.b();     // Catch: Throwable -> L20
    L17:
        k0<Void> r0 = this.p;     // Catch: Throwable -> L20
        monitor-exit(this);
        return r0;
    }

    private synchronized k0<d.c.c.h.a<d.c.i.l.c>> r(k0<d.c.c.h.a<d.c.i.l.c>> r3) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.z.containsKey(r3) == true) goto L6;
        j0 r0 = this.f16131b.x(r3);     // Catch: Throwable -> L9
        i0 r1 = this.f16131b.w(r0);     // Catch: Throwable -> L9
        this.z.put(r3, r1);     // Catch: Throwable -> L9
    L6:
        k0<d.c.c.h.a<d.c.i.l.c>> r4 = this.z.get(r3);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r4;
    }

    private synchronized k0<d.c.c.h.a<d.c.i.l.c>> s() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.y != null) goto L6;
        this.y = y(this.f16131b.y());     // Catch: Throwable -> L9
    L6:
        k0<d.c.c.h.a<d.c.i.l.c>> r0 = this.y;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    private static String t(Uri r3) {
        String r4 = String.valueOf(r3);
        if (r4.length() > 30) goto L5;
        return r4;
    L5:
        return r4.substring(0, 30) + "...";
    }

    private k0<d.c.c.h.a<d.c.i.l.c>> u(k0<d.c.c.h.a<d.c.i.l.c>> r3) {
        d.c.i.p.h r4 = this.f16131b.e(r3);
        d.c.i.p.g r5 = this.f16131b.d(r4);
        y0 r6 = this.f16131b.b(r5, this.f16136g);
        return this.f16131b.c(r6);
    }

    private k0<d.c.c.h.a<d.c.i.l.c>> v(k0<d.c.i.l.e> r2) {
        if (d.c.i.r.b.d() == false) goto L5;
        d.c.i.r.b.a("ProducerSequenceFactory#newBitmapCacheGetToDecodeSequence");
    L5:
        k0<d.c.c.h.a<d.c.i.l.c>> r1 = u(this.f16131b.i(r2));
        if (d.c.i.r.b.d() == false) goto L8;
        d.c.i.r.b.b();
    L8:
        return r1;
    }

    private k0<d.c.c.h.a<d.c.i.l.c>> w(k0<d.c.i.l.e> r4) {
        return x(r4, new c1[]{this.f16131b.q()});
    }

    private k0<d.c.c.h.a<d.c.i.l.c>> x(k0<d.c.i.l.e> r1, c1<d.c.i.l.e>[] r2) {
        return v(F(C(r1), r2));
    }

    private k0<d.c.c.h.a<d.c.i.l.c>> y(k0<d.c.i.l.e> r4) {
        return z(r4, new c1[]{this.f16131b.q()});
    }

    private k0<d.c.c.h.a<d.c.i.l.c>> z(k0<d.c.i.l.e> r1, c1<d.c.i.l.e>[] r2) {
        return v(E(C(r1), r2));
    }

    public k0<d.c.c.h.a<d.c.i.l.c>> g(d.c.i.q.b r2) {
        if (d.c.i.r.b.d() == false) goto L5;
        d.c.i.r.b.a("ProducerSequenceFactory#getDecodedImageProducerSequence");
    L5:
        k0<d.c.c.h.a<d.c.i.l.c>> r0 = c(r2);
        if (r2.j() == null) goto L9;
        r0 = r(r0);
    L9:
        if (this.f16138i == false) goto L12;
        r0 = d(r0);
    L12:
        if (d.c.i.r.b.d() == false) goto L14;
        d.c.i.r.b.b();
    L14:
        return r0;
    }

    public k0<Void> i(d.c.i.q.b r3) {
        G(r3);
        int r0 = r3.w();
        if (r0 == 0) goto L14;
        if (r0 == 2) goto L12;
        if (r0 == 3) goto L12;
        throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + t(r3.v()));
    L12:
        return l();
    L14:
        return q();
    }
}
