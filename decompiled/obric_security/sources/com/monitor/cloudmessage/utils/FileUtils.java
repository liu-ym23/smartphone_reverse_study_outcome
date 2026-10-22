package com.monitor.cloudmessage.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm6.util.IOUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.monitor.cloudmessage.CloudMessageManager;
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

/* JADX INFO: loaded from: classes2.dex */
public class FileUtils {
    static final int BUFFER = 8192;
    private static final String TAG = "FileUtils";

    static {
    }

    public FileUtils() {
    }

    public static File getCloudMsgDir(Context r2) {
        File r1 = r2.getExternalFilesDir("cloudMessage");
        if (r1 != null) goto L6;
        r1 = new File(r2.getFilesDir(), "cloudMessage");
    L6:
        if (r1.exists() == true) goto L8;
        r1.mkdir();
    L8:
        return r1;
    }

    public static void ensureDirectoryClean(File r1) {
        if (r1.exists() == false) goto L5;
        removeDir(r1.getAbsolutePath());
    L5:
        r1.mkdirs();
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

    public static boolean removeDir(String r7) {
        File r0 = new File(r7);
        if (r0.exists() == true) goto L5;
        return true;
    L5:
        if (r0.isDirectory() == false) goto L30;
        File[] r8 = r0.listFiles();
        int r2 = r8.length;
        boolean r5 = true;
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L20;
        if (r8[r4].isDirectory() == false) goto L15;
        if (r5 == true) goto L12;
    L14:
        r5 = false;
    L19:
        r4 = r4 + 1;
        goto L7
    L12:
        if (removeDir(r8[r4].getAbsolutePath()) == false) goto L14;
    L13:
        r5 = true;
        goto L19
    L15:
        if (r5 == false) goto L14;
        if (r8[r4].delete() == false) goto L14;
    L20:
        if (r5 == false) goto L25;
        if (r0.delete() == false) goto L25;
        return true;
    L25:
        return false;
    L30:
        return true;
    }

    public static void deleteFile(File r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.exists() == true) goto L7;
        return;
    L7:
        if (r5.isDirectory() == false) goto L17;
        File[] r0 = r5.listFiles();
        int r1 = r0.length;
        int r2 = 0;
    L9:
        if (r2 >= r1) goto L17;
        File r3 = r0[r2];
        if (r3.isFile() == false) goto L14;
        r3.delete();
    L16:
        r2 = r2 + 1;
        goto L9
    L14:
        if (r5.isDirectory() == false) goto L16;
        deleteFile(r3);
    L17:
        r5.delete();
    }

    public static boolean copyFile(String r3, String r4, String r5) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
    L28:
        return false;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L28;
        if (TextUtils.isEmpty(r5) == true) goto L28;
        FileInputStream r0 = null;
        FileInputStream r2 = new FileInputStream(r3);     // Catch: Throwable -> L18 Exception -> L20
        boolean r6 = saveInputStream(r2, r4, r5);     // Catch: Throwable -> L14 Exception -> L16
        r2.close();     // Catch: Exception -> L29
    L13:
        return r6;
    L16:
        e = e;
        r0 = r2;
    L21:
        e.printStackTrace();     // Catch: Throwable -> L18
        if (r0 != null) goto L37;
    L24:
        return false;
    L37:
        r0.close();     // Catch: Exception -> L31
    L14:
        th = th;
        r0 = r2;
    L25:
        if (r0 != null) goto L34;
    L27:
        throw th;
    L34:
        r0.close();     // Catch: Exception -> L30
    L20:
        e = e;
    L18:
        th = th;
        goto L25
    }

    public static boolean copyFile(String r3, String r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
    L26:
        return false;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L26;
        FileInputStream r0 = null;
        FileInputStream r2 = new FileInputStream(r3);     // Catch: Throwable -> L16 Exception -> L18
        boolean r5 = saveInputStream(r2, r4);     // Catch: Throwable -> L12 Exception -> L14
        r2.close();     // Catch: Exception -> L27
    L11:
        return r5;
    L14:
        e = e;
        r0 = r2;
    L19:
        e.printStackTrace();     // Catch: Throwable -> L16
        if (r0 != null) goto L32;
    L22:
        return false;
    L32:
        r0.close();     // Catch: Exception -> L29
    L12:
        th = th;
        r0 = r2;
    L23:
        if (r0 != null) goto L37;
    L25:
        throw th;
    L37:
        r0.close();     // Catch: Exception -> L28
    L16:
        th = th;
    L18:
        e = e;
        goto L19
    }

    public static boolean saveInputStream(InputStream r4, String r5, String r6) {
        if (r4 != null) goto L5;
        return false;
    L5:
        FileOutputStream r1 = null;
        File r2 = new File(r5);     // Catch: Throwable -> L29 Exception -> L31
        if (r2.exists() == false) goto L9;
    L13:
        FileOutputStream r7 = new FileOutputStream(new File(r2, r6));     // Catch: Throwable -> L29 Exception -> L31
        byte[] r8 = new byte[1024];     // Catch: Throwable -> L25 Exception -> L27
    L16:
        int r3 = r4.read(r8);     // Catch: Throwable -> L25 Exception -> L27
        if (r3 == (-1)) goto L19;
        r7.write(r8, 0, r3);     // Catch: Throwable -> L25 Exception -> L27
        goto L16
    L19:
        r7.flush();     // Catch: Throwable -> L25 Exception -> L27
        r7.close();     // Catch: Throwable -> L25 Exception -> L27
        r4.close();     // Catch: Throwable -> L29 Exception -> L31
        if (r4 == null) goto L69;
        r4.close();     // Catch: Exception -> L44
        return true;
    L70:
        return true;
    L69:
        return true;
    L27:
        e = e;
        r1 = r7;
    L32:
        Log.d(TAG, "save inputstream error: " + e);     // Catch: Throwable -> L29
        if (r1 != null) goto L53;
    L35:
        if (r4 != null) goto L49;
    L37:
        return false;
    L49:
        r4.close();     // Catch: Exception -> L48
        goto L37
    L53:
        r1.close();     // Catch: Exception -> L47
    L25:
        th = th;
        r1 = r7;
    L38:
        if (r1 != null) goto L59;
    L40:
        if (r4 == null) goto L67;
        r4.close();     // Catch: Exception -> L46
        throw th;
    L68:
        throw th;
    L67:
        throw th;
    L59:
        r1.close();     // Catch: Exception -> L45
        goto L40
    L9:
        if (r2.mkdirs() == true) goto L13;
        if (r4 != null) goto L57;
    L12:
        return false;
    L57:
        r4.close();     // Catch: Exception -> L43
    L31:
        e = e;
    L29:
        th = th;
        goto L38
    }

    public static boolean saveInputStream(InputStream r6, String r7) {
        if (r6 != null) goto L5;
        return false;
    L5:
        FileOutputStream r1 = null;
        File r2 = new File(r7);     // Catch: Throwable -> L25 Exception -> L27
        if (r2.exists() == true) goto L9;
        r2.createNewFile();     // Catch: Throwable -> L25 Exception -> L27
    L9:
        FileOutputStream r8 = new FileOutputStream(r2);     // Catch: Throwable -> L25 Exception -> L27
        byte[] r3 = new byte[1024];     // Catch: Throwable -> L21 Exception -> L23
    L12:
        int r4 = r6.read(r3);     // Catch: Throwable -> L21 Exception -> L23
        if (r4 == (-1)) goto L15;
        r8.write(r3, 0, r4);     // Catch: Throwable -> L21 Exception -> L23
        goto L12
    L15:
        r8.flush();     // Catch: Throwable -> L21 Exception -> L23
        r8.close();     // Catch: Throwable -> L21 Exception -> L23
        r6.close();     // Catch: Throwable -> L25 Exception -> L27
        if (r6 == null) goto L61;
        r6.close();     // Catch: Exception -> L39
        return true;
    L62:
        return true;
    L61:
        return true;
    L23:
        e = move-exception;
        r1 = r8;
        e = e;
    L28:
        Log.d(TAG, "save inputstream error: " + e);     // Catch: Throwable -> L25
        if (r1 != null) goto L44;
    L31:
        if (r6 != null) goto L51;
    L33:
        return false;
    L51:
        r6.close();     // Catch: Exception -> L43
        goto L33
    L44:
        r1.close();     // Catch: Exception -> L42
    L21:
        th = move-exception;
        r1 = r8;
        th = th;
    L34:
        if (r1 != null) goto L49;
    L36:
        if (r6 == null) goto L59;
        r6.close();     // Catch: Exception -> L41
        throw th;
    L60:
        throw th;
    L59:
        throw th;
    L49:
        r1.close();     // Catch: Exception -> L40
    L25:
        th = th;
    L27:
        e = e;
        goto L28
    }

    public static void zip(String r1, String r2) throws Exception {
        zip(r2, new File(r1));
    }

    private static void zip(String r3, File r4) throws Exception {
        ZipOutputStream r0 = null;
        ZipOutputStream r1 = new ZipOutputStream(new FileOutputStream(r3));     // Catch: Throwable -> L9
        zip(r1, r4, "");     // Catch: Throwable -> L7
        IOUtils.closeQuietly(r1);
        return;
    L7:
        th = th;
        r0 = r1;
    L10:
        IOUtils.closeQuietly(r0);
        throw th;
    L9:
        th = th;
        goto L10
    }

    private static void zip(ZipOutputStream r4, File r5, String r6) throws Exception {
        if (r5.isDirectory() == false) goto L12;
        File[] r7 = r5.listFiles();
        r4.putNextEntry(new ZipEntry(r6 + LibrarianImpl.Constants.SEPARATOR));
        if (r6.length() != 0) goto L7;
        String r8 = "";
    L8:
        int r0 = 0;
    L10:
        if (r0 >= r7.length) goto L32;
        zip(r4, r7[r0], r8 + r7[r0].getName());
        r0 = r0 + 1;
        goto L10
    L32:
        return;
    L7:
        r8 = r6 + LibrarianImpl.Constants.SEPARATOR;
        goto L8
    L12:
        r4.putNextEntry(new ZipEntry(r6));
        FileInputStream r9 = null;
        FileInputStream r1 = new FileInputStream(r5);     // Catch: Throwable -> L22
    L27:
        int r10 = r1.read();     // Catch: Throwable -> L20
        if (r10 == (-1)) goto L18;
        r4.write(r10);     // Catch: Throwable -> L20
        goto L27
    L18:
        IOUtils.closeQuietly(r1);
        return;
    L20:
        th = th;
        r9 = r1;
    L23:
        IOUtils.closeQuietly(r9);
        throw th;
    L22:
        th = th;
        goto L23
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
        throw new RuntimeException(r5 + "不存在！");     // Catch: Exception -> L15 Throwable -> L33
    L13:
        IOUtils.closeQuietly(r3);
        IOUtils.closeQuietly(r2);
        IOUtils.closeQuietly(r1);
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
        IOUtils.closeQuietly(r10);
        IOUtils.closeQuietly(r0);
        IOUtils.closeQuietly(r1);
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
        if (r3.isDirectory() == false) goto L6;
        compressDirectory(r3, r4, r5 + r3.getName() + File.separator);
        return;
    L6:
        if (ApmContext.isDebugMode() == false) goto L8;
        Logger.d("cloudmessage", new String[]{"压缩：" + r5 + r3.getName()});
    L8:
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
        IOUtils.closeQuietly(r2);
        IOUtils.closeQuietly(r1);
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
        IOUtils.closeQuietly(r0);
        IOUtils.closeQuietly(r1);
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

    public static boolean hasSdcard() {
        if (Environment.getExternalStorageState().equals("mounted") == false) goto L6;
        return true;
    L6:
        return false;
    }

    public static File joinFile(String r3, String r4) {
        Context r0 = CloudMessageManager.getInstance().getContext();
        r3.hashCode();
        byte r2 = -1;
        switch(r3.hashCode()) {
            case -1481211727: goto L26;
            case -1427366653: goto L22;
            case -1301710629: goto L18;
            case -540898700: goto L14;
            case 70125656: goto L10;
            case 1506669642: goto L6;
            default: goto L30;
        };
    L6:
        if (r3.equals("data_package_file") == false) goto L30;
        r2 = 5;
        goto L30
    L10:
        if (r3.equals("sd_package") == false) goto L30;
        r2 = 4;
        goto L30
    L14:
        if (r3.equals("data_package_cache") == false) goto L30;
        r2 = 3;
        goto L30
    L18:
        if (r3.equals("sd_package_cache") == false) goto L30;
        r2 = 2;
        goto L30
    L22:
        if (r3.equals("sd_package_file") == false) goto L30;
        r2 = 1;
        goto L30
    L26:
        if (r3.equals("data_package") == false) goto L30;
        r2 = 0;
    L30:
        switch(r2) {
            case 0: goto L43;
            case 1: goto L41;
            case 2: goto L39;
            case 3: goto L37;
            case 4: goto L35;
            case 5: goto L33;
            default: goto L31;
        };
    L31:
        return null;
    L33:
        return new File(r0.getFilesDir(), r4);
    L35:
        return new File(r0.getExternalFilesDir(null).getParentFile(), r4);
    L37:
        return new File(r0.getCacheDir(), r4);
    L39:
        return new File(r0.getExternalCacheDir(), r4);
    L41:
        return new File(r0.getExternalFilesDir(null), r4);
    L43:
        return new File(r0.getFilesDir().getParentFile(), r4);
    }

    public static String getFullPath(String r3, String r4) {
        Context r0 = CloudMessageManager.getInstance().getContext();
        r3.hashCode();
        byte r2 = -1;
        switch(r3.hashCode()) {
            case -1481211727: goto L26;
            case -1427366653: goto L22;
            case -1301710629: goto L18;
            case -540898700: goto L14;
            case 70125656: goto L10;
            case 1506669642: goto L6;
            default: goto L30;
        };
    L6:
        if (r3.equals("data_package_file") == false) goto L30;
        r2 = 5;
        goto L30
    L10:
        if (r3.equals("sd_package") == false) goto L30;
        r2 = 4;
        goto L30
    L14:
        if (r3.equals("data_package_cache") == false) goto L30;
        r2 = 3;
        goto L30
    L18:
        if (r3.equals("sd_package_cache") == false) goto L30;
        r2 = 2;
        goto L30
    L22:
        if (r3.equals("sd_package_file") == false) goto L30;
        r2 = 1;
        goto L30
    L26:
        if (r3.equals("data_package") == false) goto L30;
        r2 = 0;
    L30:
        switch(r2) {
            case 0: goto L43;
            case 1: goto L41;
            case 2: goto L39;
            case 3: goto L37;
            case 4: goto L35;
            case 5: goto L33;
            default: goto L31;
        };
    L31:
        return null;
    L33:
        return new File(r0.getFilesDir(), r4).getAbsolutePath();
    L35:
        return new File(r0.getExternalFilesDir(null).getParentFile(), r4).getAbsolutePath();
    L37:
        return new File(r0.getCacheDir(), r4).getAbsolutePath();
    L39:
        return new File(r0.getExternalCacheDir(), r4).getAbsolutePath();
    L41:
        return new File(r0.getExternalFilesDir(null), r4).getAbsolutePath();
    L43:
        return new File(r0.getFilesDir().getParentFile(), r4).getAbsolutePath();
    }
}
