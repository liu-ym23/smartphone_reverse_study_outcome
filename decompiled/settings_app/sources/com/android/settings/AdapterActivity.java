package com.android.settings;

import android.app.admin.DevicePolicyManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserHandle;
import com.android.internal.widget.LockPatternUtils;
import com.android.settings.base.BaseActivity;
import com.android.settings.fingerprint.BaseFingerprintEnrollingActivity;
import com.android.settings.fingerprint.FingerprintEnrollWizardActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.wifi.TrustedNetworkHelper;
import com.android.vcard.VCardConfig;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class AdapterActivity extends BaseActivity {
    public static final String EXTRA_ACTIVITY = "extra_activity";
    public static final String EXTRA_ALLOW_FINGERPRINT = "allow_fingerprint";
    public static final String EXTRA_SOURCE = "extra_source";
    public static final String EXTRA_TARGET = "extra_target";
    public static final int REQUEST_VERIFY_PASSWORD = 1;
    public static final String TARGET_CREATE_PASSWORD = "create_password";
    public static final String TARGET_SETUP_FINGERPRINT = "setup_fingerprint";
    public static final String TARGET_START_SETTINGS_ACTIVITY = "start_settings_activity";
    public static final String TARGET_VERIFY_PASSWORD = "verify_password";
    private static boolean isWalletVerifyPassword;
    private DevicePolicyManager mDPM;
    private boolean mIsFromTPassword;
    private LockPatternUtils mLockPatternUtils;

    public void com_android_settings_AdapterActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_AdapterActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_AdapterActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_AdapterActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_AdapterActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_settings_AdapterActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_AdapterActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_AdapterActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_AdapterActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_AdapterActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public AdapterActivity() {
    }

    public void com_android_settings_AdapterActivity__onCreate$___twin___(Bundle r7) {
        super.onCreate(r7);
        this.mDPM = (DevicePolicyManager) getSystemService("device_policy");
        this.mLockPatternUtils = new LockPatternUtils(this);
        Intent r8 = getIntent();
        String r0 = r8.getStringExtra(EXTRA_TARGET);
        String r1 = r8.getStringExtra(EXTRA_SOURCE);
        OLog.d(this.TAG, "source: " + r1 + ", target = " + r0);
        if ("com.bytedanceos.tpassword".equals(r1) == false) goto L5;
        this.mIsFromTPassword = true;
        r8.putExtra(BaseActivity.EXTRA_FROM_SECURITY, true);
    L5:
        int r4 = 0;
        if (TARGET_CREATE_PASSWORD.equals(r0) == false) goto L9;
        int r9 = r8.getIntExtra("extra_password_quality", 0);
        OLog.d(this.TAG, "quality: " + r9);
        launchCreatePassword(r9);
        finish();
        return;
    L9:
        if (TARGET_SETUP_FINGERPRINT.equals(r0) == false) goto L18;
        if (this.mLockPatternUtils.isSecure(UserHandle.myUserId()) == true) goto L13;
    L15:
        launchFingerprintSetupWizard();
    L16:
        finish();
        return;
    L13:
        if (this.mIsFromTPassword == true) goto L15;
        launchFingerprintEnrolling();
        goto L16
    L18:
        if (TARGET_VERIFY_PASSWORD.equals(r0) == false) goto L29;
        if ("com.bytedanceos.wallet".equals(r1) == false) goto L22;
        isWalletVerifyPassword = true;
    L22:
        ChooseLockSettingsHelper r2 = new ChooseLockSettingsHelper(this);
        if (r8.getBooleanExtra(EXTRA_ALLOW_FINGERPRINT, false) == false) goto L25;
        boolean r10 = r2.launchConfirmationActivity(1, null, 2);
    L26:
        if (r10 == true) goto L49;
        setResult(0);
        finish();
        return;
    L49:
        return;
    L25:
        r10 = r2.launchConfirmationActivity(1, null, true, 2);
        goto L26
    L29:
        if (TARGET_START_SETTINGS_ACTIVITY.equals(r0) == false) goto L51;
        String r3 = r8.getStringExtra(EXTRA_ACTIVITY);
        OLog.d(this.TAG, "activityName " + r3);
        Intent r5 = new Intent();
        r5.setComponent(new ComponentName(getPackageName(), r3));
        r5.putExtra(Constants.EXTRA_OUTER, true);
        if (r8.hasExtra(NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME) == false) goto L34;
        r5.putExtra(NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME, r8.getStringExtra(NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME));
    L34:
        if (r8.hasExtra(NotificationDisplayDetailsActivity.EXTRA_APP_UID) == false) goto L37;
        r5.putExtra(NotificationDisplayDetailsActivity.EXTRA_APP_UID, r8.getIntExtra(NotificationDisplayDetailsActivity.EXTRA_APP_UID, 0));
    L37:
        if (r8.hasExtra("bytedanceos.intent.extra.ANIM_RESOURCE_ID") == false) goto L45;
        r5.putExtra("bytedanceos.intent.extra.ANIM_RESOURCE_ID", r8.getIntArrayExtra("bytedanceos.intent.extra.ANIM_RESOURCE_ID"));
        r8.removeExtra("bytedanceos.intent.extra.ANIM_RESOURCE_ID");
    L45:
        startActivity(r5);     // Catch: ActivityNotFoundException -> L41
        r4 = -1;
    L43:
        setResult(r4);
        finish();
        return;
    L41:
        e = move-exception;
        e.printStackTrace();
        goto L43
    }

    private void launchCreatePassword(int r8) {
        if (r8 < 131072) goto L12;
        int r0 = this.mDPM.getPasswordMinimumLength(null);
        if (r0 >= 4) goto L7;
        r0 = 4;
    L7:
        int r2 = this.mDPM.getPasswordMaximumLength(r8);
        Intent r3 = new Intent().setClass(this, ChooseLockPassword.class);
        OLog.d(this.TAG, "updateUnlockMethodAndFinish  quality:" + r8);
        r3.putExtra("lockscreen.password_type", r8);
        r3.putExtra(ChooseLockPassword.PASSWORD_MIN_KEY, r0);
        r3.putExtra(ChooseLockPassword.PASSWORD_MAX_KEY, r2);
        r3.putExtra(ChooseLockPassword.EXTRA_PIN_LENGTH, getIntent().getIntExtra(ChooseLockPassword.EXTRA_PIN_LENGTH, 4));
        FingerprintManager r9 = (FingerprintManager) getSystemService(FingerprintManager.class);
        if (r9 == null) goto L10;
        r9.isHardwareDetected();
    L10:
        r3.putExtra(ChooseLockSettingsHelper.EXTRA_KEY_HAS_CHALLENGE, true);
        r3.putExtra(TrustedNetworkHelper.EXTRA_REQUEST_RESULT, true);
        r3.putExtra(ChooseLockGeneric.CONFIRM_CREDENTIALS, this.mLockPatternUtils.isSecure(UserHandle.myUserId()));
        r3.addFlags(VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING);
        r3.putExtras(getIntent().getExtras());
        Utils.startActivity(this, r3, 2);
        return;
    }

    private void launchFingerprintSetupWizard() {
        Intent r0 = new Intent(this, FingerprintEnrollWizardActivity.class);
        r0.putExtras(getIntent().getExtras());
        r0.addFlags(VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING);
        Utils.startActivity(this, r0, 2);
    }

    private void launchFingerprintEnrolling() {
        Intent r0 = BaseFingerprintEnrollingActivity.launchFingerprintEnrollingActivity(this);
        OLog.i(this.TAG, "launchFingerprintEnrolling EXTRA_KEY_CHALLENGE_TOKEN: no token");
        r0.putExtras(getIntent().getExtras());
        r0.addFlags(VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING);
        Utils.startActivity(this, r0, 2);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        if (r2 != 1) goto L8;
        if (r4 != null) goto L6;
        r4 = new Intent(getIntent());
    L6:
        r4.putExtras(getIntent());
        setResult(r3, r4);
        finish();
        return;
    }

    public static boolean isWalletVerifyPassword() {
        return isWalletVerifyPassword;
    }

    public void com_android_settings_AdapterActivity__onDestroy$___twin___() {
        super.onDestroy();
        isWalletVerifyPassword = false;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_AdapterActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(AdapterActivity r1) {
        com_android_settings_AdapterActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_AdapterActivity_com_obric_hook_lancet_PrivacyHook_onCreate(AdapterActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        AdapterActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_AdapterActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_AdapterActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(AdapterActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_AdapterActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_AdapterActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(AdapterActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_AdapterActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        AdapterActivity r5 = r4;
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
    public static void com_android_settings_AdapterActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(AdapterActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_AdapterActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_AdapterActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(AdapterActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_AdapterActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_AdapterActivity_com_obric_hook_lancet_PrivacyHook_onResume(AdapterActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        AdapterActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_AdapterActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_AdapterActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(AdapterActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_AdapterActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_AdapterActivity_com_obric_hook_lancet_PrivacyHook_onPause(AdapterActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        AdapterActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_AdapterActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_AdapterActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(AdapterActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_AdapterActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        AdapterActivity r5 = r3;
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
    public static void com_android_settings_AdapterActivity_com_obric_hook_lancet_PrivacyHook_onStop(AdapterActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        AdapterActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_AdapterActivity__onStop$___twin___();
    }

    @Insert("onDestroy")
    public static void com_android_settings_AdapterActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(AdapterActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        AdapterActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_AdapterActivity__onDestroy$___twin___();
    }
}
