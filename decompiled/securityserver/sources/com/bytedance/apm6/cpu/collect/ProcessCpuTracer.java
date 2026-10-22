package com.bytedance.apm6.cpu.collect;

import a.a;
import android.os.Process;
import android.os.SystemClock;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.monitor.collector.PerfMonitorManager;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class ProcessCpuTracer {
    private static final boolean DEBUG = true;
    private static final int[] PROCESS_FULL_STATS_FORMAT = null;
    static final int PROCESS_FULL_STAT_MAJOR_FAULTS = 2;
    static final int PROCESS_FULL_STAT_MINOR_FAULTS = 1;
    static final int PROCESS_FULL_STAT_STIME = 4;
    static final int PROCESS_FULL_STAT_UTIME = 3;
    static final int PROCESS_FULL_STAT_VSIZE = 5;
    private static final int[] PROCESS_STATS_FORMAT = null;
    static final int PROCESS_STAT_MAJOR_FAULTS = 1;
    static final int PROCESS_STAT_MINOR_FAULTS = 0;
    static final int PROCESS_STAT_STIME = 3;
    static final int PROCESS_STAT_UTIME = 2;
    public static final int PROC_CHAR = 2048;
    public static final int PROC_COMBINE = 256;
    public static final int PROC_NEWLINE_TERM = 10;
    public static final int PROC_OUT_FLOAT = 16384;
    public static final int PROC_OUT_LONG = 8192;
    public static final int PROC_OUT_STRING = 4096;
    public static final int PROC_PARENS = 512;
    public static final int PROC_QUOTES = 1024;
    public static final int PROC_SPACE_TERM = 32;
    public static final int PROC_TAB_TERM = 9;
    public static final int PROC_TERM_MASK = 255;
    public static final int PROC_ZERO_TERM = 0;
    private static final String TAG = "ProcessCpuTracker";
    private static final boolean localLOGV = true;
    private int mCpuNumber;
    private boolean mFirst;
    private final long mJiffyMillis;
    private final long[] mProcessFullStatsData;
    private final String[] mProcessFullStatsStringData;
    private final long[] mProcessStatsData;
    private final long[] mSinglePidStatsData;
    private Stats mSt;

    public static class Stats {
        public boolean active;
        public boolean added;
        public String baseName;
        public long base_majfaults;
        public long base_minfaults;
        public long base_stime;
        public long base_uptime;
        public long base_utime;
        public boolean interesting;
        public String name;
        public final int pid;
        public int rel_majfaults;
        public int rel_minfaults;
        public int rel_stime;
        public long rel_uptime;
        public int rel_utime;
        public boolean removed;
        final String statFile;
        public final int uid;
        public long vsize;
        public boolean working;

        public Stats(int r3) {
            this.pid = r3;
            File r0 = new File("/proc", Integer.toString(r3));
            this.uid = getUid(r0.toString());
            this.statFile = new File(r0, CloudControlInf.STAT).toString();
        }

        private static int getUid(String r3) {
            return Os.stat(r3).st_uid;
        L4:
            e = move-exception;
            Log.w(ProcessCpuTracer.TAG, "Failed to stat(" + r3 + "): " + e);
            return -1;
        }
    }

    static {
        PROCESS_STATS_FORMAT = new int[]{32, 544, 32, 32, 32, 32, 32, 32, 32, 8224, 32, 8224, 32, 8224, 8224};
        PROCESS_FULL_STATS_FORMAT = new int[]{32, 4640, 32, 32, 32, 32, 32, 32, 32, 8224, 32, 8224, 32, 8224, 8224, 32, 32, 32, 32, 32, 32, 32, 8224};
    }

    public ProcessCpuTracer() {
        this.mProcessStatsData = new long[4];
        this.mSinglePidStatsData = new long[4];
        this.mProcessFullStatsStringData = new String[6];
        this.mProcessFullStatsData = new long[6];
        this.mFirst = true;
        this.mJiffyMillis = 1000 / Os.sysconf(OsConstants._SC_CLK_TCK);
    }

    private void collectStats(boolean r27) {
        int r1 = Process.myPid();
        Stats r2 = this.mSt;
        if (r2 != null) goto L5;
    L24:
        if (r2 != null) goto L26;
    L30:
        this.mSt = new Stats(r1);
        StringBuilder r3 = a.p(r1, "New  pid ", ": ");
        r3.append(this.mSt);
        Log.v(TAG, r3.toString());
        String[] r4 = this.mProcessFullStatsStringData;
        long[] r11 = this.mProcessFullStatsData;
        this.mSt.base_uptime = SystemClock.uptimeMillis();
        if (PerfMonitorManager.getInstance().readProcFile(this.mSt.statFile.toString(), PROCESS_FULL_STATS_FORMAT, r4, r11, null) == false) goto L33;
        Stats r5 = this.mSt;
        r5.vsize = r11[5];
        r5.interesting = true;
        r5.baseName = r4[0];
        r5.base_minfaults = r11[1];
        r5.base_majfaults = r11[2];
        long r9 = r11[3];
        long r12 = this.mJiffyMillis;
        r5.base_utime = r9 * r12;
        r5.base_stime = r11[4] * r12;
    L34:
        Log.v("Load", "Stats added " + this.mSt.name + " pid=" + this.mSt.pid + " utime=" + this.mSt.base_utime + " stime=" + this.mSt.base_stime + " minfaults=" + this.mSt.base_minfaults + " majfaults=" + this.mSt.base_majfaults);
        Stats r0 = this.mSt;
        r0.rel_utime = 0;
        r0.rel_stime = 0;
        r0.rel_minfaults = 0;
        r0.rel_majfaults = 0;
        r0.added = true;
        if (r27 == false) goto L37;
        return;
    L37:
        if (r0.interesting == false) goto L43;
        r0.working = true;
        return;
    L43:
        return;
    L33:
        Log.w(TAG, "Skipping unknown process pid " + r1);
        Stats r6 = this.mSt;
        r6.baseName = "<unknown>";
        r6.base_stime = 0;
        r6.base_utime = 0;
        r6.base_majfaults = 0;
        r6.base_minfaults = 0;
        goto L34
    L26:
        if (r2.pid > r1) goto L30;
        r2.rel_utime = 0;
        r2.rel_stime = 0;
        r2.rel_minfaults = 0;
        r2.rel_majfaults = 0;
        r2.removed = true;
        r2.working = true;
        StringBuilder r7 = a.p(r1, "Removed  pid ", ": ");
        r7.append(this.mSt);
        Log.v(TAG, r7.toString());
        Stats r8 = this.mSt;
        r8.rel_utime = 0;
        r8.rel_stime = 0;
        r8.rel_minfaults = 0;
        r8.rel_majfaults = 0;
        r8.removed = true;
        r8.working = true;
        return;
    L5:
        if (r2.pid != r1) goto L24;
        r2.added = false;
        r2.working = false;
        StringBuilder r10 = a.p(r1, "Existing  pid ", ": ");
        r10.append(this.mSt);
        Log.v(TAG, r10.toString());
        if (this.mSt.interesting == false) goto L41;
        long r13 = SystemClock.uptimeMillis();
        long[] r14 = this.mProcessStatsData;
        if (PerfMonitorManager.getInstance().readProcFile(this.mSt.statFile.toString(), PROCESS_STATS_FORMAT, null, r14, null) == true) goto L11;
        return;
    L11:
        long r15 = r14[0];
        long r16 = r14[1];
        long r20 = r14[2];
        long r17 = this.mJiffyMillis;
        long r18 = r20 * r17;
        long r19 = r14[3] * r17;
        Stats r110 = this.mSt;
        if (r18 != r110.base_utime) goto L20;
        if (r19 != r110.base_stime) goto L20;
        r110.rel_utime = 0;
        r110.rel_stime = 0;
        r110.rel_minfaults = 0;
        r110.rel_majfaults = 0;
        if (r110.active == false) goto L40;
        r110.active = false;
        return;
    L40:
        return;
    L20:
        if (r110.active == true) goto L22;
        r110.active = true;
    L22:
        Log.v("Load", "Stats changed " + this.mSt.name + " pid=" + this.mSt.pid + " utime=" + r18 + "-" + this.mSt.base_utime + " stime=" + r19 + "-" + this.mSt.base_stime + " minfaults=" + r15 + "-" + this.mSt.base_minfaults + " majfaults=" + r16 + "-" + this.mSt.base_majfaults);
        Stats r21 = this.mSt;
        r21.rel_uptime = r13 - r21.base_uptime;
        r21.base_uptime = r13;
        r21.rel_utime = (int) (r18 - r21.base_utime);
        r21.rel_stime = (int) (r19 - r21.base_stime);
        r21.base_utime = r18;
        r21.base_stime = r19;
        r21.rel_minfaults = (int) (r15 - r21.base_minfaults);
        r21.rel_majfaults = (int) (r16 - r21.base_majfaults);
        r21.base_minfaults = r15;
        r21.base_majfaults = r16;
        r21.working = true;
        return;
    }

    private void printProcessCPU(StringBuffer r18, String r19, int r20, String r21, int r22, int r23, int r24, int r25, int r26, int r27, int r28, int r29) {
        r18.append(r19);
        if (r22 != 0) goto L5;
        int r0 = 1;
    L6:
        long r4 = r0;
        printRatio(r18, (((r23 + r24) + r25) + r26) + r27, r4);
        r18.append("% ");
        if (r20 < 0) goto L9;
        r18.append(r20);
        r18.append(LibrarianImpl.Constants.SEPARATOR);
    L9:
        r18.append(r21);
        r18.append(": ");
        printRatio(r18, r23, r4);
        r18.append("% user + ");
        printRatio(r18, r24, r4);
        r18.append("% kernel");
        if (r25 <= 0) goto L12;
        r18.append(" + ");
        printRatio(r18, r25, r4);
        r18.append("% iowait");
    L12:
        if (r26 <= 0) goto L14;
        r18.append(" + ");
        printRatio(r18, r26, r4);
        r18.append("% irq");
    L14:
        if (r27 <= 0) goto L16;
        r18.append(" + ");
        printRatio(r18, r27, r4);
        r18.append("% softirq");
    L16:
        if (r28 > 0) goto L18;
        if (r29 > 0) goto L18;
        return;
    L18:
        r18.append(" / faults:");
        if (r28 <= 0) goto L21;
        r18.append(" ");
        r18.append(r28);
        r18.append(" minor");
    L21:
        if (r29 <= 0) goto L25;
        r18.append(" ");
        r18.append(r29);
        r18.append(" major");
        return;
    L25:
        return;
    L5:
        r0 = r22;
        goto L6
    }

    private void printRatio(StringBuffer r3, long r4, long r6) {
        long r5 = (r4 * 1000) / r6;
        long r0 = r5 / 10;
        r3.append(r0);
        if (r0 >= 10) goto L8;
        long r7 = r5 - (r0 * 10);
        if (r7 == 0) goto L9;
        r3.append('.');
        r3.append(r7);
        return;
    L9:
        return;
    }

    public float getProcessCpuPercent() {
        if (this.mCpuNumber > 0) goto L7;
        return 0.0f;
    L7:
        return getProcessCpuPercentAllCore() / this.mCpuNumber;
    }

    public float getProcessCpuPercentAllCore() {
        Stats r7 = this.mSt;
        if (r7 != null) goto L5;
        return 0.0f;
    L5:
        long r1 = r7.rel_utime + r7.rel_stime;
        long r3 = (int) r7.rel_uptime;
        if (r3 > 0) goto L9;
        return 0.0f;
    L9:
        return (float) (((r1 * 1000) / r3) / 10.0d);
    }

    public void init() {
        Log.v(TAG, "Init: " + this);
        this.mFirst = true;
        this.mCpuNumber = Runtime.getRuntime().availableProcessors();
        update();
    }

    public String printCurrentState() {
        StringBuffer r13 = new StringBuffer();
        Stats r0 = this.mSt;
        if (r0.added == false) goto L7;
        String r1 = " +";
    L5:
        String r2 = r1;
        printProcessCPU(r13, r2, r0.pid, r0.baseName, (int) r0.rel_uptime, r0.rel_utime, r0.rel_stime, 0, 0, 0, r0.rel_minfaults, r0.rel_majfaults);
        return r13.toString();
    L7:
        if (r0.removed == false) goto L9;
        r1 = " -";
        goto L5
    L9:
        r1 = "  ";
        goto L5
    }

    public void update() {
        Log.v(TAG, "Update: " + this);
        if (PerfMonitorManager.isSoLoaded() == true) goto L11;
        return;
    L11:
        collectStats(this.mFirst);     // Catch: Exception -> L7
    L9:
        this.mFirst = false;
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }
}
