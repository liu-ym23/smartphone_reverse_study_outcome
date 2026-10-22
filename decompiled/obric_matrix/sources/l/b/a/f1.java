package l.b.a;

/* JADX INFO: loaded from: classes2.dex */
public class f1 extends a0 {
    public f1(boolean r1, int r2, e r3) {
        super(r1, r2, r3);
    }

    @Override // l.b.a.t
    void o(r r4, boolean r5) {
        t r0 = this.f21511h.b().u();
        if (this.f21510g == false) goto L5;
    L8:
        int r1 = 160;
    L9:
        r4.v(r5, r1, this.f21509f);
        if (this.f21510g == false) goto L12;
        r4.r(r0.p());
    L12:
        r0.o(r4.d(), this.f21510g);
        return;
    L5:
        if (r0.t() == true) goto L8;
        r1 = 128;
        goto L9
    }

    @Override // l.b.a.t
    int p() {
        int r0 = this.f21511h.b().u().p();
        if (this.f21510g == false) goto L7;
        int r2 = c2.b(this.f21509f) + c2.a(r0);
    L6:
        return r2 + r0;
    L7:
        r0 = r0 - 1;
        r2 = c2.b(this.f21509f);
        goto L6
    }

    @Override // l.b.a.t
    boolean t() {
        if (this.f21510g == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f21511h.b().u().t() == true) goto L8;
        return false;
    }

    @Override // l.b.a.a0, l.b.a.t
    t u() {
        return this;
    }

    @Override // l.b.a.a0, l.b.a.t
    t v() {
        return this;
    }
}
