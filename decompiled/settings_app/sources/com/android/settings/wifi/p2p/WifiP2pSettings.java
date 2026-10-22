package com.android.settings.wifi.p2p;

import android.app.Application;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pDeviceList;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pGroupList;
import android.net.wifi.p2p.WifiP2pInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;
import androidx.recyclerview.widget.RecyclerView;
import com.GlobalProxyLancet;
import com.android.settings.R;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.android.settings.SettingsPreferenceFragment23;
import com.android.settings.bluetooth.DeviceRenameDialogFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.wifi.preference.NoTitlePreferenceCategory;
import com.android.settings.wifi.preference.SectionLayoutPreference;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.privacy.GrantUtil;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class WifiP2pSettings extends SettingsPreferenceFragment23 implements WifiP2pManager.GroupInfoListener, WifiP2pManager.PeerListListener, WifiP2pManager.PersistentGroupInfoListener, WifiP2pSettinsAdapter.OnItemClickListener {
    private static final boolean DBG = true;
    private static final int DIALOG_CANCEL_CONNECT = 2;
    private static final int DIALOG_CONFIRM_CONNECT = 5;
    private static final int DIALOG_DELETE_GROUP = 4;
    private static final int DIALOG_DISCONNECT = 1;
    private static final int DIALOG_RENAME = 3;
    private static final int MAX_P2P_NAME_LENGTH_BYTES = 32;
    private static final int MENU_ID_RENAME = 2;
    private static final int MENU_ID_SEARCH = 1;
    private static final int ORDER_AVAILABLE_PEER_GROUP = 1000;
    private static final int ORDER_FOOTER = 10000;
    private static final int ORDER_HEADER = 0;
    private static final String SAVE_DEVICE_NAME = "DEV_NAME";
    private static final String SAVE_DIALOG_PEER = "PEER_STATE";
    private static final String SAVE_SELECTED_GROUP = "GROUP_NAME";
    private static final String TAG = "WifiP2pSettings";
    private PreferenceGroup mAvailablePeerGroup;
    private DialogInterface.OnClickListener mCancelConnectListener;
    private WifiP2pManager.Channel mChannel;
    private DialogInterface.OnClickListener mConfirmConnectListener;
    private int mConnectedDevices;
    private WifiP2pGroup mConnectedGroup;
    private DialogInterface.OnClickListener mDeleteGroupListener;
    private EditText mDeviceNameText;
    private DialogInterface.OnClickListener mDisconnectListener;
    private SectionLayoutPreference mFooterPreference;
    private RelativeLayout mHeaderLayout;
    private SectionLayoutPreference mHeaderPreference;
    private final IntentFilter mIntentFilter;
    private boolean mLastGroupFormed;
    private WifiP2pDeviceList mPeers;
    private WifiP2pPersistentGroupAdapter mPersistentGroupAdapter;
    private ListView mPersistentGroupsListView;
    private OSectionTitleBar mPersistentGroupsTitle;
    private final BroadcastReceiver mReceiver;
    private DialogInterface.OnClickListener mRenameListener;
    private DeviceRenameDialogFragment mRenamefragment;
    private String mSavedDeviceName;
    private OSectionTitleBar mSearchTips;
    private WifiP2pGroup mSelectedGroup;
    private String mSelectedGroupName;
    private WifiP2pPeer mSelectedWifiPeer;
    private int mStaDisconnectedScanIntervalWhenP2pConnected;
    private WifiP2pDevice mThisDevice;
    private OCardListItem mThisDeviceItem;
    private boolean mWifiP2pEnabled;
    private WifiP2pManager mWifiP2pManager;
    private boolean mWifiP2pSearching;
    private OAlertDialogBuilder p2pSettingsDialog;

    /* JADX INFO: renamed from: com.android.settings.wifi.p2p.WifiP2pSettings$1, reason: invalid class name */
    class AnonymousClass1 extends BroadcastReceiver {
        final /* synthetic */ WifiP2pSettings this$0;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            com_android_settings_wifi_p2p_WifiP2pSettings$1_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
        }

        AnonymousClass1(WifiP2pSettings r1) {
            this.this$0 = r1;
        }

        public void com_android_settings_wifi_p2p_WifiP2pSettings$1__onReceive$___twin___(Context r6, Intent r7) {
            String r8 = r7.getAction();
            boolean r1 = false;
            if ("android.net.wifi.p2p.STATE_CHANGED".equals(r8) == false) goto L9;
            WifiP2pSettings r9 = this.this$0;
            if (r7.getIntExtra("wifi_p2p_state", 1) != 2) goto L7;
            r1 = true;
        L7:
            WifiP2pSettings.access$002(r9, r1);
            WifiP2pSettings.access$100(this.this$0);
            return;
        L9:
            if ("android.net.wifi.p2p.PEERS_CHANGED".equals(r8) == false) goto L12;
            WifiP2pSettings.access$202(this.this$0, (WifiP2pDeviceList) r7.getParcelableExtra("wifiP2pDeviceList"));
            WifiP2pSettings.access$300(this.this$0);
            return;
        L12:
            if ("android.net.wifi.p2p.CONNECTION_STATE_CHANGE".equals(r8) == false) goto L23;
            if (WifiP2pSettings.access$400(this.this$0) != null) goto L16;
            return;
        L16:
            NetworkInfo r10 = (NetworkInfo) r7.getParcelableExtra("networkInfo");
            WifiP2pSettings.access$502(this.this$0, ((WifiP2pInfo) r7.getParcelableExtra("wifiP2pInfo")).groupFormed);
            if (r10.isConnected() == false) goto L20;
            OLog.d(WifiP2pSettings.TAG, "Connected");
            return;
        L20:
            if (WifiP2pSettings.access$500(this.this$0) == true) goto L42;
            WifiP2pSettings.access$600(this.this$0);
            return;
        L42:
            return;
        L23:
            if ("android.net.wifi.p2p.THIS_DEVICE_CHANGED".equals(r8) == false) goto L26;
            WifiP2pSettings.access$400(this.this$0).requestDeviceInfo(WifiP2pSettings.access$700(this.this$0), new WifiP2pSettings$1$$ExternalSyntheticLambda0(this));
            return;
        L26:
            if ("android.net.wifi.p2p.DISCOVERY_STATE_CHANGE".equals(r8) == false) goto L32;
            int r11 = r7.getIntExtra("discoveryState", 1);
            OLog.d(WifiP2pSettings.TAG, "Discovery state changed: " + r11);
            if (r11 != 2) goto L30;
            WifiP2pSettings.access$1000(this.this$0, true);
            return;
        L30:
            WifiP2pSettings.access$1000(this.this$0, false);
            return;
        L32:
            if ("android.net.wifi.p2p.action.WIFI_P2P_PERSISTENT_GROUPS_CHANGED".equals(r8) == true) goto L34;
            return;
        L34:
            if (WifiP2pSettings.access$400(this.this$0) != null) goto L36;
            return;
        L36:
            if (WifiP2pSettings.access$700(this.this$0) == null) goto L49;
            WifiP2pSettings.access$400(this.this$0).requestPersistentGroupInfo(WifiP2pSettings.access$700(this.this$0), this.this$0);
            return;
        }

        /* JADX INFO: renamed from: lambda$onReceive$0$com-android-settings-wifi-p2p-WifiP2pSettings$1, reason: not valid java name */
        /* synthetic */ void m728x9844ef41(WifiP2pDevice r2) {
            WifiP2pSettings.access$802(this.this$0, r2);
            WifiP2pSettings.access$900(this.this$0);
        }

        @Insert("onReceive")
        public static void com_android_settings_wifi_p2p_WifiP2pSettings$1_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(AnonymousClass1 r7, Context r8, Intent r9) {
            Intrinsics.checkNotNullParameter(r8, "context");
            String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
            AnonymousClass1 r1 = r7;
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
            r7.com_android_settings_wifi_p2p_WifiP2pSettings$1__onReceive$___twin___(r8, r9);
            return;
        L13:
            GrantUtil r11 = GrantUtil.INSTANCE;
            Application r12 = SettingsApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
            if (r11.isSetupCompelete(r12) == true) goto L16;
            OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
            r7.com_android_settings_wifi_p2p_WifiP2pSettings$1__onReceive$___twin___(r8, r9);
            return;
        L16:
            String r13 = r3;
            if (r13 != null) goto L19;
        L22:
            boolean r14 = true;
        L23:
            if (r14 == false) goto L26;
            OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
            r7.com_android_settings_wifi_p2p_WifiP2pSettings$1__onReceive$___twin___(r8, r9);
            return;
        L26:
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
            if (r4 == true) goto L30;
            OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
            return;
        L30:
            GrantUtil.INSTANCE.applicationInit();
            r7.com_android_settings_wifi_p2p_WifiP2pSettings$1__onReceive$___twin___(r8, r9);
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

    public void com_android_settings_wifi_p2p_WifiP2pSettings__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_wifi_p2p_WifiP2pSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_wifi_p2p_WifiP2pSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ boolean access$002(WifiP2pSettings r0, boolean r1) {
        r0.mWifiP2pEnabled = r1;
        return r1;
    }

    static /* synthetic */ void access$100(WifiP2pSettings r0) {
        r0.handleP2pStateChanged();
    }

    static /* synthetic */ void access$1000(WifiP2pSettings r0, boolean r1) {
        r0.updateSearchState(r1);
    }

    static /* synthetic */ EditText access$1100(WifiP2pSettings r0) {
        return r0.mDeviceNameText;
    }

    static /* synthetic */ WifiP2pPeer access$1200(WifiP2pSettings r0) {
        return r0.mSelectedWifiPeer;
    }

    static /* synthetic */ WifiP2pGroup access$1300(WifiP2pSettings r0) {
        return r0.mSelectedGroup;
    }

    static /* synthetic */ WifiP2pGroup access$1302(WifiP2pSettings r0, WifiP2pGroup r1) {
        r0.mSelectedGroup = r1;
        return r1;
    }

    static /* synthetic */ String access$1400(WifiP2pSettings r0) {
        return r0.mSavedDeviceName;
    }

    static /* synthetic */ void access$1500(WifiP2pSettings r0, String r1) {
        r0.createRenameProfileDialog(r1);
    }

    static /* synthetic */ WifiP2pDeviceList access$202(WifiP2pSettings r0, WifiP2pDeviceList r1) {
        r0.mPeers = r1;
        return r1;
    }

    static /* synthetic */ void access$300(WifiP2pSettings r0) {
        r0.handlePeersChanged();
    }

    static /* synthetic */ WifiP2pManager access$400(WifiP2pSettings r0) {
        return r0.mWifiP2pManager;
    }

    static /* synthetic */ boolean access$500(WifiP2pSettings r0) {
        return r0.mLastGroupFormed;
    }

    static /* synthetic */ boolean access$502(WifiP2pSettings r0, boolean r1) {
        r0.mLastGroupFormed = r1;
        return r1;
    }

    static /* synthetic */ void access$600(WifiP2pSettings r0) {
        r0.startSearch();
    }

    static /* synthetic */ WifiP2pManager.Channel access$700(WifiP2pSettings r0) {
        return r0.mChannel;
    }

    static /* synthetic */ WifiP2pDevice access$800(WifiP2pSettings r0) {
        return r0.mThisDevice;
    }

    static /* synthetic */ WifiP2pDevice access$802(WifiP2pSettings r0, WifiP2pDevice r1) {
        r0.mThisDevice = r1;
        return r1;
    }

    static /* synthetic */ void access$900(WifiP2pSettings r0) {
        r0.updateDevicePref();
    }

    public WifiP2pSettings() {
        this.mIntentFilter = new IntentFilter();
        this.mLastGroupFormed = false;
        this.mPeers = new WifiP2pDeviceList();
        this.mRenamefragment = null;
        this.mStaDisconnectedScanIntervalWhenP2pConnected = 180000;
        this.mReceiver = new AnonymousClass1(this);
        OLog.d(TAG, "Creating WifiP2pSettings ...");
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle r1, String r2) {
        super.onCreatePreferences(r1, r2);
        addPreferencesFromResource(R.xml.wifi_p2p_settings);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View r5, Bundle r6) {
        super.onViewCreated(r5, r6);
        this.mIntentFilter.addAction("android.net.wifi.p2p.STATE_CHANGED");
        this.mIntentFilter.addAction("android.net.wifi.p2p.PEERS_CHANGED");
        this.mIntentFilter.addAction("android.net.wifi.p2p.CONNECTION_STATE_CHANGE");
        this.mIntentFilter.addAction("android.net.wifi.p2p.THIS_DEVICE_CHANGED");
        this.mIntentFilter.addAction("android.net.wifi.p2p.DISCOVERY_STATE_CHANGE");
        this.mIntentFilter.addAction("android.net.wifi.p2p.action.WIFI_P2P_PERSISTENT_GROUPS_CHANGED");
        FragmentActivity r7 = getActivity();
        WifiP2pManager r0 = (WifiP2pManager) getSystemService("wifip2p");
        this.mWifiP2pManager = r0;
        if (r0 == null) goto L7;
        WifiP2pManager.Channel r8 = r0.initialize(r7, getActivity().getMainLooper(), null);
        this.mChannel = r8;
        if (r8 != null) goto L8;
        OLog.e(TAG, "Failed to set up connection with wifi p2p service");
        this.mWifiP2pManager = null;
    L8:
        if (r6 != null) goto L10;
    L12:
        if (r6 != null) goto L14;
    L16:
        if (r6 != null) goto L18;
    L20:
        this.mRenameListener = new AnonymousClass2(this);
        this.mDisconnectListener = new AnonymousClass3(this);
        this.mCancelConnectListener = new AnonymousClass4(this);
        this.mConfirmConnectListener = new AnonymousClass5(this);
        this.mDeleteGroupListener = new AnonymousClass6(this);
        createHeaderPreference();
        createFooterPreference();
        RecyclerView r9 = getListView();
        r9.setItemAnimator(null);
        r9.setOverScrollMode(0);
        r9.setClipToPadding(false);
        r9.setClipChildren(false);
        startSearch();
        return;
    L18:
        if (r6.containsKey(SAVE_SELECTED_GROUP) == false) goto L20;
        this.mSelectedGroupName = r6.getString(SAVE_SELECTED_GROUP);
        goto L20
    L14:
        if (r6.containsKey(SAVE_DEVICE_NAME) == false) goto L16;
        this.mSavedDeviceName = r6.getString(SAVE_DEVICE_NAME);
        goto L16
    L10:
        if (r6.containsKey(SAVE_DIALOG_PEER) == false) goto L12;
        WifiP2pDevice r10 = (WifiP2pDevice) r6.getParcelable(SAVE_DIALOG_PEER);
        this.mSelectedWifiPeer = new WifiP2pPeer(getActivity(), r10);
        goto L12
    L7:
        OLog.e(TAG, "mWifiP2pManager is null !");
        goto L8
    }

    private void createHeaderPreference() {
        PreferenceScreen r0 = getPreferenceScreen();
        RelativeLayout r1 = (RelativeLayout) LayoutInflater.from(getActivity()).inflate(R.layout.wifi_p2p_title, null);
        this.mHeaderLayout = r1;
        this.mThisDeviceItem = (OCardListItem) r1.findViewById(R.id.wifi_p2p_title);
        this.mSearchTips = (OSectionTitleBar) this.mHeaderLayout.findViewById(R.id.wifi_p2p_search_tips);
        this.mThisDeviceItem.setOnContentClickListener(new AnonymousClass7(this));
        updateDevicePref();
        SectionLayoutPreference r2 = new SectionLayoutPreference(getContext(), this.mHeaderLayout);
        this.mHeaderPreference = r2;
        r2.setSelectable(false);
        this.mHeaderPreference.setOrder(0);
        r0.addPreference(this.mHeaderPreference);
    }

    private void createFooterPreference() {
        PreferenceScreen r0 = getPreferenceScreen();
        RelativeLayout r1 = (RelativeLayout) LayoutInflater.from(getActivity()).inflate(R.layout.wifi_p2p_persistent_groups_footer, null);
        this.mPersistentGroupsTitle = (OSectionTitleBar) r1.findViewById(R.id.wifi_p2p_persistent_groups_title);
        ListView r2 = (ListView) r1.findViewById(R.id.wifi_p2p_persistent_groups_list);
        this.mPersistentGroupsListView = r2;
        r2.setDivider(null);
        this.mPersistentGroupsListView.setOverScrollMode(0);
        this.mPersistentGroupsListView.setClipToPadding(false);
        this.mPersistentGroupsListView.setClipChildren(false);
        WifiP2pPersistentGroupAdapter r3 = new WifiP2pPersistentGroupAdapter();
        this.mPersistentGroupAdapter = r3;
        this.mPersistentGroupsListView.setAdapter(r3);
        this.mPersistentGroupsListView.setOnItemClickListener(new WifiP2pSettings$$ExternalSyntheticLambda1(this));
        SectionLayoutPreference r4 = new SectionLayoutPreference(getContext(), r1);
        this.mFooterPreference = r4;
        r4.setSelectable(false);
        this.mFooterPreference.setOrder(10000);
        r0.addPreference(this.mFooterPreference);
    }

    /* JADX INFO: renamed from: lambda$createFooterPreference$0$com-android-settings-wifi-p2p-WifiP2pSettings, reason: not valid java name */
    /* synthetic */ void m725xc87493bc(AdapterView r1, View r2, int r3, long r4) {
        WifiP2pGroup r5 = this.mPersistentGroupAdapter.getItem(r3);
        if (r5 == null) goto L6;
        this.mSelectedGroup = r5;
        showDialog(4);
        return;
    }

    private void createRenameProfileDialog(String r2) {
        DeviceRenameDialogFragment r0 = this.mRenamefragment;
        if (r0 == null) goto L5;
        r0.dismiss();
        this.mRenamefragment = null;
    L5:
        DeviceRenameDialogFragment r1 = new DeviceRenameDialogFragment(r2);
        this.mRenamefragment = r1;
        r1.setDialogTitle(getString(R.string.change_device_name));
        this.mRenamefragment.setPositiveButtonText(getString(R.string.dlg_ok));
        this.mRenamefragment.setPositiveButtonClickListener(new AnonymousClass8(this));
        this.mRenamefragment.show(getFragmentManager(), TAG);
    }

    public void com_android_settings_wifi_p2p_WifiP2pSettings__onResume$___twin___() {
        super.onResume();
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(getActivity(), this.mReceiver, this.mIntentFilter, 2);
        WifiP2pManager r0 = this.mWifiP2pManager;
        if (r0 == null) goto L6;
        r0.requestPeers(this.mChannel, this);
        this.mWifiP2pManager.requestDeviceInfo(this.mChannel, new WifiP2pSettings$$ExternalSyntheticLambda2(this));
        return;
    }

    /* JADX INFO: renamed from: lambda$onResume$1$com-android-settings-wifi-p2p-WifiP2pSettings, reason: not valid java name */
    /* synthetic */ void m726lambda$onResume$1$comandroidsettingswifip2pWifiP2pSettings(WifiP2pDevice r1) {
        this.mThisDevice = r1;
        updateDevicePref();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        unregisterReceiver(this.mReceiver);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        WifiP2pManager r0 = this.mWifiP2pManager;
        if (r0 == null) goto L6;
        r0.stopPeerDiscovery(this.mChannel, null);
        return;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference r3) {
        if ((r3 instanceof WifiP2pPeer) == false) goto L12;
        WifiP2pPeer r0 = (WifiP2pPeer) r3;
        this.mSelectedWifiPeer = r0;
        if (r0.device.status != 0) goto L8;
        showDialog(1);
        goto L12
    L8:
        if (this.mSelectedWifiPeer.device.status != 1) goto L10;
        showDialog(2);
        goto L12
    L10:
        showDialog(5);
    L12:
        return super.onPreferenceTreeClick(r3);
    }

    @Override // com.android.settings.SettingsPreferenceFragment23
    protected void showDialog(int r2) {
        OAlertDialogBuilder r0 = this.p2pSettingsDialog;
        if (r0 != null) goto L5;
    L7:
        super.showDialog(r2);
        return;
    L5:
        if (r0.createDialog().isShowing() == false) goto L7;
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, com.android.settings.DialogCreatable
    public Dialog onCreateDialog(int r8) {
        if (r8 == 1) goto L5;
        if (r8 != 2) goto L22;
        if (TextUtils.isEmpty(this.mSelectedWifiPeer.device.deviceName) == false) goto L18;
        String r9 = this.mSelectedWifiPeer.device.deviceAddress;
    L19:
        OAlertDialogBuilder r10 = new OAlertDialogBuilder(getActivity()).autoDismiss(false).horizontalButton().title(R.string.wifi_p2p_settings_title).message(getActivity().getString(R.string.wifi_p2p_cancel_connect_message, new Object[]{r9})).negativeButton(R.string.dlg_cancel, new AnonymousClass10(this)).positiveButton(R.string.dlg_ok, this.mCancelConnectListener);
        this.p2pSettingsDialog = r10;
        return r10.createDialog();
    L18:
        r9 = this.mSelectedWifiPeer.device.deviceName;
        goto L19
    L22:
        if (r8 != 5) goto L30;
        if (TextUtils.isEmpty(this.mSelectedWifiPeer.device.deviceName) == false) goto L26;
        String r11 = this.mSelectedWifiPeer.device.deviceAddress;
    L27:
        OAlertDialogBuilder r12 = new OAlertDialogBuilder(getActivity()).autoDismiss(false).horizontalButton().title(R.string.wifi_p2p_settings_title).message(getActivity().getString(R.string.wifi_p2p_connect_message, new Object[]{r11})).negativeButton(R.string.dlg_cancel, new AnonymousClass11(this)).positiveButton(R.string.dlg_ok, this.mConfirmConnectListener);
        this.p2pSettingsDialog = r12;
        return r12.createDialog();
    L26:
        r11 = this.mSelectedWifiPeer.device.deviceName;
        goto L27
    L30:
        if (r8 != 4) goto L33;
        OAlertDialogBuilder r13 = new OAlertDialogBuilder(getActivity()).autoDismiss(false).horizontalButton().title(R.string.wifi_p2p_settings_title).message(getActivity().getString(R.string.wifi_p2p_delete_group_message)).negativeButton(R.string.dlg_cancel, this.mDeleteGroupListener).positiveButton(R.string.dlg_ok, this.mDeleteGroupListener);
        this.p2pSettingsDialog = r13;
        return r13.createDialog();
    L33:
        return null;
    L5:
        if (TextUtils.isEmpty(this.mSelectedWifiPeer.device.deviceName) == false) goto L7;
        String r14 = this.mSelectedWifiPeer.device.deviceAddress;
    L9:
        if (this.mConnectedDevices <= 1) goto L11;
        String r15 = getActivity().getString(R.string.wifi_p2p_disconnect_multiple_message, new Object[]{r14, Integer.valueOf(this.mConnectedDevices - 1)});
    L12:
        OAlertDialogBuilder r16 = new OAlertDialogBuilder(getActivity()).autoDismiss(false).horizontalButton().title(R.string.wifi_p2p_settings_title).message(r15).negativeButton(R.string.dlg_cancel, new AnonymousClass9(this)).positiveButton(R.string.dlg_ok, this.mDisconnectListener);
        this.p2pSettingsDialog = r16;
        return r16.createDialog();
    L11:
        r15 = getActivity().getString(R.string.wifi_p2p_disconnect_message, new Object[]{r14});
        goto L12
    L7:
        r14 = this.mSelectedWifiPeer.device.deviceName;
        goto L9
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r3) {
        WifiP2pPeer r0 = this.mSelectedWifiPeer;
        if (r0 == null) goto L5;
        r3.putParcelable(SAVE_DIALOG_PEER, r0.device);
    L5:
        EditText r1 = this.mDeviceNameText;
        if (r1 == null) goto L8;
        r3.putString(SAVE_DEVICE_NAME, r1.getText().toString());
    L8:
        WifiP2pGroup r2 = this.mSelectedGroup;
        if (r2 == null) goto L12;
        r3.putString(SAVE_SELECTED_GROUP, r2.getNetworkName());
        return;
    }

    @Override // android.net.wifi.p2p.WifiP2pManager.PeerListListener
    public void onPeersAvailable(WifiP2pDeviceList r5) {
        this.mPeers = r5;
        this.mConnectedDevices = 0;
        if (getActivity() != null) goto L5;
        return;
    L5:
        monitor-enter(this);
        refreshPeerPreferences(r5);     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        Iterator<WifiP2pDevice> r6 = r5.getDeviceList().iterator();
    L10:
        if (r6.hasNext() == false) goto L14;
        WifiP2pDevice r0 = r6.next();
        OLog.d(TAG, " peer " + r0);
        if (r0.status != 0) goto L10;
        this.mConnectedDevices++;
        goto L10
    L14:
        OLog.d(TAG, " mConnectedDevices " + this.mConnectedDevices);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private void handlePeersChanged() {
        this.mConnectedDevices = 0;
        OLog.d(TAG, "List of available peers");
        monitor-enter(this);
        refreshPeerPreferences(this.mPeers);     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        Iterator<WifiP2pDevice> r0 = this.mPeers.getDeviceList().iterator();
    L8:
        if (r0.hasNext() == false) goto L12;
        WifiP2pDevice r1 = r0.next();
        OLog.d(TAG, "-> " + r1);
        if (r1.status != 0) goto L8;
        this.mConnectedDevices++;
        goto L8
    L12:
        OLog.d(TAG, " mConnectedDevices " + this.mConnectedDevices);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private void refreshPeerPreferences(WifiP2pDeviceList r5) {
        PreferenceScreen r0 = getPreferenceScreen();
        if (r0 != null) goto L5;
        return;
    L5:
        if (getActivity() == null) goto L26;
        PreferenceGroup r1 = this.mAvailablePeerGroup;
        if (r1 != null) goto L10;
        NoTitlePreferenceCategory r2 = new NoTitlePreferenceCategory(getActivity());
        this.mAvailablePeerGroup = r2;
        r2.setOrder(1000);
        r0.addPreference(this.mAvailablePeerGroup);
    L11:
        Iterator<WifiP2pDevice> r6 = r5.getDeviceList().iterator();
    L12:
        int r3 = 0;
        if (r6.hasNext() == false) goto L15;
        WifiP2pDevice r4 = r6.next();
        final WifiP2pPeer r7 = new WifiP2pPeer(getActivity(), r4);
        r7.setPersistent(false);
        r7.setOnContentClickListener(new WifiP2pSettings$$ExternalSyntheticLambda0(this, r7));
        this.mAvailablePeerGroup.addPreference(r7);
        goto L12
    L15:
        int r8 = this.mAvailablePeerGroup.getPreferenceCount();
    L16:
        if (r3 >= r8) goto L27;
        Preference r9 = this.mAvailablePeerGroup.getPreference(r3);
        if ((r9 instanceof WifiP2pPeer) == false) goto L20;
        ((WifiP2pPeer) r9).setCardPosition(r3, r8);
    L20:
        r3 = r3 + 1;
        goto L16
    L27:
        return;
    L10:
        r1.removeAll();
        goto L11
    }

    /* JADX INFO: renamed from: lambda$refreshPeerPreferences$2$com-android-settings-wifi-p2p-WifiP2pSettings, reason: not valid java name */
    /* synthetic */ void m727xd5bcc27(WifiP2pPeer r1, View r2) {
        onPreferenceTreeClick(r1);
    }

    @Override // android.net.wifi.p2p.WifiP2pManager.GroupInfoListener
    public void onGroupInfoAvailable(WifiP2pGroup r3) {
        OLog.d(TAG, " group " + r3);
        this.mConnectedGroup = r3;
        updateDevicePref();
    }

    public void onPersistentGroupInfoAvailable(WifiP2pGroupList r6) {
        OLog.d(TAG, " onPersistentGroupInfoAvailable, groups count: " + r6.getGroupList().size());
        this.mPersistentGroupAdapter.setData(r6.getGroupList());
        OSectionTitleBar r0 = this.mPersistentGroupsTitle;
        int r2 = 8;
        if (r0 != null) goto L5;
    L9:
        ListView r1 = this.mPersistentGroupsListView;
        if (r1 != null) goto L12;
    L16:
        Iterator r7 = r6.getGroupList().iterator();
    L18:
        if (r7.hasNext() == false) goto L23;
        WifiP2pGroup r3 = (WifiP2pGroup) r7.next();
        OLog.d(TAG, " persistent group " + r3);
        if (r3.getNetworkName().equals(this.mSelectedGroupName) == false) goto L18;
        OLog.d(TAG, "Selecting group " + r3.getNetworkName());
        this.mSelectedGroup = r3;
        this.mSelectedGroupName = null;
        goto L18
    L23:
        if (this.mSelectedGroupName == null) goto L31;
        OLog.w(TAG, " Selected group " + this.mSelectedGroupName + " disappered on next query ");
        return;
    L31:
        return;
    L12:
        if (r6.getGroupList().isEmpty() == true) goto L15;
        r2 = 0;
    L15:
        r1.setVisibility(r2);
        goto L16
    L5:
        if (r6.getGroupList().isEmpty() == false) goto L7;
        int r4 = 8;
    L8:
        r0.setVisibility(r4);
        goto L9
    L7:
        r4 = 0;
        goto L8
    }

    private String utfToString(String r8) {
        byte[] r7 = r8.getBytes();
        ByteBuffer r0 = ByteBuffer.allocate(r8.length());
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= r7.length) goto L20;
        byte r4 = r7[r2];
        if (r4 == 92) goto L8;
    L10:
        r0.put(r4);
    L11:
        r3 = r3 + 1;
        r2 = r2 + 1;
        goto L4
    L8:
        if (r7[r2 + 1] != 120) goto L10;
        r0.put((byte) Integer.parseInt(r8.substring(r2 + 2, r2 + 4), 16));
        r2 = r2 + 3;
        goto L11
    L20:
        ByteBuffer r9 = ByteBuffer.allocate(r3);     // Catch: UnsupportedEncodingException -> L17
    L13:
        if (r1 >= r3) goto L15;
        r9.put(r0.get(r1));     // Catch: UnsupportedEncodingException -> L17
        r1 = r1 + 1;     // Catch: UnsupportedEncodingException -> L17
        goto L13
    L15:
        return new String(r9.array(), "UTF-8");
    L17:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private void handleP2pStateChanged() {
        if (this.mWifiP2pEnabled == false) goto L5;
        this.mThisDeviceItem.getContentContainer().setEnabled(true);
        this.mThisDeviceItem.getContentContainer().setClickable(true);
        this.mWifiP2pManager.requestPeers(this.mChannel, this);
        return;
    L5:
        this.mThisDeviceItem.getContentContainer().setEnabled(false);
        this.mThisDeviceItem.getContentContainer().setClickable(false);
        updateSearchState(false);
    }

    private void updateSearchState(boolean r1) {
        this.mWifiP2pSearching = r1;
        OSectionTitleBar r0 = this.mSearchTips;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    private void startSearch() {
        WifiP2pManager r0 = this.mWifiP2pManager;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mWifiP2pSearching == true) goto L9;
        r0.discoverPeers(this.mChannel, new AnonymousClass12(this));
        return;
    }

    private void updateDevicePref() {
        WifiP2pDevice r0 = this.mThisDevice;
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r0.deviceName) == false) goto L7;
        this.mThisDeviceItem.setEndDetailText(this.mThisDevice.deviceAddress);
        return;
    L7:
        this.mThisDeviceItem.setEndDetailText(this.mThisDevice.deviceName);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_wifi_p2p_WifiP2pSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(WifiP2pSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wifi_p2p_WifiP2pSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_p2p_WifiP2pSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(WifiP2pSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_wifi_p2p_WifiP2pSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_p2p_WifiP2pSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(WifiP2pSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wifi_p2p_WifiP2pSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
