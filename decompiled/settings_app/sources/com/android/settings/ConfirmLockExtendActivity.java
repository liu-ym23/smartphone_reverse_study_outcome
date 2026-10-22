package com.android.settings;

import android.content.Intent;
import android.os.Bundle;
import com.android.internal.widget.LockscreenCredential;
import com.android.settings.base.BaseActivity;
import com.android.settings.provision.ProvisionConstants;
import com.obric.common.oea.style.scene.transition.TransitionAnimHelper;
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes2.dex */
public class ConfirmLockExtendActivity extends MainSettings {
    public static final int CONFIRM_EXISTING_REQUEST = 32767;
    public static final String PASSWORD_CONFIRMED = "password_confirmed";
    public static final int RESULT_LOCALE_CHANGED = 10;
    protected LockscreenCredential mPassword;
    protected boolean mPasswordConfirmed;
    protected boolean mSkipCheck;

    @Override // com.android.settings.base.BaseActivity, android.app.Activity
    public void finish() {
        com_android_settings_ConfirmLockExtendActivity_com_obric_hook_lancet_PrivacyHook_finish(this);
    }

    @Override // com.android.settings.MainSettings, com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_ConfirmLockExtendActivity_com_obric_hook_lancet_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_settings_ConfirmLockExtendActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_ConfirmLockExtendActivity_com_obric_hook_lancet_PrivacyHook_onResume(this);
    }

    public ConfirmLockExtendActivity() {
        this.mPasswordConfirmed = false;
        this.mPassword = null;
        this.mSkipCheck = false;
    }

    public void com_android_settings_ConfirmLockExtendActivity__onCreate$___twin___(Bundle r5) {
        super.onCreate(r5);
        if (this.mSkipCheck == false) goto L5;
        return;
    L5:
        Intent r0 = getIntent();
        if (r0 != null) goto L8;
    L12:
        if (r5 == null) goto L16;
        LockscreenCredential r6 = r5.getParcelable("password");
        this.mPassword = r6;
        if (r6 == null) goto L16;
        this.mPasswordConfirmed = true;
    L16:
        this.mSetupWizardMode = Utils.getBooleanExtraSafely(getIntent(), ProvisionConstants.EXTRA_SETUPWIZARD, false);
        return;
    L8:
        if (r0.hasExtra("password") == false) goto L12;
        LockscreenCredential r1 = r0.getParcelableExtra("password");
        this.mPassword = r1;
        if (r1 == null) goto L12;
        this.mPasswordConfirmed = true;
        goto L12
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle r2) {
        super.onSaveInstanceState(r2);
        LockscreenCredential r1 = this.mPassword;
        if (r1 == null) goto L7;
        if (r2 == null) goto L8;
        r2.putParcelable("password", r1);
        return;
    L8:
        return;
    }

    public ChooseLockSettingsHelper getChooseLockSettingsHelper() {
        return new ChooseLockSettingsHelper(this, new AnonymousClass1(this));
    }

    @Override // com.android.settings.base.BaseActivity
    public void onCustomActivityResult(int r4, int r5, Intent r6) {
        super.onCustomActivityResult(r4, r5, r6);
        boolean r1 = false;
        if (r5 != 0) goto L7;
        setResult(0);
        getIntent().removeExtra("bytedanceos.intent.extra.ANIM_RESOURCE_ID");
        finish();
        return;
    L7:
        if (r4 == 32767) goto L9;
        return;
    L9:
        if (r5 != (-1)) goto L24;
        if (r6 == null) goto L21;
        if (r6.hasExtra("password") == false) goto L21;
        LockscreenCredential r7 = r6.getParcelableExtra("password");
        this.mPassword = r7;
        if (r7 != null) goto L17;
    L19:
        this.mPasswordConfirmed = r1;
        goto L21
    L17:
        if (r7.isNone() == true) goto L19;
        r1 = true;
    L21:
        if (BaseActivity.sIsUserEnterPasswordSettings == true) goto L29;
        registerUserLeavePasswordSettingsIfNeeded();
        BaseActivity.sIsUserEnterPasswordSettings = true;
        return;
    L29:
        return;
    L24:
        if (r5 == 10) goto L31;
        setResult(0);
        getIntent().removeExtra("bytedanceos.intent.extra.ANIM_RESOURCE_ID");
        finish();
        return;
    }

    public void com_android_settings_ConfirmLockExtendActivity__onResume$___twin___() {
        super.onResume();
        OLog.d(this.TAG, "mPasswordConfirmed " + this.mPasswordConfirmed);
        if (this.mPasswordConfirmed == true) goto L6;
        getChooseLockSettingsHelper().launchConfirmationActivity(32767, null, true, 2);
        return;
    }

    public void com_android_settings_ConfirmLockExtendActivity__onDestroy$___twin___() {
        if (getIntent().getBooleanExtra("password_confirmed", false) == true) goto L5;
        BaseActivity.sIsUserEnterPasswordSettings = false;
    L5:
        super.onDestroy();
    }

    public void com_android_settings_ConfirmLockExtendActivity__finish$___twin___() {
        super.finish();
        TransitionAnimHelper.overrideExitAnim(this, TransitionAnimStyle.Standard);
    }

    @Insert("onCreate")
    public static void com_android_settings_ConfirmLockExtendActivity_com_obric_hook_lancet_PrivacyHook_onCreate(ConfirmLockExtendActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ConfirmLockExtendActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_ConfirmLockExtendActivity__onCreate$___twin___(r4);
    }

    @Insert("onResume")
    public static void com_android_settings_ConfirmLockExtendActivity_com_obric_hook_lancet_PrivacyHook_onResume(ConfirmLockExtendActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ConfirmLockExtendActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_ConfirmLockExtendActivity__onResume$___twin___();
    }

    @Insert("onDestroy")
    public static void com_android_settings_ConfirmLockExtendActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(ConfirmLockExtendActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ConfirmLockExtendActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_ConfirmLockExtendActivity__onDestroy$___twin___();
    }

    @Insert("finish")
    public static void com_android_settings_ConfirmLockExtendActivity_com_obric_hook_lancet_PrivacyHook_finish(ConfirmLockExtendActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ConfirmLockExtendActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.superFinish();
        return;
    L6:
        r3.com_android_settings_ConfirmLockExtendActivity__finish$___twin___();
    }
}
