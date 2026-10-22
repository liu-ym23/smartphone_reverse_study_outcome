package kotlin.s0.w.d.l0.e.a.l0.m;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.i0.r;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.s0.w.d.l0.k.w.h;
import kotlin.s0.w.d.l0.n.a1;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.g1;
import kotlin.s0.w.d.l0.n.l0;
import kotlin.s0.w.d.l0.n.m0;
import kotlin.s0.w.d.l0.n.q1;
import kotlin.s0.w.d.l0.n.y;
import kotlin.u;
import kotlin.u0.k;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends y implements l0 {

    static final class a extends q implements l<String, CharSequence> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f19514f = null;

        static {
            f19514f = new a();
        }

        a() {
            super(1);
        }

        public final CharSequence a(String r2) {
            o.f(r2, "it");
            return "(raw) " + r2;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ CharSequence invoke(String r1) {
            return a(r1);
        }
    }

    public f(m0 r2, m0 r3) {
        o.f(r2, "lowerBound");
        o.f(r3, "upperBound");
        this(r2, r3, false);
    }

    private f(m0 r1, m0 r2, boolean r3) {
        super(r1, r2);
        if (r3 == true) goto L6;
        kotlin.s0.w.d.l0.n.t1.e.f21078a.d(r1, r2);
        return;
    }

    private static final boolean b1(String r1, String r2) {
        if (o.a(r1, k.g0(r2, "out ")) == false) goto L5;
    L8:
        return true;
    L5:
        if (o.a(r2, "*") == true) goto L8;
        return false;
    }

    private static final List<String> c1(kotlin.s0.w.d.l0.j.c r2, e0 r3) {
        List<g1> r4 = r3.M0();
        ArrayList r0 = new ArrayList(r.q(r4, 10));
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r0.add(r2.x((g1) r5.next()));
        goto L4
    L6:
        return r0;
    }

    private static final String d1(String r5, String r6) {
        if (k.E(r5, '<', false, 2, null) == true) goto L6;
        return r5;
    L6:
        return k.D0(r5, '<', null, 2, null) + '<' + r6 + '>' + k.A0(r5, '>', null, 2, null);
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public /* bridge */ /* synthetic */ e0 Q0(kotlin.s0.w.d.l0.n.t1.g r1) {
        return a1(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.q1
    public /* bridge */ /* synthetic */ q1 S0(boolean r1) {
        return Z0(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.q1
    public /* bridge */ /* synthetic */ q1 T0(kotlin.s0.w.d.l0.n.t1.g r1) {
        return a1(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.q1
    public /* bridge */ /* synthetic */ q1 U0(a1 r1) {
        return e1(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.y
    public m0 V0() {
        return W0();
    }

    @Override // kotlin.s0.w.d.l0.n.y
    public String Y0(kotlin.s0.w.d.l0.j.c r13, kotlin.s0.w.d.l0.j.f r14) {
        o.f(r13, "renderer");
        o.f(r14, "options");
        String r0 = r13.w(W0());
        String r1 = r13.w(X0());
        if (r14.n() == false) goto L7;
        return "raw (" + r0 + ".." + r1 + ')';
    L7:
        if (X0().M0().isEmpty() == true) goto L9;
        List<String> r15 = c1(r13, W0());
        List<String> r11 = c1(r13, X0());
        String r2 = r.Z(r15, ", ", null, null, 0, null, a.f19514f, 30, null);
        List r16 = r.G0(r15, r11);
        boolean r4 = true;
        if ((r16 instanceof Collection) == true) goto L13;
    L15:
        Iterator r17 = r16.iterator();
    L17:
        if (r17.hasNext() == false) goto L21;
        u r3 = (u) r17.next();
        if (b1((String) r3.c(), (String) r3.d()) == true) goto L17;
        r4 = false;
    L21:
        if (r4 == false) goto L23;
        r1 = d1(r1, r2);
    L23:
        String r18 = d1(r0, r2);
        if (o.a(r18, r1) == false) goto L27;
        return r18;
    L27:
        return r13.t(r18, r1, kotlin.s0.w.d.l0.n.x1.a.h(this));
    L13:
        if (r16.isEmpty() == false) goto L15;
    L9:
        return r13.t(r0, r1, kotlin.s0.w.d.l0.n.x1.a.h(this));
    }

    public f Z0(boolean r3) {
        return new f(W0().V0(r3), X0().V0(r3));
    }

    public y a1(kotlin.s0.w.d.l0.n.t1.g r4) {
        o.f(r4, "kotlinTypeRefiner");
        e0 r1 = r4.h(W0());
        o.d(r1, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        e0 r3 = r4.h(X0());
        o.d(r3, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new f((m0) r1, (m0) r3, true);
    }

    public f e1(a1 r3) {
        o.f(r3, "newAttributes");
        return new f(W0().W0(r3), X0().W0(r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.s0.w.d.l0.n.y, kotlin.s0.w.d.l0.n.e0
    public h q() {
        kotlin.s0.w.d.l0.c.h r0 = O0().d();
        g r2 = null;
        Object[] r3 = 0;
        if ((r0 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L5;
        kotlin.s0.w.d.l0.c.e r1 = (kotlin.s0.w.d.l0.c.e) r0;
    L6:
        if (r1 == null) goto L10;
        h r4 = r1.a0(new e(r2, 1, r3 == true ? 1 : 0));
        o.e(r4, "classDescriptor.getMemberScope(RawSubstitution())");
        return r4;
    L10:
        throw new IllegalStateException(("Incorrect classifier: " + O0().d()).toString());
    L5:
        r1 = null;
        goto L6
    }
}
