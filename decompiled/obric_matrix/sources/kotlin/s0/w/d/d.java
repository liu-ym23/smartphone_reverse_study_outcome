package kotlin.s0.w.d;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0005\u0005\u0006\u0007\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u0082\u0001\u0005\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "", "()V", "asString", "", "FakeJavaAnnotationConstructor", "JavaConstructor", "JavaMethod", "KotlinConstructor", "KotlinFunction", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$FakeJavaAnnotationConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaMethod;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class d {

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\u0007\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$FakeJavaAnnotationConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "getJClass", "()Ljava/lang/Class;", "methods", "", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "getMethods", "()Ljava/util/List;", "asString", "", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class<?> f18508a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<Method> f18509b;

        /* JADX INFO: renamed from: kotlin.s0.w.d.d$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class C0481a extends kotlin.n0.d.q implements kotlin.n0.c.l<Method, CharSequence> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final C0481a f18510f = null;

            static {
                f18510f = new C0481a();
            }

            C0481a() {
                super(1);
            }

            public final CharSequence a(Method r1) {
                Class<?> r0 = r1.getReturnType();
                kotlin.n0.d.o.e(r0, "it.returnType");
                return kotlin.s0.w.d.l0.c.s1.b.d.b(r0);
            }

            @Override // kotlin.n0.c.l
            public /* bridge */ /* synthetic */ CharSequence invoke(Method r1) {
                return a(r1);
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class b<T> implements Comparator {
            public b() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T r1, T r2) {
                return kotlin.j0.a.a(((Method) r1).getName(), ((Method) r2).getName());
            }
        }

        public a(Class<?> r2) {
            kotlin.n0.d.o.f(r2, "jClass");
            super(null);
            this.f18508a = r2;
            Method[] r3 = r2.getDeclaredMethods();
            kotlin.n0.d.o.e(r3, "jClass.declaredMethods");
            this.f18509b = kotlin.i0.i.V(r3, new b());
        }

        @Override // kotlin.s0.w.d.d
        public String a() {
            return kotlin.i0.r.Z(this.f18509b, "", "<init>(", ")V", 0, null, C0481a.f18510f, 24, null);
        }

        public final List<Method> b() {
            return this.f18509b;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "constructor", "Ljava/lang/reflect/Constructor;", "(Ljava/lang/reflect/Constructor;)V", "getConstructor", "()Ljava/lang/reflect/Constructor;", "asString", "", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Constructor<?> f18511a;

        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class a extends kotlin.n0.d.q implements kotlin.n0.c.l<Class<?>, CharSequence> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final a f18512f = null;

            static {
                f18512f = new a();
            }

            a() {
                super(1);
            }

            public final CharSequence a(Class<?> r1) {
                kotlin.n0.d.o.e(r1, "it");
                return kotlin.s0.w.d.l0.c.s1.b.d.b(r1);
            }

            @Override // kotlin.n0.c.l
            public /* bridge */ /* synthetic */ CharSequence invoke(Class<?> r1) {
                return a(r1);
            }
        }

        public b(Constructor<?> r2) {
            kotlin.n0.d.o.f(r2, "constructor");
            super(null);
            this.f18511a = r2;
        }

        @Override // kotlin.s0.w.d.d
        public String a() {
            Class<?>[] r0 = this.f18511a.getParameterTypes();
            kotlin.n0.d.o.e(r0, "constructor.parameterTypes");
            return kotlin.i0.i.N(r0, "", "<init>(", ")V", 0, null, a.f18512f, 24, null);
        }

        public final Constructor<?> b() {
            return this.f18511a;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaMethod;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "getMethod", "()Ljava/lang/reflect/Method;", "asString", "", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f18513a;

        public c(Method r2) {
            kotlin.n0.d.o.f(r2, "method");
            super(null);
            this.f18513a = r2;
        }

        @Override // kotlin.s0.w.d.d
        public String a() {
            return g0.a(this.f18513a);
        }

        public final Method b() {
            return this.f18513a;
        }
    }

    /* JADX INFO: renamed from: kotlin.s0.w.d.d$d, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "signature", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMemberSignature$Method;", "(Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;)V", "_signature", "", "constructorDesc", "getConstructorDesc", "()Ljava/lang/String;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;", "asString", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C0482d extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.f.a0.b.d.b f18514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f18515b;

        public C0482d(kotlin.s0.w.d.l0.f.a0.b.d.b r2) {
            kotlin.n0.d.o.f(r2, "signature");
            super(null);
            this.f18514a = r2;
            this.f18515b = r2.a();
        }

        @Override // kotlin.s0.w.d.d
        public String a() {
            return this.f18515b;
        }

        public final String b() {
            return this.f18514a.b();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "signature", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMemberSignature$Method;", "(Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;)V", "_signature", "", "methodDesc", "getMethodDesc", "()Ljava/lang/String;", "methodName", "getMethodName", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;", "asString", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class e extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.f.a0.b.d.b f18516a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f18517b;

        public e(kotlin.s0.w.d.l0.f.a0.b.d.b r2) {
            kotlin.n0.d.o.f(r2, "signature");
            super(null);
            this.f18516a = r2;
            this.f18517b = r2.a();
        }

        @Override // kotlin.s0.w.d.d
        public String a() {
            return this.f18517b;
        }

        public final String b() {
            return this.f18516a.b();
        }

        public final String c() {
            return this.f18516a.c();
        }
    }

    private d() {
    }

    public /* synthetic */ d(kotlin.n0.d.g r1) {
        this();
    }

    public abstract String a();
}
