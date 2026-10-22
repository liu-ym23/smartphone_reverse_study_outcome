package com.bytedance.bdlocation.scan.wifi;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.network.model.WifiInfo;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import com.google.gson.g;
import com.google.gson.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class WifiUtil {
    public static final String TAG = "WifiUtil";

    public interface WifiInfoJsonCallback {
        void onFailed(BDLocationException r1);

        void onWifiInfoJson(g r1, boolean r2);
    }

    public WifiUtil() {
    }

    static /* synthetic */ void a(long r3, WifiInfoJsonCallback r5, List r6, boolean r7) {
        LocationMonitor.fetchWifiDuration(SystemClock.elapsedRealtime() - r3);
        Logger.i("LocationMonitor fetch wifi duration is: " + (SystemClock.elapsedRealtime() - r3) + "ms");
        List<WifiInfo> r4 = getWifiListByNum(r6);
        if (r4 != null) goto L5;
    L9:
        g r8 = null;
    L10:
        r5.onWifiInfoJson(r8, r7);
        return;
    L5:
        if (r4.size() <= 0) goto L9;
        j r9 = JsonUtil.toJsonTreeSafely(r4, new AnonymousClass1().getType());
        if (r9 == null) goto L9;
        r8 = r9.b();
        goto L10
    }

    public static long getCurrentTimeSeconds() {
        return System.currentTimeMillis() / 1000;
    }

    @Nullable
    public static g getMockWifiJson() {
        ArrayList r0 = new ArrayList();
        WifiInfo r1 = new WifiInfo();
        r1.wifiMac = LocationInfoConst.MOCK_WIFI_MAC;
        r1.rssi = 0;
        r1.isCurrent = 1;
        r1.wifiName = BDLocationConfig.getMockWifiName();
        r1.timeStamp = getCurrentTimeSeconds();
        r0.add(r1);
        j r2 = JsonUtil.toJsonTreeSafely(r0, new AnonymousClass3().getType());
        if (r2 != null) goto L5;
        return null;
    L5:
        if (r2.m() == true) goto L8;
        return null;
    L8:
        return r2.b();
    }

    @Nullable
    public static g getWifiInfoJson(Context r2, Object r3) {
        if (r2 != null) goto L21;
        return null;
    L21:
    L18:
        e = move-exception;
        Logger.e("", e);
        return null;
    L6:
        if (BDLocationConfig.isUploadWIFI() == false) goto L23;
        List<WifiInfo> r4 = WifiInfoManager.getWifiInfos(r2, r3, true);     // Catch: Exception -> L18
        if (getWifiListByNum(r4) != null) goto L10;
        return null;
    L10:
        j r5 = JsonUtil.toJsonTreeSafely(r4, new AnonymousClass2().getType());     // Catch: Exception -> L18
        if (r5 != null) goto L13;
    L17:
        return null;
    L13:
        if (r5.m() == false) goto L17;
        return r5.b();
    L23:
        return null;
    }

    public static void getWifiInfoJsonAsync(Context r6, final WifiInfoJsonCallback r7, Object r8) {
    L10:
        e = move-exception;
        Logger.e("", e);
        r7.onFailed(new BDLocationException(e.getMessage(), null, BDLocationException.ERROR_WIFI_UPLOAD));
        return;
    L4:
        if (BDLocationConfig.isUploadWIFI() == true) goto L6;
    L8:
        r7.onFailed(new BDLocationException("没有开启wifi上报", null, BDLocationException.ERROR_WIFI_UPLOAD));     // Catch: Exception -> L10
    L13:
        return;
    L6:
        if (BDLocationConfig.isOverSeas() == true) goto L8;
        WifiInfoManager r2 = new WifiInfoManager();     // Catch: Exception -> L10
        final long r3 = SystemClock.elapsedRealtime();     // Catch: Exception -> L10
        r2.getWifiScanInfos(r6, new f(r3, r7), r8);     // Catch: Exception -> L10
        goto L13
    }

    @Nullable
    private static List<WifiInfo> getWifiListByNum(List<WifiInfo> r2) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.isEmpty() == true) goto L13;
        Collections.sort(r2);
        int r0 = r2.size();
        if (r0 <= BDLocationConfig.getWifiNum()) goto L10;
        r0 = BDLocationConfig.getWifiNum();
    L10:
        return r2.subList(0, r0);
    L13:
        return null;
    }
}
