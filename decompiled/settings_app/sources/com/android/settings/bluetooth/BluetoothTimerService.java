package com.android.settings.bluetooth;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.SystemClock;
import com.GlobalProxyLancet;
import com.android.settings.AdaptBluetoothDevice;
import com.android.settingslib.utils.StringUtil;
import com.android.vcard.VCardConfig;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.obric.olog.OLog;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class BluetoothTimerService extends Service {
    private static final int BLUETOOTH_TIMER_SERVICE_ID = 2;
    static final boolean D = true;
    private static final int MSG_CLOSE_SERVICE = 4;
    private static final int MSG_DISCONNECT = 1;
    private static final int MSG_DISCONNECT_A2DP = 2;
    private static final int MSG_RECONNECT_A2DP = 3;
    private static final String TAG = "BluetoothTimerService";
    private BluetoothA2dp mA2dpService;
    private BluetoothAdapter mAdapter;
    private AlarmManager mAlarmManager;
    private BluetoothDevice mBluetoothDevice;
    private Context mContext;
    private CountDownTimer mCountDownTimer;
    private CachedBluetoothDevice mDevice;
    private CachedBluetoothDeviceManager mDeviceManager;
    private Notification mForegroundNotification;
    private Handler mHandler;
    private BluetoothHeadset mHeadsetService;
    private IntentFilter mIntentFilter;
    private boolean mNeedReconnect;
    private Notification.Builder mNotificationBuilder;
    private NotificationManager mNotificationMgr;
    private LocalBluetoothProfileManager mProfileManager;
    private final BroadcastReceiver mReceiver;
    private int mRetryCounter;
    private final BroadcastReceiver notExportedReceiver;
    private PowerManager.WakeLock sServiceWakeLock;

    private final class A2dpServiceListener implements BluetoothProfile.ServiceListener {
        final /* synthetic */ BluetoothTimerService this$0;

        private A2dpServiceListener(BluetoothTimerService r1) {
            this.this$0 = r1;
        }

        /* synthetic */ A2dpServiceListener(BluetoothTimerService r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int r2, BluetoothProfile r3) {
            OLog.d(BluetoothTimerService.TAG, "Bluetooth A2dp service connected");
            BluetoothTimerService.access$1202(this.this$0, (BluetoothA2dp) r3);
            if (BluetoothTimerService.access$1200(this.this$0) != null) goto L6;
            OLog.d(BluetoothTimerService.TAG, "Bluetooth A2dp service null");
            return;
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int r1) {
            OLog.d(BluetoothTimerService.TAG, "Bluetooth A2dp service disconnected");
        }
    }

    private final class HeadsetServiceListener implements BluetoothProfile.ServiceListener {
        final /* synthetic */ BluetoothTimerService this$0;

        private HeadsetServiceListener(BluetoothTimerService r1) {
            this.this$0 = r1;
        }

        /* synthetic */ HeadsetServiceListener(BluetoothTimerService r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int r2, BluetoothProfile r3) {
            OLog.d(BluetoothTimerService.TAG, "Bluetooth Headset service connected");
            BluetoothTimerService.access$1102(this.this$0, (BluetoothHeadset) r3);
            if (BluetoothTimerService.access$1100(this.this$0) != null) goto L6;
            OLog.d(BluetoothTimerService.TAG, "Bluetooth Headset service null");
            return;
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int r1) {
            OLog.d(BluetoothTimerService.TAG, "Bluetooth Headset service disconnected");
        }
    }

    public class LocalBinder extends Binder {
        final /* synthetic */ BluetoothTimerService this$0;

        public LocalBinder(BluetoothTimerService r1) {
            this.this$0 = r1;
        }

        BluetoothTimerService getService() {
            return this.this$0;
        }
    }

    public BluetoothTimerService() {
        this.mRetryCounter = 0;
        this.mNeedReconnect = false;
        this.mReceiver = new AnonymousClass1(this);
        this.notExportedReceiver = new AnonymousClass2(this);
        this.mHandler = new AnonymousClass3(this);
    }

    static /* synthetic */ void access$000(BluetoothTimerService r0) {
        r0.reset();
    }

    static /* synthetic */ CachedBluetoothDevice access$100(BluetoothTimerService r0) {
        return r0.mDevice;
    }

    static /* synthetic */ void access$1000(BluetoothTimerService r0, long r1) {
        r0.startTimer(r1);
    }

    static /* synthetic */ CachedBluetoothDevice access$102(BluetoothTimerService r0, CachedBluetoothDevice r1) {
        r0.mDevice = r1;
        return r1;
    }

    static /* synthetic */ BluetoothHeadset access$1100(BluetoothTimerService r0) {
        return r0.mHeadsetService;
    }

    static /* synthetic */ BluetoothHeadset access$1102(BluetoothTimerService r0, BluetoothHeadset r1) {
        r0.mHeadsetService = r1;
        return r1;
    }

    static /* synthetic */ BluetoothA2dp access$1200(BluetoothTimerService r0) {
        return r0.mA2dpService;
    }

    static /* synthetic */ BluetoothA2dp access$1202(BluetoothTimerService r0, BluetoothA2dp r1) {
        r0.mA2dpService = r1;
        return r1;
    }

    static /* synthetic */ int access$1300(BluetoothTimerService r0) {
        return r0.mRetryCounter;
    }

    static /* synthetic */ int access$1302(BluetoothTimerService r0, int r1) {
        r0.mRetryCounter = r1;
        return r1;
    }

    static /* synthetic */ int access$1308(BluetoothTimerService r2) {
        int r0 = r2.mRetryCounter;
        r2.mRetryCounter = r0 + 1;
        return r0;
    }

    static /* synthetic */ LocalBluetoothProfileManager access$1400(BluetoothTimerService r0) {
        return r0.mProfileManager;
    }

    static /* synthetic */ String access$1500(BluetoothTimerService r0, int r1) {
        return r0.getStringTime(r1);
    }

    static /* synthetic */ void access$1600(BluetoothTimerService r0, String r1) {
        r0.updateNotification(r1);
    }

    static /* synthetic */ boolean access$200(BluetoothTimerService r0) {
        return r0.mNeedReconnect;
    }

    static /* synthetic */ boolean access$202(BluetoothTimerService r0, boolean r1) {
        r0.mNeedReconnect = r1;
        return r1;
    }

    static /* synthetic */ BluetoothDevice access$300(BluetoothTimerService r0) {
        return r0.mBluetoothDevice;
    }

    static /* synthetic */ BluetoothDevice access$302(BluetoothTimerService r0, BluetoothDevice r1) {
        r0.mBluetoothDevice = r1;
        return r1;
    }

    static /* synthetic */ Handler access$400(BluetoothTimerService r0) {
        return r0.mHandler;
    }

    static /* synthetic */ CachedBluetoothDeviceManager access$500(BluetoothTimerService r0) {
        return r0.mDeviceManager;
    }

    static /* synthetic */ NotificationManager access$600(BluetoothTimerService r0) {
        return r0.mNotificationMgr;
    }

    static /* synthetic */ NotificationManager access$602(BluetoothTimerService r0, NotificationManager r1) {
        r0.mNotificationMgr = r1;
        return r1;
    }

    static /* synthetic */ Context access$700(BluetoothTimerService r0) {
        return r0.mContext;
    }

    static /* synthetic */ Notification.Builder access$800(BluetoothTimerService r0) {
        return r0.mNotificationBuilder;
    }

    static /* synthetic */ Notification.Builder access$802(BluetoothTimerService r0, Notification.Builder r1) {
        r0.mNotificationBuilder = r1;
        return r1;
    }

    static /* synthetic */ Notification access$900(BluetoothTimerService r0) {
        return r0.mForegroundNotification;
    }

    static /* synthetic */ Notification access$902(BluetoothTimerService r0, Notification r1) {
        r0.mForegroundNotification = r1;
        return r1;
    }

    private void startTimer(long r4) {
        reset();
        PendingIntent r0 = getTimerPending();
        this.mAlarmManager.setExact(2, r4, r0);
        updateNotificationTime(r4);
    }

    private void updateNotificationTime(long r9) {
        final long r4 = r9 - SystemClock.elapsedRealtime();
        OLog.d(TAG, "updateNotificationTime delayTime:" + r4);
        final long r6 = 1000;
        CountDownTimer r10 = new AnonymousClass4(this, r4, r6);
        this.mCountDownTimer = r10;
        r10.start();
    }

    private void updateNotification(String r2) {
        this.mNotificationBuilder.setContentText(r2);
        this.mNotificationMgr.notify(2, this.mNotificationBuilder.build());
    }

    private String getStringTime(int r5) {
        int r4 = r5 / StringUtil.SECONDS_PER_HOUR;
        int r0 = (r5 % StringUtil.SECONDS_PER_HOUR) / 60;
        return String.format(Locale.CHINA, "%02d:%02d:%02d", new Object[]{Integer.valueOf(r4), Integer.valueOf(r0), Integer.valueOf(r5 % 60)});
    }

    private void reset() {
        PendingIntent r0 = getTimerPending();
        this.mAlarmManager.cancel(r0);
        CountDownTimer r2 = this.mCountDownTimer;
        if (r2 == null) goto L6;
        r2.cancel();
        return;
    }

    private PendingIntent getTimerPending() {
        Intent r0 = new Intent();
        r0.setClass(this.mContext, BluetoothTimerService.class);
        r0.setAction(Utils.ACTION_DISCONNECT_DEVICE);
        r0.putExtra("device", this.mBluetoothDevice);
        return PendingIntent.getService(this.mContext, 0, r0, VCardConfig.FLAG_APPEND_TYPE_PARAM);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r3, int r4, int r5) {
        OLog.d(TAG, "onStartCommand");
        if (r3 != null) goto L5;
        return 0;
    L5:
        String r0 = r3.getAction();
        if (r0 != null) goto L8;
    L21:
        return 0;
    L8:
        if (Utils.ACTION_DISCONNECT_DEVICE.equals(r0) == false) goto L21;
        this.mNeedReconnect = r3.getBooleanExtra(Utils.NEED_RECONNECT, false);
        OLog.d(TAG, "time up !");
        CachedBluetoothDevice r1 = this.mDevice;
        if (r1 != null) goto L17;
        this.mBluetoothDevice = (BluetoothDevice) r3.getParcelableExtra("device");
        OLog.d(TAG, "get device = " + AdaptBluetoothDevice.getDeviceAliasName(this.mBluetoothDevice));
        if (this.mNeedReconnect == false) goto L15;
        this.mHandler.sendEmptyMessage(2);
        return 0;
    L15:
        Handler r6 = this.mHandler;
        r6.sendMessageDelayed(r6.obtainMessage(1), 100);
    L20:
        this.mDevice = null;
        reset();
        goto L21
    L17:
        if (this.mNeedReconnect == false) goto L19;
        this.mDevice.disconnect(this.mProfileManager.getA2dpProfile());
        goto L20
    L19:
        r1.disconnect();
        goto L20
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        OLog.d(TAG, "BluetoothTimerService Create");
        this.mContext = this;
        this.mAlarmManager = (AlarmManager) getSystemService("alarm");
        LocalBluetoothManager r0 = LocalBluetoothManager.getInstance(this);
        this.mDeviceManager = r0.getCachedDeviceManager();
        this.mProfileManager = r0.getProfileManager();
        if (this.sServiceWakeLock != null) goto L5;
        this.sServiceWakeLock = ((PowerManager) getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK)).newWakeLock(1, "sBluetoothTimerServiceWakeLock");
    L5:
        BluetoothAdapter r1 = BluetoothAdapter.getDefaultAdapter();
        this.mAdapter = r1;
        AnonymousClass1 r4 = null;
        r1.getProfileProxy(this.mContext, new A2dpServiceListener(this, r4), 2);
        this.mAdapter.getProfileProxy(this.mContext, new HeadsetServiceListener(this, r4), 1);
        IntentFilter r2 = new IntentFilter();
        this.mIntentFilter = r2;
        r2.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        this.mIntentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mReceiver, this.mIntentFilter, 2);
        IntentFilter r3 = new IntentFilter();
        r3.addAction(Utils.ACTION_SET_TIMER);
        r3.addAction(Utils.ACTION_RESET_TIMER);
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.notExportedReceiver, r3, 4);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        OLog.d(TAG, "BluetoothTimerService destroy");
        this.mContext.unregisterReceiver(this.mReceiver);
        this.mContext.unregisterReceiver(this.notExportedReceiver);
        reset();
        if (this.sServiceWakeLock == null) goto L6;
        this.sServiceWakeLock = null;
        return;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r1) {
        return new LocalBinder(this);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent r1) {
        return super.onUnbind(r1);
    }
}
