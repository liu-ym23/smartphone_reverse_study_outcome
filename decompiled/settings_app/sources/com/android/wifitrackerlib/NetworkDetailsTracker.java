package com.android.wifitrackerlib;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityDiagnosticsManager;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import java.time.Clock;

/* JADX INFO: loaded from: classes2.dex */
public abstract class NetworkDetailsTracker extends BaseWifiTracker {
    public abstract WifiEntry getWifiEntry();

    public static NetworkDetailsTracker createNetworkDetailsTracker(Lifecycle r13, Context r14, WifiManager r15, ConnectivityManager r16, Handler r17, Handler r18, Clock r19, long r20, long r22, String r24) {
        return createNetworkDetailsTracker(new WifiTrackerInjector(r14), r13, r14, r15, r16, r17, r18, r19, r20, r22, r24);
    }

    static NetworkDetailsTracker createNetworkDetailsTracker(WifiTrackerInjector r15, Lifecycle r16, Context r17, WifiManager r18, ConnectivityManager r19, Handler r20, Handler r21, Clock r22, long r23, long r25, String r27) {
        if (r27.startsWith(StandardWifiEntry.KEY_PREFIX) == false) goto L7;
        return new StandardNetworkDetailsTracker(r15, r16, r17, r18, r19, r20, r21, r22, r23, r25, r27);
    L7:
        if (r27.startsWith(PasspointWifiEntry.KEY_PREFIX) == false) goto L11;
        return new PasspointNetworkDetailsTracker(r15, r16, r17, r18, r19, r20, r21, r22, r23, r25, r27);
    L11:
        if (r27.startsWith(HotspotNetworkEntry.KEY_PREFIX) == false) goto L15;
        return new HotspotNetworkDetailsTracker(r15, r16, r17, r18, r19, r20, r21, r22, r23, r25, r27);
    L15:
        throw new IllegalArgumentException("Key does not contain valid key prefix!");
    }

    NetworkDetailsTracker(WifiTrackerInjector r16, Lifecycle r17, Context r18, WifiManager r19, ConnectivityManager r20, Handler r21, Handler r22, Clock r23, long r24, long r26, String r28) {
        super(r16, r17, r18, r19, r20, r21, r22, r23, r24, r26, null, r28);
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker
    protected void handleNetworkStateChangedAction(Intent r3) {
        WifiInfo r0 = this.mWifiManager.getConnectionInfo();
        NetworkInfo r4 = (NetworkInfo) r3.getParcelableExtra("networkInfo");
        if (r0 == null) goto L8;
        if (r4 == null) goto L9;
        getWifiEntry().onPrimaryWifiInfoChanged(r0, r4);
        return;
    L9:
        return;
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker
    protected void handleLinkPropertiesChanged(Network r3, LinkProperties r4) {
        WifiEntry r2 = getWifiEntry();
        if (r2.getConnectedState() != 2) goto L6;
        r2.updateLinkProperties(r3, r4);
        return;
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker
    protected void handleNetworkCapabilitiesChanged(Network r1, NetworkCapabilities r2) {
        getWifiEntry().onNetworkCapabilitiesChanged(r1, r2);
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker
    protected void handleNetworkLost(Network r1) {
        getWifiEntry().onNetworkLost(r1);
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker
    protected void handleDefaultNetworkCapabilitiesChanged(Network r1, NetworkCapabilities r2) {
        getWifiEntry().onDefaultNetworkCapabilitiesChanged(r1, r2);
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker
    protected void handleDefaultNetworkLost() {
        getWifiEntry().onDefaultNetworkLost();
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker
    protected void handleConnectivityReportAvailable(ConnectivityDiagnosticsManager.ConnectivityReport r1) {
        getWifiEntry().updateConnectivityReport(r1);
    }
}
