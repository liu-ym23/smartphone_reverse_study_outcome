package com.android.settings;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import bytedanceos.api.SettingsSmt;
import bytedanceos.util.SettingsUtil;
import com.android.settings.base.BaseFragment;
import com.android.settings.sidedial.SideDialOptionsFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.android.settings.widget.HorizontalOptionCheckView;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.olog.OLog;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.toast.OToast;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.settings.search.SettingsSwitchKeyUtil;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public class ShortcutSettingsFragment extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private static final int DIALOG_ID_ENABLE_VOICE_ASSIST = 0;
    public static final int HAND_MODE_LEFT = 0;
    public static final int HAND_MODE_RIGHT = 1;
    private static final int INDEX_SQUEEZE = 1;
    private static final int INDEX_VOLUME_OPPOSITE = 0;
    private static final String KEY_ENABLE_TORCH_VIA_BACK_KEY = "enable_torch_via_back_key";
    private static final int TAP_EASTER_EGG_MAX_COUNT = 20;
    private final int MSG_RESET_TAP_COUNT;
    private TextView mBottomkeyHeaderView;
    private ViewStub mDoubleSideBarStub;
    private View.OnTouchListener mEasterEggListener;
    private SettingItemSwitch mEnableTorchViaBackKeySwitch;
    private SettingItemText mFunctionKeySettings;
    private Handler mHandler;
    private ViewStub mHomeLongPressStub;
    private HorizontalOptionCheckView mHomeLongPressTrigger;
    private PreviewSettingItemView mHomeTriggerNone;
    private HorizontalOptionCheckView mHomeTriggerTextRecognition;
    private HorizontalOptionCheckView mHomeTriggerVoiceCommand;
    private SettingItemSwitch mItemMenuSearch;
    private SettingItemSwitch mItemOneStep;
    private View mItemOneStepTips;
    private ViewStub mMenuBackStub;
    private SettingItemText mMenuMoveDownItem;
    private ImageView mOppositeImage;
    private SettingItemText mOppositeKey;
    private SettingItemSwitch mPowerKeyFuncSwitch;
    private Resources mResources;
    public String[] mShortcutStrVolume;
    private SettingItemText mSideKeySettings;
    private TextView mSidekeyHeaderView;
    private SettingItemText mSmartKeyWithPowerSettings;
    private SettingItemText mSmartKeyWithVolumeDownSettings;
    private SettingItemText mSmartKeyWithVolumeUpSettings;
    private ViewStub mSmartkeyStub;
    private boolean mSqueezeUpSizeKeyEnabled;
    private ImageView mSqueezingImage;
    private SettingItemText mSqueezingKey;
    private int mTapCount;
    private boolean mTextRecognitionEnabled;
    private OFloatingTitleBar mTitleBar;
    private OToast mToast;
    private PreviewSettingItemView mTriggerLock;
    private PreviewSettingItemView mTriggerVoiceAssist;
    private boolean mVoiceCommandEnabled;
    private AlertDialog mWarningDialog;

    public void com_android_settings_ShortcutSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_ShortcutSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_ShortcutSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_ShortcutSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ShortcutSettingsFragment() {
        this.MSG_RESET_TAP_COUNT = 1;
        this.mHandler = new AnonymousClass1(this);
        this.mEasterEggListener = new AnonymousClass2(this);
    }

    static /* synthetic */ int access$000(ShortcutSettingsFragment r0) {
        return r0.mTapCount;
    }

    static /* synthetic */ int access$002(ShortcutSettingsFragment r0, int r1) {
        r0.mTapCount = r1;
        return r1;
    }

    static /* synthetic */ int access$008(ShortcutSettingsFragment r2) {
        int r0 = r2.mTapCount;
        r2.mTapCount = r0 + 1;
        return r0;
    }

    static /* synthetic */ ImageView access$100(ShortcutSettingsFragment r0) {
        return r0.mSqueezingImage;
    }

    static /* synthetic */ void access$1000(ShortcutSettingsFragment r0) {
        r0.updateHomeKeyLongPressSettingsUI();
    }

    static /* synthetic */ boolean access$1100(ShortcutSettingsFragment r0) {
        return r0.mTextRecognitionEnabled;
    }

    static /* synthetic */ boolean access$1200(ShortcutSettingsFragment r0) {
        return r0.mVoiceCommandEnabled;
    }

    static /* synthetic */ AlertDialog access$1302(ShortcutSettingsFragment r0, AlertDialog r1) {
        r0.mWarningDialog = r1;
        return r1;
    }

    static /* synthetic */ Handler access$200(ShortcutSettingsFragment r0) {
        return r0.mHandler;
    }

    static /* synthetic */ OToast access$300(ShortcutSettingsFragment r0) {
        return r0.mToast;
    }

    static /* synthetic */ OToast access$302(ShortcutSettingsFragment r0, OToast r1) {
        r0.mToast = r1;
        return r1;
    }

    static /* synthetic */ boolean access$400(ShortcutSettingsFragment r0) {
        return r0.mSqueezeUpSizeKeyEnabled;
    }

    static /* synthetic */ boolean access$500(ShortcutSettingsFragment r0, boolean r1) {
        return r0.enableSqueezeUpSizeKey(r1);
    }

    static /* synthetic */ void access$600(ShortcutSettingsFragment r0) {
        r0.updateSqueezeViews();
    }

    static /* synthetic */ boolean access$700(ShortcutSettingsFragment r0) {
        return r0.isVoiceAssistEnabled();
    }

    static /* synthetic */ void access$800(ShortcutSettingsFragment r0, int r1) {
        r0.showWarningDialog(r1);
    }

    static /* synthetic */ void access$900(ShortcutSettingsFragment r0, String r1, HorizontalOptionCheckView.Position r2) {
        r0.updateValueByPosition(r1, r2);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.shortcuts_settings_layout, r3, false);
        Resources r5 = getResources();
        this.mResources = r5;
        this.mShortcutStrVolume = r5.getStringArray(R.array.opposite_key_titles);
        this.mTitleBar = (OFloatingTitleBar) findViewByIdNullable(R.id.view_title);
        if (SettingsFeature.isDarwin() == false) goto L5;
        this.mTitleBar.setCenterTitle(R.string.button_shortcuts);
    L6:
        initPowerKeySettingsView();
        initSmartKeySettingsView();
        initDoubleSideBarSettingsView();
        initHomeLongPressSettingsView();
        initMenuBackKeySettingsView();
        return this.mRootView;
    L5:
        this.mTitleBar.setCenterTitle(R.string.button_shortcuts_delta);
        goto L6
    }

    private void initPowerKeySettingsView() {
        if (SettingsFeature.isPowerShortcutSupport() == true) goto L5;
        return;
    L5:
        SettingItemSwitch r0 = (SettingItemSwitch) findViewByIdNullable(R.id.power_key_function);
        this.mPowerKeyFuncSwitch = r0;
        r0.setVisibility(0);
        this.mPowerKeyFuncSwitch.setOnCheckedChangeListener(new AnonymousClass3(this));
    }

    private void initSmartKeySettingsView() {
        this.mSmartkeyStub = (ViewStub) findViewByIdNullable(R.id.smart_key_settings);
        if (SettingsUtil.hasSmartKey() == false) goto L9;
        ViewStub r0 = this.mSmartkeyStub;
        if (r0 == null) goto L10;
        View r1 = r0.inflate();
        SettingItemText r2 = (SettingItemText) r1.findViewById(R.id.side_key);
        this.mSideKeySettings = r2;
        r2.setOnClickListener(this);
        SettingItemText r3 = (SettingItemText) r1.findViewById(R.id.function_key);
        this.mFunctionKeySettings = r3;
        r3.setOnClickListener(this);
        SettingItemText r4 = (SettingItemText) r1.findViewById(R.id.smart_key_with_power);
        this.mSmartKeyWithPowerSettings = r4;
        r4.setTag(2);
        this.mSmartKeyWithPowerSettings.setOnClickListener(this);
        SettingItemText r5 = (SettingItemText) r1.findViewById(R.id.smart_key_with_volume_up);
        this.mSmartKeyWithVolumeUpSettings = r5;
        r5.setTag(3);
        this.mSmartKeyWithVolumeUpSettings.setOnClickListener(this);
        SettingItemText r6 = (SettingItemText) r1.findViewById(R.id.smart_key_with_volume_down);
        this.mSmartKeyWithVolumeDownSettings = r6;
        r6.setTag(4);
        this.mSmartKeyWithVolumeDownSettings.setOnClickListener(this);
        return;
    L10:
        return;
    }

    private void initDoubleSideBarSettingsView() {
        this.mDoubleSideBarStub = (ViewStub) findViewByIdNullable(R.id.sidekey_settings_container);
        if (SettingsFeature.isDoubleSideKey() == false) goto L11;
        ViewStub r0 = this.mDoubleSideBarStub;
        if (r0 == null) goto L13;
        View r1 = r0.inflate();
        this.mSidekeyHeaderView = (TextView) r1.findViewById(R.id.side_key_header_view);
        this.mOppositeKey = (SettingItemText) r1.findViewById(R.id.opposite_key);
        this.mSqueezingKey = (SettingItemText) r1.findViewById(R.id.squeezing_key);
        ImageView r2 = (ImageView) r1.findViewById(R.id.squeezing_image);
        this.mSqueezingImage = r2;
        r2.setOnTouchListener(this.mEasterEggListener);
        this.mOppositeImage = (ImageView) r1.findViewById(R.id.opposite_image);
        this.mSqueezingKey.setOnClickListener(this);
        this.mOppositeKey.setOnClickListener(this);
        this.mItemOneStep = (SettingItemSwitch) r1.findViewById(R.id.one_step_switcher);
        this.mItemOneStepTips = r1.findViewById(R.id.one_step_tips);
        this.mItemOneStep.setOnCheckedChangeListener(this);
        if (SettingsFeature.LONG_PRESS_HOME_SETTINGS_FEATURE == true) goto L12;
        this.mSidekeyHeaderView.setVisibility(8);
        return;
    L12:
        return;
    L13:
        return;
    }

    private void initHomeLongPressSettingsView() {
        this.mHomeLongPressStub = (ViewStub) findViewByIdNullable(R.id.home_key_long_press_settings);
        if (SettingsFeature.LONG_PRESS_HOME_SETTINGS_FEATURE == false) goto L9;
        ViewStub r0 = this.mHomeLongPressStub;
        if (r0 == null) goto L10;
        View r1 = r0.inflate();
        HorizontalOptionCheckView r2 = (HorizontalOptionCheckView) r1.findViewById(R.id.id_home_long_press);
        this.mHomeLongPressTrigger = r2;
        r2.updateSubTitles(R.string.long_press_home_none, R.string.lock_screen_title, R.string.enable_idea_pills);
        this.mHomeTriggerNone = this.mHomeLongPressTrigger.getItemView(HorizontalOptionCheckView.Position.LEFT);
        this.mTriggerLock = this.mHomeLongPressTrigger.getItemView(HorizontalOptionCheckView.Position.MIDDLE);
        this.mTriggerVoiceAssist = this.mHomeLongPressTrigger.getItemView(HorizontalOptionCheckView.Position.RIGHT);
        this.mHomeLongPressTrigger.updatePreviews(R.drawable.setting_call_none_three, R.drawable.setting_call_lock_three, R.drawable.secletor_voice_assist_three);
        this.mHomeLongPressTrigger.setOptionListener(new AnonymousClass4(this));
        HorizontalOptionCheckView r3 = (HorizontalOptionCheckView) r1.findViewById(R.id.access_text_recognition);
        this.mHomeTriggerTextRecognition = r3;
        r3.updateSubTitles(R.string.long_press_home_none, R.string.accessibility_global_ocr);
        this.mHomeTriggerTextRecognition.updatePreviews(R.drawable.select_home_long_click_volume_up_none, R.drawable.select_home_long_click_volume_up_recognition);
        this.mHomeTriggerTextRecognition.setOptionListener(new AnonymousClass5(this));
        HorizontalOptionCheckView r4 = (HorizontalOptionCheckView) r1.findViewById(R.id.access_text_voice_command);
        this.mHomeTriggerVoiceCommand = r4;
        r4.updateSubTitles(R.string.long_press_home_none, R.string.screenshot, R.string.voice_command);
        this.mHomeTriggerVoiceCommand.updatePreviews(R.drawable.select_home_long_click_volume_down_none, R.drawable.setting_volume2_home_screenshots_odin_normal, R.drawable.select_home_long_click_volume_down_voice);
        this.mHomeTriggerVoiceCommand.setOptionListener(new AnonymousClass6(this));
        return;
    L10:
        return;
    }

    private void initMenuBackKeySettingsView() {
        this.mMenuBackStub = (ViewStub) findViewByIdNullable(R.id.menu_back_key_settings);
        if (SettingsFeature.hasMenuAndBackKeys() == false) goto L11;
        ViewStub r0 = this.mMenuBackStub;
        if (r0 == null) goto L13;
        View r1 = r0.inflate();
        this.mBottomkeyHeaderView = (TextView) NullSafe.nonNull(r1.findViewById(R.id.bottom_key_header_view));
        SettingItemSwitch r2 = (SettingItemSwitch) NullSafe.nonNull(r1.findViewById(R.id.menu));
        this.mItemMenuSearch = r2;
        r2.setOnCheckedChangeListener(this);
        this.mEnableTorchViaBackKeySwitch = (SettingItemSwitch) r1.findViewById(R.id.torch_settings);
        SettingItemText r3 = (SettingItemText) NullSafe.nonNull(r1.findViewById(R.id.item_menu_down));
        this.mMenuMoveDownItem = r3;
        r3.setOnClickListener(this);
        if (SettingsFeature.LONG_PRESS_HOME_SETTINGS_FEATURE == true) goto L12;
        this.mBottomkeyHeaderView.setVisibility(8);
        return;
    L12:
        return;
    L13:
        return;
    }

    private void initLongPressPreviewDimens(PreviewSettingItemView r4, boolean r5) {
        r4.setCheckImgMarginDimens(getResources().getDimensionPixelOffset(R.dimen.preview_check_icon_margin_top), getResources().getDimensionPixelOffset(R.dimen.preview_widget_icon_margin_right), 0, 0);
        Resources r0 = getResources();
        if (r5 == false) goto L5;
        int r1 = R.dimen.preview_widget_icon_margin_top_three;
    L6:
        r4.setPreviewImgMarginDimens(r0.getDimensionPixelOffset(r1), 0, 0, 0);
        Resources r3 = getResources();
        if (r5 == false) goto L9;
        int r6 = R.dimen.preview_widget_title_margin_top_three;
    L10:
        r4.setPreviewTitleMarginDimens(r3.getDimensionPixelOffset(r6), 0, 0, 0);
        return;
    L9:
        r6 = R.dimen.preview_widget_title_margin_top;
        goto L10
    L5:
        r1 = R.dimen.preview_widget_icon_margin_top;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
    }

    private void updateViews() {
        updateSmartKeySettings();
        buildPreviewArray();
        updateSqueezeViews();
        updateHomeKeyLongPressSettingsUI();
        updateMenuBack();
        updateSideDialSetting();
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    private void updateSideDialSetting() {
        if (SettingsFeature.isSupportSideDialKey() == true) goto L6;
        this.mSideKeySettings.setVisibility(8);
        findViewByIdNullable(R.id.side_key_img_layout).setVisibility(8);
        return;
    }

    private void updateSmartKeySettings() {
        if (SettingsFeature.isPowerShortcutSupport() == true) goto L5;
        return;
    L5:
        boolean r2 = true;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "camera_enable_by_power_key_double_click", 1) == 1) goto L9;
        r2 = false;
    L9:
        this.mPowerKeyFuncSwitch.setChecked(r2);
    }

    private void updateSqueezeViews() {
        if (SettingsFeature.isDoubleSideKey() == true) goto L5;
        return;
    L5:
        boolean r0 = isSqueezeUpSizeKeyEnabled();
        this.mSqueezeUpSizeKeyEnabled = r0;
        if (r0 == false) goto L8;
        this.mSqueezingKey.setTitle(R.string.squeeze_down_side_buttons);
        this.mItemOneStep.setChecked(isSideKeyEnable());
        this.mItemOneStep.setVisibility(0);
        this.mItemOneStepTips.setVisibility(0);
        return;
    L8:
        this.mSqueezingKey.setTitle(R.string.squeeze_side_buttons);
        this.mItemOneStep.setVisibility(8);
        this.mItemOneStepTips.setVisibility(8);
    }

    private void updateHomeKeyLongPressSettingsUI() {
        if (SettingsFeature.LONG_PRESS_HOME_SETTINGS_FEATURE == true) goto L5;
        return;
    L5:
        String r0 = android.provider.Settings.Global.getString(getContentResolver(), "long_click_home");
        String r1 = android.provider.Settings.Global.getString(getContentResolver(), "long_click_home_volume_up");
        String r2 = android.provider.Settings.Global.getString(getContentResolver(), "long_click_home_volume_down");
        byte r4 = 1;
        initLongPressPreviewDimens(this.mHomeTriggerNone, true);
        initLongPressPreviewDimens(this.mTriggerLock, true);
        initLongPressPreviewDimens(this.mTriggerVoiceAssist, true);
        this.mTriggerVoiceAssist.setVisibility(0);
        if (BatteryTypeInf.BATTERY_POWER_LOCK.equals(r0) == false) goto L9;
        this.mHomeLongPressTrigger.setCheck(HorizontalOptionCheckView.Position.MIDDLE);
    L12:
        this.mTriggerVoiceAssist.setEnabled(isVoiceAssistEnabled());
        if (android.provider.Settings.Global.getInt(getContentResolver(), "accessibility_global_ocr", 0) != 1) goto L15;
        boolean r3 = true;
    L16:
        this.mTextRecognitionEnabled = r3;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "voice_command_state", 0) != 1) goto L19;
        boolean r5 = true;
    L20:
        this.mVoiceCommandEnabled = r5;
        boolean r6 = "text_recognition".equals(r1);
        HorizontalOptionCheckView r7 = this.mHomeTriggerTextRecognition;
        if (r6 == false) goto L23;
        HorizontalOptionCheckView.Position r8 = HorizontalOptionCheckView.Position.RIGHT;
    L24:
        r7.setCheck(r8);
        if (r2 != null) goto L27;
        this.mHomeTriggerVoiceCommand.setCheck(HorizontalOptionCheckView.Position.LEFT);
        return;
    L27:
        int r9 = r2.hashCode();
        if (r9 == (-416447130)) goto L36;
        if (r9 == 349508926) goto L33;
    L38:
        r4 = -1;
    L39:
        if (r4 == 0) goto L41;
        this.mHomeTriggerVoiceCommand.setCheck(HorizontalOptionCheckView.Position.MIDDLE);
        return;
    L41:
        this.mHomeTriggerVoiceCommand.setCheck(HorizontalOptionCheckView.Position.RIGHT);
        return;
    L33:
        if (r2.equals("voice_command") == false) goto L38;
        r4 = 0;
        goto L39
    L36:
        if (r2.equals("screenshot") == false) goto L38;
    L23:
        r8 = HorizontalOptionCheckView.Position.LEFT;
        goto L24
    L19:
        r5 = false;
        goto L20
    L15:
        r3 = false;
        goto L16
    L9:
        if ("idea_pills".equals(r0) == false) goto L11;
        this.mHomeLongPressTrigger.setCheck(HorizontalOptionCheckView.Position.RIGHT);
        goto L12
    L11:
        this.mHomeLongPressTrigger.setCheck(HorizontalOptionCheckView.Position.LEFT);
        goto L12
    }

    private void updateMenuBack() {
        if (SettingsFeature.hasMenuAndBackKeys() == true) goto L5;
        return;
    L5:
        this.mItemMenuSearch.setChecked(getVoiceByMenuEnabled());
        SettingItemSwitch r0 = this.mEnableTorchViaBackKeySwitch;
        boolean r3 = false;
        if (android.provider.Settings.Global.getInt(getContentResolver(), KEY_ENABLE_TORCH_VIA_BACK_KEY, 0) != 1) goto L8;
        r3 = true;
    L8:
        r0.setChecked(r3);
        updateMenuMovedownItemView();
        this.mEnableTorchViaBackKeySwitch.setOnCheckedChangeListener(this);
    }

    private void updateValueByPosition(String r2, HorizontalOptionCheckView.Position r3) {
        if (r3 != HorizontalOptionCheckView.Position.LEFT) goto L7;
        putGlobalValue(r2, SettingsSmt.LONG_CLICK_TYPE.NONE);
        return;
    L7:
        if ("long_click_home_volume_up".equals(r2) == false) goto L10;
        putGlobalValue(r2, "text_recognition");
        return;
    L10:
        if ("long_click_home_volume_down".equals(r2) == false) goto L17;
        if (r3 != HorizontalOptionCheckView.Position.RIGHT) goto L14;
        String r4 = "voice_command";
    L15:
        putGlobalValue(r2, r4);
        return;
    L14:
        r4 = "screenshot";
        goto L15
    L17:
        if ("long_click_home".equals(r2) == true) goto L19;
        return;
    L19:
        if (r3 != HorizontalOptionCheckView.Position.MIDDLE) goto L21;
        String r5 = BatteryTypeInf.BATTERY_POWER_LOCK;
    L22:
        putGlobalValue(r2, r5);
        return;
    L21:
        r5 = "idea_pills";
        goto L22
    }

    private void putGlobalValue(String r1, String r2) {
        android.provider.Settings.Global.putString(getContentResolver(), r1, r2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        if (r3.getId() != R.id.opposite_key) goto L6;
        start(OppositeKeyOptionsFragment.class);
        SettingsTracker.onItemClick(EntityType.LIFE_LOG);
        return;
    L6:
        if (r3.getId() != R.id.squeezing_key) goto L9;
        start(SidesKeyOptionsFragment.class);
        SettingsTracker.onItemClick(1402);
        return;
    L9:
        if (r3 != this.mMenuMoveDownItem) goto L12;
        start(MenuMoveDownSettingFragment.class);
        SettingsTracker.onItemClick(1403);
        return;
    L12:
        if (r3 != this.mFunctionKeySettings) goto L15;
        start(FunctionSmartKeyOptionsFragment.class);
        return;
    L15:
        if (r3 != this.mSmartKeyWithPowerSettings) goto L17;
    L24:
        Bundle r0 = new Bundle();
        r0.putInt(FunctionKeyOptionsFragment.EXTRA_TYPE_HARDWARE_KEY, ((Integer) r3.getTag()).intValue());
        start(FunctionKeyOptionsFragment.class, r0);
        return;
    L17:
        if (r3 == this.mSmartKeyWithVolumeUpSettings) goto L24;
        if (r3 == this.mSmartKeyWithVolumeDownSettings) goto L24;
        if (r3 != this.mSideKeySettings) goto L30;
        start(SideDialOptionsFragment.class);
        return;
    }

    private void buildPreviewArray() {
        if (SettingsFeature.isDoubleSideKey() == true) goto L5;
        return;
    L5:
        int r0 = android.provider.Settings.Global.getInt(getContentResolver(), "volume_key", 1);
        if (SettingsFeature.hasMenuAndBackKeys() == true) goto L13;
        ImageView r1 = this.mOppositeImage;
        if (r0 != 1) goto L10;
        int r2 = R.drawable.preview_right_sidekey;
    L11:
        r1.setBackgroundResource(r2);
        this.mSqueezingImage.setBackgroundResource(R.drawable.preview_squeeze);
        return;
    L10:
        r2 = R.drawable.preview_left_sidekey;
        goto L11
    L13:
        int r3 = android.provider.Settings.Global.getInt(getContentResolver(), "hardware_buttons", 1);
        int r4 = r0 << r3;
        if (r4 != 1) goto L16;
        this.mOppositeImage.setBackgroundResource(R.drawable.preview_r_l);
        this.mSqueezingImage.setBackgroundResource(R.drawable.preview_squeeze_l);
        return;
    L16:
        if (r4 != 2) goto L18;
        this.mOppositeImage.setBackgroundResource(R.drawable.preview_r_r);
        this.mSqueezingImage.setBackgroundResource(R.drawable.preview_squeeze_r);
        return;
    L18:
        if ((r0 | r3) != 0) goto L20;
        this.mOppositeImage.setBackgroundResource(R.drawable.preview_l_l);
        this.mSqueezingImage.setBackgroundResource(R.drawable.preview_squeeze_l);
        return;
    L20:
        this.mOppositeImage.setBackgroundResource(R.drawable.preview_l_r);
        this.mSqueezingImage.setBackgroundResource(R.drawable.preview_squeeze_r);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != this.mItemMenuSearch.getSwitch()) goto L6;
        setVoiceByMenuEnabled(r3);
        SettingsTracker.onSwitcherClick(1404, r3);
        return;
    L6:
        if (r2 != this.mEnableTorchViaBackKeySwitch.getSwitch()) goto L9;
        android.provider.Settings.Global.putInt(getContentResolver(), KEY_ENABLE_TORCH_VIA_BACK_KEY, r3 ? 1 : 0);
        SettingsTracker.onSwitcherClick(1405, r3);
        return;
    L9:
        if (r2 != this.mItemOneStep.getSwitch()) goto L18;
        ContentResolver r1 = getContentResolver();
        if (r3 == false) goto L13;
        String r4 = "side_bar";
    L14:
        android.provider.Settings.Global.putString(r1, "squeeze_side_up_buttons", r4);
        return;
    L13:
        r4 = null;
        goto L14
    }

    private boolean getVoiceByMenuEnabled() {
        if (android.provider.Settings.Global.getInt(getContentResolver(), "voice_assit_by_menu", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public void setVoiceByMenuEnabled(boolean r2) {
        android.provider.Settings.Global.putInt(getContentResolver(), "voice_assit_by_menu", r2 ? 1 : 0);
    }

    private void updateMenuMovedownItemView() {
        boolean r1 = true;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "menu_move_down_nc", 0) == 1) goto L6;
        r1 = false;
    L6:
        if (r1 == false) goto L8;
        String r0 = getResources().getStringArray(R.array.move_down_when_setting_list)[android.provider.Settings.Global.getInt(getContentResolver(), "menu_move_down_when", 0)];
    L9:
        this.mMenuMoveDownItem.setSubTitle(r0);
        return;
    L8:
        r0 = getString(R.string.close);
        goto L9
    }

    private void showWarningDialog(final int r4) {
        if (r4 != 0) goto L15;
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L8;
        OLog.e(this.TAG, "showWarningDialog, activity is null, return");
        return;
    L8:
        if (this.mWarningDialog != null) goto L11;
        this.mWarningDialog = new AlertDialog.Builder(r0).setTitle(R.string.enable_idea_pills_title).setMessage(R.string.enable_long_press_home_for_idea_pills_message).setCancelable(false).setNegativeButton(android.R.string.cancel, null).setPositiveButton(R.string.goto_enable, new AnonymousClass8(this, r4)).setOnDismissListener(new AnonymousClass7(this)).create();
    L11:
        if (this.mWarningDialog.isShowing() == true) goto L16;
        this.mWarningDialog.show();
        return;
    L16:
        return;
    L15:
        throw new IllegalArgumentException("invalid dialog id " + r4);
    }

    private boolean isSideKeyEnable() {
        return "side_bar".equals(android.provider.Settings.Global.getString(getContentResolver(), "squeeze_side_up_buttons"));
    }

    private boolean isVoiceAssistEnabled() {
        if (android.provider.Settings.Global.getInt(getContentResolver(), SettingsSwitchKeyUtil.VOICE_INPUT, 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private boolean isSqueezeUpSizeKeyEnabled() {
        if (android.provider.Settings.Global.getInt(getContentResolver(), "squeeze_up_side_buttons_enabled", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private boolean enableSqueezeUpSizeKey(boolean r2) {
        return android.provider.Settings.Global.putInt(getContentResolver(), "squeeze_up_side_buttons_enabled", r2 ? 1 : 0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        SettingsTracker.trackShortKeySettings(this.mContext);
        super.onDestroy();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_ShortcutSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ShortcutSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ShortcutSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ShortcutSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ShortcutSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_ShortcutSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ShortcutSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ShortcutSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ShortcutSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
