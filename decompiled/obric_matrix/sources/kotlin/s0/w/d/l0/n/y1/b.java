package kotlin.s0.w.d.l0.n.y1;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.i0.r;
import kotlin.m;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.s0.w.d.l0.b.h;
import kotlin.s0.w.d.l0.k.q.a.d;
import kotlin.s0.w.d.l0.n.b0;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.e1;
import kotlin.s0.w.d.l0.n.f0;
import kotlin.s0.w.d.l0.n.f1;
import kotlin.s0.w.d.l0.n.g1;
import kotlin.s0.w.d.l0.n.i1;
import kotlin.s0.w.d.l0.n.k1;
import kotlin.s0.w.d.l0.n.l1;
import kotlin.s0.w.d.l0.n.m0;
import kotlin.s0.w.d.l0.n.n1;
import kotlin.s0.w.d.l0.n.p1;
import kotlin.s0.w.d.l0.n.q1;
import kotlin.s0.w.d.l0.n.r1;
import kotlin.u;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21199a = null;

        static {
            int[] r0 = new int[r1.values().length];
            r0[r1.f21065h.ordinal()] = 1;
            r0[r1.f21066i.ordinal()] = 2;
            r0[r1.f21067j.ordinal()] = 3;
            f21199a = r0;
        }
    }

    /* JADX INFO: renamed from: kotlin.s0.w.d.l0.n.y1.b$b, reason: collision with other inner class name */
    static final class C0582b extends q implements l<q1, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final C0582b f21200f = null;

        static {
            f21200f = new C0582b();
        }

        C0582b() {
            super(1);
        }

        public final Boolean a(q1 r1) {
            o.e(r1, "it");
            return Boolean.valueOf(d.d(r1));
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(q1 r1) {
            return a(r1);
        }
    }

    public static final class c extends f1 {
        c() {
        }

        @Override // kotlin.s0.w.d.l0.n.f1
        public g1 k(e1 r2) {
            o.f(r2, "key");
            if ((r2 instanceof kotlin.s0.w.d.l0.k.q.a.b) == false) goto L5;
            kotlin.s0.w.d.l0.k.q.a.b r3 = (kotlin.s0.w.d.l0.k.q.a.b) r2;
        L6:
            if (r3 != null) goto L9;
            return null;
        L9:
            if (r3.f().d() == false) goto L13;
            return new i1(r1.f21067j, r3.f().b());
        L13:
            return r3.f();
        L5:
            r3 = null;
            goto L6
        }
    }

    public static final kotlin.s0.w.d.l0.n.y1.a<e0> a(e0 r7) {
        o.f(r7, WsConstants.KEY_CONNECTION_TYPE);
        if (b0.b(r7) == false) goto L6;
        kotlin.s0.w.d.l0.n.y1.a<e0> r0 = a(b0.c(r7));
        kotlin.s0.w.d.l0.n.y1.a<e0> r1 = a(b0.d(r7));
        return new kotlin.s0.w.d.l0.n.y1.a(p1.b(f0.d(b0.c(r0.c()), b0.d(r1.c())), r7), p1.b(f0.d(b0.c(r0.d()), b0.d(r1.d())), r7));
    L6:
        e1 r2 = r7.O0();
        if (d.d(r7) == false) goto L18;
        o.d(r2, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.calls.inference.CapturedTypeConstructor");
        g1 r3 = ((kotlin.s0.w.d.l0.k.q.a.b) r2).f();
        e0 r4 = r3.b();
        o.e(r4, "typeProjection.type");
        e0 r5 = b(r4, r7);
        int r6 = a.f21199a[r3.a().ordinal()];
        if (r6 != 2) goto L11;
        m0 r8 = kotlin.s0.w.d.l0.n.x1.a.h(r7).I();
        o.e(r8, "type.builtIns.nullableAnyType");
        return new kotlin.s0.w.d.l0.n.y1.a(r5, r8);
    L11:
        if (r6 != 3) goto L14;
        m0 r9 = kotlin.s0.w.d.l0.n.x1.a.h(r7).H();
        o.e(r9, "type.builtIns.nothingType");
        return new kotlin.s0.w.d.l0.n.y1.a(b(r9, r7), r5);
    L14:
        throw new AssertionError("Only nontrivial projections should have been captured, not: " + r3);
    L18:
        if (r7.M0().isEmpty() == true) goto L45;
        if (r7.M0().size() != r2.getParameters().size()) goto L45;
        ArrayList r10 = new ArrayList();
        ArrayList r11 = new ArrayList();
        List<g1> r12 = r7.M0();
        List<kotlin.s0.w.d.l0.c.f1> r13 = r2.getParameters();
        o.e(r13, "typeConstructor.parameters");
        Iterator r14 = r.G0(r12, r13).iterator();
    L24:
        if (r14.hasNext() == false) goto L30;
        u r15 = (u) r14.next();
        g1 r16 = (g1) r15.a();
        kotlin.s0.w.d.l0.c.f1 r17 = (kotlin.s0.w.d.l0.c.f1) r15.b();
        o.e(r17, "typeParameter");
        kotlin.s0.w.d.l0.n.y1.c r18 = g(r16, r17);
        if (r16.d() == false) goto L28;
        r10.add(r18);
    L29:
        r11.add(r18);
        goto L24
    L28:
        kotlin.s0.w.d.l0.n.y1.a<kotlin.s0.w.d.l0.n.y1.c> r19 = d(r18);
        kotlin.s0.w.d.l0.n.y1.c r20 = r19.a();
        r18 = r19.b();
        r10.add(r20);
        goto L29
    L30:
        boolean r21 = true;
        if (r10.isEmpty() == false) goto L33;
    L32:
        r21 = false;
    L39:
        if (r21 == false) goto L41;
        Object r22 = kotlin.s0.w.d.l0.n.x1.a.h(r7).H();
        o.e(r22, "type.builtIns.nothingType");
    L43:
        return new kotlin.s0.w.d.l0.n.y1.a(r22, e(r7, r11));
    L41:
        r22 = e(r7, r10);
        goto L43
    L33:
        Iterator r23 = r10.iterator();
    L35:
        if (r23.hasNext() == false) goto L32;
        if ((!((kotlin.s0.w.d.l0.n.y1.c) r23.next()).d()) == false) goto L35;
    L45:
        return new kotlin.s0.w.d.l0.n.y1.a(r7, r7);
    }

    private static final e0 b(e0 r0, e0 r1) {
        e0 r2 = n1.q(r0, r1.P0());
        o.e(r2, "makeNullableIfNeeded(this, type.isMarkedNullable)");
        return r2;
    }

    public static final g1 c(g1 r3, boolean r4) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.d() == false) goto L8;
        return r3;
    L8:
        e0 r0 = r3.b();
        o.e(r0, "typeProjection.type");
        if (n1.c(r0, C0582b.f21200f) == true) goto L11;
        return r3;
    L11:
        r1 r1 = r3.a();
        o.e(r1, "typeProjection.projectionKind");
        if (r1 == r1.f21067j) goto L14;
        if (r4 == false) goto L19;
        return new i1(r1, a(r0).c());
    L19:
        return f(r3);
    L14:
        return new i1(r1, a(r0).d());
    }

    private static final kotlin.s0.w.d.l0.n.y1.a<kotlin.s0.w.d.l0.n.y1.c> d(kotlin.s0.w.d.l0.n.y1.c r7) {
        kotlin.s0.w.d.l0.n.y1.a<e0> r0 = a(r7.a());
        e0 r1 = r0.a();
        e0 r2 = r0.b();
        kotlin.s0.w.d.l0.n.y1.a<e0> r3 = a(r7.b());
        e0 r4 = r3.a();
        e0 r5 = r3.b();
        return new kotlin.s0.w.d.l0.n.y1.a(new kotlin.s0.w.d.l0.n.y1.c(r7.c(), r2, r4), new kotlin.s0.w.d.l0.n.y1.c(r7.c(), r1, r5));
    }

    private static final e0 e(e0 r8, List<kotlin.s0.w.d.l0.n.y1.c> r9) {
        r8.M0().size();
        r9.size();
        ArrayList r3 = new ArrayList(r.q(r9, 10));
        Iterator<T> r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L7;
        r3.add(h((kotlin.s0.w.d.l0.n.y1.c) r10.next()));
        goto L4
    L7:
        return k1.e(r8, r3, null, null, 6, null);
    }

    private static final g1 f(g1 r2) {
        l1 r0 = l1.g(new c());
        o.e(r0, "create(object : TypeCons…ojection\n        }\n    })");
        return r0.t(r2);
    }

    private static final kotlin.s0.w.d.l0.n.y1.c g(g1 r4, kotlin.s0.w.d.l0.c.f1 r5) {
        r1 r0 = l1.c(r5.n(), r4);
        int r1 = a.f21199a[r0.ordinal()];
        if (r1 != 1) goto L5;
        e0 r2 = r4.b();
        o.e(r2, WsConstants.KEY_CONNECTION_TYPE);
        e0 r6 = r4.b();
        o.e(r6, WsConstants.KEY_CONNECTION_TYPE);
        return new kotlin.s0.w.d.l0.n.y1.c(r5, r2, r6);
    L5:
        if (r1 != 2) goto L7;
        e0 r7 = r4.b();
        o.e(r7, WsConstants.KEY_CONNECTION_TYPE);
        m0 r3 = kotlin.s0.w.d.l0.k.t.a.f(r5).I();
        o.e(r3, "typeParameter.builtIns.nullableAnyType");
        return new kotlin.s0.w.d.l0.n.y1.c(r5, r7, r3);
    L7:
        if (r1 != 3) goto L10;
        m0 r8 = kotlin.s0.w.d.l0.k.t.a.f(r5).H();
        o.e(r8, "typeParameter.builtIns.nothingType");
        e0 r9 = r4.b();
        o.e(r9, WsConstants.KEY_CONNECTION_TYPE);
        return new kotlin.s0.w.d.l0.n.y1.c(r5, r8, r9);
    L10:
        throw new m();
    }

    private static final g1 h(kotlin.s0.w.d.l0.n.y1.c r2) {
        r2.d();
        if (o.a(r2.a(), r2.b()) == true) goto L17;
        r1 r0 = r2.c().n();
        r1 r1 = r1.f21066i;
        if (r0 == r1) goto L17;
        if (h.m0(r2.a()) == false) goto L13;
        if (r2.c().n() == r1) goto L13;
        return new i1(i(r2, r1.f21067j), r2.b());
    L13:
        if (h.o0(r2.b()) == false) goto L20;
        return new i1(i(r2, r1), r2.a());
    L20:
        return new i1(i(r2, r1.f21067j), r2.b());
    L17:
        return new i1(r2.a());
    }

    private static final r1 i(kotlin.s0.w.d.l0.n.y1.c r0, r1 r1) {
        if (r1 == r0.c().n()) goto L5;
        return r1;
    L5:
        return r1.f21065h;
    }
}
