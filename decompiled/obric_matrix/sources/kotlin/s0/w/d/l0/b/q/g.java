package kotlin.s0.w.d.l0.b.q;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.i0.r;
import kotlin.i0.t0;
import kotlin.n0.d.d0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.n0.d.y;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.f0;
import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.c.j1;
import kotlin.s0.w.d.l0.c.k0;
import kotlin.s0.w.d.l0.c.m;
import kotlin.s0.w.d.l0.c.q1.z;
import kotlin.s0.w.d.l0.c.s;
import kotlin.s0.w.d.l0.c.t;
import kotlin.s0.w.d.l0.c.x;
import kotlin.s0.w.d.l0.c.z0;
import kotlin.s0.w.d.l0.e.b.u;
import kotlin.s0.w.d.l0.e.b.v;
import kotlin.s0.w.d.l0.m.n;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.l1;
import kotlin.s0.w.d.l0.n.m0;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements kotlin.s0.w.d.l0.c.p1.a, kotlin.s0.w.d.l0.c.p1.c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final /* synthetic */ kotlin.s0.l<Object>[] f18814h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h0 f18815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.b.q.d f18816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.i f18817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e0 f18818d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.i f18819e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.a<kotlin.s0.w.d.l0.g.c, kotlin.s0.w.d.l0.c.e> f18820f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.i f18821g;

    private static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f18822f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f18823g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f18824h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f18825i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ a[] f18826j = null;

        static {
            f18822f = new a("HIDDEN", 0);
            f18823g = new a("VISIBLE", 1);
            f18824h = new a("NOT_CONSIDERED", 2);
            f18825i = new a("DROP", 3);
            f18826j = a();
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{f18822f, f18823g, f18824h, f18825i};
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) f18826j.clone();
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18827a = null;

        static {
            int[] r0 = new int[a.values().length];
            r0[a.f18822f.ordinal()] = 1;
            r0[a.f18824h.ordinal()] = 2;
            r0[a.f18825i.ordinal()] = 3;
            r0[a.f18823g.ordinal()] = 4;
            f18827a = r0;
        }
    }

    static final class c extends q implements kotlin.n0.c.a<m0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ g f18828f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ n f18829g;

        c(g r1, n r2) {
            this.f18828f = r1;
            this.f18829g = r2;
            super(0);
        }

        public final m0 a() {
            return x.c(g.i(this.f18828f).a(), kotlin.s0.w.d.l0.b.q.e.f18787d.a(), new k0(this.f18829g, g.i(this.f18828f).a())).s();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ m0 invoke() {
            return a();
        }
    }

    public static final class d extends z {
        d(h0 r1, kotlin.s0.w.d.l0.g.c r2) {
            super(r1, r2);
        }

        public kotlin.s0.w.d.l0.k.w.h.b F0() {
            return kotlin.s0.w.d.l0.k.w.h.b.f20650b;
        }

        @Override // kotlin.s0.w.d.l0.c.l0
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.k.w.h q() {
            return F0();
        }
    }

    static final class e extends q implements kotlin.n0.c.a<e0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ g f18830f;

        e(g r1) {
            this.f18830f = r1;
            super(0);
        }

        public final e0 a() {
            m0 r1 = g.h(this.f18830f).o().i();
            o.e(r1, "moduleDescriptor.builtIns.anyType");
            return r1;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ e0 invoke() {
            return a();
        }
    }

    static final class f extends q implements kotlin.n0.c.a<kotlin.s0.w.d.l0.c.e> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.e.a.l0.l.f f18831f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.c.e f18832g;

        f(kotlin.s0.w.d.l0.e.a.l0.l.f r1, kotlin.s0.w.d.l0.c.e r2) {
            this.f18831f = r1;
            this.f18832g = r2;
            super(0);
        }

        public final kotlin.s0.w.d.l0.c.e a() {
            kotlin.s0.w.d.l0.e.a.l0.l.f r0 = this.f18831f;
            kotlin.s0.w.d.l0.e.a.j0.g r1 = kotlin.s0.w.d.l0.e.a.j0.g.f19318a;
            o.e(r1, "EMPTY");
            return r0.O0(r1, this.f18832g);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.e invoke() {
            return a();
        }
    }

    /* JADX INFO: renamed from: kotlin.s0.w.d.l0.b.q.g$g, reason: collision with other inner class name */
    static final class C0499g extends q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.k.w.h, Collection<? extends z0>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.g.f f18833f;

        C0499g(kotlin.s0.w.d.l0.g.f r1) {
            this.f18833f = r1;
            super(1);
        }

        public final Collection<z0> a(kotlin.s0.w.d.l0.k.w.h r2) {
            o.f(r2, "it");
            return r2.a(this.f18833f, kotlin.s0.w.d.l0.d.b.d.f19189i);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Collection<? extends z0> invoke(kotlin.s0.w.d.l0.k.w.h r1) {
            return a(r1);
        }
    }

    static final class h<N> implements kotlin.s0.w.d.l0.p.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f18834a;

        h(g r1) {
            this.f18834a = r1;
        }

        @Override // kotlin.s0.w.d.l0.p.b.c
        public /* bridge */ /* synthetic */ Iterable a(Object r1) {
            return b((kotlin.s0.w.d.l0.c.e) r1);
        }

        public final Iterable<kotlin.s0.w.d.l0.c.e> b(kotlin.s0.w.d.l0.c.e r5) {
            Collection<e0> r6 = r5.k().a();
            o.e(r6, "it.typeConstructor.supertypes");
            g r4 = this.f18834a;
            ArrayList r0 = new ArrayList();
            Iterator<T> r7 = r6.iterator();
        L4:
            if (r7.hasNext() == false) goto L17;
            kotlin.s0.w.d.l0.c.h r1 = ((e0) r7.next()).O0().d();
            kotlin.s0.w.d.l0.e.a.l0.l.f r2 = null;
            if (r1 == null) goto L8;
            kotlin.s0.w.d.l0.c.h r3 = r1.a();
        L10:
            if ((r3 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L12;
            kotlin.s0.w.d.l0.c.e r8 = (kotlin.s0.w.d.l0.c.e) r3;
        L13:
            if (r8 == null) goto L15;
            r2 = g.g(r4, r8);
        L15:
            if (r2 == null) goto L4;
            r0.add(r2);
            goto L4
        L12:
            r8 = null;
            goto L13
        L8:
            r3 = null;
            goto L10
        L17:
            return r0;
        }
    }

    public static final class i extends kotlin.s0.w.d.l0.p.b.AbstractC0585b<kotlin.s0.w.d.l0.c.e, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f18835a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d0<a> f18836b;

        i(String r1, d0<a> r2) {
            this.f18835a = r1;
            this.f18836b = r2;
        }

        @Override // kotlin.s0.w.d.l0.p.b.d
        public /* bridge */ /* synthetic */ Object a() {
            return e();
        }

        @Override // kotlin.s0.w.d.l0.p.b.d
        public /* bridge */ /* synthetic */ boolean c(Object r1) {
            return d((kotlin.s0.w.d.l0.c.e) r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean d(kotlin.s0.w.d.l0.c.e r3) {
            o.f(r3, "javaClassDescriptor");
            String r4 = u.a(kotlin.s0.w.d.l0.e.b.x.f19797a, r3, this.f18835a);
            kotlin.s0.w.d.l0.b.q.i r0 = kotlin.s0.w.d.l0.b.q.i.f18840a;
            if (r0.e().contains(r4) == false) goto L7;
            d0<a> r5 = this.f18836b;
            T r1 = a.f18822f;
        L5:
            r5.f18431f = r1;
        L13:
            if (this.f18836b.f18431f != null) goto L15;
            return true;
        L15:
            return false;
        L7:
            if (r0.h().contains(r4) == false) goto L10;
            r5 = this.f18836b;
            r1 = a.f18823g;
            goto L5
        L10:
            if (r0.c().contains(r4) == false) goto L13;
            r5 = this.f18836b;
            r1 = a.f18825i;
            goto L5
        }

        public a e() {
            a r0 = this.f18836b.f18431f;
            if (r0 == null) goto L5;
            return r0;
        L5:
            return a.f18824h;
        }
    }

    static final class j<N> implements kotlin.s0.w.d.l0.p.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j<N> f18837a = null;

        static {
            f18837a = new j();
        }

        j() {
        }

        @Override // kotlin.s0.w.d.l0.p.b.c
        public /* bridge */ /* synthetic */ Iterable a(Object r1) {
            return b((kotlin.s0.w.d.l0.c.b) r1);
        }

        public final Iterable<kotlin.s0.w.d.l0.c.b> b(kotlin.s0.w.d.l0.c.b r1) {
            return r1.a().f();
        }
    }

    static final class k extends q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.c.b, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ g f18838f;

        k(g r1) {
            this.f18838f = r1;
            super(1);
        }

        public final Boolean a(kotlin.s0.w.d.l0.c.b r3) {
            if (r3.i() != kotlin.s0.w.d.l0.c.b.a.f18848f) goto L7;
            kotlin.s0.w.d.l0.b.q.d r2 = g.f(this.f18838f);
            m r4 = r3.c();
            o.d(r4, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            if (r2.c((kotlin.s0.w.d.l0.c.e) r4) == false) goto L7;
            boolean r5 = true;
        L9:
            return Boolean.valueOf(r5);
        L7:
            r5 = false;
            goto L9
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(kotlin.s0.w.d.l0.c.b r1) {
            return a(r1);
        }
    }

    static final class l extends q implements kotlin.n0.c.a<kotlin.s0.w.d.l0.c.o1.g> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ g f18839f;

        l(g r1) {
            this.f18839f = r1;
            super(0);
        }

        public final kotlin.s0.w.d.l0.c.o1.g a() {
            kotlin.s0.w.d.l0.c.o1.c r6 = kotlin.s0.w.d.l0.c.o1.f.b(g.h(this.f18839f).o(), "This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version", null, null, 6, null);
            return kotlin.s0.w.d.l0.c.o1.g.f18919b.a(r.d(r6));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.o1.g invoke() {
            return a();
        }
    }

    static {
        f18814h = new kotlin.s0.l[]{kotlin.n0.d.e0.g(new y(kotlin.n0.d.e0.b(g.class), "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns$Settings;")), kotlin.n0.d.e0.g(new y(kotlin.n0.d.e0.b(g.class), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), kotlin.n0.d.e0.g(new y(kotlin.n0.d.e0.b(g.class), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;"))};
    }

    public g(h0 r2, n r3, kotlin.n0.c.a<kotlin.s0.w.d.l0.b.q.f.b> r4) {
        o.f(r2, "moduleDescriptor");
        o.f(r3, "storageManager");
        o.f(r4, "settingsComputation");
        this.f18815a = r2;
        this.f18816b = kotlin.s0.w.d.l0.b.q.d.f18786a;
        this.f18817c = r3.d(r4);
        this.f18818d = k(r3);
        this.f18819e = r3.d(new c(this, r3));
        this.f18820f = r3.b();
        this.f18821g = r3.d(new l(this));
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.b.q.d f(g r0) {
        return r0.f18816b;
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.e.a.l0.l.f g(g r0, kotlin.s0.w.d.l0.c.e r1) {
        return r0.p(r1);
    }

    public static final /* synthetic */ h0 h(g r0) {
        return r0.f18815a;
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.b.q.f.b i(g r0) {
        return r0.s();
    }

    private final z0 j(kotlin.s0.w.d.l0.l.b.g0.d r1, z0 r2) {
        kotlin.s0.w.d.l0.c.y.a<? extends z0> r0 = r2.t();
        r0.o(r1);
        r0.n(t.f19163e);
        r0.f(r1.s());
        r0.d(r1.K0());
        kotlin.s0.w.d.l0.c.y r3 = r0.build();
        o.c(r3);
        return (z0) r3;
    }

    private final e0 k(n r13) {
        d r4 = new d(this.f18815a, new kotlin.s0.w.d.l0.g.c("java.io"));
        List r8 = r.d(new kotlin.s0.w.d.l0.n.h0(r13, new e(this)));
        kotlin.s0.w.d.l0.c.q1.h r12 = new kotlin.s0.w.d.l0.c.q1.h(r4, kotlin.s0.w.d.l0.g.f.k("Serializable"), kotlin.s0.w.d.l0.c.e0.f18863j, kotlin.s0.w.d.l0.c.f.f18866g, r8, a1.f18847a, false, r13);
        r12.L0(kotlin.s0.w.d.l0.k.w.h.b.f20650b, t0.b(), null);
        m0 r14 = r12.s();
        o.e(r14, "mockSerializableClass.defaultType");
        return r14;
    }

    private final Collection<z0> l(kotlin.s0.w.d.l0.c.e r10, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.k.w.h, ? extends Collection<? extends z0>> r11) {
        kotlin.s0.w.d.l0.e.a.l0.l.f r0 = p(r10);
        if (r0 == null) goto L5;
        Collection<kotlin.s0.w.d.l0.c.e> r1 = this.f18816b.g(kotlin.s0.w.d.l0.k.t.a.h(r0), kotlin.s0.w.d.l0.b.q.b.f18769g.a());
        kotlin.s0.w.d.l0.c.e r2 = (kotlin.s0.w.d.l0.c.e) r.c0(r1);
        if (r2 == null) goto L9;
        kotlin.s0.w.d.l0.p.f.b r3 = kotlin.s0.w.d.l0.p.f.f21288h;
        ArrayList r4 = new ArrayList(r.q(r1, 10));
        Iterator<T> r5 = r1.iterator();
    L12:
        if (r5.hasNext() == false) goto L14;
        r4.add(kotlin.s0.w.d.l0.k.t.a.h((kotlin.s0.w.d.l0.c.e) r5.next()));
        goto L12
    L14:
        kotlin.s0.w.d.l0.p.f r6 = r3.b(r4);
        boolean r12 = this.f18816b.c(r10);
        kotlin.s0.w.d.l0.k.w.h r7 = this.f18820f.a(kotlin.s0.w.d.l0.k.t.a.h(r0), new f(r0, r2)).D0();
        o.e(r7, "fakeJavaClassDescriptor.unsubstitutedMemberScope");
        Collection<? extends z0> r13 = r11.invoke(r7);
        ArrayList r8 = new ArrayList();
        Iterator<T> r14 = r13.iterator();
    L16:
        if (r14.hasNext() == false) goto L43;
        Object r9 = r14.next();
        z0 r15 = (z0) r9;
        boolean r16 = true;
        if (r15.i() == kotlin.s0.w.d.l0.c.b.a.f18848f) goto L21;
    L19:
        r16 = false;
    L41:
        if (r16 == false) goto L16;
        r8.add(r9);
        goto L16
    L21:
        if (r15.getVisibility().d() == false) goto L19;
        if (kotlin.s0.w.d.l0.b.h.j0(r15) == true) goto L19;
        Collection<? extends kotlin.s0.w.d.l0.c.y> r17 = r15.f();
        o.e(r17, "analogueMember.overriddenDescriptors");
        if ((r17 instanceof Collection) == true) goto L29;
    L31:
        Iterator<T> r18 = r17.iterator();
    L33:
        if (r18.hasNext() == false) goto L30;
        m r19 = ((kotlin.s0.w.d.l0.c.y) r18.next()).c();
        o.e(r19, "it.containingDeclaration");
        if (r6.contains(kotlin.s0.w.d.l0.k.t.a.h(r19)) == false) goto L33;
        boolean r20 = true;
    L37:
        if (r20 == true) goto L19;
        if (t(r15, r12) == true) goto L19;
    L30:
        r20 = false;
        goto L37
    L29:
        if (r17.isEmpty() == false) goto L31;
    L43:
        return r8;
    L9:
        return r.g();
    L5:
        return r.g();
    }

    private final m0 m() {
        return (m0) kotlin.s0.w.d.l0.m.m.a(this.f18819e, this, f18814h[1]);
    }

    private static final boolean n(kotlin.s0.w.d.l0.c.l r0, l1 r1, kotlin.s0.w.d.l0.c.l r2) {
        if (kotlin.s0.w.d.l0.k.j.x(r0, r2.d(r1)) != kotlin.s0.w.d.l0.k.j.i.a.f20542f) goto L5;
        return true;
    L5:
        return false;
    }

    private final kotlin.s0.w.d.l0.e.a.l0.l.f p(kotlin.s0.w.d.l0.c.e r3) {
        if (kotlin.s0.w.d.l0.b.h.a0(r3) == false) goto L6;
        return null;
    L6:
        if (kotlin.s0.w.d.l0.b.h.A0(r3) == true) goto L8;
        return null;
    L8:
        kotlin.s0.w.d.l0.g.d r4 = kotlin.s0.w.d.l0.k.t.a.i(r3);
        if (r4.f() == true) goto L11;
        return null;
    L11:
        kotlin.s0.w.d.l0.g.b r5 = kotlin.s0.w.d.l0.b.q.c.f18771a.n(r4);
        if (r5 == null) goto L20;
        kotlin.s0.w.d.l0.g.c r6 = r5.b();
        if (r6 == null) goto L22;
        kotlin.s0.w.d.l0.c.e r2 = s.c(s().a(), r6, kotlin.s0.w.d.l0.d.b.d.f19189i);
        if ((r2 instanceof kotlin.s0.w.d.l0.e.a.l0.l.f) == true) goto L19;
        return null;
    L19:
        return (kotlin.s0.w.d.l0.e.a.l0.l.f) r2;
    L22:
        return null;
    L20:
        return null;
    }

    private final a q(kotlin.s0.w.d.l0.c.y r5) {
        m r0 = r5.c();
        o.d(r0, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        String r6 = v.c(r5, false, false, 3, null);
        d0 r1 = new d0();
        Object r4 = kotlin.s0.w.d.l0.p.b.b(r.d((kotlin.s0.w.d.l0.c.e) r0), new h(this), new i(r6, r1));
        o.e(r4, "private fun FunctionDesc…ERED\n            })\n    }");
        return (a) r4;
    }

    private final kotlin.s0.w.d.l0.c.o1.g r() {
        return (kotlin.s0.w.d.l0.c.o1.g) kotlin.s0.w.d.l0.m.m.a(this.f18821g, this, f18814h[2]);
    }

    private final kotlin.s0.w.d.l0.b.q.f.b s() {
        return (kotlin.s0.w.d.l0.b.q.f.b) kotlin.s0.w.d.l0.m.m.a(this.f18817c, this, f18814h[0]);
    }

    private final boolean t(z0 r5, boolean r6) {
        m r0 = r5.c();
        o.d(r0, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        String r1 = v.c(r5, false, false, 3, null);
        Set<String> r2 = kotlin.s0.w.d.l0.b.q.i.f18840a.f();
        kotlin.s0.w.d.l0.e.b.x r3 = kotlin.s0.w.d.l0.e.b.x.f19797a;
        if ((r6 ^ r2.contains(u.a(r3, (kotlin.s0.w.d.l0.c.e) r0, r1))) == false) goto L6;
        return true;
    L6:
        Boolean r4 = kotlin.s0.w.d.l0.p.b.e(r.d(r5), j.f18837a, new k(this));
        o.e(r4, "private fun SimpleFuncti…scriptor)\n        }\n    }");
        return r4.booleanValue();
    }

    private final boolean u(kotlin.s0.w.d.l0.c.l r2, kotlin.s0.w.d.l0.c.e r3) {
        if (r2.h().size() != 1) goto L11;
        List<j1> r1 = r2.h();
        o.e(r1, "valueParameters");
        kotlin.s0.w.d.l0.c.h r4 = ((j1) r.o0(r1)).b().O0().d();
        if (r4 == null) goto L7;
        kotlin.s0.w.d.l0.g.d r5 = kotlin.s0.w.d.l0.k.t.a.i(r4);
    L9:
        if (o.a(r5, kotlin.s0.w.d.l0.k.t.a.i(r3)) == false) goto L11;
        return true;
    L7:
        r5 = null;
    L11:
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.p1.a
    public Collection<kotlin.s0.w.d.l0.c.d> a(kotlin.s0.w.d.l0.c.e r15) {
        o.f(r15, "classDescriptor");
        if (r15.i() != kotlin.s0.w.d.l0.c.f.f18865f) goto L50;
        if (s().b() == false) goto L50;
        kotlin.s0.w.d.l0.e.a.l0.l.f r0 = p(r15);
        if (r0 == null) goto L10;
        kotlin.s0.w.d.l0.c.e r1 = kotlin.s0.w.d.l0.b.q.d.f(this.f18816b, kotlin.s0.w.d.l0.k.t.a.h(r0), kotlin.s0.w.d.l0.b.q.b.f18769g.a(), null, 4, null);
        if (r1 == null) goto L14;
        l1 r2 = kotlin.s0.w.d.l0.b.q.j.a(r1, r0).c();
        List<kotlin.s0.w.d.l0.c.d> r3 = r0.P0();
        ArrayList r4 = new ArrayList();
        Iterator<T> r5 = r3.iterator();
    L16:
        boolean r8 = false;
        if (r5.hasNext() == false) goto L41;
        Object r6 = r5.next();
        kotlin.s0.w.d.l0.c.d r9 = (kotlin.s0.w.d.l0.c.d) r6;
        if (r9.getVisibility().d() == false) goto L39;
        Collection<kotlin.s0.w.d.l0.c.d> r10 = r1.m();
        o.e(r10, "defaultKotlinVersion.constructors");
        if ((r10 instanceof Collection) == true) goto L23;
    L25:
        Iterator<T> r11 = r10.iterator();
    L27:
        if (r11.hasNext() == false) goto L24;
        kotlin.s0.w.d.l0.c.d r12 = (kotlin.s0.w.d.l0.c.d) r11.next();
        o.e(r12, "it");
        if (n(r12, r2, r9) == false) goto L27;
        boolean r13 = false;
    L31:
        if (r13 == false) goto L39;
        if (u(r9, r15) == true) goto L39;
        if (kotlin.s0.w.d.l0.b.h.j0(r9) == true) goto L39;
        if (kotlin.s0.w.d.l0.b.q.i.f18840a.d().contains(u.a(kotlin.s0.w.d.l0.e.b.x.f19797a, r0, v.c(r9, false, false, 3, null))) == true) goto L39;
        r8 = true;
    L24:
        r13 = true;
        goto L31
    L23:
        if (r10.isEmpty() == false) goto L25;
    L39:
        if (r8 == false) goto L16;
        r4.add(r6);
        goto L16
    L41:
        ArrayList r7 = new ArrayList(r.q(r4, 10));
        Iterator r14 = r4.iterator();
    L43:
        if (r14.hasNext() == false) goto L48;
        kotlin.s0.w.d.l0.c.d r16 = (kotlin.s0.w.d.l0.c.d) r14.next();
        kotlin.s0.w.d.l0.c.y.a<? extends kotlin.s0.w.d.l0.c.y> r17 = r16.t();
        r17.o(r15);
        r17.f(r15.s());
        r17.e();
        r17.k(r2.j());
        if (kotlin.s0.w.d.l0.b.q.i.f18840a.g().contains(u.a(kotlin.s0.w.d.l0.e.b.x.f19797a, r0, v.c(r16, false, false, 3, null))) == true) goto L47;
        r17.r(r());
    L47:
        kotlin.s0.w.d.l0.c.y r18 = r17.build();
        o.d(r18, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
        r7.add((kotlin.s0.w.d.l0.c.d) r18);
        goto L43
    L48:
        return r7;
    L14:
        return r.g();
    L10:
        return r.g();
    L50:
        return r.g();
    }

    @Override // kotlin.s0.w.d.l0.c.p1.a
    public Collection<z0> b(kotlin.s0.w.d.l0.g.f r7, kotlin.s0.w.d.l0.c.e r8) {
        o.f(r7, "name");
        o.f(r8, "classDescriptor");
        boolean r1 = true;
        if (o.a(r7, kotlin.s0.w.d.l0.b.q.a.f18767e.a()) == false) goto L24;
        if ((r8 instanceof kotlin.s0.w.d.l0.l.b.g0.d) == false) goto L24;
        if (kotlin.s0.w.d.l0.b.h.d0(r8) == false) goto L24;
        kotlin.s0.w.d.l0.l.b.g0.d r9 = (kotlin.s0.w.d.l0.l.b.g0.d) r8;
        List<kotlin.s0.w.d.l0.f.i> r0 = r9.c1().H0();
        o.e(r0, "classDescriptor.classProto.functionList");
        if ((r0 instanceof Collection) == true) goto L11;
    L13:
        Iterator<T> r2 = r0.iterator();
    L15:
        if (r2.hasNext() == false) goto L12;
        if (o.a(kotlin.s0.w.d.l0.l.b.x.b(r9.b1().g(), ((kotlin.s0.w.d.l0.f.i) r2.next()).d0()), kotlin.s0.w.d.l0.b.q.a.f18767e.a()) == false) goto L15;
    L18:
        if (r1 == false) goto L22;
        return r.g();
    L22:
        return r.d(j(r9, (z0) r.n0(m().q().a(r7, kotlin.s0.w.d.l0.d.b.d.f19189i))));
    L12:
        r1 = false;
        goto L18
    L11:
        if (r0.isEmpty() == false) goto L13;
    L24:
        if (s().b() == false) goto L26;
        Collection<z0> r10 = l(r8, new C0499g(r7));
        ArrayList r3 = new ArrayList();
        Iterator<T> r11 = r10.iterator();
    L29:
        if (r11.hasNext() == false) goto L45;
        z0 r4 = (z0) r11.next();
        m r5 = r4.c();
        o.d(r5, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        kotlin.s0.w.d.l0.c.y r6 = r4.d(kotlin.s0.w.d.l0.b.q.j.a((kotlin.s0.w.d.l0.c.e) r5, r8).c());
        o.d(r6, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor");
        kotlin.s0.w.d.l0.c.y.a<? extends z0> r12 = ((z0) r6).t();
        r12.o(r8);
        r12.d(r8.K0());
        r12.e();
        int r13 = b.f18827a[q(r4).ordinal()];
        z0 r14 = null;
        if (r13 == 1) goto L39;
        if (r13 != 2) goto L35;
        r12.r(r());
    L42:
        kotlin.s0.w.d.l0.c.y r15 = r12.build();
        o.c(r15);
        r14 = (z0) r15;
    L43:
        if (r14 == null) goto L29;
        r3.add(r14);
        goto L29
    L35:
        if (r13 == 3) goto L43;
    L39:
        if (f0.a(r8) == true) goto L43;
        r12.h();
        goto L42
    L45:
        return r3;
    L26:
        return r.g();
    }

    @Override // kotlin.s0.w.d.l0.c.p1.c
    public boolean c(kotlin.s0.w.d.l0.c.e r6, z0 r7) {
        o.f(r6, "classDescriptor");
        o.f(r7, "functionDescriptor");
        kotlin.s0.w.d.l0.e.a.l0.l.f r8 = p(r6);
        if (r8 != null) goto L6;
        return true;
    L6:
        if (r7.getAnnotations().k(kotlin.s0.w.d.l0.c.p1.d.a()) == true) goto L9;
        return true;
    L9:
        if (s().b() == true) goto L11;
        return false;
    L11:
        String r3 = v.c(r7, false, false, 3, null);
        kotlin.s0.w.d.l0.e.a.l0.l.g r9 = r8.T0();
        kotlin.s0.w.d.l0.g.f r10 = r7.getName();
        o.e(r10, "functionDescriptor.name");
        Collection<z0> r11 = r9.a(r10, kotlin.s0.w.d.l0.d.b.d.f19189i);
        if ((r11 instanceof Collection) == true) goto L14;
    L16:
        Iterator<T> r12 = r11.iterator();
    L18:
        if (r12.hasNext() == false) goto L21;
        if (o.a(v.c((z0) r12.next(), false, false, 3, null), r3) == false) goto L18;
        return true;
    L21:
        return false;
    L14:
        if (r11.isEmpty() == false) goto L16;
        goto L16
    }

    @Override // kotlin.s0.w.d.l0.c.p1.a
    public Collection<e0> d(kotlin.s0.w.d.l0.c.e r4) {
        o.f(r4, "classDescriptor");
        kotlin.s0.w.d.l0.g.d r5 = kotlin.s0.w.d.l0.k.t.a.i(r4);
        kotlin.s0.w.d.l0.b.q.i r0 = kotlin.s0.w.d.l0.b.q.i.f18840a;
        if (r0.i(r5) == false) goto L6;
        m0 r1 = m();
        o.e(r1, "cloneableType");
        return r.j(new e0[]{r1, this.f18818d});
    L6:
        if (r0.j(r5) == false) goto L9;
        return r.d(this.f18818d);
    L9:
        return r.g();
    }

    @Override // kotlin.s0.w.d.l0.c.p1.a
    public /* bridge */ /* synthetic */ Collection e(kotlin.s0.w.d.l0.c.e r1) {
        return o(r1);
    }

    public Set<kotlin.s0.w.d.l0.g.f> o(kotlin.s0.w.d.l0.c.e r2) {
        o.f(r2, "classDescriptor");
        if (s().b() == false) goto L5;
        kotlin.s0.w.d.l0.e.a.l0.l.f r1 = p(r2);
        if (r1 == null) goto L13;
        kotlin.s0.w.d.l0.e.a.l0.l.g r3 = r1.T0();
        if (r3 == null) goto L13;
        Set<kotlin.s0.w.d.l0.g.f> r4 = r3.b();
        if (r4 == null) goto L13;
        return r4;
    L13:
        return t0.b();
    L5:
        return t0.b();
    }
}
