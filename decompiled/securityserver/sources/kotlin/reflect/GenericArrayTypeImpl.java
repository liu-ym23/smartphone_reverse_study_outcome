package kotlin.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@ExperimentalStdlibApi
final class GenericArrayTypeImpl implements GenericArrayType, TypeImpl {
    public final Type b;

    public GenericArrayTypeImpl(Type r2) {
        Intrinsics.f(r2, "elementType");
        this.b = r2;
    }

    public final boolean equals(Object r2) {
        if ((r2 instanceof GenericArrayType) == false) goto L7;
        Type r3 = ((GenericArrayType) r2).getGenericComponentType();
        if (Intrinsics.a(this.b, r3) == false) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // java.lang.reflect.GenericArrayType
    public final Type getGenericComponentType() {
        return this.b;
    }

    @Override // java.lang.reflect.Type
    public final String getTypeName() {
        return TypesJVMKt.a(this.b) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return getTypeName();
    }
}
