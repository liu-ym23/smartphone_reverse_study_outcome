package com.android.settings.wifi;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.IpConfiguration;
import android.net.NetworkInfo;
import android.net.StaticIpConfiguration;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcelable;
import android.os.ServiceManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import bytedanceos.api.ViewSmt;
import bytedanceos.util.Features;
import com.android.internal.app.chooser.DisplayResolveInfo;
import com.android.internal.app.chooser.TargetInfo;
import com.android.settings.AdaptWifi;
import com.android.settings.ExecutorManager;
import com.android.settings.FeatureFactory;
import com.android.settings.GoogleHelp;
import com.android.settings.R;
import com.android.settings.SettingsFeature;
import com.android.settings.ToastUtils;
import com.android.settings.WifiConfigurationSmtOnly;
import com.android.settings.applications.utils.Item;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.applications.utils.OPopoverHelper;
import com.android.settings.base.BaseFragment;
import com.android.settings.meeting.TabletWifiPasswordActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.UIUtils;
import com.android.settings.utils.WifiDppUtils;
import com.android.settingslib.core.lifecycle.Lifecycle;
import com.android.wifitrackerlib.NetworkDetailsTracker;
import com.android.wifitrackerlib.WifiEntry;
import com.google.zxing.WriterException;
import com.obric.cae.libs.wifi.ICaeSmartNetworkManager;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes.dex */
public class AccessPointDetailFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener, View.OnClickListener, LifecycleOwner {
    public static final String CHIP_ICON_METADATA_KEY = "android.service.chooser.chip_icon";
    public static final String CHIP_LABEL_METADATA_KEY = "android.service.chooser.chip_label";
    public static final String EXTRA_HIDDEN_SSID = "android.intent.extra.HIDDEN_SSID";
    public static final String EXTRA_PASSWORD = "android.intent.extra.PASSWORD";
    public static final String EXTRA_SECURITY_TYPE = "android.intent.extra.SECURITY_TYPE";
    public static final String EXTRA_SSID = "android.intent.extra.SSID";
    public static final String EXTRA_WIFI_CREDENTIALS_BUNDLE = "android.intent.extra.WIFI_CREDENTIALS_BUNDLE";
    public static final String GLOBAL_WIFI_PRIORIT_NETWORK = "wifi_priorit_network";
    public static final String KEY_CHOSEN_WIFIENTRY_KEY = "key_chosen_wifientry_key";
    public static final String KEY_IS_SECONDARY_WLAN = "key_is_secondary_wlan";
    private static final String KEY_WIFI_NETWORK_ID = "networkId";
    private static final long MAX_SCAN_AGE_MILLIS = 15000;
    private static final int MSG_UPDATE_WIFI_CONFIGURATION = 1;
    private static final long SCAN_INTERVAL_MILLIS = 10000;
    public static final String TRUST_AP_CHANGED_ACTION = "com.android.settings.wifi.TRUST_AP_CHANGED";
    private TrustedNetworkHelper.CancelCallback cancelCallback;
    private WifiConfiguration currentConfig;
    private boolean isSecondaryWlan;
    private AccessPoint mAccessPoint;
    private OCardListItem mAdvancedOptions;
    private OCardListItem mAutoConnectNeedLoginNetwork;
    private OSwitch mAutoConnectNeedLoginNetworkSwitch;
    private OCardListItem mAutoLogin;
    private OSwitch mAutoLoginSwitch;
    private int mBackBtnTextResId;
    private boolean mClickForgetButton;
    private final AtomicBoolean mConnected;
    private OCardListItem mConnectionSpeed;
    private OListItemSettings mDisconnectBtn;
    private LinearLayout mDisconnectLayout;
    private OButton mForgetBtn;
    private WifiManager.ActionListener mForgetListener;
    private final Handler mHandler;
    private IntentFilter mIntentFilter;
    private OCardListItem mIpAddress;
    private android.net.wifi.WifiInfo mLastInfo;
    private NetworkInfo.DetailedState mLastState;
    private final Lifecycle mLifecycle;
    private OCardListItem mMACAddress;
    private OCardListItem mModifyBtn;
    private LinearLayout mModifyLayout;
    NetworkDetailsTracker mNetworkDetailsTracker;
    private OUILinearLayout mNetworkSharing;
    private ImageView mNetworkSharingQrcode;
    private OCardListItem mPerioritConnectNetwork;
    private OSwitch mPerioritConnectNetworkSwitch;
    private int mPrioritNetowk;
    private OCardListItem mPrivacy;
    private int mRandomizationLevel;
    private BroadcastReceiver mReceiver;
    private WifiManager.ActionListener mSaveListener;
    private OCardListItem mSecurity;
    private OCardListItem mSignalStrength;
    private OCardListItem mStatusInfo;
    private TextView mTrustApTips;
    private OListItemSettings mTrustNetwork;
    private OSwitch mTrustNetworkSwitch;
    private View mTrustView;
    private TrustedNetworkHelper mTrustedHelper;
    private Parcelable mWifiConfigParcelable;
    private WifiManager mWifiManager;
    private HandlerThread mWorkerThread;
    private int networkId;
    private OPopover popover;
    private boolean resetConfirmFlagWhenPause;
    NetworkInfo.DetailedState state;
    android.net.wifi.WifiInfo wifiInfo;

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_wifi_AccessPointDetailFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_wifi_AccessPointDetailFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public AccessPointDetailFragment() {
        this.isSecondaryWlan = false;
        this.mReceiver = new AnonymousClass1(this);
        this.resetConfirmFlagWhenPause = true;
        this.mConnected = new AtomicBoolean(false);
        this.mClickForgetButton = false;
        final Looper r1 = Looper.getMainLooper();
        this.mHandler = new AnonymousClass2(this, r1);
        this.mLifecycle = new Lifecycle(this);
        this.cancelCallback = new AnonymousClass3(this);
    }

    static /* synthetic */ void access$000(AccessPointDetailFragment r0, Context r1, Intent r2) {
        r0.handleEvent(r1, r2);
    }

    static /* synthetic */ void access$100(AccessPointDetailFragment r0, List r1) {
        r0.updateWifiConfigurationView(r1);
    }

    static /* synthetic */ int access$1000(AccessPointDetailFragment r0) {
        return r0.mRandomizationLevel;
    }

    static /* synthetic */ void access$1100(AccessPointDetailFragment r0, int r1) {
        r0.updatePrivacy(r1);
    }

    static /* synthetic */ OPopover access$1200(AccessPointDetailFragment r0) {
        return r0.popover;
    }

    static /* synthetic */ void access$200(AccessPointDetailFragment r0, boolean r1) {
        r0.updateTrustedAp(r1);
    }

    static /* synthetic */ boolean access$300(AccessPointDetailFragment r0) {
        return r0.mClickForgetButton;
    }

    static /* synthetic */ boolean access$302(AccessPointDetailFragment r0, boolean r1) {
        r0.mClickForgetButton = r1;
        return r1;
    }

    static /* synthetic */ void access$400(AccessPointDetailFragment r0) {
        r0.forget();
    }

    static /* synthetic */ WifiManager access$500(AccessPointDetailFragment r0) {
        return r0.mWifiManager;
    }

    static /* synthetic */ Handler access$600(AccessPointDetailFragment r0) {
        return r0.mHandler;
    }

    static /* synthetic */ OSwitch access$700(AccessPointDetailFragment r0) {
        return r0.mPerioritConnectNetworkSwitch;
    }

    static /* synthetic */ int access$802(AccessPointDetailFragment r0, int r1) {
        r0.mPrioritNetowk = r1;
        return r1;
    }

    static /* synthetic */ AccessPoint access$900(AccessPointDetailFragment r0) {
        return r0.mAccessPoint;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        this.mTrustedHelper.handleChooseOrConfirmPasswordResult(r2, r3, r4);
        if (r3 != (-1)) goto L5;
        boolean r5 = true;
    L6:
        updateTrustedAp(r5);
        return;
    L5:
        r5 = false;
        goto L6
    }

    private void updateTrustedAp(boolean r4) {
        WifiConfiguration r0 = this.currentConfig;
        if (r0 == null) goto L10;
        WifiConfigurationSmtOnly.set_isTrustedAp(r0, r4);
        this.mWifiManager.save(this.currentConfig, this.mSaveListener);
        this.mTrustNetworkSwitch.setChecked(r4);
        if (r4 == true) goto L7;
        return;
    L7:
        if (this.currentConfig.hiddenTrust == false) goto L12;
        this.currentConfig.hiddenTrust = false;
        this.mWifiManager.save(this.currentConfig, this.mSaveListener);
        return;
    L12:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r4) {
        super.onSaveInstanceState(r4);
        WifiConfiguration r0 = this.currentConfig;
        if (r0 == null) goto L5;
        r4.putParcelable(AccessPointInfo.EXTRA_WIFI_CONFIGURATION, r0);
        OLog.w(this.TAG, "onSaveInstanceState mWifiConfigParcelable " + this.currentConfig);
        return;
    L5:
        r4.putParcelable(AccessPointInfo.EXTRA_WIFI_CONFIGURATION, this.mWifiConfigParcelable);
        OLog.w(this.TAG, "onSaveInstanceState mWifiConfigParcelable " + this.mWifiConfigParcelable);
    }

    public void com_android_settings_wifi_AccessPointDetailFragment__onCreate$___twin___(Bundle r5) {
        this.mLifecycle.onCreate(r5);
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_CREATE);
        super.onCreate(r5);
        this.mWifiManager = (WifiManager) this.mContext.getSystemService("wifi");
        Bundle r0 = getArguments();
        FragmentActivity r1 = getActivity();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r1 != null) goto L8;
    L10:
        if (r5 == null) goto L13;
        this.mWifiConfigParcelable = r5.getParcelable(AccessPointInfo.EXTRA_WIFI_CONFIGURATION);
    L13:
        if (this.mWifiConfigParcelable != null) goto L16;
        if (r0 == null) goto L16;
        this.mWifiConfigParcelable = r0.getParcelable(AccessPointInfo.EXTRA_WIFI_CONFIGURATION);
    L16:
        if (r0 == null) goto L19;
        this.isSecondaryWlan = r0.getBoolean(KEY_IS_SECONDARY_WLAN, false);
    L19:
        if (this.mWifiConfigParcelable != null) goto L21;
        this.mWifiConfigParcelable = getWifiConfiguration(getIntent());
    L21:
        Parcelable r6 = this.mWifiConfigParcelable;
        if (r6 == null) goto L37;
        if ((r6 instanceof WifiConfiguration) == false) goto L37;
        this.mAccessPoint = new AccessPoint(r1, (WifiConfiguration) this.mWifiConfigParcelable);
        AccessPoint.PskType r7 = (AccessPoint.PskType) r0.getSerializable(AccessPointInfo.EXTRA_PSK_TYPE);
        AccessPoint r2 = this.mAccessPoint;
        if (r7 != null) goto L29;
        r7 = AccessPoint.PskType.UNKNOWN;
    L29:
        r2.pskType = r7;
        android.net.wifi.WifiInfo r8 = (android.net.wifi.WifiInfo) r0.getParcelable(AccessPointInfo.EXTRA_WIFI_INFO);
        if (r8 == null) goto L32;
        this.wifiInfo = r8;
    L32:
        NetworkInfo.DetailedState r3 = (NetworkInfo.DetailedState) r0.getSerializable(AccessPointInfo.EXTRA_DETAILED_STATE);
        this.state = r3;
        if (r8 == null) goto L37;
        if (r3 == null) goto L37;
        this.mAccessPoint.update(r8, r3, -1);
    L37:
        if (this.mAccessPoint != null) goto L40;
        finish();
        return;
    L40:
        TrustedNetworkHelper r9 = new TrustedNetworkHelper(this);
        this.mTrustedHelper = r9;
        r9.setCancelCallback(this.cancelCallback);
        this.mForgetListener = new AnonymousClass4(this);
        this.mSaveListener = new AnonymousClass5(this);
        IntentFilter r10 = new IntentFilter();
        this.mIntentFilter = r10;
        r10.addAction("android.net.wifi.supplicant.STATE_CHANGE");
        this.mIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
        this.mIntentFilter.addAction("android.net.wifi.CONFIGURED_NETWORKS_CHANGE");
        this.mIntentFilter.addAction("android.net.wifi.RSSI_CHANGED");
        this.mIntentFilter.addAction(TRUST_AP_CHANGED_ACTION);
        return;
    L8:
        if (r0.containsKey(AccessPointInfo.EXTRA_WIFI_CONFIGURATION) == true) goto L10;
        r0 = r1.getIntent().getExtras();
        goto L10
    }

    private WifiConfiguration getWifiConfiguration(Intent r6) {
        WifiManager r1 = (WifiManager) this.mContext.getSystemService("wifi");
        if (r1.isWifiEnabled() == true) goto L5;
        return null;
    L5:
        this.networkId = r6.getIntExtra(KEY_WIFI_NETWORK_ID, -1);
        List<WifiConfiguration> r7 = r1.getConfiguredNetworks();     // Catch: RuntimeException -> L15
        this.wifiInfo = r1.getConnectionInfo();     // Catch: RuntimeException -> L15
        OLog.i(this.TAG, "getWifiConfiguration: networkId = " + this.networkId + "  getNetworkId() =  " + this.wifiInfo.getNetworkId());     // Catch: RuntimeException -> L15
        if (this.networkId != (-1)) goto L9;
        this.networkId = this.wifiInfo.getNetworkId();     // Catch: RuntimeException -> L15
    L9:
        Iterator<WifiConfiguration> r8 = r7.iterator();     // Catch: RuntimeException -> L15
    L10:
        if (r8.hasNext() == false) goto L17;
        WifiConfiguration r0 = r8.next();     // Catch: RuntimeException -> L15
        if (r0.networkId != this.networkId) goto L10;
        return r0;
    L17:
        return null;
    L15:
        e = move-exception;
        OLog.e(this.TAG, "getWifiConfiguration: error = " + e.getMessage());
        goto L17
    }

    private void handleEvent(Context r3, Intent r4) {
        if (isAdded() == true) goto L5;
        return;
    L5:
        String r5 = r4.getAction();
        if ("android.net.wifi.supplicant.STATE_CHANGE".equals(r5) == false) goto L22;
        if (r4.hasExtra("supplicantError") == false) goto L10;
        ToastUtils.show(getActivity(), R.string.wifi_maybe_password_error);
    L10:
        SupplicantState r6 = (SupplicantState) r4.getParcelableExtra("newState");
        if (r6 != null) goto L14;
        return;
    L14:
        if (this.mConnected.get() == true) goto L19;
        if (AdaptWifi.isHandshakeState(r6) == false) goto L19;
        updateAccessPointConnectionState(android.net.wifi.WifiInfo.getDetailedStateOf(r6));
    L41:
        this.mRootView.post(new AccessPointDetailFragment$$ExternalSyntheticLambda2(this));
        return;
    L19:
        if (r6 != SupplicantState.DISCONNECTED) goto L41;
        updateAccessPointConnectionState(android.net.wifi.WifiInfo.getDetailedStateOf(r6));
        goto L41
    L22:
        if ("android.net.wifi.STATE_CHANGE".equals(r5) == false) goto L27;
        NetworkInfo r7 = (NetworkInfo) r4.getParcelableExtra("networkInfo");
        if (r7 == null) goto L41;
        this.mConnected.set(r7.isConnected());
        updateAccessPointConnectionState(r7.getDetailedState());
        goto L41
    L27:
        if ("android.net.wifi.CONFIGURED_NETWORKS_CHANGE".equals(r5) == false) goto L36;
        WifiConfiguration r8 = (WifiConfiguration) r4.getParcelableExtra("wifiConfiguration");
        if (r4.getIntExtra("changeReason", -1) != 1) goto L41;
        if (r8 == null) goto L41;
        if (r8.networkId != this.mAccessPoint.networkId) goto L41;
        finish();
        return;
    L36:
        if (TRUST_AP_CHANGED_ACTION.equals(r5) == true) goto L41;
        if ("android.net.wifi.RSSI_CHANGED".equals(r5) == false) goto L41;
        AccessPoint.updateConnectedAccessPointRssi(r4.getIntExtra("newRssi", -200));
        goto L41
    }

    /* JADX INFO: renamed from: lambda$handleEvent$0$com-android-settings-wifi-AccessPointDetailFragment, reason: not valid java name */
    /* synthetic */ void m659x744105f2() {
        updateAccessPointInfo();
        updatePrivacyLevel();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r6, ViewGroup r7, Bundle r8) {
        View r9 = r6.inflate(R.layout.access_point_detail_fragment, r7, false);
        this.mRootView = r9;
        if (this.mAccessPoint != null) goto L5;
        return r9;
    L5:
        this.mForgetBtn = (OButton) r9.findViewById(R.id.forget_btn);
        LinearLayout r10 = (LinearLayout) r9.findViewById(R.id.forget_container);
        this.mForgetBtn.setOnClickListener(new AnonymousClass6(this));
        if (this.mAccessPoint.networkId != (-1)) goto L8;
        r10.setVisibility(8);
    L9:
        this.mDisconnectLayout = (LinearLayout) r9.findViewById(R.id.disconnect_layout);
        OListItemSettings r11 = (OListItemSettings) r9.findViewById(R.id.disconnect_btn);
        this.mDisconnectBtn = r11;
        r11.setOnClickListener(this);
        if (Features.isFeatureCMCCEnabled(getActivity()).booleanValue() == true) goto L12;
    L14:
        this.mModifyLayout = (LinearLayout) r9.findViewById(R.id.modify_layout);
        OCardListItem r12 = (OCardListItem) r9.findViewById(R.id.modify_btn);
        this.mModifyBtn = r12;
        r12.setOnContentClickListener(new AccessPointDetailFragment$$ExternalSyntheticLambda3(this));
        if (Features.isFeatureCMCCEnabled(getActivity()).booleanValue() == true) goto L17;
    L21:
        OCardListItem r13 = (OCardListItem) r9.findViewById(R.id.ap_status_info);
        this.mStatusInfo = r13;
        r13.setImportantForAccessibility(1);
        OCardListItem r14 = (OCardListItem) r9.findViewById(R.id.ap_signal_strength);
        this.mSignalStrength = r14;
        r14.setImportantForAccessibility(1);
        OCardListItem r15 = (OCardListItem) r9.findViewById(R.id.ap_connection_speed);
        this.mConnectionSpeed = r15;
        r15.setImportantForAccessibility(1);
        OCardListItem r16 = (OCardListItem) r9.findViewById(R.id.ap_security);
        this.mSecurity = r16;
        r16.setImportantForAccessibility(1);
        this.mIpAddress = (OCardListItem) r9.findViewById(R.id.ap_ip_address);
        AccessPoint r17 = this.mAccessPoint;
        if (r17 == null) goto L26;
        if (r17.getState() != NetworkInfo.DetailedState.CONNECTED) goto L26;
    L27:
        OCardListItemUtils.setTrailingMultiText(this.mIpAddress, WIFIUtils.INSTANCE.getIpAddress(!this.isSecondaryWlan));
    L28:
        this.mIpAddress.setImportantForAccessibility(1);
        this.mNetworkSharing = (OUILinearLayout) r9.findViewById(R.id.ap_network_sharing);
        this.mNetworkSharingQrcode = (ImageView) r9.findViewById(R.id.network_sharing_qrcode);
        ViewSmt.getInstance().setSupportOcrBoom(this.mNetworkSharingQrcode, true);
        OCardListItem r18 = (OCardListItem) r9.findViewById(R.id.auto_connect_network);
        this.mAutoConnectNeedLoginNetwork = r18;
        OSwitch r19 = (OSwitch) r18.getCustomEndView();
        this.mAutoConnectNeedLoginNetworkSwitch = r19;
        r19.setClickable(true);
        OCardListItem r20 = (OCardListItem) r9.findViewById(R.id.auto_login_network);
        this.mAutoLogin = r20;
        OSwitch r21 = (OSwitch) r20.getCustomEndView();
        this.mAutoLoginSwitch = r21;
        r21.setClickable(true);
        OCardListItem r22 = (OCardListItem) r9.findViewById(R.id.priorit_connect_network);
        this.mPerioritConnectNetwork = r22;
        OSwitch r23 = (OSwitch) r22.findViewById(R.id.custom_end_switch);
        this.mPerioritConnectNetworkSwitch = r23;
        r23.setClickable(true);
        this.mPrioritNetowk = Integer.parseInt(Settings.Global.getString(getContentResolver(), GLOBAL_WIFI_PRIORIT_NETWORK));     // Catch: NumberFormatException -> L31
    L33:
        if (this.mPrioritNetowk == this.mAccessPoint.networkId) goto L35;
    L37:
        this.mPerioritConnectNetworkSwitch.setChecked(false);
    L38:
        this.mTrustNetwork = (OListItemSettings) r9.findViewById(R.id.ap_trust_network);
        OSwitch r24 = new OSwitch(this.mContext);
        this.mTrustNetworkSwitch = r24;
        r24.setClickable(true);
        this.mTrustNetwork.setTrailingView(this.mTrustNetworkSwitch);
        this.mTrustView = r9.findViewById(R.id.trust_layout);
        OCardListItem r25 = (OCardListItem) r9.findViewById(R.id.ap_advanced_options);
        this.mAdvancedOptions = r25;
        r25.setOnContentClickListener(new AccessPointDetailFragment$$ExternalSyntheticLambda4(this));
        this.mTrustApTips = (TextView) r9.findViewById(R.id.ap_trust_network_tips);
        OCardListItem r26 = (OCardListItem) r9.findViewById(R.id.privacy);
        this.mPrivacy = r26;
        r26.setOnContentClickListener(new AccessPointDetailFragment$$ExternalSyntheticLambda5(this));
        this.mMACAddress = (OCardListItem) r9.findViewById(R.id.mac_address);
        if (this.isSecondaryWlan == false) goto L41;
        this.mAdvancedOptions.setVisibility(8);
        this.mPrivacy.setVisibility(8);
        this.mMACAddress.setCardPosition(0);
        ViewGroup.MarginLayoutParams r27 = (ViewGroup.MarginLayoutParams) this.mForgetBtn.getLayoutParams();
        r27.topMargin = UIUtils.INSTANCE.dp2px(16);
        this.mForgetBtn.setLayoutParams(r27);
        r9.findViewById(R.id.ap_advanced_options_divider).setVisibility(8);
        this.mPerioritConnectNetwork.setVisibility(8);
        r9.findViewById(R.id.priorit_connect_network_tips).setVisibility(8);
        r9.findViewById(R.id.priorit_connect_network_divider).setVisibility(8);
    L41:
        addActionButton();
        return r9;
    L35:
        if (this.mAccessPoint.networkId == (-1)) goto L37;
        this.mPerioritConnectNetworkSwitch.setChecked(true);
    L31:
        this.mPrioritNetowk = -1;
    L26:
        if (this.isSecondaryWlan == false) goto L28;
    L17:
        if (this.mAccessPoint.networkId == (-1)) goto L21;
        if (this.mAccessPoint.security == 0) goto L21;
        this.mModifyLayout.setVisibility(0);
        goto L21
    L12:
        if (this.mAccessPoint.getState() != NetworkInfo.DetailedState.CONNECTED) goto L14;
        this.mDisconnectLayout.setVisibility(0);
        goto L14
    L8:
        r10.setVisibility(0);
        goto L9
    }

    /* JADX INFO: renamed from: lambda$onCreateView$1$com-android-settings-wifi-AccessPointDetailFragment, reason: not valid java name */
    /* synthetic */ void m660x9f20043b(View r1) {
        modifyConfig();
    }

    /* JADX INFO: renamed from: lambda$onCreateView$2$com-android-settings-wifi-AccessPointDetailFragment, reason: not valid java name */
    /* synthetic */ void m661x2c5ab5bc(View r1) {
        this.resetConfirmFlagWhenPause = false;
        launchAdvancedOptions();
    }

    /* JADX INFO: renamed from: lambda$onCreateView$3$com-android-settings-wifi-AccessPointDetailFragment, reason: not valid java name */
    /* synthetic */ void m662xb995673d(View r1) {
        showSelectMacDialog();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        if (this.mAccessPoint != null) goto L5;
        return;
    L5:
        OFloatingTitleBar r3 = this.mTitleView;
        if (r3 == null) goto L8;
        r3.setCenterTitle(this.mAccessPoint.ssid);
    L8:
        OCardListItem r4 = this.mAutoConnectNeedLoginNetwork;
        if (this.mAccessPoint.needLogin == false) goto L11;
        int r5 = 0;
    L12:
        r4.setVisibility(r5);
        setupNetworksDetailTracker();
        isShowMACAddress();
        updatePrivacyLevel();
        return;
    L11:
        r5 = 8;
        goto L12
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r2) {
        super.onViewStateRestored(r2);
        this.mRootView.post(new AccessPointDetailFragment$$ExternalSyntheticLambda1(this));
        OSwitch r3 = this.mAutoConnectNeedLoginNetworkSwitch;
        if (r3 == null) goto L5;
        r3.setOnCheckedChangeListener(this);
    L5:
        OSwitch r4 = this.mAutoLoginSwitch;
        if (r4 == null) goto L8;
        r4.setOnCheckedChangeListener(this);
    L8:
        OSwitch r5 = this.mPerioritConnectNetworkSwitch;
        if (r5 == null) goto L11;
        r5.setOnCheckedChangeListener(this);
    L11:
        OSwitch r6 = this.mTrustNetworkSwitch;
        if (r6 == null) goto L15;
        r6.setChecked(this.mAccessPoint.isTrusted);
        this.mTrustNetworkSwitch.setOnCheckedChangeListener(this);
        return;
    }

    /* JADX INFO: renamed from: lambda$onViewStateRestored$4$com-android-settings-wifi-AccessPointDetailFragment, reason: not valid java name */
    /* synthetic */ void m663x5a649967() {
        updateViews();
    }

    private void isShowMACAddress() {
        NetworkDetailsTracker r0 = this.mNetworkDetailsTracker;
        if (r0 != null) goto L7;
        OLog.d(this.TAG, "mNetworkDetailsTracker is null");
        return;
    L7:
        if (r0.getWifiEntry().getConnectedState() == 2) goto L10;
        this.mMACAddress.setVisibility(8);
        return;
    }

    private void updatePrivacyLevel() {
        NetworkDetailsTracker r0 = this.mNetworkDetailsTracker;
        if (r0 == null) goto L19;
        WifiEntry r1 = r0.getWifiEntry();
        OLog.d(this.TAG, "updatePrivacyLevel wifiEntry:" + r1);
        int r6 = r1.getPrivacy();
        this.mRandomizationLevel = r6;
        if (r6 != 1) goto L7;
        this.mPrivacy.setEndDetailText(getString(R.string.wifi_use_randomized_mac));
    L9:
        if (r1.canSetPrivacy() == true) goto L11;
        this.mPrivacy.setOnContentClickListener(null);
        this.mPrivacy.setEndDetailText(getString(R.string.wifi_use_randomized_mac));
    L11:
        String r2 = r1.getMacAddress();
        OLog.d(this.TAG, "updatePrivacyLevel macAddress:" + r2);
        if (TextUtils.isEmpty(r2) == false) goto L16;
        this.mMACAddress.setVisibility(8);
        return;
    L16:
        if (r2.equals("02:00:00:00:00:00") == false) goto L18;
        this.mMACAddress.setEndDetailText(getString(R.string.device_info_not_available));
        return;
    L18:
        this.mMACAddress.setEndDetailText(r2);
        return;
    L7:
        this.mPrivacy.setEndDetailText(getString(R.string.wifi_use_device_mac));
        goto L9
    L19:
        WifiConfiguration r3 = this.currentConfig;
        if (r3 != null) goto L22;
    L25:
        android.net.wifi.WifiInfo r4 = this.wifiInfo;
        if (r4 == null) goto L37;
        String r5 = r4.getMacAddress();
        if (TextUtils.isEmpty(r5) == false) goto L30;
    L33:
        this.mMACAddress.setVisibility(8);
        return;
    L30:
        if (r5.equals("02:00:00:00:00:00") == true) goto L33;
        this.mMACAddress.setEndDetailText(this.wifiInfo.getMacAddress());
        return;
    L37:
        return;
    L22:
        if (r3.getMacRandomizationSetting() != 1) goto L24;
        this.mPrivacy.setEndDetailText(getString(R.string.wifi_use_randomized_mac));
        this.mRandomizationLevel = 1;
        goto L25
    L24:
        this.mPrivacy.setEndDetailText(getString(R.string.wifi_use_device_mac));
        goto L25
    }

    public void updateViews() {
        AccessPoint r0 = this.mAccessPoint;
        if (r0 != null) goto L5;
        return;
    L5:
        this.mAutoConnectNeedLoginNetworkSwitch.setChecked(r0.isAutoConnected);
        updateAccessPointInfo();
        OCardListItem r1 = this.mAutoConnectNeedLoginNetwork;
        if (this.mAccessPoint.needLogin == false) goto L8;
        int r2 = 0;
    L9:
        r1.setVisibility(r2);
        updateQrCode();
        updateAutoLoginSwitch();
        registerReceiver(this.mReceiver, this.mIntentFilter);
        this.resetConfirmFlagWhenPause = true;
        boolean r3 = com.android.settings.Utils.isUseStrictLockScreen(this.mContext);
        this.mTrustNetwork.setEnabled(!r3);
        this.mTrustNetworkSwitch.setEnabled(!r3);
        this.mTrustNetworkSwitch.setAlpha(1.0f);
        this.mTrustApTips.setText(getTrustApTipsText(r3));
        return;
    L8:
        r2 = 8;
        goto L9
    }

    private String getTrustApTipsText(boolean r5) {
        if (r5 == true) goto L6;
        return getString(R.string.wifi_trust_network_tips);
    L6:
        if (Settings.Global.getInt(getContentResolver(), "use_fingerprint_in_lockscreen", 0) != 1) goto L8;
        boolean r6 = true;
    L10:
        if (SettingsFeature.isFaceRecognitionEnable() == true) goto L12;
    L14:
        boolean r2 = false;
    L15:
        if (r6 == false) goto L18;
        if (r2 == false) goto L18;
        int r7 = R.string.fingerprint_id_and_face_recognition;
    L22:
        return getString(R.string.wifi_trust_network_with_fingerprint_tips, new Object[]{getString(r7)});
    L18:
        if (r2 == false) goto L20;
        r7 = R.string.face_recognition;
        goto L22
    L20:
        r7 = R.string.fingerprint;
        goto L22
    L12:
        if (Settings.Global.getInt(getContentResolver(), "faceid_enable", 0) != 1) goto L14;
        r2 = true;
        goto L15
    L8:
        r6 = false;
        goto L10
    }

    private void setupNetworksDetailTracker() {
        if (this.mNetworkDetailsTracker == null) goto L5;
        return;
    L5:
        String r12 = getArguments().getString("key_chosen_wifientry_key");
        if (r12 != null) goto L8;
        return;
    L8:
        if (r12.isEmpty() == true) goto L13;
        Context r4 = getContext();
        HandlerThread r0 = new HandlerThread(this.TAG + VectorFormat.DEFAULT_PREFIX + Integer.toHexString(System.identityHashCode(this)) + VectorFormat.DEFAULT_SUFFIX, 10);
        this.mWorkerThread = r0;
        r0.start();
        final ZoneOffset r1 = ZoneOffset.UTC;
        this.mNetworkDetailsTracker = FeatureFactory.getFactory(r4).getWifiTrackerLibProvider().createNetworkDetailsTracker(getLifecycle(), r4, new Handler(Looper.getMainLooper()), this.mWorkerThread.getThreadHandler(), new AnonymousClass7(this, r1), 15000, SCAN_INTERVAL_MILLIS, r12);
        return;
    }

    private void updateQrCode() {
        WifiConfiguration r0 = this.currentConfig;
        if (r0 == null) goto L5;
    L7:
        if (r0 != null) goto L9;
        r0 = (WifiConfiguration) this.mWifiConfigParcelable;
    L9:
        String r1 = Utils.createContent(this.mWifiManager, r0, false);
        if (TextUtils.isEmpty(r1) == false) goto L18;
        this.mNetworkSharing.setVisibility(8);
        return;
    L18:
        this.mNetworkSharingQrcode.setImageBitmap(Utils.createQrCode(getActivity(), r1));     // Catch: WriterException -> L13
    L15:
        this.mNetworkSharing.setVisibility(0);
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L5:
        if (this.mWifiConfigParcelable != null) goto L7;
    }

    private void updateAutoLoginSwitch() {
        if (this.currentConfig != null) goto L7;
        if (this.mWifiConfigParcelable != null) goto L7;
        return;
    L7:
        if (this.mAccessPoint.needLogin == false) goto L25;
        WifiConfiguration r0 = this.currentConfig;
        if (r0 != null) goto L12;
        r0 = (WifiConfiguration) this.mWifiConfigParcelable;
    L12:
        String r1 = WifiAuthorizeUtils.configKey(r0, 1);
        String r2 = WifiAuthorizeUtils.getAutoLoginHost(getActivity(), r1);
        if (TextUtils.isEmpty(r2) == false) goto L15;
        return;
    L15:
        if (WifiAuthorizeUtils.checkSavedLoginInfo(getActivity(), r2) == true) goto L18;
        return;
    L18:
        if (TextUtils.isEmpty(WifiAuthorizeUtils.getLoginScript(getActivity(), r1)) == true) goto L23;
        this.mAutoLogin.setVisibility(0);
        if (WifiAuthorizeUtils.autoLoginEnabled(getActivity(), r1) == false) goto L22;
        this.mAutoLoginSwitch.setChecked(true);
        return;
    L22:
        this.mAutoLoginSwitch.setChecked(false);
        return;
    L23:
        this.mAutoLogin.setVisibility(8);
        return;
    }

    private void updateAccessPointConnectionState(NetworkInfo.DetailedState r3) {
        android.net.wifi.WifiInfo r0 = this.mWifiManager.getConnectionInfo();
        this.mLastInfo = r0;
        if (r3 == null) goto L5;
        this.mLastState = r3;
    L5:
        this.mAccessPoint.update(r0, this.mLastState, -1);
    }

    private void updateAccessPointInfo() {
        NetworkDetailsTracker r0 = this.mNetworkDetailsTracker;
        if (r0 == null) goto L5;
        WifiEntry r1 = r0.getWifiEntry();
    L6:
        AccessPoint r2 = this.mAccessPoint;
        if (r2 != null) goto L9;
        return;
    L9:
        NetworkInfo.DetailedState r3 = r2.getState();
        if (r3 == null) goto L13;
        String r4 = Summary.get(getActivity(), r3);
    L16:
        this.mStatusInfo.setEndDetailText(r4);
        this.mStatusInfo.setContentDescription(this.mStatusInfo.getTitle() + this.mStatusInfo.getEndDetail().toString());
        int r5 = this.mAccessPoint.getLevel();
        if (r5 == (-1)) goto L20;
        if (r3 == null) goto L20;
        this.mSignalStrength.setEndDetailText(getResources().getStringArray(R.array.wifi_signal)[r5]);
    L26:
        this.mSignalStrength.setContentDescription(this.mSignalStrength.getTitle() + this.mSignalStrength.getEndDetail().toString());
        android.net.wifi.WifiInfo r6 = this.mAccessPoint.getInfo();
        if (r6 != null) goto L29;
    L31:
        android.net.wifi.WifiInfo r7 = this.wifiInfo;
        if (r7 != null) goto L34;
    L36:
        this.mConnectionSpeed.setEndDetailText("");
    L37:
        this.mConnectionSpeed.setContentDescription(this.mConnectionSpeed.getTitle() + this.mConnectionSpeed.getEndDetail().toString());
        String r8 = this.mAccessPoint.getSecurityString(false);
        if (r1 == null) goto L48;
        OLog.d(this.TAG, "securityText: " + r8 + " , wifiEntry.getSecurity(): " + r1.getSecurity());
        if (r1.isPskSaeTransitionMode() == false) goto L42;
    L47:
        r8 = "WPA3-Personal";
        goto L48
    L42:
        if (r1.isOweTransitionMode() == true) goto L47;
        if (r1.getSecurity() == 5) goto L47;
        if (r1.getSecurity() == 4) goto L47;
    L48:
        this.mSecurity.setEndDetailText(r8);
        this.mSecurity.setContentDescription(this.mSecurity.getTitle() + this.mSecurity.getEndDetail().toString());
        ExecutorManager.execute(new AnonymousClass8(this));
        return;
    L34:
        if (r7.getLinkSpeed() == (-1)) goto L36;
        this.mConnectionSpeed.setEndDetailText(this.wifiInfo.getLinkSpeed() + "Mbps");
        goto L37
    L29:
        if (r6.getLinkSpeed() == (-1)) goto L31;
        this.mConnectionSpeed.setEndDetailText(r6.getLinkSpeed() + "Mbps");
    L20:
        android.net.wifi.WifiInfo r9 = this.wifiInfo;
        if (r9 != null) goto L23;
    L25:
        this.mSignalStrength.setEndDetailText("");
        goto L26
    L23:
        if (WifiManager.calculateSignalLevel(r9.getRssi(), 4) == (-1)) goto L25;
        this.mSignalStrength.setEndDetailText(getResources().getStringArray(R.array.wifi_signal)[WifiManager.calculateSignalLevel(this.wifiInfo.getRssi(), 4)]);
        goto L26
    L13:
        if (this.state == null) goto L15;
        r4 = Summary.get(getActivity(), this.state);
        goto L16
    L15:
        r4 = "";
        goto L16
    L5:
        r1 = null;
        goto L6
    }

    private void updateWifiConfigurationView(List<WifiConfiguration> r4) {
        if (this.mAccessPoint.networkId == (-1)) goto L31;
        if (r4 == null) goto L16;
        Iterator<WifiConfiguration> r5 = r4.iterator();
    L7:
        if (r5.hasNext() == false) goto L16;
        WifiConfiguration r0 = r5.next();
        if (r0.networkId != this.mAccessPoint.networkId) goto L7;
        WifiConfiguration r6 = this.currentConfig;
        if (r6 != null) goto L13;
    L14:
        this.currentConfig = r0;
    L15:
        this.mAccessPoint.needLogin = WifiConfigurationSmtOnly.get_needLogin(r0);
        this.mAccessPoint.isAutoConnected = WifiConfigurationSmtOnly.get_autoConnect(r0);
        goto L16
    L13:
        if (WifiConfigurationSmtOnly.get_isTrustedAp(r6) != WifiConfigurationSmtOnly.get_isTrustedAp(r0)) goto L15;
    L16:
        WifiConfiguration r7 = this.currentConfig;
        if (r7 == null) goto L31;
        if (r7.getIpConfiguration().getIpAssignment() != IpConfiguration.IpAssignment.STATIC) goto L25;
        StaticIpConfiguration r8 = this.currentConfig.getIpConfiguration().getStaticIpConfiguration();
        if (r8 == null) goto L29;
        if (r8.ipAddress == null) goto L29;
        r8.ipAddress.getAddress().getHostAddress();
    L29:
        if (this.mTrustedHelper.isDialogShowing() == true) goto L31;
        this.mTrustNetworkSwitch.setChecked(WifiConfigurationSmtOnly.get_isTrustedAp(this.currentConfig));
        goto L31
    L25:
        android.net.wifi.WifiInfo r9 = this.mAccessPoint.getInfo();
        if (r9 == null) goto L29;
        int r10 = r9.getIpAddress();
        StringBuffer r1 = new StringBuffer().append(r10 & 255).append('.');
        int r11 = r10 >>> 8;
        StringBuffer r2 = r1.append(r11 & 255).append('.');
        int r12 = r11 >>> 8;
        r2.append(r12 & 255).append('.').append((r12 >>> 8) & 255);
    L31:
        AccessPoint r13 = this.mAccessPoint;
        if (r13 != null) goto L34;
    L36:
        this.mIpAddress.setContentDescription(this.mIpAddress.getTitle() + this.mIpAddress.getEndDetail().toString());
        return;
    L34:
        if (r13.getState() != NetworkInfo.DetailedState.CONNECTED) goto L36;
        OCardListItemUtils.setTrailingMultiText(this.mIpAddress, WIFIUtils.INSTANCE.getIpAddress(!this.isSecondaryWlan));
        goto L36
    }

    private void forget() {
        if (this.mAccessPoint.networkId != (-1)) goto L6;
        OLog.e(this.TAG, "Failed to forget invalid network " + this.mAccessPoint.getConfig());
        return;
    L6:
        removeAutoLogin(getActivity(), this.currentConfig);
        int r0 = this.mPrioritNetowk;
        if (r0 >= 0) goto L9;
    L23:
        IBinder r1 = ServiceManager.getService("cae_wifi");     // Catch: Exception -> L19
        if (r1 == null) goto L21;
        ICaeSmartNetworkManager r2 = ICaeSmartNetworkManager.Stub.asInterface(r1);     // Catch: Exception -> L19
        String r3 = r2.getCurrentSecondarySsid();     // Catch: Exception -> L19
        if (r3 == null) goto L21;
        if (r3.equals(this.mAccessPoint.ssid) == false) goto L21;
        r2.releaseAll();     // Catch: Exception -> L19
    L21:
        this.mWifiManager.forget(this.mAccessPoint.networkId, this.mForgetListener);
        return;
    L19:
        e = move-exception;
        OLog.e(this.TAG, "removeAutoLogin exception:" + e);
        goto L21
    L9:
        if (r0 != this.mAccessPoint.networkId) goto L23;
        this.mPrioritNetowk = -1;
        Settings.Global.putString(getContentResolver(), GLOBAL_WIFI_PRIORIT_NETWORK, "-1");
        goto L23
    }

    public static void removeAutoLogin(Context r1, WifiConfiguration r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        String r3 = WifiAuthorizeUtils.configKey(r2, 1);
        if (TextUtils.isEmpty(WifiAuthorizeUtils.getLoginScript(r1, r3)) == true) goto L8;
        WifiAuthorizeUtils.removeFromSharedPreferences(r1, r3);
        return;
    }

    private void modifyConfig() {
        if (this.mAccessPoint.networkId != (-1)) goto L7;
        OLog.e(this.TAG, "Failed to modify network " + this.mAccessPoint.getConfig());
        return;
    L7:
        if (this.currentConfig != null) goto L10;
        OLog.e(this.TAG, "Failed to get current network info" + this.mAccessPoint.getConfig());
        return;
    L10:
        Bundle r0 = new Bundle();
        r0.putBoolean("edit", true);
        r0.putBoolean("cmcc", true);
        Bundle r1 = new Bundle();
        this.mAccessPoint.saveWifiState(r1);
        r0.putBundle("access_point", r1);
        r0.putBoolean(TabletWifiPasswordActivity.INTENT_EXTRA_SETUP_INVALID_NETWORK, true);
        WifiSetupFragment r2 = new WifiSetupFragment();
        r2.setArguments(r0);
        start(r2);
    }

    private String getNetworkSsid(int r4) {
        List<WifiConfiguration> r3 = this.mWifiManager.getConfiguredNetworks();     // Catch: RuntimeException -> L5
    L7:
        if (r3 != null) goto L9;
        return null;
    L9:
        Iterator<WifiConfiguration> r5 = r3.iterator();
    L11:
        if (r5.hasNext() == false) goto L16;
        WifiConfiguration r1 = r5.next();
        if (r1.networkId != r4) goto L11;
        return r1.SSID;
    L16:
        return null;
    L5:
        e = move-exception;
        e.printStackTrace();
        r3 = null;
        goto L7
    }

    private void showSetPrioritNetworkDialog(int r5) {
        String r0 = getNetworkSsid(r5);
        if (r0 != null) goto L6;
        OLog.e(this.TAG, "Get ssid of network " + r5 + " is null !");
        this.mPrioritNetowk = this.mAccessPoint.networkId;
        Settings.Global.putString(getContentResolver(), GLOBAL_WIFI_PRIORIT_NETWORK, Integer.toString(this.mAccessPoint.networkId));
        return;
    L6:
        new OAlertDialogBuilder(getActivity()).autoDismiss(true).horizontalButton().title(R.string.wifi_priorit_dialog_title).message(String.format(getString(R.string.wifi_priorit_dialog_message), new Object[]{AccessPoint.removeDoubleQuotes(r0)})).positiveButton(R.string.dlg_ok, new AnonymousClass10(this)).negativeButton(R.string.dlg_cancel, new AnonymousClass9(this)).build().show();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r4, boolean r5) {
        if (r4 != this.mAutoConnectNeedLoginNetworkSwitch) goto L16;
        WifiConfiguration r6 = this.currentConfig;
        if (r6 != null) goto L7;
        return;
    L7:
        if (WifiConfigurationSmtOnly.get_autoConnect(r6) != r5) goto L10;
        return;
    L10:
        if (this.mAccessPoint.networkId != (-1)) goto L13;
        OLog.e(this.TAG, "Failed to forget invalid network " + this.mAccessPoint.getConfig());
        return;
    L13:
        WifiConfigurationSmtOnly.set_autoConnect(this.currentConfig, r5);
        this.mWifiManager.save(this.currentConfig, this.mSaveListener);
        return;
    L16:
        if (r4 != this.mAutoLoginSwitch) goto L22;
        if (r5 == false) goto L20;
        WifiAuthorizeUtils.saveToSharedPreferences(getActivity(), this.currentConfig, "on", 2);
        return;
    L20:
        WifiAuthorizeUtils.saveToSharedPreferences(getActivity(), this.currentConfig, "off", 2);
        return;
    L22:
        if (r4 == this.mPerioritConnectNetworkSwitch) goto L24;
        WifiConfiguration r7 = this.currentConfig;
        if (r7 != null) goto L38;
        return;
    L38:
        if (WifiConfigurationSmtOnly.get_isTrustedAp(r7) != r5) goto L41;
        return;
    L41:
        if (this.mAccessPoint.networkId != (-1)) goto L44;
        OLog.e(this.TAG, "Failed to forget invalid network " + this.mAccessPoint.getConfig());
        return;
    L44:
        if (r5 == true) goto L46;
    L50:
        WifiConfigurationSmtOnly.set_isTrustedAp(this.currentConfig, r5);
        this.mWifiManager.save(this.currentConfig, this.mSaveListener);
        if (r5 == true) goto L53;
        return;
    L53:
        if (this.currentConfig.hiddenTrust == false) goto L69;
        this.currentConfig.hiddenTrust = false;
        this.mWifiManager.save(this.currentConfig, this.mSaveListener);
        return;
    L69:
        return;
    L46:
        if (this.mTrustedHelper.isLockScreenSecure() == true) goto L48;
    L49:
        this.mTrustedHelper.chooseOrConfirmPasswordDialog();
        return;
    L48:
        if (this.mTrustedHelper.isPasswordConfirmedSuccess() == true) goto L50;
    L24:
        if (r5 == false) goto L33;
        int r8 = this.mPrioritNetowk;
        if (r8 != (-1)) goto L28;
        this.mPrioritNetowk = this.mAccessPoint.networkId;
        Settings.Global.putString(getContentResolver(), GLOBAL_WIFI_PRIORIT_NETWORK, Integer.toString(this.mAccessPoint.networkId));
        return;
    L28:
        if (r8 >= 0) goto L30;
        return;
    L30:
        if (r8 == this.mAccessPoint.networkId) goto L62;
        showSetPrioritNetworkDialog(this.mPrioritNetowk);
        return;
    L62:
        return;
    L33:
        if (this.mPrioritNetowk != this.mAccessPoint.networkId) goto L64;
        this.mPrioritNetowk = -1;
        Settings.Global.putString(getContentResolver(), GLOBAL_WIFI_PRIORIT_NETWORK, "-1");
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (this.mForgetBtn != r2) goto L9;
        if (this.mClickForgetButton == false) goto L7;
        return;
    L7:
        this.mClickForgetButton = true;
        forget();
        return;
    L9:
        if (this.mModifyBtn != r2) goto L12;
        modifyConfig();
        return;
    L12:
        if (this.mDisconnectBtn != r2) goto L17;
        this.mWifiManager.disconnect();
        finish();
        return;
    }

    private void showSelectMacDialog() {
        boolean r1 = false;
        if (this.mRandomizationLevel != 1) goto L5;
        boolean r0 = false;
    L6:
        ArrayList r3 = new ArrayList();
        r3.add(new Item(getString(R.string.wifi_use_randomized_mac), !r0, null));
        String r5 = getString(R.string.wifi_use_device_mac);
        if (r0 != true) goto L9;
        r1 = true;
    L9:
        r3.add(new Item(r5, r1, null));
        this.popover = OPopoverHelper.showPopoverList(getActivity(), this.mPrivacy, r3, new AnonymousClass11(this), true);
        return;
    L5:
        r0 = true;
        goto L6
    }

    private void updatePrivacy(int r7) {
        NetworkDetailsTracker r0 = this.mNetworkDetailsTracker;
        int r1 = 1;
        if (r0 == null) goto L12;
        WifiEntry r2 = r0.getWifiEntry();
        OLog.d(this.TAG, "updatePrivacy wifiEntry:" + r2 + " position:" + r7);
        if (r7 == 0) goto L8;
        r1 = 0;
    L8:
        r2.setPrivacy(r1);
        if (r2.getConnectedState() != 2) goto L11;
        r2.disconnect(null);
        r2.connect(null);
    L11:
        updatePrivacyLevel();
        return;
    L12:
        WifiConfiguration r3 = this.currentConfig;
        if (r3 == null) goto L20;
        if (r7 == 0) goto L17;
        r1 = 0;
    L17:
        r3.setMacRandomizationSetting(r1);
        this.mWifiManager.save(this.currentConfig, this.mSaveListener);
        updatePrivacyLevel();
        return;
    }

    private void launchAdvancedOptions() {
        Bundle r0 = new Bundle();
        r0.putParcelable(AccessPointInfo.EXTRA_WIFI_CONFIGURATION, this.currentConfig);
        r0.putParcelable(AccessPointInfo.EXTRA_WIFI_INFO, this.mAccessPoint.getInfo());
        r0.putSerializable(AccessPointInfo.EXTRA_DETAILED_STATE, this.mAccessPoint.getState());
        start(AdvancedAccessPointSettingsFragment.class, r0);
    }

    private int dip2px(float r1) {
        return (int) ((r1 * this.mContext.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_START);
        super.onStart();
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    public void com_android_settings_wifi_AccessPointDetailFragment__onResume$___twin___() {
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_RESUME);
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_PAUSE);
        super.onPause();
        unregisterReceiver(this.mReceiver);
        if (this.resetConfirmFlagWhenPause == false) goto L8;
        TrustedNetworkHelper r2 = this.mTrustedHelper;
        if (r2 == null) goto L9;
        r2.resetPasswordConfirmedFlag();
        return;
    L9:
        return;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_STOP);
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_DESTROY);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment, androidx.lifecycle.LifecycleOwner
    public androidx.lifecycle.Lifecycle getLifecycle() {
        return this.mLifecycle;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context r1) {
        super.onAttach(r1);
        this.mLifecycle.onAttach(r1);
    }

    private void addActionButton() {
        if (GoogleHelp.INSTANCE.isShowNearbySharingBtn() == true) goto L5;
        return;
    L5:
        final Intent r0 = new Intent().setComponent(getNearbySharingComponent());
        Button r1 = createNearbyButton(r0, new AccessPointDetailFragment$$ExternalSyntheticLambda0(this, r0));
        if (r1 != null) goto L8;
        return;
    L8:
        ((ViewGroup) this.mRootView.findViewById(R.id.wifi_dpp_layout)).addView(r1);
    }

    /* JADX INFO: renamed from: lambda$addActionButton$5$com-android-settings-wifi-AccessPointDetailFragment, reason: not valid java name */
    /* synthetic */ void m658xe1bb1bae(Intent r6, View r7) {
        r6.setAction("android.intent.action.SEND");
        r6.addFlags(268435456);
        r6.addFlags(32768);
        Bundle r8 = new Bundle();
        WifiConfiguration r0 = (WifiConfiguration) this.mWifiConfigParcelable;
        String r1 = r0.SSID;
        String r2 = r0.preSharedKey;
        String r3 = WifiDppUtils.getSecurityString(r0);
        boolean r4 = r0.hiddenSSID;
        r8.putString(EXTRA_SSID, r1);
        r8.putString(EXTRA_PASSWORD, r2);
        r8.putString(EXTRA_SECURITY_TYPE, r3);
        r8.putBoolean(EXTRA_HIDDEN_SSID, r4);
        r6.putExtra(EXTRA_WIFI_CREDENTIALS_BUNDLE, r8);
        com.android.settings.Utils.startActivity(this.mContext, r6);
    }

    ComponentName getNearbySharingComponent() {
        String r0 = Settings.Secure.getString(this.mContext.getContentResolver(), "nearby_sharing_component");
        if (TextUtils.isEmpty(r0) == false) goto L6;
        r0 = this.mContext.getString(android.R.string.config_fingerprintFrrTargetComponent);
    L6:
        if (TextUtils.isEmpty(r0) == false) goto L10;
        return null;
    L10:
        return ComponentName.unflattenFromString(r0);
    }

    Button createNearbyButton(Intent r2, View.OnClickListener r3) {
        TargetInfo r4 = getNearbySharingTarget(r2);
        if (r4 != null) goto L6;
        return null;
    L6:
        Button r1 = createActionButton(r4.getDisplayIcon(this.mContext), r4.getDisplayLabel(), r3);
        r1.setAllCaps(false);
        return r1;
    }

    private Button createActionButton(Drawable r2, CharSequence r3, View.OnClickListener r4) {
        Button r5 = new Button(this.mContext);
        r5.setText(r3);
        r5.setTextColor(this.mContext.getColor(R.color.transparent));
        r5.setBackground(null);
        r5.setOnClickListener(r4);
        return r5;
    }

    private TargetInfo getNearbySharingTarget(Intent r10) {
        ComponentName r0 = getNearbySharingComponent();
        Drawable r1 = null;
        r1 = null;
        String r2 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        Intent r7 = new Intent(r10);
        r7.setComponent(r0);
        PackageManager r3 = getContext().getPackageManager();
        ResolveInfo r4 = r3.resolveActivity(r7, 128);
        if (r4 != null) goto L8;
    L26:
        OLog.e(this.TAG, "Device-specified nearby sharing component (" + r0 + ") not available");
        return null;
    L8:
        if (r4.activityInfo == null) goto L26;
        Bundle r9 = r4.activityInfo.metaData;
        if (r9 != null) goto L31;
        Drawable r11 = null;
    L19:
        if (TextUtils.isEmpty(r2) == false) goto L21;
        CharSequence r5 = r4.loadLabel(r3);
    L22:
        if (r11 != null) goto L24;
        r11 = r4.loadIcon(r3);
    L24:
        DisplayResolveInfo r6 = new DisplayResolveInfo(r10, r4, r5, "", r7, null);
        r6.setDisplayIcon(r11);
        return r6;
    L21:
        r5 = r2;
        goto L22
    L31:
        Resources r8 = r3.getResourcesForActivity(r0);     // Catch: Throwable -> L15
        String r12 = r8.getString(r9.getInt(CHIP_LABEL_METADATA_KEY));     // Catch: Throwable -> L15
        r1 = r8.getDrawable(r9.getInt(CHIP_ICON_METADATA_KEY));     // Catch: Throwable -> L28
    L16:
        r11 = r1;
        r2 = r12;
    L15:
        r12 = null;
        goto L16
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_wifi_AccessPointDetailFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AccessPointDetailFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wifi_AccessPointDetailFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_AccessPointDetailFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AccessPointDetailFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_wifi_AccessPointDetailFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_AccessPointDetailFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AccessPointDetailFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wifi_AccessPointDetailFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
