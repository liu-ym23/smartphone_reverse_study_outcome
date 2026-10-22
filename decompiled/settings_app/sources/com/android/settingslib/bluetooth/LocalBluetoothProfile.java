package com.android.settingslib.bluetooth;

import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;

/* JADX INFO: loaded from: classes.dex */
public interface LocalBluetoothProfile {
    boolean accessProfileEnabled();

    int getConnectionPolicy(BluetoothDevice r1);

    int getConnectionStatus(BluetoothDevice r1);

    int getDrawableResource(BluetoothClass r1);

    int getNameResource(BluetoothDevice r1);

    int getOrdinal();

    int getProfileId();

    int getSummaryResourceForDevice(BluetoothDevice r1);

    boolean isAutoConnectable();

    boolean isEnabled(BluetoothDevice r1);

    boolean isProfileReady();

    boolean setEnabled(BluetoothDevice r1, boolean r2);
}
