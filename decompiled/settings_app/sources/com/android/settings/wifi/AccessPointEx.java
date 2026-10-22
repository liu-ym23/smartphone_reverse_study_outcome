package com.android.settings.wifi;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.settings.R;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes.dex */
class AccessPointEx extends RelativeLayout {
    private static final String KEY_CONFIG = "key_config";
    private static final String KEY_DETAILEDSTATE = "key_detailedstate";
    private static final String KEY_SCANRESULT = "key_scanresult";
    private static final String KEY_WIFIINFO = "key_wifiinfo";
    static final int SECURITY_EAP = 3;
    static final int SECURITY_NONE = 0;
    static final int SECURITY_PSK = 2;
    static final int SECURITY_WEP = 1;
    private static final int[] STATE_NONE = null;
    private static final int[] STATE_SECURED = null;
    static final String TAG = "Settings.AccessPoint";
    String bssid;
    private WifiConfiguration mConfig;
    private android.net.wifi.WifiInfo mInfo;
    private int mRssi;
    ScanResult mScanResult;
    private NetworkInfo.DetailedState mState;
    private ImageView mViewIcon;
    private TextView mViewSummary;
    private TextView mViewTitle;
    int networkId;
    PskType pskType;
    int security;
    String ssid;
    boolean wpsAvailable;

    /* JADX INFO: renamed from: com.android.settings.wifi.AccessPointEx$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$settings$wifi$AccessPointEx$PskType = null;

        static {
            int[] r0 = new int[PskType.values().length];
            $SwitchMap$com$android$settings$wifi$AccessPointEx$PskType = r0;
            r0[PskType.WPA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$android$settings$wifi$AccessPointEx$PskType[PskType.WPA2.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$android$settings$wifi$AccessPointEx$PskType[PskType.WPA_WPA2.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$android$settings$wifi$AccessPointEx$PskType[PskType.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static final enum PskType extends Enum<PskType> {
        private static final /* synthetic */ PskType[] $VALUES = null;
        public static final PskType UNKNOWN = null;
        public static final PskType WPA = null;
        public static final PskType WPA2 = null;
        public static final PskType WPA_WPA2 = null;

        private static /* synthetic */ PskType[] $values() {
            return new PskType[]{UNKNOWN, WPA, WPA2, WPA_WPA2};
        }

        private PskType(String r1, int r2) {
            super(r1, r2);
        }

        public static PskType valueOf(String r1) {
            return (PskType) Enum.valueOf(PskType.class, r1);
        }

        public static PskType[] values() {
            return (PskType[]) $VALUES.clone();
        }

        static {
            UNKNOWN = new PskType(NetworkStackConstant.UNKNOWN_TYPE, 0);
            WPA = new PskType("WPA", 1);
            WPA2 = new PskType("WPA2", 2);
            WPA_WPA2 = new PskType("WPA_WPA2", 3);
            $VALUES = $values();
        }
    }

    static {
        STATE_SECURED = new int[]{R.attr.state_encrypted};
        STATE_NONE = new int[0];
    }

    static int getSecurity(WifiConfiguration r3) {
        if (r3.allowedKeyManagement.get(1) == false) goto L6;
        return 2;
    L6:
        if (r3.allowedKeyManagement.get(2) == false) goto L8;
    L15:
        return 3;
    L8:
        if (r3.allowedKeyManagement.get(3) == true) goto L15;
        if (r3.wepKeys[0] == null) goto L14;
        return 1;
    L14:
        return 0;
    }

    private static int getSecurity(ScanResult r2) {
        if (r2.capabilities.contains("WEP") == false) goto L7;
        return 1;
    L7:
        if (r2.capabilities.contains("PSK") == false) goto L11;
        return 2;
    L11:
        if (r2.capabilities.contains("EAP") == false) goto L14;
        return 3;
    L14:
        return 0;
    }

    public String getSecurityString(boolean r6) {
        Context r0 = getContext();
        int r1 = this.security;
        if (r1 != 1) goto L5;
        if (r6 == false) goto L38;
        return r0.getString(R.string.wifi_security_short_wep);
    L38:
        return r0.getString(R.string.wifi_security_wep);
    L5:
        if (r1 == 2) goto L15;
        if (r1 == 3) goto L11;
        if (r6 == false) goto L10;
        return "";
    L10:
        return r0.getString(R.string.wifi_security_none);
    L11:
        if (r6 == false) goto L14;
        return r0.getString(R.string.wifi_security_short_eap);
    L14:
        return r0.getString(R.string.wifi_security_eap);
    L15:
        int r5 = AnonymousClass1.$SwitchMap$com$android$settings$wifi$AccessPointEx$PskType[this.pskType.ordinal()];
        if (r5 == 1) goto L31;
        if (r5 == 2) goto L27;
        if (r5 == 3) goto L23;
        if (r6 == false) goto L22;
        return r0.getString(R.string.wifi_security_short_psk_generic);
    L22:
        return r0.getString(R.string.wifi_security_psk_generic);
    L23:
        if (r6 == false) goto L26;
        return r0.getString(R.string.wifi_security_short_wpa_wpa2);
    L26:
        return r0.getString(R.string.wifi_security_wpa_wpa2);
    L27:
        if (r6 == false) goto L30;
        return r0.getString(R.string.wifi_security_short_wpa2);
    L30:
        return r0.getString(R.string.wifi_security_wpa2);
    L31:
        if (r6 == false) goto L34;
        return r0.getString(R.string.wifi_security_short_wpa);
    L34:
        return r0.getString(R.string.wifi_security_wpa);
    }

    private static PskType getPskType(ScanResult r3) {
        boolean r0 = r3.capabilities.contains("WPA-PSK");
        boolean r1 = r3.capabilities.contains("WPA2-PSK");
        if (r1 == false) goto L7;
        if (r0 == false) goto L7;
        return PskType.WPA_WPA2;
    L7:
        if (r1 == true) goto L9;
        if (r0 == true) goto L12;
        OLog.w(TAG, "Received abnormal flag string: " + r3.capabilities);
        return PskType.UNKNOWN;
    L12:
        return PskType.WPA;
    L9:
        return PskType.WPA2;
    }

    private void setTitle(String r1) {
        this.mViewTitle.setText(r1);
    }

    private void setSummary(String r1) {
        this.mViewSummary.setText(r1);
    }

    private void initViews(Context r3) {
        View r4 = LayoutInflater.from(r3).inflate(R.layout.wifi_accesspoint_item_layout, this, true);
        this.mViewTitle = (TextView) r4.findViewById(R.id.title);
        this.mViewSummary = (TextView) r4.findViewById(R.id.summary);
        this.mViewIcon = (ImageView) r4.findViewById(R.id.icon);
    }

    AccessPointEx(Context r2, WifiConfiguration r3) {
        super(r2);
        this.wpsAvailable = false;
        this.pskType = PskType.UNKNOWN;
        initViews(r2);
        loadConfig(r3);
        refresh();
    }

    AccessPointEx(Context r2, ScanResult r3) {
        super(r2);
        this.wpsAvailable = false;
        this.pskType = PskType.UNKNOWN;
        initViews(r2);
        loadResult(r3);
        refresh();
    }

    AccessPointEx(Context r2, Bundle r3) {
        super(r2);
        this.wpsAvailable = false;
        this.pskType = PskType.UNKNOWN;
        initViews(r2);
        WifiConfiguration r4 = (WifiConfiguration) r3.getParcelable(KEY_CONFIG);
        this.mConfig = r4;
        if (r4 == null) goto L5;
        loadConfig(r4);
    L5:
        ScanResult r5 = (ScanResult) r3.getParcelable(KEY_SCANRESULT);
        this.mScanResult = r5;
        if (r5 == null) goto L8;
        loadResult(r5);
    L8:
        this.mInfo = (android.net.wifi.WifiInfo) r3.getParcelable(KEY_WIFIINFO);
        if (r3.containsKey(KEY_DETAILEDSTATE) == false) goto L11;
        this.mState = NetworkInfo.DetailedState.valueOf(r3.getString(KEY_DETAILEDSTATE));
    L11:
        update(this.mInfo, this.mState);
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

    private void loadConfig(WifiConfiguration r2) {
        if (r2.SSID != null) goto L5;
        String r0 = "";
    L6:
        this.ssid = r0;
        this.bssid = r2.BSSID;
        this.security = getSecurity(r2);
        this.networkId = r2.networkId;
        this.mRssi = Integer.MAX_VALUE;
        this.mConfig = r2;
        return;
    L5:
        r0 = removeDoubleQuotes(r2.SSID);
        goto L6
    }

    private void loadResult(ScanResult r3) {
        this.ssid = r3.SSID;
        this.bssid = r3.BSSID;
        int r0 = getSecurity(r3);
        this.security = r0;
        if (r0 != 3) goto L5;
    L7:
        boolean r1 = false;
    L8:
        this.wpsAvailable = r1;
        if (this.security != 2) goto L11;
        this.pskType = getPskType(r3);
    L11:
        this.networkId = -1;
        this.mRssi = r3.level;
        this.mScanResult = r3;
        return;
    L5:
        if (r3.capabilities.contains("WPS") == false) goto L7;
        r1 = true;
        goto L8
    }

    public void updateSignial() {
        ImageView r0 = (ImageView) findViewById(R.id.icon);
        if (this.mRssi != Integer.MAX_VALUE) goto L5;
        r0.setImageDrawable(null);
        return;
    L5:
        r0.setImageLevel(getLevel());
        r0.setImageResource(R.drawable.wifi_signal);
        if (this.security == 0) goto L8;
        int[] r3 = STATE_SECURED;
    L9:
        r0.setImageState(r3, true);
        return;
    L8:
        r3 = STATE_NONE;
        goto L9
    }

    public int compareTo(AccessPointEx r7) {
        if ((r7 instanceof AccessPointEx) == true) goto L5;
        return 1;
    L5:
        android.net.wifi.WifiInfo r0 = this.mInfo;
        if (r0 == r7.mInfo) goto L10;
        if (r0 != null) goto L9;
        return 1;
    L9:
        return -1;
    L10:
        int r1 = this.mRssi;
        int r2 = r7.mRssi;
        if ((r1 ^ r2) < 0) goto L13;
        int r4 = this.networkId;
        if ((r7.networkId ^ r4) >= 0) goto L21;
        if (r4 != (-1)) goto L20;
        return 1;
    L20:
        return -1;
    L21:
        int r3 = WifiManager.compareSignalLevel(r2, r1);
        if (r3 == 0) goto L25;
        return r3;
    L25:
        return this.ssid.compareToIgnoreCase(r7.ssid);
    L13:
        if (r1 != Integer.MAX_VALUE) goto L15;
        return 1;
    L15:
        return -1;
    }

    boolean update(ScanResult r3) {
        if (this.ssid.equals(r3.SSID) == true) goto L5;
        return false;
    L5:
        if (this.security == getSecurity(r3)) goto L7;
        return false;
    L7:
        if (WifiManager.compareSignalLevel(r3.level, this.mRssi) <= 0) goto L10;
        getLevel();
        this.mRssi = r3.level;
        getLevel();
    L10:
        if (this.security != 2) goto L12;
        this.pskType = getPskType(r3);
    L12:
        refresh();
        return true;
    }

    void update(android.net.wifi.WifiInfo r3, NetworkInfo.DetailedState r4) {
        if (r3 == null) goto L9;
        int r0 = this.networkId;
        if (r0 == (-1)) goto L9;
        if (r0 != r3.getNetworkId()) goto L9;
        this.mRssi = r3.getRssi();
        this.mInfo = r3;
        this.mState = r4;
        refresh();
        return;
    L9:
        if (this.mInfo == null) goto L13;
        this.mInfo = null;
        this.mState = null;
        refresh();
        return;
    }

    int getLevel() {
        int r1 = this.mRssi;
        if (r1 != Integer.MAX_VALUE) goto L7;
        return -1;
    L7:
        return WifiManager.calculateSignalLevel(r1, 4);
    }

    WifiConfiguration getConfig() {
        return this.mConfig;
    }

    android.net.wifi.WifiInfo getInfo() {
        return this.mInfo;
    }

    NetworkInfo.DetailedState getState() {
        return this.mState;
    }

    static String removeDoubleQuotes(String r4) {
        int r0 = r4.length();
        if (r0 > 1) goto L5;
        return r4;
    L5:
        if (r4.charAt(0) != '\"') goto L11;
        int r1 = r0 - 1;
        if (r4.charAt(r1) == '\"') goto L9;
        return r4;
    L9:
        return r4.substring(1, r1);
    L11:
        return r4;
    }

    static String convertToQuotedString(String r2) {
        return "\"" + r2 + "\"";
    }

    private void refresh() {
        setTitle(this.ssid);
        Context r0 = getContext();
        NetworkInfo.DetailedState r1 = this.mState;
        if (r1 == null) goto L6;
        setSummary(Summary.get(r0, r1));
        updateSignial();
        return;
    L6:
        if (this.mRssi != Integer.MAX_VALUE) goto L8;
        setSummary(r0.getString(R.string.wifi_not_in_range));
        return;
    L8:
        WifiConfiguration r2 = this.mConfig;
        if (r2 != null) goto L11;
    L13:
        StringBuilder r3 = new StringBuilder();
        if (this.mConfig == null) goto L17;
        r3.append(r0.getString(R.string.wifi_remembered));
    L17:
        if (this.security == 0) goto L24;
        if (r3.length() != 0) goto L21;
        String r4 = r0.getString(R.string.wifi_secured_first_item);
    L22:
        r3.append(String.format(r4, new Object[]{getSecurityString(true)}));
        goto L24
    L21:
        r4 = r0.getString(R.string.wifi_secured_second_item);
    L24:
        if (this.mConfig == null) goto L26;
    L31:
        setSummary(r3.toString());
    L32:
        updateSignial();
        return;
    L26:
        if (this.wpsAvailable == false) goto L31;
        if (r3.length() != 0) goto L30;
        r3.append(r0.getString(R.string.wifi_wps_available_first_item));
        goto L31
    L30:
        r3.append(r0.getString(R.string.wifi_wps_available_second_item));
        goto L31
    L11:
        if (r2.status != 1) goto L13;
        goto L13
    }

    protected void generateOpenNetworkConfig() {
        if (this.security != 0) goto L10;
        if (this.mConfig == null) goto L7;
        return;
    L7:
        WifiConfiguration r0 = new WifiConfiguration();
        this.mConfig = r0;
        r0.SSID = convertToQuotedString(this.ssid);
        this.mConfig.allowedKeyManagement.set(0);
        return;
    L10:
        throw new IllegalStateException();
    }
}
