package com.bytedance.android.standard.tools.file;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.bytedance.android.standard.tools.logging.Logger;
import com.bytedance.android.standard.tools.string.StringUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class FileUtils {
    private static final byte[] GIF87A = null;
    private static final byte[] GIF89A = null;
    private static final byte[] JPEG = null;
    private static final byte[] PNG = null;
    private static final String TAG = "FileUtils";

    public static final enum ImageType extends Enum<ImageType> {
        private static final /* synthetic */ ImageType[] $VALUES = null;
        public static final ImageType GIF = null;
        public static final ImageType JPG = null;
        public static final ImageType PNG = null;
        public static final ImageType UNKNOWN = null;

        static {
            ImageType r0 = new ImageType(NetworkStackConstant.UNKNOWN_TYPE, 0);
            UNKNOWN = r0;
            ImageType r1 = new ImageType("JPG", 1);
            JPG = r1;
            ImageType r2 = new ImageType("PNG", 2);
            PNG = r2;
            ImageType r3 = new ImageType("GIF", 3);
            GIF = r3;
            $VALUES = new ImageType[]{r0, r1, r2, r3};
        }

        private ImageType(String r1, int r2) {
            super(r1, r2);
        }

        public static ImageType valueOf(String r1) {
            return (ImageType) Enum.valueOf(ImageType.class, r1);
        }

        public static ImageType[] values() {
            return (ImageType[]) $VALUES.clone();
        }
    }

    static {
        GIF87A = new byte[]{71, 73, 70, 56, 55, 97};
        GIF89A = new byte[]{71, 73, 70, 56, 57, 97};
        JPEG = new byte[]{-1, -40, -1};
        PNG = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
    }

    private FileUtils() {
    }

    public static boolean checkFile(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L8;
        return false;
    L8:
        return new File(r2).exists();
    L7:
        return false;
    }

    private static boolean checkSignature(byte[] r4, byte[] r5) {
        if (r4 == null) goto L17;
        if (r5 == null) goto L18;
        int r1 = 0;
    L8:
        if (r1 >= r5.length) goto L13;
        if (r4[r1] != r5[r1]) goto L19;
        r1 = r1 + 1;
        goto L8
    L19:
        return false;
    L13:
        return true;
    L18:
        return false;
    L17:
        return false;
    }

    public static void chmod(String r6, int r7) {
        Class<?> r2 = Class.forName("android.os.FileUtils");     // Catch: NoSuchMethodException -> L10 InvocationTargetException -> L11 IllegalAccessException -> L12 ClassNotFoundException -> L13 Throwable -> L15
        Class r5 = Integer.TYPE;     // Catch: NoSuchMethodException -> L10 InvocationTargetException -> L11 IllegalAccessException -> L12 ClassNotFoundException -> L13 Throwable -> L15
        Method r3 = r2.getMethod("setPermissions", new Class[]{String.class, r5, r5, r5});     // Catch: NoSuchMethodException -> L10 InvocationTargetException -> L11 IllegalAccessException -> L12 ClassNotFoundException -> L13 Throwable -> L15
        if (r3 != null) goto L6;
        return;
    L6:
        int r8 = ((Integer) r3.invoke(null, new Object[]{r6, Integer.valueOf(r7), -1, -1})).intValue();     // Catch: NoSuchMethodException -> L10 InvocationTargetException -> L11 IllegalAccessException -> L12 ClassNotFoundException -> L13 Throwable -> L15
        if (r8 == 0) goto L18;
        Logger.d("NetHackDbg", "android.os.FileUtils.setPermissions() returned " + r8 + " for '" + r6 + "', probably didn't work.");     // Catch: NoSuchMethodException -> L10 InvocationTargetException -> L11 IllegalAccessException -> L12 ClassNotFoundException -> L13 Throwable -> L15
        goto L23
    L22:
        return;
    L18:
        return;
    L13:
        Logger.d("NetHackDbg", "android.os.FileUtils.setPermissions() failed - ClassNotFoundException.");
        return;
    L12:
        Logger.d("NetHackDbg", "android.os.FileUtils.setPermissions() failed - IllegalAccessException.");
        return;
    L10:
        Logger.d("NetHackDbg", "android.os.FileUtils.setPermissions() failed - NoSuchMethodException.");
        return;
    L11:
        Logger.d("NetHackDbg", "android.os.FileUtils.setPermissions() failed - InvocationTargetException.");
        return;
    }

    public static void clearDir(String r3) {
        File r0 = new File(r3);
        if (r0.exists() == true) goto L5;
        return;
    L5:
        File[] r4 = r0.listFiles();
        int r1 = r4.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L14;
        if (r4[r2].isDirectory() == false) goto L11;
        removeDir(r4[r2].getAbsolutePath());
    L13:
        r2 = r2 + 1;
        goto L6
    L11:
        if (r4[r2].isFile() == false) goto L13;
        r4[r2].delete();
        goto L13
    }

    public static ByteArrayOutputStream cloneBuffer(InputStream r4) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        byte[] r1 = new byte[1024];
    L12:
        int r2 = r4.read(r1);     // Catch: IOException -> L6
        if (r2 <= (-1)) goto L8;
        r0.write(r1, 0, r2);     // Catch: IOException -> L6
        goto L12
    L8:
        r0.flush();     // Catch: IOException -> L6
    L11:
        return r0;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public static boolean copyFile(String r3, String r4, String r5) {
        if (StringUtils.isEmpty(r3) == false) goto L5;
    L37:
        return false;
    L5:
        if (StringUtils.isEmpty(r4) == true) goto L37;
        if (StringUtils.isEmpty(r5) == true) goto L37;
        FileInputStream r0 = null;
        FileInputStream r2 = new FileInputStream(r3);     // Catch: Throwable -> L21 Exception -> L23
        boolean r6 = saveInputStream(r2, r4, r5);     // Catch: Throwable -> L17 Exception -> L19
        r2.close();     // Catch: Exception -> L14
    L16:
        return r6;
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    L19:
        e = e;
        r0 = r2;
    L24:
        e.printStackTrace();     // Catch: Throwable -> L21
        if (r0 != null) goto L40;
    L30:
        return false;
    L40:
        r0.close();     // Catch: Exception -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
    L17:
        th = th;
        r0 = r2;
    L31:
        if (r0 != null) goto L42;
    L36:
        throw th;
    L42:
        r0.close();     // Catch: Exception -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
    L23:
        e = e;
    L21:
        th = th;
        goto L31
    }

    public static boolean copyWithNio(String r1, String r2) {
        return copyWithNio(new File(r1), new File(r2));
    }

    public static void deleteFile(File r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.exists() == true) goto L6;
        return;
    L6:
        if (r1.isFile() == false) goto L12;
        r1.delete();
        return;
    }

    public static void deleteFileOrFolder(File r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.exists() == true) goto L7;
        return;
    L7:
        if (r1.isFile() == false) goto L10;
        deleteFile(r1);
        return;
    L10:
        if (r1.isDirectory() == false) goto L15;
        deleteFolder(r1);
        return;
    }

    public static void deleteFolder(File r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.exists() == true) goto L6;
        return;
    L6:
        if (r4.isDirectory() == false) goto L30;
        File[] r5 = r4.listFiles();
        if (r5 == null) goto L29;
        int r0 = r5.length;
        int r1 = 0;
    L11:
        if (r1 >= r0) goto L31;
        File r2 = r5[r1];
        if (r2 == null) goto L21;
        if (r2.isDirectory() == false) goto L19;
        deleteFolder(r2);
        r2.delete();
        goto L21
    L19:
        if (r2.isFile() == false) goto L21;
        r2.delete();
    L21:
        r1 = r1 + 1;
        goto L11
    L31:
        return;
    L29:
        return;
    }

    public static boolean deleteInnerFile(File r6, Context r7) {
        boolean r0 = false;
        if (r6 == null) goto L40;
        if (r7 == null) goto L40;
        if (r6.exists() == false) goto L40;
        String r1 = r6.getAbsolutePath();
        File r2 = r7.getExternalFilesDir(null);
        File r3 = r7.getExternalCacheDir();
        File r8 = r7.getCacheDir();
        String r4 = "";
        if (r2 == null) goto L11;
        String r5 = r2.getAbsolutePath();
    L12:
        if (r3 == null) goto L14;
        String r9 = r3.getAbsolutePath();
    L15:
        if (r8 == null) goto L18;
        r4 = r8.getAbsolutePath();
    L18:
        if (TextUtils.isEmpty(r1) == false) goto L21;
        return false;
    L21:
        if (TextUtils.isEmpty(r5) == true) goto L26;
        if (r1.startsWith(r5) == false) goto L26;
    L24:
        r0 = true;
    L35:
        if (r0 == false) goto L40;
        deleteFile(r6);     // Catch: Exception -> L38
    L38:
        e = move-exception;
        Logger.w("FileUtils.deleteInnerFile", e.toString());
    L26:
        if (TextUtils.isEmpty(r9) == true) goto L31;
        if (r1.startsWith(r9) == true) goto L24;
    L31:
        if (TextUtils.isEmpty(r4) == true) goto L35;
        if (r1.startsWith(r4) == false) goto L35;
    L14:
        r9 = "";
        goto L15
    L11:
        r5 = "";
    L40:
        return r0;
    }

    public static void ensureDirExists(File r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.exists() == true) goto L8;
        r1.mkdirs();
        return;
    }

    public static boolean exists(String r1) {
        if (StringUtils.isEmpty(r1) == false) goto L5;
        return false;
    L5:
        return new File(r1).exists();
    }

    public static byte[] getByteArray(String r5) {
        File r0 = new File(r5);
        if (r0.exists() == true) goto L19;
        return null;
    L19:
        FileInputStream r6 = new FileInputStream(r0);     // Catch: Exception -> L8
        int r1 = (int) r0.length();     // Catch: Exception -> L8
        byte[] r2 = new byte[r1];     // Catch: Exception -> L8
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L10;
        r2[r3] = (byte) r6.read();     // Catch: Exception -> L8
        r3 = r3 + 1;     // Catch: Exception -> L8
        goto L6
    L10:
        r6.close();     // Catch: Exception -> L8
        return r2;
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L14
        return null;
    L14:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String getCacheDirPath(Context r3) {
        if (r3 == null) goto L17;
        String r1 = null;
        if (r3.getCacheDir() == null) goto L8;
        r1 = r3.getCacheDir().getPath();     // Catch: Throwable -> L18
    L19:
        goto L12
    L8:
        File r4 = r3.getDir("/data/data/" + r3.getPackageName() + "/cache/", 0);     // Catch: Throwable -> L18
        if (r4 == null) goto L19;
        r1 = r4.getPath();     // Catch: Throwable -> L18
    L12:
        if (StringUtils.isEmpty(r1) == true) goto L15;
        return r1;
    L15:
        throw new NullPointerException("Cannot Create Cache Dir");
    L17:
        throw new NullPointerException("Context is NUll");
    }

    public static long getDirSize(String r6) {
        long r1 = 0;
        if (isSdcardWritable() == true) goto L5;
    L21:
        return r1;
    L5:
        if (TextUtils.isEmpty(r6) == true) goto L21;
        File r0 = new File(r6);
        if (r0.exists() == false) goto L21;
        if (r0.isDirectory() == false) goto L21;
        File[] r7 = r0.listFiles();
        if (r7 != null) goto L15;
        return 0;
    L15:
        int r2 = r7.length;
        int r3 = 0;
    L16:
        if (r3 >= r2) goto L21;
        File r4 = r7[r3];
        if (r4.isFile() == false) goto L20;
        r1 = r4.length() + r1;
    L20:
        r3 = r3 + 1;
        goto L16
    }

    public static long getDirectorySize(File r6, boolean r7) {
        long r0 = 0;
        if (r6.exists() == false) goto L6;
    L8:
        File[] r8 = r6.listFiles();     // Catch: Throwable -> L20
        int r2 = r8.length;     // Catch: Throwable -> L20
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L19;
        File r4 = r8[r3];     // Catch: Throwable -> L20
        if (r4.isDirectory() == false) goto L15;
        long r5 = getDirectorySize(r4, r7);     // Catch: Throwable -> L20
    L13:
        r0 = r0 + r5;     // Catch: Throwable -> L20
    L18:
        r3 = r3 + 1;
        goto L9
    L15:
        if (r4.isFile() == false) goto L18;
        r5 = r4.length();     // Catch: Throwable -> L20
        goto L13
    L6:
        if (r6.isDirectory() == false) goto L8;
        return 0;
    L19:
        return r0;
    }

    public static String getExtension(String r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        int r0 = r2.lastIndexOf(LibrarianImpl.Constants.DOT);
        if (r0 != (-1)) goto L10;
        return "";
    L10:
        return r2.substring(r0 + 1);
    }

    public static String getFileNameWithoutExtension(String r2) {
        String r3 = new File(r2).getName();
        if (StringUtils.isEmpty(r3) == true) goto L8;
        int r0 = r3.lastIndexOf(LibrarianImpl.Constants.DOT);
        if ((-1) != r0) goto L7;
        return "";
    L7:
        return r3.substring(0, r0);
    L8:
        return "";
    }

    public static long getFileOrFolderSize(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return 0;
    L5:
        File r0 = new File(r3);
        if (r0.exists() == true) goto L9;
        return 0;
    L9:
        if (r0.isDirectory() == false) goto L12;
        return getFolderSize(r0);
    L12:
        if (r0.isFile() == true) goto L14;
        return 0;
    L14:
        return getFileSize(r0);
    }

    public static long getFileSize(File r4) {
        long r0 = 0;
        if (r4 != null) goto L5;
    L41:
        return 0;
    L5:
        if (r4.exists() == false) goto L41;
        FileInputStream r2 = null;
        FileInputStream r3 = new FileInputStream(r4);     // Catch: Throwable -> L21 IOException -> L23 FileNotFoundException -> L25
    L51:
        r0 = r3.available();     // Catch: Throwable -> L15 IOException -> L17 FileNotFoundException -> L19
        r3.close();     // Catch: IOException -> L13
    L42:
    L47:
        return r0;
    L19:
        e = e;
        r2 = r3;
    L31:
        e.printStackTrace();     // Catch: Throwable -> L21
        if (r2 == null) goto L47;
        r2.close();     // Catch: IOException -> L13
    L17:
        e = e;
        r2 = r3;
    L27:
        e.printStackTrace();     // Catch: Throwable -> L21
        if (r2 == null) goto L47;
        r2.close();     // Catch: IOException -> L13
    L15:
        th = th;
        r2 = r3;
    L35:
        if (r2 != null) goto L45;
    L40:
        throw th;
    L45:
        r2.close();     // Catch: IOException -> L38
    L38:
        e = move-exception;
        e.printStackTrace();
    L13:
        e = move-exception;
        e.printStackTrace();
    L25:
        e = e;
    L23:
        e = e;
    L21:
        th = th;
        goto L35
    }

    public static String getFilesDirPath(Context r3) {
        if (r3 == null) goto L17;
        String r1 = null;
        if (r3.getFilesDir() == null) goto L8;
        r1 = r3.getFilesDir().getPath();     // Catch: Throwable -> L18
    L19:
        goto L12
    L8:
        File r4 = r3.getDir("/data/data/" + r3.getPackageName() + "/files/", 0);     // Catch: Throwable -> L18
        if (r4 == null) goto L19;
        r1 = r4.getPath();     // Catch: Throwable -> L18
    L12:
        if (StringUtils.isEmpty(r1) == true) goto L15;
        return r1;
    L15:
        throw new NullPointerException("Cannot Create Files Dir");
    L17:
        throw new NullPointerException("Context is NUll");
    }

    public static long getFolderSize(File r6) {
        long r0 = 0;
        if (r6 != null) goto L5;
    L25:
        return r0;
    L5:
        if (r6.exists() == false) goto L7;
    L9:
        File[] r7 = r6.listFiles();
        if (r7 != null) goto L12;
        return 0;
    L12:
        int r2 = r7.length;
        int r3 = 0;
    L13:
        if (r3 >= r2) goto L25;
        File r4 = r7[r3];
        if (r4 == null) goto L24;
        if (r4.isDirectory() == false) goto L22;
        long r5 = getFolderSize(r4);
    L20:
        r0 = r5 + r0;
        goto L24
    L22:
        if (r4.isFile() == false) goto L24;
        r5 = getFileSize(r4);
    L24:
        r3 = r3 + 1;
        goto L13
    L7:
        if (r6.isDirectory() == true) goto L9;
        goto L9
    }

    public static ImageType getImageType(String r1) {
        if (StringUtils.isEmpty(r1) == true) goto L7;
        return getImageType(new File(r1));
    L7:
        return ImageType.UNKNOWN;
    }

    public static InputStream getInputStream(String r2) {
        File r0 = new File(r2);
        if (r0.exists() == true) goto L15;
        return null;
    L15:
        return new FileInputStream(r0);
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L10
        return null;
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static long getSDAvailableSize() {
        if (isSdcardAvailable() == true) goto L7;
        return 0;
    L7:
        return new StatFs(Environment.getExternalStorageDirectory().getPath()).getAvailableBytes();
    }

    public static long getTotalStorageSize() {
        if (isSdcardAvailable() == true) goto L7;
        return 0;
    L7:
        return new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getTotalBytes();
    }

    public static boolean isDirectoryExist(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return false;
    L5:
        File r0 = new File(r2);
        if (r0.isDirectory() == true) goto L8;
        return false;
    L8:
        if (r0.exists() == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean isDirectoryNotEmpty(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return false;
    L5:
        File r0 = new File(r2);
        if (r0.isDirectory() == true) goto L8;
        return false;
    L8:
        if (r0.exists() == false) goto L16;
        String[] r3 = r0.list();
        if (r3 != null) goto L12;
        return false;
    L12:
        if (r3.length <= 0) goto L18;
        return true;
    L18:
        return false;
    L16:
        return false;
    }

    public static boolean isExternalStorageReadable() {
        String r0 = Environment.getExternalStorageState();
        if ("mounted".equals(r0) == false) goto L5;
        return true;
    L5:
        if ("mounted_ro".equals(r0) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public static boolean isExternalStorageWritable() {
        if ("mounted".equals(Environment.getExternalStorageState()) == false) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean isGif(File r1) {
        if (getImageType(r1) != ImageType.GIF) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isSdcardAvailable() {
        String r1 = Environment.getExternalStorageState();     // Catch: Exception -> L9
        if ("mounted".equals(r1) == true) goto L7;
        if ("mounted_ro".equals(r1) == true) goto L7;
        return false;
    L7:
        return true;
    L13:
        return false;
    }

    public static boolean isSdcardStorageReadable() {
        String r0 = Environment.getExternalStorageState();
        if ("mounted".equals(r0) == false) goto L5;
        return true;
    L5:
        if ("mounted_ro".equals(r0) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public static boolean isSdcardWritable() {
        return "mounted".equals(Environment.getExternalStorageState());
    L4:
        return false;
    }

    public static boolean makeSureFileExist(File r2) {
        if (makesureParentDirExist(r2) == true) goto L5;
        return false;
    L5:
        if (r2.isFile() == false) goto L11;
        return r2.createNewFile();
    L8:
        e = move-exception;
        Logger.e(TAG, "catch", e);
        return false;
    L11:
        if (r2.isDirectory() == true) goto L13;
        return false;
    L13:
        return r2.mkdir();
    }

    private static boolean makesureParentDirExist(File r1) {
        File r2 = r1.getParentFile();
        if (r2 != null) goto L5;
        return true;
    L5:
        if (r2.exists() == false) goto L8;
        return true;
    L8:
        return mkdirs(r2);
    }

    public static boolean mkdirs(File r0) {
        if (r0 != null) goto L6;
        return false;
    L6:
        return r0.mkdirs();
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

    public static boolean removeFile(String r2) {
        if (isSdcardWritable() == true) goto L5;
        return false;
    L5:
        File r0 = new File(r2);
        if (r0.exists() == true) goto L8;
        return false;
    L8:
        if (r0.canWrite() == true) goto L10;
        return false;
    L10:
        if (r0.delete() == false) goto L15;
        return true;
    L15:
        return false;
    }

    public static boolean renameFile(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L16;
        File r0 = new File(r2);
        File r4 = new File(r3);
        if (r0.exists() == true) goto L10;
        return false;
    L10:
        if (r0.renameTo(r4) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    private static void safelyClose(Closeable r0) {
        if (r0 == null) goto L10;
        r0.close();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static boolean saveInputStream(InputStream r4, String r5, String r6) {
        if (r4 != null) goto L5;
        return false;
    L5:
        FileOutputStream r1 = null;
        File r2 = new File(r5);     // Catch: Throwable -> L15 Exception -> L17
        if (r2.exists() == false) goto L9;
    L19:
        FileOutputStream r7 = new FileOutputStream(new File(r2, r6));     // Catch: Throwable -> L15 Exception -> L17
        byte[] r8 = new byte[1024];     // Catch: Throwable -> L25 Exception -> L27
    L22:
        int r3 = r4.read(r8);     // Catch: Throwable -> L25 Exception -> L27
        if (r3 == (-1)) goto L29;
        r7.write(r8, 0, r3);     // Catch: Throwable -> L25 Exception -> L27
        goto L22
    L29:
        r7.flush();     // Catch: Throwable -> L25 Exception -> L27
        r7.close();     // Catch: Throwable -> L25 Exception -> L27
        r4.close();     // Catch: Throwable -> L15 Exception -> L17
        r4.close();     // Catch: Exception -> L33
        return true;
    L33:
        e = move-exception;
        e.printStackTrace();
        return true;
    L27:
        e = e;
        r1 = r7;
    L37:
        Logger.d(TAG, "save inputstream error: " + e);     // Catch: Throwable -> L15
        if (r1 == null) goto L62;
        r1.close();     // Catch: Exception -> L53
    L62:
        r4.close();     // Catch: Exception -> L42
    L44:
        return false;
    L42:
        e = move-exception;
        e.printStackTrace();
    L25:
        th = th;
        r1 = r7;
    L45:
        if (r1 == null) goto L64;
        r1.close();     // Catch: Exception -> L52
    L64:
        r4.close();     // Catch: Exception -> L49
        throw th;
    L49:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L9:
        if (r2.mkdirs() == true) goto L19;
        r4.close();     // Catch: Exception -> L12
    L14:
        return false;
    L12:
        e = move-exception;
        e.printStackTrace();
    L17:
        e = e;
    L15:
        th = th;
        goto L45
    }

    public static boolean copyWithNio(File r9, File r10) {
        FileChannel r0 = null;
        FileChannel r11 = new FileInputStream(r9).getChannel();     // Catch: Throwable -> L10 Exception -> L12
        r0 = new FileOutputStream(r10).getChannel();     // Catch: Throwable -> L7 Exception -> L9
        r0.transferFrom(r11, 0, r11.size());     // Catch: Throwable -> L7 Exception -> L9
        boolean r12 = r10.exists();     // Catch: Throwable -> L7 Exception -> L9
        safelyClose(r11);
        safelyClose(r0);
        return r12;
    L9:
        FileChannel r8 = r0;
        r0 = r11;
        FileChannel r13 = r8;
    L15:
        safelyClose(r0);
        safelyClose(r13);
        return false;
    L7:
        th = th;
        FileChannel r14 = r0;
        r0 = r11;
        FileChannel r15 = r14;
    L13:
        safelyClose(r0);
        safelyClose(r15);
        throw th;
    L12:
        r13 = null;
    L10:
        th = th;
        r15 = null;
        goto L13
    }

    public static ImageType getImageType(File r3) {
        if (r3 == null) goto L58;
        if (r3.exists() == false) goto L58;
        ImageType r0 = ImageType.UNKNOWN;
        FileInputStream r1 = null;
        FileInputStream r2 = new FileInputStream(r3);     // Catch: Throwable -> L44 Exception -> L46
        byte[] r4 = new byte[8];     // Catch: Throwable -> L22 Exception -> L24
        r2.read(r4);     // Catch: Throwable -> L22 Exception -> L24
        if (checkSignature(r4, GIF89A) == false) goto L12;
    L38:
        ImageType r5 = ImageType.GIF;     // Catch: Throwable -> L22 Exception -> L24
        r2.close();     // Catch: Exception -> L41
    L43:
        return r5;
    L41:
        e = move-exception;
        e.printStackTrace();
        goto L43
    L12:
        if (checkSignature(r4, GIF87A) == true) goto L38;
        if (checkSignature(r4, JPEG) == false) goto L27;
        ImageType r6 = ImageType.JPG;     // Catch: Throwable -> L22 Exception -> L24
        r2.close();     // Catch: Exception -> L19
    L21:
        return r6;
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L21
    L27:
        if (checkSignature(r4, PNG) == false) goto L34;
        ImageType r7 = ImageType.PNG;     // Catch: Throwable -> L22 Exception -> L24
        r2.close();     // Catch: Exception -> L31
    L33:
        return r7;
    L31:
        e = move-exception;
        e.printStackTrace();
        goto L33
    L34:
        r2.close();     // Catch: Exception -> L36
    L63:
    L50:
        return r0;
    L24:
        e = e;
        r1 = r2;
    L47:
        e.printStackTrace();     // Catch: Throwable -> L44
        if (r1 == null) goto L50;
        r1.close();     // Catch: Exception -> L36
    L22:
        th = th;
        r1 = r2;
    L51:
        if (r1 != null) goto L59;
    L56:
        throw th;
    L59:
        r1.close();     // Catch: Exception -> L54
    L54:
        e = move-exception;
        e.printStackTrace();
    L46:
        e = e;
    L44:
        th = th;
    L36:
        e = move-exception;
        e.printStackTrace();
    L58:
        return ImageType.UNKNOWN;
    }

    public static void clearDir(String r3, Set<String> r4) {
        File r0 = new File(r3);
        if (r0.exists() == true) goto L5;
        return;
    L5:
        File[] r5 = r0.listFiles();
        int r1 = r5.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L18;
        if (r5[r2].isDirectory() == false) goto L11;
        removeDir(r5[r2].getAbsolutePath(), r4);
    L17:
        r2 = r2 + 1;
        goto L6
    L11:
        if (r5[r2].isFile() == false) goto L17;
        String r6 = r5[r2].getName();
        if (r4 != null) goto L15;
    L16:
        r5[r2].delete();
        goto L17
    L15:
        if (r4.contains(r6) == true) goto L17;
    }

    public static void removeDir(String r3, Set<String> r4) {
        File r0 = new File(r3);
        if (r0.exists() == true) goto L5;
        return;
    L5:
        if (r0.isDirectory() == false) goto L22;
        File[] r5 = r0.listFiles();
        int r1 = r5.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L23;
        if (r5[r2].isDirectory() == false) goto L11;
        removeDir(r5[r2].getAbsolutePath(), r4);
    L16:
        r2 = r2 + 1;
        goto L7
    L11:
        String r6 = r5[r2].getName();
        if (r4 != null) goto L14;
    L15:
        r5[r2].delete();
        goto L16
    L14:
        if (r4.contains(r6) == true) goto L16;
    L23:
        return;
    }
}
