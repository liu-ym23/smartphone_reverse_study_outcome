package com.android.settings.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bytedanceos.util.SettingsUtil;
import com.android.settings.Constants;
import com.android.settings.ImageSpanAlignCenter;
import com.android.settings.PreferenceMgr;
import com.android.settings.R;
import com.android.settings.SettingsFeature;
import com.android.settings.SettingsTracker;
import com.android.settings.ToastUtils;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.tts.TTSSettingFragment;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public class AccessibilitySpeechReadingFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener, DialogInterface.OnClickListener, DialogInterface.OnCancelListener, DialogInterface.OnDismissListener, View.OnClickListener {
    public static final int CAPABILITY_CAN_DISABLE_LAUNCHER = 16777217;
    public static final int CAPABILITY_CAN_DISABLE_NAVBAR = 1048580;
    public static final int CAPABILITY_CAN_DISABLE_ONE_STEP = 1048578;
    public static final int CAPABILITY_CAN_GET_LOCATIONS = 64;
    public static final int CAPABILITY_CAN_READ_THIRD_APPS = 128;
    private static final int DIALOG_ID_DISABLE_WARNING = 2;
    private static final int DIALOG_ID_ENABLE_WARNING = 1;
    private static final int DIALOG_ID_ENABLE_WARNING_FIRST_TIME = 0;
    private static final int DIALOG_ID_LAUNCHER_SWITCH = 4;
    private static final int DIALOG_ID_VERIFY_DOCKER_PASS = 3;
    private static final int REQ_VERIFY_LAUNCHER_PASSWORD = 1000;
    private static final SparseArray<AccessibilityServiceInfo.CapabilityInfo> sAvailableCapabilityInfos = null;
    private int mAccessibilityBlindState;
    private boolean mChangeByShortCut;
    private int mCurrentGlobalOCRState;
    private int mCurrentVoiceCommandState;
    private int mDefaultSpeakerIndex;
    private Dialog mDialog;
    private boolean mEnableWarningShown;
    private BroadcastReceiver mHomeKeyReceiver;
    private ContentObserver mIflytekSpeakerObserver;
    private boolean mIsLauncherSwitched;
    private boolean mIsTalkBackEnabled;
    private SettingItemText mItemAccessSpeaker;
    private SettingItemText mItemAccessTimeReport;
    private SettingItemSwitch mItemAccessibilitySwitch;
    private SettingItemSwitch mItemGlobalOCR;
    private SettingItemText mItemTalkBack;
    private SettingItemText mItemVoiceCommand;
    private String mLastLauncherName;
    private boolean mMasterSwitchChanged;
    private LinearLayout mScreenReaderContainer;
    private boolean mShouldSwitchLauncher;
    private int mShownDialogId;
    private String[] mSpeakerAccentInfos;
    private View mSpeakerContainer;
    private String[] mSpeakerGenderInfos;
    private ContentObserver mSpeechReadingObserver;
    private TextView mTTSCopyrightTipsView;
    private SettingItemText mTTSItem;
    private ComponentName mTalkBackComponentName;
    private ContentObserver mTalkbackObserver;

    public void com_android_settings_accessibility_AccessibilitySpeechReadingFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_accessibility_AccessibilitySpeechReadingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_accessibility_AccessibilitySpeechReadingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    @Override // com.android.settings.base.BaseFragment
    protected boolean shouldMonitorExtDisplayStatus() {
        return true;
    }

    public AccessibilitySpeechReadingFragment() {
        final Handler r1 = new Handler();
        this.mTalkbackObserver = new AnonymousClass1(this, r1);
        final Handler r2 = new Handler();
        this.mSpeechReadingObserver = new AnonymousClass2(this, r2);
        this.mHomeKeyReceiver = new AnonymousClass3(this);
        this.mIflytekSpeakerObserver = null;
    }

    static /* synthetic */ boolean access$000(AccessibilitySpeechReadingFragment r0) {
        return r0.mIsTalkBackEnabled;
    }

    static /* synthetic */ boolean access$002(AccessibilitySpeechReadingFragment r0, boolean r1) {
        r0.mIsTalkBackEnabled = r1;
        return r1;
    }

    static /* synthetic */ SettingItemText access$100(AccessibilitySpeechReadingFragment r0) {
        return r0.mItemTalkBack;
    }

    static /* synthetic */ boolean access$202(AccessibilitySpeechReadingFragment r0, boolean r1) {
        r0.mChangeByShortCut = r1;
        return r1;
    }

    static /* synthetic */ int access$300(AccessibilitySpeechReadingFragment r0) {
        return r0.mAccessibilityBlindState;
    }

    static /* synthetic */ void access$400(AccessibilitySpeechReadingFragment r0, boolean r1) {
        r0.enableConfirmed(r1);
    }

    static /* synthetic */ String access$500(AccessibilitySpeechReadingFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ boolean access$600(AccessibilitySpeechReadingFragment r0) {
        return r0.mShouldSwitchLauncher;
    }

    static /* synthetic */ boolean access$602(AccessibilitySpeechReadingFragment r0, boolean r1) {
        r0.mShouldSwitchLauncher = r1;
        return r1;
    }

    static /* synthetic */ String access$702(AccessibilitySpeechReadingFragment r0, String r1) {
        r0.mLastLauncherName = r1;
        return r1;
    }

    static /* synthetic */ void access$800(AccessibilitySpeechReadingFragment r0) {
        r0.updateSpeaker();
    }

    static {
        SparseArray<AccessibilityServiceInfo.CapabilityInfo> r0 = new SparseArray();
        sAvailableCapabilityInfos = r0;
        r0.put(1, new AccessibilityServiceInfo.CapabilityInfo(1, R.string.capability_title_canRetrieveWindowContent, R.string.capability_desc_canRetrieveWindowContent));
        r0.put(2, new AccessibilityServiceInfo.CapabilityInfo(2, R.string.capability_title_canRequestTouchExploration, R.string.capability_desc_canRequestTouchExploration));
        r0.put(4, new AccessibilityServiceInfo.CapabilityInfo(4, R.string.capability_title_canRequestEnhancedWebAccessibility, R.string.capability_desc_canRequestEnhancedWebAccessibility));
        r0.put(8, new AccessibilityServiceInfo.CapabilityInfo(8, R.string.capability_title_canRequestFilterKeyEvents, R.string.capability_desc_canRequestFilterKeyEvents));
        r0.put(64, new AccessibilityServiceInfo.CapabilityInfo(64, R.string.accessibility_permission_custom_location, R.string.accessibility_permission_custom_location_dsc));
        r0.put(128, new AccessibilityServiceInfo.CapabilityInfo(128, R.string.accessibility_permission_custom_read_data, R.string.accessibility_permission_custom_read_data_dsc));
        r0.put(CAPABILITY_CAN_DISABLE_LAUNCHER, new AccessibilityServiceInfo.CapabilityInfo(CAPABILITY_CAN_DISABLE_LAUNCHER, R.string.accessibility_permission_disable_bytedance_launcher, R.string.accessibility_permission_disable_bytedance_launcher));
        r0.put(CAPABILITY_CAN_DISABLE_ONE_STEP, new AccessibilityServiceInfo.CapabilityInfo(CAPABILITY_CAN_DISABLE_ONE_STEP, R.string.accessibility_permission_custom_bytedance_one_step, R.string.accessibility_permission_custom_bytedance_one_step));
        r0.put(CAPABILITY_CAN_DISABLE_NAVBAR, new AccessibilityServiceInfo.CapabilityInfo(CAPABILITY_CAN_DISABLE_NAVBAR, R.string.accessibility_permission_custom_navigationbar, R.string.accessibility_permission_custom_navigationbar));
    }

    private void observerIflyState() {
        OLog.v(this.TAG, "observerIflyState broad cast to update speaker index");
        final Handler r1 = new Handler();
        this.mIflytekSpeakerObserver = new AnonymousClass4(this, r1);
        Uri r0 = Settings.Global.getUriFor("ifly_speaker_index");
        getContentResolver().registerContentObserver(r0, false, this.mIflytekSpeakerObserver);
        Intent r2 = new Intent("com.bytedanceos.IFLY_OTA_CHECK");
        r2.setPackage("com.bytedanceos.sara");
        sendBroadcast(r2);
    }

    public void com_android_settings_accessibility_AccessibilitySpeechReadingFragment__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        int r4 = Settings.Global.getInt(getContentResolver(), "ifly_speaker_index", -1);
        this.mDefaultSpeakerIndex = r4;
        if (r4 != (-1)) goto L5;
        observerIflyState();
    L5:
        this.mTalkBackComponentName = new ComponentName(Constants.PKG_TALK_BACK, Constants.TALK_BACK_SERVICE_NAME);
        this.mSpeakerGenderInfos = Utils.getOutsideAppArray(this.mContext, "com.bytedanceos.sara", "ifly_speakers_gender_value");
        this.mSpeakerAccentInfos = Utils.getOutsideAppArray(this.mContext, "com.bytedanceos.sara", "ifly_speakers_accent_value");
        this.mShouldSwitchLauncher = false;
        this.mLastLauncherName = Utils.getDefaultLauncherPkg(this.mContext);
        IntentFilter r5 = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        r5.setPriority(1000);
        registerReceiver(this.mHomeKeyReceiver, r5);
    }

    @Override // com.android.settings.base.BaseFragment
    protected void onExtDisplayChanged(boolean r1) {
        updateOnExtDisplay(r1);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        this.mRootView = r3.inflate(R.layout.accessibility_speech_reading_settings_layout, r4, false);
        this.mItemAccessibilitySwitch = (SettingItemSwitch) findViewByIdNullable(R.id.id_accessibility_speech_reading);
        this.mItemTalkBack = (SettingItemText) findViewByIdNullable(R.id.id_trigger_talk_back);
        this.mItemVoiceCommand = (SettingItemText) findViewByIdNullable(R.id.id_trigger_voice_command);
        this.mItemGlobalOCR = (SettingItemSwitch) findViewByIdNullable(R.id.id_trigger_global_ocr);
        this.mItemAccessTimeReport = (SettingItemText) findViewByIdNullable(R.id.id_trigger_accessibility_report_punctually);
        SettingItemText r6 = (SettingItemText) findViewByIdNullable(R.id.tts_settings);
        this.mTTSItem = r6;
        r6.setOnClickListener(this);
        SettingItemText r7 = this.mTTSItem;
        if (SettingsFeature.isTTSUISuitable() == false) goto L5;
        int r8 = 0;
    L6:
        r7.setVisibility(r8);
        this.mItemAccessSpeaker = (SettingItemText) findViewByIdNullable(R.id.id_trigger_accessibility_speaker);
        this.mScreenReaderContainer = (LinearLayout) findViewByIdNullable(R.id.id_screen_reader_services_container);
        this.mTTSCopyrightTipsView = (TextView) findViewByIdNullable(R.id.id_speaker_copyright);
        this.mSpeakerContainer = findViewByIdNullable(R.id.id_accessibility_speaker_container);
        this.mItemTalkBack.setOnClickListener(this);
        if (SettingsFeature.isBytedanceAccessibilitySupport(this.mContext) == false) goto L9;
        this.mItemVoiceCommand.setVisibility(0);
        findViewByIdNullable(R.id.shadow_below_voice_command).setVisibility(0);
        this.mItemVoiceCommand.setOnClickListener(this);
        findViewByIdNullable(R.id.global_ocr_tips_view).setVisibility(0);
        this.mItemGlobalOCR.setVisibility(0);
        this.mItemGlobalOCR.setOnCheckedChangeListener(this);
    L10:
        this.mItemAccessTimeReport.setOnClickListener(this);
        this.mItemAccessSpeaker.setOnClickListener(this);
        getContentResolver().registerContentObserver(Settings.Secure.getUriFor("enabled_accessibility_services"), false, this.mTalkbackObserver);
        getContentResolver().registerContentObserver(Settings.Global.getUriFor("accessibility_speech_reading"), false, this.mSpeechReadingObserver);
        setCopyrightInfo();
        return this.mRootView;
    L9:
        this.mItemVoiceCommand.setVisibility(8);
        findViewByIdNullable(R.id.shadow_below_voice_command).setVisibility(8);
        this.mItemGlobalOCR.setVisibility(8);
        findViewByIdNullable(R.id.global_ocr_tips_view).setVisibility(8);
        goto L10
    L5:
        r8 = 8;
        goto L6
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        if (this.mLastLauncherName.equals(Utils.getDefaultLauncherPkg(this.mContext)) == true) goto L6;
        this.mShouldSwitchLauncher = true;
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
        this.mItemAccessibilitySwitch.setOnCheckedChangeListener(this);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r3, boolean r4) {
        if (r3 != this.mItemAccessibilitySwitch.getSwitch()) goto L18;
        if (isRealCaptionOn() == false) goto L8;
        ToastUtils.show(getActivity(), R.string.real_caption_on_rejection_toast);
        this.mItemAccessibilitySwitch.getSwitch().setChecked(false);
        return;
    L8:
        int r1 = 1;
        if (this.mEnableWarningShown == true) goto L12;
        if (r4 == false) goto L12;
        showDialog(0);
        PreferenceMgr.getInstance(this.mContext).putInt(PreferenceMgr.KEY_SPEECH_READING_WARNING_SHOWN, 1);
    L16:
        SettingsTracker.onSwitcherClick(26030901, r4);
        return;
    L12:
        if (r4 == true) goto L15;
        r1 = 2;
    L15:
        showDialog(r1);
        goto L16
    L18:
        if (r3 != this.mItemGlobalOCR.getSwitch()) goto L22;
        Settings.Global.putInt(getContentResolver(), "accessibility_global_ocr", r4 ? 1 : 0);
        this.mCurrentGlobalOCRState = r4 ? 1 : 0;
        return;
    }

    private void updateViews() {
        if (this.mLastLauncherName.equals(Utils.getDefaultLauncherPkg(this.mContext)) == true) goto L5;
        this.mShouldSwitchLauncher = true;
    L5:
        updateView();
        updateSpeaker();
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r5, int r6) {
        boolean r1 = false;
        if (r6 != (-2)) goto L5;
        int r7 = this.mShownDialogId;
        if (r7 == 2) goto L33;
        if (r7 == 0) goto L33;
        boolean r8 = false;
    L34:
        this.mItemAccessibilitySwitch.setChecked(r8);
        if (this.mShownDialogId == 4) goto L37;
    L39:
        updateView();
        return;
    L37:
        if (this.mAccessibilityBlindState != 1) goto L39;
        enableConfirmed(false);
    L33:
        r8 = true;
        goto L34
    L5:
        if (r6 != (-1)) goto L27;
        int r9 = this.mShownDialogId;
        if (r9 != 0) goto L10;
        showDialog(1);
        goto L39
    L10:
        if (r9 == 1) goto L12;
    L14:
        int r10 = this.mShownDialogId;
        if (r10 == 1) goto L23;
        if (r10 == 2) goto L23;
        if (r10 != 3) goto L21;
        Utils.startActivity(this, new Intent("com.bytedanceos.launcher.verify_password"), 2, 1000);
    L21:
        if (this.mShownDialogId != 4) goto L39;
        this.mIsLauncherSwitched = true;
        Utils.launchNewLauncher(this.mContext);
    L23:
        if (r10 != 1) goto L25;
        r1 = true;
    L25:
        enableConfirmed(r1);
        goto L39
    L12:
        if (Utils.hasLockedPackages(this.mContext.getPackageManager()) == false) goto L14;
        showDialog(3);
        goto L39
    L27:
        throw new IllegalArgumentException();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface r4) {
        int r5 = this.mShownDialogId;
        boolean r0 = true;
        if (r5 != 1) goto L5;
    L6:
        r0 = false;
    L7:
        this.mItemAccessibilitySwitch.setChecked(r0);
        return;
    L5:
        if (r5 == 2) goto L7;
        goto L6
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r1) {
        this.mDialog = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r7) {
        if (r7 != this.mItemTalkBack) goto L15;
        AccessibilityServiceInfo r8 = getTalkBackServiceInfo();
        if (r8 != null) goto L7;
        return;
    L7:
        String r0 = r8.getResolveInfo().loadLabel(getPackageManager()).toString();
        boolean r1 = SettingsUtil.isAccessibilityEnabled(this.mContext, Constants.PKG_TALK_BACK);
        Bundle r3 = new Bundle();
        r3.putString(AccessibilitySettings.EXTRA_PREFERENCE_KEY, this.mTalkBackComponentName.flattenToString());
        r3.putBoolean("checked", r1);
        r3.putString("title", r0);
        String r2 = r8.loadDescription(getPackageManager());
        if (TextUtils.isEmpty(r2) == false) goto L10;
        r2 = getString(R.string.accessibility_service_default_description);
    L10:
        r3.putString("summary", r2);
        if (TextUtils.isEmpty(r8.getSettingsActivityName()) == true) goto L13;
        r3.putString(AccessibilitySettings.EXTRA_SETTINGS_TITLE, getString(R.string.accessibility_menu_item_settings));
        r3.putString(AccessibilitySettings.EXTRA_SETTINGS_COMPONENT_NAME, new ComponentName(Constants.PKG_TALK_BACK, Constants.TALK_BACK_ACTIVITY_NAME).flattenToString());
    L13:
        r3.putParcelable(AccessibilitySettings.EXTRA_COMPONENT_NAME, this.mTalkBackComponentName);
        r3.putBoolean(AccessibilitySettings.EXTRA_DISABLE_WARNING_DIALOG, true);
        start(new ToggleAccessibilityServiceFragment(), r3);
        return;
    L15:
        if (r7 != this.mItemVoiceCommand) goto L18;
        Intent r9 = new Intent();
        r9.setComponent(new ComponentName("com.bytedanceos.sara", "com.bytedanceos.sara.voicecommand.VoiceCommandSettingActivity"));
        r9.putExtra("back_text", getString(R.string.accessibility_speech_reading));
        Utils.startActivity(this._mActivity, r9);
        return;
    L18:
        if (r7 != this.mItemAccessTimeReport) goto L21;
        start(new HourlyChimeFragment());
        return;
    L21:
        if (r7 != this.mItemAccessSpeaker) goto L24;
        Intent r10 = new Intent("com.iflytek.speechsuite.settings.tts");
        r10.putExtra("back_text", getString(R.string.accessibility_speech_reading));
        r10.setPackage("com.bytedanceos.sara");
        Utils.startActivity(this._mActivity, r10);
        return;
    L24:
        if (this.mTTSItem != r7) goto L31;
        start(TTSSettingFragment.class);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r2, int r3, Intent r4) {
        if (r2 == 1000) goto L5;
    L7:
        super.onActivityResult(r2, r3, r4);
        return;
    L5:
        if (r3 != RESULT_OK) goto L7;
        enableConfirmed(true);
        this.mShouldSwitchLauncher = false;
        this.mLastLauncherName = "com.android.launcher3";
        Utils.launchNewLauncher(this.mContext);
        goto L7
    }

    @Override // com.android.settings.base.BaseFragment
    public boolean onBackPressedSupport() {
        OLog.d(this.TAG, "onBackPressedSupport: mMasterSwitchChanged " + this.mMasterSwitchChanged + ", mShouldSwitchLauncher" + this.mShouldSwitchLauncher);
        if (this.mShouldSwitchLauncher == false) goto L9;
        if (this.mIsLauncherSwitched == true) goto L9;
        showDialog(4);
        return true;
    L9:
        return super.onBackPressedSupport();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        getContentResolver().unregisterContentObserver(this.mTalkbackObserver);
        getContentResolver().unregisterContentObserver(this.mSpeechReadingObserver);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.mHomeKeyReceiver);
        if (this.mIflytekSpeakerObserver == null) goto L6;
        getContentResolver().unregisterContentObserver(this.mIflytekSpeakerObserver);
        return;
    }

    private void enableConfirmed(boolean r3) {
        enableItems(this.mContext, r3);
        if (this.mChangeByShortCut == true) goto L5;
        Settings.Global.putInt(this.mContext.getContentResolver(), "accessibility_speech_reading", r3 ? 1 : 0);
    L5:
        updateView();
        if (r3 == true) goto L8;
        return;
    L8:
        if ("com.android.launcher3".equals(Utils.getDefaultLauncherPkg(this.mContext)) == true) goto L10;
        this.mShouldSwitchLauncher = true;
    L10:
        Utils.switchToOriginalLauncher(this.mContext);
    }

    private void setCopyrightInfo() {
        String r0 = getString(R.string.accessibility_speaker_copyright);
        SpannableStringBuilder r1 = new SpannableStringBuilder(r0);
        Matcher r2 = Pattern.compile("/iflytek/").matcher(r0);
    L4:
        if (r2.find() == false) goto L6;
        r1.setSpan(new ImageSpanAlignCenter(this.mContext, R.drawable.ic_iflytek), r2.start(), r2.end(), 33);
        goto L4
    L6:
        this.mTTSCopyrightTipsView.setText(r1);
    }

    private void showDialog(int r9) {
        Dialog r0 = this.mDialog;
        if (r0 == null) goto L6;
        r0.dismiss();
        this.mDialog = null;
    L6:
        if (r9 != 0) goto L8;
        AlertDialog.Builder r10 = new AlertDialog.Builder(getActivity());
        this.mShownDialogId = 0;
        View r1 = LayoutInflater.from(this._mActivity).inflate(R.layout.dialog_uninstall_layout, null);
        ((TextView) r1.findViewById(R.id.id_dlg_msg_tv)).setText(R.string.accessibility_enable_warning_first_time);
        r10.setTitle(getString(R.string.warning)).setIconAttribute(android.R.attr.alertDialogIcon).setView(r1).setCancelable(false).setPositiveButton(android.R.string.ok, this).setNegativeButton(android.R.string.cancel, this).setOnCancelListener(this).setOnDismissListener(this);
        this.mDialog = r10.create();
    L22:
        this.mDialog.show();
        return;
    L8:
        if (r9 != 1) goto L10;
        this.mShownDialogId = 1;
        AlertDialog.Builder r11 = new AlertDialog.Builder(getActivity());
        r11.setTitle(getString(R.string.enable_service_title, new Object[]{getString(R.string.accessibility_speech_reading)})).setIconAttribute(android.R.attr.alertDialogIcon).setView(createEnableDialogContentView()).setCancelable(false).setPositiveButton(android.R.string.ok, this).setNegativeButton(android.R.string.cancel, this).setOnCancelListener(this).setOnDismissListener(this);
        this.mDialog = r11.create();
        goto L22
    L10:
        if (r9 != 2) goto L12;
        this.mShownDialogId = 2;
        AlertDialog.Builder r12 = new AlertDialog.Builder(getActivity());
        r12.setTitle(getString(R.string.disable_service_title, new Object[]{getString(R.string.accessibility_speech_reading)})).setIconAttribute(android.R.attr.alertDialogIcon).setMessage(getString(R.string.disable_service_message, new Object[]{getString(R.string.accessibility_speech_reading)})).setCancelable(false).setPositiveButton(android.R.string.ok, this).setNegativeButton(android.R.string.cancel, this).setOnCancelListener(this).setOnDismissListener(this);
        this.mDialog = r12.create();
        goto L22
    L12:
        if (r9 != 3) goto L14;
        this.mShownDialogId = 3;
        AlertDialog.Builder r13 = new AlertDialog.Builder(getActivity());
        r13.setTitle(getString(R.string.launcher_switch_warning_title)).setIconAttribute(android.R.attr.alertDialogIcon).setMessage(getString(R.string.launcher_switch_verify_psw)).setCancelable(false).setPositiveButton(android.R.string.ok, this).setNegativeButton(android.R.string.cancel, this).setOnCancelListener(this).setOnDismissListener(this);
        this.mDialog = r13.create();
        goto L22
    L14:
        if (r9 != 4) goto L17;
        this.mShownDialogId = 4;
        AlertDialog.Builder r14 = new AlertDialog.Builder(getActivity());
        r14.setTitle(R.string.launcher_switch_warning_title);
        r14.setMessage(R.string.launcher_force_switch_content_speechreading);
        r14.setNegativeButton(R.string.cancel, this);
        r14.setPositiveButton(R.string.ok, this);
        this.mDialog = r14.create();
        goto L22
    L17:
        throw new IllegalArgumentException("dialog id is invalidated");
    }

    private AccessibilityServiceInfo getTalkBackServiceInfo() {
        List<AccessibilityServiceInfo> r0 = AccessibilityManager.getInstance(getActivity()).getInstalledAccessibilityServiceList();
        int r1 = r0.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        AccessibilityServiceInfo r3 = r0.get(r2);
        ResolveInfo r4 = r3.getResolveInfo();
        if (this.mTalkBackComponentName.getPackageName().equals(r4.serviceInfo.packageName) == false) goto L9;
        if (this.mTalkBackComponentName.getClassName().equals(r4.serviceInfo.name) == false) goto L9;
        return r3;
    L9:
        r2 = r2 + 1;
        goto L3
    L10:
        OLog.w(this.TAG, "getTalkBackServiceInfo: talkback not installed, please make sure that.");
        return null;
    }

    private View createEnableDialogContentView() {
        LayoutInflater r1 = (LayoutInflater) getActivity().getSystemService("layout_inflater");
        ViewGroup r3 = null;
        View r2 = r1.inflate(R.layout.enable_accessibility_service_dialog_content, null);
        ((TextView) r2.findViewById(R.id.capabilities_header)).setText(getString(R.string.capabilities_list_title, new Object[]{getString(R.string.accessibility_speech_reading)}));
        LinearLayout r4 = (LinearLayout) r2.findViewById(R.id.capabilities);
        int r5 = R.layout.app_permission_item_old;
        View r6 = r1.inflate(R.layout.app_permission_item_old, null);
        int r8 = R.id.perm_icon;
        ((ImageView) r6.findViewById(R.id.perm_icon)).setImageDrawable(getResources().getDrawable(android.R.drawable.pointer_wait_vector_21));
        int r9 = R.id.permission_group;
        ((TextView) r6.findViewById(R.id.permission_group)).setText(getString(R.string.capability_title_receiveAccessibilityEvents));
        int r10 = R.id.permission_list;
        ((TextView) r6.findViewById(R.id.permission_list)).setText(getString(R.string.capability_desc_receiveAccessibilityEvents));
        r4.addView(r6);
        ArrayList r7 = new ArrayList();
        addCustomPermissions(r7);
        int r12 = r7.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        AccessibilityServiceInfo.CapabilityInfo r14 = r7.get(r13);
        View r15 = r1.inflate(R.layout.app_permission_item_old, null);
        ((ImageView) r15.findViewById(r8)).setImageDrawable(getResources().getDrawable(android.R.drawable.pointer_wait_vector_21));
        ((TextView) r15.findViewById(R.id.permission_group)).setText(getString(r14.titleResId));
        ((TextView) r15.findViewById(R.id.permission_list)).setText(getString(r14.descResId));
        r4.addView(r15);
        r13 = r13 + 1;
        r8 = R.id.perm_icon;
        goto L3
    L5:
        View r11 = r1.inflate(R.layout.app_permission_item_old, null);
        ImageView r16 = (ImageView) r11.findViewById(R.id.perm_icon);
        TextView r17 = (TextView) r11.findViewById(R.id.permission_group);
        r17.setTextSize(2, 15.0f);
        r17.setText(getString(R.string.accessibility_permission_custom_func_disable));
        TextView r18 = (TextView) r11.findViewById(R.id.permission_list);
        r16.setVisibility(8);
        r18.setVisibility(8);
        r4.addView(r11);
        List<AccessibilityServiceInfo.CapabilityInfo> r19 = buildDisablePermissions();
        int r20 = r19.size();
        int r21 = getActivity().getResources().getDimensionPixelSize(R.dimen.selection_option_margin_bottom);
        int r110 = 0;
    L6:
        if (r110 >= r20) goto L11;
        AccessibilityServiceInfo.CapabilityInfo r111 = r19.get(r110);
        View r112 = r1.inflate(r5, r3);
        TextView r113 = (TextView) r112.findViewById(r9);
        r113.setText(getString(r111.titleResId));
        r113.setPadding(r113.getPaddingLeft(), r21, r113.getPaddingRight(), r113.getPaddingBottom());
        TextView r22 = (TextView) r112.findViewById(r10);
        r22.setText(getString(r111.descResId));
        r22.setVisibility(8);
        if (r110 != (r20 - 1)) goto L10;
        int r23 = getActivity().getResources().getDimensionPixelSize(R.dimen.accessibility_dialog_msg_padding_bottom);
        r22.setPadding(r22.getPaddingLeft(), r22.getPaddingTop(), r22.getPaddingRight(), r23);
        r113.setPadding(r113.getPaddingLeft(), r113.getPaddingTop(), r113.getPaddingRight(), r23);
    L10:
        r4.addView(r112);
        r110 = r110 + 1;
        r3 = null;
        r5 = R.layout.app_permission_item_old;
        r9 = R.id.permission_group;
        r10 = R.id.permission_list;
        goto L6
    L11:
        return r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void enableItems(Context r12, boolean r13) {
        ContentResolver r0 = r12.getContentResolver();
        int r2 = 0;
        int r3 = Settings.Global.getInt(r0, "accessibility_global_ocr", 0);
        PreferenceMgr r4 = PreferenceMgr.getInstance(r12);
        int r6 = Settings.Global.getInt(r0, "voice_command_state", 0);
        if (r4.getInt(PreferenceMgr.KEY_SPEECH_READING_LUNCHED, 0) != 1) goto L5;
        Object[] r8 = true;
    L6:
        if (r8 == true) goto L15;
        Settings.Global.putInt(r0, "voice_command_state", r13 ? 1 : 0);
        if (r4.getInt(PreferenceMgr.KEY_TALKBACK_ENABLED_IN_SUW, 0) != 0) goto L10;
        r4.putInt(PreferenceMgr.KEY_TALKBACK_ENABLED_IN_SUW, 1);
        enableTalkBack(r12, r13);
    L12:
        Settings.Global.putInt(r0, "accessibility_global_ocr", r13 ? 1 : 0);
        Settings.Global.putInt(r0, "accessibility_speech_reading", r13 ? 1 : 0);
        r4.putInt(PreferenceMgr.KEY_SPEECH_READING_LUNCHED, 1);
        r4.putInt(PreferenceMgr.KEY_SPEECH_READING_WARNING_SHOWN, 1);
        return;
    L10:
        if (r13 == true) goto L12;
        enableTalkBack(r12, false);
        goto L12
    L15:
        if (r13 == false) goto L17;
        boolean r14 = r4.getBoolean(PreferenceMgr.KEY_SPEECH_TALKBACK, true);
        int r5 = r4.getInt(PreferenceMgr.KEY_SPEECH_VOICE_COMMAND, 1);
        int r7 = r4.getInt(PreferenceMgr.KEY_SPEECH_GLOBAL_OCR, 1);
        r4.putInt(PreferenceMgr.KEY_SPEECH_READING_PROTECTION, 0);
        r2 = r5;
    L21:
        Settings.Global.putInt(r0, "voice_command_state", r2);
        enableTalkBack(r12, r14);
        Settings.Global.putInt(r0, "accessibility_global_ocr", r7);
        return;
    L17:
        if (r4.getInt(PreferenceMgr.KEY_SPEECH_READING_PROTECTION, 0) != 0) goto L19;
        r4.putBoolean(PreferenceMgr.KEY_SPEECH_TALKBACK, SettingsUtil.isAccessibilityEnabled(r12, Constants.PKG_TALK_BACK));
        r4.putInt(PreferenceMgr.KEY_SPEECH_VOICE_COMMAND, r6);
        r4.putInt(PreferenceMgr.KEY_SPEECH_GLOBAL_OCR, r3);
        r4.putInt(PreferenceMgr.KEY_SPEECH_READING_PROTECTION, 1);
    L19:
        r14 = false;
        r7 = 0;
        goto L21
    L5:
        r8 = false;
        goto L6
    }

    private static void enableTalkBack(Context r1, boolean r2) {
        if (Utils.isPackageInstalled(r1, Constants.PKG_TALK_BACK) == true) goto L5;
        return;
    L5:
        Utils.enableAccessibilityService(r1, "com.google.android.marvin.talkback/com.google.android.marvin.talkback.TalkBackService", r2);
    }

    private List<AccessibilityServiceInfo.CapabilityInfo> addCustomPermissions(List<AccessibilityServiceInfo.CapabilityInfo> r2) {
        SparseArray<AccessibilityServiceInfo.CapabilityInfo> r1 = sAvailableCapabilityInfos;
        r2.add(r1.get(1));
        r2.add(r1.get(2));
        r2.add(r1.get(4));
        r2.add(r1.get(8));
        r2.add(r1.get(64));
        r2.add(r1.get(128));
        return r2;
    }

    private List<AccessibilityServiceInfo.CapabilityInfo> buildDisablePermissions() {
        ArrayList r2 = new ArrayList();
        SparseArray<AccessibilityServiceInfo.CapabilityInfo> r0 = sAvailableCapabilityInfos;
        r2.add(r0.get(CAPABILITY_CAN_DISABLE_LAUNCHER));
        r2.add(r0.get(CAPABILITY_CAN_DISABLE_ONE_STEP));
        r2.add(r0.get(CAPABILITY_CAN_DISABLE_NAVBAR));
        return r2;
    }

    private void updateView() {
        if (isAdded() == true) goto L5;
        return;
    L5:
        ContentResolver r0 = this.mContext.getContentResolver();
        PreferenceMgr r1 = PreferenceMgr.getInstance(this.mContext);
        boolean r3 = false;
        this.mAccessibilityBlindState = Settings.Global.getInt(r0, "accessibility_speech_reading", 0);
        this.mIsTalkBackEnabled = SettingsUtil.isAccessibilityEnabled(this.mContext, Constants.PKG_TALK_BACK);
        this.mCurrentVoiceCommandState = Settings.Global.getInt(r0, "voice_command_state", 0);
        this.mCurrentGlobalOCRState = Settings.Global.getInt(r0, "accessibility_global_ocr", 0);
        if (r1.getInt(PreferenceMgr.KEY_SPEECH_READING_LUNCHED, 0) != 1) goto L8;
        boolean r2 = true;
    L9:
        this.mMasterSwitchChanged = r2;
        if (r1.getInt(PreferenceMgr.KEY_SPEECH_READING_WARNING_SHOWN, 0) != 1) goto L12;
    L15:
        boolean r4 = true;
    L16:
        this.mEnableWarningShown = r4;
        SettingItemSwitch r5 = this.mItemAccessibilitySwitch;
        if (this.mAccessibilityBlindState != 1) goto L19;
        boolean r6 = true;
    L20:
        r5.setChecked(r6);
        SettingItemText r7 = this.mItemTalkBack;
        boolean r8 = this.mIsTalkBackEnabled;
        int r9 = R.string.settings_state_on;
        if (r8 == false) goto L23;
        int r10 = R.string.settings_state_on;
    L24:
        r7.setSubTitle(r10);
        SettingItemSwitch r11 = this.mItemGlobalOCR;
        if (this.mCurrentGlobalOCRState != 1) goto L27;
        boolean r12 = true;
    L28:
        r11.setChecked(r12);
        if (SettingsFeature.isBytedanceAccessibilitySupport(this.mContext) == false) goto L42;
        SettingItemText r13 = this.mItemVoiceCommand;
        if (this.mCurrentVoiceCommandState == 1) goto L34;
        r9 = R.string.settings_state_off;
    L34:
        r13.setSubTitle(r9);
        SettingItemText r14 = this.mItemVoiceCommand;
        if (this.mAccessibilityBlindState != 1) goto L37;
        boolean r15 = true;
    L38:
        r14.setEnabled(r15);
        SettingItemSwitch r16 = this.mItemGlobalOCR;
        if (this.mAccessibilityBlindState != 1) goto L41;
        r3 = true;
    L41:
        r16.setEnabled(r3);
        goto L42
    L37:
        r15 = false;
    L42:
        updateOnExtDisplay(this.mIsExtDisplayConnected);
        return;
    L27:
        r12 = false;
        goto L28
    L23:
        r10 = R.string.settings_state_off;
        goto L24
    L19:
        r6 = false;
        goto L20
    L12:
        if (this.mMasterSwitchChanged == true) goto L15;
        r4 = false;
        goto L16
    L8:
        r2 = false;
        goto L9
    }

    private void updateOnExtDisplay(boolean r3) {
        this.mItemAccessibilitySwitch.setEnabled(!r3);
        SettingItemText r0 = this.mItemTalkBack;
        boolean r1 = true;
        if (this.mAccessibilityBlindState != 1) goto L6;
        if (r3 == true) goto L6;
    L7:
        r0.setEnabled(r1);
        return;
    L6:
        r1 = false;
        goto L7
    }

    private void updateSpeaker() {
        if (isAdded() == true) goto L5;
        return;
    L5:
        StringBuilder r0 = new StringBuilder();
        int r1 = Settings.Global.getInt(getContentResolver(), "ifly_speaker_index", 0);
        this.mDefaultSpeakerIndex = r1;
        r0.append(this.mSpeakerGenderInfos[r1]);
        r0.append(this.mSpeakerAccentInfos[this.mDefaultSpeakerIndex]);
        this.mItemAccessSpeaker.setSubTitle(r0.toString());
    }

    private boolean isRealCaptionOn() {
        if (Settings.Global.getInt(getContentResolver(), "hearing_real_caption", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_accessibility_AccessibilitySpeechReadingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AccessibilitySpeechReadingFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accessibility_AccessibilitySpeechReadingFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accessibility_AccessibilitySpeechReadingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AccessibilitySpeechReadingFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_accessibility_AccessibilitySpeechReadingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accessibility_AccessibilitySpeechReadingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AccessibilitySpeechReadingFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accessibility_AccessibilitySpeechReadingFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
