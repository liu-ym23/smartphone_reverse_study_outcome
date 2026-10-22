package com.android.settings.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothUuid;
import android.content.Context;
import android.content.Intent;
import android.os.ParcelUuid;
import com.android.settings.AdaptConstants;
import com.android.settings.MultiSDKAdapter;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class LocalBluetoothProfileManager {
    private static final String TAG = "LocalBluetoothProfileManager";
    private static LocalBluetoothProfileManager sInstance;
    private A2dpProfile mA2dpProfile;
    private final Context mContext;
    private final CachedBluetoothDeviceManager mDeviceManager;
    private DunServerProfile mDunProfile;
    private final BluetoothEventManager mEventManager;
    private HeadsetProfile mHeadsetProfile;
    private final HidProfile mHidProfile;
    private final LocalBluetoothAdapter mLocalAdapter;
    private MapProfile mMapProfile;
    private OppProfile mOppProfile;
    private PanProfile mPanProfile;
    private final PbapServerProfile mPbapProfile;
    private final Map<String, LocalBluetoothProfile> mProfileNameMap;
    private final Collection<ServiceListener> mServiceListeners;

    private class PanStateChangedHandler extends StateChangedHandler {
        final /* synthetic */ LocalBluetoothProfileManager this$0;

        PanStateChangedHandler(LocalBluetoothProfileManager r1, LocalBluetoothProfile r2) {
            this.this$0 = r1;
            super(r1, r2);
        }

        @Override // com.android.settings.bluetooth.LocalBluetoothProfileManager.StateChangedHandler, com.android.settings.bluetooth.BluetoothEventManager.Handler
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

        @Override // com.android.settings.bluetooth.BluetoothEventManager.Handler
        public void onReceive(Context r9, Intent r10, BluetoothDevice r11) {
            int r2 = r10.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
            int r12 = r10.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", 0);
            OLog.d(LocalBluetoothProfileManager.TAG, this.mProfile + " state change " + r12 + " -> " + r2);
            CachedBluetoothDevice r1 = LocalBluetoothProfileManager.access$000(this.this$0).findDevice(r11);
            if (r1 != null) goto L8;
            if (r2 == 0) goto L8;
            if (r2 == 3) goto L8;
            OLog.w(LocalBluetoothProfileManager.TAG, "StateChangedHandler found new device: " + r11);
            r1 = LocalBluetoothProfileManager.access$000(this.this$0).addDevice(LocalBluetoothProfileManager.access$100(this.this$0), this.this$0, r11);
        L8:
            if (r2 != 0) goto L12;
            if (r12 != 1) goto L12;
            OLog.i(LocalBluetoothProfileManager.TAG, "Failed to connect " + this.mProfile + " device");
        L12:
            if (this.mProfile.toString().equals("A2DP") == false) goto L14;
        L15:
            if (r2 == 1) goto L18;
            if (r2 == 3) goto L18;
        L21:
            if (this.mProfile.toString().equals("A2DP") == true) goto L25;
            if (this.mProfile.toString().equals("HEADSET") == true) goto L25;
        L28:
            if (r1 == null) goto L30;
            r1.onProfileStateChanged(this.mProfile, r2);
            r1.refresh();
        L30:
            Intent r8 = new Intent(BluetoothSettings.ACTION_CONNECTION_STATE_CHANGED);
            r8.putExtra("android.bluetooth.profile.extra.STATE", r2);
            r8.putExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", r12);
            r9.sendBroadcast(r8);
            return;
        L25:
            if (r2 == 2) goto L27;
            if (r2 != 0) goto L28;
        L27:
            Utils.StopTiming(LocalBluetoothProfileManager.access$200(this.this$0));
        L18:
            if (LocalBluetoothAdapter.getInstance() == null) goto L21;
            LocalBluetoothAdapter.getInstance().cancelDiscovery();
            goto L21
        L14:
            if (this.mProfile.toString().equals("HEADSET") == false) goto L21;
            goto L15
        }
    }

    public void resetBusyList() {
    }

    static /* synthetic */ CachedBluetoothDeviceManager access$000(LocalBluetoothProfileManager r0) {
        return r0.mDeviceManager;
    }

    static /* synthetic */ LocalBluetoothAdapter access$100(LocalBluetoothProfileManager r0) {
        return r0.mLocalAdapter;
    }

    static /* synthetic */ Context access$200(LocalBluetoothProfileManager r0) {
        return r0.mContext;
    }

    LocalBluetoothProfileManager(Context r3, LocalBluetoothAdapter r4, CachedBluetoothDeviceManager r5, BluetoothEventManager r6) {
        this.mProfileNameMap = new HashMap();
        this.mServiceListeners = new ArrayList();
        this.mContext = r3;
        this.mLocalAdapter = r4;
        this.mDeviceManager = r5;
        this.mEventManager = r6;
        r4.setProfileManager(this);
        r6.setProfileManager(this);
        ParcelUuid[] r7 = r4.getUuids();
        if (r7 == null) goto L5;
        updateLocalProfiles(r7);
    L5:
        HidProfile r8 = new HidProfile(r3, r4, r5, this);
        this.mHidProfile = r8;
        addProfile(r8, "HID", MultiSDKAdapter.ACTION_CONNECTION_STATE_CHANGED);
        OLog.d(TAG, "Adding local MAP profile");
        MapProfile r9 = new MapProfile(r3, r4, r5, this);
        this.mMapProfile = r9;
        addProfile(r9, "MAP", "android.bluetooth.map.profile.action.CONNECTION_STATE_CHANGED");
        this.mPbapProfile = new PbapServerProfile(r3);
        OLog.d(TAG, "LocalBluetoothProfileManager construction complete");
    }

    void updateLocalProfiles(ParcelUuid[] r6) {
        if (BluetoothUuidEnhance.isUuidPresent(r6, AdaptConstants.A2DP_SOURCE) == false) goto L8;
        if (this.mA2dpProfile != null) goto L11;
        OLog.d(TAG, "Adding local A2DP profile");
        A2dpProfile r0 = new A2dpProfile(this.mContext, this.mLocalAdapter, this.mDeviceManager, this);
        this.mA2dpProfile = r0;
        addProfile(r0, "A2DP", "android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
    L11:
        if (BluetoothUuidEnhance.isUuidPresent(r6, AdaptConstants.HFP_AG) == true) goto L19;
        if (BluetoothUuidEnhance.isUuidPresent(r6, BluetoothUuid.HSP_AG) == true) goto L19;
        if (this.mHeadsetProfile == null) goto L22;
        OLog.w(TAG, "Warning: HEADSET profile was previously added but the UUID is now missing.");
    L22:
        if (BluetoothUuidEnhance.isUuidPresent(r6, AdaptConstants.OBEX_OBJECT_PUSH) == false) goto L27;
        if (this.mOppProfile != null) goto L29;
        OLog.d(TAG, "Adding local OPP profile");
        OppProfile r7 = new OppProfile();
        this.mOppProfile = r7;
        this.mProfileNameMap.put("OPP", r7);
    L29:
        this.mEventManager.registerProfileIntentReceiver();
        return;
    L27:
        if (this.mOppProfile == null) goto L29;
        OLog.w(TAG, "Warning: OPP profile was previously added but the UUID is now missing.");
    L19:
        if (this.mHeadsetProfile != null) goto L22;
        OLog.d(TAG, "Adding local HEADSET profile");
        HeadsetProfile r1 = new HeadsetProfile(this.mContext, this.mLocalAdapter, this.mDeviceManager, this);
        this.mHeadsetProfile = r1;
        addProfile(r1, "HEADSET", "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        goto L22
    L8:
        if (this.mA2dpProfile == null) goto L11;
        OLog.w(TAG, "Warning: A2DP profile was previously added but the UUID is now missing.");
        goto L11
    }

    private void addProfile(LocalBluetoothProfile r3, String r4, String r5) {
        this.mEventManager.addProfileHandler(r5, new StateChangedHandler(this, r3));
        this.mProfileNameMap.put(r4, r3);
    }

    private void addPanProfile(LocalBluetoothProfile r3, String r4, String r5) {
        this.mEventManager.addProfileHandler(r5, new PanStateChangedHandler(this, r3));
        this.mProfileNameMap.put(r4, r3);
    }

    LocalBluetoothProfile getProfileByName(String r1) {
        return this.mProfileNameMap.get(r1);
    }

    void setBluetoothStateOn() {
        ParcelUuid[] r0 = this.mLocalAdapter.getUuids();
        if (r0 == null) goto L5;
        updateLocalProfiles(r0);
    L5:
        this.mEventManager.readPairedDevices();
    }

    public boolean isProfilesProcessConnection() {
        BluetoothAdapter r4 = BluetoothAdapter.getDefaultAdapter();
        int r1 = r4.getProfileConnectionState(1);
        if (r1 != 1) goto L5;
    L15:
        OLog.d(TAG, "HEADSET is busy");
        return true;
    L5:
        if (r1 == 3) goto L15;
        int r5 = r4.getProfileConnectionState(2);
        if (r5 == 1) goto L13;
        if (r5 == 3) goto L13;
        return false;
    L13:
        OLog.d(TAG, "A2DP is busy");
        return true;
    }

    void addServiceListener(ServiceListener r1) {
        this.mServiceListeners.add(r1);
    }

    void removeServiceListener(ServiceListener r1) {
        this.mServiceListeners.remove(r1);
    }

    void callServiceConnectedListeners() {
        Iterator<ServiceListener> r1 = this.mServiceListeners.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onServiceConnected();
        goto L4
    }

    void callServiceDisconnectedListeners() {
        Iterator<ServiceListener> r1 = this.mServiceListeners.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onServiceDisconnected();
        goto L4
    }

    public synchronized boolean isManagerReady() {
        monitor-enter(this);
        HeadsetProfile r0 = this.mHeadsetProfile;     // Catch: Throwable -> L16
        if (r0 == null) goto L8;
        boolean r1 = r0.isProfileReady();     // Catch: Throwable -> L16
        monitor-exit(this);
        return r1;
    L8:
        A2dpProfile r2 = this.mA2dpProfile;     // Catch: Throwable -> L16
        if (r2 == null) goto L13;
        boolean r3 = r2.isProfileReady();     // Catch: Throwable -> L16
        monitor-exit(this);
        return r3;
    L13:
        monitor-exit(this);
        return false;
    L16:
        th = move-exception;
        throw th;
    }

    A2dpProfile getA2dpProfile() {
        return this.mA2dpProfile;
    }

    HeadsetProfile getHeadsetProfile() {
        return this.mHeadsetProfile;
    }

    PbapServerProfile getPbapProfile() {
        return this.mPbapProfile;
    }

    synchronized void updateProfiles(ParcelUuid[] r2, ParcelUuid[] r3, Collection<LocalBluetoothProfile> r4, Collection<LocalBluetoothProfile> r5, boolean r6, BluetoothDevice r7) {
        monitor-enter(this);
        r5.clear();     // Catch: Throwable -> L50
        r5.addAll(r4);     // Catch: Throwable -> L50
        r4.clear();     // Catch: Throwable -> L50
        if (r2 != null) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.mHeadsetProfile == null) goto L19;
        if (BluetoothUuidEnhance.isUuidPresent(r3, BluetoothUuid.HSP_AG) == false) goto L14;
        if (BluetoothUuidEnhance.isUuidPresent(r2, BluetoothUuid.HSP) == false) goto L14;
    L17:
        r4.add(this.mHeadsetProfile);     // Catch: Throwable -> L50
        r5.remove(this.mHeadsetProfile);     // Catch: Throwable -> L50
    L14:
        if (BluetoothUuidEnhance.isUuidPresent(r3, AdaptConstants.HFP_AG) == false) goto L19;
        if (BluetoothUuidEnhance.isUuidPresent(r2, AdaptConstants.HFP) == true) goto L17;
    L19:
        if (BluetoothUuid.containsAnyUuid(r2, A2dpProfile.SINK_UUIDS) == false) goto L24;
        A2dpProfile r8 = this.mA2dpProfile;     // Catch: Throwable -> L50
        if (r8 == null) goto L24;
        r4.add(r8);     // Catch: Throwable -> L50
        r5.remove(this.mA2dpProfile);     // Catch: Throwable -> L50
    L24:
        if (BluetoothUuidEnhance.isUuidPresent(r2, AdaptConstants.OBEX_OBJECT_PUSH) == false) goto L29;
        OppProfile r9 = this.mOppProfile;     // Catch: Throwable -> L50
        if (r9 == null) goto L29;
        r4.add(r9);     // Catch: Throwable -> L50
        r5.remove(this.mOppProfile);     // Catch: Throwable -> L50
    L29:
        if (BluetoothUuidEnhance.isUuidPresent(r2, AdaptConstants.HID) == false) goto L31;
    L32:
        HidProfile r10 = this.mHidProfile;     // Catch: Throwable -> L50
        if (r10 == null) goto L35;
        r4.add(r10);     // Catch: Throwable -> L50
        r5.remove(this.mHidProfile);     // Catch: Throwable -> L50
    L35:
        if (r6 == false) goto L38;
        OLog.d(TAG, "Valid PAN-NAP connection exists.");     // Catch: Throwable -> L50
    L38:
        if (BluetoothUuidEnhance.isUuidPresent(r2, BluetoothUuid.NAP) == true) goto L40;
    L41:
        if (r6 == false) goto L43;
    L42:
        r4.add(this.mPanProfile);     // Catch: Throwable -> L50
        r5.remove(this.mPanProfile);     // Catch: Throwable -> L50
    L43:
        MapProfile r11 = this.mMapProfile;     // Catch: Throwable -> L50
        if (r11 != null) goto L46;
    L48:
        monitor-exit(this);
        return;
    L46:
        if (r11.getConnectionStatus(r7) != 2) goto L48;
        r4.add(this.mMapProfile);     // Catch: Throwable -> L50
        r5.remove(this.mMapProfile);     // Catch: Throwable -> L50
        this.mMapProfile.setPreferred(r7, true);     // Catch: Throwable -> L50
        goto L48
    L40:
        if (this.mPanProfile != null) goto L42;
    L31:
        if (BluetoothUuidEnhance.isUuidPresent(r2, AdaptConstants.HOGP) == false) goto L35;
    L50:
        th = move-exception;
        throw th;
    }
}
