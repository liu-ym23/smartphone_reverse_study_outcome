package com.android.settings.applications;

import android.app.ActivityManagerNative;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.android.settings.MainSettings;
import com.android.settings.R;
import com.android.settings.base.BaseActivity;
import com.android.settings.fuelgauge.appBatteryUseOptimization.AppBatteryUseOptimizationControlFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class InstalledAppDetailsActivity extends MainSettings {
    private InstalledAppDetails mInstalledAppDetails;

    public void com_android_settings_applications_InstalledAppDetailsActivity__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_applications_InstalledAppDetailsActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_applications_InstalledAppDetailsActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_applications_InstalledAppDetailsActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_applications_InstalledAppDetailsActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.MainSettings, com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_applications_InstalledAppDetailsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // com.android.settings.MainSettings, androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent r1) {
        com_android_settings_applications_InstalledAppDetailsActivity_com_obric_hook_lancet_PrivacyHook_onNewIntent(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_applications_InstalledAppDetailsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_applications_InstalledAppDetailsActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_applications_InstalledAppDetailsActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_applications_InstalledAppDetailsActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public InstalledAppDetailsActivity() {
    }

    @Override // com.android.settings.MainSettings, com.android.settings.base.BaseActivity
    public <T extends Fragment> T getBindFragment() {
        InstalledAppDetails r0 = new InstalledAppDetails();
        this.mInstalledAppDetails = r0;
        r0.setArguments(getIntent().getExtras());
        Bundle r1 = getIntent().getExtras();
        if (r1 == null) goto L5;
        String r2 = r1.getString("open_power_usage");
    L6:
        if (r2 == null) goto L18;
        if (r2.equals("true") == false) goto L18;
        int r3 = getAppPackageUid();
        if (r3 != (-1)) goto L12;
        r3 = getOriginatingUid();
    L12:
        Intent r4 = getIntent();
        r4.putExtra("title_id", R.string.battery_manager_title);
        r4.putExtra("back_text_id", R.string.application_info_label);
        if (r4.getData() == null) goto L15;
        r4.putExtra("package_name", r4.getData().getSchemeSpecificPart());
    L15:
        r4.putExtra(BaseActivity.EXTRA_FROM_SECURITY, this.mFromSecurityCenter);
        r4.putExtra("application_uid", r3);
        AppBatteryUseOptimizationControlFragment r5 = new AppBatteryUseOptimizationControlFragment();
        r5.setArguments(r4.getExtras());
        return r5;
    L18:
        return this.mInstalledAppDetails;
    L5:
        r2 = null;
        goto L6
    }

    public void com_android_settings_applications_InstalledAppDetailsActivity__onNewIntent$___twin___(Intent r3) {
        super.onNewIntent(r3);
        if (r3.getData() == null) goto L5;
        getIntent().setData(r3.getData());
    L5:
        this.mInstalledAppDetails.updateArgs(r3.getExtras());
    }

    private int getAppPackageUid() {
        Bundle r2 = getIntent().getExtras();
        if (r2 == null) goto L10;
        return r2.getInt(InstalledAppDetails.ARG_APP_UID, -1);
    L11:
        return -1;
    L10:
        return -1;
    }

    private int getOriginatingUid() {
        return ActivityManagerNative.getDefault().getLaunchedFromUid(this.mActivity.getActivityToken());
    L4:
        return -1;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_applications_InstalledAppDetailsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(InstalledAppDetailsActivity r1) {
        com_android_settings_applications_InstalledAppDetailsActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_applications_InstalledAppDetailsActivity_com_obric_hook_lancet_PrivacyHook_onCreate(InstalledAppDetailsActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        InstalledAppDetailsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_applications_InstalledAppDetailsActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_InstalledAppDetailsActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(InstalledAppDetailsActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_applications_InstalledAppDetailsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_InstalledAppDetailsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(InstalledAppDetailsActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_applications_InstalledAppDetailsActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        InstalledAppDetailsActivity r5 = r4;
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
    public static void com_android_settings_applications_InstalledAppDetailsActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(InstalledAppDetailsActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_applications_InstalledAppDetailsActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_applications_InstalledAppDetailsActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(InstalledAppDetailsActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_applications_InstalledAppDetailsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_applications_InstalledAppDetailsActivity_com_obric_hook_lancet_PrivacyHook_onResume(InstalledAppDetailsActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        InstalledAppDetailsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_applications_InstalledAppDetailsActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_applications_InstalledAppDetailsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(InstalledAppDetailsActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_applications_InstalledAppDetailsActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_applications_InstalledAppDetailsActivity_com_obric_hook_lancet_PrivacyHook_onPause(InstalledAppDetailsActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        InstalledAppDetailsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_applications_InstalledAppDetailsActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_InstalledAppDetailsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(InstalledAppDetailsActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_applications_InstalledAppDetailsActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        InstalledAppDetailsActivity r5 = r3;
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
    public static void com_android_settings_applications_InstalledAppDetailsActivity_com_obric_hook_lancet_PrivacyHook_onStop(InstalledAppDetailsActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        InstalledAppDetailsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_applications_InstalledAppDetailsActivity__onStop$___twin___();
    }

    @Insert("onNewIntent")
    public static void com_android_settings_applications_InstalledAppDetailsActivity_com_obric_hook_lancet_PrivacyHook_onNewIntent(InstalledAppDetailsActivity r3, Intent r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        InstalledAppDetailsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onNewIntentWhenPrivacyNotOk(null);
        r0.superOnNewIntent(r4);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_applications_InstalledAppDetailsActivity__onNewIntent$___twin___(r4);
    }
}
