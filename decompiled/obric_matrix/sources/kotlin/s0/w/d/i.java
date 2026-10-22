package kotlin.s0.w.d;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.i0.m0;
import kotlin.s0.w.d.l0.c.u0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\n\b \u0018\u0000 <2\u00020\u0001:\u0003<=>B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\f\u001a\u00020\r2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0014\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u0011J\u0014\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u0011J \u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0013J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0011J\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0011J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00042\u0006\u0010\u0019\u001a\u00020\"H&J\u0012\u0010#\u001a\u0004\u0018\u00010 2\u0006\u0010$\u001a\u00020%H&J\"\u0010&\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030'0\u00042\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0004J\u0016\u0010,\u001a\b\u0012\u0004\u0012\u00020 0\u00042\u0006\u0010\u0019\u001a\u00020\"H&J\u001a\u0010-\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0.2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0014\u0010/\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J$\u00100\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020%H\u0002JE\u00103\u001a\u0004\u0018\u00010\u0018*\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0019\u001a\u00020\u00112\u0010\u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t052\n\u00106\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u00107\u001a\u00020\u0013H\u0002¢\u0006\u0002\u00108J(\u00109\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0015*\u0006\u0012\u0002\b\u00030\t2\u0010\u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0.H\u0002J=\u0010:\u001a\u0004\u0018\u00010\u0018*\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0019\u001a\u00020\u00112\u0010\u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t052\n\u00106\u001a\u0006\u0012\u0002\b\u00030\tH\u0002¢\u0006\u0002\u0010;R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006?"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "()V", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "methodOwner", "Ljava/lang/Class;", "getMethodOwner", "()Ljava/lang/Class;", "addParametersAndMasks", "", "result", "", "desc", "", "isConstructor", "", "findConstructorBySignature", "Ljava/lang/reflect/Constructor;", "findDefaultConstructor", "findDefaultMethod", "Ljava/lang/reflect/Method;", "name", "isMember", "findFunctionDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "signature", "findMethodBySignature", "findPropertyDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "index", "", "getMembers", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "scope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "belonginess", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "getProperties", "loadParameterTypes", "", "loadReturnType", "parseType", "begin", "end", "lookupMethod", "parameterTypes", "", "returnType", "isStaticDefault", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;Z)Ljava/lang/reflect/Method;", "tryGetConstructor", "tryGetMethod", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/reflect/Method;", "Companion", "Data", "MemberBelonginess", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class i implements kotlin.n0.d.d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f18591f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Class<?> f18592g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final kotlin.u0.i f18593h = null;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Companion;", "", "()V", "DEFAULT_CONSTRUCTOR_MARKER", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "LOCAL_PROPERTY_SIGNATURE", "Lkotlin/text/Regex;", "getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection", "()Lkotlin/text/Regex;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final kotlin.u0.i a() {
            return i.f();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b¦\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "moduleData", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "getModuleData", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;", "moduleData$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public abstract class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final /* synthetic */ kotlin.s0.l<Object>[] f18594c = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c0.a f18595a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f18596b;

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class a extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.s0.w.d.l0.c.s1.a.k> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ i f18597f;

            a(i r1) {
                this.f18597f = r1;
                super(0);
            }

            public final kotlin.s0.w.d.l0.c.s1.a.k a() {
                return b0.a(this.f18597f.e());
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.s1.a.k invoke() {
                return a();
            }
        }

        static {
            f18594c = new kotlin.s0.l[]{kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(b.class), "moduleData", "getModuleData()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;"))};
        }

        public b(i r2) {
            this.f18596b = r2;
            this.f18595a = c0.d(new a(r2));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final kotlin.s0.w.d.l0.c.s1.a.k a() {
            T r3 = this.f18595a.b(this, f18594c[0]);
            kotlin.n0.d.o.e(r3, "<get-moduleData>(...)");
            return (kotlin.s0.w.d.l0.c.s1.a.k) r3;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0084\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "", "(Ljava/lang/String;I)V", "accept", "", "member", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "DECLARED", "INHERITED", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    protected static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f18598f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final c f18599g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final /* synthetic */ c[] f18600h = null;

        static {
            f18598f = new c("DECLARED", 0);
            f18599g = new c("INHERITED", 1);
            f18600h = a();
        }

        private c(String r1, int r2) {
            super(r1, r2);
        }

        private static final /* synthetic */ c[] a() {
            return new c[]{f18598f, f18599g};
        }

        public static c valueOf(String r1) {
            return (c) Enum.valueOf(c.class, r1);
        }

        public static c[] values() {
            return (c[]) f18600h.clone();
        }

        public final boolean b(kotlin.s0.w.d.l0.c.b r4) {
            kotlin.n0.d.o.f(r4, "member");
            boolean r5 = r4.i().a();
            if (this != f18598f) goto L5;
            boolean r3 = true;
        L6:
            if (r5 != r3) goto L9;
            return true;
        L9:
            return false;
        L5:
            r3 = false;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class d extends kotlin.n0.d.q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.c.y, CharSequence> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final d f18601f = null;

        static {
            f18601f = new d();
        }

        d() {
            super(1);
        }

        public final CharSequence a(kotlin.s0.w.d.l0.c.y r2) {
            kotlin.n0.d.o.f(r2, "descriptor");
            return kotlin.s0.w.d.l0.j.c.f20439c.q(r2) + " | " + f0.f18547a.g(r2).a();
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ CharSequence invoke(kotlin.s0.w.d.l0.c.y r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class e extends kotlin.n0.d.q implements kotlin.n0.c.l<u0, CharSequence> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final e f18602f = null;

        static {
            f18602f = new e();
        }

        e() {
            super(1);
        }

        public final CharSequence a(u0 r2) {
            kotlin.n0.d.o.f(r2, "descriptor");
            return kotlin.s0.w.d.l0.j.c.f20439c.q(r2) + " | " + f0.f18547a.f(r2).a();
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ CharSequence invoke(u0 r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "first", "Lkotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibility;", "kotlin.jvm.PlatformType", "second", "compare"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class f<T> implements Comparator {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final f<T> f18603f = null;

        static {
            f18603f = new f();
        }

        f() {
        }

        public final int a(kotlin.s0.w.d.l0.c.u r1, kotlin.s0.w.d.l0.c.u r2) {
            Integer r0 = kotlin.s0.w.d.l0.c.t.d(r1, r2);
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.intValue();
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r1, Object r2) {
            return a((kotlin.s0.w.d.l0.c.u) r1, (kotlin.s0.w.d.l0.c.u) r2);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"kotlin/reflect/jvm/internal/KDeclarationContainerImpl$getMembers$visitor$1", "Lkotlin/reflect/jvm/internal/CreateKCallableVisitor;", "visitConstructorDescriptor", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "data", "", "(Lorg/jetbrains/kotlin/descriptors/ConstructorDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class g extends kotlin.s0.w.d.a {
        g(i r1) {
            super(r1);
        }

        @Override // kotlin.s0.w.d.l0.c.q1.l, kotlin.s0.w.d.l0.c.o
        public /* bridge */ /* synthetic */ Object h(kotlin.s0.w.d.l0.c.l r1, Object r2) {
            r(r1, (kotlin.f0) r2);
            throw null;
        }

        public kotlin.s0.w.d.f<?> r(kotlin.s0.w.d.l0.c.l r2, kotlin.f0 r3) {
            kotlin.n0.d.o.f(r2, "descriptor");
            kotlin.n0.d.o.f(r3, "data");
            throw new IllegalStateException("No constructors should appear here: " + r2);
        }
    }

    static {
        f18591f = new a(null);
        f18592g = Class.forName("kotlin.n0.d.g");
        f18593h = new kotlin.u0.i("<v#(\\d+)>");
    }

    public i() {
    }

    private final Class<?> A(String r7) {
        return C(r7, kotlin.u0.k.P(r7, ')', 0, false, 6, null) + 1, r7.length());
    }

    private final Method B(Class<?> r11, String r12, Class<?>[] r13, Class<?> r14, boolean r15) {
        if (r15 == false) goto L5;
        r13[0] = r11;
    L5:
        Method r1 = E(r11, r12, r13, r14);
        if (r1 == null) goto L8;
        return r1;
    L8:
        Class<? super Object> r3 = r11.getSuperclass();
        if (r3 == null) goto L13;
        Method r2 = B(r3, r12, r13, r14, r15);
        if (r2 == null) goto L13;
        return r2;
    L13:
        Class<?>[] r16 = r11.getInterfaces();
        kotlin.n0.d.o.e(r16, "interfaces");
        int r4 = r16.length;
        int r5 = 0;
    L14:
        if (r5 >= r4) goto L25;
        Class<?> r9 = r16[r5];
        kotlin.n0.d.o.e(r9, "superInterface");
        Method r6 = B(r9, r12, r13, r14, r15);
        if (r6 != null) goto L17;
        if (r15 == false) goto L24;
        Class<?> r7 = kotlin.s0.w.d.l0.c.s1.a.e.a(kotlin.s0.w.d.l0.c.s1.b.d.e(r9), r9.getName() + "$DefaultImpls");
        if (r7 == null) goto L24;
        r13[0] = r9;
        Method r8 = E(r7, r12, r13, r14);
        if (r8 == null) goto L24;
        return r8;
    L24:
        r5 = r5 + 1;
        goto L14
    L17:
        return r6;
    L25:
        return null;
    }

    private final Class<?> C(String r7, int r8, int r9) {
        char r0 = r7.charAt(r8);
        if (r0 != 'L') goto L7;
        ClassLoader r6 = kotlin.s0.w.d.l0.c.s1.b.d.e(e());
        String r1 = r7.substring(r8 + 1, r9 - 1);
        kotlin.n0.d.o.e(r1, "this as java.lang.String…ing(startIndex, endIndex)");
        Class<?> r10 = r6.loadClass(kotlin.u0.k.v(r1, '/', '.', false, 4, null));
        String r11 = "jClass.safeClassLoader.l…d - 1).replace('/', '.'))";
    L5:
        kotlin.n0.d.o.e(r10, r11);
        return r10;
    L7:
        if (r0 != '[') goto L10;
        return i0.e(C(r7, r8 + 1, r9));
    L10:
        if (r0 != 'V') goto L13;
        r10 = Void.TYPE;
        r11 = "TYPE";
        goto L5
    L13:
        if (r0 != 'Z') goto L16;
        return Boolean.TYPE;
    L16:
        if (r0 != 'C') goto L19;
        return Character.TYPE;
    L19:
        if (r0 != 'B') goto L22;
        return Byte.TYPE;
    L22:
        if (r0 != 'S') goto L25;
        return Short.TYPE;
    L25:
        if (r0 != 'I') goto L28;
        return Integer.TYPE;
    L28:
        if (r0 != 'F') goto L31;
        return Float.TYPE;
    L31:
        if (r0 != 'J') goto L34;
        return Long.TYPE;
    L34:
        if (r0 != 'D') goto L38;
        return Double.TYPE;
    L38:
        throw new a0("Unknown type prefix in the method signature: " + r7);
    }

    private final Constructor<?> D(Class<?> r1, List<? extends Class<?>> r2) {
        Object[] r0 = r2.toArray(new Class[0]);     // Catch: NoSuchMethodException -> L5
        kotlin.n0.d.o.d(r0, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");     // Catch: NoSuchMethodException -> L5
        Class[] r3 = (Class[]) r0;     // Catch: NoSuchMethodException -> L5
        return r1.getDeclaredConstructor((Class[]) Arrays.copyOf(r3, r3.length));
    L5:
        return null;
    }

    private final Method E(Class<?> r6, String r7, Class<?>[] r8, Class<?> r9) {
        Method r0 = r6.getDeclaredMethod(r7, (Class[]) Arrays.copyOf(r8, r8.length));     // Catch: NoSuchMethodException -> L20
        if (kotlin.n0.d.o.a(r0.getReturnType(), r9) == true) goto L19;
        Method[] r10 = r6.getDeclaredMethods();     // Catch: NoSuchMethodException -> L20
        kotlin.n0.d.o.e(r10, "declaredMethods");     // Catch: NoSuchMethodException -> L20
        int r1 = r10.length;     // Catch: NoSuchMethodException -> L20
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L27;
        Method r3 = r10[r2];     // Catch: NoSuchMethodException -> L20
        if (kotlin.n0.d.o.a(r3.getName(), r7) == true) goto L11;
    L15:
        boolean r4 = false;
    L16:
        if (r4 == true) goto L25;
        r2 = r2 + 1;
        goto L7
    L25:
        return r3;
    L11:
        if (kotlin.n0.d.o.a(r3.getReturnType(), r9) == false) goto L15;
        if (Arrays.equals(r3.getParameterTypes(), r8) == false) goto L15;
        r4 = true;
        goto L16
    L27:
        return null;
    L19:
        return r0;
    L26:
        return null;
    }

    public static final /* synthetic */ kotlin.u0.i f() {
        return f18593h;
    }

    private final void k(List<Class<?>> r3, String r4, boolean r5) {
        List<Class<?>> r2 = z(r4);
        r3.addAll(r2);
        int r6 = ((r2.size() + 32) - 1) / 32;
        int r7 = 0;
    L3:
        if (r7 >= r6) goto L5;
        Class<?> r0 = Integer.TYPE;
        kotlin.n0.d.o.e(r0, "TYPE");
        r3.add(r0);
        r7 = r7 + 1;
        goto L3
    L5:
        if (r5 == false) goto L7;
        Class<?> r8 = f18592g;
        r3.remove(r8);
        kotlin.n0.d.o.e(r8, "DEFAULT_CONSTRUCTOR_MARKER");
    L8:
        r3.add(r8);
        return;
    L7:
        r8 = Object.class;
        goto L8
    }

    private final List<Class<?>> z(String r10) {
        ArrayList r0 = new ArrayList();
        int r8 = 1;
    L4:
        if (r10.charAt(r8) == ')') goto L18;
        int r2 = r8;
    L7:
        if (r10.charAt(r2) != '[') goto L9;
        r2 = r2 + 1;
        goto L7
    L9:
        char r3 = r10.charAt(r2);
        if (kotlin.u0.k.E("VZCBSIFJD", r3, false, 2, null) == false) goto L13;
        int r4 = r2 + 1;
    L15:
        r0.add(C(r10, r8, r4));
        r8 = r4;
        goto L4
    L13:
        if (r3 != 'L') goto L17;
        r4 = kotlin.u0.k.P(r10, ';', r8, false, 4, null) + 1;
        goto L15
    L17:
        throw new a0("Unknown type prefix in the method signature: " + r10);
    L18:
        return r0;
    }

    public final Constructor<?> m(String r2) {
        kotlin.n0.d.o.f(r2, "desc");
        return D(e(), z(r2));
    }

    public final Constructor<?> o(String r4) {
        kotlin.n0.d.o.f(r4, "desc");
        Class<?> r0 = e();
        ArrayList r1 = new ArrayList();
        k(r1, r4, true);
        kotlin.f0 r5 = kotlin.f0.f18324a;
        return D(r0, r1);
    }

    public final Method p(String r9, String r10, boolean r11) {
        kotlin.n0.d.o.f(r9, "name");
        kotlin.n0.d.o.f(r10, "desc");
        if (kotlin.n0.d.o.a(r9, "<init>") == false) goto L6;
        return null;
    L6:
        ArrayList r0 = new ArrayList();
        if (r11 == false) goto L9;
        r0.add(e());
    L9:
        k(r0, r10, false);
        Class<?> r3 = x();
        String r4 = r9 + "$default";
        Object[] r12 = r0.toArray(new Class[0]);
        kotlin.n0.d.o.d(r12, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return B(r3, r4, (Class[]) r12, A(r10), r11);
    }

    public final kotlin.s0.w.d.l0.c.y q(String r12, String r13) {
        kotlin.n0.d.o.f(r12, "name");
        kotlin.n0.d.o.f(r13, "signature");
        if (kotlin.n0.d.o.a(r12, "<init>") == false) goto L5;
        Collection<kotlin.s0.w.d.l0.c.y> r0 = kotlin.i0.r.z0(t());
    L6:
        Collection<kotlin.s0.w.d.l0.c.y> r1 = r0;
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L8:
        if (r3.hasNext() == false) goto L12;
        Object r4 = r3.next();
        if (kotlin.n0.d.o.a(f0.f18547a.g((kotlin.s0.w.d.l0.c.y) r4).a(), r13) == false) goto L8;
        r2.add(r4);
        goto L8
    L12:
        boolean r10 = true;
        if (r2.size() == 1) goto L24;
        String r5 = kotlin.i0.r.Z(r1, "\n", null, null, 0, null, d.f18601f, 30, null);
        StringBuilder r6 = new StringBuilder();
        r6.append("Function '");
        r6.append(r12);
        r6.append("' (JVM signature: ");
        r6.append(r13);
        r6.append(") not resolved in ");
        r6.append(this);
        r6.append(':');
        if (r5.length() == 0) goto L18;
        r10 = false;
    L18:
        if (r10 == false) goto L20;
        String r11 = " no members found";
    L21:
        r6.append(r11);
        throw new a0(r6.toString());
    L20:
        r11 = '\n' + r5;
        goto L21
    L24:
        return (kotlin.s0.w.d.l0.c.y) kotlin.i0.r.o0(r2);
    L5:
        kotlin.s0.w.d.l0.g.f r7 = kotlin.s0.w.d.l0.g.f.k(r12);
        kotlin.n0.d.o.e(r7, "identifier(name)");
        r0 = u(r7);
        goto L6
    }

    public final Method r(String r10, String r11) {
        kotlin.n0.d.o.f(r10, "name");
        kotlin.n0.d.o.f(r11, "desc");
        if (kotlin.n0.d.o.a(r10, "<init>") == false) goto L5;
        return null;
    L5:
        Object[] r0 = z(r11).toArray(new Class[0]);
        kotlin.n0.d.o.d(r0, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        Class<?>[] r1 = (Class[]) r0;
        Class<?> r12 = A(r11);
        Method r2 = B(x(), r10, r1, r12, false);
        if (r2 == null) goto L9;
        return r2;
    L9:
        if (x().isInterface() == false) goto L13;
        Method r9 = B(Object.class, r10, r1, r12, false);
        if (r9 == null) goto L13;
        return r9;
    L13:
        return null;
    }

    public final u0 s(String r20, String r21) {
        kotlin.n0.d.o.f(r20, "name");
        kotlin.n0.d.o.f(r21, "signature");
        kotlin.u0.g r3 = f18593h.c(r21);
        boolean r4 = true;
        if (r3 == null) goto L9;
        String r1 = r3.a().a().b().get(1);
        u0 r2 = v(Integer.parseInt(r1));
        if (r2 == null) goto L8;
        return r2;
    L8:
        throw new a0("Local property #" + r1 + " not found in " + e());
    L9:
        kotlin.s0.w.d.l0.g.f r5 = kotlin.s0.w.d.l0.g.f.k(r20);
        kotlin.n0.d.o.e(r5, "identifier(name)");
        Collection<u0> r6 = y(r5);
        ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r6.iterator();
    L11:
        if (r8.hasNext() == false) goto L16;
        Object r9 = r8.next();
        if (kotlin.n0.d.o.a(f0.f18547a.f((u0) r9).a(), r21) == false) goto L11;
        r7.add(r9);
        goto L11
    L16:
        if (r7.isEmpty() == true) goto L42;
        if (r7.size() == 1) goto L40;
        LinkedHashMap r10 = new LinkedHashMap();
        Iterator r11 = r7.iterator();
    L21:
        if (r11.hasNext() == false) goto L26;
        Object r12 = r11.next();
        kotlin.s0.w.d.l0.c.u r13 = ((u0) r12).getVisibility();
        Object r14 = r10.get(r13);
        if (r14 != null) goto L25;
        r14 = new ArrayList();
        r10.put(r13, r14);
    L25:
        ((List) r14).add(r12);
        goto L21
    L26:
        Collection r15 = m0.g(r10, f.f18603f).values();
        kotlin.n0.d.o.e(r15, "properties\n             …\n                }.values");
        List r16 = (List) kotlin.i0.r.a0(r15);
        if (r16.size() != 1) goto L31;
        kotlin.n0.d.o.e(r16, "mostVisibleProperties");
        Object r0 = kotlin.i0.r.P(r16);
    L30:
        return (u0) r0;
    L31:
        kotlin.s0.w.d.l0.g.f r17 = kotlin.s0.w.d.l0.g.f.k(r20);
        kotlin.n0.d.o.e(r17, "identifier(name)");
        String r18 = kotlin.i0.r.Z(y(r17), "\n", null, null, 0, null, e.f18602f, 30, null);
        StringBuilder r19 = new StringBuilder();
        r19.append("Property '");
        r19.append(r20);
        r19.append("' (JVM signature: ");
        r19.append(r21);
        r19.append(") not resolved in ");
        r19.append(this);
        r19.append(':');
        if (r18.length() == 0) goto L35;
        r4 = false;
    L35:
        if (r4 == false) goto L37;
        String r22 = " no members found";
    L38:
        r19.append(r22);
        throw new a0(r19.toString());
    L37:
        r22 = '\n' + r18;
        goto L38
    L40:
        r0 = kotlin.i0.r.o0(r7);
        goto L30
    L42:
        throw new a0("Property '" + r20 + "' (JVM signature: " + r21 + ") not resolved in " + this);
    }

    public abstract Collection<kotlin.s0.w.d.l0.c.l> t();

    public abstract Collection<kotlin.s0.w.d.l0.c.y> u(kotlin.s0.w.d.l0.g.f r1);

    public abstract u0 v(int r1);

    protected final Collection<kotlin.s0.w.d.f<?>> w(kotlin.s0.w.d.l0.k.w.h r7, c r8) {
        kotlin.n0.d.o.f(r7, "scope");
        kotlin.n0.d.o.f(r8, "belonginess");
        g r0 = new g(this);
        Collection r9 = kotlin.s0.w.d.l0.k.w.k.a.a(r7, null, null, 3, null);
        ArrayList r1 = new ArrayList();
        Iterator r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L16;
        kotlin.s0.w.d.l0.c.m r2 = (kotlin.s0.w.d.l0.c.m) r10.next();
        if ((r2 instanceof kotlin.s0.w.d.l0.c.b) == false) goto L12;
        kotlin.s0.w.d.l0.c.b r3 = (kotlin.s0.w.d.l0.c.b) r2;
        if (kotlin.n0.d.o.a(r3.getVisibility(), kotlin.s0.w.d.l0.c.t.f19166h) == true) goto L12;
        if (r8.b(r3) == false) goto L12;
        kotlin.s0.w.d.f r4 = (kotlin.s0.w.d.f) r2.K(r0, kotlin.f0.f18324a);
    L13:
        if (r4 == null) goto L4;
        r1.add(r4);
    L12:
        r4 = null;
        goto L13
    L16:
        return kotlin.i0.r.z0(r1);
    }

    protected Class<?> x() {
        Class<?> r0 = kotlin.s0.w.d.l0.c.s1.b.d.f(e());
        if (r0 == null) goto L5;
        return r0;
    L5:
        return e();
    }

    public abstract Collection<u0> y(kotlin.s0.w.d.l0.g.f r1);
}
