package com.bytedance.apm;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm.alog.IALogActiveUploadCallback;
import com.bytedance.apm.alog.IALogActiveUploadObserver;
import com.bytedance.apm.battery.BatteryCollector;
import com.bytedance.apm.battery.BatteryTemperatureCollector;
import com.bytedance.apm.battery.ProcessEnergyCollector;
import com.bytedance.apm.battery.internal.BatteryDataManager;
import com.bytedance.apm.block.trace.MethodCollector;
import com.bytedance.apm.config.ApmReportConfig;
import com.bytedance.apm.config.EventConfig;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.CommonServiceName;
import com.bytedance.apm.constant.ExceptionTypeName;
import com.bytedance.apm.constant.ReportUrl;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.ExceptionLogData;
import com.bytedance.apm.doctor.DoctorDataUtil;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.perf.PerfCollectUtils;
import com.bytedance.apm.perf.PerfDataCenter;
import com.bytedance.apm.perf.PerfFilterManager;
import com.bytedance.apm.perf.TemperatureDataManager;
import com.bytedance.apm.perf.ThreadCollector;
import com.bytedance.apm.perf.entity.MemoryInfo;
import com.bytedance.apm.perf.traffic.BizTrafficStats;
import com.bytedance.apm.perf.traffic.TrafficCollector;
import com.bytedance.apm.report.FileUploadServiceImpl;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.thread.LogBypassStoreEventManager;
import com.bytedance.apm.ttnet.TTNetUtils;
import com.bytedance.apm.util.FileUtils;
import com.bytedance.apm.util.JsonUtils;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.apm.util.TimeUtils;
import com.bytedance.apm6.commonevent.CommonEventDeliverer;
import com.bytedance.crash.util.ActivityUtils;
import com.bytedance.frameworks.baselib.log.SlardarLogConstants;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.monitor.collector.PerfMonitorManager;
import com.bytedance.services.apm.api.IFileUploadCallback;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.ss.thor.ThorUtils;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ApmAgent {
    private static final long CHECK_DISK_INTERVAL_MS = 3600000;
    private static final long CHILD_PROC_MAP_FILE_SIZE = 262144;
    public static boolean FAST_MODE = false;
    private static final String KEY_DEBUG_UUID = "_debug_uuid";
    private static final String KEY_SELF_DEBUG_MESSAGE = "_debug_self";
    private static final long MAIN_PROC_MAP_FILE_SIZE = 2097152;
    private static final long MAX_LOGS_SIZE = 1073741824;
    public static final String MSG_TIP_NOTHING_TO_DO_PLEASE_NOT_USE = "nothing to do, implementation code has been removed in version 5+";
    private static final long REMAINING_ROM_THRESHOLD = 1073741824;
    public static final String TAG_DEPRECATED = "Deprecated";
    private static final int WEED_OUT_FILE_NUM = 60;
    static AtomicLong atomicLong = null;
    public static boolean sDeepCopy = false;
    private static long sLastCheckDiskTime = -1;
    private static MappedByteBuffer sMappedByteBuffer;
    private static File sProcessLogsFolder;

    public interface IBatteryDataListener {
        void onData(float r1, float r2, String r3);
    }

    @Deprecated
    public static void addBlockFilter(Map<String, String> r0) {
    }

    @Deprecated
    public static void addFpsFilter(Map<String, String> r0) {
    }

    @Deprecated
    public static void monitorImageSample(String r0, int r1, String r2, long r3, JSONObject r5) {
    }

    public static void reportLegacyMonitorLog(Context r0, long r1, long r3, boolean r5) {
    }

    public ApmAgent() {
    }

    static /* synthetic */ JSONObject access$000(JSONObject r0, boolean r1) {
        return optDeepCopyJson(r0, r1);
    }

    public static void monitorSLA(final long r13, final long r15, final String r17, final String r18, final String r19, final int r20, JSONObject r21) {
        final JSONObject r10 = optShallowCopyJson(r21);
        AsyncEventManager.getInstance().post(new AnonymousClass1(r13, r15, r17, r18, r19, r20, r10));
        if (ApmContext.isInternalTest() == false) goto L6;
        LogBypassStoreEventManager.getInstance().post(new AnonymousClass2(r13, r15, r17, r18, r19, r20, r10));
        return;
    }

    public static void monitorApiError(final long r13, final long r15, final String r17, final String r18, final String r19, final int r20, JSONObject r21) {
        final JSONObject r10 = optShallowCopyJson(r21);
        AsyncEventManager.getInstance().post(new AnonymousClass3(r13, r15, r17, r18, r19, r20, r10));
        if (ApmContext.isInternalTest() == false) goto L6;
        LogBypassStoreEventManager.getInstance().post(new AnonymousClass4(r13, r15, r17, r18, r19, r20, r10));
        return;
    }

    public static void monitorSLA(final long r13, final long r15, final String r17, final String r18, final String r19, final int r20, JSONObject r21, HttpRequestInfo r22) {
        final JSONObject r10 = optShallowCopyJson(r21);
        TTNetUtils.updateNetAllExtraInfo(r22, r10);
        AsyncEventManager.getInstance().post(new AnonymousClass5(r13, r15, r17, r18, r19, r20, r10));
        if (ApmContext.isInternalTest() == false) goto L6;
        LogBypassStoreEventManager.getInstance().post(new AnonymousClass6(r13, r15, r17, r18, r19, r20, r10));
        return;
    }

    public static void monitorApiError(final long r13, final long r15, final String r17, final String r18, final String r19, final int r20, JSONObject r21, HttpRequestInfo r22, Throwable r23) {
        final JSONObject r10 = optShallowCopyJson(r21);
        TTNetUtils.updateNetErrorExtraInfo(r22, r23, r10);
        AsyncEventManager.getInstance().post(new AnonymousClass7(r13, r15, r17, r18, r19, r20, r10));
        if (ApmContext.isInternalTest() == false) goto L6;
        LogBypassStoreEventManager.getInstance().post(new AnonymousClass8(r13, r15, r17, r18, r19, r20, r10));
        return;
    }

    public static void monitorEvent(final String r3, JSONObject r4, JSONObject r5, JSONObject r6) {
        if (CommonEventDeliverer.needSkip(r3, true) == false) goto L6;
        notifyNotSampled(r3, r4);
        return;
    L6:
        JSONObject r7 = preProcessExtJson2(r6);
        addDebugMessage(r7);
        CommonEventDeliverer.monitorEvent(r3, optDeepCopyJson(r4, true), optDeepCopyJson(r5, true), r7);
        if (ApmContext.isInternalTest() == false) goto L10;
        final JSONObject r8 = optDeepCopyJson(r4, true);
        final JSONObject r9 = optDeepCopyJson(r5, true);
        final JSONObject r10 = optDeepCopyJson(r7, true);
        LogBypassStoreEventManager.getInstance().post(new AnonymousClass9(r3, r8, r9, r10));
        return;
    }

    public static void monitorEvent(final EventConfig r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (CommonEventDeliverer.needSkip(r5.getServiceName(), true) == false) goto L8;
        notifyNotSampled(r5.getServiceName(), null);
        return;
    L8:
        final JSONObject r0 = getExtraLog(r5.getExtraLog());
        addDebugMessage(r0);
        AsyncEventManager.getInstance().post(new AnonymousClass10(r5, r0));
        if (ApmContext.isInternalTest() == false) goto L12;
        final JSONObject r2 = optDeepCopyJson(r5.getCategory(), true);
        final JSONObject r3 = optDeepCopyJson(r5.getMetric(), true);
        final JSONObject r1 = optDeepCopyJson(r0, true);
        LogBypassStoreEventManager.getInstance().post(new AnonymousClass11(r5, r2, r3, r1));
        return;
    }

    private static JSONObject getExtraLog(JSONObject r3) {
        if (r3 != null) goto L5;
        r3 = new JSONObject();
    L5:
        if (r3.isNull("timestamp") == true) goto L11;
    L10:
        return r3;
    L11:
        r3.put("timestamp", System.currentTimeMillis());     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public static void monitorStatusAndEvent(final String r9, final int r10, final JSONObject r11, final JSONObject r12, JSONObject r13) {
        if (CommonEventDeliverer.needSkip(r9, true) == false) goto L6;
        notifyNotSampled(r9, r11);
        return;
    L6:
        final JSONObject r14 = optShallowCopyJson(r13);
        addDebugMessage(r14);
        AsyncEventManager.getInstance().post(new AnonymousClass12(r9, r10, r11, r12, r14));
        if (ApmContext.isInternalTest() == false) goto L10;
        final JSONObject r5 = optDeepCopyJson(r11, true);
        final JSONObject r6 = optDeepCopyJson(r12, true);
        final JSONObject r7 = optDeepCopyJson(r14, true);
        LogBypassStoreEventManager.getInstance().post(new AnonymousClass13(r9, r10, r5, r6, r7));
        return;
    }

    public static void monitorStatusRate(final String r2, final int r3, JSONObject r4) {
        if (CommonEventDeliverer.needSkip(r2, true) == false) goto L6;
        notifyNotSampled(r2, r4);
        return;
    L6:
        JSONObject r5 = preProcessExtJson2(r4);
        addDebugMessage(r5);
        CommonEventDeliverer.monitorStatusRate(r2, r3, r5);
        if (ApmContext.isInternalTest() == false) goto L10;
        final JSONObject r6 = optDeepCopyJson(r5, true);
        LogBypassStoreEventManager.getInstance().post(new AnonymousClass14(r2, r3, r6));
        return;
    }

    @Deprecated
    public static void monitorDuration(final String r2, JSONObject r3, JSONObject r4) {
        if (CommonEventDeliverer.needSkip(r2, true) == false) goto L6;
        notifyNotSampled(r2, r3);
        return;
    L6:
        JSONObject r5 = preProcessExtJson2(r4);
        addDebugMessage(r5);
        if (sDeepCopy == false) goto L9;
        JSONObject r1 = JsonUtils.safeCopyJson2(r3);
    L10:
        CommonEventDeliverer.monitorDuration(r2, r1, r5);
        if (ApmContext.isInternalTest() == false) goto L14;
        final JSONObject r6 = optDeepCopyJson(r3, true);
        final JSONObject r7 = optDeepCopyJson(r5, true);
        LogBypassStoreEventManager.getInstance().post(new AnonymousClass15(r2, r6, r7));
        return;
    L14:
        return;
    L9:
        r1 = r3;
        goto L10
    }

    @Deprecated
    public static void monitorDuration(final String r2, final JSONObject r3, JSONObject r4, long r5) {
        if (CommonEventDeliverer.needSkip(r2, true) == false) goto L6;
        notifyNotSampled(r2, r3);
        return;
    L6:
        if (r4 != null) goto L15;
    L11:
        final JSONObject r6 = optShallowCopyJson(r4);
        addDebugMessage(r6);
        AsyncEventManager.getInstance().post(new AnonymousClass16(r2, r3, r6));
        if (ApmContext.isInternalTest() == false) goto L17;
        final JSONObject r7 = optDeepCopyJson(r3, true);
        final JSONObject r8 = optDeepCopyJson(r6, true);
        LogBypassStoreEventManager.getInstance().post(new AnonymousClass17(r2, r7, r8));
        return;
    L17:
        return;
    L15:
        r4.put("timestamp", r5);     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    @Deprecated
    public static void monitorStatusAndDuration(final String r4, final int r5, JSONObject r6, JSONObject r7) {
        if (CommonEventDeliverer.needSkip(r4, true) == false) goto L6;
        notifyNotSampled(r4, r6);
        return;
    L6:
        JSONObject r1 = optShallowCopyJson(r7);
        addDebugMessage(r1);
        CommonEventDeliverer.monitorStatusAndDuration(r4, r5, optDeepCopyJson(r6, true), optDeepCopyJson(r1, false));
        if (ApmContext.isInternalTest() == false) goto L10;
        final JSONObject r8 = optDeepCopyJson(r6, true);
        final JSONObject r9 = optDeepCopyJson(r7, true);
        LogBypassStoreEventManager.getInstance().post(new AnonymousClass18(r4, r5, r8, r9));
        return;
    }

    public static void monitorCommonLog(String r1, JSONObject r2) {
        monitorCommonLog(r1, r2, false);
    }

    public static void monitorExceptionLog(final String r2, JSONObject r3) {
        final JSONObject r4 = preProcessExtJson2(r3);
        AsyncEventManager.getInstance().post(new AnonymousClass19(r2, r4));
        if (ApmContext.isInternalTest() == false) goto L6;
        LogBypassStoreEventManager.getInstance().post(new AnonymousClass20(r2, r4));
        return;
    }

    public static void monitorCommonLog(final String r2, JSONObject r3, final boolean r4) {
        if (CommonEventDeliverer.needSkip(r2, false) == false) goto L6;
        notifyNotSampled(r2, r3);
        return;
    L6:
        final JSONObject r5 = preProcessExtJson2(r3);
        addDebugMessage(r5);
        AsyncEventManager.getInstance().post(new AnonymousClass21(r2, r5));
        if (ApmContext.isInternalTest() == false) goto L10;
        final JSONObject r6 = optDeepCopyJson(r5, true);
        LogBypassStoreEventManager.getInstance().post(new AnonymousClass22(r2, r6, r4));
        return;
    }

    public static boolean getServiceSwitch(String r1) {
        return ApmDelegate.getInstance().getServiceNameSwitch(r1);
    }

    public static boolean getLogTypeSwitch(String r1) {
        return ApmDelegate.getInstance().getLogTypeSwitch(r1);
    }

    @Deprecated
    public static void setReportMode(ApmReportConfig r1) {
        ApmDelegate.getInstance().setReportConfig(r1);
    }

    @Deprecated
    public static boolean getMetricsSwitch(String r1) {
        return ApmDelegate.getInstance().getMetricsTypeSwitch(r1);
    }

    public static boolean isConfigReady() {
        return ApmDelegate.getInstance().isConfigReady();
    }

    public static void monitorPageLoad(JSONObject r2, JSONObject r3) {
        monitorPerformance("page_load", "page_load", r2, r3, null);     // Catch: Exception -> L5
        return;
    }

    public static void monitorUIAction(String r1, String r2, JSONObject r3) {
        monitorUIAction(r1, r2, r3, null);
    }

    public static void monitorUIAction(final String r2, final String r3, final JSONObject r4, JSONObject r5) {
        if (sDeepCopy == false) goto L5;
        final JSONObject r6 = preProcessExtJson(r5);     // Catch: Exception -> L10
    L6:
        AsyncEventManager.getInstance().post(new AnonymousClass23(r2, r3, r4, r6));     // Catch: Exception -> L10
        if (ApmContext.isInternalTest() == false) goto L13;
        LogBypassStoreEventManager.getInstance().post(new AnonymousClass24(r2, r3, r4, r6));     // Catch: Exception -> L10
        return;
    L13:
        return;
    L5:
        r6 = preProcessExtJson2(r5);     // Catch: Exception -> L10
    }

    public static void monitorPerformance(String r1, JSONObject r2, JSONObject r3, JSONObject r4) {
        monitorPerformance(r1, "", r2, r3, r4);
    }

    public static void monitorPerformance(final String r8, final String r9, final JSONObject r10, final JSONObject r11, JSONObject r12) {
        if (sDeepCopy == false) goto L5;
        JSONObject r13 = preProcessExtJson(r12);     // Catch: Exception -> L10
    L6:
        final JSONObject r5 = r13;
        AsyncEventManager.getInstance().post(new AnonymousClass25(r8, r9, r10, r11, r5));     // Catch: Exception -> L10
        if (ApmContext.isInternalTest() == false) goto L13;
        final JSONObject r6 = r13;
        LogBypassStoreEventManager.getInstance().post(new AnonymousClass26(r8, r9, r10, r11, r6));     // Catch: Exception -> L10
        return;
    L13:
        return;
    L5:
        r13 = preProcessExtJson2(r12);     // Catch: Exception -> L10
    }

    @Deprecated
    public static void monitorDirectOnTimer(final String r2, final String r3, final float r4) {
        AsyncEventManager.getInstance().post(new AnonymousClass27(r2, r3, r4));
        if (ApmContext.isInternalTest() == false) goto L6;
        LogBypassStoreEventManager.getInstance().post(new AnonymousClass28(r2, r3, r4));
        return;
    }

    private static JSONObject preProcessExtJson(JSONObject r4) {
        JSONObject r1 = JsonUtils.copyJson2(r4);     // Catch: Exception -> L10
        if (r1 != null) goto L7;
        r1 = new JSONObject();     // Catch: Exception -> L10
    L7:
        if (r1.isNull("timestamp") == false) goto L9;
        r1.put("timestamp", System.currentTimeMillis());     // Catch: Exception -> L10
    L9:
        return r1;
    L10:
        return r4;
    }

    private static JSONObject preProcessExtJson2(JSONObject r3) {
        if (r3 != null) goto L6;
        r3 = new JSONObject();     // Catch: Exception -> L9
    L8:
        return r3;
    L6:
        if (r3.isNull("timestamp") == false) goto L8;
        r3.put("timestamp", System.currentTimeMillis());     // Catch: Exception -> L9
        goto L8
    }

    public static void activeUploadAlog(String r9, long r10, long r12, String r14, IALogActiveUploadObserver r15, IALogActiveUploadCallback r16) {
        ApmDelegate.getInstance().activeUploadAlog(r9, r10, r12, r14, r15, r16);
    }

    public static void activeUploadAlog(String r8, long r9, long r11, String r13, IALogActiveUploadObserver r14) {
        activeUploadAlog(r8, r9, r11, r13, r14, null);
    }

    public static void activeUploadAlog(long r7, long r9, String r11, IALogActiveUploadObserver r12) {
        activeUploadAlog("", r7, r9, r11, r12);
    }

    public static int reportThreadCount(String r1) {
        return ThreadCollector.reportThreadCount(r1, true);
    L5:
        return 0;
    }

    public static void trafficStats(long r8, String r10, String r11, String r12, JSONObject r13, JSONObject r14) {
        BizTrafficStats.getInstance().trafficStats(r8, r10, r11, r12, r13, r14);
    }

    public static void startTrafficStats(String r2) {
        TrafficCollector.getInstance().startMetric(r2, false);
    }

    public static void startTrafficStats(String r1, boolean r2) {
        TrafficCollector.getInstance().startMetric(r1, r2);
    }

    public static void stopTrafficStats(String r1) {
        TrafficCollector.getInstance().stopMetric(r1);
    }

    public static void startScene(String r1) {
        PerfFilterManager.getInstance().startScene(r1);
        com.bytedance.apm6.perf.base.PerfFilterManager.getInstance().startScene(r1);
    }

    public static void stopScene(String r1) {
        PerfFilterManager.getInstance().stopScene(r1);
        com.bytedance.apm6.perf.base.PerfFilterManager.getInstance().stopScene(r1);
    }

    public static void addPerfTag(String r1, String r2) {
        PerfFilterManager.getInstance().addPerfTag(r1, r2);
        com.bytedance.apm6.perf.base.PerfFilterManager.getInstance().addPerfTag(r1, r2);
    }

    public static void removePerfTag(String r1, String r2) {
        PerfFilterManager.getInstance().removePerfTag(r1, r2);
        com.bytedance.apm6.perf.base.PerfFilterManager.getInstance().removePerfTag(r1, r2);
    }

    public static void startCollectCurrent(final String r2) {
        if (ApmContext.getContext() == null) goto L5;
        AsyncEventManager.getInstance().post(new AnonymousClass29(r2));
        return;
    L5:
        ApmAlogHelper.i(SlardarLogConstants.TAG_ALOG, "ApmAgent#startCollectCurrent  apm do not be init");
    }

    public static void stopCollectCurrent(final String r2) {
        if (ApmContext.getContext() == null) goto L5;
        AsyncEventManager.getInstance().post(new AnonymousClass30(r2));
        return;
    L5:
        ApmAlogHelper.i(SlardarLogConstants.TAG_ALOG, "ApmAgent#stopCollectCurrent  apm do not be init");
    }

    public static void startBatteryCollect(String r1) {
        if (ApmContext.getContext() == null) goto L5;
        BatteryCollector.getInstance().startSceneMonitor(r1);
        return;
    L5:
        ApmAlogHelper.i(SlardarLogConstants.TAG_ALOG, "ApmAgent#startBatteryCollect  apm do not be init");
    }

    public static void stopBatteryCollect(String r1) {
        if (ApmContext.getContext() == null) goto L5;
        BatteryCollector.getInstance().stopSceneMonitor(r1);
        return;
    L5:
        ApmAlogHelper.i(SlardarLogConstants.TAG_ALOG, "ApmAgent#startBatteryCollect  apm do not be init");
    }

    public static void configSceneMinDuration(HashMap<String, Long> r1) {
        ProcessEnergyCollector.getInstance().configSceneMinDuration(r1);
    }

    public static void startCpuMonitor(final String r2) {
        if (ApmContext.getContext() == null) goto L5;
        AsyncEventManager.getInstance().post(new AnonymousClass31(r2));
        return;
    L5:
        ApmAlogHelper.i(SlardarLogConstants.TAG_ALOG, "ApmAgent#startCpuMonitor  apm do not be init");
    }

    public static void stopCpuMonitor(final String r2) {
        if (ApmContext.getContext() == null) goto L5;
        AsyncEventManager.getInstance().post(new AnonymousClass32(r2));
        return;
    L5:
        ApmAlogHelper.i(SlardarLogConstants.TAG_ALOG, "ApmAgent#stopCpuMonitor  apm do not be init");
    }

    public static void addBatteryDataListener(IBatteryDataListener r1) {
        BatteryTemperatureCollector.getInstance().addBatteryDataListener(r1);
    }

    public static void uploadMappingFile(String r10, IFileUploadCallback r11) {
        String r2 = ApmContext.getHeaderInner().optString("aid");
        String r3 = ApmContext.getHeaderInner().optString("update_version_code");
        String r4 = ApmContext.getHeaderInner().optString("channel");
        String r5 = ApmContext.getHeaderInner().optString("release_build");
        String r8 = ApmContext.getHeaderInner().optString("device_id");
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L13:
        if (r11 == null) goto L16;
        r11.onFail("Missing required parameters");
        return;
    L16:
        return;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L13;
        if (TextUtils.isEmpty(r4) == true) goto L13;
        if (TextUtils.isEmpty(r5) == true) goto L13;
        FileUploadServiceImpl.uploadMappingFiles(r2, r3, r4, r5, r10, null, r8, r11);
    }

    public static void uploadMappingFile(String r8, String r9, String r10, String r11, String r12, IFileUploadCallback r13, String r14) {
        if (TextUtils.isEmpty(r9) == false) goto L5;
    L15:
        if (r13 == null) goto L18;
        r13.onFail("Missing required parameters");
        return;
    L18:
        return;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L15;
        if (TextUtils.isEmpty(r11) == true) goto L15;
        if (TextUtils.isEmpty(r12) == true) goto L15;
        if (TextUtils.isEmpty(r14) == true) goto L15;
        FileUploadServiceImpl.setMappingFileUploadHost(r14);
        FileUploadServiceImpl.uploadMappingFiles(r9, r10, r11, r12, r8, null, r13);
    }

    public static void uploadMappingFile(String r8, String r9, String r10, String r11, String r12, IFileUploadCallback r13, String r14, String r15) {
        if (TextUtils.isEmpty(r9) == false) goto L5;
    L17:
        if (r13 == null) goto L20;
        r13.onFail("Missing required parameters");
        return;
    L20:
        return;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L17;
        if (TextUtils.isEmpty(r11) == true) goto L17;
        if (TextUtils.isEmpty(r12) == true) goto L17;
        if (TextUtils.isEmpty(r15) == true) goto L17;
        if (TextUtils.isEmpty(r14) == true) goto L17;
        FileUploadServiceImpl.setMappingFileUploadHost(r14);
        FileUploadServiceImpl.uploadMappingFiles(r9, r10, r11, r12, r8, null, r15, r13);
    }

    public static void uploadMappingFile(String r8, String r9, String r10, String r11, String r12, IFileUploadCallback r13) {
        if (TextUtils.isEmpty(r9) == false) goto L5;
    L13:
        if (r13 == null) goto L16;
        r13.onFail("Missing required parameters");
        return;
    L16:
        return;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L13;
        if (TextUtils.isEmpty(r11) == true) goto L13;
        if (TextUtils.isEmpty(r12) == true) goto L13;
        uploadMappingFileInternal(r8, r9, r10, r11, r12, null, r13);
    }

    public static void uploadMappingFile(String r1, String r2, String r3, String r4, String r5, String r6, IFileUploadCallback r7) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L15:
        if (r7 == null) goto L18;
        r7.onFail("Missing required parameters");
        return;
    L18:
        return;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L15;
        if (TextUtils.isEmpty(r4) == true) goto L15;
        if (TextUtils.isEmpty(r5) == true) goto L15;
        if (TextUtils.isEmpty(r6) == true) goto L15;
        uploadMappingFileInternal(r1, r2, r3, r4, r5, r6, r7);
    }

    private static void uploadMappingFileInternal(String r9, String r10, String r11, String r12, String r13, String r14, IFileUploadCallback r15) {
        if (ListUtils.isEmpty(ReportUrl.REPORT_URL_LIST) == false) goto L12;
        if (r15 == null) goto L14;
        r15.onFail("need host");
        return;
    L14:
        return;
    L12:
        FileUploadServiceImpl.setMappingFileUploadHost(new URL(ReportUrl.REPORT_URL_LIST.get(0)).getHost());     // Catch: MalformedURLException -> L9
        FileUploadServiceImpl.uploadMappingFiles(r10, r11, r12, r13, r9, null, r14, r15);     // Catch: MalformedURLException -> L9
        return;
    L9:
        if (r15 == null) goto L15;
        r15.onFail("MalformedURLException");
        return;
    }

    public static void feedbackReport(final long r8, final long r10, final boolean r12) {
        AsyncEventManager.getInstance().post(new AnonymousClass33(r8, r10, r12));
    }

    private static void reportFeedbackInfo() {
    L17:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (TemperatureDataManager.getInstance().isRegistered() == false) goto L5;
    L7:
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L17
        JSONObject r1 = PerfFilterManager.getInstance().getPerfFiltersJson(true);     // Catch: JSONException -> L17
        r1.put("crash_section", ApmContext.getTimeRange(System.currentTimeMillis()));     // Catch: JSONException -> L17
        r1.put("crash_type", "feedback");     // Catch: JSONException -> L17
        JSONObject r2 = PerfMonitorManager.getInstance().dumpInfos();     // Catch: JSONException -> L17
        r2.put("activity_track", ActivityUtils.getActivityTrack());     // Catch: JSONException -> L17
        r2.put("cpu_info", PerfDataCenter.getInstance().getCpuInfo());     // Catch: JSONException -> L17
        r2.put("memory_info", getMemInfo(PerfCollectUtils.getMemory(ApmContext.getContext())));     // Catch: JSONException -> L17
        r2.put(CommonServiceName.MONITOR_TYPE_TEMPERATURE, TemperatureDataManager.getInstance().getTemperature());     // Catch: JSONException -> L17
        String r3 = MethodCollector.getInstance().getEvilMethod(0, SystemClock.uptimeMillis());     // Catch: JSONException -> L17
        if (TextUtils.isEmpty(r3) == true) goto L10;
        r2.put("evil_method", r3);     // Catch: JSONException -> L17
        r1.put(CommonKey.KEY_WITH_EVIL_METHOD, "true");     // Catch: JSONException -> L17
    L10:
        String r4 = PerfMonitorManager.getInstance().dumpSortedStackTrace(0, SystemClock.uptimeMillis());     // Catch: JSONException -> L17
        if (TextUtils.isEmpty(r4) == false) goto L13;
    L15:
        r2.put("battery", getCapacity());     // Catch: JSONException -> L17
        r2.put("battery_current", getGalvanicNow());     // Catch: JSONException -> L17
        r0.put("custom", r2);     // Catch: JSONException -> L17
        r0.put("filters", r1);     // Catch: JSONException -> L17
        r0.put("stack", "at feedback.*(a.java:-1)");     // Catch: JSONException -> L17
        r0.put("event_type", ExceptionTypeName.EXCEPTION_EVENT_TYPE_SERIOUS_LAG);     // Catch: JSONException -> L17
        ExceptionLogData r5 = new ExceptionLogData("serious_block_monitor", r0);     // Catch: JSONException -> L17
        r5.forceSample();     // Catch: JSONException -> L17
        CommonDataPipeline.getInstance().handle(r5);     // Catch: JSONException -> L17
        return;
    L13:
        if (r4.length() <= 10) goto L15;
        r2.put("profiler_monitor", r4);     // Catch: JSONException -> L17
        goto L15
    L5:
        if (ApmContext.getContext() == null) goto L7;
        TemperatureDataManager.getInstance().registerTemperatureReceiver();     // Catch: JSONException -> L17
        goto L7
    }

    private static JSONObject getCapacity() {
        JSONObject r0 = new JSONObject();
        r0.put("battery_percent", ThorUtils.getCapacity(ApmContext.getContext()));     // Catch: JSONException -> L9
        JSONObject r1 = BatteryDataManager.getInstance().getMainThreadBatteryData();     // Catch: JSONException -> L9
        if (r1.length() != 0) goto L7;
        r0.put("more", "no-more-info");     // Catch: JSONException -> L9
    L12:
    L11:
        return r0;
    L7:
        r0.put("more", r1);     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    private static JSONObject getGalvanicNow() {
        JSONObject r0 = new JSONObject();
        r0.put("battery_current", ThorUtils.getGalvanicNow(ApmContext.getContext()));     // Catch: JSONException -> L5
        r0.put("scene", ActivityLifeObserver.getInstance().getTopActivityClassName());     // Catch: JSONException -> L5
    L7:
        return r0;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    private static JSONObject getMemInfo(MemoryInfo r4) throws JSONException {
        JSONObject r0 = new JSONObject();
        r0.put("javaTotalMemory", r4.javaTotalMemory);
        r0.put("javaFreeMemory", r4.javaFreeMemory);
        r0.put("javaUsedMemory", r4.javaUsedMemory);
        r0.put("pssDalvik", r4.pssDalvik);
        r0.put("pssNative", r4.pssNative);
        r0.put("pssTotal", r4.pssTotal);
        r0.put("graphics", r4.graphics);
        r0.put("vmSize", r4.vmSize);
        return r0;
    }

    public static void storeLogBypass(String r18, String r19) {
        monitor-enter(ApmAgent.class);     // Catch: Throwable -> L40
        String r0 = ApmContext.getCurrentProcessName();     // Catch: Throwable -> L36
        long r2 = Thread.currentThread().getId();     // Catch: Throwable -> L36
        long r4 = System.currentTimeMillis();     // Catch: Throwable -> L36
        String r6 = TimeUtils.getCurrentFormatTime();     // Catch: Throwable -> L36
        StringBuffer r7 = new StringBuffer();     // Catch: Throwable -> L36
        r7.append(r18).append("#").append(r2).append("#").append(r4).append("#").append(r6).append("\n").append(r19).append("\n");     // Catch: Throwable -> L36
        byte[] r3 = r7.toString().getBytes("UTF-8");     // Catch: Throwable -> L36
        String r5 = ApmContext.getContext().getExternalFilesDir(null).getAbsolutePath();     // Catch: Throwable -> L36
        if (sMappedByteBuffer != null) goto L18;
        File r8 = new File(r5 + "/logs");     // Catch: Throwable -> L36
        sProcessLogsFolder = new File(r5 + "/logs/proc: " + r0);     // Catch: Throwable -> L36
        File r9 = new File(r5 + "/logs/proc: " + r0 + LibrarianImpl.Constants.SEPARATOR + r6);     // Catch: Throwable -> L36
        if (r8.exists() == true) goto L10;
        r8.mkdirs();     // Catch: Throwable -> L36
    L10:
        if (sProcessLogsFolder.exists() == true) goto L12;
        sProcessLogsFolder.mkdirs();     // Catch: Throwable -> L36
    L12:
        r9.createNewFile();     // Catch: Throwable -> L36
        FileChannel r12 = new RandomAccessFile(r9, "rw").getChannel();     // Catch: Throwable -> L36
        FileChannel.MapMode r13 = FileChannel.MapMode.READ_WRITE;     // Catch: Throwable -> L36
        if (ApmContext.isMainProcess() == false) goto L15;
        long r16 = 2097152;
    L16:
        sMappedByteBuffer = r12.map(r13, 0, r16);     // Catch: Throwable -> L36
        goto L18
    L15:
        r16 = 262144;
    L18:
        if (sMappedByteBuffer.remaining() >= r3.length) goto L24;
        sMappedByteBuffer.force();     // Catch: Throwable -> L36
        FileChannel r11 = new RandomAccessFile(new File(r5 + "/logs/proc: " + r0 + LibrarianImpl.Constants.SEPARATOR + r6), "rw").getChannel();     // Catch: Throwable -> L36
        FileChannel.MapMode r14 = FileChannel.MapMode.READ_WRITE;     // Catch: Throwable -> L36
        if (ApmContext.isMainProcess() == false) goto L22;
        long r15 = 2097152;
    L23:
        sMappedByteBuffer = r11.map(r14, 0, r15);     // Catch: Throwable -> L36
        goto L24
    L22:
        r15 = 262144;
    L24:
        sMappedByteBuffer.put(r3);     // Catch: Throwable -> L36
        if (sLastCheckDiskTime == (-1)) goto L29;
        if ((System.currentTimeMillis() - sLastCheckDiskTime) > 3600000) goto L29;
    L34:
        monitor-exit(ApmAgent.class);     // Catch: Throwable -> L36
        goto L45
    L39:
        return;
    L29:
        if (FileUtils.getSize(sProcessLogsFolder) <= org.apache.commons.io.FileUtils.ONE_GB) goto L31;
    L32:
        weedOutOldestLogFiles();     // Catch: Throwable -> L36
    L33:
        sLastCheckDiskTime = System.currentTimeMillis();     // Catch: Throwable -> L36
        goto L34
    L31:
        if (FileUtils.getExternalRootDir(ApmContext.getContext()).getFreeSpace() >= org.apache.commons.io.FileUtils.ONE_GB) goto L33;
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L40
    }

    private static void weedOutOldestLogFiles() {
        if (ApmContext.isMainProcess() == true) goto L6;
        return;
    L6:
        if (sProcessLogsFolder.exists() == true) goto L8;
        return;
    L8:
        File[] r0 = sProcessLogsFolder.listFiles();
        Arrays.sort(r0, new AnonymousClass34());
        int r2 = 60;
        if (r0.length > 60) goto L12;
        r2 = r0.length;
    L12:
        int r1 = 0;
    L13:
        if (r1 >= r2) goto L15;
        r0[r1].delete();
        r1 = r1 + 1;
        goto L13
    }

    static {
        atomicLong = new AtomicLong(0);
    }

    private static void addDebugMessage(JSONObject r6) {
        if (r6 != null) goto L7;
        return;
    L7:
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L6
        r0.put(KEY_DEBUG_UUID, ApmContext.getStartId() + "_" + atomicLong.getAndAdd(1));     // Catch: Exception -> L6
        r6.put(KEY_SELF_DEBUG_MESSAGE, r0);     // Catch: Exception -> L6
        return;
    }

    private static JSONObject optShallowCopyJson(JSONObject r1) {
        if (FAST_MODE == false) goto L6;
        return JsonUtils.safeJsonObject(r1);
    L6:
        return preProcessExtJson2(r1);
    }

    private static JSONObject optDeepCopyJson(JSONObject r1, boolean r2) {
        if (FAST_MODE == false) goto L8;
        if (r2 == true) goto L7;
        return r1;
    L7:
        return JsonUtils.safeJsonObject(r1);
    L8:
        return JsonUtils.deepCopy(r1);
    }

    private static void notifyNotSampled(String r1, JSONObject r2) {
        if (ApmContext.isDebugMode() == false) goto L8;
        if (r2 != null) goto L6;
        r2 = new JSONObject();
    L6:
        DoctorDataUtil.onReceivedEvent(r1, r2, false);
        return;
    }
}
