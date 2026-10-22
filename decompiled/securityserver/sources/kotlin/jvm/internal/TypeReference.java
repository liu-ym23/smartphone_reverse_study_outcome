package kotlin.jvm.internal;

import a.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KVariance;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
public final class TypeReference implements KType {
    public final KClassifier b;
    public final List c;
    public final KType e;
    public final int f;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public /* synthetic */ class WhenMappings {
        static {
            int[] r0 = new int[KVariance.values().length];
            r0[0] = 1;
            r0[1] = 2;
            r0[2] = 3;
        }
    }

    public TypeReference(ClassReference r2, List r3) {
        Intrinsics.f(r3, "arguments");
        this.b = r2;
        this.c = r3;
        this.e = null;
        this.f = 1;
    }

    public final String a(boolean r10) {
        KClassifier r0 = this.b;
        Class r2 = null;
        if ((r0 instanceof KClass) == false) goto L5;
        KClass r1 = (KClass) r0;
    L6:
        if (r1 == null) goto L8;
        r2 = ((ClassBasedDeclarationContainer) r1).a();
        Intrinsics.d(r2, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
    L8:
        int r3 = this.f;
        if (r2 != null) goto L12;
        String r11 = r0.toString();
    L46:
        String r4 = "";
        if (this.c.isEmpty() == false) goto L49;
        String r5 = "";
    L51:
        if ((r3 & 1) == 0) goto L53;
        r4 = "?";
    L53:
        String r12 = a.B(r11, r5, r4);
        KType r9 = this.e;
        if ((r9 instanceof TypeReference) == false) goto L63;
        String r13 = ((TypeReference) r9).a(true);
        if (Intrinsics.a(r13, r12) == false) goto L59;
        return r12;
    L59:
        if (Intrinsics.a(r13, r12 + '?') == false) goto L62;
        return r12 + '!';
    L62:
        return "(" + r12 + ".." + r13 + ')';
    L63:
        return r12;
    L49:
        r5 = CollectionsKt.i(this.c, ", ", "<", ">", new TypeReference$asString$args$1(this), 24);
        goto L51
    L12:
        if ((r3 & 4) == 0) goto L15;
        r11 = "kotlin.Nothing";
        goto L46
    L15:
        if (r2.isArray() == true) goto L17;
        if (r10 == true) goto L43;
    L45:
        r11 = r2.getName();
        goto L46
    L43:
        if (r2.isPrimitive() == false) goto L45;
        Intrinsics.d(r0, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
        r11 = JvmClassMappingKt.a((KClass) r0).getName();
        goto L46
    L17:
        if (r2.equals(boolean[].class) == false) goto L20;
        r11 = "kotlin.BooleanArray";
        goto L46
    L20:
        if (r2.equals(char[].class) == false) goto L23;
        r11 = "kotlin.CharArray";
        goto L46
    L23:
        if (r2.equals(byte[].class) == false) goto L26;
        r11 = "kotlin.ByteArray";
        goto L46
    L26:
        if (r2.equals(short[].class) == false) goto L29;
        r11 = "kotlin.ShortArray";
        goto L46
    L29:
        if (r2.equals(int[].class) == false) goto L32;
        r11 = "kotlin.IntArray";
        goto L46
    L32:
        if (r2.equals(float[].class) == false) goto L35;
        r11 = "kotlin.FloatArray";
        goto L46
    L35:
        if (r2.equals(long[].class) == false) goto L38;
        r11 = "kotlin.LongArray";
        goto L46
    L38:
        if (r2.equals(double[].class) == false) goto L40;
        r11 = "kotlin.DoubleArray";
        goto L46
    L40:
        r11 = "kotlin.Array";
        goto L46
    L5:
        r1 = null;
        goto L6
    }

    @Override // kotlin.reflect.KType
    public final List c() {
        return this.c;
    }

    @Override // kotlin.reflect.KType
    public final KClassifier d() {
        return this.b;
    }

    public final boolean equals(Object r3) {
        if ((r3 instanceof TypeReference) == false) goto L13;
        TypeReference r4 = (TypeReference) r3;
        KClassifier r0 = r4.b;
        if (Intrinsics.a(this.b, r0) == false) goto L13;
        List r1 = r4.c;
        if (Intrinsics.a(this.c, r1) == false) goto L13;
        if (Intrinsics.a(this.e, r4.e) == false) goto L13;
        if (this.f != r4.f) goto L13;
        return true;
    L13:
        return false;
    }

    public final int hashCode() {
        int r0 = this.b.hashCode() * 31;
        int r1 = (this.c.hashCode() + r0) * 31;
        return Integer.valueOf(this.f).hashCode() + r1;
    }

    public final String toString() {
        return a(false) + " (Kotlin reflection is not available)";
    }
}
