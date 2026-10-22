package com.android.settings.wifi;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserManager;
import android.provider.Settings;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.android.settings.R;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sremlib.LibUtil;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import com.obric.privacy.LifeHookActivity2;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class WifiScanModeActivity extends LifeHookActivity2 {
    private String mApp;
    private DialogFragment mDialog;

    public static class AlertDialogFragment extends DialogFragment {
        private final String mApp;

        public void com_android_settings_wifi_WifiScanModeActivity$AlertDialogFragment__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_wifi_WifiScanModeActivity$AlertDialogFragment__onResume$___twin___() {
            super.onResume();
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_wifi_WifiScanModeActivity$AlertDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_wifi_WifiScanModeActivity$AlertDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        static AlertDialogFragment newInstance(String r1) {
            return new AlertDialogFragment(r1);
        }

        public AlertDialogFragment(String r1) {
            this.mApp = r1;
        }

        public AlertDialogFragment() {
            this.mApp = null;
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle r4) {
            return new AlertDialog.Builder(getActivity()).setMessage(getString(R.string.wifi_scan_always_turnon_message, new Object[]{this.mApp})).setPositiveButton(R.string.wifi_scan_always_confirm_allow, new AnonymousClass2(this)).setNegativeButton(R.string.wifi_scan_always_confirm_deny, new AnonymousClass1(this)).create();
        }

        @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface r1) {
            FragmentActivity r0 = getActivity();
            if (r0 == null) goto L6;
            WifiScanModeActivity.access$000((WifiScanModeActivity) r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_wifi_WifiScanModeActivity$AlertDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AlertDialogFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_wifi_WifiScanModeActivity$AlertDialogFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_wifi_WifiScanModeActivity$AlertDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AlertDialogFragment r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_wifi_WifiScanModeActivity$AlertDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_wifi_WifiScanModeActivity$AlertDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AlertDialogFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_wifi_WifiScanModeActivity$AlertDialogFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    public void com_android_settings_wifi_WifiScanModeActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_wifi_WifiScanModeActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_wifi_WifiScanModeActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_wifi_WifiScanModeActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_wifi_WifiScanModeActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_wifi_WifiScanModeActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_wifi_WifiScanModeActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public WifiScanModeActivity() {
    }

    static /* synthetic */ void access$000(WifiScanModeActivity r0) {
        r0.doNegativeClick();
    }

    static /* synthetic */ void access$100(WifiScanModeActivity r0) {
        r0.doPositiveClick();
    }

    public void com_android_settings_wifi_WifiScanModeActivity__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        com.android.settings.Utils.setTranslucentStatusAndNavigation(getApplicationContext(), getWindow());
        getWindow().addSystemFlags(524288);
        Intent r0 = getIntent();
        if (r3 != null) goto L14;
        if (r0 != null) goto L6;
    L12:
        finish();
        return;
    L6:
        if ("android.net.wifi.action.REQUEST_SCAN_ALWAYS_AVAILABLE".equals(r0.getAction()) == false) goto L12;
        this.mApp = getCallingPackage();
        PackageManager r4 = getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L21
        if (r4 == null) goto L16;
        this.mApp = (String) r4.getApplicationLabel(r4.getApplicationInfo(this.mApp, 0));     // Catch: PackageManager.NameNotFoundException -> L21
    L16:
        if (isWifiScanModeConfigAllowed(getApplicationContext()) == true) goto L19;
        OLog.e("WifiScanModeActivity", "This user is not allowed to configure Wi-Fi Scan Mode!");
        finish();
        return;
    L19:
        createDialog();
        return;
    L14:
        this.mApp = r3.getString(LibUtil.EXCEPTION_APPLICATION);
        goto L16
    }

    private void createDialog() {
        if (this.mDialog != null) goto L6;
        AlertDialogFragment r0 = AlertDialogFragment.newInstance(this.mApp);
        this.mDialog = r0;
        r0.show(getSupportFragmentManager(), "dialog");
        return;
    }

    private static boolean isWifiScanModeConfigAllowed(Context r2) {
        UserManager r3 = (UserManager) r2.getSystemService(UserManager.class);
        if (r3 != null) goto L6;
        return true;
    L6:
        return !r3.hasUserRestriction("no_config_location");
    }

    private void dismissDialog() {
        DialogFragment r0 = this.mDialog;
        if (r0 == null) goto L6;
        r0.dismissAllowingStateLoss();
        this.mDialog = null;
        return;
    }

    private void doPositiveClick() {
        Settings.Global.putInt(getContentResolver(), "wifi_scan_always_enabled", 1);
        setResult(-1);
        finish();
    }

    private void doNegativeClick() {
        setResult(0);
        finish();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle r2) {
        super.onSaveInstanceState(r2);
        r2.putString(LibUtil.EXCEPTION_APPLICATION, this.mApp);
    }

    public void com_android_settings_wifi_WifiScanModeActivity__onPause$___twin___() {
        super.onPause();
        dismissDialog();
    }

    public void com_android_settings_wifi_WifiScanModeActivity__onResume$___twin___() {
        super.onResume();
        createDialog();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_wifi_WifiScanModeActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(WifiScanModeActivity r1) {
        com_android_settings_wifi_WifiScanModeActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_wifi_WifiScanModeActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(WifiScanModeActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        WifiScanModeActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_wifi_WifiScanModeActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_WifiScanModeActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(WifiScanModeActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_wifi_WifiScanModeActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_WifiScanModeActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(WifiScanModeActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_wifi_WifiScanModeActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        WifiScanModeActivity r5 = r4;
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
    public static void com_android_settings_wifi_WifiScanModeActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(WifiScanModeActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_wifi_WifiScanModeActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_wifi_WifiScanModeActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(WifiScanModeActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_wifi_WifiScanModeActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_wifi_WifiScanModeActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(WifiScanModeActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        WifiScanModeActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_wifi_WifiScanModeActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_wifi_WifiScanModeActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(WifiScanModeActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_wifi_WifiScanModeActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_wifi_WifiScanModeActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(WifiScanModeActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        WifiScanModeActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_wifi_WifiScanModeActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_wifi_WifiScanModeActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(WifiScanModeActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_wifi_WifiScanModeActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        WifiScanModeActivity r5 = r3;
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
    public static void com_android_settings_wifi_WifiScanModeActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(WifiScanModeActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        WifiScanModeActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_wifi_WifiScanModeActivity__onStop$___twin___();
    }
}
