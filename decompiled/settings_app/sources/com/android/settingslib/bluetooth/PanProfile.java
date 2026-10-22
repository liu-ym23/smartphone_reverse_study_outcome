package com.android.settingslib.bluetooth;

import android.R;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothPan;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import com.GlobalProxyLancet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PanProfile implements LocalBluetoothProfile {
    static final String NAME = "PAN";
    private static final int ORDINAL = 4;
    private static final String TAG = "PanProfile";
    private final HashMap<BluetoothDevice, Integer> mDeviceRoleMap;
    private boolean mIsProfileReady;
    private BluetoothPan mService;

    /* JADX INFO: renamed from: com.android.settingslib.bluetooth.PanProfile$1, reason: invalid class name */
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
        public void onServiceConnected(int r1, BluetoothProfile r2) {
            PanProfile.access$002(this.this$0, (BluetoothPan) r2);
            PanProfile.access$102(this.this$0, true);
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int r1) {
            PanProfile.access$102(this.this$0, false);
        }
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean accessProfileEnabled() {
        return true;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getConnectionPolicy(BluetoothDevice r1) {
        return -1;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getDrawableResource(BluetoothClass r1) {
        return R.drawable.ic_menu_chat_dashboard;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getOrdinal() {
        return 4;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getProfileId() {
        return 5;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean isAutoConnectable() {
        return false;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean isEnabled(BluetoothDevice r1) {
        return true;
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

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean isProfileReady() {
        return this.mIsProfileReady;
    }

    PanProfile(Context r4) {
        this.mDeviceRoleMap = new HashMap();
        BluetoothAdapter.getDefaultAdapter().getProfileProxy(r4, new PanServiceListener(this, null), 5);
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getConnectionStatus(BluetoothDevice r1) {
        BluetoothPan r0 = this.mService;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getConnectionState(r1);
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean setEnabled(BluetoothDevice r4, boolean r5) {
        BluetoothPan r0 = this.mService;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r5 == false) goto L14;
        List r6 = r0.getConnectedDevices();
        if (r6 == null) goto L16;
        Iterator r7 = r6.iterator();
    L10:
        if (r7.hasNext() == false) goto L16;
        BluetoothDevice r1 = (BluetoothDevice) r7.next();
        this.mService.setConnectionPolicy(r1, 0);
    L16:
        return this.mService.setConnectionPolicy(r4, 100);
    L14:
        return r0.setConnectionPolicy(r4, 0);
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getNameResource(BluetoothDevice r1) {
        if (isLocalRoleNap(r1) == false) goto L7;
        return com.android.settingslib.R.string.bluetooth_profile_pan_nap;
    L7:
        return com.android.settingslib.R.string.bluetooth_profile_pan;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getSummaryResourceForDevice(BluetoothDevice r3) {
        int r0 = getConnectionStatus(r3);
        if (r0 == 0) goto L15;
        if (r0 == 2) goto L9;
        return BluetoothUtils.getConnectionStateSummary(r0);
    L9:
        if (isLocalRoleNap(r3) == false) goto L13;
        return com.android.settingslib.R.string.bluetooth_pan_nap_profile_summary_connected;
    L13:
        return com.android.settingslib.R.string.bluetooth_pan_user_profile_summary_connected;
    L15:
        return com.android.settingslib.R.string.bluetooth_pan_profile_summary_use_for;
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
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "finalize()");
        if (this.mService == null) goto L11;
        BluetoothAdapter.getDefaultAdapter().closeProfileProxy(5, this.mService);     // Catch: Throwable -> L6
        this.mService = null;     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Error cleaning up PAN proxy", th);
        return;
    }
}
