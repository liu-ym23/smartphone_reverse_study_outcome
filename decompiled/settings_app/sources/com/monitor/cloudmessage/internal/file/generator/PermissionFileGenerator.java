package com.monitor.cloudmessage.internal.file.generator;

import android.content.Context;
import android.content.pm.PackageManager;
import com.monitor.cloudmessage.utils.FileUtils;
import com.monitor.cloudmessage.utils.PermissionUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class PermissionFileGenerator {
    private static String[] permissionList;

    static {
    }

    public PermissionFileGenerator() {
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

    /* JADX WARN: Multi-variable type inference failed */
    public static File writePermissionInfo(Context r9) {
        BufferedWriter r0 = 0;
        r0 = 0;
        permissionList = r9.getPackageManager().getPackageInfo(r9.getPackageName(), 4096).requestedPermissions;     // Catch: PackageManager.NameNotFoundException -> L52
        String r1 = FileUtils.getCloudMsgDir(r9).getAbsolutePath() + File.separator + "permissionInfo";
        String r2 = r1 + File.separator + "permission.txt";
        File r4 = new File(r1);     // Catch: Throwable -> L27 IOException -> L29
        if (r4.exists() == true) goto L8;
        r4.mkdirs();     // Catch: Throwable -> L27 IOException -> L29
    L8:
        FileWriter r5 = new FileWriter(r1 + File.separator + "permission.txt");     // Catch: Throwable -> L27 IOException -> L29
    L67:
        BufferedWriter r3 = new BufferedWriter(r5);     // Catch: Throwable -> L23 IOException -> L25
        Iterator<Map.Entry<String, Boolean>> r10 = checkAppPermissions(r9).entrySet().iterator();     // Catch: IOException -> L21 Throwable -> L41
    L12:
        if (r10.hasNext() == false) goto L62;
        Map.Entry<String, Boolean> r6 = r10.next();     // Catch: IOException -> L21 Throwable -> L41
        r3.write(String.format("permission: %s, result: %b\n", new Object[]{r6.getKey(), r6.getValue()}));     // Catch: IOException -> L21 Throwable -> L41
        goto L12
    L62:
        r3.close();     // Catch: IOException -> L17
        r5.close();     // Catch: IOException -> L17
    L20:
        return new File(r2);
    L17:
        e = move-exception;
        e.printStackTrace();
    L21:
        e = e;
    L31:
        e.printStackTrace();     // Catch: Throwable -> L41
        if (r3 != null) goto L60;
    L36:
        if (r5 == null) goto L40;
        r5.close();     // Catch: IOException -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
    L40:
        return null;
    L60:
        r3.close();     // Catch: IOException -> L34
        goto L36
    L25:
        e = e;
        r3 = null;
    L23:
        th = th;
    L43:
        if (r0 != 0) goto L55;
    L47:
        if (r5 == null) goto L51;
        r5.close();     // Catch: IOException -> L45
    L45:
        e = move-exception;
        e.printStackTrace();
    L51:
        throw th;
    L55:
        r0.close();     // Catch: IOException -> L45
    L41:
        th = th;
        r0 = r1;
    L29:
        e = e;
        r3 = null;
        r5 = null;
    L27:
        th = th;
        r5 = null;
    L52:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
