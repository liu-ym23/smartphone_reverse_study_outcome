package com.bytedance.apm.battery.stats;

import android.app.PendingIntent;
import com.bytedance.apm.battery.BatteryCollector;
import com.bytedance.apm.battery.config.BatteryDetectConfig;
import com.bytedance.apm.battery.config.Constants;
import com.bytedance.apm.battery.hook.IHookService;
import com.bytedance.apm.battery.internal.BatteryDataManager;
import com.bytedance.apm.battery.internal.BatteryStatsRet;
import com.bytedance.apm.battery.stats.info.AlarmInfo;
import com.bytedance.apm.battery.stats.info.BaseHookInfo;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.ExceptionLogData;
import com.bytedance.apm.entity.BatteryLogEntity;
import com.bytedance.apm.perf.CommonDataAssembly;
import com.bytedance.apm.util.IntentUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BatteryAlarmStatsImpl extends AbsHookStatsTask<AlarmInfo> implements IHookService {
    private final Object lock;
    private List<Long> mGroundChangeList;
    private int mIndex;
    private int mNormalAlarmTriggerCnt;
    private final List<Long> mTmpList;
    private int[] mWakeUpAlarmTriggerCnt;

    public BatteryAlarmStatsImpl() {
        super("alarm");
        this.mGroundChangeList = new ArrayList();
        this.lock = new Object();
        this.mTmpList = new ArrayList();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private void parseRemoveAlarmArgs(Object[] r6) {
        Object r7 = r6[0];
        if (r7 != null) goto L5;
    L7:
        int r8 = -1;
    L8:
        AlarmInfo r0 = (AlarmInfo) this.mDetectMap.get(Integer.valueOf(r8));
        if (r0 != null) goto L11;
        return;
    L11:
        if (r0.interval <= 0) goto L15;
        r0.endTime = System.currentTimeMillis();
        this.mDetectMap.put(Integer.valueOf(r8), r0);
        return;
    L15:
        return;
    L5:
        if ((r7 instanceof PendingIntent) == false) goto L7;
        r8 = r7.hashCode();
        goto L8
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private void parseSetAlarmArgs(Object[] r10) {
        AlarmInfo r0 = new AlarmInfo();
        int r1 = r10.length;
        int r2 = 0;
        boolean r4 = false;
        int r5 = 0;
        int r6 = -1;
    L3:
        if (r2 >= r1) goto L20;
        Object r7 = r10[r2];
        if ((r7 instanceof Integer) == false) goto L9;
        if (r4 == true) goto L9;
        r0.type = ((Integer) r7).intValue();
        r4 = true;
    L19:
        r2 = r2 + 1;
    L9:
        if ((r7 instanceof Long) == false) goto L17;
        if (r5 != 0) goto L13;
        r0.startTime = ((Long) r7).longValue();
        r0.startTime = r0.getUTCTriggerAtMillis();
    L15:
        r5 = r5 + 1;
        goto L19
    L13:
        if (r5 != 2) goto L15;
        r0.interval = ((Long) r7).longValue();
        goto L15
    L17:
        if ((r7 instanceof PendingIntent) == false) goto L19;
        PendingIntent r8 = (PendingIntent) r7;
        r0.intentInfo = IntentUtils.parsePendingIntent(r8);
        r6 = r8.hashCode();
        goto L19
    L20:
        if (r6 != (-1)) goto L22;
        return;
    L22:
        if (r0.interval != 0) goto L24;
        long r3 = r0.startTime;
    L25:
        r0.endTime = r3;
        if (BatteryCollector.getInstance().isEnableTrace() == false) goto L28;
        r0.threadName = Thread.currentThread().getName();
        r0.elements = Thread.currentThread().getStackTrace();
    L28:
        this.mDetectMap.put(Integer.valueOf(r6), r0);
        return;
    L24:
        r3 = -1;
        goto L25
    }

    private void record(int[] r14, int r15) {
        long r9 = System.currentTimeMillis();
        if (this.mIsFront == false) goto L7;
        if ((r15 % 2) != 0) goto L7;
    L10:
        BatteryDataManager.getInstance().record(new BatteryLogEntity(false, r9, getType(), this.mIsCharging, r14[0], null));
        BatteryDataManager.getInstance().record(new BatteryLogEntity(true, r9, getType(), this.mIsCharging, r14[1], null));
        return;
    L7:
        if (this.mIsFront == false) goto L9;
    L11:
        BatteryDataManager.getInstance().record(new BatteryLogEntity(true, r9, getType(), this.mIsCharging, r14[0], null));
        BatteryDataManager.getInstance().record(new BatteryLogEntity(false, r9, getType(), this.mIsCharging, r14[1], null));
        return;
    L9:
        if ((r15 % 2) != 1) goto L11;
        goto L10
    }

    private void reportIssue() {
        long r1 = System.currentTimeMillis();
        int[] r3 = this.mWakeUpAlarmTriggerCnt;
        int r4 = 0;
        double r5 = (((((double) r3[0]) + ((double) r3[1])) / (r1 - this.mLastPollingTime)) * 60000.0d) * 10.0d;
        double r11 = ((((double) this.mNormalAlarmTriggerCnt) / (r1 - this.mLastPollingTime)) * 60000.0d) * 10.0d;
        if (r5 < BatteryDetectConfig.getMaxWakeUpAlarmInvokeCount()) goto L6;
        r4 = 49;
    L6:
        if (r11 < BatteryDetectConfig.getMaxNormalAlarmInvokeCount()) goto L8;
        r4 = r4 | 50;
    L8:
        if (r4 != 0) goto L22;
        return;
    L22:
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L21
        r2.put(Constants.BATTERY_ISSUE_TYPE, r4).put(Constants.KEY_WAKE_UP_COUNT, r5).put(Constants.KEY_NORMAL_COUNT, r11);     // Catch: Throwable -> L21
        ConcurrentHashMap<Integer, T> r6 = this.mDetectMap;     // Catch: Throwable -> L21
        if (r6 != 0) goto L13;
    L19:
        CommonDataAssembly.wrapPerfException(r2, "battery_trace");     // Catch: Throwable -> L21
        CommonDataPipeline.getInstance().handle(new ExceptionLogData("battery_trace", r2));     // Catch: Throwable -> L21
        return;
    L13:
        if (r6.size() <= 0) goto L19;
        JSONArray r7 = new JSONArray();     // Catch: Throwable -> L21
        Iterator r15 = this.mDetectMap.values().iterator();     // Catch: Throwable -> L21
    L16:
        if (r15.hasNext() == false) goto L18;
        r7.put(((AlarmInfo) r15.next()).toJson());     // Catch: Throwable -> L21
        goto L16
    L18:
        r2.put("detail", r7);     // Catch: Throwable -> L21
    }

    @Override // com.bytedance.apm.battery.stats.AbsHookStatsTask
    public /* bridge */ /* synthetic */ void checkStats(BaseHookInfo r1, long r2, long r4) {
        checkStats((AlarmInfo) r1, r2, r4);
    }

    @Override // com.bytedance.apm.battery.hook.IHookService
    public String getInterfaceName() {
        return "android.app.IAlarmManager";
    }

    @Override // com.bytedance.apm.battery.hook.IHookService
    public void invoke(Object r1, Method r2, Object[] r3) {
        String r4 = r2.getName();     // Catch: Exception -> L9
        if ("set".equals(r4) == false) goto L6;
        parseSetAlarmArgs(r3);     // Catch: Exception -> L9
    L10:
        return;
    L6:
        if ("remove".equals(r4) == false) goto L10;
        parseRemoveAlarmArgs(r3);     // Catch: Exception -> L9
    }

    @Override // com.bytedance.apm.battery.stats.AbsHookStatsTask, com.bytedance.apm.battery.stats.IBatteryStats
    public void onBack(boolean r3) {
        super.onBack(r3);
        long r0 = System.currentTimeMillis();
        Object r4 = this.lock;
        monitor-enter(r4);
        this.mGroundChangeList.add(Long.valueOf(r0));     // Catch: Throwable -> L7
        monitor-exit(r4);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void onChargeStatusChange(boolean r1, boolean r2) {
        this.mIsCharging = r1;
    }

    @Override // com.bytedance.apm.battery.stats.AbsHookStatsTask, com.bytedance.apm.battery.stats.IBatteryStats
    public void onFront(boolean r3) {
        super.onFront(r3);
        long r0 = System.currentTimeMillis();
        Object r4 = this.lock;
        monitor-enter(r4);
        this.mGroundChangeList.add(Long.valueOf(r0));     // Catch: Throwable -> L7
        monitor-exit(r4);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.battery.stats.AbsHookStatsTask
    public void pollingTask(long r8, long r10, boolean r12) {
        this.mNormalAlarmTriggerCnt = 0;
        this.mWakeUpAlarmTriggerCnt = new int[2];
        this.mTmpList.add(Long.valueOf(r8));
        Object r9 = this.lock;
        monitor-enter(r9);
        this.mTmpList.addAll(this.mGroundChangeList);     // Catch: Throwable -> L15
        this.mGroundChangeList.clear();     // Catch: Throwable -> L15
        monitor-exit(r9);     // Catch: Throwable -> L15
        this.mTmpList.add(Long.valueOf(r10));
        this.mIndex = 1;
    L8:
        if (this.mIndex >= this.mTmpList.size()) goto L10;
        super.pollingTask(this.mTmpList.get(this.mIndex - 1).longValue(), this.mTmpList.get(this.mIndex).longValue(), r12);
        this.mIndex++;
        goto L8
    L10:
        int[] r11 = this.mWakeUpAlarmTriggerCnt;
        if ((r11[0] + r11[1]) == 0) goto L13;
        record(r11, this.mTmpList.size());
    L13:
        this.mTmpList.clear();
        reportIssue();
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void startSceneMonitor(String r1, boolean r2) {
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void stopSceneMonitor(String r1, boolean r2) {
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void updateStatsRet(BatteryStatsRet r3, BatteryLogEntity r4) {
        if (getType().equals(r4.type) == true) goto L6;
        return;
    L6:
        if (r4.isBack() == false) goto L8;
        r3.addBackWakeUpAlarmCount(r4.getAccumulation());
        return;
    L8:
        r3.addFrontWakeUpAlarmCount(r4.getAccumulation());
    }

    public void checkStats(AlarmInfo r11, long r12, long r14) {
        long r0 = r11.interval;
        int r5 = 1;
        if (r0 > 0) goto L10;
        long r1 = r11.startTime;
        if (r12 <= r1) goto L7;
        return;
    L7:
        if (r1 <= r14) goto L23;
        return;
    L23:
        if (r11.isWakeUpAlarm() == false) goto L25;
        int[] r13 = this.mWakeUpAlarmTriggerCnt;
        int r10 = this.mIndex % 2;
        r13[r10] = r13[r10] + r5;
        return;
    L25:
        this.mNormalAlarmTriggerCnt += r5;
        return;
    L10:
        long r6 = r11.startTime;
        if (r6 >= r12) goto L13;
        r6 = (r12 + r0) - ((r12 - r6) % r0);
    L13:
        long r15 = r11.endTime;
        if (r15 <= r14) goto L16;
    L19:
        long r16 = r14 - r6;
        if (r16 <= 0) goto L28;
        r5 = 1 + ((int) (r16 / r0));
        goto L23
    L28:
        return;
    L16:
        if (r15 <= 0) goto L19;
        r14 = r15;
        goto L19
    }
}
