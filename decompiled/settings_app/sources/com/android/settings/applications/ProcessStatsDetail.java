package com.android.settings.applications;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.format.Formatter;
import android.util.ArrayMap;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import com.android.settings.AppHeader;
import com.android.settings.CancellablePreference;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.SummaryPreference;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ProcessStatsDetail extends SettingsPreferenceFragment {
    public static final String EXTRA_MAX_MEMORY_USAGE = "max_memory_usage";
    public static final String EXTRA_PACKAGE_ENTRY = "package_entry";
    public static final String EXTRA_TOTAL_SCALE = "total_scale";
    public static final String EXTRA_TOTAL_TIME = "total_time";
    public static final String EXTRA_WEIGHT_TO_RAM = "weight_to_ram";
    private static final String KEY_DETAILS_HEADER = "status_header";
    private static final String KEY_FREQUENCY = "frequency";
    private static final String KEY_MAX_USAGE = "max_usage";
    private static final String KEY_PROCS = "processes";
    public static final int MENU_FORCE_STOP = 1;
    private static final String TAG = "ProcessStatsDetail";
    static final Comparator<ProcStatsEntry> sEntryCompare = null;
    static final Comparator<ProcStatsEntry.Service> sServiceCompare = null;
    static final Comparator<PkgService> sServicePkgCompare = null;
    private ProcStatsPackageEntry mApp;
    private DevicePolicyManager mDpm;
    private MenuItem mForceStop;
    private double mMaxMemoryUsage;
    private long mOnePercentTime;
    private PackageManager mPm;
    private PreferenceCategory mProcGroup;
    private final ArrayMap<ComponentName, CancellablePreference> mServiceMap;
    private double mTotalScale;
    private long mTotalTime;
    private double mWeightToRam;

    static class PkgService {
        long mDuration;
        final ArrayList<ProcStatsEntry.Service> mServices;

        PkgService() {
            this.mServices = new ArrayList();
        }
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applications_ProcessStatsDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applications_ProcessStatsDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ProcessStatsDetail() {
        this.mServiceMap = new ArrayMap();
    }

    static /* synthetic */ void access$000(ProcessStatsDetail r0, String r1, String r2) {
        r0.stopService(r1, r2);
    }

    static /* synthetic */ void access$100(ProcessStatsDetail r0, String r1, String r2) {
        r0.doStopService(r1, r2);
    }

    public void com_android_settings_applications_ProcessStatsDetail__onCreate$___twin___(Bundle r5) {
        super.onCreate(r5);
        this.mPm = getActivity().getPackageManager();
        this.mDpm = (DevicePolicyManager) getActivity().getSystemService("device_policy");
        Bundle r6 = getArguments();
        ProcStatsPackageEntry r0 = (ProcStatsPackageEntry) r6.getParcelable(EXTRA_PACKAGE_ENTRY);
        this.mApp = r0;
        r0.retrieveUiData(getActivity(), this.mPm);
        this.mWeightToRam = r6.getDouble(EXTRA_WEIGHT_TO_RAM);
        this.mTotalTime = r6.getLong("total_time");
        this.mMaxMemoryUsage = r6.getDouble(EXTRA_MAX_MEMORY_USAGE);
        this.mTotalScale = r6.getDouble(EXTRA_TOTAL_SCALE);
        this.mOnePercentTime = this.mTotalTime / 100;
        this.mServiceMap.clear();
        createDetails();
        setHasOptionsMenu(true);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        if (this.mApp.mUiTargetApp != null) goto L7;
        finish();
        return;
    L7:
        if (this.mApp.mUiTargetApp == null) goto L9;
        Drawable r5 = this.mApp.mUiTargetApp.loadIcon(this.mPm);
    L10:
        AppHeader.createAppHeader(this, r5, this.mApp.mUiLabel, this.mApp.mPackage, this.mApp.mUiTargetApp.uid);
        return;
    L9:
        r5 = new ColorDrawable(0);
        goto L10
    }

    public void com_android_settings_applications_ProcessStatsDetail__onResume$___twin___() {
        super.onResume();
        checkForceStop();
        updateRunningServices();
    }

    private void updateRunningServices() {
        List<ActivityManager.RunningServiceInfo> r0 = ((ActivityManager) getActivity().getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
        int r1 = this.mServiceMap.size();
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        this.mServiceMap.valueAt(r3).setCancellable(false);
        r3 = r3 + 1;
        goto L3
    L5:
        if (r0 == null) goto L7;
        int r4 = r0.size();
    L8:
        if (r2 >= r4) goto L21;
        ActivityManager.RunningServiceInfo r5 = r0.get(r2);
        if (r5.started == true) goto L15;
        if (r5.clientLabel != 0) goto L15;
    L20:
        r2 = r2 + 1;
    L15:
        if ((r5.flags & 8) != 0) goto L20;
        final ComponentName r6 = r5.service;
        CancellablePreference r7 = this.mServiceMap.get(r6);
        if (r7 == null) goto L20;
        r7.setOnCancelListener(new AnonymousClass1(this, r6));
        r7.setCancellable(true);
        goto L20
    L21:
        return;
    L7:
        r4 = 0;
        goto L8
    }

    private void createDetails() {
        addPreferencesFromResource(R.xml.app_memory_settings);
        this.mProcGroup = (PreferenceCategory) findPreference(KEY_PROCS);
        fillProcessesSection();
        SummaryPreference r0 = (SummaryPreference) findPreference(KEY_DETAILS_HEADER);
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.mApp.mRunWeight <= this.mApp.mBgWeight) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        double r3 = this.mApp.mRunWeight;
    L12:
        double r4 = r3 * this.mWeightToRam;
        float r2 = (float) (r4 / this.mMaxMemoryUsage);
        FragmentActivity r6 = getActivity();
        r0.setRatios(r2, 0.0f, 1.0f - r2);
        Formatter.BytesResult r5 = Formatter.formatBytes(r6.getResources(), (long) r4, 1);
        r0.setAmount(r5.value);
        r0.setUnits(r5.units);
        CharSequence r7 = ProcStatsPackageEntry.getFrequency(Math.max(this.mApp.mRunDuration, this.mApp.mBgDuration) / this.mTotalTime, getActivity());
        Preference r8 = findPreference(KEY_FREQUENCY);
        if (r8 == null) goto L15;
        r8.setSummary(r7);
    L15:
        double r9 = (Math.max(this.mApp.mMaxBgMem, this.mApp.mMaxRunMem) * this.mTotalScale) * 1024.0d;
        Preference r10 = findPreference(KEY_MAX_USAGE);
        if (r10 == null) goto L19;
        r10.setSummary(Formatter.formatShortFileSize(getContext(), (long) r9));
        return;
    L19:
        return;
    L11:
        r3 = this.mApp.mBgWeight;
        goto L12
    L8:
        r1 = false;
        goto L9
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu r3, MenuInflater r4) {
        this.mForceStop = r3.add(0, 1, 0, R.string.force_stop);
        checkForceStop();
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem r2) {
        if (r2.getItemId() == 1) goto L6;
        return false;
    L6:
        killProcesses();
        return true;
    }

    static {
        sEntryCompare = new AnonymousClass2();
        sServiceCompare = new AnonymousClass3();
        sServicePkgCompare = new AnonymousClass4();
    }

    private void fillProcessesSection() {
        this.mProcGroup.removeAll();
        ArrayList r0 = new ArrayList();
        int r2 = 0;
    L4:
        if (r2 >= this.mApp.mEntries.size()) goto L10;
        ProcStatsEntry r3 = this.mApp.mEntries.get(r2);
        if (r3.mPackage.equals("os") == false) goto L8;
        r3.mLabel = r3.mName;
    L9:
        r0.add(r3);
        r2 = r2 + 1;
        goto L4
    L8:
        r3.mLabel = getProcessName(this.mApp.mUiLabel, r3);
        goto L9
    L10:
        Collections.sort(r0, sEntryCompare);
        int r4 = 0;
    L12:
        if (r4 >= r0.size()) goto L15;
        ProcStatsEntry r5 = (ProcStatsEntry) r0.get(r4);
        Preference r6 = new Preference(getPrefContext());
        r6.setTitle(r5.mLabel);
        r6.setSelectable(false);
        r6.setSummary(getString(R.string.memory_use_running_format, new Object[]{Formatter.formatShortFileSize(getActivity(), Math.max((long) (r5.mRunWeight * this.mWeightToRam), (long) (r5.mBgWeight * this.mWeightToRam))), ProcStatsPackageEntry.getFrequency(Math.max(r5.mRunDuration, r5.mBgDuration) / this.mTotalTime, getActivity())}));
        this.mProcGroup.addPreference(r6);
        r4 = r4 + 1;
        goto L12
    L15:
        if (this.mProcGroup.getPreferenceCount() >= 2) goto L22;
        getPreferenceScreen().removePreference(this.mProcGroup);
        return;
    }

    private static String capitalize(String r2) {
        char r0 = r2.charAt(0);
        if (Character.isLowerCase(r0) == true) goto L6;
        return r2;
    L6:
        return Character.toUpperCase(r0) + r2.substring(1);
    }

    private static String getProcessName(String r3, ProcStatsEntry r4) {
        String r0 = r4.mName;
        if (r0.contains(":") == false) goto L7;
        return capitalize(r0.substring(r0.lastIndexOf(58) + 1));
    L7:
        if (r0.startsWith(r4.mPackage) == true) goto L9;
        return r0;
    L9:
        if (r0.length() != r4.mPackage.length()) goto L11;
        return r3;
    L11:
        int r5 = r4.mPackage.length();
        if (r0.charAt(r5) != '.') goto L15;
        r5 = r5 + 1;
    L15:
        return capitalize(r0.substring(r5));
    }

    private void fillServicesSection(ProcStatsEntry r14, PreferenceCategory r15) {
        HashMap r0 = new HashMap();
        ArrayList r1 = new ArrayList();
        int r3 = 0;
    L4:
        if (r3 >= r14.mServices.size()) goto L16;
        String r4 = r14.mServices.keyAt(r3);
        ArrayList<ProcStatsEntry.Service> r5 = r14.mServices.valueAt(r3);
        int r6 = r5.size() - 1;
        PkgService r7 = null;
    L6:
        if (r6 < 0) goto L15;
        ProcStatsEntry.Service r8 = r5.get(r6);
        if (r8.mDuration < this.mOnePercentTime) goto L14;
        if (r7 != null) goto L13;
        r7 = (PkgService) r0.get(r4);
        if (r7 != null) goto L13;
        r7 = new PkgService();
        r0.put(r4, r7);
        r1.add(r7);
    L13:
        r7.mServices.add(r8);
        r7.mDuration += r8.mDuration;
    L14:
        r6 = r6 - 1;
        goto L6
    L15:
        r3 = r3 + 1;
        goto L4
    L16:
        Collections.sort(r1, sServicePkgCompare);
        int r16 = 0;
    L18:
        if (r16 >= r1.size()) goto L24;
        ArrayList<ProcStatsEntry.Service> r2 = ((PkgService) r1.get(r16)).mServices;
        Collections.sort(r2, sServiceCompare);
        int r9 = 0;
    L21:
        if (r9 >= r2.size()) goto L23;
        ProcStatsEntry.Service r10 = r2.get(r9);
        CharSequence r11 = getLabel(r10);
        CancellablePreference r12 = new CancellablePreference(getPrefContext());
        r12.setSelectable(false);
        r12.setTitle(r11);
        r12.setSummary(ProcStatsPackageEntry.getFrequency(r10.mDuration / this.mTotalTime, getActivity()));
        r15.addPreference(r12);
        this.mServiceMap.put(new ComponentName(r10.mPackage, r10.mName), r12);
        r9 = r9 + 1;
        goto L21
    L23:
        r16 = r16 + 1;
        goto L18
    }

    private CharSequence getLabel(ProcStatsEntry.Service r5) {
        ServiceInfo r0 = getPackageManager().getServiceInfo(new ComponentName(r5.mPackage, r5.mName), 0);     // Catch: PackageManager.NameNotFoundException -> L14
        if (r0 == null) goto L8;
        if (r0.labelRes == 0) goto L8;
        return r0.loadLabel(getPackageManager());
    L8:
        String r4 = r5.mName;
        int r6 = r4.lastIndexOf(46);
        if (r6 >= 0) goto L11;
        return r4;
    L11:
        if (r6 < (r4.length() - 1)) goto L13;
        return r4;
    L13:
        return r4.substring(r6 + 1);
    }

    private void stopService(String r3, String r4) {
    L8:
        e = move-exception;
        OLog.e(TAG, "Can't find app " + r3, e);
        return;
    L3:
        if ((getActivity().getPackageManager().getApplicationInfo(r3, 0).flags & 1) == 0) goto L6;
        showStopServiceDialog(r3, r4);     // Catch: PackageManager.NameNotFoundException -> L8
        return;
    L6:
        doStopService(r3, r4);
    }

    private void showStopServiceDialog(final String r3, final String r4) {
        new AlertDialog.Builder(getActivity()).setTitle(R.string.runningservicedetails_stop_dlg_title).setMessage(R.string.runningservicedetails_stop_dlg_text).setPositiveButton(R.string.dlg_ok, new AnonymousClass5(this, r3, r4)).setNegativeButton(R.string.dlg_cancel, null).show();
    }

    private void doStopService(String r3, String r4) {
        getActivity().stopService(new Intent().setClassName(r3, r4));
        updateRunningServices();
    }

    private void killProcesses() {
        ActivityManager r0 = (ActivityManager) getActivity().getSystemService("activity");
        int r2 = 0;
    L4:
        if (r2 >= this.mApp.mEntries.size()) goto L10;
        ProcStatsEntry r3 = this.mApp.mEntries.get(r2);
        int r4 = 0;
    L7:
        if (r4 >= r3.mPackages.size()) goto L9;
        r0.forceStopPackage(r3.mPackages.get(r4));
        r4 = r4 + 1;
        goto L7
    L9:
        r2 = r2 + 1;
        goto L4
    }

    private void checkForceStop() {
        if (this.mForceStop != null) goto L6;
        return;
    L6:
        if (this.mApp.mEntries.get(0).mUid >= 10000) goto L9;
        this.mForceStop.setVisible(false);
        return;
    L9:
        int r0 = 0;
        boolean r2 = false;
    L11:
        if (r0 >= this.mApp.mEntries.size()) goto L27;
        ProcStatsEntry r3 = this.mApp.mEntries.get(r0);
        int r5 = 0;
    L14:
        if (r5 >= r3.mPackages.size()) goto L26;
        String r6 = r3.mPackages.get(r5);
        if (this.mDpm.packageHasActiveAdmins(r6) == true) goto L17;
        ApplicationInfo r7 = this.mPm.getApplicationInfo(r6, 0);     // Catch: PackageManager.NameNotFoundException -> L30
        if (r7 == null) goto L25;
        if ((r7.flags & 2097152) != 0) goto L25;
        r2 = true;
    L25:
        r5 = r5 + 1;
        goto L14
    L17:
        this.mForceStop.setEnabled(false);
        return;
    L26:
        r0 = r0 + 1;
        goto L11
    L27:
        if (r2 == false) goto L39;
        this.mForceStop.setVisible(true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_ProcessStatsDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ProcessStatsDetail r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_ProcessStatsDetail__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_ProcessStatsDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ProcessStatsDetail r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applications_ProcessStatsDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_ProcessStatsDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ProcessStatsDetail r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_ProcessStatsDetail__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
