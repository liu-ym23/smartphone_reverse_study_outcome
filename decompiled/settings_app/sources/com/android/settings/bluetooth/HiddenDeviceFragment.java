package com.android.settings.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.android.settings.R;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.UIUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class HiddenDeviceFragment extends PreferenceFragmentCompat implements BluetoothCallback {
    private static final int LOAD_BATCH_SIZE = 8;
    private final String TAG;
    private CachedBluetoothDeviceManager mCachedDeviceManager;
    private Context mContext;
    private Handler mHandler;
    private ArrayList<BluetoothDevice> mHiddenDevices;
    private PreferenceGroup mHiddenDevicesGroup;
    private RecyclerView mListView;
    private LocalBluetoothManager mLocalManager;
    private Object mLock;
    private int mNextLoadIndex;

    public static /* synthetic */ void $r8$lambda$f7oo3Nlxz2kNe0QAcYwM0yggPMU(HiddenDeviceFragment r0) {
        r0.initDevicePreferences();
    }

    public static /* synthetic */ void $r8$lambda$wk9RINJ2nLqMnX1Xf1N0aiJfgQQ(HiddenDeviceFragment r0) {
        r0.loadNextDevicePreferences();
    }

    public void com_android_settings_bluetooth_HiddenDeviceFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.bluetooth.BluetoothCallback
    public void onBluetoothStateChanged(int r1) {
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_bluetooth_HiddenDeviceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.bluetooth.BluetoothCallback
    public void onDeviceAdded(CachedBluetoothDevice r1) {
    }

    @Override // com.android.settings.bluetooth.BluetoothCallback
    public void onDeviceDeleted(CachedBluetoothDevice r1) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_bluetooth_HiddenDeviceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    @Override // com.android.settings.bluetooth.BluetoothCallback
    public void onScanningStateChanged(boolean r1) {
    }

    public HiddenDeviceFragment() {
        this.TAG = "HiddenDeviceFragment";
        this.mLock = new Object();
        this.mHandler = new AnonymousClass1(this);
    }

    static /* synthetic */ Object access$000(HiddenDeviceFragment r0) {
        return r0.mLock;
    }

    public void com_android_settings_bluetooth_HiddenDeviceFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        FragmentActivity r2 = getActivity();
        this.mContext = r2;
        LocalBluetoothManager r3 = LocalBluetoothManager.getInstance(r2);
        this.mLocalManager = r3;
        this.mCachedDeviceManager = r3.getCachedDeviceManager();
        this.mLocalManager.getEventManager().registerCallback(this);
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle r1, String r2) {
        addPreferencesFromResource(R.xml.device_picker);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View r5, Bundle r6) {
        super.onViewCreated(r5, r6);
        this.mHiddenDevicesGroup = (PreferenceCategory) findPreference("bt_device_list");
        this.mHiddenDevices = getActivity().getIntent().getParcelableArrayListExtra("hiddenlist");
        RecyclerView r7 = getListView();
        this.mListView = r7;
        r7.setItemAnimator(null);
        RecyclerView r8 = this.mListView;
        r8.setPadding(r8.getPaddingLeft(), UIUtils.INSTANCE.dp2px(112), this.mListView.getPaddingRight(), this.mListView.getPaddingBottom());
        this.mListView.setClipChildren(false);
        this.mListView.setClipToPadding(false);
        UIUtils.setUpBottomPaddingOnApplyWindowInsets(this.mListView);
        r5.post(new HiddenDeviceFragment$$ExternalSyntheticLambda1(this));
    }

    private void initDevicePreferences() {
        if (this.mHiddenDevicesGroup != null) goto L6;
        OLog.e("HiddenDeviceFragment", "initDevicePreferences, mHiddenDevicesGroup is null, return");
        return;
    L6:
        ArrayList<BluetoothDevice> r0 = this.mHiddenDevices;
        if (r0 == null) goto L9;
        int r1 = r0.size();
    L10:
        OLog.d("HiddenDeviceFragment", "initDevicePreferences, mHiddenDevices size : " + r1);
        if (r1 != 0) goto L13;
        return;
    L13:
        this.mNextLoadIndex = 0;
        loadNextDevicePreferences();
        return;
    L9:
        r1 = 0;
        goto L10
    }

    private void loadNextDevicePreferences() {
        if (this.mHiddenDevicesGroup == null) goto L27;
        ArrayList<BluetoothDevice> r0 = this.mHiddenDevices;
        if (r0 != null) goto L7;
        return;
    L7:
        if (this.mListView == null) goto L34;
        int r1 = r0.size();
        Object r2 = this.mLock;
        monitor-enter(r2);
        int r3 = Math.min(this.mNextLoadIndex + 8, r1);     // Catch: Throwable -> L24
        int r4 = this.mNextLoadIndex;     // Catch: Throwable -> L24
    L12:
        if (r4 >= r3) goto L14;
        createDevicePreferenceLocked(this.mHiddenDevices.get(r4), r4);     // Catch: Throwable -> L24
        r4 = r4 + 1;     // Catch: Throwable -> L24
        goto L12
    L14:
        this.mNextLoadIndex = r3;     // Catch: Throwable -> L24
        setupBackgroundLocked();     // Catch: Throwable -> L24
        if (this.mNextLoadIndex >= r1) goto L17;
        boolean r5 = true;
    L18:
        monitor-exit(r2);     // Catch: Throwable -> L24
        if (r5 == false) goto L31;
        RecyclerView r6 = this.mListView;
        if (r6 == null) goto L32;
        r6.post(new HiddenDeviceFragment$$ExternalSyntheticLambda0(this));
        return;
    L32:
        return;
    L31:
        return;
    L17:
        r5 = false;
    L24:
        th = move-exception;
        throw th;
    L34:
        return;
    }

    private void createDevicePreferenceLocked(BluetoothDevice r2, int r3) {
        CachedBluetoothDevice r4 = this.mCachedDeviceManager.findDevice(r2);
        if (r4 != null) goto L5;
        return;
    L5:
        createDevicePreferenceLocked(r4, r3);
    }

    private void createDevicePreferenceLocked(CachedBluetoothDevice r9, int r10) {
        BluetoothDevicePreference r7 = new BluetoothDevicePreference(this.mContext, r9, this.mHandler, new AnonymousClass2(this), null, this.mHiddenDevicesGroup);
        r7.setOrder(r10);
        r7.setSummary(null);
        r7.setProfileButtonVisible(false);
        this.mHiddenDevicesGroup.addPreference(r7);
    }

    private void setupBackgroundLocked() {
        int r0 = this.mHiddenDevicesGroup.getPreferenceCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        Preference r2 = this.mHiddenDevicesGroup.getPreference(r1);
        if (r1 != 0) goto L7;
        r2.setKey("TOP");
    L8:
        r2.setSummary(null);
        r1 = r1 + 1;
        goto L3
    L7:
        r2.setKey("");
        goto L8
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference r2) {
        if ((r2 instanceof BluetoothDevicePreference) == false) goto L7;
        onDevicePreferenceClick((BluetoothDevicePreference) r2);
        return true;
    L7:
        return super.onPreferenceTreeClick(r2);
    }

    void onDevicePreferenceClick(BluetoothDevicePreference r1) {
        r1.onClicked();
    }

    void setupBackground() {
        if (this.mHiddenDevicesGroup != null) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mHiddenDevicesGroup.getPreferenceCount();     // Catch: Throwable -> L15
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L13;
        if (r2 != 0) goto L11;
        this.mHiddenDevicesGroup.getPreference(r2).setKey("TOP");     // Catch: Throwable -> L15
    L12:
        this.mHiddenDevicesGroup.getPreference(r2).setSummary(null);     // Catch: Throwable -> L15
        r2 = r2 + 1;     // Catch: Throwable -> L15
        goto L8
    L11:
        this.mHiddenDevicesGroup.getPreference(r2).setKey("");     // Catch: Throwable -> L15
        goto L12
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.android.settings.bluetooth.BluetoothCallback
    public void onDeviceBondStateChanged(CachedBluetoothDevice r3, int r4) {
        if (r4 != 12) goto L11;
        int r5 = 0;
    L6:
        if (r5 >= this.mHiddenDevicesGroup.getPreferenceCount()) goto L15;
        BluetoothDevicePreference r0 = (BluetoothDevicePreference) this.mHiddenDevicesGroup.getPreference(r5);
        if (Objects.equals(r3, r0.getCachedDevice()) == false) goto L10;
        this.mHiddenDevicesGroup.removePreference(r0);
    L10:
        r5 = r5 + 1;
        goto L6
    L15:
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_bluetooth_HiddenDeviceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(HiddenDeviceFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_bluetooth_HiddenDeviceFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_bluetooth_HiddenDeviceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(HiddenDeviceFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_bluetooth_HiddenDeviceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_bluetooth_HiddenDeviceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(HiddenDeviceFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_bluetooth_HiddenDeviceFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
