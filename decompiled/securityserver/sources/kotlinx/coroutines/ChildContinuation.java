package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.DispatchedContinuation;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ChildContinuation extends JobCancellingNode<Job> {
    public final CancellableContinuationImpl i;

    public ChildContinuation(Job r1, CancellableContinuationImpl r2) {
        super(r1);
        this.i = r2;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public final void K(Throwable r4) {
        CancellableContinuationImpl r5 = this.i;
        Throwable r3 = r5.r(this.f);
        boolean r2 = false;
        if (r5.e != 2) goto L5;
        boolean r0 = true;
    L6:
        Continuation r1 = r5.i;
        if (r0 == true) goto L10;
    L16:
        if (r2 == true) goto L25;
        r5.o(r3);
        if ((r1 instanceof DispatchedContinuation) == true) goto L21;
    L23:
        r5.p();
        return;
    L21:
        if (((DispatchedContinuation) r1).o(r5) == false) goto L23;
        return;
    L25:
        return;
    L10:
        if ((r1 instanceof DispatchedContinuation) == true) goto L12;
        Continuation r6 = null;
    L13:
        DispatchedContinuation r7 = (DispatchedContinuation) r6;
        if (r7 == null) goto L16;
        r2 = r7.p(r3);
        goto L16
    L12:
        r6 = r1;
        goto L13
    L5:
        r0 = false;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object r1) {
        K((Throwable) r1);
        return Unit.f330a;
    }
}
