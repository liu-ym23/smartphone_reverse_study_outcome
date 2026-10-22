package com.bytedance.framwork.core.sdklib.net;

import android.content.Context;
import com.bytedance.framwork.core.sdklog.LogHandler;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;

/* JADX INFO: loaded from: classes.dex */
public class DefaultLogSendImpl implements ILogSendImpl {
    private boolean isCollect;
    String mAid;
    Context mContext;
    volatile long mDelayTime;
    LogHandler mLogHandler;
    String mLogType;
    boolean mMoreChannelSwitch;
    int mNetFailCount;
    String mRedirectHost;
    int mShortFailCount;
    volatile long mShortStopInterval;
    int mStatusCode;
    volatile long mStopInterval;

    @Override // com.bytedance.framwork.core.sdklib.net.ILogSendImpl
    public boolean logStopCollectSwitch() {
        return false;
    }

    static /* synthetic */ long access$000(DefaultLogSendImpl r2) {
        return r2.getDelayTime();
    }

    static /* synthetic */ void access$100(DefaultLogSendImpl r0, String r1) {
        r0.changeHost(r1);
    }

    static /* synthetic */ void access$200(DefaultLogSendImpl r0) {
        r0.restore();
    }

    static /* synthetic */ void access$300(DefaultLogSendImpl r0, long r1) {
        r0.delayReport(r1);
    }

    static /* synthetic */ void access$400(DefaultLogSendImpl r0) {
        r0.dropData();
    }

    static /* synthetic */ void access$500(DefaultLogSendImpl r0) {
        r0.recoveryFromDropData();
    }

    static /* synthetic */ void access$600(DefaultLogSendImpl r0) {
        r0.dropAllData();
    }

    static /* synthetic */ void access$700(DefaultLogSendImpl r0) {
        r0.longBackOff();
    }

    static /* synthetic */ void access$800(DefaultLogSendImpl r0) {
        r0.shortBackOff();
    }

    public DefaultLogSendImpl(Context r8, final String r9) {
        this.isCollect = true;
        this.mAid = r9;
        this.mContext = r8;
        final LogHandler.BaseConfig r4 = new AnonymousClass1(this, r9);
        final LogHandler.IResponseConfig r5 = new AnonymousClass2(this, r9);
        final Context r3 = r8.getApplicationContext();
        this.mLogHandler = new AnonymousClass3(this, r3, r4, r5, r9);
    }

    private void longBackOff() {
        if (this.isCollect == true) goto L5;
        return;
    L5:
        int r0 = this.mNetFailCount;
        if (r0 != 0) goto L8;
        this.mStopInterval = 300000;
        this.mNetFailCount++;
    L14:
        SDKMonitorUtils.getInstance(this.mAid).setCollectDelay(this.mStopInterval);
        return;
    L8:
        if (r0 != 1) goto L11;
        this.mStopInterval = 900000;
        this.mNetFailCount++;
        goto L14
    L11:
        if (r0 != 2) goto L13;
        this.mStopInterval = 1800000;
        this.mNetFailCount++;
        goto L14
    L13:
        this.mStopInterval = 1800000;
        this.mNetFailCount++;
        goto L14
    }

    private void shortBackOff() {
        if (this.isCollect == true) goto L5;
        return;
    L5:
        int r0 = this.mShortFailCount;
        if (r0 != 0) goto L8;
        this.mShortStopInterval = 30000;
        this.mShortFailCount++;
    L17:
        SDKMonitorUtils.getInstance(this.mAid).setCollectDelay(this.mShortStopInterval);
        return;
    L8:
        if (r0 != 1) goto L11;
        this.mShortStopInterval = 60000;
        this.mShortFailCount++;
        goto L17
    L11:
        if (r0 != 2) goto L14;
        this.mShortStopInterval = 120000;
        this.mShortFailCount++;
        goto L17
    L14:
        if (r0 != 3) goto L16;
        this.mShortStopInterval = 240000;
        this.mShortFailCount++;
        goto L17
    L16:
        this.mShortStopInterval = 300000;
        this.mShortFailCount++;
        goto L17
    }

    private void restore() {
        if (this.isCollect == true) goto L5;
        return;
    L5:
        SDKMonitorUtils.getInstance(this.mAid).restoreCollectDelay();
        SDKMonitorUtils.getInstance(this.mAid).setStopCollect(false);
        this.mNetFailCount = 0;
        this.mStopInterval = 0;
        this.mShortFailCount = 0;
        this.mShortStopInterval = 0;
        this.mDelayTime = 0;
    }

    private void dropData() {
        if (this.isCollect == true) goto L5;
        return;
    L5:
        longBackOff();
        SDKMonitorUtils.getInstance(this.mAid).setStopCollect(true);
    }

    private void recoveryFromDropData() {
        if (this.isCollect == true) goto L5;
        return;
    L5:
        SDKMonitorUtils.getInstance(this.mAid).setStopCollect(false);
    }

    private void dropAllData() {
        if (this.isCollect == true) goto L5;
        return;
    L5:
        longBackOff();
        SDKMonitorUtils.getInstance(this.mAid).setStopCollect(true);
        SDKMonitorUtils.getInstance(this.mAid).deleteAllLogs();
        SDKMonitorUtils.getInstance(this.mAid).dropAllData();
    }

    private void changeHost(String r2) {
        if (this.isCollect == true) goto L5;
        return;
    L5:
        this.mRedirectHost = r2;
    }

    private void delayReport(long r3) {
        if (this.isCollect == true) goto L5;
        return;
    L5:
        this.mDelayTime = r3 * 1000;
        SDKMonitorUtils.getInstance(this.mAid).setCollectDelay(this.mDelayTime);
    }

    private long getDelayTime() {
        if (this.isCollect == true) goto L7;
        return 0;
    L7:
        if (this.mStopInterval <= this.mShortStopInterval) goto L9;
        long r0 = this.mStopInterval;
    L11:
        if (r0 <= this.mDelayTime) goto L14;
        return r0;
    L14:
        return this.mDelayTime;
    L9:
        r0 = this.mShortStopInterval;
        goto L11
    }

    @Override // com.bytedance.framwork.core.sdklib.net.ILogSendImpl
    public boolean send(String r1) {
        return this.mLogHandler.enqueue(r1);
    }

    public void setLastSuccessChannel(String r1) {
        this.mLogHandler.setLastSuccessChannel(r1);
    }
}
