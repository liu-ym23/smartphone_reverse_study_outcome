package com.android.wifitrackerlib;

import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.hotspot2.OsuProvider;
import android.net.wifi.hotspot2.PasspointConfiguration;
import android.net.wifi.hotspot2.ProvisioningCallback;
import android.os.Handler;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.os.BuildCompat;
import androidx.core.util.Preconditions;
import com.android.settingslib.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

/* JADX INFO: loaded from: classes2.dex */
class OsuWifiEntry extends WifiEntry {
    static final String KEY_PREFIX = "OsuWifiEntry:";
    private final List<ScanResult> mCurrentScanResults;
    private boolean mHasAddConfigUserRestriction;
    private boolean mIsAlreadyProvisioned;
    private final String mKey;
    private final OsuProvider mOsuProvider;
    private String mOsuStatusString;
    private String mSsid;
    private final UserManager mUserManager;

    class OsuWifiEntryProvisioningCallback extends ProvisioningCallback {
        final /* synthetic */ OsuWifiEntry this$0;

        OsuWifiEntryProvisioningCallback(OsuWifiEntry r1) {
            this.this$0 = r1;
        }

        public void onProvisioningFailure(int r4) {
            OsuWifiEntry r5 = this.this$0;
            monitor-enter(r5);
        L14:
            th = move-exception;
            throw th;
        L5:
            if (TextUtils.equals(OsuWifiEntry.access$000(this.this$0), this.this$0.mContext.getString(R.string.wifitrackerlib_osu_completing_sign_up)) == false) goto L7;
            OsuWifiEntry r0 = this.this$0;     // Catch: Throwable -> L14
            OsuWifiEntry.access$002(r0, r0.mContext.getString(R.string.wifitrackerlib_osu_sign_up_failed));     // Catch: Throwable -> L14
        L8:
            monitor-exit(r5);     // Catch: Throwable -> L14
            WifiEntry.ConnectCallback r6 = this.this$0.mConnectCallback;
            if (r6 == null) goto L12;
            r6.onConnectResult(2);
        L12:
            this.this$0.notifyOnUpdated();
            return;
        L7:
            OsuWifiEntry r1 = this.this$0;     // Catch: Throwable -> L14
            OsuWifiEntry.access$002(r1, r1.mContext.getString(R.string.wifitrackerlib_osu_connect_failed));     // Catch: Throwable -> L14
            goto L8
        }

        public void onProvisioningStatus(int r5) {
            boolean r0 = false;
            switch(r5) {
                case 1: goto L6;
                case 2: goto L6;
                case 3: goto L6;
                case 4: goto L6;
                case 5: goto L6;
                case 6: goto L6;
                case 7: goto L6;
                case 8: goto L5;
                case 9: goto L5;
                case 10: goto L5;
                case 11: goto L5;
                default: goto L4;
            };
        L4:
            String r6 = null;
        L7:
            OsuWifiEntry r2 = this.this$0;
            monitor-enter(r2);
        L17:
            th = move-exception;
            throw th;
        L10:
            if (TextUtils.equals(OsuWifiEntry.access$000(this.this$0), r6) == true) goto L12;
            r0 = true;
        L12:
            OsuWifiEntry.access$002(this.this$0, r6);     // Catch: Throwable -> L17
            if (r0 == false) goto L15;
            this.this$0.notifyOnUpdated();     // Catch: Throwable -> L17
        L15:
            monitor-exit(r2);     // Catch: Throwable -> L17
            return;
        L5:
            r6 = this.this$0.mContext.getString(R.string.wifitrackerlib_osu_completing_sign_up);
            goto L7
        L6:
            r6 = String.format(this.this$0.mContext.getString(R.string.wifitrackerlib_osu_opening_provider), new Object[]{this.this$0.getTitle()});
            goto L7
        }

        public void onProvisioningComplete() {
            OsuWifiEntry r0 = this.this$0;
            monitor-enter(r0);
            OsuWifiEntry r1 = this.this$0;     // Catch: Throwable -> L30
            OsuWifiEntry.access$002(r1, r1.mContext.getString(R.string.wifitrackerlib_osu_sign_up_complete));     // Catch: Throwable -> L30
            monitor-exit(r0);     // Catch: Throwable -> L30
            this.this$0.notifyOnUpdated();
            PasspointConfiguration r2 = (PasspointConfiguration) this.this$0.mWifiManager.getMatchingPasspointConfigsForOsuProviders(Collections.singleton(OsuWifiEntry.access$100(this.this$0))).get(OsuWifiEntry.access$100(this.this$0));
            WifiEntry.ConnectCallback r3 = this.this$0.mConnectCallback;
            if (r2 != null) goto L11;
            if (r3 == null) goto L38;
            r3.onConnectResult(2);
            return;
        L38:
            return;
        L11:
            String r4 = r2.getUniqueId();
            Iterator r5 = this.this$0.mWifiManager.getAllMatchingWifiConfigs(this.this$0.mWifiManager.getScanResults()).iterator();
        L13:
            if (r5.hasNext() == false) goto L27;
            Pair r6 = (Pair) r5.next();
            WifiConfiguration r7 = (WifiConfiguration) r6.first;
            if (TextUtils.equals(r7.getKey(), r4) == false) goto L13;
            List r8 = (List) ((Map) r6.second).get(0);
            List r9 = (List) ((Map) r6.second).get(1);
            if (r8 != null) goto L19;
        L21:
            if (r9 == null) goto L27;
            if (r9.isEmpty() == true) goto L27;
            ScanResult r10 = Utils.getBestScanResultByLevel(r9);
        L25:
            r7.SSID = "\"" + r10.SSID + "\"";
            this.this$0.mWifiManager.connect(r7, null);
            return;
        L19:
            if (r8.isEmpty() == true) goto L21;
            r10 = Utils.getBestScanResultByLevel(r8);
        L27:
            if (r3 == null) goto L39;
            r3.onConnectResult(2);
            return;
        L39:
            return;
        L30:
            th = move-exception;
            throw th;
        }
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public String getMacAddress() {
        return null;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    protected String getScanResultDescription() {
        return "";
    }

    static /* synthetic */ String access$000(OsuWifiEntry r0) {
        return r0.mOsuStatusString;
    }

    static /* synthetic */ String access$002(OsuWifiEntry r0, String r1) {
        r0.mOsuStatusString = r1;
        return r1;
    }

    static /* synthetic */ OsuProvider access$100(OsuWifiEntry r0) {
        return r0.mOsuProvider;
    }

    OsuWifiEntry(WifiTrackerInjector r1, Handler r2, OsuProvider r3, WifiManager r4, boolean r5) throws IllegalArgumentException {
        super(r1, r2, r4, r5);
        this.mCurrentScanResults = new ArrayList();
        this.mIsAlreadyProvisioned = false;
        this.mHasAddConfigUserRestriction = false;
        Preconditions.checkNotNull(r3, "Cannot construct with null osuProvider!");
        this.mOsuProvider = r3;
        this.mKey = osuProviderToOsuWifiEntryKey(r3);
        UserManager r6 = r1.getUserManager();
        this.mUserManager = r6;
        if (BuildCompat.isAtLeastT() == false) goto L7;
        if (r6 == null) goto L8;
        this.mHasAddConfigUserRestriction = r6.hasUserRestriction("no_add_wifi_config");
        return;
    L8:
        return;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public String getKey() {
        return this.mKey;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized String getTitle() {
        monitor-enter(this);
        String r0 = this.mOsuProvider.getFriendlyName();     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(r0) == true) goto L8;
        monitor-exit(this);
        return r0;
    L8:
        if (TextUtils.isEmpty(this.mSsid) == true) goto L12;
        String r1 = this.mSsid;     // Catch: Throwable -> L20
        monitor-exit(this);
        return r1;
    L12:
        Uri r2 = this.mOsuProvider.getServerUri();     // Catch: Throwable -> L20
        if (r2 == null) goto L18;
        String r3 = r2.toString();     // Catch: Throwable -> L20
        monitor-exit(this);
        return r3;
    L18:
        monitor-exit(this);
        return "";
    L20:
        th = move-exception;
        throw th;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized String getSummary(boolean r2) {
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L4:
        if (hasAdminRestrictions() == false) goto L8;
        String r3 = this.mContext.getString(R.string.wifitrackerlib_admin_restricted_network);     // Catch: Throwable -> L22
        monitor-exit(this);
        return r3;
    L8:
        String r0 = this.mOsuStatusString;     // Catch: Throwable -> L22
        if (r0 == null) goto L13;
        monitor-exit(this);
        return r0;
    L13:
        if (isAlreadyProvisioned() == false) goto L19;
        if (r2 == false) goto L16;
        String r4 = this.mContext.getString(R.string.wifitrackerlib_wifi_passpoint_expired);     // Catch: Throwable -> L22
    L17:
        monitor-exit(this);
        return r4;
    L16:
        r4 = this.mContext.getString(R.string.wifitrackerlib_tap_to_renew_subscription_and_connect);     // Catch: Throwable -> L22
        goto L17
    L19:
        String r5 = this.mContext.getString(R.string.wifitrackerlib_tap_to_sign_up);     // Catch: Throwable -> L22
        monitor-exit(this);
        return r5;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized String getSsid() {
        monitor-enter(this);
        String r0 = this.mSsid;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized boolean canConnect() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        boolean r1 = false;
        if (hasAdminRestrictions() == false) goto L9;
        monitor-exit(this);
        return false;
    L9:
        if (this.mLevel == (-1)) goto L13;
        if (getConnectedState() != 0) goto L13;
        r1 = true;
    L13:
        monitor-exit(this);
        return r1;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized void connect(WifiEntry.ConnectCallback r4) {
        monitor-enter(this);
        this.mConnectCallback = r4;     // Catch: Throwable -> L6
        this.mWifiManager.stopRestrictingAutoJoinToSubscriptionId();     // Catch: Throwable -> L6
        this.mWifiManager.startSubscriptionProvisioning(this.mOsuProvider, this.mContext.getMainExecutor(), new OsuWifiEntryProvisioningCallback(this));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void updateScanResultInfo(List<ScanResult> r2) throws IllegalArgumentException {
        monitor-enter(this);
        if (r2 == null) goto L17;
    L5:
        this.mCurrentScanResults.clear();     // Catch: Throwable -> L14
        this.mCurrentScanResults.addAll(r2);     // Catch: Throwable -> L14
        ScanResult r3 = Utils.getBestScanResultByLevel(r2);     // Catch: Throwable -> L14
        if (r3 == null) goto L10;
        updateTransitionModeCapa(r3);     // Catch: Throwable -> L14
        this.mSsid = r3.SSID;     // Catch: Throwable -> L14
        if (getConnectedState() != 0) goto L11;
        this.mLevel = this.mWifiManager.calculateSignalLevel(r3.level);     // Catch: Throwable -> L14
    L11:
        updateWifiGenerationInfo(this.mCurrentScanResults);     // Catch: Throwable -> L14
        notifyOnUpdated();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    L10:
        this.mLevel = -1;     // Catch: Throwable -> L14
        goto L11
    L17:
        r2 = new ArrayList();     // Catch: Throwable -> L14
        goto L5
    }

    static String osuProviderToOsuWifiEntryKey(OsuProvider r2) {
        Preconditions.checkNotNull(r2, "Cannot create key with null OsuProvider!");
        return KEY_PREFIX + r2.getFriendlyName() + "," + r2.getServerUri().toString();
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    protected boolean connectionInfoMatches(WifiInfo r2) {
        if (r2.isOsuAp() == true) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals(r2.getPasspointProviderFriendlyName(), this.mOsuProvider.getFriendlyName()) == false) goto L7;
        return true;
    }

    OsuProvider getOsuProvider() {
        return this.mOsuProvider;
    }

    synchronized boolean isAlreadyProvisioned() {
        monitor-enter(this);
        boolean r0 = this.mIsAlreadyProvisioned;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void setAlreadyProvisioned(boolean r1) {
        monitor-enter(this);
        this.mIsAlreadyProvisioned = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized boolean hasAdminRestrictions() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.mHasAddConfigUserRestriction == false) goto L10;
        if (this.mIsAlreadyProvisioned == true) goto L10;
        monitor-exit(this);
        return true;
    L10:
        monitor-exit(this);
        return false;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public String toString() {
        StringJoiner r0 = new StringJoiner("][", "[", "]");
        r0.add("FriendlyName:" + this.mOsuProvider.getFriendlyName());
        r0.add("ServerUri:" + this.mOsuProvider.getServerUri());
        r0.add("SSID:" + this.mSsid);
        return super.toString() + r0;
    }
}
