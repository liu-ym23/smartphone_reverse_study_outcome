package com.bytedance.article.common.monitor.backfetch;

import a.a;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.util.FileUtils;
import com.bytedance.apm.util.PermissionUtils;
import com.bytedance.article.common.monitor.file.FileUploadManager;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class DbFetch {
    private static final String DB_BACKUP_DIR_NAME = "dbFiles";
    public static final String DB_FILE_BACK_TYPE = "db_file_back";
    private static final String DB_SOURCE_DIR_NAME = "databases";
    private static final String DB_SUFFIX = ".db";
    private static boolean fetchSpecificFile = false;
    private static long lastFetchTime;
    private static String specificFileName;
    private static String uploadFileName;

    public DbFetch() {
    }

    public static /* synthetic */ boolean access$002(boolean r0) {
        fetchSpecificFile = r0;
        return r0;
    }

    public static /* synthetic */ String access$102(String r0) {
        specificFileName = r0;
        return r0;
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

    public static boolean copyDbFiles(Context r8) {
        if (PermissionUtils.isGrantSDCardWritePermission(r8) == true) goto L5;
        return false;
    L5:
        StringBuilder r0 = new StringBuilder();
        r0.append(r8.getApplicationInfo().dataDir);
        String r2 = File.separator;
        String r1 = a.o(r0, r2, DB_SOURCE_DIR_NAME);
        String r9 = r8.getApplicationInfo().dataDir + r2 + DB_BACKUP_DIR_NAME;
        String r3 = a.B(r9, r2, "/tmp");
        File r4 = new File(r1);
        if (r4.exists() == false) goto L36;
        File[] r5 = r4.listFiles();
        int r6 = r5.length;
        int r7 = 0;
    L8:
        if (r7 >= r6) goto L36;
        File r10 = r5[r7];
        String r11 = r10.getName();
        if (r11.endsWith(DB_SUFFIX) == false) goto L17;
        if (fetchSpecificFile == true) goto L17;
        if (FileUtils.copyFile(r10.getAbsolutePath(), r3, r11) == true) goto L17;
        return false;
    L17:
        if (fetchSpecificFile == false) goto L25;
        if (TextUtils.isEmpty(specificFileName) == true) goto L25;
        if (specificFileName.equals(r11) == false) goto L25;
        if (FileUtils.copyFile(r10.getAbsolutePath(), r3, r11) == true) goto L25;
        return false;
    L25:
        r7 = r7 + 1;
    L36:
        StringBuilder r12 = new StringBuilder();     // Catch: Exception -> L33
        r12.append(r9);     // Catch: Exception -> L33
        String r13 = File.separator;     // Catch: Exception -> L33
        r12.append(r13);     // Catch: Exception -> L33
        r12.append(uploadFileName);     // Catch: Exception -> L33
        FileUtils.compress(r12.toString(), new String[]{r3});     // Catch: Exception -> L33
        FileUtils.removeDir(r3);
        StringBuilder r14 = a.t(r9, r13);
        r14.append(uploadFileName);
        File r15 = new File(r14.toString());
        if (checkSize(r15) == true) goto L31;
        r15.delete();
        return generateErrorFile(r9, uploadFileName + " file to big");
    L31:
        return true;
    L33:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static boolean generateErrorFile(String r3, String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L10;
        return false;
    L10:
        new File(r3, a.A("DbFileError: ", r4)).createNewFile();     // Catch: IOException -> L9
        return true;
    L9:
        return false;
    }

    private static String generateUploadFileName() {
        SimpleDateFormat r0 = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
        String r1 = FetchUtils.getVersionName(ApmContext.getHeader());
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return a.j(r0.format(new Date(System.currentTimeMillis())), "_db.zip");
    L7:
        return r0.format(new Date(System.currentTimeMillis())) + "_db_" + r1 + ".zip";
    }

    public static void uploadDBFiles(final Context r4, String r5) {
        if (FetchUtils.checkFetchInterval(lastFetchTime, System.currentTimeMillis()) == true) goto L5;
        return;
    L5:
        uploadFileName = generateUploadFileName();
        if (TextUtils.isEmpty(r5) == true) goto L9;
        fetchSpecificFile = true;
        specificFileName = r5;
    L9:
        if (copyDbFiles(r4) == false) goto L12;
        lastFetchTime = System.currentTimeMillis();
        FileUploadManager.registerFileCallBack(DB_FILE_BACK_TYPE, new AnonymousClass1(r4));
        return;
    }
}
