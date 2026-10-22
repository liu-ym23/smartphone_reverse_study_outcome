package com.android.settingslib.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothCsipSetCoordinator;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.os.ParcelUuid;
import com.GlobalProxyLancet;
import com.android.settingslib.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CsipSetCoordinatorProfile implements LocalBluetoothProfile {
    static final String NAME = "CSIP Set Coordinator";
    private static final int ORDINAL = 1;
    private static final String TAG = "CsipSetCoordinatorProfile";
    private static final boolean VDBG = true;
    private Context mContext;
    private final CachedBluetoothDeviceManager mDeviceManager;
    private boolean mIsProfileReady;
    private final LocalBluetoothProfileManager mProfileManager;
    private BluetoothCsipSetCoordinator mService;

    /* JADX INFO: renamed from: com.android.settingslib.bluetooth.CsipSetCoordinatorProfile$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private final class CoordinatedSetServiceListener implements BluetoothProfile.ServiceListener {
        final /* synthetic */ CsipSetCoordinatorProfile this$0;

        private CoordinatedSetServiceListener(CsipSetCoordinatorProfile r1) {
            this.this$0 = r1;
        }

        /* synthetic */ CoordinatedSetServiceListener(CsipSetCoordinatorProfile r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int r4, BluetoothProfile r5) {
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(CsipSetCoordinatorProfile.TAG, "Bluetooth service connected");
            CsipSetCoordinatorProfile.access$002(this.this$0, (BluetoothCsipSetCoordinator) r5);
            List<BluetoothDevice> r6 = CsipSetCoordinatorProfile.access$000(this.this$0).getConnectedDevices();
        L4:
            if (r6.isEmpty() == true) goto L9;
            BluetoothDevice r7 = r6.remove(0);
            CachedBluetoothDevice r1 = CsipSetCoordinatorProfile.access$100(this.this$0).findDevice(r7);
            if (r1 != null) goto L8;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(CsipSetCoordinatorProfile.TAG, "CsipSetCoordinatorProfile found new device: " + r7);
            r1 = CsipSetCoordinatorProfile.access$100(this.this$0).addDevice(r7);
        L8:
            r1.onProfileStateChanged(this.this$0, 2);
            r1.refresh();
            goto L4
        L9:
            CsipSetCoordinatorProfile.access$100(this.this$0).updateCsipDevices();
            CsipSetCoordinatorProfile.access$200(this.this$0).callServiceConnectedListeners();
            CsipSetCoordinatorProfile.access$302(this.this$0, true);
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int r2) {
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(CsipSetCoordinatorProfile.TAG, "Bluetooth service disconnected");
            CsipSetCoordinatorProfile.access$200(this.this$0).callServiceDisconnectedListeners();
            CsipSetCoordinatorProfile.access$302(this.this$0, false);
        }
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
    public int getOrdinal() {
        return 1;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getProfileId() {
        return 25;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean isAutoConnectable() {
        return true;
    }

    public String toString() {
        return NAME;
    }

    static /* synthetic */ BluetoothCsipSetCoordinator access$000(CsipSetCoordinatorProfile r0) {
        return r0.mService;
    }

    static /* synthetic */ BluetoothCsipSetCoordinator access$002(CsipSetCoordinatorProfile r0, BluetoothCsipSetCoordinator r1) {
        r0.mService = r1;
        return r1;
    }

    static /* synthetic */ CachedBluetoothDeviceManager access$100(CsipSetCoordinatorProfile r0) {
        return r0.mDeviceManager;
    }

    static /* synthetic */ LocalBluetoothProfileManager access$200(CsipSetCoordinatorProfile r0) {
        return r0.mProfileManager;
    }

    static /* synthetic */ boolean access$302(CsipSetCoordinatorProfile r0, boolean r1) {
        r0.mIsProfileReady = r1;
        return r1;
    }

    CsipSetCoordinatorProfile(Context r2, CachedBluetoothDeviceManager r3, LocalBluetoothProfileManager r4) {
        this.mContext = r2;
        this.mDeviceManager = r3;
        this.mProfileManager = r4;
        BluetoothAdapter.getDefaultAdapter().getProfileProxy(r2, new CoordinatedSetServiceListener(this, null), 25);
    }

    public List<BluetoothDevice> getConnectedDevices() {
        BluetoothCsipSetCoordinator r1 = this.mService;
        if (r1 != null) goto L7;
        return new ArrayList(0);
    L7:
        return r1.getDevicesMatchingConnectionStates(new int[]{2, 1, 3});
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getConnectionStatus(BluetoothDevice r1) {
        BluetoothCsipSetCoordinator r0 = this.mService;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getConnectionState(r1);
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean isProfileReady() {
        return this.mIsProfileReady;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean isEnabled(BluetoothDevice r2) {
        BluetoothCsipSetCoordinator r1 = this.mService;
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
        BluetoothCsipSetCoordinator r0 = this.mService;
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
        BluetoothCsipSetCoordinator r0 = this.mService;
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
        return R.string.summary_empty;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getSummaryResourceForDevice(BluetoothDevice r1) {
        return BluetoothUtils.getConnectionStateSummary(getConnectionStatus(r1));
    }

    public Map<Integer, ParcelUuid> getGroupUuidMapByDevice(BluetoothDevice r1) {
        BluetoothCsipSetCoordinator r0 = this.mService;
        if (r0 == null) goto L8;
        if (r1 != null) goto L7;
        return null;
    L7:
        return r0.getGroupUuidMapByDevice(r1);
    L8:
        return null;
    }

    protected void finalize() {
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "finalize()");
        if (this.mService == null) goto L11;
        BluetoothAdapter.getDefaultAdapter().closeProfileProxy(25, this.mService);     // Catch: Throwable -> L6
        this.mService = null;     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Error cleaning up CSIP Set Coordinator proxy", th);
        return;
    }
}
