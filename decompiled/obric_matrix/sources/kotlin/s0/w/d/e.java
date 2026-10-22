package kotlin.s0.w.d;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.s0.w.d.l0.c.l0;
import kotlin.s0.w.d.l0.c.u0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0004\u0005\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u0082\u0001\u0004\t\n\u000b\f¨\u0006\r"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "", "()V", "asString", "", "JavaField", "JavaMethodProperty", "KotlinProperty", "MappedKotlinProperty", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaField;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaMethodProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$KotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$MappedKotlinProperty;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class e {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaField;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "getField", "()Ljava/lang/reflect/Field;", "asString", "", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Field f18518a;

        public a(Field r2) {
            kotlin.n0.d.o.f(r2, "field");
            super(null);
            this.f18518a = r2;
        }

        @Override // kotlin.s0.w.d.e
        public String a() {
            StringBuilder r0 = new StringBuilder();
            String r1 = this.f18518a.getName();
            kotlin.n0.d.o.e(r1, "field.name");
            r0.append(kotlin.s0.w.d.l0.e.a.z.b(r1));
            r0.append("()");
            Class<?> r3 = this.f18518a.getType();
            kotlin.n0.d.o.e(r3, "field.type");
            r0.append(kotlin.s0.w.d.l0.c.s1.b.d.b(r3));
            return r0.toString();
        }

        public final Field b() {
            return this.f18518a;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaMethodProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "getterMethod", "Ljava/lang/reflect/Method;", "setterMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getGetterMethod", "()Ljava/lang/reflect/Method;", "getSetterMethod", "asString", "", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f18519a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method f18520b;

        public b(Method r2, Method r3) {
            kotlin.n0.d.o.f(r2, "getterMethod");
            super(null);
            this.f18519a = r2;
            this.f18520b = r3;
        }

        @Override // kotlin.s0.w.d.e
        public String a() {
            return g0.a(this.f18519a);
        }

        public final Method b() {
            return this.f18519a;
        }

        public final Method c() {
            return this.f18520b;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0019\u001a\u00020\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$KotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "proto", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property;", "signature", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;)V", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "getNameResolver", "()Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;", "getProto", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", TypedValues.Custom.S_STRING, "", "getTypeTable", "()Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;", "asString", "getManglingSuffix", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final u0 f18521a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.f.n f18522b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.f.a0.a.d f18523c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.f.z.c f18524d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.f.z.g f18525e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f18526f;

        public c(u0 r8, kotlin.s0.w.d.l0.f.n r9, kotlin.s0.w.d.l0.f.a0.a.d r10, kotlin.s0.w.d.l0.f.z.c r11, kotlin.s0.w.d.l0.f.z.g r12) {
            kotlin.n0.d.o.f(r8, "descriptor");
            kotlin.n0.d.o.f(r9, "proto");
            kotlin.n0.d.o.f(r10, "signature");
            kotlin.n0.d.o.f(r11, "nameResolver");
            kotlin.n0.d.o.f(r12, "typeTable");
            super(null);
            this.f18521a = r8;
            this.f18522b = r9;
            this.f18523c = r10;
            this.f18524d = r11;
            this.f18525e = r12;
            if (r10.G() == false) goto L5;
            String r13 = r11.b(r10.B().w()) + r11.b(r10.B().v());
        L8:
            this.f18526f = r13;
            return;
        L5:
            kotlin.s0.w.d.l0.f.a0.b.d.a r14 = kotlin.s0.w.d.l0.f.a0.b.i.d(kotlin.s0.w.d.l0.f.a0.b.i.f19890a, r9, r11, r12, false, 8, null);
            if (r14 == null) goto L11;
            String r15 = r14.d();
            r13 = kotlin.s0.w.d.l0.e.a.z.b(r15) + c() + "()" + r14.e();
            goto L8
        L11:
            throw new a0("No field signature for property: " + r8);
        }

        private final String c() {
            kotlin.s0.w.d.l0.c.m r0 = this.f18521a.c();
            kotlin.n0.d.o.e(r0, "descriptor.containingDeclaration");
            if (kotlin.n0.d.o.a(this.f18521a.getVisibility(), kotlin.s0.w.d.l0.c.t.f19162d) == false) goto L15;
            if ((r0 instanceof kotlin.s0.w.d.l0.l.b.g0.d) == false) goto L15;
            kotlin.s0.w.d.l0.f.c r1 = ((kotlin.s0.w.d.l0.l.b.g0.d) r0).c1();
            kotlin.s0.w.d.l0.i.i.f<kotlin.s0.w.d.l0.f.c, Integer> r2 = kotlin.s0.w.d.l0.f.a0.a.f19808i;
            kotlin.n0.d.o.e(r2, "classModuleName");
            Integer r3 = (Integer) kotlin.s0.w.d.l0.f.z.e.a(r1, r2);
            if (r3 == null) goto L10;
            String r4 = this.f18524d.b(r3.intValue());
            if (r4 == null) goto L10;
        L11:
            StringBuilder r5 = new StringBuilder();
            r5.append('$');
            String r6 = kotlin.s0.w.d.l0.g.g.a(r4);
        L12:
            r5.append(r6);
            return r5.toString();
        L10:
            r4 = "main";
        L15:
            if (kotlin.n0.d.o.a(this.f18521a.getVisibility(), kotlin.s0.w.d.l0.c.t.f19159a) == true) goto L17;
            return "";
        L17:
            if ((r0 instanceof l0) == false) goto L25;
            u0 r7 = this.f18521a;
            kotlin.n0.d.o.d(r7, "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedPropertyDescriptor");
            kotlin.s0.w.d.l0.l.b.g0.f r8 = ((kotlin.s0.w.d.l0.l.b.g0.j) r7).c0();
            if ((r8 instanceof kotlin.s0.w.d.l0.e.b.k) == false) goto L26;
            kotlin.s0.w.d.l0.e.b.k r9 = (kotlin.s0.w.d.l0.e.b.k) r8;
            if (r9.f() == null) goto L27;
            r5 = new StringBuilder();
            r5.append('$');
            r6 = r9.h().b();
            goto L12
        L27:
            return "";
        L26:
            return "";
        L25:
            return "";
        }

        @Override // kotlin.s0.w.d.e
        public String a() {
            return this.f18526f;
        }

        public final u0 b() {
            return this.f18521a;
        }

        public final kotlin.s0.w.d.l0.f.z.c d() {
            return this.f18524d;
        }

        public final kotlin.s0.w.d.l0.f.n e() {
            return this.f18522b;
        }

        public final kotlin.s0.w.d.l0.f.a0.a.d f() {
            return this.f18523c;
        }

        public final kotlin.s0.w.d.l0.f.z.g g() {
            return this.f18525e;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$MappedKotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "getterSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "setterSignature", "(Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;)V", "getGetterSignature", "()Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "getSetterSignature", "asString", "", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final kotlin.s0.w.d.d.e f18527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final kotlin.s0.w.d.d.e f18528b;

        public d(kotlin.s0.w.d.d.e r2, kotlin.s0.w.d.d.e r3) {
            kotlin.n0.d.o.f(r2, "getterSignature");
            super(null);
            this.f18527a = r2;
            this.f18528b = r3;
        }

        @Override // kotlin.s0.w.d.e
        public String a() {
            return this.f18527a.a();
        }

        public final kotlin.s0.w.d.d.e b() {
            return this.f18527a;
        }

        public final kotlin.s0.w.d.d.e c() {
            return this.f18528b;
        }
    }

    private e() {
    }

    public /* synthetic */ e(kotlin.n0.d.g r1) {
        this();
    }

    public abstract String a();
}
