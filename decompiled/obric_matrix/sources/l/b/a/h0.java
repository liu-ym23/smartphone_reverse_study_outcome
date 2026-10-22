package l.b.a;

/* JADX INFO: loaded from: classes2.dex */
public class h0 extends u {
    public h0() {
    }

    public h0(e r1) {
        super(r1);
    }

    public h0(f r1) {
        super(r1);
    }

    @Override // l.b.a.t
    void o(r r2, boolean r3) {
        r2.q(r3, 48, this.f21731f);
    }

    @Override // l.b.a.t
    int p() {
        int r0 = this.f21731f.length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L6;
        r2 = r2 + this.f21731f[r1].b().p();
        r1 = r1 + 1;
        goto L3
    L6:
        return (r2 + 2) + 2;
    }
}
