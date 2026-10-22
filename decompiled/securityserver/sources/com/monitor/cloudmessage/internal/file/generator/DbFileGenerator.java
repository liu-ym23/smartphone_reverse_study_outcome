package com.monitor.cloudmessage.internal.file.generator;

import a.a;
import android.content.Context;
import android.text.TextUtils;
import com.monitor.cloudmessage.utils.FileUtils;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class DbFileGenerator {
    private static final String DB_BACKUP_DIR_NAME = "dbFiles";
    private static final String DB_SOURCE_DIR_NAME = "databases";
    private static final String DB_SUFFIX = ".db";
    private static boolean fetchSpecificFile = false;
    private static String specificFileName = null;
    private static String uploadFileName = "db.zip";

    public DbFileGenerator() {
    }

    public static boolean checkSize(File r4) {
        if (r4.exists() == true) goto L5;
        return true;
    L5:
        if (r4.length() <= 52428800) goto L10;
        return false;
    L10:
        return true;
    }

    public static void clearData(Context r1) {
        FileUtils.removeDir(r1.getApplicationInfo().dataDir + File.separator + DB_BACKUP_DIR_NAME);
    }

    public static File copyDbFiles(Context r7, String r8) {
        if (TextUtils.isEmpty(r8) == true) goto L5;
        fetchSpecificFile = true;
        specificFileName = r8;
    L5:
        StringBuilder r9 = new StringBuilder();
        r9.append(r7.getApplicationInfo().dataDir);
        String r0 = File.separator;
        String r10 = a.o(r9, r0, DB_SOURCE_DIR_NAME);
        String r11 = r7.getApplicationInfo().dataDir + r0 + DB_BACKUP_DIR_NAME;
        String r1 = a.B(r11, r0, "/tmp");
        File r2 = new File(r10);
        if (r2.exists() == false) goto L32;
        File[] r12 = r2.listFiles();
        int r3 = r12.length;
        int r4 = 0;
    L8:
        if (r4 >= r3) goto L32;
        File r5 = r12[r4];
        String r6 = r5.getName();
        if (r6.endsWith(DB_SUFFIX) == false) goto L17;
        if (fetchSpecificFile == true) goto L17;
        if (FileUtils.copyFile(r5.getAbsolutePath(), r1, r6) == true) goto L17;
        return null;
    L17:
        if (fetchSpecificFile == false) goto L25;
        if (TextUtils.isEmpty(specificFileName) == true) goto L25;
        if (specificFileName.equals(r6) == false) goto L25;
        if (FileUtils.copyFile(r5.getAbsolutePath(), r1, r6) == true) goto L25;
        return null;
    L25:
        r4 = r4 + 1;
    L32:
        StringBuilder r13 = new StringBuilder();     // Catch: Exception -> L29
        r13.append(r11);     // Catch: Exception -> L29
        String r14 = File.separator;     // Catch: Exception -> L29
        r13.append(r14);     // Catch: Exception -> L29
        r13.append(uploadFileName);     // Catch: Exception -> L29
        FileUtils.zip(r1, r13.toString());     // Catch: Exception -> L29
        FileUtils.removeDir(r1);
        StringBuilder r15 = a.t(r11, r14);
        r15.append(uploadFileName);
        return new File(r15.toString());
    L29:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
