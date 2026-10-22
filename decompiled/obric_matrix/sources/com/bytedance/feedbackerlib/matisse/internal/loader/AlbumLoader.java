package com.bytedance.feedbackerlib.matisse.internal.loader;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MergeCursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import androidx.loader.content.CursorLoader;
import com.bytedance.feedbackerlib.k.b;
import com.bytedance.feedbackerlib.matisse.internal.entity.Album;
import com.bytedance.feedbackerlib.matisse.internal.entity.c;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class AlbumLoader extends CursorLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Uri f4358a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f4359b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f4360c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String[] f4361d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String[] f4362e = null;

    static {
        f4358a = MediaStore.Files.getContentUri("external");
        f4359b = new String[]{"_id", "bucket_id", "bucket_display_name", "mime_type", "uri", "count"};
        f4360c = new String[]{"_id", "bucket_id", "bucket_display_name", "mime_type", "COUNT(*) AS count"};
        f4361d = new String[]{"_id", "bucket_id", "bucket_display_name", "mime_type"};
        f4362e = new String[]{String.valueOf(1), String.valueOf(3)};
    }

    private AlbumLoader(Context r8, String r9, String[] r10) {
        Uri r2 = f4358a;
        if (a() == false) goto L5;
        String[] r0 = f4360c;
    L6:
        super(r8, r2, r0, r9, r10, "datetaken DESC");
        return;
    L5:
        r0 = f4361d;
        goto L6
    }

    private static boolean a() {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        return true;
    L5:
        return false;
    }

    private static String[] b(int r2) {
        return new String[]{String.valueOf(r2), "image/gif"};
    }

    private static String[] c(int r2) {
        return new String[]{String.valueOf(r2)};
    }

    private static Uri d(Cursor r3) {
        long r0 = r3.getLong(r3.getColumnIndex("_id"));
        String r4 = r3.getString(r3.getColumnIndex("mime_type"));
        if (b.g(r4) == false) goto L6;
        Uri r5 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    L10:
        return ContentUris.withAppendedId(r5, r0);
    L6:
        if (b.j(r4) == false) goto L8;
        r5 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        goto L10
    L8:
        r5 = MediaStore.Files.getContentUri("external");
        goto L10
    }

    public static CursorLoader e(Context r4) {
        int r1 = 1;
        if (c.b().d() == false) goto L10;
        if (a() == false) goto L7;
        String r0 = "media_type=? AND _size>0 AND mime_type=?) GROUP BY (bucket_id";
    L8:
        String[] r2 = b(1);
    L29:
        return new AlbumLoader(r4, r0, r2);
    L7:
        r0 = "media_type=? AND _size>0 AND mime_type=?";
        goto L8
    L10:
        if (c.b().e() == false) goto L17;
        if (a() == false) goto L14;
        r0 = "media_type=? AND _size>0) GROUP BY (bucket_id";
    L15:
        r2 = c(r1);
        goto L29
    L14:
        r0 = "media_type=? AND _size>0";
        goto L15
    L17:
        if (c.b().f() == false) goto L24;
        if (a() == false) goto L21;
        r0 = "media_type=? AND _size>0) GROUP BY (bucket_id";
    L22:
        r1 = 3;
        goto L15
    L21:
        r0 = "media_type=? AND _size>0";
        goto L22
    L24:
        if (a() == false) goto L26;
        r0 = "(media_type=? OR media_type=?) AND _size>0) GROUP BY (bucket_id";
    L27:
        r2 = f4362e;
        goto L29
    L26:
        r0 = "(media_type=? OR media_type=?) AND _size>0";
        goto L27
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.loader.content.CursorLoader, androidx.loader.content.AsyncTaskLoader
    public Cursor loadInBackground() {
        Cursor r0 = super.loadInBackground();
        String[] r2 = f4359b;
        MatrixCursor r1 = new MatrixCursor(r2);
        if (a() == false) goto L19;
        MatrixCursor r3 = new MatrixCursor(r2);
        int r4 = 0;
        if (r0 != null) goto L7;
    L12:
        Uri r5 = null;
    L13:
        String[] r6 = new String[6];
        String r7 = Album.f4328j;
        r6[0] = r7;
        r6[1] = r7;
        r6[2] = "All";
        r6[3] = null;
        if (r5 != null) goto L16;
        char r8 = 4;
        String r15 = null;
    L17:
        r6[r8] = r15;
        r6[5] = String.valueOf(r4);
        r1.addRow(r6);
        return new MergeCursor(new Cursor[]{r1, r3});
    L16:
        r15 = r5.toString();
        r8 = 4;
    L7:
        if (r0.moveToNext() == false) goto L10;
        long r17 = r0.getLong(r0.getColumnIndex("_id"));
        long r19 = r0.getLong(r0.getColumnIndex("bucket_id"));
        String r16 = r0.getString(r0.getColumnIndex("bucket_display_name"));
        String r9 = r0.getString(r0.getColumnIndex("mime_type"));
        Uri r21 = d(r0);
        int r10 = r0.getInt(r0.getColumnIndex("count"));
        r3.addRow(new String[]{Long.toString(r17), Long.toString(r19), r16, r9, r21.toString(), String.valueOf(r10)});
        r4 = r4 + r10;
        goto L7
    L10:
        if (r0.moveToFirst() == false) goto L12;
        r5 = d(r0);
        goto L13
    L19:
        HashMap r11 = new HashMap();
        if (r0 != null) goto L22;
    L28:
        MatrixCursor r12 = new MatrixCursor(f4359b);
        if (r0 != null) goto L31;
    L41:
        int r13 = 0;
        Uri r14 = null;
    L42:
        String[] r18 = new String[6];
        String r20 = Album.f4328j;
        r18[0] = r20;
        r18[1] = r20;
        r18[2] = "All";
        r18[3] = null;
        if (r14 != null) goto L45;
        String r110 = null;
    L46:
        r18[4] = r110;
        r18[5] = String.valueOf(r13);
        r1.addRow(r18);
        return new MergeCursor(new Cursor[]{r1, r12});
    L45:
        r110 = r14.toString();
        goto L46
    L31:
        if (r0.moveToFirst() == false) goto L41;
        Uri r22 = d(r0);
        HashSet r111 = new HashSet();
        r13 = 0;
    L33:
        long r112 = r0.getLong(r0.getColumnIndex("bucket_id"));
        if (r111.contains(Long.valueOf(r112)) == true) goto L38;
        long r113 = r0.getLong(r0.getColumnIndex("_id"));
        String r114 = r0.getString(r0.getColumnIndex("bucket_display_name"));
        String r115 = r0.getString(r0.getColumnIndex("mime_type"));
        Uri r23 = d(r0);
        long r24 = ((Long) r11.get(Long.valueOf(r112))).longValue();
        r12.addRow(new String[]{Long.toString(r113), Long.toString(r112), r114, r115, r23.toString(), String.valueOf(r24)});
        r111.add(Long.valueOf(r112));
        r13 = (int) (((long) r13) + r24);
    L38:
        if (r0.moveToNext() == true) goto L33;
        r14 = r22;
    L22:
        if (r0.moveToNext() == false) goto L28;
        long r25 = r0.getLong(r0.getColumnIndex("bucket_id"));
        Long r26 = (Long) r11.get(Long.valueOf(r25));
        if (r26 != null) goto L26;
        long r27 = 1L;
    L27:
        r11.put(Long.valueOf(r25), r27);
        goto L22
    L26:
        r27 = Long.valueOf(r26.longValue() + 1);
        goto L27
    }

    @Override // androidx.loader.content.CursorLoader, androidx.loader.content.AsyncTaskLoader
    public /* bridge */ /* synthetic */ Cursor loadInBackground() {
        return loadInBackground();
    }

    @Override // androidx.loader.content.Loader
    public void onContentChanged() {
    }
}
