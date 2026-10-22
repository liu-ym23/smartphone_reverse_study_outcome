package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.TimeoutKt", f = "Timeout.kt", l = {101}, m = "withTimeoutOrNull")
final class TimeoutKt$withTimeoutOrNull$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r3) {
        this.f = r3;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        if (r0 != 0) goto L5;
        ResultKt.b(r3);
        return null;
    L5:
        if (r0 != 1) goto L11;
        ResultKt.b(r3);     // Catch: TimeoutCancellationException -> L8
        return r3;
    L9:
        throw null;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
