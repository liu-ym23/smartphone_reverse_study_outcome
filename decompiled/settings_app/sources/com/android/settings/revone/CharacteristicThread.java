package com.android.settings.revone;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.android.settings.Constants;
import com.android.settings.utils.NullSafe;
import com.obric.olog.OLog;
import java.util.UUID;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: classes2.dex */
public class CharacteristicThread extends Thread {
    private static final int CHARACTERISTIC_OPTION_TIMEOUT_MILLIS = 300;
    private static final int QUEUE_CAPACITY = 10;
    private static final String TAG = "CharacteristicThread";
    private BluetoothGatt mGatt;
    private boolean mIsRunning;
    private Object mObject;
    private BlockingDeque<BluetoothGattCharacteristic> mQueue;

    public CharacteristicThread(BluetoothGatt r3) {
        this.mObject = new Object();
        this.mIsRunning = true;
        this.mQueue = new LinkedBlockingDeque(10);
        this.mGatt = r3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
    L3:
        if (this.mIsRunning == false) goto L27;
        if (this.mQueue.isEmpty() == true) goto L3;
        BluetoothGattCharacteristic r0 = this.mQueue.poll();
        if (this.mGatt == null) goto L15;
        if (r0 == null) goto L15;
        if (isNotifyCharacteristic(r0) == false) goto L13;
        enableNotification(this.mGatt, r0);
        goto L15
    L13:
        if (isReadCharacteristic(r0) == false) goto L15;
        readStylusCharacteristic(this.mGatt, r0);
    L15:
        Object r1 = this.mObject;
        monitor-enter(r1);
        this.mObject.wait(300);     // Catch: Throwable -> L19 InterruptedException -> L21
    L23:
        monitor-exit(r1);     // Catch: Throwable -> L19
        goto L3
    L21:
        e = move-exception;
        OLog.e(TAG, "" + e);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    private void enableNotification(BluetoothGatt r1, BluetoothGattCharacteristic r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if ((r2.getProperties() | 16) <= 0) goto L8;
        r1.setCharacteristicNotification(r2, true);
        BluetoothGattDescriptor r0 = (BluetoothGattDescriptor) NullSafe.nonNull(r2.getDescriptor(Constants.STYLUS_CONTROL_CHARACTERISTIC_CONFIG_DESCRIPTOR.getUuid()));
        r0.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        r1.writeDescriptor(r0);
        return;
    }

    private void readStylusCharacteristic(BluetoothGatt r1, BluetoothGattCharacteristic r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if ((r2.getProperties() | 2) <= 0) goto L8;
        r1.readCharacteristic(r2);
        return;
    }

    private boolean isNotifyCharacteristic(BluetoothGattCharacteristic r1) {
        UUID r0 = r1.getUuid();
        if (r0.equals(Constants.STYLUS_CONTROL_CHARACTERISTIC_BATT_LEVEL_NOTIFY.getUuid()) == false) goto L5;
    L10:
        return true;
    L5:
        if (r0.equals(Constants.STYLUS_CONTROL_CHARACTERISTIC_KEY_EVENT_NOTIFY.getUuid()) == true) goto L10;
        if (r0.equals(Constants.STYLUS_CONTROL_CHARACTERISTIC_CHARGE_STATE_NOTIFY.getUuid()) == true) goto L10;
        return false;
    }

    private boolean isReadCharacteristic(BluetoothGattCharacteristic r1) {
        UUID r0 = r1.getUuid();
        if (r0.equals(Constants.STYLUS_CONTROL_CHARACTERISTIC_CHARGE_STATE.getUuid()) == false) goto L5;
    L8:
        return true;
    L5:
        if (r0.equals(Constants.STYLUS_CONTROL_CHARACTERISTIC_BATT_LEVEL.getUuid()) == true) goto L8;
        return false;
    }

    public void inQueueCharacteristic(BluetoothGattCharacteristic r2) {
        BlockingDeque<BluetoothGattCharacteristic> r1 = this.mQueue;
        if (r1 == null) goto L11;
        r1.put(r2);     // Catch: InterruptedException -> L6
        return;
    L6:
        e = move-exception;
        OLog.e(TAG, "" + e);
        return;
    }

    public void notifyOperationDone() {
        Object r0 = this.mObject;
        monitor-enter(r0);
        this.mObject.notify();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void shutDown() {
        this.mIsRunning = false;
        BlockingDeque<BluetoothGattCharacteristic> r0 = this.mQueue;
        if (r0 == null) goto L6;
        r0.clear();
        this.mQueue = null;
        return;
    }
}
