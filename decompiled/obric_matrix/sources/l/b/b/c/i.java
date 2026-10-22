package l.b.b.c;

/* JADX INFO: loaded from: classes2.dex */
public class i extends b implements l.b.b.b {
    public i(int r1) {
        s(r1);
        super(r1);
    }

    private static int s(int r3) {
        if (r3 != 128) goto L5;
    L9:
        return r3;
    L5:
        if (r3 == 256) goto L9;
        throw new IllegalArgumentException("'bitLength' " + r3 + " not supported for SHAKE");
    }

    @Override // l.b.b.a
    public int a(byte[] r2, int r3) {
        int r0 = f();
        d(r2, r3, r0);
        return r0;
    }

    @Override // l.b.b.b
    public int d(byte[] r1, int r2, int r3) {
        t(r1, r2, r3);
        q();
        return r3;
    }

    @Override // l.b.b.a
    public String e() {
        return "SHAKE" + this.f21828e;
    }

    public int t(byte[] r5, int r6, int r7) {
        if (this.f21829f == true) goto L5;
        l(15, 4);
    L5:
        r(r5, r6, ((long) r7) * 8);
        return r7;
    }
}
