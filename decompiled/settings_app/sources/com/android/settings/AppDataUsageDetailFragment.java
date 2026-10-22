package com.android.settings;

import android.net.NetworkPolicyManager;
import android.os.Bundle;
import android.os.UserHandle;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ScrollView;
import bytedanceos.api.SmtOpsManagerSmt;
import com.android.settings.applications.InstalledAppDetails;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.riskcontrol.RiskPermissionControlGuard;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.DataUsageStatHelper;
import com.android.settings.utils.UIUtils;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class AppDataUsageDetailFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener {
    private OCardListItem mAllowMobileData;
    private OCardListItem mAllowNetBg;
    private int mAppUid;
    private DataUsageStatHelper mDataUsageStatHelper;
    private OCardListItem mMonthUsageView;
    private NetworkPolicyManager mNpm;
    private String mPackageName;
    private View mPermSettingsContainer;
    private OCardListItem mToadyUsageView;
    private OCardListItem mWeekUsageView;

    public void com_android_settings_AppDataUsageDetailFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_AppDataUsageDetailFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_AppDataUsageDetailFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_AppDataUsageDetailFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public AppDataUsageDetailFragment() {
    }

    static /* synthetic */ void access$000(AppDataUsageDetailFragment r0, DataUsageStatHelper.AppDataUsageInfo r1) {
        r0.refreshDataUsageSummary(r1);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.app_data_usage_detail_layout, r3, false);
        this.mNpm = NetworkPolicyManager.from(this.mContext);
        this.mDataUsageStatHelper = DataUsageStatHelper.getInstance(this.mContext);
        this.mToadyUsageView = (OCardListItem) findViewByIdNullable(R.id.today);
        this.mWeekUsageView = (OCardListItem) findViewByIdNullable(R.id.week);
        this.mMonthUsageView = (OCardListItem) findViewByIdNullable(R.id.month);
        this.mPermSettingsContainer = findViewByIdNullable(R.id.id_perm_settings_container);
        this.mAllowMobileData = (OCardListItem) findViewByIdNullable(R.id.id_data_permision);
        this.mAllowNetBg = (OCardListItem) findViewByIdNullable(R.id.id_use_data_background);
        setRiskControlTouchInterceptor(this.mAllowMobileData);
        setRiskControlTouchInterceptor(this.mAllowNetBg);
        retrieveAppEntry();
        Utils.setAppLabelAndIconViews(this.mRootView, this.mPackageName, this.mAppUid);
        if (Utils.isSystemPackage(this.mContext, this.mPackageName) == false) goto L5;
    L6:
        this.mPermSettingsContainer.setVisibility(8);
    L8:
        return this.mRootView;
    L5:
        if (UserHandle.isApp(this.mAppUid) == true) goto L8;
        goto L6
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        UIUtils.fitMaskSmallTitle(this, (ScrollView) findViewByIdNullable(R.id.page_scrollview));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r2) {
        super.onViewStateRestored(r2);
        if (Utils.isPackageInstalled(this.mContext, this.mPackageName) == false) goto L5;
        refreshUi();
    L6:
        OCardListItemUtils.setOnCheckedChangeListener(this.mAllowMobileData, this);
        OCardListItemUtils.setOnCheckedChangeListener(this.mAllowNetBg, this);
        return;
    L5:
        finish();
        goto L6
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        if (Utils.isPackageInstalled(this.mContext, this.mPackageName) == false) goto L5;
        refreshUi();
        return;
    L5:
        finish();
    }

    private void refreshUi() {
        int r0 = SmtOpsManagerSmt.getInstance().checkOp(this.mContext, 16, this.mAppUid, this.mPackageName);
        OCardListItemUtils.setOnCheckedChangeListener(this.mAllowMobileData, null);
        OCardListItem r1 = this.mAllowMobileData;
        if (r0 != 0) goto L5;
        boolean r2 = true;
    L6:
        OCardListItemUtils.setChecked(r1, r2);
        OCardListItemUtils.setOnCheckedChangeListener(this.mAllowMobileData, this);
        if ((this.mNpm.getUidPolicy(this.mAppUid) & 16) == 0) goto L9;
        boolean r3 = true;
    L10:
        OCardListItemUtils.setOnCheckedChangeListener(this.mAllowNetBg, null);
        OCardListItemUtils.setChecked(this.mAllowNetBg, !r3);
        OCardListItemUtils.setOnCheckedChangeListener(this.mAllowNetBg, this);
        if (isPermManagerEnable() == false) goto L13;
        OCardListItemUtils.setEnabled(this.mAllowMobileData, true);
        OCardListItemUtils.setEnabled(this.mAllowNetBg, true);
    L14:
        refreshDataUsageAsync();
        return;
    L13:
        OCardListItemUtils.setEnabled(this.mAllowMobileData, false);
        OCardListItemUtils.setEnabled(this.mAllowNetBg, false);
        goto L14
    L9:
        r3 = false;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    private void retrieveAppEntry() {
        Bundle r0 = getArguments();
        String r1 = r0.getString("package");
        this.mPackageName = r1;
        if (r1 != null) goto L6;
        finish();
        return;
    L6:
        int r2 = r0.getInt(InstalledAppDetails.ARG_APP_UID, Utils.getAppUid(this.mContext, this.mPackageName));
        this.mAppUid = r2;
        if (r2 != (-1)) goto L10;
        finish();
        return;
    }

    private void refreshDataUsageAsync() {
        this.mDataUsageStatHelper.forceUpdateAsync(this.mAppUid, new AnonymousClass1(this));
    }

    private void refreshDataUsageSummary(DataUsageStatHelper.AppDataUsageInfo r7) {
        String r0 = Formatter.formatFileSize(this.mContext, r7.todayTotal, 8).replace('k', 'K');
        OCardListItemUtils.setTrailingText(this.mToadyUsageView, r0);
        String r1 = Formatter.formatFileSize(this.mContext, r7.weekTotal, 8).replace('k', 'K');
        OCardListItemUtils.setTrailingText(this.mWeekUsageView, r1);
        String r8 = Formatter.formatFileSize(this.mContext, r7.monthTotal, 8).replace('k', 'K');
        OCardListItemUtils.setTrailingText(this.mMonthUsageView, r8);
    }

    private boolean isPermManagerEnable() {
        return SmtOpsManagerSmt.getInstance().getEnabled(this.mContext);
    }

    private void setRiskControlTouchInterceptor(OCardListItem r2) {
        OCardListItemUtils.getSwitchView(r2).setOnTouchListener(new AppDataUsageDetailFragment$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: renamed from: lambda$setRiskControlTouchInterceptor$0$com-android-settings-AppDataUsageDetailFragment, reason: not valid java name */
    /* synthetic */ boolean m99xbad7f5ae(View r3, MotionEvent r4) {
        return RiskPermissionControlGuard.interceptOnActionUp(getActivity(), this.mPackageName, UserHandle.getUserId(this.mAppUid), 3, r4);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r9, boolean r10) {
        if (RiskPermissionControlGuard.intercept(getActivity(), this.mPackageName, UserHandle.getUserId(this.mAppUid), 3) == false) goto L11;
        if (OCardListItemUtils.getSwitchView(this.mAllowMobileData) != r9) goto L7;
        OCardListItem r11 = this.mAllowMobileData;
    L8:
        OCardListItemUtils.setOnCheckedChangeListener(r11, null);
        OCardListItemUtils.setChecked(r11, !r10);
        OCardListItemUtils.setOnCheckedChangeListener(r11, this);
        return;
    L7:
        r11 = this.mAllowNetBg;
        goto L8
    L11:
        if (OCardListItemUtils.getSwitchView(this.mAllowMobileData) != r9) goto L16;
        int r12 = !r10 ? 1 : 0;
        if (r12 == SmtOpsManagerSmt.getInstance().checkOp(r9.getContext(), 16, this.mAppUid, this.mPackageName)) goto L21;
        SmtOpsManagerSmt.getInstance().setMode(r9.getContext(), 16, this.mAppUid, this.mPackageName, r12);
        OLog.d(this.TAG, "CurrentUid : " + this.mAppUid + "CurrentPackName : " + this.mPackageName + "mode :" + r12);
        return;
    L21:
        return;
    L16:
        if (OCardListItemUtils.getSwitchView(this.mAllowNetBg) != r9) goto L23;
        if (r10 == false) goto L19;
        trySetUidPolicy(this.mAppUid, 0);
        return;
    L19:
        trySetUidPolicy(this.mAppUid, 16);
        return;
    }

    private void trySetUidPolicy(int r3, int r4) {
        this.mNpm.setUidPolicy(r3, r4);     // Catch: IllegalArgumentException -> L4
        return;
    L4:
        e = move-exception;
        OLog.e(this.TAG, "Cannot apply policy to UID " + r3 + ": " + e.getMessage());
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_AppDataUsageDetailFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AppDataUsageDetailFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_AppDataUsageDetailFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_AppDataUsageDetailFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AppDataUsageDetailFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_AppDataUsageDetailFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_AppDataUsageDetailFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AppDataUsageDetailFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_AppDataUsageDetailFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
