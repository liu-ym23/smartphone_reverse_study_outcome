package com.bytedance.article.common.monitor.backfetch;

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

/* JADX INFO: loaded from: classes3.dex */
public class DbFetch {
    private static final String DB_BACKUP_DIR_NAME = "dbFiles";
    public static final String DB_FILE_BACK_TYPE = "db_file_back";
    private static final String DB_SOURCE_DIR_NAME = "databases";
    private static final String DB_SUFFIX = ".db";
    private static boolean fetchSpecificFile = false;
    private static long lastFetchTime;
    private static String specificFileName;
    private static String uploadFileName;

    static {
    }

    public DbFetch() {
    }

    static /* synthetic */ boolean access$002(boolean r0) {
        fetchSpecificFile = r0;
        return r0;
    }

    static /* synthetic */ String access$102(String r0) {
        specificFileName = r0;
        return r0;
    }

    public static boolean copyDbFiles(Context r8) {
        if (PermissionUtils.isGrantSDCardWritePermission(r8) == true) goto L5;
        return false;
    L5:
        String r0 = r8.getApplicationInfo().dataDir + File.separator + DB_SOURCE_DIR_NAME;
        String r9 = r8.getApplicationInfo().dataDir + File.separator + DB_BACKUP_DIR_NAME;
        String r2 = r9 + File.separator + "/tmp";
        File r3 = new File(r0);
        if (r3.exists() == false) goto L35;
        File[] r1 = r3.listFiles();
        int r4 = r1.length;
        int r5 = 0;
    L8:
        if (r5 >= r4) goto L35;
        File r6 = r1[r5];
        String r7 = r6.getName();
        if (r7.endsWith(DB_SUFFIX) == false) goto L17;
        if (fetchSpecificFile == true) goto L17;
        if (FileUtils.copyFile(r6.getAbsolutePath(), r2, r7) == true) goto L17;
        return false;
    L17:
        if (fetchSpecificFile == false) goto L25;
        if (TextUtils.isEmpty(specificFileName) == true) goto L25;
        if (specificFileName.equals(r7) == false) goto L25;
        if (FileUtils.copyFile(r6.getAbsolutePath(), r2, r7) == true) goto L25;
        return false;
    L25:
        r5 = r5 + 1;
    L35:
        FileUtils.compress(r9 + File.separator + uploadFileName, new String[]{r2});     // Catch: Exception -> L32
        FileUtils.removeDir(r2);
        File r10 = new File(r9 + File.separator + uploadFileName);
        if (checkSize(r10) == true) goto L31;
        r10.delete();
        return generateErrorFile(r9, String.format("%s file to big", new Object[]{uploadFileName}));
    L31:
        return true;
    L32:
        e = move-exception;
        e.printStackTrace();
        return false;
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

    public static boolean generateErrorFile(String r4, String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L9;
        return false;
    L9:
        new File(r4, String.format("DbFileError: %s", new Object[]{r5})).createNewFile();     // Catch: IOException -> L8
        return true;
    L8:
        return false;
    }

    private static String generateUploadFileName() {
        SimpleDateFormat r0 = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
        String r1 = FetchUtils.getVersionName(ApmContext.getHeaderInner());
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return String.format("%s_db.zip", new Object[]{r0.format(new Date(System.currentTimeMillis()))});
    L7:
        return String.format("%s_db_%s.zip", new Object[]{r0.format(new Date(System.currentTimeMillis())), r1});
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
