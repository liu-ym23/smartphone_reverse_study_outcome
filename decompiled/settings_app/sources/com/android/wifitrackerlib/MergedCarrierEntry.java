package com.android.wifitrackerlib;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;
import com.android.settingslib.R;
import java.util.StringJoiner;

/* JADX INFO: loaded from: classes2.dex */
public class MergedCarrierEntry extends WifiEntry {
    static final String KEY_PREFIX = "MergedCarrierEntry:";
    boolean mIsCellDefaultRoute;
    private final String mKey;
    private final int mSubscriptionId;

    MergedCarrierEntry(WifiTrackerInjector r1, Handler r2, WifiManager r3, boolean r4, int r5) throws IllegalArgumentException {
        super(r1, r2, r3, r4);
        this.mSubscriptionId = r5;
        this.mKey = KEY_PREFIX + r5;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public String getKey() {
        return this.mKey;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public String getSummary(boolean r4) {
        StringJoiner r0 = new StringJoiner(this.mContext.getString(R.string.wifitrackerlib_summary_separator));
        if (r4 == true) goto L10;
        if (isVerboseSummaryEnabled() == false) goto L10;
        String r3 = Utils.getVerboseSummary(this);
        if (TextUtils.isEmpty(r3) == true) goto L10;
        r0.add(r3);
    L10:
        return r0.toString();
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized String getSsid() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mWifiInfo == null) goto L8;
        String r0 = WifiInfo.sanitizeSsid(this.mWifiInfo.getSSID());     // Catch: Throwable -> L11
        monitor-exit(this);
        return r0;
    L8:
        monitor-exit(this);
        return null;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized String getMacAddress() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.mWifiInfo == null) goto L11;
        String r0 = this.mWifiInfo.getMacAddress();     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r0) == true) goto L11;
        if (TextUtils.equals(r0, "02:00:00:00:00:00") == true) goto L11;
        monitor-exit(this);
        return r0;
    L11:
        monitor-exit(this);
        return null;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized boolean canConnect() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (getConnectedState() != 0) goto L8;
        if (this.mIsCellDefaultRoute == true) goto L8;
        boolean r0 = true;
    L9:
        monitor-exit(this);
        return r0;
    L8:
        r0 = false;
        goto L9
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized void connect(WifiEntry.ConnectCallback r2) {
        monitor-enter(this);
        connect(r2, true);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void connect(WifiEntry.ConnectCallback r2, boolean r3) {
        monitor-enter(this);
        this.mConnectCallback = r2;     // Catch: Throwable -> L11
        this.mWifiManager.startRestrictingAutoJoinToSubscriptionId(this.mSubscriptionId);     // Catch: Throwable -> L11
        if (r3 == false) goto L7;
        Toast.makeText(this.mContext, R.string.wifitrackerlib_wifi_wont_autoconnect_for_now, 0).show();     // Catch: Throwable -> L11
    L7:
        if (this.mConnectCallback == null) goto L9;
        this.mCallbackHandler.post(new MergedCarrierEntry$$ExternalSyntheticLambda1(this));     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: lambda$connect$0$com-android-wifitrackerlib-MergedCarrierEntry, reason: not valid java name */
    /* synthetic */ void m863lambda$connect$0$comandroidwifitrackerlibMergedCarrierEntry() {
        WifiEntry.ConnectCallback r1 = this.mConnectCallback;
        if (r1 == null) goto L6;
        r1.onConnectResult(0);
        return;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public boolean canDisconnect() {
        if (getConnectedState() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized void disconnect(WifiEntry.DisconnectCallback r2) {
        monitor-enter(this);
        this.mDisconnectCallback = r2;     // Catch: Throwable -> L8
        this.mWifiManager.stopRestrictingAutoJoinToSubscriptionId();     // Catch: Throwable -> L8
        this.mWifiManager.startScan();     // Catch: Throwable -> L8
        if (this.mDisconnectCallback == null) goto L6;
        this.mCallbackHandler.post(new MergedCarrierEntry$$ExternalSyntheticLambda0(this));     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: lambda$disconnect$1$com-android-wifitrackerlib-MergedCarrierEntry, reason: not valid java name */
    /* synthetic */ void m864xf1158ee9() {
        WifiEntry.DisconnectCallback r1 = this.mDisconnectCallback;
        if (r1 == null) goto L6;
        r1.onDisconnectResult(0);
        return;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    protected boolean connectionInfoMatches(WifiInfo r2) {
        if (r2.isCarrierMerged() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mSubscriptionId != r2.getSubscriptionId()) goto L7;
        return true;
    }

    public boolean isEnabled() {
        return this.mWifiManager.isCarrierNetworkOffloadEnabled(this.mSubscriptionId, true);
    }

    public void setEnabled(boolean r4) {
        this.mWifiManager.setCarrierNetworkOffloadEnabled(this.mSubscriptionId, true, r4);
        if (r4 == true) goto L6;
        this.mWifiManager.stopRestrictingAutoJoinToSubscriptionId();
        this.mWifiManager.startScan();
        return;
    }

    public int getSubscriptionId() {
        return this.mSubscriptionId;
    }

    synchronized void updateIsCellDefaultRoute(boolean r1) {
        monitor-enter(this);
        this.mIsCellDefaultRoute = r1;     // Catch: Throwable -> L6
        notifyOnUpdated();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public String toString() {
        StringJoiner r0 = new StringJoiner("][", "[", "]");
        r0.add("SubId:" + this.mSubscriptionId);
        return super.toString() + r0;
    }
}
