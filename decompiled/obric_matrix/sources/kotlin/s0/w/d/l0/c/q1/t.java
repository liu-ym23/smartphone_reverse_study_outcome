package kotlin.s0.w.d.l0.c.q1;

import kotlin.s0.w.d.l0.n.j1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class t implements kotlin.s0.w.d.l0.c.e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f19060f = null;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final kotlin.s0.w.d.l0.k.w.h a(kotlin.s0.w.d.l0.c.e r1, j1 r2, kotlin.s0.w.d.l0.n.t1.g r3) {
            kotlin.n0.d.o.f(r1, "<this>");
            kotlin.n0.d.o.f(r2, "typeSubstitution");
            kotlin.n0.d.o.f(r3, "kotlinTypeRefiner");
            if ((r1 instanceof t) == false) goto L5;
            t r0 = (t) r1;
        L6:
            if (r0 == null) goto L9;
            kotlin.s0.w.d.l0.k.w.h r4 = r0.F(r2, r3);
            if (r4 == null) goto L9;
            return r4;
        L9:
            kotlin.s0.w.d.l0.k.w.h r5 = r1.a0(r2);
            kotlin.n0.d.o.e(r5, "this.getMemberScope(\n   …ubstitution\n            )");
            return r5;
        L5:
            r0 = null;
            goto L6
        }

        public final kotlin.s0.w.d.l0.k.w.h b(kotlin.s0.w.d.l0.c.e r1, kotlin.s0.w.d.l0.n.t1.g r2) {
            kotlin.n0.d.o.f(r1, "<this>");
            kotlin.n0.d.o.f(r2, "kotlinTypeRefiner");
            if ((r1 instanceof t) == false) goto L5;
            t r0 = (t) r1;
        L6:
            if (r0 == null) goto L9;
            kotlin.s0.w.d.l0.k.w.h r3 = r0.J(r2);
            if (r3 == null) goto L9;
            return r3;
        L9:
            kotlin.s0.w.d.l0.k.w.h r4 = r1.D0();
            kotlin.n0.d.o.e(r4, "this.unsubstitutedMemberScope");
            return r4;
        L5:
            r0 = null;
            goto L6
        }
    }

    static {
        f19060f = new a(null);
    }

    public t() {
    }

    protected abstract kotlin.s0.w.d.l0.k.w.h F(j1 r1, kotlin.s0.w.d.l0.n.t1.g r2);

    protected abstract kotlin.s0.w.d.l0.k.w.h J(kotlin.s0.w.d.l0.n.t1.g r1);

    @Override // kotlin.s0.w.d.l0.c.e, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.h a() {
        return a();
    }

    @Override // kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.m a() {
        return a();
    }
}
