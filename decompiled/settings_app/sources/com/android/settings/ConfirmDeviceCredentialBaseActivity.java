package com.android.settings;

import android.app.KeyguardManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserManager;
import android.view.MenuItem;
import androidx.fragment.app.Fragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ConfirmDeviceCredentialBaseActivity extends SettingsActivity {
    private static final String STATE_IS_KEYGUARD_LOCKED = "STATE_IS_KEYGUARD_LOCKED";
    private boolean mDark;
    private boolean mEnterAnimationPending;
    private boolean mFirstTimeVisible;
    private boolean mIsKeyguardLocked;
    private boolean mRestoring;

    public void com_android_settings_ConfirmDeviceCredentialBaseActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_ConfirmDeviceCredentialBaseActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_ConfirmDeviceCredentialBaseActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.SettingsActivity, com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_ConfirmDeviceCredentialBaseActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_ConfirmDeviceCredentialBaseActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_ConfirmDeviceCredentialBaseActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.SettingsActivity, com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_ConfirmDeviceCredentialBaseActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_ConfirmDeviceCredentialBaseActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public ConfirmDeviceCredentialBaseActivity() {
        this.mFirstTimeVisible = true;
        this.mIsKeyguardLocked = false;
    }

    public void com_android_settings_ConfirmDeviceCredentialBaseActivity__onCreate$___twin___(Bundle r5) {
        boolean r1 = true;
        if (Utils.isManagedProfile(UserManager.get(this), Utils.getCredentialOwnerUserId(this, Utils.getUserIdFromBundle(this, getIntent().getExtras()))) == false) goto L6;
        setTheme(R.style.Theme_ConfirmDeviceCredentialsWork);
    L8:
        super.onCreate(r5);
        if (r5 != null) goto L11;
        boolean r0 = ((KeyguardManager) getSystemService(KeyguardManager.class)).isKeyguardLocked();
    L12:
        this.mIsKeyguardLocked = r0;
        if (r0 == true) goto L15;
    L17:
        setTitle((CharSequence) NullSafe.nonNull(getIntent().getStringExtra(ConfirmDeviceCredentialBaseFragment.TITLE_TEXT)));
        if (getActionBar() == null) goto L20;
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
    L20:
        if (r5 != null) goto L23;
        r1 = false;
    L23:
        this.mRestoring = r1;
        return;
    L15:
        if (getIntent().getBooleanExtra(ConfirmDeviceCredentialBaseFragment.SHOW_WHEN_LOCKED, false) == false) goto L17;
        getWindow().addFlags(524288);
        goto L17
    L11:
        r0 = r5.getBoolean(STATE_IS_KEYGUARD_LOCKED, false);
        goto L12
    L6:
        if (getIntent().getBooleanExtra(ConfirmDeviceCredentialBaseFragment.DARK_THEME, false) == false) goto L8;
        setTheme(R.style.Theme_ConfirmDeviceCredentialsDark);
        this.mDark = true;
        goto L8
    }

    @Override // com.android.settings.SettingsActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle r2) {
        super.onSaveInstanceState(r2);
        r2.putBoolean(STATE_IS_KEYGUARD_LOCKED, this.mIsKeyguardLocked);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem r3) {
        if (r3.getItemId() != 16908332) goto L7;
        finish();
        return true;
    L7:
        return super.onOptionsItemSelected(r3);
    }

    public void com_android_settings_ConfirmDeviceCredentialBaseActivity__onResume$___twin___() {
        super.onResume();
        if (isChangingConfigurations() == false) goto L5;
        return;
    L5:
        if (this.mRestoring == false) goto L7;
        return;
    L7:
        if (this.mDark == true) goto L9;
        return;
    L9:
        if (this.mFirstTimeVisible == false) goto L15;
        this.mFirstTimeVisible = false;
        prepareEnterAnimation();
        this.mEnterAnimationPending = true;
        return;
    }

    private ConfirmDeviceCredentialBaseFragment getFragment() {
        Fragment r1 = getSupportFragmentManager().findFragmentById(R.id.main_content);
        if (r1 != null) goto L5;
        return null;
    L5:
        if ((r1 instanceof ConfirmDeviceCredentialBaseFragment) == true) goto L7;
        return null;
    L7:
        return (ConfirmDeviceCredentialBaseFragment) r1;
    }

    @Override // android.app.Activity
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();
        if (this.mEnterAnimationPending == false) goto L6;
        startEnterAnimation();
        this.mEnterAnimationPending = false;
        return;
    }

    public void prepareEnterAnimation() {
        getFragment().prepareEnterAnimation();
    }

    public void startEnterAnimation() {
        getFragment().startEnterAnimation();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_ConfirmDeviceCredentialBaseActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ConfirmDeviceCredentialBaseActivity r1) {
        com_android_settings_ConfirmDeviceCredentialBaseActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_ConfirmDeviceCredentialBaseActivity_com_obric_hook_lancet_PrivacyHook_onCreate(ConfirmDeviceCredentialBaseActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ConfirmDeviceCredentialBaseActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_ConfirmDeviceCredentialBaseActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ConfirmDeviceCredentialBaseActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(ConfirmDeviceCredentialBaseActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_ConfirmDeviceCredentialBaseActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ConfirmDeviceCredentialBaseActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(ConfirmDeviceCredentialBaseActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_ConfirmDeviceCredentialBaseActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        ConfirmDeviceCredentialBaseActivity r5 = r4;
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
    public static void com_android_settings_ConfirmDeviceCredentialBaseActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(ConfirmDeviceCredentialBaseActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_ConfirmDeviceCredentialBaseActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_ConfirmDeviceCredentialBaseActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(ConfirmDeviceCredentialBaseActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_ConfirmDeviceCredentialBaseActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_ConfirmDeviceCredentialBaseActivity_com_obric_hook_lancet_PrivacyHook_onResume(ConfirmDeviceCredentialBaseActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ConfirmDeviceCredentialBaseActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_ConfirmDeviceCredentialBaseActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_ConfirmDeviceCredentialBaseActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(ConfirmDeviceCredentialBaseActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_ConfirmDeviceCredentialBaseActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_ConfirmDeviceCredentialBaseActivity_com_obric_hook_lancet_PrivacyHook_onPause(ConfirmDeviceCredentialBaseActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ConfirmDeviceCredentialBaseActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_ConfirmDeviceCredentialBaseActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_ConfirmDeviceCredentialBaseActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(ConfirmDeviceCredentialBaseActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_ConfirmDeviceCredentialBaseActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        ConfirmDeviceCredentialBaseActivity r5 = r3;
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
    public static void com_android_settings_ConfirmDeviceCredentialBaseActivity_com_obric_hook_lancet_PrivacyHook_onStop(ConfirmDeviceCredentialBaseActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ConfirmDeviceCredentialBaseActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_ConfirmDeviceCredentialBaseActivity__onStop$___twin___();
    }
}
