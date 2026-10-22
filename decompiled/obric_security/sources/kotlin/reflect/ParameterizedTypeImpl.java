package kotlin.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TypesJVM.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\u0010\tJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0016¢\u0006\u0002\u0010\u0011J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0019"}, d2 = {"Lkotlin/reflect/ParameterizedTypeImpl;", "Ljava/lang/reflect/ParameterizedType;", "Lkotlin/reflect/TypeImpl;", "rawType", "Ljava/lang/Class;", "ownerType", "Ljava/lang/reflect/Type;", "typeArguments", "", "(Ljava/lang/Class;Ljava/lang/reflect/Type;Ljava/util/List;)V", "", "[Ljava/lang/reflect/Type;", "equals", "", "other", "", "getActualTypeArguments", "()[Ljava/lang/reflect/Type;", "getOwnerType", "getRawType", "getTypeName", "", "hashCode", "", "toString", "kotlin-stdlib"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ParameterizedTypeImpl implements ParameterizedType, TypeImpl {
    private final Type ownerType;
    private final Class<?> rawType;
    private final Type[] typeArguments;

    public ParameterizedTypeImpl(Class<?> r2, Type r3, List<? extends Type> r4) {
        Intrinsics.checkNotNullParameter(r2, "rawType");
        Intrinsics.checkNotNullParameter(r4, "typeArguments");
        this.rawType = r2;
        this.ownerType = r3;
        this.typeArguments = (Type[]) r4.toArray(new Type[0]);
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.rawType;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.ownerType;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return this.typeArguments;
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.TypeImpl
    public String getTypeName() {
        StringBuilder r0 = new StringBuilder();
        Type r1 = this.ownerType;
        if (r1 == null) goto L5;
        r0.append(TypesJVMKt.access$typeToString(r1));
        r0.append("$");
        r0.append(this.rawType.getSimpleName());
    L6:
        Type[] r2 = this.typeArguments;
        if (r2.length != 0) goto L9;
        boolean r12 = true;
    L11:
        if ((!r12) == false) goto L13;
        ArraysKt.joinTo$default(r2, r0, null, "<", ">", 0, null, ParameterizedTypeImpl$getTypeName$1$1.INSTANCE, 50, null);
    L13:
        String r13 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r13, "StringBuilder().apply(builderAction).toString()");
        return r13;
    L9:
        r12 = false;
        goto L11
    L5:
        r0.append(TypesJVMKt.access$typeToString(this.rawType));
        goto L6
    }

    public boolean equals(Object r3) {
        if ((r3 instanceof ParameterizedType) == false) goto L11;
        ParameterizedType r4 = (ParameterizedType) r3;
        if (Intrinsics.areEqual(this.rawType, r4.getRawType()) == false) goto L11;
        if (Intrinsics.areEqual(this.ownerType, r4.getOwnerType()) == false) goto L11;
        if (Arrays.equals(getActualTypeArguments(), r4.getActualTypeArguments()) == false) goto L11;
        return true;
    L11:
        return false;
    }

    public int hashCode() {
        int r0 = this.rawType.hashCode();
        Type r1 = this.ownerType;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L6:
        int r3 = Arrays.hashCode(getActualTypeArguments());
        return r3 ^ (r0 ^ r2);
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return getTypeName();
    }
}
