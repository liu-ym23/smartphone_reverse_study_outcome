package com.android.wifitrackerlib;

import android.app.admin.DevicePolicyManager;
import android.app.admin.WifiSsidPolicy;
import android.icu.text.DateFormat;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.wifi.MloLink;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiSsid;
import android.os.Handler;
import android.os.SystemClock;
import android.os.UserHandle;
import android.os.UserManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Log;
import androidx.core.os.BuildCompat;
import com.android.settings.ApnEditor;
import com.android.settingslib.R;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import org.apache.commons.math3.geometry.VectorFormat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class StandardWifiEntry extends WifiEntry {
    public static final String KEY_PREFIX = "StandardWifiEntry:";
    static final String TAG = "StandardWifiEntry";
    private final DevicePolicyManager mDevicePolicyManager;
    private boolean mHasAddConfigUserRestriction;
    private boolean mIsAdminRestricted;
    private final boolean mIsEnhancedOpenSupported;
    private boolean mIsUserShareable;
    private final boolean mIsWpa3SaeSupported;
    private final boolean mIsWpa3SuiteBSupported;
    private final StandardWifiEntryKey mKey;
    private final Map<Integer, List<ScanResult>> mMatchingScanResults;
    private final Map<Integer, WifiConfiguration> mMatchingWifiConfigs;
    private boolean mShouldAutoOpenCaptivePortal;
    private final List<ScanResult> mTargetScanResults;
    private List<Integer> mTargetSecurityTypes;
    private WifiConfiguration mTargetWifiConfig;
    private final UserManager mUserManager;

    static class ScanResultKey {
        private static final String KEY_SECURITY_TYPES = "SECURITY_TYPES";
        private static final String KEY_SSID = "SSID";
        private Set<Integer> mSecurityTypes;
        private String mSsid;

        ScanResultKey() {
            this.mSecurityTypes = new ArraySet();
        }

        ScanResultKey(String r5, List<Integer> r6) {
            this.mSecurityTypes = new ArraySet();
            this.mSsid = r5;
            Iterator<Integer> r7 = r6.iterator();
        L4:
            if (r7.hasNext() == false) goto L26;
            int r8 = r7.next().intValue();
            if (r8 == 0) goto L24;
            if (r8 == 6) goto L23;
            if (r8 == 9) goto L22;
            if (r8 == 2) goto L21;
            if (r8 == 3) goto L20;
            if (r8 == 4) goto L19;
            if (r8 == 11) goto L4;
            if (r8 == 12) goto L4;
        L25:
            this.mSecurityTypes.add(Integer.valueOf(r8));
            goto L4
        L19:
            this.mSecurityTypes.add(2);
            goto L25
        L20:
            this.mSecurityTypes.add(9);
            goto L25
        L21:
            this.mSecurityTypes.add(4);
            goto L25
        L22:
            this.mSecurityTypes.add(3);
            goto L25
        L23:
            this.mSecurityTypes.add(0);
            goto L25
        L24:
            this.mSecurityTypes.add(6);
            goto L25
        }

        ScanResultKey(ScanResult r2) {
            this(r2.SSID, Utils.getSecurityTypesFromScanResult(r2));
        }

        ScanResultKey(WifiConfiguration r2) {
            this(WifiInfo.sanitizeSsid(r2.SSID), Utils.getSecurityTypesFromWifiConfiguration(r2));
        }

        ScanResultKey(String r4) {
            this.mSecurityTypes = new ArraySet();
            JSONObject r0 = new JSONObject(r4);     // Catch: JSONException -> L8
            this.mSsid = r0.getString(KEY_SSID);     // Catch: JSONException -> L8
            JSONArray r5 = r0.getJSONArray(KEY_SECURITY_TYPES);     // Catch: JSONException -> L8
            int r1 = 0;
        L5:
            if (r1 >= r5.length()) goto L14;
            this.mSecurityTypes.add(Integer.valueOf(r5.getInt(r1)));     // Catch: JSONException -> L8
            r1 = r1 + 1;
            goto L5
        L14:
            return;
        L8:
            e = move-exception;
            Log.wtf(StandardWifiEntry.TAG, "JSONException while constructing ScanResultKey from string: " + e);
        }

        public String toString() {
            JSONObject r0 = new JSONObject();
            String r1 = this.mSsid;     // Catch: JSONException -> L14
            if (r1 == null) goto L7;
            r0.put(KEY_SSID, r1);     // Catch: JSONException -> L14
        L7:
            if (this.mSecurityTypes.isEmpty() == true) goto L17;
            JSONArray r2 = new JSONArray();     // Catch: JSONException -> L14
            Iterator<Integer> r3 = this.mSecurityTypes.iterator();     // Catch: JSONException -> L14
        L10:
            if (r3.hasNext() == false) goto L12;
            r2.put(r3.next().intValue());     // Catch: JSONException -> L14
            goto L10
        L12:
            r0.put(KEY_SECURITY_TYPES, r2);     // Catch: JSONException -> L14
        L17:
            return r0.toString();
        L14:
            e = move-exception;
            Log.e(StandardWifiEntry.TAG, "JSONException while converting ScanResultKey to string: " + e);
            goto L17
        }

        String getSsid() {
            return this.mSsid;
        }

        Set<Integer> getSecurityTypes() {
            return this.mSecurityTypes;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L17:
            return false;
        L8:
            if (getClass() != r5.getClass()) goto L17;
            ScanResultKey r6 = (ScanResultKey) r5;
            if (TextUtils.equals(this.mSsid, r6.mSsid) == false) goto L16;
            if (this.mSecurityTypes.equals(r6.mSecurityTypes) == false) goto L16;
            return true;
        L16:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.mSsid, this.mSecurityTypes});
        }
    }

    static class StandardWifiEntryKey {
        private static final String KEY_IS_NETWORK_REQUEST = "IS_NETWORK_REQUEST";
        private static final String KEY_IS_TARGETING_NEW_NETWORKS = "IS_TARGETING_NEW_NETWORKS";
        private static final String KEY_SCAN_RESULT_KEY = "SCAN_RESULT_KEY";
        private static final String KEY_SUGGESTION_PROFILE_KEY = "SUGGESTION_PROFILE_KEY";
        private boolean mIsNetworkRequest;
        private boolean mIsTargetingNewNetworks;
        private ScanResultKey mScanResultKey;
        private String mSuggestionProfileKey;

        StandardWifiEntryKey(ScanResultKey r2) {
            this(r2, false);
        }

        StandardWifiEntryKey(ScanResultKey r1, boolean r2) {
            this.mScanResultKey = r1;
            this.mIsTargetingNewNetworks = r2;
        }

        StandardWifiEntryKey(WifiConfiguration r2) {
            this(r2, false);
        }

        StandardWifiEntryKey(WifiConfiguration r3, boolean r4) {
            this.mIsTargetingNewNetworks = false;
            this.mScanResultKey = new ScanResultKey(r3);
            if (r3.fromWifiNetworkSuggestion == false) goto L6;
            this.mSuggestionProfileKey = new StringJoiner(",").add(r3.creatorName).add(String.valueOf(r3.carrierId)).add(String.valueOf(r3.subscriptionId)).toString();
        L8:
            this.mIsTargetingNewNetworks = r4;
            return;
        L6:
            if (r3.fromWifiNetworkSpecifier == false) goto L8;
            this.mIsNetworkRequest = true;
            goto L8
        }

        StandardWifiEntryKey(String r8) {
            this.mIsTargetingNewNetworks = false;
            this.mScanResultKey = new ScanResultKey();
            if (r8.startsWith(StandardWifiEntry.KEY_PREFIX) == true) goto L22;
            Log.e(StandardWifiEntry.TAG, "String key does not start with key prefix!");
            return;
        L22:
            JSONObject r4 = new JSONObject(r8.substring(18));     // Catch: JSONException -> L19
            if (r4.has(KEY_SCAN_RESULT_KEY) == false) goto L10;
            this.mScanResultKey = new ScanResultKey(r4.getString(KEY_SCAN_RESULT_KEY));     // Catch: JSONException -> L19
        L10:
            if (r4.has(KEY_SUGGESTION_PROFILE_KEY) == false) goto L13;
            this.mSuggestionProfileKey = r4.getString(KEY_SUGGESTION_PROFILE_KEY);     // Catch: JSONException -> L19
        L13:
            if (r4.has(KEY_IS_NETWORK_REQUEST) == false) goto L16;
            this.mIsNetworkRequest = r4.getBoolean(KEY_IS_NETWORK_REQUEST);     // Catch: JSONException -> L19
        L16:
            if (r4.has(KEY_IS_TARGETING_NEW_NETWORKS) == false) goto L24;
            this.mIsTargetingNewNetworks = r4.getBoolean(KEY_IS_TARGETING_NEW_NETWORKS);     // Catch: JSONException -> L19
            return;
        L24:
            return;
        L19:
            e = move-exception;
            Log.e(StandardWifiEntry.TAG, "JSONException while converting StandardWifiEntryKey to string: " + e);
        }

        public String toString() {
            JSONObject r0 = new JSONObject();
            ScanResultKey r1 = this.mScanResultKey;     // Catch: JSONException -> L16
            if (r1 == null) goto L6;
            r0.put(KEY_SCAN_RESULT_KEY, r1.toString());     // Catch: JSONException -> L16
        L6:
            String r2 = this.mSuggestionProfileKey;     // Catch: JSONException -> L16
            if (r2 == null) goto L9;
            r0.put(KEY_SUGGESTION_PROFILE_KEY, r2);     // Catch: JSONException -> L16
        L9:
            boolean r3 = this.mIsNetworkRequest;     // Catch: JSONException -> L16
            if (r3 == false) goto L12;
            r0.put(KEY_IS_NETWORK_REQUEST, r3);     // Catch: JSONException -> L16
        L12:
            boolean r4 = this.mIsTargetingNewNetworks;     // Catch: JSONException -> L16
            if (r4 == false) goto L19;
            r0.put(KEY_IS_TARGETING_NEW_NETWORKS, r4);     // Catch: JSONException -> L16
        L19:
            return StandardWifiEntry.KEY_PREFIX + r0.toString();
        L16:
            e = move-exception;
            Log.wtf(StandardWifiEntry.TAG, "JSONException while converting StandardWifiEntryKey to string: " + e);
            goto L19
        }

        ScanResultKey getScanResultKey() {
            return this.mScanResultKey;
        }

        String getSuggestionProfileKey() {
            return this.mSuggestionProfileKey;
        }

        boolean isNetworkRequest() {
            return this.mIsNetworkRequest;
        }

        boolean isTargetingNewNetworks() {
            return this.mIsTargetingNewNetworks;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L19:
            return false;
        L8:
            if (getClass() != r5.getClass()) goto L19;
            StandardWifiEntryKey r6 = (StandardWifiEntryKey) r5;
            if (Objects.equals(this.mScanResultKey, r6.mScanResultKey) == false) goto L18;
            if (TextUtils.equals(this.mSuggestionProfileKey, r6.mSuggestionProfileKey) == false) goto L18;
            if (this.mIsNetworkRequest != r6.mIsNetworkRequest) goto L18;
            return true;
        L18:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.mScanResultKey, this.mSuggestionProfileKey, Boolean.valueOf(this.mIsNetworkRequest)});
        }
    }

    StandardWifiEntry(WifiTrackerInjector r1, Handler r2, StandardWifiEntryKey r3, WifiManager r4, boolean r5) {
        super(r1, r2, r4, r5);
        this.mMatchingScanResults = new ArrayMap();
        this.mMatchingWifiConfigs = new ArrayMap();
        this.mTargetScanResults = new ArrayList();
        this.mTargetSecurityTypes = new ArrayList();
        this.mIsUserShareable = false;
        this.mShouldAutoOpenCaptivePortal = false;
        this.mIsAdminRestricted = false;
        this.mHasAddConfigUserRestriction = false;
        this.mKey = r3;
        this.mIsWpa3SaeSupported = r4.isWpa3SaeSupported();
        this.mIsWpa3SuiteBSupported = r4.isWpa3SuiteBSupported();
        this.mIsEnhancedOpenSupported = r4.isEnhancedOpenSupported();
        this.mUserManager = r1.getUserManager();
        this.mDevicePolicyManager = r1.getDevicePolicyManager();
        updateSecurityTypes();
        updateAdminRestrictions();
    }

    StandardWifiEntry(WifiTrackerInjector r7, Handler r8, StandardWifiEntryKey r9, List<WifiConfiguration> r10, List<ScanResult> r11, WifiManager r12, boolean r13) throws IllegalArgumentException {
        this(r7, r8, r9, r12, r13);
        if (r10 != null) goto L5;
    L7:
        if (r11 != null) goto L9;
        return;
    L9:
        if (r11.isEmpty() == true) goto L13;
        updateScanResultInfo(r11);
        return;
    L13:
        return;
    L5:
        if (r10.isEmpty() == true) goto L7;
        updateConfig(r10);
        goto L7
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public String getKey() {
        return this.mKey.toString();
    }

    StandardWifiEntryKey getStandardWifiEntryKey() {
        return this.mKey;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public String getTitle() {
        return this.mKey.getScanResultKey().getSsid();
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized String getSummary(boolean r9) {
        monitor-enter(this);
        StringJoiner r1 = new StringJoiner(this.mContext.getString(R.string.wifitrackerlib_summary_separator));     // Catch: Throwable -> L35
        int r2 = getConnectedState();     // Catch: Throwable -> L35
        if (r2 != 0) goto L7;
        String r4 = Utils.getDisconnectedDescription(this.mInjector, this.mContext, this.mTargetWifiConfig, this.mForSavedNetworksPage, r9);     // Catch: Throwable -> L35
    L18:
        if (TextUtils.isEmpty(r4) == true) goto L20;
        r1.add(r4);     // Catch: Throwable -> L35
    L20:
        String r0 = Utils.getAutoConnectDescription(this.mContext, this);     // Catch: Throwable -> L35
        if (TextUtils.isEmpty(r0) == true) goto L23;
        r1.add(r0);     // Catch: Throwable -> L35
    L23:
        String r3 = Utils.getMeteredDescription(this.mContext, this);     // Catch: Throwable -> L35
        if (TextUtils.isEmpty(r3) == true) goto L26;
        r1.add(r3);     // Catch: Throwable -> L35
    L26:
        if (r9 == false) goto L28;
    L32:
        String r10 = r1.toString();     // Catch: Throwable -> L35
        monitor-exit(this);
        return r10;
    L28:
        if (isVerboseSummaryEnabled() == false) goto L32;
        String r11 = Utils.getVerboseSummary(this);     // Catch: Throwable -> L35
        if (TextUtils.isEmpty(r11) == true) goto L32;
        r1.add(r11);     // Catch: Throwable -> L35
        goto L32
    L7:
        if (r2 == 1) goto L15;
        r4 = null;
        if (r2 == 2) goto L12;
        Log.e(TAG, "getConnectedState() returned unknown state: " + r2);     // Catch: Throwable -> L35
        goto L18
    L12:
        if (this.mNetworkCapabilities != null) goto L14;
        Log.e(TAG, "Tried to get CONNECTED description, but mNetworkCapabilities was unexpectedly null!");     // Catch: Throwable -> L35
        goto L18
    L14:
        r4 = Utils.getConnectedDescription(this.mContext, this.mTargetWifiConfig, this.mNetworkCapabilities, isDefaultNetwork(), isLowQuality(), this.mConnectivityReport);     // Catch: Throwable -> L35
        goto L18
    L15:
        r4 = Utils.getConnectingDescription(this.mContext, this.mNetworkInfo);     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        throw th;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public String getSsid() {
        return this.mKey.getScanResultKey().getSsid();
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
        if (this.mTargetWifiConfig != null) goto L14;
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
        String r3 = this.mTargetWifiConfig.getRandomizedMacAddress().toString();     // Catch: Throwable -> L27
        monitor-exit(this);
        return r3;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized boolean isMetered() {
        monitor-enter(this);
        boolean r1 = true;
        if (getMeteredChoice() == 1) goto L11;
        WifiConfiguration r0 = this.mTargetWifiConfig;     // Catch: Throwable -> L13
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
    public synchronized boolean isSaved() {
        monitor-enter(this);
        WifiConfiguration r0 = this.mTargetWifiConfig;     // Catch: Throwable -> L13
        if (r0 != null) goto L6;
    L10:
        boolean r1 = false;
    L11:
        monitor-exit(this);
        return r1;
    L6:
        if (r0.fromWifiNetworkSuggestion == true) goto L10;
        if (this.mTargetWifiConfig.isEphemeral() == true) goto L10;
        r1 = true;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized boolean isSuggestion() {
        monitor-enter(this);
        WifiConfiguration r0 = this.mTargetWifiConfig;     // Catch: Throwable -> L11
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
    public boolean needsWifiConfiguration() {
        List<Integer> r0 = getSecurityTypes();
        if (isSaved() == false) goto L5;
        return false;
    L5:
        if (isSuggestion() == false) goto L7;
        return false;
    L7:
        if (r0.contains(0) == false) goto L9;
        return false;
    L9:
        if (r0.contains(6) == true) goto L15;
        return true;
    L15:
        return false;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized WifiConfiguration getWifiConfiguration() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (isSaved() == true) goto L8;
        monitor-exit(this);
        return null;
    L8:
        WifiConfiguration r0 = this.mTargetWifiConfig;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r0;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized boolean canConnect() {
        monitor-enter(this);
    L46:
        th = move-exception;
        throw th;
    L4:
        if (this.mLevel != (-1)) goto L6;
    L44:
        monitor-exit(this);
        return false;
    L6:
        if (getConnectedState() != 0) goto L44;
        if (hasAdminRestrictions() == false) goto L13;
        monitor-exit(this);
        return false;
    L13:
        if (this.mTargetSecurityTypes.contains(3) == false) goto L42;
        WifiConfiguration r0 = this.mTargetWifiConfig;     // Catch: Throwable -> L46
        if (r0 == null) goto L42;
        if (r0.enterpriseConfig == null) goto L42;
        if (this.mTargetWifiConfig.enterpriseConfig.isAuthenticationSimBased() == true) goto L22;
        monitor-exit(this);
        return true;
    L22:
        List<SubscriptionInfo> r1 = ((SubscriptionManager) this.mContext.getSystemService(SubscriptionManager.class)).getActiveSubscriptionInfoList();     // Catch: Throwable -> L46
        if (r1 != null) goto L25;
    L40:
        monitor-exit(this);
        return false;
    L25:
        if (r1.size() == 0) goto L40;
        if (this.mTargetWifiConfig.carrierId != (-1)) goto L31;
        monitor-exit(this);
        return true;
    L31:
        Iterator<SubscriptionInfo> r2 = r1.iterator();     // Catch: Throwable -> L46
    L33:
        if (r2.hasNext() == false) goto L38;
        if (r2.next().getCarrierId() != this.mTargetWifiConfig.carrierId) goto L33;
        monitor-exit(this);
        return true;
    L38:
        monitor-exit(this);
        return false;
    L42:
        monitor-exit(this);
        return true;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized void connect(final WifiEntry.ConnectCallback r7) {
        monitor-enter(this);
        this.mConnectCallback = r7;     // Catch: Throwable -> L30
        this.mShouldAutoOpenCaptivePortal = true;     // Catch: Throwable -> L30
        this.mWifiManager.stopRestrictingAutoJoinToSubscriptionId();     // Catch: Throwable -> L30
        if (isSaved() == true) goto L20;
        if (isSuggestion() == true) goto L20;
        if (this.mTargetSecurityTypes.contains(6) == false) goto L15;
        WifiConfiguration r8 = new WifiConfiguration();     // Catch: Throwable -> L30
        r8.SSID = "\"" + this.mKey.getScanResultKey().getSsid() + "\"";     // Catch: Throwable -> L30
        r8.setSecurityParams(6);     // Catch: Throwable -> L30
        this.mWifiManager.connect(r8, new WifiEntry.ConnectActionListener(this));     // Catch: Throwable -> L30
        if (this.mTargetSecurityTypes.contains(0) == false) goto L28;
        WifiConfiguration r9 = new WifiConfiguration();     // Catch: Throwable -> L30
        r9.SSID = "\"" + this.mKey.getScanResultKey().getSsid() + "\"";     // Catch: Throwable -> L30
        r9.setSecurityParams(0);     // Catch: Throwable -> L30
        this.mWifiManager.save(r9, null);     // Catch: Throwable -> L30
    L28:
        monitor-exit(this);
        return;
    L15:
        if (this.mTargetSecurityTypes.contains(0) == false) goto L17;
        WifiConfiguration r10 = new WifiConfiguration();     // Catch: Throwable -> L30
        r10.SSID = "\"" + this.mKey.getScanResultKey().getSsid() + "\"";     // Catch: Throwable -> L30
        r10.setSecurityParams(0);     // Catch: Throwable -> L30
        this.mWifiManager.connect(r10, new WifiEntry.ConnectActionListener(this));     // Catch: Throwable -> L30
        goto L28
    L17:
        if (r7 == null) goto L28;
        this.mCallbackHandler.post(new StandardWifiEntry$$ExternalSyntheticLambda1(r7));     // Catch: Throwable -> L30
    L20:
        if (Utils.isSimCredential(this.mTargetWifiConfig) == true) goto L22;
    L27:
        this.mWifiManager.connect(this.mTargetWifiConfig.networkId, new WifiEntry.ConnectActionListener(this));     // Catch: Throwable -> L30
        goto L28
    L22:
        if (Utils.isSimPresent(this.mContext, this.mTargetWifiConfig.carrierId) == true) goto L27;
        if (r7 == null) goto L25;
        this.mCallbackHandler.post(new StandardWifiEntry$$ExternalSyntheticLambda0(r7));     // Catch: Throwable -> L30
    L25:
        monitor-exit(this);
        return;
    L30:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ void lambda$connect$0(WifiEntry.ConnectCallback r1) {
        r1.onConnectResult(3);
    }

    static /* synthetic */ void lambda$connect$1(WifiEntry.ConnectCallback r1) {
        r1.onConnectResult(1);
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public boolean canDisconnect() {
        if (getConnectedState() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized void disconnect(final WifiEntry.DisconnectCallback r6) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (canDisconnect() == false) goto L7;
        this.mCalledDisconnect = true;     // Catch: Throwable -> L9
        this.mDisconnectCallback = r6;     // Catch: Throwable -> L9
        this.mCallbackHandler.postDelayed(new StandardWifiEntry$$ExternalSyntheticLambda2(this, r6), 10000);     // Catch: Throwable -> L9
        this.mWifiManager.disableEphemeralNetwork("\"" + this.mKey.getScanResultKey().getSsid() + "\"");     // Catch: Throwable -> L9
        this.mWifiManager.disconnect();     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
    }

    /* JADX INFO: renamed from: lambda$disconnect$2$com-android-wifitrackerlib-StandardWifiEntry, reason: not valid java name */
    /* synthetic */ void m871lambda$disconnect$2$comandroidwifitrackerlibStandardWifiEntry(WifiEntry.DisconnectCallback r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (this.mCalledDisconnect == false) goto L8;
        r1.onDisconnectResult(1);
        return;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public boolean canForget() {
        if (getWifiConfiguration() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized void forget(WifiEntry.ForgetCallback r3) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (canForget() == false) goto L6;
        this.mForgetCallback = r3;     // Catch: Throwable -> L8
        this.mWifiManager.forget(this.mTargetWifiConfig.networkId, new WifiEntry.ForgetActionListener(this));     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
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

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized boolean canShare() {
        monitor-enter(this);
    L38:
        th = move-exception;
        throw th;
    L5:
        if (this.mInjector.isDemoMode() == false) goto L8;
        monitor-exit(this);
        return false;
    L8:
        WifiConfiguration r0 = getWifiConfiguration();     // Catch: Throwable -> L38
        if (r0 != null) goto L13;
        monitor-exit(this);
        return false;
    L13:
        if (BuildCompat.isAtLeastT() == true) goto L15;
    L20:
        Iterator<Integer> r1 = this.mTargetSecurityTypes.iterator();     // Catch: Throwable -> L38
    L21:
        if (r1.hasNext() == false) goto L36;
        int r2 = r1.next().intValue();     // Catch: Throwable -> L38
        if (r2 == 0) goto L34;
        if (r2 == 1) goto L34;
        if (r2 == 2) goto L34;
        if (r2 == 4) goto L34;
        if (r2 != 6) goto L21;
    L34:
        monitor-exit(this);
        return true;
    L36:
        monitor-exit(this);
        return false;
    L15:
        if (this.mUserManager.hasUserRestrictionForUser("no_sharing_admin_configured_wifi", UserHandle.getUserHandleForUid(r0.creatorUid)) == false) goto L20;
        if (Utils.isDeviceOrProfileOwner(r0.creatorUid, r0.creatorName, this.mContext) == false) goto L20;
        monitor-exit(this);
        return false;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized boolean canEasyConnect() {
        monitor-enter(this);
    L31:
        th = move-exception;
        throw th;
    L4:
        boolean r1 = false;
        if (this.mInjector.isDemoMode() == false) goto L8;
        monitor-exit(this);
        return false;
    L8:
        WifiConfiguration r0 = getWifiConfiguration();     // Catch: Throwable -> L31
        if (r0 != null) goto L13;
        monitor-exit(this);
        return false;
    L13:
        if (this.mWifiManager.isEasyConnectSupported() == true) goto L17;
        monitor-exit(this);
        return false;
    L17:
        if (BuildCompat.isAtLeastT() == false) goto L25;
        if (this.mUserManager.hasUserRestrictionForUser("no_sharing_admin_configured_wifi", UserHandle.getUserHandleForUid(r0.creatorUid)) == false) goto L25;
        if (Utils.isDeviceOrProfileOwner(r0.creatorUid, r0.creatorName, this.mContext) == false) goto L25;
        monitor-exit(this);
        return false;
    L25:
        if (this.mTargetSecurityTypes.contains(2) == true) goto L28;
        if (this.mTargetSecurityTypes.contains(4) == true) goto L28;
    L29:
        monitor-exit(this);
        return r1;
    L28:
        r1 = true;
        goto L29
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized int getMeteredChoice() {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (isSuggestion() == true) goto L16;
        WifiConfiguration r0 = this.mTargetWifiConfig;     // Catch: Throwable -> L19
        if (r0 == null) goto L16;
        int r1 = r0.meteredOverride;     // Catch: Throwable -> L19
        if (r1 != 1) goto L13;
        monitor-exit(this);
        return 1;
    L13:
        if (r1 != 2) goto L16;
        monitor-exit(this);
        return 2;
    L16:
        monitor-exit(this);
        return 0;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public boolean canSetMeteredChoice() {
        if (getWifiConfiguration() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized void setMeteredChoice(int r3) {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (canSetMeteredChoice() == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        refreshTargetWifiConfig();     // Catch: Throwable -> L19
        if (r3 != 0) goto L11;
        this.mTargetWifiConfig.meteredOverride = 0;     // Catch: Throwable -> L19
    L16:
        this.mWifiManager.save(this.mTargetWifiConfig, null);     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L11:
        if (r3 != 1) goto L14;
        this.mTargetWifiConfig.meteredOverride = 1;     // Catch: Throwable -> L19
        goto L16
    L14:
        if (r3 != 2) goto L16;
        this.mTargetWifiConfig.meteredOverride = 2;     // Catch: Throwable -> L19
        goto L16
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public boolean canSetPrivacy() {
        return isSaved();
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized int getPrivacy() {
        monitor-enter(this);
        WifiConfiguration r0 = this.mTargetWifiConfig;     // Catch: Throwable -> L13
        if (r0 == null) goto L10;
        if (r0.macRandomizationSetting != 0) goto L10;
        monitor-exit(this);
        return 0;
    L10:
        monitor-exit(this);
        return 1;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized void setPrivacy(int r3) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (canSetPrivacy() == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        refreshTargetWifiConfig();     // Catch: Throwable -> L14
        WifiConfiguration r0 = this.mTargetWifiConfig;     // Catch: Throwable -> L14
        if (r3 != 1) goto L10;
        int r4 = 3;
    L11:
        r0.macRandomizationSetting = r4;     // Catch: Throwable -> L14
        this.mWifiManager.save(this.mTargetWifiConfig, null);     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L10:
        r4 = 0;
        goto L11
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized boolean isAutoJoinEnabled() {
        monitor-enter(this);
        WifiConfiguration r0 = this.mTargetWifiConfig;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        monitor-exit(this);
        return false;
    L8:
        boolean r1 = r0.allowAutojoin;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public boolean canSetAutoJoinEnabled() {
        if (isSaved() == false) goto L5;
    L8:
        return true;
    L5:
        if (isSuggestion() == true) goto L8;
        return false;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized void setAutoJoinEnabled(boolean r3) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.mTargetWifiConfig != null) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (canSetAutoJoinEnabled() == false) goto L11;
        this.mWifiManager.allowAutojoin(this.mTargetWifiConfig.networkId, r3);     // Catch: Throwable -> L13
        monitor-exit(this);
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized String getSecurityString(boolean r3) {
        monitor-enter(this);
        String r4 = Utils.getSecurityString(this.mContext, this.mTargetSecurityTypes, r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r4;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized String getStandardString() {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.mWifiInfo == null) goto L9;
        String r0 = Utils.getStandardString(this.mContext, this.mWifiInfo.getWifiStandard());     // Catch: Throwable -> L16
        monitor-exit(this);
        return r0;
    L9:
        if (this.mTargetScanResults.isEmpty() == true) goto L14;
        String r1 = Utils.getStandardString(this.mContext, this.mTargetScanResults.get(0).getWifiStandard());     // Catch: Throwable -> L16
        monitor-exit(this);
        return r1;
    L14:
        monitor-exit(this);
        return "";
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public WifiEntry.CertificateInfo getCertificateInfo() {
        WifiConfiguration r1 = this.mTargetWifiConfig;
        if (r1 != null) goto L5;
        return null;
    L5:
        if (r1.enterpriseConfig != null) goto L8;
        return null;
    L8:
        return Utils.getCertificateInfo(r1.enterpriseConfig);
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized String getBandString() {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.mWifiInfo == null) goto L9;
        String r0 = Utils.wifiInfoToBandString(this.mContext, this.mWifiInfo);     // Catch: Throwable -> L16
        monitor-exit(this);
        return r0;
    L9:
        if (this.mTargetScanResults.isEmpty() == true) goto L14;
        String r1 = Utils.frequencyToBandString(this.mContext, this.mTargetScanResults.get(0).frequency);     // Catch: Throwable -> L16
        monitor-exit(this);
        return r1;
    L14:
        monitor-exit(this);
        return "";
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized boolean shouldEditBeforeConnect() {
        monitor-enter(this);
        WifiConfiguration r0 = getWifiConfiguration();     // Catch: Throwable -> L24
        if (r0 != null) goto L8;
        monitor-exit(this);
        return false;
    L8:
        WifiConfiguration.NetworkSelectionStatus r1 = r0.getNetworkSelectionStatus();     // Catch: Throwable -> L24
        if (r1.getNetworkSelectionStatus() != 0) goto L13;
        if (r1.hasEverConnected() == false) goto L13;
    L19:
        monitor-exit(this);
        return false;
    L13:
        if (r1.getDisableReasonCounter(2) <= 0) goto L15;
    L21:
        monitor-exit(this);
        return true;
    L15:
        if (r1.getDisableReasonCounter(8) > 0) goto L21;
        if (r1.getDisableReasonCounter(5) <= 0) goto L19;
    L24:
        th = move-exception;
        throw th;
    }

    synchronized void updateScanResultInfo(List<ScanResult> r8) throws IllegalArgumentException {
        monitor-enter(this);
        if (r8 == null) goto L34;
    L5:
        String r0 = this.mKey.getScanResultKey().getSsid();     // Catch: Throwable -> L31
        Iterator<ScanResult> r1 = r8.iterator();     // Catch: Throwable -> L31
    L7:
        if (r1.hasNext() == false) goto L13;
        ScanResult r2 = r1.next();     // Catch: Throwable -> L31
        if (TextUtils.equals(r2.SSID, r0) == true) goto L7;
        throw new IllegalArgumentException("Attempted to update with wrong SSID! Expected: " + r0 + ", Actual: " + r2.SSID + ", ScanResult: " + r2);     // Catch: Throwable -> L31
    L13:
        this.mMatchingScanResults.clear();     // Catch: Throwable -> L31
        Set<Integer> r3 = this.mKey.getScanResultKey().getSecurityTypes();     // Catch: Throwable -> L31
        Iterator<ScanResult> r9 = r8.iterator();     // Catch: Throwable -> L31
    L15:
        if (r9.hasNext() == false) goto L28;
        ScanResult r4 = r9.next();     // Catch: Throwable -> L31
        Iterator<Integer> r5 = Utils.getSecurityTypesFromScanResult(r4).iterator();     // Catch: Throwable -> L31
    L18:
        if (r5.hasNext() == false) goto L15;
        int r6 = r5.next().intValue();     // Catch: Throwable -> L31
        if (r3.contains(Integer.valueOf(r6)) == false) goto L18;
        if (isSecurityTypeSupported(r6) == false) goto L18;
        if (this.mMatchingScanResults.containsKey(Integer.valueOf(r6)) == true) goto L27;
        this.mMatchingScanResults.put(Integer.valueOf(r6), new ArrayList());     // Catch: Throwable -> L31
    L27:
        this.mMatchingScanResults.get(Integer.valueOf(r6)).add(r4);     // Catch: Throwable -> L31
        goto L18
    L28:
        updateSecurityTypes();     // Catch: Throwable -> L31
        updateTargetScanResultInfo();     // Catch: Throwable -> L31
        notifyOnUpdated();     // Catch: Throwable -> L31
        monitor-exit(this);
        return;
    L34:
        r8 = new ArrayList();     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    }

    private synchronized void updateTargetScanResultInfo() {
        monitor-enter(this);
        ScanResult r0 = Utils.getBestScanResultByLevel(this.mTargetScanResults);     // Catch: Throwable -> L15
        if (r0 == null) goto L7;
        updateTransitionModeCapa(r0);     // Catch: Throwable -> L15
    L7:
        if (getConnectedState() != 0) goto L12;
        if (r0 == null) goto L10;
        int r1 = this.mWifiManager.calculateSignalLevel(r0.level);     // Catch: Throwable -> L15
    L11:
        this.mLevel = r1;     // Catch: Throwable -> L15
        goto L12
    L10:
        r1 = -1;
    L12:
        updateWifiGenerationInfo(this.mTargetScanResults);     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
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

    synchronized void updateConfig(List<WifiConfiguration> r7) throws IllegalArgumentException {
        monitor-enter(this);
        if (r7 == null) goto L28;
    L5:
        ScanResultKey r0 = this.mKey.getScanResultKey();     // Catch: Throwable -> L25
        String r1 = r0.getSsid();     // Catch: Throwable -> L25
        Set<Integer> r2 = r0.getSecurityTypes();     // Catch: Throwable -> L25
        this.mMatchingWifiConfigs.clear();     // Catch: Throwable -> L25
        Iterator<WifiConfiguration> r8 = r7.iterator();     // Catch: Throwable -> L25
    L7:
        if (r8.hasNext() == false) goto L22;
        WifiConfiguration r3 = r8.next();     // Catch: Throwable -> L25
        if (TextUtils.equals(r1, WifiInfo.sanitizeSsid(r3.SSID)) == false) goto L21;
        Iterator<Integer> r4 = Utils.getSecurityTypesFromWifiConfiguration(r3).iterator();     // Catch: Throwable -> L25
    L12:
        if (r4.hasNext() == false) goto L7;
        int r5 = r4.next().intValue();     // Catch: Throwable -> L25
        if (r2.contains(Integer.valueOf(r5)) == false) goto L19;
        if (isSecurityTypeSupported(r5) == false) goto L12;
        this.mMatchingWifiConfigs.put(Integer.valueOf(r5), r3);     // Catch: Throwable -> L25
        goto L12
    L19:
        throw new IllegalArgumentException("Attempted to update with wrong security! Expected one of: " + r2 + ", Actual: " + r5 + ", Config: " + r3);     // Catch: Throwable -> L25
    L21:
        throw new IllegalArgumentException("Attempted to update with wrong SSID! Expected: " + r1 + ", Actual: " + WifiInfo.sanitizeSsid(r3.SSID) + ", Config: " + r3);     // Catch: Throwable -> L25
    L22:
        updateSecurityTypes();     // Catch: Throwable -> L25
        updateTargetScanResultInfo();     // Catch: Throwable -> L25
        notifyOnUpdated();     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L28:
        r7 = Collections.emptyList();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    private boolean isSecurityTypeSupported(int r2) {
        if (r2 == 4) goto L15;
        if (r2 == 5) goto L13;
        if (r2 == 6) goto L11;
        return true;
    L11:
        return this.mIsEnhancedOpenSupported;
    L13:
        return this.mIsWpa3SuiteBSupported;
    L15:
        return this.mIsWpa3SaeSupported;
    }

    private void refreshTargetWifiConfig() {
        Iterator r0 = this.mWifiManager.getPrivilegedConfiguredNetworks().iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        WifiConfiguration r1 = (WifiConfiguration) r0.next();
        if (r1.networkId != this.mTargetWifiConfig.networkId) goto L4;
        this.mTargetWifiConfig = r1;
        return;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    protected synchronized void updateSecurityTypes() {
        monitor-enter(this);
        this.mTargetSecurityTypes.clear();     // Catch: Throwable -> L36
        if (this.mWifiInfo != null) goto L6;
    L8:
        Set<Integer> r0 = this.mMatchingWifiConfigs.keySet();     // Catch: Throwable -> L36
        if (this.mTargetSecurityTypes.isEmpty() == false) goto L22;
        if (this.mKey.isTargetingNewNetworks() == false) goto L22;
        Set<Integer> r1 = this.mMatchingScanResults.keySet();     // Catch: Throwable -> L36
        Iterator<Integer> r2 = r0.iterator();     // Catch: Throwable -> L36
    L14:
        if (r2.hasNext() == false) goto L18;
        if (r1.contains(Integer.valueOf(r2.next().intValue())) == false) goto L14;
        boolean r3 = true;
    L19:
        if (r3 == true) goto L22;
        this.mTargetSecurityTypes.addAll(r1);     // Catch: Throwable -> L36
        goto L22
    L18:
        r3 = false;
    L22:
        if (this.mTargetSecurityTypes.isEmpty() == false) goto L25;
        this.mTargetSecurityTypes.addAll(r0);     // Catch: Throwable -> L36
    L25:
        if (this.mTargetSecurityTypes.isEmpty() == false) goto L27;
        this.mTargetSecurityTypes.addAll(this.mKey.getScanResultKey().getSecurityTypes());     // Catch: Throwable -> L36
    L27:
        this.mTargetWifiConfig = this.mMatchingWifiConfigs.get(Integer.valueOf(Utils.getSingleSecurityTypeFromMultipleSecurityTypes(this.mTargetSecurityTypes)));     // Catch: Throwable -> L36
        ArraySet r4 = new ArraySet();     // Catch: Throwable -> L36
        Iterator<Integer> r5 = this.mTargetSecurityTypes.iterator();     // Catch: Throwable -> L36
    L29:
        if (r5.hasNext() == false) goto L33;
        int r6 = r5.next().intValue();     // Catch: Throwable -> L36
        if (this.mMatchingScanResults.containsKey(Integer.valueOf(r6)) == false) goto L29;
        r4.addAll(this.mMatchingScanResults.get(Integer.valueOf(r6)));     // Catch: Throwable -> L36
        goto L29
    L33:
        this.mTargetScanResults.clear();     // Catch: Throwable -> L36
        this.mTargetScanResults.addAll(r4);     // Catch: Throwable -> L36
        monitor-exit(this);
        return;
    L6:
        if (this.mWifiInfo.getCurrentSecurityType() == (-1)) goto L8;
        this.mTargetSecurityTypes.add(Integer.valueOf(this.mWifiInfo.getCurrentSecurityType()));     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        throw th;
    }

    synchronized void setUserShareable(boolean r1) {
        monitor-enter(this);
        this.mIsUserShareable = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized boolean isUserShareable() {
        monitor-enter(this);
        boolean r0 = this.mIsUserShareable;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    protected synchronized boolean connectionInfoMatches(WifiInfo r5) {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (r5.isPasspointAp() == false) goto L6;
    L18:
        monitor-exit(this);
        return false;
    L6:
        if (r5.isOsuAp() == true) goto L18;
        Iterator<WifiConfiguration> r0 = this.mMatchingWifiConfigs.values().iterator();     // Catch: Throwable -> L20
    L10:
        if (r0.hasNext() == false) goto L16;
        if (r0.next().networkId != r5.getNetworkId()) goto L10;
        monitor-exit(this);
        return true;
    L16:
        monitor-exit(this);
        return false;
    }

    static StandardWifiEntryKey ssidAndSecurityTypeToStandardWifiEntryKey(String r1, int r2) {
        return ssidAndSecurityTypeToStandardWifiEntryKey(r1, r2, false);
    }

    static StandardWifiEntryKey ssidAndSecurityTypeToStandardWifiEntryKey(String r2, int r3, boolean r4) {
        return new StandardWifiEntryKey(new ScanResultKey(r2, Collections.singletonList(Integer.valueOf(r3))), r4);
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    protected synchronized String getScanResultDescription() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mTargetScanResults.size() == 0) goto L7;
        StringBuilder r1 = new StringBuilder("[");     // Catch: Throwable -> L12
        r1.append(getScanResultDescription(2400, 2500)).append(";");     // Catch: Throwable -> L12
        r1.append(getScanResultDescription(4900, 5900)).append(";");     // Catch: Throwable -> L12
        r1.append(getScanResultDescription(WifiEntry.MIN_FREQ_6GHZ, WifiEntry.MAX_FREQ_6GHZ)).append(";");     // Catch: Throwable -> L12
        r1.append(getScanResultDescription(58320, 70200));     // Catch: Throwable -> L12
        r1.append("]");     // Catch: Throwable -> L12
        String r0 = r1.toString();     // Catch: Throwable -> L12
        monitor-exit(this);
        return r0;
    L7:
        monitor-exit(this);
        return "";
    }

    private synchronized String getScanResultDescription(final int r4, final int r5) {
        monitor-enter(this);
        List r6 = (List) this.mTargetScanResults.stream().filter(new StandardWifiEntry$$ExternalSyntheticLambda3(r4, r5)).sorted(Comparator.comparingInt(new StandardWifiEntry$$ExternalSyntheticLambda4())).collect(Collectors.toList());     // Catch: Throwable -> L14
        int r7 = r6.size();     // Catch: Throwable -> L14
        if (r7 == 0) goto L6;
        final StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L14
        r0.append("(").append(r7).append(")");     // Catch: Throwable -> L14
        if (r7 <= 4) goto L11;
        int r8 = r6.stream().mapToInt(new StandardWifiEntry$$ExternalSyntheticLambda5()).max().getAsInt();     // Catch: Throwable -> L14
        r0.append("max=").append(r8).append(",");     // Catch: Throwable -> L14
    L11:
        final long r1 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L14
        r6.forEach(new StandardWifiEntry$$ExternalSyntheticLambda6(this, r0, r1));     // Catch: Throwable -> L14
        String r9 = r0.toString();     // Catch: Throwable -> L14
        monitor-exit(this);
        return r9;
    L6:
        monitor-exit(this);
        return "";
    L14:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ boolean lambda$getScanResultDescription$3(int r1, int r2, ScanResult r3) {
        if (r3.frequency >= r1) goto L5;
    L7:
        return false;
    L5:
        if (r3.frequency > r2) goto L7;
        return true;
    }

    static /* synthetic */ int lambda$getScanResultDescription$4(ScanResult r0) {
        return r0.level * (-1);
    }

    static /* synthetic */ int lambda$getScanResultDescription$5(ScanResult r0) {
        return r0.level;
    }

    /* JADX INFO: renamed from: lambda$getScanResultDescription$6$com-android-wifitrackerlib-StandardWifiEntry, reason: not valid java name */
    /* synthetic */ void m872x2217af08(StringBuilder r1, long r2, ScanResult r4) {
        r1.append(getScanResultDescription(r4, r2));
    }

    private synchronized String getScanResultDescription(ScanResult r11, long r12) {
        monitor-enter(this);
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L29
        r0.append(" \n{");     // Catch: Throwable -> L29
        r0.append(r11.BSSID);     // Catch: Throwable -> L29
        if (this.mWifiInfo != null) goto L6;
    L8:
        r0.append("=").append(r11.frequency);     // Catch: Throwable -> L29
        r0.append(",").append(r11.level);     // Catch: Throwable -> L29
        int r1 = r11.getWifiStandard();     // Catch: Throwable -> L29
        r0.append(",").append(Utils.getStandardString(this.mContext, r1));     // Catch: Throwable -> L29
        if (BuildCompat.isAtLeastT() == true) goto L11;
    L26:
        r0.append(",").append(((int) (r12 - (r11.timestamp / 1000))) / 1000).append(DateFormat.SECOND);     // Catch: Throwable -> L29
        r0.append(VectorFormat.DEFAULT_SUFFIX);     // Catch: Throwable -> L29
        String r13 = r0.toString();     // Catch: Throwable -> L29
        monitor-exit(this);
        return r13;
    L11:
        if (r1 != 8) goto L26;
        r0.append(",mldMac=").append(r11.getApMldMacAddress());     // Catch: Throwable -> L29
        r0.append(",linkId=").append(r11.getApMloLinkId());     // Catch: Throwable -> L29
        r0.append(",affLinks=");     // Catch: Throwable -> L29
        StringJoiner r2 = new StringJoiner(",", "[", "]");     // Catch: Throwable -> L29
        Iterator<MloLink> r3 = r11.getAffiliatedMloLinks().iterator();     // Catch: Throwable -> L29
    L14:
        if (r3.hasNext() == false) goto L25;
        MloLink r4 = r3.next();     // Catch: Throwable -> L29
        int r5 = r4.getBand();     // Catch: Throwable -> L29
        int r6 = 1;
        if (r5 == 1) goto L24;
        r6 = 2;
        if (r5 == 2) goto L24;
        if (r5 == 8) goto L23;
        r6 = 16;
        if (r5 == 16) goto L24;
        Log.e(TAG, "Unknown MLO link band: " + r4.getBand());     // Catch: Throwable -> L29
        r6 = -1;
        goto L24
    L23:
        r6 = 8;
    L24:
        r2.add(new StringJoiner(",", VectorFormat.DEFAULT_PREFIX, VectorFormat.DEFAULT_SUFFIX).add("apMacAddr=" + r4.getApMacAddress()).add("freq=" + ScanResult.convertChannelToFrequencyMhzIfSupported(r4.getChannel(), r6)).toString());     // Catch: Throwable -> L29
        goto L14
    L25:
        r0.append(r2.toString());     // Catch: Throwable -> L29
        goto L26
    L6:
        if (r11.BSSID.equals(this.mWifiInfo.getBSSID()) == false) goto L8;
        r0.append(ApnEditor.APN_TYPE_ALL);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    String getNetworkSelectionDescription() {
        return Utils.getNetworkSelectionDescription(getWifiConfiguration());
    }

    void updateAdminRestrictions() {
        if (BuildCompat.isAtLeastT() == true) goto L5;
        return;
    L5:
        UserManager r0 = this.mUserManager;
        if (r0 == null) goto L8;
        this.mHasAddConfigUserRestriction = r0.hasUserRestriction("no_add_wifi_config");
    L8:
        DevicePolicyManager r1 = this.mDevicePolicyManager;
        if (r1 == null) goto L37;
        int r2 = r1.getMinimumRequiredWifiSecurityLevel();
        if (r2 == 0) goto L24;
        Iterator<Integer> r3 = getSecurityTypes().iterator();
    L14:
        if (r3.hasNext() == false) goto L20;
        int r4 = Utils.convertSecurityTypeToDpmWifiSecurity(r3.next().intValue());
        if (r4 == (-1)) goto L14;
        if (r2 > r4) goto L14;
        boolean r5 = true;
    L21:
        if (r5 == true) goto L24;
        this.mIsAdminRestricted = true;
        return;
    L20:
        r5 = false;
    L24:
        WifiSsidPolicy r6 = NonSdkApiWrapper.getWifiSsidPolicy(this.mDevicePolicyManager);
        if (r6 == null) goto L37;
        int r7 = r6.getPolicyType();
        Set<WifiSsid> r8 = r6.getSsids();
        if (r7 == 0) goto L29;
    L32:
        if (r7 != 1) goto L37;
        if (r8.contains(WifiSsid.fromBytes(getSsid().getBytes(StandardCharsets.UTF_8))) == false) goto L37;
        this.mIsAdminRestricted = true;
        return;
    L29:
        if (r8.contains(WifiSsid.fromBytes(getSsid().getBytes(StandardCharsets.UTF_8))) == true) goto L32;
        this.mIsAdminRestricted = true;
        return;
    L37:
        this.mIsAdminRestricted = false;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public synchronized boolean hasAdminRestrictions() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.mHasAddConfigUserRestriction == true) goto L6;
    L9:
        if (this.mIsAdminRestricted == false) goto L14;
    L11:
        monitor-exit(this);
        return true;
    L14:
        monitor-exit(this);
        return false;
    L6:
        if (isSaved() == true) goto L9;
        if (isSuggestion() == false) goto L11;
        goto L9
    }
}
