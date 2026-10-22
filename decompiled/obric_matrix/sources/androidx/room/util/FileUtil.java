package androidx.room.util;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.location.LocationRequestCompat;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FileUtil {
    private FileUtil() {
    }

    @SuppressLint({"LambdaLast"})
    public static void copy(@NonNull ReadableByteChannel r9, @NonNull FileChannel r10) {
    L12:
        th = move-exception;
        r9.close();
        r10.close();
        throw th;
    L3:
        if (Build.VERSION.SDK_INT <= 23) goto L5;
        r10.transferFrom(r9, 0, LocationRequestCompat.PASSIVE_INTERVAL);     // Catch: Throwable -> L12
    L9:
        r10.force(false);     // Catch: Throwable -> L12
        r9.close();
        r10.close();
        return;
    L5:
        InputStream r0 = Channels.newInputStream(r9);     // Catch: Throwable -> L12
        OutputStream r1 = Channels.newOutputStream(r10);     // Catch: Throwable -> L12
        byte[] r3 = new byte[4096];     // Catch: Throwable -> L12
    L6:
        int r4 = r0.read(r3);     // Catch: Throwable -> L12
        if (r4 <= 0) goto L9;
        r1.write(r3, 0, r4);     // Catch: Throwable -> L12
        goto L6
    }
}
