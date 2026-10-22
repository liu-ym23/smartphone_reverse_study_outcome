package obric.tablet;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import com.obric.privacy.LifeHookActivity2;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.tablet.widget.SearchBar;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SmtBaseColumnActivity extends LifeHookActivity2 implements TabletLayout.SettingsBarListener {
    public static final int COLUMNS_MASK = 3;
    public static final int FEATURE_COMPLEX_SETTINGS_BAR = 16;
    public static final int FEATURE_HAS_TITLE = 4;
    public static final int FEATURE_SIMPLE_SETTINGS_BAR = 8;
    public static final int FEATURE_THREE_COLUMN = 2;
    public static final int FEATURE_TWO_COLUMN = 1;
    public static final int SETTINGS_BAR_MASK = 24;
    private boolean isTabletModeOff;
    ViewGroup mFirstColumn;
    private int mInitFeatureFlags;
    ListView mNavigationListView;
    SearchBar mSearchView;
    ViewGroup mSecondColumn;
    View mSettingsBar;
    private TabletLayout mTabletlayout;
    ViewGroup mThirdColumn;

    protected int getFirstColumnLayoutId() {
        return R.id.first_column;
    }

    protected TabletLayout initCustomTabletLayout() {
        return null;
    }

    public void obric_tablet_SmtBaseColumnActivity__onStop$___twin___() {
        super.onStop();
    }

    public void obric_tablet_SmtBaseColumnActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // obric.tablet.TabletLayout.SettingsBarListener
    public void onAddItemClicked() {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        obric_tablet_SmtBaseColumnActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // obric.tablet.TabletLayout.SettingsBarListener
    public void onDeleteItemClicked() {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        obric_tablet_SmtBaseColumnActivity_com_obric_hook_lancet_PrivacyHookActivity2_onDestroy(this);
    }

    @Override // obric.tablet.TabletLayout.SettingsBarListener
    public void onMoreBtnClicked() {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        obric_tablet_SmtBaseColumnActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        obric_tablet_SmtBaseColumnActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // obric.tablet.TabletLayout.SettingsBarListener
    public void onSettingBtnClicked(View r1) {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        obric_tablet_SmtBaseColumnActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        obric_tablet_SmtBaseColumnActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public SmtBaseColumnActivity() {
        this.isTabletModeOff = false;
        this.mInitFeatureFlags = 0;
    }

    public void obric_tablet_SmtBaseColumnActivity__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        Utils.setTranslucentStatusAndNavigation(getApplicationContext(), getWindow());
        if (this.isTabletModeOff == false) goto L5;
        return;
    L5:
        requestWindowFeature(1);
        TabletLayout r3 = initCustomTabletLayout();
        this.mTabletlayout = r3;
        if (r3 != null) goto L8;
        this.mTabletlayout = new TabletLayout(this);
    L8:
        this.mTabletlayout.requestFeature(this.mInitFeatureFlags);
        this.mTabletlayout.initTabletView();
        setContentView(this.mTabletlayout);
        initView();
    }

    public void turnOffTabletMode() {
        this.isTabletModeOff = true;
    }

    private void initView() {
        this.mSearchView = (SearchBar) findViewById(R.id.search_bar);
        this.mNavigationListView = (ListView) findViewById(R.id.navigation_list);
        this.mFirstColumn = (ViewGroup) findViewById(R.id.first_column);
        this.mSecondColumn = (ViewGroup) findViewById(R.id.second_column);
        this.mThirdColumn = (ViewGroup) findViewById(R.id.third_column);
    }

    protected void setListAdapter(BaseAdapter r1) {
        this.mNavigationListView.setAdapter(r1);
    }

    public void setSearchBarListener(obric.widget.SearchBar.ListenerAdapter r1) {
        this.mSearchView.setListener(r1);
    }

    protected void requestFeature(int r1) {
        this.mTabletlayout.requestFeature(r1);
    }

    protected void requestColumnsFeature(int r2) {
        TabletLayout r0 = this.mTabletlayout;
        if (r0 != null) goto L5;
        int r3 = r2 & 3;
        this.mInitFeatureFlags = r3 | (this.mInitFeatureFlags & (-4));
        return;
    L5:
        r0.requestColumnsFeature(r2);
    }

    protected void requestTitleFeature() {
        this.mInitFeatureFlags |= 4;
    }

    protected void requestSettingBarFeature() {
        requestSettingBarFeature(8);
    }

    protected void requestSettingBarFeature(int r2) {
        TabletLayout r0 = this.mTabletlayout;
        if (r0 != null) goto L5;
        int r3 = r2 & 24;
        this.mInitFeatureFlags = r3 | (this.mInitFeatureFlags & (-25));
        return;
    L5:
        r0.requestSettingBarFeature(r2);
        this.mTabletlayout.setSettingsBarListener(this);
    }

    public ViewGroup getTabletlayout() {
        return this.mTabletlayout;
    }

    protected int getSecondColumnLayoutId() {
        return this.mTabletlayout.getSecondColumnLayoutId();
    }

    protected int getThirdColumnLayoutId() {
        return this.mTabletlayout.getThirdColumnLayoutId();
    }

    protected ListView getNavigationListView() {
        return this.mNavigationListView;
    }

    public SearchBar getSearchBarView() {
        return this.mSearchView;
    }

    public View getSettingBar() {
        return this.mTabletlayout.getSettingBar();
    }

    protected ViewGroup getSecondColumnLayout() {
        return this.mTabletlayout.getSecondColumnLayout();
    }

    protected ViewGroup getThirdColumnLayout() {
        return this.mTabletlayout.getThirdColumnLayout();
    }

    protected void setFirstColumnBgColor(int r1) {
        this.mFirstColumn.setBackgroundColor(r1);
    }

    protected void setFirstColumnBgColorResId(int r1) {
        this.mFirstColumn.setBackgroundResource(r1);
    }

    protected void setSettingsBarBgColor(int r1) {
        this.mTabletlayout.setSettingsBarBgColor(r1);
    }

    protected void setSettingsBarBgColorResId(int r1) {
        this.mTabletlayout.setSettingsBarBgColorResId(r1);
    }

    protected void setFirstColumnShadowVisible(boolean r1) {
        this.mTabletlayout.setFirstColumnShadowVisible(r1);
    }

    public void obric_tablet_SmtBaseColumnActivity__onResume$___twin___() {
        super.onResume();
    }

    public void obric_tablet_SmtBaseColumnActivity__onPause$___twin___() {
        super.onPause();
    }

    public void obric_tablet_SmtBaseColumnActivity__onDestroy$___twin___() {
        super.onDestroy();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void obric_tablet_SmtBaseColumnActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(SmtBaseColumnActivity r1) {
        obric_tablet_SmtBaseColumnActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void obric_tablet_SmtBaseColumnActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(SmtBaseColumnActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        SmtBaseColumnActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.obric_tablet_SmtBaseColumnActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void obric_tablet_SmtBaseColumnActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(SmtBaseColumnActivity r1) {
        String r0 = r1.getClass().getName();
        obric_tablet_SmtBaseColumnActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void obric_tablet_SmtBaseColumnActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(SmtBaseColumnActivity r4) {
        String r0 = r4.getClass().getName();
        obric_tablet_SmtBaseColumnActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        SmtBaseColumnActivity r5 = r4;
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
    public static void obric_tablet_SmtBaseColumnActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(SmtBaseColumnActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.obric_tablet_SmtBaseColumnActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void obric_tablet_SmtBaseColumnActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(SmtBaseColumnActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        obric_tablet_SmtBaseColumnActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void obric_tablet_SmtBaseColumnActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(SmtBaseColumnActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        SmtBaseColumnActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.obric_tablet_SmtBaseColumnActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void obric_tablet_SmtBaseColumnActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(SmtBaseColumnActivity r4) {
        String r0 = r4.getClass().getName();
        obric_tablet_SmtBaseColumnActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void obric_tablet_SmtBaseColumnActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(SmtBaseColumnActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        SmtBaseColumnActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.obric_tablet_SmtBaseColumnActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void obric_tablet_SmtBaseColumnActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(SmtBaseColumnActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        obric_tablet_SmtBaseColumnActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        SmtBaseColumnActivity r5 = r3;
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
    public static void obric_tablet_SmtBaseColumnActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(SmtBaseColumnActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        SmtBaseColumnActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.obric_tablet_SmtBaseColumnActivity__onStop$___twin___();
    }

    @Insert("onDestroy")
    public static void obric_tablet_SmtBaseColumnActivity_com_obric_hook_lancet_PrivacyHookActivity2_onDestroy(SmtBaseColumnActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        SmtBaseColumnActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.obric_tablet_SmtBaseColumnActivity__onDestroy$___twin___();
    }
}
