package com.bytedance.watson.assist.file;

import a.a;
import android.util.Log;
import com.bytedance.watson.assist.core.cpu.ProcTimeInStateInfo;
import com.bytedance.watson.assist.utils.DebugLog;
import com.bytedance.watson.assist.utils.FileUtils;
import java.io.BufferedReader;
import java.io.File;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ProcTimeInStateFile extends BaseStatFile {
    private static final int INDEX_FREQ = 0;
    private static final int INDEX_TIME = 1;
    private static final String PATH = "/proc/self/time_in_state";

    public ProcTimeInStateFile() {
        this(PATH);
    }

    private FileStatInfo parseFile(File r14) {
        BufferedReader r13 = FileUtils.openFile(r14);
        if (r13 != null) goto L5;
        return null;
    L5:
        ProcTimeInStateInfo r0 = new ProcTimeInStateInfo();
        LinkedHashMap<Long, Long> r3 = null;
        long r4 = 0;
    L34:
        String r6 = r13.readLine();     // Catch: Exception -> L21 Throwable -> L32
        if (r6 == null) goto L26;
        if (r6.isEmpty() == true) goto L34;
        if (r6.contains("cpu") == true) goto L34;
        String[] r7 = r6.split(" ");     // Catch: Exception -> L21 Throwable -> L32
        if (r7.length <= 1) goto L26;
        long r9 = Long.parseLong(r7[0]);     // Catch: Exception -> L21 Throwable -> L32
        long r8 = Long.parseLong(r7[1]) * 10;     // Catch: Exception -> L21 Throwable -> L32
        if (r4 != 0) goto L19;
    L23:
        if (r3 != null) goto L25;
        r3 = new LinkedHashMap();     // Catch: Exception -> L21 Throwable -> L32
    L25:
        r3.put(Long.valueOf(r9), Long.valueOf(r8));     // Catch: Exception -> L21 Throwable -> L32
        r4 = r9;
        goto L34
    L19:
        if (r9 >= r4) goto L23;
        r0.addFreqTimeItem(r3);     // Catch: Exception -> L21 Throwable -> L32
        r3 = null;
    L26:
        r0.addFreqTimeItem(r3);     // Catch: Exception -> L21 Throwable -> L32
        FileUtils.closeFile(r13);
        return r0;
    L21:
        e = move-exception;
        DebugLog.e(Log.getStackTraceString(e));     // Catch: Throwable -> L32
        FileUtils.closeFile(r13);
        return r0;
    L32:
        FileUtils.closeFile(r13);
        return r0;
    }

    @Override // com.bytedance.watson.assist.file.BaseStatFile
    public FileStatInfo doRead(File r1) {
        return parseFile(r1);
    }

    public ProcTimeInStateFile(int r3) {
        super(a.f(r3, "/proc/self/task/", "/time_in_state"));
    }

    public ProcTimeInStateFile(String r1) {
        super(r1);
    }
}
