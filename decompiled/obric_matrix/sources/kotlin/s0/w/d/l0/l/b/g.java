package kotlin.s0.w.d.l0.l.b;

import kotlin.s0.w.d.l0.c.a1;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.f.z.c f20725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.f.c f20726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.f.z.a f20727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a1 f20728d;

    public g(kotlin.s0.w.d.l0.f.z.c r2, kotlin.s0.w.d.l0.f.c r3, kotlin.s0.w.d.l0.f.z.a r4, a1 r5) {
        kotlin.n0.d.o.f(r2, "nameResolver");
        kotlin.n0.d.o.f(r3, "classProto");
        kotlin.n0.d.o.f(r4, "metadataVersion");
        kotlin.n0.d.o.f(r5, "sourceElement");
        this.f20725a = r2;
        this.f20726b = r3;
        this.f20727c = r4;
        this.f20728d = r5;
    }

    public final kotlin.s0.w.d.l0.f.z.c a() {
        return this.f20725a;
    }

    public final kotlin.s0.w.d.l0.f.c b() {
        return this.f20726b;
    }

    public final kotlin.s0.w.d.l0.f.z.a c() {
        return this.f20727c;
    }

    public final a1 d() {
        return this.f20728d;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (kotlin.n0.d.o.a(this.f20725a, r6.f20725a) == true) goto L12;
        return false;
    L12:
        if (kotlin.n0.d.o.a(this.f20726b, r6.f20726b) == true) goto L15;
        return false;
    L15:
        if (kotlin.n0.d.o.a(this.f20727c, r6.f20727c) == true) goto L18;
        return false;
    L18:
        if (kotlin.n0.d.o.a(this.f20728d, r6.f20728d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f20725a.hashCode() * 31) + this.f20726b.hashCode()) * 31) + this.f20727c.hashCode()) * 31) + this.f20728d.hashCode();
    }

    public String toString() {
        return "ClassData(nameResolver=" + this.f20725a + ", classProto=" + this.f20726b + ", metadataVersion=" + this.f20727c + ", sourceElement=" + this.f20728d + ')';
    }
}
