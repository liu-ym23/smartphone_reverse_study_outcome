package com.android.settings.bluetooth;

import android.content.Context;
import android.content.SharedPreferences;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
final class LocalBluetoothPreferences {
    private static final int GRACE_PERIOD_TO_SHOW_DIALOGS_IN_FOREGROUND = 60000;
    private static final String KEY_DISCOVERABLE_END_TIMESTAMP = "discoverable_end_timestamp";
    private static final String KEY_DISCOVERING_TIMESTAMP = "last_discovering_time";
    private static final String KEY_DOCK_AUTO_CONNECT = "auto_connect_to_dock";
    private static final String KEY_LAST_SELECTED_DEVICE = "last_selected_device";
    private static final String KEY_LAST_SELECTED_DEVICE_TIME = "last_selected_device_time";
    private static final String SHARED_PREFERENCES_NAME = "bluetooth_settings";
    private static final String TAG = "LocalBluetoothPreferences";

    private LocalBluetoothPreferences() {
    }

    private static SharedPreferences getSharedPreferences(Context r2) {
        return r2.getSharedPreferences(SHARED_PREFERENCES_NAME, 0);
    }

    static long getDiscoverableEndTimestamp(Context r3) {
        return getSharedPreferences(r3).getLong(KEY_DISCOVERABLE_END_TIMESTAMP, 0);
    }

    static boolean shouldShowDialogInForeground(Context r13, String r14) {
        LocalBluetoothManager r0 = LocalBluetoothManager.getInstance(r13);
        if (r0 != null) goto L7;
        OLog.v(TAG, "manager == null - do not show dialog.");
        return false;
    L7:
        if (r0.isForegroundActivity() == false) goto L10;
        return true;
    L10:
        if ((r13.getResources().getConfiguration().uiMode & 5) != 5) goto L13;
        OLog.v(TAG, "in appliance mode - do not show dialog.");
        return false;
    L13:
        long r5 = System.currentTimeMillis();
        SharedPreferences r15 = getSharedPreferences(r13);
        if ((r15.getLong(KEY_DISCOVERABLE_END_TIMESTAMP, 0) + 60000) <= r5) goto L16;
        return true;
    L16:
        LocalBluetoothAdapter r1 = r0.getBluetoothAdapter();
        if (r1 == null) goto L22;
        if (r1.isDiscovering() == false) goto L22;
        return true;
    L22:
        if ((r15.getLong(KEY_DISCOVERING_TIMESTAMP, 0) + 60000) <= r5) goto L24;
        return true;
    L24:
        if (r14 != null) goto L26;
    L30:
        OLog.v(TAG, "Found no reason to show the dialog - do not show dialog.");
        return false;
    L26:
        if (r14.equals(r15.getString(KEY_LAST_SELECTED_DEVICE, null)) == false) goto L30;
        if ((r15.getLong(KEY_LAST_SELECTED_DEVICE_TIME, 0) + 60000) <= r5) goto L30;
        return true;
    }

    static void persistSelectedDeviceInPicker(Context r2, String r3) {
        SharedPreferences.Editor r4 = getSharedPreferences(r2).edit();
        r4.putString(KEY_LAST_SELECTED_DEVICE, r3);
        r4.putLong(KEY_LAST_SELECTED_DEVICE_TIME, System.currentTimeMillis());
        r4.apply();
    }

    static void persistDiscoverableEndTimestamp(Context r1, long r2) {
        SharedPreferences.Editor r3 = getSharedPreferences(r1).edit();
        r3.putLong(KEY_DISCOVERABLE_END_TIMESTAMP, r2);
        r3.apply();
    }

    static void persistDiscoveringTimestamp(Context r3) {
        SharedPreferences.Editor r4 = getSharedPreferences(r3).edit();
        r4.putLong(KEY_DISCOVERING_TIMESTAMP, System.currentTimeMillis());
        r4.apply();
    }

    static boolean hasDockAutoConnectSetting(Context r2, String r3) {
        return getSharedPreferences(r2).contains(KEY_DOCK_AUTO_CONNECT + r3);
    }

    static boolean getDockAutoConnectSetting(Context r2, String r3) {
        return getSharedPreferences(r2).getBoolean(KEY_DOCK_AUTO_CONNECT + r3, false);
    }

    static void saveDockAutoConnectSetting(Context r2, String r3, boolean r4) {
        SharedPreferences.Editor r5 = getSharedPreferences(r2).edit();
        r5.putBoolean(KEY_DOCK_AUTO_CONNECT + r3, r4);
        r5.apply();
    }

    static void removeDockAutoConnectSetting(Context r2, String r3) {
        SharedPreferences.Editor r4 = getSharedPreferences(r2).edit();
        r4.remove(KEY_DOCK_AUTO_CONNECT + r3);
        r4.apply();
    }
}
