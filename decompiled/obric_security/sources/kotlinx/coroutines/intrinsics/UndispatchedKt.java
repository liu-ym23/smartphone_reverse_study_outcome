package kotlinx.coroutines.intrinsics;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.JobSupportKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: compiled from: Undispatched.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a9\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u001a\u0010\u0005\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0082\b\u001a>\u0010\b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\t\u001aR\u0010\b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u0002*\u001e\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b2\u0006\u0010\f\u001a\u0002H\n2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a>\u0010\u000e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\t\u001aR\u0010\u000e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u0002*\u001e\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b2\u0006\u0010\f\u001a\u0002H\n2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\r\u001aY\u0010\u000f\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n*\b\u0012\u0004\u0012\u0002H\u00020\u00102\u0006\u0010\f\u001a\u0002H\n2'\u0010\u0005\u001a#\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b¢\u0006\u0002\b\u0011H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001aY\u0010\u0013\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n*\b\u0012\u0004\u0012\u0002H\u00020\u00102\u0006\u0010\f\u001a\u0002H\n2'\u0010\u0005\u001a#\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b¢\u0006\u0002\b\u0011H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a?\u0010\u0014\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00102\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00062\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0019H\u0082\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"startDirect", "", ExifInterface.GPS_DIRECTION_TRUE, "completion", "Lkotlin/coroutines/Continuation;", "block", "Lkotlin/Function1;", "", "startCoroutineUndispatched", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "startCoroutineUnintercepted", "startUndispatchedOrReturn", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/internal/ScopeCoroutine;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "startUndispatchedOrReturnIgnoreTimeout", "undispatchedResult", "shouldThrow", "", "", "startBlock", "Lkotlin/Function0;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class UndispatchedKt {
    public static final <T, R> Object startUndispatchedOrReturn(ScopeCoroutine<? super T> r3, R r4, Function2<? super R, ? super Continuation<? super T>, ? extends Object> r5) {
        Object r6 = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r5, 2)).invoke(r4, r3);     // Catch: Throwable -> L5
    L8:
        if (r6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L28;
        Object r7 = r3.makeCompletingOnce$kotlinx_coroutines_core(r6);
        if (r7 != JobSupportKt.COMPLETING_WAITING_CHILDREN) goto L14;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    L14:
        if ((r7 instanceof CompletedExceptionally) == false) goto L23;
        CompletedExceptionally r8 = (CompletedExceptionally) r7;
        Throwable r9 = r8.cause;
        Throwable r10 = r8.cause;
        Continuation<? super T> r11 = r3.uCont;
        if (DebugKt.getRECOVER_STACK_TRACES() == true) goto L18;
        throw r10;
    L18:
        if ((r11 instanceof CoroutineStackFrame) == true) goto L21;
        throw r10;
    L21:
        throw StackTraceRecoveryKt.access$recoverFromStackFrame(r10, (CoroutineStackFrame) r11);
    L23:
        return JobSupportKt.unboxState(r7);
    L28:
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    L5:
        th = move-exception;
        r6 = new CompletedExceptionally(th, false, 2, null);
        goto L8
    }

    public static final <T, R> Object startUndispatchedOrReturnIgnoreTimeout(ScopeCoroutine<? super T> r3, R r4, Function2<? super R, ? super Continuation<? super T>, ? extends Object> r5) {
        boolean r0 = false;
        Object r6 = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r5, 2)).invoke(r4, r3);     // Catch: Throwable -> L5
    L8:
        if (r6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L46;
        Object r7 = r3.makeCompletingOnce$kotlinx_coroutines_core(r6);
        if (r7 != JobSupportKt.COMPLETING_WAITING_CHILDREN) goto L14;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    L14:
        if ((r7 instanceof CompletedExceptionally) == false) goto L37;
        CompletedExceptionally r8 = (CompletedExceptionally) r7;
        Throwable r1 = r8.cause;
        if ((r1 instanceof TimeoutCancellationException) == true) goto L18;
    L19:
        r0 = true;
    L20:
        if (r0 == false) goto L29;
        Throwable r9 = r8.cause;
        Continuation<? super T> r10 = r3.uCont;
        if (DebugKt.getRECOVER_STACK_TRACES() == true) goto L24;
        throw r9;
    L24:
        if ((r10 instanceof CoroutineStackFrame) == true) goto L27;
        throw r9;
    L27:
        throw StackTraceRecoveryKt.access$recoverFromStackFrame(r9, (CoroutineStackFrame) r10);
    L29:
        if ((r6 instanceof CompletedExceptionally) == false) goto L39;
        Throwable r11 = ((CompletedExceptionally) r6).cause;
        Continuation<? super T> r12 = r3.uCont;
        if (DebugKt.getRECOVER_STACK_TRACES() == true) goto L33;
        throw r11;
    L33:
        if ((r12 instanceof CoroutineStackFrame) == true) goto L36;
        throw r11;
    L36:
        throw StackTraceRecoveryKt.access$recoverFromStackFrame(r11, (CoroutineStackFrame) r12);
    L39:
        return r6;
    L18:
        if (((TimeoutCancellationException) r1).coroutine == r3) goto L20;
    L37:
        r6 = JobSupportKt.unboxState(r7);
        goto L39
    L46:
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    L5:
        th = move-exception;
        r6 = new CompletedExceptionally(th, false, 2, null);
        goto L8
    }

    private static final <T> Object undispatchedResult(ScopeCoroutine<? super T> r4, Function1<? super Throwable, Boolean> r5, Function0<? extends Object> r6) {
        Object r7 = r6.invoke();     // Catch: Throwable -> L4
    L7:
        if (r7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        Object r0 = r4.makeCompletingOnce$kotlinx_coroutines_core(r7);
        if (r0 != JobSupportKt.COMPLETING_WAITING_CHILDREN) goto L15;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    L15:
        if ((r0 instanceof CompletedExceptionally) == false) goto L35;
        CompletedExceptionally r1 = (CompletedExceptionally) r0;
        if (r5.invoke(r1.cause).booleanValue() == false) goto L26;
        Throwable r8 = r1.cause;
        Continuation<? super T> r9 = r4.uCont;
        if (DebugKt.getRECOVER_STACK_TRACES() == true) goto L21;
        throw r8;
    L21:
        if ((r9 instanceof CoroutineStackFrame) == true) goto L24;
        throw r8;
    L24:
        throw StackTraceRecoveryKt.access$recoverFromStackFrame(r8, (CoroutineStackFrame) r9);
    L26:
        if ((r7 instanceof CompletedExceptionally) == false) goto L42;
        Throwable r10 = ((CompletedExceptionally) r7).cause;
        Continuation<? super T> r11 = r4.uCont;
        if (DebugKt.getRECOVER_STACK_TRACES() == true) goto L30;
        throw r10;
    L30:
        if ((r11 instanceof CoroutineStackFrame) == true) goto L33;
        throw r10;
    L33:
        throw StackTraceRecoveryKt.access$recoverFromStackFrame(r10, (CoroutineStackFrame) r11);
    L42:
        return r7;
    L35:
        return JobSupportKt.unboxState(r0);
    L9:
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    L4:
        th = move-exception;
        r7 = new CompletedExceptionally(th, false, 2, null);
        goto L7
    }

    public static final <T> void startCoroutineUnintercepted(Function1<? super Continuation<? super T>, ? extends Object> r1, Continuation<? super T> r2) {
        Continuation r3 = DebugProbesKt.probeCoroutineCreated(r2);
        Object r4 = ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r1, 1)).invoke(r3);     // Catch: Throwable -> L7
        if (r4 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        Result.Companion r0 = Result.Companion;
        r3.resumeWith(Result.m774constructorimpl(r4));
        return;
    L12:
        return;
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3.resumeWith(Result.m774constructorimpl(ResultKt.createFailure(th)));
    }

    public static final <R, T> void startCoroutineUnintercepted(Function2<? super R, ? super Continuation<? super T>, ? extends Object> r1, R r2, Continuation<? super T> r3) {
        Continuation r4 = DebugProbesKt.probeCoroutineCreated(r3);
        Object r5 = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r1, 2)).invoke(r2, r4);     // Catch: Throwable -> L7
        if (r5 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        Result.Companion r6 = Result.Companion;
        r4.resumeWith(Result.m774constructorimpl(r5));
        return;
    L12:
        return;
    L7:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r4.resumeWith(Result.m774constructorimpl(ResultKt.createFailure(th)));
    }

    public static final <T> void startCoroutineUndispatched(Function1<? super Continuation<? super T>, ? extends Object> r3, Continuation<? super T> r4) {
        Continuation r0 = DebugProbesKt.probeCoroutineCreated(r4);
        CoroutineContext r5 = r4.getContext();     // Catch: Throwable -> L13
        Object r1 = ThreadContextKt.updateThreadContext(r5, null);     // Catch: Throwable -> L13
        Object r6 = ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r3, 1)).invoke(r0);     // Catch: Throwable -> L10
        ThreadContextKt.restoreThreadContext(r5, r1);     // Catch: Throwable -> L13
        if (r6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        Result.Companion r7 = Result.Companion;
        r0.resumeWith(Result.m774constructorimpl(r6));
        return;
    L19:
        return;
    L10:
        th = move-exception;
        ThreadContextKt.restoreThreadContext(r5, r1);     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r0.resumeWith(Result.m774constructorimpl(ResultKt.createFailure(th)));
    }

    public static final <R, T> void startCoroutineUndispatched(Function2<? super R, ? super Continuation<? super T>, ? extends Object> r3, R r4, Continuation<? super T> r5) {
        Continuation r0 = DebugProbesKt.probeCoroutineCreated(r5);
        CoroutineContext r6 = r5.getContext();     // Catch: Throwable -> L13
        Object r1 = ThreadContextKt.updateThreadContext(r6, null);     // Catch: Throwable -> L13
        Object r7 = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r3, 2)).invoke(r4, r0);     // Catch: Throwable -> L10
        ThreadContextKt.restoreThreadContext(r6, r1);     // Catch: Throwable -> L13
        if (r7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        Result.Companion r8 = Result.Companion;
        r0.resumeWith(Result.m774constructorimpl(r7));
        return;
    L19:
        return;
    L10:
        th = move-exception;
        ThreadContextKt.restoreThreadContext(r6, r1);     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r0.resumeWith(Result.m774constructorimpl(ResultKt.createFailure(th)));
    }

    private static final <T> void startDirect(Continuation<? super T> r1, Function1<? super Continuation<? super T>, ? extends Object> r2) {
        Continuation r3 = DebugProbesKt.probeCoroutineCreated(r1);
        Object r4 = r2.invoke(r3);     // Catch: Throwable -> L8
        if (r4 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        Result.Companion r0 = Result.Companion;
        r3.resumeWith(Result.m774constructorimpl(r4));
        return;
    L13:
        return;
    L8:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3.resumeWith(Result.m774constructorimpl(ResultKt.createFailure(th)));
    }
}
