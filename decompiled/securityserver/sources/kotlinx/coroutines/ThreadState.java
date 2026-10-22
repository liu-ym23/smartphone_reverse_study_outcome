package kotlinx.coroutines;

import a.a;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class ThreadState implements Function1<Throwable, Unit> {
    public static final AtomicIntegerFieldUpdater b = null;
    private volatile int _state;

    static {
        b = AtomicIntegerFieldUpdater.newUpdater(ThreadState.class, "_state");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r3) {
        Throwable r4 = (Throwable) r3;
    L3:
        int r5 = this._state;
        if (r5 != 0) goto L6;
        if (b.compareAndSet(this, r5, 2) == false) goto L3;
        throw null;
    L6:
        if (r5 == 1) goto L13;
        if (r5 == 2) goto L13;
        if (r5 == 3) goto L13;
        throw new IllegalStateException(a.e(r5, "Illegal state ").toString());
    L13:
        return Unit.f330a;
    }
}
