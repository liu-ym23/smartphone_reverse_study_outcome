package com.android.settingslib.bluetooth;

import android.R;
import android.bluetooth.BluetoothA2dpSink;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothUuid;
import android.content.Context;
import android.os.ParcelUuid;
import com.GlobalProxyLancet;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class A2dpSinkProfile implements LocalBluetoothProfile {
    static final String NAME = "A2DPSink";
    private static final int ORDINAL = 5;
    static final ParcelUuid[] SRC_UUIDS = null;
    private static final String TAG = "A2dpSinkProfile";
    private final CachedBluetoothDeviceManager mDeviceManager;
    private boolean mIsProfileReady;
    private final LocalBluetoothProfileManager mProfileManager;
    private BluetoothA2dpSink mService;

    /* JADX INFO: renamed from: com.android.settingslib.bluetooth.A2dpSinkProfile$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private final class A2dpSinkServiceListener implements BluetoothProfile.ServiceListener {
        final /* synthetic */ A2dpSinkProfile this$0;

        private A2dpSinkServiceListener(A2dpSinkProfile r1) {
            this.this$0 = r1;
        }

        /* synthetic */ A2dpSinkServiceListener(A2dpSinkProfile r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int r3, BluetoothProfile r4) {
            A2dpSinkProfile.access$002(this.this$0, (BluetoothA2dpSink) r4);
            List r5 = A2dpSinkProfile.access$000(this.this$0).getConnectedDevices();
        L4:
            if (r5.isEmpty() == true) goto L9;
            BluetoothDevice r6 = (BluetoothDevice) r5.remove(0);
            CachedBluetoothDevice r0 = A2dpSinkProfile.access$100(this.this$0).findDevice(r6);
            if (r0 != null) goto L8;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(A2dpSinkProfile.TAG, "A2dpSinkProfile found new device: " + r6);
            r0 = A2dpSinkProfile.access$100(this.this$0).addDevice(r6);
        L8:
            r0.onProfileStateChanged(this.this$0, 2);
            r0.refresh();
            goto L4
        L9:
            A2dpSinkProfile.access$202(this.this$0, true);
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int r1) {
            A2dpSinkProfile.access$202(this.this$0, false);
        }
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean accessProfileEnabled() {
        return true;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getDrawableResource(BluetoothClass r1) {
        return R.drawable.ic_menu_block;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getOrdinal() {
        return 5;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getProfileId() {
        return 11;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean isAutoConnectable() {
        return true;
    }

    public String toString() {
        return NAME;
    }

    static /* synthetic */ BluetoothA2dpSink access$000(A2dpSinkProfile r0) {
        return r0.mService;
    }

    static /* synthetic */ BluetoothA2dpSink access$002(A2dpSinkProfile r0, BluetoothA2dpSink r1) {
        r0.mService = r1;
        return r1;
    }

    static /* synthetic */ CachedBluetoothDeviceManager access$100(A2dpSinkProfile r0) {
        return r0.mDeviceManager;
    }

    static /* synthetic */ boolean access$202(A2dpSinkProfile r0, boolean r1) {
        r0.mIsProfileReady = r1;
        return r1;
    }

    static {
        SRC_UUIDS = new ParcelUuid[]{BluetoothUuid.A2DP_SOURCE, BluetoothUuid.ADV_AUDIO_DIST};
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean isProfileReady() {
        return this.mIsProfileReady;
    }

    A2dpSinkProfile(Context r2, CachedBluetoothDeviceManager r3, LocalBluetoothProfileManager r4) {
        this.mDeviceManager = r3;
        this.mProfileManager = r4;
        BluetoothAdapter.getDefaultAdapter().getProfileProxy(r2, new A2dpSinkServiceListener(this, null), 11);
    }

    public List<BluetoothDevice> getConnectedDevices() {
        BluetoothA2dpSink r1 = this.mService;
        if (r1 != null) goto L7;
        return new ArrayList(0);
    L7:
        return r1.getDevicesMatchingConnectionStates(new int[]{2, 1, 3});
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getConnectionStatus(BluetoothDevice r1) {
        BluetoothA2dpSink r0 = this.mService;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getConnectionState(r1);
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean isEnabled(BluetoothDevice r2) {
        BluetoothA2dpSink r1 = this.mService;
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
        BluetoothA2dpSink r0 = this.mService;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getConnectionPolicy(r1);
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean setEnabled(BluetoothDevice r3, boolean r4) {
        BluetoothA2dpSink r0 = this.mService;
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

    boolean isAudioPlaying() {
        BluetoothA2dpSink r0 = this.mService;
        if (r0 != null) goto L5;
        return false;
    L5:
        List r1 = r0.getConnectedDevices();
        if (r1.isEmpty() == false) goto L8;
    L11:
        return false;
    L8:
        if (this.mService.isAudioPlaying((BluetoothDevice) r1.get(0)) == false) goto L11;
        return true;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getNameResource(BluetoothDevice r1) {
        return com.android.settingslib.R.string.bluetooth_profile_a2dp;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getSummaryResourceForDevice(BluetoothDevice r1) {
        int r0 = getConnectionStatus(r1);
        if (r0 == 0) goto L11;
        if (r0 == 2) goto L9;
        return BluetoothUtils.getConnectionStateSummary(r0);
    L9:
        return com.android.settingslib.R.string.bluetooth_a2dp_profile_summary_connected;
    L11:
        return com.android.settingslib.R.string.bluetooth_a2dp_profile_summary_use_for;
    }

    protected void finalize() {
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "finalize()");
        if (this.mService == null) goto L11;
        BluetoothAdapter.getDefaultAdapter().closeProfileProxy(11, this.mService);     // Catch: Throwable -> L6
        this.mService = null;     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Error cleaning up A2DP proxy", th);
        return;
    }
}
