package com.bytedance.apm.launch;

import android.os.Debug;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm.constant.PerfConsts;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LaunchPerfDataFetcher {

    public static class LaunchTraceData {
        private long allThreadCount;
        private long binderTime;
        private long blockGcCount;
        private long blockGcTime;
        private double cpuTime;
        private long gcCount;
        private long gcTime;
        private long inVoluntarySwitches;
        private double iowaitTime;
        private List<String> javaThreadNameList;
        private long lockTime;
        private long majorFault;
        private long minorFault;
        private double runnableTime;
        private double sleepTime;
        private long voluntarySwitches;

        public LaunchTraceData() {
            this.gcCount = -1;
            this.gcTime = -1;
            this.blockGcCount = -1;
            this.blockGcTime = -1;
            this.cpuTime = -1.0d;
            this.voluntarySwitches = -1;
            this.inVoluntarySwitches = -1;
            this.iowaitTime = -1.0d;
            this.runnableTime = -1.0d;
            this.sleepTime = -1.0d;
            this.lockTime = -1;
            this.binderTime = -1;
            this.minorFault = -1;
            this.majorFault = -1;
            this.allThreadCount = -1;
            this.javaThreadNameList = null;
        }

        public static /* synthetic */ double access$002(LaunchTraceData r0, double r1) {
            r0.iowaitTime = r1;
            return r1;
        }

        public static /* synthetic */ long access$1002(LaunchTraceData r0, long r1) {
            r0.blockGcCount = r1;
            return r1;
        }

        public static /* synthetic */ double access$102(LaunchTraceData r0, double r1) {
            r0.runnableTime = r1;
            return r1;
        }

        public static /* synthetic */ long access$1102(LaunchTraceData r0, long r1) {
            r0.blockGcTime = r1;
            return r1;
        }

        public static /* synthetic */ long access$1202(LaunchTraceData r0, long r1) {
            r0.allThreadCount = r1;
            return r1;
        }

        public static /* synthetic */ List access$1302(LaunchTraceData r0, List r1) {
            r0.javaThreadNameList = r1;
            return r1;
        }

        public static /* synthetic */ double access$202(LaunchTraceData r0, double r1) {
            r0.sleepTime = r1;
            return r1;
        }

        public static /* synthetic */ long access$302(LaunchTraceData r0, long r1) {
            r0.voluntarySwitches = r1;
            return r1;
        }

        public static /* synthetic */ long access$402(LaunchTraceData r0, long r1) {
            r0.inVoluntarySwitches = r1;
            return r1;
        }

        public static /* synthetic */ double access$502(LaunchTraceData r0, double r1) {
            r0.cpuTime = r1;
            return r1;
        }

        public static /* synthetic */ long access$602(LaunchTraceData r0, long r1) {
            r0.minorFault = r1;
            return r1;
        }

        public static /* synthetic */ long access$702(LaunchTraceData r0, long r1) {
            r0.majorFault = r1;
            return r1;
        }

        public static /* synthetic */ long access$802(LaunchTraceData r0, long r1) {
            r0.gcCount = r1;
            return r1;
        }

        public static /* synthetic */ long access$902(LaunchTraceData r0, long r1) {
            r0.gcTime = r1;
            return r1;
        }

        public long getAllThreadCount() {
            return this.allThreadCount;
        }

        public long getBinderTime() {
            return this.binderTime;
        }

        public long getBlockGcCount() {
            return this.blockGcCount;
        }

        public long getBlockGcTime() {
            return this.blockGcTime;
        }

        public double getCpuTime() {
            return this.cpuTime;
        }

        public long getGcCount() {
            return this.gcCount;
        }

        public long getGcTime() {
            return this.gcTime;
        }

        public long getInVoluntarySwitches() {
            return this.inVoluntarySwitches;
        }

        public double getIowaitTime() {
            return this.iowaitTime;
        }

        public List<String> getJavaThreadNameList() {
            return this.javaThreadNameList;
        }

        public long getLockTime() {
            return this.lockTime;
        }

        public long getMajorFault() {
            return this.majorFault;
        }

        public long getMinorFault() {
            return this.minorFault;
        }

        public double getRunnableTime() {
            return this.runnableTime;
        }

        public double getSleepTime() {
            return this.sleepTime;
        }

        public long getVoluntarySwitches() {
            return this.voluntarySwitches;
        }

        public void setBinderTime(long r1) {
            this.binderTime = r1;
        }

        public void setLockTime(long r1) {
            this.lockTime = r1;
        }

        public String toString() {
            return "LaunchTraceData{gcCount=" + this.gcCount + ", gcTime=" + this.gcTime + ", blockGcCount=" + this.blockGcCount + ", blockGcTime=" + this.blockGcTime + ", cpuTime=" + this.cpuTime + ", voluntarySwitches=" + this.voluntarySwitches + ", inVoluntarySwitches=" + this.inVoluntarySwitches + ", iowaitTime=" + this.iowaitTime + ", runnableTime=" + this.runnableTime + ", sleepTime=" + this.sleepTime + ", minorFault=" + this.minorFault + ", majorFault=" + this.majorFault + ", allThreadCount=" + this.allThreadCount + ", javaThreadNameList=" + this.javaThreadNameList + ", lockTime=" + this.lockTime + ", binderTime=" + this.binderTime + '}';
        }
    }

    public LaunchPerfDataFetcher() {
    }

    private static void fetchThreadData(LaunchTraceData r7) {
        int r0 = 0;
        int r1 = new File("/proc/self/task/").listFiles().length;     // Catch: Throwable -> L5
    L6:
        if (r1 != 0) goto L8;
        return;
    L8:
        ThreadGroup r2 = Looper.getMainLooper().getThread().getThreadGroup();
        if (r2 != null) goto L12;
        return;
    L12:
        if (r2.getParent() == null) goto L14;
        r2 = r2.getParent();
        goto L12
    L14:
        int r3 = r2.activeCount();
        Thread[] r4 = new Thread[(r3 / 2) + r3];
        int r5 = r2.enumerate(r4);
        LinkedList r6 = new LinkedList();
    L15:
        if (r0 >= r5) goto L20;
        String r8 = r4[r0].getName();
        if (TextUtils.isEmpty(r8) == true) goto L19;
        r6.add(r8);
    L19:
        r0 = r0 + 1;
        goto L15
    L20:
        LaunchTraceData.access$1202(r7, r1);
        LaunchTraceData.access$1302(r7, r6);
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public static LaunchTraceData getLaunchTraceData() {
        LaunchTraceData r4 = new LaunchTraceData();
        int r2 = Process.myPid();     // Catch: Throwable -> L39
        BufferedReader r6 = null;
        BufferedReader r7 = new BufferedReader(new FileReader("/proc/" + r2 + "/task/" + r2 + "/sched"), 100);     // Catch: Throwable -> L46
    L51:
        String r8 = r7.readLine();     // Catch: Throwable -> L11
        if (r8 != null) goto L9;
    L49:
        BufferedReader r9 = new BufferedReader(new FileReader("/proc/" + r2 + "/task/" + r2 + "/stat"), 100);     // Catch: Throwable -> L45
        String[] r0 = r9.readLine().split(" ");     // Catch: Throwable -> L32
        LaunchTraceData.access$602(r4, Long.parseLong(r0[9]));     // Catch: Throwable -> L32
        LaunchTraceData.access$702(r4, Long.parseLong(r0[11]));     // Catch: Throwable -> L32
    L53:
        LaunchTraceData.access$802(r4, Long.parseLong(Debug.getRuntimeStat(PerfConsts.ART_GC_GC_COUNT)));     // Catch: Throwable -> L42
        LaunchTraceData.access$902(r4, Long.parseLong(Debug.getRuntimeStat(PerfConsts.ART_GC_GC_TIME)));     // Catch: Throwable -> L42
        LaunchTraceData.access$1002(r4, Long.parseLong(Debug.getRuntimeStat(PerfConsts.ART_GC_BLOCKING_GC_COUNT)));     // Catch: Throwable -> L42
        LaunchTraceData.access$1102(r4, Long.parseLong(Debug.getRuntimeStat(PerfConsts.ART_GC_BLOCKING_GC_TIME)));     // Catch: Throwable -> L42
    L57:
        fetchThreadData(r4);     // Catch: Throwable -> L43
    L36:
        if (r9 != null) goto L55;
    L41:
        return r4;
    L55:
        r9.close();     // Catch: Throwable -> L44
    L32:
        r7 = r9;
    L33:
        r9 = r7;
        goto L53
    L9:
        if (r8.contains("se.statistics.iowait_sum") == true) goto L10;
        if (r8.contains("se.statistics.wait_sum") == true) goto L14;
        if (r8.contains("se.statistics.sum_sleep_runtime") == true) goto L17;
        if (r8.contains("nr_voluntary_switches") == true) goto L20;
        if (r8.contains("nr_involuntary_switches") == true) goto L23;
        if (r8.contains("se.sum_exec_runtime") == false) goto L51;
        LaunchTraceData.access$502(r4, Double.parseDouble(r8.substring(r8.lastIndexOf(" ") + 1)));     // Catch: Throwable -> L11
        goto L51
    L23:
        LaunchTraceData.access$402(r4, Long.parseLong(r8.substring(r8.lastIndexOf(" ") + 1)));     // Catch: Throwable -> L11
        goto L51
    L20:
        LaunchTraceData.access$302(r4, Long.parseLong(r8.substring(r8.lastIndexOf(" ") + 1)));     // Catch: Throwable -> L11
        goto L51
    L17:
        LaunchTraceData.access$202(r4, Double.parseDouble(r8.substring(r8.lastIndexOf(" ") + 1)));     // Catch: Throwable -> L11
        goto L51
    L14:
        LaunchTraceData.access$102(r4, Double.parseDouble(r8.substring(r8.lastIndexOf(" ") + 1)));     // Catch: Throwable -> L11
        goto L51
    L10:
        LaunchTraceData.access$002(r4, Double.parseDouble(r8.substring(r8.lastIndexOf(" ") + 1)));     // Catch: Throwable -> L11
    L11:
        r6 = r7;
    L28:
        r7 = r6;
    L39:
        th = move-exception;
        LaunchAnalysisContext.getInstance().logE("error when fetch launch perf data: " + th.getLocalizedMessage());
        goto L41
    }
}
