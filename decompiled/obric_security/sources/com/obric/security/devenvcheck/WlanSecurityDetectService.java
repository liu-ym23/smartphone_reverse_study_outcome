package com.obric.security.devenvcheck;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.net.TransportInfo;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.provider.Settings;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.devenvcheck.checker.TmsWifiSecurityChecker;
import com.obric.devenvcheck.checker.WifiSecurityCheckResult;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: WlanSecurityDetectService.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u0000 I2\u00020\u0001:\u0002IJB\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010 \u001a\u0004\u0018\u00010\f2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\u001a\u0010*\u001a\u0004\u0018\u00010\"2\u0006\u0010$\u001a\u00020%2\u0006\u0010+\u001a\u00020,H\u0002J\u0018\u0010-\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u000201H\u0002J\u0014\u00102\u001a\u0004\u0018\u00010\f2\b\u00103\u001a\u0004\u0018\u00010\fH\u0002J\u0014\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u0010\u00108\u001a\u00020'2\u0006\u00106\u001a\u000207H\u0002J\b\u00109\u001a\u00020'H\u0016J\b\u0010:\u001a\u00020'H\u0016J\b\u0010;\u001a\u00020'H\u0002J\"\u0010<\u001a\u00020=2\b\u00106\u001a\u0004\u0018\u0001072\u0006\u0010>\u001a\u00020=2\u0006\u0010?\u001a\u00020=H\u0016J\u0010\u0010@\u001a\u00020'2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010A\u001a\u00020'2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010B\u001a\u0002012\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010C\u001a\u00020'H\u0002J\b\u0010D\u001a\u00020'H\u0002J\b\u0010E\u001a\u00020'H\u0002J\b\u0010F\u001a\u00020'H\u0002J \u0010G\u001a\u00020'2\u0006\u00103\u001a\u00020\f2\u0006\u0010H\u001a\u00020\f2\u0006\u0010.\u001a\u00020/H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001a0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/obric/security/devenvcheck/WlanSecurityDetectService;", "Landroid/app/Service;", "()V", "configChangeReceiver", "Landroid/content/BroadcastReceiver;", "connectivityManager", "Landroid/net/ConnectivityManager;", "getConnectivityManager", "()Landroid/net/ConnectivityManager;", "connectivityManager$delegate", "Lkotlin/Lazy;", "currentNetwork", "", "detectDelayMs", "", "detectedKeys", "Ljava/util/concurrent/ConcurrentHashMap;", "executor", "Ljava/util/concurrent/ExecutorService;", "lastNotReadyLog", "mainHandler", "Landroid/os/Handler;", "networkCallback", "Landroid/net/ConnectivityManager$NetworkCallback;", "notifiedNetwork", "runnableCache", "Ljava/lang/Runnable;", "settingsObserver", "Landroid/database/ContentObserver;", "workHandler", "workThread", "Landroid/os/HandlerThread;", "buildWifiKey", "wifiInfo", "Landroid/net/wifi/WifiInfo;", "detectRunnableFor", "network", "Landroid/net/Network;", "doDetect", "", "task", "Lcom/obric/security/devenvcheck/WlanSecurityDetectService$WifiTask;", "extractWifiInfo", "capabilities", "Landroid/net/NetworkCapabilities;", "handleResult", "result", "Lcom/obric/devenvcheck/checker/WifiSecurityCheckResult;", "isWlanSecurityDetectEnabled", "", "normalizeSsid", "ssid", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onConfiguredNetworksChanged", "onCreate", "onDestroy", "onDetectSwitchChanged", "onStartCommand", "", "flags", "startId", "onWifiConnected", "onWifiLost", "prepareDetect", "redetectActiveNetworks", "registerConfigChangeReceiver", "registerSettingsObserver", "registerWifiNetworkCallback", "showRiskPrompt", "bssid", "Companion", "WifiTask", "devenvcheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class WlanSecurityDetectService extends Service {
    private static final Companion Companion = null;

    @Deprecated
    private static final String SETTINGS_KEY_WLAN_SECURITY_CHECK = "wlan_security_check";

    @Deprecated
    private static final String TAG = "WlanWifiCheck";
    private BroadcastReceiver configChangeReceiver;
    private final Lazy connectivityManager$delegate;
    private volatile String currentNetwork;
    private final long detectDelayMs;
    private final ConcurrentHashMap<String, String> detectedKeys;
    private final ExecutorService executor;
    private volatile String lastNotReadyLog;
    private final Handler mainHandler;
    private ConnectivityManager.NetworkCallback networkCallback;
    private volatile String notifiedNetwork;
    private final ConcurrentHashMap<String, Runnable> runnableCache;
    private ContentObserver settingsObserver;
    private final Handler workHandler;
    private final HandlerThread workThread;

    /* JADX INFO: compiled from: WlanSecurityDetectService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/security/devenvcheck/WlanSecurityDetectService$Companion;", "", "()V", "SETTINGS_KEY_WLAN_SECURITY_CHECK", "", "TAG", "devenvcheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: compiled from: WlanSecurityDetectService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/obric/security/devenvcheck/WlanSecurityDetectService$WifiTask;", "", "network", "Landroid/net/Network;", "(Landroid/net/Network;)V", "<set-?>", "", "bssid", "getBssid", "()Ljava/lang/String;", "key", "getKey", "getNetwork", "()Landroid/net/Network;", "ssid", "getSsid", "bind", "", "isNeedPrompt", "", "context", "Landroid/content/Context;", "devenvcheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class WifiTask {
        private String bssid;
        private final Network network;
        private String ssid;

        public WifiTask(Network r2) {
            Intrinsics.checkNotNullParameter(r2, "network");
            this.network = r2;
        }

        public final Network getNetwork() {
            return this.network;
        }

        public final String getSsid() {
            return this.ssid;
        }

        public final String getBssid() {
            return this.bssid;
        }

        public final String getKey() {
            String r0 = this.ssid;
            if (r0 != null) goto L5;
            return null;
        L5:
            String r2 = this.bssid;
            if (r2 != null) goto L9;
            return null;
        L9:
            return r2 + "|" + r0;
        }

        public final void bind(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "ssid");
            Intrinsics.checkNotNullParameter(r3, "bssid");
            this.ssid = r2;
            this.bssid = r3;
        }

        public final boolean isNeedPrompt(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            String r1 = getKey();
            if (r1 != null) goto L7;
            return false;
        L7:
            return !WlanTrustStore.INSTANCE.isTrusted(r2, r1);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static final /* synthetic */ Companion access$Companion() {
        return Companion;
    }

    private final ConnectivityManager getConnectivityManager() {
        return (ConnectivityManager) this.connectivityManager$delegate.getValue();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r1) {
        return null;
    }

    public WlanSecurityDetectService() {
        HandlerThread r0 = new HandlerThread("wlan-security-detect");
        r0.start();
        Unit r1 = Unit.INSTANCE;
        this.workThread = r0;
        this.workHandler = new Handler(r0.getLooper());
        this.mainHandler = new Handler(Looper.getMainLooper());
        ExecutorService r2 = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(r2, "Executors.newSingleThreadExecutor()");
        this.executor = r2;
        this.connectivityManager$delegate = LazyKt.lazy(new WlanSecurityDetectService$connectivityManager$2(this));
        this.runnableCache = new ConcurrentHashMap();
        this.detectedKeys = new ConcurrentHashMap();
        this.detectDelayMs = WsConstants.EXIT_DELAY_TIME;
    }

    public static final /* synthetic */ void access$doDetect(WlanSecurityDetectService r0, WifiTask r1) {
        r0.doDetect(r1);
    }

    public static final /* synthetic */ ExecutorService access$getExecutor$p(WlanSecurityDetectService r0) {
        return r0.executor;
    }

    public static final /* synthetic */ String access$getLastNotReadyLog$p(WlanSecurityDetectService r0) {
        return r0.lastNotReadyLog;
    }

    public static final /* synthetic */ ConcurrentHashMap access$getRunnableCache$p(WlanSecurityDetectService r0) {
        return r0.runnableCache;
    }

    public static final /* synthetic */ void access$handleResult(WlanSecurityDetectService r0, WifiTask r1, WifiSecurityCheckResult r2) {
        r0.handleResult(r1, r2);
    }

    public static final /* synthetic */ void access$onConfiguredNetworksChanged(WlanSecurityDetectService r0, Intent r1) {
        r0.onConfiguredNetworksChanged(r1);
    }

    public static final /* synthetic */ void access$onDetectSwitchChanged(WlanSecurityDetectService r0) {
        r0.onDetectSwitchChanged();
    }

    public static final /* synthetic */ void access$onWifiConnected(WlanSecurityDetectService r0, Network r1) {
        r0.onWifiConnected(r1);
    }

    public static final /* synthetic */ void access$onWifiLost(WlanSecurityDetectService r0, Network r1) {
        r0.onWifiLost(r1);
    }

    public static final /* synthetic */ void access$setLastNotReadyLog$p(WlanSecurityDetectService r0, String r1) {
        r0.lastNotReadyLog = r1;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        OLog.d("WlanWifiCheck", "Service onCreate");
        registerWifiNetworkCallback();
        registerConfigChangeReceiver();
        registerSettingsObserver();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r1, int r2, int r3) {
        OLog.d("WlanWifiCheck", "Service onStartCommand: flags=" + r2 + ", startId=" + r3);
        return 1;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        OLog.d("WlanWifiCheck", "Service onDestroy");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        WlanSecurityDetectService r2 = this;     // Catch: Throwable -> L11
        ConnectivityManager.NetworkCallback r3 = this.networkCallback;     // Catch: Throwable -> L11
        if (r3 == null) goto L8;
        ConnectivityManager r4 = getConnectivityManager();     // Catch: Throwable -> L11
        if (r4 == null) goto L8;
        r4.unregisterNetworkCallback(r3);     // Catch: Throwable -> L11
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        Result.m774constructorimpl(r5);     // Catch: Throwable -> L11
    L13:
        ConnectivityManager.NetworkCallback r6 = (ConnectivityManager.NetworkCallback) null;
        this.networkCallback = null;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L20
        WlanSecurityDetectService r8 = this;     // Catch: Throwable -> L20
        BroadcastReceiver r9 = this.configChangeReceiver;     // Catch: Throwable -> L20
        if (r9 == null) goto L17;
        unregisterReceiver(r9);     // Catch: Throwable -> L20
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L20
    L18:
        Result.m774constructorimpl(r10);     // Catch: Throwable -> L20
    L22:
        BroadcastReceiver r11 = (BroadcastReceiver) null;
        this.configChangeReceiver = null;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L29
        WlanSecurityDetectService r13 = this;     // Catch: Throwable -> L29
        ContentObserver r14 = this.settingsObserver;     // Catch: Throwable -> L29
        if (r14 == null) goto L26;
        getContentResolver().unregisterContentObserver(r14);     // Catch: Throwable -> L29
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L29
    L27:
        Result.m774constructorimpl(r15);     // Catch: Throwable -> L29
    L31:
        ContentObserver r16 = (ContentObserver) null;
        this.settingsObserver = null;
        this.workHandler.removeCallbacksAndMessages(null);
        this.mainHandler.removeCallbacksAndMessages(null);
        this.workThread.quitSafely();
        this.runnableCache.clear();
        this.detectedKeys.clear();
        String r17 = (String) null;
        this.notifiedNetwork = null;
        this.currentNetwork = null;
        this.executor.shutdownNow();
        return;
    L26:
        r15 = null;
    L29:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L31
    L17:
        r10 = null;
    L20:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        Result.m774constructorimpl(ResultKt.createFailure(th));
    L8:
        r5 = null;
    L11:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    private final void registerWifiNetworkCallback() {
        ConnectivityManager r0 = getConnectivityManager();
        if (r0 != null) goto L6;
        OLog.w("WlanWifiCheck", "registerWifiNetworkCallback: ConnectivityManager unavailable");
        return;
    L6:
        NetworkRequest r2 = new NetworkRequest.Builder().addTransportType(1).build();
        ConnectivityManager.NetworkCallback r3 = new WlanSecurityDetectService$registerWifiNetworkCallback$callback$1(this);
        this.networkCallback = r3;
        r0.registerNetworkCallback(r2, r3, this.workHandler);
        OLog.d("WlanWifiCheck", "registerWifiNetworkCallback: registered");
    }

    private final void onWifiConnected(Network r7) {
        String r0 = r7.toString();
        Intrinsics.checkNotNullExpressionValue(r0, "network.toString()");
        if (Intrinsics.areEqual(this.currentNetwork, r0) == false) goto L5;
        return;
    L5:
        this.currentNetwork = r0;
        if (this.detectedKeys.containsKey(r0) == false) goto L8;
        return;
    L8:
        if (this.runnableCache.containsKey(r0) == true) goto L23;
        OLog.d("WlanWifiCheck", "onWifiConnected=====");
        if (isWlanSecurityDetectEnabled() == true) goto L14;
        OLog.d("WlanWifiCheck", "onWifiConnected: detect disabled, skip. network=" + r7);
        return;
    L14:
        OLog.d("WlanWifiCheck", "onWifiConnected: network=" + r7 + ", scheduled in " + this.detectDelayMs + "ms");
        ConcurrentHashMap<String, Runnable> r1 = this.runnableCache;
        Runnable r2 = r1.get(r0);
        if (r2 != null) goto L20;
        Runnable r8 = detectRunnableFor(r7);
        Runnable r3 = r1.putIfAbsent(r0, r8);
        if (r3 != null) goto L19;
        r2 = r8;
        goto L20
    L19:
        r2 = r3;
    L20:
        Runnable r4 = r2;
        this.workHandler.removeCallbacks(r4);
        this.workHandler.postDelayed(r4, this.detectDelayMs);
        return;
    }

    private final void onWifiLost(Network r5) {
        OLog.d("WlanWifiCheck", "onWifiLost: network=" + r5);
        if (Intrinsics.areEqual(this.currentNetwork, r5.toString()) == false) goto L5;
        String r0 = (String) null;
        this.currentNetwork = null;
    L5:
        Runnable r1 = this.runnableCache.remove(r5.toString());
        if (r1 == null) goto L8;
        this.workHandler.removeCallbacks(r1);
    L8:
        this.detectedKeys.remove(r5.toString());
        if (Intrinsics.areEqual(this.notifiedNetwork, r5.toString()) == false) goto L12;
        OLog.d("WlanWifiCheck", "onWifiLost: cancel risk notification for lost network=" + r5);
        String r6 = (String) null;
        this.notifiedNetwork = null;
        WlanRiskNotifier r7 = WlanRiskNotifier.INSTANCE;
        Context r4 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r4, "applicationContext");
        r7.cancel(r4);
        return;
    }

    private final void registerConfigChangeReceiver() {
        BroadcastReceiver r1 = new WlanSecurityDetectService$registerConfigChangeReceiver$receiver$1(this);
        this.configChangeReceiver = r1;
        IntentFilter r2 = new IntentFilter("android.net.wifi.CONFIGURED_NETWORKS_CHANGE");
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L5
        WlanSecurityDetectService r4 = this;     // Catch: Throwable -> L5
        registerReceiver(r1, r2);     // Catch: Throwable -> L5
        OLog.d("WlanWifiCheck", "registerConfigChangeReceiver: registered");     // Catch: Throwable -> L5
        Object r5 = Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r6 = Result.m777exceptionOrNullimpl(r5);
        if (r6 == null) goto L13;
        OLog.w("WlanWifiCheck", "registerConfigChangeReceiver failed", r6);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final void onConfiguredNetworksChanged(Intent r5) {
        int r0 = r5.getIntExtra("changeReason", -1);
        OLog.d("WlanWifiCheck", "onConfiguredNetworksChanged: reason=" + r0);
        if (r0 == 1) goto L6;
        return;
    L6:
        if (r5.getBooleanExtra("multipleChanges", false) == false) goto L9;
        OLog.d("WlanWifiCheck", "onConfiguredNetworksChanged: multiple changed, skip");
        return;
    L9:
        WifiConfiguration r6 = (WifiConfiguration) r5.getParcelableExtra("wifiConfiguration");
        if (r6 != null) goto L13;
        OLog.d("WlanWifiCheck", "onConfiguredNetworksChanged: no config, skip");
        return;
    L13:
        String r1 = WifiInfoUtils.INSTANCE.unquoteSsid(r6.SSID);
        if (r1 != null) goto L17;
        OLog.d("WlanWifiCheck", "onConfiguredNetworksChanged: invalid ssid=" + r6.SSID + ", skip");
        return;
    L17:
        OLog.d("WlanWifiCheck", "onConfiguredNetworksChanged: forgot network ssid=" + r1 + " bssid=" + r6.BSSID + ", clear trusted & result");
        WlanTrustStore r7 = WlanTrustStore.INSTANCE;
        Context r4 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r4, "applicationContext");
        r7.removeTrustedBySsid(r4, r1);
    }

    private final void registerSettingsObserver() {
        final Handler r2 = this.workHandler;
        ContentObserver r1 = new WlanSecurityDetectService$registerSettingsObserver$observer$1(this, r2);
        this.settingsObserver = r1;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L5
        WlanSecurityDetectService r4 = this;     // Catch: Throwable -> L5
        getContentResolver().registerContentObserver(Settings.Global.getUriFor(SETTINGS_KEY_WLAN_SECURITY_CHECK), false, r1);     // Catch: Throwable -> L5
        OLog.d("WlanWifiCheck", "registerSettingsObserver: registered");     // Catch: Throwable -> L5
        Object r5 = Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r6 = Result.m777exceptionOrNullimpl(r5);
        if (r6 == null) goto L13;
        OLog.w("WlanWifiCheck", "registerSettingsObserver failed", r6);
        ContentObserver r7 = (ContentObserver) null;
        this.settingsObserver = null;
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r5 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final void onDetectSwitchChanged() {
        boolean r0 = isWlanSecurityDetectEnabled();
        OLog.d("WlanWifiCheck", "onDetectSwitchChanged: enabled=" + r0);
        if (r0 == false) goto L6;
        redetectActiveNetworks();
        return;
    }

    private final void redetectActiveNetworks() {
        WifiInfoUtils r0 = WifiInfoUtils.INSTANCE;
        Context r1 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r1, "applicationContext");
        if (r0.getCurrentWifiInfo(r1) != null) goto L6;
        OLog.d("WlanWifiCheck", "redetectActiveNetworks: no active wifi, skip");
        return;
    L6:
        ConnectivityManager r2 = getConnectivityManager();
        if (r2 == null) goto L13;
        Network r3 = r2.getActiveNetwork();
        if (r3 == null) goto L14;
        Intrinsics.checkNotNullExpressionValue(r3, "connectivityManager?.activeNetwork ?: return");
        OLog.d("WlanWifiCheck", "redetectActiveNetworks: network=" + r3);
        this.detectedKeys.remove(r3.toString());
        String r4 = (String) null;
        this.currentNetwork = null;
        onWifiConnected(r3);
        return;
    L14:
        return;
    }

    private final Runnable detectRunnableFor(final Network r2) {
        return new AnonymousClass1(this, r2);
    }

    private final void doDetect(final WifiTask r8) {
        OLog.d("WlanWifiCheck", "doDetect: start. network=" + r8.getNetwork());
        if (prepareDetect(r8) == true) goto L5;
        return;
    L5:
        final WifiSecurityCheckResult r0 = new TmsWifiSecurityChecker().checkCurrentWifi();
        OLog.d("WlanWifiCheck", "doDetect: result isSafe=" + r0.isSafe() + ", risks=" + r0.getRiskReasons() + ", key=" + r8.getKey());
        this.mainHandler.post(new RunnableC03671(this, r8, r0));
    }

    private final boolean prepareDetect(WifiTask r7) {
        Network r0 = r7.getNetwork();
        ConnectivityManager r1 = getConnectivityManager();
        String r2 = null;
        if (r1 == null) goto L5;
        NetworkCapabilities r3 = r1.getNetworkCapabilities(r0);
    L6:
        if (r3 == null) goto L8;
        WifiInfo r4 = extractWifiInfo(r0, r3);
    L9:
        String r5 = buildWifiKey(r4);
        if (r4 == null) goto L12;
        String r6 = r4.getSSID();
    L13:
        String r8 = normalizeSsid(r6);
        if (r4 == null) goto L17;
        r2 = r4.getBSSID();
    L17:
        if (r5 == null) goto L31;
        if (r8 == null) goto L31;
        if (r2 == null) goto L31;
        r7.bind(r8, r2);
        if (r7.isNeedPrompt(this) == true) goto L25;
        OLog.d("WlanWifiCheck", "prepareDetect: wifi trusted, skip. key=" + r5);
        return false;
    L25:
        String r9 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r9, "network.toString()");
        if (Intrinsics.areEqual(this.detectedKeys.get(r9), r5) == false) goto L29;
        OLog.d("WlanWifiCheck", "prepareDetect: already detected in this connection, skip. key=" + r5);
        return false;
    L29:
        this.detectedKeys.put(r9, r5);
        OLog.d("WlanWifiCheck", "prepareDetect: pass, will detect. key=" + r5);
        return true;
    L31:
        OLog.d("WlanWifiCheck", "prepareDetect: wifiInfo not ready, skip. network=" + r0);
        return false;
    L12:
        r6 = null;
        goto L13
    L8:
        r4 = null;
        goto L9
    L5:
        r3 = null;
        goto L6
    }

    private final void handleResult(WifiTask r12, WifiSecurityCheckResult r13) {
        String r6 = r12.getSsid();
        if (r6 != null) goto L5;
        return;
    L5:
        String r7 = r12.getBssid();
        if (r7 != null) goto L8;
        return;
    L8:
        WifiInfoUtils r0 = WifiInfoUtils.INSTANCE;
        Context r1 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r1, "applicationContext");
        WifiInfoUtils.WifiInfoResult r2 = r0.getCurrentWifiInfo(r1);
        if (r2 != null) goto L11;
    L19:
        OLog.d("WlanWifiCheck", "handleResult: current wifi changed (current=" + r2 + "), drop result. key=" + r12.getKey());
        return;
    L11:
        if (StringsKt.equals(r2.getBssid(), r7, true) == false) goto L19;
        OLog.d("WlanWifiCheck", "handleResult: saveResult & sendRisk. key=" + r12.getKey() + ", isSafe=" + r13.isSafe());
        WlanCheckResultProvider.Companion r3 = WlanCheckResultProvider.Companion;
        Context r4 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r4, "applicationContext");
        r3.saveResult(r4, r13.isSafe(), r6, r7, r13.getRiskReasons());
        WlanRiskBroadcaster r5 = WlanRiskBroadcaster.INSTANCE;
        Context r8 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r8, "applicationContext");
        r5.sendRisk(r8, r6, r7, r13.getRiskReasons());
        if ((!r13.getRiskReasons().isEmpty()) == true) goto L17;
        OLog.d("WlanWifiCheck", "handleResult: skip prompt (safe). key=" + r12.getKey());
        return;
    L17:
        WlanRiskNotifier r9 = WlanRiskNotifier.INSTANCE;
        Context r10 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r10, "applicationContext");
        r9.showRiskNotification(r10, r6);
        this.notifiedNetwork = r12.getNetwork().toString();
        showRiskPrompt(r6, r7, r13);
    }

    private final void showRiskPrompt(String r4, String r5, WifiSecurityCheckResult r6) {
        OLog.d("WlanWifiCheck", "showRiskPrompt: start activity. ssid=" + r4 + ", risks=" + r6.getRiskReasons());
        Intent r0 = new Intent(this, WlanSecurityRiskPromptActivity.class);
        r0.addFlags(268435456);
        r0.putExtra(WlanSecurityRiskPromptActivity.EXTRA_SSID, r4);
        r0.putExtra(WlanSecurityRiskPromptActivity.EXTRA_BSSID, r5);
        r0.putExtra(WlanSecurityRiskPromptActivity.EXTRA_IS_SAFE, r6.isSafe());
        r0.putStringArrayListExtra(WlanSecurityRiskPromptActivity.EXTRA_RISKS, new ArrayList(r6.getRiskReasons()));
        startActivity(r0);
    }

    private final boolean isWlanSecurityDetectEnabled() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        WlanSecurityDetectService r1 = this;     // Catch: Throwable -> L4
        Object r3 = Result.m774constructorimpl(Settings.Global.getString(getContentResolver(), SETTINGS_KEY_WLAN_SECURITY_CHECK));     // Catch: Throwable -> L4
    L7:
        if (Result.m780isFailureimpl(r3) == false) goto L9;
        r3 = null;
    L9:
        String r4 = (String) r3;
        if (r4 != null) goto L12;
    L15:
        boolean r2 = true;
    L16:
        OLog.d("WlanWifiCheck", "isWlanSecurityDetectEnabled: value=" + r4 + ", enabled=" + r2);
        return r2;
    L12:
        if (Intrinsics.areEqual(r4, "1") == true) goto L15;
        r2 = false;
    L4:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final WifiInfo extractWifiInfo(Network r3, NetworkCapabilities r4) {
        if (Build.VERSION.SDK_INT < 31) goto L12;
        TransportInfo r5 = r4.getTransportInfo();
        if ((r5 instanceof WifiInfo) == true) goto L7;
        r5 = null;
    L7:
        WifiInfo r6 = (WifiInfo) r5;
        if (r6 == null) goto L12;
        if (normalizeSsid(r6.getSSID()) == null) goto L12;
        return r6;
    L12:
        WifiManager r2 = (WifiManager) getSystemService(WifiManager.class);
        if (r2 != null) goto L15;
        return null;
    L15:
        return r2.getConnectionInfo();
    }

    private final String buildWifiKey(WifiInfo r5) {
        if (r5 == null) goto L5;
        String r1 = r5.getSSID();
    L6:
        String r4 = normalizeSsid(r1);
        if (r5 == null) goto L9;
        String r2 = r5.getBSSID();
    L10:
        if (r5 == null) goto L12;
        SupplicantState r6 = r5.getSupplicantState();
    L14:
        if (r6 == SupplicantState.COMPLETED) goto L16;
        return null;
    L16:
        String r7 = r2;
        boolean r3 = false;
        if (r7 != null) goto L19;
    L22:
        boolean r8 = true;
    L23:
        if (r8 == false) goto L25;
        return null;
    L25:
        String r9 = r4;
        if (r9 != null) goto L28;
    L29:
        r3 = true;
    L30:
        if (r3 == false) goto L33;
        return null;
    L33:
        return r2 + "|" + r4;
    L28:
        if (StringsKt.isBlank(r9) == false) goto L30;
    L19:
        if (StringsKt.isBlank(r7) == true) goto L22;
        r8 = false;
        goto L23
    L12:
        r6 = null;
        goto L14
    L9:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    private final String normalizeSsid(String r6) {
        String r5 = r6;
        if (r5 != null) goto L5;
    L8:
        boolean r7 = true;
    L9:
        String r2 = null;
        if (r7 == false) goto L12;
        return null;
    L12:
        if (Intrinsics.areEqual(r6, "<unknown ssid>") == false) goto L15;
        return null;
    L15:
        if (r6.length() >= 2) goto L17;
    L21:
        String r8 = r6;
        if (StringsKt.isBlank(r8) == true) goto L26;
        r2 = r8;
    L26:
        return r2;
    L17:
        if (StringsKt.startsWith$default(r6, "\"", false, 2, null) == false) goto L21;
        if (StringsKt.endsWith$default(r6, "\"", false, 2, null) == false) goto L21;
        r6 = r6.substring(1, r6.length() - 1);
        Intrinsics.checkNotNullExpressionValue(r6, "this as java.lang.String…ing(startIndex, endIndex)");
        goto L21
    L5:
        if (StringsKt.isBlank(r5) == true) goto L8;
        r7 = false;
        goto L9
    }
}
