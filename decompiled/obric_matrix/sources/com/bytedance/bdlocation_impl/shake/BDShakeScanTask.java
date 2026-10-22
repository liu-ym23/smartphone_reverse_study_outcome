package com.bytedance.bdlocation_impl.shake;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.scan.bluetooth.BluetoothInfoManager;
import com.bytedance.bdlocation.scan.bluetooth.BluetoothUtil;
import com.bytedance.bdlocation.scan.wifi.WifiUtil;
import com.bytedance.bdlocation.thread.ThreadLooperManager;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.google.gson.g;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class BDShakeScanTask {
    public static g mBleInfos;
    public static g mWifiInfos;
    private final String TAG;
    private BluetoothInfoManager blueToothCollectManager;
    private volatile boolean isBleScanRun;
    private volatile boolean isLocationRun;
    private boolean isStartScanTask;
    private volatile boolean isWifiScanRun;
    private String mBpeaAction;
    private Object mBpeaCert;
    private Context mContext;
    private String mUploadSource;
    private ScanReceiver receiver;
    private long startScanTime;
    private Handler workHandler;

    class BleScanTask implements Runnable {
        private Object mBpeaCert;
        final /* synthetic */ BDShakeScanTask this$0;

        public BleScanTask(BDShakeScanTask r1, Object r2) {
            this.this$0 = r1;
            this.mBpeaCert = r2;
            BDShakeScanTask.access$502(r1, true);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BDLocationConfig.isBackground() == false) goto L7;
            BDShakeScanTask.access$502(this.this$0, false);
            return;
        L7:
            if (BDShakeScanTask.access$500(this.this$0) == true) goto L10;
            return;
        L10:
            if (BDShakeScanTask.access$100(this.this$0) == false) goto L12;
            return;
        L12:
            Logger.i(BluetoothUtil.BLE_SCAN_TRACE, "BleScanTask run:" + BDShakeConfig.getBleScanTime() + "--" + BDShakeConfig.getClassicScanTime());
            BDShakeScanTask.access$600(this.this$0).startScan(new AnonymousClass1(this), BDShakeConfig.getClassicScanTime(), BDShakeConfig.getBleScanTime(), this.mBpeaCert);
        }
    }

    class LocationTask implements Runnable {
        private Object mBpeaCert;
        final /* synthetic */ BDShakeScanTask this$0;

        public LocationTask(BDShakeScanTask r1, Object r2) {
            this.this$0 = r1;
            this.mBpeaCert = r2;
            BDShakeScanTask.access$002(r1, true);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BDLocationConfig.isBackground() == false) goto L7;
            BDShakeScanTask.access$002(this.this$0, false);
            return;
        L7:
            if (BDShakeScanTask.access$000(this.this$0) == true) goto L10;
            return;
        L10:
            if (BDShakeScanTask.access$100(this.this$0) == false) goto L12;
            return;
        L12:
            Logger.d(BluetoothUtil.BLE_SCAN_TRACE, "LocationTask run--------------:" + BDShakeConfig.getLocationInterval());
            BDShakeScanTask r2 = this.this$0;
            d.b.c.e.a.c(BDShakeScanTask.access$300(r2, BDShakeScanTask.access$200(r2), 1, false, 0, 0, this.mBpeaCert), null);
            if (BDShakeScanTask.access$000(this.this$0) == false) goto L16;
            BDShakeScanTask.access$400(this.this$0).postDelayed(this, BDShakeConfig.getLocationInterval());
            return;
        }
    }

    class ScanReceiver extends BroadcastReceiver {
        final /* synthetic */ BDShakeScanTask this$0;

        ScanReceiver(BDShakeScanTask r1) {
            this.this$0 = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r2, Intent r3) {
            String r4 = r3.getAction();
            r4.hashCode();
            if (r4.equals("android.net.wifi.WIFI_STATE_CHANGED") == false) goto L5;
            BDShakeScanTask.access$1000(this.this$0, r3);
            return;
        L5:
            if (r4.equals("android.bluetooth.adapter.action.STATE_CHANGED") == false) goto L11;
            BDShakeScanTask.access$900(this.this$0, r3);
            return;
        }
    }

    class WifiScanTask implements Runnable {
        private Object mBpeaCert;
        final /* synthetic */ BDShakeScanTask this$0;

        public WifiScanTask(BDShakeScanTask r1, Object r2) {
            this.this$0 = r1;
            this.mBpeaCert = r2;
            BDShakeScanTask.access$702(r1, true);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BDLocationConfig.isBackground() == false) goto L7;
            BDShakeScanTask.access$702(this.this$0, false);
            return;
        L7:
            if (BDShakeScanTask.access$700(this.this$0) == true) goto L10;
            return;
        L10:
            if (BDShakeScanTask.access$100(this.this$0) == false) goto L17;
            return;
        L17:
            Logger.d("ShakeScanTask", "WifiScanTask run:");     // Catch: Exception -> L16
            BDShakeScanTask.mWifiInfos = WifiUtil.getWifiInfoJson(BDShakeScanTask.access$800(this.this$0), this.mBpeaCert);     // Catch: Exception -> L16
            if (BDShakeScanTask.access$700(this.this$0) == false) goto L19;
            BDShakeScanTask.access$400(this.this$0).postDelayed(this, BDShakeConfig.getWifiScanInterval());     // Catch: Exception -> L16
            return;
        L19:
            return;
        }
    }

    public BDShakeScanTask() {
        this.TAG = "ShakeScanTask";
        this.mUploadSource = "ShakeScanTask";
        this.isLocationRun = false;
        this.isBleScanRun = false;
        this.isWifiScanRun = false;
        this.isStartScanTask = false;
        this.mBpeaCert = null;
        this.mBpeaAction = "";
        Context r0 = BDLocationConfig.getContext();
        this.mContext = r0;
        this.blueToothCollectManager = new BluetoothInfoManager(r0);
        this.workHandler = new Handler(ThreadLooperManager.getShakeTaskWorker());
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent INVOKEVIRTUAL_com_bytedance_bdlocation_impl_shake_BDShakeScanTask_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    static /* synthetic */ boolean access$000(BDShakeScanTask r0) {
        return r0.isLocationRun;
    }

    static /* synthetic */ boolean access$002(BDShakeScanTask r0, boolean r1) {
        r0.isLocationRun = r1;
        return r1;
    }

    static /* synthetic */ boolean access$100(BDShakeScanTask r0) {
        return r0.isTimeout();
    }

    static /* synthetic */ void access$1000(BDShakeScanTask r0, Intent r1) {
        r0.setWifiState(r1);
    }

    static /* synthetic */ String access$200(BDShakeScanTask r0) {
        return r0.mUploadSource;
    }

    static /* synthetic */ LocationOption access$300(BDShakeScanTask r0, String r1, int r2, boolean r3, int r4, long r5, Object r7) {
        return r0.getShakeScanOption(r1, r2, r3, r4, r5, r7);
    }

    static /* synthetic */ Handler access$400(BDShakeScanTask r0) {
        return r0.workHandler;
    }

    static /* synthetic */ boolean access$500(BDShakeScanTask r0) {
        return r0.isBleScanRun;
    }

    static /* synthetic */ boolean access$502(BDShakeScanTask r0, boolean r1) {
        r0.isBleScanRun = r1;
        return r1;
    }

    static /* synthetic */ BluetoothInfoManager access$600(BDShakeScanTask r0) {
        return r0.blueToothCollectManager;
    }

    static /* synthetic */ boolean access$700(BDShakeScanTask r0) {
        return r0.isWifiScanRun;
    }

    static /* synthetic */ boolean access$702(BDShakeScanTask r0, boolean r1) {
        r0.isWifiScanRun = r1;
        return r1;
    }

    static /* synthetic */ Context access$800(BDShakeScanTask r0) {
        return r0.mContext;
    }

    static /* synthetic */ void access$900(BDShakeScanTask r0, Intent r1) {
        r0.setBluetoothState(r1);
    }

    private LocationOption getShakeScanOption(String r2, int r3, boolean r4, int r5, long r6, Object r8) {
        LocationOption r0 = new LocationOption();
        r0.setUploadSource(r2);
        r0.setMaxCacheTime(r6);
        r0.setTriggerType(r3);
        r0.setUpload(r4);
        r0.setLocationTimeOutMs(r5);
        r0.setLocateType(BDLocationConfig.getLocateType());
        r0.setBpeaCert(r8);
        r0.setBpeaAction(this.mBpeaAction);
        r0.setScanBle(false);
        return r0;
    }

    private boolean isTimeout() {
        if ((System.currentTimeMillis() - this.startScanTime) <= BDShakeConfig.getScanTimeoutMS()) goto L6;
        return true;
    L6:
        return false;
    }

    private void registerScanReceiver() {
        this.receiver = new ScanReceiver(this);
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        r0.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        INVOKEVIRTUAL_com_bytedance_bdlocation_impl_shake_BDShakeScanTask_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.receiver, r0);
    }

    private void setBluetoothState(Intent r3) {
        int r4 = r3.getIntExtra("android.bluetooth.adapter.extra.STATE", 0);
        switch(r4) {
            case 10: goto L11;
            case 11: goto L10;
            case 12: goto L7;
            case 13: goto L5;
            default: goto L15;
        };
    L5:
        StringBuilder r2 = new StringBuilder();
        String r1 = "setBluetoothState 13:";
    L12:
        r2.append(r1);
        r2.append(r4);
        String r5 = r2.toString();
    L13:
        Logger.d(BDShakeConfig.TAG, r5);
        return;
    L10:
        r2 = new StringBuilder();
        r1 = "setBluetoothState 11:";
        goto L12
    L11:
        stopBleScan();
        r2 = new StringBuilder();
        r1 = "setBluetoothState 10 stopBleScan:";
        goto L12
    L15:
        return;
    L7:
        if (this.isStartScanTask == false) goto L9;
        startBleScan();
    L9:
        r5 = "setBluetoothState 12 startBleScan isStartScanTask:" + this.isStartScanTask;
        goto L13
    }

    private void setWifiState(Intent r3) {
        int r4 = r3.getIntExtra("wifi_state", 0);
        if (r4 != 0) goto L5;
        StringBuilder r2 = new StringBuilder();
        String r1 = "setWifiState 0:";
    L21:
        r2.append(r1);
        r2.append(r4);
        Logger.d(BDShakeConfig.TAG, r2.toString());
        return;
    L5:
        if (r4 != 1) goto L7;
        stopWifiScan();
        r2 = new StringBuilder();
        r1 = "setWifiState 1:";
        goto L21
    L7:
        if (r4 != 2) goto L9;
        r2 = new StringBuilder();
        r1 = "setWifiState 2:";
        goto L21
    L9:
        if (r4 == 3) goto L15;
        if (r4 != 4) goto L23;
        r2 = new StringBuilder();
        r1 = "setWifiState 4:";
        goto L21
    L23:
        return;
    L15:
        if (this.isWifiScanRun == true) goto L17;
        startWifiScan();
    L17:
        r2 = new StringBuilder();
        r1 = "setWifiState 3:";
        goto L21
    }

    private boolean startBleScan() {
        Logger.d(BDShakeConfig.TAG, "startBleScan:" + BDShakeConfig.isShakeUploadBle());
        if (Build.VERSION.SDK_INT < 31) goto L8;
        if (PermissionManager.hasBluetoothPermissions(this.mContext) == true) goto L8;
        return false;
    L8:
        if (BDShakeConfig.isShakeUploadBle() == true) goto L10;
    L15:
        return false;
    L10:
        if (this.isBleScanRun == true) goto L15;
        if (isBlueToothEnabled() == false) goto L15;
        BDLocationConfig.setEnableScanBle(false);
        this.workHandler.post(new BleScanTask(this, this.mBpeaCert));
        return true;
    }

    private boolean startGetLocation() {
        Logger.d(BDShakeConfig.TAG, "startGetLocation:" + BDShakeConfig.isStartLocationTask());
        if (BDShakeConfig.isStartLocationTask() == true) goto L5;
        return false;
    L5:
        if (this.isLocationRun == true) goto L10;
        this.workHandler.post(new LocationTask(this, this.mBpeaCert));
        return true;
    L10:
        return false;
    }

    private boolean startWifiScan() {
        Logger.d(BDShakeConfig.TAG, "startWifiScan:" + BDShakeConfig.isShakeUploadWifi());
        if (BDShakeConfig.isShakeUploadWifi() == true) goto L5;
        return false;
    L5:
        if (this.isWifiScanRun == false) goto L7;
        return false;
    L7:
        if (isWifiEnabled() == false) goto L13;
        this.workHandler.post(new WifiScanTask(this, this.mBpeaCert));
        return true;
    L13:
        return false;
    }

    private void stopBleScan() {
    L8:
        e = move-exception;
        Logger.d("ShakeScanTask", "stopBleScan error" + e.getMessage());
        return;
    L3:
        if (this.isBleScanRun == false) goto L13;
        BDLocationConfig.setEnableScanBle(true);     // Catch: Exception -> L8
        this.blueToothCollectManager.stopScan();     // Catch: Exception -> L8
        this.isBleScanRun = false;     // Catch: Exception -> L8
        if (mBleInfos == null) goto L14;
        mBleInfos = null;     // Catch: Exception -> L8
        return;
    L14:
        return;
    }

    private void stopLocationScan() {
        if (this.isLocationRun == false) goto L6;
        this.isLocationRun = false;
        return;
    }

    private void stopWifiScan() {
        if (this.isWifiScanRun == false) goto L8;
        this.isWifiScanRun = false;
        if (mWifiInfos == null) goto L9;
        mWifiInfos = null;
        return;
    L9:
        return;
    }

    private void unRegisterScanReceiver() {
        ScanReceiver r0 = this.receiver;
        if (r0 == null) goto L6;
        this.mContext.unregisterReceiver(r0);
        this.receiver = null;
        return;
    }

    public boolean isBlueToothEnabled() {
        return this.blueToothCollectManager.blueToothIsEnabled();
    }

    public boolean isScanning() {
        if (this.isBleScanRun == false) goto L5;
    L10:
        return true;
    L5:
        if (this.isWifiScanRun == true) goto L10;
        if (this.isLocationRun == true) goto L10;
        return false;
    }

    public boolean isWifiEnabled() {
        WifiManager r1 = (WifiManager) this.mContext.getApplicationContext().getSystemService("wifi");
        if (r1 != null) goto L5;
        return false;
    L5:
        if (r1.isWifiEnabled() == false) goto L10;
        return true;
    L10:
        return false;
    }

    public void setUploadSource(String r1) {
        this.mUploadSource = r1;
    }

    public boolean startScan(Object r4, String r5) {
        this.mBpeaCert = r4;
        this.mBpeaAction = r5;
        boolean r6 = false;
        if (BDLocationConfig.isBackground() == false) goto L6;
        return false;
    L6:
        if (this.isBleScanRun == true) goto L8;
    L13:
        this.startScanTime = System.currentTimeMillis();
        boolean r7 = startBleScan();
        boolean r0 = startWifiScan();
        boolean r1 = startGetLocation();
        if (r7 == true) goto L17;
        if (r0 == true) goto L17;
        if (r1 == true) goto L17;
    L18:
        if (r6 == false) goto L20;
        this.isStartScanTask = true;
        registerScanReceiver();
    L20:
        return r6;
    L17:
        r6 = true;
        goto L18
    L8:
        if (this.isWifiScanRun == false) goto L13;
        if (this.isLocationRun == false) goto L13;
        Logger.d(BDShakeConfig.TAG, "ScanTask is running!");
        return false;
    }

    public void stopScan() {
        Logger.d("ShakeScanTask", "stopScan:");     // Catch: Exception -> L5
        stopBleScan();     // Catch: Exception -> L5
        stopWifiScan();     // Catch: Exception -> L5
        stopLocationScan();     // Catch: Exception -> L5
        unRegisterScanReceiver();     // Catch: Exception -> L5
        this.workHandler.removeCallbacksAndMessages(null);     // Catch: Exception -> L5
        this.isStartScanTask = false;     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Logger.d("ShakeScanTask", "stopScan error" + e.getMessage());
    }
}
