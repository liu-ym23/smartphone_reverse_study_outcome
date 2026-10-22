package com.android.settings;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserHandle;
import android.os.VibrationAttributes;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import bytedanceos.api.ActivityManagerSmt;
import com.android.settings.applications.utils.Item;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.applications.utils.OPopoverHelper;
import com.android.settings.applications.utils.XTSUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.UIUtils;
import com.android.settings.widget.VolumeSeekBar;
import com.android.settings.wifi.SoundWorkSettingsFragment;
import com.android.settingslib.RestrictedLockUtils;
import com.android.settingslib.RestrictedLockUtilsInternal;
import com.android.settingslib.applications.RecentAppOpsAccess;
import com.obric.olog.OLog;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.common.style.IOUILayout;
import com.obric.oui.common.style.OStateGradientDrawable;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.tab.OTabLayout;
import com.obric.oui.text.OTextView;
import com.obric.privacy.GrantUtil;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class SoundSettingsFragment extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private static final String DOUBAO_VOLUME_BAR_DISPLAY_SWITCH_ON = "doubao_volume_bar_display_switch_on";
    public static final String EXTRA_TYPE = "ringtone_type";
    public static final String GLOBAL_VIBRATION_ENABLED = "global_vibration_enabled";
    private static final String HIFI_ENABLE = "hifi_enable";
    private static final int MSG_UPDATE_ALARM_RINGTONE_SUMMARY = 3;
    private static final int MSG_UPDATE_CALENDAR_RINGTONE_SUMMARY = 4;
    private static final int MSG_UPDATE_DEFAULT_RINGTONE_SUMMARY = 5;
    private static final int MSG_UPDATE_PHONE_RINGTONE_SUB2_SUMMARY = 6;
    private static final int MSG_UPDATE_PHONE_RINGTONE_SUMMARY = 1;
    private static final int MSG_UPDATE_SMS_RINGTONE_SUB2_SUMMARY = 7;
    private static final int MSG_UPDATE_SMS_RINGTONE_SUMMARY = 2;
    private static final int MSG_VIBRATION_WHEN_INTENSITY_CHANGE = 8;
    public static final String NO_DISTURB_ON = "NoDisturbOn";
    private static final String TAG = "SoundSettingsFragment";
    public static final String TYPE_ALARM = "type_alarm";
    public static final String TYPE_CALENDAR = "type_calendar";
    private static final int TYPE_CLOSE = 0;
    public static final String TYPE_DEFAULT = "type_default";
    private static final int TYPE_HIGH = 3;
    private static final int TYPE_LOW = 1;
    private static final int TYPE_MID = 2;
    public static final String TYPE_MMS = "type_mms";
    public static final String TYPE_MMS_SUB2 = "type_mms_sub2";
    public static final String TYPE_RINGTONE = "type_ringtone";
    public static final String TYPE_RINGTONE_SUB2 = "type_ringtone_sub2";
    public static final String VIBRATION_ON_RING_SWITCH_ON = "vibration_on_ring_switch_on";
    private List<String> hapticFeedbackIntensityStrs;
    private VolumeSeekBar mAssistantVolumeBar;
    private AudioManager mAudioManager;
    private VolumeSeekBar mClockVolumeBar;
    private View mDoubaoVolumeBarContainer;
    private OCardListItem mDoubaoVolumeBarDisplaySwitch;
    private OCardListItem mDtsSoundEffectItem;
    private final Handler mHandler;
    private OCardListItem mHapticFeedback;
    private OPopover mHapticFeedbackPopMenu;
    private boolean mHasMultiSimInDevice;
    private OCardListItem mInputMethodHapticFeedback;
    private boolean mIsRingerModeSwitchClicked;
    private VolumeSeekBar mMediaVolumeBar;
    private boolean mMmsSub2RingtoneSameSub1;
    private OCardListItem mNoDisturb;
    private ContentObserver mNoDisturbObserver;
    private OTextView mNotificationTips;
    private VolumeSeekBar mNotificationVolumeBar;
    private OCardListItem mOtherAlertTone;
    private OCheckBox mRingModeCheckBox;
    private BroadcastReceiver mRingerModeReceiver;
    private Runnable mRingtoneLookupRunnable;
    private VolumeSeekBar mRingtoneVolumeBar;
    private boolean mShowSlot1;
    private boolean mShowSlot2;
    private OCheckBox mSilenceModeCheckBox;
    private final BroadcastReceiver mSimStateReceiver;
    private OCardListItem mSoundWorkSettingsItem;
    private boolean mSub2RingtoneSameSub1;
    private boolean mSupportMultiSim;
    private OCardListItem mVibrationIntensity;
    private OTabLayout mVibrationIntensityTabLayout;
    private OCheckBox mVibrationModeCheckBox;
    private OCardListItem mVibrationOnRingSwitch;
    private Vibrator mVibrator;
    private OCardListItem mViewAlarm;
    private OCardListItem mViewNotification;
    private OCardListItem mViewRing;
    private OCardListItem mViewRingSub2;
    private OCardListItem mViewSms;
    private OCardListItem mViewSmsSub2;
    private OCardListItem mVolumeButtonDefaultControlItem;
    private OPopover mVolumeButtonDefaultControlPopMenu;
    private VolumeSeekBar.Callback mVolumeSeekBarCallback;

    public void com_android_settings_SoundSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_SoundSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_SoundSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_SoundSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public SoundSettingsFragment() {
        this.mHasMultiSimInDevice = false;
        this.mSub2RingtoneSameSub1 = false;
        this.mMmsSub2RingtoneSameSub1 = false;
        this.mSupportMultiSim = false;
        this.mShowSlot1 = true;
        this.mShowSlot2 = false;
        this.hapticFeedbackIntensityStrs = new ArrayList();
        this.mHapticFeedbackPopMenu = null;
        this.mVolumeButtonDefaultControlPopMenu = null;
        this.mIsRingerModeSwitchClicked = false;
        this.mHandler = new AnonymousClass7(this);
        this.mSimStateReceiver = new AnonymousClass8(this);
        this.mRingerModeReceiver = new AnonymousClass9(this);
        final Handler r1 = new Handler();
        this.mNoDisturbObserver = new AnonymousClass10(this, r1);
    }

    static /* synthetic */ void access$000(SoundSettingsFragment r0, int r1) {
        r0.setVibrationIntensity(r1);
    }

    static /* synthetic */ Handler access$100(SoundSettingsFragment r0) {
        return r0.mHandler;
    }

    static /* synthetic */ OPopover access$1000(SoundSettingsFragment r0) {
        return r0.mHapticFeedbackPopMenu;
    }

    static /* synthetic */ OPopover access$1002(SoundSettingsFragment r0, OPopover r1) {
        r0.mHapticFeedbackPopMenu = r1;
        return r1;
    }

    static /* synthetic */ OCardListItem access$1100(SoundSettingsFragment r0) {
        return r0.mVolumeButtonDefaultControlItem;
    }

    static /* synthetic */ OPopover access$1200(SoundSettingsFragment r0) {
        return r0.mVolumeButtonDefaultControlPopMenu;
    }

    static /* synthetic */ OPopover access$1202(SoundSettingsFragment r0, OPopover r1) {
        r0.mVolumeButtonDefaultControlPopMenu = r1;
        return r1;
    }

    static /* synthetic */ OCardListItem access$1300(SoundSettingsFragment r0) {
        return r0.mViewRing;
    }

    static /* synthetic */ OCardListItem access$1400(SoundSettingsFragment r0) {
        return r0.mViewSms;
    }

    static /* synthetic */ OCardListItem access$1500(SoundSettingsFragment r0) {
        return r0.mViewAlarm;
    }

    static /* synthetic */ OCardListItem access$1600(SoundSettingsFragment r0) {
        return r0.mViewNotification;
    }

    static /* synthetic */ OCardListItem access$1700(SoundSettingsFragment r0) {
        return r0.mViewRingSub2;
    }

    static /* synthetic */ OCardListItem access$1800(SoundSettingsFragment r0) {
        return r0.mViewSmsSub2;
    }

    static /* synthetic */ void access$1900(SoundSettingsFragment r0) {
        r0.vibrateWhenIntensityChange();
    }

    static /* synthetic */ boolean access$200(SoundSettingsFragment r0) {
        return r0.mIsRingerModeSwitchClicked;
    }

    static /* synthetic */ void access$2000(SoundSettingsFragment r0) {
        r0.UpdateRingToneSettings();
    }

    static /* synthetic */ boolean access$202(SoundSettingsFragment r0, boolean r1) {
        r0.mIsRingerModeSwitchClicked = r1;
        return r1;
    }

    static /* synthetic */ Runnable access$2100(SoundSettingsFragment r0) {
        return r0.mRingtoneLookupRunnable;
    }

    static /* synthetic */ OCardListItem access$2200(SoundSettingsFragment r0) {
        return r0.mSoundWorkSettingsItem;
    }

    static /* synthetic */ OCardListItem access$2300(SoundSettingsFragment r0) {
        return r0.mNoDisturb;
    }

    static /* synthetic */ boolean access$300(SoundSettingsFragment r0) {
        return r0.mShowSlot1;
    }

    static /* synthetic */ void access$400(SoundSettingsFragment r0, String r1, int r2) {
        r0.updateRingtoneName(r1, r2);
    }

    static /* synthetic */ boolean access$500(SoundSettingsFragment r0) {
        return r0.mShowSlot2;
    }

    static /* synthetic */ AudioManager access$600(SoundSettingsFragment r0) {
        return r0.mAudioManager;
    }

    static /* synthetic */ void access$700(SoundSettingsFragment r0, int r1, String r2) {
        r0.onRingerModeChange(r1, r2);
    }

    static /* synthetic */ OCardListItem access$800(SoundSettingsFragment r0) {
        return r0.mHapticFeedback;
    }

    static /* synthetic */ List access$900(SoundSettingsFragment r0) {
        return r0.hapticFeedbackIntensityStrs;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        this.mRootView = r9.inflate(R.layout.sound_settings_layout, r10, false);
        this.mAudioManager = (AudioManager) this.mContext.getSystemService("audio");
        this.mVibrator = (Vibrator) this.mContext.getSystemService("vibrator");
        OCardListItem r12 = (OCardListItem) findViewByIdNullable(R.id.item_noDisturb);
        this.mNoDisturb = r12;
        r12.setOnContentClickListener(this);
        OCardListItem r13 = (OCardListItem) findViewByIdNullable(R.id.vibrate_on_ring);
        this.mVibrationOnRingSwitch = r13;
        r13.getContentContainer().setClickable(false);
        OCardListItem r14 = (OCardListItem) findViewByIdNullable(R.id.vibration_intensity);
        this.mVibrationIntensity = r14;
        r14.getContentContainer().setClickable(false);
        View r15 = UIUtils.buildNoScaledView(this.mContext, R.layout.vibration_intensity_layout);
        OTabLayout r16 = (OTabLayout) r15.findViewById(R.id.vibration_intensity_tab_layout);
        this.mVibrationIntensityTabLayout = r16;
        KeyEvent.Callback r17 = r16.getChildAt(0);
        if ((r17 instanceof IOUILayout) == false) goto L5;
        ((IOUILayout) r17).setShadowStyle(2132018477);
    L5:
        int r18 = getNotificationVibrationIntensity();
        if (r18 > 0) goto L8;
        r18 = 3;
    L8:
        this.mVibrationIntensityTabLayout.selectTab(r18 - 1);
        this.mVibrationIntensityTabLayout.addOnTabSelectedListener(new AnonymousClass1(this));
        this.mVibrationIntensity.setCustomEndView(r15);
        this.mVibrationIntensity.showCustomEnd(true);
        this.mSupportMultiSim = Utils.isMultiSimSupport();
        VolumeSeekBar r19 = (VolumeSeekBar) findViewByIdNullable(R.id.media_volume);
        this.mMediaVolumeBar = r19;
        r19.setStream(3);
        VolumeSeekBar r20 = (VolumeSeekBar) findViewByIdNullable(R.id.ringtone_volume);
        this.mRingtoneVolumeBar = r20;
        r20.setStream(2);
        VolumeSeekBar r21 = (VolumeSeekBar) findViewByIdNullable(R.id.notification_volume);
        this.mNotificationVolumeBar = r21;
        r21.setStream(5);
        OTextView r22 = (OTextView) findViewByIdNullable(R.id.notification_tips);
        this.mNotificationTips = r22;
        if (isSilentMode() == false) goto L11;
        int r1 = 0;
    L12:
        r22.setVisibility(r1);
        VolumeSeekBar r23 = (VolumeSeekBar) findViewByIdNullable(R.id.clock_volume);
        this.mClockVolumeBar = r23;
        r23.setStream(4);
        VolumeSeekBar r24 = (VolumeSeekBar) findViewByIdNullable(R.id.assistant_volume);
        this.mAssistantVolumeBar = r24;
        r24.setStream(11);
        if (Utils.isMonkeyRunning() == true) goto L15;
        this.mMediaVolumeBar.initVolumizer();
        this.mRingtoneVolumeBar.initVolumizer();
        this.mRingtoneVolumeBar.setRingerModeSwitchClickStatusProvider(new AnonymousClass2(this));
        this.mNotificationVolumeBar.initVolumizer();
        this.mClockVolumeBar.initVolumizer();
        this.mAssistantVolumeBar.initVolumizer();
    L15:
        OCardListItem r25 = (OCardListItem) findViewByIdNullable(R.id.item_id_phone_ring);
        this.mViewRing = r25;
        OCardListItemUtils.setDefaultCustomStartView(r25, R.layout.card_list_item_custom_start_layout, getString(R.string.sound_settings_text_phone_ring), R.drawable.settings_oic_card_1_fill);
        this.mViewRing.showCustomStart(false);
        this.mViewRing.setOnContentClickListener(this);
        OCardListItem r26 = (OCardListItem) findViewByIdNullable(R.id.item_id_phone_ring_sub2);
        this.mViewRingSub2 = r26;
        OCardListItemUtils.setDefaultCustomStartView(r26, R.layout.card_list_item_custom_start_layout, getString(R.string.sound_settings_text_phone_ring), R.drawable.settings_oic_card_2_fill);
        this.mViewRingSub2.showCustomStart(false);
        this.mViewRingSub2.setOnContentClickListener(this);
        OCardListItem r27 = (OCardListItem) findViewByIdNullable(R.id.item_id_sms_ring);
        this.mViewSms = r27;
        OCardListItemUtils.setDefaultCustomStartView(r27, R.layout.card_list_item_custom_start_layout, getString(R.string.sound_settings_text_sms_ring), R.drawable.settings_oic_card_1_fill);
        this.mViewSms.showCustomStart(false);
        this.mViewSms.setOnContentClickListener(this);
        OCardListItem r28 = (OCardListItem) findViewByIdNullable(R.id.item_id_sms_ring_sub2);
        this.mViewSmsSub2 = r28;
        OCardListItemUtils.setDefaultCustomStartView(r28, R.layout.card_list_item_custom_start_layout, getString(R.string.sound_settings_text_sms_ring), R.drawable.settings_oic_card_2_fill);
        this.mViewSmsSub2.showCustomStart(false);
        this.mViewSmsSub2.setOnContentClickListener(this);
        OCardListItem r29 = (OCardListItem) findViewByIdNullable(R.id.item_id_notification_ring);
        this.mViewNotification = r29;
        r29.setOnContentClickListener(this);
        OCardListItem r30 = (OCardListItem) findViewByIdNullable(R.id.item_id_alarm_ring);
        this.mViewAlarm = r30;
        r30.setOnContentClickListener(this);
        OCardListItem r31 = (OCardListItem) findViewByIdNullable(R.id.other_alert_tone);
        this.mOtherAlertTone = r31;
        r31.setOnContentClickListener(this);
        this.hapticFeedbackIntensityStrs.add(getString(R.string.close_haptic_feedback));
        this.hapticFeedbackIntensityStrs.add(getString(R.string.low_haptic_feedback_intensity));
        this.hapticFeedbackIntensityStrs.add(getString(R.string.mid_haptic_feedback_intensity));
        this.hapticFeedbackIntensityStrs.add(getString(R.string.high_haptic_feedback_intensity));
        OCardListItem r32 = (OCardListItem) findViewByIdNullable(R.id.haptic_feedback);
        this.mHapticFeedback = r32;
        r32.setOnContentClickListener(this);
        OCardListItem r33 = (OCardListItem) findViewByIdNullable(R.id.input_method_haptic_feedback);
        this.mInputMethodHapticFeedback = r33;
        r33.setOnContentClickListener(this);
        OCardListItem r34 = (OCardListItem) findViewByIdNullable(R.id.dts_sound_effect_item);
        this.mDtsSoundEffectItem = r34;
        if (SettingsFeature.isSupportNubiaShare() == false) goto L18;
        int r2 = 0;
    L19:
        r34.setVisibility(r2);
        this.mSoundWorkSettingsItem = (OCardListItem) findViewByIdNullable(R.id.sound_work_settings_item);
        if (SoundWorkSettingsFragment.isSupportWorkProfileSound(this.mContext) == false) goto L22;
        this.mSoundWorkSettingsItem.setVisibility(0);
    L22:
        this.mSoundWorkSettingsItem.setOnContentClickListener(this);
        if (Utils.hasTelephonyFeature(this.mContext) == true) goto L25;
        this.mViewRing.setVisibility(8);
        this.mViewRingSub2.setVisibility(8);
        this.mViewSms.setVisibility(8);
        this.mViewSmsSub2.setVisibility(8);
        this.mViewNotification.setCardPosition(1);
    L27:
        if (android.provider.Settings.Global.getInt(this.mContext.getContentResolver(), "volume_key_function", 3) != 2) goto L29;
        boolean r35 = true;
    L30:
        OCardListItem r110 = (OCardListItem) findViewByIdNullable(R.id.volume_button_default_control_item);
        this.mVolumeButtonDefaultControlItem = r110;
        if (r35 == false) goto L33;
        String r36 = getString(R.string.vol_key_default_ringtone);
    L34:
        OCardListItemUtils.setCustomEndTipTextView(r110, r36);
        this.mVolumeButtonDefaultControlItem.setOnContentClickListener(this);
        ((FrameLayout) findViewById(R.id.banner)).addView(UIUtils.buildNoScaledView(this._mActivity, R.layout.view_banner_sound_mode));
        OUILinearLayout r37 = (OUILinearLayout) findViewById(R.id.ring_mode_container);
        r37.setBackground(genRingerModeContainerBgDrawable());
        r37.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        r37.setClipToOutline(true);
        OCheckBox r111 = (OCheckBox) findViewByIdNullable(R.id.ring_mode_checkbox);
        this.mRingModeCheckBox = r111;
        r111.setClickable(false);
        OUILinearLayout r112 = (OUILinearLayout) findViewByIdNullable(R.id.vibration_mode_container);
        r112.setBackground(genRingerModeContainerBgDrawable());
        r112.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        r112.setClipToOutline(true);
        OCheckBox r3 = (OCheckBox) findViewByIdNullable(R.id.vibration_mode_checkbox);
        this.mVibrationModeCheckBox = r3;
        r3.setClickable(false);
        OUILinearLayout r4 = (OUILinearLayout) findViewByIdNullable(R.id.silence_mode_container);
        r4.setBackground(genRingerModeContainerBgDrawable());
        r4.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        r4.setClipToOutline(true);
        OCheckBox r5 = (OCheckBox) findViewByIdNullable(R.id.silence_mode_checkbox);
        this.mSilenceModeCheckBox = r5;
        r5.setClickable(false);
        onRingerModeChange(this.mAudioManager.getRingerModeInternal(), "init");
        r37.setOnClickListener(genRingerModeContainerOnClickListener(2));
        r112.setOnClickListener(genRingerModeContainerOnClickListener(1));
        r4.setOnClickListener(genRingerModeContainerOnClickListener(0));
        this.mDoubaoVolumeBarDisplaySwitch = (OCardListItem) findViewByIdNullable(R.id.doubao_volume_bar_display_switch);
        this.mDoubaoVolumeBarContainer = findViewByIdNullable(R.id.doubao_volume_bar_container);
        this.mRingtoneLookupRunnable = new AnonymousClass3(this);
        UIUtils.setUpFakeStatusBarOnApplyWindowInsets(this.mRootView.findViewById(R.id.fake_status_bar));
        UIUtils.setUpBottomPaddingOnApplyWindowInsets((ViewGroup) this.mRootView.findViewById(R.id.page_container));
        this.mContext.getContentResolver().registerContentObserver(android.provider.Settings.Secure.getUriFor("NoDisturbOn"), true, this.mNoDisturbObserver);
        IntentFilter r38 = new IntentFilter();
        r38.addAction("android.media.RINGER_MODE_CHANGED");
        r38.addAction("android.media.INTERNAL_RINGER_MODE_CHANGED_ACTION");
        r38.addAction("android.intent.action.MANAGED_PROFILE_ADDED");
        r38.addAction("android.intent.action.MANAGED_PROFILE_REMOVED");
        registerReceiver(this.mRingerModeReceiver, r38);
        return this.mRootView;
    L33:
        r36 = getString(R.string.vol_key_default_media);
        goto L34
    L29:
        r35 = false;
        goto L30
    L25:
        this.mViewNotification.setCardPosition(2);
        goto L27
    L18:
        r2 = 8;
        goto L19
    L11:
        r1 = 8;
        goto L12
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r2) {
        super.onViewStateRestored(r2);
        updateViews();
        this.mVibrationOnRingSwitch.getEndSwitch().setOnCheckedChangeListener(this);
        this.mVibrationOnRingSwitch.getEndSwitch().setChecked(isVibrationOnRingSwitchOn());
        this.mDoubaoVolumeBarDisplaySwitch.getEndSwitch().setChecked(isDoubaoVolumeBarDisplaySwitchOn());
        this.mDoubaoVolumeBarDisplaySwitch.getEndSwitch().setOnCheckedChangeListener(this);
    }

    private boolean isVibrationOnRingSwitchOn() {
        if (android.provider.Settings.System.getInt(getContentResolver(), VIBRATION_ON_RING_SWITCH_ON, 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void onVibrationOnRingSwitchCheckedChange(boolean r3) {
        android.provider.Settings.System.putInt(getContentResolver(), VIBRATION_ON_RING_SWITCH_ON, r3 ? 1 : 0);
        if (this.mAudioManager.getRingerModeInternal() != 2) goto L13;
        if (r3 == false) goto L11;
        setGlobalVibrationEnabled(true);
        int r0 = getNotificationVibrationIntensity();
        if (r0 > 0) goto L8;
        r0 = 3;
    L8:
        setVibrationIntensity(r0);
        OTabLayout r2 = this.mVibrationIntensityTabLayout;
        if (r2 == null) goto L14;
        r2.selectTab(r0 - 1);
        return;
    L14:
        return;
    L11:
        setGlobalVibrationEnabled(false);
        android.provider.Settings.System.putInt(getContentResolver(), "ring_vibration_intensity", 0);
        return;
    }

    private void vibrateWhenIntensityChange() {
        VibrationEffect r0 = VibrationEffect.createOneShot(200, -1);
        VibrationAttributes r1 = new VibrationAttributes.Builder().setUsage(33).build();
        this.mVibrator.vibrate(r0, r1);
    }

    private boolean isDoubaoVolumeBarDisplaySwitchOn() {
        if (android.provider.Settings.System.getInt(getContentResolver(), DOUBAO_VOLUME_BAR_DISPLAY_SWITCH_ON, 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void onDoubaoVolumeBarDisplaySwitchCheckedChange(boolean r2) {
        android.provider.Settings.System.putInt(getContentResolver(), DOUBAO_VOLUME_BAR_DISPLAY_SWITCH_ON, r2 ? 1 : 0);
    }

    private Drawable genRingerModeContainerBgDrawable() {
        OStateGradientDrawable r0 = new OStateGradientDrawable();
        r0.setSolidColors(this.mContext.getResources().getColorStateList(R.color.o_card_list_item_content_bg_color));
        r0.setCornerRadius(UIUtils.INSTANCE.dp2px(12));
        return r0;
    }

    private View.OnClickListener genRingerModeContainerOnClickListener(final int r2) {
        return new AnonymousClass4(this, r2);
    }

    private void onRingerModeChange(int r5, String r6) {
        OLog.i(TAG, "onRingerModeChange, ringerMode: " + r5 + ", changeSource: " + r6);
        OCheckBox r7 = this.mRingModeCheckBox;
        boolean r0 = false;
        if (r5 != 2) goto L5;
        boolean r3 = true;
    L6:
        r7.setChecked(r3);
        OCheckBox r8 = this.mVibrationModeCheckBox;
        if (r5 != 1) goto L9;
        boolean r4 = true;
    L10:
        r8.setChecked(r4);
        OCheckBox r9 = this.mSilenceModeCheckBox;
        if (r5 != 0) goto L13;
        boolean r10 = true;
    L14:
        r9.setChecked(r10);
        if (r5 != 2) goto L20;
        this.mNotificationTips.setVisibility(8);
        this.mNotificationVolumeBar.setEnabled(true);
        if (isVibrationOnRingSwitchOn() == false) goto L19;
        setGlobalVibrationEnabled(true);
        return;
    L19:
        setGlobalVibrationEnabled(false);
        return;
    L20:
        this.mNotificationTips.setVisibility(0);
        this.mNotificationVolumeBar.setEnabled(false);
        if (r5 != 1) goto L23;
        r0 = true;
    L23:
        setGlobalVibrationEnabled(r0);
        if (r5 != 1) goto L34;
        int r11 = getNotificationVibrationIntensity();
        if (r11 > 0) goto L28;
        r11 = 3;
    L28:
        setVibrationIntensity(r11);
        OTabLayout r12 = this.mVibrationIntensityTabLayout;
        if (r12 == null) goto L35;
        r12.selectTab(r11 - 1);
        return;
    L35:
        return;
    L34:
        return;
    L13:
        r10 = false;
        goto L14
    L9:
        r4 = false;
        goto L10
    L5:
        r3 = false;
        goto L6
    }

    private int getNotificationVibrationIntensity() {
        return android.provider.Settings.System.getInt(getContentResolver(), "notification_vibration_intensity", 3);
    }

    private void setVibrationIntensity(int r3) {
        android.provider.Settings.System.putInt(getContentResolver(), "notification_vibration_intensity", r3);
        android.provider.Settings.System.putInt(getContentResolver(), "ring_vibration_intensity", r3);
    }

    private void setGlobalVibrationEnabled(boolean r2) {
        android.provider.Settings.Global.putInt(getContentResolver(), GLOBAL_VIBRATION_ENABLED, r2 ? 1 : 0);
    }

    private void updateHapticFeedbackState() {
        int r0 = getHapticFeedbackIntensity();
        if (r0 != 0) goto L6;
        String r1 = getString(R.string.close_haptic_feedback);
    L16:
        if (TextUtils.isEmpty(r1) == true) goto L19;
        OCardListItemUtils.setCustomEndTipTextView(this.mHapticFeedback, r1);
        return;
    L19:
        return;
    L6:
        if (r0 != 1) goto L9;
        r1 = getString(R.string.low_haptic_feedback_intensity);
        goto L16
    L9:
        if (r0 != 2) goto L12;
        r1 = getString(R.string.mid_haptic_feedback_intensity);
        goto L16
    L12:
        if (r0 != 3) goto L14;
        r1 = getString(R.string.high_haptic_feedback_intensity);
        goto L16
    L14:
        r1 = "";
        goto L16
    }

    @Override // com.android.settings.base.BaseFragment
    public boolean onKeyDown(int r4, KeyEvent r5) {
        if (r4 != 24) goto L5;
    L8:
        VolumeSeekBar[] r6 = {this.mMediaVolumeBar, this.mRingtoneVolumeBar, this.mNotificationVolumeBar, this.mClockVolumeBar, this.mAssistantVolumeBar};
        int r3 = 0;
    L9:
        if (r3 >= 5) goto L14;
        VolumeSeekBar r0 = r6[r3];
        if (r0 == null) goto L13;
        r0.onHardwareVolumeKeyPressed();
    L13:
        r3 = r3 + 1;
        goto L9
    L14:
        return false;
    L5:
        if (r4 == 25) goto L8;
        return super.onKeyDown(r4, r5);
    }

    public void updateViews() {
        int r0 = android.provider.Settings.Secure.getInt(getContext().getContentResolver(), "NoDisturbOn", 0);
        OCardListItem r1 = this.mNoDisturb;
        if (r0 != 0) goto L5;
        int r2 = R.string.settings_state_off;
    L6:
        OCardListItemUtils.setCustomEndTipTextView(r1, getString(r2));
        if (this.mSupportMultiSim == false) goto L9;
        registerReceiver(this.mSimStateReceiver, new IntentFilter("android.intent.action.SIM_STATE_CHANGED"));
        UpdateRingToneSettings();
    L9:
        ExecutorManager.execute(this.mRingtoneLookupRunnable);
        updateHapticFeedbackState();
        this.mAudioManager.forceVolumeControlStream(android.provider.Settings.Global.getInt(this.mContext.getContentResolver(), "volume_key_function", 3));
        this.mMediaVolumeBar.onResume();
        this.mRingtoneVolumeBar.onResume();
        this.mNotificationVolumeBar.onResume();
        this.mClockVolumeBar.onResume();
        this.mAssistantVolumeBar.onResume();
        this.mNotificationVolumeBar.setEnabled(!isSilentMode());
        processWhenDisallowAdjustVolume();
        return;
    L5:
        r2 = R.string.settings_state_on;
        goto L6
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    private void processWhenDisallowAdjustVolume() {
        if (XTSUtils.isInXtsMode() == true) goto L5;
        return;
    L5:
        RestrictedLockUtils.EnforcedAdmin r0 = RestrictedLockUtilsInternal.checkIfRestrictionEnforced(this.mContext, "no_adjust_volume", UserHandle.myUserId());
        boolean r1 = RestrictedLockUtilsInternal.hasBaseUserRestriction(this.mContext, "no_adjust_volume", UserHandle.myUserId());
        if (r0 == null) goto L9;
        if (r1 == true) goto L9;
        boolean r2 = true;
    L10:
        setVolumeDisallowedByAdmin(this.mMediaVolumeBar, r2, r0);
        setVolumeDisallowedByAdmin(this.mAssistantVolumeBar, r2, r0);
        setVolumeDisallowedByAdmin(this.mRingtoneVolumeBar, r2, r0);
        setVolumeDisallowedByAdmin(this.mNotificationVolumeBar, r2, r0);
        setVolumeDisallowedByAdmin(this.mClockVolumeBar, r2, r0);
        return;
    L9:
        r2 = false;
        goto L10
    }

    private void setVolumeDisallowedByAdmin(VolumeSeekBar r3, boolean r4, final RestrictedLockUtils.EnforcedAdmin r5) {
        r3.getSeekBar().setEnabled(!r4);
        ViewGroup r6 = (ViewGroup) r3.getParent().getParent();     // Catch: Exception -> L12
        if (r4 == true) goto L6;
        float r0 = 1.0f;
    L7:
        r6.setAlpha(r0);     // Catch: Exception -> L12
        if (r4 == false) goto L10;
        r6.setOnClickListener(new SoundSettingsFragment$$ExternalSyntheticLambda0(this, r5));     // Catch: Exception -> L12
        r6.setClickable(true);     // Catch: Exception -> L12
    L15:
        return;
    L10:
        r6.setOnClickListener(null);     // Catch: Exception -> L12
        r6.setClickable(false);     // Catch: Exception -> L12
        goto L15
    L6:
        r0 = 0.3f;
    L12:
        e = move-exception;
        OLog.e(TAG, "setVolumeDisallowedByAdmin failed, error_msg: " + e);
    }

    /* JADX INFO: renamed from: lambda$setVolumeDisallowedByAdmin$0$com-android-settings-SoundSettingsFragment, reason: not valid java name */
    /* synthetic */ void m210xa4f8e81b(RestrictedLockUtils.EnforcedAdmin r1, View r2) {
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(this.mContext, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.mSupportMultiSim == false) goto L5;
        unregisterReceiver(this.mSimStateReceiver);
    L5:
        this.mAudioManager.forceVolumeControlStream(-1);
        this.mVibrator.cancel();
        this.mMediaVolumeBar.onPause();
        this.mRingtoneVolumeBar.onPause();
        this.mNotificationVolumeBar.onPause();
        this.mClockVolumeBar.onPause();
        this.mAssistantVolumeBar.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (Utils.isMonkeyRunning() == true) goto L5;
        this.mMediaVolumeBar.stopVolumizer();
        this.mRingtoneVolumeBar.stopVolumizer();
        this.mNotificationVolumeBar.stopVolumizer();
        this.mClockVolumeBar.stopVolumizer();
        this.mAssistantVolumeBar.stopVolumizer();
    L5:
        this.mMediaVolumeBar.onDestroy();
        this.mRingtoneVolumeBar.onDestroy();
        this.mNotificationVolumeBar.onDestroy();
        this.mClockVolumeBar.onDestroy();
        this.mAssistantVolumeBar.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        this.mContext.getContentResolver().unregisterContentObserver(this.mNoDisturbObserver);
        unregisterReceiver(this.mRingerModeReceiver);
    }

    public static Bundle prepareRingtonePickerIntent(String r6, String r7) {
        Bundle r0 = new Bundle();
        r0.putBoolean("android.intent.extra.ringtone.SHOW_DEFAULT", false);
        if (TYPE_RINGTONE.equals(r7) == false) goto L5;
    L11:
        r0.putParcelable("android.intent.extra.ringtone.DEFAULT_URI", RingtoneManager.getDefaultUri(1));
        r0.putInt("android.intent.extra.ringtone.TYPE", 1);
    L12:
        r0.putBoolean("android.intent.extra.ringtone.SHOW_SILENT", true);
        r0.putString("title", r6);
        r0.putString(EXTRA_TYPE, r7);
        return r0;
    L5:
        if (TYPE_RINGTONE_SUB2.equals(r7) == true) goto L11;
        if (TYPE_ALARM.equals(r7) == false) goto L10;
        r0.putParcelable("android.intent.extra.ringtone.DEFAULT_URI", RingtoneManager.getDefaultUri(4));
        r0.putInt("android.intent.extra.ringtone.TYPE", 4);
        goto L12
    L10:
        r0.putParcelable("android.intent.extra.ringtone.DEFAULT_URI", RingtoneManager.getDefaultUri(2));
        r0.putInt("android.intent.extra.ringtone.TYPE", 2);
        goto L12
    }

    public static void prepareRingtonePickerIntent(Fragment r6, String r7, String r8) {
        Bundle r0 = new Bundle();
        r0.putBoolean("android.intent.extra.ringtone.SHOW_DEFAULT", false);
        if (TYPE_RINGTONE.equals(r8) == false) goto L5;
    L11:
        r0.putParcelable("android.intent.extra.ringtone.DEFAULT_URI", RingtoneManager.getDefaultUri(1));
        r0.putInt("android.intent.extra.ringtone.TYPE", 1);
    L12:
        r0.putBoolean("android.intent.extra.ringtone.SHOW_SILENT", true);
        r0.putString("title", r7);
        r0.putString(EXTRA_TYPE, r8);
        r6.setArguments(r0);
        return;
    L5:
        if (TYPE_RINGTONE_SUB2.equals(r8) == true) goto L11;
        if (TYPE_ALARM.equals(r8) == false) goto L10;
        r0.putParcelable("android.intent.extra.ringtone.DEFAULT_URI", RingtoneManager.getDefaultUri(4));
        r0.putInt("android.intent.extra.ringtone.TYPE", 4);
        goto L12
    L10:
        r0.putParcelable("android.intent.extra.ringtone.DEFAULT_URI", RingtoneManager.getDefaultUri(2));
        r0.putInt("android.intent.extra.ringtone.TYPE", 2);
        goto L12
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r5) {
        Intent r0 = new Intent();
        if (this.mTitleResId == null) goto L6;
        r0.putExtra("back_text_id", this.mTitleResId);
    L6:
        if (r5 != this.mNoDisturb.getContentContainer()) goto L12;
        r0.putExtra(Utils.EXTRA_FROM_SETTINGS, true);     // Catch: Exception -> L9
        r0.setAction("com.obric.nodisturb.NoDisturb");     // Catch: Exception -> L9
        r0.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);     // Catch: Exception -> L9
        Utils.startActivity(this._mActivity, r0);     // Catch: Exception -> L9
        SettingsTracker.onItemClick(19);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L12:
        if (r5 != this.mViewRing.getContentContainer()) goto L15;
        r0.putExtras(prepareRingtonePickerIntent(getString(R.string.sound_settings_text_phone_ring), TYPE_RINGTONE));
        r0.setClass(this.mContext, RingtoneSettingsActivity.class);
        Utils.startActivity(this._mActivity, r0);
        SettingsTracker.onItemClick(1205);
        return;
    L15:
        if (r5 != this.mViewSms.getContentContainer()) goto L18;
        r0.putExtras(prepareRingtonePickerIntent(getString(R.string.sound_settings_text_sms_ring), TYPE_MMS));
        r0.setClass(this.mContext, RingtoneSettingsActivity.class);
        Utils.startActivity(this._mActivity, r0);
        SettingsTracker.onItemClick(1207);
        return;
    L18:
        if (r5 != this.mViewAlarm.getContentContainer()) goto L21;
        r0.putExtras(prepareRingtonePickerIntent(getString(R.string.sound_settings_text_alarm_ring), TYPE_ALARM));
        r0.setClass(this.mContext, RingtoneSettingsActivity.class);
        Utils.startActivity(this._mActivity, r0);
        return;
    L21:
        if (r5 != this.mViewNotification.getContentContainer()) goto L24;
        r0.putExtras(prepareRingtonePickerIntent(getString(R.string.sound_settings_text_default_ring), TYPE_DEFAULT));
        r0.setClass(this.mContext, RingtoneSettingsActivity.class);
        Utils.startActivity(this._mActivity, r0);
        SettingsTracker.onItemClick(1212);
        return;
    L24:
        if (r5 != this.mViewRingSub2.getContentContainer()) goto L27;
        r0.putExtras(prepareRingtonePickerIntent(getString(R.string.sound_settings_text_phone_ring), TYPE_RINGTONE_SUB2));
        r0.setClass(this.mContext, RingtoneSettingsActivity.class);
        Utils.startActivity(this._mActivity, r0);
        SettingsTracker.onItemClick(1206);
        return;
    L27:
        if (r5 != this.mViewSmsSub2.getContentContainer()) goto L30;
        r0.putExtras(prepareRingtonePickerIntent(getString(R.string.sound_settings_text_sms_ring), TYPE_MMS_SUB2));
        r0.setClass(this.mContext, RingtoneSettingsActivity.class);
        Utils.startActivity(this._mActivity, r0);
        SettingsTracker.onItemClick(1208);
        return;
    L30:
        if (r5 != this.mOtherAlertTone.getContentContainer()) goto L33;
        r0.setClass(this.mContext, OtherAlertToneActivity.class);
        Utils.startActivity(this._mActivity, r0);
        return;
    L33:
        if (r5 != this.mHapticFeedback.getContentContainer()) goto L36;
        showHapticFeedbackPopMenu();
        return;
    L36:
        if (r5 != this.mInputMethodHapticFeedback.getContentContainer()) goto L42;
        r0.setClassName("com.bytedance.android.doubaoime", "com.bytedance.android.doubaoime.activity.SettingsActivityNext");     // Catch: Exception -> L39
        r0.putExtra("EXTRA_FRAGMENT_TYPE", "KEY_FEEDBACK");     // Catch: Exception -> L39
        r0.setFlags(536903680);     // Catch: Exception -> L39
        Utils.startActivity(this._mActivity, r0);     // Catch: Exception -> L39
        return;
    L39:
        e = move-exception;
        e.printStackTrace();
        return;
    L42:
        if (r5 != this.mVolumeButtonDefaultControlItem.getContentContainer()) goto L45;
        showVolumeButtonDefaultControlPopMenu();
        return;
    L45:
        if (r5 != this.mSoundWorkSettingsItem.getContentContainer()) goto L63;
        start(SoundWorkSettingsFragment.class);
        return;
    }

    private int getHapticFeedbackIntensity() {
        return android.provider.Settings.System.getInt(getContext().getContentResolver(), "haptic_feedback_intensity", 3);
    }

    private void showHapticFeedbackPopMenu() {
        ArrayList r0 = new ArrayList();
        final int r1 = getHapticFeedbackIntensity();
        int r3 = 0;
    L3:
        boolean r5 = true;
        if (r3 >= this.hapticFeedbackIntensityStrs.size()) goto L10;
        String r6 = this.hapticFeedbackIntensityStrs.get(r3);
        if (r1 == r3) goto L9;
        r5 = false;
    L9:
        r0.add(new Item(r6, r5));
        r3 = r3 + 1;
        goto L3
    L10:
        FragmentActivity r2 = getActivity();
        if (r2 != null) goto L14;
        OLog.e(TAG, "showHapticFeedbackPopMenu, activity is null, return");
        return;
    L14:
        this.mHapticFeedbackPopMenu = OPopoverHelper.showPopoverList(r2, this.mHapticFeedback, r0, new AnonymousClass5(this, r1), true);
    }

    private void showVolumeButtonDefaultControlPopMenu() {
        ArrayList r0 = new ArrayList();
        if (android.provider.Settings.Global.getInt(this.mContext.getContentResolver(), "volume_key_function", 3) != 2) goto L5;
        boolean r1 = true;
    L6:
        r0.add(new Item(getString(R.string.vol_key_default_ringtone), r1));
        r0.add(new Item(getString(R.string.vol_key_default_media), !r1));
        FragmentActivity r2 = getActivity();
        if (r2 != null) goto L10;
        OLog.e(TAG, "showVolumeButtonDefaultControlPopMenu, activity is null, return");
        return;
    L10:
        this.mVolumeButtonDefaultControlPopMenu = OPopoverHelper.showPopoverList(r2, this.mVolumeButtonDefaultControlItem, r0, new AnonymousClass6(this), true);
        return;
    L5:
        r1 = false;
        goto L6
    }

    private void updateRingtoneName(String r8, int r9) {
        if (isAdded() == true) goto L5;
        return;
    L5:
        CharSequence r10 = getRingtoneName(this.mContext, r8, this.mSupportMultiSim, this.mHasMultiSimInDevice, this.mSub2RingtoneSameSub1, this.mMmsSub2RingtoneSameSub1);
        Handler r7 = this.mHandler;
        r7.sendMessage(r7.obtainMessage(r9, r10));
    }

    public static CharSequence getCallingRingtone(Context r10, String r11) {
        ContentResolver r0 = r10.getContentResolver();
        if (android.provider.Settings.System.getInt(r0, "sub2_ringtone_sameto_sub1", 0) != 1) goto L5;
        boolean r8 = true;
    L7:
        if (android.provider.Settings.System.getInt(r0, "mms_sub2_ringtone_sameto_sub1", 0) != 1) goto L9;
        boolean r9 = true;
    L11:
        return getRingtoneName(r10, r11, Utils.isMultiSimSupport(), Utils.hasMultiSimInDevice(), r8, r9);
    L9:
        r9 = false;
        goto L11
    L5:
        r8 = false;
        goto L7
    }

    private static CharSequence getRingtoneName(Context r8, String r9, boolean r10, boolean r11, boolean r12, boolean r13) {
        ContentResolver r0 = r8.getContentResolver();
        ActivityManager r1 = (ActivityManager) r8.getSystemService("activity");
        String r2 = android.provider.Settings.System.getString(r0, r9);
        if (r2 == null) goto L5;
        Uri r3 = Uri.parse(r2);
    L6:
        String r4 = r8.getString(r8.getResources().getIdentifier("ringtone_unknown", "string", RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME));
        if (r3 != null) goto L11;
        return r8.getString(R.string.sound_settings_no_ring);
    L11:
        if (isRingtoneExist(r8, r3) == true) goto L42;
        Uri r5 = getDefaultRingtoneUri(r8, r9);
        if (r5 == null) goto L21;
        setDefaultRingtone(r8, r5, r9);     // Catch: Exception -> L18
        String r6 = getCNTitle(r8, getDefaultRingtoneTitle(r8, r9), r9);     // Catch: Exception -> L18
        if (ActivityManagerSmt.getInstance().getConfiguration(r1).locale.toString().equals(Locale.SIMPLIFIED_CHINESE.toString()) == true) goto L44;
        return getEnTitle(r8, r6, r9);
    L44:
        return r6;
    L18:
        e = move-exception;
        OLog.e(TAG, "Error getting ringtone summary.", e);
        goto L42
    L21:
        return r8.getString(R.string.sound_settings_no_ring);
    L42:
        r4 = getCNTitle(r8, Ringtone.getTitle(r8, r3, false, true).toString(), r9);     // Catch: Throwable -> L27
        if (ActivityManagerSmt.getInstance().getConfiguration(r1).locale.toString().equals(Locale.SIMPLIFIED_CHINESE.toString()) == true) goto L29;
        r4 = getEnTitle(r8, r4.toString(), r9);     // Catch: Throwable -> L27
    L29:
        if (r10 == true) goto L31;
        return r4;
    L31:
        if (r9.equals("ringtone_2") == false) goto L35;
        if (r11 == false) goto L35;
        if (r12 == false) goto L35;
    L39:
        return r8.getString(R.string.ringtone_same_to_sub1);
    L35:
        if (r9.equals("mms_ringtone_uri_2") == false) goto L46;
        if (r11 == false) goto L47;
        if (r13 == true) goto L39;
        return r4;
    L47:
        return r4;
    L46:
        return r4;
    L27:
        e = move-exception;
        OLog.w(TAG, "Error getting ringtone summary.", e);
        goto L29
    L5:
        r3 = null;
        goto L6
    }

    private static String getEnTitle(Context r5, String r6, String r7) {
        int r0 = r5.getResources().getIdentifier("internal_ringtone_title", "array", RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME);
        int r1 = r5.getResources().getIdentifier("internal_ringtone_title_en", "array", RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME);
        String[] r2 = r5.getResources().getStringArray(r0);
        String[] r3 = r5.getResources().getStringArray(r1);
        int r4 = 0;
        if (r7.equals("mms_ringtone_uri") == false) goto L5;
    L20:
        r3 = r5.getResources().getStringArray(R.array.mms_ringtone_title);
        r2 = r5.getResources().getStringArray(R.array.mms_ringtone_file_name);
    L22:
        if (r4 >= r2.length) goto L28;
        if (r2[r4].equals(r6) == true) goto L26;
        r4 = r4 + 1;
        goto L22
    L26:
        return r3[r4];
    L28:
        return r6;
    L5:
        if (r7.equals("mms_ringtone_uri_2") == true) goto L20;
        if (r7.equals("notification_sound") == false) goto L11;
        r3 = r5.getResources().getStringArray(R.array.notification_ringtone_title);
        r2 = r5.getResources().getStringArray(R.array.notification_ringtone_file_name);
        goto L22
    L11:
        if (r7.equals("alarm_alert") == false) goto L22;
        String[] r8 = r5.getResources().getStringArray(R.array.alarm_ringtone_title);
        String[] r9 = r5.getResources().getStringArray(R.array.alarm_ringtone_file_name);
        int r10 = 0;
    L14:
        if (r10 >= r9.length) goto L22;
        if (r9[r10].equals(r6) == true) goto L18;
        r10 = r10 + 1;
        goto L14
    L18:
        return r8[r10];
    }

    private static boolean isRingtoneExist(Context r8, Uri r9) {
        boolean r0 = false;
        Cursor r1 = null;
        r1 = r8.getContentResolver().query(r9, new String[]{"_id"}, null, null, null);     // Catch: Throwable -> L11 Exception -> L13
        if (r1 == null) goto L8;
        if (r1.moveToFirst() == false) goto L8;
        r0 = true;
        goto L8
    L8:
        if (r1 == null) goto L10;
        r1.close();
    L10:
        return r0;
    L11:
        th = move-exception;
        if (r1 == null) goto L20;
        r1.close();
    L20:
        throw th;
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        r1.close();
    L17:
        return false;
    }

    private static void setDefaultRingtone(Context r5, Uri r6, String r7) {
        if (r6 != null) goto L4;
        String r0 = null;
    L6:
        if (r7.equals("ringtone") == false) goto L11;
        RingtoneManager.setActualDefaultRingtoneUri(r5, 1, r6);
        if (android.provider.Settings.System.getInt(r5.getContentResolver(), "sub2_ringtone_sameto_sub1", 0) != 1) goto L19;
        android.provider.Settings.System.putString(r5.getContentResolver(), "ringtone_2", r0);
        return;
    L19:
        return;
    L11:
        if (r7.equals("ringtone_2") == false) goto L13;
        RingtoneManager.setActualDefaultRingtoneUri(r5, 2097152, r6);
        return;
    L13:
        android.provider.Settings.System.putString(r5.getContentResolver(), r7, r0);
        if (r7.equals("mms_ringtone_uri") == true) goto L16;
        return;
    L16:
        if (android.provider.Settings.System.getInt(r5.getContentResolver(), "mms_sub2_ringtone_sameto_sub1", 0) != 1) goto L23;
        android.provider.Settings.System.putString(r5.getContentResolver(), "mms_ringtone_uri_2", r0);
        return;
    L23:
        return;
    L4:
        r0 = r6.toString();
        goto L6
    }

    private static Uri getDefaultRingtoneUri(Context r9, String r10) {
        String r1 = getDefaultRingtoneTitle(r9, r10);
        if (r10.equals("ringtone") == false) goto L5;
    L11:
        String r11 = "is_ringtone = 1";
    L12:
        Cursor r2 = null;
        Uri r3 = null;
        r3 = null;
        r3 = null;
        r3 = null;
        Cursor r12 = r9.getContentResolver().query(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, new String[]{"_id"}, "title = '" + r1 + "' AND " + r11, null, null);     // Catch: Throwable -> L23 Exception -> L25
        if (r12 != null) goto L36;
    L21:
        if (r12 == null) goto L30;
    L22:
        r12.close();
    L30:
        return r3;
    L36:
    L19:
        e = e;
    L27:
        e.printStackTrace();     // Catch: Throwable -> L31
        if (r12 == null) goto L30;
    L31:
        th = th;
        r2 = r12;
    L33:
        if (r2 == null) goto L35;
        r2.close();
    L35:
        throw th;
    L16:
        if (r12.moveToFirst() == false) goto L21;
        r3 = ContentUris.withAppendedId(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, r12.getInt(0));     // Catch: Exception -> L19 Throwable -> L31
        goto L21
    L25:
        e = e;
        r12 = null;
    L23:
        th = th;
        goto L33
    L5:
        if (r10.equals("ringtone_2") == true) goto L11;
        if (r10.equals("alarm_alert") == false) goto L10;
        r11 = "is_alarm = 1";
        goto L12
    L10:
        r11 = "is_notification = 1";
        goto L12
    }

    private static String getDefaultRingtoneTitle(Context r2, String r3) {
        r3.hashCode();
        byte r1 = -1;
        switch(r3.hashCode()) {
            case -1236583518: goto L26;
            case -1078676816: goto L22;
            case 394569198: goto L18;
            case 672547131: goto L14;
            case 1349183189: goto L10;
            case 2072701486: goto L6;
            default: goto L29;
        };
    L29:
        switch(r1) {
            case 0: goto L37;
            case 1: goto L43;
            case 2: goto L42;
            case 3: goto L41;
            case 4: goto L40;
            case 5: goto L39;
            default: goto L38;
        };
    L38:
        return r2.getString(R.string.ringtone_notification_default);
    L39:
        return r2.getString(R.string.ringtone_mms_default_2);
    L40:
        return r2.getString(R.string.ringtone_default_2);
    L41:
        return r2.getString(R.string.ringtone_mms_default);
    L42:
        return r2.getString(R.string.ringtone_alarm_default);
    L43:
        return r2.getString(R.string.ringtone_calendar_default);
    L37:
        return r2.getString(R.string.ringtone_default);
    L6:
        if (r3.equals("mms_ringtone_uri_2") == false) goto L29;
        r1 = 5;
        goto L29
    L10:
        if (r3.equals("ringtone_2") == false) goto L29;
        r1 = 4;
        goto L29
    L14:
        if (r3.equals("mms_ringtone_uri") == false) goto L29;
        r1 = 3;
        goto L29
    L18:
        if (r3.equals("alarm_alert") == false) goto L29;
        r1 = 2;
        goto L29
    L22:
        if (r3.equals("calendar_ringtone_uri") == false) goto L29;
        r1 = 1;
        goto L29
    L26:
        if (r3.equals("ringtone") == false) goto L29;
        r1 = 0;
        goto L29
    }

    private static String getCNTitle(Context r5, String r6, String r7) {
        String[] r0 = r5.getResources().getStringArray(R.array.ringtone_title);
        String[] r1 = r5.getResources().getStringArray(R.array.ringtone_file_name);
        int r3 = 0;
        if (r7.equals("mms_ringtone_uri") == false) goto L5;
    L20:
        r0 = r5.getResources().getStringArray(R.array.mms_ringtone_title);
        r1 = r5.getResources().getStringArray(R.array.mms_ringtone_file_name);
    L22:
        if (r3 >= r1.length) goto L28;
        if (r1[r3].equals(r6) == true) goto L26;
        r3 = r3 + 1;
        goto L22
    L26:
        return r0[r3];
    L28:
        return r6;
    L5:
        if (r7.equals("mms_ringtone_uri_2") == true) goto L20;
        if (r7.equals("notification_sound") == false) goto L11;
        r0 = r5.getResources().getStringArray(R.array.notification_ringtone_title);
        r1 = r5.getResources().getStringArray(R.array.notification_ringtone_file_name);
        goto L22
    L11:
        if (r7.equals("alarm_alert") == false) goto L22;
        String[] r8 = r5.getResources().getStringArray(R.array.alarm_ringtone_title);
        String[] r9 = r5.getResources().getStringArray(R.array.alarm_ringtone_file_name);
        int r2 = 0;
    L14:
        if (r2 >= r9.length) goto L22;
        if (r9[r2].equals(r6) == true) goto L18;
        r2 = r2 + 1;
        goto L14
    L18:
        return r8[r2];
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != this.mVibrationOnRingSwitch.getEndSwitch()) goto L6;
        onVibrationOnRingSwitchCheckedChange(r3);
        return;
    L6:
        if (r2 != this.mDoubaoVolumeBarDisplaySwitch.getEndSwitch()) goto L10;
        onDoubaoVolumeBarDisplaySwitchCheckedChange(r3);
        return;
    }

    private void UpdateRingToneSettings() {
        if (Utils.hasTelephonyFeature(this.mContext) == true) goto L6;
        this.mViewNotification.setCardPosition(1);
        return;
    L6:
        this.mShowSlot1 = true;
        this.mShowSlot2 = true;
        this.mHasMultiSimInDevice = Utils.hasMultiSimInDevice();
        if (android.provider.Settings.System.getInt(getContentResolver(), "mms_sub2_ringtone_sameto_sub1", 0) != 1) goto L9;
        boolean r0 = true;
    L10:
        this.mMmsSub2RingtoneSameSub1 = r0;
        if (android.provider.Settings.System.getInt(getContentResolver(), "sub2_ringtone_sameto_sub1", 0) != 1) goto L13;
        boolean r1 = true;
    L14:
        this.mSub2RingtoneSameSub1 = r1;
        if (this.mHasMultiSimInDevice == false) goto L17;
    L22:
        OCardListItem r2 = this.mViewRing;
        int r4 = 8;
        if (this.mShowSlot1 == false) goto L25;
        int r3 = 0;
    L26:
        r2.setVisibility(r3);
        OCardListItem r5 = this.mViewSms;
        if (this.mShowSlot1 == false) goto L29;
        int r6 = 0;
    L30:
        r5.setVisibility(r6);
        OCardListItem r7 = this.mViewRingSub2;
        if (this.mShowSlot2 == false) goto L33;
        int r8 = 0;
    L34:
        r7.setVisibility(r8);
        OCardListItem r9 = this.mViewSmsSub2;
        if (this.mShowSlot2 == false) goto L37;
        r4 = 0;
    L37:
        r9.setVisibility(r4);
        if (this.mShowSlot1 == true) goto L40;
        this.mViewRingSub2.setCardPosition(1);
    L42:
        if (this.mHasMultiSimInDevice == false) goto L44;
        this.mViewRing.showTitle(false);
        this.mViewRing.showCustomStart(true);
        this.mViewRingSub2.showTitle(false);
        this.mViewRingSub2.showCustomStart(true);
        this.mViewSms.showTitle(false);
        this.mViewSms.showCustomStart(true);
        this.mViewSmsSub2.showTitle(false);
        this.mViewSmsSub2.showCustomStart(true);
    L46:
        if (this.mShowSlot1 == false) goto L48;
    L50:
        this.mViewNotification.setCardPosition(2);
        return;
    L48:
        if (this.mShowSlot2 == true) goto L50;
        this.mViewNotification.setCardPosition(1);
        return;
    L44:
        this.mViewRing.showCustomStart(false);
        this.mViewRing.showTitle(true);
        this.mViewRingSub2.showCustomStart(false);
        this.mViewRingSub2.showTitle(true);
        this.mViewSms.showCustomStart(false);
        this.mViewSms.showTitle(true);
        this.mViewSmsSub2.showCustomStart(false);
        this.mViewSmsSub2.showTitle(true);
        goto L46
    L40:
        this.mViewRingSub2.setCardPosition(2);
        goto L42
    L33:
        r8 = 8;
        goto L34
    L29:
        r6 = 8;
        goto L30
    L25:
        r3 = 8;
        goto L26
    L17:
        if (MultiSimAdapter.hasIccCard(1) == true) goto L19;
    L21:
        this.mShowSlot2 = false;
        goto L22
    L19:
        if (MultiSimAdapter.hasIccCard(0) == true) goto L21;
        this.mShowSlot1 = false;
        goto L22
    L13:
        r1 = false;
        goto L14
    L9:
        r0 = false;
        goto L10
    }

    private boolean isSilentMode() {
        if (this.mAudioManager.getRingerModeInternal() == 2) goto L5;
        return true;
    L5:
        return false;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_SoundSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(SoundSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_SoundSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_SoundSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(SoundSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_SoundSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_SoundSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(SoundSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_SoundSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
