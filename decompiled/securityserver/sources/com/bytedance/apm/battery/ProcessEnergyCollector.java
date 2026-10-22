package com.bytedance.apm.battery;

import android.app.Activity;
import android.os.BatteryManager;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.perf.AbstractPerfCollector;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.CommonMonitorUtil;
import com.bytedance.apm6.commonevent.CommonEventDeliverer;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.log.Logger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ProcessEnergyCollector extends AbstractPerfCollector {
    private static final boolean DEBUG = false;
    private static final long DEFAULT_BATTERY_MONITOR_INTERVAL_MS = 300000;
    private static final long DEFAULT_CPU_MONITOR_INTERVAL = 60000;
    private static final long DEFAULT_PROC_CPU_UPLOAD_INTERVAL_MS = 120000;
    private static final String TAG = "ProcessEnergyCollector";
    private long mBatteryMonitorIntervalMs;
    private long mCpuMonitorIntervalMs;
    int mLastBatteryLevel;
    long mLastBatteryUpdateSwitchCount;
    long mLastBatteryUpdateTime;
    int mLastFrontSwitch;
    long mLastGetProcCpuTime;
    long mLastProcCpuTimeMs;
    private boolean mPowerMonitorEnabled;
    private final LinkedList<SceneStackItem> mProcCpuInfos;
    private long mProcCpuUploadIntervalMs;
    private final ConcurrentHashMap<String, Long> mSceneMinDuration;
    private final LinkedList<SceneStackItem> mSceneStack;
    private int mSwitchCounter;
    private long mUploadUpdateTime;

    /* JADX INFO: renamed from: com.bytedance.apm.battery.ProcessEnergyCollector$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Holder {
        private static final ProcessEnergyCollector INSTANCE = null;

        static {
            INSTANCE = new ProcessEnergyCollector();
        }

        private Holder() {
        }

        public static /* synthetic */ ProcessEnergyCollector access$000() {
            return INSTANCE;
        }
    }

    public static class SceneStackItem {
        public long endCpuTimeMs;
        public long endTimeMs;
        public String sceneName;
        public long startCpuTimeMs;
        public long startTimeMs;

        private SceneStackItem() {
        }

        public double getCpuSpeed() {
            double r0 = getDuration() / 1000.0d;
            if (r0 > 0.0d) goto L5;
            return 0.0d;
        L5:
            return (Math.round(getCpuTime() / r0) * 100) / 100.0d;
        }

        public long getCpuTime() {
            return this.endCpuTimeMs - this.startCpuTimeMs;
        }

        public long getDuration() {
            return this.endTimeMs - this.startTimeMs;
        }

        public String toString() {
            return "Scene{ name=" + this.sceneName + ", cpu=" + getCpuTime() + " ms, dur=" + getDuration() + " ms, speed=" + getCpuSpeed();
        }

        public /* synthetic */ SceneStackItem(AnonymousClass1 r1) {
            this();
        }
    }

    public ProcessEnergyCollector() {
        this.mSceneMinDuration = new ConcurrentHashMap();
        this.mSceneStack = new LinkedList();
        this.mProcCpuInfos = new LinkedList();
        this.mSwitchCounter = 0;
        this.mLastProcCpuTimeMs = 0;
        this.mLastGetProcCpuTime = 0;
        this.mLastFrontSwitch = 0;
        this.mLastBatteryLevel = 0;
        this.mLastBatteryUpdateTime = 0;
        this.mLastBatteryUpdateSwitchCount = 0;
        this.mCollectorSettingKey = "battery";
    }

    private void caculateBatteryInfo() {
        long r0 = SystemClock.uptimeMillis();
        long r2 = this.mLastBatteryUpdateTime;
        if ((this.mBatteryMonitorIntervalMs + r2) <= r0) goto L5;
        return;
    L5:
        long r3 = r0 - r2;
        this.mLastBatteryUpdateTime = r0;
        int r1 = ((BatteryManager) ApmBaseContext.getContext().getSystemService("batterymanager")).getIntProperty(4);
        int r4 = r1 - this.mLastBatteryLevel;
        if (this.mLastBatteryUpdateSwitchCount == this.mSwitchCounter) goto L8;
    L13:
        this.mLastBatteryLevel = r1;
        this.mLastBatteryUpdateSwitchCount = this.mSwitchCounter;
        return;
    L8:
        if (isBackground() == true) goto L13;
        if (r4 > 0) goto L13;
        int r5 = Math.abs(r4);
        if (r5 > 100) goto L13;
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L15
        r6.put("battery", Math.abs(r5));     // Catch: Exception -> L15
        r6.put("duraion", r3);     // Catch: Exception -> L15
        CommonEventDeliverer.monitorEvent("apm_battery_monitor", null, r6, null);     // Catch: Exception -> L15
        goto L13
    }

    public static ProcessEnergyCollector getInstance() {
        return Holder.access$000();
    }

    private void uploadProcCpuData() {
        long r0 = SystemClock.uptimeMillis();
        if ((this.mUploadUpdateTime + this.mProcCpuUploadIntervalMs) <= r0) goto L5;
        return;
    L5:
        this.mUploadUpdateTime = r0;
        LinkedList<SceneStackItem> r1 = this.mProcCpuInfos;
        monitor-enter(r1);
        Iterator<SceneStackItem> r2 = this.mProcCpuInfos.iterator();     // Catch: Throwable -> L13
    L9:
        if (r2.hasNext() == false) goto L15;
        SceneStackItem r3 = r2.next();     // Catch: Throwable -> L13
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L20 Throwable -> L13
        r4.put("scene", r3.sceneName);     // Catch: Exception -> L20 Throwable -> L13
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L20 Throwable -> L13
        r5.put("cpu_speed", r3.getCpuSpeed());     // Catch: Exception -> L20 Throwable -> L13
        CommonEventDeliverer.monitorEvent("apm_proc_cpu_info", r4, r5, null);     // Catch: Exception -> L20 Throwable -> L13
        goto L9
    L15:
        this.mProcCpuInfos.clear();     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public void caculateCpuInfo() {
        long r0 = CommonMonitorUtil.getAppCPUTime();
        long r2 = SystemClock.uptimeMillis();
        long r4 = this.mLastGetProcCpuTime;
        if (r4 != 0) goto L5;
    L14:
        this.mLastFrontSwitch = this.mSwitchCounter;
        this.mLastProcCpuTimeMs = r0;
        this.mLastGetProcCpuTime = r2;
        return;
    L5:
        if (this.mLastFrontSwitch != this.mSwitchCounter) goto L14;
        double r5 = (r2 - r4) / 60000.0d;
        if (r5 <= 0.0d) goto L14;
        double r6 = Math.round(((r0 - this.mLastProcCpuTimeMs) / r5) * 100.0d) / 100.0d;
        JSONObject r7 = new JSONObject();     // Catch: Exception -> L16
        if (isBackground() == false) goto L12;
        String r8 = "background";
    L13:
        r7.put("status", r8);     // Catch: Exception -> L16
        JSONObject r9 = new JSONObject();     // Catch: Exception -> L16
        r9.put("cpu_speed_min", r6);     // Catch: Exception -> L16
        CommonEventDeliverer.monitorEvent("apm_cpu_speed", r7, r9, null);     // Catch: Exception -> L16
        goto L14
    L12:
        r8 = "foreground";
        goto L13
    }

    public void configSceneMinDuration(HashMap<String, Long> r1) {
        this.mSceneMinDuration.putAll(r1);
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void doConfig(JSONObject r4) {
        boolean r1 = false;
        if (r4.optInt(SlardarSettingsConsts.PER_POWER_MONITOR_ENABLE, 0) != 1) goto L5;
        r1 = true;
    L5:
        this.mPowerMonitorEnabled = r1;
        if (r1 == false) goto L8;
        this.mCpuMonitorIntervalMs = r4.optLong(SlardarSettingsConsts.PER_POWER_CPU_MONITOR_INTERVAL, 60000);
        this.mBatteryMonitorIntervalMs = r4.optLong(SlardarSettingsConsts.PER_POWER_BATTERY_MONITOR_INTERVAL, 300000);
        this.mProcCpuUploadIntervalMs = r4.optLong(SlardarSettingsConsts.PER_POWER_PROC_CPU_UPLOAD_INTERVAL, 120000);
        return;
    L8:
        ActivityLifeObserver.getInstance().unregister(this);
        AsyncEventManager.getInstance().removeTimeTask(this);
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public boolean isTimerMonitor() {
        return this.mPowerMonitorEnabled;
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onBackground(Activity r1) {
        super.onBackground(r1);
        this.mSwitchCounter++;
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onFront(Activity r1) {
        super.onFront(r1);
        this.mSwitchCounter++;
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void onStart() {
        super.onStart();
        caculateCpuInfo();
        caculateBatteryInfo();
        uploadProcCpuData();
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void onStop() {
        super.onStop();
    }

    public void startScene(String r6) {
        if (this.mPowerMonitorEnabled == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r6) == true) goto L21;
        SceneStackItem r0 = new SceneStackItem(null);
        r0.startTimeMs = SystemClock.uptimeMillis();
        long r1 = CommonMonitorUtil.getAppCPUTime();
        r0.startCpuTimeMs = r1;
        r0.sceneName = r6;
        if (r1 > 0) goto L10;
        return;
    L10:
        LinkedList<SceneStackItem> r7 = this.mSceneStack;
        monitor-enter(r7);
        this.mSceneStack.push(r0);     // Catch: Throwable -> L15
        monitor-exit(r7);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public void stopScene(String r7) {
        if (this.mPowerMonitorEnabled == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r7) == false) goto L8;
        return;
    L8:
        if (this.mSceneStack.size() == 0) goto L52;
        LinkedList<SceneStackItem> r0 = this.mSceneStack;
        monitor-enter(r0);
        SceneStackItem r1 = this.mSceneStack.pop();     // Catch: Throwable -> L34
        monitor-exit(r0);     // Catch: Throwable -> L34
        if (r1 != null) goto L15;
    L32:
        if (r1 == null) goto L8;
        Logger.d(TAG, "Unexpected scene, top: " + r1.sceneName + ", cur:" + r7);
        goto L8
    L15:
        if (r1.sceneName.equals(r7) == false) goto L32;
        r1.endTimeMs = SystemClock.uptimeMillis();
        long r2 = CommonMonitorUtil.getAppCPUTime();
        r1.endCpuTimeMs = r2;
        if (r2 <= 0) goto L50;
        Long r8 = this.mSceneMinDuration.get(r1.sceneName);
        if (r8 != null) goto L22;
    L24:
        LinkedList<SceneStackItem> r3 = this.mProcCpuInfos;
        monitor-enter(r3);
        this.mProcCpuInfos.add(r1);     // Catch: Throwable -> L29
        monitor-exit(r3);     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        throw th;
    L22:
        if (r1.getDuration() >= r8.longValue()) goto L24;
        return;
    L50:
        return;
    L34:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public long workInternalMs() {
        return this.mCpuMonitorIntervalMs;
    }
}
