package kotlin.s0.w.d.l0.c.s1.b;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.n0.d.e0;
import kotlin.n0.d.h0;
import kotlin.s0.w.d.l0.c.n1;
import kotlin.s0.w.d.l0.e.a.n0.d0;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends p implements kotlin.s0.w.d.l0.c.s1.b.h, v, kotlin.s0.w.d.l0.e.a.n0.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<?> f19136a;

    /* synthetic */ class a extends kotlin.n0.d.l implements kotlin.n0.c.l<Member, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f19137f = null;

        static {
            f19137f = new a();
        }

        a() {
            super(1);
        }

        @Override // kotlin.n0.d.c, kotlin.s0.c
        public final String getName() {
            return "isSynthetic";
        }

        @Override // kotlin.n0.d.c
        public final kotlin.s0.f getOwner() {
            return e0.b(Member.class);
        }

        @Override // kotlin.n0.d.c
        public final String getSignature() {
            return "isSynthetic()Z";
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(Member r1) {
            return m(r1);
        }

        public final Boolean m(Member r1) {
            kotlin.n0.d.o.f(r1, "p0");
            return Boolean.valueOf(r1.isSynthetic());
        }
    }

    /* synthetic */ class b extends kotlin.n0.d.l implements kotlin.n0.c.l<Constructor<?>, o> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f19138f = null;

        static {
            f19138f = new b();
        }

        b() {
            super(1);
        }

        @Override // kotlin.n0.d.c, kotlin.s0.c
        public final String getName() {
            return "<init>";
        }

        @Override // kotlin.n0.d.c
        public final kotlin.s0.f getOwner() {
            return e0.b(o.class);
        }

        @Override // kotlin.n0.d.c
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Constructor;)V";
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ o invoke(Constructor<?> r1) {
            return m(r1);
        }

        public final o m(Constructor<?> r1) {
            kotlin.n0.d.o.f(r1, "p0");
            return new o(r1);
        }
    }

    /* synthetic */ class c extends kotlin.n0.d.l implements kotlin.n0.c.l<Member, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f19139f = null;

        static {
            f19139f = new c();
        }

        c() {
            super(1);
        }

        @Override // kotlin.n0.d.c, kotlin.s0.c
        public final String getName() {
            return "isSynthetic";
        }

        @Override // kotlin.n0.d.c
        public final kotlin.s0.f getOwner() {
            return e0.b(Member.class);
        }

        @Override // kotlin.n0.d.c
        public final String getSignature() {
            return "isSynthetic()Z";
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(Member r1) {
            return m(r1);
        }

        public final Boolean m(Member r1) {
            kotlin.n0.d.o.f(r1, "p0");
            return Boolean.valueOf(r1.isSynthetic());
        }
    }

    /* synthetic */ class d extends kotlin.n0.d.l implements kotlin.n0.c.l<Field, r> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final d f19140f = null;

        static {
            f19140f = new d();
        }

        d() {
            super(1);
        }

        @Override // kotlin.n0.d.c, kotlin.s0.c
        public final String getName() {
            return "<init>";
        }

        @Override // kotlin.n0.d.c
        public final kotlin.s0.f getOwner() {
            return e0.b(r.class);
        }

        @Override // kotlin.n0.d.c
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Field;)V";
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ r invoke(Field r1) {
            return m(r1);
        }

        public final r m(Field r1) {
            kotlin.n0.d.o.f(r1, "p0");
            return new r(r1);
        }
    }

    static final class e extends kotlin.n0.d.q implements kotlin.n0.c.l<Class<?>, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final e f19141f = null;

        static {
            f19141f = new e();
        }

        e() {
            super(1);
        }

        public final Boolean a(Class<?> r1) {
            String r0 = r1.getSimpleName();
            kotlin.n0.d.o.e(r0, "it.simpleName");
            if (r0.length() != 0) goto L5;
            boolean r2 = true;
        L7:
            return Boolean.valueOf(r2);
        L5:
            r2 = false;
            goto L7
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(Class<?> r1) {
            return a(r1);
        }
    }

    static final class f extends kotlin.n0.d.q implements kotlin.n0.c.l<Class<?>, kotlin.s0.w.d.l0.g.f> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final f f19142f = null;

        static {
            f19142f = new f();
        }

        f() {
            super(1);
        }

        public final kotlin.s0.w.d.l0.g.f a(Class<?> r2) {
            String r1 = r2.getSimpleName();
            if (kotlin.s0.w.d.l0.g.f.m(r1) == true) goto L6;
            r1 = null;
        L6:
            if (r1 != null) goto L8;
            return null;
        L8:
            return kotlin.s0.w.d.l0.g.f.k(r1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.g.f invoke(Class<?> r1) {
            return a(r1);
        }
    }

    static final class g extends kotlin.n0.d.q implements kotlin.n0.c.l<Method, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ l f19143f;

        g(l r1) {
            this.f19143f = r1;
            super(1);
        }

        public final Boolean a(Method r4) {
            boolean r1 = true;
            if (r4.isSynthetic() == false) goto L6;
        L4:
            r1 = false;
        L10:
            return Boolean.valueOf(r1);
        L6:
            if (this.f19143f.A() == false) goto L10;
            l r3 = this.f19143f;
            kotlin.n0.d.o.e(r4, "method");
            if (l.R(r3, r4) == true) goto L4;
            goto L4
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(Method r1) {
            return a(r1);
        }
    }

    /* synthetic */ class h extends kotlin.n0.d.l implements kotlin.n0.c.l<Method, u> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final h f19144f = null;

        static {
            f19144f = new h();
        }

        h() {
            super(1);
        }

        @Override // kotlin.n0.d.c, kotlin.s0.c
        public final String getName() {
            return "<init>";
        }

        @Override // kotlin.n0.d.c
        public final kotlin.s0.f getOwner() {
            return e0.b(u.class);
        }

        @Override // kotlin.n0.d.c
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Method;)V";
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ u invoke(Method r1) {
            return m(r1);
        }

        public final u m(Method r1) {
            kotlin.n0.d.o.f(r1, "p0");
            return new u(r1);
        }
    }

    public l(Class<?> r2) {
        kotlin.n0.d.o.f(r2, "klass");
        this.f19136a = r2;
    }

    public static final /* synthetic */ boolean R(l r0, Method r1) {
        return r0.a0(r1);
    }

    private final boolean a0(Method r4) {
        String r3 = r4.getName();
        if (kotlin.n0.d.o.a(r3, "values") == false) goto L8;
        Class<?>[] r5 = r4.getParameterTypes();
        kotlin.n0.d.o.e(r5, "method.parameterTypes");
        if (r5.length != 0) goto L11;
        return true;
    L11:
        return false;
    L8:
        if (kotlin.n0.d.o.a(r3, "valueOf") == false) goto L11;
        return Arrays.equals(r4.getParameterTypes(), new Class[]{String.class});
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.g
    public boolean A() {
        return this.f19136a.isEnum();
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.g
    public /* bridge */ /* synthetic */ Collection C() {
        return W();
    }

    @Override // kotlin.s0.w.d.l0.c.s1.b.v
    public int D() {
        return this.f19136a.getModifiers();
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.g
    public boolean E() {
        Boolean r1 = kotlin.s0.w.d.l0.c.s1.b.b.f19104a.f(this.f19136a);
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.booleanValue();
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.g
    public boolean H() {
        return this.f19136a.isInterface();
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.g
    public d0 I() {
        return null;
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.g
    public /* bridge */ /* synthetic */ Collection K() {
        return X();
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.g
    public /* bridge */ /* synthetic */ Collection M() {
        return Y();
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.g
    public Collection<kotlin.s0.w.d.l0.e.a.n0.j> N() {
        Class<?>[] r5 = kotlin.s0.w.d.l0.c.s1.b.b.f19104a.c(this.f19136a);
        if (r5 == null) goto L8;
        ArrayList r0 = new ArrayList(r5.length);
        int r1 = 0;
        int r2 = r5.length;
    L5:
        if (r1 >= r2) goto L10;
        r0.add(new n(r5[r1]));
        r1 = r1 + 1;
        goto L5
    L10:
        return r0;
    L8:
        return kotlin.i0.r.g();
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.s
    public boolean Q() {
        return v.a.d(this);
    }

    public kotlin.s0.w.d.l0.c.s1.b.e S(kotlin.s0.w.d.l0.g.c r1) {
        return kotlin.s0.w.d.l0.c.s1.b.h.a.a(this, r1);
    }

    public List<kotlin.s0.w.d.l0.c.s1.b.e> T() {
        return kotlin.s0.w.d.l0.c.s1.b.h.a.b(this);
    }

    public List<o> U() {
        Constructor<?>[] r1 = this.f19136a.getDeclaredConstructors();
        kotlin.n0.d.o.e(r1, "klass.declaredConstructors");
        return kotlin.t0.k.z(kotlin.t0.k.t(kotlin.t0.k.o(kotlin.i0.i.q(r1), a.f19137f), b.f19138f));
    }

    public Class<?> V() {
        return this.f19136a;
    }

    public List<r> W() {
        Field[] r1 = this.f19136a.getDeclaredFields();
        kotlin.n0.d.o.e(r1, "klass.declaredFields");
        return kotlin.t0.k.z(kotlin.t0.k.t(kotlin.t0.k.o(kotlin.i0.i.q(r1), c.f19139f), d.f19140f));
    }

    public List<kotlin.s0.w.d.l0.g.f> X() {
        Class<?>[] r1 = this.f19136a.getDeclaredClasses();
        kotlin.n0.d.o.e(r1, "klass.declaredClasses");
        return kotlin.t0.k.z(kotlin.t0.k.u(kotlin.t0.k.o(kotlin.i0.i.q(r1), e.f19141f), f.f19142f));
    }

    public List<u> Y() {
        Method[] r0 = this.f19136a.getDeclaredMethods();
        kotlin.n0.d.o.e(r0, "klass.declaredMethods");
        return kotlin.t0.k.z(kotlin.t0.k.t(kotlin.t0.k.n(kotlin.i0.i.q(r0), new g(this)), h.f19144f));
    }

    public l Z() {
        Class<?> r1 = this.f19136a.getDeclaringClass();
        if (r1 != null) goto L7;
        return null;
    L7:
        return new l(r1);
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.g
    public Collection<kotlin.s0.w.d.l0.e.a.n0.j> a() {
        Type r0 = Object.class;
        if (kotlin.n0.d.o.a(this.f19136a, r0) == true) goto L5;
        h0 r1 = new h0(2);
        Type r2 = this.f19136a.getGenericSuperclass();
        if (r2 == null) goto L10;
        r0 = r2;
    L10:
        r1.a(r0);
        Type[] r3 = this.f19136a.getGenericInterfaces();
        kotlin.n0.d.o.e(r3, "klass.genericInterfaces");
        r1.b(r3);
        List r4 = kotlin.i0.r.j(r1.d(new Type[r1.c()]));
        ArrayList r5 = new ArrayList(kotlin.i0.r.q(r4, 10));
        Iterator r6 = r4.iterator();
    L12:
        if (r6.hasNext() == false) goto L14;
        r5.add(new n((Type) r6.next()));
        goto L12
    L14:
        return r5;
    L5:
        return kotlin.i0.r.g();
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.g
    public kotlin.s0.w.d.l0.g.c e() {
        kotlin.s0.w.d.l0.g.c r1 = kotlin.s0.w.d.l0.c.s1.b.d.a(this.f19136a).b();
        kotlin.n0.d.o.e(r1, "klass.classId.asSingleFqName()");
        return r1;
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof l) == true) goto L5;
    L7:
        return false;
    L5:
        if (kotlin.n0.d.o.a(this.f19136a, ((l) r2).f19136a) == false) goto L7;
        return true;
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.d
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return T();
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.t
    public kotlin.s0.w.d.l0.g.f getName() {
        kotlin.s0.w.d.l0.g.f r1 = kotlin.s0.w.d.l0.g.f.k(this.f19136a.getSimpleName());
        kotlin.n0.d.o.e(r1, "identifier(klass.simpleName)");
        return r1;
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.z
    public List<a0> getTypeParameters() {
        TypeVariable<Class<?>>[] r5 = this.f19136a.getTypeParameters();
        kotlin.n0.d.o.e(r5, "klass.typeParameters");
        ArrayList r0 = new ArrayList(r5.length);
        int r1 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.add(new a0(r5[r2]));
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.s
    public n1 getVisibility() {
        return v.a.a(this);
    }

    public int hashCode() {
        return this.f19136a.hashCode();
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.d
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.e.a.n0.a i(kotlin.s0.w.d.l0.g.c r1) {
        return S(r1);
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.s
    public boolean isAbstract() {
        return v.a.b(this);
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.s
    public boolean isFinal() {
        return v.a.c(this);
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.g
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.e.a.n0.g j() {
        return Z();
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.g
    public Collection<kotlin.s0.w.d.l0.e.a.n0.w> k() {
        Object[] r5 = kotlin.s0.w.d.l0.c.s1.b.b.f19104a.d(this.f19136a);
        int r0 = 0;
        if (r5 != null) goto L5;
        r5 = new Object[0];
    L5:
        ArrayList r1 = new ArrayList(r5.length);
        int r2 = r5.length;
    L6:
        if (r0 >= r2) goto L8;
        r1.add(new y(r5[r0]));
        r0 = r0 + 1;
        goto L6
    L8:
        return r1;
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.d
    public boolean l() {
        return kotlin.s0.w.d.l0.c.s1.b.h.a.c(this);
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.g
    public /* bridge */ /* synthetic */ Collection m() {
        return U();
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.g
    public boolean q() {
        return this.f19136a.isAnnotation();
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.g
    public boolean s() {
        Boolean r1 = kotlin.s0.w.d.l0.c.s1.b.b.f19104a.e(this.f19136a);
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.booleanValue();
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.g
    public boolean t() {
        return false;
    }

    public String toString() {
        return l.class.getName() + ": " + this.f19136a;
    }

    @Override // kotlin.s0.w.d.l0.c.s1.b.h
    public /* bridge */ /* synthetic */ AnnotatedElement v() {
        return V();
    }
}
