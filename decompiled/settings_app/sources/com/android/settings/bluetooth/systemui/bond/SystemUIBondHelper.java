package com.android.settings.bluetooth.systemui.bond;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import com.android.settings.bluetooth.BluetoothEventManager;
import com.obric.matrix.platform.sdk.ones.account.log.OLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.ShortCompanionObject;

/* JADX INFO: compiled from: SystemUIBondHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0014\u0010\u000f\u001a\u00020\u000e*\u00020\t2\u0006\u0010\u0010\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/android/settings/bluetooth/systemui/bond/SystemUIBondHelper;", "", "bluetoothEventManager", "Lcom/android/settings/bluetooth/BluetoothEventManager;", "(Lcom/android/settings/bluetooth/BluetoothEventManager;)V", "addDevices", "", "bluetoothDevices", "", "Landroid/bluetooth/BluetoothDevice;", "bluetoothDevice", "tryBondNewDevice", "", "intent", "Landroid/content/Intent;", "wrapToIntent", "isBondDevice", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SystemUIBondHelper {
    public static final Companion Companion = null;
    private static final String EXTRA_BLUETOOTH_DEVICE_LIST = "bluetooth_device_list";
    private static final String EXTRA_TO_BOND_DEVICE = "to_bond_device";
    private static final String TAG = "SystemUIBondHelper";
    private final BluetoothEventManager bluetoothEventManager;

    /* JADX INFO: compiled from: SystemUIBondHelper.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/settings/bluetooth/systemui/bond/SystemUIBondHelper$Companion;", "", "()V", "EXTRA_BLUETOOTH_DEVICE_LIST", "", "EXTRA_TO_BOND_DEVICE", "TAG", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SystemUIBondHelper(BluetoothEventManager r2) {
        Intrinsics.checkNotNullParameter(r2, "bluetoothEventManager");
        this.bluetoothEventManager = r2;
    }

    public final boolean tryBondNewDevice(Intent r7) {
        Intrinsics.checkNotNullParameter(r7, "intent");
        OLog.i(TAG, "tryBondNewDevice");
        ArrayList r0 = r7.getParcelableArrayListExtra(EXTRA_BLUETOOTH_DEVICE_LIST, BluetoothDevice.class);
        if (r0 != null) goto L5;
        return false;
    L5:
        BluetoothDevice r8 = (BluetoothDevice) r7.getParcelableExtra(EXTRA_TO_BOND_DEVICE, BluetoothDevice.class);
        if (r8 != null) goto L8;
        return false;
    L8:
        OLog.i(TAG, "tryBondNewDevice, toBondDevice = " + r8.getName());
        StringBuilder r2 = new StringBuilder("tryBondNewDevice, bluetoothDeviceList = ");
        ArrayList r1 = r0;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r4 = r1.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        r3.add(((BluetoothDevice) r4.next()).getName());
        goto L10
    L12:
        OLog.i(TAG, r2.append(r3).toString());
        r8.createBond();
        addDevices(CollectionsKt.reversed(r1), r8);
        return true;
    }

    private final void addDevices(List<BluetoothDevice> r4, BluetoothDevice r5) {
        Iterator<T> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        BluetoothDevice r0 = (BluetoothDevice) r6.next();
        this.bluetoothEventManager.handleDeviceFound(wrapToIntent(r0, Intrinsics.areEqual(r0, r5)), r0);
        goto L4
    }

    private final Intent wrapToIntent(BluetoothDevice r3, boolean r4) {
        Intent r2 = new Intent();
        r2.putExtra("android.bluetooth.device.extra.DEVICE", r3);
        if (r4 == false) goto L5;
        short r5 = 0;
    L6:
        r2.putExtra("android.bluetooth.device.extra.RSSI", r5);
        r2.putExtra("android.bluetooth.device.extra.CLASS", r3.getBluetoothClass());
        r2.putExtra("android.bluetooth.device.extra.NAME", r3.getName());
        return r2;
    L5:
        r5 = ShortCompanionObject.MIN_VALUE;
        goto L6
    }
}
