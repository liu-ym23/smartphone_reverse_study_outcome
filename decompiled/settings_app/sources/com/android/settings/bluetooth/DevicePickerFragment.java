package com.android.settings.bluetooth;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserManager;
import android.preference.BluetoothCategory;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;
import androidx.recyclerview.widget.RecyclerView;
import com.GlobalProxyLancet;
import com.android.settings.R;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.password.PasswordUtils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.android.settings.utils.RegisterUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public final class DevicePickerFragment extends DeviceListPreferenceFragment {
    private static final int MSG_CANCEL_SCAN = 5;
    private static final int MSG_HIDE_REFRESH_LOADING = 7;
    private static final int MSG_REFESH = 4;
    private static final int MSG_SCAN = 8;
    private static final int MSG_SHOW_REFRESH_LOADING = 6;
    private static final String TAG = "DevicePickerFragment";
    private boolean mActivityStarted;
    private BluetoothCategory mAvailableDevicesCategory;
    String mCallingAppPackageName;
    Context mContext;
    private boolean mDeviceSelected;
    private IntentFilter mIntentFilter;
    String mLaunchClass;
    String mLaunchPackage;
    private boolean mNeedAuth;
    private PreferenceGroup mPairedDevicesCategory;
    private final BroadcastReceiver mReceiver;
    private final Handler mScanHandler;
    private boolean stopScanForNoNecessary;

    @Override // com.android.settings.bluetooth.DeviceListPreferenceFragment
    void initDevicePreference(BluetoothDevicePreference r1) {
    }

    @Override // com.android.settings.bluetooth.DeviceListPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_bluetooth_DevicePickerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle r1, String r2) {
    }

    @Override // com.android.settings.bluetooth.DeviceListPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_bluetooth_DevicePickerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ boolean access$000(DevicePickerFragment r0) {
        return r0.mActivityStarted;
    }

    static /* synthetic */ void access$100(DevicePickerFragment r0, int r1, boolean r2) {
        r0.updateContent(r1, r2);
    }

    static /* synthetic */ boolean access$202(DevicePickerFragment r0, boolean r1) {
        r0.stopScanForNoNecessary = r1;
        return r1;
    }

    static /* synthetic */ BluetoothCategory access$300(DevicePickerFragment r0) {
        return r0.mAvailableDevicesCategory;
    }

    static /* synthetic */ boolean access$400(DevicePickerFragment r0, String r1) {
        return r0.startScanning(r1);
    }

    static /* synthetic */ Handler access$500(DevicePickerFragment r0) {
        return r0.mScanHandler;
    }

    public DevicePickerFragment() {
        this.stopScanForNoNecessary = false;
        this.mReceiver = new AnonymousClass1(this);
        this.mScanHandler = new AnonymousClass2(this);
    }

    private void updateContent(int r4, boolean r5) {
        PreferenceScreen r6 = getPreferenceScreen();
        if (this._mActivity == null) goto L5;
        Activity r0 = this._mActivity;
    L6:
        if (r0 != null) goto L9;
        OLog.e(TAG, "updateContent, activity is null, return");
        return;
    L9:
        int r1 = 0;
        switch(r4) {
            case 10: goto L27;
            case 11: goto L26;
            case 12: goto L13;
            case 13: goto L12;
            default: goto L28;
        };
    L12:
        r1 = R.string.bluetooth_turning_off;
        goto L28
    L13:
        r6.removeAll();
        r6.setOrderingAsAdded(true);
        this.mDevicePreferenceMap.clear();
        PreferenceGroup r7 = this.mPairedDevicesCategory;
        if (r7 != null) goto L16;
        this.mPairedDevicesCategory = new BluetoothCategory(r0, this.mIsLandScreen, false, false);
    L17:
        addDeviceCategory(this.mPairedDevicesCategory, R.string.bluetooth_preference_paired_devices, BluetoothDeviceFilter.BONDED_DEVICE_FILTER);
        int r8 = this.mPairedDevicesCategory.getPreferenceCount();
        BluetoothCategory r2 = this.mAvailableDevicesCategory;
        if (r2 != null) goto L20;
        BluetoothCategory r3 = new BluetoothCategory(r0, this.mIsLandScreen);
        this.mAvailableDevicesCategory = r3;
        r3.setOnClickListener(new AnonymousClass3(this));
    L21:
        addDeviceCategory(this.mAvailableDevicesCategory, R.string.bluetooth_preference_found_devices, BluetoothDeviceFilter.UNBONDED_DEVICE_FILTER);
        this.mAvailableDevicesCategory.getPreferenceCount();
        if (r8 != 0) goto L24;
        r6.removePreference(this.mPairedDevicesCategory);
    L24:
        getPreferenceScreen().addPreference(this.mAvailableDevicesCategory);
        return;
    L20:
        r2.removeAll();
        goto L21
    L16:
        r7.removeAll();
        goto L17
    L26:
        r1 = R.string.bluetooth_turning_on;
        goto L28
    L27:
        r1 = R.string.bytedance_bluetooth_empty_list_bluetooth_off;
    L28:
        setDeviceListGroup(r6);
        removeAllDevices();
        addFakePreferenceAsTips(r0, r1);
        r0.invalidateOptionsMenu();
        return;
    L5:
        r0 = getActivity();
        goto L6
    }

    private void addDeviceCategory(PreferenceGroup r1, int r2, BluetoothDeviceFilter.Filter r3) {
        r1.setTitle(r2);
        getPreferenceScreen().addPreference(r1);
        setFilter(r3);
        setMoreFilter(2);
        setDeviceListGroup(r1);
        addCachedDevices();
        r1.setEnabled(true);
    }

    @Override // com.android.settings.bluetooth.DeviceListPreferenceFragment
    void addPreferencesForActivity() {
        addPreferencesFromResource(R.xml.device_picker);
        Intent r0 = getActivity().getIntent();
        this.mNeedAuth = com.android.settings.Utils.getBooleanExtraSafely(r0, "android.bluetooth.devicepicker.extra.NEED_AUTH", false);
        setFilter(r0.getIntExtra("android.bluetooth.devicepicker.extra.FILTER_TYPE", 0));
        this.mLaunchPackage = r0.getStringExtra("android.bluetooth.devicepicker.extra.LAUNCH_PACKAGE");
        this.mLaunchClass = r0.getStringExtra("android.bluetooth.devicepicker.extra.DEVICE_PICKER_LAUNCH_CLASS");
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r6) {
        super.onActivityCreated(r6);
        if (r6 != null) goto L5;
        boolean r7 = true;
    L6:
        this.mActivityStarted = r7;
        getActivity().getLayoutInflater();
        getResources().getDimensionPixelSize(R.dimen.list_item_vertical_gap);
        getResources().getDimensionPixelSize(R.dimen.hidden_bottom_padding);
        RecyclerView r8 = getListView();
        r8.setItemAnimator(null);
        r8.setPadding(r8.getPaddingLeft(), com.android.settings.Utils.dp2Pixels(getActivity(), 112.0f), r8.getPaddingRight(), r8.getPaddingBottom());
        r8.setOverScrollMode(0);
        r8.setScrollBarStyle(0);
        r8.setClipChildren(false);
        r8.setClipToPadding(false);
        ViewParent r9 = r8.getParent();
        if ((r9 instanceof FrameLayout) == false) goto L10;
        ((FrameLayout) r9).addView(getTouchCallbackFrameLayout());
        return;
    L10:
        return;
    L5:
        r7 = false;
        goto L6
    }

    private TouchCallbackFrameLayout getTouchCallbackFrameLayout() {
        TouchCallbackFrameLayout r0 = new TouchCallbackFrameLayout(this.mContext);
        r0.addOnTouchListener(new DevicePickerFragment$$ExternalSyntheticLambda0(this));
        return r0;
    }

    /* JADX INFO: renamed from: lambda$getTouchCallbackFrameLayout$0$com-android-settings-bluetooth-DevicePickerFragment, reason: not valid java name */
    /* synthetic */ boolean m362xa659cc7(View r4, MotionEvent r5) {
        this.stopScanForNoNecessary = false;
        this.mScanHandler.removeMessages(5);
        this.mScanHandler.sendEmptyMessageDelayed(5, this.autoStopDuration);
        if (this.mLocalAdapter.isDiscovering() == true) goto L5;
        startScanning("touch");
    L5:
        return false;
    }

    @Override // com.android.settings.bluetooth.DeviceListPreferenceFragment, androidx.fragment.app.Fragment
    public void onAttach(Context r1) {
        super.onAttach(r1);
        this.mContext = r1;
    }

    public void com_android_settings_bluetooth_DevicePickerFragment__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        getActivity().setTitle(getString(R.string.device_picker));
        UserManager r3 = (UserManager) this.mContext.getSystemService(PickApplicationActivity.EXTRA_USER);
        String r4 = PasswordUtils.getCallingAppPackageName(getActivity().getActivityToken());
        this.mCallingAppPackageName = r4;
        if (TextUtils.equals(r4, this.mLaunchPackage) == true) goto L5;
        OLog.w(TAG, "sendDevicePickedIntent() launch package name is not equivalent to calling package name!");
    L5:
        this.mDeviceSelected = false;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        if (this.mScanHandler.hasMessages(4) == true) goto L6;
        this.mScanHandler.sendEmptyMessageDelayed(4, 50);
        return;
    }

    public void com_android_settings_bluetooth_DevicePickerFragment__onResume$___twin___() {
        super.onResume();
        IntentFilter r0 = new IntentFilter();
        this.mIntentFilter = r0;
        r0.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(getActivity(), this.mReceiver, this.mIntentFilter, 2);
        setDeviceListGroupTag(Utils.TAG_DEVICE_LIST_GROUP_PICKER);
        if (this.mScanHandler.hasMessages(4) == true) goto L6;
        Handler r1 = this.mScanHandler;
        r1.sendMessage(r1.obtainMessage(4));
    L6:
        if (((LocalBluetoothManager) NullSafe.nonNull(LocalBluetoothManager.getInstance(getActivity()))).getProfileManager().isProfilesProcessConnection() == true) goto L9;
        startScanning("visible");
    L9:
        if (this.mLocalAdapter.isEnabled() == false) goto L11;
        this.mScanHandler.sendEmptyMessage(6);
    L11:
        this.stopScanForNoNecessary = false;
        this.mScanHandler.sendEmptyMessageDelayed(5, this.autoStopDuration);
    }

    @Override // com.android.settings.bluetooth.DeviceListPreferenceFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        RegisterUtils.unRegisterBroadcastReceiverSafely(TAG, getActivity(), this.mReceiver);
        finish();
        this.mScanHandler.removeMessages(5);
        this.mScanHandler.removeMessages(7);
        this.mScanHandler.removeMessages(6);
    }

    @Override // com.android.settings.bluetooth.DeviceListPreferenceFragment
    protected void finish() {
        super.finish();
        OLog.d(TAG, "DevicePickerFragment finish");
    }

    @Override // com.android.settings.bluetooth.DeviceListPreferenceFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mDeviceSelected == true) goto L6;
        sendDevicePickedIntent(null);
        return;
    }

    @Override // com.android.settings.bluetooth.DeviceListPreferenceFragment
    void onDevicePreferenceClick(BluetoothDevicePreference r3) {
        this.mLocalAdapter.stopScanning();
        LocalBluetoothPreferences.persistSelectedDeviceInPicker(getActivity(), this.mSelectedDevice.getAddress());
        if (r3.getCachedDevice().getBondState() != 12) goto L5;
    L8:
        sendDevicePickedIntent(this.mSelectedDevice);
        this.mDeviceSelected = true;
        finish();
        return;
    L5:
        if (this.mNeedAuth == false) goto L8;
        super.onDevicePreferenceClick(r3);
    }

    @Override // com.android.settings.bluetooth.BluetoothCallback
    public void onDeviceBondStateChanged(CachedBluetoothDevice r2, int r3) {
        if (r3 != 12) goto L9;
        BluetoothDevice r4 = r2.getDevice();
        if (r4.equals(this.mSelectedDevice) == false) goto L7;
        sendDevicePickedIntent(r4);
        finish();
    L7:
        setupDevicePreferenceBackground();
        return;
    }

    @Override // com.android.settings.bluetooth.DeviceListPreferenceFragment, com.android.settings.bluetooth.BluetoothCallback
    public void onBluetoothStateChanged(int r2) {
        super.onBluetoothStateChanged(r2);
        if (r2 != 12) goto L5;
        this.mLocalAdapter.startScanning(false);
    L5:
        setupDevicePreferenceBackground();
    }

    @Override // com.android.settings.bluetooth.DeviceListPreferenceFragment, com.android.settings.bluetooth.BluetoothCallback
    public void onScanningStateChanged(boolean r1) {
        super.onScanningStateChanged(r1);
        getActivity().invalidateOptionsMenu();
    }

    private boolean startScanning(String r4) {
        OLog.i(TAG, String.format("startScanning  scene:%s enabled:%s stopScanForNoNecessary:%s mPaused:%s", new Object[]{r4, Boolean.valueOf(this.mLocalAdapter.isEnabled()), Boolean.valueOf(this.stopScanForNoNecessary), Boolean.valueOf(this.mPaused)}));
        if (this.mLocalAdapter.isEnabled() == true) goto L5;
    L20:
        return false;
    L5:
        if (this.stopScanForNoNecessary == true) goto L20;
        if (this.mPaused == true) goto L20;
        BluetoothCategory r5 = this.mAvailableDevicesCategory;
        if (r5 == null) goto L19;
        if (r5.isShowLoadingView() == true) goto L19;
        if (this.mScanHandler.hasMessages(6) == true) goto L19;
        if (this.mScanHandler.hasMessages(7) == true) goto L19;
        OLog.i(TAG, "restart refresh loading animation");
        this.mScanHandler.sendEmptyMessage(6);
    L19:
        return this.mLocalAdapter.startScanning();
    }

    private void sendDevicePickedIntent(BluetoothDevice r3) {
        Intent r0 = new Intent("android.bluetooth.devicepicker.action.DEVICE_SELECTED");
        r0.putExtra("android.bluetooth.device.extra.DEVICE", r3);
        String r4 = this.mLaunchPackage;
        if (r4 != null) goto L5;
    L9:
        r0.addFlags(268435456);
        this.mContext.sendBroadcast(r0, "android.permission.BLUETOOTH_ADMIN");
        return;
    L5:
        if (this.mLaunchClass == null) goto L9;
        if (TextUtils.equals(this.mCallingAppPackageName, r4) == false) goto L9;
        r0.setClassName(this.mLaunchPackage, this.mLaunchClass);
        goto L9
    }

    @Override // com.android.settings.bluetooth.DeviceListPreferenceFragment
    protected void setupDevicePreferenceBackground() {
        setupBackground(this.mPairedDevicesCategory, true);
        setupBackground(this.mAvailableDevicesCategory, false);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_bluetooth_DevicePickerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(DevicePickerFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_bluetooth_DevicePickerFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_bluetooth_DevicePickerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(DevicePickerFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_bluetooth_DevicePickerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_bluetooth_DevicePickerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(DevicePickerFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_bluetooth_DevicePickerFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
