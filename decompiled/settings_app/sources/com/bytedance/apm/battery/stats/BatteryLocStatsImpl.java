package com.bytedance.apm.battery.stats;

import android.text.TextUtils;
import com.bytedance.apm.battery.BatteryCollector;
import com.bytedance.apm.battery.config.BatteryDetectConfig;
import com.bytedance.apm.battery.config.Constants;
import com.bytedance.apm.battery.hook.IHookService;
import com.bytedance.apm.battery.internal.BatteryStatsRet;
import com.bytedance.apm.battery.stats.info.BaseHookInfo;
import com.bytedance.apm.battery.stats.info.LocInfo;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.ExceptionLogData;
import com.bytedance.apm.entity.BatteryLogEntity;
import com.bytedance.apm.perf.CommonDataAssembly;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class BatteryLocStatsImpl extends AbsBatteryTimeStats<LocInfo> implements IHookService {
    private List<String> mListenerRecord;

    @Override // com.bytedance.apm.battery.hook.IHookService
    public String getInterfaceName() {
        return "android.location.ILocationManager";
    }

    @Override // com.bytedance.apm.battery.stats.AbsBatteryTimeStats
    protected /* bridge */ /* synthetic */ void reportSingleIssue(BaseHookInfo r1, long r2) {
        reportSingleIssue((LocInfo) r1, r2);
    }

    public BatteryLocStatsImpl() {
        super("location");
        this.mListenerRecord = new ArrayList();
    }

    @Override // com.bytedance.apm.battery.hook.IHookService
    public void invoke(Object r1, Method r2, Object[] r3) {
        String r4 = r2.getName();     // Catch: Exception -> L14
        if (TextUtils.equals(r4, "requestLocationUpdates") == false) goto L6;
        parseRequestArgs(r3);     // Catch: Exception -> L14
    L15:
        return;
    L6:
        if (TextUtils.equals(r4, "registerLocationListener") == false) goto L9;
        parseRequestArgsAbove12(r3);     // Catch: Exception -> L14
        goto L15
    L9:
        if (TextUtils.equals(r4, "removeUpdates") == false) goto L11;
    L12:
        parseRemoveArgs(r3);     // Catch: Exception -> L14
        goto L15
    L11:
        if (TextUtils.equals(r4, "unregisterLocationListener") == false) goto L15;
    }

    private void parseRequestArgs(Object[] r3) {
        if (r3[0] == null) goto L8;
        Object r1 = r3[1];
        if (r1 == null) goto L9;
        recordRequest(r1.hashCode(), r3[0].toString());
        return;
    L9:
        return;
    }

    private void parseRequestArgsAbove12(Object[] r3) {
        if (r3[1] == null) goto L8;
        Object r1 = r3[2];
        if (r1 == null) goto L9;
        recordRequest(r1.hashCode(), r3[1].toString());
        return;
    L9:
        return;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private void recordRequest(int r4, String r5) {
        String r0 = String.valueOf(r4);
        if (this.mListenerRecord.contains(r0) == true) goto L6;
        addHolderCount();
        this.mListenerRecord.add(r0);
    L6:
        if (BatteryCollector.getInstance().isEnableTrace() == false) goto L12;
        LocInfo r1 = (LocInfo) this.mDetectMap.get(Integer.valueOf(r4));
        if (r1 != null) goto L10;
        r1 = new LocInfo();
        r1.request = r5;
    L10:
        r1.startTime = System.currentTimeMillis();
        r1.endTime = -1;
        r1.elements = Thread.currentThread().getStackTrace();
        r1.threadName = Thread.currentThread().getName();
        this.mDetectMap.put(Integer.valueOf(r4), r1);
        return;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private void parseRemoveArgs(Object[] r4) {
        Object r5 = r4[0];
        if (r5 == null) goto L13;
        int r6 = r5.hashCode();
        String r0 = String.valueOf(r6);
        if (this.mListenerRecord.contains(r0) == false) goto L8;
        reduceHolderCount();
        this.mListenerRecord.remove(r0);
    L8:
        if (BatteryCollector.getInstance().isEnableTrace() == false) goto L14;
        LocInfo r1 = (LocInfo) this.mDetectMap.get(Integer.valueOf(r6));
        if (r1 == null) goto L15;
        r1.endTime = System.currentTimeMillis();
        this.mDetectMap.put(Integer.valueOf(r6), r1);
        return;
    L15:
        return;
    L14:
        return;
    }

    protected void reportSingleIssue(LocInfo r4, long r5) {
        if (r5 >= BatteryDetectConfig.getMaxSingleLocRequestTimeMs()) goto L8;
        return;
    L8:
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L7
        r0.put(Constants.BATTERY_ISSUE_TYPE, 32).put("single_hold_time", r5);     // Catch: Throwable -> L7
        JSONArray r6 = new JSONArray();     // Catch: Throwable -> L7
        r6.put(r4.toJson());     // Catch: Throwable -> L7
        r0.put("detail", r6);     // Catch: Throwable -> L7
        CommonDataAssembly.wrapPerfException(r0, "battery_trace");     // Catch: Throwable -> L7
        CommonDataPipeline.getInstance().handle(new ExceptionLogData("battery_trace", r0));     // Catch: Throwable -> L7
        return;
    }

    @Override // com.bytedance.apm.battery.stats.AbsBatteryTimeStats
    void reportAccumulatedIssue(double r5, double r7) {
        if (r5 < BatteryDetectConfig.getMaxTotalLocRequestTimeMs()) goto L5;
        int r1 = 33;
    L7:
        if (r7 < BatteryDetectConfig.getMaxTotalLocRequestCount()) goto L9;
        r1 = r1 | 34;
    L9:
        if (r1 != 0) goto L23;
        return;
    L23:
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L22
        r2.put(Constants.BATTERY_ISSUE_TYPE, r1).put(Constants.KEY_TOTAL_HOLD_TIME, r5).put(Constants.KEY_TOTAL_ACQUIRE_COUNT, r7);     // Catch: Throwable -> L22
        if (this.mDetectMap != null) goto L14;
    L20:
        CommonDataAssembly.wrapPerfException(r2, "battery_trace");     // Catch: Throwable -> L22
        CommonDataPipeline.getInstance().handle(new ExceptionLogData("battery_trace", r2));     // Catch: Throwable -> L22
        return;
    L14:
        if (this.mDetectMap.size() <= 0) goto L20;
        JSONArray r6 = new JSONArray();     // Catch: Throwable -> L22
        Iterator r4 = this.mDetectMap.values().iterator();     // Catch: Throwable -> L22
    L17:
        if (r4.hasNext() == false) goto L19;
        r6.put(((LocInfo) r4.next()).toJson());     // Catch: Throwable -> L22
        goto L17
    L19:
        r2.put("detail", r6);     // Catch: Throwable -> L22
    L26:
        return;
    L5:
        r1 = 0;
        goto L7
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void updateStatsRet(BatteryStatsRet r3, BatteryLogEntity r4) {
        if (getType().equals(r4.type) == true) goto L5;
        return;
    L5:
        if (r4.isFront() == false) goto L7;
        r3.addFrontLocMs(r4.getAccumulation());
        return;
    L7:
        r3.addBackLocMs(r4.getAccumulation());
    }
}
