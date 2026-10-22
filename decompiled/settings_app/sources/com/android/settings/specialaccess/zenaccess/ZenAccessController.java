package com.android.settings.specialaccess.zenaccess;

import android.app.ActivityManager;
import android.app.AppGlobals;
import android.app.Flags;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.RemoteException;
import android.util.ArraySet;
import com.obric.olog.OLog;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class ZenAccessController {
    private static final String TAG = "ZenAccessController";
    private Context mContext;

    public ZenAccessController(Context r1, String r2) {
        this.mContext = r1;
    }

    public static Set<String> getPackagesRequestingNotificationPolicyAccess() {
        return getPackagesWithPermissions(new String[]{"android.permission.ACCESS_NOTIFICATION_POLICY"});
    }

    public static Set<String> getPackagesWithManageNotifications() {
        return getPackagesWithPermissions(new String[]{"android.permission.MANAGE_NOTIFICATIONS"});
    }

    public static Set<String> getPackagesWithPermissions(String[] r5) {
        ArraySet r0 = new ArraySet();
        List r6 = AppGlobals.getPackageManager().getPackagesHoldingPermissions(r5, 0, ActivityManager.getCurrentUser()).getList();     // Catch: RemoteException -> L12
        if (r6 == null) goto L14;
        Iterator r7 = r6.iterator();     // Catch: RemoteException -> L12
    L7:
        if (r7.hasNext() == false) goto L14;
        PackageInfo r1 = (PackageInfo) r7.next();     // Catch: RemoteException -> L12
        if (r1.applicationInfo.enabled == false) goto L7;
        r0.add(r1.packageName);     // Catch: RemoteException -> L12
    L14:
        return r0;
    L12:
        e = move-exception;
        OLog.e(TAG, "Cannot reach packagemanager", e);
        goto L14
    }

    public static Set<String> getAutoApprovedPackages(Context r2) {
        ArraySet r0 = new ArraySet();
        r0.addAll(((NotificationManager) r2.getSystemService(NotificationManager.class)).getEnabledNotificationListenerPackages());
        return r0;
    }

    public static boolean hasAccess(Context r1, String r2) {
        return ((NotificationManager) r1.getSystemService(NotificationManager.class)).isNotificationPolicyAccessGrantedForPackage(r2);
    }

    public static void setAccess(Context r1, String r2, boolean r3) {
        logSpecialPermissionChange(r3, r2, r1);
        ((NotificationManager) r1.getSystemService(NotificationManager.class)).setNotificationPolicyAccessGranted(r2, r3);
    }

    public static void deleteRules(Context r1, String r2) {
        NotificationManager r3 = (NotificationManager) r1.getSystemService(NotificationManager.class);
        if (Flags.modesApi() == false) goto L5;
        r3.removeAutomaticZenRules(r2, true);
        return;
    L5:
        r3.removeAutomaticZenRules(r2);
    }

    static void logSpecialPermissionChange(boolean r1, String r2, Context r3) {
        if (r1 == false) goto L4;
        int r4 = 768;
    L5:
        OLog.i(TAG, "logCategory: " + r4 + ", packageName: " + r2);
        return;
    L4:
        r4 = 769;
        goto L5
    }
}
