package com.bytedance.apm.perf.methodtrace;

import com.bytedance.common.utility.io.IOUtils;
import com.bytedance.monitor.util.IoUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
public class ThreadTimeUtil {
    public static final double START_RATE_THRESHOLD = 0.2d;
    public static final double THREAD_USAGE_THRESHOLD = 0.1d;

    public ThreadTimeUtil() {
    }

    public static LinkedList<ThreadTimeItem> getThreadInfo(int r14) {
        File[] r15 = new File("/proc/" + r14 + "/task/").listFiles();
        LinkedList<ThreadTimeItem> r0 = new LinkedList();
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
        r0.add(new ThreadTimeItem(r12, r13, Long.parseLong(r16[10]) + Long.parseLong(r16[11])));     // Catch: Throwable -> L8 Exception -> L10
        IoUtil.safeClose(r7);
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
        IoUtil.safeClose(r5);
        throw th;
    L16:
        IoUtil.safeClose(r5);
    L11:
        th = th;
    L14:
        IoUtil.safeClose(r5);
        return null;
    L18:
        return r0;
    }

    public static void filterThreads(int r9, List<ThreadTimeItem> r10, long r11) {
        String r12 = "/proc/" + r9 + "/task/";
        ListIterator<ThreadTimeItem> r13 = r10.listIterator();
        BufferedReader r0 = null;
    L4:
        if (r13.hasNext() == false) goto L33;
        ThreadTimeItem r1 = r13.next();     // Catch: Throwable -> L17 Exception -> L22
        BufferedReader r2 = new BufferedReader(new InputStreamReader(new FileInputStream(r12 + r1.threadId + "/stat")), 1000);     // Catch: FileNotFoundException -> L15 Throwable -> L17 Exception -> L22
        goto L20
    L27:
        String r3 = r2.readLine();     // Catch: Throwable -> L12 Exception -> L14
        String[] r4 = r3.substring(r3.lastIndexOf(41) + 4).split(" ");     // Catch: Throwable -> L12 Exception -> L14
        long r5 = Long.parseLong(r4[10]) + Long.parseLong(r4[11]);     // Catch: Throwable -> L12 Exception -> L14
        float r6 = (r5 - r1.threadTime) / r11;     // Catch: Throwable -> L12 Exception -> L14
        if (r6 < 0.1d) goto L10;
        r1.threadUsage = r6;     // Catch: Throwable -> L12 Exception -> L14
        r1.threadTime = r5;     // Catch: Throwable -> L12 Exception -> L14
    L11:
        IOUtils.close(r2);
        r0 = r2;
        goto L4
    L10:
        r13.remove();     // Catch: Throwable -> L12 Exception -> L14
        goto L11
    L14:
        r0 = r2;
    L12:
        th = th;
        r0 = r2;
    L18:
        IOUtils.close(r0);
        throw th;
    L15:
        r13.remove();     // Catch: Throwable -> L17 Exception -> L22
        IOUtils.close(r0);
        goto L4
    L17:
        th = th;
    L20:
        IOUtils.close(r0);
        return;
    }
}
