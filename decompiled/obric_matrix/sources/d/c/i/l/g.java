package d.c.i.l;

/* JADX INFO: loaded from: classes2.dex */
public class g implements i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final i f16188d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f16189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f16190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f16191c;

    static {
        f16188d = d(Integer.MAX_VALUE, true, true);
    }

    private g(int r1, boolean r2, boolean r3) {
        this.f16189a = r1;
        this.f16190b = r2;
        this.f16191c = r3;
    }

    public static i d(int r1, boolean r2, boolean r3) {
        return new g(r1, r2, r3);
    }

    @Override // d.c.i.l.i
    public boolean a() {
        return this.f16191c;
    }

    @Override // d.c.i.l.i
    public boolean b() {
        return this.f16190b;
    }

    @Override // d.c.i.l.i
    public int c() {
        return this.f16189a;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (this.f16189a != r6.f16189a) goto L16;
        if (this.f16190b != r6.f16190b) goto L16;
        if (this.f16191c != r6.f16191c) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.f16189a;
        int r2 = 0;
        if (this.f16190b == false) goto L5;
        int r1 = 4194304;
    L6:
        int r3 = r0 ^ r1;
        if (this.f16191c == false) goto L10;
        r2 = 8388608;
    L10:
        return r3 ^ r2;
    L5:
        r1 = 0;
        goto L6
    }
}
