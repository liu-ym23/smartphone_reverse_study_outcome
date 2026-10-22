package com.bytedance.apm;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm.core.DefaultDynamicParams;
import com.bytedance.apm.core.IDynamicParams;
import com.bytedance.apm.core.IQueryParams;
import com.bytedance.apm.net.DefaultHttpServiceImpl;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.apm.util.AppUtils;
import com.bytedance.apm.util.JsonUtils;
import com.bytedance.apm.util.RomUtils;
import com.bytedance.apm.util.SlardarProperties;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.IMultipartUploader;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ApmContext {
    private static boolean isInitFinish;
    private static CommonParams params;
    private static ApmProgressListener progressListener;
    private static String sAlogFilesDir;
    private static long sAppLaunchStartTimestamp;
    private static boolean sAutomationTest;
    private static Context sContext;
    private static String sCurrentProcessName;
    private static boolean sDebugMode;
    private static boolean sDoctorDebugMode;
    private static IDynamicParams sDynamicParams;
    private static boolean sExceptionTrafficDetect;
    private static JSONObject sHeader;
    private static IHttpService sHttpService;
    private static long sInitCostTime;
    private static long sInitCostTime6;
    static long sInitCostTimeStep2;
    static long sInitCostTimeStep3;
    static long sInitCostTimeStep4;
    static long sInitCostTimeStep5;
    private static long sInitTimeStamp;
    private static boolean sIsApm6Enable;
    private static boolean sIsDeviceInfoOnPerfDataEnabled;
    private static boolean sIsInternalTest;
    private static boolean sIsMainProcess;
    private static volatile int sLaunchMode;
    private static boolean sNeedSalvage;
    private static IQueryParams sQueryParams;
    private static Map<String, String> sQueryParamsMap;
    private static long sReportSeqNo;
    private static List<String> sSlardarConfigUrls;
    private static long sStartCostTime;
    private static long sStartId;
    private static long sStartTimeStamp;
    private static long sStartupTimestamp;
    private static boolean sStopWhenBackground;
    private static boolean sSupportMultiFrameRate;

    static {
        sHeader = new JSONObject();
        sDynamicParams = new DefaultDynamicParams();
        sQueryParamsMap = Collections.emptyMap();
        sHttpService = new DefaultHttpServiceImpl();
        sStartId = -1;
        sLaunchMode = -1;
        sStopWhenBackground = false;
        sReportSeqNo = 0;
        sNeedSalvage = true;
        sIsApm6Enable = true;
        isInitFinish = false;
        progressListener = null;
        sQueryParams = null;
    }

    public ApmContext() {
    }

    public static IMultipartUploader buildMultipartUploader(String r1, String r2, boolean r3) {
        return sHttpService.buildMultipartUpload(r1, r2, r3);
    }

    public static HttpResponse doGet(String r1, Map<String, String> r2) {
        return sHttpService.doGet(r1, r2);
    }

    public static HttpResponse doPost(String r1, byte[] r2, Map<String, String> r3) {
        return sHttpService.doPost(r1, r2, r3);
    }

    public static boolean extendHeader(String r2, String r3) {
        JSONObject r0 = sHeader;
        if (r0 != null) goto L9;
        return false;
    L9:
        r0.put(r2, r3);     // Catch: JSONException -> L8
        return true;
    L8:
        return false;
    }

    public static String getAlogFilesDir() {
        return sAlogFilesDir;
    }

    public static long getAppLaunchStartTimestamp() {
        return sAppLaunchStartTimestamp;
    }

    public static Context getContext() {
        return sContext;
    }

    public static String getCurrentProcessName() {
        if (TextUtils.isEmpty(sCurrentProcessName) == false) goto L6;
        sCurrentProcessName = AppUtils.getProcessName(Process.myPid());
    L6:
        return sCurrentProcessName;
    }

    public static long getDeltaTime() {
        return System.currentTimeMillis() - SystemClock.uptimeMillis();
    }

    public static IDynamicParams getDynamicParams() {
        return sDynamicParams;
    }

    public static JSONObject getHeader() {
        return sHeader;
    }

    public static IHttpService getHttpService() {
        return sHttpService;
    }

    public static long getInitCostTime() {
        return sInitCostTime;
    }

    public static long getInitCostTimeIncludingApm6() {
        return sInitCostTime6;
    }

    public static long getInitCostTimeStep2() {
        return sInitCostTimeStep2;
    }

    public static long getInitCostTimeStep3() {
        return sInitCostTimeStep3;
    }

    public static long getInitCostTimeStep4() {
        return sInitCostTimeStep4;
    }

    public static long getInitCostTimeStep5() {
        return sInitCostTimeStep5;
    }

    public static long getInitTimeStamp() {
        if (sInitTimeStamp != 0) goto L6;
        sInitTimeStamp = System.currentTimeMillis();
    L6:
        return sInitTimeStamp;
    }

    public static long getInitUpTimestamp() {
        return sStartupTimestamp;
    }

    public static int getLaunchMode() {
        return sLaunchMode;
    }

    public static String getNetType() {
        String r0 = sHttpService.getClass().getSimpleName();
        if ("DefaultTTNetImpl".equals(r0) == false) goto L6;
        return ApmTrafficStats.KEY_TRAFFIC_SOURCE_TTNET;
    L6:
        return r0;
    }

    public static String getPackageName() {
        Context r0 = sContext;
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0.getPackageName();
    }

    public static synchronized CommonParams getParams() {
        monitor-enter(ApmContext.class);
        CommonParams r1 = params;     // Catch: Throwable -> L7
        monitor-exit(ApmContext.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized Map<String, String> getParamsExtras() {
        monitor-enter(ApmContext.class);
        IQueryParams r1 = sQueryParams;     // Catch: Throwable -> L15
        if (r1 == null) goto L19;
        Map<String, String> r2 = r1.getQueryParams();     // Catch: Throwable -> L15
        if (r2 == null) goto L19;
        if (r2.size() <= 0) goto L19;
        if (params.getParamExtras() == null) goto L17;
        HashMap r3 = new HashMap(params.getParamExtras());     // Catch: Throwable -> L15
        r3.putAll(r2);     // Catch: Throwable -> L15
        monitor-exit(ApmContext.class);
        return r3;
    L17:
        monitor-exit(ApmContext.class);
        return r2;
    L19:
        CommonParams r4 = params;     // Catch: Throwable -> L15
        if (r4 == null) goto L24;
        Map<String, String> r5 = r4.getParamExtras();     // Catch: Throwable -> L15
        monitor-exit(ApmContext.class);
        return r5;
    L24:
        monitor-exit(ApmContext.class);
        return null;
    L15:
        th = move-exception;
        throw th;
    }

    public static ApmProgressListener getProgressListener() {
        return progressListener;
    }

    public static synchronized IQueryParams getQueryParams() {
        monitor-enter(ApmContext.class);
        IQueryParams r1 = sQueryParams;     // Catch: Throwable -> L7
        monitor-exit(ApmContext.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized Map<String, String> getQueryParamsMap() {
        monitor-enter(ApmContext.class);
        IQueryParams r1 = sQueryParams;     // Catch: Throwable -> L13
        if (r1 == null) goto L15;
        Map<String, String> r2 = r1.getQueryParams();     // Catch: Throwable -> L13
        if (r2 == null) goto L15;
        if (r2.size() <= 0) goto L15;
        HashMap r3 = new HashMap(sQueryParamsMap);     // Catch: Throwable -> L13
        r3.putAll(r2);     // Catch: Throwable -> L13
        monitor-exit(ApmContext.class);
        return r3;
    L15:
        Map<String, String> r4 = sQueryParamsMap;     // Catch: Throwable -> L13
        monitor-exit(ApmContext.class);
        return r4;
    L13:
        th = move-exception;
        throw th;
    }

    public static long getReportSeqNo() {
        long r0 = sReportSeqNo;
        sReportSeqNo = 1 + r0;
        return r0;
    }

    public static List<String> getSlardarConfigUrls() {
        return sSlardarConfigUrls;
    }

    public static long getStartCostTime() {
        return sStartCostTime;
    }

    public static long getStartId() {
        if (sStartId != (-1)) goto L6;
        sStartId = System.currentTimeMillis();
    L6:
        return sStartId;
    }

    public static long getStartTimeStamp() {
        return sStartTimeStamp;
    }

    public static String getTimeRange(long r2) {
        long r3 = r2 - sInitTimeStamp;
        if (r3 >= 30000) goto L7;
        return "0 - 30s";
    L7:
        if (r3 >= 60000) goto L11;
        return "30s - 1min";
    L11:
        if (r3 >= 120000) goto L15;
        return "1min - 2min";
    L15:
        if (r3 >= 300000) goto L19;
        return "2min - 5min";
    L19:
        if (r3 >= 600000) goto L23;
        return "5min - 10min";
    L23:
        if (r3 >= 1800000) goto L27;
        return "10min - 30min";
    L27:
        if (r3 >= 3600000) goto L30;
        return "30min - 1h";
    L30:
        return "1h - ";
    }

    public static boolean isAutomationTest() {
        return sAutomationTest;
    }

    public static boolean isDebugMode() {
        if (sDebugMode == false) goto L5;
    L8:
        return true;
    L5:
        if (sDoctorDebugMode == true) goto L8;
        return false;
    }

    public static boolean isDeviceInfoOnPerfDataEnabled() {
        return sIsDeviceInfoOnPerfDataEnabled;
    }

    public static boolean isDoctorDebugMode() {
        return sDoctorDebugMode;
    }

    public static boolean isExceptionTrafficSwitchOn() {
        return sExceptionTrafficDetect;
    }

    public static boolean isInitFinish() {
        return isInitFinish;
    }

    public static boolean isInternalTest() {
        return sIsInternalTest;
    }

    public static boolean isLocalChannel() {
        JSONObject r0 = sHeader;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.optString("channel") != null) goto L8;
        return false;
    L8:
        return sHeader.optString("channel").contains("local");
    }

    public static boolean isMainProcess() {
        boolean r1 = true;
        if (sIsMainProcess == false) goto L6;
        return true;
    L6:
        if (sContext == null) goto L8;
        String r0 = getCurrentProcessName();
        if (r0 != null) goto L12;
    L14:
        if (r0 != null) goto L16;
    L18:
        r1 = false;
    L19:
        sIsMainProcess = r1;
    L21:
        return sIsMainProcess;
    L16:
        if (r0.equals(sContext.getPackageName()) == false) goto L18;
    L12:
        if (r0.contains(":") == false) goto L14;
        sIsMainProcess = false;
        goto L21
    L8:
        return isMainProcessSimple();
    }

    public static boolean isMainProcessSimple() {
        if (sIsMainProcess == false) goto L5;
        return true;
    L5:
        String r0 = getCurrentProcessName();
        if (r0 != null) goto L8;
    L11:
        return true;
    L8:
        if (r0.contains(":") == false) goto L11;
        return false;
    }

    public static boolean isNeedSalvage() {
        return sNeedSalvage;
    }

    public static boolean isStopWhenBackground() {
        return sStopWhenBackground;
    }

    public static void setAlogFilesDir(String r0) {
        sAlogFilesDir = r0;
    }

    public static void setAppLaunchStartTimestamp(long r4) {
        if (r4 > 0) goto L5;
        return;
    L5:
        long r2 = sAppLaunchStartTimestamp;
        if (r2 != 0) goto L8;
    L9:
        sAppLaunchStartTimestamp = r4;
        return;
    L8:
        if (r4 < r2) goto L9;
    }

    public static void setAutomationTest(boolean r0) {
        sAutomationTest = r0;
    }

    public static void setContext(Context r0) {
        if (r0 != null) goto L4;
        return;
    L4:
        sContext = AppUtils.getApplication(r0);
    }

    public static void setCurrentProcessName(String r0) {
        sCurrentProcessName = r0;
    }

    public static void setDebugMode(boolean r0) {
        sDebugMode = r0;
        ApmBaseContext.setDebugMode(isDebugMode());
    }

    public static void setDeviceInfoOnPerfDataEnabled(boolean r0) {
        sIsDeviceInfoOnPerfDataEnabled = r0;
    }

    public static void setDoctorDebugMode(boolean r0) {
        sDoctorDebugMode = r0;
        ApmBaseContext.setDebugMode(isDebugMode());
    }

    public static synchronized void setDynamicParams(IDynamicParams r4) {
        monitor-enter(ApmContext.class);
        sDynamicParams = r4;     // Catch: Throwable -> L7
        Map<String, String> r5 = r4.getCommonParams();     // Catch: Throwable -> L7
        sQueryParamsMap = r5;     // Catch: Throwable -> L7
        if (r5 != null) goto L10;
        sQueryParamsMap = new HashMap();     // Catch: Throwable -> L7
    L10:
        if (sQueryParamsMap.containsKey("aid") == true) goto L13;
        sQueryParamsMap.put("aid", sHeader.optString("aid"));     // Catch: Throwable -> L7
    L13:
        if (sQueryParamsMap.containsKey("device_id") == true) goto L16;
        sQueryParamsMap.put("device_id", sHeader.optString("device_id"));     // Catch: Throwable -> L7
    L16:
        if (sQueryParamsMap.containsKey("device_platform") == true) goto L18;
        sQueryParamsMap.put("device_platform", "android");     // Catch: Throwable -> L7
    L18:
        sQueryParamsMap.put("os", "Android");     // Catch: Throwable -> L7
        if (sQueryParamsMap.containsKey("update_version_code") == true) goto L22;
        sQueryParamsMap.put("update_version_code", sHeader.optString("update_version_code"));     // Catch: Throwable -> L7
    L22:
        if (sQueryParamsMap.containsKey("version_code") == true) goto L25;
        sQueryParamsMap.put("version_code", sHeader.optString("version_code"));     // Catch: Throwable -> L7
    L25:
        if (sQueryParamsMap.containsKey("channel") == true) goto L28;
        sQueryParamsMap.put("channel", sHeader.optString("channel"));     // Catch: Throwable -> L7
    L28:
        if (sQueryParamsMap.containsKey("os_api") == true) goto L31;
        sQueryParamsMap.put("os_api", Build.VERSION.SDK_INT + "");     // Catch: Throwable -> L7
    L31:
        if (isDebugMode() == false) goto L36;
        if (sQueryParamsMap.containsKey("_log_level") == true) goto L36;
        sQueryParamsMap.put("_log_level", "debug");     // Catch: Throwable -> L7
    L36:
        if (params != null) goto L38;
        params = new CommonParams();     // Catch: Throwable -> L7
    L38:
        params.setParamExtras(new HashMap(sQueryParamsMap));     // Catch: Throwable -> L7
        monitor-exit(ApmContext.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void setExceptionTrafficDetect(boolean r0) {
        sExceptionTrafficDetect = r0;
    }

    public static synchronized void setHeaderInfo(JSONObject r5) {
        monitor-enter(ApmContext.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (params != null) goto L9;
        params = new CommonParams();     // Catch: Throwable -> L7 Exception -> L61
    L9:
        r5.put("os", "Android");     // Catch: Throwable -> L7 Exception -> L61
        r5.put("device_platform", "android");     // Catch: Throwable -> L7 Exception -> L61
        r5.put("os_version", Build.VERSION.RELEASE);     // Catch: Throwable -> L7 Exception -> L61
        r5.put("os_api", Build.VERSION.SDK_INT);     // Catch: Throwable -> L7 Exception -> L61
        r5.put("device_model", Build.MODEL);     // Catch: Throwable -> L7 Exception -> L61
        r5.put("device_brand", Build.BRAND);     // Catch: Throwable -> L7 Exception -> L61
        r5.put("device_manufacturer", Build.MANUFACTURER);     // Catch: Throwable -> L7 Exception -> L61
        r5.put("process_name", AppUtils.getProcessName(Process.myPid()));     // Catch: Throwable -> L7 Exception -> L61
        r5.put("sid", getStartId());     // Catch: Throwable -> L7 Exception -> L61
        r5.put("phone_startup_time", getInitTimeStamp());     // Catch: Throwable -> L7 Exception -> L61
        r5.put("verify_info", SlardarProperties.getReleaseBuild());     // Catch: Throwable -> L7 Exception -> L61
        r5.put("rom_version", RomUtils.getRomInfo());     // Catch: Throwable -> L7 Exception -> L61
        if (r5.has("version_name") == true) goto L12;
        PackageInfo r1 = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0);     // Catch: Throwable -> L7 Exception -> L61
        r5.put("version_name", r1.versionName);     // Catch: Throwable -> L7 Exception -> L61
    L14:
        if (TextUtils.isEmpty(r5.optString("app_version")) == false) goto L17;
        r5.put("app_version", r5.optString("version_name"));     // Catch: Throwable -> L7 Exception -> L61
    L17:
        if (r5.has("version_code") == true) goto L22;
        if (r1 != null) goto L20;
        r1 = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0);     // Catch: Throwable -> L7 Exception -> L61
    L20:
        r5.put("version_code", r1.versionCode);     // Catch: Throwable -> L7 Exception -> L61
    L22:
        if (TextUtils.isEmpty(r5.optString("package")) == false) goto L24;
        r5.put("package", getContext().getPackageName());     // Catch: Throwable -> L7 Exception -> L61
    L24:
        r5.put("monitor_version", "5.0.21.5");     // Catch: Throwable -> L7 Exception -> L61
        goto L25
    L12:
        r1 = null;
    L25:
        params.setProcessName(r5.optString("process_name"));     // Catch: Throwable -> L7
        params.setDeviceId(r5.optString("device_id"));     // Catch: Throwable -> L7
        params.setAid(r5.optInt("aid"));     // Catch: Throwable -> L7 Exception -> L62
        params.setChannel(r5.optString("channel"));     // Catch: Throwable -> L7 Exception -> L62
        if (r5.has("update_version_code") == false) goto L33;
        if ((r5.get("update_version_code") instanceof String) == false) goto L31;
        params.setUpdateVersionCode(Integer.valueOf(r5.optString("update_version_code")).intValue());     // Catch: Throwable -> L7 Exception -> L62
        goto L33
    L31:
        params.setUpdateVersionCode(r5.optInt("update_version_code"));     // Catch: Throwable -> L7 Exception -> L62
    L33:
        if (r5.has("version_name") == false) goto L36;
        params.setVersionName(r5.optString("version_name"));     // Catch: Throwable -> L7 Exception -> L62
    L36:
        if (r5.has("manifest_version_code") == false) goto L42;
        if ((r5.get("manifest_version_code") instanceof String) == false) goto L40;
        params.setManifestVersionCode(Integer.valueOf(r5.optString("manifest_version_code")).intValue());     // Catch: Throwable -> L7 Exception -> L62
        goto L42
    L40:
        params.setManifestVersionCode(r5.optInt("manifest_version_code"));     // Catch: Throwable -> L7 Exception -> L62
    L42:
        if (r5.has("version_code") == false) goto L48;
        if ((r5.get("version_code") instanceof String) == false) goto L46;
        params.setVersionCode(Integer.valueOf(r5.optString("version_code")).intValue());     // Catch: Throwable -> L7 Exception -> L62
        goto L48
    L46:
        params.setVersionCode(r5.optInt("version_code"));     // Catch: Throwable -> L7 Exception -> L62
    L48:
        if (r5.has("app_version") == false) goto L51;
        params.setAppVersion(r5.optString("app_version"));     // Catch: Throwable -> L7 Exception -> L62
    L51:
        if (r5.has("release_build") == false) goto L54;
        params.setReleaseBuild(r5.optString("release_build"));     // Catch: Throwable -> L7 Exception -> L62
        goto L56
    L54:
        if (SlardarProperties.getReleaseBuild().isEmpty() == true) goto L56;
        params.setReleaseBuild(SlardarProperties.getReleaseBuild());     // Catch: Throwable -> L7 Exception -> L62
    L56:
        params.setStaticHeaderExtras(JsonUtils.deepCopy(r5));     // Catch: Throwable -> L7
        sHeader = r5;     // Catch: Throwable -> L7
        monitor-exit(ApmContext.class);
    }

    public static void setHttpService(IHttpService r0) {
        if (r0 == null) goto L5;
        sHttpService = r0;
        return;
    }

    public static void setInitCostTime(long r0) {
        sInitCostTime = r0;
    }

    public static void setInitCostTimeStep2(long r0) {
        sInitCostTimeStep2 = r0;
    }

    public static void setInitCostTimeStep3(long r0) {
        sInitCostTimeStep3 = r0;
    }

    public static void setInitCostTimeStep4(long r0) {
        sInitCostTimeStep4 = r0;
    }

    public static void setInitCostTimeStep5(long r0) {
        sInitCostTimeStep5 = r0;
    }

    public static void setInitCostTimeStepFinish(long r0) {
        sInitCostTime6 = r0;
    }

    public static void setInitTimeStamp(long r0) {
        sInitTimeStamp = r0;
    }

    public static void setInitUpTimestamp(long r0) {
        sStartupTimestamp = r0;
    }

    public static void setInternalTest(boolean r0) {
        sIsInternalTest = r0;
    }

    public static void setIsInitFinish(boolean r0) {
        isInitFinish = r0;
    }

    public static void setLaunchMode(int r0) {
        sLaunchMode = r0;
    }

    public static void setNeedSalvage(boolean r0) {
        sNeedSalvage = r0;
    }

    public static void setProgressListener(ApmProgressListener r0) {
        progressListener = r0;
    }

    public static synchronized void setQueryParams(IQueryParams r1) {
        monitor-enter(ApmContext.class);
        sQueryParams = r1;     // Catch: Throwable -> L7
        monitor-exit(ApmContext.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void setSlardarConfigUrls(List<String> r0) {
        sSlardarConfigUrls = r0;
    }

    public static void setStartCostTime(long r0) {
        sStartCostTime = r0;
    }

    public static void setStartTimeStamp(long r0) {
        sStartTimeStamp = r0;
    }

    public static void setStopWhenBackground(boolean r0) {
        sStopWhenBackground = r0;
    }

    public static void setSupportMultiFrameRate(boolean r0) {
        sSupportMultiFrameRate = r0;
    }

    public static boolean supportMultiFrameRate() {
        return sSupportMultiFrameRate;
    }

    public static HttpResponse uploadFiles(String r1, List<File> r2, Map<String, String> r3) {
        return sHttpService.uploadFiles(r1, r2, r3);
    }

    public static IMultipartUploader buildMultipartUploader(String r1, String r2, boolean r3, Map<String, String> r4) {
        return sHttpService.buildMultipartUpload(r1, r2, r3, r4);
    }
}
