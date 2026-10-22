package androidx.work.impl;

import androidx.work.Configuration;
import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.utils.EnqueueUtilsKt;
import androidx.work.impl.utils.futures.SettableFuture;
import com.bytedance.apm.block.trace.MethodCollector;
import com.bytedance.tracing.internal.TracingConstants;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WorkerUpdater.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aD\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002\u001a\u001c\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007\u001a\u0014\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000fH\u0002\u001a\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00010\u001a*\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0000¨\u0006\u001b"}, d2 = {"updateWorkImpl", "Landroidx/work/WorkManager$UpdateResult;", "processor", "Landroidx/work/impl/Processor;", "workDatabase", "Landroidx/work/impl/WorkDatabase;", "configuration", "Landroidx/work/Configuration;", "schedulers", "", "Landroidx/work/impl/Scheduler;", "newWorkSpec", "Landroidx/work/impl/model/WorkSpec;", TracingConstants.KEY_TAGS, "", "", "enqueueUniquelyNamedPeriodic", "Landroidx/work/Operation;", "Landroidx/work/impl/WorkManagerImpl;", "name", "workRequest", "Landroidx/work/WorkRequest;", "failWorkTypeChanged", "", "Landroidx/work/impl/OperationImpl;", "message", "Lcom/google/common/util/concurrent/ListenableFuture;", "work-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class WorkerUpdater {
    public static /* synthetic */ void $r8$lambda$7opHgdrAWKd7YI0k0hRwdd6vZCE(WorkManagerImpl r0, String r1, OperationImpl r2, Function0 r3, WorkRequest r4) {
        enqueueUniquelyNamedPeriodic$lambda$3(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$fcuNShqzP9GQU-gKhYwmv8wgx9E, reason: not valid java name */
    public static /* synthetic */ void m64$r8$lambda$fcuNShqzP9GQUgKhYwmv8wgx9E(WorkDatabase r0, WorkSpec r1, WorkSpec r2, List r3, String r4, Set r5, boolean r6) {
        updateWorkImpl$lambda$1(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void $r8$lambda$togP6mIspgE2lT3K72k5b2EGuZg(SettableFuture r0, WorkManagerImpl r1, WorkRequest r2) {
        updateWorkImpl$lambda$2(r0, r1, r2);
    }

    private static final WorkManager.UpdateResult updateWorkImpl(Processor r9, final WorkDatabase r10, Configuration r11, final List<? extends Scheduler> r12, final WorkSpec r13, final Set<String> r14) {
        final String r5 = r13.id;
        final WorkSpec r3 = r10.workSpecDao().getWorkSpec(r5);
        if (r3 == null) goto L26;
        if (r3.state.isFinished() == false) goto L9;
        return WorkManager.UpdateResult.NOT_APPLIED;
    L9:
        if ((r3.isPeriodic() ^ r13.isPeriodic()) == true) goto L23;
        final boolean r15 = r9.isEnqueued(r5);
        if (r15 == true) goto L16;
        Iterator<T> r0 = r12.iterator();
    L14:
        if (r0.hasNext() == false) goto L16;
        ((Scheduler) r0.next()).cancel(r5);
    L16:
        r10.runInTransaction(new WorkerUpdater$$ExternalSyntheticLambda0(r10, r13, r3, r12, r5, r14, r15));
        if (r15 == true) goto L19;
        Schedulers.schedule(r11, r10, r12);
    L19:
        if (r15 == false) goto L22;
        return WorkManager.UpdateResult.APPLIED_FOR_NEXT_RUN;
    L22:
        return WorkManager.UpdateResult.APPLIED_IMMEDIATELY;
    L23:
        WorkerUpdater$updateWorkImpl$type$1 r16 = WorkerUpdater$updateWorkImpl$type$1.INSTANCE;
        throw new UnsupportedOperationException("Can't update " + r16.invoke(r3) + " Worker to " + r16.invoke(r13) + " Worker. Update operation must preserve worker's type.");
    L26:
        throw new IllegalArgumentException("Worker with " + r5 + " doesn't exist");
    }

    private static final void updateWorkImpl$lambda$1(WorkDatabase r36, WorkSpec r37, WorkSpec r38, List r39, String r40, Set r41, boolean r42) {
        Intrinsics.checkNotNullParameter(r36, "$workDatabase");
        Intrinsics.checkNotNullParameter(r37, "$newWorkSpec");
        Intrinsics.checkNotNullParameter(r38, "$oldWorkSpec");
        Intrinsics.checkNotNullParameter(r39, "$schedulers");
        Intrinsics.checkNotNullParameter(r40, "$workSpecId");
        Intrinsics.checkNotNullParameter(r41, "$tags");
        WorkSpecDao r13 = r36.workSpecDao();
        WorkTagDao r14 = r36.workTagDao();
        r13.updateWorkSpec(EnqueueUtilsKt.wrapInConstraintTrackingWorkerIfNeeded(r39, WorkSpec.copy$default(r37, null, r38.state, null, null, null, null, 0, 0, 0, null, r38.runAttemptCount, null, 0, r38.lastEnqueueTime, 0, 0, false, null, 0, r38.getGeneration() + 1, 515069, null)));
        r14.deleteByWorkSpecId(r40);
        r14.insertTags(r40, r41);
        if (r42 == true) goto L6;
        r13.markWorkSpecScheduled(r40, -1);
        r36.workProgressDao().delete(r40);
        return;
    }

    public static final ListenableFuture<WorkManager.UpdateResult> updateWorkImpl(final WorkManagerImpl r3, final WorkRequest r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "workRequest");
        final SettableFuture r0 = SettableFuture.create();
        r3.getWorkTaskExecutor().getSerialTaskExecutor().execute(new WorkerUpdater$$ExternalSyntheticLambda1(r0, r3, r4));
        Intrinsics.checkNotNullExpressionValue(r0, "future");
        return r0;
    }

    private static final void updateWorkImpl$lambda$2(SettableFuture r7, WorkManagerImpl r8, WorkRequest r9) {
        Intrinsics.checkNotNullParameter(r8, "$this_updateWorkImpl");
        Intrinsics.checkNotNullParameter(r9, "$workRequest");
        if (r7.isCancelled() == false) goto L10;
        return;
    L10:
        Processor r1 = r8.getProcessor();     // Catch: Throwable -> L7
        Intrinsics.checkNotNullExpressionValue(r1, "processor");     // Catch: Throwable -> L7
        WorkDatabase r2 = r8.getWorkDatabase();     // Catch: Throwable -> L7
        Intrinsics.checkNotNullExpressionValue(r2, "workDatabase");     // Catch: Throwable -> L7
        Configuration r3 = r8.getConfiguration();     // Catch: Throwable -> L7
        Intrinsics.checkNotNullExpressionValue(r3, "configuration");     // Catch: Throwable -> L7
        List<Scheduler> r4 = r8.getSchedulers();     // Catch: Throwable -> L7
        Intrinsics.checkNotNullExpressionValue(r4, "schedulers");     // Catch: Throwable -> L7
        r7.set(updateWorkImpl(r1, r2, r3, r4, r9.getWorkSpec(), r9.getTags()));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        r7.setException(th);
    }

    public static final Operation enqueueUniquelyNamedPeriodic(final WorkManagerImpl r9, final String r10, final WorkRequest r11) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r11, "workRequest");
        final OperationImpl r0 = new OperationImpl();
        final Function0<Unit> r5 = new WorkerUpdater$enqueueUniquelyNamedPeriodic$enqueueNew$1(r11, r9, r10, r0);
        r9.getWorkTaskExecutor().getSerialTaskExecutor().execute(new WorkerUpdater$$ExternalSyntheticLambda2(r9, r10, r0, r5, r11));
        return r0;
    }

    private static final void enqueueUniquelyNamedPeriodic$lambda$3(WorkManagerImpl r43, String r44, OperationImpl r45, Function0 r46, WorkRequest r47) {
        Intrinsics.checkNotNullParameter(r43, "$this_enqueueUniquelyNamedPeriodic");
        Intrinsics.checkNotNullParameter(r44, "$name");
        Intrinsics.checkNotNullParameter(r45, "$operation");
        Intrinsics.checkNotNullParameter(r46, "$enqueueNew");
        Intrinsics.checkNotNullParameter(r47, "$workRequest");
        WorkSpecDao r2 = r43.getWorkDatabase().workSpecDao();
        List<WorkSpec.IdAndState> r6 = r2.getWorkSpecIdAndStatesForName(r44);
        if (r6.size() <= 1) goto L6;
        failWorkTypeChanged(r45, "Can't apply UPDATE policy to the chains of work.");
        return;
    L6:
        WorkSpec.IdAndState r7 = (WorkSpec.IdAndState) CollectionsKt.firstOrNull(r6);
        if (r7 != null) goto L10;
        r46.invoke();
        return;
    L10:
        WorkSpec r8 = r2.getWorkSpec(r7.id);
        if (r8 != null) goto L15;
        r45.markState(new Operation.State.FAILURE(new IllegalStateException("WorkSpec with " + r7.id + ", that matches a name \"" + r44 + "\", wasn't found")));
        return;
    L15:
        if (r8.isPeriodic() == true) goto L19;
        failWorkTypeChanged(r45, "Can't update OneTimeWorker to Periodic Worker. Update operation must preserve worker's type.");
        return;
    L19:
        if (r7.state != WorkInfo.State.CANCELLED) goto L22;
        r2.delete(r7.id);
        r46.invoke();
        return;
    L22:
        WorkSpec r41 = WorkSpec.copy$default(r47.getWorkSpec(), r7.id, null, null, null, null, null, 0, 0, 0, null, 0, null, 0, 0, 0, 0, false, null, 0, 0, MethodCollector.METHOD_ID_DISPATCH, null);
        Processor r0 = r43.getProcessor();     // Catch: Throwable -> L25
        Intrinsics.checkNotNullExpressionValue(r0, "processor");     // Catch: Throwable -> L25
        WorkDatabase r3 = r43.getWorkDatabase();     // Catch: Throwable -> L25
        Intrinsics.checkNotNullExpressionValue(r3, "workDatabase");     // Catch: Throwable -> L25
        Configuration r4 = r43.getConfiguration();     // Catch: Throwable -> L25
        Intrinsics.checkNotNullExpressionValue(r4, "configuration");     // Catch: Throwable -> L25
        List<Scheduler> r5 = r43.getSchedulers();     // Catch: Throwable -> L25
        Intrinsics.checkNotNullExpressionValue(r5, "schedulers");     // Catch: Throwable -> L25
        updateWorkImpl(r0, r3, r4, r5, r41, r47.getTags());     // Catch: Throwable -> L25
        r45.markState(Operation.SUCCESS);     // Catch: Throwable -> L25
        return;
    L25:
        th = move-exception;
        r45.markState(new Operation.State.FAILURE(th));
    }

    private static final void failWorkTypeChanged(OperationImpl r2, String r3) {
        r2.markState(new Operation.State.FAILURE(new UnsupportedOperationException(r3)));
    }
}
