package com.android.settings.applications;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import androidx.preference.Preference;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.search.Indexable;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class AdvancedAppSettings extends SettingsPreferenceFragment implements com.android.settingslib.applications.ApplicationsState.Callbacks, Indexable {
    private static final String KEY_APP_DOMAIN_URLS = "domain_urls";
    private static final String KEY_APP_PERM = "manage_perms";
    private static final String KEY_HIGH_POWER_APPS = "high_power_apps";
    private static final String KEY_SYSTEM_ALERT_WINDOW = "system_alert_window";
    private static final String KEY_WRITE_SETTINGS_APPS = "write_settings_apps";
    public static final Indexable.SearchIndexProvider SEARCH_INDEX_DATA_PROVIDER = null;
    static final String TAG = "AdvancedAppSettings";
    private Preference mAppDomainURLsPreference;
    private Preference mAppPermsPreference;
    private Preference mHighPowerPreference;
    private BroadcastReceiver mPermissionReceiver;
    private com.android.settingslib.applications.ApplicationsState.Session mSession;
    private Preference mSystemAlertWindowPreference;
    private Preference mWriteSettingsPreference;

    public void com_android_settings_applications_AdvancedAppSettings__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onAllSizesComputed() {
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applications_AdvancedAppSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onLauncherInfoChanged() {
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onLoadEntriesCompleted() {
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onPackageIconChanged() {
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onPackageListChanged() {
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onPackageSizeChanged(String r1) {
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onRebuildComplete(ArrayList<com.android.settingslib.applications.ApplicationsState.AppEntry> r1) {
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applications_AdvancedAppSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onRunningStateChanged(boolean r1) {
    }

    public AdvancedAppSettings() {
    }

    public void com_android_settings_applications_AdvancedAppSettings__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        addPreferencesFromResource(R.xml.advanced_apps);
        getPreferenceScreen().findPreference(KEY_APP_PERM).setIntent(new Intent("android.intent.action.MANAGE_PERMISSIONS"));
        this.mSession = com.android.settingslib.applications.ApplicationsState.getInstance(getActivity().getApplication()).newSession(this);
        this.mAppPermsPreference = findPreference(KEY_APP_PERM);
        this.mAppDomainURLsPreference = findPreference(KEY_APP_DOMAIN_URLS);
        this.mHighPowerPreference = findPreference(KEY_HIGH_POWER_APPS);
        this.mSystemAlertWindowPreference = findPreference(KEY_SYSTEM_ALERT_WINDOW);
        this.mWriteSettingsPreference = findPreference(KEY_WRITE_SETTINGS_APPS);
    }

    static {
        SEARCH_INDEX_DATA_PROVIDER = new AnonymousClass1();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_AdvancedAppSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AdvancedAppSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_AdvancedAppSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_AdvancedAppSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AdvancedAppSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applications_AdvancedAppSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_AdvancedAppSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AdvancedAppSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_AdvancedAppSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
