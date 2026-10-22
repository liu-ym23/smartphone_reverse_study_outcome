package com.android.settings.settingitemsprovider.Items;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import com.android.settings.AccessibilitySettingsHelp;
import com.android.settings.AdvancedSettingsFragment;
import com.android.settings.R;
import com.android.settings.SettingsFeature;
import com.android.settings.accessibility.AccessibilityAutoClickSettingsFragment;
import com.android.settings.accessibility.AccessibilityColorCorrectionSettingsFragment;
import com.android.settings.accessibility.AccessibilityExpertiseSettingsFragment;
import com.android.settings.accessibility.AccessibilityScreenMagnificationSettingsFragment;
import com.android.settings.accessibility.AccessibilitySettingsFragment;
import com.android.settings.accessibility.VisualAccessibilitySettingsFragment;
import com.android.settings.settingitemsprovider.Constants;
import com.android.settings.settingitemsprovider.DatabaseHelper;
import java.util.List;
import obric.app.settings.search.SettingsSwitchKeyUtil;
import settings.Settings;

/* JADX INFO: loaded from: classes2.dex */
public class SystemAdvancedSettingItems extends SettingItems {
    public static final String PACKAGE_SEARCH = "com.obric.quicksearch";
    public static final String TRIGGER_SEARCH_VIA_SLIDE_DOWN = "trigger_search_via_slide_down";

    public SystemAdvancedSettingItems(Context r1) {
        super(r1);
    }

    @Override // com.android.settings.settingitemsprovider.Items.SettingItems
    public void initItemList() {
        this.mItemList.add(new SettingItems.Items(this, R.string.advanced_settings_header_title, null, Constants.COMPONENT_ADVANCED, null, true, R.string.advanced_settings_header_title, R.string.system_advanced_settings_desc));
        if (SettingsFeature.isSupportSwapAiAndPowerKey() == false) goto L5;
        this.mItemList.add(new SettingItems.Items(this, R.string.swap_ai_and_power_key, null, true, SettingsSwitchKeyUtil.SettingTable.System, AdvancedSettingsFragment.SWAP_AI_AND_POWER, null, "0", true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.swap_ai_and_power_key}), null));
    L5:
        this.mItemList.add(new SettingItems.Items(this, R.string.language_settings, null, Constants.COMPONENT_IME, null, true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.language_settings}), R.string.language_and_keyboard_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.language_select_page_title, R.string.alias_language, Constants.COMPONENT_IME, null, true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.language_settings, R.string.language_select_page_title}), R.string.language_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.autofill_app, null, Constants.COMPONENT_IME, null, true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.language_settings, R.string.autofill_app}), R.string.auto_fill_service_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.security_keyboard, null, true, SettingsSwitchKeyUtil.SettingTable.Global, com.android.settings.Constants.SAFE_KEYBOARD_SWITCH, null, "1", true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.language_settings, R.string.security_keyboard}), R.string.secure_keyboard_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.language_item_title_set_default_inputmethod, null, Constants.COMPONENT_IME, null, true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.language_item_title_set_default_inputmethod}), R.string.default_input_method_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.language_keyboard_doubao, null, Constants.COMPONENT_IME, null, true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.language_settings, R.string.language_keyboard_doubao}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.system_navigation_mode, null, Constants.COMPONENT_NAV_BAR_SETTINGS, null, true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.system_navigation_mode}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.navbar_virtual_keys_mode, null, Constants.COMPONENT_NAV_BAR_SETTINGS, null, true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.system_navigation_mode, R.string.navbar_virtual_keys_mode}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.hide_navigation_handle, null, true, SettingsSwitchKeyUtil.SettingTable.System, Settings.Global.KEY_HIDE_NAVIGATION_BAR, null, "0", isGestureNavigationMode(), buildPath(new int[]{R.string.advanced_settings_header_title, R.string.system_navigation_mode, R.string.hide_navigation_handle}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.accessibility_expertise_settings_title, null, Constants.COMPONENT_FRAGMENT_SKIPPER, "FragmentName=" + AccessibilityExpertiseSettingsFragment.class.getName(), true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.accessibility_expertise_settings_title}), R.string.accessibility_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.accessibility_blind_mode, null, Constants.COMPONENT_FRAGMENT_SKIPPER, "FragmentName=" + VisualAccessibilitySettingsFragment.class.getName(), true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.accessibility_expertise_settings_title, R.string.accessibility_blind_mode}), R.string.visual_accessibility_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.accessibility_screen_magnification, null, Constants.COMPONENT_FRAGMENT_SKIPPER, "FragmentName=" + AccessibilityScreenMagnificationSettingsFragment.class.getName(), true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.accessibility_expertise_settings_title, R.string.accessibility_blind_mode, R.string.accessibility_screen_magnification}), R.string.magnification_gestures_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.accessibility_screen_magnification_enable, null, true, "secure", "accessibility_display_magnification_enabled", null, "0", true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.accessibility_expertise_settings_title, R.string.accessibility_blind_mode, R.string.accessibility_screen_magnification, R.string.accessibility_screen_magnification_enable}), R.string.triple_tap_to_zoom_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.accessibility_large_pointer_icon, null, true, "secure", "accessibility_large_pointer_icon", null, "0", true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.accessibility_expertise_settings_title, R.string.accessibility_blind_mode, R.string.accessibility_large_pointer_icon}), R.string.large_mouse_pointer_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.accessibility_color_correction, null, Constants.COMPONENT_FRAGMENT_SKIPPER, "FragmentName=" + AccessibilityColorCorrectionSettingsFragment.class.getName(), true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.accessibility_expertise_settings_title, R.string.accessibility_blind_mode, R.string.accessibility_color_correction}), R.string.color_correction_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.accessibility_color_correction, null, true, "secure", "accessibility_display_daltonizer_enabled", null, "0", true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.accessibility_expertise_settings_title, R.string.accessibility_blind_mode, R.string.accessibility_color_correction, R.string.accessibility_color_correction}), R.string.color_correction_desc));
        int r0 = android.provider.Settings.Secure.getInt(this.mContext.getContentResolver(), "accessibility_display_daltonizer_enabled", 12);
        List<SettingItems.Items> r9 = this.mItemList;
        String r4 = Constants.COMPONENT_DALTONIZER_TYPE;
        if (r0 != 1) goto L8;
        boolean r6 = true;
        int r1 = 5;
    L9:
        int[] r2 = new int[r1];
        r2 = {x083a: FILL_ARRAY_DATA , data: [2131951985, 2131951733, 2131951712, 2131951716, 2131953589} // fill-array;
        r9.add(new SettingItems.Items(this, R.string.daltonizer_type, null, r4, null, r6, buildPath(r2), R.string.correction_mode_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.accessibility_text_high_contrast, null, true, "secure", "high_text_contrast_enabled", null, "0", true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.accessibility_expertise_settings_title, R.string.accessibility_blind_mode, R.string.accessibility_text_high_contrast}), R.string.high_contrast_text_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.accessibility_color_inversion, null, true, "secure", "accessibility_display_inversion_enabled", null, "0", true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.accessibility_expertise_settings_title, R.string.accessibility_blind_mode, R.string.accessibility_color_inversion}), R.string.color_inversion_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.accessibility_toggle_master_mono_title, null, true, SettingsSwitchKeyUtil.SettingTable.System, "master_mono", null, "0", true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.accessibility_expertise_settings_title, R.string.accessibility_toggle_master_mono_title}), R.string.mono_audio_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.accessibility_autoclick_preference_title, null, Constants.COMPONENT_FRAGMENT_SKIPPER, "FragmentName=" + AccessibilityAutoClickSettingsFragment.class.getName(), true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.accessibility_expertise_settings_title, R.string.accessibility_autoclick_preference_title}), R.string.click_after_pointer_stops_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.accessibility_autoclick_start_service, null, true, "secure", "accessibility_autoclick_enabled", null, "0", true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.accessibility_expertise_settings_title, R.string.accessibility_autoclick_preference_title, R.string.accessibility_autoclick_start_service}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.accessibility_long_press_timeout_title, null, Constants.COMPONENT_LONG_PRESS_TIMEOUT, null, true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.accessibility_expertise_settings_title, R.string.accessibility_long_press_timeout_title}), R.string.long_press_delay_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.accessibility_power_button_ends_call_prerefence_title, null, true, "secure", "incall_power_button_behavior", null, Integer.toString(1), true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.accessibility_expertise_settings_title, R.string.accessibility_power_button_ends_call_prerefence_title}), R.string.end_call_by_power_button_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.date_time_temperature_title, R.string.temperature_unit_title, Constants.COMPONENT_DATE_TIME, null, true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.date_time_temperature_title}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.date_time_auto_set, null, true, SettingsSwitchKeyUtil.SettingTable.Global, "auto_time", null, "1", true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.date_time_temperature_title, R.string.date_time_auto_set}), R.string.auto_settings_desc));
        int r10 = android.provider.Settings.Global.getInt(this.mContext.getContentResolver(), "auto_time", 1);
        List<SettingItems.Items> r11 = this.mItemList;
        String r5 = Constants.COMPONENT_DATE_TIME;
        if (r10 != 0) goto L12;
        boolean r7 = true;
    L13:
        r11.add(new SettingItems.Items(this, R.string.date_time_date, null, r5, null, r7, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.date_time_temperature_title, R.string.date_time_date}), R.string.date_desc));
        List<SettingItems.Items> r12 = this.mItemList;
        String r8 = Constants.COMPONENT_DATE_TIME;
        if (r10 != 0) goto L16;
        boolean r13 = true;
    L17:
        r12.add(new SettingItems.Items(this, R.string.date_time_time, null, r8, null, r13, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.date_time_temperature_title, R.string.date_time_time}), R.string.time_desc));
        List<SettingItems.Items> r14 = this.mItemList;
        String r15 = Constants.COMPONENT_TIMEZONE;
        if (r10 != 0) goto L20;
        boolean r16 = true;
    L21:
        r14.add(new SettingItems.Items(this, R.string.date_time_zone, null, r15, null, r16, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.date_time_temperature_title, R.string.date_time_zone}), R.string.time_zone_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.date_time_display_mode, null, true, null, null, "time_12_24", "0", true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.date_time_temperature_title, R.string.date_time_display_mode}), R.string.format_24_hour_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.advanced_item_assistant, null, Constants.COMPONENT_APP_ACCESSIBILITY, null, true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.advanced_item_assistant}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.pocket_mode, null, true, SettingsSwitchKeyUtil.SettingTable.System, AccessibilitySettingsFragment.POCKET_MODE, null, "1", true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.advanced_item_assistant, R.string.pocket_mode}), R.string.pocket_anti_mis_operation_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.title_scheduled_power_on_and_off, null, Constants.COMPONENT_SCHEDULED_POWER_ON_AND_OFF, null, true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.advanced_item_assistant, R.string.title_scheduled_power_on_and_off}), R.string.scheduled_power_on_off_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.title_earthquake_warning, null, Constants.COMPONENT_APP_EARTHQUAKE, null, false, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.advanced_item_assistant, R.string.title_earthquake_warning}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.tts_settings_title, null, Constants.COMPONENT_TTS_SETTINGS, null, false, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.advanced_item_assistant, R.string.tts_settings_title}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.accessibility_services_title, null, Constants.COMPONENT_APP_ACCESSIBILITY, null, true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.advanced_item_assistant, R.string.accessibility_services_title}), null));
        if (AccessibilitySettingsHelp.INSTANCE.isShowUserExperienceEntry() == false) goto L24;
        this.mItemList.add(new SettingItems.Items(this, R.string.ue_title, null, true, SettingsSwitchKeyUtil.SettingTable.Global, "join_ue_on", null, "1", true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.advanced_item_assistant, R.string.ue_title}), R.string.join_user_experience_program_desc));
    L24:
        this.mItemList.add(new SettingItems.Items(this, R.string.advanced_item_account, null, Constants.COMPONENT_APP_ACCOUNTS, null, true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.advanced_item_account}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.advanced_item_zte_backup, null, Constants.COMPONENT_APP_ZTE_BACKUP, null, true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.advanced_item_zte_backup}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.advanced_item_restore, this.mContext.getString(R.string.alias_master_clear) + this.mContext.getString(R.string.alias_master_clear_1), Constants.COMPONENT_APP_MASTER_CLEAR, null, true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.advanced_item_restore}), R.string.factory_reset_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.google_service_title, null, Constants.COMPONENT_GOOGLE_SERVICE, null, SettingsFeature.isGoogleSettingsAvailable(this.mContext), buildPath(new int[]{R.string.advanced_settings_header_title, R.string.google_service_title}), R.string.google_service_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.advanced_item_development, null, Constants.COMPONENT_DEVELOP_SETTINGS, null, this.mContext.getSharedPreferences("development", 0).getBoolean("show", false), buildPath(new int[]{R.string.advanced_settings_header_title, R.string.advanced_item_development}), R.string.developer_options_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.search_in_settings, null, Constants.COMPONENT_QUICKSEARCH_SETTINGS, null, true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.search_in_settings}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.switch_enable_pull_title, null, true, SettingsSwitchKeyUtil.SettingTable.Global, TRIGGER_SEARCH_VIA_SLIDE_DOWN, null, "1", true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.search_in_settings, R.string.switch_enable_pull_title}), null));
        this.mItemList.add(new SettingItems.Items(this, getPackageString(this.mContext, "com.obric.quicksearch", "search_history"), null, true, SettingsSwitchKeyUtil.SettingTable.Global, "search_history", null, "1", true, buildPath(new String[]{this.mContext.getString(R.string.advanced_settings_header_title), getPackageString(this.mContext, "com.obric.quicksearch", "search_history")}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.allowed_search_project, null, Constants.COMPONENT_SEARCH_SETTINGS, null, true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.search_in_settings, R.string.allowed_search_project}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.pinyin_fuzzy_tone_search_settings, null, Constants.COMPONENT_FUZZY_TONE_SETTINGS, null, true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.search_in_settings, R.string.pinyin_fuzzy_tone_search_settings}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.pinyin_fuzzy_tone_search_settings, null, true, SettingsSwitchKeyUtil.SettingTable.Global, "fuzzy_tones_enabled", null, "0", true, buildPath(new int[]{R.string.advanced_settings_header_title, R.string.search_in_settings, R.string.pinyin_fuzzy_tone_search_settings, R.string.pinyin_fuzzy_tone_search_settings}), null));
        return;
    L20:
        r16 = false;
        goto L21
    L16:
        r13 = false;
        goto L17
    L12:
        r7 = false;
        goto L13
    L8:
        r1 = 5;
        r6 = false;
        goto L9
    }

    public static void updateItems(Handler r8, Context r9, SQLiteDatabase r10) {
        if (android.provider.Settings.Secure.getInt(r9.getContentResolver(), "accessibility_display_daltonizer_enabled", 12) != 1) goto L5;
        String r0 = "1";
    L6:
        executeUpdate(r8, r9, r10, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r0, "name", r9.getString(R.string.daltonizer_type));
        return;
    L5:
        r0 = "0";
        goto L6
    }

    public static void updateTimeItems(Handler r9, Context r10, SQLiteDatabase r11, boolean r12) {
        if (r12 == false) goto L4;
        String r13 = "0";
    L5:
        String r4 = r13;
        executeUpdate(r9, r10, r11, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r4, "name", r10.getString(R.string.date_time_date));
        executeUpdate(r9, r10, r11, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r4, "name", r10.getString(R.string.date_time_time));
        executeUpdate(r9, r10, r11, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r4, "name", r10.getString(R.string.date_time_zone));
        return;
    L4:
        r13 = "1";
        goto L5
    }

    public static void updateHideNavigationHandleItems(Handler r8, Context r9, SQLiteDatabase r10) {
        if (isGestureNavigationMode(r9) == false) goto L5;
        String r0 = "1";
    L6:
        executeUpdate(r8, r9, r10, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r0, DatabaseHelper.ItemsRecord.ITEM_PATH_1, getHideNavigationHandleItemPath(r9));
        return;
    L5:
        r0 = "0";
        goto L6
    }

    private static String getHideNavigationHandleItemPath(Context r3) {
        return buildPath(new String[]{r3.getString(R.string.advanced_settings_header_title), r3.getString(R.string.system_navigation_mode), r3.getString(R.string.hide_navigation_handle)});
    }

    private boolean isGestureNavigationMode() {
        return isGestureNavigationMode(this.mContext);
    }

    private static boolean isGestureNavigationMode(Context r2) {
        if (android.provider.Settings.Global.getInt(r2.getContentResolver(), "navigationbar_trigger_mode", 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static void updateDevelopmentItems(Handler r7, Context r8, SQLiteDatabase r9, boolean r10) {
        if (r10 == false) goto L4;
        String r11 = "1";
    L5:
        executeUpdate(r7, r8, r9, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r11, "name", r8.getString(R.string.advanced_item_development));
        return;
    L4:
        r11 = "0";
        goto L5
    }

    public static void updateGoogleServiceItems(Handler r8, Context r9, SQLiteDatabase r10) {
        if (SettingsFeature.isGoogleSettingsAvailable(r9) == false) goto L5;
        String r0 = "1";
    L6:
        executeUpdate(r8, r9, r10, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r0, "name", r9.getString(R.string.google_service_title));
        return;
    L5:
        r0 = "0";
        goto L6
    }
}
