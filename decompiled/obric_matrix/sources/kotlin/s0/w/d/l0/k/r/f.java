package kotlin.s0.w.d.l0.k.r;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.g.b f20563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f20564b;

    public f(kotlin.s0.w.d.l0.g.b r2, int r3) {
        kotlin.n0.d.o.f(r2, "classId");
        this.f20563a = r2;
        this.f20564b = r3;
    }

    public final kotlin.s0.w.d.l0.g.b a() {
        return this.f20563a;
    }

    public final int b() {
        return this.f20564b;
    }

    public final int c() {
        return this.f20564b;
    }

    public final kotlin.s0.w.d.l0.g.b d() {
        return this.f20563a;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (kotlin.n0.d.o.a(this.f20563a, r6.f20563a) == true) goto L12;
        return false;
    L12:
        if (this.f20564b == r6.f20564b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f20563a.hashCode() * 31) + this.f20564b;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        int r1 = this.f20564b;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        r0.append("kotlin/Array<");
        r3 = r3 + 1;
        goto L3
    L5:
        r0.append(this.f20563a);
        int r5 = this.f20564b;
    L6:
        if (r2 >= r5) goto L8;
        r0.append(">");
        r2 = r2 + 1;
        goto L6
    L8:
        String r6 = r0.toString();
        kotlin.n0.d.o.e(r6, "StringBuilder().apply(builderAction).toString()");
        return r6;
    }
}
