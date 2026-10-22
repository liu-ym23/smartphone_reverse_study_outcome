package com.android.settings.bluetooth;

import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothPbap;
import android.content.Context;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
final class PbapServerProfile implements LocalBluetoothProfile {
    static final String NAME = "PBAP Server";
    private static final int ORDINAL = 6;
    private static final String TAG = "PbapServerProfile";
    private boolean mIsProfileReady;
    private BluetoothPbap mService;

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public boolean connect(BluetoothDevice r1) {
        return false;
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getDrawableResource(BluetoothClass r1) {
        return 0;
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getNameResource(BluetoothDevice r1) {
        return 0;
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getOrdinal() {
        return 6;
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getPreferred(BluetoothDevice r1) {
        return -1;
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getSummaryResourceForDevice(BluetoothDevice r1) {
        return 0;
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public boolean isAutoConnectable() {
        return false;
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public boolean isConnectable() {
        return true;
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public boolean isPreferred(BluetoothDevice r1) {
        return false;
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public void setPreferred(BluetoothDevice r1, boolean r2) {
    }

    public String toString() {
        return "PBAP Server";
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public boolean isProfileReady() {
        return this.mIsProfileReady;
    }

    PbapServerProfile(Context r1) {
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public boolean disconnect(BluetoothDevice r2) {
        BluetoothPbap r1 = this.mService;
        if (r1 != null) goto L5;
        return false;
    L5:
        r1.setConnectionPolicy(r2, 0);
        return false;
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getConnectionStatus(BluetoothDevice r2) {
        BluetoothPbap r1 = this.mService;
        if (r1 != null) goto L6;
        return 0;
    L6:
        if (r1.getConnectionState(r2) != 2) goto L8;
        return 2;
    L8:
        return 0;
    }

    protected void finalize() {
        OLog.d(TAG, "finalize()");
    L15:
        th = move-exception;
        super.finalize();     // Catch: Throwable -> L18
    L20:
        throw th;
    L18:
        th = move-exception;
        th.printStackTrace();
        goto L20
    L4:
        if (this.mService != null) goto L26;
    L23:
        super.finalize();     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    L26:
        this.mService = null;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        OLog.w(TAG, "Error cleaning up PBAP proxy", th);     // Catch: Throwable -> L15
        goto L23
    }
}
