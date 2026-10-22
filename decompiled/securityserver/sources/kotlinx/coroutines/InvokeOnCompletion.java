package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class InvokeOnCompletion extends JobNode<Job> {
    public final Function1 i;

    public InvokeOnCompletion(Job r1, Function1 r2) {
        super(r1);
        this.i = r2;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public final void K(Throwable r1) {
        this.i.invoke(r1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object r1) {
        K((Throwable) r1);
        return Unit.f330a;
    }
}
