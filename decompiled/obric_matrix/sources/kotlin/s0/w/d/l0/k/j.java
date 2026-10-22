package kotlin.s0.w.d.l0.k;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.f0;
import kotlin.i0.r;
import kotlin.s0.w.d.l0.c.d0;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.j1;
import kotlin.s0.w.d.l0.c.q;
import kotlin.s0.w.d.l0.c.q1.b0;
import kotlin.s0.w.d.l0.c.q1.c0;
import kotlin.s0.w.d.l0.c.t;
import kotlin.s0.w.d.l0.c.t0;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.c.x0;
import kotlin.s0.w.d.l0.c.y;
import kotlin.s0.w.d.l0.n.d1;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.e1;
import kotlin.s0.w.d.l0.n.g0;
import kotlin.u;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final List<kotlin.s0.w.d.l0.k.e> f20526e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final j f20527f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final kotlin.s0.w.d.l0.n.t1.e.a f20528g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.n.t1.g f20529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.n.t1.f f20530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.n.t1.e.a f20531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlin.n0.c.p<e0, e0, Boolean> f20532d;

    static class a implements kotlin.s0.w.d.l0.n.t1.e.a {
        a() {
        }

        private static /* synthetic */ void b(int r3) {
            Object[] r0 = new Object[3];
            if (r3 == 1) goto L5;
            r0[0] = "a";
        L6:
            r0[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$1";
            r0[2] = "equals";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r0));
        L5:
            r0[0] = "b";
            goto L6
        }

        @Override // kotlin.s0.w.d.l0.n.t1.e.a
        public boolean a(e1 r1, e1 r2) {
            if (r1 == null) goto L9;
            if (r2 != null) goto L6;
            b(1);
            throw null;
        L6:
            return r1.equals(r2);
        L9:
            b(0);
            throw null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [D] */
    static class b<D> implements kotlin.n0.c.p<D, D, u<kotlin.s0.w.d.l0.c.a, kotlin.s0.w.d.l0.c.a>> {
        b() {
        }

        /* JADX WARN: Incorrect types in method signature: (TD;TD;)Lkotlin/u<Lkotlin/s0/w/d/l0/c/a;Lkotlin/s0/w/d/l0/c/a;>; */
        public u a(kotlin.s0.w.d.l0.c.a r1, kotlin.s0.w.d.l0.c.a r2) {
            return new u(r1, r2);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ u<kotlin.s0.w.d.l0.c.a, kotlin.s0.w.d.l0.c.a> invoke(Object r1, Object r2) {
            return a((kotlin.s0.w.d.l0.c.a) r1, (kotlin.s0.w.d.l0.c.a) r2);
        }
    }

    static class c implements kotlin.n0.c.l<kotlin.s0.w.d.l0.c.b, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.c.m f20533f;

        c(kotlin.s0.w.d.l0.c.m r1) {
            this.f20533f = r1;
        }

        public Boolean a(kotlin.s0.w.d.l0.c.b r1) {
            if (r1.c() != this.f20533f) goto L5;
            boolean r0 = true;
        L7:
            return Boolean.valueOf(r0);
        L5:
            r0 = false;
            goto L7
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(kotlin.s0.w.d.l0.c.b r1) {
            return a(r1);
        }
    }

    static class d implements kotlin.n0.c.l<kotlin.s0.w.d.l0.c.b, kotlin.s0.w.d.l0.c.a> {
        d() {
        }

        public kotlin.s0.w.d.l0.c.b a(kotlin.s0.w.d.l0.c.b r1) {
            return r1;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.a invoke(kotlin.s0.w.d.l0.c.b r1) {
            kotlin.s0.w.d.l0.c.b r2 = r1;
            a(r2);
            return r2;
        }
    }

    static class e implements kotlin.n0.c.l<kotlin.s0.w.d.l0.c.b, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.c.e f20534f;

        e(kotlin.s0.w.d.l0.c.e r1) {
            this.f20534f = r1;
        }

        public Boolean a(kotlin.s0.w.d.l0.c.b r3) {
            boolean r1 = false;
            if (t.g(r3.getVisibility()) == true) goto L8;
            if (t.h(r3, this.f20534f, false) == false) goto L8;
            r1 = true;
        L8:
            return Boolean.valueOf(r1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(kotlin.s0.w.d.l0.c.b r1) {
            return a(r1);
        }
    }

    static class f implements kotlin.n0.c.l<kotlin.s0.w.d.l0.c.b, kotlin.s0.w.d.l0.c.a> {
        f() {
        }

        public kotlin.s0.w.d.l0.c.a a(kotlin.s0.w.d.l0.c.b r1) {
            return r1;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.a invoke(kotlin.s0.w.d.l0.c.b r1) {
            kotlin.s0.w.d.l0.c.b r2 = r1;
            a(r2);
            return r2;
        }
    }

    static class g implements kotlin.n0.c.l<kotlin.s0.w.d.l0.c.b, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.k.i f20535f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.c.b f20536g;

        g(kotlin.s0.w.d.l0.k.i r1, kotlin.s0.w.d.l0.c.b r2) {
            this.f20535f = r1;
            this.f20536g = r2;
        }

        public f0 a(kotlin.s0.w.d.l0.c.b r2) {
            this.f20535f.b(this.f20536g, r2);
            return f0.f18324a;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(kotlin.s0.w.d.l0.c.b r1) {
            return a(r1);
        }
    }

    static /* synthetic */ class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f20537a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f20538b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f20539c = null;

        static {
            int[] r0 = new int[kotlin.s0.w.d.l0.c.e0.values().length];
            f20539c = r0;
            r0[kotlin.s0.w.d.l0.c.e0.f18860g.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L33:
            f20539c[kotlin.s0.w.d.l0.c.e0.f18861h.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L39:
            f20539c[kotlin.s0.w.d.l0.c.e0.f18862i.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L51:
            f20539c[kotlin.s0.w.d.l0.c.e0.f18863j.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L10:
            int[] r4 = new int[i.a.values().length];
            f20538b = r4;
            r4[i.a.f20542f.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L35:
            f20538b[i.a.f20544h.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L37:
            f20538b[i.a.f20543g.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L14:
            int[] r5 = new int[kotlin.s0.w.d.l0.k.e.b.values().length];
            f20537a = r5;
            r5[kotlin.s0.w.d.l0.k.e.b.f20519f.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L49:
            f20537a[kotlin.s0.w.d.l0.k.e.b.f20520g.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L31:
            f20537a[kotlin.s0.w.d.l0.k.e.b.f20521h.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
        L45:
            f20537a[kotlin.s0.w.d.l0.k.e.b.f20522i.ordinal()] = 4;     // Catch: NoSuchFieldError -> L30
            return;
        }
    }

    public static class i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final i f20540b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a f20541a;

        public static final enum a extends Enum<a> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final a f20542f = null;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final a f20543g = null;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public static final a f20544h = null;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private static final /* synthetic */ a[] f20545i = null;

            static {
                a r0 = new a("OVERRIDABLE", 0);
                f20542f = r0;
                a r1 = new a("INCOMPATIBLE", 1);
                f20543g = r1;
                a r3 = new a("CONFLICT", 2);
                f20544h = r3;
                f20545i = new a[]{r0, r1, r3};
            }

            private a(String r1, int r2) {
                super(r1, r2);
            }

            public static a valueOf(String r1) {
                return (a) Enum.valueOf(a.class, r1);
            }

            public static a[] values() {
                return (a[]) f20545i.clone();
            }
        }

        static {
            f20540b = new i(a.f20542f, "SUCCESS");
        }

        public i(a r2, String r3) {
            if (r2 == null) goto L9;
            if (r3 == null) goto L7;
            this.f20541a = r2;
            return;
        L7:
            a(4);
            throw null;
        L9:
            a(3);
            throw null;
        }

        private static /* synthetic */ void a(int r10) {
            if (r10 == 1) goto L8;
            if (r10 == 2) goto L8;
            if (r10 == 3) goto L8;
            if (r10 == 4) goto L8;
            String r4 = "@NotNull method %s.%s must not return null";
        L9:
            if (r10 == 1) goto L14;
            if (r10 == 2) goto L14;
            if (r10 == 3) goto L14;
            if (r10 == 4) goto L14;
            int r5 = 2;
        L15:
            Object[] r6 = new Object[r5];
            if (r10 == 1) goto L22;
            if (r10 == 2) goto L22;
            if (r10 == 3) goto L21;
            if (r10 == 4) goto L22;
            r6[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
        L23:
            switch(r10) {
                case 1: goto L27;
                case 2: goto L27;
                case 3: goto L27;
                case 4: goto L27;
                case 5: goto L26;
                case 6: goto L25;
                default: goto L24;
            };
        L24:
            r6[1] = "success";
        L28:
            if (r10 == 1) goto L35;
            if (r10 == 2) goto L34;
            if (r10 == 3) goto L33;
            if (r10 == 4) goto L33;
        L36:
            String r7 = String.format(r4, r6);
            if (r10 == 1) goto L43;
            if (r10 == 2) goto L43;
            if (r10 == 3) goto L43;
            if (r10 == 4) goto L43;
            throw new IllegalStateException(r7);
        L43:
            throw new IllegalArgumentException(r7);
        L33:
            r6[2] = "<init>";
            goto L36
        L34:
            r6[2] = "conflict";
            goto L36
        L35:
            r6[2] = "incompatible";
            goto L36
        L25:
            r6[1] = "getDebugMessage";
            goto L28
        L26:
            r6[1] = "getResult";
            goto L28
        L27:
            r6[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
            goto L28
        L21:
            r6[0] = "success";
        L22:
            r6[0] = "debugMessage";
        L14:
            r5 = 3;
        L8:
            r4 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            goto L9
        }

        public static i b(String r2) {
            if (r2 != null) goto L4;
            a(2);
            throw null;
        L4:
            return new i(a.f20544h, r2);
        }

        public static i d(String r2) {
            if (r2 != null) goto L4;
            a(1);
            throw null;
        L4:
            return new i(a.f20543g, r2);
        }

        public static i e() {
            i r0 = f20540b;
            if (r0 == null) goto L5;
            return r0;
        L5:
            a(0);
            throw null;
        }

        public a c() {
            a r0 = this.f20541a;
            if (r0 == null) goto L5;
            return r0;
        L5:
            a(5);
            throw null;
        }
    }

    static {
        f20526e = r.z0(ServiceLoader.load(kotlin.s0.w.d.l0.k.e.class, kotlin.s0.w.d.l0.k.e.class.getClassLoader()));
        a r0 = new a();
        f20528g = r0;
        f20527f = new j(r0, kotlin.s0.w.d.l0.n.t1.g.a.f21080a, kotlin.s0.w.d.l0.n.t1.f.a.f21079a, null);
    }

    private j(kotlin.s0.w.d.l0.n.t1.e.a r2, kotlin.s0.w.d.l0.n.t1.g r3, kotlin.s0.w.d.l0.n.t1.f r4, kotlin.n0.c.p<e0, e0, Boolean> r5) {
        if (r2 == null) goto L12;
        if (r3 == null) goto L10;
        if (r4 == null) goto L8;
        this.f20531c = r2;
        this.f20529a = r3;
        this.f20530b = r4;
        this.f20532d = r5;
        return;
    L8:
        a(7);
        throw null;
    L10:
        a(6);
        throw null;
    L12:
        a(5);
        throw null;
    }

    private static boolean A(t0 r0, t0 r1) {
        if (r0 == null) goto L7;
        if (r1 != null) goto L6;
        return true;
    L6:
        return H(r0, r1);
    L7:
        return true;
    }

    public static boolean B(kotlin.s0.w.d.l0.c.a r8, kotlin.s0.w.d.l0.c.a r9) {
        if (r8 == null) goto L35;
        if (r9 == null) goto L33;
        e0 r0 = r8.getReturnType();
        e0 r1 = r9.getReturnType();
        if (H(r8, r9) == true) goto L8;
        return false;
    L8:
        d1 r2 = f20527f.l(r8.getTypeParameters(), r9.getTypeParameters());
        if ((r8 instanceof y) == false) goto L13;
        return G(r8, r0, r9, r1, r2);
    L13:
        if ((r8 instanceof u0) == false) goto L32;
        u0 r4 = (u0) r8;
        u0 r5 = (u0) r9;
        if (A(r4.Y(), r5.Y()) == true) goto L18;
        return false;
    L18:
        if (r4.j0() == false) goto L24;
        if (r5.j0() == false) goto L24;
        return kotlin.s0.w.d.l0.n.f.f20979a.k(r2, r0.R0(), r1.R0());
    L24:
        if (r4.j0() == true) goto L28;
        if (r5.j0() == false) goto L28;
        return false;
    L28:
        if (G(r8, r0, r9, r1, r2) == false) goto L38;
        return true;
    L38:
        return false;
    L32:
        throw new IllegalArgumentException("Unexpected callable: " + r8.getClass());
    L33:
        a(68);
        throw null;
    L35:
        a(67);
        throw null;
    }

    private static boolean C(kotlin.s0.w.d.l0.c.a r1, Collection<kotlin.s0.w.d.l0.c.a> r2) {
        if (r1 == null) goto L16;
        if (r2 == null) goto L14;
        Iterator<kotlin.s0.w.d.l0.c.a> r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L12;
        if (B(r1, r3.next()) == true) goto L7;
        return false;
    L12:
        return true;
    L14:
        a(72);
        throw null;
    L16:
        a(71);
        throw null;
    }

    private static boolean G(kotlin.s0.w.d.l0.c.a r1, e0 r2, kotlin.s0.w.d.l0.c.a r3, e0 r4, d1 r5) {
        if (r1 == null) goto L18;
        if (r2 == null) goto L16;
        if (r3 == null) goto L14;
        if (r4 == null) goto L12;
        if (r5 != null) goto L9;
        a(77);
        throw null;
    L9:
        return kotlin.s0.w.d.l0.n.f.f20979a.r(r5, r2.R0(), r4.R0());
    L12:
        a(76);
        throw null;
    L14:
        a(75);
        throw null;
    L16:
        a(74);
        throw null;
    L18:
        a(73);
        throw null;
    }

    private static boolean H(q r1, q r2) {
        if (r1 == null) goto L15;
        if (r2 == null) goto L13;
        Integer r3 = t.d(r1.getVisibility(), r2.getVisibility());
        if (r3 != null) goto L8;
    L11:
        return true;
    L8:
        if (r3.intValue() >= 0) goto L11;
        return false;
    L13:
        a(70);
        throw null;
    L15:
        a(69);
        throw null;
    }

    public static boolean I(d0 r1, d0 r2, boolean r3) {
        if (r1 == null) goto L14;
        if (r2 != null) goto L6;
        a(58);
        throw null;
    L6:
        if (t.g(r2.getVisibility()) == false) goto L8;
    L10:
        return false;
    L8:
        if (t.h(r2, r1, r3) == false) goto L10;
        return true;
    L14:
        a(57);
        throw null;
    }

    public static <D extends kotlin.s0.w.d.l0.c.a> boolean J(D r4, D r5, boolean r6, boolean r7) {
        if (r4 == null) goto L20;
        if (r5 != null) goto L6;
        a(14);
        throw null;
    L6:
        if (r4.equals(r5) == false) goto L8;
    L10:
        kotlin.s0.w.d.l0.c.a r8 = r5.a();
        Iterator r9 = kotlin.s0.w.d.l0.k.d.d(r4).iterator();
    L12:
        if (r9.hasNext() == false) goto L16;
        kotlin.s0.w.d.l0.c.a r0 = (kotlin.s0.w.d.l0.c.a) r9.next();
        if (kotlin.s0.w.d.l0.k.b.f20507a.d(r8, r0, r6, r7) == false) goto L12;
        return true;
    L16:
        return false;
    L8:
        if (kotlin.s0.w.d.l0.k.b.f20507a.d(r4.a(), r5.a(), r6, r7) == false) goto L10;
        return true;
    L20:
        a(13);
        throw null;
    }

    public static void K(kotlin.s0.w.d.l0.c.b r5, kotlin.n0.c.l<kotlin.s0.w.d.l0.c.b, f0> r6) {
        if (r5 == null) goto L36;
        Iterator<? extends kotlin.s0.w.d.l0.c.b> r1 = r5.f().iterator();
    L6:
        if (r1.hasNext() == false) goto L11;
        kotlin.s0.w.d.l0.c.b r2 = r1.next();
        if (r2.getVisibility() != t.f19165g) goto L6;
        K(r2, r6);
        goto L6
    L11:
        if (r5.getVisibility() == t.f19165g) goto L13;
        return;
    L13:
        kotlin.s0.w.d.l0.c.u r3 = h(r5);
        if (r3 != null) goto L18;
        if (r6 == null) goto L17;
        r6.invoke(r5);
    L17:
        kotlin.s0.w.d.l0.c.u r4 = t.f19163e;
    L20:
        if ((r5 instanceof c0) == false) goto L30;
        ((c0) r5).d1(r4);
        Iterator<t0> r7 = ((u0) r5).v().iterator();
    L23:
        if (r7.hasNext() == false) goto L48;
        t0 r8 = r7.next();
        if (r3 != null) goto L27;
        kotlin.n0.c.l<kotlin.s0.w.d.l0.c.b, f0> r9 = null;
    L28:
        K(r8, r9);
        goto L23
    L27:
        r9 = r6;
        goto L28
    L48:
        return;
    L30:
        if ((r5 instanceof kotlin.s0.w.d.l0.c.q1.p) == false) goto L32;
        ((kotlin.s0.w.d.l0.c.q1.p) r5).k1(r4);
        return;
    L32:
        b0 r10 = (b0) r5;
        r10.P0(r4);
        if (r4 == r10.B0().getVisibility()) goto L47;
        r10.N0(false);
        return;
    L47:
        return;
    L18:
        r4 = r3;
        goto L20
    L36:
        a(107);
        throw null;
    }

    public static <H> H L(Collection<H> r9, kotlin.n0.c.l<H, kotlin.s0.w.d.l0.c.a> r10) {
        if (r9 == null) goto L55;
        if (r10 != null) goto L6;
        a(79);
        throw null;
    L6:
        if (r9.size() != 1) goto L12;
        H r11 = (H) r.O(r9);
        if (r11 == null) goto L10;
        return r11;
    L10:
        a(80);
        throw null;
    L12:
        ArrayList r1 = new ArrayList(2);
        List r3 = r.e0(r9, r10);
        H r4 = (H) r.O(r9);
        kotlin.s0.w.d.l0.c.a r5 = r10.invoke(r4);
        Iterator<H> r12 = r9.iterator();
    L14:
        if (r12.hasNext() == false) goto L24;
        H r6 = r12.next();
        kotlin.s0.w.d.l0.c.a r7 = r10.invoke(r6);
        if (C(r7, r3) == false) goto L19;
        r1.add(r6);
    L19:
        if (B(r7, r5) == false) goto L14;
        if (B(r5, r7) == true) goto L14;
        r4 = r6;
        goto L14
    L24:
        if (r1.isEmpty() == false) goto L30;
        if (r4 == null) goto L27;
        return r4;
    L27:
        a(81);
        throw null;
    L30:
        if (r1.size() != 1) goto L36;
        H r13 = (H) r.O(r1);
        if (r13 == null) goto L34;
        return r13;
    L34:
        a(82);
        throw null;
    L36:
        Iterator r14 = r1.iterator();
    L38:
        if (r14.hasNext() == false) goto L42;
        H r2 = (H) r14.next();
        if (kotlin.s0.w.d.l0.n.b0.b(r10.invoke(r2).getReturnType()) == true) goto L38;
    L43:
        if (r2 == null) goto L48;
        if (r2 == null) goto L46;
        return r2;
    L46:
        a(83);
        throw null;
    L48:
        H r15 = (H) r.O(r1);
        if (r15 == null) goto L51;
        return r15;
    L51:
        a(84);
        throw null;
    L42:
        r2 = null;
        goto L43
    L55:
        a(78);
        throw null;
    }

    private static /* synthetic */ void a(int r24) {
        if (r24 == 11) goto L17;
        if (r24 == 12) goto L17;
        if (r24 == 16) goto L17;
        if (r24 == 21) goto L17;
        if (r24 == 95) goto L17;
        if (r24 == 98) goto L17;
        if (r24 == 103) goto L17;
        if (r24 == 44) goto L17;
        if (r24 == 45) goto L17;
        switch(r24) {
            case 24: goto L17;
            case 25: goto L17;
            case 26: goto L17;
            case 27: goto L17;
            case 28: goto L17;
            case 29: goto L17;
            default: goto L13;
        };
    L13:
        switch(r24) {
            case 32: goto L17;
            case 33: goto L17;
            case 34: goto L17;
            case 35: goto L17;
            case 36: goto L17;
            case 37: goto L17;
            case 38: goto L17;
            case 39: goto L17;
            default: goto L14;
        };
    L14:
        switch(r24) {
            case 80: goto L17;
            case 81: goto L17;
            case 82: goto L17;
            case 83: goto L17;
            case 84: goto L17;
            default: goto L15;
        };
    L15:
        switch(r24) {
            case 90: goto L17;
            case 91: goto L17;
            case 92: goto L17;
            default: goto L16;
        };
    L16:
        String r10 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L19:
        if (r24 == 11) goto L33;
        if (r24 == 12) goto L157;
        if (r24 == 16) goto L158;
        if (r24 == 21) goto L159;
        if (r24 == 95) goto L160;
        if (r24 == 98) goto L161;
        if (r24 == 103) goto L162;
        if (r24 == 44) goto L163;
        if (r24 == 45) goto L164;
        switch(r24) {
            case 24: goto L165;
            case 25: goto L165;
            case 26: goto L165;
            case 27: goto L165;
            case 28: goto L165;
            case 29: goto L165;
            default: goto L29;
        };
    L29:
        switch(r24) {
            case 32: goto L166;
            case 33: goto L166;
            case 34: goto L166;
            case 35: goto L166;
            case 36: goto L166;
            case 37: goto L166;
            case 38: goto L166;
            case 39: goto L166;
            default: goto L30;
        };
    L30:
        switch(r24) {
            case 80: goto L167;
            case 81: goto L167;
            case 82: goto L167;
            case 83: goto L167;
            case 84: goto L167;
            default: goto L31;
        };
    L31:
        switch(r24) {
            case 90: goto L168;
            case 91: goto L168;
            case 92: goto L168;
            default: goto L32;
        };
    L32:
        int r12 = 3;
    L34:
        Object[] r13 = new Object[r12];
        switch(r24) {
            case 1: goto L80;
            case 2: goto L79;
            case 3: goto L36;
            case 4: goto L78;
            case 5: goto L77;
            case 6: goto L36;
            case 7: goto L80;
            case 8: goto L76;
            case 9: goto L76;
            case 10: goto L75;
            case 11: goto L74;
            case 12: goto L74;
            case 13: goto L73;
            case 14: goto L72;
            case 15: goto L71;
            case 16: goto L74;
            case 17: goto L71;
            case 18: goto L70;
            case 19: goto L69;
            case 20: goto L68;
            case 21: goto L74;
            case 22: goto L69;
            case 23: goto L68;
            case 24: goto L74;
            case 25: goto L74;
            case 26: goto L74;
            case 27: goto L74;
            case 28: goto L74;
            case 29: goto L74;
            case 30: goto L69;
            case 31: goto L68;
            case 32: goto L74;
            case 33: goto L74;
            case 34: goto L74;
            case 35: goto L74;
            case 36: goto L74;
            case 37: goto L74;
            case 38: goto L74;
            case 39: goto L74;
            case 40: goto L69;
            case 41: goto L68;
            case 42: goto L67;
            case 43: goto L66;
            case 44: goto L74;
            case 45: goto L74;
            case 46: goto L65;
            case 47: goto L64;
            case 48: goto L63;
            case 49: goto L62;
            case 50: goto L61;
            case 51: goto L63;
            case 52: goto L60;
            case 53: goto L59;
            case 54: goto L58;
            case 55: goto L57;
            case 56: goto L56;
            case 57: goto L55;
            case 58: goto L54;
            case 59: goto L53;
            case 60: goto L52;
            case 61: goto L57;
            case 62: goto L56;
            case 63: goto L51;
            case 64: goto L57;
            case 65: goto L51;
            case 66: goto L56;
            case 67: goto L50;
            case 68: goto L49;
            case 69: goto L50;
            case 70: goto L49;
            case 71: goto L48;
            case 72: goto L47;
            case 73: goto L50;
            case 74: goto L46;
            case 75: goto L49;
            case 76: goto L45;
            case 77: goto L63;
            case 78: goto L44;
            case 79: goto L43;
            case 80: goto L74;
            case 81: goto L74;
            case 82: goto L74;
            case 83: goto L74;
            case 84: goto L74;
            case 85: goto L44;
            case 86: goto L57;
            case 87: goto L56;
            case 88: goto L47;
            case 89: goto L57;
            case 90: goto L74;
            case 91: goto L74;
            case 92: goto L74;
            case 93: goto L47;
            case 94: goto L42;
            case 95: goto L74;
            case 96: goto L57;
            case 97: goto L41;
            case 98: goto L74;
            case 99: goto L40;
            case 100: goto L39;
            case 101: goto L43;
            case 102: goto L38;
            case 103: goto L74;
            case 104: goto L40;
            case 105: goto L39;
            case 106: goto L56;
            case 107: goto L37;
            case 108: goto L37;
            case 109: goto L47;
            default: goto L36;
        };
    L36:
        r13[0] = "kotlinTypeRefiner";
    L82:
        if (r24 == 11) goto L105;
        if (r24 == 12) goto L105;
        if (r24 == 16) goto L104;
        if (r24 == 21) goto L103;
        if (r24 == 95) goto L102;
        if (r24 == 98) goto L101;
        if (r24 == 103) goto L100;
        if (r24 == 44) goto L99;
        if (r24 == 45) goto L99;
        switch(r24) {
            case 24: goto L103;
            case 25: goto L103;
            case 26: goto L103;
            case 27: goto L103;
            case 28: goto L103;
            case 29: goto L103;
            default: goto L92;
        };
    L92:
        switch(r24) {
            case 32: goto L98;
            case 33: goto L98;
            case 34: goto L98;
            case 35: goto L98;
            case 36: goto L98;
            case 37: goto L98;
            case 38: goto L98;
            case 39: goto L98;
            default: goto L93;
        };
    L93:
        switch(r24) {
            case 80: goto L97;
            case 81: goto L97;
            case 82: goto L97;
            case 83: goto L97;
            case 84: goto L97;
            default: goto L94;
        };
    L94:
        switch(r24) {
            case 90: goto L96;
            case 91: goto L96;
            case 92: goto L96;
            default: goto L95;
        };
    L95:
        r13[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
    L106:
        switch(r24) {
            case 1: goto L139;
            case 2: goto L139;
            case 3: goto L138;
            case 4: goto L138;
            case 5: goto L137;
            case 6: goto L137;
            case 7: goto L137;
            case 8: goto L136;
            case 9: goto L135;
            case 10: goto L135;
            case 11: goto L140;
            case 12: goto L140;
            case 13: goto L134;
            case 14: goto L134;
            case 15: goto L133;
            case 16: goto L140;
            case 17: goto L132;
            case 18: goto L132;
            case 19: goto L131;
            case 20: goto L131;
            case 21: goto L140;
            case 22: goto L131;
            case 23: goto L131;
            case 24: goto L140;
            case 25: goto L140;
            case 26: goto L140;
            case 27: goto L140;
            case 28: goto L140;
            case 29: goto L140;
            case 30: goto L130;
            case 31: goto L130;
            case 32: goto L140;
            case 33: goto L140;
            case 34: goto L140;
            case 35: goto L140;
            case 36: goto L140;
            case 37: goto L140;
            case 38: goto L140;
            case 39: goto L140;
            case 40: goto L129;
            case 41: goto L129;
            case 42: goto L128;
            case 43: goto L128;
            case 44: goto L140;
            case 45: goto L140;
            case 46: goto L127;
            case 47: goto L127;
            case 48: goto L127;
            case 49: goto L126;
            case 50: goto L126;
            case 51: goto L126;
            case 52: goto L125;
            case 53: goto L125;
            case 54: goto L125;
            case 55: goto L125;
            case 56: goto L125;
            case 57: goto L124;
            case 58: goto L124;
            case 59: goto L123;
            case 60: goto L123;
            case 61: goto L123;
            case 62: goto L123;
            case 63: goto L122;
            case 64: goto L121;
            case 65: goto L121;
            case 66: goto L121;
            case 67: goto L120;
            case 68: goto L120;
            case 69: goto L119;
            case 70: goto L119;
            case 71: goto L118;
            case 72: goto L118;
            case 73: goto L117;
            case 74: goto L117;
            case 75: goto L117;
            case 76: goto L117;
            case 77: goto L117;
            case 78: goto L116;
            case 79: goto L116;
            case 80: goto L140;
            case 81: goto L140;
            case 82: goto L140;
            case 83: goto L140;
            case 84: goto L140;
            case 85: goto L115;
            case 86: goto L115;
            case 87: goto L115;
            case 88: goto L114;
            case 89: goto L114;
            case 90: goto L140;
            case 91: goto L140;
            case 92: goto L140;
            case 93: goto L113;
            case 94: goto L113;
            case 95: goto L140;
            case 96: goto L112;
            case 97: goto L112;
            case 98: goto L140;
            case 99: goto L111;
            case 100: goto L111;
            case 101: goto L111;
            case 102: goto L111;
            case 103: goto L140;
            case 104: goto L111;
            case 105: goto L111;
            case 106: goto L111;
            case 107: goto L110;
            case 108: goto L109;
            case 109: goto L108;
            default: goto L107;
        };
    L107:
        r13[2] = "createWithTypeRefiner";
        goto L140
    L108:
        r13[2] = "findMaxVisibility";
        goto L140
    L109:
        r13[2] = "computeVisibilityToInherit";
        goto L140
    L110:
        r13[2] = "resolveUnknownVisibilityForMember";
        goto L140
    L111:
        r13[2] = "extractMembersOverridableInBothWays";
        goto L140
    L112:
        r13[2] = "filterVisibleFakeOverrides";
        goto L140
    L113:
        r13[2] = "getMinimalModality";
        goto L140
    L114:
        r13[2] = "determineModalityForFakeOverride";
        goto L140
    L115:
        r13[2] = "createAndBindFakeOverride";
        goto L140
    L116:
        r13[2] = "selectMostSpecificMember";
        goto L140
    L117:
        r13[2] = "isReturnTypeMoreSpecific";
        goto L140
    L118:
        r13[2] = "isMoreSpecificThenAllOf";
        goto L140
    L119:
        r13[2] = "isVisibilityMoreSpecific";
        goto L140
    L120:
        r13[2] = "isMoreSpecific";
        goto L140
    L121:
        r13[2] = "createAndBindFakeOverrides";
        goto L140
    L122:
        r13[2] = "allHasSameContainingDeclaration";
        goto L140
    L123:
        r13[2] = "extractAndBindOverridesForMember";
        goto L140
    L124:
        r13[2] = "isVisibleForOverride";
        goto L140
    L125:
        r13[2] = "generateOverridesInFunctionGroup";
        goto L140
    L126:
        r13[2] = "areTypeParametersEquivalent";
        goto L140
    L127:
        r13[2] = "areTypesEquivalent";
        goto L140
    L128:
        r13[2] = "createTypeCheckerState";
        goto L140
    L129:
        r13[2] = "getBasicOverridabilityProblem";
        goto L140
    L130:
        r13[2] = "isOverridableByWithoutExternalConditions";
        goto L140
    L131:
        r13[2] = "isOverridableBy";
        goto L140
    L132:
        r13[2] = "collectOverriddenDeclarations";
        goto L140
    L133:
        r13[2] = "getOverriddenDeclarations";
        goto L140
    L134:
        r13[2] = "overrides";
        goto L140
    L135:
        r13[2] = "filterOverrides";
        goto L140
    L136:
        r13[2] = "filterOutOverridden";
        goto L140
    L137:
        r13[2] = "<init>";
        goto L140
    L138:
        r13[2] = "create";
        goto L140
    L139:
        r13[2] = "createWithTypePreparatorAndCustomSubtype";
    L140:
        String r11 = String.format(r10, r13);
        if (r24 == 11) goto L156;
        if (r24 == 12) goto L156;
        if (r24 == 16) goto L156;
        if (r24 == 21) goto L156;
        if (r24 == 95) goto L156;
        if (r24 == 98) goto L156;
        if (r24 == 103) goto L156;
        if (r24 == 44) goto L156;
        if (r24 == 45) goto L156;
        switch(r24) {
            case 24: goto L156;
            case 25: goto L156;
            case 26: goto L156;
            case 27: goto L156;
            case 28: goto L156;
            case 29: goto L156;
            default: goto L151;
        };
    L151:
        switch(r24) {
            case 32: goto L156;
            case 33: goto L156;
            case 34: goto L156;
            case 35: goto L156;
            case 36: goto L156;
            case 37: goto L156;
            case 38: goto L156;
            case 39: goto L156;
            default: goto L152;
        };
    L152:
        switch(r24) {
            case 80: goto L156;
            case 81: goto L156;
            case 82: goto L156;
            case 83: goto L156;
            case 84: goto L156;
            default: goto L153;
        };
    L153:
        switch(r24) {
            case 90: goto L156;
            case 91: goto L156;
            case 92: goto L156;
            default: goto L169;
        };
    L169:
        throw new IllegalArgumentException(r11);
    L156:
        throw new IllegalStateException(r11);
    L96:
        r13[1] = "determineModalityForFakeOverride";
        goto L106
    L97:
        r13[1] = "selectMostSpecificMember";
        goto L106
    L98:
        r13[1] = "isOverridableByWithoutExternalConditions";
    L99:
        r13[1] = "createTypeCheckerState";
        goto L106
    L100:
        r13[1] = "extractMembersOverridableInBothWays";
        goto L106
    L101:
        r13[1] = "filterVisibleFakeOverrides";
        goto L106
    L102:
        r13[1] = "getMinimalModality";
    L103:
        r13[1] = "isOverridableBy";
        goto L106
    L104:
        r13[1] = "getOverriddenDeclarations";
    L105:
        r13[1] = "filterOverrides";
        goto L106
    L37:
        r13[0] = "memberDescriptor";
        goto L82
    L38:
        r13[0] = "onConflict";
        goto L82
    L39:
        r13[0] = "extractFrom";
        goto L82
    L40:
        r13[0] = "overrider";
        goto L82
    L41:
        r13[0] = "toFilter";
        goto L82
    L42:
        r13[0] = "classModality";
        goto L82
    L43:
        r13[0] = "descriptorByHandle";
        goto L82
    L44:
        r13[0] = "overridables";
        goto L82
    L45:
        r13[0] = "bReturnType";
        goto L82
    L46:
        r13[0] = "aReturnType";
        goto L82
    L47:
        r13[0] = "descriptors";
        goto L82
    L48:
        r13[0] = "candidate";
        goto L82
    L49:
        r13[0] = "b";
        goto L82
    L50:
        r13[0] = "a";
        goto L82
    L51:
        r13[0] = "notOverridden";
        goto L82
    L52:
        r13[0] = "descriptorsFromSuper";
        goto L82
    L53:
        r13[0] = "fromCurrent";
        goto L82
    L54:
        r13[0] = "fromSuper";
        goto L82
    L55:
        r13[0] = "overriding";
        goto L82
    L56:
        r13[0] = "strategy";
        goto L82
    L57:
        r13[0] = "current";
        goto L82
    L58:
        r13[0] = "membersFromCurrent";
        goto L82
    L59:
        r13[0] = "membersFromSupertypes";
        goto L82
    L60:
        r13[0] = "name";
        goto L82
    L61:
        r13[0] = "subTypeParameter";
        goto L82
    L62:
        r13[0] = "superTypeParameter";
        goto L82
    L63:
        r13[0] = "typeCheckerState";
        goto L82
    L64:
        r13[0] = "typeInSub";
        goto L82
    L65:
        r13[0] = "typeInSuper";
        goto L82
    L66:
        r13[0] = "secondParameters";
        goto L82
    L67:
        r13[0] = "firstParameters";
        goto L82
    L68:
        r13[0] = "subDescriptor";
        goto L82
    L69:
        r13[0] = "superDescriptor";
        goto L82
    L70:
        r13[0] = "result";
        goto L82
    L71:
        r13[0] = "descriptor";
        goto L82
    L72:
        r13[0] = "g";
        goto L82
    L73:
        r13[0] = "f";
        goto L82
    L74:
        r13[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
        goto L82
    L75:
        r13[0] = "transformFirst";
        goto L82
    L76:
        r13[0] = "candidateSet";
        goto L82
    L77:
        r13[0] = "axioms";
        goto L82
    L78:
        r13[0] = "equalityAxioms";
        goto L82
    L79:
        r13[0] = "customSubtype";
        goto L82
    L80:
        r13[0] = "kotlinTypePreparator";
        goto L82
    L168:
        r12 = 2;
        goto L34
    L167:
        r12 = 2;
        goto L34
    L166:
        r12 = 2;
        goto L34
    L165:
        r12 = 2;
        goto L34
    L164:
        r12 = 2;
        goto L34
    L163:
        r12 = 2;
        goto L34
    L162:
        r12 = 2;
        goto L34
    L161:
        r12 = 2;
        goto L34
    L160:
        r12 = 2;
        goto L34
    L159:
        r12 = 2;
        goto L34
    L158:
        r12 = 2;
        goto L34
    L157:
        r12 = 2;
        goto L34
    L33:
        r12 = 2;
    L17:
        r10 = "@NotNull method %s.%s must not return null";
        goto L19
    }

    private static boolean b(Collection<kotlin.s0.w.d.l0.c.b> r2) {
        if (r2 != null) goto L4;
        a(63);
        throw null;
    L4:
        if (r2.size() >= 2) goto L8;
        return true;
    L8:
        return r.H(r2, new c(r2.iterator().next().c()));
    }

    private static boolean c(f1 r4, f1 r5, d1 r6) {
        if (r4 == null) goto L25;
        if (r5 == null) goto L23;
        if (r6 == null) goto L21;
        List<e0> r7 = r4.getUpperBounds();
        ArrayList r0 = new ArrayList(r5.getUpperBounds());
        if (r7.size() == r0.size()) goto L9;
        return false;
    L9:
        Iterator<e0> r8 = r7.iterator();
    L11:
        if (r8.hasNext() == false) goto L19;
        e0 r9 = r8.next();
        ListIterator r1 = r0.listIterator();
    L14:
        if (r1.hasNext() == false) goto L18;
        if (d(r9, (e0) r1.next(), r6) == false) goto L14;
        r1.remove();
        goto L11
    L18:
        return false;
    L19:
        return true;
    L21:
        a(51);
        throw null;
    L23:
        a(50);
        throw null;
    L25:
        a(49);
        throw null;
    }

    private static boolean d(e0 r2, e0 r3, d1 r4) {
        if (r2 == null) goto L20;
        if (r3 == null) goto L18;
        if (r4 != null) goto L7;
        a(48);
        throw null;
    L7:
        if (g0.a(r2) == true) goto L9;
    L11:
        boolean r0 = false;
    L12:
        if (r0 == false) goto L15;
        return true;
    L15:
        return kotlin.s0.w.d.l0.n.f.f20979a.k(r4, r2.R0(), r3.R0());
    L9:
        if (g0.a(r3) == false) goto L11;
        r0 = true;
        goto L12
    L18:
        a(47);
        throw null;
    L20:
        a(46);
        throw null;
    }

    private static i e(kotlin.s0.w.d.l0.c.a r4, kotlin.s0.w.d.l0.c.a r5) {
        boolean r1 = true;
        if (r4.m0() != null) goto L5;
        boolean r0 = true;
    L7:
        if (r5.m0() == null) goto L10;
        r1 = false;
    L10:
        if (r0 == r1) goto L15;
        String r6 = "Receiver presence mismatch";
    L13:
        return i.d(r6);
    L15:
        if (r4.h().size() == r5.h().size()) goto L17;
        r6 = "Value parameter number mismatch";
        goto L13
    L17:
        return null;
    L5:
        r0 = false;
        goto L7
    }

    private static void f(kotlin.s0.w.d.l0.c.b r2, Set<kotlin.s0.w.d.l0.c.b> r3) {
        if (r2 == null) goto L19;
        if (r3 != null) goto L6;
        a(18);
        throw null;
    L6:
        if (r2.i().a() == false) goto L9;
        r3.add(r2);
        return;
    L9:
        if (r2.f().isEmpty() == true) goto L16;
        Iterator<? extends kotlin.s0.w.d.l0.c.b> r4 = r2.f().iterator();
    L12:
        if (r4.hasNext() == false) goto L22;
        f(r4.next(), r3);
        goto L12
    L22:
        return;
    L16:
        throw new IllegalStateException("No overridden descriptors found for (fake override) " + r2);
    L19:
        a(17);
        throw null;
    }

    private static List<e0> g(kotlin.s0.w.d.l0.c.a r2) {
        x0 r0 = r2.m0();
        ArrayList r1 = new ArrayList();
        if (r0 == null) goto L5;
        r1.add(r0.b());
    L5:
        Iterator<j1> r3 = r2.h().iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r1.add(r3.next().b());
        goto L7
    L9:
        return r1;
    }

    private static kotlin.s0.w.d.l0.c.u h(kotlin.s0.w.d.l0.c.b r5) {
        if (r5 == null) goto L20;
        Collection<? extends kotlin.s0.w.d.l0.c.b> r1 = r5.f();
        kotlin.s0.w.d.l0.c.u r2 = u(r1);
        if (r2 != null) goto L8;
        return null;
    L8:
        if (r5.i() != kotlin.s0.w.d.l0.c.b.a.f18849g) goto L19;
        Iterator<? extends kotlin.s0.w.d.l0.c.b> r6 = r1.iterator();
    L11:
        if (r6.hasNext() == false) goto L17;
        kotlin.s0.w.d.l0.c.b r3 = r6.next();
        if (r3.l() == kotlin.s0.w.d.l0.c.e0.f18863j) goto L11;
        if (r3.getVisibility().equals(r2) == true) goto L11;
        return null;
    L17:
        return r2;
    L19:
        return r2.f();
    L20:
        a(108);
        throw null;
    }

    public static j i(kotlin.s0.w.d.l0.n.t1.g r3, kotlin.s0.w.d.l0.n.t1.e.a r4) {
        if (r3 == null) goto L9;
        if (r4 != null) goto L6;
        a(4);
        throw null;
    L6:
        return new j(r4, r3, kotlin.s0.w.d.l0.n.t1.f.a.f21079a, null);
    L9:
        a(3);
        throw null;
    }

    private static void j(Collection<kotlin.s0.w.d.l0.c.b> r8, kotlin.s0.w.d.l0.c.e r9, kotlin.s0.w.d.l0.k.i r10) {
        if (r8 == null) goto L20;
        if (r9 == null) goto L18;
        if (r10 == null) goto L16;
        Collection<kotlin.s0.w.d.l0.c.b> r0 = t(r9, r8);
        boolean r1 = r0.isEmpty();
        if (r1 == true) goto L10;
        r8 = r0;
    L10:
        kotlin.s0.w.d.l0.c.e0 r4 = n(r8, r9);
        if (r1 == false) goto L13;
        kotlin.s0.w.d.l0.c.u r2 = t.f19166h;
    L14:
        kotlin.s0.w.d.l0.c.u r5 = r2;
        kotlin.s0.w.d.l0.c.b r11 = ((kotlin.s0.w.d.l0.c.b) L(r8, new d())).k0(r9, r4, r5, kotlin.s0.w.d.l0.c.b.a.f18849g, false);
        r10.d(r11, r8);
        r10.a(r11);
        return;
    L13:
        r2 = t.f19165g;
        goto L14
    L16:
        a(87);
        throw null;
    L18:
        a(86);
        throw null;
    L20:
        a(85);
        throw null;
    }

    private static void k(kotlin.s0.w.d.l0.c.e r1, Collection<kotlin.s0.w.d.l0.c.b> r2, kotlin.s0.w.d.l0.k.i r3) {
        if (r1 == null) goto L22;
        if (r2 == null) goto L20;
        if (r3 != null) goto L7;
        a(66);
        throw null;
    L7:
        if (b(r2) == false) goto L13;
        Iterator<kotlin.s0.w.d.l0.c.b> r4 = r2.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        j(Collections.singleton(r4.next()), r1, r3);
        goto L10
    L12:
        return;
    L13:
        LinkedList r0 = new LinkedList(r2);
    L15:
        if (r0.isEmpty() == true) goto L17;
        j(q(p.a(r0), r0, r3), r1, r3);
        goto L15
    L17:
        return;
    L20:
        a(65);
        throw null;
    L22:
        a(64);
        throw null;
    }

    private d1 l(List<f1> r10, List<f1> r11) {
        if (r10 == null) goto L23;
        if (r11 != null) goto L6;
        a(43);
        throw null;
    L6:
        if (r10.isEmpty() == false) goto L12;
        d1 r9 = new k(null, this.f20531c, this.f20529a, this.f20530b, this.f20532d).H0(true, true);
        if (r9 == null) goto L10;
        return r9;
    L10:
        a(44);
        throw null;
    L12:
        HashMap r4 = new HashMap();
        int r1 = 0;
    L14:
        if (r1 >= r10.size()) goto L16;
        r4.put(r10.get(r1).k(), r11.get(r1).k());
        r1 = r1 + 1;
        goto L14
    L16:
        d1 r12 = new k(r4, this.f20531c, this.f20529a, this.f20530b, this.f20532d).H0(true, true);
        if (r12 == null) goto L19;
        return r12;
    L19:
        a(45);
        throw null;
    L23:
        a(42);
        throw null;
    }

    public static j m(kotlin.s0.w.d.l0.n.t1.g r4) {
        if (r4 != null) goto L5;
        a(0);
        throw null;
    L5:
        return new j(f20528g, r4, kotlin.s0.w.d.l0.n.t1.f.a.f21079a, null);
    }

    private static kotlin.s0.w.d.l0.c.e0 n(Collection<kotlin.s0.w.d.l0.c.b> r9, kotlin.s0.w.d.l0.c.e r10) {
        if (r9 == null) goto L57;
        if (r10 == null) goto L55;
        Iterator<kotlin.s0.w.d.l0.c.b> r1 = r9.iterator();
        boolean r2 = false;
        boolean r3 = false;
        boolean r4 = false;
    L7:
        if (r1.hasNext() == false) goto L27;
        kotlin.s0.w.d.l0.c.b r5 = r1.next();
        int r7 = h.f20539c[r5.l().ordinal()];
        if (r7 == 1) goto L21;
        if (r7 == 2) goto L20;
        if (r7 != 3) goto L15;
        r3 = true;
        goto L7
    L15:
        if (r7 != 4) goto L7;
        r4 = true;
        goto L7
    L20:
        throw new IllegalStateException("Member cannot have SEALED modality: " + r5);
    L21:
        kotlin.s0.w.d.l0.c.e0 r11 = kotlin.s0.w.d.l0.c.e0.f18860g;
        if (r11 == null) goto L24;
        return r11;
    L24:
        a(90);
        throw null;
    L27:
        if (r10.L() == true) goto L29;
    L33:
        if (r3 == false) goto L40;
        if (r4 == true) goto L40;
        kotlin.s0.w.d.l0.c.e0 r12 = kotlin.s0.w.d.l0.c.e0.f18862i;
        if (r12 == null) goto L38;
        return r12;
    L38:
        a(91);
        throw null;
    L40:
        if (r3 == true) goto L49;
        if (r4 == false) goto L49;
        if (r2 == false) goto L44;
        kotlin.s0.w.d.l0.c.e0 r13 = r10.l();
    L45:
        if (r13 == null) goto L47;
        return r13;
    L47:
        a(92);
        throw null;
    L44:
        r13 = kotlin.s0.w.d.l0.c.e0.f18863j;
    L49:
        HashSet r0 = new HashSet();
        Iterator<kotlin.s0.w.d.l0.c.b> r14 = r9.iterator();
    L51:
        if (r14.hasNext() == false) goto L54;
        r0.addAll(z(r14.next()));
        goto L51
    L54:
        return y(r(r0), r2, r10.l());
    L29:
        if (r10.l() == kotlin.s0.w.d.l0.c.e0.f18863j) goto L33;
        if (r10.l() == kotlin.s0.w.d.l0.c.e0.f18861h) goto L33;
        r2 = true;
        goto L33
    L55:
        a(89);
        throw null;
    L57:
        a(88);
        throw null;
    }

    private Collection<kotlin.s0.w.d.l0.c.b> o(kotlin.s0.w.d.l0.c.b r7, Collection<? extends kotlin.s0.w.d.l0.c.b> r8, kotlin.s0.w.d.l0.c.e r9, kotlin.s0.w.d.l0.k.i r10) {
        if (r7 == null) goto L28;
        if (r8 == null) goto L26;
        if (r9 == null) goto L24;
        if (r10 == null) goto L22;
        ArrayList r0 = new ArrayList(r8.size());
        kotlin.s0.w.d.l0.p.f r1 = kotlin.s0.w.d.l0.p.f.a();
        Iterator<? extends kotlin.s0.w.d.l0.c.b> r11 = r8.iterator();
    L9:
        if (r11.hasNext() == false) goto L20;
        kotlin.s0.w.d.l0.c.b r2 = r11.next();
        i.a r3 = D(r2, r7, r9).c();
        boolean r4 = I(r7, r2, false);
        int r5 = h.f20538b[r3.ordinal()];
        if (r5 == 1) goto L17;
        if (r5 != 2) goto L9;
        if (r4 == false) goto L19;
        r10.c(r2, r7);
    L19:
        r0.add(r2);
        goto L9
    L17:
        if (r4 == false) goto L19;
        r1.add(r2);
        goto L19
    L20:
        r10.d(r7, r1);
        return r0;
    L22:
        a(62);
        throw null;
    L24:
        a(61);
        throw null;
    L26:
        a(60);
        throw null;
    L28:
        a(59);
        throw null;
    }

    public static <H> Collection<H> p(H r5, Collection<H> r6, kotlin.n0.c.l<H, kotlin.s0.w.d.l0.c.a> r7, kotlin.n0.c.l<H, f0> r8) {
        if (r5 == null) goto L26;
        if (r6 == null) goto L24;
        if (r7 == null) goto L22;
        if (r8 == null) goto L20;
        ArrayList r0 = new ArrayList();
        r0.add(r5);
        kotlin.s0.w.d.l0.c.a r1 = r7.invoke(r5);
        Iterator<H> r9 = r6.iterator();
    L9:
        if (r9.hasNext() == false) goto L19;
        H r2 = r9.next();
        kotlin.s0.w.d.l0.c.a r3 = r7.invoke(r2);
        if (r5 == r2) goto L12;
        i.a r4 = x(r1, r3);
        if (r4 == i.a.f20542f) goto L15;
        if (r4 != i.a.f20544h) goto L9;
        r8.invoke(r2);
        goto L12
    L15:
        r0.add(r2);
    L12:
        r9.remove();
        goto L9
    L19:
        return r0;
    L20:
        a(102);
        throw null;
    L22:
        a(101);
        throw null;
    L24:
        a(100);
        throw null;
    L26:
        a(99);
        throw null;
    }

    private static Collection<kotlin.s0.w.d.l0.c.b> q(kotlin.s0.w.d.l0.c.b r2, Queue<kotlin.s0.w.d.l0.c.b> r3, kotlin.s0.w.d.l0.k.i r4) {
        if (r2 == null) goto L12;
        if (r3 == null) goto L10;
        if (r4 != null) goto L7;
        a(106);
        throw null;
    L7:
        return p(r2, r3, new f(), new g(r4, r2));
    L10:
        a(105);
        throw null;
    L12:
        a(104);
        throw null;
    }

    public static <D extends kotlin.s0.w.d.l0.c.a> Set<D> r(Set<D> r3) {
        if (r3 != null) goto L5;
        a(8);
        throw null;
    L5:
        if (r3.isEmpty() == false) goto L7;
    L9:
        boolean r1 = false;
    L11:
        return s(r3, r1, null, new b());
    L7:
        if (kotlin.s0.w.d.l0.k.t.a.q(kotlin.s0.w.d.l0.k.t.a.l(r3.iterator().next())) == false) goto L9;
        r1 = true;
        goto L11
    }

    public static <D> Set<D> s(Set<D> r7, boolean r8, kotlin.n0.c.a<?> r9, kotlin.n0.c.p<? super D, ? super D, u<kotlin.s0.w.d.l0.c.a, kotlin.s0.w.d.l0.c.a>> r10) {
        if (r7 == null) goto L30;
        if (r10 != null) goto L6;
        a(10);
        throw null;
    L6:
        if (r7.size() > 1) goto L11;
        if (r7 == null) goto L9;
        return r7;
    L9:
        a(11);
        throw null;
    L11:
        LinkedHashSet r0 = new LinkedHashSet();
        Iterator<D> r11 = r7.iterator();
    L13:
        if (r11.hasNext() == false) goto L27;
        Object r1 = r11.next();
        if (r9 == null) goto L17;
        r9.invoke();
    L17:
        Iterator r3 = r0.iterator();
    L19:
        if (r3.hasNext() == false) goto L26;
        u<kotlin.s0.w.d.l0.c.a, kotlin.s0.w.d.l0.c.a> r4 = r10.invoke(r1, (Object) r3.next());
        kotlin.s0.w.d.l0.c.a r5 = r4.a();
        kotlin.s0.w.d.l0.c.a r6 = r4.b();
        if (J(r5, r6, r8, true) == true) goto L22;
        if (J(r6, r5, r8, true) == false) goto L19;
    L22:
        r3.remove();
        goto L19
    L26:
        r0.add(r1);
        goto L13
    L27:
        return r0;
    L30:
        a(9);
        throw null;
    }

    private static Collection<kotlin.s0.w.d.l0.c.b> t(kotlin.s0.w.d.l0.c.e r2, Collection<kotlin.s0.w.d.l0.c.b> r3) {
        if (r2 == null) goto L12;
        if (r3 == null) goto L10;
        List r4 = r.N(r3, new e(r2));
        if (r4 == null) goto L8;
        return r4;
    L8:
        a(98);
        throw null;
    L10:
        a(97);
        throw null;
    L12:
        a(96);
        throw null;
    }

    public static kotlin.s0.w.d.l0.c.u u(Collection<? extends kotlin.s0.w.d.l0.c.b> r5) {
        if (r5 != null) goto L5;
        a(109);
        throw null;
    L5:
        if (r5.isEmpty() == true) goto L7;
        Iterator<? extends kotlin.s0.w.d.l0.c.b> r1 = r5.iterator();
    L9:
        kotlin.s0.w.d.l0.c.u r2 = null;
    L11:
        if (r1.hasNext() == false) goto L21;
        kotlin.s0.w.d.l0.c.u r3 = r1.next().getVisibility();
        if (r2 == null) goto L14;
        Integer r4 = t.d(r3, r2);
        if (r4 == null) goto L9;
        if (r4.intValue() <= 0) goto L11;
    L14:
        r2 = r3;
        goto L11
    L21:
        if (r2 != null) goto L23;
        return null;
    L23:
        Iterator<? extends kotlin.s0.w.d.l0.c.b> r6 = r5.iterator();
    L25:
        if (r6.hasNext() == false) goto L31;
        Integer r7 = t.d(r2, r6.next().getVisibility());
        if (r7 == null) goto L30;
        if (r7.intValue() >= 0) goto L25;
    L30:
        return null;
    L31:
        return r2;
    L7:
        return t.f19169k;
    }

    public static i w(kotlin.s0.w.d.l0.c.a r4, kotlin.s0.w.d.l0.c.a r5) {
        if (r4 == null) goto L30;
        if (r5 == null) goto L28;
        boolean r1 = r4 instanceof y;
        if (r1 == true) goto L8;
    L9:
        boolean r2 = r4 instanceof u0;
        if (r2 == true) goto L12;
    L16:
        if (r1 == true) goto L22;
        if (r2 == true) goto L22;
        throw new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: " + r4);
    L22:
        if (r4.getName().equals(r5.getName()) == true) goto L24;
        String r6 = "Name mismatch";
    L15:
        return i.d(r6);
    L24:
        i r7 = e(r4, r5);
        if (r7 == null) goto L27;
        return r7;
    L27:
        return null;
    L12:
        if ((r5 instanceof u0) == true) goto L16;
    L13:
        r6 = "Member kind mismatch";
        goto L15
    L8:
        if ((r5 instanceof y) == false) goto L13;
    L28:
        a(41);
        throw null;
    L30:
        a(40);
        throw null;
    }

    public static i.a x(kotlin.s0.w.d.l0.c.a r3, kotlin.s0.w.d.l0.c.a r4) {
        j r0 = f20527f;
        i.a r2 = r0.D(r4, r3, null).c();
        i.a r5 = r0.D(r3, r4, null).c();
        i.a r6 = i.a.f20542f;
        if (r2 != r6) goto L6;
        if (r5 != r6) goto L6;
        return r6;
    L6:
        i.a r7 = i.a.f20544h;
        if (r2 == r7) goto L12;
        if (r5 != r7) goto L11;
        return r7;
    L11:
        return i.a.f20543g;
    L12:
        return r7;
    }

    private static kotlin.s0.w.d.l0.c.e0 y(Collection<kotlin.s0.w.d.l0.c.b> r5, boolean r6, kotlin.s0.w.d.l0.c.e0 r7) {
        if (r5 == null) goto L23;
        if (r7 == null) goto L21;
        kotlin.s0.w.d.l0.c.e0 r1 = kotlin.s0.w.d.l0.c.e0.f18863j;
        Iterator<kotlin.s0.w.d.l0.c.b> r8 = r5.iterator();
    L7:
        if (r8.hasNext() == false) goto L17;
        kotlin.s0.w.d.l0.c.b r2 = r8.next();
        if (r6 == true) goto L11;
    L13:
        kotlin.s0.w.d.l0.c.e0 r3 = r2.l();
    L15:
        if (r3.compareTo(r1) >= 0) goto L7;
        r1 = r3;
        goto L7
    L11:
        if (r2.l() != kotlin.s0.w.d.l0.c.e0.f18863j) goto L13;
        r3 = r7;
        goto L15
    L17:
        if (r1 == null) goto L19;
        return r1;
    L19:
        a(95);
        throw null;
    L21:
        a(94);
        throw null;
    L23:
        a(93);
        throw null;
    }

    public static Set<kotlin.s0.w.d.l0.c.b> z(kotlin.s0.w.d.l0.c.b r1) {
        if (r1 == null) goto L5;
        LinkedHashSet r0 = new LinkedHashSet();
        f(r1, r0);
        return r0;
    L5:
        a(15);
        throw null;
    }

    public i D(kotlin.s0.w.d.l0.c.a r3, kotlin.s0.w.d.l0.c.a r4, kotlin.s0.w.d.l0.c.e r5) {
        if (r3 == null) goto L12;
        if (r4 == null) goto L10;
        i r2 = E(r3, r4, r5, false);
        if (r2 == null) goto L8;
        return r2;
    L8:
        a(21);
        throw null;
    L10:
        a(20);
        throw null;
    L12:
        a(19);
        throw null;
    }

    public i E(kotlin.s0.w.d.l0.c.a r11, kotlin.s0.w.d.l0.c.a r12, kotlin.s0.w.d.l0.c.e r13, boolean r14) {
        if (r11 == null) goto L70;
        if (r12 == null) goto L68;
        i r10 = F(r11, r12, r14);
        if (r10.c() != i.a.f20542f) goto L8;
        boolean r15 = true;
    L9:
        Iterator<kotlin.s0.w.d.l0.k.e> r1 = f20526e.iterator();
    L11:
        if (r1.hasNext() == false) goto L35;
        kotlin.s0.w.d.l0.k.e r3 = r1.next();
        if (r3.a() == kotlin.s0.w.d.l0.k.e.a.f20515f) goto L11;
        if (r15 == false) goto L19;
        if (r3.a() == kotlin.s0.w.d.l0.k.e.a.f20516g) goto L11;
    L19:
        int r4 = h.f20537a[r3.b(r11, r12, r13).ordinal()];
        if (r4 != 1) goto L21;
        r15 = true;
        goto L11
    L21:
        if (r4 == 2) goto L29;
        if (r4 != 3) goto L11;
        i r16 = i.d("External condition");
        if (r16 == null) goto L27;
        return r16;
    L27:
        a(25);
        throw null;
    L29:
        i r17 = i.b("External condition failed");
        if (r17 == null) goto L32;
        return r17;
    L32:
        a(24);
        throw null;
    L35:
        if (r15 == true) goto L40;
        if (r10 == null) goto L38;
        return r10;
    L38:
        a(26);
        throw null;
    L40:
        Iterator<kotlin.s0.w.d.l0.k.e> r18 = f20526e.iterator();
    L42:
        if (r18.hasNext() == false) goto L63;
        kotlin.s0.w.d.l0.k.e r19 = r18.next();
        if (r19.a() != kotlin.s0.w.d.l0.k.e.a.f20515f) goto L42;
        int r2 = h.f20537a[r19.b(r11, r12, r13).ordinal()];
        if (r2 == 1) goto L62;
        if (r2 == 2) goto L56;
        if (r2 != 3) goto L42;
        i r110 = i.d("External condition");
        if (r110 == null) goto L54;
        return r110;
    L54:
        a(28);
        throw null;
    L56:
        i r111 = i.b("External condition failed");
        if (r111 == null) goto L59;
        return r111;
    L59:
        a(27);
        throw null;
    L62:
        throw new IllegalStateException("Contract violation in " + r19.getClass().getName() + " condition. It's not supposed to end with success");
    L63:
        i r112 = i.e();
        if (r112 == null) goto L66;
        return r112;
    L66:
        a(29);
        throw null;
    L8:
        r15 = false;
        goto L9
    L68:
        a(23);
        throw null;
    L70:
        a(22);
        throw null;
    }

    public i F(kotlin.s0.w.d.l0.c.a r10, kotlin.s0.w.d.l0.c.a r11, boolean r12) {
        if (r10 == null) goto L85;
        if (r11 == null) goto L83;
        i r1 = w(r10, r11);
        if (r1 == null) goto L11;
        if (r1 == null) goto L9;
        return r1;
    L9:
        a(32);
        throw null;
    L11:
        List<e0> r2 = g(r10);
        List<e0> r3 = g(r11);
        List<f1> r4 = r10.getTypeParameters();
        List<f1> r5 = r11.getTypeParameters();
        int r7 = 0;
        if (r4.size() != r5.size()) goto L14;
        d1 r9 = l(r4, r5);
        int r6 = 0;
    L30:
        if (r6 >= r4.size()) goto L39;
        if (c(r4.get(r6), r5.get(r6), r9) == false) goto L33;
        r6 = r6 + 1;
        goto L30
    L33:
        i r13 = i.d("Type parameter bounds mismatch");
        if (r13 == null) goto L36;
        return r13;
    L36:
        a(35);
        throw null;
    L39:
        int r8 = 0;
    L41:
        if (r8 >= r2.size()) goto L51;
        if (d(r2.get(r8), r3.get(r8), r9) == false) goto L44;
        r8 = r8 + 1;
        goto L41
    L44:
        i r14 = i.d("Value parameter type mismatch");
        if (r14 == null) goto L47;
        return r14;
    L47:
        a(36);
        throw null;
    L51:
        if ((r10 instanceof y) == true) goto L53;
    L61:
        if (r12 == false) goto L78;
        e0 r15 = r10.getReturnType();
        e0 r16 = r11.getReturnType();
        if (r15 == null) goto L78;
        if (r16 == null) goto L78;
        if (g0.a(r16) == true) goto L68;
    L70:
        if (r7 != 0) goto L78;
        if (kotlin.s0.w.d.l0.n.f.f20979a.r(r9, r16.R0(), r15.R0()) == true) goto L78;
        i r17 = i.b("Return type mismatch");
        if (r17 == null) goto L76;
        return r17;
    L76:
        a(38);
        throw null;
    L68:
        if (g0.a(r15) == false) goto L70;
        r7 = 1;
    L78:
        i r18 = i.e();
        if (r18 == null) goto L81;
        return r18;
    L81:
        a(39);
        throw null;
    L53:
        if ((r11 instanceof y) == false) goto L61;
        if (((y) r10).isSuspend() == ((y) r11).isSuspend()) goto L61;
        i r19 = i.b("Incompatible suspendability");
        if (r19 == null) goto L59;
        return r19;
    L59:
        a(37);
        throw null;
    L14:
        if (r7 >= r2.size()) goto L23;
        if (kotlin.s0.w.d.l0.n.t1.e.f21078a.b(r2.get(r7), r3.get(r7)) == false) goto L17;
        r7 = r7 + 1;
        goto L14
    L17:
        i r20 = i.d("Type parameter number mismatch");
        if (r20 == null) goto L20;
        return r20;
    L20:
        a(33);
        throw null;
    L23:
        i r21 = i.b("Type parameter number mismatch");
        if (r21 == null) goto L26;
        return r21;
    L26:
        a(34);
        throw null;
    L83:
        a(31);
        throw null;
    L85:
        a(30);
        throw null;
    }

    public void v(kotlin.s0.w.d.l0.g.f r2, Collection<? extends kotlin.s0.w.d.l0.c.b> r3, Collection<? extends kotlin.s0.w.d.l0.c.b> r4, kotlin.s0.w.d.l0.c.e r5, kotlin.s0.w.d.l0.k.i r6) {
        if (r2 == null) goto L22;
        if (r3 == null) goto L20;
        if (r4 == null) goto L18;
        if (r5 == null) goto L16;
        if (r6 == null) goto L14;
        LinkedHashSet r7 = new LinkedHashSet(r3);
        Iterator<? extends kotlin.s0.w.d.l0.c.b> r8 = r4.iterator();
    L10:
        if (r8.hasNext() == false) goto L12;
        r7.removeAll(o(r8.next(), r3, r5, r6));
        goto L10
    L12:
        k(r5, r7, r6);
        return;
    L14:
        a(56);
        throw null;
    L16:
        a(55);
        throw null;
    L18:
        a(54);
        throw null;
    L20:
        a(53);
        throw null;
    L22:
        a(52);
        throw null;
    }
}
