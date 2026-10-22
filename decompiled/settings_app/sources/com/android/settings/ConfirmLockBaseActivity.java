package com.android.settings;

import android.content.Intent;
import android.os.Bundle;
import android.os.UserManager;
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
public class ConfirmLockBaseActivity extends BaseActivity {
    public static final int CONFIRM_EXISTING_REQUEST = 32767;
    public static final String PASSWORD_CONFIRMED = "password_confirmed";
    public static final int RESULT_LOCALE_CHANGED = 10;
    protected LockscreenCredential mPassword;
    protected boolean mPasswordConfirmed;
    private boolean mSetupWizardMode;
    protected boolean mSkipCheck;

    @Override // com.android.settings.base.BaseActivity, android.app.Activity
    public void finish() {
        com_android_settings_ConfirmLockBaseActivity_com_obric_hook_lancet_PrivacyHook_finish(this);
    }

    protected boolean needInterceptConfirm(Bundle r1) {
        return false;
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_ConfirmLockBaseActivity_com_obric_hook_lancet_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_settings_ConfirmLockBaseActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(this);
    }

    public ConfirmLockBaseActivity() {
        this.mPasswordConfirmed = false;
        this.mPassword = null;
        this.mSkipCheck = false;
    }

    public void com_android_settings_ConfirmLockBaseActivity__onCreate$___twin___(Bundle r7) {
        super.onCreate(r7);
        if (this.mSkipCheck == false) goto L6;
        return;
    L6:
        if (r7 == null) goto L8;
        this.mPasswordConfirmed = r7.getBoolean("password_confirmed");
        this.mPassword = (LockscreenCredential) r7.getParcelable("password", LockscreenCredential.class);
    L15:
        OLog.d(this.TAG, "mPasswordConfirmed " + this.mPasswordConfirmed);
        if (this.mPasswordConfirmed == false) goto L18;
    L20:
        this.mSetupWizardMode = Utils.getBooleanExtraSafely(getIntent(), ProvisionConstants.EXTRA_SETUPWIZARD, false);
        return;
    L18:
        if (needInterceptConfirm(r7) == true) goto L20;
        new ChooseLockSettingsHelper(this).launchConfirmationActivity(32767, null, true, 2, Utils.getSecureTargetUser(getActivityToken(), UserManager.get(this), null, getIntent().getExtras()).getIdentifier());
        goto L20
    L8:
        Intent r1 = getIntent();
        if (r1 == null) goto L15;
        if (r1.hasExtra("password") == false) goto L15;
        LockscreenCredential r0 = r1.getParcelableExtra("password");
        this.mPassword = r0;
        if (r0 == null) goto L15;
        this.mPasswordConfirmed = true;
        goto L15
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int r3, int r4, Intent r5) {
        super.onActivityResult(r3, r4, r5);
        if (r3 != 32767) goto L24;
        boolean r0 = false;
        if (r4 != (-1)) goto L20;
        if (r5 == null) goto L17;
        if (r5.hasExtra("password") == false) goto L17;
        LockscreenCredential r6 = r5.getParcelableExtra("password");
        this.mPassword = r6;
        if (r6 != null) goto L13;
    L15:
        this.mPasswordConfirmed = r0;
        goto L17
    L13:
        if (r6.isNone() == true) goto L15;
        r0 = true;
    L17:
        if (BaseActivity.sIsUserEnterPasswordSettings == true) goto L25;
        registerUserLeavePasswordSettingsIfNeeded();
        BaseActivity.sIsUserEnterPasswordSettings = true;
        return;
    L25:
        return;
    L20:
        if (r4 == 10) goto L27;
        setResult(0);
        getIntent().removeExtra("bytedanceos.intent.extra.ANIM_RESOURCE_ID");
        finish();
        return;
    L27:
        return;
    }

    public void com_android_settings_ConfirmLockBaseActivity__onDestroy$___twin___() {
        if (getIntent().getBooleanExtra("password_confirmed", false) == true) goto L5;
        BaseActivity.sIsUserEnterPasswordSettings = false;
    L5:
        super.onDestroy();
    }

    public void com_android_settings_ConfirmLockBaseActivity__finish$___twin___() {
        super.finish();
        TransitionAnimHelper.overrideExitAnim(this, TransitionAnimStyle.Standard);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle r3) {
        super.onSaveInstanceState(r3);
        r3.putBoolean("password_confirmed", this.mPasswordConfirmed);
        r3.putParcelable("password", this.mPassword);
    }

    @Insert("onCreate")
    public static void com_android_settings_ConfirmLockBaseActivity_com_obric_hook_lancet_PrivacyHook_onCreate(ConfirmLockBaseActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ConfirmLockBaseActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_ConfirmLockBaseActivity__onCreate$___twin___(r4);
    }

    @Insert("onDestroy")
    public static void com_android_settings_ConfirmLockBaseActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(ConfirmLockBaseActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ConfirmLockBaseActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_ConfirmLockBaseActivity__onDestroy$___twin___();
    }

    @Insert("finish")
    public static void com_android_settings_ConfirmLockBaseActivity_com_obric_hook_lancet_PrivacyHook_finish(ConfirmLockBaseActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ConfirmLockBaseActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.superFinish();
        return;
    L6:
        r3.com_android_settings_ConfirmLockBaseActivity__finish$___twin___();
    }
}
