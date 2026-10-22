package kotlin.s0.w.d;

import com.bytedance.common.wschannel.WsConstants;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.i0.m0;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.x0;
import kotlin.s0.w.d.l0.n.g1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000Ê\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001al\u0010\u0011\u001a\u0002H\u0012\"\b\b\u0000\u0010\u0013*\u00020\u0014\"\b\b\u0001\u0010\u0012*\u00020\u00062\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00162\u0006\u0010\u0017\u001a\u0002H\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u001d\u0010\u001e\u001a\u0019\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00120\u001f¢\u0006\u0002\b!H\u0000¢\u0006\u0002\u0010\"\u001a.\u0010#\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00162\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020*H\u0002\u001a(\u0010#\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00162\u0006\u0010$\u001a\u00020%2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010)\u001a\u00020*H\u0002\u001a%\u0010-\u001a\u0002H.\"\u0004\b\u0000\u0010.2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002H.00H\u0080\bø\u0001\u0000¢\u0006\u0002\u00101\u001a\u0016\u00102\u001a\u0004\u0018\u00010\u000e*\u0002032\u0006\u0010$\u001a\u00020%H\u0002\u001a\u0014\u00104\u001a\b\u0012\u0002\b\u0003\u0018\u000105*\u0004\u0018\u00010\u000eH\u0000\u001a\u0010\u00106\u001a\u0004\u0018\u000107*\u0004\u0018\u00010\u000eH\u0000\u001a\u0014\u00108\u001a\b\u0012\u0002\b\u0003\u0018\u000109*\u0004\u0018\u00010\u000eH\u0000\u001a\u0012\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;*\u00020=H\u0000\u001a\u0014\u0010>\u001a\u0006\u0012\u0002\b\u00030\u0016*\u0006\u0012\u0002\b\u00030\u0016H\u0000\u001a\u000e\u0010?\u001a\u0004\u0018\u00010<*\u00020@H\u0002\u001a\u0012\u0010A\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0016*\u00020BH\u0000\u001a\u000e\u0010C\u001a\u0004\u0018\u00010D*\u00020EH\u0000\u001a\u001a\u0010F\u001a\u0004\u0018\u00010\u000e*\u0006\u0012\u0002\b\u00030G2\u0006\u0010$\u001a\u00020%H\u0002\u001a\u0018\u0010H\u001a\b\u0012\u0004\u0012\u00020<0;*\b\u0012\u0004\u0012\u00020<0;H\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0018\u0010\t\u001a\u00020\n*\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006I"}, d2 = {"JVM_STATIC", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "getJVM_STATIC", "()Lorg/jetbrains/kotlin/name/FqName;", "instanceReceiverParameter", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "getInstanceReceiverParameter", "(Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;)Lorg/jetbrains/kotlin/descriptors/ReceiverParameterDescriptor;", "isInlineClassType", "", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KType;)Z", "defaultPrimitiveValue", "", WsConstants.KEY_CONNECTION_TYPE, "Ljava/lang/reflect/Type;", "deserializeToDescriptor", "D", "M", "Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;", "moduleAnchor", "Ljava/lang/Class;", "proto", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "metadataVersion", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/BinaryVersion;", "createDescriptor", "Lkotlin/Function2;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Class;Lorg/jetbrains/kotlin/protobuf/MessageLite;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;Lorg/jetbrains/kotlin/metadata/deserialization/BinaryVersion;Lkotlin/jvm/functions/Function2;)Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;", "loadClass", "classLoader", "Ljava/lang/ClassLoader;", "packageName", "", "className", "arrayDimensions", "", "kotlinClassId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "reflectionCall", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "arrayToRuntimeValue", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/ArrayValue;", "asKCallableImpl", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "asKFunctionImpl", "Lkotlin/reflect/jvm/internal/KFunctionImpl;", "asKPropertyImpl", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "computeAnnotations", "", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotated;", "createArrayType", "toAnnotationInstance", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptor;", "toJavaClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "toKVisibility", "Lkotlin/reflect/KVisibility;", "Lkotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibility;", "toRuntimeValue", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;", "unwrapRepeatableAnnotations", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final kotlin.s0.w.d.l0.g.c f18604a = null;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18605a = null;

        static {
            int[] r0 = new int[kotlin.s0.w.d.l0.b.i.values().length];
            r0[kotlin.s0.w.d.l0.b.i.f18690k.ordinal()] = 1;
            r0[kotlin.s0.w.d.l0.b.i.f18691l.ordinal()] = 2;
            r0[kotlin.s0.w.d.l0.b.i.m.ordinal()] = 3;
            r0[kotlin.s0.w.d.l0.b.i.n.ordinal()] = 4;
            r0[kotlin.s0.w.d.l0.b.i.o.ordinal()] = 5;
            r0[kotlin.s0.w.d.l0.b.i.p.ordinal()] = 6;
            r0[kotlin.s0.w.d.l0.b.i.q.ordinal()] = 7;
            r0[kotlin.s0.w.d.l0.b.i.r.ordinal()] = 8;
            f18605a = r0;
        }
    }

    static {
        f18604a = new kotlin.s0.w.d.l0.g.c("kotlin.jvm.JvmStatic");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.lang.Class[]] */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r7v16, types: [int[]] */
    /* JADX WARN: Type inference failed for: r7v17, types: [float[]] */
    /* JADX WARN: Type inference failed for: r7v18, types: [long[]] */
    /* JADX WARN: Type inference failed for: r7v20, types: [double[]] */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.Object[]] */
    private static final Object a(kotlin.s0.w.d.l0.k.r.b r6, ClassLoader r7) {
        if ((r6 instanceof kotlin.s0.w.d.l0.l.b.n) == false) goto L5;
        kotlin.s0.w.d.l0.l.b.n r0 = (kotlin.s0.w.d.l0.l.b.n) r6;
    L6:
        if (r0 == null) goto L77;
        kotlin.s0.w.d.l0.n.e0 r1 = r0.c();
        if (r1 == null) goto L77;
        List<? extends kotlin.s0.w.d.l0.k.r.g<?>> r2 = r6.b();
        ArrayList r3 = new ArrayList(kotlin.i0.r.q(r2, 10));
        Iterator<T> r4 = r2.iterator();
    L12:
        if (r4.hasNext() == false) goto L14;
        r3.add(q((kotlin.s0.w.d.l0.k.r.g) r4.next(), r7));
        goto L12
    L14:
        kotlin.s0.w.d.l0.b.i r5 = kotlin.s0.w.d.l0.b.h.N(r1);
        if (r5 != null) goto L17;
        int r8 = -1;
    L18:
        int r9 = 0;
        switch(r8) {
            case -1: goto L47;
            case 0: goto L21;
            case 1: goto L43;
            case 2: goto L40;
            case 3: goto L37;
            case 4: goto L34;
            case 5: goto L31;
            case 6: goto L28;
            case 7: goto L25;
            case 8: goto L22;
            default: goto L21;
        };
    L22:
        int r10 = r6.b().size();
        Object r11 = new double[r10];
    L23:
        if (r9 >= r10) goto L71;
        Object r12 = r3.get(r9);
        kotlin.n0.d.o.d(r12, "null cannot be cast to non-null type kotlin.Double");
        r11[r9] = ((Double) r12).doubleValue();
        r9 = r9 + 1;
    L71:
        return r11;
    L25:
        int r13 = r6.b().size();
        r11 = new long[r13];
    L26:
        if (r9 >= r13) goto L71;
        Object r14 = r3.get(r9);
        kotlin.n0.d.o.d(r14, "null cannot be cast to non-null type kotlin.Long");
        r11[r9] = ((Long) r14).longValue();
        r9 = r9 + 1;
        goto L26
    L28:
        int r15 = r6.b().size();
        r11 = new float[r15];
    L29:
        if (r9 >= r15) goto L71;
        Object r16 = r3.get(r9);
        kotlin.n0.d.o.d(r16, "null cannot be cast to non-null type kotlin.Float");
        r11[r9] = ((Float) r16).floatValue();
        r9 = r9 + 1;
        goto L29
    L31:
        int r17 = r6.b().size();
        r11 = new int[r17];
    L32:
        if (r9 >= r17) goto L71;
        Object r18 = r3.get(r9);
        kotlin.n0.d.o.d(r18, "null cannot be cast to non-null type kotlin.Int");
        r11[r9] = ((Integer) r18).intValue();
        r9 = r9 + 1;
        goto L32
    L34:
        int r19 = r6.b().size();
        r11 = new short[r19];
    L35:
        if (r9 >= r19) goto L71;
        Object r20 = r3.get(r9);
        kotlin.n0.d.o.d(r20, "null cannot be cast to non-null type kotlin.Short");
        r11[r9] = ((Short) r20).shortValue();
        r9 = r9 + 1;
        goto L35
    L37:
        int r21 = r6.b().size();
        r11 = new byte[r21];
    L38:
        if (r9 >= r21) goto L71;
        Object r22 = r3.get(r9);
        kotlin.n0.d.o.d(r22, "null cannot be cast to non-null type kotlin.Byte");
        r11[r9] = ((Byte) r22).byteValue();
        r9 = r9 + 1;
        goto L38
    L40:
        int r23 = r6.b().size();
        r11 = new char[r23];
    L41:
        if (r9 >= r23) goto L71;
        Object r24 = r3.get(r9);
        kotlin.n0.d.o.d(r24, "null cannot be cast to non-null type kotlin.Char");
        r11[r9] = ((Character) r24).charValue();
        r9 = r9 + 1;
        goto L41
    L43:
        int r25 = r6.b().size();
        r11 = new boolean[r25];
    L44:
        if (r9 >= r25) goto L71;
        Object r26 = r3.get(r9);
        kotlin.n0.d.o.d(r26, "null cannot be cast to non-null type kotlin.Boolean");
        r11[r9] = ((Boolean) r26).booleanValue();
        r9 = r9 + 1;
        goto L44
    L21:
        throw new kotlin.m();
    L47:
        if (kotlin.s0.w.d.l0.b.h.c0(r1) == false) goto L76;
        kotlin.s0.w.d.l0.n.e0 r27 = ((g1) kotlin.i0.r.o0(r1.M0())).b();
        kotlin.n0.d.o.e(r27, "type.arguments.single().type");
        kotlin.s0.w.d.l0.c.h r28 = r27.O0().d();
        if ((r28 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L51;
        kotlin.s0.w.d.l0.c.e r29 = (kotlin.s0.w.d.l0.c.e) r28;
    L52:
        if (r29 == null) goto L74;
        if (kotlin.s0.w.d.l0.b.h.u0(r27) == false) goto L59;
        int r30 = r6.b().size();
        r11 = new String[r30];
    L56:
        if (r9 >= r30) goto L71;
        Object r31 = r3.get(r9);
        kotlin.n0.d.o.d(r31, "null cannot be cast to non-null type kotlin.String");
        r11[r9] = (String) r31;
        r9 = r9 + 1;
        goto L56
    L59:
        if (kotlin.s0.w.d.l0.b.h.k0(r29) == false) goto L63;
        int r32 = r6.b().size();
        r11 = new Class[r32];
    L61:
        if (r9 >= r32) goto L71;
        Object r33 = r3.get(r9);
        kotlin.n0.d.o.d(r33, "null cannot be cast to non-null type java.lang.Class<*>");
        r11[r9] = (Class) r33;
        r9 = r9 + 1;
        goto L61
    L63:
        kotlin.s0.w.d.l0.g.b r34 = kotlin.s0.w.d.l0.k.t.a.g(r29);
        if (r34 == null) goto L72;
        Class r35 = m(r7, r34, 0, 4, null);
        if (r35 == null) goto L72;
        Object r36 = Array.newInstance(r35, r6.b().size());
        kotlin.n0.d.o.d(r36, "null cannot be cast to non-null type kotlin.Array<in kotlin.Any?>");
        r11 = (Object[]) r36;
        int r37 = r3.size();
    L69:
        if (r9 >= r37) goto L71;
        r11[r9] = r3.get(r9);
        r9 = r9 + 1;
    L72:
        return null;
    L74:
        throw new IllegalStateException(("Not a class type: " + r27).toString());
    L51:
        r29 = null;
        goto L52
    L76:
        throw new IllegalStateException(("Not an array type: " + r1).toString());
    L17:
        r8 = a.f18605a[r5.ordinal()];
    L77:
        return null;
    L5:
        r0 = null;
        goto L6
    }

    public static final j b(Object r2) {
        if ((r2 instanceof j) == false) goto L5;
        j r0 = (j) r2;
    L6:
        if (r0 != null) goto L18;
        if ((r2 instanceof kotlin.n0.d.l) == false) goto L10;
        kotlin.n0.d.l r3 = (kotlin.n0.d.l) r2;
    L11:
        if (r3 == null) goto L13;
        kotlin.s0.c r4 = r3.compute();
    L15:
        if ((r4 instanceof j) == true) goto L20;
        return null;
    L20:
        return (j) r4;
    L13:
        r4 = null;
        goto L15
    L10:
        r3 = null;
        goto L11
    L18:
        return r0;
    L5:
        r0 = null;
        goto L6
    }

    public static final v<?> c(Object r2) {
        if ((r2 instanceof v) == false) goto L5;
        v<?> r0 = (v) r2;
    L6:
        if (r0 != null) goto L18;
        if ((r2 instanceof kotlin.n0.d.z) == false) goto L10;
        kotlin.n0.d.z r3 = (kotlin.n0.d.z) r2;
    L11:
        if (r3 == null) goto L13;
        kotlin.s0.c r4 = r3.compute();
    L15:
        if ((r4 instanceof v) == true) goto L20;
        return null;
    L20:
        return (v) r4;
    L13:
        r4 = null;
        goto L15
    L10:
        r3 = null;
        goto L11
    L18:
        return r0;
    L5:
        r0 = null;
        goto L6
    }

    public static final List<Annotation> d(kotlin.s0.w.d.l0.c.o1.a r5) {
        kotlin.n0.d.o.f(r5, "<this>");
        kotlin.s0.w.d.l0.c.o1.g r6 = r5.getAnnotations();
        ArrayList r0 = new ArrayList();
        Iterator<kotlin.s0.w.d.l0.c.o1.c> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L20;
        kotlin.s0.w.d.l0.c.o1.c r1 = r7.next();
        a1 r2 = r1.getSource();
        Annotation r4 = null;
        if ((r2 instanceof kotlin.s0.w.d.l0.c.s1.a.b) == false) goto L9;
        r4 = ((kotlin.s0.w.d.l0.c.s1.a.b) r2).d();
    L17:
        if (r4 == null) goto L4;
        r0.add(r4);
        goto L4
    L9:
        if ((r2 instanceof kotlin.s0.w.d.l0.c.s1.a.l.a) == false) goto L16;
        kotlin.s0.w.d.l0.c.s1.b.p r3 = ((kotlin.s0.w.d.l0.c.s1.a.l.a) r2).d();
        if ((r3 instanceof kotlin.s0.w.d.l0.c.s1.b.e) == false) goto L13;
        kotlin.s0.w.d.l0.c.s1.b.e r8 = (kotlin.s0.w.d.l0.c.s1.b.e) r3;
    L14:
        if (r8 == null) goto L17;
        r4 = r8.R();
        goto L17
    L13:
        r8 = null;
        goto L14
    L16:
        r4 = n(r1);
        goto L17
    L20:
        return r(r0);
    }

    public static final Class<?> e(Class<?> r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        return Array.newInstance(r1, 0).getClass();
    }

    public static final Object f(Type r3) {
        kotlin.n0.d.o.f(r3, WsConstants.KEY_CONNECTION_TYPE);
        if ((r3 instanceof Class) == true) goto L5;
    L36:
        return null;
    L5:
        if (((Class) r3).isPrimitive() == false) goto L36;
        if (kotlin.n0.d.o.a(r3, Boolean.TYPE) == false) goto L10;
        return Boolean.FALSE;
    L10:
        if (kotlin.n0.d.o.a(r3, Character.TYPE) == false) goto L13;
        return (char) 0;
    L13:
        if (kotlin.n0.d.o.a(r3, Byte.TYPE) == false) goto L16;
        return (byte) 0;
    L16:
        if (kotlin.n0.d.o.a(r3, Short.TYPE) == false) goto L19;
        return (short) 0;
    L19:
        if (kotlin.n0.d.o.a(r3, Integer.TYPE) == false) goto L22;
        return 0;
    L22:
        if (kotlin.n0.d.o.a(r3, Float.TYPE) == false) goto L25;
        return Float.valueOf(0.0f);
    L25:
        if (kotlin.n0.d.o.a(r3, Long.TYPE) == false) goto L28;
        return 0L;
    L28:
        if (kotlin.n0.d.o.a(r3, Double.TYPE) == false) goto L31;
        return Double.valueOf(0.0d);
    L31:
        if (kotlin.n0.d.o.a(r3, Void.TYPE) == false) goto L35;
        throw new IllegalStateException("Parameter with void type is illegal");
    L35:
        throw new UnsupportedOperationException("Unknown primitive: " + r3);
    }

    public static final <M extends kotlin.s0.w.d.l0.i.q, D extends kotlin.s0.w.d.l0.c.a> D g(Class<?> r14, M r15, kotlin.s0.w.d.l0.f.z.c r16, kotlin.s0.w.d.l0.f.z.g r17, kotlin.s0.w.d.l0.f.z.a r18, kotlin.n0.c.p<? super kotlin.s0.w.d.l0.l.b.w, ? super M, ? extends D> r19) {
        kotlin.n0.d.o.f(r14, "moduleAnchor");
        kotlin.n0.d.o.f(r15, "proto");
        kotlin.n0.d.o.f(r16, "nameResolver");
        kotlin.n0.d.o.f(r17, "typeTable");
        kotlin.n0.d.o.f(r18, "metadataVersion");
        kotlin.n0.d.o.f(r19, "createDescriptor");
        kotlin.s0.w.d.l0.c.s1.a.k r2 = b0.a(r14);
        if ((r15 instanceof kotlin.s0.w.d.l0.f.i) == false) goto L7;
        List<kotlin.s0.w.d.l0.f.s> r3 = ((kotlin.s0.w.d.l0.f.i) r15).l0();
    L5:
        List<kotlin.s0.w.d.l0.f.s> r12 = r3;
        kotlin.s0.w.d.l0.l.b.k r4 = r2.a();
        kotlin.s0.w.d.l0.c.h0 r6 = r2.b();
        kotlin.s0.w.d.l0.f.z.h r8 = kotlin.s0.w.d.l0.f.z.h.f20249b.b();
        kotlin.n0.d.o.e(r12, "typeParameters");
        return r19.invoke(new kotlin.s0.w.d.l0.l.b.w(new kotlin.s0.w.d.l0.l.b.m(r4, r16, r6, r17, r8, r18, null, null, r12)), r15);
    L7:
        if ((r15 instanceof kotlin.s0.w.d.l0.f.n) == false) goto L12;
        r3 = ((kotlin.s0.w.d.l0.f.n) r15).m0();
        goto L5
    L12:
        throw new IllegalStateException(("Unsupported message: " + r15).toString());
    }

    public static final x0 h(kotlin.s0.w.d.l0.c.a r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        if (r1.f0() == null) goto L5;
        kotlin.s0.w.d.l0.c.m r2 = r1.c();
        kotlin.n0.d.o.d(r2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        return ((kotlin.s0.w.d.l0.c.e) r2).K0();
    L5:
        return null;
    }

    public static final kotlin.s0.w.d.l0.g.c i() {
        return f18604a;
    }

    public static final boolean j(kotlin.s0.m r2) {
        kotlin.n0.d.o.f(r2, "<this>");
        if ((r2 instanceof x) == false) goto L5;
        x r3 = (x) r2;
    L7:
        if (r3 == null) goto L14;
        kotlin.s0.w.d.l0.n.e0 r4 = r3.k();
        if (r4 == null) goto L14;
        if (kotlin.s0.w.d.l0.k.f.c(r4) != true) goto L14;
        return true;
    L14:
        return false;
    L5:
        r3 = null;
        goto L7
    }

    private static final Class<?> k(ClassLoader r7, String r8, String r9, int r10) {
        if (kotlin.n0.d.o.a(r8, "kotlin") == true) goto L5;
    L52:
        String r11 = r8 + '.' + kotlin.u0.k.v(r9, '.', '$', false, 4, null);
        if (r10 <= 0) goto L56;
        r11 = kotlin.u0.k.s("[", r10) + 'L' + r11 + ';';
    L56:
        return kotlin.s0.w.d.l0.c.s1.a.e.a(r7, r11);
    L5:
        switch(r9.hashCode()) {
            case -901856463: goto L48;
            case -763279523: goto L43;
            case -755911549: goto L38;
            case -74930671: goto L33;
            case 22374632: goto L28;
            case 63537721: goto L23;
            case 601811914: goto L18;
            case 948852093: goto L13;
            case 2104330525: goto L8;
            default: goto L52;
        };
    L8:
        if (r9.equals("LongArray") == false) goto L52;
        return long[].class;
    L13:
        if (r9.equals("FloatArray") == false) goto L52;
        return float[].class;
    L18:
        if (r9.equals("IntArray") == false) goto L52;
        return int[].class;
    L23:
        if (r9.equals("Array") == false) goto L52;
        return Object[].class;
    L28:
        if (r9.equals("DoubleArray") == false) goto L52;
        return double[].class;
    L33:
        if (r9.equals("ByteArray") == false) goto L52;
        return byte[].class;
    L38:
        if (r9.equals("CharArray") == false) goto L52;
        return char[].class;
    L43:
        if (r9.equals("ShortArray") == false) goto L52;
        return short[].class;
    L48:
        if (r9.equals("BooleanArray") == false) goto L52;
        return boolean[].class;
    }

    private static final Class<?> l(ClassLoader r3, kotlin.s0.w.d.l0.g.b r4, int r5) {
        kotlin.s0.w.d.l0.b.q.c r0 = kotlin.s0.w.d.l0.b.q.c.f18771a;
        kotlin.s0.w.d.l0.g.d r1 = r4.b().j();
        kotlin.n0.d.o.e(r1, "kotlinClassId.asSingleFqName().toUnsafe()");
        kotlin.s0.w.d.l0.g.b r2 = r0.n(r1);
        if (r2 == null) goto L6;
        r4 = r2;
    L6:
        String r6 = r4.h().b();
        kotlin.n0.d.o.e(r6, "javaClassId.packageFqName.asString()");
        String r7 = r4.i().b();
        kotlin.n0.d.o.e(r7, "javaClassId.relativeClassName.asString()");
        return k(r3, r6, r7, r5);
    }

    static /* synthetic */ Class m(ClassLoader r0, kotlin.s0.w.d.l0.g.b r1, int r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L6;
        r2 = 0;
    L6:
        return l(r0, r1, r2);
    }

    private static final Annotation n(kotlin.s0.w.d.l0.c.o1.c r7) {
        kotlin.s0.w.d.l0.c.e r0 = kotlin.s0.w.d.l0.k.t.a.e(r7);
        if (r0 == null) goto L5;
        Class<?> r1 = o(r0);
    L7:
        if ((r1 instanceof Class) == true) goto L10;
        r1 = null;
    L10:
        if (r1 != null) goto L12;
        return null;
    L12:
        Set<Map.Entry<kotlin.s0.w.d.l0.g.f, kotlin.s0.w.d.l0.k.r.g<?>>> r8 = r7.a().entrySet();
        ArrayList r2 = new ArrayList();
        Iterator<T> r9 = r8.iterator();
    L14:
        if (r9.hasNext() == false) goto L22;
        Map.Entry r3 = (Map.Entry) r9.next();
        kotlin.s0.w.d.l0.g.f r4 = (kotlin.s0.w.d.l0.g.f) r3.getKey();
        kotlin.s0.w.d.l0.k.r.g r5 = (kotlin.s0.w.d.l0.k.r.g) r3.getValue();
        ClassLoader r6 = r1.getClassLoader();
        kotlin.n0.d.o.e(r6, "annotationClass.classLoader");
        Object r10 = q(r5, r6);
        if (r10 == null) goto L18;
        kotlin.u r11 = kotlin.a0.a(r4.b(), r10);
    L19:
        if (r11 == null) goto L14;
        r2.add(r11);
        goto L14
    L18:
        r11 = null;
        goto L19
    L22:
        return (Annotation) kotlin.s0.w.d.k0.b.g(r1, m0.q(r2), null, 4, null);
    L5:
        r1 = null;
        goto L7
    }

    public static final Class<?> o(kotlin.s0.w.d.l0.c.e r2) {
        kotlin.n0.d.o.f(r2, "<this>");
        a1 r0 = r2.getSource();
        kotlin.n0.d.o.e(r0, "source");
        if ((r0 instanceof kotlin.s0.w.d.l0.e.b.s) == false) goto L6;
        kotlin.s0.w.d.l0.e.b.q r3 = ((kotlin.s0.w.d.l0.e.b.s) r0).d();
        kotlin.n0.d.o.d(r3, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.components.ReflectKotlinClass");
        return ((kotlin.s0.w.d.l0.c.s1.a.f) r3).d();
    L6:
        if ((r0 instanceof kotlin.s0.w.d.l0.c.s1.a.l.a) == false) goto L8;
        kotlin.s0.w.d.l0.c.s1.b.p r4 = ((kotlin.s0.w.d.l0.c.s1.a.l.a) r0).d();
        kotlin.n0.d.o.d(r4, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.structure.ReflectJavaClass");
        return ((kotlin.s0.w.d.l0.c.s1.b.l) r4).V();
    L8:
        kotlin.s0.w.d.l0.g.b r1 = kotlin.s0.w.d.l0.k.t.a.g(r2);
        if (r1 != null) goto L13;
        return null;
    L13:
        return l(kotlin.s0.w.d.l0.c.s1.b.d.e(r2.getClass()), r1, 0);
    }

    public static final kotlin.s0.q p(kotlin.s0.w.d.l0.c.u r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        if (kotlin.n0.d.o.a(r1, kotlin.s0.w.d.l0.c.t.f19163e) == false) goto L6;
        return kotlin.s0.q.f18483f;
    L6:
        if (kotlin.n0.d.o.a(r1, kotlin.s0.w.d.l0.c.t.f19161c) == false) goto L9;
        return kotlin.s0.q.f18484g;
    L9:
        if (kotlin.n0.d.o.a(r1, kotlin.s0.w.d.l0.c.t.f19162d) == false) goto L12;
        return kotlin.s0.q.f18485h;
    L12:
        if (kotlin.n0.d.o.a(r1, kotlin.s0.w.d.l0.c.t.f19159a) == false) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == true) goto L22;
        return null;
    L22:
        return kotlin.s0.q.f18486i;
    L14:
        r2 = kotlin.n0.d.o.a(r1, kotlin.s0.w.d.l0.c.t.f19160b);
        goto L15
    }

    private static final Object q(kotlin.s0.w.d.l0.k.r.g<?> r4, ClassLoader r5) {
        if ((r4 instanceof kotlin.s0.w.d.l0.k.r.a) == false) goto L6;
        return n(((kotlin.s0.w.d.l0.k.r.a) r4).b());
    L6:
        if ((r4 instanceof kotlin.s0.w.d.l0.k.r.b) == false) goto L9;
        return a((kotlin.s0.w.d.l0.k.r.b) r4, r5);
    L9:
        if ((r4 instanceof kotlin.s0.w.d.l0.k.r.j) == false) goto L14;
        kotlin.u<? extends kotlin.s0.w.d.l0.g.b, ? extends kotlin.s0.w.d.l0.g.f> r6 = ((kotlin.s0.w.d.l0.k.r.j) r4).b();
        kotlin.s0.w.d.l0.g.b r0 = r6.a();
        kotlin.s0.w.d.l0.g.f r7 = r6.b();
        Class r8 = m(r5, r0, 0, 4, null);
        if (r8 != null) goto L39;
        return null;
    L39:
        return h0.a(r8, r7.b());
    L14:
        if ((r4 instanceof kotlin.s0.w.d.l0.k.r.q) == false) goto L29;
        kotlin.s0.w.d.l0.k.r.q.b r9 = ((kotlin.s0.w.d.l0.k.r.q) r4).b();
        if ((r9 instanceof kotlin.s0.w.d.l0.k.r.q.b.C0561b) == false) goto L19;
        kotlin.s0.w.d.l0.k.r.q.b.C0561b r10 = (kotlin.s0.w.d.l0.k.r.q.b.C0561b) r9;
        return l(r5, r10.b(), r10.a());
    L19:
        if ((r9 instanceof kotlin.s0.w.d.l0.k.r.q.b.a) == false) goto L27;
        kotlin.s0.w.d.l0.c.h r11 = ((kotlin.s0.w.d.l0.k.r.q.b.a) r9).a().O0().d();
        if ((r11 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L23;
        kotlin.s0.w.d.l0.c.e r12 = (kotlin.s0.w.d.l0.c.e) r11;
    L24:
        if (r12 != null) goto L42;
        return null;
    L42:
        return o(r12);
    L23:
        r12 = null;
        goto L24
    L27:
        throw new kotlin.m();
    L29:
        if ((r4 instanceof kotlin.s0.w.d.l0.k.r.k) == false) goto L31;
        boolean r13 = true;
    L32:
        if (r13 == false) goto L35;
        return null;
    L35:
        return r4.b();
    L31:
        r13 = r4 instanceof kotlin.s0.w.d.l0.k.r.s;
        goto L32
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final List<Annotation> r(List<? extends Annotation> r7) {
        if ((r7 instanceof Collection) == true) goto L5;
    L7:
        Iterator r0 = r7.iterator();
    L9:
        if (r0.hasNext() == false) goto L6;
        if (kotlin.n0.d.o.a(kotlin.n0.a.b(kotlin.n0.a.a((Annotation) r0.next())).getSimpleName(), "Container") == false) goto L9;
        boolean r1 = true;
    L13:
        if (r1 == false) goto L32;
        ArrayList r2 = new ArrayList();
        Iterator r8 = r7.iterator();
    L16:
        if (r8.hasNext() == false) goto L25;
        Annotation r3 = (Annotation) r8.next();
        Class r4 = kotlin.n0.a.b(kotlin.n0.a.a(r3));
        if (kotlin.n0.d.o.a(r4.getSimpleName(), "Container") == true) goto L20;
    L22:
        List r5 = kotlin.i0.r.d(r3);
    L23:
        kotlin.i0.r.v(r2, r5);
        goto L16
    L20:
        if (r4.getAnnotation(kotlin.n0.d.g0.class) == null) goto L22;
        Object r6 = r4.getDeclaredMethod("value", new Class[0]).invoke(r3, new Object[0]);
        kotlin.n0.d.o.d(r6, "null cannot be cast to non-null type kotlin.Array<out kotlin.Annotation>");
        r5 = kotlin.i0.i.d((Annotation[]) r6);
        goto L23
    L25:
        return r2;
    L32:
        return r7;
    L6:
        r1 = false;
        goto L13
    L5:
        if (r7.isEmpty() == false) goto L7;
        goto L6
    }
}
