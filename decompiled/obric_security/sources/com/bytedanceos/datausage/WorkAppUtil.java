package com.bytedanceos.datausage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.UserInfo;
import android.os.UserHandle;
import android.os.UserManager;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class WorkAppUtil {
    private static final String TAG = "WorkAppUtil";
    public static PackageManager workPm;

    static {
    }

    public WorkAppUtil() {
    }

    public static void initWorkPackageManager(Context context) {
        if (workPm != null) goto L13;
        int r0 = getWorkProfileUserId(context);
        if (r0 == (-1)) goto L14;
        workPm = context.createContextAsUser(UserHandle.of(r0), 0).getPackageManager();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        OLog.e(TAG, "初始化工作资料PackageManager失败", e);
        return;
    L14:
        return;
    }

    public static List<ApplicationInfo> getWorkAppsByUserId(Context context, int workUserId) {
        ArrayList r1 = new ArrayList();
        Iterator r4 = context.getPackageManager().getInstalledApplicationsAsUser(128, workUserId).iterator();     // Catch: Exception -> L11
    L5:
        if (r4.hasNext() == false) goto L9;
        ApplicationInfo r2 = (ApplicationInfo) r4.next();     // Catch: Exception -> L11
        if ((r2.flags & 1) != 0) goto L5;
        r1.add(r2);     // Catch: Exception -> L11
        goto L5
    L9:
        OLog.d(TAG, "工作资料（ID=" + workUserId + "）下共找到" + r1.size() + "个应用");     // Catch: Exception -> L11
    L13:
        return r1;
    L11:
        e = move-exception;
        OLog.e(TAG, "获取工作资料应用失败", e);
        goto L13
    }

    public static List<String> getWorkAppPackageNames(Context context, int workUserId) {
        ArrayList r0 = new ArrayList();
        Iterator<ApplicationInfo> r1 = getWorkAppsByUserId(context, workUserId).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.add(r1.next().packageName);
        goto L4
    L6:
        return r0;
    }

    public static String getWorkAppName(Context context, String packageName, int workUserId) {
        PackageManager r1 = context.getPackageManager();
        return r1.getApplicationLabel(r1.getApplicationInfoAsUser(packageName, 0, workUserId)).toString();
    L5:
        e = move-exception;
        OLog.w(TAG, "未找到应用：" + packageName, e);
        return packageName;
    }

    public static int getWorkProfileUserId(Context context) {
        UserManager r3 = (UserManager) context.getSystemService("user");
        if (r3 != null) goto L5;
        return -1;
    L5:
        List r4 = r3.getUsers();
        if (r4 != null) goto L8;
    L21:
        return -1;
    L8:
        if (r4.isEmpty() == true) goto L21;
        Iterator r5 = r4.iterator();
    L12:
        if (r5.hasNext() == false) goto L21;
        UserInfo r1 = (UserInfo) r5.next();
        if (r1.isManagedProfile() == false) goto L12;
        if (r1.isEnabled() == false) goto L12;
        if (r1.isGuest() == true) goto L12;
        return r1.id;
    }

    public static List<ApplicationInfo> getWorkProfileAppList(Context context) {
        ArrayList r1 = new ArrayList();
        Iterator<UserHandle> r2 = ((UserManager) context.getSystemService("user")).getUserProfiles().iterator();     // Catch: Exception -> L15 SecurityException -> L17
    L5:
        if (r2.hasNext() == false) goto L19;
        UserHandle r3 = r2.next();     // Catch: Exception -> L15 SecurityException -> L17
        Context r5 = context.createContextAsUser(r3, 0);     // Catch: Exception -> L15 SecurityException -> L17
        if (r3.getIdentifier() != getWorkProfileUserId(context)) goto L5;
        PackageManager r4 = r5.getPackageManager();     // Catch: Exception -> L15 SecurityException -> L17
        Iterator<ApplicationInfo> r6 = r4.getInstalledApplications(0).iterator();     // Catch: Exception -> L15 SecurityException -> L17
    L10:
        if (r6.hasNext() == false) goto L5;
        ApplicationInfo r7 = r6.next();     // Catch: Exception -> L15 SecurityException -> L17
        if ((r7.flags & 1) != 0) goto L10;
        String r8 = r7.packageName;     // Catch: Exception -> L15 SecurityException -> L17
        String r9 = r4.getApplicationLabel(r7).toString();     // Catch: Exception -> L15 SecurityException -> L17
        r1.add(r7);     // Catch: Exception -> L15 SecurityException -> L17
        workPm = r4;     // Catch: Exception -> L15 SecurityException -> L17
        OLog.d(TAG, "工作 Profile 应用：" + r9 + " (" + r8 + ")");     // Catch: Exception -> L15 SecurityException -> L17
    L19:
        return r1;
    L17:
        e = move-exception;
        OLog.e(TAG, "无跨 Profile 权限，无法获取工作 Profile 应用列表", e);
    L15:
        e = move-exception;
        OLog.e(TAG, "获取工作 Profile 应用列表失败", e);
        goto L19
    }
}
