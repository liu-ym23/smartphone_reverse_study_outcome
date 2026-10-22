package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.selects.SelectBuilderImpl;
import kotlinx.coroutines.selects.SelectInstance;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class SelectAwaitOnCompletion<T, R> extends JobNode<JobSupport> {
    public final SelectInstance i;
    public final Function2 j;

    public SelectAwaitOnCompletion(JobSupport r1, SelectInstance r2, Function2 r3) {
        super(r1);
        this.i = r2;
        this.j = r3;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public final void K(Throwable r3) {
        SelectInstance r4 = this.i;
        if (r4.h() == false) goto L9;
        Object r0 = ((JobSupport) this.f).c0();
        if ((r0 instanceof CompletedExceptionally) == false) goto L7;
        r4.p(((CompletedExceptionally) r0).f364a);
        return;
    L7:
        Object r1 = JobSupportKt.a(r0);
        SelectBuilderImpl r5 = r4.n();
        CancellableKt.b(this.j, r1, r5, null);
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object r1) {
        K((Throwable) r1);
        return Unit.f330a;
    }
}
