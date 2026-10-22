package com.android.settings.bluetooth;

/* JADX INFO: loaded from: classes2.dex */
interface BluetoothCallback {
    void onBluetoothStateChanged(int r1);

    void onDeviceAdded(CachedBluetoothDevice r1);

    void onDeviceBondStateChanged(CachedBluetoothDevice r1, int r2);

    void onDeviceDeleted(CachedBluetoothDevice r1);

    void onScanningStateChanged(boolean r1);
}
