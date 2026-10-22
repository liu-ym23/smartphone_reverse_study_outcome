package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Await.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u000e:\u0002\u000b\fB\u001d\u0012\u0014\u0010\u0004\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0086@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0004\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/AwaitAll;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/Deferred;", "deferreds", "<init>", "([Lkotlinx/coroutines/Deferred;)V", "", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "[Lkotlinx/coroutines/Deferred;", "AwaitAllNode", "DisposeHandlersOnCancel", "kotlinx-coroutines-core", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
final class AwaitAll<T> {
    static final /* synthetic */ AtomicIntegerFieldUpdater notCompletedCount$FU = null;
    private final Deferred<T>[] deferreds;
    volatile /* synthetic */ int notCompletedCount;

    /* JADX INFO: compiled from: Await.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\b\u0082\u0004\u0018\u00002\u00020\u001cB\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0002¢\u0006\u0004\b\t\u0010\nR \u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000bR<\u0010\u0013\u001a\u000e\u0018\u00010\fR\b\u0012\u0004\u0012\u00028\u00000\r2\u0012\u0010\u000e\u001a\u000e\u0018\u00010\fR\b\u0012\u0004\u0012\u00028\u00000\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/CancellableContinuation;", "", "continuation", "<init>", "(Lkotlinx/coroutines/AwaitAll;Lkotlinx/coroutines/CancellableContinuation;)V", "", "cause", "", "invoke", "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/AwaitAll;", "value", "getDisposer", "()Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "setDisposer", "(Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;)V", "disposer", "Lkotlinx/coroutines/DisposableHandle;", "handle", "Lkotlinx/coroutines/DisposableHandle;", "getHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setHandle", "(Lkotlinx/coroutines/DisposableHandle;)V", "kotlinx-coroutines-core", "Lkotlinx/coroutines/JobNode;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private final class AwaitAllNode extends JobNode {
        private volatile /* synthetic */ Object _disposer;
        private final CancellableContinuation<List<? extends T>> continuation;
        public DisposableHandle handle;
        final /* synthetic */ AwaitAll<T> this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public AwaitAllNode(AwaitAll r1, CancellableContinuation<? super List<? extends T>> r2) {
            this.this$0 = r1;
            this.continuation = r2;
            this._disposer = null;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable r1) {
            invoke2(r1);
            return Unit.INSTANCE;
        }

        public final DisposableHandle getHandle() {
            DisposableHandle r0 = this.handle;
            if (r0 == null) goto L5;
            return r0;
        L5:
            Intrinsics.throwUninitializedPropertyAccessException("handle");
            return null;
        }

        public final void setHandle(DisposableHandle r1) {
            this.handle = r1;
        }

        public final AwaitAll<T>.DisposeHandlersOnCancel getDisposer() {
            return (DisposeHandlersOnCancel) this._disposer;
        }

        public final void setDisposer(AwaitAll<T>.DisposeHandlersOnCancel r1) {
            this._disposer = r1;
        }

        @Override // kotlinx.coroutines.CompletionHandlerBase
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2(Throwable r5) {
            if (r5 == null) goto L8;
            Object r6 = this.continuation.tryResumeWithException(r5);
            if (r6 == null) goto L16;
            this.continuation.completeResume(r6);
            AwaitAll<T>.DisposeHandlersOnCancel r4 = getDisposer();
            if (r4 == null) goto L17;
            r4.disposeAll();
            return;
        L17:
            return;
        L16:
            return;
        L8:
            AwaitAll<T> r7 = this.this$0;
            if (AwaitAll.notCompletedCount$FU.decrementAndGet(r7) != 0) goto L19;
            CancellableContinuation<List<? extends T>> r8 = this.continuation;
            Deferred[] r9 = AwaitAll.access$getDeferreds$p(this.this$0);
            ArrayList r0 = new ArrayList(r9.length);
            int r1 = r9.length;
            int r2 = 0;
        L11:
            if (r2 >= r1) goto L13;
            r0.add(r9[r2].getCompleted());
            r2 = r2 + 1;
            goto L11
        L13:
            Result.Companion r10 = Result.Companion;
            r8.resumeWith(Result.m774constructorimpl(r0));
            return;
        }
    }

    /* JADX INFO: compiled from: Await.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u000e\u0012\f0\u0004R\b\u0012\u0004\u0012\u00028\u00000\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0006\u0010\b\u001a\u00020\tJ\u0013\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016R \u0010\u0002\u001a\u0012\u0012\u000e\u0012\f0\u0004R\b\u0012\u0004\u0012\u00028\u00000\u00050\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "nodes", "", "Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/AwaitAll;", "(Lkotlinx/coroutines/AwaitAll;[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;)V", "[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "disposeAll", "", "invoke", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private final class DisposeHandlersOnCancel extends CancelHandler {
        private final AwaitAll<T>.AwaitAllNode[] nodes;
        final /* synthetic */ AwaitAll<T> this$0;

        public DisposeHandlersOnCancel(AwaitAll r1, AwaitAll<T>.AwaitAllNode[] r2) {
            this.this$0 = r1;
            this.nodes = r2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable r1) {
            invoke2(r1);
            return Unit.INSTANCE;
        }

        public final void disposeAll() {
            AwaitAll<T>.AwaitAllNode[] r3 = this.nodes;
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r3[r1].getHandle().dispose();
            r1 = r1 + 1;
            goto L3
        }

        @Override // kotlinx.coroutines.CancelHandlerBase
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2(Throwable r1) {
            disposeAll();
        }

        public String toString() {
            return "DisposeHandlersOnCancel[" + this.nodes + ']';
        }
    }

    static {
        notCompletedCount$FU = AtomicIntegerFieldUpdater.newUpdater(AwaitAll.class, "notCompletedCount");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AwaitAll(Deferred<? extends T>[] r1) {
        this.deferreds = r1;
        this.notCompletedCount = r1.length;
    }

    public static final /* synthetic */ Deferred[] access$getDeferreds$p(AwaitAll r0) {
        return r0.deferreds;
    }

    public final Object await(Continuation<? super List<? extends T>> r10) {
        CancellableContinuationImpl r0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(r10), 1);
        r0.initCancellability();
        CancellableContinuationImpl r1 = r0;
        int r2 = access$getDeferreds$p(this).length;
        AwaitAllNode[] r3 = new AwaitAllNode[r2];
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r5 >= r2) goto L5;
        Deferred r6 = access$getDeferreds$p(this)[r5];
        r6.start();
        AwaitAllNode r7 = new AwaitAllNode(this, r1);
        r7.setHandle(r6.invokeOnCompletion(r7));
        Unit r8 = Unit.INSTANCE;
        r3[r5] = r7;
        r5 = r5 + 1;
        goto L3
    L5:
        AwaitAll<T>.DisposeHandlersOnCancel r9 = new DisposeHandlersOnCancel(this, r3);
    L6:
        if (r4 >= r2) goto L9;
        r3[r4].setDisposer(r9);
        r4 = r4 + 1;
        goto L6
    L9:
        if (r1.isCompleted() == false) goto L11;
        r9.disposeAll();
    L12:
        Object r11 = r0.getResult();
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        DebugProbesKt.probeCoroutineSuspended(r10);
    L15:
        return r11;
    L11:
        r1.invokeOnCancellation(r9);
        goto L12
    }
}
