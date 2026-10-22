package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.SinceKotlin;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
public class AdaptedFunctionReference implements FunctionBase, Serializable {
    public final boolean equals(Object r2) {
        if (this != r2) goto L6;
        return true;
    L6:
        if ((r2 instanceof AdaptedFunctionReference) == true) goto L8;
        return false;
    L8:
        ((AdaptedFunctionReference) r2).getClass();
        if (Intrinsics.a(null, null) == true) goto L11;
    L14:
        return false;
    L11:
        if (Intrinsics.a(null, null) == false) goto L14;
        throw null;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public final int getArity() {
        return 0;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        Reflection.f343a.getClass();
        return ReflectionFactory.a(this);
    }
}
