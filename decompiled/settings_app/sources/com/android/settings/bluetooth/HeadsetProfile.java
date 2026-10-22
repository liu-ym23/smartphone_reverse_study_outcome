package com.android.settings.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothUuid;
import android.content.Context;
import android.os.ParcelUuid;
import com.android.settings.AdaptConstants;
import com.android.settings.R;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class HeadsetProfile implements LocalBluetoothProfile {
    static final String NAME = "HEADSET";
    private static final int ORDINAL = 0;
    private static final String TAG = "HeadsetProfile";
    static final ParcelUuid[] UUIDS = null;
    private final CachedBluetoothDeviceManager mDeviceManager;
    private boolean mIsProfileReady;
    private final LocalBluetoothAdapter mLocalAdapter;
    private Object mLock;
    private final LocalBluetoothProfileManager mProfileManager;
    private BluetoothHeadset mService;

    /* JADX INFO: renamed from: com.android.settings.bluetooth.HeadsetProfile$1, reason: invalid class name */
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
        public void onServiceConnected(int r6, BluetoothProfile r7) {
            OLog.d(HeadsetProfile.TAG, "Bluetooth service connected");
            Object r8 = HeadsetProfile.access$000(this.this$0);
            monitor-enter(r8);
            HeadsetProfile.access$102(this.this$0, (BluetoothHeadset) r7);     // Catch: Throwable -> L19
            if (HeadsetProfile.access$100(this.this$0) != null) goto L9;
            HeadsetProfile.access$202(this.this$0, false);     // Catch: Throwable -> L19
            monitor-exit(r8);     // Catch: Throwable -> L19
            return;
        L9:
            List<BluetoothDevice> r9 = HeadsetProfile.access$100(this.this$0).getConnectedDevices();     // Catch: Throwable -> L19
        L11:
            if (r9.isEmpty() == true) goto L16;
            BluetoothDevice r1 = r9.remove(0);     // Catch: Throwable -> L19
            CachedBluetoothDevice r2 = HeadsetProfile.access$300(this.this$0).findDevice(r1);     // Catch: Throwable -> L19
            if (r2 != null) goto L15;
            OLog.w(HeadsetProfile.TAG, "HeadsetProfile found new device: " + r1);     // Catch: Throwable -> L19
            r2 = HeadsetProfile.access$300(this.this$0).addDevice(HeadsetProfile.access$400(this.this$0), HeadsetProfile.access$500(this.this$0), r1);     // Catch: Throwable -> L19
        L15:
            r2.onProfileStateChanged(this.this$0, 2);     // Catch: Throwable -> L19
            r2.refresh();     // Catch: Throwable -> L19
            goto L11
        L16:
            monitor-exit(r8);     // Catch: Throwable -> L19
            HeadsetProfile.access$500(this.this$0).callServiceConnectedListeners();
            HeadsetProfile.access$202(this.this$0, true);
            return;
        L19:
            th = move-exception;
            throw th;
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int r2) {
            OLog.d(HeadsetProfile.TAG, "Bluetooth service disconnected");
            HeadsetProfile.access$500(this.this$0).callServiceDisconnectedListeners();
            HeadsetProfile.access$202(this.this$0, false);
        }
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getDrawableResource(BluetoothClass r1) {
        return R.drawable.settings_oicon_selector_ic_bt_headphones_a2dp;
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getNameResource(BluetoothDevice r1) {
        return R.string.bluetooth_profile_headset;
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getOrdinal() {
        return 0;
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public boolean isAutoConnectable() {
        return true;
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public boolean isConnectable() {
        return true;
    }

    public String toString() {
        return NAME;
    }

    static /* synthetic */ Object access$000(HeadsetProfile r0) {
        return r0.mLock;
    }

    static /* synthetic */ BluetoothHeadset access$100(HeadsetProfile r0) {
        return r0.mService;
    }

    static /* synthetic */ BluetoothHeadset access$102(HeadsetProfile r0, BluetoothHeadset r1) {
        r0.mService = r1;
        return r1;
    }

    static /* synthetic */ boolean access$202(HeadsetProfile r0, boolean r1) {
        r0.mIsProfileReady = r1;
        return r1;
    }

    static /* synthetic */ CachedBluetoothDeviceManager access$300(HeadsetProfile r0) {
        return r0.mDeviceManager;
    }

    static /* synthetic */ LocalBluetoothAdapter access$400(HeadsetProfile r0) {
        return r0.mLocalAdapter;
    }

    static /* synthetic */ LocalBluetoothProfileManager access$500(HeadsetProfile r0) {
        return r0.mProfileManager;
    }

    static {
        UUIDS = new ParcelUuid[]{BluetoothUuid.HSP, AdaptConstants.HFP};
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public boolean isProfileReady() {
        return this.mIsProfileReady;
    }

    HeadsetProfile(Context r2, LocalBluetoothAdapter r3, CachedBluetoothDeviceManager r4, LocalBluetoothProfileManager r5) {
        this.mLock = new Object();
        this.mLocalAdapter = r3;
        this.mDeviceManager = r4;
        this.mProfileManager = r5;
        r3.getProfileProxy(r2, new HeadsetServiceListener(this, null), 1);
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public boolean connect(BluetoothDevice r1) {
        BluetoothHeadset r0 = this.mService;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.connect(r1);
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public boolean disconnect(BluetoothDevice r4) {
        BluetoothHeadset r0 = this.mService;
        if (r0 != null) goto L5;
        return false;
    L5:
        List<BluetoothDevice> r1 = r0.getConnectedDevices();
        if (r1.isEmpty() == false) goto L8;
    L14:
        return false;
    L8:
        if (r1.get(0).equals(r4) == false) goto L14;
        if (this.mService.getConnectionPolicy(r4) <= 100) goto L13;
        this.mService.setConnectionPolicy(r4, 100);
    L13:
        return this.mService.disconnect(r4);
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getConnectionStatus(BluetoothDevice r1) {
        BluetoothHeadset r0 = this.mService;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getConnectionState(r1);
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public boolean isPreferred(BluetoothDevice r2) {
        BluetoothHeadset r1 = this.mService;
        if (r1 != null) goto L6;
        return false;
    L6:
        if (r1.getPriority(r2) <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getPreferred(BluetoothDevice r1) {
        BluetoothHeadset r0 = this.mService;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getPriority(r1);
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public void setPreferred(BluetoothDevice r2, boolean r3) {
        BluetoothHeadset r0 = this.mService;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3 == true) goto L7;
        r0.setConnectionPolicy(r2, 0);
        return;
    L7:
        if (r0.getConnectionPolicy(r2) >= 100) goto L11;
        this.mService.setConnectionPolicy(r2, 100);
        return;
    }

    public List<BluetoothDevice> getConnectedDevices() {
        BluetoothHeadset r1 = this.mService;
        if (r1 != null) goto L7;
        return new ArrayList(0);
    L7:
        return r1.getDevicesMatchingConnectionStates(new int[]{2, 1, 3});
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getSummaryResourceForDevice(BluetoothDevice r1) {
        int r0 = getConnectionStatus(r1);
        if (r0 != 0) goto L5;
        return R.string.bluetooth_headset_profile_summary_use_for;
    L5:
        if (r0 != 2) goto L7;
        return R.string.bluetooth_headset_profile_summary_connected;
    L7:
        return Utils.getConnectionStateSummary(r0);
    }

    protected void finalize() {
        OLog.d(TAG, "finalize()");
        Object r0 = this.mLock;     // Catch: Throwable -> L20
        monitor-enter(r0);     // Catch: Throwable -> L20
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L6:
        if (this.mService != null) goto L31;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L17
        super.finalize();     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L31:
        BluetoothAdapter.getDefaultAdapter().closeProfileProxy(1, this.mService);     // Catch: Throwable -> L9
        this.mService = null;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        OLog.w(TAG, "Error cleaning up HID proxy", th);     // Catch: Throwable -> L17
    L20:
        th = move-exception;
        super.finalize();     // Catch: Throwable -> L23
    L25:
        throw th;
    L23:
        th = move-exception;
        th.printStackTrace();
        goto L25
    }
}
