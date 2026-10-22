package com.android.settings.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothSap;
import android.content.Context;
import com.android.settings.R;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
final class SapServerProfile implements LocalBluetoothProfile {
    static final String NAME = "SAP Server";
    private static final int ORDINAL = 10;
    private static final String TAG = "SapServerProfile";
    private boolean mIsProfileReady;
    private BluetoothSap mService;

    /* JADX INFO: renamed from: com.android.settings.bluetooth.SapServerProfile$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private final class SapServiceListener implements BluetoothProfile.ServiceListener {
        final /* synthetic */ SapServerProfile this$0;

        private SapServiceListener(SapServerProfile r1) {
            this.this$0 = r1;
        }

        /* synthetic */ SapServiceListener(SapServerProfile r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int r2, BluetoothProfile r3) {
            OLog.d(SapServerProfile.TAG, "Bluetooth service connected");
            SapServerProfile.access$002(this.this$0, (BluetoothSap) r3);
            SapServerProfile.access$102(this.this$0, true);
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int r2) {
            OLog.d(SapServerProfile.TAG, "Bluetooth service disconnected");
            SapServerProfile.access$102(this.this$0, false);
        }
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public boolean connect(BluetoothDevice r1) {
        return false;
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getDrawableResource(BluetoothClass r1) {
        return R.drawable.ic_bt_network_pan;
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getNameResource(BluetoothDevice r1) {
        return R.string.bluetooth_profile_sap;
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getOrdinal() {
        return 10;
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getPreferred(BluetoothDevice r1) {
        return -1;
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
        return true;
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public void setPreferred(BluetoothDevice r1, boolean r2) {
    }

    public String toString() {
        return NAME;
    }

    static /* synthetic */ BluetoothSap access$002(SapServerProfile r0, BluetoothSap r1) {
        r0.mService = r1;
        return r1;
    }

    static /* synthetic */ boolean access$102(SapServerProfile r0, boolean r1) {
        r0.mIsProfileReady = r1;
        return r1;
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public boolean isProfileReady() {
        return this.mIsProfileReady;
    }

    SapServerProfile(Context r4) {
        BluetoothAdapter.getDefaultAdapter().getProfileProxy(r4, new SapServiceListener(this, null), 10);
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public boolean disconnect(BluetoothDevice r1) {
        BluetoothSap r0 = this.mService;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.disconnect(r1);
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getConnectionStatus(BluetoothDevice r1) {
        BluetoothSap r0 = this.mService;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getConnectionState(r1);
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getSummaryResourceForDevice(BluetoothDevice r1) {
        int r0 = getConnectionStatus(r1);
        if (r0 != 0) goto L5;
        return R.string.bluetooth_sap_profile_summary_use_for;
    L5:
        if (r0 != 2) goto L7;
        return R.string.bluetooth_sap_profile_summary_connected;
    L7:
        return Utils.getConnectionStateSummary(r0);
    }

    protected void finalize() {
        OLog.d(TAG, "finalize()");
    L14:
        th = move-exception;
        super.finalize();     // Catch: Throwable -> L17
    L19:
        throw th;
    L17:
        th = move-exception;
        th.printStackTrace();
        goto L19
    L4:
        if (this.mService != null) goto L23;
    L20:
        super.finalize();     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
        return;
    L23:
        BluetoothAdapter.getDefaultAdapter().closeProfileProxy(10, this.mService);     // Catch: Throwable -> L7
        this.mService = null;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        OLog.w(TAG, "Error cleaning up SAP proxy", th);     // Catch: Throwable -> L14
        goto L20
    }
}
