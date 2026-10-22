package d.b.s.a.a0.d;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f14641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f14642b;

    public c(long r1, long r3) {
        this.f14641a = r1;
        this.f14642b = r3;
    }

    public final long a() {
        return this.f14641a;
    }

    public final long b() {
        return this.f14642b;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L5;
    L18:
        return true;
    L5:
        if ((r8 instanceof c) == false) goto L17;
        c r9 = (c) r8;
        if (this.f14641a != r9.f14641a) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L17;
        if (this.f14642b != r9.f14642b) goto L14;
        boolean r7 = true;
    L15:
        if (r7 == false) goto L17;
    L14:
        r7 = false;
        goto L15
    L9:
        r1 = false;
    L17:
        return false;
    }

    public int hashCode() {
        long r0 = this.f14641a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.f14642b;
        return r1 + ((int) ((r3 >>> 32) ^ r3));
    }

    public String toString() {
        return d.a(this.f14641a) + "ms (" + d.a(this.f14642b) + "ns)";
    }
}
