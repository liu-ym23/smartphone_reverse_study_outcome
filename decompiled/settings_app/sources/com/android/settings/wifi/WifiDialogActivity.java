package com.android.settings.wifi;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import com.GlobalProxyLancet;
import com.android.settings.SetupWizardUtils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.setupwizardlib.util.WizardManagerHelper;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import com.obric.privacy.LifeHookActivity2;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class WifiDialogActivity extends LifeHookActivity2 implements WifiDialog.WifiDialogListener, DialogInterface.OnDismissListener {
    private static final String KEY_ACCESS_POINT_STATE = "access_point_state";
    private static final String KEY_WIFI_CONFIGURATION = "wifi_configuration";
    private static final int RESULT_CONNECTED = 1;
    private static final int RESULT_FORGET = 2;
    private static final String TAG = "WifiDialogActivity";

    public void com_android_settings_wifi_WifiDialogActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_wifi_WifiDialogActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_wifi_WifiDialogActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_wifi_WifiDialogActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // android.app.Activity
    public void finish() {
        com_android_settings_wifi_WifiDialogActivity_com_obric_hook_lancet_PrivacyHookActivity2_finish(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_wifi_WifiDialogActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_wifi_WifiDialogActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_wifi_WifiDialogActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_wifi_WifiDialogActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_wifi_WifiDialogActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public WifiDialogActivity() {
    }

    public void com_android_settings_wifi_WifiDialogActivity__onCreate$___twin___(Bundle r3) {
        com.android.settings.Utils.setTranslucentStatusAndNavigation(getApplicationContext(), getWindow());
        Intent r0 = getIntent();
        if (WizardManagerHelper.isSetupWizardIntent(r0) == false) goto L5;
        setTheme(SetupWizardUtils.getTransparentTheme(r0));
    L5:
        super.onCreate(r3);
        Bundle r4 = GlobalProxyLancet.com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(r0, KEY_ACCESS_POINT_STATE);
        if (r4 == null) goto L8;
        AccessPoint r1 = new AccessPoint(this, r4);
    L9:
        WifiDialog r5 = new WifiDialog(this, this, r1, 1);
        r5.show();
        r5.setOnDismissListener(this);
        return;
    L8:
        r1 = null;
        goto L9
    }

    public void com_android_settings_wifi_WifiDialogActivity__finish$___twin___() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // com.android.settings.wifi.WifiDialog.WifiDialogListener
    public void onForget(WifiDialog r3) {
        WifiManager r0 = (WifiManager) getSystemService(WifiManager.class);
        AccessPoint r4 = r3.getController().getAccessPoint();
        Intent r1 = new Intent();
        if (r4 == null) goto L5;
        Bundle r2 = new Bundle();
        r4.saveWifiState(r2);
        r1.putExtra(KEY_ACCESS_POINT_STATE, r2);
    L5:
        setResult(2);
        finish();
    }

    @Override // com.android.settings.wifi.WifiDialog.WifiDialogListener
    public void onSubmit(WifiDialog r5) {
        WifiConfiguration r0 = r5.getController().getConfig();
        AccessPoint r6 = r5.getController().getAccessPoint();
        WifiManager r1 = (WifiManager) getSystemService(WifiManager.class);
        if (r0 != null) goto L8;
        if (r6 != null) goto L6;
    L11:
        Intent r2 = new Intent();
        if (r6 == null) goto L14;
        Bundle r3 = new Bundle();
        r6.saveWifiState(r3);
        r2.putExtra(KEY_ACCESS_POINT_STATE, r3);
    L14:
        if (r0 == null) goto L16;
        r2.putExtra(KEY_WIFI_CONFIGURATION, r0);
    L16:
        setResult(1, r2);
        finish();
        return;
    L6:
        if (r6.isSaved() == false) goto L11;
        r1.connect(r6.getConfig(), null);
        goto L11
    L8:
        r1.save(r0, null);
        if (r6 == null) goto L11;
        r1.connect(r0, null);
        goto L11
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r1) {
        finish();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_wifi_WifiDialogActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(WifiDialogActivity r1) {
        com_android_settings_wifi_WifiDialogActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_wifi_WifiDialogActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(WifiDialogActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        WifiDialogActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_wifi_WifiDialogActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_WifiDialogActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(WifiDialogActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_wifi_WifiDialogActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_WifiDialogActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(WifiDialogActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_wifi_WifiDialogActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        WifiDialogActivity r5 = r4;
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
    public static void com_android_settings_wifi_WifiDialogActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(WifiDialogActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_wifi_WifiDialogActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_wifi_WifiDialogActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(WifiDialogActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_wifi_WifiDialogActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_wifi_WifiDialogActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(WifiDialogActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        WifiDialogActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_wifi_WifiDialogActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_wifi_WifiDialogActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(WifiDialogActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_wifi_WifiDialogActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_wifi_WifiDialogActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(WifiDialogActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        WifiDialogActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_wifi_WifiDialogActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_wifi_WifiDialogActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(WifiDialogActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_wifi_WifiDialogActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        WifiDialogActivity r5 = r3;
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
    public static void com_android_settings_wifi_WifiDialogActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(WifiDialogActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        WifiDialogActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_wifi_WifiDialogActivity__onStop$___twin___();
    }

    @Insert("finish")
    public static void com_android_settings_wifi_WifiDialogActivity_com_obric_hook_lancet_PrivacyHookActivity2_finish(WifiDialogActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        WifiDialogActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.superFinish();
        return;
    L6:
        r3.com_android_settings_wifi_WifiDialogActivity__finish$___twin___();
    }
}
