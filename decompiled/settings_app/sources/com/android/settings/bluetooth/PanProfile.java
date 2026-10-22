package com.android.settings.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothPan;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import com.android.settings.R;
import com.obric.olog.OLog;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
final class PanProfile implements LocalBluetoothProfile {
    static final String NAME = "PAN";
    private static final int ORDINAL = 4;
    private static final String TAG = "PanProfile";
    private final HashMap<BluetoothDevice, Integer> mDeviceRoleMap;
    private boolean mIsProfileReady;
    private BluetoothPan mService;

    /* JADX INFO: renamed from: com.android.settings.bluetooth.PanProfile$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private final class PanServiceListener implements BluetoothProfile.ServiceListener {
        final /* synthetic */ PanProfile this$0;

        private PanServiceListener(PanProfile r1) {
            this.this$0 = r1;
        }

        /* synthetic */ PanServiceListener(PanProfile r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int r2, BluetoothProfile r3) {
            OLog.d(PanProfile.TAG, "Bluetooth service connected");
            PanProfile.access$002(this.this$0, (BluetoothPan) r3);
            PanProfile.access$102(this.this$0, true);
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int r2) {
            OLog.d(PanProfile.TAG, "Bluetooth service disconnected");
            PanProfile.access$102(this.this$0, false);
        }
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getDrawableResource(BluetoothClass r1) {
        return R.drawable.ic_bt_network_pan;
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getOrdinal() {
        return 4;
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

    static /* synthetic */ BluetoothPan access$002(PanProfile r0, BluetoothPan r1) {
        r0.mService = r1;
        return r1;
    }

    static /* synthetic */ boolean access$102(PanProfile r0, boolean r1) {
        r0.mIsProfileReady = r1;
        return r1;
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public boolean isProfileReady() {
        return this.mIsProfileReady;
    }

    PanProfile(Context r4) {
        this.mDeviceRoleMap = new HashMap();
        BluetoothAdapter.getDefaultAdapter().getProfileProxy(r4, new PanServiceListener(this, null), 5);
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public boolean connect(BluetoothDevice r1) {
        BluetoothPan r0 = this.mService;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.connect(r1);
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public boolean disconnect(BluetoothDevice r1) {
        BluetoothPan r0 = this.mService;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.disconnect(r1);
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getConnectionStatus(BluetoothDevice r1) {
        BluetoothPan r0 = this.mService;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getConnectionState(r1);
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getNameResource(BluetoothDevice r1) {
        if (isLocalRoleNap(r1) == false) goto L6;
        return R.string.bluetooth_profile_pan_nap;
    L6:
        return R.string.bluetooth_profile_pan;
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getSummaryResourceForDevice(BluetoothDevice r3) {
        int r0 = getConnectionStatus(r3);
        if (r0 != 0) goto L5;
        return R.string.bluetooth_pan_profile_summary_use_for;
    L5:
        if (r0 == 2) goto L9;
        return Utils.getConnectionStateSummary(r0);
    L9:
        if (isLocalRoleNap(r3) == false) goto L12;
        return R.string.bluetooth_pan_nap_profile_summary_connected;
    L12:
        return R.string.bluetooth_pan_user_profile_summary_connected;
    }

    void setLocalRole(BluetoothDevice r1, int r2) {
        this.mDeviceRoleMap.put(r1, Integer.valueOf(r2));
    }

    boolean isLocalRoleNap(BluetoothDevice r3) {
        if (this.mDeviceRoleMap.containsKey(r3) == true) goto L5;
        return false;
    L5:
        if (this.mDeviceRoleMap.get(r3).intValue() == 1) goto L7;
        return false;
    L7:
        return true;
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
        BluetoothAdapter.getDefaultAdapter().closeProfileProxy(5, this.mService);     // Catch: Throwable -> L7
        this.mService = null;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        OLog.w(TAG, "Error cleaning up PAN proxy", th);     // Catch: Throwable -> L14
        goto L20
    }
}
