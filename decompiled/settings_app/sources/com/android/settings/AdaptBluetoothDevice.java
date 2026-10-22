package com.android.settings;

import android.bluetooth.BluetoothDevice;

/* JADX INFO: loaded from: classes2.dex */
public class AdaptBluetoothDevice {
    public AdaptBluetoothDevice() {
    }

    public static void cancel(BluetoothDevice r0) {
        r0.cancelBondProcess();
    }

    public static String getDeviceAliasName(BluetoothDevice r0) {
        return r0.getAlias();
    }
}
