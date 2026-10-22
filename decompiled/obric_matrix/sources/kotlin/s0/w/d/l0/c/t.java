package kotlin.s0.w.d.l0.c;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;

/* JADX INFO: loaded from: classes2.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f19159a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final u f19160b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final u f19161c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final u f19162d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final u f19163e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final u f19164f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final u f19165g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final u f19166h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final u f19167i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Map<u, Integer> f19168j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final u f19169k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final kotlin.s0.w.d.l0.k.w.o.f f19170l = null;
    public static final kotlin.s0.w.d.l0.k.w.o.f m = null;

    @Deprecated
    public static final kotlin.s0.w.d.l0.k.w.o.f n = null;
    private static final kotlin.s0.w.d.l0.o.l o = null;
    private static final Map<n1, u> p = null;

    static class a implements kotlin.s0.w.d.l0.k.w.o.f {
        a() {
        }

        @Override // kotlin.s0.w.d.l0.k.w.o.f
        public kotlin.s0.w.d.l0.n.e0 b() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    static class b implements kotlin.s0.w.d.l0.k.w.o.f {
        b() {
        }

        @Override // kotlin.s0.w.d.l0.k.w.o.f
        public kotlin.s0.w.d.l0.n.e0 b() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    static class c implements kotlin.s0.w.d.l0.k.w.o.f {
        c() {
        }

        @Override // kotlin.s0.w.d.l0.k.w.o.f
        public kotlin.s0.w.d.l0.n.e0 b() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    static class d extends r {
        d(n1 r1) {
            super(r1);
        }

        private static /* synthetic */ void g(int r5) {
            Object[] r0 = new Object[3];
            if (r5 == 1) goto L7;
            if (r5 == 2) goto L6;
            r0[0] = "descriptor";
        L8:
            r0[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$1";
            if (r5 == 1) goto L12;
            if (r5 == 2) goto L12;
            r0[2] = "hasContainingSourceFile";
        L14:
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r0));
        L12:
            r0[2] = "isVisible";
            goto L14
        L6:
            r0[0] = TypedValues.TransitionType.S_FROM;
            goto L8
        L7:
            r0[0] = "what";
            goto L8
        }

        private boolean h(m r2) {
            if (r2 != null) goto L5;
            g(0);
            throw null;
        L5:
            if (kotlin.s0.w.d.l0.k.d.j(r2) == b1.f18854a) goto L10;
            return true;
        L10:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.s0.w.d.l0.c.u
        public boolean e(kotlin.s0.w.d.l0.k.w.o.f r2, m r3, m r4, boolean r5) {
            if (r3 == 0) goto L54;
            if (r4 != null) goto L6;
            g(2);
            throw null;
        L6:
            if (kotlin.s0.w.d.l0.k.d.J(r3) == false) goto L12;
            if (h(r4) == false) goto L12;
            return t.f(r3, r4);
        L12:
            if ((r3 instanceof kotlin.s0.w.d.l0.c.l) == false) goto L26;
            kotlin.s0.w.d.l0.c.i r1 = ((kotlin.s0.w.d.l0.c.l) r3).c();
            if (r5 == false) goto L26;
            if (kotlin.s0.w.d.l0.k.d.G(r1) == false) goto L26;
            if (kotlin.s0.w.d.l0.k.d.J(r1) == false) goto L26;
            if ((r4 instanceof kotlin.s0.w.d.l0.c.l) == false) goto L26;
            if (kotlin.s0.w.d.l0.k.d.J(r4.c()) == false) goto L26;
            if (t.f(r3, r4) == false) goto L26;
            return true;
        L26:
            if (r3 == 0) goto L34;
            r3 = r3.c();
            if ((r3 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L32;
            if (kotlin.s0.w.d.l0.k.d.x(r3) == false) goto L34;
        L32:
            if ((r3 instanceof l0) == false) goto L26;
        L34:
            if (r3 != 0) goto L36;
            return false;
        L36:
            if (r4 == null) goto L51;
            if (r3 == r4) goto L38;
            if ((r4 instanceof l0) == true) goto L42;
            r4 = r4.c();
            goto L36
        L42:
            if ((r3 instanceof l0) == false) goto L49;
            if (((l0) r3).e().equals(((l0) r4).e()) == false) goto L49;
            if (kotlin.s0.w.d.l0.k.d.b(r4, r3) == false) goto L49;
            return true;
        L49:
            return false;
        L38:
            return true;
        L51:
            return false;
        L54:
            g(1);
            throw null;
        }
    }

    static class e extends r {
        e(n1 r1) {
            super(r1);
        }

        private static /* synthetic */ void g(int r3) {
            Object[] r0 = new Object[3];
            if (r3 == 1) goto L5;
            r0[0] = "what";
        L6:
            r0[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$2";
            r0[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r0));
        L5:
            r0[0] = TypedValues.TransitionType.S_FROM;
            goto L6
        }

        @Override // kotlin.s0.w.d.l0.c.u
        public boolean e(kotlin.s0.w.d.l0.k.w.o.f r3, q r4, m r5, boolean r6) {
            if (r4 != null) goto L5;
            g(0);
            throw null;
        L5:
            if (r5 != null) goto L7;
            g(1);
            throw null;
        L7:
            if (t.f19159a.e(r3, r4, r5, r6) == true) goto L9;
        L20:
            return false;
        L9:
            if (r3 != t.m) goto L12;
            return true;
        L12:
            if (r3 != t.b()) goto L14;
            return false;
        L14:
            m r2 = kotlin.s0.w.d.l0.k.d.q(r4, kotlin.s0.w.d.l0.c.e.class);
            if (r2 == null) goto L20;
            if ((r3 instanceof kotlin.s0.w.d.l0.k.w.o.h) == false) goto L20;
            return ((kotlin.s0.w.d.l0.k.w.o.h) r3).r().a().equals(r2.a());
        }
    }

    static class f extends r {
        f(n1 r1) {
            super(r1);
        }

        private static /* synthetic */ void g(int r6) {
            Object[] r1 = new Object[3];
            if (r6 == 1) goto L9;
            if (r6 == 2) goto L8;
            if (r6 == 3) goto L7;
            r1[0] = "what";
        L10:
            r1[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$3";
            if (r6 == 2) goto L14;
            if (r6 == 3) goto L14;
            r1[2] = "isVisible";
        L16:
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r1));
        L14:
            r1[2] = "doesReceiverFitForProtectedVisibility";
            goto L16
        L7:
            r1[0] = "fromClass";
            goto L10
        L8:
            r1[0] = "whatDeclaration";
            goto L10
        L9:
            r1[0] = TypedValues.TransitionType.S_FROM;
            goto L10
        }

        private boolean h(kotlin.s0.w.d.l0.k.w.o.f r3, q r4, kotlin.s0.w.d.l0.c.e r5) {
            if (r4 == null) goto L33;
            if (r5 != null) goto L6;
            g(3);
            throw null;
        L6:
            if (r3 != t.n) goto L9;
            return false;
        L9:
            if ((r4 instanceof kotlin.s0.w.d.l0.c.b) == true) goto L12;
            return true;
        L12:
            if ((r4 instanceof kotlin.s0.w.d.l0.c.l) == false) goto L15;
            return true;
        L15:
            if (r3 != t.m) goto L18;
            return true;
        L18:
            if (r3 == t.b()) goto L35;
            if (r3 != null) goto L22;
            return false;
        L22:
            if ((r3 instanceof kotlin.s0.w.d.l0.k.w.o.g) == false) goto L24;
            kotlin.s0.w.d.l0.n.e0 r2 = ((kotlin.s0.w.d.l0.k.w.o.g) r3).a();
        L26:
            if (kotlin.s0.w.d.l0.k.d.I(r2, r5) == true) goto L30;
            if (kotlin.s0.w.d.l0.n.w.a(r2) == true) goto L30;
            return false;
        L30:
            return true;
        L24:
            r2 = r3.b();
            goto L26
        L35:
            return false;
        L33:
            g(2);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.c.u
        public boolean e(kotlin.s0.w.d.l0.k.w.o.f r6, q r7, m r8, boolean r9) {
            if (r7 != null) goto L5;
            g(0);
            throw null;
        L5:
            if (r8 == null) goto L27;
            kotlin.s0.w.d.l0.c.e r1 = (kotlin.s0.w.d.l0.c.e) kotlin.s0.w.d.l0.k.d.q(r7, kotlin.s0.w.d.l0.c.e.class);
            kotlin.s0.w.d.l0.c.e r10 = (kotlin.s0.w.d.l0.c.e) kotlin.s0.w.d.l0.k.d.r(r8, kotlin.s0.w.d.l0.c.e.class, false);
            if (r10 != null) goto L9;
            return false;
        L9:
            if (r1 != null) goto L11;
        L17:
            q r2 = kotlin.s0.w.d.l0.k.d.M(r7);
            kotlin.s0.w.d.l0.c.e r0 = (kotlin.s0.w.d.l0.c.e) kotlin.s0.w.d.l0.k.d.q(r2, kotlin.s0.w.d.l0.c.e.class);
            if (r0 != null) goto L21;
            return false;
        L21:
            if (kotlin.s0.w.d.l0.k.d.H(r10, r0) == false) goto L26;
            if (h(r6, r2, r10) == false) goto L26;
            return true;
        L26:
            return e(r6, r7, r10.c(), r9);
        L11:
            if (kotlin.s0.w.d.l0.k.d.x(r1) == false) goto L17;
            kotlin.s0.w.d.l0.c.e r3 = (kotlin.s0.w.d.l0.c.e) kotlin.s0.w.d.l0.k.d.q(r1, kotlin.s0.w.d.l0.c.e.class);
            if (r3 == null) goto L17;
            if (kotlin.s0.w.d.l0.k.d.H(r10, r3) == false) goto L17;
            return true;
        L27:
            g(1);
            throw null;
        }
    }

    static class g extends r {
        g(n1 r1) {
            super(r1);
        }

        private static /* synthetic */ void g(int r3) {
            Object[] r0 = new Object[3];
            if (r3 == 1) goto L5;
            r0[0] = "what";
        L6:
            r0[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$4";
            r0[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r0));
        L5:
            r0[0] = TypedValues.TransitionType.S_FROM;
            goto L6
        }

        @Override // kotlin.s0.w.d.l0.c.u
        public boolean e(kotlin.s0.w.d.l0.k.w.o.f r1, q r2, m r3, boolean r4) {
            if (r2 == null) goto L12;
            if (r3 == null) goto L10;
            h0 r0 = kotlin.s0.w.d.l0.k.d.g(r2);
            if (kotlin.s0.w.d.l0.k.d.g(r3).e0(r0) == true) goto L9;
            return false;
        L9:
            return t.c().a(r2, r3);
        L10:
            g(1);
            throw null;
        L12:
            g(0);
            throw null;
        }
    }

    static class h extends r {
        h(n1 r1) {
            super(r1);
        }

        private static /* synthetic */ void g(int r3) {
            Object[] r0 = new Object[3];
            if (r3 == 1) goto L5;
            r0[0] = "what";
        L6:
            r0[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$5";
            r0[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r0));
        L5:
            r0[0] = TypedValues.TransitionType.S_FROM;
            goto L6
        }

        @Override // kotlin.s0.w.d.l0.c.u
        public boolean e(kotlin.s0.w.d.l0.k.w.o.f r1, q r2, m r3, boolean r4) {
            if (r2 != null) goto L5;
            g(0);
            throw null;
        L5:
            if (r3 == null) goto L7;
            return true;
        L7:
            g(1);
            throw null;
        }
    }

    static class i extends r {
        i(n1 r1) {
            super(r1);
        }

        private static /* synthetic */ void g(int r3) {
            Object[] r0 = new Object[3];
            if (r3 == 1) goto L5;
            r0[0] = "what";
        L6:
            r0[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$6";
            r0[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r0));
        L5:
            r0[0] = TypedValues.TransitionType.S_FROM;
            goto L6
        }

        @Override // kotlin.s0.w.d.l0.c.u
        public boolean e(kotlin.s0.w.d.l0.k.w.o.f r1, q r2, m r3, boolean r4) {
            if (r2 == null) goto L9;
            if (r3 != null) goto L8;
            g(1);
            throw null;
        L8:
            throw new IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
        L9:
            g(0);
            throw null;
        }
    }

    static class j extends r {
        j(n1 r1) {
            super(r1);
        }

        private static /* synthetic */ void g(int r3) {
            Object[] r0 = new Object[3];
            if (r3 == 1) goto L5;
            r0[0] = "what";
        L6:
            r0[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$7";
            r0[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r0));
        L5:
            r0[0] = TypedValues.TransitionType.S_FROM;
            goto L6
        }

        @Override // kotlin.s0.w.d.l0.c.u
        public boolean e(kotlin.s0.w.d.l0.k.w.o.f r1, q r2, m r3, boolean r4) {
            if (r2 == null) goto L9;
            if (r3 != null) goto L8;
            g(1);
            throw null;
        L8:
            throw new IllegalStateException("Visibility is unknown yet");
        L9:
            g(0);
            throw null;
        }
    }

    static class k extends r {
        k(n1 r1) {
            super(r1);
        }

        private static /* synthetic */ void g(int r3) {
            Object[] r0 = new Object[3];
            if (r3 == 1) goto L5;
            r0[0] = "what";
        L6:
            r0[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$8";
            r0[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r0));
        L5:
            r0[0] = TypedValues.TransitionType.S_FROM;
            goto L6
        }

        @Override // kotlin.s0.w.d.l0.c.u
        public boolean e(kotlin.s0.w.d.l0.k.w.o.f r1, q r2, m r3, boolean r4) {
            if (r2 == null) goto L8;
            if (r3 == null) goto L6;
            return false;
        L6:
            g(1);
            throw null;
        L8:
            g(0);
            throw null;
        }
    }

    static class l extends r {
        l(n1 r1) {
            super(r1);
        }

        private static /* synthetic */ void g(int r3) {
            Object[] r0 = new Object[3];
            if (r3 == 1) goto L5;
            r0[0] = "what";
        L6:
            r0[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$9";
            r0[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r0));
        L5:
            r0[0] = TypedValues.TransitionType.S_FROM;
            goto L6
        }

        @Override // kotlin.s0.w.d.l0.c.u
        public boolean e(kotlin.s0.w.d.l0.k.w.o.f r1, q r2, m r3, boolean r4) {
            if (r2 == null) goto L8;
            if (r3 == null) goto L6;
            return false;
        L6:
            g(1);
            throw null;
        L8:
            g(0);
            throw null;
        }
    }

    static {
        d r1 = new d(m1.e.f18892c);
        f19159a = r1;
        e r2 = new e(m1.f.f18893c);
        f19160b = r2;
        f r3 = new f(m1.g.f18894c);
        f19161c = r3;
        g r4 = new g(m1.b.f18889c);
        f19162d = r4;
        h r5 = new h(m1.h.f18895c);
        f19163e = r5;
        i r6 = new i(m1.d.f18891c);
        f19164f = r6;
        j r7 = new j(m1.a.f18888c);
        f19165g = r7;
        k r8 = new k(m1.c.f18890c);
        f19166h = r8;
        l r9 = new l(m1.i.f18896c);
        f19167i = r9;
        Collections.unmodifiableSet(kotlin.i0.t0.e(new u[]{r1, r2, r4, r6}));
        HashMap r10 = kotlin.s0.w.d.l0.p.a.e(4);
        r10.put(r2, 0);
        r10.put(r1, 0);
        r10.put(r4, 1);
        r10.put(r3, 1);
        r10.put(r5, 2);
        f19168j = Collections.unmodifiableMap(r10);
        f19169k = r5;
        f19170l = new a();
        m = new b();
        n = new c();
        Iterator r0 = ServiceLoader.load(kotlin.s0.w.d.l0.o.l.class, kotlin.s0.w.d.l0.o.l.class.getClassLoader()).iterator();
        if (r0.hasNext() == false) goto L5;
        kotlin.s0.w.d.l0.o.l r11 = (kotlin.s0.w.d.l0.o.l) r0.next();
    L6:
        o = r11;
        p = new HashMap();
        i(r1);
        i(r2);
        i(r3);
        i(r4);
        i(r5);
        i(r6);
        i(r7);
        i(r8);
        i(r9);
        return;
    L5:
        r11 = kotlin.s0.w.d.l0.o.l.a.f21230a;
        goto L6
    }

    private static /* synthetic */ void a(int r8) {
        if (r8 == 16) goto L5;
        String r1 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L7:
        if (r8 == 16) goto L9;
        int r4 = 3;
    L10:
        Object[] r5 = new Object[r4];
        if (r8 == 1) goto L23;
        if (r8 == 3) goto L23;
        if (r8 == 5) goto L23;
        if (r8 == 7) goto L23;
        switch(r8) {
            case 9: goto L23;
            case 10: goto L22;
            case 11: goto L21;
            case 12: goto L22;
            case 13: goto L21;
            case 14: goto L20;
            case 15: goto L20;
            case 16: goto L19;
            default: goto L18;
        };
    L18:
        r5[0] = "what";
    L25:
        if (r8 == 16) goto L27;
        r5[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
    L28:
        switch(r8) {
            case 2: goto L37;
            case 3: goto L37;
            case 4: goto L36;
            case 5: goto L36;
            case 6: goto L35;
            case 7: goto L35;
            case 8: goto L34;
            case 9: goto L34;
            case 10: goto L33;
            case 11: goto L33;
            case 12: goto L32;
            case 13: goto L32;
            case 14: goto L31;
            case 15: goto L30;
            case 16: goto L38;
            default: goto L29;
        };
    L29:
        r5[2] = "isVisible";
        goto L38
    L30:
        r5[2] = "toDescriptorVisibility";
        goto L38
    L31:
        r5[2] = "isPrivate";
        goto L38
    L32:
        r5[2] = "compare";
        goto L38
    L33:
        r5[2] = "compareLocal";
        goto L38
    L34:
        r5[2] = "findInvisibleMember";
        goto L38
    L35:
        r5[2] = "inSameFile";
        goto L38
    L36:
        r5[2] = "isVisibleWithAnyReceiver";
        goto L38
    L37:
        r5[2] = "isVisibleIgnoringReceiver";
    L38:
        String r2 = String.format(r1, r5);
        if (r8 == 16) goto L42;
        throw new IllegalArgumentException(r2);
    L42:
        throw new IllegalStateException(r2);
    L27:
        r5[1] = "toDescriptorVisibility";
        goto L28
    L19:
        r5[0] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
        goto L25
    L20:
        r5[0] = "visibility";
        goto L25
    L21:
        r5[0] = "second";
        goto L25
    L22:
        r5[0] = "first";
    L23:
        r5[0] = TypedValues.TransitionType.S_FROM;
        goto L25
    L9:
        r4 = 2;
        goto L10
    L5:
        r1 = "@NotNull method %s.%s must not return null";
        goto L7
    }

    static /* synthetic */ kotlin.s0.w.d.l0.k.w.o.f b() {
        return f19170l;
    }

    static /* synthetic */ kotlin.s0.w.d.l0.o.l c() {
        return o;
    }

    public static Integer d(u r2, u r3) {
        if (r2 == null) goto L15;
        if (r3 == null) goto L13;
        Integer r1 = r2.a(r3);
        if (r1 == null) goto L8;
        return r1;
    L8:
        Integer r4 = r3.a(r2);
        if (r4 != null) goto L11;
        return null;
    L11:
        return Integer.valueOf(-r4.intValue());
    L13:
        a(13);
        throw null;
    L15:
        a(12);
        throw null;
    }

    public static q e(kotlin.s0.w.d.l0.k.w.o.f r4, q r5, m r6, boolean r7) {
        if (r5 == null) goto L22;
        if (r6 == null) goto L20;
        m r1 = r5.a();
    L6:
        q r2 = (q) r1;
        if (r2 == null) goto L15;
        if (r2.getVisibility() == f19164f) goto L15;
        if (r2.getVisibility().e(r4, r2, r6, r7) == false) goto L12;
        r1 = kotlin.s0.w.d.l0.k.d.q(r2, q.class);
        goto L6
    L12:
        return r2;
    L15:
        if ((r5 instanceof kotlin.s0.w.d.l0.c.q1.i0) == false) goto L19;
        q r8 = e(r4, ((kotlin.s0.w.d.l0.c.q1.i0) r5).p0(), r6, r7);
        if (r8 == null) goto L19;
        return r8;
    L19:
        return null;
    L20:
        a(9);
        throw null;
    L22:
        a(8);
        throw null;
    }

    public static boolean f(m r1, m r2) {
        if (r1 == null) goto L13;
        if (r2 == null) goto L11;
        b1 r3 = kotlin.s0.w.d.l0.k.d.j(r2);
        if (r3 != b1.f18854a) goto L8;
        return false;
    L8:
        return r3.equals(kotlin.s0.w.d.l0.k.d.j(r1));
    L11:
        a(7);
        throw null;
    L13:
        a(6);
        throw null;
    }

    public static boolean g(u r1) {
        if (r1 != null) goto L4;
        a(14);
        throw null;
    L4:
        if (r1 != f19159a) goto L6;
    L9:
        return true;
    L6:
        if (r1 == f19160b) goto L9;
        return false;
    }

    public static boolean h(q r1, m r2, boolean r3) {
        if (r1 == null) goto L12;
        if (r2 != null) goto L6;
        a(3);
        throw null;
    L6:
        if (e(m, r1, r2, r3) != null) goto L8;
        return true;
    L8:
        return false;
    L12:
        a(2);
        throw null;
    }

    private static void i(u r2) {
        p.put(r2.b(), r2);
    }

    public static u j(n1 r3) {
        if (r3 == null) goto L12;
        u r1 = p.get(r3);
        if (r1 == null) goto L11;
        if (r1 == null) goto L8;
        return r1;
    L8:
        a(16);
        throw null;
    L11:
        throw new IllegalArgumentException("Inapplicable visibility: " + r3);
    L12:
        a(15);
        throw null;
    }
}
