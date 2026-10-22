package com.android.settings.devicecredential;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.RemoteLockscreenValidationSession;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.UserManager;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import com.android.internal.widget.LockPatternUtils;
import com.android.settings.ConfirmDeviceCredentialBaseFragment;
import com.android.settings.ConfirmLockPassword;
import com.android.settings.ConfirmLockPattern;
import com.android.settings.SetupWizardUtils;
import com.android.settings.Utils;
import com.android.vcard.VCardConfig;
import com.obric.olog.OLog;
import java.util.Optional;

/* JADX INFO: loaded from: classes2.dex */
public final class ChooseLockSettingsHelper {
    public static final String EXTRA_KEY_ALLOW_ANY_USER = "allow_any_user";
    public static final String EXTRA_KEY_CALLER_APP_NAME = "caller_app_name";
    public static final String EXTRA_KEY_CHALLENGE_TOKEN = "hw_auth_token";
    public static final String EXTRA_KEY_CHOOSE_LOCK_SCREEN_DESCRIPTION = "choose_lock_setup_screen_description";
    public static final String EXTRA_KEY_CHOOSE_LOCK_SCREEN_TITLE = "choose_lock_setup_screen_title";
    public static final String EXTRA_KEY_DEVICE_PASSWORD_REQUIREMENT_ONLY = "device_password_requirement_only";
    public static final String EXTRA_KEY_FINGERPRINT_ENROLLMENT_ONLY = "for_fingerprint_only";
    public static final String EXTRA_KEY_FORCE_VERIFY = "force_verify";
    public static final String EXTRA_KEY_FOREGROUND_ONLY = "foreground_only";
    public static final String EXTRA_KEY_FOR_BIOMETRICS = "for_biometrics";
    public static final String EXTRA_KEY_FOR_FACE = "for_face";
    public static final String EXTRA_KEY_FOR_FINGERPRINT = "for_fingerprint";
    public static final String EXTRA_KEY_GK_PW_HANDLE = "gk_pw_handle";
    public static final String EXTRA_KEY_IS_CALLING_APP_ADMIN = "is_calling_app_admin";
    public static final String EXTRA_KEY_IS_SUW = "is_suw";
    public static final String EXTRA_KEY_PASSWORD = "password";
    public static final String EXTRA_KEY_REQUESTED_MIN_COMPLEXITY = "requested_min_complexity";
    public static final String EXTRA_KEY_REQUEST_GK_PW_HANDLE = "request_gk_pw_handle";
    public static final String EXTRA_KEY_REQUEST_WRITE_REPAIR_MODE_PW = "request_write_repair_mode_pw";
    public static final String EXTRA_KEY_RETURN_CREDENTIALS = "return_credentials";
    public static final String EXTRA_KEY_UNIFICATION_PROFILE_CREDENTIAL = "unification_profile_credential";
    public static final String EXTRA_KEY_UNIFICATION_PROFILE_ID = "unification_profile_id";
    public static final String EXTRA_KEY_WROTE_REPAIR_MODE_CREDENTIAL = "wrote_repair_mode_credential";
    public static final String EXTRA_PAGE_TRANSITION_TYPE = "page_transition_type";
    private static final String TAG = "ChooseLockSettingsHelper";
    private final Activity mActivity;
    private final ActivityResultLauncher mActivityResultLauncher;
    private final Builder mBuilder;
    private final Fragment mFragment;
    LockPatternUtils mLockPatternUtils;

    /* JADX INFO: renamed from: com.android.settings.devicecredential.ChooseLockSettingsHelper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private final Activity mActivity;
        private ActivityResultLauncher mActivityResultLauncher;
        private boolean mAllowAnyUserId;
        private CharSequence mAlternateButton;
        private CharSequence mCheckBoxLabel;
        private CharSequence mDescription;
        private boolean mExternal;
        private boolean mForceVerifyPath;
        private boolean mForegroundOnly;
        private Fragment mFragment;
        private CharSequence mHeader;
        private boolean mRemoteLockscreenValidation;
        private ComponentName mRemoteLockscreenValidationServiceComponent;
        private RemoteLockscreenValidationSession mRemoteLockscreenValidationSession;
        private int mRequestCode;
        private boolean mRequestGatekeeperPasswordHandle;
        private boolean mRequestWriteRepairModePassword;
        private boolean mReturnCredentials;
        private boolean mTaskOverlay;
        private CharSequence mTitle;
        private int mUserId;

        static /* synthetic */ int access$100(Builder r0) {
            return r0.mRequestCode;
        }

        static /* synthetic */ CharSequence access$1000(Builder r0) {
            return r0.mCheckBoxLabel;
        }

        static /* synthetic */ boolean access$1100(Builder r0) {
            return r0.mRemoteLockscreenValidation;
        }

        static /* synthetic */ RemoteLockscreenValidationSession access$1200(Builder r0) {
            return r0.mRemoteLockscreenValidationSession;
        }

        static /* synthetic */ ComponentName access$1300(Builder r0) {
            return r0.mRemoteLockscreenValidationServiceComponent;
        }

        static /* synthetic */ boolean access$1400(Builder r0) {
            return r0.mAllowAnyUserId;
        }

        static /* synthetic */ boolean access$1500(Builder r0) {
            return r0.mForegroundOnly;
        }

        static /* synthetic */ boolean access$1600(Builder r0) {
            return r0.mRequestGatekeeperPasswordHandle;
        }

        static /* synthetic */ boolean access$1700(Builder r0) {
            return r0.mRequestWriteRepairModePassword;
        }

        static /* synthetic */ boolean access$1800(Builder r0) {
            return r0.mTaskOverlay;
        }

        static /* synthetic */ CharSequence access$200(Builder r0) {
            return r0.mTitle;
        }

        static /* synthetic */ CharSequence access$300(Builder r0) {
            return r0.mHeader;
        }

        static /* synthetic */ CharSequence access$400(Builder r0) {
            return r0.mDescription;
        }

        static /* synthetic */ boolean access$500(Builder r0) {
            return r0.mReturnCredentials;
        }

        static /* synthetic */ boolean access$600(Builder r0) {
            return r0.mExternal;
        }

        static /* synthetic */ boolean access$700(Builder r0) {
            return r0.mForceVerifyPath;
        }

        static /* synthetic */ int access$800(Builder r0) {
            return r0.mUserId;
        }

        static /* synthetic */ CharSequence access$900(Builder r0) {
            return r0.mAlternateButton;
        }

        public Builder(Activity r1) {
            this.mActivity = r1;
            this.mUserId = Utils.getCredentialOwnerUserId(r1);
        }

        public Builder(Activity r1, Fragment r2) {
            this(r1);
            this.mFragment = r2;
        }

        public Builder setRequestCode(int r1) {
            this.mRequestCode = r1;
            return this;
        }

        public Builder setTitle(CharSequence r1) {
            this.mTitle = r1;
            return this;
        }

        public Builder setHeader(CharSequence r1) {
            this.mHeader = r1;
            return this;
        }

        public Builder setDescription(CharSequence r1) {
            this.mDescription = r1;
            return this;
        }

        public Builder setAlternateButton(CharSequence r1) {
            this.mAlternateButton = r1;
            return this;
        }

        public Builder setCheckboxLabel(CharSequence r1) {
            this.mCheckBoxLabel = r1;
            return this;
        }

        public Builder setReturnCredentials(boolean r1) {
            this.mReturnCredentials = r1;
            return this;
        }

        public Builder setUserId(int r1) {
            this.mUserId = r1;
            return this;
        }

        public Builder setAllowAnyUserId(boolean r1) {
            this.mAllowAnyUserId = r1;
            return this;
        }

        public Builder setExternal(boolean r1) {
            this.mExternal = r1;
            return this;
        }

        public Builder setTaskOverlay(boolean r1) {
            this.mTaskOverlay = r1;
            return this;
        }

        public Builder setForegroundOnly(boolean r1) {
            this.mForegroundOnly = r1;
            return this;
        }

        public Builder setForceVerifyPath(boolean r1) {
            this.mForceVerifyPath = r1;
            return this;
        }

        public Builder setRemoteLockscreenValidation(boolean r1) {
            this.mRemoteLockscreenValidation = r1;
            return this;
        }

        public Builder setRemoteLockscreenValidationSession(RemoteLockscreenValidationSession r1) {
            this.mRemoteLockscreenValidationSession = r1;
            return this;
        }

        public Builder setRemoteLockscreenValidationServiceComponent(ComponentName r1) {
            this.mRemoteLockscreenValidationServiceComponent = r1;
            return this;
        }

        public Builder setRequestGatekeeperPasswordHandle(boolean r1) {
            this.mRequestGatekeeperPasswordHandle = r1;
            return this;
        }

        public Builder setRequestWriteRepairModePassword(boolean r1) {
            this.mRequestWriteRepairModePassword = r1;
            return this;
        }

        public Builder setActivityResultLauncher(ActivityResultLauncher r1) {
            this.mActivityResultLauncher = r1;
            return this;
        }

        public ChooseLockSettingsHelper build() {
            if (this.mAllowAnyUserId == true) goto L10;
            int r0 = this.mUserId;
            if (r0 == (-9999)) goto L10;
            if (r0 == (-9998)) goto L10;
            Utils.enforceSameOwner(this.mActivity, r0);
        L10:
            if (this.mExternal == false) goto L19;
            if (this.mReturnCredentials == false) goto L19;
            if (this.mRemoteLockscreenValidation == true) goto L19;
            throw new IllegalArgumentException("External and ReturnCredentials specified.  External callers should never be allowed to receive credentials in onActivityResult");
        L19:
            if (this.mRequestGatekeeperPasswordHandle == false) goto L24;
            if (this.mReturnCredentials == true) goto L24;
            OLog.w(ChooseLockSettingsHelper.TAG, "Requested gatekeeper password handle but not requesting ReturnCredentials. Are you sure this is what you want?");
        L24:
            return new ChooseLockSettingsHelper(this, this.mActivity, this.mFragment, this.mActivityResultLauncher, null);
        }

        public boolean show() {
            return build().launch();
        }
    }

    /* synthetic */ ChooseLockSettingsHelper(Builder r1, Activity r2, Fragment r3, ActivityResultLauncher r4, AnonymousClass1 r5) {
        this(r1, r2, r3, r4);
    }

    private ChooseLockSettingsHelper(Builder r1, Activity r2, Fragment r3, ActivityResultLauncher r4) {
        this.mBuilder = r1;
        this.mActivity = r2;
        this.mFragment = r3;
        this.mActivityResultLauncher = r4;
        this.mLockPatternUtils = new LockPatternUtils(r2);
    }

    public boolean launch() {
        return launchConfirmationActivity(Builder.access$100(this.mBuilder), Builder.access$200(this.mBuilder), Builder.access$300(this.mBuilder), Builder.access$400(this.mBuilder), Builder.access$500(this.mBuilder), Builder.access$600(this.mBuilder), Builder.access$700(this.mBuilder), Builder.access$800(this.mBuilder), Builder.access$900(this.mBuilder), Builder.access$1000(this.mBuilder), Builder.access$1100(this.mBuilder), Builder.access$1200(this.mBuilder), Builder.access$1300(this.mBuilder), Builder.access$1400(this.mBuilder), Builder.access$1500(this.mBuilder), Builder.access$1600(this.mBuilder), Builder.access$1700(this.mBuilder), Builder.access$1800(this.mBuilder));
    }

    private boolean launchConfirmationActivity(int r21, CharSequence r22, CharSequence r23, CharSequence r24, boolean r25, boolean r26, boolean r27, int r28, CharSequence r29, CharSequence r30, boolean r31, RemoteLockscreenValidationSession r32, ComponentName r33, boolean r34, boolean r35, boolean r36, boolean r37, boolean r38) {
        Optional<Class<?>> r1 = determineAppropriateActivityClass(r25, r27, r28, r32);
        if (r1.isEmpty() == false) goto L7;
        return false;
    L7:
        return launchConfirmationActivity(r21, r22, r23, r24, r1.get(), r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38);
    }

    private boolean launchConfirmationActivity(int r8, CharSequence r9, CharSequence r10, CharSequence r11, Class<?> r12, boolean r13, boolean r14, boolean r15, int r16, CharSequence r17, CharSequence r18, boolean r19, RemoteLockscreenValidationSession r20, ComponentName r21, boolean r22, boolean r23, boolean r24, boolean r25, boolean r26) {
        Intent r3 = new Intent();
        r3.putExtra(ConfirmDeviceCredentialBaseFragment.TITLE_TEXT, r9);
        r3.putExtra(ConfirmDeviceCredentialBaseFragment.HEADER_TEXT, r10);
        r3.putExtra(ConfirmDeviceCredentialBaseFragment.DETAILS_TEXT, r11);
        r3.putExtra(ConfirmDeviceCredentialBaseFragment.DARK_THEME, false);
        r3.putExtra(ConfirmDeviceCredentialBaseFragment.SHOW_CANCEL_BUTTON, false);
        r3.putExtra(ConfirmDeviceCredentialBaseFragment.SHOW_WHEN_LOCKED, r14);
        r3.putExtra(ConfirmDeviceCredentialBaseFragment.USE_FADE_ANIMATION, r14);
        r3.putExtra(ConfirmDeviceCredentialBaseFragment.IS_REMOTE_LOCKSCREEN_VALIDATION, r19);
        r3.putExtra("return_credentials", r13);
        r3.putExtra(EXTRA_KEY_FORCE_VERIFY, r15);
        r3.putExtra("android.intent.extra.USER_ID", r16);
        r3.putExtra("android.app.extra.ALTERNATE_BUTTON_LABEL", r17);
        r3.putExtra("android.app.extra.CHECKBOX_LABEL", r18);
        r3.putExtra("android.app.extra.REMOTE_LOCKSCREEN_VALIDATION_SESSION", r20);
        r3.putExtra("android.intent.extra.COMPONENT_NAME", r21);
        r3.putExtra(EXTRA_KEY_FOREGROUND_ONLY, r23);
        r3.putExtra(EXTRA_KEY_ALLOW_ANY_USER, r22);
        r3.putExtra("request_gk_pw_handle", r24);
        r3.putExtra(EXTRA_KEY_REQUEST_WRITE_REPAIR_MODE_PW, r25);
        r3.setClassName("com.android.settings", r12.getName());
        r3.putExtra("page_transition_type", 1);
        Fragment r4 = this.mFragment;
        if (r4 == null) goto L5;
        Intent r5 = r4.getActivity().getIntent();
    L6:
        copyInternalExtras(r5, r3);
        Bundle r6 = createLaunchOptions(r26);
        if (r14 == false) goto L15;
        r3.addFlags(VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING);
        copyOptionalExtras(r5, r3);
        ActivityResultLauncher r1 = this.mActivityResultLauncher;
        if (r1 == null) goto L11;
        r1.launch(r3);
    L22:
        return true;
    L11:
        Fragment r2 = this.mFragment;
        if (r2 == null) goto L14;
        r2.startActivity(r3, r6);
        goto L22
    L14:
        this.mActivity.startActivity(r3, r6);
        goto L22
    L15:
        ActivityResultLauncher r7 = this.mActivityResultLauncher;
        if (r7 == null) goto L18;
        r7.launch(r3);
        goto L22
    L18:
        Fragment r27 = this.mFragment;
        if (r27 == null) goto L21;
        r27.startActivityForResult(r3, r8, r6);
        goto L22
    L21:
        this.mActivity.startActivityForResult(r3, r8, r6);
        goto L22
    L5:
        r5 = this.mActivity.getIntent();
        goto L6
    }

    private Bundle createLaunchOptions(boolean r1) {
        if (r1 == true) goto L5;
        return null;
    L5:
        ActivityOptions r2 = ActivityOptions.makeBasic();
        r2.setLaunchTaskId(this.mActivity.getTaskId());
        r2.setTaskOverlay(true, true);
        return r2.toBundle();
    }

    private Optional<Integer> passwordQualityToLockTypes(int r3) {
        if (r3 == 65536) goto L23;
        if (r3 == 131072) goto L21;
        if (r3 == 196608) goto L21;
        if (r3 == 262144) goto L19;
        if (r3 == 327680) goto L19;
        if (r3 == 393216) goto L19;
        if (r3 == 524288) goto L19;
        OLog.e(TAG, String.format("Cannot determine appropriate activity class for password quality %d", new Object[]{Integer.valueOf(r3)}));
        return Optional.empty();
    L19:
        return Optional.of(0);
    L21:
        return Optional.of(1);
    L23:
        return Optional.of(2);
    }

    private Optional<Class<?>> determineAppropriateActivityClass(boolean r1, boolean r2, int r3, RemoteLockscreenValidationSession r4) {
        if (r4 == null) goto L4;
        int r0 = r4.getLockType();
    L9:
        if (r0 != 0) goto L11;
    L23:
        if (r1 == true) goto L27;
        if (r2 == true) goto L27;
        Object r5 = ConfirmLockPassword.class;
    L29:
        return Optional.of(r5);
    L27:
        r5 = ConfirmLockPassword.InternalActivity.class;
        goto L29
    L11:
        if (r0 == 1) goto L23;
        if (r0 == 2) goto L16;
        OLog.e(TAG, String.format("Cannot determine appropriate activity class for lock type %d", new Object[]{Integer.valueOf(r0)}));
        return Optional.empty();
    L16:
        if (r1 == true) goto L20;
        if (r2 == true) goto L20;
        Object r6 = ConfirmLockPattern.class;
    L22:
        return Optional.of(r6);
    L20:
        r6 = ConfirmLockPattern.InternalActivity.class;
        goto L22
    L4:
        Optional<Integer> r7 = passwordQualityToLockTypes(this.mLockPatternUtils.getKeyguardStoredPasswordQuality(UserManager.get(this.mActivity).getCredentialOwnerProfile(r3)));
        if (r7.isEmpty() == true) goto L7;
        r0 = r7.get().intValue();
        goto L9
    L7:
        return Optional.empty();
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

    private void copyInternalExtras(Intent r1, Intent r2) {
        SetupWizardUtils.copySetupExtras(r1, r2);
        String r3 = r1.getStringExtra("theme");
        if (r3 == null) goto L6;
        r2.putExtra("theme", r3);
        return;
    }
}
