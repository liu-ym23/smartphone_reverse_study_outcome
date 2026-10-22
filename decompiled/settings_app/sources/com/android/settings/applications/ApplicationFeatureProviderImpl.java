package com.android.settings.applications;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.UserInfo;
import android.location.LocationManager;
import android.os.RemoteException;
import android.os.SystemConfigManager;
import android.os.UserManager;
import android.telecom.DefaultDialerManager;
import android.text.TextUtils;
import android.util.ArraySet;
import com.GlobalProxyLancet;
import com.android.internal.telephony.SmsApplication;
import com.android.settings.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class ApplicationFeatureProviderImpl implements ApplicationFeatureProvider {
    private static final int EUICC_QUERY_FLAGS = 269484096;
    private static final String TAG = "AppFeatureProviderImpl";
    protected final Context mContext;
    private final DevicePolicyManager mDpm;
    private final PackageManager mPm;
    private final IPackageManager mPms;
    private final SystemConfigManager mSystemConfigManager;
    private final UserManager mUm;

    private static class CurrentUserAndManagedProfileAppWithAdminGrantedPermissionsCounter extends AppWithAdminGrantedPermissionsCounter {
        private ApplicationFeatureProvider.NumberOfAppsCallback mCallback;

        CurrentUserAndManagedProfileAppWithAdminGrantedPermissionsCounter(Context r1, String[] r2, PackageManager r3, IPackageManager r4, DevicePolicyManager r5, ApplicationFeatureProvider.NumberOfAppsCallback r6) {
            super(r1, r2, r3, r4, r5);
            this.mCallback = r6;
        }

        @Override // com.android.settings.applications.AppCounter
        protected void onCountComplete(int r1) {
            this.mCallback.onNumberOfAppsResult(r1);
        }
    }

    private static class CurrentUserAndManagedProfilePolicyInstalledAppCounter extends InstalledAppCounter {
        private ApplicationFeatureProvider.NumberOfAppsCallback mCallback;

        CurrentUserAndManagedProfilePolicyInstalledAppCounter(Context r2, PackageManager r3, ApplicationFeatureProvider.NumberOfAppsCallback r4) {
            super(r2, 1, r3);
            this.mCallback = r4;
        }

        @Override // com.android.settings.applications.AppCounter
        protected void onCountComplete(int r1) {
            this.mCallback.onNumberOfAppsResult(r1);
        }
    }

    private static class CurrentUserAppWithAdminGrantedPermissionsLister extends AppWithAdminGrantedPermissionsLister {
        private ApplicationFeatureProvider.ListOfAppsCallback mCallback;

        CurrentUserAppWithAdminGrantedPermissionsLister(String[] r1, PackageManager r2, IPackageManager r3, DevicePolicyManager r4, UserManager r5, ApplicationFeatureProvider.ListOfAppsCallback r6) {
            super(r1, r2, r3, r4, r5);
            this.mCallback = r6;
        }

        @Override // com.android.settings.applications.AppLister
        protected void onAppListBuilt(List<UserAppInfo> r1) {
            this.mCallback.onListOfAppsResult(r1);
        }
    }

    private static class CurrentUserPolicyInstalledAppLister extends InstalledAppLister {
        private ApplicationFeatureProvider.ListOfAppsCallback mCallback;

        CurrentUserPolicyInstalledAppLister(PackageManager r1, UserManager r2, ApplicationFeatureProvider.ListOfAppsCallback r3) {
            super(r1, r2);
            this.mCallback = r3;
        }

        @Override // com.android.settings.applications.AppLister
        protected void onAppListBuilt(List<UserAppInfo> r1) {
            this.mCallback.onListOfAppsResult(r1);
        }
    }

    @Override // com.android.settings.applications.ApplicationFeatureProvider
    public boolean isLongBackgroundTaskPermissionToggleSupported() {
        return false;
    }

    public ApplicationFeatureProviderImpl(Context r2, PackageManager r3, IPackageManager r4) {
        Context r0 = r2.getApplicationContext();
        this.mContext = r0;
        this.mPm = r3;
        this.mPms = r4;
        this.mDpm = (DevicePolicyManager) r2.getSystemService(DevicePolicyManager.class);
        this.mUm = UserManager.get(r0);
        this.mSystemConfigManager = (SystemConfigManager) r2.getSystemService(SystemConfigManager.class);
    }

    @Override // com.android.settings.applications.ApplicationFeatureProvider
    public void calculateNumberOfPolicyInstalledApps(boolean r3, ApplicationFeatureProvider.NumberOfAppsCallback r4) {
        CurrentUserAndManagedProfilePolicyInstalledAppCounter r0 = new CurrentUserAndManagedProfilePolicyInstalledAppCounter(this.mContext, this.mPm, r4);
        if (r3 == false) goto L5;
        r0.execute(new Void[0]);
        return;
    L5:
        r0.executeInForeground();
    }

    @Override // com.android.settings.applications.ApplicationFeatureProvider
    public void listPolicyInstalledApps(ApplicationFeatureProvider.ListOfAppsCallback r3) {
        new CurrentUserPolicyInstalledAppLister(this.mPm, this.mUm, r3).execute(new Void[0]);
    }

    @Override // com.android.settings.applications.ApplicationFeatureProvider
    public void calculateNumberOfAppsWithAdminGrantedPermissions(String[] r9, boolean r10, ApplicationFeatureProvider.NumberOfAppsCallback r11) {
        CurrentUserAndManagedProfileAppWithAdminGrantedPermissionsCounter r7 = new CurrentUserAndManagedProfileAppWithAdminGrantedPermissionsCounter(this.mContext, r9, this.mPm, this.mPms, this.mDpm, r11);
        if (r10 == false) goto L5;
        r7.execute(new Void[0]);
        return;
    L5:
        r7.executeInForeground();
    }

    @Override // com.android.settings.applications.ApplicationFeatureProvider
    public void listAppsWithAdminGrantedPermissions(String[] r9, ApplicationFeatureProvider.ListOfAppsCallback r10) {
        new CurrentUserAppWithAdminGrantedPermissionsLister(r9, this.mPm, this.mPms, this.mDpm, this.mUm, r10).execute(new Void[0]);
    }

    @Override // com.android.settings.applications.ApplicationFeatureProvider
    public List<UserAppInfo> findPersistentPreferredActivities(int r8, Intent[] r9) {
        ArrayList r0 = new ArrayList();
        ArraySet r1 = new ArraySet();
        UserInfo r2 = this.mUm.getUserInfo(r8);
        int r3 = r9.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L22;
        Intent r5 = r9[r4];
        ResolveInfo r6 = this.mPms.findPersistentPreferredActivity(r5, r8);     // Catch: RemoteException -> L23
        if (r6 == null) goto L21;
        if (r6.activityInfo == null) goto L11;
        ComponentInfo r7 = r6.activityInfo;     // Catch: RemoteException -> L23
    L17:
        if (r7 == null) goto L21;
        UserAppInfo r10 = new UserAppInfo(r2, r7.applicationInfo);     // Catch: RemoteException -> L23
        if (r1.add(r10) == false) goto L21;
        r0.add(r10);     // Catch: RemoteException -> L23
        goto L21
    L11:
        if (r6.serviceInfo == null) goto L14;
        r7 = r6.serviceInfo;     // Catch: RemoteException -> L23
        goto L17
    L14:
        if (r6.providerInfo == null) goto L16;
        r7 = r6.providerInfo;     // Catch: RemoteException -> L23
        goto L17
    L16:
        r7 = null;
    L21:
        r4 = r4 + 1;
        goto L3
    L22:
        return r0;
    }

    @Override // com.android.settings.applications.ApplicationFeatureProvider
    public Set<String> getKeepEnabledPackages() {
        ArraySet r0 = new ArraySet();
        String r1 = DefaultDialerManager.getDefaultDialerApplication(this.mContext);
        if (TextUtils.isEmpty(r1) == true) goto L5;
        r0.add(r1);
    L5:
        ComponentName r2 = SmsApplication.getDefaultSmsApplication(this.mContext, true);
        if (r2 == null) goto L8;
        r0.add(r2.getPackageName());
    L8:
        ComponentInfo r3 = findEuiccService(this.mPm);
        if (r3 == null) goto L11;
        r0.add(r3.packageName);
    L11:
        r0.addAll(getEnabledPackageAllowlist());
        String r4 = ((LocationManager) this.mContext.getSystemService("location")).getExtraLocationControllerPackage();
        if (r4 == null) goto L14;
        r0.add(r4);
    L14:
        r0.addAll(this.mSystemConfigManager.getPreventUserDisablePackages());
        return r0;
    }

    private Set<String> getEnabledPackageAllowlist() {
        ArraySet r0 = new ArraySet();
        r0.add(this.mContext.getString(R.string.config_settingsintelligence_package_name));
        r0.add(this.mContext.getString(R.string.config_package_installer_package_name));
        if (this.mPm.getWellbeingPackageName() == null) goto L5;
        r0.add(this.mPm.getWellbeingPackageName());
    L5:
        return r0;
    }

    ComponentInfo findEuiccService(PackageManager r3) {
        ComponentInfo r2 = findEuiccService(r3, r3.queryIntentServices(new Intent("android.service.euicc.EuiccService"), EUICC_QUERY_FLAGS));
        if (r2 != null) goto L5;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "No valid EuiccService implementation found");
    L5:
        return r2;
    }

    private ComponentInfo findEuiccService(PackageManager r6, List<ResolveInfo> r7) {
        ComponentInfo r0 = null;
        if (r7 == null) goto L13;
        Iterator<ResolveInfo> r8 = r7.iterator();
        int r1 = Integer.MIN_VALUE;
    L6:
        if (r8.hasNext() == false) goto L13;
        ResolveInfo r2 = r8.next();
        if (isValidEuiccComponent(r6, r2) == false) goto L6;
        if (r2.filter.getPriority() <= r1) goto L6;
        int r3 = r2.filter.getPriority();
        r1 = r3;
        r0 = getComponentInfo(r2);
    L13:
        return r0;
    }

    private boolean isValidEuiccComponent(PackageManager r5, ResolveInfo r6) {
        ComponentInfo r4 = getComponentInfo(r6);
        String r0 = r4.packageName;
        if (r5.checkPermission("android.permission.WRITE_EMBEDDED_SUBSCRIPTIONS", r0) == 0) goto L7;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "Package " + r0 + " does not declare WRITE_EMBEDDED_SUBSCRIPTIONS");
        return false;
    L7:
        if ((r4 instanceof ServiceInfo) == false) goto L10;
        String r7 = ((ServiceInfo) r4).permission;
    L13:
        if (TextUtils.equals(r7, "android.permission.BIND_EUICC_SERVICE") == true) goto L17;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "Package " + r0 + " does not require the BIND_EUICC_SERVICE permission");
        return false;
    L17:
        if (r6.filter != null) goto L19;
    L23:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "Package " + r0 + " does not specify a priority");
        return false;
    L19:
        if (r6.filter.getPriority() == 0) goto L23;
        return true;
    L10:
        if ((r4 instanceof ActivityInfo) == false) goto L26;
        r7 = ((ActivityInfo) r4).permission;
        goto L13
    L26:
        throw new IllegalArgumentException("Can only verify services/activities");
    }

    private ComponentInfo getComponentInfo(ResolveInfo r1) {
        if (r1.activityInfo == null) goto L7;
        return r1.activityInfo;
    L7:
        if (r1.serviceInfo == null) goto L11;
        return r1.serviceInfo;
    L11:
        if (r1.providerInfo == null) goto L15;
        return r1.providerInfo;
    L15:
        throw new IllegalStateException("Missing ComponentInfo!");
    }
}
