package com.android.settings.intelligent;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.UserHandle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.android.internal.widget.LockPatternUtils;
import com.android.settings.ChooseLockGeneric;
import com.android.settings.ChooseLockPassword;
import com.android.settings.ChooseLockPattern;
import com.android.settings.ChooseLockSettingsHelper;
import com.android.settings.R;
import com.android.settings.Settings;
import com.android.settings.SettingsFeature;
import com.android.settings.Utils;
import com.android.settings.applications.utils.Item;
import com.android.settings.applications.utils.ODialogUtils;
import com.android.settings.applications.utils.OPopoverHelper;
import com.android.settings.base.BaseFragment;
import com.android.settings.biometrics.FaceRecognitionHelper;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.teaevent.TrackerEvent;
import com.android.settings.utils.UIUtils;
import com.android.settings.wifi.TrustedNetworkHelper;
import com.obric.olog.OLog;
import com.obric.oui.banner.BannerData;
import com.obric.oui.banner.BannerViewHolder;
import com.obric.oui.banner.IBannerViewHolderFactory;
import com.obric.oui.banner.OBanner;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.dialog.v2.action.OActionDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.indicator.OCarouselIndicator;
import com.obric.oui.layout.OUIConstraintLayout;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class AssistantActivationFragment extends BaseFragment {
    public static final String AI_KEY_SENSITIVITY_KEY = "ai_key_sensitivity";
    private static final Long BANNER_DELAY_TIME = null;
    public static final String CLICK_LEFT_KEY_OPEN_DOUBAO = "click_left_key_open_doubao";
    public static final String DOUBAO_SCREEN_OFF_AI_KEY_WAKE = "enable_ai_key_when_screen_off";
    public static final String DOUBLE_CLICK_KEY = "double_click_key";
    public static final String SINGLE_CLICK_KEY = "single_click_key";
    private OUILinearLayout bannerLayout;
    private OCardListItem mAiKeySensitivity;
    private OPopover mAiKeySensitivityPopover;
    private OCardListItem mAiKeyWhenScreenOff;
    private OAlertDialog mAlertDialog;
    private OBanner mBanner;
    private OCarouselIndicator mCarouselIndicator;
    private OActionDialog mChooseLockTypeDialog;
    private OTextView mDoubleClickDesc;
    private OPopover mDoubleClickPopover;
    private FaceRecognitionHelper mFaceRecognitionHelper;
    private boolean mIsFirstVisible;
    private OCardListItem mItemDoubleClick;
    private OCardListItem mItemFingerprint;
    private OCardListItem mItemSingleClick;
    private LockPatternUtils mLockPatternUtils;
    private OAlertDialog mSetupLockscreenDialog;
    private OTextView mSingleClickDesc;
    private OPopover mSingleClickPopover;

    private static class CustomBannerData implements BannerData {
        int imgResId;
        int position;
        String subTitle;
        String title;

        @Override // com.obric.oui.banner.BannerData
        public String getHolderKey() {
            return "custom_banner";
        }

        CustomBannerData(int r1, String r2, String r3, int r4) {
            this.imgResId = r1;
            this.title = r2;
            this.subTitle = r3;
            this.position = r4;
        }
    }

    private static class CustomBannerViewHolder extends BannerViewHolder {
        private final View mViewPager;

        public CustomBannerViewHolder(View r1) {
            super(r1);
            this.mViewPager = r1;
        }

        @Override // com.obric.oui.banner.BannerViewHolder
        public void onBind(BannerData r3) {
            CustomBannerData r4 = (CustomBannerData) r3;
            ((OUIConstraintLayout) this.mViewPager.findViewById(R.id.custom_banner_item_root_view)).setChangeAlphaWhenPress(false);
            ((ImageView) this.mViewPager.findViewById(R.id.view_pager_iv)).setImageResource(r4.imgResId);
            ((OTextView) this.mViewPager.findViewById(R.id.view_pager_title)).setText(r4.title);
            ((OTextView) this.mViewPager.findViewById(R.id.view_pager_sub_title)).setText(r4.subTitle);
        }

        @Override // com.obric.oui.banner.BannerViewHolder
        public void onSelect() {
            super.onSelect();
            delayPlayDone(5000);
        }
    }

    private static class CustomBannerViewHolderFactory implements IBannerViewHolderFactory {
        @Override // com.obric.oui.banner.IBannerViewHolderFactory
        public String getKey() {
            return "custom_banner";
        }

        private CustomBannerViewHolderFactory() {
        }

        /* synthetic */ CustomBannerViewHolderFactory(AnonymousClass1 r1) {
            this();
        }

        @Override // com.obric.oui.banner.IBannerViewHolderFactory
        public BannerViewHolder newInstance(ViewGroup r3) {
            return new CustomBannerViewHolder(LayoutInflater.from(r3.getContext()).inflate(R.layout.assistant_activation_banner_item_layout, r3, false));
        }
    }

    static /* synthetic */ void lambda$showSetupLockscreenDialog$3(DialogInterface r0, int r1) {
    }

    static /* synthetic */ void lambda$warningWillDisableTrustedAP$2(DialogInterface r0, int r1) {
    }

    public void com_android_settings_intelligent_AssistantActivationFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_intelligent_AssistantActivationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_intelligent_AssistantActivationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public AssistantActivationFragment() {
        this.mIsFirstVisible = true;
    }

    static /* synthetic */ void access$000(AssistantActivationFragment r0, View r1) {
        r0.showSingleClickPopover(r1);
    }

    static /* synthetic */ void access$100(AssistantActivationFragment r0, View r1) {
        r0.showDoubleClickPopover(r1);
    }

    static /* synthetic */ void access$1000(AssistantActivationFragment r0) {
        r0.initSingleClickView();
    }

    static /* synthetic */ OPopover access$1100(AssistantActivationFragment r0) {
        return r0.mSingleClickPopover;
    }

    static /* synthetic */ void access$1200(AssistantActivationFragment r0, int r1) {
        r0.setDoubleClick(r1);
    }

    static /* synthetic */ void access$1300(AssistantActivationFragment r0) {
        r0.initDoubleClickView();
    }

    static /* synthetic */ OPopover access$1400(AssistantActivationFragment r0) {
        return r0.mDoubleClickPopover;
    }

    static /* synthetic */ void access$200(AssistantActivationFragment r0, boolean r1) {
        r0.setScreenOffAiKeyWake(r1);
    }

    static /* synthetic */ OAlertDialog access$302(AssistantActivationFragment r0, OAlertDialog r1) {
        r0.mAlertDialog = r1;
        return r1;
    }

    static /* synthetic */ void access$400(AssistantActivationFragment r0) {
        r0.routeToFingerprintManagerActivity();
    }

    static /* synthetic */ OAlertDialog access$502(AssistantActivationFragment r0, OAlertDialog r1) {
        r0.mSetupLockscreenDialog = r1;
        return r1;
    }

    static /* synthetic */ void access$600(AssistantActivationFragment r0) {
        r0.showChooseLockMenuDialog();
    }

    static /* synthetic */ OActionDialog access$700(AssistantActivationFragment r0) {
        return r0.mChooseLockTypeDialog;
    }

    static /* synthetic */ void access$800(AssistantActivationFragment r0, int r1, int r2) {
        r0.startChooseLockTypeActivity(r1, r2);
    }

    static /* synthetic */ void access$900(AssistantActivationFragment r0, int r1) {
        r0.setSingleClick(r1);
    }

    static {
        BANNER_DELAY_TIME = 500L;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.assistant_activation_layout, r3, false);
        ((FrameLayout) this.mRootView.findViewById(R.id.frame_layout)).addView(UIUtils.buildNoScaledView(this._mActivity, R.layout.view_banner_ai_fingerprint));
        OFloatingTitleBar r5 = (OFloatingTitleBar) this.mRootView.findViewById(R.id.view_title);
        OBanner r6 = (OBanner) this.mRootView.findViewById(R.id.banner);
        this.mBanner = r6;
        updateBannerProportion(r6);
        OCarouselIndicator r7 = (OCarouselIndicator) this.mRootView.findViewById(R.id.view_pager_indicator);
        this.mCarouselIndicator = r7;
        bindViewPager(this.mBanner, r7);
        this.bannerLayout = (OUILinearLayout) this.mRootView.findViewById(R.id.bannerLayout);
        this.mLockPatternUtils = new ChooseLockSettingsHelper(this._mActivity).utils();
        this.mFaceRecognitionHelper = new FaceRecognitionHelper(this._mActivity);
        OCardListItem r8 = (OCardListItem) this.mRootView.findViewById(R.id.item_fingerprint);
        this.mItemFingerprint = r8;
        r8.setOnContentClickListener(new AssistantActivationFragment$$ExternalSyntheticLambda2(this));
        View r9 = this.mRootView.findViewById(R.id.item_fingerprint_padding);
        if (SettingsFeature.isSupportAIButtonKeyFingerprint() == false) goto L5;
        this.mItemFingerprint.setVisibility(0);
        r9.setVisibility(0);
    L6:
        OCardListItem r10 = (OCardListItem) this.mRootView.findViewById(R.id.item_single_click);
        this.mItemSingleClick = r10;
        r10.setDefaultCustomEndView(3);
        this.mItemSingleClick.showCustomEnd(true);
        this.mSingleClickDesc = this.mItemSingleClick.getEndDetail();
        this.mItemSingleClick.setOnContentClickListener(new AnonymousClass1(this));
        initSingleClickView();
        OCardListItem r11 = (OCardListItem) this.mRootView.findViewById(R.id.item_double_click);
        this.mItemDoubleClick = r11;
        r11.setDefaultCustomEndView(3);
        this.mItemDoubleClick.showCustomEnd(true);
        this.mDoubleClickDesc = this.mItemDoubleClick.getEndDetail();
        this.mItemDoubleClick.setOnContentClickListener(new AnonymousClass2(this));
        initDoubleClickView();
        this.mAiKeyWhenScreenOff = (OCardListItem) this.mRootView.findViewById(R.id.ai_key_when_screen_off);
        OCardListItem r12 = (OCardListItem) this.mRootView.findViewById(R.id.item_ai_key_sensitivity);
        this.mAiKeySensitivity = r12;
        r12.setOnContentClickListener(new AssistantActivationFragment$$ExternalSyntheticLambda3(this));
        initAiKeySensitivityView();
        return this.mRootView;
    L5:
        this.mItemFingerprint.setVisibility(8);
        r9.setVisibility(8);
        goto L6
    }

    /* JADX INFO: renamed from: lambda$onCreateView$0$com-android-settings-intelligent-AssistantActivationFragment, reason: not valid java name */
    /* synthetic */ void m495xdbd7a409(View r1) {
        processWhenClickItemFingerprint();
    }

    /* JADX INFO: renamed from: lambda$onCreateView$1$com-android-settings-intelligent-AssistantActivationFragment, reason: not valid java name */
    /* synthetic */ void m496x701613a8(View r1) {
        showAiKeySensitivityPopover(r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r2) {
        super.onViewStateRestored(r2);
        OSwitch r3 = (OSwitch) this.mAiKeyWhenScreenOff.getCustomEndView();
        r3.setOnCheckedChangeListener(new AnonymousClass3(this));
        r3.setChecked(isScreenOffAiKeyWake());
    }

    private void updateBannerProportion(OBanner r5) {
        int r0 = OUnitExtensionKt.getScreenWidth(this._mActivity);
        if (r0 <= 0) goto L6;
        float r1 = r0 - (UIUtils.INSTANCE.dp2px(12) * 2);
        float r2 = (r1 * 1.0f) / (((int) (0.7619048f * r1)) + UIUtils.INSTANCE.dp2px(62));
        OLog.i(this.TAG, "updateBannerProportion, proportion: " + r2);
        r5.setProportion(r2);
        return;
    }

    private void processWhenClickItemFingerprint() {
        if (needWarningWillDisableTrustedAP() == false) goto L5;
        OLog.e(this.TAG, "onClick itemFingerprint: need warning");
        warningWillDisableTrustedAP();
        return;
    L5:
        OLog.e(this.TAG, "onClick itemFingerprint: router to FingerprintManageActivity");
        routeToFingerprintManagerActivity();
    }

    private void warningWillDisableTrustedAP() {
        OAlertDialog r0 = this.mAlertDialog;
        if (r0 != null) goto L5;
    L7:
        String r1 = getString(R.string.fingerprint);
        if (this.mFaceRecognitionHelper.isFaceRecognitionDataExist() == false) goto L10;
        String r2 = getString(R.string.fingerprint_id_and_face_recognition);
    L11:
        OAlertDialog r3 = (OAlertDialog) new OAlertDialogBuilder(this._mActivity).horizontalButton().title(R.string.dialog_title_alert).message(getString(R.string.trusted_network_feature_disable_notification, new Object[]{r1, r2})).positiveButton(R.string.continue_fingerprint_input, new AnonymousClass5(this)).negativeButton(R.string.cancel, new AssistantActivationFragment$$ExternalSyntheticLambda6()).onDismiss(new AnonymousClass4(this)).build();
        this.mAlertDialog = r3;
        r3.show();
        return;
    L10:
        r2 = r1;
        goto L11
    L5:
        if (r0.isShowing() == false) goto L7;
    }

    private boolean needWarningWillDisableTrustedAP() {
        if (this.mFaceRecognitionHelper.isFaceRecognitionDataExist() == false) goto L16;
        if (Utils.hasTrustedAP(this.mContext) == false) goto L14;
        if (this.mLockPatternUtils.isSecure(UserHandle.myUserId()) == false) goto L14;
        if (Utils.isFingerprintExists(this.mContext) == true) goto L14;
        if (this.mFaceRecognitionHelper.isFaceRecognitionDataExist() == true) goto L14;
        return true;
    L14:
        return false;
    L16:
        if (Utils.isFingerprintExists(this.mContext) == true) goto L23;
        if (this.mLockPatternUtils.isSecure(UserHandle.myUserId()) == false) goto L23;
        if (Utils.hasTrustedAP(this.mContext) == false) goto L23;
        return true;
    L23:
        return false;
    }

    private void routeToFingerprintManagerActivity() {
        if (this.mLockPatternUtils.isSecure(UserHandle.myUserId()) == false) goto L5;
    L8:
        Intent r0 = new Intent(this._mActivity, Settings.FingerprintManageActivity.class);
        Utils.startActivity(this._mActivity, r0, 0);
        return;
    L5:
        if (Utils.isFingerprintExists(this.mContext) == true) goto L8;
        showSetupLockscreenDialog();
    }

    private void showSetupLockscreenDialog() {
        OAlertDialog r0 = this.mSetupLockscreenDialog;
        if (r0 != null) goto L5;
    L7:
        OAlertDialog r1 = (OAlertDialog) new OAlertDialogBuilder(this._mActivity).horizontalButton().title(R.string.setup_lockscreen_title).message(R.string.setup_lockscreen_message_when_click_ai_key_fingerprint_management).positiveButton(R.string.setup_lockscreen_ok_button, new AnonymousClass7(this)).negativeButton(R.string.cancel, new AssistantActivationFragment$$ExternalSyntheticLambda5()).onDismiss(new AnonymousClass6(this)).cancelable(false).build();
        this.mSetupLockscreenDialog = r1;
        r1.show();
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
    }

    private void showChooseLockMenuDialog() {
        ArrayList r3 = new ArrayList();
        r3.add(getString(R.string.lockscreen_mode_item_title_pattern));
        r3.add(getString(R.string.lockscreen_mode_pin_four));
        r3.add(getString(R.string.lockscreen_mode_pin_six));
        r3.add(getString(R.string.lockscreen_mode_item_title_hard));
        ArrayList r4 = new ArrayList();
        r4.add(getLockTypeSelectionOnclickListener(65536));
        r4.add(getLockTypeSelectionOnclickListener(131072, 4));
        r4.add(getLockTypeSelectionOnclickListener(131072, 6));
        r4.add(getLockTypeSelectionOnclickListener(262144));
        r4.add(new AnonymousClass8(this));
        this.mChooseLockTypeDialog = ODialogUtils.INSTANCE.showActionDialog(this._mActivity, getString(R.string.choose_lock_type_title), r3, r4, new AnonymousClass9(this));
    }

    private View.OnClickListener getLockTypeSelectionOnclickListener(int r2) {
        return getLockTypeSelectionOnclickListener(r2, 4);
    }

    private View.OnClickListener getLockTypeSelectionOnclickListener(final int r2, final int r3) {
        return new AnonymousClass10(this, r2, r3);
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
        OLog.i(this.TAG, "startChooseLockTypeActivity challenge 0");
        r0.putExtra("challenge", 0);
        r0.putExtra("for_fingerprint", true);
        r0.putExtra("alert_type", 0);
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

    private boolean isScreenOffAiKeyWake() {
        if (android.provider.Settings.Global.getInt(this.mContext.getContentResolver(), DOUBAO_SCREEN_OFF_AI_KEY_WAKE, 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void setScreenOffAiKeyWake(boolean r2) {
        android.provider.Settings.Global.putInt(this.mContext.getContentResolver(), DOUBAO_SCREEN_OFF_AI_KEY_WAKE, r2 ? 1 : 0);
    }

    private void initDoubleClickView() {
        if (this.mDoubleClickDesc != null) goto L5;
        return;
    L5:
        int r0 = getDoubleClick();
        if (r0 != 0) goto L9;
        this.mDoubleClickDesc.setText(getString(R.string.voice_call));
        return;
    L9:
        if (r0 != 1) goto L12;
        this.mDoubleClickDesc.setText(getString(R.string.video_call));
        return;
    L12:
        if (r0 != 2) goto L15;
        this.mDoubleClickDesc.setText(getString(R.string.share_screen_call));
        return;
    L15:
        if (r0 != 3) goto L17;
        this.mDoubleClickDesc.setText(getString(R.string.doubao_camera));
        return;
    L17:
        this.mDoubleClickDesc.setText(getString(R.string.no_events));
    }

    private void initSingleClickView() {
        if (this.mSingleClickDesc != null) goto L5;
        return;
    L5:
        int r0 = getSingleClick();
        if (r0 != 0) goto L9;
        this.mSingleClickDesc.setText(getString(R.string.open_doubao_dialog));
        return;
    L9:
        if (r0 != 1) goto L11;
        this.mSingleClickDesc.setText(getString(R.string.open_doubao_full_screen_application));
        return;
    L11:
        this.mSingleClickDesc.setText(getString(R.string.no_events));
    }

    private int getDoubleClick() {
        return android.provider.Settings.Global.getInt(this.mContext.getContentResolver(), DOUBLE_CLICK_KEY, 1);
    }

    private void setDoubleClick(int r2) {
        android.provider.Settings.Global.putInt(this.mContext.getContentResolver(), DOUBLE_CLICK_KEY, r2);
        TrackerEvent.chooseEvent("settings_system_intelligent_custom_key_double", String.valueOf(r2));
    }

    private int getSingleClick() {
        return android.provider.Settings.Global.getInt(this.mContext.getContentResolver(), SINGLE_CLICK_KEY, 0);
    }

    private void setSingleClick(int r2) {
        android.provider.Settings.Global.putInt(this.mContext.getContentResolver(), SINGLE_CLICK_KEY, r2);
        TrackerEvent.chooseEvent("settings_system_intelligent_custom_key_click", String.valueOf(r2));
    }

    private void initAiKeySensitivityView() {
        int r0 = getAiKeySensitivity();
        String[] r1 = {this._mActivity.getString(R.string.ai_key_sensitivity_max), this._mActivity.getString(R.string.ai_key_sensitivity_mid), this._mActivity.getString(R.string.ai_key_sensitivity_min)};
        if (r0 < 0) goto L7;
        if (r0 > 2) goto L8;
        this.mAiKeySensitivity.setEndDetailText(r1[r0]);
        this.mAiKeySensitivity.showCustomEnd(true);
        return;
    L8:
        return;
    }

    private void showAiKeySensitivityPopover(View r8) {
        ArrayList r0 = new ArrayList();
        int r1 = getAiKeySensitivity();
        String r3 = getString(R.string.ai_key_sensitivity_max);
        boolean r4 = false;
        if (r1 != 0) goto L5;
        boolean r6 = true;
    L6:
        r0.add(new Item(r3, r6));
        String r5 = getString(R.string.ai_key_sensitivity_mid);
        if (r1 != 1) goto L9;
        boolean r7 = true;
    L10:
        r0.add(new Item(r5, r7));
        String r9 = getString(R.string.ai_key_sensitivity_min);
        if (r1 != 2) goto L13;
        r4 = true;
    L13:
        r0.add(new Item(r9, r4));
        this.mAiKeySensitivityPopover = OPopoverHelper.showPopoverList(this._mActivity, r8, r0, new AssistantActivationFragment$$ExternalSyntheticLambda4(this), true);
        return;
    L9:
        r7 = false;
        goto L10
    L5:
        r6 = false;
        goto L6
    }

    /* JADX INFO: renamed from: lambda$showAiKeySensitivityPopover$4$com-android-settings-intelligent-AssistantActivationFragment, reason: not valid java name */
    /* synthetic */ void m499x99d8b71f(View r1, int r2) {
        OPopover r3 = this.mAiKeySensitivityPopover;
        if (r3 == null) goto L5;
        r3.dismiss();
    L5:
        setAiKeySensitivity(r2);
        initAiKeySensitivityView();
    }

    private int getAiKeySensitivity() {
        return android.provider.Settings.Global.getInt(this.mContext.getContentResolver(), AI_KEY_SENSITIVITY_KEY, 0);
    }

    private void setAiKeySensitivity(int r2) {
        android.provider.Settings.Global.putInt(this.mContext.getContentResolver(), AI_KEY_SENSITIVITY_KEY, r2);
        TrackerEvent.chooseEvent("settings_system_intelligent_ai_key_sensitivity", String.valueOf(r2));
    }

    private void showSingleClickPopover(View r8) {
        ArrayList r0 = new ArrayList();
        int r1 = getSingleClick();
        String r3 = getString(R.string.open_doubao_dialog);
        boolean r4 = false;
        if (r1 != 0) goto L5;
        boolean r6 = true;
    L6:
        r0.add(new Item(r3, r6));
        String r5 = getString(R.string.open_doubao_full_screen_application);
        if (r1 != 1) goto L9;
        boolean r7 = true;
    L10:
        r0.add(new Item(r5, r7));
        String r9 = getString(R.string.no_events);
        if (r1 != 2) goto L13;
        r4 = true;
    L13:
        r0.add(new Item(r9, r4));
        this.mSingleClickPopover = OPopoverHelper.showPopoverList(this._mActivity, r8, r0, new AnonymousClass11(this), true);
        return;
    L9:
        r7 = false;
        goto L10
    L5:
        r6 = false;
        goto L6
    }

    private void showDoubleClickPopover(View r8) {
        ArrayList r0 = new ArrayList();
        int r1 = getDoubleClick();
        String r3 = getString(R.string.voice_call);
        boolean r4 = false;
        if (r1 != 0) goto L5;
        boolean r6 = true;
    L6:
        r0.add(new Item(r3, r6));
        String r5 = getString(R.string.video_call);
        if (r1 != 1) goto L9;
        boolean r7 = true;
    L10:
        r0.add(new Item(r5, r7));
        String r9 = getString(R.string.share_screen_call);
        if (r1 != 2) goto L13;
        boolean r10 = true;
    L14:
        r0.add(new Item(r9, r10));
        String r11 = getString(R.string.doubao_camera);
        if (r1 != 3) goto L17;
        boolean r12 = true;
    L18:
        r0.add(new Item(r11, r12));
        String r13 = getString(R.string.no_events);
        if (r1 != 4) goto L21;
        r4 = true;
    L21:
        r0.add(new Item(r13, r4));
        this.mDoubleClickPopover = OPopoverHelper.showPopoverList(this._mActivity, r8, r0, new AnonymousClass12(this), true);
        return;
    L17:
        r12 = false;
        goto L18
    L13:
        r10 = false;
        goto L14
    L9:
        r7 = false;
        goto L10
    L5:
        r6 = false;
        goto L6
    }

    private void bindViewPager(OBanner r12, OCarouselIndicator r13) {
        int[] r1 = {R.drawable.img_ai_key_1, R.drawable.img_ai_key_2, R.drawable.img_ai_key_3, R.drawable.img_ai_key_4};
        String[] r2 = {getString(R.string.doubao_assistant_fingerprint_activation), getString(R.string.doubao_assistant_key_single_click_activation), getString(R.string.doubao_assistant_key_double_click_activation), getString(R.string.doubao_assistant_key_long_press_activation)};
        String[] r3 = {getString(R.string.doubao_assistant_fingerprint_activation_message), getString(R.string.doubao_assistant_key_single_click_activation_message), getString(R.string.doubao_assistant_key_double_click_activation_message), getString(R.string.doubao_assistant_key_long_press_activation_message)};
        r12.initViewPager2();
        ArrayList r11 = new ArrayList();
        int r6 = 0;
    L3:
        if (r6 >= 4) goto L5;
        r11.add(new CustomBannerData(r1[r6], r2[r6], r3[r6], r6));
        r6 = r6 + 1;
        goto L3
    L5:
        CustomBannerViewHolderFactory r0 = new CustomBannerViewHolderFactory(null);
        r13.setViewPager2(r12.getViewPager2(), r11.size());
        r12.registerViewHolder(r0);
        r12.setData(r11);
        r12.setInfiniteSwitchEnabled(true);
        r12.setDelayAfterUserTouch(5000);
        r12.setCurrentItem(0, false);
    }

    public void com_android_settings_intelligent_AssistantActivationFragment__onResume$___twin___() {
        super.onResume();
        OBanner r0 = this.mBanner;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mIsFirstVisible == false) goto L7;
        this.mIsFirstVisible = false;
        r0.post(new AssistantActivationFragment$$ExternalSyntheticLambda0(this));
        return;
    L7:
        r0.postDelayed(new AssistantActivationFragment$$ExternalSyntheticLambda1(this), BANNER_DELAY_TIME.longValue());
    }

    /* JADX INFO: renamed from: lambda$onResume$5$com-android-settings-intelligent-AssistantActivationFragment, reason: not valid java name */
    /* synthetic */ void m497x7b8ec038() {
        this.mBanner.enableAutoSwitch();
    }

    /* JADX INFO: renamed from: lambda$onResume$6$com-android-settings-intelligent-AssistantActivationFragment, reason: not valid java name */
    /* synthetic */ void m498xfcd2fd7() {
        this.mBanner.enableAutoSwitch();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        OBanner r0 = this.mBanner;
        if (r0 == null) goto L6;
        r0.disableAutoSwitch();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        OBanner r0 = this.mBanner;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        releaseDialog();
    }

    private void releaseDialog() {
        OAlertDialog r0 = this.mAlertDialog;
        if (r0 == null) goto L5;
        r0.dismiss();
        this.mAlertDialog = null;
    L5:
        OAlertDialog r1 = this.mSetupLockscreenDialog;
        if (r1 == null) goto L8;
        r1.dismiss();
        this.mSetupLockscreenDialog = null;
    L8:
        OActionDialog r2 = this.mChooseLockTypeDialog;
        if (r2 == null) goto L12;
        r2.dismiss();
        this.mChooseLockTypeDialog = null;
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_intelligent_AssistantActivationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AssistantActivationFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_intelligent_AssistantActivationFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_intelligent_AssistantActivationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AssistantActivationFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_intelligent_AssistantActivationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_intelligent_AssistantActivationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AssistantActivationFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_intelligent_AssistantActivationFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
