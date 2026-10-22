package com.facebook.soloader;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes2.dex */
public final class SysUtil {

    @d
    @TargetApi(21)
    private static final class LollipopSysdeps {
        private LollipopSysdeps() {
        }

        @d
        public static void fallocateIfSupported(FileDescriptor r2, long r3) {
            Os.posix_fallocate(r2, 0, r3);     // Catch: ErrnoException -> L5
            return;
        L5:
            e = move-exception;
            if (e.errno == OsConstants.EOPNOTSUPP) goto L15;
            int r4 = e.errno;
            if (r4 != OsConstants.ENOSYS) goto L11;
            return;
        L11:
            if (r4 != OsConstants.EINVAL) goto L14;
            return;
        L14:
            throw new IOException(e.toString(), e);
        }

        @d
        public static String[] getSupportedAbis() {
            return Build.SUPPORTED_ABIS;
        }
    }

    static int a(RandomAccessFile r4, InputStream r5, int r6, byte[] r7) {
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L7;
        int r2 = r5.read(r7, 0, Math.min(r7.length, r6 - r1));
        if (r2 == (-1)) goto L7;
        r4.write(r7, 0, r2);
        r1 = r1 + r2;
    L7:
        return r1;
    }

    public static void b(File r4) {
        if (r4.isDirectory() == false) goto L11;
        File[] r0 = r4.listFiles();
        if (r0 != null) goto L7;
        return;
    L7:
        int r1 = r0.length;
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L11;
        b(r0[r2]);
        r2 = r2 + 1;
    L11:
        if (r4.delete() == false) goto L13;
        return;
    L13:
        if (r4.exists() == true) goto L16;
        return;
    L16:
        throw new IOException("could not delete: " + r4);
    }

    public static void c(FileDescriptor r2, long r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        LollipopSysdeps.fallocateIfSupported(r2, r3);
        return;
    }

    public static int d(String[] r2, String r3) {
        int r0 = 0;
    L4:
        if (r0 >= r2.length) goto L11;
        if (r2[r0] == null) goto L10;
        if (r3.equals(r2[r0]) == false) goto L10;
        return r0;
    L10:
        r0 = r0 + 1;
        goto L4
    L11:
        return -1;
    }

    static void e(File r3) {
        if (r3.isDirectory() == false) goto L13;
        File[] r0 = r3.listFiles();
        if (r0 == null) goto L11;
        int r4 = 0;
    L8:
        if (r4 >= r0.length) goto L35;
        e(r0[r4]);
        r4 = r4 + 1;
        goto L8
    L35:
        return;
    L11:
        throw new IOException("cannot list directory " + r3);
    L13:
        if (r3.getPath().endsWith("_lock") == true) goto L34;
        RandomAccessFile r1 = new RandomAccessFile(r3, "r");
        r1.getFD().sync();     // Catch: Throwable -> L19
        r1.close();
        return;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L24
    L26:
        throw th;
    L24:
        th = move-exception;
        th.addSuppressed(th);
        goto L26
    }

    public static int f(Context r2) {
        PackageManager r0 = r2.getPackageManager();
        if (r0 != null) goto L8;
    L6:
        return 0;
    L8:
        return r0.getPackageInfo(r2.getPackageName(), 0).versionCode;
    }

    public static String[] g() {
        if (Build.VERSION.SDK_INT >= 21) goto L7;
        return new String[]{Build.CPU_ABI, Build.CPU_ABI2};
    L7:
        return LollipopSysdeps.getSupportedAbis();
    }

    static void h(File r3) {
        if (r3.mkdirs() == false) goto L5;
        return;
    L5:
        if (r3.isDirectory() == false) goto L8;
        return;
    L8:
        throw new IOException("cannot mkdir: " + r3);
    }
}
