package com.android.settings.applications;

import android.content.Context;
import android.os.Bundle;
import android.text.format.Formatter;
import androidx.preference.Preference;
import com.android.settings.R;
import com.android.settings.SummaryPreference;
import com.android.settings.Utils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ProcessStatsSummary extends ProcessStatsBase implements Preference.OnPreferenceClickListener {
    private static final String KEY_APP_LIST = "apps_list";
    private static final String KEY_AVERAGY_USED = "average_used";
    private static final String KEY_FREE = "free";
    private static final String KEY_PERFORMANCE = "performance";
    private static final String KEY_STATUS_HEADER = "status_header";
    private static final String KEY_TOTAL_MEMORY = "total_memory";
    private Preference mAppListPreference;
    private Preference mAverageUsed;
    private Preference mFree;
    private Preference mPerformance;
    private SummaryPreference mSummaryPref;
    private Preference mTotalMemory;

    public void com_android_settings_applications_ProcessStatsSummary__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.applications.ProcessStatsBase, com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applications_ProcessStatsSummary_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.applications.ProcessStatsBase, com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applications_ProcessStatsSummary_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ProcessStatsSummary() {
    }

    public void com_android_settings_applications_ProcessStatsSummary__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        addPreferencesFromResource(R.xml.process_stats_summary);
        this.mSummaryPref = (SummaryPreference) findPreference(KEY_STATUS_HEADER);
        int r5 = getContext().getColor(R.color.running_processes_apps_ram);
        this.mSummaryPref.setColors(r5, r5, getContext().getColor(R.color.running_processes_free_ram));
        this.mPerformance = findPreference(KEY_PERFORMANCE);
        this.mTotalMemory = findPreference(KEY_TOTAL_MEMORY);
        this.mAverageUsed = findPreference(KEY_AVERAGY_USED);
        this.mFree = findPreference(KEY_FREE);
        Preference r6 = findPreference(KEY_APP_LIST);
        this.mAppListPreference = r6;
        r6.setOnPreferenceClickListener(this);
    }

    @Override // com.android.settings.applications.ProcessStatsBase
    public void refreshUi() {
        Context r0 = getContext();
        ProcStatsData.MemInfo r1 = this.mStatsManager.getMemInfo();
        double r2 = r1.realUsedRam;
        double r4 = r1.realTotalRam;
        double r6 = r1.realFreeRam;
        long r8 = (long) r2;
        Formatter.BytesResult r3 = Formatter.formatBytes(r0.getResources(), r8, 1);
        long r5 = (long) r4;
        String r11 = Formatter.formatShortFileSize(r0, r5);
        String r7 = Formatter.formatShortFileSize(r0, (long) r6);
        CharSequence[] r12 = getResources().getTextArray(R.array.ram_states);
        int r13 = this.mStatsManager.getMemState();
        if (r13 >= 0) goto L5;
    L7:
        CharSequence r14 = r12[r12.length - 1];
    L8:
        this.mSummaryPref.setAmount(r3.value);
        this.mSummaryPref.setUnits(r3.units);
        float r9 = (float) (r2 / (r6 + r2));
        this.mSummaryPref.setRatios(r9, 0.0f, 1.0f - r9);
        this.mPerformance.setSummary(r14);
        this.mTotalMemory.setSummary(r11);
        this.mAverageUsed.setSummary(Utils.formatPercentage(r8, r5));
        this.mFree.setSummary(r7);
        String r10 = getString(sDurationLabels[this.mDurationIndex]);
        int r15 = this.mStatsManager.getEntries().size();
        this.mAppListPreference.setSummary(getResources().getQuantityString(R.plurals.memory_usage_apps_summary, r15, new Object[]{Integer.valueOf(r15), r10}));
        return;
    L5:
        if (r13 >= (r12.length - 1)) goto L7;
        r14 = r12[r13];
        goto L8
    }

    @Override // androidx.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference r8) {
        if (r8 != this.mAppListPreference) goto L6;
        Bundle r6 = new Bundle();
        r6.putBoolean("transfer_stats", true);
        r6.putInt("duration_index", this.mDurationIndex);
        this.mStatsManager.xferStats();
        startFragment(this, ProcessStatsUi.class.getName(), R.string.app_list_memory_use, 0, r6);
        return true;
    L6:
        return false;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_ProcessStatsSummary_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ProcessStatsSummary r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_ProcessStatsSummary__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_ProcessStatsSummary_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ProcessStatsSummary r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applications_ProcessStatsSummary_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_ProcessStatsSummary_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ProcessStatsSummary r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_ProcessStatsSummary__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
