package com.android.settings.settingitemsprovider.Items;

import android.app.DynamicRefreshRateManager;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import com.android.settings.BrightnessSettingsFragment;
import com.android.settings.DisplaySizeSettingsFragment;
import com.android.settings.R;
import com.android.settings.ScreenRefreshRateFragment;
import com.android.settings.eyesprotection.EyesProtectionTimer;
import com.android.settings.intelligent.GlobalAssistantFragment;
import com.android.settings.settingitemsprovider.Constants;
import com.android.settings.settingitemsprovider.DatabaseHelper;
import java.util.List;
import obric.app.settings.search.SettingsSwitchKeyUtil;
import settings.Settings;

/* JADX INFO: loaded from: classes2.dex */
public class BrightnessSettingItems extends SettingItems {
    public BrightnessSettingItems(Context r1) {
        super(r1);
    }

    @Override // com.android.settings.settingitemsprovider.Items.SettingItems
    public void initItemList() {
        this.mItemList.add(new SettingItems.Items(this, R.string.brightness_header_title, null, Constants.COMPONENT_BRIGHTNESS, null, true, R.string.brightness_header_title, R.string.display_and_brightness_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.display_mode, null, Constants.COMPONENT_DISPLAY_MODE, null, true, buildPath(new int[]{R.string.brightness_header_title, R.string.display_mode}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.display_light_mode, null, Constants.COMPONENT_DISPLAY_MODE, null, true, buildPath(new int[]{R.string.brightness_header_title, R.string.display_mode, R.string.display_light_mode}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.display_dark_mode, null, Constants.COMPONENT_DISPLAY_MODE, null, true, buildPath(new int[]{R.string.brightness_header_title, R.string.display_mode, R.string.display_dark_mode}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.time_to_open_dark_mode, null, true, null, null, SettingsSwitchKeyUtil.AUTO_DARK_MODE, "0", true, buildPath(new int[]{R.string.brightness_header_title, R.string.display_mode, R.string.time_to_open_dark_mode}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.auto_rotation_header_title, this.mContext.getString(R.string.alias_rotation) + this.mContext.getString(R.string.alias_rotation_1), true, null, null, "rotation", "0", true, buildPath(new int[]{R.string.brightness_header_title, R.string.auto_rotation_header_title}), R.string.auto_rotate_screen_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.brightness_title, null, Constants.COMPONENT_BRIGHTNESS, null, true, buildPath(new int[]{R.string.brightness_header_title, R.string.brightness_title}), R.string.brightness_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.brightness_auto_switch, null, true, SettingsSwitchKeyUtil.SettingTable.System, "screen_brightness_mode", null, "0", true, buildPath(new int[]{R.string.brightness_header_title, R.string.brightness_auto_switch}), R.string.auto_adjust_screen_brightness_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.security_auto_lock_time, null, Constants.COMPONENT_SCREENOFF_TIMEOUT_SETTINGS, null, true, buildPath(new int[]{R.string.brightness_header_title, R.string.security_auto_lock_time}), R.string.screen_lock_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.title_light_doze_mode, null, Constants.COMPONENT_DOZE_MODE, null, true, buildPath(new int[]{R.string.brightness_header_title, R.string.title_light_doze_mode}), R.string.always_on_display_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.adaptive_sleep_title, null, true, "secure", "adaptive_sleep", null, "0", true, buildPath(new int[]{R.string.brightness_header_title, R.string.adaptive_sleep_title}), R.string.gaze_awake_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.title_click_week_screen, null, true, SettingsSwitchKeyUtil.SettingTable.Global, GlobalAssistantFragment.DOUBLECLICK_ENABLE_ASSIST_ON, null, "0", false, buildPath(new int[]{R.string.brightness_header_title, R.string.title_click_week_screen}), R.string.double_tap_to_wake_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.title_single_click_wake_screen, null, true, null, null, SettingsSwitchKeyUtil.CLICK_WAKE_SCREEN, "0", true, buildPath(new int[]{R.string.brightness_header_title, R.string.title_single_click_wake_screen}), R.string.single_click_wake_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.title_double_tap_to_sleep, null, true, "secure", "double_tap_to_sleep", null, "1", true, buildPath(new int[]{R.string.brightness_header_title, R.string.title_double_tap_to_sleep}), R.string.double_tap_to_sleep_tips));
        this.mItemList.add(new SettingItems.Items(this, R.string.title_light_screen_pick_up, null, true, SettingsSwitchKeyUtil.SettingTable.Global, Settings.Global.PICKUP_ENABLE, null, "0", true, buildPath(new int[]{R.string.brightness_header_title, R.string.title_light_screen_pick_up}), R.string.raise_to_wake_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.screen_color_and_temperature, null, Constants.COMPONENT_SCREEN_COLOR_TEMPERATURE, null, true, buildPath(new int[]{R.string.brightness_header_title, R.string.screen_color_and_temperature}), R.string.screen_color_and_color_temperature_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.adaptive_temperature, null, true, SettingsSwitchKeyUtil.SettingTable.Global, "screen_color_temperature_adaptive", null, "0", true, buildPath(new int[]{R.string.brightness_header_title, R.string.screen_color_and_temperature, R.string.adaptive_temperature}), R.string.adaptive_color_temperature_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.settings_resolution, null, Constants.COMPONENT_BRIGHTNESS, null, true, buildPath(new int[]{R.string.brightness_header_title, R.string.settings_resolution}), R.string.settings_resolution_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.resolution_UHD, null, Constants.COMPONENT_BRIGHTNESS, null, true, buildPath(new int[]{R.string.brightness_header_title, R.string.settings_resolution, R.string.resolution_UHD}), R.string.settings_resolution_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.resolution_auto, null, Constants.COMPONENT_BRIGHTNESS, null, true, buildPath(new int[]{R.string.brightness_header_title, R.string.settings_resolution, R.string.resolution_auto}), R.string.resolution_auto_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.screen_refresh_reta, null, Constants.COMPONENT_FRAGMENT_SKIPPER, "FragmentName=" + ScreenRefreshRateFragment.class.getName(), true, buildPath(new int[]{R.string.brightness_header_title, R.string.screen_refresh_reta}), R.string.screen_refresh_rate_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.auto_screen_refresh_reta, null, Constants.COMPONENT_FRAGMENT_SKIPPER, "FragmentName=" + ScreenRefreshRateFragment.class.getName(), true, buildPath(new int[]{R.string.brightness_header_title, R.string.screen_refresh_reta, R.string.auto_screen_refresh_reta}), R.string.smart_refresh_rate_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.standard_screen_refresh_reta, null, Constants.COMPONENT_FRAGMENT_SKIPPER, "FragmentName=" + ScreenRefreshRateFragment.class.getName(), true, buildPath(new int[]{R.string.brightness_header_title, R.string.screen_refresh_reta, R.string.standard_screen_refresh_reta}), R.string.standard_refresh_rate_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.high_screen_refresh_reta, null, Constants.COMPONENT_FRAGMENT_SKIPPER, "FragmentName=" + ScreenRefreshRateFragment.class.getName(), true, buildPath(new int[]{R.string.brightness_header_title, R.string.screen_refresh_reta, R.string.high_screen_refresh_reta}), R.string.high_refresh_rate_desc));
        int r0 = DynamicRefreshRateManager.getSettingConfigId();
        List<SettingItems.Items> r9 = this.mItemList;
        String r4 = Constants.COMPONENT_FRAGMENT_SKIPPER;
        String r5 = "FragmentName=" + ScreenRefreshRateFragment.class.getName();
        if (r0 != 2) goto L5;
        boolean r1 = true;
    L6:
        r9.add(new SettingItems.Items(this, R.string.use_high_screen_refresh_reta_app, null, r4, r5, r1, buildPath(new int[]{R.string.brightness_header_title, R.string.screen_refresh_reta, R.string.use_high_screen_refresh_reta_app}), R.string.apps_using_high_refresh_rate_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.dc_dimming, null, true, SettingsSwitchKeyUtil.SettingTable.System, BrightnessSettingsFragment.DC_DIMMING, null, "0", true, buildPath(new int[]{R.string.brightness_header_title, R.string.dc_dimming}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.protect_eyes_title, null, Constants.COMPONENT_EYESPROTECTION, null, true, buildPath(new int[]{R.string.brightness_header_title, R.string.protect_eyes_title}), R.string.eye_protection_mode_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.protect_eyes_night, null, true, "secure", "night_display_activated", null, "0", true, buildPath(new int[]{R.string.brightness_header_title, R.string.protect_eyes_title, R.string.protect_eyes_night}), R.string.night_eye_protection_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.font_size, null, Constants.COMPONENT_FONT_SIZE, null, false, buildPath(new int[]{R.string.brightness_header_title, R.string.font_size}), R.string.font_size_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.screen_zoom_title, null, Constants.COMPONENT_FRAGMENT_SKIPPER, "FragmentName=" + DisplaySizeSettingsFragment.class.getName(), false, buildPath(new int[]{R.string.brightness_header_title, R.string.screen_zoom_title}), R.string.screen_zoom_title_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.auto_turn_on_off_title, null, Constants.COMPONENT_FRAGMENT_SKIPPER, "FragmentName=" + EyesProtectionTimer.class.getName(), true, buildPath(new int[]{R.string.brightness_header_title, R.string.protect_eyes_title, R.string.auto_turn_on_off_title}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.rhythmic_eye_protection_title, null, true, "secure", "rhythm_temperature_mode", null, "1", true, buildPath(new int[]{R.string.brightness_header_title, R.string.protect_eyes_title, R.string.rhythmic_eye_protection_title}), R.string.rhythmic_eye_protection_tips));
        this.mItemList.add(new SettingItems.Items(this, R.string.color_temperature_adjustment_title, null, Constants.COMPONENT_EYESPROTECTION, null, true, buildPath(new int[]{R.string.brightness_header_title, R.string.protect_eyes_title, R.string.color_temperature_adjustment_title}), null));
        return;
    L5:
        r1 = false;
        goto L6
    }

    public static void updateItems(Handler r7, Context r8, SQLiteDatabase r9, int r10) {
        if (r10 != 2) goto L5;
        String r11 = "1";
    L6:
        executeUpdate(r7, r8, r9, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r11, "name", r8.getString(R.string.use_high_screen_refresh_reta_app));
        return;
    L5:
        r11 = "0";
        goto L6
    }

    public static void updateRhythmicEyeProtection(Handler r7, Context r8, SQLiteDatabase r9, boolean r10) {
        if (r10 == false) goto L4;
        String r11 = "1";
    L5:
        executeUpdate(r7, r8, r9, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r11, "name", r8.getString(R.string.rhythmic_eye_protection_title));
        return;
    L4:
        r11 = "0";
        goto L5
    }
}
