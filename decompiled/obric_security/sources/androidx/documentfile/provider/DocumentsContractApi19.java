package androidx.documentfile.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
class DocumentsContractApi19 {
    private static final int FLAG_VIRTUAL_DOCUMENT = 512;
    private static final String TAG = "DocumentFile";

    public static boolean isVirtual(Context r4, Uri r5) {
        if (DocumentsContract.isDocumentUri(r4, r5) == true) goto L6;
        return false;
    L6:
        if ((getFlags(r4, r5) & 512) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static String getName(Context r2, Uri r3) {
        return queryForString(r2, r3, "_display_name", null);
    }

    private static String getRawType(Context r2, Uri r3) {
        return queryForString(r2, r3, "mime_type", null);
    }

    public static String getType(Context r0, Uri r1) {
        String r2 = getRawType(r0, r1);
        if ("vnd.android.document/directory".equals(r2) == false) goto L6;
        return null;
    L6:
        return r2;
    }

    public static long getFlags(Context r3, Uri r4) {
        return queryForLong(r3, r4, "flags", 0);
    }

    public static boolean isDirectory(Context r1, Uri r2) {
        return "vnd.android.document/directory".equals(getRawType(r1, r2));
    }

    public static boolean isFile(Context r0, Uri r1) {
        String r2 = getRawType(r0, r1);
        if ("vnd.android.document/directory".equals(r2) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r2) == true) goto L11;
        return true;
    L11:
        return false;
    }

    public static long lastModified(Context r3, Uri r4) {
        return queryForLong(r3, r4, "last_modified", 0);
    }

    public static long length(Context r3, Uri r4) {
        return queryForLong(r3, r4, "_size", 0);
    }

    public static boolean canRead(Context r3, Uri r4) {
        if (r3.checkCallingOrSelfUriPermission(r4, 1) == 0) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(getRawType(r3, r4)) == false) goto L8;
        return false;
    L8:
        return true;
    }

    public static boolean canWrite(Context r4, Uri r5) {
        if (r4.checkCallingOrSelfUriPermission(r5, 2) == 0) goto L5;
        return false;
    L5:
        String r1 = getRawType(r4, r5);
        int r6 = queryForInt(r4, r5, "flags", 0);
        if (TextUtils.isEmpty(r1) == false) goto L9;
        return false;
    L9:
        if ((r6 & 4) == 0) goto L12;
        return true;
    L12:
        if ("vnd.android.document/directory".equals(r1) == false) goto L17;
        if ((r6 & 8) == 0) goto L17;
        return true;
    L17:
        if (TextUtils.isEmpty(r1) == false) goto L19;
    L21:
        return false;
    L19:
        if ((r6 & 2) == 0) goto L21;
        return true;
    }

    public static boolean exists(Context r8, Uri r9) {
        ContentResolver r1 = r8.getContentResolver();
        boolean r10 = false;
        Cursor r7 = null;
        r7 = r1.query(r9, new String[]{"document_id"}, null, null, null);     // Catch: Throwable -> L8 Exception -> L10
        if (r7.getCount() <= 0) goto L6;
        r10 = true;
    L6:
        closeQuietly(r7);
        return r10;
    L8:
        th = move-exception;
        closeQuietly(r7);
        throw th;
    L10:
        e = move-exception;
        Log.w(TAG, "Failed query: " + e);     // Catch: Throwable -> L8
        closeQuietly(r7);
        return false;
    }

    private static String queryForString(Context r8, Uri r9, String r10, String r11) {
        Cursor r7 = null;
        r7 = r8.getContentResolver().query(r9, new String[]{r10}, null, null, null);     // Catch: Throwable -> L12 Exception -> L14
        if (r7.moveToFirst() == true) goto L6;
    L10:
        closeQuietly(r7);
        return r11;
    L6:
        if (r7.isNull(0) == true) goto L10;
        String r12 = r7.getString(0);     // Catch: Throwable -> L12 Exception -> L14
        closeQuietly(r7);
        return r12;
    L14:
        e = move-exception;
        Log.w(TAG, "Failed query: " + e);     // Catch: Throwable -> L12
        closeQuietly(r7);
        return r11;
    L12:
        th = move-exception;
        closeQuietly(r7);
        throw th;
    }

    private static int queryForInt(Context r2, Uri r3, String r4, int r5) {
        return (int) queryForLong(r2, r3, r4, r5);
    }

    private static long queryForLong(Context r8, Uri r9, String r10, long r11) {
        Cursor r7 = null;
        r7 = r8.getContentResolver().query(r9, new String[]{r10}, null, null, null);     // Catch: Throwable -> L12 Exception -> L14
        if (r7.moveToFirst() == true) goto L6;
    L10:
        closeQuietly(r7);
        return r11;
    L6:
        if (r7.isNull(0) == true) goto L10;
        long r12 = r7.getLong(0);     // Catch: Throwable -> L12 Exception -> L14
        closeQuietly(r7);
        return r12;
    L14:
        e = move-exception;
        Log.w(TAG, "Failed query: " + e);     // Catch: Throwable -> L12
        closeQuietly(r7);
        return r11;
    L12:
        th = move-exception;
        closeQuietly(r7);
        throw th;
    }

    private static void closeQuietly(AutoCloseable r0) {
        if (r0 != null) goto L9;
        return;
    L9:
        r0.close();     // Catch: RuntimeException -> L5 Exception -> L8
        goto L12
    L11:
        return;
    L5:
        e = move-exception;
        throw e;
    }

    private DocumentsContractApi19() {
    }
}
