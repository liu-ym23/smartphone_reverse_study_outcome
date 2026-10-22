package kotlinx.coroutines.test;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.EventLoop;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
@Metadata
public final class TestCoroutineContext implements CoroutineContext {

    @Metadata
    public final class Dispatcher extends EventLoop implements Delay {
        @Override // kotlinx.coroutines.Delay
        public final void e(long r1, CancellableContinuationImpl r3) {
            throw null;
        }

        @Override // kotlinx.coroutines.Delay
        public final DisposableHandle h(long r1, Runnable r3, CoroutineContext r4) {
            throw null;
        }

        @Override // kotlinx.coroutines.CoroutineDispatcher
        public final void j(CoroutineContext r1, Runnable r2) {
            throw null;
        }

        @Override // kotlinx.coroutines.CoroutineDispatcher
        public final String toString() {
            return "Dispatcher(null)";
        }
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final Object H(Object r1, Function2 r2) {
        return r2.mo7invoke(r2.mo7invoke(r1, null), null);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element f(CoroutineContext.Key r2) {
        if (r2 == ContinuationInterceptor.Key.f336a) goto L11;
        if (r2 == CoroutineExceptionHandler.Key.f368a) goto L9;
        return null;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type E");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type E");
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext i(CoroutineContext r1) {
        return CoroutineContext.DefaultImpls.a(this, r1);
    }

    public final String toString() {
        return "TestCoroutineContext@" + DebugStringsKt.a(this);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext v(CoroutineContext.Key r3) {
        if (r3 != ContinuationInterceptor.Key.f336a) goto L6;
    L8:
        return null;
    L6:
        if (r3 == CoroutineExceptionHandler.Key.f368a) goto L8;
        return this;
    }
}
