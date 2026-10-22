package kotlin.reflect;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@ExperimentalStdlibApi
final class WildcardTypeImpl implements WildcardType, TypeImpl {
    public static final WildcardTypeImpl e = null;
    public final Type b;
    public final Type c;

    @Metadata
    public static final class Companion {
    }

    static {
        e = new WildcardTypeImpl(null, null);
    }

    public WildcardTypeImpl(Type r1, Type r2) {
        this.b = r1;
        this.c = r2;
    }

    public final boolean equals(Object r3) {
        if ((r3 instanceof WildcardType) == false) goto L9;
        WildcardType r4 = (WildcardType) r3;
        if (Arrays.equals(getUpperBounds(), r4.getUpperBounds()) == false) goto L9;
        if (Arrays.equals(getLowerBounds(), r4.getLowerBounds()) == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getLowerBounds() {
        Type r2 = this.c;
        if (r2 != null) goto L6;
        return new Type[0];
    L6:
        return new Type[]{r2};
    }

    @Override // java.lang.reflect.Type
    public final String getTypeName() {
        Type r0 = this.c;
        if (r0 != null) goto L12;
        Type r2 = this.b;
        if (r2 != null) goto L8;
    L10:
        return "?";
    L8:
        if (Intrinsics.a(r2, Object.class) == true) goto L10;
        return "? extends " + TypesJVMKt.a(r2);
    L12:
        return "? super " + TypesJVMKt.a(r0);
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getUpperBounds() {
        Type r2 = this.b;
        if (r2 != null) goto L6;
        r2 = Object.class;
    L6:
        return new Type[]{r2};
    }

    public final int hashCode() {
        int r0 = Arrays.hashCode(getUpperBounds());
        return Arrays.hashCode(getLowerBounds()) ^ r0;
    }

    public final String toString() {
        return getTypeName();
    }
}
