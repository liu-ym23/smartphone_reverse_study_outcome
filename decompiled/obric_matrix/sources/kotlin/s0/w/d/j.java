package kotlin.s0.w.d;

import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00032\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00042\u00020\u0005B)\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\fB\u0017\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fB5\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0012J.\u00102\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u000304032\n\u00105\u001a\u0006\u0012\u0002\b\u0003042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u00106\u001a\u00020)H\u0002J\u0010\u00107\u001a\u0002082\u0006\u00105\u001a\u000209H\u0002J\u0010\u0010:\u001a\u0002082\u0006\u00105\u001a\u000209H\u0002J\u0010\u0010;\u001a\u0002082\u0006\u00105\u001a\u000209H\u0002J\u0013\u0010<\u001a\u00020)2\b\u0010=\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010>\u001a\u00020\u0014H\u0016J\b\u0010?\u001a\u00020\tH\u0016R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R!\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b\"\u0010\u001cR\u001b\u0010\r\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010*R\u0014\u0010+\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010*R\u0014\u0010,\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010*R\u0014\u0010-\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010*R\u0014\u0010.\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010*R\u0014\u0010/\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010*R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lkotlin/reflect/jvm/internal/KFunctionImpl;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "Lkotlin/reflect/KFunction;", "Lkotlin/jvm/internal/FunctionBase;", "Lkotlin/reflect/jvm/internal/FunctionWithAllInvokes;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;)V", "descriptorInitialValue", "rawBoundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Ljava/lang/Object;)V", "arity", "", "getArity", "()I", "getBoundReceiver", "()Ljava/lang/Object;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "defaultCaller$delegate", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "isBound", "", "()Z", "isExternal", "isInfix", "isInline", "isOperator", "isSuspend", "getName", "()Ljava/lang/String;", "createConstructorCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "member", "isDefault", "createInstanceMethodCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "Ljava/lang/reflect/Method;", "createJvmStaticInObjectCaller", "createStaticMethodCaller", "equals", "other", "hashCode", "toString", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class j extends f<Object> implements kotlin.n0.d.k<Object>, kotlin.s0.g<Object>, kotlin.s0.w.d.c {
    static final /* synthetic */ kotlin.s0.l<Object>[] p = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final i f18606j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f18607k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Object f18608l;
    private final c0.a m;
    private final c0.b n;
    private final c0.b o;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0012\u0012\u0002\b\u0003 \u0002*\b\u0012\u0002\b\u0003\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.s0.w.d.k0.d<? extends Member>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ j f18609f;

        a(j r1) {
            this.f18609f = r1;
            super(0);
        }

        public final kotlin.s0.w.d.k0.d<Member> a() {
            d r0 = f0.f18547a.g(this.f18609f.H());
            if ((r0 instanceof d.C0482d) == false) goto L14;
            if (this.f18609f.v() == false) goto L12;
            Class<?> r4 = this.f18609f.s().e();
            List<kotlin.s0.i> r11 = this.f18609f.getParameters();
            ArrayList r5 = new ArrayList(kotlin.i0.r.q(r11, 10));
            Iterator<T> r12 = r11.iterator();
        L8:
            if (r12.hasNext() == false) goto L11;
            String r1 = ((kotlin.s0.i) r12.next()).getName();
            kotlin.n0.d.o.c(r1);
            r5.add(r1);
            goto L8
        L11:
            return new kotlin.s0.w.d.k0.a(r4, r5, kotlin.s0.w.d.k0.a.EnumC0487a.f18624g, kotlin.s0.w.d.k0.a.b.f18627g, null, 16, null);
        L12:
            Object r2 = this.f18609f.s().m(((d.C0482d) r0).b());
        L23:
            if ((r2 instanceof Constructor) == false) goto L26;
            j r3 = this.f18609f;
            kotlin.s0.w.d.k0.d r6 = j.x(r3, (Constructor) r2, r3.H(), false);
        L35:
            return kotlin.s0.w.d.k0.h.c(r6, this.f18609f.H(), false, 2, null);
        L26:
            if ((r2 instanceof Method) == false) goto L37;
            Method r7 = (Method) r2;
            if (Modifier.isStatic(r7.getModifiers()) == true) goto L31;
            r6 = j.y(this.f18609f, r7);
            goto L35
        L31:
            if (this.f18609f.H().getAnnotations().i(i0.i()) == null) goto L33;
            r6 = j.z(this.f18609f, r7);
            goto L35
        L33:
            r6 = j.A(this.f18609f, r7);
            goto L35
        L37:
            throw new a0("Could not compute caller for function: " + this.f18609f.H() + " (member = " + r2 + ')');
        L14:
            if ((r0 instanceof d.e) == false) goto L17;
            d.e r8 = (d.e) r0;
            r2 = this.f18609f.s().r(r8.c(), r8.b());
            goto L23
        L17:
            if ((r0 instanceof d.c) == false) goto L20;
            r2 = ((d.c) r0).b();
            goto L23
        L20:
            if ((r0 instanceof d.b) == false) goto L39;
            r2 = ((d.b) r0).b();
            goto L23
        L39:
            if ((r0 instanceof d.a) == false) goto L47;
            List<Method> r9 = ((d.a) r0).b();
            Class<?> r10 = this.f18609f.s().e();
            ArrayList r13 = new ArrayList(kotlin.i0.r.q(r9, 10));
            Iterator<T> r14 = r9.iterator();
        L42:
            if (r14.hasNext() == false) goto L45;
            r13.add(((Method) r14.next()).getName());
            goto L42
        L45:
            return new kotlin.s0.w.d.k0.a(r10, r13, kotlin.s0.w.d.k0.a.EnumC0487a.f18624g, kotlin.s0.w.d.k0.a.b.f18626f, r9);
        L47:
            throw new kotlin.m();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.k0.d<? extends Member> invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.s0.w.d.k0.d<? extends Member>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ j f18610f;

        b(j r1) {
            this.f18610f = r1;
            super(0);
        }

        public final kotlin.s0.w.d.k0.d<Member> a() {
            d r0 = f0.f18547a.g(this.f18610f.H());
            if ((r0 instanceof d.e) == false) goto L6;
            i r1 = this.f18610f.s();
            d.e r2 = (d.e) r0;
            String r4 = r2.c();
            String r3 = r2.b();
            Member r5 = this.f18610f.r().b();
            kotlin.n0.d.o.c(r5);
            GenericDeclaration r6 = r1.p(r4, r3, !Modifier.isStatic(r5.getModifiers()));
        L26:
            if ((r6 instanceof Constructor) == false) goto L29;
            j r7 = this.f18610f;
            kotlin.s0.w.d.k0.d r8 = j.x(r7, (Constructor) r6, r7.H(), true);
        L37:
            if (r8 != null) goto L39;
            return null;
        L39:
            return kotlin.s0.w.d.k0.h.b(r8, this.f18610f.H(), true);
        L29:
            if ((r6 instanceof Method) == true) goto L31;
            r8 = null;
            goto L37
        L31:
            if (this.f18610f.H().getAnnotations().i(i0.i()) == null) goto L35;
            kotlin.s0.w.d.l0.c.m r9 = this.f18610f.H().c();
            kotlin.n0.d.o.d(r9, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            if (((kotlin.s0.w.d.l0.c.e) r9).x() == true) goto L35;
            r8 = j.z(this.f18610f, (Method) r6);
        L35:
            r8 = j.A(this.f18610f, (Method) r6);
            goto L37
        L6:
            if ((r0 instanceof d.C0482d) == false) goto L17;
            if (this.f18610f.v() == false) goto L15;
            Class<?> r10 = this.f18610f.s().e();
            List<kotlin.s0.i> r13 = this.f18610f.getParameters();
            ArrayList r11 = new ArrayList(kotlin.i0.r.q(r13, 10));
            Iterator<T> r14 = r13.iterator();
        L11:
            if (r14.hasNext() == false) goto L14;
            String r12 = ((kotlin.s0.i) r14.next()).getName();
            kotlin.n0.d.o.c(r12);
            r11.add(r12);
            goto L11
        L14:
            return new kotlin.s0.w.d.k0.a(r10, r11, kotlin.s0.w.d.k0.a.EnumC0487a.f18623f, kotlin.s0.w.d.k0.a.b.f18627g, null, 16, null);
        L15:
            r6 = this.f18610f.s().o(((d.C0482d) r0).b());
            goto L26
        L17:
            if ((r0 instanceof d.a) == false) goto L24;
            List<Method> r15 = ((d.a) r0).b();
            Class<?> r16 = this.f18610f.s().e();
            ArrayList r17 = new ArrayList(kotlin.i0.r.q(r15, 10));
            Iterator<T> r18 = r15.iterator();
        L20:
            if (r18.hasNext() == false) goto L23;
            r17.add(((Method) r18.next()).getName());
            goto L20
        L23:
            return new kotlin.s0.w.d.k0.a(r16, r17, kotlin.s0.w.d.k0.a.EnumC0487a.f18623f, kotlin.s0.w.d.k0.a.b.f18626f, r15);
        L24:
            r6 = null;
            goto L26
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.k0.d<? extends Member> invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class c extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.s0.w.d.l0.c.y> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ j f18611f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f18612g;

        c(j r1, String r2) {
            this.f18611f = r1;
            this.f18612g = r2;
            super(0);
        }

        public final kotlin.s0.w.d.l0.c.y a() {
            return this.f18611f.s().q(this.f18612g, j.B(this.f18611f));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.y invoke() {
            return a();
        }
    }

    static {
        p = new kotlin.s0.l[]{kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(j.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;")), kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(j.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;")), kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(j.class), "defaultCaller", "getDefaultCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
    }

    public j(i r8, String r9, String r10, Object r11) {
        kotlin.n0.d.o.f(r8, "container");
        kotlin.n0.d.o.f(r9, "name");
        kotlin.n0.d.o.f(r10, "signature");
        this(r8, r9, r10, null, r11);
    }

    private j(i r1, String r2, String r3, kotlin.s0.w.d.l0.c.y r4, Object r5) {
        this.f18606j = r1;
        this.f18607k = r3;
        this.f18608l = r5;
        this.m = c0.c(r4, new c(this, r2));
        this.n = c0.b(new a(this));
        this.o = c0.b(new b(this));
    }

    /* synthetic */ j(i r7, String r8, String r9, kotlin.s0.w.d.l0.c.y r10, Object r11, int r12, kotlin.n0.d.g r13) {
        if ((r12 & 16) == 0) goto L5;
        r11 = kotlin.n0.d.c.NO_RECEIVER;
    L5:
        this(r7, r8, r9, r10, r11);
    }

    public j(i r10, kotlin.s0.w.d.l0.c.y r11) {
        kotlin.n0.d.o.f(r10, "container");
        kotlin.n0.d.o.f(r11, "descriptor");
        String r3 = r11.getName().b();
        kotlin.n0.d.o.e(r3, "descriptor.name.asString()");
        this(r10, r3, f0.f18547a.g(r11).a(), r11, null, 16, null);
    }

    public static final /* synthetic */ kotlin.s0.w.d.k0.e.h A(j r0, Method r1) {
        return r0.F(r1);
    }

    public static final /* synthetic */ String B(j r0) {
        return r0.f18607k;
    }

    private final kotlin.s0.w.d.k0.e<Constructor<?>> C(Constructor<?> r1, kotlin.s0.w.d.l0.c.y r2, boolean r3) {
        if (r3 == true) goto L10;
        if (kotlin.s0.w.d.l0.k.u.b.f(r2) == false) goto L10;
        if (w() == false) goto L15;
        return new kotlin.s0.w.d.k0.e.a(r1, G());
    L15:
        return new kotlin.s0.w.d.k0.e.b(r1);
    L10:
        if (w() == false) goto L13;
        return new kotlin.s0.w.d.k0.e.c(r1, G());
    L13:
        return new kotlin.s0.w.d.k0.e.C0489e(r1);
    }

    private final kotlin.s0.w.d.k0.e.h D(Method r2) {
        if (w() == false) goto L6;
        return new kotlin.s0.w.d.k0.e.h.a(r2, G());
    L6:
        return new kotlin.s0.w.d.k0.e.h.d(r2);
    }

    private final kotlin.s0.w.d.k0.e.h E(Method r1) {
        if (w() == false) goto L6;
        return new kotlin.s0.w.d.k0.e.h.b(r1);
    L6:
        return new kotlin.s0.w.d.k0.e.h.C0492e(r1);
    }

    private final kotlin.s0.w.d.k0.e.h F(Method r2) {
        if (w() == false) goto L6;
        return new kotlin.s0.w.d.k0.e.h.c(r2, G());
    L6:
        return new kotlin.s0.w.d.k0.e.h.f(r2);
    }

    private final Object G() {
        return kotlin.s0.w.d.k0.h.a(this.f18608l, H());
    }

    public static final /* synthetic */ kotlin.s0.w.d.k0.e x(j r0, Constructor r1, kotlin.s0.w.d.l0.c.y r2, boolean r3) {
        return r0.C(r1, r2, r3);
    }

    public static final /* synthetic */ kotlin.s0.w.d.k0.e.h y(j r0, Method r1) {
        return r0.D(r1);
    }

    public static final /* synthetic */ kotlin.s0.w.d.k0.e.h z(j r0, Method r1) {
        return r0.E(r1);
    }

    public kotlin.s0.w.d.l0.c.y H() {
        T r3 = this.m.b(this, p[0]);
        kotlin.n0.d.o.e(r3, "<get-descriptor>(...)");
        return (kotlin.s0.w.d.l0.c.y) r3;
    }

    public boolean equals(Object r4) {
        j r5 = i0.b(r4);
        if (r5 != null) goto L6;
        return false;
    L6:
        if (kotlin.n0.d.o.a(s(), r5.s()) == true) goto L8;
        return false;
    L8:
        if (kotlin.n0.d.o.a(getName(), r5.getName()) == true) goto L10;
        return false;
    L10:
        if (kotlin.n0.d.o.a(this.f18607k, r5.f18607k) == true) goto L12;
        return false;
    L12:
        if (kotlin.n0.d.o.a(this.f18608l, r5.f18608l) == false) goto L18;
        return true;
    L18:
        return false;
    }

    @Override // kotlin.n0.c.q
    public Object f(Object r1, Object r2, Object r3) {
        return kotlin.s0.w.d.c.a.d(this, r1, r2, r3);
    }

    @Override // kotlin.n0.d.k
    public int getArity() {
        return kotlin.s0.w.d.k0.f.a(r());
    }

    @Override // kotlin.s0.c
    public String getName() {
        String r1 = H().getName().b();
        kotlin.n0.d.o.e(r1, "descriptor.name.asString()");
        return r1;
    }

    public int hashCode() {
        return (((s().hashCode() * 31) + getName().hashCode()) * 31) + this.f18607k.hashCode();
    }

    @Override // kotlin.n0.c.a
    public Object invoke() {
        return kotlin.s0.w.d.c.a.a(this);
    }

    @Override // kotlin.n0.c.l
    public Object invoke(Object r1) {
        return kotlin.s0.w.d.c.a.b(this, r1);
    }

    @Override // kotlin.n0.c.p
    public Object invoke(Object r1, Object r2) {
        return kotlin.s0.w.d.c.a.c(this, r1, r2);
    }

    @Override // kotlin.n0.c.r
    public Object invoke(Object r1, Object r2, Object r3, Object r4) {
        return kotlin.s0.w.d.c.a.e(this, r1, r2, r3, r4);
    }

    @Override // kotlin.s0.g
    public boolean isExternal() {
        return H().isExternal();
    }

    @Override // kotlin.s0.g
    public boolean isInfix() {
        return H().isInfix();
    }

    @Override // kotlin.s0.g
    public boolean isInline() {
        return H().isInline();
    }

    @Override // kotlin.s0.g
    public boolean isOperator() {
        return H().isOperator();
    }

    @Override // kotlin.s0.c
    public boolean isSuspend() {
        return H().isSuspend();
    }

    @Override // kotlin.s0.w.d.f
    public kotlin.s0.w.d.k0.d<?> r() {
        T r3 = this.n.b(this, p[1]);
        kotlin.n0.d.o.e(r3, "<get-caller>(...)");
        return (kotlin.s0.w.d.k0.d) r3;
    }

    @Override // kotlin.s0.w.d.f
    public i s() {
        return this.f18606j;
    }

    @Override // kotlin.s0.w.d.f
    public kotlin.s0.w.d.k0.d<?> t() {
        return (kotlin.s0.w.d.k0.d) this.o.b(this, p[2]);
    }

    public String toString() {
        return e0.f18529a.d(H());
    }

    @Override // kotlin.s0.w.d.f
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.b u() {
        return H();
    }

    @Override // kotlin.s0.w.d.f
    public boolean w() {
        return !kotlin.n0.d.o.a(this.f18608l, kotlin.n0.d.c.NO_RECEIVER);
    }
}
