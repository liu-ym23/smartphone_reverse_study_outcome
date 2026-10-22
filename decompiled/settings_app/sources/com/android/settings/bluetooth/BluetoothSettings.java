package com.android.settings.bluetooth;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.UserManager;
import android.preference.BluetoothCategory;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;
import androidx.recyclerview.widget.RecyclerView;
import com.GlobalProxyLancet;
import com.android.settings.ExecutorManager;
import com.android.settings.R;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsTracker;
import com.android.settings.about.DeviceUtils;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.bluetooth.systemui.bond.SystemUIBondHelper;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.SLog;
import com.android.settings.utils.UIUtils;
import com.android.settings.widget.FakePreference;
import com.android.settings.wifi.preference.SectionLayoutPreference;
import com.android.settingslib.applications.RecentAppOpsAccess;
import com.bytedance.apm.perf.ThreadCollector;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.oswitch.OSwitch;
import com.obric.privacy.GrantUtil;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.api.INewIntentHandler;

/* JADX INFO: loaded from: classes2.dex */
public final class BluetoothSettings extends DeviceListPreferenceFragment implements View.OnClickListener, INewIntentHandler {
    public static final String ACTION_CONNECTION_STATE_CHANGED = "android.setting.bluetooth.action.CONNECTION_STATE_CHANGED";
    private static final String BTOPP_ACTION_OPEN_RECEIVED_FILES = "android.btopp.intent.action.OPEN_RECEIVED_FILES";
    private static final String KEY_FOOTER = "footer";
    private static final String KEY_RESTART = "restart";
    private static final String KEY_SCENE = "scene";
    private static final int MENU_ID_RENAME_DEVICE = 2;
    private static final int MENU_ID_SCAN = 1;
    private static final int MENU_ID_SHOW_RECEIVED = 4;
    private static final int MENU_ID_VISIBILITY_TIMEOUT = 3;
    private static final int MSG_CANCEL_SCAN = 7;
    private static final int MSG_HIDE_REFRESH_LOADING = 9;
    private static final int MSG_REFESH = 4;
    private static final int MSG_REFRESH_BOUND_STATE = 5;
    private static final int MSG_REFRESH_BUSY_STATE = 6;
    private static final int MSG_SCAN = 3;
    private static final int MSG_SHOW_REFRESH_LOADING = 8;
    private static final int MSG_STATE_BUSY = 2;
    private static final int MSG_STATE_IDLE = 1;
    private static final int ORDER_AVAILABLE_DEVICES_CATEGORY = 2;
    private static final int ORDER_BLUE_TOOTH_SWITCH_HEADER = 0;
    private static final int ORDER_FOOTER = 3;
    private static final int ORDER_PAIRED_DEVICES_CATEGORY = 1;
    private static final String TAG = "BluetoothSettings";
    private static final int TIME_SCAN_DELAY = 400;
    private boolean isBondedRequest;
    private BluetoothCategory mAvailableDevicesCategory;
    private OCardListItem mBluetooth;
    private BluetoothEnabler mBluetoothEnabler;
    private View mBluetoothHeader;
    private SectionLayoutPreference mBluetoothHeaderPreference;
    private ConnectingStateHandler mConnectingStateHandler;
    private View mCustomButtonFooter;
    private SectionLayoutPreference mCustomFooterPreference;
    private OCardListItem mDeviceNameItem;
    private final View.OnClickListener mDeviceProfilesListener;
    private View mFooterView;
    private LinearLayout mGroupContainer;
    private LinearLayout.LayoutParams mGroupContainerLp;
    private boolean mHasDelayedRefresh;
    private OListItemSettings mHiddenDevices;
    private final IntentFilter mIntentFilter;
    private boolean mIsBonding;
    private boolean mIsBusyState;
    private RecyclerView mListView;
    private Object mLock;
    private BluetoothNameDialogFragment mNameFragment;
    private OCardListItem mOtherDeviceContainer;
    private PreferenceGroup mPairedDevicesCategory;
    private OCardListItem mReceivedFiles;
    private final BroadcastReceiver mReceiver;
    private final Handler mScanHandler;
    private SystemUIBondHelper mSystemUIBondHelper;
    private boolean stopScanForNoNecessary;

    private void safeSortList() {
    }

    @Override // com.android.settings.bluetooth.DeviceListPreferenceFragment
    void addPreferencesForActivity() {
    }

    public void com_android_settings_bluetooth_BluetoothSettings__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r1) {
    }

    @Override // com.android.settings.bluetooth.DeviceListPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_bluetooth_BluetoothSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.bluetooth.DeviceListPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_bluetooth_BluetoothSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ void access$000(BluetoothSettings r0) {
        r0.updateDeviceName();
    }

    static /* synthetic */ Handler access$100(BluetoothSettings r0) {
        return r0.mScanHandler;
    }

    static /* synthetic */ BluetoothCategory access$1000(BluetoothSettings r0) {
        return r0.mAvailableDevicesCategory;
    }

    static /* synthetic */ void access$200(BluetoothSettings r0, String r1) {
        r0.startScanning(r1);
    }

    static /* synthetic */ void access$300(BluetoothSettings r0) {
        r0.checkBusyState();
    }

    static /* synthetic */ boolean access$402(BluetoothSettings r0, boolean r1) {
        r0.stopScanForNoNecessary = r1;
        return r1;
    }

    static /* synthetic */ Object access$500(BluetoothSettings r0) {
        return r0.mLock;
    }

    static /* synthetic */ void access$600(BluetoothSettings r0, int r1, boolean r2) {
        r0.updateContent(r1, r2);
    }

    static /* synthetic */ void access$700(BluetoothSettings r0, boolean r1) {
        r0.setEnabled(r1);
    }

    static /* synthetic */ boolean access$800(BluetoothSettings r0) {
        return r0.mHasDelayedRefresh;
    }

    static /* synthetic */ boolean access$802(BluetoothSettings r0, boolean r1) {
        r0.mHasDelayedRefresh = r1;
        return r1;
    }

    static /* synthetic */ boolean access$900(BluetoothSettings r0) {
        return r0.mIsBusyState;
    }

    static /* synthetic */ boolean access$902(BluetoothSettings r0, boolean r1) {
        r0.mIsBusyState = r1;
        return r1;
    }

    private void checkBusyState() {
        ExecutorManager.execute(new AnonymousClass3(this));
    }

    private void updateBusyState() {
        PreferenceGroup r0 = this.mPairedDevicesCategory;
        if (r0 == null) goto L6;
        r0.setEnabled(!this.mIsBusyState);
        return;
    }

    private void refreshListByState(int r2, int r3) {
        if (r2 != 1) goto L7;
        if (r3 != 0) goto L8;
        OLog.d(TAG, "Profile connect fail, refresh the list");
        setupDevicePreferenceBackground();
        return;
    L8:
        return;
    }

    private void printAllCategory() {
        PreferenceGroup r0 = this.mPairedDevicesCategory;
        if (r0 == null) goto L5;
        printGroup(r0, "Paired");
    L5:
        BluetoothCategory r1 = this.mAvailableDevicesCategory;
        if (r1 == null) goto L9;
        printGroup(r1, "Available");
        return;
    }

    private void updateDeviceName() {
        FragmentActivity r0 = getActivity();
        StringBuilder r1 = new StringBuilder("updateDeviceName------");
        if (this.mDeviceNameItem == null) goto L6;
        if (r0 == null) goto L6;
        boolean r2 = true;
    L7:
        OLog.d(TAG, r1.append(r2).toString());
        if (this.mDeviceNameItem == null) goto L22;
        if (r0 == null) goto L23;
        boolean r3 = r0.getSharedPreferences(r0.getPackageName(), 0).getBoolean(com.android.settings.Utils.KEY_IF_NEED_READ_DEVICE_NAME_BT, true);
        if (this.mLocalAdapter.isEnabled() == true) goto L16;
        if (r3 == false) goto L16;
        this.mDeviceNameItem.setEndDetailText(com.android.settings.Utils.getDeviceName(r0));
        return;
    L16:
        if (TextUtils.equals(this.mLocalAdapter.getName(), this.mDeviceNameItem.getEndDetail().getText()) == true) goto L18;
        this.mDeviceNameItem.setEndDetailText(this.mLocalAdapter.getName());
    L18:
        SLog.d(TAG, "updateDeviceName------, isDeviceNameEdit:" + DeviceUtils.INSTANCE.isDeviceNameEdit() + " deviceName:" + com.android.settings.Utils.getDeviceName(r0));
        if (DeviceUtils.INSTANCE.isDeviceNameEdit() == false) goto L24;
        this.mDeviceNameItem.setEndDetailText(com.android.settings.Utils.getDeviceName(r0));
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L6:
        r2 = false;
        goto L7
    }

    public BluetoothSettings() {
        this.mNameFragment = null;
        this.mIsBusyState = false;
        this.mHasDelayedRefresh = false;
        this.mIsBonding = false;
        this.stopScanForNoNecessary = false;
        this.mLock = new Object();
        this.isBondedRequest = true;
        this.mReceiver = new AnonymousClass1(this);
        this.mScanHandler = new AnonymousClass2(this);
        this.mDeviceProfilesListener = new BluetoothDeviceProfilesClickListener(R.string.bluetooth_settings_title);
        IntentFilter r0 = new IntentFilter();
        this.mIntentFilter = r0;
        r0.addAction("android.bluetooth.adapter.action.LOCAL_NAME_CHANGED");
        r0.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        r0.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        r0.addAction(ACTION_CONNECTION_STATE_CHANGED);
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle r1, String r2) {
        addPreferencesFromResource(R.xml.bluetooth_settings);
    }

    private TouchCallbackFrameLayout getTouchCallbackFrameLayout() {
        TouchCallbackFrameLayout r0 = new TouchCallbackFrameLayout(this.mContext);
        r0.addOnTouchListener(new BluetoothSettings$$ExternalSyntheticLambda3(this));
        return r0;
    }

    /* JADX INFO: renamed from: lambda$getTouchCallbackFrameLayout$0$com-android-settings-bluetooth-BluetoothSettings, reason: not valid java name */
    /* synthetic */ boolean m355x15a7fdfe(View r4, MotionEvent r5) {
        this.stopScanForNoNecessary = false;
        this.mScanHandler.removeMessages(7);
        this.mScanHandler.sendEmptyMessageDelayed(7, this.autoStopDuration);
        if (this.mLocalAdapter.isDiscovering() == true) goto L5;
        startScanning("touch");
    L5:
        return false;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r4) {
        super.onConfigurationChanged(r4);
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r4.orientation != 2) goto L8;
        float r5 = r0.getResources().getDimensionPixelSize(R.dimen.bluetooth_landscape_title_textsize);
        int r1 = r0.getResources().getDimensionPixelSize(R.dimen.bluetooth_landscape_switchbar_height);
        int r2 = r0.getResources().getDimensionPixelSize(R.dimen.bluetooth_landscape_actionbar_height);
    L9:
        resetBarSize(r5, r2, r1);
        return;
    L8:
        r5 = r0.getResources().getDimensionPixelSize(R.dimen.bluetooth_portrait_title_textsize);
        r1 = r0.getResources().getDimensionPixelSize(R.dimen.bluetooth_portrait_switchbar_height);
        r2 = r0.getResources().getDimensionPixelSize(R.dimen.bluetooth_portrait_switchbar_height);
        goto L9
    }

    private void resetBarSize(float r5, int r6, int r7) {
        FragmentActivity r4 = getActivity();
        if (r4 != null) goto L5;
        return;
    L5:
        DisplayMetrics r8 = Resources.getSystem().getDisplayMetrics();
        Toolbar r9 = (Toolbar) r4.getWindow().findViewById(Resources.getSystem().getIdentifier("action_bar", "id", RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME));
        TextView r1 = null;
        if (r9 == null) goto L14;
        r9.getLayoutParams().height = (int) TypedValue.applyDimension(1, r6, r8);
        int r10 = 0;
    L9:
        if (r10 >= r9.getChildCount()) goto L14;
        if ((r9.getChildAt(r10) instanceof TextView) == false) goto L13;
        r1 = (TextView) r9.getChildAt(r10);
    L13:
        ((Toolbar.LayoutParams) r9.getChildAt(r10).getLayoutParams()).gravity = 16;
        r10 = r10 + 1;
    L14:
        if (r1 == null) goto L20;
        r1.setTextSize(1, r5);
        return;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.mScanHandler.removeCallbacksAndMessages(null);
        super.onDestroyView();
    }

    private void initBluetoothHeaderView(LayoutInflater r4) {
        View r5 = r4.inflate(R.layout.bluetooth_setting_header_switch, null);
        this.mBluetoothHeader = r5;
        this.mBluetooth = (OCardListItem) r5.findViewById(R.id.item_switch);
        OCardListItem r6 = (OCardListItem) this.mBluetoothHeader.findViewById(R.id.btn_device_name);
        this.mDeviceNameItem = r6;
        r6.setOnContentClickListener(new BluetoothSettings$$ExternalSyntheticLambda1(this));
        OCardListItem r7 = (OCardListItem) this.mBluetoothHeader.findViewById(R.id.btn_show_received_files);
        this.mReceivedFiles = r7;
        r7.setOnContentClickListener(new BluetoothSettings$$ExternalSyntheticLambda2(this));
        this.mBluetoothEnabler = new BluetoothEnabler(getActivity(), (OSwitch) this.mBluetooth.getCustomEndView(), this.mBluetoothBinderClient);
        SectionLayoutPreference r8 = new SectionLayoutPreference(this.mContext, this.mBluetoothHeader);
        this.mBluetoothHeaderPreference = r8;
        r8.setSelectable(false);
        this.mBluetoothHeaderPreference.setOrder(0);
        PreferenceScreen r9 = getPreferenceScreen();
        r9.setOrderingAsAdded(true);
        r9.addPreference(this.mBluetoothHeaderPreference);
    }

    /* JADX INFO: renamed from: lambda$initBluetoothHeaderView$2$com-android-settings-bluetooth-BluetoothSettings, reason: not valid java name */
    /* synthetic */ void m357x6bdee995(View r2) {
        BluetoothNameDialogFragment r3 = this.mNameFragment;
        if (r3 == null) goto L5;
        r3.dismiss();
        this.mNameFragment = null;
    L5:
        BluetoothNameDialogFragment r4 = new BluetoothNameDialogFragment();
        this.mNameFragment = r4;
        r4.setOnClickListener(new BluetoothSettings$$ExternalSyntheticLambda0(this));
        this.mNameFragment.show(getParentFragmentManager(), "rename device");
        SettingsTracker.onItemClick(503);
    }

    /* JADX INFO: renamed from: lambda$initBluetoothHeaderView$1$com-android-settings-bluetooth-BluetoothSettings, reason: not valid java name */
    /* synthetic */ void m356x7a354376(View r1) {
        this.mDeviceNameItem.setEndDetailText(((TextView) r1).getText().toString());
    }

    /* JADX INFO: renamed from: lambda$initBluetoothHeaderView$3$com-android-settings-bluetooth-BluetoothSettings, reason: not valid java name */
    /* synthetic */ void m358x5d888fb4(View r3) {
        Intent r4 = new Intent().setClassName("com.android.bluetooth", "com.android.bluetooth.opp.BluetoothOppTransferHistory");
        r4.putExtra(MaterialConfigFormatNames.DIRECTION, 1);
        r4.putExtra("android.btopp.intent.extra.SHOW_ALL", true);
        r4.putExtra("launchedBySetting", true);
        r4.putExtra("bytedanceos.intent.extra.ANIM_RESOURCE_ID", new int[]{R.anim.slide_in_from_left, R.anim.slide_out_to_right});
        com.android.settings.Utils.startActivity(getActivity(), r4);
        SettingsTracker.onItemClick(502);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View r6, Bundle r7) {
        super.onViewCreated(r6, r7);
        initBluetoothHeaderView(requireActivity().getLayoutInflater());
        initCustomFooterView();
        RecyclerView r8 = getListView();
        this.mListView = r8;
        r8.setItemAnimator(null);
        this.mListView.setClipChildren(false);
        this.mListView.setClipToPadding(false);
        this.mListView.setOverScrollMode(0);
        this.mListView.setVerticalScrollBarEnabled(false);
        UIUtils.setUpBottomPaddingOnApplyWindowInsets(this.mListView);
        this.mConnectingStateHandler = new ConnectingStateHandler(requireActivity());
        ViewParent r9 = this.mListView.getParent();
        if ((r9 instanceof FrameLayout) == false) goto L5;
        FrameLayout r10 = (FrameLayout) r9;
        r10.addView(getTouchCallbackFrameLayout());
    L5:
        SystemUIBondHelper r11 = new SystemUIBondHelper(LocalBluetoothManager.getInstance(getActivity()).getEventManager());
        this.mSystemUIBondHelper = r11;
        this.isBondedRequest = r11.tryBondNewDevice(requireActivity().getIntent());
        FragmentActivity r12 = getActivity();
        if (r12 == null) goto L21;
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r12, this.mReceiver, this.mIntentFilter, 2);
    L21:
        ThreadCollector.reportThreadCount("bluetooth_settings_open", true);     // Catch: Exception -> L11
    L23:
        ThreadCollector.reportThreadCount("bluetooth_settings_open", true);     // Catch: Exception -> L15
    L18:
        if (this.mScanHandler.hasMessages(4) == true) goto L25;
        this.mScanHandler.sendEmptyMessageDelayed(4, 50);
        return;
    L25:
        return;
    L15:
        e = move-exception;
        OLog.e(TAG, "reportThreadCount error", e);
    L11:
        e = move-exception;
        OLog.e(TAG, "reportThreadCount error", e);
        goto L23
    }

    private void initCustomFooterView() {
        View r0 = View.inflate(this.mContext, R.layout.bluetooth_fotter_layout, null);
        this.mCustomButtonFooter = r0;
        this.mOtherDeviceContainer = (OCardListItem) r0.findViewById(R.id.other_device);
        showOtherDevice(false);
        this.mOtherDeviceContainer.setOnContentClickListener(new AnonymousClass4(this));
        SectionLayoutPreference r1 = new SectionLayoutPreference(this.mContext, this.mCustomButtonFooter);
        this.mCustomFooterPreference = r1;
        r1.setSelectable(false);
        this.mCustomFooterPreference.setOrder(3);
        this.mCustomFooterPreference.setKey(KEY_FOOTER);
    }

    public void com_android_settings_bluetooth_BluetoothSettings__onResume$___twin___() {
        super.onResume();
        this.mScanHandler.postDelayed(new AnonymousClass5(this), 500);
        BluetoothEnabler r0 = this.mBluetoothEnabler;
        if (r0 == null) goto L5;
        r0.resume();
    L5:
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L9;
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r1, this.mReceiver, this.mIntentFilter, 2);
    L9:
        if (this.mLocalAdapter == null) goto L20;
        updateDeviceName();
        if (this.mScanHandler.hasMessages(4) == true) goto L14;
        Handler r2 = this.mScanHandler;
        r2.sendMessage(r2.obtainMessage(4));
    L14:
        if (this.mLocalAdapter.getState() != 12) goto L20;
        if (DeviceUtils.INSTANCE.isDeviceNameEdit() == false) goto L20;
        String r3 = com.android.settings.Utils.getDeviceName(SettingsApplication.getContext());
        if (r3.equals(this.mLocalAdapter.getName()) == true) goto L20;
        this.mLocalAdapter.setName(r3);
    L20:
        this.mConnectingStateHandler.onVisible();
        if (this.mLocalAdapter.isEnabled() == false) goto L23;
        Message r4 = this.mScanHandler.obtainMessage();
        Bundle r5 = new Bundle();
        r5.putString("scene", "onSupportVisible");
        r4.setData(r5);
        r4.what = 8;
        this.mScanHandler.sendMessage(r4);
    L23:
        this.stopScanForNoNecessary = false;
        this.mScanHandler.sendEmptyMessageDelayed(7, this.autoStopDuration);
        this.mLocalAdapter.setScanMode(23);
        BluetoothDiscoverableTimeoutReceiver.cancelDiscoverableAlarm(this.mContext);
    }

    @Override // com.android.settings.bluetooth.DeviceListPreferenceFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        unregisterForContextMenu(this.mListView);
        this.mConnectingStateHandler.onInvisible();
        this.mScanHandler.removeMessages(7);
        this.mScanHandler.removeMessages(9);
        this.mScanHandler.removeMessages(8);
        BluetoothDiscoverableTimeoutReceiver.setDiscoverableAlarm(this.mContext, System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(2));
    }

    @Override // com.android.settings.bluetooth.DeviceListPreferenceFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L5;
        r0.unregisterReceiver(this.mReceiver);
    L5:
        BluetoothEnabler r2 = this.mBluetoothEnabler;
        if (r2 == null) goto L9;
        r2.pause();
        return;
    }

    void checkLocalName() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.getSharedPreferences(r0.getPackageName(), 0).getBoolean(com.android.settings.Utils.KEY_IF_NEED_READ_DEVICE_NAME_BT, true) == true) goto L8;
        return;
    L8:
        if (com.android.settings.Utils.getDeviceName(r0).equals(this.mLocalAdapter.getName()) == true) goto L12;
        this.mLocalAdapter.setName(com.android.settings.Utils.getDeviceName(r0));
        return;
    }

    private void startScanning(String r7) {
        OLog.i(TAG, String.format("startScanning, scene = %s enabled = %s busy = %s isBonding = %s mPaused = %s stopScanForNoNecessary = %s", new Object[]{r7, Boolean.valueOf(this.mLocalAdapter.isEnabled()), Boolean.valueOf(this.mIsBusyState), Boolean.valueOf(this.mIsBonding), Boolean.valueOf(this.mPaused), Boolean.valueOf(this.stopScanForNoNecessary)}));
        if (((UserManager) SettingsApplication.getContext().getSystemService(PickApplicationActivity.EXTRA_USER)).hasUserRestriction("no_config_bluetooth") == false) goto L6;
        return;
    L6:
        if (this.mLocalAdapter.isEnabled() == true) goto L8;
        return;
    L8:
        if (this.mIsBusyState == false) goto L10;
        return;
    L10:
        if (this.mIsBonding == false) goto L12;
        return;
    L12:
        if (this.mPaused == false) goto L14;
        return;
    L14:
        if (this.stopScanForNoNecessary == false) goto L16;
        return;
    L16:
        if (this.isBondedRequest == true) goto L34;
        BluetoothCategory r0 = this.mAvailableDevicesCategory;
        if (r0 == null) goto L27;
        setDeviceListGroup(r0);
        if (this.mAvailableDevicesCategory.isShowLoadingView() == true) goto L27;
        if (this.mScanHandler.hasMessages(8) == true) goto L27;
        if (this.mScanHandler.hasMessages(3) == true) goto L27;
        OLog.i(TAG, "restart refresh loading animation");
        this.mScanHandler.removeMessages(9);
        Message r1 = this.mScanHandler.obtainMessage();
        Bundle r2 = new Bundle();
        r2.putString("scene", "startScanning-->" + r7);
        r1.setData(r2);
        r1.what = 8;
        this.mScanHandler.sendMessage(r1);
    L27:
        ExecutorManager.execute(new AnonymousClass6(this), true);
        return;
    }

    @Override // com.android.settings.bluetooth.DeviceListPreferenceFragment
    void onDevicePreferenceClick(BluetoothDevicePreference r2) {
        this.mLocalAdapter.stopScanning();
        super.onDevicePreferenceClick(r2);
    }

    private void addDeviceCategory(PreferenceGroup r2, int r3, BluetoothDeviceFilter.Filter r4) {
        if (r4 != BluetoothDeviceFilter.UNBONDED_DEVICE_FILTER) goto L5;
        this.mIsBonding = isBonding();
    L5:
        r2.setTitle(r3);
        getPreferenceScreen().addPreference(r2);
        setFilter(r4);
        setDeviceListGroup(r2);
        addCachedDevices();
        r2.setEnabled(true);
    }

    @Override // com.android.settings.bluetooth.DeviceListPreferenceFragment
    protected void setupDevicePreferenceBackground() {
        setupBackground(this.mPairedDevicesCategory, true);
        setupBackground(this.mAvailableDevicesCategory, false);
        setOtherBtnCard(false);
    }

    private void setOtherBtnCard(boolean r4) {
        BluetoothCategory r0 = this.mAvailableDevicesCategory;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mOtherDeviceContainer == null) goto L13;
        int r1 = r0.getPreferenceCount();
        OLog.i(TAG, "setupDevicePreferenceBackground, count = " + r1 + " isAddFooter=" + r4);
        OCardListItem r3 = this.mOtherDeviceContainer;
        if (r1 <= 0) goto L9;
        int r5 = 3;
    L10:
        r3.setCardPosition(r5);
        return;
    L9:
        r5 = 0;
        goto L10
    }

    @Override // com.android.settings.bluetooth.DeviceListPreferenceFragment
    protected void showOtherDevice(boolean r2) {
        super.showOtherDevice(r2);
        setOtherBtnCard(true);
        OCardListItem r1 = this.mOtherDeviceContainer;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r1.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    private void updateContent(int r8, boolean r9) {
        if (isAdded() == true) goto L5;
        return;
    L5:
        PreferenceScreen r0 = getPreferenceScreen();
        int r4 = 0;
        if (r8 != 12) goto L18;
    L15:
        e = move-exception;
        OLog.e(TAG, "updateContent, operate custom footer preference failed", e);
    L29:
        switch(r8) {
            case 10: goto L65;
            case 11: goto L64;
            case 12: goto L32;
            case 13: goto L31;
            default: goto L66;
        };
    L31:
        r4 = R.string.bluetooth_turning_off;
        goto L66
    L32:
        OLog.d(TAG, "updateContent , force = " + r9);
        this.mBluetooth.showSubTitle(false);
        setDeviceListGroupTag(Utils.TAG_DEVICE_LIST_GROUP_SETTING);
        if (r9 == false) goto L35;
        removeItemPreference(r0);
        r0.setOrderingAsAdded(true);
        r0.addPreference(new FakePreference(getActivity(), "").update());
        this.mDevicePreferenceMap.clear();
    L35:
        checkLocalName();
        PreferenceGroup r10 = this.mPairedDevicesCategory;
        if (r10 != null) goto L38;
        safeSortList();
        this.mPairedDevicesCategory = new BluetoothCategory(getActivity(), this.mIsLandScreen, true, false);
        boolean r11 = true;
    L41:
        if (r11 == true) goto L43;
        if (r9 == true) goto L43;
    L44:
        int r12 = this.mPairedDevicesCategory.getPreferenceCount();
        if (((UserManager) getActivity().getSystemService(PickApplicationActivity.EXTRA_USER)).hasUserRestriction("no_config_bluetooth") == true) goto L54;
        BluetoothCategory r2 = this.mAvailableDevicesCategory;
        if (r2 != null) goto L49;
        BluetoothCategory r3 = new BluetoothCategory(getActivity(), this.mIsLandScreen, true);
        this.mAvailableDevicesCategory = r3;
        r3.setOnClickListener(new AnonymousClass7(this));
        Message r5 = this.mScanHandler.obtainMessage();
        Bundle r6 = new Bundle();
        r6.putString("scene", "updateContent");
        r5.setData(r6);
        r5.what = 8;
        this.mScanHandler.sendMessage(r5);
        r4 = 1;
    L51:
        if (r4 != 0) goto L53;
        if (r9 == true) goto L53;
    L57:
        BluetoothCategory r13 = this.mAvailableDevicesCategory;
        if (r13 == null) goto L60;
        r13.getPreferenceCount();
    L60:
        if (r12 != 0) goto L62;
        r0.removePreference(this.mPairedDevicesCategory);
    L62:
        OLog.d(TAG, "leave update content ");
        return;
    L53:
        this.mAvailableDevicesCategory.setOrder(2);
        addDeviceCategory(this.mAvailableDevicesCategory, R.string.bluetooth_preference_found_devices, BluetoothDeviceFilter.UNBONDED_DEVICE_FILTER);
        goto L57
    L49:
        if (r9 == false) goto L51;
        r2.removeAll();
        goto L51
    L54:
        BluetoothCategory r14 = this.mAvailableDevicesCategory;
        if (r14 == null) goto L57;
        r0.removePreference(r14);
    L43:
        this.mPairedDevicesCategory.setOrder(1);
        addDeviceCategory(this.mPairedDevicesCategory, R.string.bluetooth_preference_paired_devices, BluetoothDeviceFilter.BONDED_DEVICE_FILTER);
        goto L44
    L38:
        if (r9 == false) goto L40;
        r10.removeAll();
    L40:
        r11 = false;
        goto L41
    L64:
        r4 = R.string.bluetooth_turning_on;
        goto L66
    L65:
        r4 = R.string.bytedance_bluetooth_empty_list_bluetooth_off;
    L66:
        setDeviceListGroup(r0);
        removeAllDevices();
        this.mBluetooth.setSubTitle(getString(r4));
        this.mBluetooth.showSubTitle(true);
        return;
    L8:
        if (this.mCustomFooterPreference == null) goto L18;
        if (this.mHiddenCachedDevices.isEmpty() == true) goto L18;
        if (r0.findPreference(KEY_FOOTER) != null) goto L14;
        r0.addPreference(this.mCustomFooterPreference);     // Catch: Exception -> L15
    L14:
        setOtherBtnCard(false);     // Catch: Exception -> L15
    L18:
        if (r8 == 13) goto L22;
        if (r8 != 10) goto L29;
    L22:
        if (this.mCustomFooterPreference == null) goto L29;
        Preference r1 = r0.findPreference(KEY_FOOTER);     // Catch: Exception -> L15
        if (r1 == null) goto L29;
        r0.removePreference(r1);     // Catch: Exception -> L15
        goto L29
    }

    @Override // com.android.settings.bluetooth.DeviceListPreferenceFragment, com.android.settings.bluetooth.BluetoothCallback
    public void onBluetoothStateChanged(int r6) {
        super.onBluetoothStateChanged(r6);
        if (isAdded() == true) goto L6;
        return;
    L6:
        if (r6 != 12) goto L8;
        setEnabled(true);
    L9:
        Object r2 = this.mLock;
        monitor-enter(r2);
        setDeviceListGroup(getPreferenceScreen());     // Catch: Throwable -> L20
        removeAllDevices();     // Catch: Throwable -> L20
        updateContent(r6, true);     // Catch: Throwable -> L20
        monitor-exit(r2);     // Catch: Throwable -> L20
        if (r6 != 12) goto L17;
        OLog.i(TAG, "onBluetoothStateChanged, STATE_ON");
        startScanning("onBluetoothStateChanged");
        Message r1 = this.mScanHandler.obtainMessage();
        Bundle r3 = new Bundle();
        r3.putString("scene", "onBluetoothStateChanged");
        r1.setData(r3);
        r1.what = 8;
        this.mScanHandler.sendMessage(r1);
    L17:
        if (r6 != 13) goto L25;
        this.mScanHandler.removeMessages(8);
        return;
    L25:
        return;
    L20:
        th = move-exception;
        throw th;
    L8:
        setEnabled(false);
        goto L9
    }

    @Override // com.android.settings.bluetooth.DeviceListPreferenceFragment, com.android.settings.bluetooth.BluetoothCallback
    public void onScanningStateChanged(boolean r1) {
        super.onScanningStateChanged(r1);
        isAdded();
    }

    @Override // com.android.settings.bluetooth.BluetoothCallback
    public void onDeviceBondStateChanged(CachedBluetoothDevice r3, int r4) {
        if (r4 != 11) goto L5;
        boolean r5 = true;
    L6:
        this.mIsBonding = r5;
        if (r5 == false) goto L9;
        return;
    L9:
        this.isBondedRequest = false;
        if (this.mScanHandler.hasMessages(4) == false) goto L12;
        this.mHasDelayedRefresh = true;
        return;
    L12:
        int r6 = this.mLocalAdapter.getBluetoothState();
        Object r7 = this.mLock;
        monitor-enter(r7);
        setDeviceListGroup(getPreferenceScreen());     // Catch: Throwable -> L18
        removeAllDevices();     // Catch: Throwable -> L18
        updateContent(r6, true);     // Catch: Throwable -> L18
        monitor-exit(r7);     // Catch: Throwable -> L18
        setupDevicePreferenceBackground();
        return;
    L18:
        th = move-exception;
        throw th;
    L5:
        r5 = false;
        goto L6
    }

    @Override // com.android.settings.bluetooth.DeviceListPreferenceFragment, com.android.settings.bluetooth.BluetoothCallback
    public void onDeviceAdded(CachedBluetoothDevice r1) {
        super.onDeviceAdded(r1);
    }

    @Override // com.android.settings.bluetooth.DeviceListPreferenceFragment
    void initDevicePreference(BluetoothDevicePreference r3) {
        if (r3.getCachedDevice().getBondState() != 12) goto L6;
        r3.setOnSettingsClickListener(this.mDeviceProfilesListener);
        return;
    }

    private boolean isBonding() {
        Iterator<CachedBluetoothDevice> r2 = this.mLocalManager.getCachedDeviceManager().getCachedDevicesCopy().iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        if (r2.next().getBondState() != 11) goto L4;
        return true;
    L9:
        return false;
    }

    private void setEnabled(boolean r1) {
        this.mDeviceNameItem.setEnabled(r1);
    }

    @Override // obric.api.INewIntentHandler
    public void handleNewIntent(Intent r2) {
        this.isBondedRequest = this.mSystemUIBondHelper.tryBondNewDevice(r2);
    }

    @Override // com.android.settings.bluetooth.DeviceListPreferenceFragment, com.android.settings.bluetooth.BluetoothDevicePreference.OnGetDeviceViewListener
    public boolean onGetDeviceViewVisible() {
        OCardListItem r0 = this.mOtherDeviceContainer;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getVisibility() != 0) goto L7;
        return true;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_bluetooth_BluetoothSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(BluetoothSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_bluetooth_BluetoothSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_bluetooth_BluetoothSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(BluetoothSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_bluetooth_BluetoothSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_bluetooth_BluetoothSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(BluetoothSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_bluetooth_BluetoothSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
