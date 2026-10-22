package l.b.a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i extends t {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected o f21593f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected l f21594g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected t f21595h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected int f21596i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected t f21597j;

    public i(f r5) {
        int r0 = 0;
        t r1 = w(r5, 0);
        if ((r1 instanceof o) == false) goto L6;
        this.f21593f = (o) r1;
        r1 = w(r5, 1);
        r0 = 1;
    L6:
        if ((r1 instanceof l) == false) goto L9;
        this.f21594g = (l) r1;
        r0 = r0 + 1;
        r1 = w(r5, r0);
    L9:
        if ((r1 instanceof a0) == true) goto L12;
        this.f21595h = r1;
        r0 = r0 + 1;
        r1 = w(r5, r0);
    L12:
        if (r5.f() != (r0 + 1)) goto L20;
        if ((r1 instanceof a0) == false) goto L18;
        a0 r2 = (a0) r1;
        z(r2.y());
        this.f21597j = r2.x();
        return;
    L18:
        throw new IllegalArgumentException("No tagged object found in vector. Structure doesn't seem to be of type External");
    L20:
        throw new IllegalArgumentException("input vector too large");
    }

    public i(o r1, l r2, t r3, int r4, t r5) {
        y(r1);
        B(r2);
        x(r3);
        z(r4);
        r5.b();
        A(r5);
    }

    private void A(t r1) {
        this.f21597j = r1;
    }

    private void B(l r1) {
        this.f21594g = r1;
    }

    private t w(f r1, int r2) {
        if (r1.f() <= r2) goto L7;
        return r1.d(r2).b();
    L7:
        throw new IllegalArgumentException("too few objects in input vector");
    }

    private void x(t r1) {
        this.f21595h = r1;
    }

    private void y(o r1) {
        this.f21593f = r1;
    }

    private void z(int r3) {
        if (r3 < 0) goto L8;
        if (r3 > 2) goto L8;
        this.f21596i = r3;
        return;
    L8:
        throw new IllegalArgumentException("invalid encoding value: " + r3);
    }

    @Override // l.b.a.n
    public int hashCode() {
        o r0 = this.f21593f;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        l r2 = this.f21594g;
        if (r2 == null) goto L9;
        r1 = r1 ^ r2.hashCode();
    L9:
        t r3 = this.f21595h;
        if (r3 == null) goto L13;
        r1 = r1 ^ r3.hashCode();
    L13:
        return this.f21597j.hashCode() ^ r1;
    L5:
        r1 = 0;
        goto L6
    }

    @Override // l.b.a.t
    boolean n(t r4) {
        if ((r4 instanceof i) == true) goto L5;
        return false;
    L5:
        if (this != r4) goto L8;
        return true;
    L8:
        i r5 = (i) r4;
        o r0 = this.f21593f;
        if (r0 == null) goto L15;
        o r2 = r5.f21593f;
        if (r2 != null) goto L13;
    L14:
        return false;
    L13:
        if (r2.r(r0) == false) goto L14;
    L15:
        l r1 = this.f21594g;
        if (r1 == null) goto L22;
        l r3 = r5.f21594g;
        if (r3 != null) goto L20;
    L21:
        return false;
    L20:
        if (r3.r(r1) == false) goto L21;
    L22:
        t r6 = this.f21595h;
        if (r6 == null) goto L30;
        t r7 = r5.f21595h;
        if (r7 != null) goto L27;
    L28:
        return false;
    L27:
        if (r7.r(r6) == false) goto L28;
    L30:
        return this.f21597j.r(r5.f21597j);
    }

    @Override // l.b.a.t
    int p() {
        return getEncoded().length;
    }

    @Override // l.b.a.t
    boolean t() {
        return true;
    }

    @Override // l.b.a.t
    t u() {
        return new q0(this.f21593f, this.f21594g, this.f21595h, this.f21596i, this.f21597j);
    }

    @Override // l.b.a.t
    t v() {
        return new m1(this.f21593f, this.f21594g, this.f21595h, this.f21596i, this.f21597j);
    }
}
