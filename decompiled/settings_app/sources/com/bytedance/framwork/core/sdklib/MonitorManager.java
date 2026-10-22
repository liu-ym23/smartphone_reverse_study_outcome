package com.bytedance.framwork.core.sdklib;

import android.content.Context;
import com.bytedance.framwork.core.sdklib.model.LocalLog;
import com.bytedance.framwork.core.sdklib.thread.AsyncEventManager;
import com.bytedance.framwork.core.sdklib.thread.IMonitorTimeTask;
import com.bytedance.framwork.core.sdklib.util.ListUtils;
import java.util.LinkedList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class MonitorManager implements IMonitorTimeTask {
    private static final int MAX_QUEUE_SIZE = 200;
    private static final String TAG = "MonitorManager";
    private final int WAIT_INSERT_DB_LOG_SIZE;
    private final int WAIT_INSERT_DB_TIME;
    private String mAid;
    private long mLastInsertDBTime;
    private LogStoreManager mLogStoreManager;
    private final LinkedList<LocalLog> mPendingQueue;
    private boolean mStopCollect;

    public MonitorManager(Context r3, String r4) {
        this.mPendingQueue = new LinkedList();
        this.WAIT_INSERT_DB_LOG_SIZE = 5;
        this.mLastInsertDBTime = 0;
        this.WAIT_INSERT_DB_TIME = 120000;
        this.mStopCollect = false;
        this.mLogStoreManager = LogStoreManager.getInstance(r3);
        this.mAid = r4;
    }

    public void init() {
        AsyncEventManager.getInstance().addTimeTask(this);
    }

    public void logSend(String r9, String r10, JSONObject r11) {
        if (this.mStopCollect == true) goto L8;
        if (r11 == null) goto L9;
        enqueue(new LocalLog(this.mAid, r9, r10, r11.toString(), System.currentTimeMillis()));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.framwork.core.sdklib.thread.IMonitorTimeTask
    public void onTimeEvent(long r2) {
        if (this.mStopCollect == true) goto L6;
        processPendingQueue(r2, false);
        return;
    }

    protected void enqueue(LocalLog r4) {
        if (this.mPendingQueue.size() < 200) goto L5;
        processPendingQueue(System.currentTimeMillis(), true);
    L5:
        this.mPendingQueue.add(r4);
    }

    public boolean processPendingQueue(long r5, boolean r7) {
        int r0 = this.mPendingQueue.size();
        if (r0 <= 0) goto L21;
        if (r7 == false) goto L6;
    L9:
        this.mLastInsertDBTime = r5;
        LinkedList<LocalLog> r6 = this.mPendingQueue;
        monitor-enter(r6);
        LinkedList r8 = new LinkedList(this.mPendingQueue);     // Catch: Throwable -> L18
        this.mPendingQueue.clear();     // Catch: Throwable -> L18
        monitor-exit(r6);     // Catch: Throwable -> L18
        if (ListUtils.isEmpty(r8) == true) goto L28;
        this.mLogStoreManager.insertLocalLogBatch(this.mAid, r8);     // Catch: Exception -> L23
        return true;
    L29:
        return true;
    L28:
        return true;
    L18:
        th = move-exception;
        throw th;
    L6:
        if (r0 >= 5) goto L9;
        if ((r5 - this.mLastInsertDBTime) > 120000) goto L9;
        return false;
    L21:
        return false;
    }

    public void clearBufferQueue() {
        LinkedList<LocalLog> r0 = this.mPendingQueue;
        monitor-enter(r0);
        this.mPendingQueue.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setStopCollect(boolean r1) {
        this.mStopCollect = r1;
    }
}
