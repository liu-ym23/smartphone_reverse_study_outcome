package com.android.settings.enterprise;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.UserHandle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.applications.ApplicationFeatureProvider;
import com.android.settings.applications.UserAppInfo;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.overlay.FeatureFactory;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.oui.bouncelayout.OListView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ApplicationListFragment extends BaseFragment {
    private AppListAdapter mAdapter;
    private OListView mAppListView;
    private ApplicationFeatureProvider mApplicationFeatureProvider;

    private static abstract class AdminGrantedPermission extends ApplicationListFragment {
        private final String[] mPermissions;

        AdminGrantedPermission(String[] r1) {
            this.mPermissions = r1;
        }

        @Override // com.android.settings.enterprise.ApplicationListFragment
        public void buildApplicationList(Context r1, ApplicationFeatureProvider.ListOfAppsCallback r2) {
            FeatureFactory.getFeatureFactory().getApplicationFeatureProvider().listAppsWithAdminGrantedPermissions(this.mPermissions, r2);
        }
    }

    public static class AdminGrantedPermissionCamera extends AdminGrantedPermission {
        public void com_android_settings_enterprise_ApplicationListFragment$AdminGrantedPermissionCamera__onResume$___twin___() {
            super.onResume();
        }

        @Override // com.android.settings.enterprise.ApplicationListFragment, com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_enterprise_ApplicationListFragment$AdminGrantedPermissionCamera_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // com.android.settings.enterprise.ApplicationListFragment, com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_enterprise_ApplicationListFragment$AdminGrantedPermissionCamera_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        @Override // com.android.settings.enterprise.ApplicationListFragment.AdminGrantedPermission, com.android.settings.enterprise.ApplicationListFragment
        public /* bridge */ /* synthetic */ void buildApplicationList(Context r1, ApplicationFeatureProvider.ListOfAppsCallback r2) {
            super.buildApplicationList(r1, r2);
        }

        public AdminGrantedPermissionCamera() {
            super(new String[]{"android.permission.CAMERA"});
        }

        public void com_android_settings_enterprise_ApplicationListFragment$AdminGrantedPermissionCamera__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
            this.mTitleResId = Integer.valueOf(R.string.enterprise_privacy_camera_access);
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_enterprise_ApplicationListFragment$AdminGrantedPermissionCamera_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AdminGrantedPermissionCamera r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_enterprise_ApplicationListFragment$AdminGrantedPermissionCamera__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_enterprise_ApplicationListFragment$AdminGrantedPermissionCamera_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AdminGrantedPermissionCamera r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_enterprise_ApplicationListFragment$AdminGrantedPermissionCamera_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_enterprise_ApplicationListFragment$AdminGrantedPermissionCamera_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AdminGrantedPermissionCamera r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_enterprise_ApplicationListFragment$AdminGrantedPermissionCamera__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    public static class AdminGrantedPermissionLocation extends AdminGrantedPermission {
        public void com_android_settings_enterprise_ApplicationListFragment$AdminGrantedPermissionLocation__onResume$___twin___() {
            super.onResume();
        }

        @Override // com.android.settings.enterprise.ApplicationListFragment, com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_enterprise_ApplicationListFragment$AdminGrantedPermissionLocation_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // com.android.settings.enterprise.ApplicationListFragment, com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_enterprise_ApplicationListFragment$AdminGrantedPermissionLocation_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        @Override // com.android.settings.enterprise.ApplicationListFragment.AdminGrantedPermission, com.android.settings.enterprise.ApplicationListFragment
        public /* bridge */ /* synthetic */ void buildApplicationList(Context r1, ApplicationFeatureProvider.ListOfAppsCallback r2) {
            super.buildApplicationList(r1, r2);
        }

        public AdminGrantedPermissionLocation() {
            super(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"});
        }

        public void com_android_settings_enterprise_ApplicationListFragment$AdminGrantedPermissionLocation__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
            this.mTitleResId = Integer.valueOf(R.string.enterprise_privacy_location_access);
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_enterprise_ApplicationListFragment$AdminGrantedPermissionLocation_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AdminGrantedPermissionLocation r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_enterprise_ApplicationListFragment$AdminGrantedPermissionLocation__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_enterprise_ApplicationListFragment$AdminGrantedPermissionLocation_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AdminGrantedPermissionLocation r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_enterprise_ApplicationListFragment$AdminGrantedPermissionLocation_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_enterprise_ApplicationListFragment$AdminGrantedPermissionLocation_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AdminGrantedPermissionLocation r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_enterprise_ApplicationListFragment$AdminGrantedPermissionLocation__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    public static class AdminGrantedPermissionMicrophone extends AdminGrantedPermission {
        public void com_android_settings_enterprise_ApplicationListFragment$AdminGrantedPermissionMicrophone__onResume$___twin___() {
            super.onResume();
        }

        @Override // com.android.settings.enterprise.ApplicationListFragment, com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_enterprise_ApplicationListFragment$AdminGrantedPermissionMicrophone_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // com.android.settings.enterprise.ApplicationListFragment, com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_enterprise_ApplicationListFragment$AdminGrantedPermissionMicrophone_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        @Override // com.android.settings.enterprise.ApplicationListFragment.AdminGrantedPermission, com.android.settings.enterprise.ApplicationListFragment
        public /* bridge */ /* synthetic */ void buildApplicationList(Context r1, ApplicationFeatureProvider.ListOfAppsCallback r2) {
            super.buildApplicationList(r1, r2);
        }

        public AdminGrantedPermissionMicrophone() {
            super(new String[]{"android.permission.RECORD_AUDIO"});
        }

        public void com_android_settings_enterprise_ApplicationListFragment$AdminGrantedPermissionMicrophone__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
            this.mTitleResId = Integer.valueOf(R.string.enterprise_privacy_microphone_access);
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_enterprise_ApplicationListFragment$AdminGrantedPermissionMicrophone_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AdminGrantedPermissionMicrophone r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_enterprise_ApplicationListFragment$AdminGrantedPermissionMicrophone__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_enterprise_ApplicationListFragment$AdminGrantedPermissionMicrophone_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AdminGrantedPermissionMicrophone r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_enterprise_ApplicationListFragment$AdminGrantedPermissionMicrophone_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_enterprise_ApplicationListFragment$AdminGrantedPermissionMicrophone_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AdminGrantedPermissionMicrophone r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_enterprise_ApplicationListFragment$AdminGrantedPermissionMicrophone__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    private class AppListAdapter extends BaseAdapter {
        private List<UserAppInfo> mApps;
        private PackageManager mPm;
        final /* synthetic */ ApplicationListFragment this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        @Override // android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int r1) {
            return getItem(r1);
        }

        AppListAdapter(ApplicationListFragment r2) {
            this.this$0 = r2;
            this.mApps = new ArrayList();
            this.mPm = r2.mContext.getPackageManager();
        }

        void setData(List<UserAppInfo> r2) {
            this.mApps.clear();
            if (r2 == null) goto L5;
            this.mApps.addAll(r2);
        L5:
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mApps.size();
        }

        @Override // android.widget.Adapter
        public UserAppInfo getItem(int r1) {
            return this.mApps.get(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r6, View r7, ViewGroup r8) {
            boolean r9 = true;
            if (r7 != null) goto L5;
        L7:
            OCardListItem r10 = new OCardListItem(this.this$0.mContext);
            r10.setCardType(0);
            r10.showIcon(true);
            r10.showSubTitle(false);
            r10.showTailIcon(false);
            r10.showCustomEnd(false);
        L8:
            UserAppInfo r1 = getItem(r6);
            if (r1 == null) goto L20;
            r10.setTitle(r1.appInfo.loadLabel(this.mPm));
            r10.showTitle(true);
            Drawable r2 = r1.appInfo.loadUnbadgedIcon(this.mPm);
            if (r1.userInfo != null) goto L13;
        L15:
            OCardListItemUtils.setIcon(r10, r2);
            if (r2 != null) goto L19;
            r9 = false;
        L19:
            r10.showIcon(r9);
            goto L20
        L13:
            if (r1.userInfo.id == UserHandle.myUserId()) goto L15;
            r2 = this.mPm.getUserBadgedIcon(r2, UserHandle.of(r1.userInfo.id));
        L20:
            OCardListItemUtils.initCardItemInAdapter(this, r10, r6);
            return r10;
        L5:
            if ((r7 instanceof OCardListItem) == false) goto L7;
            r10 = (OCardListItem) r7;
            goto L8
        }
    }

    public static class EnterpriseInstalledPackages extends ApplicationListFragment {
        public void com_android_settings_enterprise_ApplicationListFragment$EnterpriseInstalledPackages__onResume$___twin___() {
            super.onResume();
        }

        @Override // com.android.settings.enterprise.ApplicationListFragment, com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_enterprise_ApplicationListFragment$EnterpriseInstalledPackages_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // com.android.settings.enterprise.ApplicationListFragment, com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_enterprise_ApplicationListFragment$EnterpriseInstalledPackages_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        public EnterpriseInstalledPackages() {
        }

        public void com_android_settings_enterprise_ApplicationListFragment$EnterpriseInstalledPackages__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
            this.mTitleResId = Integer.valueOf(R.string.enterprise_privacy_enterprise_installed_packages);
        }

        @Override // com.android.settings.enterprise.ApplicationListFragment
        public void buildApplicationList(Context r1, ApplicationFeatureProvider.ListOfAppsCallback r2) {
            FeatureFactory.getFeatureFactory().getApplicationFeatureProvider().listPolicyInstalledApps(r2);
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_enterprise_ApplicationListFragment$EnterpriseInstalledPackages_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(EnterpriseInstalledPackages r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_enterprise_ApplicationListFragment$EnterpriseInstalledPackages__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_enterprise_ApplicationListFragment$EnterpriseInstalledPackages_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(EnterpriseInstalledPackages r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_enterprise_ApplicationListFragment$EnterpriseInstalledPackages_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_enterprise_ApplicationListFragment$EnterpriseInstalledPackages_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(EnterpriseInstalledPackages r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_enterprise_ApplicationListFragment$EnterpriseInstalledPackages__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    public abstract void buildApplicationList(Context r1, ApplicationFeatureProvider.ListOfAppsCallback r2);

    public ApplicationListFragment() {
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.mApplicationFeatureProvider = FeatureFactory.getFeatureFactory().getApplicationFeatureProvider();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.enterprise_app_list_layout, r3, false);
        this.mAppListView = (OListView) findViewById(R.id.app_list);
        AppListAdapter r5 = new AppListAdapter(this);
        this.mAdapter = r5;
        this.mAppListView.setAdapter(r5);
        return this.mRootView;
    }

    @Override // com.android.settings.base.BaseFragment
    protected void initTitleView(View r2) {
        super.initTitleView(r2);
        this.mTitleView.setOnClickListener(new ApplicationListFragment$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: renamed from: lambda$initTitleView$0$com-android-settings-enterprise-ApplicationListFragment, reason: not valid java name */
    /* synthetic */ void m453x99e810ea(View r1) {
        Utils.hideInputMethod(getActivity());
        getActivity().onBackPressed();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        refreshUi();
    }

    private void refreshUi() {
        buildApplicationList(this.mContext, new ApplicationListFragment$$ExternalSyntheticLambda1(this));
    }

    /* JADX INFO: renamed from: lambda$refreshUi$2$com-android-settings-enterprise-ApplicationListFragment, reason: not valid java name */
    /* synthetic */ void m455xd0d86ece(final List r3) {
        if (getActivity() == null) goto L6;
        getActivity().runOnUiThread(new ApplicationListFragment$$ExternalSyntheticLambda2(this, r3));
        return;
    }

    /* JADX INFO: renamed from: lambda$refreshUi$1$com-android-settings-enterprise-ApplicationListFragment, reason: not valid java name */
    /* synthetic */ void m454xab4465cd(List r1) {
        this.mAdapter.setData(r1);
    }
}
