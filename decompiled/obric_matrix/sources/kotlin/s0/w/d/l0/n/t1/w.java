package kotlin.s0.w.d.l0.n.t1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.s0.w.d.l0.n.a1;
import kotlin.s0.w.d.l0.n.b0;
import kotlin.s0.w.d.l0.n.d0;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.m0;
import kotlin.s0.w.d.l0.n.q0;
import kotlin.s0.w.d.l0.n.q1;
import kotlin.s0.w.d.l0.n.u0;

/* JADX INFO: loaded from: classes2.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f21111a = null;

    private static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f21112f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f21113g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f21114h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f21115i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ a[] f21116j = null;

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.n.t1.w$a$a, reason: collision with other inner class name */
        static final class C0580a extends a {
            C0580a(String r2, int r3) {
                super(r2, r3, null);
            }

            @Override // kotlin.s0.w.d.l0.n.t1.w.a
            public a b(q1 r2) {
                kotlin.n0.d.o.f(r2, "nextType");
                return c(r2);
            }
        }

        static final class b extends a {
            b(String r2, int r3) {
                super(r2, r3, null);
            }

            @Override // kotlin.s0.w.d.l0.n.t1.w.a
            public /* bridge */ /* synthetic */ a b(q1 r1) {
                g(r1);
                return this;
            }

            public b g(q1 r2) {
                kotlin.n0.d.o.f(r2, "nextType");
                return this;
            }
        }

        static final class c extends a {
            c(String r2, int r3) {
                super(r2, r3, null);
            }

            @Override // kotlin.s0.w.d.l0.n.t1.w.a
            public a b(q1 r2) {
                kotlin.n0.d.o.f(r2, "nextType");
                return c(r2);
            }
        }

        static final class d extends a {
            d(String r2, int r3) {
                super(r2, r3, null);
            }

            @Override // kotlin.s0.w.d.l0.n.t1.w.a
            public a b(q1 r2) {
                kotlin.n0.d.o.f(r2, "nextType");
                a r3 = c(r2);
                if (r3 != a.f21113g) goto L6;
                return this;
            L6:
                return r3;
            }
        }

        static {
            f21112f = new c("START", 0);
            f21113g = new C0580a("ACCEPT_NULL", 1);
            f21114h = new d("UNKNOWN", 2);
            f21115i = new b("NOT_NULL", 3);
            f21116j = a();
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public /* synthetic */ a(String r1, int r2, kotlin.n0.d.g r3) {
            this(r1, r2);
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{f21112f, f21113g, f21114h, f21115i};
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) f21116j.clone();
        }

        public abstract a b(q1 r1);

        protected final a c(q1 r1) {
            kotlin.n0.d.o.f(r1, "<this>");
            if (r1.P0() == false) goto L6;
            return f21113g;
        L6:
            if ((r1 instanceof kotlin.s0.w.d.l0.n.p) == false) goto L11;
            if ((((kotlin.s0.w.d.l0.n.p) r1).a1() instanceof u0) == false) goto L11;
        L17:
            return f21115i;
        L11:
            if ((r1 instanceof u0) == false) goto L14;
        L18:
            return f21114h;
        L14:
            if (o.f21105a.a(r1) == false) goto L18;
            goto L17
        }
    }

    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.a<String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Set<m0> f21117f;

        /* JADX WARN: Multi-variable type inference failed */
        b(Set<? extends m0> r1) {
            this.f21117f = r1;
            super(0);
        }

        public final String a() {
            return "This collections cannot be empty! input types: " + kotlin.i0.r.Z(this.f21117f, null, null, null, 0, null, null, 63, null);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ String invoke() {
            return a();
        }
    }

    /* synthetic */ class c extends kotlin.n0.d.l implements kotlin.n0.c.p<e0, e0, Boolean> {
        c(Object r2) {
            super(2, r2);
        }

        @Override // kotlin.n0.d.c, kotlin.s0.c
        public final String getName() {
            return "isStrictSupertype";
        }

        @Override // kotlin.n0.d.c
        public final kotlin.s0.f getOwner() {
            return kotlin.n0.d.e0.b(w.class);
        }

        @Override // kotlin.n0.d.c
        public final String getSignature() {
            return "isStrictSupertype(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Boolean invoke(e0 r1, e0 r2) {
            return m(r1, r2);
        }

        public final Boolean m(e0 r2, e0 r3) {
            kotlin.n0.d.o.f(r2, "p0");
            kotlin.n0.d.o.f(r3, "p1");
            return Boolean.valueOf(w.a((w) this.receiver, r2, r3));
        }
    }

    /* synthetic */ class d extends kotlin.n0.d.l implements kotlin.n0.c.p<e0, e0, Boolean> {
        d(Object r2) {
            super(2, r2);
        }

        @Override // kotlin.n0.d.c, kotlin.s0.c
        public final String getName() {
            return "equalTypes";
        }

        @Override // kotlin.n0.d.c
        public final kotlin.s0.f getOwner() {
            return kotlin.n0.d.e0.b(m.class);
        }

        @Override // kotlin.n0.d.c
        public final String getSignature() {
            return "equalTypes(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Boolean invoke(e0 r1, e0 r2) {
            return m(r1, r2);
        }

        public final Boolean m(e0 r2, e0 r3) {
            kotlin.n0.d.o.f(r2, "p0");
            kotlin.n0.d.o.f(r3, "p1");
            return Boolean.valueOf(((m) this.receiver).b(r2, r3));
        }
    }

    static {
        f21111a = new w();
    }

    private w() {
    }

    public static final /* synthetic */ boolean a(w r0, e0 r1, e0 r2) {
        return r0.e(r1, r2);
    }

    private final Collection<m0> b(Collection<? extends m0> r7, kotlin.n0.c.p<? super m0, ? super m0, Boolean> r8) {
        ArrayList r6 = new ArrayList(r7);
        Iterator r9 = r6.iterator();
        kotlin.n0.d.o.e(r9, "filteredTypes.iterator()");
    L4:
        if (r9.hasNext() == false) goto L20;
        m0 r0 = (m0) r9.next();
        boolean r2 = true;
        if (r6.isEmpty() == false) goto L8;
    L7:
        r2 = false;
    L18:
        if (r2 == false) goto L4;
        r9.remove();
        goto L4
    L8:
        Iterator r1 = r6.iterator();
    L10:
        if (r1.hasNext() == false) goto L7;
        m0 r4 = (m0) r1.next();
        if (r4 == r0) goto L16;
        kotlin.n0.d.o.e(r4, "lower");
        kotlin.n0.d.o.e(r0, "upper");
        if (r8.invoke(r4, r0).booleanValue() == false) goto L16;
        boolean r5 = true;
    L17:
        if (r5 == false) goto L10;
    L16:
        r5 = false;
        goto L17
    L20:
        return r6;
    }

    private final m0 d(Set<? extends m0> r4) {
        if (r4.size() == 1) goto L5;
        new b(r4);
        Collection<m0> r0 = b(r4, new c(this));
        r0.isEmpty();
        m0 r1 = kotlin.s0.w.d.l0.k.r.n.f20573f.b(r0);
        if (r1 == null) goto L9;
        return r1;
    L9:
        Collection<m0> r3 = b(r0, new d(l.f21099b.a()));
        r3.isEmpty();
        if (r3.size() >= 2) goto L14;
        return (m0) kotlin.i0.r.n0(r3);
    L14:
        return new d0(r4).h();
    L5:
        return (m0) kotlin.i0.r.n0(r4);
    }

    private final boolean e(e0 r2, e0 r3) {
        m r1 = l.f21099b.a();
        if (r1.d(r2, r3) == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.d(r3, r2) == true) goto L7;
        return true;
    }

    public final m0 c(List<? extends m0> r9) {
        kotlin.n0.d.o.f(r9, "types");
        r9.size();
        ArrayList r0 = new ArrayList();
        Iterator<? extends m0> r2 = r9.iterator();
    L4:
        if (r2.hasNext() == false) goto L16;
        m0 r3 = r2.next();
        if ((r3.O0() instanceof d0) == true) goto L7;
        r0.add(r3);
        goto L4
    L7:
        Collection<e0> r5 = r3.O0().a();
        kotlin.n0.d.o.e(r5, "type.constructor.supertypes");
        ArrayList r6 = new ArrayList(kotlin.i0.r.q(r5, 10));
        Iterator<T> r4 = r5.iterator();
    L9:
        if (r4.hasNext() == false) goto L14;
        e0 r7 = (e0) r4.next();
        kotlin.n0.d.o.e(r7, "it");
        m0 r8 = b0.d(r7);
        if (r3.P0() == false) goto L13;
        r8 = r8.V0(true);
    L13:
        r6.add(r8);
        goto L9
    L14:
        r0.addAll(r6);
        goto L4
    L16:
        a r10 = a.f21112f;
        Iterator r11 = r0.iterator();
    L18:
        if (r11.hasNext() == false) goto L20;
        r10 = r10.b((q1) r11.next());
        goto L18
    L20:
        LinkedHashSet r12 = new LinkedHashSet();
        Iterator r1 = r0.iterator();
    L22:
        if (r1.hasNext() == false) goto L30;
        m0 r13 = (m0) r1.next();
        if (r10 != a.f21115i) goto L29;
        if ((r13 instanceof i) == false) goto L28;
        r13 = q0.k((i) r13);
    L28:
        r13 = q0.i(r13, false, 1, null);
    L29:
        r12.add(r13);
        goto L22
    L30:
        ArrayList r14 = new ArrayList(kotlin.i0.r.q(r9, 10));
        Iterator<T> r15 = r9.iterator();
    L32:
        if (r15.hasNext() == false) goto L34;
        r14.add(((m0) r15.next()).N0());
        goto L32
    L34:
        Iterator r16 = r14.iterator();
        if (r16.hasNext() == false) goto L43;
        Object r17 = r16.next();
    L38:
        if (r16.hasNext() == false) goto L40;
        a1 r18 = (a1) r17;
        r17 = r18.n((a1) r16.next());
        goto L38
    L40:
        m0 r19 = d(r12);
        return r19.W0((a1) r17);
    L43:
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }
}
