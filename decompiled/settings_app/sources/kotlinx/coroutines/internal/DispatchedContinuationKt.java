package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ThreadLocalEventLoop;
import kotlinx.coroutines.UndispatchedCoroutine;

/* JADX INFO: compiled from: DispatchedContinuation.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a;\u0010\u0003\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0082\b\u001aU\u0010\u000e\u001a\u00020\r\"\u0004\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00122%\b\u0002\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\r\u0018\u00010\u0014H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001a\u0012\u0010\u001a\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\r0\u0005H\u0000\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"REUSABLE_CLAIMED", "Lkotlinx/coroutines/internal/Symbol;", "UNDEFINED", "executeUnconfined", "", "Lkotlinx/coroutines/internal/DispatchedContinuation;", "contState", "", "mode", "", "doYield", "block", "Lkotlin/Function0;", "", "resumeCancellableWith", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/Continuation;", "result", "Lkotlin/Result;", "onCancellation", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "yieldUndispatched", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DispatchedContinuationKt {
    public static final Symbol REUSABLE_CLAIMED = null;
    private static final Symbol UNDEFINED = null;

    public static final /* synthetic */ Symbol access$getUNDEFINED$p() {
        return UNDEFINED;
    }

    static {
        UNDEFINED = new Symbol("UNDEFINED");
        REUSABLE_CLAIMED = new Symbol("REUSABLE_CLAIMED");
    }

    public static /* synthetic */ void resumeCancellableWith$default(Continuation r0, Object r1, Function1 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        resumeCancellableWith(r0, r1, r2);
    }

    public static final <T> void resumeCancellableWith(Continuation<? super T> r7, Object r8, Function1<? super Throwable, Unit> r9) {
        if ((r7 instanceof DispatchedContinuation) == false) goto L43;
        DispatchedContinuation r10 = (DispatchedContinuation) r7;
        Object r11 = CompletionStateKt.toState(r8, r9);
        if (r10.dispatcher.isDispatchNeeded(r10.getContext()) == false) goto L7;
        r10._state = r11;
        r10.resumeMode = 1;
        r10.dispatcher.mo3067dispatch(r10.getContext(), r10);
        return;
    L7:
        DebugKt.getASSERTIONS_ENABLED();
        EventLoop r0 = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (r0.isUnconfinedLoopActive() == false) goto L10;
        r10._state = r11;
        r10.resumeMode = 1;
        r0.dispatchUnconfined(r10);
        return;
    L10:
        DispatchedContinuation r2 = r10;
        r0.incrementUseCount(true);
        Job r4 = (Job) r10.getContext().get(Job.Key);     // Catch: Throwable -> L37
        if (r4 != null) goto L14;
    L16:
        boolean r12 = false;
    L17:
        if (r12 == true) goto L35;
        Continuation<T> r13 = r10.continuation;     // Catch: Throwable -> L37
        Object r5 = r10.countOrElement;     // Catch: Throwable -> L37
        CoroutineContext r6 = r13.getContext();     // Catch: Throwable -> L37
        Object r14 = ThreadContextKt.updateThreadContext(r6, r5);     // Catch: Throwable -> L37
        if (r14 == ThreadContextKt.NO_THREAD_ELEMENTS) goto L22;
        UndispatchedCoroutine<?> r15 = CoroutineContextKt.updateUndispatchedCompletion(r13, r6, r14);     // Catch: Throwable -> L37
    L47:
        r10.continuation.resumeWith(r8);     // Catch: Throwable -> L28
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L28
        if (r15 != null) goto L26;
    L27:
        ThreadContextKt.restoreThreadContext(r6, r14);     // Catch: Throwable -> L37
        goto L35
    L26:
        if (r15.clearThreadContext() == false) goto L35;
    L28:
        th = move-exception;
        if (r15 != null) goto L31;
    L32:
        ThreadContextKt.restoreThreadContext(r6, r14);     // Catch: Throwable -> L37
    L33:
        throw th;     // Catch: Throwable -> L37
    L31:
        if (r15.clearThreadContext() == false) goto L33;
    L22:
        r15 = null;
    L35:
        if (r0.processUnconfinedEvent() == true) goto L35;
    L39:
        r0.decrementUseCount(true);
        return;
    L14:
        if (r4.isActive() == true) goto L16;
        CancellationException r17 = r4.getCancellationException();     // Catch: Throwable -> L37
        r10.cancelCompletedResult$kotlinx_coroutines_core(r11, r17);     // Catch: Throwable -> L37
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L37
        r10.resumeWith(Result.m1508constructorimpl(ResultKt.createFailure(r17)));     // Catch: Throwable -> L37
        r12 = true;
    L37:
        th = move-exception;
        r2.handleFatalException(th, null);     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        r0.decrementUseCount(true);
        throw th;
    L43:
        r7.resumeWith(r8);
    }

    public static final boolean yieldUndispatched(DispatchedContinuation<? super Unit> r5) {
        Unit r0 = Unit.INSTANCE;
        DebugKt.getASSERTIONS_ENABLED();
        EventLoop r1 = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (r1.isUnconfinedQueueEmpty() == false) goto L6;
        return false;
    L6:
        if (r1.isUnconfinedLoopActive() == false) goto L8;
        r5._state = r0;
        r5.resumeMode = 1;
        r1.dispatchUnconfined(r5);
        return true;
    L8:
        DispatchedContinuation<? super Unit> r2 = r5;
        r1.incrementUseCount(true);
        r5.run();     // Catch: Throwable -> L13
    L10:
        if (r1.processUnconfinedEvent() == true) goto L10;
    L16:
        r1.decrementUseCount(true);
        return false;
    L13:
        th = move-exception;
        r2.handleFatalException(th, null);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        r1.decrementUseCount(true);
        throw th;
    }

    private static final boolean executeUnconfined(DispatchedContinuation<?> r3, Object r4, int r5, boolean r6, Function0<Unit> r7) {
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L5;
    L12:
        EventLoop r0 = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (r6 == false) goto L18;
        if (r0.isUnconfinedQueueEmpty() == false) goto L18;
        return false;
    L18:
        if (r0.isUnconfinedLoopActive() == false) goto L20;
        r3._state = r4;
        r3.resumeMode = r5;
        r0.dispatchUnconfined(r3);
        return true;
    L20:
        DispatchedContinuation<?> r8 = r3;
        r0.incrementUseCount(true);
        r7.invoke();     // Catch: Throwable -> L25
    L22:
        if (r0.processUnconfinedEvent() == true) goto L22;
        InlineMarker.finallyStart(1);
    L29:
        r0.decrementUseCount(true);
        InlineMarker.finallyEnd(1);
        return false;
    L25:
        th = move-exception;
        r8.handleFatalException(th, null);     // Catch: Throwable -> L31
        InlineMarker.finallyStart(1);
    L31:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r0.decrementUseCount(true);
        InlineMarker.finallyEnd(1);
        throw th;
    L5:
        if (r5 == (-1)) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L12;
        throw new AssertionError();
    L7:
        r1 = false;
        goto L8
    }

    static /* synthetic */ boolean executeUnconfined$default(DispatchedContinuation r1, Object r2, int r3, boolean r4, Function0 r5, int r6, Object r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = false;
    L6:
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L8;
    L15:
        EventLoop r8 = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (r4 == false) goto L21;
        if (r8.isUnconfinedQueueEmpty() == false) goto L21;
        return false;
    L21:
        if (r8.isUnconfinedLoopActive() == false) goto L23;
        r1._state = r2;
        r1.resumeMode = r3;
        r8.dispatchUnconfined(r1);
        return true;
    L23:
        DispatchedContinuation r9 = r1;
        r8.incrementUseCount(true);
        r5.invoke();     // Catch: Throwable -> L28
    L25:
        if (r8.processUnconfinedEvent() == true) goto L25;
        InlineMarker.finallyStart(1);
    L32:
        r8.decrementUseCount(true);
        InlineMarker.finallyEnd(1);
        return false;
    L28:
        th = move-exception;
        r9.handleFatalException(th, null);     // Catch: Throwable -> L34
        InlineMarker.finallyStart(1);
    L34:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r8.decrementUseCount(true);
        InlineMarker.finallyEnd(1);
        throw th;
    L8:
        if (r3 == (-1)) goto L10;
        boolean r10 = true;
    L11:
        if (r10 == true) goto L15;
        throw new AssertionError();
    L10:
        r10 = false;
        goto L11
    }
}
