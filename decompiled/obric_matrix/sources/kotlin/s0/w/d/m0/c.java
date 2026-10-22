package kotlin.s0.w.d.m0;

/* JADX INFO: loaded from: classes2.dex */
final class c<V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final c<Object> f21305f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f21306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final V f21307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c<V> f21308c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c<V> f21309d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f21310e;

    static {
        f21305f = new c();
    }

    private c() {
        this.f21310e = 0;
        this.f21306a = 0;
        this.f21307b = null;
        this.f21308c = null;
        this.f21309d = null;
    }

    private c(long r1, V r3, c<V> r4, c<V> r5) {
        this.f21306a = r1;
        this.f21307b = r3;
        this.f21308c = r4;
        this.f21309d = r5;
        this.f21310e = (r4.f21310e + 1) + r5.f21310e;
    }

    private static <V> c<V> c(long r17, V r19, c<V> r20, c<V> r21) {
        int r0 = ((c) r20).f21310e;
        int r1 = ((c) r21).f21310e;
        if ((r0 + r1) <= 1) goto L21;
        if (r0 < (r1 * 5)) goto L13;
        c<V> r11 = ((c) r20).f21308c;
        c<V> r2 = ((c) r20).f21309d;
        if (((c) r2).f21310e >= (((c) r11).f21310e * 2)) goto L10;
        long r3 = ((c) r20).f21306a;
        return new c(r3 + r17, ((c) r20).f21307b, r11, new c(-r3, r19, r2.e(((c) r2).f21306a + r3), r21));
    L10:
        c<V> r4 = ((c) r2).f21308c;
        c<V> r5 = ((c) r2).f21309d;
        long r7 = ((c) r2).f21306a;
        long r14 = (((c) r20).f21306a + r7) + r17;
        V r6 = ((c) r2).f21307b;
        c r16 = new c(-r7, ((c) r20).f21307b, r11, r4.e(((c) r4).f21306a + r7));
        long r8 = ((c) r20).f21306a;
        long r9 = ((c) r2).f21306a;
        return new c(r14, r6, r16, new c((-r8) - r9, r19, r5.e((((c) r5).f21306a + r9) + r8), r21));
    L13:
        if (r1 < (r0 * 5)) goto L21;
        c<V> r10 = ((c) r21).f21308c;
        c<V> r12 = ((c) r21).f21309d;
        if (((c) r10).f21310e >= (((c) r12).f21310e * 2)) goto L18;
        long r13 = ((c) r21).f21306a;
        return new c(r13 + r17, ((c) r21).f21307b, new c(-r13, r19, r20, r10.e(((c) r10).f21306a + r13)), r12);
    L18:
        c<V> r15 = ((c) r10).f21308c;
        c<V> r18 = ((c) r10).f21309d;
        long r22 = ((c) r10).f21306a;
        long r110 = ((c) r21).f21306a;
        long r111 = (r22 + r110) + r17;
        V r112 = ((c) r10).f21307b;
        c r113 = new c((-r110) - r22, r19, r20, r15.e((((c) r15).f21306a + r22) + r110));
        long r23 = ((c) r10).f21306a;
        return new c(r111, r112, r113, new c(-r23, ((c) r21).f21307b, r18.e(((c) r18).f21306a + r23), r12));
    L21:
        return new c(r17, r19, r20, r21);
    }

    private c<V> d(c<V> r3, c<V> r4) {
        if (r3 != this.f21308c) goto L8;
        if (r4 != this.f21309d) goto L8;
        return this;
    L8:
        return c(this.f21306a, this.f21307b, r3, r4);
    }

    private c<V> e(long r8) {
        if (this.f21310e != 0) goto L5;
    L9:
        return this;
    L5:
        if (r8 == this.f21306a) goto L9;
        return new c(r8, this.f21307b, this.f21308c, this.f21309d);
    }

    V a(long r4) {
        if (this.f21310e != 0) goto L6;
        return null;
    L6:
        long r0 = this.f21306a;
        if (r4 >= r0) goto L12;
        c<V> r3 = this.f21308c;
    L10:
        return r3.a(r4 - r0);
    L12:
        if (r4 <= r0) goto L15;
        r3 = this.f21309d;
        goto L10
    L15:
        return this.f21307b;
    }

    c<V> b(long r8, V r10) {
        if (this.f21310e == 0) goto L5;
        long r0 = this.f21306a;
        if (r8 >= r0) goto L11;
        return d(this.f21308c.b(r8 - r0, r10), this.f21309d);
    L11:
        if (r8 <= r0) goto L15;
        return d(this.f21308c, this.f21309d.b(r8 - r0, r10));
    L15:
        if (r10 != this.f21307b) goto L18;
        return this;
    L18:
        return new c(r8, r10, this.f21308c, this.f21309d);
    L5:
        return new c(r8, r10, this, this);
    }
}
