package com.android.settings.provision;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserHandle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
import com.android.settings.biometrics.FaceRecognitionHelper;
import com.android.settings.fingerprint.BaseFingerprintEnrollingActivity;
import com.android.settings.provision.NextPageRouting.RoutingUtils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.teaevent.ProvisionTeaEvent;
import com.android.settings.teaevent.TeaEventConst;
import com.android.settings.wifi.TrustedNetworkHelper;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.dialog.alert.OAlertDialog;
import com.obric.oui.dialog.v2.selection.OSelectionDialog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.OMenuDialog2;
import obric.app.OMenuDialogListAdapter2;
import obric.app.SelectionDialogAdapter;

/* JADX INFO: loaded from: classes2.dex */
public class UnlockMethodSelectActivity extends ProvisionPureBaseActivity {
    private static final int REQUEST_CODE_CONFIRM_PASSWORD = 300;
    private static final int REQUEST_CODE_FACE_ENROLL = 100;
    private static final int REQUEST_CODE_SETUP_LOCK_SCREEN_PASSWORD = 200;
    private static final String TAG = "UnlockMethodSelectActivity";
    private OSelectionDialog currentDialog;
    private boolean mBackPressed;
    private OMenuDialog2 mChooseLockTypeDialog;
    private OCardListItem mFaceItem;
    private FaceRecognitionHelper mFaceRecognitionHelper;
    private OCardListItem mFingerItem;
    private int mMode;
    private LockscreenCredential mPassword;
    private boolean mPasswordConfirmed;
    private OCardListItem mPwdItem;
    VerifyCredentialResponse mResponse;
    private OAlertDialog mSetupLockScreenDialog;

    public void com_android_settings_provision_UnlockMethodSelectActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_provision_UnlockMethodSelectActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.provision.ProvisionPureBaseActivity
    protected int getBottomStringId(int r1) {
        return R.string.text_later_settings;
    }

    @Override // com.android.settings.provision.ProvisionPureBaseActivity
    protected int getContentLayoutId() {
        return R.layout.activity_provision_unlockmethodselect;
    }

    @Override // com.android.settings.provision.ProvisionPureBaseActivity
    protected int getTitleId() {
        return R.string.security_unlock_method;
    }

    @Override // com.android.settings.provision.ProvisionPureBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_provision_UnlockMethodSelectActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com_android_settings_provision_UnlockMethodSelectActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_provision_UnlockMethodSelectActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_android_settings_provision_UnlockMethodSelectActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_provision_UnlockMethodSelectActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public UnlockMethodSelectActivity() {
        this.mPassword = null;
        this.mResponse = null;
        this.mPasswordConfirmed = false;
        this.mMode = -1;
        this.currentDialog = null;
        this.mBackPressed = false;
        this.mFaceRecognitionHelper = new FaceRecognitionHelper(this);
    }

    static /* synthetic */ View access$000(UnlockMethodSelectActivity r0, ViewGroup r1) {
        return r0.genContentView(r1);
    }

    static /* synthetic */ void access$100(UnlockMethodSelectActivity r0, int r1, int r2) {
        r0.startChooseLockTypeActivity(r1, r2);
    }

    public void com_android_settings_provision_UnlockMethodSelectActivity__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        initUI();
        Window r3 = getWindow();
        if (r3 == null) goto L6;
        r3.setNavigationBarColor(getColor(R.color.Transparent));
        return;
    }

    private void initUI() {
        this.mFingerItem = (OCardListItem) findViewById(R.id.method_finger_print);
        this.mFaceItem = (OCardListItem) findViewById(R.id.method_face);
        this.mPwdItem = (OCardListItem) findViewById(R.id.method_simplepwd);
        this.mFaceItem.setOnContentClickListener(new UnlockMethodSelectActivity$$ExternalSyntheticLambda0(this));
        this.mFingerItem.setOnContentClickListener(new UnlockMethodSelectActivity$$ExternalSyntheticLambda1(this));
        this.mPwdItem.setOnContentClickListener(new UnlockMethodSelectActivity$$ExternalSyntheticLambda2(this));
    }

    /* JADX INFO: renamed from: lambda$initUI$0$com-android-settings-provision-UnlockMethodSelectActivity, reason: not valid java name */
    /* synthetic */ void m550x568193b1(View r1) {
        if (Utils.isFastDoubleClick() == false) goto L5;
        return;
    L5:
        this.mMode = 0;
        startEnrollOrStartSetupLockScreen();
        ProvisionTeaEvent.click(ProvisionTeaEvent.getPageName(getIntent()), TeaEventConst.CLICK_RECORD_FACEID);
    }

    /* JADX INFO: renamed from: lambda$initUI$1$com-android-settings-provision-UnlockMethodSelectActivity, reason: not valid java name */
    /* synthetic */ void m551x67376072(View r1) {
        if (Utils.isFastDoubleClick() == false) goto L5;
        return;
    L5:
        this.mMode = 1;
        startEnrollOrStartSetupLockScreen();
        ProvisionTeaEvent.click(ProvisionTeaEvent.getPageName(getIntent()), TeaEventConst.CLICK_RECORD_FINGERPRINT);
    }

    /* JADX INFO: renamed from: lambda$initUI$2$com-android-settings-provision-UnlockMethodSelectActivity, reason: not valid java name */
    /* synthetic */ void m552x77ed2d33(View r1) {
        if (Utils.isFastDoubleClick() == false) goto L5;
        return;
    L5:
        this.mMode = 2;
        showChooseLockMethodDialog("");
        ProvisionTeaEvent.click(ProvisionTeaEvent.getPageName(getIntent()), TeaEventConst.CLICK_SET_LOCK_PASSWORD);
    }

    public void com_android_settings_provision_UnlockMethodSelectActivity__onResume$___twin___() {
        super.onResume();
        OLog.e(TAG, "onResume");
        ProvisionTeaEvent.enterPage(getIntent());
        updateItemStatus();
        if (WizardManagerHelper.isAnySetupWizard(getIntent()) == false) goto L5;
        return;
    L5:
        getWindow().getDecorView().setBackgroundColor(0);
        getWindow().getDecorView().setVisibility(0);
        View r0 = getWindow().getDecorView();
        int r2 = getResources().getDisplayMetrics().widthPixels;
        ObjectAnimator r1 = ObjectAnimator.ofFloat(r0, "translationX", new float[]{r0.getTranslationX(), 0.0f});
        r1.setDuration(500);
        r1.setInterpolator(new PathInterpolator(0.18f, 0.85f, 0.4f, 1.0f));
        r1.start();
        r1.addListener(new AnonymousClass1(this));
    }

    public void com_android_settings_provision_UnlockMethodSelectActivity__onPause$___twin___() {
        super.onPause();
        OLog.i(TAG, "onPause: " + getTaskId());
        ProvisionTeaEvent.leavePage(getIntent());
        if (this.mBackPressed == false) goto L6;
        return;
    L6:
        if (WizardManagerHelper.isAnySetupWizard(getIntent()) == false) goto L8;
        return;
    L8:
        ObjectAnimator r0 = ObjectAnimator.ofFloat(getWindow().getDecorView(), "translationX", new float[]{0.0f, -getResources().getDisplayMetrics().widthPixels});
        r0.setDuration(500);
        r0.setInterpolator(new PathInterpolator(0.18f, 0.85f, 0.4f, 1.0f));
        r0.start();
        r0.addListener(new AnonymousClass2(this));
    }

    private void updateItemStatus() {
        boolean r0 = hasLockScreenPwd();
        boolean r1 = Utils.hasFingerprintEnrolled(this);
        boolean r2 = this.mFaceRecognitionHelper.isFaceRecognitionDataExist();
        if (r1 == true) goto L6;
        if (r2 == true) goto L6;
        if (r0 == true) goto L6;
    L7:
        if (r1 == false) goto L9;
        setCompleleTips(0);
    L9:
        if (r2 == false) goto L11;
        setCompleleTips(1);
    L11:
        if (r0 == false) goto L14;
        setCompleleTips(2);
        return;
    L14:
        return;
    L6:
        this.mBottomButton.setVisibility(0);
        this.mBottomButton.setText(R.string.next_step);
        this.mLaterSettingsTv.setVisibility(8);
        goto L7
    }

    @Override // com.android.settings.provision.ProvisionPureBaseActivity
    protected void nextStep(int r3) {
        String r0 = ProvisionTeaEvent.getPageName(getIntent());
        if (r3 != 0) goto L6;
        ProvisionTeaEvent.click(r0, TeaEventConst.CLICK_NEXT);
    L8:
        sendLockScreenChooseToProvision();
        if (WizardManagerHelper.isAnySetupWizard(getIntent()) == false) goto L12;
        OLog.i(TAG, "nextStep isAnySetupWizard");
        RoutingUtils.startActivityDefault2(this, WizardManagerHelper.getNextIntent(getIntent(), 102), 0);
        return;
    L12:
        RoutingUtils.nextToAccount(this);
        return;
    L6:
        if (r3 != 1) goto L8;
        ProvisionTeaEvent.click(r0, TeaEventConst.CLICK_SETUP_LATER);
        goto L8
    }

    private void startEnrollFinger() {
        OLog.e(TAG, "startEnrollFinger");
        Intent r0 = BaseFingerprintEnrollingActivity.launchFingerprintEnrollingActivity(this);
        LockscreenCredential r1 = this.mPassword;
        if (r1 == null) goto L5;
        r0.putExtra("password", r1);
    L5:
        r0.putExtra(BaseFingerprintEnrollingActivity.EXTRA_FROM_FP_MANAGER, false);
        r0.putExtra(ProvisionConstants.EXTRA_SETUPWIZARD, true);
        Utils.startActivity(this, r0, 2);
    }

    private void startEnrollOrStartSetupLockScreen() {
        if (hasLockScreenPwd() == true) goto L5;
        int r0 = this.mMode;
        if (r0 != 0) goto L15;
        String r1 = getString(R.string.setup_lockscreen_message_face_recognition);
    L18:
        showChooseLockMethodDialog(r1);
        return;
    L15:
        if (r0 != 1) goto L17;
        r1 = getString(R.string.setup_lockscreen_message);
        goto L18
    L17:
        r1 = "";
        goto L18
    L5:
        if (this.mPasswordConfirmed == false) goto L11;
        int r2 = this.mMode;
        if (r2 != 0) goto L9;
        startEnrollFaceRecognition();
        return;
    L9:
        if (r2 != 1) goto L21;
        startEnrollFinger();
        return;
    L21:
        return;
    L11:
        launchConfirmLock();
    }

    private void launchConfirmLock() {
        OLog.e(TAG, "launchConfirmLock");
        if (new ChooseLockSettingsHelper(this).launchConfirmationActivity(300, getString(R.string.security_settings_fingerprint_preference_title), 2) == true) goto L6;
        OLog.e(TAG, "launchConfirmLock failed, finish");
        return;
    }

    private boolean hasLockScreenPwd() {
        return new LockPatternUtils(this).isSecure(UserHandle.myUserId());
    }

    private void showChooseLockMethodDialog(String r8) {
        OSelectionDialog r9 = new OSelectionDialog(this, new OSelectionDialog.Modifier(getString(R.string.choose_lock_type_title), r8, new AnonymousClass3(this), null, null));
        this.currentDialog = r9;
        r9.show();
    }

    private View genContentView(ViewGroup r4) {
        RecyclerView r5 = new RecyclerView(this);
        r5.setOverScrollMode(2);
        r5.setLayoutManager(new LinearLayoutManager(this));
        r5.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        SelectionDialogAdapter r0 = new SelectionDialogAdapter(this);
        r5.setAdapter(r0);
        r0.setItems(genItemDataList());
        r0.setOnItemClickListener(new UnlockMethodSelectActivity$$ExternalSyntheticLambda3(this));
        return r5;
    }

    /* JADX INFO: renamed from: lambda$genContentView$3$com-android-settings-provision-UnlockMethodSelectActivity, reason: not valid java name */
    /* synthetic */ void m549xa99bbb9e(View r4, int r5) {
        OLog.d("SelectionDialog", "选中了：" + r5);
        int r6 = 65536;
        int r0 = 4;
        if (r5 != 0) goto L6;
    L14:
        startChooseLockTypeActivity(r6, r0);
        OSelectionDialog r7 = this.currentDialog;
        if (r7 != null) goto L17;
        return;
    L17:
        if (r7.isShowing() == false) goto L21;
        this.currentDialog.dismiss();
        return;
    L21:
        return;
    L6:
        if (r5 != 1) goto L9;
    L7:
        r6 = 131072;
        goto L14
    L9:
        if (r5 != 2) goto L12;
        r0 = 6;
        goto L7
    L12:
        if (r5 != 3) goto L14;
        r6 = 262144;
        goto L14
    }

    private List<String> genItemDataList() {
        ArrayList r0 = new ArrayList();
        r0.add(getString(R.string.lock_type_pattern));
        r0.add(getString(R.string.lockscreen_mode_pin_four));
        r0.add(getString(R.string.lockscreen_mode_pin_six));
        r0.add(getString(R.string.lockscreen_mode_item_title_hard));
        return r0;
    }

    private void showChooseLockMenuDialog() {
        if (this.mChooseLockTypeDialog != null) goto L6;
        OMenuDialog2 r0 = new OMenuDialog2(this);
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
        OMenuDialogListAdapter2 r3 = new OMenuDialogListAdapter2(this, r1, r2);
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

    private void startChooseLockTypeActivity(int r3, int r4) {
        Intent r0 = new Intent();
        if (r3 < 131072) goto L6;
        r0 = new Intent(this, ChooseLockPassword.class);
        r0.putExtra("lockscreen.password_type", r3);
        r0.putExtra(ChooseLockPassword.PASSWORD_MIN_KEY, 4);
        r0.putExtra(ChooseLockPassword.EXTRA_PIN_LENGTH, r4);
    L8:
        r0.putExtra(ChooseLockSettingsHelper.EXTRA_KEY_HAS_CHALLENGE, true);
        r0.putExtra(ChooseLockGeneric.CONFIRM_CREDENTIALS, false);
        r0.putExtra(TrustedNetworkHelper.EXTRA_REQUEST_RESULT, true);
        Utils.startActivity(this, r0, 2, 200);
        return;
    L6:
        if (r3 != 65536) goto L8;
        r0 = new Intent(this, ChooseLockPattern.class);
        r0.putExtra("pattern_size", 3);
        r0.putExtra("key_lock_method", "pattern");
        goto L8
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int r3, int r4, Intent r5) {
        super.onActivityResult(r3, r4, r5);
        OLog.e(TAG, "onActivityResult requestCode:" + r3 + ", resultCode:" + r4);
        if (r4 != 0) goto L6;
        return;
    L6:
        if (r3 != 100) goto L8;
        OLog.e(TAG, "onActivityResult REQUEST_CODE_FACE_ENROLL, finish");
        return;
    L8:
        if (r3 != 200) goto L10;
    L12:
        boolean r6 = false;
        if (r5 == null) goto L24;
        this.mResponse = r5.getParcelableExtra("hw_auth_token");
        LockscreenCredential r7 = r5.getParcelableExtra("password");
        if (r7 == null) goto L17;
        this.mPassword = r7;
        setPasswordToProvision();
    L17:
        LockscreenCredential r8 = this.mPassword;
        if (r8 != null) goto L20;
    L22:
        boolean r9 = false;
    L23:
        this.mPasswordConfirmed = r9;
        goto L24
    L20:
        if (r8.isNone() == true) goto L22;
        r9 = true;
    L24:
        StringBuilder r10 = new StringBuilder("mResponse is null: ");
        if (this.mResponse != null) goto L27;
        boolean r0 = true;
    L28:
        OLog.e(TAG, r10.append(r0).toString());
        StringBuilder r11 = new StringBuilder("mPassword is null: ");
        if (this.mPassword != null) goto L31;
        r6 = true;
    L31:
        OLog.e(TAG, r11.append(r6).toString());
        if (this.mPasswordConfirmed == false) goto L40;
        setCompleleTips(2);
        int r12 = this.mMode;
        if (r12 != 0) goto L36;
        startEnrollFaceRecognition();
        return;
    L36:
        if (r12 != 1) goto L42;
        startEnrollFinger();
        return;
    L42:
        return;
    L40:
        return;
    L27:
        r0 = false;
        goto L28
    L10:
        if (r3 == 300) goto L12;
    }

    private void setPasswordToProvision() {
        Uri r0 = Uri.parse("content://com.android.provision.ProvisionProvider");
        Bundle r1 = new Bundle();
        r1.putParcelable("password", this.mPassword);
        getContentResolver().call(r0, "set_password", null, r1);
    }

    private void sendLockScreenChooseToProvision() {
        boolean r0 = hasLockScreenPwd();     // Catch: Exception -> L4
        boolean r1 = Utils.hasFingerprintEnrolled(this);     // Catch: Exception -> L4
        boolean r2 = this.mFaceRecognitionHelper.isFaceRecognitionDataExist();     // Catch: Exception -> L4
        Uri r3 = Uri.parse("content://com.android.provision.ProvisionProvider");     // Catch: Exception -> L4
        Bundle r4 = new Bundle();     // Catch: Exception -> L4
        r4.putBoolean("os_unlock_passwd", r0);     // Catch: Exception -> L4
        r4.putBoolean("os_unlock_fingerprint", r1);     // Catch: Exception -> L4
        r4.putBoolean("os_unlock_faceid", r2);     // Catch: Exception -> L4
        getContentResolver().call(r3, "set_lockscreen_type", null, r4);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        OLog.e(TAG, "sendLockScreenChooseToProvision", e);
    }

    private void setCompleleTips(int r3) {
        if (r3 != 0) goto L6;
        this.mFingerItem.setEnabled(false);
        this.mFingerItem.setTitle(getString(R.string.enroll_fingerprint_set_complete));
        return;
    L6:
        if (r3 != 1) goto L8;
        this.mFaceItem.setEnabled(false);
        this.mFaceItem.setTitle(getString(R.string.enroll_face_set_complete));
        return;
    L8:
        this.mPwdItem.setEnabled(false);
        this.mPwdItem.setTitle(getString(R.string.enroll_pwd_set_complete));
    }

    private void startEnrollFaceRecognition() {
        OLog.e(TAG, "startEnrollFaceRecognition");
        Intent r0 = new Intent(this, Settings.FaceRecognitionEnrollTipActivity.class);
        r0.putExtra("password_confirmed", true);
        r0.putExtra(ProvisionConstants.EXTRA_SETUPWIZARD, true);
        r0.putExtra("password", this.mPassword);
        Utils.startActivity(this, r0, 0, 100);
    }

    @Override // com.android.settings.provision.ProvisionPureBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        this.mBackPressed = true;
        super.onBackPressed();
        ProvisionTeaEvent.click(ProvisionTeaEvent.getPageName(getIntent()), TeaEventConst.CLICK_BACK);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_provision_UnlockMethodSelectActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(UnlockMethodSelectActivity r1) {
        r1.com_android_settings_provision_UnlockMethodSelectActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_provision_UnlockMethodSelectActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(UnlockMethodSelectActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_provision_UnlockMethodSelectActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_provision_UnlockMethodSelectActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(UnlockMethodSelectActivity r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_provision_UnlockMethodSelectActivity__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        UnlockMethodSelectActivity r5 = r4;
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
    public static void com_android_settings_provision_UnlockMethodSelectActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(UnlockMethodSelectActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_provision_UnlockMethodSelectActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_provision_UnlockMethodSelectActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(UnlockMethodSelectActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_provision_UnlockMethodSelectActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_provision_UnlockMethodSelectActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(UnlockMethodSelectActivity r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_provision_UnlockMethodSelectActivity__onPause$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_provision_UnlockMethodSelectActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(UnlockMethodSelectActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        r3.com_android_settings_provision_UnlockMethodSelectActivity__onCreate$___twin___(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        UnlockMethodSelectActivity r5 = r3;
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
