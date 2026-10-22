package androidx.documentfile.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(19)
class DocumentsContractApi19 {
    private static final int FLAG_VIRTUAL_DOCUMENT = 512;
    private static final String TAG = "DocumentFile";

    private DocumentsContractApi19() {
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

    private static void closeQuietly(@Nullable AutoCloseable r0) {
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

    public static boolean exists(Context r7, Uri r8) {
        ContentResolver r0 = r7.getContentResolver();
        boolean r9 = false;
        Cursor r6 = null;
        r6 = r0.query(r8, new String[]{"document_id"}, null, null, null);     // Catch: Throwable -> L8 Exception -> L10
        if (r6.getCount() <= 0) goto L6;
        r9 = true;
    L6:
        closeQuietly(r6);
        return r9;
    L10:
        e = move-exception;
        Log.w(TAG, "Failed query: " + e);     // Catch: Throwable -> L8
        closeQuietly(r6);
        return false;
    L8:
        th = move-exception;
        closeQuietly(r6);
        throw th;
    }

    public static long getFlags(Context r3, Uri r4) {
        return queryForLong(r3, r4, "flags", 0);
    }

    @Nullable
    public static String getName(Context r2, Uri r3) {
        return queryForString(r2, r3, "_display_name", null);
    }

    @Nullable
    private static String getRawType(Context r2, Uri r3) {
        return queryForString(r2, r3, "mime_type", null);
    }

    @Nullable
    public static String getType(Context r0, Uri r1) {
        String r2 = getRawType(r0, r1);
        if ("vnd.android.document/directory".equals(r2) == false) goto L6;
        return null;
    L6:
        return r2;
    }

    public static boolean isDirectory(Context r0, Uri r1) {
        return "vnd.android.document/directory".equals(getRawType(r0, r1));
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

    public static boolean isVirtual(Context r4, Uri r5) {
        if (DocumentsContract.isDocumentUri(r4, r5) == true) goto L6;
        return false;
    L6:
        if ((getFlags(r4, r5) & 512) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static long lastModified(Context r3, Uri r4) {
        return queryForLong(r3, r4, "last_modified", 0);
    }

    public static long length(Context r3, Uri r4) {
        return queryForLong(r3, r4, "_size", 0);
    }

    private static int queryForInt(Context r2, Uri r3, String r4, int r5) {
        return (int) queryForLong(r2, r3, r4, r5);
    }

    private static long queryForLong(Context r7, Uri r8, String r9, long r10) {
        Cursor r6 = null;
        r6 = r7.getContentResolver().query(r8, new String[]{r9}, null, null, null);     // Catch: Throwable -> L12 Exception -> L14
        if (r6.moveToFirst() == true) goto L6;
    L10:
        closeQuietly(r6);
        return r10;
    L6:
        if (r6.isNull(0) == true) goto L10;
        long r11 = r6.getLong(0);     // Catch: Throwable -> L12 Exception -> L14
        closeQuietly(r6);
        return r11;
    L14:
        e = move-exception;
        Log.w(TAG, "Failed query: " + e);     // Catch: Throwable -> L12
        closeQuietly(r6);
        return r10;
    L12:
        th = move-exception;
        closeQuietly(r6);
        throw th;
    }

    @Nullable
    private static String queryForString(Context r7, Uri r8, String r9, @Nullable String r10) {
        Cursor r6 = null;
        r6 = r7.getContentResolver().query(r8, new String[]{r9}, null, null, null);     // Catch: Throwable -> L12 Exception -> L14
        if (r6.moveToFirst() == true) goto L6;
    L10:
        closeQuietly(r6);
        return r10;
    L6:
        if (r6.isNull(0) == true) goto L10;
        String r11 = r6.getString(0);     // Catch: Throwable -> L12 Exception -> L14
        closeQuietly(r6);
        return r11;
    L14:
        e = move-exception;
        Log.w(TAG, "Failed query: " + e);     // Catch: Throwable -> L12
        closeQuietly(r6);
        return r10;
    L12:
        th = move-exception;
        closeQuietly(r6);
        throw th;
    }
}
