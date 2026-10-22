package l.b.a;

/* JADX INFO: loaded from: classes2.dex */
public class c1 extends u {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f21524g;

    public c1() {
        this.f21524g = -1;
    }

    public c1(f r1) {
        super(r1);
        this.f21524g = -1;
    }

    public c1(e[] r1) {
        super(r1);
        this.f21524g = -1;
    }

    c1(e[] r1, boolean r2) {
        super(r1, r2);
        this.f21524g = -1;
    }

    public static c1 B(u r0) {
        return (c1) r0.u();
    }

    private int C() {
        if (this.f21524g >= 0) goto L9;
        int r0 = this.f21731f.length;
        int r1 = 0;
        int r2 = 0;
    L5:
        if (r1 >= r0) goto L7;
        r2 = r2 + this.f21731f[r1].b().u().p();
        r1 = r1 + 1;
        goto L5
    L7:
        this.f21524g = r2;
    L9:
        return this.f21524g;
    }

    @Override // l.b.a.t
    void o(r r8, boolean r9) {
        if (r9 == false) goto L4;
        r8.f(48);
    L4:
        a1 r10 = r8.d();
        int r0 = this.f21731f.length;
        int r2 = 0;
        if (this.f21524g < 0) goto L7;
    L15:
        r8.r(C());
    L16:
        if (r2 >= r0) goto L22;
        this.f21731f[r2].b().u().o(r10, true);
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
        t r6 = this.f21731f[r4].b().u();
        r1[r4] = r6;
        r5 = r5 + r6.p();
        r4 = r4 + 1;
        goto L10
    L12:
        this.f21524g = r5;
        r8.r(r5);
    L13:
        if (r2 >= r0) goto L18;
        r1[r2].o(r10, true);
        r2 = r2 + 1;
        goto L13
    }

    @Override // l.b.a.t
    int p() {
        int r1 = C();
        return (c2.a(r1) + 1) + r1;
    }

    @Override // l.b.a.u, l.b.a.t
    t u() {
        return this;
    }

    @Override // l.b.a.u, l.b.a.t
    t v() {
        return this;
    }
}
