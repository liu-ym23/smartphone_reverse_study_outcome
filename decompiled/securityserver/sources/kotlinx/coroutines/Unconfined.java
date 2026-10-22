package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Unconfined extends CoroutineDispatcher {
    public static final /* synthetic */ int e = 0;

    static {
        new Unconfined();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void j(CoroutineContext r1, Runnable r2) {
        YieldContext r0 = (YieldContext) r1.f(YieldContext.e);
        if (r0 == null) goto L7;
        r0.c = true;
        return;
    L7:
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        return "Dispatchers.Unconfined";
    }
}
