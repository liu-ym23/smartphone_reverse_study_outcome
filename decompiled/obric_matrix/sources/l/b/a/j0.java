package l.b.a;

/* JADX INFO: loaded from: classes2.dex */
public class j0 extends w {
    public j0() {
    }

    public j0(e r1) {
        super(r1);
    }

    public j0(f r2) {
        super(r2, false);
    }

    j0(boolean r1, e[] r2) {
        super(r1, r2);
    }

    @Override // l.b.a.t
    void o(r r2, boolean r3) {
        r2.q(r3, 49, this.f21790f);
    }

    @Override // l.b.a.t
    int p() {
        int r0 = this.f21790f.length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L6;
        r2 = r2 + this.f21790f[r1].b().p();
        r1 = r1 + 1;
        goto L3
    L6:
        return (r2 + 2) + 2;
    }
}
