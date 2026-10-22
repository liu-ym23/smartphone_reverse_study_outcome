package d.b.q;

/* JADX INFO: loaded from: classes.dex */
public final class b<A, B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final A f14314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final B f14315b;

    private b(A r1, B r2) {
        this.f14314a = r1;
        this.f14315b = r2;
    }

    public static <A, B> b<A, B> b(A r1, B r2) {
        return new b(r1, r2);
    }

    public A a() {
        return this.f14314a;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (b.class == r5.getClass()) goto L11;
        return false;
    L11:
        b r6 = (b) r5;
        A r2 = this.f14314a;
        if (r2 != null) goto L17;
        if (r6.f14314a == null) goto L19;
        return false;
    L19:
        B r4 = this.f14315b;
        if (r4 != null) goto L25;
        if (r6.f14315b == null) goto L27;
        return false;
    L27:
        return true;
    L25:
        if (r4.equals(r6.f14315b) == true) goto L27;
        return false;
    L17:
        if (r2.equals(r6.f14314a) == true) goto L19;
        return false;
    }

    public int hashCode() {
        A r0 = this.f14314a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (r2 + 31) * 31;
        B r4 = this.f14315b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }
}
