package com.android.wifi.flags;

/* JADX INFO: loaded from: classes2.dex */
public final class Flags {
    private static FeatureFlags FEATURE_FLAGS = null;
    public static final String FLAG_ANDROID_V_WIFI_API = "com.android.wifi.flags.android_v_wifi_api";
    public static final String FLAG_ANQP_REQUEST_WAIT_FOR_RESPONSE = "com.android.wifi.flags.anqp_request_wait_for_response";
    public static final String FLAG_D2D_WHEN_INFRA_STA_OFF = "com.android.wifi.flags.d2d_when_infra_sta_off";
    public static final String FLAG_DELAY_SAVE_TO_STORE = "com.android.wifi.flags.delay_save_to_store";
    public static final String FLAG_GET_BSSID_BLOCKLIST_API = "com.android.wifi.flags.get_bssid_blocklist_api";
    public static final String FLAG_GET_CHANNEL_WIDTH_API = "com.android.wifi.flags.get_channel_width_api";
    public static final String FLAG_NETWORK_PROVIDER_BATTERY_CHARGING_STATUS = "com.android.wifi.flags.network_provider_battery_charging_status";
    public static final String FLAG_SHARED_CONNECTIVITY_BROADCAST_RECEIVER_TEST_API = "com.android.wifi.flags.shared_connectivity_broadcast_receiver_test_api";
    public static final String FLAG_SINGLE_WIFI_THREAD = "com.android.wifi.flags.single_wifi_thread";
    public static final String FLAG_TEST_FLAG_FUNCTION = "com.android.wifi.flags.test_flag_function";
    public static final String FLAG_VOIP_DETECTION = "com.android.wifi.flags.voip_detection";

    public Flags() {
    }

    public static boolean androidVWifiApi() {
        return FEATURE_FLAGS.androidVWifiApi();
    }

    public static boolean anqpRequestWaitForResponse() {
        return FEATURE_FLAGS.anqpRequestWaitForResponse();
    }

    public static boolean d2dWhenInfraStaOff() {
        return FEATURE_FLAGS.d2dWhenInfraStaOff();
    }

    public static boolean delaySaveToStore() {
        return FEATURE_FLAGS.delaySaveToStore();
    }

    public static boolean getBssidBlocklistApi() {
        return FEATURE_FLAGS.getBssidBlocklistApi();
    }

    public static boolean getChannelWidthApi() {
        return FEATURE_FLAGS.getChannelWidthApi();
    }

    public static boolean networkProviderBatteryChargingStatus() {
        return FEATURE_FLAGS.networkProviderBatteryChargingStatus();
    }

    public static boolean sharedConnectivityBroadcastReceiverTestApi() {
        return FEATURE_FLAGS.sharedConnectivityBroadcastReceiverTestApi();
    }

    public static boolean singleWifiThread() {
        return FEATURE_FLAGS.singleWifiThread();
    }

    public static boolean testFlagFunction() {
        return FEATURE_FLAGS.testFlagFunction();
    }

    public static boolean voipDetection() {
        return FEATURE_FLAGS.voipDetection();
    }

    static {
        FEATURE_FLAGS = new FeatureFlagsImpl();
    }
}
