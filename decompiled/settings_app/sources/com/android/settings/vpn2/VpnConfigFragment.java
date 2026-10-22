package com.android.settings.vpn2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.VpnManager;
import android.os.Bundle;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.security.LegacyVpnProfileStore;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ScrollView;
import androidx.fragment.app.FragmentActivity;
import com.android.internal.net.LegacyVpnInfo;
import com.android.internal.net.VpnProfile;
import com.android.settings.AdaptUtils;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.VpnAdvancedOptionsActivity;
import com.android.settings.applications.utils.Item;
import com.android.settings.applications.utils.OPopoverHelper;
import com.android.settings.base.BaseFragment;
import com.android.settings.bluetooth.Utf8ByteLengthFilter;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.AndroidKeystoreAliasLoader;
import com.android.settings.utils.HanziToPinyin;
import com.android.settings.utils.UIUtils;
import com.android.vcard.VCardConfig;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.selection.OSelectionPanelView;
import com.obric.oui.selection.OSingleSelectionPanelView;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.titlebar.OCTitleBar;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class VpnConfigFragment extends BaseFragment implements TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    public static final String EXTRA_DNS_SERVERS = "extra_dns_servers";
    public static final String EXTRA_ROUTES = "extra_routes";
    public static final String EXTRA_SEARCH_DOMAINS = "extra_search_domains";
    static final String TAG = "VpnConfigFragment";
    private static final int VPN_NAME_MAX_LENGTH_BYTES = 90;
    private final String VPN_CONNECTED_INFO_CHANGE;
    private AdvancedOptions mAdvancedOptions;
    private List<String> mAllowedTypes;
    private LegacyVpnInfo mConnectedLegacyVpn;
    private OButton mDeleteBtn;
    private OAlertDialog mDeleteDialog;
    private String[] mIpsecCaCert;
    private int mIpsecCaCertIndex;
    private OInsetSheet mIpsecCaCertIndexChooser;
    private OCardListItem mIpsecCaCertItem;
    private OPopover mIpsecCaCertPopover;
    private OInputLayout mIpsecIdentifier;
    private OInputLayout mIpsecSecret;
    private String[] mIpsecServerCert;
    private int mIpsecServerCertIndex;
    private OInsetSheet mIpsecServerCertIndexChooser;
    private OCardListItem mIpsecServerCertItem;
    private OPopover mIpsecServerCertPopover;
    private String[] mIpsecUserCert;
    private int mIpsecUserCertIndex;
    private OInsetSheet mIpsecUserCertIndexChooser;
    private OCardListItem mIpsecUserCertItem;
    private OPopover mIpsecUserCertPopover;
    private boolean mIsAddVpn;
    private OInputLayout mL2tpSecret;
    private CheckBox mMppe;
    private OInputLayout mName;
    private OInputLayout mPassword;
    private VpnProfile mProfile;
    private View mRightBtn;
    private CheckBox mSaveLogin;
    private OInputLayout mServer;
    private OSectionSupportiveText mTipsAlwaysOnFailed;
    private List<String> mTotalTypes;
    private String[] mType;
    private OInsetSheet mTypeChooser;
    private int mTypeIndex;
    private OCardListItem mTypeItem;
    private OPopover mTypePopover;
    private OInputLayout mUsername;
    private View mView;
    private OCardListItem mViewSwitchAlwaysOn;
    private OSwitch mViewSwitchAlwaysOnSwitch;
    private ScrollView mVpnConfigRootView;
    private VpnManager mVpnManager;
    private String unspecifiedIpsecCaCert;
    private String unspecifiedIpsecServerCert;
    private String unspecifiedIpsecUserCert;

    class AdvancedOptions {
        String dnsServers;
        String routes;
        String searchDomains;
        final /* synthetic */ VpnConfigFragment this$0;

        AdvancedOptions(VpnConfigFragment r1) {
            this.this$0 = r1;
            this.searchDomains = "";
            this.dnsServers = "";
            this.routes = "";
        }
    }

    private boolean requiresUsernamePassword(int r1) {
        if (r1 != 7) goto L5;
        return false;
    L5:
        if (r1 == 8) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r1, boolean r2) {
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_vpn2_VpnConfigFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_vpn2_VpnConfigFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public VpnConfigFragment() {
        this.VPN_CONNECTED_INFO_CHANGE = "settings.vpn2.VPN_CONNECTED_INFO_CHANGE";
        this.unspecifiedIpsecCaCert = "";
        this.unspecifiedIpsecUserCert = "";
        this.unspecifiedIpsecServerCert = "";
    }

    static /* synthetic */ void access$000(VpnConfigFragment r0) {
        r0.CheckVpnConfigInfo();
    }

    static /* synthetic */ OAlertDialog access$100(VpnConfigFragment r0) {
        return r0.mDeleteDialog;
    }

    public void com_android_settings_vpn2_VpnConfigFragment__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        this.mVpnManager = (VpnManager) this.mContext.getSystemService("vpn_management");
        this.mProfile = getActivity().getIntent().getParcelableExtra(VpnSettings.EXTRA_VPN_PROFILE);
        this.mIsAddVpn = getActivity().getIntent().getBooleanExtra(VpnSettings.EXTRA_IS_ADD_VPN, false);
        AdvancedOptions r4 = new AdvancedOptions(this);
        this.mAdvancedOptions = r4;
        r4.searchDomains = this.mProfile.searchDomains;
        AdvancedOptions r5 = this.mAdvancedOptions;
        r5.dnsServers = this.mProfile.dnsServers;
        AdvancedOptions r6 = this.mAdvancedOptions;
        r6.routes = this.mProfile.routes;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        View r8 = r5.inflate(R.layout.vpn_config_fragment, r6, false);
        this.mView = r8;
        this.mRootView = r8;
        this.mVpnConfigRootView = (ScrollView) this.mView.findViewById(R.id.page_scrollview);
        OInputLayout r9 = (OInputLayout) ((OCardListItem) this.mView.findViewById(R.id.name)).getCustomStartView();
        this.mName = r9;
        r9.setHint(getString(R.string.vpn_name_hint));
        this.mName.setLabel(getString(R.string.vpn_name));
        this.mName.showLabel(true);
        this.mName.setInputType(8193);
        this.mName.setMaxLines(1);
        this.mName.setLimitCount(32);
        this.mName.showClear(true);
        this.mType = removeLegacyType();
        if (this.mIsAddVpn == false) goto L5;
        this.mProfile.type = convertAllowedIndexToProfileType(0);
    L5:
        OCardListItem r10 = (OCardListItem) this.mView.findViewById(R.id.server);
        int r1 = getResources().getDimensionPixelSize(R.dimen.dimen_32);
        r10.customDivider(r1, r1);
        r10.showDivider(true);
        OInputLayout r11 = (OInputLayout) r10.getCustomStartView();
        this.mServer = r11;
        r11.setHint(getString(R.string.vpn_server_hint));
        this.mServer.setLabel(getString(R.string.vpn_server));
        this.mServer.showLabel(true);
        this.mServer.setInputType(1);
        this.mServer.setMaxLines(1);
        this.mServer.setLimitCount(32);
        this.mServer.showClear(true);
        OCardListItem r12 = (OCardListItem) this.mView.findViewById(R.id.username);
        r12.customDivider(r1, r1);
        r12.showDivider(true);
        OInputLayout r13 = (OInputLayout) r12.getCustomStartView();
        this.mUsername = r13;
        r13.setHint(getString(R.string.vpn_username_hint));
        this.mUsername.setLabel(getString(R.string.vpn_username));
        this.mUsername.showLabel(true);
        this.mUsername.setInputType(1);
        this.mUsername.setMaxLines(1);
        this.mUsername.setLimitCount(32);
        this.mUsername.showClear(true);
        OCardListItem r14 = (OCardListItem) this.mView.findViewById(R.id.password);
        r14.customDivider(r1, r1);
        r14.showDivider(true);
        OInputLayout r15 = (OInputLayout) r14.getCustomStartView();
        this.mPassword = r15;
        r15.setHint(getString(R.string.vpn_password_hint));
        this.mPassword.setLabel(getString(R.string.vpn_password));
        this.mPassword.showLabel(true);
        this.mPassword.setInputType(128);
        this.mPassword.setMaxLines(1);
        this.mPassword.setLimitCount(64);
        this.mPassword.showEyes(true);
        this.mMppe = (CheckBox) this.mView.findViewById(R.id.mppe);
        OCardListItem r16 = (OCardListItem) this.mView.findViewById(R.id.l2tp_secret);
        r16.customDivider(r1, r1);
        r16.showDivider(true);
        OInputLayout r17 = (OInputLayout) r16.getCustomStartView();
        this.mL2tpSecret = r17;
        r17.setHint(getString(R.string.vpn_not_used));
        this.mL2tpSecret.setLabel(getString(R.string.vpn_l2tp_secret));
        this.mL2tpSecret.showLabel(true);
        this.mL2tpSecret.setInputType(1);
        this.mL2tpSecret.setMaxLines(1);
        this.mL2tpSecret.setLimitCount(32);
        this.mL2tpSecret.showClear(true);
        OCardListItem r18 = (OCardListItem) this.mView.findViewById(R.id.ipsec_identifier);
        r18.customDivider(r1, r1);
        r18.showDivider(true);
        OInputLayout r19 = (OInputLayout) r18.getCustomStartView();
        this.mIpsecIdentifier = r19;
        r19.setHint(getString(R.string.vpn_ipsec_identifier_hint));
        this.mIpsecIdentifier.setLabel(getString(R.string.vpn_ipsec_identifier));
        this.mIpsecIdentifier.showLabel(true);
        this.mIpsecIdentifier.setInputType(1);
        this.mIpsecIdentifier.setMaxLines(1);
        this.mIpsecIdentifier.setLimitCount(32);
        this.mIpsecIdentifier.showClear(true);
        OCardListItem r20 = (OCardListItem) this.mView.findViewById(R.id.ipsec_secret);
        r20.customDivider(r1, r1);
        r20.showDivider(false);
        OInputLayout r21 = (OInputLayout) r20.getCustomStartView();
        this.mIpsecSecret = r21;
        r21.setHint(getString(R.string.vpn_ipsec_secret_hint));
        this.mIpsecSecret.setLabel(getString(R.string.vpn_ipsec_secret));
        this.mIpsecSecret.showLabel(true);
        this.mIpsecSecret.setInputType(1);
        this.mIpsecSecret.setMaxLines(1);
        this.mIpsecSecret.setLimitCount(32);
        this.mIpsecSecret.showClear(true);
        this.mSaveLogin = (CheckBox) this.mView.findViewById(R.id.save_login);
        this.mDeleteBtn = (OButton) this.mView.findViewById(R.id.delete_btn);
        final OCardListItem r22 = (OCardListItem) this.mView.findViewById(R.id.advanced_options);
        r22.setOnContentClickListener(new VpnConfigFragment$$ExternalSyntheticLambda2(this, r22));
        this.mViewSwitchAlwaysOn = (OCardListItem) this.mView.findViewById(R.id.item_vpn_always_on);
        this.mTipsAlwaysOnFailed = (OSectionSupportiveText) this.mView.findViewById(R.id.tips_vpn_always_on_failed);
        this.mViewSwitchAlwaysOnSwitch = (OSwitch) this.mViewSwitchAlwaysOn.getCustomEndView();
        if (SystemProperties.getBoolean("persist.radio.imsregrequired", false) == false) goto L8;
        this.mViewSwitchAlwaysOn.setVisibility(8);
    L8:
        this.unspecifiedIpsecUserCert = getActivity().getString(R.string.vpn_no_user_cert);
        this.unspecifiedIpsecCaCert = getActivity().getString(R.string.vpn_no_ca_cert);
        this.unspecifiedIpsecServerCert = getActivity().getString(R.string.vpn_no_server_cert);
        this.mName.setText(this.mProfile.name);
        this.mName.getVInput().setSelection(this.mProfile.name.length());
        this.mName.getVInput().requestFocus();
        this.mServer.setText(this.mProfile.server);
        if (this.mProfile.saveLogin == false) goto L11;
        this.mUsername.setText(this.mProfile.username);
        this.mPassword.setText(this.mProfile.password);
    L11:
        this.mL2tpSecret.setText(this.mProfile.l2tpSecret);
        this.mIpsecIdentifier.setText(this.mProfile.ipsecIdentifier);
        this.mIpsecSecret.setText(this.mProfile.ipsecSecret);
        this.mName.getVInput().setFilters(new InputFilter[]{new Utf8ByteLengthFilter(90)});
        this.mName.getVInput().addTextChangedListener(this);
        this.mServer.getVInput().addTextChangedListener(this);
        this.mUsername.getVInput().addTextChangedListener(this);
        this.mPassword.getVInput().addTextChangedListener(this);
        this.mIpsecSecret.getVInput().addTextChangedListener(this);
        this.mIpsecIdentifier.getVInput().addTextChangedListener(this);
        OCardListItem r23 = (OCardListItem) this.mView.findViewById(R.id.type);
        this.mTypeItem = r23;
        r23.showTailIcon(true);
        this.mTypeItem.setOnContentClickListener(new VpnConfigFragment$$ExternalSyntheticLambda3(this));
        this.mTypeItem.setDefaultCustomEndView(3);
        this.mTypeItem.showCustomEnd(true);
        List<String> r24 = this.mAllowedTypes;
        if (r24 == null) goto L16;
        List<String> r2 = this.mTotalTypes;
        if (r2 == null) goto L16;
        this.mTypeIndex = r24.indexOf(r2.get(this.mProfile.type));
    L17:
        OCardListItem r25 = (OCardListItem) this.mView.findViewById(R.id.ipsec_ca_cert);
        this.mIpsecCaCertItem = r25;
        r25.setDefaultCustomEndView(3);
        this.mIpsecCaCertItem.showCustomEnd(true);
        this.mIpsecCaCertItem.showTailIcon(true);
        this.mIpsecCaCertItem.setOnContentClickListener(new VpnConfigFragment$$ExternalSyntheticLambda4(this));
        OCardListItem r26 = (OCardListItem) this.mView.findViewById(R.id.ipsec_user_cert);
        this.mIpsecUserCertItem = r26;
        r26.showTailIcon(true);
        this.mIpsecUserCertItem.setDefaultCustomEndView(3);
        this.mIpsecUserCertItem.showCustomEnd(true);
        this.mIpsecUserCertItem.setOnContentClickListener(new VpnConfigFragment$$ExternalSyntheticLambda5(this));
        OCardListItem r27 = (OCardListItem) this.mView.findViewById(R.id.ipsec_server_cert);
        this.mIpsecServerCertItem = r27;
        r27.showTailIcon(true);
        this.mIpsecServerCertItem.setDefaultCustomEndView(3);
        this.mIpsecServerCertItem.showCustomEnd(true);
        this.mIpsecServerCertItem.setOnContentClickListener(new VpnConfigFragment$$ExternalSyntheticLambda6(this));
        AndroidKeystoreAliasLoader r28 = new AndroidKeystoreAliasLoader(null);
        loadCertificates("USRPKEY_", r28.getKeyCertAliases(), this.unspecifiedIpsecUserCert, this.mProfile.ipsecUserCert);
        this.mIpsecUserCertItem.setEndDetailText(this.mProfile.ipsecUserCert);
        loadCertificates("CACERT_", r28.getCaCertAliases(), this.unspecifiedIpsecCaCert, this.mProfile.ipsecCaCert);
        this.mIpsecCaCertItem.setEndDetailText(this.mProfile.ipsecCaCert);
        loadCertificates("USRCERT_", r28.getKeyCertAliases(), this.unspecifiedIpsecServerCert, this.mProfile.ipsecServerCert);
        this.mIpsecServerCertItem.setEndDetailText(this.mProfile.ipsecServerCert);
        this.mView.findViewById(R.id.editor).setVisibility(0);
        changeType(this.mProfile.type);
        updateAlwaysOnUIState();
        if (this.mIsAddVpn == false) goto L20;
        this.mDeleteBtn.setVisibility(8);
        this.mView.findViewById(R.id.delete_btn_top_gap).setVisibility(8);
    L22:
        return this.mView;
    L20:
        getActivity().getWindow().setSoftInputMode(2);
        this.mDeleteBtn.setVisibility(0);
        this.mDeleteBtn.setOnClickListener(this);
        this.mView.findViewById(R.id.delete_btn_top_gap).setVisibility(0);
    L16:
        OLog.w(TAG, "Allowed or Total vpn types not initialized when setting initial selection");
        goto L17
    }

    /* JADX INFO: renamed from: lambda$onCreateView$0$com-android-settings-vpn2-VpnConfigFragment, reason: not valid java name */
    /* synthetic */ void m636xfade8c7c(OCardListItem r1, View r2) {
        onClick(r1);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$1$com-android-settings-vpn2-VpnConfigFragment, reason: not valid java name */
    /* synthetic */ void m637x957f4efd(View r1) {
        onClick(this.mTypeItem);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$2$com-android-settings-vpn2-VpnConfigFragment, reason: not valid java name */
    /* synthetic */ void m638x3020117e(View r1) {
        onClick(this.mIpsecCaCertItem);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$3$com-android-settings-vpn2-VpnConfigFragment, reason: not valid java name */
    /* synthetic */ void m639xcac0d3ff(View r1) {
        onClick(this.mIpsecUserCertItem);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$4$com-android-settings-vpn2-VpnConfigFragment, reason: not valid java name */
    /* synthetic */ void m640x65619680(View r1) {
        onClick(this.mIpsecServerCertItem);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        this.mTitleView.setEndButtonGroupStyle(2132018095);
        if (Utils.hasExtraSafely(getIntent(), "title") == false) goto L7;
        String r5 = Utils.getStringExtraSafely(getIntent(), "title");
        if (TextUtils.isEmpty(r5) == true) goto L7;
        setTitle(r5);
    L7:
        View r6 = this.mTitleView.addEndAction(getString(R.string.menu_save), -1, null);
        this.mRightBtn = r6;
        r6.setOnClickListener(new AnonymousClass1(this));
        this.mTitleView.removeStartAction();
        this.mTitleView.addStartAction(R.drawable.settings_ext_oui_icon_oic_xmark, -1, new VpnConfigFragment$$ExternalSyntheticLambda0(this));
        this.mBackView.setOnClickListener(new AnonymousClass2(this));
        if (this.mBackView == null) goto L13;
        if ((this.mBackView instanceof OButton) == false) goto L13;
        ((OButton) this.mBackView).setButtonSourceBitmap(R.drawable.settings_oic_close);
    L13:
        if (validate() == false) goto L15;
        this.mRightBtn.setEnabled(true);
    L16:
        UIUtils.setUpBottomPaddingOnApplyWindowInsets(findViewByIdNullable(R.id.page_container));
        return;
    L15:
        this.mRightBtn.setEnabled(false);
        goto L16
    }

    /* JADX INFO: renamed from: lambda$onViewCreated$5$com-android-settings-vpn2-VpnConfigFragment, reason: not valid java name */
    /* synthetic */ void m641xee287bcb(View r1) {
        finish();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r3) {
        super.onViewStateRestored(r3);
        this.mViewSwitchAlwaysOnSwitch.setOnCheckedChangeListener(this);
        this.mViewSwitchAlwaysOnSwitch.setChecked(this.mProfile.key.equals(VpnUtils.getLockdownVpn()));
        this.mMppe.setChecked(this.mProfile.mppe);
        this.mSaveLogin.setChecked(this.mProfile.saveLogin);
    }

    private void CheckVpnConfigInfo() {
        if (validate() == false) goto L5;
        saveVpn();
        finish();
        return;
    L5:
        promptConfigInvalid();
    }

    private void saveVpn() {
        VpnProfile r0 = getProfile();
        r0.saveLogin = true;
        LegacyVpnProfileStore.put("VPN_" + r0.key, r0.encode());
        boolean r1 = VpnUtils.isVpnLockdown(r0.key);
        boolean r2 = isVpnAlwaysOn();
        if (r1 == r2) goto L5;
        updateLockdownVpn(r2, r0.key);
    L5:
        LegacyVpnInfo r3 = this.mVpnManager.getLegacyVpnInfo(UserHandle.myUserId());
        if (r3 != null) goto L8;
        return;
    L8:
        if (r0.key.equals(r3.key) == true) goto L10;
        return;
    L10:
        if (r3.state == 3) goto L14;
        if (r3.state == 2) goto L14;
        return;
    L14:
        if (r3.state != 3) goto L16;
        SystemProperties.set("sys.net.connectedVPN", r0.name);
    L16:
        sendBroadcast(new Intent("settings.vpn2.VPN_CONNECTED_INFO_CHANGE"));
    }

    private void promptConfigInvalid() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L6;
        OLog.e(TAG, "promptConfigInvalid, activity is null, return");
        return;
    L6:
        new OAlertDialogBuilder(r0).autoDismiss(false).horizontalButton(true).title(R.string.vpn_config_info_save_erro_title).message(R.string.vpn_config_info_save_erro_msg).positiveButton(R.string.vpn_config_info_save_erro_ok, new AnonymousClass4(this)).negativeButton(R.string.vpn_config_info_save_erro_cancel, new AnonymousClass3(this)).show();
    }

    @Override // com.android.settings.base.BaseFragment
    public boolean onKeyDown(int r2, KeyEvent r3) {
        if (r2 == 4) goto L5;
    L11:
        return false;
    L5:
        if (getIntent().getBooleanExtra(VpnSettings.EXTRA_IS_ADD_VPN, false) == true) goto L7;
        CheckVpnConfigInfo();
        goto L11
    L7:
        if (vpnInfoHasChanged() == true) goto L9;
        finish();
        goto L11
    L9:
        CheckVpnConfigInfo();
        goto L11
    }

    private String[] removeLegacyType() {
        String[] r0 = getActivity().getResources().getStringArray(R.array.vpn_types);
        this.mTotalTypes = new ArrayList(Arrays.asList(r0));
        ArrayList r1 = new ArrayList(Arrays.asList(r0));
        this.mAllowedTypes = r1;
        int r2 = r1.size() - 1;
    L3:
        if (r2 < 0) goto L9;
        if (VpnProfile.isLegacyType(r2) == false) goto L7;
        this.mAllowedTypes.remove(r2);
    L7:
        r2 = r2 - 1;
        goto L3
    L9:
        return (String[]) this.mAllowedTypes.toArray(new String[0]);
    }

    private int convertAllowedIndexToProfileType(int r3) {
        List<String> r0 = this.mAllowedTypes;     // Catch: Exception -> L10
        if (r0 != null) goto L5;
    L8:
        OLog.w(TAG, "Allowed or Total vpn types not initialized when converting protileType");     // Catch: Exception -> L10
        return r3;
    L5:
        if (this.mTotalTypes == null) goto L8;
        String r4 = r0.get(r3);     // Catch: Exception -> L10
        return this.mTotalTypes.indexOf(r4);
    L10:
        return 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        if (r3 == null) goto L14;
        AdvancedOptions r4 = this.mAdvancedOptions;
        r4.searchDomains = r3.getStringExtra(EXTRA_SEARCH_DOMAINS);
        String r5 = r3.getStringExtra(EXTRA_DNS_SERVERS);
        if (r5 != null) goto L7;
    L9:
        String r6 = r3.getStringExtra(EXTRA_ROUTES);
        if (r6 == null) goto L14;
        if (validateAddresses(r6, true) == false) goto L14;
        this.mAdvancedOptions.routes = r6;
        goto L14
    L7:
        if (validateAddresses(r5, false) == false) goto L9;
        this.mAdvancedOptions.dnsServers = r5;
    L14:
        updateAlwaysOnUIState();
        updateSaveButtonState();
    }

    boolean vpnInfoHasChanged() {
        int r0 = convertAllowedIndexToProfileType(this.mTypeIndex);
        if (this.mName.getVInput().getText().length() == 0) goto L5;
        return true;
    L5:
        if (this.mServer.getVInput().getText().length() == 0) goto L7;
        return true;
    L7:
        if (this.mUsername.getVInput().getText().length() == 0) goto L9;
        return true;
    L9:
        if (this.mPassword.getVInput().getText().length() == 0) goto L11;
        return true;
    L11:
        if (TextUtils.isEmpty(this.mAdvancedOptions.dnsServers) == true) goto L13;
        return true;
    L13:
        if (TextUtils.isEmpty(this.mAdvancedOptions.routes) == true) goto L15;
        return true;
    L15:
        if (TextUtils.isEmpty(this.mAdvancedOptions.searchDomains) == false) goto L26;
        if (r0 != 0) goto L27;
        return false;
    L27:
        return true;
    L26:
        return true;
    }

    public boolean validate() {
        if (this.mName.getVInput().getText().length() != 0) goto L5;
    L27:
        return false;
    L5:
        if (this.mServer.getVInput().getText().length() == 0) goto L27;
        if (validateAddresses(this.mAdvancedOptions.dnsServers, false) == false) goto L27;
        if (validateAddresses(this.mAdvancedOptions.routes, true) == false) goto L27;
        int r0 = convertAllowedIndexToProfileType(this.mTypeIndex);
        if (VpnProfile.isLegacyType(this.mProfile.type) == false) goto L14;
    L16:
        switch(r0) {
            case 0: goto L26;
            case 1: goto L23;
            case 2: goto L19;
            case 3: goto L23;
            case 4: goto L19;
            case 5: goto L26;
            case 6: goto L26;
            case 7: goto L23;
            case 8: goto L19;
            default: goto L17;
        };
    L17:
        return false;
    L26:
        return true;
    L19:
        if (this.mIpsecUserCertIndex != 0) goto L21;
        return false;
    L21:
        return true;
    L23:
        if (this.mIpsecSecret.getVInput().getText().length() != 0) goto L25;
        return false;
    L25:
        return true;
    L14:
        if (this.mIpsecIdentifier.getVInput().getText().length() != 0) goto L16;
        return false;
    }

    private boolean validateAddresses(String r10, boolean r11) {
        String[] r12 = r10.split(HanziToPinyin.Token.SEPARATOR);     // Catch: Exception -> L25
        int r0 = r12.length;     // Catch: Exception -> L25
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L24;
        String r3 = r12[r1];     // Catch: Exception -> L25
        if (r3.isEmpty() == false) goto L10;
    L22:
        r1 = r1 + 1;
        goto L5
    L10:
        if (r11 == false) goto L12;
        String[] r4 = r3.split(LibrarianImpl.Constants.SEPARATOR, 2);     // Catch: Exception -> L25
        String r6 = r4[0];     // Catch: Exception -> L25
        int r7 = Integer.parseInt(r4[1]);     // Catch: Exception -> L25
        r3 = r6;
    L13:
        byte[] r5 = AdaptUtils.parseNumericAddress(r3).getAddress();     // Catch: Exception -> L25
        int r2 = (((r5[1] & 255) << 16) | (((r5[2] & 255) << 8) | (r5[3] & 255))) | ((r5[0] & 255) << 24);     // Catch: Exception -> L25
        if (r5.length != 4) goto L23;
        if (r7 < 0) goto L23;
        if (r7 > 32) goto L23;
        if (r7 >= 32) goto L22;
        if ((r2 << r7) == 0) goto L22;
    L23:
        return false;
    L12:
        r7 = 32;
        goto L13
    L24:
        return true;
    L25:
        return false;
    }

    private void loadCertificates(String r7, Collection<String> r8, String r9, String r10) {
        int r0 = 0;
        int r1 = 1;
        if (r8 != null) goto L5;
    L11:
        String[] r2 = {r9};
    L13:
        if (r1 >= r2.length) goto L19;
        if (r2[r1].equals(r10) == true) goto L16;
        r1 = r1 + 1;
        goto L13
    L16:
        r0 = r1;
    L19:
        if ("USRCERT_".equals(r7) == false) goto L26;
        this.mIpsecServerCert = r2;
        this.mIpsecServerCertIndex = r0;
        VpnProfile r6 = this.mProfile;
        if (r0 == 0) goto L24;
        r9 = r2[r0];
    L24:
        r6.ipsecServerCert = r9;
        return;
    L26:
        if ("CACERT_".equals(r7) == false) goto L33;
        this.mIpsecCaCert = r2;
        this.mIpsecCaCertIndex = r0;
        VpnProfile r11 = this.mProfile;
        if (r0 == 0) goto L31;
        r9 = r2[r0];
    L31:
        r11.ipsecCaCert = r9;
        return;
    L33:
        if ("USRPKEY_".equals(r7) == false) goto L46;
        this.mIpsecUserCert = r2;
        this.mIpsecUserCertIndex = r0;
        VpnProfile r12 = this.mProfile;
        if (r0 == 0) goto L38;
        r9 = r2[r0];
    L38:
        r12.ipsecUserCert = r9;
        return;
    L46:
        return;
    L5:
        if (r8.size() == 0) goto L11;
        r2 = new String[r8.size() + 1];
        r2[0] = r9;
        Iterator<String> r13 = r8.iterator();
        int r3 = 1;
    L9:
        if (r13.hasNext() == false) goto L13;
        r2[r3] = r13.next();
        r3 = r3 + 1;
        goto L9
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r1) {
        updateSaveButtonState();
        updateAlwaysOnUIState();
    }

    private void updateSaveButtonState() {
        this.mRightBtn.setEnabled(validate());
    }

    private void setUsernamePasswordVisibility(int r2) {
        boolean r3 = requiresUsernamePassword(r2);
        View r1 = this.mView.findViewById(R.id.user);
        if (r3 == false) goto L5;
        int r4 = 0;
    L6:
        r1.setVisibility(r4);
        return;
    L5:
        r4 = 8;
        goto L6
    }

    private void changeType(int r10) {
        this.mMppe.setVisibility(8);
        this.mView.findViewById(R.id.l2tp).setVisibility(8);
        this.mView.findViewById(R.id.ipsec_psk).setVisibility(8);
        this.mView.findViewById(R.id.ipsec_user).setVisibility(8);
        this.mView.findViewById(R.id.ipsec_peer).setVisibility(8);
        this.mView.findViewById(R.id.options_ipsec_identity).setVisibility(8);
        setUsernamePasswordVisibility(r10);
        if (VpnProfile.isLegacyType(r10) == true) goto L5;
        this.mView.findViewById(R.id.options_ipsec_identity).setVisibility(0);
    L5:
        this.mTypeItem.setEndDetailText(this.mTotalTypes.get(r10));
        OCardListItem r0 = (OCardListItem) this.mView.findViewById(R.id.ipsec_identifier);
        r0.setCardPosition(3);
        r0.showDivider(false);
        switch(r10) {
            case 0: goto L13;
            case 1: goto L11;
            case 2: goto L8;
            case 3: goto L12;
            case 4: goto L9;
            case 5: goto L10;
            case 6: goto L10;
            case 7: goto L12;
            case 8: goto L9;
            default: goto L17;
        };
    L8:
        this.mView.findViewById(R.id.l2tp).setVisibility(0);
    L9:
        this.mView.findViewById(R.id.ipsec_user).setVisibility(0);
        r0.setCardPosition(2);
        r0.showDivider(true);
    L10:
        this.mView.findViewById(R.id.ipsec_peer).setVisibility(0);
        return;
    L11:
        this.mView.findViewById(R.id.l2tp).setVisibility(0);
    L12:
        this.mView.findViewById(R.id.ipsec_psk).setVisibility(0);
        this.mView.findViewById(R.id.options_ipsec_identity).setVisibility(0);
        r0.setCardPosition(2);
        r0.showDivider(true);
        return;
    L13:
        this.mMppe.setVisibility(0);
        return;
    }

    VpnProfile getProfile() {
        VpnProfile r0 = new VpnProfile(this.mProfile.key);
        r0.name = this.mName.getVInput().getText().toString();
        r0.type = convertAllowedIndexToProfileType(this.mTypeIndex);
        r0.server = this.mServer.getVInput().getText().toString().trim();
        r0.username = this.mUsername.getVInput().getText().toString();
        r0.password = this.mPassword.getVInput().getText().toString();
        r0.searchDomains = this.mAdvancedOptions.searchDomains;
        r0.dnsServers = this.mAdvancedOptions.dnsServers;
        r0.routes = this.mAdvancedOptions.routes;
        r0.ipsecIdentifier = this.mIpsecIdentifier.getVInput().getText().toString();
        switch(r0.type) {
            case 0: goto L17;
            case 1: goto L15;
            case 2: goto L5;
            case 3: goto L16;
            case 4: goto L6;
            case 5: goto L9;
            case 6: goto L9;
            case 7: goto L16;
            case 8: goto L6;
            default: goto L18;
        };
    L5:
        r0.l2tpSecret = this.mL2tpSecret.getVInput().getText().toString();
    L6:
        int r1 = this.mIpsecUserCertIndex;
        if (r1 == 0) goto L9;
        r0.ipsecUserCert = this.mIpsecUserCert[r1];
    L9:
        int r2 = this.mIpsecCaCertIndex;
        if (r2 == 0) goto L12;
        r0.ipsecCaCert = this.mIpsecCaCert[r2];
    L12:
        int r3 = this.mIpsecServerCertIndex;
        if (r3 == 0) goto L18;
        r0.ipsecServerCert = this.mIpsecServerCert[r3];
        goto L18
    L15:
        r0.l2tpSecret = this.mL2tpSecret.getVInput().getText().toString();
    L16:
        r0.ipsecIdentifier = this.mIpsecIdentifier.getVInput().getText().toString();
        r0.ipsecSecret = this.mIpsecSecret.getVInput().getText().toString();
        goto L18
    L17:
        r0.mppe = this.mMppe.isChecked();
    L18:
        r0.saveLogin = true;
        return r0;
    }

    public void com_android_settings_vpn2_VpnConfigFragment__onResume$___twin___() {
        super.onResume();
        if (this.mIsExtDisplaying == false) goto L5;
        this.mVpnConfigRootView.setVerticalScrollBarEnabled(false);
    L5:
        this.mConnectedLegacyVpn = this.mVpnManager.getLegacyVpnInfo(UserHandle.myUserId());
        if (getIntent().getBooleanExtra(VpnSettings.EXTRA_IS_ADD_VPN, false) == false) goto L8;
        return;
    L8:
        if (isVpnProfileExist() == false) goto L10;
        return;
    L10:
        if (getActivity() == null) goto L12;
        getActivity().setIntent(null);
    L12:
        finish();
    }

    private boolean isVpnProfileExist() {
        VpnProfile r6 = getProfile();
        if (r6 != null) goto L17;
        return false;
    L17:
        String[] r1 = LegacyVpnProfileStore.list("VPN_");     // Catch: NullPointerException -> L14
        if (r1 == null) goto L16;
        int r2 = r1.length;     // Catch: NullPointerException -> L14
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L16;
        if (r1[r3].equals(r6.key) == true) goto L11;
        r3 = r3 + 1;
        goto L8
    L11:
        return true;
    L16:
        return false;
    L14:
        e = move-exception;
        OLog.e(TAG, "e" + e);
        goto L16
    }

    private void showDeleteDialog() {
        OAlertDialog r0 = this.mDeleteDialog;
        if (r0 != null) goto L5;
        this.mDeleteDialog = new OAlertDialogBuilder(requireActivity()).horizontalButton(true).negativeButton(getString(R.string.cancel), new AnonymousClass5(this)).positiveButton(R.string.delete_vpn_done, new VpnConfigFragment$$ExternalSyntheticLambda7(this)).title(R.string.delete_vpn_title).build();
    L8:
        this.mDeleteDialog.show();
        return;
    L5:
        if (r0.isShowing() == false) goto L8;
    }

    /* JADX INFO: renamed from: lambda$showDeleteDialog$6$com-android-settings-vpn2-VpnConfigFragment, reason: not valid java name */
    /* synthetic */ void m642x1d2f5e72(DialogInterface r1, int r2) {
        disconnect(this.mProfile.key);
        LegacyVpnProfileStore.remove("VPN_" + this.mProfile.key);
        updateLockdownVpn(false, this.mProfile.key);
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L6;
        r0.finish();
        return;
    }

    private void updateAlwaysOnUIState() {
        VpnProfile r0 = getProfile();
        if (r0.isValidLockdownProfile() == false) goto L5;
        this.mViewSwitchAlwaysOn.setEnabled(true);
        this.mTipsAlwaysOnFailed.setVisibility(8);
    L26:
        if (this.mViewSwitchAlwaysOnSwitch.isChecked() == false) goto L28;
        this.mSaveLogin.setChecked(true);
        this.mSaveLogin.setEnabled(false);
        return;
    L28:
        this.mSaveLogin.setChecked(this.mProfile.saveLogin);
        this.mSaveLogin.setEnabled(true);
        return;
    L5:
        this.mViewSwitchAlwaysOn.setEnabled(false);
        if (r0.isTypeValidForLockdown() == true) goto L9;
        this.mTipsAlwaysOnFailed.setSectionDes(getString(R.string.vpn_always_on_invalid_reason_type));
    L24:
        this.mTipsAlwaysOnFailed.setVisibility(0);
        goto L26
    L9:
        if (VpnProfile.isLegacyType(r0.type) == false) goto L14;
        if (r0.isServerAddressNumeric() == true) goto L14;
        this.mTipsAlwaysOnFailed.setSectionDes(getString(R.string.vpn_always_on_invalid_reason_server));
    L14:
        if (VpnProfile.isLegacyType(r0.type) == false) goto L19;
        if (r0.hasDns() == true) goto L19;
        this.mTipsAlwaysOnFailed.setSectionDes(getString(R.string.vpn_always_on_invalid_reason_no_dns));
    L19:
        if (VpnProfile.isLegacyType(r0.type) == true) goto L21;
    L23:
        this.mTipsAlwaysOnFailed.setSectionDes(getString(R.string.vpn_always_on_invalid_reason_other));
        goto L24
    L21:
        if (r0.areDnsAddressesNumeric() == true) goto L23;
        this.mTipsAlwaysOnFailed.setSectionDes(getString(R.string.vpn_always_on_invalid_reason_dns));
        goto L24
    }

    private boolean isServerAddressNumeric(String r1) {
        AdaptUtils.parseNumericAddress(r1);     // Catch: IllegalArgumentException -> L5
        return true;
    L5:
        return false;
    }

    public boolean isVpnAlwaysOn() {
        return this.mViewSwitchAlwaysOnSwitch.isChecked();
    }

    private OInsetSheet creatDialog(Context r6, String r7, List<OSelectionPanelView.SelectionItemData> r8, int r9, OSingleSelectionPanelView.OnItemSelectListener r10) {
        final OInsetSheet r0 = new OInsetSheet(r6);
        r0.setRootWidth(OInsetSheet.PanelWidth.NARROW_WIDTH);
        OCTitleBar r1 = new OCTitleBar(r6);
        r1.setShowLeftBack(false);
        OButton r3 = r1.createNeutralButton(r6, r1.mRightContainer);
        r3.setButtonSourceBitmap(R.drawable.o_ic_close);
        r3.setOnClickListener(new AnonymousClass6(this, r0));
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
        return r0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r7) {
        if (Utils.isFastDoubleClick() == false) goto L6;
        return;
    L6:
        switch(r7.getId()) {
            case 2131427538: goto L45;
            case 2131428344: goto L44;
            case 2131429243: goto L35;
            case 2131429248: goto L26;
            case 2131429250: goto L17;
            case 2131431537: goto L8;
            default: goto L68;
        };
    L8:
        ArrayList r8 = new ArrayList();
        int r2 = 0;
    L10:
        if (r2 >= this.mType.length) goto L16;
        String r4 = this.mType[r2];
        if (this.mTypeIndex != r2) goto L14;
        boolean r5 = true;
    L15:
        r8.add(new Item(r4, r5));
        r2 = r2 + 1;
        goto L10
    L14:
        r5 = false;
        goto L15
    L16:
        this.mTypePopover = OPopoverHelper.showPopoverList(requireActivity(), this.mTypeItem, r8, new VpnConfigFragment$$ExternalSyntheticLambda8(this), true);
        return;
    L17:
        ArrayList r9 = new ArrayList();
        int r3 = 0;
    L19:
        if (r3 >= this.mIpsecUserCert.length) goto L25;
        String r6 = this.mIpsecUserCert[r3];
        if (this.mIpsecUserCertIndex != r3) goto L23;
        boolean r10 = true;
    L24:
        r9.add(new Item(r6, r10));
        r3 = r3 + 1;
        goto L19
    L23:
        r10 = false;
        goto L24
    L25:
        OPopoverHelper r0 = OPopoverHelper.INSTANCE;
        this.mIpsecUserCertPopover = OPopoverHelper.showPopoverList(requireActivity(), this.mIpsecUserCertItem, r9, new VpnConfigFragment$$ExternalSyntheticLambda9(this), true);
        return;
    L26:
        ArrayList r11 = new ArrayList();
        int r12 = 0;
    L28:
        if (r12 >= this.mIpsecServerCert.length) goto L34;
        String r13 = this.mIpsecServerCert[r12];
        if (this.mIpsecServerCertIndex != r12) goto L32;
        boolean r14 = true;
    L33:
        r11.add(new Item(r13, r14));
        r12 = r12 + 1;
        goto L28
    L32:
        r14 = false;
        goto L33
    L34:
        this.mIpsecServerCertPopover = OPopoverHelper.showPopoverList(requireActivity(), this.mIpsecServerCertItem, r11, new VpnConfigFragment$$ExternalSyntheticLambda1(this), true);
        return;
    L35:
        ArrayList r15 = new ArrayList();
        int r16 = 0;
    L37:
        if (r16 >= this.mIpsecCaCert.length) goto L43;
        String r17 = this.mIpsecCaCert[r16];
        if (this.mIpsecCaCertIndex != r16) goto L41;
        boolean r18 = true;
    L42:
        r15.add(new Item(r17, r18));
        r16 = r16 + 1;
        goto L37
    L41:
        r18 = false;
        goto L42
    L43:
        this.mIpsecCaCertPopover = OPopoverHelper.showPopoverList(requireActivity(), this.mIpsecCaCertItem, r15, new VpnConfigFragment$$ExternalSyntheticLambda10(this), true);
        return;
    L44:
        showDeleteDialog();
        return;
    L45:
        Intent r19 = new Intent(getActivity(), VpnAdvancedOptionsActivity.class);
        if (this.mIsAddVpn == false) goto L48;
        int r1 = R.string.add_vpn_title;
    L49:
        r19.putExtra("back_text_id", r1);
        r19.putExtra(EXTRA_SEARCH_DOMAINS, this.mAdvancedOptions.searchDomains);
        r19.putExtra(EXTRA_DNS_SERVERS, this.mAdvancedOptions.dnsServers);
        r19.putExtra(EXTRA_ROUTES, this.mAdvancedOptions.routes);
        r19.addFlags(VCardConfig.FLAG_APPEND_TYPE_PARAM);
        startActivityForResult(r19, 0);
        return;
    L48:
        r1 = R.string.config_vpn_title;
        goto L49
    }

    /* JADX INFO: renamed from: lambda$onClick$7$com-android-settings-vpn2-VpnConfigFragment, reason: not valid java name */
    /* synthetic */ void m633lambda$onClick$7$comandroidsettingsvpn2VpnConfigFragment(View r2, int r3) {
        OPopover r4 = this.mTypePopover;
        if (r4 == null) goto L5;
        r4.dismiss();
    L5:
        OLog.e(TAG, "which = " + r3);
        this.mTypeIndex = r3;
        this.mTypeItem.setEndDetailText(this.mType[r3]);
        int r5 = convertAllowedIndexToProfileType(this.mTypeIndex);
        changeType(r5);
        updateAlwaysOnUIState();
        updateSaveButtonState();
        this.mProfile.type = r5;
    }

    /* JADX INFO: renamed from: lambda$onClick$8$com-android-settings-vpn2-VpnConfigFragment, reason: not valid java name */
    /* synthetic */ void m634lambda$onClick$8$comandroidsettingsvpn2VpnConfigFragment(View r2, int r3) {
        this.mIpsecUserCertIndex = r3;
        this.mIpsecUserCertItem.setEndDetailText(this.mIpsecUserCert[r3]);
        updateSaveButtonState();
        OPopover r1 = this.mIpsecUserCertPopover;
        if (r1 == null) goto L6;
        r1.dismiss();
        return;
    }

    /* JADX INFO: renamed from: lambda$onClick$9$com-android-settings-vpn2-VpnConfigFragment, reason: not valid java name */
    /* synthetic */ void m635lambda$onClick$9$comandroidsettingsvpn2VpnConfigFragment(View r2, int r3) {
        this.mIpsecCaCertIndex = r3;
        this.mIpsecCaCertItem.setEndDetailText(this.mIpsecCaCert[r3]);
        updateSaveButtonState();
        OPopover r1 = this.mIpsecCaCertPopover;
        if (r1 == null) goto L6;
        r1.dismiss();
        return;
    }

    /* JADX INFO: renamed from: lambda$onClick$10$com-android-settings-vpn2-VpnConfigFragment, reason: not valid java name */
    /* synthetic */ void m632lambda$onClick$10$comandroidsettingsvpn2VpnConfigFragment(View r2, int r3) {
        this.mIpsecServerCertIndex = r3;
        this.mIpsecServerCertItem.setEndDetailText(this.mIpsecServerCert[r3]);
        updateSaveButtonState();
        OPopover r1 = this.mIpsecServerCertPopover;
        if (r1 == null) goto L6;
        r1.dismiss();
        return;
    }

    private void disconnect(String r2) {
        LegacyVpnInfo r0 = this.mConnectedLegacyVpn;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r2.equals(r0.key) == false) goto L9;
        VpnUtils.clearLockdownVpn(getActivity());
        this.mVpnManager.prepareVpn("[Legacy VPN]", "[Legacy VPN]", UserHandle.myUserId());
        return;
    }

    public void updateLockdownVpn(boolean r4, String r5) {
        if (r4 == false) goto L5;
        MultiSDKAdapterNew.setAlwaysOnVpnPackage(this.mVpnManager, UserHandle.myUserId(), null, false, null);
        VpnUtils.setLockdownVpn(getActivity(), r5);
        return;
    L5:
        if (VpnUtils.isVpnLockdown(r5) == false) goto L9;
        VpnUtils.clearLockdownVpn(getActivity());
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_vpn2_VpnConfigFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(VpnConfigFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_vpn2_VpnConfigFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_vpn2_VpnConfigFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(VpnConfigFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_vpn2_VpnConfigFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_vpn2_VpnConfigFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(VpnConfigFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_vpn2_VpnConfigFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
