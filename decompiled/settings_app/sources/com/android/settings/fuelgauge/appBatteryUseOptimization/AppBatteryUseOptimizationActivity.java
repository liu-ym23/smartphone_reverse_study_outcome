package com.android.settings.fuelgauge.appBatteryUseOptimization;

import android.app.ActivityManager;
import android.app.LoaderManager;
import android.app.SmtPCUtils;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import com.android.settings.NotificationDisplayDetailsActivity;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.applications.ApplicationLabelCache;
import com.android.settings.applications.LabelEntry;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.ListContentItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public class AppBatteryUseOptimizationActivity extends BaseActivity implements LoaderManager.LoaderCallbacks<List<OptimizationInfo>> {
    private static final Comparator<OptimizationInfo> ALPHA_COMPARATOR = null;
    private static final int SHOW_LOADING_VIEW = 1;
    private AppBatteryUseAdapter mAdapter;
    private CompoundButton.OnCheckedChangeListener mCheckedChangeListener;
    private boolean mEnableOptimization;
    private Handler mHandler;
    private LayoutInflater mInflater;
    private ListView mListView;
    private View mLoadingView;

    private class AppBatteryUseAdapter extends ArrayAdapter<OptimizationInfo> {
        final PackageManager mPm;
        final /* synthetic */ AppBatteryUseOptimizationActivity this$0;

        AppBatteryUseAdapter(AppBatteryUseOptimizationActivity r1, Context r2) {
            this.this$0 = r1;
            super(r2, R.layout.app_battery_use_optimzation_item);
            this.mPm = r2.getPackageManager();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int r4, View r5, ViewGroup r6) {
            if (r5 != null) goto L4;
            r5 = AppBatteryUseOptimizationActivity.access$500(this.this$0).inflate(R.layout.app_battery_use_optimzation_item, r6, false);
            ViewHolder r7 = new ViewHolder(r5);
            r5.setTag(r7);
        L5:
            OptimizationInfo r0 = getItem(r4);
            if (r0.icon == null) goto L8;
            r7.switchEx.setIcon(r0.icon);
        L9:
            r7.switchEx.setTitle(r0.mLabelEntry.label);
            int r2 = 1;
            if (getCount() == 1) goto L18;
            if (r4 != 0) goto L15;
            r2 = 2;
            goto L18
        L15:
            if (r4 != (getCount() - 1)) goto L17;
            r2 = 4;
            goto L18
        L17:
            r2 = 3;
        L18:
            r7.switchEx.setBackgroundStyle(r2);
            r7.switchEx.setOnCheckedChangeListener(null);
            r7.switchEx.setChecked(r0.optimization);
            r7.switchEx.getSwitch().setTag(r0);
            r7.switchEx.setOnCheckedChangeListener(AppBatteryUseOptimizationActivity.access$600(this.this$0));
            r7.switchEx.setEnabled(AppBatteryUseOptimizationActivity.access$100(this.this$0));
            return r5;
        L8:
            r0.icon = r0.mPackageInfo.applicationInfo.loadIcon(this.mPm);
            r7.switchEx.setIcon(r0.icon);
            goto L9
        L4:
            r7 = (ViewHolder) r5.getTag();
            goto L5
        }
    }

    private static class AppListLoader extends AsyncTaskLoader<List<OptimizationInfo>> {
        Context mContext;
        final PackageManager mPm;

        @Override // android.content.AsyncTaskLoader
        public /* bridge */ /* synthetic */ List<OptimizationInfo> loadInBackground() {
            return loadInBackground2();
        }

        AppListLoader(Context r1) {
            super(r1);
            this.mContext = r1;
            this.mPm = r1.getPackageManager();
        }

        @Override // android.content.Loader
        protected void onStartLoading() {
            super.onStartLoading();
            forceLoad();
        }

        @Override // android.content.Loader
        protected void onStopLoading() {
            super.onStopLoading();
            cancelLoad();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.content.AsyncTaskLoader
        /* JADX INFO: renamed from: loadInBackground, reason: avoid collision after fix types in other method */
        public List<OptimizationInfo> loadInBackground2() {
            ArrayList r1 = new ArrayList();
            Cursor r2 = null;
            r2 = this.mContext.getContentResolver().query(OptimizationHelper.CONTENT_URI, new String[]{"_id", NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME, "enable", "uid"}, null, null, null);     // Catch: Throwable -> L74 Exception -> L76
            int r4 = 0;
            List<PackageInfo> r3 = this.mPm.getInstalledPackages(0);     // Catch: Throwable -> L74 Exception -> L76
            ApplicationLabelCache r5 = ApplicationLabelCache.getInstance();     // Catch: Throwable -> L74 Exception -> L76
            Iterator<PackageInfo> r6 = r3.iterator();     // Catch: Throwable -> L74 Exception -> L76
        L4:
            int r9 = -1;
            boolean r10 = true;
            if (r6.hasNext() == false) goto L31;
            PackageInfo r7 = r6.next();     // Catch: Throwable -> L74 Exception -> L76
            ApplicationInfo r11 = r7.applicationInfo;     // Catch: Throwable -> L74 Exception -> L76
            if (r11.uid < 10000) goto L4;
            if ((r11.flags & 1) != 0) goto L4;
            if (AppBatteryUseOptimizationActivity.access$300(r11.packageName) == true) goto L4;
            LabelEntry r12 = r5.getLabelEntry(getContext(), r11.packageName);     // Catch: Throwable -> L74 Exception -> L76
            if (r12 != null) goto L16;
            r12 = r5.getLabelEntryForApplication(getContext(), r7.applicationInfo);     // Catch: Throwable -> L74 Exception -> L76
        L16:
            LabelEntry r13 = r12;
            if (r2 == null) goto L29;
            r2.moveToFirst();     // Catch: Throwable -> L74 Exception -> L76
        L20:
            if (r2.getString(1).equals(r11.packageName) == false) goto L28;
            if (r2.getInt(3) != r11.uid) goto L28;
            r9 = r2.getInt(0);     // Catch: Throwable -> L74 Exception -> L76
            if (r2.getInt(2) == 1) goto L29;
            r10 = false;
        L28:
            if (r2.moveToNext() == true) goto L20;
        L29:
            OptimizationInfo r8 = new OptimizationInfo(r7, r13, null, r9, r10);     // Catch: Throwable -> L74 Exception -> L76
            r8.icon = r7.applicationInfo.loadIcon(this.mPm);     // Catch: Throwable -> L74 Exception -> L76
            r1.add(r8);     // Catch: Throwable -> L74 Exception -> L76
            goto L4
        L31:
            if (ActivityManager.getCurrentUser() != 0) goto L70;
            List r14 = this.mPm.getInstalledPackagesAsUser(0, 10);     // Catch: Throwable -> L74 Exception -> L76
            if (r14 != null) goto L37;
            if (r2 == null) goto L36;
            r2.close();
        L36:
            return r1;
        L37:
            Iterator r15 = r14.iterator();     // Catch: Throwable -> L74 Exception -> L76
        L39:
            if (r15.hasNext() == false) goto L70;
            PackageInfo r16 = (PackageInfo) r15.next();     // Catch: Throwable -> L74 Exception -> L76
            if ((r16.applicationInfo.flags & 1) != 0) goto L69;
            if (AppBatteryUseOptimizationActivity.access$300(r16.packageName) == true) goto L39;
            if (Utils.isPackageInstalled(this.mContext, r16.applicationInfo.packageName) == false) goto L69;
            LabelEntry r17 = r5.getLabelEntry(getContext(), r16.packageName);     // Catch: Throwable -> L74 Exception -> L76
            if (r17 != null) goto L50;
            r17 = r5.getLabelEntryForApplication(getContext(), r16.applicationInfo);     // Catch: Throwable -> L74 Exception -> L76
        L50:
            LabelEntry r18 = r17;
            if (r2 == null) goto L64;
            r2.moveToFirst();     // Catch: Throwable -> L74 Exception -> L76
        L54:
            if (r2.getString(1).equals(r16.packageName) == false) goto L63;
            if (r2.getInt(3) != r16.applicationInfo.uid) goto L63;
            int r19 = r2.getInt(r4);     // Catch: Throwable -> L74 Exception -> L76
            if (r2.getInt(2) != 1) goto L60;
            int r110 = 1;
        L61:
            int r111 = r19;
            boolean r112 = r110;
        L65:
            OptimizationInfo r113 = new OptimizationInfo(r16, r18, null, r111, r112);     // Catch: Throwable -> L74 Exception -> L76
            r113.icon = r16.applicationInfo.loadIcon(this.mPm);     // Catch: Throwable -> L74 Exception -> L76
            if ((r113.icon instanceof BitmapDrawable) == false) goto L68;
            r113.icon = Utils.getDoppelgangerDrawableIcon(this.mContext.getResources(), (BitmapDrawable) r113.icon);     // Catch: Throwable -> L74 Exception -> L76
        L68:
            r1.add(r113);     // Catch: Throwable -> L74 Exception -> L76
            goto L69
        L60:
            r110 = r4;
        L63:
            if (r2.moveToNext() == true) goto L54;
        L64:
            r111 = -1;
            r112 = 1;
        L69:
            r4 = 0;
        L70:
            Collections.sort(r1, AppBatteryUseOptimizationActivity.access$400());     // Catch: Throwable -> L74 Exception -> L76
            if (r2 == null) goto L73;
            r2.close();
        L73:
            return r1;
        L74:
            th = move-exception;
            if (r2 == null) goto L83;
            r2.close();
        L83:
            throw th;
        L76:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L74
            if (r2 == null) goto L80;
            r2.close();
        L80:
            return r1;
        }

        @Override // android.content.Loader
        protected void onReset() {
            cancelLoad();
        }
    }

    static class OptimizationInfo {
        Drawable icon;
        int id;
        LabelEntry mLabelEntry;
        PackageInfo mPackageInfo;
        boolean optimization;

        OptimizationInfo(PackageInfo r1, LabelEntry r2, Drawable r3, int r4, boolean r5) {
            this.mPackageInfo = r1;
            this.mLabelEntry = r2;
            this.icon = r3;
            this.id = r4;
            this.optimization = r5;
        }
    }

    private static class ViewHolder {
        public ListContentItemSwitch switchEx;

        public ViewHolder(View r2) {
            this.switchEx = (ListContentItemSwitch) r2.findViewById(R.id.switcher);
        }
    }

    public void com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public AppBatteryUseOptimizationActivity() {
        this.mHandler = new AnonymousClass1(this);
        this.mCheckedChangeListener = new AnonymousClass4(this);
    }

    static /* synthetic */ View access$000(AppBatteryUseOptimizationActivity r0) {
        return r0.mLoadingView;
    }

    static /* synthetic */ boolean access$100(AppBatteryUseOptimizationActivity r0) {
        return r0.mEnableOptimization;
    }

    static /* synthetic */ boolean access$102(AppBatteryUseOptimizationActivity r0, boolean r1) {
        r0.mEnableOptimization = r1;
        return r1;
    }

    static /* synthetic */ AppBatteryUseAdapter access$200(AppBatteryUseOptimizationActivity r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ boolean access$300(String r0) {
        return isHiddenApp(r0);
    }

    static /* synthetic */ Comparator access$400() {
        return ALPHA_COMPARATOR;
    }

    static /* synthetic */ LayoutInflater access$500(AppBatteryUseOptimizationActivity r0) {
        return r0.mInflater;
    }

    static /* synthetic */ CompoundButton.OnCheckedChangeListener access$600(AppBatteryUseOptimizationActivity r0) {
        return r0.mCheckedChangeListener;
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public /* bridge */ /* synthetic */ void onLoadFinished(Loader<List<OptimizationInfo>> r1, List<OptimizationInfo> r2) {
        onLoadFinished2(r1, r2);
    }

    public void com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationActivity__onCreate$___twin___(Bundle r7) {
        super.onCreate(r7);
        setContentView(R.layout.app_battery_use_optimzation_activity);
        setupBackBtnOnTitle(false);
        getLoaderManager().initLoader(0, null, this);
        this.mInflater = LayoutInflater.from(this);
        this.mListView = (ListView) findViewById(R.id.view_list);
        View r0 = LayoutInflater.from(this).inflate(R.layout.app_battery_use_optimzation_header, null);
        ListContentItemSwitch r2 = (ListContentItemSwitch) r0.findViewById(R.id.optimzation_header_switch);
        boolean r5 = true;
        if (Settings.Global.getInt(getContentResolver(), "optimization_APPS", 1) == 1) goto L6;
        r5 = false;
    L6:
        this.mEnableOptimization = r5;
        r2.setChecked(r5);
        r2.setOnCheckedChangeListener(new AnonymousClass2(this));
        this.mListView.addHeaderView(r0);
        this.mLoadingView = findViewById(R.id.loading_container);
        AppBatteryUseAdapter r1 = new AppBatteryUseAdapter(this, getBaseContext());
        this.mAdapter = r1;
        this.mListView.setAdapter(r1);
        this.mListView.setVisibility(4);
        View r3 = new View(this);
        r3.setLayoutParams(new AbsListView.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.settings_item_top_bottom_margin)));
        this.mListView.addFooterView(r3, null, false);
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public Loader<List<OptimizationInfo>> onCreateLoader(int r1, Bundle r2) {
        AsyncTask.setDefaultExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        return new AppListLoader(this);
    }

    /* JADX INFO: renamed from: onLoadFinished, reason: avoid collision after fix types in other method */
    public void onLoadFinished2(Loader<List<OptimizationInfo>> r2, List<OptimizationInfo> r3) {
        this.mHandler.removeMessages(1);
        this.mLoadingView.setVisibility(8);
        this.mListView.setVisibility(0);
        this.mAdapter.clear();
        this.mAdapter.addAll(r3);
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<List<OptimizationInfo>> r1) {
        this.mAdapter.clear();
    }

    static {
        ALPHA_COMPARATOR = new AnonymousClass3();
    }

    private static boolean isHiddenApp(String r1) {
        if (r1 != null) goto L4;
    L14:
        return false;
    L4:
        if (r1.startsWith("com.bytedanceos.theme") == false) goto L6;
    L13:
        return true;
    L6:
        if (r1.startsWith("com.bytedanceos.launcher.theme") == true) goto L13;
        if (r1.equals(SmtPCUtils.HANDSHAKER_DISPLAY_PKG) == true) goto L13;
        if (r1.equals("com.bytedanceos.payment") == true) goto L13;
        if (r1.startsWith("com.mediatek") == false) goto L14;
        goto L13
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(AppBatteryUseOptimizationActivity r1) {
        com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationActivity_com_obric_hook_lancet_PrivacyHook_onCreate(AppBatteryUseOptimizationActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        AppBatteryUseOptimizationActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(AppBatteryUseOptimizationActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(AppBatteryUseOptimizationActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        AppBatteryUseOptimizationActivity r5 = r4;
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
    public static void com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(AppBatteryUseOptimizationActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(AppBatteryUseOptimizationActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationActivity_com_obric_hook_lancet_PrivacyHook_onResume(AppBatteryUseOptimizationActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        AppBatteryUseOptimizationActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(AppBatteryUseOptimizationActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationActivity_com_obric_hook_lancet_PrivacyHook_onPause(AppBatteryUseOptimizationActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        AppBatteryUseOptimizationActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(AppBatteryUseOptimizationActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        AppBatteryUseOptimizationActivity r5 = r3;
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
    public static void com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationActivity_com_obric_hook_lancet_PrivacyHook_onStop(AppBatteryUseOptimizationActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        AppBatteryUseOptimizationActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_fuelgauge_appBatteryUseOptimization_AppBatteryUseOptimizationActivity__onStop$___twin___();
    }
}
