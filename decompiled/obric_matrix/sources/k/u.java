package k;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f18303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f18304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f18305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f18306d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f18307e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public u f18308f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public u f18309g;

    static {
    }

    public u() {
        this.f18303a = new byte[8192];
        this.f18307e = true;
        this.f18306d = false;
    }

    public u(byte[] r2, int r3, int r4, boolean r5, boolean r6) {
        kotlin.n0.d.o.g(r2, "data");
        this.f18303a = r2;
        this.f18304b = r3;
        this.f18305c = r4;
        this.f18306d = r5;
        this.f18307e = r6;
    }

    public final void a() {
        u r0 = this.f18309g;
        int r1 = 0;
        if (r0 == this) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L38;
        if (r0 != null) goto L10;
        kotlin.n0.d.o.p();
        throw null;
    L10:
        if (r0.f18307e == true) goto L12;
        return;
    L12:
        int r3 = this.f18305c - this.f18304b;
        if (r0 == null) goto L33;
        int r4 = 8192 - r0.f18305c;
        if (r0 != null) goto L17;
        kotlin.n0.d.o.p();
        throw null;
    L17:
        if (r0.f18306d == true) goto L22;
        if (r0 == null) goto L29;
        r1 = r0.f18304b;
        goto L22
    L29:
        kotlin.n0.d.o.p();
        throw null;
    L22:
        if (r3 <= (r4 + r1)) goto L24;
        return;
    L24:
        if (r0 == null) goto L27;
        g(r0, r3);
        b();
        v.f18312c.a(this);
        return;
    L27:
        kotlin.n0.d.o.p();
        throw null;
    L33:
        kotlin.n0.d.o.p();
        throw null;
    L38:
        throw new IllegalStateException("cannot compact".toString());
    L5:
        r2 = false;
        goto L6
    }

    public final u b() {
        u r0 = this.f18308f;
        if (r0 == this) goto L5;
        u r2 = r0;
    L6:
        u r3 = this.f18309g;
        if (r3 == null) goto L14;
        r3.f18308f = r0;
        u r1 = this.f18308f;
        if (r1 == null) goto L12;
        r1.f18309g = r3;
        this.f18308f = null;
        this.f18309g = null;
        return r2;
    L12:
        kotlin.n0.d.o.p();
        throw null;
    L14:
        kotlin.n0.d.o.p();
        throw null;
    L5:
        r2 = null;
        goto L6
    }

    public final u c(u r2) {
        kotlin.n0.d.o.g(r2, "segment");
        r2.f18309g = this;
        r2.f18308f = this.f18308f;
        u r0 = this.f18308f;
        if (r0 == null) goto L6;
        r0.f18309g = r2;
        this.f18308f = r2;
        return r2;
    L6:
        kotlin.n0.d.o.p();
        throw null;
    }

    public final u d() {
        this.f18306d = true;
        return new u(this.f18303a, this.f18304b, this.f18305c, true, false);
    }

    public final u e(int r9) {
        if (r9 > 0) goto L4;
    L6:
        boolean r0 = false;
    L7:
        if (r0 == false) goto L19;
        if (r9 < 1024) goto L11;
        u r1 = d();
    L12:
        r1.f18305c = r1.f18304b + r9;
        this.f18304b += r9;
        u r8 = this.f18309g;
        if (r8 == null) goto L16;
        r8.c(r1);
        return r1;
    L16:
        kotlin.n0.d.o.p();
        throw null;
    L11:
        r1 = v.f18312c.b();
        byte[] r2 = this.f18303a;
        byte[] r3 = r1.f18303a;
        int r4 = this.f18304b;
        kotlin.i0.i.g(r2, r3, 0, r4, r4 + r9, 2, null);
        goto L12
    L19:
        throw new IllegalArgumentException("byteCount out of range".toString());
    L4:
        if (r9 > (this.f18305c - this.f18304b)) goto L6;
        r0 = true;
        goto L7
    }

    public final u f() {
        byte[] r0 = this.f18303a;
        byte[] r3 = Arrays.copyOf(r0, r0.length);
        kotlin.n0.d.o.b(r3, "java.util.Arrays.copyOf(this, size)");
        return new u(r3, this.f18304b, this.f18305c, false, true);
    }

    public final void g(u r9, int r10) {
        kotlin.n0.d.o.g(r9, "sink");
        if (r9.f18307e == false) goto L18;
        int r5 = r9.f18305c;
        if ((r5 + r10) > 8192) goto L7;
    L15:
        byte[] r0 = this.f18303a;
        byte[] r1 = r9.f18303a;
        int r2 = r9.f18305c;
        int r3 = this.f18304b;
        kotlin.i0.i.e(r0, r1, r2, r3, r3 + r10);
        r9.f18305c += r10;
        this.f18304b += r10;
        return;
    L7:
        if (r9.f18306d == true) goto L14;
        int r4 = r9.f18304b;
        if (((r5 + r10) - r4) > 8192) goto L12;
        byte[] r6 = r9.f18303a;
        kotlin.i0.i.g(r6, r6, 0, r4, r5, 2, null);
        r9.f18305c -= r9.f18304b;
        r9.f18304b = 0;
        goto L15
    L12:
        throw new IllegalArgumentException();
    L14:
        throw new IllegalArgumentException();
    L18:
        throw new IllegalStateException("only owner can write".toString());
    }
}
