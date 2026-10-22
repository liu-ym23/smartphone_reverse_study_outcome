package com.android.settings;

import android.content.Intent;
import android.os.Bundle;
import com.android.settings.base.BaseActivity;
import com.android.settings.provision.ProvisionConstants;
import com.obric.common.oea.style.scene.transition.TransitionAnimHelper;
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes2.dex */
public class SecurityTypeActivity extends MainSettings {
    public static final int CONFIRM_EXISTING_REQUEST = 32767;
    public static final String PASSWORD_CONFIRMED = "password_confirmed";
    public static final int RESULT_LOCALE_CHANGED = 10;
    protected boolean mPasswordConfirmed;
    private boolean mSetupWizardMode;
    protected boolean mSkipCheck;

    @Override // com.android.settings.base.BaseActivity, android.app.Activity
    public void finish() {
        com_android_settings_SecurityTypeActivity_com_obric_hook_lancet_PrivacyHook_finish(this);
    }

    @Override // com.android.settings.MainSettings, com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_SecurityTypeActivity_com_obric_hook_lancet_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_settings_SecurityTypeActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(this);
    }

    public SecurityTypeActivity() {
    }

    public void com_android_settings_SecurityTypeActivity__onCreate$___twin___(Bundle r6) {
        super.onCreate(r6);
        if (this.mSkipCheck == false) goto L5;
        return;
    L5:
        this.mPasswordConfirmed = getIntent().getBooleanExtra("password_confirmed", false);
        OLog.d(this.TAG, "mPasswordConfirmed " + this.mPasswordConfirmed);
        if (this.mPasswordConfirmed == false) goto L8;
    L10:
        this.mSetupWizardMode = Utils.getBooleanExtraSafely(getIntent(), ProvisionConstants.EXTRA_SETUPWIZARD, false);
        return;
    L8:
        if (new ChooseLockSettingsHelper(this).launchConfirmationActivity(32767, null, true, 2) == true) goto L10;
        this.mPasswordConfirmed = true;
        goto L10
    }

    @Override // com.android.settings.MainSettings, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
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

    public void com_android_settings_SecurityTypeActivity__onDestroy$___twin___() {
        if (getIntent().getBooleanExtra("password_confirmed", false) == true) goto L5;
        BaseActivity.sIsUserEnterPasswordSettings = false;
    L5:
        super.onDestroy();
    }

    public void com_android_settings_SecurityTypeActivity__finish$___twin___() {
        super.finish();
        if (this.mSetupWizardMode == true) goto L6;
        TransitionAnimHelper.overrideExitAnim(this, TransitionAnimStyle.Standard);
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_SecurityTypeActivity_com_obric_hook_lancet_PrivacyHook_onCreate(SecurityTypeActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        SecurityTypeActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_SecurityTypeActivity__onCreate$___twin___(r4);
    }

    @Insert("onDestroy")
    public static void com_android_settings_SecurityTypeActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(SecurityTypeActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        SecurityTypeActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_SecurityTypeActivity__onDestroy$___twin___();
    }

    @Insert("finish")
    public static void com_android_settings_SecurityTypeActivity_com_obric_hook_lancet_PrivacyHook_finish(SecurityTypeActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        SecurityTypeActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.superFinish();
        return;
    L6:
        r3.com_android_settings_SecurityTypeActivity__finish$___twin___();
    }
}
