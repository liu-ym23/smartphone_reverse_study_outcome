package com.bytedanceos.securitycenter.task;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import com.bytedanceos.clearmemory.RunningState;
import com.bytedanceos.clearmemory.RunningStateHelper;
import com.bytedanceos.securitycenter.MainActivityTemp;
import com.bytedanceos.securitycenter.SecurityCenterApplication;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MemoryWorkTask extends WorkTask implements RunningState.OnRefreshUiListener {
    private static final long KEEP_ZERO_DURATION_MS = 300000;
    private static final String KEY_LAST_CLEAN_TIME = "last_clean_time";
    private static final int MAX_SCORE = 5;
    private static final String PREF_NAME = "memory_work_task_prefs";
    private static final int SIZE_MAX = 1073741824;
    private static final String TAG = "MemoryWorkTask";
    private boolean isPause;
    private boolean mCleaned;
    private List<RunningState.MergedItem> mItems;
    private long mLastCleanTime;
    private PackageManager mPackageManager;
    private int mScore;
    private RunningState mState;

    public MemoryWorkTask() {
        this.mScore = 0;
        this.mItems = new ArrayList();
        this.mLastCleanTime = 0;
        this.isPause = false;
    }

    static /* synthetic */ List access$000(MemoryWorkTask r0) {
        return r0.mItems;
    }

    static /* synthetic */ RunningState access$100(MemoryWorkTask r0) {
        return r0.mState;
    }

    static /* synthetic */ void access$200(MemoryWorkTask r0, List r1) {
        r0.filterItems(r1);
    }

    static /* synthetic */ void access$300(MemoryWorkTask r0) {
        r0.generateScore();
    }

    @Override // com.bytedanceos.securitycenter.task.WorkTask
    public void onCreate(Context context) {
        this.mState = RunningState.getInstance(context);
        this.mPackageManager = context.getPackageManager();
        this.mLastCleanTime = SecurityCenterApplication.getContext().getSharedPreferences(PREF_NAME, 0).getLong("last_clean_time", 0);
    }

    @Override // com.bytedanceos.securitycenter.task.WorkTask
    public void onDestory(Context context) {
        this.mItems.clear();
    }

    @Override // com.bytedanceos.securitycenter.task.WorkTask
    public void onResume() {
        this.mState.registListener(this);
        if (this.mCleaned == false) goto L5;
    L7:
        this.isPause = false;
        return;
    L5:
        if (this.isPause == false) goto L7;
        scan();
        goto L7
    }

    @Override // com.bytedanceos.securitycenter.task.WorkTask
    public void onPause() {
        this.mState.unregistListener(this);
        this.isPause = true;
    }

    @Override // com.bytedanceos.securitycenter.task.WorkTask
    protected void excute(WorkTask.WorkType type) {
        if (type != WorkTask.WorkType.SCAN) goto L6;
        scan();
        return;
    L6:
        if (type != WorkTask.WorkType.CLEAN) goto L10;
        clean();
        return;
    }

    private void scan() {
        this.mState.resume();
        this.mState.updateNow();
    }

    private void clean() {
        this.mCleaned = true;     // Catch: Exception -> L12
        this.mState.unregistListener(this);     // Catch: Exception -> L12
        Iterator<RunningState.MergedItem> r1 = this.mItems.iterator();     // Catch: Exception -> L12
    L5:
        if (r1.hasNext() == false) goto L10;
        RunningState.MergedItem r2 = r1.next();     // Catch: Exception -> L12
        r2.enSureTaskPersist(this.mPackageManager);     // Catch: Exception -> L12
        if (r2.mIsTaskPersist == true) goto L5;
        r1.remove();     // Catch: Exception -> L12
        RunningStateHelper.getInstance().stopPackage(r2, true);     // Catch: Exception -> L12
        goto L5
    L10:
        this.mScore = 0;     // Catch: Exception -> L12
        this.mLastCleanTime = System.currentTimeMillis();     // Catch: Exception -> L12
        SecurityCenterApplication.getContext().getSharedPreferences(PREF_NAME, 0).edit().putLong("last_clean_time", this.mLastCleanTime).apply();     // Catch: Exception -> L12
        reportFinish(WorkTask.TaskResult.SUCCESS);     // Catch: Exception -> L12
        return;
    L12:
        reportFinish(WorkTask.TaskResult.FAILED);
    }

    @Override // com.bytedanceos.clearmemory.RunningState.OnRefreshUiListener
    public void onRefreshUi(int what) {
        if (MainActivityTemp.DBG == false) goto L5;
        OLog.d(TAG, "onRefreshUi");
    L5:
        AsyncTask.execute(new AnonymousClass1(this));
    }

    private void filterItems(List<RunningState.MergedItem> mergedItems) {
        if (mergedItems != null) goto L4;
        return;
    L4:
        if (mergedItems.size() < 1) goto L21;
        List<RunningState.MergedItem> r3 = RunningStateHelper.getInstance().mergedPackages(mergedItems);
        if (r3 != null) goto L9;
        return;
    L9:
        Iterator<RunningState.MergedItem> r4 = r3.iterator();
    L11:
        if (r4.hasNext() == false) goto L22;
        RunningState.MergedItem r0 = r4.next();
        r0.updateMergeSizeString(SecurityCenterApplication.getContext());
        r0.enSureTaskPersist(SecurityCenterApplication.getContext().getPackageManager());
        if (r0.mIsRecommendClear == false) goto L11;
        this.mItems.add(r0);
        goto L11
    L22:
        return;
    }

    public boolean hasCanCleanMemory() {
        this.mItems.clear();
        filterItems(this.mState.getCurrentMergedItems());
        if (this.mItems.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public long getTotalSize() {
        Iterator<RunningState.MergedItem> r4 = this.mItems.iterator();
        long r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = r0 + r4.next().mMergeSize;
        goto L4
    L6:
        return r0;
    }

    private void generateScore() {
        if (this.mLastCleanTime > 0) goto L5;
    L8:
        List<RunningState.MergedItem> r0 = this.mItems;
        if (r0 != null) goto L11;
    L27:
        this.mScore = 0;
        return;
    L11:
        if (r0.size() < 1) goto L27;
        Iterator<RunningState.MergedItem> r1 = this.mItems.iterator();
        long r5 = 0;
    L15:
        if (r1.hasNext() == false) goto L18;
        r5 = r5 + r1.next().mMergeSize;
        goto L15
    L18:
        if (r5 > 0) goto L21;
        this.mScore = 0;
        return;
    L21:
        if (r5 <= 1073741824) goto L23;
        this.mScore = 5;
        return;
    L23:
        int r2 = (int) (((r5 * 1.0d) / 1.073741824E9d) * 5.0d);
        this.mScore = r2;
        if (r2 > 0) goto L32;
        this.mScore = 1;
        return;
    L32:
        return;
    L5:
        if ((System.currentTimeMillis() - this.mLastCleanTime) >= 300000) goto L8;
        this.mScore = 0;
    }

    public int getScore() {
        return this.mScore;
    }
}
