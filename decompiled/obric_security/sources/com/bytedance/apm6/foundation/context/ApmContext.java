package com.bytedance.apm6.foundation.context;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.apm.listener.INtpTimeService;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IHttpService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ApmContext extends ApmBaseContext {
    private static ApmContextAdapter apmContextAdapter = null;
    private static String appVersion = null;
    private static Map<String, String> cacheBaseUrlParams = null;
    private static String channel = null;
    private static long configTime = -1;
    private static long initTimeStamp = 0;
    private static Boolean isMainProcess = null;
    private static int manifestVersionCode = -1;
    private static INtpTimeService ntpTimeService = null;
    private static String processName = null;
    private static String releaseBuild = null;
    private static JSONObject stableHeaderExtra = null;
    private static long startId = -1;
    private static int updateVersionCode = -1;
    private static int versionCode = -1;
    private static String versionName;

    static {
    }

    public ApmContext() {
    }

    public static void setApmContextAdapter(ApmContextAdapter r1) {
        if (r1 == null) goto L6;
        apmContextAdapter = r1;
        ApmBaseContext.setContext(r1.getContext());
        return;
    L6:
        throw new IllegalArgumentException("apmAdapter cannot be null!");
    }

    public static void setNtpTimeService(INtpTimeService r0) {
        ntpTimeService = r0;
    }

    public static INtpTimeService getNtpTimeService() {
        return ntpTimeService;
    }

    public static ApmContextAdapter getApmContextAdapter() {
        return apmContextAdapter;
    }

    public static void setInitTimeStamp(long r0) {
        initTimeStamp = r0;
    }

    public static void setStartId(long r0) {
        startId = r0;
    }

    public static long getStartId() {
        if (startId >= 0) goto L6;
        startId = System.currentTimeMillis();
    L6:
        return startId;
    }

    public static long getInitTimeStamp() {
        if (initTimeStamp > 0) goto L6;
        initTimeStamp = System.currentTimeMillis();
    L6:
        return initTimeStamp;
    }

    public static boolean isMainProcess() {
        if (isMainProcess != null) goto L24;
        monitor-enter(ApmContext.class);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (isMainProcess != null) goto L18;
        String r1 = getCurrentProcessName();     // Catch: Throwable -> L20
        boolean r2 = false;
        if (r1 != null) goto L11;
    L13:
        if (r1 != null) goto L15;
    L17:
        isMainProcess = Boolean.valueOf(r2);     // Catch: Throwable -> L20
        goto L18
    L15:
        if (r1.equals(getContext().getPackageName()) == false) goto L17;
        r2 = true;
        goto L17
    L11:
        if (r1.contains(":") == false) goto L13;
        isMainProcess = false;     // Catch: Throwable -> L20
    L18:
        monitor-exit(ApmContext.class);     // Catch: Throwable -> L20
    L24:
        return isMainProcess.booleanValue();
    }

    public static String getCurrentProcessName() {
        if (processName != null) goto L15;
        monitor-enter(ApmContext.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (processName != null) goto L9;
        processName = apmContextAdapter.getProcessName();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ApmContext.class);     // Catch: Throwable -> L11
    L15:
        return processName;
    }

    public static int getAid() {
        return apmContextAdapter.getAid();
    }

    public static String getChannel() {
        if (channel != null) goto L15;
        monitor-enter(ApmContext.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (channel != null) goto L9;
        channel = apmContextAdapter.getChannel();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ApmContext.class);     // Catch: Throwable -> L11
    L15:
        return channel;
    }

    public static int getUpdateVersionCode() {
        if (updateVersionCode != (-1)) goto L15;
        monitor-enter(ApmContext.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (updateVersionCode != (-1)) goto L9;
        updateVersionCode = apmContextAdapter.getUpdateVersionCode();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ApmContext.class);     // Catch: Throwable -> L11
    L15:
        return updateVersionCode;
    }

    public static String getVersionName() {
        if (TextUtils.isEmpty(versionName) == false) goto L15;
        monitor-enter(ApmContext.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (TextUtils.isEmpty(versionName) == false) goto L9;
        versionName = apmContextAdapter.getVersionName();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ApmContext.class);     // Catch: Throwable -> L11
    L15:
        return versionName;
    }

    public static int getVersionCode() {
        if (versionCode != (-1)) goto L15;
        monitor-enter(ApmContext.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (versionCode != (-1)) goto L9;
        versionCode = apmContextAdapter.getVersionCode();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ApmContext.class);     // Catch: Throwable -> L11
    L15:
        return versionCode;
    }

    public static String getAppVersion() {
        if (TextUtils.isEmpty(appVersion) == false) goto L15;
        monitor-enter(ApmContext.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (TextUtils.isEmpty(appVersion) == false) goto L9;
        appVersion = apmContextAdapter.getAppVersion();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ApmContext.class);     // Catch: Throwable -> L11
    L15:
        return appVersion;
    }

    public static String getReleaseBuild() {
        if (TextUtils.isEmpty(releaseBuild) == false) goto L15;
        monitor-enter(ApmContext.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (TextUtils.isEmpty(releaseBuild) == false) goto L9;
        releaseBuild = apmContextAdapter.getReleaseBuild();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ApmContext.class);     // Catch: Throwable -> L11
    L15:
        return releaseBuild;
    }

    public static String getManifestVersionCode() {
        if (manifestVersionCode != (-1)) goto L15;
        monitor-enter(ApmContext.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (manifestVersionCode != (-1)) goto L9;
        manifestVersionCode = apmContextAdapter.getManifestVersionCode();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ApmContext.class);     // Catch: Throwable -> L11
    L15:
        return String.valueOf(manifestVersionCode);
    }

    public static JSONObject getStableHeaderExtras() {
        if (stableHeaderExtra != null) goto L15;
        monitor-enter(ApmContext.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (stableHeaderExtra != null) goto L9;
        stableHeaderExtra = apmContextAdapter.getStableHeaderExtras();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ApmContext.class);     // Catch: Throwable -> L11
    L15:
        return stableHeaderExtra;
    }

    public static String getDeviceId() {
        return apmContextAdapter.getDeviceId();
    }

    public static String getSessionId() {
        return apmContextAdapter.getSessionId();
    }

    public static long getUserID() {
        return apmContextAdapter.getUid();
    }

    public static void setConfigTime(long r0) {
        configTime = r0;
    }

    public static long getConfigTime() {
        return configTime;
    }

    public static Map<String, String> getUrlParams() {
        if (cacheBaseUrlParams != null) goto L5;
        HashMap r0 = new HashMap();
        cacheBaseUrlParams = r0;
        r0.put("aid", String.valueOf(getAid()));
        cacheBaseUrlParams.put("os", "Android");
        cacheBaseUrlParams.put("device_platform", "android");
        cacheBaseUrlParams.put("os_api", Build.VERSION.SDK_INT + "");
        cacheBaseUrlParams.put("update_version_code", String.valueOf(getUpdateVersionCode()));
        cacheBaseUrlParams.put("version_code", getAppVersion());
        cacheBaseUrlParams.put("channel", getChannel());
        cacheBaseUrlParams.put("device_model", Build.MODEL);
        cacheBaseUrlParams.put("device_brand", Build.BRAND);
    L5:
        cacheBaseUrlParams.put("device_id", getDeviceId());
        if (isDebugMode() == false) goto L20;
        cacheBaseUrlParams.put("_log_level", "debug");
    L20:
        Map<String, String> r1 = getApmContextAdapter().getParamsExtras();     // Catch: Throwable -> L19
        if (r1 == null) goto L18;
        if (r1.size() <= 0) goto L18;
        Iterator<Map.Entry<String, String>> r2 = r1.entrySet().iterator();     // Catch: Throwable -> L19
    L14:
        if (r2.hasNext() == false) goto L18;
        Map.Entry<String, String> r3 = r2.next();     // Catch: Throwable -> L19
        cacheBaseUrlParams.put(r3.getKey(), r3.getValue());     // Catch: Throwable -> L19
    L18:
        return cacheBaseUrlParams;
    }

    public static HttpResponse doPost(String r1, Map<String, String> r2, byte[] r3) throws Exception {
        return ((IHttpService) ServiceManager.getService(IHttpService.class)).doPost(r1, r3, r2);
    }

    public static HttpResponse doGet(String r1, Map<String, String> r2) throws Exception {
        return ((IHttpService) ServiceManager.getService(IHttpService.class)).doGet(r1, r2);
    }
}
