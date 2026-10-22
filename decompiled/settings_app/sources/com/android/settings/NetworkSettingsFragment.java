package com.android.settings;

import android.app.AlertDialog;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.RestrictionsManager;
import android.database.ContentObserver;
import android.net.ConnectivityManager;
import android.net.NetworkPolicyManager;
import android.net.wifi.WifiManager;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.UserManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.print.PrintSettingsFragment;
import com.android.settings.servicemanager.IPlatform;
import com.android.settings.sim.SIMUtils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.DevicePolicyUtils;
import com.android.settings.utils.UIUtils;
import com.android.settings.vpn2.VpnSettingsFragment;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkSettingsFragment extends BaseFragment implements View.OnClickListener {
    public static final String OTG_FUNC_SWITCH_DISABLE = "otg_current_state";
    public static final String OTG_STATE = "otg_settings_state";
    public static final int OTG_STATE_CLOSE_AND_DISABLE = 3;
    public static final int OTG_STATE_CLOSE_AND_ENABLE = 0;
    public static final int OTG_STATE_OPEN_AND_DISABLE = 2;
    public static final int OTG_STATE_OPEN_AND_ENABLE = 1;
    private static final String TETHER_CHOICE = "TETHER_TYPE";
    private final int MSG_UPDATE_BTN_STATE;
    private final int MSG_UPDATE_USB_STATE;
    private final int MSG_UPDATE_USB_STATE_DELAYED;
    private final int UPDATE_USB_BTN_DELAYED_TIME;
    private final int UPDATE_USB_STATE_DELAYED_TIME;
    private final int UPDATE_USB_STATE_TIME;
    private OCardListItem mCbsSettings;
    private ConnectivityManager mCm;
    private boolean mDataSaverEnabled;
    private Handler mHandler;
    private boolean mIsAdminUser;
    private boolean mMassStorageActive;
    private OCardListItem mNFCSettings;
    private final BroadcastReceiver mNfcReceiver;
    private OCardListItem mNubiaShareSettings;
    private final ContentObserver mOTGObserver;
    private OCardListItem mOTGSettings;
    private OSwitch mOTGSwitch;
    private OCardListItem mPersonalApSettings;
    private OCardListItem mPhoneChargeSettings;
    private NetworkPolicyManager mPolicyManager;
    private OCardListItem mPrint;
    private RestrictionsManager mRestrictionsManager;
    private int mTetherChoice;
    private String[] mTetherableIfaces;
    private String[] mTetheredIfaces;
    private String[] mTetheringErrored;
    private int mTitleStringId;
    private boolean mUsbConnected;
    private String[] mUsbRegexs;
    private UsbTetherChangeReceiver mUsbTetherReceiver;
    private OCardListItem mUsbTetherSettings;
    private boolean mUsbTetherStarted;
    private OSwitch mUsbTetherSwitch;
    private OCardListItem mUsbTetherUseConfig;
    private boolean mUsbUnavailable;
    private UserManager mUserManager;
    private OCardListItem mViewVPN;
    private OCardListItem mVoipSettings;
    private WifiManager mWifiManager;
    private IntentFilter nfcFilter;
    private IntentFilter tetherFilter;
    private BroadcastReceiver tetherStateChangeReceiver;

    private class UsbTetherChangeReceiver extends BroadcastReceiver {
        final /* synthetic */ NetworkSettingsFragment this$0;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            com_android_settings_NetworkSettingsFragment$UsbTetherChangeReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
        }

        private UsbTetherChangeReceiver(NetworkSettingsFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ UsbTetherChangeReceiver(NetworkSettingsFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        public void com_android_settings_NetworkSettingsFragment$UsbTetherChangeReceiver__onReceive$___twin___(Context r4, Intent r5) {
            String r6 = r5.getAction();
            OLog.d(NetworkSettingsFragment.access$2200(this.this$0), "onReceive: action:" + r6);
            if (r6.equals("android.net.conn.TETHER_STATE_CHANGED") == false) goto L13;
            ArrayList<String> r7 = r5.getStringArrayListExtra("availableArray");
            ArrayList<String> r0 = r5.getStringArrayListExtra("tetherArray");
            ArrayList<String> r8 = r5.getStringArrayListExtra("erroredArray");
            if (r7 == null) goto L7;
            NetworkSettingsFragment.access$102(this.this$0, (String[]) r7.toArray(new String[r7.size()]));
        L7:
            if (r0 == null) goto L9;
            NetworkSettingsFragment.access$202(this.this$0, (String[]) r0.toArray(new String[r0.size()]));
        L9:
            if (r8 == null) goto L11;
            NetworkSettingsFragment.access$302(this.this$0, (String[]) r8.toArray(new String[r8.size()]));
        L11:
            NetworkSettingsFragment.access$2300(this.this$0);
            return;
        L13:
            if (r6.equals("android.intent.action.MEDIA_SHARED") == false) goto L16;
            NetworkSettingsFragment.access$602(this.this$0, true);
            this.this$0.updateState();
            return;
        L16:
            if (r6.equals("android.intent.action.MEDIA_UNSHARED") == false) goto L19;
            NetworkSettingsFragment.access$602(this.this$0, false);
            this.this$0.updateState();
            return;
        L19:
            if (r6.equals("android.hardware.usb.action.USB_STATE") == false) goto L29;
            boolean r9 = r5.getBooleanExtra("connected", false);
            if (r9 == NetworkSettingsFragment.access$500(this.this$0)) goto L23;
            NetworkSettingsFragment.access$502(this.this$0, r9);
            NetworkSettingsFragment.access$000(this.this$0);
        L24:
            NetworkSettingsFragment.access$2400(this.this$0);
            return;
        L23:
            this.this$0.updateState();
            goto L24
        }

        @Insert("onReceive")
        public static void com_android_settings_NetworkSettingsFragment$UsbTetherChangeReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(UsbTetherChangeReceiver r7, Context r8, Intent r9) {
            Intrinsics.checkNotNullParameter(r8, "context");
            String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
            UsbTetherChangeReceiver r1 = r7;
            String r2 = r1.getClass().getName();
            String r3 = r1.getClass().getSimpleName();
            boolean r4 = Intrinsics.areEqual(SettingsInitialize.class, r1.getClass());
            String r5 = null;
            if (r9 == null) goto L5;
            String r6 = r9.getAction();
        L7:
            if (ArraysKt.contains(r0, r6) == false) goto L13;
            StringBuilder r10 = new StringBuilder("onReceive allowList ");
            if (r9 == null) goto L11;
            r5 = r9.getAction();
        L11:
            OLog.i("PrivacyHookForReceiver", r10.append(r5).toString());
            r7.com_android_settings_NetworkSettingsFragment$UsbTetherChangeReceiver__onReceive$___twin___(r8, r9);
            return;
        L13:
            GrantUtil r11 = GrantUtil.INSTANCE;
            Application r12 = SettingsApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
            if (r11.isSetupCompelete(r12) == true) goto L16;
            OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
            r7.com_android_settings_NetworkSettingsFragment$UsbTetherChangeReceiver__onReceive$___twin___(r8, r9);
            return;
        L16:
            String r13 = r3;
            if (r13 != null) goto L19;
        L22:
            boolean r14 = true;
        L23:
            if (r14 == false) goto L26;
            OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
            r7.com_android_settings_NetworkSettingsFragment$UsbTetherChangeReceiver__onReceive$___twin___(r8, r9);
            return;
        L26:
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
            if (r4 == true) goto L30;
            OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
            return;
        L30:
            GrantUtil.INSTANCE.applicationInit();
            r7.com_android_settings_NetworkSettingsFragment$UsbTetherChangeReceiver__onReceive$___twin___(r8, r9);
            return;
        L19:
            if (r13.length() == 0) goto L22;
            r14 = false;
            goto L23
        L5:
            r6 = null;
            goto L7
        }
    }

    public void com_android_settings_NetworkSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_NetworkSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_NetworkSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_NetworkSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public NetworkSettingsFragment() {
        this.mTitleStringId = R.string.more_network_settings;
        this.mTetherChoice = -1;
        this.MSG_UPDATE_USB_STATE = 4096;
        this.MSG_UPDATE_USB_STATE_DELAYED = 4097;
        this.UPDATE_USB_STATE_TIME = 1000;
        this.UPDATE_USB_STATE_DELAYED_TIME = 1100;
        this.MSG_UPDATE_BTN_STATE = 4098;
        this.UPDATE_USB_BTN_DELAYED_TIME = 2000;
        this.mHandler = new AnonymousClass1(this);
        final Handler r1 = new Handler();
        this.mOTGObserver = new AnonymousClass2(this, r1);
        this.tetherStateChangeReceiver = new AnonymousClass3(this);
        this.mNfcReceiver = new AnonymousClass4(this);
    }

    static /* synthetic */ void access$000(NetworkSettingsFragment r0) {
        r0.updateUsbStateImmediately();
    }

    static /* synthetic */ String[] access$100(NetworkSettingsFragment r0) {
        return r0.mTetherableIfaces;
    }

    static /* synthetic */ OCardListItem access$1000(NetworkSettingsFragment r0) {
        return r0.mUsbTetherUseConfig;
    }

    static /* synthetic */ String[] access$102(NetworkSettingsFragment r0, String[] r1) {
        r0.mTetherableIfaces = r1;
        return r1;
    }

    static /* synthetic */ int access$1100(NetworkSettingsFragment r0) {
        return r0.getOTGEnabled();
    }

    static /* synthetic */ void access$1200(NetworkSettingsFragment r0, int r1) {
        r0.updateOTAView(r1);
    }

    static /* synthetic */ void access$1300(NetworkSettingsFragment r0, int r1) {
        r0.setOTGState(r1);
    }

    static /* synthetic */ void access$1400(NetworkSettingsFragment r0) {
        r0.setupPersonalHotspotItemState();
    }

    static /* synthetic */ void access$1500(NetworkSettingsFragment r0) {
        r0.updateNfcView();
    }

    static /* synthetic */ String access$1600(NetworkSettingsFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ String access$1700(NetworkSettingsFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ OSwitch access$1800(NetworkSettingsFragment r0) {
        return r0.mUsbTetherSwitch;
    }

    static /* synthetic */ ConnectivityManager access$1900(NetworkSettingsFragment r0) {
        return r0.mCm;
    }

    static /* synthetic */ String[] access$200(NetworkSettingsFragment r0) {
        return r0.mTetheredIfaces;
    }

    static /* synthetic */ Handler access$2000(NetworkSettingsFragment r0) {
        return r0.mHandler;
    }

    static /* synthetic */ String[] access$202(NetworkSettingsFragment r0, String[] r1) {
        r0.mTetheredIfaces = r1;
        return r1;
    }

    static /* synthetic */ String access$2200(NetworkSettingsFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ void access$2300(NetworkSettingsFragment r0) {
        r0.updateUsbStateDelay();
    }

    static /* synthetic */ void access$2400(NetworkSettingsFragment r0) {
        r0.updateUsbConfigurationValues();
    }

    static /* synthetic */ String[] access$300(NetworkSettingsFragment r0) {
        return r0.mTetheringErrored;
    }

    static /* synthetic */ String[] access$302(NetworkSettingsFragment r0, String[] r1) {
        r0.mTetheringErrored = r1;
        return r1;
    }

    static /* synthetic */ void access$400(NetworkSettingsFragment r0, String[] r1, String[] r2, String[] r3) {
        r0.updateUsbState(r1, r2, r3);
    }

    static /* synthetic */ boolean access$500(NetworkSettingsFragment r0) {
        return r0.mUsbConnected;
    }

    static /* synthetic */ boolean access$502(NetworkSettingsFragment r0, boolean r1) {
        r0.mUsbConnected = r1;
        return r1;
    }

    static /* synthetic */ boolean access$600(NetworkSettingsFragment r0) {
        return r0.mMassStorageActive;
    }

    static /* synthetic */ boolean access$602(NetworkSettingsFragment r0, boolean r1) {
        r0.mMassStorageActive = r1;
        return r1;
    }

    static /* synthetic */ boolean access$700(NetworkSettingsFragment r0) {
        return r0.mDataSaverEnabled;
    }

    static /* synthetic */ boolean access$800(NetworkSettingsFragment r0) {
        return r0.mUsbTetherStarted;
    }

    static /* synthetic */ OCardListItem access$900(NetworkSettingsFragment r0) {
        return r0.mUsbTetherSettings;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        this.mRootView = r5.inflate(R.layout.network_settings_layout, r6, false);
        this.mWifiManager = (WifiManager) getSystemService("wifi");
        this.mTitleResId = Integer.valueOf(R.string.more_network_settings);
        IntentFilter r8 = new IntentFilter("android.net.wifi.WIFI_AP_STATE_CHANGED");
        this.tetherFilter = r8;
        r8.addAction("android.net.conn.TETHER_STATE_CHANGED");
        this.nfcFilter = new IntentFilter("android.nfc.action.ADAPTER_STATE_CHANGED");
        OCardListItem r9 = (OCardListItem) findViewByIdNullable(R.id.personal_app);
        this.mPersonalApSettings = r9;
        r9.setDefaultCustomEndView(3);
        this.mPersonalApSettings.showCustomEnd(true);
        OCardListItem r10 = (OCardListItem) findViewByIdNullable(R.id.nfc_setting);
        this.mNFCSettings = r10;
        if (Utils.isNfcSupport(this.mContext) == false) goto L5;
        int r2 = 0;
    L6:
        r10.setVisibility(r2);
        this.mNFCSettings.setDefaultCustomEndView(3);
        this.mNFCSettings.showCustomEnd(true);
        this.mViewVPN = (OCardListItem) findViewByIdNullable(R.id.item_vpn);
        this.mPhoneChargeSettings = (OCardListItem) findViewByIdNullable(R.id.charge_button);
        this.mVoipSettings = (OCardListItem) findViewByIdNullable(R.id.voip_setting_entry);
        this.mCbsSettings = (OCardListItem) findViewByIdNullable(R.id.item_cbs);
        this.mPrint = (OCardListItem) findViewByIdNullable(R.id.print);
        OCardListItem r11 = (OCardListItem) findViewByIdNullable(R.id.item_usb_tether_config);
        this.mUsbTetherUseConfig = r11;
        r11.setOnContentClickListener(new NetworkSettingsFragment$$ExternalSyntheticLambda1(this));
        OCardListItem r12 = (OCardListItem) findViewByIdNullable(R.id.item_usb_tether_switch);
        this.mUsbTetherSettings = r12;
        r12.setDefaultCustomEndView(1);
        this.mUsbTetherSettings.showCustomEnd(true);
        this.mUsbTetherSwitch = (OSwitch) this.mUsbTetherSettings.getCustomEndView();
        this.mUsbTetherSettings.showSubTitle(true);
        this.mNubiaShareSettings = (OCardListItem) findViewByIdNullable(R.id.item_nubia_share);
        if (SettingsFeature.isSupportNubiaShare() == true) goto L9;
    L11:
        this.mNubiaShareSettings.setVisibility(8);
    L12:
        this.mNubiaShareSettings.setOnContentClickListener(new AnonymousClass5(this));
        OCardListItem r13 = (OCardListItem) findViewByIdNullable(R.id.item_otg_switch);
        this.mOTGSettings = r13;
        r13.setDefaultCustomEndView(1);
        this.mOTGSettings.showCustomEnd(true);
        this.mOTGSettings.showSubTitle(true);
        this.mOTGSwitch = (OSwitch) this.mOTGSettings.getCustomEndView();
        this.mPersonalApSettings.setOnContentClickListener(new NetworkSettingsFragment$$ExternalSyntheticLambda2(this));
        this.mNFCSettings.setOnContentClickListener(new NetworkSettingsFragment$$ExternalSyntheticLambda3(this));
        this.mViewVPN.setOnContentClickListener(new NetworkSettingsFragment$$ExternalSyntheticLambda4(this));
        this.mPhoneChargeSettings.setOnContentClickListener(new NetworkSettingsFragment$$ExternalSyntheticLambda5(this));
        this.mVoipSettings.setOnContentClickListener(new NetworkSettingsFragment$$ExternalSyntheticLambda6(this));
        this.mCbsSettings.setOnContentClickListener(new NetworkSettingsFragment$$ExternalSyntheticLambda7(this));
        this.mPrint.setOnContentClickListener(this);
        if (((IPlatform) ServiceManager.getService(IPlatform.class)).isPrintEnable() == false) goto L15;
        this.mPrint.setVisibility(0);
    L16:
        initUsbTether(r7);
        UIUtils.setUpBottomPaddingOnApplyWindowInsets((ViewGroup) findViewByIdNullable(R.id.page_container));
        return this.mRootView;
    L15:
        this.mPrint.setVisibility(8);
        goto L16
    L9:
        if (((IPlatform) ServiceManager.getService(IPlatform.class)).isShowNubiaShare() == false) goto L11;
        this.mNubiaShareSettings.setVisibility(0);
        goto L12
    L5:
        r2 = 8;
        goto L6
    }

    /* JADX INFO: renamed from: lambda$onCreateView$0$com-android-settings-NetworkSettingsFragment, reason: not valid java name */
    /* synthetic */ void m165x80fe053c(View r1) {
        onClick(this.mUsbTetherUseConfig);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$1$com-android-settings-NetworkSettingsFragment, reason: not valid java name */
    /* synthetic */ void m166x3a7592db(View r1) {
        onClick(this.mPersonalApSettings);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$2$com-android-settings-NetworkSettingsFragment, reason: not valid java name */
    /* synthetic */ void m167xf3ed207a(View r1) {
        onClick(this.mNFCSettings);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$3$com-android-settings-NetworkSettingsFragment, reason: not valid java name */
    /* synthetic */ void m168xad64ae19(View r1) {
        onClick(this.mViewVPN);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$4$com-android-settings-NetworkSettingsFragment, reason: not valid java name */
    /* synthetic */ void m169x66dc3bb8(View r1) {
        onClick(this.mPhoneChargeSettings);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$5$com-android-settings-NetworkSettingsFragment, reason: not valid java name */
    /* synthetic */ void m170x2053c957(View r1) {
        onClick(this.mVoipSettings);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$6$com-android-settings-NetworkSettingsFragment, reason: not valid java name */
    /* synthetic */ void m171xd9cb56f6(View r1) {
        onClick(this.mCbsSettings);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        setupPersonalHotspotItemState();
        updateNfcView();
        if ((r1 instanceof ViewGroup) == false) goto L6;
        ((ViewGroup) r1).setClipChildren(false);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r2) {
        super.onViewStateRestored(r2);
        updateViews();
        this.mOTGSwitch.setOnCheckedChangeListener(new AnonymousClass6(this));
        this.mUsbTetherSwitch.setOnCheckedChangeListener(new AnonymousClass7(this));
    }

    private void initUsbTether(Bundle r3) {
        if (r3 == null) goto L4;
        this.mTetherChoice = r3.getInt(TETHER_CHOICE);
    L4:
        NetworkPolicyManager r4 = NetworkPolicyManager.from(this.mContext);
        this.mPolicyManager = r4;
        this.mDataSaverEnabled = r4.getRestrictBackground();
        this.mRestrictionsManager = (RestrictionsManager) getSystemService("restrictions");
        UserManager r5 = (UserManager) getSystemService(PickApplicationActivity.EXTRA_USER);
        this.mUserManager = r5;
        this.mIsAdminUser = r5.isAdminUser();
        ConnectivityManager r6 = (ConnectivityManager) getSystemService("connectivity");
        this.mCm = r6;
        this.mUsbRegexs = r6.getTetherableUsbRegexs();
        this.mMassStorageActive = "shared".equals(Environment.getExternalStorageState());
        String[] r7 = this.mUsbRegexs;
        if (r7 != null) goto L7;
    L9:
        boolean r8 = false;
    L10:
        this.mUsbConnected = r8;
        if (r8 == true) goto L13;
    L14:
        this.mUsbConnected = false;
        this.mUsbTetherSettings.setVisibility(8);
        this.mUsbTetherUseConfig.setVisibility(8);
    L16:
        if (isUiRestricted() == false) goto L19;
        this.mUsbUnavailable = true;
        return;
    L19:
        return;
    L13:
        if (Utils.isMonkeyRunning() == false) goto L16;
    L7:
        if (r7.length == 0) goto L9;
        r8 = true;
        goto L10
    }

    protected boolean isUiRestricted() {
        if (isRestrictedAndNotProviderProtected() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mIsAdminUser == false) goto L8;
        return false;
    }

    protected boolean isRestrictedAndNotProviderProtected() {
        if (this.mUserManager.hasUserRestriction("no_config_tethering") == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mRestrictionsManager.hasRestrictionsProvider() == true) goto L7;
        return true;
    }

    private void initCbsSetting() {
        if (SIMUtils.isShowCbsSettings(getActivity()) == false) goto L5;
        this.mCbsSettings.setVisibility(0);
        return;
    L5:
        this.mCbsSettings.setVisibility(8);
    }

    private void updatePhoneSettings() {
        this.mPhoneChargeSettings.setVisibility(8);
        if (SettingsFeature.isVoipSupport(this.mContext) == true) goto L5;
        this.mVoipSettings.setVisibility(8);
        return;
    L5:
        this.mVoipSettings.setVisibility(0);
        View r2 = findViewByIdNullable(R.id.voip_setting_entry_bottom);
        if (r2 == null) goto L10;
        r2.setVisibility(0);
        return;
    }

    public static AlertDialog showInstallChargeDialog(final Context r2, AlertDialog r3) {
        if (r2 != null) goto L5;
        return null;
    L5:
        if (r3 != null) goto L8;
        r3 = new AlertDialog.Builder(r2).setTitle(R.string.dlg_title_notice).setMessage(R.string.dialog_recharge_app_not_installed).setNegativeButton(android.R.string.cancel, null).setPositiveButton(R.string.install_text, new AnonymousClass8(r2)).create();
    L8:
        if (r3.isShowing() == true) goto L10;
        r3.show();
    L10:
        return r3;
    }

    public void updateViews() {
        setupPersonalHotspotItemState();
        updateNfcView();
        updateOTAView(getOTGEnabled());
        updatePhoneSettings();
        registerEvents();
        initCbsSetting();
        updateUsbStateImmediately();
        if (Utils.hasTelephonyFeature(this.mContext) == true) goto L6;
        this.mPersonalApSettings.setVisibility(8);
        this.mPhoneChargeSettings.setVisibility(8);
        this.mVoipSettings.setVisibility(8);
        this.mUsbTetherSettings.setVisibility(8);
        this.mUsbTetherUseConfig.setVisibility(8);
    L6:
        if (Utils.isOnlySupportTnt() == false) goto L9;
        this.mNFCSettings.setVisibility(8);
    L9:
        if (this.mIsExtDisplaying == false) goto L12;
        this.mUsbTetherSettings.setVisibility(8);
        this.mUsbTetherUseConfig.setVisibility(8);
        this.mPhoneChargeSettings.setVisibility(8);
    L12:
        if (((UserManager) this.mContext.getSystemService(UserManager.class)).hasUserRestriction("no_config_tethering") == false) goto L14;
        this.mUsbTetherSettings.setOnContentClickListener(new NetworkSettingsFragment$$ExternalSyntheticLambda0(this));
    L16:
        if (DevicePolicyUtils.hasUserRestriction(getActivity(), "no_config_tethering") == false) goto L18;
        OCardListItemUtils.setContentContainerEnabled(this.mPersonalApSettings, false);
        this.mPersonalApSettings.getContentContainer().setClickable(true);
        OCardListItemUtils.setContentContainerEnabled(this.mUsbTetherSettings, false);
        this.mUsbTetherSettings.getContentContainer().setClickable(true);
        return;
    L18:
        OCardListItemUtils.setContentContainerEnabled(this.mPersonalApSettings, true);
        OCardListItemUtils.setContentContainerEnabled(this.mUsbTetherSettings, true);
        return;
    L14:
        this.mUsbTetherSettings.setOnContentClickListener(null);
        goto L16
    }

    /* JADX INFO: renamed from: lambda$updateViews$7$com-android-settings-NetworkSettingsFragment, reason: not valid java name */
    /* synthetic */ void m172x3fe5d22a(View r1) {
        DevicePolicyUtils.trySendShowAdminSupportDetailsIntent(getActivity(), "no_config_tethering");
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    public boolean isUsbTetherStarted() {
        return this.mUsbTetherStarted;
    }

    public void setUsbStarted(boolean r1) {
        this.mUsbTetherStarted = r1;
    }

    public void updateState() {
        if (isAdded() == true) goto L5;
        return;
    L5:
        this.mTetherableIfaces = this.mCm.getTetherableIfaces();
        this.mTetheredIfaces = this.mCm.getTetheredIfaces();
        this.mTetheringErrored = this.mCm.getTetheringErroredIfaces();
        updateUsbStateDelay();
    }

    private void updateUsbStateDelay() {
        OLog.d(this.TAG, "updateUsbStateDelay: ");
        this.mHandler.removeMessages(4097);
        this.mHandler.sendEmptyMessageDelayed(4097, 1100);
    }

    private void updateUsbStateImmediately() {
        this.mTetherableIfaces = this.mCm.getTetherableIfaces();
        this.mTetheredIfaces = this.mCm.getTetheredIfaces();
        String[] r0 = this.mCm.getTetheringErroredIfaces();
        this.mTetheringErrored = r0;
        updateUsbState(this.mTetherableIfaces, this.mTetheredIfaces, r0);
    }

    private void updateUsbState(String[] r12, String[] r13, String[] r14) {
        this.mDataSaverEnabled = this.mPolicyManager.getRestrictBackground();
        int r2 = 0;
        if (this.mUsbConnected == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        int r3 = r12.length;
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L17;
        String r5 = r12[r4];
        String[] r6 = this.mUsbRegexs;
        int r7 = r6.length;
        int r8 = 0;
    L11:
        if (r8 >= r7) goto L16;
        if (r5.matches(r6[r8]) == true) goto L14;
        r8 = r8 + 1;
        goto L11
    L14:
        int r15 = this.mCm.getLastTetherError(r5);
    L18:
        int r9 = r13.length;
        int r10 = 0;
    L19:
        if (r10 >= r9) goto L27;
        String r11 = r13[r10];
        String[] r16 = this.mUsbRegexs;
        int r17 = r16.length;
        int r18 = 0;
    L21:
        if (r18 >= r17) goto L26;
        if (r11.matches(r16[r18]) == true) goto L24;
        r18 = r18 + 1;
        goto L21
    L24:
        boolean r19 = true;
    L28:
        int r20 = r14.length;
        int r21 = 0;
    L29:
        if (r21 >= r20) goto L37;
        String r22 = r14[r21];
        String[] r23 = this.mUsbRegexs;
        int r24 = r23.length;
        int r25 = 0;
    L31:
        if (r25 >= r24) goto L36;
        if (r22.matches(r23[r25]) == true) goto L34;
        r25 = r25 + 1;
        goto L31
    L34:
        boolean r110 = true;
    L38:
        if (r19 == false) goto L41;
        boolean r26 = this.mDataSaverEnabled;
        this.mUsbTetherStarted = false;
        this.mUsbTetherSwitch.setChecked(true);
        int r27 = R.string.usb_tethering_active_subtext;
    L40:
        int r28 = 0;
    L68:
        if (r0 == true) goto L70;
        this.mUsbTetherStarted = false;
    L70:
        OCardListItem r29 = this.mUsbTetherSettings;
        if (r0 == false) goto L74;
        if (r26 == true) goto L74;
        int r30 = 0;
    L75:
        r29.setVisibility(r30);
        OCardListItem r31 = this.mUsbTetherUseConfig;
        if (r0 == false) goto L79;
        if (r26 == true) goto L79;
    L80:
        r31.setVisibility(r2);
        this.mUsbTetherSettings.setAlpha(1.0f);
        this.mUsbTetherSettings.setSubTitle(getString(r27));
        this.mUsbTetherSettings.showSubTitle(true);
        if (r28 <= 0) goto L83;
        ToastUtils.show(getActivity(), r28);
    L83:
        OLog.d(this.TAG, "updateUsbState: usbTethered:" + r19 + ", usbAvailable:" + r0 + ", usbErrored:" + r110 + ", mMassStorageActive:" + this.mMassStorageActive + ", usbError:" + r15 + ", shouldDisableSwitch:" + r26);
        if (isAdded() == false) goto L96;
        OLog.d(this.TAG, "tips:" + getString(r27));
        return;
    L96:
        return;
    L79:
        r2 = 8;
    L74:
        r30 = 8;
        goto L75
    L41:
        r27 = R.string.usb_tethering_errored_subtext;
        if (r0 == false) goto L61;
        if (r15 == 0) goto L47;
        if (r15 == 1) goto L47;
        this.mUsbTetherSettings.setSubTitle(getString(R.string.usb_tethering_errored_subtext));
        this.mUsbTetherStarted = false;
        int r32 = R.string.usb_tethering_errored_subtext;
    L48:
        this.mUsbTetherSwitch.setChecked(false);
        if (isPreventClickFast() == false) goto L51;
    L56:
        boolean r33 = true;
    L58:
        if (isPreventClickFast() == false) goto L60;
        this.mHandler.sendEmptyMessageDelayed(4098, 2000);
    L60:
        boolean r111 = r33;
        r28 = r32;
        r26 = r111;
        goto L68
    L51:
        if (this.mDataSaverEnabled == true) goto L56;
        if (this.mUsbTetherStarted == true) goto L56;
        r33 = false;
    L47:
        r27 = R.string.usb_tethering_available_subtext;
        r32 = 0;
        goto L48
    L61:
        if (r110 == false) goto L65;
        this.mUsbTetherSwitch.setChecked(false);
    L63:
        r26 = true;
        r28 = r27;
        goto L68
    L65:
        if (this.mMassStorageActive == false) goto L67;
        this.mUsbTetherSwitch.setChecked(false);
        r27 = R.string.usb_tethering_storage_active_subtext;
        goto L63
    L67:
        this.mUsbTetherSwitch.setChecked(false);
        r27 = R.string.usb_tethering_unavailable_subtext;
        r26 = true;
        goto L40
    L36:
        r21 = r21 + 1;
        goto L29
    L37:
        r110 = false;
        goto L38
    L26:
        r10 = r10 + 1;
        goto L19
    L27:
        r19 = false;
        goto L28
    L16:
        r4 = r4 + 1;
        goto L9
    L17:
        r15 = 0;
        goto L18
    L5:
        if (this.mMassStorageActive == true) goto L7;
        r0 = true;
        goto L8
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        unRegisterEvents();
    }

    private void registerEvents() {
        getContentResolver().registerContentObserver(android.provider.Settings.Global.getUriFor("otg_current_state"), true, this.mOTGObserver);
        registerReceiver(this.tetherStateChangeReceiver, this.tetherFilter);
        if (Utils.isNfcSupport(this.mContext) == false) goto L6;
        registerReceiver(this.mNfcReceiver, this.nfcFilter);
    L6:
        if (this.mUsbUnavailable == true) goto L11;
        this.mUsbTetherReceiver = new UsbTetherChangeReceiver(this, null);
        this.mMassStorageActive = "shared".equals(Environment.getExternalStorageState());
        IntentFilter r0 = new IntentFilter("android.net.conn.TETHER_STATE_CHANGED");
        Intent r1 = registerReceiver(this.mUsbTetherReceiver, r0);
        IntentFilter r2 = new IntentFilter();
        r2.addAction("android.intent.action.MEDIA_SHARED");
        r2.addAction("android.intent.action.MEDIA_UNSHARED");
        r2.addDataScheme("file");
        registerReceiver(this.mUsbTetherReceiver, r2);
        IntentFilter r3 = new IntentFilter();
        r3.addAction("android.hardware.usb.action.USB_STATE");
        registerReceiver(this.mUsbTetherReceiver, r3);
        if (r1 == null) goto L12;
        this.mUsbTetherReceiver.onReceive(this.mContext, r1);
        return;
    L12:
        return;
    }

    private void unRegisterEvents() {
        getContentResolver().unregisterContentObserver(this.mOTGObserver);
        unregisterReceiver(this.tetherStateChangeReceiver);
        if (Utils.isNfcSupport(this.mContext) == false) goto L6;
        unregisterReceiver(this.mNfcReceiver);
    L6:
        if (this.mUsbUnavailable == true) goto L9;
        unregisterReceiver(this.mUsbTetherReceiver);
        this.mUsbTetherReceiver = null;
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r4) {
        Intent r0 = new Intent();
        r0.putExtra("back_text_id", R.string.more_network_settings);
        if (r4 != this.mPersonalApSettings) goto L9;
        SettingsTracker.onItemClick(701);
        if (DevicePolicyUtils.trySendShowAdminSupportDetailsIntent(getActivity(), "no_config_tethering") == false) goto L7;
        return;
    L7:
        start(WifiApSettingFragment.class);
        return;
    L9:
        if (r4 != this.mNFCSettings) goto L12;
        start(NfcSettingsFragment.class);
        SettingsTracker.onItemClick(702);
        return;
    L12:
        if (r4 != this.mViewVPN) goto L15;
        start(VpnSettingsFragment.class);
        SettingsTracker.onItemClick(703);
        return;
    L15:
        if (r4 != this.mPhoneChargeSettings) goto L18;
        launchCootekRecharge();
        SettingsTracker.onItemClick(704);
        return;
    L18:
        if (r4 != this.mVoipSettings) goto L21;
        Intent r5 = new Intent();
        r5.setClassName(Constants.PKG_PHONE_VOIP, "com.bytedanceos.voip.setting.VoipCallSetting");
        r5.putExtra("back_text", getResources().getString(this.mTitleStringId));
        Utils.startActivity(this._mActivity, r5);
        SettingsTracker.onItemClick(705);
        return;
    L21:
        if (r4 != this.mCbsSettings) goto L24;
        Intent r6 = new Intent();
        r6.putExtra(Utils.EXTRA_FROM_SETTINGS, true);
        r6.setClassName("com.android.cellbroadcastreceiver", "com.android.cellbroadcastreceiver.CellBroadcastSettingsBytedance");
        Utils.startActivity(this._mActivity, r6);
        return;
    L24:
        if (r4 != this.mPrint.getContentContainer()) goto L27;
        start(PrintSettingsFragment.class);
        return;
    L27:
        if (r4 != this.mUsbTetherUseConfig) goto L37;
        r0.putExtra("title_id", R.string.select_usb_config_title);
        r0.setClass(this._mActivity, UsbConfigSettingsActivity.class);
        Utils.startActivity(this._mActivity, r0);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r2) {
        super.onSaveInstanceState(r2);
        r2.putInt(TETHER_CHOICE, this.mTetherChoice);
    }

    private void setupPersonalHotspotItemState() {
        if (isAdded() == true) goto L6;
        return;
    L6:
        if (isPersonalHotspotOn() == false) goto L8;
        String r0 = getString(R.string.personal_hotspot_state_on);
    L9:
        this.mPersonalApSettings.setEndDetailText(r0);
        return;
    L8:
        r0 = getString(R.string.personal_hotspot_state_off);
        goto L9
    }

    private boolean isPersonalHotspotOn() {
        return this.mWifiManager.isWifiApEnabled();
    }

    private void updateNfcView() {
        NfcAdapter r0 = NfcAdapter.getDefaultAdapter(this.mContext);
        if (r0 == null) goto L5;
        int r1 = r0.getAdapterState();
    L6:
        setNfcSubTitle(r1);
        return;
    L5:
        r1 = 1;
        goto L6
    }

    private void setNfcSubTitle(int r2) {
        if (r2 != 1) goto L5;
        String r3 = getString(R.string.bluetooth_state_closed);
    L9:
        OCardListItem r1 = this.mNFCSettings;
        if (r1 == null) goto L13;
        r1.setEndDetailText(r3);
        return;
    L13:
        return;
    L5:
        if (r2 == 3) goto L7;
        r3 = "";
        goto L9
    L7:
        r3 = getString(R.string.nfc_state_opened);
        goto L9
    }

    private void launchCootekRecharge() {
        Intent r0 = new Intent();
        r0.setClassName(Constants.PKG_PHONE_CHARGE, "com.bytedanceos.recharge.activity.RechargeServiceActivity");
        r0.putExtra("back_text_res_name", "more_network_settings");
        r0.putExtra("exposure", 1);
        Utils.startActivity(this._mActivity, r0);
    }

    private boolean isPreventClickFast() {
        return this.mHandler.hasMessages(4096);
    }

    private int getOTGEnabled() {
        return android.provider.Settings.Global.getInt(this.mContext.getContentResolver(), "otg_current_state", 0);
    }

    private void setOTGState(int r2) {
        android.provider.Settings.Global.putInt(this.mContext.getContentResolver(), "otg_settings_state", r2);
    }

    private void updateOTAView(int r4) {
        if (r4 == 0) goto L13;
        if (r4 != 1) goto L6;
        this.mOTGSettings.setEnabled(true);
        this.mOTGSwitch.setChecked(true);
        return;
    L6:
        if (r4 != 2) goto L8;
        this.mOTGSettings.setEnabled(false);
        this.mOTGSwitch.setChecked(true);
        return;
    L8:
        if (r4 != 3) goto L18;
        this.mOTGSettings.setEnabled(false);
        this.mOTGSwitch.setChecked(false);
        return;
    L18:
        return;
    L13:
        this.mOTGSettings.setEnabled(true);
        this.mOTGSwitch.setChecked(false);
    }

    private void updateUsbConfigurationValues() {
        if (this.mUsbTetherUseConfig == null) goto L6;
        int r0 = UsbConfigSettingsActivity.getCurrentUsbConfigTitle(this.mContext);
        OCardListItemUtils.setCustomEndTipTextView(this.mUsbTetherUseConfig, getResources().getString(r0));
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_NetworkSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(NetworkSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_NetworkSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_NetworkSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(NetworkSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_NetworkSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_NetworkSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(NetworkSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_NetworkSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
