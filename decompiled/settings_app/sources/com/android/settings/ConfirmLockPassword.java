package com.android.settings;

import android.animation.ObjectAnimator;
import android.app.StatusBarManager;
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
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.method.DigitsKeyListener;
import android.text.method.TextKeyListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.GlobalProxyLancet;
import com.android.internal.widget.LockPatternUtils;
import com.android.internal.widget.LockscreenCredential;
import com.android.internal.widget.TextViewInputDisabler;
import com.android.settings.applications.utils.XTSUtils;
import com.android.settings.base.BaseActivity;
import com.android.settings.fingerprint.FingerprintAuthenticateHelper;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.UIUtils;
import com.android.settingslib.animation.AppearAnimationUtils;
import com.android.settingslib.animation.DisappearAnimationUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.util.VibratorHelper;
import obric.util.WindowUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ConfirmLockPassword extends BaseActivity {
    private static final String TAG = "ConfirmLockPassword";
    private static int mThisLockType;
    private boolean mCloseWhenLocaleChange;
    private boolean mIsAllowFingerprint;
    protected BroadcastReceiver mReceiver;

    public static class ConfirmLockPasswordFragment extends Fragment implements View.OnClickListener, TextView.OnEditorActionListener, FingerprintAuthenticateHelper.Callback {
        private static final long ERROR_MESSAGE_TIMEOUT = 1000;
        private static final String KEY_NUM_WRONG_CONFIRM_ATTEMPTS = "confirm_lock_password_fragment.key_num_wrong_confirm_attempts";
        private static final int MSG_FINGERPRRINT_UNLOCK_SUCCESS = 11;
        private static final int MSG_RESET_UI_IF_ERROR = 10;
        private int EASY_PASSWORD_LENGTH;
        private final ImageView[] dots;
        private boolean isConfirmLauncherAppLock;
        private AppearAnimationUtils mAppearAnimationUtils;
        private boolean mBlockImm;
        private LinearLayout mBtn0;
        private LinearLayout mBtn1;
        private LinearLayout mBtn2;
        private LinearLayout mBtn3;
        private LinearLayout mBtn4;
        private LinearLayout mBtn5;
        private LinearLayout mBtn6;
        private LinearLayout mBtn7;
        private LinearLayout mBtn8;
        private LinearLayout mBtn9;
        private View mCancelView;
        private View mContinueButton;
        private CountDownTimer mCountdownTimer;
        private DisappearAnimationUtils mDisappearAnimationUtils;
        private ObjectAnimator mDotShakeAnim;
        private int mEffectiveUserId;
        private FingerprintAuthenticateHelper mFingerprintListenHelper;
        private FingerprintManager mFingerprintManager;
        private final Handler mHandler;
        private ObjectAnimator mHeaderTextShakeAnim;
        private TextView mHeaderTextView;
        private InputMethodManager mImm;
        private boolean mIsAllowFingerprint;
        private boolean mIsAlpha;
        private boolean mIsInSetupWizard;
        private boolean mIsManagedProfile;
        private boolean mIsPasswordVerified;
        private RelativeLayout mKeyboardView;
        private LockPatternUtils mLockPatternUtils;
        private InputPasswordMediator mMediator;
        private int mNumWrongConfirmAttempts;
        private LinearLayout mPasswordContainer;
        private EditText mPasswordEntry;
        private TextViewInputDisabler mPasswordEntryInputDisabler;
        private AsyncTask<?, ?, ?> mPendingLockCheck;
        private final Runnable mResetErrorRunnable;
        private boolean mReturnGatekeeperPassword;
        private StatusBarManager mStatusbarManager;
        private boolean mStoredCredentialIsPin;
        private int mUserId;
        private UserManager mUserManager;
        private boolean mUsingFingerprint;

        private boolean isPinQuality(int r1) {
            if (r1 != 131072) goto L5;
        L8:
            return true;
        L5:
            if (r1 == 196608) goto L8;
            return false;
        }

        @Override // com.android.settings.fingerprint.FingerprintAuthenticateHelper.Callback
        public void onAuthenticationAcquired(int r1) {
        }

        @Override // com.android.settings.fingerprint.FingerprintAuthenticateHelper.Callback
        public void onAuthenticationHelp(int r1, CharSequence r2) {
        }

        @Override // androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_ConfirmLockPassword$ConfirmLockPasswordFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_ConfirmLockPassword$ConfirmLockPasswordFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        static /* synthetic */ void access$1000(ConfirmLockPasswordFragment r0, boolean r1) {
            r0.updateInputArea(r1);
        }

        static /* synthetic */ View access$1100(ConfirmLockPasswordFragment r0) {
            return r0.mContinueButton;
        }

        static /* synthetic */ void access$1200(ConfirmLockPasswordFragment r0) {
            r0.handleNext();
        }

        static /* synthetic */ boolean access$1300(ConfirmLockPasswordFragment r0) {
            return r0.shouldAutoShowSoftKeyboard();
        }

        static /* synthetic */ void access$1400(ConfirmLockPasswordFragment r0) {
            r0.resetState();
        }

        static /* synthetic */ InputMethodManager access$1500(ConfirmLockPasswordFragment r0) {
            return r0.mImm;
        }

        static /* synthetic */ AsyncTask access$1602(ConfirmLockPasswordFragment r0, AsyncTask r1) {
            r0.mPendingLockCheck = r1;
            return r1;
        }

        static /* synthetic */ void access$1700(ConfirmLockPasswordFragment r0, boolean r1, Intent r2, int r3, int r4) {
            r0.onPasswordChecked(r1, r2, r3, r4);
        }

        static /* synthetic */ boolean access$1800(ConfirmLockPasswordFragment r0) {
            return r0.isInternalActivity();
        }

        static /* synthetic */ CountDownTimer access$1902(ConfirmLockPasswordFragment r0, CountDownTimer r1) {
            r0.mCountdownTimer = r1;
            return r1;
        }

        static /* synthetic */ void access$200(ConfirmLockPasswordFragment r0, CharSequence r1) {
            r0.updateHeaderText(r1);
        }

        static /* synthetic */ void access$2000(ConfirmLockPasswordFragment r0) {
            r0.resetView();
        }

        static /* synthetic */ LinearLayout access$2100(ConfirmLockPasswordFragment r0) {
            return r0.mPasswordContainer;
        }

        static /* synthetic */ ObjectAnimator access$2202(ConfirmLockPasswordFragment r0, ObjectAnimator r1) {
            r0.mDotShakeAnim = r1;
            return r1;
        }

        static /* synthetic */ boolean access$2300(ConfirmLockPasswordFragment r0) {
            return r0.isPasswordLockout();
        }

        static /* synthetic */ ObjectAnimator access$2402(ConfirmLockPasswordFragment r0, ObjectAnimator r1) {
            r0.mHeaderTextShakeAnim = r1;
            return r1;
        }

        static /* synthetic */ boolean access$300(ConfirmLockPasswordFragment r0) {
            return r0.mIsAlpha;
        }

        static /* synthetic */ void access$400(ConfirmLockPasswordFragment r0) {
            r0.resetIfPasswordError();
        }

        static /* synthetic */ void access$500(ConfirmLockPasswordFragment r0, Intent r1) {
            r0.startDisappearAnimation(r1);
        }

        static /* synthetic */ EditText access$700(ConfirmLockPasswordFragment r0) {
            return r0.mPasswordEntry;
        }

        static /* synthetic */ int access$800(ConfirmLockPasswordFragment r0) {
            return r0.EASY_PASSWORD_LENGTH;
        }

        static /* synthetic */ void access$900(ConfirmLockPasswordFragment r0, int r1, boolean r2) {
            r0.updateInputArea(r1, r2);
        }

        public ConfirmLockPasswordFragment() {
            this.mHandler = new AnonymousClass1(this);
            this.EASY_PASSWORD_LENGTH = 4;
            this.dots = new ImageView[6];
            this.mUsingFingerprint = false;
            this.mResetErrorRunnable = new AnonymousClass10(this);
        }

        public void com_android_settings_ConfirmLockPassword$ConfirmLockPasswordFragment__onCreate$___twin___(Bundle r4) {
            super.onCreate(r4);
            this.mUserManager = UserManager.get(getActivity());
            this.mLockPatternUtils = new LockPatternUtils(getActivity().getApplicationContext());
            int r0 = Utils.getUserIdFromBundle(getActivity(), getActivity().getIntent().getExtras());
            this.mUserId = r0;
            this.mEffectiveUserId = this.mUserManager.getCredentialOwnerProfile(r0);
            this.mIsManagedProfile = this.mUserManager.isManagedProfile(this.mUserId);
            if (r4 == null) goto L5;
            this.mNumWrongConfirmAttempts = r4.getInt(KEY_NUM_WRONG_CONFIRM_ATTEMPTS, 0);
        L5:
            FragmentActivity r5 = getActivity();
            this.isConfirmLauncherAppLock = r5.getIntent().getBooleanExtra("confirm_app_lock_password", false);
            this.mMediator = new InputPasswordMediator(r5);
            this.mFingerprintListenHelper = FingerprintAuthenticateHelper.getInstance(r5.getApplicationContext());
            this.mFingerprintManager = (FingerprintManager) r5.getSystemService("fingerprint");
            this.mIsAllowFingerprint = false;
            OLog.d("Fingerprint", "onCreate Fragment, mIsAllowFingerprint = " + this.mIsAllowFingerprint);
            this.mIsInSetupWizard = !Utils.isDeviceProvisioned(r5);
            this.mReturnGatekeeperPassword = r5.getIntent().getBooleanExtra("request_gk_pw_handle", false);
            OLog.w(ConfirmLockPassword.access$000(), "ConfirmLockPasswordFragment onCreate");
        }

        @Override // androidx.fragment.app.Fragment
        public View onCreateView(LayoutInflater r29, ViewGroup r30, Bundle r31) {
            int r1 = this.mLockPatternUtils.getKeyguardStoredPasswordQuality(this.mEffectiveUserId);
            View r2 = r29.inflate(R.layout.confirm_lock_password, null);
            ((FrameLayout) r2.findViewById(R.id.pin_keyboard_layout)).addView(UIUtils.buildNoScaledView(getActivity(), R.layout.pin_keyboard_layout));
            View r4 = r2.findViewById(R.id.xts_enterprise_icon);
            if (r4 != null) goto L5;
        L11:
            OFloatingTitleBar r5 = (OFloatingTitleBar) r2.findViewById(R.id.view_title);
            View r7 = r5.addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, null);
            this.mCancelView = r7;
            r7.setOnClickListener(this);
            EditText r8 = (EditText) r2.findViewById(R.id.passwordEntry);
            this.mPasswordEntry = r8;
            r8.setOnEditorActionListener(this);
            this.mPasswordEntryInputDisabler = new TextViewInputDisabler(this.mPasswordEntry);
            this.mKeyboardView = (RelativeLayout) r2.findViewById(R.id.keyboard);
            this.mHeaderTextView = (TextView) r2.findViewById(R.id.headerText);
            this.mStoredCredentialIsPin = isPinQuality(r1);
            if (262144 != r1) goto L14;
        L21:
            boolean r3 = true;
        L22:
            this.mIsAlpha = r3;
            if (this.mIsInSetupWizard == false) goto L25;
            StatusBarManager r6 = (StatusBarManager) getActivity().getApplicationContext().getSystemService("statusbar");
            this.mStatusbarManager = r6;
            r6.disable(18874368);
        L25:
            getActivity().getContentResolver();
            if (this.mIsAlpha == false) goto L29;
            this.EASY_PASSWORD_LENGTH = 4;
            ConfirmLockPassword.access$602(4);
        L38:
            OLog.d("Settings", "EASY_PASSWORD_LENGTH " + this.EASY_PASSWORD_LENGTH);
            this.mImm = (InputMethodManager) getActivity().getSystemService("input_method");
            Intent r9 = getActivity().getIntent();
            if (r9 == null) goto L48;
            CharSequence r13 = r9.getCharSequenceExtra(ConfirmDeviceCredentialBaseFragment.HEADER_TEXT);
            CharSequence r10 = r9.getCharSequenceExtra(ConfirmDeviceCredentialBaseFragment.DETAILS_TEXT);
            if (TextUtils.isEmpty(r13) == false) goto L44;
            r13 = getString(getDefaultHeader());
        L44:
            if (TextUtils.isEmpty(r10) == false) goto L46;
            getString(getDefaultDetails());
        L46:
            updateHeaderText(r13);
        L48:
            if (this.mIsAlpha == false) goto L50;
            this.mPasswordEntry.setFilters(new InputFilter[]{new InputFilter.LengthFilter(16)});
        L51:
            this.mAppearAnimationUtils = new AppearAnimationUtils(getContext(), 220, 2.0f, 1.0f, AnimationUtils.loadInterpolator(getContext(), 17563662));
            this.mDisappearAnimationUtils = new DisappearAnimationUtils(getContext(), 110, 1.0f, 0.5f, AnimationUtils.loadInterpolator(getContext(), 17563663));
            this.mKeyboardView.requestFocus();
            if (this.mIsAlpha == false) goto L55;
            View r11 = r5.addEndAction(getString(R.string.lockpassword_continue_label), -1, null);
            this.mContinueButton = r11;
            r11.setOnClickListener(this);
            this.mContinueButton.setEnabled(false);
            setTextColor(getContext().getColor(R.color.oui_functional_blue_6));
        L55:
            if (this.mIsAlpha == false) goto L57;
            this.mKeyboardView.setVisibility(8);
        L59:
            if (this.mIsAlpha == false) goto L61;
            this.mPasswordEntry.setFocusable(true);
            this.mPasswordEntry.requestFocus();
            this.mPasswordEntry.setKeyListener(TextKeyListener.getInstance());
            this.mPasswordEntry.setInputType(129);
        L62:
            this.mPasswordEntry.addTextChangedListener(new AnonymousClass4(this));
            LinearLayout r12 = (LinearLayout) r2.findViewById(R.id.password_container);
            this.mPasswordContainer = r12;
            if (this.mIsAlpha == false) goto L65;
            r12.removeAllViews();
            this.mPasswordContainer.setVisibility(8);
        L68:
            OLog.w(ConfirmLockPassword.access$000(), "ConfirmLockPasswordFragment onCreateView");
            return r2;
        L65:
            this.mBtn1 = (LinearLayout) r2.findViewById(R.id.easy_password_keyboard_1);
            this.mBtn2 = (LinearLayout) r2.findViewById(R.id.easy_password_keyboard_2);
            this.mBtn3 = (LinearLayout) r2.findViewById(R.id.easy_password_keyboard_3);
            this.mBtn4 = (LinearLayout) r2.findViewById(R.id.easy_password_keyboard_4);
            this.mBtn5 = (LinearLayout) r2.findViewById(R.id.easy_password_keyboard_5);
            this.mBtn6 = (LinearLayout) r2.findViewById(R.id.easy_password_keyboard_6);
            this.mBtn7 = (LinearLayout) r2.findViewById(R.id.easy_password_keyboard_7);
            this.mBtn8 = (LinearLayout) r2.findViewById(R.id.easy_password_keyboard_8);
            this.mBtn9 = (LinearLayout) r2.findViewById(R.id.easy_password_keyboard_9);
            this.mBtn0 = (LinearLayout) r2.findViewById(R.id.easy_password_keyboard_0);
            this.mBtn1.setOnClickListener(this);
            this.mBtn2.setOnClickListener(this);
            this.mBtn3.setOnClickListener(this);
            this.mBtn4.setOnClickListener(this);
            this.mBtn5.setOnClickListener(this);
            this.mBtn6.setOnClickListener(this);
            this.mBtn7.setOnClickListener(this);
            this.mBtn8.setOnClickListener(this);
            this.mBtn9.setOnClickListener(this);
            this.mBtn0.setOnClickListener(this);
            this.dots[0] = (ImageView) r2.findViewById(R.id.easy_password_no_1);
            this.dots[1] = (ImageView) r2.findViewById(R.id.easy_password_no_2);
            this.dots[2] = (ImageView) r2.findViewById(R.id.easy_password_no_3);
            this.dots[3] = (ImageView) r2.findViewById(R.id.easy_password_no_4);
            this.dots[4] = (ImageView) r2.findViewById(R.id.easy_password_no_5);
            this.dots[5] = (ImageView) r2.findViewById(R.id.easy_password_no_6);
            updateInputArea(-1, true);
            InputPasswordMediator r14 = this.mMediator;
            if (r14 == null) goto L68;
            r14.setSoundEffectsEnabled(false, new View[]{this.mBtn1, this.mBtn2, this.mBtn3, this.mBtn4, this.mBtn5, this.mBtn6, this.mBtn7, this.mBtn8, this.mBtn9, this.mBtn0});
            goto L68
        L61:
            this.mPasswordEntry.setVisibility(4);
            this.mPasswordEntry.setKeyListener(DigitsKeyListener.getInstance());
            this.mPasswordEntry.setInputType(18);
            getActivity().getWindow().setSoftInputMode(3);
            goto L62
        L57:
            this.mKeyboardView.setVisibility(0);
            r2.findViewById(R.id.pinDel).setOnClickListener(new AnonymousClass3(this));
            goto L59
        L50:
            this.mPasswordEntry.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.EASY_PASSWORD_LENGTH)});
            this.mPasswordEntry.setOnTouchListener(new AnonymousClass2(this));
            goto L51
        L29:
            if (this.isConfirmLauncherAppLock == true) goto L38;
            int r15 = (int) LockPatternUtilsOnly.getPasswordLengthBytedance(this.mLockPatternUtils, this.mUserId);
            this.EASY_PASSWORD_LENGTH = r15;
            if (r15 == 4) goto L34;
            if (r15 == 6) goto L34;
            this.mIsAlpha = true;
            this.EASY_PASSWORD_LENGTH = 4;
            ConfirmLockPassword.access$602(4);
        L34:
            if (r15 != 4) goto L36;
            int r16 = 2;
        L37:
            ConfirmLockPassword.access$602(r16);
            goto L38
        L36:
            r16 = 3;
            goto L37
        L14:
            if (327680 == r1) goto L21;
            if (393216 == r1) goto L21;
            if (524288 == r1) goto L21;
            r3 = false;
            goto L22
        L5:
            if (XTSUtils.isInXtsMode() == true) goto L7;
        L9:
            int r17 = 8;
        L10:
            r4.setVisibility(r17);
            goto L11
        L7:
            if (this.mIsManagedProfile == false) goto L9;
            r17 = 0;
            goto L10
        }

        @Override // androidx.fragment.app.Fragment
        public void onViewCreated(View r1, Bundle r2) {
            super.onViewCreated(r1, r2);
            UIUtils.fitMaskTitleInCommon((ViewGroup) r1, r1.findViewById(R.id.title));
        }

        private void setTextColor(int r2) {
            View r1 = this.mContinueButton;
            if (r1 != null) goto L5;
            return;
        L5:
            if ((r1 instanceof ViewGroup) == false) goto L13;
            View r3 = ((ViewGroup) r1).getChildAt(0);
            if ((r3 instanceof TextView) == false) goto L12;
            ((TextView) r3).setTextColor(r2);
            return;
        L12:
            return;
        }

        private int getDefaultHeader() {
            if (this.mIsAllowFingerprint == true) goto L5;
            FingerprintManager r1 = this.mFingerprintManager;
            if (r1 != null) goto L12;
            return R.string.lockpassword_confirm_your_password_header;
        L12:
            if (r1.hasEnrolledFingerprints() == false) goto L18;
            return R.string.lockpassword_confirm_your_password_header_fingerprints;
        L18:
            return R.string.lockpassword_confirm_your_password_header;
        L5:
            if (this.mFingerprintListenHelper.isFingerprintUnlockLockout() == false) goto L7;
            return R.string.fingerprint_lockout_error;
        L7:
            return R.string.unlock_with_password_or_fingerprint;
        }

        private int getDefaultDetails() {
            if (this.mIsAlpha == false) goto L5;
            return R.string.lockpassword_confirm_your_password_generic;
        L5:
            return R.string.lockpassword_confirm_your_pin_generic;
        }

        private int getErrorMessage() {
            if (this.mIsAlpha == false) goto L5;
            return R.string.lockpassword_invalid_password;
        L5:
            return R.string.lockpassword_invalid_pin;
        }

        private View[] getActiveViews() {
            ArrayList r0 = new ArrayList();
            r0.add(this.mHeaderTextView);
            if (this.mCancelView.getVisibility() != 0) goto L5;
            r0.add(this.mCancelView);
        L5:
            r0.add(this.mPasswordEntry);
            return (View[]) r0.toArray(new View[0]);
        }

        @Override // androidx.fragment.app.Fragment
        public void onPause() {
            super.onPause();
            AsyncTask<?, ?, ?> r0 = this.mPendingLockCheck;
            if (r0 == null) goto L6;
            r0.cancel(false);
            this.mPendingLockCheck = null;
        L6:
            if (this.mIsAllowFingerprint == false) goto L9;
            this.mFingerprintListenHelper.stopAuthenticate();
            return;
        }

        public void com_android_settings_ConfirmLockPassword$ConfirmLockPasswordFragment__onResume$___twin___() {
            super.onResume();
            long r0 = this.mLockPatternUtils.getLockoutAttemptDeadline(this.mEffectiveUserId);
            if (this.mCountdownTimer == null) goto L5;
            boolean r2 = true;
        L7:
            if (r0 == 0) goto L13;
            if (r2 == true) goto L13;
            if (this.mIsAlpha == true) goto L12;
            this.mKeyboardView.setVisibility(8);
        L12:
            handleAttemptLockout(r0);
        L16:
            if (this.mIsAllowFingerprint == false) goto L19;
            this.mFingerprintListenHelper.startAuthenticate(this);
            return;
        L19:
            return;
        L13:
            if (r2 == true) goto L16;
            resetState();
            resetView();
            goto L16
        L5:
            r2 = false;
            goto L7
        }

        @Override // androidx.fragment.app.Fragment
        public void onSaveInstanceState(Bundle r2) {
            super.onSaveInstanceState(r2);
            r2.putInt(KEY_NUM_WRONG_CONFIRM_ATTEMPTS, this.mNumWrongConfirmAttempts);
        }

        private void resetState() {
            if (this.mBlockImm == false) goto L5;
            return;
        L5:
            this.mPasswordEntry.setEnabled(true);
            this.mPasswordEntryInputDisabler.setInputEnabled(true);
            if (shouldAutoShowSoftKeyboard() == false) goto L9;
            this.mImm.showSoftInput(this.mPasswordEntry, 1);
            return;
        }

        private void resetView() {
            updateHeaderText(null);
            if (this.mIsAlpha == true) goto L5;
            this.mKeyboardView.setVisibility(0);
        L5:
            this.mNumWrongConfirmAttempts = 0;
        }

        private boolean shouldAutoShowSoftKeyboard() {
            if (this.mPasswordEntry.isEnabled() == true) goto L5;
        L7:
            return false;
        L5:
            if (this.mUsingFingerprint == true) goto L7;
            return true;
        }

        public void onWindowFocusChanged(boolean r2) {
            if (r2 == true) goto L4;
            return;
        L4:
            if (this.mBlockImm == true) goto L9;
            this.mPasswordEntry.post(new AnonymousClass5(this));
            return;
        }

        @Override // androidx.fragment.app.Fragment
        public void onDestroy() {
            super.onDestroy();
            InputPasswordMediator r0 = this.mMediator;
            if (r0 == null) goto L5;
            r0.release();
        L5:
            CountDownTimer r1 = this.mCountdownTimer;
            if (r1 == null) goto L9;
            r1.cancel();
            this.mCountdownTimer = null;
        L9:
            if (this.mIsInSetupWizard == false) goto L12;
            this.mStatusbarManager.disable(0);
            return;
        }

        public boolean isFragmentInvisible() {
            if (getActivity() != null) goto L5;
        L8:
            return true;
        L5:
            if (isAdded() == false) goto L8;
            return false;
        }

        private void handleNext() {
            this.mPasswordEntryInputDisabler.setInputEnabled(false);
            AsyncTask<?, ?, ?> r0 = this.mPendingLockCheck;
            if (r0 == null) goto L5;
            r0.cancel(false);
        L5:
            String r1 = this.mPasswordEntry.getText().toString();
            OLog.w(ConfirmLockPassword.access$000(), "handleNext: isConfirmLauncherAppLock = " + this.isConfirmLauncherAppLock);
            if (this.isConfirmLauncherAppLock == false) goto L15;
            if (AppLockUtil.checkPassword(getActivity(), r1) == false) goto L13;
            OLog.w(ConfirmLockPassword.access$000(), "handleNext: isConfirmLauncherAppLock checkPassword");
            Intent r2 = new Intent();
            r2.putExtra("request_code", -1);
            Intent r3 = getActivity().getIntent();
            if (r3 == null) goto L12;
            r2.putExtra("request_code", r3.getIntExtra("request_code", -1));
        L12:
            getActivity().setResult(-1, r2);
            getActivity().finish();
            return;
        L13:
            OLog.w(ConfirmLockPassword.access$000(), "handleNext: isConfirmLauncherAppLock before showError");
            this.mPasswordEntry.setKeyListener(null);
            showError();
            return;
        L15:
            if (this.mReturnGatekeeperPassword == false) goto L17;
            startVerifyPassword(r1, new Intent());
            return;
        L17:
            boolean r4 = getActivity().getIntent().getBooleanExtra(ChooseLockSettingsHelper.EXTRA_KEY_HAS_CHALLENGE, false);
            OLog.w(ConfirmLockPassword.access$000(), "handleNext: verifyChallenge = " + r4);
            Intent r5 = new Intent();
            if (r4 == false) goto L25;
            OLog.w(ConfirmLockPassword.access$000(), "handleNext isInternalActivity():" + isInternalActivity());
            if (isInternalActivity() == false) goto L23;
            OLog.w(ConfirmLockPassword.access$000(), "handleNext before startVerifyPassword");
            startVerifyPassword(r1, r5);
            return;
        L23:
            OLog.w(ConfirmLockPassword.access$000(), "handleNext: before onPasswordChecked");
            onPasswordChecked(false, r5, 0, this.mEffectiveUserId);
            return;
        L25:
            OLog.w(ConfirmLockPassword.access$000(), "handleNext: before startCheckPassword");
            startCheckPassword(r1, r5);
        }

        private boolean isInternalActivity() {
            return getActivity() instanceof InternalActivity;
        }

        private LockscreenCredential createEnteredCredential(String r1) {
            if (this.mStoredCredentialIsPin == false) goto L6;
            return LockscreenCredential.createPin(r1);
        L6:
            return LockscreenCredential.createPassword(r1);
        }

        private void startVerifyPassword(String r11, final Intent r12) {
            OLog.w(ConfirmLockPassword.access$000(), "startVerifyPassword");
            long r6 = getActivity().getIntent().getLongExtra("challenge", 0);
            final int r8 = this.mEffectiveUserId;
            final LockscreenCredential r0 = createEnteredCredential(r11);
            this.mPendingLockCheck = LockPatternCheckerOnly.verifyPassword(this.mLockPatternUtils, r11, r6, r8, new AnonymousClass6(this, r12, r0, r8));
        }

        private void startCheckPassword(String r5, final Intent r6) {
            OLog.w(ConfirmLockPassword.access$000(), "startCheckPassword");
            final int r0 = this.mEffectiveUserId;
            final LockscreenCredential r1 = createEnteredCredential(r5);
            this.mPendingLockCheck = LockPatternCheckerOnly.checkPassword(this.mLockPatternUtils, r5, r0, new AnonymousClass7(this, r6, r1, r0));
        }

        private void startDisappearAnimation(final Intent r5) {
            if (isFragmentInvisible() == false) goto L6;
            OLog.w(ConfirmLockPassword.access$000(), "startDisappearAnimation return");
            return;
        L6:
            final FragmentActivity r0 = getActivity();
            if (r0 != null) goto L10;
            OLog.w(ConfirmLockPassword.access$000(), "startDisappearAnimation, fragmentActivity is null, return");
            return;
        L10:
            this.mIsPasswordVerified = true;
            r5.putExtra("request_code", -1);
            if (r0.getIntent() == null) goto L14;
            r5.putExtra("request_code", r0.getIntent().getIntExtra("request_code", -1));
        L14:
            if (r0.getThemeResId() != 2132019029) goto L16;
            this.mDisappearAnimationUtils.startAnimation(getActiveViews(), new AnonymousClass8(this, r0, r5));
            return;
        L16:
            OLog.w(ConfirmLockPassword.access$000(), "startDisappearAnimation finish");
            r0.setResult(-1, r5);
            r0.finish();
        }

        private void onPasswordChecked(boolean r4, Intent r5, int r6, int r7) {
            if (isFragmentInvisible() == false) goto L6;
            OLog.w(ConfirmLockPassword.access$000(), "onPasswordChecked return");
            return;
        L6:
            this.mPasswordEntryInputDisabler.setInputEnabled(true);
            OLog.w(ConfirmLockPassword.access$000(), "onPasswordChecked matched:" + r4 + ",timeoutMs:" + r6);
            if (r4 == false) goto L9;
            startDisappearAnimation(r5);
            VibratorHelper.INSTANCE.confirm(getActivity());
            return;
        L9:
            if (r6 > 0) goto L11;
            OLog.w(ConfirmLockPassword.access$000(), "onPasswordChecked before showError");
            showError();
            return;
        L11:
            if (this.mHandler.hasMessages(10) == false) goto L13;
            OLog.w(ConfirmLockPassword.access$000(), "onPasswordChecked removeMessages");
            this.mHandler.removeMessages(10);
        L13:
            Utils.vibratorUnlockNoPass(getActivity());
            handleAttemptLockout(this.mLockPatternUtils.setLockoutAttemptDeadline(r7, r6));
            if (this.mIsAlpha == true) goto L16;
            OLog.w(ConfirmLockPassword.access$000(), "onPasswordChecked before playDotShakeAnim");
            this.mKeyboardView.setVisibility(8);
            playDotShakeAnim();
            return;
        L16:
            OLog.w(ConfirmLockPassword.access$000(), "onPasswordChecked before playHeaderTextViewAnim");
            playHeaderTextViewAnim();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [com.android.settings.ConfirmLockPassword$ConfirmLockPasswordFragment$9] */
        private void handleAttemptLockout(long r11) {
            long r0 = SystemClock.elapsedRealtime();
            this.mPasswordEntry.setText("");
            this.mPasswordEntry.setEnabled(false);
            final long r6 = r11 - r0;
            final long r8 = 1000;
            this.mCountdownTimer = new AnonymousClass9(this, r6, r8).start();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r4) {
            if (this.mContinueButton != r4) goto L6;
            handleNext();
            return;
        L6:
            if (this.mCancelView != r4) goto L13;
            Intent r5 = new Intent();
            r5.putExtra("request_code", -1);
            if (getActivity() != null) goto L10;
        L12:
            getActivity().setResult(0, r5);
            getActivity().finish();
            return;
        L10:
            if (getActivity().getIntent() == null) goto L12;
            r5.putExtra("request_code", getActivity().getIntent().getIntExtra("request_code", -1));
            goto L12
        L13:
            ObjectAnimator r0 = this.mDotShakeAnim;
            if (r0 == null) goto L19;
            if (r0.isRunning() == false) goto L19;
            return;
        L19:
            if (this.mHandler.hasMessages(10) == false) goto L21;
            this.mHandler.removeMessages(10);
            resetIfPasswordError();
        L21:
            Editable r1 = this.mPasswordEntry.getEditableText();
            if (r4 != this.mBtn1) goto L25;
            r1.append("1");
        L51:
            this.mMediator.playPinKeyboardSound();
            return;
        L25:
            if (r4 != this.mBtn2) goto L28;
            r1.append(ExifInterface.GPS_MEASUREMENT_2D);
            goto L51
        L28:
            if (r4 != this.mBtn3) goto L31;
            r1.append(ExifInterface.GPS_MEASUREMENT_3D);
            goto L51
        L31:
            if (r4 != this.mBtn4) goto L34;
            r1.append("4");
            goto L51
        L34:
            if (r4 != this.mBtn5) goto L37;
            r1.append("5");
            goto L51
        L37:
            if (r4 != this.mBtn6) goto L40;
            r1.append("6");
            goto L51
        L40:
            if (r4 != this.mBtn7) goto L43;
            r1.append("7");
            goto L51
        L43:
            if (r4 != this.mBtn8) goto L46;
            r1.append("8");
            goto L51
        L46:
            if (r4 != this.mBtn9) goto L49;
            r1.append("9");
            goto L51
        L49:
            if (r4 != this.mBtn0) goto L51;
            r1.append("0");
            goto L51
        }

        private void showError() {
            updateHeaderText(true);
            if (getActivity() == null) goto L6;
            Utils.vibratorUnlockNoPass(getActivity());
        L6:
            if (this.mIsAlpha == false) goto L8;
            playHeaderTextViewAnim();
            resetIfPasswordError();
            return;
        L8:
            playDotShakeAnim();
        }

        private void showError(int r3) {
            showError(r3, 1000);
        }

        private void showError(CharSequence r3, long r4) {
            this.mHeaderTextView.setText(r3);
            this.mPasswordEntry.setText(null);
            if (this.mIsAlpha == false) goto L5;
            resetIfPasswordError();
        L6:
            this.mHandler.removeCallbacks(this.mResetErrorRunnable);
            if (r4 == 0) goto L10;
            this.mHandler.postDelayed(this.mResetErrorRunnable, r4);
            return;
        L10:
            return;
        L5:
            updateInputArea(-1, false);
            goto L6
        }

        private void showError(int r1, long r2) {
            showError(getText(r1), r2);
        }

        private void resetIfPasswordError() {
            if (isAdded() == false) goto L9;
            this.mPasswordEntry.setKeyListener(TextKeyListener.getInstance());
            this.mPasswordEntry.setText("");
            this.mPasswordEntry.setInputType(128);
            if (this.mIsAlpha == false) goto L7;
            this.mPasswordEntry.setInputType(129);
            this.mImm.showSoftInput(this.mPasswordEntry, 1);
            return;
        L7:
            this.mPasswordEntry.setInputType(18);
            return;
        }

        private void updateHeaderText(CharSequence r2) {
            if (TextUtils.isEmpty(r2) == false) goto L5;
            this.mHeaderTextView.setText(getDefaultHeader());
        L7:
            if (isPasswordLockout() == false) goto L9;
        L14:
            boolean r3 = true;
        L15:
            setupHeaderViewColor(r3);
            if (this.mIsManagedProfile == true) goto L18;
            return;
        L18:
            if (getView() == null) goto L26;
            TextView r4 = (TextView) getView().findViewById(R.id.title);
            if (r4 != null) goto L22;
            return;
        L22:
            if (getHeaderText() == null) goto L28;
            r4.setText(getHeaderText());
            return;
        L28:
            return;
        L26:
            return;
        L9:
            if (this.mIsAllowFingerprint == true) goto L11;
        L13:
            r3 = false;
            goto L15
        L11:
            if (this.mFingerprintListenHelper.isFingerprintUnlockLockout() == false) goto L13;
        L5:
            this.mHeaderTextView.setText(r2);
            goto L7
        }

        private CharSequence getHeaderText() {
            if (getActivity() != null) goto L5;
            return null;
        L5:
            if (getActivity().getIntent() == null) goto L13;
            Intent r0 = getActivity().getIntent();
            CharSequence r1 = r0.getCharSequenceExtra(ConfirmDeviceCredentialBaseFragment.HEADER_TEXT);
            r0.getCharSequenceExtra(ConfirmDeviceCredentialBaseFragment.DETAILS_TEXT);
            if (TextUtils.isEmpty(r1) == true) goto L9;
            return r1;
        L9:
            return getString(getDefaultHeader());
        L13:
            return null;
        }

        private void updateHeaderText(boolean r2) {
            updateHeaderText(r2, false);
        }

        private void updateHeaderText(boolean r2, boolean r3) {
            if (isAdded() == true) goto L5;
            return;
        L5:
            if (r2 == false) goto L11;
            TextView r0 = this.mHeaderTextView;
            if (r3 == false) goto L9;
            int r4 = R.string.retry_again;
        L10:
            r0.setText(r4);
        L12:
            setupHeaderViewColor(r2);
            return;
        L9:
            r4 = R.string.lockpassword_confirm_passwords_dont_match;
            goto L10
        L11:
            this.mHeaderTextView.setText(getDefaultHeader());
            goto L12
        }

        private void setupHeaderViewColor(boolean r2) {
            if (r2 == false) goto L4;
            int r3 = R.color.lock_screen_header_warning_text_color;
        L5:
            this.mHeaderTextView.setTextColor(getResources().getColor(r3));
            return;
        L4:
            r3 = R.color.lock_screen_header_normal_text_color;
            goto L5
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView r1, int r2, KeyEvent r3) {
            if (r2 == 0) goto L11;
            if (r2 == 6) goto L11;
            if (r2 == 5) goto L11;
            return false;
        L11:
            if (TextUtils.isEmpty(this.mPasswordEntry.getText().toString()) == true) goto L14;
            handleNext();
            return true;
        L14:
            return false;
        }

        private void updateInputArea(boolean r3) {
            if (r3 == true) goto L11;
            int r4 = 0;
        L6:
            if (r4 >= this.mPasswordContainer.getChildCount()) goto L15;
            ImageView r0 = (ImageView) this.mPasswordContainer.getChildAt(r4);
            if (r0 == null) goto L10;
            r0.setImageResource(R.drawable.easy_password_dot_error);
        L10:
            r4 = r4 + 1;
            goto L6
        L15:
            return;
        }

        private void updateInputArea(int r5, boolean r6) {
            int r1 = 0;
            if (this.EASY_PASSWORD_LENGTH != 4) goto L5;
            r5 = r5 + 1;
            this.dots[0].setVisibility(4);
            ImageView[] r0 = this.dots;
            r0[r0.length - 1].setVisibility(4);
        L6:
            if (r6 == false) goto L13;
        L7:
            ImageView[] r7 = this.dots;
            if (r1 >= r7.length) goto L16;
            if (r1 >= r5) goto L11;
            r7[r1].setImageResource(R.drawable.easy_password_dot_full);
        L12:
            r1 = r1 + 1;
            goto L7
        L11:
            r7[r1].setImageResource(R.drawable.easy_password_dot_empty);
            goto L12
        L16:
            return;
        L13:
            ImageView[] r8 = this.dots;
            if (r1 >= r8.length) goto L21;
            r8[r1].setImageResource(R.drawable.easy_password_dot_error);
            r1 = r1 + 1;
            goto L13
        L21:
            return;
        L5:
            this.dots[0].setVisibility(0);
            ImageView[] r2 = this.dots;
            r2[r2.length - 1].setVisibility(0);
            goto L6
        }

        private boolean isFingerprintUnlockAvailable() {
            boolean r0 = this.mFingerprintListenHelper.isFingerprintUnlockLockout();
            if (this.mIsAllowFingerprint == false) goto L6;
            if (r0 == true) goto L6;
            boolean r3 = true;
        L7:
            OLog.d("Fingerprint", "fingerprint lockout: " + r0 + ", isFingerprintUnlockAvailable: " + r3);
            return r3;
        L6:
            r3 = false;
            goto L7
        }

        @Override // com.android.settings.fingerprint.FingerprintAuthenticateHelper.Callback
        public void onAuthenticationSucceeded(int r3) {
            if (isPasswordLockout() == false) goto L6;
            playHeaderTextViewAnim();
            Utils.vibratorUnlockNoPass(getActivity());
            return;
        L6:
            if (this.mIsAlpha == false) goto L8;
            startDisappearAnimation(new Intent());
            return;
        L8:
            updateInputArea(this.dots.length, true);
            this.mHandler.sendEmptyMessageDelayed(11, 200);
        }

        @Override // com.android.settings.fingerprint.FingerprintAuthenticateHelper.Callback
        public void onAuthenticationFailed() {
            Utils.vibratorUnlockNoPass(getActivity());
            if (isPasswordLockout() == false) goto L5;
            playHeaderTextViewAnim();
            return;
        L5:
            updateHeaderText(true, true);
            if (this.mIsAlpha == false) goto L8;
            playHeaderTextViewAnim();
            return;
        L8:
            playDotShakeAnim();
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
            updateHeaderText(null);
        L13:
            FragmentActivity r1 = getActivity();
            if (r1 == null) goto L16;
            Utils.vibratorUnlockNoPass(r1);
        L16:
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
        public void onAuthenticationError(int r2, CharSequence r3) {
            if (r2 != 7) goto L12;
            if (this.mHandler.hasMessages(10) == false) goto L8;
            this.mHandler.removeMessages(10);
        L8:
            if (isPasswordLockout() == true) goto L10;
            updateHeaderText(null);
        L10:
            Utils.vibratorUnlockNoPass(getActivity());
            playHeaderTextViewAnim();
            return;
        L12:
            if (r2 == 10003) goto L14;
            return;
        L14:
            if (isPasswordLockout() == true) goto L19;
            updateHeaderText(null);
            return;
        }

        @Override // com.android.settings.fingerprint.FingerprintAuthenticateHelper.Callback
        public void onFingerprintLockoutReset() {
            if (isAdded() == true) goto L5;
            return;
        L5:
            String r0 = getString(R.string.unlock_with_password_or_fingerprint);
            String r1 = getString(R.string.fingerprint_lockout_error);
            String r2 = this.mHeaderTextView.getText().toString();
            if (TextUtils.equals(r0, r2) == false) goto L8;
        L9:
            updateHeaderText(null);
            return;
        L8:
            if (TextUtils.equals(r1, r2) == true) goto L9;
        }

        private void playDotShakeAnim() {
            updateInputArea(4, false);
            ObjectAnimator r0 = this.mDotShakeAnim;
            if (r0 != null) goto L5;
        L7:
            ObjectAnimator r1 = Utils.createShakeAnim(this.mPasswordContainer, new AnonymousClass11(this));
            this.mDotShakeAnim = r1;
            r1.start();
            return;
        L5:
            if (r0.isRunning() == false) goto L7;
        }

        private void playHeaderTextViewAnim() {
            ObjectAnimator r0 = this.mHeaderTextShakeAnim;
            if (r0 != null) goto L5;
        L7:
            ObjectAnimator r1 = Utils.createShakeAnim(this.mHeaderTextView, new AnonymousClass12(this));
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

        @Override // androidx.fragment.app.Fragment
        public void onStop() {
            super.onStop();
            if (this.mIsPasswordVerified == false) goto L5;
            return;
        L5:
            if (AdapterActivity.isWalletVerifyPassword() == false) goto L13;
            OLog.d("Settings", "exit_when_invisible");
            if (Utils.isScreenOn(getActivity()) == false) goto L9;
            long r0 = 0;
        L10:
            this.mHandler.postDelayed(new AnonymousClass13(this), r0);
            return;
        L9:
            r0 = 300;
            goto L10
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_ConfirmLockPassword$ConfirmLockPasswordFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ConfirmLockPasswordFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_ConfirmLockPassword$ConfirmLockPasswordFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_ConfirmLockPassword$ConfirmLockPasswordFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ConfirmLockPasswordFragment r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_ConfirmLockPassword$ConfirmLockPasswordFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_ConfirmLockPassword$ConfirmLockPasswordFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ConfirmLockPasswordFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_ConfirmLockPassword$ConfirmLockPasswordFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    public static class InternalActivity extends ConfirmLockPassword {
        public void com_android_settings_ConfirmLockPassword$InternalActivity__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_ConfirmLockPassword$InternalActivity__onPause$___twin___() {
            super.onPause();
        }

        public void com_android_settings_ConfirmLockPassword$InternalActivity__onResume$___twin___() {
            super.onResume();
        }

        public void com_android_settings_ConfirmLockPassword$InternalActivity__onStop$___twin___() {
            super.onStop();
        }

        public void com_android_settings_ConfirmLockPassword$InternalActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
            super.startActivityForResult(r1, r2, r3);
        }

        @Override // com.android.settings.ConfirmLockPassword, com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle r1) {
            com_android_settings_ConfirmLockPassword$InternalActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
        }

        @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
        public void onPause() {
            com_android_settings_ConfirmLockPassword$InternalActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
        }

        @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
        public void onResume() {
            com_android_settings_ConfirmLockPassword$InternalActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
        }

        @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
        public void onStop() {
            com_android_settings_ConfirmLockPassword$InternalActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
        }

        @Override // androidx.activity.ComponentActivity, android.app.Activity
        public void startActivityForResult(Intent r1, int r2, Bundle r3) {
            com_android_settings_ConfirmLockPassword$InternalActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
        }

        public InternalActivity() {
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
        @Insert(mayCreateSuper = true, value = "onStop")
        public static void com_android_settings_ConfirmLockPassword$InternalActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(InternalActivity r1) {
            com_android_settings_ConfirmLockPassword$InternalActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
            if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
            return;
        L8:
            r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
            return;
        }

        @Insert("onCreate")
        public static void com_android_settings_ConfirmLockPassword$InternalActivity_com_obric_hook_lancet_PrivacyHook_onCreate(InternalActivity r3, Bundle r4) {
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
            InternalActivity r0 = r3;
            if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
            r0.onCreateWhenPrivacyNotOk(null);
            r0.onSuperCreate(null);
            return;
        L6:
            GrantUtil.INSTANCE.applicationInit();
            r3.com_android_settings_ConfirmLockPassword$InternalActivity__onCreate$___twin___(r4);
        }

        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_ConfirmLockPassword$InternalActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(InternalActivity r1) {
            String r0 = r1.getClass().getName();
            com_android_settings_ConfirmLockPassword$InternalActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            AppMetricsUtils.INSTANCE.activityEventEnd(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_ConfirmLockPassword$InternalActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(InternalActivity r4) {
            String r0 = r4.getClass().getName();
            com_android_settings_ConfirmLockPassword$InternalActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
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
        public static void com_android_settings_ConfirmLockPassword$InternalActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(InternalActivity r2, Intent r3, int r4, Bundle r5) {
            Intrinsics.checkNotNullParameter(r3, "intent");
            String r0 = r2.getClass().getName();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
            AppMetricsUtils.INSTANCE.activityEventStart(r0);
        L5:
            r2.com_android_settings_ConfirmLockPassword$InternalActivity__startActivityForResult$___twin___(r3, r4, r5);
        }

        @Insert(mayCreateSuper = true, value = "onStop")
        public static void com_android_settings_ConfirmLockPassword$InternalActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(InternalActivity r2) {
            String r0 = r2.getClass().getName();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
            AppMetricsUtils.INSTANCE.activityEventStoped(r0);
        L5:
            com_android_settings_ConfirmLockPassword$InternalActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
        }

        @Insert("onResume")
        public static void com_android_settings_ConfirmLockPassword$InternalActivity_com_obric_hook_lancet_PrivacyHook_onResume(InternalActivity r3) {
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
            InternalActivity r0 = r3;
            if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
            r0.onSuperResume();
            return;
        L6:
            r3.com_android_settings_ConfirmLockPassword$InternalActivity__onResume$___twin___();
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
        @Insert(mayCreateSuper = true, value = "onPause")
        public static void com_android_settings_ConfirmLockPassword$InternalActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(InternalActivity r4) {
            String r0 = r4.getClass().getName();
            com_android_settings_ConfirmLockPassword$InternalActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_Activity " + r0);
            AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
            return;
        }

        @Insert("onPause")
        public static void com_android_settings_ConfirmLockPassword$InternalActivity_com_obric_hook_lancet_PrivacyHook_onPause(InternalActivity r3) {
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
            InternalActivity r0 = r3;
            if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
            r0.onSuperPause();
            return;
        L6:
            r3.com_android_settings_ConfirmLockPassword$InternalActivity__onPause$___twin___();
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_ConfirmLockPassword$InternalActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(InternalActivity r3, Bundle r4) {
            String r0 = r3.getClass().getName();
            com_android_settings_ConfirmLockPassword$InternalActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
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
        public static void com_android_settings_ConfirmLockPassword$InternalActivity_com_obric_hook_lancet_PrivacyHook_onStop(InternalActivity r3) {
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
            InternalActivity r0 = r3;
            if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
            r0.onSuperStop();
            return;
        L6:
            r3.com_android_settings_ConfirmLockPassword$InternalActivity__onStop$___twin___();
        }
    }

    static {
    }

    @Override // com.android.settings.base.BaseActivity, android.app.Activity
    public void finish() {
        com_android_settings_ConfirmLockPassword_com_obric_hook_lancet_PrivacyHook_finish(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_ConfirmLockPassword_com_obric_hook_lancet_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_settings_ConfirmLockPassword_com_obric_hook_lancet_PrivacyHook_onDestroy(this);
    }

    public ConfirmLockPassword() {
        this.mReceiver = new AnonymousClass1(this);
        this.mIsAllowFingerprint = false;
    }

    static /* synthetic */ String access$000() {
        return TAG;
    }

    static /* synthetic */ boolean access$100(ConfirmLockPassword r0) {
        return r0.mCloseWhenLocaleChange;
    }

    static /* synthetic */ int access$602(int r0) {
        mThisLockType = r0;
        return r0;
    }

    public void com_android_settings_ConfirmLockPassword__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        setContentView(R.layout.confirm_lock_password_activity);
        FingerprintManager r4 = (FingerprintManager) getSystemService("fingerprint");
        boolean r5 = this instanceof InternalActivity;
        this.mIsAllowFingerprint = false;
        if (AdapterActivity.isWalletVerifyPassword() == false) goto L6;
        getWindow().addFlags(524288);
    L6:
        if (Utils.isDeviceProvisioned(this.mContext) == true) goto L8;
        getWindow().addFlags(524288);
    L8:
        this.mCloseWhenLocaleChange = getIntent().getBooleanExtra(ChooseLockSettingsHelper.EXTRA_CLOSE_IF_LOCALE_CHANGED, false);
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, this.mReceiver, new IntentFilter("android.intent.action.LOCALE_CHANGED"), 2);
        OLog.w(TAG, "ConfirmLockPassword onCreate");
        WindowUtils.Companion.addSecureFlag(this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean r2) {
        super.onWindowFocusChanged(r2);
        Fragment r1 = getSupportFragmentManager().findFragmentById(R.id.main_content);
        if (r1 != null) goto L5;
        return;
    L5:
        if ((r1 instanceof ConfirmLockPasswordFragment) == false) goto L9;
        ((ConfirmLockPasswordFragment) r1).onWindowFocusChanged(r2);
        return;
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        if (Utils.getLockPasswordType(this) == mThisLockType) goto L6;
        finish();
        overridePendingTransition(0, 0);
        return;
    }

    public void com_android_settings_ConfirmLockPassword__onDestroy$___twin___() {
        super.onDestroy();
        unregisterReceiver(this.mReceiver);
    }

    public void com_android_settings_ConfirmLockPassword__finish$___twin___() {
        super.finish();
        if (getIntent() == null) goto L8;
        int[] r0 = getIntent().getIntArrayExtra("bytedanceos.intent.extra.ANIM_RESOURCE_ID");
        if (r0 == null) goto L9;
        overridePendingTransition(r0[0], r0[1]);
        return;
    L9:
        return;
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

    @Insert("onCreate")
    public static void com_android_settings_ConfirmLockPassword_com_obric_hook_lancet_PrivacyHook_onCreate(ConfirmLockPassword r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ConfirmLockPassword r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_ConfirmLockPassword__onCreate$___twin___(r4);
    }

    @Insert("onDestroy")
    public static void com_android_settings_ConfirmLockPassword_com_obric_hook_lancet_PrivacyHook_onDestroy(ConfirmLockPassword r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ConfirmLockPassword r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_ConfirmLockPassword__onDestroy$___twin___();
    }

    @Insert("finish")
    public static void com_android_settings_ConfirmLockPassword_com_obric_hook_lancet_PrivacyHook_finish(ConfirmLockPassword r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ConfirmLockPassword r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.superFinish();
        return;
    L6:
        r3.com_android_settings_ConfirmLockPassword__finish$___twin___();
    }
}
