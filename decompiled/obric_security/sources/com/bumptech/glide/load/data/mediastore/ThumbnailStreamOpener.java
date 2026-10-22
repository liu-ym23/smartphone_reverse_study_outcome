package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class ThumbnailStreamOpener {
    private static final FileService DEFAULT_SERVICE = null;
    private static final String TAG = "ThumbStreamOpener";
    private final ArrayPool byteArrayPool;
    private final ContentResolver contentResolver;
    private final List<ImageHeaderParser> parsers;
    private final ThumbnailQuery query;
    private final FileService service;

    static {
        DEFAULT_SERVICE = new FileService();
    }

    ThumbnailStreamOpener(List<ImageHeaderParser> r7, ThumbnailQuery r8, ArrayPool r9, ContentResolver r10) {
        this(r7, DEFAULT_SERVICE, r8, r9, r10);
    }

    ThumbnailStreamOpener(List<ImageHeaderParser> r1, FileService r2, ThumbnailQuery r3, ArrayPool r4, ContentResolver r5) {
        this.service = r2;
        this.query = r3;
        this.byteArrayPool = r4;
        this.contentResolver = r5;
        this.parsers = r1;
    }

    int getOrientation(Uri r5) {
        InputStream r2 = null;
        r2 = this.contentResolver.openInputStream(r5);     // Catch: Throwable -> L7 Throwable -> L9
        int r4 = ImageHeaderParserUtils.getOrientation(this.parsers, r2, this.byteArrayPool);     // Catch: Throwable -> L7 Throwable -> L9
        if (r2 != null) goto L26;
    L6:
        return r4;
    L26:
        r2.close();     // Catch: IOException -> L21
        goto L6
    L7:
        th = move-exception;
        if (r2 != null) goto L29;
    L20:
        throw th;
    L29:
        r2.close();     // Catch: IOException -> L22
    L9:
        e = move-exception;
        if (Log.isLoggable(TAG, 3) == false) goto L14;
        Log.d(TAG, "Failed to open uri: " + r5, e);     // Catch: Throwable -> L7
    L14:
        if (r2 == null) goto L32;
        r2.close();     // Catch: IOException -> L23
        return -1;
    L33:
        return -1;
    L32:
        return -1;
    }

    public InputStream open(Uri r5) throws FileNotFoundException {
        String r0 = getPath(r5);
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return null;
    L5:
        File r1 = this.service.get(r0);
        if (isValid(r1) == true) goto L8;
        return null;
    L8:
        Uri r2 = Uri.fromFile(r1);
        return this.contentResolver.openInputStream(r2);
    L11:
        e = move-exception;
        throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + r5 + " -> " + r2).initCause(e));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2 */
    private String getPath(Uri r6) {
        ?? r2 = 0;
        Cursor r5 = this.query.query(r6);     // Catch: Throwable -> L16 SecurityException -> L18
        if (r5 != null) goto L33;
    L13:
        if (r5 == null) goto L15;
        r5.close();
    L15:
        return null;
    L33:
    L11:
        e = e;
    L22:
        if (Log.isLoggable(TAG, 3) == false) goto L24;
        Log.d(TAG, "Failed to query for thumbnail for Uri: " + r6, e);     // Catch: Throwable -> L27
    L24:
        if (r5 == null) goto L26;
        r5.close();
    L26:
        return null;
    L6:
        if (r5.moveToFirst() == false) goto L13;
        String r7 = r5.getString(0);     // Catch: SecurityException -> L11 Throwable -> L27
        if (r5 == null) goto L10;
        r5.close();
    L10:
        return r7;
    L27:
        th = th;
        r2 = this;
    L29:
        if (r2 == 0) goto L31;
        r2.close();
    L31:
        throw th;
    L18:
        e = e;
        r5 = null;
    L16:
        th = th;
        goto L29
    }

    private boolean isValid(File r3) {
        if (this.service.exists(r3) == true) goto L5;
    L7:
        return false;
    L5:
        if (0 >= this.service.length(r3)) goto L7;
        return true;
    }
}
