package kotlin.s0.w.d.l0.e.a;

import kotlin.s0.w.d.l0.c.u0;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements kotlin.s0.w.d.l0.k.e {
    public n() {
    }

    @Override // kotlin.s0.w.d.l0.k.e
    public kotlin.s0.w.d.l0.k.e.a a() {
        return kotlin.s0.w.d.l0.k.e.a.f20517h;
    }

    @Override // kotlin.s0.w.d.l0.k.e
    public kotlin.s0.w.d.l0.k.e.b b(kotlin.s0.w.d.l0.c.a r1, kotlin.s0.w.d.l0.c.a r2, kotlin.s0.w.d.l0.c.e r3) {
        kotlin.n0.d.o.f(r1, "superDescriptor");
        kotlin.n0.d.o.f(r2, "subDescriptor");
        if ((r2 instanceof u0) == false) goto L27;
        if ((r1 instanceof u0) == false) goto L27;
        u0 r4 = (u0) r2;
        u0 r5 = (u0) r1;
        if (kotlin.n0.d.o.a(r4.getName(), r5.getName()) == true) goto L12;
        return kotlin.s0.w.d.l0.k.e.b.f20522i;
    L12:
        if (kotlin.s0.w.d.l0.e.a.l0.l.c.a(r4) == false) goto L18;
        if (kotlin.s0.w.d.l0.e.a.l0.l.c.a(r5) == false) goto L18;
        return kotlin.s0.w.d.l0.k.e.b.f20519f;
    L18:
        if (kotlin.s0.w.d.l0.e.a.l0.l.c.a(r4) == true) goto L25;
        if (kotlin.s0.w.d.l0.e.a.l0.l.c.a(r5) == true) goto L25;
        return kotlin.s0.w.d.l0.k.e.b.f20522i;
    L25:
        return kotlin.s0.w.d.l0.k.e.b.f20521h;
    L27:
        return kotlin.s0.w.d.l0.k.e.b.f20522i;
    }
}
