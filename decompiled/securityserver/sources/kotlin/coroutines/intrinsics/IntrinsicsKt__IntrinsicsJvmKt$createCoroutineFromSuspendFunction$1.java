package kotlin.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1 extends RestrictedContinuationImpl {
    public int c;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r3) {
        int r0 = this.c;
        if (r0 == 0) goto L9;
        if (r0 != 1) goto L8;
        this.c = 2;
        ResultKt.b(r3);
        return r3;
    L8:
        throw new IllegalStateException("This coroutine had already completed".toString());
    L9:
        this.c = 1;
        ResultKt.b(r3);
        throw null;
    }
}
