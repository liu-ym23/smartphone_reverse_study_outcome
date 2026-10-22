package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class JobNode<J extends Job> extends CompletionHandlerBase implements DisposableHandle, Incomplete {
    public final Job f;

    public JobNode(Job r1) {
        this.f = r1;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode, kotlinx.coroutines.DisposableHandle
    public final void dispose() {
        Job r0 = this.f;
        if (r0 == null) goto L19;
        JobSupport r1 = (JobSupport) r0;
    L5:
        Object r2 = r1.c0();
        if ((r2 instanceof JobNode) == false) goto L13;
        if (r2 != this) goto L26;
        Empty r3 = JobSupportKt.g;
        if (JobSupport.b.compareAndSet(r1, r2, r3) == false) goto L5;
        return;
    L26:
        return;
    L13:
        if ((r2 instanceof Incomplete) == true) goto L15;
        return;
    L15:
        if (((Incomplete) r2).j() == null) goto L25;
        G();
        return;
    L25:
        return;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobSupport");
    }

    @Override // kotlinx.coroutines.Incomplete
    public final boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.Incomplete
    public final NodeList j() {
        return null;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public final String toString() {
        return getClass().getSimpleName() + '@' + DebugStringsKt.a(this) + "[job@" + DebugStringsKt.a(this.f) + ']';
    }
}
