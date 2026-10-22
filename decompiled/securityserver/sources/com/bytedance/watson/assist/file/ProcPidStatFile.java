package com.bytedance.watson.assist.file;

import android.util.Log;
import com.bytedance.watson.assist.core.cpu.ProcStatInfo;
import com.bytedance.watson.assist.utils.DebugLog;
import com.bytedance.watson.assist.utils.FileUtils;
import java.io.BufferedReader;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class ProcPidStatFile extends BaseStatFile {
    protected static final int INDEX_CS_TIME = 14;
    protected static final int INDEX_CU_TIME = 13;
    protected static final int INDEX_PID = 0;
    protected static final int INDEX_PROC_NAME = 1;
    protected static final int INDEX_S_TIME = 12;
    protected static final int INDEX_U_TIME = 11;
    private static final String PROC_PID_STAT_PATH = "proc/self/stat";
    protected static final Character SPLIT_PROC_NAME_RIGHT = null;

    static {
        SPLIT_PROC_NAME_RIGHT = ')';
    }

    public ProcPidStatFile(String r1) {
        super(r1);
    }

    @Override // com.bytedance.watson.assist.file.BaseStatFile
    public FileStatInfo doRead(File r2) {
        return parseFile(r2, null);
    }

    public FileStatInfo parseFile(File r6, ProcStatInfo r7) {
        BufferedReader r5 = FileUtils.openFile(r6);
        if (r5 != null) goto L33;
        return null;
    L33:
        String r8 = r5.readLine();     // Catch: Exception -> L18 Throwable -> L30
        if (r8 != null) goto L9;
    L25:
        FileUtils.closeFile(r5);
        return r7;
    L9:
        if (r8.isEmpty() == true) goto L25;
        String r9 = r8.trim();     // Catch: Exception -> L18 Throwable -> L30
        Character r0 = SPLIT_PROC_NAME_RIGHT;     // Catch: Exception -> L18 Throwable -> L30
        String r1 = r9.substring(0, r9.indexOf(r0.charValue())).trim();     // Catch: Exception -> L18 Throwable -> L30
        String r10 = r9.substring(r9.indexOf(r0.charValue()) + 1, r9.length()).trim();     // Catch: Exception -> L18 Throwable -> L30
        String[] r2 = r1.split("\\(");     // Catch: Exception -> L18 Throwable -> L30
        String[] r11 = r10.split(" ");     // Catch: Exception -> L18 Throwable -> L30
        if (r2.length > 1) goto L14;
    L23:
        FileUtils.closeFile(r5);
        return r7;
    L14:
        if (r11.length <= 14) goto L23;
        if (r7 != null) goto L20;
        r7 = new ProcStatInfo();     // Catch: Exception -> L18 Throwable -> L30
    L20:
        r7.setPid(Integer.parseInt(r2[0].trim()));     // Catch: Exception -> L18 Throwable -> L30
        r7.setProcessName(r2[1].trim());     // Catch: Exception -> L18 Throwable -> L30
        r7.setCpuTime((((Integer.parseInt(r11[11]) + Integer.parseInt(r11[12])) + Integer.parseInt(r11[13])) + Integer.parseInt(r11[14])) * 10);     // Catch: Exception -> L18 Throwable -> L30
        FileUtils.closeFile(r5);
        return r7;
    L18:
        e = move-exception;
        DebugLog.e(Log.getStackTraceString(e));     // Catch: Throwable -> L30
        FileUtils.closeFile(r5);
        return r7;
    L30:
        FileUtils.closeFile(r5);
        return r7;
    }

    public ProcPidStatFile() {
        this(PROC_PID_STAT_PATH);
    }
}
