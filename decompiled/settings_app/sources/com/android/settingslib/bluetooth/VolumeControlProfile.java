package com.android.settingslib.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothVolumeControl;
import android.content.Context;
import com.GlobalProxyLancet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class VolumeControlProfile implements LocalBluetoothProfile {
    private static boolean DEBUG = true;
    static final String NAME = "VCP";
    private static final int ORDINAL = 1;
    private static final String TAG = "VolumeControlProfile";
    private Context mContext;
    private final CachedBluetoothDeviceManager mDeviceManager;
    private boolean mIsProfileReady;
    private final LocalBluetoothProfileManager mProfileManager;
    private BluetoothVolumeControl mService;

    /* JADX INFO: renamed from: com.android.settingslib.bluetooth.VolumeControlProfile$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private final class VolumeControlProfileServiceListener implements BluetoothProfile.ServiceListener {
        final /* synthetic */ VolumeControlProfile this$0;

        private VolumeControlProfileServiceListener(VolumeControlProfile r1) {
            this.this$0 = r1;
        }

        /* synthetic */ VolumeControlProfileServiceListener(VolumeControlProfile r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int r4, BluetoothProfile r5) {
            if (VolumeControlProfile.access$000() == false) goto L5;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(VolumeControlProfile.TAG, "Bluetooth service connected");
        L5:
            VolumeControlProfile.access$102(this.this$0, (BluetoothVolumeControl) r5);
            List r6 = VolumeControlProfile.access$100(this.this$0).getConnectedDevices();
        L7:
            if (r6.isEmpty() == true) goto L15;
            BluetoothDevice r7 = (BluetoothDevice) r6.remove(0);
            CachedBluetoothDevice r1 = VolumeControlProfile.access$200(this.this$0).findDevice(r7);
            if (r1 != null) goto L14;
            if (VolumeControlProfile.access$000() == false) goto L13;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(VolumeControlProfile.TAG, "VolumeControlProfile found new device: " + r7);
        L13:
            r1 = VolumeControlProfile.access$200(this.this$0).addDevice(r7);
        L14:
            r1.onProfileStateChanged(this.this$0, 2);
            r1.refresh();
            goto L7
        L15:
            VolumeControlProfile.access$300(this.this$0).callServiceConnectedListeners();
            VolumeControlProfile.access$402(this.this$0, true);
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int r2) {
            if (VolumeControlProfile.access$000() == false) goto L5;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(VolumeControlProfile.TAG, "Bluetooth service disconnected");
        L5:
            VolumeControlProfile.access$300(this.this$0).callServiceDisconnectedListeners();
            VolumeControlProfile.access$402(this.this$0, false);
        }
    }

    static {
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean accessProfileEnabled() {
        return false;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getDrawableResource(BluetoothClass r1) {
        return 0;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getNameResource(BluetoothDevice r1) {
        return 0;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getOrdinal() {
        return 1;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getProfileId() {
        return 23;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getSummaryResourceForDevice(BluetoothDevice r1) {
        return 0;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean isAutoConnectable() {
        return true;
    }

    public String toString() {
        return NAME;
    }

    static /* synthetic */ boolean access$000() {
        return DEBUG;
    }

    static /* synthetic */ BluetoothVolumeControl access$100(VolumeControlProfile r0) {
        return r0.mService;
    }

    static /* synthetic */ BluetoothVolumeControl access$102(VolumeControlProfile r0, BluetoothVolumeControl r1) {
        r0.mService = r1;
        return r1;
    }

    static /* synthetic */ CachedBluetoothDeviceManager access$200(VolumeControlProfile r0) {
        return r0.mDeviceManager;
    }

    static /* synthetic */ LocalBluetoothProfileManager access$300(VolumeControlProfile r0) {
        return r0.mProfileManager;
    }

    static /* synthetic */ boolean access$402(VolumeControlProfile r0, boolean r1) {
        r0.mIsProfileReady = r1;
        return r1;
    }

    VolumeControlProfile(Context r2, CachedBluetoothDeviceManager r3, LocalBluetoothProfileManager r4) {
        this.mContext = r2;
        this.mDeviceManager = r3;
        this.mProfileManager = r4;
        BluetoothAdapter.getDefaultAdapter().getProfileProxy(r2, new VolumeControlProfileServiceListener(this, null), 23);
    }

    public void registerCallback(Executor r1, BluetoothVolumeControl.Callback r2) {
        BluetoothVolumeControl r0 = this.mService;
        if (r0 != null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Proxy not attached to service. Cannot register callback.");
        return;
    L6:
        r0.registerCallback(r1, r2);
    }

    public void unregisterCallback(BluetoothVolumeControl.Callback r1) {
        BluetoothVolumeControl r0 = this.mService;
        if (r0 != null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Proxy not attached to service. Cannot unregister callback.");
        return;
    L6:
        r0.unregisterCallback(r1);
    }

    public void setVolumeOffset(BluetoothDevice r2, int r3) {
        BluetoothVolumeControl r1 = this.mService;
        if (r1 != null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Proxy not attached to service. Cannot set volume offset.");
        return;
    L6:
        if (r2 != null) goto L9;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Device is null. Cannot set volume offset.");
        return;
    L9:
        r1.setVolumeOffset(r2, r3);
    }

    public boolean isVolumeOffsetAvailable(BluetoothDevice r3) {
        BluetoothVolumeControl r2 = this.mService;
        if (r2 != null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Proxy not attached to service. Cannot get is volume offset available.");
        return false;
    L6:
        if (r3 != null) goto L10;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Device is null. Cannot get is volume offset available.");
        return false;
    L10:
        return r2.isVolumeOffsetAvailable(r3);
    }

    public void setDeviceVolume(BluetoothDevice r2, int r3, boolean r4) {
        BluetoothVolumeControl r1 = this.mService;
        if (r1 != null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Proxy not attached to service. Cannot set volume offset.");
        return;
    L6:
        if (r2 != null) goto L9;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Device is null. Cannot set volume offset.");
        return;
    L9:
        r1.setDeviceVolume(r2, r3, r4);
    }

    public List<BluetoothDevice> getConnectedDevices() {
        BluetoothVolumeControl r1 = this.mService;
        if (r1 != null) goto L7;
        return new ArrayList(0);
    L7:
        return r1.getDevicesMatchingConnectionStates(new int[]{2, 1, 3});
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getConnectionStatus(BluetoothDevice r1) {
        BluetoothVolumeControl r0 = this.mService;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getConnectionState(r1);
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean isEnabled(BluetoothDevice r2) {
        BluetoothVolumeControl r1 = this.mService;
        if (r1 == null) goto L10;
        if (r2 != null) goto L7;
        return false;
    L7:
        if (r1.getConnectionPolicy(r2) <= 0) goto L11;
        return true;
    L11:
        return false;
    L10:
        return false;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getConnectionPolicy(BluetoothDevice r1) {
        BluetoothVolumeControl r0 = this.mService;
        if (r0 == null) goto L8;
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r0.getConnectionPolicy(r1);
    L8:
        return 0;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean setEnabled(BluetoothDevice r4, boolean r5) {
        if (this.mService == null) goto L15;
        if (r4 != null) goto L7;
        return false;
    L7:
        if (DEBUG == false) goto L9;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, r4.getAnonymizedAddress() + " setEnabled: " + r5);
    L9:
        if (r5 == false) goto L14;
        if (this.mService.getConnectionPolicy(r4) < 100) goto L17;
        return false;
    L17:
        return this.mService.setConnectionPolicy(r4, 100);
    L14:
        return this.mService.setConnectionPolicy(r4, 0);
    L15:
        return false;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean isProfileReady() {
        return this.mIsProfileReady;
    }
}
