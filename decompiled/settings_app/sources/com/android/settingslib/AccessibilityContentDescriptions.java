package com.android.settingslib;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityContentDescriptions {
    public static final int[] DATA_CONNECTION_STRENGTH = null;
    public static final int[] ETHERNET_CONNECTION_VALUES = null;
    public static final int NO_CALLING = 0;
    public static final int[] PHONE_SIGNAL_STRENGTH = null;
    public static final int[] PHONE_SIGNAL_STRENGTH_INFLATED = null;
    public static final int PHONE_SIGNAL_STRENGTH_NONE = 0;
    public static final int[] WIFI_CONNECTION_STRENGTH = null;
    public static final int WIFI_NO_CONNECTION = 0;
    public static final int WIFI_OTHER_DEVICE_CONNECTION = 0;

    private AccessibilityContentDescriptions() {
    }

    static {
        int r0 = R.string.accessibility_no_phone;
        PHONE_SIGNAL_STRENGTH_NONE = r0;
        PHONE_SIGNAL_STRENGTH = new int[]{r0, R.string.accessibility_phone_one_bar, R.string.accessibility_phone_two_bars, R.string.accessibility_phone_three_bars, R.string.accessibility_phone_signal_full};
        PHONE_SIGNAL_STRENGTH_INFLATED = new int[]{r0, R.string.accessibility_phone_one_bar, R.string.accessibility_phone_two_bars, R.string.accessibility_phone_three_bars, R.string.accessibility_phone_four_bars, R.string.accessibility_phone_signal_full};
        DATA_CONNECTION_STRENGTH = new int[]{R.string.accessibility_no_data, R.string.accessibility_data_one_bar, R.string.accessibility_data_two_bars, R.string.accessibility_data_three_bars, R.string.accessibility_data_signal_full};
        WIFI_CONNECTION_STRENGTH = new int[]{R.string.accessibility_no_wifi, R.string.accessibility_wifi_one_bar, R.string.accessibility_wifi_two_bars, R.string.accessibility_wifi_three_bars, R.string.accessibility_wifi_signal_full};
        WIFI_NO_CONNECTION = R.string.accessibility_no_wifi;
        WIFI_OTHER_DEVICE_CONNECTION = R.string.accessibility_wifi_other_device;
        NO_CALLING = R.string.accessibility_no_calling;
        ETHERNET_CONNECTION_VALUES = new int[]{R.string.accessibility_ethernet_disconnected, R.string.accessibility_ethernet_connected};
    }

    public static int getDescriptionForLevel(int r1) {
        if (r1 > 4) goto L8;
        if (r1 >= 0) goto L7;
        return 0;
    L7:
        return PHONE_SIGNAL_STRENGTH[r1];
    L8:
        return 0;
    }

    public static int getDescriptionForInflatedLevel(int r1) {
        if (r1 > 5) goto L8;
        if (r1 >= 0) goto L7;
        return 0;
    L7:
        return PHONE_SIGNAL_STRENGTH_INFLATED[r1];
    L8:
        return 0;
    }

    public static int getDescriptionForLevel(int r1, int r2) {
        if (r2 != 5) goto L7;
        return getDescriptionForLevel(r1);
    L7:
        if (r2 == 6) goto L9;
        return 0;
    L9:
        return getDescriptionForInflatedLevel(r1);
    }
}
