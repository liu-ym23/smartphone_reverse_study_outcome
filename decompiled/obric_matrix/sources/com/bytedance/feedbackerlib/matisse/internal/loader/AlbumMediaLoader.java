package com.bytedance.feedbackerlib.matisse.internal.loader;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MergeCursor;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.loader.content.CursorLoader;
import com.bytedance.feedbackerlib.k.f.a.b;
import com.bytedance.feedbackerlib.matisse.internal.entity.Album;
import com.bytedance.feedbackerlib.matisse.internal.entity.c;

/* JADX INFO: loaded from: classes.dex */
public class AlbumMediaLoader extends CursorLoader {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Uri f4363b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f4364c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String[] f4365d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f4366a;

    static {
        f4363b = MediaStore.Files.getContentUri("external");
        f4364c = new String[]{"_id", "_display_name", "mime_type", "_size", TypedValues.TransitionType.S_DURATION};
        f4365d = new String[]{String.valueOf(1), String.valueOf(3)};
    }

    private AlbumMediaLoader(Context r8, String r9, String[] r10, boolean r11) {
        super(r8, f4363b, f4364c, r9, r10, "datetaken DESC");
        this.f4366a = r11;
    }

    private static String[] a(String r5) {
        return new String[]{String.valueOf(1), String.valueOf(3), r5};
    }

    private static String[] b(int r2, String r3) {
        return new String[]{String.valueOf(r2), r3, "image/gif"};
    }

    private static String[] c(int r2, String r3) {
        return new String[]{String.valueOf(r2), r3};
    }

    private static String[] d(int r2) {
        return new String[]{String.valueOf(r2), "image/gif"};
    }

    private static String[] e(int r2) {
        return new String[]{String.valueOf(r2)};
    }

    public static CursorLoader f(Context r3, Album r4, boolean r5) {
        if (r4.h() == false) goto L14;
        String r0 = "media_type=? AND _size>0";
        if (c.b().d() == false) goto L8;
        String[] r6 = d(1);
        r0 = "media_type=? AND mime_type=? AND _size>0";
    L27:
        return new AlbumMediaLoader(r3, r0, r6, r5);
    L8:
        if (c.b().e() == false) goto L11;
        r6 = e(1);
        goto L27
    L11:
        if (c.b().f() == false) goto L13;
        r6 = e(3);
        goto L27
    L13:
        r6 = f4365d;
        r0 = "(media_type=? OR media_type=?) AND _size>0";
        goto L27
    L14:
        r0 = "media_type=? AND  bucket_id=? AND _size>0";
        if (c.b().d() == false) goto L19;
        r6 = b(1, r4.g());
        String r7 = "media_type=? AND  bucket_id=? AND mime_type=? AND _size>0";
    L17:
        r0 = r7;
    L25:
        r5 = false;
        goto L27
    L19:
        if (c.b().e() == false) goto L21;
        r6 = c(1, r4.g());
        goto L25
    L21:
        boolean r8 = c.b().f();
        String r9 = r4.g();
        if (r8 == false) goto L24;
        r6 = c(3, r9);
        goto L25
    L24:
        r6 = a(r9);
        r7 = "(media_type=? OR media_type=?) AND  bucket_id=? AND _size>0";
        goto L17
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.loader.content.CursorLoader, androidx.loader.content.AsyncTaskLoader
    public Cursor loadInBackground() {
        Cursor r0 = super.loadInBackground();
        if (this.f4366a == true) goto L5;
    L9:
        return r0;
    L5:
        if (b.e(getContext()) == false) goto L9;
        MatrixCursor r7 = new MatrixCursor(f4364c);
        r7.addRow(new Object[]{-1L, "Capture", "", 0, 0});
        return new MergeCursor(new Cursor[]{r7, r0});
    }

    @Override // androidx.loader.content.CursorLoader, androidx.loader.content.AsyncTaskLoader
    public /* bridge */ /* synthetic */ Cursor loadInBackground() {
        return loadInBackground();
    }

    @Override // androidx.loader.content.Loader
    public void onContentChanged() {
    }
}
