package com.android.settings.location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.UserHandle;
import android.os.UserManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Switch;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;
import com.GlobalProxyLancet;
import com.android.settings.DimmableIconPreference;
import com.android.settings.MultiSDKAdapter;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settings.R;
import com.android.settings.SettingsActivity;
import com.android.settings.Utils;
import com.android.settings.applications.InstalledAppDetails;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.android.settings.widget.SwitchBar;
import com.android.settingslib.RestrictedLockUtils;
import com.android.settingslib.RestrictedSwitchPreference;
import com.android.settingslib.location.RecentLocationApps;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class LocationSettings extends LocationSettingsBase implements SwitchBar.OnSwitchChangeListener {
    private static final String KEY_LOCATION_MODE = "location_mode";
    private static final String KEY_LOCATION_SERVICES = "location_services";
    private static final String KEY_MANAGED_PROFILE_SWITCH = "managed_profile_location_switch";
    private static final String KEY_RECENT_LOCATION_REQUESTS = "recent_location_requests";
    private static final int MENU_SCANNING = 1;
    private static final String TAG = "LocationSettings";
    private SettingsInjector injector;
    private PreferenceCategory mCategoryRecentLocationRequests;
    private Preference mLocationMode;
    private UserHandle mManagedProfile;
    private RestrictedSwitchPreference mManagedProfileSwitch;
    private Preference.OnPreferenceClickListener mManagedProfileSwitchClickListener;
    private BroadcastReceiver mReceiver;
    private Switch mSwitch;
    private SwitchBar mSwitchBar;
    private UserManager mUm;
    private boolean mValidListener;

    private class PackageEntryClickedListener implements Preference.OnPreferenceClickListener {
        private String mPackage;
        private UserHandle mUserHandle;
        final /* synthetic */ LocationSettings this$0;

        public PackageEntryClickedListener(LocationSettings r1, String r2, UserHandle r3) {
            this.this$0 = r1;
            this.mPackage = r2;
            this.mUserHandle = r3;
        }

        @Override // androidx.preference.Preference.OnPreferenceClickListener
        public boolean onPreferenceClick(Preference r7) {
            Bundle r2 = new Bundle();
            r2.putString("package", this.mPackage);
            ((SettingsActivity) this.this$0.getActivity()).startPreferencePanelAsUser(InstalledAppDetails.class.getName(), r2, R.string.application_info_label, null, this.mUserHandle);
            return true;
        }
    }

    private static int getLocationString(int r1) {
        if (r1 != 0) goto L4;
        return R.string.location_mode_location_off_title;
    L4:
        if (r1 != 1) goto L6;
        return R.string.location_mode_sensors_only_title;
    L6:
        if (r1 != 2) goto L8;
        return R.string.location_mode_battery_saving_title;
    L8:
        if (r1 == 3) goto L11;
        return 0;
    L11:
        return R.string.location_mode_high_accuracy_title;
    }

    public void com_android_settings_location_LocationSettings__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment
    public int getHelpResource() {
        return R.string.help_url_location_access;
    }

    @Override // com.android.settings.location.LocationSettingsBase, com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_location_LocationSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.location.LocationSettingsBase, com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_location_LocationSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public LocationSettings() {
        this.mValidListener = false;
        this.mManagedProfileSwitchClickListener = new AnonymousClass5(this);
    }

    static /* synthetic */ SettingsInjector access$000(LocationSettings r0) {
        return r0.injector;
    }

    static /* synthetic */ RestrictedSwitchPreference access$100(LocationSettings r0) {
        return r0.mManagedProfileSwitch;
    }

    static /* synthetic */ UserHandle access$200(LocationSettings r0) {
        return r0.mManagedProfile;
    }

    static /* synthetic */ UserManager access$300(LocationSettings r0) {
        return r0.mUm;
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r2) {
        super.onActivityCreated(r2);
        SettingsActivity r3 = (SettingsActivity) getActivity();
        this.mUm = (UserManager) r3.getSystemService(PickApplicationActivity.EXTRA_USER);
        setHasOptionsMenu(true);
        SwitchBar r4 = r3.getSwitchBar();
        this.mSwitchBar = r4;
        this.mSwitch = r4.getSwitch();
        this.mSwitchBar.show();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mSwitchBar.hide();
    }

    public void com_android_settings_location_LocationSettings__onResume$___twin___() {
        super.onResume();
        createPreferenceHierarchy();
        if (this.mValidListener == true) goto L6;
        this.mSwitchBar.addOnSwitchChangeListener(this);
        this.mValidListener = true;
        return;
    }

    @Override // com.android.settings.location.LocationSettingsBase, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onPause() {
        unregisterReceiver(this.mReceiver);
        if (this.mValidListener == false) goto L5;
        this.mSwitchBar.removeOnSwitchChangeListener(this);
        this.mValidListener = false;
    L5:
        super.onPause();
    }

    private void addPreferencesSorted(List<Preference> r2, PreferenceGroup r3) {
        Collections.sort(r2, new AnonymousClass1(this));
        Iterator<Preference> r1 = r2.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r3.addPreference(r1.next());
        goto L4
    }

    static List<Preference> sortPreferencesSorted(List<Preference> r1) {
        Collections.sort(r1, new AnonymousClass2());
        return r1;
    }

    private PreferenceScreen createPreferenceHierarchy() {
        final SettingsActivity r0 = (SettingsActivity) getActivity();
        PreferenceScreen r1 = getPreferenceScreen();
        if (r1 == null) goto L5;
        r1.removeAll();
    L5:
        addPreferencesFromResource(R.xml.location_settings);
        PreferenceScreen r2 = getPreferenceScreen();
        setupManagedProfileCategory(r2);
        Preference r3 = r2.findPreference(KEY_LOCATION_MODE);
        this.mLocationMode = r3;
        r3.setOnPreferenceClickListener(new AnonymousClass3(this, r0));
        this.mCategoryRecentLocationRequests = (PreferenceCategory) r2.findPreference(KEY_RECENT_LOCATION_REQUESTS);
        List<RecentLocationApps.Request> r4 = MultiSDKAdapterNew.getAppList(new RecentLocationApps(r0));
        List<Preference> r5 = new ArrayList(r4.size());
        Iterator<RecentLocationApps.Request> r6 = r4.iterator();
    L7:
        if (r6.hasNext() == false) goto L13;
        RecentLocationApps.Request r7 = r6.next();
        Preference r8 = new DimmableIconPreference(getPrefContext(), r7.contentDescription);
        r8.setIcon(r7.icon);
        r8.setTitle(r7.label);
        if (r7.isHighBattery == false) goto L11;
        r8.setSummary(R.string.location_high_battery_use);
    L12:
        r8.setOnPreferenceClickListener(new PackageEntryClickedListener(this, r7.packageName, r7.userHandle));
        r5.add(r8);
        goto L7
    L11:
        r8.setSummary(R.string.location_low_battery_use);
        goto L12
    L13:
        boolean r9 = false;
        if (r4.size() <= 0) goto L16;
        addPreferencesSorted(r5, this.mCategoryRecentLocationRequests);
    L17:
        UserHandle r10 = this.mManagedProfile;
        if (r10 != null) goto L20;
    L22:
        addLocationServices(r0, r2, r9);
        refreshLocationMode();
        return r2;
    L20:
        if (this.mUm.hasUserRestriction("no_share_location", r10) == false) goto L22;
        r9 = true;
        goto L22
    L16:
        Preference r11 = new Preference(getPrefContext());
        r11.setLayoutResource(R.layout.location_list_no_item);
        r11.setTitle(R.string.location_no_recent_apps);
        r11.setSelectable(false);
        this.mCategoryRecentLocationRequests.addPreference(r11);
        goto L17
    }

    private void setupManagedProfileCategory(PreferenceScreen r4) {
        UserHandle r0 = Utils.getManagedProfile(this.mUm);
        this.mManagedProfile = r0;
        if (r0 != null) goto L5;
        r4.removePreference(r4.findPreference(KEY_MANAGED_PROFILE_SWITCH));
        this.mManagedProfileSwitch = null;
        return;
    L5:
        RestrictedSwitchPreference r5 = (RestrictedSwitchPreference) r4.findPreference(KEY_MANAGED_PROFILE_SWITCH);
        this.mManagedProfileSwitch = r5;
        r5.setOnPreferenceClickListener(null);
    }

    private void changeManagedProfileLocationAccessStatus(boolean r4) {
        RestrictedSwitchPreference r0 = this.mManagedProfileSwitch;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setOnPreferenceClickListener(null);
        RestrictedLockUtils.EnforcedAdmin r1 = MultiSDKAdapterNew.checkIfRestrictionEnforced(getActivity(), "no_share_location", this.mManagedProfile.getIdentifier());
        boolean r2 = isManagedProfileRestrictedByBase();
        if (r2 == true) goto L9;
        if (r1 == null) goto L9;
        this.mManagedProfileSwitch.setDisabledByAdmin(r1);
        this.mManagedProfileSwitch.setChecked(false);
        return;
    L9:
        this.mManagedProfileSwitch.setEnabled(r4);
        int r3 = R.string.switch_off_text;
        if (r4 == true) goto L12;
        this.mManagedProfileSwitch.setChecked(false);
    L17:
        this.mManagedProfileSwitch.setSummary(r3);
        return;
    L12:
        this.mManagedProfileSwitch.setChecked(!r2);
        if (r2 == true) goto L16;
        r3 = R.string.switch_on_text;
    L16:
        this.mManagedProfileSwitch.setOnPreferenceClickListener(this.mManagedProfileSwitchClickListener);
        goto L17
    }

    private void addLocationServices(Context r5, PreferenceScreen r6, boolean r7) {
        PreferenceCategory r0 = (PreferenceCategory) NullSafe.nonNull(r6.findPreference(KEY_LOCATION_SERVICES));
        SettingsInjector r1 = new SettingsInjector(r5);
        this.injector = r1;
        if (r7 == false) goto L5;
        int r8 = UserHandle.myUserId();
    L6:
        List<Preference> r9 = r1.getInjectedSettings(r8);
        this.mReceiver = new AnonymousClass4(this);
        IntentFilter r2 = new IntentFilter();
        r2.addAction("android.location.InjectedSettingChanged");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r5, this.mReceiver, r2, 2);
        if (r0 != null) goto L9;
    L11:
        r6.removePreference(r0);
        return;
    L9:
        if (r9.size() <= 0) goto L11;
        addPreferencesSorted(r9, r0);
        return;
    L5:
        r8 = -2;
        goto L6
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu r4, MenuInflater r5) {
        r4.add(0, 1, 0, R.string.location_menu_scanning);
        super.onCreateOptionsMenu(r4, r5);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem r10) {
        SettingsActivity r1 = (SettingsActivity) getActivity();
        if (r1 != null) goto L7;
        return super.onOptionsItemSelected(r10);
    L7:
        if (r10.getItemId() != 1) goto L9;
        r1.startPreferencePanel(ScanningSettings.class.getName(), null, R.string.location_scanning_screen_title, null, this, 0);
        return true;
    L9:
        return super.onOptionsItemSelected(r10);
    }

    @Override // com.android.settings.location.LocationSettingsBase
    public void onModeChanged(int r7, boolean r8) {
        int r0 = getLocationString(r7);
        if (r0 == 0) goto L5;
        this.mLocationMode.setSummary(r0);
    L5:
        boolean r1 = false;
        if (r7 == 0) goto L8;
        boolean r9 = true;
    L9:
        RestrictedLockUtils.EnforcedAdmin r2 = MultiSDKAdapterNew.checkIfRestrictionEnforced(getActivity(), "no_share_location", UserHandle.myUserId());
        if (MultiSDKAdapterNew.hasBaseUserRestriction(getActivity(), "no_share_location", UserHandle.myUserId()) == true) goto L13;
        if (r2 == null) goto L13;
        this.mSwitchBar.setDisabledByAdmin(r2);
    L14:
        Preference r3 = this.mLocationMode;
        if (r9 == false) goto L18;
        if (r8 == true) goto L18;
        r1 = true;
    L18:
        r3.setEnabled(r1);
        this.mCategoryRecentLocationRequests.setEnabled(r9);
        if (r9 != this.mSwitch.isChecked()) goto L21;
    L26:
        changeManagedProfileLocationAccessStatus(r9);
        this.injector.reloadStatusMessages();
        return;
    L21:
        if (this.mValidListener == false) goto L23;
        this.mSwitchBar.removeOnSwitchChangeListener(this);
    L23:
        this.mSwitch.setChecked(r9);
        if (this.mValidListener == false) goto L26;
        this.mSwitchBar.addOnSwitchChangeListener(this);
    L13:
        this.mSwitchBar.setEnabled(!r8);
        goto L14
    L8:
        r9 = false;
        goto L9
    }

    @Override // com.android.settings.widget.SwitchBar.OnSwitchChangeListener
    public void onSwitchChanged(Switch r1, boolean r2) {
        if (r2 == false) goto L4;
        setLocationMode(MultiSDKAdapter.getLocationMode());
        return;
    L4:
        setLocationMode(0);
    }

    private boolean isManagedProfileRestrictedByBase() {
        UserHandle r0 = this.mManagedProfile;
        if (r0 != null) goto L7;
        return false;
    L7:
        return this.mUm.hasBaseUserRestriction("no_share_location", r0);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_location_LocationSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(LocationSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_location_LocationSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_location_LocationSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(LocationSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_location_LocationSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_location_LocationSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(LocationSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_location_LocationSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
