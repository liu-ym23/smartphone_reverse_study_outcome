package com.bytedance.framwork.core.sdklib;

import android.content.Context;
import com.bytedance.apm.constant.ReportProtocal;
import com.bytedance.framwork.core.sdklib.config.MonitorConfigure;
import com.bytedance.framwork.core.sdklib.model.LocalLog;
import com.bytedance.framwork.core.sdklib.net.DefaultLogSendImpl;
import com.bytedance.framwork.core.sdklib.net.ILogSendImpl;
import com.bytedance.framwork.core.sdklib.net.MonitorLogSender;
import com.bytedance.framwork.core.sdklib.thread.IMonitorTimeTask;
import com.bytedance.framwork.core.sdklib.thread.LogEventManager;
import com.bytedance.framwork.core.sdklib.util.JsonUtil;
import com.bytedance.framwork.core.sdklib.util.ListUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class LogReportManager implements IMonitorTimeTask {
    private static final String TAG = "LogReportManager";
    private String mAid;
    private volatile boolean mCollectLogSwitch;
    private Context mContext;
    private volatile boolean mDropAllDataSwitch;
    private JSONObject mHeaderInfo;
    private int mInterval;
    private long mLastPackTime;
    private LogStoreManager mLogStoreManager;
    private int mReportCount;
    private long mStopCollectInterval;
    private long mStopCollectLogTime;

    @Override // com.bytedance.framwork.core.sdklib.thread.IMonitorTimeTask
    public void onTimeEvent(long r5) {
        long r0 = this.mStopCollectInterval;
        if (r0 > 0) goto L5;
    L7:
        packAndSendLog(false);
        return;
    L5:
        if ((r5 - this.mStopCollectLogTime) <= r0) goto L7;
        restoreCollectDelay();
        goto L7
    }

    public LogReportManager(Context r3, String r4) {
        this.mLastPackTime = 0;
        this.mInterval = 120;
        this.mReportCount = 100;
        this.mCollectLogSwitch = true;
        this.mDropAllDataSwitch = false;
        this.mContext = r3;
        this.mLogStoreManager = LogStoreManager.getInstance(r3);
        this.mAid = r4;
    }

    public void init() {
        LogEventManager.getInstance().addTimeTask(this);
        MonitorLogSender.setImpl(this.mAid, new DefaultLogSendImpl(this.mContext, this.mAid));
    }

    private List<LocalLog> getLogSampled(int r2) {
        int r0 = Integer.parseInt(this.mAid);
        return this.mLogStoreManager.getLogsLimit(r0, r2);
    }

    private long getLogSampledCount() {
        return this.mLogStoreManager.getLogCount(this.mAid);
    }

    public boolean packAndSendLog(boolean r9) {
        if (this.mCollectLogSwitch == true) goto L5;
    L20:
        return true;
    L5:
        if (this.mDropAllDataSwitch == true) goto L20;
        long r2 = System.currentTimeMillis();
        long r4 = getLogSampledCount();
        if (r4 > 0) goto L10;
        return true;
    L10:
        if (r9 == false) goto L12;
    L18:
        this.mLastPackTime = r2;
        return reportOneAidLog();
    L12:
        if (r4 > this.mReportCount) goto L18;
        if (((r2 - this.mLastPackTime) / 1000) > this.mInterval) goto L18;
        return false;
    }

    private int deleteUploadedLogs(long r2) {
        return this.mLogStoreManager.deleteLogs(this.mAid, r2);
    }

    public int deleteAllLogs() {
        return deleteUploadedLogs(2147483647L);
    }

    public boolean reportOneAidLog() {
        List<LocalLog> r0 = getLogSampled(this.mReportCount);
        if (ListUtils.isEmpty(r0) == false) goto L6;
        return true;
    L6:
        boolean r1 = false;
        JSONArray r2 = new JSONArray();     // Catch: Throwable -> L21
        LinkedList r3 = new LinkedList();     // Catch: Throwable -> L21
        Iterator<LocalLog> r4 = r0.iterator();     // Catch: Throwable -> L21
        long r5 = -1;
    L9:
        if (r4.hasNext() == false) goto L16;
        LocalLog r6 = r4.next();     // Catch: Throwable -> L21
        long r7 = r6.id;     // Catch: Throwable -> L21
        if (r7 <= r5) goto L13;
        r5 = r7;
    L13:
        String r9 = r6.data;     // Catch: Throwable -> L21
        r3.add(r6);     // Catch: Throwable -> L21
        JSONObject r8 = new JSONObject(r9);     // Catch: Throwable -> L20
        r8.put(ReportProtocal.KEY_LOG_ID, r7);     // Catch: Throwable -> L20
        r8.put("d_s_t", System.currentTimeMillis());     // Catch: Throwable -> L20
        r2.put(r8);     // Catch: Throwable -> L20
        goto L9
    L16:
        r1 = sendLog(r2, false);     // Catch: Throwable -> L21
        if (r1 == false) goto L19;
        deleteUploadedLogs(r5);     // Catch: Throwable -> L21
    L19:
        return r1;
    }

    private boolean sendLog(JSONArray r3, boolean r4) {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L12
        if (JsonUtil.isEmpty(r3) == false) goto L6;
        return false;
    L6:
        r0.put("data", r3);     // Catch: Throwable -> L12
        JSONObject r5 = this.mHeaderInfo;     // Catch: Throwable -> L12
        if (r5 == null) goto L10;
        r0.put("header", r5);     // Catch: Throwable -> L12
        return MonitorLogSender.send(this.mAid, r0.toString());
    L10:
        return true;
    L12:
        return false;
    }

    public void updateConfig() {
        setReportInterval(MonitorConfigure.getReportInterval(this.mAid));
        setReportCount(MonitorConfigure.getReportCount(this.mAid));
        setHeaderInfo(MonitorConfigure.getReportJsonHeaderInfo(this.mAid));
        ILogSendImpl r1 = MonitorLogSender.getImpl(this.mAid);
        if ((r1 instanceof DefaultLogSendImpl) == false) goto L6;
        ((DefaultLogSendImpl) r1).setLastSuccessChannel(null);
        return;
    }

    private void setReportInterval(int r1) {
        if (r1 > 0) goto L4;
        return;
    L4:
        this.mInterval = r1;
    }

    private void setReportCount(int r1) {
        if (r1 > 0) goto L4;
        return;
    L4:
        this.mReportCount = r1;
    }

    private void setHeaderInfo(JSONObject r1) {
        this.mHeaderInfo = r1;
    }

    public void setCollectDelay(long r3) {
        this.mCollectLogSwitch = false;
        this.mStopCollectLogTime = System.currentTimeMillis();
        this.mStopCollectInterval = r3;
    }

    public void restoreCollectDelay() {
        this.mCollectLogSwitch = true;
        this.mStopCollectInterval = 0;
    }

    public void dropAllData() {
        this.mDropAllDataSwitch = true;
    }
}
