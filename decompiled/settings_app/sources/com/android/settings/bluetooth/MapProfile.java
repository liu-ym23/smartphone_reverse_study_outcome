package com.android.settings.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothMap;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothUuid;
import android.content.Context;
import android.os.ParcelUuid;
import com.android.settings.R;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class MapProfile implements LocalBluetoothProfile {
    static final String NAME = "MAP";
    private static final String TAG = "MapProfile";
    static final ParcelUuid[] UUIDS = null;
    private final CachedBluetoothDeviceManager mDeviceManager;
    private boolean mIsProfileReady;
    private final LocalBluetoothAdapter mLocalAdapter;
    private final LocalBluetoothProfileManager mProfileManager;
    private BluetoothMap mService;

    /* JADX INFO: renamed from: com.android.settings.bluetooth.MapProfile$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private final class MapServiceListener implements BluetoothProfile.ServiceListener {
        final /* synthetic */ MapProfile this$0;

        private MapServiceListener(MapProfile r1) {
            this.this$0 = r1;
        }

        /* synthetic */ MapServiceListener(MapProfile r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int r5, BluetoothProfile r6) {
            OLog.d(MapProfile.TAG, "Bluetooth service connected");
            MapProfile.access$002(this.this$0, (BluetoothMap) r6);
            List r7 = new ArrayList();
            r7 = MapProfile.access$000(this.this$0).getConnectedDevices();     // Catch: Exception -> L5
        L8:
            if (r7.isEmpty() == true) goto L13;
            BluetoothDevice r8 = (BluetoothDevice) r7.remove(0);
            CachedBluetoothDevice r1 = MapProfile.access$100(this.this$0).findDevice(r8);
            if (r1 != null) goto L12;
            OLog.w(MapProfile.TAG, "MapProfile found new device: " + r8);
            r1 = MapProfile.access$100(this.this$0).addDevice(MapProfile.access$200(this.this$0), MapProfile.access$300(this.this$0), r8);
        L12:
            r1.onProfileStateChanged(this.this$0, 2);
            r1.refresh();
            goto L8
        L13:
            MapProfile.access$300(this.this$0).callServiceConnectedListeners();
            MapProfile.access$402(this.this$0, true);
            return;
        L5:
            e = move-exception;
            OLog.e(MapProfile.TAG, "onServiceConnected", e);
            goto L8
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int r2) {
            OLog.d(MapProfile.TAG, "Bluetooth service disconnected");
            MapProfile.access$300(this.this$0).callServiceDisconnectedListeners();
            MapProfile.access$402(this.this$0, false);
        }
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getDrawableResource(BluetoothClass r1) {
        return R.drawable.settings_oic_phone_portrait_fill;
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getNameResource(BluetoothDevice r1) {
        return R.string.bluetooth_profile_map;
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getOrdinal() {
        return 9;
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

    static /* synthetic */ BluetoothMap access$000(MapProfile r0) {
        return r0.mService;
    }

    static /* synthetic */ BluetoothMap access$002(MapProfile r0, BluetoothMap r1) {
        r0.mService = r1;
        return r1;
    }

    static /* synthetic */ CachedBluetoothDeviceManager access$100(MapProfile r0) {
        return r0.mDeviceManager;
    }

    static /* synthetic */ LocalBluetoothAdapter access$200(MapProfile r0) {
        return r0.mLocalAdapter;
    }

    static /* synthetic */ LocalBluetoothProfileManager access$300(MapProfile r0) {
        return r0.mProfileManager;
    }

    static /* synthetic */ boolean access$402(MapProfile r0, boolean r1) {
        r0.mIsProfileReady = r1;
        return r1;
    }

    static {
        UUIDS = new ParcelUuid[]{BluetoothUuid.MAP, BluetoothUuid.MNS, BluetoothUuid.MAS};
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public boolean isProfileReady() {
        OLog.d(TAG, "isProfileReady(): " + this.mIsProfileReady);
        return this.mIsProfileReady;
    }

    MapProfile(Context r1, LocalBluetoothAdapter r2, CachedBluetoothDeviceManager r3, LocalBluetoothProfileManager r4) {
        this.mLocalAdapter = r2;
        this.mDeviceManager = r3;
        this.mProfileManager = r4;
        r2.getProfileProxy(r1, new MapServiceListener(this, null), 9);
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public boolean connect(BluetoothDevice r1) {
        OLog.d(TAG, "connect() - should not get called");
        return true;
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public boolean disconnect(BluetoothDevice r4) {
        BluetoothMap r0 = this.mService;
        if (r0 != null) goto L5;
        return false;
    L5:
        List r1 = r0.getConnectedDevices();
        if (r1.isEmpty() == false) goto L8;
    L14:
        return false;
    L8:
        if (((BluetoothDevice) r1.get(0)).equals(r4) == false) goto L14;
        if (this.mService.getPriority(r4) <= 100) goto L13;
        this.mService.setPriority(r4, 100);
    L13:
        return this.mService.disconnect(r4);
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getConnectionStatus(BluetoothDevice r5) {
        BluetoothMap r0 = this.mService;
        if (r0 != null) goto L5;
        return 0;
    L5:
        List r1 = r0.getConnectedDevices();
        OLog.d(TAG, "getConnectionStatus: status is: " + this.mService.getConnectionState(r5));
        if (r1.isEmpty() == false) goto L8;
        return 0;
    L8:
        if (((BluetoothDevice) r1.get(0)).equals(r5) == true) goto L10;
        return 0;
    L10:
        return this.mService.getConnectionState(r5);
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public boolean isPreferred(BluetoothDevice r2) {
        BluetoothMap r1 = this.mService;
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
        BluetoothMap r0 = this.mService;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getPriority(r1);
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public void setPreferred(BluetoothDevice r2, boolean r3) {
        BluetoothMap r0 = this.mService;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3 == true) goto L7;
        r0.setPriority(r2, 0);
        return;
    L7:
        if (r0.getPriority(r2) >= 100) goto L11;
        this.mService.setPriority(r2, 100);
        return;
    }

    public List<BluetoothDevice> getConnectedDevices() {
        BluetoothMap r1 = this.mService;
        if (r1 != null) goto L7;
        return new ArrayList(0);
    L7:
        return r1.getDevicesMatchingConnectionStates(new int[]{2, 1, 3});
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getSummaryResourceForDevice(BluetoothDevice r1) {
        int r0 = getConnectionStatus(r1);
        if (r0 != 0) goto L5;
        return R.string.bluetooth_map_profile_summary_use_for;
    L5:
        if (r0 != 2) goto L7;
        return R.string.bluetooth_map_profile_summary_connected;
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
        BluetoothAdapter.getDefaultAdapter().closeProfileProxy(9, this.mService);     // Catch: Throwable -> L7
        this.mService = null;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        OLog.w(TAG, "Error cleaning up MAP proxy", th);     // Catch: Throwable -> L14
        goto L20
    }
}
