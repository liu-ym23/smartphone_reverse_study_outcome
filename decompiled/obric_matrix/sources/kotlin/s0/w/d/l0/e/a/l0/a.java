package kotlin.s0.w.d.l0.e.a.l0;

import kotlin.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.s0.w.d.l0.c.m;
import kotlin.s0.w.d.l0.e.a.n0.z;
import kotlin.s0.w.d.l0.e.a.x;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: kotlin.s0.w.d.l0.e.a.l0.a$a, reason: collision with other inner class name */
    static final class C0511a extends q implements kotlin.n0.c.a<x> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ g f19346f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.c.g f19347g;

        C0511a(g r1, kotlin.s0.w.d.l0.c.g r2) {
            this.f19346f = r1;
            this.f19347g = r2;
            super(0);
        }

        public final x a() {
            return a.g(this.f19346f, this.f19347g.getAnnotations());
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ x invoke() {
            return a();
        }
    }

    static final class b extends q implements kotlin.n0.c.a<x> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ g f19348f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.c.o1.g f19349g;

        b(g r1, kotlin.s0.w.d.l0.c.o1.g r2) {
            this.f19348f = r1;
            this.f19349g = r2;
            super(0);
        }

        public final x a() {
            return a.g(this.f19348f, this.f19349g);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ x invoke() {
            return a();
        }
    }

    private static final g a(g r2, m r3, z r4, int r5, kotlin.h<x> r6) {
        kotlin.s0.w.d.l0.e.a.l0.b r0 = r2.a();
        if (r4 == null) goto L5;
        k r1 = new h(r2, r3, r4, r5);
    L7:
        return new g(r0, r1, r6);
    L5:
        r1 = r2.f();
        goto L7
    }

    public static final g b(g r2, k r3) {
        o.f(r2, "<this>");
        o.f(r3, "typeParameterResolver");
        return new g(r2.a(), r3, r2.c());
    }

    public static final g c(g r2, kotlin.s0.w.d.l0.c.g r3, z r4, int r5) {
        o.f(r2, "<this>");
        o.f(r3, "containingDeclaration");
        return a(r2, r3, r4, r5, kotlin.i.a(l.f18419h, new C0511a(r2, r3)));
    }

    public static /* synthetic */ g d(g r0, kotlin.s0.w.d.l0.c.g r1, z r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = 0;
    L9:
        return c(r0, r1, r2, r3);
    }

    public static final g e(g r1, m r2, z r3, int r4) {
        o.f(r1, "<this>");
        o.f(r2, "containingDeclaration");
        o.f(r3, "typeParameterOwner");
        return a(r1, r2, r3, r4, r1.c());
    }

    public static /* synthetic */ g f(g r0, m r1, z r2, int r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = 0;
    L6:
        return e(r0, r1, r2, r3);
    }

    public static final x g(g r1, kotlin.s0.w.d.l0.c.o1.g r2) {
        o.f(r1, "<this>");
        o.f(r2, "additionalAnnotations");
        return r1.a().a().c(r1.b(), r2);
    }

    public static final g h(g r5, kotlin.s0.w.d.l0.c.o1.g r6) {
        o.f(r5, "<this>");
        o.f(r6, "additionalAnnotations");
        if (r6.isEmpty() == false) goto L6;
        return r5;
    L6:
        return new g(r5.a(), r5.f(), kotlin.i.a(l.f18419h, new b(r5, r6)));
    }

    public static final g i(g r2, kotlin.s0.w.d.l0.e.a.l0.b r3) {
        o.f(r2, "<this>");
        o.f(r3, "components");
        return new g(r3, r2.f(), r2.c());
    }
}
