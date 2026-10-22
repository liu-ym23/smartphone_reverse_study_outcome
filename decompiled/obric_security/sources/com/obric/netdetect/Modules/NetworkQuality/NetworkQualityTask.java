package com.obric.netdetect.Modules.NetworkQuality;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.obric.netdetect.API.Callback.NetworkQualityCallback;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkQualityTask extends AsyncTask<Integer, Void, Void> implements CellularQualityEvaluator.CellularQualityListener, WiFiQualityEvaluator.WiFiQualityListener {
    private static final String TAG = "NetworkQualityTask";
    private final NetworkQualityCallback mCallback;
    private CellularQualityEvaluator mCellularQualityEvaluator;
    private TelephonyManager mTelephonyManager;
    private WiFiQualityEvaluator mWiFiQualityEvaluator;
    private WifiManager mWifiManager;

    @Override // android.os.AsyncTask
    protected /* bridge */ /* synthetic */ Void doInBackground(Integer[] r1) {
        return doInBackground2(r1);
    }

    public NetworkQualityTask(Context r1, NetworkQualityCallback r2) {
        this.mCallback = r2;
        this.mWifiManager = (WifiManager) r1.getSystemService("wifi");
        this.mTelephonyManager = (TelephonyManager) r1.getSystemService("phone");
        int r3 = SubscriptionManager.getDefaultDataSubscriptionId();
        if (r3 == (-1)) goto L5;
        this.mTelephonyManager = this.mTelephonyManager.createForSubscriptionId(r3);
    L5:
        this.mCellularQualityEvaluator = new CellularQualityEvaluator(this.mTelephonyManager, this);
        this.mWiFiQualityEvaluator = new WiFiQualityEvaluator(this.mWifiManager, this);
    }

    /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
    protected Void doInBackground2(Integer... r2) {
        int r3 = r2[0].intValue();
        if (r3 != 1) goto L5;
        this.mWiFiQualityEvaluator.start();
        return null;
    L5:
        if (r3 != 2) goto L12;
        this.mCellularQualityEvaluator.start();
        return null;
    L12:
        return null;
    }

    @Override // com.obric.netdetect.Modules.NetworkQuality.CellularQualityEvaluator.CellularQualityListener
    public void onCellularQualityReceived(int r9, int r10, int r11, int r12, int r13, int r14, int r15) {
        NetworkQualityResult r16 = NetworkQualityResult.create().createCellularQualityResult(r9, r10, r11, r12, r13, r14, r15);
        NetworkQualityCallback r8 = this.mCallback;
        if (r8 == null) goto L6;
        r8.onNetworkQualityResult(r16);
        return;
    }

    @Override // com.obric.netdetect.Modules.NetworkQuality.WiFiQualityEvaluator.WiFiQualityListener
    public void onWiFiQualityReceived(int r10, int r11, int r12, float r13, int r14, int r15, int r16, int r17) {
        NetworkQualityResult r0 = NetworkQualityResult.create().createWifiQualityResult(r10, r11, r12, r13, r14, r15, r16, r17);
        NetworkQualityCallback r1 = this.mCallback;
        if (r1 == null) goto L6;
        r1.onNetworkQualityResult(r0);
        return;
    }
}
