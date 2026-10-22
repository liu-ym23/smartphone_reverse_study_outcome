package com.android.settings.settingitemsprovider.Items;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.provider.Settings;
import com.android.settings.OtherAlertToneFragment;
import com.android.settings.R;
import com.android.settings.SoundSettingsFragment;
import com.android.settings.Utils;
import com.android.settings.search.Index;
import com.android.settings.settingitemsprovider.Constants;
import com.android.settings.settingitemsprovider.DatabaseHelper;
import com.android.settings.utils.HanziToPinyin;
import java.util.List;
import obric.app.settings.search.SettingsSwitchKeyUtil;

/* JADX INFO: loaded from: classes2.dex */
public class SoundSettingItems extends SettingItems {
    private static final String NO_DISTURB_PACKAGE_NAME = "com.obric.nodisturb";

    public SoundSettingItems(Context r1) {
        super(r1);
    }

    @Override // com.android.settings.settingitemsprovider.Items.SettingItems
    public void initItemList() {
        String r13 = this.mContext.getString(R.string.sound_settings);
        this.mItemList.add(new SettingItems.Items(this, r13, null, Constants.COMPONENT_SOUND, null, true, r13, R.string.sound_and_vibration_desc));
        String r15 = getPackageString(this.mContext, "com.obric.nodisturb", "no_disturb_text");
        this.mItemList.add(new SettingItems.Items(this, r15, null, Constants.COMPONENT_NO_DISTURB, null, true, buildPath(new String[]{r13, r15}), R.string.do_not_disturb_mode_desc));
        this.mItemList.add(new SettingItems.Items(this, getPackageString(this.mContext, "com.obric.nodisturb", "no_disturb_text"), null, true, "secure", "NoDisturbOn", null, "0", true, buildPath(new String[]{r13, r15, getPackageString(this.mContext, "com.obric.nodisturb", "no_disturb_text")}), R.string.do_not_disturb_mode_desc));
        this.mItemList.add(new SettingItems.Items(this, getPackageString(this.mContext, "com.obric.nodisturb", "notification_allowance"), null, Constants.COMPONENT_NO_DISTURB_NOTIFICATION_ALLOWANCE, null, true, buildPath(new String[]{r13, r15, getPackageString(this.mContext, "com.obric.nodisturb", "notification_allowance")}), R.string.dnd_notification_allowance_desc));
        this.mItemList.add(new SettingItems.Items(this, getPackageString(this.mContext, "com.obric.nodisturb", "allow_media_text"), null, true, "secure", "NoDisturbAllowMedia", null, "1", true, buildPath(new String[]{r13, r15, getPackageString(this.mContext, "com.obric.nodisturb", "allow_media_text")}), R.string.dnd_allow_media_desc));
        this.mItemList.add(new SettingItems.Items(this, getPackageString(this.mContext, "com.obric.nodisturb", "allowed_call_text"), null, Constants.COMPONENT_NO_DISTURB_ALLOW_CALL, null, true, buildPath(new String[]{r13, r15, getPackageString(this.mContext, "com.obric.nodisturb", "allowed_call_text")}), R.string.allow_calls_desc));
        this.mItemList.add(new SettingItems.Items(this, getPackageString(this.mContext, "com.obric.nodisturb", "time_duration_text"), null, Constants.COMPONENT_NO_DISTURB_SET_TIME, null, true, buildPath(new String[]{r13, r15, getPackageString(this.mContext, "com.obric.nodisturb", "time_duration_text")}), R.string.scheduled_do_not_disturb_desc));
        this.mItemList.add(new SettingItems.Items(this, getPackageString(this.mContext, "com.obric.nodisturb", "notify_when_screen_on"), null, true, "secure", "NoDisturbNotifyWhenScreenOn", null, "0", true, buildPath(new String[]{r13, r15, getPackageString(this.mContext, "com.obric.nodisturb", "notify_when_screen_on")}), R.string.only_activate_when_screen_off_desc));
        this.mItemList.add(new SettingItems.Items(this, getPackageString(this.mContext, "com.obric.nodisturb", "notify_when_second_call"), null, true, "secure", "NoDisturbNotifyWhenSecondCall", null, "0", true, buildPath(new String[]{r13, r15, getPackageString(this.mContext, "com.obric.nodisturb", "notify_when_second_call")}), R.string.repeat_call_reminder_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.voice_mode_tips, null, Constants.COMPONENT_SOUND, null, true, buildPath(r13, new int[]{R.string.voice_mode_tips}), R.string.silent_mode_desc));
        int r0 = Settings.Global.getInt(this.mContext.getContentResolver(), SoundSettingsFragment.GLOBAL_VIBRATION_ENABLED, 1);
        List<SettingItems.Items> r9 = this.mItemList;
        String r5 = Constants.COMPONENT_SOUND;
        if (r0 == 0) goto L5;
        boolean r7 = true;
    L6:
        r9.add(new SettingItems.Items(this, R.string.vibration_intensity, null, r5, null, r7, buildPath(r13, new int[]{R.string.vibration_intensity}), R.string.vibration_intensity_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.volume_media_title, R.string.volume_title, Constants.COMPONENT_SOUND, null, true, buildPath(r13, new int[]{R.string.volume_media_title}), R.string.media_volume_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.volume_ringtone_title, R.string.volume_title, Constants.COMPONENT_SOUND, null, true, buildPath(r13, new int[]{R.string.volume_ringtone_title}), R.string.ringtone_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.volume_notification_title, R.string.volume_title, Constants.COMPONENT_SOUND, null, true, buildPath(r13, new int[]{R.string.volume_notification_title}), R.string.notification_and_sms_ringtone_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.volume_clock_title, R.string.volume_title, Constants.COMPONENT_SOUND, null, true, buildPath(r13, new int[]{R.string.volume_clock_title}), R.string.alarm_ringtone_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.volume_assistant_title, R.string.volume_title, Constants.COMPONENT_SOUND, null, true, buildPath(r13, new int[]{R.string.volume_assistant_title}), R.string.assistant_volume_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.volume_button_default_control_tips, null, Constants.COMPONENT_SOUND, null, true, buildPath(r13, new int[]{R.string.volume_button_default_control_tips}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.doubao_volume_bar_display_switch_title, null, true, SettingsSwitchKeyUtil.SettingTable.System, "doubao_volume_bar_display_switch_on", null, "0", true, buildPath(r13, new int[]{R.string.doubao_volume_bar_display_switch_title}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.vol_key_default_ringtone, null, Constants.COMPONENT_SOUND, null, true, buildPath(r13, new int[]{R.string.vol_key_default_ringtone}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.vol_key_default_media, null, Constants.COMPONENT_SOUND, null, true, buildPath(r13, new int[]{R.string.vol_key_default_media}), null));
        if (Utils.hasMultiSimInDevice() == true) goto L9;
        this.mItemList.add(new SettingItems.Items(this, R.string.sound_settings_text_phone_ring, R.string.alias_ringtone, Constants.COMPONENT_RINGTONE, getRingtoneExtras(R.string.sound_settings_text_phone_ring), true, buildPath(r13, new int[]{R.string.sound_settings_text_phone_ring}), R.string.incoming_call_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.sound_settings_text_sms_ring, null, Constants.COMPONENT_RINGTONE, getRingtoneExtras(R.string.sound_settings_text_sms_ring), true, buildPath(r13, new int[]{R.string.sound_settings_text_sms_ring}), R.string.sms_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.sound_settings_text_phone_ring_sub1, R.string.alias_ringtone, Constants.COMPONENT_RINGTONE, getRingtoneExtras(R.string.sound_settings_text_phone_ring), false, buildPath(r13, new int[]{R.string.sound_settings_text_phone_ring_sub1}), R.string.incoming_call_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.sound_settings_text_phone_ring_sub2, R.string.alias_ringtone, Constants.COMPONENT_RINGTONE, getRingtoneExtras(R.string.sound_settings_text_phone_ring_sub2), false, buildPath(r13, new int[]{R.string.sound_settings_text_phone_ring_sub2}), R.string.incoming_call_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.sound_settings_text_sms_ring_sub1, null, Constants.COMPONENT_RINGTONE, getRingtoneExtras(R.string.sound_settings_text_sms_ring), false, buildPath(r13, new int[]{R.string.sound_settings_text_sms_ring_sub1}), R.string.sms_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.sound_settings_text_sms_ring_sub2, null, Constants.COMPONENT_RINGTONE, getRingtoneExtras(R.string.sound_settings_text_sms_ring_sub2), false, buildPath(r13, new int[]{R.string.sound_settings_text_sms_ring_sub2}), R.string.sms_desc));
    L10:
        this.mItemList.add(new SettingItems.Items(this, R.string.sound_settings_text_default_ring, null, Constants.COMPONENT_RINGTONE, getRingtoneExtras(R.string.sound_settings_text_default_ring), true, buildPath(r13, new int[]{R.string.sound_settings_text_default_ring}), R.string.notification_ringtone_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.sound_settings_text_alarm_ring, null, Constants.COMPONENT_RINGTONE, getRingtoneExtras(R.string.sound_settings_text_alarm_ring), true, buildPath(r13, new int[]{R.string.sound_settings_text_alarm_ring}), R.string.alarm_desc));
        if (Utils.hasMultiSimInDevice() == true) goto L13;
        List<SettingItems.Items> r6 = this.mItemList;
        String r2 = this.mContext.getString(R.string.telephony_vibrate_title);
        String r17 = Constants.COMPONENT_VIBRATION_EFFECT;
        String r21 = getRingtoneVibrationExtras(R.string.telephony_vibrate_title);
        String r23 = buildPath(new String[]{r13, this.mContext.getString(R.string.sound_settings_text_phone_ring), this.mContext.getString(R.string.telephony_vibrate_title)});
        int r11 = R.string.vibration_tips;
        r6.add(new SettingItems.Items(this, r2, null, r17, r21, true, r23, R.string.incoming_call_vibration_desc));
        this.mItemList.add(new SettingItems.Items(this, this.mContext.getString(R.string.sound_settings_text_sms_ring) + this.mContext.getString(r11), null, Constants.COMPONENT_VIBRATION_EFFECT, getRingtoneVibrationExtras(R.string.sound_settings_text_sms_ring), true, buildPath(new String[]{r13, this.mContext.getString(R.string.sound_settings_text_sms_ring), this.mContext.getString(R.string.sound_settings_text_sms_ring) + this.mContext.getString(r11)}), R.string.sms_vibration_desc));
        this.mItemList.add(new SettingItems.Items(this, this.mContext.getString(R.string.telephony_vibrate_title) + HanziToPinyin.Token.SEPARATOR + this.mContext.getString(R.string.multi_sim_sub_1_title), null, Constants.COMPONENT_VIBRATION_EFFECT, getRingtoneVibrationExtras(R.string.telephony_vibrate_title), false, buildPath(new String[]{r13, this.mContext.getString(R.string.sound_settings_text_phone_ring), this.mContext.getString(R.string.telephony_vibrate_title) + HanziToPinyin.Token.SEPARATOR + this.mContext.getString(R.string.multi_sim_sub_1_title)}), R.string.incoming_call_vibration_desc));
        this.mItemList.add(new SettingItems.Items(this, this.mContext.getString(R.string.sound_settings_text_phone_ring) + this.mContext.getString(r11) + this.mContext.getString(R.string.multi_sim_sub_2_title), null, Constants.COMPONENT_VIBRATION_EFFECT, getRingtoneVibrationExtras(R.string.sound_settings_text_phone_ring_sub2), false, buildPath(new String[]{r13, this.mContext.getString(R.string.sound_settings_text_phone_ring_sub2), this.mContext.getString(R.string.sound_settings_text_phone_ring) + this.mContext.getString(r11) + this.mContext.getString(R.string.multi_sim_sub_2_title)}), R.string.incoming_call_vibration_desc));
        this.mItemList.add(new SettingItems.Items(this, this.mContext.getString(R.string.sound_settings_text_sms_ring) + this.mContext.getString(r11) + this.mContext.getString(R.string.multi_sim_sub_1_title), null, Constants.COMPONENT_VIBRATION_EFFECT, getRingtoneVibrationExtras(R.string.sound_settings_text_sms_ring), false, buildPath(new String[]{r13, this.mContext.getString(R.string.sound_settings_text_sms_ring), this.mContext.getString(R.string.sound_settings_text_sms_ring) + this.mContext.getString(r11) + this.mContext.getString(R.string.multi_sim_sub_1_title)}), R.string.sms_vibration_desc));
        this.mItemList.add(new SettingItems.Items(this, this.mContext.getString(R.string.sound_settings_text_sms_ring) + this.mContext.getString(r11) + this.mContext.getString(R.string.multi_sim_sub_2_title), null, Constants.COMPONENT_VIBRATION_EFFECT, getRingtoneVibrationExtras(R.string.sound_settings_text_sms_ring_sub2), false, buildPath(new String[]{r13, this.mContext.getString(R.string.sound_settings_text_sms_ring_sub2), this.mContext.getString(R.string.sound_settings_text_sms_ring) + this.mContext.getString(r11) + this.mContext.getString(R.string.multi_sim_sub_2_title)}), R.string.sms_vibration_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.make_ringtone_text, null, Constants.COMPONENT_RINGTONE, getRingtoneExtras(R.string.sound_settings_text_phone_ring), true, buildPath(r13, new int[]{R.string.sound_settings_text_phone_ring, R.string.make_ringtone_text}), R.string.select_song_as_ringtone_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.make_ringtone_text, null, Constants.COMPONENT_RINGTONE, getRingtoneExtras(R.string.sound_settings_text_phone_ring), false, buildPath(r13, new int[]{R.string.sound_settings_text_phone_ring_sub1, R.string.make_ringtone_text}), R.string.select_song_as_ringtone_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.make_ringtone_text, null, Constants.COMPONENT_RINGTONE, getRingtoneExtras(R.string.sound_settings_text_phone_ring_sub2), false, buildPath(r13, new int[]{R.string.sound_settings_text_phone_ring_sub2, R.string.make_ringtone_text}), R.string.select_song_as_ringtone_desc));
    L14:
        this.mItemList.add(new SettingItems.Items(this, this.mContext.getString(R.string.sound_settings_text_default_ring) + this.mContext.getString(r11), null, Constants.COMPONENT_VIBRATION_EFFECT, getRingtoneVibrationExtras(R.string.sound_settings_text_default_ring), true, buildPath(new String[]{r13, this.mContext.getString(R.string.sound_settings_text_default_ring), this.mContext.getString(R.string.sound_settings_text_default_ring) + this.mContext.getString(r11)}), R.string.notification_vibration_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.sound_settings_other_alert_tone, null, Constants.COMPONENT_OTHER_ALERT_TONE, null, true, buildPath(r13, new int[]{R.string.sound_settings_other_alert_tone}), R.string.other_sound_effects_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.dial_pad_tones_title, null, true, SettingsSwitchKeyUtil.SettingTable.System, "dtmf_tone", null, "1", true, buildPath(r13, new int[]{R.string.sound_settings_other_alert_tone, R.string.dial_pad_tones_title}), R.string.dial_pad_tone_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.touch_sounds_title, null, true, SettingsSwitchKeyUtil.SettingTable.System, "sound_effects_enabled", null, "1", true, buildPath(r13, new int[]{R.string.sound_settings_other_alert_tone, R.string.touch_sounds_title}), R.string.touch_tone_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.screen_locking_sounds_title, null, true, SettingsSwitchKeyUtil.SettingTable.System, "lockscreen_sounds_enabled", null, "1", true, buildPath(r13, new int[]{R.string.sound_settings_other_alert_tone, R.string.screen_locking_sounds_title}), R.string.lock_screen_tone_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.screenshot_sounds_settings, null, true, SettingsSwitchKeyUtil.SettingTable.System, OtherAlertToneFragment.SCREENSHOT_SOUNDS_ENABLED, null, "1", true, buildPath(r13, new int[]{R.string.sound_settings_other_alert_tone, R.string.screenshot_sounds_settings}), R.string.screenshot_tone_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.unlock_sounds_settings, null, true, SettingsSwitchKeyUtil.SettingTable.System, OtherAlertToneFragment.UNLOCK_SOUNDS_ENABLED, null, "1", true, buildPath(r13, new int[]{R.string.sound_settings_other_alert_tone, R.string.unlock_sounds_settings}), R.string.fingerprint_unlock_tone_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.title_low_battery_sound, null, true, SettingsSwitchKeyUtil.SettingTable.System, OtherAlertToneFragment.LOW_BATTERY_SOUNDS_ENABLED, null, "1", true, buildPath(r13, new int[]{R.string.sound_settings_other_alert_tone, R.string.title_low_battery_sound}), R.string.low_battery_tone_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.haptic_feedback_tips, null, Constants.COMPONENT_HAPTIC_FEED_BACK, null, true, buildPath(r13, new int[]{R.string.haptic_feedback_tips}), R.string.haptic_feedback_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.input_method_haptic_feedback, null, Constants.COMPONENT_INPUT_METHOD_HAPTIC_FEED_BACK, "EXTRA_FRAGMENT_TYPE=KEY_FEEDBACK", true, buildPath(r13, new int[]{R.string.input_method_haptic_feedback}), R.string.built_in_input_method_haptic_feedback_desc));
        return;
    L13:
        r11 = R.string.vibration_tips;
        this.mItemList.add(new SettingItems.Items(this, this.mContext.getString(R.string.telephony_vibrate_title), null, Constants.COMPONENT_VIBRATION_EFFECT, getRingtoneVibrationExtras(R.string.telephony_vibrate_title), false, buildPath(new String[]{r13, this.mContext.getString(R.string.sound_settings_text_phone_ring), this.mContext.getString(R.string.telephony_vibrate_title)}), R.string.incoming_call_vibration_desc));
        this.mItemList.add(new SettingItems.Items(this, this.mContext.getString(R.string.sound_settings_text_sms_ring) + this.mContext.getString(r11), null, Constants.COMPONENT_VIBRATION_EFFECT, getRingtoneVibrationExtras(R.string.sound_settings_text_sms_ring), false, buildPath(new String[]{r13, this.mContext.getString(R.string.sound_settings_text_sms_ring), this.mContext.getString(R.string.sound_settings_text_sms_ring) + this.mContext.getString(r11)}), R.string.sms_vibration_desc));
        this.mItemList.add(new SettingItems.Items(this, this.mContext.getString(R.string.telephony_vibrate_title) + HanziToPinyin.Token.SEPARATOR + this.mContext.getString(R.string.multi_sim_sub_1_title), null, Constants.COMPONENT_VIBRATION_EFFECT, getRingtoneVibrationExtras(R.string.telephony_vibrate_title), true, buildPath(new String[]{r13, this.mContext.getString(R.string.sound_settings_text_phone_ring), this.mContext.getString(R.string.telephony_vibrate_title) + HanziToPinyin.Token.SEPARATOR + this.mContext.getString(R.string.multi_sim_sub_1_title)}), R.string.incoming_call_vibration_desc));
        this.mItemList.add(new SettingItems.Items(this, this.mContext.getString(R.string.sound_settings_text_phone_ring) + this.mContext.getString(r11) + this.mContext.getString(R.string.multi_sim_sub_2_title), null, Constants.COMPONENT_VIBRATION_EFFECT, getRingtoneVibrationExtras(R.string.sound_settings_text_phone_ring_sub2), true, buildPath(new String[]{r13, this.mContext.getString(R.string.sound_settings_text_phone_ring_sub2), this.mContext.getString(R.string.sound_settings_text_phone_ring) + this.mContext.getString(r11) + this.mContext.getString(R.string.multi_sim_sub_2_title)}), R.string.incoming_call_vibration_desc));
        this.mItemList.add(new SettingItems.Items(this, this.mContext.getString(R.string.sound_settings_text_sms_ring) + this.mContext.getString(r11) + this.mContext.getString(R.string.multi_sim_sub_1_title), null, Constants.COMPONENT_VIBRATION_EFFECT, getRingtoneVibrationExtras(R.string.sound_settings_text_sms_ring), true, buildPath(new String[]{r13, this.mContext.getString(R.string.sound_settings_text_sms_ring), this.mContext.getString(R.string.sound_settings_text_sms_ring) + this.mContext.getString(r11) + this.mContext.getString(R.string.multi_sim_sub_1_title)}), R.string.sms_vibration_desc));
        this.mItemList.add(new SettingItems.Items(this, this.mContext.getString(R.string.sound_settings_text_sms_ring) + this.mContext.getString(r11) + this.mContext.getString(R.string.multi_sim_sub_2_title), null, Constants.COMPONENT_VIBRATION_EFFECT, getRingtoneVibrationExtras(R.string.sound_settings_text_sms_ring_sub2), true, buildPath(new String[]{r13, this.mContext.getString(R.string.sound_settings_text_sms_ring_sub2), this.mContext.getString(R.string.sound_settings_text_sms_ring) + this.mContext.getString(r11) + this.mContext.getString(R.string.multi_sim_sub_2_title)}), R.string.sms_vibration_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.make_ringtone_text, null, Constants.COMPONENT_RINGTONE, getRingtoneExtras(R.string.sound_settings_text_phone_ring), false, buildPath(r13, new int[]{R.string.sound_settings_text_phone_ring, R.string.make_ringtone_text}), R.string.select_song_as_ringtone_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.make_ringtone_text, null, Constants.COMPONENT_RINGTONE, getRingtoneExtras(R.string.sound_settings_text_phone_ring), true, buildPath(r13, new int[]{R.string.sound_settings_text_phone_ring_sub1, R.string.make_ringtone_text}), R.string.select_song_as_ringtone_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.make_ringtone_text, null, Constants.COMPONENT_RINGTONE, getRingtoneExtras(R.string.sound_settings_text_phone_ring_sub2), true, buildPath(r13, new int[]{R.string.sound_settings_text_phone_ring_sub2, R.string.make_ringtone_text}), R.string.select_song_as_ringtone_desc));
        goto L14
    L9:
        this.mItemList.add(new SettingItems.Items(this, R.string.sound_settings_text_phone_ring, R.string.alias_ringtone, Constants.COMPONENT_RINGTONE, getRingtoneExtras(R.string.sound_settings_text_phone_ring), false, buildPath(r13, new int[]{R.string.sound_settings_text_phone_ring}), R.string.incoming_call_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.sound_settings_text_sms_ring, null, Constants.COMPONENT_RINGTONE, getRingtoneExtras(R.string.sound_settings_text_sms_ring), false, buildPath(r13, new int[]{R.string.sound_settings_text_sms_ring}), R.string.sms_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.sound_settings_text_phone_ring_sub1, R.string.alias_ringtone, Constants.COMPONENT_RINGTONE, getRingtoneExtras(R.string.sound_settings_text_phone_ring), true, buildPath(r13, new int[]{R.string.sound_settings_text_phone_ring_sub1}), R.string.incoming_call_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.sound_settings_text_phone_ring_sub2, R.string.alias_ringtone, Constants.COMPONENT_RINGTONE, getRingtoneExtras(R.string.sound_settings_text_phone_ring_sub2), true, buildPath(r13, new int[]{R.string.sound_settings_text_phone_ring_sub2}), R.string.incoming_call_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.sound_settings_text_sms_ring_sub1, null, Constants.COMPONENT_RINGTONE, getRingtoneExtras(R.string.sound_settings_text_sms_ring), true, buildPath(r13, new int[]{R.string.sound_settings_text_sms_ring_sub1}), R.string.sms_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.sound_settings_text_sms_ring_sub2, null, Constants.COMPONENT_RINGTONE, getRingtoneExtras(R.string.sound_settings_text_sms_ring_sub2), true, buildPath(r13, new int[]{R.string.sound_settings_text_sms_ring_sub2}), R.string.sms_desc));
        goto L10
    L5:
        r7 = false;
        goto L6
    }

    public static void updateItems(Handler r19, Context r20, SQLiteDatabase r21, boolean r22) {
        if (r22 == false) goto L5;
        String r4 = "0";
    L6:
        executeUpdate(r19, r20, r21, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r4, "name", r20.getString(R.string.sound_settings_text_phone_ring));
        if (r22 == false) goto L9;
        String r5 = "0";
    L10:
        executeUpdate(r19, r20, r21, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r5, "name", r20.getString(R.string.sound_settings_text_sms_ring));
        if (r22 == false) goto L13;
        String r6 = "1";
    L14:
        executeUpdate(r19, r20, r21, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r6, "name", r20.getString(R.string.sound_settings_text_phone_ring_sub1));
        if (r22 == false) goto L17;
        String r7 = "1";
    L18:
        executeUpdate(r19, r20, r21, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r7, "name", r20.getString(R.string.sound_settings_text_phone_ring_sub2));
        if (r22 == false) goto L21;
        String r8 = "1";
    L22:
        executeUpdate(r19, r20, r21, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r8, "name", r20.getString(R.string.sound_settings_text_sms_ring_sub1));
        if (r22 == false) goto L25;
        String r9 = "1";
    L26:
        executeUpdate(r19, r20, r21, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r9, "name", r20.getString(R.string.sound_settings_text_sms_ring_sub2));
        if (r22 == false) goto L29;
        String r10 = "0";
    L30:
        executeUpdate(r19, r20, r21, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r10, "name", r20.getString(R.string.sound_settings_text_phone_ring) + r20.getString(R.string.vibration_tips));
        if (r22 == false) goto L33;
        String r11 = "0";
    L34:
        executeUpdate(r19, r20, r21, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r11, "name", r20.getString(R.string.sound_settings_text_sms_ring) + r20.getString(R.string.vibration_tips));
        if (r22 == false) goto L37;
        String r12 = "1";
    L38:
        executeUpdate(r19, r20, r21, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r12, "name", r20.getString(R.string.sound_settings_text_phone_ring) + r20.getString(R.string.vibration_tips) + r20.getString(R.string.multi_sim_sub_1_title));
        if (r22 == false) goto L41;
        String r13 = "1";
    L42:
        executeUpdate(r19, r20, r21, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r13, "name", r20.getString(R.string.sound_settings_text_phone_ring) + r20.getString(R.string.vibration_tips) + r20.getString(R.string.multi_sim_sub_2_title));
        if (r22 == false) goto L45;
        String r14 = "1";
    L46:
        executeUpdate(r19, r20, r21, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r14, "name", r20.getString(R.string.sound_settings_text_sms_ring) + r20.getString(R.string.vibration_tips) + r20.getString(R.string.multi_sim_sub_1_title));
        if (r22 == false) goto L49;
        String r15 = "1";
    L50:
        executeUpdate(r19, r20, r21, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r15, "name", r20.getString(R.string.sound_settings_text_sms_ring) + r20.getString(R.string.vibration_tips) + r20.getString(R.string.multi_sim_sub_2_title));
        if (r22 == false) goto L53;
        String r16 = "0";
    L54:
        executeUpdate(r19, r20, r21, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r16, DatabaseHelper.ItemsRecord.ITEM_PATH_1, buildPath(new String[]{r20.getString(R.string.sound_settings), r20.getString(R.string.sound_settings_text_phone_ring), r20.getString(R.string.make_ringtone_text)}));
        if (r22 == false) goto L57;
        String r17 = "1";
    L58:
        executeUpdate(r19, r20, r21, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r17, DatabaseHelper.ItemsRecord.ITEM_PATH_1, buildPath(new String[]{r20.getString(R.string.sound_settings), r20.getString(R.string.sound_settings_text_phone_ring_sub1), r20.getString(R.string.make_ringtone_text)}));
        if (r22 == false) goto L61;
        String r18 = "1";
    L62:
        executeUpdate(r19, r20, r21, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r18, DatabaseHelper.ItemsRecord.ITEM_PATH_1, buildPath(new String[]{r20.getString(R.string.sound_settings), r20.getString(R.string.sound_settings_text_phone_ring_sub2), r20.getString(R.string.make_ringtone_text)}));
        return;
    L61:
        r18 = "0";
        goto L62
    L57:
        r17 = "0";
        goto L58
    L53:
        r16 = "1";
        goto L54
    L49:
        r15 = "0";
        goto L50
    L45:
        r14 = "0";
        goto L46
    L41:
        r13 = "0";
        goto L42
    L37:
        r12 = "0";
        goto L38
    L33:
        r11 = "1";
        goto L34
    L29:
        r10 = "1";
        goto L30
    L25:
        r9 = "0";
        goto L26
    L21:
        r8 = "0";
        goto L22
    L17:
        r7 = "0";
        goto L18
    L13:
        r6 = "0";
        goto L14
    L9:
        r5 = "1";
        goto L10
    L5:
        r4 = "1";
        goto L6
    }

    public static void updateVibrationItems(Handler r7, Context r8, SQLiteDatabase r9, boolean r10) {
        if (r10 == false) goto L4;
        String r11 = "1";
    L5:
        executeUpdate(r7, r8, r9, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r11, "name", r8.getString(R.string.vibration_intensity));
        return;
    L4:
        r11 = "0";
        goto L5
    }

    private String getRingtoneExtras(int r5) {
        StringBuilder r0 = new StringBuilder();
        switch(r5) {
            case 2131958570: goto L11;
            case 2131958571: goto L10;
            case 2131958572: goto L9;
            case 2131958579: goto L8;
            case 2131958581: goto L7;
            case 2131958583: goto L6;
            case 2131958585: goto L5;
            default: goto L13;
        };
    L5:
        r0.append("android.intent.extra.ringtone.TYPE=2|title=").append(this.mContext.getString(R.string.sound_settings_text_sms_ring) + Index.ENTRIES_SEPARATOR).append("ringtone_type=type_mms_sub2");
        goto L13
    L6:
        r0.append("android.intent.extra.ringtone.TYPE=2|title=").append(this.mContext.getString(r5) + Index.ENTRIES_SEPARATOR).append("ringtone_type=type_mms");
        goto L13
    L7:
        r0.append("android.intent.extra.ringtone.TYPE=1|title=").append(this.mContext.getString(R.string.sound_settings_text_phone_ring) + Index.ENTRIES_SEPARATOR).append("ringtone_type=type_ringtone_sub2");
        goto L13
    L8:
        r0.append("android.intent.extra.ringtone.TYPE=1|title=").append(this.mContext.getString(r5) + Index.ENTRIES_SEPARATOR).append("ringtone_type=type_ringtone");
        goto L13
    L9:
        r0.append("android.intent.extra.ringtone.TYPE=2|title=").append(this.mContext.getString(r5) + Index.ENTRIES_SEPARATOR).append("ringtone_type=type_default");
        goto L13
    L10:
        r0.append("android.intent.extra.ringtone.TYPE=2|title=").append(this.mContext.getString(r5) + Index.ENTRIES_SEPARATOR).append("ringtone_type=type_calendar");
        goto L13
    L11:
        r0.append("android.intent.extra.ringtone.TYPE=4|title=").append(this.mContext.getString(r5) + Index.ENTRIES_SEPARATOR).append("ringtone_type=type_alarm");
    L13:
        return r0.toString();
    }

    private String getRingtoneVibrationExtras(int r7) {
        StringBuilder r0 = new StringBuilder();
        switch(r7) {
            case 2131958570: goto L11;
            case 2131958571: goto L10;
            case 2131958572: goto L9;
            case 2131958581: goto L8;
            case 2131958583: goto L7;
            case 2131958585: goto L6;
            case 2131959013: goto L5;
            default: goto L13;
        };
    L5:
        r0.append("android.intent.extra.ringtone.TYPE=1|title=").append(this.mContext.getString(r7) + Index.ENTRIES_SEPARATOR).append("ringtone_type=type_ringtone");
        goto L13
    L6:
        r0.append("android.intent.extra.ringtone.TYPE=2|title=").append(this.mContext.getString(R.string.sound_settings_text_sms_ring) + this.mContext.getString(R.string.vibration_tips) + Index.ENTRIES_SEPARATOR).append("ringtone_type=type_mms_sub2");
        goto L13
    L7:
        r0.append("android.intent.extra.ringtone.TYPE=2|title=").append(this.mContext.getString(r7) + this.mContext.getString(R.string.vibration_tips) + Index.ENTRIES_SEPARATOR).append("ringtone_type=type_mms");
        goto L13
    L8:
        r0.append("android.intent.extra.ringtone.TYPE=1|title=").append(this.mContext.getString(R.string.sound_settings_text_phone_ring) + this.mContext.getString(R.string.vibration_tips) + Index.ENTRIES_SEPARATOR).append("ringtone_type=type_ringtone_sub2");
        goto L13
    L9:
        r0.append("android.intent.extra.ringtone.TYPE=2|title=").append(this.mContext.getString(r7) + this.mContext.getString(R.string.vibration_tips) + Index.ENTRIES_SEPARATOR).append("ringtone_type=type_default");
        goto L13
    L10:
        r0.append("android.intent.extra.ringtone.TYPE=2|title=").append(this.mContext.getString(r7) + this.mContext.getString(R.string.vibration_tips) + Index.ENTRIES_SEPARATOR).append("ringtone_type=type_calendar");
        goto L13
    L11:
        r0.append("android.intent.extra.ringtone.TYPE=4|title=").append(this.mContext.getString(r7) + this.mContext.getString(R.string.vibration_tips) + Index.ENTRIES_SEPARATOR).append("ringtone_type=type_alarm");
    L13:
        return r0.toString();
    }
}
