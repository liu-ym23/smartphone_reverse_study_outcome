package com.android.settings.applications;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.TimeUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import com.android.settings.R;
import com.android.settings.SettingsActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ProcessStatsUi extends ProcessStatsBase {
    public static final int[] BACKGROUND_AND_SYSTEM_PROC_STATES = null;
    static final boolean DEBUG = false;
    public static final int[] FOREGROUND_PROC_STATES = null;
    private static final String KEY_APP_LIST = "app_list";
    private static final int MENU_SHOW_AVG = 1;
    private static final int MENU_SHOW_MAX = 2;
    static final String TAG = "ProcessStatsUi";
    static final Comparator<ProcStatsPackageEntry> sMaxPackageEntryCompare = null;
    static final Comparator<ProcStatsPackageEntry> sPackageEntryCompare = null;
    private PreferenceGroup mAppListGroup;
    private MenuItem mMenuAvg;
    private MenuItem mMenuMax;
    private PackageManager mPm;
    private boolean mShowMax;

    public void com_android_settings_applications_ProcessStatsUi__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.applications.ProcessStatsBase, com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applications_ProcessStatsUi_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.applications.ProcessStatsBase, com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applications_ProcessStatsUi_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ProcessStatsUi() {
    }

    public void com_android_settings_applications_ProcessStatsUi__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        this.mPm = getActivity().getPackageManager();
        addPreferencesFromResource(R.xml.process_stats_ui);
        this.mAppListGroup = (PreferenceGroup) findPreference(KEY_APP_LIST);
        setHasOptionsMenu(true);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu r3, MenuInflater r4) {
        super.onCreateOptionsMenu(r3, r4);
        this.mMenuAvg = r3.add(0, 1, 0, R.string.sort_avg_use);
        this.mMenuMax = r3.add(0, 2, 0, R.string.sort_max_use);
        updateMenu();
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem r4) {
        int r0 = r4.getItemId();
        if (r0 != 1) goto L5;
    L8:
        this.mShowMax = !this.mShowMax;
        refreshUi();
        updateMenu();
        return true;
    L5:
        if (r0 == 2) goto L8;
        return super.onOptionsItemSelected(r4);
    }

    private void updateMenu() {
        this.mMenuMax.setVisible(!this.mShowMax);
        this.mMenuAvg.setVisible(this.mShowMax);
    }

    @Override // com.android.settings.applications.ProcessStatsBase, com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r1) {
        super.onSaveInstanceState(r1);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference r5) {
        if ((r5 instanceof ProcessStatsPreference) == true) goto L6;
        return false;
    L6:
        ProcStatsData.MemInfo r1 = this.mStatsManager.getMemInfo();
        launchMemoryDetail((SettingsActivity) getActivity(), r1, ((ProcessStatsPreference) r5).getEntry(), true);
        return super.onPreferenceTreeClick(r5);
    }

    static {
        BACKGROUND_AND_SYSTEM_PROC_STATES = new int[]{0, 5, 6, 7, 11, 8, 9, 10, 12};
        FOREGROUND_PROC_STATES = new int[]{1};
        sPackageEntryCompare = new AnonymousClass1();
        sMaxPackageEntryCompare = new AnonymousClass2();
    }

    public static String makeDuration(long r2) {
        StringBuilder r0 = new StringBuilder(32);
        TimeUtils.formatDuration(r2, r0);
        return r0.toString();
    }

    @Override // com.android.settings.applications.ProcessStatsBase
    public void refreshUi() {
        this.mAppListGroup.removeAll();
        int r2 = 0;
        this.mAppListGroup.setOrderingAsAdded(false);
        PreferenceGroup r1 = this.mAppListGroup;
        if (this.mShowMax == false) goto L5;
        int r3 = R.string.maximum_memory_use;
    L6:
        r1.setTitle(r3);
        FragmentActivity r4 = getActivity();
        ProcStatsData.MemInfo r5 = this.mStatsManager.getMemInfo();
        List<ProcStatsPackageEntry> r6 = this.mStatsManager.getEntries();
        int r7 = r6.size();
        int r8 = 0;
    L7:
        if (r8 >= r7) goto L10;
        r6.get(r8).updateMetrics();
        r8 = r8 + 1;
        goto L7
    L10:
        if (this.mShowMax == false) goto L12;
        Comparator<ProcStatsPackageEntry> r9 = sMaxPackageEntryCompare;
    L13:
        Collections.sort(r6, r9);
        if (this.mShowMax == false) goto L16;
        double r10 = r5.realTotalRam;
    L18:
        if (r2 >= r6.size()) goto L20;
        ProcStatsPackageEntry r11 = r6.get(r2);
        ProcessStatsPreference r14 = new ProcessStatsPreference(getPrefContext());
        r11.retrieveUiData(r4, this.mPm);
        r14.init(r11, this.mPm, r10, r5.weightToRam, r5.totalScale, !this.mShowMax);
        r14.setOrder(r2);
        this.mAppListGroup.addPreference(r14);
        r2 = r2 + 1;
        r4 = r4;
        goto L18
    L20:
        return;
    L16:
        r10 = r5.usedWeight * r5.weightToRam;
        goto L18
    L12:
        r9 = sPackageEntryCompare;
        goto L13
    L5:
        r3 = R.string.average_memory_use;
        goto L6
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_ProcessStatsUi_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ProcessStatsUi r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_ProcessStatsUi__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_ProcessStatsUi_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ProcessStatsUi r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applications_ProcessStatsUi_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_ProcessStatsUi_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ProcessStatsUi r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_ProcessStatsUi__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
