package com.obric.olog.salvage;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f10723a = null;

    static {
        f10723a = Logger.getLogger(b.class.getName());
    }

    public b() {
    }

    private static boolean a(File r15, String r16, ZipOutputStream r17, File r18, String r19, boolean r20) {
        File[] r9 = r15.listFiles();
        if (r9 == null) goto L57;
        int r11 = r9.length;
        int r12 = 0;
        boolean r13 = false;
    L5:
        if (r12 >= r11) goto L41;
        File r2 = r9[r12];
        if (r2.equals(r18) == true) goto L39;
        if (r20 == true) goto L16;
        if (r2.getName().contains("SensitiveContent") == false) goto L16;
        Log.i("zhoupeng.725", "Skipping sensitive file: " + r2.getAbsolutePath());
    L16:
        if (r2.isDirectory() == false) goto L18;
        r13 = r13 | a(r2, r16 + "/" + r2.getName(), r17, r18, r19, r20);
        goto L39
    L18:
        String r0 = r19 + "/" + r16 + "/" + r2.getName();
        Log.i("zhoupeng.725", "entryName:" + r0);
        FileInputStream r5 = new FileInputStream(r2);     // Catch: Exception -> L37
        r17.putNextEntry(new ZipEntry(r0));     // Catch: Throwable -> L29
        byte[] r1 = new byte[8192];     // Catch: Throwable -> L29
    L21:
        int r7 = r5.read(r1);     // Catch: Throwable -> L29
        if (r7 < 0) goto L24;
        r17.write(r1, 0, r7);     // Catch: Throwable -> L29
        goto L21
    L24:
        r17.closeEntry();     // Catch: Throwable -> L29
        r5.close();     // Catch: Exception -> L27
        r13 = true;
    L27:
        e = e;
        r13 = true;
    L38:
        Log.e("zhoupeng.725", "压缩文件失败，将跳过该文件: " + r2.getAbsolutePath(), e);
        goto L39
    L29:
        th = move-exception;
        r5.close();     // Catch: Throwable -> L33
    L36:
        throw th;     // Catch: Exception -> L37
    L33:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L37
    L37:
        e = e;
    L39:
        r12 = r12 + 1;
        goto L5
    L41:
        return r13;
    L57:
        return false;
    }

    public static void b(Context r17, String[] r18, String r19) {
        String[] r0 = r18;
        String r1 = r0[r0.length - 1].trim().toLowerCase();
        if (r1.equals("true") == false) goto L5;
    L8:
        r0 = (String[]) Arrays.copyOfRange(r0, 0, r0.length - 1);
        boolean r2 = r1.equals("true");
        Log.i("zhoupeng.725", "解析控制参数：isIncludeSensitive=" + r2);
    L9:
        File r4 = new File(r17.getFilesDir(), r19);
        if (r4.exists() == false) goto L53;
        r4.delete();
    L53:
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
        f10723a.log(Level.SEVERE, "Source directory {0} does not exist or is not a directory.", r7);     // Catch: Throwable -> L34
    L28:
        r15 = r15 + 1;     // Catch: Throwable -> L34
        goto L15
    L19:
        if (r8.isDirectory() == false) goto L27;
        if (a(r8, r8.getName(), r13, r4, r8.getAbsolutePath().replaceAll("/", "_"), r2) == true) goto L26;
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
        f10723a.log(Level.SEVERE, "Error compressing files to {0}: {1}", new Object[]{r4.getAbsolutePath(), e.getMessage()});
        throw e;
    L5:
        if (r1.equals("false") == true) goto L8;
        r2 = false;
        goto L9
    }
}
