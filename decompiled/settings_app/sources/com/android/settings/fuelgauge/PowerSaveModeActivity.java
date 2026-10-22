package com.android.settings.fuelgauge;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.provider.Settings;
import android.widget.CompoundButton;
import bytedanceos.api.PackageManagerSmt;
import bytedanceos.api.PowerManagerSmt;
import com.android.settings.R;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.ListContentItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public class PowerSaveModeActivity extends BaseActivity {
    private static final String ON_HAND_IN_HAND_KEY = "on_hand_in_hand";
    private static final String SCREEN_RECORDER_STATUS = "screen_recorder_status";
    private CompoundButton.OnCheckedChangeListener mFeatureModeChangeListener;
    ListContentItemSwitch mFeaturePhoneMode;
    private ContentObserver mFeaturePhoneModeObserver;
    private ContentObserver mHandInHandObserver;
    boolean mIsFeaturePhoneMode;
    boolean mIsLowBatteryMode;
    ListContentItemSwitch mLowBatteryMode;
    private CompoundButton.OnCheckedChangeListener mLowBatteryModeChangeListener;
    private ContentObserver mLowBatteryModeObserver;
    PowerManager mPowerManager;
    PowerManagerSmt mPowerManagerSmt;
    private ContentObserver mRecordScreenObserver;
    private AlertDialog mSavePowerDialog;

    public void com_android_settings_fuelgauge_PowerSaveModeActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_fuelgauge_PowerSaveModeActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_fuelgauge_PowerSaveModeActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com_android_settings_fuelgauge_PowerSaveModeActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_fuelgauge_PowerSaveModeActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_fuelgauge_PowerSaveModeActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_fuelgauge_PowerSaveModeActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public PowerSaveModeActivity() {
        final Handler r1 = new Handler();
        this.mLowBatteryModeObserver = new AnonymousClass1(this, r1);
        final Handler r2 = new Handler();
        this.mFeaturePhoneModeObserver = new AnonymousClass2(this, r2);
        this.mLowBatteryModeChangeListener = new AnonymousClass3(this);
        this.mFeatureModeChangeListener = new AnonymousClass8(this);
        final Handler r3 = new Handler();
        this.mRecordScreenObserver = new AnonymousClass13(this, r3);
        final Handler r4 = new Handler();
        this.mHandInHandObserver = new AnonymousClass14(this, r4);
    }

    static /* synthetic */ void access$000(PowerSaveModeActivity r0) {
        r0.setChecked();
    }

    static /* synthetic */ void access$100(PowerSaveModeActivity r0) {
        r0.showLowBatteryModeDialog();
    }

    static /* synthetic */ boolean access$200(PowerSaveModeActivity r0, PackageManager r1, String r2) {
        return r0.isPackageLocked(r1, r2);
    }

    static /* synthetic */ AlertDialog access$300(PowerSaveModeActivity r0) {
        return r0.mSavePowerDialog;
    }

    static /* synthetic */ AlertDialog access$302(PowerSaveModeActivity r0, AlertDialog r1) {
        r0.mSavePowerDialog = r1;
        return r1;
    }

    static /* synthetic */ void access$400(PowerSaveModeActivity r0) {
        r0.showFeatureModeDialog();
    }

    static /* synthetic */ void access$500(PowerSaveModeActivity r0) {
        r0.initFeaturePhoneSwitchEnable();
    }

    public void com_android_settings_fuelgauge_PowerSaveModeActivity__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        setContentView(R.layout.power_usage_mode_activity);
        this.mPowerManager = (PowerManager) getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        this.mPowerManagerSmt = PowerManagerSmt.getInstance();
        setupBackBtnOnTitle();
        initView();
    }

    private void initView() {
        ListContentItemSwitch r0 = (ListContentItemSwitch) findViewById(R.id.power_usage_low_battery_mode);
        this.mLowBatteryMode = r0;
        r0.getTitleView().setTextColor(getResources().getColorStateList(R.color.power_save_mode_item_switch_colorlist));
        ListContentItemSwitch r1 = (ListContentItemSwitch) findViewById(R.id.power_usage_feature_phone_mode);
        this.mFeaturePhoneMode = r1;
        r1.getTitleView().setTextColor(getResources().getColorStateList(R.color.power_save_mode_item_switch_colorlist));
    }

    public static boolean isLowBatteryMode(Context r2) {
        if (Settings.Global.getInt(r2.getContentResolver(), "low_power", 0) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean isFeaturePhoneMode(Context r2) {
        if (Settings.Global.getInt(r2.getContentResolver(), "feature_phone_mode", 0) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    private void setChecked() {
        this.mLowBatteryMode.setOnCheckedChangeListener(null);
        this.mFeaturePhoneMode.setOnCheckedChangeListener(null);
        ListContentItemSwitch r0 = this.mLowBatteryMode;
        if (this.mIsFeaturePhoneMode == false) goto L5;
    L7:
        boolean r1 = false;
    L8:
        r0.setChecked(r1);
        this.mFeaturePhoneMode.setChecked(this.mIsFeaturePhoneMode);
        this.mFeaturePhoneMode.setOnCheckedChangeListener(this.mFeatureModeChangeListener);
        this.mLowBatteryMode.setOnCheckedChangeListener(this.mLowBatteryModeChangeListener);
        return;
    L5:
        if (this.mIsLowBatteryMode == false) goto L7;
        r1 = true;
        goto L8
    }

    private void showLowBatteryModeDialog() {
        if (this.mSavePowerDialog != null) goto L6;
        AlertDialog.Builder r0 = new AlertDialog.Builder(this);
        r0.setTitle(R.string.enter_save_power_alert_title).setMessage(R.string.power_usage_low_battery_alert_msg_first_open).setNegativeButton(R.string.cancel, new AnonymousClass5(this)).setPositiveButton(R.string.enter_save_power_ok, new AnonymousClass4(this));
        AlertDialog r1 = r0.create();
        this.mSavePowerDialog = r1;
        r1.setOnCancelListener(new AnonymousClass6(this));
        this.mSavePowerDialog.setOnDismissListener(new AnonymousClass7(this));
    L6:
        if (this.mSavePowerDialog.isShowing() == true) goto L9;
        this.mSavePowerDialog.show();
        return;
    }

    private void showFeatureModeDialog() {
        if (this.mSavePowerDialog != null) goto L6;
        AlertDialog.Builder r0 = new AlertDialog.Builder(this);
        r0.setTitle(R.string.enter_save_power_alert_title).setMessage(R.string.power_usage_feature_phone_alert_text).setNegativeButton(R.string.cancel, new AnonymousClass10(this)).setPositiveButton(R.string.enter_save_power_ok, new AnonymousClass9(this));
        AlertDialog r1 = r0.create();
        this.mSavePowerDialog = r1;
        r1.setOnCancelListener(new AnonymousClass11(this));
        this.mSavePowerDialog.setOnDismissListener(new AnonymousClass12(this));
    L6:
        if (this.mSavePowerDialog.isShowing() == true) goto L9;
        this.mSavePowerDialog.show();
        return;
    }

    public boolean isRecordScreen(Context r2) {
        if (Settings.Global.getInt(r2.getContentResolver(), SCREEN_RECORDER_STATUS, 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public boolean isHandInHand() {
        int r3 = Settings.System.getInt(getContentResolver(), ON_HAND_IN_HAND_KEY, 0);
        if (r3 == 1) goto L9;
        if (r3 == 2) goto L9;
        if (r3 == 101) goto L9;
        return false;
    L9:
        return true;
    }

    private void initFeaturePhoneSwitchEnable() {
        if (isRecordScreen(this) == false) goto L5;
    L8:
        this.mFeaturePhoneMode.setEnabled(false);
        this.mFeaturePhoneMode.getTitleView().setEnabled(false);
    L10:
        if (isHandInHand() == false) goto L12;
        this.mLowBatteryMode.setEnabled(false);
        this.mLowBatteryMode.getTitleView().setEnabled(false);
        return;
    L12:
        this.mLowBatteryMode.setEnabled(true);
        this.mLowBatteryMode.getTitleView().setEnabled(true);
        return;
    L5:
        if (isHandInHand() == true) goto L8;
        this.mFeaturePhoneMode.setEnabled(true);
        this.mFeaturePhoneMode.getTitleView().setEnabled(true);
        goto L10
    }

    private boolean isPackageLocked(PackageManager r1, String r2) {
        return PackageManagerSmt.getInstance().isPackageLocked(r1, r2);
    }

    public void com_android_settings_fuelgauge_PowerSaveModeActivity__onResume$___twin___() {
        super.onResume();
        this.mIsLowBatteryMode = isLowBatteryMode(this);
        this.mIsFeaturePhoneMode = this.mPowerManagerSmt.isFeaturePhoneMode(this.mPowerManager);
        setChecked();
        getContentResolver().registerContentObserver(Settings.Global.getUriFor("low_power"), true, this.mLowBatteryModeObserver);
        getContentResolver().registerContentObserver(Settings.Global.getUriFor("feature_phone_mode"), true, this.mFeaturePhoneModeObserver);
        getContentResolver().registerContentObserver(Settings.Global.getUriFor(SCREEN_RECORDER_STATUS), true, this.mRecordScreenObserver);
        getContentResolver().registerContentObserver(Settings.System.getUriFor(ON_HAND_IN_HAND_KEY), true, this.mHandInHandObserver);
        initFeaturePhoneSwitchEnable();
    }

    public void com_android_settings_fuelgauge_PowerSaveModeActivity__onPause$___twin___() {
        super.onPause();
        getContentResolver().unregisterContentObserver(this.mLowBatteryModeObserver);
        getContentResolver().unregisterContentObserver(this.mFeaturePhoneModeObserver);
        getContentResolver().unregisterContentObserver(this.mRecordScreenObserver);
        getContentResolver().unregisterContentObserver(this.mHandInHandObserver);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_fuelgauge_PowerSaveModeActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(PowerSaveModeActivity r1) {
        com_android_settings_fuelgauge_PowerSaveModeActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_fuelgauge_PowerSaveModeActivity_com_obric_hook_lancet_PrivacyHook_onCreate(PowerSaveModeActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        PowerSaveModeActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_fuelgauge_PowerSaveModeActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fuelgauge_PowerSaveModeActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(PowerSaveModeActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_fuelgauge_PowerSaveModeActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fuelgauge_PowerSaveModeActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(PowerSaveModeActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_fuelgauge_PowerSaveModeActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        PowerSaveModeActivity r5 = r4;
        String r2 = r5.getCallingPackage();
        if (r2 != null) goto L9;
        OLog.e("BaseActivity", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r6 = r5.getReferrer();
        if (r6 == null) goto L9;
        r2 = r6.toString();
    L9:
        OLog.i("TeaEventReportUtil", "callingPkg=" + r2);
        if (r2 != null) goto L12;
        r2 = "null";
    L12:
        AppMetricsUtils.INSTANCE.reportColdStartActivity(r2, r0);
    L13:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }

    @Insert(mayCreateSuper = true, value = "startActivityForResult")
    public static void com_android_settings_fuelgauge_PowerSaveModeActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(PowerSaveModeActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_fuelgauge_PowerSaveModeActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_fuelgauge_PowerSaveModeActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(PowerSaveModeActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_fuelgauge_PowerSaveModeActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_fuelgauge_PowerSaveModeActivity_com_obric_hook_lancet_PrivacyHook_onResume(PowerSaveModeActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        PowerSaveModeActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_fuelgauge_PowerSaveModeActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_fuelgauge_PowerSaveModeActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(PowerSaveModeActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_fuelgauge_PowerSaveModeActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_fuelgauge_PowerSaveModeActivity_com_obric_hook_lancet_PrivacyHook_onPause(PowerSaveModeActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        PowerSaveModeActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_fuelgauge_PowerSaveModeActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_fuelgauge_PowerSaveModeActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(PowerSaveModeActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_fuelgauge_PowerSaveModeActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        PowerSaveModeActivity r5 = r3;
        String r6 = r5.getCallingPackage();
        if (r6 != null) goto L9;
        OLog.e("AppLifecycle", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r7 = r5.getReferrer();
        if (r7 == null) goto L9;
        r6 = r7.toString();
    L9:
        OLog.i("AppLifecycle", "TeaEventReportUtil callingPkg=" + r6);
        if (r6 != null) goto L12;
        r6 = "null";
    L12:
        AppMetricsUtils r8 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r8.callingPackageEvent(r6, r0, false);
        return;
    }

    @Insert("onStop")
    public static void com_android_settings_fuelgauge_PowerSaveModeActivity_com_obric_hook_lancet_PrivacyHook_onStop(PowerSaveModeActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        PowerSaveModeActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_fuelgauge_PowerSaveModeActivity__onStop$___twin___();
    }
}
