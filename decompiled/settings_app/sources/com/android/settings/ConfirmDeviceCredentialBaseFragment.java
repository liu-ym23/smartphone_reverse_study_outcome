package com.android.settings;

import android.app.ActivityManagerNative;
import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.app.IActivityManager;
import android.app.admin.DevicePolicyManager;
import android.app.trust.TrustManager;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.UserManager;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.internal.widget.LockPatternUtils;
import com.android.settings.fingerprint.FingerprintUiHelper;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ConfirmDeviceCredentialBaseFragment extends OptionsMenuFragment implements FingerprintUiHelper.Callback {
    private static final int ALLOWING_BIOMETRIC = 4;
    public static final String ALLOW_FP_AUTHENTICATION = "com.android.settings.ConfirmCredentials.allowFpAuthentication";
    public static final String DARK_THEME = "com.android.settings.ConfirmCredentials.darkTheme";
    public static final String DETAILS_TEXT = "com.android.settings.ConfirmCredentials.details";
    public static final String HEADER_TEXT = "com.android.settings.ConfirmCredentials.header";
    public static final String IS_REMOTE_LOCKSCREEN_VALIDATION = "com.android.settings.ConfirmCredentials.isRemoteLockscreenValidation";
    public static final String PACKAGE = "com.android.settings";
    public static final String SHOW_CANCEL_BUTTON = "com.android.settings.ConfirmCredentials.showCancelButton";
    public static final String SHOW_WHEN_LOCKED = "com.android.settings.ConfirmCredentials.showWhenLocked";
    public static final String TITLE_TEXT = "com.android.settings.ConfirmCredentials.title";
    public static final String USE_FADE_ANIMATION = "com.android.settings.ConfirmCredentials.useFadeAnimation";
    private boolean mAllowFpAuthentication;
    protected Button mCancelButton;
    protected int mEffectiveUserId;
    protected TextView mErrorTextView;
    private FingerprintUiHelper mFingerprintHelper;
    protected ImageView mFingerprintIcon;
    protected final Handler mHandler;
    protected boolean mIsStrongAuthRequired;
    protected LockPatternUtils mLockPatternUtils;
    private final Runnable mResetErrorRunnable;
    protected boolean mReturnCredentials;
    protected int mUserId;

    protected abstract void authenticationSucceeded();

    protected abstract int getLastTryErrorMessage();

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_ConfirmDeviceCredentialBaseFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.fingerprint.FingerprintUiHelper.Callback
    public void onFingerprintIconVisibilityChanged(boolean r1) {
    }

    @Override // com.android.settings.InstrumentedFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_ConfirmDeviceCredentialBaseFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    protected abstract void onShowError();

    public void prepareEnterAnimation() {
    }

    public void startEnterAnimation() {
    }

    public ConfirmDeviceCredentialBaseFragment() {
        this.mReturnCredentials = false;
        this.mHandler = new Handler();
        this.mResetErrorRunnable = new AnonymousClass2(this);
    }

    public void com_android_settings_ConfirmDeviceCredentialBaseFragment__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        boolean r1 = false;
        this.mAllowFpAuthentication = getActivity().getIntent().getBooleanExtra(ALLOW_FP_AUTHENTICATION, false);
        this.mReturnCredentials = getActivity().getIntent().getBooleanExtra("return_credentials", false);
        Intent r4 = getActivity().getIntent();
        this.mUserId = Utils.getUserIdFromBundle(getActivity(), r4.getExtras());
        this.mEffectiveUserId = UserManager.get(getActivity()).getCredentialOwnerProfile(this.mUserId);
        this.mLockPatternUtils = new LockPatternUtils(getActivity());
        this.mIsStrongAuthRequired = isFingerprintDisallowedByStrongAuth();
        if (this.mAllowFpAuthentication == true) goto L5;
    L11:
        this.mAllowFpAuthentication = r1;
        return;
    L5:
        if (isFingerprintDisabledByAdmin() == true) goto L11;
        if (this.mReturnCredentials == true) goto L11;
        if (this.mIsStrongAuthRequired == true) goto L11;
        r1 = true;
        goto L11
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View r4, Bundle r5) {
        super.onViewCreated(r4, r5);
        this.mCancelButton = (Button) r4.findViewById(R.id.cancelButton);
        this.mFingerprintIcon = (ImageView) r4.findViewById(R.id.fingerprintIcon);
        this.mFingerprintHelper = new FingerprintUiHelper(this.mFingerprintIcon, (TextView) r4.findViewById(R.id.errorText), this, this.mEffectiveUserId);
        int r1 = 0;
        boolean r6 = getActivity().getIntent().getBooleanExtra(SHOW_CANCEL_BUTTON, false);
        Button r0 = this.mCancelButton;
        if (r6 == true) goto L6;
        r1 = 8;
    L6:
        r0.setVisibility(r1);
        this.mCancelButton.setOnClickListener(new AnonymousClass1(this));
        int r7 = Utils.getCredentialOwnerUserId(getActivity(), Utils.getUserIdFromBundle(getActivity(), getActivity().getIntent().getExtras()));
        if (Utils.isManagedProfile(UserManager.get(getActivity()), r7) == false) goto L10;
        setWorkChallengeBackground(r4, r7);
        return;
    }

    private boolean isFingerprintDisabledByAdmin() {
        if ((((DevicePolicyManager) getActivity().getSystemService("device_policy")).getKeyguardDisabledFeatures(null, this.mEffectiveUserId) & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isFingerprintDisallowedByStrongAuth() {
        return !isBiometricAllowedForUser(this.mLockPatternUtils, this.mEffectiveUserId);
    }

    private static boolean isBiometricAllowedForUser(LockPatternUtils r0, int r1) {
        if ((r0.getStrongAuthForUser(r1) & (-5)) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void com_android_settings_ConfirmDeviceCredentialBaseFragment__onResume$___twin___() {
        super.onResume();
        if (this.mAllowFpAuthentication == false) goto L6;
        this.mFingerprintHelper.startListening();
    L6:
        if (isProfileChallenge() == false) goto L9;
        updateErrorMessage(this.mLockPatternUtils.getCurrentFailedPasswordAttempts(this.mEffectiveUserId));
        return;
    }

    protected void setAccessibilityTitle(CharSequence r4) {
        Intent r0 = getActivity().getIntent();
        if (r0 == null) goto L10;
        CharSequence r1 = r0.getCharSequenceExtra(TITLE_TEXT);
        if (r1 == null) goto L11;
        if (r4 == null) goto L12;
        getActivity().setTitle(Utils.createAccessibleSequence(r1, r1 + "," + r4));
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.android.settings.InstrumentedFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.mAllowFpAuthentication == false) goto L6;
        this.mFingerprintHelper.stopListening();
        return;
    }

    @Override // com.android.settings.fingerprint.FingerprintUiHelper.Callback
    public void onAuthenticated() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        if (getActivity().isResumed() == false) goto L9;
        ((TrustManager) getActivity().getSystemService("trust")).setDeviceLockedForUser(this.mEffectiveUserId, false);
        authenticationSucceeded();
        authenticationSucceeded();
        checkForPendingIntent();
        return;
    }

    protected void checkForPendingIntent() {
        int r0 = getActivity().getIntent().getIntExtra("android.intent.extra.TASK_ID", -1);
        if (r0 != (-1)) goto L14;
    L6:
        IntentSender r2 = (IntentSender) getActivity().getIntent().getParcelableExtra("android.intent.extra.INTENT");
        if (r2 == null) goto L16;
        getActivity().startIntentSenderForResult(r2, -1, null, 0, 0, 0);     // Catch: IntentSender.SendIntentException -> L11
        return;
    L17:
        return;
    L16:
        return;
    L14:
        IActivityManager r1 = ActivityManagerNative.getDefault();     // Catch: RemoteException -> L10
        ActivityOptions r3 = ActivityOptions.makeBasic();     // Catch: RemoteException -> L10
        MultiSDKAdapter.setLaunchStackId(r3, -1);     // Catch: RemoteException -> L10
        r1.startActivityFromRecents(r0, r3.toBundle());     // Catch: RemoteException -> L10
    }

    private void setWorkChallengeBackground(View r3, int r4) {
        View r0 = getActivity().findViewById(R.id.main_content);
        if (r0 == null) goto L5;
        r0.setPadding(0, 0, 0, 0);
    L5:
        r3.setBackground(new ColorDrawable(((DevicePolicyManager) getActivity().getSystemService("device_policy")).getOrganizationColorForUser(r4)));
        ImageView r5 = (ImageView) r3.findViewById(R.id.background_image);
        if (r5 == null) goto L9;
        Point r6 = new Point();
        getActivity().getWindowManager().getDefaultDisplay().getSize(r6);
        r5.setLayoutParams(new FrameLayout.LayoutParams(-1, r6.y));
        return;
    }

    protected boolean isProfileChallenge() {
        return Utils.isManagedProfile(UserManager.get(getContext()), this.mEffectiveUserId);
    }

    protected void reportSuccessfullAttempt() {
        if (isProfileChallenge() == false) goto L6;
        this.mLockPatternUtils.reportSuccessfulPasswordAttempt(this.mEffectiveUserId);
        this.mLockPatternUtils.userPresent(this.mEffectiveUserId);
        return;
    }

    protected void reportFailedAttempt() {
        if (isProfileChallenge() == false) goto L6;
        updateErrorMessage(this.mLockPatternUtils.getCurrentFailedPasswordAttempts(this.mEffectiveUserId) + 1);
        this.mLockPatternUtils.reportFailedPasswordAttempt(this.mEffectiveUserId);
        return;
    }

    protected void updateErrorMessage(int r7) {
        int r0 = this.mLockPatternUtils.getMaximumFailedPasswordsForWipe(this.mEffectiveUserId);
        if (r0 <= 0) goto L14;
        if (r7 <= 0) goto L15;
        int r1 = r0 - r7;
        if (r1 != 1) goto L8;
        showDialog(getActivity().getString(R.string.lock_profile_wipe_warning_title), getActivity().getString(getLastTryErrorMessage()), android.R.string.ok, false);
    L11:
        if (this.mErrorTextView == null) goto L16;
        showError(getActivity().getString(R.string.lock_profile_wipe_attempts, new Object[]{Integer.valueOf(r7), Integer.valueOf(r0)}), 0);
        return;
    L16:
        return;
    L8:
        if (r1 > 0) goto L11;
        showDialog(null, getActivity().getString(R.string.lock_profile_wipe_content), R.string.lock_profile_wipe_dismiss, true);
        goto L11
    L15:
        return;
    }

    protected void showError(CharSequence r3, long r4) {
        this.mErrorTextView.setText(r3);
        onShowError();
        this.mHandler.removeCallbacks(this.mResetErrorRunnable);
        if (r4 == 0) goto L6;
        this.mHandler.postDelayed(this.mResetErrorRunnable, r4);
        return;
    }

    protected void showError(int r1, long r2) {
        showError(getText(r1), r2);
    }

    private void showDialog(String r3, String r4, int r5, final boolean r6) {
        new AlertDialog.Builder(getActivity()).setTitle(r3).setMessage(r4).setPositiveButton(r5, new AnonymousClass3(this, r6)).create().show();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_ConfirmDeviceCredentialBaseFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ConfirmDeviceCredentialBaseFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ConfirmDeviceCredentialBaseFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ConfirmDeviceCredentialBaseFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ConfirmDeviceCredentialBaseFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_ConfirmDeviceCredentialBaseFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ConfirmDeviceCredentialBaseFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ConfirmDeviceCredentialBaseFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ConfirmDeviceCredentialBaseFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
