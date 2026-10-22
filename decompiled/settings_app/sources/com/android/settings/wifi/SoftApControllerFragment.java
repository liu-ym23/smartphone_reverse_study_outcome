package com.android.settings.wifi;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiDevice;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerExecutor;
import android.os.Message;
import android.os.SystemClock;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import androidx.preference.PreferenceViewHolder;
import androidx.recyclerview.widget.RecyclerView;
import com.GlobalProxyLancet;
import com.android.settings.R;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.android.settings.SettingsPreferenceFragment23;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.android.settings.utils.UIUtils;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.privacy.GrantUtil;
import com.ttnet.org.chromium.base.TimeUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class SoftApControllerFragment extends SettingsPreferenceFragment23 {
    private static final boolean DEBUG = true;
    private static final String TAG = "SoftApControllerFragment";
    private static final int UPDATE_DATA_USAGE = 1;
    private static final int UPDATE_DATA_USAGE_INTERVAL_MS = 5000;
    private static final int UPDATE_WIFIDEVICE_STATUS = 0;
    private static final int UPDATE_WIFIDEVICE_STATUS_INTERVAL_MS = 1000;
    private WifiDevicePreference dataUsagePref;
    private AccessibilityManager mAccessibilityManager;
    private BroadcastReceiver mBroadcastReceiver;
    private int mConnectedDevicesCount;
    private ConnectivityManager mConnectivityManager;
    private Context mContext;
    private boolean mDataEnabled;
    private TextView mEmptyView;
    private Handler mHandler;
    private boolean mIsAccessibilityEnable;
    private ArrayList<WifiDevicePreference> mPreferences;
    private WifiManager.SoftApCallback mSoftApCallback;
    private Updater mUpdater;
    private WifiManager mWifiManager;
    private SimStateReceiver receiver;
    private int wifiApState;

    public class SimStateReceiver extends BroadcastReceiver {
        final /* synthetic */ SoftApControllerFragment this$0;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            com_android_settings_wifi_SoftApControllerFragment$SimStateReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
        }

        public SimStateReceiver(SoftApControllerFragment r1) {
            this.this$0 = r1;
        }

        public void com_android_settings_wifi_SoftApControllerFragment$SimStateReceiver__onReceive$___twin___(Context r3, Intent r4) {
            if (WifiApService.TETHER_CONNECT_STATE_CHANGED.equals(r4.getAction()) == false) goto L8;
            int r5 = r4.getIntExtra("connected_devices_count", 0);
            if (((WifiManager) r3.getSystemService("wifi")) == null) goto L9;
            SoftApControllerFragment.access$102(this.this$0, r5);
            SoftApControllerFragment.access$400(this.this$0).clear();
            this.this$0.getPreferenceScreen().removeAll();
            SoftApControllerFragment r2 = this.this$0;
            SoftApControllerFragment.access$500(r2, r2.getActivity());
            return;
        L9:
            return;
        }

        @Insert("onReceive")
        public static void com_android_settings_wifi_SoftApControllerFragment$SimStateReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(SimStateReceiver r7, Context r8, Intent r9) {
            Intrinsics.checkNotNullParameter(r8, "context");
            String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
            SimStateReceiver r1 = r7;
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
            r7.com_android_settings_wifi_SoftApControllerFragment$SimStateReceiver__onReceive$___twin___(r8, r9);
            return;
        L13:
            GrantUtil r11 = GrantUtil.INSTANCE;
            Application r12 = SettingsApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
            if (r11.isSetupCompelete(r12) == true) goto L16;
            OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
            r7.com_android_settings_wifi_SoftApControllerFragment$SimStateReceiver__onReceive$___twin___(r8, r9);
            return;
        L16:
            String r13 = r3;
            if (r13 != null) goto L19;
        L22:
            boolean r14 = true;
        L23:
            if (r14 == false) goto L26;
            OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
            r7.com_android_settings_wifi_SoftApControllerFragment$SimStateReceiver__onReceive$___twin___(r8, r9);
            return;
        L26:
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
            if (r4 == true) goto L30;
            OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
            return;
        L30:
            GrantUtil.INSTANCE.applicationInit();
            r7.com_android_settings_wifi_SoftApControllerFragment$SimStateReceiver__onReceive$___twin___(r8, r9);
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

    private class Updater extends Handler {
        final /* synthetic */ SoftApControllerFragment this$0;

        private Updater(SoftApControllerFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ Updater(SoftApControllerFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        void resume() {
            if (hasMessages(0) == true) goto L6;
            sendEmptyMessage(0);
        L6:
            if (hasMessages(1) == true) goto L9;
            sendEmptyMessage(1);
            return;
        }

        @Override // android.os.Handler
        public void handleMessage(Message r4) {
            int r5 = r4.what;
            removeMessages(r5);
            if (r5 != 0) goto L9;
            if (SoftApControllerFragment.access$700(this.this$0) == false) goto L7;
            return;
        L7:
            SoftApControllerFragment.access$800(this.this$0);
            sendEmptyMessageDelayed(0, 1000);
            return;
        L9:
            if (r5 != 1) goto L13;
            SoftApControllerFragment.access$300(this.this$0);
            sendEmptyMessageDelayed(1, 5000);
            return;
        }
    }

    class WifiDevicePreference extends Preference {
        protected static final int REFRESH_BACKGROUND = 1;
        private int mBackgroundId;
        private OCardListItem mItemContainer;
        private int mState;
        private WifiDevice mWifiDevice;
        final /* synthetic */ SoftApControllerFragment this$0;

        WifiDevicePreference(SoftApControllerFragment r1, Context r2, WifiDevice r3) {
            this.this$0 = r1;
            super(r2);
            this.mState = -1;
            this.mBackgroundId = 2;
            setPersistent(false);
            setLayoutResource(R.layout.softap_controller_fragment);
            this.mWifiDevice = r3;
            update();
        }

        void setBackgroundId(int r1) {
            this.mBackgroundId = r1;
        }

        WifiDevice getWifiDevice() {
            return this.mWifiDevice;
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof WifiDevicePreference) == true) goto L6;
            return false;
        L6:
            String r3 = ((WifiDevicePreference) r2).getWifiDevice().deviceAddress;
            return this.mWifiDevice.deviceAddress.equals(r3);
        }

        void update(int r1) {
            this.mState = r1;
            update();
        }

        void update(WifiDevice r1) {
            this.mWifiDevice = r1;
            update();
        }

        @Override // androidx.preference.Preference
        public void setSummary(CharSequence r2) {
            OCardListItem r0 = this.mItemContainer;
            if (r0 == null) goto L6;
            r0.setSubTitle(r2);
            this.mItemContainer.showSubTitle(true);
            return;
        }

        void update() {
            setTitle(this.mWifiDevice.deviceName);
            setSummary(SoftApControllerFragment.access$600(this.this$0, this.mWifiDevice.deviceState, this.mWifiDevice));
            OCardListItem r0 = this.mItemContainer;
            if (r0 == null) goto L6;
            r0.setTitle(this.mWifiDevice.deviceName);
            this.mItemContainer.setSubTitle(SoftApControllerFragment.access$600(this.this$0, this.mWifiDevice.deviceState, this.mWifiDevice));
            this.mItemContainer.showSubTitle(true);
            return;
        }

        void updateSummary() {
            setSummary(SoftApControllerFragment.access$600(this.this$0, this.mWifiDevice.deviceState, this.mWifiDevice));
        }

        @Override // androidx.preference.Preference
        public void onBindViewHolder(PreferenceViewHolder r6) {
            super.onBindViewHolder(r6);
            r6.itemView.setClickable(false);
            OCardListItem r0 = (OCardListItem) NullSafe.nonNull(r6.findViewById(R.id.list_item_container));
            this.mItemContainer = r0;
            r0.showTailIcon(false);
            int r1 = this.mBackgroundId;
            if (r1 == (-1)) goto L9;
            this.mItemContainer.setCardPosition(r1);
            View r2 = r6.findViewById(R.id.layout_gap_top);
            View r7 = r6.findViewById(R.id.layout_gap_bottom);
            if (r2 == null) goto L7;
            r2.setVisibility(8);
        L7:
            if (r7 == null) goto L10;
            r7.setVisibility(8);
        L10:
            update();
            SoftApControllerFragment.access$300(this.this$0);
            return;
        L9:
            this.mItemContainer.setCardPosition(0);
            r6.findViewById(R.id.layout_gap_top).setVisibility(0);
            r6.findViewById(R.id.layout_gap_bottom).setVisibility(0);
            goto L10
        }
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_wifi_SoftApControllerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_wifi_SoftApControllerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public SoftApControllerFragment() {
        this.mPreferences = new ArrayList();
        this.mDataEnabled = false;
        this.mAccessibilityManager = null;
        this.mIsAccessibilityEnable = false;
        this.mHandler = new Handler();
        this.mSoftApCallback = new AnonymousClass1(this);
        this.mBroadcastReceiver = new AnonymousClass2(this);
    }

    static /* synthetic */ int access$102(SoftApControllerFragment r0, int r1) {
        r0.mConnectedDevicesCount = r1;
        return r1;
    }

    static /* synthetic */ boolean access$202(SoftApControllerFragment r0, boolean r1) {
        r0.mDataEnabled = r1;
        return r1;
    }

    static /* synthetic */ void access$300(SoftApControllerFragment r0) {
        r0.setDataUsageSummary();
    }

    static /* synthetic */ ArrayList access$400(SoftApControllerFragment r0) {
        return r0.mPreferences;
    }

    static /* synthetic */ void access$500(SoftApControllerFragment r0, Context r1) {
        r0.constructWifiDevicePreference(r1);
    }

    static /* synthetic */ String access$600(SoftApControllerFragment r0, int r1, WifiDevice r2) {
        return r0.wifiTetherStateToString(r1, r2);
    }

    static /* synthetic */ boolean access$700(SoftApControllerFragment r0) {
        return r0.mIsAccessibilityEnable;
    }

    static /* synthetic */ void access$800(SoftApControllerFragment r0) {
        r0.updateWifiDeviceSummary();
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r6) {
        super.onActivityCreated(r6);
        this.mContext = getActivity();
        this.mConnectivityManager = (ConnectivityManager) getSystemService("connectivity");
        WifiManager r7 = (WifiManager) getSystemService("wifi");
        this.mWifiManager = r7;
        r7.registerSoftApCallback(new HandlerExecutor(this.mHandler), this.mSoftApCallback);
        this.mAccessibilityManager = (AccessibilityManager) getSystemService("accessibility");
        RecyclerView r8 = getListView();
        r8.setOverScrollMode(0);
        r8.setClipChildren(false);
        TextView r1 = (TextView) getView().findViewById(android.R.id.empty);
        this.mEmptyView = r1;
        r1.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.mEmptyView.setText(R.string.wifi_devices_list_empty_tips);
        this.mEmptyView.setTextSize(20.0f);
        this.mEmptyView.setTextColor(getResources().getColor(R.color.oui_text_3));
        this.mEmptyView.setGravity(17);
        DisplayMetrics r2 = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(r2);
        this.mEmptyView.setHeight(r2.heightPixels);
        r8.setClipChildren(false);
        r8.setClipToPadding(false);
        UIUtils.updatePadding(r8, -1, getResources().getDimensionPixelSize(R.dimen.vpn_first_item_card_gap), -1, getResources().getDimensionPixelSize(R.dimen.settings_container_bottom_padding));
        updateEmptyViewVisibility();
    }

    public void com_android_settings_wifi_SoftApControllerFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        addPreferencesFromResource(R.xml.softap_controller_info);
        registerStickyReceiver();
        registerTetherReceiver();
    }

    private void registerTetherReceiver() {
        IntentFilter r0 = new IntentFilter();
        r0.addAction(WifiApService.TETHER_CONNECT_STATE_CHANGED);
        this.receiver = new SimStateReceiver(this);
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(getActivity(), this.receiver, r0, 2);
    }

    public void com_android_settings_wifi_SoftApControllerFragment__onResume$___twin___() {
        super.onResume();
        this.mIsAccessibilityEnable = this.mAccessibilityManager.isEnabled();
        this.mPreferences.clear();
        getPreferenceScreen().removeAll();
        getPreferenceScreen().setOrderingAsAdded(true);
        init();
        constructWifiDevicePreference(this.mContext);
        if (this.mUpdater != null) goto L5;
        this.mUpdater = new Updater(this, null);
    L5:
        this.mUpdater.resume();
    }

    private void init() {
        this.wifiApState = this.mWifiManager.getWifiApState();
        NetworkInfo r0 = this.mConnectivityManager.getActiveNetworkInfo();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isConnected() == true) goto L7;
        return;
    L7:
        if (r0.getType() != 0) goto L9;
    L12:
        this.mDataEnabled = true;
        return;
    L9:
        if (r0.getType() == 5) goto L12;
        if (r0.getType() == 1) goto L12;
    }

    private void constructWifiDevicePreference(Context r11) {
        ArrayList<WifiDevicePreference> r1 = new ArrayList();
        ArrayList<WifiDevicePreference> r2 = new ArrayList();
        if (this.dataUsagePref != null) goto L37;
        WifiDevice r3 = new WifiDevice();
        r3.deviceName = r11.getString(R.string.wifi_tether_total_connected_stations_text);
        WifiDevicePreference r4 = new WifiDevicePreference(this, r11, r3);
        this.dataUsagePref = r4;
        r4.setBackgroundId(-1);
    L37:
        List r5 = this.mWifiManager.getConfiguredStations();     // Catch: Exception -> L26
        if (r5 == null) goto L11;
        int r6 = 0;
    L9:
        if (r6 >= r5.size()) goto L11;
        WifiDevice r7 = (WifiDevice) r5.get(r6);     // Catch: Exception -> L26
        OLog.d(TAG, "deviceName = " + r7.deviceName + ",state = " + r7.deviceState);     // Catch: Exception -> L26
        r1.add(new WifiDevicePreference(this, r11, r7));     // Catch: Exception -> L26
        r6 = r6 + 1;     // Catch: Exception -> L26
    L11:
        List r8 = this.mWifiManager.getConnectedStations();     // Catch: Exception -> L26
        if (r8 == null) goto L28;
        Iterator r9 = r8.iterator();     // Catch: Exception -> L26
    L14:
        if (r9.hasNext() == false) goto L28;
        WifiDevice r10 = (WifiDevice) r9.next();     // Catch: Exception -> L26
        OLog.d(TAG, "result.deviceName = " + r10.deviceName + ",result.state = " + r10.deviceState);     // Catch: Exception -> L26
        Iterator<WifiDevicePreference> r12 = r1.iterator();     // Catch: Exception -> L26
    L18:
        if (r12.hasNext() == false) goto L22;
        WifiDevicePreference r13 = r12.next();     // Catch: Exception -> L26
        if (r13.getWifiDevice().deviceAddress.equals(r10.deviceAddress) == false) goto L18;
        r13.update(r10);     // Catch: Exception -> L26
        boolean r14 = true;
    L23:
        if (r14 == true) goto L14;
        r1.add(new WifiDevicePreference(this, r11, r10));     // Catch: Exception -> L26
        goto L14
    L22:
        r14 = false;
    L28:
        Collections.sort(r1);
        if (r1.size() <= 0) goto L31;
        r2.add(this.dataUsagePref);
        r2.addAll(r1);
    L31:
        this.mPreferences = r2;
        setWifiDevicePreferenceBackground(r1);
        Iterator<WifiDevicePreference> r15 = this.mPreferences.iterator();
    L33:
        if (r15.hasNext() == false) goto L35;
        getPreferenceScreen().addPreference(r15.next());
        goto L33
    L35:
        updateEmptyViewVisibility();
        return;
    L26:
        e = move-exception;
        OLog.e(TAG, "Exception : " + e);
        goto L28
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Updater r1 = this.mUpdater;
        if (r1 == null) goto L6;
        r1.removeCallbacksAndMessages(null);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        unregisterStickyReceiver();
        this.mWifiManager.unregisterSoftApCallback(this.mSoftApCallback);
        unregisterReceiver(this.receiver);
    }

    private void registerStickyReceiver() {
        IntentFilter r0 = new IntentFilter("android.net.wifi.WIFI_AP_STATE_CHANGED");
        r0.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(getActivity(), this.mBroadcastReceiver, r0, 2);
    }

    private void unregisterStickyReceiver() {
        unregisterReceiver(this.mBroadcastReceiver);
    }

    private void setWifiDevicePreferenceBackground(ArrayList<WifiDevicePreference> r5) {
        int r4 = r5.size();
        WifiDevicePreference r0 = null;
        WifiDevicePreference r2 = null;
        int r3 = 0;
    L3:
        if (r3 >= r4) goto L8;
        r0 = r5.get(r3);
        if (r2 != null) goto L7;
        r2 = r0;
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        if (r0 == null) goto L12;
        if (r0 != r2) goto L12;
        r0.setBackgroundId(0);
        return;
    L12:
        if (r2 == null) goto L14;
        r2.setBackgroundId(1);
    L14:
        if (r0 == null) goto L20;
        r0.setBackgroundId(3);
        return;
    }

    private void updateEmptyViewVisibility() {
        TextView r0 = this.mEmptyView;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mPreferences.isEmpty() == false) goto L7;
        int r1 = 0;
    L8:
        r0.setVisibility(r1);
        return;
    L7:
        r1 = 8;
        goto L8
    }

    private String wifiTetherStateToString(int r8, WifiDevice r9) {
        Context r0 = getContext();
        if (r8 == 0) goto L22;
        if (r8 != 1) goto L7;
        String r10 = r0.getString(R.string.wifi_tether_status_connected);
        if (r9.deviceSetupTime == (-1)) goto L17;
        if (this.mIsAccessibilityEnable == true) goto L17;
        r10 = String.format(r10, new Object[]{formatTimeShown((SystemClock.elapsedRealtime() - r9.deviceSetupTime) / 1000)});
    L17:
        if (this.mIsAccessibilityEnable == false) goto L25;
        if (r10 == null) goto L25;
        return r10.split(":")[0];
    L25:
        return r10;
    L7:
        if (r8 == 2) goto L10;
        return null;
    L10:
        return "blacklist";
    L22:
        return r0.getString(R.string.wifi_tether_status_disconnected);
    }

    private String formatTimeShown(long r9) {
        StringBuilder r8 = new StringBuilder();
        long r0 = r9 / TimeUtils.SECONDS_PER_HOUR;
        long r4 = (r9 / 60) % 60;
        long r10 = r9 % 60;
        if (r0 < 10) goto L5;
        Object r1 = Long.valueOf(r0);
    L6:
        StringBuilder r2 = r8.append(r1).append(":");
        if (r4 < 10) goto L9;
        Object r5 = Long.valueOf(r4);
    L10:
        StringBuilder r3 = r2.append(r5).append(":");
        if (r10 < 10) goto L13;
        Object r11 = Long.valueOf(r10);
    L14:
        r3.append(r11);
        return r8.toString();
    L13:
        r11 = "0" + r10;
        goto L14
    L9:
        r5 = "0" + r4;
        goto L10
    L5:
        r1 = "0" + r0;
        goto L6
    }

    private void updateWifiDeviceSummary() {
        PreferenceScreen r0 = getPreferenceScreen();
        int r1 = r0.getPreferenceCount();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        WifiDevicePreference r3 = (WifiDevicePreference) r0.getPreference(r2);
        if (r3.equals(this.dataUsagePref) == true) goto L7;
        WifiDevice r4 = r3.getWifiDevice();
        r3.setSummary(wifiTetherStateToString(r4.deviceState, r4));
    L7:
        r2 = r2 + 1;
        goto L3
    }

    private void updateDataUsageView(long r4) {
        WifiDevicePreference r0 = this.dataUsagePref;
        if (r0 == null) goto L6;
        r0.setSummary(String.format(getContext().getString(R.string.wifi_tether_data_usage), new Object[]{Formatter.formatFileSize(getContext(), r4)}));
        return;
    }

    private void setDataUsageSummary() {
        if (this.wifiApState != 13) goto L16;
        long r0 = Utils.getStartUpDataUsage(this.mContext);
        if (this.mDataEnabled == true) goto L7;
    L11:
        long r2 = Utils.getLastDataUsage(this.mContext);
        if (r2 < r0) goto L14;
        r2 = r2 - r0;
    L14:
        updateDataUsageView(r2);
        return;
    L7:
        if (this.mConnectedDevicesCount == 0) goto L11;
        long r3 = Utils.getDataUsage(this.mContext);
        if (r3 < r0) goto L17;
        updateDataUsageView(r3 - r0);
        return;
    L17:
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_wifi_SoftApControllerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(SoftApControllerFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wifi_SoftApControllerFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_SoftApControllerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(SoftApControllerFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_wifi_SoftApControllerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_SoftApControllerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(SoftApControllerFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wifi_SoftApControllerFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
