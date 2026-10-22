package com.android.settings.fingerprint;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.biometrics.SensorProperties;
import android.hardware.fingerprint.Fingerprint;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintSensorProperties;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserHandle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.android.internal.widget.LockPatternUtils;
import com.android.internal.widget.LockscreenCredential;
import com.android.internal.widget.VerifyCredentialResponse;
import com.android.settings.AdapterActivity;
import com.android.settings.ChooseLockSettingsHelper;
import com.android.settings.ConfirmLockBaseActivity;
import com.android.settings.PrivacySecurity;
import com.android.settings.R;
import com.android.settings.Settings;
import com.android.settings.SettingsFeature;
import com.android.settings.Utils;
import com.android.settings.biometrics.FaceRecognitionHelper;
import com.android.settings.fingerprint.utils.FingerprintUtils;
import com.android.settings.provision.ProvisionConstants;
import com.android.settings.widget.FingerprintEnrollProgressView;
import com.android.settings.widget.FrontFingerprintAnimView;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseFingerprintEnrollingActivity extends ConfirmLockBaseActivity implements FingerprintEnrollProgressView.Callback, FingerprintEnrollSidecar.Listener {
    protected static final int CONFIRM_REQUEST = 1;
    protected static final int DELAY_TIME_OF_PROMPT = 1000;
    protected static final Long DELAY_TIME_START_ENROLL = null;
    protected static final int EVENT_ENROLLING_PROGRESS_CHANGED = 108;
    public static final int EVENT_ENROLLMENT_HELP_MSG_CODE = 6;
    public static final String EXTRA_FROM_ASSISTANT = "from_assistant";
    public static final String EXTRA_FROM_FP_MANAGER = "from_fp_manager";
    public static final String EXTRA_FROM_PROVISION = "from_provision";
    public static final String EXTRA_PWD = "extra_pwd";
    protected static final int MSG_FINISH_ACTIVITY = 2;
    protected static final int MSG_PROMPT_FINGER_UP = 1;
    protected static final int MSG_START_ENROLL = 3;
    private static final int MY_USER_ID = 0;
    protected static final String TAG = "BaseFingerprintEnrollingActivity";
    protected static final String TAG_SIDECAR = "sidecar";
    protected boolean fromAssistant;
    protected boolean fromProvision;
    protected boolean isFirstFingerprint;
    protected boolean isFromFpManager;
    private OAlertDialog mBackAlertDialog;
    protected STEP mCurrentStep;
    protected Button mDoneButton;
    protected Button mEnrollNextFinger;
    protected boolean mEnrollingFaceRecognitionData;
    protected FrontFingerprintAnimView mFingerprintAnimView;
    private FingerprintManager.LockoutResetCallback mFingerprintLockoutResetCallback;
    FingerprintManager mFingerprintManager;
    protected Button mGotoFaceEnroll;
    protected Handler mHandler;
    protected boolean mIsClickBackButton;
    protected boolean mIsFingerPressing;
    protected boolean mIsFromSetupWizard;
    protected boolean mIsFromWallet;
    private boolean mIsStartEnrollDone;
    protected int mLastRemainCount;
    private LockPatternUtils mLockPatternUtils;
    protected int mLockedFingerNum;
    protected int mMaxFingerNum;
    private AsyncTask<?, ?, ?> mPendingLockCheck;
    protected View mRightBtn;
    protected FingerprintEnrollSidecar mSidecar;
    protected String mTarget;
    protected TextView mTextTips;
    protected byte[] mToken;

    /* JADX INFO: renamed from: com.android.settings.fingerprint.BaseFingerprintEnrollingActivity$13, reason: invalid class name */
    static /* synthetic */ class AnonymousClass13 {
        static final /* synthetic */ int[] $SwitchMap$com$android$settings$fingerprint$BaseFingerprintEnrollingActivity$STEP = null;

        static {
            int[] r0 = new int[STEP.values().length];
            $SwitchMap$com$android$settings$fingerprint$BaseFingerprintEnrollingActivity$STEP = r0;
            r0[STEP.INIT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$android$settings$fingerprint$BaseFingerprintEnrollingActivity$STEP[STEP.ENROLLING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$android$settings$fingerprint$BaseFingerprintEnrollingActivity$STEP[STEP.DONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$android$settings$fingerprint$BaseFingerprintEnrollingActivity$STEP[STEP.ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    protected static final enum STEP extends Enum<STEP> {
        private static final /* synthetic */ STEP[] $VALUES = null;
        public static final STEP DONE = null;
        public static final STEP ENROLLED = null;
        public static final STEP ENROLLING = null;
        public static final STEP ERROR = null;
        public static final STEP INIT = null;

        private static /* synthetic */ STEP[] $values() {
            return new STEP[]{INIT, ENROLLING, ENROLLED, DONE, ERROR};
        }

        private STEP(String r1, int r2) {
            super(r1, r2);
        }

        public static STEP valueOf(String r1) {
            return (STEP) Enum.valueOf(STEP.class, r1);
        }

        public static STEP[] values() {
            return (STEP[]) $VALUES.clone();
        }

        static {
            INIT = new STEP("INIT", 0);
            ENROLLING = new STEP("ENROLLING", 1);
            ENROLLED = new STEP("ENROLLED", 2);
            DONE = new STEP("DONE", 3);
            ERROR = new STEP("ERROR", 4);
            $VALUES = $values();
        }
    }

    private int getResultImageResource(boolean r1, boolean r2) {
        if (r1 == false) goto L8;
        if (r2 == false) goto L6;
        return R.drawable.setting_fp_correct_icon_front;
    L6:
        return R.drawable.setting_fp_error_icon_front;
    L8:
        if (r2 == false) goto L11;
        return R.drawable.setting_fp_correct_icon;
    L11:
        return R.drawable.setting_fp_error_icon;
    }

    @Override // com.android.settings.ConfirmLockBaseActivity, com.android.settings.base.BaseActivity, android.app.Activity
    public void finish() {
        com_android_settings_fingerprint_BaseFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_finish(this);
    }

    protected abstract int getContentLayout();

    protected abstract int getCorrectImageResource();

    protected int getDefaultIntroduction() {
        return R.string.enrolling_front_fp_introduction;
    }

    protected abstract int getDefaultTips();

    protected abstract int getErrorImageResource();

    protected int getSensorType() {
        return 0;
    }

    protected boolean isFrontFingerPrint() {
        return false;
    }

    protected boolean needInterceptEnrollmentError(int r1, CharSequence r2) {
        return false;
    }

    protected boolean needInterceptEnrollmentHelp(int r1, CharSequence r2) {
        return false;
    }

    @Override // com.android.settings.ConfirmLockBaseActivity, com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_fingerprint_BaseFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.settings.ConfirmLockBaseActivity, com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_settings_fingerprint_BaseFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_fingerprint_BaseFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onPause(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_fingerprint_BaseFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com_android_settings_fingerprint_BaseFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onStart(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_android_settings_fingerprint_BaseFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onStop(this);
    }

    protected abstract void updateTipsView(int r1, CharSequence r2);

    public BaseFingerprintEnrollingActivity() {
        this.mLastRemainCount = 0;
        this.mIsStartEnrollDone = false;
        this.mCurrentStep = STEP.INIT;
        this.mHandler = new AnonymousClass1(this);
        this.mFingerprintLockoutResetCallback = new AnonymousClass2(this);
    }

    static /* synthetic */ void access$000(BaseFingerprintEnrollingActivity r0, int r1) {
        r0.turnToSetupWizardCompleteActivity(r1);
    }

    static /* synthetic */ LockscreenCredential access$100(BaseFingerprintEnrollingActivity r0) {
        return r0.mPassword;
    }

    static /* synthetic */ FingerprintManager.LockoutResetCallback access$1000(BaseFingerprintEnrollingActivity r0) {
        return r0.mFingerprintLockoutResetCallback;
    }

    static /* synthetic */ LockscreenCredential access$1100(BaseFingerprintEnrollingActivity r0) {
        return r0.mPassword;
    }

    static /* synthetic */ void access$1200(BaseFingerprintEnrollingActivity r0, VerifyCredentialResponse r1) {
        r0.generateTokenToRetry(r1);
    }

    static /* synthetic */ LockscreenCredential access$1300(BaseFingerprintEnrollingActivity r0) {
        return r0.mPassword;
    }

    static /* synthetic */ void access$1400(BaseFingerprintEnrollingActivity r0) {
        r0.successToEnrollFace();
    }

    static /* synthetic */ void access$1500(BaseFingerprintEnrollingActivity r0) {
        r0.successToDone();
    }

    static /* synthetic */ boolean access$200(BaseFingerprintEnrollingActivity r0) {
        return r0.mIsStartEnrollDone;
    }

    static /* synthetic */ boolean access$202(BaseFingerprintEnrollingActivity r0, boolean r1) {
        r0.mIsStartEnrollDone = r1;
        return r1;
    }

    static /* synthetic */ int access$300(BaseFingerprintEnrollingActivity r0) {
        return r0.getSensorId();
    }

    static /* synthetic */ void access$400(BaseFingerprintEnrollingActivity r0) {
        r0.showBackAlertDialog();
    }

    static /* synthetic */ OFloatingTitleBar access$500(BaseFingerprintEnrollingActivity r0) {
        return r0.mTitle;
    }

    static /* synthetic */ OFloatingTitleBar access$600(BaseFingerprintEnrollingActivity r0) {
        return r0.mTitle;
    }

    static /* synthetic */ AsyncTask access$700(BaseFingerprintEnrollingActivity r0) {
        return r0.mPendingLockCheck;
    }

    static /* synthetic */ AsyncTask access$702(BaseFingerprintEnrollingActivity r0, AsyncTask r1) {
        r0.mPendingLockCheck = r1;
        return r1;
    }

    static /* synthetic */ int access$800() {
        return MY_USER_ID;
    }

    static /* synthetic */ LockPatternUtils access$900(BaseFingerprintEnrollingActivity r0) {
        return r0.mLockPatternUtils;
    }

    static {
        DELAY_TIME_START_ENROLL = 300L;
        MY_USER_ID = UserHandle.myUserId();
    }

    public void com_android_settings_fingerprint_BaseFingerprintEnrollingActivity__onCreate$___twin___(Bundle r6) {
        super.onCreate(r6);
        setContentView(getContentLayout());
        this.isFirstFingerprint = !Utils.isFingerprintExists(this.mContext);
        int r2 = 0;
        this.isFromFpManager = getIntent().getBooleanExtra(EXTRA_FROM_FP_MANAGER, false);
        this.fromProvision = getIntent().getBooleanExtra(EXTRA_FROM_PROVISION, false);
        this.fromAssistant = getIntent().getBooleanExtra(EXTRA_FROM_ASSISTANT, false);
        this.mLastRemainCount = FingerprintEnrollSidecar.getMaxStep(getSensorType());
        if (Utils.isDeviceSetupComplete(this) == true) goto L5;
    L8:
        boolean r7 = true;
    L9:
        this.mIsFromSetupWizard = r7;
        if (r7 == false) goto L12;
        registerWizardFinishReceiver();
    L12:
        OLog.d(TAG, "mIsFromSetupWizard " + this.mIsFromSetupWizard);
        String r8 = Utils.getStringExtraSafely(getIntent(), AdapterActivity.EXTRA_SOURCE);
        this.mTarget = Utils.getStringExtraSafely(getIntent(), AdapterActivity.EXTRA_TARGET);
        OLog.d(TAG, "source = " + r8 + " , mTarget = " + this.mTarget);
        if ("com.bytedanceos.wallet".equals(r8) == false) goto L15;
        this.mIsFromWallet = true;
    L15:
        this.mToken = getIntent().getByteArrayExtra("hw_auth_token");
        this.mEnrollNextFinger = (Button) findViewById(R.id.enroll_next_finger);
        this.mGotoFaceEnroll = (Button) findViewById(R.id.goto_face_enroll);
        if (this.fromProvision == false) goto L18;
        this.mEnrollNextFinger.setVisibility(8);
        this.mGotoFaceEnroll.setVisibility(8);
    L18:
        this.mDoneButton = (Button) findViewById(R.id.done_button);
        FrontFingerprintAnimView r9 = (FrontFingerprintAnimView) findViewById(R.id.fp_anim_view);
        this.mFingerprintAnimView = r9;
        r9.setCallback(this);
        this.mFingerprintAnimView.setSensorType(getSensorType());
        this.mTextTips = (TextView) findViewById(R.id.tips_text);
        if (Utils.isEnglishLocale() == false) goto L21;
        this.mTextTips.setTextSize(0, getResources().getDimension(R.dimen.fingerprintEnrolling_texttips_max_size_english_locale));
    L21:
        this.mTextTips.setText(getDefaultIntroduction());
        this.mTextTips.setTextColor(getResources().getColor(R.color.oui_basic_text_1));
        this.mBackView = this.mTitle.addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, null);
        this.mBackView.setOnClickListener(new AnonymousClass3(this));
        View r10 = this.mTitle.addEndAction(getString(R.string.activate_dlg_positive), -1, null);
        this.mRightBtn = r10;
        r10.setOnClickListener(new AnonymousClass4(this));
        this.mTitle.showEndAction(false);
        this.mLockPatternUtils = new ChooseLockSettingsHelper(this).utils();
        FingerprintManager r11 = (FingerprintManager) getSystemService("fingerprint");
        this.mFingerprintManager = r11;
        List<Fingerprint> r12 = FingerprintUtils.getFingerprintList(r11, getSensorType());
        this.mMaxFingerNum = FingerprintHelper.getMaxFingerprintPerUser(getResources());
        if (r12 == null) goto L25;
        r2 = r12.size();
    L25:
        this.mLockedFingerNum = r2;
        if (r2 < this.mMaxFingerNum) goto L28;
        OLog.e(TAG, "the finger num is overflow!");
    L28:
        this.mEnrollNextFinger.setOnClickListener(new AnonymousClass5(this));
        this.mGotoFaceEnroll.setOnClickListener(new AnonymousClass6(this));
        return;
    L5:
        if (Utils.getBooleanExtraSafely(getIntent(), ProvisionConstants.EXTRA_SETUPWIZARD, false) == true) goto L8;
        r7 = false;
        goto L9
    }

    private void turnOnDefaultFingerprintSettings() {
        if (Utils.isPrivacyPasswordEnable(this.mContext) == true) goto L5;
        return;
    L5:
        if (this.isFirstFingerprint == false) goto L9;
        PrivacySecurity.getInstance(this.mContext).setFingerprintUnlock(true);
        return;
    }

    public void com_android_settings_fingerprint_BaseFingerprintEnrollingActivity__onResume$___twin___() {
        super.onResume();
        OLog.d(TAG, "onResume");
        if (this.mPasswordConfirmed == true) goto L6;
        return;
    L6:
        if (this.mSidecar != null) goto L8;
        addSideCar();
    L8:
        FingerprintEnrollSidecar r0 = this.mSidecar;
        if (r0 == null) goto L12;
        r0.setListener(this);
    L12:
        if (this.mCurrentStep == STEP.ENROLLING) goto L15;
        OLog.e(TAG, "onResume...");
        updateUI();
        return;
    }

    public void com_android_settings_fingerprint_BaseFingerprintEnrollingActivity__onStart$___twin___() {
        super.onStart();
        OLog.d(TAG, "onStart");
    }

    private void addSideCar() {
        FingerprintEnrollSidecar r0 = (FingerprintEnrollSidecar) getSupportFragmentManager().findFragmentByTag(TAG_SIDECAR);
        this.mSidecar = r0;
        if (r0 != null) goto L5;
        this.mSidecar = new FingerprintEnrollSidecar();
        Bundle r1 = new Bundle();
        r1.putByteArray(FingerprintEnrollSidecar.EXTRA_TOKEN, this.mToken);
        OLog.e(TAG, "startEnrollingActivity mPassword=" + this.mPassword);
        r1.putParcelable(FingerprintEnrollSidecar.EXTRA_PASSWORD, this.mPassword);
        r1.putInt(FingerprintEnrollSidecar.EXTRA_SENSOR_ID, getSensorId());
        r1.putInt(FingerprintEnrollSidecar.EXTRA_SENSOR_TYPE, getSensorType());
        this.mSidecar.setArguments(r1);
        getSupportFragmentManager().beginTransaction().add(this.mSidecar, TAG_SIDECAR).commit();
    L5:
        this.mSidecar.setListener(this);
    }

    private FingerprintManager.GenerateChallengeCallback genCallbackForRetryWithPassword(final String r3, final int r4) {
        OLog.i(TAG, "genCallbackForRetryWithPassword source: " + r3 + ", originSensorId: " + r4 + ", sensorType: " + getSensorType());
        return new AnonymousClass7(this, r3, r4);
    }

    protected void retryWithPassword() {
        if (this.mPassword == null) goto L8;
        int r0 = getSensorId();
        if (r0 == (-1)) goto L7;
        this.mFingerprintManager.generateChallenge(r0, MY_USER_ID, genCallbackForRetryWithPassword("withSensorId", getSensorId()));
        return;
    L7:
        this.mFingerprintManager.generateChallenge(MY_USER_ID, genCallbackForRetryWithPassword("withoutSensorId", -1));
        return;
    L8:
        generateTokenToRetry(null);
    }

    private FingerprintManager.GenerateChallengeCallback genCallbackForGenerateTokenToRetry(final String r3, final int r4, final VerifyCredentialResponse r5) {
        OLog.i(TAG, "genCallbackForGenerateTokenToRetry source: " + r3 + ", originSensorId: " + r4 + ", sensorType: " + getSensorType());
        return new AnonymousClass8(this, r5, r3, r4);
    }

    private void generateTokenToRetry(VerifyCredentialResponse r5) {
        if (r5 == null) goto L7;
        int r0 = getSensorId();
        if (r0 == (-1)) goto L6;
        this.mFingerprintManager.generateChallenge(r0, MY_USER_ID, genCallbackForGenerateTokenToRetry("withSensorId", r0, r5));
        return;
    L6:
        this.mFingerprintManager.generateChallenge(MY_USER_ID, genCallbackForGenerateTokenToRetry("withoutSensorId", -1, r5));
        return;
    L7:
        OLog.e(TAG, "generateTokenToRetry EXTRA_KEY_CHALLENGE_TOKEN: token is null");
    }

    protected void retryEnrolling() {
        this.mHandler.removeCallbacks(null);
        OLog.i(TAG, "retryEnrolling");
        if (this.mPassword == null) goto L5;
        retryWithPassword();
        return;
    L5:
        OLog.e(TAG, "retryEnrolling error: password is null");
    }

    public void com_android_settings_fingerprint_BaseFingerprintEnrollingActivity__onPause$___twin___() {
        super.onPause();
        if (this.mPasswordConfirmed == true) goto L5;
        return;
    L5:
        FingerprintEnrollSidecar r1 = this.mSidecar;
        if (r1 == null) goto L9;
        r1.setListener(null);
        return;
    }

    public void com_android_settings_fingerprint_BaseFingerprintEnrollingActivity__onStop$___twin___() {
        super.onStop();
        OLog.d(TAG, "onStop");
    }

    @Override // com.android.settings.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (SettingsFeature.isFingerprintNavigationDevice() == false) goto L5;
        return;
    L5:
        super.onBackPressed();
    }

    public void com_android_settings_fingerprint_BaseFingerprintEnrollingActivity__finish$___twin___() {
        if (this.mForceFinish == true) goto L11;
        FingerprintEnrollSidecar r0 = this.mSidecar;
        if (r0 == null) goto L11;
        if (r0.getCurrentStep() <= 0) goto L11;
        if (this.mCurrentStep == STEP.DONE) goto L11;
        showBackAlertDialog();
        return;
    L11:
        OAlertDialog r1 = this.mBackAlertDialog;
        if (r1 == null) goto L14;
        r1.dismiss();
        this.mBackAlertDialog = null;
    L14:
        super.finish();
    }

    private void showBackAlertDialog() {
        if (this.mBackAlertDialog != null) goto L8;
        OAlertDialog r0 = new OAlertDialogBuilder(this).horizontalButton(true).title(R.string.back_alert_dialog_title_when_enroll_fingerprint).message(R.string.back_alert_dialog_message_when_enroll_fingerprint).horizontalButton().negativeButton(R.string.back_alert_dialog_continue_setup_when_enroll_fingerprint, new BaseFingerprintEnrollingActivity$$ExternalSyntheticLambda0(this)).positiveButton(R.string.back_alert_dialog_stop_when_enroll_fingerprint, new BaseFingerprintEnrollingActivity$$ExternalSyntheticLambda1(this)).build();
        this.mBackAlertDialog = r0;
        OButton r1 = (OButton) r0.getPositiveButton();
        if (r1 == null) goto L8;
        r1.setTextColor(ContextCompat.getColor(this, R.color.oui_functional_red_6));
    L8:
        if (isFinishing() == true) goto L11;
        this.mBackAlertDialog.show();
        return;
    }

    /* JADX INFO: renamed from: lambda$showBackAlertDialog$0$com-android-settings-fingerprint-BaseFingerprintEnrollingActivity, reason: not valid java name */
    /* synthetic */ void m463x4230866c(DialogInterface r1, int r2) {
        if (this.mBackAlertDialog == null) goto L6;
        r1.dismiss();
        return;
    }

    /* JADX INFO: renamed from: lambda$showBackAlertDialog$1$com-android-settings-fingerprint-BaseFingerprintEnrollingActivity, reason: not valid java name */
    /* synthetic */ void m464x1df2022d(DialogInterface r1, int r2) {
        if (this.mBackAlertDialog == null) goto L5;
        r1.dismiss();
    L5:
        super.finish();
    }

    protected int getCompletedBtnTextRes() {
        if (isAddFaceDataAllowable() == false) goto L5;
        return R.string.next_step;
    L5:
        return R.string.done;
    }

    protected boolean isAddFaceDataAllowable() {
        if (SettingsFeature.isFaceRecognitionEnable() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mIsFromSetupWizard == false) goto L7;
        return true;
    }

    protected AlphaAnimation getAlphaAnimation(float r1, float r2, long r3, int r5) {
        AlphaAnimation r0 = new AlphaAnimation(r1, r2);
        r0.setDuration(r3);
        r0.setRepeatMode(2);
        r0.setRepeatCount(r5);
        r0.setInterpolator(new DecelerateInterpolator(1.0f));
        return r0;
    }

    private void turnToSetupWizardCompleteActivity(int r5) {
        Intent r0 = new Intent();
        r0.setComponent(new ComponentName("com.bytedanceos.setupwizard", "com.bytedanceos.setupwizard.SetupWizardCompleteActivity"));
        Utils.startActivity(this, r0, r5);
    }

    private void launchConfirmLock() {
        OLog.i(TAG, "launchConfirmLock challenge 0");
        if (new ChooseLockSettingsHelper(this).launchConfirmationActivity(1, getString(R.string.security_settings_fingerprint_preference_title), true, 2) == true) goto L6;
        finish();
        return;
    }

    @Override // com.android.settings.widget.FingerprintEnrollProgressView.Callback
    public void onAnimDone() {
        this.mCurrentStep = STEP.DONE;
        OLog.e(TAG, "onAnimDone...");
        updateUI();
    }

    private void showBackView(boolean r2) {
        View r1 = this.mTitle.findViewById(R.id.start_button_group);
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r1.setVisibility(r3);
        return;
    L5:
        r3 = 4;
        goto L6
    }

    protected void updateUI() {
        OLog.i(TAG, "updateUI " + this.mCurrentStep);
        int r0 = AnonymousClass13.$SwitchMap$com$android$settings$fingerprint$BaseFingerprintEnrollingActivity$STEP[this.mCurrentStep.ordinal()];
        if (r0 != 1) goto L5;
        this.mFingerprintAnimView.reset();
        showBackView(true);
        this.mTextTips.setVisibility(0);
        this.mTextTips.setText(getDefaultIntroduction());
        this.mTextTips.setTextColor(getResources().getColor(R.color.oui_basic_text_1));
        this.mEnrollNextFinger.setVisibility(8);
        this.mGotoFaceEnroll.setVisibility(8);
        this.mDoneButton.setVisibility(8);
        return;
    L5:
        if (r0 != 2) goto L7;
        this.mTextTips.setTextColor(getResources().getColor(R.color.oui_basic_text_1));
        this.mTextTips.setText(getDefaultTips());
        clearTipsAnimation();
        playEnrollingAnim();
        return;
    L7:
        if (r0 != 3) goto L9;
        showBackView(true);
        onEnrollmentSuccess();
        this.mFingerprintAnimView.processDone(false);
        return;
    L9:
        if (r0 != 4) goto L19;
        this.mFingerprintAnimView.processDone(true);
        this.mTitle.showEndAction(true);
        return;
    }

    private void successToDone() {
        OLog.i(TAG, "successToDone ");
        if (this.mIsFromWallet == false) goto L5;
    L9:
        turnOnDefaultFingerprintSettings();
        this.mHandler.sendEmptyMessage(2);
        return;
    L5:
        if (this.isFirstFingerprint == false) goto L9;
        if (this.isFromFpManager == true) goto L9;
        turnToFingerprintManage();
        goto L9
    }

    private void successToFaceDialog() {
        OLog.i(TAG, "successToFaceDialog ");
        OAlertDialogBuilder r0 = new OAlertDialogBuilder(this);
        r0.title(R.string.enroll_face_dialog_title).horizontalButton().message(R.string.enroll_face_dialog_suggestions).positiveButton(R.string.enroll_face_dialog_positive, new AnonymousClass10(this)).negativeButton(R.string.enroll_face_dialog_negative, new AnonymousClass9(this));
        r0.build().show();
    }

    private void successToEnrollFace() {
        OLog.i(TAG, "successToEnrollFace ");
        Intent r0 = new Intent(this, Settings.FaceRecognitionEnrollTipActivity.class);
        r0.putExtra("password_confirmed", true);
        r0.putExtra("password", this.mPassword);
        Utils.startActivity(this, r0);
        this.mHandler.sendEmptyMessage(2);
    }

    private void onEnrollmentSuccess() {
        OLog.i(TAG, "onEnrollmentSuccess mIsFromSetupWizard: " + this.mIsFromSetupWizard);
        int r1 = 0;
        if (this.mIsFromSetupWizard == false) goto L9;
        this.mDoneButton.setVisibility(8);
        this.mGotoFaceEnroll.setText(R.string.finish_button);
        this.mGotoFaceEnroll.setVisibility(0);
        Button r0 = this.mEnrollNextFinger;
        if (this.mLockedFingerNum < this.mMaxFingerNum) goto L8;
        r1 = 8;
    L8:
        r0.setVisibility(r1);
        this.mGotoFaceEnroll.setOnClickListener(new AnonymousClass11(this));
        return;
    L9:
        Button r2 = this.mEnrollNextFinger;
        if (this.mLockedFingerNum >= this.mMaxFingerNum) goto L12;
        int r3 = 0;
    L13:
        r2.setVisibility(r3);
        this.mGotoFaceEnroll.setVisibility(8);
        this.mDoneButton.setVisibility(0);
        this.mDoneButton.setOnClickListener(new AnonymousClass12(this));
        if (Utils.isSeDevice() == true) goto L16;
        return;
    L16:
        if (new FaceRecognitionHelper(this).isFaceRecognitionDataExist() == true) goto L21;
        successToFaceDialog();
        return;
    L21:
        return;
    L12:
        r3 = 8;
        goto L13
    }

    protected void turnToFingerprintManage() {
        Intent r0 = new Intent(this, Settings.FingerprintManageActivity.class);
        r0.putExtra("password", this.mPassword);
        if (this.mPassword == null) goto L5;
        boolean r1 = true;
    L6:
        r0.putExtra("password_confirmed", r1);
        Utils.startActivity(this, r0);
        return;
    L5:
        r1 = false;
        goto L6
    }

    protected void turnToFaceRecognitionEnrollActivity() {
        this.mEnrollingFaceRecognitionData = true;
        Intent r1 = new Intent(this, Settings.FaceRecognitionEnrollTipActivity.class);
        r1.putExtra("password_confirmed", true);
        Utils.startActivity(this, r1);
    }

    protected boolean isFingerprintEnrolled() {
        if (this.mCurrentStep != STEP.ENROLLED) goto L5;
    L8:
        return true;
    L5:
        if (this.mCurrentStep == STEP.DONE) goto L8;
        return false;
    }

    protected void playEnrollingAnim() {
        int r0 = this.mSidecar.getEnrollmentSteps();
        int r1 = this.mSidecar.getCurrentProgress();
        OLog.i(TAG, "playEnrollingAnim currentProgress:" + r1);
        if (r0 != 0) goto L6;
        this.mFingerprintAnimView.reset();
        return;
    L6:
        if (r0 <= 0) goto L9;
        this.mFingerprintAnimView.playAnimation(r1);
        return;
    }

    @Override // com.android.settings.fingerprint.FingerprintEnrollSidecar.Listener
    public void onEnrollmentHelp(int r2, CharSequence r3) {
        if (needInterceptEnrollmentHelp(r2, r3) == false) goto L5;
        return;
    L5:
        updateTipsView(r2, r3);
    }

    private boolean contains(CharSequence r4, CharSequence... r5) {
        if (r5 == null) goto L12;
        if (r4 == null) goto L12;
        int r0 = r5.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L12;
        if (TextUtils.equals(r5[r1], r4) == true) goto L9;
        r1 = r1 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    @Override // com.android.settings.fingerprint.FingerprintEnrollSidecar.Listener
    public void onEnrollmentError(int r5, CharSequence r6) {
        OLog.e(TAG, "onEnrollmentError: errMsgId=" + r5 + ", errString=" + r6);
        this.mLastRemainCount = -1;
        if (isResumed() == true) goto L6;
        return;
    L6:
        if (this.mIsClickBackButton == false) goto L9;
        return;
    L9:
        if (this.mCurrentStep != STEP.INIT) goto L13;
        OLog.e(TAG, "onEnrollmentError errMsgId=" + r5 + ", errString=" + r6 + ", retryEnrolling");
        retryEnrolling();
        return;
    L13:
        if (needInterceptEnrollmentError(r5, r6) == false) goto L15;
        return;
    L15:
        this.mCurrentStep = STEP.ERROR;
        setResult(0);
        this.mTextTips.setText(r6);
        this.mTextTips.setTextColor(ContextCompat.getColor(this.mContext, R.color.oui_functional_red_6));
        clearTipsAnimation();
        updateUI();
    }

    protected void clearTipsAnimation() {
        this.mTextTips.clearAnimation();
        this.mTextTips.setAlpha(1.0f);
    }

    public void onEnrollmentProgressChange(int r4, int r5) {
        OLog.i(TAG, "onEnrollmentProgressChange steps:" + r4 + ",remaining:" + r5);
        updateTipsView(108, null);
        OLog.i(TAG, "mLastRemainCount:" + this.mLastRemainCount + ",remaining:" + r5);
        if (this.mLastRemainCount != r5) goto L9;
        OLog.i(TAG, "ShowTips:" + this.mSidecar.isShowTips());
        if (this.mSidecar.isShowTips() == false) goto L7;
        this.mTextTips.setTextColor(getResources().getColor(R.color.oui_basic_text_1));
        this.mTextTips.setText(getString(android.R.string.global_actions));
    L7:
        OLog.w(TAG, "ignore refresh UI if same progress");
        return;
    L9:
        this.mLastRemainCount = r5;
        if (this.mCurrentStep != STEP.INIT) goto L12;
        this.mCurrentStep = STEP.ENROLLING;
    L15:
        updateUI();
        return;
    L12:
        updateUI();
        if (r5 != 0) goto L15;
        this.mCurrentStep = STEP.ENROLLED;
        onFingerprintEnrollDone();
        setResult(-1);
        goto L15
    }

    public void onUdfpsPointerDown(int r2) {
        OLog.i(TAG, "onUdfpsPointerDown: " + r2);
    }

    public void onUdfpsPointerUp(int r2) {
        OLog.i(TAG, "onUdfpsPointerUp: " + r2);
    }

    protected void onFingerprintEnrollDone() {
        if (isFingerprintEnrolled() == true) goto L5;
    L9:
        this.mLockedFingerNum++;
        OLog.d(TAG, "locked fingerprint count:" + this.mLockedFingerNum);
        return;
    L5:
        if (this.isFirstFingerprint == false) goto L9;
        android.provider.Settings.Global.putInt(getContentResolver(), "use_fingerprint_in_lockscreen", 1);
        android.provider.Settings.Secure.putInt(getContentResolver(), "lock_screen_lock_after_timeout", 0);
        if (SettingsFeature.isWalletFeatureEnabled(this) == false) goto L9;
        android.provider.Settings.Global.putInt(getContentResolver(), "use_fingerprint_in_wallet", 1);
        goto L9
    }

    @Override // com.android.settings.ConfirmLockBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        OLog.d(TAG, "onActivityResult");
    }

    public void com_android_settings_fingerprint_BaseFingerprintEnrollingActivity__onDestroy$___twin___() {
        super.onDestroy();
        FrontFingerprintAnimView r1 = this.mFingerprintAnimView;
        if (r1 == null) goto L6;
        r1.setCallback(null);
        return;
    }

    public static Intent launchFingerprintEnrollingActivity(Activity r2) {
        OLog.i(TAG, "launchFingerprintEnrollingActivity");
        if (SettingsFeature.isSupportFrontFP() == false) goto L6;
        return new Intent(r2, FrontFingerprintEnrollingActivity.class);
    L6:
        if (SettingsFeature.isSupportRightSideFP() == false) goto L9;
        return new Intent(r2, RightSideFingerprintEnrollingActivity.class);
    L9:
        return new Intent(r2, BackFingerprintEnrollingActivity.class);
    }

    public static Intent launchFingerprintEnrollingActivity(Activity r2, int r3) {
        OLog.i(TAG, "launchFingerprintEnrollingActivity, fingerType:" + r3);
        if (r3 != 4) goto L6;
        return new Intent(r2, AIPoweredFingerprintEnrollingActivity.class);
    L6:
        return launchFingerprintEnrollingActivity(r2);
    }

    public static byte[] requestGatekeeperHat(Context r6, long r7, int r9, long r10) {
        VerifyCredentialResponse r8 = new LockPatternUtils(r6).verifyGatekeeperPasswordHandle(r7, r10, r9);
        if (r8.isMatched() == false) goto L7;
        return r8.getGatekeeperHAT();
    L7:
        throw new IllegalStateException("Unable to request Gatekeeper HAT");
    }

    private int getSensorId() {
        if (getSensorType() != 0) goto L5;
        return -1;
    L5:
        Iterator r0 = ((FingerprintManager) getSystemService(FingerprintManager.class)).getSensorProperties().iterator();
    L7:
        if (r0.hasNext() == false) goto L15;
        FingerprintSensorProperties r2 = (SensorProperties) r0.next();
        if (r2.getSensorType() != getSensorType()) goto L7;
        return r2.getSensorId();
    L15:
        return -1;
    }

    @Insert("onCreate")
    public static void com_android_settings_fingerprint_BaseFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onCreate(BaseFingerprintEnrollingActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        BaseFingerprintEnrollingActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_fingerprint_BaseFingerprintEnrollingActivity__onCreate$___twin___(r4);
    }

    @Insert("onStart")
    public static void com_android_settings_fingerprint_BaseFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onStart(BaseFingerprintEnrollingActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        BaseFingerprintEnrollingActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStart();
        return;
    L6:
        r3.com_android_settings_fingerprint_BaseFingerprintEnrollingActivity__onStart$___twin___();
    }

    @Insert("onResume")
    public static void com_android_settings_fingerprint_BaseFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onResume(BaseFingerprintEnrollingActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        BaseFingerprintEnrollingActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_fingerprint_BaseFingerprintEnrollingActivity__onResume$___twin___();
    }

    @Insert("onPause")
    public static void com_android_settings_fingerprint_BaseFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onPause(BaseFingerprintEnrollingActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        BaseFingerprintEnrollingActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_fingerprint_BaseFingerprintEnrollingActivity__onPause$___twin___();
    }

    @Insert("onStop")
    public static void com_android_settings_fingerprint_BaseFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onStop(BaseFingerprintEnrollingActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        BaseFingerprintEnrollingActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_fingerprint_BaseFingerprintEnrollingActivity__onStop$___twin___();
    }

    @Insert("onDestroy")
    public static void com_android_settings_fingerprint_BaseFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(BaseFingerprintEnrollingActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        BaseFingerprintEnrollingActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_fingerprint_BaseFingerprintEnrollingActivity__onDestroy$___twin___();
    }

    @Insert("finish")
    public static void com_android_settings_fingerprint_BaseFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_finish(BaseFingerprintEnrollingActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        BaseFingerprintEnrollingActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.superFinish();
        return;
    L6:
        r3.com_android_settings_fingerprint_BaseFingerprintEnrollingActivity__finish$___twin___();
    }
}
