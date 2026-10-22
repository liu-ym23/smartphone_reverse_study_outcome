package com.android.settings;

import android.app.admin.DevicePolicyManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.UserInfo;
import android.hardware.fingerprint.FingerprintManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import bytedanceos.util.NavigationBarHelper;
import com.android.internal.widget.LockPatternUtils;
import com.android.internal.widget.LockscreenCredential;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.applications.utils.ODialogUtils;
import com.android.settings.applications.utils.XTSUtils;
import com.android.settings.applock.AppLockManager;
import com.android.settings.base.BaseFragment;
import com.android.settings.biometrics.FaceRecognitionHelper;
import com.android.settings.biometrics.facejigan.LiteManager;
import com.android.settings.settingitemsprovider.DatabaseHelper;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.StringClickBuilder;
import com.android.settings.utils.UIUtils;
import com.android.settings.wifi.TrustedNetworkHelper;
import com.android.settingslib.RestrictedLockUtils;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.action.OActionDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class LockScreenFragment extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    public static final String ACTION_PRIVACY = "com.android.settings.bytedance.lockscreen.privacy";
    private static final int ADVANCE_SETTING_ITEM = 1605;
    private static final int ALERT_TYPE_FACE_RECOGNITION = 1;
    private static final int ALERT_TYPE_FINGERPRINT = 0;
    protected static final String ANSWERED_QUESTION_CORRECTLY = "answered_question_correctly";
    private static final String CONFIRM_CREDENTIALS = "confirm_credentials";
    private static final int ENROLL_NEW_FP_BUTTON = 1601;
    public static final int FOURE_DIGIT_PIN = 4;
    public static final String FROM = "LockScreenFragment";
    private static final int LOCK_APP_ITEM = 1604;
    private static final int LOCK_SCREEN_ITEM = 1602;
    private static final int MIN_PASSWORD_LENGTH = 4;
    private static final int MY_USER_ID = 0;
    private static final int PRIVACY_PASSWORD_ITEM = 1603;
    private static final int REQUEST_CODE_CLICK_SET_UP_LOCKSCREEN = 400;
    private static final int REQUEST_CODE_CONFIRM_ZTE_FACE = 500;
    private static final int REQUEST_CODE_FACE_ENROLL = 100;
    public static final int REQUEST_CODE_SETEUP_LOCKSCREEN = 200;
    private static final int REQUEST_CODE_SETEUP_LOCKSCREEN_FACE_RECOGNITION = 300;
    public static final int SIX_DIGIT_PIN = 6;
    private OCardListItem mAdServiceSettings;
    private OAlertDialog mAlertDialog;
    private OActionDialog mChooseLockTypeDialog;
    private DevicePolicyManager mDPM;
    private OCardListItem mEnrollFaceRecognitionItemText;
    private boolean mFaceRecognitionEnable;
    private FaceRecognitionHelper mFaceRecognitionHelper;
    private FingerprintManager mFingerprintManager;
    private OCardListItem mItemAdvanceSettings;
    private OCardListItem mItemLockScreenMode;
    private OCardListItem mItemTrustAgents;
    private OCardListItem mItemUnifiedLock;
    private OCardListItem mItemWorkSettings;
    private LockPatternUtils mLockPatternUtils;
    private OCardListItem mManageFaceRecognitionItem;
    private OCardListItem mManageFingerprint;
    public LockscreenCredential mPassword;
    private OCardListItem mPasswordBook;
    private AsyncTask<?, ?, ?> mPendingLockCheck;
    private OCardListItem mPrivacyPasswd;
    private OAlertDialog mSetupLockscreenDialog;
    private int mWorkUserId;
    private byte[] token;

    static /* synthetic */ void lambda$showSetupLockscreenDialog$1(DialogInterface r0, int r1) {
    }

    static /* synthetic */ void lambda$warningWillDisableTrustedAP$0(DialogInterface r0, int r1) {
    }

    @Override // com.android.settings.base.BaseFragment
    public int getTitleResId() {
        return R.string.lock_screen_header_title;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_LockScreenFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_LockScreenFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public LockScreenFragment() {
        this.mWorkUserId = -10000;
    }

    static /* synthetic */ String access$000(LockScreenFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ String access$100(LockScreenFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ void access$1000(LockScreenFragment r0, int r1, int r2, int r3) {
        r0.startChooseLockTypeActivity(r1, r2, r3);
    }

    static /* synthetic */ String access$200(LockScreenFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ void access$300(LockScreenFragment r0) {
        r0.updateFaceRecognitionView();
    }

    static /* synthetic */ OAlertDialog access$402(LockScreenFragment r0, OAlertDialog r1) {
        r0.mAlertDialog = r1;
        return r1;
    }

    static /* synthetic */ void access$500(LockScreenFragment r0) {
        r0.routeToFingerprintManagerActivity();
    }

    static /* synthetic */ void access$600(LockScreenFragment r0) {
        r0.addNewFaceRecognition();
    }

    static /* synthetic */ OAlertDialog access$702(LockScreenFragment r0, OAlertDialog r1) {
        r0.mSetupLockscreenDialog = r1;
        return r1;
    }

    static /* synthetic */ void access$800(LockScreenFragment r0, int r1) {
        r0.showChooseLockMenuDialog(r1);
    }

    static /* synthetic */ OActionDialog access$900(LockScreenFragment r0) {
        return r0.mChooseLockTypeDialog;
    }

    static {
        MY_USER_ID = UserHandle.myUserId();
    }

    public void com_android_settings_LockScreenFragment__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        this.mDPM = (DevicePolicyManager) getSystemService("device_policy");
        this.mFingerprintManager = (FingerprintManager) getSystemService("fingerprint");
        this.mLockPatternUtils = new ChooseLockSettingsHelper(this._mActivity).utils();
        PrivacySecurity.getInstance(this.mContext);
        AppLockManager.getInstance(this.mContext);
        initLiteManager();
        FaceRecognitionHelper r4 = new FaceRecognitionHelper(this._mActivity);
        this.mFaceRecognitionHelper = r4;
        this.mFaceRecognitionEnable = r4.isFaceRecognitionDataExist();
        this.token = getIntent().getByteArrayExtra("hw_auth_token");
        Intent r5 = this._mActivity.getIntent();
        if (r5 != null) goto L5;
        return;
    L5:
        if ("android.settings.PRIVACY_SETTINGS".equals(r5.getAction()) == true) goto L7;
        return;
    L7:
        if ("com.google.android.cts.deviceowner".equals(this._mActivity.getLaunchedFromPackage()) == false) goto L12;
        Intent r0 = new Intent();
        r0.putExtras(r5);
        r0.setClass(this._mActivity, MasterClearActivity.class);
        r0.putExtra("isPrivacySettings", true);
        this._mActivity.startActivity(r0);
        this._mActivity.finish();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        OLog.e(this.TAG, "onCreateView");
        this.mRootView = r3.inflate(R.layout.lock_screen_settings_layout, r4, false);
        OCardListItem r6 = (OCardListItem) findViewByIdNullable(R.id.manage_fingerprint);
        this.mManageFingerprint = r6;
        r6.setOnContentClickListener(this);
        OCardListItemUtils.setTrailingText(this.mManageFingerprint, getString(R.string.settings_no_record));
        OCardListItem r7 = (OCardListItem) findViewByIdNullable(R.id.item_lock_screen_password);
        this.mItemLockScreenMode = r7;
        r7.setOnContentClickListener(this);
        this.mItemUnifiedLock = (OCardListItem) findViewByIdNullable(R.id.item_work_profile_unified_lock);
        this.mItemWorkSettings = (OCardListItem) findViewById(R.id.item_work_settings);
        assignWorkUserId();
        OCardListItem r8 = (OCardListItem) findViewByIdNullable(R.id.item_password_book);
        this.mPasswordBook = r8;
        r8.setOnContentClickListener(this);
        OCardListItem r9 = (OCardListItem) findViewByIdNullable(R.id.item_ad_service);
        this.mAdServiceSettings = r9;
        r9.setOnContentClickListener(this);
        OCardListItem r10 = (OCardListItem) findViewByIdNullable(R.id.item_privacy_password);
        this.mPrivacyPasswd = r10;
        r10.setOnContentClickListener(this);
        OCardListItem r11 = (OCardListItem) findViewByIdNullable(R.id.manage_face_data);
        this.mManageFaceRecognitionItem = r11;
        r11.setOnContentClickListener(this);
        OCardListItem r12 = (OCardListItem) findViewByIdNullable(R.id.item_enroll_face_data);
        this.mEnrollFaceRecognitionItemText = r12;
        r12.setOnContentClickListener(this);
        OCardListItemUtils.setTrailingText(this.mManageFaceRecognitionItem, getString(R.string.settings_state_on));
        OCardListItemUtils.setTrailingText(this.mEnrollFaceRecognitionItemText, getString(R.string.settings_no_record));
        OCardListItem r13 = (OCardListItem) findViewByIdNullable(R.id.item_advance_settings);
        this.mItemAdvanceSettings = r13;
        r13.setOnContentClickListener(this);
        OCardListItem r14 = (OCardListItem) findViewByIdNullable(R.id.item_trust_agents);
        this.mItemTrustAgents = r14;
        r14.setOnContentClickListener(this);
        RestrictedLockUtils.EnforcedAdmin r15 = MultiSDKAdapterNew.checkIfKeyguardFeaturesDisabled(getContext(), 16, UserHandle.myUserId());
        if (isWorkProfileEnabled(this._mActivity) == false) goto L6;
        if (r15 == null) goto L6;
        this.mItemTrustAgents.setVisibility(0);
        this.mItemTrustAgents.setEnabled(false);
    L7:
        NavigationBarHelper.setBottomPaddingWhenNavigationBarStatusChange(findViewByIdNullable(R.id.page_scrollview));
        UIUtils.setUpBottomPaddingOnApplyWindowInsets((ViewGroup) findViewByIdNullable(R.id.page_container));
        TextView r16 = (TextView) ((OSectionSupportiveText) findViewByIdNullable(R.id.fingerprint_law_tips)).findViewById(R.id.section_des);
        StringClickBuilder r17 = new StringClickBuilder(getString(R.string.biometrics_license_tips), r16);
        int r18 = getResources().getColor(R.color.oui_functional_blue_6);
        r17.onClick(R.string.biometrics_fingerprint_license, r18, new AnonymousClass1(this));
        r17.onClick(R.string.biometrics_face_license, r18, new AnonymousClass2(this));
        r16.setText(r17.build());
        r16.setMovementMethod(LinkMovementMethod.getInstance());
        initAdsItemView(this.mRootView);
        return this.mRootView;
    L6:
        this.mItemTrustAgents.setVisibility(8);
        goto L7
    }

    public boolean isWorkProfileEnabled(Context r2) {
        UserManager r1 = (UserManager) r2.getSystemService(PickApplicationActivity.EXTRA_USER);
        if (r1 != null) goto L5;
        return false;
    L5:
        Iterator r3 = r1.getProfiles(UserHandle.myUserId()).iterator();
    L7:
        if (r3.hasNext() == false) goto L12;
        if (((UserInfo) r3.next()).isManagedProfile() == false) goto L7;
        return true;
    L12:
        return false;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        UIUtils.updatePadding(r2.findViewById(R.id.page_container), -1, UIUtils.INSTANCE.dp2px(104), -1, UIUtils.INSTANCE.dp2px(32));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
        this.mItemUnifiedLock.getEndSwitch().setOnCheckedChangeListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    private void initLiteManager() {
        OLog.d(this.TAG, "initLiteManager()...");
        LiteManager.getInstance().initLite(this.mContext, new AnonymousClass3(this));
    }

    private void bindFaceRecognition() {
        FaceRecognitionHelper r0 = this.mFaceRecognitionHelper;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.bind(new AnonymousClass4(this));
    }

    private void unbindFaceRecognition() {
        FaceRecognitionHelper r0 = this.mFaceRecognitionHelper;
        if (r0 == null) goto L6;
        r0.unbind();
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r4) {
        OLog.e(this.TAG, "onClick");
        if (r4 != OCardListItemUtils.getContentView(this.mManageFingerprint)) goto L9;
        if (needWarningWillDisableTrustedAP() == false) goto L7;
        OLog.e(this.TAG, "onClick mManageFingerprint: need warning");
        warningWillDisableTrustedAP(0);
        return;
    L7:
        OLog.e(this.TAG, "onClick mManageFingerprint: router to FingerprintManageActivity");
        routeToFingerprintManagerActivity();
        return;
    L9:
        if (OCardListItemUtils.getContentView(this.mItemLockScreenMode) != r4) goto L15;
        Intent r5 = new Intent(this._mActivity, LockScreenModeActivity.class);
        if (this.mTitleResId == null) goto L13;
        r5.putExtra("back_text_id", this.mTitleResId);
    L13:
        r5.putExtra("from", FROM);
        Utils.startActivity(this._mActivity, r5);
        SettingsTracker.onItemClick(LOCK_SCREEN_ITEM);
        return;
    L15:
        if (OCardListItemUtils.getContentView(this.mPrivacyPasswd) != r4) goto L18;
        startAppLockPrivacySetting(this._mActivity);
        SettingsTracker.onItemClick(PRIVACY_PASSWORD_ITEM);
        return;
    L18:
        if (OCardListItemUtils.getContentView(this.mItemAdvanceSettings) != r4) goto L21;
        start(SecuritySettingsFragment.class);
        SettingsTracker.onItemClick(ADVANCE_SETTING_ITEM);
        return;
    L21:
        if (OCardListItemUtils.getContentView(this.mAdServiceSettings) != r4) goto L24;
        start(AdServiceSettingsFragment.class);
        return;
    L24:
        if (r4 != OCardListItemUtils.getContentView(this.mEnrollFaceRecognitionItemText)) goto L30;
        if (needWarningWillDisableTrustedAP() == false) goto L28;
        warningWillDisableTrustedAP(1);
        return;
    L28:
        addNewFaceRecognition();
        return;
    L30:
        if (r4 != OCardListItemUtils.getContentView(this.mManageFaceRecognitionItem)) goto L36;
        if (SettingsFeature.isSupportZteFaceRecognition() == false) goto L34;
        new ChooseLockSettingsHelper(this._mActivity, this).launchConfirmationActivity(500, null, true, 2);
        return;
    L34:
        Utils.startActivity(this._mActivity, new Intent(this._mActivity, Settings.FaceRecognitionManageActivity.class), 0);
        return;
    L36:
        if (r4 != OCardListItemUtils.getContentView(this.mPasswordBook)) goto L42;
        Intent r6 = new Intent();     // Catch: Exception -> L39
        r6.setComponent(new ComponentName("com.obric.vault", "com.obric.vault.feat.main.SecurityAuthActivityForSettings"));     // Catch: Exception -> L39
        this._mActivity.startActivity(r6);     // Catch: Exception -> L39
        return;
    L39:
        e = move-exception;
        OLog.w(this.TAG, "start activity error:" + e);
        return;
    L42:
        if (OCardListItemUtils.getContentView(this.mItemTrustAgents) != r4) goto L58;
        start(TrustAgentSettings.class);
        return;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r4, boolean r5) {
        if (disallowChangeUnifyChallenge() == false) goto L6;
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(r4.getContext(), RestrictedLockUtils.getProfileOrDeviceOwner(r4.getContext(), "no_unified_password", UserHandle.getUserHandleForUid(MY_USER_ID)));
        r4.setChecked(false);
        return;
    L6:
        this.mLockPatternUtils.setSeparateProfileChallengeEnabled(this.mWorkUserId, !r5, this.mPassword);
        updateLockItemsEnabled(!r5);
    }

    private void routeToFingerprintManagerActivity() {
        if (isSecure() == false) goto L5;
    L8:
        Intent r0 = new Intent(this._mActivity, Settings.FingerprintManageActivity.class);
        Utils.startActivity(this._mActivity, r0, 0);
        return;
    L5:
        if (Utils.isFingerprintExists(this.mContext) == true) goto L8;
        showSetupLockscreenDialog(0);
    }

    public void startAppLockPrivacySetting(Context r9) {
        if (isAppLocked(r9) == false) goto L5;
        gotoChooseEasyPassword(r9, this.mDPM, 4, R.string.lock_screen_header_title, false, false, true);
        return;
    L5:
        gotoChooseEasyPassword(r9, this.mDPM, 6, R.string.lock_screen_header_title, false);
    }

    private boolean needWarningWillDisableTrustedAP() {
        if (this.mFaceRecognitionEnable == false) goto L16;
        if (hasTrustedAP() == false) goto L14;
        if (this.mLockPatternUtils.isSecure(MY_USER_ID) == false) goto L14;
        if (Utils.isFingerprintExists(this.mContext) == true) goto L14;
        if (this.mFaceRecognitionHelper.isFaceRecognitionDataExist() == true) goto L14;
        return true;
    L14:
        return false;
    L16:
        if (Utils.isFingerprintExists(this.mContext) == true) goto L23;
        if (this.mLockPatternUtils.isSecure(MY_USER_ID) == false) goto L23;
        if (hasTrustedAP() == false) goto L23;
        return true;
    L23:
        return false;
    }

    private void startEnrollFaceRecognition(LockscreenCredential r4) {
        OLog.i(this.TAG, "startEnrollFaceRecognition");
        Intent r0 = new Intent(this._mActivity, Settings.FaceRecognitionEnrollTipActivity.class);
        if (r4 != null) goto L5;
    L7:
        Utils.startActivity(this._mActivity, r0, 0, 100);
        return;
    L5:
        if (r4.isNone() == true) goto L7;
        r0.putExtra("password", r4);
        r0.putExtra("password_confirmed", true);
        goto L7
    }

    private void warningWillDisableTrustedAP(final int r3) {
        OAlertDialog r0 = this.mAlertDialog;
        if (r0 != null) goto L5;
    L7:
        OAlertDialog r4 = (OAlertDialog) new OAlertDialogBuilder(this._mActivity).horizontalButton().title(R.string.dialog_title_alert).message(getDisableTrustedAPMessage(r3)).positiveButton(R.string.continue_fingerprint_input, new AnonymousClass6(this, r3)).negativeButton(R.string.cancel, new LockScreenFragment$$ExternalSyntheticLambda1()).onDismiss(new AnonymousClass5(this)).build();
        this.mAlertDialog = r4;
        r4.show();
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
    }

    private void addNewFaceRecognition() {
        if (isSecure() == false) goto L5;
        startEnrollFaceRecognition(null);
        return;
    L5:
        showSetupLockscreenDialog(1);
    }

    private boolean isSecure() {
        return this.mLockPatternUtils.isSecure(UserHandle.myUserId());
    }

    private void showSetupLockscreenDialog(final int r4) {
        OAlertDialog r0 = this.mSetupLockscreenDialog;
        if (r0 != null) goto L5;
    L7:
        if (r4 != 0) goto L10;
        int r1 = R.string.setup_lockscreen_message;
    L12:
        OAlertDialog r5 = (OAlertDialog) new OAlertDialogBuilder(this._mActivity).horizontalButton().title(R.string.setup_lockscreen_title).message(r1).positiveButton(R.string.setup_lockscreen_ok_button, new AnonymousClass8(this, r4)).negativeButton(R.string.cancel, new LockScreenFragment$$ExternalSyntheticLambda0()).onDismiss(new AnonymousClass7(this)).cancelable(false).build();
        this.mSetupLockscreenDialog = r5;
        r5.show();
        return;
    L10:
        if (r4 != 1) goto L15;
        r1 = R.string.setup_lockscreen_message_face_recognition;
        goto L12
    L15:
        throw new IllegalArgumentException("unknown alert type : " + r4);
    L5:
        if (r0.isShowing() == false) goto L7;
    }

    private void showChooseLockMenuDialog(int r7) {
        ArrayList r3 = new ArrayList();
        r3.add(getString(R.string.lockscreen_mode_item_title_pattern));
        r3.add(getString(R.string.lockscreen_mode_pin_four));
        r3.add(getString(R.string.lockscreen_mode_pin_six));
        r3.add(getString(R.string.lockscreen_mode_item_title_hard));
        ArrayList r4 = new ArrayList();
        r4.add(getLockTypeSelectionOnclickListener(r7, 65536));
        r4.add(getLockTypeSelectionOnclickListener(r7, 131072, 4));
        r4.add(getLockTypeSelectionOnclickListener(r7, 131072, 6));
        r4.add(getLockTypeSelectionOnclickListener(r7, 262144));
        r4.add(new AnonymousClass9(this));
        this.mChooseLockTypeDialog = ODialogUtils.INSTANCE.showActionDialog(this._mActivity, getString(R.string.choose_lock_type_title), r3, r4, new AnonymousClass10(this));
    }

    private View.OnClickListener getLockTypeSelectionOnclickListener(int r2, int r3) {
        return getLockTypeSelectionOnclickListener(r2, r3, 4);
    }

    private View.OnClickListener getLockTypeSelectionOnclickListener(final int r2, final int r3, final int r4) {
        return new AnonymousClass11(this, r2, r3, r4);
    }

    private void startChooseLockTypeActivity(int r4, int r5, int r6) {
        Intent r0 = new Intent();
        if (r5 < 131072) goto L6;
        r0 = new Intent(this._mActivity, ChooseLockPassword.class);
        r0.putExtra("lockscreen.password_type", r5);
        r0.putExtra(ChooseLockPassword.PASSWORD_MIN_KEY, 4);
        r0.putExtra(ChooseLockPassword.EXTRA_PIN_LENGTH, r6);
    L8:
        r0.putExtra(ChooseLockSettingsHelper.EXTRA_KEY_HAS_CHALLENGE, true);
        if (r4 != 0) goto L11;
        OLog.i(this.TAG, "startChooseLockTypeActivity challenge 0");
        r0.putExtra("challenge", 0);
        r0.putExtra("for_fingerprint", true);
        int r7 = 200;
    L13:
        r0.putExtra("alert_type", r4);
        r0.putExtra("confirm_credentials", false);
        r0.putExtra(TrustedNetworkHelper.EXTRA_REQUEST_RESULT, true);
        Utils.startActivity(this, r0, 2, r7);
        return;
    L11:
        if (r4 != 1) goto L16;
        r7 = 300;
        goto L13
    L16:
        throw new IllegalArgumentException("unknown alert type : " + r4);
    L6:
        if (r5 != 65536) goto L8;
        r0 = new Intent(this._mActivity, ChooseLockPattern.class);
        r0.putExtra("pattern_size", 3);
        r0.putExtra("key_lock_method", "pattern");
        goto L8
    }

    public static void gotoChooseEasyPassword(Context r0, DevicePolicyManager r1, int r2, int r3, boolean r4, boolean r5, boolean r6) {
        Intent r7 = getAppLockPWDIntent(r0, r1, r2, r3);
        r7.putExtra(ANSWERED_QUESTION_CORRECTLY, r4);
        r7.putExtra(AppLockUtil.CHANGE_APPLICATION_LOCK_PASSWORD, r5);
        r7.putExtra(AppLockUtil.CHANGE_PLATE_LOCK_PASSWORD, r6);
        Utils.startActivity(r0, r7, 2);
    }

    public static void gotoChooseEasyPassword(Context r7, DevicePolicyManager r8, int r9, int r10, boolean r11) {
        gotoChooseEasyPassword(r7, r8, r9, r10, r11, false, false);
    }

    public static Intent getAppLockPWDIntent(Context r3, DevicePolicyManager r4, int r5, int r6) {
        Intent r0 = new Intent(r3, ChooseLockPassword.class);
        int r7 = r4.getPasswordMinimumLength(null);
        if (r7 >= 4) goto L5;
        r7 = 4;
    L5:
        int r8 = r4.getPasswordMaximumLength(131072);
        r0.putExtra("back_text_id", r6);
        r0.putExtra("lockscreen.password_type", 131072);
        r0.putExtra(ChooseLockPassword.PASSWORD_MIN_KEY, r7);
        r0.putExtra(ChooseLockPassword.PASSWORD_MAX_KEY, r8);
        r0.putExtra(ChooseLockPassword.EXTRA_PIN_LENGTH, r5);
        r0.putExtra("confirm_credentials", false);
        r0.putExtra(ChooseLockPassword.PASSWORD_APPLICATIONS_LOCK_KEY, true);
        return r0;
    }

    public void updateViews() {
        updateFaceRecognitionView();
        updateLockModeInfo();
        updateUnifiedLockSwitch();
        updateLockAppsInfo();
        updateUseFingerprintSettings();
        if (isSecure() == true) goto L6;
        this.token = null;
        return;
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    private void updateFaceRecognitionView() {
        boolean r0 = this.mFaceRecognitionHelper.isFaceRecognitionDataExist();
        boolean r1 = Utils.isSeDevice();
        OCardListItem r2 = this.mManageFaceRecognitionItem;
        int r3 = 0;
        if (r0 == false) goto L8;
        if (r1 == false) goto L6;
    L7:
        int r5 = 0;
    L9:
        r2.setVisibility(r5);
        OCardListItem r4 = this.mEnrollFaceRecognitionItemText;
        if (r0 == true) goto L14;
        if (r1 == false) goto L13;
    L15:
        r4.setVisibility(r3);
        updateLayout();
        DatabaseHelper.getInstance(this.mContext).updateFaceRecognitionItems();
        return;
    L13:
        if (SettingsFeature.isSupportZteFaceRecognition() == true) goto L15;
    L14:
        r3 = 8;
        goto L15
    L6:
        if (SettingsFeature.isSupportZteFaceRecognition() == true) goto L7;
    L8:
        r5 = 8;
        goto L9
    }

    private void updateUseFingerprintSettings() {
        boolean r1 = true;
        if (isLockScreenDisabled() == false) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L10;
        OCardListItemUtils.setTrailingText(this.mManageFingerprint, getString(R.string.settings_state_on));
    L11:
        updateLayout();
        DatabaseHelper r3 = DatabaseHelper.getInstance(this.mContext);
        if (this.mIsExtDisplaying == true) goto L15;
        if (r0 == false) goto L15;
    L16:
        r3.updateFingerprintItems(r1);
        return;
    L15:
        r1 = false;
        goto L16
    L10:
        OCardListItemUtils.setTrailingText(this.mManageFingerprint, getString(R.string.settings_no_record));
        goto L11
    L5:
        if (Utils.isFingerprintExists(this.mContext) == false) goto L7;
        r0 = true;
        goto L8
    }

    private void updateLayout() {
        ViewGroup r10 = (ViewGroup) findViewByIdNullable(R.id.biometrics_settings_layout);
        int r0 = r10.getChildCount();
        if (r0 <= 0) goto L31;
        OCardListItem r2 = null;
        int r3 = 0;
        int r4 = 0;
        boolean r5 = false;
    L6:
        if (r3 >= r0) goto L20;
        View r7 = r10.getChildAt(r3);
        boolean r8 = r7 instanceof OCardListItem;
        if (r8 == true) goto L10;
    L14:
        if (r8 == false) goto L19;
        if (r7.getVisibility() != 0) goto L19;
        if (r5 == false) goto L19;
        OCardListItem r9 = (OCardListItem) r7;
        r9.setCardPosition(2);
        r4 = r4 + 1;
    L13:
        r2 = r9;
    L19:
        r3 = r3 + 1;
        goto L6
    L10:
        if (r7.getVisibility() != 0) goto L14;
        if (r5 == true) goto L14;
        r9 = (OCardListItem) r7;
        r9.setCardPosition(1);
        r4 = r4 + 1;
        r5 = true;
        goto L13
    L20:
        if (r2 == null) goto L32;
        if (r4 != 1) goto L23;
        r2.setCardPosition(0);
        return;
    L23:
        if (r4 <= 1) goto L34;
        r2.setCardPosition(3);
        return;
    L34:
        return;
    L32:
        return;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        AsyncTask<?, ?, ?> r1 = this.mPendingLockCheck;
        if (r1 == null) goto L6;
        r1.cancel(false);
        this.mPendingLockCheck = null;
    L6:
        if (this.mAlertDialog == null) goto L15;
        OLog.d(this.TAG, "onPause disimissing dialog = " + this.mAlertDialog);     // Catch: IllegalArgumentException -> L9
        this.mAlertDialog.dismiss();     // Catch: IllegalArgumentException -> L9
    L11:
        this.mAlertDialog = null;
        return;
    L9:
        e = move-exception;
        OLog.w(this.TAG, "Exception dismissing dialog. Ex=" + e);
        goto L11
    }

    public void com_android_settings_LockScreenFragment__onResume$___twin___() {
        super.onResume();
        updateFaceRecognitionView();
    }

    private String getDisableTrustedAPMessage(int r5) {
        if (r5 != 0) goto L8;
        String r6 = getString(R.string.fingerprint);
        if (this.mFaceRecognitionEnable == false) goto L7;
        String r0 = getString(R.string.fingerprint_id_and_face_recognition);
    L11:
        return getString(R.string.trusted_network_feature_disable_notification, new Object[]{r6, r0});
    L7:
        r0 = r6;
        goto L11
    L8:
        if (r5 != 1) goto L13;
        r6 = getString(R.string.face_recognition);
        r0 = getString(R.string.fingerprint_id_and_face_recognition);
        goto L11
    L13:
        throw new IllegalArgumentException("unknown alert type : " + r5);
    }

    private boolean isAppLocked(Context r1) {
        return AppLockUtil.isLocked(r1);
    }

    private void updateLockAppsInfo() {
        if (AppLockUtil.isPrivacyPasswordSet(this.mContext.getContentResolver()) == true) goto L5;
        int r0 = R.string.security_item_applications_lock_none;
    L6:
        OCardListItemUtils.setTrailingText(this.mPrivacyPasswd, getString(r0));
        return;
    L5:
        r0 = R.string.security_item_applications_lock_edit;
        goto L6
    }

    private boolean isLockScreenDisabled() {
        LockPatternUtils r0 = this.mLockPatternUtils;
        int r1 = MY_USER_ID;
        if (r0.isSecure(r1) == false) goto L5;
    L7:
        return false;
    L5:
        if (this.mLockPatternUtils.isLockScreenDisabled(r1) == true) goto L7;
        return true;
    }

    private void updateLockModeInfo() {
        int r0 = (int) LockPatternUtilsOnly.getPasswordLengthBytedance(this.mLockPatternUtils, UserHandle.myUserId());
        LockPatternUtils r1 = this.mLockPatternUtils;
        int r2 = MY_USER_ID;
        if (r1.isSecure(r2) == true) goto L5;
        char r3 = R.xml.security_settings_chooser;
    L24:
        if (r3 == R.xml.security_settings_chooser) goto L26;
        if (r3 == R.xml.security_settings_pin) goto L31;
        if (r3 != R.xml.security_settings_password) goto L36;
        int r4 = R.string.lockscreen_mode_item_title_hard;
    L40:
        if (android.provider.Settings.Global.getInt(getContentResolver(), "use_fingerprint_in_lockscreen", 0) != 1) goto L42;
        boolean r5 = true;
    L44:
        if (Utils.isFingerprintExists(this.mContext) == false) goto L49;
        if (r5 == false) goto L49;
        if (this.mIsExtDisplaying == true) goto L49;
        String r6 = " + " + getString(R.string.fingerprint);
    L50:
        boolean r7 = this.mFaceRecognitionHelper.isFaceRecognitionDataExist();
        this.mFaceRecognitionEnable = r7;
        if (r7 == true) goto L53;
    L55:
        if (r4 == 0) goto L58;
        OCardListItemUtils.setTrailingText(this.mItemLockScreenMode, getString(r4));
        return;
    L58:
        return;
    L53:
        if (android.provider.Settings.Global.getInt(getContentResolver(), "faceid_enable", 0) != 1) goto L55;
        String r8 = r6 + " + " + getString(R.string.face_recognition);
    L49:
        r6 = "";
        goto L50
    L42:
        r5 = false;
        goto L44
    L36:
        if (r3 != R.xml.security_settings_pattern) goto L38;
        r4 = R.string.unlock_set_unlock_mode_pattern;
        goto L40
    L38:
        r4 = 0;
        goto L40
    L31:
        if (r0 != 4) goto L33;
        r4 = R.string.lockscreen_mode_pin_four;
        goto L40
    L33:
        r4 = R.string.lockscreen_mode_pin_six;
        goto L40
    L26:
        if (XTSUtils.isInXtsMode() == false) goto L28;
        r4 = R.string.unlock_set_unlock_mode_none;
        goto L40
    L28:
        r4 = R.string.unlock_set_unlock_mode_off;
        goto L40
    L5:
        int r9 = this.mLockPatternUtils.getKeyguardStoredPasswordQuality(r2);
        if (r9 != 65536) goto L8;
        r3 = R.xml.security_settings_pattern;
        goto L24
    L8:
        if (r9 == 131072) goto L20;
        if (r9 == 196608) goto L20;
        if (r9 != 262144) goto L14;
    L18:
        r3 = R.xml.security_settings_password;
        goto L24
    L14:
        if (r9 == 327680) goto L18;
        if (r9 == 393216) goto L18;
        r3 = 0;
    L20:
        if (r0 == (-1)) goto L18;
        r3 = R.xml.security_settings_pin;
        goto L24
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r3, int r4, Intent r5) {
        super.onActivityResult(r3, r4, r5);
        OLog.e(this.TAG, "LockscreenActivity onActivityResult, requestCode " + r3 + ", resultCode " + r4);
        if (r4 != RESULT_CANCELED) goto L6;
        return;
    L6:
        if (r3 == 500) goto L8;
        return;
    L8:
        if (r4 != RESULT_OK) goto L12;
        launcherZteFaceVerify(this.mContext);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        OAlertDialog r0 = this.mAlertDialog;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }

    private boolean hasTrustedAP() {
        return Utils.hasTrustedAP(this.mContext);
    }

    private void updateToken(byte[] r1) {
        this.token = r1;
    }

    private void updateUnifiedLockSwitch() {
        if (this.mWorkUserId != MY_USER_ID) goto L13;
        boolean r1 = false;
        this.mItemUnifiedLock.setVisibility(0);
        boolean r0 = disallowChangeUnifyChallenge();
        boolean r3 = !this.mLockPatternUtils.isSeparateProfileChallengeEnabled(this.mWorkUserId);
        if (r0 == true) goto L8;
        if (r3 == false) goto L8;
        r1 = true;
    L8:
        OCardListItemUtils.setChecked(this.mItemUnifiedLock, r1);
        if (r0 == false) goto L11;
        int r2 = R.string.disabled_by_administrator_summary;
    L12:
        OCardListItemUtils.setSubTitleString(this.mItemUnifiedLock, getString(r2));
        updateLockItemsEnabled(!r1);
        return;
    L11:
        r2 = R.string.lock_screen_unified_challenge_summary;
        goto L12
    L13:
        this.mItemUnifiedLock.setVisibility(8);
        updateLockItemsEnabled(true);
    }

    private void updateLockItemsEnabled(boolean r2) {
        this.mItemLockScreenMode.setEnabled(r2);
        this.mEnrollFaceRecognitionItemText.setEnabled(r2);
        this.mManageFaceRecognitionItem.setEnabled(r2);
        this.mManageFingerprint.setEnabled(r2);
    }

    private void assignWorkUserId() {
        UserManager r0 = (UserManager) getSystemService(PickApplicationActivity.EXTRA_USER);
        if (r0 == null) goto L10;
        Iterator r1 = r0.getProfiles(UserHandle.myUserId()).iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        UserInfo r2 = (UserInfo) r1.next();
        if (r2.isManagedProfile() == false) goto L6;
        this.mWorkUserId = r2.id;
    L10:
        final UserHandle r3 = Utils.getManagedProfile(r0);
        if (r3 != null) goto L13;
    L15:
        this.mItemWorkSettings.setVisibility(8);
        return;
    L13:
        if (r3.equals(UserHandle.CURRENT) == true) goto L15;
        this.mItemWorkSettings.setVisibility(0);
        this.mItemWorkSettings.setOnContentClickListener(new LockScreenFragment$$ExternalSyntheticLambda2(this, r3));
    }

    /* JADX INFO: renamed from: lambda$assignWorkUserId$2$com-android-settings-LockScreenFragment, reason: not valid java name */
    /* synthetic */ void m148xdf51aab4(UserHandle r2, View r3) {
        Intent r4 = new Intent("android.settings.SECURITY_SETTINGS");
        r4.setPackage(getPackageName());
        this._mActivity.startActivityAsUser(r4, r2);
    }

    private boolean disallowChangeUnifyChallenge() {
        return ((UserManager) getSystemService(PickApplicationActivity.EXTRA_USER)).hasUserRestriction("no_unified_password");
    }

    private void launcherZteFaceVerify(Context r4) {
        Intent r0 = new Intent("com.zte.faceverify.LIST");     // Catch: ActivityNotFoundException -> L4
        r0.putExtra("fromSetupWizard", false);     // Catch: ActivityNotFoundException -> L4
        r0.addFlags(268435456);     // Catch: ActivityNotFoundException -> L4
        r4.startActivity(r0);     // Catch: ActivityNotFoundException -> L4
        return;
    L4:
        OLog.d(this.TAG, "launcherZteFaceVerify ActivityNotFoundException");
    }

    private void initAdsItemView(View r4) {
        LinearLayout r5 = (LinearLayout) r4.findViewById(R.id.adsLayout);
        IGoogleAds r0 = (IGoogleAds) ServiceManager.getService(IGoogleAds.class);
        if (r0 == null) goto L5;
        this.mAdServiceSettings.setVisibility(8);
        r5.addView(r0.create(this._mActivity));
        return;
    L5:
        this.mAdServiceSettings.setVisibility(0);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_LockScreenFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(LockScreenFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_LockScreenFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_LockScreenFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(LockScreenFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_LockScreenFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_LockScreenFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(LockScreenFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_LockScreenFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
