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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0014J\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bR\"\u0010\b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/UndispatchedCoroutine;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/internal/ScopeCoroutine;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "threadStateToRecover", "Ljava/lang/ThreadLocal;", "Lkotlin/Pair;", "", "afterResume", "", "state", "clearThreadContext", "", "saveThreadContext", "oldValue", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UndispatchedCoroutine<T> extends ScopeCoroutine<T> {
    private ThreadLocal<Pair<CoroutineContext, Object>> threadStateToRecover;

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

    public final void saveThreadContext(CoroutineContext r1, Object r2) {
        this.threadStateToRecover.set(TuplesKt.to(r1, r2));
    }

    public final boolean clearThreadContext() {
        if (this.threadStateToRecover.get() != null) goto L6;
        return false;
    L6:
        this.threadStateToRecover.set(null);
        return true;
    }

    @Override // kotlinx.coroutines.internal.ScopeCoroutine, kotlinx.coroutines.AbstractCoroutine
    protected void afterResume(Object r6) {
        Pair<CoroutineContext, Object> r0 = this.threadStateToRecover.get();
        UndispatchedCoroutine<?> r1 = null;
        if (r0 == null) goto L5;
        ThreadContextKt.restoreThreadContext(r0.component1(), r0.component2());
        this.threadStateToRecover.set(null);
    L5:
        Object r7 = CompletionStateKt.recoverResult(r6, this.uCont);
        Continuation<T> r2 = this.uCont;
        CoroutineContext r3 = r2.getContext();
        Object r4 = ThreadContextKt.updateThreadContext(r3, null);
        if (r4 == ThreadContextKt.NO_THREAD_ELEMENTS) goto L8;
        r1 = CoroutineContextKt.updateUndispatchedCompletion(r2, r3, r4);
    L21:
        this.uCont.resumeWith(r7);     // Catch: Throwable -> L15
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L15
        if (r1 != null) goto L12;
    L13:
        ThreadContextKt.restoreThreadContext(r3, r4);
        return;
    L12:
        if (r1.clearThreadContext() == true) goto L13;
        return;
    L15:
        th = move-exception;
        if (r1 != null) goto L18;
    L19:
        ThreadContextKt.restoreThreadContext(r3, r4);
    L20:
        throw th;
    L18:
        if (r1.clearThreadContext() == false) goto L20;
    L8:
        UndispatchedCoroutine r8 = (UndispatchedCoroutine) null;
        goto L21
    }
}
