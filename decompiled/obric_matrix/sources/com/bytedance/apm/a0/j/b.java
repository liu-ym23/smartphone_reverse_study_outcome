package com.bytedance.apm.a0.j;

import d.b.l.a.d;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static LinkedList<a> a(int r14) {
        File[] r15 = new File("/proc/" + r14 + "/task/").listFiles();
        LinkedList<a> r0 = new LinkedList();
        int r1 = r15.length;
        BufferedReader r5 = null;
        int r4 = 0;
    L3:
        if (r4 >= r1) goto L18;
        BufferedReader r7 = new BufferedReader(new InputStreamReader(new FileInputStream(r15[r4].getPath() + "/stat")), 1000);     // Catch: Throwable -> L11 Exception -> L19 FileNotFoundException -> L16
        String r6 = r7.readLine();     // Catch: Throwable -> L8 Exception -> L10
        int r8 = r6.lastIndexOf(41);     // Catch: Throwable -> L8 Exception -> L10
        String r9 = r6.substring(0, r8);     // Catch: Throwable -> L8 Exception -> L10
        String r10 = r6.substring(r8 + 4);     // Catch: Throwable -> L8 Exception -> L10
        int r11 = r9.indexOf(40);     // Catch: Throwable -> L8 Exception -> L10
        int r12 = Integer.valueOf(r9.substring(0, r11 - 1)).intValue();     // Catch: Throwable -> L8 Exception -> L10
        String r13 = r9.substring(r11 + 1);     // Catch: Throwable -> L8 Exception -> L10
        String[] r16 = r10.split(" ");     // Catch: Throwable -> L8 Exception -> L10
        r0.add(new a(r12, r13, Long.parseLong(r16[10]) + Long.parseLong(r16[11])));     // Catch: Throwable -> L8 Exception -> L10
        d.b(r7);
        r5 = r7;
    L17:
        r4 = r4 + 1;
        goto L3
    L10:
        r5 = r7;
    L8:
        th = th;
        r5 = r7;
    L12:
        d.b(r5);
        throw th;
    L16:
        d.b(r5);
    L11:
        th = th;
    L14:
        d.b(r5);
        return null;
    L18:
        return r0;
    }
}
