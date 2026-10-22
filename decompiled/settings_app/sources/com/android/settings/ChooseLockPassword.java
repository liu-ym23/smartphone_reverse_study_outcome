package com.android.settings;

import android.animation.ObjectAnimator;
import android.app.StatusBarManager;
import android.app.admin.DevicePolicyManager;
import android.app.admin.PasswordMetrics;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.hardware.fingerprint.FingerprintManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.os.UserManager;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.method.DigitsKeyListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.PreferenceFragmentCompat;
import com.android.internal.widget.LockPatternUtils;
import com.android.internal.widget.LockscreenCredential;
import com.android.internal.widget.PasswordValidationError;
import com.android.internal.widget.TextViewInputDisabler;
import com.android.internal.widget.VerifyCredentialResponse;
import com.android.settings.applock.AppLockManager;
import com.android.settings.applock.view.BindCloudActivity;
import com.android.settings.applock.view.PrivacyPasswordSettingActivity;
import com.android.settings.base.BaseActivity;
import com.android.settings.biometrics.BiometricsUtils;
import com.android.settings.fingerprint.BaseFingerprintEnrollingActivity;
import com.android.settings.fingerprint.FingerprintManageFragment;
import com.android.settings.provision.NextPageRouting.RoutingUtils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.android.settings.utils.ThreadUtils;
import com.android.settings.utils.UIUtils;
import com.android.settings.wifi.TrustedNetworkHelper;
import com.android.settingslib.utils.StringUtil;
import com.android.vcard.VCardConfig;
import com.obric.olog.OLog;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import com.obric.widget.SizeChangedRelativeLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.OMenuDialog;
import obric.app.OMenuDialogListAdapter;
import obric.util.VibratorHelper;
import obric.util.WindowUtils;
import obric.widget.AppLockView;

/* JADX INFO: loaded from: classes2.dex */
public class ChooseLockPassword extends BaseActivity {
    private static final String ACCOUNT_KEY_PHONE_NUMBER = "phonenumber";
    private static final String ACCOUNT_KEY_RESULT = "result";
    private static final int ACCOUNT_RESULT_FAIL = -1;
    private static final int ACCOUNT_RESULT_SUCCESS = 0;
    private static final String CHECK_FROM = "check_from";
    private static final int CHECK_FROM_PRIVACY_PASSWORD = 2;
    private static final String CLOUD_ID_PERMISSION = "com.bytedance.permission.ACCOUNT_CENTER";
    private static final String CLOUD_ID_PROVIDER = "content://com.bytedanceos.cloudsync.accountcenter";
    private static final String CLOUD_SYNC_CHECK_CLASS = "com.bytedanceos.cloudsync.CheckPasswordActivity";
    private static final String CLOUD_SYNC_PACKAGE = "com.bytedanceos.cloudsync";
    private static final String CUSTOM_MESSAGE = "custom_message";
    private static final String CUSTOM_TITLE = "custom_title";
    public static final String EXTRA_CONFIRM_APP_LOCK = "extra_confirm_app_lock";
    public static final String EXTRA_PASSWORD = "password";
    public static final String EXTRA_PIN_LENGTH = "extra_pin_length";
    public static final String EXTRA_WALLET_HAS_BANKCARD = "wallet_has_bankcard";
    public static final String FROM_BYTEDANCEOS_LAUNCHER = "from_bytedanceos_launcher";
    private static final int LOCK_OUT_DEAD_LINE_DELAY = 999;
    private static final int LOCK_OUT_DEAD_LINE_TIME_OUT = 30000;
    private static final int MASK_FROM = 3;
    public static final String MASK_TEXT = "****";
    private static final int MASK_TO = 7;
    private static final int MESSAGE_DELAY = 200;
    private static final String PARAMS_DATA = "params_data";
    public static final String PASSWORD_APPLICATIONS_LOCK_KEY = "launcher_applications_lock";
    private static final int PASSWORD_FAIL_FIVE_TIMES = 5;
    private static final int PASSWORD_FAIL_TEN_TIMES = 10;
    public static final String PASSWORD_MAX_KEY = "lockscreen.password_max";
    public static final String PASSWORD_MIN_KEY = "lockscreen.password_min";
    public static final String PASSWORD_MIN_LETTERS_KEY = "lockscreen.password_min_letters";
    public static final String PASSWORD_MIN_LOWERCASE_KEY = "lockscreen.password_min_lowercase";
    public static final String PASSWORD_MIN_NONLETTER_KEY = "lockscreen.password_min_nonletter";
    public static final String PASSWORD_MIN_NUMERIC_KEY = "lockscreen.password_min_numeric";
    public static final String PASSWORD_MIN_SYMBOLS_KEY = "lockscreen.password_min_symbols";
    public static final String PASSWORD_MIN_UPPERCASE_KEY = "lockscreen.password_min_uppercase";
    private static final String REQUEST_ACCOUNT_PHONE = "request_account_phone";
    private static final int REQUEST_CLOUD_CHECK_PASSWORD = 200;
    private static final String TAG = "ChooseLockPassword";
    private static boolean sChooseLockPasswordSuccessed;
    private boolean fromProvision;
    private int mFingerType;
    private boolean mFromBytedanceLauncher;
    private boolean mFromBytedanceosLaunchpad;

    public static class ChooseLockPasswordFragment extends PreferenceFragmentCompat implements View.OnClickListener, TextView.OnEditorActionListener {
        private static final int APP_LOCK_PWD_CONFIRMED = 5;
        private static final int CONFIRM_EXISTING_REQUEST = 58;
        private static final int FIRST_INPUT_UPDATE_DELAY = 2;
        private static final String KEY_CURRENT_CREDENTIAL = "current_password";
        private static final String KEY_FIRST_PASSWORD = "first_pin";
        private static final String KEY_UI_STAGE = "ui_stage";
        private static final int MSG_SHOW_ERROR = 1;
        private static final int PLATE_LOCK_CONFIRMED = 7;
        private static final int REQUEST_FIND_PASSWORD_WAY_SETTING = 60;
        private static final int RESET_APPLICATIONS_LOCK_READY = 4;
        private static final int RESET_ERROR_UI = 6;
        static final int RESULT_FINISHED = 1;
        private static final int SECOND_INPUT_UPDATE_DELAY = 3;
        private int EASY_PASSWORD_LENGTH;
        private long clickDebounceTime;
        private long currentClickTime;
        private final ImageView[] dots;
        private boolean hasConfirmedAppLockCorrectly;
        private boolean isInsideSettings;
        private boolean mAnsweredQuestionCorrectly;
        private boolean mApplicationsLock;
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
        private boolean mCanEnterPassword;
        private View mCancelView;
        private long mChallenge;
        private boolean mChangePassword;
        private boolean mChangePlateLockPwd;
        private ChooseLockSettingsHelper mChooseLockSettingsHelper;
        private OMenuDialog mChooseLockTypeDialog;
        private LockscreenCredential mChosenPassword;
        private boolean mConfirmWrongPlateLock;
        private CountDownTimer mCountdownTimer;
        private LockscreenCredential mCurrentCredential;
        private ObjectAnimator mDotShakeAnim;
        private boolean mExitSmilingCloud;
        private int mFingerType;
        private LockscreenCredential mFirstPassword;
        private boolean mFirstSetPassword;
        private FingerprintManager mFm;
        private boolean mForFingerprint;
        private TextView mForgetPwd;
        private boolean mFromBytedanceosLauncher;
        private boolean mFromBytedanceosLaunchpad;
        private final Handler mHandler;
        private boolean mHasChallenge;
        private boolean mHasError;
        private TextView mHeaderText;
        private ObjectAnimator mHeaderTextShakeAnim;
        private boolean mHideDrawer;
        private boolean mIsAlphaMode;
        private boolean mIsAppLocked;
        private boolean mIsFromWallet;
        private boolean mIsHasBankCardInWallet;
        private boolean mIsInSetupWizard;
        private boolean mIsManagedProfile;
        private boolean mIsResetPwdByFindPwd;
        private boolean mIsTargetConfirmAppLock;
        private RelativeLayout mKeyboardView;
        private LockPatternUtils mLockPatternUtils;
        private InputPasswordMediator mMediator;
        private boolean mNeedResult;
        private View mNextButton;
        private View mNextImageView;
        private boolean mOnConfigurationChanging;
        private LinearLayout mPasswordContainer;
        private OInputLayout mPasswordEntry;
        private TextViewInputDisabler mPasswordEntryInputDisabler;
        private byte[] mPasswordHistoryHashFactor;
        private int mPasswordMaxLength;
        private int mPasswordMinLength;
        private int mPasswordMinLetters;
        private int mPasswordMinLowerCase;
        private int mPasswordMinNonLetter;
        private int mPasswordMinNumeric;
        private int mPasswordMinSymbols;
        private int mPasswordMinUpperCase;
        private AsyncTask<?, ?, ?> mPendingLockCheck;
        private int mRequestedMinComplexity;
        private int mRequestedQuality;
        private boolean mSecurityOn;
        private boolean mSettingPassword;
        private SizeChangedRelativeLayout mSizeChangedLayout;
        private StatusBarManager mStatusbarManager;
        private TextView mSwitchDigitView;
        private Stage mUiStage;
        private TextView mUseCloudUnlock;
        private int mUserId;
        private List<PasswordValidationError> mValidationErrors;
        private boolean requestResult;
        private OFloatingTitleBar titleBar;

        /* JADX INFO: renamed from: com.android.settings.ChooseLockPassword$ChooseLockPasswordFragment$9, reason: invalid class name */
        class AnonymousClass9 extends AsyncTask<Void, Void, Void> {
            final /* synthetic */ ChooseLockPasswordFragment this$0;
            final /* synthetic */ String val$passwordText;
            final /* synthetic */ LockscreenCredential val$savePassword;
            final /* synthetic */ boolean val$wasSecureBefore;

            AnonymousClass9(ChooseLockPasswordFragment r1, LockscreenCredential r2, String r3, boolean r4) {
                this.this$0 = r1;
                this.val$savePassword = r2;
                this.val$passwordText = r3;
                this.val$wasSecureBefore = r4;
            }

            @Override // android.os.AsyncTask
            protected /* bridge */ /* synthetic */ Void doInBackground(Void[] r1) {
                return doInBackground2(r1);
            }

            @Override // android.os.AsyncTask
            protected /* bridge */ /* synthetic */ void onPostExecute(Void r1) {
                onPostExecute2(r1);
            }

            /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
            protected Void doInBackground2(Void... r8) {
                LockPatternUtils r2 = ChooseLockPasswordFragment.access$2800(this.this$0).utils();
            L17:
                th = move-exception;
                OLog.e(ChooseLockPassword.TAG, "Failed to set lockscreen credential:" + ChooseLockPasswordFragment.access$2400(this.this$0), th);
                AppMetricsUtils.INSTANCE.reportSetLockCredentialError("password", th);
                ThreadUtils.postOnMainThread(new ChooseLockPassword$ChooseLockPasswordFragment$9$$ExternalSyntheticLambda1(this));
            L19:
                return null;
            L4:
                if (ChooseLockPasswordFragment.access$2900(this.this$0) != null) goto L7;
                ChooseLockPasswordFragment.access$2902(this.this$0, LockscreenCredential.createNone());     // Catch: Throwable -> L17
            L7:
                if (r2.setLockCredential(this.val$savePassword, ChooseLockPasswordFragment.access$2900(this.this$0), ChooseLockPasswordFragment.access$2400(this.this$0)) == true) goto L10;
                OLog.e(ChooseLockPassword.TAG, "Failed to set lockscreen credential:" + ChooseLockPasswordFragment.access$2400(this.this$0));     // Catch: Throwable -> L17
                AppMetricsUtils.INSTANCE.reportSetLockCredentialError("password", null);     // Catch: Throwable -> L17
                ThreadUtils.postOnMainThread(new ChooseLockPassword$ChooseLockPasswordFragment$9$$ExternalSyntheticLambda0(this));     // Catch: Throwable -> L17
                goto L19
            L10:
                if (ChooseLockPasswordFragment.access$1600(this.this$0) == true) goto L19;
                if (this.val$passwordText.length() != 4) goto L14;
            L15:
                LockPatternUtilsOnly.setPasswordLengthBytedance(r2, this.val$passwordText.length(), ChooseLockPasswordFragment.access$2400(this.this$0));     // Catch: Throwable -> L17
                goto L19
            L14:
                if (this.val$passwordText.length() != 6) goto L19;
                goto L15
            }

            /* JADX INFO: renamed from: lambda$doInBackground$0$com-android-settings-ChooseLockPassword$ChooseLockPasswordFragment$9, reason: not valid java name */
            /* synthetic */ void m109x1771faa6() {
                ToastUtils.show(this.this$0.getActivity(), R.string.set_lock_credential_failed);
            }

            /* JADX INFO: renamed from: lambda$doInBackground$1$com-android-settings-ChooseLockPassword$ChooseLockPasswordFragment$9, reason: not valid java name */
            /* synthetic */ void m110x50525b45() {
                ToastUtils.show(this.this$0.getActivity(), R.string.set_lock_credential_failed);
            }

            /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
            protected void onPostExecute2(Void r3) {
                super.onPostExecute(r3);
                if (this.this$0.isAdded() == true) goto L5;
                return;
            L5:
                OLog.d(ChooseLockPassword.TAG, "save lock  len:" + this.val$passwordText.length() + "  quality:" + ChooseLockPasswordFragment.access$3000(this.this$0));
                OLog.i(ChooseLockPassword.TAG, "NeedToConfirm onPostExecute");
                VibratorHelper.INSTANCE.confirm(this.this$0.getActivity());
                if (ChooseLockPasswordFragment.access$3100(this.this$0) == false) goto L10;
                OLog.e(ChooseLockPassword.TAG, "finishSetupWizard: true");
                return;
            L10:
                if (ChooseLockPasswordFragment.access$3200(this.this$0) == true) goto L13;
                this.this$0.getActivity().setResult(-1, Utils.getPasswordIntent(ChooseLockPasswordFragment.access$500(this.this$0), ChooseLockPasswordFragment.access$600(this.this$0)));
            L13:
                if (ChooseLockPasswordFragment.access$3300(this.this$0) == false) goto L16;
                ChooseLockPasswordFragment.access$3400(this.this$0, this.val$savePassword, this.val$wasSecureBefore);
                return;
            L16:
                ChooseLockPasswordFragment r4 = this.this$0;
                ChooseLockPasswordFragment.access$3500(r4, ChooseLockPasswordFragment.access$500(r4));
                ChooseLockPasswordFragment.access$3600(this.this$0);
            }
        }

        protected static final enum Stage extends Enum<Stage> {
            private static final /* synthetic */ Stage[] $VALUES = null;
            public static final Stage ConfirmPlateLock = null;
            public static final Stage ConfirmWrong = null;
            public static final Stage Introduction = null;
            public static final Stage NeedToConfirm = null;
            public final int alphaHint;
            public final int buttonText;
            public final int numericHint;

            private static /* synthetic */ Stage[] $values() {
                return new Stage[]{ConfirmPlateLock, Introduction, NeedToConfirm, ConfirmWrong};
            }

            public static Stage valueOf(String r1) {
                return (Stage) Enum.valueOf(Stage.class, r1);
            }

            public static Stage[] values() {
                return (Stage[]) $VALUES.clone();
            }

            static {
                ConfirmPlateLock = new Stage("ConfirmPlateLock", 0, R.string.setup_complex_password, R.string.lockpassword_choose_your_pin_header, R.string.lockpassword_continue_label);
                Introduction = new Stage("Introduction", 1, R.string.setup_complex_password, R.string.lockpassword_choose_your_pin_header, R.string.lockpassword_continue_label);
                NeedToConfirm = new Stage("NeedToConfirm", 2, R.string.security_item_applications_lock_confirm, R.string.lockpassword_confirm_your_pin_header, R.string.lockpassword_ok_label);
                ConfirmWrong = new Stage("ConfirmWrong", 3, R.string.security_item_applications_lock_nomatch, R.string.lockpassword_confirm_pins_dont_match, R.string.lockpassword_continue_label);
                $VALUES = $values();
            }

            private Stage(String r1, int r2, int r3, int r4, int r5) {
                super(r1, r2);
                this.alphaHint = r3;
                this.numericHint = r4;
                this.buttonText = r5;
            }
        }

        @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_ChooseLockPassword$ChooseLockPasswordFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.preference.PreferenceFragmentCompat
        public void onCreatePreferences(Bundle r1, String r2) {
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_ChooseLockPassword$ChooseLockPasswordFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        protected void setNextText(int r1) {
        }

        static /* synthetic */ void access$000(ChooseLockPasswordFragment r0) {
            r0.updatePasswordUi();
        }

        static /* synthetic */ void access$100(ChooseLockPasswordFragment r0) {
            r0.clearPasswordEntry();
        }

        static /* synthetic */ int access$1000(ChooseLockPasswordFragment r0) {
            return r0.EASY_PASSWORD_LENGTH;
        }

        static /* synthetic */ int access$1002(ChooseLockPasswordFragment r0, int r1) {
            r0.EASY_PASSWORD_LENGTH = r1;
            return r1;
        }

        static /* synthetic */ void access$1100(ChooseLockPasswordFragment r0, int r1, boolean r2) {
            r0.updateInputArea(r1, r2);
        }

        static /* synthetic */ Handler access$1200(ChooseLockPasswordFragment r0) {
            return r0.mHandler;
        }

        static /* synthetic */ boolean access$1300(ChooseLockPasswordFragment r0) {
            return r0.mConfirmWrongPlateLock;
        }

        static /* synthetic */ boolean access$1400(ChooseLockPasswordFragment r0) {
            return r0.mHasError;
        }

        static /* synthetic */ void access$1500(ChooseLockPasswordFragment r0) {
            r0.updateUi();
        }

        static /* synthetic */ boolean access$1600(ChooseLockPasswordFragment r0) {
            return r0.mIsAlphaMode;
        }

        static /* synthetic */ int access$1700(ChooseLockPasswordFragment r0) {
            return r0.mPasswordMinLength;
        }

        static /* synthetic */ TextView access$1800(ChooseLockPasswordFragment r0) {
            return r0.mHeaderText;
        }

        static /* synthetic */ void access$1900(ChooseLockPasswordFragment r0) {
            r0.handleNext();
        }

        static /* synthetic */ void access$2000(ChooseLockPasswordFragment r0) {
            r0.gotoCloudCheckPassword();
        }

        static /* synthetic */ LockscreenCredential access$202(ChooseLockPasswordFragment r0, LockscreenCredential r1) {
            r0.mFirstPassword = r1;
            return r1;
        }

        static /* synthetic */ void access$2100(ChooseLockPasswordFragment r0) {
            r0.gotoFindPassword();
        }

        static /* synthetic */ void access$2200(ChooseLockPasswordFragment r0, String r1, boolean r2) {
            r0.updateHeaderView(r1, r2);
        }

        static /* synthetic */ CountDownTimer access$2302(ChooseLockPasswordFragment r0, CountDownTimer r1) {
            r0.mCountdownTimer = r1;
            return r1;
        }

        static /* synthetic */ int access$2400(ChooseLockPasswordFragment r0) {
            return r0.mUserId;
        }

        static /* synthetic */ void access$2500(ChooseLockPasswordFragment r0, int r1, boolean r2) {
            r0.updateHeaderView(r1, r2);
        }

        static /* synthetic */ boolean access$2600(ChooseLockPasswordFragment r0) {
            return r0.mApplicationsLock;
        }

        static /* synthetic */ boolean access$2702(ChooseLockPasswordFragment r0, boolean r1) {
            r0.mCanEnterPassword = r1;
            return r1;
        }

        static /* synthetic */ ChooseLockSettingsHelper access$2800(ChooseLockPasswordFragment r0) {
            return r0.mChooseLockSettingsHelper;
        }

        static /* synthetic */ LockscreenCredential access$2900(ChooseLockPasswordFragment r0) {
            return r0.mCurrentCredential;
        }

        static /* synthetic */ LockscreenCredential access$2902(ChooseLockPasswordFragment r0, LockscreenCredential r1) {
            r0.mCurrentCredential = r1;
            return r1;
        }

        static /* synthetic */ int access$3000(ChooseLockPasswordFragment r0) {
            return r0.mRequestedQuality;
        }

        static /* synthetic */ boolean access$302(ChooseLockPasswordFragment r0, boolean r1) {
            r0.mSettingPassword = r1;
            return r1;
        }

        static /* synthetic */ boolean access$3100(ChooseLockPasswordFragment r0) {
            return r0.finishSetupWizard();
        }

        static /* synthetic */ boolean access$3200(ChooseLockPasswordFragment r0) {
            return r0.mIsFromWallet;
        }

        static /* synthetic */ boolean access$3300(ChooseLockPasswordFragment r0) {
            return r0.mHasChallenge;
        }

        static /* synthetic */ void access$3400(ChooseLockPasswordFragment r0, LockscreenCredential r1, boolean r2) {
            r0.startVerifyPassword(r1, r2);
        }

        static /* synthetic */ void access$3500(ChooseLockPasswordFragment r0, LockscreenCredential r1) {
            r0.handleEnrolling(r1);
        }

        static /* synthetic */ void access$3600(ChooseLockPasswordFragment r0) {
            r0.closeActivity();
        }

        static /* synthetic */ LockPatternUtils access$3800(ChooseLockPasswordFragment r0) {
            return r0.mLockPatternUtils;
        }

        static /* synthetic */ long access$3900(ChooseLockPasswordFragment r2) {
            return r2.mChallenge;
        }

        static /* synthetic */ void access$400(ChooseLockPasswordFragment r0) {
            r0.resetUiIfConfirmWrong();
        }

        static /* synthetic */ TextViewInputDisabler access$4000(ChooseLockPasswordFragment r0) {
            return r0.mPasswordEntryInputDisabler;
        }

        static /* synthetic */ AsyncTask access$4102(ChooseLockPasswordFragment r0, AsyncTask r1) {
            r0.mPendingLockCheck = r1;
            return r1;
        }

        static /* synthetic */ boolean access$4200(ChooseLockPasswordFragment r0, VerifyCredentialResponse r1) {
            return r0.handlePasswordCreated(r1);
        }

        static /* synthetic */ int access$4300(ChooseLockPasswordFragment r0) {
            return r0.mFingerType;
        }

        static /* synthetic */ OMenuDialog access$4402(ChooseLockPasswordFragment r0, OMenuDialog r1) {
            r0.mChooseLockTypeDialog = r1;
            return r1;
        }

        static /* synthetic */ ObjectAnimator access$4502(ChooseLockPasswordFragment r0, ObjectAnimator r1) {
            r0.mHeaderTextShakeAnim = r1;
            return r1;
        }

        static /* synthetic */ LinearLayout access$4600(ChooseLockPasswordFragment r0) {
            return r0.mPasswordContainer;
        }

        static /* synthetic */ ObjectAnimator access$4702(ChooseLockPasswordFragment r0, ObjectAnimator r1) {
            r0.mDotShakeAnim = r1;
            return r1;
        }

        static /* synthetic */ LockscreenCredential access$500(ChooseLockPasswordFragment r0) {
            return r0.mChosenPassword;
        }

        static /* synthetic */ boolean access$600(ChooseLockPasswordFragment r0) {
            return r0.isInsideSettings;
        }

        static /* synthetic */ Stage access$700(ChooseLockPasswordFragment r0) {
            return r0.mUiStage;
        }

        static /* synthetic */ Stage access$702(ChooseLockPasswordFragment r0, Stage r1) {
            r0.mUiStage = r1;
            return r1;
        }

        static /* synthetic */ RelativeLayout access$800(ChooseLockPasswordFragment r0) {
            return r0.mKeyboardView;
        }

        static /* synthetic */ OInputLayout access$900(ChooseLockPasswordFragment r0) {
            return r0.mPasswordEntry;
        }

        private void updatePasswordUi() {
            this.EASY_PASSWORD_LENGTH = 6;
            this.mForgetPwd.setVisibility(8);
        }

        private void clearPasswordEntry() {
            this.mPasswordEntry.setText("");
        }

        public ChooseLockPasswordFragment() {
            this.mPasswordMinLength = 4;
            this.mPasswordMaxLength = 16;
            this.mPasswordMinLetters = 0;
            this.mPasswordMinUpperCase = 0;
            this.mPasswordMinLowerCase = 0;
            this.mPasswordMinSymbols = 0;
            this.mPasswordMinNumeric = 0;
            this.mPasswordMinNonLetter = 0;
            this.mRequestedQuality = 131072;
            this.mUiStage = Stage.Introduction;
            this.mSettingPassword = false;
            this.mConfirmWrongPlateLock = false;
            this.mFirstSetPassword = false;
            this.mHideDrawer = false;
            this.mCanEnterPassword = true;
            this.EASY_PASSWORD_LENGTH = 4;
            this.dots = new ImageView[6];
            this.mFingerType = -1;
            this.isInsideSettings = false;
            this.mRequestedMinComplexity = 0;
            this.mOnConfigurationChanging = false;
            this.mHandler = new AnonymousClass1(this);
            this.currentClickTime = 0;
            this.clickDebounceTime = 500;
        }

        public void com_android_settings_ChooseLockPassword$ChooseLockPasswordFragment__onCreate$___twin___(Bundle r7) {
            super.onCreate(r7);
            this.mLockPatternUtils = new LockPatternUtils(getActivity());
            Intent r8 = getActivity().getIntent();
            if ((getActivity() instanceof ChooseLockPassword) == false) goto L26;
            this.mRequestedMinComplexity = r8.getIntExtra("android.app.extra.PASSWORD_COMPLEXITY", 0);
            int r0 = Utils.getUserIdFromBundle(getActivity(), r8.getExtras());
            this.mUserId = r0;
            this.mIsManagedProfile = UserManager.get(getActivity()).isManagedProfile(this.mUserId);
            OLog.d(ChooseLockPassword.TAG, "UserId:" + this.mUserId + " ManagedProfile:" + this.mIsManagedProfile);
            PasswordMetrics r2 = this.mLockPatternUtils.getRequestedPasswordMetrics(r0);
            this.mRequestedQuality = Utils.getIntExtraSafely(r8, "lockscreen.password_type", this.mRequestedQuality);
            this.mPasswordMinLength = Utils.getIntExtraSafely(r8, ChooseLockPassword.PASSWORD_MIN_KEY, this.EASY_PASSWORD_LENGTH);
            this.mPasswordMaxLength = Utils.getIntExtraSafely(r8, ChooseLockPassword.PASSWORD_MAX_KEY, this.mPasswordMaxLength);
            this.mPasswordMinLetters = Math.max(Utils.getIntExtraSafely(r8, ChooseLockPassword.PASSWORD_MIN_LETTERS_KEY, this.mPasswordMinLetters), this.mLockPatternUtils.getRequestedMinimumPasswordLength(r0));
            this.mPasswordMinUpperCase = Math.max(Utils.getIntExtraSafely(r8, ChooseLockPassword.PASSWORD_MIN_UPPERCASE_KEY, this.mPasswordMinUpperCase), r2.upperCase);
            this.mPasswordMinLowerCase = Math.max(Utils.getIntExtraSafely(r8, ChooseLockPassword.PASSWORD_MIN_LOWERCASE_KEY, this.mPasswordMinLowerCase), r2.lowerCase);
            this.mPasswordMinNumeric = Math.max(Utils.getIntExtraSafely(r8, ChooseLockPassword.PASSWORD_MIN_NUMERIC_KEY, this.mPasswordMinNumeric), r2.numeric);
            this.mPasswordMinSymbols = Math.max(Utils.getIntExtraSafely(r8, ChooseLockPassword.PASSWORD_MIN_SYMBOLS_KEY, this.mPasswordMinSymbols), r2.symbols);
            this.mPasswordMinNonLetter = Math.max(Utils.getIntExtraSafely(r8, ChooseLockPassword.PASSWORD_MIN_NONLETTER_KEY, this.mPasswordMinNonLetter), r2.nonLetter);
            this.mApplicationsLock = Utils.getBooleanExtraSafely(r8, ChooseLockPassword.PASSWORD_APPLICATIONS_LOCK_KEY, false);
            this.mIsHasBankCardInWallet = Utils.getBooleanExtraSafely(r8, ChooseLockPassword.EXTRA_WALLET_HAS_BANKCARD, false);
            String r1 = Utils.getStringExtraSafely(r8, AdapterActivity.EXTRA_SOURCE);
            this.mChangePassword = Utils.getBooleanExtraSafely(r8, AppLockUtil.CHANGE_APPLICATION_LOCK_PASSWORD, false);
            this.mChangePlateLockPwd = Utils.getBooleanExtraSafely(r8, AppLockUtil.CHANGE_PLATE_LOCK_PASSWORD, false);
            this.mExitSmilingCloud = Utils.getBooleanExtraSafely(r8, AppLockUtil.EXIT_SMILING_CLOUD, false);
            this.mFromBytedanceosLaunchpad = Utils.getBooleanExtraSafely(r8, AppLockUtil.FROM_BYTEDANCEOS_LAUNCHPAD, false);
            if ("com.bytedanceos.wallet".equals(r1) == false) goto L8;
            this.mIsFromWallet = true;
        L8:
            if (this.mApplicationsLock == false) goto L23;
            boolean r3 = Utils.getBooleanExtraSafely(r8, "answered_question_correctly", false);
            this.mAnsweredQuestionCorrectly = r3;
            this.mIsResetPwdByFindPwd = r3;
            this.mIsTargetConfirmAppLock = Utils.getBooleanExtraSafely(r8, ChooseLockPassword.EXTRA_CONFIRM_APP_LOCK, false);
            boolean r4 = AppLockUtil.isPrivacyPasswordSet(getContext().getContentResolver());
            this.mSecurityOn = r4;
            if (this.mChangePassword == false) goto L12;
            this.mIsAppLocked = false;
        L18:
            boolean r9 = Utils.getBooleanExtraSafely(r8, ChooseLockPassword.FROM_BYTEDANCEOS_LAUNCHER, false);
            this.mFromBytedanceosLauncher = r9;
            if (r9 == false) goto L23;
            if (this.mIsAppLocked == false) goto L23;
            OLog.d(ChooseLockPassword.TAG, "error logic of coming from launcher for resetting pwd, finish..");
            getActivity().finish();
            goto L23
        L12:
            if (r4 == true) goto L14;
        L16:
            boolean r5 = false;
        L17:
            this.mIsAppLocked = r5;
            goto L18
        L14:
            if (this.mAnsweredQuestionCorrectly == true) goto L16;
            r5 = true;
        L23:
            this.mForFingerprint = getActivity().getIntent().getBooleanExtra("for_fingerprint", false);
            this.mChooseLockSettingsHelper = new ChooseLockSettingsHelper(getActivity(), this);
            this.mMediator = new InputPasswordMediator(getActivity());
            this.requestResult = Utils.getBooleanExtraSafely(getActivity().getIntent(), TrustedNetworkHelper.EXTRA_REQUEST_RESULT, false);
            this.mIsInSetupWizard = !Utils.isDeviceProvisioned(getActivity());
            this.isInsideSettings = Utils.isInsidePackage(getActivity());
            return;
        L26:
            throw new SecurityException("Fragment contained in wrong activity");
        }

        @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration r1) {
            super.onConfigurationChanged(r1);
            this.mOnConfigurationChanging = true;
        }

        @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
        public View onCreateView(LayoutInflater r11, ViewGroup r12, Bundle r13) {
            if (this.mFromBytedanceosLauncher == false) goto L5;
            int r14 = R.layout.choose_lock_password_for_fake;
        L6:
            View r15 = r11.inflate(r14, null);
            ((FrameLayout) r15.findViewById(R.id.pin_keyboard_layout)).addView(UIUtils.buildNoScaledView(getActivity(), R.layout.pin_keyboard_layout));
            this.mFingerType = getActivity().getIntent().getIntExtra(FingerprintManageFragment.FINGER_TYPE, -1);
            this.mFm = (FingerprintManager) getActivity().getSystemService("fingerprint");
            OFloatingTitleBar r16 = (OFloatingTitleBar) r15.findViewById(R.id.view_title);
            this.titleBar = r16;
            int r0 = this.mRequestedQuality;
            if (262144 != r0) goto L9;
        L14:
            boolean r1 = true;
        L15:
            this.mIsAlphaMode = r1;
            this.mCancelView = r16.addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, this);
            if (this.mIsInSetupWizard == false) goto L19;
            StatusBarManager r17 = (StatusBarManager) getActivity().getApplicationContext().getSystemService("statusbar");
            this.mStatusbarManager = r17;
            r17.disable(18874368);
        L19:
            if (this.mIsAlphaMode == false) goto L21;
            this.mNextButton = this.titleBar.addEndAction(getString(R.string.lockpassword_continue_label), -1, this);
            this.titleBar.setEndButtonGroupStyle(2132017894);
            setNextEnabled(false);
        L31:
            this.mKeyboardView = (RelativeLayout) r15.findViewById(R.id.keyboard);
            SizeChangedRelativeLayout r18 = (SizeChangedRelativeLayout) r15.findViewById(R.id.size_changed_layout);
            this.mSizeChangedLayout = r18;
            r18.setSizeChangedListener(new ChooseLockPassword$ChooseLockPasswordFragment$$ExternalSyntheticLambda0(this));
            OInputLayout r19 = (OInputLayout) r15.findViewById(R.id.passwordEntry);
            this.mPasswordEntry = r19;
            if (this.mIsAlphaMode == true) goto L34;
            r19.setVisibility(4);
            this.mPasswordEntry.setOnTouchListener(new AnonymousClass2(this));
        L34:
            this.mPasswordEntry.getVInput().setOnEditorActionListener(this);
            this.mPasswordEntryInputDisabler = new TextViewInputDisabler(this.mPasswordEntry.getVInput());
            OEditText r110 = this.mPasswordEntry.getVInput();
            InputFilter[] r5 = new InputFilter[1];
            if (this.mIsAlphaMode == false) goto L37;
            int r7 = 16;
        L38:
            r5[0] = new InputFilter.LengthFilter(r7);
            r110.setFilters(r5);
            this.mPasswordEntry.setOnFocusChangeListener(new AnonymousClass3(this));
            if (this.mIsAlphaMode == false) goto L41;
            this.mKeyboardView.setVisibility(8);
        L43:
            if (this.mIsAlphaMode == false) goto L45;
            this.mPasswordEntry.setFocusable(true);
        L46:
            this.mPasswordEntry.getVInput().addTextChangedListener(new AnonymousClass5(this));
            LinearLayout r111 = (LinearLayout) r15.findViewById(R.id.password_container);
            this.mPasswordContainer = r111;
            if (this.mIsAlphaMode == false) goto L49;
            r111.removeAllViews();
            this.mPasswordContainer.setVisibility(8);
        L52:
            getActivity();
            this.mHeaderText = (TextView) r15.findViewById(R.id.headerText);
            TextView r112 = (TextView) r15.findViewById(R.id.use_smiling_unlock);
            this.mUseCloudUnlock = r112;
            r112.setOnClickListener(new AnonymousClass6(this));
            if (this.mApplicationsLock == true) goto L55;
        L65:
            TextView r113 = (TextView) r15.findViewById(R.id.forget_password);
            this.mForgetPwd = r113;
            r113.setOnClickListener(new AnonymousClass7(this));
            if (this.mChangePlateLockPwd == false) goto L68;
            this.mForgetPwd.setVisibility(0);
        L68:
            Intent r114 = getActivity().getIntent();
            boolean r2 = r114.getBooleanExtra(ChooseLockGeneric.CONFIRM_CREDENTIALS, true);
            if (r114.hasExtra("password") == false) goto L71;
            this.mCurrentCredential = r114.getParcelableExtra("password");
        L72:
            this.mHasChallenge = r114.getBooleanExtra(ChooseLockSettingsHelper.EXTRA_KEY_HAS_CHALLENGE, false);
            this.mChallenge = r114.getLongExtra("challenge", 0);
            if (r13 == null) goto L75;
            this.mFirstPassword = r13.getParcelable(KEY_FIRST_PASSWORD);
            String r3 = r13.getString(KEY_UI_STAGE);
            if (r3 == null) goto L93;
            Stage r4 = Stage.valueOf(r3);
            this.mUiStage = r4;
            updateStage(r4);
        L93:
            if (this.mCurrentCredential != null) goto L95;
            this.mCurrentCredential = r13.getParcelable(KEY_CURRENT_CREDENTIAL);
        L95:
            setUpTitle(r15, r114);
            return r15;
        L75:
            if (this.mChangePlateLockPwd == false) goto L78;
            updateStage(Stage.ConfirmPlateLock);
        L85:
            if (r2 == false) goto L95;
            if (this.mFromBytedanceosLauncher == true) goto L95;
            this.mNeedResult = true;
            this.mChooseLockSettingsHelper.launchConfirmationActivity(58, null, true, 2, this.mUserId);
            goto L95
        L78:
            if (this.mChangePassword == false) goto L81;
            updateStage(Stage.Introduction);
            goto L85
        L81:
            if (this.mIsAppLocked == false) goto L83;
            Stage r115 = Stage.NeedToConfirm;
        L84:
            updateStage(r115);
            goto L85
        L83:
            r115 = Stage.Introduction;
            goto L84
        L71:
            OLog.e(ChooseLockPassword.TAG, "don't have EXTRA_KEY_PASSWORD");
            goto L72
        L55:
            if (this.mChangePlateLockPwd == true) goto L65;
            if (this.mChangePassword == true) goto L65;
            if (this.mIsAppLocked == false) goto L65;
            if (this.mExitSmilingCloud == true) goto L65;
            if (AppLockUtil.isSmilingCloudLogin(getContext()) == false) goto L65;
            this.mUseCloudUnlock.setVisibility(0);
            goto L65
        L49:
            this.mBtn1 = (LinearLayout) r15.findViewById(R.id.easy_password_keyboard_1);
            this.mBtn2 = (LinearLayout) r15.findViewById(R.id.easy_password_keyboard_2);
            this.mBtn3 = (LinearLayout) r15.findViewById(R.id.easy_password_keyboard_3);
            this.mBtn4 = (LinearLayout) r15.findViewById(R.id.easy_password_keyboard_4);
            this.mBtn5 = (LinearLayout) r15.findViewById(R.id.easy_password_keyboard_5);
            this.mBtn6 = (LinearLayout) r15.findViewById(R.id.easy_password_keyboard_6);
            this.mBtn7 = (LinearLayout) r15.findViewById(R.id.easy_password_keyboard_7);
            this.mBtn8 = (LinearLayout) r15.findViewById(R.id.easy_password_keyboard_8);
            this.mBtn9 = (LinearLayout) r15.findViewById(R.id.easy_password_keyboard_9);
            this.mBtn0 = (LinearLayout) r15.findViewById(R.id.easy_password_keyboard_0);
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
            this.mSwitchDigitView = (TextView) r15.findViewById(R.id.switch_digit);
            this.dots[0] = (ImageView) r15.findViewById(R.id.easy_password_no_1);
            this.dots[1] = (ImageView) r15.findViewById(R.id.easy_password_no_2);
            this.dots[2] = (ImageView) r15.findViewById(R.id.easy_password_no_3);
            this.dots[3] = (ImageView) r15.findViewById(R.id.easy_password_no_4);
            this.dots[4] = (ImageView) r15.findViewById(R.id.easy_password_no_5);
            this.dots[5] = (ImageView) r15.findViewById(R.id.easy_password_no_6);
            updateInputArea(-1, true);
            InputPasswordMediator r116 = this.mMediator;
            if (r116 == null) goto L52;
            r116.setSoundEffectsEnabled(false, new View[]{this.mBtn1, this.mBtn2, this.mBtn3, this.mBtn4, this.mBtn5, this.mBtn6, this.mBtn7, this.mBtn8, this.mBtn9, this.mBtn0});
            goto L52
        L45:
            this.mPasswordEntry.getVInput().setKeyListener(DigitsKeyListener.getInstance());
            this.mPasswordEntry.setInputType(18);
            getActivity().getWindow().setSoftInputMode(3);
            goto L46
        L41:
            this.mKeyboardView.setVisibility(0);
            this.mKeyboardView.requestFocus();
            r15.findViewById(R.id.pinDel).setOnClickListener(new AnonymousClass4(this));
            goto L43
        L37:
            r7 = this.EASY_PASSWORD_LENGTH;
            goto L38
        L21:
            int r117 = getActivity().getIntent().getIntExtra(ChooseLockPassword.EXTRA_PIN_LENGTH, 4);
            this.EASY_PASSWORD_LENGTH = r117;
            if (this.mApplicationsLock == true) goto L24;
            if (r117 == 4) goto L31;
            if (r117 == 6) goto L31;
            throw new IllegalArgumentException("pin code length must be 4 or 6!");
        L24:
            if (this.mFromBytedanceosLauncher == false) goto L31;
            createImageView(R.drawable.standard_icon_cancel_selector);
            this.mNextImageView.setOnClickListener(this);
            this.mCancelView.setVisibility(4);
            goto L31
        L9:
            if (327680 == r0) goto L14;
            if (393216 == r0) goto L14;
            r1 = false;
            goto L15
        L5:
            r14 = R.layout.choose_lock_password;
            goto L6
        }

        /* JADX INFO: renamed from: lambda$onCreateView$0$com-android-settings-ChooseLockPassword$ChooseLockPasswordFragment, reason: not valid java name */
        /* synthetic */ void m108xe00263af() {
            this.mPasswordEntry.requestFocus();
        }

        @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
        public void onViewCreated(View r3, Bundle r4) {
            UIUtils.fitMaskTitleInCommon((ViewGroup) r3, r3.findViewById(R.id.title));
            super.onViewCreated(r3, r4);
        }

        private void setUpTitle(View r2, Intent r3) {
            int r1 = r3.getIntExtra("lockscreen.password_type", 131072);
            if (131072 != r1) goto L6;
            ((TextView) r2.findViewById(R.id.title)).setText(R.string.lock_screen_mode_password_easy);
            return;
        L6:
            if (262144 != r1) goto L10;
            ((TextView) r2.findViewById(R.id.title)).setText(R.string.lock_screen_mode_password_hard);
            return;
        }

        private void setupHeaderTopMargin(TextView r3) {
            RelativeLayout.LayoutParams r0 = (RelativeLayout.LayoutParams) r3.getLayoutParams();
            if (this.mIsAlphaMode == false) goto L6;
            int r1 = R.dimen.choose_lock_pwd_header_text_margin_top_complex;
        L9:
            r0.topMargin = (int) getResources().getDimension(r1);
            r3.setLayoutParams(r0);
            return;
        L6:
            if (Utils.isDesktop(getActivity()) == false) goto L8;
            r1 = R.dimen.desktop_choose_lock_pwd_header_text_margin_top;
            goto L9
        L8:
            r1 = R.dimen.choose_lock_pwd_header_text_margin_top;
            goto L9
        }

        public void com_android_settings_ChooseLockPassword$ChooseLockPasswordFragment__onResume$___twin___() {
            super.onResume();
            updateStage(this.mUiStage);
            boolean r1 = true;
            this.mPasswordEntryInputDisabler.setInputEnabled(true);
            if (this.mIsAlphaMode == false) goto L5;
            this.mPasswordEntry.setFocusable(true);
            this.mPasswordEntry.requestFocus();
            OLog.e(ChooseLockPassword.TAG, "onResume mPasswordEntry requestFocus");
        L7:
            if (this.mApplicationsLock == true) goto L9;
            return;
        L9:
            if (this.mIsResetPwdByFindPwd == true) goto L22;
            long r2 = AppLockView.getLockoutAttemptDeadline(this.mUserId);
            if (this.mCountdownTimer != null) goto L15;
            r1 = false;
        L15:
            if (r2 == 0) goto L23;
            if (r1 == false) goto L18;
            return;
        L18:
            if (this.mIsResetPwdByFindPwd == true) goto L25;
            handleAttemptLockout(r2);
            return;
        L25:
            return;
        L23:
            return;
        L22:
            return;
        L5:
            this.mKeyboardView.requestFocus();
            goto L7
        }

        /* JADX WARN: Type inference failed for: r9v6, types: [com.android.settings.ChooseLockPassword$ChooseLockPasswordFragment$8] */
        private void handleAttemptLockout(long r9) {
            final long r4 = r9 - SystemClock.elapsedRealtime();
            if (r4 > 0) goto L6;
            return;
        L6:
            if (this.mApplicationsLock == false) goto L9;
            this.mCanEnterPassword = false;
        L11:
            final long r6 = 1000;
            this.mCountdownTimer = new AnonymousClass8(this, r4, r6).start();
            return;
        L9:
            if (this.mIsAlphaMode == true) goto L11;
            this.mKeyboardView.setVisibility(8);
            goto L11
        }

        @Override // androidx.fragment.app.Fragment
        public void onPause() {
            this.mHandler.removeMessages(1);
            AsyncTask<?, ?, ?> r0 = this.mPendingLockCheck;
            if (r0 == null) goto L5;
            r0.cancel(false);
            this.mPendingLockCheck = null;
        L5:
            super.onPause();
        }

        @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
        public void onStop() {
            super.onStop();
            if (this.mFromBytedanceosLauncher == false) goto L5;
            return;
        L5:
            if (this.mNeedResult == false) goto L7;
            return;
        L7:
            if (this.mOnConfigurationChanging == true) goto L12;
            Utils.finishActivityDelay(getActivity());
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

        @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
        public void onSaveInstanceState(Bundle r3) {
            super.onSaveInstanceState(r3);
            r3.putString(KEY_UI_STAGE, this.mUiStage.name());
            r3.putParcelable(KEY_FIRST_PASSWORD, this.mFirstPassword);
            LockscreenCredential r2 = this.mCurrentCredential;
            if (r2 == null) goto L6;
            r3.putParcelable(KEY_CURRENT_CREDENTIAL, r2.duplicate());
            return;
        }

        @Override // androidx.fragment.app.Fragment
        public void onActivityResult(int r4, int r5, Intent r6) {
            super.onActivityResult(r4, r5, r6);
            this.mNeedResult = false;
            if (r4 != 58) goto L5;
            if (r5 == (-1)) goto L17;
            getActivity().setResult(1);
            closeActivity();
            return;
        L17:
            this.mCurrentCredential = r6.getParcelableExtra("password");
            return;
        L5:
            if (r4 == 60) goto L12;
            if (r4 != 200) goto L23;
            if (r5 != (-1)) goto L19;
            AppLockView.setLockoutAttemptDeadline(this.mUserId, 0);
            AppLockView.setLockoutFailedTimes(this.mUserId, 0);
            gotoPrivacyPasswordSetting();
            return;
        L19:
            return;
        L23:
            return;
        L12:
            if (this.mFromBytedanceosLauncher == false) goto L14;
            getActivity().setResult(r5);
        L14:
            closeActivity();
        }

        protected void updateStage(Stage r2) {
            Stage r0 = this.mUiStage;
            this.mUiStage = r2;
            updateUi();
            if (r0 == r2) goto L6;
            TextView r1 = this.mHeaderText;
            r1.announceForAccessibility(r1.getText());
            return;
        }

        private String validatePassword(String r12) {
            int r0 = r12.length();
            int r1 = this.mPasswordMinLength;
            boolean r2 = false;
            if (r0 < r1) goto L5;
            int r3 = r12.length();
            int r4 = this.mPasswordMaxLength;
            if (r3 > r4) goto L13;
            int r5 = 0;
            int r6 = 0;
            int r7 = 0;
            int r8 = 0;
            int r9 = 0;
            int r10 = 0;
            int r11 = 0;
        L20:
            if (r5 >= r12.length()) goto L46;
            char r13 = r12.charAt(r5);
            if (r13 < ' ') goto L45;
            if (r13 > 127) goto L45;
            if (r13 < '0') goto L33;
            if (r13 > '9') goto L33;
            r8 = r8 + 1;
        L31:
            r9 = r9 + 1;
        L43:
            r5 = r5 + 1;
        L33:
            if (r13 < 'A') goto L38;
            if (r13 > 'Z') goto L38;
            r6 = r6 + 1;
            r11 = r11 + 1;
        L38:
            if (r13 >= 'a') goto L40;
        L42:
            r7 = r7 + 1;
            goto L31
        L40:
            if (r13 > 'z') goto L42;
            r6 = r6 + 1;
            r10 = r10 + 1;
        L45:
            return getString(R.string.lockpassword_illegal_character);
        L46:
            int r14 = this.mRequestedQuality;
            if (131072 == r14) goto L83;
            if (196608 == r14) goto L83;
            if (393216 != r14) goto L77;
            if (r6 >= this.mPasswordMinLetters) goto L57;
            return String.format(getResources().getQuantityString(R.plurals.lockpassword_password_requires_letters, this.mPasswordMinLetters), new Object[]{Integer.valueOf(this.mPasswordMinLetters)});
        L57:
            if (r8 >= this.mPasswordMinNumeric) goto L61;
            return String.format(getResources().getQuantityString(R.plurals.lockpassword_password_requires_numeric, this.mPasswordMinNumeric), new Object[]{Integer.valueOf(this.mPasswordMinNumeric)});
        L61:
            if (r10 >= this.mPasswordMinLowerCase) goto L65;
            return String.format(getResources().getQuantityString(R.plurals.lockpassword_password_requires_lowercase, this.mPasswordMinLowerCase), new Object[]{Integer.valueOf(this.mPasswordMinLowerCase)});
        L65:
            if (r11 >= this.mPasswordMinUpperCase) goto L69;
            return String.format(getResources().getQuantityString(R.plurals.lockpassword_password_requires_uppercase, this.mPasswordMinUpperCase), new Object[]{Integer.valueOf(this.mPasswordMinUpperCase)});
        L69:
            if (r7 >= this.mPasswordMinSymbols) goto L73;
            return String.format(getResources().getQuantityString(R.plurals.lockpassword_password_requires_symbols, this.mPasswordMinSymbols), new Object[]{Integer.valueOf(this.mPasswordMinSymbols)});
        L73:
            if (r9 < this.mPasswordMinNonLetter) goto L75;
        L95:
            LockscreenCredential r15 = this.mChosenPassword;
            if (r15 != null) goto L98;
            return null;
        L98:
            if (validatePassword(r15) == false) goto L100;
            return null;
        L100:
            return Arrays.toString(convertErrorCodeToMessages());
        L75:
            return String.format(getResources().getQuantityString(R.plurals.lockpassword_password_requires_nonletter, this.mPasswordMinNonLetter), new Object[]{Integer.valueOf(this.mPasswordMinNonLetter)});
        L77:
            if (327680 != r14) goto L79;
            r2 = true;
        L79:
            if (r2 == false) goto L95;
            if (r8 != 0) goto L95;
            return getString(R.string.lockpassword_password_requires_digit);
        L83:
            if (r6 > 0) goto L104;
            if (r7 > 0) goto L104;
            int r16 = InvisibleApi.maxLengthSequence(r12);
            if (196608 != this.mRequestedQuality) goto L95;
            if (r16 <= 3) goto L95;
            if (this.mIsHasBankCardInWallet == false) goto L94;
            return getString(R.string.lockpassword_pin_no_sequential_digits_for_wallet);
        L94:
            return getString(R.string.lockpassword_pin_no_sequential_digits);
        L104:
            return getString(R.string.lockpassword_pin_contains_non_digits);
        L13:
            if (this.mIsAlphaMode == false) goto L15;
            int r17 = R.string.lockpassword_password_too_long;
        L17:
            return getString(r17, new Object[]{Integer.valueOf(r4 + 1)});
        L15:
            r17 = R.string.lockpassword_pin_too_long;
            goto L17
        L5:
            if (this.mIsAlphaMode == false) goto L7;
            int r18 = R.string.lockpassword_password_too_short;
        L9:
            return getString(r18, new Object[]{Integer.valueOf(r1)});
        L7:
            r18 = R.string.lockpassword_pin_too_short;
            goto L9
        }

        private boolean isSimplePassword(String r9) {
            if (r9.isEmpty() == false) goto L5;
            return true;
        L5:
            char r1 = r9.charAt(0);
            int r2 = 1;
            boolean r3 = true;
            boolean r4 = true;
            boolean r5 = true;
        L7:
            if (r2 >= r9.length()) goto L18;
            char r6 = r9.charAt(r2);
            if (r1 == r6) goto L12;
            r3 = false;
        L12:
            if ((r1 + 1) == r6) goto L15;
            r4 = false;
        L15:
            if ((r1 - 1) == r6) goto L17;
            r5 = false;
        L17:
            r2 = r2 + 1;
            r1 = r6;
            goto L7
        L18:
            if (r3 == true) goto L27;
            if (r4 == true) goto L28;
            if (r5 == false) goto L23;
            return true;
        L23:
            return false;
        L28:
            return true;
        L27:
            return true;
        }

        private void handleNext() {
            String r0 = this.mPasswordEntry.getText().toString();
            if (TextUtils.isEmpty(r0) == false) goto L6;
            return;
        L6:
            if (this.mIsAlphaMode == false) goto L8;
            LockscreenCredential r1 = LockscreenCredential.createPassword(r0);
        L9:
            this.mChosenPassword = r1;
            if (getContext() != null) goto L13;
            return;
        L13:
            if (this.mUiStage != Stage.ConfirmPlateLock) goto L22;
            String r2 = validatePassword(r0);
            if (r2 == null) goto L17;
            showError(r2, this.mUiStage);
        L75:
            if (r2 == null) goto L78;
            showError(r2, this.mUiStage);
            return;
        L78:
            return;
        L17:
            if (AppLockUtil.checkPassword(getContext(), r0) == false) goto L19;
            this.mConfirmWrongPlateLock = false;
            Message r3 = new Message();
            r3.obj = this.mChosenPassword;
            r3.what = 7;
            this.mHandler.sendMessageDelayed(r3, 200);
            goto L75
        L19:
            this.mConfirmWrongPlateLock = true;
            handlePasswordEnterError();
            goto L75
        L22:
            if (this.mUiStage != Stage.Introduction) goto L29;
            r2 = validatePassword(r0);
            if (r2 != null) goto L26;
            this.mFirstSetPassword = true;
            Message r4 = new Message();
            r4.obj = this.mChosenPassword;
            r4.what = 2;
            this.mHandler.sendMessageDelayed(r4, 200);
            goto L75
        L26:
            updateInputArea(0, true);
            updateStage(Stage.Introduction);
            VibratorHelper.INSTANCE.reject(getActivity());
            return;
        L29:
            if (this.mUiStage != Stage.NeedToConfirm) goto L74;
            LockscreenCredential r5 = this.mFirstPassword;
            if (r5 == null) goto L35;
            if (r5.equals(this.mChosenPassword) == false) goto L35;
        L38:
            OLog.d(ChooseLockPassword.TAG, "mApplicationsLock: " + this.mApplicationsLock + ", mIsAppLocked: " + this.mIsAppLocked + ", hasConfirmedAppLockCorrectly: " + this.hasConfirmedAppLockCorrectly);
            if (this.mApplicationsLock == false) goto L68;
            if (this.mIsAppLocked == false) goto L60;
            if (AppLockUtil.checkMd5Password(getContext(), r0) == false) goto L55;
            AppLockView.setLockoutFailedTimes(this.mUserId, 0);
            this.mFirstSetPassword = false;
            if (this.mExitSmilingCloud == false) goto L48;
            gotoPrivacyPasswordSetting();
        L54:
            closeActivity();
            goto L74
        L48:
            if (this.mChangePassword == false) goto L51;
            AppLockUtil.clearPlatLock(getContext());
            AppLockUtil.setPrivacyPassword(getContext(), this.mChangePassword);
            gotoPrivacyPasswordSetting();
            goto L54
        L51:
            if (this.mSettingPassword == false) goto L53;
            this.mSettingPassword = false;
            gotoBindSmilingCloud();
            goto L54
        L53:
            gotoPrivacyPasswordSetting();
            goto L54
        L55:
            this.hasConfirmedAppLockCorrectly = true;
            AppLockView.setLockoutFailedTimes(this.mUserId, 0L);
            if (this.mIsTargetConfirmAppLock == false) goto L58;
            this.mHandler.sendEmptyMessage(5);
            goto L74
        L58:
            this.mHandler.sendEmptyMessage(4);
            goto L74
        L60:
            if (this.mChangePassword == false) goto L63;
            AppLockUtil.clearPlatLock(getContext());
            AppLockUtil.setPrivacyPassword(getContext(), this.mChangePassword);
        L66:
            closeActivity();
            goto L74
        L63:
            if (this.mSettingPassword == false) goto L65;
            this.mSettingPassword = false;
            gotoBindSmilingCloud();
            goto L66
        L65:
            gotoPrivacyPasswordSetting();
            goto L66
        L68:
            if (this.currentClickTime > 0) goto L70;
        L72:
            this.currentClickTime = System.currentTimeMillis();
            OLog.d(ChooseLockPassword.TAG, "start save lock password:" + this.mUserId);
            boolean r6 = this.mLockPatternUtils.isSecure(this.mUserId);
            getActivity().getIntent().getBooleanExtra(EncryptionInterstitial.EXTRA_REQUIRE_PASSWORD, true);
            new AnonymousClass9(this, this.mChosenPassword.duplicate(), r0, r6).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            goto L74
        L70:
            if ((System.currentTimeMillis() - this.currentClickTime) > this.clickDebounceTime) goto L72;
            return;
        L35:
            if (this.mChangePassword == false) goto L37;
        L73:
            handlePasswordEnterError();
            goto L74
        L37:
            if (AppLockUtil.checkMd5Password(getContext(), r0) == false) goto L73;
        L74:
            r2 = null;
            goto L75
        L8:
            r1 = LockscreenCredential.createPin(r0);
            goto L9
        }

        private void handlePasswordEnterError() {
            updateStage(Stage.ConfirmWrong);
            CharSequence r0 = this.mPasswordEntry.getText();
            if (r0 == null) goto L5;
            Selection.setSelection((Spannable) r0, 0, r0.length());
        L5:
            updateInputArea(this.EASY_PASSWORD_LENGTH, false);
            if (this.mFirstSetPassword == false) goto L8;
            return;
        L8:
            if (this.mApplicationsLock == false) goto L16;
            long r1 = AppLockView.getLockoutFailedTimes(this.mUserId) + 1;
            OLog.d(ChooseLockPassword.TAG, "wrong privacy pwd, failed times " + r1);
            AppLockView.setLockoutFailedTimes(this.mUserId, Long.valueOf(r1));
            if (r1 != 5) goto L12;
        L13:
            AppLockView.setLockoutAttemptDeadline(this.mUserId, 30999);
            long r2 = AppLockView.getLockoutAttemptDeadline(this.mUserId);
            OLog.d(ChooseLockPassword.TAG, "deadline: " + r2);
            handleAttemptLockout(r2);
            return;
        L12:
            if (r1 >= 10) goto L13;
            return;
        }

        private boolean finishSetupWizard() {
            BaseActivity r0 = (BaseActivity) getActivity();
            if (r0 != null) goto L5;
        L8:
            OLog.e(ChooseLockPassword.TAG, "finishSetupWizard return false");
            return false;
        L5:
            if (r0.mSetupWizardMode == false) goto L8;
            OLog.e(ChooseLockPassword.TAG, "finishSetupWizard, nextToAccount");
            RoutingUtils.nextToAccount(r0);
            getActivity().setResult(-1, Utils.getPasswordIntent(this.mChosenPassword, this.isInsideSettings));
            r0.finish();
            return true;
        }

        private void closeActivity() {
            LockscreenCredential r0 = this.mCurrentCredential;
            if (r0 == null) goto L5;
            r0.zeroize();
            this.mCurrentCredential = null;
        L5:
            LockscreenCredential r1 = this.mChosenPassword;
            if (r1 == null) goto L8;
            r1.zeroize();
            this.mChosenPassword = null;
        L8:
            LockscreenCredential r2 = this.mFirstPassword;
            if (r2 == null) goto L12;
            r2.zeroize();
            this.mFirstPassword = null;
        L12:
            if (getActivity() == null) goto L15;
            getActivity().finish();
            return;
        }

        private void gotoFindPassword() {
            ChooseLockPassword.access$3702(true);
            FragmentActivity r1 = getActivity();
            if (r1 == null) goto L6;
            Intent r2 = new Intent(r1, FindingPasswordActivity.class);
            r2.putExtra("back_text_id", R.string.security_item_applications_lock);
            r2.putExtra("isFindingPassword", true);
            r2.putExtra("SHOW_LAUNCHPAD", false);
            r1.setResult(0, r2);
            startActivity(r2);
            return;
        }

        private void gotoFindPasswordWaysSetting() {
            Intent r0 = new Intent(getActivity(), FindPasswordWaysActivity.class);
            r0.putExtra(ChooseLockPassword.FROM_BYTEDANCEOS_LAUNCHER, this.mFromBytedanceosLauncher);
            r0.putExtra("password", this.mPasswordEntry.getText().toString());
            startActivityForResult(r0, 60);
        }

        private void gotoBindSmilingCloud() {
            Intent r0 = new Intent(getActivity(), BindCloudActivity.class);
            r0.addFlags(VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING);
            r0.putExtra(AppLockUtil.FROM_BYTEDANCEOS_LAUNCHPAD, this.mFromBytedanceosLaunchpad);
            startActivity(r0);
            ChooseLockPassword.access$3702(true);
        }

        private void gotoPrivacyPasswordSetting() {
            Intent r0 = new Intent(getActivity(), PrivacyPasswordSettingActivity.class);
            r0.putExtra(AppLockUtil.EXIT_SMILING_CLOUD, this.mExitSmilingCloud);
            r0.putExtra(AppLockUtil.CHANGE_APPLICATION_LOCK_PASSWORD, this.mChangePassword);
            r0.putExtra(AppLockUtil.FROM_BYTEDANCEOS_LAUNCHPAD, this.mFromBytedanceosLaunchpad);
            r0.addFlags(VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING);
            startActivity(r0);
            if (getActivity() == null) goto L5;
            getActivity().overridePendingTransition(R.anim.pop_up_in, R.anim.fake_anim);
        L5:
            ChooseLockPassword.access$3702(true);
        }

        private void gotoCloudCheckPassword() {
            Intent r0 = new Intent();
            r0.setComponent(new ComponentName(ChooseLockPassword.CLOUD_SYNC_PACKAGE, ChooseLockPassword.CLOUD_SYNC_CHECK_CLASS));
            r0.putExtra("bytedanceos.intent.extra.ANIM_RESOURCE_ID", new int[]{0, R.anim.slide_down_out});
            r0.putExtra(ChooseLockPassword.CHECK_FROM, 2);
            Bundle r1 = new Bundle();
            r1.putString(ChooseLockPassword.CUSTOM_TITLE, getString(R.string.cloud_check_password));
            if (TextUtils.isEmpty(getAccount()) == false) goto L5;
            String r2 = getString(R.string.cloudid_message);
        L6:
            r1.putString(ChooseLockPassword.CUSTOM_MESSAGE, r2);
            r0.putExtra(ChooseLockPassword.PARAMS_DATA, r1);
            startActivityForResult(r0, 200);
            getActivity().overridePendingTransition(R.anim.pop_up_in, R.anim.fake_anim);
            return;
        L5:
            r2 = getString(R.string.cloudid_message_with_account, new Object[]{getAccount()});
            goto L6
        }

        private String getAccount() {
            if (isPermissionDenied() == false) goto L5;
            return "";
        L5:
            Bundle r4 = getContext().getContentResolver().call(Uri.parse(ChooseLockPassword.CLOUD_ID_PROVIDER), ChooseLockPassword.REQUEST_ACCOUNT_PHONE, null, null);
            if (r4 == null) goto L13;
            int r0 = r4.getInt("result", -1);
            String r5 = r4.getString(ChooseLockPassword.ACCOUNT_KEY_PHONE_NUMBER, "");
            if (r0 == 0) goto L10;
            return r5;
        L10:
            if (r5.length() > 7) goto L12;
            return r5;
        L12:
            return r5.substring(0, 3) + ChooseLockPassword.MASK_TEXT + r5.substring(7);
        L13:
            return null;
        }

        private boolean isPermissionDenied() {
            if (((Context) NullSafe.nonNull(getContext())).checkCallingOrSelfPermission(ChooseLockPassword.CLOUD_ID_PERMISSION) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        private void resetUiIfConfirmWrong() {
            if (isAdded() == true) goto L5;
            return;
        L5:
            if (this.mHandler.hasMessages(3) == false) goto L8;
            this.mHandler.removeMessages(3);
        L8:
            if (this.mUiStage != Stage.ConfirmWrong) goto L12;
            updateUi();
            this.mUiStage = Stage.NeedToConfirm;
            clearPasswordEntry();
            return;
        }

        /* JADX WARN: Type inference failed for: r3v2, types: [com.android.settings.ChooseLockPassword$ChooseLockPasswordFragment$10] */
        private void startVerifyPassword(final LockscreenCredential r2, boolean r3) {
            this.mPasswordEntryInputDisabler.setInputEnabled(false);
            setNextEnabled(false);
            new AnonymousClass10(this, r2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }

        private void handleEnrolling(LockscreenCredential r4) {
            FragmentActivity r3 = getActivity();
            LockscreenCredential r5 = r4.duplicate();
            if (r5 != null) goto L5;
        L8:
            boolean r0 = true;
        L9:
            OLog.i(ChooseLockPassword.TAG, "handleEnrolling activity=" + r3 + ", pwdInvalid=" + r0);
            BiometricsUtils.INSTANCE.handleEnrolling(r3, r5);
            return;
        L5:
            if (r5.isNone() == true) goto L8;
            r0 = false;
            goto L9
        }

        private boolean handlePasswordCreated(VerifyCredentialResponse r7) {
            FragmentActivity r0 = getActivity();
            boolean r1 = false;
            if (r0 != null) goto L6;
            return false;
        L6:
            if (this.mIsFromWallet == false) goto L19;
            ToastUtils.show(getActivity(), R.string.lock_pwd_setup_success);
            FingerprintManager r2 = this.mFm;
            if (r2 != null) goto L10;
        L17:
            getActivity().setResult(-1, Utils.getPasswordIntent(this.mChosenPassword, this.isInsideSettings));
            closeActivity();
            r0.overridePendingTransition(0, R.anim.slide_down_out);
        L18:
            return true;
        L10:
            if (r2.isHardwareDetected() == false) goto L17;
            if (Utils.isFingerprintExists(r0) == true) goto L17;
            Intent r3 = BaseFingerprintEnrollingActivity.launchFingerprintEnrollingActivity(r0, this.mFingerType);
            StringBuilder r4 = new StringBuilder("handlePasswordCreated EXTRA_KEY_CHALLENGE_TOKEN: token==null ");
            if (r7 != null) goto L16;
            r1 = true;
        L16:
            OLog.i(ChooseLockPassword.TAG, r4.append(r1).toString());
            r3.putExtra("hw_auth_token", r7);
            r3.putExtra("back_text_id", R.string.short_cancel);
            r3.addFlags(VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING);
            r3.putExtras(getActivity().getIntent().getExtras());
            Utils.startActivity(r0, r3);
            this.mHandler.postDelayed(new AnonymousClass11(this), 1000);
            goto L18
        L19:
            return false;
        }

        protected void setNextEnabled(boolean r2) {
            View r0 = this.mNextButton;
            if (r0 == null) goto L5;
            r0.setEnabled(r2);
        L5:
            View r1 = this.mNextImageView;
            if (r1 == null) goto L9;
            r1.setEnabled(r2);
            return;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r3) {
            ObjectAnimator r0 = this.mDotShakeAnim;
            if (r0 == null) goto L8;
            if (r0.isRunning() == false) goto L8;
            return;
        L8:
            if (this.mCancelView != r3) goto L11;
            closeActivity();
            return;
        L11:
            if (this.mNextButton == r3) goto L53;
            if (this.mNextImageView == r3) goto L53;
            if (r3 != this.mSwitchDigitView) goto L19;
            showChooseLockMenuDialog();
            return;
        L19:
            if (this.mCanEnterPassword == true) goto L21;
            return;
        L21:
            Editable r1 = this.mPasswordEntry.getVInput().getEditableText();
            if (r3 != this.mBtn1) goto L25;
            r1.append("1");
        L51:
            this.mMediator.playPinKeyboardSound();
            return;
        L25:
            if (r3 != this.mBtn2) goto L28;
            r1.append(ExifInterface.GPS_MEASUREMENT_2D);
            goto L51
        L28:
            if (r3 != this.mBtn3) goto L31;
            r1.append(ExifInterface.GPS_MEASUREMENT_3D);
            goto L51
        L31:
            if (r3 != this.mBtn4) goto L34;
            r1.append("4");
            goto L51
        L34:
            if (r3 != this.mBtn5) goto L37;
            r1.append("5");
            goto L51
        L37:
            if (r3 != this.mBtn6) goto L40;
            r1.append("6");
            goto L51
        L40:
            if (r3 != this.mBtn7) goto L43;
            r1.append("7");
            goto L51
        L43:
            if (r3 != this.mBtn8) goto L46;
            r1.append("8");
            goto L51
        L46:
            if (r3 != this.mBtn9) goto L49;
            r1.append("9");
            goto L51
        L49:
            if (r3 != this.mBtn0) goto L51;
            r1.append("0");
        L53:
            if (this.mFromBytedanceosLauncher == false) goto L55;
            getActivity().setResult(0);
            closeActivity();
            return;
        L55:
            handleNext();
        }

        private void showError(String r2, Stage r3) {
            this.mHeaderText.setText(r2);
            Message r4 = this.mHandler.obtainMessage(1, r3);
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessage(r4);
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView r1, int r2, KeyEvent r3) {
            if (r2 != 0) goto L4;
        L10:
            handleNext();
            return true;
        L4:
            if (r2 == 6) goto L10;
            if (r2 == 5) goto L10;
            return false;
        }

        private void updateUi() {
            String r0 = this.mPasswordEntry.getText().toString();
            int r1 = r0.length();
            boolean r4 = true;
            if (this.mUiStage != Stage.ConfirmWrong) goto L5;
            boolean r2 = true;
        L6:
            Stage r3 = this.mUiStage;
            Stage r6 = Stage.ConfirmPlateLock;
            int r8 = R.string.lockpassword_password_too_short;
            if (r3 != r6) goto L33;
            if (r1 <= 0) goto L33;
            int r5 = this.mPasswordMinLength;
            if (r1 >= r5) goto L17;
            boolean r7 = this.mIsAlphaMode;
            if (r7 == false) goto L62;
            if (r7 == true) goto L16;
            r8 = R.string.lockpassword_pin_too_short;
        L16:
            this.mHeaderText.setText(getString(r8, new Object[]{Integer.valueOf(r5)}));
        L62:
            updateHeaderView(null, r2);
            if (this.mFromBytedanceosLauncher == false) goto L65;
            return;
        L65:
            if (this.mIsAlphaMode == false) goto L73;
            this.titleBar.removeAllEndAction();
            if (this.mUiStage == Stage.NeedToConfirm) goto L69;
            this.mNextButton = this.titleBar.addEndAction(getString(this.mUiStage.buttonText), -1, this);
            setTextColor(getContext().getColor(R.color.oui_functional_blue_6));
        L70:
            setNextEnabled(false);
            return;
        L69:
            createImageView(R.drawable.o_card_list_item_tail_icon_mark);
            this.mNextImageView.setOnClickListener(this);
            goto L70
        L73:
            return;
        L17:
            String r9 = validatePassword(r0);
            if (r9 == null) goto L23;
            updateHeaderView(r9, true);
            updateInputArea(this.EASY_PASSWORD_LENGTH, false);
            if (this.mHandler.hasMessages(6) == false) goto L31;
            this.mHandler.removeMessages(6);
        L31:
            r2 = r4;
            goto L62
        L23:
            if (this.mApplicationsLock == false) goto L28;
            if (this.mConfirmWrongPlateLock == true) goto L28;
            adjustHeaderTextForAppLock();
        L30:
            r4 = r2;
        L28:
            if (this.mIsAlphaMode == false) goto L30;
            this.mHeaderText.setText(R.string.lockpassword_press_continue);
        L33:
            if (this.mUiStage != Stage.Introduction) goto L55;
            if (r1 <= 0) goto L55;
            int r10 = this.mPasswordMinLength;
            if (r1 >= r10) goto L43;
            boolean r11 = this.mIsAlphaMode;
            if (r11 == false) goto L62;
            if (r11 == true) goto L42;
            r8 = R.string.lockpassword_pin_too_short;
        L42:
            this.mHeaderText.setText(getString(r8, new Object[]{Integer.valueOf(r10)}));
            goto L62
        L43:
            String r12 = validatePassword(r0);
            if (r12 == null) goto L49;
            updateHeaderView(r12, true);
            updateInputArea(this.EASY_PASSWORD_LENGTH, false);
            if (this.mHandler.hasMessages(6) == false) goto L31;
            this.mHandler.removeMessages(6);
            goto L31
        L49:
            if (this.mApplicationsLock == false) goto L52;
            adjustHeaderTextForAppLock();
            goto L30
        L52:
            if (this.mIsAlphaMode == false) goto L30;
            this.mHeaderText.setText(R.string.lockpassword_press_continue);
        L55:
            if (this.mApplicationsLock == false) goto L57;
            adjustHeaderTextForAppLock();
            goto L62
        L57:
            TextView r13 = this.mHeaderText;
            if (this.mIsAlphaMode == false) goto L60;
            int r14 = this.mUiStage.alphaHint;
        L61:
            r13.setText(r14);
            goto L62
        L60:
            r14 = this.mUiStage.numericHint;
            goto L61
        L5:
            r2 = false;
            goto L6
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        private void createImageView(int r5) {
            ImageView r0 = new ImageView(getContext());
            this.mNextImageView = r0;
            r0.setBackgroundResource(r5);
            OUIFrameLayout r6 = new OUIFrameLayout(getContext());
            int r1 = UIUtils.INSTANCE.dp2px(7);
            r6.setPadding(r1, r1, r1, r1);
            r6.setClickable(true);
            FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(UIUtils.INSTANCE.dp2px(22), UIUtils.INSTANCE.dp2px(22));
            r2.gravity = 17;
            r6.addView(this.mNextImageView, r2);
            this.titleBar.addEndAction(r6, -1);
        }

        private void setTextColor(int r2) {
            View r1 = this.mNextButton;
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

        private void clearTintColor() {
            View r0 = this.mNextButton;
            if (r0 != null) goto L5;
            return;
        L5:
            if ((r0 instanceof ViewGroup) == false) goto L13;
            View r1 = ((ViewGroup) r0).getChildAt(0);
            if ((r1 instanceof ImageView) == false) goto L12;
            ((ImageView) r1).setColorFilter(getContext().getColor(R.color.oui_accent_6_bg));
            return;
        L12:
            return;
        }

        private void adjustHeaderTextForAppLock() {
            if (this.mApplicationsLock == true) goto L5;
            return;
        L5:
            if (this.mIsAppLocked == false) goto L26;
            if (this.mUiStage != Stage.ConfirmPlateLock) goto L10;
            this.mHeaderText.setText(R.string.security_item_plate_lock_four_password);
            return;
        L10:
            if (this.mUiStage != Stage.NeedToConfirm) goto L15;
            if (this.hasConfirmedAppLockCorrectly == true) goto L15;
            this.mHeaderText.setText(R.string.security_enter_password);
            return;
        L15:
            if (this.mUiStage != Stage.Introduction) goto L18;
            this.mHeaderText.setText(R.string.security_app_lock_six_password);
            return;
        L18:
            if (this.mUiStage != Stage.NeedToConfirm) goto L23;
            if (this.hasConfirmedAppLockCorrectly == false) goto L23;
            this.mHeaderText.setText(R.string.security_app_lock_confirm_password);
            return;
        L23:
            if (this.mUiStage != Stage.ConfirmWrong) goto L41;
            this.mHeaderText.setText(R.string.security_item_applications_lock_nomatch);
            return;
        L41:
            return;
        L26:
            if (this.mUiStage != Stage.ConfirmPlateLock) goto L29;
            this.mHeaderText.setText(R.string.security_item_plate_lock_four_password);
            return;
        L29:
            if (this.mUiStage != Stage.Introduction) goto L32;
            this.mHeaderText.setText(R.string.security_app_lock_six_password);
            return;
        L32:
            if (this.mUiStage != Stage.ConfirmWrong) goto L34;
            this.mHeaderText.setText(R.string.security_item_applications_lock_nomatch);
            return;
        L34:
            this.mHeaderText.setText(R.string.security_app_lock_confirm_password);
        }

        private void updateHeaderView(int r1, boolean r2) {
            updateHeaderView(getString(r1), r2);
        }

        private void updateHeaderView(String r2, boolean r3) {
            this.mHasError = r3;
            if (r2 == null) goto L5;
            this.mHeaderText.setText(r2);
        L5:
            if (r3 == false) goto L9;
            this.mHeaderText.setTextColor(getResources().getColor(R.color.lock_screen_header_warning_text_color));
            if (this.mIsAlphaMode == false) goto L11;
            Utils.vibratorUnlockNoPass(getActivity());
            playHeaderTextViewAnim();
            return;
        L11:
            return;
        L9:
            this.mHeaderText.setTextColor(getResources().getColor(R.color.oui_basic_text_1));
        }

        private void updateInputArea(int r5, boolean r6) {
            if (this.mIsAlphaMode == false) goto L5;
            return;
        L5:
            int r2 = 0;
            if (this.EASY_PASSWORD_LENGTH != 4) goto L8;
            this.dots[0].setVisibility(4);
            ImageView[] r0 = this.dots;
            r0[r0.length - 1].setVisibility(4);
            r5 = r5 + 1;
        L9:
            if (r6 == false) goto L16;
        L10:
            ImageView[] r7 = this.dots;
            if (r2 >= r7.length) goto L28;
            if (r2 >= r5) goto L14;
            r7[r2].setImageResource(R.drawable.easy_password_dot_full);
        L15:
            r2 = r2 + 1;
            goto L10
        L14:
            r7[r2].setImageResource(R.drawable.easy_password_dot_empty);
            goto L15
        L28:
            return;
        L16:
            ImageView[] r8 = this.dots;
            if (r2 >= r8.length) goto L19;
            r8[r2].setImageResource(R.drawable.easy_password_dot_error);
            r2 = r2 + 1;
            goto L16
        L19:
            playDotShakeAnim();
            FragmentActivity r4 = getActivity();
            if (r4 == null) goto L27;
            Utils.vibratorUnlockNoPass(r4);
            return;
        L27:
            return;
        L8:
            this.dots[0].setVisibility(0);
            ImageView[] r1 = this.dots;
            r1[r1.length - 1].setVisibility(0);
            goto L9
        }

        private void showChooseLockMenuDialog() {
            if (this.mChooseLockTypeDialog != null) goto L9;
            OMenuDialog r0 = new OMenuDialog(getActivity());
            this.mChooseLockTypeDialog = r0;
            r0.setTitle(R.string.password_selection);
            ArrayList r1 = new ArrayList();
            if (this.EASY_PASSWORD_LENGTH != 4) goto L7;
            r1.add(getString(R.string.use_six_digit_pin_code));
        L8:
            ArrayList r2 = new ArrayList();
            r2.add(new AnonymousClass12(this));
            OMenuDialogListAdapter r3 = new OMenuDialogListAdapter(getActivity(), r1, r2);
            this.mChooseLockTypeDialog.setAdapter(r3);
            goto L9
        L7:
            r1.add(getString(R.string.use_four_digit_pin_code));
        L9:
            this.mChooseLockTypeDialog.setOnDismissListener(new AnonymousClass13(this));
            if (this.mChooseLockTypeDialog.isShowing() == true) goto L13;
            this.mChooseLockTypeDialog.show();
            return;
        }

        private void playHeaderTextViewAnim() {
            ObjectAnimator r0 = this.mHeaderTextShakeAnim;
            if (r0 != null) goto L5;
        L7:
            ObjectAnimator r1 = Utils.createShakeAnim(this.mHeaderText, new AnonymousClass14(this));
            this.mHeaderTextShakeAnim = r1;
            r1.start();
            return;
        L5:
            if (r0.isRunning() == false) goto L7;
        }

        private void playDotShakeAnim() {
            ObjectAnimator r0 = this.mDotShakeAnim;
            if (r0 != null) goto L5;
        L7:
            ObjectAnimator r1 = Utils.createShakeAnim(this.mPasswordContainer, new AnonymousClass15(this));
            this.mDotShakeAnim = r1;
            r1.start();
            return;
        L5:
            if (r0.isRunning() == false) goto L7;
        }

        boolean validatePassword(LockscreenCredential r4) {
            List<PasswordValidationError> r0 = PasswordMetrics.validateCredential(this.mLockPatternUtils.getRequestedPasswordMetrics(this.mUserId), getAggregatedPasswordComplexity(), r4);
            this.mValidationErrors = r0;
            if (r0.isEmpty() == true) goto L5;
        L7:
            OLog.d(ChooseLockPassword.TAG, "validatePassword: validationErrors:" + this.mValidationErrors + " complexity:" + getAggregatedPasswordComplexity());
            OLog.d(ChooseLockPassword.TAG, "complexity:" + this.mLockPatternUtils.getDevicePolicyManager().getPasswordComplexity());
            return this.mValidationErrors.isEmpty();
        L5:
            if (this.mLockPatternUtils.checkPasswordHistory(r4.getCredential(), getPasswordHistoryHashFactor(), this.mUserId) == false) goto L7;
            this.mValidationErrors = Collections.singletonList(new PasswordValidationError(14));
            goto L7
        }

        private byte[] getPasswordHistoryHashFactor() {
            if (this.mPasswordHistoryHashFactor != null) goto L10;
            LockPatternUtils r0 = this.mLockPatternUtils;
            LockscreenCredential r1 = this.mCurrentCredential;
            if (r1 != null) goto L8;
            r1 = LockscreenCredential.createNone();
        L8:
            this.mPasswordHistoryHashFactor = r0.getPasswordHistoryHashFactor(r1, this.mUserId);
        L10:
            return this.mPasswordHistoryHashFactor;
        }

        public int getAggregatedPasswordComplexity() {
            return Math.max(Math.max(this.mRequestedMinComplexity, this.mLockPatternUtils.getRequestedPasswordComplexity(this.mUserId, false)), this.mLockPatternUtils.getRequestedPasswordComplexity(this.mUserId));
        }

        String[] convertErrorCodeToMessages() {
            ArrayList r0 = new ArrayList();
            Iterator<PasswordValidationError> r1 = this.mValidationErrors.iterator();
        L4:
            if (r1.hasNext() == false) goto L40;
            PasswordValidationError r2 = r1.next();
            switch(r2.errorCode) {
                case 2: goto L38;
                case 3: goto L26;
                case 4: goto L25;
                case 5: goto L20;
                case 6: goto L19;
                case 7: goto L18;
                case 8: goto L17;
                case 9: goto L16;
                case 10: goto L15;
                case 11: goto L14;
                case 12: goto L13;
                case 13: goto L12;
                case 14: goto L8;
                default: goto L7;
            };
        L8:
            DevicePolicyManager r3 = (DevicePolicyManager) getContext().getSystemService(DevicePolicyManager.class);
            if (this.mIsAlphaMode == true) goto L10;
            r0.add(r3.getResources().getString("Settings.PIN_RECENTLY_USED", new ChooseLockPassword$ChooseLockPasswordFragment$$ExternalSyntheticLambda2(this)));
            goto L4
        L10:
            r0.add(r3.getResources().getString("Settings.PASSWORD_RECENTLY_USED", new ChooseLockPassword$ChooseLockPasswordFragment$$ExternalSyntheticLambda1(this)));
            goto L4
        L12:
            r0.add(StringUtil.getIcuPluralsString(getContext(), r2.requirement, R.string.lockpassword_password_requires_nonnumerical));
            goto L4
        L13:
            r0.add(StringUtil.getIcuPluralsString(getContext(), r2.requirement, R.string.lockpassword_password_requires_nonletter));
            goto L4
        L14:
            r0.add(StringUtil.getIcuPluralsString(getContext(), r2.requirement, R.string.lockpassword_password_requires_symbols));
            goto L4
        L15:
            r0.add(StringUtil.getIcuPluralsString(getContext(), r2.requirement, R.string.lockpassword_password_requires_numeric));
            goto L4
        L16:
            r0.add(StringUtil.getIcuPluralsString(getContext(), r2.requirement, R.string.lockpassword_password_requires_lowercase));
            goto L4
        L17:
            r0.add(StringUtil.getIcuPluralsString(getContext(), r2.requirement, R.string.lockpassword_password_requires_uppercase));
            goto L4
        L18:
            r0.add(StringUtil.getIcuPluralsString(getContext(), r2.requirement, R.string.lockpassword_password_requires_letters));
            goto L4
        L19:
            r0.add(getString(R.string.lockpassword_pin_no_sequential_digits));
            goto L4
        L20:
            Context r4 = getContext();
            int r5 = r2.requirement + 1;
            if (this.mIsAlphaMode == false) goto L23;
            int r6 = R.string.lockpassword_password_too_long_new;
        L24:
            r0.add(StringUtil.getIcuPluralsString(r4, r5, r6));
            goto L4
        L23:
            r6 = R.string.lockpassword_pin_too_long_new;
            goto L24
        L25:
            r0.add(StringUtil.getIcuPluralsString(getContext(), r2.requirement, R.string.lockpassword_password_too_short_all_numeric));
            goto L4
        L26:
            Context r7 = getContext();
            int r8 = r2.requirement;
            if (this.mIsAlphaMode == false) goto L29;
            int r9 = R.string.lockpassword_password_too_short_new;
        L30:
            String r10 = StringUtil.getIcuPluralsString(r7, r8, r9);
            if (LockPatternUtils.isAutoPinConfirmFeatureAvailable() == true) goto L33;
        L37:
            r0.add(r10);
            goto L4
        L33:
            if (this.mIsAlphaMode == true) goto L37;
            if (r2.requirement >= 6) goto L37;
            HashMap r11 = new HashMap();
            r11.put("count", Integer.valueOf(r2.requirement));
            r11.put("minAutoConfirmLen", 6);
            r10 = StringUtil.getIcuPluralsString(getContext(), r11, R.string.lockpassword_pin_too_short_autoConfirm_extra_message);
            goto L37
        L29:
            r9 = R.string.lockpassword_pin_too_short_new;
            goto L30
        L38:
            r0.add(getString(R.string.lockpassword_illegal_character_new));
            goto L4
        L7:
            OLog.e(ChooseLockPassword.TAG, "unknown error validating password: " + r2);
            Log.wtf(ChooseLockPassword.TAG, "unknown error validating password: " + r2);
            goto L4
        L40:
            return (String[]) r0.toArray(new String[0]);
        }

        /* JADX INFO: renamed from: lambda$convertErrorCodeToMessages$1$com-android-settings-ChooseLockPassword$ChooseLockPasswordFragment, reason: not valid java name */
        /* synthetic */ String m106xd0ca7345() {
            return getString(R.string.lockpassword_password_recently_used);
        }

        /* JADX INFO: renamed from: lambda$convertErrorCodeToMessages$2$com-android-settings-ChooseLockPassword$ChooseLockPasswordFragment, reason: not valid java name */
        /* synthetic */ String m107x6d386fa4() {
            return getString(R.string.lockpassword_pin_recently_used_new);
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_ChooseLockPassword$ChooseLockPasswordFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ChooseLockPasswordFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_ChooseLockPassword$ChooseLockPasswordFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_ChooseLockPassword$ChooseLockPasswordFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ChooseLockPasswordFragment r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_ChooseLockPassword$ChooseLockPasswordFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_ChooseLockPassword$ChooseLockPasswordFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ChooseLockPasswordFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_ChooseLockPassword$ChooseLockPasswordFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    @Override // com.android.settings.base.BaseActivity, android.app.Activity
    public void finish() {
        com_android_settings_ChooseLockPassword_com_obric_hook_lancet_PrivacyHook_finish(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_ChooseLockPassword_com_obric_hook_lancet_PrivacyHook_onCreate(this, r1);
    }

    public ChooseLockPassword() {
    }

    static /* synthetic */ boolean access$3702(boolean r0) {
        sChooseLockPasswordSuccessed = r0;
        return r0;
    }

    public static Intent createIntent(Context r2, int r3, int r4, int r5, boolean r6, boolean r7) {
        Intent r8 = new Intent().setClass(r2, ChooseLockPassword.class);
        r8.putExtra("lockscreen.password_type", r3);
        r8.putExtra(PASSWORD_MIN_KEY, r4);
        r8.putExtra(PASSWORD_MAX_KEY, r5);
        r8.putExtra(ChooseLockGeneric.CONFIRM_CREDENTIALS, r7);
        r8.putExtra(EncryptionInterstitial.EXTRA_REQUIRE_PASSWORD, r6);
        return r8;
    }

    public static Intent createIntent(Context r6, int r7, int r8, int r9, boolean r10, LockscreenCredential r11) {
        Intent r12 = createIntent(r6, r7, r8, r9, r10, false);
        if (r11 != null) goto L5;
        OLog.i(TAG, "createIntent password is null");
    L5:
        r12.putExtra("password", r11);
        return r12;
    }

    public static Intent createIntent(Context r6, int r7, int r8, int r9, boolean r10, long r11) {
        Intent r12 = createIntent(r6, r7, r8, r9, r10, false);
        r12.putExtra(ChooseLockSettingsHelper.EXTRA_KEY_HAS_CHALLENGE, true);
        r12.putExtra("challenge", r11);
        return r12;
    }

    public void com_android_settings_ChooseLockPassword__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        setContentView(R.layout.choose_lock_password_activity);
        this.mFingerType = getIntent().getIntExtra(FingerprintManageFragment.FINGER_TYPE, -1);
        this.mFromBytedanceLauncher = getIntent().getBooleanExtra(FROM_BYTEDANCEOS_LAUNCHER, false);
        this.mFromBytedanceosLaunchpad = getIntent().getBooleanExtra(AppLockUtil.FROM_BYTEDANCEOS_LAUNCHPAD, false);
        this.fromProvision = getIntent().getBooleanExtra(BaseFingerprintEnrollingActivity.EXTRA_FROM_PROVISION, false);
        PrivacySecurity.getInstance(this.mContext);
        AppLockManager.getInstance(this.mContext);
        sChooseLockPasswordSuccessed = false;
        OLog.d(TAG, "from Launcher:" + this.mFromBytedanceLauncher);
        if (Utils.isDeviceProvisioned(this.mContext) == true) goto L5;
        getWindow().addFlags(524288);
    L5:
        WindowUtils.Companion.addSecureFlag(this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean r2) {
        super.onWindowFocusChanged(r2);
        OLog.e(TAG, "onWindowFocusChanged:" + r2);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        recreate();
    }

    @Override // com.android.settings.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (this.mFromBytedanceLauncher == false) goto L6;
        setResult(0);
        finish();
        return;
    }

    public void com_android_settings_ChooseLockPassword__finish$___twin___() {
        super.finish();
        if (this.mSetupWizardMode == false) goto L5;
        return;
    L5:
        Utils.hideInputMethod(this);
        if (sChooseLockPasswordSuccessed == true) goto L9;
        AppLockUtil.sendPwdErrCodeBroadcast(this.mContext, this.mFromBytedanceosLaunchpad, 0);
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_ChooseLockPassword_com_obric_hook_lancet_PrivacyHook_onCreate(ChooseLockPassword r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ChooseLockPassword r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_ChooseLockPassword__onCreate$___twin___(r4);
    }

    @Insert("finish")
    public static void com_android_settings_ChooseLockPassword_com_obric_hook_lancet_PrivacyHook_finish(ChooseLockPassword r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ChooseLockPassword r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.superFinish();
        return;
    L6:
        r3.com_android_settings_ChooseLockPassword__finish$___twin___();
    }
}
