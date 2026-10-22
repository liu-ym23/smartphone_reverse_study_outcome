package androidx.work.impl.workers;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTrackerImpl;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConstraintTrackingWorker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\u0016\u0010\u0019\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0015H\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0002J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\u001dH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u00018G@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR2\u0010\u000e\u001a&\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u0010 \u0011*\u0012\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u0010\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/work/impl/workers/ConstraintTrackingWorker;", "Landroidx/work/ListenableWorker;", "Landroidx/work/impl/constraints/WorkConstraintsCallback;", "appContext", "Landroid/content/Context;", "workerParameters", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "areConstraintsUnmet", "", "<set-?>", "delegate", "getDelegate", "()Landroidx/work/ListenableWorker;", "future", "Landroidx/work/impl/utils/futures/SettableFuture;", "Landroidx/work/ListenableWorker$Result;", "kotlin.jvm.PlatformType", "lock", "", "onAllConstraintsMet", "", "workSpecs", "", "Landroidx/work/impl/model/WorkSpec;", "onAllConstraintsNotMet", "onStopped", "setupAndRunConstraintTrackingWork", "startWork", "Lcom/google/common/util/concurrent/ListenableFuture;", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ConstraintTrackingWorker extends ListenableWorker implements WorkConstraintsCallback {
    private volatile boolean areConstraintsUnmet;
    private ListenableWorker delegate;
    private final SettableFuture<ListenableWorker.Result> future;
    private final Object lock;
    private final WorkerParameters workerParameters;

    public static /* synthetic */ void $r8$lambda$Pq8ShJ1797iT4hh1l_us_0tEsV0(ConstraintTrackingWorker r0, ListenableFuture r1) {
        setupAndRunConstraintTrackingWork$lambda$2(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$wxwWb1SPyd6YmyhjXwGT_lgVTZk(ConstraintTrackingWorker r0) {
        startWork$lambda$0(r0);
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsMet(List<WorkSpec> r1) {
        Intrinsics.checkNotNullParameter(r1, "workSpecs");
    }

    public ConstraintTrackingWorker(Context r2, WorkerParameters r3) {
        Intrinsics.checkNotNullParameter(r2, "appContext");
        Intrinsics.checkNotNullParameter(r3, "workerParameters");
        super(r2, r3);
        this.workerParameters = r3;
        this.lock = new Object();
        this.future = SettableFuture.create();
    }

    public final ListenableWorker getDelegate() {
        return this.delegate;
    }

    private static final void startWork$lambda$0(ConstraintTrackingWorker r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.setupAndRunConstraintTrackingWork();
    }

    @Override // androidx.work.ListenableWorker
    public ListenableFuture<ListenableWorker.Result> startWork() {
        getBackgroundExecutor().execute(new ConstraintTrackingWorker$$ExternalSyntheticLambda0(this));
        SettableFuture<ListenableWorker.Result> r2 = this.future;
        Intrinsics.checkNotNullExpressionValue(r2, "future");
        return r2;
    }

    private final void setupAndRunConstraintTrackingWork() {
        if (this.future.isCancelled() == false) goto L5;
        return;
    L5:
        String r0 = getInputData().getString(ConstraintTrackingWorkerKt.ARGUMENT_CLASS_NAME);
        Logger r1 = Logger.get();
        Intrinsics.checkNotNullExpressionValue(r1, "get()");
        String r2 = r0;
        if (r2 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == false) goto L15;
        r1.error(ConstraintTrackingWorkerKt.access$getTAG$p(), "No worker to delegate to.");
        SettableFuture<ListenableWorker.Result> r6 = this.future;
        Intrinsics.checkNotNullExpressionValue(r6, "future");
        ConstraintTrackingWorkerKt.access$setFailed(r6);
        return;
    L15:
        ListenableWorker r4 = getWorkerFactory().createWorkerWithDefaultFallback(getApplicationContext(), r0, this.workerParameters);
        this.delegate = r4;
        if (r4 != null) goto L19;
        r1.debug(ConstraintTrackingWorkerKt.access$getTAG$p(), "No worker to delegate to.");
        SettableFuture<ListenableWorker.Result> r7 = this.future;
        Intrinsics.checkNotNullExpressionValue(r7, "future");
        ConstraintTrackingWorkerKt.access$setFailed(r7);
        return;
    L19:
        WorkManagerImpl r5 = WorkManagerImpl.getInstance(getApplicationContext());
        Intrinsics.checkNotNullExpressionValue(r5, "getInstance(applicationContext)");
        WorkSpecDao r8 = r5.getWorkDatabase().workSpecDao();
        String r9 = getId().toString();
        Intrinsics.checkNotNullExpressionValue(r9, "id.toString()");
        WorkSpec r10 = r8.getWorkSpec(r9);
        if (r10 != null) goto L23;
        SettableFuture<ListenableWorker.Result> r11 = this.future;
        Intrinsics.checkNotNullExpressionValue(r11, "future");
        ConstraintTrackingWorkerKt.access$setFailed(r11);
        return;
    L23:
        Trackers r12 = r5.getTrackers();
        Intrinsics.checkNotNullExpressionValue(r12, "workManagerImpl.trackers");
        WorkConstraintsTrackerImpl r13 = new WorkConstraintsTrackerImpl(r12, this);
        r13.replace(CollectionsKt.listOf(r10));
        String r14 = getId().toString();
        Intrinsics.checkNotNullExpressionValue(r14, "id.toString()");
        if (r13.areAllConstraintsMet(r14) == false) goto L40;
        r1.debug(ConstraintTrackingWorkerKt.access$getTAG$p(), "Constraints met for delegate " + r0);
        ListenableWorker r15 = this.delegate;     // Catch: Throwable -> L28
        Intrinsics.checkNotNull(r15);     // Catch: Throwable -> L28
        final ListenableFuture<ListenableWorker.Result> r16 = r15.startWork();     // Catch: Throwable -> L28
        Intrinsics.checkNotNullExpressionValue(r16, "delegate!!.startWork()");     // Catch: Throwable -> L28
        r16.addListener(new ConstraintTrackingWorker$$ExternalSyntheticLambda1(this, r16), getBackgroundExecutor());     // Catch: Throwable -> L28
        return;
    L28:
        th = move-exception;
        r1.debug(ConstraintTrackingWorkerKt.access$getTAG$p(), "Delegated worker " + r0 + " threw exception in startWork.", th);
        monitor-enter(this.lock);
    L37:
        th = move-exception;
        throw th;
    L32:
        if (this.areConstraintsUnmet == false) goto L34;
        r1.debug(ConstraintTrackingWorkerKt.access$getTAG$p(), "Constraints were unmet, Retrying.");     // Catch: Throwable -> L37
        SettableFuture<ListenableWorker.Result> r17 = this.future;     // Catch: Throwable -> L37
        Intrinsics.checkNotNullExpressionValue(r17, "future");     // Catch: Throwable -> L37
        ConstraintTrackingWorkerKt.access$setRetry(r17);     // Catch: Throwable -> L37
        return;
    L34:
        SettableFuture<ListenableWorker.Result> r18 = this.future;     // Catch: Throwable -> L37
        Intrinsics.checkNotNullExpressionValue(r18, "future");     // Catch: Throwable -> L37
        ConstraintTrackingWorkerKt.access$setFailed(r18);     // Catch: Throwable -> L37
        return;
    L40:
        r1.debug(ConstraintTrackingWorkerKt.access$getTAG$p(), "Constraints not met for delegate " + r0 + ". Requesting retry.");
        SettableFuture<ListenableWorker.Result> r19 = this.future;
        Intrinsics.checkNotNullExpressionValue(r19, "future");
        ConstraintTrackingWorkerKt.access$setRetry(r19);
        return;
    L8:
        if (r2.length() == 0) goto L11;
        r3 = false;
        goto L12
    }

    private static final void setupAndRunConstraintTrackingWork$lambda$2(ConstraintTrackingWorker r2, ListenableFuture r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "$innerFuture");
        Object r0 = r2.lock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (r2.areConstraintsUnmet == false) goto L7;
        SettableFuture<ListenableWorker.Result> r4 = r2.future;     // Catch: Throwable -> L11
        Intrinsics.checkNotNullExpressionValue(r4, "future");     // Catch: Throwable -> L11
        ConstraintTrackingWorkerKt.access$setRetry(r4);     // Catch: Throwable -> L11
    L8:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r0);
        return;
    L7:
        r2.future.setFuture(r3);     // Catch: Throwable -> L11
        goto L8
    }

    @Override // androidx.work.ListenableWorker
    public void onStopped() {
        super.onStopped();
        ListenableWorker r1 = this.delegate;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.isStopped() == true) goto L9;
        r1.stop();
        return;
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsNotMet(List<WorkSpec> r5) {
        Intrinsics.checkNotNullParameter(r5, "workSpecs");
        Logger.get().debug(ConstraintTrackingWorkerKt.access$getTAG$p(), "Constraints changed for " + r5);
        Object r6 = this.lock;
        monitor-enter(r6);
        this.areConstraintsUnmet = true;     // Catch: Throwable -> L8
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r6);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
