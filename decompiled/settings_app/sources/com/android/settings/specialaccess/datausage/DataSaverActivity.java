package com.android.settings.specialaccess.datausage;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserHandle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.android.settings.R;
import com.android.settings.accounts.obric.ObricIconUtils;
import com.android.settings.applications.AppStateBaseBridge;
import com.android.settings.datausage.AppStateDataUsageBridge;
import com.android.settings.datausage.DataSaverBackend;
import com.android.settings.riskcontrol.RiskPermissionControlGuard;
import com.android.settings.specialaccess.SpecialAccessBaseActivity;
import com.android.settings.specialaccess.SpecialAccessHeaderAdapter;
import com.android.settings.specialaccess.SpecialAccessSwitchViewHolder;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settingslib.applications.AppUtils;
import com.android.settingslib.applications.ApplicationsState;
import com.android.settingslib.core.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class DataSaverActivity extends SpecialAccessBaseActivity implements AppStateBaseBridge.Callback, ApplicationsState.Callbacks {
    private final String TAG;
    private ApplicationAdapter mApplicationAdapter;
    private ApplicationsState mApplicationsState;
    private DataSaverBackend mDataSaverBackend;
    private AppStateDataUsageBridge mDataUsageBridge;
    private boolean mExtraLoaded;
    private ApplicationsState.AppFilter mFilter;
    private ApplicationsState.Session mSession;

    static class ApplicationAdapter extends SpecialAccessHeaderAdapter {
        private static final int VIEW_TYPE_ITEM_INFO = -200001;
        private final Activity activity;
        ArrayList<ApplicationsState.AppEntry> apps;
        private DataSaverBackend mDataSaverBackend;
        private PackageManager mPkgMan;

        public ApplicationAdapter(Activity r1, PackageManager r2, DataSaverBackend r3, Function1<OSectionSupportiveText, Unit> r4) {
            super(r4);
            this.apps = new ArrayList();
            this.activity = r1;
            this.mPkgMan = r2;
            this.mDataSaverBackend = r3;
        }

        public void setData(ArrayList<ApplicationsState.AppEntry> r1) {
            this.apps = r1;
            notifyDataSetChanged();
        }

        @Override // com.android.settings.specialaccess.HeaderBaseAdapter
        public RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup r2, int r3) {
            if (r3 != VIEW_TYPE_ITEM_INFO) goto L7;
            return DataSaverViewHolder.build(r2, this.mDataSaverBackend);
        L7:
            return new SpecialAccessSwitchViewHolder(SpecialAccessSwitchViewHolder.newView(r2));
        }

        @Override // com.android.settings.specialaccess.HeaderBaseAdapter
        public int getContentItemViewType(int r3) {
            if (r3 != 0) goto L8;
            if (getItemContentCount() != 1) goto L8;
            return VIEW_TYPE_ITEM_INFO;
        L8:
            return super.getContentItemViewType(r3);
        }

        @Override // com.android.settings.specialaccess.HeaderBaseAdapter
        public void onBindContentViewHolder(RecyclerView.ViewHolder r4, int r5) {
            if ((r4 instanceof DataSaverViewHolder) == false) goto L6;
            DataSaverViewHolder r6 = (DataSaverViewHolder) r4;
            r6.bindData(this.apps.get(r5));
            return;
        L6:
            SpecialAccessSwitchViewHolder r7 = (SpecialAccessSwitchViewHolder) r4;
            ApplicationsState.AppEntry r0 = this.apps.get(r5);
            final ApplicationInfo r1 = r0.info;
            r7.initCardItemInAdapter(this.apps.size(), r5);
            r7.setIcon(ObricIconUtils.getDrawable(r1));
            r7.setTitle(r1.loadLabel(this.mPkgMan), null);
            r7.updateSwitch(getSwitchOnCheckedListener(r0), enableSwitch(r0), checkSwitch(r0));
            r7.setSwitchOnTouchListener(new DataSaverActivity$ApplicationAdapter$$ExternalSyntheticLambda0(this, r1));
        }

        /* JADX INFO: renamed from: lambda$onBindContentViewHolder$0$com-android-settings-specialaccess-datausage-DataSaverActivity$ApplicationAdapter, reason: not valid java name */
        /* synthetic */ boolean m609xee609d88(ApplicationInfo r2, View r3, MotionEvent r4) {
            return RiskPermissionControlGuard.interceptOnActionUp(this.activity, r2.packageName, UserHandle.getUserId(r2.uid), 3, r4);
        }

        @Override // com.android.settings.specialaccess.HeaderBaseAdapter
        public int getItemContentCount() {
            ArrayList<ApplicationsState.AppEntry> r0 = this.apps;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.size();
        }

        public CompoundButton.OnCheckedChangeListener getSwitchOnCheckedListener(final ApplicationsState.AppEntry r2) {
            if (r2 != null) goto L6;
            return null;
        L6:
            return new DataSaverActivity$ApplicationAdapter$$ExternalSyntheticLambda1(this, r2);
        }

        /* JADX INFO: renamed from: lambda$getSwitchOnCheckedListener$1$com-android-settings-specialaccess-datausage-DataSaverActivity$ApplicationAdapter, reason: not valid java name */
        /* synthetic */ void m608x561e2707(ApplicationsState.AppEntry r4, CompoundButton r5, boolean r6) {
            if (RiskPermissionControlGuard.intercept(this.activity, r4.info.packageName, UserHandle.getUserId(r4.info.uid), 3) == false) goto L6;
            notifyDataSetChanged();
            return;
        L6:
            setNewState(r4, Boolean.valueOf(r6).booleanValue());
        }

        private final boolean enableSwitch(ApplicationsState.AppEntry r2) {
            AppStateDataUsageBridge.DataUsageState r0 = (AppStateDataUsageBridge.DataUsageState) r2.extraInfo;
            if (r0 == null) goto L7;
            return !r0.isDataSaverDenylisted;
        L7:
            return !getDataUsageState(r2.info.uid).isDataSaverDenylisted;
        }

        private final boolean checkSwitch(ApplicationsState.AppEntry r2) {
            AppStateDataUsageBridge.DataUsageState r0 = (AppStateDataUsageBridge.DataUsageState) r2.extraInfo;
            if (r0 == null) goto L7;
            return r0.isDataSaverAllowlisted;
        L7:
            return getDataUsageState(r2.info.uid).isDataSaverAllowlisted;
        }

        private AppStateDataUsageBridge.DataUsageState getDataUsageState(int r3) {
            return new AppStateDataUsageBridge.DataUsageState(this.mDataSaverBackend.isAllowlisted(r3), this.mDataSaverBackend.isDenylisted(r3));
        }

        private void setNewState(ApplicationsState.AppEntry r4, boolean r5) {
            this.mDataSaverBackend.setIsAllowlisted(r4.info.uid, r4.info.packageName, r5);
            AppStateDataUsageBridge.DataUsageState r0 = (AppStateDataUsageBridge.DataUsageState) r4.extraInfo;
            if (r0 == null) goto L5;
            r0.isDataSaverAllowlisted = r5;
            return;
        L5:
            r4.extraInfo = getDataUsageState(r4.info.uid);
        }
    }

    public void com_android_settings_specialaccess_datausage_DataSaverActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_specialaccess_datausage_DataSaverActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity
    protected int getEmptyRes() {
        return R.string.picture_in_picture_empty_text;
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity
    protected int getSubtitleResId() {
        return R.string.unrestricted_app_summary;
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity
    protected int getTitleRes() {
        return R.string.unrestricted_data_saver;
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onAllSizesComputed() {
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity, com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_specialaccess_datausage_DataSaverActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
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

    @Override // com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_specialaccess_datausage_DataSaverActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_specialaccess_datausage_DataSaverActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onRunningStateChanged(boolean r1) {
    }

    @Override // com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_specialaccess_datausage_DataSaverActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_specialaccess_datausage_DataSaverActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public DataSaverActivity() {
        this.TAG = "DataSaverActivity";
    }

    static /* synthetic */ void access$000(DataSaverActivity r0, OSectionSupportiveText r1) {
        r0.initDescText(r1);
    }

    public void com_android_settings_specialaccess_datausage_DataSaverActivity__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        this.mApplicationsState = ApplicationsState.getInstance((Application) getApplicationContext());
        this.mDataSaverBackend = new DataSaverBackend(this);
        this.mDataUsageBridge = new AppStateDataUsageBridge(this.mApplicationsState, this, this.mDataSaverBackend);
        this.mApplicationAdapter = new ApplicationAdapter(this, getPackageManager(), this.mDataSaverBackend, new AnonymousClass1(this));
        this.mRecyclerView.setAdapter(this.mApplicationAdapter);
        setFilter(ApplicationsState.FILTER_ENABLED_NOT_QUIET);
        setSession(getSettingsLifecycle());
    }

    private int getPackageIdx(String r2, ArrayList<ApplicationsState.AppEntry> r3) {
        if (r2 == null) goto L13;
        if (r3 == null) goto L13;
        int r1 = 0;
    L6:
        if (r1 >= r3.size()) goto L13;
        ApplicationInfo r0 = r3.get(r1).info;
        if (r0 == null) goto L12;
        if (TextUtils.equals(r2, r0.packageName) == false) goto L12;
        return r1;
    L12:
        r1 = r1 + 1;
    L13:
        return -1;
    }

    public void setFilter(ApplicationsState.AppFilter r1) {
        this.mFilter = r1;
    }

    public void setSession(Lifecycle r2) {
        this.mSession = this.mApplicationsState.newSession(this, r2);
    }

    public void com_android_settings_specialaccess_datausage_DataSaverActivity__onResume$___twin___() {
        super.onResume();
        this.mDataUsageBridge.resume(true);
    }

    public void com_android_settings_specialaccess_datausage_DataSaverActivity__onStop$___twin___() {
        super.onStop();
        this.mDataUsageBridge.pause();
    }

    @Override // com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.mDataUsageBridge.release();
        super.onDestroy();
    }

    @Override // com.android.settings.applications.AppStateBaseBridge.Callback
    public void onExtraInfoUpdated() {
        this.mExtraLoaded = true;
        rebuild();
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onRebuildComplete(ArrayList<ApplicationsState.AppEntry> r6) {
        if (r6 != null) goto L4;
        r6 = new ArrayList();
    L4:
        AppUtils.preloadTopIcons(this, r6, getResources().getInteger(R.integer.config_num_visible_app_icons));
        ArrayList<ApplicationsState.AppEntry> r0 = new ArrayList();
        int r1 = r6.size();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L12;
        ApplicationsState.AppEntry r3 = r6.get(r2);
        if (shouldAddPreference(r3) == false) goto L10;
        r0.add(r3);
    L10:
        r2 = r2 + 1;
        goto L5
    L12:
        if (r0.isEmpty() == false) goto L14;
        showEmptyView();
    L15:
        int r7 = getPackageIdx(this.mPackageName, r0);
        if (r7 < 0) goto L18;
        ArrayList<ApplicationsState.AppEntry> r4 = new ArrayList();
        r4.add(r0.get(r7));
        this.mApplicationAdapter.setData(r4);
        updatePositionAfterNotify();
        return;
    L18:
        this.mApplicationAdapter.setData(r0);
        updatePositionAfterNotify();
        return;
    L14:
        showContent();
        goto L15
    }

    public void rebuild() {
        if (this.mExtraLoaded == true) goto L5;
        return;
    L5:
        ArrayList<ApplicationsState.AppEntry> r0 = this.mSession.rebuild(this.mFilter, ApplicationsState.ALPHA_COMPARATOR);
        if (r0 == null) goto L9;
        onRebuildComplete(r0);
        return;
    }

    static boolean shouldAddPreference(ApplicationsState.AppEntry r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (UserHandle.isApp(r0.info.uid) == false) goto L6;
        return true;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_specialaccess_datausage_DataSaverActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(DataSaverActivity r1) {
        r1.com_android_settings_specialaccess_datausage_DataSaverActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_specialaccess_datausage_DataSaverActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(DataSaverActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_specialaccess_datausage_DataSaverActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_specialaccess_datausage_DataSaverActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(DataSaverActivity r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_specialaccess_datausage_DataSaverActivity__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        DataSaverActivity r5 = r4;
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
    public static void com_android_settings_specialaccess_datausage_DataSaverActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(DataSaverActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_specialaccess_datausage_DataSaverActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_specialaccess_datausage_DataSaverActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(DataSaverActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_specialaccess_datausage_DataSaverActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_specialaccess_datausage_DataSaverActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(DataSaverActivity r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_specialaccess_datausage_DataSaverActivity__onPause$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_specialaccess_datausage_DataSaverActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(DataSaverActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        r3.com_android_settings_specialaccess_datausage_DataSaverActivity__onCreate$___twin___(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        DataSaverActivity r5 = r3;
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
}
