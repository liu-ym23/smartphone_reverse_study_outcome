package com.android.settings.wifi;

import android.app.Activity;
import android.content.Context;
import android.net.IpConfiguration;
import android.net.LinkAddress;
import android.net.NetworkUtils;
import android.net.ProxyInfo;
import android.net.StaticIpConfiguration;
import android.net.Uri;
import android.net.wifi.WifiConfiguration;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.android.net.module.util.NetUtils;
import com.android.net.module.util.ProxyUtils;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settings.ProxySelector;
import com.android.settings.R;
import com.android.settings.WifiConfigurationSmtOnly;
import com.android.settings.applications.utils.Item;
import com.android.settings.applications.utils.OPopoverHelper;
import com.android.settings.base.BaseActivity;
import com.android.settings.utils.NullSafe;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.text.OTextView;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class WifiConfigControllerEx implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private static final int PROXY_MODE_AUTO = 2;
    private static final int PROXY_MODE_MANUAL = 1;
    private static final int PROXY_MODE_NONE = 0;
    private static final String TAG = "com.android.settings.wifi.WifiConfigControllerEx";
    protected static final int TAG_DNS1 = 16;
    protected static final int TAG_DNS2 = 17;
    protected static final int TAG_GATEWAY = 14;
    protected static final int TAG_IP_ADDRESS = 13;
    protected static final int TAG_NETWORK_PREFIX_LEN = 15;
    protected static final int TAG_PROXY_EXCLUSION = 12;
    protected static final int TAG_PROXY_HOST = 10;
    protected static final int TAG_PROXY_MODE = 18;
    protected static final int TAG_PROXY_PAC = 19;
    protected static final int TAG_PROXY_PORT = 11;
    private final AccessPoint mAccessPoint;
    private int mAccessPointSecurity;
    private Context mContext;
    private OCardListItem mDNS1;
    private OCardListItem mDNS2;
    private DismissListener mDismissListener;
    private EditText mEditor;
    private Fragment mFragment;
    private OCardListItem mGateway;
    private ProxyInfo mHttpProxy;
    private OCardListItem mIpAddress;
    private IpConfiguration.IpAssignment mIpAssignment;
    private View.OnClickListener mListener;
    private OCardListItem mNetworkPrefixLen;
    private OCardListItem mProxyExclusionlist;
    private OCardListItem mProxyHostname;
    private LinearLayout mProxyManualContainer;
    private OCardListItem mProxyMode;
    private OCardListItem mProxyPac;
    private LinearLayout mProxyPacContainer;
    private OCardListItem mProxyPort;
    private OInsetSheet mProxySetDialog;
    private IpConfiguration.ProxySettings mProxySettings;
    private OCardListItem mStaticIpAddress;
    private OSwitch mStaticIpAddressSwitch;
    private StaticIpConfiguration mStaticIpConfiguration;
    private OPopover popover;

    public interface DismissListener {
        void dismiss(boolean r1);
    }

    static {
    }

    static /* synthetic */ void access$000(WifiConfigControllerEx r0, int r1) {
        r0.setProxyMode(r1);
    }

    static /* synthetic */ OPopover access$100(WifiConfigControllerEx r0) {
        return r0.popover;
    }

    static /* synthetic */ boolean access$200(WifiConfigControllerEx r0) {
        return r0.ipAndProxyFieldsAreValid();
    }

    static /* synthetic */ DismissListener access$300(WifiConfigControllerEx r0) {
        return r0.mDismissListener;
    }

    static /* synthetic */ Fragment access$400(WifiConfigControllerEx r0) {
        return r0.mFragment;
    }

    void setSaveButtonListener(View.OnClickListener r1) {
        this.mListener = r1;
    }

    public WifiConfigControllerEx(Fragment r4, View r5, AccessPoint r6) {
        this.mIpAssignment = IpConfiguration.IpAssignment.UNASSIGNED;
        this.mProxySettings = IpConfiguration.ProxySettings.UNASSIGNED;
        WifiConfiguration r0 = null;
        this.mHttpProxy = null;
        this.mStaticIpConfiguration = null;
        this.mProxySetDialog = null;
        this.mDismissListener = null;
        this.mContext = r4.getActivity();
        this.mFragment = r4;
        this.mAccessPoint = r6;
        boolean r7 = false;
        if (r6 != null) goto L5;
        int r1 = 0;
    L6:
        this.mAccessPointSecurity = r1;
        if (r6 == null) goto L9;
        String r2 = r6.ssid;
    L11:
        if (TextUtils.isEmpty(r2) == false) goto L13;
        this.mContext.getString(R.string.wifi_add_network);
    L13:
        OCardListItem r3 = (OCardListItem) NullSafe.nonNull(r5.findViewById(R.id.proxy_mode));
        this.mProxyMode = r3;
        r3.setTag(18);
        this.mProxyMode.setOnContentClickListener(new WifiConfigControllerEx$$ExternalSyntheticLambda0(this));
        this.mProxyPacContainer = (LinearLayout) NullSafe.nonNull(r5.findViewById(R.id.proxy_setting_auto_container));
        OCardListItem r8 = (OCardListItem) NullSafe.nonNull(r5.findViewById(R.id.proxy_setting_auto));
        this.mProxyPac = r8;
        r8.setTag(19);
        this.mProxyPac.setOnContentClickListener(this);
        OCardListItem r9 = (OCardListItem) NullSafe.nonNull(r5.findViewById(R.id.proxy_hostname));
        this.mProxyHostname = r9;
        r9.setTag(10);
        this.mProxyHostname.setOnContentClickListener(this);
        OCardListItem r10 = (OCardListItem) NullSafe.nonNull(r5.findViewById(R.id.proxy_port));
        this.mProxyPort = r10;
        r10.setTag(11);
        this.mProxyPort.setOnContentClickListener(this);
        OCardListItem r11 = (OCardListItem) NullSafe.nonNull(r5.findViewById(R.id.proxy_exclusionlist));
        this.mProxyExclusionlist = r11;
        r11.setTag(12);
        this.mProxyExclusionlist.setOnContentClickListener(this);
        this.mProxyManualContainer = (LinearLayout) NullSafe.nonNull(r5.findViewById(R.id.proxy_setting_manual_container));
        OCardListItem r12 = (OCardListItem) NullSafe.nonNull(r5.findViewById(R.id.static_ip_address_switch));
        this.mStaticIpAddress = r12;
        this.mStaticIpAddressSwitch = (OSwitch) r12.getCustomEndView();
        OCardListItem r13 = (OCardListItem) NullSafe.nonNull(r5.findViewById(R.id.wifi_ip_address));
        this.mIpAddress = r13;
        r13.setTag(13);
        this.mIpAddress.setOnContentClickListener(this);
        OCardListItem r14 = (OCardListItem) NullSafe.nonNull(r5.findViewById(R.id.wifi_gateway));
        this.mGateway = r14;
        r14.setTag(14);
        this.mGateway.setOnContentClickListener(this);
        OCardListItem r15 = (OCardListItem) NullSafe.nonNull(r5.findViewById(R.id.wifi_network_prefix_len));
        this.mNetworkPrefixLen = r15;
        r15.setTag(15);
        this.mNetworkPrefixLen.setOnContentClickListener(this);
        OCardListItem r16 = (OCardListItem) NullSafe.nonNull(r5.findViewById(R.id.wifi_dns1));
        this.mDNS1 = r16;
        r16.setTag(16);
        this.mDNS1.setOnContentClickListener(this);
        OCardListItem r17 = (OCardListItem) NullSafe.nonNull(r5.findViewById(R.id.wifi_dns2));
        this.mDNS2 = r17;
        r17.setTag(17);
        this.mDNS2.setOnContentClickListener(this);
        if (r6 == null) goto L16;
        r0 = r6.getConfig();
    L16:
        if (r0 != null) goto L18;
    L21:
        this.mStaticIpAddressSwitch.setChecked(r7);
        this.mStaticIpAddressSwitch.setOnCheckedChangeListener(this);
        setStaticIpFieldsEnableState(r7);
        showIpConfigFields();
        showProxyFields();
        return;
    L18:
        if (r0.getIpConfiguration().getIpAssignment() != IpConfiguration.IpAssignment.STATIC) goto L20;
        r7 = true;
    L20:
        r0.getIpConfiguration().getProxySettings();
        IpConfiguration.ProxySettings r18 = IpConfiguration.ProxySettings.STATIC;
        goto L21
    L9:
        r2 = null;
        goto L11
    L5:
        r1 = r6.security;
        goto L6
    }

    /* JADX INFO: renamed from: lambda$new$0$com-android-settings-wifi-WifiConfigControllerEx, reason: not valid java name */
    /* synthetic */ void m684lambda$new$0$comandroidsettingswifiWifiConfigControllerEx(View r1) {
        handleProxyClick();
    }

    private void handleProxyClick() {
        if (this.mProxySettings != IpConfiguration.ProxySettings.STATIC) goto L6;
        int r0 = 1;
    L9:
        ArrayList r1 = new ArrayList();
        r1.add(new Item(this.mContext.getString(R.string.proxy_setting_summary_none), false, null));
        r1.add(new Item(this.mContext.getString(R.string.proxy_setting_summary_manual), false, null));
        r1.add(new Item(this.mContext.getString(R.string.proxy_setting_summary_pac), false, null));
        ((Item) r1.get(r0)).setSelect(true);
        this.popover = OPopoverHelper.showPopoverList((Activity) this.mContext, this.mProxyMode, r1, new AnonymousClass1(this), true);
        return;
    L6:
        if (this.mProxySettings != IpConfiguration.ProxySettings.PAC) goto L8;
        r0 = 2;
        goto L9
    L8:
        r0 = 0;
        goto L9
    }

    private void setStaticIpFieldsEnableState(boolean r2) {
        setChildrenAlpha(this.mIpAddress, r2);
        setChildrenAlpha(this.mGateway, r2);
        setChildrenAlpha(this.mNetworkPrefixLen, r2);
        setChildrenAlpha(this.mDNS1, r2);
        setChildrenAlpha(this.mDNS2, r2);
    }

    WifiConfiguration getConfig() {
        AccessPoint r0 = this.mAccessPoint;
        if (r0 == null) goto L5;
        WifiConfiguration r1 = r0.getConfig();
    L6:
        AccessPoint r2 = this.mAccessPoint;
        if (r2 == null) goto L14;
        if (r2.networkId != (-1)) goto L12;
        r1.SSID = AccessPoint.convertToQuotedString(this.mAccessPoint.ssid);
        goto L14
    L12:
        r1.networkId = this.mAccessPoint.networkId;
        WifiConfigurationSmtOnly.set_isTrustedAp(r1, WifiConfigurationSmtOnly.get_isTrustedAp(this.mAccessPoint.getConfig()));
        WifiConfigurationSmtOnly.set_needLogin(r1, WifiConfigurationSmtOnly.get_needLogin(this.mAccessPoint.getConfig()));
        WifiConfigurationSmtOnly.set_autoConnect(r1, WifiConfigurationSmtOnly.get_autoConnect(this.mAccessPoint.getConfig()));
    L14:
        switch(this.mAccessPointSecurity) {
            case 0: goto L23;
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            default: goto L15;
        };
    L15:
        return null;
    L17:
        r1.setSecurityParams(4);
    L24:
        r1.setIpConfiguration(new IpConfiguration(this.mIpAssignment, this.mProxySettings, this.mStaticIpConfiguration, this.mHttpProxy));
        return r1;
    L18:
        r1.allowedKeyManagement.set(MultiSDKAdapterNew.getWapiCertValue());
        goto L24
    L19:
        r1.allowedKeyManagement.set(MultiSDKAdapterNew.getWapiPskValue());
        goto L24
    L20:
        r1.allowedKeyManagement.set(2);
        r1.allowedKeyManagement.set(3);
        goto L24
    L21:
        r1.allowedKeyManagement.set(1);
        goto L24
    L22:
        r1.allowedKeyManagement.set(0);
        r1.allowedAuthAlgorithms.set(0);
        r1.allowedAuthAlgorithms.set(1);
        goto L24
    L23:
        r1.allowedKeyManagement.set(0);
        goto L24
    L5:
        r1 = new WifiConfiguration();
        goto L6
    }

    private boolean ipAndProxyFieldsAreValid() {
        if (this.mStaticIpAddressSwitch.isChecked() == false) goto L5;
        IpConfiguration.IpAssignment r0 = IpConfiguration.IpAssignment.STATIC;
    L6:
        this.mIpAssignment = r0;
        StaticIpConfiguration r1 = new StaticIpConfiguration();
        this.mStaticIpConfiguration = r1;
        int r2 = validateIpConfigFields(r1);
        if (this.mIpAssignment != IpConfiguration.IpAssignment.STATIC) goto L11;
        if (r2 == 0) goto L11;
        OLog.d(TAG, "invalid ip address :" + this.mContext.getString(r2));
        return false;
    L11:
        String r3 = getTrailingTextString(this.mProxyHostname);
        String r4 = "";
        if (r3 != null) goto L14;
        r3 = "";
    L14:
        String r5 = getTrailingTextString(this.mProxyPort);
        if (r5 != null) goto L17;
        r5 = "";
    L17:
        String r6 = getTrailingTextString(this.mProxyExclusionlist);
        if (r6 == null) goto L22;
        r4 = r6;
    L22:
        if (TextUtils.isEmpty(r5) == false) goto L52;
        int r7 = -1;
    L27:
        CharSequence r8 = this.mProxyPac.getSubTitle();
        if (TextUtils.isEmpty(r8) == true) goto L30;
        Uri r9 = Uri.parse(r8.toString());
    L31:
        this.mHttpProxy = null;
        if (this.mProxySettings != IpConfiguration.ProxySettings.STATIC) goto L42;
        if (this.mProxyHostname == null) goto L42;
        r7 = Integer.parseInt(r5);     // Catch: NumberFormatException -> L37
        int r10 = ProxySelector.validate(r3, r5, r4);     // Catch: NumberFormatException -> L37
    L38:
        if (r10 != 0) goto L40;
        this.mHttpProxy = new ProxyInfo(r3, r7, r4);
        return true;
    L40:
        return false;
    L37:
        r10 = R.string.proxy_error_invalid_port;
    L42:
        if (this.mProxySettings == IpConfiguration.ProxySettings.PAC) goto L44;
        return true;
    L44:
        if (this.mProxyPac == null) goto L56;
        if (r9 != null) goto L47;
        return false;
    L47:
        this.mHttpProxy = new ProxyInfo(r9);
        return true;
    L56:
        return true;
    L30:
        r9 = null;
        goto L31
    L52:
        r7 = Integer.parseInt(r5);     // Catch: NumberFormatException -> L25
    L25:
        return false;
    L5:
        r0 = IpConfiguration.IpAssignment.DHCP;
        goto L6
    }

    private int validateIpConfigFields(StaticIpConfiguration r7) {
        OCardListItem r0 = this.mIpAddress;
        if (r0 != null) goto L5;
        return 0;
    L5:
        String r1 = getTrailingTextString(r0);
        if (TextUtils.isEmpty(r1) == false) goto L8;
        return R.string.wifi_ip_settings_invalid_ip_address;
    L8:
        Inet4Address r2 = getIPv4Address(r1);
        if (r2 != null) goto L11;
    L60:
        return R.string.wifi_ip_settings_invalid_ip_address;
    L11:
        if (r2.equals(Inet4Address.ANY) == true) goto L60;
        StaticIpConfiguration.Builder r8 = new StaticIpConfiguration.Builder().setDnsServers(r7.getDnsServers()).setDomains(r7.getDomains()).setGateway(r7.getGateway()).setIpAddress(r7.getIpAddress());
        int r3 = Integer.parseInt(getTrailingTextString(this.mNetworkPrefixLen));     // Catch: Throwable -> L23 IllegalArgumentException -> L25 NumberFormatException -> L27
        if (r3 >= 0) goto L17;
    L21:
        this.mStaticIpConfiguration = r8.build();
        return R.string.wifi_ip_settings_invalid_network_prefix_length;
    L17:
        if (r3 > 32) goto L21;
        r8.setIpAddress(new LinkAddress(r2, r3));     // Catch: Throwable -> L23 IllegalArgumentException -> L25 NumberFormatException -> L27
    L28:
        String r4 = getTrailingTextString(this.mGateway);     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r4) == true) goto L62;
        Inet4Address r5 = getIPv4Address(r4);     // Catch: Throwable -> L23
        if (r5 != null) goto L38;
    L35:
        this.mStaticIpConfiguration = r8.build();
        return R.string.wifi_ip_settings_invalid_gateway;
    L38:
        if (r5.isMulticastAddress() == true) goto L35;
        r8.setGateway(r5);     // Catch: Throwable -> L23
    L41:
        String r6 = getTrailingTextString(this.mDNS1);     // Catch: Throwable -> L23
        ArrayList r9 = new ArrayList();     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r6) == false) goto L44;
        setTailText(this.mDNS1, this.mContext.getString(R.string.wifi_dns1_hint));     // Catch: Throwable -> L23
    L49:
        String r10 = getTrailingTextString(this.mDNS2);     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r10) == true) goto L55;
        Inet4Address r11 = getIPv4Address(r10);     // Catch: Throwable -> L23
        if (r11 == null) goto L46;
        r9.add(r11);     // Catch: Throwable -> L23
    L46:
        this.mStaticIpConfiguration = r8.build();
        return R.string.wifi_ip_settings_invalid_dns;
    L55:
        r8.setDnsServers(r9);     // Catch: Throwable -> L23
        this.mStaticIpConfiguration = r8.build();
        return 0;
    L44:
        Inet4Address r12 = getIPv4Address(r6);     // Catch: Throwable -> L23
        if (r12 == null) goto L46;
        r9.add(r12);     // Catch: Throwable -> L23
        goto L49
    L62:
        byte[] r13 = NetUtils.getNetworkPart(r2, r3).getAddress();     // Catch: Throwable -> L23 Throwable -> L61
        r13[r13.length - 1] = 1;     // Catch: Throwable -> L23 Throwable -> L61
        this.mGateway.setEndDetailText(InetAddress.getByAddress(r13).getHostAddress());     // Catch: Throwable -> L23 Throwable -> L61
        goto L41
    L23:
        th = move-exception;
        this.mStaticIpConfiguration = r8.build();
        throw th;
    L27:
        setTailText(this.mNetworkPrefixLen, this.mContext.getString(R.string.wifi_network_prefix_length_hint));     // Catch: Throwable -> L23
        r3 = Integer.parseInt(getTrailingTextString(this.mNetworkPrefixLen));     // Catch: Throwable -> L23
    L25:
        this.mStaticIpConfiguration = r8.build();
        return R.string.wifi_ip_settings_invalid_ip_address;
    }

    private String getTrailingTextString(OCardListItem r1) {
        View r0 = r1.getCustomEndView();
        if ((r0 instanceof TextView) == true) goto L5;
        return "";
    L5:
        return ((TextView) r0).getText().toString();
    }

    private Inet4Address getIPv4Address(String r1) {
        return (Inet4Address) NetworkUtils.numericToInetAddress(r1);
    L5:
        return null;
    }

    private void showIpConfigFields() {
        AccessPoint r0 = this.mAccessPoint;
        if (r0 == null) goto L5;
        WifiConfiguration r1 = r0.getConfig();
    L6:
        if (r1 == null) goto L22;
        StaticIpConfiguration r2 = r1.getIpConfiguration().getStaticIpConfiguration();
        if (r2 != null) goto L10;
        return;
    L10:
        if (r2.ipAddress == null) goto L13;
        setTailText(this.mIpAddress, r2.ipAddress.getAddress().getHostAddress());
        setTailText(this.mNetworkPrefixLen, Integer.toString(r2.ipAddress.getNetworkPrefixLength()));
    L13:
        if (r2.gateway == null) goto L15;
        setTailText(this.mGateway, r2.gateway.getHostAddress());
    L15:
        Iterator r3 = r2.dnsServers.iterator();
        if (r3.hasNext() == false) goto L19;
        setTailText(this.mDNS1, ((InetAddress) r3.next()).getHostAddress());
    L19:
        if (r3.hasNext() == false) goto L24;
        setTailText(this.mDNS2, ((InetAddress) r3.next()).getHostAddress());
        return;
    L24:
        return;
    L22:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private void setTailText(OCardListItem r1, String r2) {
        r1.setEndDetailText(r2);
    }

    private void showProxyFields() {
        AccessPoint r0 = this.mAccessPoint;
        if (r0 == null) goto L5;
        WifiConfiguration r1 = r0.getConfig();
    L6:
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.getIpConfiguration().getProxySettings() != IpConfiguration.ProxySettings.STATIC) goto L16;
        setProxyMode(1);
        if (r1 == null) goto L24;
        ProxyInfo r2 = r1.getHttpProxy();
        if (r2 == null) goto L25;
        setTailText(this.mProxyHostname, r2.getHost());
        setTailText(this.mProxyPort, Integer.toString(r2.getPort()));
        setTailText(this.mProxyExclusionlist, ProxyUtils.exclusionListAsString(r2.getExclusionList()));
        return;
    L25:
        return;
    L24:
        return;
    L16:
        if (r1.getIpConfiguration().getProxySettings() != IpConfiguration.ProxySettings.PAC) goto L22;
        setProxyMode(2);
        if (r1 == null) goto L27;
        ProxyInfo r3 = r1.getHttpProxy();
        if (r3 == null) goto L28;
        this.mProxyPac.setSubTitle(r3.getPacFileUrl().toString());
        return;
    L28:
        return;
    L27:
        return;
    L22:
        setProxyMode(0);
        return;
    L5:
        r1 = null;
        goto L6
    }

    private void setManualProxyVisible(boolean r1) {
        if (r1 == false) goto L4;
        int r2 = 0;
    L5:
        this.mProxyManualContainer.setVisibility(r2);
        return;
    L4:
        r2 = 8;
        goto L5
    }

    private void setAutoProxyVisible(boolean r1) {
        if (r1 == false) goto L4;
        this.mProxyPacContainer.setVisibility(0);
        return;
    L4:
        this.mProxyPacContainer.setVisibility(8);
    }

    private void setProxyMode(int r4) {
        if (r4 != 0) goto L5;
        setManualProxyVisible(false);
        setAutoProxyVisible(false);
        this.mProxyMode.setCardPosition(0);
        this.mProxyMode.setEndDetailText(this.mContext.getString(R.string.proxy_setting_summary_none));
        this.mProxySettings = IpConfiguration.ProxySettings.NONE;
        return;
    L5:
        if (r4 != 1) goto L7;
        this.mProxyMode.setCardPosition(1);
        setManualProxyVisible(true);
        setAutoProxyVisible(false);
        this.mProxyMode.setEndDetailText(this.mContext.getString(R.string.proxy_setting_summary_manual));
        this.mProxySettings = IpConfiguration.ProxySettings.STATIC;
        return;
    L7:
        if (r4 != 2) goto L15;
        this.mProxyMode.setCardPosition(1);
        setManualProxyVisible(false);
        setAutoProxyVisible(true);
        this.mProxyMode.setEndDetailText(this.mContext.getString(R.string.proxy_setting_summary_pac));
        this.mProxySettings = IpConfiguration.ProxySettings.PAC;
        return;
    }

    private View createDialogView() {
        String r0 = this.mProxyPac.getSubTitle().toString();
        View r1 = LayoutInflater.from(this.mContext).inflate(R.layout.dialog_edittext, null);
        OEditText r2 = ((OInputView) r1.findViewById(R.id.edittext)).getVInput();
        this.mEditor = r2;
        r2.addTextChangedListener(new AnonymousClass2(this));
        this.mEditor.setInputType(1);
        this.mEditor.setSingleLine();
        this.mEditor.setText(r0);
        this.mEditor.setSelection(0, r0.length());
        return r1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r8) {
        if (com.android.settings.Utils.isFastDoubleClick() == false) goto L6;
        return;
    L6:
        if ((r8 instanceof OListItemSettings) == false) goto L30;
        Object r0 = r8.getTag();
        if (r0 != null) goto L10;
        return;
    L10:
        final OListItemSettings r9 = (OListItemSettings) r8;
        CharSequence r1 = r9.getTitleString();
        if (r1 != null) goto L13;
        return;
    L13:
        Integer r2 = (Integer) r0;
        final boolean r4 = true;
        if (r2.intValue() != 12) goto L16;
        final boolean r3 = true;
    L18:
        if (r2.intValue() == 19) goto L21;
        r4 = false;
    L21:
        if (r3 == true) goto L25;
        if (r4 == true) goto L25;
        CharSequence r5 = r9.getTrailingTextString();
    L26:
        AccessPointEditorDialogFragment r6 = new AccessPointEditorDialogFragment();
        r6.init(r2.intValue(), r1, r5, new AnonymousClass3(this, r3, r4, r9));
        FragmentManager r7 = ((BaseActivity) this.mContext).getSupportFragmentManager();
        if (r7.isStateSaved() == false) goto L29;
        return;
    L29:
        r6.show(r7, r1.toString());
        return;
    L25:
        r5 = r9.getSubTitleString();
        goto L26
    L16:
        r3 = false;
        goto L18
    L30:
        OCardListItem r10 = findAncestors(r8);
        if (r10 == null) goto L35;
        handleClickItem(r10);
        return;
    }

    private OCardListItem findAncestors(View r2) {
        Iterator<ViewParent> r1 = ViewKt.getAncestors(r2).iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        ViewParent r3 = r1.next();
        if ((r3 instanceof OCardListItem) == false) goto L4;
        return (OCardListItem) r3;
    L9:
        return null;
    }

    private void handleClickItem(final OCardListItem r13) {
        Object r0 = r13.getTag();
        if (r0 != null) goto L5;
        return;
    L5:
        CharSequence r1 = r13.getTitle();
        if (r1 != null) goto L8;
        return;
    L8:
        Integer r2 = (Integer) r0;
        if (r2.intValue() != 12) goto L11;
        final boolean r8 = true;
    L13:
        if (r2.intValue() != 19) goto L15;
        final boolean r9 = true;
    L16:
        final OTextView r11 = (OTextView) r13.getCustomEndView();
        if (r8 == true) goto L21;
        if (r9 == true) goto L21;
        CharSequence r3 = r11.getText();
    L22:
        AccessPointEditorDialogFragment r4 = new AccessPointEditorDialogFragment();
        r4.init(r2.intValue(), r1, r3, new AnonymousClass4(this, r8, r9, r13, r11));
        FragmentManager r12 = ((BaseActivity) this.mContext).getSupportFragmentManager();
        if (r12.isStateSaved() == false) goto L25;
        return;
    L25:
        r4.show(r12, r1.toString());
        return;
    L21:
        r3 = r13.getSubTitle();
        goto L22
    L15:
        r9 = false;
        goto L16
    L11:
        r8 = false;
        goto L13
    }

    public static void setChildrenAlpha(OCardListItem r1, boolean r2) {
        View r3 = r1.findViewById(R.id.content_container);
        if (r3 == null) goto L6;
        r3.setEnabled(r2);
        return;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r1, boolean r2) {
        setStaticIpFieldsEnableState(r2);
    }

    private void promptConfigInvaild() {
        new OAlertDialogBuilder(this.mContext).autoDismiss(false).horizontalButton(true).title(R.string.wifi_save_PoxyAndIp_erro_title).message(R.string.wifi_save_PoxyAndIp_erro_msg).positiveButton(R.string.wifi_save_PoxyAndIp_erro_ok, new AnonymousClass6(this)).negativeButton(R.string.wifi_save_PoxyAndIp_erro_cancel, new AnonymousClass5(this)).show();
    }

    void onKeyDown() {
        savePoxyAndIpConfiguration();
    }

    public void savePoxyAndIpConfiguration() {
        if (ipAndProxyFieldsAreValid() == true) goto L5;
        promptConfigInvaild();
        return;
    L5:
        View.OnClickListener r0 = this.mListener;
        if (r0 == null) goto L8;
        r0.onClick(null);
    L8:
        DismissListener r2 = this.mDismissListener;
        if (r2 == null) goto L13;
        r2.dismiss(true);
        return;
    }

    public void setDismissListener(DismissListener r1) {
        this.mDismissListener = r1;
    }
}
