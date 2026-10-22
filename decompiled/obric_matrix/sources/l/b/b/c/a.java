package l.b.b.c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements l.b.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f21820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f21821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f21822c;

    protected a() {
        this.f21820a = new byte[4];
        this.f21821b = 0;
    }

    @Override // l.b.b.a
    public void b(byte[] r7, int r8, int r9) {
        int r0 = 0;
        int r10 = Math.max(0, r9);
        if (this.f21821b == 0) goto L11;
        int r1 = 0;
    L5:
        if (r1 >= r10) goto L10;
        byte[] r2 = this.f21820a;
        int r3 = this.f21821b;
        int r4 = r3 + 1;
        this.f21821b = r4;
        int r5 = r1 + 1;
        r2[r3] = r7[r1 + r8];
        if (r4 == 4) goto L8;
        r1 = r5;
        goto L5
    L8:
        j(r2, 0);
        this.f21821b = 0;
        r0 = r5;
        goto L11
    L10:
        r0 = r1;
    L11:
        int r6 = ((r10 - r0) & (-4)) + r0;
    L12:
        if (r0 >= r6) goto L14;
        j(r7, r8 + r0);
        r0 = r0 + 4;
    L14:
        if (r0 >= r10) goto L16;
        byte[] r11 = this.f21820a;
        int r12 = this.f21821b;
        this.f21821b = r12 + 1;
        r11[r12] = r7[r0 + r8];
        r0 = r0 + 1;
        goto L14
    L16:
        this.f21822c += (long) r10;
    }

    @Override // l.b.b.a
    public void c(byte r5) {
        byte[] r0 = this.f21820a;
        int r1 = this.f21821b;
        int r2 = r1 + 1;
        this.f21821b = r2;
        r0[r1] = r5;
        if (r2 != r0.length) goto L5;
        j(r0, 0);
        this.f21821b = 0;
    L5:
        this.f21822c++;
    }

    public void g() {
        long r0 = this.f21822c << 3;
        byte r2 = -128;
    L3:
        c(r2);
        if (this.f21821b == 0) goto L6;
        r2 = 0;
        goto L3
    L6:
        i(r0);
        h();
    }

    protected abstract void h();

    protected abstract void i(long r1);

    protected abstract void j(byte[] r1, int r2);

    public void k() {
        this.f21822c = 0;
        this.f21821b = 0;
        int r1 = 0;
    L3:
        byte[] r2 = this.f21820a;
        if (r1 >= r2.length) goto L6;
        r2[r1] = 0;
        r1 = r1 + 1;
        goto L3
    }
}
