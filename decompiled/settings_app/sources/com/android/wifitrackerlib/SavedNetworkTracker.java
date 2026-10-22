package com.android.wifitrackerlib;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityDiagnosticsManager;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiEnterpriseConfig;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiNetworkSuggestion;
import android.net.wifi.hotspot2.PasspointConfiguration;
import android.os.Handler;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.util.Pair;
import androidx.core.util.Preconditions;
import androidx.lifecycle.Lifecycle;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes2.dex */
public class SavedNetworkTracker extends BaseWifiTracker {
    private static final String TAG = "SavedNetworkTracker";
    private final SavedNetworkTrackerCallback mListener;
    private final Object mLock;
    private final Map<String, PasspointWifiEntry> mPasspointWifiEntryCache;
    private final List<WifiEntry> mSavedWifiEntries;
    private final List<StandardWifiEntry> mStandardWifiEntryCache;
    private final List<WifiEntry> mSubscriptionWifiEntries;

    public interface SavedNetworkTrackerCallback extends BaseWifiTracker.BaseWifiTrackerCallback {
        void onSavedWifiEntriesChanged();

        void onSubscriptionWifiEntriesChanged();
    }

    public SavedNetworkTracker(Lifecycle r15, Context r16, WifiManager r17, ConnectivityManager r18, Handler r19, Handler r20, Clock r21, long r22, long r24, SavedNetworkTrackerCallback r26) {
        this(new WifiTrackerInjector(r16), r15, r16, r17, r18, r19, r20, r21, r22, r24, r26);
    }

    SavedNetworkTracker(WifiTrackerInjector r17, Lifecycle r18, Context r19, WifiManager r20, ConnectivityManager r21, Handler r22, Handler r23, Clock r24, long r25, long r27, SavedNetworkTrackerCallback r29) {
        super(r17, r18, r19, r20, r21, r22, r23, r24, r25, r27, r29, TAG);
        this.mLock = new Object();
        this.mSavedWifiEntries = new ArrayList();
        this.mSubscriptionWifiEntries = new ArrayList();
        this.mStandardWifiEntryCache = new ArrayList();
        this.mPasspointWifiEntryCache = new ArrayMap();
        this.mListener = r29;
    }

    public List<WifiEntry> getSavedWifiEntries() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(this.mSavedWifiEntries);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public List<WifiEntry> getSubscriptionWifiEntries() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(this.mSubscriptionWifiEntries);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private static boolean hasCaCertificate(WifiEnterpriseConfig r2) {
        if (r2.getCaCertificateAliases() == null) goto L6;
        return true;
    L6:
        if (r2.getCaCertificates() == null) goto L9;
        return true;
    L9:
        if (TextUtils.isEmpty(r2.getCaPath()) == true) goto L11;
        return true;
    L11:
        return false;
    }

    private static boolean isCertificateUsedByConfiguration(WifiConfiguration r7, String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return false;
    L5:
        if (r7 != null) goto L8;
        return false;
    L8:
        if (r7.enterpriseConfig != null) goto L10;
        return false;
    L10:
        WifiEnterpriseConfig r9 = r7.enterpriseConfig;
        if (r9.isEapMethodServerCertUsed() == true) goto L14;
        return false;
    L14:
        if (hasCaCertificate(r9) == false) goto L16;
    L18:
        String[] r0 = r9.getCaCertificateAliases();
        if (r0 == null) goto L28;
        int r3 = r0.length;
        int r4 = 0;
    L21:
        if (r4 >= r3) goto L28;
        String r5 = r0[r4];
        if (TextUtils.isEmpty(r5) == true) goto L27;
        if (r8.equals(r5) == false) goto L27;
        return true;
    L27:
        r4 = r4 + 1;
    L28:
        String r10 = r9.getClientCertificateAlias();
        if (TextUtils.isEmpty(r10) == false) goto L31;
    L33:
        return false;
    L31:
        if (r8.equals(r10) == false) goto L33;
        return true;
    L16:
        if (TextUtils.isEmpty(r9.getClientCertificateAlias()) == false) goto L18;
        return false;
    }

    public boolean isCertificateRequired(final String r3) {
        List r0 = (List) this.mWifiManager.getNetworkSuggestions().stream().map(new SavedNetworkTracker$$ExternalSyntheticLambda10()).collect(Collectors.toList());
        r0.addAll(this.mWifiManager.getConfiguredNetworks());
        return r0.stream().anyMatch(new SavedNetworkTracker$$ExternalSyntheticLambda11(r3));
    }

    static /* synthetic */ WifiConfiguration lambda$isCertificateRequired$0(WifiNetworkSuggestion r0) {
        return r0.getWifiConfiguration();
    }

    static /* synthetic */ boolean lambda$isCertificateRequired$1(String r0, WifiConfiguration r1) {
        return isCertificateUsedByConfiguration(r1, r0);
    }

    public List<String> getCertificateRequesterNames(final String r3) {
        List r0 = (List) this.mWifiManager.getNetworkSuggestions().stream().map(new SavedNetworkTracker$$ExternalSyntheticLambda5()).collect(Collectors.toList());
        r0.addAll(this.mWifiManager.getConfiguredNetworks());
        return (List) ((Set) r0.stream().filter(new SavedNetworkTracker$$ExternalSyntheticLambda6(r3)).map(new SavedNetworkTracker$$ExternalSyntheticLambda7()).collect(Collectors.toSet())).stream().collect(Collectors.toList());
    }

    static /* synthetic */ WifiConfiguration lambda$getCertificateRequesterNames$2(WifiNetworkSuggestion r0) {
        return r0.getWifiConfiguration();
    }

    static /* synthetic */ boolean lambda$getCertificateRequesterNames$3(String r0, WifiConfiguration r1) {
        return isCertificateUsedByConfiguration(r1, r0);
    }

    static /* synthetic */ String lambda$getCertificateRequesterNames$4(WifiConfiguration r0) {
        return r0.SSID;
    }

    private List<WifiEntry> getAllWifiEntries() {
        ArrayList r0 = new ArrayList();
        r0.addAll(this.mStandardWifiEntryCache);
        r0.addAll(this.mPasspointWifiEntryCache.values());
        return r0;
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker
    protected void handleOnStart() {
        Iterator<WifiEntry> r0 = getAllWifiEntries().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().clearConnectionInfo();
        goto L4
    L6:
        updateStandardWifiEntryConfigs(this.mWifiManager.getConfiguredNetworks());
        updatePasspointWifiEntryConfigs(this.mWifiManager.getPasspointConfigurations());
        this.mScanResultUpdater.update(this.mWifiManager.getScanResults());
        conditionallyUpdateScanResults(true);
        Network r1 = this.mWifiManager.getCurrentNetwork();
        if (r1 == null) goto L14;
        NetworkCapabilities r2 = this.mConnectivityManager.getNetworkCapabilities(r1);
        if (r2 == null) goto L11;
        handleNetworkCapabilitiesChanged(r1, new NetworkCapabilities.Builder(r2).setTransportInfo(this.mWifiManager.getConnectionInfo()).build());
    L11:
        LinkProperties r3 = this.mConnectivityManager.getLinkProperties(r1);
        if (r3 == null) goto L14;
        handleLinkPropertiesChanged(r1, r3);
    L14:
        updateWifiEntries();
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker
    protected void handleWifiStateChangedAction() {
        conditionallyUpdateScanResults(true);
        updateWifiEntries();
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker
    protected void handleScanResultsAvailableAction(Intent r3) {
        Preconditions.checkNotNull(r3, "Intent cannot be null!");
        conditionallyUpdateScanResults(r3.getBooleanExtra("resultsUpdated", true));
        updateWifiEntries();
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker
    protected void handleConfiguredNetworksChangedAction(Intent r2) {
        Preconditions.checkNotNull(r2, "Intent cannot be null!");
        updateStandardWifiEntryConfigs(this.mWifiManager.getConfiguredNetworks());
        updatePasspointWifiEntryConfigs(this.mWifiManager.getPasspointConfigurations());
        updateWifiEntries();
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker
    protected void handleNetworkStateChangedAction(Intent r3) {
        WifiInfo r0 = this.mWifiManager.getConnectionInfo();
        NetworkInfo r4 = (NetworkInfo) r3.getParcelableExtra("networkInfo");
        if (r0 == null) goto L10;
        if (r4 == null) goto L12;
        Iterator<WifiEntry> r2 = getAllWifiEntries().iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        r2.next().onPrimaryWifiInfoChanged(r0, r4);
        goto L8
    L13:
        return;
    L12:
        return;
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker
    protected void handleLinkPropertiesChanged(Network r2, LinkProperties r3) {
        Iterator<WifiEntry> r1 = getAllWifiEntries().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().updateLinkProperties(r2, r3);
        goto L4
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker
    protected void handleNetworkCapabilitiesChanged(Network r1, NetworkCapabilities r2) {
        updateConnectionInfo(r1, r2);
        updateWifiEntries();
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker
    protected void handleNetworkLost(Network r3) {
        Iterator<WifiEntry> r0 = getAllWifiEntries().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onNetworkLost(r3);
        goto L4
    L6:
        updateWifiEntries();
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker
    protected void handleConnectivityReportAvailable(ConnectivityDiagnosticsManager.ConnectivityReport r2) {
        Iterator<WifiEntry> r1 = getAllWifiEntries().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().updateConnectivityReport(r2);
        goto L4
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker
    protected void handleDefaultNetworkCapabilitiesChanged(Network r2, NetworkCapabilities r3) {
        Iterator<WifiEntry> r1 = getAllWifiEntries().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onDefaultNetworkCapabilitiesChanged(r2, r3);
        goto L4
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker
    protected void handleDefaultNetworkLost() {
        Iterator<WifiEntry> r1 = getAllWifiEntries().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onDefaultNetworkLost();
        goto L4
    }

    private void updateWifiEntries() {
        Object r2 = this.mLock;
        monitor-enter(r2);
        this.mSavedWifiEntries.clear();     // Catch: Throwable -> L10
        this.mSavedWifiEntries.addAll(this.mStandardWifiEntryCache);     // Catch: Throwable -> L10
        Collections.sort(this.mSavedWifiEntries, WifiEntry.TITLE_COMPARATOR);     // Catch: Throwable -> L10
        this.mSubscriptionWifiEntries.clear();     // Catch: Throwable -> L10
        this.mSubscriptionWifiEntries.addAll(this.mPasspointWifiEntryCache.values());     // Catch: Throwable -> L10
        Collections.sort(this.mSubscriptionWifiEntries, WifiEntry.TITLE_COMPARATOR);     // Catch: Throwable -> L10
        if (isVerboseLoggingEnabled() == false) goto L7;
        Log.v(TAG, "Updated SavedWifiEntries: " + Arrays.toString(this.mSavedWifiEntries.toArray()));     // Catch: Throwable -> L10
        Log.v(TAG, "Updated SubscriptionWifiEntries: " + Arrays.toString(this.mSubscriptionWifiEntries.toArray()));     // Catch: Throwable -> L10
    L7:
        monitor-exit(r2);     // Catch: Throwable -> L10
        notifyOnSavedWifiEntriesChanged();
        notifyOnSubscriptionWifiEntriesChanged();
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void updateStandardWifiEntryScans(List<ScanResult> r2) {
        Preconditions.checkNotNull(r2, "Scan Result list should not be null!");
        final Map r3 = (Map) r2.stream().collect(Collectors.groupingBy(new SavedNetworkTracker$$ExternalSyntheticLambda8()));
        this.mStandardWifiEntryCache.forEach(new SavedNetworkTracker$$ExternalSyntheticLambda9(r3));
    }

    static /* synthetic */ void lambda$updateStandardWifiEntryScans$5(Map r1, StandardWifiEntry r2) {
        r2.updateScanResultInfo((List) r1.get(r2.getStandardWifiEntryKey().getScanResultKey()));
    }

    private void updatePasspointWifiEntryScans(List<ScanResult> r7) {
        Preconditions.checkNotNull(r7, "Scan Result list should not be null!");
        TreeSet r0 = new TreeSet();
        Iterator r8 = this.mWifiManager.getAllMatchingWifiConfigs(r7).iterator();
    L4:
        if (r8.hasNext() == false) goto L9;
        Pair r1 = (Pair) r8.next();
        WifiConfiguration r2 = (WifiConfiguration) r1.first;
        String r3 = PasspointWifiEntry.uniqueIdToPasspointWifiEntryKey(r2.getKey());
        r0.add(r3);
        if (this.mPasspointWifiEntryCache.containsKey(r3) == false) goto L4;
        this.mPasspointWifiEntryCache.get(r3).updateScanResultInfo(r2, (List) ((Map) r1.second).get(0), (List) ((Map) r1.second).get(1));
        goto L4
    L9:
        Iterator<PasspointWifiEntry> r6 = this.mPasspointWifiEntryCache.values().iterator();
    L11:
        if (r6.hasNext() == false) goto L15;
        PasspointWifiEntry r9 = r6.next();
        if (r0.contains(r9.getKey()) == true) goto L11;
        r9.updateScanResultInfo(null, null, null);
        goto L11
    }

    private void conditionallyUpdateScanResults(boolean r5) {
        if (this.mWifiManager.getWifiState() != 1) goto L6;
        updateStandardWifiEntryScans(Collections.emptyList());
        updatePasspointWifiEntryScans(Collections.emptyList());
        return;
    L6:
        long r0 = this.mMaxScanAgeMillis;
        if (r5 == false) goto L9;
        this.mScanResultUpdater.update(this.mWifiManager.getScanResults());
    L10:
        updateStandardWifiEntryScans(this.mScanResultUpdater.getScanResults(r0));
        updatePasspointWifiEntryScans(this.mScanResultUpdater.getScanResults(r0));
        return;
    L9:
        r0 = r0 + this.mScanIntervalMillis;
        goto L10
    }

    private void updateStandardWifiEntryConfigs(List<WifiConfiguration> r12) {
        Preconditions.checkNotNull(r12, "Config list should not be null!");
        final Map r13 = (Map) r12.stream().filter(new SavedNetworkTracker$$ExternalSyntheticLambda2()).collect(Collectors.groupingBy(new SavedNetworkTracker$$ExternalSyntheticLambda3()));
        this.mStandardWifiEntryCache.removeIf(new SavedNetworkTracker$$ExternalSyntheticLambda4(r13));
        Iterator r0 = r13.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        StandardWifiEntry.StandardWifiEntryKey r5 = (StandardWifiEntry.StandardWifiEntryKey) r0.next();
        this.mStandardWifiEntryCache.add(new StandardWifiEntry(this.mInjector, this.mMainHandler, r5, (List) r13.get(r5), null, this.mWifiManager, true));
        goto L4
    }

    static /* synthetic */ boolean lambda$updateStandardWifiEntryConfigs$6(WifiConfiguration r0) {
        return !r0.carrierMerged;
    }

    static /* synthetic */ boolean lambda$updateStandardWifiEntryConfigs$7(Map r1, StandardWifiEntry r2) {
        r2.updateConfig((List) r1.remove(r2.getStandardWifiEntryKey()));
        return !r2.isSaved();
    }

    private void updatePasspointWifiEntryConfigs(List<PasspointConfiguration> r11) {
        Preconditions.checkNotNull(r11, "Config list should not be null!");
        final Map r12 = (Map) r11.stream().collect(Collectors.toMap(new SavedNetworkTracker$$ExternalSyntheticLambda13(), Function.identity()));
        this.mPasspointWifiEntryCache.entrySet().removeIf(new SavedNetworkTracker$$ExternalSyntheticLambda1(r12));
        Iterator r0 = r12.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String r1 = (String) r0.next();
        this.mPasspointWifiEntryCache.put(r1, new PasspointWifiEntry(this.mInjector, this.mMainHandler, (PasspointConfiguration) r12.get(r1), this.mWifiManager, true));
        goto L4
    }

    static /* synthetic */ String lambda$updatePasspointWifiEntryConfigs$8(PasspointConfiguration r0) {
        return PasspointWifiEntry.uniqueIdToPasspointWifiEntryKey(r0.getUniqueId());
    }

    static /* synthetic */ boolean lambda$updatePasspointWifiEntryConfigs$9(Map r1, Map.Entry r2) {
        PasspointWifiEntry r3 = (PasspointWifiEntry) r2.getValue();
        PasspointConfiguration r4 = (PasspointConfiguration) r1.remove(r3.getKey());
        if (r4 == null) goto L6;
        r3.updatePasspointConfig(r4);
        return false;
    L6:
        return true;
    }

    private void updateConnectionInfo(Network r2, NetworkCapabilities r3) {
        Iterator<WifiEntry> r1 = getAllWifiEntries().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onNetworkCapabilitiesChanged(r2, r3);
        goto L4
    }

    private void notifyOnSavedWifiEntriesChanged() {
        if (this.mListener == null) goto L6;
        Handler r0 = this.mMainHandler;
        final SavedNetworkTrackerCallback r2 = this.mListener;
        Objects.requireNonNull(r2);
        r0.post(new SavedNetworkTracker$$ExternalSyntheticLambda0(r2));
        return;
    }

    private void notifyOnSubscriptionWifiEntriesChanged() {
        if (this.mListener == null) goto L6;
        Handler r0 = this.mMainHandler;
        final SavedNetworkTrackerCallback r2 = this.mListener;
        Objects.requireNonNull(r2);
        r0.post(new SavedNetworkTracker$$ExternalSyntheticLambda12(r2));
        return;
    }
}
