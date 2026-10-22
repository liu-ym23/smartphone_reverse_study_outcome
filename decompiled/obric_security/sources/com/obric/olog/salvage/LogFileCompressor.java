package com.obric.olog.salvage;

import android.content.Context;
import android.util.Log;
import com.bytedance.librarian.LibrarianImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class LogFileCompressor {
    private static final int BUFFER_SIZE = 8192;
    private static final String INCLUDE_SENSITIVE_FALSE = "false";
    private static final String INCLUDE_SENSITIVE_TRUE = "true";
    private static final Logger LOGGER = null;
    private static final String SENSITIVE_CONTENT_MARKER = "SensitiveContent";

    public LogFileCompressor() {
    }

    static {
        LOGGER = Logger.getLogger(LogFileCompressor.class.getName());
    }

    public static void compressLogFiles(Context r17, String[] r18, String r19) throws Exception {
        String[] r0 = r18;
        String r1 = r0[r0.length - 1].trim().toLowerCase();
        if (r1.equals("true") == false) goto L5;
    L8:
        r0 = (String[]) Arrays.copyOfRange(r0, 0, r0.length - 1);
        boolean r2 = r1.equals("true");
        Log.i("zhoupeng.725", "解析控制参数：isIncludeSensitive=" + r2);
    L9:
        File r4 = new File(r17.getFilesDir(), r19);
        if (r4.exists() == false) goto L54;
        r4.delete();
    L54:
        FileOutputStream r3 = new FileOutputStream(r4);     // Catch: Exception -> L50
        ZipOutputStream r13 = new ZipOutputStream(r3);     // Catch: Throwable -> L42
        int r14 = r0.length;     // Catch: Throwable -> L34
        int r15 = 0;
        boolean r16 = false;
    L15:
        if (r15 >= r14) goto L29;
        String r7 = r0[r15];     // Catch: Throwable -> L34
        File r8 = new File(r7);     // Catch: Throwable -> L34
        if (r8.exists() == true) goto L19;
    L27:
        LOGGER.log(Level.SEVERE, "Source directory {0} does not exist or is not a directory.", r7);     // Catch: Throwable -> L34
    L28:
        r15 = r15 + 1;     // Catch: Throwable -> L34
        goto L15
    L19:
        if (r8.isDirectory() == false) goto L27;
        if (compressDirectoryToZipfile(r8, r8.getName(), r13, r4, r8.getAbsolutePath().replaceAll(LibrarianImpl.Constants.SEPARATOR, "_"), r2) == true) goto L26;
        if (r16 == true) goto L26;
        r16 = false;
    L26:
        r16 = true;
        goto L28
    L29:
        if (r16 == true) goto L31;
        Log.i("zhoupeng.725", "atLeastOneFileAdded为false，空目录。添加一个empty_logs保证zip文件正常");     // Catch: Throwable -> L34
        r13.putNextEntry(new ZipEntry("empty_logs/"));     // Catch: Throwable -> L34
        r13.closeEntry();     // Catch: Throwable -> L34
    L31:
        r13.close();     // Catch: Throwable -> L42
        r3.close();     // Catch: Exception -> L50
        return;
    L34:
        th = move-exception;
        r13.close();     // Catch: Throwable -> L38
    L65:
        throw th;     // Catch: Throwable -> L42
    L38:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L42
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        r3.close();     // Catch: Throwable -> L46
    L66:
        throw th;     // Catch: Exception -> L50
    L46:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L50
        throw th;     // Catch: Exception -> L50
    L50:
        e = move-exception;
        LOGGER.log(Level.SEVERE, "Error compressing files to {0}: {1}", new Object[]{r4.getAbsolutePath(), e.getMessage()});
        throw e;
    L5:
        if (r1.equals(INCLUDE_SENSITIVE_FALSE) == true) goto L8;
        r2 = false;
        goto L9
    }

    private static boolean compressDirectoryToZipfile(File r10, String r11, ZipOutputStream r12, File r13, String r14, boolean r15) throws Exception {
        File[] r16 = r10.listFiles();
        if (r16 == null) goto L52;
        int r1 = r16.length;
        int r2 = 0;
        boolean r3 = false;
    L5:
        if (r2 >= r1) goto L37;
        File r4 = r16[r2];
        if (r4.equals(r13) == true) goto L35;
        if (r15 == true) goto L15;
        if (r4.getName().contains(SENSITIVE_CONTENT_MARKER) == false) goto L15;
        Log.i("zhoupeng.725", "Skipping sensitive file: " + r4.getAbsolutePath());
    L15:
        if (r4.isDirectory() == false) goto L17;
        r3 = r3 | compressDirectoryToZipfile(r4, r11 + LibrarianImpl.Constants.SEPARATOR + r4.getName(), r12, r13, r14, r15);
        goto L35
    L17:
        String r6 = r14 + LibrarianImpl.Constants.SEPARATOR + r11 + LibrarianImpl.Constants.SEPARATOR + r4.getName();
        Log.i("zhoupeng.725", "entryName:" + r6);
        FileInputStream r7 = new FileInputStream(r4);     // Catch: Exception -> L33
        r12.putNextEntry(new ZipEntry(r6));     // Catch: Throwable -> L27
        byte[] r8 = new byte[8192];     // Catch: Throwable -> L27
    L20:
        int r9 = r7.read(r8);     // Catch: Throwable -> L27
        if (r9 < 0) goto L23;
        r12.write(r8, 0, r9);     // Catch: Throwable -> L27
        goto L20
    L23:
        r12.closeEntry();     // Catch: Throwable -> L27
        r3 = true;
        r7.close();     // Catch: Exception -> L33
        goto L35
    L27:
        th = move-exception;
        r7.close();     // Catch: Throwable -> L30
    L32:
        throw th;     // Catch: Exception -> L33
    L30:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L33
    L33:
        e = move-exception;
        Log.e("zhoupeng.725", "压缩文件失败，将跳过该文件: " + r4.getAbsolutePath(), e);
    L35:
        r2 = r2 + 1;
        goto L5
    L37:
        return r3;
    L52:
        return false;
    }
}
