package kotlinx.coroutines.intrinsics;

import androidx.exifinterface.media.ExifInterface;
import com.android.settingslib.SliceBroadcastRelay;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.DispatchedContinuationKt;

/* JADX INFO: compiled from: Cancellable.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001c\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a#\u0010\u0006\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0082\b\u001a\u001e\u0010\t\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00032\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0000\u001a>\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u000b*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0003H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001ay\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u000b*\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00102\u0006\u0010\u0011\u001a\u0002H\u000f2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00032%\b\u0002\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fH\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"dispatcherFailure", "", "completion", "Lkotlin/coroutines/Continuation;", "e", "", "runSafely", "block", "Lkotlin/Function0;", "startCoroutineCancellable", "fatalCompletion", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", SliceBroadcastRelay.EXTRA_RECEIVER, "onCancellation", "Lkotlin/ParameterName;", "name", "cause", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CancellableKt {
    public static final <T> void startCoroutineCancellable(Function1<? super Continuation<? super T>, ? extends Object> r3, Continuation<? super T> r4) {
        Continuation r5 = IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(r3, r4));     // Catch: Throwable -> L4
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        DispatchedContinuationKt.resumeCancellableWith$default(r5, Result.m1508constructorimpl(Unit.INSTANCE), null, 2, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        dispatcherFailure(r4, th);
    }

    public static /* synthetic */ void startCoroutineCancellable$default(Function2 r0, Object r1, Continuation r2, Function1 r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        startCoroutineCancellable(r0, r1, r2, r3);
    }

    public static final <R, T> void startCoroutineCancellable(Function2<? super R, ? super Continuation<? super T>, ? extends Object> r0, R r1, Continuation<? super T> r2, Function1<? super Throwable, Unit> r3) {
        Continuation r4 = IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(r0, r1, r2));     // Catch: Throwable -> L4
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L4
        DispatchedContinuationKt.resumeCancellableWith(r4, Result.m1508constructorimpl(Unit.INSTANCE), r3);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        dispatcherFailure(r2, th);
    }

    public static final void startCoroutineCancellable(Continuation<? super Unit> r3, Continuation<?> r4) {
        Continuation r5 = IntrinsicsKt.intercepted(r3);     // Catch: Throwable -> L4
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        DispatchedContinuationKt.resumeCancellableWith$default(r5, Result.m1508constructorimpl(Unit.INSTANCE), null, 2, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        dispatcherFailure(r4, th);
    }

    private static final void runSafely(Continuation<?> r0, Function0<Unit> r1) {
        r1.invoke();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        dispatcherFailure(r0, th);
    }

    private static final void dispatcherFailure(Continuation<?> r1, Throwable r2) {
        Result.Companion r0 = Result.Companion;
        r1.resumeWith(Result.m1508constructorimpl(ResultKt.createFailure(r2)));
        throw r2;
    }
}
