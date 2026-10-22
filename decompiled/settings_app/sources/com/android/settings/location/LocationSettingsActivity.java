package com.android.settings.location;

import android.content.Intent;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.widget.CompoundButton;
import com.android.settings.R;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public class LocationSettingsActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener {
    private SettingItemSwitch mAgps;
    private SettingItemSwitch mGpsAndNetwork;
    private final ContentObserver mGpsObserver;

    public void com_android_settings_location_LocationSettingsActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_location_LocationSettingsActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_location_LocationSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com_android_settings_location_LocationSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_location_LocationSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_location_LocationSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_location_LocationSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public LocationSettingsActivity() {
        final Handler r1 = new Handler();
        this.mGpsObserver = new AnonymousClass1(this, r1);
    }

    public void com_android_settings_location_LocationSettingsActivity__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        setContentView(R.layout.location_settings_activity);
        this.mGpsAndNetwork = (SettingItemSwitch) findViewById(R.id.gps);
        this.mAgps = (SettingItemSwitch) findViewById(R.id.agps);
        setupBackBtnOnTitle();
    }

    private boolean isGpsOn() {
        return Settings.Secure.isLocationProviderEnabled(getContentResolver(), "gps");
    }

    private boolean isNetworkLocationOn() {
        return Settings.Secure.isLocationProviderEnabled(getContentResolver(), "network");
    }

    private boolean isAGPSEnable() {
        if (Settings.Global.getInt(getContentResolver(), "assisted_gps_enabled", 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void setAGPSEnable(boolean r2) {
        Settings.Global.putInt(getContentResolver(), "assisted_gps_enabled", r2 ? 1 : 0);
    }

    public void setLocationProviderEnabled(boolean r3) {
        Settings.Secure.setLocationProviderEnabled(getContentResolver(), "network", r3);
        Settings.Secure.setLocationProviderEnabled(getContentResolver(), "gps", r3);
    }

    public void updateGpsSwitchState() {
        boolean r0 = isNetworkLocationOn();
        this.mGpsAndNetwork.setChecked(r0);
        this.mAgps.getSwitch().setEnabled(this.mGpsAndNetwork.isChecked());
        this.mAgps.setChecked(isAGPSEnable());
        setLocationProviderEnabled(r0);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != this.mAgps.getSwitch()) goto L6;
        setAGPSEnable(r3);
        return;
    L6:
        if (r2 != this.mGpsAndNetwork.getSwitch()) goto L10;
        setLocationProviderEnabled(r3);
        this.mAgps.getSwitch().setEnabled(this.mGpsAndNetwork.isChecked());
        return;
    }

    public void com_android_settings_location_LocationSettingsActivity__onResume$___twin___() {
        super.onResume();
        updateGpsSwitchState();
        getContentResolver().registerContentObserver(Settings.Secure.getUriFor("location_providers_allowed"), true, this.mGpsObserver);
        this.mGpsAndNetwork.setOnCheckedChangeListener(this);
        this.mAgps.setOnCheckedChangeListener(this);
    }

    public void com_android_settings_location_LocationSettingsActivity__onPause$___twin___() {
        super.onPause();
        getContentResolver().unregisterContentObserver(this.mGpsObserver);
        this.mGpsAndNetwork.setOnCheckedChangeListener(null);
        this.mAgps.setOnCheckedChangeListener(null);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_location_LocationSettingsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(LocationSettingsActivity r1) {
        com_android_settings_location_LocationSettingsActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_location_LocationSettingsActivity_com_obric_hook_lancet_PrivacyHook_onCreate(LocationSettingsActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LocationSettingsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_location_LocationSettingsActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_location_LocationSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(LocationSettingsActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_location_LocationSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_location_LocationSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(LocationSettingsActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_location_LocationSettingsActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        LocationSettingsActivity r5 = r4;
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
    public static void com_android_settings_location_LocationSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(LocationSettingsActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_location_LocationSettingsActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_location_LocationSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(LocationSettingsActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_location_LocationSettingsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_location_LocationSettingsActivity_com_obric_hook_lancet_PrivacyHook_onResume(LocationSettingsActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LocationSettingsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_location_LocationSettingsActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_location_LocationSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(LocationSettingsActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_location_LocationSettingsActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_location_LocationSettingsActivity_com_obric_hook_lancet_PrivacyHook_onPause(LocationSettingsActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LocationSettingsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_location_LocationSettingsActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_location_LocationSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(LocationSettingsActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_location_LocationSettingsActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        LocationSettingsActivity r5 = r3;
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
    public static void com_android_settings_location_LocationSettingsActivity_com_obric_hook_lancet_PrivacyHook_onStop(LocationSettingsActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LocationSettingsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_location_LocationSettingsActivity__onStop$___twin___();
    }
}
