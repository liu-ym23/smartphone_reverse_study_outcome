package kotlin.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@ExperimentalStdlibApi
final class ParameterizedTypeImpl implements ParameterizedType, TypeImpl {
    public final Class b;
    public final Type c;
    public final Type[] e;

    public ParameterizedTypeImpl(Class r1, Type r2, ArrayList r3) {
        this.b = r1;
        this.c = r2;
        Object[] r4 = r3.toArray(new Type[0]);
        Intrinsics.d(r4, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        this.e = (Type[]) r4;
    }

    public final boolean equals(Object r3) {
        if ((r3 instanceof ParameterizedType) == false) goto L11;
        ParameterizedType r4 = (ParameterizedType) r3;
        Type r0 = r4.getRawType();
        if (Intrinsics.a(this.b, r0) == false) goto L11;
        if (Intrinsics.a(this.c, r4.getOwnerType()) == false) goto L11;
        Type[] r5 = r4.getActualTypeArguments();
        if (Arrays.equals(this.e, r5) == false) goto L11;
        return true;
    L11:
        return false;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type[] getActualTypeArguments() {
        return this.e;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getOwnerType() {
        return this.c;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getRawType() {
        return this.b;
    }

    @Override // java.lang.reflect.Type
    public final String getTypeName() {
        StringBuilder r0 = new StringBuilder();
        Class r1 = this.b;
        Type r2 = this.c;
        if (r2 == null) goto L5;
        r0.append(TypesJVMKt.a(r2));
        r0.append("$");
        r0.append(r1.getSimpleName());
    L6:
        Type[] r8 = this.e;
        int r3 = 0;
        if (r8.length != 0) goto L9;
        boolean r4 = true;
    L11:
        if ((!r4) == false) goto L19;
        ParameterizedTypeImpl$getTypeName$1$1 r5 = ParameterizedTypeImpl$getTypeName$1$1.e;
        r0.append("<");
        int r6 = r8.length;
        int r7 = 0;
    L13:
        if (r3 >= r6) goto L18;
        Type r9 = r8[r3];
        r7 = r7 + 1;
        if (r7 <= 1) goto L17;
        r0.append(", ");
    L17:
        StringsKt.l(r0, r9, r5);
        r3 = r3 + 1;
        goto L13
    L18:
        r0.append(">");
    L19:
        String r10 = r0.toString();
        Intrinsics.e(r10, "StringBuilder().apply(builderAction).toString()");
        return r10;
    L9:
        r4 = false;
        goto L11
    L5:
        r0.append(TypesJVMKt.a(r1));
        goto L6
    }

    public final int hashCode() {
        int r0 = this.b.hashCode();
        Type r1 = this.c;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L6:
        int r3 = Arrays.hashCode(this.e);
        return r3 ^ (r0 ^ r2);
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return getTypeName();
    }
}
