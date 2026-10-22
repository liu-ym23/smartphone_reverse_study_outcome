package com.android.settingslib.bluetooth;

import android.bluetooth.BluetoothCodecStatus;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public interface BluetoothCallback {

    @Retention(RetentionPolicy.SOURCE)
    public @interface AdapterState {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ConnectionState {
    }

    default void onA2dpCodecConfigChanged(CachedBluetoothDevice r1, BluetoothCodecStatus r2) {
    }

    default void onAclConnectionStateChanged(CachedBluetoothDevice r1, int r2) {
    }

    default void onActiveDeviceChanged(CachedBluetoothDevice r1, int r2) {
    }

    default void onAudioModeChanged() {
    }

    default void onAutoOnStateChanged(int r1) {
    }

    default void onBluetoothStateChanged(int r1) {
    }

    default void onBroadcastKeyGenerated() {
    }

    default void onBroadcastStateChanged(int r1) {
    }

    default void onConnectionStateChanged(CachedBluetoothDevice r1, int r2) {
    }

    default void onDeviceAdded(CachedBluetoothDevice r1) {
    }

    default void onDeviceBondStateChanged(CachedBluetoothDevice r1, int r2) {
    }

    default void onDeviceDeleted(CachedBluetoothDevice r1) {
    }

    default void onGroupDiscoveryStatusChanged(int r1, int r2, int r3) {
    }

    default void onNewGroupFound(CachedBluetoothDevice r1, int r2, UUID r3) {
    }

    default void onProfileConnectionStateChanged(CachedBluetoothDevice r1, int r2, int r3) {
    }

    default void onScanningStateChanged(boolean r1) {
    }
}
