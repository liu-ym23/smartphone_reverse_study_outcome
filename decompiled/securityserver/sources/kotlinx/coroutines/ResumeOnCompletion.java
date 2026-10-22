package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class ResumeOnCompletion extends JobNode<Job> {
    public final Continuation i;

    public ResumeOnCompletion(Job r1, CancellableContinuationImpl r2) {
        super(r1);
        this.i = r2;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public final void K(Throwable r1) {
        Unit r2 = Unit.f330a;
        this.i.k(r2);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object r1) {
        K((Throwable) r1);
        return Unit.f330a;
    }
}
