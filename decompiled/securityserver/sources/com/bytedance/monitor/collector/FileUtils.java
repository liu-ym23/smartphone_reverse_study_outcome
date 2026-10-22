package com.bytedance.monitor.collector;

import a.a;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.monitor.util.IoUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class FileUtils {
    private FileUtils() {
    }

    public static void copy(File r3, File r4) {
        if (r3 == null) goto L34;
        if (r4 == null) goto L45;
        FileInputStream r0 = null;
        r4.getParentFile().mkdirs();     // Catch: Throwable -> L24 Exception -> L26
        FileInputStream r1 = new FileInputStream(r3);     // Catch: Throwable -> L24 Exception -> L26
        FileOutputStream r5 = new FileOutputStream(r4);     // Catch: Throwable -> L20 Exception -> L22
    L41:
        byte[] r6 = new byte[8192];     // Catch: Throwable -> L14 Exception -> L16
    L10:
        int r2 = r1.read(r6);     // Catch: Throwable -> L14 Exception -> L16
        if (r2 <= 0) goto L18;
        r5.write(r6, 0, r2);     // Catch: Throwable -> L14 Exception -> L16
    L18:
        IoUtil.safeClose(r1);
    L19:
        IoUtil.safeClose(r5);
        return;
    L16:
        e = e;
    L17:
        r0 = r1;
    L35:
        e.printStackTrace();     // Catch: Throwable -> L31
        IoUtil.safeClose(r0);
    L31:
        th = th;
    L32:
        IoUtil.safeClose(r0);
        IoUtil.safeClose(r5);
        throw th;
    L14:
        th = th;
    L15:
        r0 = r1;
    L22:
        e = e;
        r5 = null;
    L20:
        th = th;
        r5 = null;
        goto L15
    L26:
        e = e;
        r5 = null;
    L24:
        th = th;
        r5 = null;
        goto L32
    L45:
        return;
    }

    public static boolean deleteFile(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return false;
    L7:
        return deleteFile(new File(r1));
    }

    public static boolean isEmpty(File r0) {
        String[] r1 = r0.list();
        if (r1 != null) goto L5;
    L8:
        return true;
    L5:
        if (r1.length == 0) goto L8;
        return false;
    }

    public static String readFile(String r4, String r5) {
        BufferedReader r1 = null;
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return null;
    L5:
        File r0 = new File(r4);
        StringBuilder r6 = new StringBuilder();
        BufferedReader r2 = new BufferedReader(new FileReader(r0));     // Catch: Throwable -> L17
    L22:
        String r3 = r2.readLine();     // Catch: Throwable -> L13
        if (r3 == null) goto L15;
        r6.append(r3);     // Catch: Throwable -> L13
        if (r5 == null) goto L22;
        r6.append(r5);     // Catch: Throwable -> L13
        goto L22
    L15:
        IoUtil.safeClose(r2);
        return r6.toString();
    L13:
        th = th;
        r1 = r2;
    L18:
        IoUtil.safeClose(r1);
        throw th;
    L17:
        th = th;
        goto L18
    }

    public static JSONArray readFileArray(String r4) {
        BufferedReader r1 = null;
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return null;
    L5:
        File r0 = new File(r4);
        JSONArray r5 = new JSONArray();
        BufferedReader r2 = new BufferedReader(new FileReader(r0));     // Catch: Throwable -> L15
    L18:
        String r3 = r2.readLine();     // Catch: Throwable -> L11
        if (r3 == null) goto L13;
        r5.put(r3);     // Catch: Throwable -> L11
        goto L18
    L13:
        IoUtil.safeClose(r2);
        return r5;
    L11:
        th = th;
        r1 = r2;
    L16:
        IoUtil.safeClose(r1);
        throw th;
    L15:
        th = th;
        goto L16
    }

    public static ArrayList<HashMap<String, String>> readListMap(File r8, String r9, String r10) {
        BufferedReader r0 = null;
        ArrayList<HashMap<String, String>> r1 = null;
        BufferedReader r2 = null;
        if (r8 != null) goto L5;
        return null;
    L5:
        if (r8.exists() == true) goto L7;
        return null;
    L7:
        if (TextUtils.isEmpty(r9) == false) goto L9;
        return null;
    L9:
        if (TextUtils.isEmpty(r10) == true) goto L67;
        BufferedReader r3 = new BufferedReader(new FileReader(r8));     // Catch: Throwable -> L38 Throwable -> L40
    L47:
        String r11 = r3.readLine();     // Catch: Throwable -> L27 Throwable -> L29
        if (r11 == null) goto L37;
        if ("\n".equals(r11) == true) goto L47;
        String[] r12 = r11.split(r9);     // Catch: Throwable -> L27 Throwable -> L29
        if (r12 == null) goto L47;
        HashMap<String, String> r4 = new HashMap();     // Catch: Throwable -> L27 Throwable -> L29
        int r5 = 0;
    L21:
        if (r5 >= r12.length) goto L32;
        String[] r6 = r12[r5].split(r10);     // Catch: Throwable -> L27 Throwable -> L29
        if (r6 == null) goto L30;
        if (r6.length != 2) goto L30;
        r4.put(r6[0], r6[1]);     // Catch: Throwable -> L27 Throwable -> L29
    L30:
        r5 = r5 + 1;     // Catch: Throwable -> L27 Throwable -> L29
        goto L21
    L32:
        if (r4.size() <= 0) goto L47;
        if (r1 != null) goto L35;
        r1 = new ArrayList();     // Catch: Throwable -> L27 Throwable -> L29
    L35:
        r1.add(r4);     // Catch: Throwable -> L27 Throwable -> L29
        goto L47
    L37:
        IoUtil.safeClose(r3);
        return r1;
    L29:
        ArrayList<HashMap<String, String>> r13 = r1;
        r2 = r3;
    L43:
        IoUtil.safeClose(r2);
        return r13;
    L27:
        th = th;
        r0 = r3;
    L41:
        IoUtil.safeClose(r0);
        throw th;
    L40:
        r13 = null;
    L38:
        th = th;
        goto L41
    L67:
        return null;
    }

    @Nullable
    public static String[] readProcFile(String r4) {
        BufferedReader r1 = new BufferedReader(new InputStreamReader(new FileInputStream(r4)), 1000);     // Catch: Throwable -> L12
        String r5 = r1.readLine();     // Catch: Throwable -> L7
        int r2 = r5.indexOf(")");     // Catch: Throwable -> L7
        if (r2 <= 0) goto L9;
        r5 = r5.substring(r2 + 2);     // Catch: Throwable -> L7
    L9:
        String[] r6 = r5.split(" ");     // Catch: Throwable -> L7
        IoUtil.safeClose(r1);
        return r6;
    L7:
        th = th;
    L24:
        th.printStackTrace();     // Catch: Throwable -> L17
        IoUtil.safeClose(r1);
        return null;
    L17:
        th = move-exception;
        IoUtil.safeClose(r1);
        throw th;
    L12:
        th = th;
        r1 = null;
        goto L24
    }

    @Nullable
    public static Map<String, String> readPropertiesFile(File r6) {
        FileInputStream r0 = null;
        Properties r1 = new Properties();     // Catch: Throwable -> L13 IOException -> L15
        FileInputStream r2 = new FileInputStream(r6);     // Catch: Throwable -> L13 IOException -> L15
    L23:
        r1.load(r2);     // Catch: Throwable -> L9 IOException -> L20
        Set<String> r7 = r1.stringPropertyNames();     // Catch: Throwable -> L9 IOException -> L20
        HashMap r3 = new HashMap();     // Catch: Throwable -> L9 IOException -> L20
        Iterator<String> r8 = r7.iterator();     // Catch: Throwable -> L9 IOException -> L20
    L6:
        if (r8.hasNext() == false) goto L11;
        String r4 = r8.next();     // Catch: Throwable -> L9 IOException -> L20
        r3.put(r4, r1.getProperty(r4));     // Catch: Throwable -> L9 IOException -> L20
        goto L18
    L11:
        IoUtil.safeClose(r2);
        return r3;
    L9:
        th = th;
        r0 = r2;
    L16:
        IoUtil.safeClose(r0);
        throw th;
    L18:
        IoUtil.safeClose(r2);
        return null;
    L15:
        r2 = null;
    L13:
        th = th;
        goto L16
    }

    public static JSONArray toJsonArray(String r3, String r4) {
        JSONArray r0 = new JSONArray();
        if (r3 == null) goto L8;
        if (r4 == null) goto L8;
        String[] r5 = r3.split(r4);
        int r6 = r5.length;
        int r1 = 0;
    L6:
        if (r1 >= r6) goto L8;
        r0.put(r5[r1]);
        r1 = r1 + 1;
    L8:
        return r0;
    }

    public static void writeFile(@NonNull File r2, @NonNull String r3, boolean r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        r2.getParentFile().mkdirs();
        FileOutputStream r0 = null;
        FileOutputStream r1 = new FileOutputStream(r2, r4);     // Catch: Throwable -> L12
        r1.write(r3.getBytes());     // Catch: Throwable -> L10
        r1.flush();     // Catch: Throwable -> L10
        IoUtil.safeClose(r1);
        return;
    L10:
        th = th;
        r0 = r1;
    L13:
        IoUtil.safeClose(r0);
        throw th;
    L12:
        th = th;
        goto L13
    }

    public static void writeListMap(File r5, ArrayList<HashMap<String, String>> r6, String r7, String r8) {
        if (r5 == null) goto L39;
        if (r6 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r7) == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r8) == true) goto L53;
        FileOutputStream r0 = null;
        FileOutputStream r1 = new FileOutputStream(r5);     // Catch: Throwable -> L31 IOException -> L33
        StringBuilder r9 = new StringBuilder();     // Catch: Throwable -> L23 IOException -> L25
        int r2 = 0;
    L13:
        if (r2 >= r6.size()) goto L29;
        HashMap<String, String> r3 = r6.get(r2);     // Catch: Throwable -> L23 IOException -> L25
        if (r3 == null) goto L28;
        if (r3.size() == 0) goto L28;
        Iterator<String> r4 = r3.keySet().iterator();     // Catch: Throwable -> L23 IOException -> L25
    L21:
        if (r4.hasNext() == false) goto L27;
        String r10 = r4.next();     // Catch: Throwable -> L23 IOException -> L25
        r9.append(r10);     // Catch: Throwable -> L23 IOException -> L25
        r9.append(r8);     // Catch: Throwable -> L23 IOException -> L25
        r9.append(r3.get(r10));     // Catch: Throwable -> L23 IOException -> L25
        r9.append(r7);     // Catch: Throwable -> L23 IOException -> L25
        goto L21
    L27:
        r9.append("\n");     // Catch: Throwable -> L23 IOException -> L25
    L28:
        r2 = r2 + 1;     // Catch: Throwable -> L23 IOException -> L25
        goto L13
    L29:
        r1.write(r9.toString().getBytes());     // Catch: Throwable -> L23 IOException -> L25
        IoUtil.safeClose(r1);
        return;
    L25:
        e = e;
        r0 = r1;
    L34:
        e.printStackTrace();     // Catch: Throwable -> L31
        IoUtil.safeClose(r0);
        return;
    L23:
        th = th;
        r0 = r1;
    L37:
        IoUtil.safeClose(r0);
        throw th;
    L33:
        e = e;
    L31:
        th = th;
        goto L37
    L53:
        return;
    }

    public static void zip(String r1, String r2) {
        zip(r2, new File(r1));
    }

    public static void zip(List<String> r3, String r4) {
        ZipOutputStream r0 = null;
        ZipOutputStream r1 = new ZipOutputStream(new FileOutputStream(r4));     // Catch: Throwable -> L13
        Iterator<String> r5 = r3.iterator();     // Catch: Throwable -> L9
    L6:
        if (r5.hasNext() == false) goto L11;
        File r2 = new File(r5.next());     // Catch: Throwable -> L9
        zip(r1, r2, r2.getName());     // Catch: Throwable -> L9
        goto L6
    L11:
        IoUtil.safeClose(r1);
        return;
    L9:
        th = th;
        r0 = r1;
    L14:
        IoUtil.safeClose(r0);
        throw th;
    L13:
        th = th;
        goto L14
    }

    public static boolean deleteFile(@NonNull File r5) {
        boolean r1 = true;
        if (r5.exists() == true) goto L6;
        return true;
    L6:
        if (r5.canWrite() == true) goto L9;
        return false;
    L9:
        if (r5.isFile() == false) goto L13;
        return r5.delete();
    L13:
        if (r5.isDirectory() == false) goto L33;
        File[] r0 = r5.listFiles();
        int r3 = 0;
    L15:
        if (r0 == null) goto L28;
        if (r3 >= r0.length) goto L28;
        if (r0[r3].isFile() == true) goto L21;
        boolean r4 = deleteFile(r0[r3]);
    L23:
        r1 = r1 & r4;
    L26:
        r3 = r3 + 1;
        goto L15
    L21:
        if (r0[r3].canWrite() == false) goto L24;
        r4 = r0[r3].delete();
        goto L23
    L24:
        r1 = false;
    L28:
        return r1 & r5.delete();
    L33:
        return true;
    }

    public static boolean isEmpty(JSONArray r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.length() == 0) goto L7;
        return false;
    }

    public static boolean isEmpty(File[] r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.length == 0) goto L7;
        return false;
    }

    private static void zip(String r3, File r4) {
        ZipOutputStream r0 = null;
        new File(r3).getParentFile().mkdirs();     // Catch: Throwable -> L9
        ZipOutputStream r1 = new ZipOutputStream(new FileOutputStream(r3));     // Catch: Throwable -> L9
        zip(r1, r4, "");     // Catch: Throwable -> L7
        IoUtil.safeClose(r1);
        return;
    L7:
        th = th;
        r0 = r1;
    L10:
        IoUtil.safeClose(r0);
        throw th;
    L9:
        th = th;
        goto L10
    }

    public static String readFile(String r1) {
        return readFile(r1, null);
    }

    public static void zip(OutputStream r3, File... r4) {
        ZipOutputStream r0 = null;
        ZipOutputStream r1 = new ZipOutputStream(r3);     // Catch: Throwable -> L12
        r1.putNextEntry(new ZipEntry(LibrarianImpl.Constants.SEPARATOR));     // Catch: Throwable -> L8
        int r5 = r4.length;     // Catch: Throwable -> L8
        int r2 = 0;
    L5:
        if (r2 >= r5) goto L10;
        zip(r1, r4[r2]);     // Catch: Throwable -> L8
        r2 = r2 + 1;
        goto L5
    L10:
        IoUtil.safeClose(r1);
        return;
    L8:
        th = th;
        r0 = r1;
    L13:
        IoUtil.safeClose(r0);
        throw th;
    L12:
        th = th;
        goto L13
    }

    private static void zip(ZipOutputStream r4, File r5) {
        if (r5.exists() == true) goto L5;
        return;
    L5:
        int r1 = 0;
        if (r5.isDirectory() == false) goto L11;
        File[] r6 = r5.listFiles();
    L9:
        if (r1 >= r6.length) goto L33;
        File r0 = r6[r1];
        zip(r4, r0, r0.getName());
        r1 = r1 + 1;
        goto L9
    L33:
        return;
    L11:
        FileInputStream r2 = null;
        FileInputStream r3 = new FileInputStream(r5);     // Catch: Throwable -> L23
        byte[] r7 = new byte[4096];     // Catch: Throwable -> L19
    L15:
        int r8 = r3.read(r7);     // Catch: Throwable -> L19
        if ((-1) == r8) goto L21;
        r4.write(r7, 0, r8);     // Catch: Throwable -> L19
        goto L15
    L21:
        IoUtil.safeClose(r3);
        return;
    L19:
        th = th;
        r2 = r3;
    L24:
        IoUtil.safeClose(r2);
        throw th;
    L23:
        th = th;
        goto L24
    }

    private static void zip(ZipOutputStream r4, File r5, String r6) {
        if (r5.exists() == true) goto L5;
        return;
    L5:
        int r1 = 0;
        if (r5.isDirectory() == false) goto L14;
        File[] r7 = r5.listFiles();
        r4.putNextEntry(new ZipEntry(a.j(r6, LibrarianImpl.Constants.SEPARATOR)));
        if (r6.length() != 0) goto L10;
        String r8 = "";
    L12:
        if (r1 >= r7.length) goto L37;
        File r0 = r7[r1];
        StringBuilder r2 = a.q(r8);
        r2.append(r7[r1].getName());
        zip(r4, r0, r2.toString());
        r1 = r1 + 1;
        goto L12
    L37:
        return;
    L10:
        r8 = r6.concat(LibrarianImpl.Constants.SEPARATOR);
        goto L12
    L14:
        r4.putNextEntry(new ZipEntry(r6));
        FileInputStream r9 = null;
        FileInputStream r3 = new FileInputStream(r5);     // Catch: Throwable -> L26
        byte[] r10 = new byte[4096];     // Catch: Throwable -> L22
    L18:
        int r11 = r3.read(r10);     // Catch: Throwable -> L22
        if ((-1) == r11) goto L24;
        r4.write(r10, 0, r11);     // Catch: Throwable -> L22
        goto L18
    L24:
        IoUtil.safeClose(r3);
        return;
    L22:
        th = th;
        r9 = r3;
    L27:
        IoUtil.safeClose(r9);
        throw th;
    L26:
        th = th;
        goto L27
    }
}
