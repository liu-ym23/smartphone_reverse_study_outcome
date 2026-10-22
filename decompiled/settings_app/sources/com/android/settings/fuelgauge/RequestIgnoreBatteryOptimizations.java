package com.android.settings.fuelgauge;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.IDeviceIdleController;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.view.View;
import com.android.settings.R;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.privacy.GrantUtil;
import com.obric.privacy.LifeHookActivity2;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class RequestIgnoreBatteryOptimizations extends LifeHookActivity2 implements DialogInterface.OnClickListener {
    private static final String DEVICE_IDLE_SERVICE = "deviceidle";
    static final String TAG = "RequestIgnoreBatteryOptimizations";
    IDeviceIdleController mDeviceIdleService;
    String mPackageName;
    private OAlertDialog mWarningDialog;

    public static /* synthetic */ void $r8$lambda$eytHQji2oG4MFSsh5Im_fFGh6_8(RequestIgnoreBatteryOptimizations r0) {
        r0.finish();
    }

    public void com_android_settings_fuelgauge_RequestIgnoreBatteryOptimizations__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_fuelgauge_RequestIgnoreBatteryOptimizations__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_fuelgauge_RequestIgnoreBatteryOptimizations__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_fuelgauge_RequestIgnoreBatteryOptimizations__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r1, int r2) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_fuelgauge_RequestIgnoreBatteryOptimizations_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_fuelgauge_RequestIgnoreBatteryOptimizations_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_fuelgauge_RequestIgnoreBatteryOptimizations_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_fuelgauge_RequestIgnoreBatteryOptimizations_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_fuelgauge_RequestIgnoreBatteryOptimizations_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public RequestIgnoreBatteryOptimizations() {
    }

    public void com_android_settings_fuelgauge_RequestIgnoreBatteryOptimizations__onCreate$___twin___(Bundle r6) {
        super.onCreate(r6);
        this.mDeviceIdleService = IDeviceIdleController.Stub.asInterface(ServiceManager.getService(DEVICE_IDLE_SERVICE));
        Uri r7 = getIntent().getData();
        if (r7 != null) goto L6;
        OLog.w(TAG, "No data supplied for IGNORE_BATTERY_OPTIMIZATION_SETTINGS in: " + getIntent());
        finish();
        return;
    L6:
        String r8 = r7.getSchemeSpecificPart();
        this.mPackageName = r8;
        if (r8 != null) goto L11;
        OLog.w(TAG, "No data supplied for IGNORE_BATTERY_OPTIMIZATION_SETTINGS in: " + getIntent());
        finish();
        return;
    L11:
        if (((PowerManager) getSystemService(PowerManager.class)).isIgnoringBatteryOptimizations(this.mPackageName) == false) goto L23;
        OLog.i(TAG, "Not should prompt, already ignoring optimizations: " + this.mPackageName);
        finish();
        return;
    L23:
        ApplicationInfo r9 = getPackageManager().getApplicationInfo(this.mPackageName, 0);     // Catch: PackageManager.NameNotFoundException -> L21
        if (getPackageManager().checkPermission("android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS", this.mPackageName) == 0) goto L19;
        OLog.w(TAG, "Requested package " + this.mPackageName + " does not hold permission android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
        finish();
        return;
    L19:
        OAlertDialog r10 = (OAlertDialog) new OAlertDialogBuilder(this).autoDismiss(false).horizontalButton(true).title(getText(R.string.battery_optimization_title), false).message(getString(R.string.battery_optimization_message, new Object[]{r9.loadLabel(getPackageManager())})).negativeButton(R.string.battery_optimization_cancel, new RequestIgnoreBatteryOptimizations$$ExternalSyntheticLambda1(this)).positiveButton(R.string.battery_optimization_confirm, new RequestIgnoreBatteryOptimizations$$ExternalSyntheticLambda2(this)).onCancel(new RequestIgnoreBatteryOptimizations$$ExternalSyntheticLambda3(this)).createDialog();
        this.mWarningDialog = r10;
        r10.show();
        return;
    L21:
        OLog.w(TAG, "Requested package doesn't exist: " + this.mPackageName);
        finish();
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$com-android-settings-fuelgauge-RequestIgnoreBatteryOptimizations, reason: not valid java name */
    /* synthetic */ void m475x8d9450f0(DialogInterface r1, int r2) {
        dismissDialog();
    }

    /* JADX INFO: renamed from: lambda$onCreate$1$com-android-settings-fuelgauge-RequestIgnoreBatteryOptimizations, reason: not valid java name */
    /* synthetic */ void m476xf7c3d90f(DialogInterface r2, int r3) {
        this.mDeviceIdleService.addPowerSaveWhitelistApp(this.mPackageName);     // Catch: RemoteException -> L4
    L6:
        setResult(-1);
        dismissDialog();
        return;
    L4:
        e = move-exception;
        OLog.w(TAG, "Unable to reach IDeviceIdleController", e);
        goto L6
    }

    /* JADX INFO: renamed from: lambda$onCreate$2$com-android-settings-fuelgauge-RequestIgnoreBatteryOptimizations, reason: not valid java name */
    /* synthetic */ void m477x61f3612e(DialogInterface r1) {
        dismissDialog();
    }

    private void dismissDialog() {
        OAlertDialog r3 = this.mWarningDialog;     // Catch: Throwable -> L8 Exception -> L10
        if (r3 == null) goto L6;
        r3.dismiss();     // Catch: Throwable -> L8 Exception -> L10
        this.mWarningDialog = null;     // Catch: Throwable -> L8 Exception -> L10
    L6:
        View r0 = getWindow().getDecorView();
        Runnable r4 = new RequestIgnoreBatteryOptimizations$$ExternalSyntheticLambda0(this);
    L7:
        r0.postDelayed(r4, 250);
        return;
    L10:
        e = move-exception;
        OLog.e(TAG, "dismissDialog error, error = " + e);     // Catch: Throwable -> L8
        r0 = getWindow().getDecorView();
        r4 = new RequestIgnoreBatteryOptimizations$$ExternalSyntheticLambda0(this);
    L8:
        th = move-exception;
        getWindow().getDecorView().postDelayed(new RequestIgnoreBatteryOptimizations$$ExternalSyntheticLambda0(this), 250);
        throw th;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_fuelgauge_RequestIgnoreBatteryOptimizations_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(RequestIgnoreBatteryOptimizations r1) {
        com_android_settings_fuelgauge_RequestIgnoreBatteryOptimizations_com_obric_hook_lancet_PrivacyHookActivity2_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_fuelgauge_RequestIgnoreBatteryOptimizations_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(RequestIgnoreBatteryOptimizations r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        RequestIgnoreBatteryOptimizations r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_fuelgauge_RequestIgnoreBatteryOptimizations__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fuelgauge_RequestIgnoreBatteryOptimizations_com_obric_hook_lancet_BatchedActivityLancet_onResume(RequestIgnoreBatteryOptimizations r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_fuelgauge_RequestIgnoreBatteryOptimizations_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fuelgauge_RequestIgnoreBatteryOptimizations_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(RequestIgnoreBatteryOptimizations r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_fuelgauge_RequestIgnoreBatteryOptimizations_com_obric_hook_lancet_PrivacyHookActivity2_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        RequestIgnoreBatteryOptimizations r5 = r4;
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
    public static void com_android_settings_fuelgauge_RequestIgnoreBatteryOptimizations_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(RequestIgnoreBatteryOptimizations r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_fuelgauge_RequestIgnoreBatteryOptimizations__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_fuelgauge_RequestIgnoreBatteryOptimizations_com_obric_hook_lancet_BatchedActivityLancet_onStop(RequestIgnoreBatteryOptimizations r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_fuelgauge_RequestIgnoreBatteryOptimizations_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_fuelgauge_RequestIgnoreBatteryOptimizations_com_obric_hook_lancet_PrivacyHookActivity2_onResume(RequestIgnoreBatteryOptimizations r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        RequestIgnoreBatteryOptimizations r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_fuelgauge_RequestIgnoreBatteryOptimizations__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_fuelgauge_RequestIgnoreBatteryOptimizations_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(RequestIgnoreBatteryOptimizations r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_fuelgauge_RequestIgnoreBatteryOptimizations_com_obric_hook_lancet_PrivacyHookActivity2_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_fuelgauge_RequestIgnoreBatteryOptimizations_com_obric_hook_lancet_PrivacyHookActivity2_onPause(RequestIgnoreBatteryOptimizations r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        RequestIgnoreBatteryOptimizations r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_fuelgauge_RequestIgnoreBatteryOptimizations__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_fuelgauge_RequestIgnoreBatteryOptimizations_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(RequestIgnoreBatteryOptimizations r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_fuelgauge_RequestIgnoreBatteryOptimizations_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        RequestIgnoreBatteryOptimizations r5 = r3;
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
    public static void com_android_settings_fuelgauge_RequestIgnoreBatteryOptimizations_com_obric_hook_lancet_PrivacyHookActivity2_onStop(RequestIgnoreBatteryOptimizations r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        RequestIgnoreBatteryOptimizations r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_fuelgauge_RequestIgnoreBatteryOptimizations__onStop$___twin___();
    }
}
