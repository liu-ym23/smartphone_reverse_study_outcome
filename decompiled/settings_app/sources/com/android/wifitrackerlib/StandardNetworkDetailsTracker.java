package com.android.wifitrackerlib;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.telephony.SubscriptionManager;
import androidx.core.util.Preconditions;
import androidx.lifecycle.Lifecycle;
import java.time.Clock;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes2.dex */
public class StandardNetworkDetailsTracker extends NetworkDetailsTracker {
    private static final String TAG = "StandardNetworkDetailsTracker";
    private final StandardWifiEntry mChosenEntry;
    private final StandardWifiEntry.StandardWifiEntryKey mKey;

    /* JADX INFO: renamed from: $r8$lambda$VNJx-BfZ-i5neJn83Hm7x-OwKCs, reason: not valid java name */
    public static /* synthetic */ boolean m869$r8$lambda$VNJxBfZi5neJn83Hm7xOwKCs(StandardNetworkDetailsTracker r0, WifiConfiguration r1) {
        return r0.configMatches(r1);
    }

    public StandardNetworkDetailsTracker(Lifecycle r15, Context r16, WifiManager r17, ConnectivityManager r18, Handler r19, Handler r20, Clock r21, long r22, long r24, String r26) {
        this(new WifiTrackerInjector(r16), r15, r16, r17, r18, r19, r20, r21, r22, r24, r26);
    }

    StandardNetworkDetailsTracker(WifiTrackerInjector r16, Lifecycle r17, Context r18, WifiManager r19, ConnectivityManager r20, Handler r21, Handler r22, Clock r23, long r24, long r26, String r28) {
        super(r16, r17, r18, r19, r20, r21, r22, r23, r24, r26, TAG);
        StandardWifiEntry.StandardWifiEntryKey r0 = new StandardWifiEntry.StandardWifiEntryKey(r28);
        this.mKey = r0;
        if (r0.isNetworkRequest() == false) goto L5;
        this.mChosenEntry = new NetworkRequestEntry(this.mInjector, this.mMainHandler, r0, this.mWifiManager, false);
    L6:
        updateStartInfo();
        return;
    L5:
        this.mChosenEntry = new StandardWifiEntry(this.mInjector, this.mMainHandler, r0, this.mWifiManager, false);
        goto L6
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
    protected void handleWifiStateChangedAction() {
        conditionallyUpdateScanResults(true);
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker
    protected void handleScanResultsAvailableAction(Intent r3) {
        Preconditions.checkNotNull(r3, "Intent cannot be null!");
        conditionallyUpdateScanResults(r3.getBooleanExtra("resultsUpdated", true));
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker
    protected void handleConfiguredNetworksChangedAction(Intent r2) {
        Preconditions.checkNotNull(r2, "Intent cannot be null!");
        conditionallyUpdateConfig();
    }

    private void updateStartInfo() {
        this.mChosenEntry.clearConnectionInfo();
        conditionallyUpdateScanResults(true);
        conditionallyUpdateConfig();
        handleDefaultSubscriptionChanged(SubscriptionManager.getDefaultDataSubscriptionId());
        Network r0 = this.mWifiManager.getCurrentNetwork();
        if (r0 == null) goto L11;
        NetworkCapabilities r1 = this.mConnectivityManager.getNetworkCapabilities(r0);
        if (r1 == null) goto L7;
        handleNetworkCapabilitiesChanged(r0, new NetworkCapabilities.Builder(r1).setTransportInfo(this.mWifiManager.getConnectionInfo()).build());
    L7:
        LinkProperties r2 = this.mConnectivityManager.getLinkProperties(r0);
        if (r2 == null) goto L12;
        handleLinkPropertiesChanged(r0, r2);
        return;
    L12:
        return;
    }

    private void conditionallyUpdateScanResults(boolean r5) {
        if (this.mWifiManager.getWifiState() != 1) goto L6;
        this.mChosenEntry.updateScanResultInfo(Collections.emptyList());
        return;
    L6:
        long r0 = this.mMaxScanAgeMillis;
        if (r5 == false) goto L9;
        this.mScanResultUpdater.update(this.mWifiManager.getScanResults());
    L10:
        this.mChosenEntry.updateScanResultInfo((List) this.mScanResultUpdater.getScanResults(r0).stream().filter(new StandardNetworkDetailsTracker$$ExternalSyntheticLambda0(this)).collect(Collectors.toList()));
        return;
    L9:
        r0 = r0 + this.mScanIntervalMillis;
        goto L10
    }

    /* JADX INFO: renamed from: lambda$conditionallyUpdateScanResults$0$com-android-wifitrackerlib-StandardNetworkDetailsTracker, reason: not valid java name */
    /* synthetic */ boolean m870xf3698a04(ScanResult r2) {
        return new StandardWifiEntry.ScanResultKey(r2).equals(this.mKey.getScanResultKey());
    }

    private void conditionallyUpdateConfig() {
        this.mChosenEntry.updateConfig((List) this.mWifiManager.getPrivilegedConfiguredNetworks().stream().filter(new StandardNetworkDetailsTracker$$ExternalSyntheticLambda1(this)).collect(Collectors.toList()));
    }

    private boolean configMatches(WifiConfiguration r3) {
        if (r3.isPasspoint() == false) goto L7;
        return false;
    L7:
        return this.mKey.equals(new StandardWifiEntry.StandardWifiEntryKey(r3, this.mKey.isTargetingNewNetworks()));
    }
}
