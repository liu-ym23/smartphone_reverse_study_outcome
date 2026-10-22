package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletedWithCancellation;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ThreadLocalEventLoop;
import kotlinx.coroutines.UndispatchedCoroutine;
import tmsdkobf.b0$$ExternalSyntheticBackport0;

/* JADX INFO: compiled from: DispatchedContinuation.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000O2\u00060?j\u0002`@2\b\u0012\u0004\u0012\u00028\u00000\u0004B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0011\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0010¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001d\u001a\n\u0018\u00010\u001bj\u0004\u0018\u0001`\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010 \u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\u0015\u0010\"\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020\b¢\u0006\u0004\b$\u0010\nJH\u0010+\u001a\u00020\b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000%2%\b\b\u0010*\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b\u0018\u00010'H\u0086\bø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u001a\u0010.\u001a\u00020\u001f2\b\u0010-\u001a\u0004\u0018\u00010\u000bH\u0086\b¢\u0006\u0004\b.\u0010/J!\u00100\u001a\u00020\b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0086\bø\u0001\u0000¢\u0006\u0004\b0\u00101J \u00102\u001a\u00020\b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016ø\u0001\u0000¢\u0006\u0004\b2\u00101J\u0011\u00105\u001a\u0004\u0018\u00010\u000bH\u0010¢\u0006\u0004\b3\u00104J\u000f\u00107\u001a\u000206H\u0016¢\u0006\u0004\b7\u00108J\u001b\u0010:\u001a\u0004\u0018\u00010\r2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u000309¢\u0006\u0004\b:\u0010;R\u001e\u0010<\u001a\u0004\u0018\u00010\u000b8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b<\u0010=\u0012\u0004\b>\u0010\nR\u001c\u0010C\u001a\n\u0018\u00010?j\u0004\u0018\u0001`@8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0014\u0010\u0016\u001a\u00020\u00158\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bD\u0010ER\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010FR\u0014\u0010G\u001a\u00020\u000b8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\bG\u0010=R\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048PX\u0090\u0004¢\u0006\u0006\u001a\u0004\bH\u0010IR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010KR\u001a\u0010M\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bL\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006N"}, d2 = {"Lkotlinx/coroutines/internal/DispatchedContinuation;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lkotlin/coroutines/Continuation;", "continuation", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)V", "", "awaitReusability", "()V", "", "takenState", "", "cause", "cancelCompletedResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelCompletedResult", "Lkotlinx/coroutines/CancellableContinuationImpl;", "claimReusableCancellableContinuation", "()Lkotlinx/coroutines/CancellableContinuationImpl;", "Lkotlin/coroutines/CoroutineContext;", "context", "value", "dispatchYield$kotlinx_coroutines_core", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "dispatchYield", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "", "isReusable", "()Z", "postponeCancellation", "(Ljava/lang/Throwable;)Z", "release", "Lkotlin/Result;", "result", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onCancellation", "resumeCancellableWith", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "state", "resumeCancelled", "(Ljava/lang/Object;)Z", "resumeUndispatchedWith", "(Ljava/lang/Object;)V", "resumeWith", "takeState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "takeState", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/CancellableContinuation;", "tryReleaseClaimedContinuation", "(Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Throwable;", "_state", "Ljava/lang/Object;", "get_state$kotlinx_coroutines_core$annotations", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/Continuation;", "countOrElement", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "delegate", "Lkotlinx/coroutines/CoroutineDispatcher;", "getReusableCancellableContinuation", "reusableCancellableContinuation", "kotlinx-coroutines-core", "Lkotlinx/coroutines/DispatchedTask;"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DispatchedContinuation<T> extends DispatchedTask<T> implements CoroutineStackFrame, Continuation<T> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater _reusableCancellableContinuation$FU = null;
    private volatile /* synthetic */ Object _reusableCancellableContinuation;
    public Object _state;
    public final Continuation<T> continuation;
    public final Object countOrElement;
    public final CoroutineDispatcher dispatcher;

    static {
        _reusableCancellableContinuation$FU = AtomicReferenceFieldUpdater.newUpdater(DispatchedContinuation.class, Object.class, "_reusableCancellableContinuation");
    }

    public static /* synthetic */ void get_state$kotlinx_coroutines_core$annotations() {
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.continuation.getContext();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DispatchedContinuation(CoroutineDispatcher r2, Continuation<? super T> r3) {
        super(-1);
        this.dispatcher = r2;
        this.continuation = r3;
        this._state = DispatchedContinuationKt.access$getUNDEFINED$p();
        this.countOrElement = ThreadContextKt.threadContextElements(getContext());
        this._reusableCancellableContinuation = null;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> r1 = this.continuation;
        if ((r1 instanceof CoroutineStackFrame) == true) goto L7;
        return null;
    L7:
        return (CoroutineStackFrame) r1;
    }

    private final CancellableContinuationImpl<?> getReusableCancellableContinuation() {
        Object r1 = this._reusableCancellableContinuation;
        if ((r1 instanceof CancellableContinuationImpl) == true) goto L7;
        return null;
    L7:
        return (CancellableContinuationImpl) r1;
    }

    public final boolean isReusable() {
        if (this._reusableCancellableContinuation == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void release() {
        awaitReusability();
        CancellableContinuationImpl<?> r0 = getReusableCancellableContinuation();
        if (r0 == null) goto L6;
        r0.detachChild$kotlinx_coroutines_core();
        return;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Object takeState$kotlinx_coroutines_core() {
        Object r0 = this._state;
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L5;
    L12:
        this._state = DispatchedContinuationKt.access$getUNDEFINED$p();
        return r0;
    L5:
        if (r0 == DispatchedContinuationKt.access$getUNDEFINED$p()) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L12;
        throw new AssertionError();
    L7:
        r1 = false;
        goto L8
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Continuation<T> getDelegate$kotlinx_coroutines_core() {
        return this;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object r7) {
        CoroutineContext r0 = this.continuation.getContext();
        Object r3 = CompletionStateKt.toState$default(r7, null, 1, null);
        if (this.dispatcher.isDispatchNeeded(r0) == false) goto L5;
        this._state = r3;
        this.resumeMode = 0;
        this.dispatcher.mo2326dispatch(r0, this);
        return;
    L5:
        DebugKt.getASSERTIONS_ENABLED();
        EventLoop r1 = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (r1.isUnconfinedLoopActive() == false) goto L8;
        this._state = r3;
        this.resumeMode = 0;
        r1.dispatchUnconfined(this);
        return;
    L8:
        DispatchedContinuation<T> r4 = this;
        r1.incrementUseCount(true);
        CoroutineContext r5 = getContext();     // Catch: Throwable -> L18
        Object r6 = ThreadContextKt.updateThreadContext(r5, this.countOrElement);     // Catch: Throwable -> L18
        this.continuation.resumeWith(r7);     // Catch: Throwable -> L15
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L15
        ThreadContextKt.restoreThreadContext(r5, r6);     // Catch: Throwable -> L18
    L13:
        if (r1.processUnconfinedEvent() == true) goto L13;
    L20:
        r1.decrementUseCount(true);
        return;
    L15:
        th = move-exception;
        ThreadContextKt.restoreThreadContext(r5, r6);     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        r4.handleFatalException(th, null);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        r1.decrementUseCount(true);
        throw th;
    }

    public final void resumeCancellableWith(Object r8, Function1<? super Throwable, Unit> r9) {
        Object r10 = CompletionStateKt.toState(r8, r9);
        if (this.dispatcher.isDispatchNeeded(getContext()) == false) goto L5;
        this._state = r10;
        this.resumeMode = 1;
        this.dispatcher.mo2326dispatch(getContext(), this);
        return;
    L5:
        DebugKt.getASSERTIONS_ENABLED();
        EventLoop r0 = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (r0.isUnconfinedLoopActive() == false) goto L8;
        this._state = r10;
        this.resumeMode = 1;
        r0.dispatchUnconfined(this);
        return;
    L8:
        DispatchedContinuation<T> r2 = this;
        r0.incrementUseCount(true);
        Job r4 = (Job) getContext().get(Job.Key);     // Catch: Throwable -> L39
        if (r4 != null) goto L12;
    L14:
        boolean r11 = false;
    L15:
        if (r11 == true) goto L37;
        Continuation<T> r12 = this.continuation;     // Catch: Throwable -> L39
        Object r5 = this.countOrElement;     // Catch: Throwable -> L39
        CoroutineContext r6 = r12.getContext();     // Catch: Throwable -> L39
        Object r7 = ThreadContextKt.updateThreadContext(r6, r5);     // Catch: Throwable -> L39
        if (r7 == ThreadContextKt.NO_THREAD_ELEMENTS) goto L19;
        UndispatchedCoroutine<?> r13 = CoroutineContextKt.updateUndispatchedCompletion(r12, r6, r7);     // Catch: Throwable -> L39
    L50:
        this.continuation.resumeWith(r8);     // Catch: Throwable -> L28
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L28
        InlineMarker.finallyStart(1);     // Catch: Throwable -> L39
        if (r13 != null) goto L25;
    L26:
        ThreadContextKt.restoreThreadContext(r6, r7);     // Catch: Throwable -> L39
    L27:
        InlineMarker.finallyEnd(1);     // Catch: Throwable -> L39
        goto L37
    L25:
        if (r13.clearThreadContext() == false) goto L27;
    L28:
        th = move-exception;
        InlineMarker.finallyStart(1);     // Catch: Throwable -> L39
        if (r13 != null) goto L32;
    L33:
        ThreadContextKt.restoreThreadContext(r6, r7);     // Catch: Throwable -> L39
    L34:
        InlineMarker.finallyEnd(1);     // Catch: Throwable -> L39
        throw th;     // Catch: Throwable -> L39
    L32:
        if (r13.clearThreadContext() == false) goto L34;
    L19:
        UndispatchedCoroutine r15 = (UndispatchedCoroutine) null;     // Catch: Throwable -> L39
        r13 = null;
    L37:
        if (r0.processUnconfinedEvent() == true) goto L37;
        InlineMarker.finallyStart(1);
    L42:
        r0.decrementUseCount(true);
        InlineMarker.finallyEnd(1);
        return;
    L12:
        if (r4.isActive() == true) goto L14;
        CancellationException r16 = r4.getCancellationException();     // Catch: Throwable -> L39
        cancelCompletedResult$kotlinx_coroutines_core(r10, r16);     // Catch: Throwable -> L39
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L39
        resumeWith(Result.m774constructorimpl(ResultKt.createFailure(r16)));     // Catch: Throwable -> L39
        r11 = true;
    L39:
        th = move-exception;
        r2.handleFatalException(th, null);     // Catch: Throwable -> L44
        InlineMarker.finallyStart(1);
    L44:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r0.decrementUseCount(true);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public void cancelCompletedResult$kotlinx_coroutines_core(Object r1, Throwable r2) {
        if ((r1 instanceof CompletedWithCancellation) == false) goto L6;
        ((CompletedWithCancellation) r1).onCancellation.invoke(r2);
        return;
    }

    public final boolean resumeCancelled(Object r3) {
        Job r0 = (Job) getContext().get(Job.Key);
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isActive() == true) goto L10;
        CancellationException r1 = r0.getCancellationException();
        cancelCompletedResult$kotlinx_coroutines_core(r3, r1);
        Result.Companion r4 = Result.Companion;
        resumeWith(Result.m774constructorimpl(ResultKt.createFailure(r1)));
        return true;
    L10:
        return false;
    }

    public final void resumeUndispatchedWith(Object r5) {
        Continuation<T> r0 = this.continuation;
        Object r1 = this.countOrElement;
        CoroutineContext r2 = r0.getContext();
        Object r3 = ThreadContextKt.updateThreadContext(r2, r1);
        if (r3 == ThreadContextKt.NO_THREAD_ELEMENTS) goto L5;
        UndispatchedCoroutine<?> r4 = CoroutineContextKt.updateUndispatchedCompletion(r0, r2, r3);
    L23:
        this.continuation.resumeWith(r5);     // Catch: Throwable -> L15
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L15
        InlineMarker.finallyStart(1);
        if (r4 != null) goto L11;
    L12:
        ThreadContextKt.restoreThreadContext(r2, r3);
    L13:
        InlineMarker.finallyEnd(1);
        return;
    L11:
        if (r4.clearThreadContext() == false) goto L13;
    L15:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (r4 != null) goto L19;
    L20:
        ThreadContextKt.restoreThreadContext(r2, r3);
    L21:
        InlineMarker.finallyEnd(1);
        throw th;
    L19:
        if (r4.clearThreadContext() == false) goto L21;
    L5:
        r4 = null;
        UndispatchedCoroutine r7 = (UndispatchedCoroutine) null;
        goto L23
    }

    public final void dispatchYield$kotlinx_coroutines_core(CoroutineContext r1, T r2) {
        this._state = r2;
        this.resumeMode = 1;
        this.dispatcher.dispatchYield(r1, this);
    }

    public String toString() {
        return "DispatchedContinuation[" + this.dispatcher + ", " + DebugStringsKt.toDebugString(this.continuation) + ']';
    }

    public final void awaitReusability() {
    L3:
        if (this._reusableCancellableContinuation == DispatchedContinuationKt.REUSABLE_CLAIMED) goto L3;
    }

    public final CancellableContinuationImpl<T> claimReusableCancellableContinuation() {
    L2:
        Object r0 = this._reusableCancellableContinuation;
        if (r0 == null) goto L4;
        if ((r0 instanceof CancellableContinuationImpl) == true) goto L9;
        if (r0 == DispatchedContinuationKt.REUSABLE_CLAIMED) goto L2;
        if ((r0 instanceof Throwable) == true) goto L2;
        throw new IllegalStateException(("Inconsistent state " + r0).toString());
    L9:
        if (b0$$ExternalSyntheticBackport0.m(_reusableCancellableContinuation$FU, this, r0, DispatchedContinuationKt.REUSABLE_CLAIMED) == false) goto L2;
        return (CancellableContinuationImpl) r0;
    L4:
        this._reusableCancellableContinuation = DispatchedContinuationKt.REUSABLE_CLAIMED;
        return null;
    }

    public final Throwable tryReleaseClaimedContinuation(CancellableContinuation<?> r4) {
    L2:
        Object r0 = this._reusableCancellableContinuation;
        if (r0 != DispatchedContinuationKt.REUSABLE_CLAIMED) goto L8;
        if (b0$$ExternalSyntheticBackport0.m(_reusableCancellableContinuation$FU, this, DispatchedContinuationKt.REUSABLE_CLAIMED, r4) == false) goto L2;
        return null;
    L8:
        if ((r0 instanceof Throwable) == false) goto L16;
        if (b0$$ExternalSyntheticBackport0.m(_reusableCancellableContinuation$FU, this, r0, null) == false) goto L14;
        return (Throwable) r0;
    L14:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L16:
        throw new IllegalStateException(("Inconsistent state " + r0).toString());
    }

    public final boolean postponeCancellation(Throwable r4) {
    L2:
        Object r0 = this._reusableCancellableContinuation;
        if (Intrinsics.areEqual(r0, DispatchedContinuationKt.REUSABLE_CLAIMED) == true) goto L5;
        if ((r0 instanceof Throwable) == true) goto L9;
        if (b0$$ExternalSyntheticBackport0.m(_reusableCancellableContinuation$FU, this, r0, null) == false) goto L2;
        return false;
    L9:
        return true;
    L5:
        if (b0$$ExternalSyntheticBackport0.m(_reusableCancellableContinuation$FU, this, DispatchedContinuationKt.REUSABLE_CLAIMED, r4) == false) goto L2;
        return true;
    }
}
