package com.android.wifitrackerlib;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.wifi.WifiManager;
import android.net.wifi.sharedconnectivity.app.HotspotNetwork;
import android.os.Handler;
import android.telephony.SubscriptionManager;
import android.util.Log;
import androidx.lifecycle.Lifecycle;
import java.time.Clock;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class HotspotNetworkDetailsTracker extends NetworkDetailsTracker {
    private static final String TAG = "HotspotNetworkDetailsTracker";
    private final HotspotNetworkEntry mChosenEntry;
    private HotspotNetwork mHotspotNetworkData;

    public HotspotNetworkDetailsTracker(Lifecycle r15, Context r16, WifiManager r17, ConnectivityManager r18, Handler r19, Handler r20, Clock r21, long r22, long r24, String r26) {
        this(new WifiTrackerInjector(r16), r15, r16, r17, r18, r19, r20, r21, r22, r24, r26);
    }

    HotspotNetworkDetailsTracker(WifiTrackerInjector r17, Lifecycle r18, Context r19, WifiManager r20, ConnectivityManager r21, Handler r22, Handler r23, Clock r24, long r25, long r27, String r29) {
        super(r17, r18, r19, r20, r21, r22, r23, r24, r25, r27, TAG);
        Log.v(TAG, "key: " + r29);
        HotspotNetworkEntry.HotspotNetworkEntryKey r0 = new HotspotNetworkEntry.HotspotNetworkEntryKey(r29);
        if (r0.isVirtualEntry() == false) goto L5;
        Log.e(TAG, "Network details not relevant for virtual entry");
    L5:
        HotspotNetworkEntry r2 = new HotspotNetworkEntry(this.mInjector, this.mContext, this.mMainHandler, this.mWifiManager, this.mSharedConnectivityManager, r0);
        this.mChosenEntry = r2;
        updateStartInfo();
        Log.v(TAG, "mChosenEntry: " + r2);
    }

    @Override // com.android.wifitrackerlib.NetworkDetailsTracker
    public WifiEntry getWifiEntry() {
        return this.mChosenEntry;
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker
    protected void handleOnStart() {
        updateStartInfo();
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker
    protected void handleServiceConnected() {
        if (this.mInjector.isSharedConnectivityFeatureEnabled() == true) goto L5;
    L9:
        HotspotNetwork r0 = this.mHotspotNetworkData;
        if (r0 == null) goto L14;
        this.mChosenEntry.updateHotspotNetworkData(r0);
        return;
    L14:
        throw new IllegalArgumentException("Cannot find data for given HotspotNetworkEntry key!");
    L5:
        if (this.mSharedConnectivityManager == null) goto L9;
        List r1 = this.mSharedConnectivityManager.getHotspotNetworks();
        if (r1 == null) goto L9;
        this.mHotspotNetworkData = (HotspotNetwork) r1.stream().filter(new HotspotNetworkDetailsTracker$$ExternalSyntheticLambda1(this)).findFirst().orElse(null);
        goto L9
    }

    /* JADX INFO: renamed from: lambda$handleServiceConnected$0$com-android-wifitrackerlib-HotspotNetworkDetailsTracker, reason: not valid java name */
    /* synthetic */ boolean m859x9fae4757(HotspotNetwork r3) {
        if (r3.getDeviceId() != this.mChosenEntry.getHotspotNetworkEntryKey().getDeviceId()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker
    protected void handleHotspotNetworksUpdated(List<HotspotNetwork> r2) {
        if (this.mInjector.isSharedConnectivityFeatureEnabled() == false) goto L5;
        this.mHotspotNetworkData = r2.stream().filter(new HotspotNetworkDetailsTracker$$ExternalSyntheticLambda0(this)).findFirst().orElse(null);
    L5:
        HotspotNetwork r3 = this.mHotspotNetworkData;
        if (r3 == null) goto L10;
        this.mChosenEntry.updateHotspotNetworkData(r3);
        return;
    L10:
        throw new IllegalArgumentException("Cannot find data for given HotspotNetworkEntry key!");
    }

    /* JADX INFO: renamed from: lambda$handleHotspotNetworksUpdated$1$com-android-wifitrackerlib-HotspotNetworkDetailsTracker, reason: not valid java name */
    /* synthetic */ boolean m858x1ce5612b(HotspotNetwork r3) {
        if (r3.getDeviceId() != this.mChosenEntry.getHotspotNetworkEntryKey().getDeviceId()) goto L5;
        return true;
    L5:
        return false;
    }

    private void updateStartInfo() {
        handleDefaultSubscriptionChanged(SubscriptionManager.getDefaultDataSubscriptionId());
        Network r0 = this.mWifiManager.getCurrentNetwork();
        if (r0 != null) goto L5;
        return;
    L5:
        NetworkCapabilities r1 = this.mConnectivityManager.getNetworkCapabilities(r0);
        if (r1 == null) goto L8;
        handleNetworkCapabilitiesChanged(r0, new NetworkCapabilities.Builder(r1).setTransportInfo(this.mWifiManager.getConnectionInfo()).build());
    L8:
        LinkProperties r2 = this.mConnectivityManager.getLinkProperties(r0);
        if (r2 == null) goto L12;
        handleLinkPropertiesChanged(r0, r2);
        return;
    }
}
