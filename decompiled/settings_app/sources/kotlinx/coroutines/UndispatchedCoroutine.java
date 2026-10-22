package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: compiled from: CoroutineContext.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0014J\u0006\u0010\u0011\u001a\u00020\tJ\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\rR\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\r0\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/UndispatchedCoroutine;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/internal/ScopeCoroutine;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "threadLocalIsSet", "", "threadStateToRecover", "Ljava/lang/ThreadLocal;", "Lkotlin/Pair;", "", "afterResume", "", "state", "clearThreadContext", "saveThreadContext", "oldValue", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UndispatchedCoroutine<T> extends ScopeCoroutine<T> {
    private volatile boolean threadLocalIsSet;
    private final ThreadLocal<Pair<CoroutineContext, Object>> threadStateToRecover;

    public UndispatchedCoroutine(CoroutineContext r2, Continuation<? super T> r3) {
        if (r2.get(UndispatchedMarker.INSTANCE) != null) goto L5;
        CoroutineContext r0 = r2.plus(UndispatchedMarker.INSTANCE);
    L6:
        super(r0, r3);
        this.threadStateToRecover = new ThreadLocal();
        if ((r3.getContext().get(ContinuationInterceptor.Key) instanceof CoroutineDispatcher) == true) goto L10;
        Object r4 = ThreadContextKt.updateThreadContext(r2, null);
        ThreadContextKt.restoreThreadContext(r2, r4);
        saveThreadContext(r2, r4);
        return;
    L10:
        return;
    L5:
        r0 = r2;
        goto L6
    }

    public final void saveThreadContext(CoroutineContext r2, Object r3) {
        this.threadLocalIsSet = true;
        this.threadStateToRecover.set(TuplesKt.to(r2, r3));
    }

    public final boolean clearThreadContext() {
        if (this.threadLocalIsSet == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        this.threadStateToRecover.remove();
        return !r0;
    L5:
        if (this.threadStateToRecover.get() != null) goto L7;
        r0 = true;
        goto L8
    }

    @Override // kotlinx.coroutines.internal.ScopeCoroutine, kotlinx.coroutines.AbstractCoroutine
    protected void afterResume(Object r6) {
        if (this.threadLocalIsSet == false) goto L8;
        Pair<CoroutineContext, Object> r0 = this.threadStateToRecover.get();
        if (r0 == null) goto L7;
        ThreadContextKt.restoreThreadContext(r0.component1(), r0.component2());
    L7:
        this.threadStateToRecover.remove();
    L8:
        Object r7 = CompletionStateKt.recoverResult(r6, this.uCont);
        Continuation<T> r1 = this.uCont;
        CoroutineContext r2 = r1.getContext();
        UndispatchedCoroutine<?> r3 = null;
        Object r4 = ThreadContextKt.updateThreadContext(r2, null);
        if (r4 == ThreadContextKt.NO_THREAD_ELEMENTS) goto L23;
        r3 = CoroutineContextKt.updateUndispatchedCompletion(r1, r2, r4);
    L23:
        this.uCont.resumeWith(r7);     // Catch: Throwable -> L17
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L17
        if (r3 != null) goto L14;
    L15:
        ThreadContextKt.restoreThreadContext(r2, r4);
        return;
    L14:
        if (r3.clearThreadContext() == true) goto L15;
        return;
    L17:
        th = move-exception;
        if (r3 != null) goto L20;
    L21:
        ThreadContextKt.restoreThreadContext(r2, r4);
    L22:
        throw th;
    L20:
        if (r3.clearThreadContext() == false) goto L22;
        goto L21
    }
}
