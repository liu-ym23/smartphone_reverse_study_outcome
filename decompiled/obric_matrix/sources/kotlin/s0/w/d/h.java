package kotlin.s0.w.d;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.n.m0;

/* JADX WARN: Unexpected interfaces in signature: [kotlin.s0.w.d.z] */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u00052\u00020\u0006:\u0001eB\u0013\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\tJ\u0013\u0010T\u001a\u00020&2\b\u0010U\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0016\u0010V\u001a\b\u0012\u0004\u0012\u00020W0\u00142\u0006\u0010X\u001a\u00020YH\u0016J\u0012\u0010Z\u001a\u0004\u0018\u00010[2\u0006\u0010\\\u001a\u00020]H\u0016J\u0016\u0010^\u001a\b\u0012\u0004\u0012\u00020[0\u00142\u0006\u0010X\u001a\u00020YH\u0016J\b\u0010_\u001a\u00020]H\u0016J\u0012\u0010`\u001a\u00020&2\b\u0010a\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010b\u001a\u00020cH\u0002J\b\u0010d\u001a\u00020AH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00190\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0017R3\u0010\u001b\u001a$\u0012 \u0012\u001e \u001e*\u000e\u0018\u00010\u001dR\b\u0012\u0004\u0012\u00028\u00000\u00000\u001dR\b\u0012\u0004\u0012\u00028\u00000\u00000\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010'R\u0014\u0010(\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010'R\u0014\u0010)\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010'R\u0014\u0010*\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010'R\u0014\u0010+\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010'R\u0014\u0010,\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010'R\u0014\u0010-\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010'R\u0014\u0010.\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010'R\u001a\u0010/\u001a\u00020&8VX\u0096\u0004¢\u0006\f\u0012\u0004\b0\u00101\u001a\u0004\b/\u0010'R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0014\u00104\u001a\u0002058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u001e\u00108\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003090\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010\u0017R\u001e\u0010;\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\u0017R\u0016\u0010=\u001a\u0004\u0018\u00018\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0016\u0010@\u001a\u0004\u0018\u00010A8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\"\u0010D\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00040\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010\u000eR\u0016\u0010F\u001a\u0004\u0018\u00010A8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bG\u0010CR\u0014\u0010H\u001a\u0002058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bI\u00107R\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020K0\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bL\u0010\u000eR\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020N0\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bO\u0010\u000eR\u0016\u0010P\u001a\u0004\u0018\u00010Q8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bR\u0010S¨\u0006f"}, d2 = {"Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors", "data", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "kotlin.jvm.PlatformType", "getData", "()Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "isAbstract", "", "()Z", "isCompanion", "isData", "isFinal", "isFun", "isInner", "isOpen", "isSealed", "isValue", "isValue$annotations", "()V", "getJClass", "()Ljava/lang/Class;", "memberScope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getMemberScope$kotlin_reflection", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "getSealedSubclasses", "simpleName", "getSimpleName", "staticScope", "getStaticScope$kotlin_reflection", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "index", "", "getProperties", "hashCode", "isInstance", "value", "reportUnresolvedClass", "", "toString", "Data", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class h<T> extends i implements kotlin.s0.d<T>, Object {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Class<T> f18551i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final c0.b<h<T>.a> f18552j;

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010N\u001a\u00020<2\n\u0010O\u001a\u0006\u0012\u0002\b\u00030PH\u0002R%\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR%\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\bR%\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000f\u0010\bR!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0014\u0010\u0015R-\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00180\u00058FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\n\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\bR%\u0010\u001d\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\n\u001a\u0004\b\u001e\u0010\bR%\u0010 \u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\n\u001a\u0004\b!\u0010\bR%\u0010#\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\n\u001a\u0004\b$\u0010\bR\u001b\u0010&\u001a\u00020'8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\n\u001a\u0004\b(\u0010)R%\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\n\u001a\u0004\b,\u0010\bR%\u0010.\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\n\u001a\u0004\b/\u0010\bR%\u00101\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\n\u001a\u0004\b3\u0010\bR#\u00105\u001a\u0004\u0018\u00018\u00008FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b9\u0010:\u0012\u0004\b6\u0010\u001a\u001a\u0004\b7\u00108R\u001d\u0010;\u001a\u0004\u0018\u00010<8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\n\u001a\u0004\b=\u0010>R)\u0010@\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u0000020\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\n\u001a\u0004\bA\u0010\u0015R\u001d\u0010C\u001a\u0004\u0018\u00010<8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\n\u001a\u0004\bD\u0010>R!\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bI\u0010\n\u001a\u0004\bH\u0010\u0015R!\u0010J\u001a\b\u0012\u0004\u0012\u00020K0\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\n\u001a\u0004\bL\u0010\u0015¨\u0006Q"}, d2 = {"Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "(Lkotlin/reflect/jvm/internal/KClassImpl;)V", "allMembers", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getAllMembers", "()Ljava/util/Collection;", "allMembers$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "allNonStaticMembers", "getAllNonStaticMembers", "allNonStaticMembers$delegate", "allStaticMembers", "getAllStaticMembers", "allStaticMembers$delegate", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors$annotations", "()V", "getConstructors", "constructors$delegate", "declaredMembers", "getDeclaredMembers", "declaredMembers$delegate", "declaredNonStaticMembers", "getDeclaredNonStaticMembers", "declaredNonStaticMembers$delegate", "declaredStaticMembers", "getDeclaredStaticMembers", "declaredStaticMembers$delegate", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor$delegate", "inheritedNonStaticMembers", "getInheritedNonStaticMembers", "inheritedNonStaticMembers$delegate", "inheritedStaticMembers", "getInheritedStaticMembers", "inheritedStaticMembers$delegate", "nestedClasses", "Lkotlin/reflect/KClass;", "getNestedClasses", "nestedClasses$delegate", "objectInstance", "getObjectInstance$annotations", "getObjectInstance", "()Ljava/lang/Object;", "objectInstance$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "qualifiedName$delegate", "sealedSubclasses", "getSealedSubclasses", "sealedSubclasses$delegate", "simpleName", "getSimpleName", "simpleName$delegate", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "supertypes$delegate", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "typeParameters$delegate", "calculateLocalClassName", "jClass", "Ljava/lang/Class;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class a extends kotlin.s0.w.d.i.b {
        static final /* synthetic */ kotlin.s0.l<Object>[] n = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final c0.a f18553d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final c0.a f18554e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final c0.a f18555f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final c0.a f18556g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final c0.a f18557h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final c0.a f18558i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final c0.a f18559j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final c0.a f18560k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final c0.a f18561l;
        final /* synthetic */ h<T> m;

        /* JADX INFO: renamed from: kotlin.s0.w.d.h$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002 \u0003*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin.jvm.PlatformType", "T", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class C0484a extends kotlin.n0.d.q implements kotlin.n0.c.a<List<? extends kotlin.s0.w.d.f<?>>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ h<T>.a f18562f;

            C0484a(h<T>.a r1) {
                this.f18562f = r1;
                super(0);
            }

            public final List<kotlin.s0.w.d.f<?>> a() {
                return kotlin.i0.r.k0(this.f18562f.g(), this.f18562f.h());
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ List<? extends kotlin.s0.w.d.f<?>> invoke() {
                return a();
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002 \u0003*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin.jvm.PlatformType", "T", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class b extends kotlin.n0.d.q implements kotlin.n0.c.a<List<? extends kotlin.s0.w.d.f<?>>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ h<T>.a f18563f;

            b(h<T>.a r1) {
                this.f18563f = r1;
                super(0);
            }

            public final List<kotlin.s0.w.d.f<?>> a() {
                return kotlin.i0.r.k0(this.f18563f.i(), a.d(this.f18563f));
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ List<? extends kotlin.s0.w.d.f<?>> invoke() {
                return a();
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002 \u0003*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin.jvm.PlatformType", "T", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class c extends kotlin.n0.d.q implements kotlin.n0.c.a<List<? extends kotlin.s0.w.d.f<?>>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ h<T>.a f18564f;

            c(h<T>.a r1) {
                this.f18564f = r1;
                super(0);
            }

            public final List<kotlin.s0.w.d.f<?>> a() {
                return kotlin.i0.r.k0(a.c(this.f18564f), a.e(this.f18564f));
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ List<? extends kotlin.s0.w.d.f<?>> invoke() {
                return a();
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "T", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class d extends kotlin.n0.d.q implements kotlin.n0.c.a<List<? extends Annotation>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ h<T>.a f18565f;

            d(h<T>.a r1) {
                this.f18565f = r1;
                super(0);
            }

            public final List<Annotation> a() {
                return i0.d(this.f18565f.k());
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ List<? extends Annotation> invoke() {
                return a();
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0002 \u0004*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/KFunction;", "T", "kotlin.jvm.PlatformType", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class e extends kotlin.n0.d.q implements kotlin.n0.c.a<List<? extends kotlin.s0.g<? extends T>>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ h<T> f18566f;

            e(h<T> r1) {
                this.f18566f = r1;
                super(0);
            }

            public final List<kotlin.s0.g<T>> a() {
                Collection<kotlin.s0.w.d.l0.c.l> r0 = this.f18566f.t();
                h<T> r4 = this.f18566f;
                ArrayList r1 = new ArrayList(kotlin.i0.r.q(r0, 10));
                Iterator<T> r2 = r0.iterator();
            L4:
                if (r2.hasNext() == false) goto L6;
                r1.add(new kotlin.s0.w.d.j(r4, (kotlin.s0.w.d.l0.c.l) r2.next()));
                goto L4
            L6:
                return r1;
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ Object invoke() {
                return a();
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002 \u0003*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin.jvm.PlatformType", "T", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class f extends kotlin.n0.d.q implements kotlin.n0.c.a<List<? extends kotlin.s0.w.d.f<?>>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ h<T>.a f18567f;

            f(h<T>.a r1) {
                this.f18567f = r1;
                super(0);
            }

            public final List<kotlin.s0.w.d.f<?>> a() {
                return kotlin.i0.r.k0(this.f18567f.i(), a.c(this.f18567f));
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ List<? extends kotlin.s0.w.d.f<?>> invoke() {
                return a();
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002 \u0003*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin.jvm.PlatformType", "T", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class g extends kotlin.n0.d.q implements kotlin.n0.c.a<Collection<? extends kotlin.s0.w.d.f<?>>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ h<T> f18568f;

            g(h<T> r1) {
                this.f18568f = r1;
                super(0);
            }

            public final Collection<kotlin.s0.w.d.f<?>> a() {
                h<T> r2 = this.f18568f;
                return r2.w(r2.K(), kotlin.s0.w.d.i.c.f18598f);
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ Collection<? extends kotlin.s0.w.d.f<?>> invoke() {
                return a();
            }
        }

        /* JADX INFO: renamed from: kotlin.s0.w.d.h$a$h, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002 \u0003*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin.jvm.PlatformType", "T", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class C0485h extends kotlin.n0.d.q implements kotlin.n0.c.a<Collection<? extends kotlin.s0.w.d.f<?>>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ h<T> f18569f;

            C0485h(h<T> r1) {
                this.f18569f = r1;
                super(0);
            }

            public final Collection<kotlin.s0.w.d.f<?>> a() {
                h<T> r2 = this.f18569f;
                return r2.w(r2.L(), kotlin.s0.w.d.i.c.f18598f);
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ Collection<? extends kotlin.s0.w.d.f<?>> invoke() {
                return a();
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "kotlin.jvm.PlatformType", "T", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class i extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.s0.w.d.l0.c.e> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ h<T> f18570f;

            i(h<T> r1) {
                this.f18570f = r1;
                super(0);
            }

            public final kotlin.s0.w.d.l0.c.e a() {
                kotlin.s0.w.d.l0.g.b r0 = h.F(this.f18570f);
                kotlin.s0.w.d.l0.c.s1.a.k r1 = this.f18570f.I().invoke().a();
                if (r0.k() == false) goto L5;
                kotlin.s0.w.d.l0.c.e r2 = r1.a().b(r0);
            L6:
                if (r2 == null) goto L8;
                return r2;
            L8:
                h.G(this.f18570f);
                throw null;
            L5:
                r2 = kotlin.s0.w.d.l0.c.x.a(r1.b(), r0);
                goto L6
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.e invoke() {
                return a();
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002 \u0003*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin.jvm.PlatformType", "T", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class j extends kotlin.n0.d.q implements kotlin.n0.c.a<Collection<? extends kotlin.s0.w.d.f<?>>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ h<T> f18571f;

            j(h<T> r1) {
                this.f18571f = r1;
                super(0);
            }

            public final Collection<kotlin.s0.w.d.f<?>> a() {
                h<T> r2 = this.f18571f;
                return r2.w(r2.K(), kotlin.s0.w.d.i.c.f18599g);
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ Collection<? extends kotlin.s0.w.d.f<?>> invoke() {
                return a();
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002 \u0003*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin.jvm.PlatformType", "T", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class k extends kotlin.n0.d.q implements kotlin.n0.c.a<Collection<? extends kotlin.s0.w.d.f<?>>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ h<T> f18572f;

            k(h<T> r1) {
                this.f18572f = r1;
                super(0);
            }

            public final Collection<kotlin.s0.w.d.f<?>> a() {
                h<T> r2 = this.f18572f;
                return r2.w(r2.L(), kotlin.s0.w.d.i.c.f18599g);
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ Collection<? extends kotlin.s0.w.d.f<?>> invoke() {
                return a();
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a6\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u00030\u0002 \u0004*\u001a\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u00030\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KClassImpl;", "", "kotlin.jvm.PlatformType", "T", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class l extends kotlin.n0.d.q implements kotlin.n0.c.a<List<? extends h<? extends Object>>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ h<T>.a f18573f;

            l(h<T>.a r1) {
                this.f18573f = r1;
                super(0);
            }

            public final List<h<? extends Object>> a() {
                kotlin.s0.w.d.l0.k.w.h r4 = this.f18573f.k().y0();
                kotlin.n0.d.o.e(r4, "descriptor.unsubstitutedInnerClassesScope");
                Collection r5 = kotlin.s0.w.d.l0.k.w.k.a.a(r4, null, null, 3, null);
                ArrayList r1 = new ArrayList();
                Iterator<T> r6 = r5.iterator();
            L4:
                if (r6.hasNext() == false) goto L8;
                T r2 = r6.next();
                if (kotlin.s0.w.d.l0.k.d.B((kotlin.s0.w.d.l0.c.m) r2) == true) goto L4;
                r1.add(r2);
                goto L4
            L8:
                ArrayList r7 = new ArrayList();
                Iterator<T> r3 = r1.iterator();
            L10:
                if (r3.hasNext() == false) goto L23;
                kotlin.s0.w.d.l0.c.m r8 = (kotlin.s0.w.d.l0.c.m) r3.next();
                if ((r8 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L14;
                kotlin.s0.w.d.l0.c.e r9 = (kotlin.s0.w.d.l0.c.e) r8;
            L15:
                if (r9 == null) goto L17;
                Class<?> r10 = i0.o(r9);
            L18:
                if (r10 == null) goto L20;
                h r11 = new h(r10);
            L21:
                if (r11 == null) goto L10;
                r7.add(r11);
                goto L10
            L20:
                r11 = null;
                goto L21
            L17:
                r10 = null;
                goto L18
            L14:
                r9 = null;
                goto L15
            L23:
                return r7;
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ List<? extends h<? extends Object>> invoke() {
                return a();
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "T", "", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class m extends kotlin.n0.d.q implements kotlin.n0.c.a<T> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ h<T>.a f18574f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ h<T> f18575g;

            m(h<T>.a r1, h<T> r2) {
                this.f18574f = r1;
                this.f18575g = r2;
                super(0);
            }

            @Override // kotlin.n0.c.a
            public final T invoke() {
                kotlin.s0.w.d.l0.c.e r0 = this.f18574f.k();
                if (r0.i() == kotlin.s0.w.d.l0.c.f.f18870k) goto L6;
                return null;
            L6:
                if (r0.x() == true) goto L8;
            L10:
                Class r4 = this.f18575g.e();
                String r1 = "INSTANCE";
            L11:
                T r5 = (T) r4.getDeclaredField(r1).get(null);
                kotlin.n0.d.o.d(r5, "null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.KClassImpl");
                return r5;
            L8:
                if (kotlin.s0.w.d.l0.b.d.a(kotlin.s0.w.d.l0.b.c.f18671a, r0) == true) goto L10;
                r4 = this.f18575g.e().getEnclosingClass();
                r1 = r0.getName().b();
                goto L11
            }
        }

        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class n extends kotlin.n0.d.q implements kotlin.n0.c.a<String> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ h<T> f18576f;

            n(h<T> r1) {
                this.f18576f = r1;
                super(0);
            }

            public final String a() {
                if (this.f18576f.e().isAnonymousClass() == false) goto L5;
                return null;
            L5:
                kotlin.s0.w.d.l0.g.b r2 = h.F(this.f18576f);
                if (r2.k() == false) goto L9;
                return null;
            L9:
                return r2.b().b();
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ String invoke() {
                return a();
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00030\u0002 \u0004*\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00030\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "kotlin.jvm.PlatformType", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class o extends kotlin.n0.d.q implements kotlin.n0.c.a<List<? extends h<? extends T>>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ h<T>.a f18577f;

            o(h<T>.a r1) {
                this.f18577f = r1;
                super(0);
            }

            public final List<h<? extends T>> a() {
                Collection<kotlin.s0.w.d.l0.c.e> r3 = this.f18577f.k().H();
                kotlin.n0.d.o.e(r3, "descriptor.sealedSubclasses");
                ArrayList r0 = new ArrayList();
                Iterator<T> r4 = r3.iterator();
            L4:
                if (r4.hasNext() == false) goto L11;
                kotlin.s0.w.d.l0.c.e r1 = (kotlin.s0.w.d.l0.c.e) r4.next();
                kotlin.n0.d.o.d(r1, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                Class<?> r2 = i0.o(r1);
                if (r2 == null) goto L8;
                h r5 = new h(r2);
            L9:
                if (r5 == null) goto L4;
                r0.add(r5);
                goto L4
            L8:
                r5 = null;
                goto L9
            L11:
                return r0;
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ Object invoke() {
                return a();
            }
        }

        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class p extends kotlin.n0.d.q implements kotlin.n0.c.a<String> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ h<T> f18578f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ h<T>.a f18579g;

            p(h<T> r1, h<T>.a r2) {
                this.f18578f = r1;
                this.f18579g = r2;
                super(0);
            }

            public final String a() {
                if (this.f18578f.e().isAnonymousClass() == false) goto L6;
                return null;
            L6:
                kotlin.s0.w.d.l0.g.b r0 = h.F(this.f18578f);
                if (r0.k() == true) goto L11;
                String r2 = r0.j().b();
                kotlin.n0.d.o.e(r2, "classId.shortClassName.asString()");
                return r2;
            L11:
                return a.b(this.f18579g, this.f18578f.e());
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ String invoke() {
                return a();
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "kotlin.jvm.PlatformType", "T", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class q extends kotlin.n0.d.q implements kotlin.n0.c.a<List<? extends x>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ h<T>.a f18580f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ h<T> f18581g;

            /* JADX INFO: renamed from: kotlin.s0.w.d.h$a$q$a, reason: collision with other inner class name */
            @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Type;", "T", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
            static final class C0486a extends kotlin.n0.d.q implements kotlin.n0.c.a<Type> {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ kotlin.s0.w.d.l0.n.e0 f18582f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ h<T>.a f18583g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                final /* synthetic */ h<T> f18584h;

                C0486a(kotlin.s0.w.d.l0.n.e0 r1, h<T>.a r2, h<T> r3) {
                    this.f18582f = r1;
                    this.f18583g = r2;
                    this.f18584h = r3;
                    super(0);
                }

                public final Type a() {
                    kotlin.s0.w.d.l0.c.h r0 = this.f18582f.O0().d();
                    if ((r0 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L19;
                    Class<?> r1 = i0.o((kotlin.s0.w.d.l0.c.e) r0);
                    if (r1 == null) goto L17;
                    if (kotlin.n0.d.o.a(this.f18584h.e().getSuperclass(), r1) == false) goto L10;
                    Type r4 = this.f18584h.e().getGenericSuperclass();
                    String r2 = "{\n                      …ass\n                    }";
                L9:
                    kotlin.n0.d.o.e(r4, r2);
                    return r4;
                L10:
                    Class<?>[] r3 = this.f18584h.e().getInterfaces();
                    kotlin.n0.d.o.e(r3, "jClass.interfaces");
                    int r5 = kotlin.i0.i.D(r3, r1);
                    if (r5 < 0) goto L15;
                    r4 = this.f18584h.e().getGenericInterfaces()[r5];
                    r2 = "{\n                      …ex]\n                    }";
                    goto L9
                L15:
                    throw new a0("No superclass of " + this.f18583g + " in Java reflection for " + r0);
                L17:
                    throw new a0("Unsupported superclass of " + this.f18583g + ": " + r0);
                L19:
                    throw new a0("Supertype not a class: " + r0);
                }

                @Override // kotlin.n0.c.a
                public /* bridge */ /* synthetic */ Type invoke() {
                    return a();
                }
            }

            @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Type;", "T", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
            static final class b extends kotlin.n0.d.q implements kotlin.n0.c.a<Type> {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                public static final b f18585f = null;

                static {
                    f18585f = new b();
                }

                b() {
                    super(0);
                }

                public final Type a() {
                    return Object.class;
                }

                @Override // kotlin.n0.c.a
                public /* bridge */ /* synthetic */ Type invoke() {
                    return a();
                }
            }

            q(h<T>.a r1, h<T> r2) {
                this.f18580f = r1;
                this.f18581g = r2;
                super(0);
            }

            public final List<x> a() {
                Collection<kotlin.s0.w.d.l0.n.e0> r0 = this.f18580f.k().k().a();
                kotlin.n0.d.o.e(r0, "descriptor.typeConstructor.supertypes");
                ArrayList r1 = new ArrayList(r0.size());
                h<T>.a r2 = this.f18580f;
                h<T> r3 = this.f18581g;
                Iterator<T> r4 = r0.iterator();
            L4:
                if (r4.hasNext() == false) goto L7;
                kotlin.s0.w.d.l0.n.e0 r5 = (kotlin.s0.w.d.l0.n.e0) r4.next();
                kotlin.n0.d.o.e(r5, "kotlinType");
                r1.add(new x(r5, new C0486a(r5, r2, r3)));
                goto L4
            L7:
                if (kotlin.s0.w.d.l0.b.h.t0(this.f18580f.k()) == true) goto L25;
                boolean r6 = false;
                if (r1.isEmpty() == false) goto L11;
            L10:
                r6 = true;
            L22:
                if (r6 == false) goto L25;
                m0 r7 = kotlin.s0.w.d.l0.k.t.a.f(this.f18580f.k()).i();
                kotlin.n0.d.o.e(r7, "descriptor.builtIns.anyType");
                r1.add(new x(r7, b.f18585f));
                goto L25
            L11:
                Iterator<T> r8 = r1.iterator();
            L13:
                if (r8.hasNext() == false) goto L10;
                kotlin.s0.w.d.l0.c.f r9 = kotlin.s0.w.d.l0.k.d.e(((x) r8.next()).k()).i();
                kotlin.n0.d.o.e(r9, "getClassDescriptorForType(it.type).kind");
                if (r9 != kotlin.s0.w.d.l0.c.f.f18866g) goto L17;
            L20:
                boolean r10 = true;
            L21:
                if (r10 == true) goto L13;
            L17:
                if (r9 == kotlin.s0.w.d.l0.c.f.f18869j) goto L20;
                r10 = false;
            L25:
                return kotlin.s0.w.d.l0.p.a.c(r1);
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ List<? extends x> invoke() {
                return a();
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "kotlin.jvm.PlatformType", "T", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class r extends kotlin.n0.d.q implements kotlin.n0.c.a<List<? extends y>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ h<T>.a f18586f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ h<T> f18587g;

            r(h<T>.a r1, h<T> r2) {
                this.f18586f = r1;
                this.f18587g = r2;
                super(0);
            }

            public final List<y> a() {
                List<f1> r0 = this.f18586f.k().u();
                kotlin.n0.d.o.e(r0, "descriptor.declaredTypeParameters");
                h<T> r5 = this.f18587g;
                ArrayList r1 = new ArrayList(kotlin.i0.r.q(r0, 10));
                Iterator<T> r2 = r0.iterator();
            L4:
                if (r2.hasNext() == false) goto L6;
                f1 r3 = (f1) r2.next();
                kotlin.n0.d.o.e(r3, "descriptor");
                r1.add(new y(r5, r3));
                goto L4
            L6:
                return r1;
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ List<? extends y> invoke() {
                return a();
            }
        }

        static {
            n = new kotlin.s0.l[]{kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(a.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(a.class), "annotations", "getAnnotations()Ljava/util/List;")), kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(a.class), "simpleName", "getSimpleName()Ljava/lang/String;")), kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(a.class), "qualifiedName", "getQualifiedName()Ljava/lang/String;")), kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(a.class), "constructors", "getConstructors()Ljava/util/Collection;")), kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(a.class), "nestedClasses", "getNestedClasses()Ljava/util/Collection;")), kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(a.class), "objectInstance", "getObjectInstance()Ljava/lang/Object;")), kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(a.class), "typeParameters", "getTypeParameters()Ljava/util/List;")), kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(a.class), "supertypes", "getSupertypes()Ljava/util/List;")), kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(a.class), "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;")), kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(a.class), "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;")), kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(a.class), "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;")), kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(a.class), "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;")), kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(a.class), "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;")), kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(a.class), "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;")), kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(a.class), "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;")), kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(a.class), "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;")), kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(a.class), "allMembers", "getAllMembers()Ljava/util/Collection;"))};
        }

        public a(h r2) {
            this.m = r2;
            super(r2);
            this.f18553d = c0.d(new i(r2));
            c0.d(new d(this));
            this.f18554e = c0.d(new p(r2, this));
            this.f18555f = c0.d(new n(r2));
            c0.d(new e(r2));
            c0.d(new l(this));
            c0.b(new m(this, r2));
            c0.d(new r(this, r2));
            c0.d(new q(this, r2));
            c0.d(new o(this));
            this.f18556g = c0.d(new g(r2));
            this.f18557h = c0.d(new C0485h(r2));
            this.f18558i = c0.d(new j(r2));
            this.f18559j = c0.d(new k(r2));
            this.f18560k = c0.d(new b(this));
            this.f18561l = c0.d(new c(this));
            c0.d(new f(this));
            c0.d(new C0484a(this));
        }

        public static final /* synthetic */ String b(a r0, Class r1) {
            return r0.f(r1);
        }

        public static final /* synthetic */ Collection c(a r0) {
            return r0.j();
        }

        public static final /* synthetic */ Collection d(a r0) {
            return r0.l();
        }

        public static final /* synthetic */ Collection e(a r0) {
            return r0.m();
        }

        private final String f(Class<?> r6) {
            String r5 = r6.getSimpleName();
            Method r0 = r6.getEnclosingMethod();
            if (r0 == null) goto L7;
            kotlin.n0.d.o.e(r5, "name");
            String r7 = r0.getName() + '$';
        L6:
            return kotlin.u0.k.y0(r5, r7, null, 2, null);
        L7:
            Constructor<?> r8 = r6.getEnclosingConstructor();
            kotlin.n0.d.o.e(r5, "name");
            if (r8 == null) goto L11;
            r7 = r8.getName() + '$';
            goto L6
        L11:
            return kotlin.u0.k.x0(r5, '$', null, 2, null);
        }

        private final Collection<kotlin.s0.w.d.f<?>> j() {
            T r3 = this.f18557h.b(this, n[11]);
            kotlin.n0.d.o.e(r3, "<get-declaredStaticMembers>(...)");
            return (Collection) r3;
        }

        private final Collection<kotlin.s0.w.d.f<?>> l() {
            T r3 = this.f18558i.b(this, n[12]);
            kotlin.n0.d.o.e(r3, "<get-inheritedNonStaticMembers>(...)");
            return (Collection) r3;
        }

        private final Collection<kotlin.s0.w.d.f<?>> m() {
            T r3 = this.f18559j.b(this, n[13]);
            kotlin.n0.d.o.e(r3, "<get-inheritedStaticMembers>(...)");
            return (Collection) r3;
        }

        public final Collection<kotlin.s0.w.d.f<?>> g() {
            T r3 = this.f18560k.b(this, n[14]);
            kotlin.n0.d.o.e(r3, "<get-allNonStaticMembers>(...)");
            return (Collection) r3;
        }

        public final Collection<kotlin.s0.w.d.f<?>> h() {
            T r3 = this.f18561l.b(this, n[15]);
            kotlin.n0.d.o.e(r3, "<get-allStaticMembers>(...)");
            return (Collection) r3;
        }

        public final Collection<kotlin.s0.w.d.f<?>> i() {
            T r3 = this.f18556g.b(this, n[10]);
            kotlin.n0.d.o.e(r3, "<get-declaredNonStaticMembers>(...)");
            return (Collection) r3;
        }

        public final kotlin.s0.w.d.l0.c.e k() {
            T r3 = this.f18553d.b(this, n[0]);
            kotlin.n0.d.o.e(r3, "<get-descriptor>(...)");
            return (kotlin.s0.w.d.l0.c.e) r3;
        }

        public final String n() {
            return (String) this.f18555f.b(this, n[3]);
        }

        public final String o() {
            return (String) this.f18554e.b(this, n[2]);
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18588a = null;

        static {
            int[] r0 = new int[kotlin.s0.w.d.l0.e.b.c0.a.EnumC0526a.values().length];
            r0[kotlin.s0.w.d.l0.e.b.c0.a.EnumC0526a.f19735k.ordinal()] = 1;
            r0[kotlin.s0.w.d.l0.e.b.c0.a.EnumC0526a.m.ordinal()] = 2;
            r0[kotlin.s0.w.d.l0.e.b.c0.a.EnumC0526a.n.ordinal()] = 3;
            r0[kotlin.s0.w.d.l0.e.b.c0.a.EnumC0526a.f19736l.ordinal()] = 4;
            r0[kotlin.s0.w.d.l0.e.b.c0.a.EnumC0526a.f19733i.ordinal()] = 5;
            r0[kotlin.s0.w.d.l0.e.b.c0.a.EnumC0526a.f19734j.ordinal()] = 6;
            f18588a = r0;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u001e \u0004*\u000e\u0018\u00010\u0001R\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001R\b\u0012\u0004\u0012\u0002H\u00030\u0002\"\b\b\u0000\u0010\u0003*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "kotlin.jvm.PlatformType", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class c extends kotlin.n0.d.q implements kotlin.n0.c.a<h<T>.a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ h<T> f18589f;

        c(h<T> r1) {
            this.f18589f = r1;
            super(0);
        }

        public final h<T>.a a() {
            return new a(this.f18589f);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Object invoke() {
            return a();
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* synthetic */ class d extends kotlin.n0.d.l implements kotlin.n0.c.p<kotlin.s0.w.d.l0.l.b.w, kotlin.s0.w.d.l0.f.n, u0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final d f18590f = null;

        static {
            f18590f = new d();
        }

        d() {
            super(2);
        }

        @Override // kotlin.n0.d.c, kotlin.s0.c
        public final String getName() {
            return "loadProperty";
        }

        @Override // kotlin.n0.d.c
        public final kotlin.s0.f getOwner() {
            return kotlin.n0.d.e0.b(kotlin.s0.w.d.l0.l.b.w.class);
        }

        @Override // kotlin.n0.d.c
        public final String getSignature() {
            return "loadProperty(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;)Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;";
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ u0 invoke(kotlin.s0.w.d.l0.l.b.w r1, kotlin.s0.w.d.l0.f.n r2) {
            return m(r1, r2);
        }

        public final u0 m(kotlin.s0.w.d.l0.l.b.w r1, kotlin.s0.w.d.l0.f.n r2) {
            kotlin.n0.d.o.f(r1, "p0");
            kotlin.n0.d.o.f(r2, "p1");
            return r1.l(r2);
        }
    }

    public h(Class<T> r2) {
        kotlin.n0.d.o.f(r2, "jClass");
        this.f18551i = r2;
        c0.b<h<T>.a> r3 = c0.b(new c(this));
        kotlin.n0.d.o.e(r3, "lazy { Data() }");
        this.f18552j = r3;
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.g.b F(h r0) {
        return r0.H();
    }

    public static final /* synthetic */ Void G(h r0) {
        r0.M();
        throw null;
    }

    private final kotlin.s0.w.d.l0.g.b H() {
        return f0.f18547a.c(e());
    }

    private final Void M() {
        kotlin.s0.w.d.l0.c.s1.a.f r0 = kotlin.s0.w.d.l0.c.s1.a.f.f19086c.a(e());
        if (r0 == null) goto L7;
        kotlin.s0.w.d.l0.e.b.c0.a r1 = r0.a();
        if (r1 == null) goto L7;
        kotlin.s0.w.d.l0.e.b.c0.a.EnumC0526a r2 = r1.c();
    L8:
        if (r2 != null) goto L10;
        int r3 = -1;
    L11:
        switch(r3) {
            case -1: goto L21;
            case 0: goto L13;
            case 1: goto L19;
            case 2: goto L19;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L21;
            default: goto L13;
        };
    L13:
        throw new kotlin.m();
    L15:
        throw new a0("Unknown class: " + e() + " (kind = " + r2 + ')');
    L17:
        throw new UnsupportedOperationException("This class is an internal synthetic class generated by the Kotlin compiler, such as an anonymous class for a lambda, a SAM wrapper, a callable reference, etc. It's not a Kotlin class or interface, so the reflection library has no idea what declarations it has. Please use Java reflection to inspect this class: " + e());
    L19:
        throw new UnsupportedOperationException("Packages and file facades are not yet supported in Kotlin reflection. Meanwhile please use Java reflection to inspect this class: " + e());
    L21:
        throw new a0("Unresolved class: " + e());
    L10:
        r3 = b.f18588a[r2.ordinal()];
    L7:
        r2 = null;
        goto L8
    }

    public final c0.b<h<T>.a> I() {
        return this.f18552j;
    }

    public kotlin.s0.w.d.l0.c.e J() {
        return this.f18552j.invoke().k();
    }

    public final kotlin.s0.w.d.l0.k.w.h K() {
        return J().s().q();
    }

    public final kotlin.s0.w.d.l0.k.w.h L() {
        kotlin.s0.w.d.l0.k.w.h r1 = J().R();
        kotlin.n0.d.o.e(r1, "descriptor.staticScope");
        return r1;
    }

    @Override // kotlin.s0.d
    public String a() {
        return this.f18552j.invoke().n();
    }

    @Override // kotlin.n0.d.d
    public Class<T> e() {
        return this.f18551i;
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof h) == true) goto L5;
    L7:
        return false;
    L5:
        if (kotlin.n0.d.o.a(kotlin.n0.a.c(this), kotlin.n0.a.c((kotlin.s0.d) r2)) == false) goto L7;
        return true;
    }

    @Override // kotlin.s0.d
    public String h() {
        return this.f18552j.invoke().o();
    }

    public int hashCode() {
        return kotlin.n0.a.c(this).hashCode();
    }

    @Override // kotlin.s0.w.d.i
    public Collection<kotlin.s0.w.d.l0.c.l> t() {
        kotlin.s0.w.d.l0.c.e r2 = J();
        if (r2.i() == kotlin.s0.w.d.l0.c.f.f18866g) goto L10;
        if (r2.i() == kotlin.s0.w.d.l0.c.f.f18870k) goto L10;
        Collection<kotlin.s0.w.d.l0.c.d> r3 = r2.m();
        kotlin.n0.d.o.e(r3, "descriptor.constructors");
        return r3;
    L10:
        return kotlin.i0.r.g();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("class ");
        kotlin.s0.w.d.l0.g.b r8 = H();
        kotlin.s0.w.d.l0.g.c r1 = r8.h();
        kotlin.n0.d.o.e(r1, "classId.packageFqName");
        if (r1.d() == false) goto L5;
        String r2 = "";
    L6:
        String r3 = r8.i().b();
        kotlin.n0.d.o.e(r3, "classId.relativeClassName.asString()");
        r0.append(r2 + kotlin.u0.k.v(r3, '.', '$', false, 4, null));
        return r0.toString();
    L5:
        r2 = r1.b() + '.';
        goto L6
    }

    @Override // kotlin.s0.w.d.i
    public Collection<kotlin.s0.w.d.l0.c.y> u(kotlin.s0.w.d.l0.g.f r3) {
        kotlin.n0.d.o.f(r3, "name");
        kotlin.s0.w.d.l0.k.w.h r0 = K();
        kotlin.s0.w.d.l0.d.b.d r1 = kotlin.s0.w.d.l0.d.b.d.m;
        return kotlin.i0.r.k0(r0.a(r3, r1), L().a(r3, r1));
    }

    @Override // kotlin.s0.w.d.i
    public u0 v(int r10) {
        if (kotlin.n0.d.o.a(e().getSimpleName(), "DefaultImpls") == false) goto L10;
        Class<?> r0 = e().getDeclaringClass();
        if (r0 == null) goto L10;
        if (r0.isInterface() == false) goto L10;
        kotlin.s0.d r9 = kotlin.n0.a.e(r0);
        kotlin.n0.d.o.d(r9, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
        return ((h) r9).v(r10);
    L10:
        kotlin.s0.w.d.l0.c.e r1 = J();
        if ((r1 instanceof kotlin.s0.w.d.l0.l.b.g0.d) == false) goto L13;
        kotlin.s0.w.d.l0.l.b.g0.d r2 = (kotlin.s0.w.d.l0.l.b.g0.d) r1;
    L14:
        if (r2 == null) goto L19;
        kotlin.s0.w.d.l0.f.c r3 = r2.c1();
        kotlin.s0.w.d.l0.i.i.f<kotlin.s0.w.d.l0.f.c, List<kotlin.s0.w.d.l0.f.n>> r4 = kotlin.s0.w.d.l0.f.a0.a.f19809j;
        kotlin.n0.d.o.e(r4, "classLocalVariable");
        kotlin.s0.w.d.l0.f.n r5 = (kotlin.s0.w.d.l0.f.n) kotlin.s0.w.d.l0.f.z.e.b(r3, r4, r10);
        if (r5 != null) goto L18;
        return null;
    L18:
        return (u0) i0.g(e(), r5, r2.b1().g(), r2.b1().j(), r2.e1(), d.f18590f);
    L19:
        return null;
    L13:
        r2 = null;
        goto L14
    }

    @Override // kotlin.s0.w.d.i
    public Collection<u0> y(kotlin.s0.w.d.l0.g.f r3) {
        kotlin.n0.d.o.f(r3, "name");
        kotlin.s0.w.d.l0.k.w.h r0 = K();
        kotlin.s0.w.d.l0.d.b.d r1 = kotlin.s0.w.d.l0.d.b.d.m;
        return kotlin.i0.r.k0(r0.c(r3, r1), L().c(r3, r1));
    }
}
