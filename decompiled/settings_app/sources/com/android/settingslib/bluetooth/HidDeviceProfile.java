package com.android.settingslib.bluetooth;

import android.R;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHidDevice;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import com.GlobalProxyLancet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class HidDeviceProfile implements LocalBluetoothProfile {
    static final String NAME = "HID DEVICE";
    private static final int ORDINAL = 18;
    private static final int PREFERRED_VALUE = -1;
    private static final String TAG = "HidDeviceProfile";
    private final CachedBluetoothDeviceManager mDeviceManager;
    private boolean mIsProfileReady;
    private final LocalBluetoothProfileManager mProfileManager;
    private BluetoothHidDevice mService;

    /* JADX INFO: renamed from: com.android.settingslib.bluetooth.HidDeviceProfile$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private final class HidDeviceServiceListener implements BluetoothProfile.ServiceListener {
        final /* synthetic */ HidDeviceProfile this$0;

        private HidDeviceServiceListener(HidDeviceProfile r1) {
            this.this$0 = r1;
        }

        /* synthetic */ HidDeviceServiceListener(HidDeviceProfile r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int r4, BluetoothProfile r5) {
            HidDeviceProfile.access$102(this.this$0, (BluetoothHidDevice) r5);
            Iterator<BluetoothDevice> r6 = HidDeviceProfile.access$100(this.this$0).getConnectedDevices().iterator();
        L4:
            if (r6.hasNext() == false) goto L9;
            BluetoothDevice r7 = r6.next();
            CachedBluetoothDevice r0 = HidDeviceProfile.access$200(this.this$0).findDevice(r7);
            if (r0 != null) goto L8;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(HidDeviceProfile.TAG, "HidProfile found new device: " + r7);
            r0 = HidDeviceProfile.access$200(this.this$0).addDevice(r7);
        L8:
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(HidDeviceProfile.TAG, "Connection status changed: " + r0);
            r0.onProfileStateChanged(this.this$0, 2);
            r0.refresh();
            goto L4
        L9:
            HidDeviceProfile.access$302(this.this$0, true);
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int r1) {
            HidDeviceProfile.access$302(this.this$0, false);
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
        return R.drawable.ic_menu_cc_am;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getOrdinal() {
        return 18;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getProfileId() {
        return 19;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean isAutoConnectable() {
        return false;
    }

    public String toString() {
        return NAME;
    }

    static /* synthetic */ BluetoothHidDevice access$100(HidDeviceProfile r0) {
        return r0.mService;
    }

    static /* synthetic */ BluetoothHidDevice access$102(HidDeviceProfile r0, BluetoothHidDevice r1) {
        r0.mService = r1;
        return r1;
    }

    static /* synthetic */ CachedBluetoothDeviceManager access$200(HidDeviceProfile r0) {
        return r0.mDeviceManager;
    }

    static /* synthetic */ boolean access$302(HidDeviceProfile r0, boolean r1) {
        r0.mIsProfileReady = r1;
        return r1;
    }

    HidDeviceProfile(Context r2, CachedBluetoothDeviceManager r3, LocalBluetoothProfileManager r4) {
        this.mDeviceManager = r3;
        this.mProfileManager = r4;
        BluetoothAdapter.getDefaultAdapter().getProfileProxy(r2, new HidDeviceServiceListener(this, null), 19);
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean isProfileReady() {
        return this.mIsProfileReady;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getConnectionStatus(BluetoothDevice r1) {
        BluetoothHidDevice r0 = this.mService;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getConnectionState(r1);
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean isEnabled(BluetoothDevice r1) {
        if (getConnectionStatus(r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean setEnabled(BluetoothDevice r2, boolean r3) {
        if (r3 == false) goto L5;
        return false;
    L5:
        return this.mService.setConnectionPolicy(r2, 0);
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getNameResource(BluetoothDevice r1) {
        return com.android.settingslib.R.string.bluetooth_profile_hid;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getSummaryResourceForDevice(BluetoothDevice r1) {
        int r0 = getConnectionStatus(r1);
        if (r0 == 0) goto L11;
        if (r0 == 2) goto L9;
        return BluetoothUtils.getConnectionStateSummary(r0);
    L9:
        return com.android.settingslib.R.string.bluetooth_hid_profile_summary_connected;
    L11:
        return com.android.settingslib.R.string.bluetooth_hid_profile_summary_use_for;
    }

    protected void finalize() {
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "finalize()");
        if (this.mService == null) goto L11;
        BluetoothAdapter.getDefaultAdapter().closeProfileProxy(19, this.mService);     // Catch: Throwable -> L6
        this.mService = null;     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Error cleaning up HID proxy", th);
        return;
    }
}
