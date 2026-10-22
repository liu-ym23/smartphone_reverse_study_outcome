package l.b.a;

/* JADX INFO: loaded from: classes2.dex */
public class t0 extends j {
    public t0(byte[] r1) {
        super(r1);
    }

    private byte[] G() {
        byte[] r0 = this.f21605f;
        if (r0[r0.length - 1] == 90) goto L5;
        return r0;
    L5:
        if (C() == true) goto L9;
        byte[] r1 = this.f21605f;
        byte[] r2 = new byte[r1.length + 4];
        System.arraycopy(r1, 0, r2, 0, r1.length - 1);
        System.arraycopy(l.b.h.g.e("0000Z"), 0, r2, this.f21605f.length - 1, 5);
        return r2;
    L9:
        if (D() == true) goto L13;
        byte[] r3 = this.f21605f;
        byte[] r4 = new byte[r3.length + 2];
        System.arraycopy(r3, 0, r4, 0, r3.length - 1);
        System.arraycopy(l.b.h.g.e("00Z"), 0, r4, this.f21605f.length - 1, 3);
        return r4;
    L13:
        if (B() == false) goto L26;
        int r5 = this.f21605f.length - 2;
    L15:
        if (r5 <= 0) goto L19;
        if (this.f21605f[r5] != 48) goto L19;
        r5 = r5 - 1;
    L19:
        byte[] r6 = this.f21605f;
        if (r6[r5] != 46) goto L23;
        byte[] r7 = new byte[r5 + 1];
        System.arraycopy(r6, 0, r7, 0, r5);
        r7[r5] = 90;
        return r7;
    L23:
        byte[] r8 = new byte[r5 + 2];
        int r9 = r5 + 1;
        System.arraycopy(r6, 0, r8, 0, r9);
        r8[r9] = 90;
        return r8;
    L26:
        return this.f21605f;
    }

    @Override // l.b.a.j, l.b.a.t
    void o(r r2, boolean r3) {
        r2.n(r3, 24, G());
    }

    @Override // l.b.a.j, l.b.a.t
    int p() {
        int r1 = G().length;
        return (c2.a(r1) + 1) + r1;
    }

    @Override // l.b.a.j, l.b.a.t
    t u() {
        return this;
    }

    @Override // l.b.a.j, l.b.a.t
    t v() {
        return this;
    }
}
