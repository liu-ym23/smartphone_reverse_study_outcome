package com.ttnet.org.chromium.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
public class FileUtils {
    public static Function<String, Boolean> DELETE_ALL = null;
    private static final String TAG = "FileUtils";

    public interface Natives {
        String getAbsoluteFilePath(String r1);
    }

    static {
        DELETE_ALL = new b();
    }

    public FileUtils() {
    }

    public static /* synthetic */ Boolean a(String r0) {
        return lambda$static$0(r0);
    }

    public static void batchDeleteFiles(List<String> r2, Function<String, Boolean> r3) {
        Iterator<String> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L16;
        String r0 = r4.next();
        if (r3 == null) goto L11;
        if (r3.apply(r0).booleanValue() == false) goto L4;
    L11:
        if (ContentUriUtils.isContentUri(r0) == true) goto L12;
        File r1 = new File(r0);
        if (r1.exists() == false) goto L4;
        recursivelyDeleteFile(r1, r3);
        goto L4
    L12:
        ContentUriUtils.delete(r0);
        goto L4
    }

    public static void copyStream(InputStream r3, OutputStream r4) {
        byte[] r0 = new byte[8192];
    L3:
        int r1 = r3.read(r0);
        if (r1 == (-1)) goto L6;
        r4.write(r0, 0, r1);
        goto L3
    }

    public static void copyStreamToFile(InputStream r5, File r6) {
        File r0 = new File(r6.getPath() + ".tmp");
        FileOutputStream r1 = new FileOutputStream(r0);
        Log.i(TAG, "Writing to %s", new Object[]{r6});     // Catch: Throwable -> L9
        copyStream(r5, r1);     // Catch: Throwable -> L9
        r1.close();
        if (r0.renameTo(r6) == false) goto L8;
        return;
    L8:
        throw new IOException();
    L9:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L12
    L14:
        throw th;
    L12:
        th = move-exception;
        th.addSuppressed(th);
        goto L14
    }

    public static String getAbsoluteFilePath(String r1) {
        return FileUtilsJni.get().getAbsoluteFilePath(r1);
    }

    public static String getExtension(String r2) {
        int r0 = r2.lastIndexOf(47);
        int r1 = r2.lastIndexOf(46);
        if (r0 < r1) goto L7;
        return "";
    L7:
        return r2.substring(r1 + 1).toLowerCase(Locale.US);
    }

    public static long getFileSizeBytes(File r6) {
        long r0 = 0;
        if (r6 != null) goto L6;
        return 0;
    L6:
        if (r6.isDirectory() == false) goto L15;
        File[] r7 = r6.listFiles();
        if (r7 != null) goto L10;
        return 0;
    L10:
        int r2 = r7.length;
        int r3 = 0;
    L11:
        if (r3 >= r2) goto L13;
        r0 = r0 + getFileSizeBytes(r7[r3]);
        r3 = r3 + 1;
        goto L11
    L13:
        return r0;
    L15:
        return r6.length();
    }

    public static Uri getUriForFile(File r3) {
        Uri r0 = ContentUriUtils.getContentUriFromFile(r3);     // Catch: IllegalArgumentException -> L4
    L6:
        if (r0 == null) goto L8;
        return r0;
    L8:
        return Uri.fromFile(r3);
    L4:
        e = move-exception;
        Log.e(TAG, "Could not create content uri: " + e, new Object[0]);
        r0 = null;
        goto L6
    }

    private static /* synthetic */ Boolean lambda$static$0(String r0) {
        return Boolean.TRUE;
    }

    @Nullable
    public static Bitmap queryBitmapFromContentProvider(Context r7, Uri r8) {
        ParcelFileDescriptor r9 = r7.getContentResolver().openFileDescriptor(r8, "r");     // Catch: IOException -> L29
        if (r9 != null) goto L11;
        Log.w(TAG, "Null ParcelFileDescriptor from uri " + r8, new Object[0]);     // Catch: Throwable -> L9
        if (r9 == null) goto L8;
        r9.close();     // Catch: IOException -> L29
    L8:
        return null;
    L11:
        FileDescriptor r3 = r9.getFileDescriptor();     // Catch: Throwable -> L9
        if (r3 != null) goto L16;
        Log.w(TAG, "Null FileDescriptor from uri " + r8, new Object[0]);     // Catch: Throwable -> L9
        r9.close();     // Catch: IOException -> L29
        return null;
    L16:
        Bitmap r2 = BitmapFactory.decodeFileDescriptor(r3);     // Catch: Throwable -> L9
        if (r2 != null) goto L21;
        Log.w(TAG, "Failed to decode image from uri " + r8, new Object[0]);     // Catch: Throwable -> L9
        r9.close();     // Catch: IOException -> L29
        return null;
    L21:
        r9.close();     // Catch: IOException -> L29
        return r2;
    L9:
        th = move-exception;
        if (r9 != null) goto L33;
    L28:
        throw th;     // Catch: IOException -> L29
    L33:
        r9.close();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L29
    L29:
        Log.w(TAG, "IO exception when reading uri " + r8, new Object[0]);
        return null;
    }

    @NonNull
    public static byte[] readStream(InputStream r1) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        copyStream(r1, r0);
        return r0.toByteArray();
    }

    public static boolean recursivelyDeleteFile(File r4, Function<String, Boolean> r5) {
        if (r4.exists() == true) goto L6;
        r4.delete();
        return true;
    L6:
        if (r5 == null) goto L11;
        if (r5.apply(r4.getPath()).booleanValue() == true) goto L11;
        return true;
    L11:
        if (r4.isDirectory() == false) goto L17;
        File[] r0 = r4.listFiles();
        if (r0 == null) goto L17;
        int r1 = r0.length;
        int r2 = 0;
    L15:
        if (r2 >= r1) goto L17;
        recursivelyDeleteFile(r0[r2], r5);
        r2 = r2 + 1;
    L17:
        boolean r6 = r4.delete();
        if (r6 == true) goto L20;
        Log.e(TAG, "Failed to delete: %s", new Object[]{r4});
    L20:
        return r6;
    }
}
