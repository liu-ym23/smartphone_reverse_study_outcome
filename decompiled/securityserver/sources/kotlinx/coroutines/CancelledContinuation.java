package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CancelledContinuation extends CompletedExceptionally {
    public static final AtomicIntegerFieldUpdater c = null;
    private volatile int _resumed;

    static {
        c = AtomicIntegerFieldUpdater.newUpdater(CancelledContinuation.class, "_resumed");
    }

    public CancelledContinuation(Continuation r3, Throwable r4, boolean r5) {
        if (r4 != null) goto L5;
        r4 = new CancellationException("Continuation " + r3 + " was cancelled normally");
    L5:
        super(r4, r5);
        this._resumed = 0;
    }
}
