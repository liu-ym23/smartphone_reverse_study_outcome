package com.bytedance.apm6.cpu.exception;

import a.a;
import android.text.TextUtils;
import com.bytedance.apm6.cpu.Constants;
import com.bytedance.apm6.perf.base.model.ThreadStatInfo;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.proc.CommonProcUtil;
import com.bytedance.common.utility.io.IOUtils;
import com.bytedance.monitor.collector.PerfMonitorManager;
import com.bytedance.monitor.util.IoUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ThreadCpuExceptionUtils {
    public ThreadCpuExceptionUtils() {
    }

    public static void filterThreads(int r19, List<ThreadExceptionItem> r20, List<ThreadExceptionItem> r21, double r22, Map<String, Double> r24) {
        String r6 = a.f(r19, "/proc/", "/task/");
        Logger.i(Constants.TAG, "size: " + r20.size());
        long r8 = CommonProcUtil.getAppCPUTime();
        Iterator<ThreadExceptionItem> r10 = r20.iterator();
        BufferedReader r11 = null;
    L4:
        if (r10.hasNext() == false) goto L46;
        ThreadExceptionItem r0 = r10.next();
        if (r0 != null) goto L61;
        IOUtils.close(r11);
        String r110 = r6;
        Iterator<ThreadExceptionItem> r17 = r10;
    L39:
        r6 = r110;
        r10 = r17;
        goto L4
    L61:
        StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L36
        r15.append(r6);     // Catch: Throwable -> L36
        r110 = r6;
        r15.append(r0.getThreadId());     // Catch: Throwable -> L48
        r15.append("/stat");     // Catch: Throwable -> L48
        BufferedReader r12 = new BufferedReader(new InputStreamReader(new FileInputStream(r15.toString())), 1000);     // Catch: Throwable -> L48
        String r7 = r12.readLine();     // Catch: Throwable -> L33
        String[] r9 = r7.substring(r7.lastIndexOf(41) + 4).split(" ");     // Catch: Throwable -> L33
        long r13 = Long.parseLong(r9[10]) + Long.parseLong(r9[11]);     // Catch: Throwable -> L33
        r17 = r10;
        BufferedReader r18 = r12;
        float r14 = (r13 - r0.getThreadCpuTime()) / (r8 - r0.getProcessCpuTime());
        Logger.i(Constants.TAG, r0.getThreadName() + " judge: " + r13 + " " + r0.getThreadCpuTime() + " " + r14 + " " + r22);     // Catch: Throwable -> L22
        if (r24 != null) goto L18;
    L25:
        double r16 = r14;
        if (r16 < r22) goto L28;
        r0.setCpuUsage(r16);     // Catch: Throwable -> L22
        r0.setPriority(Integer.parseInt(r9[18]));     // Catch: Throwable -> L22
    L29:
        Logger.i(Constants.TAG, "after item: " + r0);     // Catch: Throwable -> L22
        IOUtils.close(r18);
        r11 = r18;
        goto L39
    L28:
        r21.add(r0);     // Catch: Throwable -> L22
        goto L29
    L18:
        if (r24.containsKey(r0.getThreadName()) == false) goto L25;
        double r111 = r14;
        if (r111 < r24.get(r0.getThreadName()).doubleValue()) goto L24;
        r0.setCpuUsage(r111);     // Catch: Throwable -> L22
        r0.setPriority(Integer.parseInt(r9[18]));     // Catch: Throwable -> L22
        goto L29
    L24:
        r21.add(r0);     // Catch: Throwable -> L22
    L22:
        th = th;
    L23:
        r11 = r18;
    L51:
        Logger.i(Constants.TAG, "error: " + th.getLocalizedMessage());     // Catch: Throwable -> L43
    L38:
        IOUtils.close(r11);
    L43:
        th = move-exception;
        IOUtils.close(r11);
        throw th;
    L31:
        th = th;
    L32:
        r18 = r12;
    L33:
        th = th;
        r17 = r10;
    L35:
        r17 = r10;
        r21.add(r0);     // Catch: Throwable -> L40
    L40:
        th = th;
    L36:
        r110 = r6;
        goto L35
    L46:
        r20.removeAll(r21);
        Logger.i(Constants.TAG, "after size: " + r20.size());
    }

    public static void getThreadInfo(int r9, Map<Integer, ThreadExceptionItem> r10) {
        File[] r0 = new File(a.f(r9, "/proc/", "/task/")).listFiles();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L15;
        int r3 = Integer.parseInt(r0[r2].getName());     // Catch: NumberFormatException -> L16
        ThreadStatInfo r4 = PerfMonitorManager.getInstance().dumpThreadStatInfo(r9, r3);     // Catch: NumberFormatException -> L16
        if (r3 == 0) goto L14;
        if (r4 == null) goto L14;
        if (TextUtils.isEmpty(r4.threadName) == true) goto L14;
        if (r4.threadCpuTime == 0) goto L14;
        ThreadExceptionItem r5 = new ThreadExceptionItem();     // Catch: NumberFormatException -> L16
        r5.setThreadId(r3);     // Catch: NumberFormatException -> L16
        r5.setThreadName(r4.threadName);     // Catch: NumberFormatException -> L16
        r5.setThreadCpuTime(r4.threadCpuTime);     // Catch: NumberFormatException -> L16
        r10.put(Integer.valueOf(r3), r5);     // Catch: NumberFormatException -> L16
    L14:
        r2 = r2 + 1;
        goto L3
    }

    public static void getThreadInfo(int r14, List<ThreadExceptionItem> r15) {
        File[] r16 = new File(a.f(r14, "/proc/", "/task/")).listFiles();
        long r0 = CommonProcUtil.getAppCPUTime();
        int r2 = r16.length;
        BufferedReader r3 = null;
        int r5 = 0;
    L3:
        if (r5 >= r2) goto L22;
        BufferedReader r7 = new BufferedReader(new InputStreamReader(new FileInputStream(r16[r5].getPath() + "/stat")), 1000);     // Catch: Throwable -> L23
        String r4 = r7.readLine();     // Catch: Throwable -> L18
        int r6 = r4.lastIndexOf(41);     // Catch: Throwable -> L18
        String r8 = r4.substring(0, r6);     // Catch: Throwable -> L18
        String r9 = r4.substring(r6 + 4);     // Catch: Throwable -> L18
        int r10 = r8.indexOf(40);     // Catch: Throwable -> L18
        int r11 = Integer.valueOf(r8.substring(0, r10 - 1)).intValue();     // Catch: Throwable -> L18
        String r12 = r8.substring(r10 + 1);     // Catch: Throwable -> L18
        String[] r13 = r9.split(" ");     // Catch: Throwable -> L18
        long r17 = Long.parseLong(r13[10]) + Long.parseLong(r13[11]);     // Catch: Throwable -> L18
        if (r11 != 0) goto L9;
    L15:
        IoUtil.safeClose(r7);
        r3 = r7;
    L21:
        r5 = r5 + 1;
        goto L3
    L9:
        if (r12.isEmpty() == true) goto L15;
        if (r17 == 0) goto L15;
        if (Thread.currentThread().getName().contains(r12) == true) goto L15;
        ThreadExceptionItem r18 = new ThreadExceptionItem();     // Catch: Throwable -> L18
        r18.setThreadName(r12);     // Catch: Throwable -> L18
        r18.setThreadId(r11);     // Catch: Throwable -> L18
        r18.setThreadCpuTime(r17);     // Catch: Throwable -> L18
        r18.setProcessCpuTime(r0);     // Catch: Throwable -> L18
        r18.setPriority(Integer.parseInt(r13[14]));     // Catch: Throwable -> L18
        r15.add(r18);     // Catch: Throwable -> L18
    L18:
        r3 = r7;
    L20:
        IoUtil.safeClose(r3);
        goto L21
    }

    public static void filterThreads(int r6, List<ThreadExceptionItem> r7, double r8, Map<String, Double> r10) {
        filterThreads(r6, r7, new LinkedList(), r8, r10);
    }
}
