package com.android.settingslib.bluetooth;

import android.R;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothUuid;
import android.content.Context;
import android.os.ParcelUuid;
import com.GlobalProxyLancet;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class HeadsetProfile implements LocalBluetoothProfile {
    static final String NAME = "HEADSET";
    private static final int ORDINAL = 0;
    private static final String TAG = "HeadsetProfile";
    static final ParcelUuid[] UUIDS = null;
    private final BluetoothAdapter mBluetoothAdapter;
    private final CachedBluetoothDeviceManager mDeviceManager;
    private boolean mIsProfileReady;
    private final LocalBluetoothProfileManager mProfileManager;
    private BluetoothHeadset mService;

    /* JADX INFO: renamed from: com.android.settingslib.bluetooth.HeadsetProfile$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private final class HeadsetServiceListener implements BluetoothProfile.ServiceListener {
        final /* synthetic */ HeadsetProfile this$0;

        private HeadsetServiceListener(HeadsetProfile r1) {
            this.this$0 = r1;
        }

        /* synthetic */ HeadsetServiceListener(HeadsetProfile r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int r3, BluetoothProfile r4) {
            HeadsetProfile.access$002(this.this$0, (BluetoothHeadset) r4);
            List<BluetoothDevice> r5 = HeadsetProfile.access$000(this.this$0).getConnectedDevices();
        L4:
            if (r5.isEmpty() == true) goto L9;
            BluetoothDevice r6 = r5.remove(0);
            CachedBluetoothDevice r0 = HeadsetProfile.access$100(this.this$0).findDevice(r6);
            if (r0 != null) goto L8;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(HeadsetProfile.TAG, "HeadsetProfile found new device: " + r6);
            r0 = HeadsetProfile.access$100(this.this$0).addDevice(r6);
        L8:
            r0.onProfileStateChanged(this.this$0, 2);
            r0.refresh();
            goto L4
        L9:
            HeadsetProfile.access$202(this.this$0, true);
            HeadsetProfile.access$300(this.this$0).callServiceConnectedListeners();
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int r1) {
            HeadsetProfile.access$300(this.this$0).callServiceDisconnectedListeners();
            HeadsetProfile.access$202(this.this$0, false);
        }
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean accessProfileEnabled() {
        return true;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getDrawableResource(BluetoothClass r1) {
        return R.drawable.ic_menu_blocked_user;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getOrdinal() {
        return 0;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getProfileId() {
        return 1;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean isAutoConnectable() {
        return true;
    }

    public String toString() {
        return NAME;
    }

    static /* synthetic */ BluetoothHeadset access$000(HeadsetProfile r0) {
        return r0.mService;
    }

    static /* synthetic */ BluetoothHeadset access$002(HeadsetProfile r0, BluetoothHeadset r1) {
        r0.mService = r1;
        return r1;
    }

    static /* synthetic */ CachedBluetoothDeviceManager access$100(HeadsetProfile r0) {
        return r0.mDeviceManager;
    }

    static /* synthetic */ boolean access$202(HeadsetProfile r0, boolean r1) {
        r0.mIsProfileReady = r1;
        return r1;
    }

    static /* synthetic */ LocalBluetoothProfileManager access$300(HeadsetProfile r0) {
        return r0.mProfileManager;
    }

    static {
        UUIDS = new ParcelUuid[]{BluetoothUuid.HSP, BluetoothUuid.HFP};
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean isProfileReady() {
        return this.mIsProfileReady;
    }

    HeadsetProfile(Context r2, CachedBluetoothDeviceManager r3, LocalBluetoothProfileManager r4) {
        this.mDeviceManager = r3;
        this.mProfileManager = r4;
        BluetoothAdapter r5 = BluetoothAdapter.getDefaultAdapter();
        this.mBluetoothAdapter = r5;
        r5.getProfileProxy(r2, new HeadsetServiceListener(this, null), 1);
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getConnectionStatus(BluetoothDevice r1) {
        BluetoothHeadset r0 = this.mService;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getConnectionState(r1);
    }

    public boolean setActiveDevice(BluetoothDevice r2) {
        BluetoothAdapter r1 = this.mBluetoothAdapter;
        if (r1 != null) goto L7;
        return false;
    L7:
        if (r2 != null) goto L10;
        return r1.removeActiveDevice(1);
    L10:
        return r1.setActiveDevice(r2, 1);
    }

    public BluetoothDevice getActiveDevice() {
        BluetoothAdapter r2 = this.mBluetoothAdapter;
        if (r2 != null) goto L5;
        return null;
    L5:
        List r3 = r2.getActiveDevices(1);
        if (r3.size() > 0) goto L8;
        return null;
    L8:
        return (BluetoothDevice) r3.get(0);
    }

    public int getAudioState(BluetoothDevice r1) {
        BluetoothHeadset r0 = this.mService;
        if (r0 != null) goto L7;
        return 10;
    L7:
        return r0.getAudioState(r1);
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean isEnabled(BluetoothDevice r2) {
        BluetoothHeadset r1 = this.mService;
        if (r1 != null) goto L6;
        return false;
    L6:
        if (r1.getConnectionPolicy(r2) <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getConnectionPolicy(BluetoothDevice r1) {
        BluetoothHeadset r0 = this.mService;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getConnectionPolicy(r1);
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean setEnabled(BluetoothDevice r3, boolean r4) {
        BluetoothHeadset r0 = this.mService;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r4 == false) goto L10;
        if (r0.getConnectionPolicy(r3) < 100) goto L12;
        return false;
    L12:
        return this.mService.setConnectionPolicy(r3, 100);
    L10:
        return r0.setConnectionPolicy(r3, 0);
    }

    public List<BluetoothDevice> getConnectedDevices() {
        BluetoothHeadset r1 = this.mService;
        if (r1 != null) goto L7;
        return new ArrayList(0);
    L7:
        return r1.getDevicesMatchingConnectionStates(new int[]{2, 1, 3});
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getNameResource(BluetoothDevice r1) {
        return com.android.settingslib.R.string.bluetooth_profile_headset;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getSummaryResourceForDevice(BluetoothDevice r1) {
        int r0 = getConnectionStatus(r1);
        if (r0 == 0) goto L11;
        if (r0 == 2) goto L9;
        return BluetoothUtils.getConnectionStateSummary(r0);
    L9:
        return com.android.settingslib.R.string.bluetooth_headset_profile_summary_connected;
    L11:
        return com.android.settingslib.R.string.bluetooth_headset_profile_summary_use_for;
    }

    protected void finalize() {
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "finalize()");
        if (this.mService == null) goto L11;
        BluetoothAdapter.getDefaultAdapter().closeProfileProxy(1, this.mService);     // Catch: Throwable -> L6
        this.mService = null;     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Error cleaning up HID proxy", th);
        return;
    }
}
