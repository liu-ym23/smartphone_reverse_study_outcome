package d.b.s.a.i0;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f14790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f14791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f14792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f14793d;

    public b(long r1, long r3, int r5, int r6) {
        this.f14790a = r1;
        this.f14791b = r3;
        this.f14792c = r5;
        this.f14793d = r6;
    }

    public final long a() {
        return this.f14790a;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L5;
    L28:
        return true;
    L5:
        if ((r8 instanceof b) == false) goto L27;
        b r9 = (b) r8;
        if (this.f14790a != r9.f14790a) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L27;
        if (this.f14791b != r9.f14791b) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == false) goto L27;
        if (this.f14792c != r9.f14792c) goto L19;
        boolean r3 = true;
    L20:
        if (r3 == false) goto L27;
        if (this.f14793d != r9.f14793d) goto L24;
        boolean r7 = true;
    L25:
        if (r7 == false) goto L27;
    L24:
        r7 = false;
        goto L25
    L19:
        r3 = false;
        goto L20
    L14:
        r2 = false;
        goto L15
    L9:
        r1 = false;
    L27:
        return false;
    }

    public int hashCode() {
        long r0 = this.f14790a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.f14791b;
        return ((((r1 + ((int) ((r3 >>> 32) ^ r3))) * 31) + this.f14792c) * 31) + this.f14793d;
    }

    public String toString() {
        return "GetTimeResult(timeMillis=" + this.f14790a + ", serverTimeMillis=" + this.f14791b + ", timeSource=" + this.f14792c + ", flags=" + this.f14793d + ")";
    }
}
