package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class ResumeAwaitOnCompletion<T> extends JobNode<JobSupport> {
    @Override // kotlinx.coroutines.CompletionHandlerBase
    public final void K(Throwable r2) {
        Object r1 = ((JobSupport) this.f).c0();
        boolean r0 = DebugKt.f370a;
        if ((r1 instanceof CompletedExceptionally) == false) goto L6;
        ResultKt.a(((CompletedExceptionally) r1).f364a);
        throw null;
    L6:
        JobSupportKt.a(r1);
        throw null;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object r1) {
        K((Throwable) r1);
        return Unit.f330a;
    }
}
