package com.obric.netdetect.Modules.NetworkQuality;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.RemoteException;
import com.obric.cae.libs.wifi.ICaeSmartNetworkManager;
import com.obric.netdetect.Utils.NetDetectLog;
import com.obric.netdetect.Utils.WifiUtils;

/* JADX INFO: loaded from: classes3.dex */
public class WiFiQualityEvaluator {
    private static final int GET_SERVER_INTERVAL_MS = 100;
    private static final int INVALID_RSSI = -127;
    private static final int RETRY_GET_SERVER_COUNT = 30;
    private static final String TAG = "WiFiQualityEvaluator";
    private static final String WIFI_QOS_SERVICE_NAME = "cae_wifi";
    private static final int[] rssi24GThresholds = null;
    private static final int[] rssi5GThresholds = null;
    private static final int[] rxLinkSpeedThresholds = null;
    private static final int[] throughputThresholds = null;
    private static final int[] txLinkSpeedThresholds = null;
    private ICaeSmartNetworkManager mCaeSmartNetworkManager;
    private final WiFiQualityListener mListener;
    private final WifiManager mWifiManager;

    public interface WiFiQualityListener {
        void onWiFiQualityReceived(int r1, int r2, int r3, float r4, int r5, int r6, int r7, int r8);
    }

    static /* synthetic */ ICaeSmartNetworkManager access$000(WiFiQualityEvaluator r0) {
        return r0.mCaeSmartNetworkManager;
    }

    static /* synthetic */ ICaeSmartNetworkManager access$002(WiFiQualityEvaluator r0, ICaeSmartNetworkManager r1) {
        r0.mCaeSmartNetworkManager = r1;
        return r1;
    }

    static /* synthetic */ void access$100(WiFiQualityEvaluator r0) {
        r0.setBinderDeath();
    }

    static {
        rssi24GThresholds = new int[]{-55, -65, -75, -127};
        rssi5GThresholds = new int[]{-60, -70, -80, -127};
        txLinkSpeedThresholds = new int[]{108, 68, 17, 0};
        rxLinkSpeedThresholds = new int[]{108, 68, 17, 0};
        throughputThresholds = new int[]{108, 68, 17, 0};
    }

    public WiFiQualityEvaluator(WifiManager r2, WiFiQualityListener r3) {
        this.mCaeSmartNetworkManager = null;
        this.mListener = r3;
        this.mWifiManager = r2;
        doBindServiceThread();
    }

    private void doBindServiceThread() {
        new Thread(new AnonymousClass1(this)).start();
    }

    private void setBinderDeath() {
        this.mCaeSmartNetworkManager.asBinder().linkToDeath(new AnonymousClass2(this), 0);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        NetDetectLog.e(TAG, "mCaeSmartNetworkManager linkToDeath! :" + e);
    }

    public void start() {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (this.mCaeSmartNetworkManager != null) goto L13;
        if (r1 >= 30) goto L13;
        Thread.sleep(100);     // Catch: InterruptedException -> L10
        r1 = r1 + 1;
    L10:
        e = move-exception;
        throw new RuntimeException(e);
    L13:
        WifiInfo r2 = this.mWifiManager.getConnectionInfo();
        int[] r3 = rssi24GThresholds;
        int r9 = WifiUtils.getBand(r2.getFrequency());
        if (r9 != 2) goto L16;
        r3 = rssi5GThresholds;
    L16:
        int r10 = r2.getRssi();
        int r11 = r2.getTxLinkSpeedMbps();
        int r12 = r2.getRxLinkSpeedMbps();
        calculateRssiLevel(r10, r3);
        calculateLinkSpeedLevel(r11, txLinkSpeedThresholds);
        calculateLinkSpeedLevel(r12, rxLinkSpeedThresholds);
        ICaeSmartNetworkManager r4 = this.mCaeSmartNetworkManager;
        float r5 = 0.0f;
        if (r4 != null) goto L31;
        NetDetectLog.d(TAG, "CaeSmartNetworkManager bind failed.");
        int r6 = 0;
        int r7 = 0;
    L25:
        float r8 = r5;
        int r13 = (int) (r6 * (1.0f - ((r7 * r8) / 100.0f)));
        int r14 = calculateLinkSpeedLevel(r13, throughputThresholds);
        NetDetectLog.d(TAG, "wifi quality: throughput=" + r6 + ", jitterThroughput=" + r13 + ", jitter=" + r7 + ", jitterWeight:" + r8 + ", rssi=" + r10 + ", txLinkSpeed=" + r11 + ", rxLinkSpeed=" + r12 + ", level=" + r14);
        this.mListener.onWiFiQualityReceived(r14, r6, r7, r8, r9, r10, r11, r12);
        return;
    L31:
        int r15 = r4.getLinkThroughput();     // Catch: RemoteException -> L22
        r0 = this.mCaeSmartNetworkManager.getLinkThroughputJitter();     // Catch: RemoteException -> L21
        r5 = this.mCaeSmartNetworkManager.getLinkThroughputJitterWeight();     // Catch: RemoteException -> L21
        r7 = r0;
        r6 = r15;
    L21:
        int r16 = r0;
        r0 = r15;
    L23:
        NetDetectLog.e(TAG, "CaeSmartNetworkManager getLinkThroughput failed.");
        r6 = r0;
        r7 = r16;
    L22:
        r16 = 0;
        goto L23
    }

    private int calculateRssiLevel(int r5, int[] r6) {
        if (r5 != (-127)) goto L6;
        return 0;
    L6:
        if (r5 < r6[0]) goto L9;
        return 4;
    L9:
        if (r5 < r6[1]) goto L12;
        return 3;
    L12:
        if (r5 < r6[2]) goto L15;
        return 2;
    L15:
        if (r5 >= r6[3]) goto L17;
        return 0;
    L17:
        return 1;
    }

    private int calculateLinkSpeedLevel(int r5, int[] r6) {
        if (r5 != (-1)) goto L6;
        return 0;
    L6:
        if (r5 < r6[0]) goto L9;
        return 4;
    L9:
        if (r5 < r6[1]) goto L12;
        return 3;
    L12:
        if (r5 < r6[2]) goto L15;
        return 2;
    L15:
        if (r5 >= r6[3]) goto L17;
        return 0;
    L17:
        return 1;
    }
}
