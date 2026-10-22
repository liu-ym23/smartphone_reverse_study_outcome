package com.bytedance.apm.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.system.Os;
import android.system.OsConstants;
import android.text.TextUtils;
import com.android.settings.utils.HanziToPinyin;
import com.bytedance.apm.ApmContext;
import com.bytedance.monitor.util.IoUtil;
import com.bytedance.platform.godzilla.common.Constant;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class CommonMonitorUtil {
    public static final int BUFFER_SIZE = 8192;
    public static final String CACHE = "cache";
    public static final long DEFAULT_CLOCK_TICKS_PER_SECOND = 100;
    private static final int ERROR_RESULT = -1;
    public static final long KB = 1024;
    public static final String MEMORY_INFO_PATH = "/proc/meminfo";
    public static final String OUTSIDE_STORAGE = "/Android/data/";
    private static final String PATH_PREFIX = "/sys/devices/system/cpu/cpu";
    private static final String PATH_SUFFIX = "/cpufreq/stats/time_in_state";
    public static final String PROC_STAT_FILE = "/proc/stat";
    private static int isSysProcCanRead = 0;
    private static long sClkTck = -1;
    private static int sCpuCoreNum = 0;
    private static long sMaxMemory = -1;

    static {
    }

    public CommonMonitorUtil() {
    }

    public static boolean isProcStatCanRead() {
        int r0 = isSysProcCanRead;
        if (r0 != 0) goto L12;
        File r1 = new File("/proc/stat");
        if (r1.exists() == true) goto L7;
    L10:
        isSysProcCanRead = 2;
        return false;
    L7:
        if (r1.canRead() == false) goto L10;
        isSysProcCanRead = 1;
        return true;
    L12:
        if (r0 == 1) goto L14;
        return false;
    L14:
        return true;
    }

    public static long getTotalCPUTime() {
        BufferedReader r0 = null;
        BufferedReader r1 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/stat")), 1000);     // Catch: Throwable -> L10
        String r2 = r1.readLine();     // Catch: Throwable -> L7
        r1.close();     // Catch: Throwable -> L7
        String[] r3 = r2.split(HanziToPinyin.Token.SEPARATOR);     // Catch: Throwable -> L7
        long r4 = (((((Long.parseLong(r3[2]) + Long.parseLong(r3[3])) + Long.parseLong(r3[4])) + Long.parseLong(r3[6])) + Long.parseLong(r3[5])) + Long.parseLong(r3[7])) + Long.parseLong(r3[8]);
        IoUtil.safeClose(r1);
        return r4;
    L7:
        r0 = r1;
    L8:
        IoUtil.safeClose(r0);
        return -1;
    }

    public static long getTotalCPUTimeByTimeInStat() {
        int r0 = getCpuCoreNum();
        long r1 = -1;
        if (r0 > 0) goto L5;
        return -1;
    L5:
        int r3 = 0;
    L6:
        if (r3 >= r0) goto L26;
        BufferedReader r4 = null;
        BufferedReader r5 = new BufferedReader(new FileReader(PATH_PREFIX + r3 + PATH_SUFFIX), 50);     // Catch: Throwable -> L22
    L30:
        String r6 = r5.readLine();     // Catch: Throwable -> L20
        if (r6 != null) goto L12;
    L28:
        r5.close();     // Catch: Throwable -> L27
        r3 = r3 + 1;     // Catch: Throwable -> L27
        goto L6
    L12:
        if (r6.isEmpty() == true) goto L28;
        String[] r7 = r6.split("\\s+");     // Catch: Throwable -> L20
        if (r7.length != 2) goto L30;
        r1 = r1 + Long.parseLong(r7[1]);
    L20:
        th = th;
        r4 = r5;
    L23:
        if (r4 == null) goto L25;
        r4.close();     // Catch: Throwable -> L27
    L25:
        throw th;     // Catch: Throwable -> L27
    L22:
        th = th;
    L26:
        return r1;
    }

    public static synchronized int getCpuCoreNum() {
        monitor-enter(CommonMonitorUtil.class);
        int r1 = sCpuCoreNum;     // Catch: Throwable -> L27
        if (r1 == 0) goto L37;
        monitor-exit(CommonMonitorUtil.class);
        return r1;
    L37:
        BufferedReader r2 = new BufferedReader(new FileReader("/proc/cpuinfo"), 50);     // Catch: Throwable -> L19
        int r3 = 0;
    L31:
        String r4 = r2.readLine();     // Catch: Throwable -> L17
        if (r4 == null) goto L16;
        if (r4.startsWith("processor") == false) goto L31;
        r3 = r3 + 1;
        goto L31
    L16:
        r2.close();     // Catch: Throwable -> L30
        sCpuCoreNum = r3;     // Catch: Throwable -> L30
    L17:
        Throwable th = th;
    L21:
        if (r2 == null) goto L43;
        r2.close();     // Catch: Throwable -> L30
        throw th;     // Catch: Throwable -> L30
    L43:
        throw th;     // Catch: Throwable -> L30
    L19:
        th = move-exception;
        r2 = null;
        th = th;
    L24:
        int r5 = sCpuCoreNum;     // Catch: Throwable -> L27
        monitor-exit(CommonMonitorUtil.class);
        return r5;
    L27:
        th = move-exception;
        throw th;
    }

    public static long getAppCPUTime() {
        return getPidCPUTime(Process.myPid());
    }

    public static long getPidCPUTime(int r6) {
        BufferedReader r1 = null;
        BufferedReader r2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + r6 + "/stat")), 1000);     // Catch: Throwable -> L10
        String r7 = r2.readLine();     // Catch: Throwable -> L7
        r2.close();     // Catch: Throwable -> L7
        String[] r8 = r7.split(HanziToPinyin.Token.SEPARATOR);     // Catch: Throwable -> L7
        long r0 = ((Long.parseLong(r8[13]) + Long.parseLong(r8[14])) + Long.parseLong(r8[15])) + Long.parseLong(r8[16]);
        IoUtil.safeClose(r2);
        return r0;
    L7:
        r1 = r2;
    L8:
        IoUtil.safeClose(r1);
        return -1;
    }

    public static long getAppCpuActiveTime() {
        BufferedReader r2 = null;
        BufferedReader r3 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/stat")), 1000);     // Catch: Throwable -> L10 Exception -> L15
        String r0 = r3.readLine();     // Catch: Throwable -> L7 Exception -> L9
        r3.close();     // Catch: Throwable -> L7 Exception -> L9
        String[] r1 = r0.split(HanziToPinyin.Token.SEPARATOR);     // Catch: Throwable -> L7 Exception -> L9
        long r4 = Long.parseLong(r1[13]) + Long.parseLong(r1[14]);
        IoUtil.safeClose(r3);
        return r4;
    L9:
        r2 = r3;
    L7:
        th = th;
        r2 = r3;
    L11:
        IoUtil.safeClose(r2);
        throw th;
    L10:
        th = th;
    L13:
        IoUtil.safeClose(r2);
        return -1;
    }

    public static long getVmSize() {
        int r2 = 0;
        String[] r0 = getStringFromFile(String.format("/proc/%s/status", new Object[]{Integer.valueOf(getMyPid())})).trim().split("\n");     // Catch: Exception -> L20
        int r1 = r0.length;     // Catch: Exception -> L20
    L5:
        if (r2 >= r1) goto L14;
        String r6 = r0[r2];     // Catch: Exception -> L20
        if (r6.startsWith("VmSize") == false) goto L12;
        Matcher r5 = Pattern.compile("\\d+").matcher(r6);     // Catch: Exception -> L20
        if (r5.find() == false) goto L12;
        return Long.parseLong(r5.group());
    L12:
        r2 = r2 + 1;     // Catch: Exception -> L20
        goto L5
    L14:
        if (r0.length <= 12) goto L19;
        Matcher r3 = Pattern.compile("\\d+").matcher(r0[12]);     // Catch: Exception -> L20
        if (r3.find() == false) goto L19;
        return Long.parseLong(r3.group());
    L19:
        return -1;
    }

    public static int getMyPid() {
        return Process.myPid();
    }

    public static String getStringFromFile(String r2) throws Exception {
        FileInputStream r1 = new FileInputStream(new File(r2));     // Catch: Throwable -> L9
        String r3 = convertStreamToString(r1);     // Catch: Throwable -> L7
        r1.close();
        return r3;
    L7:
        Throwable th = th;
    L11:
        if (r1 == null) goto L13;
        r1.close();
    L13:
        throw th;
    L9:
        th = move-exception;
        r1 = null;
        th = th;
        goto L11
    }

    public static String convertStreamToString(InputStream r4) throws Exception {
        StringBuilder r0 = new StringBuilder();
        BufferedReader r1 = null;
        BufferedReader r2 = new BufferedReader(new InputStreamReader(r4));     // Catch: Throwable -> L12
    L16:
        String r5 = r2.readLine();     // Catch: Throwable -> L10
        if (r5 == null) goto L8;
        r0.append(r5).append('\n');     // Catch: Throwable -> L10
        goto L16
    L8:
        r2.close();
        return r0.toString();
    L10:
        th = th;
        r1 = r2;
    L13:
        if (r1 == null) goto L15;
        r1.close();
    L15:
        throw th;
    L12:
        th = th;
        goto L13
    }

    public static long getIdleCPUTime() {
        BufferedReader r0 = null;
        BufferedReader r1 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/stat")), 1000);     // Catch: Throwable -> L10 Exception -> L16
        goto L14
    L19:
        String r2 = r1.readLine();     // Catch: Throwable -> L7 Exception -> L9
        r1.close();     // Catch: Throwable -> L7 Exception -> L9
        long r3 = Long.parseLong(r2.split(HanziToPinyin.Token.SEPARATOR)[5]);     // Catch: Throwable -> L7 Exception -> L9
        IoUtil.safeClose(r1);
        return r3;
    L9:
        r0 = r1;
    L7:
        Throwable th = th;
    L12:
        IoUtil.safeClose(r1);
        throw th;
    L10:
        th = move-exception;
        r1 = null;
        th = th;
    L14:
        IoUtil.safeClose(r0);
        return -1;
    }

    public static int getAPPMemLimit(Context r2) {
        if (r2 != null) goto L5;
        return -1;
    L5:
        ActivityManager r3 = (ActivityManager) r2.getSystemService("activity");
        if (r3 != null) goto L9;
        return -1;
    L9:
        return r3.getMemoryClass();
    }

    public static long getRuntimeMaxMemory() {
        if (sMaxMemory != (-1)) goto L6;
        sMaxMemory = Runtime.getRuntime().maxMemory();     // Catch: Exception -> L7
    L6:
        return sMaxMemory;
    }

    public static int getPidMemorySize(int r3, Context r4) {
        if (r4 != null) goto L11;
        return -1;
    L11:
        ActivityManager r5 = (ActivityManager) r4.getSystemService("activity");     // Catch: Exception -> L10
        if (r5 != null) goto L8;
        return -1;
    L8:
        return r5.getProcessMemoryInfo(new int[]{r3})[0].dalvikPss;
    L10:
        return -1;
    }

    public static Debug.MemoryInfo getPidMemoryInfo(int r3, Context r4) {
        if (r4 != null) goto L11;
        return null;
    L11:
        ActivityManager r5 = (ActivityManager) r4.getSystemService("activity");     // Catch: Exception -> L10
        if (r5 != null) goto L8;
        return null;
    L8:
        return r5.getProcessMemoryInfo(new int[]{r3})[0];
    L10:
        return null;
    }

    public static long getFreeMemory(Context r4) {
        if (r4 != null) goto L5;
        return -1;
    L5:
        ActivityManager.MemoryInfo r2 = new ActivityManager.MemoryInfo();
        ActivityManager r5 = (ActivityManager) r4.getSystemService("activity");
        if (r5 != null) goto L8;
        return -1;
    L8:
        r5.getMemoryInfo(r2);
        return r2.availMem / 1024;
    }

    public static long getTotalMemory(Context r4) {
        if (r4 != null) goto L5;
        return -1;
    L5:
        ActivityManager.MemoryInfo r2 = new ActivityManager.MemoryInfo();
        ActivityManager r5 = (ActivityManager) r4.getSystemService("activity");
        if (r5 != null) goto L8;
        return -1;
    L8:
        r5.getMemoryInfo(r2);
        return r2.totalMem / 1024;
    }

    public static void getMemMonitorInfo(JSONObject r5, Context r6, int r7) {
        if (r5 == null) goto L14;
        if (r6 == null) goto L15;
        ActivityManager r0 = (ActivityManager) r6.getSystemService("activity");
        if (r0 != null) goto L8;
        return;
    L8:
        Debug.MemoryInfo[] r8 = r0.getProcessMemoryInfo(new int[]{r7});
        r5.put("total_mem", getTotalMemory(r6));     // Catch: JSONException -> L11
        r5.put("mem_class", getAPPMemLimit(r6));     // Catch: JSONException -> L11
        r5.put("dalvik_used_mem", r8[0].dalvikPss / 1024);     // Catch: JSONException -> L11
        r5.put("native_heap_size", r8[0].nativePss / 1024);     // Catch: JSONException -> L11
        return;
    L16:
        return;
    L15:
        return;
    }

    public static long getUsedStorageSize(Context r5) {
        if (r5 != null) goto L19;
        return -1;
    L19:
        File r2 = new File(r5.getFilesDir().getParent());     // Catch: Throwable -> L18
        if (r2.exists() == true) goto L8;
        return -1;
    L8:
        long r3 = getFileDirSize(r2);     // Catch: Throwable -> L18
        File r6 = r5.getExternalFilesDir(null);     // Catch: Throwable -> L18
        if (r6 == null) goto L17;
        File r7 = r6.getParentFile();     // Catch: Throwable -> L18
        if (r7.exists() == false) goto L14;
        long r0 = getFileDirSize(r7);     // Catch: Throwable -> L18
    L16:
        return r3 + r0;
    L14:
        r0 = 0;
    L17:
        return -1;
    }

    public static long getDiskTotalSize() {
        File r0 = Environment.getRootDirectory();
        return getExternalStorageSize() + getFileTotalSize(r0);
    }

    protected static long getExternalStorageSize() {
        if ("mounted".equals(Environment.getExternalStorageState()) == false) goto L6;
        return getFileTotalSize(FileUtils.getExternalRootDir(ApmContext.getContext()));
    L6:
        return 0;
    L11:
        return 0;
    }

    public static long getFileTotalSize(File r2) {
        return new StatFs(r2.getPath()).getTotalBytes();
    L4:
        return 0;
    }

    public static long getFileDirSize(File r6) {
        File[] r7 = r6.listFiles();
        long r0 = 0;
        if (r7 != null) goto L5;
        return 0;
    L5:
        int r2 = r7.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L12;
        File r4 = r7[r3];
        if (r4.isDirectory() == false) goto L10;
        long r5 = getFileDirSize(r4);
    L11:
        r0 = r0 + r5;
        r3 = r3 + 1;
        goto L6
    L10:
        r5 = r4.length();
        goto L11
    L12:
        return r0;
    }

    public static long getUsedCacheSize(Context r7) {
        if (r7 != null) goto L18;
        return -1;
    L18:
    L17:
        return -1;
    L6:
        if (TextUtils.isEmpty(r7.getPackageName()) == false) goto L8;
        return -1;
    L8:
        File r8 = r7.getCacheDir();     // Catch: Throwable -> L17
        long r3 = 0;
        if (r8.exists() == false) goto L11;
        long r5 = getFileDirSize(r8);     // Catch: Throwable -> L17
    L12:
        File r9 = ApmContext.getContext().getExternalCacheDir();     // Catch: Throwable -> L17
        if (r9.exists() == false) goto L16;
        r3 = getFileDirSize(r9);     // Catch: Throwable -> L17
    L16:
        return r5 + r3;
    L11:
        r5 = 0;
        goto L12
    }

    public static Pair<Long, Long> getTrafficBytes(Context r19) {
        int r0 = Process.myUid();
        Iterator<String> r1 = TrafficUtils.readFile2List(new File("/proc/net/xt_qtaguid/stats"), Constant.CHARSET_UTF_8).iterator();
        long r2 = 0;
        long r4 = 0;
        long r6 = 0;
        long r8 = 0;
        long r10 = 0;
    L4:
        if (r1.hasNext() == false) goto L13;
        String[] r12 = r1.next().split(HanziToPinyin.Token.SEPARATOR);
        if (r0 != Integer.parseInt(r12[3])) goto L4;
        long r13 = Long.parseLong(r12[5]);     // Catch: NumberFormatException -> L22
        long r15 = Long.parseLong(r12[7]);     // Catch: NumberFormatException -> L22
        if (Long.valueOf(r12[4]).longValue() == 0) goto L11;
        r4 = r4 + r13;
        r6 = r6 + r15;
        goto L4
    L11:
        r8 = r8 + r13;
        r10 = r10 + r15;
        goto L4
    L13:
        long r5 = r4 + r6;
        long r9 = r8 + r10;
        if (r5 >= 0) goto L17;
        r5 = 0;
    L17:
        if (r9 < 0) goto L21;
        r2 = r9;
    L21:
        return new Pair(Long.valueOf(r5), Long.valueOf(r2));
    }

    public static long getScClkTck(long r4) {
        if (sClkTck != (-1)) goto L9;
        long r0 = Os.sysconf(OsConstants._SC_CLK_TCK);
        if (r0 <= 0) goto L7;
        r4 = r0;
    L7:
        sClkTck = r4;
    L9:
        return sClkTck;
    }

    private static long fromLibcore(long r8) {
        int r0 = Class.forName("libcore.io.OsConstants").getField("_SC_CLK_TCK").getInt(null);     // Catch: Exception -> L4
        Class<?> r2 = Class.forName("libcore.io.Libcore");     // Catch: Exception -> L4
        Class<?> r3 = Class.forName("libcore.io.Os");     // Catch: Exception -> L4
        Object r1 = r2.getField("os").get(null);     // Catch: Exception -> L4
        return ((Long) r3.getMethod("sysconf", new Class[]{Integer.TYPE}).invoke(r1, new Object[]{Integer.valueOf(r0)})).longValue();
    L7:
        return r8;
    }
}
