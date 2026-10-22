package kotlin.s0.w.d.l0.f.z;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.f.n;
import kotlin.s0.w.d.l0.f.q;
import kotlin.s0.w.d.l0.f.r;
import kotlin.s0.w.d.l0.f.s;
import kotlin.s0.w.d.l0.f.u;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public static final q a(q r1, g r2) {
        o.f(r1, "<this>");
        o.f(r2, "typeTable");
        if (r1.j0() == false) goto L6;
        return r1.R();
    L6:
        if (r1.k0() == true) goto L11;
        return null;
    L11:
        return r2.a(r1.S());
    }

    public static final q b(r r1, g r2) {
        o.f(r1, "<this>");
        o.f(r2, "typeTable");
        if (r1.d0() == false) goto L6;
        q r3 = r1.T();
        o.e(r3, "expandedType");
        return r3;
    L6:
        if (r1.e0() == false) goto L10;
        return r2.a(r1.U());
    L10:
        throw new IllegalStateException("No expandedType in ProtoBuf.TypeAlias".toString());
    }

    public static final q c(q r1, g r2) {
        o.f(r1, "<this>");
        o.f(r2, "typeTable");
        if (r1.o0() == false) goto L6;
        return r1.b0();
    L6:
        if (r1.p0() == true) goto L11;
        return null;
    L11:
        return r2.a(r1.c0());
    }

    public static final boolean d(kotlin.s0.w.d.l0.f.i r1) {
        o.f(r1, "<this>");
        if (r1.v0() == false) goto L5;
    L8:
        return true;
    L5:
        if (r1.w0() == true) goto L8;
        return false;
    }

    public static final boolean e(n r1) {
        o.f(r1, "<this>");
        if (r1.s0() == false) goto L5;
    L8:
        return true;
    L5:
        if (r1.t0() == true) goto L8;
        return false;
    }

    public static final q f(kotlin.s0.w.d.l0.f.c r1, g r2) {
        o.f(r1, "<this>");
        o.f(r2, "typeTable");
        if (r1.o1() == false) goto L6;
        return r1.J0();
    L6:
        if (r1.p1() == true) goto L11;
        return null;
    L11:
        return r2.a(r1.K0());
    }

    public static final q g(q r1, g r2) {
        o.f(r1, "<this>");
        o.f(r2, "typeTable");
        if (r1.r0() == false) goto L6;
        return r1.e0();
    L6:
        if (r1.s0() == true) goto L11;
        return null;
    L11:
        return r2.a(r1.f0());
    }

    public static final q h(kotlin.s0.w.d.l0.f.i r1, g r2) {
        o.f(r1, "<this>");
        o.f(r2, "typeTable");
        if (r1.v0() == false) goto L6;
        return r1.f0();
    L6:
        if (r1.w0() == true) goto L11;
        return null;
    L11:
        return r2.a(r1.g0());
    }

    public static final q i(n r1, g r2) {
        o.f(r1, "<this>");
        o.f(r2, "typeTable");
        if (r1.s0() == false) goto L6;
        return r1.e0();
    L6:
        if (r1.t0() == true) goto L11;
        return null;
    L11:
        return r2.a(r1.f0());
    }

    public static final q j(kotlin.s0.w.d.l0.f.i r1, g r2) {
        o.f(r1, "<this>");
        o.f(r2, "typeTable");
        if (r1.x0() == false) goto L6;
        q r3 = r1.h0();
        o.e(r3, "returnType");
        return r3;
    L6:
        if (r1.y0() == false) goto L10;
        return r2.a(r1.i0());
    L10:
        throw new IllegalStateException("No returnType in ProtoBuf.Function".toString());
    }

    public static final q k(n r1, g r2) {
        o.f(r1, "<this>");
        o.f(r2, "typeTable");
        if (r1.u0() == false) goto L6;
        q r3 = r1.g0();
        o.e(r3, "returnType");
        return r3;
    L6:
        if (r1.v0() == false) goto L10;
        return r2.a(r1.h0());
    L10:
        throw new IllegalStateException("No returnType in ProtoBuf.Property".toString());
    }

    public static final List<q> l(kotlin.s0.w.d.l0.f.c r3, g r4) {
        o.f(r3, "<this>");
        o.f(r4, "typeTable");
        List<q> r0 = r3.a1();
        if ((!r0.isEmpty()) == true) goto L6;
        r0 = null;
    L6:
        if (r0 != null) goto L11;
        List<Integer> r5 = r3.Z0();
        o.e(r5, "supertypeIdList");
        r0 = new ArrayList(kotlin.i0.r.q(r5, 10));
        Iterator<T> r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L11;
        Integer r1 = (Integer) r6.next();
        o.e(r1, "it");
        r0.add(r4.a(r1.intValue()));
    L11:
        return r0;
    }

    public static final q m(q.b r1, g r2) {
        o.f(r1, "<this>");
        o.f(r2, "typeTable");
        if (r1.B() == false) goto L6;
        return r1.y();
    L6:
        if (r1.C() == true) goto L11;
        return null;
    L11:
        return r2.a(r1.z());
    }

    public static final q n(u r1, g r2) {
        o.f(r1, "<this>");
        o.f(r2, "typeTable");
        if (r1.S() == false) goto L6;
        q r3 = r1.M();
        o.e(r3, WsConstants.KEY_CONNECTION_TYPE);
        return r3;
    L6:
        if (r1.T() == false) goto L10;
        return r2.a(r1.N());
    L10:
        throw new IllegalStateException("No type in ProtoBuf.ValueParameter".toString());
    }

    public static final q o(r r1, g r2) {
        o.f(r1, "<this>");
        o.f(r2, "typeTable");
        if (r1.h0() == false) goto L6;
        q r3 = r1.a0();
        o.e(r3, "underlyingType");
        return r3;
    L6:
        if (r1.i0() == false) goto L10;
        return r2.a(r1.b0());
    L10:
        throw new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias".toString());
    }

    public static final List<q> p(s r3, g r4) {
        o.f(r3, "<this>");
        o.f(r4, "typeTable");
        List<q> r0 = r3.S();
        if ((!r0.isEmpty()) == true) goto L6;
        r0 = null;
    L6:
        if (r0 != null) goto L11;
        List<Integer> r5 = r3.R();
        o.e(r5, "upperBoundIdList");
        r0 = new ArrayList(kotlin.i0.r.q(r5, 10));
        Iterator<T> r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L11;
        Integer r1 = (Integer) r6.next();
        o.e(r1, "it");
        r0.add(r4.a(r1.intValue()));
    L11:
        return r0;
    }

    public static final q q(u r1, g r2) {
        o.f(r1, "<this>");
        o.f(r2, "typeTable");
        if (r1.U() == false) goto L6;
        return r1.O();
    L6:
        if (r1.V() == true) goto L11;
        return null;
    L11:
        return r2.a(r1.P());
    }
}
