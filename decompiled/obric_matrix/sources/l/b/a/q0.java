package l.b.a;

import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class q0 extends i {
    public q0(o r1, l r2, t r3, int r4, t r5) {
        super(r1, r2, r3, r4, r5);
    }

    @Override // l.b.a.t
    void o(r r6, boolean r7) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        o r1 = this.f21593f;
        if (r1 == null) goto L5;
        r0.write(r1.m("DER"));
    L5:
        l r2 = this.f21594g;
        if (r2 == null) goto L8;
        r0.write(r2.m("DER"));
    L8:
        t r3 = this.f21595h;
        if (r3 == null) goto L11;
        r0.write(r3.m("DER"));
    L11:
        r0.write(new f1(true, this.f21596i, this.f21597j).m("DER"));
        r6.m(r7, 32, 8, r0.toByteArray());
    }

    @Override // l.b.a.i, l.b.a.t
    int p() {
        return getEncoded().length;
    }

    @Override // l.b.a.i, l.b.a.t
    t u() {
        return this;
    }

    @Override // l.b.a.i, l.b.a.t
    t v() {
        return this;
    }
}
