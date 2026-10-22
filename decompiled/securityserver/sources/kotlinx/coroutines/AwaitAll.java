package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class AwaitAll<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f360a = null;
    volatile int notCompletedCount;

    @Metadata
    public final class AwaitAllNode extends JobNode<Job> {
        private volatile Object _disposer;

        @Override // kotlinx.coroutines.CompletionHandlerBase
        public final void K(Throwable r1) {
            if (r1 != null) goto L9;
            if (AwaitAll.f360a.decrementAndGet(null) == 0) goto L7;
            return;
        L7:
            throw null;
        L9:
            throw null;
        }

        @Override // kotlin.jvm.functions.Function1
        public final /* bridge */ /* synthetic */ Object invoke(Object r1) {
            K((Throwable) r1);
            return Unit.f330a;
        }
    }

    @Metadata
    public final class DisposeHandlersOnCancel extends CancelHandler {
        @Override // kotlinx.coroutines.CancelHandlerBase
        public final void c(Throwable r1) {
            d();
        }

        public final void d() {
            throw null;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object r1) {
            Throwable r2 = (Throwable) r1;
            d();
            return Unit.f330a;
        }

        public final String toString() {
            return "DisposeHandlersOnCancel[null]";
        }
    }

    static {
        f360a = AtomicIntegerFieldUpdater.newUpdater(AwaitAll.class, "notCompletedCount");
    }
}
