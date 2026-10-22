package androidx.work.impl.utils;

import android.text.TextUtils;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.WorkRequest;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.model.Dependency;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkName;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class EnqueueRunnable implements Runnable {
    private static final String TAG = null;
    private final OperationImpl mOperation;
    private final WorkContinuationImpl mWorkContinuation;

    static {
        TAG = Logger.tagWithPrefix("EnqueueRunnable");
    }

    public EnqueueRunnable(WorkContinuationImpl workContinuation) {
        this(workContinuation, new OperationImpl());
    }

    public EnqueueRunnable(WorkContinuationImpl workContinuation, OperationImpl result) {
        this.mWorkContinuation = workContinuation;
        this.mOperation = result;
    }

    @Override // java.lang.Runnable
    public void run() {
    L11:
        th = move-exception;
        this.mOperation.markState(new Operation.State.FAILURE(th));
        return;
    L4:
        if (this.mWorkContinuation.hasCycles() == true) goto L10;
        if (addToDatabase() == false) goto L8;
        PackageManagerHelper.setComponentEnabled(this.mWorkContinuation.getWorkManagerImpl().getApplicationContext(), RescheduleReceiver.class, true);     // Catch: Throwable -> L11
        scheduleWorkInBackground();     // Catch: Throwable -> L11
    L8:
        this.mOperation.markState(Operation.SUCCESS);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IllegalStateException("WorkContinuation has cycles (" + this.mWorkContinuation + ")");     // Catch: Throwable -> L11
    }

    public Operation getOperation() {
        return this.mOperation;
    }

    public boolean addToDatabase() {
        WorkDatabase r0 = this.mWorkContinuation.getWorkManagerImpl().getWorkDatabase();
        r0.beginTransaction();
        boolean r1 = processContinuation(this.mWorkContinuation);     // Catch: Throwable -> L6
        r0.setTransactionSuccessful();     // Catch: Throwable -> L6
        r0.endTransaction();
        return r1;
    L6:
        th = move-exception;
        r0.endTransaction();
        throw th;
    }

    public void scheduleWorkInBackground() {
        WorkManagerImpl r2 = this.mWorkContinuation.getWorkManagerImpl();
        Schedulers.schedule(r2.getConfiguration(), r2.getWorkDatabase(), r2.getSchedulers());
    }

    private static boolean processContinuation(WorkContinuationImpl workContinuation) {
        List<WorkContinuationImpl> r0 = workContinuation.getParents();
        boolean r1 = false;
        if (r0 == null) goto L12;
        Iterator<WorkContinuationImpl> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L12;
        WorkContinuationImpl r3 = r2.next();
        if (r3.isEnqueued() == false) goto L9;
        Logger.get().warning(TAG, "Already enqueued work ids (" + TextUtils.join(", ", r3.getIds()) + ")");
        goto L6
    L9:
        r1 = r1 | processContinuation(r3);
    L12:
        return enqueueContinuation(workContinuation) | r1;
    }

    private static boolean enqueueContinuation(WorkContinuationImpl workContinuation) {
        Set<String> r0 = WorkContinuationImpl.prerequisitesFor(workContinuation);
        boolean r1 = enqueueWorkWithPrerequisites(workContinuation.getWorkManagerImpl(), workContinuation.getWork(), (String[]) r0.toArray(new String[0]), workContinuation.getName(), workContinuation.getExistingWorkPolicy());
        workContinuation.markEnqueued();
        return r1;
    }

    private static boolean enqueueWorkWithPrerequisites(WorkManagerImpl workManagerImpl, List<? extends WorkRequest> workList, String[] prerequisiteIds, String name, ExistingWorkPolicy existingWorkPolicy) {
        String[] r0 = prerequisiteIds;
        long r3 = System.currentTimeMillis();
        WorkDatabase r5 = workManagerImpl.getWorkDatabase();
        if (r0 != null) goto L5;
    L7:
        boolean r8 = false;
    L8:
        if (r8 == false) goto L26;
        int r9 = r0.length;
        boolean r11 = true;
        int r10 = 0;
        boolean r12 = false;
        boolean r13 = false;
    L10:
        if (r10 >= r9) goto L27;
        String r14 = r0[r10];
        WorkSpec r15 = r5.workSpecDao().getWorkSpec(r14);
        if (r15 == null) goto L13;
        WorkInfo.State r16 = r15.state;
        if (r16 != WorkInfo.State.SUCCEEDED) goto L18;
        boolean r17 = true;
    L19:
        r11 = r11 & r17;
        if (r16 != WorkInfo.State.FAILED) goto L23;
        r13 = true;
    L25:
        r10 = r10 + 1;
        goto L10
    L23:
        if (r16 != WorkInfo.State.CANCELLED) goto L25;
        r12 = true;
        goto L25
    L18:
        r17 = false;
        goto L19
    L13:
        Logger.get().error(TAG, "Prerequisite " + r14 + " doesn't exist; not enqueuing");
        return false;
    L27:
        boolean r18 = !TextUtils.isEmpty(name);
        if (r18 == false) goto L31;
        if (r8 == true) goto L31;
        boolean r19 = true;
    L32:
        if (r19 == false) goto L87;
        List<WorkSpec.IdAndState> r110 = r5.workSpecDao().getWorkSpecIdAndStatesForName(name);
        if (r110.isEmpty() == true) goto L87;
        if (existingWorkPolicy != ExistingWorkPolicy.APPEND) goto L38;
    L57:
        DependencyDao r20 = r5.dependencyDao();
        List r111 = new ArrayList();
        Iterator<WorkSpec.IdAndState> r112 = r110.iterator();
    L59:
        if (r112.hasNext() == false) goto L75;
        WorkSpec.IdAndState r113 = r112.next();
        if (r20.hasDependents(r113.id) == true) goto L59;
        if (r113.state != WorkInfo.State.SUCCEEDED) goto L65;
        boolean r6 = true;
    L66:
        boolean r7 = r6 & r11;
        if (r113.state != WorkInfo.State.FAILED) goto L70;
        r13 = true;
    L72:
        r111.add(r113.id);
        r11 = r7;
        goto L59
    L70:
        if (r113.state != WorkInfo.State.CANCELLED) goto L72;
        r12 = true;
        goto L72
    L65:
        r6 = false;
        goto L66
    L75:
        if (existingWorkPolicy != ExistingWorkPolicy.APPEND_OR_REPLACE) goto L83;
        if (r12 == true) goto L78;
        if (r13 == false) goto L83;
    L78:
        WorkSpecDao r2 = r5.workSpecDao();
        Iterator<WorkSpec.IdAndState> r21 = r2.getWorkSpecIdAndStatesForName(name).iterator();
    L80:
        if (r21.hasNext() == false) goto L82;
        r2.delete(r21.next().id);
        goto L80
    L82:
        r111 = Collections.emptyList();
        r12 = false;
        r13 = false;
    L83:
        r0 = (String[]) r111.toArray(r0);
        if (r0.length <= 0) goto L86;
        r8 = true;
        goto L87
    L86:
        r8 = false;
        goto L87
    L38:
        if (existingWorkPolicy == ExistingWorkPolicy.APPEND_OR_REPLACE) goto L57;
        if (existingWorkPolicy != ExistingWorkPolicy.KEEP) goto L52;
        Iterator<WorkSpec.IdAndState> r4 = r110.iterator();
    L44:
        if (r4.hasNext() == false) goto L52;
        WorkSpec.IdAndState r114 = r4.next();
        if (r114.state == WorkInfo.State.ENQUEUED) goto L51;
        if (r114.state != WorkInfo.State.RUNNING) goto L44;
    L51:
        return false;
    L52:
        CancelWorkRunnable.forName(name, workManagerImpl, false).run();
        WorkSpecDao r22 = r5.workSpecDao();
        Iterator<WorkSpec.IdAndState> r115 = r110.iterator();
    L54:
        if (r115.hasNext() == false) goto L56;
        r22.delete(r115.next().id);
        goto L54
    L56:
        boolean r23 = true;
    L88:
        Iterator<? extends WorkRequest> r24 = workList.iterator();
    L90:
        if (r24.hasNext() == false) goto L112;
        WorkRequest r25 = r24.next();
        WorkSpec r116 = r25.getWorkSpec();
        if (r8 == false) goto L99;
        if (r11 == true) goto L99;
        if (r13 == false) goto L96;
        r116.state = WorkInfo.State.FAILED;
    L101:
        if (r116.state != WorkInfo.State.ENQUEUED) goto L103;
        r23 = true;
    L103:
        r5.workSpecDao().insertWorkSpec(EnqueueUtilsKt.wrapInConstraintTrackingWorkerIfNeeded(workManagerImpl.getSchedulers(), r116));
        if (r8 == false) goto L108;
        int r117 = r0.length;
        int r118 = 0;
    L106:
        if (r118 >= r117) goto L108;
        String[] r119 = r0;
        r5.dependencyDao().insertDependency(new Dependency(r25.getStringId(), r0[r118]));
        r118 = r118 + 1;
        r23 = r23;
        r0 = r119;
    L108:
        String[] r120 = r0;
        boolean r121 = r23;
        r5.workTagDao().insertTags(r25.getStringId(), r25.getTags());
        if (r18 == false) goto L111;
        r5.workNameDao().insert(new WorkName(name, r25.getStringId()));
    L111:
        r23 = r121;
        r0 = r120;
        goto L90
    L96:
        if (r12 == false) goto L98;
        r116.state = WorkInfo.State.CANCELLED;
        goto L101
    L98:
        r116.state = WorkInfo.State.BLOCKED;
    L99:
        r116.lastEnqueueTime = r3;
        goto L101
    L112:
        return r23;
    L87:
        r23 = false;
    L31:
        r19 = false;
        goto L32
    L26:
        r11 = true;
        r12 = false;
        r13 = false;
        goto L27
    L5:
        if (r0.length <= 0) goto L7;
        r8 = true;
        goto L8
    }
}
