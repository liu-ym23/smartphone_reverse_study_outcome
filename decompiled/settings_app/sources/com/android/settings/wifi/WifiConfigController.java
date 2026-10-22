package com.android.settings.wifi;

import android.content.Context;
import android.content.res.Resources;
import android.net.IpConfiguration;
import android.net.LinkAddress;
import android.net.NetworkInfo;
import android.net.NetworkUtils;
import android.net.ProxyInfo;
import android.net.StaticIpConfiguration;
import android.net.Uri;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiEnterpriseConfig;
import android.os.Handler;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import com.android.net.module.util.NetUtils;
import com.android.settings.MultiSimAdapter;
import com.android.settings.ProxySelector;
import com.android.settings.R;
import com.android.settings.bluetooth.Utf8ByteLengthFilter;
import com.android.settings.utils.AndroidKeystoreAliasLoader;
import com.android.settingslib.applications.RecentAppOpsAccess;
import com.obric.olog.OLog;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes.dex */
public class WifiConfigController implements TextWatcher, AdapterView.OnItemSelectedListener, CompoundButton.OnCheckedChangeListener {
    private static final int DHCP = 0;
    private static final String KEYSTORE_SPACE = "keystore://";
    public static final int PROXY_NONE = 0;
    public static final int PROXY_PAC = 2;
    public static final int PROXY_STATIC = 1;
    private static final int SSID_NAME_MAX_LENGTH_BYTES = 32;
    private static final int STATIC_IP = 1;
    private static final String SYSTEM_CA_STORE_PATH = "/system/etc/security/cacerts";
    private static final String TAG = "WifiConfigController";
    static final String[] UNDESIRED_CERTIFICATES = null;
    private static final String UNDESIRED_CERTIFICATE_MACRANDSAPSECRET = "MacRandSapSecret";
    private static final String UNDESIRED_CERTIFICATE_MACRANDSECRET = "MacRandSecret";
    private static final int[] WAPI_PSK_TYPE_VALUES = null;
    public static final int WIFI_EAP_METHOD_AKA = 5;
    public static final int WIFI_EAP_METHOD_AKA_PRIME = 6;
    public static final int WIFI_EAP_METHOD_PEAP = 0;
    public static final int WIFI_EAP_METHOD_PWD = 3;
    public static final int WIFI_EAP_METHOD_SIM = 4;
    public static final int WIFI_EAP_METHOD_TLS = 1;
    public static final int WIFI_EAP_METHOD_TTLS = 2;
    public static final int WIFI_PEAP_PHASE2_GTC = 2;
    public static final int WIFI_PEAP_PHASE2_MSCHAPV2 = 1;
    public static final int WIFI_PEAP_PHASE2_NONE = 0;
    private static int mWepPosition;
    private final AccessPoint mAccessPoint;
    private int mAccessPointSecurity;
    private final WifiConfigUiBase mConfigUi;
    private Context mContext;
    private TextView mDns1View;
    private TextView mDns2View;
    private String mDoNotProvideEapUserCertString;
    private String mDoNotValidateEapServerString;
    private TextView mEapAnonymousView;
    private Spinner mEapCaCertSpinner;
    private TextView mEapDomainView;
    private TextView mEapIdentityView;
    private Spinner mEapMethodSpinner;
    private Spinner mEapUserCertSpinner;
    private TextView mGatewayView;
    private boolean mHasWapiAsCert;
    private boolean mHasWapiUserCert;
    private ProxyInfo mHttpProxy;
    private TextView mIpAddressView;
    private IpConfiguration.IpAssignment mIpAssignment;
    private Spinner mIpSettingsSpinner;
    private String[] mLevels;
    private int mMode;
    private String mMultipleCertSetString;
    private TextView mNetworkPrefixLengthView;
    private TextView mPasswordView;
    private ArrayAdapter<String> mPhase2Adapter;
    private final ArrayAdapter<String> mPhase2FullAdapter;
    private final ArrayAdapter<String> mPhase2PeapAdapter;
    private Spinner mPhase2Spinner;
    private TextView mProxyExclusionListView;
    private TextView mProxyHostView;
    private TextView mProxyPacView;
    private TextView mProxyPortView;
    private IpConfiguration.ProxySettings mProxySettings;
    private Spinner mProxySettingsSpinner;
    private Spinner mSecuritySpinner;
    private CheckBox mSharedCheckBox;
    private Spinner mSimCardSpinner;
    private ArrayList<String> mSimDisplayNames;
    private TextView mSsidView;
    private StaticIpConfiguration mStaticIpConfiguration;
    private SubscriptionManager mSubscriptionManager;
    private TelephonyManager mTelephonyManager;
    private final Handler mTextViewChangedHandler;
    private String mUnspecifiedCertString;
    private String mUseSystemCertsString;
    private final View mView;
    private Spinner mWapiAsCert;
    private Spinner mWapiPskType;
    private Spinner mWapiUserCert;
    private Spinner mWepKeyIndex;
    private int selectedSimCardNumber;

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> r1) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    static {
        WAPI_PSK_TYPE_VALUES = new int[]{0, 0};
        UNDESIRED_CERTIFICATES = new String[]{UNDESIRED_CERTIFICATE_MACRANDSECRET, UNDESIRED_CERTIFICATE_MACRANDSAPSECRET};
    }

    public WifiConfigController(WifiConfigUiBase r17, View r18, AccessPoint r19, int r20) {
        this.mIpAssignment = IpConfiguration.IpAssignment.UNASSIGNED;
        this.mProxySettings = IpConfiguration.ProxySettings.UNASSIGNED;
        this.mHttpProxy = null;
        this.mStaticIpConfiguration = null;
        this.mSubscriptionManager = null;
        this.mHasWapiAsCert = false;
        this.mHasWapiUserCert = false;
        this.mConfigUi = r17;
        this.mView = r18;
        this.mAccessPoint = r19;
        this.mMode = r20;
        this.mTextViewChangedHandler = new Handler();
        Context r6 = r17.getContext();
        this.mContext = r6;
        Resources r7 = r6.getResources();
        this.mTelephonyManager = (TelephonyManager) this.mContext.getSystemService(MultiSimAdapter.PHONE_KEY);
        this.mSimDisplayNames = new ArrayList();
        this.mLevels = r7.getStringArray(R.array.wifi_signal);
        ArrayAdapter<String> r8 = new ArrayAdapter(this.mContext, android.R.layout.simple_spinner_item, r7.getStringArray(R.array.wifi_peap_phase2_entries));
        this.mPhase2PeapAdapter = r8;
        r8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> r9 = new ArrayAdapter(this.mContext, android.R.layout.simple_spinner_item, r7.getStringArray(R.array.wifi_phase2_entries));
        this.mPhase2FullAdapter = r9;
        r9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.mUnspecifiedCertString = this.mContext.getString(R.string.wifi_unspecified);
        this.mMultipleCertSetString = this.mContext.getString(R.string.wifi_multiple_cert_added);
        this.mUseSystemCertsString = this.mContext.getString(R.string.wifi_use_system_certs);
        this.mDoNotProvideEapUserCertString = this.mContext.getString(R.string.wifi_do_not_provide_eap_user_cert);
        this.mDoNotValidateEapServerString = this.mContext.getString(R.string.wifi_do_not_validate_eap_server);
        Spinner r10 = (Spinner) r18.findViewById(R.id.ip_settings);
        this.mIpSettingsSpinner = r10;
        r10.setOnItemSelectedListener(this);
        Spinner r11 = (Spinner) r18.findViewById(R.id.proxy_settings);
        this.mProxySettingsSpinner = r11;
        r11.setOnItemSelectedListener(this);
        this.mSharedCheckBox = (CheckBox) r18.findViewById(R.id.shared);
        if (r19 != null) goto L5;
        r17.setTitle(R.string.wifi_add_network);
        TextView r3 = (TextView) r18.findViewById(R.id.ssid);
        this.mSsidView = r3;
        r3.setFilters(new InputFilter[]{new Utf8ByteLengthFilter(32)});
        this.mSsidView.addTextChangedListener(this);
        Spinner r4 = (Spinner) r18.findViewById(R.id.security);
        this.mSecuritySpinner = r4;
        r4.setOnItemSelectedListener(this);
        r18.findViewById(R.id.type).setVisibility(0);
        showIpConfigFields();
        showProxyFields();
        r18.findViewById(R.id.wifi_advanced_toggle).setVisibility(0);
        ((CheckBox) r18.findViewById(R.id.wifi_advanced_togglebox)).setOnCheckedChangeListener(this);
        r17.setSubmitButton(r7.getString(R.string.wifi_save));
    L83:
        r17.setCancelButton(r7.getString(R.string.wifi_cancel));
        if (r17.getSubmitButton() == null) goto L87;
        enableSubmitIfAppropriate();
        return;
    L87:
        return;
    L5:
        r17.setTitle(r19.ssid);
        ViewGroup r12 = (ViewGroup) r18.findViewById(R.id.info);
        if (r19.isSaved() == false) goto L31;
        WifiConfiguration r13 = r19.getConfig();
        if (r13.getIpConfiguration().getIpAssignment() != IpConfiguration.IpAssignment.STATIC) goto L15;
        this.mIpSettingsSpinner.setSelection(1);
        StaticIpConfiguration r14 = r13.getIpConfiguration().getStaticIpConfiguration();
        if (r14 != null) goto L12;
    L14:
        boolean r15 = true;
    L16:
        this.mSharedCheckBox.setEnabled(r13.shared);
        if (r13.shared == true) goto L20;
        r15 = true;
    L20:
        if (r13.getIpConfiguration().getProxySettings() != IpConfiguration.ProxySettings.STATIC) goto L24;
        this.mProxySettingsSpinner.setSelection(1);
    L22:
        r15 = true;
    L27:
        if (r13 == null) goto L33;
        if (r13.isPasspoint() == false) goto L33;
        addRow(r12, R.string.passpoint_label, String.format(this.mContext.getString(R.string.passpoint_content), new Object[]{r13.providerFriendlyName}));
    L33:
        if (r19.isSaved() == true) goto L35;
    L36:
        showSecurityFields();
        showIpConfigFields();
        showProxyFields();
        r18.findViewById(R.id.wifi_advanced_toggle).setVisibility(0);
        ((CheckBox) r18.findViewById(R.id.wifi_advanced_togglebox)).setOnCheckedChangeListener(this);
        if (r15 == false) goto L39;
        ((CheckBox) r18.findViewById(R.id.wifi_advanced_togglebox)).setChecked(true);
        r18.findViewById(R.id.wifi_advanced_fields).setVisibility(0);
    L39:
        int r5 = this.mMode;
        if (r5 != 2) goto L43;
        r17.setSubmitButton(r7.getString(R.string.wifi_save));
        goto L83
    L43:
        if (r5 != 1) goto L45;
        r17.setSubmitButton(r7.getString(R.string.wifi_connect));
        goto L83
    L45:
        NetworkInfo.DetailedState r16 = r19.getState();
        String r21 = getSignalString();
        if (r16 != null) goto L49;
        if (r21 == null) goto L49;
        r17.setSubmitButton(r7.getString(R.string.wifi_connect));
    L81:
        if (r19.isSaved() == false) goto L83;
        r17.setForgetButton(r7.getString(R.string.wifi_forget));
    L49:
        if (r16 == null) goto L56;
        WifiConfiguration r22 = r19.getConfig();
        if (r22 != null) goto L53;
    L55:
        addRow(r12, R.string.wifi_status, "");
        goto L56
    L53:
        if (r22.isPasspoint() == false) goto L55;
        String r23 = r22.providerFriendlyName;
    L56:
        if (r21 == null) goto L58;
        addRow(r12, R.string.wifi_signal, r21);
    L58:
        android.net.wifi.WifiInfo r24 = r19.getInfo();
        if (r24 != null) goto L61;
    L63:
        if (r24 != null) goto L65;
    L79:
        addRow(r12, R.string.wifi_security, r19.getSecurityString(false));
        r18.findViewById(R.id.ip_fields).setVisibility(8);
        goto L81
    L65:
        if (r24.getFrequency() == (-1)) goto L79;
        int r25 = r24.getFrequency();
        if (r25 < 2400) goto L72;
        if (r25 >= 2500) goto L72;
        String r26 = r7.getString(R.string.wifi_band_24ghz);
    L77:
        if (r26 == null) goto L79;
        addRow(r12, R.string.wifi_frequency, r26);
    L72:
        if (r25 >= 4900) goto L74;
    L76:
        OLog.e(TAG, "Unexpected frequency " + r25);
        r26 = null;
        goto L77
    L74:
        if (r25 >= 5900) goto L76;
        r26 = r7.getString(R.string.wifi_band_5ghz);
        goto L77
    L61:
        if (r24.getLinkSpeed() == (-1)) goto L63;
        addRow(r12, R.string.wifi_speed, String.format(r7.getString(R.string.link_speed), new Object[]{Integer.valueOf(r24.getLinkSpeed())}));
        goto L63
    L35:
        if (this.mMode == 0) goto L39;
    L24:
        if (r13.getIpConfiguration().getProxySettings() != IpConfiguration.ProxySettings.PAC) goto L26;
        this.mProxySettingsSpinner.setSelection(2);
        goto L22
    L26:
        this.mProxySettingsSpinner.setSelection(0);
        goto L27
    L12:
        if (r14.ipAddress == null) goto L14;
        addRow(r12, R.string.wifi_ip_address, r14.ipAddress.getAddress().getHostAddress());
        goto L14
    L15:
        this.mIpSettingsSpinner.setSelection(0);
        r15 = false;
        goto L16
    L31:
        r15 = false;
        goto L33
    }

    private void addRow(ViewGroup r3, int r4, String r5) {
        View r2 = this.mConfigUi.getLayoutInflater().inflate(R.layout.wifi_dialog_row, r3, false);
        ((TextView) r2.findViewById(R.id.name)).setText(r4);
        ((TextView) r2.findViewById(R.id.value)).setText(r5);
        r3.addView(r2);
    }

    private String getSignalString() {
        int r0 = this.mAccessPoint.getLevel();
        if (r0 <= (-1)) goto L7;
        String[] r2 = this.mLevels;
        if (r0 >= r2.length) goto L7;
        return r2[r0];
    L7:
        return null;
    }

    void hideForgetButton() {
        Button r1 = this.mConfigUi.getForgetButton();
        if (r1 != null) goto L5;
        return;
    L5:
        r1.setVisibility(8);
    }

    void hideSubmitButton() {
        Button r1 = this.mConfigUi.getSubmitButton();
        if (r1 != null) goto L5;
        return;
    L5:
        r1.setVisibility(8);
    }

    void enableSubmitIfAppropriate() {
        Button r0 = this.mConfigUi.getSubmitButton();
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r3 = false;
        if (this.mPasswordView != null) goto L8;
    L16:
        TextView r1 = this.mPasswordView;
        if (r1 == null) goto L29;
        if (this.mAccessPointSecurity != 4) goto L29;
        int r2 = r1.length();
        if (r2 >= 8) goto L23;
    L15:
        boolean r4 = true;
    L40:
        TextView r5 = this.mSsidView;
        if (r5 != null) goto L43;
    L44:
        AccessPoint r6 = this.mAccessPoint;
        if (r6 != null) goto L47;
    L48:
        if (r4 == false) goto L51;
    L53:
        r0.setEnabled(r3);
        return;
    L51:
        if (ipAndProxyFieldsAreValid() == false) goto L53;
        r3 = true;
        goto L53
    L47:
        if (r6.isSaved() == true) goto L51;
    L43:
        if (r5.length() == 0) goto L53;
    L23:
        if (r2 > 64) goto L15;
        if (this.mWapiPskType.getSelectedItemPosition() != 0) goto L39;
        r4 = !this.mPasswordView.getText().toString().matches("[0-9A-Fa-f]*");
    L39:
        r4 = false;
    L29:
        if (this.mAccessPointSecurity != 5) goto L34;
        Spinner r7 = this.mWapiAsCert;
        if (r7 == null) goto L34;
        if (r7.getSelectedItemPosition() == 0) goto L15;
    L34:
        Spinner r8 = this.mWapiUserCert;
        if (r8 == null) goto L39;
        if (r8.getSelectedItemPosition() != 0) goto L39;
    L8:
        if (this.mAccessPointSecurity != 1) goto L12;
        if (WepInvalid() == true) goto L15;
    L12:
        if (this.mAccessPointSecurity != 2) goto L16;
        if (this.mPasswordView.length() >= 8) goto L16;
        goto L15
    }

    private boolean WepInvalid() {
        TextView r0 = this.mPasswordView;
        if (r0 == null) goto L29;
        int r1 = r0.length();
        String r6 = this.mPasswordView.getText().toString();
        if (r1 == 10) goto L11;
        if (r1 == 26) goto L11;
        if (r1 == 32) goto L11;
    L14:
        if (r1 != 5) goto L16;
    L19:
        byte[] r7 = r6.getBytes();
        int r2 = r7.length;
        int r3 = 0;
    L20:
        if (r3 >= r2) goto L28;
        byte r4 = r7[r3];
        if (r4 < 0) goto L27;
        if (r4 > 127) goto L27;
        r3 = r3 + 1;
    L27:
        return true;
    L28:
        return false;
    L16:
        if (r1 == 13) goto L19;
        if (r1 != 16) goto L29;
    L11:
        if (r6.matches("[0-9A-Fa-f]*") == false) goto L14;
        return false;
    L29:
        return true;
    }

    void showWarningMessagesIfAppropriate() {
        this.mView.findViewById(R.id.no_ca_cert_warning).setVisibility(8);
        this.mView.findViewById(R.id.no_domain_warning).setVisibility(8);
        if (this.mEapCaCertSpinner != null) goto L5;
        return;
    L5:
        if (this.mView.findViewById(R.id.l_ca_cert).getVisibility() == 8) goto L20;
        String r0 = (String) this.mEapCaCertSpinner.getSelectedItem();
        if (r0.equals(this.mDoNotValidateEapServerString) == false) goto L10;
        this.mView.findViewById(R.id.no_ca_cert_warning).setVisibility(0);
    L10:
        if (r0.equals(this.mUseSystemCertsString) == true) goto L12;
        return;
    L12:
        if (this.mEapDomainView != null) goto L14;
        return;
    L14:
        if (this.mView.findViewById(R.id.l_domain).getVisibility() != 8) goto L16;
        return;
    L16:
        if (TextUtils.isEmpty(this.mEapDomainView.getText().toString()) == false) goto L24;
        this.mView.findViewById(R.id.no_domain_warning).setVisibility(0);
        return;
    L24:
        return;
    }

    WifiConfiguration getConfig() {
        if (this.mMode != 0) goto L5;
        return null;
    L5:
        WifiConfiguration r0 = new WifiConfiguration();
        AccessPoint r2 = this.mAccessPoint;
        if (r2 != null) goto L9;
        r0.SSID = AccessPoint.convertToQuotedString(this.mSsidView.getText().toString());
        r0.hiddenSSID = true;
    L12:
        r0.shared = this.mSharedCheckBox.isChecked();
        int r3 = this.mAccessPointSecurity;
        if (r3 != 0) goto L15;
        r0.allowedKeyManagement.set(0);
    L88:
        r0.setIpConfiguration(new IpConfiguration(this.mIpAssignment, this.mProxySettings, this.mStaticIpConfiguration, this.mHttpProxy));
        return r0;
    L15:
        if (r3 != 1) goto L17;
        r0.allowedKeyManagement.set(0);
        r0.allowedAuthAlgorithms.set(0);
        r0.allowedAuthAlgorithms.set(1);
        if (this.mPasswordView.length() == 0) goto L88;
        int r1 = this.mPasswordView.length();
        String r4 = this.mPasswordView.getText().toString();
        if (r1 == 10) goto L83;
        if (r1 == 26) goto L83;
    L85:
        r0.wepKeys[mWepPosition] = "\"" + r4 + '\"';
    L86:
        r0.wepTxKeyIndex = mWepPosition;
    L83:
        if (r4.matches("[0-9A-Fa-f]*") == false) goto L85;
        r0.wepKeys[mWepPosition] = r4;
        goto L86
    L17:
        if (r3 != 2) goto L19;
        r0.allowedKeyManagement.set(1);
        if (this.mPasswordView.length() == 0) goto L88;
        String r5 = this.mPasswordView.getText().toString();
        if (r5.matches("[0-9A-Fa-f]{64}") == false) goto L75;
        r0.preSharedKey = r5;
        goto L88
    L75:
        r0.preSharedKey = "\"" + r5 + '\"';
        goto L88
    L19:
        if (r3 == 3) goto L21;
        return null;
    L21:
        r0.allowedKeyManagement.set(2);
        r0.allowedKeyManagement.set(3);
        r0.enterpriseConfig = new WifiEnterpriseConfig();
        int r6 = this.mEapMethodSpinner.getSelectedItemPosition();
        int r7 = this.mPhase2Spinner.getSelectedItemPosition();
        r0.enterpriseConfig.setEapMethod(r6);
        if (r6 == 0) goto L30;
        if (r6 != 4) goto L25;
    L29:
        this.selectedSimCardNumber = this.mSimCardSpinner.getSelectedItemPosition() + 1;
    L37:
        String r8 = (String) this.mEapCaCertSpinner.getSelectedItem();
        r0.enterpriseConfig.setCaCertificateAliases(null);
        r0.enterpriseConfig.setCaPath(null);
        r0.enterpriseConfig.setDomainSuffixMatch(this.mEapDomainView.getText().toString());
        if (r8.equals(this.mUnspecifiedCertString) == true) goto L55;
        if (r8.equals(this.mDoNotValidateEapServerString) == true) goto L55;
        if (r8.equals(this.mUseSystemCertsString) == false) goto L46;
        r0.enterpriseConfig.setCaPath(SYSTEM_CA_STORE_PATH);
        goto L55
    L46:
        if (r8.equals(this.mMultipleCertSetString) == false) goto L53;
        AccessPoint r9 = this.mAccessPoint;
        if (r9 == null) goto L55;
        if (r9.isSaved() == true) goto L52;
        OLog.e(TAG, "Multiple certs can only be set when editing saved network");
    L52:
        r0.enterpriseConfig.setCaCertificateAliases(this.mAccessPoint.getConfig().enterpriseConfig.getCaCertificateAliases());
        goto L55
    L53:
        r0.enterpriseConfig.setCaCertificateAliases(new String[]{r8});
    L55:
        if (r0.enterpriseConfig.getCaCertificateAliases() != null) goto L57;
    L59:
        String r10 = (String) this.mEapUserCertSpinner.getSelectedItem();
        if (r10.equals(this.mUnspecifiedCertString) == false) goto L62;
    L63:
        r10 = "";
    L64:
        r0.enterpriseConfig.setClientCertificateAlias(r10);
        r0.enterpriseConfig.setIdentity(this.mEapIdentityView.getText().toString());
        r0.enterpriseConfig.setAnonymousIdentity(this.mEapAnonymousView.getText().toString());
        if (this.mPasswordView.isShown() == true) goto L67;
        r0.enterpriseConfig.setPassword(this.mPasswordView.getText().toString());
        goto L88
    L67:
        if (this.mPasswordView.length() <= 0) goto L88;
        r0.enterpriseConfig.setPassword(this.mPasswordView.getText().toString());
        goto L88
    L62:
        if (r10.equals(this.mDoNotProvideEapUserCertString) == false) goto L64;
    L57:
        if (r0.enterpriseConfig.getCaPath() == null) goto L59;
        OLog.e(TAG, "ca_cert (" + r0.enterpriseConfig.getCaCertificateAliases() + ") and ca_path (" + r0.enterpriseConfig.getCaPath() + ") should not both be non-null");
        goto L59
    L25:
        if (r6 == 5) goto L29;
        if (r6 == 6) goto L29;
        r0.enterpriseConfig.setPhase2Method(r7);
        goto L37
    L30:
        if (r7 == 0) goto L36;
        if (r7 == 1) goto L35;
        if (r7 == 2) goto L34;
        OLog.e(TAG, "Unknown phase2 method" + r7);
        goto L37
    L34:
        r0.enterpriseConfig.setPhase2Method(4);
        goto L37
    L35:
        r0.enterpriseConfig.setPhase2Method(3);
        goto L37
    L36:
        r0.enterpriseConfig.setPhase2Method(0);
        goto L37
    L9:
        if (r2.isSaved() == true) goto L11;
        r0.SSID = AccessPoint.convertToQuotedString(this.mAccessPoint.ssid);
        goto L12
    L11:
        r0.networkId = this.mAccessPoint.getConfig().networkId;
        goto L12
    }

    private boolean ipAndProxyFieldsAreValid() {
        Spinner r0 = this.mIpSettingsSpinner;
        if (r0 != null) goto L5;
    L7:
        IpConfiguration.IpAssignment r1 = IpConfiguration.IpAssignment.DHCP;
    L8:
        this.mIpAssignment = r1;
        if (r1 != IpConfiguration.IpAssignment.STATIC) goto L13;
        StaticIpConfiguration r2 = new StaticIpConfiguration();
        this.mStaticIpConfiguration = r2;
        if (validateIpConfigFields(r2) == 0) goto L13;
        return false;
    L13:
        int r3 = this.mProxySettingsSpinner.getSelectedItemPosition();
        this.mProxySettings = IpConfiguration.ProxySettings.NONE;
        this.mHttpProxy = null;
        if (r3 != 1) goto L27;
        if (this.mProxyHostView == null) goto L27;
        this.mProxySettings = IpConfiguration.ProxySettings.STATIC;
        String r4 = this.mProxyHostView.getText().toString();
        String r5 = this.mProxyPortView.getText().toString();
        String r6 = this.mProxyExclusionListView.getText().toString();
        int r7 = Integer.parseInt(r5);     // Catch: NumberFormatException -> L21
        int r8 = ProxySelector.validate(r4, r5, r6);     // Catch: NumberFormatException -> L38
    L23:
        if (r8 != 0) goto L25;
        this.mHttpProxy = new ProxyInfo(r4, r7, r6);
    L37:
        return true;
    L25:
        return false;
    L22:
        r8 = R.string.proxy_error_invalid_port;
    L21:
        r7 = 0;
    L27:
        if (r3 != 2) goto L37;
        if (this.mProxyPacView == null) goto L37;
        this.mProxySettings = IpConfiguration.ProxySettings.PAC;
        CharSequence r9 = this.mProxyPacView.getText();
        if (TextUtils.isEmpty(r9) == false) goto L33;
        return false;
    L33:
        Uri r10 = Uri.parse(r9.toString());
        if (r10 != null) goto L36;
        return false;
    L36:
        this.mHttpProxy = new ProxyInfo(r10);
        goto L37
    L5:
        if (r0.getSelectedItemPosition() != 1) goto L7;
        r1 = IpConfiguration.IpAssignment.STATIC;
        goto L8
    }

    private Inet4Address getIPv4Address(String r1) {
        return (Inet4Address) NetworkUtils.numericToInetAddress(r1);
    L4:
        return null;
    }

    private int validateIpConfigFields(StaticIpConfiguration r7) {
        TextView r0 = this.mIpAddressView;
        if (r0 != null) goto L5;
        return 0;
    L5:
        String r1 = r0.getText().toString();
        if (TextUtils.isEmpty(r1) == false) goto L8;
        return R.string.wifi_ip_settings_invalid_ip_address;
    L8:
        Inet4Address r2 = getIPv4Address(r1);
        if (r2 != null) goto L11;
    L50:
        return R.string.wifi_ip_settings_invalid_ip_address;
    L11:
        if (r2.isAnyLocalAddress() == true) goto L50;
        int r3 = -1;
        r3 = Integer.parseInt(this.mNetworkPrefixLengthView.getText().toString());     // Catch: IllegalArgumentException -> L23 NumberFormatException -> L24
        if (r3 >= 0) goto L17;
        return R.string.wifi_ip_settings_invalid_network_prefix_length;
    L17:
        if (r3 > 32) goto L56;
        r7.ipAddress = new LinkAddress(r2, r3);     // Catch: IllegalArgumentException -> L23 NumberFormatException -> L24
    L25:
        String r4 = this.mGatewayView.getText().toString();
        if (TextUtils.isEmpty(r4) == true) goto L52;
        Inet4Address r5 = getIPv4Address(r4);
        if (r5 != null) goto L33;
        return R.string.wifi_ip_settings_invalid_gateway;
    L33:
        if (r5.isMulticastAddress() == false) goto L35;
        return R.string.wifi_ip_settings_invalid_gateway;
    L35:
        r7.gateway = r5;
    L36:
        String r6 = this.mDns1View.getText().toString();
        if (TextUtils.isEmpty(r6) == false) goto L39;
        this.mDns1View.setText(this.mConfigUi.getContext().getString(R.string.wifi_dns1_hint));
    L44:
        if (this.mDns2View.length() <= 0) goto L49;
        Inet4Address r8 = getIPv4Address(this.mDns2View.getText().toString());
        if (r8 != null) goto L48;
        return R.string.wifi_ip_settings_invalid_dns;
    L48:
        r7.dnsServers.add(r8);
    L49:
        return 0;
    L39:
        Inet4Address r9 = getIPv4Address(r6);
        if (r9 != null) goto L42;
        return R.string.wifi_ip_settings_invalid_dns;
    L42:
        r7.dnsServers.add(r9);
        goto L44
    L52:
        byte[] r10 = NetUtils.getNetworkPart(r2, r3).getAddress();     // Catch: Throwable -> L51
        r10[r10.length - 1] = 1;     // Catch: Throwable -> L51
        this.mGatewayView.setText(InetAddress.getByAddress(r10).getHostAddress());     // Catch: Throwable -> L51
        goto L36
    L56:
        return R.string.wifi_ip_settings_invalid_network_prefix_length;
    L24:
        this.mNetworkPrefixLengthView.setText(this.mConfigUi.getContext().getString(R.string.wifi_network_prefix_length_hint));
    L23:
        return R.string.wifi_ip_settings_invalid_ip_address;
    }

    private void showSecurityFields() {
        if (this.mAccessPointSecurity != 0) goto L6;
        this.mView.findViewById(R.id.security_fields).setVisibility(8);
        return;
    L6:
        this.mView.findViewById(R.id.security_fields).setVisibility(0);
        if (this.mPasswordView != null) goto L14;
        TextView r0 = (TextView) this.mView.findViewById(R.id.password);
        this.mPasswordView = r0;
        r0.addTextChangedListener(this);
        ((CheckBox) this.mView.findViewById(R.id.show_password)).setOnCheckedChangeListener(this);
        AccessPoint r1 = this.mAccessPoint;
        if (r1 == null) goto L14;
        if (r1.isSaved() == false) goto L14;
        this.mPasswordView.setHint(R.string.wifi_unchanged);
    L14:
        if (this.mAccessPointSecurity != 1) goto L16;
        this.mView.findViewById(R.id.wifi_wep_password_tip).setVisibility(0);
        this.mView.findViewById(R.id.key_index).setVisibility(0);
        this.mView.findViewById(R.id.wep_key_index).setVisibility(0);
        Spinner r2 = (Spinner) this.mView.findViewById(R.id.wep_key_index);
        this.mWepKeyIndex = r2;
        r2.setOnItemSelectedListener(this);
        Context r3 = this.mConfigUi.getContext();
        ArrayAdapter r5 = new ArrayAdapter(r3, android.R.layout.simple_spinner_item, r3.getResources().getStringArray(R.array.wep_key_index));
        r5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.mWepKeyIndex.setAdapter(r5);
    L18:
        if (this.mAccessPointSecurity == 3) goto L21;
        this.mView.findViewById(R.id.eap).setVisibility(8);
        return;
    L21:
        this.mView.findViewById(R.id.eap).setVisibility(0);
        Spinner r4 = this.mEapMethodSpinner;
        if (r4 != null) goto L64;
        getSIMInfo();
        Spinner r6 = (Spinner) this.mView.findViewById(R.id.method);
        this.mEapMethodSpinner = r6;
        r6.setOnItemSelectedListener(this);
        int r7 = this.mContext.getResources().getIdentifier("config_eap_sim_based_auth_supported", "bool", RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME);
        if (com.android.settings.Utils.isWifiOnly(this.mContext) == false) goto L26;
    L27:
        ArrayAdapter r8 = new ArrayAdapter(this.mContext, android.R.layout.simple_spinner_item, this.mContext.getResources().getStringArray(R.array.eap_method_without_sim_auth));
        r8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.mEapMethodSpinner.setAdapter(r8);
    L28:
        this.mPhase2Spinner = (Spinner) this.mView.findViewById(R.id.phase2);
        Spinner r9 = (Spinner) this.mView.findViewById(R.id.ca_cert);
        this.mEapCaCertSpinner = r9;
        r9.setOnItemSelectedListener(this);
        TextView r10 = (TextView) this.mView.findViewById(R.id.domain);
        this.mEapDomainView = r10;
        r10.addTextChangedListener(this);
        Spinner r11 = (Spinner) this.mView.findViewById(R.id.user_cert);
        this.mEapUserCertSpinner = r11;
        r11.setOnItemSelectedListener(this);
        this.mSimCardSpinner = (Spinner) this.mView.findViewById(R.id.sim_card);
        this.mEapIdentityView = (TextView) this.mView.findViewById(R.id.identity);
        this.mEapAnonymousView = (TextView) this.mView.findViewById(R.id.anonymous);
        AndroidKeystoreAliasLoader r12 = getAndroidKeystoreAliasLoader();
        loadCertificates(this.mEapCaCertSpinner, r12.getCaCertAliases(), "CACERT_", this.mDoNotValidateEapServerString, false, true);
        loadCertificates(this.mEapUserCertSpinner, r12.getCaCertAliases(), "USRPKEY_", this.mDoNotProvideEapUserCertString, false, false);
        AccessPoint r13 = this.mAccessPoint;
        if (r13 != null) goto L31;
    L63:
        showEapFieldsByMethod(this.mEapMethodSpinner.getSelectedItemPosition());
        return;
    L31:
        if (r13.isSaved() == false) goto L63;
        WifiEnterpriseConfig r14 = this.mAccessPoint.getConfig().enterpriseConfig;
        int r15 = r14.getEapMethod();
        int r16 = r14.getPhase2Method();
        this.mEapMethodSpinner.setSelection(r15);
        showEapFieldsByMethod(r15);
        if (r15 == 0) goto L41;
        if (r15 != 4) goto L36;
    L40:
        this.mAccessPoint.getConfig();
    L49:
        if (TextUtils.isEmpty(r14.getCaPath()) == true) goto L51;
        setSelection(this.mEapCaCertSpinner, this.mUseSystemCertsString);
    L58:
        this.mEapDomainView.setText(r14.getDomainSuffixMatch());
        String r17 = r14.getClientCertificateAlias();
        if (TextUtils.isEmpty(r17) == false) goto L61;
        setSelection(this.mEapUserCertSpinner, this.mDoNotProvideEapUserCertString);
    L62:
        this.mEapIdentityView.setText(r14.getIdentity());
        this.mEapAnonymousView.setText(r14.getAnonymousIdentity());
        return;
    L61:
        setSelection(this.mEapUserCertSpinner, r17);
        goto L62
    L51:
        String[] r18 = r14.getCaCertificateAliases();
        if (r18 != null) goto L55;
        setSelection(this.mEapCaCertSpinner, this.mDoNotValidateEapServerString);
        goto L58
    L55:
        if (r18.length != 1) goto L57;
        setSelection(this.mEapCaCertSpinner, r18[0]);
        goto L58
    L57:
        loadCertificates(this.mEapCaCertSpinner, r12.getCaCertAliases(), "CACERT_", this.mDoNotValidateEapServerString, true, true);
        setSelection(this.mEapCaCertSpinner, this.mMultipleCertSetString);
        goto L58
    L36:
        if (r15 == 5) goto L40;
        if (r15 == 6) goto L40;
        this.mPhase2Spinner.setSelection(r16);
        goto L49
    L41:
        if (r16 == 0) goto L47;
        if (r16 == 3) goto L46;
        if (r16 == 4) goto L45;
        OLog.e(TAG, "Invalid phase 2 method " + r16);
        goto L49
    L45:
        this.mPhase2Spinner.setSelection(2);
        goto L49
    L46:
        this.mPhase2Spinner.setSelection(1);
        goto L49
    L47:
        this.mPhase2Spinner.setSelection(0);
        goto L49
    L26:
        if (this.mContext.getResources().getBoolean(r7) == true) goto L28;
    L64:
        showEapFieldsByMethod(r4.getSelectedItemPosition());
        return;
    L16:
        this.mView.findViewById(R.id.wifi_wep_password_tip).setVisibility(8);
        this.mView.findViewById(R.id.key_index).setVisibility(8);
        this.mView.findViewById(R.id.wep_key_index).setVisibility(8);
        goto L18
    }

    private void showEapFieldsByMethod(int r6) {
        this.mView.findViewById(R.id.l_method).setVisibility(0);
        this.mView.findViewById(R.id.l_identity).setVisibility(0);
        this.mView.findViewById(R.id.l_ca_cert).setVisibility(0);
        this.mView.findViewById(R.id.password_layout).setVisibility(0);
        this.mView.findViewById(R.id.show_password_layout).setVisibility(0);
        this.mConfigUi.getContext();
        switch(r6) {
            case 0: goto L12;
            case 1: goto L11;
            case 2: goto L7;
            case 3: goto L6;
            case 4: goto L5;
            case 5: goto L5;
            case 6: goto L5;
            default: goto L17;
        };
    L5:
        this.mAccessPoint.getConfig();
        Context r0 = this.mContext;
        ArrayList<String> r3 = this.mSimDisplayNames;
        ArrayAdapter r7 = new ArrayAdapter(r0, android.R.layout.simple_spinner_item, (String[]) r3.toArray(new String[r3.size()]));
        r7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.mSimCardSpinner.setAdapter(r7);
        this.mView.findViewById(R.id.l_sim_card).setVisibility(0);
        setPhase2Invisible();
        setAnonymousIdentInvisible();
        setCaCertInvisible();
        setDomainInvisible();
        setUserCertInvisible();
        setPasswordInvisible();
        setIdentityInvisible();
        goto L17
    L6:
        setPhase2Invisible();
        setCaCertInvisible();
        setDomainInvisible();
        setAnonymousIdentInvisible();
        setUserCertInvisible();
        setSimCardInvisible();
        goto L17
    L7:
        ArrayAdapter<String> r8 = this.mPhase2Adapter;
        ArrayAdapter<String> r4 = this.mPhase2FullAdapter;
        if (r8 == r4) goto L10;
        this.mPhase2Adapter = r4;
        this.mPhase2Spinner.setAdapter(r4);
    L10:
        this.mView.findViewById(R.id.l_phase2).setVisibility(0);
        this.mView.findViewById(R.id.l_anonymous).setVisibility(0);
        setUserCertInvisible();
        setSimCardInvisible();
        goto L17
    L11:
        this.mView.findViewById(R.id.l_user_cert).setVisibility(0);
        setPhase2Invisible();
        setAnonymousIdentInvisible();
        setPasswordInvisible();
        setSimCardInvisible();
        goto L17
    L12:
        ArrayAdapter<String> r9 = this.mPhase2Adapter;
        ArrayAdapter<String> r5 = this.mPhase2PeapAdapter;
        if (r9 == r5) goto L15;
        this.mPhase2Adapter = r5;
        this.mPhase2Spinner.setAdapter(r5);
    L15:
        this.mView.findViewById(R.id.l_phase2).setVisibility(0);
        this.mView.findViewById(R.id.l_anonymous).setVisibility(0);
        setUserCertInvisible();
        setSimCardInvisible();
    L17:
        if (this.mView.findViewById(R.id.l_ca_cert).getVisibility() == 8) goto L26;
        String r10 = (String) this.mEapCaCertSpinner.getSelectedItem();
        if (TextUtils.isEmpty(r10) == false) goto L21;
        return;
    L21:
        if (r10.equals(this.mDoNotValidateEapServerString) == false) goto L23;
    L24:
        setDomainInvisible();
        return;
    L23:
        if (r10.equals(this.mUnspecifiedCertString) == true) goto L24;
        return;
    }

    private void setSimCardInvisible() {
        this.mView.findViewById(R.id.l_sim_card).setVisibility(8);
    }

    private void setIdentityInvisible() {
        this.mView.findViewById(R.id.l_identity).setVisibility(8);
        this.mPhase2Spinner.setSelection(0);
    }

    private void setPhase2Invisible() {
        this.mView.findViewById(R.id.l_phase2).setVisibility(8);
        this.mPhase2Spinner.setSelection(0);
    }

    private void setCaCertInvisible() {
        this.mView.findViewById(R.id.l_ca_cert).setVisibility(8);
        setSelection(this.mEapCaCertSpinner, this.mUnspecifiedCertString);
    }

    private void setDomainInvisible() {
        this.mView.findViewById(R.id.l_domain).setVisibility(8);
        this.mEapDomainView.setText("");
    }

    private void setUserCertInvisible() {
        this.mView.findViewById(R.id.l_user_cert).setVisibility(8);
        setSelection(this.mEapUserCertSpinner, this.mUnspecifiedCertString);
    }

    private void setAnonymousIdentInvisible() {
        this.mView.findViewById(R.id.l_anonymous).setVisibility(8);
        this.mEapAnonymousView.setText("");
    }

    private void setPasswordInvisible() {
        this.mPasswordView.setText("");
        this.mView.findViewById(R.id.password_layout).setVisibility(8);
        this.mView.findViewById(R.id.show_password_layout).setVisibility(8);
    }

    private void showIpConfigFields() {
        this.mView.findViewById(R.id.ip_fields).setVisibility(0);
        AccessPoint r0 = this.mAccessPoint;
        if (r0 != null) goto L5;
    L7:
        WifiConfiguration r1 = null;
    L9:
        if (this.mIpSettingsSpinner.getSelectedItemPosition() != 1) goto L28;
        this.mView.findViewById(R.id.staticip).setVisibility(0);
        if (this.mIpAddressView != null) goto L13;
        TextView r2 = (TextView) this.mView.findViewById(R.id.ipaddress);
        this.mIpAddressView = r2;
        r2.setInputType(3);
        this.mIpAddressView.addTextChangedListener(this);
        TextView r3 = (TextView) this.mView.findViewById(R.id.gateway);
        this.mGatewayView = r3;
        r3.setInputType(3);
        this.mGatewayView.addTextChangedListener(this);
        TextView r4 = (TextView) this.mView.findViewById(R.id.network_prefix_length);
        this.mNetworkPrefixLengthView = r4;
        r4.setInputType(2);
        this.mNetworkPrefixLengthView.addTextChangedListener(this);
        TextView r5 = (TextView) this.mView.findViewById(R.id.dns1);
        this.mDns1View = r5;
        r5.setInputType(3);
        this.mDns1View.addTextChangedListener(this);
        TextView r6 = (TextView) this.mView.findViewById(R.id.dns2);
        this.mDns2View = r6;
        r6.setInputType(3);
        this.mDns2View.addTextChangedListener(this);
    L13:
        if (r1 == null) goto L30;
        StaticIpConfiguration r7 = r1.getIpConfiguration().getStaticIpConfiguration();
        if (r7 != null) goto L17;
        return;
    L17:
        if (r7.ipAddress == null) goto L20;
        this.mIpAddressView.setText(r7.ipAddress.getAddress().getHostAddress());
        this.mNetworkPrefixLengthView.setText(Integer.toString(r7.ipAddress.getNetworkPrefixLength()));
    L20:
        if (r7.gateway == null) goto L22;
        this.mGatewayView.setText(r7.gateway.getHostAddress());
    L22:
        Iterator r8 = r7.dnsServers.iterator();
        if (r8.hasNext() == false) goto L26;
        this.mDns1View.setText(((InetAddress) r8.next()).getHostAddress());
    L26:
        if (r8.hasNext() == false) goto L32;
        this.mDns2View.setText(((InetAddress) r8.next()).getHostAddress());
        return;
    L32:
        return;
    L30:
        return;
    L28:
        this.mView.findViewById(R.id.staticip).setVisibility(8);
        return;
    L5:
        if (r0.isSaved() == false) goto L7;
        r1 = this.mAccessPoint.getConfig();
        goto L9
    }

    private void showProxyFields() {
        this.mView.findViewById(R.id.proxy_settings_fields).setVisibility(0);
        AccessPoint r0 = this.mAccessPoint;
        if (r0 != null) goto L5;
    L7:
        WifiConfiguration r1 = null;
    L9:
        if (this.mProxySettingsSpinner.getSelectedItemPosition() != 1) goto L18;
        setVisibility(R.id.proxy_warning_limited_support, 0);
        setVisibility(R.id.proxy_fields, 0);
        setVisibility(R.id.proxy_pac_field, 8);
        if (this.mProxyHostView != null) goto L13;
        TextView r2 = (TextView) this.mView.findViewById(R.id.proxy_hostname);
        this.mProxyHostView = r2;
        r2.addTextChangedListener(this);
        TextView r3 = (TextView) this.mView.findViewById(R.id.proxy_port);
        this.mProxyPortView = r3;
        r3.setInputType(2);
        this.mProxyPortView.addTextChangedListener(this);
        TextView r4 = (TextView) this.mView.findViewById(R.id.proxy_exclusionlist);
        this.mProxyExclusionListView = r4;
        r4.addTextChangedListener(this);
    L13:
        if (r1 == null) goto L28;
        ProxyInfo r5 = r1.getHttpProxy();
        if (r5 == null) goto L29;
        this.mProxyHostView.setText(r5.getHost());
        this.mProxyPortView.setText(Integer.toString(r5.getPort()));
        this.mProxyExclusionListView.setText(r5.getExclusionListAsString());
        return;
    L29:
        return;
    L28:
        return;
    L18:
        if (this.mProxySettingsSpinner.getSelectedItemPosition() != 2) goto L26;
        setVisibility(R.id.proxy_warning_limited_support, 8);
        setVisibility(R.id.proxy_fields, 8);
        setVisibility(R.id.proxy_pac_field, 0);
        if (this.mProxyPacView != null) goto L22;
        TextView r6 = (TextView) this.mView.findViewById(R.id.proxy_pac);
        this.mProxyPacView = r6;
        r6.addTextChangedListener(this);
    L22:
        if (r1 == null) goto L31;
        ProxyInfo r7 = r1.getHttpProxy();
        if (r7 == null) goto L32;
        this.mProxyPacView.setText(r7.getPacFileUrl().toString());
        return;
    L32:
        return;
    L31:
        return;
    L26:
        setVisibility(R.id.proxy_warning_limited_support, 8);
        setVisibility(R.id.proxy_fields, 8);
        setVisibility(R.id.proxy_pac_field, 8);
        return;
    L5:
        if (r0.isSaved() == false) goto L7;
        r1 = this.mAccessPoint.getConfig();
        goto L9
    }

    private void setVisibility(int r1, int r2) {
        View r0 = this.mView.findViewById(r1);
        if (r0 == null) goto L6;
        r0.setVisibility(r2);
        return;
    }

    AndroidKeystoreAliasLoader getAndroidKeystoreAliasLoader() {
        return new AndroidKeystoreAliasLoader(102);
    }

    private void loadCertificates(Spinner r3, Collection<String> r4, String r5, String r6, boolean r7, boolean r8) {
        Context r9 = this.mConfigUi.getContext();
        ArrayList r0 = new ArrayList();
        r0.add(this.mUnspecifiedCertString);
        if (r7 == false) goto L5;
        r0.add(this.mMultipleCertSetString);
    L5:
        if (r8 == false) goto L7;
        r0.add(this.mUseSystemCertsString);
    L7:
        if (r4 != null) goto L9;
    L11:
        r0.add(r6);
        ArrayAdapter r2 = new ArrayAdapter(r9, android.R.layout.simple_spinner_item, (String[]) r0.toArray(new String[r0.size()]));
        r2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        r3.setAdapter(r2);
        return;
    L9:
        if (r4.size() == 0) goto L11;
        r0.addAll((Collection) r4.stream().filter(new WifiConfigController$$ExternalSyntheticLambda0()).collect(Collectors.toList()));
        goto L11
    }

    static /* synthetic */ boolean lambda$loadCertificates$0(String r5) {
        String[] r0 = UNDESIRED_CERTIFICATES;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L8;
        if (r5.startsWith(r0[r3]) == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    private void setCertificate(Spinner r2, String r3, String r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.startsWith(r3) == false) goto L8;
        setSelection(r2, r4.substring(r3.length()));
        return;
    }

    private void setSelection(Spinner r3, String r4) {
        if (r4 == null) goto L9;
        ArrayAdapter r2 = (ArrayAdapter) r3.getAdapter();
        int r0 = r2.getCount() - 1;
    L4:
        if (r0 < 0) goto L13;
        if (r4.equals(r2.getItem(r0)) == true) goto L7;
        r0 = r0 - 1;
        goto L4
    L7:
        r3.setSelection(r0);
        return;
    L13:
        return;
    }

    public int getMode() {
        return this.mMode;
    }

    public boolean isEdit() {
        if (this.mMode != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r2) {
        this.mTextViewChangedHandler.post(new AnonymousClass1(this));
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r3, boolean r4) {
        if (r3.getId() != R.id.show_password) goto L12;
        int r5 = this.mPasswordView.getSelectionEnd();
        TextView r0 = this.mPasswordView;
        if (r4 == false) goto L7;
        int r6 = 144;
    L8:
        r0.setInputType(r6 | 1);
        if (r5 < 0) goto L18;
        ((EditText) this.mPasswordView).setSelection(r5);
        return;
    L18:
        return;
    L7:
        r6 = 128;
        goto L8
    L12:
        if (r3.getId() == R.id.wifi_advanced_togglebox) goto L14;
        return;
    L14:
        if (r4 == false) goto L16;
        this.mView.findViewById(R.id.wifi_advanced_fields).setVisibility(0);
        return;
    L16:
        this.mView.findViewById(R.id.wifi_advanced_fields).setVisibility(8);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> r1, View r2, int r3, long r4) {
        if (r1 != this.mSecuritySpinner) goto L6;
        this.mAccessPointSecurity = r3;
        showSecurityFields();
    L23:
        showWarningMessagesIfAppropriate();
        enableSubmitIfAppropriate();
        return;
    L6:
        if (r1 != this.mEapMethodSpinner) goto L8;
    L22:
        showSecurityFields();
        goto L23
    L8:
        if (r1 == this.mEapCaCertSpinner) goto L22;
        if (r1 != this.mProxySettingsSpinner) goto L14;
        showProxyFields();
        goto L23
    L14:
        if (r1 != this.mWepKeyIndex) goto L17;
        mWepPosition = r3;
        goto L23
    L17:
        if (r1 == this.mWapiAsCert) goto L23;
        if (r1 == this.mWapiUserCert) goto L23;
        showIpConfigFields();
        goto L23
    }

    public void updatePassword() {
        TextView r0 = (TextView) this.mView.findViewById(R.id.password);
        if (((CheckBox) this.mView.findViewById(R.id.show_password)).isChecked() == false) goto L5;
        int r2 = 144;
    L6:
        r0.setInputType(r2 | 1);
        return;
    L5:
        r2 = 128;
        goto L6
    }

    public AccessPoint getAccessPoint() {
        return this.mAccessPoint;
    }

    private void getSIMInfo() {
        this.mSubscriptionManager = SubscriptionManager.from(this.mContext);
        int r1 = 0;
    L4:
        if (r1 >= this.mTelephonyManager.getSimCount()) goto L10;
        SubscriptionInfo r2 = this.mSubscriptionManager.getActiveSubscriptionInfoForSimSlotIndex(r1);
        if (r2 == null) goto L8;
        String r3 = String.valueOf(r2.getDisplayName());
    L9:
        this.mSimDisplayNames.add(r3);
        r1 = r1 + 1;
        goto L4
    L8:
        r3 = this.mContext.getString(R.string.sim_editor_title, new Object[]{Integer.valueOf(r1 + 1)});
        goto L9
    }
}
