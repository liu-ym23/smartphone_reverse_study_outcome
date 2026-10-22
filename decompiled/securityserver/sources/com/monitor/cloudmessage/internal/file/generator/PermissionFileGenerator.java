package com.monitor.cloudmessage.internal.file.generator;

import a.a;
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

/* JADX INFO: loaded from: classes.dex */
public class PermissionFileGenerator {
    private static String[] permissionList;

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
    public static File writePermissionInfo(Context r7) {
        BufferedWriter r0 = 0;
        r0 = 0;
        permissionList = r7.getPackageManager().getPackageInfo(r7.getPackageName(), 4096).requestedPermissions;     // Catch: PackageManager.NameNotFoundException -> L52
        StringBuilder r1 = new StringBuilder();
        r1.append(FileUtils.getCloudMsgDir(r7).getAbsolutePath());
        String r2 = File.separator;
        String r3 = a.o(r1, r2, "permissionInfo");
        String r4 = a.B(r3, r2, "permission.txt");
        File r5 = new File(r3);     // Catch: Throwable -> L8 IOException -> L10
        if (r5.exists() == true) goto L12;
        r5.mkdirs();     // Catch: Throwable -> L8 IOException -> L10
    L12:
        FileWriter r6 = new FileWriter(r3 + r2 + "permission.txt");     // Catch: Throwable -> L8 IOException -> L10
    L67:
        BufferedWriter r8 = new BufferedWriter(r6);     // Catch: Throwable -> L29 IOException -> L31
        Iterator<Map.Entry<String, Boolean>> r9 = checkAppPermissions(r7).entrySet().iterator();     // Catch: Throwable -> L19 IOException -> L21
    L16:
        if (r9.hasNext() == false) goto L64;
        Map.Entry<String, Boolean> r10 = r9.next();     // Catch: Throwable -> L19 IOException -> L21
        r8.write(String.format("permission: %s, result: %b\n", new Object[]{r10.getKey(), r10.getValue()}));     // Catch: Throwable -> L19 IOException -> L21
        goto L16
    L64:
        r8.close();     // Catch: IOException -> L25
        r6.close();     // Catch: IOException -> L25
    L28:
        return new File(r4);
    L25:
        e = move-exception;
        e.printStackTrace();
    L21:
        e = e;
    L33:
        e.printStackTrace();     // Catch: Throwable -> L19
        if (r8 != null) goto L58;
    L38:
        if (r6 == null) goto L42;
        r6.close();     // Catch: IOException -> L36
    L36:
        e = move-exception;
        e.printStackTrace();
    L42:
        return null;
    L58:
        r8.close();     // Catch: IOException -> L36
        goto L38
    L31:
        e = e;
        r8 = null;
    L29:
        th = th;
    L43:
        if (r0 != 0) goto L55;
    L47:
        if (r6 == null) goto L51;
        r6.close();     // Catch: IOException -> L45
    L45:
        e = move-exception;
        e.printStackTrace();
    L51:
        throw th;
    L55:
        r0.close();     // Catch: IOException -> L45
    L19:
        th = th;
        r0 = r3;
    L10:
        e = e;
        r8 = null;
        r6 = null;
    L8:
        th = th;
        r6 = null;
    L52:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
