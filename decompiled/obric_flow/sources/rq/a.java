package rq;

import ai.j0;
import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f21795a = null;

    static {
        f21795a = Logger.getLogger(a.class.getName());
    }

    public static void a(File r10, String r11, ZipOutputStream r12) {
        File[] r13 = r10.listFiles();
        if (r13 == null) goto L28;
        int r5 = r13.length;
        int r14 = 0;
    L5:
        if (r14 >= r5) goto L39;
        File r15 = r13[r14];
        if (r15.isDirectory() == false) goto L29;
        StringBuilder r16 = j0.w(r11, "/");
        r16.append(r15.getName());
        a(r15, r16.toString(), r12);
    L18:
        r14 = r14 + 1;
        goto L5
    L29:
        FileInputStream r17 = new FileInputStream(r15);     // Catch: IOException -> L19
        r12.putNextEntry(new ZipEntry(r11 + "/" + r15.getName()));     // Catch: Throwable -> L14
        byte[] r18 = new byte[8192];     // Catch: Throwable -> L14
    L11:
        int r19 = r17.read(r18);     // Catch: Throwable -> L14
        if (r19 < 0) goto L16;
        r12.write(r18, 0, r19);     // Catch: Throwable -> L14
        goto L11
    L16:
        r12.closeEntry();     // Catch: Throwable -> L14
        r17.close();     // Catch: IOException -> L19
        goto L18
    L14:
        th = move-exception;
        r17.close();     // Catch: Throwable -> L23
    L25:
        throw th;     // Catch: IOException -> L19
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L19
    L19:
        e = move-exception;
        f21795a.log(Level.SEVERE, "Error compressing file {0}: {1}", new Object[]{r15.getAbsolutePath(), e.getMessage()});
        throw e;
    L39:
        return;
    }

    public static void b(Context r10, String[] r11) {
        Logger r5 = f21795a;
        File r12 = new File(r10.getFilesDir(), "ologs.zip");
        if (r12.exists() == false) goto L43;
        r12.delete();
    L43:
        FileOutputStream r13 = new FileOutputStream(r12);     // Catch: IOException -> L22
        ZipOutputStream r14 = new ZipOutputStream(r13);     // Catch: Throwable -> L24
        int r15 = r11.length;     // Catch: Throwable -> L15
        int r16 = 0;
    L8:
        if (r16 >= r15) goto L19;
        String r17 = r11[r16];     // Catch: Throwable -> L15
        File r18 = new File(r17);     // Catch: Throwable -> L15
        if (r18.exists() == true) goto L12;
    L17:
        r5.log(Level.SEVERE, "Source directory {0} does not exist or is not a directory.", r17);     // Catch: Throwable -> L15
    L18:
        r16 = r16 + 1;
        goto L8
    L12:
        if (r18.isDirectory() == false) goto L17;
        a(r18, r18.getName(), r14);     // Catch: Throwable -> L15
        goto L18
    L19:
        r14.close();     // Catch: Throwable -> L24
        r13.close();     // Catch: IOException -> L22
        return;
    L15:
        th = move-exception;
        r14.close();     // Catch: Throwable -> L28
    L30:
        throw th;     // Catch: Throwable -> L24
    L28:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        r13.close();     // Catch: Throwable -> L33
    L35:
        throw th;     // Catch: IOException -> L22
    L33:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L22
    L22:
        e = move-exception;
        r5.log(Level.SEVERE, "Error compressing files to {0}: {1}", new Object[]{r12.getAbsolutePath(), e.getMessage()});
        throw e;
    }
}
