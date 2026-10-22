package kotlin.s0.w.d.l0.e.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.e.b.b.a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b<A, S extends a<? extends A>> implements kotlin.s0.w.d.l0.l.b.f<A> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o f19693a;

    public static abstract class a<A> {
        public a() {
        }

        public abstract Map<t, List<A>> a();
    }

    /* JADX INFO: renamed from: kotlin.s0.w.d.l0.e.b.b$b, reason: collision with other inner class name */
    private static final enum EnumC0523b extends Enum<EnumC0523b> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final EnumC0523b f19694f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final EnumC0523b f19695g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final EnumC0523b f19696h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ EnumC0523b[] f19697i = null;

        static {
            f19694f = new EnumC0523b("PROPERTY", 0);
            f19695g = new EnumC0523b("BACKING_FIELD", 1);
            f19696h = new EnumC0523b("DELEGATE_FIELD", 2);
            f19697i = a();
        }

        private EnumC0523b(String r1, int r2) {
            super(r1, r2);
        }

        private static final /* synthetic */ EnumC0523b[] a() {
            return new EnumC0523b[]{f19694f, f19695g, f19696h};
        }

        public static EnumC0523b valueOf(String r1) {
            return (EnumC0523b) Enum.valueOf(EnumC0523b.class, r1);
        }

        public static EnumC0523b[] values() {
            return (EnumC0523b[]) f19697i.clone();
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19698a = null;

        static {
            int[] r0 = new int[kotlin.s0.w.d.l0.l.b.b.values().length];
            r0[kotlin.s0.w.d.l0.l.b.b.f20697h.ordinal()] = 1;
            r0[kotlin.s0.w.d.l0.l.b.b.f20698i.ordinal()] = 2;
            r0[kotlin.s0.w.d.l0.l.b.b.f20696g.ordinal()] = 3;
            f19698a = r0;
        }
    }

    public static final class d implements q.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b<A, S> f19699a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList<A> f19700b;

        d(b<A, S> r1, ArrayList<A> r2) {
            this.f19699a = r1;
            this.f19700b = r2;
        }

        @Override // kotlin.s0.w.d.l0.e.b.q.c
        public void a() {
        }

        @Override // kotlin.s0.w.d.l0.e.b.q.c
        public q.a b(kotlin.s0.w.d.l0.g.b r2, a1 r3) {
            kotlin.n0.d.o.f(r2, "classId");
            kotlin.n0.d.o.f(r3, "source");
            return this.f19699a.y(r2, r3, this.f19700b);
        }
    }

    public b(o r2) {
        kotlin.n0.d.o.f(r2, "kotlinClassFinder");
        this.f19693a = r2;
    }

    private final q B(kotlin.s0.w.d.l0.l.b.z.a r2) {
        a1 r1 = r2.c();
        if ((r1 instanceof s) == false) goto L5;
        s r3 = (s) r1;
    L6:
        if (r3 != null) goto L8;
        return null;
    L8:
        return r3.d();
    L5:
        r3 = null;
        goto L6
    }

    private final int l(kotlin.s0.w.d.l0.l.b.z r3, kotlin.s0.w.d.l0.i.q r4) {
        if ((r4 instanceof kotlin.s0.w.d.l0.f.i) == false) goto L9;
        if (kotlin.s0.w.d.l0.f.z.f.d((kotlin.s0.w.d.l0.f.i) r4) == false) goto L20;
        return 1;
    L20:
        return 0;
    L9:
        if ((r4 instanceof kotlin.s0.w.d.l0.f.n) == false) goto L14;
        if (kotlin.s0.w.d.l0.f.z.f.e((kotlin.s0.w.d.l0.f.n) r4) == false) goto L20;
        return 1;
    L14:
        if ((r4 instanceof kotlin.s0.w.d.l0.f.d) == false) goto L22;
        kotlin.n0.d.o.d(r3, "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.ProtoContainer.Class");
        kotlin.s0.w.d.l0.l.b.z.a r5 = (kotlin.s0.w.d.l0.l.b.z.a) r3;
        if (r5.g() != kotlin.s0.w.d.l0.f.c.EnumC0545c.f19945i) goto L19;
        return 2;
    L19:
        if (r5.i() == false) goto L20;
        return 1;
    L22:
        throw new UnsupportedOperationException("Unsupported message: " + r4.getClass());
    }

    private final List<A> m(kotlin.s0.w.d.l0.l.b.z r7, t r8, boolean r9, boolean r10, Boolean r11, boolean r12) {
        q r13 = o(r7, v(r7, r9, r10, r11, r12));
        if (r13 == null) goto L5;
        List<A> r6 = p(r13).a().get(r8);
        if (r6 == null) goto L9;
        return r6;
    L9:
        return kotlin.i0.r.g();
    L5:
        return kotlin.i0.r.g();
    }

    static /* synthetic */ List n(b r9, kotlin.s0.w.d.l0.l.b.z r10, t r11, boolean r12, boolean r13, Boolean r14, boolean r15, int r16, Object r17) {
        if (r17 != null) goto L22;
        if ((r16 & 4) == 0) goto L6;
        boolean r5 = false;
    L8:
        if ((r16 & 8) == 0) goto L10;
        boolean r6 = false;
    L12:
        if ((r16 & 16) == 0) goto L14;
        Boolean r7 = null;
    L16:
        if ((r16 & 32) == 0) goto L18;
        boolean r8 = false;
    L20:
        return r9.m(r10, r11, r5, r6, r7, r8);
    L18:
        r8 = r15;
        goto L20
    L14:
        r7 = r14;
        goto L16
    L10:
        r6 = r13;
        goto L12
    L6:
        r5 = r12;
        goto L8
    L22:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findClassAndLoadMemberAnnotations");
    }

    public static /* synthetic */ t s(b r6, kotlin.s0.w.d.l0.i.q r7, kotlin.s0.w.d.l0.f.z.c r8, kotlin.s0.w.d.l0.f.z.g r9, kotlin.s0.w.d.l0.l.b.b r10, boolean r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 16) == 0) goto L7;
        r11 = false;
    L7:
        return r6.r(r7, r8, r9, r10, r11);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCallableSignature");
    }

    public static /* synthetic */ t u(b r9, kotlin.s0.w.d.l0.f.n r10, kotlin.s0.w.d.l0.f.z.c r11, kotlin.s0.w.d.l0.f.z.g r12, boolean r13, boolean r14, boolean r15, int r16, Object r17) {
        if (r17 != null) goto L18;
        if ((r16 & 8) == 0) goto L6;
        boolean r6 = false;
    L8:
        if ((r16 & 16) == 0) goto L10;
        boolean r7 = false;
    L12:
        if ((r16 & 32) == 0) goto L14;
        boolean r8 = true;
    L16:
        return r9.t(r10, r11, r12, r6, r7, r8);
    L14:
        r8 = r15;
        goto L16
    L10:
        r7 = r14;
        goto L12
    L6:
        r6 = r13;
        goto L8
    L18:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPropertySignature");
    }

    private final List<A> z(kotlin.s0.w.d.l0.l.b.z r19, kotlin.s0.w.d.l0.f.n r20, EnumC0523b r21) {
        Boolean r1 = kotlin.s0.w.d.l0.f.z.b.A.g(r20.a0());
        kotlin.n0.d.o.e(r1, "IS_CONST.get(proto.flags)");
        boolean r2 = r1.booleanValue();
        boolean r8 = kotlin.s0.w.d.l0.f.a0.b.i.f(r20);
        EnumC0523b r3 = EnumC0523b.f19694f;
        kotlin.s0.w.d.l0.f.z.c r11 = r19.b();
        kotlin.s0.w.d.l0.f.z.g r12 = r19.d();
        if (r21 != r3) goto L10;
        t r4 = u(this, r20, r11, r12, false, true, false, 40, null);
        if (r4 != null) goto L9;
        return kotlin.i0.r.g();
    L9:
        return n(this, r19, r4, true, false, Boolean.valueOf(r2), r8, 8, null);
    L10:
        t r5 = u(this, r20, r11, r12, true, false, false, 48, null);
        if (r5 == null) goto L13;
        boolean r7 = false;
        boolean r6 = kotlin.u0.k.F(r5.a(), "$delegate", false, 2, null);
        if (r21 != EnumC0523b.f19696h) goto L17;
        r7 = true;
    L17:
        if (r6 == r7) goto L21;
        return kotlin.i0.r.g();
    L21:
        return m(r19, r5, true, true, Boolean.valueOf(r2), r8);
    L13:
        return kotlin.i0.r.g();
    }

    protected abstract A A(kotlin.s0.w.d.l0.f.b r1, kotlin.s0.w.d.l0.f.z.c r2);

    @Override // kotlin.s0.w.d.l0.l.b.f
    public List<A> a(kotlin.s0.w.d.l0.f.s r4, kotlin.s0.w.d.l0.f.z.c r5) {
        kotlin.n0.d.o.f(r4, "proto");
        kotlin.n0.d.o.f(r5, "nameResolver");
        Object r6 = r4.t(kotlin.s0.w.d.l0.f.a0.a.f19807h);
        kotlin.n0.d.o.e(r6, "proto.getExtension(JvmPr….typeParameterAnnotation)");
        Iterable r7 = (Iterable) r6;
        ArrayList r0 = new ArrayList(kotlin.i0.r.q(r7, 10));
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        kotlin.s0.w.d.l0.f.b r1 = (kotlin.s0.w.d.l0.f.b) r8.next();
        kotlin.n0.d.o.e(r1, "it");
        r0.add(A(r1, r5));
        goto L4
    L6:
        return r0;
    }

    @Override // kotlin.s0.w.d.l0.l.b.f
    public List<A> b(kotlin.s0.w.d.l0.l.b.z r10, kotlin.s0.w.d.l0.i.q r11, kotlin.s0.w.d.l0.l.b.b r12, int r13, kotlin.s0.w.d.l0.f.u r14) {
        kotlin.n0.d.o.f(r10, "container");
        kotlin.n0.d.o.f(r11, "callableProto");
        kotlin.n0.d.o.f(r12, "kind");
        kotlin.n0.d.o.f(r14, "proto");
        t r15 = s(this, r11, r10.b(), r10.d(), r12, false, 16, null);
        if (r15 == null) goto L7;
        int r16 = r13 + l(r10, r11);
        return n(this, r10, t.f19794b.e(r15, r16), false, false, null, false, 60, null);
    L7:
        return kotlin.i0.r.g();
    }

    @Override // kotlin.s0.w.d.l0.l.b.f
    public List<A> c(kotlin.s0.w.d.l0.l.b.z.a r3) {
        kotlin.n0.d.o.f(r3, "container");
        q r0 = B(r3);
        if (r0 == null) goto L7;
        ArrayList r4 = new ArrayList(1);
        r0.b(new d(this, r4), q(r0));
        return r4;
    L7:
        throw new IllegalStateException(("Class for loading annotations is not found: " + r3.a()).toString());
    }

    @Override // kotlin.s0.w.d.l0.l.b.f
    public List<A> d(kotlin.s0.w.d.l0.f.q r4, kotlin.s0.w.d.l0.f.z.c r5) {
        kotlin.n0.d.o.f(r4, "proto");
        kotlin.n0.d.o.f(r5, "nameResolver");
        Object r6 = r4.t(kotlin.s0.w.d.l0.f.a0.a.f19805f);
        kotlin.n0.d.o.e(r6, "proto.getExtension(JvmProtoBuf.typeAnnotation)");
        Iterable r7 = (Iterable) r6;
        ArrayList r0 = new ArrayList(kotlin.i0.r.q(r7, 10));
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        kotlin.s0.w.d.l0.f.b r1 = (kotlin.s0.w.d.l0.f.b) r8.next();
        kotlin.n0.d.o.e(r1, "it");
        r0.add(A(r1, r5));
        goto L4
    L6:
        return r0;
    }

    @Override // kotlin.s0.w.d.l0.l.b.f
    public List<A> f(kotlin.s0.w.d.l0.l.b.z r12, kotlin.s0.w.d.l0.f.g r13) {
        kotlin.n0.d.o.f(r12, "container");
        kotlin.n0.d.o.f(r13, "proto");
        t.a r0 = t.f19794b;
        String r14 = r12.b().b(r13.F());
        String r1 = ((kotlin.s0.w.d.l0.l.b.z.a) r12).e().c();
        kotlin.n0.d.o.e(r1, "container as ProtoContai…Class).classId.asString()");
        return n(this, r12, r0.a(r14, kotlin.s0.w.d.l0.f.a0.b.b.b(r1)), false, false, null, false, 60, null);
    }

    @Override // kotlin.s0.w.d.l0.l.b.f
    public List<A> g(kotlin.s0.w.d.l0.l.b.z r2, kotlin.s0.w.d.l0.f.n r3) {
        kotlin.n0.d.o.f(r2, "container");
        kotlin.n0.d.o.f(r3, "proto");
        return z(r2, r3, EnumC0523b.f19695g);
    }

    @Override // kotlin.s0.w.d.l0.l.b.f
    public List<A> h(kotlin.s0.w.d.l0.l.b.z r11, kotlin.s0.w.d.l0.i.q r12, kotlin.s0.w.d.l0.l.b.b r13) {
        kotlin.n0.d.o.f(r11, "container");
        kotlin.n0.d.o.f(r12, "proto");
        kotlin.n0.d.o.f(r13, "kind");
        t r14 = s(this, r12, r11.b(), r11.d(), r13, false, 16, null);
        if (r14 == null) goto L7;
        return n(this, r11, t.f19794b.e(r14, 0), false, false, null, false, 60, null);
    L7:
        return kotlin.i0.r.g();
    }

    @Override // kotlin.s0.w.d.l0.l.b.f
    public List<A> i(kotlin.s0.w.d.l0.l.b.z r2, kotlin.s0.w.d.l0.f.n r3) {
        kotlin.n0.d.o.f(r2, "container");
        kotlin.n0.d.o.f(r3, "proto");
        return z(r2, r3, EnumC0523b.f19696h);
    }

    @Override // kotlin.s0.w.d.l0.l.b.f
    public List<A> j(kotlin.s0.w.d.l0.l.b.z r11, kotlin.s0.w.d.l0.i.q r12, kotlin.s0.w.d.l0.l.b.b r13) {
        kotlin.n0.d.o.f(r11, "container");
        kotlin.n0.d.o.f(r12, "proto");
        kotlin.n0.d.o.f(r13, "kind");
        if (r13 == kotlin.s0.w.d.l0.l.b.b.f20696g) goto L5;
        t r2 = s(this, r12, r11.b(), r11.d(), r13, false, 16, null);
        if (r2 != null) goto L11;
        return kotlin.i0.r.g();
    L11:
        return n(this, r11, r2, false, false, null, false, 60, null);
    L5:
        return z(r11, (kotlin.s0.w.d.l0.f.n) r12, EnumC0523b.f19694f);
    }

    protected final q o(kotlin.s0.w.d.l0.l.b.z r2, q r3) {
        kotlin.n0.d.o.f(r2, "container");
        if (r3 == null) goto L5;
        return r3;
    L5:
        if ((r2 instanceof kotlin.s0.w.d.l0.l.b.z.a) == true) goto L10;
        return null;
    L10:
        return B((kotlin.s0.w.d.l0.l.b.z.a) r2);
    }

    protected abstract S p(q r1);

    protected byte[] q(q r1) {
        kotlin.n0.d.o.f(r1, "kotlinClass");
        return null;
    }

    protected final t r(kotlin.s0.w.d.l0.i.q r10, kotlin.s0.w.d.l0.f.z.c r11, kotlin.s0.w.d.l0.f.z.g r12, kotlin.s0.w.d.l0.l.b.b r13, boolean r14) {
        kotlin.n0.d.o.f(r10, "proto");
        kotlin.n0.d.o.f(r11, "nameResolver");
        kotlin.n0.d.o.f(r12, "typeTable");
        kotlin.n0.d.o.f(r13, "kind");
        if ((r10 instanceof kotlin.s0.w.d.l0.f.d) == false) goto L9;
        t.a r9 = t.f19794b;
        kotlin.s0.w.d.l0.f.a0.b.d.b r15 = kotlin.s0.w.d.l0.f.a0.b.i.f19890a.b((kotlin.s0.w.d.l0.f.d) r10, r11, r12);
        if (r15 != null) goto L34;
        return null;
    L34:
        return r9.b(r15);
    L9:
        if ((r10 instanceof kotlin.s0.w.d.l0.f.i) == false) goto L14;
        r9 = t.f19794b;
        r15 = kotlin.s0.w.d.l0.f.a0.b.i.f19890a.e((kotlin.s0.w.d.l0.f.i) r10, r11, r12);
        if (r15 != null) goto L34;
        return null;
    L14:
        if ((r10 instanceof kotlin.s0.w.d.l0.f.n) == false) goto L35;
        kotlin.s0.w.d.l0.i.i.f<kotlin.s0.w.d.l0.f.n, kotlin.s0.w.d.l0.f.a0.a.d> r2 = kotlin.s0.w.d.l0.f.a0.a.f19803d;
        kotlin.n0.d.o.e(r2, "propertySignature");
        kotlin.s0.w.d.l0.f.a0.a.d r0 = (kotlin.s0.w.d.l0.f.a0.a.d) kotlin.s0.w.d.l0.f.z.e.a((kotlin.s0.w.d.l0.i.i.d) r10, r2);
        if (r0 != null) goto L18;
        return null;
    L18:
        int r16 = c.f19698a[r13.ordinal()];
        if (r16 == 1) goto L30;
        if (r16 == 2) goto L27;
        if (r16 == 3) goto L36;
        return null;
    L36:
        return t((kotlin.s0.w.d.l0.f.n) r10, r11, r12, true, true, r14);
    L27:
        if (r0.H() == false) goto L37;
        t.a r17 = t.f19794b;
        kotlin.s0.w.d.l0.f.a0.a.c r18 = r0.C();
        String r19 = "signature.setter";
    L32:
        kotlin.n0.d.o.e(r18, r19);
        return r17.c(r11, r18);
    L37:
        return null;
    L30:
        if (r0.G() == false) goto L38;
        r17 = t.f19794b;
        r18 = r0.B();
        r19 = "signature.getter";
        goto L32
    L38:
        return null;
    L35:
        return null;
    }

    protected final t t(kotlin.s0.w.d.l0.f.n r2, kotlin.s0.w.d.l0.f.z.c r3, kotlin.s0.w.d.l0.f.z.g r4, boolean r5, boolean r6, boolean r7) {
        kotlin.n0.d.o.f(r2, "proto");
        kotlin.n0.d.o.f(r3, "nameResolver");
        kotlin.n0.d.o.f(r4, "typeTable");
        kotlin.s0.w.d.l0.i.i.f<kotlin.s0.w.d.l0.f.n, kotlin.s0.w.d.l0.f.a0.a.d> r1 = kotlin.s0.w.d.l0.f.a0.a.f19803d;
        kotlin.n0.d.o.e(r1, "propertySignature");
        kotlin.s0.w.d.l0.f.a0.a.d r8 = (kotlin.s0.w.d.l0.f.a0.a.d) kotlin.s0.w.d.l0.f.z.e.a(r2, r1);
        if (r8 != null) goto L5;
        return null;
    L5:
        if (r5 == false) goto L11;
        kotlin.s0.w.d.l0.f.a0.b.d.a r9 = kotlin.s0.w.d.l0.f.a0.b.i.f19890a.c(r2, r3, r4, r7);
        if (r9 != null) goto L10;
        return null;
    L10:
        return t.f19794b.b(r9);
    L11:
        if (r6 == true) goto L13;
    L16:
        return null;
    L13:
        if (r8.I() == false) goto L16;
        t.a r10 = t.f19794b;
        kotlin.s0.w.d.l0.f.a0.a.c r11 = r8.D();
        kotlin.n0.d.o.e(r11, "signature.syntheticMethod");
        return r10.c(r3, r11);
    }

    protected final q v(kotlin.s0.w.d.l0.l.b.z r7, boolean r8, boolean r9, Boolean r10, boolean r11) {
        kotlin.n0.d.o.f(r7, "container");
        if (r8 == false) goto L27;
        if (r10 == null) goto L26;
        if ((r7 instanceof kotlin.s0.w.d.l0.l.b.z.a) == false) goto L13;
        kotlin.s0.w.d.l0.l.b.z.a r12 = (kotlin.s0.w.d.l0.l.b.z.a) r7;
        if (r12.g() != kotlin.s0.w.d.l0.f.c.EnumC0545c.f19944h) goto L13;
        o r6 = this.f19693a;
        kotlin.s0.w.d.l0.g.b r13 = r12.e().d(kotlin.s0.w.d.l0.g.f.k("DefaultImpls"));
        String r14 = "container.classId.create…EFAULT_IMPLS_CLASS_NAME))";
    L10:
        kotlin.n0.d.o.e(r13, r14);
        return p.b(r6, r13);
    L13:
        if (r10.booleanValue() == false) goto L27;
        if ((r7 instanceof kotlin.s0.w.d.l0.l.b.z.b) == false) goto L27;
        a1 r15 = r7.c();
        if ((r15 instanceof k) == false) goto L19;
        k r16 = (k) r15;
    L20:
        if (r16 == null) goto L22;
        kotlin.s0.w.d.l0.k.u.d r17 = r16.f();
    L23:
        if (r17 == null) goto L27;
        r6 = this.f19693a;
        String r0 = r17.f();
        kotlin.n0.d.o.e(r0, "facadeClassName.internalName");
        r13 = kotlin.s0.w.d.l0.g.b.m(new kotlin.s0.w.d.l0.g.c(kotlin.u0.k.v(r0, '/', '.', false, 4, null)));
        r14 = "topLevel(FqName(facadeCl…lName.replace('/', '.')))";
        goto L10
    L22:
        r17 = null;
        goto L23
    L19:
        r16 = null;
        goto L20
    L26:
        throw new IllegalStateException(("isConst should not be null for property (container=" + r7 + ')').toString());
    L27:
        if (r9 == false) goto L46;
        if ((r7 instanceof kotlin.s0.w.d.l0.l.b.z.a) == false) goto L46;
        kotlin.s0.w.d.l0.l.b.z.a r18 = (kotlin.s0.w.d.l0.l.b.z.a) r7;
        if (r18.g() != kotlin.s0.w.d.l0.f.c.EnumC0545c.m) goto L46;
        kotlin.s0.w.d.l0.l.b.z.a r19 = r18.h();
        if (r19 == null) goto L46;
        if (r19.g() == kotlin.s0.w.d.l0.f.c.EnumC0545c.f19943g) goto L44;
        if (r19.g() == kotlin.s0.w.d.l0.f.c.EnumC0545c.f19945i) goto L44;
        if (r11 == false) goto L46;
        if (r19.g() == kotlin.s0.w.d.l0.f.c.EnumC0545c.f19944h) goto L44;
        if (r19.g() != kotlin.s0.w.d.l0.f.c.EnumC0545c.f19947k) goto L46;
    L44:
        return B(r19);
    L46:
        if ((r7 instanceof kotlin.s0.w.d.l0.l.b.z.b) == true) goto L48;
    L53:
        return null;
    L48:
        if ((r7.c() instanceof k) == false) goto L53;
        a1 r20 = r7.c();
        kotlin.n0.d.o.d(r20, "null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
        k r21 = (k) r20;
        q r22 = r21.g();
        if (r22 == null) goto L52;
        return r22;
    L52:
        return p.b(this.f19693a, r21.d());
    }

    protected final boolean w(kotlin.s0.w.d.l0.g.b r4) {
        kotlin.n0.d.o.f(r4, "classId");
        if (r4.g() != null) goto L5;
        return false;
    L5:
        if (kotlin.n0.d.o.a(r4.j().b(), "Container") == false) goto L16;
        q r3 = p.b(this.f19693a, r4);
        if (r3 != null) goto L10;
        return false;
    L10:
        if (kotlin.s0.w.d.l0.a.f18663a.c(r3) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    protected abstract q.a x(kotlin.s0.w.d.l0.g.b r1, a1 r2, List<A> r3);

    protected final q.a y(kotlin.s0.w.d.l0.g.b r2, a1 r3, List<A> r4) {
        kotlin.n0.d.o.f(r2, "annotationClassId");
        kotlin.n0.d.o.f(r3, "source");
        kotlin.n0.d.o.f(r4, "result");
        if (kotlin.s0.w.d.l0.a.f18663a.b().contains(r2) == false) goto L7;
        return null;
    L7:
        return x(r2, r3, r4);
    }
}
