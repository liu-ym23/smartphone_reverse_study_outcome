package com.android.settings.wifi.assistant;

import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.net.TransportInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiNetworkSpecifier;
import com.android.settings.SettingsApplication;
import com.obric.olog.OLog;
import cz.msebera.android.httpclient.message.TokenParser;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SecondaryNetworkCallback.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/android/settings/wifi/assistant/SecondaryNetworkCallback;", "Landroid/net/ConnectivityManager$NetworkCallback;", "brand", "", "(I)V", "getBrand", "()I", "onAvailable", "", "network", "Landroid/net/Network;", "onBlockedStatusChanged", "blocked", "", "onCapabilitiesChanged", "networkCapabilities", "Landroid/net/NetworkCapabilities;", "onLinkPropertiesChanged", "linkProperties", "Landroid/net/LinkProperties;", "onLosing", "maxMsToLive", "onLost", "onUnavailable", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SecondaryNetworkCallback extends ConnectivityManager.NetworkCallback {
    public static final Companion Companion = null;
    private static final String TAG = null;
    private static Network network;
    private static WifiInfo wifiInfo;
    private final int brand;

    /* JADX INFO: compiled from: SecondaryNetworkCallback.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/android/settings/wifi/assistant/SecondaryNetworkCallback$Companion;", "", "()V", "TAG", "", "network", "Landroid/net/Network;", "getNetwork", "()Landroid/net/Network;", "setNetwork", "(Landroid/net/Network;)V", "wifiInfo", "Landroid/net/wifi/WifiInfo;", "getWifiInfo", "()Landroid/net/wifi/WifiInfo;", "setWifiInfo", "(Landroid/net/wifi/WifiInfo;)V", "registerSecondaryNetworkCallback", "Lcom/android/settings/wifi/assistant/SecondaryNetworkCallback;", "Landroid/net/ConnectivityManager;", "brand", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final WifiInfo getWifiInfo() {
            return SecondaryNetworkCallback.access$getWifiInfo$cp();
        }

        public final void setWifiInfo(WifiInfo r1) {
            SecondaryNetworkCallback.access$setWifiInfo$cp(r1);
        }

        public final Network getNetwork() {
            return SecondaryNetworkCallback.access$getNetwork$cp();
        }

        public final void setNetwork(Network r1) {
            SecondaryNetworkCallback.access$setNetwork$cp(r1);
        }

        public final SecondaryNetworkCallback registerSecondaryNetworkCallback(ConnectivityManager r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "<this>");
            WifiNetworkSpecifier.Builder r2 = new WifiNetworkSpecifier.Builder();
            r2.setBand(r4);
            WifiNetworkSpecifier r5 = r2.build();
            Intrinsics.checkNotNullExpressionValue(r5, "build(...)");
            NetworkRequest r6 = new NetworkRequest.Builder().clearCapabilities().addCapability(12).addTransportType(1).setNetworkSpecifier(r5).build();
            SecondaryNetworkCallback r0 = new SecondaryNetworkCallback(r4);
            r3.registerNetworkCallback(r6, new SecondaryNetworkCallback(r4));
            OLog.d(SecondaryNetworkCallback.access$getTAG$cp(), "registerNetworkCallback " + r4);
            return r0;
        }
    }

    public SecondaryNetworkCallback(int r2) {
        super(1);
        this.brand = r2;
    }

    public static final /* synthetic */ Network access$getNetwork$cp() {
        return network;
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return TAG;
    }

    public static final /* synthetic */ WifiInfo access$getWifiInfo$cp() {
        return wifiInfo;
    }

    public static final /* synthetic */ void access$setNetwork$cp(Network r0) {
        network = r0;
    }

    public static final /* synthetic */ void access$setWifiInfo$cp(WifiInfo r0) {
        wifiInfo = r0;
    }

    public final int getBrand() {
        return this.brand;
    }

    static {
        Companion = new Companion(null);
        TAG = "SecondaryNetworkCallbac";
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network r4) {
        Intrinsics.checkNotNullParameter(r4, "network");
        super.onAvailable(r4);
        String r3 = TAG;
        OLog.d(r3, "onAvailable");
        ConnectivityManager r0 = (ConnectivityManager) SettingsApplication.getContext().getSystemService(ConnectivityManager.class);
        if (r0 == null) goto L5;
        NetworkCapabilities r5 = r0.getNetworkCapabilities(r4);
    L6:
        if (r5 == null) goto L11;
        TransportInfo r6 = r5.getTransportInfo();
        if ((r6 instanceof WifiInfo) == false) goto L12;
        WifiInfo r1 = (WifiInfo) r6;
        OLog.d(r3, "onAvailable ssid=" + r1.getSSID() + " bssid=" + r1.getBSSID() + TokenParser.SP + r6);
        wifiInfo = r1;
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLosing(Network r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "network");
        super.onLosing(r2, r3);
        OLog.d(TAG, "onLosing");
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network r2) {
        Intrinsics.checkNotNullParameter(r2, "network");
        super.onLost(r2);
        OLog.d(TAG, "onLost");
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onUnavailable() {
        super.onUnavailable();
        OLog.d(TAG, "onUnavailable");
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network r3, NetworkCapabilities r4) {
        Intrinsics.checkNotNullParameter(r3, "network");
        Intrinsics.checkNotNullParameter(r4, "networkCapabilities");
        super.onCapabilitiesChanged(r3, r4);
        String r2 = TAG;
        OLog.d(r2, "onCapabilitiesChanged");
        if (r4.hasTransport(1) == false) goto L8;
        TransportInfo r5 = r4.getTransportInfo();
        if ((r5 instanceof WifiInfo) == false) goto L9;
        WifiInfo r0 = (WifiInfo) r5;
        OLog.d(r2, "onCapabilitiesChanged macAddress=" + r0.getMacAddress() + " bssid=" + r0.getBSSID() + TokenParser.SP + r5);
        wifiInfo = r0;
        return;
    L9:
        return;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLinkPropertiesChanged(Network r3, LinkProperties r4) {
        Intrinsics.checkNotNullParameter(r3, "network");
        Intrinsics.checkNotNullParameter(r4, "linkProperties");
        super.onLinkPropertiesChanged(r3, r4);
        OLog.d(TAG, "onLinkPropertiesChanged " + r4.getLinkAddresses());
        network = r3;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onBlockedStatusChanged(Network r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "network");
        super.onBlockedStatusChanged(r2, r3);
        OLog.d(TAG, "onBlockedStatusChanged");
    }
}
