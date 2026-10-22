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
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.hotspot2.OsuProvider;
import android.net.wifi.hotspot2.PasspointConfiguration;
import android.net.wifi.sharedconnectivity.app.HotspotNetwork;
import android.net.wifi.sharedconnectivity.app.HotspotNetworkConnectionStatus;
import android.net.wifi.sharedconnectivity.app.KnownNetwork;
import android.net.wifi.sharedconnectivity.app.KnownNetworkConnectionStatus;
import android.os.Handler;
import android.telephony.SubscriptionManager;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import androidx.core.os.BuildCompat;
import androidx.core.util.Preconditions;
import androidx.lifecycle.Lifecycle;
import com.android.settings.dashboard.DashboardFragment$$ExternalSyntheticLambda12;
import com.bytedance.librarian.LibrarianImpl;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes2.dex */
public class WifiPickerTracker extends BaseWifiTracker {
    private static final String EXTRA_KEY_CONNECTION_STATUS_CONNECTED = "connection_status_connected";
    private static final String TAG = "WifiPickerTracker";
    public static final int WIFI_ENTRIES_CHANGED_REASON_GENERAL = 0;
    public static final int WIFI_ENTRIES_CHANGED_REASON_SCAN_RESULTS = 1;
    private List<WifiEntry> mActiveWifiEntries;
    private WifiEntry mConnectedWifiEntry;
    private final List<HotspotNetwork> mHotspotNetworkDataCache;
    private final List<HotspotNetworkEntry> mHotspotNetworkEntryCache;
    private final List<KnownNetwork> mKnownNetworkDataCache;
    private final List<KnownNetworkEntry> mKnownNetworkEntryCache;
    private final WifiPickerTrackerCallback mListener;
    private MergedCarrierEntry mMergedCarrierEntry;
    private final ArrayMap<StandardWifiEntry.StandardWifiEntryKey, List<WifiConfiguration>> mNetworkRequestConfigCache;
    private NetworkRequestEntry mNetworkRequestEntry;
    private int mNumSavedNetworks;
    private final Map<String, OsuWifiEntry> mOsuWifiEntryCache;
    private final Map<String, PasspointConfiguration> mPasspointConfigCache;
    private final SparseArray<WifiConfiguration> mPasspointWifiConfigCache;
    private final Map<String, PasspointWifiEntry> mPasspointWifiEntryCache;
    private final Map<StandardWifiEntry.StandardWifiEntryKey, List<WifiConfiguration>> mStandardWifiConfigCache;
    private final List<StandardWifiEntry> mStandardWifiEntryCache;
    private final Map<StandardWifiEntry.StandardWifiEntryKey, List<WifiConfiguration>> mSuggestedConfigCache;
    private final List<StandardWifiEntry> mSuggestedWifiEntryCache;
    private List<WifiEntry> mWifiEntries;

    @Retention(RetentionPolicy.SOURCE)
    public @interface WifiEntriesChangedReason {
    }

    public interface WifiPickerTrackerCallback extends BaseWifiTracker.BaseWifiTrackerCallback {
        void onNumSavedNetworksChanged();

        void onNumSavedSubscriptionsChanged();

        default void onWifiEntriesChanged() {
        }

        default void onWifiEntriesChanged(int r1) {
            onWifiEntriesChanged();
        }
    }

    public static /* synthetic */ long $r8$lambda$tjzx37IQB1pKlxJUBN2hWQSehyU(HotspotNetwork r2) {
        return r2.getDeviceId();
    }

    static /* synthetic */ HotspotNetwork lambda$updateHotspotNetworkEntries$30(HotspotNetwork r0) {
        return r0;
    }

    static /* synthetic */ KnownNetwork lambda$updateKnownNetworkEntryScans$25(KnownNetwork r0) {
        return r0;
    }

    protected void updateContextualWifiEntryScans(List<ScanResult> r1) {
    }

    public WifiPickerTracker(Lifecycle r15, Context r16, WifiManager r17, ConnectivityManager r18, Handler r19, Handler r20, Clock r21, long r22, long r24, WifiPickerTrackerCallback r26) {
        this(new WifiTrackerInjector(r16), r15, r16, r17, r18, r19, r20, r21, r22, r24, r26);
    }

    WifiPickerTracker(WifiTrackerInjector r17, Lifecycle r18, Context r19, WifiManager r20, ConnectivityManager r21, Handler r22, Handler r23, Clock r24, long r25, long r27, WifiPickerTrackerCallback r29) {
        super(r17, r18, r19, r20, r21, r22, r23, r24, r25, r27, r29, TAG);
        this.mActiveWifiEntries = new ArrayList();
        this.mWifiEntries = new ArrayList();
        this.mStandardWifiConfigCache = new ArrayMap();
        this.mSuggestedConfigCache = new ArrayMap();
        this.mNetworkRequestConfigCache = new ArrayMap();
        this.mStandardWifiEntryCache = new ArrayList();
        this.mSuggestedWifiEntryCache = new ArrayList();
        this.mPasspointConfigCache = new ArrayMap();
        this.mPasspointWifiConfigCache = new SparseArray();
        this.mPasspointWifiEntryCache = new ArrayMap();
        this.mOsuWifiEntryCache = new ArrayMap();
        this.mKnownNetworkDataCache = new ArrayList();
        this.mKnownNetworkEntryCache = new ArrayList();
        this.mHotspotNetworkDataCache = new ArrayList();
        this.mHotspotNetworkEntryCache = new ArrayList();
        this.mListener = r29;
    }

    public WifiEntry getConnectedWifiEntry() {
        return this.mConnectedWifiEntry;
    }

    public List<WifiEntry> getActiveWifiEntries() {
        return new ArrayList(this.mActiveWifiEntries);
    }

    public List<WifiEntry> getWifiEntries() {
        return new ArrayList(this.mWifiEntries);
    }

    public MergedCarrierEntry getMergedCarrierEntry() {
        if (isInitialized() == true) goto L10;
        if (this.mMergedCarrierEntry != null) goto L10;
        int r6 = SubscriptionManager.getDefaultDataSubscriptionId();
        if (r6 == (-1)) goto L10;
        this.mMergedCarrierEntry = new MergedCarrierEntry(this.mInjector, this.mWorkerHandler, this.mWifiManager, false, r6);
    L10:
        return this.mMergedCarrierEntry;
    }

    public int getNumSavedNetworks() {
        return this.mNumSavedNetworks;
    }

    public int getNumSavedSubscriptions() {
        return this.mPasspointConfigCache.size();
    }

    private List<WifiEntry> getAllWifiEntries() {
        ArrayList r0 = new ArrayList();
        r0.addAll(this.mStandardWifiEntryCache);
        r0.addAll(this.mSuggestedWifiEntryCache);
        r0.addAll(this.mPasspointWifiEntryCache.values());
        r0.addAll(this.mOsuWifiEntryCache.values());
        if (this.mInjector.isSharedConnectivityFeatureEnabled() == false) goto L5;
        r0.addAll(this.mKnownNetworkEntryCache);
        r0.addAll(this.mHotspotNetworkEntryCache);
    L5:
        NetworkRequestEntry r1 = this.mNetworkRequestEntry;
        if (r1 == null) goto L8;
        r0.add(r1);
    L8:
        MergedCarrierEntry r2 = this.mMergedCarrierEntry;
        if (r2 == null) goto L11;
        r0.add(r2);
    L11:
        return r0;
    }

    private void clearAllWifiEntries() {
        this.mStandardWifiEntryCache.clear();
        this.mSuggestedWifiEntryCache.clear();
        this.mPasspointWifiEntryCache.clear();
        this.mOsuWifiEntryCache.clear();
        if (this.mInjector.isSharedConnectivityFeatureEnabled() == false) goto L5;
        this.mKnownNetworkEntryCache.clear();
        this.mHotspotNetworkEntryCache.clear();
    L5:
        this.mNetworkRequestEntry = null;
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker
    protected void handleOnStart() {
        Iterator<WifiEntry> r0 = getAllWifiEntries().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().clearConnectionInfo();
        goto L4
    L6:
        updateWifiConfigurations(this.mWifiManager.getPrivilegedConfiguredNetworks());
        updatePasspointConfigurations(this.mWifiManager.getPasspointConfigurations());
        this.mScanResultUpdater.update(this.mWifiManager.getScanResults());
        conditionallyUpdateScanResults(true);
        handleDefaultSubscriptionChanged(SubscriptionManager.getDefaultDataSubscriptionId());
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
        notifyOnNumSavedNetworksChanged();
        notifyOnNumSavedSubscriptionsChanged();
        updateWifiEntries();
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker
    protected void handleWifiStateChangedAction() {
        if (getWifiState() != 1) goto L5;
        clearAllWifiEntries();
    L5:
        updateWifiEntries();
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker
    protected void handleScanResultsAvailableAction(Intent r3) {
        Preconditions.checkNotNull(r3, "Intent cannot be null!");
        conditionallyUpdateScanResults(r3.getBooleanExtra("resultsUpdated", true));
        updateWifiEntries(1);
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker
    protected void handleConfiguredNetworksChangedAction(Intent r2) {
        Preconditions.checkNotNull(r2, "Intent cannot be null!");
        processConfiguredNetworksChanged();
    }

    protected void processConfiguredNetworksChanged() {
        updateWifiConfigurations(this.mWifiManager.getPrivilegedConfiguredNetworks());
        updatePasspointConfigurations(this.mWifiManager.getPasspointConfigurations());
        conditionallyUpdateScanResults(false);
        notifyOnNumSavedNetworksChanged();
        notifyOnNumSavedSubscriptionsChanged();
        updateWifiEntries();
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker
    protected void handleNetworkStateChangedAction(Intent r4) {
        WifiInfo r0 = this.mWifiManager.getConnectionInfo();
        NetworkInfo r5 = (NetworkInfo) r4.getParcelableExtra("networkInfo");
        if (r0 == null) goto L5;
        conditionallyCreateConnectedWifiEntry(r0);
    L5:
        Iterator<WifiEntry> r1 = getAllWifiEntries().iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        r1.next().onPrimaryWifiInfoChanged(r0, r5);
        goto L7
    L9:
        updateWifiEntries();
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker
    protected void handleRssiChangedAction(Intent r3) {
        WifiInfo r4 = this.mWifiManager.getConnectionInfo();
        Iterator<WifiEntry> r2 = getAllWifiEntries().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r2.next().onPrimaryWifiInfoChanged(r4, null);
        goto L4
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
        updateNetworkCapabilities(r1, r2);
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
        NetworkRequestEntry r4 = this.mNetworkRequestEntry;
        if (r4 != null) goto L9;
    L11:
        updateWifiEntries();
        return;
    L9:
        if (r4.getConnectedState() != 0) goto L11;
        this.mNetworkRequestEntry = null;
        goto L11
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
    protected void handleDefaultNetworkCapabilitiesChanged(Network r3, NetworkCapabilities r4) {
        Iterator<WifiEntry> r0 = getAllWifiEntries().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onDefaultNetworkCapabilitiesChanged(r3, r4);
        goto L4
    L6:
        notifyOnWifiEntriesChanged(0);
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker
    protected void handleDefaultNetworkLost() {
        Iterator<WifiEntry> r0 = getAllWifiEntries().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onDefaultNetworkLost();
        goto L4
    L6:
        notifyOnWifiEntriesChanged(0);
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker
    protected void handleDefaultSubscriptionChanged(int r1) {
        updateMergedCarrierEntry(r1);
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker
    protected void handleKnownNetworksUpdated(List<KnownNetwork> r2) {
        if (this.mInjector.isSharedConnectivityFeatureEnabled() == false) goto L6;
        this.mKnownNetworkDataCache.clear();
        this.mKnownNetworkDataCache.addAll(r2);
        updateKnownNetworkEntryScans(this.mScanResultUpdater.getScanResults());
        updateWifiEntries();
        return;
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker
    protected void handleHotspotNetworksUpdated(List<HotspotNetwork> r2) {
        if (this.mInjector.isSharedConnectivityFeatureEnabled() == false) goto L6;
        this.mHotspotNetworkDataCache.clear();
        this.mHotspotNetworkDataCache.addAll(r2);
        updateHotspotNetworkEntries();
        updateWifiEntries();
        return;
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker
    protected void handleHotspotNetworkConnectionStatusChanged(final HotspotNetworkConnectionStatus r2) {
        this.mHotspotNetworkEntryCache.stream().filter(new WifiPickerTracker$$ExternalSyntheticLambda3(r2)).forEach(new WifiPickerTracker$$ExternalSyntheticLambda4(r2));
    }

    static /* synthetic */ boolean lambda$handleHotspotNetworkConnectionStatusChanged$0(HotspotNetworkConnectionStatus r2, HotspotNetworkEntry r3) {
        if (r3.getHotspotNetworkEntryKey().getDeviceId() != r2.getHotspotNetwork().getDeviceId()) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ void lambda$handleHotspotNetworkConnectionStatusChanged$1(HotspotNetworkConnectionStatus r3, HotspotNetworkEntry r4) {
        if (r3.getExtras().getBoolean(EXTRA_KEY_CONNECTION_STATUS_CONNECTED, false) == false) goto L5;
        r4.onConnectionStatusChanged(10);
        return;
    L5:
        r4.onConnectionStatusChanged(r3.getStatus());
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker
    protected void handleKnownNetworkConnectionStatusChanged(final KnownNetworkConnectionStatus r5) {
        final StandardWifiEntry.ScanResultKey r0 = new StandardWifiEntry.ScanResultKey(r5.getKnownNetwork().getSsid(), new ArrayList(r5.getKnownNetwork().getSecurityTypes()));
        this.mKnownNetworkEntryCache.stream().filter(new WifiPickerTracker$$ExternalSyntheticLambda35(r0)).forEach(new WifiPickerTracker$$ExternalSyntheticLambda36(r5));
    }

    static /* synthetic */ boolean lambda$handleKnownNetworkConnectionStatusChanged$2(StandardWifiEntry.ScanResultKey r0, KnownNetworkEntry r1) {
        return r1.getStandardWifiEntryKey().getScanResultKey().equals(r0);
    }

    static /* synthetic */ void lambda$handleKnownNetworkConnectionStatusChanged$3(KnownNetworkConnectionStatus r0, KnownNetworkEntry r1) {
        r1.onConnectionStatusChanged(r0.getStatus());
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker
    protected void handleServiceConnected() {
        if (this.mInjector.isSharedConnectivityFeatureEnabled() == false) goto L15;
        this.mKnownNetworkDataCache.clear();
        List r0 = this.mSharedConnectivityManager.getKnownNetworks();
        if (r0 == null) goto L7;
        this.mKnownNetworkDataCache.addAll(r0);
    L7:
        this.mHotspotNetworkDataCache.clear();
        List r1 = this.mSharedConnectivityManager.getHotspotNetworks();
        if (r1 == null) goto L10;
        this.mHotspotNetworkDataCache.addAll(r1);
    L10:
        updateKnownNetworkEntryScans(this.mScanResultUpdater.getScanResults());
        updateHotspotNetworkEntries();
        HotspotNetworkConnectionStatus r2 = this.mSharedConnectivityManager.getHotspotNetworkConnectionStatus();
        if (r2 == null) goto L13;
        handleHotspotNetworkConnectionStatusChanged(r2);
    L13:
        updateWifiEntries();
        return;
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker
    protected void handleServiceDisconnected() {
        if (this.mInjector.isSharedConnectivityFeatureEnabled() == false) goto L6;
        this.mKnownNetworkDataCache.clear();
        this.mHotspotNetworkDataCache.clear();
        this.mKnownNetworkEntryCache.clear();
        this.mHotspotNetworkEntryCache.clear();
        updateWifiEntries();
        return;
    }

    protected void updateWifiEntries(int r14) {
        final ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        r0.addAll(this.mStandardWifiEntryCache);
        r0.addAll(this.mSuggestedWifiEntryCache);
        r0.addAll(this.mPasspointWifiEntryCache.values());
        if (this.mInjector.isSharedConnectivityFeatureEnabled() == false) goto L5;
        r0.addAll(this.mHotspotNetworkEntryCache);
    L5:
        NetworkRequestEntry r2 = this.mNetworkRequestEntry;
        if (r2 == null) goto L8;
        r0.add(r2);
    L8:
        r0.removeIf(new WifiPickerTracker$$ExternalSyntheticLambda11());
        final ArraySet r3 = new ArraySet();
        Iterator r4 = r0.iterator();
    L10:
        if (r4.hasNext() == false) goto L14;
        WifiEntry r5 = (WifiEntry) r4.next();
        if ((r5 instanceof HotspotNetworkEntry) == false) goto L10;
        r3.add(((HotspotNetworkEntry) r5).getHotspotNetworkEntryKey().getScanResultKey());
        goto L10
    L14:
        r0.removeIf(new WifiPickerTracker$$ExternalSyntheticLambda12(r3));
        r0.sort(WifiEntry.WIFI_PICKER_COMPARATOR);
        Set r6 = (Set) this.mSuggestedWifiEntryCache.stream().filter(new WifiPickerTracker$$ExternalSyntheticLambda13(r0)).map(new WifiPickerTracker$$ExternalSyntheticLambda14()).collect(Collectors.toSet());
        ArraySet r7 = new ArraySet();
        Iterator<PasspointWifiEntry> r8 = this.mPasspointWifiEntryCache.values().iterator();
    L16:
        if (r8.hasNext() == false) goto L18;
        r7.addAll(r8.next().getAllUtf8Ssids());
        goto L16
    L18:
        ArraySet r9 = new ArraySet();
        Iterator<KnownNetworkEntry> r10 = this.mKnownNetworkEntryCache.iterator();
    L20:
        if (r10.hasNext() == false) goto L22;
        r9.add(r10.next().getStandardWifiEntryKey().getScanResultKey());
        goto L20
    L22:
        ArraySet r11 = new ArraySet();
        Iterator<HotspotNetworkEntry> r12 = this.mHotspotNetworkEntryCache.iterator();
    L24:
        if (r12.hasNext() == false) goto L28;
        HotspotNetworkEntry r13 = r12.next();
        if (r13.getHotspotNetworkEntryKey().isVirtualEntry() == true) goto L24;
        r11.add(r13.getHotspotNetworkEntryKey().getScanResultKey());
        goto L24
    L28:
        final ArraySet r15 = new ArraySet();
        Iterator<StandardWifiEntry> r16 = this.mStandardWifiEntryCache.iterator();
    L30:
        if (r16.hasNext() == false) goto L54;
        StandardWifiEntry r17 = r16.next();
        r17.updateAdminRestrictions();
        if (r0.contains(r17) == true) goto L30;
        if (r17.isSaved() == true) goto L47;
        if (r6.contains(r17.getStandardWifiEntryKey().getScanResultKey()) == true) goto L30;
        if (r7.contains(r17.getSsid()) == true) goto L30;
        if (this.mInjector.isSharedConnectivityFeatureEnabled() == false) goto L49;
        if (r9.contains(r17.getStandardWifiEntryKey().getScanResultKey()) == true) goto L30;
    L49:
        if (this.mInjector.isSharedConnectivityFeatureEnabled() == false) goto L53;
        if (r11.contains(r17.getStandardWifiEntryKey().getScanResultKey()) == true) goto L30;
    L53:
        r1.add(r17);
        goto L30
    L47:
        r15.add(r17.getStandardWifiEntryKey().getScanResultKey());
        goto L49
    L54:
        r1.addAll((Collection) this.mSuggestedWifiEntryCache.stream().filter(new WifiPickerTracker$$ExternalSyntheticLambda15()).collect(Collectors.toList()));
        r1.addAll((Collection) this.mPasspointWifiEntryCache.values().stream().filter(new WifiPickerTracker$$ExternalSyntheticLambda16()).collect(Collectors.toList()));
        r1.addAll((Collection) this.mOsuWifiEntryCache.values().stream().filter(new WifiPickerTracker$$ExternalSyntheticLambda17()).collect(Collectors.toList()));
        r1.addAll((Collection) getContextualWifiEntries().stream().filter(new WifiPickerTracker$$ExternalSyntheticLambda18()).collect(Collectors.toList()));
        if (this.mInjector.isSharedConnectivityFeatureEnabled() == false) goto L57;
        r1.addAll((Collection) this.mKnownNetworkEntryCache.stream().filter(new WifiPickerTracker$$ExternalSyntheticLambda19(r15)).collect(Collectors.toList()));
        r1.addAll((Collection) this.mHotspotNetworkEntryCache.stream().filter(new WifiPickerTracker$$ExternalSyntheticLambda20()).collect(Collectors.toList()));
    L57:
        Collections.sort(r1, WifiEntry.WIFI_PICKER_COMPARATOR);
        if (isVerboseLoggingEnabled() == false) goto L72;
        Log.v(TAG, "onWifiEntriesChanged: reason=" + r14);
        StringJoiner r18 = new StringJoiner("\n");
        int r19 = r0.size() + r1.size();
        if (r19 != 0) goto L62;
        r18.add("No entries!");
    L62:
        Iterator r20 = r0.iterator();
        int r21 = 1;
    L64:
        if (r20.hasNext() == false) goto L66;
        r18.add("Entry " + r21 + LibrarianImpl.Constants.SEPARATOR + r19 + ": " + ((WifiEntry) r20.next()));
        r21 = r21 + 1;
        goto L64
    L66:
        Iterator r22 = r1.iterator();
    L68:
        if (r22.hasNext() == false) goto L70;
        r18.add("Entry " + r21 + LibrarianImpl.Constants.SEPARATOR + r19 + ": " + ((WifiEntry) r22.next()));
        r21 = r21 + 1;
        goto L68
    L70:
        Log.d(TAG, r18.toString());
        Log.v(TAG, "MergedCarrierEntry: " + this.mMergedCarrierEntry);
    L72:
        if (r0.isEmpty() == true) goto L76;
        WifiEntry r23 = (WifiEntry) r0.get(0);
        if (r23.isPrimaryNetwork() == false) goto L76;
    L77:
        this.mConnectedWifiEntry = r23;
        this.mActiveWifiEntries = r0;
        this.mWifiEntries = r1;
        notifyOnWifiEntriesChanged(r14);
        return;
    L76:
        r23 = null;
        goto L77
    }

    static /* synthetic */ boolean lambda$updateWifiEntries$4(WifiEntry r0) {
        if (r0.getConnectedState() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ boolean lambda$updateWifiEntries$5(Set r1, WifiEntry r2) {
        if ((r2 instanceof StandardWifiEntry) == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.contains(((StandardWifiEntry) r2).getStandardWifiEntryKey().getScanResultKey()) == false) goto L7;
        return true;
    }

    static /* synthetic */ boolean lambda$updateWifiEntries$6(List r1, StandardWifiEntry r2) {
        if (r2.isUserShareable() == false) goto L7;
        return true;
    L7:
        return r1.contains(r2);
    }

    static /* synthetic */ StandardWifiEntry.ScanResultKey lambda$updateWifiEntries$7(StandardWifiEntry r0) {
        return r0.getStandardWifiEntryKey().getScanResultKey();
    }

    static /* synthetic */ boolean lambda$updateWifiEntries$8(StandardWifiEntry r1) {
        if (r1.getConnectedState() == 0) goto L5;
    L7:
        return false;
    L5:
        if (r1.isUserShareable() == false) goto L7;
        return true;
    }

    static /* synthetic */ boolean lambda$updateWifiEntries$9(PasspointWifiEntry r0) {
        if (r0.getConnectedState() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ boolean lambda$updateWifiEntries$10(OsuWifiEntry r1) {
        if (r1.getConnectedState() == 0) goto L5;
    L7:
        return false;
    L5:
        if (r1.isAlreadyProvisioned() == true) goto L7;
        return true;
    }

    static /* synthetic */ boolean lambda$updateWifiEntries$11(WifiEntry r0) {
        if (r0.getConnectedState() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ boolean lambda$updateWifiEntries$12(Set r1, KnownNetworkEntry r2) {
        if (r2.getConnectedState() == 0) goto L5;
    L7:
        return false;
    L5:
        if (r1.contains(r2.getStandardWifiEntryKey().getScanResultKey()) == true) goto L7;
        return true;
    }

    static /* synthetic */ boolean lambda$updateWifiEntries$13(HotspotNetworkEntry r0) {
        if (r0.getConnectedState() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    protected void updateWifiEntries() {
        updateWifiEntries(0);
    }

    private void updateMergedCarrierEntry(int r8) {
        if (r8 == (-1)) goto L5;
        MergedCarrierEntry r0 = this.mMergedCarrierEntry;
        if (r0 != null) goto L11;
    L13:
        this.mMergedCarrierEntry = new MergedCarrierEntry(this.mInjector, this.mWorkerHandler, this.mWifiManager, false, r8);
        Network r9 = this.mWifiManager.getCurrentNetwork();
        if (r9 == null) goto L21;
        NetworkCapabilities r1 = this.mConnectivityManager.getNetworkCapabilities(r9);
        if (r1 == null) goto L18;
        this.mMergedCarrierEntry.onNetworkCapabilitiesChanged(r9, new NetworkCapabilities.Builder(r1).setTransportInfo(this.mWifiManager.getConnectionInfo()).build());
    L18:
        LinkProperties r2 = this.mConnectivityManager.getLinkProperties(r9);
        if (r2 == null) goto L21;
        this.mMergedCarrierEntry.updateLinkProperties(r9, r2);
    L21:
        notifyOnWifiEntriesChanged(0);
        return;
    L11:
        if (r8 != r0.getSubscriptionId()) goto L13;
        return;
    L5:
        if (this.mMergedCarrierEntry != null) goto L7;
        return;
    L7:
        this.mMergedCarrierEntry = null;
        goto L21
    }

    protected List<WifiEntry> getContextualWifiEntries() {
        return Collections.emptyList();
    }

    private void updateStandardWifiEntryScans(List<ScanResult> r12) {
        Preconditions.checkNotNull(r12, "Scan Result list should not be null!");
        final Map r13 = (Map) r12.stream().filter(new WifiPickerTracker$$ExternalSyntheticLambda8()).collect(Collectors.groupingBy(new SavedNetworkTracker$$ExternalSyntheticLambda8()));
        final ArraySet r0 = new ArraySet(r13.keySet());
        this.mStandardWifiEntryCache.forEach(new WifiPickerTracker$$ExternalSyntheticLambda9(r0, r13));
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        StandardWifiEntry.ScanResultKey r2 = (StandardWifiEntry.ScanResultKey) r1.next();
        StandardWifiEntry.StandardWifiEntryKey r5 = new StandardWifiEntry.StandardWifiEntryKey(r2, true);
        StandardWifiEntry r10 = new StandardWifiEntry(this.mInjector, this.mMainHandler, r5, this.mStandardWifiConfigCache.get(r5), (List) r13.get(r2), this.mWifiManager, false);
        this.mStandardWifiEntryCache.add(r10);
        goto L4
    L6:
        this.mStandardWifiEntryCache.removeIf(new WifiPickerTracker$$ExternalSyntheticLambda10());
    }

    static /* synthetic */ boolean lambda$updateStandardWifiEntryScans$14(ScanResult r0) {
        return !TextUtils.isEmpty(r0.SSID);
    }

    static /* synthetic */ void lambda$updateStandardWifiEntryScans$15(Set r1, Map r2, StandardWifiEntry r3) {
        StandardWifiEntry.ScanResultKey r0 = r3.getStandardWifiEntryKey().getScanResultKey();
        r1.remove(r0);
        r3.updateScanResultInfo((List) r2.get(r0));
    }

    static /* synthetic */ boolean lambda$updateStandardWifiEntryScans$16(StandardWifiEntry r1) {
        if (r1.getLevel() != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private void updateSuggestedWifiEntryScans(List<ScanResult> r14) {
        Preconditions.checkNotNull(r14, "Scan Result list should not be null!");
        final Set r0 = (Set) this.mWifiManager.getWifiConfigForMatchedNetworkSuggestionsSharedWithUser(r14).stream().map(new SavedNetworkTracker$$ExternalSyntheticLambda3()).collect(Collectors.toSet());
        final Map r15 = (Map) r14.stream().filter(new WifiPickerTracker$$ExternalSyntheticLambda22()).collect(Collectors.groupingBy(new SavedNetworkTracker$$ExternalSyntheticLambda8()));
        final ArraySet r1 = new ArraySet();
        this.mSuggestedWifiEntryCache.forEach(new WifiPickerTracker$$ExternalSyntheticLambda23(r1, r15, r0));
        Iterator<StandardWifiEntry.StandardWifiEntryKey> r2 = this.mSuggestedConfigCache.keySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        StandardWifiEntry.StandardWifiEntryKey r3 = r2.next();
        StandardWifiEntry.ScanResultKey r4 = r3.getScanResultKey();
        if (r1.contains(r3) == true) goto L4;
        if (r15.containsKey(r4) == false) goto L4;
        StandardWifiEntry r12 = new StandardWifiEntry(this.mInjector, this.mMainHandler, r3, this.mSuggestedConfigCache.get(r3), (List) r15.get(r4), this.mWifiManager, false);
        r12.setUserShareable(r0.contains(r3));
        this.mSuggestedWifiEntryCache.add(r12);
        goto L4
    L11:
        this.mSuggestedWifiEntryCache.removeIf(new WifiPickerTracker$$ExternalSyntheticLambda24());
    }

    static /* synthetic */ boolean lambda$updateSuggestedWifiEntryScans$17(ScanResult r0) {
        return !TextUtils.isEmpty(r0.SSID);
    }

    static /* synthetic */ void lambda$updateSuggestedWifiEntryScans$18(Set r1, Map r2, Set r3, StandardWifiEntry r4) {
        StandardWifiEntry.StandardWifiEntryKey r0 = r4.getStandardWifiEntryKey();
        r1.add(r0);
        r4.updateScanResultInfo((List) r2.get(r0.getScanResultKey()));
        r4.setUserShareable(r3.contains(r0));
    }

    static /* synthetic */ boolean lambda$updateSuggestedWifiEntryScans$19(StandardWifiEntry r1) {
        if (r1.getLevel() != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private void updatePasspointWifiEntryScans(List<ScanResult> r15) {
        Preconditions.checkNotNull(r15, "Scan Result list should not be null!");
        final TreeSet r0 = new TreeSet();
        Iterator r16 = this.mWifiManager.getAllMatchingWifiConfigs(r15).iterator();
    L4:
        if (r16.hasNext() == false) goto L14;
        Pair r1 = (Pair) r16.next();
        WifiConfiguration r2 = (WifiConfiguration) r1.first;
        List<ScanResult> r10 = (List) ((Map) r1.second).get(0);
        List<ScanResult> r3 = (List) ((Map) r1.second).get(1);
        String r11 = PasspointWifiEntry.uniqueIdToPasspointWifiEntryKey(r2.getKey());
        r0.add(r11);
        if (this.mPasspointWifiEntryCache.containsKey(r11) == true) goto L13;
        if (r2.fromWifiNetworkSuggestion == true) goto L9;
        if (this.mPasspointConfigCache.containsKey(r11) == false) goto L4;
        this.mPasspointWifiEntryCache.put(r11, new PasspointWifiEntry(this.mInjector, this.mMainHandler, this.mPasspointConfigCache.get(r11), this.mWifiManager, false));
        goto L13
    L9:
        this.mPasspointWifiEntryCache.put(r11, new PasspointWifiEntry(this.mInjector, this.mContext, this.mMainHandler, r2, this.mWifiManager, false));
    L13:
        this.mPasspointWifiEntryCache.get(r11).updateScanResultInfo(r2, r10, r3);
        goto L4
    L14:
        this.mPasspointWifiEntryCache.entrySet().removeIf(new WifiPickerTracker$$ExternalSyntheticLambda1(r0));
    }

    static /* synthetic */ boolean lambda$updatePasspointWifiEntryScans$20(Set r2, Map.Entry r3) {
        if (((PasspointWifiEntry) r3.getValue()).getLevel() != (-1)) goto L5;
    L10:
        return true;
    L5:
        if (r2.contains(r3.getKey()) == false) goto L7;
    L9:
        return false;
    L7:
        if (((PasspointWifiEntry) r3.getValue()).getConnectedState() != 0) goto L9;
        goto L9
    }

    private void updateOsuWifiEntryScans(List<ScanResult> r11) {
        Preconditions.checkNotNull(r11, "Scan Result list should not be null!");
        Map r12 = this.mWifiManager.getMatchingOsuProviders(r11);
        final Map r0 = this.mWifiManager.getMatchingPasspointConfigsForOsuProviders(r12.keySet());
        Iterator<OsuWifiEntry> r1 = this.mOsuWifiEntryCache.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        OsuWifiEntry r2 = r1.next();
        r2.updateScanResultInfo((List) r12.remove(r2.getOsuProvider()));
        goto L4
    L6:
        Iterator r3 = r12.keySet().iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        OsuProvider r4 = (OsuProvider) r3.next();
        OsuWifiEntry r9 = new OsuWifiEntry(this.mInjector, this.mMainHandler, r4, this.mWifiManager, false);
        r9.updateScanResultInfo((List) r12.get(r4));
        this.mOsuWifiEntryCache.put(OsuWifiEntry.osuProviderToOsuWifiEntryKey(r4), r9);
        goto L8
    L10:
        this.mOsuWifiEntryCache.values().forEach(new WifiPickerTracker$$ExternalSyntheticLambda33(this, r0));
        this.mOsuWifiEntryCache.entrySet().removeIf(new WifiPickerTracker$$ExternalSyntheticLambda34());
    }

    /* JADX INFO: renamed from: lambda$updateOsuWifiEntryScans$21$com-android-wifitrackerlib-WifiPickerTracker, reason: not valid java name */
    /* synthetic */ void m880xef31b4b9(Map r2, OsuWifiEntry r3) {
        PasspointConfiguration r4 = (PasspointConfiguration) r2.get(r3.getOsuProvider());
        if (r4 != null) goto L6;
        r3.setAlreadyProvisioned(false);
        return;
    L6:
        r3.setAlreadyProvisioned(true);
        PasspointWifiEntry r1 = this.mPasspointWifiEntryCache.get(PasspointWifiEntry.uniqueIdToPasspointWifiEntryKey(r4.getUniqueId()));
        if (r1 != null) goto L9;
        return;
    L9:
        r1.setOsuWifiEntry(r3);
    }

    static /* synthetic */ boolean lambda$updateOsuWifiEntryScans$22(Map.Entry r1) {
        if (((OsuWifiEntry) r1.getValue()).getLevel() != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private void updateKnownNetworkEntryScans(List<ScanResult> r18) {
        Preconditions.checkNotNull(r18, "Scan Result list should not be null!");
        final Map r1 = (Map) r18.stream().filter(new WifiPickerTracker$$ExternalSyntheticLambda0()).collect(Collectors.groupingBy(new SavedNetworkTracker$$ExternalSyntheticLambda8()));
        final Map r2 = (Map) this.mKnownNetworkDataCache.stream().collect(Collectors.toMap(new WifiPickerTracker$$ExternalSyntheticLambda21(), new WifiPickerTracker$$ExternalSyntheticLambda30(), new WifiPickerTracker$$ExternalSyntheticLambda41()));
        this.mKnownNetworkEntryCache.removeIf(new WifiPickerTracker$$ExternalSyntheticLambda43(r2));
        Stream r3 = r2.keySet().stream();
        Objects.requireNonNull(r1);
        final Set r4 = (Set) r3.filter(new WifiPickerTracker$$ExternalSyntheticLambda44(r1)).collect(Collectors.toSet());
        this.mKnownNetworkEntryCache.forEach(new WifiPickerTracker$$ExternalSyntheticLambda45(r4, r1));
        Network r5 = null;
        NetworkCapabilities r6 = null;
        if (r4.isEmpty() == true) goto L10;
        Network r7 = this.mWifiManager.getCurrentNetwork();
        if (r7 == null) goto L9;
        r6 = this.mConnectivityManager.getNetworkCapabilities(r7);
        if (r6 == null) goto L9;
        r6 = new NetworkCapabilities.Builder(r6).setTransportInfo(this.mWifiManager.getConnectionInfo()).build();
    L9:
        NetworkCapabilities r16 = r6;
        r5 = r7;
        NetworkCapabilities r8 = r16;
    L11:
        Iterator r9 = r4.iterator();
    L13:
        if (r9.hasNext() == false) goto L19;
        StandardWifiEntry.ScanResultKey r10 = (StandardWifiEntry.ScanResultKey) r9.next();
        Map r19 = r1;
        KnownNetworkEntry r15 = new KnownNetworkEntry(this.mInjector, this.mMainHandler, new StandardWifiEntry.StandardWifiEntryKey(r10, true), null, (List) r1.get(r10), this.mWifiManager, this.mSharedConnectivityManager, (KnownNetwork) r2.get(r10));
        if (r5 == null) goto L18;
        if (r8 == null) goto L18;
        r15.onNetworkCapabilitiesChanged(r5, r8);
    L18:
        this.mKnownNetworkEntryCache.add(r15);
        r1 = r19;
        goto L13
    L19:
        this.mKnownNetworkEntryCache.removeIf(new WifiPickerTracker$$ExternalSyntheticLambda46());
        return;
    L10:
        r8 = null;
        goto L11
    }

    static /* synthetic */ boolean lambda$updateKnownNetworkEntryScans$23(ScanResult r0) {
        return !TextUtils.isEmpty(r0.SSID);
    }

    static /* synthetic */ StandardWifiEntry.ScanResultKey lambda$updateKnownNetworkEntryScans$24(KnownNetwork r3) {
        return new StandardWifiEntry.ScanResultKey(r3.getSsid(), new ArrayList(r3.getSecurityTypes()));
    }

    static /* synthetic */ KnownNetwork lambda$updateKnownNetworkEntryScans$26(KnownNetwork r1, KnownNetwork r2) {
        Log.e(TAG, "Encountered duplicate key data in updateKnownNetworkEntryScans");
        return r1;
    }

    static /* synthetic */ boolean lambda$updateKnownNetworkEntryScans$27(Map r0, KnownNetworkEntry r1) {
        return !r0.keySet().contains(r1.getStandardWifiEntryKey().getScanResultKey());
    }

    static /* synthetic */ void lambda$updateKnownNetworkEntryScans$28(Set r1, Map r2, KnownNetworkEntry r3) {
        StandardWifiEntry.ScanResultKey r0 = r3.getStandardWifiEntryKey().getScanResultKey();
        r1.remove(r0);
        r3.updateScanResultInfo((List) r2.get(r0));
    }

    static /* synthetic */ boolean lambda$updateKnownNetworkEntryScans$29(KnownNetworkEntry r1) {
        if (r1.getLevel() != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private void updateHotspotNetworkEntries() {
        final Map r0 = (Map) this.mHotspotNetworkDataCache.stream().collect(Collectors.toMap(new WifiPickerTracker$$ExternalSyntheticLambda37(), new WifiPickerTracker$$ExternalSyntheticLambda38(), new WifiPickerTracker$$ExternalSyntheticLambda39()));
        final ArraySet r1 = new ArraySet(r0.keySet());
        this.mHotspotNetworkEntryCache.removeIf(new WifiPickerTracker$$ExternalSyntheticLambda40(r1));
        this.mHotspotNetworkEntryCache.forEach(new WifiPickerTracker$$ExternalSyntheticLambda42(r1, r0));
        Network r3 = null;
        NetworkCapabilities r4 = null;
        if (r1.isEmpty() == true) goto L10;
        Network r2 = this.mWifiManager.getCurrentNetwork();
        if (r2 == null) goto L9;
        r4 = this.mConnectivityManager.getNetworkCapabilities(r2);
        if (r4 == null) goto L9;
        r4 = new NetworkCapabilities.Builder(r4).setTransportInfo(this.mWifiManager.getConnectionInfo()).build();
    L9:
        NetworkCapabilities r13 = r4;
        r3 = r2;
        NetworkCapabilities r5 = r13;
    L11:
        Iterator r6 = r1.iterator();
    L13:
        if (r6.hasNext() == false) goto L19;
        HotspotNetworkEntry r12 = new HotspotNetworkEntry(this.mInjector, this.mContext, this.mMainHandler, this.mWifiManager, this.mSharedConnectivityManager, (HotspotNetwork) r0.get((Long) r6.next()));
        if (r3 == null) goto L18;
        if (r5 == null) goto L18;
        r12.onNetworkCapabilitiesChanged(r3, r5);
    L18:
        this.mHotspotNetworkEntryCache.add(r12);
        goto L13
    L19:
        return;
    L10:
        r5 = null;
        goto L11
    }

    static /* synthetic */ HotspotNetwork lambda$updateHotspotNetworkEntries$31(HotspotNetwork r1, HotspotNetwork r2) {
        Log.e(TAG, "Encountered duplicate key data in updateHotspotNetworkEntries");
        return r1;
    }

    static /* synthetic */ boolean lambda$updateHotspotNetworkEntries$32(Set r2, HotspotNetworkEntry r3) {
        return !r2.contains(Long.valueOf(r3.getHotspotNetworkEntryKey().getDeviceId()));
    }

    static /* synthetic */ void lambda$updateHotspotNetworkEntries$33(Set r2, Map r3, HotspotNetworkEntry r4) {
        Long r0 = Long.valueOf(r4.getHotspotNetworkEntryKey().getDeviceId());
        r2.remove(r0);
        r4.updateHotspotNetworkData((HotspotNetwork) r3.get(r0));
    }

    private void updateNetworkRequestEntryScans(List<ScanResult> r3) {
        Preconditions.checkNotNull(r3, "Scan Result list should not be null!");
        NetworkRequestEntry r0 = this.mNetworkRequestEntry;
        if (r0 != null) goto L5;
        return;
    L5:
        final StandardWifiEntry.ScanResultKey r1 = r0.getStandardWifiEntryKey().getScanResultKey();
        List<ScanResult> r4 = (List) r3.stream().filter(new WifiPickerTracker$$ExternalSyntheticLambda47(r1)).collect(Collectors.toList());
        this.mNetworkRequestEntry.updateScanResultInfo(r4);
    }

    static /* synthetic */ boolean lambda$updateNetworkRequestEntryScans$34(StandardWifiEntry.ScanResultKey r1, ScanResult r2) {
        return r1.equals(new StandardWifiEntry.ScanResultKey(r2));
    }

    private void conditionallyUpdateScanResults(boolean r5) {
        if (this.mWifiManager.getWifiState() != 1) goto L11;
        updateStandardWifiEntryScans(Collections.emptyList());
        updateSuggestedWifiEntryScans(Collections.emptyList());
        updatePasspointWifiEntryScans(Collections.emptyList());
        updateOsuWifiEntryScans(Collections.emptyList());
        if (this.mInjector.isSharedConnectivityFeatureEnabled() == true) goto L7;
    L9:
        updateNetworkRequestEntryScans(Collections.emptyList());
        updateContextualWifiEntryScans(Collections.emptyList());
        return;
    L7:
        if (BuildCompat.isAtLeastU() == false) goto L9;
        this.mKnownNetworkEntryCache.clear();
        this.mHotspotNetworkEntryCache.clear();
        goto L9
    L11:
        long r0 = this.mMaxScanAgeMillis;
        if (r5 == false) goto L14;
        this.mScanResultUpdater.update(this.mWifiManager.getScanResults());
    L15:
        List<ScanResult> r6 = this.mScanResultUpdater.getScanResults(r0);
        updateStandardWifiEntryScans(r6);
        updateSuggestedWifiEntryScans(r6);
        updatePasspointWifiEntryScans(r6);
        updateOsuWifiEntryScans(r6);
        if (this.mInjector.isSharedConnectivityFeatureEnabled() == true) goto L18;
    L20:
        updateNetworkRequestEntryScans(r6);
        updateContextualWifiEntryScans(r6);
        return;
    L18:
        if (BuildCompat.isAtLeastU() == false) goto L20;
        updateKnownNetworkEntryScans(r6);
        updateHotspotNetworkEntries();
        goto L20
    L14:
        r0 = r0 + this.mScanIntervalMillis;
        goto L15
    }

    private void updateWifiConfigurations(List<WifiConfiguration> r5) {
        Preconditions.checkNotNull(r5, "Config list should not be null!");
        this.mStandardWifiConfigCache.clear();
        this.mSuggestedConfigCache.clear();
        this.mNetworkRequestConfigCache.clear();
        Iterator<WifiConfiguration> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L27;
        WifiConfiguration r0 = r6.next();
        if (r0.carrierMerged == true) goto L4;
        StandardWifiEntry.StandardWifiEntryKey r1 = new StandardWifiEntry.StandardWifiEntryKey(r0, true);
        if (r0.isPasspoint() == true) goto L10;
        if (r0.fromWifiNetworkSuggestion == true) goto L14;
        if (r0.fromWifiNetworkSpecifier == true) goto L20;
        if (this.mStandardWifiConfigCache.containsKey(r1) == true) goto L26;
        this.mStandardWifiConfigCache.put(r1, new ArrayList());
    L26:
        this.mStandardWifiConfigCache.get(r1).add(r0);
        goto L4
    L20:
        if (this.mNetworkRequestConfigCache.containsKey(r1) == true) goto L22;
        this.mNetworkRequestConfigCache.put(r1, new ArrayList());
    L22:
        this.mNetworkRequestConfigCache.get(r1).add(r0);
        goto L4
    L14:
        if (this.mSuggestedConfigCache.containsKey(r1) == true) goto L16;
        this.mSuggestedConfigCache.put(r1, new ArrayList());
    L16:
        this.mSuggestedConfigCache.get(r1).add(r0);
        goto L4
    L10:
        this.mPasspointWifiConfigCache.put(r0.networkId, r0);
        goto L4
    L27:
        this.mNumSavedNetworks = (int) this.mStandardWifiConfigCache.values().stream().flatMap(new DashboardFragment$$ExternalSyntheticLambda12()).filter(new WifiPickerTracker$$ExternalSyntheticLambda27()).map(new WifiPickerTracker$$ExternalSyntheticLambda28()).distinct().count();
        this.mStandardWifiEntryCache.forEach(new WifiPickerTracker$$ExternalSyntheticLambda29(this));
        this.mSuggestedWifiEntryCache.removeIf(new WifiPickerTracker$$ExternalSyntheticLambda31(this));
        updateSuggestedWifiEntryScans(this.mScanResultUpdater.getScanResults());
        NetworkRequestEntry r7 = this.mNetworkRequestEntry;
        if (r7 == null) goto L45;
        r7.updateConfig(this.mNetworkRequestConfigCache.get(r7.getStandardWifiEntryKey()));
        return;
    }

    static /* synthetic */ boolean lambda$updateWifiConfigurations$35(WifiConfiguration r0) {
        return !r0.isEphemeral();
    }

    static /* synthetic */ Integer lambda$updateWifiConfigurations$36(WifiConfiguration r0) {
        return Integer.valueOf(r0.networkId);
    }

    /* JADX INFO: renamed from: lambda$updateWifiConfigurations$37$com-android-wifitrackerlib-WifiPickerTracker, reason: not valid java name */
    /* synthetic */ void m882xeeec6548(StandardWifiEntry r2) {
        r2.updateConfig(this.mStandardWifiConfigCache.get(r2.getStandardWifiEntryKey()));
    }

    /* JADX INFO: renamed from: lambda$updateWifiConfigurations$38$com-android-wifitrackerlib-WifiPickerTracker, reason: not valid java name */
    /* synthetic */ boolean m883xa863f2e7(StandardWifiEntry r2) {
        r2.updateConfig(this.mSuggestedConfigCache.get(r2.getStandardWifiEntryKey()));
        return !r2.isSuggestion();
    }

    private void updatePasspointConfigurations(List<PasspointConfiguration> r4) {
        Preconditions.checkNotNull(r4, "Config list should not be null!");
        this.mPasspointConfigCache.clear();
        this.mPasspointConfigCache.putAll((Map) r4.stream().collect(Collectors.toMap(new WifiPickerTracker$$ExternalSyntheticLambda25(), Function.identity())));
        this.mPasspointWifiEntryCache.entrySet().removeIf(new WifiPickerTracker$$ExternalSyntheticLambda26(this));
    }

    static /* synthetic */ String lambda$updatePasspointConfigurations$39(PasspointConfiguration r0) {
        return PasspointWifiEntry.uniqueIdToPasspointWifiEntryKey(r0.getUniqueId());
    }

    /* JADX INFO: renamed from: lambda$updatePasspointConfigurations$40$com-android-wifitrackerlib-WifiPickerTracker, reason: not valid java name */
    /* synthetic */ boolean m881x34bd7dae(Map.Entry r2) {
        PasspointWifiEntry r3 = (PasspointWifiEntry) r2.getValue();
        String r0 = r3.getKey();
        r3.updatePasspointConfig(this.mPasspointConfigCache.get(r0));
        if (r3.isSubscription() == false) goto L5;
    L7:
        return false;
    L5:
        if (r3.isSuggestion() == true) goto L7;
        return true;
    }

    private void updateNetworkCapabilities(Network r3, NetworkCapabilities r4) {
        if ((((this.mStandardWifiConfigCache.size() + this.mSuggestedConfigCache.size()) + this.mPasspointWifiConfigCache.size()) + this.mNetworkRequestConfigCache.size()) != 0) goto L5;
        updateWifiConfigurations(this.mWifiManager.getPrivilegedConfiguredNetworks());
    L5:
        conditionallyCreateConnectedWifiEntry(Utils.getWifiInfo(r4));
        Iterator<WifiEntry> r2 = getAllWifiEntries().iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        r2.next().onNetworkCapabilitiesChanged(r3, r4);
        goto L7
    }

    private void conditionallyCreateConnectedWifiEntry(WifiInfo r1) {
        conditionallyCreateConnectedStandardWifiEntry(r1);
        conditionallyCreateConnectedSuggestedWifiEntry(r1);
        conditionallyCreateConnectedPasspointWifiEntry(r1);
        conditionallyCreateConnectedNetworkRequestEntry(r1);
    }

    private void conditionallyCreateConnectedNetworkRequestEntry(WifiInfo r9) {
        ArrayList r0 = new ArrayList();
        if (r9 == null) goto L14;
        int r2 = 0;
    L6:
        if (r2 >= this.mNetworkRequestConfigCache.size()) goto L14;
        List<WifiConfiguration> r3 = this.mNetworkRequestConfigCache.valueAt(r2);
        if (r3.isEmpty() == true) goto L12;
        if (r3.get(0).networkId != r9.getNetworkId()) goto L12;
        r0.addAll(r3);
    L12:
        r2 = r2 + 1;
    L14:
        if (r0.isEmpty() == false) goto L16;
        return;
    L16:
        StandardWifiEntry.StandardWifiEntryKey r5 = new StandardWifiEntry.StandardWifiEntryKey((WifiConfiguration) r0.get(0));
        NetworkRequestEntry r10 = this.mNetworkRequestEntry;
        if (r10 != null) goto L19;
    L20:
        NetworkRequestEntry r11 = new NetworkRequestEntry(this.mInjector, this.mMainHandler, r5, this.mWifiManager, false);
        this.mNetworkRequestEntry = r11;
        r11.updateConfig(r0);
        updateNetworkRequestEntryScans(this.mScanResultUpdater.getScanResults());
        return;
    L19:
        if (r10.getStandardWifiEntryKey().equals(r5) == false) goto L20;
    }

    private void conditionallyCreateConnectedStandardWifiEntry(WifiInfo r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.isPasspointAp() == false) goto L6;
        return;
    L6:
        if (r11.isOsuAp() == true) goto L30;
        final int r12 = r11.getNetworkId();
        Iterator<List<WifiConfiguration>> r0 = this.mStandardWifiConfigCache.values().iterator();
    L10:
        if (r0.hasNext() == false) goto L31;
        List<WifiConfiguration> r6 = r0.next();
        if (r6.stream().map(new WifiPickerTracker$$ExternalSyntheticLambda6()).filter(new WifiPickerTracker$$ExternalSyntheticLambda7(r12)).count() == 0) goto L10;
        StandardWifiEntry.StandardWifiEntryKey r5 = new StandardWifiEntry.StandardWifiEntryKey(r6.get(0), true);
        Iterator<StandardWifiEntry> r13 = this.mStandardWifiEntryCache.iterator();
    L16:
        if (r13.hasNext() == false) goto L20;
        if (r5.equals(r13.next().getStandardWifiEntryKey()) == false) goto L16;
        return;
    L20:
        StandardWifiEntry r14 = new StandardWifiEntry(this.mInjector, this.mMainHandler, r5, r6, null, this.mWifiManager, false);
        this.mStandardWifiEntryCache.add(r14);
        return;
    L31:
        return;
    }

    static /* synthetic */ Integer lambda$conditionallyCreateConnectedStandardWifiEntry$41(WifiConfiguration r0) {
        return Integer.valueOf(r0.networkId);
    }

    static /* synthetic */ boolean lambda$conditionallyCreateConnectedStandardWifiEntry$42(int r0, Integer r1) {
        if (r1.intValue() != r0) goto L5;
        return true;
    L5:
        return false;
    }

    private void conditionallyCreateConnectedSuggestedWifiEntry(WifiInfo r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.isPasspointAp() == false) goto L6;
        return;
    L6:
        if (r11.isOsuAp() == true) goto L35;
        int r12 = r11.getNetworkId();
        Iterator<List<WifiConfiguration>> r0 = this.mSuggestedConfigCache.values().iterator();
    L10:
        if (r0.hasNext() == false) goto L36;
        List<WifiConfiguration> r6 = r0.next();
        if (r6.isEmpty() == true) goto L10;
        if (r6.get(0).networkId != r12) goto L10;
        StandardWifiEntry.StandardWifiEntryKey r5 = new StandardWifiEntry.StandardWifiEntryKey(r6.get(0), true);
        Iterator<StandardWifiEntry> r13 = this.mSuggestedWifiEntryCache.iterator();
    L18:
        if (r13.hasNext() == false) goto L22;
        if (r5.equals(r13.next().getStandardWifiEntryKey()) == false) goto L18;
        return;
    L22:
        StandardWifiEntry r14 = new StandardWifiEntry(this.mInjector, this.mMainHandler, r5, r6, null, this.mWifiManager, false);
        this.mSuggestedWifiEntryCache.add(r14);
        return;
    L36:
        return;
    }

    private void conditionallyCreateConnectedPasspointWifiEntry(WifiInfo r12) {
        if (r12 != null) goto L4;
        return;
    L4:
        if (r12.isPasspointAp() == false) goto L19;
        WifiConfiguration r4 = this.mPasspointWifiConfigCache.get(r12.getNetworkId());
        if (r4 != null) goto L9;
        return;
    L9:
        String r13 = PasspointWifiEntry.uniqueIdToPasspointWifiEntryKey(r4.getKey());
        if (this.mPasspointWifiEntryCache.containsKey(r13) == false) goto L12;
        return;
    L12:
        PasspointConfiguration r8 = this.mPasspointConfigCache.get(PasspointWifiEntry.uniqueIdToPasspointWifiEntryKey(r4.getKey()));
        if (r8 == null) goto L15;
        PasspointWifiEntry r14 = new PasspointWifiEntry(this.mInjector, this.mMainHandler, r8, this.mWifiManager, false);
    L16:
        this.mPasspointWifiEntryCache.put(r14.getKey(), r14);
        return;
    L15:
        r14 = new PasspointWifiEntry(this.mInjector, this.mContext, this.mMainHandler, r4, this.mWifiManager, false);
        goto L16
    }

    private void notifyOnWifiEntriesChanged(final int r3) {
        if (this.mListener == null) goto L6;
        this.mMainHandler.post(new WifiPickerTracker$$ExternalSyntheticLambda5(this, r3));
        return;
    }

    /* JADX INFO: renamed from: lambda$notifyOnWifiEntriesChanged$43$com-android-wifitrackerlib-WifiPickerTracker, reason: not valid java name */
    /* synthetic */ void m879x5816a813(int r1) {
        this.mListener.onWifiEntriesChanged(r1);
    }

    private void notifyOnNumSavedNetworksChanged() {
        if (this.mListener == null) goto L6;
        Handler r0 = this.mMainHandler;
        final WifiPickerTrackerCallback r2 = this.mListener;
        Objects.requireNonNull(r2);
        r0.post(new WifiPickerTracker$$ExternalSyntheticLambda2(r2));
        return;
    }

    private void notifyOnNumSavedSubscriptionsChanged() {
        if (this.mListener == null) goto L6;
        Handler r0 = this.mMainHandler;
        final WifiPickerTrackerCallback r2 = this.mListener;
        Objects.requireNonNull(r2);
        r0.post(new WifiPickerTracker$$ExternalSyntheticLambda32(r2));
        return;
    }
}
