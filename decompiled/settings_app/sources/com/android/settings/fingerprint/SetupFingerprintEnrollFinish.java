package com.android.settings.fingerprint;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.android.settings.R;
import com.android.settings.SetupWizardUtils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.setupwizardlib.view.NavigationBar;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class SetupFingerprintEnrollFinish extends FingerprintEnrollFinish implements NavigationBar.NavigationBarListener {
    public void com_android_settings_fingerprint_SetupFingerprintEnrollFinish__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_fingerprint_SetupFingerprintEnrollFinish__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_fingerprint_SetupFingerprintEnrollFinish__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_fingerprint_SetupFingerprintEnrollFinish__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_fingerprint_SetupFingerprintEnrollFinish__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.fingerprint.FingerprintEnrollFinish, com.android.settings.fingerprint.FingerprintEnrollBase, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_fingerprint_SetupFingerprintEnrollFinish_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_fingerprint_SetupFingerprintEnrollFinish_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_fingerprint_SetupFingerprintEnrollFinish_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_fingerprint_SetupFingerprintEnrollFinish_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_fingerprint_SetupFingerprintEnrollFinish_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public SetupFingerprintEnrollFinish() {
    }

    @Override // com.android.settings.fingerprint.FingerprintEnrollBase
    protected Intent getEnrollingIntent() {
        Intent r0 = new Intent(this, SetupFingerprintEnrollEnrolling.class);
        r0.putExtra("hw_auth_token", this.mToken);
        if (this.mUserId == (-10000)) goto L5;
        r0.putExtra("android.intent.extra.USER_ID", this.mUserId);
    L5:
        SetupWizardUtils.copySetupExtras(getIntent(), r0);
        return r0;
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper
    protected void onApplyThemeResource(Resources.Theme r1, int r2, boolean r3) {
        super.onApplyThemeResource(r1, SetupWizardUtils.getTheme(getIntent()), r3);
    }

    @Override // com.android.settings.fingerprint.FingerprintEnrollBase
    protected void initViews() {
        SetupWizardUtils.setImmersiveMode(this);
        View r0 = findViewById(R.id.next_button);
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        NavigationBar r1 = getNavigationBar();
        if (r1 == null) goto L8;
        r1.setNavigationBarListener(this);
        r1.getBackButton().setVisibility(8);
    L8:
        ((TextView) findViewById(R.id.message)).setText(R.string.setup_fingerprint_enroll_finish_message);
        ((TextView) findViewById(R.id.message_secondary)).setVisibility(0);
    }

    @Override // com.android.settings.fingerprint.FingerprintEnrollBase
    protected Button getNextButton() {
        return getNavigationBar().getNextButton();
    }

    @Override // com.android.setupwizardlib.view.NavigationBar.NavigationBarListener
    public void onNavigateBack() {
        onBackPressed();
    }

    @Override // com.android.setupwizardlib.view.NavigationBar.NavigationBarListener
    public void onNavigateNext() {
        onNextButtonClick();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_fingerprint_SetupFingerprintEnrollFinish_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(SetupFingerprintEnrollFinish r1) {
        com_android_settings_fingerprint_SetupFingerprintEnrollFinish_com_obric_hook_lancet_PrivacyHookActivity2_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_fingerprint_SetupFingerprintEnrollFinish_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(SetupFingerprintEnrollFinish r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        SetupFingerprintEnrollFinish r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_fingerprint_SetupFingerprintEnrollFinish__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fingerprint_SetupFingerprintEnrollFinish_com_obric_hook_lancet_BatchedActivityLancet_onResume(SetupFingerprintEnrollFinish r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_fingerprint_SetupFingerprintEnrollFinish_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fingerprint_SetupFingerprintEnrollFinish_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(SetupFingerprintEnrollFinish r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_fingerprint_SetupFingerprintEnrollFinish_com_obric_hook_lancet_PrivacyHookActivity2_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        SetupFingerprintEnrollFinish r5 = r4;
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
    public static void com_android_settings_fingerprint_SetupFingerprintEnrollFinish_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(SetupFingerprintEnrollFinish r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_fingerprint_SetupFingerprintEnrollFinish__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_fingerprint_SetupFingerprintEnrollFinish_com_obric_hook_lancet_BatchedActivityLancet_onStop(SetupFingerprintEnrollFinish r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_fingerprint_SetupFingerprintEnrollFinish_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_fingerprint_SetupFingerprintEnrollFinish_com_obric_hook_lancet_PrivacyHookActivity2_onResume(SetupFingerprintEnrollFinish r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        SetupFingerprintEnrollFinish r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_fingerprint_SetupFingerprintEnrollFinish__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_fingerprint_SetupFingerprintEnrollFinish_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(SetupFingerprintEnrollFinish r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_fingerprint_SetupFingerprintEnrollFinish_com_obric_hook_lancet_PrivacyHookActivity2_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_fingerprint_SetupFingerprintEnrollFinish_com_obric_hook_lancet_PrivacyHookActivity2_onPause(SetupFingerprintEnrollFinish r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        SetupFingerprintEnrollFinish r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_fingerprint_SetupFingerprintEnrollFinish__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_fingerprint_SetupFingerprintEnrollFinish_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(SetupFingerprintEnrollFinish r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_fingerprint_SetupFingerprintEnrollFinish_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        SetupFingerprintEnrollFinish r5 = r3;
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
    public static void com_android_settings_fingerprint_SetupFingerprintEnrollFinish_com_obric_hook_lancet_PrivacyHookActivity2_onStop(SetupFingerprintEnrollFinish r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        SetupFingerprintEnrollFinish r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_fingerprint_SetupFingerprintEnrollFinish__onStop$___twin___();
    }
}
