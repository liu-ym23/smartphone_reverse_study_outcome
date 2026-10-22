package com.android.settings.bluetooth;

import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;

/* JADX INFO: loaded from: classes2.dex */
interface LocalBluetoothProfile {
    boolean connect(BluetoothDevice r1);

    boolean disconnect(BluetoothDevice r1);

    int getConnectionStatus(BluetoothDevice r1);

    int getDrawableResource(BluetoothClass r1);

    int getNameResource(BluetoothDevice r1);

    int getOrdinal();

    int getPreferred(BluetoothDevice r1);

    int getSummaryResourceForDevice(BluetoothDevice r1);

    boolean isAutoConnectable();

    boolean isConnectable();

    boolean isPreferred(BluetoothDevice r1);

    boolean isProfileReady();

    void setPreferred(BluetoothDevice r1, boolean r2);
}
