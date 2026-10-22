package com.android.settingslib.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanFilter;
import android.content.Context;
import android.icu.text.DateFormat;
import com.GlobalProxyLancet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class CachedBluetoothDeviceManager {
    private static final boolean DEBUG = true;
    private static final String TAG = "CachedBluetoothDeviceManager";
    static int sLateBondingTimeoutMillis = 5000;
    private final LocalBluetoothManager mBtManager;
    final List<CachedBluetoothDevice> mCachedDevices;
    private Context mContext;
    CsipDeviceManager mCsipDeviceManager;
    int mGroupIdOfLateBonding;
    HearingAidDeviceManager mHearingAidDeviceManager;
    boolean mIsLateBonding;
    BluetoothDevice mOngoingSetMemberPair;

    static {
    }

    public CachedBluetoothDeviceManager(Context r3, LocalBluetoothManager r4) {
        ArrayList r0 = new ArrayList();
        this.mCachedDevices = r0;
        this.mContext = r3;
        this.mBtManager = r4;
        this.mHearingAidDeviceManager = new HearingAidDeviceManager(r3, r4, r0);
        this.mCsipDeviceManager = new CsipDeviceManager(r4, r0);
    }

    public synchronized Collection<CachedBluetoothDevice> getCachedDevicesCopy() {
        monitor-enter(this);
        ArrayList r0 = new ArrayList(this.mCachedDevices);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public static boolean onDeviceDisappeared(CachedBluetoothDevice r2) {
        r2.setJustDiscovered(false);
        if (r2.getBondState() != 10) goto L6;
        return true;
    L6:
        return false;
    }

    public void onDeviceNameUpdated(BluetoothDevice r1) {
        CachedBluetoothDevice r0 = findDevice(r1);
        if (r0 == null) goto L6;
        r0.refreshName();
        return;
    }

    public synchronized CachedBluetoothDevice findDevice(BluetoothDevice r6) {
        monitor-enter(this);
        Iterator<CachedBluetoothDevice> r0 = this.mCachedDevices.iterator();     // Catch: Throwable -> L28
    L4:
        if (r0.hasNext() == false) goto L25;
        CachedBluetoothDevice r1 = r0.next();     // Catch: Throwable -> L28
        if (r1.getDevice().equals(r6) == true) goto L8;
        HashSet r2 = new HashSet(r1.getMemberDevice());     // Catch: Throwable -> L28
        if (r2.isEmpty() == true) goto L19;
        Iterator r3 = r2.iterator();     // Catch: Throwable -> L28
    L14:
        if (r3.hasNext() == false) goto L19;
        CachedBluetoothDevice r4 = (CachedBluetoothDevice) r3.next();     // Catch: Throwable -> L28
        if (r4.getDevice().equals(r6) == false) goto L14;
        monitor-exit(this);
        return r4;
    L19:
        CachedBluetoothDevice r5 = r1.getSubDevice();     // Catch: Throwable -> L28
        if (r5 == null) goto L4;
        if (r5.getDevice().equals(r6) == false) goto L4;
        monitor-exit(this);
        return r5;
    L8:
        monitor-exit(this);
        return r1;
    L25:
        monitor-exit(this);
        return null;
    L28:
        th = move-exception;
        throw th;
    }

    public CachedBluetoothDevice addDevice(BluetoothDevice r2) {
        return addDevice(r2, null);
    }

    public CachedBluetoothDevice addDevice(BluetoothDevice r4, List<ScanFilter> r5) {
        LocalBluetoothProfileManager r0 = this.mBtManager.getProfileManager();
        monitor-enter(this);
        CachedBluetoothDevice r1 = findDevice(r4);     // Catch: Throwable -> L13
        if (r1 != null) goto L11;
        r1 = new CachedBluetoothDevice(this.mContext, r0, r4);     // Catch: Throwable -> L13
        this.mCsipDeviceManager.initCsipDeviceIfNeeded(r1);     // Catch: Throwable -> L13
        this.mHearingAidDeviceManager.initHearingAidDeviceIfNeeded(r1, r5);     // Catch: Throwable -> L13
        if (this.mCsipDeviceManager.setMemberDeviceIfNeeded(r1) == true) goto L11;
        if (this.mHearingAidDeviceManager.setSubDeviceIfNeeded(r1) == true) goto L11;
        this.mCachedDevices.add(r1);     // Catch: Throwable -> L13
        this.mBtManager.getEventManager().dispatchDeviceAdded(r1);     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);     // Catch: Throwable -> L13
        return r1;
    L13:
        th = move-exception;
        throw th;
    }

    public synchronized String getSubDeviceSummary(CachedBluetoothDevice r4) {
        monitor-enter(this);
        Set<CachedBluetoothDevice> r0 = r4.getMemberDevice();     // Catch: Throwable -> L23
        if (r0.isEmpty() == true) goto L13;
        Iterator<CachedBluetoothDevice> r1 = r0.iterator();     // Catch: Throwable -> L23
    L7:
        if (r1.hasNext() == false) goto L13;
        CachedBluetoothDevice r2 = r1.next();     // Catch: Throwable -> L23
        if (r2.isConnected() == false) goto L7;
        String r5 = r2.getConnectionSummary();     // Catch: Throwable -> L23
        monitor-exit(this);
        return r5;
    L13:
        CachedBluetoothDevice r6 = r4.getSubDevice();     // Catch: Throwable -> L23
        if (r6 != null) goto L16;
    L20:
        monitor-exit(this);
        return null;
    L16:
        if (r6.isConnected() == false) goto L20;
        String r7 = r6.getConnectionSummary();     // Catch: Throwable -> L23
        monitor-exit(this);
        return r7;
    L23:
        th = move-exception;
        throw th;
    }

    public synchronized void syncDeviceWithinHearingAidSetIfNeeded(CachedBluetoothDevice r2, int r3, int r4) {
        monitor-enter(this);
        if (r4 == 28) goto L10;
        if (r4 == 21) goto L10;
        if (r4 == 25) goto L10;
    L16:
        monitor-exit(this);
        return;
    L10:
        if (r3 != 2) goto L16;
        this.mHearingAidDeviceManager.syncDeviceIfNeeded(r2);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public synchronized boolean isSubDevice(BluetoothDevice r6) {
        monitor-enter(this);
        Iterator<CachedBluetoothDevice> r0 = this.mCachedDevices.iterator();     // Catch: Throwable -> L26
    L4:
        if (r0.hasNext() == false) goto L23;
        CachedBluetoothDevice r1 = r0.next();     // Catch: Throwable -> L26
        if (r1.getDevice().equals(r6) == true) goto L4;
        Set<CachedBluetoothDevice> r2 = r1.getMemberDevice();     // Catch: Throwable -> L26
        if (r2.isEmpty() == false) goto L10;
        CachedBluetoothDevice r3 = r1.getSubDevice();     // Catch: Throwable -> L26
        if (r3 == null) goto L4;
        if (r3.getDevice().equals(r6) == false) goto L4;
        monitor-exit(this);
        return true;
    L10:
        Iterator<CachedBluetoothDevice> r4 = r2.iterator();     // Catch: Throwable -> L26
    L12:
        if (r4.hasNext() == false) goto L4;
        if (r4.next().getDevice().equals(r6) == false) goto L12;
        monitor-exit(this);
        return true;
    L23:
        monitor-exit(this);
        return false;
    L26:
        th = move-exception;
        throw th;
    }

    public synchronized void updateHearingAidsDevices() {
        monitor-enter(this);
        this.mHearingAidDeviceManager.updateHearingAidsDevices();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void updateCsipDevices() {
        monitor-enter(this);
        this.mCsipDeviceManager.updateCsipDevices();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public String getName(BluetoothDevice r3) {
        if (isOngoingPairByCsip(r3) == false) goto L10;
        CachedBluetoothDevice r0 = this.mCsipDeviceManager.getFirstMemberDevice(this.mGroupIdOfLateBonding);
        if (r0 == null) goto L10;
        if (r0.getName() == null) goto L10;
        return r0.getName();
    L10:
        CachedBluetoothDevice r2 = findDevice(r3);
        if (r2 != null) goto L13;
    L16:
        String r4 = r3.getAlias();
        if (r4 == null) goto L20;
        return r4;
    L20:
        return r3.getAddress();
    L13:
        if (r2.getName() == null) goto L16;
        return r2.getName();
    }

    public synchronized void clearNonBondedDevices() {
        monitor-enter(this);
        clearNonBondedSubDevices();     // Catch: Throwable -> L6
        final ArrayList r0 = new ArrayList();     // Catch: Throwable -> L6
        this.mCachedDevices.stream().filter(new CachedBluetoothDeviceManager$$ExternalSyntheticLambda1()).forEach(new CachedBluetoothDeviceManager$$ExternalSyntheticLambda2(r0));     // Catch: Throwable -> L6
        this.mCachedDevices.removeAll(r0);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ boolean lambda$clearNonBondedDevices$0(CachedBluetoothDevice r1) {
        if (r1.getBondState() != 10) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ void lambda$clearNonBondedDevices$1(List r0, CachedBluetoothDevice r1) {
        r1.release();
        r0.add(r1);
    }

    private void clearNonBondedSubDevices() {
        int r0 = this.mCachedDevices.size() - 1;
    L3:
        if (r0 < 0) goto L19;
        CachedBluetoothDevice r1 = this.mCachedDevices.get(r0);
        Set<CachedBluetoothDevice> r2 = r1.getMemberDevice();
        if (r2.isEmpty() == false) goto L6;
        CachedBluetoothDevice r3 = r1.getSubDevice();
        if (r3 == null) goto L18;
        if (r3.getDevice().getBondState() != 10) goto L18;
        r3.release();
        r1.setSubDevice(null);
    L18:
        r0 = r0 - 1;
        goto L3
    L6:
        Object[] r6 = r2.toArray();
        int r4 = r6.length;
        int r5 = 0;
    L7:
        if (r5 >= r4) goto L12;
        CachedBluetoothDevice r7 = (CachedBluetoothDevice) r6[r5];
        if (r7.getDevice().getBondState() != 10) goto L11;
        r1.removeMemberDevice(r7);
    L11:
        r5 = r5 + 1;
        goto L7
    L12:
        return;
    }

    public synchronized void clearAllDevices() {
        monitor-enter(this);
        int r0 = this.mCachedDevices.size() - 1;     // Catch: Throwable -> L9
    L4:
        if (r0 < 0) goto L7;
        CachedBluetoothDevice r1 = this.mCachedDevices.get(r0);     // Catch: Throwable -> L9
        this.mCachedDevices.remove(r0);     // Catch: Throwable -> L9
        r0 = r0 - 1;
        goto L4
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized void onScanningStateChanged(boolean r5) {
        monitor-enter(this);
        if (r5 == true) goto L26;
        monitor-exit(this);
        return;
    L26:
        int r6 = this.mCachedDevices.size() - 1;     // Catch: Throwable -> L23
    L7:
        if (r6 < 0) goto L21;
        CachedBluetoothDevice r0 = this.mCachedDevices.get(r6);     // Catch: Throwable -> L23
        r0.setJustDiscovered(false);     // Catch: Throwable -> L23
        Set<CachedBluetoothDevice> r2 = r0.getMemberDevice();     // Catch: Throwable -> L23
        if (r2.isEmpty() == false) goto L10;
        CachedBluetoothDevice r1 = r0.getSubDevice();     // Catch: Throwable -> L23
        if (r1 == null) goto L20;
        r1.setJustDiscovered(false);     // Catch: Throwable -> L23
    L20:
        r6 = r6 - 1;
        goto L7
    L10:
        Iterator<CachedBluetoothDevice> r7 = r2.iterator();     // Catch: Throwable -> L23
    L11:
        if (r7.hasNext() == false) goto L15;
        r7.next().setJustDiscovered(false);     // Catch: Throwable -> L23
        goto L11
    L15:
        monitor-exit(this);
        return;
    L21:
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public synchronized void onBluetoothStateChanged(int r8) {
        monitor-enter(this);
        if (r8 == 13) goto L32;
    L30:
        monitor-exit(this);
        return;
    L32:
        int r9 = this.mCachedDevices.size() - 1;     // Catch: Throwable -> L27
    L7:
        if (r9 < 0) goto L25;
        CachedBluetoothDevice r3 = this.mCachedDevices.get(r9);     // Catch: Throwable -> L27
        Set<CachedBluetoothDevice> r4 = r3.getMemberDevice();     // Catch: Throwable -> L27
        if (r4.isEmpty() == true) goto L16;
        Iterator<CachedBluetoothDevice> r1 = r4.iterator();     // Catch: Throwable -> L27
    L12:
        if (r1.hasNext() == false) goto L22;
        CachedBluetoothDevice r5 = r1.next();     // Catch: Throwable -> L27
        if (r5.getBondState() == 12) goto L12;
        r3.removeMemberDevice(r5);     // Catch: Throwable -> L27
    L22:
        if (r3.getBondState() == 12) goto L24;
        r3.setJustDiscovered(false);     // Catch: Throwable -> L27
        r3.release();     // Catch: Throwable -> L27
        this.mCachedDevices.remove(r9);     // Catch: Throwable -> L27
    L24:
        r3.mTwspBatteryState = -1;     // Catch: Throwable -> L27
        r3.mTwspBatteryLevel = -1;     // Catch: Throwable -> L27
        r9 = r9 - 1;     // Catch: Throwable -> L27
        goto L7
    L16:
        CachedBluetoothDevice r6 = r3.getSubDevice();     // Catch: Throwable -> L27
        if (r6 == null) goto L22;
        if (r6.getBondState() == 12) goto L22;
        r3.setSubDevice(null);     // Catch: Throwable -> L27
        goto L22
    L25:
        this.mOngoingSetMemberPair = null;     // Catch: Throwable -> L27
        this.mIsLateBonding = false;     // Catch: Throwable -> L27
        this.mGroupIdOfLateBonding = -1;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    synchronized void removeDuplicateInstanceForIdentityAddress(BluetoothDevice r3) {
        monitor-enter(this);
        final String r0 = r3.getIdentityAddress();     // Catch: Throwable -> L13
        if (r0 != null) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (r0.equals(r3.getAddress()) == true) goto L11;
        this.mCachedDevices.removeIf(new CachedBluetoothDeviceManager$$ExternalSyntheticLambda0(r0));     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ boolean lambda$removeDuplicateInstanceForIdentityAddress$2(String r2, CachedBluetoothDevice r3) {
        boolean r4 = r3.getDevice().getAddress().equals(r2);
        if (r4 == false) goto L5;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Remove instance for identity address " + r3);
    L5:
        return r4;
    }

    public synchronized boolean onProfileConnectionStateChangedIfProcessed(CachedBluetoothDevice r2, int r3, int r4) {
        monitor-enter(this);
        if (r4 != 21) goto L11;
        boolean r5 = this.mHearingAidDeviceManager.onProfileConnectionStateChangedIfProcessed(r2, r3);     // Catch: Throwable -> L8
        monitor-exit(this);
        return r5;
    L11:
        if (r4 != 1) goto L13;
    L22:
        boolean r6 = this.mCsipDeviceManager.onProfileConnectionStateChangedIfProcessed(r2, r3);     // Catch: Throwable -> L8
        monitor-exit(this);
        return r6;
    L13:
        if (r4 == 2) goto L22;
        if (r4 == 22) goto L22;
        if (r4 == 25) goto L22;
        monitor-exit(this);
        return false;
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized void onActiveDeviceChanged(CachedBluetoothDevice r2) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (r2.isHearingAidDevice() == false) goto L6;
        this.mHearingAidDeviceManager.onActiveDeviceChanged(r2);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public synchronized void onDeviceUnpaired(CachedBluetoothDevice r5) {
        monitor-enter(this);
        r5.setGroupId(-1);     // Catch: Throwable -> L19
        CachedBluetoothDevice r1 = this.mCsipDeviceManager.findMainDevice(r5);     // Catch: Throwable -> L19
        HashSet r2 = new HashSet(r5.getMemberDevice());     // Catch: Throwable -> L19
        if (r2.isEmpty() == true) goto L10;
        Iterator r3 = r2.iterator();     // Catch: Throwable -> L19
    L8:
        if (r3.hasNext() == false) goto L12;
        CachedBluetoothDevice r4 = (CachedBluetoothDevice) r3.next();     // Catch: Throwable -> L19
        r4.unpair();     // Catch: Throwable -> L19
        r4.setGroupId(-1);     // Catch: Throwable -> L19
        r5.removeMemberDevice(r4);     // Catch: Throwable -> L19
    L12:
        CachedBluetoothDevice r0 = this.mHearingAidDeviceManager.findMainDevice(r5);     // Catch: Throwable -> L19
        CachedBluetoothDevice r6 = r5.getSubDevice();     // Catch: Throwable -> L19
        if (r6 == null) goto L15;
        r6.unpair();     // Catch: Throwable -> L19
        r5.setSubDevice(null);     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);
        return;
    L15:
        if (r0 == null) goto L17;
        r0.unpair();     // Catch: Throwable -> L19
        r0.setSubDevice(null);     // Catch: Throwable -> L19
        goto L17
    L10:
        if (r1 == null) goto L12;
        r1.unpair();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    private synchronized boolean shouldPairByCsip(BluetoothDevice r8, int r9) {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.mOngoingSetMemberPair == null) goto L7;
        boolean r1 = true;
    L8:
        int r10 = r8.getBondState();     // Catch: Throwable -> L18
        boolean r4 = this.mCsipDeviceManager.isExistedGroupId(r9);     // Catch: Throwable -> L18
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "isOngoingSetMemberPair=" + r1 + ", bondState=" + r10 + ", groupExists=" + r4 + ", groupId=" + r9);     // Catch: Throwable -> L18
        if (r1 == false) goto L11;
    L16:
        monitor-exit(this);
        return false;
    L11:
        if (r10 != 10) goto L16;
        if (r4 == false) goto L16;
        monitor-exit(this);
        return true;
    L7:
        r1 = false;
        goto L8
    }

    private synchronized boolean checkLateBonding(int r9) {
        monitor-enter(this);
        CachedBluetoothDevice r2 = this.mCsipDeviceManager.getFirstMemberDevice(r9);     // Catch: Throwable -> L20
        boolean r3 = false;
        if (r2 != null) goto L9;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "No first device in group: " + r9);     // Catch: Throwable -> L20
        monitor-exit(this);
        return false;
    L9:
        Timestamp r10 = r2.getBondTimestamp();     // Catch: Throwable -> L20
        if (r10 != null) goto L14;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "No bond timestamp");     // Catch: Throwable -> L20
        monitor-exit(this);
        return true;
    L14:
        long r4 = new Timestamp(System.currentTimeMillis()).getTime() - r10.getTime();     // Catch: Throwable -> L20
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Time difference to first bonding: " + r4 + DateFormat.MINUTE_SECOND);     // Catch: Throwable -> L20
        if (r4 <= sLateBondingTimeoutMillis) goto L18;
        r3 = true;
    L18:
        monitor-exit(this);
        return r3;
    L20:
        th = move-exception;
        throw th;
    }

    public synchronized boolean isLateBonding(BluetoothDevice r3) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (isOngoingPairByCsip(r3) == true) goto L10;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "isLateBonding: pair not ongoing or not matching device");     // Catch: Throwable -> L13
        monitor-exit(this);
        return false;
    L10:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "isLateBonding: " + this.mIsLateBonding);     // Catch: Throwable -> L13
        boolean r4 = this.mIsLateBonding;     // Catch: Throwable -> L13
        monitor-exit(this);
        return r4;
    }

    public synchronized void pairDeviceByCsip(BluetoothDevice r4, int r5) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (shouldPairByCsip(r4, r5) == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Bond " + r4.getAnonymizedAddress() + " groupId=" + r5 + " by CSIP ");     // Catch: Throwable -> L13
        this.mOngoingSetMemberPair = r4;     // Catch: Throwable -> L13
        this.mIsLateBonding = checkLateBonding(r5);     // Catch: Throwable -> L13
        this.mGroupIdOfLateBonding = r5;     // Catch: Throwable -> L13
        syncConfigFromMainDevice(r4, r5);     // Catch: Throwable -> L13
        if (r4.createBond(2) == true) goto L11;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Bonding could not be started");     // Catch: Throwable -> L13
        this.mOngoingSetMemberPair = null;     // Catch: Throwable -> L13
        this.mIsLateBonding = false;     // Catch: Throwable -> L13
        this.mGroupIdOfLateBonding = -1;     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
    }

    private void syncConfigFromMainDevice(BluetoothDevice r3, int r4) {
        if (isOngoingPairByCsip(r3) == true) goto L5;
        return;
    L5:
        CachedBluetoothDevice r0 = findDevice(r3);
        CachedBluetoothDevice r1 = this.mCsipDeviceManager.findMainDevice(r0);
        if (r1 != null) goto L8;
        r1 = this.mCsipDeviceManager.getCachedDevice(r4);
    L8:
        if (r1 != null) goto L10;
    L14:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "no mainDevice");
        return;
    L10:
        if (r1.equals(r0) == true) goto L14;
        r3.setPhonebookAccessPermission(r1.getDevice().getPhonebookAccessPermission());
    }

    public synchronized boolean onBondStateChangedIfProcess(BluetoothDevice r4, int r5) {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (isOngoingPairByCsip(r4) == true) goto L9;
        monitor-exit(this);
        return false;
    L9:
        if (r5 != 11) goto L13;
        monitor-exit(this);
        return true;
    L13:
        this.mOngoingSetMemberPair = null;     // Catch: Throwable -> L20
        this.mIsLateBonding = false;     // Catch: Throwable -> L20
        this.mGroupIdOfLateBonding = -1;     // Catch: Throwable -> L20
        if (r5 != 10) goto L16;
    L18:
        monitor-exit(this);
        return true;
    L16:
        if (findDevice(r4) != null) goto L18;
        LocalBluetoothProfileManager r6 = this.mBtManager.getProfileManager();     // Catch: Throwable -> L20
        CachedBluetoothDevice r0 = new CachedBluetoothDevice(this.mContext, r6, r4);     // Catch: Throwable -> L20
        this.mCachedDevices.add(r0);     // Catch: Throwable -> L20
        findDevice(r4).connect();     // Catch: Throwable -> L20
        goto L18
    }

    public boolean isOngoingPairByCsip(BluetoothDevice r1) {
        BluetoothDevice r0 = this.mOngoingSetMemberPair;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.equals(r1) == false) goto L7;
        return true;
    }

    private void log(String r1) {
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, r1);
    }
}
