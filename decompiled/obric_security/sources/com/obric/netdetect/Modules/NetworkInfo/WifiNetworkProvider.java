package com.obric.netdetect.Modules.NetworkInfo;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.obric.netdetect.Utils.WifiUtils;

/* JADX INFO: loaded from: classes3.dex */
public class WifiNetworkProvider {
    private static final String TAG = "WifiNetworkProvider";
    private final IpInfoProvider mIpInfoProvider;
    private final LinkInfoProvider mLinkInfoProvider;
    private final WifiNetworkListener mListener;
    private final WifiManager mWifiManager;

    public interface WifiNetworkListener {
        void onWifiNetworkInfoReceived(NetworkInfoResult.WifiConnInfo r1, NetworkInfoResult.LinkInfo r2, NetworkInfoResult.IpInfo r3);
    }

    public WifiNetworkProvider(WifiManager r1, LinkInfoProvider r2, IpInfoProvider r3, WifiNetworkListener r4) {
        this.mLinkInfoProvider = r2;
        this.mIpInfoProvider = r3;
        this.mWifiManager = r1;
        this.mListener = r4;
    }

    public void start() {
        NetworkInfoResult.WifiConnInfo r0 = getWifiConnInfo();
        NetworkInfoResult.LinkInfo r1 = this.mLinkInfoProvider.getLinkInfo();
        this.mListener.onWifiNetworkInfoReceived(r0, r1, null);
    }

    private NetworkInfoResult.WifiConnInfo getWifiConnInfo() {
        WifiInfo r10 = this.mWifiManager.getConnectionInfo();
        if (r10 != null) goto L6;
        return null;
    L6:
        String r1 = r10.getSSID();
        String r2 = r10.getBSSID();
        int r3 = r10.getFrequency();
        int r4 = WifiUtils.getBand(r3);
        int r7 = r10.getRssi();
        int r8 = r10.getTxLinkSpeedMbps();
        int r9 = r10.getRxLinkSpeedMbps();
        return new NetworkInfoResult.WifiConnInfo(r1, r2, r3, r4, r10.getWifiStandard(), 0, r7, r8, r9);
    }
}
