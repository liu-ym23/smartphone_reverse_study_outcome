package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: HandlerDispatcher.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0011\u0010\b\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a\u0011\u0010\n\u001a\u00020\u0001H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0002\u001a\u0016\u0010\u000f\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0002\u001a\u001d\u0010\u0010\u001a\u00020\u0003*\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0002\b\u0014\u001a\u0014\u0010\u0015\u001a\u00020\u0011*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0004\u0010\u0005\"\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"MAX_DELAY", "", "Main", "Lkotlinx/coroutines/android/HandlerDispatcher;", "getMain$annotations", "()V", "choreographer", "Landroid/view/Choreographer;", "awaitFrame", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFrameSlowPath", "postFrameCallback", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "updateChoreographerAndPostFrameCallback", "asCoroutineDispatcher", "Landroid/os/Handler;", "name", "", "from", "asHandler", "Landroid/os/Looper;", "async", "", "kotlinx-coroutines-android"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class HandlerDispatcherKt {
    private static final long MAX_DELAY = 4611686018427387903L;
    public static final HandlerDispatcher Main = null;
    private static volatile Choreographer choreographer;

    /* JADX INFO: renamed from: $r8$lambda$JvkVT-pCVfLu3tzMCeYQAqDm6wU, reason: not valid java name */
    public static /* synthetic */ void m3011$r8$lambda$JvkVTpCVfLu3tzMCeYQAqDm6wU(CancellableContinuation r0, long r1) {
        postFrameCallback$lambda$6(r0, r1);
    }

    public static final /* synthetic */ Object access$awaitFrameSlowPath(Continuation r0) {
        return awaitFrameSlowPath(r0);
    }

    public static final /* synthetic */ void access$postFrameCallback(Choreographer r0, CancellableContinuation r1) {
        postFrameCallback(r0, r1);
    }

    public static final /* synthetic */ void access$updateChoreographerAndPostFrameCallback(CancellableContinuation r0) {
        updateChoreographerAndPostFrameCallback(r0);
    }

    public static final HandlerDispatcher from(Handler r2) {
        return from$default(r2, null, 1, null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use Dispatchers.Main instead")
    public static /* synthetic */ void getMain$annotations() {
    }

    public static /* synthetic */ HandlerDispatcher from$default(Handler r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return from(r0, r1);
    }

    public static final HandlerDispatcher from(Handler r1, String r2) {
        return new HandlerContext(r1, r2);
    }

    public static final Handler asHandler(Looper r4, boolean r5) {
        if (r5 == false) goto L6;
        Object r6 = Handler.class.getDeclaredMethod("createAsync", new Class[]{Looper.class}).invoke(null, new Object[]{r4});
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.os.Handler");
        return (Handler) r6;
    L6:
        return new Handler(r4);
    }

    static {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r2 = Result.m1508constructorimpl(new HandlerContext(asHandler(Looper.getMainLooper(), true), null, 2, null));     // Catch: Throwable -> L5
    L8:
        if (Result.m1514isFailureimpl(r2) == true) goto L11;
        r0 = r2;
    L11:
        Main = (HandlerDispatcher) r0;
        return;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r2 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static final Object awaitFrame(Continuation<? super Long> r4) {
        Choreographer r0 = choreographer;
        if (r0 == null) goto L9;
        CancellableContinuationImpl r1 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(r4), 1);
        r1.initCancellability();
        access$postFrameCallback(r0, r1);
        Object r2 = r1.getResult();
        if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L7;
        DebugProbesKt.probeCoroutineSuspended(r4);
    L7:
        return r2;
    L9:
        return awaitFrameSlowPath(r4);
    }

    private static final void updateChoreographerAndPostFrameCallback(CancellableContinuation<? super Long> r1) {
        Choreographer r0 = choreographer;
        if (r0 != null) goto L5;
        r0 = Choreographer.getInstance();
        Intrinsics.checkNotNull(r0);
        choreographer = r0;
    L5:
        postFrameCallback(r0, r1);
    }

    private static final void postFrameCallback(Choreographer r1, final CancellableContinuation<? super Long> r2) {
        r1.postFrameCallback(new HandlerDispatcherKt$$ExternalSyntheticLambda0(r2));
    }

    private static final void postFrameCallback$lambda$6(CancellableContinuation r1, long r2) {
        r1.resumeUndispatched(Dispatchers.getMain(), Long.valueOf(r2));
    }

    private static final Object awaitFrameSlowPath(Continuation<? super Long> r5) {
        CancellableContinuationImpl r0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(r5), 1);
        r0.initCancellability();
        final CancellableContinuationImpl r1 = r0;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        access$updateChoreographerAndPostFrameCallback(r1);
    L6:
        Object r2 = r0.getResult();
        if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L9:
        return r2;
    L5:
        Dispatchers.getMain().mo3067dispatch(r1.getContext(), new HandlerDispatcherKt$awaitFrameSlowPath$lambda$3$$inlined$Runnable$1(r1));
        goto L6
    }
}
