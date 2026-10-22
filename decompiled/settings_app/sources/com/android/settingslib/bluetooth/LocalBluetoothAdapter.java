package com.android.settingslib.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.le.BluetoothLeScanner;
import android.content.Context;
import android.os.ParcelUuid;
import java.time.Duration;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class LocalBluetoothAdapter {
    private static final int SCAN_EXPIRATION_MS = 300000;
    private static final String TAG = "LocalBluetoothAdapter";
    private static LocalBluetoothAdapter sInstance;
    private final BluetoothAdapter mAdapter;
    private long mLastScan;
    private LocalBluetoothProfileManager mProfileManager;
    private int mState;

    private LocalBluetoothAdapter(BluetoothAdapter r2) {
        this.mState = Integer.MIN_VALUE;
        this.mAdapter = r2;
    }

    void setProfileManager(LocalBluetoothProfileManager r1) {
        this.mProfileManager = r1;
    }

    static synchronized LocalBluetoothAdapter getInstance() {
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

    public void cancelDiscovery() {
        this.mAdapter.cancelDiscovery();
    }

    public boolean enable() {
        return this.mAdapter.enable();
    }

    public boolean disable() {
        return this.mAdapter.disable();
    }

    public String getAddress() {
        return this.mAdapter.getAddress();
    }

    void getProfileProxy(Context r1, BluetoothProfile.ServiceListener r2, int r3) {
        this.mAdapter.getProfileProxy(r1, r2, r3);
    }

    public Set<BluetoothDevice> getBondedDevices() {
        return this.mAdapter.getBondedDevices();
    }

    public String getName() {
        return this.mAdapter.getName();
    }

    public int getScanMode() {
        return this.mAdapter.getScanMode();
    }

    public BluetoothLeScanner getBluetoothLeScanner() {
        return this.mAdapter.getBluetoothLeScanner();
    }

    public int getState() {
        return this.mAdapter.getState();
    }

    public ParcelUuid[] getUuids() {
        List r1 = this.mAdapter.getUuidsList();
        ParcelUuid[] r0 = new ParcelUuid[r1.size()];
        r1.toArray(r0);
        return r0;
    }

    public boolean isDiscovering() {
        return this.mAdapter.isDiscovering();
    }

    public boolean isEnabled() {
        return this.mAdapter.isEnabled();
    }

    public int getConnectionState() {
        return this.mAdapter.getConnectionState();
    }

    public void setDiscoverableTimeout(int r3) {
        this.mAdapter.setDiscoverableTimeout(Duration.ofSeconds(r3));
    }

    public long getDiscoveryEndMillis() {
        return this.mAdapter.getDiscoveryEndMillis();
    }

    public void setName(String r1) {
        this.mAdapter.setName(r1);
    }

    public void setScanMode(int r1) {
        this.mAdapter.setScanMode(r1);
    }

    public boolean setScanMode(int r4, int r5) {
        if (this.mAdapter.setDiscoverableTimeout(Duration.ofSeconds(r5)) == 0) goto L5;
    L7:
        return false;
    L5:
        if (this.mAdapter.setScanMode(r4) != 0) goto L7;
        return true;
    }

    public void startScanning(boolean r5) {
        if (this.mAdapter.isDiscovering() == true) goto L22;
        if (r5 == true) goto L19;
        if ((this.mLastScan + 300000) <= System.currentTimeMillis()) goto L8;
        return;
    L8:
        A2dpProfile r6 = this.mProfileManager.getA2dpProfile();
        if (r6 != null) goto L11;
    L13:
        A2dpSinkProfile r7 = this.mProfileManager.getA2dpSinkProfile();
        if (r7 == null) goto L19;
        if (r7.isAudioPlaying() == false) goto L19;
        return;
    L11:
        if (r6.isA2dpPlaying() == false) goto L13;
        return;
    L19:
        if (this.mAdapter.startDiscovery() == false) goto L23;
        this.mLastScan = System.currentTimeMillis();
        return;
    L23:
        return;
    }

    public void stopScanning() {
        if (this.mAdapter.isDiscovering() == false) goto L6;
        this.mAdapter.cancelDiscovery();
        return;
    }

    public synchronized int getBluetoothState() {
        monitor-enter(this);
        syncBluetoothState();     // Catch: Throwable -> L6
        int r0 = this.mState;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    void setBluetoothStateInt(int r2) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.mState != r2) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L15
        return;
    L7:
        this.mState = r2;     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        if (r2 != 12) goto L19;
        LocalBluetoothProfileManager r1 = this.mProfileManager;
        if (r1 == null) goto L20;
        r1.setBluetoothStateOn();
        return;
    L20:
        return;
    }

    boolean syncBluetoothState() {
        if (this.mAdapter.getState() == this.mState) goto L6;
        setBluetoothStateInt(this.mAdapter.getState());
        return true;
    L6:
        return false;
    }

    public boolean setBluetoothEnabled(boolean r2) {
        if (r2 == false) goto L4;
        boolean r0 = this.mAdapter.enable();
    L5:
        if (r0 == false) goto L10;
        if (r2 == false) goto L8;
        int r3 = 11;
    L9:
        setBluetoothStateInt(r3);
    L11:
        return r0;
    L8:
        r3 = 13;
        goto L9
    L10:
        syncBluetoothState();
        goto L11
    L4:
        r0 = this.mAdapter.disable();
        goto L5
    }

    public BluetoothDevice getRemoteDevice(String r1) {
        return this.mAdapter.getRemoteDevice(r1);
    }

    public List<Integer> getSupportedProfiles() {
        return this.mAdapter.getSupportedProfiles();
    }
}
