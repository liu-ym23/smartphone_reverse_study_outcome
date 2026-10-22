package com.android.settings;

import android.bluetooth.BluetoothUuid;
import android.os.ParcelUuid;

/* JADX INFO: loaded from: classes2.dex */
public interface AdaptConstants {
    public static final ParcelUuid A2DP_SINK = null;
    public static final ParcelUuid A2DP_SOURCE = null;
    public static final String ACTION_NETWORK_SET_TIMEZONE = "com.android.settings.NETWORK_SET_TIMEZONE";
    public static final ParcelUuid ADV_AUDIO_DIST = null;
    public static final String CERTIFICATE_USAGE_CA = "ca";
    public static final int DNS_TYPE_PTR = 12;
    public static final int DNS_TYPE_TXT = 16;
    public static final String EXTRA_CERTIFICATE_USAGE = "certificate_install_usage";
    public static final int FLAG_SMT_SYSTEM_APP_CAN_UNINSTALL = 8;
    public static final ParcelUuid HFP = null;
    public static final ParcelUuid HFP_AG = null;
    public static final ParcelUuid HID = null;
    public static final ParcelUuid HOGP = null;
    public static final String LINK_CONFIGURATION_CHANGED_ACTION = "android.net.wifi.LINK_CONFIGURATION_CHANGED";
    public static final ParcelUuid OBEX_OBJECT_PUSH = null;
    public static final String PACKAGE_VERIFIER_ENABLE = "package_verifier_enable";
    public static final int PERSISTENT_NET_ID = -2;
    public static final String SCREEN_BRIGHTNESS = "screen_brightness";
    public static final String SMT_SENSOR_CAL_LIB_NATIVE = "SMTSensorCalLibNative_system";
    public static final int WIFI_SUPPL_STATE_DISCONNECTED = 1;
    public static final int WIFI_SUPPL_STATE_DORMANT = 11;
    public static final int WIFI_SUPPL_STATE_INACTIVE = 3;
    public static final int WIFI_SUPPL_STATE_INTERFACE_DISABLED = 2;
    public static final int WIFI_SUPPL_STATE_INVALID = 0;
    public static final int WIFI_SUPPL_STATE_UNINITIALIZED = 12;

    static {
        A2DP_SOURCE = BluetoothUuid.A2DP_SOURCE;
        HFP_AG = BluetoothUuid.HFP_AG;
        HFP = BluetoothUuid.HFP;
        OBEX_OBJECT_PUSH = BluetoothUuid.OBEX_OBJECT_PUSH;
        HID = BluetoothUuid.HID;
        HOGP = BluetoothUuid.HOGP;
        A2DP_SINK = BluetoothUuid.A2DP_SINK;
        ADV_AUDIO_DIST = BluetoothUuid.ADV_AUDIO_DIST;
    }
}
