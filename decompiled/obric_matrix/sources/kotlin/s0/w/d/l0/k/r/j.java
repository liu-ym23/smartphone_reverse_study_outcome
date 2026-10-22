package kotlin.s0.w.d.l0.k.r;

import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.m0;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends g<kotlin.u<? extends kotlin.s0.w.d.l0.g.b, ? extends kotlin.s0.w.d.l0.g.f>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.g.b f20569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.g.f f20570c;

    public j(kotlin.s0.w.d.l0.g.b r2, kotlin.s0.w.d.l0.g.f r3) {
        kotlin.n0.d.o.f(r2, "enumClassId");
        kotlin.n0.d.o.f(r3, "enumEntryName");
        super(kotlin.a0.a(r2, r3));
        this.f20569b = r2;
        this.f20570c = r3;
    }

    @Override // kotlin.s0.w.d.l0.k.r.g
    public e0 a(h0 r5) {
        kotlin.n0.d.o.f(r5, "module");
        kotlin.s0.w.d.l0.c.e r6 = kotlin.s0.w.d.l0.c.x.a(r5, this.f20569b);
        m0 r0 = null;
        if (r6 != null) goto L5;
    L10:
        if (r0 != null) goto L13;
        kotlin.s0.w.d.l0.n.u1.j r7 = kotlin.s0.w.d.l0.n.u1.j.D0;
        String r2 = this.f20569b.toString();
        kotlin.n0.d.o.e(r2, "enumClassId.toString()");
        String r4 = this.f20570c.toString();
        kotlin.n0.d.o.e(r4, "enumEntryName.toString()");
        return kotlin.s0.w.d.l0.n.u1.k.d(r7, new String[]{r2, r4});
    L13:
        return r0;
    L5:
        if (kotlin.s0.w.d.l0.k.d.A(r6) == true) goto L8;
        r6 = null;
    L8:
        if (r6 == null) goto L10;
        r0 = r6.s();
        goto L10
    }

    public final kotlin.s0.w.d.l0.g.f c() {
        return this.f20570c;
    }

    @Override // kotlin.s0.w.d.l0.k.r.g
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.f20569b.j());
        r0.append('.');
        r0.append(this.f20570c);
        return r0.toString();
    }
}
