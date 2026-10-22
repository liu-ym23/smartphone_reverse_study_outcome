package com.bytedance.apm.battery.internal;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.PerfData;
import com.bytedance.apm.logging.DebugLogger;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.perf.CommonDataAssembly;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class BatteryStatsRet {
    private long mBackAlarmCount;
    private long mBackCpuMs;
    private long mBackDuration;
    private long mBackLocMs;
    private long mBackTrafficBytes;
    private long mBackTrafficBytesAllIface;
    private long mBackTrafficPackets;
    private long mBackTrafficPacketsAllIface;
    private long mBackWakeLockMs;
    private long mFrontAlarmCount;
    private long mFrontBatteryConsume;
    private long mFrontCpuMs;
    private long mFrontDuration;
    private long mFrontLocMs;
    private long mFrontTrafficBytes;
    private long mFrontTrafficBytesAllIface;
    private long mFrontTrafficPackets;
    private long mFrontTrafficPacketsAllIface;
    private long mFrontWakeLockMs;
    private boolean mIsCharging;
    private boolean mMainProcess;
    private long mMaxBackDuration;
    private long mMaxFrontDuration;
    private long mProcessBackDuration;
    private long mProcessFrontDuration;
    private String mProcessName;
    private String mScene;
    private String mStartUUID;
    private int mTotalBackAlarmCount;
    private long mTotalBackBytesAllInterface;
    private int mTotalBackCpuMs;
    private int mTotalBackLocMs;
    private long mTotalBackPacketAllInterface;
    private long mTotalBackTrafficBytes;
    private long mTotalBackTrafficPackets;
    private int mTotalBackWakeLockMs;
    private int mTotalFrontAlarmCount;
    private long mTotalFrontBytesAllInterface;
    private int mTotalFrontCpuMs;
    private int mTotalFrontLocMs;
    private long mTotalFrontPacketAllInterface;
    private long mTotalFrontTrafficBytes;
    private long mTotalFrontTrafficPackets;
    private int mTotalFrontWakeLockMs;

    public BatteryStatsRet() {
        this.mFrontCpuMs = 0;
        this.mFrontLocMs = 0;
        this.mFrontWakeLockMs = 0;
        this.mFrontAlarmCount = 0;
        this.mFrontTrafficBytes = 0;
        this.mFrontTrafficPackets = 0;
        this.mFrontTrafficBytesAllIface = 0;
        this.mFrontTrafficPacketsAllIface = 0;
        this.mFrontBatteryConsume = 0;
        this.mBackCpuMs = 0;
        this.mBackLocMs = 0;
        this.mBackWakeLockMs = 0;
        this.mBackAlarmCount = 0;
        this.mBackTrafficBytes = 0;
        this.mBackTrafficPackets = 0;
        this.mBackTrafficBytesAllIface = 0;
        this.mBackTrafficPacketsAllIface = 0;
        this.mMainProcess = true;
        this.mTotalFrontBytesAllInterface = 0;
        this.mTotalFrontPacketAllInterface = 0;
        this.mTotalBackBytesAllInterface = 0;
        this.mTotalBackPacketAllInterface = 0;
    }

    void addBackDuration(long r3) {
        this.mBackDuration += r3;
    }

    public void addBackCpuMs(long r3) {
        this.mBackCpuMs += r3;
    }

    public void addBackWakeLockMs(long r3) {
        this.mBackWakeLockMs += r3;
    }

    public void addBackTrafficBytes(long r3) {
        this.mBackTrafficBytes += r3;
    }

    public void addBackTrafficPackets(long r3) {
        this.mBackTrafficPackets += r3;
    }

    public void addBackBytesAllInterface(long r3) {
        this.mBackTrafficBytesAllIface += r3;
    }

    public void addBackPacketsAllInterface(long r3) {
        this.mBackTrafficPacketsAllIface += r3;
    }

    public void addBackLocMs(long r3) {
        this.mBackLocMs += r3;
    }

    public void addBackWakeUpAlarmCount(long r3) {
        this.mBackAlarmCount += r3;
    }

    void addFrontDuration(long r3) {
        this.mFrontDuration += r3;
    }

    public void addFrontCpuMs(long r3) {
        this.mFrontCpuMs += r3;
    }

    public void addFrontWakeLockMs(long r3) {
        this.mFrontWakeLockMs += r3;
    }

    public void addFrontTrafficBytes(long r3) {
        this.mFrontTrafficBytes += r3;
    }

    public void addFrontTrafficPackets(long r3) {
        this.mFrontTrafficPackets += r3;
    }

    public void addFrontBytesAllInterface(long r3) {
        this.mFrontTrafficBytesAllIface += r3;
    }

    public void addFrontPacketsAllInterface(long r3) {
        this.mFrontTrafficPacketsAllIface += r3;
    }

    public void addFrontLocMs(long r3) {
        this.mFrontLocMs += r3;
    }

    public void addFrontWakeUpAlarmCount(long r3) {
        this.mFrontAlarmCount += r3;
    }

    public void addBatteryConsume(long r3) {
        this.mFrontBatteryConsume += r3;
    }

    public boolean isMainProcess() {
        return this.mMainProcess;
    }

    void setMainProcess(boolean r1) {
        this.mMainProcess = r1;
    }

    void setIsCharging(boolean r1) {
        this.mIsCharging = r1;
    }

    void setProcessName(String r1) {
        this.mProcessName = r1;
    }

    void setStartUUID(String r1) {
        this.mStartUUID = r1;
    }

    void setScene(String r1) {
        this.mScene = r1;
    }

    void clearReportedData() {
        this.mFrontDuration = 0;
        this.mBackDuration = 0;
        this.mFrontCpuMs = 0;
        this.mFrontLocMs = 0;
        this.mFrontWakeLockMs = 0;
        this.mFrontAlarmCount = 0;
        this.mFrontTrafficBytes = 0;
        this.mFrontTrafficPackets = 0;
        this.mFrontTrafficBytesAllIface = 0;
        this.mFrontTrafficPacketsAllIface = 0;
        this.mFrontBatteryConsume = 0;
        this.mBackCpuMs = 0;
        this.mBackLocMs = 0;
        this.mBackWakeLockMs = 0;
        this.mBackAlarmCount = 0;
        this.mBackTrafficBytes = 0;
        this.mBackTrafficPackets = 0;
        this.mBackTrafficBytesAllIface = 0;
        this.mBackTrafficPacketsAllIface = 0;
        this.mMainProcess = true;
        this.mIsCharging = false;
        this.mProcessName = "";
        this.mStartUUID = "";
        this.mScene = "";
    }

    void reportOverallData() {
        this.mFrontAlarmCount = this.mTotalFrontAlarmCount;
        this.mFrontCpuMs = this.mTotalFrontCpuMs;
        this.mFrontLocMs = this.mTotalFrontLocMs;
        this.mFrontWakeLockMs = this.mTotalFrontWakeLockMs;
        this.mFrontDuration = this.mMaxFrontDuration;
        this.mFrontTrafficBytes = this.mTotalFrontTrafficBytes;
        this.mFrontTrafficPackets = this.mTotalFrontTrafficPackets;
        this.mFrontTrafficBytesAllIface = this.mTotalFrontBytesAllInterface;
        this.mFrontTrafficPacketsAllIface = this.mTotalFrontPacketAllInterface;
        this.mBackAlarmCount = this.mTotalBackAlarmCount;
        this.mBackCpuMs = this.mTotalBackCpuMs;
        this.mBackLocMs = this.mTotalBackLocMs;
        this.mBackWakeLockMs = this.mTotalBackWakeLockMs;
        this.mBackDuration = this.mMaxBackDuration;
        this.mBackTrafficBytes = this.mTotalBackTrafficBytes;
        this.mBackTrafficPackets = this.mTotalBackTrafficPackets;
        this.mBackTrafficBytesAllIface = this.mTotalBackBytesAllInterface;
        this.mBackTrafficPacketsAllIface = this.mTotalBackPacketAllInterface;
        this.mMainProcess = false;
        this.mProcessName = "all_process";
        this.mIsCharging = false;
        this.mScene = "";
        report(false);     // Catch: Exception -> L5
        return;
    }

    boolean isFrontDataValid() {
        if (this.mFrontDuration <= 10000) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isBackDataValid() {
        if (this.mBackDuration <= 5000) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean report(boolean r5) throws Exception {
        boolean r6 = compute(r5);
        if (r6 == false) goto L5;
    L7:
        clearReportedData();
        return r6;
    L5:
        if (ApmContext.isDebugMode() == false) goto L7;
        Logger.i(DebugLogger.TAG_BATTERY, new String[]{"stats report failed, processName: " + this.mProcessName});
        goto L7
    }

    public void isProcessOver() {
        long r0 = this.mProcessFrontDuration;
        if (r0 <= this.mMaxFrontDuration) goto L5;
        this.mMaxFrontDuration = r0;
    L5:
        this.mProcessFrontDuration = 0;
        long r2 = this.mProcessBackDuration;
        if (r2 <= this.mMaxBackDuration) goto L8;
        this.mMaxBackDuration = r2;
    L8:
        this.mProcessBackDuration = 0;
    }

    private boolean compute(boolean r10) throws Exception {
        JSONObject r11 = computeAndReturnJSONObject(r10);
        if (r11 != null) goto L6;
        return false;
    L6:
        if (r11.length() != 0) goto L8;
        return true;
    L8:
        JSONObject r4 = new JSONObject();
        r4.put("is_main_process", this.mMainProcess);
        r4.put("process_name", this.mProcessName);
        r4.put("scene", this.mScene);
        r4.put(CommonKey.KEY_IS_CHARGING, this.mIsCharging ? 1 : 0);
        JSONObject r5 = new JSONObject();
        r5.put("sid", this.mStartUUID);
        PerfData r8 = new PerfData("battery", "", r11, r4, r5);
        CommonDataAssembly.wrapFilters(r8, false);
        CommonDataPipeline.getInstance().handle(r8);
        if (ApmContext.isDebugMode() == false) goto L11;
        Logger.i(DebugLogger.TAG_BATTERY, new String[]{"stats report, processName: " + this.mProcessName + " Json:" + r11.toString()});
    L11:
        return true;
    }

    public JSONObject computeAndReturnJSONObject(boolean r24) throws Exception {
        JSONObject r1 = new JSONObject();
        if (isFrontDataValid() == false) goto L31;
        r1.put("front_alarm", this.mFrontAlarmCount);
        r1.put("front_loc_p_time", (this.mFrontLocMs * 1.0f) / 1000.0f);
        r1.put("front_power_p_time", (this.mFrontWakeLockMs * 1.0f) / 1000.0f);
        long r4 = this.mFrontCpuMs;
        if (r4 < 0) goto L8;
        r1.put("front_cpu_active_time_p_time", (r4 * 1.0f) / 1000.0f);
        double r5 = (((this.mFrontAlarmCount * 0.002083333383779973d) + (this.mFrontCpuMs * 6.944444612599909E-5d)) + (this.mFrontLocMs * 7.499999810534064E-6d)) + (this.mFrontWakeLockMs * 6.944444521650439E-6d);
        if (this.mMainProcess == true) goto L14;
        if (r24 == false) goto L14;
    L16:
        if (r5 < 0.0d) goto L18;
        r1.put("front_score", r5);
        r1.put("front_p_time", (this.mFrontDuration * 1.0f) / 1000.0f);
        float r2 = 60000.0f / this.mFrontDuration;
        r1.put("front_alarm_per_min", this.mFrontAlarmCount * r2);
        r1.put("front_loc_per_min_p_time", (this.mFrontLocMs / 1000.0f) * r2);
        r1.put("front_power_per_min_p_time", (this.mFrontWakeLockMs / 1000.0f) * r2);
        r1.put("front_cpu_active_time_per_min_p_time", (this.mFrontCpuMs / 1000.0f) * r2);
        if (this.mMainProcess == true) goto L24;
        if (r24 == false) goto L24;
    L25:
        r1.put("front_score_per_min", r5 * ((double) r2));
        if (this.mMainProcess == false) goto L28;
        r1.put("front_battery_consume", this.mFrontBatteryConsume);
        r1.put("front_battery_consume_per_min", this.mFrontBatteryConsume * r2);
    L28:
        if (r24 == false) goto L31;
        this.mTotalFrontAlarmCount = (int) (((long) this.mTotalFrontAlarmCount) + this.mFrontAlarmCount);
        this.mTotalFrontCpuMs = (int) (((long) this.mTotalFrontCpuMs) + this.mFrontCpuMs);
        this.mTotalFrontLocMs = (int) (((long) this.mTotalFrontLocMs) + this.mFrontLocMs);
        this.mTotalFrontWakeLockMs = (int) (((long) this.mTotalFrontWakeLockMs) + this.mFrontWakeLockMs);
        this.mProcessFrontDuration += this.mFrontDuration;
        this.mTotalFrontTrafficBytes += this.mFrontTrafficBytes;
        this.mTotalFrontTrafficPackets += this.mFrontTrafficPackets;
        this.mTotalFrontBytesAllInterface += this.mFrontTrafficBytesAllIface;
        this.mTotalFrontPacketAllInterface += this.mFrontTrafficPacketsAllIface;
    L24:
        r1.put("front_traffic_per_min_p_capacity", (this.mFrontTrafficBytes / 1024.0f) * r2);
        r1.put("front_traffic_packets_per_min", this.mFrontTrafficPackets * r2);
        r1.put("front_traffic_all_iface_per_min", ((this.mFrontTrafficBytesAllIface * 1.0f) / 1024.0f) * r2);
        r1.put("front_traffic_packets_all_iface_per_min", this.mFrontTrafficPacketsAllIface * r2);
        goto L25
    L18:
        if (ApmContext.isDebugMode() == false) goto L20;
        Logger.w(DebugLogger.TAG_BATTERY, new String[]{" report data invalid, frontScore < 0 : " + r5});
    L20:
        return null;
    L14:
        r1.put("front_traffic_all_iface", (this.mFrontTrafficBytesAllIface * 1.0f) / 1024.0f);
        r1.put("front_traffic_packets_all_iface", this.mFrontTrafficPacketsAllIface);
        r1.put("front_traffic_p_capacity", (this.mFrontTrafficBytes * 1.0f) / 1024.0f);
        r1.put("front_traffic_packets", this.mFrontTrafficPackets);
        r5 = r5 + (this.mFrontTrafficBytes * 2.6666666030905617E-7d);
        goto L16
    L8:
        if (ApmContext.isDebugMode() == false) goto L10;
        Logger.w(DebugLogger.TAG_BATTERY, new String[]{" report data invalid, frontCpuMs < 0 : " + this.mFrontCpuMs});
    L10:
        return null;
    L31:
        if (isBackDataValid() == false) goto L50;
        r1.put("back_alarm", this.mBackAlarmCount);
        r1.put("back_loc_p_time", (this.mBackLocMs * 1.0f) / 1000.0f);
        r1.put("back_power_p_time", (this.mBackWakeLockMs * 1.0f) / 1000.0f);
        long r6 = this.mBackCpuMs;
        if (r6 < 0) goto L36;
        r1.put("back_cpu_active_time_p_time", (r6 * 1.0f) / 1000.0f);
        double r3 = (((this.mBackAlarmCount * 0.002083333383779973d) + (this.mBackCpuMs * 6.944444612599909E-5d)) + (this.mBackLocMs * 7.499999810534064E-6d)) + (this.mBackWakeLockMs * 6.944444521650439E-6d);
        if (this.mMainProcess == true) goto L42;
        if (r24 == false) goto L42;
    L43:
        r1.put("back_score", r3);
        r1.put("back_p_time", (this.mBackDuration * 1.0f) / 1000.0f);
        float r7 = 60000.0f / this.mBackDuration;
        r1.put("back_alarm_per_min", this.mBackAlarmCount * r7);
        r1.put("back_loc_per_min_p_time", (this.mBackLocMs / 1000.0f) * r7);
        r1.put("back_power_per_min_p_time", (this.mBackWakeLockMs / 1000.0f) * r7);
        r1.put("back_cpu_active_time_per_min_p_time", (this.mBackCpuMs / 1000.0f) * r7);
        if (this.mMainProcess == true) goto L46;
        if (r24 == false) goto L46;
    L47:
        r1.put("back_score_per_min", r3 * ((double) r7));
        if (r24 == false) goto L50;
        this.mTotalBackAlarmCount = (int) (((long) this.mTotalBackAlarmCount) + this.mBackAlarmCount);
        this.mTotalBackCpuMs = (int) (((long) this.mTotalBackCpuMs) + this.mBackCpuMs);
        this.mTotalBackLocMs = (int) (((long) this.mTotalBackLocMs) + this.mBackLocMs);
        this.mTotalBackWakeLockMs = (int) (((long) this.mTotalBackWakeLockMs) + this.mBackWakeLockMs);
        this.mProcessBackDuration += this.mBackDuration;
        this.mTotalBackBytesAllInterface += this.mBackTrafficBytesAllIface;
        this.mTotalBackPacketAllInterface += this.mBackTrafficPacketsAllIface;
        this.mTotalBackTrafficBytes += this.mBackTrafficBytes;
        this.mTotalBackTrafficPackets += this.mBackTrafficPackets;
    L46:
        r1.put("back_traffic_all_iface_per_min", ((this.mBackTrafficBytesAllIface * 1.0f) / 1024.0f) * r7);
        r1.put("back_traffic_packets_all_iface_per_min", this.mBackTrafficPacketsAllIface * r7);
        r1.put("back_traffic_per_min_p_capacity", (this.mBackTrafficBytes / 1024.0f) * r7);
        r1.put("back_traffic_packets_per_min", this.mBackTrafficPackets * r7);
    L42:
        r1.put("back_traffic_all_iface", (this.mBackTrafficBytesAllIface * 1.0f) / 1024.0f);
        r1.put("back_traffic_packets_all_iface", this.mBackTrafficPacketsAllIface);
        r1.put("back_traffic_p_capacity", (this.mBackTrafficBytes * 1.0f) / 1024.0f);
        r1.put("back_traffic_packets", this.mBackTrafficPackets);
        r3 = r3 + (this.mBackTrafficBytes * 2.6666666030905617E-7d);
        goto L43
    L36:
        if (ApmContext.isDebugMode() == false) goto L38;
        Logger.w(DebugLogger.TAG_BATTERY, new String[]{" report data invalid, mBackCpuMs < 0 : " + this.mBackCpuMs});
    L38:
        return null;
    L50:
        return r1;
    }
}
