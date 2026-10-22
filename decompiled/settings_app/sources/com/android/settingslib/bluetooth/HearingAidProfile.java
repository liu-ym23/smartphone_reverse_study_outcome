package com.android.settingslib.bluetooth;

import android.R;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHearingAid;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import com.GlobalProxyLancet;
import com.android.settingslib.Utils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class HearingAidProfile implements LocalBluetoothProfile {
    static final String NAME = "HearingAid";
    private static final int ORDINAL = 1;
    private static final String TAG = "HearingAidProfile";
    private static boolean V = true;
    private final BluetoothAdapter mBluetoothAdapter;
    private Context mContext;
    private final CachedBluetoothDeviceManager mDeviceManager;
    private boolean mIsProfileReady;
    private final LocalBluetoothProfileManager mProfileManager;
    private BluetoothHearingAid mService;

    /* JADX INFO: renamed from: com.android.settingslib.bluetooth.HearingAidProfile$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DeviceMode {
        public static final int MODE_BINAURAL = 1;
        public static final int MODE_INVALID = -1;
        public static final int MODE_MONAURAL = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DeviceSide {
        public static final int SIDE_INVALID = -1;
        public static final int SIDE_LEFT = 0;
        public static final int SIDE_RIGHT = 1;
    }

    private final class HearingAidServiceListener implements BluetoothProfile.ServiceListener {
        final /* synthetic */ HearingAidProfile this$0;

        private HearingAidServiceListener(HearingAidProfile r1) {
            this.this$0 = r1;
        }

        /* synthetic */ HearingAidServiceListener(HearingAidProfile r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int r3, BluetoothProfile r4) {
            HearingAidProfile.access$002(this.this$0, (BluetoothHearingAid) r4);
            List<BluetoothDevice> r5 = HearingAidProfile.access$000(this.this$0).getConnectedDevices();
        L4:
            if (r5.isEmpty() == true) goto L12;
            BluetoothDevice r6 = r5.remove(0);
            CachedBluetoothDevice r0 = HearingAidProfile.access$100(this.this$0).findDevice(r6);
            if (r0 != null) goto L11;
            if (HearingAidProfile.access$200() == false) goto L10;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(HearingAidProfile.TAG, "HearingAidProfile found new device: " + r6);
        L10:
            r0 = HearingAidProfile.access$100(this.this$0).addDevice(r6);
        L11:
            r0.onProfileStateChanged(this.this$0, 2);
            r0.refresh();
            goto L4
        L12:
            HearingAidProfile.access$100(this.this$0).updateHearingAidsDevices();
            HearingAidProfile.access$302(this.this$0, true);
            HearingAidProfile.access$400(this.this$0).callServiceConnectedListeners();
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int r2) {
            HearingAidProfile.access$302(this.this$0, false);
            HearingAidProfile.access$400(this.this$0).callServiceDisconnectedListeners();
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
        return R.drawable.ic_menu_btn_add;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getOrdinal() {
        return 1;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getProfileId() {
        return 21;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean isAutoConnectable() {
        return true;
    }

    public String toString() {
        return NAME;
    }

    static /* synthetic */ BluetoothHearingAid access$000(HearingAidProfile r0) {
        return r0.mService;
    }

    static /* synthetic */ BluetoothHearingAid access$002(HearingAidProfile r0, BluetoothHearingAid r1) {
        r0.mService = r1;
        return r1;
    }

    static /* synthetic */ CachedBluetoothDeviceManager access$100(HearingAidProfile r0) {
        return r0.mDeviceManager;
    }

    static /* synthetic */ boolean access$200() {
        return V;
    }

    static /* synthetic */ boolean access$302(HearingAidProfile r0, boolean r1) {
        r0.mIsProfileReady = r1;
        return r1;
    }

    static /* synthetic */ LocalBluetoothProfileManager access$400(HearingAidProfile r0) {
        return r0.mProfileManager;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean isProfileReady() {
        return this.mIsProfileReady;
    }

    HearingAidProfile(Context r2, CachedBluetoothDeviceManager r3, LocalBluetoothProfileManager r4) {
        this.mContext = r2;
        this.mDeviceManager = r3;
        this.mProfileManager = r4;
        BluetoothAdapter r5 = BluetoothAdapter.getDefaultAdapter();
        this.mBluetoothAdapter = r5;
        r5.getProfileProxy(r2, new HearingAidServiceListener(this, null), 21);
    }

    public List<BluetoothDevice> getConnectedDevices() {
        return getDevicesByStates(new int[]{2, 1, 3});
    }

    public List<BluetoothDevice> getConnectableDevices() {
        return getDevicesByStates(new int[]{0, 2, 1, 3});
    }

    private List<BluetoothDevice> getDevicesByStates(int[] r1) {
        BluetoothHearingAid r0 = this.mService;
        if (r0 != null) goto L7;
        return new ArrayList(0);
    L7:
        return r0.getDevicesMatchingConnectionStates(r1);
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getConnectionStatus(BluetoothDevice r1) {
        BluetoothHearingAid r0 = this.mService;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getConnectionState(r1);
    }

    public boolean setActiveDevice(BluetoothDevice r2) {
        if (this.mBluetoothAdapter != null) goto L6;
        return false;
    L6:
        boolean r0 = Utils.isAudioModeOngoingCall(this.mContext);
        if (r2 != null) goto L10;
        return this.mBluetoothAdapter.removeActiveDevice(r0 ? 1 : 0);
    L10:
        return this.mBluetoothAdapter.setActiveDevice(r2, r0 ? 1 : 0);
    }

    public List<BluetoothDevice> getActiveDevices() {
        BluetoothAdapter r1 = this.mBluetoothAdapter;
        if (r1 != null) goto L7;
        return new ArrayList();
    L7:
        return r1.getActiveDevices(21);
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean isEnabled(BluetoothDevice r2) {
        BluetoothHearingAid r1 = this.mService;
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
        BluetoothHearingAid r0 = this.mService;
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
        BluetoothHearingAid r0 = this.mService;
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

    public void setVolume(int r1) {
        BluetoothHearingAid r0 = this.mService;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setVolume(r1);
    }

    public long getHiSyncId(BluetoothDevice r1) {
        BluetoothHearingAid r0 = this.mService;
        if (r0 == null) goto L8;
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r0.getHiSyncId(r1);
    L8:
        return 0;
    }

    public int getDeviceSide(BluetoothDevice r1) {
        BluetoothHearingAid r0 = this.mService;
        if (r0 != null) goto L7;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Proxy not attached to HearingAidService");
        return -1;
    L7:
        return r0.getDeviceSide(r1);
    }

    public int getDeviceMode(BluetoothDevice r1) {
        BluetoothHearingAid r0 = this.mService;
        if (r0 != null) goto L7;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Proxy not attached to HearingAidService");
        return -1;
    L7:
        return r0.getDeviceMode(r1);
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getNameResource(BluetoothDevice r1) {
        return com.android.settingslib.R.string.bluetooth_profile_hearing_aid;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getSummaryResourceForDevice(BluetoothDevice r1) {
        int r0 = getConnectionStatus(r1);
        if (r0 == 0) goto L11;
        if (r0 == 2) goto L9;
        return BluetoothUtils.getConnectionStateSummary(r0);
    L9:
        return com.android.settingslib.R.string.bluetooth_hearing_aid_profile_summary_connected;
    L11:
        return com.android.settingslib.R.string.bluetooth_hearing_aid_profile_summary_use_for;
    }

    protected void finalize() {
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "finalize()");
        if (this.mService == null) goto L11;
        BluetoothAdapter.getDefaultAdapter().closeProfileProxy(21, this.mService);     // Catch: Throwable -> L6
        this.mService = null;     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Error cleaning up Hearing Aid proxy", th);
        return;
    }
}
