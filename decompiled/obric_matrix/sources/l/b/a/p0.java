package l.b.a;

/* JADX INFO: loaded from: classes2.dex */
public class p0 extends b {
    public p0(e r2) {
        super(r2.b().m("DER"), 0);
    }

    public p0(byte[] r2) {
        this(r2, 0);
    }

    public p0(byte[] r1, int r2) {
        super(r1, r2);
    }

    public static p0 A(Object r3) {
        if (r3 == null) goto L20;
        if ((r3 instanceof p0) == true) goto L20;
        if ((r3 instanceof l1) == false) goto L11;
        l1 r4 = (l1) r3;
        return new p0(r4.f21515f, r4.f21516g);
    L11:
        if ((r3 instanceof byte[]) == false) goto L18;
        return (p0) t.s((byte[]) r3);
    L14:
        e = move-exception;
        throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
    L18:
        throw new IllegalArgumentException("illegal object in getInstance: " + r3.getClass().getName());
    L20:
        return (p0) r3;
    }

    public static p0 B(a0 r0, boolean r1) {
        t r2 = r0.x();
        if (r1 == true) goto L10;
        if ((r2 instanceof p0) == true) goto L10;
        return z(p.w(r2).y());
    L10:
        return A(r2);
    }

    static p0 z(byte[] r5) {
        if (r5.length < 1) goto L10;
        byte r2 = r5[0];
        int r3 = r5.length - 1;
        byte[] r4 = new byte[r3];
        if (r3 == 0) goto L8;
        System.arraycopy(r5, 1, r4, 0, r5.length - 1);
    L8:
        return new p0(r4, r2);
    L10:
        throw new IllegalArgumentException("truncated BIT STRING detected");
    }

    @Override // l.b.a.t
    void o(r r9, boolean r10) {
        byte[] r4 = this.f21515f;
        int r0 = r4.length;
        if (r0 == 0) goto L10;
        int r1 = this.f21516g;
        if (r1 == 0) goto L10;
        int r6 = r0 - 1;
        if (r4[r6] == ((byte) (r4[r6] & (255 << r1)))) goto L10;
        r9.l(r10, 3, (byte) r1, r4, 0, r6, (byte) (r4[r6] & (255 << r1)));
        return;
    L10:
        r9.k(r10, 3, (byte) this.f21516g, r4);
    }

    @Override // l.b.a.t
    int p() {
        return ((c2.a(this.f21515f.length + 1) + 1) + this.f21515f.length) + 1;
    }

    @Override // l.b.a.t
    boolean t() {
        return false;
    }

    @Override // l.b.a.b, l.b.a.t
    t u() {
        return this;
    }

    @Override // l.b.a.b, l.b.a.t
    t v() {
        return this;
    }
}
