package com.android.settings;

import android.app.PendingIntent;
import android.app.admin.DevicePolicyManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.vcard.VCardConfig;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class LockScreenModeListActivity extends BaseActivity implements View.OnClickListener {
    private static final boolean ALWAY_SHOW_TUTORIAL = true;
    private static final String CONFIRM_CREDENTIALS = "confirm_credentials";
    private static final int CONFIRM_EXISTING_REQUEST = 100;
    public static final String EXTRA_SHOW_FRAGMENT_TITLE = ":android:show_fragment_title";
    private static final int FALLBACK_REQUEST = 101;
    public static final String MINIMUM_QUALITY_KEY = "minimum_quality";
    private static final int MIN_PASSWORD_LENGTH = 4;
    private static final String PASSWORD_CONFIRMED = "password_confirmed";
    private static final String WAITING_FOR_CONFIRMATION = "waiting_for_confirmation";
    private ChooseLockSettingsHelper mChooseLockSettingsHelper;
    private DevicePolicyManager mDPM;
    private SettingItemText mItemModeNone;
    private SettingItemText mItemModePasswordEasy;
    private SettingItemText mItemModePasswordHard;
    private SettingItemText mItemModePattern;
    private LinearLayout mLinearLayout;
    private boolean mPasswordConfirmed;
    private boolean mWaitingForConfirmation;

    private boolean allowedForFallback(int r1) {
        if (R.id.item_mode_pattern != r1) goto L5;
        return true;
    L5:
        return false;
    }

    private int upgradeQualityForKeyStore(int r1) {
        return r1;
    }

    public void com_android_settings_LockScreenModeListActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_LockScreenModeListActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_LockScreenModeListActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_LockScreenModeListActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_LockScreenModeListActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_LockScreenModeListActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_LockScreenModeListActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_LockScreenModeListActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public LockScreenModeListActivity() {
        this.mPasswordConfirmed = false;
        this.mWaitingForConfirmation = false;
    }

    public void com_android_settings_LockScreenModeListActivity__onCreate$___twin___(Bundle r5) {
        super.onCreate(r5);
        setContentView(R.layout.lock_screen_mode_settings_layout);
        this.mLinearLayout = (LinearLayout) findViewById(R.id.mode_list);
        SettingItemText r0 = (SettingItemText) findViewById(R.id.item_mode_none);
        this.mItemModeNone = r0;
        r0.setOnClickListener(this);
        SettingItemText r1 = (SettingItemText) findViewById(R.id.item_mode_password_easy);
        this.mItemModePasswordEasy = r1;
        r1.setOnClickListener(this);
        SettingItemText r2 = (SettingItemText) findViewById(R.id.item_mode_password_hard);
        this.mItemModePasswordHard = r2;
        r2.setOnClickListener(this);
        SettingItemText r3 = (SettingItemText) findViewById(R.id.item_mode_pattern);
        this.mItemModePattern = r3;
        r3.setOnClickListener(this);
        this.mPasswordConfirmed = !getIntent().getBooleanExtra("confirm_credentials", true);
        if (r5 == null) goto L6;
        this.mPasswordConfirmed = r5.getBoolean("password_confirmed");
        this.mWaitingForConfirmation = r5.getBoolean(WAITING_FOR_CONFIRMATION);
    L6:
        if (this.mPasswordConfirmed == false) goto L9;
        updatePreferencesOrFinish();
    L14:
        this.mDPM = (DevicePolicyManager) getSystemService("device_policy");
        this.mBackView = this.mTitle.addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, null);
        this.mBackView.setOnClickListener(new AnonymousClass1(this));
        return;
    L9:
        if (this.mWaitingForConfirmation == true) goto L14;
        if (new ChooseLockSettingsHelper(this).launchConfirmationActivity(100, null, 2) == true) goto L13;
        this.mPasswordConfirmed = true;
        updatePreferencesOrFinish();
        goto L14
    L13:
        this.mWaitingForConfirmation = true;
        goto L14
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle r3) {
        super.onSaveInstanceState(r3);
        r3.putBoolean("password_confirmed", this.mPasswordConfirmed);
        r3.putBoolean(WAITING_FOR_CONFIRMATION, this.mWaitingForConfirmation);
    }

    public void com_android_settings_LockScreenModeListActivity__onResume$___twin___() {
        super.onResume();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        if (this.mItemModeNone != r3) goto L6;
        updateUnlockMethodAndFinish(0, false);
        return;
    L6:
        if (this.mItemModePasswordEasy != r3) goto L9;
        updateUnlockMethodAndFinish(262144, false);
        return;
    L9:
        if (this.mItemModePasswordHard != r3) goto L12;
        updateUnlockMethodAndFinish(393216, false);
        return;
    L12:
        if (this.mItemModePattern != r3) goto L18;
        updateUnlockMethodAndFinish(65536, false);
        return;
    }

    void updateUnlockMethodAndFinish(int r4, boolean r5) {
        if (this.mPasswordConfirmed == false) goto L16;
        int r6 = upgradeQuality(r4);
        if (r6 < 131072) goto L11;
        int r7 = this.mDPM.getPasswordMinimumLength(null);
        if (r7 >= 4) goto L9;
        r7 = 4;
    L9:
        int r0 = this.mDPM.getPasswordMaximumLength(r6);
        Intent r1 = new Intent().setClass(this, ChooseLockPassword.class);
        r1.putExtra("lockscreen.password_type", r6);
        r1.putExtra(ChooseLockPassword.PASSWORD_MIN_KEY, r7);
        r1.putExtra(ChooseLockPassword.PASSWORD_MAX_KEY, r0);
        r1.putExtra("confirm_credentials", false);
        r1.addFlags(VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING);
        startActivity(r1);
    L13:
        finish();
        return;
    L11:
        if (r6 != 32768) goto L13;
        startActivity(getBiometricSensorIntent());
        goto L13
    L16:
        throw new IllegalStateException("Tried to update password without confirming it");
    }

    private void updatePreferencesOrFinish() {
        Intent r0 = getIntent();
        int r1 = r0.getIntExtra("lockscreen.password_type", -1);
        if (r1 != (-1)) goto L5;
        disableUnusablePreferences(upgradeQuality(r0.getIntExtra("minimum_quality", -1)));
        return;
    L5:
        updateUnlockMethodAndFinish(r1, false);
    }

    private Intent getBiometricSensorIntent() {
        Intent r0 = new Intent().setClass(this, ChooseLockGeneric.class);
        r0.putExtra("confirm_credentials", false);
        Intent r1 = new Intent();
        r1.setClassName("com.android.facelock", "com.android.facelock.SetupIntro");
        r1.putExtra("PendingIntent", PendingIntent.getActivity(this, 0, r0, 201326592));
        return r1;
    }

    private void disableUnusablePreferences(int r7) {
        int r0 = this.mLinearLayout.getChildCount() - 1;
    L3:
        if (r0 < 0) goto L29;
        View r2 = this.mLinearLayout.getChildAt(r0);
        if ((r2 instanceof SettingItemText) == false) goto L28;
        SettingItemText r3 = (SettingItemText) r2;
        int r4 = r3.getId();
        if (R.id.item_mode_none != r4) goto L12;
        if (r7 <= 0) goto L25;
    L10:
        boolean r5 = false;
    L26:
        if (r5 == true) goto L28;
        r3.setSubTitle(getString(R.string.unlock_set_unlock_disabled_summary));
        r3.setEnabled(false);
    L25:
        r5 = true;
        goto L26
    L12:
        if (R.id.item_mode_pattern != r4) goto L17;
        if (r7 > 65536) goto L10;
    L17:
        if (R.id.item_mode_password_easy != r4) goto L22;
        if (r7 > 262144) goto L10;
    L22:
        if (R.id.item_mode_password_hard != r4) goto L25;
        if (r7 > 393216) goto L10;
    L28:
        r0 = r0 - 1;
        goto L3
    }

    private int upgradeQuality(int r2) {
        int r3 = upgradeQualityForKeyStore(upgradeQualityForDPM(r2));
        int r1 = upgradeQualityForEncryption(r3);
        if (r1 > r3) goto L5;
    L7:
        return r1;
    L5:
        if (r3 != 32768) goto L7;
        return r3;
    }

    private int upgradeQualityForDPM(int r2) {
        int r1 = this.mDPM.getPasswordQuality(null);
        if (r2 < r1) goto L5;
        return r2;
    L5:
        return r1;
    }

    private int upgradeQualityForEncryption(int r2) {
        int r1 = this.mDPM.getStorageEncryptionStatus();
        if (r1 != 3) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L11;
        return r2;
    L11:
        if (r2 < 131072) goto L13;
        return r2;
    L13:
        return 131072;
    L5:
        if (r1 == 2) goto L8;
        r3 = false;
        goto L9
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        this.mWaitingForConfirmation = false;
        if (r1 == 100) goto L5;
        return;
    L5:
        if (r2 != (-1)) goto L9;
        this.mPasswordConfirmed = true;
        updatePreferencesOrFinish();
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_LockScreenModeListActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(LockScreenModeListActivity r1) {
        com_android_settings_LockScreenModeListActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_LockScreenModeListActivity_com_obric_hook_lancet_PrivacyHook_onCreate(LockScreenModeListActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LockScreenModeListActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_LockScreenModeListActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_LockScreenModeListActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(LockScreenModeListActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_LockScreenModeListActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_LockScreenModeListActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(LockScreenModeListActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_LockScreenModeListActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        LockScreenModeListActivity r5 = r4;
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
    public static void com_android_settings_LockScreenModeListActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(LockScreenModeListActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_LockScreenModeListActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_LockScreenModeListActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(LockScreenModeListActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_LockScreenModeListActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_LockScreenModeListActivity_com_obric_hook_lancet_PrivacyHook_onResume(LockScreenModeListActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LockScreenModeListActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_LockScreenModeListActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_LockScreenModeListActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(LockScreenModeListActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_LockScreenModeListActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_LockScreenModeListActivity_com_obric_hook_lancet_PrivacyHook_onPause(LockScreenModeListActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LockScreenModeListActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_LockScreenModeListActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_LockScreenModeListActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(LockScreenModeListActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_LockScreenModeListActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        LockScreenModeListActivity r5 = r3;
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
    public static void com_android_settings_LockScreenModeListActivity_com_obric_hook_lancet_PrivacyHook_onStop(LockScreenModeListActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LockScreenModeListActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_LockScreenModeListActivity__onStop$___twin___();
    }
}
