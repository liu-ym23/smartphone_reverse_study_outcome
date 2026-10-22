package com.android.settings.fingerprint;

import android.app.admin.DevicePolicyManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.fingerprint.Fingerprint;
import android.hardware.fingerprint.FingerprintManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.UserHandle;
import android.provider.Settings;
import android.security.bytedance.guard.BDSettingsEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.android.internal.widget.LockPatternUtils;
import com.android.internal.widget.LockscreenCredential;
import com.android.internal.widget.VerifyCredentialResponse;
import com.android.settings.ChooseLockGeneric;
import com.android.settings.ChooseLockPassword;
import com.android.settings.ChooseLockPattern;
import com.android.settings.ChooseLockSettingsHelper;
import com.android.settings.FingerprintRenameDialogWrapper;
import com.android.settings.InvisibleApi;
import com.android.settings.PreferenceMgr;
import com.android.settings.PrivacySecurity;
import com.android.settings.QuickPaymentViaFingerprintFragment;
import com.android.settings.R;
import com.android.settings.SettingsFeature;
import com.android.settings.SettingsTracker;
import com.android.settings.ToastUtils;
import com.android.settings.Utils;
import com.android.settings.applications.utils.Item;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.applications.utils.OPopoverHelper;
import com.android.settings.autoaction.SecurityEventMonitor;
import com.android.settings.base.BaseFragment;
import com.android.settings.fingerprint.utils.FingerprintUtils;
import com.android.settings.settingitemsprovider.DatabaseHelper;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.UIUtils;
import com.android.settings.wifi.TrustedNetworkHelper;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.popover.v2.OPopoverHelperEx;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.text.OTextView;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.OMenuDialog2;
import obric.app.OMenuDialogListAdapter2;

/* JADX INFO: loaded from: classes2.dex */
public class FingerprintManageFragment extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    public static final String ARG_KEY_PASSWORD = "password";
    public static final String FINGER_TYPE = "finger_type";
    private static final int MY_USER_ID = 0;
    private static final int REQUEST_CODE_SETUP_LOCKSCREEN = 200;
    private LinearLayout mAIPoweredFpsContainer;
    private OSectionSupportiveText mAPFpsOSSupportiveText;
    private OSectionTitleBar mAPFpsOSTitleBar;
    private OCardListItem mAddAIPoweredFpsItem;
    private OCardListItem mAddUdfpsItem;
    private OAlertDialog mAlertDialog;
    private FingerprintAuthenticateHelper.Callback mAuthenticateHelperCallback;
    private long mChallenge;
    private OMenuDialog2 mChooseLockTypeDialog;
    private OAlertDialog mConfirmRemoveDialog;
    private DevicePolicyManager mDPM;
    private OCardListItem mFingerprintAnimationItem;
    private FingerprintAuthenticateHelper mFingerprintListenHelper;
    private FingerprintManager mFingerprintManager;
    private OPopover mFpsMoreOptionsPopover;
    private boolean mIsActionFinished;
    private LockPatternUtils mLockPatternUtils;
    public LockscreenCredential mPassword;
    private AsyncTask<?, ?, ?> mPendingLockCheck;
    private OAlertDialog mSetupLockscreenDialog;
    private OCardListItem mStartAppViaFPItem;
    private LinearLayout mUdfpsContainer;
    private OCardListItem mUdfpsDisplayPolicyItem;
    private OPopover mUdfpsDisplayPolicyPopMenu;
    private OCardListItem mUdfpsUnlockScreenEnableItem;
    private OCardListItem mUdfpsUnlockScreenTypeItem;
    private OPopover mUdfpsUnlockScreenTypePopover;
    private int udfpsCount;

    private boolean isFingerprintHighlightEnabled() {
        return false;
    }

    static /* synthetic */ void lambda$showConfirmRemoveDialog$0(DialogInterface r0, int r1) {
    }

    static /* synthetic */ void lambda$showSetupLockScreenDialog$9(DialogInterface r0, int r1) {
    }

    static /* synthetic */ void lambda$warningWillDisableTrustedAP$8(DialogInterface r0, int r1) {
    }

    public void com_android_settings_fingerprint_FingerprintManageFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_fingerprint_FingerprintManageFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_fingerprint_FingerprintManageFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public FingerprintManageFragment() {
        this.mChallenge = 0;
        this.udfpsCount = 0;
        this.mIsActionFinished = false;
    }

    static /* synthetic */ String access$000(FingerprintManageFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ void access$100(FingerprintManageFragment r0, int r1) {
        r0.updateFingerprintViewByFingerType(r1);
    }

    static /* synthetic */ void access$1000(FingerprintManageFragment r0, int r1, int r2, int r3) {
        r0.startChooseLockTypeActivity(r1, r2, r3);
    }

    static /* synthetic */ void access$1100(FingerprintManageFragment r0, int r1) {
        r0.highLightDetectedFingerprint(r1);
    }

    static /* synthetic */ String access$200(FingerprintManageFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ void access$300(FingerprintManageFragment r0, View r1, Fingerprint r2, int r3) {
        r0.showFpsMoreOptionMenu(r1, r2, r3);
    }

    static /* synthetic */ OAlertDialog access$402(FingerprintManageFragment r0, OAlertDialog r1) {
        r0.mAlertDialog = r1;
        return r1;
    }

    static /* synthetic */ void access$500(FingerprintManageFragment r0) {
        r0.addAIPoweredFingerprint();
    }

    static /* synthetic */ void access$600(FingerprintManageFragment r0) {
        r0.addUnderDisplayFingerprint();
    }

    static /* synthetic */ OAlertDialog access$702(FingerprintManageFragment r0, OAlertDialog r1) {
        r0.mSetupLockscreenDialog = r1;
        return r1;
    }

    static /* synthetic */ void access$800(FingerprintManageFragment r0, int r1) {
        r0.showChooseLockMenuDialog(r1);
    }

    static /* synthetic */ OMenuDialog2 access$902(FingerprintManageFragment r0, OMenuDialog2 r1) {
        r0.mChooseLockTypeDialog = r1;
        return r1;
    }

    static {
        MY_USER_ID = UserHandle.myUserId();
    }

    public static FingerprintManageFragment newInstance(LockscreenCredential r3) {
        FingerprintManageFragment r0 = new FingerprintManageFragment();
        if (r3 == null) goto L5;
        Bundle r1 = new Bundle();
        r1.putParcelable("password", r3);
        r0.setArguments(r1);
    L5:
        return r0;
    }

    public void com_android_settings_fingerprint_FingerprintManageFragment__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L5;
        this.mPassword = r3.getParcelable("password");
    L5:
        this.mDPM = (DevicePolicyManager) getSystemService("device_policy");
        this.mFingerprintManager = (FingerprintManager) getSystemService("fingerprint");
        this.mLockPatternUtils = new ChooseLockSettingsHelper(this._mActivity).utils();
        this.mFingerprintListenHelper = FingerprintAuthenticateHelper.getInstance(getApplicationContext());
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        dismissDialogIfNeed();
        OPopover r0 = this.mFpsMoreOptionsPopover;
        if (r0 == null) goto L5;
        r0.dismiss();
        this.mFpsMoreOptionsPopover = null;
    L5:
        OPopover r1 = this.mUdfpsUnlockScreenTypePopover;
        if (r1 == null) goto L9;
        r1.dismiss();
        this.mUdfpsUnlockScreenTypePopover = null;
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        int r0 = 0;
        this.mRootView = r2.inflate(R.layout.manage_fingerprint_fragment, r3, false);
        this.mTitleResId = Integer.valueOf(R.string.manage_fingerprint);
        this.mUdfpsContainer = (LinearLayout) findViewByIdNullable(R.id.udfps_container);
        OCardListItem r5 = (OCardListItem) findViewByIdNullable(R.id.add_udfps_item);
        this.mAddUdfpsItem = r5;
        r5.setOnContentClickListener(this);
        this.mUdfpsUnlockScreenEnableItem = (OCardListItem) findViewByIdNullable(R.id.udfps_unlock_screen_enable_item);
        OCardListItem r6 = (OCardListItem) findViewByIdNullable(R.id.udfps_unlock_screen_type_item);
        this.mUdfpsUnlockScreenTypeItem = r6;
        r6.setOnContentClickListener(this);
        this.mAPFpsOSTitleBar = (OSectionTitleBar) findViewByIdNullable(R.id.ai_powered_fingerprint_ostb_text);
        this.mAIPoweredFpsContainer = (LinearLayout) findViewByIdNullable(R.id.ai_powered_fps_container);
        OCardListItem r7 = (OCardListItem) findViewByIdNullable(R.id.add_ai_powered_fps_item);
        this.mAddAIPoweredFpsItem = r7;
        r7.setOnContentClickListener(this);
        OCardListItem r8 = (OCardListItem) findViewByIdNullable(R.id.fingerprint_udfps_display_policy);
        this.mUdfpsDisplayPolicyItem = r8;
        r8.setOnContentClickListener(this);
        this.mAPFpsOSSupportiveText = (OSectionSupportiveText) findViewByIdNullable(R.id.ai_powered_fps_tips);
        OCardListItem r9 = (OCardListItem) findViewByIdNullable(R.id.start_app_via_fp_item);
        this.mStartAppViaFPItem = r9;
        r9.setOnContentClickListener(this);
        OCardListItem r10 = (OCardListItem) findViewByIdNullable(R.id.fingerprint_animation_item);
        this.mFingerprintAnimationItem = r10;
        r10.setOnClickListener(this);
        View r11 = findViewByIdNullable(R.id.page_container);
        if (isFingerprintHardwareEnable() == true) goto L6;
        r0 = 8;
    L6:
        r11.setVisibility(r0);
        UIUtils.setUpBottomPaddingOnApplyWindowInsets((ViewGroup) findViewByIdNullable(R.id.page_container));
        return this.mRootView;
    }

    private boolean isFingerprintHardwareEnable() {
        FingerprintManager r0 = this.mFingerprintManager;
        if (r0 != null) goto L6;
        OLog.e(this.TAG, "isFingerprintHardwareEnable, FingerprintManager is null, return");
        return false;
    L6:
        boolean r1 = r0.isHardwareDetected();
        OLog.d(this.TAG, "isFingerprintHardwareEnable, enable: " + r1);
        return r1;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
        this.mUdfpsUnlockScreenEnableItem.getEndSwitch().setOnCheckedChangeListener(this);
    }

    public void updateViews() {
        updateAllFingerprintView();
        updateUdfpsDisplayPolicySummary();
        if (isFingerprintHighlightEnabled() == false) goto L6;
        this.mFingerprintListenHelper.startAuthenticate(getFingerprintAuthenticateHelperCallback(), true, true);
        return;
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (isFingerprintHighlightEnabled() == false) goto L5;
        this.mFingerprintListenHelper.stopAuthenticate();
    L5:
        AsyncTask<?, ?, ?> r0 = this.mPendingLockCheck;
        if (r0 == null) goto L8;
        r0.cancel(false);
        this.mPendingLockCheck = null;
    L8:
        dismissDialogIfNeed();
    }

    private void dismissDialogIfNeed() {
        OAlertDialog r0 = this.mAlertDialog;
        if (r0 == null) goto L12;
        r0.dismiss();     // Catch: IllegalArgumentException -> L6
    L8:
        this.mAlertDialog = null;
        return;
    L6:
        e = move-exception;
        OLog.w(this.TAG, "Exception dismissing dialog. Ex=" + e);
        goto L8
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r3, boolean r4) {
        if (r3 != this.mUdfpsUnlockScreenEnableItem.getEndSwitch()) goto L16;
        FingerprintUtils.updateUdfpsUnlockScreenEnabled(this.mContext, r4);
        OCardListItem r5 = this.mUdfpsUnlockScreenEnableItem;
        int r1 = 0;
        if (this.udfpsCount <= 0) goto L8;
        if (r4 == false) goto L8;
        int r0 = 1;
    L9:
        r5.setCardPosition(r0);
        OCardListItem r6 = this.mUdfpsUnlockScreenTypeItem;
        if (this.udfpsCount <= 0) goto L13;
        if (r4 == false) goto L13;
    L14:
        r6.setVisibility(r1);
        return;
    L13:
        r1 = 8;
    L8:
        r0 = 0;
        goto L9
    }

    private void removeFingerprint(Fingerprint r5, final int r6) {
        OLog.d(this.TAG, "try removeFingerprint: " + ("quick_app_via_fingerprint_id_" + InvisibleApi.getFingerId(r5)));
        this.mFingerprintManager.remove(r5, UserHandle.myUserId(), new AnonymousClass1(this, r6));
        List r7 = this.mFingerprintManager.getEnrolledFingerprints();
        if (r7 != null) goto L5;
    L6:
        Settings.Global.putInt(getContentResolver(), "pickup_show_fp_icon", 0);
        Settings.Global.putInt(getContentResolver(), "use_fingerprint_when_screenoff", 0);
        PrivacySecurity.getInstance(this.mContext).setFingerprintUnlock(false);
        return;
    L5:
        if (r7.isEmpty() == true) goto L6;
    }

    private void showConfirmRemoveDialog(final Fingerprint r5, final int r6) {
        OAlertDialog r0 = this.mConfirmRemoveDialog;
        if (r0 != null) goto L5;
    L7:
        final int r1 = BDSettingsEvent.EVENT_TYPE_DELETE_FINGERPRINT.getType();
        SecurityEventMonitor.INSTANCE.start(this._mActivity, r1);
        this.mIsActionFinished = false;
        OAlertDialog r7 = (OAlertDialog) new OAlertDialogBuilder(this._mActivity).horizontalButton(true).title(R.string.remove_fingerprint).message(R.string.remove_fingerprint_message).negativeButton(R.string.cancel, new FingerprintManageFragment$$ExternalSyntheticLambda4()).positiveButton(R.string.ok, new FingerprintManageFragment$$ExternalSyntheticLambda5(this, r5, r6, r1)).onDismiss(new FingerprintManageFragment$$ExternalSyntheticLambda6(this, r1)).build();
        this.mConfirmRemoveDialog = r7;
        r7.show();
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
    }

    /* JADX INFO: renamed from: lambda$showConfirmRemoveDialog$1$com-android-settings-fingerprint-FingerprintManageFragment, reason: not valid java name */
    /* synthetic */ void m467x578025d5(Fingerprint r1, int r2, int r3, DialogInterface r4, int r5) {
        removeFingerprint(r1, r2);
        SecurityEventMonitor.INSTANCE.finish(this._mActivity, r3);
        this.mIsActionFinished = true;
    }

    /* JADX INFO: renamed from: lambda$showConfirmRemoveDialog$2$com-android-settings-fingerprint-FingerprintManageFragment, reason: not valid java name */
    /* synthetic */ void m468x5d83f134(int r1, DialogInterface r2) {
        if (this.mIsActionFinished == true) goto L6;
        SecurityEventMonitor.INSTANCE.cancel(this._mActivity, r1);
        return;
    }

    private void updateFpsView(List<Fingerprint> r11, ViewGroup r12, OCardListItem r13, final int r14) {
        if (r12 == null) goto L34;
        if (r13 == null) goto L35;
        r12.removeAllViews();
        boolean r0 = false;
        if (r11 != null) goto L8;
        int r1 = 0;
    L9:
        int r2 = 0;
    L11:
        if (r2 >= r1) goto L23;
        final Fingerprint r4 = r11.get(r2);
        OLog.d(this.TAG, "updateFpsView " + ("quick_app_via_fingerprint_id_" + InvisibleApi.getFingerId(r4)));
        View r5 = View.inflate(this._mActivity, R.layout.settings_oui_card_list_item, null);
        OCardListItem r6 = (OCardListItem) r5.findViewById(R.id.card_list_item);
        OCardListItemUtils.initCardItemInAdapter(r6, r1, r2);
        if (r1 > 1) goto L15;
    L17:
        if (r1 != 1) goto L19;
        r6.setCardPosition(1);
    L19:
        r6.setTag(Integer.valueOf(InvisibleApi.getFingerId(r4)));
        OCardListItemUtils.setTitle(r6, r4.getName().toString());
        r6.showTailIcon(false);
        ImageView r3 = new ImageView(this._mActivity);
        r3.setImageResource(R.drawable.settings_oic_ellipsis_3);
        FrameLayout.LayoutParams r7 = (FrameLayout.LayoutParams) r3.getLayoutParams();
        if (r7 != null) goto L22;
        r7 = new FrameLayout.LayoutParams(-2, -2);
    L22:
        int r8 = getResources().getDimensionPixelSize(R.dimen.dimen_7);
        r7.setMargins(r8, r8, r8, r8);
        r3.setLayoutParams(r7);
        r6.setCustomEndView(r3);
        r3.setOnClickListener(new AnonymousClass2(this, r4, r14));
        r12.addView(r5);
        r2 = r2 + 1;
        goto L11
    L15:
        if (r2 != (r1 - 1)) goto L17;
        r6.setCardPosition(2);
        goto L19
    L23:
        if (r1 != 0) goto L25;
        r13.setCardPosition(0);
    L27:
        if (r1 >= FingerprintHelper.getMaxFingerprintPerUser(getResources())) goto L29;
        r0 = true;
    L29:
        r13.setEnabled(r0);
        return;
    L25:
        r13.setCardPosition(3);
        goto L27
    L8:
        r1 = r11.size();
        goto L9
    L35:
        return;
    }

    private void showFpsMoreOptionMenu(View r5, final Fingerprint r6, final int r7) {
        OPopoverEntranceMenuView.Builder r0 = new OPopoverEntranceMenuView.Builder(this._mActivity);
        OPopoverHelper.addPopoverItem(r0, R.drawable.settings_oic_pen_with_horizontal_line, getString(R.string.option_edit_name), new FingerprintManageFragment$$ExternalSyntheticLambda7(this, r6, r7));
        r0.addHighlightPopoverItem(Integer.valueOf(R.drawable.settings_oic_trashcan), getString(R.string.option_remove_fingerprint), new FingerprintManageFragment$$ExternalSyntheticLambda8(this, r6, r7));
        this.mFpsMoreOptionsPopover = new OPopover.Builder(this._mActivity).setView(r0.build()).build();
        OPopoverHelperEx.INSTANCE.showPopoverSmartly(this.mFpsMoreOptionsPopover, r5, 83);
    }

    /* JADX INFO: renamed from: lambda$showFpsMoreOptionMenu$4$com-android-settings-fingerprint-FingerprintManageFragment, reason: not valid java name */
    /* synthetic */ Unit m470xf3d4440c(Fingerprint r1, final int r2, View r3, Integer r4) {
        new FingerprintRenameDialogWrapper(this, r1).setPostCallback(new FingerprintManageFragment$$ExternalSyntheticLambda9(this, r2)).show();
        OPopover r0 = this.mFpsMoreOptionsPopover;
        if (r0 == null) goto L6;
        r0.dismiss();
    L6:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$showFpsMoreOptionMenu$3$com-android-settings-fingerprint-FingerprintManageFragment, reason: not valid java name */
    /* synthetic */ void m469xedd078ad(int r1) {
        updateFingerprintViewByFingerType(r1);
    }

    /* JADX INFO: renamed from: lambda$showFpsMoreOptionMenu$5$com-android-settings-fingerprint-FingerprintManageFragment, reason: not valid java name */
    /* synthetic */ Unit m471xf9d80f6b(Fingerprint r1, int r2, View r3, Integer r4) {
        showConfirmRemoveDialog(r1, r2);
        OPopover r0 = this.mFpsMoreOptionsPopover;
        if (r0 == null) goto L6;
        r0.dismiss();
    L6:
        return Unit.INSTANCE;
    }

    private void updateAllFingerprintView() {
        updateFingerprintViewByFingerType(2);
        updateFingerprintViewByFingerType(4);
    }

    private void updateFingerprintViewByFingerType(int r6) {
        OLog.d(this.TAG, "updateFingerprintViewByFingerType " + r6);
        boolean r0 = true;
        if (r6 != 2) goto L27;
        List<Fingerprint> r7 = FingerprintUtils.getFingerprintList(this.mFingerprintManager, 2);
        updateFpsView(r7, this.mUdfpsContainer, this.mAddUdfpsItem, 2);
        if (r7 != null) goto L7;
        int r8 = 0;
    L8:
        this.udfpsCount = r8;
        boolean r9 = FingerprintUtils.isUdfpsUnlockScreenEnabled(this.mContext);
        this.mUdfpsUnlockScreenEnableItem.getEndSwitch().setChecked(r9);
        OCardListItem r2 = this.mUdfpsUnlockScreenEnableItem;
        int r4 = 8;
        if (this.udfpsCount <= 0) goto L11;
        int r3 = 0;
    L12:
        r2.setVisibility(r3);
        OCardListItem r5 = this.mUdfpsUnlockScreenEnableItem;
        if (this.udfpsCount <= 0) goto L16;
        if (r9 == false) goto L16;
        int r10 = 1;
    L17:
        r5.setCardPosition(r10);
        OTextView r11 = this.mUdfpsUnlockScreenTypeItem.getEndDetail();
        if (FingerprintUtils.getUdfpsUnlockScreenType(this.mContext) != 0) goto L20;
        int r12 = R.string.udfps_unlock_screen_type_enter_to_home_screen;
    L21:
        r11.setText(r12);
        OCardListItem r13 = this.mUdfpsUnlockScreenTypeItem;
        if (this.udfpsCount <= 0) goto L25;
        if (r9 == false) goto L25;
        r4 = 0;
    L25:
        r13.setVisibility(r4);
    L30:
        if (isLockScreenDisabled() == false) goto L32;
    L34:
        boolean r14 = false;
    L35:
        DatabaseHelper r15 = DatabaseHelper.getInstance(this.mContext);
        if (this.mIsExtDisplaying == true) goto L39;
        if (r14 == false) goto L39;
    L40:
        r15.updateFingerprintItems(r0);
        return;
    L39:
        r0 = false;
        goto L40
    L32:
        if (Utils.isFingerprintExists(this.mContext) == false) goto L34;
        r14 = true;
        goto L35
    L20:
        r12 = R.string.udfps_unlock_screen_type_remain_on_the_lock_screen;
    L16:
        r10 = 0;
        goto L17
    L11:
        r3 = 8;
        goto L12
    L7:
        r8 = r7.size();
        goto L8
    L27:
        if (r6 != 4) goto L30;
        updateFpsView(FingerprintUtils.getFingerprintList(this.mFingerprintManager, 4), this.mAIPoweredFpsContainer, this.mAddAIPoweredFpsItem, 4);
        goto L30
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

    private void showUdfpsDisplayPolicyPopMenu() {
        if (this.mUdfpsDisplayPolicyItem != null) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList();
        int r1 = FingerprintUtils.getUdfpsPolicy(this.mContext);
        String r3 = getString(R.string.obric_udfps_display_policy_off);
        boolean r4 = false;
        if (r1 != 0) goto L8;
        boolean r6 = true;
    L9:
        r0.add(new Item(r3, r6));
        String r5 = getString(R.string.obric_udfps_display_policy_tap_lift);
        if (r1 != 1) goto L12;
        boolean r7 = true;
    L13:
        r0.add(new Item(r5, r7));
        String r8 = getString(R.string.obric_udfps_display_policy_follow_aod);
        if (r1 != 2) goto L16;
        r4 = true;
    L16:
        r0.add(new Item(r8, r4));
        this.mUdfpsDisplayPolicyPopMenu = OPopoverHelper.showPopoverList(this._mActivity, this.mUdfpsDisplayPolicyItem, r0, new FingerprintManageFragment$$ExternalSyntheticLambda3(this), true);
        return;
    L12:
        r7 = false;
        goto L13
    L8:
        r6 = false;
        goto L9
    }

    /* JADX INFO: renamed from: lambda$showUdfpsDisplayPolicyPopMenu$6$com-android-settings-fingerprint-FingerprintManageFragment, reason: not valid java name */
    /* synthetic */ void m472xd59ede06(View r2, int r3) {
        if (r3 == 0) goto L9;
        int r4 = 1;
        if (r3 != 1) goto L6;
    L10:
        Settings.Secure.putInt(getContentResolver(), FingerprintUtils.KEY_OBRIC_UDFPS_ICON_VISIBILITY_POLICY, r4);
        updateUdfpsDisplayPolicySummary();
        OPopover r5 = this.mUdfpsDisplayPolicyPopMenu;
        if (r5 == null) goto L14;
        r5.dismiss();
        this.mUdfpsDisplayPolicyPopMenu = null;
        return;
    L14:
        return;
    L6:
        if (r3 != 2) goto L10;
        r4 = 2;
        goto L10
    L9:
        r4 = 0;
        goto L10
    }

    private void updateUdfpsDisplayPolicySummary() {
        if (this.mUdfpsDisplayPolicyItem != null) goto L5;
        return;
    L5:
        String r0 = FingerprintUtils.getUdfpsPolicySummary(this.mContext);
        OCardListItemUtils.setCustomEndTipTextView(this.mUdfpsDisplayPolicyItem, r0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2 != this.mAddUdfpsItem.getContentContainer()) goto L9;
        SettingsTracker.onItemClick(EntityType.EVENT_TASK);
        if (needWarningWillDisableTrustedAP() == false) goto L7;
        warningWillDisableTrustedAP(2);
        return;
    L7:
        addUnderDisplayFingerprint();
        return;
    L9:
        if (r2 != this.mUdfpsUnlockScreenTypeItem.getContentContainer()) goto L12;
        showUdfpsUnlockScreenTypePopMenu();
        return;
    L12:
        if (r2 != this.mAddAIPoweredFpsItem.getContentContainer()) goto L18;
        if (needWarningWillDisableTrustedAP() == false) goto L16;
        warningWillDisableTrustedAP(4);
        return;
    L16:
        addAIPoweredFingerprint();
        return;
    L18:
        if (r2 != this.mUdfpsDisplayPolicyItem.getContentContainer()) goto L21;
        showUdfpsDisplayPolicyPopMenu();
        return;
    L21:
        if (r2 != this.mStartAppViaFPItem) goto L24;
        SettingsTracker.onItemClick(1602);
        start(QuickPaymentViaFingerprintFragment.class);
        return;
    L24:
        if (r2 != this.mFingerprintAnimationItem.getContentContainer()) goto L34;
        start(FingerprintAnimationFragment.class);
        return;
    }

    private void showUdfpsUnlockScreenTypePopMenu() {
        ArrayList r0 = new ArrayList();
        int r1 = FingerprintUtils.getUdfpsUnlockScreenType(this.mContext);
        String r3 = getString(R.string.udfps_unlock_screen_type_remain_on_the_lock_screen);
        boolean r4 = false;
        if (r1 != 1) goto L5;
        boolean r6 = true;
    L6:
        r0.add(new Item(r3, r6));
        String r5 = getString(R.string.udfps_unlock_screen_type_enter_to_home_screen);
        if (r1 != 0) goto L9;
        r4 = true;
    L9:
        r0.add(new Item(r5, r4));
        this.mUdfpsUnlockScreenTypePopover = OPopoverHelper.showPopoverList(this._mActivity, this.mUdfpsUnlockScreenTypeItem, r0, new FingerprintManageFragment$$ExternalSyntheticLambda0(this), true);
        return;
    L5:
        r6 = false;
        goto L6
    }

    /* JADX INFO: renamed from: lambda$showUdfpsUnlockScreenTypePopMenu$7$com-android-settings-fingerprint-FingerprintManageFragment, reason: not valid java name */
    /* synthetic */ void m473x2b123efb(View r3, int r4) {
        if (r4 != 0) goto L5;
        FingerprintUtils.updateUdfpsUnlockScreenType(this.mContext, 1);
    L6:
        OTextView r0 = this.mUdfpsUnlockScreenTypeItem.getEndDetail();
        if (r4 != 1) goto L9;
        int r5 = R.string.udfps_unlock_screen_type_enter_to_home_screen;
    L10:
        r0.setText(r5);
        OPopover r6 = this.mUdfpsUnlockScreenTypePopover;
        if (r6 == null) goto L14;
        r6.dismiss();
        this.mUdfpsUnlockScreenTypePopover = null;
        return;
    L14:
        return;
    L9:
        r5 = R.string.udfps_unlock_screen_type_remain_on_the_lock_screen;
        goto L10
    L5:
        FingerprintUtils.updateUdfpsUnlockScreenType(this.mContext, 0);
        goto L6
    }

    private boolean needWarningWillDisableTrustedAP() {
        if (SettingsFeature.isFaceRecognitionEnable() == false) goto L16;
        if (hasTrustedAP() == false) goto L14;
        if (this.mLockPatternUtils.isSecure(MY_USER_ID) == false) goto L14;
        if (Utils.isFingerprintExists(this.mContext) == true) goto L14;
        if (hasFaceRecognitionData() == true) goto L14;
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

    private boolean hasTrustedAP() {
        return Utils.hasTrustedAP(this.mContext);
    }

    private boolean hasFaceRecognitionData() {
        return PreferenceMgr.getInstance(this.mContext).getBoolean(PreferenceMgr.KEY_FACE_RECOGNITION_DATA_EXIST, false);
    }

    private void warningWillDisableTrustedAP(final int r4) {
        OAlertDialog r0 = this.mAlertDialog;
        if (r0 != null) goto L5;
    L7:
        OAlertDialog r5 = (OAlertDialog) new OAlertDialogBuilder(this._mActivity).horizontalButton().title(R.string.dialog_title_alert).message(getDisableTrustedAPMessage()).negativeButton(R.string.cancel, new FingerprintManageFragment$$ExternalSyntheticLambda1()).positiveButton(R.string.continue_fingerprint_input, new AnonymousClass4(this, r4)).onDismiss(new AnonymousClass3(this)).build();
        this.mAlertDialog = r5;
        r5.show();
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
    }

    private String getDisableTrustedAPMessage() {
        String r0 = getString(R.string.fingerprint);
        if (SettingsFeature.isFaceRecognitionEnable() == false) goto L5;
        String r1 = getString(R.string.fingerprint_id_and_face_recognition);
    L7:
        return getString(R.string.trusted_network_feature_disable_notification, new Object[]{r0, r1});
    L5:
        r1 = r0;
        goto L7
    }

    private void addUnderDisplayFingerprint() {
        if (isSecure() == false) goto L5;
        startEnrollingActivity(null, false, 2);
        return;
    L5:
        showSetupLockScreenDialog(2);
    }

    private void startEnrollingActivity(VerifyCredentialResponse r9, boolean r10, int r11) {
        Intent r12 = BaseFingerprintEnrollingActivity.launchFingerprintEnrollingActivity(this._mActivity, r11);
        if (r9 == null) goto L12;
        byte[] r1 = r9.getGatekeeperHAT();
        if (r1 != null) goto L7;
        r1 = BaseFingerprintEnrollingActivity.requestGatekeeperHat(this.mContext, r9.getGatekeeperPasswordHandle(), MY_USER_ID, this.mChallenge);
    L7:
        r12.putExtra("hw_auth_token", r1);
        String r13 = this.TAG;
        StringBuilder r2 = new StringBuilder("startUdfpsEnrollingActivity EXTRA_KEY_CHALLENGE_TOKEN: ba==null ");
        if (r1 != null) goto L10;
        boolean r3 = true;
    L11:
        OLog.i(r13, r2.append(r3).toString());
    L13:
        if (r10 == false) goto L15;
        r12.putExtra("back_text_id", R.string.short_cancel);
    L15:
        OLog.e(this.TAG, "startUdfpsEnrollingActivity mPassword=" + this.mPassword);
        LockscreenCredential r14 = this.mPassword;
        if (r14 == null) goto L18;
        r12.putExtra("password", r14);
        r12.putExtra("password_confirmed", true);
    L18:
        r12.putExtra(BaseFingerprintEnrollingActivity.EXTRA_FROM_FP_MANAGER, true);
        Utils.startActivity(this._mActivity, r12, 2);
        return;
    L10:
        r3 = false;
        goto L11
    L12:
        OLog.i(this.TAG, "startUdfpsEnrollingActivity EXTRA_KEY_CHALLENGE_TOKEN: token is null");
        goto L13
    }

    private void addAIPoweredFingerprint() {
        if (isSecure() == false) goto L5;
        startEnrollingActivity(null, false, 4);
        return;
    L5:
        showSetupLockScreenDialog(4);
    }

    private void showSetupLockScreenDialog(final int r3) {
        OAlertDialog r0 = this.mSetupLockscreenDialog;
        if (r0 != null) goto L5;
    L7:
        OAlertDialog r4 = (OAlertDialog) new OAlertDialogBuilder(this._mActivity).horizontalButton().title(R.string.setup_lockscreen_title).message(R.string.setup_lockscreen_message).positiveButton(R.string.setup_lockscreen_ok_button, new AnonymousClass6(this, r3)).negativeButton(R.string.cancel, new FingerprintManageFragment$$ExternalSyntheticLambda2()).onDismiss(new AnonymousClass5(this)).cancelable(false).build();
        this.mSetupLockscreenDialog = r4;
        r4.show();
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
    }

    private void showChooseLockMenuDialog(int r5) {
        OMenuDialog2 r0 = this.mChooseLockTypeDialog;
        if (r0 != null) goto L5;
    L7:
        OMenuDialog2 r1 = new OMenuDialog2(this._mActivity);
        this.mChooseLockTypeDialog = r1;
        r1.setTitle(R.string.choose_lock_type_title);
        ArrayList r2 = new ArrayList();
        r2.add(getString(R.string.lockscreen_mode_item_title_pattern));
        r2.add(getString(R.string.lockscreen_mode_pin_four));
        r2.add(getString(R.string.lockscreen_mode_pin_six));
        r2.add(getString(R.string.lockscreen_mode_item_title_hard));
        ArrayList r3 = new ArrayList();
        r3.add(getLockTypeSelectionOnclickListener(65536, r5));
        r3.add(getLockTypeSelectionOnclickListener(131072, 4, r5));
        r3.add(getLockTypeSelectionOnclickListener(131072, 6, r5));
        r3.add(getLockTypeSelectionOnclickListener(262144, r5));
        OMenuDialogListAdapter2 r6 = new OMenuDialogListAdapter2(this._mActivity, r2, r3);
        this.mChooseLockTypeDialog.setAdapter(r6);
        this.mChooseLockTypeDialog.setOnDismissListener(new AnonymousClass7(this));
        this.mChooseLockTypeDialog.show();
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
    }

    private View.OnClickListener getLockTypeSelectionOnclickListener(int r2, int r3) {
        return getLockTypeSelectionOnclickListener(r2, 4, r3);
    }

    private View.OnClickListener getLockTypeSelectionOnclickListener(final int r2, final int r3, final int r4) {
        return new AnonymousClass8(this, r2, r3, r4);
    }

    private void startChooseLockTypeActivity(int r4, int r5, int r6) {
        Intent r0 = new Intent();
        if (r4 < 131072) goto L6;
        r0 = new Intent(this._mActivity, ChooseLockPassword.class);
        r0.putExtra("lockscreen.password_type", r4);
        r0.putExtra(ChooseLockPassword.PASSWORD_MIN_KEY, 4);
        r0.putExtra(ChooseLockPassword.EXTRA_PIN_LENGTH, r5);
    L8:
        OLog.i(this.TAG, "startChooseLockTypeActivity challenge 0");
        r0.putExtra("challenge", 0);
        r0.putExtra(ChooseLockSettingsHelper.EXTRA_KEY_HAS_CHALLENGE, true);
        r0.putExtra("for_fingerprint", true);
        r0.putExtra(ChooseLockGeneric.CONFIRM_CREDENTIALS, false);
        r0.putExtra(TrustedNetworkHelper.EXTRA_REQUEST_RESULT, true);
        r0.putExtra(FINGER_TYPE, r6);
        Utils.startActivity(this, r0, 2, 200);
        return;
    L6:
        if (r4 != 65536) goto L8;
        r0 = new Intent(this._mActivity, ChooseLockPattern.class);
        r0.putExtra("pattern_size", 3);
        r0.putExtra("key_lock_method", "pattern");
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        if (r3 != RESULT_CANCELED) goto L6;
        return;
    L6:
        if (r2 == 200) goto L9;
        return;
    L9:
        if (isSecure() == false) goto L16;
        ToastUtils.show(this._mActivity, R.string.lock_pwd_setup_success);
        if (r4 == null) goto L13;
        VerifyCredentialResponse r5 = (VerifyCredentialResponse) r4.getParcelableExtra("hw_auth_token");
    L14:
        startEnrollingActivity(r5, true, r4.getIntExtra(FINGER_TYPE, -1));
        return;
    L13:
        r5 = null;
        goto L14
    }

    private boolean isSecure() {
        return this.mLockPatternUtils.isSecure(UserHandle.myUserId());
    }

    private FingerprintAuthenticateHelper.Callback getFingerprintAuthenticateHelperCallback() {
        if (this.mAuthenticateHelperCallback != null) goto L6;
        this.mAuthenticateHelperCallback = new AnonymousClass9(this);
    L6:
        return this.mAuthenticateHelperCallback;
    }

    private void highLightDetectedFingerprint(int r7) {
        int r0 = this.mUdfpsContainer.getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        View r3 = this.mUdfpsContainer.getChildAt(r2);
        if (r3 == null) goto L6;
        if (r7 != ((Integer) r3.getTag()).intValue()) goto L10;
        OLog.d("Fingerprint", "onFingerprintDetected " + r2);
        r3.setPressed(true);
    L11:
        r2 = r2 + 1;
        goto L3
    L10:
        r3.setPressed(false);
        goto L11
    L6:
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_fingerprint_FingerprintManageFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(FingerprintManageFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_fingerprint_FingerprintManageFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fingerprint_FingerprintManageFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(FingerprintManageFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_fingerprint_FingerprintManageFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fingerprint_FingerprintManageFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(FingerprintManageFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_fingerprint_FingerprintManageFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
