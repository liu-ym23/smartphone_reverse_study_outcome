package com.android.settings;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.os.UserHandle;
import android.util.Log;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import com.obric.privacy.LifeHookActivity2;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class TetherProvisioningActivity extends LifeHookActivity2 {
    private static final boolean DEBUG = false;
    private static final String EXTRA_TETHER_TYPE = "TETHER_TYPE";
    private static final int PROVISION_REQUEST = 0;
    private static final String TAG = "TetherProvisioningAct";
    private ResultReceiver mResultReceiver;

    public void com_android_settings_TetherProvisioningActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_TetherProvisioningActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_TetherProvisioningActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_TetherProvisioningActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_TetherProvisioningActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_TetherProvisioningActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_TetherProvisioningActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_TetherProvisioningActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_TetherProvisioningActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public TetherProvisioningActivity() {
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    public void com_android_settings_TetherProvisioningActivity__onCreate$___twin___(Bundle r7) {
        super.onCreate(r7);
        Utils.setTranslucentStatusAndNavigation(getApplicationContext(), getWindow());
        this.mResultReceiver = (ResultReceiver) getIntent().getParcelableExtra("extraProvisionCallback");
        int r8 = getIntent().getIntExtra("extraAddTetherType", -1);
        String[] r0 = getResources().getStringArray(android.R.array.config_priorityOnlyDndExemptPackages);
        Intent r1 = new Intent("android.intent.action.MAIN");
        r1.setClassName(r0[0], r0[1]);
        r1.putExtra(EXTRA_TETHER_TYPE, r8);
        if (DEBUG == false) goto L6;
        OLog.d(TAG, "Starting provisioning app: " + r0[0] + "." + r0[1]);
    L6:
        if (getPackageManager().queryIntentActivities(r1, 65536).isEmpty() == false) goto L9;
        OLog.e(TAG, "Provisioning app is configured, but not available.");
        this.mResultReceiver.send(11, null);
        finish();
        return;
    L9:
        startActivityForResultAsUser(r1, 0, UserHandle.CURRENT);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        if (r1 == 0) goto L5;
        return;
    L5:
        if (DEBUG == false) goto L8;
        OLog.d(TAG, "Got result from app: " + r2);
    L8:
        if (r2 != (-1)) goto L10;
        int r4 = 0;
    L11:
        this.mResultReceiver.send(r4, null);
        finish();
        return;
    L10:
        r4 = 11;
        goto L11
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_TetherProvisioningActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(TetherProvisioningActivity r1) {
        com_android_settings_TetherProvisioningActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_TetherProvisioningActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(TetherProvisioningActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        TetherProvisioningActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_TetherProvisioningActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_TetherProvisioningActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(TetherProvisioningActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_TetherProvisioningActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_TetherProvisioningActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(TetherProvisioningActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_TetherProvisioningActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        TetherProvisioningActivity r5 = r4;
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
    public static void com_android_settings_TetherProvisioningActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(TetherProvisioningActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_TetherProvisioningActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_TetherProvisioningActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(TetherProvisioningActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_TetherProvisioningActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_TetherProvisioningActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(TetherProvisioningActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        TetherProvisioningActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_TetherProvisioningActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_TetherProvisioningActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(TetherProvisioningActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_TetherProvisioningActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_TetherProvisioningActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(TetherProvisioningActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        TetherProvisioningActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_TetherProvisioningActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_TetherProvisioningActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(TetherProvisioningActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_TetherProvisioningActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        TetherProvisioningActivity r5 = r3;
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
    public static void com_android_settings_TetherProvisioningActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(TetherProvisioningActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        TetherProvisioningActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_TetherProvisioningActivity__onStop$___twin___();
    }
}
