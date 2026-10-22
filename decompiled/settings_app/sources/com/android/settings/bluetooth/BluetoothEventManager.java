package com.android.settings.bluetooth;

import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.settings.InvisibleApi;
import com.android.settings.R;
import com.android.settings.utils.SLog;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.ShortCompanionObject;
import obric.bluetooth.SmartBluetoothBinderClient;

/* JADX INFO: loaded from: classes2.dex */
public final class BluetoothEventManager {
    private static final int MSG_ADD_FOUND_DEVICE = 1;
    private static final int MSG_UPDATE_DEVICE_ADDED_UI = 2;
    private static final String TAG = "BluetoothEventManager";
    private final Set<BluetoothDevice> currentDevices;
    private long lastStartScanTime;
    private final IntentFilter mAdapterIntentFilter;
    private android.os.Handler mAddDeviceHandler;
    private HandlerThread mAddDeviceThread;
    private final BroadcastReceiver mBroadcastReceiver;
    private final Collection<BluetoothCallback> mCallbacks;
    private boolean mClassChangeBroadcastFlag;
    private final BroadcastReceiver mClassChangeBroadcastReceiver;
    private final IntentFilter mClassChangeIntentFilter;
    private Context mContext;
    private final CachedBluetoothDeviceManager mDeviceManager;
    private final Map<String, Handler> mHandlerMap;
    private final LocalBluetoothAdapter mLocalAdapter;
    private final IntentFilter mProfileIntentFilter;
    private LocalBluetoothProfileManager mProfileManager;
    private UpdateUIHandler mUIHandler;

    public class A2DPStateChangedHandler implements Handler {
        final /* synthetic */ BluetoothEventManager this$0;

        public A2DPStateChangedHandler(BluetoothEventManager r1) {
            this.this$0 = r1;
        }

        @Override // com.android.settings.bluetooth.BluetoothEventManager.Handler
        public void onReceive(Context r2, Intent r3, BluetoothDevice r4) {
            Iterator<CachedBluetoothDevice> r5 = BluetoothEventManager.access$1700(this.this$0).getConnectedDevices().iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            CachedBluetoothDevice r6 = r5.next();
            BluetoothEventManager.access$1700(this.this$0).onAttributeChange(r6.getDevice(), "A2DPState");
            goto L4
        }
    }

    public class ACLConnectedHandler implements Handler {
        private boolean isConnected;
        final /* synthetic */ BluetoothEventManager this$0;

        public ACLConnectedHandler(BluetoothEventManager r1, boolean r2) {
            this.this$0 = r1;
            this.isConnected = r2;
        }

        @Override // com.android.settings.bluetooth.BluetoothEventManager.Handler
        public void onReceive(Context r2, Intent r3, BluetoothDevice r4) {
            BluetoothEventManager.access$1700(this.this$0).onAttributeChange(r4, "ACLConnected=" + this.isConnected);
        }
    }

    private class AdapterStateChangedHandler implements Handler {
        final /* synthetic */ BluetoothEventManager this$0;

        private AdapterStateChangedHandler(BluetoothEventManager r1) {
            this.this$0 = r1;
        }

        /* synthetic */ AdapterStateChangedHandler(BluetoothEventManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.settings.bluetooth.BluetoothEventManager.Handler
        public void onReceive(Context r3, Intent r4, BluetoothDevice r5) {
            int r6 = r4.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
            BluetoothEventManager.access$1100(this.this$0).setBluetoothStateInt(r6);
            if (r6 != 10) goto L8;
            BluetoothEventManager.access$1100(this.this$0).setBoundState(10);
            if (BluetoothEventManager.access$1200(this.this$0) == false) goto L12;
            BluetoothEventManager.access$1202(this.this$0, false);
            BluetoothEventManager.access$1400(this.this$0).unregisterReceiver(BluetoothEventManager.access$1300(this.this$0));
        L12:
            Collection r7 = BluetoothEventManager.access$1600(this.this$0);
            monitor-enter(r7);
            Iterator r8 = BluetoothEventManager.access$1600(this.this$0).iterator();     // Catch: Throwable -> L21
        L16:
            if (r8.hasNext() == false) goto L18;
            ((BluetoothCallback) r8.next()).onBluetoothStateChanged(r6);     // Catch: Throwable -> L21
            goto L16
        L18:
            monitor-exit(r7);     // Catch: Throwable -> L21
            BluetoothEventManager.access$1700(this.this$0).onBluetoothStateChanged(r6);
            return;
        L21:
            th = move-exception;
            throw th;
        L8:
            if (r6 != 12) goto L12;
            if (BluetoothEventManager.access$1200(this.this$0) == true) goto L12;
            BluetoothEventManager.access$1202(this.this$0, true);
            GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(BluetoothEventManager.access$1400(this.this$0), BluetoothEventManager.access$1300(this.this$0), BluetoothEventManager.access$1500(this.this$0), 2);
            goto L12
        }
    }

    private class AddDeviceHandler extends android.os.Handler {
        final /* synthetic */ BluetoothEventManager this$0;

        public AddDeviceHandler(BluetoothEventManager r1, Looper r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r7) {
            if (r7.what != 1) goto L16;
            Intent r8 = (Intent) r7.obj;
            BluetoothDevice r0 = (BluetoothDevice) r8.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            String r1 = r8.getStringExtra("android.bluetooth.device.extra.NAME");
            StringBuilder r2 = new StringBuilder("AddDeviceHandler: MSG_ADD_FOUND_DEVICE device :");
            if (r0 == null) goto L8;
            String r3 = r0.getAddress();
        L9:
            SLog.d(BluetoothEventManager.TAG, r2.append(r3).append(", ").append(r1).toString());
            if (r0 != null) goto L12;
        L14:
            Message r4 = BluetoothEventManager.access$2100(this.this$0).obtainMessage();
            r4.what = 2;
            r4.obj = r8;
            BluetoothEventManager.access$2100(this.this$0).sendMessage(r4);
            return;
        L12:
            if (BluetoothEventManager.access$1700(this.this$0).findDevice(r0) != null) goto L14;
            SLog.d(BluetoothEventManager.TAG, "DeviceFoundHandler created new CachedBluetoothDevice: " + BluetoothEventManager.access$1700(this.this$0).addDevice(BluetoothEventManager.access$1100(this.this$0), BluetoothEventManager.access$2000(this.this$0), r0, r1));
            goto L14
        L8:
            r3 = "null";
            goto L9
        }
    }

    public class BatteryLevelChangedHandler implements Handler {
        final /* synthetic */ BluetoothEventManager this$0;

        public BatteryLevelChangedHandler(BluetoothEventManager r1) {
            this.this$0 = r1;
        }

        @Override // com.android.settings.bluetooth.BluetoothEventManager.Handler
        public void onReceive(Context r1, Intent r2, BluetoothDevice r3) {
            BluetoothEventManager.access$1700(this.this$0).onAttributeChange(r3, "BatteryLevel");
        }
    }

    private class BondStateChangedHandler implements Handler {
        final /* synthetic */ BluetoothEventManager this$0;

        private BondStateChangedHandler(BluetoothEventManager r1) {
            this.this$0 = r1;
        }

        /* synthetic */ BondStateChangedHandler(BluetoothEventManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.settings.bluetooth.BluetoothEventManager.Handler
        public void onReceive(Context r6, Intent r7, BluetoothDevice r8) {
            if (r8 != null) goto L5;
            OLog.e(BluetoothEventManager.TAG, "ACTION_BOND_STATE_CHANGED with no EXTRA_DEVICE");
            return;
        L5:
            int r0 = r7.getIntExtra("android.bluetooth.device.extra.BOND_STATE", Integer.MIN_VALUE);
            if (BluetoothEventManager.access$1100(this.this$0) == null) goto L8;
            BluetoothEventManager.access$1100(this.this$0).setBoundState(r0);
        L8:
            CachedBluetoothDevice r2 = BluetoothEventManager.access$1700(this.this$0).findDevice(r8);
            if (r2 != null) goto L18;
            OLog.w(BluetoothEventManager.TAG, "CachedBluetoothDevice for device " + r8 + " not found, calling readPairedDevices().");
            if (this.this$0.readPairedDevices() == true) goto L14;
            OLog.e(BluetoothEventManager.TAG, "Got bonding state changed for " + r8 + ", but we have no record of that device.");
            return;
        L14:
            r2 = BluetoothEventManager.access$1700(this.this$0).findDevice(r8);
            if (r2 != null) goto L18;
            OLog.e(BluetoothEventManager.TAG, "Got bonding state changed for " + r8 + ", but device not added in cache.");
            return;
        L18:
            r2.onBondingStateChanged(r0);
            Collection r9 = BluetoothEventManager.access$1600(this.this$0);
            monitor-enter(r9);
            Iterator r3 = BluetoothEventManager.access$1600(this.this$0).iterator();     // Catch: Throwable -> L42
        L22:
            if (r3.hasNext() == false) goto L24;
            ((BluetoothCallback) r3.next()).onDeviceBondStateChanged(r2, r0);     // Catch: Throwable -> L42
            goto L22
        L24:
            monitor-exit(r9);     // Catch: Throwable -> L42
            if (r0 == 10) goto L28;
            return;
        L28:
            if (r2.isRemovable() == false) goto L40;
            Collection r10 = BluetoothEventManager.access$1600(this.this$0);
            monitor-enter(r10);
            Iterator r1 = BluetoothEventManager.access$1600(this.this$0).iterator();     // Catch: Throwable -> L37
        L33:
            if (r1.hasNext() == false) goto L35;
            ((BluetoothCallback) r1.next()).onDeviceDeleted(r2);     // Catch: Throwable -> L37
            goto L33
        L35:
            monitor-exit(r10);     // Catch: Throwable -> L37
            BluetoothEventManager.access$1700(this.this$0).onDeviceDeleted(r2);
        L37:
            th = move-exception;
            throw th;
        L40:
            showUnbondMessage(r6, r2.getName(), r7.getIntExtra("android.bluetooth.device.extra.REASON", Integer.MIN_VALUE));
            return;
        L42:
            th = move-exception;
            throw th;
        }

        private void showUnbondMessage(Context r1, String r2, int r3) {
            switch(r3) {
                case 1: goto L8;
                case 2: goto L7;
                case 3: goto L3;
                case 4: goto L6;
                case 5: goto L5;
                case 6: goto L5;
                case 7: goto L5;
                case 8: goto L5;
                default: goto L3;
            };
        L3:
            OLog.w(BluetoothEventManager.TAG, "showUnbondMessage: Not displaying any message for reason: " + r3);
            return;
        L5:
            int r0 = R.string.bluetooth_pairing_error_message;
        L9:
            Utils.showError(r1, r2, r0);
            return;
        L6:
            r0 = R.string.bluetooth_pairing_device_down_error_message;
            goto L9
        L7:
            r0 = R.string.bluetooth_pairing_rejected_error_message;
            goto L9
        L8:
            r0 = R.string.bluetooth_pairing_pin_error_message;
            goto L9
        }
    }

    private class ClassChangedHandler implements Handler {
        final /* synthetic */ BluetoothEventManager this$0;

        private ClassChangedHandler(BluetoothEventManager r1) {
            this.this$0 = r1;
        }

        /* synthetic */ ClassChangedHandler(BluetoothEventManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.settings.bluetooth.BluetoothEventManager.Handler
        public void onReceive(Context r1, Intent r2, BluetoothDevice r3) {
            BluetoothEventManager.access$1700(this.this$0).onBtClassChanged(r3);
        }
    }

    private class DeviceDisappearedHandler implements Handler {
        final /* synthetic */ BluetoothEventManager this$0;

        private DeviceDisappearedHandler(BluetoothEventManager r1) {
            this.this$0 = r1;
        }

        /* synthetic */ DeviceDisappearedHandler(BluetoothEventManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.settings.bluetooth.BluetoothEventManager.Handler
        public void onReceive(Context r3, Intent r4, BluetoothDevice r5) {
            CachedBluetoothDevice r6 = BluetoothEventManager.access$1700(this.this$0).findDevice(r5);
            if (r6 != null) goto L7;
            OLog.w(BluetoothEventManager.TAG, "received ACTION_DISAPPEARED for an unknown device: " + r5);
            return;
        L7:
            if (CachedBluetoothDeviceManager.onDeviceDisappeared(r6) == false) goto L19;
            Collection r7 = BluetoothEventManager.access$1600(this.this$0);
            monitor-enter(r7);
            Iterator r8 = BluetoothEventManager.access$1600(this.this$0).iterator();     // Catch: Throwable -> L16
        L12:
            if (r8.hasNext() == false) goto L14;
            BluetoothCallback r0 = (BluetoothCallback) r8.next();     // Catch: Throwable -> L16
            r6.setRemovable(true);     // Catch: Throwable -> L16
            BluetoothEventManager.access$1700(this.this$0).onDeviceDeleted(r6);     // Catch: Throwable -> L16
            r0.onDeviceDeleted(r6);     // Catch: Throwable -> L16
            goto L12
        L14:
            monitor-exit(r7);     // Catch: Throwable -> L16
            return;
        L16:
            th = move-exception;
            throw th;
        }
    }

    private class DeviceFoundHandler implements Handler {
        final /* synthetic */ BluetoothEventManager this$0;

        private DeviceFoundHandler(BluetoothEventManager r1) {
            this.this$0 = r1;
        }

        /* synthetic */ DeviceFoundHandler(BluetoothEventManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.settings.bluetooth.BluetoothEventManager.Handler
        public void onReceive(Context r1, Intent r2, BluetoothDevice r3) {
            this.this$0.handleDeviceFound(r2, r3);
        }
    }

    private class DockEventHandler implements Handler {
        final /* synthetic */ BluetoothEventManager this$0;

        private DockEventHandler(BluetoothEventManager r1) {
            this.this$0 = r1;
        }

        /* synthetic */ DockEventHandler(BluetoothEventManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.settings.bluetooth.BluetoothEventManager.Handler
        public void onReceive(Context r2, Intent r3, BluetoothDevice r4) {
            if (r3.getIntExtra("android.intent.extra.DOCK_STATE", 1) != 0) goto L11;
            if (r4 != null) goto L6;
            return;
        L6:
            if (r4.getBondState() != 10) goto L13;
            CachedBluetoothDevice r1 = BluetoothEventManager.access$1700(this.this$0).findDevice(r4);
            if (r1 == null) goto L14;
            r1.setVisible(false);
            return;
        L14:
            return;
        L13:
            return;
        }
    }

    interface Handler {
        void onReceive(Context r1, Intent r2, BluetoothDevice r3);
    }

    public class HeadsetStateChangedHandler implements Handler {
        final /* synthetic */ BluetoothEventManager this$0;

        public HeadsetStateChangedHandler(BluetoothEventManager r1) {
            this.this$0 = r1;
        }

        @Override // com.android.settings.bluetooth.BluetoothEventManager.Handler
        public void onReceive(Context r2, Intent r3, BluetoothDevice r4) {
            Iterator<CachedBluetoothDevice> r5 = BluetoothEventManager.access$1700(this.this$0).getConnectedDevices().iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            CachedBluetoothDevice r6 = r5.next();
            BluetoothEventManager.access$1700(this.this$0).onAttributeChange(r6.getDevice(), "HeadsetState");
            goto L4
        }
    }

    private class NameChangedHandler implements Handler {
        final /* synthetic */ BluetoothEventManager this$0;

        private NameChangedHandler(BluetoothEventManager r1) {
            this.this$0 = r1;
        }

        /* synthetic */ NameChangedHandler(BluetoothEventManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.settings.bluetooth.BluetoothEventManager.Handler
        public void onReceive(Context r3, Intent r4, BluetoothDevice r5) {
            if (r5 != null) goto L6;
            OLog.e(BluetoothEventManager.TAG, "ACTION_NAME_CHANGED with no EXTRA_DEVICE");
            return;
        L6:
            OLog.d(BluetoothEventManager.TAG, "NameChangedHandler: name = " + r5.getName() + " mac_address = " + r5.getAddress());
            boolean r0 = Utils.shouldDiscardDevice(BluetoothEventManager.access$1700(this.this$0).findDevice(r5));
            BluetoothEventManager.access$1700(this.this$0).onDeviceNameUpdated(r5);
            if (r0 == false) goto L10;
            OLog.d(BluetoothEventManager.TAG, "onReceive: shouldBeDiscardedPrevious = true device=" + r5.getAddress());
            Message r6 = BluetoothEventManager.access$2100(this.this$0).obtainMessage();
            r6.what = 2;
            r6.obj = r4;
            BluetoothEventManager.access$2100(this.this$0).sendMessage(r6);
            return;
        }
    }

    private class PairingCancelHandler implements Handler {
        final /* synthetic */ BluetoothEventManager this$0;

        private PairingCancelHandler(BluetoothEventManager r1) {
            this.this$0 = r1;
        }

        /* synthetic */ PairingCancelHandler(BluetoothEventManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.settings.bluetooth.BluetoothEventManager.Handler
        public void onReceive(Context r1, Intent r2, BluetoothDevice r3) {
            if (r3 != null) goto L5;
            OLog.e(BluetoothEventManager.TAG, "ACTION_PAIRING_CANCEL with no EXTRA_DEVICE");
            return;
        L5:
            CachedBluetoothDevice r0 = BluetoothEventManager.access$1700(this.this$0).findDevice(r3);
            if (r1 == null) goto L10;
            if (r0 == null) goto L11;
            Utils.showError(r1, r0.getName(), R.string.bluetooth_pairing_error_message);
            return;
        L11:
            return;
        }
    }

    private class ScanningStateChangedHandler implements Handler {
        private final boolean mStarted;
        final /* synthetic */ BluetoothEventManager this$0;

        ScanningStateChangedHandler(BluetoothEventManager r1, boolean r2) {
            this.this$0 = r1;
            this.mStarted = r2;
        }

        @Override // com.android.settings.bluetooth.BluetoothEventManager.Handler
        public void onReceive(Context r4, Intent r5, BluetoothDevice r6) {
            Collection r7 = BluetoothEventManager.access$1600(this.this$0);
            monitor-enter(r7);
            Iterator r8 = BluetoothEventManager.access$1600(this.this$0).iterator();     // Catch: Throwable -> L37
        L6:
            if (r8.hasNext() == false) goto L8;
            ((BluetoothCallback) r8.next()).onScanningStateChanged(this.mStarted);     // Catch: Throwable -> L37
            goto L6
        L8:
            monitor-exit(r7);     // Catch: Throwable -> L37
            BluetoothEventManager.access$1700(this.this$0).onScanningStateChanged(this.mStarted);
            LocalBluetoothPreferences.persistDiscoveringTimestamp(r4);
            if (this.mStarted == false) goto L13;
            SLog.i(BluetoothEventManager.TAG, "ScanningStateChangedHandler: onReceive: start " + BluetoothUtils.logString(BluetoothEventManager.access$1800(this.this$0)));
            BluetoothEventManager.access$1902(this.this$0, SystemClock.elapsedRealtime());
            BluetoothEventManager.access$1800(this.this$0).clear();
            return;
        L13:
            if ((SystemClock.elapsedRealtime() - BluetoothEventManager.access$1900(this.this$0)) <= TimeUnit.SECONDS.toMillis(12)) goto L56;
            SLog.i(BluetoothEventManager.TAG, "ScanningStateChangedHandler: onReceive: end " + BluetoothUtils.logString(BluetoothEventManager.access$1800(this.this$0)));
            ArrayList r9 = new ArrayList();
            Iterator<CachedBluetoothDevice> r10 = BluetoothEventManager.access$1700(this.this$0).getCachedDevicesCopy().iterator();
        L16:
            if (r10.hasNext() == false) goto L20;
            CachedBluetoothDevice r11 = r10.next();
            if (BluetoothEventManager.access$1800(this.this$0).contains(r11.getDevice()) == true) goto L16;
            r9.add(r11);
            goto L16
        L20:
            SLog.i(BluetoothEventManager.TAG, "ScanningStateChangedHandler: onReceive: diff " + BluetoothUtils.logStr(r9));
            Iterator r12 = r9.iterator();
        L22:
            if (r12.hasNext() == false) goto L57;
            CachedBluetoothDevice r13 = (CachedBluetoothDevice) r12.next();
            if (CachedBluetoothDeviceManager.onDeviceDisappeared(r13) == false) goto L22;
            Collection r14 = BluetoothEventManager.access$1600(this.this$0);
            monitor-enter(r14);
            Iterator r0 = BluetoothEventManager.access$1600(this.this$0).iterator();     // Catch: Throwable -> L33
        L29:
            if (r0.hasNext() == false) goto L31;
            BluetoothCallback r1 = (BluetoothCallback) r0.next();     // Catch: Throwable -> L33
            r13.setRemovable(true);     // Catch: Throwable -> L33
            r1.onDeviceDeleted(r13);     // Catch: Throwable -> L33
            goto L29
        L31:
            monitor-exit(r14);     // Catch: Throwable -> L33
        L33:
            th = move-exception;
            throw th;
        L57:
            return;
        L56:
            return;
        L37:
            th = move-exception;
            throw th;
        }
    }

    private class UpdateUIHandler extends android.os.Handler {
        final /* synthetic */ BluetoothEventManager this$0;

        private UpdateUIHandler(BluetoothEventManager r1) {
            this.this$0 = r1;
        }

        /* synthetic */ UpdateUIHandler(BluetoothEventManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r8) {
            if (r8.what != 2) goto L17;
            Intent r9 = (Intent) r8.obj;
            BluetoothDevice r0 = (BluetoothDevice) r9.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            short r1 = r9.getShortExtra("android.bluetooth.device.extra.RSSI", ShortCompanionObject.MIN_VALUE);
            int r2 = r9.getIntExtra(SmartBluetoothBinderClient.KEY_PRODUCT_ID, -1);
            BluetoothClass r3 = (BluetoothClass) r9.getParcelableExtra("android.bluetooth.device.extra.CLASS");
            String r10 = r9.getStringExtra("android.bluetooth.device.extra.NAME");
            CachedBluetoothDevice r4 = BluetoothEventManager.access$1700(this.this$0).findDevice(r0);
            StringBuilder r5 = new StringBuilder("UpdateUIHandler: device :");
            Object r6 = "null";
            if (r0 == null) goto L8;
            String r7 = r0.getAddress();
        L9:
            StringBuilder r11 = r5.append(r7).append(", ").append(r10).append("MajorDeviceClass :");
            if (r3 == null) goto L12;
            r6 = Integer.valueOf(r3.getMajorDeviceClass());
        L12:
            SLog.d(BluetoothEventManager.TAG, r11.append(r6).toString());
            if (r4 == null) goto L16;
            r4.setRssi(r1);
            r4.setBtClass(r3);
            r4.setName(r10);
            r4.setVisible(true);
            r4.setProductId(r2);
            BluetoothEventManager.access$2200(this.this$0, r4);
            return;
        L16:
            return;
        L8:
            r7 = "null";
            goto L9
        }
    }

    private class UuidChangedHandler implements Handler {
        final /* synthetic */ BluetoothEventManager this$0;

        private UuidChangedHandler(BluetoothEventManager r1) {
            this.this$0 = r1;
        }

        /* synthetic */ UuidChangedHandler(BluetoothEventManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.settings.bluetooth.BluetoothEventManager.Handler
        public void onReceive(Context r1, Intent r2, BluetoothDevice r3) {
            BluetoothEventManager.access$1700(this.this$0).onUuidChanged(r3);
        }
    }

    static /* synthetic */ Map access$1000(BluetoothEventManager r0) {
        return r0.mHandlerMap;
    }

    static /* synthetic */ LocalBluetoothAdapter access$1100(BluetoothEventManager r0) {
        return r0.mLocalAdapter;
    }

    static /* synthetic */ boolean access$1200(BluetoothEventManager r0) {
        return r0.mClassChangeBroadcastFlag;
    }

    static /* synthetic */ boolean access$1202(BluetoothEventManager r0, boolean r1) {
        r0.mClassChangeBroadcastFlag = r1;
        return r1;
    }

    static /* synthetic */ BroadcastReceiver access$1300(BluetoothEventManager r0) {
        return r0.mClassChangeBroadcastReceiver;
    }

    static /* synthetic */ Context access$1400(BluetoothEventManager r0) {
        return r0.mContext;
    }

    static /* synthetic */ IntentFilter access$1500(BluetoothEventManager r0) {
        return r0.mClassChangeIntentFilter;
    }

    static /* synthetic */ Collection access$1600(BluetoothEventManager r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ CachedBluetoothDeviceManager access$1700(BluetoothEventManager r0) {
        return r0.mDeviceManager;
    }

    static /* synthetic */ Set access$1800(BluetoothEventManager r0) {
        return r0.currentDevices;
    }

    static /* synthetic */ long access$1900(BluetoothEventManager r2) {
        return r2.lastStartScanTime;
    }

    static /* synthetic */ long access$1902(BluetoothEventManager r0, long r1) {
        r0.lastStartScanTime = r1;
        return r1;
    }

    static /* synthetic */ LocalBluetoothProfileManager access$2000(BluetoothEventManager r0) {
        return r0.mProfileManager;
    }

    static /* synthetic */ UpdateUIHandler access$2100(BluetoothEventManager r0) {
        return r0.mUIHandler;
    }

    static /* synthetic */ void access$2200(BluetoothEventManager r0, CachedBluetoothDevice r1) {
        r0.dispatchDeviceAdded(r1);
    }

    void addClassChangeHandler(String r2, Handler r3) {
        this.mHandlerMap.put(r2, r3);
        this.mClassChangeIntentFilter.addAction(r2);
    }

    void addHandler(String r2, Handler r3) {
        this.mHandlerMap.put(r2, r3);
        this.mAdapterIntentFilter.addAction(r2);
    }

    void addProfileHandler(String r2, Handler r3) {
        this.mHandlerMap.put(r2, r3);
        this.mProfileIntentFilter.addAction(r2);
    }

    void setProfileManager(LocalBluetoothProfileManager r1) {
        this.mProfileManager = r1;
    }

    BluetoothEventManager(LocalBluetoothAdapter r5, CachedBluetoothDeviceManager r6, Context r7) {
        this.mClassChangeBroadcastFlag = false;
        this.mCallbacks = new ArrayList();
        BroadcastReceiver r1 = new AnonymousClass1(this);
        this.mBroadcastReceiver = r1;
        this.mClassChangeBroadcastReceiver = new AnonymousClass2(this);
        this.currentDevices = new HashSet();
        this.lastStartScanTime = 0;
        this.mLocalAdapter = r5;
        this.mDeviceManager = r6;
        IntentFilter r8 = new IntentFilter();
        this.mAdapterIntentFilter = r8;
        this.mProfileIntentFilter = new IntentFilter();
        this.mClassChangeIntentFilter = new IntentFilter();
        this.mHandlerMap = new HashMap();
        this.mContext = r7;
        AnonymousClass1 r9 = null;
        this.mUIHandler = new UpdateUIHandler(this, r9);
        HandlerThread r10 = new HandlerThread("AddDeviceThread");
        this.mAddDeviceThread = r10;
        r10.start();
        this.mAddDeviceHandler = new AddDeviceHandler(this, this.mAddDeviceThread.getLooper());
        addHandler("android.bluetooth.adapter.action.STATE_CHANGED", new AdapterStateChangedHandler(this, r9));
        addHandler("android.bluetooth.adapter.action.DISCOVERY_STARTED", new ScanningStateChangedHandler(this, true));
        addHandler("android.bluetooth.adapter.action.DISCOVERY_FINISHED", new ScanningStateChangedHandler(this, false));
        addHandler("android.bluetooth.device.action.FOUND", new DeviceFoundHandler(this, r9));
        addHandler(InvisibleApi.ACTION_DISAPPEARED, new DeviceDisappearedHandler(this, r9));
        addHandler("android.bluetooth.device.action.NAME_CHANGED", new NameChangedHandler(this, r9));
        addHandler("android.bluetooth.device.action.BOND_STATE_CHANGED", new BondStateChangedHandler(this, r9));
        addHandler("android.bluetooth.device.action.PAIRING_CANCEL", new PairingCancelHandler(this, r9));
        addClassChangeHandler("android.bluetooth.device.action.CLASS_CHANGED", new ClassChangedHandler(this, r9));
        addHandler("android.bluetooth.device.action.UUID", new UuidChangedHandler(this, r9));
        addHandler("android.bluetooth.device.action.BATTERY_LEVEL_CHANGED", new BatteryLevelChangedHandler(this));
        addHandler("android.bluetooth.headset.profile.action.ACTIVE_DEVICE_CHANGED", new HeadsetStateChangedHandler(this));
        addHandler("android.bluetooth.a2dp.profile.action.ACTIVE_DEVICE_CHANGED", new A2DPStateChangedHandler(this));
        addHandler("android.bluetooth.device.action.ACL_CONNECTED", new ACLConnectedHandler(this, true));
        addHandler("android.bluetooth.device.action.ACL_DISCONNECTED", new ACLConnectedHandler(this, false));
        addHandler("android.intent.action.DOCK_EVENT", new DockEventHandler(this, r9));
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, r1, r8, 2);
    }

    void registerProfileIntentReceiver() {
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mBroadcastReceiver, this.mProfileIntentFilter, 2);
    }

    void registerCallback(BluetoothCallback r2) {
        Collection<BluetoothCallback> r0 = this.mCallbacks;
        monitor-enter(r0);
        this.mCallbacks.add(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void unregisterCallback(BluetoothCallback r2) {
        Collection<BluetoothCallback> r0 = this.mCallbacks;
        monitor-enter(r0);
        this.mCallbacks.remove(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static String getDockedDeviceAddress(Context r3) {
        Intent r4 = GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r3, null, new IntentFilter("android.intent.action.DOCK_EVENT"), 2);
        if (r4 != null) goto L5;
    L10:
        return null;
    L5:
        if (r4.getIntExtra("android.intent.extra.DOCK_STATE", 0) == 0) goto L10;
        BluetoothDevice r5 = (BluetoothDevice) r4.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (r5 == null) goto L10;
        return r5.getAddress();
    }

    public void handleDeviceFound(Intent r9, BluetoothDevice r10) {
        short r0 = r9.getShortExtra("android.bluetooth.device.extra.RSSI", ShortCompanionObject.MIN_VALUE);
        BluetoothClass r1 = (BluetoothClass) r9.getParcelableExtra("android.bluetooth.device.extra.CLASS");
        String r2 = r9.getStringExtra("android.bluetooth.device.extra.NAME");
        int r3 = r9.getIntExtra(SmartBluetoothBinderClient.KEY_PRODUCT_ID, -1);
        if (r10 == null) goto L5;
        String r4 = r10.getAddress();
    L6:
        SLog.d(TAG, "DeviceFoundHandler: device :" + r4 + ", " + r2);
        CachedBluetoothDevice r5 = this.mDeviceManager.findDevice(r10);
        if (r5 != null) goto L10;
        Message.obtain(this.mAddDeviceHandler, 1, r9).sendToTarget();
    L14:
        if (TextUtils.isEmpty(r4) == true) goto L17;
        this.currentDevices.add(r10);
        return;
    L17:
        return;
    L10:
        if (r5.isVisible() == true) goto L12;
        r5.setVisible(true);
        Message.obtain(this.mAddDeviceHandler, 1, r9).sendToTarget();
        goto L14
    L12:
        r5.setRssi(r0);
        r5.setBtClass(r1);
        r5.setName(r2);
        r5.setProductId(r3);
        goto L14
    L5:
        r4 = null;
        goto L6
    }

    private void dispatchDeviceAdded(CachedBluetoothDevice r3) {
        Collection<BluetoothCallback> r0 = this.mCallbacks;
        monitor-enter(r0);
        Iterator<BluetoothCallback> r2 = this.mCallbacks.iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L8;
        r2.next().onDeviceAdded(r3);     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    boolean readPairedDevices() {
        Set<BluetoothDevice> r0 = this.mLocalAdapter.getBondedDevices();
        boolean r1 = false;
        if (r0 != null) goto L5;
        return false;
    L5:
        Iterator<BluetoothDevice> r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        BluetoothDevice r3 = r2.next();
        if (this.mDeviceManager.findDevice(r3) != null) goto L7;
        dispatchDeviceAdded(this.mDeviceManager.addDevice(this.mLocalAdapter, this.mProfileManager, r3));
        r1 = true;
        goto L7
    L11:
        return r1;
    }
}
