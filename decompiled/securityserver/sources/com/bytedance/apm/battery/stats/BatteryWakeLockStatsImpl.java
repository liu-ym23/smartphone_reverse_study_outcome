package com.bytedance.apm.battery.stats;

import android.os.IBinder;
import com.bytedance.apm.battery.BatteryCollector;
import com.bytedance.apm.battery.config.BatteryDetectConfig;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.apm.battery.config.Constants;
import com.bytedance.apm.battery.hook.IHookService;
import com.bytedance.apm.battery.internal.BatteryStatsRet;
import com.bytedance.apm.battery.stats.info.BaseHookInfo;
import com.bytedance.apm.battery.stats.info.WakeLockInfo;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.ExceptionLogData;
import com.bytedance.apm.entity.BatteryLogEntity;
import com.bytedance.apm.perf.CommonDataAssembly;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BatteryWakeLockStatsImpl extends AbsBatteryTimeStats<WakeLockInfo> implements IHookService {
    public BatteryWakeLockStatsImpl() {
        super(BatteryTypeInf.BATTERY_POWER_LOCK);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private void parseAcquireWakeLockArgs(Object[] r5) {
        addHolderCount();
        if (BatteryCollector.getInstance().isEnableTrace() == true) goto L5;
        return;
    L5:
        if (r5.length <= 7) goto L7;
        return;
    L7:
        if (r5.length < 4) goto L37;
        Object r0 = r5[0];
        if (r0 != null) goto L12;
        return;
    L12:
        if ((r0 instanceof IBinder) == false) goto L36;
        int r1 = r0.hashCode();
        if (this.mDetectMap.containsKey(Integer.valueOf(r1)) == true) goto L25;
        WakeLockInfo r2 = new WakeLockInfo();
        Object r3 = r5[1];
        if (r3 != null) goto L18;
        return;
    L18:
        if ((r3 instanceof Integer) == false) goto L30;
        r2.flags = ((Integer) r3).intValue();
        Object r6 = r5[2];
        if (r6 != null) goto L22;
        return;
    L22:
        if ((r6 instanceof String) == false) goto L32;
        r2.tag = (String) r6;
        r2.endTime = -1;
    L28:
        r2.elements = Thread.currentThread().getStackTrace();
        r2.threadName = Thread.currentThread().getName();
        r2.startTime = System.currentTimeMillis();
        this.mDetectMap.put(Integer.valueOf(r1), r2);
        return;
    L32:
        return;
    L30:
        return;
    L25:
        r2 = (WakeLockInfo) this.mDetectMap.get(Integer.valueOf(r1));
        if (r2 != null) goto L28;
        return;
    L36:
        return;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private void parseReleaseWakeLockArgs(Object[] r4) {
        reduceHolderCount();
        if (BatteryCollector.getInstance().isEnableTrace() == true) goto L5;
        return;
    L5:
        if (r4.length == 2) goto L7;
        return;
    L7:
        Object r5 = r4[0];
        if (r5 != null) goto L10;
        return;
    L10:
        if ((r5 instanceof IBinder) == false) goto L17;
        int r6 = r5.hashCode();
        WakeLockInfo r0 = (WakeLockInfo) this.mDetectMap.get(Integer.valueOf(r6));
        if (r0 == null) goto L18;
        r0.endTime = System.currentTimeMillis();
        this.mDetectMap.put(Integer.valueOf(r6), r0);
        return;
    L18:
        return;
    }

    @Override // com.bytedance.apm.battery.hook.IHookService
    public String getInterfaceName() {
        return "android.os.IPowerManager";
    }

    @Override // com.bytedance.apm.battery.hook.IHookService
    public synchronized void invoke(Object r1, Method r2, Object[] r3) {
        monitor-enter(this);
        String r4 = r2.getName();     // Catch: Throwable -> L6 Exception -> L16
        if ("acquireWakeLock".equals(r4) == false) goto L9;
        parseAcquireWakeLockArgs(r3);     // Catch: Throwable -> L6 Exception -> L16
    L17:
        goto L14
    L9:
        if ("releaseWakeLock".equals(r4) == false) goto L17;
        parseReleaseWakeLockArgs(r3);     // Catch: Throwable -> L6 Exception -> L16
    L6:
        th = move-exception;
        throw th;
    L14:
        monitor-exit(this);
    }

    @Override // com.bytedance.apm.battery.stats.AbsBatteryTimeStats
    public void reportAccumulatedIssue(double r5, double r7) {
        if (r5 < BatteryDetectConfig.getMaxTotalWakeLockHoldTimeMs()) goto L5;
        int r1 = 17;
    L7:
        if (r7 < BatteryDetectConfig.getMaxTotalWakeLockAcquireCount()) goto L9;
        r1 = r1 | 18;
    L9:
        if (r1 != 0) goto L23;
        return;
    L23:
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L22
        r2.put(Constants.BATTERY_ISSUE_TYPE, r1).put(Constants.KEY_TOTAL_HOLD_TIME, r5).put(Constants.KEY_TOTAL_ACQUIRE_COUNT, r7);     // Catch: Throwable -> L22
        ConcurrentHashMap<Integer, T> r6 = this.mDetectMap;     // Catch: Throwable -> L22
        if (r6 != 0) goto L14;
    L20:
        CommonDataAssembly.wrapPerfException(r2, "battery_trace");     // Catch: Throwable -> L22
        CommonDataPipeline.getInstance().handle(new ExceptionLogData("battery_trace", r2));     // Catch: Throwable -> L22
        return;
    L14:
        if (r6.size() <= 0) goto L20;
        JSONArray r8 = new JSONArray();     // Catch: Throwable -> L22
        Iterator r4 = this.mDetectMap.values().iterator();     // Catch: Throwable -> L22
    L17:
        if (r4.hasNext() == false) goto L19;
        r8.put(((WakeLockInfo) r4.next()).toJson());     // Catch: Throwable -> L22
        goto L17
    L19:
        r2.put("detail", r8);     // Catch: Throwable -> L22
    L26:
        return;
    L5:
        r1 = 0;
        goto L7
    }

    @Override // com.bytedance.apm.battery.stats.AbsBatteryTimeStats
    public /* bridge */ /* synthetic */ void reportSingleIssue(BaseHookInfo r1, long r2) {
        reportSingleIssue((WakeLockInfo) r1, r2);
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void updateStatsRet(BatteryStatsRet r3, BatteryLogEntity r4) {
        if (getType().equals(r4.type) == true) goto L5;
        return;
    L5:
        if (r4.isFront() == false) goto L7;
        r3.addFrontWakeLockMs(r4.getAccumulation());
        return;
    L7:
        r3.addBackWakeLockMs(r4.getAccumulation());
    }

    public void reportSingleIssue(WakeLockInfo r4, long r5) {
        if (r5 >= BatteryDetectConfig.getMaxSingleWakeLockHoldTimeMs()) goto L8;
        return;
    L8:
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L7
        r0.put("event_type", "battery_trace");     // Catch: JSONException -> L7
        r0.put(Constants.BATTERY_ISSUE_TYPE, 16).put("single_hold_time", r5).put(Constants.KEY_WAKE_LOCK_INFO, r4.toString());     // Catch: JSONException -> L7
        CommonDataAssembly.wrapPerfException(r0, "battery_trace");     // Catch: JSONException -> L7
        CommonDataPipeline.getInstance().handle(new ExceptionLogData("battery_trace", r0));     // Catch: JSONException -> L7
        return;
    }
}
