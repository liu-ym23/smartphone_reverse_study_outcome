package com.android.settings;

import android.app.admin.DevicePolicyManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ModifyOrFindPassword extends BaseActivity implements View.OnClickListener {
    protected static final String CONFIRM_APP_LOCK_PASSWORD = "confirm_app_lock_password";
    private static final int REQUEST_CONFIRM_APP_LOCK = 101;
    private DevicePolicyManager mDPM;
    private int mTitleStringResId;

    public void com_android_settings_ModifyOrFindPassword__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_ModifyOrFindPassword__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_ModifyOrFindPassword__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_ModifyOrFindPassword_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_ModifyOrFindPassword_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_ModifyOrFindPassword_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_ModifyOrFindPassword_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_ModifyOrFindPassword_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public ModifyOrFindPassword() {
    }

    public void com_android_settings_ModifyOrFindPassword__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        if (AppLockUtil.isLocked(this) == true) goto L6;
        finish();
        return;
    L6:
        setContentView(R.layout.modify_or_find_password);
        findViewById(R.id.item_modify_pwd).setOnClickListener(this);
        findViewById(R.id.item_find_pwd).setOnClickListener(this);
        this.mDPM = (DevicePolicyManager) getSystemService("device_policy");
        this.mTitleStringResId = R.string.security_item_applications_lock;
        setupBackBtnOnTitle();
    }

    public void com_android_settings_ModifyOrFindPassword__onResume$___twin___() {
        super.onResume();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        int r3 = r2.getId();
        if (r3 != R.id.item_find_pwd) goto L5;
        gotoFindPassword();
        return;
    L5:
        if (r3 != R.id.item_modify_pwd) goto L11;
        gotoModifyAppLock();
        return;
    }

    private void gotoModifyAppLock() {
        LockScreenFragment.gotoChooseEasyPassword(this, this.mDPM, 4, this.mTitleStringResId, false);
    }

    private void gotoFindPassword() {
        Intent r0 = new Intent(this, FindingPasswordActivity.class);
        r0.putExtra("back_text_id", this.mTitleStringResId);
        r0.putExtra("isFindingPassword", true);
        startActivity(r0);
    }

    private void gotoConfirmAppLockPassword() {
        Intent r0 = new Intent();
        r0.setClassName(this, ConfirmLockPassword.class.getName());
        r0.putExtra(CONFIRM_APP_LOCK_PASSWORD, true);
        r0.putExtra("lockscreen.password_type", 131072);
        startActivityForResult(r0, 101);
    }

    private void gotoFindPasswordQuestionSettings() {
        Intent r0 = new Intent();
        r0.setClass(this, FindPasswordQuestionSettingsActivity.class);
        startActivity(r0);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        if (r1 == 101) goto L5;
        return;
    L5:
        if (r2 != (-1)) goto L9;
        gotoFindPasswordQuestionSettings();
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_ModifyOrFindPassword_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ModifyOrFindPassword r1) {
        com_android_settings_ModifyOrFindPassword_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_ModifyOrFindPassword_com_obric_hook_lancet_PrivacyHook_onCreate(ModifyOrFindPassword r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ModifyOrFindPassword r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_ModifyOrFindPassword__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ModifyOrFindPassword_com_obric_hook_lancet_BatchedActivityLancet_onResume(ModifyOrFindPassword r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_ModifyOrFindPassword_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ModifyOrFindPassword_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(ModifyOrFindPassword r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_ModifyOrFindPassword_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        ModifyOrFindPassword r5 = r4;
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
    public static void com_android_settings_ModifyOrFindPassword_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(ModifyOrFindPassword r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_ModifyOrFindPassword__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_ModifyOrFindPassword_com_obric_hook_lancet_BatchedActivityLancet_onStop(ModifyOrFindPassword r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_ModifyOrFindPassword_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_ModifyOrFindPassword_com_obric_hook_lancet_PrivacyHook_onResume(ModifyOrFindPassword r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ModifyOrFindPassword r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_ModifyOrFindPassword__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_ModifyOrFindPassword_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(ModifyOrFindPassword r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_ModifyOrFindPassword_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_ModifyOrFindPassword_com_obric_hook_lancet_PrivacyHook_onPause(ModifyOrFindPassword r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ModifyOrFindPassword r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_ModifyOrFindPassword__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_ModifyOrFindPassword_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(ModifyOrFindPassword r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_ModifyOrFindPassword_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        ModifyOrFindPassword r5 = r3;
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
    public static void com_android_settings_ModifyOrFindPassword_com_obric_hook_lancet_PrivacyHook_onStop(ModifyOrFindPassword r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ModifyOrFindPassword r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_ModifyOrFindPassword__onStop$___twin___();
    }
}
