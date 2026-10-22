package com.android.settingslib.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkKey;
import android.net.NetworkRequest;
import android.net.NetworkScoreManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiNetworkScoreCache;
import android.net.wifi.hotspot2.OsuProvider;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Log;
import android.util.Pair;
import android.widget.Toast;
import com.GlobalProxyLancet;
import com.android.settings.AdaptConstants;
import com.android.settingslib.R;
import com.android.settingslib.core.lifecycle.Lifecycle;
import com.android.settingslib.core.lifecycle.LifecycleObserver;
import com.android.settingslib.core.lifecycle.events.OnDestroy;
import com.android.settingslib.core.lifecycle.events.OnStart;
import com.android.settingslib.core.lifecycle.events.OnStop;
import com.android.settingslib.utils.ThreadUtils;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import obric.tablet.widget.BytedanceJustifyTextView;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class WifiTracker implements LifecycleObserver, OnStart, OnStop, OnDestroy {
    private static final long DEFAULT_MAX_CACHED_SCORE_AGE_MILLIS = 1200000;
    static final long MAX_SCAN_RESULT_AGE_MILLIS = 15000;
    private static final String TAG = "WifiTracker";
    private static final int WIFI_RESCAN_INTERVAL_MS = 10000;
    private static final String WIFI_SECURITY_EAP = "EAP";
    private static final String WIFI_SECURITY_OWE = "OWE";
    private static final String WIFI_SECURITY_PSK = "PSK";
    private static final String WIFI_SECURITY_SAE = "SAE";
    private static final String WIFI_SECURITY_SUITE_B_192 = "SUITE_B_192";
    public static boolean sVerboseLogging;
    private final AtomicBoolean mConnected;
    private final ConnectivityManager mConnectivityManager;
    private final Context mContext;
    private final IntentFilter mFilter;
    private final List<AccessPoint> mInternalAccessPoints;
    private WifiInfo mLastInfo;
    private NetworkInfo mLastNetworkInfo;
    private boolean mLastScanSucceeded;
    private final WifiListenerExecutor mListener;
    private final Object mLock;
    private long mMaxSpeedLabelScoreCacheAge;
    private WifiTrackerNetworkCallback mNetworkCallback;
    private final NetworkRequest mNetworkRequest;
    private final NetworkScoreManager mNetworkScoreManager;
    private boolean mNetworkScoringUiEnabled;
    final BroadcastReceiver mReceiver;
    private boolean mRegistered;
    private final Set<NetworkKey> mRequestedScores;
    private final HashMap<String, ScanResult> mScanResultCache;
    Scanner mScanner;
    private WifiNetworkScoreCache mScoreCache;
    private boolean mStaleScanResults;
    private final WifiManager mWifiManager;
    Handler mWorkHandler;
    private HandlerThread mWorkThread;

    private static class Multimap<K, V> {
        private final HashMap<K, List<V>> store;

        private Multimap() {
            this.store = new HashMap();
        }

        List<V> getAll(K r1) {
            List<V> r0 = this.store.get(r1);
            if (r0 == null) goto L6;
            return r0;
        L6:
            return Collections.emptyList();
        }

        void put(K r3, V r4) {
            List<V> r0 = this.store.get(r3);
            if (r0 != null) goto L5;
            r0 = new ArrayList(3);
            this.store.put(r3, r0);
        L5:
            r0.add(r4);
        }
    }

    class Scanner extends Handler {
        static final int MSG_SCAN = 0;
        private int mRetry;
        final /* synthetic */ WifiTracker this$0;

        Scanner(WifiTracker r1) {
            this.this$0 = r1;
            this.mRetry = 0;
        }

        void resume() {
            if (WifiTracker.access$900() == false) goto L6;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(WifiTracker.TAG, "Scanner resume");
        L6:
            if (hasMessages(0) == true) goto L9;
            sendEmptyMessage(0);
            return;
        }

        void pause() {
            if (WifiTracker.access$900() == false) goto L5;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(WifiTracker.TAG, "Scanner pause");
        L5:
            this.mRetry = 0;
            removeMessages(0);
        }

        boolean isScanning() {
            return hasMessages(0);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r4) {
            if (r4.what == 0) goto L6;
            return;
        L6:
            if (WifiTracker.access$300(this.this$0).startScan() == false) goto L8;
            this.mRetry = 0;
        L14:
            sendEmptyMessageDelayed(0, 10000);
            return;
        L8:
            int r5 = this.mRetry + 1;
            this.mRetry = r5;
            if (r5 < 3) goto L14;
            this.mRetry = 0;
            if (WifiTracker.access$1000(this.this$0) == null) goto L16;
            Toast.makeText(WifiTracker.access$1000(this.this$0), R.string.wifi_fail_to_scan, 1).show();
            return;
        }
    }

    public interface WifiListener {
        void onAccessPointsChanged();

        void onConnectedChanged();

        void onWifiStateChanged(int r1);
    }

    class WifiListenerExecutor implements WifiListener {
        private final WifiListener mDelegatee;
        final /* synthetic */ WifiTracker this$0;

        public WifiListenerExecutor(WifiTracker r1, WifiListener r2) {
            this.this$0 = r1;
            this.mDelegatee = r2;
        }

        /* JADX INFO: renamed from: lambda$onWifiStateChanged$0$com-android-settingslib-wifi-WifiTracker$WifiListenerExecutor, reason: not valid java name */
        /* synthetic */ void m851x2ba4b5bc(int r1) {
            this.mDelegatee.onWifiStateChanged(r1);
        }

        @Override // com.android.settingslib.wifi.WifiTracker.WifiListener
        public void onWifiStateChanged(final int r4) {
            runAndLog(new WifiTracker$WifiListenerExecutor$$ExternalSyntheticLambda2(this, r4), String.format("Invoking onWifiStateChanged callback with state %d", new Object[]{Integer.valueOf(r4)}));
        }

        @Override // com.android.settingslib.wifi.WifiTracker.WifiListener
        public void onConnectedChanged() {
            final WifiListener r0 = this.mDelegatee;
            Objects.requireNonNull(r0);
            runAndLog(new WifiTracker$WifiListenerExecutor$$ExternalSyntheticLambda0(r0), "Invoking onConnectedChanged callback");
        }

        @Override // com.android.settingslib.wifi.WifiTracker.WifiListener
        public void onAccessPointsChanged() {
            final WifiListener r0 = this.mDelegatee;
            Objects.requireNonNull(r0);
            runAndLog(new WifiTracker$WifiListenerExecutor$$ExternalSyntheticLambda3(r0), "Invoking onAccessPointsChanged callback");
        }

        private void runAndLog(final Runnable r2, final String r3) {
            ThreadUtils.postOnMainThread(new WifiTracker$WifiListenerExecutor$$ExternalSyntheticLambda1(this, r3, r2));
        }

        /* JADX INFO: renamed from: lambda$runAndLog$1$com-android-settingslib-wifi-WifiTracker$WifiListenerExecutor, reason: not valid java name */
        /* synthetic */ void m852x749f0124(String r1, Runnable r2) {
            if (WifiTracker.access$000(this.this$0) == true) goto L5;
            return;
        L5:
            if (WifiTracker.access$900() == false) goto L7;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_i(WifiTracker.TAG, r1);
        L7:
            r2.run();
        }
    }

    private final class WifiTrackerNetworkCallback extends ConnectivityManager.NetworkCallback {
        final /* synthetic */ WifiTracker this$0;

        private WifiTrackerNetworkCallback(WifiTracker r1) {
            this.this$0 = r1;
        }

        /* synthetic */ WifiTrackerNetworkCallback(WifiTracker r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network r1, NetworkCapabilities r2) {
            if (r1.equals(WifiTracker.access$300(this.this$0).getCurrentNetwork()) == false) goto L6;
            WifiTracker.access$800(this.this$0, null);
            return;
        }
    }

    static /* synthetic */ boolean access$000(WifiTracker r0) {
        return r0.mRegistered;
    }

    static /* synthetic */ void access$100(WifiTracker r0) {
        r0.updateNetworkScores();
    }

    static /* synthetic */ Context access$1000(WifiTracker r0) {
        return r0.mContext;
    }

    static /* synthetic */ WifiManager access$300(WifiTracker r0) {
        return r0.mWifiManager;
    }

    static /* synthetic */ void access$400(WifiTracker r0, int r1) {
        r0.updateWifiState(r1);
    }

    static /* synthetic */ boolean access$502(WifiTracker r0, boolean r1) {
        r0.mStaleScanResults = r1;
        return r1;
    }

    static /* synthetic */ boolean access$602(WifiTracker r0, boolean r1) {
        r0.mLastScanSucceeded = r1;
        return r1;
    }

    static /* synthetic */ void access$700(WifiTracker r0) {
        r0.fetchScansAndConfigsAndUpdateAccessPoints();
    }

    static /* synthetic */ void access$800(WifiTracker r0, NetworkInfo r1) {
        r0.updateNetworkInfo(r1);
    }

    static /* synthetic */ boolean access$900() {
        return isVerboseLoggingEnabled();
    }

    private static final boolean DBG() {
        return Log.isLoggable(TAG, 3);
    }

    private static boolean isVerboseLoggingEnabled() {
        if (sVerboseLogging == false) goto L5;
    L8:
        return true;
    L5:
        if (Log.isLoggable(TAG, 2) == true) goto L8;
        return false;
    }

    private static IntentFilter newIntentFilter() {
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        r0.addAction("android.net.wifi.SCAN_RESULTS");
        r0.addAction("android.net.wifi.NETWORK_IDS_CHANGED");
        r0.addAction("android.net.wifi.supplicant.STATE_CHANGE");
        r0.addAction("android.net.wifi.CONFIGURED_NETWORKS_CHANGE");
        r0.addAction(AdaptConstants.LINK_CONFIGURATION_CHANGED_ACTION);
        r0.addAction("android.net.wifi.STATE_CHANGE");
        r0.addAction("android.net.wifi.RSSI_CHANGED");
        return r0;
    }

    @Deprecated
    public WifiTracker(Context r8, WifiListener r9, boolean r10, boolean r11) {
        this(r8, r9, (WifiManager) r8.getSystemService(WifiManager.class), (ConnectivityManager) r8.getSystemService(ConnectivityManager.class), (NetworkScoreManager) r8.getSystemService(NetworkScoreManager.class), newIntentFilter());
    }

    public WifiTracker(Context r8, WifiListener r9, Lifecycle r10, boolean r11, boolean r12) {
        this(r8, r9, (WifiManager) r8.getSystemService(WifiManager.class), (ConnectivityManager) r8.getSystemService(ConnectivityManager.class), (NetworkScoreManager) r8.getSystemService(NetworkScoreManager.class), newIntentFilter());
        r10.addObserver(this);
    }

    WifiTracker(Context r4, WifiListener r5, WifiManager r6, ConnectivityManager r7, NetworkScoreManager r8, IntentFilter r9) {
        boolean r1 = false;
        this.mConnected = new AtomicBoolean(false);
        this.mLock = new Object();
        this.mInternalAccessPoints = new ArrayList();
        this.mRequestedScores = new ArraySet();
        this.mStaleScanResults = true;
        this.mLastScanSucceeded = true;
        this.mScanResultCache = new HashMap();
        this.mReceiver = new AnonymousClass2(this);
        this.mContext = r4;
        this.mWifiManager = r6;
        this.mListener = new WifiListenerExecutor(this, r5);
        this.mConnectivityManager = r7;
        if (r6 != null) goto L5;
    L7:
        sVerboseLogging = r1;
        this.mFilter = r9;
        this.mNetworkRequest = new NetworkRequest.Builder().clearCapabilities().addCapability(15).addTransportType(1).build();
        this.mNetworkScoreManager = r8;
        HandlerThread r10 = new HandlerThread("WifiTracker{" + Integer.toHexString(System.identityHashCode(this)) + VectorFormat.DEFAULT_SUFFIX, 10);
        r10.start();
        setWorkThread(r10);
        return;
    L5:
        if (r6.isVerboseLoggingEnabled() == false) goto L7;
        r1 = true;
        goto L7
    }

    void setWorkThread(HandlerThread r4) {
        this.mWorkThread = r4;
        this.mWorkHandler = new Handler(r4.getLooper());
        Context r0 = this.mContext;
        final Handler r2 = this.mWorkHandler;
        this.mScoreCache = new WifiNetworkScoreCache(r0, new AnonymousClass1(this, r2));
    }

    @Override // com.android.settingslib.core.lifecycle.events.OnDestroy
    public void onDestroy() {
        this.mWorkThread.quit();
    }

    private void pauseScanning() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Scanner r1 = this.mScanner;     // Catch: Throwable -> L10
        if (r1 == null) goto L7;
        r1.pause();     // Catch: Throwable -> L10
        this.mScanner = null;     // Catch: Throwable -> L10
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L10
        this.mStaleScanResults = true;
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void resumeScanning() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mScanner != null) goto L8;
        this.mScanner = new Scanner(this);     // Catch: Throwable -> L12
    L8:
        if (isWifiEnabled() == false) goto L10;
        this.mScanner.resume();     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    @Override // com.android.settingslib.core.lifecycle.events.OnStart
    public void onStart() {
        forceUpdate();
        registerScoreCache();
        boolean r2 = false;
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "network_scoring_ui_enabled", 0) != 1) goto L5;
        r2 = true;
    L5:
        this.mNetworkScoringUiEnabled = r2;
        this.mMaxSpeedLabelScoreCacheAge = Settings.Global.getLong(this.mContext.getContentResolver(), "speed_label_cache_eviction_age_millis", 1200000);
        resumeScanning();
        if (this.mRegistered == true) goto L9;
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mReceiver, this.mFilter, null, this.mWorkHandler, 2);
        WifiTrackerNetworkCallback r0 = new WifiTrackerNetworkCallback(this, null);
        this.mNetworkCallback = r0;
        this.mConnectivityManager.registerNetworkCallback(this.mNetworkRequest, r0, this.mWorkHandler);
        this.mRegistered = true;
        return;
    }

    void forceUpdate() {
        this.mLastInfo = this.mWifiManager.getConnectionInfo();
        this.mLastNetworkInfo = this.mConnectivityManager.getNetworkInfo(this.mWifiManager.getCurrentNetwork());
        fetchScansAndConfigsAndUpdateAccessPoints();
    }

    private void registerScoreCache() {
        this.mNetworkScoreManager.registerNetworkScoreCache(1, this.mScoreCache, 2);
    }

    private void requestScoresForNetworkKeys(Collection<NetworkKey> r4) {
        if (r4.isEmpty() == false) goto L6;
        return;
    L6:
        if (DBG() == false) goto L8;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Requesting scores for Network Keys: " + r4);
    L8:
        this.mNetworkScoreManager.requestScores((NetworkKey[]) r4.toArray(new NetworkKey[r4.size()]));
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mRequestedScores.addAll(r4);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.android.settingslib.core.lifecycle.events.OnStop
    public void onStop() {
        if (this.mRegistered == false) goto L5;
        this.mContext.unregisterReceiver(this.mReceiver);
        this.mConnectivityManager.unregisterNetworkCallback(this.mNetworkCallback);
        this.mRegistered = false;
    L5:
        unregisterScoreCache();
        pauseScanning();
        this.mWorkHandler.removeCallbacksAndMessages(null);
    }

    private void unregisterScoreCache() {
        this.mNetworkScoreManager.unregisterNetworkScoreCache(1, this.mScoreCache);
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mRequestedScores.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public List<AccessPoint> getAccessPoints() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(this.mInternalAccessPoints);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public WifiManager getManager() {
        return this.mWifiManager;
    }

    public boolean isWifiEnabled() {
        WifiManager r0 = this.mWifiManager;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isWifiEnabled() == false) goto L7;
        return true;
    }

    public int getNumSavedNetworks() {
        return WifiSavedConfigUtils.getAllConfigs(this.mContext, this.mWifiManager).size();
    }

    public boolean isConnected() {
        return this.mConnected.get();
    }

    public void dump(PrintWriter r4) {
        r4.println("  - wifi tracker ------");
        Iterator<AccessPoint> r3 = getAccessPoints().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r4.println(BytedanceJustifyTextView.TWO_BLANK + r3.next());
        goto L4
    }

    private ArrayMap<String, List<ScanResult>> updateScanResultCache(List<ScanResult> r5) {
        Iterator<ScanResult> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L11;
        ScanResult r0 = r6.next();
        if (r0.SSID == null) goto L4;
        if (r0.SSID.isEmpty() == true) goto L4;
        this.mScanResultCache.put(r0.BSSID, r0);
        goto L4
    L11:
        evictOldScans();
        ArrayMap<String, List<ScanResult>> r7 = new ArrayMap();
        Iterator<ScanResult> r1 = this.mScanResultCache.values().iterator();
    L13:
        if (r1.hasNext() == false) goto L26;
        ScanResult r2 = r1.next();
        if (r2.SSID == null) goto L13;
        if (r2.SSID.length() == 0) goto L13;
        if (r2.capabilities.contains("[IBSS]") == true) goto L13;
        String r3 = AccessPoint.getKey(this.mContext, r2);
        if (r7.containsKey(r3) == false) goto L24;
        List<ScanResult> r4 = r7.get(r3);
    L25:
        r4.add(r2);
        goto L13
    L24:
        ArrayList r8 = new ArrayList();
        r7.put(r3, r8);
        r4 = r8;
        goto L25
    L26:
        return r7;
    }

    private void evictOldScans() {
        if (this.mLastScanSucceeded == false) goto L5;
        long r0 = 15000;
    L6:
        long r2 = SystemClock.elapsedRealtime();
        Iterator<ScanResult> r8 = this.mScanResultCache.values().iterator();
    L8:
        if (r8.hasNext() == false) goto L12;
        if ((r2 - (r8.next().timestamp / 1000)) <= r0) goto L8;
        r8.remove();
        goto L8
    L12:
        return;
    L5:
        r0 = 30000;
        goto L6
    }

    private WifiConfiguration getWifiConfigurationForNetworkId(int r3, List<WifiConfiguration> r4) {
        if (r4 == null) goto L11;
        Iterator<WifiConfiguration> r5 = r4.iterator();
    L5:
        if (r5.hasNext() == false) goto L19;
        WifiConfiguration r0 = r5.next();
        if (this.mLastInfo == null) goto L5;
        if (r3 != r0.networkId) goto L5;
        return r0;
    L19:
        return null;
    L11:
        return null;
    }

    private void fetchScansAndConfigsAndUpdateAccessPoints() {
        List<ScanResult> r0 = filterScanResultsByCapabilities(this.mWifiManager.getScanResults());
        if (isVerboseLoggingEnabled() == false) goto L5;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_i(TAG, "Fetched scan results: " + r0);
    L5:
        updateAccessPoints(r0, this.mWifiManager.getConfiguredNetworks());
    }

    private void updateAccessPoints(List<ScanResult> r13, List<WifiConfiguration> r14) {
        WifiInfo r0 = this.mLastInfo;
        if (r0 == null) goto L5;
        WifiConfiguration r1 = getWifiConfigurationForNetworkId(r0.getNetworkId(), r14);
    L6:
        Object r2 = this.mLock;
        monitor-enter(r2);
        ArrayMap<String, List<ScanResult>> r15 = updateScanResultCache(r13);     // Catch: Throwable -> L66
        List<AccessPoint> r3 = new ArrayList(this.mInternalAccessPoints);     // Catch: Throwable -> L66
        ArrayList r4 = new ArrayList();     // Catch: Throwable -> L66
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L66
        Iterator<Map.Entry<String, List<ScanResult>>> r16 = r15.entrySet().iterator();     // Catch: Throwable -> L66
    L10:
        if (r16.hasNext() == false) goto L29;
        Map.Entry<String, List<ScanResult>> r6 = r16.next();     // Catch: Throwable -> L66
        Iterator<ScanResult> r9 = r6.getValue().iterator();     // Catch: Throwable -> L66
    L13:
        if (r9.hasNext() == false) goto L19;
        NetworkKey r10 = NetworkKey.createFromScanResult(r9.next());     // Catch: Throwable -> L66
        if (r10 == null) goto L13;
        if (this.mRequestedScores.contains(r10) == true) goto L13;
        r5.add(r10);     // Catch: Throwable -> L66
        goto L13
    L19:
        final AccessPoint r7 = getCachedOrCreate(r6.getValue(), r3);     // Catch: Throwable -> L66
        List r11 = (List) r14.stream().filter(new WifiTracker$$ExternalSyntheticLambda0(r7)).collect(Collectors.toList());     // Catch: Throwable -> L66
        int r12 = r11.size();     // Catch: Throwable -> L66
        if (r12 != 0) goto L22;
        r7.update(null);     // Catch: Throwable -> L66
    L28:
        r4.add(r7);     // Catch: Throwable -> L66
        goto L10
    L22:
        if (r12 != 1) goto L24;
        r7.update((WifiConfiguration) r11.get(0));     // Catch: Throwable -> L66
        goto L28
    L24:
        Optional r8 = r11.stream().filter(new WifiTracker$$ExternalSyntheticLambda1()).findFirst();     // Catch: Throwable -> L66
        if (r8.isPresent() == false) goto L27;
        r7.update((WifiConfiguration) r8.get());     // Catch: Throwable -> L66
        goto L28
    L27:
        r7.update((WifiConfiguration) r11.get(0));     // Catch: Throwable -> L66
        goto L28
    L29:
        ArrayList r17 = new ArrayList(this.mScanResultCache.values());     // Catch: Throwable -> L66
        r4.addAll(updatePasspointAccessPoints(this.mWifiManager.getAllMatchingWifiConfigs(r17), r3));     // Catch: Throwable -> L66
        r4.addAll(updateOsuAccessPoints(this.mWifiManager.getMatchingOsuProviders(r17), r3));     // Catch: Throwable -> L66
        if (this.mLastInfo == null) goto L38;
        if (this.mLastNetworkInfo == null) goto L38;
        Iterator r18 = r4.iterator();     // Catch: Throwable -> L66
    L35:
        if (r18.hasNext() == false) goto L38;
        ((AccessPoint) r18.next()).update(r1, this.mLastInfo, this.mLastNetworkInfo);     // Catch: Throwable -> L66
    L38:
        if (r4.isEmpty() == false) goto L41;
        if (r1 == null) goto L41;
        AccessPoint r19 = new AccessPoint(this.mContext, r1);     // Catch: Throwable -> L66
        r19.update(r1, this.mLastInfo, this.mLastNetworkInfo);     // Catch: Throwable -> L66
        r4.add(r19);     // Catch: Throwable -> L66
        r5.add(NetworkKey.createFromWifiInfo(this.mLastInfo));     // Catch: Throwable -> L66
    L41:
        requestScoresForNetworkKeys(r5);     // Catch: Throwable -> L66
        Iterator r110 = r4.iterator();     // Catch: Throwable -> L66
    L43:
        if (r110.hasNext() == false) goto L45;
        ((AccessPoint) r110.next()).update(this.mScoreCache, this.mNetworkScoringUiEnabled, this.mMaxSpeedLabelScoreCacheAge);     // Catch: Throwable -> L66
        goto L43
    L45:
        Collections.sort(r4);     // Catch: Throwable -> L66
        if (DBG() == false) goto L62;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "------ Dumping AccessPoints that were not seen on this scan ------");     // Catch: Throwable -> L66
        Iterator<AccessPoint> r111 = this.mInternalAccessPoints.iterator();     // Catch: Throwable -> L66
    L49:
        if (r111.hasNext() == false) goto L61;
        String r112 = r111.next().getTitle();     // Catch: Throwable -> L66
        Iterator r20 = r4.iterator();     // Catch: Throwable -> L66
    L52:
        if (r20.hasNext() == false) goto L58;
        AccessPoint r21 = (AccessPoint) r20.next();     // Catch: Throwable -> L66
        if (r21.getTitle() == null) goto L52;
        if (r21.getTitle().equals(r112) == false) goto L52;
        boolean r22 = true;
    L59:
        if (r22 == true) goto L49;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Did not find " + r112 + " in this scan");     // Catch: Throwable -> L66
        goto L49
    L58:
        r22 = false;
        goto L59
    L61:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "---- Done dumping AccessPoints that were not seen on this scan ----");     // Catch: Throwable -> L66
    L62:
        this.mInternalAccessPoints.clear();     // Catch: Throwable -> L66
        this.mInternalAccessPoints.addAll(r4);     // Catch: Throwable -> L66
        monitor-exit(r2);     // Catch: Throwable -> L66
        conditionallyNotifyListeners();
        return;
    L66:
        th = move-exception;
        throw th;
    L5:
        r1 = null;
        goto L6
    }

    static /* synthetic */ boolean lambda$updateAccessPoints$0(AccessPoint r0, WifiConfiguration r1) {
        return r0.matches(r1);
    }

    static /* synthetic */ boolean lambda$updateAccessPoints$1(WifiConfiguration r0) {
        return isSaeOrOwe(r0);
    }

    private static boolean isSaeOrOwe(WifiConfiguration r1) {
        int r2 = AccessPoint.getSecurity(r1);
        if (r2 != 5) goto L5;
    L8:
        return true;
    L5:
        if (r2 == 4) goto L8;
        return false;
    }

    List<AccessPoint> updatePasspointAccessPoints(List<Pair<WifiConfiguration, Map<Integer, List<ScanResult>>>> r7, List<AccessPoint> r8) {
        ArrayList r0 = new ArrayList();
        ArraySet r1 = new ArraySet();
        Iterator<Pair<WifiConfiguration, Map<Integer, List<ScanResult>>>> r9 = r7.iterator();
    L4:
        if (r9.hasNext() == false) goto L8;
        Pair<WifiConfiguration, Map<Integer, List<ScanResult>>> r2 = r9.next();
        WifiConfiguration r3 = (WifiConfiguration) r2.first;
        if (r1.add(r3.FQDN) == false) goto L4;
        r0.add(getCachedOrCreatePasspoint(r3, (List) ((Map) r2.second).get(0), (List) ((Map) r2.second).get(1), r8));
        goto L4
    L8:
        return r0;
    }

    List<AccessPoint> updateOsuAccessPoints(Map<OsuProvider, List<ScanResult>> r6, List<AccessPoint> r7) {
        ArrayList r0 = new ArrayList();
        Set r1 = this.mWifiManager.getMatchingPasspointConfigsForOsuProviders(r6.keySet()).keySet();
        Iterator<OsuProvider> r2 = r6.keySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        OsuProvider r3 = r2.next();
        if (r1.contains(r3) == true) goto L4;
        r0.add(getCachedOrCreateOsu(r3, r6.get(r3), r7));
        goto L4
    L8:
        return r0;
    }

    private AccessPoint getCachedOrCreate(List<ScanResult> r3, List<AccessPoint> r4) {
        AccessPoint r5 = getCachedByKey(r4, AccessPoint.getKey(this.mContext, r3.get(0)));
        if (r5 == null) goto L7;
        r5.setScanResults(r3);
        return r5;
    L7:
        return new AccessPoint(this.mContext, r3);
    }

    private AccessPoint getCachedOrCreatePasspoint(WifiConfiguration r2, List<ScanResult> r3, List<ScanResult> r4, List<AccessPoint> r5) {
        AccessPoint r6 = getCachedByKey(r5, AccessPoint.getKey(r2));
        if (r6 == null) goto L7;
        r6.update(r2);
        r6.setScanResultsPasspoint(r3, r4);
        return r6;
    L7:
        return new AccessPoint(this.mContext, r2, r3, r4);
    }

    private AccessPoint getCachedOrCreateOsu(OsuProvider r2, List<ScanResult> r3, List<AccessPoint> r4) {
        AccessPoint r5 = getCachedByKey(r4, AccessPoint.getKey(r2));
        if (r5 == null) goto L7;
        r5.setScanResults(r3);
        return r5;
    L7:
        return new AccessPoint(this.mContext, r2, r3);
    }

    private AccessPoint getCachedByKey(List<AccessPoint> r2, String r3) {
        ListIterator<AccessPoint> r1 = r2.listIterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        AccessPoint r4 = r1.next();
        if (r4.getKey().equals(r3) == false) goto L4;
        r1.remove();
        return r4;
    L9:
        return null;
    }

    private void updateNetworkInfo(NetworkInfo r11) {
        if (isWifiEnabled() == true) goto L6;
        clearAccessPointsAndConditionallyUpdate();
        return;
    L6:
        if (r11 == null) goto L13;
        this.mLastNetworkInfo = r11;
        if (DBG() == false) goto L11;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "mLastNetworkInfo set: " + this.mLastNetworkInfo);
    L11:
        if (r11.isConnected() == this.mConnected.getAndSet(r11.isConnected())) goto L13;
        this.mListener.onConnectedChanged();
    L13:
        this.mLastInfo = this.mWifiManager.getConnectionInfo();
        if (DBG() == false) goto L16;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "mLastInfo set as: " + this.mLastInfo);
    L16:
        WifiInfo r12 = this.mLastInfo;
        if (r12 == null) goto L19;
        WifiConfiguration r13 = getWifiConfigurationForNetworkId(r12.getNetworkId(), this.mWifiManager.getConfiguredNetworks());
    L20:
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mInternalAccessPoints.size() - 1;     // Catch: Throwable -> L40
        boolean r3 = false;
        boolean r4 = false;
    L23:
        if (r1 < 0) goto L34;
        AccessPoint r5 = this.mInternalAccessPoints.get(r1);     // Catch: Throwable -> L40
        boolean r6 = r5.isActive();     // Catch: Throwable -> L40
        if (r5.update(r13, this.mLastInfo, this.mLastNetworkInfo) == false) goto L31;
        if (r6 == r5.isActive()) goto L29;
        r3 = true;
        r4 = true;
        goto L31
    L29:
        r4 = true;
    L31:
        if (r5.update(this.mScoreCache, this.mNetworkScoringUiEnabled, this.mMaxSpeedLabelScoreCacheAge) == false) goto L33;
        r3 = true;
        r4 = true;
    L33:
        r1 = r1 - 1;     // Catch: Throwable -> L40
        goto L23
    L34:
        if (r3 == false) goto L36;
        Collections.sort(this.mInternalAccessPoints);     // Catch: Throwable -> L40
    L36:
        if (r4 == false) goto L38;
        conditionallyNotifyListeners();     // Catch: Throwable -> L40
    L38:
        monitor-exit(r0);     // Catch: Throwable -> L40
        return;
    L40:
        th = move-exception;
        throw th;
    L19:
        r13 = null;
        goto L20
    }

    private void clearAccessPointsAndConditionallyUpdate() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mInternalAccessPoints.isEmpty() == true) goto L7;
        this.mInternalAccessPoints.clear();     // Catch: Throwable -> L9
        conditionallyNotifyListeners();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    private void updateNetworkScores() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = 0;
        boolean r2 = false;
    L18:
    L15:
        th = move-exception;
        throw th;
    L6:
        if (r1 >= this.mInternalAccessPoints.size()) goto L11;
        if (this.mInternalAccessPoints.get(r1).update(this.mScoreCache, this.mNetworkScoringUiEnabled, this.mMaxSpeedLabelScoreCacheAge) == false) goto L10;
        r2 = true;
    L10:
        r1 = r1 + 1;     // Catch: Throwable -> L15
        goto L18
    L11:
        if (r2 == false) goto L13;
        Collections.sort(this.mInternalAccessPoints);     // Catch: Throwable -> L15
        conditionallyNotifyListeners();     // Catch: Throwable -> L15
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L15
    }

    private void updateWifiState(int r4) {
        if (isVerboseLoggingEnabled() == false) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "updateWifiState: " + r4);
    L6:
        if (r4 != 3) goto L17;
        Object r0 = this.mLock;
        monitor-enter(r0);
        Scanner r1 = this.mScanner;     // Catch: Throwable -> L14
        if (r1 == null) goto L12;
        r1.resume();     // Catch: Throwable -> L14
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
    L24:
        this.mListener.onWifiStateChanged(r4);
        return;
    L14:
        th = move-exception;
        throw th;
    L17:
        clearAccessPointsAndConditionallyUpdate();
        this.mLastInfo = null;
        this.mLastNetworkInfo = null;
        Object r2 = this.mLock;
        monitor-enter(r2);
        Scanner r3 = this.mScanner;     // Catch: Throwable -> L26
        if (r3 == null) goto L22;
        r3.pause();     // Catch: Throwable -> L26
    L22:
        monitor-exit(r2);     // Catch: Throwable -> L26
        this.mStaleScanResults = true;
    L26:
        th = move-exception;
        throw th;
    }

    private void conditionallyNotifyListeners() {
        if (this.mStaleScanResults == false) goto L5;
        return;
    L5:
        this.mListener.onAccessPointsChanged();
    }

    private List<ScanResult> filterScanResultsByCapabilities(List<ScanResult> r7) {
        if (r7 != null) goto L5;
        return null;
    L5:
        boolean r0 = this.mWifiManager.isEnhancedOpenSupported();
        boolean r1 = this.mWifiManager.isWpa3SaeSupported();
        boolean r6 = this.mWifiManager.isWpa3SuiteBSupported();
        ArrayList r2 = new ArrayList();
        Iterator<ScanResult> r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L24;
        ScanResult r3 = r8.next();
        if (r3.capabilities.contains(WIFI_SECURITY_PSK) == true) goto L10;
        if (r3.capabilities.contains(WIFI_SECURITY_SUITE_B_192) == false) goto L15;
        if (r6 == true) goto L15;
    L21:
        if (isVerboseLoggingEnabled() == false) goto L7;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_v(TAG, "filterScanResultsByCapabilities: Filtering SSID " + r3.SSID + " with capabilities: " + r3.capabilities);
    L15:
        if (r3.capabilities.contains(WIFI_SECURITY_SAE) == false) goto L18;
        if (r1 == false) goto L21;
    L18:
        if (r3.capabilities.contains(WIFI_SECURITY_OWE) == false) goto L23;
        if (r0 == false) goto L21;
    L23:
        r2.add(r3);
        goto L7
    L10:
        r2.add(r3);
        goto L7
    L24:
        return r2;
    }
}
