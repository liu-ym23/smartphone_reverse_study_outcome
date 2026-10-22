package com.bytedance.watson.assist.file;

import android.util.Log;
import com.bytedance.watson.assist.core.cpu.CpuTimeStatInfo;
import com.bytedance.watson.assist.utils.CpuUtils;
import com.bytedance.watson.assist.utils.DebugLog;
import com.bytedance.watson.assist.utils.FileUtils;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SystemPolicyTimeInStateFile extends BaseStatFile {
    private static final int INDEX_FREQ = 0;
    private static final int INDEX_TIME = 1;
    private static final String PATH_PREFIX = "/sys/devices/system/cpu/cpufreq/";
    private static final String PATH_SUFFIX = "/stats/time_in_state";
    private List<Integer> cpuNumList;
    private List<File> fileList;

    public SystemPolicyTimeInStateFile(String r1) {
        super(r1);
        this.fileList = new ArrayList();
        this.cpuNumList = new ArrayList();
    }

    private FileStatInfo doRead(List<File> r6, List<Integer> r7) {
        if (r6 != null) goto L4;
        return null;
    L4:
        if (r6.isEmpty() == true) goto L23;
        if (r7 != null) goto L7;
        return null;
    L7:
        if (r7.isEmpty() == false) goto L9;
        return null;
    L9:
        if (r6.size() != r7.size()) goto L26;
        CpuTimeStatInfo r0 = new CpuTimeStatInfo();
        int r1 = r6.size();
        int r2 = 0;
    L12:
        if (r2 >= r1) goto L17;
        LinkedHashMap<Long, Long> r3 = parseFile(r6.get(r2), r7.get(r2).intValue());
        if (r3 == null) goto L16;
        r0.putFreqTimeMap(r3);
    L16:
        r2 = r2 + 1;
        goto L12
    L17:
        return r0;
    L26:
        return null;
    L23:
        return null;
    }

    private LinkedHashMap<Long, Long> parseFile(File r8, int r9) {
        BufferedReader r7 = FileUtils.openFile(r8);
        LinkedHashMap<Long, Long> r10 = null;
        if (r7 != null) goto L26;
        return null;
    L26:
        String r0 = r7.readLine();     // Catch: Exception -> L15 Throwable -> L24
        if (r0 == null) goto L19;
        if (r0.isEmpty() == true) goto L19;
        String[] r1 = r0.split(" ");     // Catch: Exception -> L15 Throwable -> L24
        if (r1.length <= 1) goto L19;
        if (r10 != null) goto L17;
        r10 = new LinkedHashMap();     // Catch: Exception -> L15 Throwable -> L24
    L17:
        r10.put(Long.valueOf(Long.parseLong(r1[0])), Long.valueOf(((long) (r9 * 10)) * Long.parseLong(r1[1])));     // Catch: Exception -> L15 Throwable -> L24
    L19:
        FileUtils.closeFile(r7);
        return r10;
    L24:
        FileUtils.closeFile(r7);
        return r10;
    L15:
        e = move-exception;
        DebugLog.e(Log.getStackTraceString(e));     // Catch: Throwable -> L24
        FileUtils.closeFile(r7);
        return r10;
    }

    @Override // com.bytedance.watson.assist.file.BaseStatFile
    public FileStatInfo refresh() {
        if (this.fileList.isEmpty() == false) goto L12;
        List<CpuUtils.CpuClusterInfo> r0 = CpuUtils.getCpuClusterInfoList();
        if (r0 != null) goto L8;
        return null;
    L8:
        Iterator<CpuUtils.CpuClusterInfo> r1 = r0.iterator();
    L10:
        if (r1.hasNext() == false) goto L12;
        CpuUtils.CpuClusterInfo r2 = r1.next();
        this.fileList.add(new File(PATH_PREFIX + r2.getName() + PATH_SUFFIX));
        this.cpuNumList.add(Integer.valueOf(r2.getAffectedCpuList().size()));
    L12:
        FileStatInfo r3 = doRead(this.fileList, this.cpuNumList);
        this.mLastInfo = r3;
        return r3;
    }

    public SystemPolicyTimeInStateFile() {
        super("");
        this.fileList = new ArrayList();
        this.cpuNumList = new ArrayList();
    }
}
