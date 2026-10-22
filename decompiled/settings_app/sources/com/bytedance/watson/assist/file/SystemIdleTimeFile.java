package com.bytedance.watson.assist.file;

import android.util.Log;
import com.bytedance.watson.assist.core.cpu.CpuIdleTimeStatInfo;
import com.bytedance.watson.assist.utils.CpuUtils;
import com.bytedance.watson.assist.utils.DebugLog;
import com.bytedance.watson.assist.utils.FileUtils;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class SystemIdleTimeFile extends BaseStatFile {
    private static final String PATH_PREFIX = "/sys/devices/system/cpu/cpu";
    private static final String PATH_SUB_PREFIX = "/cpuidle/state";
    private static final String PATH_SUFFIX = "/time";
    private int cpuNum;
    private List<List<File>> fileList;
    private List<Integer> idleStateNumList;
    private boolean inited;

    public SystemIdleTimeFile() {
        super("");
        this.inited = false;
        this.fileList = new ArrayList();
        this.cpuNum = -1;
    }

    public SystemIdleTimeFile(String r1) {
        super(r1);
        this.inited = false;
        this.fileList = new ArrayList();
        this.cpuNum = -1;
    }

    @Override // com.bytedance.watson.assist.file.BaseStatFile
    public FileStatInfo refresh() {
        if (this.inited == true) goto L6;
        this.cpuNum = CpuUtils.getCpuCoreNum();
        this.idleStateNumList = CpuUtils.getCpuIdleStateNumList();
        this.inited = true;
    L6:
        if (this.idleStateNumList != null) goto L10;
        return null;
    L10:
        if (this.fileList.isEmpty() == false) goto L18;
        int r1 = 0;
    L13:
        if (r1 >= this.cpuNum) goto L18;
        int r2 = this.idleStateNumList.get(r1).intValue();
        ArrayList r3 = new ArrayList();
        int r4 = 0;
    L15:
        if (r4 >= r2) goto L17;
        r3.add(new File(PATH_PREFIX + r1 + PATH_SUB_PREFIX + r4 + PATH_SUFFIX));
        r4 = r4 + 1;
        goto L15
    L17:
        this.fileList.add(r3);
        r1 = r1 + 1;
    L18:
        this.mLastInfo = doRead(this.fileList);
        return this.mLastInfo;
    }

    private FileStatInfo doRead(List<List<File>> r3) {
        if (r3 != null) goto L4;
        return null;
    L4:
        if (r3.isEmpty() == true) goto L20;
        CpuIdleTimeStatInfo r0 = new CpuIdleTimeStatInfo();
        Iterator<List<File>> r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L12;
        List<Long> r1 = parseFile(r4.next());
        if (r1 == null) goto L8;
        r0.putStateTimeList(r1);
        goto L8
    L12:
        return r0;
    L20:
        return null;
    }

    private List<Long> parseFile(List<File> r6) {
        ArrayList r5 = new ArrayList();
        Iterator<File> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L24;
        BufferedReader r0 = FileUtils.openFile(r7.next());
        if (r0 == null) goto L7;
    L25:
        String r1 = r0.readLine();     // Catch: Throwable -> L17 Exception -> L19
        if (r1 == null) goto L16;
        if (r1.isEmpty() == true) goto L16;
        r5.add(Long.valueOf(Long.parseLong(r1) / 1000));     // Catch: Throwable -> L17 Exception -> L19
    L16:
        FileUtils.closeFile(r0);
    L19:
        e = move-exception;
        DebugLog.e(Log.getStackTraceString(e));     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        FileUtils.closeFile(r0);
        throw th;
    L7:
        return null;
    L24:
        return r5;
    }
}
