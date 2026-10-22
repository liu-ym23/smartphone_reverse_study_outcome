package com.bytedance.bdlocation.scan.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.thread.ThreadLooperManager;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class BluetoothInfoManager {
    private static BluetoothScanCallback mBluetoothCallback;
    private final String TAG;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothLeScanner mBluetoothLeScanner;
    private List<BDBleInfo> mBluetoothList;
    private BroadcastReceiver mBluetoothReceiver;
    private Object mBpeaCert;
    private Context mContext;
    private Handler mHandler;
    private boolean mIsRegisterReceiver;
    private BluetoothAdapter.LeScanCallback mLeScanCallback;
    private ScanCallback mScanCallback;
    private int mScanMode;

    /* JADX INFO: renamed from: com.bytedance.bdlocation.scan.bluetooth.BluetoothInfoManager$1, reason: invalid class name */
    class AnonymousClass1 extends ScanCallback {
        final /* synthetic */ BluetoothInfoManager this$0;

        AnonymousClass1(BluetoothInfoManager r1) {
            this.this$0 = r1;
        }

        private /* synthetic */ void a(ScanResult r6) {
            BluetoothDevice r1 = r6.getDevice();     // Catch: Exception -> L10
            String r2 = BDLocationExtrasService.getBPEAManager().getAddress(r1, BluetoothInfoManager.access$100(this.this$0));     // Catch: Exception -> L10
            Logger.d("BDShakeCollectManager", "startLeScan onScanResult:" + r2);     // Catch: Exception -> L10
            BDBleInfo r3 = new BDBleInfo();     // Catch: Exception -> L10
            r3.rssi = r6.getRssi();     // Catch: Exception -> L10
            String r4 = r1.getName();     // Catch: Exception -> L10
            if (r4 == null) goto L6;
            r3.bleName = r4;     // Catch: Exception -> L10
        L6:
            r3.bleMac = r2;     // Catch: Exception -> L10
            r3.timeStamp = System.currentTimeMillis();     // Catch: Exception -> L10
            BluetoothInfoManager.optimizeBeaconData(r3, r6);     // Catch: Exception -> L10
            BluetoothInfoManager.access$200(this.this$0, r3);     // Catch: Exception -> L10
            if (BluetoothInfoManager.access$300() == null) goto L15;
            BluetoothInfoManager.access$300().onScan(r3);     // Catch: Exception -> L10
            return;
        L15:
            return;
        L10:
            e = move-exception;
            Logger.d("BDShakeCollectManager", "startLeScan onScanResult error:" + e.getMessage());
        }

        public /* synthetic */ void b(ScanResult r1) {
            a(r1);
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onBatchScanResults(List<ScanResult> r1) {
            super.onBatchScanResults(r1);
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int r2) {
            super.onScanFailed(r2);
            Logger.d("BDShakeCollectManager", "startLeScan onScanFailed errorCode:" + r2);
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int r2, final ScanResult r3) {
            super.onScanResult(r2, r3);
            BluetoothInfoManager.access$000(this.this$0).post(new a(this, r3));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.bdlocation.scan.bluetooth.BluetoothInfoManager$2, reason: invalid class name */
    class AnonymousClass2 implements BluetoothAdapter.LeScanCallback {
        final /* synthetic */ BluetoothInfoManager this$0;

        AnonymousClass2(BluetoothInfoManager r1) {
            this.this$0 = r1;
        }

        private /* synthetic */ void a(BluetoothDevice r1, int r2) {
            BluetoothInfoManager.access$400(this.this$0, r1, r2);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            Logger.d("BDShakeCollectManager", "startLeScan onLeScan error:" + e.getMessage());
        }

        public /* synthetic */ void b(BluetoothDevice r1, int r2) {
            a(r1, r2);
        }

        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(final BluetoothDevice r2, final int r3, byte[] r4) {
            BluetoothInfoManager.access$000(this.this$0).post(new b(this, r2, r3));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.bdlocation.scan.bluetooth.BluetoothInfoManager$3, reason: invalid class name */
    class AnonymousClass3 extends BroadcastReceiver {
        final /* synthetic */ BluetoothInfoManager this$0;

        AnonymousClass3(BluetoothInfoManager r1) {
            this.this$0 = r1;
        }

        private /* synthetic */ void a(Intent r4) {
            BluetoothDevice r0 = (BluetoothDevice) r4.getParcelableExtra("android.bluetooth.device.extra.DEVICE");     // Catch: Exception -> L4
            short r5 = r4.getShortExtra("android.bluetooth.device.extra.RSSI", Short.MIN_VALUE);     // Catch: Exception -> L4
            BluetoothInfoManager.access$400(this.this$0, r0, r5);     // Catch: Exception -> L4
            return;
        }

        public /* synthetic */ void b(Intent r1) {
            a(r1);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r2, final Intent r3) {
            String r4 = r3.getAction();
            if ("android.bluetooth.device.action.FOUND".equals(r4) == false) goto L6;
            Logger.d("BluetoothAdapter BluetoothAdapter.ACTION_FOUND");
            BluetoothInfoManager.access$000(this.this$0).post(new c(this, r3));
            return;
        L6:
            if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(r4) == false) goto L10;
            Logger.d("BluetoothAdapter BluetoothAdapter.ACTION_DISCOVERY_FINISHED");
            return;
        }
    }

    public interface BluetoothScanCallback {
        void onError();

        void onScan(BDBleInfo r1);

        void onSuccess(List<BDBleInfo> r1);
    }

    public BluetoothInfoManager(Context r2) {
        this.TAG = "BDShakeCollectManager";
        this.mScanMode = 2;
        this.mIsRegisterReceiver = false;
        this.mBpeaCert = null;
        this.mBluetoothReceiver = new AnonymousClass3(this);
        this.mContext = r2;
        this.mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        this.mBluetoothList = new ArrayList();
        this.mHandler = new Handler(ThreadLooperManager.getBleScanWorker());
        initScanCallback();
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent INVOKEVIRTUAL_com_bytedance_bdlocation_scan_bluetooth_BluetoothInfoManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    private /* synthetic */ void a(long r3, Object r5) {
        stopBleScan();
        if (r3 <= 0) goto L6;
        registerScanReceiver(this.mContext);
        this.mIsRegisterReceiver = true;
        startBlueScan(r5);
        return;
    }

    static /* synthetic */ Handler access$000(BluetoothInfoManager r0) {
        return r0.mHandler;
    }

    static /* synthetic */ Object access$100(BluetoothInfoManager r0) {
        return r0.mBpeaCert;
    }

    static /* synthetic */ void access$200(BluetoothInfoManager r0, BDBleInfo r1) {
        r0.addList(r1);
    }

    static /* synthetic */ BluetoothScanCallback access$300() {
        return mBluetoothCallback;
    }

    static /* synthetic */ void access$400(BluetoothInfoManager r0, BluetoothDevice r1, int r2) {
        r0.setDeviceData(r1, r2);
    }

    private void addList(BDBleInfo r2) {
        List<BDBleInfo> r0 = this.mBluetoothList;     // Catch: Exception -> L11
        if (r0 == null) goto L10;
        if (r2 != null) goto L7;
        return;
    L7:
        if (r0.contains(r2) == true) goto L17;
        this.mBluetoothList.add(r2);     // Catch: Exception -> L11
        return;
    L17:
        return;
    L10:
        return;
    L11:
        e = move-exception;
        Logger.d("addList error" + e.getMessage());
    }

    private /* synthetic */ void c() {
        stopBlueScan();
        BluetoothScanCallback r0 = mBluetoothCallback;
        if (r0 == null) goto L6;
        r0.onSuccess(this.mBluetoothList);
        return;
    }

    private /* synthetic */ void e(final Object r3, BluetoothScanCallback r4, long r5, final long r7) {
        this.mBpeaCert = r3;     // Catch: Exception -> L20
        if (BDLocationConfig.isBackground() == false) goto L7;
        r4.onError();     // Catch: Exception -> L20
        return;
    L7:
        if (this.mBluetoothAdapter.isEnabled() == true) goto L10;
        Logger.d("未开启蓝牙");     // Catch: Exception -> L20
        r4.onError();     // Catch: Exception -> L20
        return;
    L10:
        mBluetoothCallback = r4;     // Catch: Exception -> L20
        List<BDBleInfo> r0 = this.mBluetoothList;     // Catch: Exception -> L20
        if (r0 == null) goto L16;
        if (r0.size() <= 0) goto L16;
        this.mBluetoothList.clear();     // Catch: Exception -> L20
    L16:
        if (r5 <= 0) goto L18;
        startBleScan(r3);     // Catch: Exception -> L20
    L18:
        this.mHandler.postDelayed(new f(this, r7, r3), r5);     // Catch: Exception -> L20
        this.mHandler.postDelayed(new e(this), r7 + r5);     // Catch: Exception -> L20
        return;
    L20:
        e = move-exception;
        Logger.d("startScan error" + e.getMessage());
        stopScan();
        r4.onError();
    }

    private void initScanCallback() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 21) goto L6;
        this.mScanCallback = new AnonymousClass1(this);
    L6:
        if (r0 < 18) goto L9;
        this.mLeScanCallback = new AnonymousClass2(this);
        return;
    }

    @RequiresApi(api = 21)
    public static void optimizeBeaconData(BDBleInfo r6, ScanResult r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        if (r7.getScanRecord() == null) goto L21;
        r6.rawData = BluetoothUtil.Bytes2HexString(r7.getScanRecord().getBytes());
        Logger.i("optimizeBeaconData00" + r6.rawData);
        byte[] r8 = r7.getScanRecord().getManufacturerSpecificData(76);
        if (r8 != null) goto L9;
        return;
    L9:
        if (r8.length >= 23) goto L11;
        return;
    L11:
        if (r8[0] != 2) goto L19;
        String r2 = BluetoothUtil.Bytes2HexString(Arrays.copyOfRange(r8, 2, 18));
        if (TextUtils.isEmpty(r2) == true) goto L20;
        String r0 = (((((((r2.substring(0, 8) + "-") + r2.substring(8, 12)) + "-") + r2.substring(12, 16)) + "-") + r2.substring(16, 20)) + "-") + r2.substring(20, 32);
        int r1 = BluetoothUtil.byteToInt(r8[18], r8[19]);
        int r9 = BluetoothUtil.byteToInt(r8[20], r8[21]);
        r6.isBeacon = true;
        r6.major = r1;
        r6.minor = r9;
        r6.beaconUuid = r0;
        Logger.i("optimizeBeaconData11 uuid:" + r0 + "---major:" + r1 + "---minor:" + r9);
        return;
    L20:
        return;
    L19:
        return;
    }

    private void registerScanReceiver(Context r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (this.mBluetoothReceiver != null) goto L6;
        return;
    L6:
        if (this.mIsRegisterReceiver == true) goto L12;
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.bluetooth.device.action.FOUND");
        r0.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        INVOKEVIRTUAL_com_bytedance_bdlocation_scan_bluetooth_BluetoothInfoManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r3, this.mBluetoothReceiver, r0);
        this.mIsRegisterReceiver = true;
        return;
    }

    private void setDeviceData(BluetoothDevice r4, int r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        BDBleInfo r0 = new BDBleInfo();
        String r1 = BDLocationExtrasService.getBPEAManager().getAddress(r4, this.mBpeaCert);
        String r6 = r4.getName();
        if (r6 == null) goto L7;
        r0.bleName = r6;
    L7:
        r0.bleMac = r1;
        r0.rssi = r5;
        r0.timeStamp = System.currentTimeMillis();
        addList(r0);
        BluetoothScanCallback r3 = mBluetoothCallback;
        if (r3 == null) goto L11;
        r3.onScan(r0);
        return;
    }

    private void startBleScan(Object r9) {
        if (this.mBluetoothAdapter.isEnabled() == true) goto L24;
        Logger.d("未开启蓝牙");
        return;
    L24:
    L20:
        e = move-exception;
        Logger.d("BDShakeCollectManager", "startBleCollect error" + e.getMessage());
        return;
    L7:
        if (BDLocationConfig.isBackground() == false) goto L9;
        return;
    L9:
        int r1 = Build.VERSION.SDK_INT;     // Catch: Exception -> L20
        if (r1 < 21) goto L15;
        ScanSettings r5 = new ScanSettings.Builder().setScanMode(this.mScanMode).build();     // Catch: Exception -> L20
        BluetoothLeScanner r2 = this.mBluetoothAdapter.getBluetoothLeScanner();     // Catch: Exception -> L20
        this.mBluetoothLeScanner = r2;     // Catch: Exception -> L20
        ScanCallback r3 = this.mScanCallback;     // Catch: Exception -> L20
        if (r3 == null) goto L23;
        r2.stopScan(r3);     // Catch: Exception -> L20
        Logger.d("BDShakeCollectManager", "startLeScan bluetoothStartScan:");     // Catch: Exception -> L20
        BDLocationExtrasService.getBPEAManager().bluetoothStartScan(this.mBluetoothLeScanner, null, r5, this.mScanCallback, r9);     // Catch: Exception -> L20
    L23:
        return;
    L15:
        if (r1 < 18) goto L23;
        BluetoothAdapter.LeScanCallback r4 = this.mLeScanCallback;     // Catch: Exception -> L20
        if (r4 == null) goto L23;
        this.mBluetoothAdapter.stopLeScan(r4);     // Catch: Exception -> L20
        BDLocationExtrasService.getBPEAManager().startLeScan(this.mBluetoothAdapter, this.mLeScanCallback, r9);     // Catch: Exception -> L20
        goto L23
    }

    private void startBlueScan(Object r2) {
    L14:
        Logger.d("startBlueCollect error");
        return;
    L3:
        if (BDLocationConfig.isBackground() == false) goto L6;
        return;
    L6:
        if (this.mBluetoothAdapter.isEnabled() == true) goto L10;
        Logger.d("未开启蓝牙");     // Catch: Exception -> L14
        return;
    L10:
        if (this.mBluetoothAdapter.isDiscovering() == false) goto L12;
        this.mBluetoothAdapter.cancelDiscovery();     // Catch: Exception -> L14
    L12:
        BDLocationExtrasService.getBPEAManager().startDiscovery(this.mBluetoothAdapter, r2);     // Catch: Exception -> L14
        Logger.d("BluetoothAdapterstartNormalBlueCollect");     // Catch: Exception -> L14
    }

    private void stopBleScan() {
        int r0 = Build.VERSION.SDK_INT;
        Logger.d("BLE扫描结束------------------");     // Catch: Exception -> L16
        BluetoothLeScanner r1 = this.mBluetoothLeScanner;     // Catch: Exception -> L16
        if (r1 == null) goto L11;
        if (r0 < 21) goto L11;
        if (this.mLeScanCallback == null) goto L11;
        r1.stopScan(this.mScanCallback);     // Catch: Exception -> L16
    L11:
        if (r0 < 18) goto L21;
        BluetoothAdapter.LeScanCallback r2 = this.mLeScanCallback;     // Catch: Exception -> L16
        if (r2 == null) goto L22;
        this.mBluetoothAdapter.stopLeScan(r2);     // Catch: Exception -> L16
        return;
    L22:
        return;
    L21:
        return;
    L16:
        e = move-exception;
        Logger.d("stopBleScan error:" + e.getMessage());
    }

    private void stopBlueScan() {
    L6:
        e = move-exception;
        Logger.d("stopBlueScan error:" + e.getMessage());
        return;
    L3:
        if (this.mBluetoothAdapter.isDiscovering() == false) goto L11;
        Logger.d("Blue扫描结束------------------");     // Catch: Exception -> L6
        this.mBluetoothAdapter.cancelDiscovery();     // Catch: Exception -> L6
        return;
    }

    private void unRegisterScanReceiver(Context r2) {
        if (this.mIsRegisterReceiver == false) goto L10;
        if (r2 == null) goto L8;
        BroadcastReceiver r0 = this.mBluetoothReceiver;
        if (r0 == null) goto L8;
        r2.unregisterReceiver(r0);
    L8:
        this.mIsRegisterReceiver = false;
        return;
    }

    public /* synthetic */ void b(long r1, Object r3) {
        a(r1, r3);
    }

    public boolean blueToothIsEnabled() {
        return this.mBluetoothAdapter.isEnabled();
    L4:
        e = move-exception;
        Logger.d("blueToothIsEnabled error" + e.getMessage());
        return false;
    }

    public /* synthetic */ void d() {
        c();
    }

    public /* synthetic */ void f(Object r1, BluetoothScanCallback r2, long r3, long r5) {
        e(r1, r2, r3, r5);
    }

    public List<BDBleInfo> getBlueToothList() {
        return this.mBluetoothList;
    }

    public void setScanMode(int r1) {
        this.mScanMode = r1;
    }

    public synchronized void startScan(final BluetoothScanCallback r12, final long r13, final long r15, final Object r17) {
        monitor-enter(this);
        this.mHandler.removeCallbacksAndMessages(null);     // Catch: Throwable -> L7
        this.mHandler.post(new d(this, r17, r12, r15, r13));     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void stopScan() {
        monitor-enter(this);
        stopBlueScan();     // Catch: Throwable -> L7 Exception -> L9
        stopBleScan();     // Catch: Throwable -> L7 Exception -> L9
        mBluetoothCallback = null;     // Catch: Throwable -> L7 Exception -> L9
        if (this.mIsRegisterReceiver == false) goto L11;
        unRegisterScanReceiver(this.mContext);     // Catch: Throwable -> L7 Exception -> L9
        this.mIsRegisterReceiver = false;     // Catch: Throwable -> L7 Exception -> L9
    L11:
        monitor-exit(this);
        return;
    L9:
        e = move-exception;
        Logger.d("BDShakeCollectManager", "stopBlueScan error" + e.getMessage());     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }
}
