package kotlin.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2 extends ContinuationImpl {
    public int f;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r3) {
        int r0 = this.f;
        if (r0 == 0) goto L9;
        if (r0 != 1) goto L8;
        this.f = 2;
        ResultKt.b(r3);
        return r3;
    L8:
        throw new IllegalStateException("This coroutine had already completed".toString());
    L9:
        this.f = 1;
        ResultKt.b(r3);
        throw null;
    }
}
