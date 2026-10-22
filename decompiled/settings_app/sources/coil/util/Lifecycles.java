package coil.util;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: renamed from: coil.util.-Lifecycles, reason: invalid class name */
/* JADX INFO: compiled from: Lifecycles.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0081@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"awaitStarted", "", "Landroidx/lifecycle/Lifecycle;", "(Landroidx/lifecycle/Lifecycle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeAndAddObserver", "observer", "Landroidx/lifecycle/LifecycleObserver;", "coil-base_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Lifecycles {

    /* JADX INFO: renamed from: coil.util.-Lifecycles$awaitStarted$1, reason: invalid class name */
    /* JADX INFO: compiled from: Lifecycles.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "coil.util.-Lifecycles", f = "Lifecycles.kt", i = {0, 0}, l = {44}, m = "awaitStarted", n = {"$this$awaitStarted", "observer"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return Lifecycles.awaitStarted(null, this);
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, coil.util.-Lifecycles$awaitStarted$2$1] */
    public static final Object awaitStarted(Lifecycle r6, Continuation<? super Unit> r7) {
        if ((r7 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r7;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L17;
        Ref.ObjectRef r9 = (Ref.ObjectRef) r0.L$1;
        Lifecycle r3 = (Lifecycle) r0.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L14
    L29:
        LifecycleObserver r10 = (LifecycleObserver) r9.element;
        if (r10 == null) goto L33;
        r3.removeObserver(r10);
    L33:
        return Unit.INSTANCE;
    L14:
        Throwable th = th;
    L36:
        LifecycleObserver r11 = (LifecycleObserver) r9.element;
        if (r11 == null) goto L39;
        r3.removeObserver(r11);
    L39:
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r8);
        if (r6.getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L21;
        Ref.ObjectRef r12 = new Ref.ObjectRef();
        r0.L$0 = r6;     // Catch: Throwable -> L34
        r0.L$1 = r12;     // Catch: Throwable -> L34
        r0.label = 1;     // Catch: Throwable -> L34
        CancellableContinuationImpl r4 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(r0), 1);     // Catch: Throwable -> L34
        r4.initCancellability();     // Catch: Throwable -> L34
        final CancellableContinuationImpl r5 = r4;     // Catch: Throwable -> L34
        r12.element = new Lifecycles$awaitStarted$2$1(r5);     // Catch: Throwable -> L34
        T r13 = r12.element;     // Catch: Throwable -> L34
        Intrinsics.checkNotNull(r13);     // Catch: Throwable -> L34
        r6.addObserver((LifecycleObserver) r13);     // Catch: Throwable -> L34
        Object r14 = r4.getResult();     // Catch: Throwable -> L34
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        DebugProbesKt.probeCoroutineSuspended(r0);     // Catch: Throwable -> L34
    L26:
        if (r14 != r1) goto L28;
        return r1;
    L28:
        r3 = r6;
        r9 = r12;
    L34:
        th = move-exception;
        r3 = r6;
        r9 = r12;
        th = th;
        goto L36
    L21:
        return Unit.INSTANCE;
    L7:
        r0 = new AnonymousClass1(r7);
        goto L8
    }

    public static final void removeAndAddObserver(Lifecycle r0, LifecycleObserver r1) {
        r0.removeObserver(r1);
        r0.addObserver(r1);
    }
}
