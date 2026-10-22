package com.android.settings.applications;

import android.content.Intent;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public interface ApplicationFeatureProvider {

    public interface ListOfAppsCallback {
        void onListOfAppsResult(List<UserAppInfo> r1);
    }

    public interface NumberOfAppsCallback {
        void onNumberOfAppsResult(int r1);
    }

    void calculateNumberOfAppsWithAdminGrantedPermissions(String[] r1, boolean r2, NumberOfAppsCallback r3);

    void calculateNumberOfPolicyInstalledApps(boolean r1, NumberOfAppsCallback r2);

    List<UserAppInfo> findPersistentPreferredActivities(int r1, Intent[] r2);

    Set<String> getKeepEnabledPackages();

    default CharSequence getTimeSpentInApp(String r1) {
        return "";
    }

    boolean isLongBackgroundTaskPermissionToggleSupported();

    void listAppsWithAdminGrantedPermissions(String[] r1, ListOfAppsCallback r2);

    void listPolicyInstalledApps(ListOfAppsCallback r1);
}
