package com.android.settings.wifi;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiEnterpriseConfig;
import android.net.wifi.WifiKeystore;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.WindowInsets;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import bytedanceos.util.Features;
import com.android.settings.MultiSimAdapter;
import com.android.settings.R;
import com.android.settings.ToastUtils;
import com.android.settings.applications.utils.Item;
import com.android.settings.applications.utils.OPopoverHelper;
import com.android.settings.bluetooth.Utf8ByteLengthFilter;
import com.android.settings.utils.AndroidKeystoreAliasLoader;
import com.android.settings.utils.NullSafe;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.selection.OSelectionPanelView;
import com.obric.oui.selection.OSingleSelectionPanelView;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.titlebar.OCTitleBar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: loaded from: classes.dex */
public class WifiConfigControllerForSetup implements TextWatcher, View.OnClickListener {
    private static final String KEYSTORE_SPACE = "keystore://";
    public static final int PROXY_NONE = 0;
    public static final int PROXY_STATIC = 1;
    private static final int SSID_NAME_MAX_LENGTH_BYTES = 32;
    private static final String SYSTEM_CA_STORE_PATH = "/system/etc/security/cacerts";
    private static final String TAG = "WifiConfigControllerForSetup";
    static final String[] UNDESIRED_CERTIFICATES = null;
    private static final String UNDESIRED_CERTIFICATE_MACRANDSAPSECRET = "MacRandSapSecret";
    private static final String UNDESIRED_CERTIFICATE_MACRANDSECRET = "MacRandSecret";
    public static final int WAPI_ASCII_PASSWORD = 0;
    public static final int WAPI_HEX_PASSWORD = 1;
    private static final int[] WAPI_PSK_TYPE_VALUES = null;
    public static final String WAPI_USER_CERTIFICATE = "WAPI_USER_";
    public static final int WIFI_EAP_METHOD_AKA = 5;
    public static final int WIFI_EAP_METHOD_AKA_PRIME = 6;
    private static final int WIFI_EAP_METHOD_FOR_CMCC = 7;
    public static final int WIFI_EAP_METHOD_PEAP = 0;
    public static final int WIFI_EAP_METHOD_PWD = 3;
    public static final int WIFI_EAP_METHOD_SIM = 4;
    public static final int WIFI_EAP_METHOD_TLS = 1;
    public static final int WIFI_EAP_METHOD_TTLS = 2;
    public static final int WIFI_PEAP_PHASE2_GTC = 1;
    public static final int WIFI_PEAP_PHASE2_MSCHAPV2 = 0;
    private final String[] EAP_METHOD_VALUES;
    private final ArrayAdapter<String> PHASE2_FULL_ADAPTER;
    private final String[] PHASE2_FULL_VALUES;
    private final ArrayAdapter<String> PHASE2_PEAP_ADAPTER;
    private final String[] PHASE2_PEAP_VALUES;
    private final String[] WAPI_PSK_VALUES;
    private final String[] WEP_KEY_INDEX;
    private final String[] WIFI_SECURITY_VALUES;
    private final Context context;
    private final AccessPoint mAccessPoint;
    private int mAccessPointSecurity;
    private String[] mAsCerts;
    private final WifiSetupFragment mConfigUi;
    private String mDoNotProvideEapUserCertString;
    private String mDoNotValidateEapServerString;
    private OInputLayout mDomainInputLayout;
    private OEditText mEapAnonymousView;
    private int mEapCaCert;
    private OInsetSheet mEapCaCertIndexChooser;
    private OCardListItem mEapCaCertItem;
    private String[] mEapCaCerts;
    private OEditText mEapDomainView;
    private OEditText mEapIdentityView;
    private OInsetSheet mEapIndexChooser;
    private LinearLayout mEapLinearLayoutIdentityView;
    private int mEapMethod;
    private OCardListItem mEapMethodItem;
    private int mEapUserCert;
    private OInsetSheet mEapUserCertIndexChooser;
    private OCardListItem mEapUserCertItem;
    private String[] mEapUserCerts;
    private boolean mEdit;
    private boolean mHaveWapiCert;
    private boolean mIsTrustOnFirstUseSupported;
    private String mMultipleCertSetString;
    private OEditText mPasswordView;
    private ArrayAdapter<String> mPhase2Adapter;
    private OInsetSheet mPhase2IndexChooser;
    private OCardListItem mPhase2Item;
    private int mPhase2Method;
    private OCardListItem mPrivacy;
    private OInsetSheet mSecurityChooser;
    private boolean mSelectEapCaCertManual;
    private int mSelectPrivacyLevel;
    private int mSimCardIndex;
    private OInsetSheet mSimCardIndexChooser;
    private OCardListItem mSimCardItem;
    private String[] mSimDisplayNames;
    private OEditText mSsidView;
    private boolean mSubmitEnabled;
    private SubscriptionManager mSubscriptionManager;
    private TelephonyManager mTelephonyManager;
    private final Handler mTextViewChangedHandler;
    private String mTrustOnFirstUse;
    private String mUseSystemCertsString;
    private String[] mUserCerts;
    private final View mView;
    private int mWapiAsCert;
    private OInsetSheet mWapiAsCertIndexChooser;
    private ArrayList<String> mWapiCertList;
    private OInsetSheet mWapiPskIndexChooser;
    private int mWapiPskType;
    private int mWapiUserCert;
    private OInsetSheet mWapiUserCertIndexChooser;
    private OInsetSheet mWepIndexChooser;
    private int mWepPosition;
    private boolean multiWlan;
    private OCardListItem passwordContainer;
    private OPopover popover;
    private String unspecifiedCert;

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    static /* synthetic */ void access$000(WifiConfigControllerForSetup r0) {
        r0.launchAdvancedOptions();
    }

    static /* synthetic */ Context access$100(WifiConfigControllerForSetup r0) {
        return r0.context;
    }

    static /* synthetic */ ArrayList access$1000(WifiConfigControllerForSetup r0) {
        return r0.mWapiCertList;
    }

    static /* synthetic */ int access$1100(WifiConfigControllerForSetup r0) {
        return r0.mEapUserCert;
    }

    static /* synthetic */ int access$1102(WifiConfigControllerForSetup r0, int r1) {
        r0.mEapUserCert = r1;
        return r1;
    }

    static /* synthetic */ String[] access$1200(WifiConfigControllerForSetup r0) {
        return r0.mEapUserCerts;
    }

    static /* synthetic */ void access$1300(WifiConfigControllerForSetup r0) {
        r0.showSecurityFields();
    }

    static /* synthetic */ int access$1400(WifiConfigControllerForSetup r0) {
        return r0.mSimCardIndex;
    }

    static /* synthetic */ int access$1402(WifiConfigControllerForSetup r0, int r1) {
        r0.mSimCardIndex = r1;
        return r1;
    }

    static /* synthetic */ String[] access$1500(WifiConfigControllerForSetup r0) {
        return r0.mSimDisplayNames;
    }

    static /* synthetic */ int access$1600(WifiConfigControllerForSetup r0) {
        return r0.mWapiUserCert;
    }

    static /* synthetic */ int access$1602(WifiConfigControllerForSetup r0, int r1) {
        r0.mWapiUserCert = r1;
        return r1;
    }

    static /* synthetic */ int access$1700(WifiConfigControllerForSetup r0) {
        return r0.mEapCaCert;
    }

    static /* synthetic */ int access$1702(WifiConfigControllerForSetup r0, int r1) {
        r0.mEapCaCert = r1;
        return r1;
    }

    static /* synthetic */ boolean access$1802(WifiConfigControllerForSetup r0, boolean r1) {
        r0.mSelectEapCaCertManual = r1;
        return r1;
    }

    static /* synthetic */ String[] access$1900(WifiConfigControllerForSetup r0) {
        return r0.mEapCaCerts;
    }

    static /* synthetic */ View access$200(WifiConfigControllerForSetup r0) {
        return r0.mView;
    }

    static /* synthetic */ void access$2000(WifiConfigControllerForSetup r0, String r1) {
        r0.setEapCaCertSubtile(r1);
    }

    static /* synthetic */ int access$2100(WifiConfigControllerForSetup r0) {
        return r0.mPhase2Method;
    }

    static /* synthetic */ int access$2102(WifiConfigControllerForSetup r0, int r1) {
        r0.mPhase2Method = r1;
        return r1;
    }

    static /* synthetic */ int access$2200(WifiConfigControllerForSetup r0) {
        return r0.mEapMethod;
    }

    static /* synthetic */ int access$2202(WifiConfigControllerForSetup r0, int r1) {
        r0.mEapMethod = r1;
        return r1;
    }

    static /* synthetic */ String[] access$2300(WifiConfigControllerForSetup r0) {
        return r0.PHASE2_PEAP_VALUES;
    }

    static /* synthetic */ String[] access$2400(WifiConfigControllerForSetup r0) {
        return r0.PHASE2_FULL_VALUES;
    }

    static /* synthetic */ String[] access$2500(WifiConfigControllerForSetup r0) {
        return r0.EAP_METHOD_VALUES;
    }

    static /* synthetic */ int access$2600(WifiConfigControllerForSetup r0) {
        return r0.mWapiPskType;
    }

    static /* synthetic */ int access$2602(WifiConfigControllerForSetup r0, int r1) {
        r0.mWapiPskType = r1;
        return r1;
    }

    static /* synthetic */ String[] access$2700(WifiConfigControllerForSetup r0) {
        return r0.WAPI_PSK_VALUES;
    }

    static /* synthetic */ int access$2800(WifiConfigControllerForSetup r0) {
        return r0.mWepPosition;
    }

    static /* synthetic */ int access$2802(WifiConfigControllerForSetup r0, int r1) {
        r0.mWepPosition = r1;
        return r1;
    }

    static /* synthetic */ String[] access$2900(WifiConfigControllerForSetup r0) {
        return r0.WEP_KEY_INDEX;
    }

    static /* synthetic */ void access$300(WifiConfigControllerForSetup r0) {
        r0.showSelectMacDialog();
    }

    static /* synthetic */ int access$3000(WifiConfigControllerForSetup r0) {
        return r0.mAccessPointSecurity;
    }

    static /* synthetic */ int access$3002(WifiConfigControllerForSetup r0, int r1) {
        r0.mAccessPointSecurity = r1;
        return r1;
    }

    static /* synthetic */ String[] access$3100(WifiConfigControllerForSetup r0) {
        return r0.WIFI_SECURITY_VALUES;
    }

    static /* synthetic */ int access$400(WifiConfigControllerForSetup r0) {
        return r0.mSelectPrivacyLevel;
    }

    static /* synthetic */ int access$402(WifiConfigControllerForSetup r0, int r1) {
        r0.mSelectPrivacyLevel = r1;
        return r1;
    }

    static /* synthetic */ void access$500(WifiConfigControllerForSetup r0, int r1) {
        r0.updatePrivacy(r1);
    }

    static /* synthetic */ OPopover access$600(WifiConfigControllerForSetup r0) {
        return r0.popover;
    }

    static /* synthetic */ boolean access$700(WifiConfigControllerForSetup r0) {
        return r0.mSubmitEnabled;
    }

    static /* synthetic */ WifiSetupFragment access$800(WifiConfigControllerForSetup r0) {
        return r0.mConfigUi;
    }

    static /* synthetic */ int access$900(WifiConfigControllerForSetup r0) {
        return r0.mWapiAsCert;
    }

    static /* synthetic */ int access$902(WifiConfigControllerForSetup r0, int r1) {
        r0.mWapiAsCert = r1;
        return r1;
    }

    static {
        WAPI_PSK_TYPE_VALUES = new int[]{0, 1};
        UNDESIRED_CERTIFICATES = new String[]{UNDESIRED_CERTIFICATE_MACRANDSECRET, UNDESIRED_CERTIFICATE_MACRANDSAPSECRET};
    }

    public WifiConfigControllerForSetup(WifiSetupFragment r9, View r10, AccessPoint r11, boolean r12, boolean r13, boolean r14) {
        this.unspecifiedCert = "unspecified";
        int r0 = 0;
        this.mSelectPrivacyLevel = 0;
        this.mSubscriptionManager = null;
        this.mSelectEapCaCertManual = false;
        this.mHaveWapiCert = false;
        this.mSubmitEnabled = false;
        this.mConfigUi = r9;
        this.mView = r10;
        this.mAccessPoint = r11;
        if (r11 != null) goto L5;
        int r1 = 0;
    L6:
        this.mAccessPointSecurity = r1;
        this.mEdit = r12;
        this.multiWlan = r14;
        this.mTextViewChangedHandler = new Handler();
        Context r15 = r9.getContext();
        this.context = r15;
        Resources r2 = r15.getResources();
        this.mTelephonyManager = (TelephonyManager) r15.getSystemService(MultiSimAdapter.PHONE_KEY);
        String[] r3 = r2.getStringArray(R.array.wifi_security);
        this.WIFI_SECURITY_VALUES = r3;
        this.WEP_KEY_INDEX = r2.getStringArray(R.array.wep_key_index);
        this.WAPI_PSK_VALUES = r2.getStringArray(R.array.wifi_wapi_psk_type);
        this.EAP_METHOD_VALUES = r2.getStringArray(R.array.wifi_eap_method);
        String[] r4 = r2.getStringArray(R.array.wifi_peap_phase2_entries);
        this.PHASE2_PEAP_VALUES = r4;
        this.PHASE2_PEAP_ADAPTER = new ArrayAdapter(r15, R.layout.wifi_setup_list_item_single_choice, r4);
        String[] r5 = r2.getStringArray(R.array.wifi_phase2_entries);
        this.PHASE2_FULL_VALUES = r5;
        this.PHASE2_FULL_ADAPTER = new ArrayAdapter(r15, R.layout.wifi_setup_list_item_single_choice, r5);
        this.unspecifiedCert = r15.getString(R.string.wifi_unspecified);
        this.mMultipleCertSetString = r15.getString(R.string.wifi_multiple_cert_added);
        this.mUseSystemCertsString = r15.getString(R.string.wifi_use_system_certs);
        this.mDoNotProvideEapUserCertString = r15.getString(R.string.wifi_do_not_provide_eap_user_cert);
        this.mDoNotValidateEapServerString = r15.getString(R.string.wifi_do_not_validate_eap_server);
        this.mTrustOnFirstUse = r15.getString(R.string.wifi_trust_on_first_use);
        this.mIsTrustOnFirstUseSupported = ((WifiManager) r15.getSystemService(WifiManager.class)).isTrustOnFirstUseSupported();
        OCardListItem r6 = (OCardListItem) NullSafe.nonNull(r10.findViewById(R.id.password));
        this.passwordContainer = r6;
        if (r11 != null) goto L13;
        OInputLayout r7 = (OInputLayout) r6.getCustomStartView();
        r7.setLabel(r15.getString(R.string.apn_password));
        r7.setHint(r15.getString(R.string.wapi_password_empty));
        r7.showLabel(true);
        r9.setTitle(r15.getString(R.string.wifi_add_network));
        OCardListItem r8 = (OCardListItem) NullSafe.nonNull(r10.findViewById(R.id.ssid));
        OInputLayout r16 = (OInputLayout) r8.getCustomStartView();
        r16.setLabel(r15.getString(R.string.wifi_ssid));
        r16.setHint(r15.getString(R.string.please_input_network_name));
        r16.showLabel(true);
        OEditText r17 = ((OInputLayout) r8.getCustomStartView()).getVInput();
        this.mSsidView = r17;
        r17.setFilters(new InputFilter[]{new Utf8ByteLengthFilter(32)});
        this.mSsidView.addTextChangedListener(this);
        if (r13 == true) goto L11;
        this.mSsidView.setMovementMethod(ScrollingMovementMethod.getInstance());
    L11:
        final OCardListItem r18 = (OCardListItem) NullSafe.nonNull(r10.findViewById(R.id.security));
        r18.setOnContentClickListener(new WifiConfigControllerForSetup$$ExternalSyntheticLambda9(this, r18));
        r18.setEndDetailText(r3[this.mAccessPointSecurity]);
        NullSafe.nonNull(r10.findViewById(R.id.type)).setVisibility(0);
        ((OCardListItem) NullSafe.nonNull(r10.findViewById(R.id.wifi_advanced_togglebox))).setOnContentClickListener(new AnonymousClass1(this));
        r9.setSubmitButton(r15.getString(R.string.wifi_connect));
    L24:
        OCardListItem r19 = (OCardListItem) r10.findViewById(R.id.privacy);
        this.mPrivacy = r19;
        r19.setOnContentClickListener(new AnonymousClass3(this));
        this.mPrivacy.setEndDetailText(r15.getString(R.string.wifi_use_randomized_mac));
        if (r9.getSubmitButton() == null) goto L27;
        showWarningMessagesIfAppropriate();
        enableSubmitIfAppropriate();
    L27:
        if (r14 == false) goto L29;
        ((OCardListItem) NullSafe.nonNull(r10.findViewById(R.id.wifi_advanced_togglebox))).setVisibility(8);
        this.mPrivacy.setVisibility(8);
    L29:
        if (r11 != null) goto L31;
    L36:
        showSoftKeyguard(r15);
        return;
    L31:
        if (r11.security != 5) goto L36;
        if (r10 != null) goto L34;
        return;
    L34:
        if (r10.getWindowInsetsController() == null) goto L39;
        r10.getWindowInsetsController().hide(WindowInsets.Type.ime());
        return;
    L39:
        return;
    L13:
        if (r11.security != 3) goto L15;
        r0 = 3;
    L15:
        r6.setCardPosition(r0);
        r9.setTitle(r11.ssid);
        ((OInputLayout) this.passwordContainer.getCustomStartView()).setHint(r15.getString(R.string.security_enter_password));
        r11.getState();
        r11.getLevel();
        if (r11.networkId != (-1)) goto L18;
    L19:
        showSecurityFields();
        ((OCardListItem) NullSafe.nonNull(r10.findViewById(R.id.wifi_advanced_togglebox))).setOnContentClickListener(new AnonymousClass2(this));
    L21:
        if (this.mEdit == false) goto L23;
        r9.setSubmitButton(r15.getString(R.string.wifi_save));
        goto L24
    L23:
        r9.setSubmitButton(r15.getString(R.string.wifi_connect));
        goto L24
    L18:
        if (this.mEdit == false) goto L21;
    L5:
        r1 = r11.security;
        goto L6
    }

    /* JADX INFO: renamed from: lambda$new$0$com-android-settings-wifi-WifiConfigControllerForSetup, reason: not valid java name */
    /* synthetic */ void m685x8b11b5d4(OCardListItem r1, View r2) {
        handleClickSecurity(r1);
    }

    private void showSelectMacDialog() {
        ArrayList r0 = new ArrayList();
        r0.add(new Item(this.context.getString(R.string.wifi_use_randomized_mac), false, null));
        r0.add(new Item(this.context.getString(R.string.wifi_use_device_mac), false, null));
        ((Item) r0.get(this.mSelectPrivacyLevel)).setSelect(true);
        this.popover = OPopoverHelper.showPopoverList((Activity) this.context, this.mPrivacy, r0, new AnonymousClass4(this), true);
    }

    private void updatePrivacy(int r2) {
        if (r2 != 0) goto L4;
        this.mPrivacy.setEndDetailText(this.context.getString(R.string.wifi_use_randomized_mac));
        return;
    L4:
        this.mPrivacy.setEndDetailText(this.context.getString(R.string.wifi_use_device_mac));
    }

    boolean isValidSaePassword(String r2) {
        if (r2.length() >= 1) goto L5;
        return false;
    L5:
        if (r2.length() > 63) goto L9;
        return true;
    L9:
        return false;
    }

    void enableSubmitIfAppropriate() {
        View r0 = this.mConfigUi.getSubmitButton();
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r1 = false;
        boolean r5 = true;
        if (this.mPasswordView != null) goto L9;
    L17:
        OEditText r2 = this.mPasswordView;     // Catch: Exception -> L81
        if (r2 == null) goto L34;
        if (this.mAccessPointSecurity != 4) goto L34;
        int r3 = r2.length();     // Catch: Exception -> L81
        if (r3 >= 8) goto L24;
    L16:
        boolean r4 = true;
    L46:
        OEditText r6 = this.mSsidView;     // Catch: Exception -> L81
        if (r6 != null) goto L49;
    L50:
        AccessPoint r7 = this.mAccessPoint;     // Catch: Exception -> L81
        if (r7 == null) goto L55;
        if (r7.networkId == (-1)) goto L55;
    L87:
    L79:
        e = e;
        r1 = r5;
    L82:
        OLog.e(TAG, "enableSubmit: error: " + e.getMessage());
    L83:
        this.mSubmitEnabled = r1;
        r0.setEnabled(r1);
        return;
    L58:
        if (this.mEapCaCertItem == null) goto L72;
        if (NullSafe.nonNull(this.mView.findViewById(R.id.ca_cert_container)).getVisibility() == 8) goto L72;
        if (this.unspecifiedCert.equals(this.mEapCaCerts[this.mEapCaCert]) == false) goto L65;
        r5 = false;
    L65:
        if (this.mEapDomainView == null) goto L72;
        if (NullSafe.nonNull(this.mView.findViewById(R.id.l_domain)).getVisibility() == 8) goto L72;
        if (TextUtils.isEmpty(this.mEapDomainView.getText().toString()) == false) goto L72;
        r5 = false;
    L72:
        if (this.mEapUserCertItem != null) goto L74;
    L78:
        r1 = r5;
        goto L83
    L74:
        if (NullSafe.nonNull(this.mView.findViewById(R.id.user_cert_container)).getVisibility() == 8) goto L78;
        if (this.unspecifiedCert.equals(this.mEapUserCerts[this.mEapUserCert]) == false) goto L78;
    L55:
        if (r4 == false) goto L87;
    L56:
        r5 = false;
        goto L87
    L49:
        if (r6.length() == 0) goto L56;
    L24:
        if (r3 > 64) goto L16;
        if (this.mWapiPskType != 1) goto L45;
        String r8 = this.mPasswordView.getText().toString();     // Catch: Exception -> L81
        if ((this.mPasswordView.length() % 2) != 0) goto L16;
        if (r8.matches("[0-9A-Fa-f]*") == false) goto L16;
    L45:
        r4 = false;
    L34:
        if (this.mAccessPointSecurity != 5) goto L41;
        ArrayList<String> r9 = this.mWapiCertList;     // Catch: Exception -> L81
        if (r9 == null) goto L16;
        if (r9.size() <= 1) goto L16;
    L41:
        if (this.mAccessPointSecurity != 6) goto L45;
        if (isValidSaePassword(this.mPasswordView.getText().toString()) == true) goto L45;
    L9:
        if (this.mAccessPointSecurity != 1) goto L13;
        if (WepInvalid() == true) goto L16;
    L13:
        if (this.mAccessPointSecurity != 2) goto L17;
        if (this.mPasswordView.length() >= 8) goto L17;
    L81:
        e = e;
        goto L82
    }

    void showWarningMessagesIfAppropriate() {
        NullSafe.nonNull(this.mView.findViewById(R.id.no_ca_cert_warning)).setVisibility(8);
        OInputLayout r0 = this.mDomainInputLayout;
        if (r0 == null) goto L6;
        r0.showTip(false);
    L6:
        if (this.mEapCaCertItem != null) goto L8;
        return;
    L8:
        if (NullSafe.nonNull(this.mView.findViewById(R.id.ca_cert_container)).getVisibility() == 8) goto L23;
        String r1 = this.mEapCaCerts[this.mEapCaCert];
        if (this.mDoNotValidateEapServerString.equals(r1) == false) goto L13;
        NullSafe.nonNull(this.mView.findViewById(R.id.no_ca_cert_warning)).setVisibility(0);
    L13:
        if (this.mEapDomainView != null) goto L15;
        return;
    L15:
        if (NullSafe.nonNull(this.mView.findViewById(R.id.l_domain)).getVisibility() != 8) goto L17;
        return;
    L17:
        if (TextUtils.isEmpty(this.mEapDomainView.getText().toString()) == false) goto L26;
        OInputLayout r5 = this.mDomainInputLayout;
        if (r5 == null) goto L27;
        r5.showTip(true);
        return;
    L27:
        return;
    L26:
        return;
    }

    private boolean WepInvalid() {
        OEditText r0 = this.mPasswordView;
        if (r0 == null) goto L27;
        int r1 = r0.length();
        String r6 = this.mPasswordView.getText().toString();
        if (r1 == 10) goto L9;
        if (r1 == 26) goto L9;
    L12:
        if (r1 != 5) goto L14;
    L17:
        byte[] r7 = r6.getBytes();
        int r2 = r7.length;
        int r3 = 0;
    L18:
        if (r3 >= r2) goto L26;
        byte r4 = r7[r3];
        if (r4 < 0) goto L25;
        if (r4 > 127) goto L25;
        r3 = r3 + 1;
    L25:
        return true;
    L26:
        return false;
    L14:
        if (r1 == 13) goto L17;
        if (r1 != 16) goto L27;
    L9:
        if (r6.matches("[0-9A-Fa-f]*") == false) goto L12;
        return false;
    L27:
        return true;
    }

    WifiConfiguration getConfig() {
        AccessPoint r0 = this.mAccessPoint;
        if (r0 != null) goto L5;
    L10:
        WifiConfiguration r1 = new WifiConfiguration();
        AccessPoint r4 = this.mAccessPoint;
        int r5 = 1;
        if (r4 != null) goto L14;
        r1.SSID = AccessPoint.convertToQuotedString(this.mSsidView.getText().toString());
        r1.hiddenSSID = true;
    L20:
        switch(this.mAccessPointSecurity) {
            case 0: goto L111;
            case 1: goto L100;
            case 2: goto L94;
            case 3: goto L36;
            case 4: goto L30;
            case 5: goto L26;
            case 6: goto L23;
            default: goto L21;
        };
    L21:
        OLog.e(TAG, "Unknown security type " + this.mAccessPointSecurity);
        return null;
    L23:
        r1.setSecurityParams(4);
        if (this.mPasswordView.length() == 0) goto L113;
        r1.preSharedKey = "\"" + this.mPasswordView.getText().toString() + '\"';
    L113:
        if (this.mConfigUi.mConfig == null) goto L116;
        r1.setIpConfiguration(this.mConfigUi.mConfig.getIpConfiguration());
    L116:
        if (this.mSelectPrivacyLevel == 0) goto L119;
        r5 = 0;
    L119:
        r1.macRandomizationSetting = r5;
        return r1;
    L26:
        r1.allowedProtocols.set(3);
        r1.allowedKeyManagement.set(14);
        r1.enterpriseConfig.setEapMethod(8);
        if (this.mWapiUserCert != 0) goto L29;
        r1.enterpriseConfig.setWapiCertSuite(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
        goto L113
    L29:
        r1.enterpriseConfig.setWapiCertSuite(this.mWapiCertList.get(this.mWapiUserCert));
        goto L113
    L30:
        r1.allowedProtocols.set(3);
        r1.allowedKeyManagement.set(13);
        if (this.mPasswordView.length() == 0) goto L113;
        String r2 = this.mPasswordView.getText().toString();
        if (this.mWapiPskType != 1) goto L35;
        r1.preSharedKey = r2;
        goto L113
    L35:
        r1.preSharedKey = "\"" + r2 + '\"';
        goto L113
    L36:
        r1.allowedKeyManagement.set(2);
        r1.allowedKeyManagement.set(3);
        r1.enterpriseConfig = new WifiEnterpriseConfig();
        int r3 = this.mEapMethod;
        int r6 = this.mPhase2Method;
        r1.enterpriseConfig.setEapMethod(r3);
        if (r3 == 0) goto L42;
        if (r3 == 4) goto L47;
        if (r3 == 5) goto L47;
        if (r3 == 6) goto L47;
        r1.enterpriseConfig.setPhase2Method(r6 + 1);
    L47:
        String r7 = this.mEapCaCerts[this.mEapCaCert];
        r1.enterpriseConfig.setCaCertificateAliases(null);
        r1.enterpriseConfig.setCaPath(null);
        r1.enterpriseConfig.setDomainSuffixMatch(this.mEapDomainView.getText().toString());
        if (r7.equals(this.unspecifiedCert) == true) goto L70;
        if (r7.equals(this.mDoNotValidateEapServerString) == true) goto L70;
        if (r7.equals(this.mUseSystemCertsString) == false) goto L56;
        r1.enterpriseConfig.setCaPath(SYSTEM_CA_STORE_PATH);
        goto L70
    L56:
        if (r7.equals(this.mTrustOnFirstUse) == false) goto L61;
        if (this.mIsTrustOnFirstUseSupported == false) goto L61;
        r1.enterpriseConfig.enableTrustOnFirstUse(true);
    L61:
        if (r7.equals(this.mMultipleCertSetString) == false) goto L68;
        AccessPoint r8 = this.mAccessPoint;
        if (r8 == null) goto L70;
        if (r8.isSaved() == true) goto L67;
        OLog.e(TAG, "Multiple certs can only be set when editing saved network");
    L67:
        r1.enterpriseConfig.setCaCertificateAliases(this.mAccessPoint.getConfig().enterpriseConfig.getCaCertificateAliases());
        goto L70
    L68:
        r1.enterpriseConfig.setCaCertificateAliases(new String[]{r7});
    L70:
        if (r1.enterpriseConfig.getCaCertificateAliases() != null) goto L72;
    L74:
        String r9 = this.mEapUserCerts[this.mEapUserCert];
        if (r9.equals(this.unspecifiedCert) == false) goto L77;
    L78:
        r9 = "";
    L79:
        r1.enterpriseConfig.setClientCertificateAlias(r9);
        if (r3 == 4) goto L87;
        if (r3 == 5) goto L87;
        if (r3 == 6) goto L87;
        if (r3 != 3) goto L86;
        r1.enterpriseConfig.setIdentity(this.mEapIdentityView.getText().toString());
        r1.enterpriseConfig.setAnonymousIdentity("");
    L89:
        if (this.mPasswordView.isShown() == true) goto L91;
        r1.enterpriseConfig.setPassword(this.mPasswordView.getText().toString());
        goto L113
    L91:
        if (this.mPasswordView.length() <= 0) goto L113;
        r1.enterpriseConfig.setPassword(this.mPasswordView.getText().toString());
        goto L113
    L86:
        r1.enterpriseConfig.setIdentity(this.mEapIdentityView.getText().toString());
        r1.enterpriseConfig.setAnonymousIdentity(this.mEapAnonymousView.getText().toString());
    L87:
        r1.enterpriseConfig.setIdentity("");
        r1.enterpriseConfig.setAnonymousIdentity("");
        goto L89
    L77:
        if (r9.equals(this.mDoNotProvideEapUserCertString) == false) goto L79;
    L72:
        if (r1.enterpriseConfig.getCaPath() == null) goto L74;
        OLog.e(TAG, "ca_cert (" + r1.enterpriseConfig.getCaCertificateAliases() + ") and ca_path (" + r1.enterpriseConfig.getCaPath() + ") should not both be non-null");
        goto L74
    L42:
        if (r6 == 0) goto L46;
        if (r6 == 1) goto L45;
        OLog.e(TAG, "Unknown phase2 method" + r6);
        goto L47
    L45:
        r1.enterpriseConfig.setPhase2Method(4);
        goto L47
    L46:
        r1.enterpriseConfig.setPhase2Method(3);
        goto L47
    L94:
        r1.allowedKeyManagement.set(1);
        if (this.mPasswordView.length() == 0) goto L113;
        String r10 = this.mPasswordView.getText().toString();
        if (r10.matches("[0-9A-Fa-f]{64}") == false) goto L99;
        r1.preSharedKey = r10;
        goto L113
    L99:
        r1.preSharedKey = "\"" + r10 + '\"';
        goto L113
    L100:
        r1.allowedKeyManagement.set(0);
        r1.allowedAuthAlgorithms.set(0);
        r1.allowedAuthAlgorithms.set(1);
        if (this.mPasswordView.length() == 0) goto L113;
        int r11 = this.mPasswordView.length();
        String r12 = this.mPasswordView.getText().toString();
        if (r11 == 10) goto L107;
        if (r11 == 26) goto L107;
    L109:
        r1.wepKeys[this.mWepPosition] = "\"" + r12 + '\"';
    L110:
        r1.wepTxKeyIndex = this.mWepPosition;
    L107:
        if (r12.matches("[0-9A-Fa-f]*") == false) goto L109;
        r1.wepKeys[this.mWepPosition] = r12;
        goto L110
    L111:
        r1.allowedKeyManagement.set(0);
        goto L113
    L14:
        if (r4.networkId != (-1)) goto L18;
        r1.SSID = AccessPoint.convertToQuotedString(this.mAccessPoint.ssid);
        if (this.mAccessPoint.getConfig() == null) goto L20;
        r1.hiddenSSID = this.mAccessPoint.getConfig().hiddenSSID;
        goto L20
    L18:
        r1.networkId = this.mAccessPoint.networkId;
        goto L20
    L5:
        if (r0.networkId == (-1)) goto L10;
        if (this.mEdit == true) goto L10;
        OLog.d(TAG, "mAccessPoint.networkId:" + this.mAccessPoint.networkId);
        return null;
    }

    private OCardListItem getSecurityView() {
        return (OCardListItem) NullSafe.nonNull(this.mView.findViewById(R.id.security));
    }

    private void showSecurityFields() {
        OCardListItem r0 = getSecurityView();
        if (this.mAccessPointSecurity != 0) goto L6;
        NullSafe.nonNull(this.mView.findViewById(R.id.security_fields)).setVisibility(8);
        r0.setCardPosition(0);
        return;
    L6:
        r0.setCardPosition(1);
        NullSafe.nonNull(this.mView.findViewById(R.id.security_fields)).setVisibility(0);
        if (this.mPasswordView != null) goto L14;
        OEditText r1 = ((OInputLayout) ((OCardListItem) NullSafe.nonNull(this.mView.findViewById(R.id.password))).getCustomStartView()).getVInput();
        this.mPasswordView = r1;
        r1.setOnEditorActionListener(new AnonymousClass5(this));
        this.mPasswordView.addTextChangedListener(this);
        AccessPoint r2 = this.mAccessPoint;
        if (r2 == null) goto L14;
        if (r2.networkId == (-1)) goto L14;
        this.mPasswordView.setHint(R.string.wifi_unchanged);
    L14:
        if (this.mAccessPointSecurity != 1) goto L16;
        String[] r3 = this.mConfigUi.getContext().getResources().getStringArray(R.array.wep_key_index);
        final OCardListItem r4 = (OCardListItem) NullSafe.nonNull(this.mView.findViewById(R.id.wep_key_index));
        NullSafe.nonNull(this.mView.findViewById(R.id.wep_key_index_container)).setVisibility(0);
        r4.setEndDetailText(r3[this.mWepPosition]);
        r4.setOnContentClickListener(new WifiConfigControllerForSetup$$ExternalSyntheticLambda0(this, r4));
    L18:
        if (this.mAccessPointSecurity == 4) goto L20;
        NullSafe.nonNull(this.mView.findViewById(R.id.wapi_psk_type_container)).setVisibility(8);
    L22:
        if (this.mAccessPointSecurity == 5) goto L24;
        NullSafe.nonNull(this.mView.findViewById(R.id.wapi_cert)).setVisibility(8);
        NullSafe.nonNull(this.mView.findViewById(R.id.l_anonymous)).setVisibility(0);
    L25:
        int r5 = 2;
        if (this.mAccessPointSecurity != 2) goto L29;
        NullSafe.nonNull(this.mView.findViewById(R.id.password_editor_container)).setVisibility(0);
    L29:
        if (this.mAccessPointSecurity == 3) goto L32;
        NullSafe.nonNull(this.mView.findViewById(R.id.eap)).setVisibility(8);
        return;
    L32:
        NullSafe.nonNull(this.mView.findViewById(R.id.eap)).setVisibility(0);
        if (this.mEapMethodItem != null) goto L52;
        getSIMInfo();
        OCardListItem r6 = (OCardListItem) NullSafe.nonNull(this.mView.findViewById(R.id.method));
        this.mEapMethodItem = r6;
        r6.setOnContentClickListener(new WifiConfigControllerForSetup$$ExternalSyntheticLambda3(this));
        AccessPoint r7 = this.mAccessPoint;
        if (r7 == null) goto L40;
        OCardListItem r8 = this.mEapMethodItem;
        if (r7.security != 3) goto L39;
        r5 = 1;
    L39:
        r8.setCardPosition(r5);
    L40:
        OCardListItem r9 = (OCardListItem) NullSafe.nonNull(this.mView.findViewById(R.id.phase2));
        this.mPhase2Item = r9;
        if (this.mEapMethod != 0) goto L43;
        String r10 = this.PHASE2_PEAP_VALUES[this.mPhase2Method];
    L44:
        r9.setEndDetailText(r10);
        this.mPhase2Item.setOnContentClickListener(new WifiConfigControllerForSetup$$ExternalSyntheticLambda4(this));
        OCardListItem r11 = (OCardListItem) NullSafe.nonNull(this.mView.findViewById(R.id.l_sim_card));
        this.mSimCardItem = r11;
        r11.setOnContentClickListener(new WifiConfigControllerForSetup$$ExternalSyntheticLambda5(this));
        OCardListItem r12 = (OCardListItem) NullSafe.nonNull(this.mView.findViewById(R.id.ca_cert));
        this.mEapCaCertItem = r12;
        r12.setOnContentClickListener(new WifiConfigControllerForSetup$$ExternalSyntheticLambda6(this));
        OCardListItem r13 = (OCardListItem) NullSafe.nonNull(this.mView.findViewById(R.id.user_cert));
        this.mEapUserCertItem = r13;
        r13.setOnContentClickListener(new WifiConfigControllerForSetup$$ExternalSyntheticLambda7(this));
        OInputLayout r14 = (OInputLayout) ((OCardListItem) NullSafe.nonNull(this.mView.findViewById(R.id.domain))).getCustomStartView();
        this.mDomainInputLayout = r14;
        r14.showDivider(true);
        OInputLayout r15 = this.mDomainInputLayout;
        r15.setLabel(r15.getResources().getString(R.string.wifi_eap_domain));
        this.mDomainInputLayout.showLabel(true);
        OInputLayout r16 = this.mDomainInputLayout;
        r16.setHint(r16.getResources().getString(R.string.please_input_wifi_eap_domain));
        this.mDomainInputLayout.showClear(true);
        this.mDomainInputLayout.setType(0);
        OInputLayout r17 = this.mDomainInputLayout;
        r17.setTip(r17.getResources().getString(R.string.wifi_no_domain_warning));
        this.mDomainInputLayout.setTextState(true);
        OEditText r18 = this.mDomainInputLayout.getVInput();
        this.mEapDomainView = r18;
        r18.addTextChangedListener(this);
        this.mEapLinearLayoutIdentityView = (LinearLayout) NullSafe.nonNull(this.mView.findViewById(R.id.l_identity));
        OInputLayout r19 = (OInputLayout) ((OCardListItem) NullSafe.nonNull(this.mView.findViewById(R.id.identity))).getCustomStartView();
        r19.showDivider(true);
        r19.setLabel(r19.getResources().getString(R.string.wifi_eap_identity));
        r19.showLabel(true);
        r19.setHint(r19.getResources().getString(R.string.please_input_identify));
        r19.showClear(true);
        r19.setType(0);
        OEditText r20 = r19.getVInput();
        this.mEapIdentityView = r20;
        r20.setFilters(new InputFilter[]{new InputFilter.LengthFilter(32)});
        OInputLayout r21 = (OInputLayout) ((OCardListItem) NullSafe.nonNull(this.mView.findViewById(R.id.anonymous))).getCustomStartView();
        r21.showDivider(true);
        r21.setLabel(r21.getResources().getString(R.string.wifi_eap_anonymous));
        r21.showLabel(true);
        r21.setHint(r21.getResources().getString(R.string.please_input_anonymous));
        r21.showClear(true);
        r21.setType(0);
        OEditText r22 = r21.getVInput();
        this.mEapAnonymousView = r22;
        r22.setFilters(new InputFilter[]{new InputFilter.LengthFilter(32)});
        AndroidKeystoreAliasLoader r23 = getAndroidKeystoreAliasLoader();
        loadCertificates("CACERT_", r23.getCaCertAliases(), this.mDoNotValidateEapServerString, false, true);
        loadCertificates("USRPKEY_", r23.getKeyCertAliases(), this.mDoNotProvideEapUserCertString, false, false);
        this.mEapMethodItem.setEndDetailText(this.EAP_METHOD_VALUES[0]);
        setEapCaCertSubtile(this.mEapCaCerts[this.mEapCaCert]);
        if (Features.isFeatureCMCCEnabled(this.context).booleanValue() == false) goto L51;
        AccessPoint r24 = this.mAccessPoint;
        if (r24 == null) goto L51;
        if ("CMCC".equals(r24.ssid) == false) goto L51;
        showEapFieldsByMethod(7);
        return;
    L51:
        showEapFieldsByMethod(this.mEapMethod);
        return;
    L43:
        r10 = this.PHASE2_FULL_VALUES[this.mPhase2Method];
        goto L44
    L52:
        OCardListItem r25 = this.mPhase2Item;
        if (this.mEapMethod != 0) goto L55;
        String r26 = this.PHASE2_PEAP_VALUES[this.mPhase2Method];
    L56:
        r25.setEndDetailText(r26);
        showEapFieldsByMethod(this.mEapMethod);
        return;
    L55:
        r26 = this.PHASE2_FULL_VALUES[this.mPhase2Method];
        goto L56
    L24:
        NullSafe.nonNull(this.mView.findViewById(R.id.wapi_cert)).setVisibility(0);
        NullSafe.nonNull(this.mView.findViewById(R.id.l_anonymous)).setVisibility(0);
        setPasswordInvisible();
        OListItemSettings r27 = (OListItemSettings) NullSafe.nonNull(this.mView.findViewById(R.id.wapi_as_cert));
        r27.setImageView(this.context.getDrawable(R.drawable.o_icon_down));
        r27.setOnClickListener(this);
        final OCardListItem r28 = (OCardListItem) NullSafe.nonNull(this.mView.findViewById(R.id.wapi_user_cert));
        r28.setOnContentClickListener(new WifiConfigControllerForSetup$$ExternalSyntheticLambda2(this, r28));
        loadWapiCertificates();
        r28.setEndDetailText(this.mWapiCertList.get(this.mWapiUserCert));
        goto L25
    L20:
        NullSafe.nonNull(this.mView.findViewById(R.id.password_editor_container)).setVisibility(0);
        String[] r29 = this.mConfigUi.getContext().getResources().getStringArray(R.array.wifi_wapi_psk_type);
        final OCardListItem r30 = (OCardListItem) NullSafe.nonNull(this.mView.findViewById(R.id.wapi_psk_type));
        NullSafe.nonNull(this.mView.findViewById(R.id.wapi_psk_type_container)).setVisibility(0);
        r30.setOnContentClickListener(new WifiConfigControllerForSetup$$ExternalSyntheticLambda1(this, r30));
        r30.setEndDetailText(r29[this.mWapiPskType]);
        goto L22
    L16:
        NullSafe.nonNull(this.mView.findViewById(R.id.wep_key_index_container)).setVisibility(8);
        goto L18
    }

    /* JADX INFO: renamed from: lambda$showSecurityFields$1$com-android-settings-wifi-WifiConfigControllerForSetup, reason: not valid java name */
    /* synthetic */ void m686xb7741383(OCardListItem r1, View r2) {
        handleWepKeyIndexClick(r1);
    }

    /* JADX INFO: renamed from: lambda$showSecurityFields$2$com-android-settings-wifi-WifiConfigControllerForSetup, reason: not valid java name */
    /* synthetic */ void m687xb8aa6662(OCardListItem r1, View r2) {
        handleWapiPskTypeClick(r1);
    }

    /* JADX INFO: renamed from: lambda$showSecurityFields$3$com-android-settings-wifi-WifiConfigControllerForSetup, reason: not valid java name */
    /* synthetic */ void m688xb9e0b941(OCardListItem r1, View r2) {
        handleClickUserCert(r1);
    }

    /* JADX INFO: renamed from: lambda$showSecurityFields$4$com-android-settings-wifi-WifiConfigControllerForSetup, reason: not valid java name */
    /* synthetic */ void m689xbb170c20(View r1) {
        handleMethodClick(this.mEapMethodItem);
    }

    /* JADX INFO: renamed from: lambda$showSecurityFields$5$com-android-settings-wifi-WifiConfigControllerForSetup, reason: not valid java name */
    /* synthetic */ void m690xbc4d5eff(View r1) {
        handlePhase2Click(this.mPhase2Item);
    }

    /* JADX INFO: renamed from: lambda$showSecurityFields$6$com-android-settings-wifi-WifiConfigControllerForSetup, reason: not valid java name */
    /* synthetic */ void m691xbd83b1de(View r1) {
        handleSimCardClick(this.mSimCardItem);
    }

    /* JADX INFO: renamed from: lambda$showSecurityFields$7$com-android-settings-wifi-WifiConfigControllerForSetup, reason: not valid java name */
    /* synthetic */ void m692xbeba04bd(View r1) {
        handleEapCacertClick();
    }

    /* JADX INFO: renamed from: lambda$showSecurityFields$8$com-android-settings-wifi-WifiConfigControllerForSetup, reason: not valid java name */
    /* synthetic */ void m693xbff0579c(View r1) {
        handleEapUserCertClick(this.mEapUserCertItem);
    }

    private void showEapFieldsByMethod(int r5) {
        NullSafe.nonNull(this.mView.findViewById(R.id.method)).setVisibility(0);
        this.mEapLinearLayoutIdentityView.setVisibility(0);
        NullSafe.nonNull(this.mView.findViewById(R.id.l_domain)).setVisibility(0);
        NullSafe.nonNull(this.mView.findViewById(R.id.ca_cert_container)).setVisibility(0);
        NullSafe.nonNull(this.mView.findViewById(R.id.password_editor_container)).setVisibility(0);
        switch(r5) {
            case 0: goto L22;
            case 1: goto L16;
            case 2: goto L9;
            case 3: goto L7;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L27;
        };
    L5:
        setEapMethodInvisible();
        setPhase2Invisible();
        setCaCertInvisible();
        setDomainInvisible();
        setAnonymousIdentInvisible();
        setUserCertInvisible();
        setSimCardInvisible();
        goto L27
    L6:
        NullSafe.nonNull(this.mView.findViewById(R.id.l_sim_card_container)).setVisibility(0);
        setPhase2Invisible();
        setAnonymousIdentInvisible();
        setCaCertInvisible();
        setDomainInvisible();
        setUserCertInvisible();
        setPasswordInvisible();
        setIdentityInvisible();
        goto L27
    L7:
        setPhase2Invisible();
        setCaCertInvisible();
        setDomainInvisible();
        setAnonymousIdentInvisible();
        setUserCertInvisible();
        setSimCardInvisible();
        goto L27
    L22:
        ArrayAdapter<String> r6 = this.mPhase2Adapter;
        ArrayAdapter<String> r3 = this.PHASE2_PEAP_ADAPTER;
        if (r6 == r3) goto L25;
        this.mPhase2Adapter = r3;
    L25:
        NullSafe.nonNull(this.mView.findViewById(R.id.phase2_container)).setVisibility(0);
        NullSafe.nonNull(this.mView.findViewById(R.id.l_anonymous)).setVisibility(0);
        setUserCertInvisible();
        setSimCardInvisible();
        goto L27
    L9:
        if (this.mSelectEapCaCertManual == true) goto L11;
        setCaCertSelection(this.mUseSystemCertsString);
    L11:
        ArrayAdapter<String> r7 = this.mPhase2Adapter;
        ArrayAdapter<String> r4 = this.PHASE2_FULL_ADAPTER;
        if (r7 == r4) goto L14;
        this.mPhase2Adapter = r4;
    L14:
        NullSafe.nonNull(this.mView.findViewById(R.id.phase2_container)).setVisibility(0);
        NullSafe.nonNull(this.mView.findViewById(R.id.l_anonymous)).setVisibility(0);
        setUserCertInvisible();
        setSimCardInvisible();
        goto L27
    L16:
        if (this.mSelectEapCaCertManual == true) goto L18;
        setCaCertSelection(this.mUseSystemCertsString);
    L18:
        View r8 = NullSafe.nonNull(this.mView.findViewById(R.id.user_cert_container));
        if (r8 == null) goto L21;
        r8.setVisibility(0);
    L21:
        setPhase2Invisible();
        setAnonymousIdentInvisible();
        setPasswordInvisible();
        setSimCardInvisible();
    L27:
        if (NullSafe.nonNull(this.mView.findViewById(R.id.ca_cert)).getVisibility() == 8) goto L38;
        String r9 = this.mEapCaCerts[this.mEapCaCert];
        if (r9.equals(this.mDoNotValidateEapServerString) == false) goto L31;
    L36:
        setDomainInvisible();
        return;
    L31:
        if (r9.equals(this.unspecifiedCert) == true) goto L36;
        if (this.mIsTrustOnFirstUseSupported == true) goto L35;
        return;
    L35:
        if (r9.equals(this.mTrustOnFirstUse) == true) goto L36;
        return;
    }

    private void setSimCardInvisible() {
        NullSafe.nonNull(this.mView.findViewById(R.id.l_sim_card_container)).setVisibility(8);
    }

    private void setIdentityInvisible() {
        this.mEapLinearLayoutIdentityView.setVisibility(8);
    }

    private void setPhase2Invisible() {
        NullSafe.nonNull(this.mView.findViewById(R.id.phase2_container)).setVisibility(8);
    }

    private void setCaCertInvisible() {
        NullSafe.nonNull(this.mView.findViewById(R.id.ca_cert_container)).setVisibility(8);
    }

    private void setUserCertInvisible() {
        NullSafe.nonNull(this.mView.findViewById(R.id.user_cert_container)).setVisibility(8);
    }

    private void setDomainInvisible() {
        NullSafe.nonNull(this.mView.findViewById(R.id.l_domain)).setVisibility(8);
        this.mEapDomainView.setText("");
    }

    private void setAnonymousIdentInvisible() {
        NullSafe.nonNull(this.mView.findViewById(R.id.l_anonymous)).setVisibility(8);
        this.mEapAnonymousView.setText("");
    }

    private void setPasswordInvisible() {
        this.mPasswordView.setText("");
        NullSafe.nonNull(this.mView.findViewById(R.id.password_editor_container)).setVisibility(8);
    }

    private void setEapMethodInvisible() {
        NullSafe.nonNull(this.mView.findViewById(R.id.method)).setVisibility(8);
    }

    AndroidKeystoreAliasLoader getAndroidKeystoreAliasLoader() {
        return new AndroidKeystoreAliasLoader(102);
    }

    private void loadCertificates(String r2, Collection<String> r3, String r4, boolean r5, boolean r6) {
        this.mConfigUi.getContext();
        ArrayList r7 = new ArrayList();
        r7.add(this.unspecifiedCert);
        if (r5 == false) goto L5;
        r7.add(this.mMultipleCertSetString);
    L5:
        if (r6 == false) goto L9;
        r7.add(this.mUseSystemCertsString);
        if (this.mIsTrustOnFirstUseSupported == false) goto L9;
        r7.add(this.mTrustOnFirstUse);
    L9:
        if (r3 == null) goto L14;
        if (r3.size() == 0) goto L14;
        r7.addAll((Collection) r3.stream().filter(new WifiConfigControllerForSetup$$ExternalSyntheticLambda8()).collect(Collectors.toList()));
    L14:
        if ("CACERT_".equals(r2) == false) goto L17;
        this.mEapCaCerts = (String[]) r7.toArray(new String[r7.size()]);
        return;
    L17:
        if ("USRPKEY_".equals(r2) == false) goto L21;
        this.mEapUserCerts = (String[]) r7.toArray(new String[r7.size()]);
        return;
    }

    static /* synthetic */ boolean lambda$loadCertificates$9(String r5) {
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

    private void setCaCertSelection(String r6) {
        int r0 = 0;
        if (r6 == null) goto L11;
        String[] r1 = this.mEapCaCerts;
        int r2 = r1.length;
        int r3 = 0;
    L5:
        if (r0 >= r2) goto L10;
        if (r6.equals(r1[r0]) == true) goto L10;
        r3 = r3 + 1;
        r0 = r0 + 1;
    L10:
        r0 = r3;
    L11:
        this.mEapCaCert = r0;
        this.mEapCaCertItem.setEndDetailText(this.mEapCaCerts[r0]);
    }

    private void loadWapiCertificates() {
        String r0 = this.context.getString(R.string.wifi_unspecified);
        String r1 = this.context.getString(R.string.wapi_auto_sel_cert);
        ArrayList<String> r2 = new ArrayList();
        String[] r3 = WifiKeystore.list(WAPI_USER_CERTIFICATE);
        int r4 = 0;
        if (r3 != null) goto L5;
    L12:
        r2.add(r0);
        this.mHaveWapiCert = false;
    L13:
        this.mWapiCertList = r2;
        return;
    L5:
        if (r3.length <= 0) goto L12;
        r2.add(r1);
    L9:
        if (r4 >= r3.length) goto L11;
        r2.add(r3[r4]);
        r4 = r4 + 1;
        goto L9
    L11:
        this.mHaveWapiCert = true;
        goto L13
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

    public boolean isEdit() {
        return this.mEdit;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r2) {
        OInputLayout r0 = this.mDomainInputLayout;
        if (r0 != null) goto L5;
    L7:
        this.mTextViewChangedHandler.post(new AnonymousClass6(this));
        return;
    L5:
        if (r0.getVInput().getEditableText() != r2) goto L7;
        OInputLayout r3 = this.mDomainInputLayout;
        r3.setTextState(r3.getText().isEmpty());
        goto L7
    }

    public void showSoftKeyguard(Context r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        OEditText r0 = this.mPasswordView;
        if (r0 != null) goto L7;
    L9:
        OEditText r1 = this.mSsidView;
        if (r1 != null) goto L12;
    L14:
        LinearLayout r2 = this.mEapLinearLayoutIdentityView;
        if (r2 != null) goto L17;
        return;
    L17:
        if (r2.getVisibility() != 0) goto L23;
        OLog.d(TAG, "show InputMethod for identityView");
        com.android.settings.Utils.showSoftInputMethod(r3, this.mEapIdentityView);
        return;
    L23:
        return;
    L12:
        if (r1.getVisibility() != 0) goto L14;
        OLog.d(TAG, "show InputMethod for ssidView");
        com.android.settings.Utils.showSoftInputMethod(r3, this.mSsidView);
        return;
    L7:
        if (r0.getVisibility() != 0) goto L9;
        OLog.d(TAG, "show InputMethod for passwordView");
        com.android.settings.Utils.showSoftInputMethod(r3, this.mPasswordView);
    }

    private OInsetSheet creatDialog(Context r6, String r7, List<OSelectionPanelView.SelectionItemData> r8, int r9, OSingleSelectionPanelView.OnItemSelectListener r10) {
        final OInsetSheet r0 = new OInsetSheet(r6);
        r0.setRootWidth(OInsetSheet.PanelWidth.NARROW_WIDTH);
        OCTitleBar r1 = new OCTitleBar(r6);
        r1.setShowLeftBack(false);
        OButton r3 = r1.createNeutralButton(r6, r1.mRightContainer);
        r3.setButtonSourceBitmap(R.drawable.o_ic_close);
        r3.setOnClickListener(new AnonymousClass7(this, r0));
        r1.setTitleText(r7);
        r0.setHeaderView(r1);
        OSingleSelectionPanelView r5 = new OSingleSelectionPanelView(r6, null, R.style.OSelectionPanel);
        r5.showDividers(true);
        r5.setItems(r8);
        r5.select(r9);
        r5.removeMinHeightConstraint();
        r5.registerItemSelectListener(r10);
        r0.setContainerView(r5);
        r0.setClearDimFlag(false);
        r0.getWindow().setFlags(131072, 131072);
        return r0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(final View r7) {
        if (com.android.settings.Utils.isFastDoubleClick() == false) goto L5;
        return;
    L5:
        int r0 = r7.getId();
        if (r0 != R.id.wapi_as_cert) goto L8;
        ArrayList r1 = new ArrayList();
        int r2 = 0;
    L13:
        if (r2 >= this.mWapiCertList.size()) goto L15;
        r1.add(new Item(this.mWapiCertList.get(r2), false, null));
        r2 = r2 + 1;
        goto L13
    L15:
        ((Item) r1.get(this.mWapiAsCert)).setSelect(true);
        this.popover = OPopoverHelper.showPopoverList((Activity) this.context, r7, r1, new AnonymousClass8(this, r7), true);
        return;
    L8:
        if (r0 != R.id.wifi_advanced_togglebox) goto L19;
        launchAdvancedOptions();
        return;
    }

    private void handleEapUserCertClick(final OCardListItem r7) {
        ArrayList r0 = new ArrayList();
        int r2 = 0;
    L4:
        if (r2 >= this.mEapUserCerts.length) goto L6;
        r0.add(new Item(this.mEapUserCerts[r2], false, null));
        r2 = r2 + 1;
        goto L4
    L6:
        ((Item) r0.get(this.mEapUserCert)).setSelect(true);
        this.popover = OPopoverHelper.showPopoverList((Activity) this.context, r7, r0, new AnonymousClass9(this, r7), true);
    }

    private void handleSimCardClick(final OCardListItem r7) {
        ArrayList r0 = new ArrayList();
        int r2 = 0;
    L4:
        if (r2 >= this.mSimDisplayNames.length) goto L6;
        r0.add(new Item(this.mSimDisplayNames[r2], false, null));
        r2 = r2 + 1;
        goto L4
    L6:
        ((Item) r0.get(this.mSimCardIndex)).setSelect(true);
        this.popover = OPopoverHelper.showPopoverList((Activity) this.context, r7, r0, new AnonymousClass10(this, r7), true);
    }

    private void handleClickUserCert(final OCardListItem r7) {
        ArrayList r0 = new ArrayList();
        int r2 = 0;
    L4:
        if (r2 >= this.mWapiCertList.size()) goto L6;
        r0.add(new Item(this.mWapiCertList.get(r2), false, null));
        r2 = r2 + 1;
        goto L4
    L6:
        ((Item) r0.get(this.mWapiUserCert)).setSelect(true);
        this.popover = OPopoverHelper.showPopoverList((Activity) this.context, r7, r0, new AnonymousClass11(this, r7), true);
    }

    private void handleEapCacertClick() {
        ArrayList r0 = new ArrayList();
        int r2 = 0;
    L4:
        if (r2 >= this.mEapCaCerts.length) goto L6;
        r0.add(new Item(this.mEapCaCerts[r2], false, null));
        r2 = r2 + 1;
        goto L4
    L6:
        ((Item) r0.get(this.mEapCaCert)).setSelect(true);
        this.popover = OPopoverHelper.showPopoverList((Activity) this.context, this.mEapCaCertItem, r0, new AnonymousClass12(this), true);
    }

    private void handlePhase2Click(final OCardListItem r7) {
        ArrayList r0 = new ArrayList();
        int r2 = 0;
    L4:
        if (r2 >= this.mPhase2Adapter.getCount()) goto L6;
        r0.add(new Item(this.mPhase2Adapter.getItem(r2), false, null));
        r2 = r2 + 1;
        goto L4
    L6:
        ((Item) r0.get(this.mPhase2Method)).setSelect(true);
        this.popover = OPopoverHelper.showPopoverList((Activity) this.context, r7, r0, new AnonymousClass13(this, r7), true);
    }

    private void handleMethodClick(final OCardListItem r7) {
        ArrayList r0 = new ArrayList();
        int r2 = 0;
    L4:
        if (r2 >= this.EAP_METHOD_VALUES.length) goto L6;
        r0.add(new Item(this.EAP_METHOD_VALUES[r2], false, null));
        r2 = r2 + 1;
        goto L4
    L6:
        ((Item) r0.get(this.mEapMethod)).setSelect(true);
        this.popover = OPopoverHelper.showPopoverList((Activity) this.context, r7, r0, new AnonymousClass14(this, r7), true);
    }

    private void handleWapiPskTypeClick(final OCardListItem r7) {
        ArrayList r0 = new ArrayList();
        int r2 = 0;
    L4:
        if (r2 >= this.WAPI_PSK_VALUES.length) goto L6;
        r0.add(new Item(this.WAPI_PSK_VALUES[r2], false, null));
        r2 = r2 + 1;
        goto L4
    L6:
        ((Item) r0.get(this.mWapiPskType)).setSelect(true);
        this.popover = OPopoverHelper.showPopoverList((Activity) this.context, r7, r0, new AnonymousClass15(this, r7), true);
    }

    private void handleWepKeyIndexClick(final OCardListItem r9) {
        ArrayList r0 = new ArrayList();
        String[] r1 = this.WEP_KEY_INDEX;
        int r2 = r1.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        r0.add(new Item(r1[r4], false, null));
        r4 = r4 + 1;
        goto L3
    L5:
        ((Item) r0.get(this.mWepPosition)).setSelect(true);
        this.popover = OPopoverHelper.showPopoverList((Activity) this.context, r9, r0, new AnonymousClass16(this, r9), true);
    }

    private void handleClickSecurity(final OCardListItem r9) {
        OPopover r0 = this.popover;
        if (r0 != null) goto L5;
    L7:
        ArrayList r1 = new ArrayList();
        String[] r2 = this.WIFI_SECURITY_VALUES;
        int r3 = r2.length;
        int r4 = 0;
    L8:
        if (r4 >= r3) goto L10;
        r1.add(new Item(r2[r4], false, null));
        r4 = r4 + 1;
        goto L8
    L10:
        ((Item) r1.get(this.mAccessPointSecurity)).setSelect(true);
        this.popover = OPopoverHelper.showPopoverList((Activity) this.context, r9, r1, new AnonymousClass17(this, r9), true);
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
    }

    private void launchAdvancedOptions() {
        AdvancedAccessPointSettingsFragment r0 = new AdvancedAccessPointSettingsFragment();
        Bundle r1 = new Bundle();
        r1.putParcelable(AccessPointInfo.EXTRA_WIFI_CONFIGURATION, getConfig());
        r1.putBoolean("launch_by_wifiSetup", true);
        r0.setArguments(r1);
        this.mConfigUi.start(r0);
    }

    private void getSIMInfo() {
        ArrayList r0 = new ArrayList();
        this.mSubscriptionManager = SubscriptionManager.from(this.context);
        int r2 = 0;
    L4:
        if (r2 >= this.mTelephonyManager.getSimCount()) goto L10;
        SubscriptionInfo r3 = this.mSubscriptionManager.getActiveSubscriptionInfoForSimSlotIndex(r2);
        if (r3 == null) goto L8;
        String r4 = String.valueOf(r3.getDisplayName());
    L9:
        r0.add(r4);
        r2 = r2 + 1;
        goto L4
    L8:
        r4 = this.context.getString(R.string.sim_editor_title, new Object[]{Integer.valueOf(r2 + 1)});
        goto L9
    L10:
        this.mSimDisplayNames = (String[]) r0.toArray(new String[r0.size()]);
    }

    public void finish() {
        OInsetSheet r0 = this.mSecurityChooser;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }

    private void setEapCaCertSubtile(String r5) {
        SpannableString r0 = new SpannableString(r5);
        if (this.mEapCaCert != 0) goto L5;
        r0.setSpan(new ForegroundColorSpan(this.context.getColor(R.color.legal_privacy_light_color)), 0, r5.length(), 33);
    L5:
        this.mEapCaCertItem.setEndDetailText(r0.toString());
    }

    public int getCurSecurity() {
        return this.mAccessPointSecurity;
    }

    public boolean checkWapiParam() {
        this.mConfigUi.getContext().getString(R.string.wifi_unchanged);
        int r0 = this.mAccessPointSecurity;
        if (r0 != 5) goto L7;
        return this.mHaveWapiCert;
    L7:
        if (r0 == 4) goto L9;
        return true;
    L9:
        return checkWapiPassword(this.mPasswordView.getText().toString(), this.mWapiPskType);
    }

    private boolean checkWapiPassword(String r5, int r6) {
        Context r0 = this.mConfigUi.getContext();
        if (r5.isEmpty() == false) goto L7;
        ToastUtils.show(this.mConfigUi.getActivity(), r0.getString(R.string.wapi_password_empty));
        return false;
    L7:
        if (r5.length() >= 8) goto L9;
    L22:
        ToastUtils.show(this.mConfigUi.getActivity(), r0.getString(R.string.wapi_password_length_invalid));
        return false;
    L9:
        if (r5.length() > 64) goto L22;
        if (r6 != 1) goto L21;
        int r7 = checkHexPasswd(r5);
        if (r7 != (-2)) goto L18;
        ToastUtils.show(this.mConfigUi.getActivity(), r0.getString(R.string.wapi_password_hex_format_invalid));
        return false;
    L18:
        if (r7 != (-1)) goto L21;
        ToastUtils.show(this.mConfigUi.getActivity(), r0.getString(R.string.wapi_password_hex_length_invalid));
        return false;
    L21:
        return true;
    }

    private static int checkHexPasswd(String r3) {
        if ((r3.length() % 2) != 1) goto L6;
        return -1;
    L6:
        int r0 = r3.length() - 1;
    L7:
        if (r0 < 0) goto L24;
        char r1 = r3.charAt(r0);
        if (r1 < '0') goto L13;
        if (r1 > '9') goto L13;
    L21:
        r0 = r0 - 1;
    L13:
        if (r1 < 'A') goto L17;
        if (r1 <= 'F') goto L21;
    L17:
        if (r1 < 'a') goto L22;
        if (r1 <= 'f') goto L21;
        return -2;
    L22:
        return -2;
    L24:
        return 0;
    }
}
