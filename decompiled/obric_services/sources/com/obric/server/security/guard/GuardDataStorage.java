package com.obric.server.security.guard;

import android.util.Log;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class GuardDataStorage {
    private static final int DEFAULT_PERMISSIONS_COUNT = 5;
    private static final String MIN_PER_POLICY_FILE = "min_per_policy.json";
    private static final String PATH = "/data/misc/security/guard/";
    private static final String TAG = "GuardDataStorage";

    public GuardDataStorage() {
        File directory = new File(PATH);     // Catch: Exception -> L10
        if (directory.exists() == false) goto L6;
    L13:
        return;
    L6:
        if (directory.mkdirs() == false) goto L8;
        Log.e(TAG, "create directory success.");     // Catch: Exception -> L10
        goto L13
    L8:
        Log.e(TAG, "create directory failed.");     // Catch: Exception -> L10
    L10:
        e = move-exception;
        Log.e(TAG, "GuardDataStorage init failed, " + e.getMessage());
    }

    public void writeMinPolicy(String data) {
        BufferedWriter writer = null;
        File file = new File("/data/misc/security/guard/min_per_policy.json");     // Catch: Throwable -> L12 Exception -> L14
        if (file.exists() == true) goto L6;
        file.createNewFile();     // Catch: Throwable -> L12 Exception -> L14
        Log.e(TAG, "file is not exist.");     // Catch: Throwable -> L12 Exception -> L14
    L6:
        writer = new BufferedWriter(new FileWriter("/data/misc/security/guard/min_per_policy.json"));     // Catch: Throwable -> L12 Exception -> L14
        writer.write(data);     // Catch: Throwable -> L12 Exception -> L14
        writer.close();     // Catch: Exception -> L9
        return;
    L9:
        e = e;
        StringBuilder r5 = new StringBuilder();
    L11:
        Log.e(TAG, r5.append("writeRecord close write occur exception, ").append(e.getMessage()).toString());
        return;
    L14:
        e = move-exception;
        Log.e(TAG, "writeRecord occur exception, " + e.getMessage());     // Catch: Throwable -> L12
        if (writer != null) goto L30;
        return;
    L30:
        writer.close();     // Catch: Exception -> L19
        return;
    L19:
        e = e;
        r5 = new StringBuilder();
    L12:
        th = move-exception;
        if (writer != null) goto L32;
    L27:
        throw th;
    L32:
        writer.close();     // Catch: Exception -> L25
    L25:
        e = move-exception;
        Log.e(TAG, "writeRecord close write occur exception, " + e.getMessage());
        goto L27
    }

    private static String validateFileName(String fileName) {
        if (fileName != null) goto L5;
    L11:
        return null;
    L5:
        if (fileName.isEmpty() == true) goto L11;
        if (fileName.contains("..") == false) goto L10;
        return null;
    L10:
        return fileName;
    }

    public static void writePolicy(String fileName, String data) {
        String validFileName = validateFileName(fileName);
        if (validFileName != null) goto L6;
        Log.e(TAG, "非法文件名: " + fileName);
        return;
    L6:
        String fileName2 = PATH + fileName;
        BufferedWriter writer = null;
        File file = new File(fileName2);     // Catch: Throwable -> L19 Exception -> L21
        if (file.exists() == false) goto L10;
    L13:
        writer = new BufferedWriter(new FileWriter(fileName2));     // Catch: Throwable -> L19 Exception -> L21
        writer.write(data);     // Catch: Throwable -> L19 Exception -> L21
    L42:
        writer.close();     // Catch: Exception -> L16
        return;
    L16:
        e = e;
        StringBuilder r5 = new StringBuilder();
    L18:
        Log.e(TAG, r5.append("writeRecord close write occur exception, ").append(e.getMessage()).toString());
        return;
    L10:
        if (file.createNewFile() == false) goto L12;
        setFIlePermission(file);     // Catch: Throwable -> L19 Exception -> L21
    L12:
        Log.e(TAG, "file is not exist.");     // Catch: Throwable -> L19 Exception -> L21
    L21:
        e = move-exception;
        Log.e(TAG, "writeRecord occur exception, " + e.getMessage());     // Catch: Throwable -> L19
        if (writer != null) goto L35;
        return;
    L35:
        writer.close();     // Catch: Exception -> L26
        return;
    L26:
        e = e;
        r5 = new StringBuilder();
    L19:
        th = move-exception;
        if (writer != null) goto L37;
    L34:
        throw th;
    L37:
        writer.close();     // Catch: Exception -> L32
    L32:
        e = move-exception;
        Log.e(TAG, "writeRecord close write occur exception, " + e.getMessage());
        goto L34
    }

    public static String getPolicy(String fileName) {
        String validFileName = validateFileName(fileName);
        if (validFileName != null) goto L6;
        Log.e(TAG, "非法文件名: " + fileName);
        return null;
    L6:
        String data = null;
        BufferedReader reader = null;
        File file = new File(PATH + fileName);     // Catch: Throwable -> L26 Exception -> L28
        if (file.exists() == true) goto L15;
        if (0 != 0) goto L43;
    L14:
        return null;
    L43:
        reader.close();     // Catch: Exception -> L12
    L12:
        e = move-exception;
        Log.e(TAG, "readRecord close read occur exception, " + e.getMessage());
        goto L14
    L15:
        reader = new BufferedReader(new FileReader(file));     // Catch: Throwable -> L26 Exception -> L28
        StringBuilder sb = new StringBuilder();     // Catch: Throwable -> L26 Exception -> L28
    L16:
        String line = reader.readLine();     // Catch: Throwable -> L26 Exception -> L28
        if (line == null) goto L19;
        sb.append(line);     // Catch: Throwable -> L26 Exception -> L28
        goto L16
    L19:
        data = sb.toString();     // Catch: Throwable -> L26 Exception -> L28
        reader.close();     // Catch: Exception -> L23
    L35:
        return data;
    L23:
        e = e;
        StringBuilder r6 = new StringBuilder();
    L25:
        Log.e(TAG, r6.append("readRecord close read occur exception, ").append(e.getMessage()).toString());
        goto L35
    L26:
        th = move-exception;
        if (reader != null) goto L49;
    L41:
        throw th;
    L49:
        reader.close();     // Catch: Exception -> L39
    L39:
        e = move-exception;
        Log.e(TAG, "readRecord close read occur exception, " + e.getMessage());
    L28:
        e = move-exception;
        Log.e(TAG, "readRecord occur exception, " + e.getMessage());     // Catch: Throwable -> L26
        if (reader == null) goto L35;
        reader.close();     // Catch: Exception -> L33
    L33:
        e = e;
        r6 = new StringBuilder();
        goto L25
    }

    public String getMinPolicy() {
        File file = new File("/data/misc/security/guard/min_per_policy.json");
        if (file.exists() == true) goto L5;
        return null;
    L5:
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(file));     // Catch: Throwable -> L16 Exception -> L18
        StringBuilder sb = new StringBuilder();     // Catch: Throwable -> L16 Exception -> L18
    L7:
        String line = reader.readLine();     // Catch: Throwable -> L16 Exception -> L18
        if (line == null) goto L10;
        sb.append(line);     // Catch: Throwable -> L16 Exception -> L18
        goto L7
    L10:
        String r5 = sb.toString();     // Catch: Throwable -> L16 Exception -> L18
        reader.close();     // Catch: Exception -> L13
    L15:
        return r5;
    L13:
        e = move-exception;
        Log.e(TAG, "readRecord close read occur exception, " + e.getMessage());
        goto L15
    L16:
        th = move-exception;
        if (reader != null) goto L35;
    L31:
        throw th;
    L35:
        reader.close();     // Catch: Exception -> L29
    L29:
        e = move-exception;
        Log.e(TAG, "readRecord close read occur exception, " + e.getMessage());
    L18:
        e = move-exception;
        Log.e(TAG, "readRecord occur exception, " + e.getMessage());     // Catch: Throwable -> L16
        if (reader != null) goto L37;
    L25:
        return null;
    L37:
        reader.close();     // Catch: Exception -> L23
    L23:
        e = move-exception;
        Log.e(TAG, "readRecord close read occur exception, " + e.getMessage());
        goto L25
    }

    private static void setFIlePermission(File file) {
        Set<PosixFilePermission> perms = new HashSet(DEFAULT_PERMISSIONS_COUNT);
        perms.add(PosixFilePermission.OWNER_READ);
        perms.add(PosixFilePermission.OWNER_WRITE);
        perms.add(PosixFilePermission.OWNER_EXECUTE);
        perms.add(PosixFilePermission.GROUP_READ);
        perms.add(PosixFilePermission.OTHERS_READ);
        Path path = Paths.get(file.getCanonicalPath(), new String[0]);     // Catch: IOException -> L5
        Files.setPosixFilePermissions(path, perms);     // Catch: IOException -> L5
        return;
    L6:
        Log.e(TAG, "setFilePermission: IOException");
    }
}
