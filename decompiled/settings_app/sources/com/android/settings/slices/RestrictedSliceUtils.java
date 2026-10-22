package com.android.settings.slices;

import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
public class RestrictedSliceUtils {
    private static final Uri AUTO_TURN_ON_WIFI_SLICE_URI = null;
    private static final Uri BLUETOOTH_TETHERING_SLICE_URI = null;
    private static final Uri NOTIFY_OPEN_NETWORKS_SLICE_URI = null;
    private static final Uri USB_TETHERING_SLICE_URI = null;

    public RestrictedSliceUtils() {
    }

    static {
        NOTIFY_OPEN_NETWORKS_SLICE_URI = new Uri.Builder().scheme("content").authority(SettingsSliceProvider.SLICE_AUTHORITY).appendPath("action").appendPath("notify_open_networks").build();
        AUTO_TURN_ON_WIFI_SLICE_URI = new Uri.Builder().scheme("content").authority(SettingsSliceProvider.SLICE_AUTHORITY).appendPath("action").appendPath("enable_wifi_wakeup").build();
        USB_TETHERING_SLICE_URI = new Uri.Builder().scheme("content").authority(SettingsSliceProvider.SLICE_AUTHORITY).appendPath("action").appendPath("enable_usb_tethering").build();
        BLUETOOTH_TETHERING_SLICE_URI = new Uri.Builder().scheme("content").authority(SettingsSliceProvider.SLICE_AUTHORITY).appendPath("action").appendPath("enable_bluetooth_tethering_2").build();
    }

    public static boolean isGuestRestricted(Uri r1) {
        if (AUTO_TURN_ON_WIFI_SLICE_URI.equals(r1) == false) goto L5;
        return true;
    L5:
        if (NOTIFY_OPEN_NETWORKS_SLICE_URI.equals(r1) == false) goto L7;
        return true;
    L7:
        if (BLUETOOTH_TETHERING_SLICE_URI.equals(r1) == false) goto L9;
        return true;
    L9:
        if (USB_TETHERING_SLICE_URI.equals(r1) == false) goto L11;
        return true;
    L11:
        if (CustomSliceRegistry.MOBILE_DATA_SLICE_URI.equals(r1) == true) goto L20;
        return false;
    L20:
        return true;
    }
}
