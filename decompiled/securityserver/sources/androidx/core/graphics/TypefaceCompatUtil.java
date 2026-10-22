package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TypefaceCompatUtil {
    private static final String CACHE_FILE_PREFIX = ".font";
    private static final String TAG = "TypefaceCompatUtil";

    private TypefaceCompatUtil() {
    }

    public static void closeQuietly(Closeable r0) {
        if (r0 == null) goto L8;
        r0.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    @Nullable
    @RequiresApi(19)
    public static ByteBuffer copyToDirectBuffer(Context r1, Resources r2, int r3) {
        File r4 = getTempFile(r1);
        if (r4 != null) goto L15;
        return null;
    L15:
    L12:
        th = move-exception;
        r4.delete();
        throw th;
    L6:
        if (copyToFile(r4, r2, r3) == true) goto L9;
        r4.delete();
        return null;
    L9:
        ByteBuffer r5 = mmap(r4);     // Catch: Throwable -> L12
        r4.delete();
        return r5;
    }

    public static boolean copyToFile(File r5, InputStream r6) {
        StrictMode.ThreadPolicy r0 = StrictMode.allowThreadDiskWrites();
        FileOutputStream r2 = null;
        FileOutputStream r3 = new FileOutputStream(r5, false);     // Catch: Throwable -> L16 IOException -> L18
        byte[] r7 = new byte[1024];     // Catch: Throwable -> L10 IOException -> L12
    L6:
        int r4 = r6.read(r7);     // Catch: Throwable -> L10 IOException -> L12
        if (r4 == (-1)) goto L14;
        r3.write(r7, 0, r4);     // Catch: Throwable -> L10 IOException -> L12
    L14:
        closeQuietly(r3);
        StrictMode.setThreadPolicy(r0);
        return true;
    L12:
        e = e;
        r2 = r3;
    L19:
        Log.e(TAG, "Error copying resource contents to temp file: " + e.getMessage());     // Catch: Throwable -> L16
        closeQuietly(r2);
        StrictMode.setThreadPolicy(r0);
        return false;
    L10:
        th = th;
        r2 = r3;
    L22:
        closeQuietly(r2);
        StrictMode.setThreadPolicy(r0);
        throw th;
    L18:
        e = e;
    L16:
        th = th;
        goto L22
    }

    @Nullable
    public static File getTempFile(Context r5) {
        File r6 = r5.getCacheDir();
        if (r6 != null) goto L5;
        return null;
    L5:
        String r1 = CACHE_FILE_PREFIX + Process.myPid() + "-" + Process.myTid() + "-";
        int r2 = 0;
    L7:
        if (r2 >= 100) goto L13;
        File r3 = new File(r6, r1 + r2);
        if (r3.createNewFile() == false) goto L12;
        return r3;
    L12:
        r2 = r2 + 1;
        goto L7
    L13:
        return null;
    }

    @Nullable
    @RequiresApi(19)
    private static ByteBuffer mmap(File r7) {
        FileInputStream r0 = new FileInputStream(r7);     // Catch: IOException -> L12
        FileChannel r1 = r0.getChannel();     // Catch: Throwable -> L6
        long r5 = r1.size();     // Catch: Throwable -> L6
        MappedByteBuffer r8 = r1.map(FileChannel.MapMode.READ_ONLY, 0, r5);     // Catch: Throwable -> L6
        r0.close();     // Catch: IOException -> L12
        return r8;
    L6:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L9
    L11:
        throw th;     // Catch: IOException -> L12
    L9:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L12
    L12:
        return null;
    }

    @Nullable
    @RequiresApi(19)
    public static ByteBuffer mmap(Context r7, CancellationSignal r8, Uri r9) {
        ParcelFileDescriptor r10 = r7.getContentResolver().openFileDescriptor(r9, "r", r8);     // Catch: IOException -> L26
        if (r10 != null) goto L29;
        if (r10 == null) goto L7;
        r10.close();     // Catch: IOException -> L26
    L7:
        return null;
    L29:
        FileInputStream r11 = new FileInputStream(r10.getFileDescriptor());     // Catch: Throwable -> L13
        FileChannel r1 = r11.getChannel();     // Catch: Throwable -> L15
        long r5 = r1.size();     // Catch: Throwable -> L15
        MappedByteBuffer r12 = r1.map(FileChannel.MapMode.READ_ONLY, 0, r5);     // Catch: Throwable -> L15
        r11.close();     // Catch: Throwable -> L13
        r10.close();     // Catch: IOException -> L26
        return r12;
    L15:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L18
    L20:
        throw th;     // Catch: Throwable -> L13
    L18:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        r10.close();     // Catch: Throwable -> L23
    L25:
        throw th;     // Catch: IOException -> L26
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L26
    L26:
        return null;
    }

    public static boolean copyToFile(File r0, Resources r1, int r2) {
        InputStream r3 = r1.openRawResource(r2);     // Catch: Throwable -> L8
        boolean r4 = copyToFile(r0, r3);     // Catch: Throwable -> L6
        closeQuietly(r3);
        return r4;
    L6:
        th = th;
    L10:
        closeQuietly(r3);
        throw th;
    L8:
        th = th;
        r3 = null;
        goto L10
    }
}
