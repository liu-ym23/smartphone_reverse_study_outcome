package com.bytedanceos.securitycenter;

import android.app.ActivityManager;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Country;
import android.location.CountryDetector;
import android.location.CountryListener;
import android.os.Process;
import android.os.UserManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.work.Configuration;
import bytedanceos.api.ConfigureRescourceSmt;
import bytedanceos.util.MultiSimAdapter;
import com.bytedanceos.powerusage.PowerUsageHelper;
import com.bytedanceos.preventdisturb.Contact;
import com.bytedanceos.preventdisturb.CootekManager;
import com.bytedanceos.preventdisturb.ToastUtils;
import com.bytedanceos.preventdisturb.widget.AvatarImageView;
import com.bytedanceos.securitycenter.init.InitOlog;
import com.bytedanceos.securitycenter.init.VirusDbAutoUpdateInitializer;
import com.bytedanceos.securitycenter.memory.StorageReportWorker;
import com.obric.android.agilelogger.Util;
import com.obric.baseservice.privacy.PrivacySdkManager;
import com.obric.matrix.platform.sdk.ones.MatrixOnesSdk;
import com.obric.matrix.platform.sdk.ones.commonmonitor.applaunch.AppLaunchMonitor;
import com.obric.matrix.sdk.network.TTNetHelper;
import com.obric.olog.OLog;
import com.obric.pushservice.PushInitializer;
import com.obric.safecheck.dataSync.DailySyncWorkInitializer;
import com.obric.safecheck.dataSync.miitAntiFraud.MiitAntiFraudPushMessageObserver;
import com.obric.safecheck.dataSync.miitAntiFraud.MiitAntiFraudPushTokenObserver;
import com.obric.safecheck.riskcontrol.VirusRiskControlRuntimeInstaller;
import com.obric.safecheck.riskcontrol.observer.RiskProcessObserverManager;
import com.obric.security.BuildConfig;
import com.obric.security.NumberAssistantManager;
import com.obric.security.battertpower.powerHigh.HighPowerWhitelistTask;
import com.obric.security.battertpower.powerHigh.settingsobserver.PowerHighSettingsMonitor;
import com.obric.security.devenvcheck.WlanSecurityDetectService;
import com.obric.security.tcsecurity.cleansdk.CleanSDK;
import com.obric.security.tcsecurity.safecheck.TmsApkCheckManager;
import com.obric.security.tcsecurity.safecheck.TmsUrlCheckManagerImpl;
import com.obric.security.tcsecurity.safecheck.TmsVirusDbUpdateManager;
import com.obric.security.tcsecurity.wifidetect.TmsWifiDetectManagerImpl;
import com.obric.securitycenter.api.ApplicationContainer;
import com.obric.securitycenter.api.GlobalManagerCreator;
import com.obric.securitycenter.api.INumberCheckManager;
import com.obric.securitycenter.api.ITmsApkCheckManager;
import com.obric.securitycenter.api.ITmsUrlCheckManager;
import com.obric.securitycenter.api.ITmsWifiDetectManager;
import com.obric.securitycenter.api.IVirusDbUpdateManager;
import com.obric.securitycenter.api.MatrixUtil;
import com.obric.taskmanager.TaskManager;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public class SecurityCenterApplication extends Application implements Configuration.Provider {
    public static final String ACTION_UPDATE_COUNTRY_ISO = "com_bytedanceos_mms_action_update_country_iso";
    private static final int APPID = 899598;
    private static final String LAST_SUBSCRIBER_PROP = "persist.radio.last.subscriber";
    private static final int MAX_THREAD_NUM = 5;
    public static final String TAG = "SecurityCenterApplication";
    private static final String TMS_UPDATE_TIME = "tms_update_time";
    private static final String TRACK_VALUE_TIME = "track_value_time";
    private static Context mContext;
    private static SecurityCenterApplication sSecurityCenterApplication;
    private String debugCode;
    private boolean isMainProcess;
    private CountryDetector mCountryDetector;
    private String mCountryIso;
    private android.content.res.Configuration mCurrentConfig;
    private BroadcastReceiver mLanguageChangeReceiver;
    private ExecutorService mSharedPrefExecutorService;
    private TelephonyManager mTelephonyManager;
    private PowerHighSettingsMonitor powerHighSettingsMonitor;
    private String releaseCode;

    static {
    }

    public SecurityCenterApplication() {
        this.powerHighSettingsMonitor = new PowerHighSettingsMonitor();
        this.debugCode = "#4#107561##FQedagTeCuQUX4oW/z/Q7do9em4tKd6KRvFwuJiO9Og/U9aRV5Ma7FOnjmRFegIPcVFiIOq9OzFMRZkG8+p7dw==";
        this.releaseCode = "#4#107561##dSdZE6EjszQNoiZ7Pgw5fEwhzYmvwQefNaMId7F2mS/rkFOzGW5IZiunJuobhS9JUZetDSCAc9DcvCKk77n/GQ==";
        this.isMainProcess = false;
        this.mLanguageChangeReceiver = new AnonymousClass1(this);
    }

    static /* synthetic */ void access$000(SecurityCenterApplication r0, boolean r1, Country r2) {
        r0.updateCountryIso(r1, r2);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context base) {
        boolean r0 = Util.isMainProcess(base);
        this.isMainProcess = r0;
        if (r0 == false) goto L5;
        AppLaunchMonitor.getInstance().registerActivityLifecycleCallbacks(this);
        AppLaunchMonitor.getInstance().startTrace(MainActivity.class.getName());
    L5:
        super.attachBaseContext(base);
        sSecurityCenterApplication = this;
        MatrixUtil.INSTANCE.markLaunchPeriod(AppLaunchMonitor.PERIOD_APP_ATTACH, false, this.isMainProcess);
    }

    @Override // android.app.Application
    public void onCreate() {
        InitOlog.INSTANCE.initOLog(this);
        OLog.d(TAG, "onCreate");
        MatrixUtil.INSTANCE.markLaunchPeriod(AppLaunchMonitor.PERIOD_APP_CREATE, true, this.isMainProcess);
        super.onCreate();
        MatrixUtil.INSTANCE.initMatrix(this, BuildConfig.VERSION_NAME, BuildConfig.VERSION_CODE, false);
        String r0 = getProcessName(this, Process.myPid());
        if (TextUtils.equals(r0, getPackageName() + ":security_scan") == false) goto L7;
        mContext = getApplicationContext();
        ApplicationContainer.INSTANCE.init(this);
        GlobalManagerCreator.INSTANCE.registerManager(ITmsWifiDetectManager.class, new SecurityCenterApplication$$ExternalSyntheticLambda0());
        return;
    L7:
        if (TextUtils.equals(r0, getPackageName()) == true) goto L9;
        return;
    L9:
        mContext = getApplicationContext();
        ApplicationContainer.INSTANCE.init(this);
        VirusRiskControlRuntimeInstaller.install(this);
        initNetworkSDK();
        MatrixOnesSdk.INSTANCE.init(this, new AnonymousClass2(this));
        GlobalManagerCreator.INSTANCE.registerManager(ITmsUrlCheckManager.class, new SecurityCenterApplication$$ExternalSyntheticLambda1());
        GlobalManagerCreator.INSTANCE.registerManager(ITmsApkCheckManager.class, new SecurityCenterApplication$$ExternalSyntheticLambda2());
        GlobalManagerCreator.INSTANCE.registerManager(ITmsWifiDetectManager.class, new SecurityCenterApplication$$ExternalSyntheticLambda3());
        GlobalManagerCreator.INSTANCE.registerManager(INumberCheckManager.class, new SecurityCenterApplication$$ExternalSyntheticLambda4());
        GlobalManagerCreator.INSTANCE.registerManager(IVirusDbUpdateManager.class, new SecurityCenterApplication$$ExternalSyntheticLambda5());
        initWorkAfterUserUnlocked();
        startService(new Intent(this, WlanSecurityDetectService.class));     // Catch: Throwable -> L12
    L14:
        this.mCountryDetector = (CountryDetector) getSystemService("country_detector");
        CountryListener r1 = new AnonymousClass3(this);
        CountryDetector r2 = this.mCountryDetector;
        if (r2 == null) goto L17;
        r2.addCountryListener(r1, getMainLooper());
    L17:
        this.mCurrentConfig = new android.content.res.Configuration(getResources().getConfiguration());
        if (com.bytedanceos.security.Utils.hasTelephonyFeature(this) == false) goto L20;
        Contact.init(this);
        CootekManager.init(this);
    L20:
        this.mSharedPrefExecutorService = Executors.newFixedThreadPool(5);
        ToastUtils.init(this);
        PowerUsageHelper.resetLowPowerModeTriggerLevel(getApplicationContext());
        IntentFilter r3 = new IntentFilter();
        r3.addAction("android.intent.action.LOCALE_CHANGED");
        registerReceiver(this.mLanguageChangeReceiver, r3);
        this.powerHighSettingsMonitor.startMonitoring(this);
        RiskProcessObserverManager.INSTANCE.register(this, false);
        TaskManager.Companion.getInstance().execute("allow_bg_power_high", new HighPowerWhitelistTask(getApplicationContext()));
        MatrixUtil.INSTANCE.markLaunchPeriod(AppLaunchMonitor.PERIOD_APP_CREATE, false, this.isMainProcess);
        return;
    L12:
        th = move-exception;
        OLog.w(TAG, "start WlanSecurityDetectService failed", th);
        goto L14
    }

    static /* synthetic */ ITmsWifiDetectManager lambda$onCreate$0() {
        CleanSDK.INSTANCE.initCleanSDK();
        return TmsWifiDetectManagerImpl.INSTANCE;
    }

    static /* synthetic */ ITmsUrlCheckManager lambda$onCreate$1() {
        CleanSDK.INSTANCE.initCleanSDK();
        return TmsUrlCheckManagerImpl.INSTANCE;
    }

    static /* synthetic */ ITmsApkCheckManager lambda$onCreate$2() {
        CleanSDK.INSTANCE.initCleanSDK();
        return TmsApkCheckManager.INSTANCE;
    }

    static /* synthetic */ ITmsWifiDetectManager lambda$onCreate$3() {
        return TmsWifiDetectManagerImpl.INSTANCE;
    }

    static /* synthetic */ INumberCheckManager lambda$onCreate$4() {
        return NumberAssistantManager.getInstance();
    }

    static /* synthetic */ IVirusDbUpdateManager lambda$onCreate$5() {
        CleanSDK.INSTANCE.initCleanSDK();
        return TmsVirusDbUpdateManager.INSTANCE;
    }

    @Override // android.app.Application
    public void onTerminate() {
        unregisterReceiver(this.mLanguageChangeReceiver);
        super.onTerminate();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (TextUtils.equals(getProcessName(this, Process.myPid()), getPackageName()) == true) goto L6;
        return;
    L6:
        if (this.mCurrentConfig != null) goto L9;
        return;
    L9:
        if (ConfigureRescourceSmt.getInstance().isSameCustomTheme(this.mCurrentConfig, newConfig) == true) goto L11;
        AvatarImageView.onColorThemeChange(this);
    L11:
        this.mCurrentConfig = new android.content.res.Configuration(newConfig);
    }

    public ExecutorService getSharedPrefExecutorService() {
        if (this.mSharedPrefExecutorService != null) goto L6;
        this.mSharedPrefExecutorService = Executors.newFixedThreadPool(5);
    L6:
        return this.mSharedPrefExecutorService;
    }

    public String getCurrentCountryIso() {
        if (TextUtils.isEmpty(this.mCountryIso) == false) goto L5;
        CountryDetector r0 = this.mCountryDetector;
        if (r0 == null) goto L9;
        Country r1 = r0.detectCountry();
    L10:
        updateCountryIso(false, r1);
        return this.mCountryIso;
    L9:
        r1 = null;
        goto L10
    L5:
        return this.mCountryIso;
    }

    private void updateCountryIso(boolean initContact, Country country) {
        TelephonyManager r0 = getTelephonyManager();
        if (r0 != null) goto L5;
        return;
    L5:
        String r1 = r0.getSimCountryIso();
        if (TextUtils.isEmpty(r1) == false) goto L10;
        if (country == null) goto L10;
        r1 = country.getCountryIso();
    L10:
        if (TextUtils.isEmpty(r1) == true) goto L19;
        String r4 = r1.toUpperCase(Locale.US);
        if (r4.equals(this.mCountryIso) == true) goto L20;
        this.mCountryIso = r4;
        if (initContact == true) goto L16;
        return;
    L16:
        if (com.bytedanceos.security.Utils.hasTelephonyFeature(this) == false) goto L22;
        Contact.init(this);
        sendBroadcast(new Intent(ACTION_UPDATE_COUNTRY_ISO));
        return;
    L22:
        return;
    L20:
        return;
    }

    private void initNetworkSDK() {
        TTNetHelper.INSTANCE.setRequestListener(new AnonymousClass4(this));
    }

    private void initWorkAfterUserUnlocked() {
        String r0 = TAG;
        OLog.i(r0, "initWorkAfterUserUnlocked");
        UserManager r1 = (UserManager) getSystemService(UserManager.class);
        if (r1 != null) goto L5;
    L8:
        MiitAntiFraudPushTokenObserver.register();
        MiitAntiFraudPushMessageObserver.register();
        PushInitializer.init(this);
        AccountSdkInitializer.INSTANCE.init(this);
        PrivacySdkManager.INSTANCE.init(this);
        DailySyncWorkInitializer.INSTANCE.init(this);
        StorageReportWorker.init(this);
        VirusDbAutoUpdateInitializer.init(this);
        PowerUsageHelper.resetBgBatteryControllerStatus(getApplication());
        return;
    L5:
        if (r1.isUserUnlocked() == true) goto L8;
        OLog.i(r0, "Skip WorkManager init before user unlock");
    }

    public static synchronized SecurityCenterApplication getApplication() {
        monitor-enter(SecurityCenterApplication.class);
        SecurityCenterApplication r1 = sSecurityCenterApplication;     // Catch: Throwable -> L7
        monitor-exit(SecurityCenterApplication.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public TelephonyManager getTelephonyManager() {
        if (this.mTelephonyManager != null) goto L6;
        this.mTelephonyManager = (TelephonyManager) mContext.getSystemService("phone");
    L6:
        return this.mTelephonyManager;
    }

    private static String getActiveSubscriberId(int currentSlot) {
        String r0 = TelephonyManager.getDefault().getSubscriberId(MultiSimAdapter.slot2Sub(currentSlot));
        if (r0 == null) goto L6;
        return r0;
    L6:
        return getLastSubscriberId(currentSlot);
    }

    private static String getLastSubscriberId(int currentSlot) {
        return TelephonyManager.getTelephonyProperty(currentSlot, LAST_SUBSCRIBER_PROP, null);
    }

    public static String getProcessName(Context context, int pid) {
        ActivityManager r3 = (ActivityManager) context.getSystemService("activity");
        if (r3 != null) goto L5;
        return "";
    L5:
        List<ActivityManager.RunningAppProcessInfo> r4 = r3.getRunningAppProcesses();
        if (r4 != null) goto L8;
    L17:
        return "";
    L8:
        if (r4.isEmpty() == true) goto L17;
        Iterator<ActivityManager.RunningAppProcessInfo> r5 = r4.iterator();
    L12:
        if (r5.hasNext() == false) goto L17;
        ActivityManager.RunningAppProcessInfo r1 = r5.next();
        if (r1.pid != pid) goto L12;
        return r1.processName;
    }

    public static Context getContext() {
        return mContext;
    }

    @Override // androidx.work.Configuration.Provider
    public Configuration getWorkManagerConfiguration() {
        return new Configuration.Builder().setMinimumLoggingLevel(4).build();
    }
}
