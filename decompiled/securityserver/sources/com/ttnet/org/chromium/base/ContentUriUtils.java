package com.ttnet.org.chromium.base;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.annotation.Nullable;
import com.bytedance.librarian.LibrarianImpl;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ContentUriUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "ContentUriUtils";
    private static FileProviderUtil sFileProviderUtil;
    private static final Object sLock = null;

    public interface FileProviderUtil {
        Uri getContentUriFromFile(File r1);
    }

    static {
        sLock = new Object();
    }

    private ContentUriUtils() {
    }

    @CalledByNative
    public static boolean contentUriExists(String r1) {
        AssetFileDescriptor r2 = getAssetFileDescriptor(r1);
        if (r2 == null) goto L5;
        boolean r0 = true;
    L6:
        if (r2 != null) goto L10;
    L8:
        return r0;
    L10:
        r2.close();     // Catch: IOException -> L9
        goto L8
    L5:
        r0 = false;
        goto L6
    }

    @CalledByNative
    public static boolean delete(String r2) {
        Uri r3 = Uri.parse(r2);
        if (ContextUtils.getApplicationContext().getContentResolver().delete(r3, null, null) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static AssetFileDescriptor getAssetFileDescriptor(String r10) {
        ContentResolver r0 = ContextUtils.getApplicationContext().getContentResolver();
        Uri r1 = Uri.parse(r10);
    L17:
        e = move-exception;
        Log.w(TAG, "Cannot open content uri: %s", new Object[]{r10, e});
    L27:
        return null;
    L4:
        if (isVirtualDocument(r1) == false) goto L22;
        String[] r3 = r0.getStreamTypes(r1, "*/*");     // Catch: Exception -> L17
        if (r3 == null) goto L27;
        if (r3.length <= 0) goto L27;
        AssetFileDescriptor r2 = r0.openTypedAssetFileDescriptor(r1, r3[0], null);     // Catch: Exception -> L17
        if (r2 != null) goto L13;
    L21:
        return r2;
    L13:
        if (r2.getStartOffset() == 0) goto L21;
        r2.close();     // Catch: Exception -> L17 IOException -> L28
    L20:
        throw new SecurityException("Cannot open files with non-zero offset type.");     // Catch: Exception -> L17
    L22:
        ParcelFileDescriptor r5 = r0.openFileDescriptor(r1, "r");     // Catch: Exception -> L17
        if (r5 == null) goto L27;
        return new AssetFileDescriptor(r5, 0, -1);
    }

    public static Uri getContentUriFromFile(File r2) {
        Object r0 = sLock;
        monitor-enter(r0);
        FileProviderUtil r1 = sFileProviderUtil;     // Catch: Throwable -> L9
        if (r1 == null) goto L11;
        Uri r3 = r1.getContentUriFromFile(r2);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L9:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    public static String getContentUriFromFilePath(String r2) {
        Uri r0 = getContentUriFromFile(new File(r2));     // Catch: IllegalArgumentException -> L6
        if (r0 == null) goto L12;
        return r0.toString();
    L12:
        return null;
    L6:
        e = move-exception;
        Log.e(TAG, "Cannot retrieve content uri from file: %s", new Object[]{r2, e});
        return null;
    }

    public static String getDisplayName(Uri r7, Context r8, String r9) {
        if (r7 != null) goto L5;
        return "";
    L5:
        ContentResolver r10 = r8.getContentResolver();
        Cursor r1 = r10.query(r7, null, null, null, null);     // Catch: NullPointerException -> L37
        if (r1 != null) goto L38;
    L34:
        if (r1 == null) goto L36;
        r1.close();     // Catch: NullPointerException -> L37
        goto L36
    L38:
    L25:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L31
    L33:
        throw th;     // Catch: NullPointerException -> L37
    L31:
        th = move-exception;
        th.addSuppressed(th);     // Catch: NullPointerException -> L37
        goto L33
    L9:
        if (r1.getCount() < 1) goto L34;
        r1.moveToFirst();     // Catch: Throwable -> L25
        int r11 = r1.getColumnIndex(r9);     // Catch: Throwable -> L25
        if (r11 != (-1)) goto L15;
        r1.close();     // Catch: NullPointerException -> L37
        return "";
    L15:
        String r12 = r1.getString(r11);     // Catch: Throwable -> L25
        if (hasVirtualFlag(r1) == false) goto L27;
        String[] r13 = r10.getStreamTypes(r7, "*/*");     // Catch: Throwable -> L25
        if (r13 == null) goto L27;
        if (r13.length <= 0) goto L27;
        String r14 = MimeTypeMap.getSingleton().getExtensionFromMimeType(r13[0]);     // Catch: Throwable -> L25
        if (r14 == null) goto L27;
        r12 = r12 + LibrarianImpl.Constants.DOT + r14;     // Catch: Throwable -> L25
    L27:
        r1.close();     // Catch: NullPointerException -> L37
        return r12;
    L36:
        return "";
    }

    @CalledByNative
    public static String getMimeType(String r2) {
        ContentResolver r0 = ContextUtils.getApplicationContext().getContentResolver();
        Uri r3 = Uri.parse(r2);
        if (isVirtualDocument(r3) == false) goto L12;
        String[] r4 = r0.getStreamTypes(r3, "*/*");
        if (r4 != null) goto L7;
    L9:
        return null;
    L7:
        if (r4.length <= 0) goto L9;
        return r4[0];
    L12:
        return r0.getType(r3);
    }

    private static boolean hasVirtualFlag(Cursor r4) {
        int r0 = r4.getColumnIndex("flags");
        if (r0 > (-1)) goto L5;
    L7:
        return false;
    L5:
        if ((r4.getLong(r0) & 512) == 0) goto L7;
        return true;
    }

    public static boolean isContentUri(String r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        Uri r3 = Uri.parse(r2);
        if (r3 != null) goto L8;
        return false;
    L8:
        if ("content".equals(r3.getScheme()) == false) goto L12;
        return true;
    L12:
        return false;
    }

    private static boolean isVirtualDocument(Uri r8) {
        if (r8 != null) goto L6;
        return false;
    L6:
        if (DocumentsContract.isDocumentUri(ContextUtils.getApplicationContext(), r8) == true) goto L30;
        return false;
    L30:
        Cursor r9 = ContextUtils.getApplicationContext().getContentResolver().query(r8, null, null, null, null);     // Catch: NullPointerException -> L25
        if (r9 != null) goto L26;
    L22:
        if (r9 == null) goto L24;
        r9.close();     // Catch: NullPointerException -> L25
        goto L24
    L26:
    L16:
        th = move-exception;
        r9.close();     // Catch: Throwable -> L19
    L21:
        throw th;     // Catch: NullPointerException -> L25
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: NullPointerException -> L25
        goto L21
    L12:
        if (r9.getCount() < 1) goto L22;
        r9.moveToFirst();     // Catch: Throwable -> L16
        boolean r1 = hasVirtualFlag(r9);     // Catch: Throwable -> L16
        r9.close();     // Catch: NullPointerException -> L25
        return r1;
    L24:
        return false;
    }

    @Nullable
    @CalledByNative
    public static String maybeGetDisplayName(String r4) {
        Uri r0 = Uri.parse(r4);
        String r1 = getDisplayName(r0, ContextUtils.getApplicationContext(), "_display_name");     // Catch: Exception -> L8
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return null;
    L7:
        return r1;
    L8:
        e = move-exception;
        Log.w(TAG, "Cannot open content uri: %s", new Object[]{r4, e});
        return null;
    }

    @CalledByNative
    public static int openContentUriForRead(String r0) {
        AssetFileDescriptor r1 = getAssetFileDescriptor(r0);
        if (r1 != null) goto L5;
        return -1;
    L5:
        return r1.getParcelFileDescriptor().detachFd();
    }

    public static void setFileProviderUtil(FileProviderUtil r1) {
        Object r0 = sLock;
        monitor-enter(r0);
        sFileProviderUtil = r1;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
