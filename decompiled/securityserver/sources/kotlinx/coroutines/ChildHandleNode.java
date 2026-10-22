package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ChildHandleNode extends JobCancellingNode<JobSupport> implements ChildHandle {
    public final ChildJob i;

    public ChildHandleNode(JobSupport r1, JobSupport r2) {
        super(r1);
        this.i = r2;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public final void K(Throwable r1) {
        ParentJob r2 = (ParentJob) this.f;
        this.i.t(r2);
    }

    @Override // kotlinx.coroutines.ChildHandle
    public final boolean i(Throwable r1) {
        return ((JobSupport) this.f).S(r1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object r1) {
        K((Throwable) r1);
        return Unit.f330a;
    }
}
