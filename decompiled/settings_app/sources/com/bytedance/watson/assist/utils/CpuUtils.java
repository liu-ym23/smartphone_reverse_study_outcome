package com.bytedance.watson.assist.utils;

import android.util.Log;
import com.bytedance.librarian.LibrarianImpl;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class CpuUtils {
    private static List<Integer> CLUSTER_AFFECT_CPU_NUM = null;
    private static final String CPU_CLUSTER_DIR = "/sys/devices/system/cpu/cpufreq";
    private static List<CpuClusterInfo> CPU_CLUSTER_INFO_LIST = null;
    private static int CPU_CORE_NUM = -1;
    private static final String CPU_CUR_FREQ_PATH = "/scaling_cur_freq";
    private static final String CPU_DIR = "/sys/devices/system/cpu";
    private static String CPU_HARDWARE = null;
    private static String CPU_HARDWARE_FROM_PROP = null;
    private static final String CPU_HARDWARE_PROP = "ro.board.platform";
    private static final String CPU_IDLE_PREFIX_DIR = "/sys/devices/system/cpu/cpu";
    private static List<Integer> CPU_IDLE_STATE_NUM_LIST = null;
    private static final String CPU_IDLE_SUFFIX_DIR = "/cpuidle";
    private static final String CPU_SCALING_MAX_FREQ_PATH = "/scaling_max_freq";
    private static final String CPU_SCALING_MIN_FREQ_PATH = "/scaling_min_freq";
    private static final String PROC_CPU_PATH = "/proc/cpuinfo";
    public static final int kClockTicksMs = 10;

    public static class CpuClusterInfo {
        private List<Integer> affectedCpuList;
        private List<Long> freqList;
        private String name;

        public CpuClusterInfo(String r2) {
            this.affectedCpuList = new ArrayList();
            this.freqList = new ArrayList();
            this.name = r2;
        }

        public String getName() {
            return this.name;
        }

        public List<Integer> getAffectedCpuList() {
            return this.affectedCpuList;
        }

        public void setAffectedCpuList(List<Integer> r1) {
            this.affectedCpuList = r1;
        }

        public List<Long> getFreqList() {
            return this.freqList;
        }

        public void setFreqList(List<Long> r1) {
            this.freqList = r1;
        }

        public String toString() {
            return "CpuClusterInfo{name='" + this.name + "', affectedCpuList=" + this.affectedCpuList + ", freqList=" + this.freqList + '}';
        }
    }

    static {
    }

    public CpuUtils() {
    }

    static /* synthetic */ String access$002(String r0) {
        CPU_HARDWARE = r0;
        return r0;
    }

    public static int getCpuCoreNum() {
        if (CPU_CORE_NUM != (-1)) goto L10;
        File[] r0 = new File(CPU_DIR).listFiles(new AnonymousClass1());
        if (r0 != null) goto L7;
        int r1 = 1;
    L8:
        CPU_CORE_NUM = r1;
        goto L10
    L7:
        r1 = r0.length;
    L10:
        return CPU_CORE_NUM;
    }

    public static synchronized List<Integer> getCpuIdleStateNumList() {
        monitor-enter(CpuUtils.class);
        List<Integer> r1 = CPU_IDLE_STATE_NUM_LIST;     // Catch: Throwable -> L24
        if (r1 == null) goto L8;
        monitor-exit(CpuUtils.class);
        return r1;
    L8:
        int r2 = getCpuCoreNum();     // Catch: Throwable -> L24
        if (r2 != (-1)) goto L14;
        monitor-exit(CpuUtils.class);
        return null;
    L14:
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L24
        int r4 = 0;
    L15:
        if (r4 >= r2) goto L21;
        File[] r5 = new File(CPU_IDLE_PREFIX_DIR + r4 + CPU_IDLE_SUFFIX_DIR).listFiles(new AnonymousClass2());     // Catch: Throwable -> L24
        if (r5 != null) goto L19;
        int r6 = 0;
    L20:
        r3.add(Integer.valueOf(r6));     // Catch: Throwable -> L24
        r4 = r4 + 1;     // Catch: Throwable -> L24
        goto L15
    L19:
        r6 = r5.length;     // Catch: Throwable -> L24
        goto L20
    L21:
        CPU_IDLE_STATE_NUM_LIST = r3;     // Catch: Throwable -> L24
        monitor-exit(CpuUtils.class);
        return r3;
    L24:
        th = move-exception;
        throw th;
    }

    public static int getCpuIdleStateNum(int r2) {
        if (CPU_IDLE_STATE_NUM_LIST != null) goto L8;
        getCpuIdleStateNumList();
        if (CPU_IDLE_STATE_NUM_LIST != null) goto L8;
        return -1;
    L8:
        if (r2 < CPU_IDLE_STATE_NUM_LIST.size()) goto L11;
        return -1;
    L11:
        return CPU_IDLE_STATE_NUM_LIST.get(r2).intValue();
    }

    public static String getCpuHardware() {
        String r0 = CPU_HARDWARE;
        if (r0 == null) goto L5;
        return r0;
    L5:
        FileUtils.readFile(PROC_CPU_PATH, new AnonymousClass3());
        return CPU_HARDWARE;
    }

    public static String getCpuHardwareFromProp() {
        String r0 = CPU_HARDWARE_FROM_PROP;
        if (r0 == null) goto L5;
        return r0;
    L5:
        String r1 = SystemProperties.get(CPU_HARDWARE_PROP, "");
        CPU_HARDWARE_FROM_PROP = r1;
        return r1;
    }

    public static synchronized List<CpuClusterInfo> getCpuClusterInfoList() {
        monitor-enter(CpuUtils.class);
        List<CpuClusterInfo> r1 = CPU_CLUSTER_INFO_LIST;     // Catch: Throwable -> L18
        if (r1 == null) goto L8;
        monitor-exit(CpuUtils.class);
        return r1;
    L8:
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L18
        File[] r3 = new File(CPU_CLUSTER_DIR).listFiles(new AnonymousClass4());     // Catch: Throwable -> L18
        if (r3 != null) goto L11;
    L15:
        CPU_CLUSTER_INFO_LIST = r2;     // Catch: Throwable -> L18
        monitor-exit(CpuUtils.class);
        return r2;
    L11:
        if (r3.length <= 0) goto L15;
        Arrays.sort(r3, new AnonymousClass5());     // Catch: Throwable -> L18
        int r4 = r3.length;     // Catch: Throwable -> L18
        int r5 = 0;
    L13:
        if (r5 >= r4) goto L15;
        File r6 = r3[r5];     // Catch: Throwable -> L18
        CpuClusterInfo r7 = new CpuClusterInfo(r6.getName());     // Catch: Throwable -> L18
        final ArrayList r8 = new ArrayList();     // Catch: Throwable -> L18
        final ArrayList r9 = new ArrayList();     // Catch: Throwable -> L18
        FileUtils.readFile(r6.getAbsolutePath() + "/scaling_available_frequencies", new AnonymousClass6(r8));     // Catch: Throwable -> L18
        FileUtils.readFile(r6.getAbsolutePath() + "/affected_cpus", new AnonymousClass7(r9));     // Catch: Throwable -> L18
        r7.setFreqList(r8);     // Catch: Throwable -> L18
        r7.setAffectedCpuList(r9);     // Catch: Throwable -> L18
        r2.add(r7);     // Catch: Throwable -> L18
        r5 = r5 + 1;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public static synchronized List<Integer> getClusterCpuNum() {
        monitor-enter(CpuUtils.class);
        List<Integer> r1 = CLUSTER_AFFECT_CPU_NUM;     // Catch: Throwable -> L15
        if (r1 == null) goto L8;
        monitor-exit(CpuUtils.class);
        return r1;
    L8:
        List<CpuClusterInfo> r2 = getCpuClusterInfoList();     // Catch: Throwable -> L15
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L15
        Iterator<CpuClusterInfo> r4 = r2.iterator();     // Catch: Throwable -> L15
    L10:
        if (r4.hasNext() == false) goto L12;
        r3.add(Integer.valueOf(r4.next().getAffectedCpuList().size()));     // Catch: Throwable -> L15
        goto L10
    L12:
        CLUSTER_AFFECT_CPU_NUM = r3;     // Catch: Throwable -> L15
        monitor-exit(CpuUtils.class);
        return r3;
    L15:
        th = move-exception;
        throw th;
    }

    public static boolean isClusterLockFreq(int r6) {
        long r0 = getClusterMaxFreq(r6);
        long r2 = getClusterMinFreq(r6);
        if (r0 != (-1)) goto L5;
        return false;
    L5:
        if (r2 != (-1)) goto L7;
        return false;
    L7:
        if (r0 != r2) goto L13;
        return true;
    L13:
        return false;
    }

    public static long getClusterCurrentFreq(int r2) {
        return getClusterFreq(r2, CPU_CUR_FREQ_PATH);
    }

    public static long getClusterMinFreq(int r2) {
        return getClusterFreq(r2, CPU_SCALING_MIN_FREQ_PATH);
    }

    public static long getClusterMaxFreq(int r2) {
        return getClusterFreq(r2, CPU_SCALING_MAX_FREQ_PATH);
    }

    public static int getClusterCurrentFreqLevel(int r2) {
        return getFreqLevel(r2, getClusterFreq(r2, CPU_CUR_FREQ_PATH));
    }

    public static int getClusterMinFreqLevelLevel(int r2) {
        return getFreqLevel(r2, getClusterFreq(r2, CPU_SCALING_MIN_FREQ_PATH));
    }

    public static int getClusterMaxFreqLevel(int r2) {
        return getFreqLevel(r2, getClusterFreq(r2, CPU_SCALING_MAX_FREQ_PATH));
    }

    private static long getClusterFreq(int r5, String r6) {
        Long r1 = -1L;
        if (r5 < 0) goto L29;
        if (r6 == null) goto L29;
        List<CpuClusterInfo> r2 = getCpuClusterInfoList();
        String r3 = LibrarianImpl.Constants.SEPARATOR;
        if (r2 != null) goto L9;
    L11:
        BufferedReader r7 = FileUtils.openFile(new File(CPU_CLUSTER_DIR + r3 + r6));
        if (r7 == null) goto L14;
        String r4 = r7.readLine();     // Catch: Throwable -> L19 Exception -> L21
        if (r4 == null) goto L18;
        r1 = Long.valueOf(Long.parseLong(r4));     // Catch: Throwable -> L19 Exception -> L21
    L18:
        FileUtils.closeFile(r7);
        return r1.longValue();
    L21:
        e = move-exception;
        DebugLog.w("get cluster freq error : " + r6 + Log.getStackTraceString(e));     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        FileUtils.closeFile(r7);
        throw th;
    L14:
        return r1.longValue();
    L9:
        if (r2.size() <= r5) goto L11;
        r3 = LibrarianImpl.Constants.SEPARATOR + r2.get(r5).getName();
    L29:
        return r1.longValue();
    }

    public static int getFreqLevel(int r5, long r6) {
        if (r5 >= 0) goto L5;
    L26:
        return -1;
    L5:
        if (r6 <= 0) goto L26;
        List<CpuClusterInfo> r1 = getCpuClusterInfoList();
        if (r1 == null) goto L26;
        if (r1.size() < (r5 + 1)) goto L26;
        CpuClusterInfo r7 = r1.get(r5);
        if (r7 == null) goto L26;
        if (r7.getFreqList() == null) goto L26;
        int r2 = r7.getFreqList().size();
        int r3 = 0;
    L18:
        if (r3 >= r2) goto L26;
        if (r7.getFreqList().get(r3).longValue() == r6) goto L21;
        r3 = r3 + 1;
        goto L18
    L21:
        int r4 = r3 / (r2 / 4);
        if (r4 > 3) goto L24;
        return r4;
    L24:
        return 3;
    }
}
