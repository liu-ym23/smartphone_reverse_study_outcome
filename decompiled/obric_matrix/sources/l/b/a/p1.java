package l.b.a;

/* JADX INFO: loaded from: classes2.dex */
public class p1 extends u {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f21660g;

    public p1() {
        this.f21660g = -1;
    }

    public p1(e r1) {
        super(r1);
        this.f21660g = -1;
    }

    public p1(f r1) {
        super(r1);
        this.f21660g = -1;
    }

    p1(e[] r1, boolean r2) {
        super(r1, r2);
        this.f21660g = -1;
    }

    private int B() {
        if (this.f21660g >= 0) goto L9;
        int r0 = this.f21731f.length;
        int r1 = 0;
        int r2 = 0;
    L5:
        if (r1 >= r0) goto L7;
        r2 = r2 + this.f21731f[r1].b().v().p();
        r1 = r1 + 1;
        goto L5
    L7:
        this.f21660g = r2;
    L9:
        return this.f21660g;
    }

    @Override // l.b.a.t
    void o(r r8, boolean r9) {
        if (r9 == false) goto L4;
        r8.f(48);
    L4:
        r r10 = r8.e();
        int r0 = this.f21731f.length;
        int r2 = 0;
        if (this.f21660g < 0) goto L7;
    L15:
        r8.r(B());
    L16:
        if (r2 >= r0) goto L22;
        r10.u(this.f21731f[r2].b(), true);
        r2 = r2 + 1;
        goto L16
    L22:
        return;
    L7:
        if (r0 > 16) goto L15;
        t[] r1 = new t[r0];
        int r4 = 0;
        int r5 = 0;
    L10:
        if (r4 >= r0) goto L12;
        t r6 = this.f21731f[r4].b().v();
        r1[r4] = r6;
        r5 = r5 + r6.p();
        r4 = r4 + 1;
        goto L10
    L12:
        this.f21660g = r5;
        r8.r(r5);
    L13:
        if (r2 >= r0) goto L18;
        r10.u(r1[r2], true);
        r2 = r2 + 1;
        goto L13
    }

    @Override // l.b.a.t
    int p() {
        int r1 = B();
        return (c2.a(r1) + 1) + r1;
    }

    @Override // l.b.a.u, l.b.a.t
    t v() {
        return this;
    }
}
