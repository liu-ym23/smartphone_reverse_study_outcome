package androidx.work.impl.utils;

import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkSpecDao;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public abstract class CancelWorkRunnable implements Runnable {
    private final OperationImpl mOperation;

    abstract void runInternal();

    public CancelWorkRunnable() {
        this.mOperation = new OperationImpl();
    }

    public Operation getOperation() {
        return this.mOperation;
    }

    @Override // java.lang.Runnable
    public void run() {
        runInternal();     // Catch: Throwable -> L4
        this.mOperation.markState(Operation.SUCCESS);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        this.mOperation.markState(new Operation.State.FAILURE(th));
    }

    void cancel(WorkManagerImpl workManagerImpl, String workSpecId) {
        iterativelyCancelWorkAndDependents(workManagerImpl.getWorkDatabase(), workSpecId);
        workManagerImpl.getProcessor().stopAndCancelWork(workSpecId);
        Iterator<Scheduler> r1 = workManagerImpl.getSchedulers().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().cancel(workSpecId);
        goto L4
    }

    void reschedulePendingWorkers(WorkManagerImpl workManagerImpl) {
        Schedulers.schedule(workManagerImpl.getConfiguration(), workManagerImpl.getWorkDatabase(), workManagerImpl.getSchedulers());
    }

    private void iterativelyCancelWorkAndDependents(WorkDatabase workDatabase, String workSpecId) {
        WorkSpecDao r3 = workDatabase.workSpecDao();
        DependencyDao r4 = workDatabase.dependencyDao();
        LinkedList r0 = new LinkedList();
        r0.add(workSpecId);
    L4:
        if (r0.isEmpty() == true) goto L11;
        String r5 = (String) r0.remove();
        WorkInfo.State r1 = r3.getState(r5);
        if (r1 == WorkInfo.State.SUCCEEDED) goto L10;
        if (r1 == WorkInfo.State.FAILED) goto L10;
        r3.setState(WorkInfo.State.CANCELLED, r5);
    L10:
        r0.addAll(r4.getDependentWorkIds(r5));
        goto L4
    }

    public static CancelWorkRunnable forId(final UUID id, final WorkManagerImpl workManagerImpl) {
        return new AnonymousClass1(workManagerImpl, id);
    }

    public static CancelWorkRunnable forTag(final String tag, final WorkManagerImpl workManagerImpl) {
        return new AnonymousClass2(workManagerImpl, tag);
    }

    public static CancelWorkRunnable forName(final String name, final WorkManagerImpl workManagerImpl, final boolean allowReschedule) {
        return new AnonymousClass3(workManagerImpl, name, allowReschedule);
    }

    public static CancelWorkRunnable forAll(final WorkManagerImpl workManagerImpl) {
        return new AnonymousClass4(workManagerImpl);
    }
}
