package com.obric.olog;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.android.settings.NotificationDisplayDetailsActivity;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.apm.alog.AlogMonitor;
import com.obric.android.agilelogger.ALog;
import com.obric.android.agilelogger.ALogConfig;
import com.obric.android.agilelogger.utils.FormatUtils;
import com.obric.privacy.GrantUtil;
import com.slardaros.client.MetricEvent;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class OLog extends ContentProvider {
    private static ALogConfig sConfig = null;
    private static Context sContext = null;
    private static long sCurrentTime = 0;
    private static volatile boolean sIsInited = false;
    private static ALog.LogInstance sLogInstance = null;
    private static volatile int sLogLevel = 3;
    private static long sLogNumInHour = 0;
    private static volatile boolean sOutputToLogd = false;
    private static volatile boolean sReport = false;
    private static volatile boolean sSaveToDisk = true;

    static {
    }

    public void com_obric_olog_OLog__onCreate$___twin___() {
        super.onCreate();
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r1) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public void onCreate() {
        com_obric_olog_OLog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Provider(this);
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        return 0;
    }

    public OLog() {
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        sContext = getContext();
        sCurrentTime = System.currentTimeMillis();
        sLogNumInHour = 0;
        return true;
    }

    private static boolean initAlog(OLogConfig r2) {
        ALogConfig r3 = new ALogConfig.Builder(r2.getContext()).setOffloadMainThreadWrite(true).setEncrypt(false).setCompress(false).setLevel(r2.getLevel()).setLogDirPath(r2.getLogDirPath()).setMaxDirSize(r2.getMaxDirSize()).setLogFileExpDays(r2.getLogFileExpDays()).setBufferDirPath(r2.getBufferDirPath()).build();
        sConfig = r3;
        return ALog.init(r3);
    }

    private static boolean checkLevel(int r1) {
        if (r1 < sLogLevel) goto L5;
        return true;
    L5:
        return false;
    }

    public static void init(OLogConfig r5) {
        sReport = r5.isReport();
        sSaveToDisk = r5.isSaveToDisk();
        sLogLevel = r5.getLevel();
        sContext = r5.getContext();
        UserManager r0 = (UserManager) r5.getContext().getSystemService(PickApplicationActivity.EXTRA_USER);
        if (r0 != null) goto L42;
    L7:
        SharedPreferences r1 = r5.getContext().createDeviceProtectedStorageContext().getSharedPreferences(Constants.CONFIG_FIELD, 0);     // Catch: IllegalStateException -> L9
    L41:
    L12:
        if (r1 != null) goto L19;
        if (sSaveToDisk == false) goto L16;
        initAlog(r5);
    L16:
        sIsInited = true;
        return;
    L19:
        if (r1.contains(Constants.REPORT_FIELD) == false) goto L22;
        sReport = r1.getBoolean(Constants.REPORT_FIELD, false);
    L22:
        if (r1.contains(Constants.SAVE_TO_DISK_FIELD) == false) goto L25;
        sSaveToDisk = r1.getBoolean(Constants.SAVE_TO_DISK_FIELD, true);
    L25:
        if (r1.contains(Constants.OUTPUT_TO_LOGD_FIELD) == false) goto L28;
        sOutputToLogd = r1.getBoolean(Constants.OUTPUT_TO_LOGD_FIELD, false);
    L28:
        if (r1.contains(Constants.LOG_LEVEL_FIELD) == false) goto L31;
        sLogLevel = r1.getInt(Constants.LOG_LEVEL_FIELD, 3);
        r5.setLevel(sLogLevel);
    L31:
        if (r1.contains(Constants.MAX_DIR_SIZE_FIELD) == false) goto L34;
        r5.setMaxDirSize(r1.getInt(Constants.MAX_DIR_SIZE_FIELD, r5.getMaxDirSize()));
    L34:
        if (r1.contains(Constants.LOG_EXPIRED_DAYS_FIELD) == false) goto L37;
        r5.setLogFileExpDays(r1.getInt(Constants.LOG_EXPIRED_DAYS_FIELD, r5.getLogFileExpDays()));
    L37:
        if (sSaveToDisk == false) goto L39;
        initAlog(r5);
    L39:
        sIsInited = true;
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        r1 = null;
        goto L12
    L42:
        if (r0.isUserUnlocked() == false) goto L7;
        r1 = r5.getContext().getSharedPreferences(Constants.CONFIG_FIELD, 0);     // Catch: IllegalStateException -> L9
        goto L41
    }

    private static void initInternal() {
        init(new OLogConfig.Builder(sContext).build());
    }

    private static void logout(int r1, String r2, String r3) {
        if (r1 > 2) goto L6;
        Log.v(r2, r3);
        return;
    L6:
        if (r1 != 3) goto L9;
        Log.d(r2, r3);
        return;
    L9:
        if (r1 != 4) goto L12;
        Log.i(r2, r3);
        return;
    L12:
        if (r1 != 5) goto L14;
        Log.w(r2, r3);
        return;
    L14:
        Log.e(r2, r3);
    }

    private static void logout(int r1, String r2, String r3, Throwable r4) {
        if (r1 > 2) goto L6;
        Log.v(r2, r3, r4);
        return;
    L6:
        if (r1 != 3) goto L9;
        Log.d(r2, r3, r4);
        return;
    L9:
        if (r1 != 4) goto L12;
        Log.i(r2, r3, r4);
        return;
    L12:
        if (r1 != 5) goto L14;
        Log.w(r2, r3, r4);
        return;
    L14:
        Log.e(r2, r3, r4);
    }

    private static void Alogout(int r1, String r2, String r3) {
        if (r1 > 2) goto L6;
        ALog.v(r2, r3);
        return;
    L6:
        if (r1 != 3) goto L9;
        ALog.d(r2, r3);
        return;
    L9:
        if (r1 != 4) goto L12;
        ALog.i(r2, r3);
        return;
    L12:
        if (r1 != 5) goto L14;
        ALog.w(r2, r3);
        return;
    L14:
        ALog.e(r2, r3);
    }

    private static void AlogoutSensetive(int r1, String r2, String r3) {
        if (r1 > 2) goto L8;
        sLogInstance.v(r2, r3);     // Catch: Exception -> L5
    L20:
        return;
    L8:
        if (r1 != 3) goto L11;
        sLogInstance.d(r2, r3);     // Catch: Exception -> L5
        goto L20
    L11:
        if (r1 != 4) goto L14;
        sLogInstance.i(r2, r3);     // Catch: Exception -> L5
        goto L20
    L14:
        if (r1 != 5) goto L16;
        sLogInstance.w(r2, r3);     // Catch: Exception -> L5
        goto L20
    L16:
        sLogInstance.e(r2, r3);     // Catch: Exception -> L5
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public static void StatisticFunc() {
        sLogNumInHour++;
        Log.d("obric_log_statistic", "Alogout dada: " + (System.currentTimeMillis() - sCurrentTime));
        if ((System.currentTimeMillis() - sCurrentTime) < 60000) goto L6;
        Log.d("obric_log_statistic", "Alogout in a minutes: " + sLogNumInHour);
        reportMetricEvent(sLogNumInHour);
        sCurrentTime = System.currentTimeMillis();
        sLogNumInHour = 0;
        return;
    }

    public static void setOutputToLogd(boolean r3) {
        sOutputToLogd = r3;     // Catch: Exception -> L14
        UserManager r4 = (UserManager) sContext.getSystemService(PickApplicationActivity.EXTRA_USER);     // Catch: Exception -> L14
        if (r4 != null) goto L7;
    L9:
        SharedPreferences r5 = sContext.createDeviceProtectedStorageContext().getSharedPreferences(Constants.CONFIG_FIELD, 0);     // Catch: Exception -> L14
    L11:
        if (r5.contains(Constants.OUTPUT_TO_LOGD_FIELD) == false) goto L19;
        sOutputToLogd = r5.getBoolean(Constants.OUTPUT_TO_LOGD_FIELD, false);     // Catch: Exception -> L14
        return;
    L19:
        return;
    L7:
        if (r4.isUserUnlocked() == false) goto L9;
        r5 = sContext.getSharedPreferences(Constants.CONFIG_FIELD, 0);     // Catch: Exception -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
    }

    public static void v(String r2, String r3) {
        if (sIsInited == true) goto L6;
        initInternal();
    L6:
        if (sOutputToLogd == false) goto L11;
        if (checkLevel(2) == false) goto L11;
        logout(2, r2, r3);
    L11:
        if (sSaveToDisk == false) goto L14;
        Alogout(2, r2, r3);
        return;
    }

    private static void createInstanceIfNeed() {
        if (sLogInstance != null) goto L8;
        ALogConfig r0 = sConfig;
        if (r0 == null) goto L9;
        sLogInstance = ALog.createInstance("SensitiveContent", r0);
        return;
    L9:
        return;
    }

    public static void vSensitive(String r2, String r3) {
        if (sIsInited == true) goto L5;
        initInternal();
    L5:
        createInstanceIfNeed();
        if (sLogInstance != null) goto L9;
        return;
    L9:
        if (sOutputToLogd == false) goto L14;
        if (checkLevel(2) == false) goto L14;
        logout(2, r2, r3);
    L14:
        if (sSaveToDisk == false) goto L17;
        AlogoutSensetive(2, r2, r3);
        return;
    }

    public static void v(String r2, String r3, Throwable r4) {
        if (sIsInited == true) goto L6;
        initInternal();
    L6:
        if (sOutputToLogd == false) goto L11;
        if (checkLevel(2) == false) goto L11;
        logout(2, r2, r3, r4);
    L11:
        if (sSaveToDisk == false) goto L14;
        Alogout(2, r2, r3);
        return;
    }

    public static void vSensitive(String r2, String r3, Throwable r4) {
        if (sIsInited == true) goto L5;
        initInternal();
    L5:
        createInstanceIfNeed();
        if (sLogInstance != null) goto L9;
        return;
    L9:
        if (sOutputToLogd == false) goto L14;
        if (checkLevel(2) == false) goto L14;
        logout(2, r2, r3, r4);
    L14:
        if (sSaveToDisk == false) goto L17;
        AlogoutSensetive(2, r2, r3);
        return;
    }

    public static void d(String r2, String r3) {
        if (sIsInited == true) goto L6;
        initInternal();
    L6:
        if (sOutputToLogd == false) goto L11;
        if (checkLevel(3) == false) goto L11;
        logout(3, r2, r3);
    L11:
        if (sSaveToDisk == false) goto L14;
        Alogout(3, r2, r3);
        return;
    }

    public static void d(String r2, String r3, Throwable r4) {
        if (sIsInited == true) goto L6;
        initInternal();
    L6:
        if (sOutputToLogd == false) goto L11;
        if (checkLevel(3) == false) goto L11;
        logout(3, r2, r3, r4);
    L11:
        if (sSaveToDisk == false) goto L14;
        Alogout(3, r2, r3);
        return;
    }

    public static void i(String r2, String r3) {
        if (sIsInited == true) goto L6;
        initInternal();
    L6:
        if (sOutputToLogd == false) goto L11;
        if (checkLevel(4) == false) goto L11;
        logout(4, r2, r3);
    L11:
        if (sSaveToDisk == false) goto L14;
        Alogout(4, r2, r3);
        return;
    }

    public static void i(String r2, String r3, Throwable r4) {
        if (sIsInited == true) goto L6;
        initInternal();
    L6:
        if (sOutputToLogd == false) goto L11;
        if (checkLevel(4) == false) goto L11;
        logout(4, r2, r3, r4);
    L11:
        if (sSaveToDisk == false) goto L14;
        Alogout(4, r2, r3);
        return;
    }

    public static void w(String r2, String r3) {
        if (sIsInited == true) goto L6;
        initInternal();
    L6:
        if (sOutputToLogd == false) goto L11;
        if (checkLevel(5) == false) goto L11;
        logout(5, r2, r3);
    L11:
        if (sSaveToDisk == false) goto L14;
        Alogout(5, r2, r3);
        return;
    }

    public static void w(String r1, String r2, Throwable r3) {
        if (sIsInited == true) goto L6;
        initInternal();
    L6:
        if (sOutputToLogd == false) goto L11;
        if (checkLevel(5) == false) goto L11;
        Log.w(r1, r2, r3);
    L11:
        if (sSaveToDisk == false) goto L14;
        ALog.w(r1, r2, r3);
        return;
    }

    public static void w(String r1, Throwable r2) {
        if (sIsInited == true) goto L6;
        initInternal();
    L6:
        if (sOutputToLogd == false) goto L11;
        if (checkLevel(5) == false) goto L11;
        Log.w(r1, r2);
    L11:
        if (sSaveToDisk == false) goto L14;
        ALog.w(r1, r2);
        return;
    }

    public static void e(String r1, String r2) {
        if (sIsInited == true) goto L6;
        initInternal();
    L6:
        if (sOutputToLogd == false) goto L11;
        if (checkLevel(6) == false) goto L11;
        Log.e(r1, r2);
    L11:
        if (sSaveToDisk == false) goto L14;
        ALog.e(r1, r2);
        return;
    }

    public static void e(String r1, String r2, Throwable r3) {
        if (sIsInited == true) goto L6;
        initInternal();
    L6:
        if (sOutputToLogd == false) goto L11;
        if (checkLevel(6) == false) goto L11;
        Log.e(r1, r2, r3);
    L11:
        if (sSaveToDisk == false) goto L14;
        ALog.e(r1, r2, r3);
        return;
    }

    public static void header(int r1, String r2, String r3) {
        if (sIsInited == true) goto L6;
        initInternal();
    L6:
        if (sOutputToLogd == false) goto L11;
        if (checkLevel(r1) == false) goto L11;
        logout(r1, r2, FormatUtils.format(FormatUtils.TYPE.BORDER, r3));
    L11:
        if (sSaveToDisk == false) goto L14;
        ALog.header(r1, r2, r3);
        return;
    }

    public static void bundle(int r1, String r2, Bundle r3) {
        if (sIsInited == true) goto L6;
        initInternal();
    L6:
        if (sOutputToLogd == false) goto L11;
        if (checkLevel(r1) == false) goto L11;
        logout(r1, r2, FormatUtils.format(FormatUtils.TYPE.BUNDLE, r3));
    L11:
        if (sSaveToDisk == false) goto L14;
        ALog.bundle(r1, r2, r3);
        return;
    }

    public static void intent(int r1, String r2, Intent r3) {
        if (sIsInited == true) goto L6;
        initInternal();
    L6:
        if (sOutputToLogd == false) goto L11;
        if (checkLevel(r1) == false) goto L11;
        logout(r1, r2, FormatUtils.format(FormatUtils.TYPE.INTENT, r3));
    L11:
        if (sSaveToDisk == false) goto L14;
        ALog.intent(r1, r2, r3);
        return;
    }

    public static void thread(int r1, String r2, Thread r3) {
        if (sIsInited == true) goto L6;
        initInternal();
    L6:
        if (sOutputToLogd == false) goto L11;
        if (checkLevel(r1) == false) goto L11;
        logout(r1, r2, FormatUtils.format(FormatUtils.TYPE.THREAD, r3));
    L11:
        if (sSaveToDisk == false) goto L14;
        ALog.thread(r1, r2, r3);
        return;
    }

    public static void json(int r1, String r2, String r3) {
        if (sIsInited == true) goto L6;
        initInternal();
    L6:
        if (sOutputToLogd == false) goto L11;
        if (checkLevel(r1) == false) goto L11;
        logout(r1, r2, FormatUtils.format(FormatUtils.TYPE.JSON, r3));
    L11:
        if (sSaveToDisk == false) goto L14;
        ALog.json(r1, r2, r3);
        return;
    }

    public static void throwable(int r1, String r2, Throwable r3) {
        if (sIsInited == true) goto L6;
        initInternal();
    L6:
        if (sOutputToLogd == false) goto L11;
        if (checkLevel(r1) == false) goto L11;
        logout(r1, r2, FormatUtils.format(FormatUtils.TYPE.THROWABLE, r3));
    L11:
        if (sSaveToDisk == false) goto L14;
        ALog.throwable(r1, r2, r3);
        return;
    }

    public static void stacktrace(int r1, String r2, StackTraceElement[] r3) {
        if (sIsInited == true) goto L6;
        initInternal();
    L6:
        if (sOutputToLogd == false) goto L11;
        if (checkLevel(r1) == false) goto L11;
        logout(r1, r2, FormatUtils.format(FormatUtils.TYPE.STACKTRACE, r3));
    L11:
        if (sSaveToDisk == false) goto L14;
        ALog.stacktrace(r1, r2, r3);
        return;
    }

    private static void reportMetricEvent(long r6) {
        if (sContext != null) goto L5;
        return;
    L5:
        JSONObject r2 = new JSONObject();
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L9
        r3.put(NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME, sContext.getPackageName());     // Catch: Exception -> L9
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L9
        r4.put("mainLogNumLines", r6);     // Catch: Exception -> L9
        r2.put("category", r3);     // Catch: Exception -> L9
        r2.put(MetricEvent.METRICS_KEY, r4);     // Catch: Exception -> L9
        r2.put(MetricEvent.TIMESTAMP_KEY, System.currentTimeMillis());     // Catch: Exception -> L9
        r2.put("log_type", "flexible");     // Catch: Exception -> L9
        r2.put(MetricEvent.EVENTNAME_KEY, "appLogFileLines");     // Catch: Exception -> L9
    L7:
        Intent r7 = new Intent(com.slardaros.client.Constants.METRIC_EVENT_ACTION);
        r7.putExtra(AlogMonitor.ALOG_RESULT_CODE, 0);
        r7.putExtra(MetricEvent.EVENTNAME_KEY, "appLogFileLines");
        r7.putExtra("json_string", r2.toString());
        sContext.sendBroadcast(r7, com.slardaros.client.Constants.METRIC_EVENT_PERMISSION);
    }

    public static void syncFlush() {
        if (sSaveToDisk == false) goto L6;
        ALog.syncFlush();
        return;
    }

    public static Context getsContext() {
        return sContext;
    }

    static boolean isInited() {
        return sIsInited;
    }

    static void setReport(boolean r0) {
        sReport = r0;
    }

    static void setLogLevel(int r0) {
        sLogLevel = r0;
        ALog.changeLevel(r0);
    }

    public static void dSensitive(String r2, String r3) {
        if (sIsInited == true) goto L5;
        initInternal();
    L5:
        createInstanceIfNeed();
        if (sLogInstance != null) goto L9;
        return;
    L9:
        if (sOutputToLogd == false) goto L14;
        if (checkLevel(3) == false) goto L14;
        logout(3, r2, r3);
    L14:
        if (sSaveToDisk == false) goto L17;
        AlogoutSensetive(3, r2, r3);
        return;
    }

    public static void dSensitive(String r2, String r3, Throwable r4) {
        if (sIsInited == true) goto L5;
        initInternal();
    L5:
        createInstanceIfNeed();
        if (sLogInstance != null) goto L9;
        return;
    L9:
        if (sOutputToLogd == false) goto L14;
        if (checkLevel(3) == false) goto L14;
        logout(3, r2, r3, r4);
    L14:
        if (sSaveToDisk == false) goto L17;
        AlogoutSensetive(3, r2, r3);
        return;
    }

    public static void iSensitive(String r2, String r3) {
        if (sIsInited == true) goto L5;
        initInternal();
    L5:
        createInstanceIfNeed();
        if (sLogInstance != null) goto L9;
        return;
    L9:
        if (sOutputToLogd == false) goto L14;
        if (checkLevel(4) == false) goto L14;
        logout(4, r2, r3);
    L14:
        if (sSaveToDisk == false) goto L17;
        AlogoutSensetive(4, r2, r3);
        return;
    }

    public static void iSensitive(String r2, String r3, Throwable r4) {
        if (sIsInited == true) goto L5;
        initInternal();
    L5:
        createInstanceIfNeed();
        if (sLogInstance != null) goto L9;
        return;
    L9:
        if (sOutputToLogd == false) goto L14;
        if (checkLevel(4) == false) goto L14;
        logout(4, r2, r3, r4);
    L14:
        if (sSaveToDisk == false) goto L17;
        AlogoutSensetive(4, r2, r3);
        return;
    }

    public static void wSensitive(String r2, String r3) {
        if (sIsInited == true) goto L5;
        initInternal();
    L5:
        createInstanceIfNeed();
        if (sLogInstance != null) goto L9;
        return;
    L9:
        if (sOutputToLogd == false) goto L14;
        if (checkLevel(5) == false) goto L14;
        logout(5, r2, r3);
    L14:
        if (sSaveToDisk == false) goto L17;
        AlogoutSensetive(5, r2, r3);
        return;
    }

    public static void wSensitive(String r2, String r3, Throwable r4) {
        if (sIsInited == true) goto L5;
        initInternal();
    L5:
        createInstanceIfNeed();
        if (sLogInstance != null) goto L9;
        return;
    L9:
        if (sOutputToLogd == false) goto L14;
        if (checkLevel(5) == false) goto L14;
        Log.w(r2, r3, r4);
    L14:
        if (sSaveToDisk == false) goto L17;
        AlogoutSensetive(5, r2, r3);
        return;
    }

    public static void wSensitive(String r2, Throwable r3) {
        if (sIsInited == true) goto L5;
        initInternal();
    L5:
        createInstanceIfNeed();
        if (sLogInstance != null) goto L9;
        return;
    L9:
        if (sOutputToLogd == false) goto L14;
        if (checkLevel(5) == false) goto L14;
        Log.w(r2, r3);
    L14:
        if (sSaveToDisk == false) goto L17;
        AlogoutSensetive(5, r2, r3.getMessage());
        return;
    }

    public static void eSensitive(String r2, String r3) {
        if (sIsInited == true) goto L5;
        initInternal();
    L5:
        createInstanceIfNeed();
        if (sLogInstance != null) goto L9;
        return;
    L9:
        if (sOutputToLogd == false) goto L14;
        if (checkLevel(6) == false) goto L14;
        Log.e(r2, r3);
    L14:
        if (sSaveToDisk == false) goto L17;
        AlogoutSensetive(6, r2, r3);
        return;
    }

    public static void eSensitive(String r2, String r3, Throwable r4) {
        if (sIsInited == true) goto L5;
        initInternal();
    L5:
        createInstanceIfNeed();
        if (sLogInstance != null) goto L9;
        return;
    L9:
        if (sOutputToLogd == false) goto L14;
        if (checkLevel(6) == false) goto L14;
        Log.e(r2, r3, r4);
    L14:
        if (sSaveToDisk == false) goto L17;
        AlogoutSensetive(6, r2, r3);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.content.ContentProvider")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_obric_olog_OLog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Provider(OLog r2) {
        String r0 = r2.getClass().getName();
        r2.com_obric_olog_OLog__onCreate$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportColdStartProvider(r0);
    L5:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }
}
