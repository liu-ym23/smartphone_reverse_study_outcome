package com.android.settings.biometrics;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.UserHandle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.internal.widget.LockPatternUtils;
import com.android.internal.widget.LockscreenCredential;
import com.android.internal.widget.VerifyCredentialResponse;
import com.android.settings.ChooseLockGeneric;
import com.android.settings.ChooseLockPassword;
import com.android.settings.ChooseLockPattern;
import com.android.settings.ChooseLockSettingsHelper;
import com.android.settings.R;
import com.android.settings.Settings;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.biometrics.facejigan.LiteManager;
import com.android.settings.provision.NextPageRouting.RoutingUtils;
import com.android.settings.provision.ProvisionConstants;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.wifi.TrustedNetworkHelper;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OIconButton;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.OMenuDialog2;
import obric.app.OMenuDialogListAdapter2;

/* JADX INFO: loaded from: classes2.dex */
public class FaceRecognitionSetupFragment extends BaseFragment {
    public static final String EXTRA_PASSWORD_CONFIRMED = "password_confirmed";
    private static final int REQUEST_CODE_CONFIRM_PASSWORD = 300;
    private static final int REQUEST_CODE_FACE_ENROLL = 100;
    private static final int REQUEST_CODE_SETUP_LOCK_SCREEN_PASSWORD = 200;
    private OMenuDialog2 mChooseLockTypeDialog;
    private boolean mFaceRecognitionEnable;
    private FaceRecognitionHelper mFaceRecognitionHelper;
    private LockscreenCredential mPassword;
    private boolean mPasswordConfirmed;
    VerifyCredentialResponse mResponse;
    private OAlertDialog mSetupLockScreenDialog;
    private boolean mSetupWizardMode;
    private OAlertDialog mTipsDialog;

    static /* synthetic */ void lambda$showSetupLockScreenDialog$3(DialogInterface r0, int r1) {
    }

    public void com_android_settings_biometrics_FaceRecognitionSetupFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_biometrics_FaceRecognitionSetupFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_biometrics_FaceRecognitionSetupFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public FaceRecognitionSetupFragment() {
        this.mPasswordConfirmed = false;
        this.mResponse = null;
    }

    static /* synthetic */ String access$000(FaceRecognitionSetupFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ String access$100(FaceRecognitionSetupFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ String access$200(FaceRecognitionSetupFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ void access$300(FaceRecognitionSetupFragment r0) {
        r0.showChooseLockMenuDialog();
    }

    static /* synthetic */ void access$400(FaceRecognitionSetupFragment r0, int r1, int r2) {
        r0.startChooseLockTypeActivity(r1, r2);
    }

    public static FaceRecognitionSetupFragment newInstance(boolean r2) {
        Bundle r0 = new Bundle();
        r0.putBoolean("password_confirmed", r2);
        FaceRecognitionSetupFragment r3 = new FaceRecognitionSetupFragment();
        r3.setArguments(r0);
        return r3;
    }

    public void com_android_settings_biometrics_FaceRecognitionSetupFragment__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        if (r4 != null) goto L5;
    L7:
        boolean r5 = false;
    L8:
        this.mPasswordConfirmed = r5;
        initLiteManager();
        FaceRecognitionHelper r6 = new FaceRecognitionHelper(this._mActivity);
        this.mFaceRecognitionHelper = r6;
        this.mFaceRecognitionEnable = r6.isFaceRecognitionDataExist();
        this.mSetupWizardMode = Utils.getBooleanExtraSafely(getIntent(), ProvisionConstants.EXTRA_SETUPWIZARD, false);
        return;
    L5:
        if (r4.getBoolean("password_confirmed", false) == false) goto L7;
        r5 = true;
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    private void initLiteManager() {
        OLog.d(this.TAG, "initLiteManager()...");
        LiteManager.getInstance().initLite(this.mContext, new AnonymousClass1(this));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        if (this.mSetupWizardMode == false) goto L14;
        this.mRootView = r2.inflate(R.layout.activity_base_face, r3, false);
        OIconButton r5 = (OIconButton) findViewByIdNullable(R.id.titlebar_back_btn);
        if (r5 == null) goto L7;
        r5.setOnClickListener(new FaceRecognitionSetupFragment$$ExternalSyntheticLambda1(this));
        r5.setVisibility(0);
    L7:
        TextView r6 = (TextView) findViewByIdNullable(R.id.titlebar_title_tv);
        if (r6 == null) goto L10;
        r6.setText(R.string.provision_face_enroll);
    L10:
        OButton r7 = (OButton) findViewByIdNullable(R.id.titlebar_right_btn);
        r7.setVisibility(0);
        r7.setOnClickListener(new FaceRecognitionSetupFragment$$ExternalSyntheticLambda2(this));
        OButton r8 = (OButton) findViewByIdNullable(R.id.bottom_button);
        if (r8 == null) goto L14;
        r8.setText(R.string.provision_face_go_enroll);
        r8.setOnClickListener(new FaceRecognitionSetupFragment$$ExternalSyntheticLambda3(this));
    L14:
        return this.mRootView;
    }

    /* JADX INFO: renamed from: lambda$onCreateView$0$com-android-settings-biometrics-FaceRecognitionSetupFragment, reason: not valid java name */
    /* synthetic */ void m338x2462d060(View r1) {
        if (isAdded() == false) goto L6;
        getActivity().onBackPressed();
        return;
    }

    /* JADX INFO: renamed from: lambda$onCreateView$1$com-android-settings-biometrics-FaceRecognitionSetupFragment, reason: not valid java name */
    /* synthetic */ void m339xb8a13fff(View r1) {
        if (isAdded() == false) goto L6;
        RoutingUtils.nextToPassword(getActivity());
        return;
    }

    /* JADX INFO: renamed from: lambda$onCreateView$2$com-android-settings-biometrics-FaceRecognitionSetupFragment, reason: not valid java name */
    /* synthetic */ void m340x4cdfaf9e(View r1) {
        startEnrollOrStartSetupLockScreen();
    }

    private void startEnrollOrStartSetupLockScreen() {
        if (hasLockScreenPwd() == true) goto L5;
        showSetupLockScreenDialog();
        return;
    L5:
        if (this.mPasswordConfirmed == false) goto L7;
        startEnrollFaceRecognition();
        return;
    L7:
        launchConfirmLock();
    }

    private void launchConfirmLock() {
        OLog.e(this.TAG, "launchConfirmLock");
        if (new ChooseLockSettingsHelper(this._mActivity).launchConfirmationActivity(300, getString(R.string.security_settings_fingerprint_preference_title), 2) == true) goto L6;
        OLog.e(this.TAG, "launchConfirmLock failed, finish");
        finish();
        return;
    }

    private void showSetupLockScreenDialog() {
        if (this.mSetupLockScreenDialog != null) goto L6;
        this.mSetupLockScreenDialog = (OAlertDialog) new OAlertDialogBuilder(this._mActivity).horizontalButton().title(R.string.setup_lockscreen_title).message(R.string.setup_lockscreen_message_face_recognition).positiveButton(R.string.setup_lockscreen_ok_button, new AnonymousClass2(this)).negativeButton(R.string.cancel, new FaceRecognitionSetupFragment$$ExternalSyntheticLambda0()).cancelable(false).build();
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
        return new AnonymousClass3(this, r2, r3);
    }

    private void startChooseLockTypeActivity(int r4, int r5) {
        Intent r0 = new Intent();
        if (r4 < 131072) goto L6;
        r0 = new Intent(this._mActivity, ChooseLockPassword.class);
        r0.putExtra("lockscreen.password_type", r4);
        r0.putExtra(ChooseLockPassword.PASSWORD_MIN_KEY, 4);
        r0.putExtra(ChooseLockPassword.EXTRA_PIN_LENGTH, r5);
    L8:
        r0.putExtra(ChooseLockSettingsHelper.EXTRA_KEY_HAS_CHALLENGE, true);
        r0.putExtra(ChooseLockGeneric.CONFIRM_CREDENTIALS, false);
        r0.putExtra(TrustedNetworkHelper.EXTRA_REQUEST_RESULT, true);
        Utils.startActivity(this, r0, 2, 200);
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

    private void startEnrollFaceRecognition() {
        OLog.e(this.TAG, "startEnrollFaceRecognition");
        Intent r0 = new Intent(this._mActivity, Settings.FaceRecognitionEnrollTipActivity.class);
        r0.putExtra("password_confirmed", true);
        r0.putExtra(ProvisionConstants.EXTRA_SETUPWIZARD, true);
        r0.putExtra("password", this.mPassword);
        Utils.startActivity(this._mActivity, r0, 0, 100);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r4, int r5, Intent r6) {
        super.onActivityResult(r4, r5, r6);
        OLog.e(this.TAG, "onActivityResult requestCode:" + r4 + ", resultCode:" + r5);
        if (this.mFaceRecognitionHelper.isFaceRecognitionDataExist() == false) goto L6;
        OLog.e(this.TAG, "onActivityResult hasFaceRecognitionData");
        finish();
        return;
    L6:
        if (r5 != 0) goto L9;
        return;
    L9:
        if (r4 != 100) goto L11;
        OLog.e(this.TAG, "onActivityResult REQUEST_CODE_FACE_ENROLL, finish");
        finish();
        return;
    L11:
        if (r4 != 200) goto L13;
    L15:
        boolean r7 = true;
        if (r6 == null) goto L27;
        this.mResponse = r6.getParcelableExtra("hw_auth_token");
        LockscreenCredential r8 = r6.getParcelableExtra("password");
        if (r8 == null) goto L20;
        this.mPassword = r8;
    L20:
        LockscreenCredential r9 = this.mPassword;
        if (r9 != null) goto L23;
    L25:
        boolean r10 = false;
    L26:
        this.mPasswordConfirmed = r10;
        goto L27
    L23:
        if (r9.isNone() == true) goto L25;
        r10 = true;
    L27:
        String r11 = this.TAG;
        StringBuilder r0 = new StringBuilder("mResponse is null: ");
        if (this.mResponse != null) goto L30;
        boolean r1 = true;
    L31:
        OLog.e(r11, r0.append(r1).toString());
        String r12 = this.TAG;
        StringBuilder r2 = new StringBuilder("mPassword is null: ");
        if (this.mPassword == null) goto L35;
        r7 = false;
    L35:
        OLog.e(r12, r2.append(r7).toString());
        if (this.mPasswordConfirmed == false) goto L40;
        startEnrollFaceRecognition();
        return;
    L40:
        return;
    L30:
        r1 = false;
        goto L31
    L13:
        if (r4 == 300) goto L15;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_biometrics_FaceRecognitionSetupFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(FaceRecognitionSetupFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_biometrics_FaceRecognitionSetupFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_biometrics_FaceRecognitionSetupFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(FaceRecognitionSetupFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_biometrics_FaceRecognitionSetupFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_biometrics_FaceRecognitionSetupFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(FaceRecognitionSetupFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_biometrics_FaceRecognitionSetupFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
