package com.android.settingslib.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothLeAudio;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import com.GlobalProxyLancet;
import com.android.settingslib.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LeAudioProfile implements LocalBluetoothProfile {
    private static boolean DEBUG = true;
    static final String NAME = "LE_AUDIO";
    private static final int ORDINAL = 1;
    private static final String TAG = "LeAudioProfile";
    private final BluetoothAdapter mBluetoothAdapter;
    private Context mContext;
    private final CachedBluetoothDeviceManager mDeviceManager;
    private boolean mIsProfileReady;
    private final LocalBluetoothProfileManager mProfileManager;
    private BluetoothLeAudio mService;

    /* JADX INFO: renamed from: com.android.settingslib.bluetooth.LeAudioProfile$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private final class LeAudioServiceListener implements BluetoothProfile.ServiceListener {
        final /* synthetic */ LeAudioProfile this$0;

        private LeAudioServiceListener(LeAudioProfile r1) {
            this.this$0 = r1;
        }

        /* synthetic */ LeAudioServiceListener(LeAudioProfile r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int r4, BluetoothProfile r5) {
            if (LeAudioProfile.access$000() == false) goto L5;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(LeAudioProfile.TAG, "Bluetooth service connected");
        L5:
            LeAudioProfile.access$102(this.this$0, (BluetoothLeAudio) r5);
            List<BluetoothDevice> r6 = LeAudioProfile.access$100(this.this$0).getConnectedDevices();
        L7:
            if (r6.isEmpty() == true) goto L15;
            BluetoothDevice r7 = r6.remove(0);
            CachedBluetoothDevice r1 = LeAudioProfile.access$200(this.this$0).findDevice(r7);
            if (r1 != null) goto L14;
            if (LeAudioProfile.access$000() == false) goto L13;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(LeAudioProfile.TAG, "LeAudioProfile found new device: " + r7);
        L13:
            r1 = LeAudioProfile.access$200(this.this$0).addDevice(r7);
        L14:
            r1.onProfileStateChanged(this.this$0, 2);
            r1.refresh();
            goto L7
        L15:
            LeAudioProfile.access$200(this.this$0).updateHearingAidsDevices();
            LeAudioProfile.access$300(this.this$0).callServiceConnectedListeners();
            LeAudioProfile.access$402(this.this$0, true);
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int r2) {
            if (LeAudioProfile.access$000() == false) goto L5;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(LeAudioProfile.TAG, "Bluetooth service disconnected");
        L5:
            LeAudioProfile.access$300(this.this$0).callServiceDisconnectedListeners();
            LeAudioProfile.access$402(this.this$0, false);
        }
    }

    static {
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean accessProfileEnabled() {
        return true;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getOrdinal() {
        return 1;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getProfileId() {
        return 22;
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

    static /* synthetic */ BluetoothLeAudio access$100(LeAudioProfile r0) {
        return r0.mService;
    }

    static /* synthetic */ BluetoothLeAudio access$102(LeAudioProfile r0, BluetoothLeAudio r1) {
        r0.mService = r1;
        return r1;
    }

    static /* synthetic */ CachedBluetoothDeviceManager access$200(LeAudioProfile r0) {
        return r0.mDeviceManager;
    }

    static /* synthetic */ LocalBluetoothProfileManager access$300(LeAudioProfile r0) {
        return r0.mProfileManager;
    }

    static /* synthetic */ boolean access$402(LeAudioProfile r0, boolean r1) {
        r0.mIsProfileReady = r1;
        return r1;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean isProfileReady() {
        return this.mIsProfileReady;
    }

    LeAudioProfile(Context r2, CachedBluetoothDeviceManager r3, LocalBluetoothProfileManager r4) {
        this.mContext = r2;
        this.mDeviceManager = r3;
        this.mProfileManager = r4;
        BluetoothAdapter r5 = BluetoothAdapter.getDefaultAdapter();
        this.mBluetoothAdapter = r5;
        r5.getProfileProxy(r2, new LeAudioServiceListener(this, null), 22);
    }

    public List<BluetoothDevice> getConnectedDevices() {
        return getDevicesByStates(new int[]{2, 1, 3});
    }

    public List<BluetoothDevice> getConnectableDevices() {
        return getDevicesByStates(new int[]{0, 2, 1, 3});
    }

    private List<BluetoothDevice> getDevicesByStates(int[] r1) {
        BluetoothLeAudio r0 = this.mService;
        if (r0 != null) goto L7;
        return new ArrayList(0);
    L7:
        return r0.getDevicesMatchingConnectionStates(r1);
    }

    public boolean connect(BluetoothDevice r2) {
        BluetoothLeAudio r1 = this.mService;
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.setConnectionPolicy(r2, 100);
    }

    public boolean disconnect(BluetoothDevice r2) {
        BluetoothLeAudio r1 = this.mService;
        if (r1 != null) goto L6;
        return false;
    L6:
        return r1.setConnectionPolicy(r2, 0);
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getConnectionStatus(BluetoothDevice r1) {
        BluetoothLeAudio r0 = this.mService;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getConnectionState(r1);
    }

    public int getGroupId(BluetoothDevice r1) {
        BluetoothLeAudio r0 = this.mService;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getGroupId(r1);
    }

    public boolean setActiveDevice(BluetoothDevice r2) {
        BluetoothAdapter r1 = this.mBluetoothAdapter;
        if (r1 != null) goto L7;
        return false;
    L7:
        if (r2 != null) goto L10;
        return r1.removeActiveDevice(2);
    L10:
        return r1.setActiveDevice(r2, 2);
    }

    public List<BluetoothDevice> getActiveDevices() {
        BluetoothAdapter r1 = this.mBluetoothAdapter;
        if (r1 != null) goto L7;
        return new ArrayList();
    L7:
        return r1.getActiveDevices(22);
    }

    public BluetoothDevice getConnectedGroupLeadDevice(int r3) {
        if (DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "getConnectedGroupLeadDevice");
    L5:
        BluetoothLeAudio r2 = this.mService;
        if (r2 != null) goto L10;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "No service.");
        return null;
    L10:
        return r2.getConnectedGroupLeadDevice(r3);
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean isEnabled(BluetoothDevice r2) {
        BluetoothLeAudio r1 = this.mService;
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
        BluetoothLeAudio r0 = this.mService;
        if (r0 == null) goto L8;
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r0.getConnectionPolicy(r1);
    L8:
        return 0;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean setEnabled(BluetoothDevice r3, boolean r4) {
        BluetoothLeAudio r0 = this.mService;
        if (r0 == null) goto L12;
        if (r3 == null) goto L15;
        if (r4 == false) goto L11;
        if (r0.getConnectionPolicy(r3) < 100) goto L14;
        return false;
    L14:
        return this.mService.setConnectionPolicy(r3, 100);
    L11:
        return r0.setConnectionPolicy(r3, 0);
    L15:
        return false;
    L12:
        return false;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getNameResource(BluetoothDevice r1) {
        return R.string.bluetooth_profile_le_audio;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getSummaryResourceForDevice(BluetoothDevice r1) {
        int r0 = getConnectionStatus(r1);
        if (r0 == 0) goto L11;
        if (r0 == 2) goto L9;
        return BluetoothUtils.getConnectionStateSummary(r0);
    L9:
        return R.string.bluetooth_le_audio_profile_summary_connected;
    L11:
        return R.string.bluetooth_le_audio_profile_summary_use_for;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getDrawableResource(BluetoothClass r1) {
        if (r1 != null) goto L5;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "No btClass.");
        return R.drawable.ic_bt_le_audio_speakers;
    L5:
        int r0 = r1.getDeviceClass();
        if (r0 == 1024) goto L16;
        if (r0 == 1028) goto L16;
        if (r0 == 1040) goto L16;
        if (r0 == 1048) goto L16;
        return R.drawable.ic_bt_le_audio_speakers;
    L16:
        return R.drawable.ic_bt_le_audio;
    }

    public int getAudioLocation(BluetoothDevice r1) {
        BluetoothLeAudio r0 = this.mService;
        if (r0 == null) goto L8;
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r0.getAudioLocation(r1);
    L8:
        return 0;
    }

    protected void finalize() {
        if (DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "finalize()");
    L6:
        if (this.mService == null) goto L14;
        BluetoothAdapter.getDefaultAdapter().closeProfileProxy(22, this.mService);     // Catch: Throwable -> L9
        this.mService = null;     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Error cleaning up LeAudio proxy", th);
        return;
    }
}
