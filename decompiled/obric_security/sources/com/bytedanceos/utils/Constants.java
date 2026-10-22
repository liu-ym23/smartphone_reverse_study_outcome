package com.bytedanceos.utils;

/* JADX INFO: loaded from: classes2.dex */
public class Constants {
    public static final String ACTION_BYTEDANCE_GAMEAPPTYPE_UPDATED = "android.intent.action_GAMEAPPTYPE_UPDATED";
    public static final int ANDROID_SDK_INT_Q = 29;
    public static final int ANDROID_SDK_INT_R = 30;
    public static final int CHECK_STATE_GENERATE = 1;
    public static final int CHECK_STATE_INIT = 0;
    public static final int CHECK_STATE_NO_SPACE = -2;
    public static final int CHECK_STATE_SAME_FILE = -1;
    public static final String DATA_USAGE_CYCLE = "data_usage_cycle";
    public static final String DATA_USAGE_LIMIT = "data_usage_limit";
    public static final String DATA_USAGE_LIMIT_SUB2 = "data_usage_limit_sub2";
    public static final String DATA_USAGE_LIMIT_UNIT = "data_usage_limit_unit";
    public static final String DATA_USAGE_LIMIT_UNIT_SUB2 = "data_usage_limit_unit_sub2";
    public static final String DATA_USAGE_WARNING = "data_usage_warning";
    public static final String DATA_USAGE_WARNING_SUB2 = "data_usage_warning_sub2";
    public static final String EXTRA_BYTEDANCE_ANIM_RESOURCE_ID = "bytedanceos.intent.extra.ANIM_RESOURCE_ID";
    public static final String FEATURE_PHONE_MODE = "feature_phone_mode";
    public static final int FIVEG_DISABLE = 0;
    public static final int FIVEG_ENABLE = 1;
    public static final String FIVEG_POWER_SAVER_ENABLED = "fiveg_power_saver_enabled";
    public static final Boolean IS_FEATURE_DOMESTIC = null;
    public static final String IS_SET = "true";
    public static final int KB = 1024;
    public static final long MB = 1048576;
    public static final String MEMORY_OPT_ENABLE = "memory_opt_enable";
    public static final int MULTI_SIM_ADAPTER_SUB1 = 0;
    public static final String NEED_REBOOT_KEY = "net.need.reboot";
    public static final String OPTIMIZATION_APPS = "optimization_APPS";
    public static final String PERMISSION_MANAGE_EXTERNAL_STORAGE = "android.permission.MANAGE_EXTERNAL_STORAGE";
    public static final String POWER_ACL_MODE_ENABLE = "acl_mode_enable";
    public static final String POWER_SLEEP_MODE_ENABLE = "sleep_mode_enable";
    public static final String SMART_CHARGING_MODE_ENABLED = "smart_charging_mode_enabled";
    public static final int SMT_5G_DEFAULT_STATUS = 1;
    public static final String SMT_5G_STATUS_KEY = "smt_5g_status";
    public static final String SWAP_FEATURE_PROPERTY_SIZE = "persist.vendor.bytedanceswap.size";
    public static final long SWAP_FEATURE_PROPERTY_SIZE_2G = 2147483648L;
    public static final String SWAP_FILE_PATH = "/data/vendor/swap/swapfile";
    public static final String SWAP_STORAGE_HEALTH = "swap_storage_health";
    public static final int TIMES_MB = 8;
    public static final int USER_DOPPELGANGER = 10;
    public static final String WIRELESS_CHARGING = "Obric_reverse_charging_enable";

    public static class ACL_MODE {
        public static final int ACL_MODE_DEFAULT = 1;
        public static final int ACL_MODE_OFF = 0;
        public static final int ACL_MODE_ON = 1;

        public ACL_MODE() {
        }
    }

    public static class BATTERY_PERCENT_MODE {
        public static final int BATTERY_PERCENT_MODE_DEFAULT = 1;
        public static final int BATTERY_PERCENT_MODE_OFF = 0;
        public static final int BATTERY_PERCENT_MODE_ON = 1;

        public BATTERY_PERCENT_MODE() {
        }
    }

    public static class SLEEP_MODE {
        public static final int SLEEP_MODE_LAST_OFF_STATE = 0;
        public static final int SLEEP_MODE_LAST_ON_STATE = 1;
        public static final int SLEEP_MODE_OFF = 0;
        public static final int SLEEP_MODE_ON = 1;

        public SLEEP_MODE() {
        }
    }

    public Constants() {
    }

    static {
        IS_FEATURE_DOMESTIC = true;
    }
}
