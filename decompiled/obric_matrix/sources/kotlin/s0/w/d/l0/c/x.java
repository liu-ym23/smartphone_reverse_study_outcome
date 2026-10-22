package kotlin.s0.w.d.l0.c;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class x {

    /* synthetic */ class a extends kotlin.n0.d.l implements kotlin.n0.c.l<kotlin.s0.w.d.l0.g.b, kotlin.s0.w.d.l0.g.b> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f19172f = null;

        static {
            f19172f = new a();
        }

        a() {
            super(1);
        }

        @Override // kotlin.n0.d.c, kotlin.s0.c
        public final String getName() {
            return "getOuterClassId";
        }

        @Override // kotlin.n0.d.c
        public final kotlin.s0.f getOwner() {
            return kotlin.n0.d.e0.b(kotlin.s0.w.d.l0.g.b.class);
        }

        @Override // kotlin.n0.d.c
        public final String getSignature() {
            return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.g.b invoke(kotlin.s0.w.d.l0.g.b r1) {
            return m(r1);
        }

        public final kotlin.s0.w.d.l0.g.b m(kotlin.s0.w.d.l0.g.b r1) {
            kotlin.n0.d.o.f(r1, "p0");
            return r1.g();
        }
    }

    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.g.b, Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f19173f = null;

        static {
            f19173f = new b();
        }

        b() {
            super(1);
        }

        public final Integer a(kotlin.s0.w.d.l0.g.b r1) {
            kotlin.n0.d.o.f(r1, "it");
            return 0;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Integer invoke(kotlin.s0.w.d.l0.g.b r1) {
            return a(r1);
        }
    }

    public static final e a(h0 r1, kotlin.s0.w.d.l0.g.b r2) {
        kotlin.n0.d.o.f(r1, "<this>");
        kotlin.n0.d.o.f(r2, "classId");
        h r3 = b(r1, r2);
        if ((r3 instanceof e) == true) goto L7;
        return null;
    L7:
        return (e) r3;
    }

    public static final h b(h0 r10, kotlin.s0.w.d.l0.g.b r11) {
        kotlin.n0.d.o.f(r10, "<this>");
        kotlin.n0.d.o.f(r11, "classId");
        h0 r0 = kotlin.s0.w.d.l0.k.n.a(r10);
        if (r0 != null) goto L20;
        kotlin.s0.w.d.l0.g.c r1 = r11.h();
        kotlin.n0.d.o.e(r1, "classId.packageFqName");
        q0 r12 = r10.N(r1);
        List<kotlin.s0.w.d.l0.g.f> r13 = r11.i().f();
        kotlin.n0.d.o.e(r13, "classId.relativeClassName.pathSegments()");
        kotlin.s0.w.d.l0.k.w.h r14 = r12.q();
        Object r2 = kotlin.i0.r.P(r13);
        kotlin.n0.d.o.e(r2, "segments.first()");
        h r15 = r14.f((kotlin.s0.w.d.l0.g.f) r2, kotlin.s0.w.d.l0.d.b.d.w);
        if (r15 == null) goto L72;
        Iterator<kotlin.s0.w.d.l0.g.f> r16 = r13.subList(1, r13.size()).iterator();
    L9:
        if (r16.hasNext() == false) goto L71;
        kotlin.s0.w.d.l0.g.f r3 = r16.next();
        if ((r15 instanceof e) == false) goto L75;
        kotlin.s0.w.d.l0.k.w.h r17 = ((e) r15).y0();
        kotlin.n0.d.o.e(r3, "name");
        h r18 = r17.f(r3, kotlin.s0.w.d.l0.d.b.d.w);
        if ((r18 instanceof e) == false) goto L16;
        r15 = (e) r18;
    L17:
        if (r15 != null) goto L9;
        return null;
    L16:
        r15 = null;
        goto L17
    L75:
        return null;
    L71:
        return r15;
    L72:
        return null;
    L20:
        kotlin.s0.w.d.l0.g.c r7 = r11.h();
        kotlin.n0.d.o.e(r7, "classId.packageFqName");
        q0 r4 = r0.N(r7);
        List<kotlin.s0.w.d.l0.g.f> r8 = r11.i().f();
        kotlin.n0.d.o.e(r8, "classId.relativeClassName.pathSegments()");
        kotlin.s0.w.d.l0.k.w.h r5 = r4.q();
        Object r9 = kotlin.i0.r.P(r8);
        kotlin.n0.d.o.e(r9, "segments.first()");
        h r6 = r5.f((kotlin.s0.w.d.l0.g.f) r9, kotlin.s0.w.d.l0.d.b.d.w);
        if (r6 != null) goto L23;
    L22:
        r6 = null;
    L35:
        if (r6 != null) goto L52;
        kotlin.s0.w.d.l0.g.c r19 = r11.h();
        kotlin.n0.d.o.e(r19, "classId.packageFqName");
        q0 r110 = r10.N(r19);
        List<kotlin.s0.w.d.l0.g.f> r111 = r11.i().f();
        kotlin.n0.d.o.e(r111, "classId.relativeClassName.pathSegments()");
        kotlin.s0.w.d.l0.k.w.h r112 = r110.q();
        Object r20 = kotlin.i0.r.P(r111);
        kotlin.n0.d.o.e(r20, "segments.first()");
        r15 = r112.f((kotlin.s0.w.d.l0.g.f) r20, kotlin.s0.w.d.l0.d.b.d.w);
        if (r15 == null) goto L73;
        Iterator<kotlin.s0.w.d.l0.g.f> r113 = r111.subList(1, r111.size()).iterator();
    L41:
        if (r113.hasNext() == false) goto L71;
        kotlin.s0.w.d.l0.g.f r21 = r113.next();
        if ((r15 instanceof e) == false) goto L77;
        kotlin.s0.w.d.l0.k.w.h r114 = ((e) r15).y0();
        kotlin.n0.d.o.e(r21, "name");
        h r115 = r114.f(r21, kotlin.s0.w.d.l0.d.b.d.w);
        if ((r115 instanceof e) == false) goto L48;
        r15 = (e) r115;
    L49:
        if (r15 != null) goto L41;
        return null;
    L48:
        r15 = null;
        goto L49
    L77:
        return null;
    L73:
        return null;
    L52:
        return r6;
    L23:
        Iterator<kotlin.s0.w.d.l0.g.f> r22 = r8.subList(1, r8.size()).iterator();
    L25:
        if (r22.hasNext() == false) goto L35;
        kotlin.s0.w.d.l0.g.f r23 = r22.next();
        if ((r6 instanceof e) == false) goto L22;
        kotlin.s0.w.d.l0.k.w.h r24 = ((e) r6).y0();
        kotlin.n0.d.o.e(r23, "name");
        h r25 = r24.f(r23, kotlin.s0.w.d.l0.d.b.d.w);
        if ((r25 instanceof e) == false) goto L32;
        r6 = (e) r25;
    L33:
        if (r6 == null) goto L22;
    L32:
        r6 = null;
        goto L33
    }

    public static final e c(h0 r1, kotlin.s0.w.d.l0.g.b r2, k0 r3) {
        kotlin.n0.d.o.f(r1, "<this>");
        kotlin.n0.d.o.f(r2, "classId");
        kotlin.n0.d.o.f(r3, "notFoundClasses");
        e r4 = a(r1, r2);
        if (r4 == null) goto L6;
        return r4;
    L6:
        return r3.d(r2, kotlin.t0.k.z(kotlin.t0.k.t(kotlin.t0.k.h(r2, a.f19172f), b.f19173f)));
    }

    public static final e1 d(h0 r1, kotlin.s0.w.d.l0.g.b r2) {
        kotlin.n0.d.o.f(r1, "<this>");
        kotlin.n0.d.o.f(r2, "classId");
        h r3 = b(r1, r2);
        if ((r3 instanceof e1) == true) goto L7;
        return null;
    L7:
        return (e1) r3;
    }
}
