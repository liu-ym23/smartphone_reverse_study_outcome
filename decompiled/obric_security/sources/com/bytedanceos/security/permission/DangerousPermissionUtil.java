package com.bytedanceos.security.permission;

import android.app.AppOpsManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.UserHandle;
import android.text.TextUtils;
import com.bytedanceos.clearmemory.RunningStateHelper;
import com.bytedanceos.security.PermissionCompat;
import com.bytedanceos.security.Utils;
import com.bytedanceos.security.multi.adpter.MultiSdkAdapter;
import com.bytedanceos.security.reflect.OpsManagerHelper;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class DangerousPermissionUtil {
    public static final String BROADCAST_PERMISSION_CHANGE_ACTION = "com.bytedanceos.permission.PERMISSION_CHANGE";
    public static final int BROADCAST_PERMISSION_SOURCE_SECURITY = 2;
    private static final String TAG = "DangerousPermissionUtil";

    public DangerousPermissionUtil() {
    }

    public static OpenSystemApp getOpenSystemAppByPkg(String pkg) {
        if (TextUtils.isEmpty(pkg) == false) goto L5;
        return null;
    L5:
        Iterator<OpenSystemApp> r0 = OpenSystemConstant.getAllOpenSystemApps().iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        OpenSystemApp r2 = r0.next();
        if (TextUtils.equals(pkg, r2.getPackageName()) == false) goto L7;
        return r2;
    L11:
        return null;
    }

    public static boolean isOpenSystemAppHiddenPermission(String pkg, String[] permission) {
        OpenSystemApp r8 = getOpenSystemAppByPkg(pkg);
        if (r8 == null) goto L17;
        if (permission == null) goto L17;
        if (permission.length < 1) goto L17;
        String[] r9 = r8.getHiddenDangerousPermissions();
        int r1 = r9.length;
        int r3 = 0;
    L9:
        if (r3 >= r1) goto L17;
        String r4 = r9[r3];
        int r5 = permission.length;
        int r6 = 0;
    L11:
        if (r6 >= r5) goto L16;
        if (TextUtils.equals(r4, permission[r6]) == true) goto L14;
        r6 = r6 + 1;
        goto L11
    L14:
        return true;
    L16:
        r3 = r3 + 1;
    L17:
        return false;
    }

    public static boolean isOpenSystemApp(String packageName) {
        if (MultiSdkAdapter.sdkIsBeforeO() == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(packageName) == false) goto L8;
        return false;
    L8:
        if (getOpenSystemAppByPkg(packageName) == null) goto L12;
        return true;
    L12:
        return false;
    }

    public static List<ResolveInfo> getAllLaunchApps(PackageManager pm) {
        if (pm != null) goto L5;
        return null;
    L5:
        Intent r1 = new Intent("android.intent.action.MAIN", null);
        r1.addCategory("android.intent.category.LAUNCHER");
        List<ResolveInfo> r2 = pm.queryIntentActivitiesAsUser(r1, 0, 0);
        List<ResolveInfo> r4 = pm.queryIntentActivitiesAsUser(r1, 0, 10);
        if (r2 == null) goto L10;
        if (r4 == null) goto L11;
        r2.addAll(r4);
        return r2;
    L11:
        return r2;
    L10:
        return r4;
    }

    public static boolean isLaunchApp(String packageName, List<ResolveInfo> allLunchApps) {
        if (TextUtils.isEmpty(packageName) == true) goto L14;
        if (allLunchApps == null) goto L14;
        if (allLunchApps.size() < 1) goto L14;
        Iterator<ResolveInfo> r4 = allLunchApps.iterator();
    L10:
        if (r4.hasNext() == false) goto L14;
        if (TextUtils.equals(packageName, r4.next().activityInfo.packageName) == false) goto L10;
        return true;
    L14:
        return false;
    }

    public static List<String> filterPermission(NativePermission permission, String[] appPermissions) {
        String[] r0 = permission.getPermissions();
        if (r0 == null) goto L19;
        if (appPermissions != null) goto L7;
        return null;
    L7:
        if (permission.hasBackgroundPermission() == false) goto L9;
        r0 = (String[]) Arrays.copyOf(r0, r0.length + 1);
        r0[r0.length - 1] = permission.getBackgroundPermission();
    L9:
        ArrayList r9 = new ArrayList();
        int r1 = r0.length;
        int r3 = 0;
    L10:
        if (r3 >= r1) goto L18;
        String r4 = r0[r3];
        int r5 = appPermissions.length;
        int r6 = 0;
    L12:
        if (r6 >= r5) goto L17;
        String r7 = appPermissions[r6];
        if (TextUtils.equals(r7, r4) == false) goto L16;
        r9.add(r7);
    L16:
        r6 = r6 + 1;
        goto L12
    L17:
        r3 = r3 + 1;
        goto L10
    L18:
        return r9;
    L19:
        return null;
    }

    public static boolean supportRuntimePermission(PackageInfo packageInfo) {
        if (packageInfo != null) goto L6;
        return false;
    L6:
        if (packageInfo.applicationInfo.targetSdkVersion <= 22) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean validSepicalPermission(Context context, NativePermission permission, String[] appHasPermission) {
        if (permission != null) goto L5;
    L25:
        return false;
    L5:
        if (permission.isSepicalPermission() == false) goto L25;
        if (TextUtils.equals(NativePermissionManager.PERMISSION_INSTALL_UNKONW_RESOURCE, permission.getPermissionName()) == true) goto L24;
        if (TextUtils.equals(NativePermissionManager.PERMISSION_START_ON_BACKGROUND, permission.getPermissionName()) == true) goto L24;
        if (TextUtils.equals(NativePermissionManager.PERMISSION_NFC, permission.getPermissionName()) == false) goto L22;
        List<String> r5 = filterPermission(permission, appHasPermission);
        if (r5 != null) goto L17;
    L21:
        return false;
    L17:
        if (r5.size() < 1) goto L21;
        return Utils.isNfcSupport(context);
    L22:
        return true;
    L24:
        return !MultiSdkAdapter.sdkIsBeforeO();
    }

    public static int getDangerousPermissionMode(AppOpsManager appOpsManager, PackageManager packageManager, PackageInfo sourcepackageInfo, String permission) {
        ArrayList r0 = new ArrayList();
        r0.add(permission);
        return getDangerousPermissionMode(appOpsManager, packageManager, sourcepackageInfo, r0);
    }

    public static boolean isPermissionGranted(Application app, String packageName, String permission, UserHandle user) {
        PackageManager r2 = app.createContextAsUser(user, 0).getPackageManager();     // Catch: Exception -> L16
        int r5 = r2.getPermissionFlags(permission, packageName, user);     // Catch: Exception -> L16
        if (r2.checkPermission(permission, packageName) != 0) goto L6;
        boolean r3 = true;
    L8:
        if ((r5 & 8) == 0) goto L10;
        boolean r4 = true;
    L11:
        if (r3 == false) goto L15;
        if (r4 == true) goto L15;
        return true;
    L15:
        return false;
    L10:
        r4 = false;
        goto L11
    L6:
        r3 = false;
    L20:
        return true;
    }

    public static UserHandle getUserHandleFromCallingUid(int callingUid) {
        return UserHandle.of(UserHandle.getUserId(callingUid));
    L5:
        return UserHandle.of(0);
    }

    public static int getDangerousPermissionMode(AppOpsManager appOpsManager, PackageManager packageManager, PackageInfo sourcepackageInfo, List<String> permission) {
        if (sourcepackageInfo == null) goto L4;
        int r0 = sourcepackageInfo.applicationInfo.uid;     // Catch: Exception -> L40
        String r1 = sourcepackageInfo.packageName;     // Catch: Exception -> L40
        boolean r10 = supportRuntimePermission(sourcepackageInfo);     // Catch: Exception -> L40
        if (TextUtils.isEmpty(r1) == true) goto L8;
        PackageInfo r9 = packageManager.getPackageInfoAsUser(r1, 4096, UserHandle.getUserId(r0));     // Catch: Exception -> L40
        if (r9 == null) goto L39;
        if (r9.requestedPermissions == null) goto L39;
        int r2 = r9.requestedPermissions.length;     // Catch: Exception -> L40
        int r3 = 0;
    L15:
        if (r3 >= r2) goto L43;
        String r4 = r9.requestedPermissions[r3];     // Catch: Exception -> L40
        Iterator<String> r5 = permission.iterator();     // Catch: Exception -> L40
    L17:
        boolean r7 = true;
        if (r5.hasNext() == false) goto L22;
        if (r4.equals(r5.next()) == false) goto L17;
        boolean r6 = true;
    L23:
        if (r6 == false) goto L37;
        if (r10 == true) goto L27;
        String r8 = AppOpsManager.permissionToOp(r4);     // Catch: Exception -> L40
        if (TextUtils.isEmpty(r8) == false) goto L32;
    L33:
        r7 = false;
    L34:
        if (r7 == false) goto L37;
        return OpsManagerHelper.get_MODE_ALLOWED();
    L32:
        return MultiSdkAdapter.checkAppOp(appOpsManager, r8, r9.applicationInfo.uid, r1);
    L27:
        if ((r9.requestedPermissionsFlags[r3] & 2) == 0) goto L33;
    L37:
        r3 = r3 + 1;     // Catch: Exception -> L40
        goto L15
    L22:
        r6 = false;
    L43:
        return OpsManagerHelper.get_MODE_IGNORED();
    L39:
        return OpsManagerHelper.get_MODE_IGNORED();
    L8:
        return OpsManagerHelper.get_MODE_IGNORED();
    L4:
        return OpsManagerHelper.get_MODE_IGNORED();
    L40:
        e = move-exception;
        OLog.d(TAG, "getDangerousPermissionMode exception=" + e);
        goto L43
    }

    public static void setOpsMode(AppOpsManager appOpsManager, PackageInfo packageInfo, String permission, int mode) {
        if (appOpsManager == null) goto L15;
        if (packageInfo != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(permission) == false) goto L8;
        return;
    L8:
        if (RiskPermissionControlGuard.isSensitivePermissionChangeBlocked(packageInfo) == false) goto L10;
        return;
    L10:
        int r2 = packageInfo.applicationInfo.uid;
        String r3 = AppOpsManager.permissionToOp(permission);
        if (TextUtils.isEmpty(r3) == false) goto L13;
        return;
    L13:
        appOpsManager.setUidMode(r3, r2, mode);
        return;
    }

    public static void grantBackgroundPermission(AppOpsManager appOpsManager, PackageManager packageManager, PackageInfo packageInfo, String permission) {
        if (packageInfo != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(permission) == true) goto L9;
        ArrayList r0 = new ArrayList();
        r0.add(permission);
        grantDangrousRuntimePermission(appOpsManager, packageManager, packageInfo, r0, -1);
        return;
    }

    public static void grantDangrousRuntimePermission(AppOpsManager appOpsManager, PackageManager packageManager, PackageInfo packageInfo, List<String> permissions, int smtOpCode) {
        if (packageInfo != null) goto L26;
        return;
    L26:
    L22:
        e = move-exception;
        OLog.d(TAG, "grantDangrousRuntimePermission exception=" + e);
        return;
    L6:
        if (RiskPermissionControlGuard.isSensitivePermissionChangeBlocked(packageInfo) == false) goto L8;
        return;
    L8:
        int r1 = packageInfo.applicationInfo.uid;     // Catch: Exception -> L22
        String r8 = packageInfo.packageName;     // Catch: Exception -> L22
        boolean r13 = supportRuntimePermission(packageInfo);     // Catch: Exception -> L22
        UserHandle r9 = new UserHandle(UserHandle.getUserId(r1));     // Catch: Exception -> L22
        Iterator<String> r14 = permissions.iterator();     // Catch: Exception -> L22
    L10:
        if (r14.hasNext() == false) goto L37;
        String r10 = r14.next();     // Catch: Exception -> L22
        String r2 = AppOpsManager.permissionToOp(r10);     // Catch: Exception -> L25
        if (TextUtils.isEmpty(r2) == true) goto L16;
        appOpsManager.setUidMode(r2, r1, 0);     // Catch: Exception -> L25
    L16:
        if (smtOpCode <= (-1)) goto L18;
        OpsManagerHelper.getInstance().setMode(smtOpCode, r1, r8, OpsManagerHelper.get_MODE_ALLOWED());     // Catch: Exception -> L25
    L18:
        if (r13 == false) goto L10;
        packageManager.grantRuntimePermission(r8, r10, r9);     // Catch: Exception -> L25
        packageManager.updatePermissionFlags(r10, r8, PermissionCompat.FLAG_MASK, 0, r9);     // Catch: Exception -> L25
        OLog.d(TAG, "grant permission=" + r10);     // Catch: Exception -> L25
        goto L10
    }

    public static void revokeBackgroundPermission(AppOpsManager appOpsManager, PackageManager packageManager, PackageInfo packageInfo, String permission) {
        if (packageInfo != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(permission) == false) goto L7;
        return;
    L7:
        if (getDangerousPermissionMode(appOpsManager, packageManager, packageInfo, permission) != OpsManagerHelper.get_MODE_ALLOWED()) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L13;
        OLog.d(TAG, "background permission not granted ,don't need to revoke");
        return;
    L13:
        ArrayList r1 = new ArrayList();
        r1.add(permission);
        revokePermissions(appOpsManager, packageManager, packageInfo, r1, -1);
        return;
    L9:
        r0 = false;
        goto L10
    }

    public static void revokePermissions(AppOpsManager appOpsManager, PackageManager packageManager, PackageInfo packageInfo, List<String> permissions, int smtOpCode) {
        if (packageInfo != null) goto L41;
        return;
    L41:
    L33:
        e = move-exception;
        OLog.d(TAG, "revokePermissions exception=" + e);
        return;
    L6:
        if (RiskPermissionControlGuard.isSensitivePermissionChangeBlocked(packageInfo) == false) goto L8;
        return;
    L8:
        int r3 = packageInfo.applicationInfo.uid;     // Catch: Exception -> L33
        String r10 = packageInfo.packageName;     // Catch: Exception -> L33
        boolean r11 = supportRuntimePermission(packageInfo);     // Catch: Exception -> L33
        UserHandle r12 = new UserHandle(UserHandle.getUserId(r3));     // Catch: Exception -> L33
        Iterator<String> r13 = permissions.iterator();     // Catch: Exception -> L33
    L10:
        if (r13.hasNext() == false) goto L31;
        String r14 = r13.next();     // Catch: Exception -> L33
        String r4 = AppOpsManager.permissionToOp(r14);     // Catch: Exception -> L30
        if (r11 == false) goto L19;
        if (MultiSdkAdapter.isAfterQ() == true) goto L19;
    L26:
        if (r11 == false) goto L10;
        packageManager.revokeRuntimePermission(r10, r14, r12);     // Catch: Exception -> L36
        packageManager.updatePermissionFlags(r14, r10, PermissionCompat.FLAG_MASK, 1, r12);     // Catch: Exception -> L36
        OLog.d(TAG, "revoke permission=" + r14);     // Catch: Exception -> L36
    L19:
        if (TextUtils.isEmpty(r4) == true) goto L24;
        appOpsManager.setUidMode(r4, r3, 1);     // Catch: Exception -> L36
    L24:
        if (smtOpCode <= (-1)) goto L26;
        OpsManagerHelper.getInstance().setMode(smtOpCode, r3, r10, OpsManagerHelper.get_MODE_IGNORED());     // Catch: Exception -> L36
        goto L26
    L31:
        RunningStateHelper.getInstance().restartPackage(packageInfo);     // Catch: Exception -> L33
    }

    public static <T> boolean contains(T[] array, T value) {
        if (indexOf(array, value) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public static <T> int indexOf(T[] array, T value) {
        if (array != null) goto L5;
        return -1;
    L5:
        int r1 = 0;
    L7:
        if (r1 >= array.length) goto L12;
        if (Objects.equals(array[r1], value) == true) goto L10;
        r1 = r1 + 1;
        goto L7
    L10:
        return r1;
    L12:
        return -1;
    }
}
