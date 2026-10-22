package com.android.settings.fingerprint;

import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserHandle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.profileinstaller.ProfileVerifier;
import com.android.internal.widget.LockPatternUtils;
import com.android.settings.AdapterActivity;
import com.android.settings.ChooseLockGeneric;
import com.android.settings.ChooseLockPassword;
import com.android.settings.ChooseLockPattern;
import com.android.settings.ChooseLockSettingsHelper;
import com.android.settings.R;
import com.android.settings.Settings;
import com.android.settings.SettingsFeature;
import com.android.settings.ToastUtils;
import com.android.settings.Utils;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.DisplayUtils;
import com.android.settings.wifi.TrustedNetworkHelper;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.OMenuDialog;
import obric.app.OMenuDialogListAdapter;

/* JADX INFO: loaded from: classes2.dex */
public class FingerprintEnrollWizardActivity extends BaseActivity implements View.OnClickListener {
    private final int REQUEST_CODE_ENROLLING_FINGERPRINT;
    private final int REQUEST_CODE_SETEUP_LOCKSCREEN;
    private final String TAG;
    private OMenuDialog mChooseLockTypeDialog;
    private boolean mIsFromSetupWizard;
    private boolean mIsFromTPassword;
    private boolean mIsFromWallet;
    private Button mNextStepButton;
    private OAlertDialog mSetupLockscreenDialog;
    private OAlertDialog mSkipWarningDialog;
    private TextView mTipsView;
    private byte[] mToken;

    static /* synthetic */ void lambda$showSetupLockscreenDialog$0(DialogInterface r0, int r1) {
    }

    public void com_android_settings_fingerprint_FingerprintEnrollWizardActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_fingerprint_FingerprintEnrollWizardActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_fingerprint_FingerprintEnrollWizardActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, android.app.Activity
    public void finish() {
        com_android_settings_fingerprint_FingerprintEnrollWizardActivity_com_obric_hook_lancet_PrivacyHook_finish(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_fingerprint_FingerprintEnrollWizardActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_fingerprint_FingerprintEnrollWizardActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_fingerprint_FingerprintEnrollWizardActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_fingerprint_FingerprintEnrollWizardActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_fingerprint_FingerprintEnrollWizardActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public FingerprintEnrollWizardActivity() {
        this.TAG = "Fingerprint";
        this.REQUEST_CODE_SETEUP_LOCKSCREEN = 200;
        this.REQUEST_CODE_ENROLLING_FINGERPRINT = 201;
    }

    static /* synthetic */ void access$000(FingerprintEnrollWizardActivity r0) {
        r0.showConfirmSkipDialog();
    }

    static /* synthetic */ boolean access$100(FingerprintEnrollWizardActivity r0) {
        return r0.mIsFromTPassword;
    }

    static /* synthetic */ void access$200(FingerprintEnrollWizardActivity r0) {
        r0.turnToFaceRecognitionEnrollActivity();
    }

    static /* synthetic */ void access$300(FingerprintEnrollWizardActivity r0) {
        r0.turnToSetupWizardCompleteActivity();
    }

    static /* synthetic */ void access$400(FingerprintEnrollWizardActivity r0) {
        r0.showChooseLockMenuDialog();
    }

    static /* synthetic */ void access$500(FingerprintEnrollWizardActivity r0, int r1, int r2) {
        r0.startChooseLockTypeActivity(r1, r2);
    }

    public void com_android_settings_fingerprint_FingerprintEnrollWizardActivity__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        setContentView(R.layout.fingerprint_enroll_wizard);
        boolean r5 = !Utils.isDeviceSetupComplete(this);
        this.mIsFromSetupWizard = r5;
        if (r5 == false) goto L5;
        registerWizardFinishReceiver();
    L5:
        Intent r6 = getIntent();
        String r1 = Utils.getStringExtraSafely(r6, AdapterActivity.EXTRA_SOURCE);
        if ("com.bytedanceos.wallet".equals(r1) == false) goto L9;
        this.mIsFromWallet = true;
    L9:
        if ("com.bytedanceos.tpassword".equals(r1) == false) goto L11;
        this.mIsFromTPassword = true;
    L11:
        this.mToken = r6.getByteArrayExtra("hw_auth_token");
        this.mTipsView = (TextView) findViewById(R.id.fingerprint_setup_tips);
        String r7 = r6.getStringExtra("extra_tips");
        if (TextUtils.isEmpty(r7) == true) goto L14;
        this.mTipsView.setText(r7);
    L14:
        Button r8 = (Button) findViewById(R.id.next_step_btn);
        this.mNextStepButton = r8;
        r8.setText(R.string.begin_setup);
        this.mNextStepButton.setOnClickListener(this);
        this.mRightBtn = setupBackBtnOnTitle().addEndAction(R.string.button_skip, -1, null);
        if (this.mIsFromSetupWizard == false) goto L17;
    L20:
        this.mBackView.setVisibility(4);
        this.mRightBtn.setOnClickListener(new AnonymousClass1(this));
        if (this.mIsFromTPassword == false) goto L24;
        this.mTipsView.setText(R.string.fingerprint_enroll_wizard_with_tpassword_tips);
    L24:
        if (SettingsFeature.isSupportFrontFP() == true) goto L27;
        findViewById(R.id.fingerprint_film_tips).setVisibility(8);
        return;
    L27:
        return;
    L17:
        if (this.mIsFromTPassword == true) goto L20;
        this.mRightBtn.setVisibility(4);
        this.mBackView.setOnClickListener(new AnonymousClass2(this));
        goto L24
    }

    public void com_android_settings_fingerprint_FingerprintEnrollWizardActivity__onResume$___twin___() {
        super.onResume();
        if (Utils.isFingerprintExists(this) == true) goto L5;
        return;
    L5:
        if (this.mIsFromSetupWizard == false) goto L9;
        this.mNextStepButton.setText(R.string.button_next_step);
        this.mTipsView.setText(R.string.fingerprint_enroll_complete_tips);
        return;
    }

    @Override // com.android.settings.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.mIsFromSetupWizard == false) goto L5;
        return;
    L5:
        if (this.mIsFromTPassword == true) goto L9;
        super.onBackPressed();
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int r3, int r4, Intent r5) {
        super.onActivityResult(r3, r4, r5);
        OLog.d("Fingerprint", "FingerprintEnrollWizardActivity onActivityResult, requestCode " + r3 + ", resultCode " + r4);
        if (r3 != 200) goto L17;
        if (isHasLockScreenPwd() == false) goto L17;
        if (SettingsFeature.isDarwin() == false) goto L9;
        int r6 = 0;
    L10:
        ToastUtils.showToastWithOffset(this, R.string.lock_pwd_setup_success, r6);
        if (r5 == null) goto L13;
        byte[] r7 = r5.getByteArrayExtra("hw_auth_token");
    L14:
        OLog.d("Fingerprint", "FingerprintEnrollWizardActivity onActivityResult " + r7);
        turnToFingerEnrollingActivity(r7);
        return;
    L13:
        r7 = null;
        goto L14
    L9:
        r6 = (int) DisplayUtils.dip2px(60.0f);
    L17:
        if (r3 == 201) goto L19;
        return;
    L19:
        if (r4 != (-1)) goto L22;
        setResult(r4);
        finish();
    L22:
        if (this.mIsFromSetupWizard == false) goto L24;
        return;
    L24:
        if (this.mIsFromTPassword == true) goto L29;
        finish();
        return;
    }

    private void showConfirmSkipDialog() {
        if (this.mSkipWarningDialog != null) goto L13;
        if (this.mIsFromWallet == false) goto L7;
        int r0 = R.string.skip_fingerprint_step__with_wallet_dialog_message;
    L9:
        if (this.mIsFromTPassword == false) goto L11;
        r0 = R.string.skip_fingerprint_step_with_tpassword_dialog_message;
    L11:
        this.mSkipWarningDialog = (OAlertDialog) new OAlertDialogBuilder(this).title(R.string.skip_fingerprint_step).message(r0).positiveButton(R.string.button_skip, new AnonymousClass4(this)).negativeButton(R.string.continue_enroll_fingerprint, new AnonymousClass3(this)).cancelable(false).build();
        goto L13
    L7:
        r0 = R.string.skip_fingerprint_step_dialog_message;
    L13:
        if (this.mSkipWarningDialog.isShowing() == true) goto L16;
        this.mSkipWarningDialog.show();
        return;
    }

    private void turnToFaceRecognitionEnrollActivity() {
        Utils.startActivity(this, new Intent(this, Settings.FaceRecognitionEnrollTipActivity.class));
    }

    private void turnToSetupWizardCompleteActivity() {
        Intent r0 = new Intent();
        r0.setComponent(new ComponentName("com.bytedanceos.setupwizard", "com.bytedanceos.setupwizard.SetupWizardCompleteActivity"));
        Utils.startActivity(this, r0);
    }

    private void turnToFingerEnrollingActivity(byte[] r4) {
        Intent r0 = BaseFingerprintEnrollingActivity.launchFingerprintEnrollingActivity(this);
        if (r4 == null) goto L5;
        r0.putExtra("hw_auth_token", r4);
        OLog.i("Fingerprint", "turnToFingerEnrollingActivity EXTRA_KEY_CHALLENGE_TOKEN: token is not null");
    L6:
        r0.putExtra("back_text_id", R.string.short_cancel);
        if (this.mIsFromWallet == false) goto L9;
        r0.putExtra(AdapterActivity.EXTRA_SOURCE, "com.bytedanceos.wallet");
    L9:
        Utils.startActivity(this, r0, 2, 201);
        return;
    L5:
        OLog.i("Fingerprint", "turnToFingerEnrollingActivity EXTRA_KEY_CHALLENGE_TOKEN: token is null");
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2 == this.mNextStepButton) goto L5;
        return;
    L5:
        if (isHasLockScreenPwd() == false) goto L7;
    L10:
        turnToFingerEnrollingActivity(this.mToken);
        return;
    L7:
        if (this.mToken != null) goto L10;
        showSetupLockscreenDialog();
    }

    private void showSetupLockscreenDialog() {
        if (this.mSetupLockscreenDialog != null) goto L6;
        this.mSetupLockscreenDialog = (OAlertDialog) new OAlertDialogBuilder(this).title(R.string.setup_lockscreen_title).message(R.string.setup_lockscreen_message).positiveButton(R.string.setup_lockscreen_ok_button, new AnonymousClass5(this)).negativeButton(R.string.cancel, new FingerprintEnrollWizardActivity$$ExternalSyntheticLambda0()).cancelable(false).build();
    L6:
        if (this.mSetupLockscreenDialog.isShowing() == true) goto L9;
        this.mSetupLockscreenDialog.show();
        return;
    }

    private boolean isHasLockScreenPwd() {
        return new LockPatternUtils(this).isSecure(UserHandle.myUserId());
    }

    private void showChooseLockMenuDialog() {
        if (this.mChooseLockTypeDialog != null) goto L12;
        OMenuDialog r0 = new OMenuDialog(this);
        this.mChooseLockTypeDialog = r0;
        r0.setTitle(R.string.choose_lock_type_title);
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        int r3 = 131072;
        if (this.mIsFromWallet == true) goto L8;
        r1.add(getString(R.string.lockscreen_mode_item_title_pattern));
        r2.add(getLockTypeSelectionOnclickListener(65536));
        r1.add(getString(R.string.lockscreen_mode_pin_four));
        r2.add(getLockTypeSelectionOnclickListener(131072, 4));
    L8:
        if (this.mIsFromWallet == false) goto L10;
        r3 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
    L10:
        r1.add(getString(R.string.lockscreen_mode_pin_six));
        r2.add(getLockTypeSelectionOnclickListener(r3, 6));
        r1.add(getString(R.string.lockscreen_mode_item_title_hard));
        r2.add(getLockTypeSelectionOnclickListener(262144));
        OMenuDialogListAdapter r4 = new OMenuDialogListAdapter(this, r1, r2);
        this.mChooseLockTypeDialog.setAdapter(r4);
    L12:
        if (this.mChooseLockTypeDialog.isShowing() == true) goto L15;
        this.mChooseLockTypeDialog.show();
        return;
    }

    private View.OnClickListener getLockTypeSelectionOnclickListener(int r2) {
        return getLockTypeSelectionOnclickListener(r2, 4);
    }

    private View.OnClickListener getLockTypeSelectionOnclickListener(final int r2, final int r3) {
        return new AnonymousClass6(this, r2, r3);
    }

    private void startChooseLockTypeActivity(int r4, int r5) {
        Intent r0 = new Intent();
        if (r4 < 131072) goto L6;
        r0 = new Intent(this, ChooseLockPassword.class);
        r0.putExtra("lockscreen.password_type", r4);
        r0.putExtra(ChooseLockPassword.PASSWORD_MIN_KEY, 4);
        r0.putExtra(ChooseLockPassword.EXTRA_PIN_LENGTH, r5);
    L8:
        OLog.i("Fingerprint", "startChooseLockTypeActivity challenge 0");
        r0.putExtra(ChooseLockSettingsHelper.EXTRA_KEY_HAS_CHALLENGE, true);
        r0.putExtra("challenge", 0);
        r0.putExtra("for_fingerprint", true);
        r0.putExtra(ChooseLockGeneric.CONFIRM_CREDENTIALS, false);
        r0.putExtra(TrustedNetworkHelper.EXTRA_REQUEST_RESULT, true);
        Utils.startActivity(this, r0, 2, 200);
        return;
    L6:
        if (r4 != 65536) goto L8;
        r0 = new Intent(this, ChooseLockPattern.class);
        r0.putExtra("pattern_size", 3);
        r0.putExtra("key_lock_method", "pattern");
        goto L8
    }

    public void com_android_settings_fingerprint_FingerprintEnrollWizardActivity__finish$___twin___() {
        super.finish();
        if (this.mIsFromWallet == false) goto L6;
        overridePendingTransition(0, R.anim.slide_down_out);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_fingerprint_FingerprintEnrollWizardActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(FingerprintEnrollWizardActivity r1) {
        com_android_settings_fingerprint_FingerprintEnrollWizardActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_fingerprint_FingerprintEnrollWizardActivity_com_obric_hook_lancet_PrivacyHook_onCreate(FingerprintEnrollWizardActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        FingerprintEnrollWizardActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_fingerprint_FingerprintEnrollWizardActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fingerprint_FingerprintEnrollWizardActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(FingerprintEnrollWizardActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_fingerprint_FingerprintEnrollWizardActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fingerprint_FingerprintEnrollWizardActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(FingerprintEnrollWizardActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_fingerprint_FingerprintEnrollWizardActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        FingerprintEnrollWizardActivity r5 = r4;
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
    public static void com_android_settings_fingerprint_FingerprintEnrollWizardActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(FingerprintEnrollWizardActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_fingerprint_FingerprintEnrollWizardActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_fingerprint_FingerprintEnrollWizardActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(FingerprintEnrollWizardActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_fingerprint_FingerprintEnrollWizardActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_fingerprint_FingerprintEnrollWizardActivity_com_obric_hook_lancet_PrivacyHook_onResume(FingerprintEnrollWizardActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        FingerprintEnrollWizardActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_fingerprint_FingerprintEnrollWizardActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_fingerprint_FingerprintEnrollWizardActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(FingerprintEnrollWizardActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_fingerprint_FingerprintEnrollWizardActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_fingerprint_FingerprintEnrollWizardActivity_com_obric_hook_lancet_PrivacyHook_onPause(FingerprintEnrollWizardActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        FingerprintEnrollWizardActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_fingerprint_FingerprintEnrollWizardActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_fingerprint_FingerprintEnrollWizardActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(FingerprintEnrollWizardActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_fingerprint_FingerprintEnrollWizardActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        FingerprintEnrollWizardActivity r5 = r3;
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
    public static void com_android_settings_fingerprint_FingerprintEnrollWizardActivity_com_obric_hook_lancet_PrivacyHook_onStop(FingerprintEnrollWizardActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        FingerprintEnrollWizardActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_fingerprint_FingerprintEnrollWizardActivity__onStop$___twin___();
    }

    @Insert("finish")
    public static void com_android_settings_fingerprint_FingerprintEnrollWizardActivity_com_obric_hook_lancet_PrivacyHook_finish(FingerprintEnrollWizardActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        FingerprintEnrollWizardActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.superFinish();
        return;
    L6:
        r3.com_android_settings_fingerprint_FingerprintEnrollWizardActivity__finish$___twin___();
    }
}
