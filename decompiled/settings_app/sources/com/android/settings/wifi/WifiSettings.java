package com.android.settings.wifi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.net.CaptivePortalData;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.BoostFramework;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import bytedanceos.util.DeviceType;
import com.GlobalProxyLancet;
import com.android.settings.AdaptConstants;
import com.android.settings.AdaptWifi;
import com.android.settings.AdaptWifiConfig;
import com.android.settings.FeatureFactory;
import com.android.settings.HandInHandProcessor;
import com.android.settings.MultiSDKAdapter;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settings.R;
import com.android.settings.Settings;
import com.android.settings.SettingsTracker;
import com.android.settings.ToastUtils;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.base.BaseFragment;
import com.android.settings.provision.ProvisionConstants;
import com.android.settings.provision.WifiPickerActivity2;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.teaevent.ProvisionTeaEvent;
import com.android.settings.teaevent.TeaEventConst;
import com.android.settings.teaevent.TrackerEvent;
import com.android.settings.utils.DevicePolicyUtils;
import com.android.settings.utils.HanziToPinyin;
import com.android.settings.utils.ResourceUtils;
import com.android.settings.utils.SLog;
import com.android.settings.utils.SettingsProviderUtils;
import com.android.settings.utils.ThreadUtils;
import com.android.settings.utils.UIUtils;
import com.android.settings.wifi.main.ModularWifiListSetupAdapter;
import com.android.settings.wifi.main.WifiListSetupAdapter;
import com.android.settings.wifi.scanner.WifiConfigManager;
import com.android.settings.wifi.scanner.WifiParsedResult;
import com.android.settings.wifi.scanner.WifiResultParser;
import com.android.settingslib.RestrictedLockUtils;
import com.android.settingslib.core.lifecycle.Lifecycle;
import com.android.wifitrackerlib.WifiEntry;
import com.android.wifitrackerlib.WifiPickerTracker;
import com.bytedance.librarian.LibrarianImpl;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import java.time.Clock;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes.dex */
public class WifiSettings extends BaseFragment implements CompoundButton.OnCheckedChangeListener, AdapterView.OnItemClickListener, LifecycleOwner {
    public static final String ACTION_WIFI_AUTHORIZATION_START = "action.intent.bytedanceos.wifi_authorization_start";
    public static final String ACTION_WIFI_AUTHORIZATION_SUCCESS = "action.intent.bytedanceos.wifi_authorization_success";
    public static final String ACTION_WIFI_RISK_DETECTED = "com.obric.security.wlan.ACTION_WIFI_RISK_DETECTED";
    private static final int ACTIVATE_FLAG_CELLULAR = 1;
    private static final int ACTIVATE_FLAG_SMS = 2;
    public static final int ACTIVATE_FLAG_WIFI = 0;
    private static final long DELAY_UPDATE_ACCESS_POINT = 150;
    private static final String EXTRA_KEY_NETWORK_ID = "extra_key_network_id";
    private static final String EXTRA_KEY_SECURITY = "extra_key_security";
    private static final String EXTRA_KEY_SSID = "extra_key_ssid";
    private static final long MAX_SCAN_AGE_MILLIS = 15000;
    private static final int MSG_UPDATE_ACCESS_POINT = 1;
    private static final int REQ_CODE_LAUNCH_CAMERA = 12;
    public static final int REQ_CODE_LAUNCH_QR_SCANNER = 1001;
    private static final long SCAN_INTERVAL_MILLIS = 5000;
    public static final String ScannerIntentResult_BARCODE_FORMAT = "format";
    public static final String ScannerIntentResult_CONTENTS = "contents";
    private static final String TAG = "WifiSettings";
    public static final String WAPI_CERT_MANAGE_ACTION = "android.Wapi.CertManage";
    public static final int WIFI_DIALOG_ID = 1;
    private static final int WIFI_RESCAN_INTERVAL_MS = 6000;
    static final int WPS_PBC_DIALOG_ID = 2;
    private static int mListFooterCount = 0;
    public static int[] mPerParamVal = null;
    public static final int mPerfLockDuration = 2000;
    private static boolean savedNetworksExist;
    private boolean isRegisteredWifiRiskReceiver;
    private AccessPointInfo lastConnectedAccessPoint;
    OTextView laterSetBtn;
    private View mActivateFooter;
    private View mActivateHeader;
    boolean mActivateRequested;
    private View mAddNetworkLayout;
    private Button mAddNetworkSettingItem;
    private AppBarLayout mAppBar;
    private ConnectivityManager mConnService;
    private WifiManager.ActionListener mConnectListener;
    private String mConnectSSID;
    private final AtomicBoolean mConnected;
    private AccessPointInfo mCurrentAccessPoint;
    private OAlertDialogBuilder mFallbackDilog;
    private final IntentFilter mFilter;
    private Handler mHandler;
    private boolean mHideContentForAutoNext;
    private boolean mIsActivateFailed;
    private boolean mIsCell;
    private boolean mIsCellFailed;
    boolean mIsFirstActivate;
    boolean mIsFirstFrpActivate;
    private boolean mIsListScrollIdle;
    private int mKeyStoreNetworkId;
    private long mLastConnectAccessPointTs;
    private android.net.wifi.WifiInfo mLastInfo;
    private NetworkInfo.DetailedState mLastState;
    private final Lifecycle mLifecycle;
    private LinkProperties mLinkProperties;
    private ListView mListView;
    private Handler mMainHandler;
    private Network mNetwork;
    private View mNoSIMTipContainer;
    private View mOtherNetworkView;
    private BoostFramework mPerf;
    private final BroadcastReceiver mReceiver;
    private OButton mScanQRcodeSettingItem;
    private final Scanner mScanner;
    private AccessPointInfo mSelectedAccessPoint;
    private boolean mSetupWizardMode;
    private View mSmsTipContainer;
    private boolean mUpdateWifiListInstantWhenFirstIn;
    private OCardListItem mViewWifiSwitch;
    private WifiListSetupAdapter mWifiListSetupAdapter;
    WifiManager mWifiManager;
    private boolean mWifiPickerMode;
    WifiPickerTracker mWifiPickerTracker;
    private HandlerThread mWifiPickerTrackerWorkerThread;
    private boolean mWifiRefreshed;
    private BroadcastReceiver mWifiRiskReceiver;
    private TextView mWifiStateTipView;
    private WifiEnabler mWifiSwitchEnabler;
    private RelativeLayout mWifiSwitchLayout;
    private Handler mWorkerHandler;
    private OCardListItem networkAssistantView;
    private ConnectivityManager.NetworkCallback networkCallback;
    OButton oNextStepBtn;
    private RecyclerView recyclerView;
    private OAlertDialog retryDialog;
    private OTextView titleStr400;
    private OTextView titleStr500;
    private OTextView titleStr600;
    private OTextView titleStr640;
    private final WifiEntry.WifiEntryCallback wifiEntryCallback;
    private WlanRiskInfo wlanRiskInfo;

    /* JADX INFO: renamed from: com.android.settings.wifi.WifiSettings$8, reason: invalid class name */
    class AnonymousClass8 extends ConnectivityManager.NetworkCallback {
        final /* synthetic */ WifiSettings this$0;

        AnonymousClass8(WifiSettings r1) {
            this.this$0 = r1;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network r2) {
            super.onAvailable(r2);
            OLog.i(WifiSettings.TAG, "NetworkCallback onAvailable: " + r2);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(final Network r3) {
            super.onLost(r3);
            this.this$0._mActivity.runOnUiThread(new WifiSettings$8$$ExternalSyntheticLambda1(this, r3));
        }

        /* JADX INFO: renamed from: lambda$onLost$0$com-android-settings-wifi-WifiSettings$8, reason: not valid java name */
        /* synthetic */ void m714lambda$onLost$0$comandroidsettingswifiWifiSettings$8(Network r4) {
            Network r0 = WifiSettings.access$600(this.this$0).getActiveNetwork();
            OLog.i(WifiSettings.TAG, "NetworkCallback onLost: " + r4 + "  activeNetwork:" + r0);
            if (r0 == null) goto L5;
            NetworkCapabilities r5 = WifiSettings.access$600(this.this$0).getNetworkCapabilities(r0);
        L6:
            WifiSettings.access$500(this.this$0, r5);
            return;
        L5:
            r5 = null;
            goto L6
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network r3, final NetworkCapabilities r4) {
            super.onCapabilitiesChanged(r3, r4);
            OLog.i(WifiSettings.TAG, "NetworkCallback onCapabilitiesChanged: " + r4.hasCapability(16));
            this.this$0._mActivity.runOnUiThread(new WifiSettings$8$$ExternalSyntheticLambda0(this, r4));
        }

        /* JADX INFO: renamed from: lambda$onCapabilitiesChanged$1$com-android-settings-wifi-WifiSettings$8, reason: not valid java name */
        /* synthetic */ void m713xb7ae65d9(NetworkCapabilities r1) {
            WifiSettings.access$500(this.this$0, r1);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network r1, LinkProperties r2) {
            super.onLinkPropertiesChanged(r1, r2);
            OLog.i(WifiSettings.TAG, "onLinkPropertiesChanged: " + r2.toString());
        }
    }

    private static class Multimap<K, V> {
        private final HashMap<K, List<V>> store;

        private Multimap() {
            this.store = new HashMap();
        }

        /* synthetic */ Multimap(AnonymousClass1 r1) {
            this();
        }

        List<V> getAll(K r1) {
            List<V> r0 = this.store.get(r1);
            if (r0 == null) goto L6;
            return r0;
        L6:
            return Collections.emptyList();
        }

        void put(K r3, V r4) {
            List<V> r0 = this.store.get(r3);
            if (r0 != null) goto L5;
            r0 = new ArrayList(3);
            this.store.put(r3, r0);
        L5:
            r0.add(r4);
        }
    }

    private static class Scanner extends Handler {
        private int mRetry;
        private WifiSettings mWifiSettings;

        Scanner(WifiSettings r2) {
            this.mRetry = 0;
            this.mWifiSettings = r2;
        }

        void resume() {
            if (hasMessages(0) == true) goto L6;
            sendEmptyMessage(0);
            return;
        }

        void forceScan() {
            removeMessages(0);
            sendEmptyMessage(0);
        }

        void pause() {
            this.mRetry = 0;
            removeMessages(0);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r3) {
            OLog.d(WifiSettings.TAG, "startScan");
            if (this.mWifiSettings.mWifiManager.startScan() == false) goto L5;
            this.mRetry = 0;
            return;
        L5:
            int r4 = this.mRetry + 1;
            this.mRetry = r4;
            if (r4 < 3) goto L12;
            this.mRetry = 0;
            FragmentActivity r2 = this.mWifiSettings.getActivity();
            if (r2 == null) goto L13;
            ToastUtils.show(r2, R.string.wifi_fail_to_scan);
            return;
        L13:
            return;
        }
    }

    class UpdateAccessPointsTask extends AsyncTask<Void, Void, ArrayList<AccessPointInfo>> {
        final /* synthetic */ WifiSettings this$0;

        UpdateAccessPointsTask(WifiSettings r1) {
            this.this$0 = r1;
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ ArrayList<AccessPointInfo> doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(ArrayList<AccessPointInfo> r1) {
            onPostExecute2(r1);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected ArrayList<AccessPointInfo> doInBackground2(Void... r3) {
            if (this.this$0.mWifiManager.getWifiState() == 3) goto L5;
            return null;
        L5:
            if (WifiSettings.access$700(this.this$0) == null) goto L7;
            WifiSettings.access$700(this.this$0).perfLockAcquire(2000, WifiSettings.mPerParamVal);
        L7:
            WifiSettings r4 = this.this$0;
            return WifiSettings.access$1000(r4, r4.mWifiManager, WifiSettings.access$800(this.this$0), WifiSettings.access$900(this.this$0));
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(ArrayList<AccessPointInfo> r1) {
            WifiSettings.access$1100(this.this$0, r1);
            OLog.d(WifiSettings.TAG, "MSG_UPDATE_ACCESS_POINT 2");
        }
    }

    @Override // com.android.settings.base.BaseFragment
    public int getTitleResId() {
        return R.string.wifi_settings_title;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r1, boolean r2) {
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_wifi_WifiSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_wifi_WifiSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ WifiListSetupAdapter access$000(WifiSettings r0) {
        return r0.mWifiListSetupAdapter;
    }

    static /* synthetic */ boolean access$100(WifiSettings r0) {
        return r0.mIsListScrollIdle;
    }

    static /* synthetic */ ArrayList access$1000(WifiSettings r0, WifiManager r1, android.net.wifi.WifiInfo r2, NetworkInfo.DetailedState r3) {
        return r0.constructAccessPoints(r1, r2, r3);
    }

    static /* synthetic */ void access$1100(WifiSettings r0, ArrayList r1) {
        r0.updateAccessPointsUI(r1);
    }

    static /* synthetic */ boolean access$1300(WifiSettings r0) {
        return r0.mSetupWizardMode;
    }

    static /* synthetic */ boolean access$202(WifiSettings r0, boolean r1) {
        r0.mWifiRefreshed = r1;
        return r1;
    }

    static /* synthetic */ void access$300(WifiSettings r0, Intent r1) {
        r0.handleEvent(r1);
    }

    static /* synthetic */ void access$400(WifiSettings r0, Intent r1) {
        r0.dealWifiRiskIntent(r1);
    }

    static /* synthetic */ void access$500(WifiSettings r0, NetworkCapabilities r1) {
        r0.updateBottomButtonState(r1);
    }

    static /* synthetic */ ConnectivityManager access$600(WifiSettings r0) {
        return r0.mConnService;
    }

    static /* synthetic */ BoostFramework access$700(WifiSettings r0) {
        return r0.mPerf;
    }

    static /* synthetic */ android.net.wifi.WifiInfo access$800(WifiSettings r0) {
        return r0.mLastInfo;
    }

    static /* synthetic */ NetworkInfo.DetailedState access$900(WifiSettings r0) {
        return r0.mLastState;
    }

    static {
        mPerParamVal = ResourceUtils.getResources().getIntArray(R.array.max_freq_boost_param_value);
    }

    public WifiSettings() {
        this.isRegisteredWifiRiskReceiver = false;
        this.mConnected = new AtomicBoolean(false);
        this.mKeyStoreNetworkId = -1;
        this.mIsCell = false;
        this.mIsCellFailed = false;
        this.mIsActivateFailed = false;
        this.mSetupWizardMode = false;
        this.mWifiPickerMode = false;
        this.mIsListScrollIdle = true;
        this.mWifiRefreshed = false;
        this.mLifecycle = new Lifecycle(this);
        this.wifiEntryCallback = new AnonymousClass1(this);
        this.mActivateRequested = false;
        this.mIsFirstActivate = true;
        this.mIsFirstFrpActivate = true;
        this.mConnectSSID = null;
        this.mPerf = null;
        this.mUpdateWifiListInstantWhenFirstIn = true ^ DeviceType.isOneOf(new DeviceType[]{DeviceType.ODIN, DeviceType.OSCAR});
        this.mHandler = new AnonymousClass2(this);
        this.mHideContentForAutoNext = false;
        IntentFilter r0 = new IntentFilter();
        this.mFilter = r0;
        r0.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        r0.addAction("android.net.wifi.SCAN_RESULTS");
        r0.addAction("android.net.wifi.NETWORK_IDS_CHANGED");
        r0.addAction("android.net.wifi.STATE_CHANGE");
        r0.addAction("android.net.wifi.supplicant.STATE_CHANGE");
        r0.addAction("android.net.wifi.CONFIGURED_NETWORKS_CHANGE");
        r0.addAction(AdaptConstants.LINK_CONFIGURATION_CHANGED_ACTION);
        r0.addAction("android.net.wifi.RSSI_CHANGED");
        r0.addAction("android.intent.action.SIM_STATE_CHANGED");
        this.mReceiver = new AnonymousClass3(this);
        this.mScanner = new Scanner(this);
    }

    private void registerWifiRiskReceiver() {
        if (SettingsProviderUtils.isWlanSecurityCheckSwitchEnabled(getContext()) == true) goto L6;
        return;
    L6:
        if (this.mWifiManager.getWifiState() != 3) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L12;
        return;
    L12:
        if (this.isRegisteredWifiRiskReceiver == false) goto L14;
        return;
    L14:
        this.isRegisteredWifiRiskReceiver = true;
        this.mWifiRiskReceiver = new AnonymousClass4(this);
        registerReceiver(this.mWifiRiskReceiver, new IntentFilter(ACTION_WIFI_RISK_DETECTED));
        return;
    L8:
        r0 = false;
        goto L9
    }

    private void dealWifiRiskIntent(Intent r10) {
        if (Objects.equals(r10.getAction(), ACTION_WIFI_RISK_DETECTED) == true) goto L5;
        return;
    L5:
        String r0 = r10.getStringExtra("ssid");
        String r1 = r10.getStringExtra(WlanRiskInfo.EXTRA_BSSID);
        ArrayList<String> r6 = r10.getStringArrayListExtra(WlanRiskInfo.EXTRA_RISKS);
        long r7 = r10.getLongExtra("timestamp", 0);
        StringBuilder r11 = new StringBuilder("dealWifiRiskIntent: ssid=").append(r0).append(" , bssid=").append(r1).append(", risks=");
        if (r6 != null) goto L8;
    L10:
        String r2 = "null";
    L11:
        OLog.i(TAG, r11.append(r2).toString());
        if (r0 == null) goto L14;
        String r4 = r0;
    L15:
        if (r1 == null) goto L17;
        String r5 = r1;
    L18:
        this.wlanRiskInfo = new WlanRiskInfo(r4, r5, r6, r7);
        updateAccessPoints();
        return;
    L17:
        r5 = "";
        goto L18
    L14:
        r4 = "";
        goto L15
    L8:
        if (r6.isEmpty() == true) goto L10;
        r2 = r6.get(0);
        goto L11
    }

    private void unregisterWifiRiskReceiver() {
        unregisterReceiver(this.mWifiRiskReceiver);
        this.mWifiRiskReceiver = null;
        this.wlanRiskInfo = null;
        this.lastConnectedAccessPoint = null;
        this.isRegisteredWifiRiskReceiver = false;
    }

    public void com_android_settings_wifi_WifiSettings__onCreate$___twin___(Bundle r3) {
        this.mLifecycle.onCreate(r3);
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_CREATE);
        super.onCreate(r3);
        if ((getActivity() instanceof WifiPickerActivity2) == false) goto L5;
        this.mWifiPickerMode = true;
        this.mSetupWizardMode = ((WifiPickerActivity2) getActivity()).isSetupWizardMode();
    L5:
        this.mTitleResId = Integer.valueOf(R.string.wifi_settings_title);
        this.mWifiManager = (WifiManager) getSystemService("wifi");
        this.mPerf = new BoostFramework();
        this.mConnectListener = new AnonymousClass5(this);
        setupWifiPickerTracker();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_DESTROY);
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r21, ViewGroup r22, Bundle r23) {
        if (this.mSetupWizardMode == false) goto L5;
        this.mRootView = r21.inflate(R.layout.wifi_setting_layout_provision, r22, false);
    L6:
        RecyclerView r1 = (RecyclerView) findViewByIdNullable(R.id.recycler_view);
        this.recyclerView = r1;
        r1.setLayoutManager(new LinearLayoutManager(getActivity()));
        if (isActivateMode() == true) goto L9;
        this.mWifiListSetupAdapter = new ModularWifiListSetupAdapter(this._mActivity, isActivateMode(), new WifiSettings$$ExternalSyntheticLambda1(this), new WifiSettings$$ExternalSyntheticLambda5(this), new WifiSettings$$ExternalSyntheticLambda6(this), new WifiSettings$$ExternalSyntheticLambda7(this), new WifiSettings$$ExternalSyntheticLambda8(this));
    L10:
        this.recyclerView.setAdapter(this.mWifiListSetupAdapter);
        if (isActivateMode() == true) goto L18;
        OFloatingTitleBar r2 = (OFloatingTitleBar) findViewByIdNullable(R.id.view_title);
        if (r2 != null) goto L16;
        return null;
    L16:
        if (DevicePolicyUtils.hasUserRestriction(this._mActivity, "no_config_wifi") == true) goto L25;
        r2.addEndAction(R.drawable.settings_oic_scan, -1, null).setOnClickListener(new AnonymousClass6(this));
    L25:
        WifiEnabler r3 = this.mWifiSwitchEnabler;
        if (r3 == null) goto L31;
        boolean r4 = r3.isChecked();
        updateBottomViews(r4);
        if (r4 == false) goto L31;
        updateWifiStateTips(R.string.wifi_empty_list_wifi_on);
    L31:
        return this.mRootView;
    L18:
        setWifiEnabled(this._mActivity, true);
        OLog.e(TAG, "onCreateView provision feature");
        ((OFloatingTitleBar) findViewByIdNullable(R.id.phone_setup_title_bar)).addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, new WifiSettings$$ExternalSyntheticLambda14(this));
        OTextView r5 = (OTextView) findViewByIdNullable(R.id.title_text);
        if (r5 == null) goto L21;
        r5.setText(R.string.connecting_network);
    L21:
        final Intent r6 = this._mActivity.getIntent();
        OTextView r7 = (OTextView) findViewByIdNullable(R.id.later_setting);
        this.laterSetBtn = r7;
        r7.setOnClickListener(new WifiSettings$$ExternalSyntheticLambda2(this));
        this.oNextStepBtn = (OButton) findViewByIdNullable(R.id.bottom_button);
        this.laterSetBtn.setVisibility(4);
        this.laterSetBtn.setText(R.string.text_later_settings);
        this.laterSetBtn.setOnClickListener(new WifiSettings$$ExternalSyntheticLambda3(this, r6));
        OButton r8 = this.oNextStepBtn;
        if (r8 == null) goto L24;
        r8.setText(R.string.next_step);
        this.oNextStepBtn.setEnabled(false);
        this.oNextStepBtn.setOnClickListener(new WifiSettings$$ExternalSyntheticLambda4(this, r6));
    L24:
        final View r9 = findViewByIdNullable(R.id.list_view_divider);
        this.mWifiListSetupAdapter.registerDataSetObserver(new AnonymousClass7(this, r9));
        goto L25
    L9:
        this.mWifiListSetupAdapter = new WifiListSetupAdapter(this._mActivity, isActivateMode(), new WifiSettings$$ExternalSyntheticLambda9(this), new WifiSettings$$ExternalSyntheticLambda10(this), new WifiSettings$$ExternalSyntheticLambda12(this), new WifiSettings$$ExternalSyntheticLambda13(this));
        goto L10
    L5:
        this.mRootView = r21.inflate(R.layout.wifi_setting_layout, r22, false);
        goto L6
    }

    /* JADX INFO: renamed from: lambda$onCreateView$0$com-android-settings-wifi-WifiSettings, reason: not valid java name */
    /* synthetic */ List m698lambda$onCreateView$0$comandroidsettingswifiWifiSettings() {
        return constructAccessPoints(this.mWifiManager, this.mLastInfo, this.mLastState);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$1$com-android-settings-wifi-WifiSettings, reason: not valid java name */
    /* synthetic */ Unit m699lambda$onCreateView$1$comandroidsettingswifiWifiSettings(View r1) {
        return initWifiSwitch(r1);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$2$com-android-settings-wifi-WifiSettings, reason: not valid java name */
    /* synthetic */ Unit m703lambda$onCreateView$2$comandroidsettingswifiWifiSettings(AccessPointInfo r1) {
        return processItemClick(r1);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$3$com-android-settings-wifi-WifiSettings, reason: not valid java name */
    /* synthetic */ Unit m704lambda$onCreateView$3$comandroidsettingswifiWifiSettings(View r1) {
        return initOtherNetworkView(r1);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$4$com-android-settings-wifi-WifiSettings, reason: not valid java name */
    /* synthetic */ Unit m705lambda$onCreateView$4$comandroidsettingswifiWifiSettings(View r1, Boolean r2) {
        return initAddNetworkButton(r1, r2.booleanValue());
    }

    /* JADX INFO: renamed from: lambda$onCreateView$5$com-android-settings-wifi-WifiSettings, reason: not valid java name */
    /* synthetic */ List m706lambda$onCreateView$5$comandroidsettingswifiWifiSettings() {
        return constructAccessPoints(this.mWifiManager, this.mLastInfo, this.mLastState);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$6$com-android-settings-wifi-WifiSettings, reason: not valid java name */
    /* synthetic */ Unit m707lambda$onCreateView$6$comandroidsettingswifiWifiSettings(View r1) {
        return initWifiSwitch(r1);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$7$com-android-settings-wifi-WifiSettings, reason: not valid java name */
    /* synthetic */ Unit m708lambda$onCreateView$7$comandroidsettingswifiWifiSettings(AccessPointInfo r1) {
        return processItemClick(r1);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$8$com-android-settings-wifi-WifiSettings, reason: not valid java name */
    /* synthetic */ Unit m709lambda$onCreateView$8$comandroidsettingswifiWifiSettings(View r1, Boolean r2) {
        return initAddNetworkButton(r1, r2.booleanValue());
    }

    /* JADX INFO: renamed from: lambda$onCreateView$9$com-android-settings-wifi-WifiSettings, reason: not valid java name */
    /* synthetic */ void m710lambda$onCreateView$9$comandroidsettingswifiWifiSettings(View r2) {
        if (this._mActivity != null) goto L6;
        return;
    L6:
        if ((this._mActivity instanceof WifiPickerActivity2) == false) goto L8;
        ((WifiPickerActivity2) this._mActivity).setBackPressed(true);
    L8:
        this._mActivity.onBackPressed();
    }

    /* JADX INFO: renamed from: lambda$onCreateView$10$com-android-settings-wifi-WifiSettings, reason: not valid java name */
    /* synthetic */ void m700lambda$onCreateView$10$comandroidsettingswifiWifiSettings(View r1) {
        if (com.android.settings.Utils.isFastDoubleClick() == false) goto L5;
        return;
    L5:
        startActivate(0);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$11$com-android-settings-wifi-WifiSettings, reason: not valid java name */
    /* synthetic */ void m701lambda$onCreateView$11$comandroidsettingswifiWifiSettings(Intent r1, View r2) {
        if (com.android.settings.Utils.isFastDoubleClick() == false) goto L5;
        return;
    L5:
        ProvisionTeaEvent.click(ProvisionTeaEvent.getPageName(r1), TeaEventConst.CLICK_SETUP_LATER);
        startActivate(0);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$12$com-android-settings-wifi-WifiSettings, reason: not valid java name */
    /* synthetic */ void m702lambda$onCreateView$12$comandroidsettingswifiWifiSettings(Intent r1, View r2) {
        if (com.android.settings.Utils.isFastDoubleClick() == false) goto L5;
        return;
    L5:
        OButton r3 = this.oNextStepBtn;
        if (r3 != null) goto L8;
        return;
    L8:
        if (r3.isEnabled() == false) goto L12;
        ProvisionTeaEvent.click(ProvisionTeaEvent.getPageName(r1), TeaEventConst.CLICK_NEXT);
        startActivate(0);
        return;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        if (isFromNetworkPanel() == false) goto L6;
        r2.setVisibility(4);
    L9:
        if (this.mSetupWizardMode == false) goto L14;
        initSetupWizardViews();
        r2.setBackgroundColor(0);
        if ((r2 instanceof ViewGroup) == false) goto L15;
        ViewGroup r4 = (ViewGroup) r2;
        r4.setClipChildren(false);
        r4.setClipToPadding(false);
        return;
    L15:
        return;
    L14:
        return;
    L6:
        if (shouldHideContentForAutoNext() == false) goto L9;
        r2.setVisibility(4);
        this.mHideContentForAutoNext = true;
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
    }

    private void registerNetworkCallback() {
        this.mConnService = (ConnectivityManager) getSystemService("connectivity");
        NetworkRequest r0 = new NetworkRequest.Builder().addTransportType(0).addTransportType(1).addCapability(12).build();
        AnonymousClass8 r1 = new AnonymousClass8(this);
        this.networkCallback = r1;
        this.mConnService.registerNetworkCallback(r0, r1);
    }

    private void unregisterNetworkCallback() {
        ConnectivityManager r0 = this.mConnService;
        if (r0 == null) goto L8;
        ConnectivityManager.NetworkCallback r1 = this.networkCallback;
        if (r1 == null) goto L9;
        r0.unregisterNetworkCallback(r1);
        return;
    L9:
        return;
    }

    private void updateBottomButtonState(NetworkCapabilities r7) {
        if (this.laterSetBtn != null) goto L5;
        return;
    L5:
        if (this.oNextStepBtn == null) goto L53;
        OLog.d(TAG, "updateBottomButtonState: mIsCell:" + this.mIsCell + " mIsCellFailed:" + this.mIsCellFailed);
        int r0 = 4;
        if (r7 != null) goto L10;
    L42:
        this.laterSetBtn.setVisibility(4);
        this.oNextStepBtn.setEnabled(false);
        OLog.d(TAG, "updateBottomButtonState: networkCapabilities is null");
        return;
    L10:
        if (this.mIsCellFailed == true) goto L42;
        if (r7.hasCapability(16) == true) goto L19;
        OLog.d(TAG, "updateBottomButtonState: netCapabilityValidated is false");
        OTextView r8 = this.laterSetBtn;
        if (this.mIsCell == false) goto L17;
        r0 = 0;
    L17:
        r8.setVisibility(r0);
        this.oNextStepBtn.setEnabled(false);
        return;
    L19:
        boolean r1 = r7.hasTransport(0);
        OLog.d(TAG, "updateBottomButtonState: hasCellularTransport:" + r1 + " hasWifiTransport:" + r7.hasTransport(1));
        if (r1 == false) goto L44;
        this.mIsCell = true;
        this.laterSetBtn.setVisibility(0);
        this.laterSetBtn.setTextColor(getResources().getColorStateList(R.color.later_settings_textview_color, null));     // Catch: Exception -> L24
    L26:
        this.laterSetBtn.setEnabled(true);
        this.oNextStepBtn.setEnabled(false);
        return;
    L24:
        e = move-exception;
        OLog.e(TAG, "updateBottomButtonState: laterSetBtn.setTextColor error", e);
        goto L26
    L44:
        this.laterSetBtn.setTextColor(getResources().getColor(R.color.topbar_text_color));     // Catch: Exception -> L29
    L31:
        this.laterSetBtn.setEnabled(false);
        this.oNextStepBtn.setEnabled(true);
        this.mIsCell = false;
        if (this.mIsFirstActivate == true) goto L34;
        return;
    L34:
        if (this.mIsFirstFrpActivate == true) goto L36;
        return;
    L36:
        if (this.mIsActivateFailed == false) goto L38;
        return;
    L38:
        if (com.android.settings.Utils.isFastDoubleClick() == false) goto L40;
        return;
    L40:
        startActivate(0);
        return;
    L29:
        e = move-exception;
        OLog.e(TAG, "updateBottomButtonState: laterSetBtn.setTextColor error 22 ", e);
        goto L31
    }

    private static void setWifiEnabled(Context r3, boolean r4) {
        if (r4 == false) goto L4;
        String r0 = "true";
    L5:
        OLog.d(TAG, "start setWifiEnabled, enabled is ".concat(r0));
        String r1 = "open";
        if (((WifiManager) r3.getSystemService("wifi")).setWifiEnabled(r4) == false) goto L11;
        if (r4 == true) goto L10;
        r1 = "close";
    L10:
        OLog.i(TAG, r1.concat(" wifi success."));
        return;
    L11:
        if (r4 == true) goto L14;
        r1 = "close";
    L14:
        OLog.e(TAG, r1.concat(" wifi failed."));
        return;
    L4:
        r0 = "false";
        goto L5
    }

    private void setupWifiPickerTracker() {
        Context r2 = getContext();
        final ZoneOffset r0 = ZoneOffset.UTC;
        Clock r5 = new AnonymousClass9(this, r0);
        HandlerThread r1 = new HandlerThread("WifiSettings{" + Integer.toHexString(System.identityHashCode(this)) + VectorFormat.DEFAULT_SUFFIX, 10);
        this.mWifiPickerTrackerWorkerThread = r1;
        r1.start();
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mWorkerHandler = this.mWifiPickerTrackerWorkerThread.getThreadHandler();
        this.mWifiPickerTracker = FeatureFactory.getFactory(r2).getWifiTrackerLibProvider().createWifiPickerTracker(getLifecycle(), r2, this.mMainHandler, this.mWorkerHandler, r5, 15000, 5000, null);
    }

    private void initSetupWizardViews() {
        if (getIntent().getBooleanExtra("CMCC_WIFI_SETTING", false) == false) goto L6;
        this.mBackView.setVisibility(4);
        return;
    }

    private Unit initWifiSwitch(View r6) {
        RelativeLayout r7 = (RelativeLayout) r6;
        this.mWifiSwitchLayout = r7;
        r7.setOnTouchListener(new AnonymousClass10(this));
        OCardListItem r8 = (OCardListItem) this.mWifiSwitchLayout.findViewById(R.id.switch_wifi);
        this.mViewWifiSwitch = r8;
        r8.setOnClickListener(null);
        this.mWifiStateTipView = (TextView) this.mWifiSwitchLayout.findViewById(R.id.wifi_state_tips);
        int r1 = 0;
        if (this.mSetupWizardMode == false) goto L5;
        ((ViewStub) this.mWifiSwitchLayout.findViewById(R.id.preview_wizard)).setVisibility(0);
    L5:
        OCardListItem r9 = (OCardListItem) this.mWifiSwitchLayout.findViewById(R.id.assistant);
        this.networkAssistantView = r9;
        if (r9 == null) goto L9;
        r9.setOnContentClickListener(new AnonymousClass11(this));
    L9:
        if (isActivateMode() == false) goto L11;
    L17:
        OCardListItem r10 = this.networkAssistantView;
        if (r10 == null) goto L26;
        WifiEnabler r5 = this.mWifiSwitchEnabler;
        if (r5 == null) goto L26;
        if (r5.isChecked() == true) goto L25;
        r1 = 8;
    L25:
        r10.setVisibility(r1);
    L26:
        return null;
    L11:
        if (this.mWifiSwitchEnabler != null) goto L17;
        OSwitch r11 = (OSwitch) this.mViewWifiSwitch.findViewById(R.id.custom_end_switch);
        this.mWifiSwitchEnabler = new WifiEnabler(this._mActivity, r11, new WifiSettings$$ExternalSyntheticLambda23(this));
        if (this.mWifiManager.getWifiState() != 3) goto L15;
        boolean r2 = true;
    L16:
        r11.setChecked(r2);
        this.mWifiSwitchEnabler.resume(this._mActivity);
        goto L17
    L15:
        r2 = false;
        goto L16
    }

    /* JADX INFO: renamed from: lambda$initWifiSwitch$13$com-android-settings-wifi-WifiSettings, reason: not valid java name */
    /* synthetic */ void m697lambda$initWifiSwitch$13$comandroidsettingswifiWifiSettings() {
        updateWifiStateTips(R.string.wifi_starting);
    }

    private Unit initOtherNetworkView(View r1) {
        this.mOtherNetworkView = r1;
        return null;
    }

    private Unit initAddNetworkButton(View r2, boolean r3) {
        this.mAddNetworkLayout = r2;
        Button r4 = (Button) r2.findViewById(R.id.add_network);
        this.mAddNetworkSettingItem = r4;
        setBottomRoundedWhiteBackground(r4, r3, 20.0f);
        this.mAddNetworkSettingItem.setOnClickListener(new AnonymousClass12(this));
        OButton r5 = (OButton) this.mAddNetworkLayout.findViewById(R.id.scan_QRcode);
        this.mScanQRcodeSettingItem = r5;
        int r6 = 8;
        r5.setVisibility(8);
        this.mAddNetworkLayout.findViewById(R.id.qr_tips).setVisibility(8);
        WifiEnabler r7 = this.mWifiSwitchEnabler;
        if (r7 == null) goto L10;
        View r1 = this.mAddNetworkLayout;
        if (r7.isChecked() == false) goto L7;
        r6 = 0;
    L7:
        r1.setVisibility(r6);
        return null;
    L10:
        return null;
    }

    public void setBottomRoundedWhiteBackground(View r5, boolean r6, float r7) {
        if (isActivateMode() == false) goto L9;
        ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) r5.getLayoutParams();
        if (r6 == false) goto L7;
        r0.topMargin = 0;
    L8:
        r5.setLayoutParams(r0);
        goto L9
    L7:
        r0.topMargin = UIUtils.INSTANCE.dp2px(16);
    L9:
        float r8 = dpToPx((int) r7);
        if (r6 == false) goto L12;
        float r9 = 0.0f;
    L13:
        MaterialShapeDrawable r10 = new MaterialShapeDrawable(ShapeAppearanceModel.builder().setTopLeftCorner(0, r9).setTopRightCorner(0, r9).setBottomLeftCorner(0, r8).setBottomRightCorner(0, r8).build());
        r10.setFillColor(ColorStateList.valueOf(ContextCompat.getColor(this.mContext, R.color.oui_fill_list_item_card)));
        r10.setStroke(0.0f, 0);
        r10.setShadowCompatibilityMode(1);
        r10.setShadowEnabled(false);
        r10.setElevation(0.0f);
        ViewCompat.setBackground(r5, r10);
        r5.setElevation(0.0f);
        r5.setTranslationZ(0.0f);
        r5.setOutlineProvider(null);
        if ((r5.getParent() instanceof ViewGroup) == false) goto L17;
        ViewGroup r4 = (ViewGroup) r5.getParent();
        return;
    L17:
        return;
    L12:
        r9 = r8;
        goto L13
    }

    private void updateSimStateView() {
        if (isActivateMode() == false) goto L11;
        View r0 = this.mNoSIMTipContainer;
        if (r0 == null) goto L7;
        r0.setVisibility(8);
    L7:
        View r2 = this.mSmsTipContainer;
        if (r2 == null) goto L12;
        r2.setVisibility(8);
        return;
    L12:
        return;
    }

    public void updateViews() {
        Activity r0 = this._mActivity;
        WifiEnabler r1 = this.mWifiSwitchEnabler;
        if (r1 == null) goto L5;
        r1.resume(r0);
    L5:
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r0, this.mReceiver, this.mFilter, 2);
        this.mKeyStoreNetworkId = -1;
        updateSimStateView();
        updateNetworkInfo();
        updateAccessPoints();
        ensureContentVisibleIfNeeded();
        UserManager r2 = (UserManager) this._mActivity.getSystemService(UserManager.class);
        FrameLayout r3 = (FrameLayout) findViewByIdNullable(R.id.empty_view);
        if (r2.hasUserRestriction("no_config_wifi") == false) goto L12;
        if (r3.getVisibility() != 0) goto L12;
        finish();
        return;
    L12:
        if (DevicePolicyUtils.trySendShowAdminSupportDetailsIntent(this._mActivity, "no_config_wifi") == false) goto L16;
        if (r3 == null) goto L17;
        r3.setVisibility(0);
        return;
    L17:
        return;
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    private void showSwitchConfirmDialog(Context r7, final WifiConfiguration r8, final WifiManager.ActionListener r9) {
        HandInHandProcessor r0 = new HandInHandProcessor();
        if (this.mConnected.get() == true) goto L5;
    L7:
        this.mWifiManager.connect(r8, r9);
        if (AccessPointInfo.getSecurity(r8) != 0) goto L10;
        TrackerEvent.buttonEvent("settings_wifi_try_connect_no_password");
        return;
    L10:
        TrackerEvent.buttonEvent("settings_wifi_try_connect_password");
        return;
    L5:
        if (r0.isHandInHandle(r7) == false) goto L7;
        r0.showDialog(r7, 2, new AnonymousClass13(this), new AnonymousClass14(this, r8, r9), new AnonymousClass15(this));
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
        OLog.d(TAG, "onItemClick position=" + r3 + ", id=" + r4);
    }

    private Unit processItemClick(AccessPointInfo r7) {
        if (com.android.settings.Utils.isFastDoubleClick() == false) goto L5;
        return null;
    L5:
        if (r7 != null) goto L7;
        return null;
    L7:
        RestrictedLockUtils.EnforcedAdmin r0 = MultiSDKAdapterNew.checkIfRestrictionEnforced(this._mActivity, "no_config_wifi", UserHandle.myUserId());
        if (r0 == null) goto L12;
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(this._mActivity, r0);
        return null;
    L12:
        if (r7.networkId != (-1)) goto L17;
        RestrictedLockUtils.EnforcedAdmin r1 = MultiSDKAdapterNew.checkIfRestrictionEnforced(this._mActivity, "no_add_wifi_config", UserHandle.myUserId());
        if (r1 == null) goto L17;
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(this._mActivity, r1);
        return null;
    L17:
        boolean r2 = r7.equalsTo(this.mSelectedAccessPoint);
        this.mSelectedAccessPoint = r7;
        if (startCaptivePortal(r7) == false) goto L20;
        return null;
    L20:
        OLog.d(TAG, "onItemClick mSelectedAccessPoint" + this.mSelectedAccessPoint.ssid + ", networkId=" + this.mSelectedAccessPoint.networkId);
        if (this.mSelectedAccessPoint.security != 0) goto L29;
        if (this.mSelectedAccessPoint.networkId != (-1)) goto L29;
        this.mSelectedAccessPoint.generateOpenNetworkConfig();
        if (savedNetworksExist == true) goto L27;
        savedNetworksExist = true;
    L27:
        showSwitchConfirmDialog(getActivity(), this.mSelectedAccessPoint.getConfig(), this.mConnectListener);
    L50:
        return null;
    L29:
        if (this.mSelectedAccessPoint.networkId == (-1)) goto L46;
        NetworkInfo.DetailedState r8 = this.mSelectedAccessPoint.getState();
        int r3 = this.mSelectedAccessPoint.getLevel();
        if (r8 != null) goto L41;
        if (r3 == (-1)) goto L41;
        if (r2 == false) goto L38;
        if (r2 == false) goto L50;
        if ((System.currentTimeMillis() - this.mLastConnectAccessPointTs) <= 2000) goto L50;
    L38:
        this.mLastConnectAccessPointTs = System.currentTimeMillis();
        FragmentActivity r9 = getActivity();
        if (r9 == null) goto L50;
        showSwitchConfirmDialog(r9, this.mSelectedAccessPoint.getConfig(), this.mConnectListener);
    L41:
        if (r8 != null) goto L43;
    L45:
        Bundle r10 = new Bundle();
        r10.putParcelable(AccessPointInfo.EXTRA_WIFI_CONFIGURATION, this.mSelectedAccessPoint.getConfig());
        r10.putSerializable(AccessPointInfo.EXTRA_PSK_TYPE, this.mSelectedAccessPoint.pskType);
        r10.putParcelable(AccessPointInfo.EXTRA_WIFI_INFO, this.mSelectedAccessPoint.getInfo());
        r10.putSerializable(AccessPointInfo.EXTRA_DETAILED_STATE, this.mSelectedAccessPoint.getState());
        r10.putInt("back_text_id", R.string.wifi_settings_title);
        r10.putString("key_chosen_wifientry_key", this.mSelectedAccessPoint.key);
        Intent r4 = new Intent(getContext(), Settings.AccessPointDetailActivity.class);
        r4.putExtras(r10);
        com.android.settings.Utils.startActivity(this._mActivity, r4);
        TrackerEvent.buttonEvent("settings_wifi_details");
        goto L50
    L43:
        if (r8 == NetworkInfo.DetailedState.CONNECTED) goto L45;
        return null;
    L46:
        Bundle r11 = new Bundle();
        r11.putBoolean("edit", false);
        r11.putBoolean("text_is_selectable", !this.mSetupWizardMode);
        if (this.mSelectedAccessPoint == null) goto L49;
        Bundle r5 = new Bundle();
        this.mSelectedAccessPoint.saveWifiState(r5);
        r11.putBundle("access_point", r5);
    L49:
        WifiSetupFragment r6 = new WifiSetupFragment();
        r6.setRightBtnText(getResources().getString(R.string.wifi_connect));
        r6.setRightBtnColor(getResources().getColor(R.color.oui_dark_functional_blue_6));
        r6.setArguments(r11);
        start(r6);
        TrackerEvent.buttonEvent("settings_wifi_try_connect_password");
        goto L50
    }

    private boolean startCaptivePortal(AccessPointInfo r8) {
        ConnectivityManager r0 = (ConnectivityManager) this.mContext.getSystemService(ConnectivityManager.class);
        WifiEntry r1 = this.mWifiPickerTracker.getConnectedWifiEntry();
        if (r1 != null) goto L6;
        return false;
    L6:
        if (r8.ssid.equals(AccessPointInfo.removeDoubleQuotes(r1.getSsid())) == true) goto L8;
        return false;
    L8:
        Uri r9 = getCaptivePortalVenueInfoUrl();
        if (r9 != null) goto L16;
        if (r1.canSignIn() == true) goto L13;
        return false;
    L13:
        WifiManager r10 = (WifiManager) this.mContext.getSystemService("wifi");
        android.net.wifi.WifiInfo r2 = r10.getConnectionInfo();
        Intent r3 = new Intent();
        r3.setClassName(WifiAuthorizeUtils.PACKAGE_NAME, WifiAuthorizeUtils.CLASS_NAME);
        r3.putExtra(WifiAuthorizeUtils.EXTRA_NAME_IP_ADDRESS, r2.getIpAddress() + "");
        r3.putExtra("ssid", r2.getSSID());
        r3.putExtra(WifiAuthorizeUtils.EXTRA_NAME_WIFI_CONFIG, getCurrenWifiConfiguration(r10, r2));
        r3.setFlags(268435456);
        com.android.settings.Utils.startActivity(getActivity(), r3);
        TrackerEvent.buttonEvent("settings_wifi_try_connect_portal");
        return true;
    L16:
        if (r1.getConnectedState() != 2) goto L19;
        Intent r4 = new Intent("android.intent.action.VIEW");
        r4.setFlags(268435456);
        r4.setData(r9);
        com.android.settings.Utils.startActivity(getActivity(), r4);
        TrackerEvent.buttonEvent("settings_wifi_try_connect_portal");
        return true;
    L19:
        return false;
    }

    private WifiConfiguration getCurrenWifiConfiguration(WifiManager r5, android.net.wifi.WifiInfo r6) {
        if (r5 == null) goto L27;
        if (r6 == null) goto L32;
        int r7 = r6.getNetworkId();
        List<WifiConfiguration> r8 = r5.getConfiguredNetworks();     // Catch: RuntimeException -> L17 NullPointerException -> L19
        if (r8 != null) goto L10;
        return null;
    L10:
        if (r7 == (-1)) goto L29;
        Iterator<WifiConfiguration> r9 = r8.iterator();     // Catch: RuntimeException -> L17 NullPointerException -> L19
    L13:
        if (r9.hasNext() == false) goto L33;
        WifiConfiguration r2 = r9.next();     // Catch: RuntimeException -> L17 NullPointerException -> L19
        if (r2.networkId != r7) goto L13;
        return r2;
    L33:
        return null;
    L29:
        return null;
    L19:
        e = move-exception;
        OLog.e(TAG, "e :" + e);
        return null;
    L17:
        e = move-exception;
        OLog.e(TAG, "e :" + e);
        return null;
    L32:
        return null;
    L27:
        return null;
    }

    private Uri getCaptivePortalVenueInfoUrl() {
        LinkProperties r1 = this.mLinkProperties;
        if (r1 != null) goto L5;
        return null;
    L5:
        CaptivePortalData r2 = r1.getCaptivePortalData();
        if (r2 != null) goto L9;
        return null;
    L9:
        return r2.getVenueInfoUrl();
    }

    void updateNetworkInfo() {
        ConnectivityManager r0 = (ConnectivityManager) this.mContext.getSystemService(ConnectivityManager.class);
        WifiEntry r1 = this.mWifiPickerTracker.getConnectedWifiEntry();
        if (r1 != null) goto L6;
        return;
    L6:
        if (r1.getConnectedState() != 2) goto L8;
        Network r2 = this.mWifiManager.getCurrentNetwork();
        this.mNetwork = r2;
        this.mLinkProperties = r0.getLinkProperties(r2);
        return;
    L8:
        this.mNetwork = null;
        this.mLinkProperties = null;
    }

    private void updateAccessPoints() {
        if (this.mUpdateWifiListInstantWhenFirstIn == false) goto L6;
        this.mUpdateWifiListInstantWhenFirstIn = false;
        new UpdateAccessPointsTask(this).execute(new Void[0]);
        return;
    L6:
        if (this.mHandler.hasMessages(1) == false) goto L8;
        this.mHandler.removeMessages(1);
    L8:
        this.mHandler.sendEmptyMessageDelayed(1, 150);
    }

    private boolean isFromNetworkPanel() {
        Bundle r1 = getArguments();
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.containsKey(EXTRA_KEY_SSID) == false) goto L7;
        return true;
    }

    private boolean handleExtraAccessPointInfoIfNeed(ArrayList<AccessPointInfo> r11) {
        if (r11 != null) goto L5;
    L18:
        return false;
    L5:
        if (isFromNetworkPanel() == false) goto L18;
        Bundle r1 = getArguments();
        String r3 = r1.getString(EXTRA_KEY_SSID);
        int r5 = r1.getInt(EXTRA_KEY_SECURITY, 0);
        int r6 = r1.getInt(EXTRA_KEY_NETWORK_ID, -1);
        Iterator<AccessPointInfo> r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L18;
        AccessPointInfo r8 = r12.next();
        if (TextUtils.equals(r3, r8.ssid) == false) goto L9;
        if (r6 != r8.networkId) goto L9;
        if (r5 != r8.security) goto L9;
        Bundle r13 = new Bundle();
        r13.putBoolean("edit", false);
        r13.putBoolean("text_is_selectable", !this.mSetupWizardMode);
        Bundle r0 = new Bundle();
        r8.saveWifiState(r0);
        r13.putBundle("access_point", r0);
        WifiSetupFragment r2 = new WifiSetupFragment();
        r2.setArguments(r13);
        start(r2);
        r1.remove(EXTRA_KEY_SSID);
        r1.remove(EXTRA_KEY_SECURITY);
        r1.remove(EXTRA_KEY_NETWORK_ID);
        return true;
    }

    private void updateAccessPointsUI(ArrayList<AccessPointInfo> r6) {
        if (getActivity() != null) goto L5;
        return;
    L5:
        if (isAdded() == false) goto L37;
        OLog.d(TAG, "updateAccessPointsUI----");
        int r0 = this.mWifiManager.getWifiState();
        if (r0 == 0) goto L31;
        boolean r3 = true;
        if (r0 != 1) goto L12;
        AccessPointInfo.updateConnectedAccessPointRssi(-200);
        updateWifiStateTips(R.string.wifi_empty_list_wifi_off);
        this.mWifiListSetupAdapter.updateData(null);
        return;
    L12:
        if (r0 != 2) goto L14;
        AccessPointInfo.updateConnectedAccessPointRssi(-200);
        updateWifiStateTips(R.string.wifi_starting);
        this.mWifiListSetupAdapter.updateData(null);
        return;
    L14:
        if (r0 == 3) goto L17;
        return;
    L17:
        if (r6 != null) goto L19;
    L22:
        if (r3 == false) goto L24;
        updateWifiStateTips(R.string.wifi_empty_list_wifi_on);
    L26:
        if (handleExtraAccessPointInfoIfNeed(r6) == false) goto L28;
        return;
    L28:
        this.mWifiListSetupAdapter.updateData(r6);
        return;
    L24:
        updateWifiStateTips(0);
        goto L26
    L19:
        if (r6.size() == 0) goto L22;
        r3 = false;
        goto L22
    L31:
        updateWifiStateTips(R.string.wifi_stopping);
        this.mWifiListSetupAdapter.updateData(null);
        return;
    }

    private void updateWifiStateTips(int r2) {
        if (this.mSetupWizardMode == true) goto L5;
        return;
    L5:
        TextView r0 = this.mWifiStateTipView;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r2 <= 0) goto L10;
        r0.setText(r2);
        this.mWifiStateTipView.setVisibility(0);
        return;
    L10:
        r0.setVisibility(8);
    }

    private void updateBottomViews(boolean r5) {
        OLog.d(TAG, "updateBottomViews " + r5);
        boolean r0 = false;
        if (r5 == true) goto L5;
        Optional.ofNullable(this.mOtherNetworkView).ifPresent(new WifiSettings$$ExternalSyntheticLambda21());
        Optional.ofNullable(this.mAddNetworkLayout).ifPresent(new WifiSettings$$ExternalSyntheticLambda22());
        OCardListItem r6 = this.networkAssistantView;
        if (r6 == null) goto L14;
        r6.setVisibility(8);
    L14:
        this.mWifiListSetupAdapter.updateData(null);
    L16:
        if (this.mAddNetworkLayout == null) goto L22;
        OLog.d(TAG, "mAddNetworkLayout isShow = " + this.mAddNetworkLayout.isShown());
        StringBuilder r7 = new StringBuilder("mAddNetworkLayout visible =");
        if (this.mAddNetworkLayout.getVisibility() != 0) goto L20;
        boolean r3 = true;
    L21:
        OLog.d(TAG, r7.append(r3).toString());
    L24:
        if (this.mAddNetworkSettingItem == null) goto L29;
        OLog.d(TAG, "mAddNetworkSettingItem isShow = " + this.mAddNetworkSettingItem.isShown());
        StringBuilder r8 = new StringBuilder("mAddNetworkSettingItem visible =");
        if (this.mAddNetworkSettingItem.getVisibility() != 0) goto L28;
        r0 = true;
    L28:
        OLog.d(TAG, r8.append(r0).toString());
        return;
    L29:
        OLog.d(TAG, "updateBottomViews, mAddNetworkSettingItem is null");
        return;
    L20:
        r3 = false;
        goto L21
    L22:
        OLog.d(TAG, "updateBottomViews, mAddNetworkLayout is null");
        goto L24
    L5:
        if (((UserManager) this._mActivity.getSystemService(PickApplicationActivity.EXTRA_USER)).hasUserRestriction("no_config_wifi") == false) goto L7;
        Optional.ofNullable(this.mOtherNetworkView).ifPresent(new WifiSettings$$ExternalSyntheticLambda17());
        Optional.ofNullable(this.mAddNetworkLayout).ifPresent(new WifiSettings$$ExternalSyntheticLambda18());
    L8:
        OCardListItem r9 = this.networkAssistantView;
        if (r9 == null) goto L16;
        r9.setVisibility(0);
        goto L16
    L7:
        Optional.ofNullable(this.mOtherNetworkView).ifPresent(new WifiSettings$$ExternalSyntheticLambda19());
        Optional.ofNullable(this.mAddNetworkLayout).ifPresent(new WifiSettings$$ExternalSyntheticLambda20());
        goto L8
    }

    static /* synthetic */ void lambda$updateBottomViews$14(View r1) {
        r1.setVisibility(8);
    }

    static /* synthetic */ void lambda$updateBottomViews$15(View r1) {
        r1.setVisibility(8);
    }

    static /* synthetic */ void lambda$updateBottomViews$16(View r1) {
        r1.setVisibility(0);
    }

    static /* synthetic */ void lambda$updateBottomViews$17(View r1) {
        r1.setVisibility(0);
    }

    static /* synthetic */ void lambda$updateBottomViews$18(View r1) {
        r1.setVisibility(8);
    }

    static /* synthetic */ void lambda$updateBottomViews$19(View r1) {
        r1.setVisibility(8);
    }

    private ArrayList<AccessPointInfo> constructAccessPoints(WifiManager r26, android.net.wifi.WifiInfo r27, NetworkInfo.DetailedState r28) {
        ArrayList r5 = new ArrayList();
        ArrayList<AccessPointInfo> r6 = new ArrayList();
        Multimap r7 = new Multimap(null);
        HashSet r9 = new HashSet();
        List<WifiConfiguration> r0 = r26.getConfiguredNetworks();     // Catch: RuntimeException -> L5
    L8:
        if (r0 == null) goto L47;
        int r12 = r0.size() - 1;
        int r13 = 0;
    L11:
        if (r13 >= r0.size()) goto L47;
        WifiConfiguration r14 = r0.get(r13);
        OLog.i(TAG, "WifiConfiguration [" + r13 + LibrarianImpl.Constants.SEPARATOR + r12 + "]:" + r14.toString().replace("\n", "--"));
        if (r9.contains(Integer.valueOf(r14.networkId)) == false) goto L16;
    L14:
        r0 = r0;
        r6 = r6;
        int r17 = r12;
    L46:
        r13 = r13 + 1;
        r0 = r0;
        r12 = r17;
        r6 = r6;
        goto L11
    L16:
        if (new AdaptWifiConfig(r14).getSelfAdded() == true) goto L18;
    L20:
        AccessPointInfo r8 = new AccessPointInfo(r14);
        if (r27 == 0) goto L25;
        if (r28 == 0) goto L25;
        r8.update(r27, r28);
    L25:
        if (r8.getState() == NetworkInfo.DetailedState.CONNECTED) goto L27;
    L44:
        r6 = r6;
        r17 = r12;
    L45:
        r9.add(Integer.valueOf(r14.networkId));
        setWifiEntryKey(r8);
        r5.add(r8);
        r7.put(r8.ssid, r8);
        goto L46
    L27:
        if (SettingsProviderUtils.isWlanSecurityCheckSwitchEnabled(getContext()) == false) goto L44;
        if (this.wlanRiskInfo == null) goto L31;
        r17 = r12;
        boolean r2 = !WlanRiskInfo.Companion.isWlanRisk(this.wlanRiskInfo, r8.ssid, this.mLastInfo.getBSSID());
        OLog.d(TAG, "wlanRiskInfo: isSafe=" + r2 + ", wlanRiskInfo.ssid=" + this.wlanRiskInfo.getSsid());
    L37:
        r6 = r6;
    L43:
        OLog.d(TAG, "queryWifiSafe: isSafe=" + r2 + ", ssid=" + r8.ssid + ", bssid=" + this.mLastInfo.getBSSID());
        r8.setIsSafe(r2);
        this.lastConnectedAccessPoint = r8;
        goto L45
    L31:
        r17 = r12;
        AccessPointInfo r3 = this.lastConnectedAccessPoint;
        if (r3 != null) goto L34;
    L38:
        String r4 = this.mLastInfo.getBSSID();
        boolean r10 = WIFIUtils.INSTANCE.queryWifiSafe(this.mContext, r8.ssid, r4);
        if (r10 == true) goto L42;
        ArrayList r11 = new ArrayList();
        r11.add("isSafe:" + r10);
        this.wlanRiskInfo = new WlanRiskInfo(r8.ssid, r4, r11, 0);
        OLog.i(TAG, "queryWifiSafe: isSafe=" + r10 + ", ssid=" + r8.ssid + ", bssid=" + r4);
    L42:
        r2 = r10;
        goto L43
    L34:
        if (Objects.equals(r3.ssid, r8.ssid) == false) goto L38;
        r2 = true;
        goto L37
    L18:
        if (r14.numAssociation != 0) goto L20;
    L47:
        ArrayList<AccessPointInfo> r24 = r6;
        List<ScanResult> r15 = r26.getScanResults();     // Catch: RuntimeException -> L50
    L52:
        if (r15 == null) goto L72;
        Iterator<ScanResult> r1 = r15.iterator();
    L55:
        if (r1.hasNext() == false) goto L72;
        ScanResult r16 = r1.next();
        if (r16.SSID == null) goto L55;
        if (r16.SSID.length() == 0) goto L55;
        if (r16.capabilities.contains("[IBSS]") == true) goto L55;
        SLog.i(TAG, "ScanResult " + r16);
        List r18 = r7.getAll(r16.SSID);
        int r19 = 0;
        boolean r20 = false;
    L65:
        if (r19 >= r18.size()) goto L70;
        if (((AccessPointInfo) r18.get(r19)).update(r16) == false) goto L69;
        r20 = true;
    L69:
        r19 = r19 + 1;
        goto L65
    L70:
        if (r20 == true) goto L55;
        AccessPointInfo r21 = new AccessPointInfo(r16);
        setWifiEntryKey(r21);
        r5.add(r21);
        r7.put(r21.ssid, r21);
    L72:
        boolean r22 = ((UserManager) this.mContext.getSystemService(PickApplicationActivity.EXTRA_USER)).hasUserRestriction("no_config_wifi");
        Iterator r23 = r5.iterator();
    L74:
        if (r23.hasNext() == false) goto L85;
        AccessPointInfo r25 = (AccessPointInfo) r23.next();
        if (r22 == false) goto L81;
        if (r25.networkId == (-1)) goto L74;
    L81:
        if (r25.getLevel() < 0) goto L83;
        ArrayList<AccessPointInfo> r29 = r24;
        r29.add(r25);
    L84:
        r24 = r29;
        goto L74
    L83:
        r29 = r24;
        goto L84
    L85:
        ArrayList<AccessPointInfo> r30 = r24;
        Collections.sort(r30);
        return r30;
    L50:
        e = move-exception;
        OLog.e(TAG, "wifiManager.getScanResults(), e:" + e);
        r15 = null;
    L5:
        e = move-exception;
        OLog.e(TAG, "getConfiguredNetworks exception : " + e);
        r0 = null;
        goto L8
    }

    private void setWifiEntryKey(AccessPointInfo r5) {
        WifiPickerTracker r0 = this.mWifiPickerTracker;
        if (r0 != null) goto L5;
        return;
    L5:
        WifiEntry r1 = r0.getConnectedWifiEntry();
        if (r1 != null) goto L8;
        OLog.d(TAG, "setWifiEntryKey: connectedWifiEntry is null ");
        r1 = CacheMgr.INSTANCE.getConnectedEntry();
    L8:
        if (r1 != null) goto L11;
        OLog.d(TAG, "connectedWifiEntry is null");
    L16:
        Iterator<WifiEntry> r4 = this.mWifiPickerTracker.getWifiEntries().iterator();
    L18:
        if (r4.hasNext() == false) goto L31;
        WifiEntry r2 = r4.next();
        if (r5.ssid.equals(r2.getSsid()) == false) goto L18;
        if (r5.checkSecuritySame(r2) == false) goto L18;
        r5.key = r2.getKey();
        r5.wifiEntry = r2;
        return;
    L31:
        return;
    L11:
        if (r5.ssid.equals(r1.getSsid()) == false) goto L16;
        if (r5.checkSecuritySame(r1) == false) goto L16;
        OLog.d(TAG, "setWifiEntryKey: connectedWifiEntry summary " + r1.getSummary());
        r5.key = r1.getKey();
        r5.wifiEntry = r1;
        r5.mState = NetworkInfo.DetailedState.CONNECTED;
        r1.setListener(this.wifiEntryCallback);
    }

    private void handleEvent(Intent r5) {
        String r0 = r5.getAction();
        OLog.d(TAG, "handleEvent action " + r0);
        if ("android.net.wifi.WIFI_STATE_CHANGED".equals(r0) == false) goto L6;
        updateWifiState(r5.getIntExtra("wifi_state", 4));
        return;
    L6:
        if ("android.net.wifi.SCAN_RESULTS".equals(r0) == false) goto L8;
    L61:
        updateAccessPoints();
        return;
    L8:
        if ("android.net.wifi.CONFIGURED_NETWORKS_CHANGE".equals(r0) == true) goto L61;
        if (AdaptConstants.LINK_CONFIGURATION_CHANGED_ACTION.equals(r0) == true) goto L61;
        if ("android.net.wifi.supplicant.STATE_CHANGE".equals(r0) == false) goto L37;
        if (r5.hasExtra("supplicantError") == false) goto L24;
        final WifiConfiguration r1 = (WifiConfiguration) r5.getParcelableExtra("extra_failedAuthConfig");
        if (getActivity() != null) goto L19;
    L23:
        this.mScanner.forceScan();
        goto L24
    L19:
        if (getActivity().isFinishing() == true) goto L23;
        if (MultiSDKAdapter.isWrongPSWDReason(r5) == false) goto L23;
        ThreadUtils.postOnBackgroundThread(new WifiSettings$$ExternalSyntheticLambda16(this, r1));
    L24:
        SupplicantState r6 = (SupplicantState) r5.getParcelableExtra("newState");
        if (r6 != null) goto L28;
        return;
    L28:
        if (this.mConnected.get() == true) goto L33;
        if (AdaptWifi.isHandshakeState(r6) == false) goto L33;
        updateConnectionState(android.net.wifi.WifiInfo.getDetailedStateOf(r6), true);
        return;
    L33:
        if (r6 != SupplicantState.DISCONNECTED) goto L35;
        CacheMgr.INSTANCE.setConnectedEntry(null);
        updateConnectionState(android.net.wifi.WifiInfo.getDetailedStateOf(r6), true);
        return;
    L35:
        updateConnectionState(null, true);
        return;
    L37:
        if ("android.net.wifi.STATE_CHANGE".equals(r0) == false) goto L54;
        NetworkInfo r2 = (NetworkInfo) r5.getParcelableExtra("networkInfo");
        if (r2 != null) goto L41;
        return;
    L41:
        this.mConnected.set(r2.isConnected());
        if (this.mConnected.get() == false) goto L48;
        OAlertDialog r3 = this.retryDialog;
        if (r3 == null) goto L48;
        if (r3.isShowing() == false) goto L48;
        this.retryDialog.dismiss();
    L48:
        updateConnectionState(r2.getDetailedState(), true);
        updateAccessPoints();
        String r7 = r5.getStringExtra(WlanRiskInfo.EXTRA_BSSID);
        if (r7 != null) goto L51;
        return;
    L51:
        if (r7.equals(this.mConnectSSID) == true) goto L68;
        this.mConnectSSID = r7;
        return;
    L68:
        return;
    L54:
        if ("android.net.wifi.RSSI_CHANGED".equals(r0) == false) goto L59;
        int r8 = r5.getIntExtra("newRssi", -200);
        AccessPoint.updateConnectedAccessPointRssi(r8);
        AccessPointInfo.updateConnectedAccessPointRssi(r8);
        updateConnectionState(null, false);
        WifiListSetupAdapter r4 = this.mWifiListSetupAdapter;
        if (r4 == null) goto L70;
        r4.tryUpdateConnectedAccessPointRssi();
        return;
    L70:
        return;
    L59:
        if ("android.intent.action.SIM_STATE_CHANGED".equals(r0) == false) goto L72;
        updateSimStateView();
        return;
    }

    /* JADX INFO: renamed from: lambda$handleEvent$21$com-android-settings-wifi-WifiSettings, reason: not valid java name */
    /* synthetic */ void m696lambda$handleEvent$21$comandroidsettingswifiWifiSettings(final WifiConfiguration r4) {
        final ArrayList<AccessPointInfo> r0 = constructAccessPoints(this.mWifiManager, this.mLastInfo, this.mLastState);
        ThreadUtils.postOnMainThread(new WifiSettings$$ExternalSyntheticLambda11(this, r0, r4));
    }

    /* JADX INFO: renamed from: lambda$handleEvent$20$com-android-settings-wifi-WifiSettings, reason: not valid java name */
    /* synthetic */ void m695lambda$handleEvent$20$comandroidsettingswifiWifiSettings(ArrayList r1, WifiConfiguration r2) {
        updateAccessPointsUI(r1);
        showRetryDialog(r2);
    }

    private void showRetryDialog(WifiConfiguration r7) {
        if (r7 == null) goto L17;
        List<AccessPointInfo> r1 = this.mWifiListSetupAdapter.getData();
        if (r1 == null) goto L14;
        int r2 = r1.size() - 1;
    L7:
        if (r2 < 0) goto L14;
        AccessPointInfo r3 = r1.get(r2);
        if (AccessPoint.removeDoubleQuotes(r7.SSID).equals(r3.ssid) == false) goto L13;
        if (r3.security != AccessPoint.getSecurity(r7)) goto L13;
        this.mCurrentAccessPoint = r3;
        boolean r8 = true;
    L15:
        if (r8 == true) goto L17;
        this.mCurrentAccessPoint = this.mSelectedAccessPoint;
    L13:
        r2 = r2 - 1;
    L14:
        r8 = false;
    L17:
        final AccessPointInfo r9 = this.mCurrentAccessPoint;
        if (r9 == null) goto L30;
        OLog.d(TAG, "show retryDialog");
        OAlertDialog r4 = this.retryDialog;
        if (r4 != null) goto L22;
    L24:
        OAlertDialog r10 = new OAlertDialogBuilder(getActivity()).autoDismiss(true).horizontalButton().title(R.string.wifi_connection_failure_title).message(R.string.wifi_connection_failure_msg).negativeButton(R.string.wifi_connection_failure_cancel, new AnonymousClass17(this)).positiveButton(R.string.wifi_connection_failure_ok, new AnonymousClass16(this, r9)).build();
        this.retryDialog = r10;
        r10.show();
        return;
    L22:
        if (r4.isShowing() == false) goto L24;
        return;
    }

    private void updateConnectionState(NetworkInfo.DetailedState r2, boolean r3) {
        if (this.mWifiManager.isWifiEnabled() == true) goto L7;
        this.mScanner.pause();
        return;
    L7:
        if (r2 != NetworkInfo.DetailedState.OBTAINING_IPADDR) goto L9;
        this.mScanner.pause();
    L11:
        this.mLastInfo = this.mWifiManager.getConnectionInfo();
        if (r2 == null) goto L14;
        this.mLastState = r2;
    L14:
        updateAccessPoints();
        return;
    L9:
        if (r3 == false) goto L11;
        this.mScanner.resume();
        goto L11
    }

    private void updateWifiState(int r4) {
        OLog.d(TAG, "updateWifiState state = " + r4);
        if (r4 != 0) goto L5;
        updateWifiStateTips(R.string.wifi_stopping);
        updateBottomViews(false);
    L19:
        this.mLastInfo = null;
        this.mLastState = null;
        this.mScanner.pause();
        return;
    L5:
        if (r4 != 1) goto L7;
        unregisterWifiRiskReceiver();
        updateWifiStateTips(R.string.wifi_empty_list_wifi_off);
        updateBottomViews(false);
        goto L19
    L7:
        if (r4 != 2) goto L9;
        updateWifiStateTips(R.string.wifi_starting);
        updateBottomViews(true);
        goto L19
    L9:
        if (r4 != 3) goto L11;
        registerWifiRiskReceiver();
        this.mScanner.resume();
        updateBottomViews(true);
        ThreadUtils.postOnBackgroundThread(new WifiSettings$$ExternalSyntheticLambda15(this));
        return;
    L11:
        if (r4 == 4) goto L13;
        updateWifiStateTips(R.string.wifi_unknown_state);
        updateBottomViews(false);
        goto L19
    L13:
        updateWifiStateTips(R.string.wifi_unknown_state);
        updateBottomViews(false);
        goto L19
    }

    /* JADX INFO: renamed from: lambda$updateWifiState$23$com-android-settings-wifi-WifiSettings, reason: not valid java name */
    /* synthetic */ void m712lambda$updateWifiState$23$comandroidsettingswifiWifiSettings() {
        final ArrayList<AccessPointInfo> r0 = constructAccessPoints(this.mWifiManager, this.mLastInfo, this.mLastState);
        ThreadUtils.postOnMainThread(new WifiSettings$$ExternalSyntheticLambda0(this, r0));
    }

    /* JADX INFO: renamed from: lambda$updateWifiState$22$com-android-settings-wifi-WifiSettings, reason: not valid java name */
    /* synthetic */ void m711lambda$updateWifiState$22$comandroidsettingswifiWifiSettings(ArrayList r1) {
        updateAccessPointsUI(r1);
    }

    protected void connect(WifiConfiguration r2) {
        this.mWifiManager.connect(r2, this.mConnectListener);
    }

    protected void connect(int r2) {
        this.mWifiManager.connect(r2, this.mConnectListener);
    }

    void onAddNetworkPressed() {
        RestrictedLockUtils.EnforcedAdmin r0 = MultiSDKAdapterNew.checkIfRestrictionEnforced(this._mActivity, "no_config_wifi", UserHandle.myUserId());
        if (r0 == null) goto L6;
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(this._mActivity, r0);
        return;
    L6:
        RestrictedLockUtils.EnforcedAdmin r1 = MultiSDKAdapterNew.checkIfRestrictionEnforced(this._mActivity, "no_add_wifi_config", UserHandle.myUserId());
        if (r1 == null) goto L10;
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(this._mActivity, r1);
        return;
    L10:
        this.mSelectedAccessPoint = null;
        Bundle r2 = new Bundle();
        r2.putBoolean("edit", true);
        r2.putBoolean("text_is_selectable", !this.mSetupWizardMode);
        WifiSetupFragment r3 = new WifiSetupFragment();
        r3.setArguments(r2);
        start(r3);
        SettingsTracker.onItemClick(202);
        TrackerEvent.buttonEvent("settings_wifi_add_network_manually");
    }

    void pauseWifiScan() {
        if (this.mWifiManager.isWifiEnabled() == false) goto L6;
        this.mScanner.pause();
        return;
    }

    void resumeWifiScan() {
        if (this.mWifiManager.isWifiEnabled() == false) goto L6;
        this.mScanner.resume();
        return;
    }

    boolean isActivateMode() {
        if (this.mSetupWizardMode == true) goto L5;
    L7:
        return false;
    L5:
        if (com.android.settings.Utils.ACTIVATE_MODE == false) goto L7;
        return true;
    }

    private boolean isFrpActivated() {
        OLog.i(TAG, "isFrpActivated enter");
        if ((this._mActivity instanceof WifiPickerActivity2) == false) goto L5;
        boolean r3 = ((WifiPickerActivity2) this._mActivity).checkFrpActivated();
    L6:
        OLog.i(TAG, "isFrpActivated res=" + r3);
        return r3;
    L5:
        r3 = false;
        goto L6
    }

    private void startActivate(int r3) {
        OLog.i(TAG, "startActivate flag: " + r3 + ", mActivateRequested: " + this.mActivateRequested);
        if (isFrpActivated() == false) goto L7;
        this.mIsFirstFrpActivate = false;
        return;
    L7:
        if (this.mSetupWizardMode == true) goto L9;
        return;
    L9:
        if (this.mActivateRequested == false) goto L12;
        return;
    L12:
        if ((this._mActivity instanceof WifiPickerActivity2) == false) goto L14;
        ((WifiPickerActivity2) this._mActivity).startActivate(this.mIsCell);
    L14:
        this.mIsFirstActivate = false;
        this.mActivateRequested = true;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_START);
        super.onStart();
        registerNetworkCallback();
        registerWifiRiskReceiver();
    }

    public void com_android_settings_wifi_WifiSettings__onResume$___twin___() {
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_RESUME);
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_PAUSE);
        super.onPause();
        OAlertDialog r0 = this.retryDialog;
        if (r0 != null) goto L5;
    L7:
        WifiEnabler r1 = this.mWifiSwitchEnabler;
        if (r1 == null) goto L10;
        r1.pause();
    L10:
        unregisterReceiver(this.mReceiver);
        this.mScanner.pause();
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
        this.retryDialog.dismiss();
        this.retryDialog = null;
        goto L7
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_STOP);
        super.onStop();
        unregisterNetworkCallback();
        unregisterWifiRiskReceiver();
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

    protected void showCellFailureDialog() {
        ((OAlertDialog) new OAlertDialogBuilder(this._mActivity).title(R.string.provision_cell_failed_title).message(R.string.provision_cell_failed_tips).verticalButton().positiveButton(R.string.provision_cell_know, new AnonymousClass18(this)).cancelable(false).build()).show();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r5, int r6, Intent r7) {
        super.onActivityResult(r5, r6, r7);
        OLog.e(TAG, "onActivityResult: " + r5 + HanziToPinyin.Token.SEPARATOR + r6);
        this.mActivateRequested = false;
        if (r5 != ProvisionConstants.REQ_ACTIVATE) goto L21;
        if (r6 != RESULT_OK) goto L10;
        if ((getActivity() instanceof WifiPickerActivity2) == false) goto L30;
        ((WifiPickerActivity2) getActivity()).setActivated();
        return;
    L30:
        return;
    L10:
        if (r6 != RESULT_CANCELED) goto L32;
        OLog.e(TAG, "onActivityResult RESULT_CANCELED");
        if ((getActivity() instanceof WifiPickerActivity2) == true) goto L14;
    L17:
        this.mIsActivateFailed = true;
        ensureContentVisibleIfNeeded();
        if (this.mIsCell == false) goto L33;
        this.mIsCellFailed = true;
        showCellFailureDialog();
        return;
    L33:
        return;
    L14:
        if (((WifiPickerActivity2) getActivity()).isActivated() == true) goto L17;
        OLog.i(TAG, "onActivityResult isActivated, return");
        return;
    L32:
        return;
    L21:
        if (r5 == 1001) goto L23;
        return;
    L23:
        if (r6 != RESULT_OK) goto L36;
        String r8 = r7.getStringExtra(ScannerIntentResult_CONTENTS);
        OLog.d(TAG, "scan result: " + r8 + ", format: " + r7.getStringExtra(ScannerIntentResult_BARCODE_FORMAT));
        WifiConfigManager r9 = new WifiConfigManager((WifiManager) this.mContext.getSystemService("wifi"));
        WifiParsedResult r4 = new WifiResultParser().parse(r8);
        if (r4 != null) goto L28;
        OLog.d(TAG, "wifi result is empty!");
        return;
    L28:
        r9.execute(new WifiParsedResult[]{r4});
        return;
    }

    private int dpToPx(int r1) {
        return Math.round(getResources().getDisplayMetrics().density * r1);
    }

    private boolean shouldHideContentForAutoNext() {
        if (isActivateMode() == true) goto L6;
        return false;
    L6:
        if (this.mIsFirstActivate == true) goto L8;
        return false;
    L8:
        if (this.mIsFirstFrpActivate == true) goto L10;
        return false;
    L10:
        if (this.mIsActivateFailed == true) goto L31;
        ConnectivityManager r3 = (ConnectivityManager) getSystemService("connectivity");
        if (r3 != null) goto L15;
        return false;
    L15:
        Network r0 = r3.getActiveNetwork();
        if (r0 != null) goto L18;
        return false;
    L18:
        NetworkCapabilities r4 = r3.getNetworkCapabilities(r0);
        if (r4 != null) goto L22;
        return false;
    L22:
        if (r4.hasTransport(1) == true) goto L24;
        return false;
    L24:
        if (r4.hasCapability(16) == true) goto L26;
        return false;
    L26:
        return true;
    L31:
        return false;
    }

    private void ensureContentVisibleIfNeeded() {
        if (isAdded() == true) goto L5;
        return;
    L5:
        if (this.mRootView != null) goto L8;
        return;
    L8:
        if (this.mHideContentForAutoNext == true) goto L10;
        return;
    L10:
        if (shouldHideContentForAutoNext() == true) goto L15;
        this.mRootView.setVisibility(0);
        this.mHideContentForAutoNext = false;
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_wifi_WifiSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(WifiSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wifi_WifiSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_WifiSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(WifiSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_wifi_WifiSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_WifiSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(WifiSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wifi_WifiSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
