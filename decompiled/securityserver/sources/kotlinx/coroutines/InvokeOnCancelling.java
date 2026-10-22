package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class InvokeOnCancelling extends JobCancellingNode<Job> {
    public static final AtomicIntegerFieldUpdater j = null;
    private volatile int _invoked;
    public final Function1 i;

    static {
        j = AtomicIntegerFieldUpdater.newUpdater(InvokeOnCancelling.class, "_invoked");
    }

    public InvokeOnCancelling(Job r1, Function1 r2) {
        super(r1);
        this.i = r2;
        this._invoked = 0;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public final void K(Throwable r4) {
        if (j.compareAndSet(this, 0, 1) == false) goto L6;
        this.i.invoke(r4);
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object r1) {
        K((Throwable) r1);
        return Unit.f330a;
    }
}
