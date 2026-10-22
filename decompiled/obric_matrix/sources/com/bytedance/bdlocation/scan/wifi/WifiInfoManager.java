package com.bytedance.bdlocation.scan.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.network.model.WifiInfo;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.thread.AppExecutors;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class WifiInfoManager {
    private static final String TAG = "WifiInfoManager";
    private static SparseIntArray sChannelFrequency;
    private AppExecutors mAppExecutors;
    private Object mBpeaCert;
    private volatile boolean mEnableCallbackOnMainThread;
    private volatile boolean mIsNotified;
    private volatile boolean mIsRegisterReceiver;
    private WifiInfoCallback mWifiInfoCallback;
    private BroadcastReceiver mWifiScanReceiver;

    /* JADX INFO: renamed from: com.bytedance.bdlocation.scan.wifi.WifiInfoManager$1, reason: invalid class name */
    class AnonymousClass1 extends BroadcastReceiver {
        final /* synthetic */ WifiInfoManager this$0;

        AnonymousClass1(WifiInfoManager r1) {
            this.this$0 = r1;
        }

        private /* synthetic */ void a(Intent r7, Context r8) {
            long r0 = System.currentTimeMillis() / 1000;
            boolean r9 = r7.getBooleanExtra("resultsUpdated", false);
            if (r9 == false) goto L5;
            String r4 = "WifiInfoManager scan wifi from broadcast result is success.";
        L6:
            Logger.i(r4);
            if (WifiInfoManager.access$100(this.this$0) == true) goto L9;
            WifiInfoManager.access$200(this.this$0, r8, !r9);
        L9:
            WifiInfoManager.access$300(this.this$0, r8);
            Logger.i("WifiInfoManager Receiver excutTime:" + ((System.currentTimeMillis() / 1000) - r0) + "--success " + r9);
            return;
        L5:
            r4 = "WifiInfoManager scan wifi from broadcast result is failed.";
            goto L6
        }

        public /* synthetic */ void b(Intent r1, Context r2) {
            a(r1, r2);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(final Context r3, final Intent r4) {
            Logger.i("WifiInfoManager wifi scan receive broadcast result");
            WifiInfoManager.access$000(this.this$0).diskIO().execute(new a(this, r4, r3));
        }
    }

    public interface WifiInfoCallback {
        default void onFailed(int r2, String r3) {
            Logger.i(WifiInfoManager.TAG, "get wifiInfos failed, code:" + r2 + "--message:" + r3);
        }

        void onWifiInfo(List<WifiInfo> r1, boolean r2);
    }

    static {
        SparseIntArray r0 = new SparseIntArray();
        sChannelFrequency = r0;
        r0.put(1, 2412);
        sChannelFrequency.put(2, 2417);
        sChannelFrequency.put(3, 2422);
        sChannelFrequency.put(4, 2427);
        sChannelFrequency.put(5, 2432);
        sChannelFrequency.put(6, 2437);
        sChannelFrequency.put(7, 2442);
        sChannelFrequency.put(8, 2447);
        sChannelFrequency.put(9, 2452);
        sChannelFrequency.put(10, 2457);
        sChannelFrequency.put(11, 2462);
        sChannelFrequency.put(12, 2467);
        sChannelFrequency.put(13, 2472);
        sChannelFrequency.put(14, 2484);
        sChannelFrequency.put(36, 5180);
        sChannelFrequency.put(40, 5200);
        sChannelFrequency.put(44, 5220);
        sChannelFrequency.put(48, 5240);
        sChannelFrequency.put(52, 5260);
        sChannelFrequency.put(56, 5280);
        sChannelFrequency.put(60, 5300);
        sChannelFrequency.put(64, 5320);
        sChannelFrequency.put(100, 5500);
        sChannelFrequency.put(104, 5520);
        sChannelFrequency.put(108, 5540);
        sChannelFrequency.put(112, 5560);
        sChannelFrequency.put(116, 5580);
        sChannelFrequency.put(120, 5600);
        sChannelFrequency.put(124, 5620);
        sChannelFrequency.put(128, 5640);
        sChannelFrequency.put(132, 5660);
        sChannelFrequency.put(136, 5680);
        sChannelFrequency.put(140, 5700);
        sChannelFrequency.put(149, 5745);
        sChannelFrequency.put(153, 5765);
        sChannelFrequency.put(157, 5785);
        sChannelFrequency.put(161, 5805);
    }

    public WifiInfoManager() {
        this.mIsNotified = false;
        this.mAppExecutors = AppExecutors.getInstance();
        this.mIsRegisterReceiver = false;
        this.mBpeaCert = null;
        this.mWifiScanReceiver = new AnonymousClass1(this);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent INVOKEVIRTUAL_com_bytedance_bdlocation_scan_wifi_WifiInfoManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    static /* synthetic */ void a(WifiInfoCallback r0, int r1, String r2) {
        r0.onFailed(r1, r2);
    }

    static /* synthetic */ AppExecutors access$000(WifiInfoManager r0) {
        return r0.mAppExecutors;
    }

    static /* synthetic */ boolean access$100(WifiInfoManager r0) {
        return r0.mIsNotified;
    }

    static /* synthetic */ void access$200(WifiInfoManager r0, Context r1, boolean r2) {
        r0.notifyWifi(r1, r2);
    }

    static /* synthetic */ void access$300(WifiInfoManager r0, Context r1) {
        r0.unRegisterReceiver(r1);
    }

    private static void addScanWifiInfoMonitor(boolean r2, String r3) {
        if (BDLocationConfig.isOpenWifiListMonitor() == false) goto L6;
        Logger.i(LocationMonitorConst.EVENT_CONNECT_WIFI_INFO, "isCache:" + r2 + "--connectWifi:" + r3);
        LocationMonitor.doConnectWifiInfo(r2, r3);
        return;
    }

    private static void addScanWifiListMonitor(boolean r7, List<ScanResult> r8) {
        if (BDLocationConfig.isOpenWifiListMonitor() == true) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList(r8);
        Logger.i(LocationMonitorConst.EVENT_SCAN_WIFI_LIST, "addScanWifiListMonitor start");
        if (r0.isEmpty() == true) goto L18;
        JSONArray r1 = new JSONArray();
        int r2 = 0;
    L9:
        if (r2 >= r0.size()) goto L17;
        ScanResult r3 = (ScanResult) r0.get(r2);
        if (r3 == null) goto L16;
        JSONObject r4 = new JSONObject();     // Catch: JSONException -> L14
        r4.put("w_ssid", r3.SSID);     // Catch: JSONException -> L14
        r4.put("w_bssid", r3.BSSID);     // Catch: JSONException -> L14
        r4.put("w_rssi", r3.level);     // Catch: JSONException -> L14
        r1.put(r4);     // Catch: JSONException -> L14
    L14:
        e = move-exception;
        Logger.i(LocationMonitorConst.EVENT_SCAN_WIFI_LIST, "addScanWifiListMonitor JSONException:" + e.toString() + "--scanResult" + r3.toString());
    L16:
        r2 = r2 + 1;
        goto L9
    L17:
        String r5 = r1.toString();
        Logger.i(LocationMonitorConst.EVENT_SCAN_WIFI_LIST, "isCache:" + r7 + "--scanResults:" + r5 + "--end");
        LocationMonitor.doScanWiFiList(r7, r5);
        return;
    L18:
        LocationMonitor.doScanWiFiList(r7, "");
    }

    static /* synthetic */ void b(WifiInfoCallback r0, int r1, String r2) {
        r0.onFailed(r1, r2);
    }

    static /* synthetic */ void c(WifiInfoCallback r0, List r1, boolean r2) {
        r0.onWifiInfo(r1, r2);
    }

    static /* synthetic */ void d(WifiInfoCallback r0, List r1, boolean r2) {
        r0.onWifiInfo(r1, r2);
    }

    private static android.net.wifi.WifiInfo getConnectWifiInfo(Context r1, WifiManager r2, Object r3) {
        if (r1 == null) goto L18;
        if (r2 != null) goto L5;
        return null;
    L5:
        if (isWifi(r1) == false) goto L20;
        android.net.wifi.WifiInfo r4 = getConnectionInfo(r1, r2, r3);     // Catch: Throwable -> L12
        if (((ConnectivityManager) r1.getApplicationContext().getSystemService("connectivity")).getNetworkInfo(1).getState() != NetworkInfo.State.CONNECTED) goto L21;
        if (r4 == null) goto L22;
        if (BDLocationExtrasService.getBPEAManager().getSSID(r4, r3) == null) goto L23;
        return r4;
    L23:
        return null;
    L22:
        return null;
    L21:
        return null;
    L12:
        th = move-exception;
        Logger.e("", th);
        return null;
    L20:
        return null;
    L18:
        return null;
    }

    private static android.net.wifi.WifiInfo getConnectionInfo(Context r2, WifiManager r3, Object r4) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if (PermissionManager.hasAnyPermission(r2, new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == true) goto L8;
        return null;
    L8:
        return BDLocationExtrasService.getBPEAManager().getConnectionInfo(r3, r4);
    }

    @Nullable
    public static List<WifiInfo> getWifiInfos(Context r13, Object r14, boolean r15) {
        int r0 = Build.VERSION.SDK_INT;
        if (BDLocationConfig.isUploadWIFI() == true) goto L5;
        return null;
    L5:
        if (r13 != null) goto L59;
        return null;
    L59:
        WifiManager r1 = (WifiManager) r13.getApplicationContext().getSystemService("wifi");     // Catch: Exception -> L56
        if (r1 != null) goto L10;
        return null;
    L10:
        ArrayList r3 = new ArrayList();     // Catch: Exception -> L56
        if (PermissionManager.hasAnyPermission(r13, new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == false) goto L13;
        List<ScanResult> r4 = BDLocationExtrasService.getBPEAManager().getScanResults(r1, r14);     // Catch: Exception -> L56
        addScanWifiListMonitor(r15, r4);     // Catch: Exception -> L56
    L14:
        StringBuilder r5 = new StringBuilder();     // Catch: Exception -> L56
        r5.append("wifi scan result is null: ");     // Catch: Exception -> L56
        if (r4 != null) goto L17;
        boolean r8 = true;
    L18:
        r5.append(r8);     // Catch: Exception -> L56
        Logger.i(r5.toString());     // Catch: Exception -> L56
        android.net.wifi.WifiInfo r16 = getConnectWifiInfo(r13, r1, r14);     // Catch: Exception -> L56
        if (r16 == null) goto L21;
        addScanWifiInfoMonitor(r15, r16.toString());     // Catch: Exception -> L56
        String r17 = BDLocationExtrasService.getBPEAManager().getBSSID(r16, r14);     // Catch: Exception -> L56
    L23:
        if (isValidWifiInfo(r17) == false) goto L33;
        WifiInfo r2 = new WifiInfo();     // Catch: Exception -> L56
        String r18 = BDLocationExtrasService.getBPEAManager().getSSID(r16, r14);     // Catch: Exception -> L56
        if (TextUtils.isEmpty(r18) == false) goto L27;
    L29:
        r2.wifiName = r18;     // Catch: Exception -> L56
        r2.wifiMac = r17;     // Catch: Exception -> L56
        r2.rssi = r16.getRssi();     // Catch: Exception -> L56
        r2.isCurrent = 1;     // Catch: Exception -> L56
        r2.timeStamp = WifiUtil.getCurrentTimeSeconds();     // Catch: Exception -> L56
        if (r0 < 21) goto L32;
        r2.frequency = r16.getFrequency();     // Catch: Exception -> L56
    L32:
        r3.add(r2);     // Catch: Exception -> L56
        goto L33
    L27:
        if (r18.matches("\".*\"") == false) goto L29;
        r18 = r18.substring(1, r18.length() - 1);     // Catch: Exception -> L56
    L33:
        if (r4 != null) goto L35;
    L55:
        return r3;
    L35:
        if (r4.isEmpty() == true) goto L55;
        int r19 = r4.size();     // Catch: Exception -> L56
        int r110 = 0;
    L37:
        if (r110 >= r19) goto L55;
        ScanResult r6 = r4.get(r110);     // Catch: Exception -> L56
        if (r6 == null) goto L54;
        if (TextUtils.isEmpty(r6.SSID) == true) goto L54;
        if (TextUtils.isEmpty(r6.BSSID) == true) goto L54;
        if (r6.capabilities.contains("[IBSS]") == true) goto L54;
        if (r6.BSSID.equalsIgnoreCase(r17) == true) goto L54;
        WifiInfo r7 = new WifiInfo();     // Catch: Exception -> L56
        r7.wifiName = r6.SSID;     // Catch: Exception -> L56
        r7.wifiMac = r6.BSSID;     // Catch: Exception -> L56
        r7.rssi = r6.level;     // Catch: Exception -> L56
        r7.frequency = r6.frequency;     // Catch: Exception -> L56
        r7.isCurrent = 0;     // Catch: Exception -> L56
        if (r0 <= 17) goto L53;
        r7.timeStamp = ((System.currentTimeMillis() - SystemClock.elapsedRealtime()) + (r6.timestamp / 1000)) / 1000;     // Catch: Exception -> L56
    L53:
        r3.add(r7);     // Catch: Exception -> L56
    L54:
        r110 = r110 + 1;
        goto L37
    L21:
        addScanWifiInfoMonitor(r15, "");     // Catch: Exception -> L56
        r17 = null;
        goto L23
    L17:
        r8 = false;
        goto L18
    L13:
        r4 = null;
    L56:
        e = move-exception;
        Logger.v(TAG, "WifiInfo: scan exception", e);
        return null;
    }

    private static boolean isValidWifiInfo(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return false;
    L6:
        if (r2.matches("^[0-9|A-Z|a-z]{2}(:[0-9|A-Z|a-z]{2}){5}$") == true) goto L8;
        return false;
    L8:
        if (TextUtils.equals(r2, "02:00:00:00:00:00") == true) goto L12;
        return true;
    L12:
        return false;
    }

    private static boolean isWifi(Context r2) {
        NetworkInfo r3 = ((ConnectivityManager) r2.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L13
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.isAvailable() == false) goto L17;
        if (1 == r3.getType()) goto L12;
        return false;
    L12:
        return true;
    L17:
        return false;
    L19:
        return false;
    }

    private void notifyFailed(final int r4, final String r5) {
        final WifiInfoCallback r0 = this.mWifiInfoCallback;
        if (r0 != null) goto L5;
        return;
    L5:
        this.mWifiInfoCallback = null;
        if (this.mEnableCallbackOnMainThread == false) goto L10;
        Executor r1 = this.mAppExecutors.mainThread();
        Runnable r2 = new c(r0, r4, r5);
    L8:
        r1.execute(r2);
    L13:
        this.mEnableCallbackOnMainThread = false;
        return;
    L10:
        if (this.mAppExecutors.isMainThread() == false) goto L12;
        r1 = this.mAppExecutors.diskIO();
        r2 = new e(r0, r4, r5);
        goto L8
    L12:
        r0.onFailed(r4, r5);
        goto L13
    }

    private synchronized void notifyWifi(Context r2, boolean r3) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsNotified == true) goto L6;
        notifyWifiInfos(getWifiInfos(r2, this.mBpeaCert, r3), r3);     // Catch: Throwable -> L8
        this.mIsNotified = true;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    private void notifyWifiInfos(final List<WifiInfo> r4, final boolean r5) {
        final WifiInfoCallback r0 = this.mWifiInfoCallback;
        if (r0 != null) goto L5;
        return;
    L5:
        this.mWifiInfoCallback = null;
        if (this.mEnableCallbackOnMainThread == false) goto L10;
        Executor r1 = this.mAppExecutors.mainThread();
        Runnable r2 = new d(r0, r4, r5);
    L8:
        r1.execute(r2);
    L13:
        this.mEnableCallbackOnMainThread = false;
        return;
    L10:
        if (this.mAppExecutors.isMainThread() == false) goto L12;
        r1 = this.mAppExecutors.diskIO();
        r2 = new b(r0, r4, r5);
        goto L8
    L12:
        r0.onWifiInfo(r4, r5);
        goto L13
    }

    private void registerReceiver(Context r3) {
        if (r3 != null) goto L4;
    L13:
        Logger.i("WifiInfoManager has register receiver.");
        return;
    L4:
        if (this.mWifiScanReceiver == null) goto L13;
        if (this.mIsRegisterReceiver == true) goto L13;
        IntentFilter r0 = new IntentFilter();     // Catch: Throwable -> L10
        r0.addAction("android.net.wifi.SCAN_RESULTS");     // Catch: Throwable -> L10
        INVOKEVIRTUAL_com_bytedance_bdlocation_scan_wifi_WifiInfoManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r3, this.mWifiScanReceiver, r0);     // Catch: Throwable -> L10
        this.mIsRegisterReceiver = true;     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        Logger.i("registerReceiver error:" + th.toString());
    }

    private void unRegisterReceiver(Context r3) {
        if (this.mIsRegisterReceiver == false) goto L15;
        if (r3 == null) goto L16;
        BroadcastReceiver r0 = this.mWifiScanReceiver;
        if (r0 == null) goto L17;
        r3.unregisterReceiver(r0);     // Catch: Throwable -> L9
    L11:
        this.mIsRegisterReceiver = false;
        return;
    L9:
        th = move-exception;
        Logger.i("unRegisterReceiver error:" + th.toString());
        goto L11
    L17:
        return;
    L16:
        return;
    }

    public int getChannel(int r1) {
        int r0 = sChannelFrequency.indexOfValue(r1);
        if (r0 >= 0) goto L5;
        return -1;
    L5:
        return sChannelFrequency.keyAt(r0);
    }

    public void getWifiScanInfos(Context r2, WifiInfoCallback r3, Object r4) {
        if (r2 != null) goto L5;
        Logger.d("The method getAllWifiInfos of WifiInfoManager is executed and context is null");
        notifyFailed(-1, "context is null.");
        return;
    L5:
        this.mBpeaCert = r4;
        WifiManager r0 = (WifiManager) r2.getSystemService("wifi");
        registerReceiver(r2);
        this.mWifiInfoCallback = r3;
        this.mIsNotified = false;
        if (BDLocationExtrasService.getBPEAManager().wifiStartScan(r0, r4) == true) goto L9;
        Logger.i("WifiInfoManager start scan failed.");
        notifyWifi(r2, true);
        return;
    }
}
