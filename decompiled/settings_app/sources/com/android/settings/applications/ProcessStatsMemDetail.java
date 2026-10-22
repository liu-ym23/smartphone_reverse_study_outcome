package com.android.settings.applications;

import android.os.Bundle;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.android.settings.InstrumentedFragment;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ProcessStatsMemDetail extends InstrumentedFragment {
    public static final String EXTRA_MEM_CACHED_WEIGHT = "mem_cached_weight";
    public static final String EXTRA_MEM_FREE_WEIGHT = "mem_free_weight";
    public static final String EXTRA_MEM_KERNEL_WEIGHT = "mem_kernel_weight";
    public static final String EXTRA_MEM_NATIVE_WEIGHT = "mem_native_weight";
    public static final String EXTRA_MEM_STATE_WEIGHTS = "mem_state_weights";
    public static final String EXTRA_MEM_TIMES = "mem_times";
    public static final String EXTRA_MEM_TOTAL_WEIGHT = "mem_total_weight";
    public static final String EXTRA_MEM_ZRAM_WEIGHT = "mem_zram_weight";
    public static final String EXTRA_TOTAL_TIME = "total_time";
    public static final String EXTRA_USE_USS = "use_uss";
    double mMemCachedWeight;
    double mMemFreeWeight;
    double mMemKernelWeight;
    double mMemNativeWeight;
    private ViewGroup mMemStateParent;
    double[] mMemStateWeights;
    long[] mMemTimes;
    double mMemTotalWeight;
    private ViewGroup mMemUseParent;
    double mMemZRamWeight;
    private View mRootView;
    long mTotalTime;
    boolean mUseUss;

    public void com_android_settings_applications_ProcessStatsMemDetail__onResume$___twin___() {
        super.onResume();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applications_ProcessStatsMemDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.InstrumentedFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applications_ProcessStatsMemDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ProcessStatsMemDetail() {
    }

    public void com_android_settings_applications_ProcessStatsMemDetail__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        this.mMemTimes = r4.getLongArray(EXTRA_MEM_TIMES);
        this.mMemStateWeights = r4.getDoubleArray(EXTRA_MEM_STATE_WEIGHTS);
        this.mMemCachedWeight = r4.getDouble(EXTRA_MEM_CACHED_WEIGHT);
        this.mMemFreeWeight = r4.getDouble(EXTRA_MEM_FREE_WEIGHT);
        this.mMemZRamWeight = r4.getDouble(EXTRA_MEM_ZRAM_WEIGHT);
        this.mMemKernelWeight = r4.getDouble(EXTRA_MEM_KERNEL_WEIGHT);
        this.mMemNativeWeight = r4.getDouble(EXTRA_MEM_NATIVE_WEIGHT);
        this.mMemTotalWeight = r4.getDouble(EXTRA_MEM_TOTAL_WEIGHT);
        this.mUseUss = r4.getBoolean(EXTRA_USE_USS);
        this.mTotalTime = r4.getLong("total_time");
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = r2.inflate(R.layout.process_stats_mem_details, r3, false);
        Utils.prepareCustomPreferencesList(r3, r5, r5, false);
        this.mRootView = r5;
        createDetails();
        return r5;
    }

    @Override // com.android.settings.InstrumentedFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    private void createDetails() {
        this.mMemStateParent = (ViewGroup) this.mRootView.findViewById(R.id.mem_state);
        this.mMemUseParent = (ViewGroup) this.mRootView.findViewById(R.id.mem_use);
        fillMemStateSection();
        fillMemUseSection();
    }

    private void addDetailsItem(ViewGroup r4, CharSequence r5, float r6, CharSequence r7) {
        LayoutInflater r3 = getActivity().getLayoutInflater();
        ViewGroup r0 = (ViewGroup) r3.inflate(R.layout.app_item, null);
        r3.inflate(R.layout.widget_progress_bar, (ViewGroup) r0.findViewById(android.R.id.widget_frame));
        r4.addView(r0);
        r0.findViewById(android.R.id.icon).setVisibility(8);
        TextView r8 = (TextView) r0.findViewById(android.R.id.title);
        TextView r9 = (TextView) r0.findViewById(android.R.id.text1);
        r8.setText(r5);
        r9.setText(r7);
        ((ProgressBar) r0.findViewById(android.R.id.progress)).setProgress(Math.round(r6 * 100.0f));
    }

    private void fillMemStateSection() {
        CharSequence[] r0 = getResources().getTextArray(R.array.proc_stats_memory_states);
        int r1 = 0;
    L4:
        if (r1 >= 4) goto L9;
        long r2 = this.mMemTimes[r1];
        if (r2 <= 0) goto L8;
        addDetailsItem(this.mMemStateParent, r0[r1], r2 / this.mTotalTime, Formatter.formatShortElapsedTime(getActivity(), this.mMemTimes[r1]));
    L8:
        r1 = r1 + 1;
        goto L4
    }

    private void addMemUseDetailsItem(ViewGroup r5, CharSequence r6, double r7) {
        if (r7 <= 0.0d) goto L6;
        addDetailsItem(r5, r6, (float) (r7 / this.mMemTotalWeight), Formatter.formatShortFileSize(getActivity(), (long) ((r7 * 1024.0d) / this.mTotalTime)));
        return;
    }

    private void fillMemUseSection() {
        CharSequence[] r0 = getResources().getTextArray(R.array.proc_stats_process_states);
        addMemUseDetailsItem(this.mMemUseParent, getResources().getText(R.string.mem_use_kernel_type), this.mMemKernelWeight);
        addMemUseDetailsItem(this.mMemUseParent, getResources().getText(R.string.mem_use_zram_type), this.mMemZRamWeight);
        addMemUseDetailsItem(this.mMemUseParent, getResources().getText(R.string.mem_use_native_type), this.mMemNativeWeight);
        int r1 = 0;
    L4:
        if (r1 >= 16) goto L6;
        addMemUseDetailsItem(this.mMemUseParent, r0[r1], this.mMemStateWeights[r1]);
        r1 = r1 + 1;
        goto L4
    L6:
        addMemUseDetailsItem(this.mMemUseParent, getResources().getText(R.string.mem_use_kernel_cache_type), this.mMemCachedWeight);
        addMemUseDetailsItem(this.mMemUseParent, getResources().getText(R.string.mem_use_free_type), this.mMemFreeWeight);
        addMemUseDetailsItem(this.mMemUseParent, getResources().getText(R.string.mem_use_total), this.mMemTotalWeight);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_ProcessStatsMemDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ProcessStatsMemDetail r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_ProcessStatsMemDetail__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_ProcessStatsMemDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ProcessStatsMemDetail r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applications_ProcessStatsMemDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_ProcessStatsMemDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ProcessStatsMemDetail r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_ProcessStatsMemDetail__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
