package kotlin.s0.w.d;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.s0.w.d.l0.c.t0;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.c.v0;
import kotlin.s0.w.d.l0.c.w0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\b \u0018\u0000 @*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0004?@ABB)\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eB3\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0011J\n\u00104\u001a\u0004\u0018\u000105H\u0004J\u0013\u00106\u001a\u00020)2\b\u00107\u001a\u0004\u0018\u00010\nH\u0096\u0002J(\u00108\u001a\u0004\u0018\u00010\n2\b\u00109\u001a\u0004\u0018\u0001052\b\u0010:\u001a\u0004\u0018\u00010\n2\b\u0010;\u001a\u0004\u0018\u00010\nH\u0004J\b\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020\u0007H\u0016R\u001c\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\r0\r0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\t\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001dR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0018\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010*R\u0014\u0010+\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010*R\u0014\u0010,\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010*R\u0014\u0010-\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010*R\u0013\u0010.\u001a\u0004\u0018\u00010\u00178F¢\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b3\u00102¨\u0006C"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl;", "V", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "descriptorInitialValue", "rawBoundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Ljava/lang/Object;)V", "_descriptor", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin.jvm.PlatformType", "_javaField", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Ljava/lang/reflect/Field;", "getBoundReceiver", "()Ljava/lang/Object;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "getter", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "getGetter", "()Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "isBound", "", "()Z", "isConst", "isLateinit", "isSuspend", "javaField", "getJavaField", "()Ljava/lang/reflect/Field;", "getName", "()Ljava/lang/String;", "getSignature", "computeDelegateSource", "Ljava/lang/reflect/Member;", "equals", "other", "getDelegateImpl", "fieldOrMethod", "receiver1", "receiver2", "hashCode", "", "toString", "Accessor", "Companion", "Getter", "Setter", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class v<V> extends f<V> implements kotlin.s0.l<V> {
    private static final Object p = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final i f21346j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f21347k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f21348l;
    private final Object m;
    private final c0.b<Field> n;
    private final c0.a<u0> o;

    /* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<PropertyType>] */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u0001*\u0006\b\u0002\u0010\u0002 \u00012\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0015R\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00010\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "PropertyType", "ReturnType", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty$Accessor;", "Lkotlin/reflect/KFunction;", "()V", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getDefaultCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyAccessorDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyAccessorDescriptor;", "isBound", "", "()Z", "isExternal", "isInfix", "isInline", "isOperator", "isSuspend", "property", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "getProperty", "()Lkotlin/reflect/jvm/internal/KPropertyImpl;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class a<PropertyType, ReturnType> extends f<ReturnType> implements kotlin.s0.g<ReturnType> {
        public a() {
        }

        @Override // kotlin.s0.g
        public boolean isExternal() {
            return x().isExternal();
        }

        @Override // kotlin.s0.g
        public boolean isInfix() {
            return x().isInfix();
        }

        @Override // kotlin.s0.g
        public boolean isInline() {
            return x().isInline();
        }

        @Override // kotlin.s0.g
        public boolean isOperator() {
            return x().isOperator();
        }

        @Override // kotlin.s0.c
        public boolean isSuspend() {
            return x().isSuspend();
        }

        @Override // kotlin.s0.w.d.f
        public i s() {
            return y().s();
        }

        @Override // kotlin.s0.w.d.f
        public kotlin.s0.w.d.k0.d<?> t() {
            return null;
        }

        @Override // kotlin.s0.w.d.f
        public boolean w() {
            return y().w();
        }

        public abstract t0 x();

        public abstract v<PropertyType> y();
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0016R\u001f\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00068VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "V", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "Lkotlin/reflect/KProperty$Getter;", "()V", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyGetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class b<V> extends a<V, V> implements Object<V> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        static final /* synthetic */ kotlin.s0.l<Object>[] f21349l = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final c0.a f21350j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final c0.b f21351k;

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0012\u0012\u0002\b\u0003 \u0002*\b\u0012\u0002\b\u0003\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0003 \u0001\"\u0006\b\u0001\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "kotlin.jvm.PlatformType", "V", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class a extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.s0.w.d.k0.d<?>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ b<V> f21352f;

            /* JADX WARN: Multi-variable type inference failed */
            a(b<? extends V> r1) {
                this.f21352f = r1;
                super(0);
            }

            public final kotlin.s0.w.d.k0.d<?> a() {
                return w.a(this.f21352f, true);
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ kotlin.s0.w.d.k0.d<?> invoke() {
                return a();
            }
        }

        /* JADX INFO: renamed from: kotlin.s0.w.d.v$b$b, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0003 \u0001\"\u0006\b\u0001\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyGetterDescriptor;", "kotlin.jvm.PlatformType", "V", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class C0589b extends kotlin.n0.d.q implements kotlin.n0.c.a<v0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ b<V> f21353f;

            /* JADX WARN: Multi-variable type inference failed */
            C0589b(b<? extends V> r1) {
                this.f21353f = r1;
                super(0);
            }

            public final v0 a() {
                v0 r0 = this.f21353f.y().A().g();
                if (r0 == null) goto L5;
                return r0;
            L5:
                return kotlin.s0.w.d.l0.k.c.d(this.f21353f.y().A(), kotlin.s0.w.d.l0.c.o1.g.f18919b.b());
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ v0 invoke() {
                return a();
            }
        }

        static {
            f21349l = new kotlin.s0.l[]{kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(b.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;")), kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(b.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
        }

        public b() {
            this.f21350j = c0.d(new C0589b(this));
            this.f21351k = c0.b(new a(this));
        }

        @Override // java.lang.Object
        public boolean equals(Object r2) {
            if ((r2 instanceof b) == true) goto L5;
        L7:
            return false;
        L5:
            if (kotlin.n0.d.o.a(y(), ((b) r2).y()) == false) goto L7;
            return true;
        }

        @Override // kotlin.s0.c
        public String getName() {
            return "<get-" + y().getName() + '>';
        }

        @Override // java.lang.Object
        public int hashCode() {
            return y().hashCode();
        }

        @Override // kotlin.s0.w.d.f
        public kotlin.s0.w.d.k0.d<?> r() {
            T r3 = this.f21351k.b(this, f21349l[1]);
            kotlin.n0.d.o.e(r3, "<get-caller>(...)");
            return (kotlin.s0.w.d.k0.d) r3;
        }

        @Override // java.lang.Object
        public String toString() {
            return "getter of " + y();
        }

        @Override // kotlin.s0.w.d.f
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.b u() {
            return z();
        }

        @Override // kotlin.s0.w.d.v.a
        public /* bridge */ /* synthetic */ t0 x() {
            return z();
        }

        public v0 z() {
            T r3 = this.f21350j.b(this, f21349l[0]);
            kotlin.n0.d.o.e(r3, "<get-descriptor>(...)");
            return (v0) r3;
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0001\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016R\u001f\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "V", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "", "Lkotlin/reflect/KMutableProperty$Setter;", "()V", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertySetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class c<V> extends a<V, kotlin.f0> implements Object<V> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        static final /* synthetic */ kotlin.s0.l<Object>[] f21354l = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final c0.a f21355j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final c0.b f21356k;

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0012\u0012\u0002\b\u0003 \u0002*\b\u0012\u0002\b\u0003\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0003\"\u0006\b\u0001\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "kotlin.jvm.PlatformType", "V", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class a extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.s0.w.d.k0.d<?>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ c<V> f21357f;

            a(c<V> r1) {
                this.f21357f = r1;
                super(0);
            }

            public final kotlin.s0.w.d.k0.d<?> a() {
                return w.a(this.f21357f, false);
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ kotlin.s0.w.d.k0.d<?> invoke() {
                return a();
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0003\"\u0006\b\u0001\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertySetterDescriptor;", "kotlin.jvm.PlatformType", "V", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class b extends kotlin.n0.d.q implements kotlin.n0.c.a<w0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ c<V> f21358f;

            b(c<V> r1) {
                this.f21358f = r1;
                super(0);
            }

            public final w0 a() {
                w0 r0 = this.f21358f.y().A().Y();
                if (r0 != null) goto L6;
                u0 r2 = this.f21358f.y().A();
                kotlin.s0.w.d.l0.c.o1.g.a r1 = kotlin.s0.w.d.l0.c.o1.g.f18919b;
                return kotlin.s0.w.d.l0.k.c.e(r2, r1.b(), r1.b());
            L6:
                return r0;
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ w0 invoke() {
                return a();
            }
        }

        static {
            f21354l = new kotlin.s0.l[]{kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(c.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;")), kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(c.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
        }

        public c() {
            this.f21355j = c0.d(new b(this));
            this.f21356k = c0.b(new a(this));
        }

        @Override // java.lang.Object
        public boolean equals(Object r2) {
            if ((r2 instanceof c) == true) goto L5;
        L7:
            return false;
        L5:
            if (kotlin.n0.d.o.a(y(), ((c) r2).y()) == false) goto L7;
            return true;
        }

        @Override // kotlin.s0.c
        public String getName() {
            return "<set-" + y().getName() + '>';
        }

        @Override // java.lang.Object
        public int hashCode() {
            return y().hashCode();
        }

        @Override // kotlin.s0.w.d.f
        public kotlin.s0.w.d.k0.d<?> r() {
            T r3 = this.f21356k.b(this, f21354l[1]);
            kotlin.n0.d.o.e(r3, "<get-caller>(...)");
            return (kotlin.s0.w.d.k0.d) r3;
        }

        @Override // java.lang.Object
        public String toString() {
            return "setter of " + y();
        }

        @Override // kotlin.s0.w.d.f
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.b u() {
            return z();
        }

        @Override // kotlin.s0.w.d.v.a
        public /* bridge */ /* synthetic */ t0 x() {
            return z();
        }

        public w0 z() {
            T r3 = this.f21355j.b(this, f21354l[0]);
            kotlin.n0.d.o.e(r3, "<get-descriptor>(...)");
            return (w0) r3;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "kotlin.jvm.PlatformType", "V", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class d extends kotlin.n0.d.q implements kotlin.n0.c.a<u0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ v<V> f21359f;

        /* JADX WARN: Multi-variable type inference failed */
        d(v<? extends V> r1) {
            this.f21359f = r1;
            super(0);
        }

        public final u0 a() {
            return this.f21359f.s().s(this.f21359f.getName(), this.f21359f.D());
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ u0 invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Field;", "V", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class e extends kotlin.n0.d.q implements kotlin.n0.c.a<Field> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ v<V> f21360f;

        /* JADX WARN: Multi-variable type inference failed */
        e(v<? extends V> r1) {
            this.f21360f = r1;
            super(0);
        }

        public final Field a() {
            kotlin.s0.w.d.e r0 = f0.f18547a.f(this.f21360f.A());
            if ((r0 instanceof kotlin.s0.w.d.e.c) == false) goto L20;
            kotlin.s0.w.d.e.c r1 = (kotlin.s0.w.d.e.c) r0;
            u0 r2 = r1.b();
            kotlin.s0.w.d.l0.f.a0.b.d.a r3 = kotlin.s0.w.d.l0.f.a0.b.i.d(kotlin.s0.w.d.l0.f.a0.b.i.f19890a, r1.e(), r1.d(), r1.g(), false, 8, null);
            if (r3 == null) goto L27;
            v<V> r10 = this.f21360f;
            if (kotlin.s0.w.d.l0.e.a.k.e(r2) == false) goto L9;
        L15:
            Class<?> r11 = r10.s().e().getEnclosingClass();
        L16:
            if (r11 == null) goto L33;
            return r11.getDeclaredField(r3.c());
        L38:
            return null;
        L33:
            return null;
        L9:
            if (kotlin.s0.w.d.l0.f.a0.b.i.f(r1.e()) == true) goto L15;
            kotlin.s0.w.d.l0.c.m r4 = r2.c();
            if ((r4 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L14;
            r11 = i0.o((kotlin.s0.w.d.l0.c.e) r4);
            goto L16
        L14:
            r11 = r10.s().e();
            goto L16
        L27:
            return null;
        L20:
            if ((r0 instanceof kotlin.s0.w.d.e.a) == false) goto L23;
            return ((kotlin.s0.w.d.e.a) r0).b();
        L23:
            if ((r0 instanceof kotlin.s0.w.d.e.b) == false) goto L26;
            return null;
        L26:
            if ((r0 instanceof kotlin.s0.w.d.e.d) == false) goto L29;
            return null;
        L29:
            throw new kotlin.m();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Field invoke() {
            return a();
        }
    }

    static {
        p = new Object();
    }

    public v(i r8, String r9, String r10, Object r11) {
        kotlin.n0.d.o.f(r8, "container");
        kotlin.n0.d.o.f(r9, "name");
        kotlin.n0.d.o.f(r10, "signature");
        this(r8, r9, r10, null, r11);
    }

    private v(i r1, String r2, String r3, u0 r4, Object r5) {
        this.f21346j = r1;
        this.f21347k = r2;
        this.f21348l = r3;
        this.m = r5;
        c0.b<Field> r6 = c0.b(new e(this));
        kotlin.n0.d.o.e(r6, "lazy {\n        when (val…y -> null\n        }\n    }");
        this.n = r6;
        c0.a<u0> r7 = c0.c(r4, new d(this));
        kotlin.n0.d.o.e(r7, "lazySoft(descriptorIniti…or(name, signature)\n    }");
        this.o = r7;
    }

    public v(i r8, u0 r9) {
        kotlin.n0.d.o.f(r8, "container");
        kotlin.n0.d.o.f(r9, "descriptor");
        String r3 = r9.getName().b();
        kotlin.n0.d.o.e(r3, "descriptor.name.asString()");
        this(r8, r3, f0.f18547a.f(r9).a(), r9, kotlin.n0.d.c.NO_RECEIVER);
    }

    public u0 A() {
        u0 r1 = this.o.invoke();
        kotlin.n0.d.o.e(r1, "_descriptor()");
        return r1;
    }

    public abstract b<V> B();

    public final Field C() {
        return this.n.invoke();
    }

    public final String D() {
        return this.f21348l;
    }

    public boolean equals(Object r4) {
        v<?> r5 = i0.c(r4);
        if (r5 != null) goto L6;
        return false;
    L6:
        if (kotlin.n0.d.o.a(s(), r5.s()) == true) goto L8;
        return false;
    L8:
        if (kotlin.n0.d.o.a(getName(), r5.getName()) == true) goto L10;
        return false;
    L10:
        if (kotlin.n0.d.o.a(this.f21348l, r5.f21348l) == true) goto L12;
        return false;
    L12:
        if (kotlin.n0.d.o.a(this.m, r5.m) == false) goto L18;
        return true;
    L18:
        return false;
    }

    @Override // kotlin.s0.c
    public String getName() {
        return this.f21347k;
    }

    public int hashCode() {
        return (((s().hashCode() * 31) + getName().hashCode()) * 31) + this.f21348l.hashCode();
    }

    @Override // kotlin.s0.c
    public boolean isSuspend() {
        return false;
    }

    @Override // kotlin.s0.w.d.f
    public kotlin.s0.w.d.k0.d<?> r() {
        return B().r();
    }

    @Override // kotlin.s0.w.d.f
    public i s() {
        return this.f21346j;
    }

    @Override // kotlin.s0.w.d.f
    public kotlin.s0.w.d.k0.d<?> t() {
        return B().t();
    }

    public String toString() {
        return e0.f18529a.g(A());
    }

    @Override // kotlin.s0.w.d.f
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.b u() {
        return A();
    }

    @Override // kotlin.s0.w.d.f
    public boolean w() {
        return !kotlin.n0.d.o.a(this.m, kotlin.n0.d.c.NO_RECEIVER);
    }

    protected final Member x() {
        if (A().O() == true) goto L5;
        return null;
    L5:
        kotlin.s0.w.d.e r0 = f0.f18547a.f(A());
        if ((r0 instanceof kotlin.s0.w.d.e.c) == false) goto L18;
        kotlin.s0.w.d.e.c r1 = (kotlin.s0.w.d.e.c) r0;
        if (r1.f().E() == false) goto L18;
        kotlin.s0.w.d.l0.f.a0.a.c r2 = r1.f().z();
        if (r2.z() == true) goto L12;
    L16:
        return null;
    L12:
        if (r2.y() == false) goto L16;
        String r3 = r1.d().b(r2.w());
        String r4 = r1.d().b(r2.v());
        return s().r(r3, r4);
    L18:
        return C();
    }

    public final Object y() {
        return kotlin.s0.w.d.k0.h.a(this.m, A());
    }

    protected final Object z(Member r7, Object r8, Object r9) {
        Object r0 = p;     // Catch: IllegalAccessException -> L57
        if (r8 == r0) goto L6;
        if (r9 == r0) goto L6;
    L8:
        if (w() == false) goto L10;
        Object r1 = y();     // Catch: IllegalAccessException -> L57
    L12:
        if (r1 == r0) goto L14;
        boolean r4 = true;
    L16:
        if (r4 == true) goto L20;
        r1 = null;
    L20:
        if (w() == true) goto L23;
        r8 = r9;
    L23:
        if (r8 == r0) goto L25;
        boolean r6 = true;
    L26:
        if (r6 == true) goto L29;
        r8 = null;
    L29:
        if (r7 != null) goto L32;
        return null;
    L32:
        if ((r7 instanceof Field) == false) goto L35;
        return ((Field) r7).get(r1);
    L35:
        if ((r7 instanceof Method) == false) goto L54;
        int r10 = ((Method) r7).getParameterTypes().length;     // Catch: IllegalAccessException -> L57
        if (r10 == 0) goto L52;
        if (r10 != 1) goto L40;
        Method r11 = (Method) r7;     // Catch: IllegalAccessException -> L57
        Object[] r12 = new Object[1];     // Catch: IllegalAccessException -> L57
        if (r1 != null) goto L50;
        Class<?> r13 = ((Method) r7).getParameterTypes()[0];     // Catch: IllegalAccessException -> L57
        kotlin.n0.d.o.e(r13, "fieldOrMethod.parameterTypes[0]");     // Catch: IllegalAccessException -> L57
        r1 = i0.f(r13);     // Catch: IllegalAccessException -> L57
    L50:
        r12[0] = r1;     // Catch: IllegalAccessException -> L57
        return r11.invoke(null, r12);
    L40:
        if (r10 != 2) goto L46;
        Method r14 = (Method) r7;     // Catch: IllegalAccessException -> L57
        Object[] r15 = new Object[2];     // Catch: IllegalAccessException -> L57
        r15[0] = r1;     // Catch: IllegalAccessException -> L57
        if (r8 != null) goto L44;
        Class<?> r16 = ((Method) r7).getParameterTypes()[1];     // Catch: IllegalAccessException -> L57
        kotlin.n0.d.o.e(r16, "fieldOrMethod.parameterTypes[1]");     // Catch: IllegalAccessException -> L57
        r8 = i0.f(r16);     // Catch: IllegalAccessException -> L57
    L44:
        r15[1] = r8;     // Catch: IllegalAccessException -> L57
        return r14.invoke(null, r15);
    L46:
        throw new AssertionError("delegate method " + r7 + " should take 0, 1, or 2 parameters");     // Catch: IllegalAccessException -> L57
    L52:
        return ((Method) r7).invoke(null, new Object[0]);
    L54:
        throw new AssertionError("delegate field/method " + r7 + " neither field nor method");     // Catch: IllegalAccessException -> L57
    L25:
        r6 = false;
        goto L26
    L14:
        r4 = false;
        goto L16
    L10:
        r1 = r8;
    L6:
        if (A().m0() != null) goto L8;
        throw new RuntimeException('\'' + this + "' is not an extension property and thus getExtensionDelegate() is not going to work, use getDelegate() instead");     // Catch: IllegalAccessException -> L57
    L57:
        e = move-exception;
        throw new kotlin.s0.v.b(e);
    }
}
