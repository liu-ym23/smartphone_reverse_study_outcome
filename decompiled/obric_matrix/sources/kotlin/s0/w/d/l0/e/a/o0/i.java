package kotlin.s0.w.d.l0.e.a.o0;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f19563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f19564b;

    public i(h r2, boolean r3) {
        kotlin.n0.d.o.f(r2, "qualifier");
        this.f19563a = r2;
        this.f19564b = r3;
    }

    public /* synthetic */ i(h r1, boolean r2, int r3, kotlin.n0.d.g r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        this(r1, r2);
    }

    public static /* synthetic */ i b(i r0, h r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.f19563a;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.f19564b;
    L9:
        return r0.a(r1, r2);
    }

    public final i a(h r1, boolean r2) {
        kotlin.n0.d.o.f(r1, "qualifier");
        return new i(r1, r2);
    }

    public final h c() {
        return this.f19563a;
    }

    public final boolean d() {
        return this.f19564b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
        if (this.f19563a == r6.f19563a) goto L12;
        return false;
    L12:
        if (this.f19564b == r6.f19564b) goto L14;
        return false;
    L14:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    public int hashCode() {
        int r0 = this.f19563a.hashCode() * 31;
        boolean r1 = this.f19564b;
        ?? r2 = r1;
        if (r1 == false) goto L6;
        r2 = 1;
    L6:
        return r0 + r2;
    }

    public String toString() {
        return "NullabilityQualifierWithMigrationStatus(qualifier=" + this.f19563a + ", isForWarningOnly=" + this.f19564b + ')';
    }
}
