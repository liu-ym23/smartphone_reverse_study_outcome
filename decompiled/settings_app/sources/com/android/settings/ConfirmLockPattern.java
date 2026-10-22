package com.android.settings;

import android.animation.ObjectAnimator;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.fingerprint.FingerprintManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.os.UserManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.GlobalProxyLancet;
import com.android.internal.widget.LockPatternUtils;
import com.android.settings.applications.utils.XTSUtils;
import com.android.settings.base.BaseActivity;
import com.android.settings.fingerprint.FingerprintAuthenticateHelper;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.UIUtils;
import com.android.settings.widget.lockpatternview.KeyguardLockPatternView;
import com.android.settingslib.animation.AppearAnimationCreator;
import com.android.settingslib.animation.AppearAnimationUtils;
import com.android.settingslib.animation.DisappearAnimationUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Collections;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.util.WindowUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ConfirmLockPattern extends BaseActivity {
    private boolean mCloseWhenLocaleChange;
    private boolean mIsAllowFingerprint;
    protected BroadcastReceiver mReceiver;

    /* JADX INFO: renamed from: com.android.settings.ConfirmLockPattern$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$android$settings$ConfirmLockPattern$Stage = null;

        static {
            int[] r0 = new int[Stage.values().length];
            $SwitchMap$com$android$settings$ConfirmLockPattern$Stage = r0;
            r0[Stage.NeedToUnlock.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$android$settings$ConfirmLockPattern$Stage[Stage.NeedToUnlockWrong.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$android$settings$ConfirmLockPattern$Stage[Stage.LockedOut.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static class ConfirmLockPatternFragment extends Fragment implements AppearAnimationCreator<Object>, FingerprintAuthenticateHelper.Callback {
        private static final long ERROR_MESSAGE_TIMEOUT = 1000;
        private static final String KEY_NUM_WRONG_ATTEMPTS = "num_wrong_attempts";
        private static final int MSG_RESET_UI_IF_ERROR = 10;
        private static final String TAG = "ConfirmLockPatternFragment";
        private static final int WRONG_PATTERN_CLEAR_TIMEOUT_MS = 2000;
        private AppearAnimationUtils mAppearAnimationUtils;
        private final Runnable mClearPatternRunnable;
        private final KeyguardLockPatternView.OnPatternListener mConfirmExistingLockPatternListener;
        private CountDownTimer mCountdownTimer;
        private CharSequence mDetailsText;
        private DisappearAnimationUtils mDisappearAnimationUtils;
        private int mEffectiveUserId;
        private FingerprintAuthenticateHelper mFingerprintListenHelper;
        private FingerprintManager mFingerprintManager;
        private final Handler mHandler;
        private CharSequence mHeaderText;
        private ObjectAnimator mHeaderTextShakeAnim;
        private TextView mHeaderTextView;
        private boolean mIsAllowFingerprint;
        private boolean mIsManagedProfile;
        private View mLeftSpacerLandscape;
        private LockPatternUtils mLockPatternUtils;
        private KeyguardLockPatternView mLockPatternView;
        private int mNumWrongConfirmAttempts;
        private AsyncTask<?, ?, ?> mPendingLockCheck;
        private boolean mReturnCredentials;
        private boolean mReturnGatekeeperPassword;
        private View mRightSpacerLandscape;
        private int mUserId;
        private UserManager mUserManager;

        @Override // com.android.settingslib.animation.AppearAnimationCreator
        public void createAnimation(Object r1, long r2, long r4, float r6, boolean r7, Interpolator r8, Runnable r9) {
        }

        @Override // com.android.settings.fingerprint.FingerprintAuthenticateHelper.Callback
        public void onAuthenticationAcquired(int r1) {
        }

        @Override // com.android.settings.fingerprint.FingerprintAuthenticateHelper.Callback
        public void onAuthenticationHelp(int r1, CharSequence r2) {
        }

        @Override // androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_ConfirmLockPattern$ConfirmLockPatternFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_ConfirmLockPattern$ConfirmLockPatternFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        static /* synthetic */ KeyguardLockPatternView access$100(ConfirmLockPatternFragment r0) {
            return r0.mLockPatternView;
        }

        static /* synthetic */ void access$1000(ConfirmLockPatternFragment r0, Intent r1) {
            r0.startDisappearAnimation(r1);
        }

        static /* synthetic */ void access$1100(ConfirmLockPatternFragment r0, long r1) {
            r0.handleAttemptLockout(r1);
        }

        static /* synthetic */ void access$1200(ConfirmLockPatternFragment r0, Stage r1) {
            r0.updateStage(r1);
        }

        static /* synthetic */ void access$1300(ConfirmLockPatternFragment r0) {
            r0.postClearPatternRunnable();
        }

        static /* synthetic */ void access$1400(ConfirmLockPatternFragment r0) {
            r0.playHeaderTextViewAnim();
        }

        static /* synthetic */ TextView access$1500(ConfirmLockPatternFragment r0) {
            return r0.mHeaderTextView;
        }

        static /* synthetic */ void access$1600(ConfirmLockPatternFragment r0, boolean r1) {
            r0.setupHeaderTextColor(r1);
        }

        static /* synthetic */ CountDownTimer access$1702(ConfirmLockPatternFragment r0, CountDownTimer r1) {
            r0.mCountdownTimer = r1;
            return r1;
        }

        static /* synthetic */ int access$1802(ConfirmLockPatternFragment r0, int r1) {
            r0.mNumWrongConfirmAttempts = r1;
            return r1;
        }

        static /* synthetic */ int access$1900(ConfirmLockPatternFragment r0) {
            return r0.getDefaultHeader();
        }

        static /* synthetic */ Runnable access$200(ConfirmLockPatternFragment r0) {
            return r0.mClearPatternRunnable;
        }

        static /* synthetic */ void access$2000(ConfirmLockPatternFragment r0, boolean r1, int r2) {
            r0.updateHeaderTextView(r1, r2);
        }

        static /* synthetic */ ObjectAnimator access$2102(ConfirmLockPatternFragment r0, ObjectAnimator r1) {
            r0.mHeaderTextShakeAnim = r1;
            return r1;
        }

        static /* synthetic */ Handler access$300(ConfirmLockPatternFragment r0) {
            return r0.mHandler;
        }

        static /* synthetic */ AsyncTask access$400(ConfirmLockPatternFragment r0) {
            return r0.mPendingLockCheck;
        }

        static /* synthetic */ AsyncTask access$402(ConfirmLockPatternFragment r0, AsyncTask r1) {
            r0.mPendingLockCheck = r1;
            return r1;
        }

        static /* synthetic */ boolean access$500(ConfirmLockPatternFragment r0) {
            return r0.mReturnGatekeeperPassword;
        }

        static /* synthetic */ boolean access$600(ConfirmLockPatternFragment r0) {
            return r0.isInternalActivity();
        }

        static /* synthetic */ int access$700(ConfirmLockPatternFragment r0) {
            return r0.mEffectiveUserId;
        }

        static /* synthetic */ LockPatternUtils access$800(ConfirmLockPatternFragment r0) {
            return r0.mLockPatternUtils;
        }

        public ConfirmLockPatternFragment() {
            this.mClearPatternRunnable = new AnonymousClass3(this);
            this.mConfirmExistingLockPatternListener = new AnonymousClass5(this);
            this.mHandler = new AnonymousClass7(this);
        }

        public void com_android_settings_ConfirmLockPattern$ConfirmLockPatternFragment__onCreate$___twin___(Bundle r3) {
            super.onCreate(r3);
            this.mLockPatternUtils = new LockPatternUtils(getActivity());
            this.mUserManager = UserManager.get(getActivity());
            int r4 = Utils.getUserIdFromBundle(getActivity(), getActivity().getIntent().getExtras());
            this.mUserId = r4;
            this.mEffectiveUserId = this.mUserManager.getCredentialOwnerProfile(r4);
            this.mIsManagedProfile = this.mUserManager.isManagedProfile(this.mUserId);
            OLog.d("ConfirmLockPattern", "UserId:" + this.mUserId + " ManagedProfile:" + this.mIsManagedProfile);
            this.mFingerprintListenHelper = FingerprintAuthenticateHelper.getInstance(getActivity().getApplicationContext());
            this.mFingerprintManager = (FingerprintManager) getActivity().getSystemService("fingerprint");
            if (isInternalActivity() == true) goto L9;
            FingerprintManager r5 = this.mFingerprintManager;
            if (r5 == null) goto L9;
            if (r5.hasEnrolledFingerprints() == false) goto L9;
            boolean r6 = true;
        L10:
            this.mIsAllowFingerprint = r6;
            this.mReturnGatekeeperPassword = getActivity().getIntent().getBooleanExtra("request_gk_pw_handle", false);
            OLog.d("Fingerprint", "onCreate Fragment, mIsAllowFingerprint = " + this.mIsAllowFingerprint);
            return;
        L9:
            r6 = false;
            goto L10
        }

        @Override // androidx.fragment.app.Fragment
        public View onCreateView(LayoutInflater r20, ViewGroup r21, Bundle r22) {
            View r2 = r20.inflate(R.layout.confirm_lock_pattern, null);
            ((FrameLayout) r2.findViewById(R.id.lockPatternFL)).addView(UIUtils.buildNoScaledView(getActivity(), R.layout.view_lockpattern_input));
            View r4 = r2.findViewById(R.id.xts_enterprise_icon);
            if (r4 != null) goto L5;
        L11:
            this.mHeaderTextView = (TextView) r2.findViewById(R.id.headerText);
            this.mLockPatternView = (KeyguardLockPatternView) r2.findViewById(R.id.lockPattern);
            setupHeaderTextColor(false);
            r2.findViewById(R.id.topLayout).setDefaultTouchRecepient(this.mLockPatternView);
            Intent r5 = getActivity().getIntent();
            if (r5 == null) goto L14;
            this.mHeaderText = r5.getCharSequenceExtra(ConfirmDeviceCredentialBaseFragment.HEADER_TEXT);
            this.mDetailsText = r5.getCharSequenceExtra(ConfirmDeviceCredentialBaseFragment.DETAILS_TEXT);
        L14:
            this.mLockPatternView.setInStealthMode(!this.mLockPatternUtils.isVisiblePatternEnabled(this.mEffectiveUserId));
            this.mLockPatternView.setOnPatternListener(this.mConfirmExistingLockPatternListener);
            updateStage(Stage.NeedToUnlock);
            if (r22 == null) goto L18;
            this.mNumWrongConfirmAttempts = r22.getInt(KEY_NUM_WRONG_ATTEMPTS);
        L23:
            ((OFloatingTitleBar) r2.findViewById(R.id.view_title)).addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, null).setOnClickListener(new AnonymousClass1(this));
            this.mAppearAnimationUtils = new AppearAnimationUtils(getContext(), 220, 2.0f, 1.3f, AnimationUtils.loadInterpolator(getContext(), 17563662));
            this.mDisappearAnimationUtils = new DisappearAnimationUtils(getContext(), 125, 4.0f, 0.3f, AnimationUtils.loadInterpolator(getContext(), 17563663), new AnonymousClass2(this));
            return r2;
        L18:
            if (this.mLockPatternUtils.isLockPatternEnabled(this.mEffectiveUserId) == true) goto L23;
            Intent r1 = new Intent();
            r1.putExtra("request_code", -1);
            if (r5 == null) goto L22;
            r1.putExtra("request_code", r5.getIntExtra("request_code", -1));
        L22:
            getActivity().setResult(-1, r1);
            getActivity().finish();
            goto L23
        L5:
            if (XTSUtils.isInXtsMode() == true) goto L7;
        L9:
            int r6 = 8;
        L10:
            r4.setVisibility(r6);
            goto L11
        L7:
            if (this.mIsManagedProfile == false) goto L9;
            r6 = 0;
            goto L10
        }

        @Override // androidx.fragment.app.Fragment
        public void onViewCreated(View r3, Bundle r4) {
            UIUtils.fitMaskTitleInCommon((ViewGroup) r3, r3.findViewById(R.id.title));
            super.onViewCreated(r3, r4);
        }

        @Override // androidx.fragment.app.Fragment
        public void onSaveInstanceState(Bundle r2) {
            super.onSaveInstanceState(r2);
            r2.putInt(KEY_NUM_WRONG_ATTEMPTS, this.mNumWrongConfirmAttempts);
        }

        @Override // androidx.fragment.app.Fragment
        public void onPause() {
            super.onPause();
            if (this.mIsAllowFingerprint == false) goto L6;
            this.mFingerprintListenHelper.stopAuthenticate();
            return;
        }

        @Override // androidx.fragment.app.Fragment
        public void onDestroy() {
            super.onDestroy();
            CountDownTimer r0 = this.mCountdownTimer;
            if (r0 == null) goto L5;
            r0.cancel();
            this.mCountdownTimer = null;
        L5:
            AsyncTask<?, ?, ?> r1 = this.mPendingLockCheck;
            if (r1 == null) goto L8;
            r1.cancel(false);
            this.mPendingLockCheck = null;
        L8:
            KeyguardLockPatternView r3 = this.mLockPatternView;
            if (r3 == null) goto L12;
            r3.setOnPatternListener(null);
            return;
        }

        public void com_android_settings_ConfirmLockPattern$ConfirmLockPatternFragment__onResume$___twin___() {
            super.onResume();
            long r0 = this.mLockPatternUtils.getLockoutAttemptDeadline(this.mEffectiveUserId);
            if (this.mCountdownTimer == null) goto L5;
            boolean r2 = true;
        L6:
            if (r2 == false) goto L8;
            updateHeaderTextView();
        L13:
            if (this.mIsAllowFingerprint == false) goto L16;
            this.mFingerprintListenHelper.startAuthenticate(this);
            return;
        L16:
            return;
        L8:
            if (r0 == 0) goto L10;
            handleAttemptLockout(r0);
            goto L13
        L10:
            this.mNumWrongConfirmAttempts = 0;
            updateStage(Stage.NeedToUnlock);
            goto L13
        L5:
            r2 = false;
            goto L6
        }

        private Object[][] getActiveViews() {
            new ArrayList().add(new ArrayList(Collections.singletonList(this.mHeaderTextView)));
            return null;
        }

        private void updateStage(Stage r4) {
            int r5 = AnonymousClass2.$SwitchMap$com$android$settings$ConfirmLockPattern$Stage[r4.ordinal()];
            boolean r0 = false;
            if (r5 == 1) goto L12;
            if (r5 != 2) goto L7;
            updateHeaderTextView(true, R.string.lockpattern_need_to_unlock_wrong);
            Utils.vibratorUnlockNoPass(getActivity());
            this.mLockPatternView.setDisplayMode(KeyguardLockPatternView.DisplayMode.Wrong);
            this.mLockPatternView.setEnabled(true);
            this.mLockPatternView.enableInput();
        L28:
            TextView r3 = this.mHeaderTextView;
            r3.announceForAccessibility(r3.getText());
            return;
        L7:
            if (r5 != 3) goto L28;
            this.mLockPatternView.clearPattern();
            this.mLockPatternView.setEnabled(false);
            goto L28
        L12:
            if (this.mHeaderText != null) goto L14;
            this.mHeaderTextView.setText(getDefaultHeader());
        L23:
            if (this.mIsAllowFingerprint == true) goto L25;
        L27:
            setupHeaderTextColor(r0);
            this.mLockPatternView.setEnabled(true);
            this.mLockPatternView.enableInput();
            this.mLockPatternView.clearPattern();
            goto L28
        L25:
            if (this.mFingerprintListenHelper.isFingerprintUnlockLockout() == false) goto L27;
            r0 = true;
            goto L27
        L14:
            if (this.mIsManagedProfile == true) goto L16;
        L20:
            this.mHeaderTextView.setText(this.mHeaderText);
            goto L23
        L16:
            if (getView() == null) goto L20;
            this.mHeaderTextView.setText(getDefaultHeader());
            TextView r6 = (TextView) getView().findViewById(R.id.title);
            if (r6 == null) goto L23;
            r6.setText(this.mHeaderText);
            goto L23
        }

        private void postClearPatternRunnable() {
            this.mLockPatternView.removeCallbacks(this.mClearPatternRunnable);
            this.mLockPatternView.postDelayed(this.mClearPatternRunnable, 2000);
        }

        private void setupHeaderTextColor(boolean r2) {
            if (r2 == false) goto L4;
            int r3 = R.color.lock_screen_header_warning_text_color;
        L5:
            this.mHeaderTextView.setTextColor(getResources().getColor(r3));
            return;
        L4:
            r3 = R.color.oui_text_3;
            goto L5
        }

        private void startDisappearAnimation(final Intent r5) {
            final FragmentActivity r0 = getActivity();
            if (r0 != null) goto L6;
            OLog.e(TAG, "startDisappearAnimation, fragmentActivity is null, return");
            return;
        L6:
            Intent r1 = r0.getIntent();
            r5.putExtra("request_code", -1);
            if (r1 == null) goto L10;
            r5.putExtra("request_code", r1.getIntExtra("request_code", -1));
        L10:
            if (r0.getThemeResId() != 2132019029) goto L12;
            this.mLockPatternView.clearPattern();
            this.mDisappearAnimationUtils.startAnimation2d(getActiveViews(), new AnonymousClass4(this, r0, r5), this);
            return;
        L12:
            r0.setResult(-1, r5);
            r0.finish();
        }

        private boolean isInternalActivity() {
            return getActivity() instanceof InternalActivity;
        }

        /* JADX WARN: Type inference failed for: r8v0, types: [com.android.settings.ConfirmLockPattern$ConfirmLockPatternFragment$6] */
        private void handleAttemptLockout(long r10) {
            updateStage(Stage.LockedOut);
            final long r4 = r10 - SystemClock.elapsedRealtime();
            final long r6 = 1000;
            this.mCountdownTimer = new AnonymousClass6(this, r4, r6).start();
        }

        private int getDefaultHeader() {
            if (this.mIsAllowFingerprint == true) goto L5;
            FingerprintManager r2 = this.mFingerprintManager;
            if (r2 != null) goto L11;
        L14:
            return R.string.lockpassword_confirm_your_pattern_header;
        L11:
            if (r2.hasEnrolledFingerprints() == false) goto L14;
            return R.string.lockpassword_confirm_your_pattern_header_fingerprints;
        L5:
            if (this.mFingerprintListenHelper.isFingerprintUnlockLockout() == false) goto L15;
            return R.string.pattern_fingerprint_lockout_error;
        L15:
            return R.string.lockpassword_confirm_your_pattern_header;
        }

        private void updateHeaderTextView() {
            if (isPasswordLockout() == false) goto L5;
        L10:
            boolean r0 = true;
        L11:
            updateHeaderTextView(r0, getDefaultHeader());
            return;
        L5:
            if (this.mIsAllowFingerprint == true) goto L7;
        L9:
            r0 = false;
            goto L11
        L7:
            if (this.mFingerprintListenHelper.isFingerprintUnlockLockout() == false) goto L9;
            goto L9
        }

        private void updateHeaderTextView(boolean r2, int r3) {
            if (isAdded() == true) goto L5;
            return;
        L5:
            this.mHeaderTextView.setText(r3);
            setupHeaderTextColor(r2);
        }

        @Override // com.android.settings.fingerprint.FingerprintAuthenticateHelper.Callback
        public void onAuthenticationSucceeded(int r1) {
            if (isPasswordLockout() == false) goto L5;
            playHeaderTextViewAnim();
            Utils.vibratorUnlockNoPass(getActivity());
            return;
        L5:
            startDisappearAnimation(new Intent());
        }

        @Override // com.android.settings.fingerprint.FingerprintAuthenticateHelper.Callback
        public void onAuthenticationFailed() {
            Utils.vibratorUnlockNoPass(getActivity());
            updateHeaderTextView(true, R.string.retry_again);
            playHeaderTextViewAnim();
        }

        @Override // com.android.settings.fingerprint.FingerprintAuthenticateHelper.Callback
        public void onAnyFingerprintDetected() {
            if (isPasswordLockout() == false) goto L6;
            boolean r0 = true;
        L9:
            if (r0 == true) goto L11;
            return;
        L11:
            if (isPasswordLockout() == true) goto L13;
            updateHeaderTextView(true, getDefaultHeader());
        L13:
            Utils.vibratorUnlockNoPass(getActivity());
            playHeaderTextViewAnim();
            return;
        L6:
            if (this.mIsAllowFingerprint == false) goto L8;
            r0 = this.mFingerprintListenHelper.isFingerprintUnlockLockout();
            goto L9
        L8:
            r0 = false;
            goto L9
        }

        @Override // com.android.settings.fingerprint.FingerprintAuthenticateHelper.Callback
        public void onAuthenticationError(int r3, CharSequence r4) {
            if (r3 != 7) goto L12;
            if (this.mHandler.hasMessages(10) == false) goto L7;
            this.mHandler.removeMessages(10);
        L7:
            OLog.d("Fingerprint", "onAuthenticationError in confirm pattern");
            if (isPasswordLockout() == true) goto L10;
            updateHeaderTextView(true, R.string.pattern_fingerprint_lockout_error);
        L10:
            Utils.vibratorUnlockNoPass(getActivity());
            playHeaderTextViewAnim();
            return;
        L12:
            if (r3 == 10003) goto L14;
            return;
        L14:
            if (isPasswordLockout() == true) goto L19;
            updateHeaderTextView(true, R.string.pattern_fingerprint_lockout_error);
            return;
        }

        @Override // com.android.settings.fingerprint.FingerprintAuthenticateHelper.Callback
        public void onFingerprintLockoutReset() {
            if (isAdded() == true) goto L6;
            return;
        L6:
            if (TextUtils.equals(getString(R.string.pattern_fingerprint_lockout_error), this.mHeaderTextView.getText().toString()) == false) goto L9;
            updateHeaderTextView(false, getDefaultHeader());
            return;
        }

        private void playHeaderTextViewAnim() {
            ObjectAnimator r0 = this.mHeaderTextShakeAnim;
            if (r0 != null) goto L5;
        L7:
            ObjectAnimator r1 = Utils.createShakeAnim(this.mHeaderTextView, new AnonymousClass8(this));
            this.mHeaderTextShakeAnim = r1;
            r1.start();
            return;
        L5:
            if (r0.isRunning() == false) goto L7;
        }

        private boolean isPasswordLockout() {
            if (this.mLockPatternUtils.getLockoutAttemptDeadline(this.mEffectiveUserId) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_ConfirmLockPattern$ConfirmLockPatternFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ConfirmLockPatternFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_ConfirmLockPattern$ConfirmLockPatternFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_ConfirmLockPattern$ConfirmLockPatternFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ConfirmLockPatternFragment r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_ConfirmLockPattern$ConfirmLockPatternFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_ConfirmLockPattern$ConfirmLockPatternFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ConfirmLockPatternFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_ConfirmLockPattern$ConfirmLockPatternFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    public static class InternalActivity extends ConfirmLockPattern {
        public void com_android_settings_ConfirmLockPattern$InternalActivity__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_ConfirmLockPattern$InternalActivity__onPause$___twin___() {
            super.onPause();
        }

        public void com_android_settings_ConfirmLockPattern$InternalActivity__onResume$___twin___() {
            super.onResume();
        }

        public void com_android_settings_ConfirmLockPattern$InternalActivity__onStop$___twin___() {
            super.onStop();
        }

        public void com_android_settings_ConfirmLockPattern$InternalActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
            super.startActivityForResult(r1, r2, r3);
        }

        @Override // com.android.settings.ConfirmLockPattern, com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle r1) {
            com_android_settings_ConfirmLockPattern$InternalActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
        }

        @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
        public void onPause() {
            com_android_settings_ConfirmLockPattern$InternalActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
        }

        @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
        public void onResume() {
            com_android_settings_ConfirmLockPattern$InternalActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
        }

        @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
        public void onStop() {
            com_android_settings_ConfirmLockPattern$InternalActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
        }

        @Override // androidx.activity.ComponentActivity, android.app.Activity
        public void startActivityForResult(Intent r1, int r2, Bundle r3) {
            com_android_settings_ConfirmLockPattern$InternalActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
        }

        public InternalActivity() {
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
        @Insert(mayCreateSuper = true, value = "onStop")
        public static void com_android_settings_ConfirmLockPattern$InternalActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(InternalActivity r1) {
            com_android_settings_ConfirmLockPattern$InternalActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
            if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
            return;
        L8:
            r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
            return;
        }

        @Insert("onCreate")
        public static void com_android_settings_ConfirmLockPattern$InternalActivity_com_obric_hook_lancet_PrivacyHook_onCreate(InternalActivity r3, Bundle r4) {
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
            InternalActivity r0 = r3;
            if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
            r0.onCreateWhenPrivacyNotOk(null);
            r0.onSuperCreate(null);
            return;
        L6:
            GrantUtil.INSTANCE.applicationInit();
            r3.com_android_settings_ConfirmLockPattern$InternalActivity__onCreate$___twin___(r4);
        }

        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_ConfirmLockPattern$InternalActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(InternalActivity r1) {
            String r0 = r1.getClass().getName();
            com_android_settings_ConfirmLockPattern$InternalActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            AppMetricsUtils.INSTANCE.activityEventEnd(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_ConfirmLockPattern$InternalActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(InternalActivity r4) {
            String r0 = r4.getClass().getName();
            com_android_settings_ConfirmLockPattern$InternalActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
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
        public static void com_android_settings_ConfirmLockPattern$InternalActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(InternalActivity r2, Intent r3, int r4, Bundle r5) {
            Intrinsics.checkNotNullParameter(r3, "intent");
            String r0 = r2.getClass().getName();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
            AppMetricsUtils.INSTANCE.activityEventStart(r0);
        L5:
            r2.com_android_settings_ConfirmLockPattern$InternalActivity__startActivityForResult$___twin___(r3, r4, r5);
        }

        @Insert(mayCreateSuper = true, value = "onStop")
        public static void com_android_settings_ConfirmLockPattern$InternalActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(InternalActivity r2) {
            String r0 = r2.getClass().getName();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
            AppMetricsUtils.INSTANCE.activityEventStoped(r0);
        L5:
            com_android_settings_ConfirmLockPattern$InternalActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
        }

        @Insert("onResume")
        public static void com_android_settings_ConfirmLockPattern$InternalActivity_com_obric_hook_lancet_PrivacyHook_onResume(InternalActivity r3) {
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
            InternalActivity r0 = r3;
            if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
            r0.onSuperResume();
            return;
        L6:
            r3.com_android_settings_ConfirmLockPattern$InternalActivity__onResume$___twin___();
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
        @Insert(mayCreateSuper = true, value = "onPause")
        public static void com_android_settings_ConfirmLockPattern$InternalActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(InternalActivity r4) {
            String r0 = r4.getClass().getName();
            com_android_settings_ConfirmLockPattern$InternalActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_Activity " + r0);
            AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
            return;
        }

        @Insert("onPause")
        public static void com_android_settings_ConfirmLockPattern$InternalActivity_com_obric_hook_lancet_PrivacyHook_onPause(InternalActivity r3) {
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
            InternalActivity r0 = r3;
            if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
            r0.onSuperPause();
            return;
        L6:
            r3.com_android_settings_ConfirmLockPattern$InternalActivity__onPause$___twin___();
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_ConfirmLockPattern$InternalActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(InternalActivity r3, Bundle r4) {
            String r0 = r3.getClass().getName();
            com_android_settings_ConfirmLockPattern$InternalActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
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

        @Insert("onStop")
        public static void com_android_settings_ConfirmLockPattern$InternalActivity_com_obric_hook_lancet_PrivacyHook_onStop(InternalActivity r3) {
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
            InternalActivity r0 = r3;
            if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
            r0.onSuperStop();
            return;
        L6:
            r3.com_android_settings_ConfirmLockPattern$InternalActivity__onStop$___twin___();
        }
    }

    private static final enum Stage extends Enum<Stage> {
        private static final /* synthetic */ Stage[] $VALUES = null;
        public static final Stage LockedOut = null;
        public static final Stage NeedToUnlock = null;
        public static final Stage NeedToUnlockWrong = null;

        private static /* synthetic */ Stage[] $values() {
            return new Stage[]{NeedToUnlock, NeedToUnlockWrong, LockedOut};
        }

        private Stage(String r1, int r2) {
            super(r1, r2);
        }

        public static Stage valueOf(String r1) {
            return (Stage) Enum.valueOf(Stage.class, r1);
        }

        public static Stage[] values() {
            return (Stage[]) $VALUES.clone();
        }

        static {
            NeedToUnlock = new Stage("NeedToUnlock", 0);
            NeedToUnlockWrong = new Stage("NeedToUnlockWrong", 1);
            LockedOut = new Stage("LockedOut", 2);
            $VALUES = $values();
        }
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_ConfirmLockPattern_com_obric_hook_lancet_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_settings_ConfirmLockPattern_com_obric_hook_lancet_PrivacyHook_onDestroy(this);
    }

    public ConfirmLockPattern() {
        this.mReceiver = new AnonymousClass1(this);
        this.mIsAllowFingerprint = false;
    }

    static /* synthetic */ boolean access$000(ConfirmLockPattern r0) {
        return r0.mCloseWhenLocaleChange;
    }

    public void com_android_settings_ConfirmLockPattern__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        setContentView(R.layout.confirm_lock_pattern_activity);
        FingerprintManager r4 = (FingerprintManager) getSystemService("fingerprint");
        if ((this instanceof InternalActivity) == true) goto L8;
        if (r4 == null) goto L8;
        if (r4.hasEnrolledFingerprints() == false) goto L8;
        boolean r5 = true;
    L9:
        this.mIsAllowFingerprint = r5;
        this.mCloseWhenLocaleChange = getIntent().getBooleanExtra(ChooseLockSettingsHelper.EXTRA_CLOSE_IF_LOCALE_CHANGED, false);
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, this.mReceiver, new IntentFilter("android.intent.action.LOCALE_CHANGED"), 2);
        WindowUtils.Companion.addSecureFlag(this);
        return;
    L8:
        r5 = false;
        goto L9
    }

    @Override // com.android.settings.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (SettingsFeature.isFingerprintNavigationDevice() == true) goto L5;
    L7:
        super.onBackPressed();
        return;
    L5:
        if (this.mIsAllowFingerprint == false) goto L7;
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        if (Utils.getLockPasswordType(this) == 1) goto L6;
        finish();
        overridePendingTransition(0, 0);
        return;
    }

    public void com_android_settings_ConfirmLockPattern__onDestroy$___twin___() {
        super.onDestroy();
        unregisterReceiver(this.mReceiver);
    }

    @Insert("onCreate")
    public static void com_android_settings_ConfirmLockPattern_com_obric_hook_lancet_PrivacyHook_onCreate(ConfirmLockPattern r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ConfirmLockPattern r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_ConfirmLockPattern__onCreate$___twin___(r4);
    }

    @Insert("onDestroy")
    public static void com_android_settings_ConfirmLockPattern_com_obric_hook_lancet_PrivacyHook_onDestroy(ConfirmLockPattern r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ConfirmLockPattern r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_ConfirmLockPattern__onDestroy$___twin___();
    }
}
