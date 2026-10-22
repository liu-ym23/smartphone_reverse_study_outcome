package com.bytedance.apm.trace;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.agent.tracing.AutoLaunchTraceHelper;
import com.bytedance.apm.block.trace.MethodCollector;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.PerfData;
import com.bytedance.apm.entity.TraceTimeEntity;
import com.bytedance.apm.internal.FunctionSwitcher;
import com.bytedance.apm.launch.LaunchAnalysisContext;
import com.bytedance.apm.launch.LaunchCommon;
import com.bytedance.apm.launch.LaunchDataReport;
import com.bytedance.apm.launch.LaunchPerfDataFetcher;
import com.bytedance.apm.launch.evil.LaunchLockDetector;
import com.bytedance.apm.launch.evil.LaunchSleepDetector;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.DeviceInfoUtil;
import com.bytedance.apm.util.LogUtils;
import com.bytedance.apm6.perf.base.CommonDataAssembly;
import com.bytedance.monitor.collector.LockMonitorManager;
import com.bytedance.perf.monitor.EvilMethodTracer;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TraceStats {
    public static final int FLAG_EXTRA_INFO_IO = 16;
    public static final int FLAG_EXTRA_INFO_NET = 1;
    public static final int FLAG_EXTRA_INFO_NONE = 0;
    public static final int FLAG_EXTRA_INFO_THREAD = 256;
    private static final String TAG = "AppStartStats";
    private static volatile boolean isFirst = true;
    private final ConcurrentHashMap<String, TraceTimeEntity> timeSpanMap;
    private long traceBeginTimestamp;
    private long traceEndTimestamp;
    private final String traceName;
    private final String traceServiceName;

    public interface LockFetchListener {
        @WorkerThread
        void lockTime(long r1);
    }

    public TraceStats(String r3, String r4) {
        this.timeSpanMap = new ConcurrentHashMap(4);
        if ("start_trace".equals(r3) == false) goto L5;
    L9:
        this.traceServiceName = r3;
        this.traceName = r4;
        return;
    L5:
        if ("page_load_trace".equals(r3) == true) goto L9;
        throw new IllegalStateException("Please add TraceServiceName support on TraceState#reportAsync");
    }

    public static /* synthetic */ boolean access$000(TraceStats r0) {
        return r0.isLaunchService();
    }

    public static /* synthetic */ long access$100(TraceStats r2) {
        return r2.traceEndTimestamp;
    }

    public static /* synthetic */ void access$200(TraceStats r0, int r1, String r2, String r3, long r4, LaunchPerfDataFetcher.LaunchTraceData r6) {
        r0.reportAsync(r1, r2, r3, r4, r6);
    }

    private boolean isLaunchService() {
        return "start_trace".equals(this.traceServiceName);
    }

    private void reportAsync(int r19, String r20, String r21, long r22, @Nullable LaunchPerfDataFetcher.LaunchTraceData r24) {
        JSONArray r8 = new JSONArray();
        int r9 = 2;
        char r11 = 1;
    L6:
        e = move-exception;
        e.printStackTrace();
    L31:
        ConcurrentHashMap<String, TraceTimeEntity> r0 = this.timeSpanMap;
        if (r0 == null) goto L34;
        r0.clear();
    L34:
        JSONObject r1 = new JSONObject();
        r1.put("name", this.traceName);     // Catch: JSONException -> L61
        r1.put("page_type", this.traceName);     // Catch: JSONException -> L61
        r1.put("start", this.traceBeginTimestamp);     // Catch: JSONException -> L61
        r1.put(TraceStatsConsts.STATS_KEY_END, r22);     // Catch: JSONException -> L61
        r1.put(TraceStatsConsts.STATS_KEY_SPANS, r8);     // Catch: JSONException -> L61
        r1.put(TraceStatsConsts.START_STATS_KEY_COLLECT_FROM, 2);     // Catch: JSONException -> L61
        r1.put(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, r21);     // Catch: JSONException -> L61
        if (r19 == (-1)) goto L39;
        r1.put(TraceStatsConsts.STATS_KEY_LAUNCH_MODE, r19);     // Catch: JSONException -> L61
    L39:
        if (r20.isEmpty() == true) goto L42;
        r1.put(TraceStatsConsts.STATS_KEY_CUSTOM_LAUNCH_MODE, r20);     // Catch: JSONException -> L61
    L42:
        if (ApmAlogHelper.isFeedbackALogEnabled() == false) goto L45;
        ApmAlogHelper.feedbackI(TAG, r1.toString());     // Catch: JSONException -> L61
    L45:
        if (isLaunchService() == true) goto L47;
    L50:
        JSONObject r2 = new JSONObject();
        r2.put(TraceStatsConsts.STATS_KEY_TRACE, r1);     // Catch: JSONException -> L63
        if (r24 == null) goto L56;
        JSONObject r3 = LaunchDataReport.packagePerfData(r24);     // Catch: JSONException -> L63
        if (r3 == null) goto L56;
        r2.put(LaunchCommon.LAUNCH_DATA_PERF_DATA, r3);     // Catch: JSONException -> L63
    L56:
        PerfData r4 = new PerfData(this.traceServiceName, "", null, null, r2);
        CommonDataAssembly.wrapFilters(r4, false);
        if (ApmContext.isDebugMode() == false) goto L59;
        LogUtils.d(TAG, "reportAsync: " + r2);
    L59:
        CommonDataPipeline.getInstance().handle(r4);
        return;
    L47:
        if (LaunchAnalysisContext.getInstance().getConfig().isNeedCollectDeviceInfo() == false) goto L50;
        JSONObject r5 = new JSONObject();
        DeviceInfoUtil.getInstance().addRealTimeDeviceInfo(r5, true);
        DeviceInfoUtil.getInstance().addConstantDeviceInfo(r5, true);
        r1.put(LaunchCommon.LAUNCH_DATA_DEVICE_DATA, r5);     // Catch: Throwable -> L62
        goto L50
    L4:
        if (TextUtils.equals(r21, AutoLaunchTraceHelper.sLauncherActivityName) == false) goto L8;
        r8 = AutoLaunchTraceHelper.assemblySpan();     // Catch: JSONException -> L6
    L8:
        ConcurrentHashMap<String, TraceTimeEntity> r6 = this.timeSpanMap;     // Catch: JSONException -> L6
        if (r6 == null) goto L31;
        if (r6.isEmpty() == true) goto L31;
        Iterator<Map.Entry<String, TraceTimeEntity>> r7 = this.timeSpanMap.entrySet().iterator();     // Catch: JSONException -> L6
    L13:
        if (r7.hasNext() == false) goto L31;
        Map.Entry<String, TraceTimeEntity> r12 = r7.next();     // Catch: JSONException -> L6
        String r13 = r12.getKey();     // Catch: JSONException -> L6
        TraceTimeEntity r14 = r12.getValue();     // Catch: JSONException -> L6
        if (r14.endTimestamp == 0) goto L13;
        JSONObject r15 = new JSONObject();     // Catch: JSONException -> L6
        String[] r16 = r13.split("#");     // Catch: JSONException -> L6
        if (r16.length != r9) goto L26;
        if ("page_load_trace".equals(this.traceServiceName) == false) goto L24;
        r15.put("name", r16[r11]);     // Catch: JSONException -> L6
    L28:
        r15.put("start", r14.startTimestamp);     // Catch: JSONException -> L6
        r15.put(TraceStatsConsts.STATS_KEY_END, r14.endTimestamp);     // Catch: JSONException -> L6
        r15.put("thread", r14.threadName);     // Catch: JSONException -> L6
        r8.put(r15);     // Catch: JSONException -> L6
        r9 = 2;
        r11 = 1;
        goto L13
    L24:
        r15.put(TraceStatsConsts.STATS_KEY_MODULE_NAME, r16[0]);     // Catch: JSONException -> L6
        r15.put(TraceStatsConsts.STATS_KEY_SPAN_NAME, r16[1]);     // Catch: JSONException -> L6
        goto L28
    L26:
        if (r16.length != 1) goto L28;
        r15.put(TraceStatsConsts.STATS_KEY_SPAN_NAME, r16[0]);     // Catch: JSONException -> L6
        goto L28
    }

    private void reportPerfInfo(final int r14, final String r15, final long r16, final long r18) {
        final long[] r3 = MethodCollector.getInstance().copyAllData();
        final long r4 = SystemClock.uptimeMillis();
        if (r3 == null) goto L6;
        AsyncEventManager.getInstance().post(new AnonymousClass2(this, r3, r4, r18, r16, r14, r15));
        return;
    }

    public void cancelTrace() {
        this.timeSpanMap.clear();
    }

    public void endSpan(String r6, String r7) {
        TraceTimeEntity r0 = this.timeSpanMap.get(r6 + "#" + r7);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.appendEndTimeAndThread(System.currentTimeMillis(), Thread.currentThread().getName());
        this.timeSpanMap.put(r6 + "#" + r7, r0);
    }

    public void endTrace(int r8, String r9, long r10) {
        endTrace(r8, r9, r10, 0);
    }

    public long getTraceBeginTimestamp() {
        return this.traceBeginTimestamp;
    }

    public void recordSpan(String r4, String r5, long r6) {
        long r0 = System.currentTimeMillis();
        TraceTimeEntity r2 = new TraceTimeEntity(r0 - r6);
        r2.appendEndTimeAndThread(r0, Thread.currentThread().getName());
        this.timeSpanMap.put(r4 + "#" + r5, r2);
    }

    public void startSpan(String r2, String r3) {
        startSpan(r2, r3, false);
    }

    public void startTrace() {
        this.traceBeginTimestamp = System.currentTimeMillis();
    }

    public void endTrace(int r9, String r10, long r11, long r13) {
        endTrace(r9, "", r10, r11, r13);
    }

    public void startSpan(String r4, String r5, boolean r6) {
        if (this.timeSpanMap.get(r4 + "#" + r5) == null) goto L5;
        if (r6 == true) goto L5;
        return;
    L5:
        TraceTimeEntity r7 = new TraceTimeEntity(System.currentTimeMillis());
        this.timeSpanMap.put(r4 + "#" + r5, r7);
    }

    public void endTrace(String r8, String r9, long r10) {
        endTrace(r8, r9, r10, 0);
    }

    public void endTrace(String r9, String r10, long r11, long r13) {
        endTrace(-1, r9, r10, r11, r13);
    }

    @RequiresApi(api = 18)
    private void endTrace(final int r12, final String r13, final String r14, long r15, long r17) {
        if (r12 != (-1)) goto L12;
        if (r13.isEmpty() == false) goto L12;
        if (ApmContext.isDebugMode() == false) goto L12;
        throw new IllegalArgumentException("Launch mode is both none");
    L12:
        if (isLaunchService() == false) goto L15;
        LaunchPerfDataFetcher.LaunchTraceData r0 = LaunchDataReport.createPerfData();
    L14:
        final LaunchPerfDataFetcher.LaunchTraceData r10 = r0;
        this.traceEndTimestamp = System.currentTimeMillis();
        if (r17 <= 0) goto L19;
        this.traceEndTimestamp = this.traceBeginTimestamp + r17;
    L19:
        long r2 = this.traceEndTimestamp - this.traceBeginTimestamp;
        if (r15 <= 0) goto L25;
        if (r2 <= r15) goto L25;
        return;
    L25:
        if (isLaunchService() == false) goto L32;
        if (EvilMethodTracer.isEvilMethodTraceEnable == false) goto L32;
        if (isFirst == false) goto L32;
        isFirst = false;
        reportPerfInfo(r12, r13, this.traceBeginTimestamp, this.traceEndTimestamp);
    L32:
        if (isLaunchService() == true) goto L34;
    L43:
        AsyncEventManager.getInstance().post(new AnonymousClass1(this, r10, r12, r13, r14));
        if (isLaunchService() == false) goto L49;
        LaunchSleepDetector.stopDetect();
        return;
    L49:
        return;
    L34:
        if (LaunchAnalysisContext.getInstance().getMonitorConfig().isDetectLock() == false) goto L43;
        if (FunctionSwitcher.getSwitch(8) == false) goto L43;
        JSONObject r1 = new JSONObject();
        r1.put(LaunchLockDetector.LAUNCH_LOCK_WITH_OWNER_KEY, true);     // Catch: JSONException -> L40
    L42:
        LockMonitorManager.endLockDetect(r1);
    L40:
        e = move-exception;
        e.printStackTrace();
        goto L42
    L15:
        r0 = null;
        goto L14
    }
}
