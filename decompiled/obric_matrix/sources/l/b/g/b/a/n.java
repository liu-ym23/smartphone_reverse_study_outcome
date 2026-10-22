package l.b.g.b.a;

/* JADX INFO: loaded from: classes2.dex */
class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f22032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f22033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final l.b.b.a f22034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f22035d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f22036e;

    public n(byte[] r1, byte[] r2, l.b.b.a r3) {
        this.f22032a = r1;
        this.f22033b = r2;
        this.f22034c = r3;
    }

    public void a(byte[] r1, boolean r2, int r3) {
        b(r1, r3);
        if (r2 == false) goto L6;
        this.f22036e++;
        return;
    }

    public byte[] b(byte[] r5, int r6) {
        if (r5.length < this.f22034c.f()) goto L7;
        l.b.b.a r0 = this.f22034c;
        byte[] r1 = this.f22032a;
        r0.b(r1, 0, r1.length);
        this.f22034c.c((byte) (this.f22035d >>> 24));
        this.f22034c.c((byte) (this.f22035d >>> 16));
        this.f22034c.c((byte) (this.f22035d >>> 8));
        this.f22034c.c((byte) this.f22035d);
        this.f22034c.c((byte) (this.f22036e >>> 8));
        this.f22034c.c((byte) this.f22036e);
        this.f22034c.c((byte) -1);
        l.b.b.a r2 = this.f22034c;
        byte[] r3 = this.f22033b;
        r2.b(r3, 0, r3.length);
        this.f22034c.a(r5, r6);
        return r5;
    L7:
        throw new IllegalArgumentException("target length is less than digest size.");
    }

    public void c(int r1) {
        this.f22036e = r1;
    }

    public void d(int r1) {
        this.f22035d = r1;
    }
}
