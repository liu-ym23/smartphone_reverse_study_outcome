package com.bytedance.apm.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.monitor.util.IoUtil;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class FileUtils {
    static final int BUFFER = 8192;
    public static final String TAG = "FileUtils";

    static {
    }

    public FileUtils() {
    }

    public static String getFormatSize(double r9) {
        double r2 = r9 / 1024.0d;
        if (r2 < 1.0d) goto L5;
        double r10 = r2 / 1024.0d;
        if (r10 < 1.0d) goto L9;
        double r3 = r10 / 1024.0d;
        if (r3 < 1.0d) goto L13;
        double r11 = r3 / 1024.0d;
        if (r11 >= 1.0d) goto L19;
        return new BigDecimal(Double.toString(r3)).setScale(2, 4).toPlainString() + "GB";
    L19:
        return new BigDecimal(r11).setScale(2, 4).toPlainString() + "TB";
    L13:
        return new BigDecimal(Double.toString(r10)).setScale(2, 4).toPlainString() + "MB";
    L9:
        return new BigDecimal(Double.toString(r2)).setScale(2, 4).toPlainString() + "KB";
    L5:
        return r9 + "Byte(s)";
    }

    public static void removeDir(String r4) {
        File r0 = new File(r4);
        if (r0.exists() == true) goto L5;
        return;
    L5:
        if (r0.isDirectory() == false) goto L19;
        File[] r5 = r0.listFiles();
        int r1 = r5.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L13;
        if (r5[r2].isDirectory() == false) goto L11;
        removeDir(r5[r2].getAbsolutePath());
    L12:
        r2 = r2 + 1;
        goto L7
    L11:
        r5[r2].delete();
        goto L12
    L13:
        r0.delete();
        return;
    }

    public static boolean copyFile(String r3, String r4, String r5) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
    L26:
        return false;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L26;
        if (TextUtils.isEmpty(r5) == true) goto L26;
        FileInputStream r0 = null;
        FileInputStream r2 = new FileInputStream(r3);     // Catch: Throwable -> L18 Exception -> L20
        boolean r6 = saveInputStream(r2, r4, r5);     // Catch: Throwable -> L14 Exception -> L16
        IoUtil.safeClose(r2);
        return r6;
    L16:
        e = e;
        r0 = r2;
    L21:
        e.printStackTrace();     // Catch: Throwable -> L18
        IoUtil.safeClose(r0);
        return false;
    L14:
        th = th;
        r0 = r2;
    L24:
        IoUtil.safeClose(r0);
        throw th;
    L20:
        e = e;
    L18:
        th = th;
        goto L24
    }

    public static boolean saveInputStream(InputStream r4, String r5, String r6) {
        if (r4 != null) goto L5;
        return false;
    L5:
        FileOutputStream r1 = null;
        File r2 = new File(r5);     // Catch: Throwable -> L26 Exception -> L28
        if (r2.exists() == false) goto L9;
    L12:
        FileOutputStream r7 = new FileOutputStream(new File(r2, r6));     // Catch: Throwable -> L26 Exception -> L28
        byte[] r8 = new byte[1024];     // Catch: Throwable -> L22 Exception -> L24
    L15:
        int r3 = r4.read(r8);     // Catch: Throwable -> L22 Exception -> L24
        if (r3 == (-1)) goto L18;
        r7.write(r8, 0, r3);     // Catch: Throwable -> L22 Exception -> L24
        goto L15
    L18:
        r7.flush();     // Catch: Throwable -> L22 Exception -> L24
        r7.close();     // Catch: Throwable -> L22 Exception -> L24
        r4.close();     // Catch: Throwable -> L26 Exception -> L28
        IoUtil.safeClose(null);
        IoUtil.safeClose(r4);
        return true;
    L24:
        e = e;
        r1 = r7;
    L29:
        Log.d(TAG, "save inputstream error: " + e);     // Catch: Throwable -> L26
    L10:
        IoUtil.safeClose(r1);
        IoUtil.safeClose(r4);
        return false;
    L22:
        th = th;
        r1 = r7;
    L31:
        IoUtil.safeClose(r1);
        IoUtil.safeClose(r4);
        throw th;
    L9:
        if (r2.mkdirs() == true) goto L12;
    L28:
        e = e;
    L26:
        th = th;
        goto L31
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8 */
    public static void compress(String r7, String... r8) {
        ?? r0 = new File(r7);
        FileOutputStream r1 = new FileOutputStream(r0);     // Catch: Throwable -> L25 Exception -> L28
    L42:
        CheckedOutputStream r2 = new CheckedOutputStream(r1, new CRC32());     // Catch: Throwable -> L21 Exception -> L23
        ZipOutputStream r3 = new ZipOutputStream(r2);     // Catch: Throwable -> L17 Exception -> L19
        int r9 = r8.length;     // Catch: Exception -> L15 Throwable -> L33
        int r4 = 0;
    L7:
        if (r4 >= r9) goto L13;
        String r5 = r8[r4];     // Catch: Exception -> L15 Throwable -> L33
        File r6 = new File(r5);     // Catch: Exception -> L15 Throwable -> L33
        if (r6.exists() == false) goto L12;
        compress(r6, r3, "");     // Catch: Exception -> L15 Throwable -> L33
        r4 = r4 + 1;     // Catch: Exception -> L15 Throwable -> L33
        goto L7
    L12:
        throw new RuntimeException(r5 + "not exist！");     // Catch: Exception -> L15 Throwable -> L33
    L13:
        IoUtil.safeClose(r3);
        IoUtil.safeClose(r2);
        IoUtil.safeClose(r1);
        return;
    L15:
        Exception e = e;
    L32:
        throw new RuntimeException(e);     // Catch: Throwable -> L33
    L19:
        e = e;
    L30:
        e = e;
    L17:
        th = th;
        Closeable r10 = null;
        r0 = r2;
    L27:
        th = th;
    L34:
        IoUtil.safeClose(r10);
        IoUtil.safeClose(r0);
        IoUtil.safeClose(r1);
        throw th;
    L23:
        e = e;
    L21:
        th = th;
        r0 = 0;
        r10 = null;
    L33:
        th = th;
    L28:
        e = e;
    L25:
        th = th;
        r0 = 0;
        r1 = null;
        r10 = null;
        goto L27
    }

    private static void compress(File r3, ZipOutputStream r4, String r5) {
        if (r3.isDirectory() == false) goto L5;
        compressDirectory(r3, r4, r5 + r3.getName() + File.separator);
        return;
    L5:
        System.out.println("compress：" + r5 + r3.getName());
        compressFile(r3, r4, r5);
    }

    private static void compressDirectory(File r2, ZipOutputStream r3, String r4) {
        if (r2.exists() == true) goto L5;
        return;
    L5:
        File[] r5 = r2.listFiles();
        int r0 = 0;
    L7:
        if (r0 >= r5.length) goto L9;
        compress(r5[r0], r3, r4);
        r0 = r0 + 1;
        goto L7
    }

    private static void compressFile(File r5, ZipOutputStream r6, String r7) {
        if (r5.exists() == true) goto L5;
        return;
    L5:
        InputStream r0 = null;
        InputStream r1 = new FileInputStream(r5);     // Catch: Throwable -> L24 Exception -> L26
    L39:
        BufferedInputStream r2 = new BufferedInputStream(r1);     // Catch: Throwable -> L19 Exception -> L21
    L41:
        r6.putNextEntry(new ZipEntry(r7 + r5.getName()));     // Catch: Throwable -> L15 Exception -> L17
        byte[] r8 = new byte[8192];     // Catch: Throwable -> L15 Exception -> L17
    L9:
        int r3 = r2.read(r8, 0, 8192);     // Catch: Throwable -> L15 Exception -> L17
        if (r3 == (-1)) goto L13;
        r6.write(r8, 0, r3);     // Catch: Throwable -> L15 Exception -> L17
    L13:
        IoUtil.safeClose(r2);
        IoUtil.safeClose(r1);
        return;
    L17:
        e = e;
    L23:
        r0 = r1;
    L35:
    L30:
        th = th;
        r1 = r0;
    L32:
        r0 = r2;
    L33:
        IoUtil.safeClose(r0);
        IoUtil.safeClose(r1);
        throw th;
    L29:
        throw new RuntimeException(e);     // Catch: Throwable -> L30
    L15:
        th = th;
    L21:
        e = e;
        r2 = null;
    L19:
        th = th;
    L26:
        e = e;
        r2 = null;
    L24:
        th = th;
        r1 = null;
        goto L33
    }

    public static String getFileNameWithoutSuffix(File r2) {
        String[] r3 = r2.getName().split("\\.");
        if (r3.length > 1) goto L7;
        return "";
    L7:
        return r3[r3.length - 2];
    }

    public static long getSize(File r6) {
        long r1 = -1;
        if (r6.exists() == true) goto L6;
        return -1;
    L6:
        if (r6.isFile() == false) goto L10;
        return r6.length();
    L10:
        if (r6.isDirectory() == false) goto L14;
        File[] r7 = r6.listFiles();
        int r0 = r7.length;
        r1 = 0;
        int r3 = 0;
    L12:
        if (r3 >= r0) goto L14;
        r1 = r1 + getSize(r7[r3]);
        r3 = r3 + 1;
    L14:
        return r1;
    }

    public static File getExternalRootDir(Context r2) {
        File r0 = null;
        if (r2 != null) goto L10;
        return null;
    L10:
        r0 = r2.getExternalFilesDir(null);     // Catch: Throwable -> L9
    L6:
        r0 = r0.getParentFile();     // Catch: Throwable -> L9
        if (r0.getAbsolutePath().contains("/Android") == true) goto L6;
    L8:
        return r0;
    }
}
