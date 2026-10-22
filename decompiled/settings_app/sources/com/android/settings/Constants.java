package com.android.settings;

import android.casthal.CasthalManager;
import android.os.ParcelUuid;
import com.obric.olog.OLog;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public class Constants {
    public static final String ACTION_GATT_CONNECTED = "com.android.settings.stylus.ACTION_GATT_CONNECTED";
    public static final String ACTION_GATT_DISCONNECTED = "com.android.settings.stylus.ACTION_GATT_DISCONNECTED";
    public static final String ACTION_GATT_MANUL_DISCONNECTED = "com.android.settings.stylus.ACTION_GATT_MANUL_DISCONNECTED";
    public static final String ACTION_STYLUSBLUETOOTHSERVIC = "com.settings.stylus.action.StylusBluetoothService";
    public static final String ACTION_STYLUS_BATTERY_LEVEL_CHANGED = "com.android.setting.action.STYLUS_BATTERY_LEVEL_CHANGED";
    public static final String ACTION_STYLUS_CHARGE_STATE_CHANGED = "com.android.setting.action.STYLUS_CHARGE_STATE_CHANGED";
    public static final String ACTION_STYLUS_KEY_EVENT_CHANGED = "com.android.setting.action.STYLUS_KEY_EVENT_CHANGED";
    public static final String ACTION_THINKBOOST_SEARCH_WINDOW = "android.intent.action.SEARCH_WINDOW_SELECTED";
    public static final String ACTIVITY_IMAGESEARCH = "com.android.browser.setting_impl.page.ImageSearchEnginePreferencesActivity";
    public static final String ADAPTER_COLOR_STATUS_BAR = "adapter_color_status_bar";
    public static final String APP_LABELS_OF_EN_US = "en_US";
    public static final String APP_LABELS_OF_ZH_CN = "zh_CN";
    public static final String APP_LABELS_OF_ZH_TW = "zh_TW";
    public static final String BYTEDANCE_LAUNCHER_ACTIVITY = "com.bytedanceos.launcher.Launcher";
    public static final String BYTEDANCE_SHOP = "";
    public static final String BYTEDANCE_SHOP_ITEM_PHONE_CASE = "";
    public static final String BYTEDANCE_SHOP_ITEM_STYLUS = "";
    public static final boolean CHANGE_NEW_LAUNCHER = true;
    public static final String CLASS_HEARINGAID_SETTING = "com.bytedanceos.hearingaid.setting.activity.SettingActivity";
    public static final String CLASS_NAME_HANDBOOK = "com.bytedanceos.manual.activity.StartVideoActivity";
    public static final String CLASS_NAME_NODISTURB_SPECIFY = "com.obric.nodisturb.SpecifyListActivity";
    public static final String COM_BYTEDANCE_BYTEDANCESTORE = "com.bytedance.bytedancestore";
    public static final String CREATE_NOTES_ACTIVITY = "com.obric.notes.CreateNotesActivity";
    public static final String CURRENT_COLOR_TEMPERATURE_MODE_ID = "current_color_temperature_mode_id";
    public static final int DARWIN_PWD_SETUP_SUCCESS_TOAST_OFFSET = 0;
    public static final int DEFAULT_APP_SETUP_TOAST_OFFSET = 60;
    public static final String DESKTOP_SCROLL_SERVICE_NAME = "com.android.desktop.systemui.scrollscreenshot.ScrollService";
    public static final String DEVICE_ACTIVATION_COMPLETED = "device_activation_completed";
    public static final String DOWNLOADS_FROM_CLOUD_FEED_BACK = "com.android.providers.downloads.ACTION_SYNC_DATA_FINISH_FEEDBACK";
    public static final String DOWNLOADS_FROM_CLOUD_IMMERSIVE_BLACK_LIST = "immersive_blacklist";
    public static final String EXTRA_BLE_DEVICE = "extra_ble_device";
    public static final String EXTRA_OUTER = "extra_outer";
    public static final String EXTRA_STYLUS_BATTERY_LEVEL = "com.android.setting.extra.STYLUS_BATTERY_LEVEL";
    public static final String EXTRA_STYLUS_CHARGE_STATE = "com.android.setting.extra.STYLUS_CHARGE_STATE";
    public static final String EXTRA_STYLUS_KEY_EVENT = "com.android.setting.extra.STYLUS_KEY_EVENT";
    public static final String FEATURE_SYSTEM_PRINTER = "FEAT_SYSTEM_PRINTER";
    public static int FLAG_SMT_SYSTEM_APP_CAN_UNINSTALL = 0;
    public static final int GATT_CONNECT_SYNC_CLOCK_FAIL = 133;
    public static final String IS_SIDE_DIAL_CUSTOM_PAGE_MODIFY = "is_side_dial_custom_page_modify";
    public static final String IS_SIDE_DIAL_DETAIL_PAGE_MODIFY = "is_side_dial_detail_page_modify";
    public static final String KEY_CACHE_SETTINGS_STYLUS = "settings_stylus";
    public static final String KEY_NEED_PROMPT_LAUNCHER_CHOOSE = "key_need_prompt_launcher_choose";
    public static final String KEY_STYLUS_BATTERY = "key_stylus_battery";
    public static final String KEY_STYLUS_NAME = "key_stylus_name";
    public static final String LAST_GRID_LAUNCHER_MODE = "last_grid_launcher_mode";
    public static final String LAST_NINE_LAUNCHER_MULTI_PANEL_MODE = "last_nine_launcher_multi_panel_mode";
    public static final String NET_ON_NON_DATA_SIM_KEY = "temp_switch_dds";
    public static final String NOTIFICATION_CHANEL_ID = "com.android.settings.chanel";
    public static final String NOTIFICATION_CHANEL_NAME = "com.android.settings.chanel.default";
    public static final String ORIGINAL_LAUNCHER_ACTIVITY = "com.android.launcher3.Launcher";
    public static final String PACKAGE_ALIPAY = "com.eg.android.AlipayGphone";
    public static final String PACKAGE_COM_BYTEDANCEOS_BOSTON_PHONE = "com.bytedanceos.boston.phone";
    public static final String PACKAGE_NAME_HANDBOOK = "com.bytedanceos.manual";
    public static final String PACKAGE_NAME_NODISTURB = "com.obric.nodisturb";
    public static final String PACKAGE_NOTES = "com.obric.notes";
    public static final String PACKAGE_QUICKSEARCH = "com.obric.quicksearch";
    public static final String PACKAGE_SECURITY_IME2 = "com.bytedance.android.securityinput";
    public static final String PACKAGE_TECENT_MM = "com.tencent.mm";
    public static final String PACKAGE_TECENT_QQ = "com.tencent.mobileqq";
    public static final String PACKAGE_WHITEBOARD = "com.bytedanceos.whiteboard";
    public static final String PKG_ALIPAY = "com.eg.android.AlipayGphone";
    public static final String PKG_BACKUP = "com.bytedanceos.backup";
    public static final String PKG_BIG_BANG = "com.bytedanceos.textboom";
    public static final String PKG_BROWSER = "com.android.browser";
    public static final String PKG_BUG2GO = "com.obric.feedback";
    public static final String PKG_BULLET_SMS = "com.bullet.messenger";
    public static final String PKG_BYTEDANCE_LAUNCHER = "com.bytedanceos.launcher";
    public static final String PKG_BYTEDANCE_MAGICFLOW = "com.bytedanceos.magicflow";
    public static final String PKG_BYYT_VOICE_BACK = "com.bjbyhd.voiceback";
    public static final String PKG_CAMSCANNER = "com.intsig.camscanner";
    public static final String PKG_CMEL_ESPORT_COMMUNITY = "com.ttdj.cmel";
    public static final String PKG_CONTACT = "com.android.contacts";
    public static final String PKG_DESKTOP_SYSTEMUI = "com.android.desktop.systemui";
    public static final String PKG_DM_VOICE_BACK = "com.dianming.phoneapp";
    public static final String PKG_GALLERY = "com.android.gallery3d";
    public static final String PKG_GLOBAL_ROAMING = "com.redteamobile.global.roaming";
    public static final String PKG_HAND_IN_HAND = "com.bytedanceos.handinhand";
    public static final String PKG_IDEA_PILLS = "com.bytedanceos.thinkboost";
    public static final String PKG_KEYGUARD = "com.bytedanceos.keyguard";
    public static final String PKG_MMS = "com.android.mms";
    public static final String PKG_MUSIC = "com.obric.music";
    public static final String PKG_ORIGINAL_LAUNCHER = "com.android.launcher3";
    public static final String PKG_ORIGINAL_SMARTNOTIFICATION = "com.obric.smartnotification";
    public static final String PKG_ORIGINAL_SMARTNOTIFICATION_CLASS_NAME = "com.obric.smartnotification.featuresettings.impl.SmartNotificationSetting";
    public static final String PKG_PERSPECTIVE = "com.bytedanceos.perspective";
    public static final String PKG_PHONE_CHARGE = "com.bytedanceos.recharge";
    public static final String PKG_PHONE_VOIP = "com.bytedanceos.phone_number_assistant";
    public static final String PKG_RECORDER = "com.obric.recorder";
    public static final String PKG_SARA = "com.bytedanceos.sara";
    public static final String PKG_SCREEN_RECORDER = "com.bytedanceos.screenrecorder";
    public static final String PKG_SECURITY = "com.obric.security";
    public static final String PKG_SETTINGS = "com.android.settings";
    public static final String PKG_SETTINGS_PROVIDER = "com.android.providers.settings";
    public static final String PKG_SIDEBAR = "com.bytedanceos.sidebar";
    public static final String PKG_SYSTEMUI = "com.android.systemui";
    public static final String PKG_TALK_BACK = "com.google.android.marvin.talkback";
    public static final String PKG_VIDEO = "com.bytedanceos.videoplayerproject";
    public static final String PKG_WALLPAPER_PROVIDER = "com.obric.wallpaper";
    public static final String PKG_WECHAT = "com.tencent.mm";
    public static final String PKG_WEIBO = "com.sina.weibo";
    public static final String PKG_WPS = "cn.wps.moffice_eng";
    public static final String PKG_XM_VOICE_BACK = "com.archermind.xingmu";
    public static final String PKG_YD_VOICE_BACK = "com.lvtech.ydcenter";
    public static final String PKG_ZTE_USE_BALANCE = "com.zte.usebalance";
    public static final String PROPERTY_TEMP_DDS = "persist.radio.enable_temp_dds";
    public static final String PROP_DEVICE_COLOR = "persist.sys.device_color";
    public static final String PROP_DEVICE_PROVISIONED = "persist.sys.device_provisioned";
    public static final int PWD_SETUP_SUCCESS_TOAST_OFFSET = 60;
    public static final String SAFE_KEYBOARD_SWITCH = "safe_keyboard_switch";
    public static final String SCROLL_SERVICE_NAME = "com.android.systemui.scrollscreenshot.ScrollService";
    public static final int SDK_VERSION_O = 26;
    public static final int SDK_VERSION_P = 28;
    public static final int SDK_VERSION_Q = 29;
    public static final int SDK_VERSION_R = 30;
    public static final String SIDE_DIAL_CAR_MODE_ALWAYS_ON_SCREEN = "side_dial_car_mode_always_on_screen";
    public static final String SIDE_DIAL_CAR_MODE_BLUETOOTH = "side_dial_car_mode_bluetooth";
    public static final String SIDE_DIAL_CAR_MODE_DEFAULT = "{\"side_dial_car_mode_bluetooth\":\"1\",\"side_dial_car_mode_always_on_screen\":\"1\",\"side_dial_car_mode_screen_rotation\":\"1\",\"side_dial_car_mode_navigation\":\"\"}";
    public static final String SIDE_DIAL_CAR_MODE_NAVIGATION = "side_dial_car_mode_navigation";
    public static final String SIDE_DIAL_CAR_MODE_SCREEN_ROTATION = "side_dial_car_mode_screen_rotation";
    public static final String SIDE_DIAL_CUSTOM_MODE_ALWAYS_ON_SCREEN = "side_dial_custom_mode_always_on_screen";
    public static final String SIDE_DIAL_CUSTOM_MODE_AUTO_BRIGHTNESS = "side_dial_custom_mode_auto_brightness";
    public static final String SIDE_DIAL_CUSTOM_MODE_DEFAULT = "{\"side_dial_custom_mode_screen_rotation\":\"0\",\"side_dial_custom_mode_always_on_screen\":\"0\",\"side_dial_custom_mode_auto_brightness\":\"0\",\"side_dial_custom_mode_read_mode\":\"0\",\"side_dial_custom_mode_protect_eyes\":\"0\",\"side_dial_custom_mode_mute\":\"0\",\"side_dial_custom_mode_telephony_vibrate\":\"0\",\"side_dial_custom_mode_feedback_vibration\":\"0\",\"side_dial_custom_mode_global_vibrate\":\"0\"}";
    public static final String SIDE_DIAL_CUSTOM_MODE_FEEDBACK_VIBRATION = "side_dial_custom_mode_feedback_vibration";
    public static final String SIDE_DIAL_CUSTOM_MODE_GLOBAL_VIBRATE = "side_dial_custom_mode_global_vibrate";
    public static final String SIDE_DIAL_CUSTOM_MODE_MUTE = "side_dial_custom_mode_mute";
    public static final String SIDE_DIAL_CUSTOM_MODE_PROTECT_EYES = "side_dial_custom_mode_protect_eyes";
    public static final String SIDE_DIAL_CUSTOM_MODE_READ_MODE = "side_dial_custom_mode_read_mode";
    public static final String SIDE_DIAL_CUSTOM_MODE_SCREEN_ROTATION = "side_dial_custom_mode_screen_rotation";
    public static final String SIDE_DIAL_CUSTOM_MODE_TELEPHONY_VIBRATE = "side_dial_custom_mode_telephony_vibrate";
    public static final String SIDE_DIAL_CUSTOM_PROTECT_NEED_IGNORE = "side_dial_custom_protect_need_ignore";
    public static final String SIDE_DIAL_CUSTOM_TITLE_NAME = "side_dial_custom_title_name";
    public static final String SIDE_DIAL_ENTER_FUTURE_PHONE_STATUS = "side_dial_enter_future_phone_status";
    public static final String SIDE_DIAL_MODE_CUSTOM_SWITCH_CURRENT = "side_dial_mode_custom_switch_current";
    public static final String SIDE_DIAL_MODE_SWITCH_CURRENT = "side_dial_mode_switch_current";
    public static final String SIDE_DIAL_MODE_SWITCH_CURRENT_BLUETOOTH = "side_dial_mode_switch_current_bluetooth";
    public static final String SIDE_DIAL_SWITCH_DISABLE = "0";
    public static final String SIDE_DIAL_SWITCH_ENABLE = "1";
    public static final int SMT_PC_SHORTCUT_SCREENSHOT_FULL = 27;
    public static final String SM_BOARD_NAME = "Shellkey";
    public static final String SM_BT_KEYBOARD_NAME = "Keyboard K370/K375";
    public static final String SOURCE = "source";
    public static final String STRING_IMAGE_SEARCH = "image_search_engine_setting";
    public static final int STYLUS_BACK_KEY_CLICK_DOUBLE = 145;
    public static final int STYLUS_BACK_KEY_CLICK_LONG = 147;
    public static final int STYLUS_BACK_KEY_CLICK_SINGLE = 144;
    public static final int STYLUS_BACK_KEY_CLICK_TRIBLE = 146;
    public static final int STYLUS_BATT_CHARGING = 32;
    public static final int STYLUS_BATT_LEVEL1 = 0;
    public static final int STYLUS_BATT_LEVEL10 = 9;
    public static final int STYLUS_BATT_LEVEL2 = 1;
    public static final int STYLUS_BATT_LEVEL3 = 2;
    public static final int STYLUS_BATT_LEVEL4 = 3;
    public static final int STYLUS_BATT_LEVEL5 = 4;
    public static final int STYLUS_BATT_LEVEL6 = 5;
    public static final int STYLUS_BATT_LEVEL7 = 6;
    public static final int STYLUS_BATT_LEVEL8 = 7;
    public static final int STYLUS_BATT_LEVEL9 = 8;
    public static final int STYLUS_BATT_UNPLUG = 33;
    public static final ParcelUuid STYLUS_CONTROL_CHARACTERISTIC_BATT_LEVEL = null;
    public static final ParcelUuid STYLUS_CONTROL_CHARACTERISTIC_BATT_LEVEL_NOTIFY = null;
    public static final ParcelUuid STYLUS_CONTROL_CHARACTERISTIC_CHARGE_STATE = null;
    public static final ParcelUuid STYLUS_CONTROL_CHARACTERISTIC_CHARGE_STATE_NOTIFY = null;
    public static final ParcelUuid STYLUS_CONTROL_CHARACTERISTIC_CONFIG_DESCRIPTOR = null;
    public static final ParcelUuid STYLUS_CONTROL_CHARACTERISTIC_KEY_EVENT = null;
    public static final ParcelUuid STYLUS_CONTROL_CHARACTERISTIC_KEY_EVENT_NOTIFY = null;
    public static final ParcelUuid STYLUS_CONTROL_SERVICE_NOTIFY_UUID = null;
    public static final ParcelUuid STYLUS_CONTROL_SERVICE_READ_UUID = null;
    public static final String STYLUS_CUSTOM_KEY_APP_DOUBLE_CLICK = "stylus_custom_key_app_double_click";
    public static final String STYLUS_CUSTOM_KEY_APP_ONE_CLICK = "stylus_custom_key_app_one_click";
    public static final String STYLUS_CUSTOM_KEY_DOUBLE_CLICK = "stylus_custom_key_double_click";
    public static final String STYLUS_CUSTOM_KEY_LAUNCH_SPECIFIED_APP = "stylus_custom_key_launch_specified_app";
    public static final String STYLUS_CUSTOM_KEY_LONG_PRESS = "stylus_custom_key_long_press";
    public static final String STYLUS_CUSTOM_KEY_ONE_CLICK = "stylus_custom_key_one_click";
    public static final String STYLUS_KEY_ACTIVATE_VOICE_INPUT = "stylus_key_activate_voice_input";
    public static final String STYLUS_KEY_IDEA_PILLS_BETA = "stylus_key_idea_pills_beta";
    public static final String STYLUS_KEY_LAUNCH_SPECIFIED_APP = "stylus_key_launch_specified_app";
    public static final String STYLUS_KEY_LAUNCH_WHITEBOARD = "stylus_key_launch_whiteboard";
    public static final String STYLUS_KEY_NEW_CANVAS = "stylus_key_new_canvas";
    public static final String STYLUS_KEY_NEW_NOTE = "stylus_key_new_note";
    public static final String STYLUS_KEY_NONE = "stylus_key_none";
    public static final String STYLUS_KEY_PRESENTATION_PAGE = "stylus_key_presentation_page";
    public static final String STYLUS_KEY_SCREENRECORD = "stylus_key_screenrecord";
    public static final String STYLUS_KEY_SCREENSHOT_COPY = "stylus_key_screenshot_copy";
    public static final String STYLUS_KEY_SCREENSHOT_MARKUP = "stylus_key_screenshot_markup";
    public static final String STYLUS_KEY_SEARCH_WORD_MODE = "stylus_key_search_word_mode";
    public static final String STYLUS_KEY_TEXT_BOOM_SETTINGS = "stylus_key_text_boom_settings";
    public static final String SYSTEM_APP_CUSTOMIZED_STATUS_BAR = "system_app_customized_status_bar_";
    public static final String TALK_BACK_ACTIVITY_NAME = "com.android.talkback.TalkBackPreferencesActivity";
    public static final String TALK_BACK_SERVICE_NAME = "com.google.android.marvin.talkback.TalkBackService";
    public static final String TB_SELECT_SPEECH_SERVICE_NAME = "com.google.android.accessibility.selecttospeak.SelectToSpeakService";
    public static final String TB_SWITCH_SERVICE_NAME = "com.android.switchaccess.SwitchAccessService";
    public static final String TEXT_BOOM_SERVICE_NAME = "com.bytedanceos.textboom.service.BoomAccessibilityService";
    public static final String THIRD_APP_CUSTOMIZED_STATUS_BAR = "disable_3rd_app_customized_status_bar";
    public static final String TYPE_PAYMENT = "payment";
    public static final String USE_AUTO_TIME_SWITCH = "use_auto_time_switch_settings";
    public static final String VIDEO_NAME_KEY = "video_name";
    public static final String VOICE_ASSIST_SERVICE_NAME = "com.aitek.sdklib.service.SuperAccessibilityService";
    public static final String VOICE_COMMAND_SERVICE_NAME = "com.bytedanceos.sara.voicecommand.VoiceCommandAccessibilityService";
    public static final String WHITEBOARD_MAINACTIVITY = "com.bytedanceos.whiteboard.MainActivity";
    public static final String WIFI_PRIORIT_NETWORK = "persist.wifi.manual.sort";
    public static boolean sIsBostonConnected;

    public static class ACTION {
        public static final String ACTION_LAUNCHER_READY = "com.bytedanceos.launcher.ready";
        public static final String ACTION_PASSWORD_CHANGED = "com.bytedanceos.intent.PASSWORD_CHANGED";
        public static final String ACTION_STATUSBAR_SETTINGS_CHANGED = "bytedanceos.intent.action.STATUSBAR_SETTINGS_CHANGED";

        public ACTION() {
        }
    }

    public Constants() {
    }

    static {
        boolean r1 = true;
        Class<?> r3 = Class.forName("android.content.pm.ApplicationInfo");     // Catch: Exception -> L5
        Field r4 = r3.getField("FLAG_SMT_SYSTEM_APP_CAN_UNINSTALL");     // Catch: Exception -> L5
        r4.setAccessible(true);     // Catch: Exception -> L5
        FLAG_SMT_SYSTEM_APP_CAN_UNINSTALL = r4.getInt(r3);     // Catch: Exception -> L5
        OLog.d("Settings", "FLAG_SMT_SYSTEM_APP_CAN_UNINSTALL = " + FLAG_SMT_SYSTEM_APP_CAN_UNINSTALL);     // Catch: Exception -> L5
    L7:
        if (SettingsFeature.isDarwin() == true) goto L9;
    L13:
        r1 = false;
    L14:
        sIsBostonConnected = r1;
        STYLUS_CONTROL_SERVICE_READ_UUID = ParcelUuid.fromString("00002199-0000-1000-8000-00805f9b34fb");
        STYLUS_CONTROL_CHARACTERISTIC_KEY_EVENT = ParcelUuid.fromString("00002288-0000-1000-8000-00805f9b34fb");
        STYLUS_CONTROL_CHARACTERISTIC_BATT_LEVEL = ParcelUuid.fromString("00002289-0000-1000-8000-00805f9b34fb");
        STYLUS_CONTROL_CHARACTERISTIC_CHARGE_STATE = ParcelUuid.fromString("00002290-0000-1000-8000-00805f9b34fb");
        STYLUS_CONTROL_SERVICE_NOTIFY_UUID = ParcelUuid.fromString("00001999-0000-1000-8000-00805f9b34fb");
        STYLUS_CONTROL_CHARACTERISTIC_KEY_EVENT_NOTIFY = ParcelUuid.fromString("00002088-0000-1000-8000-00805f9b34fb");
        STYLUS_CONTROL_CHARACTERISTIC_BATT_LEVEL_NOTIFY = ParcelUuid.fromString("00002089-0000-1000-8000-00805f9b34fb");
        STYLUS_CONTROL_CHARACTERISTIC_CHARGE_STATE_NOTIFY = ParcelUuid.fromString("00002090-0000-1000-8000-00805f9b34fb");
        STYLUS_CONTROL_CHARACTERISTIC_CONFIG_DESCRIPTOR = ParcelUuid.fromString("00002902-0000-1000-8000-00805f9b34fb");
        return;
    L9:
        if (CasthalManager.getInstance(SettingsApplication.getContext()) == null) goto L13;
        if (CasthalManager.getInstance(SettingsApplication.getContext()).isBostonConnected() == false) goto L13;
    L5:
        FLAG_SMT_SYSTEM_APP_CAN_UNINSTALL = 0;
        goto L7
    }
}
