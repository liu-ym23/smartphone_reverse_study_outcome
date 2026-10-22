package l.b.g.a;

import l.b.a.a0;
import l.b.a.c1;
import l.b.a.f1;
import l.b.a.p;
import l.b.a.t;
import l.b.a.u;
import l.b.a.y0;

/* JADX INFO: loaded from: classes2.dex */
public class k extends l.b.a.n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f21963f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f21964g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f21965h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final byte[] f21966i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final byte[] f21967j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final byte[] f21968k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final byte[] f21969l;
    private final byte[] m;

    public k(long r2, byte[] r4, byte[] r5, byte[] r6, byte[] r7, byte[] r8) {
        this.f21963f = 0;
        this.f21964g = r2;
        this.f21966i = l.b.h.a.d(r4);
        this.f21967j = l.b.h.a.d(r5);
        this.f21968k = l.b.h.a.d(r6);
        this.f21969l = l.b.h.a.d(r7);
        this.m = l.b.h.a.d(r8);
        this.f21965h = -1;
    }

    public k(long r2, byte[] r4, byte[] r5, byte[] r6, byte[] r7, byte[] r8, long r9) {
        this.f21963f = 1;
        this.f21964g = r2;
        this.f21966i = l.b.h.a.d(r4);
        this.f21967j = l.b.h.a.d(r5);
        this.f21968k = l.b.h.a.d(r6);
        this.f21969l = l.b.h.a.d(r7);
        this.m = l.b.h.a.d(r8);
        this.f21965h = r9;
    }

    private k(u r9) {
        l.b.a.l r1 = l.b.a.l.w(r9.y(0));
        if (r1.z(l.b.h.b.f22285a) == false) goto L5;
    L9:
        this.f21963f = r1.B();
        if (r9.size() != 2) goto L12;
    L16:
        u r4 = u.w(r9.y(1));
        this.f21964g = l.b.a.l.w(r4.y(0)).E();
        this.f21966i = l.b.h.a.d(p.w(r4.y(1)).y());
        this.f21967j = l.b.h.a.d(p.w(r4.y(2)).y());
        this.f21968k = l.b.h.a.d(p.w(r4.y(3)).y());
        this.f21969l = l.b.h.a.d(p.w(r4.y(4)).y());
        if (r4.size() != 6) goto L24;
        a0 r5 = a0.w(r4.y(5));
        if (r5.y() != 0) goto L22;
        long r6 = l.b.a.l.x(r5, false).E();
    L26:
        this.f21965h = r6;
        if (r9.size() != 3) goto L29;
        this.m = l.b.h.a.d(p.x(a0.w(r9.y(2)), true).y());
        return;
    L29:
        this.m = null;
        return;
    L22:
        throw new IllegalArgumentException("unknown tag in XMSSPrivateKey");
    L24:
        if (r4.size() != 5) goto L32;
        r6 = -1;
        goto L26
    L32:
        throw new IllegalArgumentException("keySeq should be 5 or 6 in length");
    L12:
        if (r9.size() == 3) goto L16;
        throw new IllegalArgumentException("key sequence wrong size");
    L5:
        if (r1.z(l.b.h.b.f22286b) == true) goto L9;
        throw new IllegalArgumentException("unknown version of sequence");
    }

    public static k p(Object r1) {
        if ((r1 instanceof k) == true) goto L5;
        if (r1 != null) goto L8;
        return null;
    L8:
        return new k(u.w(r1));
    L5:
        return (k) r1;
    }

    @Override // l.b.a.n, l.b.a.e
    public t b() {
        l.b.a.f r0 = new l.b.a.f();
        if (this.f21965h < 0) goto L5;
        l.b.a.l r1 = new l.b.a.l(1);
    L6:
        r0.a(r1);
        l.b.a.f r2 = new l.b.a.f();
        r2.a(new l.b.a.l(this.f21964g));
        r2.a(new y0(this.f21966i));
        r2.a(new y0(this.f21967j));
        r2.a(new y0(this.f21968k));
        r2.a(new y0(this.f21969l));
        long r5 = this.f21965h;
        if (r5 < 0) goto L9;
        r2.a(new f1(false, 0, new l.b.a.l(r5)));
    L9:
        r0.a(new c1(r2));
        r0.a(new f1(true, 0, new y0(this.m)));
        return new c1(r0);
    L5:
        r1 = new l.b.a.l(0);
        goto L6
    }

    public byte[] n() {
        return l.b.h.a.d(this.m);
    }

    public long o() {
        return this.f21964g;
    }

    public long q() {
        return this.f21965h;
    }

    public byte[] r() {
        return l.b.h.a.d(this.f21968k);
    }

    public byte[] s() {
        return l.b.h.a.d(this.f21969l);
    }

    public byte[] t() {
        return l.b.h.a.d(this.f21967j);
    }

    public byte[] u() {
        return l.b.h.a.d(this.f21966i);
    }

    public int v() {
        return this.f21963f;
    }
}
