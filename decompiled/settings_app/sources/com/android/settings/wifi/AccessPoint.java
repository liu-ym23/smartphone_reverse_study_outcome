package com.android.settings.wifi;

import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.AdaptWifi;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settings.R;
import com.android.settings.Settings;
import com.android.settings.WifiConfigurationSmtOnly;
import com.android.settings.base.BaseActivity;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes.dex */
public class AccessPoint extends Preference implements View.OnClickListener {
    protected static final String EXTRA_DETAILED_STATE = "extra_detailed_state";
    protected static final String EXTRA_PSK_TYPE = "extra_psk_type";
    protected static final String EXTRA_WIFI_CONFIGURATION = "extra_wifi_configuration";
    protected static final String EXTRA_WIFI_INFO = "extra_wifi_info";
    public static final int HIGHER_FREQ_24GHZ = 2500;
    public static final int HIGHER_FREQ_5GHZ = 5900;
    public static final int INVALID_BG_RES = -1;
    public static final int ITEM_BG_BOTTOM = 2131235469;
    public static final int ITEM_BG_MIDDLE = 2131235470;
    public static final int ITEM_BG_SINGLE = 2131235471;
    public static final int ITEM_BG_TOP = 2131235473;
    private static final String KEY_CONFIG = "key_config";
    private static final String KEY_DETAILEDSTATE = "key_detailedstate";
    private static final String KEY_SCANRESULT = "key_scanresult";
    private static final String KEY_WIFIINFO = "key_wifiinfo";
    public static final int LOWER_FREQ_24GHZ = 2400;
    public static final int LOWER_FREQ_5GHZ = 4900;
    public static final int SECURITY_EAP = 3;
    public static final int SECURITY_NONE = 0;
    public static final int SECURITY_PSK = 2;
    static final int SECURITY_SAE = 6;
    public static final int SECURITY_WAPI_CERT = 5;
    public static final int SECURITY_WAPI_PSK = 4;
    public static final int SECURITY_WEP = 1;
    private static final int[] STATE_NONE = null;
    private static final int[] STATE_SECURED = null;
    static final String TAG = "Settings.AccessPoint";
    private static int mConnectedAccessPointRssi = -200;
    private ImageView accessPointInfo;
    String bssid;
    boolean isAutoConnected;
    boolean isTrusted;
    private int mBackgroundId;
    private WifiConfiguration mConfig;
    private android.net.wifi.WifiInfo mInfo;
    private int mRssi;
    ScanResult mScanResult;
    private NetworkInfo.DetailedState mState;
    private ViewStub mTrustedLabelStub;
    boolean needLogin;
    public int networkId;
    PskType pskType;
    public int security;
    boolean showSummary;
    public String ssid;

    /* JADX INFO: renamed from: com.android.settings.wifi.AccessPoint$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$settings$wifi$AccessPoint$PskType = null;

        static {
            int[] r0 = new int[PskType.values().length];
            $SwitchMap$com$android$settings$wifi$AccessPoint$PskType = r0;
            r0[PskType.WPA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$android$settings$wifi$AccessPoint$PskType[PskType.WPA2.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$android$settings$wifi$AccessPoint$PskType[PskType.WPA_WPA2.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$android$settings$wifi$AccessPoint$PskType[PskType.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static final enum PskType extends Enum<PskType> {
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

    @Override // androidx.preference.Preference, java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Preference r1) {
        return compareTo(r1);
    }

    static {
        STATE_SECURED = new int[]{R.attr.state_encrypted};
        STATE_NONE = new int[0];
    }

    public static int getSecurity(WifiConfiguration r5) {
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

    static int getSecurity(ScanResult r2) {
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
        Context r0 = getContext();
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

    AccessPoint(Context r1, WifiConfiguration r2) {
        super(r1);
        this.networkId = -1;
        this.showSummary = true;
        this.pskType = PskType.UNKNOWN;
        this.mRssi = Integer.MAX_VALUE;
        this.mBackgroundId = R.drawable.selector_setting_sub_item_bg_middle;
        setLayoutResource(R.layout.wifi_accesspoint_item_layout);
        loadConfig(r2);
    }

    AccessPoint(Context r1, ScanResult r2) {
        super(r1);
        this.networkId = -1;
        this.showSummary = true;
        this.pskType = PskType.UNKNOWN;
        this.mRssi = Integer.MAX_VALUE;
        this.mBackgroundId = R.drawable.selector_setting_sub_item_bg_middle;
        setLayoutResource(R.layout.wifi_accesspoint_item_layout);
        loadResult(r2);
    }

    AccessPoint(Context r1, String r2, int r3) {
        super(r1);
        this.networkId = -1;
        this.showSummary = true;
        this.pskType = PskType.UNKNOWN;
        this.mRssi = Integer.MAX_VALUE;
        this.mBackgroundId = R.drawable.selector_setting_sub_item_bg_middle;
        setLayoutResource(R.layout.wifi_accesspoint_item_layout);
        this.ssid = r2;
        this.security = r3;
    }

    public AccessPoint(Context r3, Bundle r4) {
        super(r3);
        this.networkId = -1;
        this.showSummary = true;
        this.pskType = PskType.UNKNOWN;
        this.mRssi = Integer.MAX_VALUE;
        this.mBackgroundId = R.drawable.selector_setting_sub_item_bg_middle;
        setLayoutResource(R.layout.wifi_accesspoint_item_layout);
        WifiConfiguration r0 = (WifiConfiguration) r4.getParcelable(KEY_CONFIG);
        this.mConfig = r0;
        if (r0 == null) goto L5;
        loadConfig(r0);
    L5:
        ScanResult r1 = (ScanResult) r4.getParcelable(KEY_SCANRESULT);
        this.mScanResult = r1;
        if (r1 == null) goto L8;
        loadResult(r1);
    L8:
        this.mInfo = (android.net.wifi.WifiInfo) r4.getParcelable(KEY_WIFIINFO);
        if (r4.containsKey(KEY_DETAILEDSTATE) == false) goto L11;
        this.mState = NetworkInfo.DetailedState.valueOf(r4.getString(KEY_DETAILEDSTATE));
    L11:
        update(this.mInfo, this.mState, -1);
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

    public void setBackgroundId(int r1) {
        if (r1 <= 0) goto L5;
        this.mBackgroundId = r1;
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
        this.isTrusted = WifiConfigurationSmtOnly.get_isTrustedAp(r2);
        this.needLogin = WifiConfigurationSmtOnly.get_needLogin(r2);
        this.isAutoConnected = WifiConfigurationSmtOnly.get_autoConnect(r2);
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
        if (r0 != 2) goto L5;
        this.pskType = getPskType(r3);
    L5:
        this.networkId = -1;
        this.mRssi = r3.level;
        this.mScanResult = r3;
    }

    public boolean isSaved() {
        if (this.networkId == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r5) {
        super.onBindViewHolder(r5);
        View r6 = r5.itemView;
        refresh();
        ImageView r0 = (ImageView) r6.findViewById(R.id.signal);
        boolean r1 = true;
        if (r0 != null) goto L5;
    L12:
        ImageView r2 = (ImageView) r6.findViewById(R.id.ap_detail);
        this.accessPointInfo = r2;
        int r3 = 0;
        if (r2 != null) goto L15;
    L21:
        boolean r4 = com.android.settings.Utils.isUseStrictLockScreen(r6.getContext());
        ViewStub r7 = (ViewStub) r6.findViewById(R.id.trusted_label_viewstub);
        this.mTrustedLabelStub = r7;
        if (r7 != null) goto L24;
        return;
    L24:
        if (this.isTrusted == false) goto L27;
        if (r4 == true) goto L27;
    L28:
        r7.setVisibility(r3);
        return;
    L27:
        r3 = 8;
        goto L28
    L15:
        if (this.mState == null) goto L17;
    L20:
        r2.setEnabled(r1);
        this.accessPointInfo.setOnClickListener(this);
        goto L21
    L17:
        if (this.mConfig != null) goto L20;
        r1 = false;
        goto L20
    L5:
        if (this.mRssi != Integer.MAX_VALUE) goto L7;
        r0.setImageDrawable(null);
        goto L12
    L7:
        r0.setImageResource(R.drawable.wifi_signal);
        r0.setImageLevel(getLevel());
        if (this.security == 0) goto L10;
        int[] r8 = STATE_SECURED;
    L11:
        r0.setImageState(r8, true);
        goto L12
    L10:
        r8 = STATE_NONE;
        goto L11
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r4) {
        if (r4.getId() != R.id.ap_detail) goto L9;
        Bundle r5 = new Bundle();
        r5.putParcelable("extra_wifi_configuration", this.mConfig);
        r5.putSerializable("extra_psk_type", this.pskType);
        r5.putParcelable("extra_wifi_info", this.mInfo);
        r5.putSerializable("extra_detailed_state", this.mState);
        r5.putInt("back_text_id", R.string.wifi_settings_title);
        if ((getContext() instanceof BaseActivity) == false) goto L7;
        AccessPointDetailFragment r0 = new AccessPointDetailFragment();
        r0.setArguments(r5);
        ((BaseActivity) getContext()).start(r0);
        return;
    L7:
        Intent r1 = new Intent(getContext(), Settings.AccessPointDetailActivity.class);
        r1.putExtras(r5);
        r1.addFlags(268435456);
        getContext().startActivity(r1);
        return;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.preference.Preference
    public int compareTo(Preference r6) {
        if ((r6 instanceof AccessPoint) == false) goto L5;
        AccessPoint r7 = (AccessPoint) r6;
        android.net.wifi.WifiInfo r0 = this.mInfo;
        if (r0 == null) goto L12;
        if (r7.mInfo != null) goto L12;
        return -1;
    L12:
        if (r0 == null) goto L14;
    L16:
        int r1 = this.mRssi;
        if (r1 != Integer.MAX_VALUE) goto L19;
    L21:
        if (r1 == Integer.MAX_VALUE) goto L23;
    L25:
        if (r1 == Integer.MAX_VALUE) goto L27;
    L29:
        int r2 = this.networkId;
        if (r2 != (-1)) goto L32;
    L34:
        if (r2 == (-1)) goto L36;
    L38:
        if (r2 != (-1)) goto L40;
    L47:
        int r3 = WifiManager.compareSignalLevel(r7.mRssi, this.mRssi);
        if (r3 == 0) goto L51;
        return r3;
    L51:
        return this.ssid.compareToIgnoreCase(r7.ssid);
    L40:
        if (r7.networkId == (-1)) goto L47;
        if (this.ssid.equals(r7.ssid) == false) goto L47;
        if (this.security == r7.security) goto L47;
        return getOrder() - r7.getOrder();
    L36:
        if (r7.networkId == (-1)) goto L38;
        return 1;
    L32:
        if (r7.networkId != (-1)) goto L34;
        return -1;
    L27:
        if (r7.mRssi == Integer.MAX_VALUE) goto L29;
        return 1;
    L23:
        if (r7.mRssi == Integer.MAX_VALUE) goto L25;
        return 1;
    L19:
        if (r7.mRssi != Integer.MAX_VALUE) goto L21;
        return -1;
    L14:
        if (r7.mInfo == null) goto L16;
        return 1;
    L5:
        return super.compareTo2(r6);
    }

    @Override // androidx.preference.Preference
    protected void onPrepareForRemoval() {
        super.onPrepareForRemoval();
        ImageView r1 = this.accessPointInfo;
        if (r1 == null) goto L6;
        r1.setOnClickListener(null);
        return;
    }

    public boolean equals(Object r3) {
        if ((r3 instanceof AccessPoint) == true) goto L6;
        return false;
    L6:
        if (compareTo((AccessPoint) r3) != 0) goto L9;
        return true;
    L9:
        return false;
    }

    boolean equalsTo(Object r4) {
        if ((r4 instanceof AccessPoint) == true) goto L5;
        return false;
    L5:
        AccessPoint r5 = (AccessPoint) r4;
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

    boolean update(ScanResult r2, int r3) {
        if (r3 <= 0) goto L5;
        this.mBackgroundId = r3;
    L5:
        if (this.ssid.equals(r2.SSID) == true) goto L7;
        return false;
    L7:
        if (this.security == getSecurity(r2)) goto L9;
        return false;
    L9:
        if (WifiManager.compareSignalLevel(r2.level, this.mRssi) <= 0) goto L14;
        int r4 = getLevel();
        this.mRssi = r2.level;
        if (getLevel() == r4) goto L14;
        notifyChanged();
    L14:
        if (this.security != 2) goto L16;
        this.pskType = getPskType(r2);
    L16:
        this.mScanResult = r2;
        return true;
    }

    void update(android.net.wifi.WifiInfo r4, NetworkInfo.DetailedState r5, int r6) {
        if (r6 <= 0) goto L4;
        this.mBackgroundId = r6;
    L4:
        boolean r7 = true;
        if (r4 == null) goto L16;
        int r1 = this.networkId;
        if (r1 == (-1)) goto L16;
        if (r1 != r4.getNetworkId()) goto L16;
        if (this.mInfo == null) goto L14;
        r7 = false;
    L14:
        this.mRssi = r4.getRssi();
        this.mInfo = r4;
        this.mState = r5;
    L19:
        if (r7 == false) goto L22;
        notifyHierarchyChanged();
        return;
    L22:
        return;
    L16:
        if (this.mInfo == null) goto L18;
        this.mInfo = null;
        this.mState = null;
        goto L19
    L18:
        r7 = false;
        goto L19
    }

    public static void updateConnectedAccessPointRssi(int r0) {
        mConnectedAccessPointRssi = r0;
    }

    public int getLevel() {
        if (this.mState == null) goto L8;
        int r0 = mConnectedAccessPointRssi;
        if (r0 == (-200)) goto L8;
        return WifiManager.calculateSignalLevel(r0, 4);
    L8:
        int r3 = this.mRssi;
        if (r3 != Integer.MAX_VALUE) goto L13;
        return -1;
    L13:
        return WifiManager.calculateSignalLevel(r3, 4);
    }

    public WifiConfiguration getConfig() {
        return this.mConfig;
    }

    android.net.wifi.WifiInfo getInfo() {
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

    public static String convertToQuotedString(String r2) {
        return "\"" + r2 + "\"";
    }

    public void setShowSummary(boolean r1) {
        this.showSummary = r1;
    }

    void refresh() {
        setTitle(this.ssid);
        Context r0 = getContext();
        NetworkInfo.DetailedState r1 = this.mState;
        if (r1 == null) goto L9;
        if (r1 != NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK) goto L7;
        String r2 = Summary.get(r0, NetworkInfo.DetailedState.CONNECTED);
    L15:
        setSummary(r2);
        this.showSummary = TextUtils.isEmpty(r2);
        return;
    L7:
        r2 = Summary.get(r0, this.mState);
        goto L15
    L9:
        if (this.mRssi != Integer.MAX_VALUE) goto L12;
        r2 = r0.getString(R.string.wifi_not_in_range);
        goto L15
    L12:
        if (this.mConfig == null) goto L14;
        r2 = r0.getString(R.string.wifi_remembered);
        goto L15
    L14:
        r2 = null;
        goto L15
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
