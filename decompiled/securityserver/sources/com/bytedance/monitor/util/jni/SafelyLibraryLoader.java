package com.bytedance.monitor.util.jni;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.monitor.util.IoUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes.dex */
public class SafelyLibraryLoader {
    private static final String LIB_DIR = "libso";
    private static List<String> sLoadedLibs;

    static {
        sLoadedLibs = new ArrayList();
    }

    public SafelyLibraryLoader() {
    }

    private static File getLibraryFile(Context r1, String r2) {
        String r3 = System.mapLibraryName(r2);
        File r4 = getLibraryFolder(r1);
        if (r4 != null) goto L5;
        return null;
    L5:
        return new File(r4, r3);
    }

    private static File getLibraryFolder(Context r2) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.getFilesDir() == null) goto L12;
        File r0 = new File(r2.getFilesDir(), LIB_DIR);
        if (r0.exists() == true) goto L9;
        IoUtil.mkdir(r0.getAbsolutePath());
    L9:
        return r0;
    L12:
        return null;
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    public static synchronized boolean loadLibrary(Context r6, String r7) {
        monitor-enter(SafelyLibraryLoader.class);
    L23:
        th = move-exception;
        throw th;
    L6:
        if (sLoadedLibs.contains(r7) == false) goto L40;
        monitor-exit(SafelyLibraryLoader.class);
        return true;
    L40:
        System.loadLibrary(r7);     // Catch: UnsatisfiedLinkError -> L12 Throwable -> L14
        sLoadedLibs.add(r7);     // Catch: UnsatisfiedLinkError -> L12 Throwable -> L14
    L31:
        monitor-exit(SafelyLibraryLoader.class);
        return true;
    L12:
        e = move-exception;
        File r4 = getLibraryFile(r6, r7);     // Catch: Throwable -> L23
        if (r4 != null) goto L21;
        return false;
    L21:
        if (r4.exists() == false) goto L25;
        r4.delete();     // Catch: Throwable -> L23
    L25:
        String r8 = unpackLibrary(r6, r7, r4);     // Catch: Throwable -> L23
        if (r8 == null) goto L37;
        Log.e("loadLibrary", e.getMessage() + "[" + r8 + "]");     // Catch: Throwable -> L23
        return false;
    L37:
        System.load(r4.getAbsolutePath());     // Catch: Throwable -> L33
        sLoadedLibs.add(r7);     // Catch: Throwable -> L33
    L34:
        return false;
    L15:
        return false;
    }

    public static String unpackLibrary(Context r9, String r10, File r11) {
        FileOutputStream r3 = null;
        ZipFile r4 = new ZipFile(new File(r9.getApplicationInfo().sourceDir), 1);     // Catch: Throwable -> L33
        StringBuilder r12 = new StringBuilder("lib/");     // Catch: Throwable -> L16
        String r5 = Build.CPU_ABI;     // Catch: Throwable -> L16
        r12.append(r5);     // Catch: Throwable -> L16
        r12.append(LibrarianImpl.Constants.SEPARATOR);     // Catch: Throwable -> L16
        r12.append(System.mapLibraryName(r10));     // Catch: Throwable -> L16
        ZipEntry r13 = r4.getEntry(r12.toString());     // Catch: Throwable -> L16
        if (r13 != null) goto L19;
        int r14 = r5.indexOf(45);     // Catch: Throwable -> L16
        StringBuilder r7 = new StringBuilder("lib/");     // Catch: Throwable -> L16
        if (r14 > 0) goto L10;
        r14 = r5.length();     // Catch: Throwable -> L16
    L10:
        r7.append(r5.substring(0, r14));     // Catch: Throwable -> L16
        r7.append(LibrarianImpl.Constants.SEPARATOR);     // Catch: Throwable -> L16
        r7.append(System.mapLibraryName(r10));     // Catch: Throwable -> L16
        String r15 = r7.toString();     // Catch: Throwable -> L16
        ZipEntry r16 = r4.getEntry(r15);     // Catch: Throwable -> L16
        if (r16 != null) goto L18;
        String r17 = "Library entry not found:" + r15;     // Catch: Throwable -> L16
        IoUtil.safeClose(null);
        IoUtil.safeClose(null);
    L14:
        IoUtil.safeClose(r4);
        return r17;
    L18:
        r13 = r16;
    L19:
        r11.createNewFile();     // Catch: Throwable -> L16
        InputStream r18 = r4.getInputStream(r13);     // Catch: Throwable -> L16
        FileOutputStream r19 = new FileOutputStream(r11);     // Catch: Throwable -> L31
        byte[] r0 = new byte[4096];     // Catch: Throwable -> L26
    L23:
        int r1 = r18.read(r0);     // Catch: Throwable -> L26
        if (r1 <= 0) goto L28;
        r19.write(r0, 0, r1);     // Catch: Throwable -> L26
        goto L23
    L28:
        IoUtil.setPermissions(r11.getAbsolutePath(), 493);     // Catch: Throwable -> L26
        IoUtil.safeClose(r19);
        IoUtil.safeClose(r18);
        IoUtil.safeClose(r4);
        return null;
    L26:
        th = move-exception;
        r3 = r19;
        InputStream r110 = r18;
        th = th;
    L42:
        r17 = th.getMessage();     // Catch: Throwable -> L37
        IoUtil.safeClose(r3);
        IoUtil.safeClose(r110);
    L37:
        th = move-exception;
        IoUtil.safeClose(r3);
        IoUtil.safeClose(r110);
        IoUtil.safeClose(r4);
        throw th;
    L31:
        th = move-exception;
        r110 = r18;
        th = th;
    L16:
        th = th;
        r110 = null;
    L33:
        th = th;
        r110 = null;
        r4 = null;
        goto L42
    }
}
