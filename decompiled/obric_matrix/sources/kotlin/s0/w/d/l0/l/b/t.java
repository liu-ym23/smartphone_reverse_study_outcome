package kotlin.s0.w.d.l0.l.b;

/* JADX INFO: loaded from: classes2.dex */
public final class t<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f20860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f20861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f20862c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.g.b f20863d;

    public t(T r2, T r3, String r4, kotlin.s0.w.d.l0.g.b r5) {
        kotlin.n0.d.o.f(r4, "filePath");
        kotlin.n0.d.o.f(r5, "classId");
        this.f20860a = r2;
        this.f20861b = r3;
        this.f20862c = r4;
        this.f20863d = r5;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof t) == true) goto L8;
        return false;
    L8:
        t r6 = (t) r5;
        if (kotlin.n0.d.o.a(this.f20860a, r6.f20860a) == true) goto L12;
        return false;
    L12:
        if (kotlin.n0.d.o.a(this.f20861b, r6.f20861b) == true) goto L15;
        return false;
    L15:
        if (kotlin.n0.d.o.a(this.f20862c, r6.f20862c) == true) goto L18;
        return false;
    L18:
        if (kotlin.n0.d.o.a(this.f20863d, r6.f20863d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        T r0 = this.f20860a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        T r4 = this.f20861b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((((r3 + r1) * 31) + this.f20862c.hashCode()) * 31) + this.f20863d.hashCode();
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "IncompatibleVersionErrorData(actualVersion=" + this.f20860a + ", expectedVersion=" + this.f20861b + ", filePath=" + this.f20862c + ", classId=" + this.f20863d + ')';
    }
}
