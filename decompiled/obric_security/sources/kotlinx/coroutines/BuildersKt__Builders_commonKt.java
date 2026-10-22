package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.obric.matrix.platform.sdk.ones.safecushion.SafeCushionConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

/* JADX INFO: compiled from: Builders.common.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001aU\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t¢\u0006\u0002\b\rH\u0086@ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\u000e\u001a[\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0010\"\u0004\b\u0000\u0010\u0005*\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00122'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t¢\u0006\u0002\b\rø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001aF\u0010\u0014\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0005*\u00020\u00152)\b\b\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t¢\u0006\u0002\b\rH\u0086Jø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001aO\u0010\u0017\u001a\u00020\u0018*\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00122'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t¢\u0006\u0002\b\rø\u0001\u0000¢\u0006\u0002\u0010\u001a\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"RESUMED", "", DebugCoroutineInfoImplKt.SUSPENDED, "UNDECIDED", "withContext", ExifInterface.GPS_DIRECTION_TRUE, "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "async", "Lkotlinx/coroutines/Deferred;", "start", "Lkotlinx/coroutines/CoroutineStart;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Deferred;", "invoke", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", SafeCushionConstant.LAUNCH_CRASH, "Lkotlinx/coroutines/Job;", "", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "kotlinx/coroutines/BuildersKt")
final /* synthetic */ class BuildersKt__Builders_commonKt {
    private static final int RESUMED = 2;
    private static final int SUSPENDED = 1;
    private static final int UNDECIDED = 0;

    public static /* synthetic */ Job launch$default(CoroutineScope r0, EmptyCoroutineContext r1, CoroutineStart r2, Function2 r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = EmptyCoroutineContext.INSTANCE;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = CoroutineStart.DEFAULT;
    L9:
        return BuildersKt.launch(r0, r1, r2, r3);
    }

    public static final Job launch(CoroutineScope r1, CoroutineContext r2, CoroutineStart r3, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r4) {
        CoroutineContext r5 = CoroutineContextKt.newCoroutineContext(r1, r2);
        if (r3.isLazy() == false) goto L5;
        LazyStandaloneCoroutine r6 = new LazyStandaloneCoroutine(r5, r4);
    L6:
        r6.start(r3, r6, r4);
        return r6;
    L5:
        r6 = new StandaloneCoroutine(r5, true);
        goto L6
    }

    public static /* synthetic */ Deferred async$default(CoroutineScope r0, EmptyCoroutineContext r1, CoroutineStart r2, Function2 r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = EmptyCoroutineContext.INSTANCE;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = CoroutineStart.DEFAULT;
    L9:
        return BuildersKt.async(r0, r1, r2, r3);
    }

    public static final <T> Deferred<T> async(CoroutineScope r1, CoroutineContext r2, CoroutineStart r3, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r4) {
        CoroutineContext r5 = CoroutineContextKt.newCoroutineContext(r1, r2);
        if (r3.isLazy() == false) goto L5;
        LazyDeferredCoroutine r6 = new LazyDeferredCoroutine(r5, r4);
    L6:
        r6.start(r3, r6, r4);
        return r6;
    L5:
        r6 = new DeferredCoroutine(r5, true);
        goto L6
    }

    public static final <T> Object withContext(CoroutineContext r8, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r9, Continuation<? super T> r10) {
        CoroutineContext r0 = r10.getContext();
        CoroutineContext r11 = CoroutineContextKt.newCoroutineContext(r0, r8);
        JobKt.ensureActive(r11);
        if (r11 != r0) goto L6;
        ScopeCoroutine r1 = new ScopeCoroutine(r11, r10);
        Object r12 = UndispatchedKt.startUndispatchedOrReturn(r1, r1, r9);
    L15:
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        DebugProbesKt.probeCoroutineSuspended(r10);
    L17:
        return r12;
    L6:
        if (Intrinsics.areEqual(r11.get(ContinuationInterceptor.Key), r0.get(ContinuationInterceptor.Key)) == false) goto L13;
        UndispatchedCoroutine r2 = new UndispatchedCoroutine(r11, r10);
        Object r3 = ThreadContextKt.updateThreadContext(r11, null);
        Object r13 = UndispatchedKt.startUndispatchedOrReturn(r2, r2, r9);     // Catch: Throwable -> L10
        ThreadContextKt.restoreThreadContext(r11, r3);
        r12 = r13;
    L10:
        th = move-exception;
        ThreadContextKt.restoreThreadContext(r11, r3);
        throw th;
    L13:
        DispatchedCoroutine r4 = new DispatchedCoroutine(r11, r10);
        CancellableKt.startCoroutineCancellable$default(r9, r4, r4, null, 4, null);
        r12 = r4.getResult();
        goto L15
    }

    public static final <T> Object invoke(CoroutineDispatcher r0, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r1, Continuation<? super T> r2) {
        return BuildersKt.withContext(r0, r1, r2);
    }

    private static final <T> Object invoke$$forInline(CoroutineDispatcher r1, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r2, Continuation<? super T> r3) {
        InlineMarker.mark(0);
        Object r4 = BuildersKt.withContext(r1, r2, r3);
        InlineMarker.mark(1);
        return r4;
    }
}
