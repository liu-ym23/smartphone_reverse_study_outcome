package com.android.settingslib.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothUuid;
import android.content.Context;
import android.content.Intent;
import android.os.ParcelUuid;
import com.GlobalProxyLancet;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.CollectionUtils;
import com.android.settings.MultiSDKAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class LocalBluetoothProfileManager {
    private static final String BC_CONNECTION_STATE_CHANGED = "android.bluetooth.bc.profile.action.CONNECTION_STATE_CHANGED";
    private static final boolean DEBUG = true;
    private static final String TAG = "LocalBluetoothProfileManager";
    private A2dpProfile mA2dpProfile;
    private A2dpSinkProfile mA2dpSinkProfile;
    private final Context mContext;
    private CsipSetCoordinatorProfile mCsipSetCoordinatorProfile;
    private final CachedBluetoothDeviceManager mDeviceManager;
    protected final BluetoothEventManager mEventManager;
    private HapClientProfile mHapClientProfile;
    private HeadsetProfile mHeadsetProfile;
    private HearingAidProfile mHearingAidProfile;
    private HfpClientProfile mHfpClientProfile;
    private HidDeviceProfile mHidDeviceProfile;
    private HidProfile mHidProfile;
    private LocalBluetoothLeBroadcast mLeAudioBroadcast;
    private LocalBluetoothLeBroadcastAssistant mLeAudioBroadcastAssistant;
    private LeAudioProfile mLeAudioProfile;
    private MapClientProfile mMapClientProfile;
    private MapProfile mMapProfile;
    private OppProfile mOppProfile;
    private PanProfile mPanProfile;
    private PbapClientProfile mPbapClientProfile;
    private PbapServerProfile mPbapProfile;
    private final Map<String, LocalBluetoothProfile> mProfileNameMap;
    private SapProfile mSapProfile;
    private final Collection<ServiceListener> mServiceListeners;
    private VolumeControlProfile mVolumeControlProfile;

    private class HeadsetStateChangeHandler extends StateChangedHandler {
        private final String mAudioChangeAction;
        private final int mAudioDisconnectedState;
        final /* synthetic */ LocalBluetoothProfileManager this$0;

        HeadsetStateChangeHandler(LocalBluetoothProfileManager r1, LocalBluetoothProfile r2, String r3, int r4) {
            this.this$0 = r1;
            super(r1, r2);
            this.mAudioChangeAction = r3;
            this.mAudioDisconnectedState = r4;
        }

        @Override // com.android.settingslib.bluetooth.LocalBluetoothProfileManager.StateChangedHandler
        public void onReceiveInternal(Intent r3, CachedBluetoothDevice r4) {
            if (this.mAudioChangeAction.equals(r3.getAction()) == true) goto L5;
            super.onReceiveInternal(r3, r4);
            return;
        L5:
            if (r3.getIntExtra("android.bluetooth.profile.extra.STATE", 0) == this.mAudioDisconnectedState) goto L7;
            r4.onProfileStateChanged(this.mProfile, 2);
        L7:
            r4.refresh();
        }
    }

    private class PanStateChangedHandler extends StateChangedHandler {
        final /* synthetic */ LocalBluetoothProfileManager this$0;

        PanStateChangedHandler(LocalBluetoothProfileManager r1, LocalBluetoothProfile r2) {
            this.this$0 = r1;
            super(r1, r2);
        }

        @Override // com.android.settingslib.bluetooth.LocalBluetoothProfileManager.StateChangedHandler, com.android.settingslib.bluetooth.BluetoothEventManager.Handler
        public void onReceive(Context r4, Intent r5, BluetoothDevice r6) {
            ((PanProfile) this.mProfile).setLocalRole(r6, r5.getIntExtra("android.bluetooth.pan.extra.LOCAL_ROLE", 0));
            super.onReceive(r4, r5, r6);
        }
    }

    public interface ServiceListener {
        void onServiceConnected();

        void onServiceDisconnected();
    }

    private class StateChangedHandler implements BluetoothEventManager.Handler {
        final LocalBluetoothProfile mProfile;
        final /* synthetic */ LocalBluetoothProfileManager this$0;

        StateChangedHandler(LocalBluetoothProfileManager r1, LocalBluetoothProfile r2) {
            this.this$0 = r1;
            this.mProfile = r2;
        }

        @Override // com.android.settingslib.bluetooth.BluetoothEventManager.Handler
        public void onReceive(Context r3, Intent r4, BluetoothDevice r5) {
            if (r5 != null) goto L6;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(LocalBluetoothProfileManager.TAG, "StateChangedHandler receives state-change for invalid device");
            return;
        L6:
            CachedBluetoothDevice r0 = LocalBluetoothProfileManager.access$000(this.this$0).findDevice(r5);
            if (r0 != null) goto L9;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(LocalBluetoothProfileManager.TAG, "StateChangedHandler found new device: " + r5);
            r0 = LocalBluetoothProfileManager.access$000(this.this$0).addDevice(r5);
        L9:
            onReceiveInternal(r4, r0);
        }

        protected void onReceiveInternal(Intent r11, CachedBluetoothDevice r12) {
            boolean r1 = false;
            int r0 = r11.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
            int r13 = r11.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", 0);
            boolean r2 = true;
            if (r0 != 0) goto L7;
            if (r13 != 1) goto L7;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_i(LocalBluetoothProfileManager.TAG, "Failed to connect " + this.mProfile + " device");
        L7:
            if (this.this$0.getHearingAidProfile() == null) goto L18;
            if ((this.mProfile instanceof HearingAidProfile) == false) goto L18;
            if (r0 != 2) goto L18;
            if (r12.getHiSyncId() != 0) goto L16;
            long r6 = this.this$0.getHearingAidProfile().getHiSyncId(r12.getDevice());
            if (r6 == 0) goto L16;
            BluetoothDevice r14 = r12.getDevice();
            r12.setHearingAidInfo(new HearingAidInfo.Builder().setAshaDeviceSide(this.this$0.getHearingAidProfile().getDeviceSide(r14)).setAshaDeviceMode(this.this$0.getHearingAidProfile().getDeviceMode(r14)).setHiSyncId(r6).build());
        L16:
            HearingAidStatsLogUtils.logHearingAidInfo(r12);
        L18:
            if (this.this$0.getHapClientProfile() != null) goto L20;
        L22:
            boolean r15 = false;
        L24:
            if (this.this$0.getLeAudioProfile() != null) goto L26;
        L28:
            boolean r7 = false;
        L29:
            if (r15 == true) goto L31;
            if (r7 == true) goto L31;
        L32:
            if (r1 == false) goto L38;
            if (r0 != 2) goto L38;
            if (r12.isConnectedLeAudioHearingAidDevice() == false) goto L38;
            BluetoothDevice r16 = r12.getDevice();
            r12.setHearingAidInfo(new HearingAidInfo.Builder().setLeAudioLocation(this.this$0.getLeAudioProfile().getAudioLocation(r16)).setHapDeviceType(this.this$0.getHapClientProfile().getHearingAidType(r16)).build());
            HearingAidStatsLogUtils.logHearingAidInfo(r12);
        L38:
            if (this.this$0.getCsipSetCoordinatorProfile() != null) goto L40;
        L49:
            r12.onProfileStateChanged(this.mProfile, r0);
            if (r12.getHiSyncId() == 0) goto L52;
        L53:
            LocalBluetoothProfileManager.access$000(this.this$0).syncDeviceWithinHearingAidSetIfNeeded(r12, r0, this.mProfile.getProfileId());
            r2 = true ^ LocalBluetoothProfileManager.access$000(this.this$0).onProfileConnectionStateChangedIfProcessed(r12, r0, this.mProfile.getProfileId());
        L54:
            if (r2 == false) goto L57;
            r12.refresh();
            this.this$0.mEventManager.dispatchProfileConnectionStateChanged(r12, r0, this.mProfile.getProfileId());
            return;
        L57:
            return;
        L52:
            if (r12.getGroupId() == (-1)) goto L54;
        L40:
            if ((this.mProfile instanceof CsipSetCoordinatorProfile) == false) goto L49;
            if (r0 != 2) goto L49;
            if (r12.getGroupId() != (-1)) goto L49;
            Map<Integer, ParcelUuid> r17 = this.this$0.getCsipSetCoordinatorProfile().getGroupUuidMapByDevice(r12.getDevice());
            if (r17 == null) goto L49;
            Iterator<Map.Entry<Integer, ParcelUuid>> r18 = r17.entrySet().iterator();
            if (r18.hasNext() == false) goto L49;
            r12.setGroupId(r18.next().getKey().intValue());
        L31:
            r1 = true;
            goto L32
        L26:
            if ((this.mProfile instanceof LeAudioProfile) == false) goto L28;
            r7 = true;
            goto L29
        L20:
            if ((this.mProfile instanceof HapClientProfile) == false) goto L22;
            r15 = true;
            goto L24
        }
    }

    static /* synthetic */ CachedBluetoothDeviceManager access$000(LocalBluetoothProfileManager r0) {
        return r0.mDeviceManager;
    }

    LocalBluetoothProfileManager(Context r2, LocalBluetoothAdapter r3, CachedBluetoothDeviceManager r4, BluetoothEventManager r5) {
        this.mProfileNameMap = new HashMap();
        this.mServiceListeners = new CopyOnWriteArrayList();
        this.mContext = r2;
        this.mDeviceManager = r4;
        this.mEventManager = r5;
        r3.setProfileManager(this);
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "LocalBluetoothProfileManager construction complete");
    }

    synchronized void updateLocalProfiles() {
        monitor-enter(this);
        List r0 = BluetoothAdapter.getDefaultAdapter().getSupportedProfiles();     // Catch: Throwable -> L111
        if (CollectionUtils.isEmpty(r0) == false) goto L9;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "supportedList is null");     // Catch: Throwable -> L111
        monitor-exit(this);
        return;
    L9:
        if (this.mA2dpProfile != null) goto L14;
        if (r0.contains(2) == false) goto L14;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Adding local A2DP profile");     // Catch: Throwable -> L111
        A2dpProfile r1 = new A2dpProfile(this.mContext, this.mDeviceManager, this);     // Catch: Throwable -> L111
        this.mA2dpProfile = r1;     // Catch: Throwable -> L111
        addProfile(r1, "A2DP", "android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");     // Catch: Throwable -> L111
    L14:
        if (this.mA2dpSinkProfile != null) goto L19;
        if (r0.contains(11) == false) goto L19;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Adding local A2DP SINK profile");     // Catch: Throwable -> L111
        A2dpSinkProfile r2 = new A2dpSinkProfile(this.mContext, this.mDeviceManager, this);     // Catch: Throwable -> L111
        this.mA2dpSinkProfile = r2;     // Catch: Throwable -> L111
        addProfile(r2, "A2DPSink", "android.bluetooth.a2dp-sink.profile.action.CONNECTION_STATE_CHANGED");     // Catch: Throwable -> L111
    L19:
        if (this.mHeadsetProfile != null) goto L24;
        if (r0.contains(1) == false) goto L24;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Adding local HEADSET profile");     // Catch: Throwable -> L111
        HeadsetProfile r4 = new HeadsetProfile(this.mContext, this.mDeviceManager, this);     // Catch: Throwable -> L111
        this.mHeadsetProfile = r4;     // Catch: Throwable -> L111
        addHeadsetProfile(r4, "HEADSET", "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED", "android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED", 10);     // Catch: Throwable -> L111
    L24:
        if (this.mHfpClientProfile != null) goto L29;
        if (r0.contains(16) == false) goto L29;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Adding local HfpClient profile");     // Catch: Throwable -> L111
        HfpClientProfile r3 = new HfpClientProfile(this.mContext, this.mDeviceManager, this);     // Catch: Throwable -> L111
        this.mHfpClientProfile = r3;     // Catch: Throwable -> L111
        addProfile(r3, "HEADSET_CLIENT", "android.bluetooth.headsetclient.profile.action.CONNECTION_STATE_CHANGED");     // Catch: Throwable -> L111
    L29:
        if (this.mMapClientProfile != null) goto L34;
        if (r0.contains(18) == false) goto L34;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Adding local MAP CLIENT profile");     // Catch: Throwable -> L111
        MapClientProfile r5 = new MapClientProfile(this.mContext, this.mDeviceManager, this);     // Catch: Throwable -> L111
        this.mMapClientProfile = r5;     // Catch: Throwable -> L111
        addProfile(r5, "MAP Client", "android.bluetooth.mapmce.profile.action.CONNECTION_STATE_CHANGED");     // Catch: Throwable -> L111
    L34:
        if (this.mMapProfile != null) goto L39;
        if (r0.contains(9) == false) goto L39;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Adding local MAP profile");     // Catch: Throwable -> L111
        MapProfile r6 = new MapProfile(this.mContext, this.mDeviceManager, this);     // Catch: Throwable -> L111
        this.mMapProfile = r6;     // Catch: Throwable -> L111
        addProfile(r6, "MAP", "android.bluetooth.map.profile.action.CONNECTION_STATE_CHANGED");     // Catch: Throwable -> L111
    L39:
        if (this.mOppProfile != null) goto L44;
        if (r0.contains(20) == false) goto L44;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Adding local OPP profile");     // Catch: Throwable -> L111
        OppProfile r7 = new OppProfile();     // Catch: Throwable -> L111
        this.mOppProfile = r7;     // Catch: Throwable -> L111
        this.mProfileNameMap.put("OPP", r7);     // Catch: Throwable -> L111
    L44:
        if (this.mHearingAidProfile != null) goto L49;
        if (r0.contains(21) == false) goto L49;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Adding local Hearing Aid profile");     // Catch: Throwable -> L111
        HearingAidProfile r8 = new HearingAidProfile(this.mContext, this.mDeviceManager, this);     // Catch: Throwable -> L111
        this.mHearingAidProfile = r8;     // Catch: Throwable -> L111
        addProfile(r8, "HearingAid", "android.bluetooth.hearingaid.profile.action.CONNECTION_STATE_CHANGED");     // Catch: Throwable -> L111
    L49:
        if (this.mHapClientProfile != null) goto L54;
        if (r0.contains(28) == false) goto L54;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Adding local HAP_CLIENT profile");     // Catch: Throwable -> L111
        HapClientProfile r9 = new HapClientProfile(this.mContext, this.mDeviceManager, this);     // Catch: Throwable -> L111
        this.mHapClientProfile = r9;     // Catch: Throwable -> L111
        addProfile(r9, "HapClient", "android.bluetooth.action.HAP_CONNECTION_STATE_CHANGED");     // Catch: Throwable -> L111
    L54:
        if (this.mHidProfile != null) goto L59;
        if (r0.contains(4) == false) goto L59;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Adding local HID_HOST profile");     // Catch: Throwable -> L111
        HidProfile r10 = new HidProfile(this.mContext, this.mDeviceManager, this);     // Catch: Throwable -> L111
        this.mHidProfile = r10;     // Catch: Throwable -> L111
        addProfile(r10, "HID", MultiSDKAdapter.ACTION_CONNECTION_STATE_CHANGED);     // Catch: Throwable -> L111
    L59:
        if (this.mHidDeviceProfile != null) goto L64;
        if (r0.contains(19) == false) goto L64;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Adding local HID_DEVICE profile");     // Catch: Throwable -> L111
        HidDeviceProfile r11 = new HidDeviceProfile(this.mContext, this.mDeviceManager, this);     // Catch: Throwable -> L111
        this.mHidDeviceProfile = r11;     // Catch: Throwable -> L111
        addProfile(r11, "HID DEVICE", "android.bluetooth.hiddevice.profile.action.CONNECTION_STATE_CHANGED");     // Catch: Throwable -> L111
    L64:
        if (this.mPanProfile != null) goto L69;
        if (r0.contains(5) == false) goto L69;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Adding local PAN profile");     // Catch: Throwable -> L111
        PanProfile r12 = new PanProfile(this.mContext);     // Catch: Throwable -> L111
        this.mPanProfile = r12;     // Catch: Throwable -> L111
        addPanProfile(r12, "PAN", "android.bluetooth.pan.profile.action.CONNECTION_STATE_CHANGED");     // Catch: Throwable -> L111
    L69:
        if (this.mPbapProfile != null) goto L74;
        if (r0.contains(6) == false) goto L74;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Adding local PBAP profile");     // Catch: Throwable -> L111
        PbapServerProfile r13 = new PbapServerProfile(this.mContext);     // Catch: Throwable -> L111
        this.mPbapProfile = r13;     // Catch: Throwable -> L111
        addProfile(r13, PbapServerProfile.NAME, "android.bluetooth.pbap.profile.action.CONNECTION_STATE_CHANGED");     // Catch: Throwable -> L111
    L74:
        if (this.mPbapClientProfile != null) goto L79;
        if (r0.contains(17) == false) goto L79;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Adding local PBAP Client profile");     // Catch: Throwable -> L111
        PbapClientProfile r14 = new PbapClientProfile(this.mContext, this.mDeviceManager, this);     // Catch: Throwable -> L111
        this.mPbapClientProfile = r14;     // Catch: Throwable -> L111
        addProfile(r14, "PbapClient", "android.bluetooth.pbapclient.profile.action.CONNECTION_STATE_CHANGED");     // Catch: Throwable -> L111
    L79:
        if (this.mSapProfile != null) goto L84;
        if (r0.contains(10) == false) goto L84;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Adding local SAP profile");     // Catch: Throwable -> L111
        SapProfile r15 = new SapProfile(this.mContext, this.mDeviceManager, this);     // Catch: Throwable -> L111
        this.mSapProfile = r15;     // Catch: Throwable -> L111
        addProfile(r15, "SAP", "android.bluetooth.sap.profile.action.CONNECTION_STATE_CHANGED");     // Catch: Throwable -> L111
    L84:
        if (this.mVolumeControlProfile != null) goto L89;
        if (r0.contains(23) == false) goto L89;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Adding local Volume Control profile");     // Catch: Throwable -> L111
        VolumeControlProfile r16 = new VolumeControlProfile(this.mContext, this.mDeviceManager, this);     // Catch: Throwable -> L111
        this.mVolumeControlProfile = r16;     // Catch: Throwable -> L111
        addProfile(r16, "VCP", "android.bluetooth.volume-control.profile.action.CONNECTION_STATE_CHANGED");     // Catch: Throwable -> L111
    L89:
        if (this.mLeAudioProfile != null) goto L94;
        if (r0.contains(22) == false) goto L94;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Adding local LE_AUDIO profile");     // Catch: Throwable -> L111
        LeAudioProfile r17 = new LeAudioProfile(this.mContext, this.mDeviceManager, this);     // Catch: Throwable -> L111
        this.mLeAudioProfile = r17;     // Catch: Throwable -> L111
        addProfile(r17, "LE_AUDIO", "android.bluetooth.action.LE_AUDIO_CONNECTION_STATE_CHANGED");     // Catch: Throwable -> L111
    L94:
        if (this.mLeAudioBroadcast != null) goto L99;
        if (r0.contains(26) == false) goto L99;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Adding local LE_AUDIO_BROADCAST profile");     // Catch: Throwable -> L111
        LocalBluetoothLeBroadcast r18 = new LocalBluetoothLeBroadcast(this.mContext, this.mDeviceManager);     // Catch: Throwable -> L111
        this.mLeAudioBroadcast = r18;     // Catch: Throwable -> L111
        this.mProfileNameMap.put("LE_AUDIO_BROADCAST", r18);     // Catch: Throwable -> L111
    L99:
        if (this.mLeAudioBroadcastAssistant != null) goto L104;
        if (r0.contains(29) == false) goto L104;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Adding local LE_AUDIO_BROADCAST_ASSISTANT profile");     // Catch: Throwable -> L111
        LocalBluetoothLeBroadcastAssistant r19 = new LocalBluetoothLeBroadcastAssistant(this.mContext, this.mDeviceManager, this);     // Catch: Throwable -> L111
        this.mLeAudioBroadcastAssistant = r19;     // Catch: Throwable -> L111
        addProfile(r19, "LE_AUDIO_BROADCAST", "android.bluetooth.action.CONNECTION_STATE_CHANGED");     // Catch: Throwable -> L111
    L104:
        if (this.mCsipSetCoordinatorProfile == null) goto L106;
    L108:
        this.mEventManager.registerProfileIntentReceiver();     // Catch: Throwable -> L111
        monitor-exit(this);
        return;
    L106:
        if (r0.contains(25) == false) goto L108;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Adding local CSIP set coordinator profile");     // Catch: Throwable -> L111
        CsipSetCoordinatorProfile r20 = new CsipSetCoordinatorProfile(this.mContext, this.mDeviceManager, this);     // Catch: Throwable -> L111
        this.mCsipSetCoordinatorProfile = r20;     // Catch: Throwable -> L111
        addProfile(r20, "CSIP Set Coordinator", "android.bluetooth.action.CSIS_CONNECTION_STATE_CHANGED");     // Catch: Throwable -> L111
    L111:
        th = move-exception;
        throw th;
    }

    private void addHeadsetProfile(LocalBluetoothProfile r2, String r3, String r4, String r5, int r6) {
        HeadsetStateChangeHandler r0 = new HeadsetStateChangeHandler(this, r2, r5, r6);
        this.mEventManager.addProfileHandler(r4, r0);
        this.mEventManager.addProfileHandler(r5, r0);
        this.mProfileNameMap.put(r3, r2);
    }

    private void addProfile(LocalBluetoothProfile r3, String r4, String r5) {
        this.mEventManager.addProfileHandler(r5, new StateChangedHandler(this, r3));
        this.mProfileNameMap.put(r4, r3);
    }

    private void addPanProfile(LocalBluetoothProfile r3, String r4, String r5) {
        this.mEventManager.addProfileHandler(r5, new PanStateChangedHandler(this, r3));
        this.mProfileNameMap.put(r4, r3);
    }

    public LocalBluetoothProfile getProfileByName(String r1) {
        return this.mProfileNameMap.get(r1);
    }

    void setBluetoothStateOn() {
        updateLocalProfiles();
        this.mEventManager.readPairedDevices();
    }

    public void addServiceListener(ServiceListener r1) {
        this.mServiceListeners.add(r1);
    }

    public void removeServiceListener(ServiceListener r1) {
        this.mServiceListeners.remove(r1);
    }

    void callServiceConnectedListeners() {
        Iterator r1 = new ArrayList(this.mServiceListeners).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((ServiceListener) r1.next()).onServiceConnected();
        goto L4
    }

    void callServiceDisconnectedListeners() {
        Iterator r1 = new ArrayList(this.mServiceListeners).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((ServiceListener) r1.next()).onServiceDisconnected();
        goto L4
    }

    public synchronized boolean isManagerReady() {
        monitor-enter(this);
        HeadsetProfile r0 = this.mHeadsetProfile;     // Catch: Throwable -> L21
        if (r0 == null) goto L8;
        boolean r1 = r0.isProfileReady();     // Catch: Throwable -> L21
        monitor-exit(this);
        return r1;
    L8:
        A2dpProfile r2 = this.mA2dpProfile;     // Catch: Throwable -> L21
        if (r2 == null) goto L13;
        boolean r3 = r2.isProfileReady();     // Catch: Throwable -> L21
        monitor-exit(this);
        return r3;
    L13:
        A2dpSinkProfile r4 = this.mA2dpSinkProfile;     // Catch: Throwable -> L21
        if (r4 == null) goto L18;
        boolean r5 = r4.isProfileReady();     // Catch: Throwable -> L21
        monitor-exit(this);
        return r5;
    L18:
        monitor-exit(this);
        return false;
    L21:
        th = move-exception;
        throw th;
    }

    public A2dpProfile getA2dpProfile() {
        return this.mA2dpProfile;
    }

    public A2dpSinkProfile getA2dpSinkProfile() {
        A2dpSinkProfile r0 = this.mA2dpSinkProfile;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.isProfileReady() == true) goto L7;
        return null;
    L7:
        return this.mA2dpSinkProfile;
    }

    public HeadsetProfile getHeadsetProfile() {
        return this.mHeadsetProfile;
    }

    public HfpClientProfile getHfpClientProfile() {
        HfpClientProfile r0 = this.mHfpClientProfile;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.isProfileReady() == true) goto L7;
        return null;
    L7:
        return this.mHfpClientProfile;
    }

    public PbapClientProfile getPbapClientProfile() {
        return this.mPbapClientProfile;
    }

    public PbapServerProfile getPbapProfile() {
        return this.mPbapProfile;
    }

    public MapProfile getMapProfile() {
        return this.mMapProfile;
    }

    public MapClientProfile getMapClientProfile() {
        return this.mMapClientProfile;
    }

    public HearingAidProfile getHearingAidProfile() {
        return this.mHearingAidProfile;
    }

    public HapClientProfile getHapClientProfile() {
        return this.mHapClientProfile;
    }

    public LeAudioProfile getLeAudioProfile() {
        return this.mLeAudioProfile;
    }

    public LocalBluetoothLeBroadcast getLeAudioBroadcastProfile() {
        return this.mLeAudioBroadcast;
    }

    public LocalBluetoothLeBroadcastAssistant getLeAudioBroadcastAssistantProfile() {
        return this.mLeAudioBroadcastAssistant;
    }

    SapProfile getSapProfile() {
        return this.mSapProfile;
    }

    public HidProfile getHidProfile() {
        return this.mHidProfile;
    }

    HidDeviceProfile getHidDeviceProfile() {
        return this.mHidDeviceProfile;
    }

    public CsipSetCoordinatorProfile getCsipSetCoordinatorProfile() {
        return this.mCsipSetCoordinatorProfile;
    }

    public VolumeControlProfile getVolumeControlProfile() {
        return this.mVolumeControlProfile;
    }

    synchronized void updateProfiles(ParcelUuid[] r5, ParcelUuid[] r6, Collection<LocalBluetoothProfile> r7, Collection<LocalBluetoothProfile> r8, boolean r9, BluetoothDevice r10) {
        monitor-enter(this);
        r8.clear();     // Catch: Throwable -> L113
        r8.addAll(r7);     // Catch: Throwable -> L113
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Current Profiles" + r7.toString());     // Catch: Throwable -> L113
        r7.clear();     // Catch: Throwable -> L113
        if (r5 != null) goto L9;
        monitor-exit(this);
        return;
    L9:
        if (ArrayUtils.contains(r5, BluetoothUuid.LE_AUDIO) == false) goto L14;
        LeAudioProfile r1 = this.mLeAudioProfile;     // Catch: Throwable -> L113
        if (r1 == null) goto L14;
        r7.add(r1);     // Catch: Throwable -> L113
        r8.remove(this.mLeAudioProfile);     // Catch: Throwable -> L113
    L14:
        if (this.mHeadsetProfile == null) goto L27;
        if (ArrayUtils.contains(r6, BluetoothUuid.HSP_AG) == false) goto L20;
        if (ArrayUtils.contains(r5, BluetoothUuid.HSP) == false) goto L20;
    L25:
        r7.add(this.mHeadsetProfile);     // Catch: Throwable -> L113
        r8.remove(this.mHeadsetProfile);     // Catch: Throwable -> L113
    L20:
        if (ArrayUtils.contains(r6, BluetoothUuid.HFP_AG) == false) goto L24;
        if (ArrayUtils.contains(r5, BluetoothUuid.HFP) == true) goto L25;
    L24:
        if (this.mHeadsetProfile.getConnectionStatus(r10) == 2) goto L25;
    L27:
        if (this.mHfpClientProfile == null) goto L34;
        if (ArrayUtils.contains(r5, BluetoothUuid.HFP_AG) == false) goto L34;
        if (ArrayUtils.contains(r6, BluetoothUuid.HFP) == false) goto L34;
        r7.add(this.mHfpClientProfile);     // Catch: Throwable -> L113
        r8.remove(this.mHfpClientProfile);     // Catch: Throwable -> L113
    L34:
        if (this.mA2dpProfile == null) goto L41;
        if (BluetoothUuid.containsAnyUuid(r5, A2dpProfile.SINK_UUIDS) == false) goto L38;
    L39:
        r7.add(this.mA2dpProfile);     // Catch: Throwable -> L113
        r8.remove(this.mA2dpProfile);     // Catch: Throwable -> L113
        goto L41
    L38:
        if (this.mA2dpProfile.getConnectionStatus(r10) == 2) goto L39;
    L41:
        if (BluetoothUuid.containsAnyUuid(r5, A2dpSinkProfile.SRC_UUIDS) == false) goto L46;
        A2dpSinkProfile r11 = this.mA2dpSinkProfile;     // Catch: Throwable -> L113
        if (r11 == null) goto L46;
        r7.add(r11);     // Catch: Throwable -> L113
        r8.remove(this.mA2dpSinkProfile);     // Catch: Throwable -> L113
    L46:
        if (ArrayUtils.contains(r5, BluetoothUuid.OBEX_OBJECT_PUSH) == false) goto L51;
        OppProfile r12 = this.mOppProfile;     // Catch: Throwable -> L113
        if (r12 == null) goto L51;
        r7.add(r12);     // Catch: Throwable -> L113
        r8.remove(this.mOppProfile);     // Catch: Throwable -> L113
    L51:
        if (ArrayUtils.contains(r5, BluetoothUuid.HID) == false) goto L53;
    L54:
        HidProfile r13 = this.mHidProfile;     // Catch: Throwable -> L113
        if (r13 == null) goto L57;
        r7.add(r13);     // Catch: Throwable -> L113
        r8.remove(this.mHidProfile);     // Catch: Throwable -> L113
    L57:
        HidDeviceProfile r14 = this.mHidDeviceProfile;     // Catch: Throwable -> L113
        if (r14 != null) goto L60;
    L62:
        if (r9 == false) goto L65;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Valid PAN-NAP connection exists.");     // Catch: Throwable -> L113
    L65:
        if (ArrayUtils.contains(r5, BluetoothUuid.NAP) == true) goto L67;
    L68:
        if (r9 == false) goto L70;
    L69:
        r7.add(this.mPanProfile);     // Catch: Throwable -> L113
        r8.remove(this.mPanProfile);     // Catch: Throwable -> L113
    L70:
        MapProfile r15 = this.mMapProfile;     // Catch: Throwable -> L113
        if (r15 == null) goto L76;
        if (r15.getConnectionStatus(r10) != 2) goto L76;
        r7.add(this.mMapProfile);     // Catch: Throwable -> L113
        r8.remove(this.mMapProfile);     // Catch: Throwable -> L113
        this.mMapProfile.setEnabled(r10, true);     // Catch: Throwable -> L113
    L76:
        if (this.mPbapProfile == null) goto L81;
        if (BluetoothUuid.containsAnyUuid(r5, PbapServerProfile.PBAB_CLIENT_UUIDS) == false) goto L81;
        r7.add(this.mPbapProfile);     // Catch: Throwable -> L113
        r8.remove(this.mPbapProfile);     // Catch: Throwable -> L113
        this.mPbapProfile.setEnabled(r10, true);     // Catch: Throwable -> L113
    L81:
        if (this.mMapClientProfile == null) goto L86;
        if (BluetoothUuid.containsAnyUuid(r5, MapClientProfile.UUIDS) == false) goto L86;
        r7.add(this.mMapClientProfile);     // Catch: Throwable -> L113
        r8.remove(this.mMapClientProfile);     // Catch: Throwable -> L113
    L86:
        if (this.mPbapClientProfile == null) goto L91;
        if (BluetoothUuid.containsAnyUuid(r5, PbapClientProfile.SRC_UUIDS) == false) goto L91;
        r7.add(this.mPbapClientProfile);     // Catch: Throwable -> L113
        r8.remove(this.mPbapClientProfile);     // Catch: Throwable -> L113
    L91:
        if (ArrayUtils.contains(r5, BluetoothUuid.HEARING_AID) == false) goto L96;
        HearingAidProfile r16 = this.mHearingAidProfile;     // Catch: Throwable -> L113
        if (r16 == null) goto L96;
        r7.add(r16);     // Catch: Throwable -> L113
        r8.remove(this.mHearingAidProfile);     // Catch: Throwable -> L113
    L96:
        if (this.mSapProfile == null) goto L101;
        if (ArrayUtils.contains(r5, BluetoothUuid.SAP) == false) goto L101;
        r7.add(this.mSapProfile);     // Catch: Throwable -> L113
        r8.remove(this.mSapProfile);     // Catch: Throwable -> L113
    L101:
        if (this.mVolumeControlProfile == null) goto L106;
        if (ArrayUtils.contains(r5, BluetoothUuid.VOLUME_CONTROL) == false) goto L106;
        r7.add(this.mVolumeControlProfile);     // Catch: Throwable -> L113
        r8.remove(this.mVolumeControlProfile);     // Catch: Throwable -> L113
    L106:
        if (this.mCsipSetCoordinatorProfile != null) goto L108;
    L110:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "New Profiles" + r7.toString());     // Catch: Throwable -> L113
        monitor-exit(this);
        return;
    L108:
        if (ArrayUtils.contains(r5, BluetoothUuid.COORDINATED_SET) == false) goto L110;
        r7.add(this.mCsipSetCoordinatorProfile);     // Catch: Throwable -> L113
        r8.remove(this.mCsipSetCoordinatorProfile);     // Catch: Throwable -> L113
        goto L110
    L67:
        if (this.mPanProfile != null) goto L69;
    L60:
        if (r14.getConnectionStatus(r10) == 0) goto L62;
        r7.add(this.mHidDeviceProfile);     // Catch: Throwable -> L113
        r8.remove(this.mHidDeviceProfile);     // Catch: Throwable -> L113
        goto L62
    L53:
        if (ArrayUtils.contains(r5, BluetoothUuid.HOGP) == false) goto L57;
    L113:
        th = move-exception;
        throw th;
    }
}
