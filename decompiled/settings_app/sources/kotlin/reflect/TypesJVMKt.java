package kotlin.reflect;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.KTypeBase;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: TypesJVM.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a\"\u0010\n\u001a\u00020\u00012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0003\u001a\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0001H\u0002\u001a\u0016\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0003\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00078BX\u0083\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\b\u001a\u0004\b\u0005\u0010\t¨\u0006\u0015"}, d2 = {"javaType", "Ljava/lang/reflect/Type;", "Lkotlin/reflect/KType;", "getJavaType$annotations", "(Lkotlin/reflect/KType;)V", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "Lkotlin/reflect/KTypeProjection;", "(Lkotlin/reflect/KTypeProjection;)V", "(Lkotlin/reflect/KTypeProjection;)Ljava/lang/reflect/Type;", "createPossiblyInnerType", "jClass", "Ljava/lang/Class;", "arguments", "", "typeToString", "", "type", "computeJavaType", "forceWrapper", "", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class TypesJVMKt {

    /* JADX INFO: compiled from: TypesJVM.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[KVariance.values().length];
            r0[KVariance.IN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[KVariance.INVARIANT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[KVariance.OUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static final /* synthetic */ Type access$computeJavaType(KType r0, boolean r1) {
        return computeJavaType(r0, r1);
    }

    public static final /* synthetic */ String access$typeToString(Type r0) {
        return typeToString(r0);
    }

    public static /* synthetic */ void getJavaType$annotations(KType r0) {
    }

    private static /* synthetic */ void getJavaType$annotations(KTypeProjection r0) {
    }

    public static final Type getJavaType(KType r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if ((r3 instanceof KTypeBase) == false) goto L8;
        Type r0 = ((KTypeBase) r3).getJavaType();
        if (r0 == null) goto L8;
        return r0;
    L8:
        return computeJavaType$default(r3, false, 1, null);
    }

    static /* synthetic */ Type computeJavaType$default(KType r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return computeJavaType(r0, r1);
    }

    private static final Type computeJavaType(KType r3, boolean r4) {
        KClassifier r0 = r3.getClassifier();
        if ((r0 instanceof KTypeParameter) == false) goto L7;
        return new TypeVariableImpl((KTypeParameter) r0);
    L7:
        if ((r0 instanceof KClass) == false) goto L50;
        KClass r1 = (KClass) r0;
        if (r4 == false) goto L11;
        Class r5 = JvmClassMappingKt.getJavaObjectType(r1);
    L12:
        List<KTypeProjection> r2 = r3.getArguments();
        if (r2.isEmpty() == false) goto L17;
        return r5;
    L17:
        if (r5.isArray() == false) goto L48;
        if (r5.getComponentType().isPrimitive() == true) goto L21;
        KTypeProjection r6 = (KTypeProjection) CollectionsKt.singleOrNull(r2);
        if (r6 == null) goto L46;
        KVariance r7 = r6.component1();
        KType r8 = r6.component2();
        if (r7 != null) goto L27;
        int r9 = -1;
    L28:
        if (r9 == (-1)) goto L44;
        if (r9 == 1) goto L44;
        if (r9 != 2) goto L34;
    L38:
        Intrinsics.checkNotNull(r8);
        Type r10 = computeJavaType$default(r8, false, 1, null);
        Type r11 = r5;
        if ((r10 instanceof Class) == true) goto L51;
        r11 = new GenericArrayTypeImpl(r10);
    L51:
        return r11;
    L34:
        if (r9 == 3) goto L38;
        throw new NoWhenBranchMatchedException();
    L44:
        return r5;
    L27:
        r9 = WhenMappings.$EnumSwitchMapping$0[r7.ordinal()];
        goto L28
    L46:
        throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + r3);
    L21:
        return r5;
    L48:
        return createPossiblyInnerType(r5, r2);
    L11:
        r5 = JvmClassMappingKt.getJavaClass(r1);
        goto L12
    L50:
        throw new UnsupportedOperationException("Unsupported type classifier: " + r3);
    }

    private static final Type createPossiblyInnerType(Class<?> r4, List<KTypeProjection> r5) {
        Class<?> r0 = r4.getDeclaringClass();
        if (r0 != null) goto L11;
        List<KTypeProjection> r6 = r5;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r7 = r6.iterator();
    L6:
        if (r7.hasNext() == false) goto L9;
        r1.add(getJavaType((KTypeProjection) r7.next()));
        goto L6
    L9:
        return new ParameterizedTypeImpl(r4, null, r1);
    L11:
        if (Modifier.isStatic(r4.getModifiers()) == false) goto L18;
        Class<?> r2 = r0;
        List<KTypeProjection> r8 = r5;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r9 = r8.iterator();
    L14:
        if (r9.hasNext() == false) goto L17;
        r3.add(getJavaType((KTypeProjection) r9.next()));
        goto L14
    L17:
        return new ParameterizedTypeImpl(r4, r2, r3);
    L18:
        int r10 = r4.getTypeParameters().length;
        Type r11 = createPossiblyInnerType(r0, r5.subList(r10, r5.size()));
        List<KTypeProjection> r12 = r5.subList(0, r10);
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r14 = r12.iterator();
    L20:
        if (r14.hasNext() == false) goto L23;
        r13.add(getJavaType((KTypeProjection) r14.next()));
        goto L20
    L23:
        return new ParameterizedTypeImpl(r4, r11, r13);
    }

    private static final Type getJavaType(KTypeProjection r4) {
        KVariance r0 = r4.getVariance();
        if (r0 == null) goto L5;
        KType r5 = r4.getType();
        Intrinsics.checkNotNull(r5);
        int r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        if (r1 == 1) goto L17;
        if (r1 == 2) goto L19;
        if (r1 != 3) goto L14;
        return new WildcardTypeImpl(computeJavaType(r5, true), null);
    L14:
        throw new NoWhenBranchMatchedException();
    L19:
        return computeJavaType(r5, true);
    L17:
        return new WildcardTypeImpl(null, computeJavaType(r5, true));
    L5:
        return WildcardTypeImpl.Companion.getSTAR();
    }

    private static final String typeToString(Type r2) {
        if ((r2 instanceof Class) == false) goto L10;
        Class r0 = (Class) r2;
        if (r0.isArray() == false) goto L7;
        Sequence r3 = SequencesKt.generateSequence(r2, TypesJVMKt$typeToString$unwrap$1.INSTANCE);
        String r4 = ((Class) SequencesKt.last(r3)).getName() + StringsKt.repeat(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, SequencesKt.count(r3));
    L8:
        Intrinsics.checkNotNull(r4);
        return r4;
    L7:
        r4 = r0.getName();
        goto L8
    L10:
        return r2.toString();
    }
}
