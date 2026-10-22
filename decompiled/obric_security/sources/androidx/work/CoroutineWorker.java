package androidx.work;

import android.content.Context;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: CoroutineWorker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0016\u001a\u00020\u000fH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0011\u0010\u0018\u001a\u00020\u0019H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u0019\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0019H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010 J\u0019\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020#H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010$J\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001bR\u001c\u0010\u0007\u001a\u00020\b8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Landroidx/work/CoroutineWorker;", "Landroidx/work/ListenableWorker;", "appContext", "Landroid/content/Context;", "params", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "coroutineContext", "Lkotlinx/coroutines/CoroutineDispatcher;", "getCoroutineContext$annotations", "()V", "getCoroutineContext", "()Lkotlinx/coroutines/CoroutineDispatcher;", "future", "Landroidx/work/impl/utils/futures/SettableFuture;", "Landroidx/work/ListenableWorker$Result;", "getFuture$work_runtime_ktx_release", "()Landroidx/work/impl/utils/futures/SettableFuture;", "job", "Lkotlinx/coroutines/CompletableJob;", "getJob$work_runtime_ktx_release", "()Lkotlinx/coroutines/CompletableJob;", "doWork", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getForegroundInfo", "Landroidx/work/ForegroundInfo;", "getForegroundInfoAsync", "Lcom/google/common/util/concurrent/ListenableFuture;", "onStopped", "", "setForeground", "foregroundInfo", "(Landroidx/work/ForegroundInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setProgress", "data", "Landroidx/work/Data;", "(Landroidx/work/Data;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startWork", "work-runtime-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class CoroutineWorker extends ListenableWorker {
    private final CoroutineDispatcher coroutineContext;
    private final SettableFuture<ListenableWorker.Result> future;
    private final CompletableJob job;

    /* JADX INFO: renamed from: androidx.work.CoroutineWorker$getForegroundInfoAsync$1, reason: invalid class name */
    /* JADX INFO: compiled from: CoroutineWorker.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "androidx.work.CoroutineWorker$getForegroundInfoAsync$1", f = "CoroutineWorker.kt", i = {}, l = {134}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ JobListenableFuture<ForegroundInfo> $jobFuture;
        Object L$0;
        int label;
        final /* synthetic */ CoroutineWorker this$0;

        AnonymousClass1(JobListenableFuture<ForegroundInfo> r1, CoroutineWorker r2, Continuation<? super AnonymousClass1> r3) {
            this.$jobFuture = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.$jobFuture, this.this$0, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            JobListenableFuture r5 = (JobListenableFuture) this.L$0;
            ResultKt.throwOnFailure(r6);
        L12:
            r5.complete(r6);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            JobListenableFuture<ForegroundInfo> r7 = this.$jobFuture;
            this.L$0 = r7;
            this.label = 1;
            Object r8 = this.this$0.getForegroundInfo(this);
            if (r8 != r0) goto L11;
            return r0;
        L11:
            r6 = r8;
            r5 = r7;
            goto L12
        }
    }

    /* JADX INFO: renamed from: androidx.work.CoroutineWorker$startWork$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CoroutineWorker.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "androidx.work.CoroutineWorker$startWork$1", f = "CoroutineWorker.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
    static final class C01301 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CoroutineWorker this$0;

        C01301(CoroutineWorker r1, Continuation<? super C01301> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C01301(this.this$0, r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C01301) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L7
        L15:
            SettableFuture<ListenableWorker.Result> r2 = this.this$0.getFuture$work_runtime_ktx_release();     // Catch: Throwable -> L7
            r2.set((ListenableWorker.Result) r4);     // Catch: Throwable -> L7
        L19:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r4);
            this.label = 1;     // Catch: Throwable -> L7
            r4 = this.this$0.doWork(this);     // Catch: Throwable -> L7
            if (r4 != r0) goto L15;
            return r0;
        L7:
            th = move-exception;
            this.this$0.getFuture$work_runtime_ktx_release().setException(th);
            goto L19
        }
    }

    public static /* synthetic */ void $r8$lambda$vS4ut6uACXh9vB8D1LtSlAShhGE(CoroutineWorker r0) {
        _init_$lambda$0(r0);
    }

    @Deprecated(message = "use withContext(...) inside doWork() instead.")
    public static /* synthetic */ void getCoroutineContext$annotations() {
    }

    public abstract Object doWork(Continuation<? super ListenableWorker.Result> r1);

    public Object getForegroundInfo(Continuation<? super ForegroundInfo> r1) {
        return getForegroundInfo$suspendImpl(this, r1);
    }

    public CoroutineWorker(Context r2, WorkerParameters r3) {
        Intrinsics.checkNotNullParameter(r2, "appContext");
        Intrinsics.checkNotNullParameter(r3, "params");
        super(r2, r3);
        this.job = JobKt.Job$default(null, 1, null);
        SettableFuture<ListenableWorker.Result> r4 = SettableFuture.create();
        Intrinsics.checkNotNullExpressionValue(r4, "create()");
        this.future = r4;
        r4.addListener(new CoroutineWorker$$ExternalSyntheticLambda0(this), getTaskExecutor().getSerialTaskExecutor());
        this.coroutineContext = Dispatchers.getDefault();
    }

    public final CompletableJob getJob$work_runtime_ktx_release() {
        return this.job;
    }

    public final SettableFuture<ListenableWorker.Result> getFuture$work_runtime_ktx_release() {
        return this.future;
    }

    private static final void _init_$lambda$0(CoroutineWorker r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        if (r2.future.isCancelled() == false) goto L6;
        Job.DefaultImpls.cancel$default(r2.job, null, 1, null);
        return;
    }

    public CoroutineDispatcher getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // androidx.work.ListenableWorker
    public final ListenableFuture<ListenableWorker.Result> startWork() {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(getCoroutineContext().plus(this.job)), null, null, new C01301(this, null), 3, null);
        return this.future;
    }

    static /* synthetic */ Object getForegroundInfo$suspendImpl(CoroutineWorker r0, Continuation<? super ForegroundInfo> r1) {
        throw new IllegalStateException("Not implemented");
    }

    public final Object setProgress(Data r4, Continuation<? super Unit> r5) {
        ListenableFuture<Void> r3 = setProgressAsync(r4);
        Intrinsics.checkNotNullExpressionValue(r3, "setProgressAsync(data)");
        if (r3.isDone() == true) goto L19;
        CancellableContinuationImpl r6 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(r5), 1);
        r6.initCancellability();
        CancellableContinuationImpl r0 = r6;
        r3.addListener(new ListenableFutureKt$await$2$1(r0, r3), DirectExecutor.INSTANCE);
        r0.invokeOnCancellation(new ListenableFutureKt$await$2$2(r3));
        Object r7 = r6.getResult();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L15:
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
        return r7;
    L18:
        return Unit.INSTANCE;
    L19:
        r3.get();     // Catch: ExecutionException -> L6
    L6:
        e = move-exception;
        Throwable r8 = e.getCause();
        if (r8 == null) goto L10;
        throw r8;
    L10:
        throw e;
    }

    public final Object setForeground(ForegroundInfo r4, Continuation<? super Unit> r5) {
        ListenableFuture<Void> r3 = setForegroundAsync(r4);
        Intrinsics.checkNotNullExpressionValue(r3, "setForegroundAsync(foregroundInfo)");
        if (r3.isDone() == true) goto L19;
        CancellableContinuationImpl r6 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(r5), 1);
        r6.initCancellability();
        CancellableContinuationImpl r0 = r6;
        r3.addListener(new ListenableFutureKt$await$2$1(r0, r3), DirectExecutor.INSTANCE);
        r0.invokeOnCancellation(new ListenableFutureKt$await$2$2(r3));
        Object r7 = r6.getResult();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L15:
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
        return r7;
    L18:
        return Unit.INSTANCE;
    L19:
        r3.get();     // Catch: ExecutionException -> L6
    L6:
        e = move-exception;
        Throwable r8 = e.getCause();
        if (r8 == null) goto L10;
        throw r8;
    L10:
        throw e;
    }

    @Override // androidx.work.ListenableWorker
    public final ListenableFuture<ForegroundInfo> getForegroundInfoAsync() {
        CompletableJob r0 = JobKt.Job$default(null, 1, null);
        CoroutineScope r3 = CoroutineScopeKt.CoroutineScope(getCoroutineContext().plus(r0));
        JobListenableFuture r2 = new JobListenableFuture(r0, null, 2, null);
        BuildersKt.launch$default(r3, null, null, new AnonymousClass1(r2, this, null), 3, null);
        return r2;
    }

    @Override // androidx.work.ListenableWorker
    public final void onStopped() {
        super.onStopped();
        this.future.cancel(false);
    }
}
