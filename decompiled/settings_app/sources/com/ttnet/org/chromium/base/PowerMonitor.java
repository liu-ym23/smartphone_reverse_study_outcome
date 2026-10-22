package com.ttnet.org.chromium.base;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.PowerManager;
import android.text.TextUtils;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.compat.ApiHelperForQ;
import com.ttnet.org.chromium.build.BuildConfig;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes5.dex */
@JNINamespace("base::android")
public class PowerMonitor implements TTLifeCycleMonitor.AppStateListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static String CRONET_ACTION_BACK = null;
    private static String CRONET_ACTION_FORE = null;
    private static final String TAG = "PowerMonitor";
    private static final long TIME_TO_ENTER_SAME_STATE = 10000;
    private static String WSCHANNEL_ACTION_BACK;
    private static String WSCHANNEL_ACTION_FORE;
    private static TTLifeCycleMonitor mLifeCycleMonitor;
    private static boolean mListenAppStateIndependently;
    private static PowerMonitor sInstance;
    private static String sPackageName;
    private static long sReceiveBackAction;
    private static long sReceiveForeAction;
    private static AppStateReceiver sReceiver;
    private boolean mIsBatteryPower;

    public static class AppStateReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            com_ttnet_org_chromium_base_PowerMonitor$AppStateReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
        }

        public AppStateReceiver() {
        }

        public void com_ttnet_org_chromium_base_PowerMonitor$AppStateReceiver__onReceive$___twin___(Context r6, Intent r7) {
            long r5 = System.currentTimeMillis();
            String r8 = r7.getAction();
            if (r8.equals(PowerMonitor.access$000()) == false) goto L5;
        L14:
            long r3 = r5 - PowerMonitor.access$200();
            PowerMonitor.access$202(r5);
            if (r3 <= PowerMonitor.TIME_TO_ENTER_SAME_STATE) goto L21;
            PowerMonitorJni.get().onResume();
            return;
        L21:
            return;
        L5:
            if (r8.equals(PowerMonitor.access$100()) == true) goto L14;
            if (r8.equals(PowerMonitor.access$300()) == false) goto L10;
        L11:
            long r4 = r5 - PowerMonitor.access$500();
            PowerMonitor.access$502(r5);
            if (r4 <= PowerMonitor.TIME_TO_ENTER_SAME_STATE) goto L19;
            PowerMonitorJni.get().onSuspend();
            return;
        L19:
            return;
        L10:
            if (r8.equals(PowerMonitor.access$400()) == true) goto L11;
        }

        @Insert("onReceive")
        public static void com_ttnet_org_chromium_base_PowerMonitor$AppStateReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(AppStateReceiver r7, Context r8, Intent r9) {
            Intrinsics.checkNotNullParameter(r8, "context");
            String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
            AppStateReceiver r1 = r7;
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
            r7.com_ttnet_org_chromium_base_PowerMonitor$AppStateReceiver__onReceive$___twin___(r8, r9);
            return;
        L13:
            GrantUtil r11 = GrantUtil.INSTANCE;
            Application r12 = SettingsApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
            if (r11.isSetupCompelete(r12) == true) goto L16;
            OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
            r7.com_ttnet_org_chromium_base_PowerMonitor$AppStateReceiver__onReceive$___twin___(r8, r9);
            return;
        L16:
            String r13 = r3;
            if (r13 != null) goto L19;
        L22:
            boolean r14 = true;
        L23:
            if (r14 == false) goto L26;
            OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
            r7.com_ttnet_org_chromium_base_PowerMonitor$AppStateReceiver__onReceive$___twin___(r8, r9);
            return;
        L26:
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
            if (r4 == true) goto L30;
            OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
            return;
        L30:
            GrantUtil.INSTANCE.applicationInit();
            r7.com_ttnet_org_chromium_base_PowerMonitor$AppStateReceiver__onReceive$___twin___(r8, r9);
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

    interface Natives {
        void onBatteryChargingChanged();

        void onInstantResume();

        void onInstantSuspend();

        void onResume();

        void onSuspend();

        void onThermalStatusChanged(int r1);
    }

    static /* synthetic */ String access$000() {
        return CRONET_ACTION_FORE;
    }

    static /* synthetic */ String access$100() {
        return WSCHANNEL_ACTION_FORE;
    }

    static /* synthetic */ long access$200() {
        return sReceiveForeAction;
    }

    static /* synthetic */ long access$202(long r0) {
        sReceiveForeAction = r0;
        return r0;
    }

    static /* synthetic */ String access$300() {
        return CRONET_ACTION_BACK;
    }

    static /* synthetic */ String access$400() {
        return WSCHANNEL_ACTION_BACK;
    }

    static /* synthetic */ long access$500() {
        return sReceiveBackAction;
    }

    static /* synthetic */ long access$502(long r0) {
        sReceiveBackAction = r0;
        return r0;
    }

    static /* synthetic */ void access$600(boolean r0) {
        onBatteryChargingChanged(r0);
    }

    static {
        mLifeCycleMonitor = new TTLifeCycleMonitor();
    }

    public static void setListenAppStateIndependently(boolean r0) {
        mListenAppStateIndependently = r0;
    }

    public static void mockAppResumeForTesting() {
        if (BuildConfig.DCHECK_IS_ON == false) goto L6;
        PowerMonitorJni.get().onResume();
        return;
    }

    public static void mockAppSuspendForTesting() {
        if (BuildConfig.DCHECK_IS_ON == false) goto L6;
        PowerMonitorJni.get().onSuspend();
        return;
    }

    @Override // com.ttnet.org.chromium.base.TTLifeCycleMonitor.AppStateListener
    public void onEnterToForeground() {
        Context r2 = ContextUtils.getApplicationContext();
        if (TTProcessUtils.isMainProcess(r2) == false) goto L11;
        Intent r0 = new Intent();
        r0.setAction(CRONET_ACTION_FORE);
        if (TextUtils.isEmpty(sPackageName) == true) goto L13;
        r0.setPackage(sPackageName);
    L13:
        r2.sendBroadcast(r0);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
    L11:
        PowerMonitorJni.get().onResume();
    }

    @Override // com.ttnet.org.chromium.base.TTLifeCycleMonitor.AppStateListener
    public void onEnterToBackground() {
        Context r2 = ContextUtils.getApplicationContext();
        if (TTProcessUtils.isMainProcess(r2) == false) goto L11;
        Intent r0 = new Intent();
        r0.setAction(CRONET_ACTION_BACK);
        if (TextUtils.isEmpty(sPackageName) == true) goto L13;
        r0.setPackage(sPackageName);
    L13:
        r2.sendBroadcast(r0);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
    L11:
        PowerMonitorJni.get().onSuspend();
    }

    @Override // com.ttnet.org.chromium.base.TTLifeCycleMonitor.AppStateListener
    public void onInstantEnterToForeground() {
        PowerMonitorJni.get().onInstantResume();
    }

    @Override // com.ttnet.org.chromium.base.TTLifeCycleMonitor.AppStateListener
    public void onInstantEnterToBackground() {
        PowerMonitorJni.get().onInstantSuspend();
    }

    public static void createForTests() {
        sInstance = new PowerMonitor();
    }

    public static void create() {
        if (sInstance == null) goto L5;
        return;
    L5:
        Context r0 = ContextUtils.getApplicationContext();
        sInstance = new PowerMonitor();
        Intent r1 = ContextUtils.registerNonExportedBroadcastReceiver(r0, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (r1 == null) goto L11;
        boolean r3 = false;
        if (r1.getIntExtra("plugged", 0) != 0) goto L10;
        r3 = true;
    L10:
        onBatteryChargingChanged(r3);
    L11:
        IntentFilter r2 = new IntentFilter();
        r2.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        r2.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        ContextUtils.registerNonExportedBroadcastReceiver(r0, new AnonymousClass1(), r2);
        sPackageName = r0.getPackageName();
        CRONET_ACTION_BACK = sPackageName + ".cronet.APP_BACKGROUND";
        CRONET_ACTION_FORE = sPackageName + ".cronet.APP_FOREGROUND";
        WSCHANNEL_ACTION_BACK = sPackageName + ".wschannel.APP_BACKGROUND";
        WSCHANNEL_ACTION_FORE = sPackageName + ".wschannel.APP_FOREGROUND";
        if (TTProcessUtils.isMainProcess(r0) == true) goto L18;
        if (mListenAppStateIndependently == true) goto L18;
        sReceiver = new AppStateReceiver();
        IntentFilter r4 = new IntentFilter();
        r4.addAction(CRONET_ACTION_BACK);
        r4.addAction(CRONET_ACTION_FORE);
        r4.addAction(WSCHANNEL_ACTION_BACK);
        r4.addAction(WSCHANNEL_ACTION_FORE);
        ContextUtils.registerNonExportedBroadcastReceiver(r0, sReceiver, r4);
        return;
    L18:
        if ((r0 instanceof Application) == false) goto L22;
        mLifeCycleMonitor.setAppStateChangedListener(sInstance);
        ((Application) r0).registerActivityLifecycleCallbacks(mLifeCycleMonitor);
        return;
    }

    private PowerMonitor() {
    }

    private static void onBatteryChargingChanged(boolean r1) {
        sInstance.mIsBatteryPower = r1;
        PowerMonitorJni.get().onBatteryChargingChanged();
    }

    private static boolean isBatteryPower() {
        if (sInstance != null) goto L6;
        create();
    L6:
        return sInstance.mIsBatteryPower;
    }

    private static int getRemainingBatteryCapacity() {
        if (sInstance != null) goto L6;
        create();
    L6:
        return getRemainingBatteryCapacityImpl();
    }

    private static int getRemainingBatteryCapacityImpl() {
        return ((BatteryManager) ContextUtils.getApplicationContext().getSystemService("batterymanager")).getIntProperty(1);
    }

    private static int getCurrentThermalStatus() {
        if (sInstance != null) goto L5;
        create();
    L5:
        PowerManager r0 = (PowerManager) ContextUtils.getApplicationContext().getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        if (r0 != null) goto L10;
        return -1;
    L10:
        return ApiHelperForQ.getCurrentThermalStatus(r0);
    }
}
