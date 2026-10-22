package com.android.settingslib.media.flags;

/* JADX INFO: loaded from: classes.dex */
public final class Flags {
    private static FeatureFlags FEATURE_FLAGS = null;
    public static final String FLAG_ENABLE_OUTPUT_SWITCHER_FOR_SYSTEM_ROUTING = "com.android.settingslib.media.flags.enable_output_switcher_for_system_routing";
    public static final String FLAG_ENABLE_TV_MEDIA_OUTPUT_DIALOG = "com.android.settingslib.media.flags.enable_tv_media_output_dialog";
    public static final String FLAG_REMOVE_UNNECESSARY_ROUTE_SCANNING = "com.android.settingslib.media.flags.remove_unnecessary_route_scanning";
    public static final String FLAG_USE_MEDIA_ROUTER2_FOR_INFO_MEDIA_MANAGER = "com.android.settingslib.media.flags.use_media_router2_for_info_media_manager";
    public static final String FLAG_USE_PLAYBACK_INFO_FOR_ROUTING_CONTROLS = "com.android.settingslib.media.flags.use_playback_info_for_routing_controls";

    public Flags() {
    }

    public static boolean enableOutputSwitcherForSystemRouting() {
        return FEATURE_FLAGS.enableOutputSwitcherForSystemRouting();
    }

    public static boolean enableTvMediaOutputDialog() {
        return FEATURE_FLAGS.enableTvMediaOutputDialog();
    }

    public static boolean removeUnnecessaryRouteScanning() {
        return FEATURE_FLAGS.removeUnnecessaryRouteScanning();
    }

    public static boolean useMediaRouter2ForInfoMediaManager() {
        return FEATURE_FLAGS.useMediaRouter2ForInfoMediaManager();
    }

    public static boolean usePlaybackInfoForRoutingControls() {
        return FEATURE_FLAGS.usePlaybackInfoForRoutingControls();
    }

    static {
        FEATURE_FLAGS = new FeatureFlagsImpl();
    }
}
