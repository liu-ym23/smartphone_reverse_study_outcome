package kotlin.s0.w.d.l0.l.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.i0.j0;
import kotlin.i0.m0;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.c.j1;
import kotlin.s0.w.d.l0.c.k0;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h0 f20720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k0 f20721b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20722a = null;

        static {
            int[] r0 = new int[kotlin.s0.w.d.l0.f.b.C0541b.c.EnumC0544c.values().length];
            r0[kotlin.s0.w.d.l0.f.b.C0541b.c.EnumC0544c.f19922g.ordinal()] = 1;
            r0[kotlin.s0.w.d.l0.f.b.C0541b.c.EnumC0544c.f19923h.ordinal()] = 2;
            r0[kotlin.s0.w.d.l0.f.b.C0541b.c.EnumC0544c.f19924i.ordinal()] = 3;
            r0[kotlin.s0.w.d.l0.f.b.C0541b.c.EnumC0544c.f19925j.ordinal()] = 4;
            r0[kotlin.s0.w.d.l0.f.b.C0541b.c.EnumC0544c.f19926k.ordinal()] = 5;
            r0[kotlin.s0.w.d.l0.f.b.C0541b.c.EnumC0544c.f19927l.ordinal()] = 6;
            r0[kotlin.s0.w.d.l0.f.b.C0541b.c.EnumC0544c.m.ordinal()] = 7;
            r0[kotlin.s0.w.d.l0.f.b.C0541b.c.EnumC0544c.n.ordinal()] = 8;
            r0[kotlin.s0.w.d.l0.f.b.C0541b.c.EnumC0544c.o.ordinal()] = 9;
            r0[kotlin.s0.w.d.l0.f.b.C0541b.c.EnumC0544c.p.ordinal()] = 10;
            r0[kotlin.s0.w.d.l0.f.b.C0541b.c.EnumC0544c.q.ordinal()] = 11;
            r0[kotlin.s0.w.d.l0.f.b.C0541b.c.EnumC0544c.r.ordinal()] = 12;
            r0[kotlin.s0.w.d.l0.f.b.C0541b.c.EnumC0544c.s.ordinal()] = 13;
            f20722a = r0;
        }
    }

    public e(h0 r2, k0 r3) {
        kotlin.n0.d.o.f(r2, "module");
        kotlin.n0.d.o.f(r3, "notFoundClasses");
        this.f20720a = r2;
        this.f20721b = r3;
    }

    private final boolean b(kotlin.s0.w.d.l0.k.r.g<?> r7, kotlin.s0.w.d.l0.n.e0 r8, kotlin.s0.w.d.l0.f.b.C0541b.c r9) {
        kotlin.s0.w.d.l0.f.b.C0541b.c.EnumC0544c r0 = r9.S();
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 != 10) goto L9;
        kotlin.s0.w.d.l0.c.h r6 = r8.O0().d();
        if ((r6 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L34;
        kotlin.s0.w.d.l0.c.e r10 = (kotlin.s0.w.d.l0.c.e) r6;
    L35:
        if (r10 != null) goto L37;
    L39:
        return true;
    L37:
        if (kotlin.s0.w.d.l0.b.h.k0(r10) == true) goto L39;
        return false;
    L34:
        r10 = null;
        goto L35
    L9:
        if (r1 == 13) goto L12;
        return kotlin.n0.d.o.a(r7.a(this.f20720a), r8);
    L12:
        if ((r7 instanceof kotlin.s0.w.d.l0.k.r.b) == true) goto L14;
    L16:
        boolean r2 = false;
    L17:
        if (r2 == false) goto L30;
        kotlin.s0.w.d.l0.n.e0 r11 = c().k(r8);
        kotlin.n0.d.o.e(r11, "builtIns.getArrayElementType(expectedType)");
        kotlin.s0.w.d.l0.k.r.b r12 = (kotlin.s0.w.d.l0.k.r.b) r7;
        Iterable r3 = kotlin.i0.r.h(r12.b());
        if ((r3 instanceof Collection) == true) goto L21;
    L23:
        Iterator r4 = r3.iterator();
    L25:
        if (r4.hasNext() == false) goto L39;
        int r5 = ((j0) r4).nextInt();
        kotlin.s0.w.d.l0.k.r.g<?> r13 = r12.b().get(r5);
        kotlin.s0.w.d.l0.f.b.C0541b.c r14 = r9.H(r5);
        kotlin.n0.d.o.e(r14, "value.getArrayElement(i)");
        if (b(r13, r11, r14) == true) goto L25;
        return false;
    L21:
        if (((Collection) r3).isEmpty() == false) goto L23;
    L30:
        throw new IllegalStateException(("Deserialized ArrayValue should have the same number of elements as the original array value: " + r7).toString());
    L14:
        if (((kotlin.s0.w.d.l0.k.r.b) r7).b().size() != r9.J().size()) goto L16;
        r2 = true;
        goto L17
    L5:
        r1 = a.f20722a[r0.ordinal()];
        goto L7
    }

    private final kotlin.s0.w.d.l0.b.h c() {
        return this.f20720a.o();
    }

    private final kotlin.u<kotlin.s0.w.d.l0.g.f, kotlin.s0.w.d.l0.k.r.g<?>> d(kotlin.s0.w.d.l0.f.b.C0541b r4, Map<kotlin.s0.w.d.l0.g.f, ? extends j1> r5, kotlin.s0.w.d.l0.f.z.c r6) {
        j1 r7 = r5.get(x.b(r6, r4.v()));
        if (r7 != null) goto L6;
        return null;
    L6:
        kotlin.s0.w.d.l0.g.f r1 = x.b(r6, r4.v());
        kotlin.s0.w.d.l0.n.e0 r8 = r7.b();
        kotlin.n0.d.o.e(r8, "parameter.type");
        kotlin.s0.w.d.l0.f.b.C0541b.c r9 = r4.w();
        kotlin.n0.d.o.e(r9, "proto.value");
        return new kotlin.u(r1, g(r8, r9, r6));
    }

    private final kotlin.s0.w.d.l0.c.e e(kotlin.s0.w.d.l0.g.b r2) {
        return kotlin.s0.w.d.l0.c.x.c(this.f20720a, r2, this.f20721b);
    }

    private final kotlin.s0.w.d.l0.k.r.g<?> g(kotlin.s0.w.d.l0.n.e0 r2, kotlin.s0.w.d.l0.f.b.C0541b.c r3, kotlin.s0.w.d.l0.f.z.c r4) {
        kotlin.s0.w.d.l0.k.r.g<?> r5 = f(r2, r3, r4);
        if (b(r5, r2, r3) == true) goto L6;
        r5 = null;
    L6:
        if (r5 == null) goto L8;
        return r5;
    L8:
        return kotlin.s0.w.d.l0.k.r.k.f20571b.a("Unexpected argument value: actual type " + r3.S() + " != expected type " + r2);
    }

    public final kotlin.s0.w.d.l0.c.o1.c a(kotlin.s0.w.d.l0.f.b r6, kotlin.s0.w.d.l0.f.z.c r7) {
        kotlin.n0.d.o.f(r6, "proto");
        kotlin.n0.d.o.f(r7, "nameResolver");
        kotlin.s0.w.d.l0.c.e r0 = e(x.a(r7, r6.A()));
        Map r1 = m0.h();
        if (r6.w() == 0) goto L22;
        if (kotlin.s0.w.d.l0.n.u1.k.m(r0) == true) goto L22;
        if (kotlin.s0.w.d.l0.k.d.t(r0) == false) goto L22;
        Collection<kotlin.s0.w.d.l0.c.d> r2 = r0.m();
        kotlin.n0.d.o.e(r2, "annotationClass.constructors");
        kotlin.s0.w.d.l0.c.d r3 = (kotlin.s0.w.d.l0.c.d) kotlin.i0.r.p0(r2);
        if (r3 == null) goto L22;
        List<j1> r4 = r3.h();
        kotlin.n0.d.o.e(r4, "constructor.valueParameters");
        LinkedHashMap r5 = new LinkedHashMap(kotlin.r0.e.c(m0.d(kotlin.i0.r.q(r4, 10)), 16));
        Iterator<T> r8 = r4.iterator();
    L12:
        if (r8.hasNext() == false) goto L14;
        Object r9 = r8.next();
        r5.put(((j1) r9).getName(), r9);
        goto L12
    L14:
        List<kotlin.s0.w.d.l0.f.b.C0541b> r10 = r6.y();
        kotlin.n0.d.o.e(r10, "proto.argumentList");
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L16:
        if (r12.hasNext() == false) goto L20;
        kotlin.s0.w.d.l0.f.b.C0541b r13 = (kotlin.s0.w.d.l0.f.b.C0541b) r12.next();
        kotlin.n0.d.o.e(r13, "it");
        kotlin.u<kotlin.s0.w.d.l0.g.f, kotlin.s0.w.d.l0.k.r.g<?>> r14 = d(r13, r5, r7);
        if (r14 == null) goto L16;
        r11.add(r14);
        goto L16
    L20:
        r1 = m0.q(r11);
    L22:
        return new kotlin.s0.w.d.l0.c.o1.d(r0.s(), r1, a1.f18847a);
    }

    public final kotlin.s0.w.d.l0.k.r.g<?> f(kotlin.s0.w.d.l0.n.e0 r5, kotlin.s0.w.d.l0.f.b.C0541b.c r6, kotlin.s0.w.d.l0.f.z.c r7) {
        kotlin.n0.d.o.f(r5, "expectedType");
        kotlin.n0.d.o.f(r6, "value");
        kotlin.n0.d.o.f(r7, "nameResolver");
        Boolean r0 = kotlin.s0.w.d.l0.f.z.b.N.g(r6.O());
        kotlin.n0.d.o.e(r0, "IS_UNSIGNED.get(value.flags)");
        boolean r1 = r0.booleanValue();
        kotlin.s0.w.d.l0.f.b.C0541b.c.EnumC0544c r2 = r6.S();
        if (r2 != null) goto L5;
        int r3 = -1;
    L6:
        switch(r3) {
            case 1: goto L40;
            case 2: goto L54;
            case 3: goto L35;
            case 4: goto L31;
            case 5: goto L26;
            case 6: goto L52;
            case 7: goto L51;
            case 8: goto L20;
            case 9: goto L49;
            case 10: goto L48;
            case 11: goto L47;
            case 12: goto L14;
            case 13: goto L9;
            default: goto L8;
        };
    L9:
        List<kotlin.s0.w.d.l0.f.b.C0541b.c> r8 = r6.J();
        kotlin.n0.d.o.e(r8, "value.arrayElementList");
        ArrayList r4 = new ArrayList(kotlin.i0.r.q(r8, 10));
        Iterator<T> r9 = r8.iterator();
    L11:
        if (r9.hasNext() == false) goto L44;
        kotlin.s0.w.d.l0.f.b.C0541b.c r10 = (kotlin.s0.w.d.l0.f.b.C0541b.c) r9.next();
        kotlin.s0.w.d.l0.n.m0 r11 = c().i();
        kotlin.n0.d.o.e(r11, "builtIns.anyType");
        kotlin.n0.d.o.e(r10, "it");
        r4.add(f(r11, r10, r7));
        goto L11
    L44:
        return new n(r4, r5);
    L14:
        kotlin.s0.w.d.l0.f.b r12 = r6.F();
        kotlin.n0.d.o.e(r12, "value.annotation");
        kotlin.s0.w.d.l0.k.r.g<?> r13 = new kotlin.s0.w.d.l0.k.r.a(a(r12, r7));
    L46:
        return r13;
    L26:
        long r14 = r6.Q();
        if (r1 == false) goto L29;
        kotlin.s0.w.d.l0.k.r.g<?> r15 = new kotlin.s0.w.d.l0.k.r.y(r14);
    L53:
        return r15;
    L29:
        r15 = new kotlin.s0.w.d.l0.k.r.r(r14);
        goto L53
    L31:
        int r16 = (int) r6.Q();
        if (r1 == false) goto L34;
        r13 = new kotlin.s0.w.d.l0.k.r.x(r16);
        goto L46
    L34:
        r13 = new kotlin.s0.w.d.l0.k.r.m(r16);
        goto L46
    L35:
        short r17 = (short) r6.Q();
        if (r1 == false) goto L38;
        r13 = new kotlin.s0.w.d.l0.k.r.z(r17);
        goto L46
    L38:
        r13 = new kotlin.s0.w.d.l0.k.r.u(r17);
        goto L46
    L40:
        byte r18 = (byte) r6.Q();
        if (r1 == false) goto L43;
        r13 = new kotlin.s0.w.d.l0.k.r.w(r18);
        goto L46
    L43:
        r13 = new kotlin.s0.w.d.l0.k.r.d(r18);
        goto L46
    L8:
        throw new IllegalStateException(("Unsupported annotation argument type: " + r6.S() + " (expected " + r5 + ')').toString());
    L47:
        return new kotlin.s0.w.d.l0.k.r.j(x.a(r7, r6.K()), x.b(r7, r6.N()));
    L48:
        return new kotlin.s0.w.d.l0.k.r.q(x.a(r7, r6.K()), r6.G());
    L49:
        return new kotlin.s0.w.d.l0.k.r.v(r7.b(r6.R()));
    L20:
        if (r6.Q() == 0) goto L22;
        boolean r19 = true;
    L50:
        return new kotlin.s0.w.d.l0.k.r.c(r19);
    L22:
        r19 = false;
        goto L50
    L51:
        return new kotlin.s0.w.d.l0.k.r.i(r6.M());
    L52:
        return new kotlin.s0.w.d.l0.k.r.l(r6.P());
    L54:
        return new kotlin.s0.w.d.l0.k.r.e((char) r6.Q());
    L5:
        r3 = a.f20722a[r2.ordinal()];
        goto L6
    }
}
