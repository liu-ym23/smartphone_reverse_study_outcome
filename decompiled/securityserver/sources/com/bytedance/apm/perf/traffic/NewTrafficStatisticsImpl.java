package com.bytedance.apm.perf.traffic;

import a.a;
import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm6.util.log.Logger;

/* JADX INFO: loaded from: classes.dex */
public class NewTrafficStatisticsImpl implements ITrafficStatistics {
    private static final long FOREVER_TIMESTAMP = 4611686018427387903L;
    private static final long ONE_SECOND_IN_MILLS = 1000;
    private static final String TAG = "NewTrafficStatisticsImp";
    private boolean initialized;
    private volatile boolean mIsFront;
    private volatile long mLastCheckTs;
    private volatile long mMobileBackBytes;
    private volatile long mMobileBackPackets;
    private volatile long mMobileFrontBytes;
    private volatile long mMobileFrontPackets;
    private volatile long[] mMobileNetInfo;
    private NetworkStatsManager mNetworkStatsManager;
    private volatile long mWifiBackBytes;
    private volatile long mWifiBackPackets;
    private volatile long mWifiFrontBytes;
    private volatile long mWifiFrontPackets;
    private volatile long[] mWifiNetInfo;
    private int sUid;

    public NewTrafficStatisticsImpl() {
        this.initialized = false;
        this.mWifiBackBytes = 0;
        this.mMobileBackBytes = 0;
        this.mWifiFrontBytes = 0;
        this.mMobileFrontBytes = 0;
        this.mWifiBackPackets = 0;
        this.mMobileBackPackets = 0;
        this.mWifiFrontPackets = 0;
        this.mMobileFrontPackets = 0;
        this.mLastCheckTs = -1;
        this.mIsFront = true;
        this.sUid = -1;
    }

    public static /* synthetic */ void access$000(NewTrafficStatisticsImpl r0) {
        r0.initTrafficData();
    }

    public static /* synthetic */ void access$100(NewTrafficStatisticsImpl r0) {
        r0.updateNetData();
    }

    public static /* synthetic */ boolean access$202(NewTrafficStatisticsImpl r0, boolean r1) {
        r0.mIsFront = r1;
        return r1;
    }

    private int getAppUid(@NonNull Context r3) {
        if (this.sUid != (-1)) goto L12;
        PackageManager r0 = r3.getApplicationContext().getPackageManager();
        PackageInfo r4 = r0.getPackageInfo(r3.getApplicationContext().getPackageName(), 128);     // Catch: PackageManager.NameNotFoundException -> L9
        if (r4 == null) goto L12;
        this.sUid = r4.applicationInfo.uid;     // Catch: PackageManager.NameNotFoundException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
    L12:
        return this.sUid;
    }

    @RequiresApi(api = 23)
    private long[] getPeriodNetBytesFromNetworkStatsManager(long r16, long r18, int r20) {
        Context r3 = ApmContext.getContext();
        if (this.mNetworkStatsManager != null) goto L5;
        this.mNetworkStatsManager = (NetworkStatsManager) r3.getApplicationContext().getSystemService("netstats");
    L5:
        long r4 = 0;
        if (this.mNetworkStatsManager == null) goto L8;
        NetworkStats.Bucket r6 = new NetworkStats.Bucket();
        NetworkStats r0 = this.mNetworkStatsManager.querySummary(r20, null, r16, r18);     // Catch: Exception -> L12
    L11:
        long r7 = 0;
        long r9 = 0;
        long r11 = 0;
    L14:
        if (r0 == null) goto L20;
        if (r0.hasNextBucket() == false) goto L20;
        r0.getNextBucket(r6);
        if (getAppUid(r3) != r6.getUid()) goto L14;
        long r13 = r6.getRxBytes() + r4;
        long r5 = r6.getTxBytes() + r7;
        long r8 = r6.getRxPackets() + r9;
        r11 = r6.getTxPackets() + r11;
        r9 = r8;
        r7 = r5;
        r4 = r13;
    L20:
        if (r0 == null) goto L23;
        r0.close();
    L23:
        return new long[]{r4 + r7, r9 + r11};
    L12:
        e = move-exception;
        e.printStackTrace();
        r0 = null;
        goto L11
    L8:
        return new long[]{0, 0};
    }

    @RequiresApi(api = 23)
    @WorkerThread
    private void initTrafficData() {
        if (this.initialized == false) goto L5;
        return;
    L5:
        this.initialized = true;
        this.mWifiNetInfo = getPeriodNetBytesFromNetworkStatsManager(0, FOREVER_TIMESTAMP, 1);
        this.mMobileNetInfo = getPeriodNetBytesFromNetworkStatsManager(0, FOREVER_TIMESTAMP, 0);
        this.mLastCheckTs = SystemClock.elapsedRealtime();
        if (ApmContext.isDebugMode() == false) goto L9;
        Logger.d(TAG, "initTrafficData: mTotalWifiBytes:" + this.mWifiNetInfo[0] + " mTotalWifiPackets:" + this.mWifiNetInfo[1] + " mTotalMobileBytes:" + this.mMobileNetInfo[0] + " mTotalMobilePackets:" + this.mMobileNetInfo[1]);
        return;
    }

    @RequiresApi(api = 23)
    private void updateNetData() {
        long r7 = SystemClock.elapsedRealtime();
        if ((r7 - this.mLastCheckTs) >= 1000) goto L5;
        return;
    L5:
        if (this.mLastCheckTs == (-1)) goto L21;
        long[] r9 = getPeriodNetBytesFromNetworkStatsManager(0, FOREVER_TIMESTAMP, 1);
        long[] r0 = getPeriodNetBytesFromNetworkStatsManager(0, FOREVER_TIMESTAMP, 0);
        long r2 = r0[0] - this.mMobileNetInfo[0];
        long r10 = r0[1] - this.mMobileNetInfo[1];
        this.mMobileNetInfo = r0;
        long r12 = r9[0] - this.mWifiNetInfo[0];
        long r14 = r9[1] - this.mWifiNetInfo[1];
        this.mWifiNetInfo = r9;
        if (ApmContext.isDebugMode() == false) goto L10;
        String r1 = "mTotalWifiBytes:" + this.mWifiNetInfo[0] + " mTotalWifiPackets:" + this.mWifiNetInfo[1] + " mTotalMobileBytes:" + this.mMobileNetInfo[0] + " mTotalMobilePackets:" + this.mMobileNetInfo[1];
        String r3 = TAG;
        Logger.d(r3, r1);
    L12:
        if (this.mIsFront == false) goto L14;
        this.mMobileFrontBytes += r2;
        this.mMobileFrontPackets += r10;
        this.mWifiFrontBytes += r12;
        this.mWifiFrontPackets += r14;
    L16:
        if (ApmContext.isDebugMode() == false) goto L18;
        StringBuilder r4 = a.s("periodWifiBytes", r12, " periodMobileBytes:");
        r4.append(r2);
        r4.append(" mMobileBackBytes:");
        r4.append(this.mMobileBackBytes);
        r4.append(" mWifiBackBytes:");
        r4.append(this.mWifiBackBytes);
        Logger.d(r3, r4.toString());
    L18:
        this.mLastCheckTs = r7;
        return;
    L14:
        this.mMobileBackBytes += r2;
        this.mMobileBackPackets += r10;
        this.mWifiBackBytes += r12;
        this.mWifiBackPackets += r14;
        goto L16
    L10:
        r3 = TAG;
        goto L12
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    @RequiresApi(api = 23)
    public long getBackBytes() {
        updateNetData();
        return this.mMobileBackBytes + this.mWifiBackBytes;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    @RequiresApi(api = 23)
    public long getBackPackets() {
        updateNetData();
        return this.mMobileBackPackets + this.mWifiBackPackets;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    @RequiresApi(api = 23)
    public long getFrontBytes() {
        updateNetData();
        return this.mMobileFrontBytes + this.mWifiFrontBytes;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    @RequiresApi(api = 23)
    public long getFrontPackets() {
        updateNetData();
        return this.mMobileFrontPackets + this.mWifiFrontPackets;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    @RequiresApi(api = 23)
    public long getMobileBackBytes() {
        updateNetData();
        return this.mMobileBackBytes;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    @RequiresApi(api = 23)
    public long getMobileBytes() {
        updateNetData();
        return this.mMobileBackBytes + this.mMobileFrontBytes;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    @RequiresApi(api = 23)
    public long getMobileFrontBytes() {
        updateNetData();
        return this.mMobileFrontBytes;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    @RequiresApi(api = 23)
    public long getTotalBytes() {
        long r0 = getMobileBytes();
        return getWifiBytes() + r0;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    @RequiresApi(api = 23)
    public long getWifiBackBytes() {
        updateNetData();
        return this.mWifiBackBytes;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    @RequiresApi(api = 23)
    public long getWifiBytes() {
        updateNetData();
        return this.mWifiBackBytes + this.mWifiFrontBytes;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    @RequiresApi(api = 23)
    public long getWifiFrontBytes() {
        updateNetData();
        return this.mWifiFrontBytes;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    @RequiresApi(api = 23)
    public void init() {
        if (AsyncEventManager.getInstance().inWorkThread() == false) goto L5;
        initTrafficData();
        return;
    L5:
        AsyncEventManager.getInstance().post(new AnonymousClass1(this));
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    @RequiresApi(api = 23)
    public void onStatusChange(final boolean r3) {
        AsyncEventManager.getInstance().forcePost(new AnonymousClass2(this, r3));
    }
}
