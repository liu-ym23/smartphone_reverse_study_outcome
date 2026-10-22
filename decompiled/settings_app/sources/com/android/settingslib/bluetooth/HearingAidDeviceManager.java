package com.android.settingslib.bluetooth;

import android.bluetooth.BluetoothUuid;
import android.bluetooth.le.ScanFilter;
import android.content.ContentResolver;
import android.content.Context;
import android.media.AudioDeviceAttributes;
import android.media.audiopolicy.AudioProductStrategy;
import android.os.ParcelUuid;
import android.provider.Settings;
import android.util.FeatureFlagUtils;
import com.GlobalProxyLancet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class HearingAidDeviceManager {
    private static final boolean DEBUG = true;
    private static final String TAG = "HearingAidDeviceManager";
    private final LocalBluetoothManager mBtManager;
    private final List<CachedBluetoothDevice> mCachedDevices;
    private final ContentResolver mContentResolver;
    private final Context mContext;
    private final HearingAidAudioRoutingHelper mRoutingHelper;

    private boolean isValidGroupId(int r1) {
        if (r1 == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isValidHiSyncId(long r3) {
        if (r3 == 0) goto L5;
        return true;
    L5:
        return false;
    }

    HearingAidDeviceManager(Context r2, LocalBluetoothManager r3, List<CachedBluetoothDevice> r4) {
        this.mContext = r2;
        this.mContentResolver = r2.getContentResolver();
        this.mBtManager = r3;
        this.mCachedDevices = r4;
        this.mRoutingHelper = new HearingAidAudioRoutingHelper(r2);
    }

    HearingAidDeviceManager(Context r1, LocalBluetoothManager r2, List<CachedBluetoothDevice> r3, HearingAidAudioRoutingHelper r4) {
        this.mContext = r1;
        this.mContentResolver = r1.getContentResolver();
        this.mBtManager = r2;
        this.mCachedDevices = r3;
        this.mRoutingHelper = r4;
    }

    void initHearingAidDeviceIfNeeded(CachedBluetoothDevice r3, List<ScanFilter> r4) {
        HearingAidInfo r2 = generateHearingAidInfo(r3);
        if (r2 == null) goto L5;
        r3.setHearingAidInfo(r2);
        return;
    L5:
        if (r4 != null) goto L7;
        return;
    L7:
        if (r3.isHearingAidDevice() == true) goto L29;
        Iterator<ScanFilter> r5 = r4.iterator();
    L10:
        if (r5.hasNext() == false) goto L30;
        ScanFilter r6 = r5.next();
        ParcelUuid r0 = r6.getServiceUuid();
        ParcelUuid r7 = r6.getServiceDataUuid();
        if (BluetoothUuid.HEARING_AID.equals(r0) == true) goto L19;
        if (BluetoothUuid.HAS.equals(r0) == true) goto L19;
        if (BluetoothUuid.HEARING_AID.equals(r7) == true) goto L19;
        if (BluetoothUuid.HAS.equals(r7) == false) goto L10;
    L19:
        r3.setHearingAidInfo(new HearingAidInfo.Builder().build());
        return;
    L30:
        return;
    }

    boolean setSubDeviceIfNeeded(CachedBluetoothDevice r4) {
        long r0 = r4.getHiSyncId();
        if (isValidHiSyncId(r0) == false) goto L8;
        CachedBluetoothDevice r3 = getCachedDevice(r0);
        if (r3 == null) goto L10;
        r3.setSubDevice(r4);
        r4.setName(r3.getName());
        return true;
    L10:
        return false;
    L8:
        return false;
    }

    private CachedBluetoothDevice getCachedDevice(long r5) {
        int r0 = this.mCachedDevices.size() - 1;
    L3:
        if (r0 < 0) goto L8;
        CachedBluetoothDevice r1 = this.mCachedDevices.get(r0);
        if (r1.getHiSyncId() == r5) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        return r1;
    L8:
        return null;
    }

    void updateHearingAidsDevices() {
        HashSet r0 = new HashSet();
        Iterator<CachedBluetoothDevice> r1 = this.mCachedDevices.iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        CachedBluetoothDevice r2 = r1.next();
        if (isValidHiSyncId(r2.getHiSyncId()) == true) goto L4;
        HearingAidInfo r3 = generateHearingAidInfo(r2);
        if (r3 == null) goto L4;
        r2.setHearingAidInfo(r3);
        if (isValidHiSyncId(r3.getHiSyncId()) == false) goto L4;
        r0.add(Long.valueOf(r3.getHiSyncId()));
        goto L4
    L13:
        Iterator r4 = r0.iterator();
    L15:
        if (r4.hasNext() == false) goto L17;
        onHiSyncIdChanged(((Long) r4.next()).longValue());
        goto L15
    }

    void onHiSyncIdChanged(long r8) {
        int r0 = this.mCachedDevices.size() - 1;
        int r2 = -1;
    L3:
        if (r0 < 0) goto L24;
        CachedBluetoothDevice r3 = this.mCachedDevices.get(r0);
        if (r3.getHiSyncId() != r8) goto L12;
        if (r3.getProfiles().stream().anyMatch(new HearingAidDeviceManager$$ExternalSyntheticLambda0()) == true) goto L12;
        if (r2 != (-1)) goto L14;
        r2 = r0;
        goto L12
    L14:
        if (r3.isConnected() == false) goto L16;
        CachedBluetoothDevice r1 = this.mCachedDevices.get(r2);
        r0 = r2;
    L17:
        r3.setSubDevice(r1);
        this.mCachedDevices.remove(r0);
        log("onHiSyncIdChanged: removed from UI device =" + r1 + ", with hiSyncId=" + r8);
        this.mBtManager.getEventManager().dispatchDeviceRemoved(r1);
        return;
    L16:
        r3 = this.mCachedDevices.get(r2);
        r1 = r3;
    L12:
        r0 = r0 - 1;
        goto L3
    }

    static /* synthetic */ boolean lambda$onHiSyncIdChanged$0(LocalBluetoothProfile r0) {
        return r0 instanceof CsipSetCoordinatorProfile;
    }

    boolean onProfileConnectionStateChangedIfProcessed(CachedBluetoothDevice r4, int r5) {
        if (r5 == 0) goto L15;
        if (r5 != 2) goto L28;
        onHiSyncIdChanged(r4.getHiSyncId());
        CachedBluetoothDevice r6 = findMainDevice(r4);
        if (r6 != null) goto L10;
        return false;
    L10:
        if (r6.isConnected() == false) goto L12;
        r6.refresh();
    L13:
        return true;
    L12:
        switchDeviceContent(r6, r4);
        goto L13
    L28:
        return false;
    L15:
        if (r4.getUnpairing() == false) goto L17;
        return true;
    L17:
        CachedBluetoothDevice r7 = findMainDevice(r4);
        if (r7 == null) goto L21;
        r7.refresh();
        return true;
    L21:
        CachedBluetoothDevice r8 = getConnectedSecondaryDevice(r4);
        if (r8 == null) goto L27;
        switchDeviceContent(r4, r8);
        return true;
    L27:
        return false;
    }

    private void switchDeviceContent(CachedBluetoothDevice r2, CachedBluetoothDevice r3) {
        this.mBtManager.getEventManager().dispatchDeviceRemoved(r2);
        if (r2.getSubDevice() != null) goto L5;
    L7:
        r2.switchMemberDeviceContent(r3);
    L8:
        r2.refresh();
        this.mBtManager.getEventManager().dispatchDeviceAdded(r2);
        return;
    L5:
        if (r2.getSubDevice().equals(r3) == false) goto L7;
        r2.switchSubDeviceContent();
        goto L8
    }

    private CachedBluetoothDevice getConnectedSecondaryDevice(CachedBluetoothDevice r1) {
        if (r1.getSubDevice() == null) goto L9;
        if (r1.getSubDevice().isConnected() == false) goto L9;
        return r1.getSubDevice();
    L9:
        return r1.getMemberDevice().stream().filter(new HearingAidDeviceManager$$ExternalSyntheticLambda1()).findAny().orElse(null);
    }

    void onActiveDeviceChanged(CachedBluetoothDevice r3) {
        if (FeatureFlagUtils.isEnabled(this.mContext, "settings_audio_routing") == true) goto L5;
        return;
    L5:
        if (r3.isActiveDevice(21) == false) goto L7;
    L10:
        setAudioRoutingConfig(r3);
        return;
    L7:
        if (r3.isActiveDevice(22) == true) goto L10;
        clearAudioRoutingConfig();
    }

    void syncDeviceIfNeeded(CachedBluetoothDevice r5) {
        HapClientProfile r0 = this.mBtManager.getProfileManager().getHapClientProfile();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.supportsSynchronizedPresets(r5.getDevice()) == true) goto L14;
        CachedBluetoothDevice r4 = findMainDevice(r5);
        if (r4 == null) goto L15;
        int r6 = r0.getActivePresetIndex(r4.getDevice());
        int r1 = r0.getActivePresetIndex(r5.getDevice());
        if (r6 == 0) goto L16;
        if (r6 == r1) goto L17;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "syncing preset from " + r1 + "->" + r6 + ", device=" + r5);
        r0.selectPreset(r5.getDevice(), r6);
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    private void setAudioRoutingConfig(CachedBluetoothDevice r7) {
        AudioDeviceAttributes r0 = this.mRoutingHelper.getMatchedHearingDeviceAttributes(r7);
        if (r0 != null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Can not find expected AudioDeviceAttributes for hearing device: " + r7.getDevice().getAnonymizedAddress());
        return;
    L6:
        int r8 = Settings.Secure.getInt(this.mContentResolver, "hearing_aid_call_routing", 0);
        int r1 = Settings.Secure.getInt(this.mContentResolver, "hearing_aid_media_routing", 0);
        int r3 = Settings.Secure.getInt(this.mContentResolver, "hearing_aid_ringtone_routing", 0);
        int r2 = Settings.Secure.getInt(this.mContentResolver, "hearing_aid_notification_routing", 0);
        setPreferredDeviceRoutingStrategies(HearingAidAudioRoutingConstants.CALL_ROUTING_ATTRIBUTES, r0, r8);
        setPreferredDeviceRoutingStrategies(HearingAidAudioRoutingConstants.MEDIA_ROUTING_ATTRIBUTES, r0, r1);
        setPreferredDeviceRoutingStrategies(HearingAidAudioRoutingConstants.RINGTONE_ROUTING_ATTRIBUTES, r0, r3);
        setPreferredDeviceRoutingStrategies(HearingAidAudioRoutingConstants.NOTIFICATION_ROUTING_ATTRIBUTES, r0, r2);
    }

    private void clearAudioRoutingConfig() {
        setPreferredDeviceRoutingStrategies(HearingAidAudioRoutingConstants.CALL_ROUTING_ATTRIBUTES, null, 0);
        setPreferredDeviceRoutingStrategies(HearingAidAudioRoutingConstants.MEDIA_ROUTING_ATTRIBUTES, null, 0);
        setPreferredDeviceRoutingStrategies(HearingAidAudioRoutingConstants.RINGTONE_ROUTING_ATTRIBUTES, null, 0);
        setPreferredDeviceRoutingStrategies(HearingAidAudioRoutingConstants.NOTIFICATION_ROUTING_ATTRIBUTES, null, 0);
    }

    private void setPreferredDeviceRoutingStrategies(int[] r2, AudioDeviceAttributes r3, int r4) {
        List<AudioProductStrategy> r5 = this.mRoutingHelper.getSupportedStrategies(r2);
        if (this.mRoutingHelper.setPreferredDeviceRoutingStrategies(r5, r3, r4) == true) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "routingStrategies: " + r5.toString() + "routingValue: " + r4 + " fail to configure AudioProductStrategy");
        return;
    }

    CachedBluetoothDevice findMainDevice(CachedBluetoothDevice r6) {
        if (r6 == null) goto L27;
        List<CachedBluetoothDevice> r1 = this.mCachedDevices;
        if (r1 == null) goto L27;
        Iterator<CachedBluetoothDevice> r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L27;
        CachedBluetoothDevice r3 = r2.next();
        if (isValidGroupId(r3.getGroupId()) == false) goto L21;
        Iterator<CachedBluetoothDevice> r4 = r3.getMemberDevice().iterator();
    L14:
        if (r4.hasNext() == false) goto L21;
        CachedBluetoothDevice r5 = r4.next();
        if (r5 == null) goto L14;
        if (r5.equals(r6) == false) goto L14;
        return r3;
    L21:
        if (isValidHiSyncId(r3.getHiSyncId()) == false) goto L9;
        CachedBluetoothDevice r7 = r3.getSubDevice();
        if (r7 == null) goto L9;
        if (r7.equals(r6) == false) goto L9;
        return r3;
    L27:
        return null;
    }

    private HearingAidInfo generateHearingAidInfo(CachedBluetoothDevice r8) {
        LocalBluetoothProfileManager r0 = this.mBtManager.getProfileManager();
        HearingAidProfile r1 = r0.getHearingAidProfile();
        if (r1 != null) goto L5;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "HearingAidProfile is not supported on this device");
    L9:
        HapClientProfile r7 = r0.getHapClientProfile();
        LeAudioProfile r2 = r0.getLeAudioProfile();
        if (r7 == null) goto L21;
        if (r2 == null) goto L21;
        if (r8.getProfiles().stream().anyMatch(new HearingAidDeviceManager$$ExternalSyntheticLambda2()) == false) goto L24;
        int r3 = r2.getAudioLocation(r8.getDevice());
        int r9 = r7.getHearingAidType(r8.getDevice());
        if (r3 != 0) goto L18;
        return null;
    L18:
        if (r9 == (-1)) goto L26;
        HearingAidInfo r10 = new HearingAidInfo.Builder().setLeAudioLocation(r3).setHapDeviceType(r9).build();
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "generateHearingAidInfo, " + r8 + ", info=" + r10);
        return r10;
    L26:
        return null;
    L24:
        return null;
    L21:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "HapClientProfile or LeAudioProfile is not supported on this device");
        return null;
    L5:
        long r5 = r1.getHiSyncId(r8.getDevice());
        if (isValidHiSyncId(r5) == false) goto L9;
        HearingAidInfo r11 = new HearingAidInfo.Builder().setAshaDeviceSide(r1.getDeviceSide(r8.getDevice())).setAshaDeviceMode(r1.getDeviceMode(r8.getDevice())).setHiSyncId(r5).build();
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "generateHearingAidInfo, " + r8 + ", info=" + r11);
        return r11;
    }

    static /* synthetic */ boolean lambda$generateHearingAidInfo$1(LocalBluetoothProfile r0) {
        return r0 instanceof HapClientProfile;
    }

    private void log(String r1) {
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, r1);
    }
}
