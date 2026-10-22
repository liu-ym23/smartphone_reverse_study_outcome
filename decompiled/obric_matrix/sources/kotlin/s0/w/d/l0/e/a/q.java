package kotlin.s0.w.d.l0.e.a;

import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.e.a.o0.i f19632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Collection<b> f19633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f19634c;

    /* JADX WARN: Multi-variable type inference failed */
    public q(kotlin.s0.w.d.l0.e.a.o0.i r2, Collection<? extends b> r3, boolean r4) {
        kotlin.n0.d.o.f(r2, "nullabilityQualifier");
        kotlin.n0.d.o.f(r3, "qualifierApplicabilityTypes");
        this.f19632a = r2;
        this.f19633b = r3;
        this.f19634c = r4;
    }

    public /* synthetic */ q(kotlin.s0.w.d.l0.e.a.o0.i r1, Collection r2, boolean r3, int r4, kotlin.n0.d.g r5) {
        if ((r4 & 4) != 0) goto L5;
    L8:
        this(r1, r2, r3);
        return;
    L5:
        if (r1.c() != kotlin.s0.w.d.l0.e.a.o0.h.f19561h) goto L7;
        r3 = true;
        goto L8
    L7:
        r3 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ q b(q r0, kotlin.s0.w.d.l0.e.a.o0.i r1, Collection r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.f19632a;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.f19633b;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.f19634c;
    L12:
        return r0.a(r1, r2, r3);
    }

    public final q a(kotlin.s0.w.d.l0.e.a.o0.i r1, Collection<? extends b> r2, boolean r3) {
        kotlin.n0.d.o.f(r1, "nullabilityQualifier");
        kotlin.n0.d.o.f(r2, "qualifierApplicabilityTypes");
        return new q(r1, r2, r3);
    }

    public final boolean c() {
        return this.f19634c;
    }

    public final kotlin.s0.w.d.l0.e.a.o0.i d() {
        return this.f19632a;
    }

    public final Collection<b> e() {
        return this.f19633b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof q) == true) goto L8;
        return false;
    L8:
        q r6 = (q) r5;
        if (kotlin.n0.d.o.a(this.f19632a, r6.f19632a) == true) goto L12;
        return false;
    L12:
        if (kotlin.n0.d.o.a(this.f19633b, r6.f19633b) == true) goto L15;
        return false;
    L15:
        if (this.f19634c == r6.f19634c) goto L17;
        return false;
    L17:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        int r0 = ((this.f19632a.hashCode() * 31) + this.f19633b.hashCode()) * 31;
        boolean r2 = this.f19634c;
        ?? r3 = r2;
        if (r2 == false) goto L6;
        r3 = 1;
    L6:
        return r0 + r3;
    }

    public String toString() {
        return "JavaDefaultQualifiers(nullabilityQualifier=" + this.f19632a + ", qualifierApplicabilityTypes=" + this.f19633b + ", definitelyNotNull=" + this.f19634c + ')';
    }
}
