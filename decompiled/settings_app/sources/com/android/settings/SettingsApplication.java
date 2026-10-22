package com.android.settings;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Trace;
import com.GlobalProxyLancet;
import com.android.settings.accounts.OAccountHelper;
import com.android.settings.accounts.obric.AccountBridge;
import com.android.settings.accounts.obric.AccountLogger;
import com.android.settings.applications.ApplicationLabelCache;
import com.android.settings.metrics.SlardarOsReporter;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.teaevent.EventReportUtil;
import com.android.settings.teaevent.common.EventDailyReporter;
import com.bytedance.keva.KevaBuilder;
import com.bytedance.os.oms.OmsLogger;
import com.obric.apm.ApmHelper;
import com.obric.apptools.sdk.common.AppMetrics;
import com.obric.matrix.platform.sdk.ones.account.OAccount;
import com.obric.olog.OLog;
import com.obric.olog.OLogConfig;
import com.obric.privacy.GrantUtil;
import com.obric.tools.MatrixSettingsInitManager;
import com.obric.tools.MatrixTeaInitManager;
import com.squareup.leakcanary.LeakCanary;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;
import obric.common.ttnet.InitTTNetHelper;

/* JADX INFO: loaded from: classes2.dex */
public class SettingsApplication extends Application {
    public static String AppId = "3740";
    private static final String EXTRA_ALIAS = "alias";
    private static final String EXTRA_BADGE_NUM = "badge_num";
    private static final int GLOABLE_SEARCH_SYNC_RETRY_INTERVAL_TIME = 86400000;
    private static final String KEY_VIDEO_VERSION = "gesture_video_version";
    private static final String LAUNCHER_BADGE_CONTENT_URI = "content://com.bytedanceos.launcher.badge";
    private static final String METHOD_UPDATE_BADGE = "updateMessageBadge";
    private static final int MSG_ID_INIT_OPERATION = 1;
    private static final int MSG_ID_UPDATE_IMEI = 2;
    private static final String OMS_LOG_TAG_PREFIX = "Oms_";
    private static final String PERSIST_LCD_CGM = "persist.lcd.cgm";
    private static final String TAG = "SettingsApplication";
    private static boolean mApplogInited = false;
    private static String mDid;
    private static String mInstallId;
    private static Application sApplication;
    private static Context sContext;
    private Handler mHandler;
    private BroadcastReceiver mLauncherReadyReceiver;
    private ScreenMonitorReceiver mScreenMonitorReceiver;

    public class ScreenMonitorReceiver extends BroadcastReceiver {
        private boolean mCharging;
        final /* synthetic */ SettingsApplication this$0;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            com_android_settings_SettingsApplication$ScreenMonitorReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
        }

        public ScreenMonitorReceiver(SettingsApplication r1) {
            this.this$0 = r1;
        }

        public void com_android_settings_SettingsApplication$ScreenMonitorReceiver__onReceive$___twin___(Context r4, Intent r5) {
            String r6 = r5.getAction();
            OLog.d(SettingsApplication.TAG, "action " + r6);
            this.mCharging = SettingsApplication.access$100(r4);
            OLog.d(SettingsApplication.TAG, "is Charging " + this.mCharging);
            r6.hashCode();
            if (r6.equals("android.intent.action.SCREEN_OFF") == true) goto L9;
            if (r6.equals("android.intent.action.SCREEN_ON") == false) goto L17;
            SettingsApplication.access$300(this.this$0, r4);
            return;
        L17:
            return;
        L9:
            if (SettingsApplication.needMonitorWizardNoOperation(r4) == true) goto L11;
            return;
        L11:
            if (this.mCharging == true) goto L16;
            SettingsApplication.access$200(this.this$0, r4);
            return;
        }

        @Insert("onReceive")
        public static void com_android_settings_SettingsApplication$ScreenMonitorReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(ScreenMonitorReceiver r7, Context r8, Intent r9) {
            Intrinsics.checkNotNullParameter(r8, "context");
            String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
            ScreenMonitorReceiver r1 = r7;
            String r2 = r1.getClass().getName();
            String r3 = r1.getClass().getSimpleName();
            boolean r4 = Intrinsics.areEqual(SettingsInitialize.class, r1.getClass());
            String r5 = null;
            if (r9 == null) goto L5;
            String r6 = r9.getAction();
        L7:
            if (ArraysKt.contains(r0, r6) == false) goto L13;
            StringBuilder r10 = new StringBuilder("onReceive allowList ");
            if (r9 == null) goto L11;
            r5 = r9.getAction();
        L11:
            OLog.i("PrivacyHookForReceiver", r10.append(r5).toString());
            r7.com_android_settings_SettingsApplication$ScreenMonitorReceiver__onReceive$___twin___(r8, r9);
            return;
        L13:
            GrantUtil r11 = GrantUtil.INSTANCE;
            Application r12 = SettingsApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
            if (r11.isSetupCompelete(r12) == true) goto L16;
            OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
            r7.com_android_settings_SettingsApplication$ScreenMonitorReceiver__onReceive$___twin___(r8, r9);
            return;
        L16:
            String r13 = r3;
            if (r13 != null) goto L19;
        L22:
            boolean r14 = true;
        L23:
            if (r14 == false) goto L26;
            OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
            r7.com_android_settings_SettingsApplication$ScreenMonitorReceiver__onReceive$___twin___(r8, r9);
            return;
        L26:
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
            if (r4 == true) goto L30;
            OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
            return;
        L30:
            GrantUtil.INSTANCE.applicationInit();
            r7.com_android_settings_SettingsApplication$ScreenMonitorReceiver__onReceive$___twin___(r8, r9);
            return;
        L19:
            if (r13.length() == 0) goto L22;
            r14 = false;
            goto L23
        L5:
            r6 = null;
            goto L7
        }
    }

    static {
    }

    static /* synthetic */ void access$000(SettingsApplication r0) {
        r0.init();
    }

    static /* synthetic */ boolean access$100(Context r0) {
        return isCharging(r0);
    }

    static /* synthetic */ void access$200(SettingsApplication r0, Context r1) {
        r0.scheduleShutdownWizard(r1);
    }

    static /* synthetic */ void access$300(SettingsApplication r0, Context r1) {
        r0.cancelScheduleShutdownWizard(r1);
    }

    public static String getDid() {
        OLog.i(TAG, "getDid startToGetDid1");
        if (mApplogInited == true) goto L13;
        OLog.i(TAG, "mApplogInited: false");
    L10:
        th = move-exception;
        th.printStackTrace();
        OLog.e(TAG, "MatrixTeaInitManager init error: " + th);
    L12:
        mApplogInited = true;
        OLog.i(TAG, "mApplogInited: true");
        goto L13
    L6:
        if (getApplication() != null) goto L8;
        OLog.e(TAG, "mApplogInited: false, but application is null");     // Catch: Throwable -> L10
    L8:
        MatrixTeaInitManager.INSTANCE.init(getApplication());     // Catch: Throwable -> L10
    L13:
        String r1 = mDid;
        OLog.i(TAG, "current did 1: " + r1);
    L21:
        th = th;
    L22:
        th.printStackTrace();
        OLog.e(TAG, "MatrixTeaInitManager getDid error: " + th);
    L23:
        OLog.i(TAG, "current did 2: " + r1);
        OLog.i(TAG, "getDid startToGetDid2");
        return r1;
    L15:
        if (isValidDeviceId(r1) == true) goto L23;
        String r3 = MatrixTeaInitManager.INSTANCE.getDeviceId();     // Catch: Throwable -> L21
        mDid = r3;     // Catch: Throwable -> L21
        OLog.i(TAG, "MatrixTeaInitManager getDeviceId: " + r3);     // Catch: Throwable -> L19
        r1 = r3;
    L19:
        th = th;
        r1 = r3;
        goto L22
    }

    private static boolean isValidDeviceId(String r1) {
        if (r1 != null) goto L4;
    L10:
        return false;
    L4:
        if (r1.isEmpty() == true) goto L10;
        if (r1.equals("0") == true) goto L10;
        if (r1.equals("-1") == true) goto L10;
        return true;
    }

    public static String getInstallId() {
        return mInstallId;
    }

    private void init() {
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L5;
        return;
    L5:
        CustomizedStatusBarHelp.getInstance().init(this);
        SettingsFeature.resetNavbarTheme(getContext());
        monitorScreenOffIfNeeded();
    }

    private void monitorScreenOffIfNeeded() {
        if (needMonitorWizardNoOperation(this) == false) goto L6;
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.intent.action.SCREEN_OFF");
        r0.addAction("android.intent.action.SCREEN_ON");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, this.mScreenMonitorReceiver, r0, 2);
        return;
    }

    public static void notifyLauncher(Context r3, int r4) {
        OLog.i(TAG, "notifyLauncher: " + r4);     // Catch: Exception -> L5
        Uri r0 = Uri.parse(LAUNCHER_BADGE_CONTENT_URI);     // Catch: Exception -> L5
        Bundle r1 = new Bundle();     // Catch: Exception -> L5
        r1.putInt(EXTRA_BADGE_NUM, r4);     // Catch: Exception -> L5
        r3.getContentResolver().call(r0, METHOD_UPDATE_BADGE, null, r1);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        OLog.e("notifyLauncher", "notifyLauncher error." + e);
    }

    public SettingsApplication() {
        this.mScreenMonitorReceiver = new ScreenMonitorReceiver(this);
        this.mHandler = new AnonymousClass1(this);
        this.mLauncherReadyReceiver = new AnonymousClass2(this);
        Trace.beginSection("SettingsApplication-<init>");
        AppMetricsUtils.INSTANCE.setColdStartTime(AppMetricsUtils.INSTANCE.getNanoTimeMillis());
        Trace.endSection();
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context r2) {
        Trace.beginSection("SettingsApplication-attachBaseContext");
        super.attachBaseContext(r2);
        sContext = r2;
        sApplication = this;
        KevaBuilder.getInstance().setContext(r2);
        initOLog(sContext);
        initOmsLogger();
        com.android.settings.overlay.FeatureFactory.setFactory(this, new com.android.settings.overlay.FeatureFactoryImpl());
        Trace.endSection();
    }

    private boolean isSettingsProcess() {
        int r0 = Process.myPid();     // Catch: Exception -> L9
        Iterator<ActivityManager.RunningAppProcessInfo> r3 = ((ActivityManager) getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L9
    L4:
        if (r3.hasNext() == false) goto L18;
        ActivityManager.RunningAppProcessInfo r1 = r3.next();     // Catch: Exception -> L9
        if (r1.pid != r0) goto L4;
        return r1.processName.startsWith("com.android.settings");
    L18:
        return false;
    L9:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // android.app.Application
    public void onCreate() {
        Trace.beginSection("SettingsApplication-onCreate");
        OLog.i("SettingsApplication-onCreate", "onCreate");
        super.onCreate();
        initOAccount();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L5;
        GrantUtil.INSTANCE.setApplicationInitCallback(new SettingsApplication$$ExternalSyntheticLambda0(this));
    L6:
        Trace.endSection();
        return;
    L5:
        initApplication();
        goto L6
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$com-android-settings-SettingsApplication, reason: not valid java name */
    /* synthetic */ void m207lambda$onCreate$0$comandroidsettingsSettingsApplication() {
        initApplication();
    }

    private void initApplication() {
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L6;
        return;
    L6:
        if (LeakCanary.isInAnalyzerProcess(this) == false) goto L8;
        return;
    L8:
        Trace.beginSection("SettingsApplication-initApplication");
        LeakCanary.install(this);
        SettingsTracker.init(this);
        AsyncTask.setDefaultExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        SettingsUncaughtExceptionHandler.getInstance(this).register();
        InitTTNetHelper.INSTANCE.init(this, this);
        String r0 = getLocalProcessName();
        if (getPackageName().equals(r0) == true) goto L12;
        OLog.d(TAG, "current process is: " + r0 + ", NOT main process, just return!");
        Trace.endSection();
        return;
    L12:
        this.mHandler.sendEmptyMessageDelayed(1, 500);
        this.mHandler.sendEmptyMessageDelayed(2, 300000);
        if (SettingsFeature.isSupportDC() == true) goto L15;
    L21:
        updateGestureVideoIfNeeded();
        registerLauncherReadyReceiver();
        if (isSettingsProcess() == false) goto L24;
        initSettings(sContext);
        AppMetrics.INSTANCE.init(this, new SlardarOsReporter());
        OLog.i(TAG, "是Settings主进程");
        EventReportUtil.INSTANCE.initSDK();
        EventDailyReporter.createEventDailyTask(sContext);
    L24:
        ApmHelper.INSTANCE.verify2InitApm(this);
        Trace.endSection();
        return;
    L15:
        if (android.provider.Settings.Global.getInt(getContentResolver(), "screen_color_mode", 0) != 0) goto L21;
        if (SystemProperties.get(PERSIST_LCD_CGM) == null) goto L21;
        if (SystemProperties.get(PERSIST_LCD_CGM).length() != 0) goto L21;
        Calibration.setColorMode(0);
        goto L21
    }

    private void initSettings(Context r1) {
        MatrixSettingsInitManager.INSTANCE.init(r1);
    }

    private void initOLog(Context r2) {
        OLog.init(new OLogConfig.Builder(r2).setLevel(3).setSaveToDisk(true).setLogFileExpDays(30).setLogDirPath(getFilesDir().getAbsolutePath() + "/ologs").build());
        OLog.setOutputToLogd(false);
    }

    private void initOmsLogger() {
        OmsLogger.setLoggerDelegate(new SettingsApplication$$ExternalSyntheticLambda1(this));
    }

    /* JADX INFO: renamed from: lambda$initOmsLogger$1$com-android-settings-SettingsApplication, reason: not valid java name */
    /* synthetic */ void m206lambda$initOmsLogger$1$comandroidsettingsSettingsApplication(int r1, String r2, String r3, Throwable r4) {
        String r0 = formatOmsLogTag(r2);
        switch(r1) {
            case 2: goto L18;
            case 3: goto L15;
            case 4: goto L12;
            case 5: goto L9;
            case 6: goto L6;
            case 7: goto L6;
            default: goto L4;
        };
    L4:
        if (r4 == null) goto L21;
        OLog.i(r0, r3, r4);
        return;
    L21:
        OLog.i(r0, r3);
        return;
    L6:
        if (r4 == null) goto L8;
        OLog.e(r0, r3, r4);
        return;
    L8:
        OLog.e(r0, r3);
        return;
    L9:
        if (r4 == null) goto L11;
        OLog.w(r0, r3, r4);
        return;
    L11:
        OLog.w(r0, r3);
        return;
    L12:
        if (r4 == null) goto L14;
        OLog.i(r0, r3, r4);
        return;
    L14:
        OLog.i(r0, r3);
        return;
    L15:
        if (r4 == null) goto L17;
        OLog.d(r0, r3, r4);
        return;
    L17:
        OLog.d(r0, r3);
        return;
    L18:
        if (r4 == null) goto L20;
        OLog.v(r0, r3, r4);
        return;
    L20:
        OLog.v(r0, r3);
    }

    private String formatOmsLogTag(String r2) {
        if (r2 != null) goto L4;
    L5:
        r2 = "OmsLogger";
    L7:
        if (r2.startsWith(OMS_LOG_TAG_PREFIX) == false) goto L10;
        return r2;
    L10:
        return OMS_LOG_TAG_PREFIX + r2;
    L4:
        if (r2.isEmpty() == false) goto L7;
        goto L5
    }

    private void initOAccount() {
        AccountLogger r0 = new AccountLogger();
        AccountBridge r1 = new AccountBridge();
        OAccount.INSTANCE.init(this, r0, r1);
        OAccountHelper.INSTANCE.registerAccountListener(this);
    }

    private void registerLauncherReadyReceiver() {
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.intent.action.USER_UNLOCKED");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, this.mLauncherReadyReceiver, r0, 2);
    }

    @Override // android.app.Application
    public void onTerminate() {
        unregisterReceiver(this.mLauncherReadyReceiver);
        super.onTerminate();
    }

    private String getLocalProcessName() {
        int r0 = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> r4 = ((ActivityManager) getSystemService("activity")).getRunningAppProcesses();
        int r1 = 0;
        if (r4 != null) goto L5;
        int r2 = 0;
    L6:
        if (r1 >= r2) goto L11;
        if (r4.get(r1).pid == r0) goto L16;
        r1 = r1 + 1;
        goto L6
    L16:
        return r4.get(r1).processName;
    L11:
        return null;
    L5:
        r2 = r4.size();
        goto L6
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        ApplicationLabelCache.getInstance().reload(this);
        return;
    }

    public static Context getContext() {
        return sContext;
    }

    public static Application getApplication() {
        return sApplication;
    }

    public static boolean needMonitorWizardNoOperation(Context r3) {
        if (android.provider.Settings.Global.getInt(r3.getContentResolver(), Constants.DEVICE_ACTIVATION_COMPLETED, 0) != 1) goto L5;
        boolean r0 = true;
    L7:
        if (Utils.isDeviceProvisioned(r3) == true) goto L11;
        if (r0 == false) goto L10;
        return false;
    L10:
        return true;
    L11:
        return false;
    L5:
        r0 = false;
        goto L7
    }

    private static boolean isCharging(Context r3) {
        int r4 = GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r3, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), 2).getIntExtra("plugged", -1);
        if (r4 == 1) goto L8;
        if (r4 == 2) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    private void scheduleShutdownWizard(Context r6) {
        OLog.d(TAG, "scheduleShutdownWizard");
        AlarmManager r0 = (AlarmManager) r6.getSystemService("alarm");
        PendingIntent r5 = getShutdownPendingIntent(r6);
        r0.cancel(r5);
        r0.setExactAndAllowWhileIdle(2, SystemClock.elapsedRealtime() + 3600000, r5);
    }

    private void cancelScheduleShutdownWizard(Context r3) {
        OLog.d(TAG, "cancelScheduleShutdownWizard");
        ((AlarmManager) r3.getSystemService("alarm")).cancel(getShutdownPendingIntent(r3));
    }

    private PendingIntent getShutdownPendingIntent(Context r3) {
        Intent r2 = new Intent("com.bytedanceos.action.settings.HandleEventService");
        r2.putExtra("type", 4);
        return PendingIntent.getService(r3, 1, r2, 335544320);
    }

    public boolean needUpdateIMEI(Context r2) {
        boolean r0 = true;
        if (android.provider.Settings.Global.getInt(r2.getContentResolver(), "has_upload_imei", 1) == 0) goto L6;
        r0 = false;
    L6:
        OLog.d(TAG, "needUpdateIMEI needUpload :" + r0);
        return r0;
    }

    private void updateGestureVideoIfNeeded() {
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L5;
        return;
    L5:
        int r0 = PreferenceMgr.getInstance(this).getInt("gesture_video_version", 1);
        int r2 = getContext().getPackageManager().getApplicationInfo(getContext().getPackageName(), 128).metaData.getInt("gesture_video_version", 1);     // Catch: PackageManager.NameNotFoundException -> L8
    L9:
        if (r2 <= r0) goto L24;
        File r1 = new File(getExternalFilesDir(null), "gesture");
        if (r1.exists() == true) goto L13;
    L19:
        PreferenceMgr.getInstance(this).putInt("gesture_video_version", r2);
        return;
    L13:
        if (r1.isDirectory() == false) goto L19;
        File[] r3 = r1.listFiles();
        if (r3 == null) goto L19;
        int r4 = r3.length;
        int r5 = 0;
    L17:
        if (r5 >= r4) goto L19;
        r3[r5].delete();
        r5 = r5 + 1;
        goto L17
    L24:
        return;
    L8:
        r2 = r0;
        goto L9
    }
}
