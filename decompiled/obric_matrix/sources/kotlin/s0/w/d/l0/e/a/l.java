package kotlin.s0.w.d.l0.e.a;

import java.util.Iterator;
import java.util.List;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.j1;
import kotlin.s0.w.d.l0.c.x0;
import kotlin.s0.w.d.l0.c.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements kotlin.s0.w.d.l0.k.e {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19344a = null;

        static {
            int[] r0 = new int[kotlin.s0.w.d.l0.k.j.i.a.values().length];
            r0[kotlin.s0.w.d.l0.k.j.i.a.f20542f.ordinal()] = 1;
            f19344a = r0;
        }
    }

    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.l<j1, kotlin.s0.w.d.l0.n.e0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f19345f = null;

        static {
            f19345f = new b();
        }

        b() {
            super(1);
        }

        public final kotlin.s0.w.d.l0.n.e0 a(j1 r1) {
            return r1.b();
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.n.e0 invoke(j1 r1) {
            return a(r1);
        }
    }

    public l() {
    }

    @Override // kotlin.s0.w.d.l0.k.e
    public kotlin.s0.w.d.l0.k.e.a a() {
        return kotlin.s0.w.d.l0.k.e.a.f20516g;
    }

    @Override // kotlin.s0.w.d.l0.k.e
    public kotlin.s0.w.d.l0.k.e.b b(kotlin.s0.w.d.l0.c.a r5, kotlin.s0.w.d.l0.c.a r6, kotlin.s0.w.d.l0.c.e r7) {
        kotlin.n0.d.o.f(r5, "superDescriptor");
        kotlin.n0.d.o.f(r6, "subDescriptor");
        if ((r6 instanceof kotlin.s0.w.d.l0.e.a.k0.e) == false) goto L48;
        kotlin.s0.w.d.l0.e.a.k0.e r4 = (kotlin.s0.w.d.l0.e.a.k0.e) r6;
        List<f1> r8 = r4.getTypeParameters();
        kotlin.n0.d.o.e(r8, "subDescriptor.typeParameters");
        if ((!r8.isEmpty()) == true) goto L48;
        kotlin.s0.w.d.l0.k.j.i r9 = kotlin.s0.w.d.l0.k.j.w(r5, r6);
        if (r9 == null) goto L10;
        kotlin.s0.w.d.l0.k.j.i.a r10 = r9.c();
    L11:
        if (r10 != null) goto L13;
        List<j1> r11 = r4.h();
        kotlin.n0.d.o.e(r11, "subDescriptor.valueParameters");
        kotlin.t0.h r12 = kotlin.t0.k.t(kotlin.i0.r.I(r11), b.f19345f);
        kotlin.s0.w.d.l0.n.e0 r2 = r4.getReturnType();
        kotlin.n0.d.o.c(r2);
        kotlin.t0.h r13 = kotlin.t0.k.w(r12, r2);
        x0 r14 = r4.m0();
        if (r14 == null) goto L17;
        kotlin.s0.w.d.l0.n.e0 r15 = r14.b();
    L18:
        Iterator r16 = kotlin.t0.k.v(r13, kotlin.i0.r.k(r15)).iterator();
    L20:
        if (r16.hasNext() == false) goto L29;
        kotlin.s0.w.d.l0.n.e0 r17 = (kotlin.s0.w.d.l0.n.e0) r16.next();
        if ((!r17.M0().isEmpty()) == true) goto L24;
    L26:
        boolean r18 = false;
    L27:
        if (r18 == false) goto L20;
        boolean r19 = true;
    L30:
        if (r19 == true) goto L32;
        kotlin.s0.w.d.l0.c.a r20 = r5.d(new kotlin.s0.w.d.l0.e.a.l0.m.e(null, 1, null).c());
        if (r20 != null) goto L38;
        return kotlin.s0.w.d.l0.k.e.b.f20522i;
    L38:
        if ((r20 instanceof z0) == false) goto L42;
        z0 r21 = (z0) r20;
        List<f1> r22 = r21.getTypeParameters();
        kotlin.n0.d.o.e(r22, "erasedSuper.typeParameters");
        if ((!r22.isEmpty()) == false) goto L42;
        r20 = r21.t().l(kotlin.i0.r.g()).build();
        kotlin.n0.d.o.c(r20);
    L42:
        kotlin.s0.w.d.l0.k.j.i.a r23 = kotlin.s0.w.d.l0.k.j.f20527f.F(r20, r6, false).c();
        kotlin.n0.d.o.e(r23, "DEFAULT.isOverridableByW…Descriptor, false).result");
        if (a.f19344a[r23.ordinal()] != 1) goto L46;
        return kotlin.s0.w.d.l0.k.e.b.f20519f;
    L46:
        return kotlin.s0.w.d.l0.k.e.b.f20522i;
    L32:
        return kotlin.s0.w.d.l0.k.e.b.f20522i;
    L24:
        if ((r17.R0() instanceof kotlin.s0.w.d.l0.e.a.l0.m.f) == true) goto L26;
        r18 = true;
        goto L27
    L29:
        r19 = false;
        goto L30
    L17:
        r15 = null;
        goto L18
    L13:
        return kotlin.s0.w.d.l0.k.e.b.f20522i;
    L10:
        r10 = null;
    L48:
        return kotlin.s0.w.d.l0.k.e.b.f20522i;
    }
}
