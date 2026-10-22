package l.b.a;

import java.util.Enumeration;

/* JADX INFO: loaded from: classes2.dex */
public class l0 extends a0 {
    public l0(boolean r1, int r2, e r3) {
        super(r1, r2, r3);
    }

    @Override // l.b.a.t
    void o(r r3, boolean r4) {
        r3.v(r4, 160, this.f21509f);
        r3.f(128);
        if (this.f21510g == true) goto L19;
        e r5 = this.f21511h;
        if ((r5 instanceof p) == false) goto L11;
        if ((r5 instanceof f0) == false) goto L9;
        Enumeration r2 = ((f0) r5).C();
    L16:
        r3.h(r2);
    L20:
        r3.f(0);
        r3.f(0);
        return;
    L9:
        r2 = new f0(((p) r5).y()).C();
        goto L16
    L11:
        if ((r5 instanceof u) == false) goto L14;
        r2 = ((u) r5).z();
        goto L16
    L14:
        if ((r5 instanceof w) == false) goto L18;
        r2 = ((w) r5).A();
        goto L16
    L18:
        throw new h("not implemented: " + this.f21511h.getClass().getName());
    L19:
        r3.u(this.f21511h.b(), true);
        goto L20
    }

    @Override // l.b.a.t
    int p() {
        int r0 = this.f21511h.b().p();
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
        if (this.f21511h.b().t() == true) goto L8;
        return false;
    }
}
