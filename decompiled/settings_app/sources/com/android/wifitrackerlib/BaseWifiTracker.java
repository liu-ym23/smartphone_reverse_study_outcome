package com.android.wifitrackerlib;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityDiagnosticsManager;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiScanner;
import android.net.wifi.sharedconnectivity.app.HotspotNetwork;
import android.net.wifi.sharedconnectivity.app.HotspotNetworkConnectionStatus;
import android.net.wifi.sharedconnectivity.app.KnownNetwork;
import android.net.wifi.sharedconnectivity.app.KnownNetworkConnectionStatus;
import android.net.wifi.sharedconnectivity.app.SharedConnectivityClientCallback;
import android.net.wifi.sharedconnectivity.app.SharedConnectivityManager;
import android.net.wifi.sharedconnectivity.app.SharedConnectivitySettingsState;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.core.os.BuildCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.GlobalProxyLancet;
import java.time.Clock;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class BaseWifiTracker {
    protected final ActivityManager mActivityManager;
    private final BroadcastReceiver mBroadcastReceiver;
    private final ConnectivityDiagnosticsManager.ConnectivityDiagnosticsCallback mConnectivityDiagnosticsCallback;
    private final Executor mConnectivityDiagnosticsExecutor;
    protected final ConnectivityDiagnosticsManager mConnectivityDiagnosticsManager;
    protected final ConnectivityManager mConnectivityManager;
    protected final Context mContext;
    private final ConnectivityManager.NetworkCallback mDefaultNetworkCallback;
    protected final WifiTrackerInjector mInjector;
    private boolean mIsInitialized;
    private boolean mIsScanningDisabled;
    private final LifecycleObserver mLifecycleObserver;
    private final BaseWifiTrackerCallback mListener;
    protected final Handler mMainHandler;
    protected final long mMaxScanAgeMillis;
    private final ConnectivityManager.NetworkCallback mNetworkCallback;
    private final NetworkRequest mNetworkRequest;
    protected final long mScanIntervalMillis;
    protected final ScanResultUpdater mScanResultUpdater;
    private final Scanner mScanner;
    private SharedConnectivityClientCallback mSharedConnectivityCallback;
    private final Executor mSharedConnectivityExecutor;
    protected SharedConnectivityManager mSharedConnectivityManager;
    private final String mTag;
    protected final WifiManager mWifiManager;
    private int mWifiState;
    protected final Handler mWorkerHandler;

    protected interface BaseWifiTrackerCallback {
        default void onScanRequested() {
        }

        void onWifiStateChanged();
    }

    private class Scanner extends Handler {
        private final WifiScanner.ScanListener mFirstScanListener;
        private boolean mIsStartedState;
        private boolean mIsWifiEnabled;
        final /* synthetic */ BaseWifiTracker this$0;

        /* JADX INFO: renamed from: com.android.wifitrackerlib.BaseWifiTracker$Scanner$1, reason: invalid class name */
        class AnonymousClass1 implements WifiScanner.ScanListener {
            final /* synthetic */ Scanner this$1;

            public void onFullResult(ScanResult r1) {
            }

            public void onPeriodChanged(int r1) {
            }

            public void onSuccess() {
            }

            AnonymousClass1(Scanner r1) {
                this.this$1 = r1;
            }

            public void onResults(final WifiScanner.ScanData[] r3) {
                this.this$1.this$0.mWorkerHandler.post(new BaseWifiTracker$Scanner$1$$ExternalSyntheticLambda1(this, r3));
            }

            /* JADX INFO: renamed from: lambda$onResults$0$com-android-wifitrackerlib-BaseWifiTracker$Scanner$1, reason: not valid java name */
            /* synthetic */ void m857xb61b0a56(WifiScanner.ScanData[] r5) {
                if (Scanner.access$1000(this.this$1) == true) goto L6;
                return;
            L6:
                if (this.this$1.this$0.isVerboseLoggingEnabled() == false) goto L8;
                Log.v(BaseWifiTracker.access$000(this.this$1.this$0), "Received scan results from first scan request.");
            L8:
                ArrayList r0 = new ArrayList();
                if (r5 == null) goto L13;
                int r1 = r5.length;
                int r2 = 0;
            L11:
                if (r2 >= r1) goto L13;
                r0.addAll(List.of(r5[r2].getResults()));
                r2 = r2 + 1;
            L13:
                this.this$1.this$0.mScanResultUpdater.update(r0);
                this.this$1.this$0.handleScanResultsAvailableAction(new Intent("android.net.wifi.SCAN_RESULTS").putExtra("resultsUpdated", true));
                Scanner.access$900(this.this$1);
            }

            public void onFailure(final int r2, String r3) {
                this.this$1.this$0.mWorkerHandler.post(new BaseWifiTracker$Scanner$1$$ExternalSyntheticLambda0(this, r2));
            }

            /* JADX INFO: renamed from: lambda$onFailure$1$com-android-wifitrackerlib-BaseWifiTracker$Scanner$1, reason: not valid java name */
            /* synthetic */ void m856xb91ddce1(int r4) {
                if (Scanner.access$800(this.this$1) == true) goto L5;
                return;
            L5:
                Log.e(BaseWifiTracker.access$000(this.this$1.this$0), "Failed to scan! Reason: " + r4 + ", ");
                Scanner.access$900(this.this$1);
            }
        }

        public static /* synthetic */ void $r8$lambda$8kTpX9K3f_W494xgBmSuJSjoHzQ(Scanner r0) {
            r0.possiblyStartScanning();
        }

        public static /* synthetic */ void $r8$lambda$GpH9DceLYCccsaSmlVkp91j7BQ8(Scanner r0) {
            r0.scanLoop();
        }

        public static /* synthetic */ void $r8$lambda$bQVY2s2hrCDszrqGyEpGeVDtK1E(Scanner r0) {
            r0.stopScanning();
        }

        /* synthetic */ Scanner(BaseWifiTracker r1, Looper r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        static /* synthetic */ boolean access$1000(Scanner r0) {
            return r0.shouldScan();
        }

        static /* synthetic */ void access$300(Scanner r0, boolean r1) {
            r0.onWifiStateChanged(r1);
        }

        static /* synthetic */ void access$600(Scanner r0) {
            r0.onStart();
        }

        static /* synthetic */ void access$700(Scanner r0) {
            r0.onStop();
        }

        static /* synthetic */ boolean access$800(Scanner r0) {
            return r0.mIsWifiEnabled;
        }

        static /* synthetic */ void access$900(Scanner r0) {
            r0.scanLoop();
        }

        private Scanner(BaseWifiTracker r1, Looper r2) {
            this.this$0 = r1;
            super(r2);
            this.mIsStartedState = false;
            this.mIsWifiEnabled = false;
            this.mFirstScanListener = new AnonymousClass1(this);
        }

        private void onStart() {
            this.mIsStartedState = true;
            this.this$0.mWorkerHandler.post(new BaseWifiTracker$Scanner$$ExternalSyntheticLambda0(this));
        }

        private void onStop() {
            this.mIsStartedState = false;
            this.this$0.mWorkerHandler.post(new BaseWifiTracker$Scanner$$ExternalSyntheticLambda1(this));
        }

        private void onWifiStateChanged(boolean r2) {
            boolean r0 = this.mIsWifiEnabled;
            this.mIsWifiEnabled = r2;
            if (r2 == r0) goto L8;
            if (r2 == false) goto L6;
            possiblyStartScanning();
            return;
        L6:
            stopScanning();
            return;
        }

        private boolean shouldScan() {
            if (this.mIsWifiEnabled == true) goto L5;
        L9:
            return false;
        L5:
            if (this.mIsStartedState == false) goto L9;
            if (BaseWifiTracker.access$1100(this.this$0) == true) goto L9;
            return true;
        }

        private void possiblyStartScanning() {
            if (shouldScan() == true) goto L5;
            return;
        L5:
            Log.i(BaseWifiTracker.access$000(this.this$0), "Scanning started");
            if (BuildCompat.isAtLeastU() == false) goto L15;
            WifiScanner.ScanSettings r0 = new WifiScanner.ScanSettings();
            r0.band = 3;
            r0.setRnrSetting(1);
            r0.reportEvents = 3;
            WifiScanner r1 = (WifiScanner) this.this$0.mContext.getSystemService(WifiScanner.class);
            if (r1 == null) goto L14;
            r1.stopScan(this.mFirstScanListener);
            if (this.this$0.isVerboseLoggingEnabled() == false) goto L12;
            Log.v(BaseWifiTracker.access$000(this.this$0), "Issuing scan request from WifiScanner");
        L12:
            r1.startScan(r0, this.mFirstScanListener);
            BaseWifiTracker.access$1200(this.this$0);
            return;
        L14:
            Log.e(BaseWifiTracker.access$000(this.this$0), "Failed to retrieve WifiScanner!");
        L15:
            scanLoop();
        }

        private void stopScanning() {
            Log.i(BaseWifiTracker.access$000(this.this$0), "Scanning stopped");
            removeCallbacksAndMessages(null);
        }

        private void scanLoop() {
            if (shouldScan() == true) goto L7;
            Log.e(BaseWifiTracker.access$000(this.this$0), "Scan loop called even though we shouldn't be scanning! mIsWifiEnabled=" + this.mIsWifiEnabled + " mIsStartedState=" + this.mIsStartedState);
            return;
        L7:
            if (BaseWifiTracker.access$1300(this.this$0) == true) goto L11;
            Log.e(BaseWifiTracker.access$000(this.this$0), "Scan loop called even though app isn't visible anymore! mIsWifiEnabled=" + this.mIsWifiEnabled + " mIsStartedState=" + this.mIsStartedState);
            return;
        L11:
            if (this.this$0.isVerboseLoggingEnabled() == false) goto L13;
            Log.v(BaseWifiTracker.access$000(this.this$0), "Issuing scan request from WifiManager");
        L13:
            removeCallbacksAndMessages(null);
            this.this$0.mWifiManager.startScan();
            BaseWifiTracker.access$1200(this.this$0);
            postDelayed(new BaseWifiTracker$Scanner$$ExternalSyntheticLambda2(this), this.this$0.mScanIntervalMillis);
        }
    }

    class WifiTrackerLifecycleObserver implements LifecycleObserver {
        final /* synthetic */ BaseWifiTracker this$0;

        WifiTrackerLifecycleObserver(BaseWifiTracker r1) {
            this.this$0 = r1;
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public void onStart() {
            this.this$0.onStart();
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        public void onStop() {
            this.this$0.onStop();
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void onDestroy() {
            this.this$0.onDestroy();
        }
    }

    protected void handleConfiguredNetworksChangedAction(Intent r1) {
    }

    protected void handleConnectivityReportAvailable(ConnectivityDiagnosticsManager.ConnectivityReport r1) {
    }

    protected void handleDefaultNetworkCapabilitiesChanged(Network r1, NetworkCapabilities r2) {
    }

    protected void handleDefaultNetworkLost() {
    }

    protected void handleDefaultSubscriptionChanged(int r1) {
    }

    protected void handleHotspotNetworkConnectionStatusChanged(HotspotNetworkConnectionStatus r1) {
    }

    protected void handleHotspotNetworksUpdated(List<HotspotNetwork> r1) {
    }

    protected void handleKnownNetworkConnectionStatusChanged(KnownNetworkConnectionStatus r1) {
    }

    protected void handleKnownNetworksUpdated(List<KnownNetwork> r1) {
    }

    protected void handleLinkPropertiesChanged(Network r1, LinkProperties r2) {
    }

    protected void handleNetworkCapabilitiesChanged(Network r1, NetworkCapabilities r2) {
    }

    protected void handleNetworkLost(Network r1) {
    }

    protected void handleNetworkStateChangedAction(Intent r1) {
    }

    protected void handleOnStart() {
    }

    protected void handleRegisterCallbackFailed(Exception r1) {
    }

    protected void handleRssiChangedAction(Intent r1) {
    }

    protected void handleScanResultsAvailableAction(Intent r1) {
    }

    protected void handleServiceConnected() {
    }

    protected void handleServiceDisconnected() {
    }

    protected void handleSharedConnectivitySettingsChanged(SharedConnectivitySettingsState r1) {
    }

    protected void handleWifiStateChangedAction() {
    }

    static /* synthetic */ String access$000(BaseWifiTracker r0) {
        return r0.mTag;
    }

    static /* synthetic */ int access$100(BaseWifiTracker r0) {
        return r0.mWifiState;
    }

    static /* synthetic */ int access$102(BaseWifiTracker r0, int r1) {
        r0.mWifiState = r1;
        return r1;
    }

    static /* synthetic */ boolean access$1100(BaseWifiTracker r0) {
        return r0.mIsScanningDisabled;
    }

    static /* synthetic */ void access$1200(BaseWifiTracker r0) {
        r0.notifyOnScanRequested();
    }

    static /* synthetic */ boolean access$1300(BaseWifiTracker r0) {
        return r0.isAppVisible();
    }

    static /* synthetic */ Scanner access$200(BaseWifiTracker r0) {
        return r0.mScanner;
    }

    static /* synthetic */ void access$400(BaseWifiTracker r0) {
        r0.notifyOnWifiStateChanged();
    }

    public boolean isVerboseLoggingEnabled() {
        return this.mInjector.isVerboseLoggingEnabled();
    }

    private SharedConnectivityClientCallback createSharedConnectivityCallback() {
        return new AnonymousClass7(this);
    }

    BaseWifiTracker(WifiTrackerInjector r13, final Lifecycle r14, Context r15, WifiManager r16, ConnectivityManager r17, Handler r18, Handler r19, Clock r20, long r21, long r23, BaseWifiTrackerCallback r25, String r26) {
        final int r8 = 1;
        this.mWifiState = 1;
        this.mIsInitialized = false;
        this.mIsScanningDisabled = false;
        this.mBroadcastReceiver = new AnonymousClass1(this);
        this.mLifecycleObserver = new WifiTrackerLifecycleObserver(this);
        AnonymousClass1 r9 = null;
        this.mSharedConnectivityManager = null;
        this.mNetworkRequest = new NetworkRequest.Builder().clearCapabilities().addCapability(15).addTransportType(1).build();
        this.mNetworkCallback = new AnonymousClass2(this, r8);
        this.mDefaultNetworkCallback = new AnonymousClass3(this, r8);
        this.mConnectivityDiagnosticsCallback = new AnonymousClass4(this);
        this.mConnectivityDiagnosticsExecutor = new AnonymousClass5(this);
        this.mSharedConnectivityExecutor = new AnonymousClass6(this);
        this.mSharedConnectivityCallback = null;
        this.mInjector = r13;
        this.mActivityManager = (ActivityManager) r15.getSystemService(ActivityManager.class);
        this.mContext = r15;
        this.mWifiManager = r16;
        this.mConnectivityManager = r17;
        this.mConnectivityDiagnosticsManager = (ConnectivityDiagnosticsManager) r15.getSystemService(ConnectivityDiagnosticsManager.class);
        if (r13.isSharedConnectivityFeatureEnabled() == true) goto L5;
    L7:
        this.mMainHandler = r18;
        this.mWorkerHandler = r19;
        this.mMaxScanAgeMillis = r21;
        this.mScanIntervalMillis = r23;
        this.mListener = r25;
        this.mTag = r26;
        this.mScanResultUpdater = new ScanResultUpdater(r20, r21 + r23);
        this.mScanner = new Scanner(this, r19.getLooper(), r9);
        if (r14 == null) goto L11;
        r18.post(new BaseWifiTracker$$ExternalSyntheticLambda0(this, r14));
        return;
    L11:
        return;
    L5:
        if (BuildCompat.isAtLeastU() == false) goto L7;
        this.mSharedConnectivityManager = (SharedConnectivityManager) r15.getSystemService(SharedConnectivityManager.class);
        this.mSharedConnectivityCallback = createSharedConnectivityCallback();
        goto L7
    }

    /* JADX INFO: renamed from: lambda$new$0$com-android-wifitrackerlib-BaseWifiTracker, reason: not valid java name */
    /* synthetic */ void m853lambda$new$0$comandroidwifitrackerlibBaseWifiTracker(Lifecycle r1) {
        r1.addObserver(this.mLifecycleObserver);
    }

    public void disableScanning() {
        this.mIsScanningDisabled = true;
        this.mInjector.disableVerboseLogging();
    }

    public LifecycleObserver getLifecycleObserver() {
        return this.mLifecycleObserver;
    }

    public void onStart() {
        if (isVerboseLoggingEnabled() == false) goto L5;
        Log.v(this.mTag, "onStart");
    L5:
        Scanner.access$600(this.mScanner);
        this.mWorkerHandler.post(new BaseWifiTracker$$ExternalSyntheticLambda4(this));
    }

    /* JADX INFO: renamed from: lambda$onStart$1$com-android-wifitrackerlib-BaseWifiTracker, reason: not valid java name */
    /* synthetic */ void m854lambda$onStart$1$comandroidwifitrackerlibBaseWifiTracker() {
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        if (this.mIsScanningDisabled == true) goto L5;
        r0.addAction("android.net.wifi.SCAN_RESULTS");
    L5:
        r0.addAction("android.net.wifi.CONFIGURED_NETWORKS_CHANGE");
        r0.addAction("android.net.wifi.STATE_CHANGE");
        if (isVerboseLoggingEnabled() == false) goto L8;
        r0.addAction("android.net.wifi.RSSI_CHANGED");
    L8:
        r0.addAction("android.intent.action.ACTION_DEFAULT_DATA_SUBSCRIPTION_CHANGED");
        r0.setPriority(1000);
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mBroadcastReceiver, r0, null, this.mWorkerHandler);
        this.mConnectivityManager.registerNetworkCallback(this.mNetworkRequest, this.mNetworkCallback, this.mWorkerHandler);
        this.mConnectivityManager.registerDefaultNetworkCallback(this.mDefaultNetworkCallback, this.mWorkerHandler);
        this.mConnectivityDiagnosticsManager.registerConnectivityDiagnosticsCallback(this.mNetworkRequest, this.mConnectivityDiagnosticsExecutor, this.mConnectivityDiagnosticsCallback);
        if (this.mSharedConnectivityManager != null) goto L11;
    L15:
        handleOnStart();
        this.mIsInitialized = true;
        return;
    L11:
        if (this.mSharedConnectivityCallback == null) goto L15;
        if (BuildCompat.isAtLeastU() == false) goto L15;
        this.mSharedConnectivityManager.registerCallback(this.mSharedConnectivityExecutor, this.mSharedConnectivityCallback);
        goto L15
    }

    public void onStop() {
        if (isVerboseLoggingEnabled() == false) goto L5;
        Log.v(this.mTag, "onStop");
    L5:
        Scanner.access$700(this.mScanner);
        this.mWorkerHandler.post(new BaseWifiTracker$$ExternalSyntheticLambda1(this));
    }

    /* JADX INFO: renamed from: lambda$onStop$2$com-android-wifitrackerlib-BaseWifiTracker, reason: not valid java name */
    /* synthetic */ void m855lambda$onStop$2$comandroidwifitrackerlibBaseWifiTracker() {
        this.mContext.unregisterReceiver(this.mBroadcastReceiver);     // Catch: IllegalArgumentException -> L12
        this.mConnectivityManager.unregisterNetworkCallback(this.mNetworkCallback);     // Catch: IllegalArgumentException -> L12
        this.mConnectivityManager.unregisterNetworkCallback(this.mDefaultNetworkCallback);     // Catch: IllegalArgumentException -> L12
        this.mConnectivityDiagnosticsManager.unregisterConnectivityDiagnosticsCallback(this.mConnectivityDiagnosticsCallback);     // Catch: IllegalArgumentException -> L12
        if (this.mSharedConnectivityManager != null) goto L5;
        return;
    L5:
        if (this.mSharedConnectivityCallback != null) goto L7;
        return;
    L7:
        if (BuildCompat.isAtLeastU() == true) goto L9;
        return;
    L9:
        if (this.mSharedConnectivityManager.unregisterCallback(this.mSharedConnectivityCallback) == true) goto L18;
        Log.e(this.mTag, "onStop: unregisterCallback failed");     // Catch: IllegalArgumentException -> L12
        return;
    L18:
        return;
    }

    public void onDestroy() {
        this.mContext.unregisterReceiver(this.mBroadcastReceiver);     // Catch: IllegalArgumentException -> L12
        this.mConnectivityManager.unregisterNetworkCallback(this.mNetworkCallback);     // Catch: IllegalArgumentException -> L12
        this.mConnectivityManager.unregisterNetworkCallback(this.mDefaultNetworkCallback);     // Catch: IllegalArgumentException -> L12
        this.mConnectivityDiagnosticsManager.unregisterConnectivityDiagnosticsCallback(this.mConnectivityDiagnosticsCallback);     // Catch: IllegalArgumentException -> L12
        if (this.mSharedConnectivityManager != null) goto L5;
        return;
    L5:
        if (this.mSharedConnectivityCallback != null) goto L7;
        return;
    L7:
        if (BuildCompat.isAtLeastU() == true) goto L9;
        return;
    L9:
        if (this.mSharedConnectivityManager.unregisterCallback(this.mSharedConnectivityCallback) == true) goto L18;
        Log.e(this.mTag, "onDestroyed: unregisterCallback failed");     // Catch: IllegalArgumentException -> L12
        return;
    L18:
        return;
    }

    boolean isInitialized() {
        return this.mIsInitialized;
    }

    public int getWifiState() {
        return this.mWifiState;
    }

    private boolean isAppVisible() {
        ActivityManager.RunningAppProcessInfo r1 = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(r1);
        if (r1.importance > 200) goto L5;
        return true;
    L5:
        return false;
    }

    private void notifyOnWifiStateChanged() {
        final BaseWifiTrackerCallback r0 = this.mListener;
        if (r0 == null) goto L6;
        Handler r2 = this.mMainHandler;
        Objects.requireNonNull(r0);
        r2.post(new BaseWifiTracker$$ExternalSyntheticLambda3(r0));
        return;
    }

    private void notifyOnScanRequested() {
        final BaseWifiTrackerCallback r0 = this.mListener;
        if (r0 == null) goto L6;
        Handler r2 = this.mMainHandler;
        Objects.requireNonNull(r0);
        r2.post(new BaseWifiTracker$$ExternalSyntheticLambda2(r0));
        return;
    }
}
