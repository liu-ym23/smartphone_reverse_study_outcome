package com.android.wifitrackerlib;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.sharedconnectivity.app.KnownNetwork;
import android.net.wifi.sharedconnectivity.app.SharedConnectivityManager;
import android.os.Handler;
import android.text.BidiFormatter;
import com.android.settingslib.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class KnownNetworkEntry extends StandardWifiEntry {
    static final String TAG = "KnownNetworkEntry";
    private final KnownNetwork mKnownNetworkData;
    private final SharedConnectivityManager mSharedConnectivityManager;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ConnectionStatus {
    }

    KnownNetworkEntry(WifiTrackerInjector r7, Handler r8, StandardWifiEntry.StandardWifiEntryKey r9, WifiManager r10, SharedConnectivityManager r11, KnownNetwork r12) {
        super(r7, r8, r9, r10, false);
        this.mSharedConnectivityManager = r11;
        this.mKnownNetworkData = r12;
    }

    KnownNetworkEntry(WifiTrackerInjector r10, Handler r11, StandardWifiEntry.StandardWifiEntryKey r12, List<WifiConfiguration> r13, List<ScanResult> r14, WifiManager r15, SharedConnectivityManager r16, KnownNetwork r17) throws IllegalArgumentException {
        super(r10, r11, r12, r13, r14, r15, false);
        this.mSharedConnectivityManager = r16;
        this.mKnownNetworkData = r17;
    }

    @Override // com.android.wifitrackerlib.StandardWifiEntry, com.android.wifitrackerlib.WifiEntry
    public synchronized String getSummary(boolean r5) {
        monitor-enter(this);
        String r6 = this.mContext.getString(R.string.wifitrackerlib_known_network_summary, new Object[]{BidiFormatter.getInstance().unicodeWrap(this.mKnownNetworkData.getNetworkProviderInfo().getDeviceName())});     // Catch: Throwable -> L6
        monitor-exit(this);
        return r6;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.wifitrackerlib.StandardWifiEntry, com.android.wifitrackerlib.WifiEntry
    public synchronized void connect(final WifiEntry.ConnectCallback r3) {
        monitor-enter(this);
        this.mConnectCallback = r3;     // Catch: Throwable -> L12
        SharedConnectivityManager r0 = this.mSharedConnectivityManager;     // Catch: Throwable -> L12
        if (r0 != null) goto L9;
        if (r3 == null) goto L7;
        this.mCallbackHandler.post(new KnownNetworkEntry$$ExternalSyntheticLambda1(r3));     // Catch: Throwable -> L12
    L7:
        monitor-exit(this);
        return;
    L9:
        r0.connectKnownNetwork(this.mKnownNetworkData);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ void lambda$connect$0(WifiEntry.ConnectCallback r1) {
        r1.onConnectResult(2);
    }

    @Override // com.android.wifitrackerlib.StandardWifiEntry, com.android.wifitrackerlib.WifiEntry
    public synchronized boolean isSaved() {
        monitor-enter(this);
        monitor-exit(this);
        return false;
    }

    @Override // com.android.wifitrackerlib.StandardWifiEntry, com.android.wifitrackerlib.WifiEntry
    public synchronized boolean isSuggestion() {
        monitor-enter(this);
        monitor-exit(this);
        return false;
    }

    @Override // com.android.wifitrackerlib.StandardWifiEntry, com.android.wifitrackerlib.WifiEntry
    protected synchronized boolean connectionInfoMatches(WifiInfo r3) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (r3.isPasspointAp() == false) goto L6;
    L11:
        monitor-exit(this);
        return false;
    L6:
        if (r3.isOsuAp() == true) goto L11;
        boolean r4 = Objects.equals(getStandardWifiEntryKey().getScanResultKey(), ssidAndSecurityTypeToStandardWifiEntryKey(WifiInfo.sanitizeSsid(r3.getSSID()), r3.getCurrentSecurityType()).getScanResultKey());     // Catch: Throwable -> L14
        monitor-exit(this);
        return r4;
    }

    public void onConnectionStatusChanged(int r2) {
        if (r2 == 2) goto L5;
        return;
    L5:
        if (this.mConnectCallback == null) goto L9;
        this.mCallbackHandler.post(new KnownNetworkEntry$$ExternalSyntheticLambda0(this));
        return;
    }

    /* JADX INFO: renamed from: lambda$onConnectionStatusChanged$1$com-android-wifitrackerlib-KnownNetworkEntry, reason: not valid java name */
    /* synthetic */ void m862x42e9e535() {
        this.mConnectCallback.onConnectResult(2);
    }
}
