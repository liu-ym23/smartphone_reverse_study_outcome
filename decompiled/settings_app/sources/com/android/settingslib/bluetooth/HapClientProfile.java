package com.android.settingslib.bluetooth;

import android.R;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHapClient;
import android.bluetooth.BluetoothHapPresetInfo;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import com.GlobalProxyLancet;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class HapClientProfile implements LocalBluetoothProfile {
    static final String NAME = "HapClient";
    private static final int ORDINAL = 1;
    private static final String TAG = "HapClientProfile";
    private final BluetoothAdapter mBluetoothAdapter;
    private final CachedBluetoothDeviceManager mDeviceManager;
    private boolean mIsProfileReady;
    private final LocalBluetoothProfileManager mProfileManager;
    private BluetoothHapClient mService;

    /* JADX INFO: renamed from: com.android.settingslib.bluetooth.HapClientProfile$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private final class HapClientServiceListener implements BluetoothProfile.ServiceListener {
        final /* synthetic */ HapClientProfile this$0;

        private HapClientServiceListener(HapClientProfile r1) {
            this.this$0 = r1;
        }

        /* synthetic */ HapClientServiceListener(HapClientProfile r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int r3, BluetoothProfile r4) {
            HapClientProfile.access$002(this.this$0, (BluetoothHapClient) r4);
            List r5 = HapClientProfile.access$000(this.this$0).getConnectedDevices();
        L4:
            if (r5.isEmpty() == true) goto L9;
            BluetoothDevice r6 = (BluetoothDevice) r5.remove(0);
            CachedBluetoothDevice r0 = HapClientProfile.access$100(this.this$0).findDevice(r6);
            if (r0 != null) goto L8;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(HapClientProfile.TAG, "HapClient profile found new device: " + r6);
            r0 = HapClientProfile.access$100(this.this$0).addDevice(r6);
        L8:
            r0.onProfileStateChanged(this.this$0, 2);
            r0.refresh();
            goto L4
        L9:
            HapClientProfile.access$100(this.this$0).updateHearingAidsDevices();
            HapClientProfile.access$202(this.this$0, true);
            HapClientProfile.access$300(this.this$0).callServiceConnectedListeners();
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int r2) {
            HapClientProfile.access$202(this.this$0, false);
            HapClientProfile.access$300(this.this$0).callServiceDisconnectedListeners();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface HearingAidType {
        public static final int TYPE_BANDED = 2;
        public static final int TYPE_BINAURAL = 0;
        public static final int TYPE_INVALID = -1;
        public static final int TYPE_MONAURAL = 1;
        public static final int TYPE_RFU = 3;
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
        return 28;
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean isAutoConnectable() {
        return true;
    }

    public String toString() {
        return NAME;
    }

    static /* synthetic */ BluetoothHapClient access$000(HapClientProfile r0) {
        return r0.mService;
    }

    static /* synthetic */ BluetoothHapClient access$002(HapClientProfile r0, BluetoothHapClient r1) {
        r0.mService = r1;
        return r1;
    }

    static /* synthetic */ CachedBluetoothDeviceManager access$100(HapClientProfile r0) {
        return r0.mDeviceManager;
    }

    static /* synthetic */ boolean access$202(HapClientProfile r0, boolean r1) {
        r0.mIsProfileReady = r1;
        return r1;
    }

    static /* synthetic */ LocalBluetoothProfileManager access$300(HapClientProfile r0) {
        return r0.mProfileManager;
    }

    HapClientProfile(Context r2, CachedBluetoothDeviceManager r3, LocalBluetoothProfileManager r4) {
        this.mDeviceManager = r3;
        this.mProfileManager = r4;
        BluetoothManager r5 = (BluetoothManager) r2.getSystemService(BluetoothManager.class);
        AnonymousClass1 r6 = null;
        if (r5 == null) goto L5;
        BluetoothAdapter r7 = r5.getAdapter();
        this.mBluetoothAdapter = r7;
        r7.getProfileProxy(r2, new HapClientServiceListener(this, r6), 28);
        return;
    L5:
        this.mBluetoothAdapter = null;
    }

    public void registerCallback(Executor r1, BluetoothHapClient.Callback r2) {
        BluetoothHapClient r0 = this.mService;
        if (r0 != null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Proxy not attached to service. Cannot register callback.");
        return;
    L6:
        r0.registerCallback(r1, r2);
    }

    public void unregisterCallback(BluetoothHapClient.Callback r1) {
        BluetoothHapClient r0 = this.mService;
        if (r0 != null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Proxy not attached to service. Cannot unregister callback.");
        return;
    L6:
        r0.unregisterCallback(r1);
    }

    public List<BluetoothDevice> getConnectedDevices() {
        return getDevicesByStates(new int[]{2, 1, 3});
    }

    public List<BluetoothDevice> getConnectableDevices() {
        return getDevicesByStates(new int[]{0, 2, 1, 3});
    }

    private List<BluetoothDevice> getDevicesByStates(int[] r1) {
        BluetoothHapClient r0 = this.mService;
        if (r0 != null) goto L7;
        return new ArrayList(0);
    L7:
        return r0.getDevicesMatchingConnectionStates(r1);
    }

    public int getHearingAidType(BluetoothDevice r1) {
        BluetoothHapClient r0 = this.mService;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getHearingAidType(r1);
    }

    public boolean supportsSynchronizedPresets(BluetoothDevice r1) {
        BluetoothHapClient r0 = this.mService;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.supportsSynchronizedPresets(r1);
    }

    public boolean supportsIndependentPresets(BluetoothDevice r1) {
        BluetoothHapClient r0 = this.mService;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.supportsIndependentPresets(r1);
    }

    public boolean supportsDynamicPresets(BluetoothDevice r1) {
        BluetoothHapClient r0 = this.mService;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.supportsDynamicPresets(r1);
    }

    public boolean supportsWritablePresets(BluetoothDevice r1) {
        BluetoothHapClient r0 = this.mService;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.supportsWritablePresets(r1);
    }

    public int getHapGroup(BluetoothDevice r1) {
        BluetoothHapClient r0 = this.mService;
        if (r0 != null) goto L7;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Proxy not attached to service. Cannot get hap group.");
        return -1;
    L7:
        return r0.getHapGroup(r1);
    }

    public int getActivePresetIndex(BluetoothDevice r1) {
        BluetoothHapClient r0 = this.mService;
        if (r0 != null) goto L7;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Proxy not attached to service. Cannot get active preset index.");
        return 0;
    L7:
        return r0.getActivePresetIndex(r1);
    }

    public BluetoothHapPresetInfo getActivePresetInfo(BluetoothDevice r1) {
        BluetoothHapClient r0 = this.mService;
        if (r0 != null) goto L7;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Proxy not attached to service. Cannot get active preset info.");
        return null;
    L7:
        return r0.getActivePresetInfo(r1);
    }

    public void selectPreset(BluetoothDevice r1, int r2) {
        BluetoothHapClient r0 = this.mService;
        if (r0 != null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Proxy not attached to service. Cannot select preset.");
        return;
    L6:
        r0.selectPreset(r1, r2);
    }

    public void selectPresetForGroup(int r1, int r2) {
        BluetoothHapClient r0 = this.mService;
        if (r0 != null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Proxy not attached to service. Cannot select preset for group.");
        return;
    L6:
        r0.selectPresetForGroup(r1, r2);
    }

    public void switchToNextPreset(BluetoothDevice r1) {
        BluetoothHapClient r0 = this.mService;
        if (r0 != null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Proxy not attached to service. Cannot switch to next preset.");
        return;
    L6:
        r0.switchToNextPreset(r1);
    }

    public void switchToNextPresetForGroup(int r1) {
        BluetoothHapClient r0 = this.mService;
        if (r0 != null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Proxy not attached to service. Cannot switch to next preset for group.");
        return;
    L6:
        r0.switchToNextPresetForGroup(r1);
    }

    public void switchToPreviousPreset(BluetoothDevice r1) {
        BluetoothHapClient r0 = this.mService;
        if (r0 != null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Proxy not attached to service. Cannot switch to previous preset.");
        return;
    L6:
        r0.switchToPreviousPreset(r1);
    }

    public void switchToPreviousPresetForGroup(int r1) {
        BluetoothHapClient r0 = this.mService;
        if (r0 != null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Proxy not attached to service. Cannot switch to previous preset for group.");
        return;
    L6:
        r0.switchToPreviousPresetForGroup(r1);
    }

    public BluetoothHapPresetInfo getPresetInfo(BluetoothDevice r1, int r2) {
        BluetoothHapClient r0 = this.mService;
        if (r0 != null) goto L7;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Proxy not attached to service. Cannot get preset info.");
        return null;
    L7:
        return r0.getPresetInfo(r1, r2);
    }

    public List<BluetoothHapPresetInfo> getAllPresetInfo(BluetoothDevice r1) {
        BluetoothHapClient r0 = this.mService;
        if (r0 != null) goto L7;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Proxy not attached to service. Cannot get all preset info.");
        return new ArrayList();
    L7:
        return r0.getAllPresetInfo(r1);
    }

    public void setPresetName(BluetoothDevice r1, int r2, String r3) {
        BluetoothHapClient r0 = this.mService;
        if (r0 != null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Proxy not attached to service. Cannot set preset name.");
        return;
    L6:
        r0.setPresetName(r1, r2, r3);
    }

    public void setPresetNameForGroup(int r1, int r2, String r3) {
        BluetoothHapClient r0 = this.mService;
        if (r0 != null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Proxy not attached to service. Cannot set preset name for group.");
        return;
    L6:
        r0.setPresetNameForGroup(r1, r2, r3);
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public int getConnectionStatus(BluetoothDevice r1) {
        BluetoothHapClient r0 = this.mService;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getConnectionState(r1);
    }

    @Override // com.android.settingslib.bluetooth.LocalBluetoothProfile
    public boolean isEnabled(BluetoothDevice r2) {
        BluetoothHapClient r1 = this.mService;
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
        BluetoothHapClient r0 = this.mService;
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
        BluetoothHapClient r0 = this.mService;
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
    public boolean isProfileReady() {
        return this.mIsProfileReady;
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
        BluetoothProfile r0 = this.mService;
        if (r0 == null) goto L11;
        this.mBluetoothAdapter.closeProfileProxy(28, r0);     // Catch: Throwable -> L6
        this.mService = null;     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Error cleaning up HAP Client proxy", th);
        return;
    }
}
