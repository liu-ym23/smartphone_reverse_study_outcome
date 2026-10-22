package com.monitor.cloudmessage.internal.file.generator;

import com.bytedance.apm6.util.ListUtils;
import com.bytedance.librarian.LibrarianImpl;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DirTreeFileGenerator {
    public DirTreeFileGenerator() {
    }

    private static void dir2map(File r5, HashMap<String, Object> r6, List<String> r7) {
        if (shouldSkip(r5.getName()) == false) goto L5;
        return;
    L5:
        int r1 = 0;
        if (ListUtils.isEmpty(r7) == true) goto L13;
        Iterator<String> r0 = r7.iterator();
    L9:
        if (r0.hasNext() == false) goto L13;
        if (r5.getAbsolutePath().startsWith(r0.next()) == false) goto L9;
        boolean r2 = true;
    L14:
        if (r2 == false) goto L20;
        StringBuilder r3 = new StringBuilder();
        int r4 = 0;
    L17:
        if (r4 >= r5.getName().length()) goto L19;
        r3.append("*");
        r4 = r4 + 1;
        goto L17
    L19:
        String r8 = r3.toString();
    L22:
        if (r5.isFile() == false) goto L25;
        r6.put(r8, Long.valueOf(r5.length()));
    L25:
        if (r5.isDirectory() == false) goto L29;
        HashMap r9 = new HashMap();
        r6.put(r8, r9);
        String[] r10 = r5.list();
        int r11 = r10.length;
    L27:
        if (r1 >= r11) goto L35;
        dir2map(new File(r5, r10[r1]), r9, r7);
        r1 = r1 + 1;
        goto L27
    L35:
        return;
    L29:
        return;
    L20:
        r8 = r5.getName();
    L13:
        r2 = false;
        goto L14
    }

    public static void getDeptJson(File r4, BufferedWriter r5, List<String> r6) {
        HashMap r0 = new HashMap();
        r5.write("{");
        r5.newLine();
        File[] r7 = r4.listFiles();
        int r1 = 0;
    L4:
        if (r1 >= r7.length) goto L12;
        r0.clear();
        dir2map(r7[r1], r0, r6);
        if (r0.keySet().isEmpty() == true) goto L11;
        writeJson(r0, 1, r5);
        if ((r1 + 1) >= r7.length) goto L11;
        r5.write(",");
    L11:
        r1 = r1 + 1;
        goto L4
    L12:
        r5.write("}");
        r5.flush();
    }

    private static boolean shouldSkip(String r1) {
        return r1.startsWith(LibrarianImpl.Constants.DOT);
    }

    public static boolean writeDirTreeInfo(File r2, File r3, List<String> r4) {
        BufferedWriter r0 = null;
        FileWriter r1 = new FileWriter(r3);     // Catch: Throwable -> L20 IOException -> L22
        BufferedWriter r5 = new BufferedWriter(r1);     // Catch: Throwable -> L16 IOException -> L18
        getDeptJson(r2, r5, r4);     // Catch: Throwable -> L12 IOException -> L14
        r5.close();     // Catch: IOException -> L8
        r1.close();     // Catch: IOException -> L8
        return true;
    L8:
        e = move-exception;
        e.printStackTrace();
        return true;
    L14:
        e = e;
        r0 = r5;
    L24:
        e.printStackTrace();     // Catch: Throwable -> L16
        if (r0 != null) goto L50;
    L29:
        if (r1 == null) goto L58;
        r1.close();     // Catch: IOException -> L27
        return false;
    L27:
        e = move-exception;
        e.printStackTrace();
        return false;
    L58:
        return false;
    L50:
        r0.close();     // Catch: IOException -> L27
    L12:
        th = th;
        r0 = r5;
    L35:
        if (r0 != null) goto L48;
    L39:
        if (r1 == null) goto L43;
        r1.close();     // Catch: IOException -> L37
    L37:
        e = move-exception;
        e.printStackTrace();
    L43:
        throw th;
    L48:
        r0.close();     // Catch: IOException -> L37
    L18:
        e = e;
        goto L24
    L16:
        th = th;
    L22:
        e = e;
        r1 = null;
    L20:
        th = th;
        r1 = null;
        goto L35
    }

    private static void writeJson(HashMap<String, Object> r12, int r13, BufferedWriter r14) {
        int r0 = r12.keySet().size();
        Iterator<String> r1 = r12.keySet().iterator();
        int r3 = 0;
    L4:
        if (r1.hasNext() == false) goto L25;
        String r4 = r1.next();
        Object r5 = r12.get(r4);
        r3 = r3 + 1;
        if ((r5 instanceof Long) == true) goto L7;
        int r6 = 0;
    L16:
        if (r6 >= r13) goto L18;
        r14.write("\t");
        r6 = r6 + 1;
        goto L16
    L18:
        r14.write("\"" + r4.replaceAll("\n", "") + "\": {");
        r14.newLine();
        int r7 = r13 + 1;
        writeJson((HashMap) r5, r7, r14);
        int r8 = 0;
    L19:
        if (r8 >= r7) goto L21;
        r14.write("\t");
        r8 = r8 + 1;
        goto L19
    L21:
        r14.write("}");
        if (r3 >= r0) goto L24;
        r14.write(",");
    L24:
        r14.newLine();
        goto L4
    L7:
        int r9 = 0;
    L9:
        if (r9 >= (r13 + 1)) goto L11;
        r14.write("\t");
        r9 = r9 + 1;
        goto L9
    L11:
        String r10 = r4.replaceAll("\n", "");
        Long r11 = (Long) r5;
        r11.longValue();
        r14.write(String.format("\"%s\": %d", new Object[]{r10, r11}));
        if (r3 >= r0) goto L14;
        r14.write(",");
    L14:
        r14.newLine();
        goto L4
    }
}
