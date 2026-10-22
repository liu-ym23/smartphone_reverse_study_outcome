package com.android.settings;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.hardware.fingerprint.Fingerprint;
import android.hardware.fingerprint.FingerprintManager;
import android.icu.text.PluralRules;
import android.net.Uri;
import android.nfc.NfcAdapter;
import android.text.TextUtils;
import bytedanceos.api.StorageManagerSmt;
import bytedanceos.util.SettingsUtil;
import com.android.internal.inputmethod.InputMethodUtils;
import com.android.settings.accessibility.AccessibilitySettingsFragment;
import com.android.settings.applications.PreferredSettingsUtils;
import com.android.settings.fuelgauge.BatteryHistoryDetail;
import com.android.settings.textboom.OCRLanguageChooserFragment;
import com.bytedance.bdinstall.Api;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import obric.app.settings.search.SettingsSwitchKeyUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SettingsTracker {
    public static final String APP_NAME = "app_name";
    public static final int HOURS = 12;
    private static final String KEY_CURRENT_SCHEDULE_TIMESTAMP = "key_current_schedule_timestamp";
    private static final String KEY_LAST_TRACK_ALL_TIMESTAMP = "key_last_track_all_timestamp";
    public static final long PERIOD_UPLOAD_TRACK = 43200000;
    private static final List<String> STATISTICS_INTEGER_TYPE = null;
    public static final String STATUS = "status";
    private static final String TAG = "SettingsTracker";

    public static void flush() {
    }

    public static void init(Application r0) {
    }

    public SettingsTracker() {
    }

    static /* synthetic */ void access$000(Context r0) {
        trackAll(r0);
    }

    static {
        ArrayList r0 = new ArrayList();
        STATISTICS_INTEGER_TYPE = r0;
        r0.add("finger_num");
        r0.add("lock_paper_num");
        r0.add("desk_paper_num");
        r0.add("screen_off");
        r0.add("id");
        r0.add("status");
    }

    public static void onLaunch() {
        OLog.d(TAG, "onLaunch ");
    }

    public static void onSwitcherClick(int r2, boolean r3) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("id", Integer.valueOf(r2));
        r0.put("status", Integer.valueOf(r3 ? 1 : 0));
        JSONObject r4 = LinkedHashMapToJson(r0);
        if (r4 == null) goto L6;
        OLog.d(TAG, "onSwitcherChanged: " + r4);
        return;
    }

    private static JSONObject LinkedHashMapToJson(LinkedHashMap<String, Object> r4) {
        JSONObject r0 = new JSONObject();
        Iterator<Map.Entry<String, Object>> r5 = r4.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L14;
        Map.Entry<String, Object> r1 = r5.next();
        if (STATISTICS_INTEGER_TYPE.contains(r1.getKey()) == true) goto L8;
        r0.put(r1.getKey(), String.valueOf(r1.getValue()));     // Catch: JSONException -> L11
        goto L4
    L8:
        r0.put(r1.getKey(), r1.getValue());     // Catch: JSONException -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
        OLog.d(TAG, "LinkedHashMapToJson catch JSONException " + e.getMessage());
        return null;
    L14:
        return r0;
    }

    public static void onEvent(String r2) {
        OLog.d(TAG, "onEvent " + r2);
    }

    public static void onEvent(String r2, String r3, Object r4) {
        OLog.d(TAG, "onEvent " + r2);
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put(r3, r4);
        onEvent(r2, r0);
    }

    public static void onEvent(String r3, LinkedHashMap<String, Object> r4) {
        OLog.d(TAG, "onEvent " + r3);
        JSONObject r5 = LinkedHashMapToJson(r4);
        if (r5 == null) goto L6;
        OLog.d(TAG, "onEvent " + r3 + " jsonObject:\n" + r5.toString());
        return;
    }

    public static void onSwitchStatus(String r2, String r3, boolean r4) {
        OLog.d(TAG, "onSwitchStatus " + r2);
        onStatus(r2, r3, Integer.valueOf(r4 ? 1 : 0));
    }

    public static void onStatus(String r2, String r3, Object r4) {
        OLog.d(TAG, "onStatus " + r2);
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put(r3, r4);
        onStatus(r2, r0);
    }

    public static void onStatus(String r0, LinkedHashMap<String, Object> r1) {
        if (r1.isEmpty() == false) goto L5;
        return;
    L5:
        LinkedHashMapToJson(r1);
    }

    private static void onStatus(String r2, JSONObject r3) {
        if (r3 == null) goto L5;
        OLog.d(TAG, "onStatus " + r2 + " jsonObject:\n" + r3.toString());
        return;
    }

    public static void onItemClick(int r3) {
        OLog.d(TAG, "onItemClick " + r3);
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("id", String.valueOf(r3));
        JSONObject r4 = LinkedHashMapToJson(r0);
        if (r4 == null) goto L6;
        OLog.d(TAG, "onClick: " + r4);
        return;
    }

    public static void flushAll(final Context r9, boolean r10) {
        PreferenceMgr r0 = PreferenceMgr.getInstance(r9.getApplicationContext());
        long r1 = r0.getLong(KEY_LAST_TRACK_ALL_TIMESTAMP, Long.MAX_VALUE);
        long r4 = System.currentTimeMillis();
        long r2 = Math.abs(r4 - r1);
        if (r10 == false) goto L5;
    L8:
        OLog.d(TAG, "track all");
        r0.putLong(KEY_LAST_TRACK_ALL_TIMESTAMP, r4);
        ExecutorManager.execute(new AnonymousClass1(r9));
        return;
    L5:
        if (r2 > PERIOD_UPLOAD_TRACK) goto L8;
        OLog.d(TAG, "no need track all, time diff = " + r2);
    }

    private static synchronized void trackAll(Context r8) {
        monitor-enter(SettingsTracker.class);
        ContentResolver r1 = r8.getContentResolver();     // Catch: Throwable -> L26
        onSwitchStatus("A131000", "GPS", android.provider.Settings.Secure.isLocationProviderEnabled(r1, "network"));     // Catch: Throwable -> L26
        boolean r6 = true;
        if (android.provider.Settings.Global.getInt(r1, "wifi_sleep_policy", 2) != 2) goto L7;
        boolean r4 = true;
    L8:
        onSwitchStatus("A131001", "close_screen", r4);     // Catch: Throwable -> L26
        String r2 = android.provider.Settings.System.getString(r1, "disable_notification");     // Catch: Throwable -> L26
        if (r2 == null) goto L11;
        boolean r3 = !Boolean.parseBoolean(r2);     // Catch: Throwable -> L26
    L12:
        onSwitchStatus("A131016", "display_msg", r3);     // Catch: Throwable -> L26
        if (23 != BluetoothAdapter.getDefaultAdapter().getScanMode()) goto L15;
        onStatus("A131003", "other_search", 1);     // Catch: Throwable -> L26
    L17:
        if (SettingsFeature.isSupportNetOnNonDataSim() == true) goto L19;
    L23:
        trackNFC(r8);     // Catch: Throwable -> L26
        trackBigBang(r8);     // Catch: Throwable -> L26
        trackWallpaperThemeIcons(r8);     // Catch: Throwable -> L26
        trackLauncherSettings(r8);     // Catch: Throwable -> L26
        trackerDisplaySettings(r8);     // Catch: Throwable -> L26
        trackSoundSettings(r8);     // Catch: Throwable -> L26
        trackObsessionSettings(r8);     // Catch: Throwable -> L26
        trackShortKeySettings(r8);     // Catch: Throwable -> L26
        trackOnehandSettings(r8);     // Catch: Throwable -> L26
        trackLockscreenSecurity(r8);     // Catch: Throwable -> L26
        trackAppManagerSettings(r8);     // Catch: Throwable -> L26
        trackLanguageAndImSettings(r8);     // Catch: Throwable -> L26
        trackAdvanceSettings(r8);     // Catch: Throwable -> L26
        trackNavigationSettings(r8);     // Catch: Throwable -> L26
        monitor-exit(SettingsTracker.class);
        return;
    L19:
        if (android.provider.Settings.Global.getInt(r1, Constants.NET_ON_NON_DATA_SIM_KEY, 0) == 1) goto L22;
        r6 = false;
    L22:
        onSwitchStatus("A131004", "undata_sim", r6);     // Catch: Throwable -> L26
        goto L23
    L15:
        onStatus("A131003", "other_search", 0);     // Catch: Throwable -> L26
        goto L17
    L11:
        r3 = false;
        goto L12
    L7:
        r4 = false;
    L26:
        th = move-exception;
        throw th;
    }

    public static boolean isNFCOn(Context r3) {
        NfcAdapter r4 = NfcAdapter.getDefaultAdapter(r3);     // Catch: Exception -> L9
        if (r4 == null) goto L14;
        if (r4.getAdapterState() != 3) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    L9:
        e = move-exception;
        OLog.e(TAG, "isNFCOn exception: " + e);
        return false;
    }

    private static boolean isBeamOn(Context r0) {
        NfcAdapter r1 = NfcAdapter.getDefaultAdapter(r0);
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.isNdefPushEnabled();
    }

    private static boolean isBlueToothOn() {
        BluetoothAdapter r0 = BluetoothAdapter.getDefaultAdapter();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isEnabled();
    }

    private static boolean isUnset(ResolveInfo r3) {
        if (r3 != null) goto L5;
        return true;
    L5:
        if (r3.activityInfo != null) goto L7;
        return true;
    L7:
        if (PreferredSettingsUtils.COMPONENT_RESOLVERACTIVITY.equals(r3.activityInfo.name) == false) goto L9;
        return true;
    L9:
        if (PreferredSettingsUtils.COMPONENT_RESOLVERACTIVITY_ANDROID.equals(r3.activityInfo.name) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static void trackNFC(Context r5) {
    L17:
        e = move-exception;
        OLog.e(TAG, "trackNFC: unexpected error", e);
        return;
    L3:
        if (Utils.isNfcSupport(r5) == true) goto L5;
        return;
    L5:
        if (NfcAdapter.getDefaultAdapter(r5) != null) goto L7;
        return;
    L7:
        LinkedHashMap r0 = new LinkedHashMap();     // Catch: Exception -> L17
        int r3 = 1;
        if (isNFCOn(r5) == false) goto L10;
        int r2 = 1;
    L11:
        r0.put("NFC", Integer.valueOf(r2));     // Catch: Exception -> L17
        if (isBeamOn(r5) == true) goto L15;
        r3 = 0;
    L15:
        r0.put(SettingsSwitchKeyUtil.BEAM, Integer.valueOf(r3));     // Catch: Exception -> L17
        onStatus("A131005", r0);     // Catch: Exception -> L17
        return;
    L10:
        r2 = 0;
        goto L11
    }

    public static void trackBigBang(Context r4) {
        ContentResolver r0 = r4.getContentResolver();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put(TrackerConstants.BIGBANG, Integer.valueOf(android.provider.Settings.Global.getInt(r0, "text_boom", 1)));
        r1.put("pic", Integer.valueOf(android.provider.Settings.Global.getInt(r0, "big_bang_ocr", 0)));
        r1.put("touch_area", Integer.valueOf(android.provider.Settings.Global.getInt(r0, "boom_text_trigger_area", 2)));
        r1.put("def_search", Integer.valueOf(android.provider.Settings.Global.getInt(r0, "text_boom_search_method", 3)));
        r1.put("def_dic", Integer.valueOf(android.provider.Settings.Global.getInt(r0, "big_bang_default_dict", 256)));
        JSONObject r2 = LinkedHashMapToJson(r1);
        r2.put(Api.KEY_LANGUAGE, getOCRLangArray(r4));     // Catch: JSONException -> L5
    L7:
        onStatus("A131006", r2);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    private static JSONArray getOCRLangArray(Context r5) {
        String[] r0 = r5.getResources().getStringArray(R.array.ocr_language_track_name_list);
        int r6 = android.provider.Settings.Global.getInt(r5.getContentResolver(), "big_bang_ocr_language", 3);
        JSONArray r1 = new JSONArray();
        int r3 = 0;
    L4:
        if (r3 >= OCRLanguageChooserFragment.sOCRLangArray.length) goto L12;
        if ((OCRLanguageChooserFragment.sOCRLangArray[r3].intValue() & r6) <= 0) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L11;
        r1.put(r0[r3]);
    L11:
        r3 = r3 + 1;
        goto L4
    L8:
        r4 = false;
        goto L9
    L12:
        return r1;
    }

    public static void trackWallpaperThemeIcons(Context r14) {
        ContentResolver r0 = r14.getContentResolver();
        LinkedHashMap r1 = new LinkedHashMap();
        String r2 = android.provider.Settings.Global.getString(r14.getContentResolver(), "launcher_theme");
        int r4 = 0;
        int r3 = android.provider.Settings.Global.getInt(r0, "launcher_page_animation", 0);
        String r5 = ThemeChooserActivity.getCurrentTheme(r14);
        String r6 = android.provider.Settings.System.getString(r0, "lockscreen_background");
        String r9 = "";
        int r10 = -1;
        if (r6 == null) goto L20;
        String r11 = Uri.parse(r6).getLastPathSegment();
        if (r6.startsWith("android.resource://") == false) goto L7;
    L19:
        r9 = Uri.parse(r6).getLastPathSegment();
        goto L20
    L7:
        if (r11.length() == 32) goto L19;
        if (r6.startsWith("content://media") == false) goto L13;
        r4 = 2;
        goto L20
    L13:
        if (r11.contains("_") == false) goto L16;
        r11 = r11.substring(0, r11.indexOf("_"));
    L16:
        if (TextUtils.isDigitsOnly(r11) == false) goto L18;
        r10 = Integer.parseInt(r11);
    L18:
        r4 = 1;
    L20:
        int r7 = Utils.getHistoryWallpaperCount(r14, 1);
        int r15 = Utils.getHistoryWallpaperCount(r14, 2);
        int r8 = android.provider.Settings.Global.getInt(r0, "four_fingers_change_lockscreen_enable", 1);
        int r12 = android.provider.Settings.Global.getInt(r0, "original_launcher_wallpaper_blur_on", 1);
        r1.put("desktop_theme", r2);
        r1.put("flip", Integer.valueOf(r3));
        r1.put("color_theme", r5);
        r1.put("lock_wallpaper_type", Integer.valueOf(r4));
        r1.put("lock_paper_num", Integer.valueOf(r7));
        r1.put("lock_sys_wallpaper", r9);
        r1.put("lock_ol_wallpaper", Integer.valueOf(r10));
        r1.put("lock_change_paper", Integer.valueOf(r8));
        r1.put("desk_paper_num", Integer.valueOf(r15));
        r1.put("desk_blur", Integer.valueOf(r12));
        onStatus("A131007", r1);
    }

    public static void trackLauncherSettings(Context r10) {
        ContentResolver r0 = r10.getContentResolver();
        LinkedHashMap r1 = new LinkedHashMap();
        if (Utils.isThirdPartHome(r10) == false) goto L5;
        int r2 = 3;
    L6:
        String r11 = Utils.getDefaultLauncherPkg(r10);
        boolean r3 = Boolean.parseBoolean(android.provider.Settings.System.getString(r0, "launcher_hide_lable"));
        int r4 = android.provider.Settings.Global.getInt(r0, "launcher_unlock_animation_enabled", 1);
        int r6 = android.provider.Settings.Global.getInt(r0, "launcher_switching_orientation", 0);
        r1.put("desktop_type", Integer.valueOf(r2));
        r1.put("desk_name", r11);
        r1.put("hide_icon_name", Integer.valueOf(r3 ? 1 : 0));
        r1.put("unlock", Integer.valueOf(r4));
        r1.put("single_multi", Integer.valueOf(r6));
        r1.put("blur", Integer.valueOf(android.provider.Settings.Global.getInt(r0, "original_launcher_wallpaper_blur_on", 1)));
        r1.put("theme", Integer.valueOf(android.provider.Settings.Global.getInt(r0, "launcher_grid_theme", 0)));
        if (r2 != 9) goto L9;
        r1.put("multiple_plate", Integer.valueOf(android.provider.Settings.Global.getInt(r0, "multi_block_mode", 36)));
    L10:
        onStatus("A131008", r1);
        return;
    L9:
        r1.put("multiple_plate", 0);
        goto L10
    L5:
        r2 = Utils.getCurrentLauncherMode(r10);
        goto L6
    }

    public static void trackerDisplaySettings(Context r9) {
        ContentResolver r10 = r9.getContentResolver();
        LinkedHashMap r0 = new LinkedHashMap();
        int r2 = 0;
        if (android.provider.Settings.System.getInt(r10, "accelerometer_rotation", 0) == 0) goto L5;
        int r1 = 1;
    L7:
        if (android.provider.Settings.System.getInt(r10, "screen_brightness_mode", 0) != 1) goto L9;
        int r4 = 1;
    L10:
        int r5 = android.provider.Settings.System.getInt(r10, PageConstants.LAUNCH_PAGE_SCREEN_OFF_TIMEOUT, 60000);
        if (android.provider.Settings.Global.getInt(r10, "stay_on_while_plugged_in", 0) == 0) goto L13;
        int r6 = 1;
    L15:
        if (android.provider.Settings.Global.getInt(r10, "smart_display_state", 0) == 0) goto L17;
        r2 = 1;
    L17:
        r0.put("auto_rotate", Integer.valueOf(r1));
        r0.put("auto_light", Integer.valueOf(r4));
        r0.put("screen_off", Long.valueOf(((long) r5) / 1000));
        r0.put("recharge", Integer.valueOf(r6));
        r0.put("font_size", Float.valueOf(Utils.getCurrentFontScale()));
        r0.put("smart_display", Integer.valueOf(r2));
        onStatus("A131009", r0);
        return;
    L13:
        r6 = 0;
        goto L15
    L9:
        r4 = 0;
        goto L10
    L5:
        r1 = 0;
        goto L7
    }

    public static void trackSoundSettings(Context r8) {
        ContentResolver r0 = r8.getContentResolver();
        LinkedHashMap r1 = new LinkedHashMap();
        int r3 = 0;
        if (SettingsFeature.isHiFiSupport() == true) goto L5;
    L9:
        r1.put("call_vib", Integer.valueOf(android.provider.Settings.Global.getInt(r0, "telephony_vibration_enabled", 1)));
        if (SettingsFeature.supportFingerprint(r8) == false) goto L12;
        r1.put("home_vib", Integer.valueOf(android.provider.Settings.Global.getInt(r0, "back_via_home_vibration", 1)));
    L12:
        r1.put("other_vib", Integer.valueOf(android.provider.Settings.Global.getInt(r0, SoundSettingsFragment.GLOBAL_VIBRATION_ENABLED, 1)));
        if (Utils.isSimExists() == true) goto L15;
    L16:
        String r6 = android.provider.Settings.System.getString(r0, "ringtone");
        if (r6 != null) goto L19;
    L21:
        int r7 = 0;
    L22:
        r1.put("sim1_ring_type", Integer.valueOf(r7 ^ 1));
        r1.put("sim1_ring_name", Utils.getRingtoneName(r8, "ringtone", true));
        r1.put("sim1_smsring", Utils.getRingtoneName(r8, "mms_ringtone_uri", true));
    L24:
        if (MultiSimAdapter.hasIccCard(1) == false) goto L31;
        String r9 = android.provider.Settings.System.getString(r0, "ringtone_2");
        if (r9 != null) goto L28;
    L30:
        r1.put("sim2_ring_type", Integer.valueOf(r3 ^ 1));
        r1.put("sim2_ring_name", Utils.getRingtoneName(r8, "ringtone_2", true));
        r1.put("sim2_smsring", Utils.getRingtoneName(r8, "mms_ringtone_uri_2", true));
        goto L31
    L28:
        if (r9.startsWith("content://media/internal/") == false) goto L30;
        r3 = 1;
    L31:
        r1.put("rec_mail_ring", Utils.getRingtoneName(r8, "email_receive_ringtone_uri", true));
        r1.put("send_mail_ring", Utils.getRingtoneName(r8, "email_send_ringtone_uri", true));
        r1.put("ca_ring", Utils.getRingtoneName(r8, "calendar_ringtone_uri", true));
        r1.put("msg_ring", Utils.getRingtoneName(r8, "notification_sound", true));
        r1.put("dial", Integer.valueOf(android.provider.Settings.System.getInt(r0, "dtmf_tone", 1)));
        r1.put("low_volume", Integer.valueOf(android.provider.Settings.Global.getInt(r0, "power_sounds_enabled", 1)));
        onStatus("A131010", r1);
        return;
    L19:
        if (r6.startsWith("content://media/internal/") == false) goto L21;
        r7 = 1;
        goto L22
    L15:
        if (MultiSimAdapter.hasIccCard(0) == false) goto L24;
    L5:
        if (android.provider.Settings.System.getInt(r0, "hifi_enable", 0) != 1) goto L7;
        int r2 = 1;
    L8:
        r1.put("HiFi", Integer.valueOf(r2));
        goto L9
    L7:
        r2 = 0;
        goto L8
    }

    public static void trackObsessionSettings(Context r9) {
        ContentResolver r10 = r9.getContentResolver();
        LinkedHashMap r0 = new LinkedHashMap();
        int r4 = 1;
        if (android.provider.Settings.System.getInt(r10, "status_bar_battery", 0) != 3) goto L5;
        int r1 = 1;
    L7:
        if (android.provider.Settings.Global.getInt(r10, "display_large_battery_in_lockscreen", 1) != 1) goto L9;
        int r3 = 1;
    L10:
        String r5 = android.provider.Settings.System.getString(r10, "launcher_hide_lable");
        String r6 = android.provider.Settings.System.getString(r10, "launcher_hide_badge");
        String r7 = android.provider.Settings.System.getString(r10, "launcher_badge_swipe_clean");
        if (android.provider.Settings.System.getInt(r10, SettingsSwitchKeyUtil.FACE_RECOGNITION_ENABLED, 1) == 0) goto L14;
        r4 = 0;
    L14:
        r0.put("elec_per", Integer.valueOf(r1));
        r0.put("big_bat", Integer.valueOf(r3));
        if (r5 == null) goto L17;
        r0.put("hide_name", Integer.valueOf(Boolean.parseBoolean(r5) ? 1 : 0));
    L17:
        if (r6 == null) goto L19;
        r0.put("hide_icon", Integer.valueOf(Boolean.parseBoolean(r6) ? 1 : 0));
    L19:
        if (r7 == null) goto L21;
        r0.put("sweep", Integer.valueOf(Boolean.parseBoolean(r7) ? 1 : 0));
    L21:
        r0.put("panel", Integer.valueOf(android.provider.Settings.Global.getInt(r10, "contacts_dialpad_change_layout", 0)));
        r0.put("hide_axis", Integer.valueOf(r4));
        onStatus("A131011", r0);
        return;
    L9:
        r3 = 0;
        goto L10
    L5:
        r1 = 0;
        goto L7
    }

    public static void trackShortKeySettings(Context r15) {
        ContentResolver r0 = r15.getContentResolver();
        LinkedHashMap r1 = new LinkedHashMap();
        int r9 = 0;
        if (SettingsFeature.isDoubleSideKey() == false) goto L19;
        int r2 = android.provider.Settings.Global.getInt(r0, "brightness_key_function", 1);
        String r11 = android.provider.Settings.Global.getString(r0, "squeeze_side_buttons");
        String r12 = "none";
        if (r11 != null) goto L7;
        r11 = "none";
    L7:
        String r13 = android.provider.Settings.Global.getString(r0, "squeeze_side_buttons_screen_off");
        if (r13 == null) goto L11;
        r12 = r13;
    L11:
        r1.put("volume", Integer.valueOf(android.provider.Settings.Global.getInt(r0, "volume_key", 1)));
        r1.put(PluralRules.KEYWORD_OTHER, Integer.valueOf(r2));
        r1.put("change_song", Integer.valueOf(android.provider.Settings.System.getInt(r0, "switch_with_brightness_keys", 1)));
        r1.put("both_sides", Integer.valueOf(android.provider.Settings.Global.getInt(r0, "squeeze_side_buttons_enabled", 1)));
        r1.put("screen_off", r12);
        r1.put("screen_on", r11);
        if (r11.contains(LibrarianImpl.Constants.SEPARATOR) == false) goto L14;
        String r3 = r11.split("\\/")[0];
    L15:
        r1.put("screen_app", r3);
        int r4 = android.provider.Settings.Global.getInt(r0, "squeeze_up_side_buttons_enabled", 0);
        r1.put("eggs", Integer.valueOf(r4));
        if (r4 != 1) goto L19;
        r1.put("quick_onstep", Integer.valueOf("side_bar".equals(android.provider.Settings.Global.getString(r0, "squeeze_side_up_buttons")) ? 1 : 0));
        goto L19
    L14:
        r3 = "";
    L19:
        if (SettingsFeature.isWalletFeatureEnabled(r15) == false) goto L22;
        r1.put("lock_dclick_home", Integer.valueOf(android.provider.Settings.Global.getInt(r0, "lockscreen_home_trigger_type", 0)));
    L22:
        if (SettingsFeature.LONG_PRESS_HOME_SETTINGS_FEATURE == false) goto L32;
        int r16 = android.provider.Settings.Global.getInt(r0, "voice_assit_by_home", 1);
        if (r16 == 0) goto L30;
        if (r16 == 1) goto L29;
        if (r16 != 2) goto L32;
        r1.put("long_press_home", 2);
        goto L32
    L29:
        r1.put("long_press_home", 0);
        goto L32
    L30:
        r1.put("long_press_home", 1);
    L32:
        if (SettingsUtil.hasSmartKey() == true) goto L34;
    L59:
        onStatus("A131012", r1);
        return;
    L34:
        if (android.provider.Settings.Global.getInt(r0, "squeeze_with_power_enabled", 1) == 0) goto L36;
        int r17 = 1;
    L37:
        String r14 = android.provider.Settings.Global.getString(r0, "squeeze_with_power_function");
        r1.put("capsule_pw", Integer.valueOf(r17));
        r1.put("capsule_pw_func", Integer.valueOf("screenshot".equals(r14) ? 1 : 0));
        if (android.provider.Settings.Global.getInt(r0, "squeeze_up_side_buttons_enabled", 1) == 0) goto L40;
        int r18 = 1;
    L41:
        r1.put("capsule_vu", Integer.valueOf(r18));
        String r19 = android.provider.Settings.Global.getString(r0, "squeeze_side_up_buttons");
        if ("torch".equals(r19) == false) goto L45;
        int r110 = 1;
    L48:
        r1.put("capsule_vu_func", Integer.valueOf(r110));
        if (android.provider.Settings.Global.getInt(r0, "squeeze_side_buttons_enabled", 1) == 0) goto L51;
        int r111 = 1;
    L52:
        r1.put("capsule_vd", Integer.valueOf(r111));
        String r112 = android.provider.Settings.Global.getString(r0, "squeeze_side_buttons");
        if ("voice_command".equals(r112) == false) goto L56;
        r9 = 1;
    L58:
        r1.put("capsule_vd_func_l", Integer.valueOf(r9));
        r1.put("capsule_vd_func_c", Integer.valueOf("voice_command".equals(android.provider.Settings.Global.getString(r0, "squeeze_side_buttons_screen_off")) ? 1 : 0));
        goto L59
    L56:
        if ("side_bar".equals(r112) == false) goto L58;
        r9 = 2;
        goto L58
    L51:
        r111 = 0;
        goto L52
    L45:
        if ("text_recognition".equals(r19) == false) goto L47;
        r110 = 2;
        goto L48
    L47:
        r110 = 0;
        goto L48
    L40:
        r18 = 0;
        goto L41
    L36:
        r17 = 0;
        goto L37
    }

    public static void trackOnehandSettings(Context r5) {
        ContentResolver r6 = r5.getContentResolver();
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("left_right", Integer.valueOf(android.provider.Settings.Global.getInt(r6, "one_hand_mode", 1)));
        boolean r1 = Boolean.parseBoolean(android.provider.Settings.Global.getString(r6, SettingsSwitchKeyUtil.THUMB_PUSH_DOWN));
        r0.put("slide_down", Integer.valueOf(r1 ? 1 : 0));
        if (r1 == true) goto L5;
    L7:
        r0.put("touch_area", Integer.valueOf(android.provider.Settings.Global.getInt(r6, "thumb_trigger_area", 2)));
        if (SettingsFeature.hasMenuAndBackKeys() == false) goto L10;
        r0.put("menu_center", Integer.valueOf(android.provider.Settings.Global.getInt(r6, "menu_move_down_nc", 0)));
        r0.put("menu_center_type", Integer.valueOf(android.provider.Settings.Global.getInt(r6, "menu_move_down_when", 0)));
        r0.put("press_menu", Integer.valueOf(android.provider.Settings.Global.getInt(r6, "voice_assit_by_menu", 0)));
        r0.put("press_back", Integer.valueOf(android.provider.Settings.Global.getInt(r6, "enable_torch_via_back_key", 0)));
    L10:
        onStatus("A131013", r0);
        return;
    L5:
        if (SettingsFeature.ENABLE_THUMB_PULLDOWN_WALLPAPER == false) goto L7;
        r0.put("slide_down_pic", Integer.valueOf(android.provider.Settings.Global.getInt(r6, "thumb_pulldown_wallpaper_enabled", 1)));
        goto L7
    }

    public static void trackLockscreenSecurity(Context r13) {
        ContentResolver r0 = r13.getContentResolver();
        LinkedHashMap r1 = new LinkedHashMap();
        if (SettingsFeature.supportFingerprint(r13) == false) goto L28;
        FingerprintManager r2 = (FingerprintManager) r13.getSystemService("fingerprint");
        if (r2 != null) goto L7;
        List r3 = null;
    L8:
        if (r3 != null) goto L10;
        int r5 = 0;
    L11:
        if (r5 <= 0) goto L13;
        boolean r6 = true;
    L14:
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
    L15:
        if (r7 >= r5) goto L25;
        String r10 = android.provider.Settings.Global.getString(r0, "quick_app_via_fingerprint_id_" + InvisibleApi.getFingerId((Fingerprint) r3.get(r7)));
        if (r10 == null) goto L24;
        if (r10.contains("com.eg.android.AlipayGphone") == false) goto L22;
        r8 = 1;
    L22:
        if (r10.contains("com.tencent.mm") == false) goto L24;
        r9 = 1;
    L24:
        r7 = r7 + 1;
        goto L15
    L25:
        r1.put("finger_num", Integer.valueOf(r5));
        if (r6 == false) goto L29;
        r1.put("finger_for_lockscreen", Integer.valueOf(android.provider.Settings.Global.getInt(r0, "use_fingerprint_in_lockscreen", 0)));
        r1.put("finger_for_locklauncher", Integer.valueOf(android.provider.Settings.Global.getInt(r0, "use_fingerprint_in_launcher", 0)));
        r1.put("finger_for_wallet", Integer.valueOf(android.provider.Settings.Global.getInt(r0, "use_fingerprint_in_wallet", 0)));
        r1.put("home_unlock", Integer.valueOf(android.provider.Settings.Global.getInt(r0, "quick_unlock_when_screen_off", 0)));
        r1.put("alipay", Integer.valueOf(r8));
        r1.put("wechatpay", Integer.valueOf(r9));
    L29:
        int r14 = Utils.getLockPasswordType(r13);
        if (r6 == false) goto L32;
        r14 = r14 + 4;
    L32:
        r1.put("lock_type", Integer.valueOf(r14));
        if (SettingsFeature.isFaceRecognitionEnable() == false) goto L35;
        r1.put("face_unlock", Integer.valueOf(android.provider.Settings.Global.getInt(r0, "faceid_enable", 0)));
        r1.put("allow_light_screen", Integer.valueOf(android.provider.Settings.Global.getInt(r0, "face_data_enable_when_notification_turn_on_screen", 0)));
        r1.put("face_ul_success", Integer.valueOf(android.provider.Settings.Global.getInt(r0, "stay_in_locked_screen_when_face_recognized", 1)));
    L35:
        onStatus("A131014", r1);
        return;
    L13:
        r6 = false;
        goto L14
    L10:
        r5 = r3.size();
        goto L11
    L7:
        r3 = r2.getEnrolledFingerprints();
        goto L8
    L28:
        r6 = false;
        goto L29
    }

    public static void trackAppManagerSettings(Context r9) {
        ContentResolver r0 = r9.getContentResolver();     // Catch: JSONException -> L28
        PackageManager r1 = r9.getPackageManager();     // Catch: JSONException -> L28
        JSONObject r2 = new JSONObject();     // Catch: JSONException -> L28
        JSONArray r3 = new JSONArray();     // Catch: JSONException -> L28
        List r4 = r1.getInstalledPackagesAsUser(0, 10);     // Catch: JSONException -> L28
        if (r4 != null) goto L5;
        int r6 = 0;
    L6:
        int r7 = 0;
    L7:
        if (r7 >= r6) goto L9;
        r3.put(((PackageInfo) r4.get(r7)).packageName);     // Catch: JSONException -> L28
        r7 = r7 + 1;     // Catch: JSONException -> L28
        goto L7
    L9:
        r2.put("double_app", r3);     // Catch: JSONException -> L28
        r2.put("def_desk", Utils.getDefaultLauncherPkg(r9));     // Catch: JSONException -> L28
        Intent r10 = new Intent("android.intent.action.VIEW");     // Catch: JSONException -> L28
        r10.setData(new Uri.Builder().scheme("http").authority(ApnEditor.APN_TYPE_ALL).build());     // Catch: JSONException -> L28
        ResolveInfo r11 = r1.resolveActivity(r10, 65536);     // Catch: JSONException -> L28
        Intent r5 = new Intent("android.intent.action.SENDTO");     // Catch: JSONException -> L28
        r5.setData(new Uri.Builder().scheme("mailto").build());     // Catch: JSONException -> L28
        ResolveInfo r8 = r1.resolveActivity(r5, 65536);     // Catch: JSONException -> L28
        String r12 = "none";
        if (isUnset(r11) == false) goto L13;
        String r13 = "none";
    L14:
        r2.put("def_browser", r13);     // Catch: JSONException -> L28
        if (isUnset(r8) == true) goto L18;
        r12 = r8.activityInfo.packageName;     // Catch: JSONException -> L28
    L18:
        r2.put("def_mail", r12);     // Catch: JSONException -> L28
        if (TextUtils.isEmpty(StorageManagerSmt.getExternalSdcardPath()) == true) goto L21;
        boolean r14 = true;
    L23:
        if (SettingsFeature.isSupportSd() == false) goto L26;
        if (r14 == false) goto L26;
        r2.put("defstore_local", android.provider.Settings.Global.getInt(r0, "storage_path_local_backup", 1));     // Catch: JSONException -> L28
        r2.put("defstore_cam", android.provider.Settings.Global.getInt(r0, "storage_path_camera", 0));     // Catch: JSONException -> L28
        r2.put("defstore_pic", android.provider.Settings.Global.getInt(r0, "storage_path_gallery", 0));     // Catch: JSONException -> L28
        r2.put("defstore_mus", android.provider.Settings.Global.getInt(r0, "storage_path_music", 0));     // Catch: JSONException -> L28
        r2.put("defstore_rec", android.provider.Settings.Global.getInt(r0, "storage_path_recording", 0));     // Catch: JSONException -> L28
        r2.put("defstore_scr", android.provider.Settings.Global.getInt(r0, "storage_path_captivate", 0));     // Catch: JSONException -> L28
        r2.put("defstore_cat", android.provider.Settings.Global.getInt(r0, "storage_path_screenshot", 0));     // Catch: JSONException -> L28
        r2.put("defstore_email", android.provider.Settings.Global.getInt(r0, "storage_path_mail_attachment_download", 0));     // Catch: JSONException -> L28
        r2.put("defstore_bro", android.provider.Settings.Global.getInt(r0, "storage_path_browser_download", 0));     // Catch: JSONException -> L28
    L26:
        onStatus("A131015", r2);     // Catch: JSONException -> L28
        return;
    L21:
        r14 = false;
        goto L23
    L13:
        r13 = r11.activityInfo.packageName;     // Catch: JSONException -> L28
        goto L14
    L5:
        r6 = r4.size();     // Catch: JSONException -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
    }

    public static void trackLanguageAndImSettings(Context r3) {
        LinkedHashMap r0 = new LinkedHashMap();
        ContentResolver r4 = r3.getContentResolver();
        r0.put("langue", Locale.getDefault().toString());
        r0.put("input_name", android.provider.Settings.Secure.getString(r4, "default_input_method"));
        onStatus("A131018", r0);
    }

    public static void trackAdvanceSettings(Context r12) {
        ContentResolver r5 = r12.getContentResolver();
        if (android.provider.Settings.System.getInt(r5, "3rd_app_status_bar_mode", 0) != 0) goto L5;
        boolean r6 = true;
    L7:
        if (android.provider.Settings.System.getInt(r5, Constants.ADAPTER_COLOR_STATUS_BAR, 1) != 1) goto L9;
        boolean r9 = true;
    L10:
        JSONObject r10 = new JSONObject();
        if (r6 == false) goto L14;
        int r7 = 0;
    L70:
        r10.put("statusbar_type", r7);     // Catch: JSONException -> L67
        if (r9 == false) goto L18;
        int r11 = 1;
    L19:
        r10.put("statusbar_icon", r11);     // Catch: JSONException -> L67
        r10.put("quick_icon", new JSONArray());     // Catch: JSONException -> L67
        r10.put("long_press", AccessibilitySettingsFragment.getLongPressTimeoutIndex(r12));     // Catch: JSONException -> L67
        r10.put("join_ue_plan", android.provider.Settings.Global.getInt(r5, "join_ue_on", 1));     // Catch: JSONException -> L67
        if (SettingsUtil.hasNavigationBar() == false) goto L22;
        r10.put("nav_type", android.provider.Settings.Global.getInt(r5, "navigation_bar_mode", 1));     // Catch: JSONException -> L67
        r10.put("virtual_key", android.provider.Settings.System.getInt(r5, settings.Settings.Global.KEY_REVERSE_NAVIGATION_BAR, 1));     // Catch: JSONException -> L67
        r10.put("virtual_key_style", android.provider.Settings.Global.getInt(r5, "navigationbar_style", 0));     // Catch: JSONException -> L67
        r10.put("nav_theme", android.provider.Settings.Global.getInt(r5, "navigationbar_theme", 0));     // Catch: JSONException -> L67
        r10.put("smart_screen", android.provider.Settings.Global.getInt(r5, SettingsSwitchKeyUtil.SMART_SCREEN_PROTECTOR, 0));     // Catch: JSONException -> L67
    L22:
        r10.put(InputMethodUtils.SUBTYPE_MODE_VOICE, android.provider.Settings.Global.getInt(r5, "accessibility_speech_reading", 0));     // Catch: JSONException -> L67
        r10.put(BatteryHistoryDetail.EXTRA_BROADCAST, android.provider.Settings.Global.getInt(r5, "accessibility_hourly_chime", 0));     // Catch: JSONException -> L67
        r10.put("broadcast_type", android.provider.Settings.Global.getInt(r5, "accessibility_hourly_chime_type", 0) + 1);     // Catch: JSONException -> L67
        if (SettingsUtil.isAccessibilityEnabled(r12) == false) goto L25;
        int r13 = 1;
    L26:
        r10.put("talkback", r13);     // Catch: JSONException -> L67
        r10.put("enlarge", android.provider.Settings.Secure.getInt(r5, "accessibility_display_magnification_enabled", 0));     // Catch: JSONException -> L67
        r10.put("big_mouse_pointer", android.provider.Settings.Secure.getInt(r5, "accessibility_large_pointer_icon", 0));     // Catch: JSONException -> L67
        r10.put("color_correction", android.provider.Settings.Secure.getInt(r5, "accessibility_display_daltonizer_enabled", 0));     // Catch: JSONException -> L67
        int r8 = android.provider.Settings.Secure.getInt(r5, "accessibility_display_daltonizer", 12);     // Catch: JSONException -> L67
        if (r8 != 12) goto L31;
        r10.put("color_correction_type", 1);     // Catch: JSONException -> L67
    L36:
        r10.put("color_reversal", android.provider.Settings.Secure.getInt(r5, "accessibility_display_inversion_enabled", 0));     // Catch: JSONException -> L67
        r10.put("high_contrast", android.provider.Settings.Secure.getInt(r5, "high_text_contrast_enabled", 0));     // Catch: JSONException -> L67
        r10.put("say_password", android.provider.Settings.Secure.getInt(r5, "speak_password", 0));     // Catch: JSONException -> L67
        if (android.provider.Settings.System.getIntForUser(r5, "master_mono", 0, -2) != 1) goto L39;
        int r14 = 1;
    L40:
        r10.put("mono", r14);     // Catch: JSONException -> L67
        r10.put("recognition", android.provider.Settings.Global.getInt(r5, "accessibility_global_ocr", 0));     // Catch: JSONException -> L67
        r10.put("voice_cmd", android.provider.Settings.Global.getInt(r5, "voice_command_state", 0));     // Catch: JSONException -> L67
        if (SettingsUtil.isAccessibilityEnabled(r12, Constants.PKG_BYYT_VOICE_BACK) == false) goto L43;
        int r15 = 1;
    L44:
        r10.put("baoyi", r15);     // Catch: JSONException -> L67
        if (SettingsUtil.isAccessibilityEnabled(r12, Constants.PKG_XM_VOICE_BACK) == false) goto L47;
        int r16 = 1;
    L48:
        r10.put("xingmu", r16);     // Catch: JSONException -> L67
        if (SettingsUtil.isAccessibilityEnabled(r12, Constants.PKG_YD_VOICE_BACK) == false) goto L51;
        int r17 = 1;
    L52:
        r10.put("yongde", r17);     // Catch: JSONException -> L67
        if (SettingsUtil.isAccessibilityEnabled(r12, Constants.PKG_DM_VOICE_BACK) == false) goto L55;
        int r18 = 1;
    L56:
        r10.put("dianming", r18);     // Catch: JSONException -> L67
        if (SettingsFeature.isGameModeSupport() == false) goto L63;
        r10.put("game_mod", android.provider.Settings.Global.getInt(r5, "game_mode_enable", 0));     // Catch: JSONException -> L67
        r10.put("game_side_bar", android.provider.Settings.Global.getInt(r5, "game_sidebar_menu", 1));     // Catch: JSONException -> L67
        r10.put("banner_display", android.provider.Settings.Global.getInt(r5, "game_mode_no_disturb_enable", 1));     // Catch: JSONException -> L67
        r10.put("auto_light", android.provider.Settings.Global.getInt(r5, "game_mode_lock_auto_brightness_enable", 0));     // Catch: JSONException -> L67
        if (SettingsFeature.isSupportForbidNavBar() == false) goto L61;
        r10.put("key_locking", android.provider.Settings.Global.getInt(r5, "game_mode_nav_bar_btn_forbidden", 0));     // Catch: JSONException -> L67
    L61:
        r10.put("disable_qucik_key", android.provider.Settings.Global.getInt(r5, "game_mode_shortcut_key_forbidden", 1));     // Catch: JSONException -> L67
        r10.put("reject_call", android.provider.Settings.Global.getInt(r5, "reject_call", 0));     // Catch: JSONException -> L67
        r10.put("allow_call", android.provider.Settings.Global.getInt(r5, "allow_call", 4));     // Catch: JSONException -> L67
        r10.put("repeated_call", android.provider.Settings.Global.getInt(r5, "repeated_call", 0));     // Catch: JSONException -> L67
        r10.put("message_barrage_notification", android.provider.Settings.Global.getInt(r5, "message_barrage_notification", 0));     // Catch: JSONException -> L67
        r10.put("shielded_status_bar_notification", android.provider.Settings.Global.getInt(r5, "shielded_status_bar_notification", 0));     // Catch: JSONException -> L67
    L63:
        if (Utils.isCameraInScreen() == false) goto L65;
        r10.put("pre_lens", android.provider.Settings.Global.getInt(r5, "notch_status_bar_state", 0));     // Catch: JSONException -> L67
    L65:
        r10.put("change_screen", android.provider.Settings.Global.getInt(r5, "manual_rotation_state", 0));     // Catch: JSONException -> L67
        onStatus("A131023", r10);     // Catch: JSONException -> L67
        return;
    L55:
        r18 = 0;
        goto L56
    L51:
        r17 = 0;
        goto L52
    L47:
        r16 = 0;
        goto L48
    L43:
        r15 = 0;
        goto L44
    L39:
        r14 = 0;
        goto L40
    L31:
        if (r8 != 11) goto L34;
        r10.put("color_correction_type", 2);     // Catch: JSONException -> L67
        goto L36
    L34:
        if (r8 != 13) goto L36;
        r10.put("color_correction_type", 3);     // Catch: JSONException -> L67
        goto L36
    L25:
        r13 = 0;
        goto L26
    L18:
        r11 = 0;
    L67:
        e = move-exception;
        e.printStackTrace();
        return;
    L14:
        r7 = 1;
        goto L70
    L9:
        r9 = false;
        goto L10
    L5:
        r6 = false;
        goto L7
    }

    public static void trackNavigationSettings(Context r2) {
        onStatus("A131028", "trigger_mode", Integer.valueOf(android.provider.Settings.Global.getInt(r2.getContentResolver(), "navigationbar_trigger_mode", 0)));
    }
}
