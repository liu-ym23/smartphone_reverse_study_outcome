package com.obric.netdetect.Modules.NetworkInfo;

import android.content.Context;
import android.net.Network;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.obric.netdetect.API.Callback.NetworkInfoCallback;
import com.obric.netdetect.Utils.NetDetectLog;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkInfoTask extends AsyncTask<Integer, Void, Void> implements WifiNetworkProvider.WifiNetworkListener, CellularNetworkProvider.CellularNetworkListener {
    private static final String TAG = "NetworkInfoTask";
    private CellularNetworkProvider mCellularNetworkProvider;
    private IpInfoProvider mIpInfoProvider;
    private LinkInfoProvider mLinkInfoProvider;
    private Network mNetwork;
    private final NetworkInfoCallback mNetworkInfoCallback;
    private TelephonyManager mTelephonyManager;
    private WifiManager mWifiManager;
    private WifiNetworkProvider mWifiNetworkProvider;

    @Override // android.os.AsyncTask
    protected /* bridge */ /* synthetic */ Void doInBackground(Integer[] r1) {
        return doInBackground2(r1);
    }

    public NetworkInfoTask(Context r1, NetworkInfoCallback r2, Network r3) {
        this.mNetworkInfoCallback = r2;
        this.mNetwork = r3;
        this.mWifiManager = (WifiManager) r1.getSystemService("wifi");
        this.mTelephonyManager = (TelephonyManager) r1.getSystemService("phone");
        int r4 = SubscriptionManager.getDefaultDataSubscriptionId();
        if (r4 == (-1)) goto L5;
        this.mTelephonyManager = this.mTelephonyManager.createForSubscriptionId(r4);
    L5:
        this.mIpInfoProvider = new IpInfoProvider(r1, this.mNetwork);
        this.mLinkInfoProvider = new LinkInfoProvider(r1, this.mNetwork);
    }

    /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
    protected Void doInBackground2(Integer... r4) {
        int r5 = r4[0].intValue();
        if (r5 != 1) goto L5;
        WifiNetworkProvider r6 = new WifiNetworkProvider(this.mWifiManager, this.mLinkInfoProvider, this.mIpInfoProvider, this);
        this.mWifiNetworkProvider = r6;
        r6.start();
        return null;
    L5:
        if (r5 != 2) goto L12;
        CellularNetworkProvider r7 = new CellularNetworkProvider(this.mTelephonyManager, this.mIpInfoProvider, this.mLinkInfoProvider, this);
        this.mCellularNetworkProvider = r7;
        r7.start();
        return null;
    L12:
        return null;
    }

    @Override // com.obric.netdetect.Modules.NetworkInfo.CellularNetworkProvider.CellularNetworkListener
    public void onCellularNetworkInfoReceived(NetworkInfoResult.CellularInfo r10, NetworkInfoResult.LinkInfo r11, NetworkInfoResult.IpInfo r12) {
        NetDetectLog.i(TAG, "received cellular network info");
        NetworkInfoCallback r0 = this.mNetworkInfoCallback;
        if (r0 == null) goto L6;
        r0.onNetworkInfoResult(new NetworkInfoResult(2, Integer.parseInt(this.mNetwork.toString()), null, r10, r11, r12));
        return;
    }

    @Override // com.obric.netdetect.Modules.NetworkInfo.WifiNetworkProvider.WifiNetworkListener
    public void onWifiNetworkInfoReceived(NetworkInfoResult.WifiConnInfo r10, NetworkInfoResult.LinkInfo r11, NetworkInfoResult.IpInfo r12) {
        NetDetectLog.i(TAG, "received wifi network info");
        NetworkInfoCallback r0 = this.mNetworkInfoCallback;
        if (r0 == null) goto L6;
        r0.onNetworkInfoResult(new NetworkInfoResult(1, Integer.parseInt(this.mNetwork.toString()), r10, null, r11, r12));
        return;
    }
}
