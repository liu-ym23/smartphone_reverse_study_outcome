package com.bytedance.boost_multidex;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
import android.os.Process;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class Utility {
    public Utility() {
    }

    static void clearDirFiles(File r7) {
        if (r7.exists() == true) goto L5;
        return;
    L5:
        File[] r0 = r7.listFiles();
        if (r0 != null) goto L9;
        Monitor.get().logWarning("Failed to list secondary dex dir content (" + r7.getPath() + ").");
        return;
    L9:
        int r8 = r0.length;
        int r1 = 0;
    L10:
        if (r1 >= r8) goto L16;
        File r2 = r0[r1];
        Monitor.get().logInfo("Trying to delete old file " + r2.getPath() + " of size " + r2.length());
        if (r2.delete() == true) goto L14;
        Monitor.get().logWarning("Failed to delete old file " + r2.getPath());
    L15:
        r1 = r1 + 1;
        goto L10
    L14:
        Monitor.get().logInfo("Deleted old file " + r2.getPath());
        goto L15
    }

    static void closeQuietly(Closeable r2) {
        if (r2 != null) goto L9;
        return;
    L9:
        r2.close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        Monitor.get().logWarning("Failed to close resource", e);
    }

    static long doFileCheckSum(File r6) {
        if (r6.exists() == true) goto L7;
        Monitor.get().logInfo("File is not exist: " + r6.getPath());
        return 0;
    L7:
        if (Monitor.get().isEnableNativeCheckSum() == true) goto L27;
    L12:
        long r3 = 0;
    L14:
        if (r3 != 0) goto L26;
        Monitor.get().logWarning("Fall back to java impl");
        CheckedInputStream r0 = null;
        byte[] r1 = new byte[8192];
        CheckedInputStream r2 = new CheckedInputStream(new FileInputStream(r6), new Adler32());     // Catch: Throwable -> L23
    L29:
    L21:
        th = th;
        r0 = r2;
    L24:
        closeQuietly(r0);
        throw th;
    L18:
        if (r2.read(r1) >= 0) goto L29;
        r3 = r2.getChecksum().getValue();     // Catch: Throwable -> L21
        closeQuietly(r2);
    L23:
        th = th;
    L26:
        return r3;
    L27:
        r3 = BoostNative.obtainCheckSum(r6.getPath());     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Monitor.get().logWarning("Failed to native obtainCheckSum in " + r6.getPath(), th);
        goto L12
    }

    static long doZipCheckSum(File r12) {
        RandomAccessFile r0 = null;
        RandomAccessFile r1 = new RandomAccessFile(r12, "r");     // Catch: Throwable -> L31
        long r2 = r1.length() - 22;     // Catch: Throwable -> L29
        if (r2 < 0) goto L28;
        long r6 = r2 - 65536;     // Catch: Throwable -> L29
        if (r6 >= 0) goto L9;
        r6 = 0;
    L9:
        int r13 = Integer.reverseBytes(Constants.ENDSIG);     // Catch: Throwable -> L29
    L10:
        r1.seek(r2);     // Catch: Throwable -> L29
        if (r1.readInt() == r13) goto L12;
        r2 = r2 - 1;
        if (r2 >= r6) goto L10;
        throw new ZipException("End Of Central Directory signature not found");     // Catch: Throwable -> L29
    L12:
        r1.skipBytes(2);     // Catch: Throwable -> L29
        r1.skipBytes(2);     // Catch: Throwable -> L29
        r1.skipBytes(2);     // Catch: Throwable -> L29
        r1.skipBytes(2);     // Catch: Throwable -> L29
        long r3 = ((long) Integer.reverseBytes(r1.readInt())) & 4294967295L;     // Catch: Throwable -> L29
        long r7 = 4294967295L & ((long) Integer.reverseBytes(r1.readInt()));     // Catch: Throwable -> L29
        CRC32 r14 = new CRC32();     // Catch: Throwable -> L29
        r1.seek(r7);     // Catch: Throwable -> L29
        byte[] r8 = new byte[8192];     // Catch: Throwable -> L29
        int r4 = r1.read(r8, 0, (int) Math.min(8192, r3));     // Catch: Throwable -> L29
    L14:
        if (r4 == (-1)) goto L19;
        r14.update(r8, 0, r4);     // Catch: Throwable -> L29
        r3 = r3 - ((long) r4);     // Catch: Throwable -> L29
        if (r3 == 0) goto L19;
        r4 = r1.read(r8, 0, (int) Math.min(8192, r3));     // Catch: Throwable -> L29
    L19:
        long r5 = r14.getValue();     // Catch: Throwable -> L29
        closeQuietly(r1);
        return r5;
    L28:
        throw new ZipException("File too short to be a zip file: " + r1.length());     // Catch: Throwable -> L29
    L29:
        th = th;
        r0 = r1;
    L32:
        closeQuietly(r0);
        throw th;
    L31:
        th = th;
        goto L32
    }

    static File ensureDirCreated(File r1, String r2) {
        File r0 = new File(r1, r2);
        mkdirChecked(r0);
        return r0;
    }

    static void expandFieldArray(Object r4, String r5, Object[] r6) {
        Field r7 = findField(r4.getClass(), r5);
        Object[] r0 = (Object[]) r7.get(r4);
        Object[] r1 = (Object[]) Array.newInstance(r0.getClass().getComponentType(), r0.length + r6.length);
        System.arraycopy(r0, 0, r1, 0, r0.length);
        System.arraycopy(r6, 0, r1, r0.length, r6.length);
        r7.set(r4, r1);
    }

    static Constructor findConstructor(Class<?> r0, Class<?>... r1) {
        Constructor<?> r2 = r0.getDeclaredConstructor(r1);
        if (r2.isAccessible() == true) goto L5;
        r2.setAccessible(true);
    L5:
        return r2;
    }

    static Field findField(Class<?> r0, String r1) {
        Field r2 = r0.getDeclaredField(r1);
        if (r2.isAccessible() == true) goto L5;
        r2.setAccessible(true);
    L5:
        return r2;
    }

    static Field findFieldRecursively(Class<?> r3, String r4) {
        Class<?> r0 = r3;
    L3:
        if (r0 == null) goto L8;
        return findField(r0, r4);
    L6:
        r0 = r0.getSuperclass();
        goto L3
    L8:
        throw new NoSuchFieldException("Field " + r4 + " not found in " + r3);
    }

    static Method findMethod(Class<?> r0, String r1, Class<?>... r2) {
        Method r3 = r0.getDeclaredMethod(r1, r2);
        if (r3.isAccessible() == true) goto L5;
        r3.setAccessible(true);
    L5:
        return r3;
    }

    static Method findMethodRecursively(Class<?> r3, String r4, Class<?>... r5) {
        Class<?> r0 = r3;
    L3:
        if (r0 == null) goto L8;
        return findMethod(r0, r4, r5);
    L6:
        r0 = r0.getSuperclass();
        goto L3
    L8:
        throw new NoSuchMethodException("Method " + r4 + " with parameters " + Arrays.asList(r5) + " not found in " + r3);
    }

    static String getCurProcessName(Context r3) {
        int r0 = Process.myPid();     // Catch: Exception -> L9
        Iterator<ActivityManager.RunningAppProcessInfo> r4 = ((ActivityManager) r3.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L9
    L4:
        if (r4.hasNext() == false) goto L18;
        ActivityManager.RunningAppProcessInfo r1 = r4.next();     // Catch: Exception -> L9
        if (r1.pid != r0) goto L4;
        return r1.processName;
    L18:
        return null;
    L9:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    static boolean isBetterUseApkBuf() {
        Runtime r0 = Runtime.getRuntime();
        long r1 = Environment.getDataDirectory().getFreeSpace();
        long r3 = r0.maxMemory() - r0.totalMemory();
        Monitor.get().logInfo("Memory remains " + r3 + ", free space " + r1);
        if (r3 <= Constants.MEM_THRESHOLD) goto L5;
    L8:
        return true;
    L5:
        if (r1 < Constants.SPACE_MIN_THRESHOLD) goto L8;
        return false;
    }

    static boolean isOptimizeProcess(String r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (r1.endsWith(":boost_multidex") == false) goto L6;
        return true;
    }

    static void mkdirChecked(File r4) {
        if (r4.exists() == true) goto L6;
        r4.mkdirs();
    L6:
        if (r4.isDirectory() == true) goto L13;
        File r0 = r4.getParentFile();
        if (r0 != null) goto L10;
        Monitor.get().logError("Failed to create dir " + r4.getPath() + ". Parent file is null.");
    L12:
        throw new IOException("Failed to create directory " + r4.getPath());
    L10:
        Monitor.get().logError("Failed to create dir " + r4.getPath() + ". parent file is a dir " + r0.isDirectory() + ", a file " + r0.isFile() + ", exists " + r0.exists() + ", readable " + r0.canRead() + ", writable " + r0.canWrite());
        goto L12
    }

    static byte[] obtainBytesFromInputStream(InputStream r4) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        byte[] r1 = new byte[8192];     // Catch: Throwable -> L10
    L4:
        int r2 = r4.read(r1);     // Catch: Throwable -> L10
        if (r2 == (-1)) goto L7;
        r0.write(r1, 0, r2);     // Catch: Throwable -> L10
        goto L4
    L7:
        byte[] r5 = r0.toByteArray();     // Catch: Throwable -> L10
        closeQuietly(r0);
        return r5;
    L10:
        th = move-exception;
        closeQuietly(r0);
        throw th;
    }

    static byte[] obtainBytesInFile(File r4) {
        RandomAccessFile r0 = null;
        RandomAccessFile r1 = new RandomAccessFile(r4.getPath(), "r");     // Catch: Throwable -> L9 IOException -> L11
        byte[] r5 = new byte[(int) r1.length()];     // Catch: IOException -> L7 Throwable -> L16
        r1.readFully(r5);     // Catch: IOException -> L7 Throwable -> L16
        closeQuietly(r1);
        return r5;
    L7:
        e = e;
    L13:
        Monitor.get().logWarning("Fail to get bytes of file", e);     // Catch: Throwable -> L16
        closeQuietly(r1);
        return null;
    L16:
        th = th;
        r0 = r1;
    L18:
        closeQuietly(r0);
        throw th;
    L11:
        e = e;
        r1 = null;
    L9:
        th = th;
        goto L18
    }

    static byte[] obtainEntryBytesInZip(ZipFile r5, ZipEntry r6) {
        InputStream r0 = null;
        int r1 = 3;
        IOException e2 = null;
    L3:
        if (r1 <= 0) goto L18;
        InputStream r2 = r5.getInputStream(r6);     // Catch: Throwable -> L12 IOException -> L15
        byte[] r7 = obtainBytesFromInputStream(r2);     // Catch: Throwable -> L8 IOException -> L10
    L6:
        closeQuietly(r2);
        return r7;
    L10:
        e = move-exception;
        InputStream r3 = r2;
        e2 = e;
    L17:
        closeQuietly(r3);
        r1 = r1 - 1;
    L8:
        th = th;
        r0 = r2;
    L13:
        closeQuietly(r0);
        throw th;
    L15:
        e2 = e;
        r3 = null;
    L12:
        th = th;
        goto L13
    L18:
        throw e2;
    }

    static File obtainEntryFileFromInputStream(InputStream r5, File r6) {
        File r0 = File.createTempFile("tmp-", r6.getName(), r6.getParentFile());
        Monitor.get().logInfo("Extracting " + r0.getPath());
        FileOutputStream r1 = new FileOutputStream(r0);
        byte[] r2 = new byte[8192];     // Catch: Throwable -> L17
    L4:
        int r3 = r5.read(r2);     // Catch: Throwable -> L17
        if (r3 == (-1)) goto L8;
        r1.write(r2, 0, r3);     // Catch: Throwable -> L17
        goto L4
    L8:
        if (r0.setReadOnly() == false) goto L16;
        Monitor.get().logInfo("Renaming to " + r6.getPath());     // Catch: Throwable -> L17
        if (r0.renameTo(r6) == false) goto L14;
        closeQuietly(r1);
        r0.delete();
        return r6;
    L14:
        throw new IOException("Failed to rename \"" + r0.getAbsolutePath() + "\" to \"" + r6.getAbsolutePath() + "\"");     // Catch: Throwable -> L17
    L16:
        throw new IOException("Failed to mark readonly \"" + r0.getAbsolutePath() + "\" (tmp of \"" + r6.getAbsolutePath() + "\")");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        closeQuietly(r1);
        r0.delete();
        throw th;
    }

    static File obtainEntryFileInZip(ZipFile r3, ZipEntry r4, File r5) {
        IOException r0 = null;
        int r1 = 3;
    L3:
        if (r1 <= 0) goto L13;
        InputStream r2 = r3.getInputStream(r4);
        File r6 = obtainEntryFileFromInputStream(r2, r5);     // Catch: Throwable -> L8 IOException -> L11
    L6:
        closeQuietly(r2);
        return r6;
    L11:
        e = move-exception;
        closeQuietly(r2);
        r1 = r1 - 1;
        r0 = e;
    L8:
        th = move-exception;
        closeQuietly(r2);
        throw th;
    L13:
        throw r0;
    }

    static void obtainZipForEntryFileInZip(ZipFile r7, ZipEntry r8, File r9) {
        IOException r0 = null;
        int r1 = 3;
    L3:
        if (r1 <= 0) goto L29;
        InputStream r2 = r7.getInputStream(r8);
        File r3 = File.createTempFile("tmp-", Constants.ZIP_SUFFIX, r9.getParentFile());
        ZipOutputStream r4 = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(r3)));     // Catch: Throwable -> L24 IOException -> L27
        ZipEntry r5 = new ZipEntry("classes.dex");     // Catch: Throwable -> L21
        r5.setTime(r8.getTime());     // Catch: Throwable -> L21
        r4.putNextEntry(r5);     // Catch: Throwable -> L21
        byte[] r6 = new byte[8192];     // Catch: Throwable -> L21
    L7:
        int r10 = r2.read(r6);     // Catch: Throwable -> L21
        if (r10 == (-1)) goto L10;
        r4.write(r6, 0, r10);     // Catch: Throwable -> L21
        goto L7
    L10:
        r4.closeEntry();     // Catch: Throwable -> L21
    L11:
        r4.close();     // Catch: Throwable -> L24 IOException -> L27
        if (r3.setReadOnly() == false) goto L20;
        Monitor.get().logInfo("Renaming to " + r9.getPath());     // Catch: Throwable -> L24 IOException -> L27
        if (r3.renameTo(r9) == false) goto L18;
        closeQuietly(r2);
        r3.delete();
        return;
    L18:
        throw new IOException("Failed to rename \"" + r3.getAbsolutePath() + "\" to \"" + r9.getAbsolutePath() + "\"");     // Catch: Throwable -> L24 IOException -> L27
    L20:
        throw new IOException("Failed to mark readonly \"" + r3.getAbsolutePath() + "\" (tmp of \"" + r9.getAbsolutePath() + "\")");     // Catch: Throwable -> L24 IOException -> L27
    L21:
        th = move-exception;
        r4.close();     // Catch: Throwable -> L24 IOException -> L27
        throw th;     // Catch: Throwable -> L24 IOException -> L27
    L27:
        e = move-exception;
        closeQuietly(r2);
        r3.delete();
        r1 = r1 - 1;
        r0 = e;
    L24:
        th = move-exception;
        closeQuietly(r2);
        r3.delete();
        throw th;
    L29:
        if (r0 != null) goto L31;
        return;
    L31:
        throw r0;
    }

    static boolean storeBytesToFile(byte[] r2, File r3) {
        FileOutputStream r0 = null;
        FileOutputStream r1 = new FileOutputStream(r3);     // Catch: Throwable -> L11 IOException -> L13
        r1.write(r2);     // Catch: Throwable -> L7 IOException -> L9
        closeQuietly(r1);
        return true;
    L9:
        e = e;
        r0 = r1;
    L14:
        Monitor.get().logError("fail to store bytes to file", e);     // Catch: Throwable -> L11
        closeQuietly(r0);
        return false;
    L7:
        th = th;
        r0 = r1;
    L17:
        closeQuietly(r0);
        throw th;
    L11:
        th = th;
    L13:
        e = e;
        goto L14
    }
}
