package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.ReflectionFactory;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
public abstract class RestrictedSuspendLambda extends RestrictedContinuationImpl implements FunctionBase<Object>, SuspendFunction {
    @Override // kotlin.jvm.internal.FunctionBase
    public final int getArity() {
        return 0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final String toString() {
        if (this.b != null) goto L6;
        Reflection.f343a.getClass();
        String r1 = ReflectionFactory.a(this);
        Intrinsics.e(r1, "renderLambdaToString(this)");
        return r1;
    L6:
        return super.toString();
    }
}
