package com.android.wifitrackerlib;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.hotspot2.PasspointConfiguration;
import android.os.Handler;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.Log;
import androidx.core.util.Preconditions;
import com.android.settingslib.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

/* JADX INFO: loaded from: classes2.dex */
public class PasspointWifiEntry extends WifiEntry implements WifiEntry.WifiEntryCallback {
    public static final String KEY_PREFIX = "PasspointWifiEntry:";
    static final String TAG = "PasspointWifiEntry";
    private final List<ScanResult> mCurrentHomeScanResults;
    private final List<ScanResult> mCurrentRoamingScanResults;
    private final String mFqdn;
    private final String mFriendlyName;
    private final String mKey;
    private int mMeteredOverride;
    private OsuWifiEntry mOsuWifiEntry;
    private PasspointConfiguration mPasspointConfig;
    private boolean mShouldAutoOpenCaptivePortal;
    protected long mSubscriptionExpirationTimeInMillis;
    private List<Integer> mTargetSecurityTypes;
    private final String mUniqueId;
    private WifiConfiguration mWifiConfig;

    @Override // com.android.wifitrackerlib.WifiEntry
    protected String getScanResultDescription() {
        return "";
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public boolean shouldShowSsid() {
        return true;
    }

    PasspointWifiEntry(WifiTrackerInjector r1, Handler r2, PasspointConfiguration r3, WifiManager r4, boolean r5) throws IllegalArgumentException {
        super(r1, r2, r4, r5);
        this.mCurrentHomeScanResults = new ArrayList();
        this.mCurrentRoamingScanResults = new ArrayList();
        this.mTargetSecurityTypes = Arrays.asList(new Integer[]{11, 12});
        this.mShouldAutoOpenCaptivePortal = false;
        this.mMeteredOverride = 0;
        Preconditions.checkNotNull(r3, "Cannot construct with null PasspointConfiguration!");
        this.mPasspointConfig = r3;
        String r6 = r3.getUniqueId();
        this.mUniqueId = r6;
        this.mKey = uniqueIdToPasspointWifiEntryKey(r6);
        String r7 = r3.getHomeSp().getFqdn();
        this.mFqdn = r7;
        Preconditions.checkNotNull(r7, "Cannot construct with null PasspointConfiguration FQDN!");
        this.mFriendlyName = r3.getHomeSp().getFriendlyName();
        this.mSubscriptionExpirationTimeInMillis = r3.getSubscriptionExpirationTimeMillis();
        this.mMeteredOverride = this.mPasspointConfig.getMeteredOverride();
    }

    PasspointWifiEntry(WifiTrackerInjector r1, Context r2, Handler r3, WifiConfiguration r4, WifiManager r5, boolean r6) throws IllegalArgumentException {
        super(r1, r3, r5, r6);
        this.mCurrentHomeScanResults = new ArrayList();
        this.mCurrentRoamingScanResults = new ArrayList();
        this.mTargetSecurityTypes = Arrays.asList(new Integer[]{11, 12});
        this.mShouldAutoOpenCaptivePortal = false;
        this.mMeteredOverride = 0;
        Preconditions.checkNotNull(r4, "Cannot construct with null WifiConfiguration!");
        if (r4.isPasspoint() == false) goto L7;
        this.mWifiConfig = r4;
        String r7 = r4.getKey();
        this.mUniqueId = r7;
        this.mKey = uniqueIdToPasspointWifiEntryKey(r7);
        String r8 = r4.FQDN;
        this.mFqdn = r8;
        Preconditions.checkNotNull(r8, "Cannot construct with null WifiConfiguration FQDN!");
        this.mFriendlyName = this.mWifiConfig.providerFriendlyName;
        return;
    L7:
        throw new IllegalArgumentException("Given WifiConfiguration is not for Passpoint!");
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public String getKey() {
        return this.mKey;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized int getConnectedState() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (isExpired() == true) goto L6;
    L12:
        int r0 = super.getConnectedState();     // Catch: Throwable -> L15
        monitor-exit(this);
        return r0;
    L6:
        if (super.getConnectedState() != 0) goto L12;
        OsuWifiEntry r1 = this.mOsuWifiEntry;     // Catch: Throwable -> L15
        if (r1 == null) goto L12;
        int r2 = r1.getConnectedState();     // Catch: Throwable -> L15
        monitor-exit(this);
        return r2;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public String getTitle() {
        return this.mFriendlyName;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized String getSummary(boolean r9) {
        monitor-enter(this);
        StringJoiner r1 = new StringJoiner(this.mContext.getString(R.string.wifitrackerlib_summary_separator));     // Catch: Throwable -> L41
        if (isExpired() == false) goto L10;
        OsuWifiEntry r0 = this.mOsuWifiEntry;     // Catch: Throwable -> L41
        if (r0 == null) goto L9;
        r1.add(r0.getSummary(r9));     // Catch: Throwable -> L41
    L26:
        String r2 = Utils.getAutoConnectDescription(this.mContext, this);     // Catch: Throwable -> L41
        if (TextUtils.isEmpty(r2) == true) goto L29;
        r1.add(r2);     // Catch: Throwable -> L41
    L29:
        String r3 = Utils.getMeteredDescription(this.mContext, this);     // Catch: Throwable -> L41
        if (TextUtils.isEmpty(r3) == true) goto L32;
        r1.add(r3);     // Catch: Throwable -> L41
    L32:
        if (r9 == false) goto L34;
    L38:
        String r10 = r1.toString();     // Catch: Throwable -> L41
        monitor-exit(this);
        return r10;
    L34:
        if (isVerboseSummaryEnabled() == false) goto L38;
        String r11 = Utils.getVerboseSummary(this);     // Catch: Throwable -> L41
        if (TextUtils.isEmpty(r11) == true) goto L38;
        r1.add(r11);     // Catch: Throwable -> L41
        goto L38
    L9:
        r1.add(this.mContext.getString(R.string.wifitrackerlib_wifi_passpoint_expired));     // Catch: Throwable -> L41
        goto L26
    L10:
        int r4 = getConnectedState();     // Catch: Throwable -> L41
        if (r4 != 0) goto L13;
        String r5 = Utils.getDisconnectedDescription(this.mInjector, this.mContext, this.mWifiConfig, this.mForSavedNetworksPage, r9);     // Catch: Throwable -> L41
    L24:
        if (TextUtils.isEmpty(r5) == true) goto L26;
        r1.add(r5);     // Catch: Throwable -> L41
        goto L26
    L13:
        if (r4 == 1) goto L21;
        r5 = null;
        if (r4 == 2) goto L18;
        Log.e(TAG, "getConnectedState() returned unknown state: " + r4);     // Catch: Throwable -> L41
        goto L24
    L18:
        if (this.mNetworkCapabilities != null) goto L20;
        Log.e(TAG, "Tried to get CONNECTED description, but mNetworkCapabilities was unexpectedly null!");     // Catch: Throwable -> L41
        goto L24
    L20:
        r5 = Utils.getConnectedDescription(this.mContext, this.mWifiConfig, this.mNetworkCapabilities, isDefaultNetwork(), isLowQuality(), this.mConnectivityReport);     // Catch: Throwable -> L41
        goto L24
    L21:
        r5 = Utils.getConnectingDescription(this.mContext, this.mNetworkInfo);     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        throw th;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized String getSsid() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.mWifiInfo == null) goto L8;
        String r0 = WifiInfo.sanitizeSsid(this.mWifiInfo.getSSID());     // Catch: Throwable -> L15
        monitor-exit(this);
        return r0;
    L8:
        WifiConfiguration r1 = this.mWifiConfig;     // Catch: Throwable -> L15
        if (r1 == null) goto L12;
        String r2 = WifiInfo.sanitizeSsid(r1.SSID);     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
        return r2;
    L12:
        r2 = null;
        goto L13
    }

    synchronized Set<String> getAllUtf8Ssids() {
        monitor-enter(this);
        ArraySet r0 = new ArraySet();     // Catch: Throwable -> L14
        Iterator<ScanResult> r1 = this.mCurrentHomeScanResults.iterator();     // Catch: Throwable -> L14
    L5:
        if (r1.hasNext() == false) goto L7;
        r0.add(r1.next().SSID);     // Catch: Throwable -> L14
        goto L5
    L7:
        Iterator<ScanResult> r2 = this.mCurrentRoamingScanResults.iterator();     // Catch: Throwable -> L14
    L8:
        if (r2.hasNext() == false) goto L12;
        r0.add(r2.next().SSID);     // Catch: Throwable -> L14
        goto L8
    L12:
        monitor-exit(this);
        return r0;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized List<Integer> getSecurityTypes() {
        monitor-enter(this);
        ArrayList r0 = new ArrayList(this.mTargetSecurityTypes);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized String getMacAddress() {
        monitor-enter(this);
    L27:
        th = move-exception;
        throw th;
    L4:
        if (this.mWifiInfo == null) goto L12;
        String r0 = this.mWifiInfo.getMacAddress();     // Catch: Throwable -> L27
        if (TextUtils.isEmpty(r0) == true) goto L12;
        if (TextUtils.equals(r0, "02:00:00:00:00:00") == true) goto L12;
        monitor-exit(this);
        return r0;
    L12:
        if (this.mWifiConfig != null) goto L14;
    L19:
        String[] r1 = this.mWifiManager.getFactoryMacAddresses();     // Catch: Throwable -> L27
        if (r1.length <= 0) goto L24;
        String r2 = r1[0];     // Catch: Throwable -> L27
        monitor-exit(this);
        return r2;
    L24:
        monitor-exit(this);
        return null;
    L14:
        if (getPrivacy() != 1) goto L19;
        String r3 = this.mWifiConfig.getRandomizedMacAddress().toString();     // Catch: Throwable -> L27
        monitor-exit(this);
        return r3;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized boolean isMetered() {
        monitor-enter(this);
        boolean r1 = true;
        if (getMeteredChoice() == 1) goto L11;
        WifiConfiguration r0 = this.mWifiConfig;     // Catch: Throwable -> L13
        if (r0 == null) goto L10;
        if (r0.meteredHint == true) goto L11;
    L10:
        r1 = false;
    L11:
        monitor-exit(this);
        return r1;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized boolean isSuggestion() {
        monitor-enter(this);
        WifiConfiguration r0 = this.mWifiConfig;     // Catch: Throwable -> L11
        if (r0 == null) goto L8;
        if (r0.fromWifiNetworkSuggestion == false) goto L8;
        boolean r1 = true;
    L9:
        monitor-exit(this);
        return r1;
    L8:
        r1 = false;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized boolean isSubscription() {
        monitor-enter(this);
        if (this.mPasspointConfig == null) goto L6;
        boolean r0 = true;
    L7:
        monitor-exit(this);
        return r0;
    L6:
        r0 = false;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized boolean canConnect() {
        monitor-enter(this);
        boolean r1 = true;
        if (isExpired() == false) goto L14;
        OsuWifiEntry r0 = this.mOsuWifiEntry;     // Catch: Throwable -> L23
        if (r0 != null) goto L8;
    L10:
        r1 = false;
    L11:
        monitor-exit(this);
        return r1;
    L8:
        if (r0.canConnect() == false) goto L10;
    L14:
        if (this.mLevel != (-1)) goto L16;
    L20:
        r1 = false;
    L21:
        monitor-exit(this);
        return r1;
    L16:
        if (getConnectedState() != 0) goto L20;
        if (this.mWifiConfig == null) goto L20;
    L23:
        th = move-exception;
        throw th;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized void connect(WifiEntry.ConnectCallback r3) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (isExpired() == false) goto L11;
        OsuWifiEntry r0 = this.mOsuWifiEntry;     // Catch: Throwable -> L17
        if (r0 == null) goto L11;
        r0.connect(r3);     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L11:
        this.mShouldAutoOpenCaptivePortal = true;     // Catch: Throwable -> L17
        this.mConnectCallback = r3;     // Catch: Throwable -> L17
        if (this.mWifiConfig != null) goto L14;
        new WifiEntry.ConnectActionListener(this).onFailure(0);     // Catch: Throwable -> L17
    L14:
        this.mWifiManager.stopRestrictingAutoJoinToSubscriptionId();     // Catch: Throwable -> L17
        this.mWifiManager.connect(this.mWifiConfig, new WifiEntry.ConnectActionListener(this));     // Catch: Throwable -> L17
        monitor-exit(this);
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public boolean canDisconnect() {
        if (getConnectedState() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized void disconnect(final WifiEntry.DisconnectCallback r5) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (canDisconnect() == false) goto L6;
        this.mCalledDisconnect = true;     // Catch: Throwable -> L8
        this.mDisconnectCallback = r5;     // Catch: Throwable -> L8
        this.mCallbackHandler.postDelayed(new PasspointWifiEntry$$ExternalSyntheticLambda0(this, r5), 10000);     // Catch: Throwable -> L8
        this.mWifiManager.disableEphemeralNetwork(this.mFqdn);     // Catch: Throwable -> L8
        this.mWifiManager.disconnect();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    /* JADX INFO: renamed from: lambda$disconnect$0$com-android-wifitrackerlib-PasspointWifiEntry, reason: not valid java name */
    /* synthetic */ void m867xb18ecc00(WifiEntry.DisconnectCallback r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (this.mCalledDisconnect == false) goto L8;
        r1.onDisconnectResult(1);
        return;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized boolean canForget() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (isSuggestion() == true) goto L8;
        if (this.mPasspointConfig == null) goto L8;
        boolean r0 = true;
    L9:
        monitor-exit(this);
        return r0;
    L8:
        r0 = false;
        goto L9
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized void forget(WifiEntry.ForgetCallback r2) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (canForget() == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.mForgetCallback = r2;     // Catch: Throwable -> L10
        this.mWifiManager.removePasspointConfiguration(this.mPasspointConfig.getHomeSp().getFqdn());     // Catch: Throwable -> L10
        new WifiEntry.ForgetActionListener(this).onSuccess();     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized int getMeteredChoice() {
        monitor-enter(this);
        int r0 = this.mMeteredOverride;     // Catch: Throwable -> L15
        if (r0 != 1) goto L9;
        monitor-exit(this);
        return 1;
    L9:
        if (r0 != 2) goto L12;
        monitor-exit(this);
        return 2;
    L12:
        monitor-exit(this);
        return 0;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized boolean canSetMeteredChoice() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (isSuggestion() == true) goto L8;
        if (this.mPasspointConfig == null) goto L8;
        boolean r0 = true;
    L9:
        monitor-exit(this);
        return r0;
    L8:
        r0 = false;
        goto L9
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized void setMeteredChoice(int r3) {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L4:
        if (this.mPasspointConfig != null) goto L6;
    L21:
        monitor-exit(this);
        return;
    L6:
        if (canSetMeteredChoice() == false) goto L21;
        if (r3 != 0) goto L10;
        this.mMeteredOverride = 0;     // Catch: Throwable -> L23
    L18:
        this.mWifiManager.setPasspointMeteredOverride(this.mPasspointConfig.getHomeSp().getFqdn(), this.mMeteredOverride);     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L10:
        if (r3 != 1) goto L12;
        this.mMeteredOverride = 1;     // Catch: Throwable -> L23
        goto L18
    L12:
        if (r3 == 2) goto L15;
        monitor-exit(this);
        return;
    L15:
        this.mMeteredOverride = 2;     // Catch: Throwable -> L23
        goto L18
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized boolean canSetPrivacy() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (isSuggestion() == true) goto L8;
        if (this.mPasspointConfig == null) goto L8;
        boolean r0 = true;
    L9:
        monitor-exit(this);
        return r0;
    L8:
        r0 = false;
        goto L9
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized int getPrivacy() {
        monitor-enter(this);
        PasspointConfiguration r0 = this.mPasspointConfig;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        monitor-exit(this);
        return 1;
    L8:
        boolean r1 = r0.isMacRandomizationEnabled();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1 ? 1 : 0;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized void setPrivacy(int r3) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.mPasspointConfig != null) goto L6;
    L15:
        monitor-exit(this);
        return;
    L6:
        if (canSetPrivacy() == false) goto L15;
        WifiManager r0 = this.mWifiManager;     // Catch: Throwable -> L17
        String r1 = this.mPasspointConfig.getHomeSp().getFqdn();     // Catch: Throwable -> L17
        if (r3 != 0) goto L11;
        boolean r4 = false;
    L12:
        r0.setMacRandomizationSettingPasspointEnabled(r1, r4);     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L11:
        r4 = true;
        goto L12
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized boolean isAutoJoinEnabled() {
        monitor-enter(this);
        PasspointConfiguration r0 = this.mPasspointConfig;     // Catch: Throwable -> L16
        if (r0 == null) goto L8;
        boolean r1 = r0.isAutojoinEnabled();     // Catch: Throwable -> L16
        monitor-exit(this);
        return r1;
    L8:
        WifiConfiguration r2 = this.mWifiConfig;     // Catch: Throwable -> L16
        if (r2 == null) goto L13;
        boolean r3 = r2.allowAutojoin;     // Catch: Throwable -> L16
        monitor-exit(this);
        return r3;
    L13:
        monitor-exit(this);
        return false;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized boolean canSetAutoJoinEnabled() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.mPasspointConfig != null) goto L9;
        if (this.mWifiConfig != null) goto L9;
        boolean r0 = false;
    L10:
        monitor-exit(this);
        return r0;
    L9:
        r0 = true;
        goto L10
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized void setAutoJoinEnabled(boolean r3) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mPasspointConfig == null) goto L7;
        this.mWifiManager.allowAutojoinPasspoint(this.mPasspointConfig.getHomeSp().getFqdn(), r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L7:
        if (this.mWifiConfig == null) goto L9;
        this.mWifiManager.allowAutojoin(this.mWifiConfig.networkId, r3);     // Catch: Throwable -> L11
        goto L9
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public String getSecurityString(boolean r1) {
        return this.mContext.getString(R.string.wifitrackerlib_wifi_security_passpoint);
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized String getStandardString() {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L4:
        if (this.mWifiInfo == null) goto L9;
        String r0 = Utils.getStandardString(this.mContext, this.mWifiInfo.getWifiStandard());     // Catch: Throwable -> L21
        monitor-exit(this);
        return r0;
    L9:
        if (this.mCurrentHomeScanResults.isEmpty() == true) goto L14;
        String r1 = Utils.getStandardString(this.mContext, this.mCurrentHomeScanResults.get(0).getWifiStandard());     // Catch: Throwable -> L21
        monitor-exit(this);
        return r1;
    L14:
        if (this.mCurrentRoamingScanResults.isEmpty() == true) goto L19;
        String r2 = Utils.getStandardString(this.mContext, this.mCurrentRoamingScanResults.get(0).getWifiStandard());     // Catch: Throwable -> L21
        monitor-exit(this);
        return r2;
    L19:
        monitor-exit(this);
        return "";
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized String getBandString() {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L4:
        if (this.mWifiInfo == null) goto L9;
        String r0 = Utils.wifiInfoToBandString(this.mContext, this.mWifiInfo);     // Catch: Throwable -> L21
        monitor-exit(this);
        return r0;
    L9:
        if (this.mCurrentHomeScanResults.isEmpty() == true) goto L14;
        String r1 = Utils.frequencyToBandString(this.mContext, this.mCurrentHomeScanResults.get(0).frequency);     // Catch: Throwable -> L21
        monitor-exit(this);
        return r1;
    L14:
        if (this.mCurrentRoamingScanResults.isEmpty() == true) goto L19;
        String r2 = Utils.frequencyToBandString(this.mContext, this.mCurrentRoamingScanResults.get(0).frequency);     // Catch: Throwable -> L21
        monitor-exit(this);
        return r2;
    L19:
        monitor-exit(this);
        return "";
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized boolean isExpired() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        boolean r1 = false;
        if (this.mSubscriptionExpirationTimeInMillis > 0) goto L8;
        monitor-exit(this);
        return false;
    L8:
        if (System.currentTimeMillis() < this.mSubscriptionExpirationTimeInMillis) goto L12;
        r1 = true;
    L12:
        monitor-exit(this);
        return r1;
    }

    synchronized void updatePasspointConfig(PasspointConfiguration r3) {
        monitor-enter(this);
        this.mPasspointConfig = r3;     // Catch: Throwable -> L9
        if (r3 == null) goto L6;
        this.mSubscriptionExpirationTimeInMillis = r3.getSubscriptionExpirationTimeMillis();     // Catch: Throwable -> L9
        this.mMeteredOverride = r3.getMeteredOverride();     // Catch: Throwable -> L9
    L6:
        notifyOnUpdated();     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    synchronized void updateScanResultInfo(WifiConfiguration r4, List<ScanResult> r5, List<ScanResult> r6) throws IllegalArgumentException {
        monitor-enter(this);
        this.mWifiConfig = r4;     // Catch: Throwable -> L32
        this.mCurrentHomeScanResults.clear();     // Catch: Throwable -> L32
        this.mCurrentRoamingScanResults.clear();     // Catch: Throwable -> L32
        if (r5 == null) goto L7;
        this.mCurrentHomeScanResults.addAll(r5);     // Catch: Throwable -> L32
    L7:
        if (r6 == null) goto L9;
        this.mCurrentRoamingScanResults.addAll(r6);     // Catch: Throwable -> L32
    L9:
        int r1 = -1;
        if (this.mWifiConfig == null) goto L28;
        ArrayList r7 = new ArrayList();     // Catch: Throwable -> L32
        if (r5 != null) goto L14;
    L16:
        if (r6 != null) goto L18;
    L20:
        ScanResult r8 = Utils.getBestScanResultByLevel(r7);     // Catch: Throwable -> L32
        if (r8 == null) goto L24;
        this.mWifiConfig.SSID = "\"" + r8.SSID + "\"";     // Catch: Throwable -> L32
        updateTransitionModeCapa(r8);     // Catch: Throwable -> L32
    L24:
        if (getConnectedState() != 0) goto L29;
        if (r8 == null) goto L27;
        r1 = this.mWifiManager.calculateSignalLevel(r8.level);     // Catch: Throwable -> L32
    L27:
        this.mLevel = r1;     // Catch: Throwable -> L32
    L29:
        notifyOnUpdated();     // Catch: Throwable -> L32
        monitor-exit(this);
        return;
    L18:
        if (r6.isEmpty() == true) goto L20;
        r7.addAll(r6);     // Catch: Throwable -> L32
        updateWifiGenerationInfo(r6);     // Catch: Throwable -> L32
        goto L20
    L14:
        if (r5.isEmpty() == true) goto L16;
        r7.addAll(r5);     // Catch: Throwable -> L32
        updateWifiGenerationInfo(r5);     // Catch: Throwable -> L32
        goto L20
    L28:
        this.mLevel = -1;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    protected synchronized void updateSecurityTypes() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.mWifiInfo == null) goto L10;
        int r0 = this.mWifiInfo.getCurrentSecurityType();     // Catch: Throwable -> L12
        if (r0 == (-1)) goto L10;
        this.mTargetSecurityTypes = Collections.singletonList(Integer.valueOf(r0));     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L10:
        monitor-exit(this);
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    protected boolean connectionInfoMatches(WifiInfo r2) {
        if (r2.isPasspointAp() == true) goto L7;
        return false;
    L7:
        if (NonSdkApiWrapper.isAndroidVWifiApiEnabled() == false) goto L11;
        return TextUtils.equals(this.mUniqueId, r2.getPasspointUniqueId());
    L11:
        return TextUtils.equals(r2.getPasspointFqdn(), this.mFqdn);
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    synchronized void onNetworkCapabilitiesChanged(Network r1, NetworkCapabilities r2) {
        monitor-enter(this);
        super.onNetworkCapabilitiesChanged(r1, r2);     // Catch: Throwable -> L10
        if (canSignIn() == true) goto L6;
    L8:
        monitor-exit(this);
        return;
    L6:
        if (this.mShouldAutoOpenCaptivePortal == false) goto L8;
        this.mShouldAutoOpenCaptivePortal = false;     // Catch: Throwable -> L10
        signIn(null);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    static String uniqueIdToPasspointWifiEntryKey(String r2) {
        Preconditions.checkNotNull(r2, "Cannot create key with null unique id!");
        return KEY_PREFIX + r2;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    synchronized String getNetworkSelectionDescription() {
        monitor-enter(this);
        String r0 = Utils.getNetworkSelectionDescription(this.mWifiConfig);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void setOsuWifiEntry(OsuWifiEntry r1) {
        monitor-enter(this);
        this.mOsuWifiEntry = r1;     // Catch: Throwable -> L8
        if (r1 == null) goto L6;
        r1.setListener(this);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.wifitrackerlib.WifiEntry.WifiEntryCallback
    public void onUpdated() {
        notifyOnUpdated();
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized boolean canSignIn() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.mNetwork != null) goto L6;
    L10:
        boolean r0 = false;
    L11:
        monitor-exit(this);
        return r0;
    L6:
        if (this.mNetworkCapabilities == null) goto L10;
        if (this.mNetworkCapabilities.hasCapability(17) == false) goto L10;
        r0 = true;
        goto L11
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public void signIn(WifiEntry.SignInCallback r2) {
        if (canSignIn() == false) goto L6;
        NonSdkApiWrapper.startCaptivePortalApp((ConnectivityManager) this.mContext.getSystemService(ConnectivityManager.class), this.mNetwork);
        return;
    }

    public PasspointConfiguration getPasspointConfig() {
        return this.mPasspointConfig;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public String toString() {
        StringJoiner r0 = new StringJoiner("][", "[", "]");
        r0.add("FQDN:" + this.mFqdn);
        r0.add("FriendlyName:" + this.mFriendlyName);
        if (this.mPasspointConfig == null) goto L6;
        r0.add("UniqueId:" + this.mPasspointConfig.getUniqueId());
    L9:
        return super.toString() + r0;
    L6:
        if (this.mWifiConfig == null) goto L9;
        r0.add("UniqueId:" + this.mWifiConfig.getKey());
        goto L9
    }
}
