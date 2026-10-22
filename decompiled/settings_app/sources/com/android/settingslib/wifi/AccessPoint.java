package com.android.settingslib.wifi;

import android.app.AppGlobals;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkKey;
import android.net.NetworkScoreManager;
import android.net.NetworkScorerAppData;
import android.net.ScoredNetwork;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiNetworkScoreCache;
import android.net.wifi.hotspot2.OsuProvider;
import android.net.wifi.hotspot2.PasspointConfiguration;
import android.net.wifi.hotspot2.ProvisioningCallback;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.UserHandle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.Log;
import android.util.Pair;
import com.GlobalProxyLancet;
import com.android.internal.util.CollectionUtils;
import com.android.settingslib.R;
import com.android.settingslib.applications.RecentAppOpsAccess;
import com.android.settingslib.utils.ThreadUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class AccessPoint implements Comparable<AccessPoint> {
    private static final int EAP_UNKNOWN = 0;
    private static final int EAP_WPA = 1;
    private static final int EAP_WPA2_WPA3 = 2;
    public static final int HIGHER_FREQ_24GHZ = 2500;
    public static final int HIGHER_FREQ_5GHZ = 5900;
    public static final int HIGHER_FREQ_60GHZ = 70200;
    public static final int HIGHER_FREQ_6GHZ = 7115;
    static final String KEY_CONFIG = "key_config";
    static final String KEY_EAPTYPE = "eap_psktype";
    static final String KEY_FQDN = "key_fqdn";
    static final String KEY_IS_OWE_TRANSITION_MODE = "key_is_owe_transition_mode";
    static final String KEY_IS_PSK_SAE_TRANSITION_MODE = "key_is_psk_sae_transition_mode";
    static final String KEY_NETWORKINFO = "key_networkinfo";
    static final String KEY_PASSPOINT_CONFIGURATION_VERSION = "key_passpoint_configuration_version";
    static final String KEY_PASSPOINT_UNIQUE_ID = "key_passpoint_unique_id";
    public static final String KEY_PREFIX_AP = "AP:";
    public static final String KEY_PREFIX_OSU = "OSU:";
    public static final String KEY_PREFIX_PASSPOINT_UNIQUE_ID = "PASSPOINT:";
    static final String KEY_PROVIDER_FRIENDLY_NAME = "key_provider_friendly_name";
    static final String KEY_PSKTYPE = "key_psktype";
    static final String KEY_SCANRESULTS = "key_scanresults";
    static final String KEY_SCOREDNETWORKCACHE = "key_scorednetworkcache";
    static final String KEY_SECURITY = "key_security";
    static final String KEY_SPEED = "key_speed";
    static final String KEY_SSID = "key_ssid";
    static final String KEY_SUBSCRIPTION_EXPIRATION_TIME_IN_MILLIS = "key_subscription_expiration_time_in_millis";
    static final String KEY_WIFIINFO = "key_wifiinfo";
    public static final int LOWER_FREQ_24GHZ = 2400;
    public static final int LOWER_FREQ_5GHZ = 4900;
    public static final int LOWER_FREQ_60GHZ = 58320;
    public static final int LOWER_FREQ_6GHZ = 5935;
    private static final int PSK_UNKNOWN = 0;
    private static final int PSK_WPA = 1;
    private static final int PSK_WPA2 = 2;
    private static final int PSK_WPA_WPA2 = 3;
    public static final int SECURITY_DPP = 8;
    public static final int SECURITY_EAP = 3;
    public static final int SECURITY_EAP_SUITE_B = 6;
    public static final int SECURITY_EAP_WPA3_ENTERPRISE = 7;
    public static final int SECURITY_MAX_VAL = 9;
    public static final int SECURITY_NONE = 0;
    public static final int SECURITY_OWE = 4;
    public static final int SECURITY_PSK = 2;
    public static final int SECURITY_SAE = 5;
    public static final int SECURITY_WEP = 1;
    static final String TAG = "SettingsLib.AccessPoint";
    public static final int UNREACHABLE_RSSI = Integer.MIN_VALUE;
    static final AtomicInteger sLastId = null;
    private String bssid;
    AccessPointListener mAccessPointListener;
    private WifiConfiguration mConfig;
    private WifiManager.ActionListener mConnectListener;
    private final Context mContext;
    private int mDeviceWifiStandard;
    private int mEapType;
    private final ArraySet<ScanResult> mExtraScanResults;
    private String mFqdn;
    private WifiInfo mInfo;
    private boolean mIsOweTransitionMode;
    private boolean mIsPskSaeTransitionMode;
    private boolean mIsRoaming;
    private boolean mIsScoredNetworkMetered;
    private String mKey;
    private final Object mLock;
    private NetworkInfo mNetworkInfo;
    private String mOsuFailure;
    private OsuProvider mOsuProvider;
    private boolean mOsuProvisioningComplete;
    private String mOsuStatus;
    private int mPasspointConfigurationVersion;
    private String mPasspointUniqueId;
    private String mProviderFriendlyName;
    private int mRssi;
    private final ArraySet<ScanResult> mScanResults;
    private final Map<String, TimestampedScoredNetwork> mScoredNetworkCache;
    private int mSpeed;
    private long mSubscriptionExpirationTimeInMillis;
    private Object mTag;
    private WifiManager mWifiManager;
    private int mWifiStandard;
    private int networkId;
    private int pskType;
    private int security;
    private String ssid;

    public interface AccessPointListener {
        void onAccessPointChanged(AccessPoint r1);

        void onLevelChanged(AccessPoint r1);
    }

    class AccessPointProvisioningCallback extends ProvisioningCallback {
        final /* synthetic */ AccessPoint this$0;

        AccessPointProvisioningCallback(AccessPoint r1) {
            this.this$0 = r1;
        }

        public void onProvisioningFailure(int r3) {
            if (TextUtils.equals(AccessPoint.access$000(this.this$0), AccessPoint.access$100(this.this$0).getString(R.string.osu_completing_sign_up)) == false) goto L5;
            AccessPoint r4 = this.this$0;
            AccessPoint.access$202(r4, AccessPoint.access$100(r4).getString(R.string.osu_sign_up_failed));
        L6:
            AccessPoint.access$002(this.this$0, null);
            AccessPoint.access$302(this.this$0, false);
            ThreadUtils.postOnMainThread(new AccessPoint$AccessPointProvisioningCallback$$ExternalSyntheticLambda2(this));
            return;
        L5:
            AccessPoint r5 = this.this$0;
            AccessPoint.access$202(r5, AccessPoint.access$100(r5).getString(R.string.osu_connect_failed));
            goto L6
        }

        /* JADX INFO: renamed from: lambda$onProvisioningFailure$0$com-android-settingslib-wifi-AccessPoint$AccessPointProvisioningCallback, reason: not valid java name */
        /* synthetic */ void m843x972e0a5a() {
            if (this.this$0.mAccessPointListener == null) goto L6;
            this.this$0.mAccessPointListener.onAccessPointChanged(this.this$0);
            return;
        }

        public void onProvisioningStatus(int r6) {
            switch(r6) {
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
            String r7 = null;
        L7:
            boolean r1 = true ^ TextUtils.equals(AccessPoint.access$000(this.this$0), r7);
            AccessPoint.access$002(this.this$0, r7);
            AccessPoint.access$202(this.this$0, null);
            AccessPoint.access$302(this.this$0, false);
            if (r1 == false) goto L11;
            ThreadUtils.postOnMainThread(new AccessPoint$AccessPointProvisioningCallback$$ExternalSyntheticLambda0(this));
            return;
        L11:
            return;
        L5:
            r7 = AccessPoint.access$100(this.this$0).getString(R.string.osu_completing_sign_up);
            goto L7
        L6:
            r7 = String.format(AccessPoint.access$100(this.this$0).getString(R.string.osu_opening_provider), new Object[]{AccessPoint.access$400(this.this$0).getFriendlyName()});
            goto L7
        }

        /* JADX INFO: renamed from: lambda$onProvisioningStatus$1$com-android-settingslib-wifi-AccessPoint$AccessPointProvisioningCallback, reason: not valid java name */
        /* synthetic */ void m844x699d555f() {
            if (this.this$0.mAccessPointListener == null) goto L6;
            this.this$0.mAccessPointListener.onAccessPointChanged(this.this$0);
            return;
        }

        public void onProvisioningComplete() {
            AccessPoint.access$302(this.this$0, true);
            AccessPoint.access$202(this.this$0, null);
            AccessPoint.access$002(this.this$0, null);
            ThreadUtils.postOnMainThread(new AccessPoint$AccessPointProvisioningCallback$$ExternalSyntheticLambda1(this));
            WifiManager r0 = AccessPoint.access$500(this.this$0);
            PasspointConfiguration r2 = (PasspointConfiguration) r0.getMatchingPasspointConfigsForOsuProviders(Collections.singleton(AccessPoint.access$400(this.this$0))).get(AccessPoint.access$400(this.this$0));
            if (r2 != null) goto L8;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(AccessPoint.TAG, "Missing PasspointConfiguration for newly provisioned network!");
            if (AccessPoint.access$600(this.this$0) == null) goto L22;
            AccessPoint.access$600(this.this$0).onFailure(0);
            return;
        L22:
            return;
        L8:
            String r3 = r2.getUniqueId();
            Iterator r4 = r0.getAllMatchingWifiConfigs(r0.getScanResults()).iterator();
        L10:
            if (r4.hasNext() == false) goto L16;
            Pair r5 = (Pair) r4.next();
            WifiConfiguration r6 = (WifiConfiguration) r5.first;
            if (TextUtils.equals(r6.getKey(), r3) == false) goto L10;
            List r7 = (List) ((Map) r5.second).get(0);
            List r1 = (List) ((Map) r5.second).get(1);
            r0.connect(new AccessPoint(AccessPoint.access$100(this.this$0), r6, r7, r1).getConfig(), AccessPoint.access$600(this.this$0));
            return;
        L16:
            if (AccessPoint.access$600(this.this$0) == null) goto L23;
            AccessPoint.access$600(this.this$0).onFailure(0);
            return;
        }

        /* JADX INFO: renamed from: lambda$onProvisioningComplete$2$com-android-settingslib-wifi-AccessPoint$AccessPointProvisioningCallback, reason: not valid java name */
        /* synthetic */ void m842xee4db917() {
            if (this.this$0.mAccessPointListener == null) goto L6;
            this.this$0.mAccessPointListener.onAccessPointChanged(this.this$0);
            return;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface PasspointConfigurationVersion {
        public static final int INVALID = 0;
        public static final int NO_OSU_PROVISIONED = 1;
        public static final int OSU_PROVISIONED = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Speed {
        public static final int FAST = 20;
        public static final int MODERATE = 10;
        public static final int NONE = 0;
        public static final int SLOW = 5;
        public static final int VERY_FAST = 30;
    }

    private static int roundToClosestSpeedEnum(int r2) {
        if (r2 >= 5) goto L7;
        return 0;
    L7:
        if (r2 >= 7) goto L10;
        return 5;
    L10:
        if (r2 >= 15) goto L14;
        return 10;
    L14:
        if (r2 >= 25) goto L17;
        return 20;
    L17:
        return 30;
    }

    public static String securityToString(int r3, int r4) {
        if (r3 != 1) goto L7;
        return "WEP";
    L7:
        if (r3 != 2) goto L19;
        if (r4 != 1) goto L11;
        return "WPA";
    L11:
        if (r4 != 2) goto L14;
        return "WPA2";
    L14:
        if (r4 != 3) goto L17;
        return "WPA_WPA2";
    L17:
        return "PSK";
    L19:
        if (r3 != 3) goto L23;
        return "EAP";
    L23:
        if (r3 != 8) goto L27;
        return "DPP";
    L27:
        if (r3 != 5) goto L31;
        return "SAE";
    L31:
        if (r3 != 6) goto L35;
        return "SUITE_B";
    L35:
        if (r3 != 4) goto L38;
        return "OWE";
    L38:
        return "NONE";
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(AccessPoint r1) {
        return compareTo2(r1);
    }

    static /* synthetic */ String access$000(AccessPoint r0) {
        return r0.mOsuStatus;
    }

    static /* synthetic */ String access$002(AccessPoint r0, String r1) {
        r0.mOsuStatus = r1;
        return r1;
    }

    static /* synthetic */ Context access$100(AccessPoint r0) {
        return r0.mContext;
    }

    static /* synthetic */ String access$202(AccessPoint r0, String r1) {
        r0.mOsuFailure = r1;
        return r1;
    }

    static /* synthetic */ boolean access$302(AccessPoint r0, boolean r1) {
        r0.mOsuProvisioningComplete = r1;
        return r1;
    }

    static /* synthetic */ OsuProvider access$400(AccessPoint r0) {
        return r0.mOsuProvider;
    }

    static /* synthetic */ WifiManager access$500(AccessPoint r0) {
        return r0.getWifiManager();
    }

    static /* synthetic */ WifiManager.ActionListener access$600(AccessPoint r0) {
        return r0.mConnectListener;
    }

    static {
        sLastId = new AtomicInteger(0);
    }

    public AccessPoint(Context r5, Bundle r6) {
        this.mLock = new Object();
        ArraySet<ScanResult> r0 = new ArraySet();
        this.mScanResults = r0;
        this.mExtraScanResults = new ArraySet();
        this.mScoredNetworkCache = new HashMap();
        this.networkId = -1;
        int r1 = 0;
        this.pskType = 0;
        this.mEapType = 0;
        this.mRssi = Integer.MIN_VALUE;
        this.mWifiStandard = 1;
        this.mSpeed = 0;
        this.mIsScoredNetworkMetered = false;
        this.mIsRoaming = false;
        this.mPasspointConfigurationVersion = 0;
        this.mOsuProvisioningComplete = false;
        this.mIsPskSaeTransitionMode = false;
        this.mIsOweTransitionMode = false;
        this.mContext = r5;
        if (r6.containsKey(KEY_CONFIG) == false) goto L5;
        this.mConfig = (WifiConfiguration) r6.getParcelable(KEY_CONFIG);
    L5:
        WifiConfiguration r7 = this.mConfig;
        if (r7 == null) goto L9;
        loadConfig(r7);
    L9:
        if (r6.containsKey(KEY_SSID) == false) goto L12;
        this.ssid = r6.getString(KEY_SSID);
    L12:
        if (r6.containsKey(KEY_SECURITY) == false) goto L15;
        this.security = r6.getInt(KEY_SECURITY);
    L15:
        if (r6.containsKey(KEY_SPEED) == false) goto L18;
        this.mSpeed = r6.getInt(KEY_SPEED);
    L18:
        if (r6.containsKey(KEY_PSKTYPE) == false) goto L21;
        this.pskType = r6.getInt(KEY_PSKTYPE);
    L21:
        if (r6.containsKey(KEY_EAPTYPE) == false) goto L23;
        this.mEapType = r6.getInt(KEY_EAPTYPE);
    L23:
        this.mInfo = (WifiInfo) r6.getParcelable(KEY_WIFIINFO);
        if (r6.containsKey(KEY_NETWORKINFO) == false) goto L27;
        this.mNetworkInfo = (NetworkInfo) r6.getParcelable(KEY_NETWORKINFO);
    L27:
        if (r6.containsKey(KEY_SCANRESULTS) == false) goto L32;
        Parcelable[] r8 = r6.getParcelableArray(KEY_SCANRESULTS);
        r0.clear();
        int r2 = r8.length;
    L29:
        if (r1 >= r2) goto L32;
        Parcelable r3 = r8[r1];
        this.mScanResults.add((ScanResult) r3);
        r1 = r1 + 1;
    L32:
        if (r6.containsKey(KEY_SCOREDNETWORKCACHE) == false) goto L38;
        Iterator r9 = r6.getParcelableArrayList(KEY_SCOREDNETWORKCACHE).iterator();
    L35:
        if (r9.hasNext() == false) goto L38;
        TimestampedScoredNetwork r4 = (TimestampedScoredNetwork) r9.next();
        this.mScoredNetworkCache.put(r4.getScore().networkKey.wifiKey.bssid, r4);
    L38:
        if (r6.containsKey(KEY_PASSPOINT_UNIQUE_ID) == false) goto L41;
        this.mPasspointUniqueId = r6.getString(KEY_PASSPOINT_UNIQUE_ID);
    L41:
        if (r6.containsKey(KEY_FQDN) == false) goto L44;
        this.mFqdn = r6.getString(KEY_FQDN);
    L44:
        if (r6.containsKey(KEY_PROVIDER_FRIENDLY_NAME) == false) goto L47;
        this.mProviderFriendlyName = r6.getString(KEY_PROVIDER_FRIENDLY_NAME);
    L47:
        if (r6.containsKey(KEY_SUBSCRIPTION_EXPIRATION_TIME_IN_MILLIS) == false) goto L50;
        this.mSubscriptionExpirationTimeInMillis = r6.getLong(KEY_SUBSCRIPTION_EXPIRATION_TIME_IN_MILLIS);
    L50:
        if (r6.containsKey(KEY_PASSPOINT_CONFIGURATION_VERSION) == false) goto L53;
        this.mPasspointConfigurationVersion = r6.getInt(KEY_PASSPOINT_CONFIGURATION_VERSION);
    L53:
        if (r6.containsKey(KEY_IS_PSK_SAE_TRANSITION_MODE) == false) goto L56;
        this.mIsPskSaeTransitionMode = r6.getBoolean(KEY_IS_PSK_SAE_TRANSITION_MODE);
    L56:
        if (r6.containsKey(KEY_IS_OWE_TRANSITION_MODE) == false) goto L58;
        this.mIsOweTransitionMode = r6.getBoolean(KEY_IS_OWE_TRANSITION_MODE);
    L58:
        update(this.mConfig, this.mInfo, this.mNetworkInfo);
        updateKey();
        updateBestRssiInfo();
        updateDeviceWifiGenerationInfo();
        updateWifiGeneration();
    }

    public AccessPoint(Context r3, WifiConfiguration r4) {
        this.mLock = new Object();
        this.mScanResults = new ArraySet();
        this.mExtraScanResults = new ArraySet();
        this.mScoredNetworkCache = new HashMap();
        this.networkId = -1;
        this.pskType = 0;
        this.mEapType = 0;
        this.mRssi = Integer.MIN_VALUE;
        this.mWifiStandard = 1;
        this.mSpeed = 0;
        this.mIsScoredNetworkMetered = false;
        this.mIsRoaming = false;
        this.mPasspointConfigurationVersion = 0;
        this.mOsuProvisioningComplete = false;
        this.mIsPskSaeTransitionMode = false;
        this.mIsOweTransitionMode = false;
        this.mContext = r3;
        loadConfig(r4);
        updateKey();
        updateDeviceWifiGenerationInfo();
    }

    public AccessPoint(Context r5, PasspointConfiguration r6) {
        this.mLock = new Object();
        this.mScanResults = new ArraySet();
        this.mExtraScanResults = new ArraySet();
        this.mScoredNetworkCache = new HashMap();
        this.networkId = -1;
        this.pskType = 0;
        this.mEapType = 0;
        this.mRssi = Integer.MIN_VALUE;
        this.mWifiStandard = 1;
        this.mSpeed = 0;
        this.mIsScoredNetworkMetered = false;
        this.mIsRoaming = false;
        this.mPasspointConfigurationVersion = 0;
        this.mOsuProvisioningComplete = false;
        this.mIsPskSaeTransitionMode = false;
        this.mIsOweTransitionMode = false;
        this.mContext = r5;
        this.mPasspointUniqueId = r6.getUniqueId();
        this.mFqdn = r6.getHomeSp().getFqdn();
        this.mProviderFriendlyName = r6.getHomeSp().getFriendlyName();
        this.mSubscriptionExpirationTimeInMillis = r6.getSubscriptionExpirationTimeMillis();
        if (r6.isOsuProvisioned() == false) goto L5;
        this.mPasspointConfigurationVersion = 2;
    L6:
        updateKey();
        updateDeviceWifiGenerationInfo();
        return;
    L5:
        this.mPasspointConfigurationVersion = 1;
        goto L6
    }

    public AccessPoint(Context r3, WifiConfiguration r4, Collection<ScanResult> r5, Collection<ScanResult> r6) {
        this.mLock = new Object();
        this.mScanResults = new ArraySet();
        this.mExtraScanResults = new ArraySet();
        this.mScoredNetworkCache = new HashMap();
        this.networkId = -1;
        this.pskType = 0;
        this.mEapType = 0;
        this.mRssi = Integer.MIN_VALUE;
        this.mWifiStandard = 1;
        this.mSpeed = 0;
        this.mIsScoredNetworkMetered = false;
        this.mIsRoaming = false;
        this.mPasspointConfigurationVersion = 0;
        this.mOsuProvisioningComplete = false;
        this.mIsPskSaeTransitionMode = false;
        this.mIsOweTransitionMode = false;
        this.mContext = r3;
        this.networkId = r4.networkId;
        this.mConfig = r4;
        this.mPasspointUniqueId = r4.getKey();
        this.mFqdn = r4.FQDN;
        updateDeviceWifiGenerationInfo();
        setScanResultsPasspoint(r5, r6);
        updateKey();
    }

    public AccessPoint(Context r3, OsuProvider r4, Collection<ScanResult> r5) {
        this.mLock = new Object();
        this.mScanResults = new ArraySet();
        this.mExtraScanResults = new ArraySet();
        this.mScoredNetworkCache = new HashMap();
        this.networkId = -1;
        this.pskType = 0;
        this.mEapType = 0;
        this.mRssi = Integer.MIN_VALUE;
        this.mWifiStandard = 1;
        this.mSpeed = 0;
        this.mIsScoredNetworkMetered = false;
        this.mIsRoaming = false;
        this.mPasspointConfigurationVersion = 0;
        this.mOsuProvisioningComplete = false;
        this.mIsPskSaeTransitionMode = false;
        this.mIsOweTransitionMode = false;
        this.mContext = r3;
        this.mOsuProvider = r4;
        updateDeviceWifiGenerationInfo();
        setScanResults(r5);
        updateKey();
    }

    AccessPoint(Context r3, Collection<ScanResult> r4) {
        this.mLock = new Object();
        this.mScanResults = new ArraySet();
        this.mExtraScanResults = new ArraySet();
        this.mScoredNetworkCache = new HashMap();
        this.networkId = -1;
        this.pskType = 0;
        this.mEapType = 0;
        this.mRssi = Integer.MIN_VALUE;
        this.mWifiStandard = 1;
        this.mSpeed = 0;
        this.mIsScoredNetworkMetered = false;
        this.mIsRoaming = false;
        this.mPasspointConfigurationVersion = 0;
        this.mOsuProvisioningComplete = false;
        this.mIsPskSaeTransitionMode = false;
        this.mIsOweTransitionMode = false;
        this.mContext = r3;
        updateDeviceWifiGenerationInfo();
        setScanResults(r4);
        updateKey();
    }

    void loadConfig(WifiConfiguration r2) {
        if (r2.SSID != null) goto L5;
        String r0 = "";
    L6:
        this.ssid = r0;
        this.bssid = r2.BSSID;
        this.security = getSecurity(r2);
        this.networkId = r2.networkId;
        this.mConfig = r2;
        return;
    L5:
        r0 = removeDoubleQuotes(r2.SSID);
        goto L6
    }

    private void updateKey() {
        if (isPasspoint() == false) goto L6;
        this.mKey = getKey(this.mConfig);
        return;
    L6:
        if (isPasspointConfig() == false) goto L9;
        this.mKey = getKey(this.mPasspointUniqueId);
        return;
    L9:
        if (isOsuProvider() == false) goto L11;
        this.mKey = getKey(this.mOsuProvider);
        return;
    L11:
        this.mKey = getKey(getSsidStr(), getBssid(), getSecurity());
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(AccessPoint r4) {
        if (isActive() == false) goto L8;
        if (r4.isActive() == true) goto L8;
        return -1;
    L8:
        if (isActive() == true) goto L13;
        if (r4.isActive() == false) goto L13;
        return 1;
    L13:
        if (isReachable() == false) goto L18;
        if (r4.isReachable() == true) goto L18;
        return -1;
    L18:
        if (isReachable() == true) goto L23;
        if (r4.isReachable() == false) goto L23;
        return 1;
    L23:
        if (isSaved() == false) goto L28;
        if (r4.isSaved() == true) goto L28;
        return -1;
    L28:
        if (isSaved() == true) goto L33;
        if (r4.isSaved() == false) goto L33;
        return 1;
    L33:
        if (getSpeed() != r4.getSpeed()) goto L35;
        WifiManager r0 = getWifiManager();
        int r1 = r0.calculateSignalLevel(r4.mRssi) - r0.calculateSignalLevel(this.mRssi);
        if (r1 == 0) goto L39;
        return r1;
    L39:
        int r2 = getTitle().compareToIgnoreCase(r4.getTitle());
        if (r2 == 0) goto L43;
        return r2;
    L43:
        return getSsidStr().compareTo(r4.getSsidStr());
    L35:
        return r4.getSpeed() - getSpeed();
    }

    public boolean equals(Object r3) {
        if ((r3 instanceof AccessPoint) == true) goto L6;
        return false;
    L6:
        if (compareTo2((AccessPoint) r3) != 0) goto L9;
        return true;
    L9:
        return false;
    }

    public int hashCode() {
        WifiInfo r0 = this.mInfo;
        int r1 = 0;
        if (r0 == null) goto L6;
        r1 = 0 + (r0.hashCode() * 13);
    L6:
        return ((r1 + (this.mRssi * 19)) + (this.networkId * 23)) + (this.ssid.hashCode() * 29);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("AccessPoint(").append(this.ssid);
        if (this.bssid == null) goto L6;
        r0.append(":").append(this.bssid);
    L6:
        if (isSaved() == false) goto L9;
        r0.append(",saved");
    L9:
        if (isActive() == false) goto L12;
        r0.append(",active");
    L12:
        if (isEphemeral() == false) goto L15;
        r0.append(",ephemeral");
    L15:
        if (isConnectable() == false) goto L17;
        r0.append(",connectable");
    L17:
        int r1 = this.security;
        if (r1 != 0) goto L20;
    L22:
        r0.append(",level=").append(getLevel());
        if (this.mSpeed == 0) goto L25;
        r0.append(",speed=").append(this.mSpeed);
    L25:
        r0.append(",metered=").append(isMetered());
        if (isVerboseLoggingEnabled() == false) goto L36;
        r0.append(",rssi=").append(this.mRssi);
        Object r2 = this.mLock;
        monitor-enter(r2);
        r0.append(",scan cache size=").append(this.mScanResults.size() + this.mExtraScanResults.size());     // Catch: Throwable -> L32
        monitor-exit(r2);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    L36:
        return r0.append(')').toString();
    L20:
        if (r1 == 4) goto L22;
        r0.append(',').append(securityToString(this.security, this.pskType));
        goto L22
    }

    boolean update(WifiNetworkScoreCache r2, boolean r3, long r4) {
        if (r3 == false) goto L5;
        boolean r5 = updateScores(r2, r4);
    L7:
        if (updateMetered(r2) == true) goto L9;
        if (r5 == true) goto L9;
        return false;
    L9:
        return true;
    L5:
        r5 = false;
        goto L7
    }

    private boolean updateScores(WifiNetworkScoreCache r9, long r10) {
        long r0 = SystemClock.elapsedRealtime();
        Object r2 = this.mLock;
        monitor-enter(r2);
        Iterator<ScanResult> r3 = this.mScanResults.iterator();     // Catch: Throwable -> L17
    L6:
        if (r3.hasNext() == false) goto L14;
        ScanResult r4 = r3.next();     // Catch: Throwable -> L17
        ScoredNetwork r5 = r9.getScoredNetwork(r4);     // Catch: Throwable -> L17
        if (r5 == null) goto L6;
        TimestampedScoredNetwork r6 = this.mScoredNetworkCache.get(r4.BSSID);     // Catch: Throwable -> L17
        if (r6 == null) goto L12;
        r6.update(r5, r0);     // Catch: Throwable -> L17
        goto L6
    L12:
        this.mScoredNetworkCache.put(r4.BSSID, new TimestampedScoredNetwork(r5, r0));     // Catch: Throwable -> L17
        goto L6
    L14:
        monitor-exit(r2);     // Catch: Throwable -> L17
        final long r1 = r0 - r10;
        final Iterator<TimestampedScoredNetwork> r11 = this.mScoredNetworkCache.values().iterator();
        r11.forEachRemaining(new AccessPoint$$ExternalSyntheticLambda0(r1, r11));
        return updateSpeed();
    L17:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ void lambda$updateScores$0(long r2, Iterator r4, TimestampedScoredNetwork r5) {
        if (r5.getUpdatedTimestampMillis() >= r2) goto L6;
        r4.remove();
        return;
    }

    private boolean updateSpeed() {
        int r0 = this.mSpeed;
        int r1 = generateAverageSpeedForSsid();
        this.mSpeed = r1;
        if (r0 == r1) goto L5;
        boolean r2 = true;
    L7:
        if (isVerboseLoggingEnabled() == false) goto L10;
        if (r2 == false) goto L10;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_i(TAG, String.format("%s: Set speed to %d", new Object[]{this.ssid, Integer.valueOf(this.mSpeed)}));
    L10:
        return r2;
    L5:
        r2 = false;
        goto L7
    }

    private int generateAverageSpeedForSsid() {
        if (this.mScoredNetworkCache.isEmpty() == false) goto L6;
        return 0;
    L6:
        if (Log.isLoggable(TAG, 3) == false) goto L8;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, String.format("Generating fallbackspeed for %s using cache: %s", new Object[]{getSsidStr(), this.mScoredNetworkCache}));
    L8:
        Iterator<TimestampedScoredNetwork> r0 = this.mScoredNetworkCache.values().iterator();
        int r5 = 0;
        int r6 = 0;
    L10:
        if (r0.hasNext() == false) goto L14;
        int r7 = r0.next().getScore().calculateBadge(this.mRssi);
        if (r7 == 0) goto L10;
        r5 = r5 + 1;
        r6 = r6 + r7;
        goto L10
    L14:
        if (r5 != 0) goto L16;
        int r8 = 0;
    L18:
        if (isVerboseLoggingEnabled() == false) goto L21;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_i(TAG, String.format("%s generated fallback speed is: %d", new Object[]{getSsidStr(), Integer.valueOf(r8)}));
    L21:
        return roundToClosestSpeedEnum(r8);
    L16:
        r8 = r6 / r5;
        goto L18
    }

    private boolean updateMetered(WifiNetworkScoreCache r7) {
        boolean r0 = this.mIsScoredNetworkMetered;
        this.mIsScoredNetworkMetered = false;
        if (isActive() == false) goto L9;
        WifiInfo r2 = this.mInfo;
        if (r2 == null) goto L9;
        ScoredNetwork r8 = r7.getScoredNetwork(NetworkKey.createFromWifiInfo(r2));
        if (r8 == null) goto L20;
        boolean r3 = this.mIsScoredNetworkMetered;
        this.mIsScoredNetworkMetered = r8.meteredHint | r3;
    L20:
        if (r0 == this.mIsScoredNetworkMetered) goto L34;
        return true;
    L34:
        return false;
    L9:
        Object r4 = this.mLock;
        monitor-enter(r4);
        Iterator<ScanResult> r5 = this.mScanResults.iterator();     // Catch: Throwable -> L23
    L13:
        if (r5.hasNext() == false) goto L18;
        ScoredNetwork r6 = r7.getScoredNetwork(r5.next());     // Catch: Throwable -> L23
        if (r6 == null) goto L13;
        boolean r9 = this.mIsScoredNetworkMetered;     // Catch: Throwable -> L23
        this.mIsScoredNetworkMetered = r6.meteredHint | r9;     // Catch: Throwable -> L23
        goto L13
    L18:
        monitor-exit(r4);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    public static String getKey(Context r2, ScanResult r3) {
        return getKey(r3.SSID, r3.BSSID, getSecurity(r2, r3));
    }

    public static String getKey(WifiConfiguration r2) {
        if (r2.isPasspoint() == false) goto L7;
        return getKey(r2.getKey());
    L7:
        return getKey(removeDoubleQuotes(r2.SSID), r2.BSSID, getSecurity(r2));
    }

    public static String getKey(String r2) {
        return KEY_PREFIX_PASSPOINT_UNIQUE_ID + r2;
    }

    public static String getKey(OsuProvider r2) {
        return KEY_PREFIX_OSU + r2.getFriendlyName() + ',' + r2.getServerUri();
    }

    private static String getKey(String r2, String r3, int r4) {
        StringBuilder r0 = new StringBuilder(KEY_PREFIX_AP);
        if (TextUtils.isEmpty(r2) == false) goto L5;
        r0.append(r3);
    L6:
        r0.append(',').append(r4);
        return r0.toString();
    L5:
        r0.append(r2);
        goto L6
    }

    public String getKey() {
        return this.mKey;
    }

    public boolean matches(AccessPoint r7) {
        if (isPasspoint() == true) goto L45;
        if (isPasspointConfig() == true) goto L45;
        if (isOsuProvider() == true) goto L45;
        if (isSameSsidOrBssid(r7) == true) goto L12;
        return false;
    L12:
        int r0 = r7.getSecurity();
        if (this.mIsPskSaeTransitionMode == false) goto L20;
        if (r0 == 5) goto L16;
    L18:
        if (r0 != 2) goto L27;
        return true;
    L27:
        if (this.mIsOweTransitionMode == false) goto L34;
        if (r0 == 4) goto L30;
    L32:
        if (r0 != 0) goto L41;
        return true;
    L41:
        if (this.security == r7.getSecurity()) goto L43;
        return false;
    L43:
        return true;
    L30:
        if (getWifiManager().isEnhancedOpenSupported() == false) goto L32;
        return true;
    L34:
        int r1 = this.security;
        if (r1 == 4) goto L38;
        if (r1 != 0) goto L41;
    L38:
        if (r7.isOweTransitionMode() == false) goto L41;
        return true;
    L16:
        if (getWifiManager().isWpa3SaeSupported() == false) goto L18;
        return true;
    L20:
        int r2 = this.security;
        if (r2 == 5) goto L24;
        if (r2 != 2) goto L27;
    L24:
        if (r7.isPskSaeTransitionMode() == false) goto L27;
        return true;
    L45:
        return getKey().equals(r7.getKey());
    }

    public boolean matches(WifiConfiguration r5) {
        if (r5.isPasspoint() == false) goto L11;
        if (isPasspoint() == true) goto L7;
        return false;
    L7:
        if (r5.getKey().equals(this.mConfig.getKey()) == true) goto L9;
        return false;
    L9:
        return true;
    L11:
        if (this.ssid.equals(removeDoubleQuotes(r5.SSID)) == false) goto L42;
        WifiConfiguration r0 = this.mConfig;
        if (r0 != null) goto L15;
    L17:
        int r1 = getSecurity(r5);
        if (this.mIsPskSaeTransitionMode == false) goto L28;
        if (r1 != 5) goto L25;
        if (getWifiManager().isWpa3SaeSupported() == false) goto L25;
        return true;
    L25:
        if (r1 != 2) goto L28;
        return true;
    L28:
        if (this.mIsOweTransitionMode == false) goto L37;
        if (r1 == 4) goto L32;
    L34:
        if (r1 != 0) goto L37;
        return true;
    L32:
        if (getWifiManager().isEnhancedOpenSupported() == false) goto L34;
        return true;
    L37:
        if (this.security == getSecurity(r5)) goto L39;
        return false;
    L39:
        return true;
    L15:
        if (r0.shared == r5.shared) goto L17;
        return false;
    L42:
        return false;
    }

    private boolean matches(WifiConfiguration r3, WifiInfo r4) {
        if (r3 == null) goto L13;
        if (r4 == null) goto L13;
        if (r3.isPasspoint() == true) goto L12;
        if (isSameSsidOrBssid(r4) == true) goto L12;
        return false;
    L12:
        return matches(r3);
    L13:
        return false;
    }

    boolean matches(ScanResult r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (isPasspoint() == true) goto L49;
        if (isOsuProvider() == true) goto L49;
        if (isSameSsidOrBssid(r5) == true) goto L13;
        return false;
    L13:
        if (this.mIsPskSaeTransitionMode == true) goto L15;
        int r1 = this.security;
        if (r1 == 5) goto L27;
        if (r1 == 2) goto L27;
    L30:
        if (this.mIsOweTransitionMode == false) goto L38;
        int r2 = getSecurity(this.mContext, r5);
        if (r2 == 4) goto L34;
    L36:
        if (r2 != 0) goto L45;
        return true;
    L45:
        if (this.security == getSecurity(this.mContext, r5)) goto L47;
        return false;
    L47:
        return true;
    L34:
        if (getWifiManager().isEnhancedOpenSupported() == false) goto L36;
        return true;
    L38:
        int r3 = this.security;
        if (r3 == 4) goto L42;
        if (r3 != 0) goto L45;
    L42:
        if (isOweTransitionMode(r5) == false) goto L45;
        return true;
    L27:
        if (isPskSaeTransitionMode(r5) == false) goto L30;
        return true;
    L15:
        if (r5.capabilities.contains("SAE") == false) goto L20;
        if (getWifiManager().isWpa3SaeSupported() == false) goto L20;
        return true;
    L20:
        if (r5.capabilities.contains("PSK") == false) goto L30;
        return true;
    L49:
        throw new IllegalStateException("Should not matches a Passpoint by ScanResult");
    }

    public WifiConfiguration getConfig() {
        return this.mConfig;
    }

    public String getPasspointFqdn() {
        return this.mFqdn;
    }

    public void clearConfig() {
        this.mConfig = null;
        this.networkId = -1;
    }

    public WifiInfo getInfo() {
        return this.mInfo;
    }

    public int getLevel() {
        return getWifiManager().calculateSignalLevel(this.mRssi);
    }

    public int getRssi() {
        return this.mRssi;
    }

    public Set<ScanResult> getScanResults() {
        ArraySet r0 = new ArraySet();
        Object r1 = this.mLock;
        monitor-enter(r1);
        r0.addAll(this.mScanResults);     // Catch: Throwable -> L7
        r0.addAll(this.mExtraScanResults);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    public Map<String, TimestampedScoredNetwork> getScoredNetworkCache() {
        return this.mScoredNetworkCache;
    }

    private void updateBestRssiInfo() {
        if (isActive() == false) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        Iterator<ScanResult> r1 = this.mScanResults.iterator();     // Catch: Throwable -> L34
        ScanResult r3 = null;
        int r4 = Integer.MIN_VALUE;
    L9:
        if (r1.hasNext() == false) goto L13;
        ScanResult r5 = r1.next();     // Catch: Throwable -> L34
        if (r5.level <= r4) goto L9;
        r4 = r5.level;     // Catch: Throwable -> L34
        r3 = r5;
        goto L9
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L34
        if (r4 == Integer.MIN_VALUE) goto L19;
        int r2 = this.mRssi;
        if (r2 == Integer.MIN_VALUE) goto L19;
        this.mRssi = (r2 + r4) / 2;
    L20:
        if (r3 == null) goto L31;
        this.ssid = r3.SSID;
        this.bssid = r3.BSSID;
        int r6 = getSecurity(this.mContext, r3);
        this.security = r6;
        if (r6 != 2) goto L24;
    L25:
        this.pskType = getPskType(r3);
    L27:
        if (this.security != 3) goto L29;
        this.mEapType = getEapType(r3);
    L29:
        this.mIsPskSaeTransitionMode = isPskSaeTransitionMode(r3);
        this.mIsOweTransitionMode = isOweTransitionMode(r3);
        goto L31
    L24:
        if (r6 != 5) goto L27;
    L31:
        if (isPasspoint() == false) goto L44;
        this.mConfig.SSID = convertToQuotedString(this.ssid);
        return;
    L44:
        return;
    L19:
        this.mRssi = r4;
    L34:
        th = move-exception;
        throw th;
    }

    public boolean isMetered() {
        if (this.mIsScoredNetworkMetered == false) goto L5;
    L8:
        return true;
    L5:
        if (WifiConfiguration.isMetered(this.mConfig, this.mInfo) == true) goto L8;
        return false;
    }

    public NetworkInfo getNetworkInfo() {
        return this.mNetworkInfo;
    }

    public int getSecurity() {
        return this.security;
    }

    public String getSecurityString(boolean r5) {
        Context r0 = this.mContext;
        if (isPasspoint() == false) goto L5;
    L81:
        if (r5 == false) goto L84;
        return r0.getString(R.string.wifi_security_short_eap);
    L84:
        return r0.getString(R.string.wifi_security_eap);
    L5:
        if (isPasspointConfig() == true) goto L81;
        if (this.mIsPskSaeTransitionMode == false) goto L14;
        if (r5 == false) goto L12;
        return r0.getString(R.string.wifi_security_short_psk_sae);
    L12:
        return r0.getString(R.string.wifi_security_psk_sae);
    L14:
        if (this.mIsOweTransitionMode == false) goto L20;
        if (r5 == false) goto L18;
        return r0.getString(R.string.wifi_security_short_none_owe);
    L18:
        return r0.getString(R.string.wifi_security_none_owe);
    L20:
        switch(this.security) {
            case 1: goto L75;
            case 2: goto L54;
            case 3: goto L39;
            case 4: goto L35;
            case 5: goto L31;
            case 6: goto L27;
            case 7: goto L21;
            case 8: goto L23;
            default: goto L21;
        };
    L21:
        if (r5 == false) goto L80;
        return "";
    L80:
        return r0.getString(R.string.wifi_security_none);
    L23:
        if (r5 == false) goto L26;
        return r0.getString(R.string.wifi_security_short_dpp);
    L26:
        return r0.getString(R.string.wifi_security_dpp);
    L27:
        if (r5 == false) goto L30;
        return r0.getString(R.string.wifi_security_short_eap_suiteb);
    L30:
        return r0.getString(R.string.wifi_security_eap_suiteb);
    L31:
        if (r5 == false) goto L34;
        return r0.getString(R.string.wifi_security_short_sae);
    L34:
        return r0.getString(R.string.wifi_security_sae);
    L35:
        if (r5 == false) goto L38;
        return r0.getString(R.string.wifi_security_short_owe);
    L38:
        return r0.getString(R.string.wifi_security_owe);
    L39:
        int r4 = this.mEapType;
        if (r4 == 1) goto L50;
        if (r4 == 2) goto L46;
        if (r5 == false) goto L45;
        return r0.getString(R.string.wifi_security_short_eap);
    L45:
        return r0.getString(R.string.wifi_security_eap);
    L46:
        if (r5 == false) goto L49;
        return r0.getString(R.string.wifi_security_short_eap_wpa2_wpa3);
    L49:
        return r0.getString(R.string.wifi_security_eap_wpa2_wpa3);
    L50:
        if (r5 == false) goto L53;
        return r0.getString(R.string.wifi_security_short_eap_wpa);
    L53:
        return r0.getString(R.string.wifi_security_eap_wpa);
    L54:
        int r6 = this.pskType;
        if (r6 == 1) goto L71;
        if (r6 != 2) goto L58;
        if (r5 == false) goto L70;
        return r0.getString(R.string.wifi_security_short_wpa2);
    L70:
        return r0.getString(R.string.wifi_security_wpa2);
    L58:
        if (r6 == 3) goto L63;
        if (r5 == false) goto L62;
        return r0.getString(R.string.wifi_security_short_psk_generic);
    L62:
        return r0.getString(R.string.wifi_security_psk_generic);
    L63:
        if (r5 == false) goto L66;
        return r0.getString(R.string.wifi_security_short_wpa_wpa2);
    L66:
        return r0.getString(R.string.wifi_security_wpa_wpa2);
    L71:
        if (r5 == false) goto L74;
        return r0.getString(R.string.wifi_security_short_wpa);
    L74:
        return r0.getString(R.string.wifi_security_wpa);
    L75:
        if (r5 == false) goto L78;
        return r0.getString(R.string.wifi_security_short_wep);
    L78:
        return r0.getString(R.string.wifi_security_wep);
    }

    public String getSsidStr() {
        return this.ssid;
    }

    public String getBssid() {
        return this.bssid;
    }

    public CharSequence getSsid() {
        return this.ssid;
    }

    @Deprecated
    public String getConfigName() {
        WifiConfiguration r0 = this.mConfig;
        if (r0 == null) goto L9;
        if (r0.isPasspoint() == false) goto L9;
        return this.mConfig.providerFriendlyName;
    L9:
        if (this.mPasspointUniqueId == null) goto L13;
        return this.mProviderFriendlyName;
    L13:
        return this.ssid;
    }

    public NetworkInfo.DetailedState getDetailedState() {
        NetworkInfo r1 = this.mNetworkInfo;
        if (r1 != null) goto L5;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "NetworkInfo is null, cannot return detailed state");
        return null;
    L5:
        return r1.getDetailedState();
    }

    public String getSavedNetworkSummary() {
        WifiConfiguration r0 = this.mConfig;
        if (r0 == null) goto L20;
        PackageManager r1 = this.mContext.getPackageManager();
        String r2 = r1.getNameForUid(1000);
        int r3 = UserHandle.getUserId(r0.creatorUid);
        if (r0.creatorName != null) goto L7;
    L27:
        ApplicationInfo r4 = AppGlobals.getPackageManager().getApplicationInfo(r0.creatorName, 0, r3);     // Catch: RemoteException -> L11
    L12:
        if (r4 == null) goto L20;
        if (r4.packageName.equals(this.mContext.getString(R.string.settings_package)) == true) goto L20;
        if (r4.packageName.equals(this.mContext.getString(R.string.certinstaller_package)) == true) goto L20;
        return this.mContext.getString(R.string.saved_network, new Object[]{r4.loadLabel(r1)});
    L11:
        r4 = null;
        goto L12
    L7:
        if (r0.creatorName.equals(r2) == false) goto L27;
        r4 = this.mContext.getApplicationInfo();
    L20:
        if (isPasspointConfigurationR1() == true) goto L22;
        return "";
    L22:
        if (isExpired() == true) goto L24;
        return "";
    L24:
        return this.mContext.getString(R.string.wifi_passpoint_expired);
    }

    public String getTitle() {
        if (isPasspoint() == false) goto L9;
        if (TextUtils.isEmpty(this.mConfig.providerFriendlyName) == true) goto L9;
        return this.mConfig.providerFriendlyName;
    L9:
        if (isPasspointConfig() == false) goto L15;
        if (TextUtils.isEmpty(this.mProviderFriendlyName) == true) goto L15;
        return this.mProviderFriendlyName;
    L15:
        if (isOsuProvider() == false) goto L21;
        if (TextUtils.isEmpty(this.mOsuProvider.getFriendlyName()) == true) goto L21;
        return this.mOsuProvider.getFriendlyName();
    L21:
        if (TextUtils.isEmpty(getSsidStr()) == false) goto L23;
        return "";
    L23:
        return getSsidStr();
    }

    public String getSummary() {
        return getSettingsSummary();
    }

    public String getSettingsSummary() {
        return getSettingsSummary(false);
    }

    public String getSettingsSummary(boolean r9) {
        if (isPasspointConfigurationR1() == true) goto L5;
    L8:
        StringBuilder r0 = new StringBuilder();
        if (isOsuProvider() == false) goto L21;
        if (this.mOsuProvisioningComplete == false) goto L13;
        r0.append(this.mContext.getString(R.string.osu_sign_up_complete));
    L70:
        if (isVerboseLoggingEnabled() == false) goto L72;
        r0.append(WifiUtils.buildLoggingSummary(this, this.mConfig));
    L72:
        WifiConfiguration r10 = this.mConfig;
        if (r10 == null) goto L81;
        if (WifiUtils.isMeteredOverridden(r10) == true) goto L79;
        if (this.mConfig.meteredHint == false) goto L81;
    L79:
        return this.mContext.getResources().getString(R.string.preference_summary_default_combination, new Object[]{WifiUtils.getMeteredLabel(this.mContext, this.mConfig), r0.toString()});
    L81:
        if (getSpeedLabel() == null) goto L87;
        if (r0.length() == 0) goto L87;
        return this.mContext.getResources().getString(R.string.preference_summary_default_combination, new Object[]{getSpeedLabel(), r0.toString()});
    L87:
        if (getSpeedLabel() == null) goto L91;
        return getSpeedLabel();
    L91:
        return r0.toString();
    L13:
        String r11 = this.mOsuFailure;
        if (r11 == null) goto L16;
        r0.append(r11);
        goto L70
    L16:
        String r12 = this.mOsuStatus;
        if (r12 == null) goto L19;
        r0.append(r12);
        goto L70
    L19:
        r0.append(this.mContext.getString(R.string.tap_to_sign_up));
        goto L70
    L21:
        if (isActive() == false) goto L33;
        Context r13 = this.mContext;
        NetworkInfo.DetailedState r1 = getDetailedState();
        WifiInfo r5 = this.mInfo;
        if (r5 != null) goto L25;
    L27:
        boolean r6 = false;
    L28:
        WifiInfo r7 = this.mInfo;
        if (r7 == null) goto L31;
        String r8 = r7.getRequestingPackageName();
    L32:
        r0.append(getSummary(r13, null, r1, r6, r8));
        goto L70
    L31:
        r8 = null;
        goto L32
    L25:
        if (r5.isEphemeral() == false) goto L27;
        r6 = true;
        goto L28
    L33:
        WifiConfiguration r2 = this.mConfig;
        if (r2 != null) goto L36;
    L42:
        WifiConfiguration r3 = this.mConfig;
        if (r3 == null) goto L59;
        if (r3.getNetworkSelectionStatus().getNetworkSelectionStatus() == 0) goto L59;
        int r14 = this.mConfig.getNetworkSelectionStatus().getNetworkSelectionDisableReason();
        if (r14 == 1) goto L57;
        if (r14 != 2) goto L50;
        r0.append(this.mContext.getString(R.string.wifi_disabled_password_failure));
        goto L70
    L50:
        if (r14 != 3) goto L52;
        r0.append(this.mContext.getString(R.string.wifi_disabled_network_failure));
        goto L70
    L52:
        if (r14 != 8) goto L70;
        r0.append(this.mContext.getString(R.string.wifi_check_password_try_again));
        goto L70
    L57:
        r0.append(this.mContext.getString(R.string.wifi_disabled_generic));
    L59:
        if (isReachable() == true) goto L61;
        r0.append(this.mContext.getString(R.string.wifi_not_in_range));
        goto L70
    L61:
        WifiConfiguration r4 = this.mConfig;
        if (r4 == null) goto L70;
        if (r4.getRecentFailureReason() == 17) goto L68;
        if (r9 == false) goto L67;
        r0.append(this.mContext.getString(R.string.wifi_disconnected));
        goto L70
    L67:
        r0.append(this.mContext.getString(R.string.wifi_remembered));
        goto L70
    L68:
        r0.append(this.mContext.getString(R.string.wifi_ap_unable_to_handle_new_sta));
        goto L70
    L36:
        if (r2.hasNoInternetAccess() == false) goto L42;
        if (this.mConfig.getNetworkSelectionStatus().getNetworkSelectionStatus() != 2) goto L40;
        int r15 = R.string.wifi_no_internet_no_reconnect;
    L41:
        r0.append(this.mContext.getString(r15));
        goto L70
    L40:
        r15 = R.string.wifi_no_internet;
        goto L41
    L5:
        if (isExpired() == false) goto L8;
        return this.mContext.getString(R.string.wifi_passpoint_expired);
    }

    public boolean isActive() {
        NetworkInfo r0 = this.mNetworkInfo;
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (this.networkId == (-1)) goto L7;
    L8:
        return true;
    L7:
        if (r0.getState() == NetworkInfo.State.DISCONNECTED) goto L9;
        goto L8
    }

    public boolean isConnectable() {
        if (getLevel() != (-1)) goto L5;
    L7:
        return false;
    L5:
        if (getDetailedState() != null) goto L7;
        return true;
    }

    public boolean isEphemeral() {
        WifiInfo r0 = this.mInfo;
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (r0.isEphemeral() == false) goto L11;
        NetworkInfo r1 = this.mNetworkInfo;
        if (r1 == null) goto L11;
        if (r1.getState() == NetworkInfo.State.DISCONNECTED) goto L11;
        return true;
    }

    public boolean isPasspoint() {
        WifiConfiguration r0 = this.mConfig;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isPasspoint() == false) goto L7;
        return true;
    }

    public boolean isPasspointConfig() {
        if (this.mPasspointUniqueId != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mConfig != null) goto L7;
        return true;
    }

    public boolean isOsuProvider() {
        if (this.mOsuProvider == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isExpired() {
        if (this.mSubscriptionExpirationTimeInMillis > 0) goto L6;
        return false;
    L6:
        if (System.currentTimeMillis() < this.mSubscriptionExpirationTimeInMillis) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean isPasspointConfigurationR1() {
        if (this.mPasspointConfigurationVersion == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isPasspointConfigurationOsuProvisioned() {
        if (this.mPasspointConfigurationVersion != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public void startOsuProvisioning(WifiManager.ActionListener r4) {
        this.mConnectListener = r4;
        getWifiManager().startSubscriptionProvisioning(this.mOsuProvider, this.mContext.getMainExecutor(), new AccessPointProvisioningCallback(this));
    }

    private boolean isInfoForThisAccessPoint(WifiConfiguration r5, WifiInfo r6) {
        if (r6.isOsuAp() == true) goto L36;
        if (this.mOsuStatus != null) goto L36;
        if (r6.isPasspointAp() == true) goto L25;
        if (isPasspoint() == true) goto L25;
        int r0 = this.networkId;
        if (r0 != (-1)) goto L15;
        if (r5 == null) goto L23;
        return matches(r5, r6);
    L23:
        return TextUtils.equals(removeDoubleQuotes(r6.getSSID()), this.ssid);
    L15:
        if (r0 != r6.getNetworkId()) goto L18;
        return true;
    L18:
        return false;
    L25:
        if (r6.isPasspointAp() == false) goto L34;
        if (isPasspoint() == false) goto L34;
        if (TextUtils.equals(r6.getPasspointFqdn(), this.mConfig.FQDN) == false) goto L34;
        if (TextUtils.equals(r6.getPasspointProviderFriendlyName(), this.mConfig.providerFriendlyName) == false) goto L34;
        return true;
    L34:
        return false;
    L36:
        if (r6.isOsuAp() == false) goto L41;
        if (this.mOsuStatus == null) goto L41;
        return true;
    L41:
        return false;
    }

    public boolean isSaved() {
        if (this.mConfig == null) goto L5;
        return true;
    L5:
        return false;
    }

    public Object getTag() {
        return this.mTag;
    }

    public void setTag(Object r1) {
        this.mTag = r1;
    }

    public void generateOpenNetworkConfig() {
        if (isOpenNetwork() == false) goto L13;
        if (this.mConfig == null) goto L7;
        return;
    L7:
        WifiConfiguration r0 = new WifiConfiguration();
        this.mConfig = r0;
        r0.SSID = convertToQuotedString(this.ssid);
        if (this.security != 0) goto L10;
        this.mConfig.allowedKeyManagement.set(0);
        return;
    L10:
        this.mConfig.allowedKeyManagement.set(9);
        this.mConfig.requirePmf = true;
        return;
    L13:
        throw new IllegalStateException();
    }

    public void saveWifiState(Bundle r6) {
        if (this.ssid == null) goto L5;
        r6.putString(KEY_SSID, getSsidStr());
    L5:
        r6.putInt(KEY_SECURITY, this.security);
        r6.putInt(KEY_SPEED, this.mSpeed);
        r6.putInt(KEY_PSKTYPE, this.pskType);
        r6.putInt(KEY_EAPTYPE, this.mEapType);
        WifiConfiguration r0 = this.mConfig;
        if (r0 == null) goto L8;
        r6.putParcelable(KEY_CONFIG, r0);
    L8:
        r6.putParcelable(KEY_WIFIINFO, this.mInfo);
        Object r1 = this.mLock;
        monitor-enter(r1);
        ArraySet<ScanResult> r2 = this.mScanResults;     // Catch: Throwable -> L26
        r6.putParcelableArray(KEY_SCANRESULTS, (Parcelable[]) r2.toArray(new Parcelable[r2.size() + this.mExtraScanResults.size()]));     // Catch: Throwable -> L26
        monitor-exit(r1);     // Catch: Throwable -> L26
        r6.putParcelableArrayList(KEY_SCOREDNETWORKCACHE, new ArrayList(this.mScoredNetworkCache.values()));
        NetworkInfo r3 = this.mNetworkInfo;
        if (r3 == null) goto L15;
        r6.putParcelable(KEY_NETWORKINFO, r3);
    L15:
        String r4 = this.mPasspointUniqueId;
        if (r4 == null) goto L18;
        r6.putString(KEY_PASSPOINT_UNIQUE_ID, r4);
    L18:
        String r5 = this.mFqdn;
        if (r5 == null) goto L21;
        r6.putString(KEY_FQDN, r5);
    L21:
        String r7 = this.mProviderFriendlyName;
        if (r7 == null) goto L24;
        r6.putString(KEY_PROVIDER_FRIENDLY_NAME, r7);
    L24:
        r6.putLong(KEY_SUBSCRIPTION_EXPIRATION_TIME_IN_MILLIS, this.mSubscriptionExpirationTimeInMillis);
        r6.putInt(KEY_PASSPOINT_CONFIGURATION_VERSION, this.mPasspointConfigurationVersion);
        r6.putBoolean(KEY_IS_PSK_SAE_TRANSITION_MODE, this.mIsPskSaeTransitionMode);
        r6.putBoolean(KEY_IS_OWE_TRANSITION_MODE, this.mIsOweTransitionMode);
        return;
    L26:
        th = move-exception;
        throw th;
    }

    public void setListener(AccessPointListener r1) {
        this.mAccessPointListener = r1;
    }

    void setScanResults(Collection<ScanResult> r5) {
        if (CollectionUtils.isEmpty(r5) == false) goto L7;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Cannot set scan results to empty list");
        return;
    L7:
        if (this.mKey != null) goto L9;
    L19:
        int r0 = getLevel();
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mScanResults.clear();     // Catch: Throwable -> L29
        this.mScanResults.addAll(r5);     // Catch: Throwable -> L29
        monitor-exit(r1);     // Catch: Throwable -> L29
        updateBestRssiInfo();
        updateWifiGeneration();
        int r6 = getLevel();
        if (r6 <= 0) goto L27;
        if (r6 == r0) goto L27;
        updateSpeed();
        ThreadUtils.postOnMainThread(new AccessPoint$$ExternalSyntheticLambda2(this));
    L27:
        ThreadUtils.postOnMainThread(new AccessPoint$$ExternalSyntheticLambda3(this));
        return;
    L29:
        th = move-exception;
        throw th;
    L9:
        if (isPasspoint() == true) goto L19;
        if (isOsuProvider() == true) goto L19;
        Iterator<ScanResult> r2 = r5.iterator();
    L14:
        if (r2.hasNext() == false) goto L19;
        ScanResult r3 = r2.next();
        if (matches(r3) == true) goto L14;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, String.format("ScanResult %s\nkey of %s did not match current AP key %s", new Object[]{r3, getKey(this.mContext, r3), this.mKey}));
    }

    /* JADX INFO: renamed from: lambda$setScanResults$1$com-android-settingslib-wifi-AccessPoint, reason: not valid java name */
    /* synthetic */ void m837lambda$setScanResults$1$comandroidsettingslibwifiAccessPoint() {
        AccessPointListener r0 = this.mAccessPointListener;
        if (r0 == null) goto L6;
        r0.onLevelChanged(this);
        return;
    }

    /* JADX INFO: renamed from: lambda$setScanResults$2$com-android-settingslib-wifi-AccessPoint, reason: not valid java name */
    /* synthetic */ void m838lambda$setScanResults$2$comandroidsettingslibwifiAccessPoint() {
        AccessPointListener r0 = this.mAccessPointListener;
        if (r0 == null) goto L6;
        r0.onAccessPointChanged(this);
        return;
    }

    void setScanResultsPasspoint(Collection<ScanResult> r3, Collection<ScanResult> r4) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mExtraScanResults.clear();     // Catch: Throwable -> L15
        if (CollectionUtils.isEmpty(r3) == true) goto L11;
        this.mIsRoaming = false;     // Catch: Throwable -> L15
        if (CollectionUtils.isEmpty(r4) == true) goto L9;
        this.mExtraScanResults.addAll(r4);     // Catch: Throwable -> L15
    L9:
        setScanResults(r3);     // Catch: Throwable -> L15
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L11:
        if (CollectionUtils.isEmpty(r4) == true) goto L13;
        this.mIsRoaming = true;     // Catch: Throwable -> L15
        setScanResults(r4);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public boolean update(WifiConfiguration r5, WifiInfo r6, NetworkInfo r7) {
        int r0 = getLevel();
        boolean r1 = true;
        boolean r2 = false;
        if (r6 == null) goto L31;
        if (isInfoForThisAccessPoint(r5, r6) == false) goto L31;
        if (this.mInfo != null) goto L10;
        r2 = true;
    L10:
        if (isPasspoint() == true) goto L15;
        if (this.mConfig == r5) goto L15;
        update(r5);
    L15:
        if (getWifiStandard() == r6.getWifiStandard()) goto L18;
        r2 = true;
    L18:
        if (this.mRssi != r6.getRssi()) goto L20;
    L22:
        NetworkInfo r8 = this.mNetworkInfo;
        if (r8 == null) goto L28;
        if (r7 == null) goto L28;
        if (r8.getDetailedState() == r7.getDetailedState()) goto L28;
    L29:
        this.mInfo = r6;
        this.mNetworkInfo = r7;
    L34:
        if (r1 == true) goto L36;
    L40:
        return r1;
    L36:
        if (this.mAccessPointListener == null) goto L40;
        ThreadUtils.postOnMainThread(new AccessPoint$$ExternalSyntheticLambda4(this));
        if (r0 == getLevel()) goto L40;
        ThreadUtils.postOnMainThread(new AccessPoint$$ExternalSyntheticLambda5(this));
    L28:
        r1 = r2;
        goto L29
    L20:
        if (r6.getRssi() == (-127)) goto L22;
        this.mRssi = r6.getRssi();
    L31:
        if (this.mInfo == null) goto L33;
        this.mInfo = null;
        this.mNetworkInfo = null;
        updateWifiGeneration();
        goto L34
    L33:
        r1 = false;
        goto L34
    }

    /* JADX INFO: renamed from: lambda$update$3$com-android-settingslib-wifi-AccessPoint, reason: not valid java name */
    /* synthetic */ void m839lambda$update$3$comandroidsettingslibwifiAccessPoint() {
        AccessPointListener r0 = this.mAccessPointListener;
        if (r0 == null) goto L6;
        r0.onAccessPointChanged(this);
        return;
    }

    /* JADX INFO: renamed from: lambda$update$4$com-android-settingslib-wifi-AccessPoint, reason: not valid java name */
    /* synthetic */ void m840lambda$update$4$comandroidsettingslibwifiAccessPoint() {
        AccessPointListener r0 = this.mAccessPointListener;
        if (r0 == null) goto L6;
        r0.onLevelChanged(this);
        return;
    }

    void update(WifiConfiguration r2) {
        this.mConfig = r2;
        if (r2 != null) goto L5;
    L7:
        if (r2 == null) goto L9;
        int r3 = r2.networkId;
    L10:
        this.networkId = r3;
        ThreadUtils.postOnMainThread(new AccessPoint$$ExternalSyntheticLambda1(this));
        return;
    L9:
        r3 = -1;
        goto L10
    L5:
        if (isPasspoint() == true) goto L7;
        this.ssid = removeDoubleQuotes(this.mConfig.SSID);
        goto L7
    }

    /* JADX INFO: renamed from: lambda$update$5$com-android-settingslib-wifi-AccessPoint, reason: not valid java name */
    /* synthetic */ void m841lambda$update$5$comandroidsettingslibwifiAccessPoint() {
        AccessPointListener r0 = this.mAccessPointListener;
        if (r0 == null) goto L6;
        r0.onAccessPointChanged(this);
        return;
    }

    void setRssi(int r1) {
        this.mRssi = r1;
    }

    void setUnreachable() {
        setRssi(Integer.MIN_VALUE);
    }

    int getSpeed() {
        return this.mSpeed;
    }

    String getSpeedLabel() {
        return getSpeedLabel(this.mSpeed);
    }

    String getSpeedLabel(int r1) {
        return getSpeedLabel(this.mContext, r1);
    }

    private static String getSpeedLabel(Context r1, int r2) {
        if (r2 == 5) goto L19;
        if (r2 == 10) goto L17;
        if (r2 == 20) goto L15;
        if (r2 == 30) goto L13;
        return null;
    L13:
        return r1.getString(R.string.speed_label_very_fast);
    L15:
        return r1.getString(R.string.speed_label_fast);
    L17:
        return r1.getString(R.string.speed_label_okay);
    L19:
        return r1.getString(R.string.speed_label_slow);
    }

    public static String getSpeedLabel(Context r0, ScoredNetwork r1, int r2) {
        return getSpeedLabel(r0, roundToClosestSpeedEnum(r1.calculateBadge(r2)));
    }

    public boolean isReachable() {
        if (this.mRssi == Integer.MIN_VALUE) goto L5;
        return true;
    L5:
        return false;
    }

    private static CharSequence getAppLabel(String r3, PackageManager r4) {
        ApplicationInfo r5 = r4.getApplicationInfoAsUser(r3, 0, UserHandle.getUserId(-2));     // Catch: PackageManager.NameNotFoundException -> L7
        if (r5 != null) goto L6;
        return "";
    L6:
        return r5.loadLabel(r4);
    L7:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "Failed to get app info", e);
        return "";
    }

    public static String getSummary(Context r3, String r4, NetworkInfo.DetailedState r5, boolean r6, String r7) {
        if (r5 != NetworkInfo.DetailedState.CONNECTED) goto L18;
        if (r6 == true) goto L6;
    L9:
        if (r6 == false) goto L18;
        NetworkScorerAppData r8 = ((NetworkScoreManager) r3.getSystemService(NetworkScoreManager.class)).getActiveScorer();
        if (r8 == null) goto L17;
        if (r8.getRecommendationServiceLabel() == null) goto L17;
        return String.format(r3.getString(R.string.connected_via_network_scorer), new Object[]{r8.getRecommendationServiceLabel()});
    L17:
        return r3.getString(R.string.connected_via_network_scorer_default);
    L6:
        if (TextUtils.isEmpty(r7) == true) goto L9;
        CharSequence r9 = getAppLabel(r7, r3.getPackageManager());
        return r3.getString(R.string.connected_via_app, new Object[]{r9});
    L18:
        ConnectivityManager r10 = (ConnectivityManager) r3.getSystemService("connectivity");
        if (r5 != NetworkInfo.DetailedState.CONNECTED) goto L39;
        NetworkCapabilities r11 = r10.getNetworkCapabilities(((WifiManager) r3.getSystemService(WifiManager.class)).getCurrentNetwork());
        if (r11 == null) goto L39;
        if (r11.hasCapability(17) == false) goto L27;
        return r3.getString(r3.getResources().getIdentifier("network_available_sign_in", "string", RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME));
    L27:
        if (r11.hasCapability(24) == false) goto L31;
        return r3.getString(R.string.wifi_limited_connection);
    L31:
        if (r11.hasCapability(16) == true) goto L39;
        Settings.Global.getString(r3.getContentResolver(), "private_dns_mode");
        if (r11.isPrivateDnsBroken() == false) goto L37;
        return r3.getString(R.string.private_dns_broken);
    L37:
        return r3.getString(R.string.wifi_connected_no_internet);
    L39:
        if (r5 != null) goto L42;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "state is null, returning empty summary");
        return "";
    L42:
        Resources r12 = r3.getResources();
        if (r4 != null) goto L45;
        int r13 = R.array.wifi_status;
    L46:
        String[] r14 = r12.getStringArray(r13);
        int r15 = r5.ordinal();
        if (r15 < r14.length) goto L49;
    L53:
        return "";
    L49:
        if (r14[r15].length() == 0) goto L53;
        return String.format(r14[r15], new Object[]{r4});
    L45:
        r13 = R.array.wifi_status_with_ssid;
        goto L46
    }

    public static String convertToQuotedString(String r2) {
        return "\"" + r2 + "\"";
    }

    private static int getPskType(ScanResult r4) {
        boolean r0 = r4.capabilities.contains("WPA-PSK");
        boolean r1 = r4.capabilities.contains("RSN-PSK");
        boolean r2 = r4.capabilities.contains("RSN-SAE");
        if (r1 == false) goto L7;
        if (r0 == false) goto L7;
        return 3;
    L7:
        if (r1 == false) goto L10;
        return 2;
    L10:
        if (r0 == false) goto L13;
        return 1;
    L13:
        if (r2 == true) goto L17;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Received abnormal flag string: " + r4.capabilities);
        return 0;
    L17:
        return 0;
    }

    private static int getEapType(ScanResult r2) {
        if (r2.capabilities.contains("RSN-EAP") == false) goto L7;
        return 2;
    L7:
        if (r2.capabilities.contains("WPA-EAP") == false) goto L10;
        return 1;
    L10:
        return 0;
    }

    private static int getSecurity(Context r12, ScanResult r13) {
        boolean r0 = r13.capabilities.contains("WEP");
        boolean r1 = r13.capabilities.contains("SAE");
        boolean r2 = r13.capabilities.contains("PSK");
        boolean r3 = r13.capabilities.contains("EAP_SUITE_B_192");
        boolean r4 = r13.capabilities.contains("EAP");
        boolean r5 = r13.capabilities.contains("OWE");
        boolean r6 = r13.capabilities.contains("OWE_TRANSITION");
        boolean r14 = r13.capabilities.contains("DPP");
        if (r1 == false) goto L11;
        if (r2 == false) goto L11;
        if (((WifiManager) r12.getSystemService("wifi")).isWpa3SaeSupported() == false) goto L9;
        return 5;
    L9:
        return 2;
    L11:
        if (r6 == true) goto L13;
        if (r14 == false) goto L20;
        return 8;
    L20:
        if (r0 == false) goto L23;
        return 1;
    L23:
        if (r1 == false) goto L25;
        return 5;
    L25:
        if (r2 == false) goto L27;
        return 2;
    L27:
        if (r3 == false) goto L30;
        return 6;
    L30:
        if (r4 == false) goto L33;
        return 3;
    L33:
        if (r5 == false) goto L35;
        return 4;
    L35:
        return 0;
    L13:
        if (((WifiManager) r12.getSystemService("wifi")).isEnhancedOpenSupported() == false) goto L16;
        return 4;
    L16:
        return 0;
    }

    static int getSecurity(WifiConfiguration r5) {
        if (r5.allowedKeyManagement.get(8) == false) goto L7;
        return 5;
    L7:
        if (r5.allowedKeyManagement.get(1) == false) goto L10;
        return 2;
    L10:
        if (r5.allowedKeyManagement.get(10) == false) goto L14;
        return 6;
    L14:
        if (r5.allowedKeyManagement.get(2) == false) goto L16;
    L34:
        return 3;
    L16:
        if (r5.allowedKeyManagement.get(3) == true) goto L34;
        if (r5.allowedKeyManagement.get(17) == false) goto L22;
        return 8;
    L22:
        if (r5.allowedKeyManagement.get(9) == false) goto L26;
        return 4;
    L26:
        if (r5.wepTxKeyIndex >= 0) goto L28;
    L32:
        return 0;
    L28:
        if (r5.wepTxKeyIndex >= r5.wepKeys.length) goto L32;
        if (r5.wepKeys[r5.wepTxKeyIndex] == null) goto L32;
        return 1;
    }

    static String removeDoubleQuotes(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return "";
    L6:
        int r0 = r4.length();
        if (r0 > 1) goto L9;
        return r4;
    L9:
        if (r4.charAt(0) != '\"') goto L15;
        int r1 = r0 - 1;
        if (r4.charAt(r1) == '\"') goto L13;
        return r4;
    L13:
        return r4.substring(1, r1);
    L15:
        return r4;
    }

    private WifiManager getWifiManager() {
        if (this.mWifiManager != null) goto L6;
        this.mWifiManager = (WifiManager) this.mContext.getSystemService("wifi");
    L6:
        return this.mWifiManager;
    }

    public boolean isOpenNetwork() {
        int r1 = this.security;
        if (r1 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 4) goto L8;
        return false;
    }

    private static boolean isVerboseLoggingEnabled() {
        if (WifiTracker.sVerboseLogging == false) goto L5;
    L8:
        return true;
    L5:
        if (Log.isLoggable(TAG, 2) == true) goto L8;
        return false;
    }

    public boolean isPskSaeTransitionMode() {
        return this.mIsPskSaeTransitionMode;
    }

    public boolean isOweTransitionMode() {
        return this.mIsOweTransitionMode;
    }

    private static boolean isPskSaeTransitionMode(ScanResult r2) {
        if (r2.capabilities.contains("PSK") == true) goto L5;
    L7:
        return false;
    L5:
        if (r2.capabilities.contains("SAE") == false) goto L7;
        return true;
    }

    private static boolean isOweTransitionMode(ScanResult r1) {
        return r1.capabilities.contains("OWE_TRANSITION");
    }

    private boolean isSameSsidOrBssid(ScanResult r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (TextUtils.equals(this.ssid, r4.SSID) == false) goto L9;
        return true;
    L9:
        if (r4.BSSID != null) goto L11;
    L13:
        return false;
    L11:
        if (TextUtils.equals(this.bssid, r4.BSSID) == false) goto L13;
        return true;
    }

    private boolean isSameSsidOrBssid(WifiInfo r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (TextUtils.equals(this.ssid, removeDoubleQuotes(r4.getSSID())) == false) goto L9;
        return true;
    L9:
        if (r4.getBSSID() != null) goto L11;
    L13:
        return false;
    L11:
        if (TextUtils.equals(this.bssid, r4.getBSSID()) == false) goto L13;
        return true;
    }

    private boolean isSameSsidOrBssid(AccessPoint r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (TextUtils.equals(this.ssid, r4.getSsid()) == false) goto L9;
        return true;
    L9:
        if (r4.getBssid() != null) goto L11;
    L13:
        return false;
    L11:
        if (TextUtils.equals(this.bssid, r4.getBssid()) == false) goto L13;
        return true;
    }

    private void updateDeviceWifiGenerationInfo() {
        WifiManager r0 = getWifiManager();
        if (r0.isWifiStandardSupported(6) == false) goto L6;
        this.mDeviceWifiStandard = 6;
        return;
    L6:
        if (r0.isWifiStandardSupported(5) == false) goto L9;
        this.mDeviceWifiStandard = 5;
        return;
    L9:
        if (r0.isWifiStandardSupported(4) == false) goto L11;
        this.mDeviceWifiStandard = 4;
        return;
    L11:
        this.mDeviceWifiStandard = 1;
    }

    private void updateWifiGeneration() {
        int r0 = this.mDeviceWifiStandard;
        Iterator<ScanResult> r1 = this.mScanResults.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        int r2 = r1.next().getWifiStandard();
        if (r2 >= r0) goto L4;
        r0 = r2;
        goto L4
    L8:
        this.mWifiStandard = r0;
    }

    public int getWifiStandard() {
        if (isActive() == false) goto L9;
        WifiInfo r0 = this.mInfo;
        if (r0 == null) goto L9;
        return r0.getWifiStandard();
    L9:
        return this.mWifiStandard;
    }
}
