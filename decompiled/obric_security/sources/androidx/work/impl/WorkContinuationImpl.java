package androidx.work.impl;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.work.ArrayCreatingInputMerger;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.WorkContinuation;
import androidx.work.WorkInfo;
import androidx.work.WorkRequest;
import androidx.work.impl.utils.EnqueueRunnable;
import androidx.work.impl.utils.StatusRunnable;
import androidx.work.impl.workers.CombineContinuationsWorker;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class WorkContinuationImpl extends WorkContinuation {
    private static final String TAG = null;
    private final List<String> mAllIds;
    private boolean mEnqueued;
    private final ExistingWorkPolicy mExistingWorkPolicy;
    private final List<String> mIds;
    private final String mName;
    private Operation mOperation;
    private final List<WorkContinuationImpl> mParents;
    private final List<? extends WorkRequest> mWork;
    private final WorkManagerImpl mWorkManagerImpl;

    static {
        TAG = Logger.tagWithPrefix("WorkContinuationImpl");
    }

    public WorkManagerImpl getWorkManagerImpl() {
        return this.mWorkManagerImpl;
    }

    public String getName() {
        return this.mName;
    }

    public ExistingWorkPolicy getExistingWorkPolicy() {
        return this.mExistingWorkPolicy;
    }

    public List<? extends WorkRequest> getWork() {
        return this.mWork;
    }

    public List<String> getIds() {
        return this.mIds;
    }

    public List<String> getAllIds() {
        return this.mAllIds;
    }

    public boolean isEnqueued() {
        return this.mEnqueued;
    }

    public void markEnqueued() {
        this.mEnqueued = true;
    }

    public List<WorkContinuationImpl> getParents() {
        return this.mParents;
    }

    public WorkContinuationImpl(WorkManagerImpl workManagerImpl, List<? extends WorkRequest> work) {
        this(workManagerImpl, null, ExistingWorkPolicy.KEEP, work, null);
    }

    public WorkContinuationImpl(WorkManagerImpl workManagerImpl, String name, ExistingWorkPolicy existingWorkPolicy, List<? extends WorkRequest> work) {
        this(workManagerImpl, name, existingWorkPolicy, work, null);
    }

    public WorkContinuationImpl(WorkManagerImpl workManagerImpl, String name, ExistingWorkPolicy existingWorkPolicy, List<? extends WorkRequest> work, List<WorkContinuationImpl> parents) {
        this.mWorkManagerImpl = workManagerImpl;
        this.mName = name;
        this.mExistingWorkPolicy = existingWorkPolicy;
        this.mWork = work;
        this.mParents = parents;
        this.mIds = new ArrayList(work.size());
        this.mAllIds = new ArrayList();
        if (parents == null) goto L8;
        Iterator<WorkContinuationImpl> r1 = parents.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        WorkContinuationImpl r2 = r1.next();
        this.mAllIds.addAll(r2.mAllIds);
    L8:
        int r3 = 0;
    L10:
        if (r3 >= work.size()) goto L12;
        String r4 = work.get(r3).getStringId();
        this.mIds.add(r4);
        this.mAllIds.add(r4);
        r3 = r3 + 1;
        goto L10
    }

    @Override // androidx.work.WorkContinuation
    public WorkContinuation then(List<OneTimeWorkRequest> work) {
        if (work.isEmpty() == false) goto L6;
        return this;
    L6:
        return new WorkContinuationImpl(this.mWorkManagerImpl, this.mName, ExistingWorkPolicy.KEEP, work, Collections.singletonList(this));
    }

    @Override // androidx.work.WorkContinuation
    public LiveData<List<WorkInfo>> getWorkInfosLiveData() {
        return this.mWorkManagerImpl.getWorkInfosById(this.mAllIds);
    }

    @Override // androidx.work.WorkContinuation
    public ListenableFuture<List<WorkInfo>> getWorkInfos() {
        StatusRunnable<List<WorkInfo>> r0 = StatusRunnable.forStringIds(this.mWorkManagerImpl, this.mAllIds);
        this.mWorkManagerImpl.getWorkTaskExecutor().executeOnTaskThread(r0);
        return r0.getFuture();
    }

    @Override // androidx.work.WorkContinuation
    public Operation enqueue() {
        if (this.mEnqueued == true) goto L5;
        EnqueueRunnable r0 = new EnqueueRunnable(this);
        this.mWorkManagerImpl.getWorkTaskExecutor().executeOnTaskThread(r0);
        this.mOperation = r0.getOperation();
    L7:
        return this.mOperation;
    L5:
        Logger.get().warning(TAG, "Already enqueued work ids (" + TextUtils.join(", ", this.mIds) + ")");
        goto L7
    }

    @Override // androidx.work.WorkContinuation
    protected WorkContinuation combineInternal(List<WorkContinuation> continuations) {
        OneTimeWorkRequest r0 = new OneTimeWorkRequest.Builder(CombineContinuationsWorker.class).setInputMerger(ArrayCreatingInputMerger.class).build();
        ArrayList r6 = new ArrayList(continuations.size());
        Iterator<WorkContinuation> r8 = continuations.iterator();
    L4:
        if (r8.hasNext() == false) goto L7;
        r6.add((WorkContinuationImpl) r8.next());
        goto L4
    L7:
        return new WorkContinuationImpl(this.mWorkManagerImpl, null, ExistingWorkPolicy.KEEP, Collections.singletonList(r0), r6);
    }

    public boolean hasCycles() {
        return hasCycles(this, new HashSet());
    }

    private static boolean hasCycles(WorkContinuationImpl continuation, Set<String> visited) {
        visited.addAll(continuation.getIds());
        Set<String> r0 = prerequisitesFor(continuation);
        Iterator<String> r1 = visited.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        if (r0.contains(r1.next()) == false) goto L4;
        return true;
    L8:
        List<WorkContinuationImpl> r2 = continuation.getParents();
        if (r2 != null) goto L11;
    L18:
        visited.removeAll(continuation.getIds());
        return false;
    L11:
        if (r2.isEmpty() == true) goto L18;
        Iterator<WorkContinuationImpl> r3 = r2.iterator();
    L14:
        if (r3.hasNext() == false) goto L18;
        if (hasCycles(r3.next(), visited) == false) goto L14;
        return true;
    }

    public static Set<String> prerequisitesFor(WorkContinuationImpl continuation) {
        HashSet r0 = new HashSet();
        List<WorkContinuationImpl> r2 = continuation.getParents();
        if (r2 != null) goto L5;
    L10:
        return r0;
    L5:
        if (r2.isEmpty() == true) goto L10;
        Iterator<WorkContinuationImpl> r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        r0.addAll(r3.next().getIds());
        goto L8
    }
}
