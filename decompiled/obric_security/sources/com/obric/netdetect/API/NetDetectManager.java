package com.obric.netdetect.API;

import android.content.Context;
import com.obric.netdetect.API.Callback.DnsResolverCallback;
import com.obric.netdetect.API.Callback.HttpProbeCallback;
import com.obric.netdetect.API.Callback.IpProbeCallback;
import com.obric.netdetect.API.Callback.NetworkInfoCallback;
import com.obric.netdetect.API.Callback.NetworkQualityCallback;
import com.obric.netdetect.API.Callback.PingCallback;
import com.obric.netdetect.Modules.NetDetectImpl;

/* JADX INFO: loaded from: classes3.dex */
public class NetDetectManager implements NetDetectInterface {
    private static final String TAG = "NetDetectManager";
    private Context mContext;
    private NetDetectImpl mNetworkDetectImpl;

    public NetDetectManager(Context r2, NetDetectConfig r3) {
        this.mContext = r2;
        this.mNetworkDetectImpl = new NetDetectImpl(this.mContext, r3);
    }

    public boolean updateConfig(NetDetectConfig r1) {
        return this.mNetworkDetectImpl.updateNetDetectConfig(r1);
    }

    @Override // com.obric.netdetect.API.NetDetectInterface
    public void detectHttpConnectivity(int r2, HttpProbeCallback r3) {
        this.mNetworkDetectImpl.sendMessageWithParam(2, r2, r3);
    }

    @Override // com.obric.netdetect.API.NetDetectInterface
    public void detectDnsConnectivity(int r2, DnsResolverCallback r3) {
        this.mNetworkDetectImpl.sendMessageWithParam(1, r2, r3);
    }

    @Override // com.obric.netdetect.API.NetDetectInterface
    public void detectNetworkQuality(int r2, NetworkQualityCallback r3) {
        this.mNetworkDetectImpl.sendMessageWithParam(4, r2, r3);
    }

    @Override // com.obric.netdetect.API.NetDetectInterface
    public void detectPingConnectivity(int r2, PingCallback r3) {
        this.mNetworkDetectImpl.sendMessageWithParam(3, r2, r3);
    }

    @Override // com.obric.netdetect.API.NetDetectInterface
    public void detectNetworkInfo(int r2, NetworkInfoCallback r3) {
        this.mNetworkDetectImpl.sendMessageWithParam(5, r2, r3);
    }

    @Override // com.obric.netdetect.API.NetDetectInterface
    public void detectIpConflict(int r2, IpProbeCallback r3) {
        this.mNetworkDetectImpl.sendMessageWithParam(6, r2, r3);
    }
}
