package com.android.settings.bluetooth;

import android.app.AlertDialog;
import android.app.Dialog;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.preference.CheckBoxPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment23;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public final class DeviceProfilesSettings extends SettingsPreferenceFragment23 implements CachedBluetoothDevice.Callback, Preference.OnPreferenceChangeListener {
    public static final String ARG_DEVICE_ADDRESS = "device_address";
    public static final String EXTRA_DEVICE = "device";
    private static final String KEY_PROFILE_CONTAINER = "profile_container";
    private static final String KEY_RENAME_DEVICE = "rename_device";
    private static final String KEY_UNPAIR = "unpair";
    private static final int OK_BUTTON = -1;
    private static final String TAG = "DeviceProfilesSettings";
    private final HashMap<LocalBluetoothProfile, CheckBoxPreference> mAutoConnectPrefs;
    private CachedBluetoothDevice mCachedDevice;
    private DeviceProfileRenamePreference mDeviceNamePref;
    private AlertDialog mDisconnectDialog;
    private LocalBluetoothManager mManager;
    private PreferenceGroup mProfileContainer;
    private boolean mProfileGroupIsRemoved;
    private TextView mProfileLabel;
    private LocalBluetoothProfileManager mProfileManager;
    private RenameEditTextPreference mRenameDeviceNamePref;
    private View mRootView;

    private class RenameEditTextPreference implements TextWatcher {
        final /* synthetic */ DeviceProfilesSettings this$0;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        private RenameEditTextPreference(DeviceProfilesSettings r1) {
            this.this$0 = r1;
        }

        /* synthetic */ RenameEditTextPreference(DeviceProfilesSettings r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r2) {
            if (DeviceProfilesSettings.access$000(this.this$0) != null) goto L5;
            return;
        L5:
            Dialog r1 = DeviceProfilesSettings.access$000(this.this$0).getDialog();
            if ((r1 instanceof AlertDialog) == false) goto L13;
            Button r3 = ((AlertDialog) r1).getButton(-1);
            if (r2.length() <= 0) goto L10;
            boolean r4 = true;
        L11:
            r3.setEnabled(r4);
            return;
        L10:
            r4 = false;
            goto L11
        }
    }

    private CheckBox findProfile(String r1) {
        return null;
    }

    private void showOrHideProfileGroup() {
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_bluetooth_DeviceProfilesSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_bluetooth_DeviceProfilesSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public DeviceProfilesSettings() {
        this.mAutoConnectPrefs = new HashMap();
    }

    static /* synthetic */ DeviceProfileRenamePreference access$000(DeviceProfilesSettings r0) {
        return r0.mDeviceNamePref;
    }

    public void com_android_settings_bluetooth_DeviceProfilesSettings__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        if (r4 == null) goto L5;
        BluetoothDevice r5 = (BluetoothDevice) r4.getParcelable("device");
    L6:
        addPreferencesFromResource(R.xml.bluetooth_device_advanced);
        getPreferenceScreen().setOrderingAsAdded(false);
        this.mProfileContainer = (PreferenceGroup) findPreference(KEY_PROFILE_CONTAINER);
        this.mDeviceNamePref = (DeviceProfileRenamePreference) findPreference(KEY_RENAME_DEVICE);
        if (r5 != null) goto L10;
        OLog.w(TAG, "Activity started without a remote Bluetooth device");
        finish();
        return;
    L10:
        this.mRenameDeviceNamePref = new RenameEditTextPreference(this, null);
        LocalBluetoothManager r1 = LocalBluetoothManager.getInstance(getActivity());
        this.mManager = r1;
        if (r1 == null) goto L13;
        CachedBluetoothDeviceManager r2 = r1.getCachedDeviceManager();
        this.mProfileManager = this.mManager.getProfileManager();
        this.mCachedDevice = r2.findDevice(r5);
    L13:
        CachedBluetoothDevice r6 = this.mCachedDevice;
        if (r6 != null) goto L17;
        OLog.w(TAG, "Device not found, cannot connect to it");
        finish();
        return;
    L17:
        String r7 = r6.getName();
        DeviceProfileRenamePreference r0 = this.mDeviceNamePref;
        if (r0 == null) goto L20;
        r0.setTitle(R.string.bluetooth_device_name);
        this.mDeviceNamePref.setSubtitle(r7);
        this.mDeviceNamePref.setOnPreferenceChangeListener(this);
    L20:
        addPreferencesForProfiles();
        return;
    L5:
        r5 = (BluetoothDevice) ((Bundle) getActivity().getIntent().getExtras().getParcelable("device")).getParcelable("device");
        goto L6
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r1) {
        super.onActivityCreated(r1);
        RecyclerView r0 = getListView();
        r0.setPadding(0, 0, 0, 0);
        r0.setOverScrollMode(0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        AlertDialog r0 = this.mDisconnectDialog;
        if (r0 == null) goto L6;
        r0.dismiss();
        this.mDisconnectDialog = null;
        return;
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r2) {
        super.onSaveInstanceState(r2);
        CachedBluetoothDevice r1 = this.mCachedDevice;
        if (r1 == null) goto L6;
        r2.putParcelable("device", r1.getDevice());
        return;
    }

    public void com_android_settings_bluetooth_DeviceProfilesSettings__onResume$___twin___() {
        super.onResume();
        this.mManager.setForegroundActivity(getActivity());
        CachedBluetoothDevice r0 = this.mCachedDevice;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.registerCallback(this);
        if (this.mCachedDevice.getBondState() != 10) goto L8;
        finish();
    L8:
        refresh();
        DeviceProfileRenamePreference r1 = this.mDeviceNamePref;
        if (r1 != null) goto L11;
        return;
    L11:
        EditText r2 = r1.getEditText();
        this.mDeviceNamePref.setText(this.mCachedDevice.getName());
        if (r2 == null) goto L21;
        r2.addTextChangedListener(this.mRenameDeviceNamePref);
        Dialog r3 = this.mDeviceNamePref.getDialog();
        if ((r3 instanceof AlertDialog) == false) goto L22;
        Button r4 = ((AlertDialog) r3).getButton(-1);
        if (r2.getText().length() <= 0) goto L18;
        boolean r5 = true;
    L19:
        r4.setEnabled(r5);
        return;
    L18:
        r5 = false;
        goto L19
    L22:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        CachedBluetoothDevice r0 = this.mCachedDevice;
        if (r0 == null) goto L5;
        r0.unregisterCallback(this);
    L5:
        this.mManager.setForegroundActivity(null);
    }

    private void addPreferencesForProfiles() {
        CachedBluetoothDevice r0 = this.mCachedDevice;
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<LocalBluetoothProfile> r1 = r0.getConnectableProfiles().iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        CheckBoxPreference r2 = createProfilePreference(r1.next());
        this.mProfileContainer.addPreference(r2);
        goto L7
    L9:
        showOrHideProfileGroup();
    }

    private CheckBoxPreference createProfilePreference(LocalBluetoothProfile r4) {
        CheckBoxPreference r0 = new CheckBoxPreference(getActivity());
        r0.setKey(r4.toString());
        CachedBluetoothDevice r1 = this.mCachedDevice;
        if (r1 != null) goto L5;
        return r0;
    L5:
        r0.setTitle(r4.getNameResource(r1.getDevice()));
        r0.setPersistent(false);
        r0.setOnPreferenceChangeListener(this);
        int r2 = r4.getDrawableResource(this.mCachedDevice.getBtClass());
        if (r2 == 0) goto L8;
        r0.setIcon(getResources().getDrawable(r2));
    L8:
        r0.setEnabled(!this.mCachedDevice.isBusy());
        refreshProfilePreference(r0, r4);
        return r0;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference r3) {
        if (r3.getKey().equals(KEY_UNPAIR) == false) goto L7;
        unpairDevice();
        finish();
        return true;
    L7:
        return super.onPreferenceTreeClick(r3);
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference r2, Object r3) {
        if (r2 != this.mDeviceNamePref) goto L10;
        CachedBluetoothDevice r1 = this.mCachedDevice;
        if (r1 == null) goto L13;
        r1.setAliasName((String) r3);
        return true;
    L13:
        return true;
    L10:
        if ((r2 instanceof CheckBoxPreference) == false) goto L12;
        onProfileClicked(getProfileOf(r2), (CheckBoxPreference) r2);
    L12:
        return false;
    }

    private void onProfileClicked(LocalBluetoothProfile r6, CheckBoxPreference r7) {
        CachedBluetoothDevice r0 = this.mCachedDevice;
        if (r0 != null) goto L5;
        return;
    L5:
        BluetoothDevice r1 = r0.getDevice();
        if (r6.getConnectionStatus(r1) != 2) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        askDisconnect(getActivity(), r6);
        return;
    L12:
        if (r6.isPreferred(r1) == true) goto L14;
        r6.setPreferred(r1, true);
        this.mCachedDevice.connectProfile(r6);
    L18:
        refreshProfilePreference(r7, r6);
        return;
    L14:
        if ((r6 instanceof PanProfile) == false) goto L16;
        this.mCachedDevice.connectProfile(r6);
        goto L18
    L16:
        r6.setPreferred(r1, false);
        goto L18
    L8:
        r2 = false;
        goto L9
    }

    private void askDisconnect(Context r9, LocalBluetoothProfile r10) {
        CachedBluetoothDevice r0 = this.mCachedDevice;
        if (r0 != null) goto L5;
        return;
    L5:
        String r1 = r0.getName();
        if (TextUtils.isEmpty(r1) == false) goto L8;
        r1 = r9.getString(R.string.bluetooth_device);
    L8:
        String r11 = r9.getString(r10.getNameResource(r0.getDevice()));
        String r6 = r9.getString(R.string.bluetooth_disable_profile_title);
        String r12 = r9.getString(R.string.bluetooth_disable_profile_message, new Object[]{r11, r1});
        this.mDisconnectDialog = Utils.showDisconnectDialog(r9, this.mDisconnectDialog, new AnonymousClass1(this), null, r6, Html.fromHtml(r12));
    }

    @Override // com.android.settings.bluetooth.CachedBluetoothDevice.Callback
    public void onDeviceAttributesChanged(boolean r1) {
        refresh();
    }

    private void refresh() {
        CachedBluetoothDevice r0 = this.mCachedDevice;
        if (r0 != null) goto L5;
        return;
    L5:
        String r1 = r0.getName();
        DeviceProfileRenamePreference r2 = this.mDeviceNamePref;
        if (r2 == null) goto L8;
        r2.setSubtitle(r1);
    L8:
        refreshProfiles();
    }

    private void refreshProfiles() {
        CachedBluetoothDevice r0 = this.mCachedDevice;
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<LocalBluetoothProfile> r1 = r0.getConnectableProfiles().iterator();
    L7:
        if (r1.hasNext() == false) goto L12;
        LocalBluetoothProfile r2 = r1.next();
        CheckBoxPreference r3 = (CheckBoxPreference) findPreference(r2.toString());
        if (r3 == null) goto L10;
        refreshProfilePreference(r3, r2);
        goto L7
    L10:
        this.mProfileContainer.addPreference(createProfilePreference(r2));
        goto L7
    L12:
        Iterator<LocalBluetoothProfile> r4 = this.mCachedDevice.getRemovedProfiles().iterator();
    L14:
        if (r4.hasNext() == false) goto L18;
        LocalBluetoothProfile r5 = r4.next();
        Preference r6 = findPreference(r5.toString());
        if (r6 == null) goto L14;
        OLog.d(TAG, "Removing " + r5.toString() + " from profile list");
        this.mProfileContainer.removePreference(r6);
        goto L14
    L18:
        showOrHideProfileGroup();
    }

    private void refreshProfilePreference(CheckBoxPreference r4, LocalBluetoothProfile r5) {
        CachedBluetoothDevice r0 = this.mCachedDevice;
        if (r0 != null) goto L5;
        return;
    L5:
        BluetoothDevice r1 = r0.getDevice();
        boolean r2 = true;
        r4.setEnabled(!this.mCachedDevice.isBusy());
        if ((r5 instanceof PanProfile) == true) goto L8;
        r4.setChecked(r5.isPreferred(r1));
    L13:
        r4.setSummary(r5.getSummaryResourceForDevice(r1));
        return;
    L8:
        if (r5.getConnectionStatus(r1) == 2) goto L11;
        r2 = false;
    L11:
        r4.setChecked(r2);
        goto L13
    }

    private LocalBluetoothProfile getProfileOf(Preference r3) {
        if ((r3 instanceof CheckBoxPreference) == true) goto L5;
        return null;
    L5:
        String r4 = r3.getKey();
        if (TextUtils.isEmpty(r4) == false) goto L13;
        return null;
    L13:
        LocalBluetoothProfileManager r2 = this.mProfileManager;     // Catch: IllegalArgumentException -> L12
        if (r2 == null) goto L15;
        return r2.getProfileByName(r4);
    L15:
        return null;
    L16:
        return null;
    }

    private void unpairDevice() {
        CachedBluetoothDevice r0 = this.mCachedDevice;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.unpair();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_bluetooth_DeviceProfilesSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(DeviceProfilesSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_bluetooth_DeviceProfilesSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_bluetooth_DeviceProfilesSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(DeviceProfilesSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_bluetooth_DeviceProfilesSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_bluetooth_DeviceProfilesSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(DeviceProfilesSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_bluetooth_DeviceProfilesSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
