package com.android.settings.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHidHost;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import com.android.settings.R;
import com.obric.olog.OLog;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class HidProfile implements LocalBluetoothProfile {
    static final String NAME = "HID";
    private static final int ORDINAL = 3;
    private static final String TAG = "HidProfile";
    private final CachedBluetoothDeviceManager mDeviceManager;
    private boolean mIsProfileReady;
    private final LocalBluetoothAdapter mLocalAdapter;
    private Object mLock;
    private final LocalBluetoothProfileManager mProfileManager;
    private BluetoothHidHost mService;

    /* JADX INFO: renamed from: com.android.settings.bluetooth.HidProfile$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private final class InputDeviceServiceListener implements BluetoothProfile.ServiceListener {
        final /* synthetic */ HidProfile this$0;

        private InputDeviceServiceListener(HidProfile r1) {
            this.this$0 = r1;
        }

        /* synthetic */ InputDeviceServiceListener(HidProfile r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int r6, BluetoothProfile r7) {
            OLog.d(HidProfile.TAG, "Bluetooth service connected");
            Object r8 = HidProfile.access$000(this.this$0);
            monitor-enter(r8);
            HidProfile.access$102(this.this$0, (BluetoothHidHost) r7);     // Catch: Throwable -> L19
            if (HidProfile.access$100(this.this$0) != null) goto L9;
            HidProfile.access$202(this.this$0, false);     // Catch: Throwable -> L19
            monitor-exit(r8);     // Catch: Throwable -> L19
            return;
        L9:
            List r9 = HidProfile.access$100(this.this$0).getConnectedDevices();     // Catch: Throwable -> L19
        L11:
            if (r9.isEmpty() == true) goto L16;
            BluetoothDevice r1 = (BluetoothDevice) r9.remove(0);     // Catch: Throwable -> L19
            CachedBluetoothDevice r2 = HidProfile.access$300(this.this$0).findDevice(r1);     // Catch: Throwable -> L19
            if (r2 != null) goto L15;
            OLog.w(HidProfile.TAG, "HidProfile found new device: " + r1);     // Catch: Throwable -> L19
            r2 = HidProfile.access$300(this.this$0).addDevice(HidProfile.access$400(this.this$0), HidProfile.access$500(this.this$0), r1);     // Catch: Throwable -> L19
        L15:
            r2.onProfileStateChanged(this.this$0, 2);     // Catch: Throwable -> L19
            r2.refresh();     // Catch: Throwable -> L19
            goto L11
        L16:
            HidProfile.access$202(this.this$0, true);     // Catch: Throwable -> L19
            monitor-exit(r8);     // Catch: Throwable -> L19
            return;
        L19:
            th = move-exception;
            throw th;
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int r2) {
            OLog.d(HidProfile.TAG, "Bluetooth service disconnected");
            HidProfile.access$202(this.this$0, false);
        }
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getNameResource(BluetoothDevice r1) {
        return R.string.bluetooth_profile_hid;
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getOrdinal() {
        return 3;
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

    static /* synthetic */ Object access$000(HidProfile r0) {
        return r0.mLock;
    }

    static /* synthetic */ BluetoothHidHost access$100(HidProfile r0) {
        return r0.mService;
    }

    static /* synthetic */ BluetoothHidHost access$102(HidProfile r0, BluetoothHidHost r1) {
        r0.mService = r1;
        return r1;
    }

    static /* synthetic */ boolean access$202(HidProfile r0, boolean r1) {
        r0.mIsProfileReady = r1;
        return r1;
    }

    static /* synthetic */ CachedBluetoothDeviceManager access$300(HidProfile r0) {
        return r0.mDeviceManager;
    }

    static /* synthetic */ LocalBluetoothAdapter access$400(HidProfile r0) {
        return r0.mLocalAdapter;
    }

    static /* synthetic */ LocalBluetoothProfileManager access$500(HidProfile r0) {
        return r0.mProfileManager;
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public boolean isProfileReady() {
        return this.mIsProfileReady;
    }

    HidProfile(Context r2, LocalBluetoothAdapter r3, CachedBluetoothDeviceManager r4, LocalBluetoothProfileManager r5) {
        this.mLock = new Object();
        this.mLocalAdapter = r3;
        this.mDeviceManager = r4;
        this.mProfileManager = r5;
        r3.getProfileProxy(r2, new InputDeviceServiceListener(this, null), 4);
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public boolean connect(BluetoothDevice r1) {
        BluetoothHidHost r0 = this.mService;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.connect(r1);
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public boolean disconnect(BluetoothDevice r1) {
        BluetoothHidHost r0 = this.mService;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.disconnect(r1);
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getConnectionStatus(BluetoothDevice r1) {
        BluetoothHidHost r0 = this.mService;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getConnectionState(r1);
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public boolean isPreferred(BluetoothDevice r2) {
        BluetoothHidHost r1 = this.mService;
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
        BluetoothHidHost r0 = this.mService;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getPriority(r1);
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public void setPreferred(BluetoothDevice r2, boolean r3) {
        BluetoothHidHost r0 = this.mService;
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

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getSummaryResourceForDevice(BluetoothDevice r1) {
        int r0 = getConnectionStatus(r1);
        if (r0 != 0) goto L5;
        return R.string.bluetooth_hid_profile_summary_use_for;
    L5:
        if (r0 != 2) goto L7;
        return R.string.bluetooth_hid_profile_summary_connected;
    L7:
        return Utils.getConnectionStateSummary(r0);
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfile
    public int getDrawableResource(BluetoothClass r1) {
        if (r1 != null) goto L6;
        return R.drawable.settings_oicon_selector_ic_bt_unknown;
    L6:
        return getHidClassDrawable(r1);
    }

    static int getHidClassDrawable(BluetoothClass r1) {
        int r2 = r1.getDeviceClass();
        if (r2 != 1344) goto L5;
        return R.drawable.ic_bt_keyboard_hid;
    L5:
        if (r2 != 1408) goto L7;
        return R.drawable.ic_bt_pointing_hid;
    L7:
        if (r2 == 1472) goto L14;
        return R.drawable.settings_oicon_selector_ic_bt_unknown;
    L14:
        return R.drawable.ic_bt_keyboard_hid;
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
        BluetoothAdapter.getDefaultAdapter().closeProfileProxy(4, this.mService);     // Catch: Throwable -> L9
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
