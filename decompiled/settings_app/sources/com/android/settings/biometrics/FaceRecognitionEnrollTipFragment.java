package com.android.settings.biometrics;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.face.FaceManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.UserHandle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.android.internal.widget.LockPatternUtils;
import com.android.internal.widget.LockscreenCredential;
import com.android.internal.widget.VerifyCredentialResponse;
import com.android.settings.ChooseLockGeneric;
import com.android.settings.ChooseLockPassword;
import com.android.settings.ChooseLockPattern;
import com.android.settings.ConfirmLockExtendActivity;
import com.android.settings.LockPatternCheckerOnly;
import com.android.settings.R;
import com.android.settings.SettingsFeature;
import com.android.settings.Utils;
import com.android.settings.base.BaseActivity;
import com.android.settings.base.BaseFragment;
import com.android.settings.biometrics.ocean.face.FaceEnrollEnrollingActivity;
import com.android.settings.fingerprint.utils.FingerprintUtils;
import com.android.settings.provision.ProvisionConstants;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.UIUtils;
import com.android.settings.wifi.TrustedNetworkHelper;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.v2.alert.style.DialogContainer;
import com.obric.oui.dialog.v2.alert.style.OViewStyleController;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.OMenuDialog2;
import obric.app.OMenuDialogListAdapter2;

/* JADX INFO: loaded from: classes2.dex */
public class FaceRecognitionEnrollTipFragment extends BaseFragment implements View.OnClickListener {
    public static final String EXTRA_PASSWORD_CONFIRMED = "password_confirmed";
    private static final int MY_USER_ID = 0;
    private static final int REQUEST_CODE_CONFIRM_PASSWORD = 300;
    private static final int REQUEST_CODE_FACE_ENROLL = 100;
    private static final int REQUEST_CODE_SETUP_LOCK_SCREEN_PASSWORD = 200;
    private long mChallenge;
    private OMenuDialog2 mChooseLockTypeDialog;
    private FaceRecognitionHelper mFaceRecognitionHelper;
    private boolean mIsFromSetupWizard;
    private LockPatternUtils mLockPatternUtils;
    private LockscreenCredential mPassword;
    private boolean mPasswordConfirmed;
    private AsyncTask<?, ?, ?> mPendingLockCheck;
    private VerifyCredentialResponse mResponse;
    private OAlertDialog mSetupLockScreenDialog;
    private OAlertDialog mTipsDialog;
    private byte[] mToken;

    static /* synthetic */ void lambda$showSetupLockScreenDialog$1(DialogInterface r0, int r1) {
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_biometrics_FaceRecognitionEnrollTipFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_biometrics_FaceRecognitionEnrollTipFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public FaceRecognitionEnrollTipFragment() {
        this.mResponse = null;
        this.mChallenge = 0;
    }

    static /* synthetic */ void access$000(FaceRecognitionEnrollTipFragment r0) {
        r0.startEnrollOrStartSetupLockScreen();
    }

    static /* synthetic */ void access$100(FaceRecognitionEnrollTipFragment r0) {
        r0.showChooseLockMenuDialog();
    }

    static /* synthetic */ void access$200(FaceRecognitionEnrollTipFragment r0, int r1, int r2) {
        r0.startChooseLockTypeActivity(r1, r2);
    }

    static /* synthetic */ String access$300(FaceRecognitionEnrollTipFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ AsyncTask access$402(FaceRecognitionEnrollTipFragment r0, AsyncTask r1) {
        r0.mPendingLockCheck = r1;
        return r1;
    }

    static /* synthetic */ VerifyCredentialResponse access$502(FaceRecognitionEnrollTipFragment r0, VerifyCredentialResponse r1) {
        r0.mResponse = r1;
        return r1;
    }

    static /* synthetic */ void access$600(FaceRecognitionEnrollTipFragment r0) {
        r0.startEnrollWithResponse();
    }

    static /* synthetic */ String access$700(FaceRecognitionEnrollTipFragment r0) {
        return r0.TAG;
    }

    public void com_android_settings_biometrics_FaceRecognitionEnrollTipFragment__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        boolean r0 = true;
        this.mIsFromSetupWizard = !Utils.isDeviceSetupComplete(this.mContext);
        Bundle r5 = getArguments();
        if (r5 == null) goto L15;
        LockscreenCredential r6 = r5.getParcelable("password");
        this.mPassword = r6;
        if (r6 == null) goto L7;
        boolean r7 = true;
    L8:
        this.mPasswordConfirmed = r7;
        if (this.mIsFromSetupWizard == false) goto L11;
    L14:
        this.mIsFromSetupWizard = r0;
        goto L15
    L11:
        if (getIntent().getBooleanExtra(ProvisionConstants.EXTRA_SETUPWIZARD, false) == true) goto L14;
        r0 = false;
        goto L14
    L7:
        r7 = false;
    L15:
        FaceRecognitionHelper r8 = new FaceRecognitionHelper(this.mContext);
        this.mFaceRecognitionHelper = r8;
        r8.bind(null);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.face_data_enroll_fragment, r3, false);
        ((FrameLayout) this.mRootView.findViewById(R.id.frame_layout)).addView(UIUtils.buildNoScaledView(this._mActivity, R.layout.view_face_tips_background));
        findViewById(R.id.enroll_start).setOnClickListener(this);
        findViewById(R.id.face_data_license).setOnClickListener(this);
        UIUtils.setUpFakeStatusBarOnApplyWindowInsets(this.mRootView.findViewById(R.id.fake_status_bar));
        return this.mRootView;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        UIUtils.fitMaskTitleInCommon((ViewGroup) r3, r3.findViewById(R.id.face_enroll_container));
        super.onViewCreated(r3, r4);
        this.mBackView.setVisibility(0);
    }

    public void com_android_settings_biometrics_FaceRecognitionEnrollTipFragment__onResume$___twin___() {
        super.onResume();
        if (this.mIsFromSetupWizard == true) goto L5;
        return;
    L5:
        if (this.mFaceRecognitionHelper.isFaceRecognitionDataExist() == false) goto L9;
        this._mActivity.setResult(-1);
        finish();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mFaceRecognitionHelper.unbind();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        if (r3.getId() != R.id.enroll_start) goto L6;
        onStartEnrollClicked();
        return;
    L6:
        if (r3.getId() != R.id.face_data_license) goto L10;
        onClickFaceLicense();
        return;
    }

    @Override // com.android.settings.base.BaseFragment
    public void finish() {
        super.finish();
    }

    private void turnToSetupWizardCompleteActivity() {
        Intent r0 = new Intent();
        r0.setComponent(new ComponentName("com.bytedanceos.setupwizard", "com.bytedanceos.setupwizard.SetupWizardCompleteActivity"));
        Utils.startActivity(this._mActivity, r0);
    }

    private void onStartEnrollClicked() {
        if (SettingsFeature.isSupportZteFaceRecognition() == false) goto L6;
        launcherZteFaceVerify(this.mContext);
        return;
    L6:
        if (this.mTipsDialog != null) goto L9;
        this.mTipsDialog = new OAlertDialogBuilder(this._mActivity).horizontalButton().body(new OViewStyleController(new FaceRecognitionEnrollTipFragment$$ExternalSyntheticLambda1(this))).title(R.string.encrypt_warning_title).positiveButton(R.string.sure, new AnonymousClass2(this)).negativeButton(R.string.cancel, new AnonymousClass1(this)).build();
    L9:
        if (this.mTipsDialog.isShowing() == true) goto L13;
        this.mTipsDialog.show();
        return;
    }

    /* JADX INFO: renamed from: lambda$onStartEnrollClicked$0$com-android-settings-biometrics-FaceRecognitionEnrollTipFragment, reason: not valid java name */
    /* synthetic */ Unit m333xdd91401a(DialogContainer r3) {
        View r2 = getLayoutInflater().inflate(R.layout.dialog_face_recognition_enroll_msg, null);
        r3.getBodySlot().addView(r2);
        return Unit.INSTANCE;
    }

    private void launcherZteFaceVerify(Context r4) {
        Intent r0 = new Intent("com.zte.faceverify.LIST");     // Catch: Throwable -> L4 Exception -> L6 ActivityNotFoundException -> L8
        r0.putExtra("fromSetupWizard", false);     // Catch: Throwable -> L4 Exception -> L6 ActivityNotFoundException -> L8
        r0.addFlags(268435456);     // Catch: Throwable -> L4 Exception -> L6 ActivityNotFoundException -> L8
        r4.startActivity(r0);     // Catch: Throwable -> L4 Exception -> L6 ActivityNotFoundException -> L8
    L11:
        return;
    L4:
        th = move-exception;
        throw th;
    L6:
        e = move-exception;
        OLog.e(this.TAG, "launcherZteFaceVerify Exception", e);     // Catch: Throwable -> L4
    L8:
        OLog.d(this.TAG, "launcherZteFaceVerify ActivityNotFoundException");     // Catch: Throwable -> L4
        goto L11
    }

    private void onClickFaceLicense() {
        FingerprintUtils.loadFaceLicenseWebview(this._mActivity, false);
    }

    private void startEnrollOrStartSetupLockScreen() {
        if (hasLockScreenPwd() == true) goto L5;
        showSetupLockScreenDialog();
        return;
    L5:
        if (this.mPasswordConfirmed == false) goto L7;
        startEnroll();
        return;
    L7:
        launchConfirmLock();
    }

    private void launchConfirmLock() {
        FragmentActivity r0 = getActivity();
        if ((r0 instanceof ConfirmLockExtendActivity) == true) goto L6;
        OLog.e(this.TAG, "launchConfirmLock, activity: " + r0 + " is not ConfirmLockExtendActivity, return");
        return;
    L6:
        FingerprintManager r1 = (FingerprintManager) this.mContext.getSystemService(FingerprintManager.class);
        if (((ConfirmLockExtendActivity) r0).getChooseLockSettingsHelper().launchConfirmationActivity(300, getString(R.string.security_settings_fingerprint_preference_title), null, null, 0, 2) == true) goto L10;
        finish();
        return;
    }

    private void showSetupLockScreenDialog() {
        if (this.mSetupLockScreenDialog != null) goto L6;
        this.mSetupLockScreenDialog = (OAlertDialog) new OAlertDialogBuilder(this._mActivity).horizontalButton().title(R.string.setup_lockscreen_title).message(R.string.setup_lockscreen_message_face_recognition).positiveButton(R.string.setup_lockscreen_ok_button, new AnonymousClass3(this)).negativeButton(R.string.cancel, new FaceRecognitionEnrollTipFragment$$ExternalSyntheticLambda0()).cancelable(false).build();
    L6:
        if (this.mSetupLockScreenDialog.isShowing() == true) goto L9;
        this.mSetupLockScreenDialog.show();
        return;
    }

    private void showChooseLockMenuDialog() {
        if (this.mChooseLockTypeDialog != null) goto L6;
        OMenuDialog2 r0 = new OMenuDialog2(this._mActivity);
        this.mChooseLockTypeDialog = r0;
        r0.setTitle(R.string.choose_lock_type_title);
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        r1.add(getString(R.string.lockscreen_mode_item_title_pattern));
        r2.add(getLockTypeSelectionOnclickListener(65536));
        r1.add(getString(R.string.lockscreen_mode_pin_four));
        r2.add(getLockTypeSelectionOnclickListener(131072, 4));
        r1.add(getString(R.string.lockscreen_mode_pin_six));
        r2.add(getLockTypeSelectionOnclickListener(131072, 6));
        r1.add(getString(R.string.lockscreen_mode_item_title_hard));
        r2.add(getLockTypeSelectionOnclickListener(262144));
        OMenuDialogListAdapter2 r3 = new OMenuDialogListAdapter2(this._mActivity, r1, r2);
        this.mChooseLockTypeDialog.setAdapter(r3);
    L6:
        if (this.mChooseLockTypeDialog.isShowing() == true) goto L9;
        this.mChooseLockTypeDialog.show();
        return;
    }

    private View.OnClickListener getLockTypeSelectionOnclickListener(int r2) {
        return getLockTypeSelectionOnclickListener(r2, 4);
    }

    private View.OnClickListener getLockTypeSelectionOnclickListener(final int r2, final int r3) {
        return new AnonymousClass4(this, r2, r3);
    }

    private void startChooseLockTypeActivity(int r4, int r5) {
        Intent r0 = new Intent();
        if (r4 < 131072) goto L6;
        r0 = new Intent(this._mActivity, ChooseLockPassword.class);
        r0.putExtra("lockscreen.password_type", r4);
        r0.putExtra(ChooseLockPassword.PASSWORD_MIN_KEY, 4);
        r0.putExtra(ChooseLockPassword.EXTRA_PIN_LENGTH, r5);
    L8:
        r0.putExtra(ChooseLockGeneric.CONFIRM_CREDENTIALS, false);
        r0.putExtra(TrustedNetworkHelper.EXTRA_REQUEST_RESULT, true);
        r0.putExtra("request_code", 200);
        ((BaseActivity) getActivity()).customStartActivityForResult(r0, 2);
        return;
    L6:
        if (r4 != 65536) goto L8;
        r0 = new Intent(this._mActivity, ChooseLockPattern.class);
        r0.putExtra("pattern_size", 3);
        r0.putExtra("key_lock_method", "pattern");
        goto L8
    }

    private boolean hasLockScreenPwd() {
        return new LockPatternUtils(this.mContext).isSecure(UserHandle.myUserId());
    }

    private void startEnroll() {
        OLog.i(this.TAG, "startEnroll");
        LockscreenCredential r0 = this.mPassword;
        if (r0 != null) goto L5;
    L8:
        OLog.i(this.TAG, "startEnroll end");
        return;
    L5:
        if (r0.isNone() == true) goto L8;
        OLog.i(this.TAG, "startEnroll 1");
        startEnrollFaceWithPassword();
    }

    private void startEnrollWithResponse() {
        OLog.i(this.TAG, "startEnroll 3");
        if (this.mResponse == null) goto L6;
        OLog.i(this.TAG, "startEnroll 4");
        com.android.settings.biometrics.ocean.password.BiometricsUtils.requestGatekeeperHat(this.mContext, this.mResponse, UserHandle.myUserId(), new FaceRecognitionEnrollTipFragment$$ExternalSyntheticLambda2(this));
        return;
    }

    /* JADX INFO: renamed from: lambda$startEnrollWithResponse$2$com-android-settings-biometrics-FaceRecognitionEnrollTipFragment, reason: not valid java name */
    /* synthetic */ Unit m335x142f0841(byte[] r1) {
        this.mToken = r1;
        startEnrollActivity();
        return Unit.INSTANCE;
    }

    static {
        MY_USER_ID = UserHandle.myUserId();
    }

    private void startEnrollFaceWithPassword() {
        OLog.i(this.TAG, "startEnroll 2");
        FaceManager r0 = Utils.getFaceManagerOrNull(this.mContext);
        this.mLockPatternUtils = new LockPatternUtils(getActivity());
        r0.generateChallenge(UserHandle.myUserId(), new FaceRecognitionEnrollTipFragment$$ExternalSyntheticLambda3(this));
    }

    /* JADX INFO: renamed from: lambda$startEnrollFaceWithPassword$3$com-android-settings-biometrics-FaceRecognitionEnrollTipFragment, reason: not valid java name */
    /* synthetic */ void m334x93e1e529(int r8, int r9, long r10) {
        OLog.d(this.TAG, "startEnrolling challenge " + r10);
        this.mChallenge = r10;
        if (this.mPassword == null) goto L12;
        AsyncTask<?, ?, ?> r11 = this.mPendingLockCheck;
        if (r11 == null) goto L7;
        r11.cancel(false);
    L7:
        final long r12 = System.currentTimeMillis();
        LockPatternUtils r0 = this.mLockPatternUtils;
        int r5 = MY_USER_ID;
        if (r0.getKeyguardStoredPasswordQuality(r5) != 65536) goto L10;
        this.mPendingLockCheck = LockPatternCheckerOnly.verifyPattern2(this.mLockPatternUtils, this.mPassword, r10, r5, new AnonymousClass5(this, r12));
        return;
    L10:
        this.mPendingLockCheck = LockPatternCheckerOnly.verifyPassword2(this.mLockPatternUtils, this.mPassword, r10, Utils.getEffectiveUserId(this.mContext), new AnonymousClass6(this, r12));
        return;
    }

    private void startEnrollActivity() {
        OLog.i(this.TAG, "startEnroll 5");
        Intent r0 = new Intent(this._mActivity, FaceEnrollEnrollingActivity.class);
        r0.putExtra(ProvisionConstants.EXTRA_SETUPWIZARD, this.mIsFromSetupWizard);
        r0.putExtra("password_confirmed", true);
        r0.putExtra("hw_auth_token", this.mToken);
        r0.putExtra("password", this.mPassword);
        r0.putExtra("request_code", 100);
        ((BaseActivity) getActivity()).customStartActivityForResult(r0);
    }

    @Override // com.android.settings.base.BaseFragment
    public void onCustomActivityResult(int r4, int r5, Intent r6) {
        super.onCustomActivityResult(r4, r5, r6);
        if (100 != r4) goto L6;
        this._mActivity.setResult(r5);
        this._mActivity.finish();
    L6:
        if (r5 == (-1)) goto L8;
        return;
    L8:
        boolean r0 = true;
        if (r4 == 200) goto L35;
        if (r4 != 300) goto L13;
        if (r6 != null) goto L27;
    L33:
        startEnroll();
        return;
    L27:
        if (r6.hasExtra("password") == false) goto L33;
        LockscreenCredential r7 = r6.getParcelableExtra("password");
        this.mPassword = r7;
        if (r7 != null) goto L32;
        r0 = false;
    L32:
        this.mPasswordConfirmed = r0;
        goto L33
    L13:
        if (r4 == 32767) goto L16;
        return;
    L16:
        if (hasLockScreenPwd() == false) goto L46;
        if (r6 != null) goto L19;
        return;
    L19:
        if (r6.hasExtra("password") == false) goto L48;
        LockscreenCredential r8 = r6.getParcelableExtra("password");
        this.mPassword = r8;
        if (r8 != null) goto L24;
        r0 = false;
    L24:
        this.mPasswordConfirmed = r0;
        return;
    L48:
        return;
    L46:
        return;
    L35:
        if (hasLockScreenPwd() == false) goto L51;
        if (r6 != null) goto L38;
    L44:
        startEnroll();
        return;
    L38:
        if (r6.hasExtra("password") == false) goto L44;
        LockscreenCredential r9 = r6.getParcelableExtra("password");
        this.mPassword = r9;
        if (r9 != null) goto L43;
        r0 = false;
    L43:
        this.mPasswordConfirmed = r0;
        goto L44
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_biometrics_FaceRecognitionEnrollTipFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(FaceRecognitionEnrollTipFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_biometrics_FaceRecognitionEnrollTipFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_biometrics_FaceRecognitionEnrollTipFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(FaceRecognitionEnrollTipFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_biometrics_FaceRecognitionEnrollTipFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_biometrics_FaceRecognitionEnrollTipFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(FaceRecognitionEnrollTipFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_biometrics_FaceRecognitionEnrollTipFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
