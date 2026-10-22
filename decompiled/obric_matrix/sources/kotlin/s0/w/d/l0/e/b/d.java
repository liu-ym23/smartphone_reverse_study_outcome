package kotlin.s0.w.d.l0.e.b;

import kotlin.f0;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.l0;
import kotlin.s0.w.d.l0.c.v0;
import kotlin.s0.w.d.l0.n.d0;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.e1;
import kotlin.s0.w.d.l0.n.g1;
import kotlin.s0.w.d.l0.n.n1;
import kotlin.s0.w.d.l0.n.r1;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static final String a(kotlin.s0.w.d.l0.c.e r8, y<?> r9) {
        kotlin.n0.d.o.f(r8, "klass");
        kotlin.n0.d.o.f(r9, "typeMappingConfiguration");
        String r0 = r9.b(r8);
        if (r0 == null) goto L5;
        return r0;
    L5:
        kotlin.s0.w.d.l0.c.m r1 = r8.c();
        kotlin.n0.d.o.e(r1, "klass.containingDeclaration");
        String r2 = kotlin.s0.w.d.l0.g.h.b(r8.getName()).g();
        kotlin.n0.d.o.e(r2, "safeIdentifier(klass.name).identifier");
        if ((r1 instanceof l0) == false) goto L13;
        kotlin.s0.w.d.l0.g.c r10 = ((l0) r1).e();
        if (r10.d() == true) goto L24;
        StringBuilder r11 = new StringBuilder();
        String r3 = r10.b();
        kotlin.n0.d.o.e(r3, "fqName.asString()");
        r11.append(kotlin.u0.k.v(r3, '.', '/', false, 4, null));
        r11.append('/');
        r11.append(r2);
        return r11.toString();
    L24:
        return r2;
    L13:
        if ((r1 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L15;
        kotlin.s0.w.d.l0.c.e r4 = (kotlin.s0.w.d.l0.c.e) r1;
    L16:
        if (r4 == null) goto L23;
        String r12 = r9.d(r4);
        if (r12 != null) goto L21;
        r12 = a(r4, r9);
    L21:
        return r12 + '$' + r2;
    L23:
        throw new IllegalArgumentException("Unexpected container: " + r1 + " for " + r8);
    L15:
        r4 = null;
        goto L16
    }

    public static /* synthetic */ String b(kotlin.s0.w.d.l0.c.e r0, y r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L6;
        r1 = z.f19799a;
    L6:
        return a(r0, r1);
    }

    public static final boolean c(kotlin.s0.w.d.l0.c.a r2) {
        kotlin.n0.d.o.f(r2, "descriptor");
        if ((r2 instanceof kotlin.s0.w.d.l0.c.l) == false) goto L5;
        return true;
    L5:
        e0 r0 = r2.getReturnType();
        kotlin.n0.d.o.c(r0);
        if (kotlin.s0.w.d.l0.b.h.B0(r0) == false) goto L12;
        e0 r1 = r2.getReturnType();
        kotlin.n0.d.o.c(r1);
        if (n1.l(r1) == true) goto L12;
        if ((r2 instanceof v0) == true) goto L12;
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10, types: [T, java.lang.Object] */
    public static final <T> T d(e0 r10, m<T> r11, a0 r12, y<? extends T> r13, j<T> r14, kotlin.n0.c.q<? super e0, ? super T, ? super a0, f0> r15) {
        kotlin.n0.d.o.f(r10, "kotlinType");
        kotlin.n0.d.o.f(r11, "factory");
        kotlin.n0.d.o.f(r12, "mode");
        kotlin.n0.d.o.f(r13, "typeMappingConfiguration");
        kotlin.n0.d.o.f(r15, "writeGenericType");
        e0 r1 = r13.e(r10);
        if (r1 == null) goto L7;
        return (T) d(r1, r11, r12, r13, r14, r15);
    L7:
        if (kotlin.s0.w.d.l0.b.g.q(r10) == true) goto L9;
        kotlin.s0.w.d.l0.n.t1.q r0 = kotlin.s0.w.d.l0.n.t1.q.f21107a;
        Object r2 = b0.b(r0, r10, r11, r12);
        if (r2 == null) goto L14;
        ?? r16 = (Object) b0.a(r11, r2, r12.d());
        r15.f(r10, r16, r12);
        return r16;
    L14:
        e1 r3 = r10.O0();
        if ((r3 instanceof d0) == false) goto L21;
        d0 r4 = (d0) r3;
        e0 r17 = r4.i();
        if (r17 != null) goto L20;
        r17 = r13.c(r4.a());
    L20:
        return (T) d(kotlin.s0.w.d.l0.n.x1.a.w(r17), r11, r12, r13, r14, r15);
    L21:
        kotlin.s0.w.d.l0.c.h r5 = r3.d();
        if (r5 == null) goto L96;
        if (kotlin.s0.w.d.l0.n.u1.k.m(r5) == false) goto L30;
        T r18 = (T) r11.c("error/NonExistentClass");
        r13.f(r10, (kotlin.s0.w.d.l0.c.e) r5);
        if (r14 != null) goto L28;
        return r18;
    L28:
        r14.c(r18);
        throw null;
    L30:
        boolean r6 = r5 instanceof kotlin.s0.w.d.l0.c.e;
        if (r6 == true) goto L33;
    L54:
        if (r6 == false) goto L78;
        if (kotlin.s0.w.d.l0.k.f.b(r5) == false) goto L64;
        if (r12.c() == true) goto L64;
        e0 r7 = (e0) kotlin.s0.w.d.l0.n.x.a(r0, r10);
        if (r7 == null) goto L64;
        return (T) d(r7, r11, r12.g(), r13, r14, r15);
    L64:
        if (r12.e() == true) goto L66;
    L68:
        kotlin.s0.w.d.l0.c.e r8 = (kotlin.s0.w.d.l0.c.e) r5;
        kotlin.s0.w.d.l0.c.e r19 = r8.a();
        kotlin.n0.d.o.e(r19, "descriptor.original");
        T r110 = r13.a(r19);
        if (r110 == null) goto L71;
        T r111 = (Object) r110;
    L75:
        r15.f(r10, r111, r12);
        return r111;
    L71:
        if (r8.i() != kotlin.s0.w.d.l0.c.f.f18868i) goto L73;
        kotlin.s0.w.d.l0.c.m r112 = r8.c();
        kotlin.n0.d.o.d(r112, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        r8 = (kotlin.s0.w.d.l0.c.e) r112;
    L73:
        kotlin.s0.w.d.l0.c.e r113 = r8.a();
        kotlin.n0.d.o.e(r113, "enumClassIfEnumEntry.original");
        r111 = (Object) r11.c(a(r113, r13));
        goto L75
    L66:
        if (kotlin.s0.w.d.l0.b.h.k0((kotlin.s0.w.d.l0.c.e) r5) == false) goto L68;
        r111 = (Object) r11.e();
        goto L75
    L78:
        if ((r5 instanceof f1) == false) goto L88;
        e0 r114 = kotlin.s0.w.d.l0.n.x1.a.i((f1) r5);
        if (r10.P0() == false) goto L82;
        r114 = kotlin.s0.w.d.l0.n.x1.a.t(r114);
    L82:
        T r115 = (T) d(r114, r11, r12, r13, null, kotlin.s0.w.d.l0.p.d.b());
        if (r14 != null) goto L85;
        return r115;
    L85:
        kotlin.s0.w.d.l0.g.f r116 = r5.getName();
        kotlin.n0.d.o.e(r116, "descriptor.getName()");
        r14.d(r116, r115);
        throw null;
    L88:
        if ((r5 instanceof kotlin.s0.w.d.l0.c.e1) == false) goto L94;
        if (r12.b() == false) goto L94;
        return (T) d(((kotlin.s0.w.d.l0.c.e1) r5).V(), r11, r12, r13, r14, r15);
    L94:
        throw new UnsupportedOperationException("Unknown type " + r10);
    L33:
        if (kotlin.s0.w.d.l0.b.h.c0(r10) == false) goto L54;
        if (r10.M0().size() != 1) goto L53;
        g1 r117 = r10.M0().get(0);
        e0 r9 = r117.b();
        kotlin.n0.d.o.e(r9, "memberProjection.type");
        if (r117.a() != r1.f21066i) goto L43;
        Object r118 = r11.c("java/lang/Object");
        if (r14 == null) goto L47;
        r14.b();
        throw null;
    L47:
        return (T) r11.b('[' + r11.a(r118));
    L43:
        if (r14 != null) goto L50;
        r1 r119 = r117.a();
        kotlin.n0.d.o.e(r119, "memberProjection.projectionKind");
        r118 = d(r9, r11, r12.f(r119, true), r13, r14, r15);
        if (r14 == null) goto L47;
        r14.a();
        throw null;
    L50:
        r14.b();
        throw null;
    L53:
        throw new UnsupportedOperationException("arrays must have one type argument");
    L96:
        throw new UnsupportedOperationException("no descriptor for type constructor of " + r10);
    L9:
        return (T) d(kotlin.s0.w.d.l0.b.l.a(r10), r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ Object e(e0 r6, m r7, a0 r8, y r9, j r10, kotlin.n0.c.q r11, int r12, Object r13) {
        if ((r12 & 32) == 0) goto L6;
        r11 = kotlin.s0.w.d.l0.p.d.b();
    L6:
        return d(r6, r7, r8, r9, r10, r11);
    }
}
