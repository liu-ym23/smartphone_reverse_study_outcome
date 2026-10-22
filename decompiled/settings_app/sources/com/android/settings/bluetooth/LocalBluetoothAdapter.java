package com.android.settings.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.os.ParcelUuid;
import android.text.TextUtils;
import com.obric.olog.OLog;
import java.time.Duration;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class LocalBluetoothAdapter {
    private static final int SCAN_EXPIRATION_MS = 300000;
    private static final String TAG = "LocalBluetoothAdapter";
    private static LocalBluetoothAdapter sInstance;
    private final BluetoothAdapter mAdapter;
    private int mBoundState;
    private long mLastScan;
    private LocalBluetoothProfileManager mProfileManager;
    private int mState;

    private LocalBluetoothAdapter(BluetoothAdapter r2) {
        this.mState = Integer.MIN_VALUE;
        this.mBoundState = 10;
        this.mAdapter = r2;
    }

    void setProfileManager(LocalBluetoothProfileManager r1) {
        this.mProfileManager = r1;
    }

    public static synchronized LocalBluetoothAdapter getInstance() {
        monitor-enter(LocalBluetoothAdapter.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L9;
        BluetoothAdapter r1 = BluetoothAdapter.getDefaultAdapter();     // Catch: Throwable -> L12
        if (r1 == null) goto L9;
        sInstance = new LocalBluetoothAdapter(r1);     // Catch: Throwable -> L12
    L9:
        LocalBluetoothAdapter r2 = sInstance;     // Catch: Throwable -> L12
        monitor-exit(LocalBluetoothAdapter.class);
        return r2;
    }

    void cancelDiscovery() {
        if (this.mAdapter.isDiscovering() == false) goto L6;
        this.mAdapter.cancelDiscovery();
        return;
    }

    boolean enable() {
        return this.mAdapter.enable();
    }

    boolean disable() {
        return this.mAdapter.disable();
    }

    void getProfileProxy(Context r1, BluetoothProfile.ServiceListener r2, int r3) {
        this.mAdapter.getProfileProxy(r1, r2, r3);
    }

    Set<BluetoothDevice> getBondedDevices() {
        return this.mAdapter.getBondedDevices();
    }

    String getName() {
        return this.mAdapter.getName();
    }

    int getScanMode() {
        return this.mAdapter.getScanMode();
    }

    int getState() {
        return this.mAdapter.getState();
    }

    public int getConnectionState() {
        return this.mAdapter.getConnectionState();
    }

    public void setBoundState(int r1) {
        this.mBoundState = r1;
    }

    ParcelUuid[] getUuids() {
        return this.mAdapter.getUuids();
    }

    boolean isDiscovering() {
        return this.mAdapter.isDiscovering();
    }

    boolean isEnabled() {
        return this.mAdapter.isEnabled();
    }

    void setDiscoverableTimeout(int r3) {
        this.mAdapter.setDiscoverableTimeout(Duration.ofSeconds(r3));
    }

    void setName(String r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r2.trim()) == true) goto L9;
        this.mAdapter.setName(r2);
        return;
    }

    void setScanMode(int r1) {
        this.mAdapter.setScanMode(r1);
    }

    boolean setScanMode(int r4, int r5) {
        if (this.mAdapter.setDiscoverableTimeout(Duration.ofSeconds(r5)) == 0) goto L5;
    L7:
        return false;
    L5:
        if (this.mAdapter.setScanMode(r4) != 0) goto L7;
        return true;
    }

    boolean startScanning() {
        LocalBluetoothProfileManager r0 = this.mProfileManager;
        if (r0 == null) goto L9;
        if (r0.isProfilesProcessConnection() == false) goto L9;
        OLog.d(TAG, "isProfilesProcessConnection");
        return false;
    L9:
        if (this.mBoundState != 11) goto L12;
        OLog.d(TAG, "BluetoothDevice.BOND_BONDING");
        return false;
    L12:
        startScanning(true);
        return true;
    }

    void startScanning(boolean r5) {
        if (this.mAdapter.isDiscovering() == true) goto L17;
        if (r5 == true) goto L14;
        if ((this.mLastScan + 300000) <= System.currentTimeMillis()) goto L8;
        return;
    L8:
        A2dpProfile r6 = this.mProfileManager.getA2dpProfile();
        if (r6 == null) goto L14;
        if (r6.isA2dpPlaying() == false) goto L14;
        return;
    L14:
        if (this.mAdapter.startDiscovery() == false) goto L18;
        this.mLastScan = System.currentTimeMillis();
        return;
    L18:
        return;
    }

    void stopScanning() {
        if (this.mAdapter.isDiscovering() == false) goto L6;
        this.mAdapter.cancelDiscovery();
        return;
    }

    public int getBluetoothState() {
        syncBluetoothState();
        return this.mState;
    }

    synchronized void setBluetoothStateInt(int r2) {
        monitor-enter(this);
        this.mState = r2;     // Catch: Throwable -> L15
        if (r2 != 12) goto L9;
        LocalBluetoothProfileManager r0 = this.mProfileManager;     // Catch: Throwable -> L15
        if (r0 == null) goto L9;
        r0.setBluetoothStateOn();     // Catch: Throwable -> L15
    L9:
        if (r2 != 10) goto L13;
        LocalBluetoothProfileManager r3 = this.mProfileManager;     // Catch: Throwable -> L15
        if (r3 == null) goto L13;
        r3.resetBusyList();     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    boolean syncBluetoothState() {
        if (this.mAdapter.getState() == this.mState) goto L6;
        setBluetoothStateInt(this.mAdapter.getState());
        return true;
    L6:
        return false;
    }

    public void setBluetoothEnabled(boolean r3) {
        if (r3 == false) goto L4;
        boolean r0 = this.mAdapter.enable();
    L5:
        if (r0 == false) goto L10;
        if (r3 == false) goto L8;
        int r4 = 11;
    L9:
        setBluetoothStateInt(r4);
        return;
    L8:
        r4 = 13;
        goto L9
    L10:
        OLog.v(TAG, "setBluetoothEnabled call, manager didn't return success for enabled: " + r3);
        syncBluetoothState();
        return;
    L4:
        r0 = this.mAdapter.disable();
        goto L5
    }
}
