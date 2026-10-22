package com.bytedance.framwork.core.sdkmonitor;

/* JADX INFO: loaded from: classes.dex */
public class MonitorConstants {
    public static final String COLLECT_PATH = "/monitor/collect/";
    public static final int DISABLE_ERROR_API = 0;
    public static String ENABLE_ACTIVE_UPLOAD_ALOG = "enable_active_upload_alog";
    public static final int ENABLE_NET_STATA = 0;
    public static final long FETCH_SETTING_INTERVAL = 1200;
    public static final String HOST_APP_ID = "host_aid";
    public static final String HOST_APP_PACKAGE_NAME = "package_name";
    public static final String HTTPS = "https://";
    public static final String KEY_AID = "aid";
    static final String KEY_APP_VERSION = "app_version";
    static final String KEY_CHANNEL = "channel";
    static final String KEY_DEVICE_BRAND = "device_brand";
    public static final String KEY_DEVICE_ID = "device_id";
    static final String KEY_DEVICE_MANUFACTURER = "device_manufacturer";
    static final String KEY_DEVICE_MODEL = "device_model";
    public static final String KEY_MONITOR_FROM = "monitor_from";
    public static final String KEY_MONITOR_VERSION = "sdkmonitor_version";
    static final String KEY_OS = "os";
    static final String KEY_OS_API = "os_api";
    static final String KEY_OS_VERSION = "os_version";
    static final String KEY_OVERSEA = "oversea";
    static final String KEY_PLATFORM = "device_platform";
    public static final String KEY_QUERY_MINOR_VERSION = "minor_version";
    static final String KEY_REGION = "region";
    static final String KEY_VERSION_CODE = "version_code";
    static final String KEY_VERSION_NAME = "version_name";
    public static final int LOG_REPORT_COUNT = 100;
    public static final int LOG_REPORT_INTERVAL = 120;
    public static final int LOG_SEND_SWITCH = 1;
    public static final long MIN_FETCH_SETTING_INTERVAL = 600;
    public static final String MONITOR_CONFIG = "monitor_config";
    public static final String MONITOR_CONFIG_REFRESH_TIME = "monitor_configure_refresh_time";
    public static final String MONITOR_CONFIG_UPDATE = "monitor_config_update";
    public static final String MONITOR_FROM_SDK = "sdk";
    public static final int MONITOR_LOG_MAX_SAVE_COUNT = 2000;
    public static final String MONITOR_NET_CONFIG = "monitor_net_config";
    public static final String MONITOR_TYPE_API_ALL = "api_all";
    public static final String MONITOR_TYPE_API_ERROR = "api_error";
    public static final String MONITOR_TYPE_SERVICE_MONITOR = "service_monitor";
    public static final int REPORT_FAIL_REPEAT_BASE_TIME = 15;
    public static final int REPORT_FAIL_REPEAT_COUNT = 4;
    public static final String REPORT_TYPE = "sdk_monitor";
    public static String SETTING_CUSTOM_EVENT = "custom_event_settings";
    public static String SETTING_GENERAL = "general";
    public static String SETTING_GENERAL_API = "slardar_api_settings";
    public static String SETTING_GENERAL_API_FETCH = "fetch_setting";
    public static String SETTING_GENERAL_API_FETCH_INTERVAL = "fetch_setting_interval";
    public static String SETTING_GENERAL_API_REPORT = "report_setting";
    public static String SETTING_GENERAL_API_REPORT_BG_UOLOADING_INTERVAL = "uploading_interval_background";
    public static String SETTING_GENERAL_API_REPORT_ENCRYPT = "enable_encrypt";
    public static String SETTING_GENERAL_API_REPORT_HOSTS = "hosts";
    public static String SETTING_GENERAL_API_REPORT_UOLOADING_INTERVAL = "uploading_interval";
    public static String SETTING_GENERAL_CLEANUP = "cleanup";
    public static String SETTING_NETWORK = "network";
    public static String SETTING_NETWORK_IMAGE_MODULES = "network_image_modules";
    public static final String SETTING_V2_PATH = "/monitor/appmonitor/v2/settings";
    public static final String SETTING_V3_PATH = "/monitor/appmonitor/v3/settings";
    public static final long STOP_MORE_CHANNEL_INTERVAL = 1800;

    static {
    }

    public MonitorConstants() {
    }
}
