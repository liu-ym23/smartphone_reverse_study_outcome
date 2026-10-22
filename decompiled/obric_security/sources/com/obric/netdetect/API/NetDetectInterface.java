package com.obric.netdetect.API;

import com.obric.netdetect.API.Callback.DnsResolverCallback;
import com.obric.netdetect.API.Callback.HttpProbeCallback;
import com.obric.netdetect.API.Callback.IpProbeCallback;
import com.obric.netdetect.API.Callback.NetworkInfoCallback;
import com.obric.netdetect.API.Callback.NetworkQualityCallback;
import com.obric.netdetect.API.Callback.PingCallback;

/* JADX INFO: loaded from: classes3.dex */
public interface NetDetectInterface {
    void detectDnsConnectivity(int r1, DnsResolverCallback r2);

    void detectHttpConnectivity(int r1, HttpProbeCallback r2);

    void detectIpConflict(int r1, IpProbeCallback r2);

    void detectNetworkInfo(int r1, NetworkInfoCallback r2);

    void detectNetworkQuality(int r1, NetworkQualityCallback r2);

    void detectPingConnectivity(int r1, PingCallback r2);
}
