package com.android.settingslib.bluetooth;

import android.app.Application;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.UserHandle;
import android.util.Log;
import com.GlobalProxyLancet;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.android.settingslib.R;
import com.android.settingslib.flags.Flags;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.ShortCompanionObject;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes.dex */
public class BluetoothEventManager {
    private static final boolean DEBUG = false;
    private static final String TAG = "BluetoothEventManager";
    private final IntentFilter mAdapterIntentFilter;
    private final BroadcastReceiver mBroadcastReceiver;
    private final LocalBluetoothManager mBtManager;
    private final Collection<BluetoothCallback> mCallbacks;
    private final Context mContext;
    private final CachedBluetoothDeviceManager mDeviceManager;
    private final Map<String, Handler> mHandlerMap;
    private final LocalBluetoothAdapter mLocalAdapter;
    private final BroadcastReceiver mProfileBroadcastReceiver;
    private final IntentFilter mProfileIntentFilter;
    private final android.os.Handler mReceiverHandler;
    private final UserHandle mUserHandle;

    /* JADX INFO: renamed from: com.android.settingslib.bluetooth.BluetoothEventManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class AclStateChangedHandler implements Handler {
        final /* synthetic */ BluetoothEventManager this$0;

        private AclStateChangedHandler(BluetoothEventManager r1) {
            this.this$0 = r1;
        }

        /* synthetic */ AclStateChangedHandler(BluetoothEventManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.settingslib.bluetooth.BluetoothEventManager.Handler
        public void onReceive(Context r2, Intent r3, BluetoothDevice r4) {
            if (r4 != null) goto L7;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(BluetoothEventManager.TAG, "AclStateChangedHandler: device is null");
            return;
        L7:
            if (BluetoothEventManager.access$1600(this.this$0).isSubDevice(r4) == false) goto L9;
            return;
        L9:
            String r5 = r3.getAction();
            if (r5 != null) goto L13;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(BluetoothEventManager.TAG, "AclStateChangedHandler: action is null");
            return;
        L13:
            CachedBluetoothDevice r6 = BluetoothEventManager.access$1600(this.this$0).findDevice(r4);
            if (r6 != null) goto L17;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(BluetoothEventManager.TAG, "AclStateChangedHandler: activeDevice is null");
            return;
        L17:
            r5.hashCode();
            if (r5.equals("android.bluetooth.device.action.ACL_CONNECTED") == false) goto L20;
            int r7 = 2;
        L25:
            BluetoothEventManager.access$1900(this.this$0, r6, r7);
            return;
        L20:
            if (r5.equals("android.bluetooth.device.action.ACL_DISCONNECTED") == true) goto L23;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(BluetoothEventManager.TAG, "ActiveDeviceChangedHandler: unknown action " + r5);
            return;
        L23:
            r7 = 0;
            goto L25
        }
    }

    private class ActiveDeviceChangedHandler implements Handler {
        final /* synthetic */ BluetoothEventManager this$0;

        private ActiveDeviceChangedHandler(BluetoothEventManager r1) {
            this.this$0 = r1;
        }

        /* synthetic */ ActiveDeviceChangedHandler(BluetoothEventManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.settingslib.bluetooth.BluetoothEventManager.Handler
        public void onReceive(Context r2, Intent r3, BluetoothDevice r4) {
            String r5 = r3.getAction();
            if (r5 != null) goto L6;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(BluetoothEventManager.TAG, "ActiveDeviceChangedHandler: action is null");
            return;
        L6:
            CachedBluetoothDevice r6 = BluetoothEventManager.access$1600(this.this$0).findDevice(r4);
            if (Objects.equals(r5, "android.bluetooth.a2dp.profile.action.ACTIVE_DEVICE_CHANGED") == false) goto L10;
            int r7 = 2;
        L18:
            this.this$0.dispatchActiveDeviceChanged(r6, r7);
            return;
        L10:
            if (Objects.equals(r5, "android.bluetooth.headset.profile.action.ACTIVE_DEVICE_CHANGED") == false) goto L13;
            r7 = 1;
            goto L18
        L13:
            if (Objects.equals(r5, "android.bluetooth.hearingaid.profile.action.ACTIVE_DEVICE_CHANGED") == false) goto L16;
            r7 = 21;
            goto L18
        L16:
            if (Objects.equals(r5, "android.bluetooth.action.LE_AUDIO_ACTIVE_DEVICE_CHANGED") == false) goto L20;
            r7 = 22;
            goto L18
        L20:
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(BluetoothEventManager.TAG, "ActiveDeviceChangedHandler: unknown action " + r5);
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

        @Override // com.android.settingslib.bluetooth.BluetoothEventManager.Handler
        public void onReceive(Context r1, Intent r2, BluetoothDevice r3) {
            int r4 = r2.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
            BluetoothEventManager.access$1400(this.this$0).setBluetoothStateInt(r4);
            Iterator r5 = BluetoothEventManager.access$1500(this.this$0).iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            ((BluetoothCallback) r5.next()).onBluetoothStateChanged(r4);
            goto L4
        L6:
            BluetoothEventManager.access$1600(this.this$0).onBluetoothStateChanged(r4);
        }
    }

    private class AudioModeChangedHandler implements Handler {
        final /* synthetic */ BluetoothEventManager this$0;

        private AudioModeChangedHandler(BluetoothEventManager r1) {
            this.this$0 = r1;
        }

        /* synthetic */ AudioModeChangedHandler(BluetoothEventManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.settingslib.bluetooth.BluetoothEventManager.Handler
        public void onReceive(Context r1, Intent r2, BluetoothDevice r3) {
            if (r2.getAction() != null) goto L6;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(BluetoothEventManager.TAG, "AudioModeChangedHandler() action is null");
            return;
        L6:
            BluetoothEventManager.access$2000(this.this$0);
        }
    }

    private class AutoOnStateChangedHandler implements Handler {
        final /* synthetic */ BluetoothEventManager this$0;

        private AutoOnStateChangedHandler(BluetoothEventManager r1) {
            this.this$0 = r1;
        }

        /* synthetic */ AutoOnStateChangedHandler(BluetoothEventManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.settingslib.bluetooth.BluetoothEventManager.Handler
        public void onReceive(Context r1, Intent r2, BluetoothDevice r3) {
            if (r2.getAction() != null) goto L6;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(BluetoothEventManager.TAG, "AutoOnStateChangedHandler() action is null");
            return;
        L6:
            int r4 = r2.getIntExtra("android.bluetooth.extra.AUTO_ON_STATE", Integer.MIN_VALUE);
            Iterator r0 = BluetoothEventManager.access$1500(this.this$0).iterator();
        L8:
            if (r0.hasNext() == false) goto L10;
            ((BluetoothCallback) r0.next()).onAutoOnStateChanged(r4);
            goto L8
        }
    }

    private class BatteryLevelChangedHandler implements Handler {
        final /* synthetic */ BluetoothEventManager this$0;

        private BatteryLevelChangedHandler(BluetoothEventManager r1) {
            this.this$0 = r1;
        }

        /* synthetic */ BatteryLevelChangedHandler(BluetoothEventManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.settingslib.bluetooth.BluetoothEventManager.Handler
        public void onReceive(Context r1, Intent r2, BluetoothDevice r3) {
            CachedBluetoothDevice r0 = BluetoothEventManager.access$1600(this.this$0).findDevice(r3);
            if (r0 == null) goto L6;
            r0.refresh();
            return;
        }
    }

    private class BluetoothBroadcastReceiver extends BroadcastReceiver {
        final /* synthetic */ BluetoothEventManager this$0;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            com_android_settingslib_bluetooth_BluetoothEventManager$BluetoothBroadcastReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
        }

        private BluetoothBroadcastReceiver(BluetoothEventManager r1) {
            this.this$0 = r1;
        }

        /* synthetic */ BluetoothBroadcastReceiver(BluetoothEventManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        public void com_android_settingslib_bluetooth_BluetoothEventManager$BluetoothBroadcastReceiver__onReceive$___twin___(Context r3, Intent r4) {
            String r0 = r4.getAction();
            BluetoothDevice r1 = (BluetoothDevice) r4.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            Handler r2 = (Handler) BluetoothEventManager.access$1300(this.this$0).get(r0);
            if (r2 == null) goto L6;
            r2.onReceive(r3, r4, r1);
            return;
        }

        @Insert("onReceive")
        public static void com_android_settingslib_bluetooth_BluetoothEventManager$BluetoothBroadcastReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(BluetoothBroadcastReceiver r7, Context r8, Intent r9) {
            Intrinsics.checkNotNullParameter(r8, "context");
            String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
            BluetoothBroadcastReceiver r1 = r7;
            String r2 = r1.getClass().getName();
            String r3 = r1.getClass().getSimpleName();
            boolean r4 = Intrinsics.areEqual(SettingsInitialize.class, r1.getClass());
            String r5 = null;
            if (r9 == null) goto L5;
            String r6 = r9.getAction();
        L7:
            if (ArraysKt.contains(r0, r6) == false) goto L13;
            StringBuilder r10 = new StringBuilder("onReceive allowList ");
            if (r9 == null) goto L11;
            r5 = r9.getAction();
        L11:
            OLog.i("PrivacyHookForReceiver", r10.append(r5).toString());
            r7.com_android_settingslib_bluetooth_BluetoothEventManager$BluetoothBroadcastReceiver__onReceive$___twin___(r8, r9);
            return;
        L13:
            GrantUtil r11 = GrantUtil.INSTANCE;
            Application r12 = SettingsApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
            if (r11.isSetupCompelete(r12) == true) goto L16;
            OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
            r7.com_android_settingslib_bluetooth_BluetoothEventManager$BluetoothBroadcastReceiver__onReceive$___twin___(r8, r9);
            return;
        L16:
            String r13 = r3;
            if (r13 != null) goto L19;
        L22:
            boolean r14 = true;
        L23:
            if (r14 == false) goto L26;
            OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
            r7.com_android_settingslib_bluetooth_BluetoothEventManager$BluetoothBroadcastReceiver__onReceive$___twin___(r8, r9);
            return;
        L26:
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
            if (r4 == true) goto L30;
            OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
            return;
        L30:
            GrantUtil.INSTANCE.applicationInit();
            r7.com_android_settingslib_bluetooth_BluetoothEventManager$BluetoothBroadcastReceiver__onReceive$___twin___(r8, r9);
            return;
        L19:
            if (r13.length() == 0) goto L22;
            r14 = false;
            goto L23
        L5:
            r6 = null;
            goto L7
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

        @Override // com.android.settingslib.bluetooth.BluetoothEventManager.Handler
        public void onReceive(Context r9, Intent r10, BluetoothDevice r11) {
            if (r11 != null) goto L6;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(BluetoothEventManager.TAG, "ACTION_BOND_STATE_CHANGED with no EXTRA_DEVICE");
            return;
        L6:
            int r1 = r10.getIntExtra("android.bluetooth.device.extra.BOND_STATE", Integer.MIN_VALUE);
            if (BluetoothEventManager.access$1600(this.this$0).onBondStateChangedIfProcess(r11, r1) == false) goto L10;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(BluetoothEventManager.TAG, "Should not update UI for the set member");
            return;
        L10:
            CachedBluetoothDevice r3 = BluetoothEventManager.access$1600(this.this$0).findDevice(r11);
            if (r3 != null) goto L14;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(BluetoothEventManager.TAG, "Got bonding state changed for " + r11 + ", but we have no record of that device.");
            r3 = BluetoothEventManager.access$1600(this.this$0).addDevice(r11);
        L14:
            if (Flags.enableCachedBluetoothDeviceDedup() == true) goto L16;
        L18:
            Iterator r12 = BluetoothEventManager.access$1500(this.this$0).iterator();
        L20:
            if (r12.hasNext() == false) goto L22;
            ((BluetoothCallback) r12.next()).onDeviceBondStateChanged(r3, r1);
            goto L20
        L22:
            r3.onBondingStateChanged(r1);
            if (r1 == 10) goto L25;
            return;
        L25:
            if (BluetoothEventManager.access$1800() == false) goto L28;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(BluetoothEventManager.TAG, "BondStateChangedHandler: cachedDevice.getGroupId() = " + r3.getGroupId() + ", cachedDevice.getHiSyncId()= " + r3.getHiSyncId());
        L28:
            if (r3.getGroupId() == (-1)) goto L30;
        L31:
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(BluetoothEventManager.TAG, "BondStateChangedHandler: Start onDeviceUnpaired");
            BluetoothEventManager.access$1600(this.this$0).onDeviceUnpaired(r3);
        L32:
            showUnbondMessage(r9, r3.getName(), r10.getIntExtra("android.bluetooth.device.extra.REASON", Integer.MIN_VALUE));
            return;
        L30:
            if (r3.getHiSyncId() == 0) goto L32;
        L16:
            if (r1 != 12) goto L18;
            BluetoothEventManager.access$1600(this.this$0).removeDuplicateInstanceForIdentityAddress(r11);
            goto L18
        }

        private void showUnbondMessage(Context r3, String r4, int r5) {
            if (BluetoothEventManager.access$1800() == false) goto L5;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(BluetoothEventManager.TAG, "showUnbondMessage() name : " + r4 + ", reason : " + r5);
        L5:
            switch(r5) {
                case 1: goto L11;
                case 2: goto L10;
                case 3: goto L6;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L8;
                case 7: goto L8;
                case 8: goto L8;
                default: goto L6;
            };
        L6:
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(BluetoothEventManager.TAG, "showUnbondMessage: Not displaying any message for reason: " + r5);
            return;
        L8:
            int r2 = R.string.bluetooth_pairing_error_message;
        L12:
            BluetoothUtils.showError(r3, r4, r2);
            return;
        L9:
            r2 = R.string.bluetooth_pairing_device_down_error_message;
            goto L12
        L10:
            r2 = R.string.bluetooth_pairing_rejected_error_message;
            goto L12
        L11:
            r2 = R.string.bluetooth_pairing_pin_error_message;
            goto L12
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

        @Override // com.android.settingslib.bluetooth.BluetoothEventManager.Handler
        public void onReceive(Context r1, Intent r2, BluetoothDevice r3) {
            CachedBluetoothDevice r0 = BluetoothEventManager.access$1600(this.this$0).findDevice(r3);
            if (r0 == null) goto L6;
            r0.refresh();
            return;
        }
    }

    private class ConnectionStateChangedHandler implements Handler {
        final /* synthetic */ BluetoothEventManager this$0;

        private ConnectionStateChangedHandler(BluetoothEventManager r1) {
            this.this$0 = r1;
        }

        /* synthetic */ ConnectionStateChangedHandler(BluetoothEventManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.settingslib.bluetooth.BluetoothEventManager.Handler
        public void onReceive(Context r2, Intent r3, BluetoothDevice r4) {
            CachedBluetoothDevice r5 = BluetoothEventManager.access$1600(this.this$0).findDevice(r4);
            int r6 = r3.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", Integer.MIN_VALUE);
            BluetoothEventManager.access$1700(this.this$0, r5, r6);
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

        @Override // com.android.settingslib.bluetooth.BluetoothEventManager.Handler
        public void onReceive(Context r3, Intent r4, BluetoothDevice r5) {
            short r6 = r4.getShortExtra("android.bluetooth.device.extra.RSSI", ShortCompanionObject.MIN_VALUE);
            r4.getStringExtra("android.bluetooth.device.extra.NAME");
            boolean r7 = r4.getBooleanExtra("android.bluetooth.extra.IS_COORDINATED_SET_MEMBER", false);
            CachedBluetoothDevice r0 = BluetoothEventManager.access$1600(this.this$0).findDevice(r5);
            if (r0 != null) goto L6;
            r0 = BluetoothEventManager.access$1600(this.this$0).addDevice(r5);
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(BluetoothEventManager.TAG, "DeviceFoundHandler created new CachedBluetoothDevice " + r0.getDevice().getAnonymizedAddress());
        L10:
            r0.setRssi(r6);
            r0.setJustDiscovered(true);
            r0.setIsCoordinatedSetMember(r7);
            return;
        L6:
            if (r0.getBondState() != 12) goto L10;
            if (r0.getDevice().isConnected() == true) goto L10;
            this.this$0.dispatchDeviceAdded(r0);
            goto L10
        }
    }

    interface Handler {
        void onReceive(Context r1, Intent r2, BluetoothDevice r3);
    }

    private class NameChangedHandler implements Handler {
        final /* synthetic */ BluetoothEventManager this$0;

        private NameChangedHandler(BluetoothEventManager r1) {
            this.this$0 = r1;
        }

        /* synthetic */ NameChangedHandler(BluetoothEventManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.settingslib.bluetooth.BluetoothEventManager.Handler
        public void onReceive(Context r1, Intent r2, BluetoothDevice r3) {
            BluetoothEventManager.access$1600(this.this$0).onDeviceNameUpdated(r3);
        }
    }

    private class ScanningStateChangedHandler implements Handler {
        private final boolean mStarted;
        final /* synthetic */ BluetoothEventManager this$0;

        ScanningStateChangedHandler(BluetoothEventManager r1, boolean r2) {
            this.this$0 = r1;
            this.mStarted = r2;
        }

        @Override // com.android.settingslib.bluetooth.BluetoothEventManager.Handler
        public void onReceive(Context r1, Intent r2, BluetoothDevice r3) {
            Iterator r4 = BluetoothEventManager.access$1500(this.this$0).iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            ((BluetoothCallback) r4.next()).onScanningStateChanged(this.mStarted);
            goto L4
        L6:
            BluetoothEventManager.access$1600(this.this$0).onScanningStateChanged(this.mStarted);
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

        @Override // com.android.settingslib.bluetooth.BluetoothEventManager.Handler
        public void onReceive(Context r1, Intent r2, BluetoothDevice r3) {
            CachedBluetoothDevice r0 = BluetoothEventManager.access$1600(this.this$0).findDevice(r3);
            if (r0 == null) goto L6;
            r0.onUuidChanged();
            return;
        }
    }

    static /* synthetic */ Map access$1300(BluetoothEventManager r0) {
        return r0.mHandlerMap;
    }

    static /* synthetic */ LocalBluetoothAdapter access$1400(BluetoothEventManager r0) {
        return r0.mLocalAdapter;
    }

    static /* synthetic */ Collection access$1500(BluetoothEventManager r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ CachedBluetoothDeviceManager access$1600(BluetoothEventManager r0) {
        return r0.mDeviceManager;
    }

    static /* synthetic */ void access$1700(BluetoothEventManager r0, CachedBluetoothDevice r1, int r2) {
        r0.dispatchConnectionStateChanged(r1, r2);
    }

    static /* synthetic */ boolean access$1800() {
        return DEBUG;
    }

    static /* synthetic */ void access$1900(BluetoothEventManager r0, CachedBluetoothDevice r1, int r2) {
        r0.dispatchAclStateChanged(r1, r2);
    }

    static /* synthetic */ void access$2000(BluetoothEventManager r0) {
        r0.dispatchAudioModeChanged();
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    BluetoothEventManager(LocalBluetoothAdapter r3, LocalBluetoothManager r4, CachedBluetoothDeviceManager r5, Context r6, android.os.Handler r7, UserHandle r8) {
        AnonymousClass1 r1 = null;
        this.mBroadcastReceiver = new BluetoothBroadcastReceiver(this, r1);
        this.mProfileBroadcastReceiver = new BluetoothBroadcastReceiver(this, r1);
        this.mCallbacks = new CopyOnWriteArrayList();
        this.mLocalAdapter = r3;
        this.mBtManager = r4;
        this.mDeviceManager = r5;
        this.mAdapterIntentFilter = new IntentFilter();
        this.mProfileIntentFilter = new IntentFilter();
        this.mHandlerMap = new HashMap();
        this.mContext = r6;
        this.mUserHandle = r8;
        this.mReceiverHandler = r7;
        addHandler("android.bluetooth.adapter.action.STATE_CHANGED", new AdapterStateChangedHandler(this, r1));
        addHandler("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED", new ConnectionStateChangedHandler(this, r1));
        addHandler("android.bluetooth.adapter.action.DISCOVERY_STARTED", new ScanningStateChangedHandler(this, true));
        addHandler("android.bluetooth.adapter.action.DISCOVERY_FINISHED", new ScanningStateChangedHandler(this, false));
        addHandler("android.bluetooth.device.action.FOUND", new DeviceFoundHandler(this, r1));
        addHandler("android.bluetooth.device.action.NAME_CHANGED", new NameChangedHandler(this, r1));
        addHandler("android.bluetooth.device.action.ALIAS_CHANGED", new NameChangedHandler(this, r1));
        addHandler("android.bluetooth.device.action.BOND_STATE_CHANGED", new BondStateChangedHandler(this, r1));
        addHandler("android.bluetooth.device.action.CLASS_CHANGED", new ClassChangedHandler(this, r1));
        addHandler("android.bluetooth.device.action.UUID", new UuidChangedHandler(this, r1));
        addHandler("android.bluetooth.device.action.BATTERY_LEVEL_CHANGED", new BatteryLevelChangedHandler(this, r1));
        addHandler("android.bluetooth.a2dp.profile.action.ACTIVE_DEVICE_CHANGED", new ActiveDeviceChangedHandler(this, r1));
        addHandler("android.bluetooth.headset.profile.action.ACTIVE_DEVICE_CHANGED", new ActiveDeviceChangedHandler(this, r1));
        addHandler("android.bluetooth.hearingaid.profile.action.ACTIVE_DEVICE_CHANGED", new ActiveDeviceChangedHandler(this, r1));
        addHandler("android.bluetooth.action.LE_AUDIO_ACTIVE_DEVICE_CHANGED", new ActiveDeviceChangedHandler(this, r1));
        addHandler("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED", new AudioModeChangedHandler(this, r1));
        addHandler("android.intent.action.PHONE_STATE", new AudioModeChangedHandler(this, r1));
        addHandler("android.bluetooth.device.action.ACL_CONNECTED", new AclStateChangedHandler(this, r1));
        addHandler("android.bluetooth.device.action.ACL_DISCONNECTED", new AclStateChangedHandler(this, r1));
        addHandler("android.bluetooth.action.AUTO_ON_STATE_CHANGED", new AutoOnStateChangedHandler(this, r1));
        registerAdapterIntentReceiver();
    }

    public void registerCallback(BluetoothCallback r1) {
        this.mCallbacks.add(r1);
    }

    public void unregisterCallback(BluetoothCallback r1) {
        this.mCallbacks.remove(r1);
    }

    void registerProfileIntentReceiver() {
        registerIntentReceiver(this.mProfileBroadcastReceiver, this.mProfileIntentFilter);
    }

    void registerAdapterIntentReceiver() {
        registerIntentReceiver(this.mBroadcastReceiver, this.mAdapterIntentFilter);
    }

    private void registerIntentReceiver(BroadcastReceiver r10, IntentFilter r11) {
        UserHandle r2 = this.mUserHandle;
        if (r2 != null) goto L5;
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, r10, r11, null, this.mReceiverHandler, 2);
        return;
    L5:
        this.mContext.registerReceiverAsUser(r10, r2, r11, null, this.mReceiverHandler, 2);
    }

    void addProfileHandler(String r2, Handler r3) {
        this.mHandlerMap.put(r2, r3);
        this.mProfileIntentFilter.addAction(r2);
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
        this.mDeviceManager.addDevice(r3);
        r1 = true;
        goto L7
    L11:
        return r1;
    }

    void dispatchDeviceAdded(CachedBluetoothDevice r2) {
        Iterator<BluetoothCallback> r1 = this.mCallbacks.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onDeviceAdded(r2);
        goto L4
    }

    void dispatchDeviceRemoved(CachedBluetoothDevice r2) {
        Iterator<BluetoothCallback> r1 = this.mCallbacks.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onDeviceDeleted(r2);
        goto L4
    }

    void dispatchProfileConnectionStateChanged(CachedBluetoothDevice r3, int r4, int r5) {
        Iterator<BluetoothCallback> r0 = this.mCallbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        r0.next().onProfileConnectionStateChanged(r3, r4, r5);
        goto L4
    L7:
        if (r5 != 29) goto L24;
        if (r4 == 0) goto L10;
        return;
    L10:
        if (BluetoothUtils.isAudioSharingEnabled() == false) goto L26;
        LocalBluetoothProfileManager r2 = this.mBtManager.getProfileManager();
        if (r2 != null) goto L14;
        return;
    L14:
        if (r2.getLeAudioBroadcastProfile() != null) goto L16;
        return;
    L16:
        if (r2.getLeAudioBroadcastProfile().isProfileReady() == true) goto L18;
        return;
    L18:
        if (r2.getLeAudioBroadcastAssistantProfile() != null) goto L20;
        return;
    L20:
        if (r2.getLeAudioBroadcastAssistantProfile().isProfileReady() == false) goto L31;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "updateFallbackActiveDeviceIfNeeded, ASSISTANT profile disconnected");
        r2.getLeAudioBroadcastProfile().updateFallbackActiveDeviceIfNeeded();
        return;
    L31:
        return;
    L26:
        return;
    }

    private void dispatchConnectionStateChanged(CachedBluetoothDevice r2, int r3) {
        Iterator<BluetoothCallback> r1 = this.mCallbacks.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onConnectionStateChanged(r2, r3);
        goto L4
    }

    private void dispatchAudioModeChanged() {
        Iterator<CachedBluetoothDevice> r0 = this.mDeviceManager.getCachedDevicesCopy().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onAudioModeChanged();
        goto L4
    L6:
        Iterator<BluetoothCallback> r2 = this.mCallbacks.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r2.next().onAudioModeChanged();
        goto L8
    }

    void dispatchActiveDeviceChanged(final CachedBluetoothDevice r5, int r6) {
        Iterator<CachedBluetoothDevice> r0 = this.mDeviceManager.getCachedDevicesCopy().iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        CachedBluetoothDevice r1 = r0.next();
        CachedBluetoothDevice r2 = r1.getSubDevice();
        if (r5 == null) goto L13;
        if (r2 == null) goto L11;
        if (r2.equals(r5) == false) goto L11;
    L12:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "The active device is the sub/member device " + r5.getDevice().getAnonymizedAddress() + ". change targetDevice as main device " + r1.getDevice().getAnonymizedAddress());
        r5 = r1;
    L11:
        if (r1.getMemberDevice().stream().anyMatch(new BluetoothEventManager$$ExternalSyntheticLambda0(r5)) == true) goto L12;
    L13:
        r1.onActiveDeviceChanged(r1.equals(r5), r6);
        this.mDeviceManager.onActiveDeviceChanged(r1);
        goto L4
    L14:
        Iterator<BluetoothCallback> r4 = this.mCallbacks.iterator();
    L16:
        if (r4.hasNext() == false) goto L18;
        r4.next().onActiveDeviceChanged(r5, r6);
        goto L16
    }

    static /* synthetic */ boolean lambda$dispatchActiveDeviceChanged$0(CachedBluetoothDevice r0, CachedBluetoothDevice r1) {
        return r1.equals(r0);
    }

    private void dispatchAclStateChanged(CachedBluetoothDevice r2, int r3) {
        Iterator<BluetoothCallback> r1 = this.mCallbacks.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onAclConnectionStateChanged(r2, r3);
        goto L4
    }

    void addHandler(String r2, Handler r3) {
        this.mHandlerMap.put(r2, r3);
        this.mAdapterIntentFilter.addAction(r2);
    }
}
