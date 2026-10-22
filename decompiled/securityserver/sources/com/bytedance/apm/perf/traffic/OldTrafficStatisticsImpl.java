package com.bytedance.apm.perf.traffic;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.monitor.util.IoUtil;
import com.bytedance.platform.godzilla.common.Constant;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class OldTrafficStatisticsImpl implements ITrafficStatistics {
    private List<String> mFileDataList;
    private long mLastReadTs;
    private volatile long mMobileBackBytes;
    private volatile long mMobileBackPackets;
    private volatile long mMobileFrontBytes;
    private volatile long mMobileFrontPackets;
    private File mProcFile;
    private volatile long mWifiBackBytes;
    private volatile long mWifiBackPackets;
    private volatile long mWifiFrontBytes;
    private volatile long mWifiFrontPackets;

    public OldTrafficStatisticsImpl() {
        this.mFileDataList = new CopyOnWriteArrayList();
        this.mLastReadTs = -1;
        this.mWifiBackBytes = 0;
        this.mMobileBackBytes = 0;
        this.mWifiFrontBytes = 0;
        this.mMobileFrontBytes = 0;
        this.mWifiBackPackets = 0;
        this.mMobileBackPackets = 0;
        this.mWifiFrontPackets = 0;
        this.mMobileFrontPackets = 0;
    }

    private void readFile2List() {
        if (this.mProcFile != null) goto L5;
        return;
    L5:
        BufferedReader r0 = null;
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L17
        BufferedReader r2 = new BufferedReader(new InputStreamReader(new FileInputStream(this.mProcFile), Constant.CHARSET_UTF_8));     // Catch: Throwable -> L17
        int r3 = 1;
    L26:
        String r4 = r2.readLine();     // Catch: Throwable -> L12
        if (r4 == null) goto L15;
        if (r3 < 0) goto L14;
        r1.add(r4);     // Catch: Throwable -> L12
    L14:
        r3 = r3 + 1;     // Catch: Throwable -> L12
        goto L26
    L15:
        this.mFileDataList.clear();     // Catch: Throwable -> L12
        this.mFileDataList.addAll(r1);     // Catch: Throwable -> L12
        IoUtil.safeClose(r2);
        return;
    L12:
        th = th;
        r0 = r2;
    L24:
        th.printStackTrace();     // Catch: Throwable -> L21
        IoUtil.safeClose(r0);
        return;
    L21:
        th = move-exception;
        IoUtil.safeClose(r0);
        throw th;
    L17:
        th = th;
        goto L24
    }

    private void updateNetData() {
        OldTrafficStatisticsImpl this = this;
        if ((System.currentTimeMillis() - this.mLastReadTs) >= 1000) goto L5;
        return;
    L5:
        this.mLastReadTs = System.currentTimeMillis();
        int r1 = Process.myUid();
        readFile2List();
        if (ListUtils.isEmpty(this.mFileDataList) == false) goto L8;
        return;
    L8:
        Iterator<String> r2 = this.mFileDataList.iterator();
        long r3 = 0;
        long r5 = 0;
        long r7 = 0;
        long r9 = 0;
        long r11 = 0;
        long r13 = 0;
        long r15 = 0;
        long r19 = 0;
    L10:
        if (r2.hasNext() == false) goto L46;
        r2 = r2;
        long r23 = r15;
        String[] r4 = r2.next().split(" ");
    L40:
        int r32 = r1;
        long r34 = r5;
    L42:
        long r6 = r23;
    L43:
        r15 = r6;
    L44:
        r5 = r34;
    L45:
        r1 = r32;
        goto L10
    L13:
        if (TextUtils.equals(r4[3], "uid_tag_int") == true) goto L14;
        if (r1 != Integer.parseInt(r4[3])) goto L41;
        long r16 = Long.parseLong(r4[5]);     // Catch: Exception -> L40
        long r25 = Long.parseLong(r4[6]);     // Catch: Exception -> L40
        long r27 = Long.parseLong(r4[7]);     // Catch: Exception -> L40
        long r29 = Long.parseLong(r4[8]);     // Catch: Exception -> L40
        r32 = r1;
        if (Long.valueOf(r4[4]).longValue() != 1) goto L28;
        r34 = r5;
        if (r4[1].startsWith("rmnet_data") == false) goto L26;
        r11 = r11 + (r27 + r16);     // Catch: Exception -> L50
        r13 = r13 + (r29 + r25);     // Catch: Exception -> L50
    L31:
        if (Long.valueOf(r4[4]).longValue() == 0) goto L57;
    L39:
        r6 = r23;
        goto L43
    L57:
        if (r4[1].startsWith("rmnet_data") == false) goto L35;
        r7 = (r27 + r16) + r7;
        r15 = (r29 + r25) + r23;
        goto L44
    L35:
        r6 = r23;
        if (r4[1].startsWith("wlan") == false) goto L43;
        long r0 = (r27 + r16) + r34;
        r19 = (r29 + r25) + r19;
        r15 = r6;
        r5 = r0;
        goto L45
    L26:
        if (r4[1].startsWith("wlan") == false) goto L31;
        r9 = r9 + (r27 + r16);     // Catch: Exception -> L50
        r3 = r3 + (r29 + r25);     // Catch: Exception -> L50
        goto L31
    L28:
        r34 = r5;
        goto L31
    L41:
        r32 = r1;
        r34 = r5;
        goto L42
    L14:
        r15 = r23;
        goto L10
    L46:
        long r8 = r5;
        this.mWifiBackBytes = r8;
        this.mMobileBackBytes = r7;
        this.mWifiFrontBytes = r9;
        this.mMobileFrontBytes = r11;
        this.mWifiBackPackets = r19;
        this.mMobileBackPackets = r15;
        this.mWifiFrontPackets = r3;
        this.mMobileFrontPackets = r13;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getBackBytes() {
        long r0 = getMobileBackBytes();
        return getWifiBackBytes() + r0;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getBackPackets() {
        updateNetData();
        return this.mMobileBackPackets + this.mWifiBackPackets;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getFrontBytes() {
        long r0 = getMobileFrontBytes();
        return getWifiFrontBytes() + r0;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getFrontPackets() {
        updateNetData();
        return this.mMobileFrontPackets + this.mWifiFrontPackets;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getMobileBackBytes() {
        updateNetData();
        return this.mMobileBackBytes;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getMobileBytes() {
        long r0 = getMobileBackBytes();
        return getMobileFrontBytes() + r0;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getMobileFrontBytes() {
        updateNetData();
        return this.mMobileFrontBytes;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getTotalBytes() {
        long r0 = getMobileBytes();
        return getWifiBytes() + r0;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getWifiBackBytes() {
        updateNetData();
        return this.mWifiBackBytes;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getWifiBytes() {
        long r0 = getWifiBackBytes();
        return getWifiFrontBytes() + r0;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public long getWifiFrontBytes() {
        updateNetData();
        return this.mWifiFrontBytes;
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public void init() {
        this.mProcFile = new File("/proc/net/xt_qtaguid/stats");
    }

    @Override // com.bytedance.apm.perf.traffic.ITrafficStatistics
    public void onStatusChange(boolean r1) {
    }
}
