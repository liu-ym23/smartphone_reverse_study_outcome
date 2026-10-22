package com.android.settings.bluetooth;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.Service;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.SystemProperties;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.GlobalProxyLancet;
import com.android.settings.AdaptBluetoothDevice;
import com.android.settings.R;
import com.obric.olog.OLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class DockService extends Service implements LocalBluetoothProfileManager.ServiceListener {
    static final boolean DEBUG = false;
    private static final long DISABLE_BT_GRACE_PERIOD = 2000;
    private static final int INVALID_STARTID = -100;
    private static final String KEY_CONNECT_RETRY_COUNT = "connect_retry_count";
    private static final String KEY_DISABLE_BT = "disable_bt";
    private static final String KEY_DISABLE_BT_WHEN_UNDOCKED = "disable_bt_when_undock";
    private static final int MAX_CONNECT_RETRY = 6;
    private static final int MSG_TYPE_DISABLE_BT = 555;
    private static final int MSG_TYPE_DOCKED = 222;
    private static final int MSG_TYPE_SHOW_UI = 111;
    private static final int MSG_TYPE_UNDOCKED_PERMANENT = 444;
    private static final int MSG_TYPE_UNDOCKED_TEMPORARY = 333;
    private static final String SHARED_PREFERENCES_NAME = "dock_settings";
    private static final String TAG = "DockService";
    private static final long UNDOCKED_GRACE_PERIOD = 1000;
    private CheckBox mAudioMediaCheckbox;
    private final CompoundButton.OnCheckedChangeListener mCheckedChangeListener;
    private boolean[] mCheckedItems;
    private final DialogInterface.OnClickListener mClickListener;
    private BluetoothDevice mDevice;
    private CachedBluetoothDeviceManager mDeviceManager;
    private AlertDialog mDialog;
    private final DialogInterface.OnDismissListener mDismissListener;
    private LocalBluetoothAdapter mLocalAdapter;
    private final DialogInterface.OnMultiChoiceClickListener mMultiClickListener;
    private BluetoothDevice mPendingDevice;
    private int mPendingStartId;
    private int mPendingTurnOffStartId;
    private int mPendingTurnOnStartId;
    private LocalBluetoothProfileManager mProfileManager;
    private LocalBluetoothProfile[] mProfiles;
    private Runnable mRunnable;
    private volatile ServiceHandler mServiceHandler;
    private volatile Looper mServiceLooper;
    private int mStartIdAssociatedWithDialog;

    public static class DockBluetoothCallback implements BluetoothCallback {
        private final Context mContext;

        @Override // com.android.settings.bluetooth.BluetoothCallback
        public void onBluetoothStateChanged(int r1) {
        }

        public void onConnectionStateChanged(CachedBluetoothDevice r1, int r2) {
        }

        @Override // com.android.settings.bluetooth.BluetoothCallback
        public void onDeviceAdded(CachedBluetoothDevice r1) {
        }

        @Override // com.android.settings.bluetooth.BluetoothCallback
        public void onDeviceBondStateChanged(CachedBluetoothDevice r1, int r2) {
        }

        @Override // com.android.settings.bluetooth.BluetoothCallback
        public void onDeviceDeleted(CachedBluetoothDevice r1) {
        }

        public DockBluetoothCallback(Context r1) {
            this.mContext = r1;
        }

        @Override // com.android.settings.bluetooth.BluetoothCallback
        public void onScanningStateChanged(boolean r1) {
            LocalBluetoothPreferences.persistDiscoveringTimestamp(this.mContext);
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
    }

    private final class ServiceHandler extends Handler {
        final /* synthetic */ DockService this$0;

        /* synthetic */ ServiceHandler(DockService r1, Looper r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private ServiceHandler(DockService r1, Looper r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r1) {
            DockService.access$100(this.this$0, r1);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r1) {
        return null;
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfileManager.ServiceListener
    public void onServiceDisconnected() {
    }

    public DockService() {
        this.mPendingTurnOnStartId = -100;
        this.mPendingTurnOffStartId = -100;
        this.mMultiClickListener = new AnonymousClass2(this);
        this.mCheckedChangeListener = new AnonymousClass3(this);
        this.mDismissListener = new AnonymousClass4(this);
        this.mClickListener = new AnonymousClass5(this);
    }

    static /* synthetic */ void access$100(DockService r0, Message r1) {
        r0.processMessage(r1);
    }

    static /* synthetic */ void access$200(DockService r0, BluetoothDevice r1, int r2, int r3) {
        r0.handleDocked(r1, r2, r3);
    }

    static /* synthetic */ boolean[] access$300(DockService r0) {
        return r0.mCheckedItems;
    }

    static /* synthetic */ BluetoothDevice access$400(DockService r0) {
        return r0.mDevice;
    }

    static /* synthetic */ BluetoothDevice access$500(DockService r0) {
        return r0.mPendingDevice;
    }

    static /* synthetic */ int access$600(DockService r0) {
        return r0.mStartIdAssociatedWithDialog;
    }

    static /* synthetic */ void access$700(DockService r0, BluetoothDevice r1, int r2) {
        r0.applyBtSettings(r1, r2);
    }

    static /* synthetic */ CheckBox access$800(DockService r0) {
        return r0.mAudioMediaCheckbox;
    }

    static {
        boolean r1 = false;
        if (SystemProperties.getInt("ro.debuggable", 0) != 1) goto L5;
        r1 = true;
    L5:
        DEBUG = r1;
    }

    @Override // android.app.Service
    public void onCreate() {
        if (DEBUG == false) goto L5;
        OLog.d(TAG, "onCreate");
    L5:
        LocalBluetoothManager r0 = LocalBluetoothManager.getInstance(this);
        if (r0 != null) goto L9;
        OLog.e(TAG, "Can't get LocalBluetoothManager: exiting");
        return;
    L9:
        this.mLocalAdapter = r0.getBluetoothAdapter();
        this.mDeviceManager = r0.getCachedDeviceManager();
        LocalBluetoothProfileManager r1 = r0.getProfileManager();
        this.mProfileManager = r1;
        if (r1 != null) goto L13;
        OLog.e(TAG, "Can't get LocalBluetoothProfileManager: exiting");
        return;
    L13:
        HandlerThread r2 = new HandlerThread(TAG);
        r2.start();
        this.mServiceLooper = r2.getLooper();
        this.mServiceHandler = new ServiceHandler(this, this.mServiceLooper, null);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (DEBUG == false) goto L5;
        OLog.d(TAG, "onDestroy");
    L5:
        this.mRunnable = null;
        AlertDialog r1 = this.mDialog;
        if (r1 == null) goto L8;
        r1.dismiss();
        this.mDialog = null;
    L8:
        LocalBluetoothProfileManager r2 = this.mProfileManager;
        if (r2 == null) goto L12;
        r2.removeServiceListener(this);
    L12:
        if (this.mServiceLooper == null) goto L14;
        this.mServiceLooper.quit();
    L14:
        this.mLocalAdapter = null;
        this.mDeviceManager = null;
        this.mProfileManager = null;
        this.mServiceLooper = null;
        this.mServiceHandler = null;
    }

    private SharedPreferences getPrefs() {
        return getSharedPreferences(SHARED_PREFERENCES_NAME, 0);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r10, int r11, int r12) {
        boolean r0 = DEBUG;
        if (r0 == false) goto L6;
        OLog.d(TAG, "onStartCommand startId: " + r12 + " flags: " + r11);
    L6:
        if (r10 != null) goto L12;
        if (r0 == false) goto L9;
        OLog.d(TAG, "START_NOT_STICKY - intent is null.");
    L9:
        DockEventReceiver.finishStartingService(this, r12);
        return 2;
    L12:
        if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(r10.getAction()) == false) goto L15;
        handleBtStateChange(r10, r12);
        return 2;
    L15:
        SharedPreferences r2 = getPrefs();
        if ("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(r10.getAction()) == false) goto L22;
        BluetoothDevice r13 = (BluetoothDevice) r10.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        int r1 = r2.getInt(KEY_CONNECT_RETRY_COUNT, 0);
        if (r1 >= 6) goto L20;
        r2.edit().putInt(KEY_CONNECT_RETRY_COUNT, r1 + 1).apply();
        handleUnexpectedDisconnect(r13, this.mProfileManager.getHeadsetProfile(), r12);
    L20:
        return 2;
    L22:
        if ("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED".equals(r10.getAction()) == false) goto L27;
        BluetoothDevice r14 = (BluetoothDevice) r10.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        int r3 = r2.getInt(KEY_CONNECT_RETRY_COUNT, 0);
        if (r3 >= 6) goto L26;
        r2.edit().putInt(KEY_CONNECT_RETRY_COUNT, r3 + 1).apply();
        handleUnexpectedDisconnect(r14, this.mProfileManager.getA2dpProfile(), r12);
    L26:
        return 2;
    L27:
        Message r15 = parseIntent(r10);
        if (r15 != null) goto L34;
        if (r0 == false) goto L31;
        OLog.d(TAG, "START_NOT_STICKY - Bad intent.");
    L31:
        DockEventReceiver.finishStartingService(this, r12);
        return 2;
    L34:
        if (r15.what != 222) goto L36;
        r2.edit().remove(KEY_CONNECT_RETRY_COUNT).apply();
    L36:
        r15.arg2 = r12;
        processMessage(r15);
        return 2;
    }

    private synchronized void processMessage(Message r7) {
        monitor-enter(this);
        int r1 = r7.what;     // Catch: Throwable -> L41
        int r2 = r7.arg1;     // Catch: Throwable -> L41
        int r3 = r7.arg2;     // Catch: Throwable -> L41
        if (r7.obj == null) goto L7;
        BluetoothDevice r8 = (BluetoothDevice) r7.obj;     // Catch: Throwable -> L41
    L9:
        if (DEBUG == false) goto L16;
        StringBuilder r0 = new StringBuilder("processMessage: ").append(r1).append(" state: ").append(r2).append(" device = ");     // Catch: Throwable -> L41
        if (r8 != null) goto L13;
        String r5 = "null";
    L14:
        OLog.d(TAG, r0.append(r5).toString());     // Catch: Throwable -> L41
        goto L16
    L13:
        r5 = r8.toString();     // Catch: Throwable -> L41
    L16:
        if (r1 != 111) goto L18;
        if (r8 == null) goto L31;
        createDialog(r8, r2, r3);     // Catch: Throwable -> L41
    L31:
        boolean r9 = false;
    L33:
        if (this.mDialog == null) goto L35;
    L39:
        monitor-exit(this);
        return;
    L35:
        if (this.mPendingDevice != null) goto L39;
        if (r1 == MSG_TYPE_UNDOCKED_TEMPORARY) goto L39;
        if (r9 == true) goto L39;
        DockEventReceiver.finishStartingService(this, r3);     // Catch: Throwable -> L41
        goto L39
    L18:
        if (r1 == 222) goto L28;
        if (r1 != MSG_TYPE_UNDOCKED_TEMPORARY) goto L21;
        msgTypeUndockedTemporary(r8, r2, r3);     // Catch: Throwable -> L41
        goto L31
    L21:
        if (r1 != MSG_TYPE_UNDOCKED_PERMANENT) goto L23;
        r9 = msgTypeUndockedPermanent(r8, r3);     // Catch: Throwable -> L41
        goto L33
    L23:
        if (r1 != MSG_TYPE_DISABLE_BT) goto L31;
        r9 = msgTypeDisableBluetooth(r3);     // Catch: Throwable -> L41
        goto L33
    L28:
        r9 = msgTypeDocked(r8, r2, r3);     // Catch: Throwable -> L41
        goto L33
    L7:
        r8 = null;
    L41:
        th = move-exception;
        throw th;
    }

    private boolean msgTypeDisableBluetooth(int r6) {
        boolean r0 = DEBUG;
        if (r0 == false) goto L5;
        OLog.d(TAG, "BT DISABLE");
    L5:
        SharedPreferences r2 = getPrefs();
        if (this.mLocalAdapter.disable() == false) goto L9;
        r2.edit().remove(KEY_DISABLE_BT_WHEN_UNDOCKED).apply();
        return false;
    L9:
        r2.edit().putBoolean(KEY_DISABLE_BT, true).apply();
        this.mPendingTurnOffStartId = r6;
        if (r0 == false) goto L12;
        OLog.d(TAG, "disable failed. try again later " + r6);
    L12:
        return true;
    }

    private void msgTypeUndockedTemporary(BluetoothDevice r3, int r4, int r5) {
        Message r6 = this.mServiceHandler.obtainMessage(MSG_TYPE_UNDOCKED_PERMANENT, r4, r5, r3);
        this.mServiceHandler.sendMessageDelayed(r6, 1000);
    }

    private boolean msgTypeUndockedPermanent(BluetoothDevice r8, int r9) {
        handleUndocked(r8);
        if (r8 == null) goto L16;
        SharedPreferences r1 = getPrefs();
        boolean r2 = DEBUG;
        if (r2 == false) goto L8;
        OLog.d(TAG, "DISABLE_BT_WHEN_UNDOCKED = " + r1.getBoolean(KEY_DISABLE_BT_WHEN_UNDOCKED, false));
    L8:
        if (r1.getBoolean(KEY_DISABLE_BT_WHEN_UNDOCKED, false) == false) goto L16;
        if (hasOtherConnectedDevices(r8) == false) goto L12;
        r1.edit().remove(KEY_DISABLE_BT_WHEN_UNDOCKED).apply();
        goto L16
    L12:
        if (r2 == false) goto L14;
        OLog.d(TAG, "QUEUED BT DISABLE");
    L14:
        this.mServiceHandler.sendMessageDelayed(this.mServiceHandler.obtainMessage(MSG_TYPE_DISABLE_BT, 0, r9, null), DISABLE_BT_GRACE_PERIOD);
        return true;
    L16:
        return false;
    }

    private boolean msgTypeDocked(final BluetoothDevice r5, final int r6, final int r7) {
        if (DEBUG == false) goto L5;
        OLog.d(TAG, "1 Has undock perm msg = " + this.mServiceHandler.hasMessages(MSG_TYPE_UNDOCKED_PERMANENT, this.mDevice));
        OLog.d(TAG, "2 Has undock perm msg = " + this.mServiceHandler.hasMessages(MSG_TYPE_UNDOCKED_PERMANENT, r5));
    L5:
        this.mServiceHandler.removeMessages(MSG_TYPE_UNDOCKED_PERMANENT);
        this.mServiceHandler.removeMessages(MSG_TYPE_DISABLE_BT);
        getPrefs().edit().remove(KEY_DISABLE_BT).apply();
        if (r5 == null) goto L18;
        if (r5.equals(this.mDevice) == true) goto L23;
        BluetoothDevice r1 = this.mDevice;
        if (r1 == null) goto L12;
        handleUndocked(r1);
    L12:
        this.mDevice = r5;
        this.mProfileManager.addServiceListener(this);
        if (this.mProfileManager.isManagerReady() == false) goto L15;
        handleDocked(r5, r6, r7);
        this.mProfileManager.removeServiceListener(this);
        return false;
    L15:
        this.mRunnable = new AnonymousClass1(this, r5, r6, r7);
        return true;
    L23:
        return false;
    L18:
        if (Settings.Global.getInt(getContentResolver(), "dock_audio_media_enabled", -1) == (-1)) goto L20;
        return false;
    L20:
        if (r6 != 3) goto L27;
        handleDocked(null, r6, r7);
        return true;
    L27:
        return false;
    }

    synchronized boolean hasOtherConnectedDevices(BluetoothDevice r8) {
        monitor-enter(this);
        Collection<CachedBluetoothDevice> r2 = this.mDeviceManager.getCachedDevicesCopy();     // Catch: Throwable -> L32
        Set<BluetoothDevice> r3 = this.mLocalAdapter.getBondedDevices();     // Catch: Throwable -> L32
        if (r3 == null) goto L30;
        if (r2 == null) goto L30;
        if (r3.isEmpty() == true) goto L30;
        if (DEBUG == false) goto L13;
        OLog.d(TAG, "btDevices = " + r3.size());     // Catch: Throwable -> L32
        OLog.d(TAG, "cachedDeviceUIs = " + r2.size());     // Catch: Throwable -> L32
    L13:
        Iterator<CachedBluetoothDevice> r0 = r2.iterator();     // Catch: Throwable -> L32
    L15:
        if (r0.hasNext() == false) goto L28;
        CachedBluetoothDevice r1 = r0.next();     // Catch: Throwable -> L32
        BluetoothDevice r4 = r1.getDevice();     // Catch: Throwable -> L32
        if (r4.equals(r8) == true) goto L15;
        if (r3.contains(r4) == false) goto L15;
        if (r1.isConnected() == false) goto L15;
        if (DEBUG == false) goto L25;
        OLog.d(TAG, "connected deviceUI = " + r1.getName());     // Catch: Throwable -> L32
    L25:
        monitor-exit(this);
        return true;
    L28:
        monitor-exit(this);
        return false;
    L30:
        monitor-exit(this);
        return false;
    L32:
        th = move-exception;
        throw th;
    }

    private Message parseIntent(Intent r7) {
        BluetoothDevice r0 = (BluetoothDevice) r7.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        int r1 = r7.getIntExtra("android.intent.extra.DOCK_STATE", -1234);
        if (DEBUG == false) goto L9;
        StringBuilder r2 = new StringBuilder("Action: ").append(r7.getAction()).append(" State:").append(r1).append(" Device: ");
        if (r0 != null) goto L7;
        String r4 = "null";
    L8:
        OLog.d(TAG, r2.append(r4).toString());
        goto L9
    L7:
        r4 = AdaptBluetoothDevice.getDeviceAliasName(r0);
    L9:
        if (r1 != 0) goto L11;
        int r8 = MSG_TYPE_UNDOCKED_TEMPORARY;
    L31:
        return this.mServiceHandler.obtainMessage(r8, r1, 0, r0);
    L11:
        if (r1 != 1) goto L13;
    L19:
        if (r0 != null) goto L23;
        OLog.w(TAG, "device is null");
        return null;
    L23:
        if (DockEventReceiver.ACTION_DOCK_SHOW_UI.equals(r7.getAction()) == false) goto L28;
        if (r0 != null) goto L27;
        OLog.w(TAG, "device is null");
        return null;
    L27:
        r8 = 111;
        goto L31
    L28:
        r8 = 222;
        goto L31
    L13:
        if (r1 == 2) goto L19;
        if (r1 == 3) goto L23;
        if (r1 == 4) goto L19;
        return null;
    }

    private void createDialog(BluetoothDevice r11, int r12, int r13) {
        AlertDialog r0 = this.mDialog;
        if (r0 == null) goto L5;
        r0.dismiss();
        this.mDialog = null;
    L5:
        this.mDevice = r11;
        boolean r1 = true;
        if (r12 != 1) goto L8;
    L14:
        startForeground(0, new Notification());
        AlertDialog.Builder r2 = new AlertDialog.Builder(this);
        LayoutInflater r4 = (LayoutInflater) getSystemService("layout_inflater");
        this.mAudioMediaCheckbox = null;
        if (r11 == null) goto L26;
        boolean r6 = !LocalBluetoothPreferences.hasDockAutoConnectSetting(this, r11.getAddress());
        CharSequence[] r14 = initBtSettings(r11, r12, r6);
        r2.setTitle(getString(R.string.bluetooth_dock_settings_title));
        r2.setMultiChoiceItems(r14, this.mCheckedItems, this.mMultiClickListener);
        View r15 = r4.inflate(R.layout.remember_dock_setting, null);
        CheckBox r3 = (CheckBox) r15.findViewById(R.id.remember);
        if (r6 == false) goto L19;
    L22:
        r3.setChecked(r1);
        r3.setOnCheckedChangeListener(this.mCheckedChangeListener);
        if (DEBUG == false) goto L25;
        OLog.d(TAG, "Auto connect = " + LocalBluetoothPreferences.getDockAutoConnectSetting(this, r11.getAddress()));
    L25:
        View r5 = r15;
    L31:
        int r8 = (int) (getResources().getDisplayMetrics().density * 14.0f);
        r2.setView(r5, r8, 0, r8, 0);
        r2.setPositiveButton(getString(android.R.string.ok), this.mClickListener);
        this.mStartIdAssociatedWithDialog = r13;
        AlertDialog r16 = r2.create();
        this.mDialog = r16;
        r16.getWindow().setType(2009);
        this.mDialog.setOnDismissListener(this.mDismissListener);
        this.mDialog.show();
        return;
    L19:
        if (LocalBluetoothPreferences.getDockAutoConnectSetting(this, r11.getAddress()) == true) goto L22;
        r1 = false;
        goto L22
    L26:
        r2.setTitle(getString(R.string.bluetooth_dock_settings_title));
        View r17 = r4.inflate(R.layout.dock_audio_media_enable_dialog, null);
        this.mAudioMediaCheckbox = (CheckBox) r17.findViewById(R.id.dock_audio_media_enable_cb);
        if (Settings.Global.getInt(getContentResolver(), "dock_audio_media_enabled", 0) == 1) goto L30;
        r1 = false;
    L30:
        this.mAudioMediaCheckbox.setChecked(r1);
        this.mAudioMediaCheckbox.setOnCheckedChangeListener(this.mCheckedChangeListener);
        r5 = r17;
        goto L31
    L8:
        if (r12 == 2) goto L14;
        if (r12 == 3) goto L14;
        if (r12 == 4) goto L14;
    }

    private CharSequence[] initBtSettings(BluetoothDevice r8, int r9, boolean r10) {
        if (r9 == 1) goto L10;
        if (r9 == 2) goto L9;
        if (r9 == 3) goto L10;
        if (r9 == 4) goto L10;
        return null;
    L9:
        int r4 = 2;
    L11:
        this.mProfiles = new LocalBluetoothProfile[r4];
        this.mCheckedItems = new boolean[r4];
        CharSequence[] r5 = new CharSequence[r4];
        if (r9 == 1) goto L21;
        if (r9 == 2) goto L17;
        if (r9 == 3) goto L21;
        if (r9 == 4) goto L21;
    L25:
        return r5;
    L17:
        r5[0] = getString(R.string.bluetooth_dock_settings_headset);
        r5[1] = getString(R.string.bluetooth_dock_settings_a2dp);
        this.mProfiles[0] = this.mProfileManager.getHeadsetProfile();
        this.mProfiles[1] = this.mProfileManager.getA2dpProfile();
        if (r10 == false) goto L20;
        boolean[] r7 = this.mCheckedItems;
        r7[0] = true;
        r7[1] = true;
        goto L25
    L20:
        this.mCheckedItems[0] = this.mProfiles[0].isPreferred(r8);
        this.mCheckedItems[1] = this.mProfiles[1].isPreferred(r8);
    L21:
        r5[0] = getString(R.string.bluetooth_dock_settings_a2dp);
        this.mProfiles[0] = this.mProfileManager.getA2dpProfile();
        if (r10 == false) goto L24;
        this.mCheckedItems[0] = false;
        goto L25
    L24:
        this.mCheckedItems[0] = this.mProfiles[0].isPreferred(r8);
    L10:
        r4 = 1;
        goto L11
    }

    private void handleBtStateChange(Intent r6, int r7) {
        int r8 = r6.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
        monitor-enter(this);
        boolean r2 = DEBUG;     // Catch: Throwable -> L26
        if (r2 == false) goto L8;
        OLog.d(TAG, "BtState = " + r8 + " mPendingDevice = " + this.mPendingDevice);     // Catch: Throwable -> L26
    L8:
        if (r8 != 12) goto L11;
        handleBluetoothStateOn(r7);     // Catch: Throwable -> L26
    L24:
        monitor-exit(this);     // Catch: Throwable -> L26
        return;
    L11:
        if (r8 != 13) goto L14;
        getPrefs().edit().remove(KEY_DISABLE_BT_WHEN_UNDOCKED).apply();     // Catch: Throwable -> L26
        DockEventReceiver.finishStartingService(this, r7);     // Catch: Throwable -> L26
        goto L24
    L14:
        if (r8 != 10) goto L24;
        if (r2 == false) goto L17;
        OLog.d(TAG, "Bluetooth = OFF mPendingDevice = " + this.mPendingDevice);     // Catch: Throwable -> L26
    L17:
        int r9 = this.mPendingTurnOffStartId;     // Catch: Throwable -> L26
        if (r9 == (-100)) goto L21;
        DockEventReceiver.finishStartingService(this, r9);     // Catch: Throwable -> L26
        getPrefs().edit().remove(KEY_DISABLE_BT).apply();     // Catch: Throwable -> L26
        this.mPendingTurnOffStartId = -100;     // Catch: Throwable -> L26
    L21:
        if (this.mPendingDevice == null) goto L23;
        this.mLocalAdapter.enable();     // Catch: Throwable -> L26
        this.mPendingTurnOnStartId = r7;     // Catch: Throwable -> L26
        goto L24
    L23:
        DockEventReceiver.finishStartingService(this, r7);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    private void handleBluetoothStateOn(int r7) {
        BluetoothDevice r0 = this.mPendingDevice;
        Intent r1 = null;
        if (r0 != null) goto L5;
        SharedPreferences r2 = getPrefs();
        if (DEBUG == false) goto L38;
        OLog.d(TAG, "A DISABLE_BT_WHEN_UNDOCKED = " + r2.getBoolean(KEY_DISABLE_BT_WHEN_UNDOCKED, false));
    L38:
        r1 = GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, null, new IntentFilter("android.intent.action.DOCK_EVENT"));     // Catch: Exception -> L19
    L21:
        if (r1 != null) goto L23;
    L33:
        int r3 = this.mPendingTurnOnStartId;
        if (r3 == (-100)) goto L36;
        DockEventReceiver.finishStartingService(this, r3);
        this.mPendingTurnOnStartId = -100;
    L36:
        DockEventReceiver.finishStartingService(this, r7);
        return;
    L23:
        if (r1.getIntExtra("android.intent.extra.DOCK_STATE", 0) == 0) goto L28;
        BluetoothDevice r4 = (BluetoothDevice) r1.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (r4 == null) goto L33;
        connectIfEnabled(r4);
        goto L33
    L28:
        if (r2.getBoolean(KEY_DISABLE_BT, false) == false) goto L33;
        if (this.mLocalAdapter.disable() == false) goto L33;
        this.mPendingTurnOffStartId = r7;
        r2.edit().remove(KEY_DISABLE_BT).apply();
        return;
    L19:
        e = move-exception;
        OLog.e(TAG, "registerReceiver failed", e);
        goto L21
    L5:
        if (r0.equals(this.mDevice) == false) goto L11;
        if (DEBUG == false) goto L9;
        OLog.d(TAG, "applying settings");
    L9:
        applyBtSettings(this.mPendingDevice, this.mPendingStartId);
    L13:
        this.mPendingDevice = null;
        DockEventReceiver.finishStartingService(this, this.mPendingStartId);
        goto L33
    L11:
        if (DEBUG == false) goto L13;
        OLog.d(TAG, "mPendingDevice  (" + this.mPendingDevice + ") != mDevice (" + this.mDevice + ')');
        goto L13
    }

    private synchronized void handleUnexpectedDisconnect(BluetoothDevice r4, LocalBluetoothProfile r5, int r6) {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (DEBUG == false) goto L7;
        OLog.d(TAG, "handling failed connect for " + r4);     // Catch: Throwable -> L20
    L7:
        if (r4 == null) goto L17;
        Intent r0 = GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, null, new IntentFilter("android.intent.action.DOCK_EVENT"));     // Catch: Throwable -> L20
        if (r0 == null) goto L17;
        if (r0.getIntExtra("android.intent.extra.DOCK_STATE", 0) == 0) goto L17;
        BluetoothDevice r1 = (BluetoothDevice) r0.getParcelableExtra("android.bluetooth.device.extra.DEVICE");     // Catch: Throwable -> L20
        if (r1 == null) goto L17;
        if (r1.equals(r4) == false) goto L17;
        getCachedBluetoothDevice(r1).connectProfile(r5);     // Catch: Throwable -> L20
    L17:
        DockEventReceiver.finishStartingService(this, r6);     // Catch: Throwable -> L20
        monitor-exit(this);
    }

    private synchronized void connectIfEnabled(BluetoothDevice r5) {
        monitor-enter(this);
        CachedBluetoothDevice r0 = getCachedBluetoothDevice(r5);     // Catch: Throwable -> L13
        Iterator<LocalBluetoothProfile> r1 = r0.getConnectableProfiles().iterator();     // Catch: Throwable -> L13
    L5:
        if (r1.hasNext() == false) goto L11;
        if (r1.next().getPreferred(r5) != 1000) goto L5;
        r0.connect(false);     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L11:
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private synchronized void applyBtSettings(BluetoothDevice r10, int r11) {
        monitor-enter(this);
        if (r10 != null) goto L67;
    L65:
        monitor-exit(this);
        return;
    L67:
    L62:
        th = move-exception;
        throw th;
    L5:
        if (this.mProfiles == null) goto L65;
        boolean[] r0 = this.mCheckedItems;     // Catch: Throwable -> L62
        if (r0 == null) goto L65;
        if (this.mLocalAdapter == null) goto L65;
        int r1 = r0.length;     // Catch: Throwable -> L62
        int r3 = 0;
    L13:
        if (r3 >= r1) goto L34;
        if (r0[r3] == false) goto L32;
        int r5 = this.mLocalAdapter.getBluetoothState();     // Catch: Throwable -> L62
        if (DEBUG == false) goto L19;
        OLog.d(TAG, "BtState = " + r5);     // Catch: Throwable -> L62
    L19:
        this.mLocalAdapter.enable();     // Catch: Throwable -> L62
        if (r5 == 12) goto L32;
        BluetoothDevice r2 = this.mPendingDevice;     // Catch: Throwable -> L62
        if (r2 != null) goto L24;
    L27:
        this.mPendingDevice = r10;     // Catch: Throwable -> L62
        this.mPendingStartId = r11;     // Catch: Throwable -> L62
        if (r5 == 11) goto L30;
        getPrefs().edit().putBoolean(KEY_DISABLE_BT_WHEN_UNDOCKED, true).apply();     // Catch: Throwable -> L62
    L30:
        monitor-exit(this);
        return;
    L24:
        if (r2.equals(this.mDevice) == false) goto L27;
        monitor-exit(this);
        return;
    L32:
        r3 = r3 + 1;
        goto L13
    L34:
        this.mPendingDevice = null;     // Catch: Throwable -> L62
        CachedBluetoothDevice r12 = getCachedBluetoothDevice(r10);     // Catch: Throwable -> L62
        int r4 = 0;
        boolean r6 = false;
    L35:
        LocalBluetoothProfile[] r7 = this.mProfiles;     // Catch: Throwable -> L62
        if (r4 >= r7.length) goto L55;
        LocalBluetoothProfile r8 = r7[r4];     // Catch: Throwable -> L62
        boolean r9 = DEBUG;     // Catch: Throwable -> L62
        if (r9 == false) goto L40;
        OLog.d(TAG, r8.toString() + " = " + this.mCheckedItems[r4]);     // Catch: Throwable -> L62
    L40:
        boolean r13 = this.mCheckedItems[r4];     // Catch: Throwable -> L62
        if (r13 == false) goto L43;
        r6 = true;
    L49:
        r8.setPreferred(r10, this.mCheckedItems[r4]);     // Catch: Throwable -> L62
        if (r9 == false) goto L54;
        if (this.mCheckedItems[r4] == r8.isPreferred(r10)) goto L54;
        OLog.e(TAG, "Can't save preferred value");     // Catch: Throwable -> L62
    L54:
        r4 = r4 + 1;     // Catch: Throwable -> L62
        goto L35
    L43:
        if (r13 == true) goto L49;
        if (r8.getConnectionStatus(r12.getDevice()) != 2) goto L49;
        if (r9 == false) goto L48;
        OLog.d(TAG, "applyBtSettings - Disconnecting");     // Catch: Throwable -> L62
    L48:
        r12.disconnect(this.mProfiles[r4]);     // Catch: Throwable -> L62
        goto L49
    L55:
        if (r6 == true) goto L57;
    L60:
        monitor-exit(this);
        return;
    L57:
        if (DEBUG == false) goto L59;
        OLog.d(TAG, "applyBtSettings - Connecting");     // Catch: Throwable -> L62
    L59:
        r12.connect(false);     // Catch: Throwable -> L62
        goto L60
    }

    private synchronized void handleDocked(BluetoothDevice r2, int r3, int r4) {
        monitor-enter(this);
        if (r2 != null) goto L13;
    L7:
        createDialog(r2, r3, r4);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    L13:
        if (LocalBluetoothPreferences.getDockAutoConnectSetting(this, r2.getAddress()) == false) goto L7;
        initBtSettings(r2, r3, false);     // Catch: Throwable -> L10
        applyBtSettings(this.mDevice, r4);     // Catch: Throwable -> L10
        goto L8
    }

    private synchronized void handleUndocked(BluetoothDevice r3) {
        monitor-enter(this);
        this.mRunnable = null;     // Catch: Throwable -> L12
        this.mProfileManager.removeServiceListener(this);     // Catch: Throwable -> L12
        AlertDialog r1 = this.mDialog;     // Catch: Throwable -> L12
        if (r1 == null) goto L7;
        r1.dismiss();     // Catch: Throwable -> L12
        this.mDialog = null;     // Catch: Throwable -> L12
    L7:
        this.mDevice = null;     // Catch: Throwable -> L12
        this.mPendingDevice = null;     // Catch: Throwable -> L12
        if (r3 == null) goto L10;
        getCachedBluetoothDevice(r3).disconnect();     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private CachedBluetoothDevice getCachedBluetoothDevice(BluetoothDevice r3) {
        CachedBluetoothDevice r0 = this.mDeviceManager.findDevice(r3);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.mDeviceManager.addDevice(this.mLocalAdapter, this.mProfileManager, r3);
    }

    @Override // com.android.settings.bluetooth.LocalBluetoothProfileManager.ServiceListener
    public synchronized void onServiceConnected() {
        monitor-enter(this);
        Runnable r0 = this.mRunnable;     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        r0.run();     // Catch: Throwable -> L8
        this.mRunnable = null;     // Catch: Throwable -> L8
        this.mProfileManager.removeServiceListener(this);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
