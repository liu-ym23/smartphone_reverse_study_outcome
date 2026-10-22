package com.android.settings.devicecredential;

import android.app.RemoteLockscreenValidationSession;
import android.app.admin.DevicePolicyManager;
import android.app.trust.TrustManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.UserProperties;
import android.hardware.biometrics.BiometricPrompt;
import android.hardware.biometrics.PromptInfo;
import android.multiuser.Flags;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.android.internal.widget.LockPatternUtils;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ConfirmDeviceCredentialActivity extends FragmentActivity {
    public static final int BIOMETRIC_LOCKOUT_ERROR_RESULT = 100;
    public static final String BIOMETRIC_PROMPT_AUTHENTICATORS = "biometric_prompt_authenticators";
    public static final String BIOMETRIC_PROMPT_HIDE_BACKGROUND = "biometric_prompt_hide_background";
    public static final String BIOMETRIC_PROMPT_NEGATIVE_BUTTON_TEXT = "biometric_prompt_negative_button_text";
    public static final String CUSTOM_BIOMETRIC_PROMPT_LOGO_DESCRIPTION_KEY = "custom_logo_description";
    public static final String CUSTOM_BIOMETRIC_PROMPT_LOGO_RES_ID_KEY = "custom_logo_res_id";
    public static final String EXTRA_DATA = "extra_data";
    public static final String TAG = "ConfirmDeviceCredentialActivity";
    private static final String TAG_BIOMETRIC_FRAGMENT = "fragment";
    private BiometricPrompt.AuthenticationCallback mAuthenticationCallback;
    private BiometricFragment mBiometricFragment;
    private int mBiometricsAuthenticators;
    private boolean mCheckDevicePolicyManager;
    private Context mContext;
    private CharSequence mDetails;
    private DevicePolicyManager mDevicePolicyManager;
    private Executor mExecutor;
    private boolean mForceVerifyPath;
    private boolean mGoingToBackground;
    private Handler mHandler;
    private Intent mIntentData;
    private LockPatternUtils mLockPatternUtils;
    private boolean mTaskOverlay;
    private String mTitle;
    private TrustManager mTrustManager;
    private int mUserId;
    private UserManager mUserManager;
    private boolean mWaitingForBiometricCallback;

    public static class InternalActivity extends ConfirmDeviceCredentialActivity {
        public void com_android_settings_devicecredential_ConfirmDeviceCredentialActivity$InternalActivity__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_devicecredential_ConfirmDeviceCredentialActivity$InternalActivity__onPause$___twin___() {
            super.onPause();
        }

        public void com_android_settings_devicecredential_ConfirmDeviceCredentialActivity$InternalActivity__onResume$___twin___() {
            super.onResume();
        }

        public void com_android_settings_devicecredential_ConfirmDeviceCredentialActivity$InternalActivity__onStop$___twin___() {
            super.onStop();
        }

        public void com_android_settings_devicecredential_ConfirmDeviceCredentialActivity$InternalActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
            super.startActivityForResult(r1, r2, r3);
        }

        @Override // com.android.settings.devicecredential.ConfirmDeviceCredentialActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle r1) {
            com_android_settings_devicecredential_ConfirmDeviceCredentialActivity$InternalActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
        }

        @Override // com.android.settings.devicecredential.ConfirmDeviceCredentialActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
        public void onPause() {
            com_android_settings_devicecredential_ConfirmDeviceCredentialActivity$InternalActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
        }

        @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
        public void onResume() {
            com_android_settings_devicecredential_ConfirmDeviceCredentialActivity$InternalActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
        }

        @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
        protected void onStop() {
            com_android_settings_devicecredential_ConfirmDeviceCredentialActivity$InternalActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
        }

        @Override // androidx.activity.ComponentActivity, android.app.Activity
        public void startActivityForResult(Intent r1, int r2, Bundle r3) {
            com_android_settings_devicecredential_ConfirmDeviceCredentialActivity$InternalActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
        }

        public InternalActivity() {
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
        @Insert(mayCreateSuper = true, value = "onStop")
        public static void com_android_settings_devicecredential_ConfirmDeviceCredentialActivity$InternalActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(InternalActivity r1) {
            r1.com_android_settings_devicecredential_ConfirmDeviceCredentialActivity$InternalActivity__onStop$___twin___();
            if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
            return;
        L8:
            r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
            return;
        }

        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_devicecredential_ConfirmDeviceCredentialActivity$InternalActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(InternalActivity r1) {
            String r0 = r1.getClass().getName();
            com_android_settings_devicecredential_ConfirmDeviceCredentialActivity$InternalActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            AppMetricsUtils.INSTANCE.activityEventEnd(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_devicecredential_ConfirmDeviceCredentialActivity$InternalActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(InternalActivity r4) {
            String r0 = r4.getClass().getName();
            r4.com_android_settings_devicecredential_ConfirmDeviceCredentialActivity$InternalActivity__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
            OLog.i("AppLifecycle", "onResume_Activity " + r0);
            AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r1.recordVisibleTime(r0);
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
            InternalActivity r5 = r4;
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
        public static void com_android_settings_devicecredential_ConfirmDeviceCredentialActivity$InternalActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(InternalActivity r2, Intent r3, int r4, Bundle r5) {
            Intrinsics.checkNotNullParameter(r3, "intent");
            String r0 = r2.getClass().getName();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
            AppMetricsUtils.INSTANCE.activityEventStart(r0);
        L5:
            r2.com_android_settings_devicecredential_ConfirmDeviceCredentialActivity$InternalActivity__startActivityForResult$___twin___(r3, r4, r5);
        }

        @Insert(mayCreateSuper = true, value = "onStop")
        public static void com_android_settings_devicecredential_ConfirmDeviceCredentialActivity$InternalActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(InternalActivity r2) {
            String r0 = r2.getClass().getName();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
            AppMetricsUtils.INSTANCE.activityEventStoped(r0);
        L5:
            com_android_settings_devicecredential_ConfirmDeviceCredentialActivity$InternalActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
        @Insert(mayCreateSuper = true, value = "onPause")
        public static void com_android_settings_devicecredential_ConfirmDeviceCredentialActivity$InternalActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(InternalActivity r4) {
            String r0 = r4.getClass().getName();
            r4.com_android_settings_devicecredential_ConfirmDeviceCredentialActivity$InternalActivity__onPause$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_Activity " + r0);
            AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_devicecredential_ConfirmDeviceCredentialActivity$InternalActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(InternalActivity r3, Bundle r4) {
            String r0 = r3.getClass().getName();
            r3.com_android_settings_devicecredential_ConfirmDeviceCredentialActivity$InternalActivity__onCreate$___twin___(r4);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
            OLog.i("AppLifecycle", "onCreate_Activity " + r0);
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
            InternalActivity r5 = r3;
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

    static {
    }

    public ConfirmDeviceCredentialActivity() {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mForceVerifyPath = false;
        this.mExecutor = new ConfirmDeviceCredentialActivity$$ExternalSyntheticLambda0(this);
        this.mAuthenticationCallback = new AnonymousClass1(this);
    }

    static /* synthetic */ boolean access$000(ConfirmDeviceCredentialActivity r0) {
        return r0.mGoingToBackground;
    }

    static /* synthetic */ boolean access$100(ConfirmDeviceCredentialActivity r0) {
        return r0.mWaitingForBiometricCallback;
    }

    static /* synthetic */ Intent access$1000(ConfirmDeviceCredentialActivity r0) {
        return r0.mIntentData;
    }

    static /* synthetic */ boolean access$102(ConfirmDeviceCredentialActivity r0, boolean r1) {
        r0.mWaitingForBiometricCallback = r1;
        return r1;
    }

    static /* synthetic */ int access$200(ConfirmDeviceCredentialActivity r0) {
        return r0.mUserId;
    }

    static /* synthetic */ UserManager access$300(ConfirmDeviceCredentialActivity r0) {
        return r0.mUserManager;
    }

    static /* synthetic */ int access$400(ConfirmDeviceCredentialActivity r0) {
        return r0.mBiometricsAuthenticators;
    }

    static /* synthetic */ void access$500(ConfirmDeviceCredentialActivity r0) {
        r0.showConfirmCredentials();
    }

    static /* synthetic */ TrustManager access$600(ConfirmDeviceCredentialActivity r0) {
        return r0.mTrustManager;
    }

    static /* synthetic */ LockPatternUtils access$700(ConfirmDeviceCredentialActivity r0) {
        return r0.mLockPatternUtils;
    }

    static /* synthetic */ DevicePolicyManager access$800(ConfirmDeviceCredentialActivity r0) {
        return r0.mDevicePolicyManager;
    }

    static /* synthetic */ boolean access$900(ConfirmDeviceCredentialActivity r0) {
        return r0.isInternalActivity();
    }

    /* JADX INFO: renamed from: lambda$new$0$com-android-settings-devicecredential-ConfirmDeviceCredentialActivity, reason: not valid java name */
    /* synthetic */ void m435x403a107(Runnable r1) {
        this.mHandler.post(r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r18) {
        super.onCreate(r18);
        Intent r2 = getIntent();
        boolean r3 = false;
        if (r2.getBooleanExtra(BIOMETRIC_PROMPT_HIDE_BACKGROUND, false) == false) goto L5;
        getWindow().addFlags(2);
        getWindow().setDimAmount(1.0f);
        r2.removeExtra(BIOMETRIC_PROMPT_HIDE_BACKGROUND);
    L6:
        this.mDevicePolicyManager = (DevicePolicyManager) getSystemService(DevicePolicyManager.class);
        this.mUserManager = UserManager.get(this);
        this.mTrustManager = (TrustManager) getSystemService(TrustManager.class);
        this.mLockPatternUtils = new LockPatternUtils(this);
        this.mContext = this;
        this.mCheckDevicePolicyManager = r2.getBooleanExtra("check_dpm", false);
        this.mTitle = r2.getStringExtra("android.app.extra.TITLE");
        this.mDetails = r2.getCharSequenceExtra("android.app.extra.DESCRIPTION");
        String r4 = r2.getStringExtra("android.app.extra.ALTERNATE_BUTTON_LABEL");
        this.mBiometricsAuthenticators = r2.getIntExtra(BIOMETRIC_PROMPT_AUTHENTICATORS, 33023);
        this.mIntentData = (Intent) r2.getParcelableExtra(EXTRA_DATA, Intent.class);
        String r5 = r2.getStringExtra(BIOMETRIC_PROMPT_NEGATIVE_BUTTON_TEXT);
        boolean r6 = "android.app.action.CONFIRM_FRP_CREDENTIAL".equals(r2.getAction());
        boolean r7 = "android.app.action.CONFIRM_REPAIR_MODE_DEVICE_CREDENTIAL".equals(r2.getAction());
        boolean r8 = "android.app.action.CONFIRM_REMOTE_DEVICE_CREDENTIAL".equals(r2.getAction());
        if (isInternalActivity() == true) goto L9;
    L11:
        boolean r0 = false;
    L12:
        this.mTaskOverlay = r0;
        boolean r10 = "android.app.action.PREPARE_REPAIR_MODE_DEVICE_CREDENTIAL".equals(r2.getAction());
        this.mUserId = UserHandle.myUserId();
        if (isInternalActivity() == true) goto L97;
    L18:
        int r1 = this.mUserManager.getCredentialOwnerProfile(this.mUserId);
        boolean r11 = this.mUserManager.isManagedProfile(r1);
        UserProperties r12 = this.mUserManager.getUserProperties(UserHandle.of(this.mUserId));
        if (this.mTitle != null) goto L22;
        if (r11 == false) goto L22;
        this.mTitle = getTitleFromOrganizationName(this.mUserId);
    L22:
        PromptInfo r13 = new PromptInfo();
        r13.setTitle(this.mTitle);
        r13.setDescription(this.mDetails);
        r13.setDisallowBiometricsIfPolicyExists(this.mCheckDevicePolicyManager);
        r13.setAuthenticators(this.mBiometricsAuthenticators);
        r13.setNegativeButtonText(r5);
        String r9 = r2.getStringExtra("android.intent.extra.PACKAGE_NAME");
        if (isInternalActivity() == false) goto L26;
        if (r9 == null) goto L26;
        r13.setRealCallerForConfirmDeviceCredentialActivity(new ComponentName(r9, ""));
    L28:
        if (Flags.enablePrivateSpaceFeatures() == true) goto L30;
    L39:
        int r14 = this.mDevicePolicyManager.getManagedSubscriptionsPolicy().getPolicyType();
        if (r11 == false) goto L43;
        if (r14 != 1) goto L43;
        r13.setShowEmergencyCallButton(true);
    L43:
        int r15 = Utils.getCredentialType(this.mContext, r1);
        if (this.mTitle != null) goto L47;
        r13.setDeviceCredentialTitle(getTitleFromCredentialType(r15, r11));
    L47:
        if (this.mDetails != null) goto L49;
        r13.setDeviceCredentialSubtitle(Utils.getConfirmCredentialStringForUser(this, this.mUserId, r15));
    L49:
        if (r6 == false) goto L52;
        boolean r16 = new ChooseLockSettingsHelper.Builder(this).setHeader(this.mTitle).setDescription(this.mDetails).setAlternateButton(r4).setExternal(true).setUserId(-9999).show();
    L51:
        r3 = r16;
        boolean r17 = false;
    L91:
        if (r3 == false) goto L93;
        finish();
        return;
    L93:
        if (r17 == false) goto L95;
        this.mWaitingForBiometricCallback = true;
        return;
    L95:
        OLog.d(TAG, "No pattern, password or PIN set.");
        setResult(-1);
        finish();
        return;
    L52:
        if (r7 == false) goto L54;
        r16 = new ChooseLockSettingsHelper.Builder(this).setHeader(this.mTitle).setDescription(this.mDetails).setAlternateButton(r4).setExternal(true).setUserId(-9998).show();
        goto L51
    L54:
        if (r8 == false) goto L57;
        RemoteLockscreenValidationSession r19 = (RemoteLockscreenValidationSession) r2.getParcelableExtra("android.app.extra.REMOTE_LOCKSCREEN_VALIDATION_SESSION", RemoteLockscreenValidationSession.class);
        ComponentName r20 = (ComponentName) r2.getParcelableExtra("android.intent.extra.COMPONENT_NAME", ComponentName.class);
        new ChooseLockSettingsHelper.Builder(this).setRemoteLockscreenValidation(true).setRemoteLockscreenValidationSession(r19).setRemoteLockscreenValidationServiceComponent(r20).setRequestGatekeeperPasswordHandle(true).setReturnCredentials(true).setHeader(this.mTitle).setDescription(this.mDetails).setCheckboxLabel(r2.getStringExtra("android.app.extra.CHECKBOX_LABEL")).setAlternateButton(r4).setExternal(true).show();
        return;
    L57:
        if (r10 == false) goto L60;
        r16 = new ChooseLockSettingsHelper.Builder(this).setHeader(this.mTitle).setDescription(this.mDetails).setExternal(true).setUserId(this.mUserId).setTaskOverlay(this.mTaskOverlay).setRequestWriteRepairModePassword(true).setForceVerifyPath(true).show();
        goto L51
    L60:
        if (this.mLockPatternUtils.isManagedProfileWithUnifiedChallenge(this.mUserId) == false) goto L68;
        if (isInternalActivity() == false) goto L68;
        this.mForceVerifyPath = true;
        if (isBiometricAllowed(r1, this.mUserId) == false) goto L66;
        showBiometricPrompt(r13, this.mUserId);
    L88:
        r17 = true;
        goto L91
    L66:
        showConfirmCredentials();
    L90:
        r17 = false;
        r3 = true;
    L68:
        if (android.os.Flags.allowPrivateProfile() == false) goto L86;
        if (Flags.enablePrivateSpaceFeatures() == false) goto L86;
        if (r12 == null) goto L86;
        if (r12.isAuthAlwaysRequiredToDisableQuietMode() == false) goto L86;
        if (isInternalActivity() == false) goto L86;
        this.mForceVerifyPath = r12.isCredentialShareableWithParent();
        if (Flags.enableBiometricsToUnlockPrivateSpace() == false) goto L82;
        if (isBiometricAllowed(r1, this.mUserId) == false) goto L82;
        setBiometricPromptPropertiesForPrivateProfile(r13);
        showBiometricPrompt(r13, r1);
    L82:
        if (BiometricFlagsReflectionUtils.privateSpaceBp() == false) goto L84;
        r13.setAuthenticators(32768);
        setBiometricPromptPropertiesForPrivateProfile(r13);
        showBiometricPrompt(r13, this.mUserId);
        goto L88
    L84:
        this.mDetails = Utils.getConfirmCredentialStringForUser(this, this.mUserId, r15);
        showConfirmCredentials();
    L86:
        if (isBiometricAllowed(r1, this.mUserId) == false) goto L89;
        showBiometricPrompt(r13, this.mUserId);
        goto L88
    L89:
        showConfirmCredentials();
        goto L90
    L30:
        if (Flags.usePrivateSpaceIconInBiometricPrompt() == false) goto L39;
        if (hasSetBiometricDialogAdvanced(this.mContext, getLaunchedFromUid()) == false) goto L39;
        int r21 = r2.getIntExtra("custom_logo_res_id", 0);
        if (r21 == 0) goto L36;
        r13.setLogo(r21, Utils.drawableToBitmap(this.mContext.getDrawable(r21)));
    L36:
        String r22 = r2.getStringExtra("custom_logo_description");
        if (TextUtils.isEmpty(r22) == true) goto L39;
        r13.setLogoDescription(r22);
    L26:
        r13.setRealCallerForConfirmDeviceCredentialActivity(getCallingActivity());
        goto L28
    L97:
        this.mUserId = Utils.getUserIdFromBundle(this, r2.getExtras());     // Catch: SecurityException -> L16
    L16:
        e = move-exception;
        OLog.e(TAG, "Invalid intent extra", e);
        goto L18
    L9:
        if (r2.getBooleanExtra("android.app.KeyguardManager.FORCE_TASK_OVERLAY", false) == false) goto L11;
        r0 = true;
        goto L12
    L5:
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(0);
        goto L6
    }

    private static void setBiometricPromptPropertiesForPrivateProfile(PromptInfo r1) {
        r1.setUseParentProfileForDeviceCredential(true);
        r1.setConfirmationRequested(false);
    }

    /* JADX INFO: renamed from: lambda$getTitleFromCredentialType$1$com-android-settings-devicecredential-ConfirmDeviceCredentialActivity, reason: not valid java name */
    /* synthetic */ String m432x239ff3bf() {
        return getString(R.string.lockpassword_confirm_your_work_pin_header);
    }

    /* JADX INFO: renamed from: lambda$getTitleFromCredentialType$2$com-android-settings-devicecredential-ConfirmDeviceCredentialActivity, reason: not valid java name */
    /* synthetic */ String m433x6cba700() {
        return getString(R.string.lockpassword_confirm_your_work_pattern_header);
    }

    private String getTitleFromCredentialType(int r2, boolean r3) {
        if (r2 != 1) goto L5;
        if (r3 == false) goto L24;
        return this.mDevicePolicyManager.getResources().getString("Settings.CONFIRM_WORK_PROFILE_PATTERN_HEADER", new ConfirmDeviceCredentialActivity$$ExternalSyntheticLambda2(this));
    L24:
        return getString(R.string.lockpassword_confirm_your_pattern_header);
    L5:
        if (r2 != 3) goto L7;
        if (r3 == false) goto L19;
        return this.mDevicePolicyManager.getResources().getString("Settings.CONFIRM_WORK_PROFILE_PIN_HEADER", new ConfirmDeviceCredentialActivity$$ExternalSyntheticLambda1(this));
    L19:
        return getString(R.string.lockpassword_confirm_your_pin_header);
    L7:
        if (r2 == 4) goto L10;
        return null;
    L10:
        if (r3 == false) goto L14;
        return this.mDevicePolicyManager.getResources().getString("Settings.CONFIRM_WORK_PROFILE_PASSWORD_HEADER", new ConfirmDeviceCredentialActivity$$ExternalSyntheticLambda3(this));
    L14:
        return getString(R.string.lockpassword_confirm_your_password_header);
    }

    /* JADX INFO: renamed from: lambda$getTitleFromCredentialType$3$com-android-settings-devicecredential-ConfirmDeviceCredentialActivity, reason: not valid java name */
    /* synthetic */ String m434xe9f75a41() {
        return getString(R.string.lockpassword_confirm_your_work_password_header);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        setVisible(true);
        if ((getResources().getConfiguration().uiMode & 48) == 32) goto L6;
        getWindow().getInsetsController().setSystemBarsAppearance(8, 8);
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (isChangingConfigurations() == true) goto L7;
        this.mGoingToBackground = true;
        if (this.mWaitingForBiometricCallback == true) goto L9;
        finish();
        return;
    L9:
        return;
    L7:
        this.mGoingToBackground = false;
    }

    private static boolean hasSetBiometricDialogAdvanced(Context r2, int r3) {
        if (r2.checkPermission("android.permission.SET_BIOMETRIC_DIALOG_ADVANCED", -1, r3) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isStrongAuthRequired(int r2) {
        if (this.mLockPatternUtils.isBiometricAllowedForUser(r2) == true) goto L5;
    L8:
        return true;
    L5:
        if (doesUserStateEnforceStrongAuth(this.mUserId) == true) goto L8;
        return false;
    }

    private boolean doesUserStateEnforceStrongAuth(int r2) {
        if (android.os.Flags.allowPrivateProfile() == false) goto L11;
        if (Flags.enableBiometricsToUnlockPrivateSpace() == false) goto L11;
        if (Flags.enablePrivateSpaceFeatures() == false) goto L11;
        return !StorageManager.isCeStorageUnlocked(r2);
    L11:
        return !this.mUserManager.isUserUnlocked(r2);
    }

    private boolean isBiometricAllowed(int r1, int r2) {
        if (isStrongAuthRequired(r1) == false) goto L5;
    L7:
        return false;
    L5:
        if (this.mLockPatternUtils.hasPendingEscrowToken(r2) == true) goto L7;
        return true;
    }

    private void showBiometricPrompt(PromptInfo r5, int r6) {
        BiometricFragment r0 = (BiometricFragment) getSupportFragmentManager().findFragmentByTag("fragment");
        this.mBiometricFragment = r0;
        if (r0 != null) goto L5;
        this.mBiometricFragment = BiometricFragment.newInstance(r5);
        boolean r7 = true;
    L6:
        this.mBiometricFragment.setCallbacks(this.mExecutor, this.mAuthenticationCallback);
        this.mBiometricFragment.setUser(r6);
        if (r7 == false) goto L10;
        getSupportFragmentManager().beginTransaction().add(this.mBiometricFragment, "fragment").commit();
        return;
    L10:
        return;
    L5:
        r7 = false;
        goto L6
    }

    private void showConfirmCredentials() {
        if (new ChooseLockSettingsHelper.Builder(this).setHeader(this.mTitle).setDescription(this.mDetails).setExternal(true).setUserId(this.mUserId).setTaskOverlay(this.mTaskOverlay).setForceVerifyPath(this.mForceVerifyPath).show() == true) goto L5;
        OLog.d(TAG, "No pin/pattern/pass set");
        setResult(-1);
    L5:
        finish();
    }

    private boolean isInternalActivity() {
        return this instanceof InternalActivity;
    }

    private String getTitleFromOrganizationName(int r2) {
        DevicePolicyManager r1 = (DevicePolicyManager) getSystemService("device_policy");
        if (r1 == null) goto L5;
        CharSequence r3 = r1.getOrganizationNameForUser(r2);
    L6:
        if (r3 != null) goto L8;
        return null;
    L8:
        return r3.toString();
    L5:
        r3 = null;
        goto L6
    }
}
