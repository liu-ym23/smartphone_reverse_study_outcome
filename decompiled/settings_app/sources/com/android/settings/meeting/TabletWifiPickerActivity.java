package com.android.settings.meeting;

import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.app.SmtPCUtils;
import android.app.TaskStackListener;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.BoostFramework;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.android.settings.AdaptConstants;
import com.android.settings.AdaptWifi;
import com.android.settings.AdaptWifiConfig;
import com.android.settings.MultiSDKAdapter;
import com.android.settings.R;
import com.android.settings.SettingsAdapter;
import com.android.settings.ToastUtils;
import com.android.settings.Utils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.wifi.AccessPoint;
import com.android.settings.wifi.AccessPointInfo;
import com.android.settings.wifi.WlanRiskInfo;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import com.obric.privacy.LifeHookActivity2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class TabletWifiPickerActivity extends LifeHookActivity2 implements AdapterView.OnItemClickListener, View.OnClickListener {
    private static final int RSSI_CODE = -200;
    private static final String TAG = "TabletWifiPickerActivity";
    private static final int WIFI_RESCAN_INTERVAL_MS = 6000;
    private boolean mActivateRequested;
    private View mBottomLine;
    private Button mBtnBack;
    private WifiManager.ActionListener mConnectListener;
    private String mConnectSSID;
    private final AtomicBoolean mConnected;
    private Context mContext;
    private AccessPointInfo mCurrentAccessPoint;
    private IntentFilter mFilter;
    private long mLastConnectAccessPointTs;
    private WifiInfo mLastInfo;
    private NetworkInfo.DetailedState mLastState;
    private FrameLayout mLayoutParent;
    private ListView mListView;
    private int[] mPerParamVal;
    private BoostFramework mPerf;
    private final int mPerfLockDuration;
    private BroadcastReceiver mReceiver;
    private Scanner mScanner;
    private AccessPointInfo mSelectedAccessPoint;
    private TaskStackListener mTaskStackListener;
    private TextView mTitle;
    private View mTopLine;
    private WifiListAdapter mWifiListAdapter;
    private WifiManager mWifiManager;
    private AlertDialog retryDilog;

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
        private TabletWifiPickerActivity mTabletWifiPickerActivity;

        Scanner(TabletWifiPickerActivity r2) {
            this.mRetry = 0;
            this.mTabletWifiPickerActivity = r2;
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
        public void handleMessage(Message r4) {
            if (TabletWifiPickerActivity.access$700(this.mTabletWifiPickerActivity).startScan() == false) goto L5;
            this.mRetry = 0;
        L11:
            sendEmptyMessageDelayed(0, 6000);
            return;
        L5:
            int r5 = this.mRetry + 1;
            this.mRetry = r5;
            if (r5 < 3) goto L11;
            this.mRetry = 0;
            TabletWifiPickerActivity r3 = this.mTabletWifiPickerActivity;
            if (r3 == null) goto L13;
            ToastUtils.show(r3, R.string.wifi_fail_to_scan);
            return;
        }
    }

    class UpdateAccessPointsTask extends AsyncTask<Void, Void, ArrayList<AccessPointInfo>> {
        final /* synthetic */ TabletWifiPickerActivity this$0;

        UpdateAccessPointsTask(TabletWifiPickerActivity r1) {
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
            if (TabletWifiPickerActivity.access$700(this.this$0).getWifiState() == 3) goto L5;
            return null;
        L5:
            if (TabletWifiPickerActivity.access$900(this.this$0) == null) goto L7;
            TabletWifiPickerActivity.access$900(this.this$0).perfLockAcquire(2000, TabletWifiPickerActivity.access$1000(this.this$0));
        L7:
            TabletWifiPickerActivity r4 = this.this$0;
            return TabletWifiPickerActivity.access$1300(r4, TabletWifiPickerActivity.access$700(r4), TabletWifiPickerActivity.access$1100(this.this$0), TabletWifiPickerActivity.access$1200(this.this$0));
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(ArrayList<AccessPointInfo> r1) {
            TabletWifiPickerActivity.access$1400(this.this$0, r1);
        }
    }

    private class WifiListAdapter extends SettingsAdapter {
        ArrayList<AccessPointInfo> accessPointsList;
        final /* synthetic */ TabletWifiPickerActivity this$0;

        private WifiListAdapter(TabletWifiPickerActivity r1) {
            this.this$0 = r1;
        }

        /* synthetic */ WifiListAdapter(TabletWifiPickerActivity r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int r1) {
            return getItem(r1);
        }

        public ArrayList<AccessPointInfo> getData() {
            return this.accessPointsList;
        }

        public void updateData(ArrayList<AccessPointInfo> r1) {
            this.accessPointsList = r1;
            notifyDataSetChanged();
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public int getCount() {
            ArrayList<AccessPointInfo> r0 = this.accessPointsList;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.size();
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public AccessPointInfo getItem(int r1) {
            ArrayList<AccessPointInfo> r0 = this.accessPointsList;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.get(r1);
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public View getView(int r1, View r2, ViewGroup r3) {
            if (r2 != null) goto L4;
            TabletAccessPointView r4 = new TabletAccessPointView(TabletWifiPickerActivity.access$1500(this.this$0));
        L5:
            r4.bindData(this.accessPointsList.get(r1));
            r4.setBackgroundRes(getWifiItemBgRes(r1));
            return r4;
        L4:
            r4 = (TabletAccessPointView) r2;
            goto L5
        }
    }

    public void com_android_settings_meeting_TabletWifiPickerActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_meeting_TabletWifiPickerActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_meeting_TabletWifiPickerActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_meeting_TabletWifiPickerActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // android.app.Activity
    public void finish() {
        com_android_settings_meeting_TabletWifiPickerActivity_com_obric_hook_lancet_PrivacyHookActivity2_finish(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_meeting_TabletWifiPickerActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_settings_meeting_TabletWifiPickerActivity_com_obric_hook_lancet_PrivacyHookActivity2_onDestroy(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_meeting_TabletWifiPickerActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_meeting_TabletWifiPickerActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_meeting_TabletWifiPickerActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_meeting_TabletWifiPickerActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public TabletWifiPickerActivity() {
        this.mPerf = null;
        this.mPerfLockDuration = 2000;
        this.mConnectSSID = null;
        this.mActivateRequested = false;
        this.mConnected = new AtomicBoolean(false);
        this.mTaskStackListener = new AnonymousClass4(this);
    }

    static /* synthetic */ View access$100(TabletWifiPickerActivity r0) {
        return r0.mTopLine;
    }

    static /* synthetic */ int[] access$1000(TabletWifiPickerActivity r0) {
        return r0.mPerParamVal;
    }

    static /* synthetic */ WifiInfo access$1100(TabletWifiPickerActivity r0) {
        return r0.mLastInfo;
    }

    static /* synthetic */ NetworkInfo.DetailedState access$1200(TabletWifiPickerActivity r0) {
        return r0.mLastState;
    }

    static /* synthetic */ ArrayList access$1300(TabletWifiPickerActivity r0, WifiManager r1, WifiInfo r2, NetworkInfo.DetailedState r3) {
        return r0.constructAccessPoints(r1, r2, r3);
    }

    static /* synthetic */ void access$1400(TabletWifiPickerActivity r0, ArrayList r1) {
        r0.updateAccessPointsUI(r1);
    }

    static /* synthetic */ Context access$1500(TabletWifiPickerActivity r0) {
        return r0.mContext;
    }

    static /* synthetic */ void access$200(TabletWifiPickerActivity r0, Intent r1) {
        r0.handleEvent(r1);
    }

    static /* synthetic */ TextView access$300(TabletWifiPickerActivity r0) {
        return r0.mTitle;
    }

    static /* synthetic */ ListView access$400(TabletWifiPickerActivity r0) {
        return r0.mListView;
    }

    static /* synthetic */ Button access$500(TabletWifiPickerActivity r0) {
        return r0.mBtnBack;
    }

    static /* synthetic */ View access$600(TabletWifiPickerActivity r0) {
        return r0.mBottomLine;
    }

    static /* synthetic */ WifiManager access$700(TabletWifiPickerActivity r0) {
        return r0.mWifiManager;
    }

    static /* synthetic */ BoostFramework access$900(TabletWifiPickerActivity r0) {
        return r0.mPerf;
    }

    public void com_android_settings_meeting_TabletWifiPickerActivity__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        Utils.setTranslucentStatusAndNavigation(getApplicationContext(), getWindow());
        setContentView(R.layout.revone_wifi_setting_layout);
        initViews();
        initEvent();
    }

    private void initViews() {
        this.mContext = this;
        this.mLayoutParent = (FrameLayout) findViewById(R.id.layout_parent);
        this.mTitle = (TextView) findViewById(R.id.view_title);
        this.mListView = (ListView) findViewById(R.id.listView);
        this.mBtnBack = (Button) findViewById(R.id.btn_back);
        this.mTopLine = findViewById(R.id.top_line);
        this.mBottomLine = findViewById(R.id.bottom_line);
        this.mBtnBack.setOnClickListener(this);
        this.mListView.setOnItemClickListener(this);
        WifiListAdapter r0 = new WifiListAdapter(this, null);
        this.mWifiListAdapter = r0;
        this.mListView.setAdapter(r0);
        this.mListView.setOnScrollListener(new AnonymousClass1(this));
    }

    private void initEvent() {
        this.mWifiManager = (WifiManager) getSystemService("wifi");
        IntentFilter r0 = new IntentFilter();
        this.mFilter = r0;
        r0.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        this.mFilter.addAction("android.net.wifi.SCAN_RESULTS");
        this.mFilter.addAction("android.net.wifi.NETWORK_IDS_CHANGED");
        this.mFilter.addAction("android.net.wifi.STATE_CHANGE");
        this.mFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
        this.mFilter.addAction("android.net.wifi.CONFIGURED_NETWORKS_CHANGE");
        this.mFilter.addAction(AdaptConstants.LINK_CONFIGURATION_CHANGED_ACTION);
        this.mFilter.addAction("android.net.wifi.RSSI_CHANGED");
        this.mReceiver = new AnonymousClass2(this);
        this.mScanner = new Scanner(this);
        this.mPerf = new BoostFramework();
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, this.mReceiver, this.mFilter);
        this.mConnectListener = new AnonymousClass3(this);
        registerTaskListener();
    }

    private void registerTaskListener() {
        SmtPCUtils.registerSmtTaskStackListener(this.mTaskStackListener);
    }

    private void unRegisterTaskStackListener() {
        SmtPCUtils.unRegisterSmtTaskStackListener(this.mTaskStackListener);
    }

    private void handleEvent(Intent r4) {
        String r0 = r4.getAction();
        if ("android.net.wifi.WIFI_STATE_CHANGED".equals(r0) == false) goto L6;
        updateWifiState(r4.getIntExtra("wifi_state", 4));
        return;
    L6:
        if ("android.net.wifi.SCAN_RESULTS".equals(r0) == false) goto L8;
    L50:
        updateAccessPoints();
        return;
    L8:
        if ("android.net.wifi.CONFIGURED_NETWORKS_CHANGE".equals(r0) == true) goto L50;
        if (AdaptConstants.LINK_CONFIGURATION_CHANGED_ACTION.equals(r0) == true) goto L50;
        if ("android.net.wifi.supplicant.STATE_CHANGE".equals(r0) == false) goto L34;
        if (r4.hasExtra("supplicantError") == false) goto L22;
        WifiConfiguration r1 = (WifiConfiguration) r4.getParcelableExtra("extra_failedAuthConfig");
        if (isFinishing() == false) goto L19;
    L21:
        this.mScanner.forceScan();
        goto L22
    L19:
        if (MultiSDKAdapter.isWrongPSWDReason(r4) == false) goto L21;
        showRetryDialog(r1);
    L22:
        SupplicantState r5 = (SupplicantState) r4.getParcelableExtra("newState");
        if (r5 == null) goto L30;
        if (this.mConnected.get() == true) goto L30;
        if (AdaptWifi.isHandshakeState(r5) == false) goto L30;
        updateConnectionState(WifiInfo.getDetailedStateOf(r5));
        return;
    L30:
        if (r5 != SupplicantState.DISCONNECTED) goto L32;
        updateConnectionState(WifiInfo.getDetailedStateOf(r5));
        return;
    L32:
        updateConnectionState(null);
        return;
    L34:
        if ("android.net.wifi.STATE_CHANGE".equals(r0) == false) goto L48;
        NetworkInfo r2 = (NetworkInfo) r4.getParcelableExtra("networkInfo");
        this.mConnected.set(r2.isConnected());
        if (this.mConnected.get() == false) goto L42;
        AlertDialog r3 = this.retryDilog;
        if (r3 == null) goto L42;
        if (r3.isShowing() == false) goto L42;
        this.retryDilog.dismiss();
    L42:
        updateConnectionState(r2.getDetailedState());
        updateAccessPoints();
        String r6 = r4.getStringExtra(WlanRiskInfo.EXTRA_BSSID);
        if (r6 != null) goto L45;
        return;
    L45:
        if (r6.equals(this.mConnectSSID) == true) goto L57;
        this.mConnectSSID = r6;
        this.mActivateRequested = false;
        return;
    L57:
        return;
    L48:
        if ("android.net.wifi.RSSI_CHANGED".equals(r0) == false) goto L59;
        AccessPoint.updateConnectedAccessPointRssi(r4.getIntExtra("newRssi", -200));
        updateConnectionState(null);
        return;
    }

    private void showRetryDialog(WifiConfiguration r7) {
        updateAccessPointsUI(constructAccessPoints(this.mWifiManager, this.mLastInfo, this.mLastState));
        if (r7 == null) goto L18;
        ArrayList<AccessPointInfo> r1 = this.mWifiListAdapter.getData();
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
        if (r8 == true) goto L18;
        this.mCurrentAccessPoint = this.mSelectedAccessPoint;
    L13:
        r2 = r2 - 1;
    L14:
        r8 = false;
    L18:
        if (this.mCurrentAccessPoint == null) goto L30;
        AlertDialog r9 = this.retryDilog;
        if (r9 != null) goto L22;
    L24:
        AlertDialog r10 = new AlertDialog.Builder(this.mContext).setTitle(R.string.wifi_connection_failure_title).setMessage(R.string.wifi_connection_failure_msg).setCancelable(true).setNegativeButton(R.string.wifi_connection_failure_cancel, null).setPositiveButton(R.string.wifi_connection_failure_ok, new AnonymousClass5(this)).create();
        this.retryDilog = r10;
        r10.show();
        return;
    L22:
        if (r9.isShowing() == false) goto L24;
        return;
    }

    private void updateConnectionState(NetworkInfo.DetailedState r2) {
        if (this.mWifiManager.isWifiEnabled() == true) goto L7;
        this.mScanner.pause();
        return;
    L7:
        if (r2 != NetworkInfo.DetailedState.OBTAINING_IPADDR) goto L9;
        this.mScanner.pause();
    L10:
        this.mLastInfo = this.mWifiManager.getConnectionInfo();
        if (r2 == null) goto L13;
        this.mLastState = r2;
    L13:
        updateAccessPoints();
        return;
    L9:
        this.mScanner.resume();
        goto L10
    }

    private void updateAccessPoints() {
        new UpdateAccessPointsTask(this).execute(new Void[0]);
    }

    private void updateWifiState(int r2) {
        if (r2 != 3) goto L5;
        this.mScanner.resume();
        return;
    L5:
        this.mLastInfo = null;
        this.mLastState = null;
        this.mScanner.pause();
    }

    private ActivityOptions getLaunchOption() {
        ActivityOptions r0 = ActivityOptions.makeCustomAnimation(this.mContext, R.anim.revone_popup_fade_in, 0);
        Rect r1 = new Rect();
        View r7 = getWindow().getDecorView();
        if (r7 == null) goto L5;
        r7.getWindowDisplayFrame(r1);
    L5:
        Rect r8 = SmtPCUtils.getDefaultWindowBounds(true);
        r0.setLaunchBounds(new Rect((r1.left + (r1.width() / 2)) - (r8.width() / 2), (r1.top + (r1.height() / 2)) - (r8.height() / 2), r1.right - ((r1.width() / 2) - (r8.width() / 2)), r1.bottom - ((r1.height() / 2) - (r8.height() / 2))));
        return r0;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
        int r5 = r3 - this.mListView.getHeaderViewsCount();
        if (r5 >= 0) goto L5;
        return;
    L5:
        if (r5 > (this.mWifiListAdapter.getCount() - 1)) goto L43;
        AccessPointInfo r6 = this.mWifiListAdapter.getItem(r5);
        boolean r7 = r6.equalsTo(this.mSelectedAccessPoint);
        this.mSelectedAccessPoint = r6;
        if (r6.security != 0) goto L13;
        if (this.mSelectedAccessPoint.networkId != (-1)) goto L13;
        this.mSelectedAccessPoint.generateOpenNetworkConfig();
        this.mWifiManager.connect(this.mSelectedAccessPoint.getConfig(), this.mConnectListener);
        return;
    L13:
        if (this.mSelectedAccessPoint.networkId == (-1)) goto L28;
        NetworkInfo.DetailedState r8 = this.mSelectedAccessPoint.getState();
        int r9 = this.mSelectedAccessPoint.getLevel();
        if (r8 != null) goto L23;
        if (r9 == (-1)) goto L23;
        if (r7 == false) goto L22;
        if (r7 == true) goto L21;
        return;
    L21:
        if ((System.currentTimeMillis() - this.mLastConnectAccessPointTs) > 2000) goto L22;
        return;
    L22:
        this.mLastConnectAccessPointTs = System.currentTimeMillis();
        this.mWifiManager.connect(this.mSelectedAccessPoint.getConfig(), this.mConnectListener);
        return;
    L23:
        if (r8 != null) goto L25;
    L27:
        Intent r10 = new Intent();
        r10.setClassName(SmtPCUtils.PKG_DESKTOP_SETUPWIZARD, "com.bytedance.table.setupwizard.meeting.TabletModeActivity");
        startActivity(r10, ActivityOptions.makeCustomAnimation(this, 0, 0).toBundle());
        finish();
        return;
    L25:
        if (r8 == NetworkInfo.DetailedState.CONNECTED) goto L27;
        return;
    L28:
        Bundle r11 = new Bundle();
        r11.putBoolean("edit", false);
        r11.putBoolean("text_is_selectable", false);
        if (this.mSelectedAccessPoint == null) goto L32;
        Bundle r12 = new Bundle();
        this.mSelectedAccessPoint.saveWifiState(r12);
        r11.putBundle("access_point", r12);
    L32:
        if (this.mSelectedAccessPoint.security != 2) goto L34;
        Intent r13 = new Intent(this, TabletWifiPasswordActivity.class);
        r13.putExtras(r11);
        startActivity(r13, ActivityOptions.makeCustomAnimation(this, 0, 0).toBundle());
        return;
    L34:
        Intent r14 = new Intent(this, TabletWifiSetupActivity.class);
        r14.addFlags(268435456);
        this.mTitle.setVisibility(8);
        this.mListView.setVisibility(8);
        this.mBtnBack.setVisibility(8);
        this.mTopLine.setVisibility(8);
        this.mBottomLine.setVisibility(8);
        r14.putExtras(r11);
        startActivity(r14, getLaunchOption().toBundle());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ArrayList<AccessPointInfo> constructAccessPoints(WifiManager r10, WifiInfo r11, NetworkInfo.DetailedState r12) {
        ArrayList r0 = new ArrayList();
        ArrayList<AccessPointInfo> r1 = new ArrayList();
        List<ScanResult> r3 = null;
        Multimap r2 = new Multimap(0 == true ? 1 : 0);
        List<WifiConfiguration> r4 = r10.getConfiguredNetworks();     // Catch: RuntimeException -> L5
    L8:
        if (r4 == null) goto L56;
        int r6 = 0;
    L11:
        if (r6 >= r4.size()) goto L56;
        WifiConfiguration r7 = r4.get(r6);
        if (new AdaptWifiConfig(r7).getSelfAdded() == true) goto L15;
    L17:
        AccessPointInfo r8 = new AccessPointInfo(r7);
        if (r11 == null) goto L21;
        if (r12 == null) goto L21;
        r8.update(r11, r12);
    L21:
        r0.add(r8);
        r2.put(r8.ssid, r8);
    L22:
        r6 = r6 + 1;
        goto L11
    L15:
        if (r7.numAssociation != 0) goto L17;
    L56:
        r3 = r10.getScanResults();     // Catch: RuntimeException -> L25
    L27:
        if (r3 == null) goto L47;
        Iterator<ScanResult> r9 = r3.iterator();
    L30:
        if (r9.hasNext() == false) goto L47;
        ScanResult r13 = r9.next();
        if (r13.SSID == null) goto L30;
        if (r13.SSID.length() == 0) goto L30;
        if (r13.capabilities.contains("[IBSS]") == true) goto L30;
        List r14 = r2.getAll(r13.SSID);
        int r15 = 0;
        boolean r5 = false;
    L40:
        if (r15 >= r14.size()) goto L45;
        if (((AccessPointInfo) r14.get(r15)).update(r13) == false) goto L44;
        r5 = true;
    L44:
        r15 = r15 + 1;
        goto L40
    L45:
        if (r5 == true) goto L30;
        AccessPointInfo r16 = new AccessPointInfo(r13);
        r0.add(r16);
        r2.put(r16.ssid, r16);
    L47:
        Iterator r17 = r0.iterator();
    L49:
        if (r17.hasNext() == false) goto L54;
        AccessPointInfo r18 = (AccessPointInfo) r17.next();
        int r19 = r18.getLevel();
        if (r18.networkId == (-1)) goto L53;
        if (r19 == (-1)) goto L49;
    L53:
        r1.add(r18);
        goto L49
    L54:
        Collections.sort(r1);
        return r1;
    L25:
        e = move-exception;
        OLog.e(TAG, "wifiManager.getScanResults(), e:" + e);
    L5:
        e = move-exception;
        OLog.e(TAG, "getConfiguredNetworks exception : " + e);
        r4 = null;
        goto L8
    }

    private void updateAccessPointsUI(ArrayList<AccessPointInfo> r5) {
        if (isFinishing() == false) goto L5;
        return;
    L5:
        OLog.d(TAG, "updateAccessPointsUI----");
        int r0 = this.mWifiManager.getWifiState();
        if (r0 != 0) goto L8;
        this.mWifiListAdapter.updateData(null);
        return;
    L8:
        if (r0 != 1) goto L10;
        AccessPointInfo.updateConnectedAccessPointRssi(-200);
        this.mWifiListAdapter.updateData(null);
        return;
    L10:
        if (r0 != 2) goto L12;
        AccessPointInfo.updateConnectedAccessPointRssi(-200);
        this.mWifiListAdapter.updateData(null);
        return;
    L12:
        if (r0 != 3) goto L22;
        this.mWifiListAdapter.updateData(r5);
        return;
    }

    public void com_android_settings_meeting_TabletWifiPickerActivity__onDestroy$___twin___() {
        super.onDestroy();
        unregisterReceiver(this.mReceiver);
        unRegisterTaskStackListener();
        this.mScanner.pause();
    }

    public void com_android_settings_meeting_TabletWifiPickerActivity__finish$___twin___() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2.getId() != R.id.btn_back) goto L7;
        finish();
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_meeting_TabletWifiPickerActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(TabletWifiPickerActivity r1) {
        com_android_settings_meeting_TabletWifiPickerActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_meeting_TabletWifiPickerActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(TabletWifiPickerActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        TabletWifiPickerActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_meeting_TabletWifiPickerActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_meeting_TabletWifiPickerActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(TabletWifiPickerActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_meeting_TabletWifiPickerActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_meeting_TabletWifiPickerActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(TabletWifiPickerActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_meeting_TabletWifiPickerActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        TabletWifiPickerActivity r5 = r4;
        String r2 = r5.getCallingPackage();
        if (r2 != null) goto L9;
        OLog.e("BaseActivity", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r6 = r5.getReferrer();
        if (r6 == null) goto L9;
        r2 = r6.toString();
    L9:
        OLog.i("TeaEventReportUtil", "callingPkg=" + r2);
        if (r2 != null) goto L12;
        r2 = "null";
    L12:
        AppMetricsUtils.INSTANCE.reportColdStartActivity(r2, r0);
    L13:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }

    @Insert(mayCreateSuper = true, value = "startActivityForResult")
    public static void com_android_settings_meeting_TabletWifiPickerActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(TabletWifiPickerActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_meeting_TabletWifiPickerActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_meeting_TabletWifiPickerActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(TabletWifiPickerActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_meeting_TabletWifiPickerActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_meeting_TabletWifiPickerActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(TabletWifiPickerActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        TabletWifiPickerActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_meeting_TabletWifiPickerActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_meeting_TabletWifiPickerActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(TabletWifiPickerActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_meeting_TabletWifiPickerActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_meeting_TabletWifiPickerActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(TabletWifiPickerActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        TabletWifiPickerActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_meeting_TabletWifiPickerActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_meeting_TabletWifiPickerActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(TabletWifiPickerActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_meeting_TabletWifiPickerActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        TabletWifiPickerActivity r5 = r3;
        String r6 = r5.getCallingPackage();
        if (r6 != null) goto L9;
        OLog.e("AppLifecycle", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r7 = r5.getReferrer();
        if (r7 == null) goto L9;
        r6 = r7.toString();
    L9:
        OLog.i("AppLifecycle", "TeaEventReportUtil callingPkg=" + r6);
        if (r6 != null) goto L12;
        r6 = "null";
    L12:
        AppMetricsUtils r8 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r8.callingPackageEvent(r6, r0, false);
        return;
    }

    @Insert("onStop")
    public static void com_android_settings_meeting_TabletWifiPickerActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(TabletWifiPickerActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        TabletWifiPickerActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_meeting_TabletWifiPickerActivity__onStop$___twin___();
    }

    @Insert("onDestroy")
    public static void com_android_settings_meeting_TabletWifiPickerActivity_com_obric_hook_lancet_PrivacyHookActivity2_onDestroy(TabletWifiPickerActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        TabletWifiPickerActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_meeting_TabletWifiPickerActivity__onDestroy$___twin___();
    }

    @Insert("finish")
    public static void com_android_settings_meeting_TabletWifiPickerActivity_com_obric_hook_lancet_PrivacyHookActivity2_finish(TabletWifiPickerActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        TabletWifiPickerActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.superFinish();
        return;
    L6:
        r3.com_android_settings_meeting_TabletWifiPickerActivity__finish$___twin___();
    }
}
