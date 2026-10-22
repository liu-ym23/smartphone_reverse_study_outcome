package com.android.settings.bluetooth;

import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.ParcelUuid;
import android.os.SystemClock;
import android.text.TextUtils;
import com.android.settings.AdaptBluetoothDevice;
import com.android.settings.MultiSDKAdapter;
import com.android.settings.utils.SLog;
import com.obric.cae.libs.bluetooth.CaeBluetoothDeviceManager;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import obric.tablet.widget.BytedanceJustifyTextView;

/* JADX INFO: loaded from: classes2.dex */
public final class CachedBluetoothDevice implements Comparable<CachedBluetoothDevice> {
    private static final String A2DP_ABS_PREFS_NAME = "a2dp_abs_status";
    static final int ACCESS_ALLOWED = 1;
    static final int ACCESS_REJECTED = 2;
    static final int ACCESS_UNKNOWN = 0;
    private static final int BT_UNPAIR_DEVICE = 0;
    private static final long MAX_UUID_DELAY_FOR_AUTO_CONNECT = 5000;
    private static final String MESSAGE_PREFS_NAME = "bluetooth_message_permission";
    private static final String MESSAGE_REJECT_TIMES = "bluetooth_message_reject";
    static final int PERSIST_REJECTED_TIMES_LIMIT = 2;
    private static final String PHONEBOOK_PREFS_NAME = "bluetooth_phonebook_permission";
    private static final String PHONEBOOK_REJECT_TIMES = "bluetooth_phonebook_reject";
    private static final int RSSI_SORT_BUCKET_SIZE = 4;
    private static final String TAG = "CachedBluetoothDevice";
    private boolean mAbsStatus;
    private int mAudioCodec;
    private int mBondState;
    private BluetoothClass mBtClass;
    private final Collection<Callback> mCallbacks;
    private boolean mConnectAfterPairing;
    private long mConnectAttempted;
    private final Context mContext;
    private final BluetoothDevice mDevice;
    private boolean mDeviceRemove;
    private String mFoundName;
    private boolean mIsConnectingErrorPossible;
    private final LocalBluetoothAdapter mLocalAdapter;
    private boolean mLocalNapRoleConnected;
    private int mMessagePermissionChoice;
    private int mMessageRejectedTimes;
    private String mName;
    private int mPhonebookPermissionChoice;
    private int mPhonebookRejectedTimes;
    private HashMap<LocalBluetoothProfile, Integer> mProfileConnectionState;
    private final LocalBluetoothProfileManager mProfileManager;
    private final List<LocalBluetoothProfile> mProfiles;
    private final List<LocalBluetoothProfile> mRemovedProfiles;
    short mRssi;
    private final Handler mUnpairHandler;
    private boolean mVisible;
    private int productId;

    public interface Callback {
        void onDeviceAttributesChanged(boolean r1);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(CachedBluetoothDevice r1) {
        return compareTo2(r1);
    }

    private String describe(LocalBluetoothProfile r3) {
        StringBuilder r0 = new StringBuilder("Address:");
        r0.append(this.mDevice);
        if (r3 == null) goto L6;
        r0.append(" Profile:").append(r3);
    L6:
        return r0.toString();
    }

    void onProfileStateChanged(LocalBluetoothProfile r5, int r6) {
        OLog.d(TAG, "onProfileStateChanged: profile " + r5 + " newProfileState " + r6);
        if (this.mLocalAdapter.getBluetoothState() != 13) goto L8;
        OLog.d(TAG, " BT Turninig Off...Profile conn state change ignored...");
        HashMap<LocalBluetoothProfile, Integer> r4 = this.mProfileConnectionState;
        if (r4 == null) goto L36;
        r4.put(r5, 0);
        return;
    L36:
        return;
    L8:
        this.mProfileConnectionState.put(r5, Integer.valueOf(r6));
        if (r6 != 2) goto L21;
        if (this.mProfiles.contains(r5) == true) goto L18;
        this.mRemovedProfiles.remove(r5);
        this.mProfiles.add(r5);
        if ((r5 instanceof PanProfile) == false) goto L18;
        if (((PanProfile) r5).isLocalRoleNap(this.mDevice) == false) goto L18;
        this.mLocalNapRoleConnected = true;
    L18:
        if ((r5 instanceof MapProfile) == false) goto L37;
        r5.setPreferred(this.mDevice, true);
        return;
    L37:
        return;
    L21:
        if ((r5 instanceof MapProfile) == false) goto L28;
        if (r6 != 0) goto L28;
        if (this.mProfiles.contains(r5) == false) goto L26;
        this.mRemovedProfiles.add(r5);
        this.mProfiles.remove(r5);
    L26:
        r5.setPreferred(this.mDevice, false);
        return;
    L28:
        if (this.mLocalNapRoleConnected == true) goto L30;
        return;
    L30:
        if ((r5 instanceof PanProfile) == true) goto L32;
        return;
    L32:
        if (((PanProfile) r5).isLocalRoleNap(this.mDevice) == false) goto L42;
        if (r6 != 0) goto L43;
        OLog.d(TAG, "Removing PanProfile from device after NAP disconnect");
        this.mProfiles.remove(r5);
        this.mRemovedProfiles.add(r5);
        this.mLocalNapRoleConnected = false;
        return;
    L43:
        return;
    }

    CachedBluetoothDevice(Context r2, LocalBluetoothAdapter r3, LocalBluetoothProfileManager r4, BluetoothDevice r5, String r6) {
        this.productId = -1;
        this.mBondState = 10;
        this.mProfileConnectionState = new HashMap();
        this.mProfiles = new ArrayList();
        this.mRemovedProfiles = new ArrayList();
        this.mCallbacks = new ArrayList();
        this.mAbsStatus = true;
        this.mUnpairHandler = new AnonymousClass1(this);
        this.mContext = r2;
        this.mLocalAdapter = r3;
        this.mProfileManager = r4;
        this.mDevice = r5;
        this.mFoundName = r6;
        fillData();
    }

    void disconnect() {
        this.mDevice.disconnect();
        PbapServerProfile r0 = this.mProfileManager.getPbapProfile();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getConnectionStatus(this.mDevice) != 2) goto L9;
        r0.disconnect(this.mDevice);
        return;
    }

    void disconnect(LocalBluetoothProfile r3) {
        if (r3.disconnect(this.mDevice) == false) goto L6;
        OLog.d(TAG, "Command sent successfully:DISCONNECT " + describe(r3));
        return;
    }

    void connect(boolean r3) {
        if (ensurePaired() == true) goto L5;
        return;
    L5:
        this.mConnectAttempted = SystemClock.elapsedRealtime();
        connectWithoutResettingTimer(r3);
    }

    void onBondingDockConnect() {
        connect(false);
    }

    private void connectWithoutResettingTimer(boolean r6) {
        if (this.mProfiles.isEmpty() == false) goto L10;
        OLog.d(TAG, "No profiles. Maybe we will connect later");
        this.mDevice.connect();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        OLog.e(TAG, "Failed to connect to device", e);
        return;
    L10:
        this.mIsConnectingErrorPossible = true;
        Iterator<LocalBluetoothProfile> r0 = this.mProfiles.iterator();
        int r2 = 0;
    L12:
        if (r0.hasNext() == false) goto L23;
        LocalBluetoothProfile r3 = r0.next();
        if (r6 == true) goto L16;
        if (r3.isAutoConnectable() == false) goto L12;
    L21:
        if (r3.isPreferred(this.mDevice) == false) goto L12;
        r2 = r2 + 1;
        connectInt(r3);
        goto L12
    L16:
        if (r3.isConnectable() == false) goto L12;
    L23:
        OLog.d(TAG, "Preferred profiles = " + r2);
        if (r2 != 0) goto L41;
        connectAutoConnectableProfiles();
        return;
    }

    private void connectAutoConnectableProfiles() {
        if (ensurePaired() == true) goto L5;
        return;
    L5:
        this.mIsConnectingErrorPossible = true;
        Iterator<LocalBluetoothProfile> r1 = this.mProfiles.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        LocalBluetoothProfile r2 = r1.next();
        if (r2.isAutoConnectable() == false) goto L7;
        r2.setPreferred(this.mDevice, true);
        connectInt(r2);
        goto L7
    }

    void connectProfile(LocalBluetoothProfile r3) {
        this.mConnectAttempted = SystemClock.elapsedRealtime();
        this.mIsConnectingErrorPossible = true;
        connectInt(r3);
        refresh();
    }

    synchronized void connectInt(LocalBluetoothProfile r4) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (ensurePaired() == true) goto L9;
        monitor-exit(this);
        return;
    L9:
        if (r4.connect(this.mDevice) == false) goto L13;
        OLog.d(TAG, "Command sent successfully:CONNECT " + describe(r4));     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L13:
        OLog.i(TAG, "Failed to connect " + r4.toString() + " to " + this.mName);     // Catch: Throwable -> L16
        monitor-exit(this);
    }

    private boolean ensurePaired() {
        if (getBondState() != 10) goto L6;
        startPairing();
        return false;
    L6:
        return true;
    }

    boolean startPairing() {
        if (this.mLocalAdapter.isDiscovering() == false) goto L6;
        this.mLocalAdapter.cancelDiscovery();
    L6:
        if (this.mDevice.createBond() == true) goto L9;
        return false;
    L9:
        this.mConnectAfterPairing = true;
        return true;
    }

    boolean isUserInitiatedPairing() {
        return this.mConnectAfterPairing;
    }

    void unpairDevice() {
        boolean r0 = isConnected();
        if (r0 == false) goto L5;
        disconnect();
    L5:
        Handler r3 = this.mUnpairHandler;
        if (r0 == false) goto L8;
        long r1 = 2000;
    L9:
        r3.sendEmptyMessageDelayed(0, r1);
        return;
    L8:
        r1 = 0;
        goto L9
    }

    void unpair() {
        int r0 = getBondState();
        if (r0 != 11) goto L6;
        this.mDevice.cancelBondProcess();
    L6:
        if (r0 == 10) goto L11;
        BluetoothDevice r2 = this.mDevice;
        if (r2 == null) goto L12;
        r2.removeBond();
        return;
    L12:
        return;
    }

    int getProfileConnectionState(LocalBluetoothProfile r3) {
        if (this.mProfileConnectionState.get(r3) != null) goto L6;
        int r0 = r3.getConnectionStatus(this.mDevice);
        this.mProfileConnectionState.put(r3, Integer.valueOf(r0));
    L6:
        return this.mProfileConnectionState.get(r3).intValue();
    }

    public void clearProfileConnectionState() {
        OLog.d(TAG, " Clearing all connection state for dev:" + this.mDevice.getName());
        Iterator<LocalBluetoothProfile> r0 = getProfiles().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        this.mProfileConnectionState.put(r0.next(), 0);
        goto L4
    }

    private void fillData() {
        fetchName();
        fetchBtClass();
        fetchBondState();
        updateProfiles();
        fetchPhonebookPermissionChoice();
        fetchMessagePermissionChoice();
        fetchPhonebookRejectTimes();
        fetchMessageRejectTimes();
        fetchAbsStatus();
        this.mVisible = false;
        this.mAudioCodec = -1;
        dispatchAttributesChanged();
    }

    private void fetchBondState() {
        this.mBondState = this.mDevice.getBondState();
    }

    BluetoothDevice getDevice() {
        return this.mDevice;
    }

    public String getName() {
        return this.mName;
    }

    void setName(String r2) {
        String r0 = this.mFoundName;
        if (r0 == null) goto L7;
        if (r0.equals(r2) == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r2) == true) goto L10;
        this.mFoundName = r2;
    L10:
        if (TextUtils.isEmpty(this.mFoundName) == false) goto L12;
        this.mFoundName = this.mDevice.getAddress();
    L12:
        dispatchAttributesChanged();
        refreshName();
    }

    public void setAliasName(String r2) {
        if (this.mName.equals(r2) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r2) == true) goto L7;
        this.mName = r2;
        this.mDevice.setAlias(r2);
    L7:
        dispatchAttributesChanged();
    }

    void refreshName() {
        fetchName();
        dispatchAttributesChanged();
    }

    private void fetchName() {
        String r0 = AdaptBluetoothDevice.getDeviceAliasName(this.mDevice);
        if (TextUtils.isEmpty(r0) == false) goto L6;
        r0 = this.mDevice.getName();
    L6:
        if (TextUtils.isEmpty(r0) == true) goto L9;
        this.mName = r0;
    L9:
        if (TextUtils.isEmpty(this.mName) == false) goto L14;
        if (TextUtils.isEmpty(this.mFoundName) == true) goto L14;
        this.mName = this.mFoundName;
    L14:
        if (TextUtils.isEmpty(this.mName) == false) goto L17;
        this.mName = this.mDevice.getAddress();
        SLog.d(TAG, "Device has no name (yet), use address: " + this.mName);
        return;
    }

    void refresh() {
        dispatchAttributesChanged();
    }

    boolean isVisible() {
        return this.mVisible;
    }

    boolean isRemovable() {
        return this.mDeviceRemove;
    }

    void setVisible(boolean r2) {
        if (this.mVisible == r2) goto L6;
        this.mVisible = r2;
        dispatchAttributesChanged();
        return;
    }

    void setRemovable(boolean r1) {
        this.mDeviceRemove = r1;
    }

    int getBondState() {
        return this.mDevice.getBondState();
    }

    void setRssi(short r2) {
        if (this.mRssi == r2) goto L6;
        this.mRssi = r2;
        dispatchAttributesChanged();
        return;
    }

    int getProductId() {
        return this.productId;
    }

    void setProductId(int r2) {
        if (this.productId == r2) goto L6;
        this.productId = r2;
        dispatchAttributesChanged();
        return;
    }

    boolean isConnected() {
        Iterator<LocalBluetoothProfile> r0 = this.mProfiles.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (getProfileConnectionState(r0.next()) != 2) goto L4;
        return true;
    L9:
        return false;
    }

    boolean isAclConnected() {
        BluetoothDevice r0 = this.mDevice;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isConnected() == false) goto L7;
        return true;
    }

    boolean isConnectedProfile(LocalBluetoothProfile r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (getProfileConnectionState(r2) != 2) goto L9;
        return true;
    L9:
        return false;
    }

    boolean isBusy() {
        Iterator<LocalBluetoothProfile> r0 = this.mProfiles.iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        LocalBluetoothProfile r1 = r0.next();
        int r3 = getProfileConnectionState(r1);
        int r2 = r1.getConnectionStatus(this.mDevice);
        if (r3 == 1) goto L11;
        if (r3 == 3) goto L11;
        if (r2 == 1) goto L11;
        if (r2 != 3) goto L4;
    L11:
        return true;
    L13:
        if (getBondState() == 11) goto L23;
        return false;
    L23:
        return true;
    }

    boolean isConnecting() {
        Iterator<LocalBluetoothProfile> r0 = this.mProfiles.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        LocalBluetoothProfile r1 = r0.next();
        int r2 = getProfileConnectionState(r1);
        int r3 = r1.getConnectionStatus(this.mDevice);
        if (r2 == 1) goto L8;
        if (r3 != 1) goto L4;
    L8:
        return true;
    L9:
        return false;
    }

    boolean isDisconnecting() {
        Iterator<LocalBluetoothProfile> r0 = this.mProfiles.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        LocalBluetoothProfile r1 = r0.next();
        int r2 = getProfileConnectionState(r1);
        int r3 = r1.getConnectionStatus(this.mDevice);
        if (r2 == 3) goto L8;
        if (r3 != 3) goto L4;
        return true;
    L8:
        return true;
    L10:
        return false;
    }

    private void fetchBtClass() {
        this.mBtClass = this.mDevice.getBluetoothClass();
        StringBuilder r0 = new StringBuilder("fetchBtClass: device=").append(this.mDevice.getAddress()).append(" MajorDeviceClass");
        BluetoothClass r2 = this.mBtClass;
        if (r2 != null) goto L5;
        Integer r3 = null;
    L6:
        SLog.d(TAG, r0.append(r3).toString());
        return;
    L5:
        r3 = Integer.valueOf(r2.getMajorDeviceClass());
        goto L6
    }

    private boolean updateProfiles() {
        ParcelUuid[] r0 = this.mDevice.getUuids();
        int r8 = 0;
        if (r0 != null) goto L5;
        return false;
    L5:
        ParcelUuid[] r3 = this.mLocalAdapter.getUuids();
        if (r3 != null) goto L8;
        return false;
    L8:
        this.mProfileManager.updateProfiles(r0, r3, this.mProfiles, this.mRemovedProfiles, this.mLocalNapRoleConnected, this.mDevice);
        OLog.e(TAG, "updating profiles for " + AdaptBluetoothDevice.getDeviceAliasName(this.mDevice));
        BluetoothClass r9 = this.mDevice.getBluetoothClass();
        if (r9 == null) goto L11;
        OLog.v(TAG, "Class: " + r9.toString());
    L11:
        OLog.v(TAG, "UUID:");
        int r10 = r0.length;
    L12:
        if (r8 >= r10) goto L14;
        OLog.v(TAG, BytedanceJustifyTextView.TWO_BLANK + r0[r8]);
        r8 = r8 + 1;
        goto L12
    L14:
        return true;
    }

    void refreshBtClass() {
        fetchBtClass();
        dispatchAttributesChanged();
    }

    void onUuidChanged() {
        updateProfiles();
        OLog.e(TAG, "onUuidChanged: Time since last connect" + (SystemClock.elapsedRealtime() - this.mConnectAttempted));
        if (this.mProfiles.isEmpty() == false) goto L5;
    L7:
        dispatchAttributesChanged();
        return;
    L5:
        if ((this.mConnectAttempted + 5000) <= SystemClock.elapsedRealtime()) goto L7;
        connectWithoutResettingTimer(false);
        goto L7
    }

    void onBondingStateChanged(int r4) {
        this.mBondState = r4;
        if (r4 != 10) goto L5;
        this.mProfiles.clear();
        this.mConnectAfterPairing = false;
        setPhonebookPermissionChoice(0);
        setMessagePermissionChoice(0);
        this.mPhonebookRejectedTimes = 0;
        savePhonebookRejectTimes();
        this.mMessageRejectedTimes = 0;
        saveMessageRejectTimes();
    L5:
        OLog.d(TAG, "onBondingStateChanged" + r4);
        switch(r4) {
            case 10: goto L12;
            case 11: goto L13;
            case 12: goto L9;
            default: goto L7;
        };
    L7:
        OLog.e(TAG, "Incorrect Bond State received");
        return;
    L12:
        this.mProfiles.clear();
        this.mConnectAfterPairing = false;
    L13:
        setPhonebookPermissionChoice(0);
        setMessagePermissionChoice(0);
        this.mPhonebookRejectedTimes = 0;
        savePhonebookRejectTimes();
        this.mMessageRejectedTimes = 0;
        saveMessageRejectTimes();
        refresh();
        return;
    L9:
        if (this.mConnectAfterPairing == false) goto L11;
        connect(false);
    L11:
        this.mConnectAfterPairing = false;
    }

    void setBtClass(BluetoothClass r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (this.mBtClass == r2) goto L8;
        this.mBtClass = r2;
        dispatchAttributesChanged();
        return;
    }

    BluetoothClass getBtClass() {
        return this.mBtClass;
    }

    List<LocalBluetoothProfile> getProfiles() {
        return Collections.unmodifiableList(this.mProfiles);
    }

    List<LocalBluetoothProfile> getConnectableProfiles() {
        ArrayList r0 = new ArrayList();
        Iterator<LocalBluetoothProfile> r3 = this.mProfiles.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        LocalBluetoothProfile r1 = r3.next();
        if (r1.isConnectable() == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        return r0;
    }

    List<LocalBluetoothProfile> getRemovedProfiles() {
        return this.mRemovedProfiles;
    }

    void registerCallback(Callback r2) {
        Collection<Callback> r0 = this.mCallbacks;
        monitor-enter(r0);
        this.mCallbacks.add(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void unregisterCallback(Callback r3) {
        Collection<Callback> r0 = this.mCallbacks;
        monitor-enter(r0);
        if (r3 != null) goto L16;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L16:
    L13:
        th = move-exception;
        throw th;
    L6:
        if (this.mCallbacks.isEmpty() == true) goto L11;
        this.mCallbacks.remove(r3);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    private void dispatchAttributesChanged() {
        Collection<Callback> r0 = this.mCallbacks;
        monitor-enter(r0);
        Iterator<Callback> r3 = this.mCallbacks.iterator();     // Catch: Throwable -> L10
    L6:
        if (r3.hasNext() == false) goto L8;
        r3.next().onDeviceAttributesChanged(false);     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public String toString() {
        return this.mDevice.toString();
    }

    public boolean equals(Object r2) {
        if (r2 != null) goto L4;
        return false;
    L4:
        if ((r2 instanceof CachedBluetoothDevice) == true) goto L7;
        return false;
    L7:
        return this.mDevice.equals(((CachedBluetoothDevice) r2).mDevice);
    }

    public int hashCode() {
        return this.mDevice.getAddress().hashCode();
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(CachedBluetoothDevice r6) {
        if (r6 != null) goto L5;
        return -1;
    L5:
        int r0 = (BluetoothUtils.isActiveDevice(r6.getDevice()) ? 1 : 0) - (BluetoothUtils.isActiveDevice(getDevice()) ? 1 : 0);
        if (r0 == 0) goto L8;
        return r0;
    L8:
        int r1 = (r6.isAclConnected() ? 1 : 0) - (isAclConnected() ? 1 : 0);
        if (r1 == 0) goto L11;
        return r1;
    L11:
        int r2 = 1;
        if (r6.getBondState() != 12) goto L14;
        int r3 = 1;
    L16:
        if (getBondState() == 12) goto L19;
        r2 = 0;
    L19:
        int r4 = r3 - r2;
        if (r4 == 0) goto L22;
        return r4;
    L22:
        int r5 = r6.getRssiSortBucket() - getRssiSortBucket();
        if (r5 == 0) goto L25;
        return r5;
    L25:
        int r7 = getCompareName().compareTo(r6.getCompareName());
        if (r7 == 0) goto L29;
        return r7;
    L29:
        return getCompareAddress().compareTo(r6.getCompareAddress());
    L14:
        r3 = 0;
        goto L16
    }

    private int getRssiSortBucket() {
        return this.mRssi / 4;
    }

    private String getCompareName() {
        if (TextUtils.isEmpty(this.mName) == false) goto L5;
        BluetoothDevice r0 = this.mDevice;
        if (r0 != null) goto L9;
        return "";
    L9:
        if (TextUtils.isEmpty(r0.getName()) == false) goto L11;
        return "";
    L11:
        return this.mDevice.getName();
    L5:
        return this.mName;
    }

    private String getCompareAddress() {
        BluetoothDevice r0 = this.mDevice;
        if (r0 != null) goto L5;
        return "";
    L5:
        if (TextUtils.isEmpty(r0.getAddress()) == false) goto L7;
        return "";
    L7:
        return this.mDevice.getAddress();
    }

    int getPhonebookPermissionChoice() {
        return this.mPhonebookPermissionChoice;
    }

    void setPhonebookPermissionChoice(int r4) {
        if (r4 != 2) goto L7;
        this.mPhonebookRejectedTimes++;
        savePhonebookRejectTimes();
        if (this.mPhonebookRejectedTimes >= 2) goto L7;
        return;
    L7:
        this.mPhonebookPermissionChoice = r4;
        SharedPreferences.Editor r0 = this.mContext.getSharedPreferences(PHONEBOOK_PREFS_NAME, 0).edit();
        if (r4 != 0) goto L10;
        r0.remove(this.mDevice.getAddress());
    L11:
        r0.apply();
        return;
    L10:
        r0.putInt(this.mDevice.getAddress(), r4);
        goto L11
    }

    private void fetchPhonebookPermissionChoice() {
        this.mPhonebookPermissionChoice = this.mContext.getSharedPreferences(PHONEBOOK_PREFS_NAME, 0).getInt(this.mDevice.getAddress(), 0);
    }

    private void fetchPhonebookRejectTimes() {
        this.mPhonebookRejectedTimes = this.mContext.getSharedPreferences(PHONEBOOK_REJECT_TIMES, 0).getInt(this.mDevice.getAddress(), 0);
    }

    private void savePhonebookRejectTimes() {
        SharedPreferences.Editor r0 = this.mContext.getSharedPreferences(PHONEBOOK_REJECT_TIMES, 0).edit();
        if (this.mPhonebookRejectedTimes != 0) goto L5;
        r0.remove(this.mDevice.getAddress());
    L6:
        r0.apply();
        return;
    L5:
        r0.putInt(this.mDevice.getAddress(), this.mPhonebookRejectedTimes);
        goto L6
    }

    int getMessagePermissionChoice() {
        return this.mMessagePermissionChoice;
    }

    void setMessagePermissionChoice(int r4) {
        if (r4 != 2) goto L7;
        this.mMessageRejectedTimes++;
        saveMessageRejectTimes();
        if (this.mMessageRejectedTimes >= 2) goto L7;
        return;
    L7:
        this.mMessagePermissionChoice = r4;
        SharedPreferences.Editor r0 = this.mContext.getSharedPreferences(MESSAGE_PREFS_NAME, 0).edit();
        if (r4 != 0) goto L10;
        r0.remove(this.mDevice.getAddress());
    L11:
        r0.apply();
        return;
    L10:
        r0.putInt(this.mDevice.getAddress(), r4);
        goto L11
    }

    private void fetchMessagePermissionChoice() {
        this.mMessagePermissionChoice = this.mContext.getSharedPreferences(MESSAGE_PREFS_NAME, 0).getInt(this.mDevice.getAddress(), 0);
    }

    private void fetchMessageRejectTimes() {
        this.mMessageRejectedTimes = this.mContext.getSharedPreferences(MESSAGE_REJECT_TIMES, 0).getInt(this.mDevice.getAddress(), 0);
    }

    private void saveMessageRejectTimes() {
        SharedPreferences.Editor r0 = this.mContext.getSharedPreferences(MESSAGE_REJECT_TIMES, 0).edit();
        if (this.mMessageRejectedTimes != 0) goto L5;
        r0.remove(this.mDevice.getAddress());
    L6:
        r0.apply();
        return;
    L5:
        r0.putInt(this.mDevice.getAddress(), this.mMessageRejectedTimes);
        goto L6
    }

    int getAudioCodec() {
        return this.mAudioCodec;
    }

    void setAudioCodec(int r2) {
        if (this.mAudioCodec == r2) goto L6;
        this.mAudioCodec = r2;
        return;
    }

    void setAbsStatus(boolean r1) {
        this.mAbsStatus = r1;
        saveAbsStatus();
    }

    boolean getAbsStatus() {
        boolean r0 = CaeBluetoothDeviceManager.getInstance(this.mContext).isAbsoluteVolumeSupported(this.mDevice);
        this.mAbsStatus = r0;
        return r0;
    }

    private void fetchAbsStatus() {
        this.mAbsStatus = CaeBluetoothDeviceManager.getInstance(this.mContext).isAbsoluteVolumeSupported(this.mDevice);
    }

    private void saveAbsStatus() {
        if (this.mAbsStatus == false) goto L5;
        MultiSDKAdapter.removeDeviceFromDatabase(this.mDevice, Utils.ABS_FEATURE_CODE);
        return;
    L5:
        MultiSDKAdapter.addDeviceToDatabase(this.mDevice, Utils.ABS_FEATURE_CODE);
    }
}
