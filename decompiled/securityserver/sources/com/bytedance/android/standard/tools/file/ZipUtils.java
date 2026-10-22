package com.bytedance.android.standard.tools.file;

import a.a;
import com.bytedance.librarian.LibrarianImpl;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class ZipUtils {
    private static final String TEMP_SUFFIX = ".temp";

    private ZipUtils() {
    }

    private static void renameToOrigin(List<File> r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        Iterator<File> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L14;
        File r0 = r5.next();
        if (r0 == null) goto L6;
        String r1 = r0.getAbsolutePath();
        File r2 = new File(r1.substring(0, r1.indexOf(TEMP_SUFFIX)));
        if (r2.exists() == false) goto L13;
        r2.delete();
    L13:
        r0.renameTo(r2);
        goto L6
    }

    public static void unZipFolder(String r5, String r6) {
        ZipInputStream r0 = null;
        ZipInputStream r1 = new ZipInputStream(new FileInputStream(r5));     // Catch: Throwable -> L33 IOException -> L35
    L56:
        ZipEntry r7 = r1.getNextEntry();     // Catch: Throwable -> L12 IOException -> L14
        if (r7 == null) goto L29;
        String r2 = r7.getName();     // Catch: Throwable -> L12 IOException -> L14
        if (r2.contains("../") == true) goto L56;
        if (r7.isDirectory() == true) goto L11;
        File r8 = new File(r6 + File.separator + r2);     // Catch: Throwable -> L12 IOException -> L14
        if (r8.exists() == true) goto L19;
        r8.getParentFile().mkdirs();     // Catch: Throwable -> L12 IOException -> L14
        r8.createNewFile();     // Catch: Throwable -> L12 IOException -> L14
    L19:
        FileOutputStream r3 = new FileOutputStream(r8);     // Catch: Throwable -> L12 IOException -> L14
        byte[] r9 = new byte[1024];     // Catch: Throwable -> L12 IOException -> L14
    L20:
        int r4 = r1.read(r9);     // Catch: Throwable -> L12 IOException -> L14
        if (r4 == (-1)) goto L46;
        r3.write(r9, 0, r4);     // Catch: Throwable -> L12 IOException -> L14
        r3.flush();     // Catch: Throwable -> L12 IOException -> L14
        goto L20
    L46:
        r3.close();     // Catch: Throwable -> L12 IOException -> L26
    L26:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L12 IOException -> L14
        goto L56
    L11:
        new File(r6 + File.separator + r2.substring(0, r2.length() - 1)).mkdirs();     // Catch: Throwable -> L12 IOException -> L14
        goto L56
    L29:
        r1.close();     // Catch: IOException -> L31
    L53:
        return;
    L14:
        e = e;
        r0 = r1;
    L36:
        e.printStackTrace();     // Catch: Throwable -> L33
        if (r0 == null) goto L69;
        r0.close();     // Catch: IOException -> L31
        goto L53
    L69:
        return;
    L12:
        th = th;
        r0 = r1;
    L40:
        if (r0 != null) goto L48;
    L45:
        throw th;
    L48:
        r0.close();     // Catch: IOException -> L43
    L43:
        e = move-exception;
        e.printStackTrace();
    L35:
        e = e;
    L33:
        th = th;
    L31:
        e = move-exception;
        e.printStackTrace();
    }

    public static void unzip(File r6, File r7) {
        ZipFile r0 = new ZipFile(r6);
        Enumeration<? extends ZipEntry> r8 = r0.entries();
    L4:
        if (r8.hasMoreElements() == false) goto L21;
        ZipEntry r1 = r8.nextElement();
        if (r1.getName().contains("../") == true) goto L4;
        File r2 = new File(r7, r1.getName());
        if (r1.isDirectory() == false) goto L14;
        if (r2.exists() == true) goto L14;
        r2.mkdirs();
    L14:
        if (r2.getParentFile().exists() == true) goto L16;
        r2.getParentFile().mkdirs();
    L16:
        InputStream r3 = r0.getInputStream(r1);
        BufferedOutputStream r4 = new BufferedOutputStream(new FileOutputStream(r2));
        byte[] r5 = new byte[8192];
    L17:
        int r9 = r3.read(r5);
        if ((-1) == r9) goto L20;
        r4.write(r5, 0, r9);
        goto L17
    L20:
        r3.close();
        r4.close();
        goto L4
    L21:
        r0.close();
    }

    public static void unzipRenameToFile(String r1, String r2) {
        unzipRenameToFile(new File(r1), new File(r2));
    }

    private static List<File> unzipTempFile(String r7, ZipInputStream r8) {
        String r0 = File.separator;
        if (r7.endsWith(r0) == true) goto L5;
        r7 = a.j(r7, r0);
    L5:
        File r1 = new File(r7);
        if (r1.isFile() == false) goto L9;
        r1.delete();
    L9:
        if (r1.exists() == true) goto L12;
        r1.mkdir();
    L12:
        if (r1.isDirectory() == true) goto L14;
        return null;
    L14:
        ZipEntry r2 = r8.getNextEntry();
        ArrayList r3 = new ArrayList();
    L15:
        if (r2 == null) goto L42;
        String r4 = r2.getName();
        if (r4.contains("../") == true) goto L15;
        if (r4.endsWith(LibrarianImpl.Constants.SEPARATOR) == false) goto L24;
        File r5 = new File(a.j(r7, r4));
        r5.mkdir();
        if (r5.isDirectory() == false) goto L23;
    L39:
        r8.closeEntry();
        r2 = r8.getNextEntry();
        goto L15
    L23:
        return null;
    L24:
        File r6 = new File(a.B(r7, r4, TEMP_SUFFIX));
        if (r6.exists() == false) goto L27;
        r6.delete();
    L27:
        r6.createNewFile();
        if (r6.isFile() == false) goto L29;
        r3.add(r6);
        FileOutputStream r9 = new FileOutputStream(r6);
        BufferedOutputStream r10 = new BufferedOutputStream(r9);
        byte[] r11 = new byte[1024];     // Catch: Throwable -> L36
    L32:
        int r12 = r8.read(r11);     // Catch: Throwable -> L36
        if (r12 == (-1)) goto L38;
        r10.write(r11, 0, r12);     // Catch: Throwable -> L36
        goto L32
    L38:
        r10.close();
        r9.close();
    L36:
        th = move-exception;
        r10.close();
        r9.close();
        throw th;
    L29:
        return null;
    L42:
        return r3;
    }

    private static void zip(File r8, File r9, ZipOutputStream r10) {
        File[] r11 = r8.listFiles();
        byte[] r0 = new byte[8192];
        int r1 = r11.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L13;
        File r4 = r11[r3];
        if (r4.isDirectory() == false) goto L7;
        zip(r4, r9, r10);
    L12:
        r3 = r3 + 1;
        goto L3
    L7:
        FileInputStream r5 = new FileInputStream(r4);
        r10.putNextEntry(new ZipEntry(r4.getPath().substring(r9.getPath().length() + 1)));
    L8:
        int r6 = r5.read(r0);
        if ((-1) == r6) goto L11;
        r10.write(r0, 0, r6);
        goto L8
    L11:
        r5.close();
        goto L12
    }

    public static void zipDirectory(File r2, File r3) {
        ZipOutputStream r0 = new ZipOutputStream(new FileOutputStream(r3));
        zip(r2, r2, r0);
        r0.close();
    }

    public static void unzipRenameToFile(File r1, File r2) {
        if (r1.isDirectory() == true) goto L5;
    L7:
        FileInputStream r0 = new FileInputStream(r1);
        ZipInputStream r3 = new ZipInputStream(r0);
        renameToOrigin(unzipTempFile(r2.getAbsolutePath(), r3));     // Catch: Throwable -> L11
        r3.close();
        r0.close();
        return;
    L11:
        th = move-exception;
        r3.close();
        r0.close();
        throw th;
    L5:
        if (r2.isDirectory() == true) goto L7;
    }
}
