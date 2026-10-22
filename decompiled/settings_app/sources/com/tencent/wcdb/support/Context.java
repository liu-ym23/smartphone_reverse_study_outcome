package com.tencent.wcdb.support;

import com.tencent.wcdb.DatabaseErrorHandler;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public final class Context {
    public static final int MODE_ENABLE_WRITE_AHEAD_LOGGING = 8;

    public Context() {
    }

    static {
        SQLiteGlobal.loadLib();
    }

    private static File getDataDirFile(android.content.Context r1) {
        if (r1 == null) goto L9;
        String r2 = r1.getApplicationInfo().dataDir;
        if (r2 != null) goto L10;
        return null;
    L10:
        return new File(r2);
    L9:
        throw new RuntimeException("Not supported in system context");
    }

    private static File getDatabasesDir(android.content.Context r2) {
        File r0 = new File(getDataDirFile(r2), "databases");
        if (r0.getPath().equals("databases") == true) goto L5;
        return r0;
    L5:
        return new File("/data/system");
    }

    private static File makeFilename(File r2, String r3) {
        if (r3.indexOf(File.separatorChar) >= 0) goto L7;
        return new File(r2, r3);
    L7:
        throw new IllegalArgumentException("File " + r3 + " contains a path separator");
    }

    private static File validateFilePath(android.content.Context r3, String r4, boolean r5) {
        if (r4.charAt(0) != File.separatorChar) goto L5;
        File r0 = new File(r4.substring(0, r4.lastIndexOf(File.separatorChar)));
        File r6 = new File(r0, r4.substring(r4.lastIndexOf(File.separatorChar)));
    L6:
        if (r5 == true) goto L8;
    L12:
        return r6;
    L8:
        if (r0.isDirectory() == true) goto L12;
        if (r0.mkdir() == false) goto L12;
        FileUtils.setPermissions(r0.getPath(), 505, -1, -1);
        goto L12
    L5:
        r0 = getDatabasesDir(r3);
        r6 = makeFilename(r0, r4);
        goto L6
    }

    private static void setFilePermissionsFromMode(String r1, int r2, int r3) {
        int r4 = r3 | 432;
        if ((r2 & 1) == 0) goto L6;
        r4 = r4 | 4;
    L6:
        if ((r2 & 2) == 0) goto L8;
        r4 = r4 | 2;
    L8:
        FileUtils.setPermissions(r1, r4, -1, -1);
    }

    public static SQLiteDatabase openOrCreateDatabase(android.content.Context r8, String r9, int r10, SQLiteDatabase.CursorFactory r11) {
        return openOrCreateDatabase(r8, r9, null, null, r10, r11, null, 0);
    }

    public static SQLiteDatabase openOrCreateDatabase(android.content.Context r8, String r9, int r10, SQLiteDatabase.CursorFactory r11, DatabaseErrorHandler r12) {
        return openOrCreateDatabase(r8, r9, null, null, r10, r11, r12, 0);
    }

    public static SQLiteDatabase openOrCreateDatabase(android.content.Context r8, String r9, byte[] r10, SQLiteCipherSpec r11, int r12, SQLiteDatabase.CursorFactory r13) {
        return openOrCreateDatabase(r8, r9, r10, r11, r12, r13, null, 0);
    }

    public static SQLiteDatabase openOrCreateDatabase(android.content.Context r8, String r9, byte[] r10, SQLiteCipherSpec r11, int r12, SQLiteDatabase.CursorFactory r13, DatabaseErrorHandler r14) {
        return openOrCreateDatabase(r8, r9, r10, r11, r12, r13, r14, 0);
    }

    public static SQLiteDatabase openOrCreateDatabase(android.content.Context r7, String r8, byte[] r9, SQLiteCipherSpec r10, int r11, SQLiteDatabase.CursorFactory r12, DatabaseErrorHandler r13, int r14) {
        File r15 = validateFilePath(r7, r8, true);
        if ((r11 & 8) == 0) goto L5;
        int r16 = 805306368;
    L6:
        String r0 = r15.getPath();
        SQLiteDatabase r17 = SQLiteDatabase.openDatabase(r0, r9, r10, r12, r16, r13, r14);
        setFilePermissionsFromMode(r15.getPath(), r11, 0);
        return r17;
    L5:
        r16 = 268435456;
        goto L6
    }
}
