package com.bytedanceos.securitycenter.task;

import android.content.Context;
import com.obric.olog.OLog;
import com.obric.security.cleaner.trashclear.CleanStatusCallBack;
import com.obric.security.cleaner.trashclear.ScanStatusCallBack;
import com.obric.security.cleaner.trashclear.TcTrashClearHelper;
import java.util.Collection;
import java.util.Iterator;
import tmsdk.fg.module.cleanV2.RubbishEntity;
import tmsdk.fg.module.cleanV2.RubbishHolder;

/* JADX INFO: loaded from: classes2.dex */
public class TrashFileWorkTask extends WorkTask {
    private static final int MAX_SCORE = 10;
    private static final int SIZE_MB = 1048576;
    private static final String TAG = "TrashFileWorkTask";
    private CleanStatusCallBack cleanCallBack;
    private Context mContext;
    private int mScore;
    private ScanStatusCallBack scanCallback;
    private TcTrashClearHelper trashClearHelper;

    public TrashFileWorkTask() {
        this.mScore = 0;
        this.scanCallback = new AnonymousClass1(this);
        this.cleanCallBack = new AnonymousClass2(this);
    }

    static /* synthetic */ int access$002(TrashFileWorkTask r0, int r1) {
        r0.mScore = r1;
        return r1;
    }

    static /* synthetic */ int access$100(TrashFileWorkTask r0, long r1) {
        return r0.generateScore(r1);
    }

    @Override // com.bytedanceos.securitycenter.task.WorkTask
    public void onCreate(Context context) {
        this.trashClearHelper = TcTrashClearHelper.getInstance(context, TAG);
        this.mContext = context;
    }

    @Override // com.bytedanceos.securitycenter.task.WorkTask
    public void onDestory(Context context) {
        TcTrashClearHelper r0 = this.trashClearHelper;
        if (r0 == null) goto L6;
        r0.onDestory();
        return;
    }

    private void startScan() {
        if (this.trashClearHelper.canDeepScan() == false) goto L5;
        this.trashClearHelper.deepScan(this.scanCallback, false);
        return;
    L5:
        this.scanCallback.onScanFinished();
    }

    private void startClean() {
        RubbishHolder r0 = this.trashClearHelper.deepScanCallBack.currentRubbish;
        if (r0 == null) goto L6;
        setStatus(this.trashClearHelper.getSoftCacheRubbish());
        setStatus(this.trashClearHelper.getUninstallRubbish());
        setStatus(this.trashClearHelper.getApkRubbish());
        setStatus(this.trashClearHelper.getSystemRubbish());
        this.trashClearHelper.cleanRubbish(r0, this.cleanCallBack);
        return;
    }

    private void setStatus(Collection<RubbishEntity> rubbishList) {
        if (rubbishList == null) goto L10;
        Iterator<RubbishEntity> r1 = rubbishList.iterator();
    L5:
        if (r1.hasNext() == false) goto L17;
        RubbishEntity r2 = r1.next();
        if (r2.isSuggest() == true) goto L8;
        r2.setStatus(0);
        goto L5
    L8:
        r2.setStatus(1);
        goto L5
    L17:
        return;
    }

    public long getTotalSize() {
        return (((getSuggestSize(this.trashClearHelper.getSoftCacheRubbish()) + 0) + getSuggestSize(this.trashClearHelper.getUninstallRubbish())) + getSuggestSize(this.trashClearHelper.getApkRubbish())) + getSuggestSize(this.trashClearHelper.getSystemRubbish());
    }

    public long getSuggestSize(Collection<RubbishEntity> rubbishList) {
        long r0 = 0;
        if (rubbishList == null) goto L10;
        Iterator<RubbishEntity> r4 = rubbishList.iterator();
    L6:
        if (r4.hasNext() == false) goto L10;
        RubbishEntity r5 = r4.next();
        if (r5.isSuggest() == false) goto L6;
        r0 = r0 + r5.getSize();
    L10:
        return r0;
    }

    public boolean hasTrash() {
        if (getTotalSize() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private int generateScore(long size) {
        OLog.d(TAG, "generateScore: size = " + size);
        if (size > 0) goto L7;
        return 0;
    L7:
        if (size >= 209715200) goto L10;
        return 2;
    L10:
        if (size >= 524288000) goto L13;
        return 5;
    L13:
        if (size >= 1073741824) goto L15;
        return 7;
    L15:
        return 10;
    }

    public int getScore() {
        return this.mScore;
    }

    @Override // com.bytedanceos.securitycenter.task.WorkTask
    protected void excute(WorkTask.WorkType type) {
        if (type != WorkTask.WorkType.SCAN) goto L6;
        startScan();
        return;
    L6:
        if (type != WorkTask.WorkType.CLEAN) goto L10;
        startClean();
        return;
    }
}
