package com.bytedance.article.common.monitor.backfetch;

import a.a;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.util.FileUtils;
import com.bytedance.apm.util.PermissionUtils;
import com.bytedance.article.common.monitor.file.FileUploadManager;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class PermissionFetch {
    public static final String PERMISSION_FILE_BACK_TYPE = "permission_back";
    private static long lastFetchTime;
    private static String[] permissionList;

    public PermissionFetch() {
    }

    public static Map<String, Boolean> checkAppPermissions(Context r6) {
        HashMap r0 = new HashMap();
        String[] r1 = permissionList;
        if (r1 == null) goto L7;
        int r2 = r1.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L7;
        String r4 = r1[r3];
        r0.put(r4, Boolean.valueOf(PermissionUtils.checkSelfPermission(r6, r4)));
        r3 = r3 + 1;
    L7:
        return r0;
    }

    private static String generateUploadFileName() {
        SimpleDateFormat r0 = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
        String r1 = FetchUtils.getVersionName(ApmContext.getHeader());
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return a.j(r0.format(new Date(System.currentTimeMillis())), "_permissionInfo");
    L7:
        return a.B(r0.format(new Date(System.currentTimeMillis())), "_permissionInfo_", r1);
    }

    public static void uploadPermissionFile(Context r4) {
        if (FetchUtils.checkFetchInterval(lastFetchTime, System.currentTimeMillis()) == true) goto L6;
        return;
    L6:
        if (writePermissionInfo(r4) == false) goto L9;
        lastFetchTime = System.currentTimeMillis();
        FileUploadManager.registerFileCallBack(PERMISSION_FILE_BACK_TYPE, new AnonymousClass1());
        return;
    }

    public static boolean writePermissionInfo(Context r6) {
        if (PermissionUtils.isGrantSDCardWritePermission(r6) == true) goto L63;
        return false;
    L63:
        permissionList = r6.getPackageManager().getPackageInfo(r6.getPackageName(), 4096).requestedPermissions;     // Catch: PackageManager.NameNotFoundException -> L53
        StringBuilder r0 = new StringBuilder();
        r0.append(FileUtils.getExternalRootDir(r6).getAbsolutePath());
        String r2 = File.separator;
        r0.append(r2);
        r0.append("backfetch");
        r0.append(r2);
        r0.append("permissioninfo");
        String r1 = r0.toString();
        BufferedWriter r3 = null;
        File r4 = new File(r1);     // Catch: Throwable -> L10 IOException -> L12
        if (r4.exists() == true) goto L14;
        r4.mkdirs();     // Catch: Throwable -> L10 IOException -> L12
    L14:
        FileWriter r5 = new FileWriter(r1 + r2 + generateUploadFileName());     // Catch: Throwable -> L10 IOException -> L12
        BufferedWriter r7 = new BufferedWriter(r5);     // Catch: Throwable -> L31 IOException -> L33
        Iterator<Map.Entry<String, Boolean>> r8 = checkAppPermissions(r6).entrySet().iterator();     // Catch: Throwable -> L21 IOException -> L23
    L18:
        if (r8.hasNext() == false) goto L65;
        Map.Entry<String, Boolean> r9 = r8.next();     // Catch: Throwable -> L21 IOException -> L23
        r7.write(String.format("permission: %s, result: %b\n", new Object[]{r9.getKey(), r9.getValue()}));     // Catch: Throwable -> L21 IOException -> L23
    L65:
        r7.close();     // Catch: IOException -> L27
        r5.close();     // Catch: IOException -> L27
        return true;
    L27:
        e = move-exception;
        e.printStackTrace();
        return true;
    L23:
        e = e;
        r3 = r7;
    L34:
        e.printStackTrace();     // Catch: Throwable -> L31
        if (r3 != null) goto L60;
    L39:
        if (r5 == null) goto L43;
        r5.close();     // Catch: IOException -> L37
    L37:
        e = move-exception;
        e.printStackTrace();
    L43:
        return false;
    L60:
        r3.close();     // Catch: IOException -> L37
    L21:
        th = th;
        r3 = r7;
    L44:
        if (r3 != null) goto L58;
    L48:
        if (r5 == null) goto L52;
        r5.close();     // Catch: IOException -> L46
    L46:
        e = move-exception;
        e.printStackTrace();
    L52:
        throw th;
    L58:
        r3.close();     // Catch: IOException -> L46
    L33:
        e = e;
    L31:
        th = th;
        goto L44
    L12:
        e = e;
        r5 = null;
    L10:
        th = th;
        r5 = null;
    L53:
        e = move-exception;
        e.printStackTrace();
        return false;
    }
}
