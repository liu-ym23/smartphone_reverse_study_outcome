package com.android.settings.wifi;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.settings.AdaptWifi;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settings.R;
import com.android.settings.SettingsApplication;
import com.android.settings.WifiConfigurationSmtOnly;
import com.android.wifitrackerlib.WifiEntry;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes.dex */
public class AccessPointInfo implements Comparable<AccessPointInfo> {
    public static final String EXTRA_DETAILED_STATE = "extra_detailed_state";
    public static final String EXTRA_PSK_TYPE = "extra_psk_type";
    public static final String EXTRA_WIFI_CONFIGURATION = "extra_wifi_configuration";
    public static final String EXTRA_WIFI_INFO = "extra_wifi_info";
    public static final int HIGHER_FREQ_24GHZ = 2500;
    public static final int HIGHER_FREQ_5GHZ = 5900;
    private static final String KEY_CONFIG = "key_config";
    private static final String KEY_DETAILEDSTATE = "key_detailedstate";
    private static final String KEY_SCANRESULT = "key_scanresult";
    private static final String KEY_WIFIINFO = "key_wifiinfo";
    public static final int LOWER_FREQ_24GHZ = 2400;
    public static final int LOWER_FREQ_5GHZ = 4900;
    static final int SECURITY_EAP = 3;
    public static final int SECURITY_NONE = 0;
    static final int SECURITY_PSK = 2;
    static final int SECURITY_SAE = 6;
    static final int SECURITY_WAPI_CERT = 5;
    static final int SECURITY_WAPI_PSK = 4;
    static final int SECURITY_WEP = 1;
    private static final String TAG = "AccessPointInfo";
    private static int mConnectedAccessPointRssi = -200;
    static WifiManager mWifiManager;
    public String bssid;
    private boolean is24GHz;
    private boolean is5GHz;
    boolean isAutoConnected;
    boolean isSafe;
    boolean isTrusted;
    public String key;
    public WifiConfiguration mConfig;
    android.net.wifi.WifiInfo mInfo;
    public int mRssi;
    ScanResult mScanResult;
    public NetworkInfo.DetailedState mState;
    boolean needLogin;
    public int networkId;
    public AccessPoint.PskType pskType;
    public int security;
    public String ssid;
    public WifiEntry wifiEntry;

    /* JADX INFO: renamed from: com.android.settings.wifi.AccessPointInfo$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$settings$wifi$AccessPoint$PskType = null;

        static {
            int[] r0 = new int[AccessPoint.PskType.values().length];
            $SwitchMap$com$android$settings$wifi$AccessPoint$PskType = r0;
            r0[AccessPoint.PskType.WPA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$android$settings$wifi$AccessPoint$PskType[AccessPoint.PskType.WPA2.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$android$settings$wifi$AccessPoint$PskType[AccessPoint.PskType.WPA_WPA2.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$android$settings$wifi$AccessPoint$PskType[AccessPoint.PskType.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(AccessPointInfo r1) {
        return compareTo2(r1);
    }

    static {
        mWifiManager = (WifiManager) SettingsApplication.getContext().getSystemService(WifiManager.class);
    }

    public AccessPointInfo(WifiConfiguration r2) {
        this.networkId = -1;
        this.wifiEntry = null;
        this.pskType = AccessPoint.PskType.UNKNOWN;
        this.mRssi = Integer.MAX_VALUE;
        this.is24GHz = false;
        this.is5GHz = false;
        this.isSafe = true;
        loadConfig(r2);
    }

    public AccessPointInfo(ScanResult r2) {
        this.networkId = -1;
        this.wifiEntry = null;
        this.pskType = AccessPoint.PskType.UNKNOWN;
        this.mRssi = Integer.MAX_VALUE;
        this.is24GHz = false;
        this.is5GHz = false;
        this.isSafe = true;
        loadResult(r2);
    }

    private void loadResult(ScanResult r3) {
        this.ssid = r3.SSID;
        this.bssid = r3.BSSID;
        int r0 = getSecurity(r3);
        this.security = r0;
        if (r0 != 2) goto L5;
        this.pskType = getPskType(r3);
    L5:
        this.networkId = -1;
        this.mRssi = r3.level;
        this.mScanResult = r3;
        if (r3.is24GHz() == false) goto L9;
        this.is24GHz = true;
    L9:
        if (r3.is5GHz() == false) goto L12;
        this.is5GHz = true;
        return;
    }

    static int getSecurity(WifiConfiguration r5) {
        int r2 = 2;
        if (r5.allowedKeyManagement.get(1) == false) goto L5;
    L31:
        return r2;
    L5:
        if (r5.allowedKeyManagement.get(4) == true) goto L31;
        r2 = 3;
        if (r5.allowedKeyManagement.get(2) == true) goto L31;
        if (r5.allowedKeyManagement.get(3) == true) goto L31;
        int r3 = 0;
    L14:
        if (r3 >= r5.wepKeys.length) goto L20;
        if (r5.wepKeys[r3] != null) goto L17;
        r3 = r3 + 1;
        goto L14
    L17:
        return 1;
    L20:
        if (r5.allowedKeyManagement.get(MultiSDKAdapterNew.getWapiPskValue()) == false) goto L23;
        return 4;
    L23:
        if (r5.allowedKeyManagement.get(MultiSDKAdapterNew.getWapiCertValue()) == false) goto L27;
        return 5;
    L27:
        if (r5.allowedKeyManagement.get(8) == false) goto L30;
        return 6;
    L30:
        return 0;
    }

    public static int getSecurity(ScanResult r2) {
        if (r2.capabilities.contains(AdaptWifi.getSecurityWapiPskValue()) == false) goto L7;
        return 4;
    L7:
        if (r2.capabilities.contains("WAPI-CERT") == false) goto L11;
        return 5;
    L11:
        if (r2.capabilities.contains("WEP") == false) goto L15;
        return 1;
    L15:
        if (r2.capabilities.contains("PSK") == false) goto L19;
        return 2;
    L19:
        if (r2.capabilities.contains("EAP") == false) goto L23;
        return 3;
    L23:
        if (r2.capabilities.contains("SAE") == false) goto L26;
        return 6;
    L26:
        return 0;
    }

    public String getSecurityString(boolean r6) {
        Context r0 = SettingsApplication.getContext();
        int r1 = this.security;
        if (r1 != 1) goto L5;
        if (r6 == false) goto L46;
        return r0.getString(R.string.wifi_security_short_wep);
    L46:
        return r0.getString(R.string.wifi_security_wep);
    L5:
        if (r1 == 2) goto L23;
        if (r1 != 3) goto L8;
        if (r6 == false) goto L22;
        return r0.getString(R.string.wifi_security_short_eap);
    L22:
        return r0.getString(R.string.wifi_security_eap);
    L8:
        if (r1 == 4) goto L18;
        if (r1 == 5) goto L16;
        if (r6 == false) goto L14;
        return "";
    L14:
        return r0.getString(R.string.wifi_security_none);
    L16:
        return r0.getString(R.string.wifi_security_wapi_cert);
    L18:
        return r0.getString(R.string.wifi_security_wapi_psk);
    L23:
        int r5 = AnonymousClass1.$SwitchMap$com$android$settings$wifi$AccessPoint$PskType[this.pskType.ordinal()];
        if (r5 == 1) goto L39;
        if (r5 == 2) goto L35;
        if (r5 == 3) goto L31;
        if (r6 == false) goto L30;
        return r0.getString(R.string.wifi_security_short_psk_generic);
    L30:
        return r0.getString(R.string.wifi_security_psk_generic);
    L31:
        if (r6 == false) goto L34;
        return r0.getString(R.string.wifi_security_short_wpa_wpa2);
    L34:
        return r0.getString(R.string.wifi_security_wpa_wpa2);
    L35:
        if (r6 == false) goto L38;
        return r0.getString(R.string.wifi_security_short_wpa2);
    L38:
        return r0.getString(R.string.wifi_security_wpa2);
    L39:
        if (r6 == false) goto L42;
        return r0.getString(R.string.wifi_security_short_wpa);
    L42:
        return r0.getString(R.string.wifi_security_wpa);
    }

    private static AccessPoint.PskType getPskType(ScanResult r3) {
        boolean r0 = r3.capabilities.contains("WPA-PSK");
        boolean r1 = r3.capabilities.contains("WPA2-PSK");
        if (r1 == false) goto L7;
        if (r0 == false) goto L7;
        return AccessPoint.PskType.WPA_WPA2;
    L7:
        if (r1 == true) goto L9;
        if (r0 == true) goto L12;
        OLog.w(TAG, "Received abnormal flag string: " + r3.capabilities);
        return AccessPoint.PskType.UNKNOWN;
    L12:
        return AccessPoint.PskType.WPA;
    L9:
        return AccessPoint.PskType.WPA2;
    }

    public void loadConfig(WifiConfiguration r3) {
        if (r3.SSID != null) goto L5;
        String r0 = "";
    L6:
        this.ssid = r0;
        if (r3.getMacRandomizationSetting() != 1) goto L9;
        String r1 = r3.getRandomizedMacAddress().toString();
    L11:
        if (TextUtils.isEmpty(this.bssid) == true) goto L13;
    L15:
        this.security = getSecurity(r3);
        this.networkId = r3.networkId;
        this.isTrusted = WifiConfigurationSmtOnly.get_isTrustedAp(r3);
        this.needLogin = WifiConfigurationSmtOnly.get_needLogin(r3);
        this.isAutoConnected = WifiConfigurationSmtOnly.get_autoConnect(r3);
        this.mConfig = r3;
        return;
    L13:
        if (TextUtils.isEmpty(r1) == true) goto L15;
        this.bssid = r1;
        goto L15
    L9:
        r1 = r3.BSSID;
        goto L11
    L5:
        r0 = removeDoubleQuotes(r3.SSID);
        goto L6
    }

    public boolean isSaved() {
        if (this.networkId == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public void update(android.net.wifi.WifiInfo r3, NetworkInfo.DetailedState r4) {
        if (r3 == null) goto L11;
        int r0 = this.networkId;
        if (r0 == (-1)) goto L11;
        if (r0 != r3.getNetworkId()) goto L11;
        if (checkSecuritySame(r3) == false) goto L11;
        this.mRssi = r3.getRssi();
        this.mInfo = r3;
        this.mState = r4;
        return;
    L11:
        if (this.mInfo == null) goto L15;
        this.mInfo = null;
        this.mState = null;
        return;
    }

    public boolean update(ScanResult r5, boolean r6) {
        if (r6 == false) goto L5;
    L8:
        boolean r7 = true;
    L10:
        if (this.ssid.equals(r5.SSID) == false) goto L16;
        if (r7 == false) goto L16;
        if (this.mScanResult != null) goto L16;
        this.mScanResult = r5;
    L16:
        if (r5.is24GHz() == false) goto L19;
        this.is24GHz = true;
    L19:
        if (r5.is5GHz() == false) goto L22;
        this.is5GHz = true;
    L22:
        if (this.ssid.equals(r5.SSID) == true) goto L24;
    L33:
        return false;
    L24:
        if (checkSecuritySame(r5) == false) goto L33;
        if (r7 == false) goto L33;
        if (WifiManager.compareSignalLevel(r5.level, this.mRssi) <= 0) goto L30;
        this.mRssi = r5.level;
    L30:
        if (this.security != 2) goto L32;
        this.pskType = getPskType(r5);
    L32:
        return true;
    L5:
        if (com.android.wifitrackerlib.Utils.getBand(getFrequency()) == com.android.wifitrackerlib.Utils.getBand(r5.frequency)) goto L8;
        r7 = false;
        goto L10
    }

    public boolean checkSecuritySame(ScanResult r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (this.security != 0) goto L10;
        if (getSecurity(r3) != 0) goto L10;
    L13:
        return true;
    L10:
        if (this.security != 0) goto L12;
        return false;
    L12:
        if (getSecurity(r3) != 0) goto L13;
        return false;
    }

    public boolean checkSecuritySame(android.net.wifi.WifiInfo r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (this.security != 0) goto L10;
        if (r3.getCurrentSecurityType() != 0) goto L10;
    L13:
        return true;
    L10:
        if (this.security != 0) goto L12;
        return false;
    L12:
        if (r3.getCurrentSecurityType() != 0) goto L13;
        return false;
    }

    public boolean checkSecuritySame(WifiEntry r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (this.security != 0) goto L10;
        if (r3.getSecurity() != 0) goto L10;
    L13:
        return true;
    L10:
        if (this.security != 0) goto L12;
        return false;
    L12:
        if (r3.getSecurity() != 0) goto L13;
        return false;
    }

    public boolean update(ScanResult r2) {
        return update(r2, true);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(AccessPointInfo r6) {
        if ((r6 instanceof AccessPointInfo) == true) goto L5;
        return 1;
    L5:
        android.net.wifi.WifiInfo r0 = this.mInfo;
        if (r0 != null) goto L8;
    L10:
        if (r0 == null) goto L12;
    L14:
        int r1 = this.mRssi;
        if (r1 != Integer.MAX_VALUE) goto L17;
    L19:
        if (r1 == Integer.MAX_VALUE) goto L21;
    L23:
        if (r1 == Integer.MAX_VALUE) goto L25;
    L27:
        int r3 = this.networkId;
        if (r3 != (-1)) goto L30;
    L32:
        if (r3 == (-1)) goto L34;
    L36:
        int r2 = WifiManager.compareSignalLevel(r6.mRssi, r1);
        if (r2 == 0) goto L39;
        return r2;
    L39:
        int r4 = this.ssid.compareToIgnoreCase(r6.ssid);
        if (r4 == 0) goto L43;
        return r4;
    L43:
        if (getFrequency() > r6.getFrequency()) goto L45;
        return 1;
    L45:
        return -1;
    L34:
        if (r6.networkId == (-1)) goto L36;
        return 1;
    L30:
        if (r6.networkId != (-1)) goto L32;
        return -1;
    L25:
        if (r6.mRssi == Integer.MAX_VALUE) goto L27;
        return 1;
    L21:
        if (r6.mRssi == Integer.MAX_VALUE) goto L23;
        return 1;
    L17:
        if (r6.mRssi != Integer.MAX_VALUE) goto L19;
        return -1;
    L12:
        if (r6.mInfo == null) goto L14;
        return 1;
    L8:
        if (r6.mInfo != null) goto L10;
        return -1;
    }

    public boolean equals(Object r3) {
        if ((r3 instanceof AccessPointInfo) == true) goto L6;
        return false;
    L6:
        if (compareTo2((AccessPointInfo) r3) != 0) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean equalsTo(Object r4) {
        if ((r4 instanceof AccessPointInfo) == true) goto L5;
        return false;
    L5:
        AccessPointInfo r5 = (AccessPointInfo) r4;
        if (this.ssid.equals(r5.ssid) == true) goto L9;
        return false;
    L9:
        if (this.security == r5.security) goto L12;
        return false;
    L12:
        if (this.networkId == r5.networkId) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        android.net.wifi.WifiInfo r0 = this.mInfo;
        int r1 = 0;
        if (r0 == null) goto L6;
        r1 = 0 + (r0.hashCode() * 13);
    L6:
        return ((r1 + (this.mRssi * 19)) + (this.networkId * 23)) + (this.ssid.hashCode() * 29);
    }

    public static void updateConnectedAccessPointRssi(int r0) {
        mConnectedAccessPointRssi = r0;
    }

    public int getLevel() {
        WifiEntry r0 = this.wifiEntry;
        if (r0 == null) goto L11;
        if (r0.getConnectedState() != 2) goto L7;
        OLog.d(TAG, "wifiEntry.getLevel:" + this.wifiEntry.getLevel() + " ssid:" + this.wifiEntry.getSsid());
    L7:
        int r2 = this.wifiEntry.getLevel();
    L9:
        return r2 - 1;
    L11:
        if (this.mState == null) goto L15;
        int r1 = mConnectedAccessPointRssi;
        if (r1 == (-200)) goto L15;
        r2 = mWifiManager.calculateSignalLevel(r1);
    L15:
        int r3 = this.mRssi;
        if (r3 != Integer.MAX_VALUE) goto L19;
        return -1;
    L19:
        r2 = mWifiManager.calculateSignalLevel(r3);
        goto L9
    }

    public WifiConfiguration getConfig() {
        return this.mConfig;
    }

    public android.net.wifi.WifiInfo getInfo() {
        return this.mInfo;
    }

    public NetworkInfo.DetailedState getState() {
        return this.mState;
    }

    public static String removeDoubleQuotes(String r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        int r0 = r4.length();
        if (r0 > 1) goto L8;
        return r4;
    L8:
        if (r4.charAt(0) != '\"') goto L14;
        int r1 = r0 - 1;
        if (r4.charAt(r1) == '\"') goto L12;
        return r4;
    L12:
        return r4.substring(1, r1);
    L14:
        return r4;
    }

    static String convertToQuotedString(String r2) {
        return "\"" + r2 + "\"";
    }

    public void saveWifiState(Bundle r3) {
        r3.putParcelable(KEY_CONFIG, this.mConfig);
        r3.putParcelable(KEY_SCANRESULT, this.mScanResult);
        r3.putParcelable(KEY_WIFIINFO, this.mInfo);
        NetworkInfo.DetailedState r2 = this.mState;
        if (r2 == null) goto L6;
        r3.putString(KEY_DETAILEDSTATE, r2.toString());
        return;
    }

    public void generateOpenNetworkConfig() {
        if (this.security != 0) goto L10;
        if (this.mConfig == null) goto L7;
        return;
    L7:
        WifiConfiguration r0 = new WifiConfiguration();
        this.mConfig = r0;
        r0.SSID = AccessPoint.convertToQuotedString(this.ssid);
        this.mConfig.allowedKeyManagement.set(0);
        return;
    L10:
        throw new IllegalStateException();
    }

    public int getFrequency() {
        ScanResult r0 = this.mScanResult;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.frequency;
    }

    public boolean is5GHz() {
        return this.is5GHz;
    }

    public boolean is24GHz() {
        return this.is24GHz;
    }

    public void setIsSafe(boolean r1) {
        this.isSafe = r1;
    }
}
