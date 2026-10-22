package com.android.settingslib.bluetooth;

import android.R;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothPbapClient;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothUuid;
import android.content.Context;
import android.os.ParcelUuid;
import com.GlobalProxyLancet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class PbapClientProfile implements LocalBluetoothProfile {
    static final String NAME = "PbapClient";
    private static final int ORDINAL = 6;
    static final ParcelUuid[] SRC_UUIDS = null;
    private static final String TAG = "PbapClientProfile";
    private final CachedBluetoothDeviceManager mDeviceManager;
    private boolean mIsProfileReady;
    private final LocalBluetoothProfileManager mProfileManager;
    private BluetoothPbapClient mService;

    /* JADX INFO: renamed from: com.android.settingslib.bluetooth.PbapClientProfile$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private final class PbapClientServiceListener implements BluetoothProfile.ServiceListener {
        final /* synthetic */ PbapClientProfile this$0;

        private PbapClientServiceListener(PbapClientProfile r1) {
            this.this$0 = r1;
        }

        /* synthetic */ PbapClientServiceListener(PbapClientProfile r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int r3, BluetoothProfile r4) {
            PbapClientProfile.access$002(this.this$0, (BluetoothPbapClient) r4);
            List r5 = PbapClientProfile.access$000(this.this$0).getConnectedDevices();
        L4:
            if (r5.isEmpty() == true) goto L9;
            BluetoothDevice r6 = (BluetoothDevice) r5.remove(0);
            CachedBluetoothDevice r0 = PbapClientProfile.access$100(this.this$0).findDevice(r6);
            if (r0 != null) goto L8;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(PbapClientProfile.TAG, "PbapClientProfile found new device: " + r6);
            r0 = PbapClientProfile.access$100(this.this$0).addDevice(r6);
        L8:
            r0.onProfileStateChanged(this.this$0, 2);
            r0.refresh();
            goto L4
        L9:
            PbapClientProfile.access$202(this.this$0, true);
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int r1) {
            PbapClientProfile.access$202(this.this$0, false);
        }
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean accessProfileEnabled() {
        return true;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getDrawableResource(BluetoothClass r1) {
        return R.drawable.pointer_alias_large_icon;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getOrdinal() {
        return 6;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getProfileId() {
        return 17;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean isAutoConnectable() {
        return true;
    }

    public String toString() {
        return NAME;
    }

    static /* synthetic */ BluetoothPbapClient access$000(PbapClientProfile r0) {
        return r0.mService;
    }

    static /* synthetic */ BluetoothPbapClient access$002(PbapClientProfile r0, BluetoothPbapClient r1) {
        r0.mService = r1;
        return r1;
    }

    static /* synthetic */ CachedBluetoothDeviceManager access$100(PbapClientProfile r0) {
        return r0.mDeviceManager;
    }

    static /* synthetic */ boolean access$202(PbapClientProfile r0, boolean r1) {
        r0.mIsProfileReady = r1;
        return r1;
    }

    static {
        SRC_UUIDS = new ParcelUuid[]{BluetoothUuid.PBAP_PSE};
    }

    private void refreshProfiles() {
        Iterator<CachedBluetoothDevice> r1 = this.mDeviceManager.getCachedDevicesCopy().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onUuidChanged();
        goto L4
    }

    public boolean pbapClientExists() {
        if (this.mService == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean isProfileReady() {
        return this.mIsProfileReady;
    }

    PbapClientProfile(Context r2, CachedBluetoothDeviceManager r3, LocalBluetoothProfileManager r4) {
        this.mDeviceManager = r3;
        this.mProfileManager = r4;
        BluetoothAdapter.getDefaultAdapter().getProfileProxy(r2, new PbapClientServiceListener(this, null), 17);
    }

    public List<BluetoothDevice> getConnectedDevices() {
        BluetoothPbapClient r1 = this.mService;
        if (r1 != null) goto L7;
        return new ArrayList(0);
    L7:
        return r1.getDevicesMatchingConnectionStates(new int[]{2, 1, 3});
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getConnectionStatus(BluetoothDevice r1) {
        BluetoothPbapClient r0 = this.mService;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getConnectionState(r1);
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean isEnabled(BluetoothDevice r2) {
        BluetoothPbapClient r1 = this.mService;
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
        BluetoothPbapClient r0 = this.mService;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getConnectionPolicy(r1);
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean setEnabled(BluetoothDevice r3, boolean r4) {
        BluetoothPbapClient r0 = this.mService;
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

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getNameResource(BluetoothDevice r1) {
        return com.android.settingslib.R.string.bluetooth_profile_pbap;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getSummaryResourceForDevice(BluetoothDevice r1) {
        return com.android.settingslib.R.string.bluetooth_profile_pbap_summary;
    }

    protected void finalize() {
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "finalize()");
        if (this.mService == null) goto L11;
        BluetoothAdapter.getDefaultAdapter().closeProfileProxy(17, this.mService);     // Catch: Throwable -> L6
        this.mService = null;     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Error cleaning up PBAP Client proxy", th);
        return;
    }
}
