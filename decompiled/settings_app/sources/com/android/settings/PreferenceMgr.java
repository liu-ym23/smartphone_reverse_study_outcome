package com.android.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* JADX INFO: loaded from: classes2.dex */
public class PreferenceMgr {
    public static final String KEY_BIGBANG_VIDEO_PLAYED = "bigbang_video_played";
    public static final String KEY_BUILD_SEARCH_INDEX = "build_search_index";
    public static final String KEY_FACE_RECOGNITION_DATA_EXIST = "face_recognition_data_exist";
    public static final String KEY_FORMAL_IDEA_PILLS_APP_NOTIFICATION = "formal_idea_pills_app_notification";
    public static final String KEY_GESTURE_VIDEO_VERSION = "gesture_video_version";
    public static final String KEY_GLOABLE_SEARCH_CONFIG_SYNC_RETRY_TIME = "gloable_search_config_sync_retry_time";
    public static final String KEY_GLOABLE_SEARCH_CONFIG_SYNC_SUCCES_TIME = "gloable_search_config_sync_success_time";
    public static final String KEY_GLOBAL_VIBRATION_ENABLED_RECORD = "global_vibration_enabled_record";
    public static final String KEY_GLOBAL_VIBRATION_ENABLED_USER = "global_vibration_enabled_user";
    public static final String KEY_HOURLY_CHIME_TIMESET_MILLIS = "hourly_chime_timeset_millis";
    public static final String KEY_LAST_EXT_DISPLAY_CONNECT_STATE = "last_ext_display_connect_state";
    public static final String KEY_LAST_HAPTIC_FEEDBACK_ENABLED = "last_haptic_feedback_enabled";
    public static final String KEY_OCR_LANGUAGE_SET_BY_USER = "OCR_language_set_by_user";
    public static final String KEY_OCR_LANGUAGE_WARNING_SELECTED_TOO_MUCH = "key_ocr_language_warning_selected_too_much";
    public static final String KEY_PHONE_CASE_FUNC_VALUES = "phone_case_func_values";
    public static final String KEY_PHONE_CASE_STATE = "phone_case_state";
    public static final String KEY_PROMPT_SETUP_IDEA_PILLS_SHORTCUT = "prompt_setup_idea_pills_shortcut";
    public static final String KEY_ROM_VERSION = "rom_version";
    public static final String KEY_SHORTCUT_SQUEEZE = "squeeze_side_shortcut";
    public static final String KEY_SHORTCUT_SQUEEZE_VOL_UP = "squeeze_side_shortcut_vol_up";
    public static final String KEY_SPEECH_GLOBAL_OCR = "speech_global_ocr";
    public static final String KEY_SPEECH_READING_LUNCHED = "is_speech_lunched";
    public static final String KEY_SPEECH_READING_PROTECTION = "speech_reading_protection";
    public static final String KEY_SPEECH_READING_WARNING_SHOWN = "is_speech_reading_warning_shown";
    public static final String KEY_SPEECH_TALKBACK = "speech_talk_back";
    public static final String KEY_SPEECH_VOICE_COMMAND = "speech_voice_command";
    public static final String KEY_TALKBACK_ENABLED_IN_SUW = "talkback_enabled_in_suw";
    public static final String KEY_TEXT_BOOM_MEMORY_WARNED = "text_boom_memory_warned";
    public static final String KEY_TNT_SCREEN_COLOR_PROGRESS = "tnt_screen_color_progress";
    public static final String SETTINGS_PREFERENCES_PRIVACY_ALLOWED = "privacy_has_allowed";
    private static PreferenceMgr mInstance;
    private SharedPreferences mPrefs;

    private PreferenceMgr(Context r1) {
        this.mPrefs = PreferenceManager.getDefaultSharedPreferences(r1);
    }

    public static PreferenceMgr getInstance(Context r1) {
        if (mInstance != null) goto L6;
        mInstance = new PreferenceMgr(r1.getApplicationContext());
    L6:
        return mInstance;
    }

    public void putBoolean(String r1, boolean r2) {
        this.mPrefs.edit().putBoolean(r1, r2).apply();
    }

    public void putString(String r1, String r2) {
        this.mPrefs.edit().putString(r1, r2).apply();
    }

    public void putLong(String r1, long r2) {
        this.mPrefs.edit().putLong(r1, r2).apply();
    }

    public void putInt(String r1, int r2) {
        this.mPrefs.edit().putInt(r1, r2).apply();
    }

    public boolean putIntSync(String r1, int r2) {
        return this.mPrefs.edit().putInt(r1, r2).commit();
    }

    public boolean getBoolean(String r1, boolean r2) {
        return this.mPrefs.getBoolean(r1, r2);
    }

    public String getString(String r1, String r2) {
        return this.mPrefs.getString(r1, r2);
    }

    public long getLong(String r1, long r2) {
        return this.mPrefs.getLong(r1, r2);
    }

    public int getInt(String r1, int r2) {
        return this.mPrefs.getInt(r1, r2);
    }

    public void remove(String r1) {
        this.mPrefs.edit().remove(r1).apply();
    }
}
