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
import android.net.wifi.hotspot2.OsuProvider;
import android.net.wifi.hotspot2.PasspointConfiguration;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.util.Preconditions;
import androidx.lifecycle.Lifecycle;
import java.time.Clock;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/* JADX INFO: loaded from: classes2.dex */
public class PasspointNetworkDetailsTracker extends NetworkDetailsTracker {
    private static final String TAG = "PasspointNetworkDetailsTracker";
    private final PasspointWifiEntry mChosenEntry;
    private WifiConfiguration mCurrentWifiConfig;
    private OsuWifiEntry mOsuWifiEntry;

    public PasspointNetworkDetailsTracker(Lifecycle r15, Context r16, WifiManager r17, ConnectivityManager r18, Handler r19, Handler r20, Clock r21, long r22, long r24, String r26) {
        this(new WifiTrackerInjector(r16), r15, r16, r17, r18, r19, r20, r21, r22, r24, r26);
    }

    PasspointNetworkDetailsTracker(WifiTrackerInjector r17, Lifecycle r18, Context r19, WifiManager r20, ConnectivityManager r21, Handler r22, Handler r23, Clock r24, long r25, long r27, final String r29) {
        super(r17, r18, r19, r20, r21, r22, r23, r24, r25, r27, TAG);
        Optional<PasspointConfiguration> r0 = this.mWifiManager.getPasspointConfigurations().stream().filter(new PasspointNetworkDetailsTracker$$ExternalSyntheticLambda0(r29)).findAny();
        if (r0.isPresent() == false) goto L5;
        this.mChosenEntry = new PasspointWifiEntry(this.mInjector, this.mMainHandler, r0.get(), this.mWifiManager, false);
    L8:
        updateStartInfo();
        return;
    L5:
        Optional r1 = this.mWifiManager.getPrivilegedConfiguredNetworks().stream().filter(new PasspointNetworkDetailsTracker$$ExternalSyntheticLambda1(r29)).findAny();
        if (r1.isPresent() == false) goto L11;
        this.mChosenEntry = new PasspointWifiEntry(this.mInjector, this.mContext, this.mMainHandler, (WifiConfiguration) r1.get(), this.mWifiManager, false);
        goto L8
    L11:
        throw new IllegalArgumentException("Cannot find config for given PasspointWifiEntry key!");
    }

    static /* synthetic */ boolean lambda$new$0(String r0, PasspointConfiguration r1) {
        return TextUtils.equals(r0, PasspointWifiEntry.uniqueIdToPasspointWifiEntryKey(r1.getUniqueId()));
    }

    static /* synthetic */ boolean lambda$new$1(String r1, WifiConfiguration r2) {
        if (r2.isPasspoint() == true) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals(r1, PasspointWifiEntry.uniqueIdToPasspointWifiEntryKey(r2.getKey())) == false) goto L7;
        return true;
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

    private void updatePasspointWifiEntryScans(List<ScanResult> r5) {
        Preconditions.checkNotNull(r5, "Scan Result list should not be null!");
        Iterator r6 = this.mWifiManager.getAllMatchingWifiConfigs(r5).iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        Pair r0 = (Pair) r6.next();
        WifiConfiguration r1 = (WifiConfiguration) r0.first;
        if (TextUtils.equals(PasspointWifiEntry.uniqueIdToPasspointWifiEntryKey(r1.getKey()), this.mChosenEntry.getKey()) == false) goto L4;
        this.mCurrentWifiConfig = r1;
        this.mChosenEntry.updateScanResultInfo(r1, (List) ((Map) r0.second).get(0), (List) ((Map) r0.second).get(1));
        return;
    L9:
        this.mChosenEntry.updateScanResultInfo(this.mCurrentWifiConfig, null, null);
    }

    private void updateOsuWifiEntryScans(List<ScanResult> r10) {
        Preconditions.checkNotNull(r10, "Scan Result list should not be null!");
        Map r11 = this.mWifiManager.getMatchingOsuProviders(r10);
        Map r0 = this.mWifiManager.getMatchingPasspointConfigsForOsuProviders(r11.keySet());
        OsuWifiEntry r1 = this.mOsuWifiEntry;
        if (r1 == null) goto L5;
        r1.updateScanResultInfo((List) r11.get(r1.getOsuProvider()));
    L14:
        OsuWifiEntry r12 = this.mOsuWifiEntry;
        if (r12 != null) goto L17;
        return;
    L17:
        if (r12.getLevel() != (-1)) goto L27;
        this.mChosenEntry.setOsuWifiEntry(null);
        this.mOsuWifiEntry = null;
        return;
    L27:
        return;
    L5:
        Iterator r2 = r11.keySet().iterator();
    L7:
        if (r2.hasNext() == false) goto L14;
        OsuProvider r3 = (OsuProvider) r2.next();
        PasspointConfiguration r4 = (PasspointConfiguration) r0.get(r3);
        if (r4 == null) goto L7;
        if (TextUtils.equals(this.mChosenEntry.getKey(), PasspointWifiEntry.uniqueIdToPasspointWifiEntryKey(r4.getUniqueId())) == false) goto L7;
        OsuWifiEntry r5 = new OsuWifiEntry(this.mInjector, this.mMainHandler, r3, this.mWifiManager, false);
        this.mOsuWifiEntry = r5;
        r5.updateScanResultInfo((List) r11.get(r3));
        this.mOsuWifiEntry.setAlreadyProvisioned(true);
        this.mChosenEntry.setOsuWifiEntry(this.mOsuWifiEntry);
    }

    private void conditionallyUpdateScanResults(boolean r5) {
        if (this.mWifiManager.getWifiState() != 1) goto L6;
        this.mChosenEntry.updateScanResultInfo(this.mCurrentWifiConfig, null, null);
        return;
    L6:
        long r0 = this.mMaxScanAgeMillis;
        if (r5 == false) goto L9;
        cacheNewScanResults();
    L10:
        List<ScanResult> r6 = this.mScanResultUpdater.getScanResults(r0);
        updatePasspointWifiEntryScans(r6);
        updateOsuWifiEntryScans(r6);
        return;
    L9:
        r0 = r0 + this.mScanIntervalMillis;
        goto L10
    }

    private void conditionallyUpdateConfig() {
        this.mWifiManager.getPasspointConfigurations().stream().filter(new PasspointNetworkDetailsTracker$$ExternalSyntheticLambda2(this)).findAny().ifPresent(new PasspointNetworkDetailsTracker$$ExternalSyntheticLambda3(this));
    }

    /* JADX INFO: renamed from: lambda$conditionallyUpdateConfig$2$com-android-wifitrackerlib-PasspointNetworkDetailsTracker, reason: not valid java name */
    /* synthetic */ boolean m865x38068e71(PasspointConfiguration r1) {
        return TextUtils.equals(PasspointWifiEntry.uniqueIdToPasspointWifiEntryKey(r1.getUniqueId()), this.mChosenEntry.getKey());
    }

    /* JADX INFO: renamed from: lambda$conditionallyUpdateConfig$3$com-android-wifitrackerlib-PasspointNetworkDetailsTracker, reason: not valid java name */
    /* synthetic */ void m866x48bc5b32(PasspointConfiguration r1) {
        this.mChosenEntry.updatePasspointConfig(r1);
    }

    private void cacheNewScanResults() {
        this.mScanResultUpdater.update(this.mWifiManager.getScanResults());
    }
}
