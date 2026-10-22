package com.android.settingslib.wifi;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkKey;
import android.net.NetworkRequest;
import android.net.NetworkScoreManager;
import android.net.ScoredNetwork;
import android.net.vcn.VcnTransportInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiNetworkScoreCache;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.provider.Settings;
import com.android.settingslib.R;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class WifiStatusTracker {
    private static final int HISTORY_SIZE = 32;
    private static final SimpleDateFormat SSDF = null;
    public boolean connected;
    public boolean enabled;
    public boolean isCaptivePortal;
    public boolean isCarrierMerged;
    public boolean isDefaultNetwork;
    public int level;
    private final WifiNetworkScoreCache.CacheListener mCacheListener;
    private final Runnable mCallback;
    private final ConnectivityManager mConnectivityManager;
    private final Context mContext;
    private Network mDefaultNetwork;
    private final ConnectivityManager.NetworkCallback mDefaultNetworkCallback;
    private NetworkCapabilities mDefaultNetworkCapabilities;
    private final Handler mHandler;
    private final String[] mHistory;
    private int mHistoryIndex;
    private final Handler mMainThreadHandler;
    private final ConnectivityManager.NetworkCallback mNetworkCallback;
    private final NetworkRequest mNetworkRequest;
    private final NetworkScoreManager mNetworkScoreManager;
    private final Set<Integer> mNetworks;
    private int mPrimaryNetworkId;
    private WifiInfo mWifiInfo;
    private final WifiManager mWifiManager;
    private final WifiNetworkScoreCache mWifiNetworkScoreCache;
    public int rssi;
    public String ssid;
    public int state;
    public String statusLabel;
    public int subId;
    public int wifiStandard;

    /* JADX INFO: renamed from: com.android.settingslib.wifi.WifiStatusTracker$1, reason: invalid class name */
    class AnonymousClass1 extends ConnectivityManager.NetworkCallback {
        final /* synthetic */ WifiStatusTracker this$0;

        AnonymousClass1(WifiStatusTracker r1, int r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network r6, NetworkCapabilities r7) {
            WifiInfo r0 = WifiStatusTracker.access$000(this.this$0, r7);
            if (WifiStatusTracker.access$100(this.this$0, r7, r0) == false) goto L5;
            WifiStatusTracker.access$300(this.this$0, WifiStatusTracker.access$200().format(Long.valueOf(System.currentTimeMillis())) + ",onCapabilitiesChanged: network=" + r6 + ",networkCapabilities=" + r7);
        L5:
            if (r0 == null) goto L15;
            if (r0.isPrimary() == false) goto L15;
            if (WifiStatusTracker.access$400(this.this$0).contains(Integer.valueOf(r6.getNetId())) == true) goto L12;
            WifiStatusTracker.access$400(this.this$0).add(Integer.valueOf(r6.getNetId()));
        L12:
            WifiStatusTracker.access$502(this.this$0, r6.getNetId());
            WifiStatusTracker.access$600(this.this$0, r0);
            WifiStatusTracker.access$700(this.this$0);
            WifiStatusTracker.access$800(this.this$0).post(new WifiStatusTracker$1$$ExternalSyntheticLambda0(this));
            return;
        L15:
            if (WifiStatusTracker.access$400(this.this$0).contains(Integer.valueOf(r6.getNetId())) == false) goto L18;
            WifiStatusTracker.access$400(this.this$0).remove(Integer.valueOf(r6.getNetId()));
            return;
        }

        /* JADX INFO: renamed from: lambda$onCapabilitiesChanged$0$com-android-settingslib-wifi-WifiStatusTracker$1, reason: not valid java name */
        /* synthetic */ void m846x3aaa41d1() {
            WifiStatusTracker.access$900(this.this$0);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network r5) {
            WifiStatusTracker.access$300(this.this$0, WifiStatusTracker.access$200().format(Long.valueOf(System.currentTimeMillis())) + ",onLost: network=" + r5);
            if (WifiStatusTracker.access$400(this.this$0).contains(Integer.valueOf(r5.getNetId())) == false) goto L6;
            WifiStatusTracker.access$400(this.this$0).remove(Integer.valueOf(r5.getNetId()));
        L6:
            if (r5.getNetId() == WifiStatusTracker.access$500(this.this$0)) goto L8;
            return;
        L8:
            WifiStatusTracker.access$600(this.this$0, null);
            WifiStatusTracker.access$700(this.this$0);
            WifiStatusTracker.access$800(this.this$0).post(new WifiStatusTracker$1$$ExternalSyntheticLambda1(this));
        }

        /* JADX INFO: renamed from: lambda$onLost$1$com-android-settingslib-wifi-WifiStatusTracker$1, reason: not valid java name */
        /* synthetic */ void m847lambda$onLost$1$comandroidsettingslibwifiWifiStatusTracker$1() {
            WifiStatusTracker.access$900(this.this$0);
        }
    }

    /* JADX INFO: renamed from: com.android.settingslib.wifi.WifiStatusTracker$2, reason: invalid class name */
    class AnonymousClass2 extends ConnectivityManager.NetworkCallback {
        final /* synthetic */ WifiStatusTracker this$0;

        AnonymousClass2(WifiStatusTracker r1, int r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network r2, NetworkCapabilities r3) {
            WifiStatusTracker.access$1002(this.this$0, r2);
            WifiStatusTracker.access$1102(this.this$0, r3);
            WifiStatusTracker.access$700(this.this$0);
            WifiStatusTracker.access$800(this.this$0).post(new WifiStatusTracker$2$$ExternalSyntheticLambda0(this));
        }

        /* JADX INFO: renamed from: lambda$onCapabilitiesChanged$0$com-android-settingslib-wifi-WifiStatusTracker$2, reason: not valid java name */
        /* synthetic */ void m848x3aaa41d2() {
            WifiStatusTracker.access$900(this.this$0);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network r2) {
            WifiStatusTracker.access$1002(this.this$0, null);
            WifiStatusTracker.access$1102(this.this$0, null);
            WifiStatusTracker.access$700(this.this$0);
            WifiStatusTracker.access$800(this.this$0).post(new WifiStatusTracker$2$$ExternalSyntheticLambda1(this));
        }

        /* JADX INFO: renamed from: lambda$onLost$1$com-android-settingslib-wifi-WifiStatusTracker$2, reason: not valid java name */
        /* synthetic */ void m849lambda$onLost$1$comandroidsettingslibwifiWifiStatusTracker$2() {
            WifiStatusTracker.access$900(this.this$0);
        }
    }

    /* JADX INFO: renamed from: com.android.settingslib.wifi.WifiStatusTracker$3, reason: invalid class name */
    class AnonymousClass3 extends WifiNetworkScoreCache.CacheListener {
        final /* synthetic */ WifiStatusTracker this$0;

        AnonymousClass3(WifiStatusTracker r1, Handler r2) {
            this.this$0 = r1;
            super(r2);
        }

        public void networkCacheUpdated(List<ScoredNetwork> r2) {
            WifiStatusTracker.access$700(this.this$0);
            WifiStatusTracker.access$800(this.this$0).post(new WifiStatusTracker$3$$ExternalSyntheticLambda0(this));
        }

        /* JADX INFO: renamed from: lambda$networkCacheUpdated$0$com-android-settingslib-wifi-WifiStatusTracker$3, reason: not valid java name */
        /* synthetic */ void m850x9a5f61ab() {
            WifiStatusTracker.access$900(this.this$0);
        }
    }

    static /* synthetic */ WifiInfo access$000(WifiStatusTracker r0, NetworkCapabilities r1) {
        return r0.getMainOrUnderlyingWifiInfo(r1);
    }

    static /* synthetic */ boolean access$100(WifiStatusTracker r0, NetworkCapabilities r1, WifiInfo r2) {
        return r0.connectionIsWifi(r1, r2);
    }

    static /* synthetic */ Network access$1002(WifiStatusTracker r0, Network r1) {
        r0.mDefaultNetwork = r1;
        return r1;
    }

    static /* synthetic */ NetworkCapabilities access$1102(WifiStatusTracker r0, NetworkCapabilities r1) {
        r0.mDefaultNetworkCapabilities = r1;
        return r1;
    }

    static /* synthetic */ SimpleDateFormat access$200() {
        return SSDF;
    }

    static /* synthetic */ void access$300(WifiStatusTracker r0, String r1) {
        r0.recordLastWifiNetwork(r1);
    }

    static /* synthetic */ Set access$400(WifiStatusTracker r0) {
        return r0.mNetworks;
    }

    static /* synthetic */ int access$500(WifiStatusTracker r0) {
        return r0.mPrimaryNetworkId;
    }

    static /* synthetic */ int access$502(WifiStatusTracker r0, int r1) {
        r0.mPrimaryNetworkId = r1;
        return r1;
    }

    static /* synthetic */ void access$600(WifiStatusTracker r0, WifiInfo r1) {
        r0.updateWifiInfo(r1);
    }

    static /* synthetic */ void access$700(WifiStatusTracker r0) {
        r0.updateStatusLabel();
    }

    static /* synthetic */ Handler access$800(WifiStatusTracker r0) {
        return r0.mMainThreadHandler;
    }

    static /* synthetic */ void access$900(WifiStatusTracker r0) {
        r0.postResults();
    }

    static {
        SSDF = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
    }

    public WifiStatusTracker(Context r9, WifiManager r10, NetworkScoreManager r11, ConnectivityManager r12, Runnable r13) {
        this(r9, r10, r11, r12, r13, null, null);
    }

    public WifiStatusTracker(Context r4, WifiManager r5, NetworkScoreManager r6, ConnectivityManager r7, Runnable r8, Handler r9, Handler r10) {
        this.mNetworks = new HashSet();
        this.mHistory = new String[32];
        this.mNetworkRequest = new NetworkRequest.Builder().clearCapabilities().addCapability(15).addTransportType(1).addTransportType(0).build();
        this.mNetworkCallback = new AnonymousClass1(this, 1);
        this.mDefaultNetworkCallback = new AnonymousClass2(this, 1);
        this.mDefaultNetwork = null;
        this.mDefaultNetworkCapabilities = null;
        this.mContext = r4;
        this.mWifiManager = r5;
        this.mWifiNetworkScoreCache = new WifiNetworkScoreCache(r4);
        this.mNetworkScoreManager = r6;
        this.mConnectivityManager = r7;
        this.mCallback = r8;
        if (r10 != null) goto L5;
        HandlerThread r11 = new HandlerThread("WifiStatusTrackerHandler");
        r11.start();
        this.mHandler = new Handler(r11.getLooper());
    L6:
        if (r9 != null) goto L8;
        r9 = new Handler(Looper.getMainLooper());
    L8:
        this.mMainThreadHandler = r9;
        this.mCacheListener = new AnonymousClass3(this, this.mHandler);
        return;
    L5:
        this.mHandler = r10;
        goto L6
    }

    public void setListening(boolean r4) {
        if (r4 == false) goto L5;
        this.mNetworkScoreManager.registerNetworkScoreCache(1, this.mWifiNetworkScoreCache, 1);
        this.mWifiNetworkScoreCache.registerListener(this.mCacheListener);
        this.mConnectivityManager.registerNetworkCallback(this.mNetworkRequest, this.mNetworkCallback, this.mHandler);
        this.mConnectivityManager.registerDefaultNetworkCallback(this.mDefaultNetworkCallback, this.mHandler);
        return;
    L5:
        this.mNetworkScoreManager.unregisterNetworkScoreCache(1, this.mWifiNetworkScoreCache);
        this.mWifiNetworkScoreCache.unregisterListener();
        this.mConnectivityManager.unregisterNetworkCallback(this.mNetworkCallback);
        this.mConnectivityManager.unregisterNetworkCallback(this.mDefaultNetworkCallback);
    }

    public void fetchInitialState() {
        if (this.mWifiManager != null) goto L5;
        return;
    L5:
        updateWifiState();
        boolean r1 = true;
        NetworkInfo r0 = this.mConnectivityManager.getNetworkInfo(1);
        if (r0 != null) goto L8;
    L10:
        r1 = false;
    L11:
        this.connected = r1;
        this.mWifiInfo = null;
        this.ssid = null;
        if (r1 == false) goto L23;
        WifiInfo r2 = this.mWifiManager.getConnectionInfo();
        this.mWifiInfo = r2;
        if (r2 == null) goto L23;
        if (r2.isPasspointAp() == false) goto L18;
    L21:
        this.ssid = this.mWifiInfo.getPasspointProviderFriendlyName();
    L22:
        this.isCarrierMerged = this.mWifiInfo.isCarrierMerged();
        this.subId = this.mWifiInfo.getSubscriptionId();
        updateRssi(this.mWifiInfo.getRssi());
        maybeRequestNetworkScore();
        goto L23
    L18:
        if (this.mWifiInfo.isOsuAp() == true) goto L21;
        this.ssid = getValidSsid(this.mWifiInfo);
    L23:
        updateStatusLabel();
        return;
    L8:
        if (r0.isConnected() == false) goto L10;
        goto L10
    }

    public void handleBroadcast(Intent r2) {
        if (this.mWifiManager != null) goto L6;
        return;
    L6:
        if (r2.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED") == false) goto L9;
        updateWifiState();
        return;
    }

    private void updateWifiInfo(WifiInfo r2) {
        updateWifiState();
        if (r2 == null) goto L5;
        boolean r0 = true;
    L6:
        this.connected = r0;
        this.mWifiInfo = r2;
        this.ssid = null;
        if (r2 != null) goto L9;
        return;
    L9:
        if (r2.isPasspointAp() == false) goto L11;
    L14:
        this.ssid = this.mWifiInfo.getPasspointProviderFriendlyName();
    L15:
        updateRssi(this.mWifiInfo.getRssi());
        maybeRequestNetworkScore();
        this.wifiStandard = this.mWifiInfo.getWifiStandard();
        this.isCarrierMerged = this.mWifiInfo.isCarrierMerged();
        this.subId = this.mWifiInfo.getSubscriptionId();
        updateRssi(this.mWifiInfo.getRssi());
        maybeRequestNetworkScore();
        return;
    L11:
        if (this.mWifiInfo.isOsuAp() == true) goto L14;
        this.ssid = getValidSsid(this.mWifiInfo);
        goto L15
    L5:
        r0 = false;
        goto L6
    }

    private void updateWifiState() {
        int r0 = this.mWifiManager.getWifiState();
        this.state = r0;
        if (r0 != 3) goto L5;
        boolean r1 = true;
    L6:
        this.enabled = r1;
        return;
    L5:
        r1 = false;
        goto L6
    }

    private void updateRssi(int r2) {
        this.rssi = r2;
        this.level = this.mWifiManager.calculateSignalLevel(r2);
    }

    private void maybeRequestNetworkScore() {
        NetworkKey r0 = NetworkKey.createFromWifiInfo(this.mWifiInfo);
        if (this.mWifiNetworkScoreCache.getScoredNetwork(r0) != null) goto L6;
        this.mNetworkScoreManager.requestScores(new NetworkKey[]{r0});
        return;
    }

    private void updateStatusLabel() {
        if (this.mWifiManager != null) goto L5;
        return;
    L5:
        NetworkCapabilities r0 = this.mDefaultNetworkCapabilities;
        if (r0 != null) goto L8;
    L10:
        boolean r1 = false;
    L11:
        this.isDefaultNetwork = r1;
        if (r1 == false) goto L14;
        NetworkCapabilities r2 = this.mDefaultNetworkCapabilities;
    L15:
        this.isCaptivePortal = false;
        if (r2 != null) goto L18;
    L40:
        ScoredNetwork r3 = this.mWifiNetworkScoreCache.getScoredNetwork(NetworkKey.createFromWifiInfo(this.mWifiInfo));
        if (r3 != null) goto L43;
        String r4 = null;
    L44:
        this.statusLabel = r4;
        return;
    L43:
        r4 = AccessPoint.getSpeedLabel(this.mContext, r3, this.rssi);
        goto L44
    L18:
        if (r2.hasCapability(17) == false) goto L22;
        this.statusLabel = this.mContext.getString(R.string.wifi_status_sign_in_required);
        this.isCaptivePortal = true;
        return;
    L22:
        if (r2.hasCapability(24) == false) goto L26;
        this.statusLabel = this.mContext.getString(R.string.wifi_limited_connection);
        return;
    L26:
        if (r2.hasCapability(16) == true) goto L33;
        Settings.Global.getString(this.mContext.getContentResolver(), "private_dns_mode");
        if (r2.isPrivateDnsBroken() == false) goto L30;
        this.statusLabel = this.mContext.getString(R.string.private_dns_broken);
        return;
    L30:
        this.statusLabel = this.mContext.getString(R.string.wifi_status_no_internet);
        return;
    L33:
        if (this.isDefaultNetwork == true) goto L40;
        NetworkCapabilities r5 = this.mDefaultNetworkCapabilities;
        if (r5 == null) goto L40;
        if (r5.hasTransport(0) == false) goto L40;
        this.statusLabel = this.mContext.getString(R.string.wifi_connected_low_quality);
        return;
    L14:
        r2 = this.mConnectivityManager.getNetworkCapabilities(this.mWifiManager.getCurrentNetwork());
        goto L15
    L8:
        if (connectionIsWifi(r0) == false) goto L10;
        r1 = true;
        goto L11
    }

    private WifiInfo getMainOrUnderlyingWifiInfo(NetworkCapabilities r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        WifiInfo r1 = getMainWifiInfo(r4);
        if (r1 == null) goto L9;
        return r1;
    L9:
        if (r4.hasTransport(0) == true) goto L11;
        return r1;
    L11:
        List r5 = r4.getUnderlyingNetworks();
        if (r5 != null) goto L14;
        return null;
    L14:
        Iterator r6 = r5.iterator();
    L16:
        if (r6.hasNext() == false) goto L20;
        Network r2 = (Network) r6.next();
        WifiInfo r3 = getMainWifiInfo(this.mConnectivityManager.getNetworkCapabilities(r2));
        if (r3 == null) goto L16;
        return r3;
    L20:
        return null;
    }

    private WifiInfo getMainWifiInfo(NetworkCapabilities r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        boolean r0 = true;
        if (r4.hasTransport(1) == false) goto L8;
    L11:
        if (r0 == true) goto L13;
        return null;
    L13:
        VcnTransportInfo r5 = r4.getTransportInfo();
        if ((r5 instanceof VcnTransportInfo) == false) goto L18;
        return r5.getWifiInfo();
    L18:
        if ((r5 instanceof WifiInfo) == true) goto L20;
        return null;
    L20:
        return (WifiInfo) r5;
    L8:
        if (r4.hasTransport(0) == true) goto L11;
        r0 = false;
        goto L11
    }

    private boolean connectionIsWifi(NetworkCapabilities r2) {
        return connectionIsWifi(r2, getMainOrUnderlyingWifiInfo(r2));
    }

    private boolean connectionIsWifi(NetworkCapabilities r2, WifiInfo r3) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (r3 != null) goto L10;
        if (r2.hasTransport(1) == true) goto L10;
        return false;
    L10:
        return true;
    }

    public void refreshLocale() {
        updateStatusLabel();
        this.mMainThreadHandler.post(new WifiStatusTracker$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: renamed from: lambda$refreshLocale$0$com-android-settingslib-wifi-WifiStatusTracker, reason: not valid java name */
    /* synthetic */ void m845xb5e646ae() {
        postResults();
    }

    private String getValidSsid(WifiInfo r1) {
        String r0 = r1.getSSID();
        if (r0 != null) goto L5;
        return null;
    L5:
        if ("<unknown ssid>".equals(r0) == true) goto L9;
        return r0;
    L9:
        return null;
    }

    private void recordLastWifiNetwork(String r3) {
        String[] r0 = this.mHistory;
        int r1 = this.mHistoryIndex;
        r0[r1] = r3;
        this.mHistoryIndex = (r1 + 1) % 32;
    }

    private void postResults() {
        this.mCallback.run();
    }

    public void dump(PrintWriter r7) {
        r7.println("  - WiFi Network History ------");
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= 32) goto L9;
        if (this.mHistory[r0] == null) goto L8;
        r1 = r1 + 1;
    L8:
        r0 = r0 + 1;
        goto L4
    L9:
        int r2 = this.mHistoryIndex + 32;
    L10:
        r2 = r2 - 1;
        if (r2 < ((this.mHistoryIndex + 32) - r1)) goto L13;
        r7.println("  Previous WiFiNetwork(" + ((this.mHistoryIndex + 32) - r2) + "): " + this.mHistory[r2 & 31]);
        goto L10
    }
}
