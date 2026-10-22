package com.android.settings.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.text.TextUtils;
import com.android.settings.AdaptBluetoothDevice;
import com.android.settings.utils.SLog;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class CachedBluetoothDeviceManager {
    private static final String TAG = "CachedBluetoothDeviceManager";
    private final Map<BluetoothDevice, CachedBluetoothDevice> mCachedDeviceMap;
    private Context mContext;
    private Object mLock;

    CachedBluetoothDeviceManager(Context r2) {
        this.mLock = new Object();
        this.mCachedDeviceMap = new HashMap();
        this.mContext = r2;
    }

    public synchronized Collection<CachedBluetoothDevice> getCachedDevicesCopy() {
        monitor-enter(this);
        Object r0 = this.mLock;     // Catch: Throwable -> L12
        monitor-enter(r0);     // Catch: Throwable -> L12
        ArrayList r1 = new ArrayList(this.mCachedDeviceMap.values());     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r1;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public synchronized void clearCachedDevices() {
        monitor-enter(this);
        Object r0 = this.mLock;     // Catch: Throwable -> L17
        monitor-enter(r0);     // Catch: Throwable -> L17
        Iterator<Map.Entry<BluetoothDevice, CachedBluetoothDevice>> r1 = this.mCachedDeviceMap.entrySet().iterator();     // Catch: Throwable -> L14
    L7:
        if (r1.hasNext() == false) goto L11;
        CachedBluetoothDevice r2 = r1.next().getValue();     // Catch: Throwable -> L14
        if (r2.getBondState() != 10) goto L7;
        r2.setVisible(false);     // Catch: Throwable -> L14
        r1.remove();     // Catch: Throwable -> L14
        goto L7
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public synchronized void clearDevicesConnectionState() {
        monitor-enter(this);
        Object r0 = this.mLock;     // Catch: Throwable -> L17
        monitor-enter(r0);     // Catch: Throwable -> L17
        Iterator<CachedBluetoothDevice> r1 = this.mCachedDeviceMap.values().iterator();     // Catch: Throwable -> L14
    L7:
        if (r1.hasNext() == false) goto L11;
        CachedBluetoothDevice r2 = r1.next();     // Catch: Throwable -> L14
        if (r2.getBondState() == 10) goto L7;
        r2.clearProfileConnectionState();     // Catch: Throwable -> L14
        goto L7
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public static boolean onDeviceDisappeared(CachedBluetoothDevice r2) {
        r2.setVisible(false);
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

    public CachedBluetoothDevice findDevice(BluetoothDevice r2) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        CachedBluetoothDevice r1 = this.mCachedDeviceMap.get(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public List<CachedBluetoothDevice> getConnectedDevices() {
        ArrayList r0 = new ArrayList();
        Object r1 = this.mLock;
        monitor-enter(r1);
        Iterator<CachedBluetoothDevice> r4 = this.mCachedDeviceMap.values().iterator();     // Catch: Throwable -> L12
    L6:
        if (r4.hasNext() == false) goto L10;
        CachedBluetoothDevice r2 = r4.next();     // Catch: Throwable -> L12
        if (r2.isConnected() == false) goto L6;
        r0.add(r2);     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r1);     // Catch: Throwable -> L12
        return r0;
    L12:
        th = move-exception;
        throw th;
    }

    CachedBluetoothDevice addDevice(LocalBluetoothAdapter r2, LocalBluetoothProfileManager r3, BluetoothDevice r4) {
        return addDevice(r2, r3, r4, null);
    }

    CachedBluetoothDevice addDevice(LocalBluetoothAdapter r9, LocalBluetoothProfileManager r10, BluetoothDevice r11, String r12) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        CachedBluetoothDevice r7 = new CachedBluetoothDevice(this.mContext, r9, r10, r11, r12);     // Catch: Throwable -> L7 Exception -> L9
        this.mCachedDeviceMap.put(r11, r7);     // Catch: Throwable -> L7 Exception -> L9
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    L9:
        e = move-exception;
        OLog.e(TAG, e.toString());     // Catch: Throwable -> L7
        return null;
    }

    public String getName(BluetoothDevice r2) {
        String r1 = AdaptBluetoothDevice.getDeviceAliasName(r2);
        if (r1 != null) goto L5;
    L7:
        if (r1 != null) goto L9;
        return r1;
    L9:
        if (TextUtils.isEmpty(r1) == false) goto L13;
        String r3 = r2.getAddress();
        SLog.d(TAG, "Device has no name, use address: " + r3);
        return r3;
    L13:
        return r1;
    L5:
        if (TextUtils.isEmpty(r1) == false) goto L7;
        r1 = r2.getName();
        goto L7
    }

    public synchronized void onScanningStateChanged(boolean r5) {
        monitor-enter(this);
        Object r0 = this.mLock;     // Catch: Throwable -> L17
        monitor-enter(r0);     // Catch: Throwable -> L17
        Iterator<CachedBluetoothDevice> r1 = this.mCachedDeviceMap.values().iterator();     // Catch: Throwable -> L14
    L7:
        if (r1.hasNext() == false) goto L11;
        CachedBluetoothDevice r2 = r1.next();     // Catch: Throwable -> L14
        if (r5 == false) goto L7;
        r2.setVisible(false);     // Catch: Throwable -> L14
        goto L7
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public synchronized void onBtClassChanged(BluetoothDevice r1) {
        monitor-enter(this);
        CachedBluetoothDevice r2 = findDevice(r1);     // Catch: Throwable -> L8
        if (r2 == null) goto L6;
        r2.refreshBtClass();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized void onAttributeChange(BluetoothDevice r4, String r5) {
        monitor-enter(this);
        OLog.d(TAG, "onAttributeChange, scene: " + r5);     // Catch: Throwable -> L9
        CachedBluetoothDevice r6 = findDevice(r4);     // Catch: Throwable -> L9
        if (r6 == null) goto L7;
        r6.refresh();     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized void onUuidChanged(BluetoothDevice r1) {
        monitor-enter(this);
        CachedBluetoothDevice r2 = findDevice(r1);     // Catch: Throwable -> L8
        if (r2 == null) goto L6;
        r2.onUuidChanged();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized void onDeviceDeleted(CachedBluetoothDevice r3) {
        monitor-enter(this);
        OLog.d(TAG, "onDeviceDeleted");     // Catch: Throwable -> L12
        if (r3 != null) goto L6;
    L10:
        monitor-exit(this);
        return;
    L6:
        if (r3.getBondState() != 10) goto L10;
        if (r3.isRemovable() == false) goto L10;
        this.mCachedDeviceMap.remove(r3.getDevice());     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public synchronized void onBluetoothStateChanged(int r2) {
        monitor-enter(this);
        if (r2 == 13) goto L12;
    L10:
        monitor-exit(this);
        return;
    L12:
        clearCachedDevices();     // Catch: Throwable -> L7
        clearDevicesConnectionState();     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }
}
