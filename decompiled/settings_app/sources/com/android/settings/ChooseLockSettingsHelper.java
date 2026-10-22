package com.android.settings;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.UserHandle;
import android.os.UserManager;
import androidx.fragment.app.Fragment;
import com.android.internal.widget.LockPatternUtils;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public final class ChooseLockSettingsHelper {
    public static final String EXTRA_CLOSE_IF_LOCALE_CHANGED = "extra_close_if_locale_changed";
    public static final String EXTRA_KEY_CHALLENGE = "challenge";
    public static final String EXTRA_KEY_CHALLENGE_TOKEN = "hw_auth_token";
    public static final String EXTRA_KEY_CREDENTIAL_RESPONSE = "hw_credential_response";
    public static final String EXTRA_KEY_FOR_CHANGE_CRED_REQUIRED_FOR_BOOT = "for_cred_req_boot";
    public static final String EXTRA_KEY_FOR_FINGERPRINT = "for_fingerprint";
    public static final String EXTRA_KEY_GK_PW_HANDLE = "gk_pw_handle";
    public static final String EXTRA_KEY_HAS_CHALLENGE = "has_challenge";
    public static final String EXTRA_KEY_PASSWORD = "password";
    public static final String EXTRA_KEY_REQUEST_GK_PW_HANDLE = "request_gk_pw_handle";
    public static final String EXTRA_KEY_RETURN_CREDENTIALS = "return_credentials";
    static final String EXTRA_KEY_TYPE = "type";
    static final String EXTRA_PUSH_DOWN_TO_FINISH = "push_down_to_finish";
    private Activity mActivity;
    private Fragment mFragment;
    private LockPatternUtils mLockPatternUtils;
    private StartActivityLauncher mStartActivityLauncher;

    public interface StartActivityLauncher {
        void customStartActivity(Intent r1, int r2, int r3);
    }

    public ChooseLockSettingsHelper(Activity r2) {
        this.mActivity = r2;
        this.mLockPatternUtils = new LockPatternUtils(r2);
    }

    public ChooseLockSettingsHelper(Activity r2, StartActivityLauncher r3) {
        this.mActivity = r2;
        this.mLockPatternUtils = new LockPatternUtils(r2);
        this.mStartActivityLauncher = r3;
    }

    public ChooseLockSettingsHelper(Activity r1, Fragment r2) {
        this(r1);
        this.mFragment = r2;
    }

    public ChooseLockSettingsHelper(Activity r1, Fragment r2, StartActivityLauncher r3) {
        this(r1, r3);
        this.mFragment = r2;
        this.mStartActivityLauncher = r3;
    }

    public LockPatternUtils utils() {
        return this.mLockPatternUtils;
    }

    public boolean launchConfirmationActivity(int r9, CharSequence r10, int r11) {
        return launchConfirmationActivity(r9, r10, null, null, false, false, r11);
    }

    public boolean launchConfirmationActivity(int r9, CharSequence r10, int r11, boolean r12) {
        return launchConfirmationActivity(r9, r10, null, null, r12, false, r11);
    }

    boolean launchConfirmationActivity(int r9, CharSequence r10, boolean r11) {
        return launchConfirmationActivity(r9, r10, null, null, false, r11, 0);
    }

    public boolean launchConfirmationActivity(int r14, CharSequence r15, boolean r16, int r17) {
        return launchConfirmationActivity(r14, r15, null, null, r16, false, false, 0, UserHandle.myUserId(), r17, false);
    }

    public boolean launchConfirmationActivity(int r14, CharSequence r15, boolean r16, int r17, int r18) {
        return launchConfirmationActivity(r14, r15, null, null, r16, false, false, 0, r18, r17, false);
    }

    public boolean launchConfirmationActivity(int r14, CharSequence r15, boolean r16, int r17, boolean r18) {
        return launchConfirmationActivity(r14, r15, null, null, r16, false, false, 0, UserHandle.myUserId(), r17, true);
    }

    boolean launchConfirmationActivity(int r14, CharSequence r15, CharSequence r16, CharSequence r17, boolean r18, boolean r19, int r20) {
        return launchConfirmationActivity(r14, r15, r16, r17, r18, r19, false, 0, Utils.getCredentialOwnerUserId(this.mActivity), r20, true);
    }

    boolean launchConfirmationActivity(int r14, CharSequence r15, CharSequence r16, CharSequence r17, boolean r18, boolean r19, int r20, int r21) {
        return launchConfirmationActivity(r14, r15, r16, r17, r18, r19, false, 0, Utils.enforceSameOwner(this.mActivity, r20), r21, true);
    }

    public boolean launchConfirmationActivity(int r14, CharSequence r15, CharSequence r16, CharSequence r17, long r18, int r20) {
        return launchConfirmationActivity(r14, r15, r16, r17, true, false, true, r18, Utils.getCredentialOwnerUserId(this.mActivity), r20, true);
    }

    public boolean launchConfirmationActivityWithExternalAndChallenge(int r14, CharSequence r15, CharSequence r16, CharSequence r17, boolean r18, long r19, int r21) {
        return launchConfirmationActivity(r14, r15, r16, r17, false, r18, true, r19, Utils.enforceSameOwner(this.mActivity, r21), 1, true);
    }

    private boolean launchConfirmationActivity(int r15, CharSequence r16, CharSequence r17, CharSequence r18, boolean r19, boolean r20, boolean r21, long r22, int r24, int r25, boolean r26) {
        int r1 = UserManager.get(this.mActivity).getCredentialOwnerProfile(r24);
        OLog.d("lsf", "launchConfirmationActivity:effectiveUserId:" + r1 + " userId:" + r24);
        int r2 = this.mLockPatternUtils.getKeyguardStoredPasswordQuality(r1);
        if (r2 != 65536) goto L5;
        if (r19 == true) goto L27;
        if (r21 == true) goto L27;
        Class<?> r3 = ConfirmLockPattern.class;
    L29:
        return launchConfirmationActivity(r15, r16, r17, r18, r3, r19, r20, r21, r22, r24, r25, r26);
    L27:
        r3 = ConfirmLockPattern.InternalActivity.class;
        goto L29
    L5:
        if (r2 != 131072) goto L7;
    L17:
        if (r19 == true) goto L21;
        if (r21 == true) goto L21;
        Class<?> r4 = ConfirmLockPassword.class;
    L31:
        return launchConfirmationActivity(r15, r16, r17, r18, r4, r19, r20, r21, r22, r24, r25, r26);
    L21:
        r4 = ConfirmLockPassword.InternalActivity.class;
        goto L31
    L7:
        if (r2 == 196608) goto L17;
        if (r2 == 262144) goto L17;
        if (r2 == 327680) goto L17;
        if (r2 == 393216) goto L17;
        if (r2 == 524288) goto L17;
        return false;
    }

    private boolean launchConfirmationActivity(int r3, CharSequence r4, CharSequence r5, CharSequence r6, Class<?> r7, boolean r8, boolean r9, boolean r10, long r11, int r13, int r14, boolean r15) {
        Intent r0 = new Intent();
        r0.putExtra(ConfirmDeviceCredentialBaseFragment.TITLE_TEXT, r4);
        r0.putExtra(ConfirmDeviceCredentialBaseFragment.HEADER_TEXT, r5);
        r0.putExtra(ConfirmDeviceCredentialBaseFragment.DETAILS_TEXT, r6);
        r0.putExtra(ConfirmDeviceCredentialBaseFragment.ALLOW_FP_AUTHENTICATION, r9);
        r0.putExtra(ConfirmDeviceCredentialBaseFragment.DARK_THEME, r9);
        r0.putExtra(ConfirmDeviceCredentialBaseFragment.SHOW_CANCEL_BUTTON, r9);
        r0.putExtra(ConfirmDeviceCredentialBaseFragment.SHOW_WHEN_LOCKED, r9);
        r0.putExtra("return_credentials", r8);
        r0.putExtra(EXTRA_KEY_HAS_CHALLENGE, r10);
        r0.putExtra("challenge", r11);
        r0.putExtra(SettingsActivity.EXTRA_HIDE_DRAWER, true);
        r0.putExtra("android.intent.extra.USER_ID", r13);
        r0.setClassName("com.android.settings", r7.getName());
        if (r3 != 32767) goto L5;
        r0.putExtra(EXTRA_CLOSE_IF_LOCALE_CHANGED, true);
    L5:
        if (r15 == false) goto L7;
        r0.putExtra("request_gk_pw_handle", true);
    L7:
        Fragment r12 = this.mFragment;
        if (r12 == null) goto L13;
        copyOptionalExtras(r12.getActivity().getIntent(), r0);
        StartActivityLauncher r16 = this.mStartActivityLauncher;
        if (r16 == null) goto L12;
        r16.customStartActivity(r0, r3, r14);
    L17:
        return true;
    L12:
        Utils.startActivity(this.mFragment, r0, r14, r3);
        goto L17
    L13:
        copyOptionalExtras(this.mActivity.getIntent(), r0);
        StartActivityLauncher r17 = this.mStartActivityLauncher;
        if (r17 == null) goto L16;
        r17.customStartActivity(r0, r3, r14);
        goto L17
    L16:
        Utils.startActivity(this.mActivity, r0, r14, r3);
        goto L17
    }

    private void copyOptionalExtras(Intent r3, Intent r4) {
        IntentSender r0 = (IntentSender) r3.getParcelableExtra("android.intent.extra.INTENT");
        if (r0 == null) goto L5;
        r4.putExtra("android.intent.extra.INTENT", r0);
    L5:
        int r5 = r3.getIntExtra("android.intent.extra.TASK_ID", -1);
        if (r5 == (-1)) goto L8;
        r4.putExtra("android.intent.extra.TASK_ID", r5);
    L8:
        if (r0 != null) goto L10;
        if (r5 != (-1)) goto L10;
        return;
    L10:
        r4.addFlags(8388608);
        r4.addFlags(1073741824);
    }
}
