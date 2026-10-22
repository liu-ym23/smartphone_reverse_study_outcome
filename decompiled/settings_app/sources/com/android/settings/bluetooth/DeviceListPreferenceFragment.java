package com.android.settings.bluetooth;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceGroup;
import com.android.settings.SettingsApplication;
import com.android.settings.about.DeviceUtils;
import com.android.settings.utils.HanziToPinyin;
import com.android.settings.utils.SLog;
import com.android.settings.widget.FakePreference;
import com.android.settings.wifi.preference.SectionLayoutPreference;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import obric.bluetooth.SmartBluetoothBinderClient;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DeviceListPreferenceFragment extends PreferenceFragmentCompat implements BluetoothCallback, BluetoothDevicePreference.OnGetDeviceViewListener {
    private static final short DEVICE_AVAILABLE_RSSI = -65;
    private static final String KEY_BT_DEVICE_LIST = "bt_device_list";
    private static final String KEY_BT_SCAN = "bt_scan";
    protected static final String SCENE_TOUCH = "touch";
    private String TAG;
    protected Activity _mActivity;
    protected long autoStopDuration;
    private boolean isAddCachedDevices;
    protected SmartBluetoothBinderClient mBluetoothBinderClient;
    protected Context mContext;
    protected PreferenceGroup mDeviceListGroup;
    final WeakHashMap<CachedBluetoothDevice, BluetoothDevicePreference> mDevicePreferenceMap;
    private BluetoothDeviceFilter.Filter mFilter;
    private String mGroupTag;
    private Handler mHandler;
    protected ArrayList<BluetoothDevice> mHiddenCachedDevices;
    protected boolean mIsLandScreen;
    LocalBluetoothAdapter mLocalAdapter;
    LocalBluetoothManager mLocalManager;
    private Object mLock;
    private BluetoothDeviceFilter.Filter mMoreFilter;
    protected boolean mPaused;
    BluetoothDevice mSelectedDevice;

    abstract void addPreferencesForActivity();

    void initDevicePreference(BluetoothDevicePreference r1) {
    }

    public boolean onGetDeviceViewVisible() {
        return false;
    }

    public void onScanningStateChanged(boolean r1) {
    }

    protected void setupDevicePreferenceBackground() {
    }

    protected void showOtherDevice(boolean r1) {
    }

    static /* synthetic */ Object access$000(DeviceListPreferenceFragment r0) {
        return r0.mLock;
    }

    DeviceListPreferenceFragment() {
        this.TAG = getClass().getSimpleName();
        this.mLock = new Object();
        this.mPaused = false;
        this.autoStopDuration = TimeUnit.MINUTES.toMillis(1);
        this.mHiddenCachedDevices = new ArrayList();
        this.mIsLandScreen = false;
        this.mDevicePreferenceMap = new WeakHashMap();
        this.mHandler = new AnonymousClass1(this);
        this.mFilter = BluetoothDeviceFilter.ALL_FILTER;
        this.mMoreFilter = BluetoothDeviceFilter.ALL_FILTER;
    }

    final void setFilter(BluetoothDeviceFilter.Filter r4) {
        this.mFilter = r4;
        OLog.d(this.TAG, "setFilter: " + r4.toString() + HanziToPinyin.Token.SEPARATOR + hashCode());
    }

    final void setFilter(int r1) {
        this.mFilter = BluetoothDeviceFilter.getFilter(r1);
    }

    final void setMoreFilter(int r1) {
        this.mMoreFilter = BluetoothDeviceFilter.getFilter(r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context r1) {
        super.onAttach(r1);
        this.mContext = r1;
        this._mActivity = getActivity();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        this.mLocalManager = LocalBluetoothManager.getInstance(getActivity());
        this.mBluetoothBinderClient = new SmartBluetoothBinderClient(getActivity());
        LocalBluetoothManager r3 = this.mLocalManager;
        if (r3 != null) goto L6;
        OLog.e(this.TAG, "Bluetooth is not supported on this device");
        return;
    L6:
        this.mLocalAdapter = r3.getBluetoothAdapter();
        addPreferencesForActivity();
        this.mDeviceListGroup = (PreferenceCategory) findPreference(KEY_BT_DEVICE_LIST);
        this.mLocalManager.getEventManager().registerCallback(this);
        if (this.mContext.getResources().getConfiguration().orientation != 2) goto L9;
        boolean r4 = true;
    L10:
        this.mIsLandScreen = r4;
        return;
    L9:
        r4 = false;
        goto L10
    }

    void setDeviceListGroup(PreferenceGroup r1) {
        this.mDeviceListGroup = r1;
    }

    void setDeviceListGroupTag(String r4) {
        OLog.d(this.TAG, "Set the setDeviceListGroupTag " + r4);
        this.mGroupTag = r4;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mPaused = false;
        LocalBluetoothManager r0 = this.mLocalManager;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setForegroundActivity(getActivity());
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mPaused = true;
        if (this.mLocalManager != null) goto L5;
        return;
    L5:
        this.mLocalAdapter.stopScanning();
        this.mLocalManager.setForegroundActivity(null);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        removeOorDevices();
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mGroupTag == null) goto L5;
        removeAllDevices();
        removeCachedDevices();
    L5:
        this.mLocalManager.getEventManager().unregisterCallback(this);
        this.mBluetoothBinderClient.close();
    }

    ArrayList<BluetoothDevice> getHidenDevices() {
        String r0 = this.mGroupTag;
        if (r0 == null) goto L9;
        if (r0.equals(Utils.TAG_DEVICE_LIST_GROUP_SETTING) == false) goto L9;
        return this.mHiddenCachedDevices;
    L9:
        return new ArrayList();
    }

    void removeCachedDevices() {
        LocalBluetoothManager r0 = this.mLocalManager;
        if (r0 == null) goto L6;
        r0.getCachedDeviceManager().clearCachedDevices();
        return;
    }

    void removeAllDevices() {
        this.mLocalAdapter.stopScanning();
        WeakHashMap<CachedBluetoothDevice, BluetoothDevicePreference> r0 = this.mDevicePreferenceMap;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        PreferenceGroup r1 = this.mDeviceListGroup;
        if (r1 == null) goto L8;
        removeItemPreference(r1);
    L8:
        this.mHiddenCachedDevices.clear();
        showOtherDevice(false);
    }

    void addFakePreferenceAsTips(Context r2, int r3) {
        PreferenceGroup r1 = this.mDeviceListGroup;
        if (r1 == null) goto L6;
        r1.addPreference(new FakePreference(r2, r3).update());
        return;
    }

    void addFakePreferenceAsTips(Context r2, CharSequence r3) {
        PreferenceGroup r1 = this.mDeviceListGroup;
        if (r1 == null) goto L6;
        r1.addPreference(new FakePreference(r2, r3).update());
        return;
    }

    void addCachedDevices() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PreferenceGroup r1 = this.mDeviceListGroup;     // Catch: Throwable -> L14
        if (r1 == null) goto L7;
        removeItemPreference(r1);     // Catch: Throwable -> L14
    L7:
        Collection<CachedBluetoothDevice> r2 = this.mLocalManager.getCachedDeviceManager().getCachedDevicesCopy();     // Catch: Throwable -> L14
        this.isAddCachedDevices = true;     // Catch: Throwable -> L14
        Iterator<CachedBluetoothDevice> r3 = r2.iterator();     // Catch: Throwable -> L14
    L9:
        if (r3.hasNext() == false) goto L11;
        onDeviceAdded(r3.next());     // Catch: Throwable -> L14
        goto L9
    L11:
        setupDevicePreferenceBackground();     // Catch: Throwable -> L14
        this.isAddCachedDevices = false;     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    void removeOorDevices() {
        Iterator<CachedBluetoothDevice> r0 = this.mLocalManager.getCachedDeviceManager().getCachedDevicesCopy().iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        CachedBluetoothDevice r1 = r0.next();
        if (r1.getBondState() != 10) goto L4;
        if (r1.isVisible() == true) goto L4;
        OLog.d(this.TAG, "Device Removed " + r1);
        BluetoothDevicePreference r2 = this.mDevicePreferenceMap.get(r1);
        if (r2 == null) goto L12;
        this.mDeviceListGroup.removePreference(r2);
    L12:
        this.mDevicePreferenceMap.remove(r1);
        r1.setRemovable(true);
        goto L4
    L13:
        Object r3 = this.mLock;
        monitor-enter(r3);
        setupDevicePreferenceBackground();     // Catch: Throwable -> L18
        monitor-exit(r3);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference r3) {
        if (KEY_BT_SCAN.equals(r3.getKey()) == false) goto L7;
        this.mLocalAdapter.startScanning(true);
        return true;
    L7:
        if ((r3 instanceof BluetoothDevicePreference) == false) goto L11;
        BluetoothDevicePreference r4 = (BluetoothDevicePreference) r3;
        this.mSelectedDevice = r4.getCachedDevice().getDevice();
        onDevicePreferenceClick(r4);
        return true;
    L11:
        return super.onPreferenceTreeClick(r3);
    }

    void onDevicePreferenceClick(BluetoothDevicePreference r3) {
        OLog.d(this.TAG, "onDevicePreferenceClick: " + r3.getCachedDevice().getName());
        r3.onClicked();
    }

    boolean isRssiAddDevice(CachedBluetoothDevice r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.getBtClass() != null) goto L8;
        return false;
    L8:
        if (r3.mRssi >= (-70)) goto L10;
        return false;
    L10:
        if (2 != r3.getDevice().getType()) goto L12;
        return false;
    L12:
        if (r3.getBtClass().getMajorDeviceClass() == 7936) goto L14;
    L15:
        return true;
    L14:
        if (r3.getName().equals(r3.getDevice().getAddress()) == false) goto L15;
        return false;
    }

    boolean shouldHideDevice(CachedBluetoothDevice r1) {
        return Utils.shouldDiscardDevice(r1);
    }

    boolean shouldDiscardDevice(CachedBluetoothDevice r4) {
        if (r4 != null) goto L5;
    L17:
        return false;
    L5:
        if (r4.getBtClass() == null) goto L17;
        if (r4.getBtClass().getMajorDeviceClass() != 7936) goto L17;
        if (r4.getName() == null) goto L14;
        if (r4.getName().equals(r4.getDevice().getAddress()) == false) goto L17;
    L14:
        if (r4.getBondState() == 12) goto L17;
        SLog.d(this.TAG, "device : " + r4 + " is discarded.");
        return true;
    }

    public void onDeviceAdded(CachedBluetoothDevice r9) {
        String r0 = this.TAG;
        StringBuilder r1 = new StringBuilder("onDeviceAdded, ").append(buildDeviceDebugInfo(r9)).append(", groupTag=").append(this.mGroupTag).append(", localState=").append(this.mLocalAdapter.getBluetoothState()).append(", deviceListGroup=");
        PreferenceGroup r4 = this.mDeviceListGroup;
        if (r4 != null) goto L5;
        CharSequence r5 = "null";
    L6:
        OLog.d(r0, r1.append(r5).toString());
        if (isAdded() == true) goto L10;
        OLog.d(this.TAG, "onDeviceAdded: ignore, fragment not added");
        return;
    L10:
        if (r9 != null) goto L13;
        OLog.d(this.TAG, "onDeviceAdded: ignore, cachedDevice is null");
        return;
    L13:
        BluetoothDevicePreference r2 = this.mDevicePreferenceMap.get(r9);
        if (r2 == null) goto L18;
        OLog.d(this.TAG, "onDeviceAdded: device already added, updateAttributes, " + buildDeviceDebugInfo(r9));
        r2.onDeviceAttributesChanged(false);
        return;
    L18:
        if (this.mLocalAdapter.getBluetoothState() == 12) goto L21;
        OLog.d(this.TAG, "onDeviceAdded: ignore, bluetooth is not STATE_ON, " + buildDeviceDebugInfo(r9) + ", localState=" + this.mLocalAdapter.getBluetoothState());
        return;
    L21:
        checkLocalName();
        String r3 = this.mGroupTag;
        if (r3 != null) goto L24;
    L33:
        String r6 = this.mGroupTag;
        if (r6 != null) goto L36;
    L45:
        OLog.d(this.TAG, "onDeviceAdded: ignore, unsupported groupTag, " + buildDeviceDebugInfo(r9) + ", groupTag=" + this.mGroupTag);
        return;
    L36:
        if (r6.equals(Utils.TAG_DEVICE_LIST_GROUP_PICKER) == false) goto L45;
        boolean r7 = this.mFilter.matches(r9.getDevice());
        boolean r8 = this.mMoreFilter.matches(r9.getDevice());
        OLog.d(this.TAG, "onDeviceAdded: picker group filters, " + buildDeviceDebugInfo(r9) + ", filterMatched=" + r7 + ", moreFilterMatched=" + r8);
        if (r7 == false) goto L44;
        if (r8 == false) goto L44;
        if (Utils.shouldDiscardDevice(r9) == false) goto L43;
        OLog.d(this.TAG, "onDeviceAdded: discard, uncategorized unnamed device, " + buildDeviceDebugInfo(r9));
        return;
    L43:
        OLog.d(this.TAG, "onDeviceAdded: add, normal picker group, " + buildDeviceDebugInfo(r9));
        createDevicePreference(r9);
        return;
    L44:
        OLog.d(this.TAG, "onDeviceAdded: ignore, filter not matched, " + buildDeviceDebugInfo(r9));
        return;
    L24:
        if (r3.equals(Utils.TAG_DEVICE_LIST_GROUP_SETTING) == false) goto L33;
        boolean r10 = this.mFilter.matches(r9.getDevice());
        boolean r11 = this.mMoreFilter.matches(r9.getDevice());
        OLog.d(this.TAG, "onDeviceAdded: setting group filters, " + buildDeviceDebugInfo(r9) + ", filterMatched=" + r10 + ", moreFilterMatched=" + r11);
        if (r10 == false) goto L32;
        if (r11 == false) goto L32;
        if (Utils.shouldDiscardDevice(r9) == false) goto L31;
        OLog.d(this.TAG, "onDeviceAdded: hide, shouldHideDevice matched, " + buildDeviceDebugInfo(r9));
        this.mHiddenCachedDevices.add(r9.getDevice());
        showOtherDevice(true);
        return;
    L31:
        OLog.d(this.TAG, "onDeviceAdded: add, normal setting group, " + buildDeviceDebugInfo(r9));
        createDevicePreference(r9);
        return;
    L32:
        OLog.d(this.TAG, "onDeviceAdded: ignore, filter not matched, " + buildDeviceDebugInfo(r9));
        return;
    L5:
        r5 = r4.getTitle();
        goto L6
    }

    private String buildDeviceDebugInfo(CachedBluetoothDevice r3) {
        return "address=" + r3.getDevice().getAddress() + ", name=" + r3.getName();
    }

    private void checkLocalName() {
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

    void createDevicePreference(CachedBluetoothDevice r13) {
        if (this.mDeviceListGroup != null) goto L5;
        return;
    L5:
        Object r3 = this.mLock;
        monitor-enter(r3);
        BluetoothDevicePreference r11 = new BluetoothDevicePreference(getActivity(), r13, this.mHandler, new AnonymousClass2(this), this.mBluetoothBinderClient, this.mDeviceListGroup);     // Catch: Throwable -> L18
        r11.setOnGetDeviceViewListener(this);     // Catch: Throwable -> L18
        initDevicePreference(r11);     // Catch: Throwable -> L18
        OLog.d(this.TAG, "createDevicePreference: " + r13.getName());     // Catch: Throwable -> L18
        String r2 = this.mGroupTag;     // Catch: Throwable -> L18
        if (r2 != null) goto L10;
    L12:
        OLog.d(this.TAG, "mGroupTag = " + this.mGroupTag);     // Catch: Throwable -> L18
        r11.setSummary(null);     // Catch: Throwable -> L18
        r11.setProfileButtonVisible(false);     // Catch: Throwable -> L18
    L13:
        this.mDeviceListGroup.addPreference(r11);     // Catch: Throwable -> L18
        this.mDevicePreferenceMap.put(r13, r11);     // Catch: Throwable -> L18
        if (this.isAddCachedDevices == true) goto L16;
        setupDevicePreferenceBackground();     // Catch: Throwable -> L18
    L16:
        monitor-exit(r3);     // Catch: Throwable -> L18
        return;
    L10:
        if (r2.equals(Utils.TAG_DEVICE_LIST_GROUP_SETTING) == false) goto L12;
        OLog.d(this.TAG, "mGroupTag = " + this.mGroupTag);     // Catch: Throwable -> L18
        r11.setProfileButtonVisible(true);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    void setupBackground(PreferenceGroup r6, boolean r7) {
        if (r6 != null) goto L4;
        return;
    L4:
        Object r5 = this.mLock;
        monitor-enter(r5);
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L31
        int r1 = 0;
        int r2 = 0;
    L8:
        if (r2 >= r6.getPreferenceCount()) goto L13;
        Preference r3 = r6.getPreference(r2);     // Catch: Throwable -> L31
        if ((r3 instanceof BluetoothDevicePreference) == true) goto L12;
        r0.add(r3);     // Catch: Throwable -> L31
    L12:
        r2 = r2 + 1;     // Catch: Throwable -> L31
        goto L8
    L13:
        Iterator r4 = r0.iterator();     // Catch: Throwable -> L31
    L15:
        if (r4.hasNext() == false) goto L17;
        r6.removePreference((Preference) r4.next());     // Catch: Throwable -> L31
        goto L15
    L17:
        int r8 = r6.getPreferenceCount();     // Catch: Throwable -> L31
    L18:
        if (r1 >= r8) goto L29;
        BluetoothDevicePreference r9 = (BluetoothDevicePreference) r6.getPreference(r1);     // Catch: Throwable -> L31
        r9.setPair(r7);     // Catch: Throwable -> L31
        if (r1 != 0) goto L22;
        r9.setKey("TOP");     // Catch: Throwable -> L31
    L23:
        if (r7 == false) goto L26;
        r9.refresh();     // Catch: Throwable -> L31
    L26:
        if ((r6 instanceof BluetoothProgressCategory) == false) goto L28;
        r9.setSummary(null);     // Catch: Throwable -> L31
    L28:
        r1 = r1 + 1;     // Catch: Throwable -> L31
        goto L18
    L22:
        r9.setKey("");     // Catch: Throwable -> L31
        goto L23
    L29:
        monitor-exit(r5);     // Catch: Throwable -> L31
        return;
    L31:
        th = move-exception;
        throw th;
    }

    void printGroup(PreferenceGroup r6, String r7) {
        if (r6 != null) goto L4;
        return;
    L4:
        monitor-enter(r6);
        int r0 = r6.getPreferenceCount();     // Catch: Throwable -> L10
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L8;
        OLog.d(this.TAG, "printGroup " + r7 + "; devicePreference: " + r1 + " address: " + ((BluetoothDevicePreference) r6.getPreference(r1)).getCachedDevice().getDevice().getAddress() + " name: " + ((BluetoothDevicePreference) r6.getPreference(r1)).getCachedDevice().getName());     // Catch: Throwable -> L10
        r1 = r1 + 1;     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r6);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.android.settings.bluetooth.BluetoothCallback
    public void onDeviceDeleted(CachedBluetoothDevice r5) {
        BluetoothDevicePreference r0 = this.mDevicePreferenceMap.remove(r5);
        if (r0 == null) goto L5;
        OLog.d(this.TAG, "onDeviceDeleted: " + r5.getName() + "remove: " + this.mDeviceListGroup.removePreference(r0));
    L5:
        Object r6 = this.mLock;
        monitor-enter(r6);
        setupDevicePreferenceBackground();     // Catch: Throwable -> L10
        monitor-exit(r6);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void onBluetoothStateChanged(int r2) {
        if (r2 == 12) goto L5;
        return;
    L5:
        if (DeviceUtils.INSTANCE.isDeviceNameEdit() == true) goto L7;
        return;
    L7:
        if (this.mLocalAdapter == null) goto L14;
        String r3 = com.android.settings.Utils.getDeviceName(SettingsApplication.getContext());
        if (r3.equals(this.mLocalAdapter.getName()) == true) goto L15;
        this.mLocalAdapter.setName(r3);
        return;
    L15:
        return;
    }

    protected void finish() {
        FragmentActivity r0 = getActivity();
        if (isAdded() == false) goto L8;
        if (r0 == null) goto L9;
        r0.onBackPressed();
        com.android.settings.Utils.hideInputMethod(r0);
        OLog.d(this.TAG, this.TAG + " finish");
        return;
    L9:
        return;
    }

    protected void removeItemPreference(PreferenceGroup r5) {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= r5.getPreferenceCount()) goto L9;
        Preference r2 = r5.getPreference(r1);
        if ((r2 instanceof SectionLayoutPreference) == true) goto L8;
        r0.add(r2);
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        Iterator r3 = r0.iterator();
    L11:
        if (r3.hasNext() == false) goto L17;
        Preference r4 = (Preference) r3.next();
        r5.removePreference(r4);
        if ((r4 instanceof BluetoothDevicePreference) == false) goto L11;
        CachedBluetoothDevice r6 = ((BluetoothDevicePreference) r4).getCachedDevice();
        if (r6 == null) goto L11;
        this.mDevicePreferenceMap.remove(r6);
        goto L11
    }
}
