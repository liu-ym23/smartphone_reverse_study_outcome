package com.android.settings.wifi;

import android.app.Notification;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.provider.Settings;
import com.GlobalProxyLancet;
import com.android.settings.AdaptWifi;
import com.android.settings.MultiSDKAdapter;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes.dex */
public final class WifiApService extends Service {
    private static final int CHECK_STATUS_INTERVAL_MSECONDS = 30000;
    private static final boolean DEBUG = true;
    private static final int MSG_AP_DISABLED = 101;
    private static final int MSG_CHECK_CONNETIVITY_STATUS = 102;
    private static final int MSG_CLOSE_SOFTAP = 100;
    private static final int POST_DELAY_MSECONDS = 600000;
    private static final String TAG = "WifiApService";
    public static final String TETHER_CONNECT_STATE_CHANGED = "codeaurora.net.conn.TETHER_CONNECT_STATE_CHANGED";
    private static final int WIFIAP_SERVICE_ID = 1;
    private boolean mConnectStateChanged;
    private int mConnectedDeviceSize;
    private Notification mForegroundNotification;
    private IntentFilter mIntentFilter;
    private final BroadcastReceiver mReceiver;
    private volatile ServiceHandler mServiceHandler;
    private volatile Looper mServiceLooper;
    private WifiManager mWifiManager;
    private PowerManager.WakeLock sServiceWakeLock;

    private final class ServiceHandler extends Handler {
        final /* synthetic */ WifiApService this$0;

        /* synthetic */ ServiceHandler(WifiApService r1, Looper r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private ServiceHandler(WifiApService r1, Looper r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r1) {
            WifiApService.access$500(this.this$0, r1);
        }

        void stop() {
            removeMessages(102);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r1) {
        return null;
    }

    public void onServiceDisconnected() {
    }

    public WifiApService() {
        this.mConnectStateChanged = false;
        this.mReceiver = new AnonymousClass1(this);
    }

    static /* synthetic */ void access$000(WifiApService r0, int r1) {
        r0.handleWifiApStateChanged(r1);
    }

    static /* synthetic */ boolean access$102(WifiApService r0, boolean r1) {
        r0.mConnectStateChanged = r1;
        return r1;
    }

    static /* synthetic */ int access$200(WifiApService r0) {
        return r0.mConnectedDeviceSize;
    }

    static /* synthetic */ int access$202(WifiApService r0, int r1) {
        r0.mConnectedDeviceSize = r1;
        return r1;
    }

    static /* synthetic */ ServiceHandler access$300(WifiApService r0) {
        return r0.mServiceHandler;
    }

    static /* synthetic */ void access$500(WifiApService r0, Message r1) {
        r0.processMessage(r1);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        OLog.d(TAG, "onCreate");
        WifiManager r0 = (WifiManager) getSystemService("wifi");
        this.mWifiManager = r0;
        if (r0 != null) goto L7;
        OLog.e(TAG, "Can't get WifiManager: exiting");
        return;
    L7:
        if (this.sServiceWakeLock != null) goto L9;
        this.sServiceWakeLock = ((PowerManager) getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK)).newWakeLock(1, "sWifiApServiceWakeLock");
    L9:
        this.sServiceWakeLock.acquire();
        IntentFilter r1 = new IntentFilter("android.net.wifi.WIFI_AP_STATE_CHANGED");
        this.mIntentFilter = r1;
        r1.addAction(TETHER_CONNECT_STATE_CHANGED);
        this.mIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, this.mReceiver, this.mIntentFilter, 2);
        HandlerThread r2 = new HandlerThread(TAG);
        r2.start();
        this.mServiceLooper = r2.getLooper();
        if (this.mServiceLooper == null) goto L12;
        this.mServiceHandler = new ServiceHandler(this, this.mServiceLooper, null);
    L12:
        MultiSDKAdapter.getNotificationManager(this, 2);
        this.mForegroundNotification = MultiSDKAdapter.getNotificationBuilder(this, 2).setContentText(TAG).build();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        OLog.d(TAG, "onDestroy");
        unregisterReceiver(this.mReceiver);
        if (this.mServiceLooper == null) goto L5;
        this.mServiceLooper.quit();
    L5:
        PowerManager.WakeLock r0 = this.sServiceWakeLock;
        if (r0 == null) goto L8;
        r0.release();
        this.sServiceWakeLock = null;
    L8:
        this.mServiceLooper = null;
        System.exit(0);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r3, int r4, int r5) {
        OLog.d(TAG, "onStartCommand startId: " + r5 + " flags: " + r4);
        if ("android.net.wifi.WIFI_AP_STATE_CHANGED".equals(r3.getAction()) == false) goto L7;
        handleWifiApStateChanged(r3.getIntExtra("wifi_state", 14));
        startForeground(1, this.mForegroundNotification);
        return 2;
    L7:
        return 2;
    }

    private void checkConnectivityStatus() {
        boolean r0 = Utils.hasAssignedIp();
        OLog.d(TAG, "checkConnectivityStatus hsCilent: " + r0);
        if (r0 == true) goto L5;
    L10:
        this.mServiceHandler.sendEmptyMessage(100);
        return;
    L5:
        if (this.mConnectStateChanged == true) goto L7;
    L9:
        this.mServiceHandler.sendEmptyMessageDelayed(102, 30000);
        return;
    L7:
        if (this.mConnectedDeviceSize != 0) goto L9;
        goto L9
    }

    private void handleWifiApStateChanged(int r3) {
        if (r3 != 11) goto L5;
        this.mServiceHandler.sendEmptyMessage(101);
        return;
    L5:
        if (r3 != 13) goto L11;
        this.mServiceHandler.sendEmptyMessageDelayed(102, 600000);
        return;
    }

    private synchronized void processMessage(Message r4) {
        monitor-enter(this);
        OLog.d(TAG, "processMessage msg.what: " + r4.what);     // Catch: Throwable -> L12
        switch(r4.what) {
            case 100: goto L9;
            case 101: goto L8;
            case 102: goto L7;
            default: goto L10;
        };     // Catch: Throwable -> L12
    L7:
        checkConnectivityStatus();     // Catch: Throwable -> L12
        goto L10
    L8:
        OLog.d(TAG, "softAp disabled then stop this service.");     // Catch: Throwable -> L12
        this.mServiceHandler.stop();     // Catch: Throwable -> L12
        stopSelf();     // Catch: Throwable -> L12
        goto L10
    L9:
        disabledSoftap();     // Catch: Throwable -> L12
        this.mServiceHandler.stop();     // Catch: Throwable -> L12
        stopSelf();     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private void disabledSoftap() {
        ContentResolver r1 = getContentResolver();
        int r3 = Settings.Global.getInt(r1, AdaptWifi.WIFI_SAVED_STATE);     // Catch: Settings.SettingNotFoundException -> L5
    L8:
        if (this.mWifiManager.getWifiApState() == 13) goto L11;
        return;
    L11:
        if (MultiSDKAdapter.setWifiApEnabled(this.mWifiManager, null, false) == true) goto L13;
        return;
    L13:
        if (r3 != 1) goto L19;
        this.mWifiManager.setWifiEnabled(true);
        Settings.Global.putInt(r1, AdaptWifi.WIFI_SAVED_STATE, 0);
        return;
    L19:
        return;
    L5:
        e = move-exception;
        OLog.e(TAG, "Exception: " + e);
        r3 = 0;
        goto L8
    }
}
