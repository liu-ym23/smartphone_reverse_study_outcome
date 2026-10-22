package com.android.settings.privatespace;

import android.app.ActivityOptions;
import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.multiuser.Flags;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.FragmentActivity;
import com.android.internal.app.SetScreenLockDialogActivity;
import com.android.settings.R;
import com.android.settings.activityembedding.ActivityEmbeddingUtils;
import com.android.settings.activityembedding.EmbeddedDeepLinkUtils;
import com.android.settings.core.SubSettingLauncher;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.vcard.VCardConfig;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class PrivateSpaceAuthenticationActivity extends FragmentActivity {
    public static final String CUSTOM_BIOMETRIC_PROMPT_LOGO_DESCRIPTION_KEY = "custom_logo_description";
    public static final String CUSTOM_BIOMETRIC_PROMPT_LOGO_RES_ID_KEY = "custom_logo_res_id";
    public static final String EXTRA_SHOW_PRIVATE_SPACE_UNLOCKED = "extra_show_private_space_unlocked";
    private static final String TAG = "PrivateSpaceAuthCheck";
    private KeyguardManager mKeyguardManager;
    private PrivateSpaceMaintainer mPrivateSpaceMaintainer;
    private final ActivityResultLauncher<Intent> mSetDeviceLock;
    private final ActivityResultLauncher<Intent> mVerifyDeviceLock;

    static class Injector {
        Injector() {
        }

        PrivateSpaceMaintainer injectPrivateSpaceMaintainer(Context r1) {
            return PrivateSpaceMaintainer.getInstance(r1);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$TFaOdK5cPK6oYaxjPQBxc-I1kmI, reason: not valid java name */
    public static /* synthetic */ void m540$r8$lambda$TFaOdK5cPK6oYaxjPQBxcI1kmI(PrivateSpaceAuthenticationActivity r0, ActivityResult r1) {
        r0.onSetDeviceLockResult(r1);
    }

    public static /* synthetic */ void $r8$lambda$ZPtroeLyEI4lSJTwxnIXD3pa8sk(PrivateSpaceAuthenticationActivity r0, ActivityResult r1) {
        r0.onVerifyDeviceLock(r1);
    }

    public void com_android_settings_privatespace_PrivateSpaceAuthenticationActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_privatespace_PrivateSpaceAuthenticationActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_privatespace_PrivateSpaceAuthenticationActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_privatespace_PrivateSpaceAuthenticationActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_privatespace_PrivateSpaceAuthenticationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_privatespace_PrivateSpaceAuthenticationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_privatespace_PrivateSpaceAuthenticationActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_android_settings_privatespace_PrivateSpaceAuthenticationActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_privatespace_PrivateSpaceAuthenticationActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public PrivateSpaceAuthenticationActivity() {
        this.mSetDeviceLock = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new PrivateSpaceAuthenticationActivity$$ExternalSyntheticLambda0(this));
        this.mVerifyDeviceLock = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new PrivateSpaceAuthenticationActivity$$ExternalSyntheticLambda1(this));
    }

    public void com_android_settings_privatespace_PrivateSpaceAuthenticationActivity__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        Intent r0 = getIntent();
        String r1 = getString(R.string.menu_key_security);
        if (shouldShowMultiPaneDeepLink(r0) == true) goto L5;
    L8:
        this.mPrivateSpaceMaintainer = new Injector().injectPrivateSpaceMaintainer(getApplicationContext());
        if (getKeyguardManager().isDeviceSecure() == false) goto L15;
        if (r4 == null) goto L12;
        return;
    L12:
        if (this.mPrivateSpaceMaintainer.doesPrivateSpaceExist() == false) goto L14;
        unlockAndLaunchPrivateSpaceSettings(this);
        return;
    L14:
        authenticatePrivateSpaceEntry();
        return;
    L15:
        promptToSetDeviceLock();
        return;
    L5:
        if (EmbeddedDeepLinkUtils.tryStartMultiPaneDeepLink(this, r0, r1) == false) goto L8;
        finish();
    }

    private boolean shouldShowMultiPaneDeepLink(Intent r3) {
        if (ActivityEmbeddingUtils.isEmbeddingActivityEnabled(this) == true) goto L6;
        return false;
    L6:
        if (isTaskRoot() == true) goto L11;
        if ((r3.getFlags() & 268435456) != 0) goto L11;
        return false;
    L11:
        if (r3.getAction() == null) goto L14;
        return true;
    L14:
        return false;
    }

    public void onLockAuthentication(Context r2) {
        if (this.mPrivateSpaceMaintainer.doesPrivateSpaceExist() == false) goto L5;
        unlockAndLaunchPrivateSpaceSettings(r2);
        return;
    L5:
        finish();
    }

    public void setPrivateSpaceMaintainer(Injector r1) {
        this.mPrivateSpaceMaintainer = r1.injectPrivateSpaceMaintainer(this);
    }

    private void promptToSetDeviceLock() {
        OLog.d(TAG, "Show prompt to set device lock before using private space feature");
        startActivity(SetScreenLockDialogActivity.createBaseIntent(2));
        finish();
    }

    private KeyguardManager getKeyguardManager() {
        if (this.mKeyguardManager != null) goto L6;
        this.mKeyguardManager = (KeyguardManager) getSystemService(KeyguardManager.class);
    L6:
        return this.mKeyguardManager;
    }

    private void onSetDeviceLockResult(ActivityResult r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (getKeyguardManager().isDeviceSecure() == false) goto L6;
        onLockAuthentication(this);
        return;
    L6:
        finish();
    }

    private void onVerifyDeviceLock(ActivityResult r2) {
        if (r2 != null) goto L4;
    L6:
        finish();
        return;
    L4:
        if (r2.getResultCode() != (-1)) goto L6;
        onLockAuthentication(this);
    }

    private void unlockAndLaunchPrivateSpaceSettings(Context r6) {
        SubSettingLauncher r0 = new SubSettingLauncher(r6).setDestination(PrivateSpaceDashboardFragment.class.getName()).setTransitionType(1).setSourceMetricsCategory(2040);
        if (this.mPrivateSpaceMaintainer.isPrivateSpaceLocked() == true) goto L5;
        OLog.i(TAG, "Launch private space settings");
        r0.launch();
    L10:
        finish();
        return;
    L5:
        if (Build.VERSION.SDK_INT < 34) goto L7;
        ActivityOptions r2 = ActivityOptions.makeBasic().setPendingIntentCreatorBackgroundActivityStartMode(1);
    L8:
        this.mPrivateSpaceMaintainer.unlockPrivateSpace(PendingIntent.getActivity(r6, 0, r0.toIntent().putExtra(EXTRA_SHOW_PRIVATE_SPACE_UNLOCKED, true), VCardConfig.FLAG_APPEND_TYPE_PARAM, r2.toBundle()).getIntentSender());
        goto L10
    L7:
        r2 = null;
        goto L8
    }

    private void authenticatePrivateSpaceEntry() {
        Intent r0 = this.mPrivateSpaceMaintainer.getPrivateProfileLockCredentialIntent();
        if (r0 != null) goto L5;
        OLog.e(TAG, "verifyCredentialIntent is null even though device lock is set");
        finish();
        return;
    L5:
        if (Flags.usePrivateSpaceIconInBiometricPrompt() == false) goto L7;
        r0.putExtra("custom_logo_res_id", 17305211);
        r0.putExtra("custom_logo_description", getApplicationContext().getString(android.R.string.serviceClassData));
    L7:
        this.mVerifyDeviceLock.launch(r0);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_privatespace_PrivateSpaceAuthenticationActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(PrivateSpaceAuthenticationActivity r1) {
        r1.com_android_settings_privatespace_PrivateSpaceAuthenticationActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_privatespace_PrivateSpaceAuthenticationActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(PrivateSpaceAuthenticationActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_privatespace_PrivateSpaceAuthenticationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_privatespace_PrivateSpaceAuthenticationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(PrivateSpaceAuthenticationActivity r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_privatespace_PrivateSpaceAuthenticationActivity__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        PrivateSpaceAuthenticationActivity r5 = r4;
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
    public static void com_android_settings_privatespace_PrivateSpaceAuthenticationActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(PrivateSpaceAuthenticationActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_privatespace_PrivateSpaceAuthenticationActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_privatespace_PrivateSpaceAuthenticationActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(PrivateSpaceAuthenticationActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_privatespace_PrivateSpaceAuthenticationActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_privatespace_PrivateSpaceAuthenticationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(PrivateSpaceAuthenticationActivity r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_privatespace_PrivateSpaceAuthenticationActivity__onPause$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_privatespace_PrivateSpaceAuthenticationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(PrivateSpaceAuthenticationActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        r3.com_android_settings_privatespace_PrivateSpaceAuthenticationActivity__onCreate$___twin___(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        PrivateSpaceAuthenticationActivity r5 = r3;
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
}
