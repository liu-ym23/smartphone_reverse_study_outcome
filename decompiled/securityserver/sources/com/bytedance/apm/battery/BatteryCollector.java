package com.bytedance.apm.battery;

import android.app.Activity;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.agent.v2.instrumentation.BatteryAgent;
import com.bytedance.apm.battery.config.BatteryDetectConfig;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.apm.battery.config.Constants;
import com.bytedance.apm.battery.hook.BinderHookHelper;
import com.bytedance.apm.battery.internal.BatteryDataManager;
import com.bytedance.apm.battery.stats.BatteryAlarmStatsImpl;
import com.bytedance.apm.battery.stats.BatteryConsumeStatsImpl;
import com.bytedance.apm.battery.stats.BatteryCpuStatsImpl;
import com.bytedance.apm.battery.stats.BatteryLocStatsImpl;
import com.bytedance.apm.battery.stats.BatteryPacketsStatsImpl;
import com.bytedance.apm.battery.stats.BatteryTrafficAllInterface;
import com.bytedance.apm.battery.stats.BatteryTrafficStatsImpl;
import com.bytedance.apm.battery.stats.BatteryWakeLockStatsImpl;
import com.bytedance.apm.battery.stats.IBatteryStats;
import com.bytedance.apm.battery.util.BatteryUtils;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.entity.BatteryLogEntity;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.logging.DebugLogger;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.perf.AbstractPerfCollector;
import com.bytedance.apm.perf.methodtrace.ThreadTimeItem;
import com.bytedance.apm.perf.methodtrace.ThreadTimeUtil;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.CommonMonitorUtil;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.apm.util.ParseUtils;
import com.bytedance.monitor.util.thread.TaskRunnable;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.apm.api.EnsureManager;
import com.bytedance.services.slardar.config.IConfigManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BatteryCollector extends AbstractPerfCollector implements BatteryUtils.ChargeListener {
    private static final long BACK_RECORD_INTERVAL = 10;
    private static final long DEFAULT_REPORT_INTERVAL = 30;
    public static final String TAG = "BatteryCollector";
    private static final Object innerLock = null;
    private volatile boolean isFront;
    private String[] mActivityNameToReport;
    private final Map<String, IBatteryStats> mBatteryStatsMap;
    private HashMap<String, Integer> mCPUMonitorConfigMap;
    private volatile boolean mCollectEnable;
    private String mCurSceneSetStr;
    private boolean mEnableLocalRecord;
    private volatile boolean mEnableTrace;
    private boolean mIsCharging;
    private long mJiffyHz;
    private String mLastOnFrontActivity;
    private volatile long mLastReportTime;
    private volatile long mLastStatusSampleTime;
    private int mMaxSupportApiLevel;
    private volatile long mRecordInterval;
    private volatile long mReportInterval;
    private List<String> mSceneBlackList;
    private List<String> mSceneList;
    private HashMap<Integer, ThreadTimeItem> mThreadCostRecord;
    private final TaskRunnable mTimerRunnable;
    private final TaskRunnable mUpdateThreadRecordRunnable;
    private HashMap<Integer, ThreadTimeItem> pageInThreadState;

    public static final class Holder {
        private static final BatteryCollector INSTANCE = null;

        static {
            INSTANCE = new BatteryCollector(null);
        }

        private Holder() {
        }

        public static /* synthetic */ BatteryCollector access$100() {
            return INSTANCE;
        }
    }

    static {
        innerLock = new Object();
    }

    public /* synthetic */ BatteryCollector(AnonymousClass1 r1) {
        this();
    }

    public static /* synthetic */ boolean access$1000(BatteryCollector r0) {
        return r0.mCollectEnable;
    }

    public static /* synthetic */ long access$1100(BatteryCollector r2) {
        return r2.mLastReportTime;
    }

    public static /* synthetic */ long access$1102(BatteryCollector r0, long r1) {
        r0.mLastReportTime = r1;
        return r1;
    }

    public static /* synthetic */ long access$1200(BatteryCollector r2) {
        return r2.mReportInterval;
    }

    public static /* synthetic */ void access$1300(BatteryCollector r0) {
        r0.updateThreadRecord();
    }

    public static /* synthetic */ HashMap access$1400(BatteryCollector r0) {
        return r0.mCPUMonitorConfigMap;
    }

    public static /* synthetic */ TaskRunnable access$1500(BatteryCollector r0) {
        return r0.mUpdateThreadRecordRunnable;
    }

    public static /* synthetic */ Object access$200() {
        return innerLock;
    }

    public static /* synthetic */ boolean access$300(BatteryCollector r0) {
        return r0.recordStatus();
    }

    public static /* synthetic */ Map access$400(BatteryCollector r0) {
        return r0.mBatteryStatsMap;
    }

    public static /* synthetic */ boolean access$502(BatteryCollector r0, boolean r1) {
        r0.mIsCharging = r1;
        return r1;
    }

    public static /* synthetic */ List access$600(BatteryCollector r0) {
        return r0.mSceneList;
    }

    public static /* synthetic */ void access$700(BatteryCollector r0) {
        r0.updateSceneStr();
    }

    public static /* synthetic */ boolean access$800(BatteryCollector r0, boolean r1) {
        return r0.recordStatus(r1);
    }

    public static /* synthetic */ boolean access$900(BatteryCollector r0) {
        return r0.isFront;
    }

    public static /* synthetic */ boolean access$902(BatteryCollector r0, boolean r1) {
        r0.isFront = r1;
        return r1;
    }

    private boolean cpuMonitorEnable() {
        if (BatteryAgent.hasHook() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.mCPUMonitorConfigMap.containsKey(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_ENABLE) == true) goto L7;
    L8:
        return true;
    L7:
        if (this.mCPUMonitorConfigMap.get(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_ENABLE).intValue() == 0) goto L9;
        goto L8
    }

    public static BatteryCollector getInstance() {
        return Holder.access$100();
    }

    private boolean isAndroidVersionInvalid() {
        if (Build.VERSION.SDK_INT <= this.mMaxSupportApiLevel) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isStayDurationValid(long r6) {
        if (this.isFront == false) goto L13;
        if (this.mCPUMonitorConfigMap.containsKey(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_FRONT_VALID_DURATION) == false) goto L7;
        int r5 = this.mCPUMonitorConfigMap.get(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_FRONT_VALID_DURATION).intValue();
    L9:
        if (r6 > (r5 * 1000)) goto L11;
        return false;
    L11:
        return true;
    L7:
        r5 = 20;
        goto L9
    L13:
        if (this.mCPUMonitorConfigMap.containsKey(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_BACKGROUND_VALID_DURATION) == false) goto L15;
        int r7 = this.mCPUMonitorConfigMap.get(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_BACKGROUND_VALID_DURATION).intValue();
    L17:
        if (r6 > (r7 * 1000)) goto L19;
        return false;
    L19:
        return true;
    L15:
        r7 = 60;
        goto L17
    }

    private void monitorFunctionExecute(long r12) {
        int r1 = 5;
        if (this.isFront == true) goto L12;
        if (TextUtils.isEmpty(this.mCurSceneSetStr) == false) goto L12;
        if (this.mCPUMonitorConfigMap.containsKey(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_FUNCTION_BACKGROUND_THRESHOLD) == false) goto L10;
        int r0 = this.mCPUMonitorConfigMap.get(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_FUNCTION_BACKGROUND_THRESHOLD).intValue();
    L15:
        Map<String, BatteryAgent.MethodExecutedValue> r2 = BatteryAgent.filterResultAndClear((((long) r0) * r12) / 100);
        if (isStayDurationValid(r12) == false) goto L41;
        JSONObject r3 = new JSONObject();
        int r5 = 0;
        boolean r6 = true;
        if (r2.isEmpty() == true) goto L24;
        JSONArray r4 = new JSONArray();
        Iterator<Map.Entry<String, BatteryAgent.MethodExecutedValue>> r7 = r2.entrySet().iterator();
    L21:
        if (r7.hasNext() == false) goto L23;
        Map.Entry<String, BatteryAgent.MethodExecutedValue> r8 = r7.next();
        JSONObject r9 = new JSONObject();
        r9.putOpt("method", r8.getKey());
        r9.putOpt("exe_count", Integer.valueOf(r8.getValue().getCount()));
        r9.putOpt("cpu_cost", Integer.valueOf(r8.getValue().getCost()));
        r4.put(r9);
        goto L21
    L23:
        r3.putOpt("functions", r4);
        boolean r10 = true;
    L26:
        if (this.mThreadCostRecord.isEmpty() == true) goto L34;
        ArrayList r11 = new ArrayList(this.mThreadCostRecord.values());
        Collections.sort(r11, new AnonymousClass8(this));
        JSONArray r13 = new JSONArray();
        if (this.mCPUMonitorConfigMap.containsKey(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_THREAD_COUNT) == false) goto L31;
        r1 = this.mCPUMonitorConfigMap.get(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_THREAD_COUNT).intValue();
    L31:
        if (r5 >= Math.min(r11.size(), r1)) goto L33;
        ThreadTimeItem r14 = (ThreadTimeItem) r11.get(r5);
        JSONObject r15 = new JSONObject();
        r5 = r5 + 1;
        r15.putOpt("rank", Integer.valueOf(r5));
        r15.putOpt("thread_name", r14.threadName);
        r15.putOpt("cpu_cost", Long.valueOf(r14.threadTime));
        r13.put(r15);
        goto L31
    L33:
        r3.putOpt("threads", r13);
    L35:
        if (r6 == false) goto L41;
        if (this.isFront == false) goto L39;
        String r16 = BatteryDataManager.getInstance().getCurrentActivityName();
    L40:
        JSONObject r17 = new JSONObject();
        r17.putOpt("scene", r16);
        JSONObject r18 = new JSONObject();
        r18.putOpt("stay_duration", Long.valueOf(r12));
        ApmAlogHelper.i(Constants.TAG_BATTERY_LOCAL, "scene:" + r16 + " stayDuration:" + r12 + " data:" + r3.toString());
        ApmAgent.monitorEvent("monitor_expend_function", r17, r18, r3);
        goto L41
    L39:
        r16 = "background";
        goto L40
    L34:
        r6 = r10;
        goto L35
    L24:
        r10 = false;
    L41:
        resetPageInThreadState();
        return;
    L10:
        r0 = 2;
    L12:
        if (this.mCPUMonitorConfigMap.containsKey(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_FUNCTION_FRONT_THRESHOLD) == false) goto L14;
        r0 = this.mCPUMonitorConfigMap.get(SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_FUNCTION_FRONT_THRESHOLD).intValue();
        goto L15
    L14:
        r0 = 5;
        goto L15
    }

    private void recordBackgroundData() {
        if (isAndroidVersionInvalid() == false) goto L5;
        return;
    L5:
        ApmAlogHelper.i(Constants.TAG_BATTERY, "ToBack");
        BatteryDataManager.getInstance().setCurrentActivityName(ActivityLifeObserver.getInstance().getTopActivityClassName());
        AsyncEventManager.getInstance().forcePost(new AnonymousClass5(this));
    }

    private void recordFrontData(String r3) {
        if (isAndroidVersionInvalid() == false) goto L5;
        return;
    L5:
        ApmAlogHelper.i(Constants.TAG_BATTERY, "ToFront:" + r3);
        BatteryDataManager.getInstance().setCurrentActivityName(r3);
        AsyncEventManager.getInstance().forcePost(new AnonymousClass4(this));
    }

    private boolean recordStatus() {
        return recordStatus(false);
    }

    private void resetPageInThreadState() {
        this.pageInThreadState.clear();
        this.mThreadCostRecord.clear();
        LinkedList<ThreadTimeItem> r0 = ThreadTimeUtil.getThreadInfo(Process.myPid());
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEmpty() == true) goto L13;
        Iterator<ThreadTimeItem> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L14;
        ThreadTimeItem r2 = r1.next();
        this.pageInThreadState.put(Integer.valueOf(r2.threadId), r2);
        goto L9
    L14:
        return;
    }

    private void updateSceneStr() {
        if (this.mSceneList.isEmpty() == false) goto L6;
        this.mCurSceneSetStr = null;
        return;
    L6:
        Collections.sort(this.mSceneList, new AnonymousClass10(this));
        this.mCurSceneSetStr = ListUtils.arrayToString(this.mSceneList.toArray(), "#");
    }

    private void updateThreadRecord() {
        if (this.pageInThreadState.isEmpty() == false) goto L5;
        return;
    L5:
        LinkedList<ThreadTimeItem> r0 = ThreadTimeUtil.getThreadInfo(Process.myPid());
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.isEmpty() == true) goto L32;
        Iterator<ThreadTimeItem> r1 = r0.iterator();
    L12:
        if (r1.hasNext() == false) goto L33;
        ThreadTimeItem r2 = r1.next();
        if (this.pageInThreadState.containsKey(Integer.valueOf(r2.threadId)) == false) goto L16;
        long r3 = r2.threadTime - this.pageInThreadState.get(Integer.valueOf(r2.threadId)).threadTime;
    L18:
        if (r3 <= 0) goto L12;
        long r4 = (long) ((r3 / this.mJiffyHz) * 1000.0d);
        if (this.mThreadCostRecord.containsKey(Integer.valueOf(r2.threadId)) == true) goto L21;
        this.mThreadCostRecord.put(Integer.valueOf(r2.threadId), new ThreadTimeItem(r2.threadId, r2.threadName, r4));
        goto L12
    L21:
        this.mThreadCostRecord.get(Integer.valueOf(r2.threadId)).updateThreadTime(r4);
        goto L12
    L16:
        r3 = r2.threadTime;
        goto L18
    L33:
        return;
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void doConfig(JSONObject r14) {
        this.mRecordInterval = r14.optLong(SlardarSettingsConsts.PERF_BATTERY_RECORD_INTERVAL, 10);
        this.mReportInterval = r14.optLong(SlardarSettingsConsts.PERF_BATTERY_REPORT_INTERVAL, 30);
        int r0 = r14.optInt("enable_upload", 0);
        if (r0 == 1) goto L5;
    L7:
        boolean r3 = false;
    L8:
        this.mCollectEnable = r3;
        this.mMaxSupportApiLevel = r14.optInt(SlardarSettingsConsts.PERF_BATTERY_SUPPORT_MAX_API_LEVEL, this.mMaxSupportApiLevel);
        if (ApmContext.isDebugMode() == false) goto L12;
        Logger.e(DebugLogger.TAG_BATTERY, new String[]{"mRecordInterval:" + this.mRecordInterval + ",mBatteryCollectEnabled" + r0});
    L12:
        if (this.mCollectEnable == true) goto L17;
        if (this.mEnableLocalRecord == true) goto L17;
        this.mBatteryStatsMap.clear();
        ActivityLifeObserver.getInstance().unregister(this);
        BatteryUtils.removeListener(ApmContext.getContext(), this);
    L20:
        if (r14.optInt(SlardarSettingsConsts.PERF_BATTERY_TRACE_ENABLE, 0) != 1) goto L22;
        boolean r1 = true;
    L23:
        this.mEnableTrace = r1;
        if (this.mEnableTrace == false) goto L26;
        BatteryDetectConfig.setMaxSingleWakeLockHoldTimeMs(r14.optLong(BatteryDetectConfig.KEY_MAX_SINGLE_WAKE_LOCK_HOLD_TIME, 120) * 1000);
        BatteryDetectConfig.setMaxTotalWakeLockAcquireCount(r14.optInt(BatteryDetectConfig.KEY_MAX_TOTAL_WAKE_LOCK_ACQUIRE_COUNT_10_MINS, 5));
        BatteryDetectConfig.setMaxTotalWakeLockHoldTimeMs(r14.optLong(BatteryDetectConfig.KEY_MAX_TOTAL_WAKE_LOCK_HOLD_TIME_10_MINS, 240) * 1000);
        BatteryDetectConfig.setMaxWakeUpAlarmInvokeCount(r14.optInt(BatteryDetectConfig.KEY_MAX_WAKE_UP_ALARM_INVOKE_COUNT_10_MINS, 5));
        BatteryDetectConfig.setMaxNormalAlarmInvokeCount(r14.optInt(BatteryDetectConfig.KEY_MAX_NORMAL_ALARM_INVOKE_COUNT_10_MINS, 10));
        BatteryDetectConfig.setMaxSingleLocRequestTimeMs(r14.optLong(BatteryDetectConfig.KEY_MAX_SINGLE_LOC_REQUEST_TIME, 120) * 1000);
        BatteryDetectConfig.setMaxTotalLocRequestCount(r14.optInt(BatteryDetectConfig.KEY_MAX_TOTAL_LOC_REQUEST_COUNT_10_MINS, 5));
        BatteryDetectConfig.setMaxTotalLocRequestTimeMs(r14.optLong(BatteryDetectConfig.KEY_MAX_TOTAL_LOC_REQUEST_TIME_10_MINS, 240) * 1000);
    L26:
        JSONObject r2 = r14.optJSONObject(SlardarSettingsConsts.PERF_BATTERY_CPU_MONITOR_CONFIG);
        if (r2 == null) goto L37;
        Iterator<String> r4 = r2.keys();
    L30:
        if (r4.hasNext() == false) goto L37;
        String r5 = r4.next();
        if (SlardarSettingsConsts.PERF_KEY_CPU_MONITOR_ENABLE.equals(r5) == true) goto L33;
        int r6 = r2.optInt(r5, 0);
        if (r6 <= 0) goto L30;
        this.mCPUMonitorConfigMap.put(r5, Integer.valueOf(r6));
        goto L30
    L33:
        this.mCPUMonitorConfigMap.put(r5, Integer.valueOf(r2.optInt(r5, 1)));
    L37:
        this.mSceneBlackList = ParseUtils.parseList(r14, SlardarSettingsConsts.PERF_BATTERY_SCENE_BLACK_LIST);
        if (cpuMonitorEnable() == false) goto L49;
        AsyncEventManager.getInstance().forcePost(this.mUpdateThreadRecordRunnable);
        resetPageInThreadState();
        return;
    L49:
        return;
    L22:
        r1 = false;
    L17:
        if (r14.optInt(SlardarSettingsConsts.PERF_BATTERY_NET_ALL_INTERFACE_ENABLE, 0) != 1) goto L20;
        this.mBatteryStatsMap.put(BatteryTypeInf.BATTERY_NET_ALL_INTERFACE, new BatteryTrafficAllInterface());
        goto L20
    L5:
        if (this.mRecordInterval <= 0) goto L7;
        r3 = true;
        goto L8
    }

    public Map<String, IBatteryStats> getBatteryStatsMap() {
        return this.mBatteryStatsMap;
    }

    public String getCurSceneSetStr() {
        return this.mCurSceneSetStr;
    }

    public void init(boolean r1) {
        this.mEnableLocalRecord = r1;
        init();
    }

    public boolean isEnableTrace() {
        return this.mEnableTrace;
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public boolean isTimerMonitor() {
        return false;
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityResume(Activity r5) {
        super.onActivityResume(r5);
        String[] r0 = this.mActivityNameToReport;
        r0[0] = r0[1];
        r0[1] = r5.getClass().getName();
        if (TextUtils.equals(r5.getClass().getName(), this.mLastOnFrontActivity) == false) goto L5;
    L7:
        this.mLastOnFrontActivity = null;
        return;
    L5:
        if (TextUtils.isEmpty(this.mActivityNameToReport[0]) == true) goto L7;
        recordFrontData(this.mActivityNameToReport[0]);
        goto L7
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onBackground(Activity r1) {
        super.onBackground(r1);
        recordBackgroundData();
    }

    @Override // com.bytedance.apm.battery.util.BatteryUtils.ChargeListener
    public void onChange(final boolean r3) {
        if (this.mBatteryStatsMap.isEmpty() == false) goto L5;
        return;
    L5:
        BatteryDataManager.getInstance().setCurrentActivityName(ActivityLifeObserver.getInstance().getTopActivityClassName());
        AsyncEventManager.getInstance().forcePost(new AnonymousClass1(this, r3));
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onFront(Activity r1) {
        super.onFront(r1);
        this.mLastOnFrontActivity = r1.getClass().getName();
        recordFrontData(ActivityLifeObserver.getInstance().getTopActivityClassName());
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void onInit() {
        if (isAndroidVersionInvalid() == false) goto L5;
        return;
    L5:
        ApmAlogHelper.i(Constants.TAG_BATTERY, "Battery init process" + ApmContext.getCurrentProcessName());
        this.isFront = ActivityLifeObserver.getInstance().isForeground();
        this.mActivityNameToReport[1] = ActivityLifeObserver.getInstance().getTopActivityClassName();
        this.mJiffyHz = CommonMonitorUtil.getScClkTck(100);
        this.mIsCharging = BatteryUtils.addChargeListener(ApmContext.getContext(), this);
        BatteryAlarmStatsImpl r3 = new BatteryAlarmStatsImpl();
        BatteryLocStatsImpl r4 = new BatteryLocStatsImpl();
        BatteryWakeLockStatsImpl r5 = new BatteryWakeLockStatsImpl();
        BinderHookHelper r6 = new BinderHookHelper();     // Catch: Exception -> L9
        r6.addHook("alarm", r3);     // Catch: Exception -> L9
        r6.addHook(BatteryTypeInf.BATTERY_LOC_API, r4);     // Catch: Exception -> L9
        r6.addHook(BatteryTypeInf.BATTERY_POWER_LOCK, r5);     // Catch: Exception -> L9
        r6.hookService();     // Catch: Exception -> L9
        BatteryCpuStatsImpl r7 = new BatteryCpuStatsImpl();
        BatteryTrafficStatsImpl r8 = new BatteryTrafficStatsImpl();
        BatteryPacketsStatsImpl r9 = new BatteryPacketsStatsImpl();
        BatteryConsumeStatsImpl r10 = new BatteryConsumeStatsImpl();
        this.mBatteryStatsMap.put("alarm", r3);
        this.mBatteryStatsMap.put(BatteryTypeInf.BATTERY_CPU_ACTIVE, r7);
        this.mBatteryStatsMap.put("traffic", r8);
        this.mBatteryStatsMap.put(BatteryTypeInf.BATTERY_PACKETS, r9);
        this.mBatteryStatsMap.put(BatteryTypeInf.BATTERY_LOC_API, r4);
        this.mBatteryStatsMap.put(BatteryTypeInf.BATTERY_POWER_LOCK, r5);
        this.mBatteryStatsMap.put(BatteryTypeInf.BATTERY_CONSUME, r10);
        this.mLastReportTime = SystemClock.elapsedRealtime();
        return;
    L9:
        e = move-exception;
        if (ApmContext.isDebugMode() == false) goto L13;
        Logger.e(DebugLogger.TAG_BATTERY, new String[]{"Binder hook failed: " + e.getMessage()});
    L13:
        ActivityLifeObserver.getInstance().unregister(this);
        BatteryUtils.removeListener(ApmContext.getContext(), this);
        ((IConfigManager) ServiceManager.getService(IConfigManager.class)).unregisterConfigListener(this);
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector, com.bytedance.services.slardar.config.IConfigListener
    public void onReady() {
        super.onReady();
        if (ApmContext.isMainProcess() == true) goto L5;
        return;
    L5:
        if (this.mCollectEnable == false) goto L9;
        BatteryDataManager.getInstance().handleReportAndHandleCache(true);
        this.mLastReportTime = SystemClock.elapsedRealtime();
        return;
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void onStart() {
        if (isAndroidVersionInvalid() == false) goto L5;
        return;
    L5:
        if (this.mBatteryStatsMap.isEmpty() == true) goto L13;
        ApmAlogHelper.i(Constants.TAG_BATTERY, "OnTimer");
        long r0 = workInternalMs();
        if (r0 <= 0) goto L10;
        AsyncEventManager.getInstance().forcePostDelay(this.mTimerRunnable, r0);
    L10:
        BatteryDataManager.getInstance().setCurrentActivityName(ActivityLifeObserver.getInstance().getTopActivityClassName());
        AsyncEventManager.getInstance().forcePost(new AnonymousClass6(this));
        return;
    }

    public void startSceneMonitor(final String r3) {
        if (this.mBatteryStatsMap.isEmpty() == true) goto L15;
        if (r3 == null) goto L16;
        List<String> r0 = this.mSceneBlackList;
        if (r0 != null) goto L9;
    L13:
        AsyncEventManager.getInstance().forcePost(new AnonymousClass2(this, r3));
        return;
    L9:
        if (r0.isEmpty() == true) goto L13;
        if (this.mSceneBlackList.contains(r3) == false) goto L13;
        return;
    L16:
        return;
    }

    public void stopSceneMonitor(final String r3) {
        if (this.mBatteryStatsMap.isEmpty() == true) goto L15;
        if (r3 == null) goto L16;
        List<String> r0 = this.mSceneBlackList;
        if (r0 != null) goto L9;
    L13:
        AsyncEventManager.getInstance().forcePost(new AnonymousClass3(this, r3));
        return;
    L9:
        if (r0.isEmpty() == true) goto L13;
        if (this.mSceneBlackList.contains(r3) == false) goto L13;
        return;
    L16:
        return;
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public long workInternalMs() {
        return this.mRecordInterval * 60000;
    }

    private BatteryCollector() {
        this.mBatteryStatsMap = new ConcurrentHashMap();
        this.mLastStatusSampleTime = -1;
        this.mCollectEnable = false;
        this.mReportInterval = 30;
        this.mLastReportTime = -1;
        this.mMaxSupportApiLevel = 32;
        this.mActivityNameToReport = new String[2];
        this.mSceneList = new ArrayList();
        this.pageInThreadState = new HashMap();
        this.mThreadCostRecord = new HashMap();
        this.mCPUMonitorConfigMap = new HashMap();
        this.mTimerRunnable = new AnonymousClass7(this);
        this.mUpdateThreadRecordRunnable = new AnonymousClass9(this);
        this.mCollectorSettingKey = "battery";
    }

    private boolean recordStatus(boolean r19) {
        long r1 = SystemClock.elapsedRealtime();
        long r3 = r1 - this.mLastStatusSampleTime;
        if (r3 <= 2000) goto L6;
        boolean r5 = true;
    L5:
        boolean r14 = r5;
        if (this.mLastStatusSampleTime == (-1)) goto L15;
        if (r14 == false) goto L15;
        boolean r17 = r14;
        BatteryDataManager.getInstance().record(new BatteryLogEntity(this.isFront, System.currentTimeMillis(), BatteryTypeInf.BATTERY_GROUND_RECORD, this.mIsCharging, r3, this.mCurSceneSetStr));
        if (this.isFront == false) goto L17;
        if (r3 <= 7200000) goto L17;
        HashMap r6 = new HashMap();
        r6.put("duration", String.valueOf(r3));
        EnsureManager.ensureNotReachHere("BatterErrorDuration", r6);
    L17:
        if (this.mLastStatusSampleTime == (-1)) goto L22;
        if (r19 == false) goto L22;
        if (cpuMonitorEnable() == false) goto L22;
        monitorFunctionExecute(r3);
    L22:
        this.mLastStatusSampleTime = r1;
        return r17;
    L15:
        r17 = r14;
        goto L17
    L6:
        r5 = false;
        goto L5
    }
}
