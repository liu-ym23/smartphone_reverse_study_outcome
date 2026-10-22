package com.android.settings;

import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import com.obric.privacy.LifeHookActivity2;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class UsageStatsActivity extends LifeHookActivity2 implements AdapterView.OnItemSelectedListener {
    private static final String TAG = "UsageStatsActivity";
    private static final boolean localLOGV = false;
    private UsageStatsAdapter mAdapter;
    private LayoutInflater mInflater;
    private PackageManager mPm;
    private UsageStatsManager mUsageStatsManager;

    public static class AppNameComparator implements Comparator<UsageStats> {
        private Map<String, String> mAppLabelList;

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(UsageStats r1, UsageStats r2) {
            return compare2(r1, r2);
        }

        AppNameComparator(Map<String, String> r1) {
            this.mAppLabelList = r1;
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public final int compare2(UsageStats r2, UsageStats r3) {
            return this.mAppLabelList.get(r2.getPackageName()).compareTo(this.mAppLabelList.get(r3.getPackageName()));
        }
    }

    static class AppViewHolder {
        TextView lastTimeUsed;
        TextView pkgName;
        TextView usageTime;

        AppViewHolder() {
        }
    }

    public static class LastTimeUsedComparator implements Comparator<UsageStats> {
        public LastTimeUsedComparator() {
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(UsageStats r1, UsageStats r2) {
            return compare2(r1, r2);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public final int compare2(UsageStats r3, UsageStats r4) {
            return Long.compare(r4.getLastTimeUsed(), r3.getLastTimeUsed());
        }
    }

    class UsageStatsAdapter extends BaseAdapter {
        private static final int _DISPLAY_ORDER_APP_NAME = 2;
        private static final int _DISPLAY_ORDER_LAST_TIME_USED = 1;
        private static final int _DISPLAY_ORDER_USAGE_TIME = 0;
        private AppNameComparator mAppLabelComparator;
        private final ArrayMap<String, String> mAppLabelMap;
        private int mDisplayOrder;
        private LastTimeUsedComparator mLastTimeUsedComparator;
        private final ArrayList<UsageStats> mPackageStats;
        private UsageTimeComparator mUsageTimeComparator;
        final /* synthetic */ UsageStatsActivity this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        UsageStatsAdapter(UsageStatsActivity r11) {
            this.this$0 = r11;
            this.mDisplayOrder = 0;
            this.mLastTimeUsedComparator = new LastTimeUsedComparator();
            this.mUsageTimeComparator = new UsageTimeComparator();
            this.mAppLabelMap = new ArrayMap();
            this.mPackageStats = new ArrayList();
            Calendar r1 = Calendar.getInstance();
            r1.add(6, -5);
            List<UsageStats> r2 = UsageStatsActivity.access$000(r11).queryUsageStats(4, r1.getTimeInMillis(), System.currentTimeMillis());
            if (r2 != null) goto L5;
            return;
        L5:
            ArrayMap r3 = new ArrayMap();
            int r4 = r2.size();
            int r5 = 0;
        L6:
            if (r5 >= r4) goto L13;
            UsageStats r6 = r2.get(r5);
            this.mAppLabelMap.put(r6.getPackageName(), UsageStatsActivity.access$100(r11).getApplicationInfo(r6.getPackageName(), 0).loadLabel(UsageStatsActivity.access$100(r11)).toString());     // Catch: PackageManager.NameNotFoundException -> L15
            UsageStats r7 = (UsageStats) r3.get(r6.getPackageName());     // Catch: PackageManager.NameNotFoundException -> L15
            if (r7 != null) goto L11;
            r3.put(r6.getPackageName(), r6);     // Catch: PackageManager.NameNotFoundException -> L15
            goto L12
        L11:
            r7.add(r6);     // Catch: PackageManager.NameNotFoundException -> L15
        L12:
            r5 = r5 + 1;
            goto L6
        L13:
            this.mPackageStats.addAll(r3.values());
            this.mAppLabelComparator = new AppNameComparator(this.mAppLabelMap);
            sortList();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mPackageStats.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return this.mPackageStats.get(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r8, View r9, ViewGroup r10) {
            if (r9 != null) goto L4;
            r9 = UsageStatsActivity.access$200(this.this$0).inflate(R.layout.usage_stats_item, null);
            AppViewHolder r11 = new AppViewHolder();
            r11.pkgName = (TextView) r9.findViewById(R.id.package_name);
            r11.lastTimeUsed = (TextView) r9.findViewById(R.id.last_time_used);
            r11.usageTime = (TextView) r9.findViewById(R.id.usage_time);
            r9.setTag(r11);
        L5:
            UsageStats r0 = this.mPackageStats.get(r8);
            if (r0 == null) goto L8;
            r11.pkgName.setText(this.mAppLabelMap.get(r0.getPackageName()));
            r11.lastTimeUsed.setText(DateUtils.formatSameDayTime(r0.getLastTimeUsed(), System.currentTimeMillis(), 2, 2));
            r11.usageTime.setText(DateUtils.formatElapsedTime(r0.getTotalTimeInForeground() / 1000));
        L9:
            return r9;
        L8:
            OLog.w(UsageStatsActivity.TAG, "No usage stats info for package:" + r8);
            goto L9
        L4:
            r11 = (AppViewHolder) r9.getTag();
            goto L5
        }

        void sortList(int r2) {
            if (this.mDisplayOrder != r2) goto L5;
            return;
        L5:
            this.mDisplayOrder = r2;
            sortList();
        }

        private void sortList() {
            int r0 = this.mDisplayOrder;
            if (r0 != 0) goto L6;
            Collections.sort(this.mPackageStats, this.mUsageTimeComparator);
        L11:
            notifyDataSetChanged();
            return;
        L6:
            if (r0 != 1) goto L9;
            Collections.sort(this.mPackageStats, this.mLastTimeUsedComparator);
            goto L11
        L9:
            if (r0 != 2) goto L11;
            Collections.sort(this.mPackageStats, this.mAppLabelComparator);
            goto L11
        }
    }

    public static class UsageTimeComparator implements Comparator<UsageStats> {
        public UsageTimeComparator() {
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(UsageStats r1, UsageStats r2) {
            return compare2(r1, r2);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public final int compare2(UsageStats r3, UsageStats r4) {
            return Long.compare(r4.getTotalTimeInForeground(), r3.getTotalTimeInForeground());
        }
    }

    public void com_android_settings_UsageStatsActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_UsageStatsActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_UsageStatsActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_UsageStatsActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_UsageStatsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> r1) {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_UsageStatsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_UsageStatsActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_UsageStatsActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_UsageStatsActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public UsageStatsActivity() {
    }

    static /* synthetic */ UsageStatsManager access$000(UsageStatsActivity r0) {
        return r0.mUsageStatsManager;
    }

    static /* synthetic */ PackageManager access$100(UsageStatsActivity r0) {
        return r0.mPm;
    }

    static /* synthetic */ LayoutInflater access$200(UsageStatsActivity r0) {
        return r0.mInflater;
    }

    public void com_android_settings_UsageStatsActivity__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        Utils.setTranslucentStatusAndNavigation(getApplicationContext(), getWindow());
        setContentView(R.layout.usage_stats);
        this.mUsageStatsManager = (UsageStatsManager) getSystemService("usagestats");
        this.mInflater = (LayoutInflater) getSystemService("layout_inflater");
        this.mPm = getPackageManager();
        ((OFloatingTitleBar) findViewById(R.id.view_title)).addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, null).setOnClickListener(new AnonymousClass1(this));
        ((Spinner) findViewById(R.id.typeSpinner)).setOnItemSelectedListener(this);
        ListView r5 = (ListView) findViewById(R.id.pkg_list);
        UsageStatsAdapter r0 = new UsageStatsAdapter(this);
        this.mAdapter = r0;
        r5.setAdapter(r0);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> r1, View r2, int r3, long r4) {
        this.mAdapter.sortList(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_UsageStatsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(UsageStatsActivity r1) {
        com_android_settings_UsageStatsActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_UsageStatsActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(UsageStatsActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        UsageStatsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_UsageStatsActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_UsageStatsActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(UsageStatsActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_UsageStatsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_UsageStatsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(UsageStatsActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_UsageStatsActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        UsageStatsActivity r5 = r4;
        String r2 = r5.getCallingPackage();
        if (r2 != null) goto L9;
        OLog.e("BaseActivity", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r6 = r5.getReferrer();
        if (r6 == null) goto L9;
        r2 = r6.toString();
    L9:
        OLog.i("TeaEventReportUtil", "callingPkg=" + r2);
        if (r2 != null) goto L12;
        r2 = "null";
    L12:
        AppMetricsUtils.INSTANCE.reportColdStartActivity(r2, r0);
    L13:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }

    @Insert(mayCreateSuper = true, value = "startActivityForResult")
    public static void com_android_settings_UsageStatsActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(UsageStatsActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_UsageStatsActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_UsageStatsActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(UsageStatsActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_UsageStatsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_UsageStatsActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(UsageStatsActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        UsageStatsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_UsageStatsActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_UsageStatsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(UsageStatsActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_UsageStatsActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_UsageStatsActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(UsageStatsActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        UsageStatsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_UsageStatsActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_UsageStatsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(UsageStatsActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_UsageStatsActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        UsageStatsActivity r5 = r3;
        String r6 = r5.getCallingPackage();
        if (r6 != null) goto L9;
        OLog.e("AppLifecycle", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r7 = r5.getReferrer();
        if (r7 == null) goto L9;
        r6 = r7.toString();
    L9:
        OLog.i("AppLifecycle", "TeaEventReportUtil callingPkg=" + r6);
        if (r6 != null) goto L12;
        r6 = "null";
    L12:
        AppMetricsUtils r8 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r8.callingPackageEvent(r6, r0, false);
        return;
    }

    @Insert("onStop")
    public static void com_android_settings_UsageStatsActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(UsageStatsActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        UsageStatsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_UsageStatsActivity__onStop$___twin___();
    }
}
