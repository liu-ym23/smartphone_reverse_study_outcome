package com.android.settings.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemProperties;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.android.settings.R;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import com.obric.privacy.LifeHookActivity2;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes.dex */
public class SortNetworkListActivity extends LifeHookActivity2 {
    private static final int CMD_UPDATE_PRIORITY = 1;
    private static final String TAG = "SortNetworkListActivity";
    private static final String WIFI_MANUAL_SORT_PROP = "persist.wifi.manual.sort";
    private AccessPointAdapter mAdapter;
    private View mBackView;
    private final AtomicBoolean mConnected;
    private boolean mEditMode;
    private TextView mEmptySummaryView;
    private TextView mEmptyTitleView;
    private final IntentFilter mFilter;
    private android.net.wifi.WifiInfo mLastInfo;
    private NetworkInfo.DetailedState mLastState;
    private List<WifiConfiguration> mListAccessPoint;
    private boolean mManualSortMode;
    private final BroadcastReceiver mReceiver;
    private ImageView mRightView;
    private List<AccessPoint> mSeenAccessPoint;
    private volatile ServiceHandler mServiceHandler;
    private volatile Looper mServiceLooper;
    private TextView mTipsTextView;
    private OFloatingTitleBar mTitleBar;
    private HashMap<Integer, ViewHolder> mViewHolderMap;
    private SettingItemSwitch mViewSortMode;
    private WifiManager mWifiManager;

    private class AccessPointAdapter extends BaseAdapter {
        LayoutInflater mInflater;
        List<WifiConfiguration> mList;
        int mSortSplitLinePosition;
        final /* synthetic */ SortNetworkListActivity this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int r1) {
            return true;
        }

        public AccessPointAdapter(SortNetworkListActivity r2, List<WifiConfiguration> r3, int r4) {
            this.this$0 = r2;
            this.mList = r3;
            WifiConfiguration r5 = new WifiConfiguration();
            r5.networkId = -2;
            this.mList.add(r4, r5);
            this.mInflater = LayoutInflater.from(r2);
            SortNetworkListActivity.access$600(r2).clear();
            this.mSortSplitLinePosition = r4;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mList.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r2) {
            if (r2 >= 0) goto L4;
            return null;
        L4:
            if (r2 < this.mList.size()) goto L6;
            return null;
        L6:
            return this.mList.get(r2);
        }

        private void setPreferenceBackground(View r2, int r3) {
            View r0 = r2.findViewById(R.id.title_blank_view);
            if (r3 != this.mSortSplitLinePosition) goto L6;
            r2.setBackgroundColor(-1184275);
            r0.setVisibility(8);
            return;
        L6:
            r2.setBackgroundColor(-1);
            r0.setVisibility(0);
        }

        private void updateViewText(ViewHolder r4, WifiConfiguration r5) {
            if (r5 != null) goto L5;
            return;
        L5:
            if (r4.getPosition() != this.mSortSplitLinePosition) goto L9;
            r4.mTitle.setText(this.this$0.getString(R.string.wifi_connection_sort_tips));
            r4.mTitle.setTextSize(13.5f);
            r4.mTitle.setTextColor(Integer.MIN_VALUE);
            r4.mTitle.setLeft(11);
            int r3 = this.this$0.getResources().getDimensionPixelSize(R.dimen.wifi_sort_network_text_margin);
            r4.mTitle.setPadding(0, r3, 0, r3);
            r4.mRemoveIcon.setVisibility(8);
            r4.mSummary.setVisibility(8);
            r4.mDrag.setVisibility(8);
            return;
        L9:
            if (SortNetworkListActivity.access$200(this.this$0) == false) goto L11;
            r4.mRemoveIcon.setVisibility(0);
            r4.mDrag.setVisibility(4);
        L12:
            r4.mSummary.setVisibility(0);
            r4.mTitle.setText(AccessPoint.removeDoubleQuotes(r5.SSID));
            r4.mTitle.setTextSize(18.0f);
            r4.mTitle.setTextColor(-872415232);
            r4.mTitle.setPadding(0, 0, 0, 0);
            if (SortNetworkListActivity.access$700(this.this$0, r5) == true) goto L15;
            r4.mSummary.setText(this.this$0.getString(R.string.wifi_not_in_range));
            return;
        L15:
            SortNetworkListActivity r0 = this.this$0;
            SortNetworkListActivity.access$802(r0, SortNetworkListActivity.access$900(r0).getConnectionInfo());
            if (SortNetworkListActivity.access$1000(this.this$0).get() == true) goto L18;
        L22:
            r4.mSummary.setText(this.this$0.getString(R.string.wifi_remembered));
            r4.getRemoveIcon().setImageResource(R.drawable.ic_remove);
            return;
        L18:
            if (SortNetworkListActivity.access$800(this.this$0) == null) goto L22;
            if (SortNetworkListActivity.access$800(this.this$0).getNetworkId() != r5.networkId) goto L22;
            r4.mSummary.setText(this.this$0.getString(R.string.wifi_display_status_connected));
            r4.getRemoveIcon().setImageResource(R.drawable.ic_disable_remove);
            return;
        L11:
            r4.mDrag.setVisibility(0);
            goto L12
        }

        @Override // android.widget.Adapter
        public View getView(final int r15, View r16, ViewGroup r17) {
            final WifiConfiguration r9 = this.mList.get(r15);
            if (r16 != null) goto L9;
            View r11 = this.mInflater.inflate(R.layout.sort_access_point_layout, r17, false);
            RelativeLayout r1 = (RelativeLayout) r11.findViewById(R.id.all_view_layout);
            RelativeLayout r2 = (RelativeLayout) r1.findViewById(R.id.title_layout);
            LinearLayout r4 = (LinearLayout) r2.findViewById(R.id.title_layout_wifi);
            ImageView r5 = (ImageView) r1.findViewById(R.id.item_remove_view);
            TextView r6 = (TextView) r4.findViewById(R.id.title);
            TextView r7 = (TextView) r4.findViewById(R.id.summary);
            TextView r8 = (TextView) r2.findViewById(R.id.currently_connected_text);
            ImageView r12 = (ImageView) r1.findViewById(R.id.drag_handle);
            if (SortNetworkListActivity.access$1100(this.this$0) == false) goto L7;
            r12.setVisibility(0);
        L8:
            ViewHolder r13 = new ViewHolder(r5, r6, r7, r8, r12, r15);
            r11.setTag(r13);
        L10:
            r13.mPosition = r15;
            updateViewText(r13, r9);
            r13.getRemoveIcon().setOnClickListener(new AnonymousClass1(this, r9, r15));
            setPreferenceBackground((RelativeLayout) r11.findViewById(R.id.all_view_layout), r15);
            SortNetworkListActivity.access$600(this.this$0).put(Integer.valueOf(r9.networkId), r13);
            return r11;
        L7:
            r12.setVisibility(4);
            goto L8
        L9:
            r13 = (ViewHolder) r16.getTag();
            r11 = r16;
            goto L10
        }
    }

    private final class ServiceHandler extends Handler {
        final /* synthetic */ SortNetworkListActivity this$0;

        /* synthetic */ ServiceHandler(SortNetworkListActivity r1, Looper r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private ServiceHandler(SortNetworkListActivity r1, Looper r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r3) {
            if (r3.what != 1) goto L7;
            OLog.d(SortNetworkListActivity.TAG, "handleMessage CMD_UPDATE_PRIORITY");
            List r4 = (List) r3.obj;
            SortNetworkListActivity.access$500(this.this$0, r4);
            return;
        }
    }

    private static class ViewHolder {
        ImageView mDrag;
        int mPosition;
        ImageView mRemoveIcon;
        TextView mSubTitle;
        TextView mSummary;
        TextView mTitle;

        public ViewHolder(ImageView r1, TextView r2, TextView r3, TextView r4, ImageView r5, int r6) {
            this.mRemoveIcon = r1;
            this.mTitle = r2;
            this.mSummary = r3;
            this.mSubTitle = r4;
            this.mDrag = r5;
            this.mPosition = r6;
        }

        ImageView getRemoveIcon() {
            return this.mRemoveIcon;
        }

        TextView getSubTitle() {
            return this.mSubTitle;
        }

        ImageView getDrag() {
            return this.mDrag;
        }

        int getPosition() {
            return this.mPosition;
        }
    }

    public void com_android_settings_wifi_SortNetworkListActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_wifi_SortNetworkListActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_wifi_SortNetworkListActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_wifi_SortNetworkListActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com_android_settings_wifi_SortNetworkListActivity_com_obric_hook_lancet_PrivacyHookActivity2_onDestroy(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_wifi_SortNetworkListActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_wifi_SortNetworkListActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_wifi_SortNetworkListActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_wifi_SortNetworkListActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    static /* synthetic */ void access$000(SortNetworkListActivity r0, Context r1, Intent r2) {
        r0.handleEvent(r1, r2);
    }

    static /* synthetic */ AtomicBoolean access$1000(SortNetworkListActivity r0) {
        return r0.mConnected;
    }

    static /* synthetic */ boolean access$1100(SortNetworkListActivity r0) {
        return r0.mManualSortMode;
    }

    static /* synthetic */ TextView access$1200(SortNetworkListActivity r0) {
        return r0.mEmptyTitleView;
    }

    static /* synthetic */ TextView access$1300(SortNetworkListActivity r0) {
        return r0.mEmptySummaryView;
    }

    static /* synthetic */ boolean access$200(SortNetworkListActivity r0) {
        return r0.mEditMode;
    }

    static /* synthetic */ boolean access$202(SortNetworkListActivity r0, boolean r1) {
        r0.mEditMode = r1;
        return r1;
    }

    static /* synthetic */ void access$300(SortNetworkListActivity r0) {
        r0.cancelEditMode();
    }

    static /* synthetic */ void access$400(SortNetworkListActivity r0) {
        r0.startEditMode();
    }

    static /* synthetic */ void access$500(SortNetworkListActivity r0, List r1) {
        r0.updateAccessPointPriority(r1);
    }

    static /* synthetic */ HashMap access$600(SortNetworkListActivity r0) {
        return r0.mViewHolderMap;
    }

    static /* synthetic */ boolean access$700(SortNetworkListActivity r0, WifiConfiguration r1) {
        return r0.matchScanResult(r1);
    }

    static /* synthetic */ android.net.wifi.WifiInfo access$800(SortNetworkListActivity r0) {
        return r0.mLastInfo;
    }

    static /* synthetic */ android.net.wifi.WifiInfo access$802(SortNetworkListActivity r0, android.net.wifi.WifiInfo r1) {
        r0.mLastInfo = r1;
        return r1;
    }

    static /* synthetic */ WifiManager access$900(SortNetworkListActivity r0) {
        return r0.mWifiManager;
    }

    public SortNetworkListActivity() {
        this.mViewHolderMap = new HashMap();
        this.mConnected = new AtomicBoolean(false);
        this.mEditMode = false;
        this.mManualSortMode = false;
        IntentFilter r0 = new IntentFilter();
        this.mFilter = r0;
        r0.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        r0.addAction("android.net.wifi.STATE_CHANGE");
        this.mReceiver = new AnonymousClass1(this);
    }

    private void handleEvent(Context r2, Intent r3) {
        if ("android.net.wifi.STATE_CHANGE".equals(r3.getAction()) == false) goto L8;
        NetworkInfo r4 = (NetworkInfo) r3.getParcelableExtra("networkInfo");
        this.mConnected.set(r4.isConnected());
        AccessPointAdapter r1 = this.mAdapter;
        if (r1 == null) goto L9;
        r1.notifyDataSetChanged();
        return;
    L9:
        return;
    }

    private List<WifiConfiguration> sortConfigedAPs(List<WifiConfiguration> r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        Collections.sort(r2, new AnonymousClass2(this));
        return r2;
    }

    private List<WifiConfiguration> constructAccessPoints() {
        List<WifiConfiguration> r0 = this.mWifiManager.getConfiguredNetworks();     // Catch: RuntimeException -> L4
    L7:
        return sortConfigedAPs(r0);
    L4:
        e = move-exception;
        e.printStackTrace();
        r0 = null;
        goto L7
    }

    public void com_android_settings_wifi_SortNetworkListActivity__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        com.android.settings.Utils.setTranslucentStatusAndNavigation(getApplicationContext(), getWindow());
        setContentView(R.layout.sort_network_list_activity);
        this.mWifiManager = (WifiManager) getSystemService("wifi");
        this.mListAccessPoint = constructAccessPoints();
        this.mEmptyTitleView = (TextView) findViewById(R.id.empty_network_tip_title);
        this.mEmptySummaryView = (TextView) findViewById(R.id.empty_network_tip_summary);
        List<WifiConfiguration> r4 = this.mListAccessPoint;
        int r0 = 0;
        if (r4 != null) goto L5;
    L6:
        this.mEmptyTitleView.setVisibility(0);
        this.mEmptySummaryView.setVisibility(0);
    L7:
        initTitleView();
        int r5 = Settings.Global.getInt(getContentResolver(), "wifi_sort_network_splite_line_position", 0);
        if (r5 > this.mListAccessPoint.size()) goto L11;
        r0 = r5;
    L11:
        this.mAdapter = new AccessPointAdapter(this, this.mListAccessPoint, r0);
        attemptStartSortMode();
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, this.mReceiver, this.mFilter, 2);
        HandlerThread r6 = new HandlerThread("NetworkSortThread");
        r6.start();
        this.mServiceLooper = r6.getLooper();
        this.mServiceHandler = new ServiceHandler(this, this.mServiceLooper, null);
        return;
    L5:
        if (r4.size() >= 1) goto L7;
        goto L6
    }

    public void com_android_settings_wifi_SortNetworkListActivity__onResume$___twin___() {
        super.onResume();
    }

    private void attemptStartSortMode() {
        int r0 = this.mAdapter.mSortSplitLinePosition;
        int r1 = 0;
        boolean r2 = false;
    L3:
        if (r1 >= r0) goto L9;
        r2 = matchScanResult(this.mAdapter.mList.get(r1));
        if (r2 == true) goto L9;
        r1 = r1 + 1;
    L9:
        if (r2 == false) goto L11;
        SystemProperties.set("persist.wifi.manual.sort", "true");
        return;
    L11:
        SystemProperties.set("persist.wifi.manual.sort", "false");
    }

    private void setUiState(boolean r2) {
        if (r2 == false) goto L7;
        if (this.mRightView.isEnabled() == true) goto L10;
        this.mRightView.setAlpha(1);
        this.mRightView.setEnabled(true);
        return;
    L10:
        return;
    L7:
        if (this.mRightView.isEnabled() == false) goto L12;
        this.mRightView.setAlpha(0.5f);
        this.mRightView.setEnabled(false);
        return;
    }

    private void initTitleView() {
        this.mTipsTextView = (TextView) findViewById(R.id.sort_tips);
        OFloatingTitleBar r0 = (OFloatingTitleBar) findViewById(R.id.view_title);
        this.mTitleBar = r0;
        ImageView r1 = (ImageView) r0.addEndAction(R.drawable.standard_icon_hignlight_multi_select_selector, -1, null);
        this.mRightView = r1;
        r1.setOnClickListener(new AnonymousClass3(this));
        if (this.mListAccessPoint.size() > 0) goto L5;
        setUiState(false);
    L6:
        View r2 = this.mTitleBar.addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, null);
        this.mBackView = r2;
        r2.setOnClickListener(new AnonymousClass4(this));
        return;
    L5:
        setUiState(true);
        goto L6
    }

    private void startEditMode() {
        this.mRightView.setImageResource(R.drawable.standard_icon_hignlight_confirm_selector);
        updateRemovedImageVisibility(true);
    }

    private void cancelEditMode() {
        this.mRightView.setImageResource(R.drawable.standard_icon_hignlight_multi_select_selector);
        updateRemovedImageVisibility(false);
        if (this.mAdapter.mList.size() > 1) goto L5;
        setUiState(false);
        return;
    L5:
        setUiState(true);
    }

    private void updateRemovedImageVisibility(boolean r7) {
        android.net.wifi.WifiInfo r0 = this.mWifiManager.getConnectionInfo();
        this.mLastInfo = r0;
        int r1 = r0.getNetworkId();
        Iterator<Integer> r2 = this.mViewHolderMap.keySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L16;
        Integer r3 = r2.next();
        ViewHolder r4 = this.mViewHolderMap.get(r3);
        if (r4.getPosition() == this.mAdapter.mSortSplitLinePosition) goto L4;
        if (r7 == true) goto L10;
        r4.getRemoveIcon().setVisibility(8);
        r4.getDrag().setVisibility(0);
        goto L4
    L10:
        r4.getRemoveIcon().setVisibility(0);
        if (r3.intValue() == r1) goto L13;
        r4.getRemoveIcon().setImageResource(R.drawable.ic_remove);
    L14:
        r4.getDrag().setVisibility(4);
        goto L4
    L13:
        r4.getRemoveIcon().setImageResource(R.drawable.ic_disable_remove);
        goto L14
    }

    public void com_android_settings_wifi_SortNetworkListActivity__onDestroy$___twin___() {
        super.onDestroy();
        Settings.Global.putInt(getContentResolver(), "wifi_sort_network_splite_line_position", this.mAdapter.mSortSplitLinePosition);
        unregisterReceiver(this.mReceiver);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.mEditMode == false) goto L6;
        this.mEditMode = false;
        cancelEditMode();
        return;
    }

    private void updateAccessPointPriority(List<WifiConfiguration> r5) {
        int r0 = r5.size();
        int r1 = 0;
    L4:
        if (r1 >= r5.size()) goto L6;
        WifiConfiguration r2 = r5.get(r1);
        r2.priority = r0 - r1;
        this.mWifiManager.updateNetwork(r2);
        r1 = r1 + 1;
        goto L4
    L6:
        this.mWifiManager.saveConfiguration();
        this.mWifiManager.startScan();
    }

    private boolean matchScanResult(WifiConfiguration r4) {
        List<ScanResult> r3 = this.mWifiManager.getScanResults();
        if (r3 == null) goto L15;
        Iterator<ScanResult> r5 = r3.iterator();
    L6:
        if (r5.hasNext() == false) goto L25;
        ScanResult r0 = r5.next();
        if (r0.SSID == null) goto L6;
        if (r0.SSID.equals(AccessPoint.removeDoubleQuotes(r4.SSID)) == false) goto L6;
        if (AccessPoint.getSecurity(r0) != AccessPoint.getSecurity(r4)) goto L6;
        return true;
    L25:
        return false;
    L15:
        return false;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_wifi_SortNetworkListActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(SortNetworkListActivity r1) {
        com_android_settings_wifi_SortNetworkListActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_wifi_SortNetworkListActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(SortNetworkListActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        SortNetworkListActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_wifi_SortNetworkListActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_SortNetworkListActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(SortNetworkListActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_wifi_SortNetworkListActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_SortNetworkListActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(SortNetworkListActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_wifi_SortNetworkListActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        SortNetworkListActivity r5 = r4;
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
    public static void com_android_settings_wifi_SortNetworkListActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(SortNetworkListActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_wifi_SortNetworkListActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_wifi_SortNetworkListActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(SortNetworkListActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_wifi_SortNetworkListActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_wifi_SortNetworkListActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(SortNetworkListActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        SortNetworkListActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_wifi_SortNetworkListActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_wifi_SortNetworkListActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(SortNetworkListActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_wifi_SortNetworkListActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_wifi_SortNetworkListActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(SortNetworkListActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        SortNetworkListActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_wifi_SortNetworkListActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_wifi_SortNetworkListActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(SortNetworkListActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_wifi_SortNetworkListActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        SortNetworkListActivity r5 = r3;
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
    public static void com_android_settings_wifi_SortNetworkListActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(SortNetworkListActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        SortNetworkListActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_wifi_SortNetworkListActivity__onStop$___twin___();
    }

    @Insert("onDestroy")
    public static void com_android_settings_wifi_SortNetworkListActivity_com_obric_hook_lancet_PrivacyHookActivity2_onDestroy(SortNetworkListActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        SortNetworkListActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_wifi_SortNetworkListActivity__onDestroy$___twin___();
    }
}
