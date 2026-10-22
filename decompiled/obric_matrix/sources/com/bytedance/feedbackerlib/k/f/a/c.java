package com.bytedance.feedbackerlib.k.f.a;

import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static String a(Context r8, Uri r9, String r10, String[] r11) {
        String[] r3 = {"_data"};
        Cursor r7 = null;
        Cursor r12 = r8.getContentResolver().query(r9, r3, r10, r11, null);     // Catch: Throwable -> L16
        if (r12 != null) goto L22;
    L13:
        if (r12 == null) goto L15;
        r12.close();
    L15:
        return null;
    L22:
    L11:
        th = th;
        r7 = r12;
    L17:
        if (r7 == null) goto L19;
        r7.close();
    L19:
        throw th;
    L6:
        if (r12.moveToFirst() == false) goto L13;
        String r13 = r12.getString(r12.getColumnIndexOrThrow("_data"));     // Catch: Throwable -> L11
        if (r12 == null) goto L10;
        r12.close();
    L10:
        return r13;
    L16:
        th = th;
        goto L17
    }

    @TargetApi(19)
    public static String b(Context r5, Uri r6) {
        Uri r1 = null;
        if (e.b() == false) goto L30;
        if (DocumentsContract.isDocumentUri(r5, r6) == false) goto L30;
        if (d(r6) == false) goto L13;
        String[] r7 = DocumentsContract.getDocumentId(r6).split(":");
        if ("primary".equalsIgnoreCase(r7[0]) == true) goto L11;
    L37:
        return null;
    L11:
        return Environment.getExternalStorageDirectory() + "/" + r7[1];
    L13:
        if (c(r6) == false) goto L17;
        return a(r5, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(r6)).longValue()), null, null);
    L17:
        if (e(r6) == false) goto L37;
        String[] r8 = DocumentsContract.getDocumentId(r6).split(":");
        String r0 = r8[0];
        if ("image".equals(r0) == false) goto L22;
        r1 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    L28:
        return a(r5, r1, "_id=?", new String[]{r8[1]});
    L22:
        if ("video".equals(r0) == false) goto L25;
        r1 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        goto L28
    L25:
        if ("audio".equals(r0) == false) goto L28;
        r1 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
    L30:
        if ("content".equalsIgnoreCase(r6.getScheme()) == false) goto L34;
        return a(r5, r6, null, null);
    L34:
        if ("file".equalsIgnoreCase(r6.getScheme()) == false) goto L37;
        return r6.getPath();
    }

    public static boolean c(Uri r1) {
        return "com.android.providers.downloads.documents".equals(r1.getAuthority());
    }

    public static boolean d(Uri r1) {
        return "com.android.externalstorage.documents".equals(r1.getAuthority());
    }

    public static boolean e(Uri r1) {
        return "com.android.providers.media.documents".equals(r1.getAuthority());
    }
}
