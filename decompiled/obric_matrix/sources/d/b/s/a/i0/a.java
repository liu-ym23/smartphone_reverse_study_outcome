package d.b.s.a.i0;

import kotlin.n0.d.g;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f14786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f14787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f14788c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f14789d;

    public a() {
        this(0, 0, 0, 0, 15, null);
    }

    public a(long r1, long r3, long r5, int r7) {
        this.f14786a = r1;
        this.f14787b = r3;
        this.f14788c = r5;
        this.f14789d = r7;
    }

    public /* synthetic */ a(long r3, long r5, long r7, int r9, int r10, g r11) {
        if ((r10 & 1) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r10 & 2) == 0) goto L9;
        r5 = 0;
    L9:
        if ((r10 & 4) == 0) goto L12;
        r7 = 0;
    L12:
        if ((r10 & 8) == 0) goto L14;
        r9 = -1;
    L14:
        this(r3, r5, r7, r9);
    }

    public final long a() {
        return this.f14788c;
    }

    public final long b() {
        return this.f14786a;
    }

    public final int c() {
        return this.f14789d;
    }

    public final long d() {
        return this.f14787b;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L5;
    L28:
        return true;
    L5:
        if ((r8 instanceof a) == false) goto L27;
        a r9 = (a) r8;
        if (this.f14786a != r9.f14786a) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L27;
        if (this.f14787b != r9.f14787b) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == false) goto L27;
        if (this.f14788c != r9.f14788c) goto L19;
        boolean r3 = true;
    L20:
        if (r3 == false) goto L27;
        if (this.f14789d != r9.f14789d) goto L24;
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
        long r0 = this.f14786a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.f14787b;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r4 = this.f14788c;
        return ((r2 + ((int) ((r4 >>> 32) ^ r4))) * 31) + this.f14789d;
    }

    public String toString() {
        return "CalibrationRecord(serverTimeMillis=" + this.f14786a + ", systemTimeMillis=" + this.f14787b + ", elapsedRealTimeMillis=" + this.f14788c + ", systemBootTimes=" + this.f14789d + ")";
    }
}
