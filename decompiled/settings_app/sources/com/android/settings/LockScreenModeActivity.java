package com.android.settings;

import android.app.ActivityManager;
import android.app.admin.DevicePolicyManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.face.Face;
import android.hardware.face.FaceManager;
import android.hardware.fingerprint.Fingerprint;
import android.hardware.fingerprint.FingerprintManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.UserHandle;
import android.os.UserManager;
import android.security.bytedance.guard.BDSettingsEvent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.android.internal.widget.LockPatternUtils;
import com.android.internal.widget.VerifyCredentialResponse;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.applications.utils.ODialogUtils;
import com.android.settings.applications.utils.XTSUtils;
import com.android.settings.autoaction.SecurityEventMonitor;
import com.android.settings.base.BaseActivity;
import com.android.settings.biometrics.FaceRecognitionHelper;
import com.android.settings.fingerprint.BaseFingerprintEnrollingActivity;
import com.android.settings.notification.LockNotificationFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NotificationHelper;
import com.android.settings.utils.ThreadUtils;
import com.android.settings.utils.UIUtils;
import com.android.settings.wifi.TrustedNetworkHelper;
import com.android.vcard.VCardConfig;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.common.oea.style.scene.transition.TransitionAnimHelper;
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.action.OActionDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.selection.OActionSheetButton;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class LockScreenModeActivity extends ConfirmLockBaseActivity implements View.OnClickListener {
    private static final String CONFIRM_CREDENTIALS = "confirm_credentials";
    public static final String FROM = "from";
    public static final String IS_PASSWORD_SETTING = "is_password_setting";
    public static final String MINIMUM_QUALITY_KEY = "minimum_quality";
    private static final int MIN_PASSWORD_LENGTH = 4;
    private static final int MY_USER_ID = 0;
    public static final int NOTIFICATION_DISPLAY_DETAIL_REQUEST = 200;
    public static final String PASSWORD_CONFIRMED = "password_confirmed";
    public static final int SET_LOCK_PASSWORD_REQUEST = 300;
    private static final String TAG = "LockScreenModeActivity";
    private static final String WAITING_FOR_CONFIRMATION = "waiting_for_confirmation";
    private CompoundButton.OnCheckedChangeListener mCheckedChangeListener;
    private ChooseLockSettingsHelper mChooseLockSettingsHelper;
    private OAlertDialog mConfirmRemoveFingerprintDialog;
    private DevicePolicyManager mDPM;
    private boolean mFaceRecognitionEnable;
    private FaceRecognitionHelper mFaceRecognitionHelper;
    private OActionDialog mFingerOrFaceActionSheet;
    private FingerprintManager mFingerprintManager;
    private String mFrom;
    private boolean mIsActionFinished;
    private boolean mIsHasBankCardInWallet;
    private boolean mIsManagedProfile;
    private boolean mIsPasswordSetting;
    private OCardListItem mItemEasy4;
    private OCardListItem mItemEasy6;
    private OCardListItem mItemHard;
    private OCardListItem mItemHidePatternTrack;
    private OCardListItem mItemNeedPassword;
    private OCardListItem mItemPattern;
    private OCardListItem mItemSwipe;
    private LockPatternUtils mLockPatternUtils;
    private LockPasswordQualityHelper mLockQualityHelper;
    private AsyncTask<?, ?, ?> mPendingLockCheck;
    private MultiSDKAdapter.RemovalCallback mRemovalCallback;
    private int mRequestedMinComplexity;
    private int mUserId;
    private VerifyCredentialResponse mVerifyCredentialResponse;
    private boolean mWaitingForConfirmation;
    private boolean registered;

    private void refreshUI() {
    }

    public void com_android_settings_LockScreenModeActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_LockScreenModeActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.ConfirmLockBaseActivity, com.android.settings.base.BaseActivity, android.app.Activity
    public void finish() {
        com_android_settings_LockScreenModeActivity_com_obric_hook_lancet_PrivacyHook_finish(this);
    }

    @Override // com.android.settings.ConfirmLockBaseActivity, com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_LockScreenModeActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // com.android.settings.ConfirmLockBaseActivity, com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_settings_LockScreenModeActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com_android_settings_LockScreenModeActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_LockScreenModeActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_LockScreenModeActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_LockScreenModeActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public LockScreenModeActivity() {
        this.mWaitingForConfirmation = false;
        this.mIsPasswordSetting = false;
        this.registered = false;
        this.mRemovalCallback = new AnonymousClass1(this);
        this.mIsHasBankCardInWallet = false;
        this.mFingerOrFaceActionSheet = null;
        this.mRequestedMinComplexity = 0;
        this.mUserId = -1;
        this.mCheckedChangeListener = new AnonymousClass2(this);
        this.mIsActionFinished = false;
    }

    static /* synthetic */ FingerprintManager access$000(LockScreenModeActivity r0) {
        return r0.mFingerprintManager;
    }

    static /* synthetic */ String access$100() {
        return TAG;
    }

    static /* synthetic */ int access$200(LockScreenModeActivity r0) {
        return r0.mUserId;
    }

    static /* synthetic */ LockPatternUtils access$300(LockScreenModeActivity r0) {
        return r0.mLockPatternUtils;
    }

    static /* synthetic */ void access$400(LockScreenModeActivity r0) {
        r0.startEnrolling();
    }

    static /* synthetic */ OActionDialog access$500(LockScreenModeActivity r0) {
        return r0.mFingerOrFaceActionSheet;
    }

    static /* synthetic */ boolean access$600(LockScreenModeActivity r0) {
        return r0.queryHasBankCardInWallet();
    }

    static /* synthetic */ boolean access$700(LockScreenModeActivity r0) {
        return r0.mIsHasBankCardInWallet;
    }

    static /* synthetic */ boolean access$702(LockScreenModeActivity r0, boolean r1) {
        r0.mIsHasBankCardInWallet = r1;
        return r1;
    }

    static /* synthetic */ void access$800(LockScreenModeActivity r0) {
        r0.updatePreferencesOrFinish();
    }

    static {
        MY_USER_ID = UserHandle.myUserId();
    }

    @Override // com.android.settings.base.BaseActivity
    public CharSequence getTitleName() {
        return getString(R.string.lock_screen_mode_title);
    }

    public void com_android_settings_LockScreenModeActivity__onCreate$___twin___(Bundle r5) {
        super.onCreate(r5);
        setContentView(R.layout.set_or_change_lock_method_layout);
        FaceRecognitionHelper r0 = new FaceRecognitionHelper(this);
        this.mFaceRecognitionHelper = r0;
        this.mFaceRecognitionEnable = r0.isFaceRecognitionDataExist();
        this.mFingerprintManager = (FingerprintManager) getSystemService("fingerprint");
        OCardListItem r1 = (OCardListItem) findViewById(R.id.item_mode_swipe);
        this.mItemSwipe = r1;
        r1.setOnContentClickListener(this);
        OCardListItem r2 = (OCardListItem) findViewById(R.id.item_mode_pattern);
        this.mItemPattern = r2;
        r2.setOnContentClickListener(this);
        OCardListItemUtils.setTitleRightDrawable(this.mItemPattern, R.drawable.settings_title_right_arrow);
        OCardListItem r3 = (OCardListItem) findViewById(R.id.item_mode_easy_4);
        this.mItemEasy4 = r3;
        r3.setOnContentClickListener(this);
        OCardListItemUtils.setTitleRightDrawable(this.mItemEasy4, R.drawable.settings_title_right_arrow);
        OCardListItem r4 = (OCardListItem) findViewById(R.id.item_mode_easy_6);
        this.mItemEasy6 = r4;
        r4.setOnContentClickListener(this);
        OCardListItemUtils.setTitleRightDrawable(this.mItemEasy6, R.drawable.settings_title_right_arrow);
        OCardListItem r6 = (OCardListItem) findViewById(R.id.item_mode_hard);
        this.mItemHard = r6;
        OCardListItemUtils.setTitleRightDrawable(r6, R.drawable.settings_title_right_arrow);
        this.mItemHard.setOnContentClickListener(this);
        OCardListItem r7 = (OCardListItem) findViewById(R.id.item_need_passward);
        this.mItemNeedPassword = r7;
        r7.setOnContentClickListener(this);
        this.mItemHidePatternTrack = (OCardListItem) findViewById(R.id.item_enable_visible_pattern);
        if ("android.app.action.SET_NEW_PARENT_PROFILE_PASSWORD".equals(getIntent().getAction()) == false) goto L5;
        this.mUserId = ActivityManager.getCurrentUser();
    L6:
        this.mIsManagedProfile = UserManager.get(this).isManagedProfile(this.mUserId);
        String r8 = TAG;
        OLog.d(r8, "mUserId: " + this.mUserId + " mIsManagedProfile:" + this.mIsManagedProfile);
        this.mLockQualityHelper = new LockPasswordQualityHelper(this, this.mUserId);
        this.mDPM = (DevicePolicyManager) getSystemService("device_policy");
        ChooseLockSettingsHelper r9 = new ChooseLockSettingsHelper(this);
        this.mChooseLockSettingsHelper = r9;
        this.mLockPatternUtils = r9.utils();
        OLog.d(r8, "mPasswordConfirmed " + this.mPasswordConfirmed);
        if (r5 == null) goto L9;
        this.mWaitingForConfirmation = r5.getBoolean(WAITING_FOR_CONFIRMATION);
    L9:
        this.mFrom = getIntent().getStringExtra("from");
        this.mRequestedMinComplexity = getIntent().getIntExtra("android.app.extra.PASSWORD_COMPLEXITY", 0);
        if (TextUtils.isEmpty(this.mFrom) == false) goto L15;
        if (getIntent().getBooleanExtra("from_search", false) == false) goto L15;
        this.mFrom = LockScreenFragment.FROM;
    L15:
        if ("notification".equals(this.mFrom) == false) goto L18;
        this.mItemHidePatternTrack.setVisibility(8);
        findViewById(R.id.item_enable_visible_pattern_shadow).setVisibility(8);
        this.mItemNeedPassword.setVisibility(8);
        findViewById(R.id.item_need_passward_shadow).setVisibility(8);
    L18:
        if (this.mPasswordConfirmed == false) goto L21;
        updatePreferencesOrFinish();
    L23:
        setupBackBtnOnTitle();
        UIUtils.fitMaskTitleInCommon((ViewGroup) findViewById(R.id.page_root), findViewById(R.id.page_container));
        return;
    L21:
        if (this.mWaitingForConfirmation == true) goto L23;
        this.mWaitingForConfirmation = true;
        goto L23
    L5:
        this.mUserId = Utils.getSecureTargetUser(getActivityToken(), UserManager.get(this), null, getIntent().getExtras()).getIdentifier();
        goto L6
    }

    @Override // com.android.settings.ConfirmLockBaseActivity
    protected boolean needInterceptConfirm(Bundle r1) {
        if (r1 != null) goto L4;
        return false;
    L4:
        if (r1.getBoolean(IS_PASSWORD_SETTING) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public void com_android_settings_LockScreenModeActivity__onDestroy$___twin___() {
        super.onDestroy();
        AsyncTask<?, ?, ?> r0 = this.mPendingLockCheck;
        if (r0 == null) goto L6;
        r0.cancel(false);
        this.mPendingLockCheck = null;
        return;
    }

    public void com_android_settings_LockScreenModeActivity__onResume$___twin___() {
        super.onResume();
        this.mFaceRecognitionEnable = this.mFaceRecognitionHelper.isFaceRecognitionDataExist();     // Catch: Exception -> L9
        updateLockscreenModeTitles();     // Catch: Exception -> L9
        updateCheckState();     // Catch: Exception -> L9
        updateLockAfterItem();     // Catch: Exception -> L9
        OCardListItem r0 = this.mItemHidePatternTrack;     // Catch: Exception -> L9
        if (this.mLockPatternUtils.isVisiblePatternEnabled(this.mUserId) == true) goto L6;
        boolean r1 = true;
    L7:
        OCardListItemUtils.setChecked(r0, r1);     // Catch: Exception -> L9
        startQueryBankcardCount();     // Catch: Exception -> L9
        OCardListItemUtils.setOnCheckedChangeListener(this.mItemHidePatternTrack, this.mCheckedChangeListener);     // Catch: Exception -> L9
        return;
    L6:
        r1 = false;
    L9:
        e = move-exception;
        OLog.e(TAG, "onResume failed, error_msg: " + e + ", finish");
        finish();
    }

    public void com_android_settings_LockScreenModeActivity__onPause$___twin___() {
        super.onPause();
        OCardListItemUtils.setOnCheckedChangeListener(this.mItemHidePatternTrack, null);
    }

    private void updatePreferencesOrFinish() {
        Intent r0 = getIntent();
        int r1 = r0.getIntExtra("lockscreen.password_type", -1);
        if (r1 != (-1)) goto L5;
        int r2 = r0.getIntExtra("minimum_quality", -1);
        disableUnusablePreferences(this.mLockQualityHelper.upgradeQuality(r2));
        return;
    L5:
        updateUnlockMethodAndFinish(r1, false);
    }

    private void disableUnusablePreferences(int r7) {
        OLog.d(TAG, "quality:" + r7);
        boolean r0 = true;
        if (r7 > 0) goto L5;
        boolean r2 = true;
    L7:
        if (r7 > 131072) goto L9;
        boolean r3 = true;
    L11:
        if (r7 <= 65536) goto L13;
    L15:
        boolean r4 = false;
    L17:
        if (r7 > 393216) goto L19;
        boolean r8 = true;
    L20:
        OCardListItemUtils.setEnabled(this.mItemSwipe, r2);
        OCardListItem r5 = this.mItemEasy4;
        if (r3 == true) goto L23;
    L25:
        r0 = false;
    L26:
        OCardListItemUtils.setEnabled(r5, r0);
        OCardListItemUtils.setEnabled(this.mItemEasy6, r3);
        OCardListItemUtils.setEnabled(this.mItemHard, r8);
        OCardListItemUtils.setEnabled(this.mItemPattern, r4);
        return;
    L23:
        if (this.mIsHasBankCardInWallet == true) goto L25;
    L19:
        r8 = false;
        goto L20
    L13:
        if (this.mIsHasBankCardInWallet == true) goto L15;
        r4 = true;
        goto L17
    L9:
        r3 = false;
        goto L11
    L5:
        r2 = false;
        goto L7
    }

    @Override // com.android.settings.ConfirmLockBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int r9, int r10, Intent r11) {
        super.onActivityResult(r9, r10, r11);
        this.mWaitingForConfirmation = false;
        String r1 = TAG;
        OLog.e(r1, "onActivityResult requestCode:" + r9 + ", resultCode:" + r10);
        if (r9 != 32767) goto L5;
        if (r10 != (-1)) goto L5;
    L8:
        if (this.registered == true) goto L10;
        BaseActivity.sIsUserEnterPasswordSettings = true;
        registerUserLeavePasswordSettingsIfNeeded();
        this.registered = true;
    L10:
        updatePreferencesOrFinish();
        if (r9 != 200) goto L14;
        setResult(-1);
        finish();
    L14:
        if (r11.hasExtra("password") == false) goto L39;
        OLog.e(r1, "onActivityResult getParcelableExtra EXTRA_KEY_PASSWORD");
        this.mPassword = r11.getParcelableExtra("password");
        if (this.mPassword != null) goto L18;
        return;
    L18:
        if (this.mPassword.isNone() == true) goto L41;
        this.mPasswordConfirmed = true;
        return;
    L41:
        return;
    L39:
        return;
    L5:
        if (r9 != 200) goto L21;
        if (r10 != 0) goto L8;
    L21:
        if (r9 != 300) goto L37;
        if (r10 == (-1)) goto L24;
        if (r10 != 1) goto L37;
    L24:
        OLog.d(r1, "SET_LOCK_PASSWORD_REQUEST");
        if (this.registered == true) goto L28;
        BaseActivity.sIsUserEnterPasswordSettings = true;
        registerUserLeavePasswordSettingsIfNeeded();
        this.registered = true;
    L28:
        if (r11.hasExtra("password") == false) goto L35;
        OLog.e(r1, "onActivityResult getParcelableExtra EXTRA_KEY_PASSWORD");
        this.mPassword = r11.getParcelableExtra("password");
        if (this.mPassword == null) goto L35;
        if (this.mPassword.isNone() == true) goto L35;
        this.mPasswordConfirmed = true;
    L35:
        if (LockNotificationFragment.FROM.equals(this.mFrom) == true) goto L43;
        showFingerOrFaceDialog();
        return;
    L43:
        return;
    L37:
        setResult(0);
        finish();
    }

    @Override // com.android.settings.ConfirmLockBaseActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle r3) {
        super.onSaveInstanceState(r3);
        r3.putBoolean(WAITING_FOR_CONFIRMATION, this.mWaitingForConfirmation);
        r3.putBoolean(IS_PASSWORD_SETTING, this.mIsPasswordSetting);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r4) {
        OLog.e(TAG, "onClick");
        if (r4 != this.mItemSwipe.getContentContainer()) goto L16;
        if (this.mFaceRecognitionEnable == false) goto L9;
        if (this.mFaceRecognitionHelper.isFaceRecognitionDataExist() == false) goto L9;
    L14:
        showConfirmRemoveFingerprintDialog();
    L28:
        updateCheckState();
        return;
    L9:
        if (Utils.isFingerprintExists(this) == true) goto L14;
        if (this.mIsHasBankCardInWallet == true) goto L14;
        updateUnlockMethodAndFinish(0, false);
        goto L28
    L16:
        if (r4 != OCardListItemUtils.getContentView(this.mItemPattern)) goto L19;
        updateUnlockMethodAndFinish(65536, false);
        goto L28
    L19:
        if (r4 != OCardListItemUtils.getContentView(this.mItemEasy4)) goto L22;
        updateUnlockMethodAndFinish(131072, 4, false);
        goto L28
    L22:
        if (r4 != OCardListItemUtils.getContentView(this.mItemEasy6)) goto L25;
        updateUnlockMethodAndFinish(131072, 6, false);
        goto L28
    L25:
        if (r4 != OCardListItemUtils.getContentView(this.mItemHard)) goto L27;
        updateUnlockMethodAndFinish(262144, false);
        goto L28
    L27:
        OCardListItemUtils.getContentView(this.mItemNeedPassword);
        goto L28
    }

    private void removeFaceRecognitionIfExist() {
        if (this.mFaceRecognitionEnable == true) goto L5;
        return;
    L5:
        removeFaceRecognitionIfExist(this.mContext, this.mFaceRecognitionHelper);
    }

    public static void removeFaceRecognitionIfExist(Context r2, FaceRecognitionHelper r3) {
        if (r3.isFaceRecognitionDataExist() == true) goto L5;
        return;
    L5:
        if (r3.deleteFaceRecognitionData(r2) == false) goto L9;
        android.provider.Settings.Global.putInt(r2.getContentResolver(), "faceid_enable", 0);
        PreferenceMgr.getInstance(r2).putBoolean(PreferenceMgr.KEY_FACE_RECOGNITION_DATA_EXIST, false);
        return;
    }

    private void launchNeedPasswordOptions() {
        String[] r0 = getResources().getStringArray(R.array.lock_after_timeout_entries);
        String[] r1 = getResources().getStringArray(R.array.lock_after_timeout_values);
        Utils.launchOptionsActivity(this, new OptionsInfo(r0, r1, OptionsInfo.SaveTargetTable.Secure, "lock_screen_lock_after_timeout"), r1[getCurrentLockAfterIndex()], getString(R.string.security_need_password), R.string.lock_screen_mode_title);
    }

    private int getCurrentLockAfterIndex() {
        int r2 = 0;
        int r0 = android.provider.Settings.Secure.getInt(getContentResolver(), "lock_screen_lock_after_timeout", 0);
        String[] r4 = getResources().getStringArray(R.array.lock_after_timeout_values);
        int r1 = 0;
    L4:
        if (r2 >= r4.length) goto L9;
        if (r0 < Integer.valueOf(r4[r2].toString()).intValue()) goto L8;
        r1 = r2;
    L8:
        r2 = r2 + 1;
        goto L4
    L9:
        return r1;
    }

    private void updateLockAfterItem() {
        int r0 = getCurrentLockAfterIndex();
        int r1 = getLockMode();
        OCardListItemUtils.setTrailingText(this.mItemNeedPassword, getResources().getStringArray(R.array.lock_after_timeout_entries)[r0]);
        boolean r3 = false;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "use_fingerprint_in_lockscreen", 0) != 1) goto L5;
        boolean r2 = true;
    L6:
        OCardListItem r4 = this.mItemNeedPassword;
        if (r2 == true) goto L10;
        if (r1 == 1) goto L10;
        r3 = true;
    L10:
        OCardListItemUtils.setEnabled(r4, r3);
        return;
    L5:
        r2 = false;
        goto L6
    }

    private void updateCheckState() {
        int r0 = getLockMode();
        int r1 = (int) LockPatternUtilsOnly.getPasswordLengthBytedance(this.mLockPatternUtils, this.mUserId);
        OLog.d(TAG, "updateCheckState quality" + r0);
        OCardListItem r2 = this.mItemSwipe;
        boolean r3 = false;
        if (r0 != 1) goto L5;
        boolean r5 = true;
    L6:
        OCardListItemUtils.setMark(r2, r5);
        OCardListItem r4 = this.mItemPattern;
        if (r0 != 2) goto L9;
        boolean r6 = true;
    L10:
        OCardListItemUtils.setMark(r4, r6);
        OCardListItem r7 = this.mItemEasy4;
        if (r0 != 3) goto L14;
        if (r1 != 4) goto L14;
        boolean r8 = true;
    L15:
        OCardListItemUtils.setMark(r7, r8);
        OCardListItem r9 = this.mItemEasy6;
        if (r0 == 3) goto L18;
    L20:
        boolean r10 = false;
    L21:
        OCardListItemUtils.setMark(r9, r10);
        OCardListItem r11 = this.mItemHard;
        if (r0 != 4) goto L24;
        r3 = true;
    L24:
        OCardListItemUtils.setMark(r11, r3);
        return;
    L18:
        if (r1 != 6) goto L20;
        r10 = true;
    L14:
        r8 = false;
        goto L15
    L9:
        r6 = false;
        goto L10
    L5:
        r5 = false;
        goto L6
    }

    private void updateLockscreenModeTitles() {
        android.provider.Settings.Global.getInt(getContentResolver(), "use_fingerprint_in_lockscreen", 0);
        OCardListItem r0 = this.mItemSwipe;
        if (XTSUtils.isInXtsMode() == false) goto L5;
        int r1 = R.string.lockscreen_mode_item_title_swipe;
    L6:
        OCardListItemUtils.setTitle(r0, getString(r1));
        OCardListItemUtils.setTitle(this.mItemPattern, getString(R.string.lockscreen_mode_item_title_pattern));
        OCardListItemUtils.setTitle(this.mItemEasy4, getString(R.string.lockscreen_mode_pin_four));
        OCardListItemUtils.setTitle(this.mItemEasy6, getString(R.string.lockscreen_mode_pin_six));
        OCardListItemUtils.setTitle(this.mItemHard, getString(R.string.lockscreen_mode_item_title_hard));
        return;
    L5:
        r1 = R.string.lockscreen_mode_item_title_none;
        goto L6
    }

    private void showFingerOrFaceDialog() {
        if (this.mFaceRecognitionEnable == true) goto L5;
    L7:
        ArrayList r4 = new ArrayList();
        ArrayList r5 = new ArrayList();
        OActionDialog r0 = this.mFingerOrFaceActionSheet;
        if (r0 != null) goto L10;
    L12:
        View r1 = LayoutInflater.from(this).inflate(R.layout.finger_or_face_item, null);
        ((OActionSheetButton) r1.findViewById(R.id.finger_item)).setText(getString(R.string.enroll_fingerprint_data));
        if (Utils.isFingerprintExists(this) == true) goto L16;
        r4.add(getString(R.string.enroll_fingerprint_data));
        r5.add(new AnonymousClass3(this));
    L16:
        ((OActionSheetButton) r1.findViewById(R.id.face_item)).setText(getString(R.string.enroll_face_data));
        if (this.mFaceRecognitionEnable == false) goto L19;
    L22:
        r5.add(new AnonymousClass5(this));
        this.mFingerOrFaceActionSheet = ODialogUtils.INSTANCE.showActionDialog(this, getString(R.string.lock_pwd_setup_success), r4, r5, new AnonymousClass6(this));
        return;
    L19:
        if (Utils.isSeDevice() == false) goto L22;
        r4.add(getString(R.string.enroll_face_data));
        r5.add(new AnonymousClass4(this));
        goto L22
    L10:
        if (r0.isShowing() == false) goto L12;
        this.mFingerOrFaceActionSheet.dismiss();
        goto L12
    L5:
        if (Utils.isFingerprintExists(this) == false) goto L7;
    }

    private void startEnrolling() {
        turnToFingerEnrollingActivity();
    }

    private void turnToFingerEnrollingActivity() {
        String r0 = TAG;
        StringBuilder r1 = new StringBuilder("turnToFingerEnrollingActivity: mPassword==null ");
        if (this.mPassword != null) goto L5;
        boolean r2 = true;
    L6:
        OLog.i(r0, r1.append(r2).toString());
        Intent r3 = BaseFingerprintEnrollingActivity.launchFingerprintEnrollingActivity(this);
        if (this.mPassword != null) goto L9;
    L11:
        r3.putExtra("back_text_id", R.string.short_cancel);
        Utils.startActivity(this, r3, 2);
        return;
    L9:
        if (this.mPassword.isNone() == true) goto L11;
        r3.putExtra("password", this.mPassword);
        r3.putExtra("password_confirmed", true);
        goto L11
    L5:
        r2 = false;
        goto L6
    }

    private int getLockMode() {
        if (this.mLockPatternUtils.isSecure(this.mUserId) == false) goto L27;
        int r0 = this.mLockPatternUtils.getKeyguardStoredPasswordQuality(this.mUserId);
        if (r0 != 65536) goto L8;
        return 2;
    L8:
        if (r0 == 131072) goto L20;
        if (r0 == 196608) goto L20;
        if (r0 == 262144) goto L25;
        if (r0 == 327680) goto L25;
        if (r0 == 393216) goto L25;
        return 1;
    L25:
        return 4;
    L20:
        if (((int) LockPatternUtilsOnly.getPasswordLengthBytedance(this.mLockPatternUtils, this.mUserId)) == (-1)) goto L25;
        return 3;
    L27:
        return 1;
    }

    void updateUnlockMethodAndFinish(int r2, boolean r3) {
        updateUnlockMethodAndFinish(r2, 4, r3);
    }

    void updateUnlockMethodAndFinish(int r18, int r19, boolean r20) {
        String r4 = TAG;
        OLog.e(r4, "updateUnlockMethodAndFinish quality=" + r18 + ", pinLength=" + r19 + ", disabled=" + r20);
        if (updatePasswordIfUnspecified(r18, r20) == false) goto L5;
        return;
    L5:
        this.mIsPasswordSetting = true;
        int r1 = this.mLockQualityHelper.upgradeQuality(r18);
        if (this.mPassword != null) goto L8;
        OLog.e(r4, "updateUnlockMethodAndFinish mPassword is null");
    L8:
        OLog.e(r4, "updateUnlockMethodAndFinish upgradeQuality quality=" + r1);
        if (r1 < 131072) goto L29;
        int r3 = this.mDPM.getPasswordMinimumLength(null);
        if (r3 >= 4) goto L14;
        r3 = 4;
    L14:
        if (this.mIsHasBankCardInWallet == true) goto L16;
    L18:
        int r6 = this.mDPM.getPasswordMaximumLength(r1);
        Intent r5 = new Intent().setClass(this, ChooseLockPassword.class);
        OLog.i(r4, "updateUnlockMethodAndFinish  ChooseLockPassword:" + r1);
        r5.putExtra("lockscreen.password_type", r1);
        r5.putExtra(ChooseLockPassword.PASSWORD_MIN_KEY, r3);
        r5.putExtra(ChooseLockPassword.PASSWORD_MAX_KEY, r6);
        r5.putExtra(ChooseLockPassword.EXTRA_PIN_LENGTH, r19);
        r5.putExtra(ChooseLockPassword.EXTRA_WALLET_HAS_BANKCARD, this.mIsHasBankCardInWallet);
        r5.putExtra("password", this.mPassword);
        r5.putExtra("confirm_credentials", false);
        r5.putExtra(EncryptionInterstitial.EXTRA_REQUIRE_PASSWORD, false);
        r5.putExtra(ChooseLockSettingsHelper.EXTRA_KEY_HAS_CHALLENGE, true);
        r5.putExtra("android.app.extra.PASSWORD_COMPLEXITY", this.mRequestedMinComplexity);
        r5.putExtra("android.intent.extra.USER_ID", this.mUserId);
        if ("notification".equals(this.mFrom) == false) goto L22;
        Utils.startActivityForResult(this, r5, 2, 200);
        return;
    L22:
        if (LockScreenFragment.FROM.equals(this.mFrom) == false) goto L24;
    L27:
        Utils.startActivityForResult(this, r5, 2, 300);
        return;
    L24:
        if (LockNotificationFragment.FROM.equals(this.mFrom) == true) goto L27;
        r5.addFlags(VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING);
        Utils.startActivity(this, r5, 2);
        finish();
        return;
    L16:
        if (r1 >= 196608) goto L18;
        r1 = 196608;
        goto L18
    L29:
        if (r1 != 65536) goto L40;
        OLog.i(r4, "updateUnlockMethodAndFinish  ChooseLockPattern:" + r1);
        Intent r2 = new Intent();
        r2.setClass(this, ChooseLockPattern.class);
        r2.putExtra("pattern_size", 3);
        r2.putExtra("key_lock_method", "pattern");
        r2.putExtra("confirm_credentials", false);
        r2.putExtra("password", this.mPassword);
        r2.putExtra(EncryptionInterstitial.EXTRA_REQUIRE_PASSWORD, false);
        r2.putExtra(ChooseLockSettingsHelper.EXTRA_KEY_HAS_CHALLENGE, true);
        r2.putExtra("android.intent.extra.USER_ID", this.mUserId);
        if ("notification".equals(this.mFrom) == false) goto L34;
        Utils.startActivityForResult(this, r2, 2, 200);
        return;
    L34:
        if (LockScreenFragment.FROM.equals(this.mFrom) == false) goto L36;
    L39:
        r2.putExtra(TrustedNetworkHelper.EXTRA_REQUEST_RESULT, true);
        Utils.startActivityForResult(this, r2, 2, 300);
        return;
    L36:
        if (LockNotificationFragment.FROM.equals(this.mFrom) == true) goto L39;
        r2.addFlags(VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING);
        Utils.startActivity(this, r2, 2);
        finish();
        return;
    L40:
        updatePasswordIfUnspecified(r1, r20);
    }

    private boolean updatePasswordIfUnspecified(int r4, final boolean r5) {
        OLog.i(TAG, "updatePasswordIfUnspecified quality=" + r4 + ", disabled=" + r5);
        if (r4 != 0) goto L6;
        ThreadUtils.postOnBackgroundThread(new LockScreenModeActivity$$ExternalSyntheticLambda0(this, r5));
        return true;
    L6:
        return false;
    }

    /* JADX INFO: renamed from: lambda$updatePasswordIfUnspecified$1$com-android-settings-LockScreenModeActivity, reason: not valid java name */
    /* synthetic */ void m152x6ada874b(boolean r5) {
        OLog.e(TAG, "updatePasswordIfUnspecified clearLock2");
        InvisibleApi.setSeparateProfileChallengeEnabled2(this.mLockPatternUtils, this.mUserId, true, this.mPassword);
        InvisibleApi.clearLock2(this.mChooseLockSettingsHelper.utils(), this.mPassword, this.mUserId);
        this.mChooseLockSettingsHelper.utils().setLockScreenDisabled(r5, this.mUserId);
        final boolean r6 = removeAllFingerprintTemplates();
        removeFaceRecognitionData();
        ThreadUtils.postOnMainThread(new LockScreenModeActivity$$ExternalSyntheticLambda4(this, r6));
    }

    /* JADX INFO: renamed from: lambda$updatePasswordIfUnspecified$0$com-android-settings-LockScreenModeActivity, reason: not valid java name */
    /* synthetic */ void m151xd039c4ca(boolean r3) {
        if ("notification".equals(this.mFrom) == true) goto L5;
        setResult(-1);
    L5:
        NotificationHelper.getInstance().resetNotificationsVisibility();
        if (r3 == false) goto L9;
        finish();
        return;
    }

    private void removeFaceRecognitionData() {
        FaceManager r0 = Utils.getFaceManagerOrNull(this.mContext);
        if (r0 == null) goto L11;
        List r1 = r0.getEnrolledFaces(this.mUserId);
        OLog.i(TAG, "removeFaceRecognitionData: faces = " + r1);
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.isEmpty() == true) goto L13;
        r0.remove((Face) r1.get(0), this.mUserId, new AnonymousClass7(this));
        return;
    L13:
        return;
    }

    private boolean removeAllFingerprintTemplates() {
        return removeAllFingerprintTemplates(this, this.mRemovalCallback, this.mUserId);
    }

    public static boolean removeAllFingerprintTemplates(Context r1, MultiSDKAdapter.RemovalCallback r2) {
        return removeAllFingerprintTemplates(r1, r2, UserHandle.myUserId());
    }

    public static boolean removeAllFingerprintTemplates(Context r9, MultiSDKAdapter.RemovalCallback r10, int r11) {
        FingerprintManager r0 = (FingerprintManager) r9.getSystemService("fingerprint");
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isHardwareDetected() == true) goto L7;
        return false;
    L7:
        if (r0.getEnrolledFingerprints().size() <= 0) goto L13;
        OLog.d(TAG, "removeAllFingerprintTemplates.....");
        onPasswordSetAsNone(r9);
        r0.remove(new Fingerprint(null, 0, 0, 0), r11, r10);
        return true;
    L13:
        return true;
    }

    public static void onPasswordSetAsNone(Context r4) {
        ContentResolver r0 = r4.getContentResolver();
        android.provider.Settings.Global.putInt(r0, "use_fingerprint_in_lockscreen", 0);
        android.provider.Settings.Global.putInt(r0, "use_fingerprint_in_launcher", 0);
        android.provider.Settings.Global.putInt(r0, "use_fingerprint_in_wallet", 0);
        FingerprintManager r5 = (FingerprintManager) r4.getSystemService("fingerprint");
        if (r5 != null) goto L5;
        return;
    L5:
        List r6 = r5.getEnrolledFingerprints();
        if (r6 == null) goto L11;
        Iterator r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L13;
        android.provider.Settings.Global.putString(r0, "quick_app_via_fingerprint_id_" + InvisibleApi.getFingerId((Fingerprint) r7.next()), null);
        goto L9
    L13:
        return;
    }

    private void showConfirmRemoveFingerprintDialog() {
        final int r0 = BDSettingsEvent.EVENT_TYPE_DELETE_PASSWORD.getType();
        SecurityEventMonitor.INSTANCE.start(this.mActivity, r0);
        this.mIsActionFinished = false;
        if (this.mConfirmRemoveFingerprintDialog != null) goto L6;
        this.mConfirmRemoveFingerprintDialog = (OAlertDialog) new OAlertDialogBuilder(this).horizontalButton().title(R.string.confirm_set_none_pwd_title).message(getSetNonePwdMessage()).positiveButton(R.string.close, new LockScreenModeActivity$$ExternalSyntheticLambda1(this, r0)).negativeButton(R.string.cancel, new LockScreenModeActivity$$ExternalSyntheticLambda2()).onDismiss(new LockScreenModeActivity$$ExternalSyntheticLambda3(this, r0)).cancelable(false).build();
    L6:
        if (this.mConfirmRemoveFingerprintDialog.isShowing() == true) goto L9;
        this.mConfirmRemoveFingerprintDialog.show();
        return;
    }

    /* JADX INFO: renamed from: lambda$showConfirmRemoveFingerprintDialog$2$com-android-settings-LockScreenModeActivity, reason: not valid java name */
    /* synthetic */ void m149xdf714055(int r2, DialogInterface r3, int r4) {
        removeFaceRecognitionIfExist();
        updateUnlockMethodAndFinish(0, false);
        android.provider.Settings.Global.putInt(getContentResolver(), "pickup_show_fp_icon", 0);
        android.provider.Settings.Global.putInt(getContentResolver(), "use_fingerprint_when_screenoff", 0);
        SecurityEventMonitor.INSTANCE.finish(this.mActivity, r2);
        this.mIsActionFinished = true;
    }

    static /* synthetic */ void lambda$showConfirmRemoveFingerprintDialog$3(DialogInterface r0, int r1) {
        r0.dismiss();
    }

    /* JADX INFO: renamed from: lambda$showConfirmRemoveFingerprintDialog$4$com-android-settings-LockScreenModeActivity, reason: not valid java name */
    /* synthetic */ void m150x14b2c557(int r1, DialogInterface r2) {
        if (this.mIsActionFinished == true) goto L6;
        SecurityEventMonitor.INSTANCE.cancel(this.mActivity, r1);
        return;
    }

    private String getSetNonePwdMessage() {
        boolean r0 = Utils.isFingerprintExists(this);
        if (this.mFaceRecognitionEnable == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r0 == true) goto L17;
        if (r1 == true) goto L17;
        if (this.mIsHasBankCardInWallet == true) goto L14;
        return null;
    L14:
        return getString(R.string.confirm_set_none_pwd_with_wallet_without_fingerprint_msg);
    L17:
        if (r0 == false) goto L20;
        if (r1 == false) goto L20;
        String r2 = getString(R.string.fingerprint_id_and_face_recognition);
    L24:
        if (this.mIsHasBankCardInWallet == false) goto L28;
        return getString(R.string.confirm_set_none_pwd_with_wallet_message, new Object[]{r2, r2});
    L28:
        return getString(R.string.confirm_set_none_pwd_message, new Object[]{r2, r2, r2});
    L20:
        if (r0 == false) goto L22;
        r2 = getString(R.string.fingerprint);
        goto L24
    L22:
        r2 = getString(R.string.face_recognition);
        goto L24
    L5:
        if (this.mFaceRecognitionHelper.isFaceRecognitionDataExist() == false) goto L7;
        r1 = true;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.android.settings.LockScreenModeActivity$8] */
    private void startQueryBankcardCount() {
        new AnonymousClass8(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    private boolean queryHasBankCardInWallet() {
        if (SettingsFeature.isWalletFeatureEnabled(this) == true) goto L5;
        return false;
    L5:
        Bundle r4 = Utils.getWalletData(this);
        if (r4 == null) goto L8;
        int r5 = r4.getInt("bank_card_count", 0);
        OLog.d(TAG, "bankCardCount = " + r5);
    L9:
        if (r5 <= 0) goto L12;
        return true;
    L12:
        return false;
    L8:
        r5 = 0;
        goto L9
    }

    public void com_android_settings_LockScreenModeActivity__finish$___twin___() {
        super.finish();
        TransitionAnimHelper.overrideExitAnim(this, TransitionAnimStyle.Standard);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_LockScreenModeActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(LockScreenModeActivity r1) {
        com_android_settings_LockScreenModeActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_LockScreenModeActivity_com_obric_hook_lancet_PrivacyHook_onCreate(LockScreenModeActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LockScreenModeActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_LockScreenModeActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_LockScreenModeActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(LockScreenModeActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_LockScreenModeActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_LockScreenModeActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(LockScreenModeActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_LockScreenModeActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        LockScreenModeActivity r5 = r4;
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
    public static void com_android_settings_LockScreenModeActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(LockScreenModeActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_LockScreenModeActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_LockScreenModeActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(LockScreenModeActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_LockScreenModeActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_LockScreenModeActivity_com_obric_hook_lancet_PrivacyHook_onResume(LockScreenModeActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LockScreenModeActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_LockScreenModeActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_LockScreenModeActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(LockScreenModeActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_LockScreenModeActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_LockScreenModeActivity_com_obric_hook_lancet_PrivacyHook_onPause(LockScreenModeActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LockScreenModeActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_LockScreenModeActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_LockScreenModeActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(LockScreenModeActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_LockScreenModeActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        LockScreenModeActivity r5 = r3;
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
    public static void com_android_settings_LockScreenModeActivity_com_obric_hook_lancet_PrivacyHook_onStop(LockScreenModeActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LockScreenModeActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_LockScreenModeActivity__onStop$___twin___();
    }

    @Insert("onDestroy")
    public static void com_android_settings_LockScreenModeActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(LockScreenModeActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LockScreenModeActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_LockScreenModeActivity__onDestroy$___twin___();
    }

    @Insert("finish")
    public static void com_android_settings_LockScreenModeActivity_com_obric_hook_lancet_PrivacyHook_finish(LockScreenModeActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LockScreenModeActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.superFinish();
        return;
    L6:
        r3.com_android_settings_LockScreenModeActivity__finish$___twin___();
    }
}
