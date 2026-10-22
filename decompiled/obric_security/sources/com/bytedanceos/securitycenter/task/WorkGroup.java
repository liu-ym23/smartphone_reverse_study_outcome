package com.bytedanceos.securitycenter.task;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class WorkGroup implements WorkTask.WorkListener {
    private static final String TAG = "WorkGroup";
    private volatile boolean mIsWorking;
    private List<WorkTask> mTasks;
    private Handler mUiHandler;
    private WorkStatusListener mWorkStatusListener;
    private WorkTask.WorkType mWorkType;

    public interface WorkStatusListener {
        void onAllFinish(WorkTask.WorkType type);

        void onWorkFinish(WorkTask task, WorkTask.WorkType type);
    }

    @Override // com.bytedanceos.securitycenter.task.WorkTask.WorkListener
    public void onWorkStart(WorkTask wk) {
    }

    static /* synthetic */ WorkStatusListener access$000(WorkGroup r0) {
        return r0.mWorkStatusListener;
    }

    static /* synthetic */ WorkTask.WorkType access$100(WorkGroup r0) {
        return r0.mWorkType;
    }

    static /* synthetic */ WorkTask.WorkType access$102(WorkGroup r0, WorkTask.WorkType r1) {
        r0.mWorkType = r1;
        return r1;
    }

    public void setWorkStatusListener(WorkStatusListener listener) {
        this.mWorkStatusListener = listener;
    }

    public WorkGroup() {
        this.mIsWorking = false;
        this.mWorkType = WorkTask.WorkType.NONE;
        this.mUiHandler = new Handler(Looper.getMainLooper());
        this.mTasks = new ArrayList();
    }

    public void startWork(WorkTask.WorkType type) {
        if (this.mIsWorking == false) goto L5;
        return;
    L5:
        this.mWorkType = type;
        this.mIsWorking = true;
        Iterator<WorkTask> r1 = this.mTasks.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        r1.next().excuteTask(type);
        goto L7
    }

    public void addTask(WorkTask task) {
        if (task != null) goto L4;
        return;
    L4:
        if (this.mIsWorking == true) goto L9;
        task.setWorkListener(this);
        this.mTasks.add(task);
        return;
    }

    public void removeTask(WorkTask task) {
        this.mTasks.remove(task);
    }

    public void onCreate(Context context) {
        Iterator<WorkTask> r1 = this.mTasks.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onCreate(context);
        goto L4
    }

    public void onResume() {
        Iterator<WorkTask> r1 = this.mTasks.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onResume();
        goto L4
    }

    public void onPause() {
        Iterator<WorkTask> r1 = this.mTasks.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onPause();
        goto L4
    }

    public void onDestory(Context context) {
        Iterator<WorkTask> r0 = this.mTasks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onDestory(context);
        goto L4
    L6:
        this.mTasks.clear();
        this.mIsWorking = false;
        this.mWorkStatusListener = null;
    }

    public boolean checkFinished() {
        Iterator<WorkTask> r2 = this.mTasks.iterator();
    L4:
        if (r2.hasNext() == false) goto L13;
        WorkTask r0 = r2.next();
        if (r0.isFinished() == true) goto L4;
        OLog.d(TAG, "check task " + r0 + " not finish");
        return false;
    L13:
        return false;
    }

    private boolean isAllFinish() {
        Iterator<WorkTask> r1 = this.mTasks.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        if (r1.next().isFinished() == true) goto L4;
        return false;
    L8:
        return true;
    }

    @Override // com.bytedanceos.securitycenter.task.WorkTask.WorkListener
    public void onWorkFinish(final WorkTask wk) {
        if (this.mWorkType != WorkTask.WorkType.NONE) goto L8;
        WorkStatusListener r0 = this.mWorkStatusListener;
        if (r0 == null) goto L13;
        r0.onWorkFinish(wk, this.mWorkType);
        return;
    L13:
        return;
    L8:
        final boolean r1 = isAllFinish();
        if (r1 == false) goto L11;
        this.mIsWorking = false;
    L11:
        this.mUiHandler.post(new AnonymousClass1(this, wk, r1));
    }
}
