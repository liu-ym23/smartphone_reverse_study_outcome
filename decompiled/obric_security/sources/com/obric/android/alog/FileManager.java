package com.obric.android.alog;

import android.text.TextUtils;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedanceos.securitycenter.appBgBatteryControl.AppBgBatteryControlDataHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
class FileManager {
    private static final String FETCH_TIME_INVALID = "time interval is invalid";
    private static final String LOG_DIR_INVALID = "log dir not exists";
    private static final String LOG_FILE_NOT_FOUND = "log file not found";
    private static final String LOG_FILE_SUFFIX = ".olog";
    private static final int SUFFIX_LEN = 5;
    private static long sFetchEndTs;
    private static String sFetchFailReason;
    private static long sFetchStartTs;
    private static ArrayList<String> sLastFetchFileLists;

    static {
    }

    FileManager() {
    }

    static File[] getLogs(String r9, String r10, String r11, final long r12, final long r14) {
        sFetchStartTs = r12;
        sFetchEndTs = r14;
        sFetchFailReason = null;
        sLastFetchFileLists = null;
        if (r12 <= r14) goto L6;
        sFetchFailReason = FETCH_TIME_INVALID;
        return new File[0];
    L6:
        File r0 = new File(r9);
        if (r0.exists() == true) goto L9;
    L30:
        sFetchFailReason = LOG_DIR_INVALID;
        return new File[0];
    L9:
        if (r0.isDirectory() == false) goto L30;
        if (TextUtils.isEmpty(r10) == true) goto L14;
        r10 = r10.replace(':', '-');
    L14:
        StringBuilder r13 = new StringBuilder("^\\d{4}_\\d{2}_\\d{2}_(\\d+)__");
        String r3 = "\\S+";
        if (TextUtils.isEmpty(r10) == false) goto L17;
        String r15 = "\\S+";
    L18:
        StringBuilder r16 = r13.append(r15).append("__");
        if (TextUtils.isEmpty(r11) == true) goto L22;
        r3 = Pattern.quote(r11);
    L22:
        final Pattern r4 = Pattern.compile(r16.append(r3).append("\\.alog\\.hot$").toString());
        final ArrayList<String> r17 = new ArrayList();
        File[] r18 = r0.listFiles(new AnonymousClass1(r17, r4, r14, r12));
        if (r18 != null) goto L25;
    L26:
        sFetchFailReason = LOG_FILE_NOT_FOUND;
        sLastFetchFileLists = r17;
    L27:
        if (r18 == null) goto L29;
        return r18;
    L29:
        return new File[0];
    L25:
        if (r18.length != 0) goto L27;
    L17:
        r15 = Pattern.quote(r10);
        goto L18
    }

    static HashMap<String, String> getLastErrorInfo() {
        HashMap<String, String> r0 = new HashMap();
        r0.put("start", Long.toString(sFetchStartTs));
        r0.put(TraceStatsConsts.STATS_KEY_END, Long.toString(sFetchEndTs));
        r0.put(AppBgBatteryControlDataHelper.ItemColumns.REASON, sFetchFailReason);
        if (sLastFetchFileLists == null) goto L12;
        StringBuilder r1 = new StringBuilder();
        Iterator<String> r2 = sLastFetchFileLists.iterator();
    L6:
        if (r2.hasNext() == false) goto L11;
        String r3 = r2.next();
        if (r3.endsWith(LOG_FILE_SUFFIX) == false) goto L10;
        r3 = r3.substring(0, r3.length() - SUFFIX_LEN);
    L10:
        r1.append(r3).append(";");
        goto L6
    L11:
        r0.put("file", r1.toString());
    L12:
        sFetchFailReason = null;
        sLastFetchFileLists = null;
        return r0;
    }
}
