package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CompletionStateKt {
    public static final Object a(Object r1, Continuation r2) {
        if ((r1 instanceof CompletedExceptionally) == false) goto L12;
        Throwable r3 = ((CompletedExceptionally) r1).f364a;
        if (DebugKt.b == false) goto L11;
        if ((r2 instanceof CoroutineStackFrame) == false) goto L11;
        r3 = StackTraceRecoveryKt.a(r3, (CoroutineStackFrame) r2);
    L11:
        return ResultKt.a(r3);
    L12:
        return r1;
    }
}
