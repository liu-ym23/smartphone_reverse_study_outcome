package com.android.settings.applications;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.android.internal.app.procstats.ProcessStats;
import com.android.settings.R;
import com.android.settings.SettingsActivity;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.SettingsTracker;
import com.bytedance.sremlib.LibUtil;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ProcessStatsBase extends SettingsPreferenceFragment implements AdapterView.OnItemSelectedListener {
    protected static final String ARG_DURATION_INDEX = "duration_index";
    protected static final String ARG_TRANSFER_STATS = "transfer_stats";
    private static final String DURATION = "duration";
    private static final long DURATION_QUANTUM = 0;
    protected static final int NUM_DURATIONS = 4;
    protected static int[] sDurationLabels;
    protected static long[] sDurations;
    protected int mDurationIndex;
    private ArrayAdapter<String> mFilterAdapter;
    private Spinner mFilterSpinner;
    private ViewGroup mSpinnerHeader;
    protected ProcStatsData mStatsManager;

    public abstract void refreshUi();

    public ProcessStatsBase() {
    }

    static {
        long r0 = ProcessStats.COMMIT_PERIOD;
        DURATION_QUANTUM = r0;
        sDurations = new long[]{10800000 - (r0 / 2), LibUtil.DEFAULT_LIVETIME_SUBMIT_INTERVAL - (r0 / 2), SettingsTracker.PERIOD_UPLOAD_TRACK - (r0 / 2), 86400000 - (r0 / 2)};
        sDurationLabels = new int[]{R.string.menu_duration_3h, R.string.menu_duration_6h, R.string.menu_duration_12h, R.string.menu_duration_1d};
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r6) {
        super.onCreate(r6);
        Bundle r0 = getArguments();
        FragmentActivity r2 = getActivity();
        if (r6 != null) goto L9;
        if (r0 != null) goto L6;
    L8:
        boolean r4 = false;
    L10:
        this.mStatsManager = new ProcStatsData(r2, r4);
        if (r6 == null) goto L13;
        int r1 = r6.getInt(ARG_DURATION_INDEX);
    L16:
        this.mDurationIndex = r1;
        ProcStatsData r5 = this.mStatsManager;
        if (r6 == null) goto L19;
        long r3 = r6.getLong("duration", sDurations[0]);
    L20:
        r5.setDuration(r3);
        return;
    L19:
        r3 = sDurations[0];
        goto L20
    L13:
        if (r0 == null) goto L15;
        r1 = r0.getInt(ARG_DURATION_INDEX);
        goto L16
    L15:
        r1 = 0;
        goto L16
    L6:
        if (r0.getBoolean(ARG_TRANSFER_STATS, false) == false) goto L8;
    L9:
        r4 = true;
        goto L10
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r4) {
        super.onSaveInstanceState(r4);
        r4.putLong("duration", this.mStatsManager.getDuration());
        r4.putInt(ARG_DURATION_INDEX, this.mDurationIndex);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mStatsManager.refreshStats(false);
        refreshUi();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (getActivity().isChangingConfigurations() == false) goto L6;
        this.mStatsManager.xferStats();
        return;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        ViewGroup r4 = (ViewGroup) setPinnedHeaderView(R.layout.apps_filter_spinner);
        this.mSpinnerHeader = r4;
        this.mFilterSpinner = (Spinner) r4.findViewById(R.id.filter_spinner);
        ArrayAdapter<String> r5 = new ArrayAdapter(getActivity(), R.layout.filter_spinner_item);
        this.mFilterAdapter = r5;
        r5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        int r6 = 0;
    L4:
        if (r6 >= 4) goto L6;
        this.mFilterAdapter.add(getString(sDurationLabels[r6]));
        r6 = r6 + 1;
        goto L4
    L6:
        this.mFilterSpinner.setAdapter(this.mFilterAdapter);
        this.mFilterSpinner.setSelection(this.mDurationIndex);
        this.mFilterSpinner.setOnItemSelectedListener(this);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> r1, View r2, int r3, long r4) {
        this.mDurationIndex = r3;
        this.mStatsManager.setDuration(sDurations[r3]);
        refreshUi();
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> r1) {
        this.mFilterSpinner.setSelection(0);
    }

    public static void launchMemoryDetail(SettingsActivity r7, ProcStatsData.MemInfo r8, ProcStatsPackageEntry r9, boolean r10) {
        Bundle r2 = new Bundle();
        r2.putParcelable(ProcessStatsDetail.EXTRA_PACKAGE_ENTRY, r9);
        r2.putDouble(ProcessStatsDetail.EXTRA_WEIGHT_TO_RAM, r8.weightToRam);
        r2.putLong("total_time", r8.memTotalTime);
        r2.putDouble(ProcessStatsDetail.EXTRA_MAX_MEMORY_USAGE, r8.usedWeight * r8.weightToRam);
        r2.putDouble(ProcessStatsDetail.EXTRA_TOTAL_SCALE, r8.totalScale);
        r2.putBoolean("hideInfoButton", !r10);
        Fragment r11 = (Fragment) null;
        r7.startPreferencePanel(ProcessStatsDetail.class.getName(), r2, R.string.memory_usage, null, null, 0);
    }
}
