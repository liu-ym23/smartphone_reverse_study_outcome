package com.android.settings.fuelgauge;

import android.app.usage.UsageStatsManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class InactiveApps extends SettingsPreferenceFragment implements Preference.OnPreferenceClickListener {
    private UsageStatsManager mUsageStats;

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_fuelgauge_InactiveApps_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_fuelgauge_InactiveApps_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public InactiveApps() {
    }

    public void com_android_settings_fuelgauge_InactiveApps__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        this.mUsageStats = (UsageStatsManager) getActivity().getSystemService(UsageStatsManager.class);
        addPreferencesFromResource(R.xml.inactive_apps);
    }

    public void com_android_settings_fuelgauge_InactiveApps__onResume$___twin___() {
        super.onResume();
        init();
    }

    private void init() {
        PreferenceScreen r0 = getPreferenceScreen();
        r0.removeAll();
        r0.setOrderingAsAdded(false);
        FragmentActivity r2 = getActivity();
        PackageManager r3 = r2.getPackageManager();
        UsageStatsManager r4 = (UsageStatsManager) r2.getSystemService(UsageStatsManager.class);
        Intent r5 = new Intent("android.intent.action.MAIN");
        r5.addCategory("android.intent.category.LAUNCHER");
        Iterator<ResolveInfo> r1 = r3.queryIntentActivities(r5, 0).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ResolveInfo r6 = r1.next();
        String r7 = r6.activityInfo.applicationInfo.packageName;
        Preference r8 = new Preference(getPrefContext());
        r8.setTitle(r6.loadLabel(r3));
        r8.setIcon(r6.loadIcon(r3));
        r8.setKey(r7);
        updateSummary(r8);
        r8.setOnPreferenceClickListener(this);
        r0.addPreference(r8);
        goto L4
    }

    private void updateSummary(Preference r2) {
        if (this.mUsageStats.isAppInactive(r2.getKey()) == false) goto L5;
        int r1 = R.string.inactive_app_inactive_summary;
    L6:
        r2.setSummary(r1);
        return;
    L5:
        r1 = R.string.inactive_app_active_summary;
        goto L6
    }

    @Override // androidx.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference r4) {
        String r0 = r4.getKey();
        UsageStatsManager r1 = this.mUsageStats;
        r1.setAppInactive(r0, !r1.isAppInactive(r0));
        updateSummary(r4);
        return false;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_fuelgauge_InactiveApps_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(InactiveApps r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_fuelgauge_InactiveApps__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fuelgauge_InactiveApps_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(InactiveApps r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_fuelgauge_InactiveApps_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fuelgauge_InactiveApps_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(InactiveApps r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_fuelgauge_InactiveApps__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
