package com.bytedance.apm6.util;

import android.os.StatFs;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class FileUtils {
    public FileUtils() {
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x003c: MOVE (r0 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:28:0x003c */
    public static byte[] readFileToByteArray(File r5) {
        Closeable r0 = null;
        if (r5 != null) goto L5;
    L31:
        return null;
    L5:
        if (r5.exists() == false) goto L31;
        int r1 = (int) r5.length();
        byte[] r2 = new byte[r1];
        BufferedInputStream r3 = new BufferedInputStream(new FileInputStream(r5));     // Catch: Throwable -> L17 IOException -> L19 FileNotFoundException -> L22
    L33:
        r3.read(r2, 0, r1);     // Catch: IOException -> L13 FileNotFoundException -> L15 Throwable -> L27
        r3.close();     // Catch: IOException -> L13 FileNotFoundException -> L15 Throwable -> L27
        IOUtils.closeQuietly(r3);
        return r2;
    L15:
        e = e;
    L24:
        e.printStackTrace();     // Catch: Throwable -> L27
    L25:
        IOUtils.closeQuietly(r3);
        return null;
    L13:
        e = e;
    L21:
        e.printStackTrace();     // Catch: Throwable -> L27
    L27:
        th = th;
        r0 = r3;
    L29:
        IOUtils.closeQuietly(r0);
        throw th;
    L22:
        e = e;
        r3 = null;
    L19:
        e = e;
        r3 = null;
    L17:
        th = th;
        goto L29
    }

    public static boolean deleteFileWithResult(File r2) {
        if (r2 != null) goto L5;
    L9:
        return false;
    L5:
        if (r2.exists() == false) goto L9;
        return r2.delete();
    }

    public static void deleteFile(File r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.exists() == false) goto L12;
        r1.delete();     // Catch: Throwable -> L8
        return;
    L13:
        return;
    }

    public static long getAvailableStorage(String r2) {
        return new StatFs(r2).getAvailableBytes();
    }

    public static long getTotalStorageSize(String r2) {
        return new StatFs(r2).getTotalBytes();
    }
}
