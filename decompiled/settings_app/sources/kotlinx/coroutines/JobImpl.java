package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0000\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0003R\u0014\u0010\u0006\u001a\u00020\u0007X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/JobImpl;", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/CompletableJob;", "parent", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "handlesException", "", "getHandlesException$kotlinx_coroutines_core", "()Z", "onCancelComplete", "getOnCancelComplete$kotlinx_coroutines_core", "complete", "completeExceptionally", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class JobImpl extends JobSupport implements CompletableJob {
    private final boolean handlesException;

    @Override // kotlinx.coroutines.JobSupport
    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return true;
    }

    public JobImpl(Job r2) {
        super(true);
        initParentJob(r2);
        this.handlesException = handlesException();
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean getHandlesException$kotlinx_coroutines_core() {
        return this.handlesException;
    }

    @Override // kotlinx.coroutines.CompletableJob
    public boolean complete() {
        return makeCompleting$kotlinx_coroutines_core(Unit.INSTANCE);
    }

    @Override // kotlinx.coroutines.CompletableJob
    public boolean completeExceptionally(Throwable r5) {
        return makeCompleting$kotlinx_coroutines_core(new CompletedExceptionally(r5, false, 2, null));
    }

    private final boolean handlesException() {
        ChildHandle r3 = getParentHandle$kotlinx_coroutines_core();
        if ((r3 instanceof ChildHandleNode) == false) goto L5;
        ChildHandleNode r4 = (ChildHandleNode) r3;
    L7:
        if (r4 == null) goto L22;
        JobSupport r5 = r4.getJob();
        if (r5 == null) goto L22;
    L12:
        if (r5.getHandlesException$kotlinx_coroutines_core() == true) goto L13;
        ChildHandle r6 = r5.getParentHandle$kotlinx_coroutines_core();
        if ((r6 instanceof ChildHandleNode) == false) goto L18;
        ChildHandleNode r7 = (ChildHandleNode) r6;
    L19:
        if (r7 == null) goto L22;
        r5 = r7.getJob();
        if (r5 != null) goto L12;
    L18:
        r7 = null;
        goto L19
    L13:
        return true;
    L22:
        return false;
    L5:
        r4 = null;
        goto L7
    }
}
