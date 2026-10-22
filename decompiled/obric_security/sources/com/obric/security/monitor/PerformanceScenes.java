package com.obric.security.monitor;

import kotlin.Metadata;

/* JADX INFO: compiled from: PerformanceMonitors.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b'\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/obric/security/monitor/PerformanceScenes;", "", "()V", "ACTION_CLEANER_TRASH_SCAN", "", "ACTION_PERMISSION_BACKGROUND_NETWORK_FIRST_LOAD", "ACTION_PERMISSION_DATA_USAGE_INIT", "ACTION_PERMISSION_NETWORK_CONTROL_FIRST_LOAD", "FPS_ANIM_PERMISSION_BACKGROUND_NETWORK_SEARCH", "FPS_ANIM_PERMISSION_NETWORK_CONTROL_SEARCH", "FPS_BATTERY_POWER_CONSUMPTION_RANKING_LIST", "FPS_BATTERY_POWER_HIGH_POWER_LIST", "FPS_BATTERY_POWER_SCROLL", "FPS_BIG_FILE_LIST", "FPS_CLEANER_APK_LIST", "FPS_CLEANER_SOFT_CACHE_LIST", "FPS_CLEANER_SYSTEM_RUBBISH_LIST", "FPS_CLEANER_UNINSTALL_RETAIL_LIST", "FPS_MEMORY_CLEAN_RUNNING_LIST", "FPS_NODISTURB_BLACKLIST_LIST", "FPS_NODISTURB_SMS_KEYWORD_LIST", "FPS_NODISTURB_WHITELIST_LIST", "FPS_PERMISSION_BACKGROUND_NETWORK_LIST", "FPS_PERMISSION_DISTURB_CALL_LIST", "FPS_PERMISSION_DISTURB_SMS_LIST", "FPS_PERMISSION_NETWORK_CONTROL_LIST", "FPS_STORAGE_MANAGER_SCROLL", "LAUNCH_PMP_MAIN", "PAGE_MAIN_HOME", "PAGE_PERMISSION_APP_MANAGER", "PAGE_PERMISSION_BACKGROUND_NETWORK", "PAGE_PERMISSION_DATA_USAGE", "PAGE_PERMISSION_DISTURB", "PAGE_PERMISSION_DISTURB_CALL", "PAGE_PERMISSION_DISTURB_SMS", "PAGE_PERMISSION_NETWORK_CONTROL", "PAGE_SETTINGS", "THREAD_PERMISSION_APP_MANAGER_LOAD", "THREAD_PERMISSION_BACKGROUND_NETWORK_LOAD", "THREAD_PERMISSION_DATA_USAGE_LOAD", "THREAD_PERMISSION_DISTURB_LOAD", "THREAD_PERMISSION_MAIN_LAUNCH", "THREAD_PERMISSION_NETWORK_CONTROL_LOAD", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class PerformanceScenes {
    public static final String ACTION_CLEANER_TRASH_SCAN = "action_cleaner_trash_scan";
    public static final String ACTION_PERMISSION_BACKGROUND_NETWORK_FIRST_LOAD = "action_permission_background_network_first_load";
    public static final String ACTION_PERMISSION_DATA_USAGE_INIT = "action_permission_data_usage_init";
    public static final String ACTION_PERMISSION_NETWORK_CONTROL_FIRST_LOAD = "action_permission_network_control_first_load";
    public static final String FPS_ANIM_PERMISSION_BACKGROUND_NETWORK_SEARCH = "fps_anim_permission_background_network_search";
    public static final String FPS_ANIM_PERMISSION_NETWORK_CONTROL_SEARCH = "fps_anim_permission_network_control_search";
    public static final String FPS_BATTERY_POWER_CONSUMPTION_RANKING_LIST = "fps_battery_power_consumption_ranking_list";
    public static final String FPS_BATTERY_POWER_HIGH_POWER_LIST = "fps_battery_power_high_power_list";
    public static final String FPS_BATTERY_POWER_SCROLL = "fps_battery_power_scroll";
    public static final String FPS_BIG_FILE_LIST = "fps_big_file_list";
    public static final String FPS_CLEANER_APK_LIST = "fps_cleaner_apk_list";
    public static final String FPS_CLEANER_SOFT_CACHE_LIST = "fps_cleaner_soft_cache_list";
    public static final String FPS_CLEANER_SYSTEM_RUBBISH_LIST = "fps_cleaner_system_rubbish_list";
    public static final String FPS_CLEANER_UNINSTALL_RETAIL_LIST = "fps_cleaner_uninstall_retail_list";
    public static final String FPS_MEMORY_CLEAN_RUNNING_LIST = "fps_memory_clean_running_list";
    public static final String FPS_NODISTURB_BLACKLIST_LIST = "fps_nodisturb_blacklist_list";
    public static final String FPS_NODISTURB_SMS_KEYWORD_LIST = "fps_nodisturb_sms_keyword_list";
    public static final String FPS_NODISTURB_WHITELIST_LIST = "fps_nodisturb_whitelist_list";
    public static final String FPS_PERMISSION_BACKGROUND_NETWORK_LIST = "fps_permission_background_network_list";
    public static final String FPS_PERMISSION_DISTURB_CALL_LIST = "fps_permission_disturb_call_list";
    public static final String FPS_PERMISSION_DISTURB_SMS_LIST = "fps_permission_disturb_sms_list";
    public static final String FPS_PERMISSION_NETWORK_CONTROL_LIST = "fps_permission_network_control_list";
    public static final String FPS_STORAGE_MANAGER_SCROLL = "fps_storage_manager_scroll";
    public static final PerformanceScenes INSTANCE = null;
    public static final String LAUNCH_PMP_MAIN = "launch_pmp_main";
    public static final String PAGE_MAIN_HOME = "page_main_home";
    public static final String PAGE_PERMISSION_APP_MANAGER = "page_permission_app_manager";
    public static final String PAGE_PERMISSION_BACKGROUND_NETWORK = "page_permission_background_network";
    public static final String PAGE_PERMISSION_DATA_USAGE = "page_permission_data_usage";
    public static final String PAGE_PERMISSION_DISTURB = "page_permission_disturb";
    public static final String PAGE_PERMISSION_DISTURB_CALL = "page_permission_disturb_call";
    public static final String PAGE_PERMISSION_DISTURB_SMS = "page_permission_disturb_sms";
    public static final String PAGE_PERMISSION_NETWORK_CONTROL = "page_permission_network_control";
    public static final String PAGE_SETTINGS = "page_settings";
    public static final String THREAD_PERMISSION_APP_MANAGER_LOAD = "thread_permission_app_manager_load";
    public static final String THREAD_PERMISSION_BACKGROUND_NETWORK_LOAD = "thread_permission_background_network_load";
    public static final String THREAD_PERMISSION_DATA_USAGE_LOAD = "thread_permission_data_usage_load";
    public static final String THREAD_PERMISSION_DISTURB_LOAD = "thread_permission_disturb_load";
    public static final String THREAD_PERMISSION_MAIN_LAUNCH = "thread_permission_main_launch";
    public static final String THREAD_PERMISSION_NETWORK_CONTROL_LOAD = "thread_permission_network_control_load";

    static {
        INSTANCE = new PerformanceScenes();
    }

    private PerformanceScenes() {
    }
}
