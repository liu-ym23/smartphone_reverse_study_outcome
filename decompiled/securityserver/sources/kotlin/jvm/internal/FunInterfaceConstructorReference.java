package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.SinceKotlin;
import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
public class FunInterfaceConstructorReference extends FunctionReference implements Serializable {
    @Override // kotlin.jvm.internal.FunctionReference
    public final KFunction e() {
        throw new UnsupportedOperationException("Functional interface constructor does not support reflection");
    }

    @Override // kotlin.jvm.internal.FunctionReference
    public final boolean equals(Object r1) {
        if (this != r1) goto L6;
        return true;
    L6:
        if ((r1 instanceof FunInterfaceConstructorReference) == true) goto L9;
        return false;
    L9:
        ((FunInterfaceConstructorReference) r1).getClass();
        throw null;
    }

    @Override // kotlin.jvm.internal.FunctionReference, kotlin.jvm.internal.CallableReference
    public final /* bridge */ /* synthetic */ KCallable getReflected() {
        e();
        throw null;
    }

    @Override // kotlin.jvm.internal.FunctionReference
    public final int hashCode() {
        throw null;
    }

    @Override // kotlin.jvm.internal.FunctionReference
    public final String toString() {
        throw null;
    }
}
