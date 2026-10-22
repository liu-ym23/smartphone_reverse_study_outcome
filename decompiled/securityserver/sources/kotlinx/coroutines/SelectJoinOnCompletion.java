package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class SelectJoinOnCompletion<R> extends JobNode<JobSupport> {
    @Override // kotlinx.coroutines.CompletionHandlerBase
    public final void K(Throwable r1) {
        throw null;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object r1) {
        K((Throwable) r1);
        return Unit.f330a;
    }
}
