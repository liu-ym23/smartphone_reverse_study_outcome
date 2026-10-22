package com.bytedance.common.utility.io;

import a.a;
import android.os.StatFs;
import android.text.TextUtils;
import com.bytedance.common.utility.reflect.JavaCalls;
import com.bytedance.librarian.LibrarianImpl;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes.dex */
public final class IOUtils {
    private IOUtils() {
    }

    public static boolean canWrite(File r3) {
        if (r3 != null) goto L4;
        return false;
    L4:
        if (r3.exists() == false) goto L13;
        File r1 = new File(r3, LibrarianImpl.Constants.DOT + System.currentTimeMillis());
        boolean r4 = r1.mkdir();
        if (r4 == true) goto L9;
        return r4;
    L9:
        return r1.delete();
    L13:
        return false;
    }

    public static void clearPath(String r6) {
        File r0 = new File(r6);
        if (r0.exists() == true) goto L5;
        return;
    L5:
        if (r0.isDirectory() == false) goto L24;
        String[] r1 = r0.list();
        int r2 = r1.length;
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L25;
        String r4 = r1[r3];
        String r5 = File.separator;
        if (r6.endsWith(r5) == false) goto L12;
        String r7 = a.j(r6, r4);
    L13:
        File r8 = new File(r7);
        if (r8.isFile() == false) goto L17;
        r8.delete();
    L17:
        if (r8.isDirectory() == false) goto L19;
        deletePath(r7);
    L19:
        r3 = r3 + 1;
        goto L8
    L12:
        r7 = a.B(r6, r5, r4);
        goto L13
    L25:
        return;
    }

    public static void close(Closeable r0) {
        if (r0 != null) goto L7;
        return;
    L7:
        r0.close();     // Catch: IOException -> L6
        return;
    }

    public static boolean copyFile(File r4, File r5) {
        if (r4.exists() == true) goto L5;
    L23:
        return false;
    L5:
        if (r4.isFile() == false) goto L23;
        if (r5.isDirectory() == false) goto L10;
        return false;
    L10:
        if (r5.exists() == false) goto L24;
        r5.delete();
    L24:
        byte[] r0 = new byte[2048];     // Catch: IOException -> L18
        BufferedInputStream r2 = new BufferedInputStream(new FileInputStream(r4));     // Catch: IOException -> L18
        BufferedOutputStream r6 = new BufferedOutputStream(new FileOutputStream(r5));     // Catch: IOException -> L18
    L14:
        int r7 = r2.read(r0);     // Catch: IOException -> L18
        if (r7 == (-1)) goto L16;
        r6.write(r0, 0, r7);     // Catch: IOException -> L18
        goto L14
    L16:
        r2.close();     // Catch: IOException -> L18
        r6.flush();     // Catch: IOException -> L18
        r6.close();     // Catch: IOException -> L18
        return true;
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L23
    }

    public static void deleteFile(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return;
    L5:
        File r0 = new File(r1);
        if (r0.exists() == true) goto L8;
        return;
    L8:
        if (r0.isFile() == false) goto L13;
        r0.delete();
        return;
    }

    public static void deletePath(String r7) {
        File r0 = new File(r7);
        if (r0.exists() == true) goto L6;
        return;
    L6:
        if (r0.isFile() == false) goto L9;
        r0.delete();
        return;
    L9:
        String[] r1 = r0.list();
        if (r1 != null) goto L12;
        return;
    L12:
        int r2 = r1.length;
        int r3 = 0;
    L13:
        if (r3 >= r2) goto L28;
        String r4 = r1[r3];
        if (r4 == null) goto L27;
        String r5 = File.separator;
        if (r7.endsWith(r5) == false) goto L20;
        String r6 = r7.concat(r4);
    L21:
        File r8 = new File(r6);
        if (r8.isFile() == false) goto L25;
        r8.delete();
    L25:
        if (r8.isDirectory() == false) goto L27;
        deletePath(r6);
        goto L27
    L20:
        r6 = a.B(r7, r5, r4);
    L27:
        r3 = r3 + 1;
        goto L13
    L28:
        r0.delete();
    }

    public static boolean exists(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return false;
    L7:
        return new File(r1).exists();
    }

    public static long getAllBytes(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L15;
        return 0;
    L15:
    L12:
        e = move-exception;
        e.printStackTrace();
    L14:
        return 0;
    L6:
        if (TextUtils.isEmpty(r5) == true) goto L14;
        if (new File(r5).exists() == false) goto L14;
        StatFs r0 = new StatFs(r5);     // Catch: Exception -> L12
        return ((long) r0.getBlockSize()) * r0.getBlockCount();
    }

    public static long getAvailableBytes(String r5) {
    L9:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L3:
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return 0;
    L5:
        if (new File(r5).exists() == false) goto L16;
        StatFs r0 = new StatFs(r5);     // Catch: Exception -> L9
        return ((long) r0.getBlockSize()) * r0.getAvailableBlocks();
    L16:
        return 0;
    }

    public static String getFileExtension(String r2) {
        int r0 = r2.lastIndexOf(LibrarianImpl.Constants.DOT);
        if (r0 >= 0) goto L5;
        return "";
    L5:
        if (r0 < (r2.length() - 1)) goto L7;
        return "";
    L7:
        return r2.substring(r0 + 1).toUpperCase(Locale.getDefault());
    }

    public static String getFileName(String r3) {
        if (r3.endsWith(LibrarianImpl.Constants.SEPARATOR) == false) goto L5;
        r3 = r3.substring(0, r3.length() - 1);
    L5:
        int r0 = r3.lastIndexOf(LibrarianImpl.Constants.SEPARATOR);
        if (r0 > 0) goto L8;
        return r3;
    L8:
        if (r0 < (r3.length() - 1)) goto L10;
        return r3;
    L10:
        return r3.substring(r0 + 1);
    }

    public static String getFileNameWithoutExtension(String r2) {
        String r3 = getFileName(r2);
        if (r3 != null) goto L5;
        return r3;
    L5:
        if (r3.length() <= 0) goto L11;
        int r0 = r3.lastIndexOf(46);
        if (r0 > 0) goto L9;
        return r3;
    L9:
        return r3.substring(0, r0);
    L11:
        return r3;
    }

    public static long getFileSize(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return 0;
    L5:
        File r0 = new File(r8);
        if (r0.exists() == true) goto L8;
        return 0;
    L8:
        long r3 = r0.length();
        if (r0.isDirectory() == false) goto L25;
        File[] r9 = r0.listFiles();
        if (r9 == null) goto L25;
        int r1 = r9.length;
        int r5 = 0;
    L13:
        if (r5 >= r1) goto L25;
        r3 = r3 + getFileSize(r9[r5].getAbsolutePath());
        r5 = r5 + 1;
        goto L13
    L17:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L19:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L25:
        return r3;
    }

    public static String getParentFilePath(String r3) {
        if (r3.endsWith(LibrarianImpl.Constants.SEPARATOR) == false) goto L5;
        r3 = r3.substring(0, r3.length() - 1);
    L5:
        int r0 = r3.lastIndexOf(LibrarianImpl.Constants.SEPARATOR);
        if (r0 >= 0) goto L8;
        return null;
    L8:
        return r3.substring(0, r0);
    }

    public static boolean mkdir(String r1) {
        return new File(r1).mkdirs();
    }

    public static String readFileFirstLine(String r3) {
        BufferedReader r0 = null;
        BufferedReader r1 = new BufferedReader(new FileReader(r3));     // Catch: Throwable -> L13 Exception -> L28
        goto L16
    L37:
        String r4 = r1.readLine();     // Catch: Throwable -> L10 Exception -> L12
        r1.close();     // Catch: Throwable -> L10 Exception -> L12
        r1.close();     // Catch: IOException -> L7
    L9:
        return r4;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    L12:
        r0 = r1;
    L10:
        th = th;
        r0 = r1;
    L22:
        if (r0 != null) goto L31;
    L27:
        throw th;
    L31:
        r0.close();     // Catch: IOException -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
    L13:
        th = th;
    L16:
        if (r0 != null) goto L29;
    L21:
        return "";
    L29:
        r0.close();     // Catch: IOException -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L21
    }

    public static boolean renameFile(String r1, String r2) {
        File r0 = new File(r1);
        File r3 = new File(r2);
        if (r0.exists() == true) goto L7;
        return false;
    L7:
        return r0.renameTo(r3);
    }

    public static void setPermissions(String r1, int r2) {
        JavaCalls.callStaticMethod("android.os.FileUtils", r1, new Object[]{Integer.valueOf(r2), -1, -1});
    }

    public static void write(String r3, String r4, boolean r5) {
        FileWriter r0 = null;
        File r1 = new File(r3);     // Catch: Throwable -> L6 IOException -> L8
        if (r1.exists() == true) goto L10;
        r1.getParentFile().mkdirs();     // Catch: Throwable -> L6 IOException -> L8
        r1.createNewFile();     // Catch: Throwable -> L6 IOException -> L8
    L10:
        FileWriter r2 = new FileWriter(r3, r5);     // Catch: Throwable -> L6 IOException -> L8
    L42:
        r2.write(r4);     // Catch: Throwable -> L14 IOException -> L16
        r2.close();     // Catch: Exception -> L31
    L33:
    L36:
        return;
    L16:
        e = e;
        r0 = r2;
    L24:
        e.printStackTrace();     // Catch: Throwable -> L22
        if (r0 == null) goto L36;
    L20:
        r0.close();     // Catch: Exception -> L31
    L14:
        th = th;
        r0 = r2;
    L18:
        th.printStackTrace();     // Catch: Throwable -> L22
        if (r0 == null) goto L36;
    L8:
        e = e;
    L6:
        th = th;
    L44:
        return;
    L22:
        th = move-exception;
        if (r0 != null) goto L39;
    L30:
        throw th;
    L39:
        r0.close();     // Catch: Exception -> L32
        goto L30
    }

    public static void close(ZipFile r0) {
        if (r0 != null) goto L7;
        return;
    L7:
        r0.close();     // Catch: IOException -> L6
        return;
    }

    public static boolean copyFile(String r1, String r2) {
        return copyFile(new File(r1), new File(r2));
    }
}
