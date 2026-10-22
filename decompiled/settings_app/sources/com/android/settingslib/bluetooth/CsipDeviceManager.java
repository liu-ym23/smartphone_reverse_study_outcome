package com.android.settingslib.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.os.ParcelUuid;
import com.GlobalProxyLancet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes.dex */
public class CsipDeviceManager {
    private static final boolean DEBUG = true;
    private static final String TAG = "CsipDeviceManager";
    private final LocalBluetoothManager mBtManager;
    private final List<CachedBluetoothDevice> mCachedDevices;

    private static boolean isAtLeastT() {
        return true;
    }

    private boolean isValidGroupId(int r1) {
        if (r1 == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    CsipDeviceManager(LocalBluetoothManager r1, List<CachedBluetoothDevice> r2) {
        this.mBtManager = r1;
        this.mCachedDevices = r2;
    }

    void initCsipDeviceIfNeeded(CachedBluetoothDevice r4) {
        int r0 = getBaseGroupId(r4.getDevice());
        if (isValidGroupId(r0) == false) goto L6;
        log("initCsipDeviceIfNeeded: " + r4 + " (group: " + r0 + ")");
        r4.setGroupId(r0);
        return;
    }

    private int getBaseGroupId(BluetoothDevice r2) {
        CsipSetCoordinatorProfile r1 = this.mBtManager.getProfileManager().getCsipSetCoordinatorProfile();
        if (r1 == null) goto L11;
        Map<Integer, ParcelUuid> r3 = r1.getGroupUuidMapByDevice(r2);
        if (r3 != null) goto L7;
        return -1;
    L7:
        Iterator<Map.Entry<Integer, ParcelUuid>> r4 = r3.entrySet().iterator();
        if (r4.hasNext() == false) goto L11;
        return r4.next().getKey().intValue();
    L11:
        return -1;
    }

    boolean setMemberDeviceIfNeeded(CachedBluetoothDevice r4) {
        int r0 = r4.getGroupId();
        if (isValidGroupId(r0) == false) goto L8;
        CachedBluetoothDevice r1 = getCachedDevice(r0);
        log("setMemberDeviceIfNeeded, main: " + r1 + ", member: " + r4);
        if (r1 == null) goto L10;
        r1.addMemberDevice(r4);
        r4.setName(r1.getName());
        return true;
    L10:
        return false;
    L8:
        return false;
    }

    public CachedBluetoothDevice getCachedDevice(int r4) {
        log("getCachedDevice: groupId: " + r4);
        int r0 = this.mCachedDevices.size() - 1;
    L3:
        if (r0 < 0) goto L9;
        CachedBluetoothDevice r1 = this.mCachedDevices.get(r0);
        if (r1.getGroupId() == r4) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        log("getCachedDevice: found cachedDevice with the groupId: " + r1.getDevice().getAnonymizedAddress());
        return r1;
    L9:
        return null;
    }

    void updateCsipDevices() {
        HashSet r0 = new HashSet();
        Iterator<CachedBluetoothDevice> r1 = this.mCachedDevices.iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        CachedBluetoothDevice r2 = r1.next();
        if (isValidGroupId(r2.getGroupId()) == true) goto L4;
        int r3 = getBaseGroupId(r2.getDevice());
        if (isValidGroupId(r3) == false) goto L4;
        r2.setGroupId(r3);
        r0.add(Integer.valueOf(r3));
        goto L4
    L10:
        Iterator r4 = r0.iterator();
    L12:
        if (r4.hasNext() == false) goto L14;
        onGroupIdChanged(((Integer) r4.next()).intValue());
        goto L12
    }

    void onGroupIdChanged(int r2) {
        if (isValidGroupId(r2) == true) goto L6;
        log("onGroupIdChanged: groupId is invalid");
        return;
    L6:
        updateRelationshipOfGroupDevices(r2);
    }

    boolean onProfileConnectionStateChangedIfProcessed(CachedBluetoothDevice r3, int r4) {
        log("onProfileConnectionStateChangedIfProcessed: " + r3 + ", state: " + r4);
        if (r4 == 2) goto L8;
        if (r4 == 0) goto L8;
        return false;
    L8:
        return updateRelationshipOfGroupDevices(r3.getGroupId());
    }

    boolean updateRelationshipOfGroupDevices(int r5) {
        if (isValidGroupId(r5) == true) goto L6;
        log("The device is not group.");
        return false;
    L6:
        log("updateRelationshipOfGroupDevices: mCachedDevices list =" + this.mCachedDevices.toString());
        List<CachedBluetoothDevice> r0 = getGroupDevicesFromAllOfDevicesList(r5);
        CachedBluetoothDevice r1 = getPreferredMainDevice(r5, r0);
        log("The preferredMainDevice= " + r1 + " and the groupDevicesList of groupId= " + r5 + " =" + r0);
        return addMemberDevicesIntoMainDevice(r5, r1);
    }

    CachedBluetoothDevice findMainDevice(CachedBluetoothDevice r6) {
        if (r6 == null) goto L23;
        List<CachedBluetoothDevice> r1 = this.mCachedDevices;
        if (r1 == null) goto L23;
        Iterator<CachedBluetoothDevice> r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L23;
        CachedBluetoothDevice r3 = r2.next();
        if (isValidGroupId(r3.getGroupId()) == false) goto L9;
        Set<CachedBluetoothDevice> r4 = r3.getMemberDevice();
        if (r4.isEmpty() == true) goto L9;
        Iterator<CachedBluetoothDevice> r5 = r4.iterator();
    L17:
        if (r5.hasNext() == false) goto L9;
        CachedBluetoothDevice r7 = r5.next();
        if (r7 == null) goto L17;
        if (r7.equals(r6) == false) goto L17;
        return r3;
    L23:
        return null;
    }

    public boolean isExistedGroupId(int r1) {
        if (getCachedDevice(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    List<CachedBluetoothDevice> getGroupDevicesFromAllOfDevicesList(int r4) {
        ArrayList r0 = new ArrayList();
        if (isValidGroupId(r4) == true) goto L5;
        return r0;
    L5:
        Iterator<CachedBluetoothDevice> r3 = this.mCachedDevices.iterator();
    L7:
        if (r3.hasNext() == false) goto L12;
        CachedBluetoothDevice r1 = r3.next();
        if (r4 != r1.getGroupId()) goto L7;
        r0.add(r1);
        r0.addAll(r1.getMemberDevice());
        goto L7
    L12:
        return r0;
    }

    public CachedBluetoothDevice getFirstMemberDevice(int r4) {
        List<CachedBluetoothDevice> r0 = getGroupDevicesFromAllOfDevicesList(r4);
        if (r0.isEmpty() == false) goto L6;
        return null;
    L6:
        CachedBluetoothDevice r1 = r0.get(0);
        log("getFirstMemberDevice: groupId=" + r4 + " address=" + r1.getDevice().getAnonymizedAddress());
        return r1;
    }

    CachedBluetoothDevice getPreferredMainDevice(int r6, List<CachedBluetoothDevice> r7) {
        if (r7 != null) goto L5;
    L39:
        return null;
    L5:
        if (r7.isEmpty() == true) goto L39;
        CachedBluetoothDevice r1 = r7.stream().filter(new CsipDeviceManager$$ExternalSyntheticLambda3()).filter(new CsipDeviceManager$$ExternalSyntheticLambda4()).findFirst().orElse(null);
        if (isDeviceConnected(r1) == false) goto L11;
        log("getPreferredMainDevice: The connected DUAL mode device");
        return r1;
    L11:
        LocalBluetoothProfileManager r2 = this.mBtManager.getProfileManager();
        CachedBluetoothDeviceManager r3 = this.mBtManager.getCachedDeviceManager();
        LeAudioProfile r4 = r2.getLeAudioProfile();
        if (r4 != null) goto L14;
    L16:
        BluetoothDevice r8 = null;
    L17:
        if (r8 == null) goto L19;
        log("getPreferredMainDevice: The LeadDevice from LE profile is " + r8.getAnonymizedAddress());
    L19:
        if (r8 == null) goto L21;
        CachedBluetoothDevice r9 = r3.findDevice(r8);
    L22:
        if (r9 != null) goto L25;
        log("getPreferredMainDevice: The LeadDevice is not in the all of devices list");
    L28:
        CachedBluetoothDevice r10 = r7.stream().filter(new CsipDeviceManager$$ExternalSyntheticLambda5(this)).findFirst().orElse(null);
        if (r10 == null) goto L32;
        log("getPreferredMainDevice: One of the connected devices.");
        return r10;
    L32:
        if (r1 == null) goto L36;
        log("getPreferredMainDevice: The DUAL mode device.");
        return r1;
    L36:
        if (r7.isEmpty() == true) goto L39;
        log("getPreferredMainDevice: One of the group devices.");
        return r7.get(0);
    L25:
        if (isDeviceConnected(r9) == false) goto L28;
        log("getPreferredMainDevice: The connected LeadDevice from LE profile");
        return r9;
    L21:
        r9 = null;
        goto L22
    L14:
        if (isAtLeastT() == false) goto L16;
        r8 = r4.getConnectedGroupLeadDevice(r6);
        goto L17
    }

    static /* synthetic */ boolean lambda$getPreferredMainDevice$1(CachedBluetoothDevice r1) {
        return r1.getConnectableProfiles().stream().anyMatch(new CsipDeviceManager$$ExternalSyntheticLambda2());
    }

    static /* synthetic */ boolean lambda$getPreferredMainDevice$0(LocalBluetoothProfile r0) {
        return r0 instanceof LeAudioProfile;
    }

    static /* synthetic */ boolean lambda$getPreferredMainDevice$3(CachedBluetoothDevice r1) {
        return r1.getConnectableProfiles().stream().anyMatch(new CsipDeviceManager$$ExternalSyntheticLambda0());
    }

    static /* synthetic */ boolean lambda$getPreferredMainDevice$2(LocalBluetoothProfile r1) {
        if ((r1 instanceof A2dpProfile) == false) goto L5;
    L8:
        return true;
    L5:
        if ((r1 instanceof HeadsetProfile) == true) goto L8;
        return false;
    }

    /* JADX INFO: renamed from: lambda$getPreferredMainDevice$4$com-android-settingslib-bluetooth-CsipDeviceManager, reason: not valid java name */
    /* synthetic */ boolean m743x19bed2ef(CachedBluetoothDevice r1) {
        return isDeviceConnected(r1);
    }

    boolean addMemberDevicesIntoMainDevice(final int r8, CachedBluetoothDevice r9) {
        boolean r0 = false;
        if (r9 != null) goto L6;
        log("addMemberDevicesIntoMainDevice: No main device. Do nothing.");
        return false;
    L6:
        BluetoothDevice r1 = r9.getDevice();
        CachedBluetoothDevice r2 = findMainDevice(r9);
        if (r2 != null) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == true) goto L12;
        log("addMemberDevicesIntoMainDevice: The PreferredMainDevice have the mainDevice. Do switch relationship between the mainDeviceOfPreferredMainDevice and PreferredMainDevice");
        this.mBtManager.getEventManager().dispatchDeviceRemoved(r2);
        r2.switchMemberDeviceContent(r9);
        r2.refresh();
        this.mBtManager.getEventManager().dispatchDeviceAdded(r2);
        boolean r10 = true;
    L13:
        List r11 = (List) this.mCachedDevices.stream().filter(new CsipDeviceManager$$ExternalSyntheticLambda1(r8)).collect(Collectors.toList());
        if (r11.size() <= 1) goto L16;
        r0 = true;
    L16:
        CachedBluetoothDevice r3 = this.mBtManager.getCachedDeviceManager().findDevice(r1);
        if (r0 == false) goto L33;
        Iterator r12 = r11.iterator();
    L20:
        if (r12.hasNext() == false) goto L33;
        CachedBluetoothDevice r5 = (CachedBluetoothDevice) r12.next();
        if (r5.getDevice() == null) goto L20;
        if (r5.getDevice().equals(r1) == true) goto L20;
        Set<CachedBluetoothDevice> r13 = r5.getMemberDevice();
        Iterator<CachedBluetoothDevice> r6 = r13.iterator();
    L28:
        if (r6.hasNext() == false) goto L32;
        CachedBluetoothDevice r7 = r6.next();
        if (r7.equals(r3) == true) goto L28;
        r3.addMemberDevice(r7);
        goto L28
    L32:
        r13.clear();
        r3.addMemberDevice(r5);
        this.mCachedDevices.remove(r5);
        this.mBtManager.getEventManager().dispatchDeviceRemoved(r5);
        r10 = true;
    L33:
        if (r10 == false) goto L35;
        log("addMemberDevicesIntoMainDevice: After changed, CachedBluetoothDevice list: " + this.mCachedDevices);
    L35:
        return r10;
    L12:
        r10 = false;
        goto L13
    L9:
        r4 = false;
        goto L10
    }

    static /* synthetic */ boolean lambda$addMemberDevicesIntoMainDevice$5(int r0, CachedBluetoothDevice r1) {
        if (r1.getGroupId() != r0) goto L5;
        return true;
    L5:
        return false;
    }

    private void log(String r1) {
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, r1);
    }

    private boolean isDeviceConnected(CachedBluetoothDevice r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        BluetoothDevice r0 = r3.getDevice();
        if (r3.isConnected() == true) goto L8;
        return false;
    L8:
        if (r0.getBondState() == 12) goto L10;
        return false;
    L10:
        if (r0.isConnected() == false) goto L15;
        return true;
    L15:
        return false;
    }
}
