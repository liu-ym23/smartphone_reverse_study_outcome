package com.android.settings;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.android.settings.accessibility.AccessibilityExpertiseSettingsFragment;
import com.android.settings.accessibility.AccessibilitySettingsFragment;
import com.android.settings.accounts.AccountSettingsFragment;
import com.android.settings.applications.utils.XTSUtils;
import com.android.settings.base.BaseActivity;
import com.android.settings.base.BaseFragment;
import com.android.settings.eldership.EldershipModeSettingsFragment;
import com.android.settings.inputmethod.InputMethodAndLanguageSettingsActivity;
import com.android.settings.servicemanager.IPlatform;
import com.android.settings.system.FactoryResetPreferenceController;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.DevicePolicyUtils;
import com.android.settings.utils.MinorUtils;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.obric.apptools.sdk.common.AppMetrics;
import com.obric.apptools.sdk.common.Event;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.v2.alert.style.DialogContainer;
import com.obric.oui.dialog.v2.alert.style.OViewStyleController;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.privacy.GrantUtil;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class AdvancedSettingsFragment extends BaseFragment implements View.OnClickListener {
    private static final String MINORS_MODE_ENABLE = "minors_mode_enabled";
    public static final String SWAP_AI_AND_POWER = "toggle_power_ai_key";
    private static final int TRACKER_DEVELOPMENT = 2610;
    private OCardListItem mAccessibilitySettings;
    private OCardListItem mBackup;
    private OCardListItem mCameraLocation;
    private OCardListItem mDataTransfer;
    private OCardListItem mDateTimeSettings;
    private OCardListItem mEldershipMode;
    private FactoryResetPreferenceController mFactoryResetController;
    private OCardListItem mGoogleSettings;
    private OCardListItem mImeSettings;
    private OCardListItem mLedBrightness;
    private OCardListItem mNavBarSettings;
    private OCardListItem mNotificationCustom;
    private OCardListItem mScreenOrientationItem;
    private OCardListItem mSearchSettings;
    private OCardListItem mSwapAIAndPower;
    private OCardListItem mThirdPartyCustomize;
    private int mTitleStringResId;
    private OCardListItem mViewAccount;
    private OCardListItem mViewAssistFunc;
    private OCardListItem mViewDevelopment;
    private OCardListItem mViewRestore;
    private OCardListItem mViewStorage;
    private OCardListItem mViewUser;
    private OCardListItem mZteBackup;
    private boolean showDevelopmentItem;

    /* JADX INFO: renamed from: com.android.settings.AdvancedSettingsFragment$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {
        final /* synthetic */ AdvancedSettingsFragment this$0;
        final /* synthetic */ LayoutInflater val$inflater;
        final /* synthetic */ OSwitch val$oSwitch;

        AnonymousClass1(AdvancedSettingsFragment r1, OSwitch r2, LayoutInflater r3) {
            this.this$0 = r1;
            this.val$oSwitch = r2;
            this.val$inflater = r3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r5) {
            if (AdvancedSettingsFragment.access$000(this.this$0) == true) goto L5;
            this.val$oSwitch.setChecked(false);
            final View r6 = this.val$inflater.inflate(R.layout.swap_ai_and_power_dialog_layout, null);
            new OAlertDialogBuilder(this.this$0.getActivity()).autoDismiss(false).title(this.this$0.getString(R.string.swap_ai_and_power_title), false).message(R.string.swap_ai_and_power_message).body(new OViewStyleController(new AdvancedSettingsFragment$1$$ExternalSyntheticLambda0(r6))).horizontalButton().negativeButton(R.string.swap_ai_and_power_cancel, new AnonymousClass2(this)).positiveButton(R.string.swap_ai_and_power_confirm, new DialogInterfaceOnClickListenerC00121(this)).createDialog().show();
            return;
        L5:
            AdvancedSettingsFragment.access$100(this.this$0, false);
        }

        static /* synthetic */ Unit lambda$onClick$0(View r0, DialogContainer r1) {
            r1.getBodySlot().addView(r0);
            return Unit.INSTANCE;
        }
    }

    public void com_android_settings_AdvancedSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_AdvancedSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment
    public int getTitleResId() {
        return R.string.advanced_settings_header_title;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_AdvancedSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_AdvancedSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public AdvancedSettingsFragment() {
    }

    static /* synthetic */ boolean access$000(AdvancedSettingsFragment r0) {
        return r0.isSwapAIAndPowerKey();
    }

    static /* synthetic */ void access$100(AdvancedSettingsFragment r0, boolean r1) {
        r0.setSwapAIAndPowerKey(r1);
    }

    static /* synthetic */ void access$200(AdvancedSettingsFragment r0) {
        r0.handleFactoryResetClick();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        this.mRootView = r3.inflate(R.layout.advanced_settings_layout, r4, false);
        this.mFactoryResetController = new FactoryResetPreferenceController(this.mContext);
        this.mTitleStringResId = R.string.advanced_settings_header_title;
        OCardListItem r6 = (OCardListItem) findViewByIdNullable(R.id.swap_ai_and_power_key);
        this.mSwapAIAndPower = r6;
        r6.setDefaultCustomEndView(1);
        this.mSwapAIAndPower.showCustomEnd(true);
        View r7 = this.mSwapAIAndPower.getCustomEndView();
        if ((r7 instanceof OSwitch) == false) goto L6;
        OSwitch r8 = (OSwitch) r7;
        r8.setChecked(isSwapAIAndPowerKey());
        r8.setOnClickListener(new AnonymousClass1(this, r8, r3));
    L6:
        if (SettingsFeature.isSupportSwapAiAndPowerKey() == false) goto L8;
        this.mSwapAIAndPower.setVisibility(0);
        findViewByIdNullable(R.id.swap_ai_and_power_key_bottom_gap).setVisibility(0);
    L8:
        OCardListItem r9 = (OCardListItem) findViewByIdNullable(R.id.ime_settings);
        this.mImeSettings = r9;
        r9.setOnContentClickListener(new AdvancedSettingsFragment$$ExternalSyntheticLambda0(this));
        OCardListItem r10 = (OCardListItem) findViewByIdNullable(R.id.navbar_settings);
        this.mNavBarSettings = r10;
        r10.setOnContentClickListener(new AdvancedSettingsFragment$$ExternalSyntheticLambda2(this));
        OCardListItem r11 = (OCardListItem) findViewByIdNullable(R.id.accessibility_settings);
        this.mAccessibilitySettings = r11;
        r11.setOnContentClickListener(new AdvancedSettingsFragment$$ExternalSyntheticLambda4(this));
        OCardListItem r12 = (OCardListItem) findViewByIdNullable(R.id.date_time_settings);
        this.mDateTimeSettings = r12;
        r12.setOnContentClickListener(new AdvancedSettingsFragment$$ExternalSyntheticLambda5(this));
        OCardListItem r13 = (OCardListItem) findViewByIdNullable(R.id.eldership_mode);
        this.mEldershipMode = r13;
        r13.setOnContentClickListener(new AdvancedSettingsFragment$$ExternalSyntheticLambda6(this));
        addInfoButtonForEldershipItem();
        OCardListItem r14 = (OCardListItem) findViewByIdNullable(R.id.item_assisant);
        this.mViewAssistFunc = r14;
        r14.setOnContentClickListener(new AdvancedSettingsFragment$$ExternalSyntheticLambda7(this));
        OCardListItem r15 = (OCardListItem) findViewByIdNullable(R.id.item_zte_backup);
        this.mZteBackup = r15;
        r15.setOnContentClickListener(new AdvancedSettingsFragment$$ExternalSyntheticLambda8(this));
        if (SettingsFeature.isSupportSwapAiAndPowerKey() == true) goto L11;
        this.mZteBackup.setVisibility(0);
    L11:
        OCardListItem r16 = (OCardListItem) findViewByIdNullable(R.id.item_account);
        this.mViewAccount = r16;
        r16.setOnContentClickListener(new AdvancedSettingsFragment$$ExternalSyntheticLambda9(this));
        OCardListItem r17 = (OCardListItem) findViewByIdNullable(R.id.item_user);
        this.mViewUser = r17;
        r17.setOnContentClickListener(new AdvancedSettingsFragment$$ExternalSyntheticLambda10(this));
        if (XTSUtils.isInXtsMode() == false) goto L14;
        this.mViewUser.setVisibility(0);
    L14:
        OCardListItem r18 = (OCardListItem) findViewByIdNullable(R.id.item_storage);
        this.mViewStorage = r18;
        r18.setOnContentClickListener(new AdvancedSettingsFragment$$ExternalSyntheticLambda12(this));
        OCardListItem r19 = (OCardListItem) findViewByIdNullable(R.id.item_restore);
        this.mViewRestore = r19;
        r19.setOnContentClickListener(new AdvancedSettingsFragment$$ExternalSyntheticLambda11(this));
        OCardListItem r20 = (OCardListItem) findViewByIdNullable(R.id.item_backup);
        this.mBackup = r20;
        r20.setOnContentClickListener(new AdvancedSettingsFragment$$ExternalSyntheticLambda13(this));
        OCardListItem r21 = (OCardListItem) findViewByIdNullable(R.id.item_data_transfer);
        this.mDataTransfer = r21;
        r21.setOnContentClickListener(new AdvancedSettingsFragment$$ExternalSyntheticLambda14(this));
        OCardListItem r22 = (OCardListItem) findViewByIdNullable(R.id.item_camera_location);
        this.mCameraLocation = r22;
        r22.setOnContentClickListener(new AdvancedSettingsFragment$$ExternalSyntheticLambda15(this));
        if (SettingsFeature.isCameraLocationSettingsAvailable() == true) goto L17;
        this.mCameraLocation.setVisibility(8);
    L17:
        OCardListItem r23 = (OCardListItem) findViewByIdNullable(R.id.item_led_brightness);
        this.mLedBrightness = r23;
        r23.setOnContentClickListener(new AdvancedSettingsFragment$$ExternalSyntheticLambda16(this));
        if (SettingsFeature.isLEDBrightnessSettingsEnabled() == false) goto L20;
        this.mLedBrightness.setVisibility(0);
    L20:
        this.mNotificationCustom = (OCardListItem) findViewByIdNullable(R.id.item_notification_custom);
        if (SettingsFeature.isNotificationCustomAvailable() == false) goto L23;
        this.mNotificationCustom.setVisibility(8);
        this.mNotificationCustom.setOnContentClickListener(new AdvancedSettingsFragment$$ExternalSyntheticLambda17(this));
    L24:
        OCardListItem r24 = (OCardListItem) findViewByIdNullable(R.id.id_screen_rotation);
        this.mScreenOrientationItem = r24;
        r24.setOnContentClickListener(new AdvancedSettingsFragment$$ExternalSyntheticLambda18(this));
        boolean r25 = SettingsFeature.ADVANCE_SCREEN_ROTATION_MANUAL;
        this.mGoogleSettings = (OCardListItem) findViewByIdNullable(R.id.item_google_settings);
        if (SettingsFeature.isSupportSwapAiAndPowerKey() == false) goto L27;
        this.mGoogleSettings.setTitle(this.mContext.getString(R.string.google_settings));
    L27:
        this.mGoogleSettings.setOnContentClickListener(new AdvancedSettingsFragment$$ExternalSyntheticLambda19(this));
        OCardListItem r26 = (OCardListItem) findViewByIdNullable(R.id.item_third_party);
        this.mThirdPartyCustomize = r26;
        r26.setOnContentClickListener(new AdvancedSettingsFragment$$ExternalSyntheticLambda20(this));
        OCardListItem r27 = (OCardListItem) findViewByIdNullable(R.id.item_development);
        this.mViewDevelopment = r27;
        r27.setOnContentClickListener(new AdvancedSettingsFragment$$ExternalSyntheticLambda1(this));
        OCardListItem r28 = (OCardListItem) findViewByIdNullable(R.id.search_settings);
        this.mSearchSettings = r28;
        r28.setOnContentClickListener(new AdvancedSettingsFragment$$ExternalSyntheticLambda3(this));
        if (Utils.isPackageInstalledAndIsSystemApp(this.mContext, Constants.PKG_BACKUP) == true) goto L31;
        this.mBackup.setVisibility(8);
    L31:
        if (this.mIsExtDisplaying == false) goto L36;
        if (this.mIsLandScreen == false) goto L36;
        this.mViewAssistFunc.setVisibility(8);
        this.mViewAccount.setVisibility(8);
        this.mViewRestore.setVisibility(8);
        this.mBackup.setVisibility(8);
        this.mDataTransfer.setVisibility(8);
        this.mCameraLocation.setVisibility(8);
        this.mLedBrightness.setVisibility(8);
        this.mScreenOrientationItem.setVisibility(8);
        this.mThirdPartyCustomize.setVisibility(0);
    L36:
        return this.mRootView;
    L23:
        this.mNotificationCustom.setVisibility(8);
        goto L24
    }

    /* JADX INFO: renamed from: lambda$onCreateView$0$com-android-settings-AdvancedSettingsFragment, reason: not valid java name */
    /* synthetic */ void m77x918d6fda(View r1) {
        onClick(this.mImeSettings);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$1$com-android-settings-AdvancedSettingsFragment, reason: not valid java name */
    /* synthetic */ void m78x707961b(View r1) {
        onClick(this.mNavBarSettings);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$2$com-android-settings-AdvancedSettingsFragment, reason: not valid java name */
    /* synthetic */ void m89x7c81bc5c(View r1) {
        onClick(this.mAccessibilitySettings);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$3$com-android-settings-AdvancedSettingsFragment, reason: not valid java name */
    /* synthetic */ void m91xf1fbe29d(View r1) {
        onClick(this.mDateTimeSettings);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$4$com-android-settings-AdvancedSettingsFragment, reason: not valid java name */
    /* synthetic */ void m92x677608de(View r1) {
        onClick(this.mEldershipMode);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$5$com-android-settings-AdvancedSettingsFragment, reason: not valid java name */
    /* synthetic */ void m93xdcf02f1f(View r1) {
        onClick(this.mViewAssistFunc);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$6$com-android-settings-AdvancedSettingsFragment, reason: not valid java name */
    /* synthetic */ void m94x526a5560(View r1) {
        onClick(this.mZteBackup);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$7$com-android-settings-AdvancedSettingsFragment, reason: not valid java name */
    /* synthetic */ void m95xc7e47ba1(View r1) {
        onClick(this.mViewAccount);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$8$com-android-settings-AdvancedSettingsFragment, reason: not valid java name */
    /* synthetic */ void m96x3d5ea1e2(View r1) {
        onClick(this.mViewUser);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$9$com-android-settings-AdvancedSettingsFragment, reason: not valid java name */
    /* synthetic */ void m97xb2d8c823(View r1) {
        onClick(this.mViewStorage);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$10$com-android-settings-AdvancedSettingsFragment, reason: not valid java name */
    /* synthetic */ void m79xfea07e77(View r1) {
        onClick(this.mViewRestore);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$11$com-android-settings-AdvancedSettingsFragment, reason: not valid java name */
    /* synthetic */ void m80x741aa4b8(View r1) {
        onClick(this.mBackup);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$12$com-android-settings-AdvancedSettingsFragment, reason: not valid java name */
    /* synthetic */ void m81xe994caf9(View r1) {
        onClick(this.mDataTransfer);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$13$com-android-settings-AdvancedSettingsFragment, reason: not valid java name */
    /* synthetic */ void m82x5f0ef13a(View r1) {
        onClick(this.mCameraLocation);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$14$com-android-settings-AdvancedSettingsFragment, reason: not valid java name */
    /* synthetic */ void m83xd489177b(View r1) {
        onClick(this.mLedBrightness);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$15$com-android-settings-AdvancedSettingsFragment, reason: not valid java name */
    /* synthetic */ void m84x4a033dbc(View r1) {
        onClick(this.mNotificationCustom);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$16$com-android-settings-AdvancedSettingsFragment, reason: not valid java name */
    /* synthetic */ void m85xbf7d63fd(View r1) {
        onClick(this.mScreenOrientationItem);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$17$com-android-settings-AdvancedSettingsFragment, reason: not valid java name */
    /* synthetic */ void m86x34f78a3e(View r1) {
        onClick(this.mGoogleSettings);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$18$com-android-settings-AdvancedSettingsFragment, reason: not valid java name */
    /* synthetic */ void m87xaa71b07f(View r1) {
        onClick(this.mThirdPartyCustomize);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$19$com-android-settings-AdvancedSettingsFragment, reason: not valid java name */
    /* synthetic */ void m88x1febd6c0(View r1) {
        onClick(this.mViewDevelopment);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$20$com-android-settings-AdvancedSettingsFragment, reason: not valid java name */
    /* synthetic */ void m90x386b2056(View r1) {
        onClick(this.mSearchSettings);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        if (SettingsFeature.isGoogleSettingsAvailable(this.mContext) == true) goto L5;
    L7:
        this.mGoogleSettings.setVisibility(8);
    L8:
        updateDevelomentSettingItem();
        return;
    L5:
        if (this.mIsExtDisplaying == true) goto L7;
        this.mGoogleSettings.setVisibility(0);
        goto L8
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateDevelomentSettingItem();
    }

    private void addInfoButtonForEldershipItem() {
        if (this.mEldershipMode != null) goto L5;
        return;
    L5:
        ImageView r0 = new ImageView(this.mContext);
        r0.setImageResource(R.drawable.ic_info_button);
        this.mEldershipMode.setCustomEndView(r0);
        this.mEldershipMode.showCustomEnd(true);
        r0.setOnClickListener(new AnonymousClass2(this));
    }

    private void updateDevelomentSettingItem() {
        boolean r0 = getSharedPreferences("development", 0).getBoolean("show", false);
        this.showDevelopmentItem = r0;
        if (r0 == true) goto L5;
        this.mViewDevelopment.setVisibility(8);
    L6:
        updateGroupContainer();
        return;
    L5:
        this.mViewDevelopment.setVisibility(0);
        goto L6
    }

    private void updateGroupContainer() {
        if (this.mRootView != null) goto L5;
        return;
    L5:
        LinearLayout r7 = (LinearLayout) this.mRootView.findViewById(R.id.group_container);
        int r0 = r7.getChildCount();
        OCardListItem r2 = null;
        int r4 = 0;
        OCardListItem r3 = null;
    L6:
        if (r4 >= r0) goto L16;
        View r5 = r7.getChildAt(r4);
        if ((r5 instanceof OCardListItem) == false) goto L15;
        OCardListItem r6 = (OCardListItem) r5;
        if (r5.getVisibility() != 0) goto L15;
        if (r3 != null) goto L14;
        r3 = r6;
    L14:
        r6.setCardPosition(2);
        r2 = r6;
    L15:
        r4 = r4 + 1;
        goto L6
    L16:
        if (r2 != r3) goto L20;
        if (r3 == null) goto L20;
        r3.setCardPosition(0);
        return;
    L20:
        if (r3 == null) goto L22;
        r3.setCardPosition(1);
    L22:
        if (r2 == null) goto L29;
        r2.setCardPosition(3);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        Intent r0 = new Intent();
        r0.putExtra("back_text_id", this.mTitleStringResId);
        if (this.mImeSettings != r10) goto L6;
        r0.setClass(this.mContext, InputMethodAndLanguageSettingsActivity.class);
        Utils.startActivity(this._mActivity, r0);
        return;
    L6:
        if (this.mNavBarSettings != r10) goto L9;
        start(NavbarModeFragment.class);
        return;
    L9:
        if (this.mAccessibilitySettings != r10) goto L12;
        start(AccessibilityExpertiseSettingsFragment.class);
        return;
    L12:
        if (this.mDateTimeSettings != r10) goto L15;
        start(DateTimeSettingsFragment.class);
        SettingsTracker.onItemClick(2601);
        return;
    L15:
        if (r10 != this.mEldershipMode) goto L18;
        start(EldershipModeSettingsFragment.class);
        return;
    L18:
        if (this.mViewAssistFunc != r10) goto L21;
        start(AccessibilitySettingsFragment.class);
        SettingsTracker.onItemClick(2603);
        return;
    L21:
        if (this.mZteBackup != r10) goto L24;
        Intent r11 = new Intent("com.ume.weshare.CHANGEPHONE");
        Utils.startActivity(this._mActivity, r11);
        return;
    L24:
        if (this.mViewAccount != r10) goto L27;
        start(AccountSettingsFragment.class);
        SettingsTracker.onItemClick(2604);
        return;
    L27:
        if (this.mViewUser != r10) goto L30;
        Intent r12 = new Intent(this.mContext, Settings.UserSettingsActivity.class);
        Utils.startActivity(this._mActivity, r12);
        SettingsTracker.onItemClick(2607);
        return;
    L30:
        if (this.mViewStorage != r10) goto L33;
        r0.setClassName(Constants.PKG_SECURITY, "com.bytedanceos.storage.StorageActivity");
        r0.setAction("android.intent.action.MAIN");
        r0.removeExtra("back_text_id");
        r0.putExtra(Utils.EXTRA_FROM_SETTINGS, true);
        r0.putExtra(BaseActivity.EXTRA_FROM_SECURITY, false);
        r0.putExtra("back_text_res_name", "advanced_settings_header_title");
        r0.putExtra("bytedanceos.intent.extra.ANIM_RESOURCE_ID", new int[]{R.anim.slide_in_from_left, R.anim.slide_out_to_right});
        Utils.startActivity(this._mActivity, r0);
        SettingsTracker.onItemClick(2612);
        return;
    L33:
        if (this.mViewRestore != r10) goto L39;
        if (MinorUtils.INSTANCE.getMinorsModeState(this.mContext) == false) goto L37;
        MinorUtils.INSTANCE.launchCredentialConfirmController(getActivity(), new AnonymousClass3(this));
        return;
    L37:
        handleFactoryResetClick();
        SettingsTracker.onItemClick(2605);
        return;
    L39:
        if (this.mBackup != r10) goto L43;
        r0.setClassName(Constants.PKG_BACKUP, "com.bytedanceos.backup.activity.BackupListActivity");
        r0.setAction("android.intent.action.MAIN");
        r0.removeExtra("back_text_id");
        r0.putExtra(Utils.EXTRA_FROM_SETTINGS, true);
        Utils.startActivity(this._mActivity, r0);
        SettingsTracker.onItemClick(2606);
        return;
    L43:
        if (this.mDataTransfer != r10) goto L46;
        r0.setClassName(Constants.PKG_BACKUP, "com.bytedanceos.backup.activity.OldPhoneActivity");
        r0.putExtra("back_text", getString(this.mTitleStringResId));
        Utils.startActivity(this._mActivity, r0);
        SettingsTracker.onItemClick(2607);
        return;
    L46:
        if (this.mCameraLocation != r10) goto L49;
        r0.setClass(this.mContext, CameraSettingsActivity.class);
        Utils.startActivity(this._mActivity, r0, 0);
        return;
    L49:
        if (this.mViewDevelopment != r10) goto L63;
        if (DevicePolicyUtils.trySendShowAdminSupportDetailsIntent(this.mContext, "no_debugging_features") == false) goto L54;
        return;
    L54:
        if (MinorUtils.INSTANCE.getMinorsModeState(this.mContext) == false) goto L57;
        ToastUtils.show(getActivity(), R.string.minors_mode_development_not_supported);
        return;
    L57:
        SettingsTracker.onItemClick(TRACKER_DEVELOPMENT);
        if (Utils.isMonkeyRunning() == false) goto L61;
        OLog.d(this.TAG, "isMonkeyRunning, ignore monkey operation");
        return;
    L61:
        r0.setClass(this.mContext, DevelopmentSettings.class);
        Utils.startActivity(this._mActivity, r0, 0);
        return;
    L63:
        if (this.mLedBrightness != r10) goto L66;
        r0.setClass(this.mContext, LedBrightnessSettings.class);
        startActivity(r0);
        SettingsTracker.onItemClick(2611);
        return;
    L66:
        if (this.mGoogleSettings != r10) goto L72;
        if (SettingsFeature.isSupportSwapAiAndPowerKey() == true) goto L70;
        start(GoogleServiceSettingsFragment.class);
        return;
    L70:
        r0.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.app.settings.GoogleSettingsLink"));
        startActivity(r0);
        SettingsTracker.onItemClick(2609);
        return;
    L72:
        if (r10 != this.mScreenOrientationItem) goto L75;
        start(new ScreenRotationSettingFragment());
        return;
    L75:
        if (r10 != this.mThirdPartyCustomize) goto L78;
        start(ThirdPartyAppCustomizeFragment.class);
        return;
    L78:
        if (this.mSearchSettings != r10) goto L106;
        r0.setClassName("com.obric.quicksearch", "com.android.quicksearchbox.preferences.SearchSettingsActivity");     // Catch: Exception -> L81
        Utils.startActivity(this._mActivity, r0);     // Catch: Exception -> L81
        return;
    L81:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static boolean getMinorsModeState(Context r2) {
        if (android.provider.Settings.Secure.getInt(r2.getContentResolver(), "minors_mode_enabled", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private void jumpToMinorApp() {
        Intent r0 = new Intent();
        r0.setComponent(new ComponentName("com.zte.usebalance", "com.zte.usebalance.activity.home.MinorsModeActivity"));
        r0.setAction("android.intent.action.MAIN");
        Utils.startActivity(this._mActivity, r0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        SettingsTracker.trackAdvanceSettings(this.mContext);
        super.onDestroy();
    }

    private boolean isSwapAIAndPowerKey() {
        if (android.provider.Settings.System.getInt(this.mContext.getContentResolver(), SWAP_AI_AND_POWER, 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private void setSwapAIAndPowerKey(boolean r4) {
        android.provider.Settings.System.putInt(this.mContext.getContentResolver(), SWAP_AI_AND_POWER, r4 ? 1 : 0);
        Event r3 = AppMetrics.INSTANCE.eventOf("swap", "ai_and_power_key");
        AppMetrics.INSTANCE.addCategory(r3, SWAP_AI_AND_POWER, Boolean.valueOf(r4));
        AppMetrics.INSTANCE.report(r3);
    }

    private void handleFactoryResetClick() {
        if (((IPlatform) ServiceManager.getService(IPlatform.class)).isGoogleResetEnable() == true) goto L7;
        this.mFactoryResetController.startFactoryResetActivity(this);
        return;
    L7:
        if (this.mFactoryResetController.isAvailable() == true) goto L10;
        OLog.w(this.TAG, "Factory reset is not available for current user");
        return;
    L10:
        Intent r0 = this.mFactoryResetController.getPrepareFactoryResetIntent();
        if (r0 == null) goto L13;
        OLog.d(this.TAG, "Starting factory reset preparation activity");
        startActivityForResult(r0, 10001);
        return;
    L13:
        OLog.d(this.TAG, "No preparation activity found, starting factory reset directly");
        this.mFactoryResetController.startFactoryResetActivity(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        if (r2 != 10001) goto L6;
        this.mFactoryResetController.handlePrepareResult(this, r3, r4);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_AdvancedSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AdvancedSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_AdvancedSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_AdvancedSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AdvancedSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_AdvancedSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_AdvancedSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AdvancedSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_AdvancedSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
