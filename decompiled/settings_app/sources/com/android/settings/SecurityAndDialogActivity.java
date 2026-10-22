package com.android.settings;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class SecurityAndDialogActivity extends BaseActivity {
    public static final int CONFIRM_EXISTING_REQUEST = 32767;
    public static final int RESULT_LOCALE_CHANGED = 10;
    private static final String TAG = "SecurityAndDialogActivity";
    private OAlertDialog mConfirmDialog;
    protected boolean mPasswordConfirmed;

    static /* synthetic */ void lambda$showConfirmDialog$1(DialogInterface r0, int r1) {
    }

    public void com_android_settings_SecurityAndDialogActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_SecurityAndDialogActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_SecurityAndDialogActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_SecurityAndDialogActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_SecurityAndDialogActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com_android_settings_SecurityAndDialogActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_SecurityAndDialogActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_SecurityAndDialogActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_SecurityAndDialogActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_SecurityAndDialogActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public SecurityAndDialogActivity() {
    }

    public void com_android_settings_SecurityAndDialogActivity__onCreate$___twin___(Bundle r5) {
        super.onCreate(r5);
        this.mPasswordConfirmed = getIntent().getBooleanExtra("password_confirmed", false);
        OLog.d(TAG, "mPasswordConfirmed " + this.mPasswordConfirmed);
        if (this.mPasswordConfirmed == false) goto L5;
    L7:
        showConfirmDialog();
        return;
    L5:
        if (new ChooseLockSettingsHelper(this).launchConfirmationActivity(32767, null, true, 2) == true) goto L7;
        this.mPasswordConfirmed = true;
        goto L7
    }

    private void showConfirmDialog() {
        OAlertDialog r0 = this.mConfirmDialog;
        if (r0 != null) goto L5;
    L7:
        OAlertDialog r1 = (OAlertDialog) new OAlertDialogBuilder(this).horizontalButton(true).title(R.string.dialog_title_alert).message(R.string.reset_oaid_desc).positiveButton(R.string.ok, new SecurityAndDialogActivity$$ExternalSyntheticLambda0(this)).negativeButton(R.string.cancel, new SecurityAndDialogActivity$$ExternalSyntheticLambda1()).onDismiss(new SecurityAndDialogActivity$$ExternalSyntheticLambda2(this)).build();
        this.mConfirmDialog = r1;
        r1.show();
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
    }

    /* JADX INFO: renamed from: lambda$showConfirmDialog$0$com-android-settings-SecurityAndDialogActivity, reason: not valid java name */
    /* synthetic */ void m200x2abe35b8(DialogInterface r1, int r2) {
        Utils.resetOaid(getApplicationContext());
    }

    /* JADX INFO: renamed from: lambda$showConfirmDialog$2$com-android-settings-SecurityAndDialogActivity, reason: not valid java name */
    /* synthetic */ void m201x9e537976(DialogInterface r1) {
        this.mConfirmDialog = null;
        finish();
    }

    public void com_android_settings_SecurityAndDialogActivity__onDestroy$___twin___() {
        if (getIntent().getBooleanExtra("password_confirmed", false) == true) goto L5;
        BaseActivity.sIsUserEnterPasswordSettings = false;
    L5:
        OAlertDialog r0 = this.mConfirmDialog;
        if (r0 != null) goto L8;
    L10:
        super.onDestroy();
        return;
    L8:
        if (r0.isShowing() == false) goto L10;
        this.mConfirmDialog.dismiss();
        goto L10
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        if (r1 == 32767) goto L5;
        return;
    L5:
        if (r2 != (-1)) goto L8;
        this.mPasswordConfirmed = true;
        BaseActivity.sIsUserEnterPasswordSettings = true;
        registerUserLeavePasswordSettingsIfNeeded();
        return;
    L8:
        if (r2 == 10) goto L14;
        setResult(0);
        getIntent().removeExtra("bytedanceos.intent.extra.ANIM_RESOURCE_ID");
        finish();
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_SecurityAndDialogActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(SecurityAndDialogActivity r1) {
        com_android_settings_SecurityAndDialogActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_SecurityAndDialogActivity_com_obric_hook_lancet_PrivacyHook_onCreate(SecurityAndDialogActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        SecurityAndDialogActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_SecurityAndDialogActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_SecurityAndDialogActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(SecurityAndDialogActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_SecurityAndDialogActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_SecurityAndDialogActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(SecurityAndDialogActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_SecurityAndDialogActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        SecurityAndDialogActivity r5 = r4;
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
    public static void com_android_settings_SecurityAndDialogActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(SecurityAndDialogActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_SecurityAndDialogActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_SecurityAndDialogActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(SecurityAndDialogActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_SecurityAndDialogActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_SecurityAndDialogActivity_com_obric_hook_lancet_PrivacyHook_onResume(SecurityAndDialogActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        SecurityAndDialogActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_SecurityAndDialogActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_SecurityAndDialogActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(SecurityAndDialogActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_SecurityAndDialogActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_SecurityAndDialogActivity_com_obric_hook_lancet_PrivacyHook_onPause(SecurityAndDialogActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        SecurityAndDialogActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_SecurityAndDialogActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_SecurityAndDialogActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(SecurityAndDialogActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_SecurityAndDialogActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        SecurityAndDialogActivity r5 = r3;
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
    public static void com_android_settings_SecurityAndDialogActivity_com_obric_hook_lancet_PrivacyHook_onStop(SecurityAndDialogActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        SecurityAndDialogActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_SecurityAndDialogActivity__onStop$___twin___();
    }

    @Insert("onDestroy")
    public static void com_android_settings_SecurityAndDialogActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(SecurityAndDialogActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        SecurityAndDialogActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_SecurityAndDialogActivity__onDestroy$___twin___();
    }
}
