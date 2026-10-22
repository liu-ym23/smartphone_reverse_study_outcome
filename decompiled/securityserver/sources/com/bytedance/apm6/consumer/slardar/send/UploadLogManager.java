package com.bytedance.apm6.consumer.slardar.send;

import a.a;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.header.HeaderInfo;
import com.bytedance.apm6.consumer.slardar.header.HeaderManager;
import com.bytedance.apm6.consumer.slardar.persistent.LogFile;
import com.bytedance.apm6.consumer.slardar.persistent.LogItem;
import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeController;
import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeDataStorage;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.log.Logger;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class UploadLogManager {
    private static final String KEY_DEBUG_LEFT_COUNT = "debug_left_file_count";
    private static final String KEY_DEBUG_MERGE_COUNT = "debug_merge_file_count";
    private static final String KEY_DEBUG_SECOND_LEFT_COUNT = "debug_second_file_count";
    private static final String KEY_DEBUG_SEQ_NUM = "debug_sender_number";
    private static final String KEY_DEBUG_SID = "debug_sender_sid";
    private static final String KEY_DEBUG_TOTAL_BYTES = "debug_total_bytes";
    private static final String KEY_DEBUG_TOTAL_COUNT = "debug_total_count";
    private static final String KEY_SELF_DEBUG_MESSAGE = "_debug_self";
    private static final UploadLogInfo.ExceptionLogInfo exceptionLogInfo = null;
    private static final UploadLogInfo.MonitorLogInfo monitorLogInfo = null;
    private static AtomicInteger seqNum;
    private static final UploadLogInfo.TraceLogInfo traceLogInfo = null;
    private static final List<String> uploadTypeListInTraceType = null;
    private static final List<UploadLogInfo> uploadTypes = null;

    static {
        seqNum = new AtomicInteger(0);
        uploadTypeListInTraceType = Arrays.asList(new String[]{"tracing"});
        UploadLogInfo.ExceptionLogInfo r0 = new UploadLogInfo.ExceptionLogInfo();
        exceptionLogInfo = r0;
        UploadLogInfo.TraceLogInfo r1 = new UploadLogInfo.TraceLogInfo();
        traceLogInfo = r1;
        UploadLogInfo.MonitorLogInfo r2 = new UploadLogInfo.MonitorLogInfo();
        monitorLogInfo = r2;
        ArrayList r3 = new ArrayList();
        uploadTypes = r3;
        r3.add(r0);
        r3.add(r1);
        r3.add(r2);
    }

    public UploadLogManager() {
    }

    private static void debugPrint(Map<Long, List<LogItem>> r9) {
        if (ApmBaseContext.isDebugMode() == false) goto L12;
        Logger.d(Constants.TAG, "sendLog: input sendList merged into " + r9.size() + " group(s)");
        Iterator<Long> r0 = r9.keySet().iterator();
        int r2 = 0;
    L6:
        if (r0.hasNext() == false) goto L15;
        Long r3 = r0.next();
        List<LogItem> r4 = r9.get(r3);
        Logger.d(Constants.TAG, "----------------");
        HeaderInfo r5 = HeaderManager.getInstance().getHeaderInfo(String.valueOf(r3));
        String r6 = Constants.TAG;
        StringBuilder r7 = new StringBuilder("group ");
        int r8 = r2 + 1;
        r7.append(r2);
        r7.append(" header:");
        r7.append(r5);
        Logger.d(r6, r7.toString());
        int r10 = 0;
    L9:
        if (r10 >= r4.size()) goto L11;
        String r11 = Constants.TAG;
        StringBuilder r12 = a.p(r10, "  log[", "]=");
        r12.append(r4.get(r10).toString());
        Logger.d(r11, r12.toString());
        r10 = r10 + 1;
        goto L9
    L11:
        Logger.d(Constants.TAG, "----------------");
        r2 = r8;
        goto L6
    L15:
        return;
    }

    private static UploadLogInfo getUploadLogInfo(JSONObject r1) {
        String r2 = r1.optString("log_type");
        if (Constants.EXCEPTION_TYPE.contains(r2) == false) goto L7;
        return exceptionLogInfo;
    L7:
        if (uploadTypeListInTraceType.contains(r2) == false) goto L11;
        return traceLogInfo;
    L11:
        return monitorLogInfo;
    }

    public static List<UploadLogInfo> getUploadType() {
        return uploadTypes;
    }

    public static Map<UploadLogInfo, byte[]> serialize(List<LogFile> r22, int r23) {
        String r1 = KEY_SELF_DEBUG_MESSAGE;
        HashMap r2 = new HashMap();     // Catch: Throwable -> L9
        long r3 = r22.size();     // Catch: Throwable -> L9
        Iterator<LogFile> r5 = r22.iterator();     // Catch: Throwable -> L9
        long r6 = 0;
        long r8 = 0;
    L5:
        if (r5.hasNext() == false) goto L12;
        LogFile r10 = r5.next();     // Catch: Throwable -> L9
        long r11 = r10.getStartID();     // Catch: Throwable -> L9
        List r13 = (List) r2.get(Long.valueOf(r11));     // Catch: Throwable -> L9
        if (r13 != null) goto L11;
        r13 = new ArrayList();     // Catch: Throwable -> L9
        r2.put(Long.valueOf(r11), r13);     // Catch: Throwable -> L9
    L11:
        r6 = r6 + ((long) r10.getTotalBytes());     // Catch: Throwable -> L9
        r8 = r8 + ((long) r10.getTotalCount());     // Catch: Throwable -> L9
        r13.addAll(r10.getLogList());     // Catch: Throwable -> L9
        goto L5
    L12:
        debugPrint(r2);     // Catch: Throwable -> L9
        File r7 = DiskFileHelper.getInstance().getDirectory();     // Catch: Throwable -> L9
        if (r7 == null) goto L17;
        String[] r9 = r7.list();     // Catch: Throwable -> L9
        if (r9 == null) goto L17;
        int r12 = r9.length;     // Catch: Throwable -> L9
    L18:
        HashMap r14 = new HashMap();     // Catch: Throwable -> L9
        ArrayList r15 = new ArrayList();     // Catch: Throwable -> L9
        Iterator r16 = r2.keySet().iterator();     // Catch: Throwable -> L9
    L20:
        if (r16.hasNext() == false) goto L72;
        Long r17 = (Long) r16.next();     // Catch: Throwable -> L9
        List r18 = (List) r2.get(r17);     // Catch: Throwable -> L9
        if (r18 == null) goto L20;
        HashMap r19 = r2;
        int r110 = 0;
    L26:
        if (r110 >= r18.size()) goto L71;
        Iterator r111 = r16;
        List r112 = r18;
        JSONObject r113 = new JSONObject(new String(((LogItem) r18.get(r110)).getData()));     // Catch: Throwable -> L9 Exception -> L85
        if (DowngradeController.getInstance().uploadEnabled(r113, ApmContext.getAid()) == false) goto L35;
        UploadLogInfo r4 = getUploadLogInfo(r113);     // Catch: Throwable -> L9
        if ((r4 instanceof UploadLogInfo.MonitorLogInfo) == true) goto L98;
        r1 = r1;
        r110 = r110;
        r14 = r14;
    L62:
        Map r114 = (Map) r14.get(r4);     // Catch: Throwable -> L9
        if (r114 != null) goto L66;
        r114 = new HashMap();     // Catch: Throwable -> L9
        r14.put(r4, r114);     // Catch: Throwable -> L9
    L66:
        if (r114.containsKey(r17) == true) goto L68;
        r114.put(r17, new JSONArray());     // Catch: Throwable -> L9
    L68:
        ((JSONArray) r114.get(r17)).put(r113);     // Catch: Throwable -> L9
        goto L70
    L98:
        JSONObject r115 = r113.optJSONObject(r1);     // Catch: Throwable -> L9 Exception -> L45
        if (r115 != null) goto L44;
        r115 = new JSONObject();     // Catch: Throwable -> L9 Exception -> L45
        r113.put(r1, r115);     // Catch: Throwable -> L9 Exception -> L45
    L44:
        r1 = r1;
        r110 = r110;
        r115.put(KEY_DEBUG_SEQ_NUM, seqNum.getAndIncrement());     // Catch: Throwable -> L9 Exception -> L56
        HashMap r20 = r14;
        r115.put(KEY_DEBUG_SID, ApmContext.getStartId());     // Catch: Throwable -> L9 Exception -> L83
        r115.put(KEY_DEBUG_TOTAL_BYTES, r6);     // Catch: Throwable -> L9 Exception -> L83
        r115.put(KEY_DEBUG_TOTAL_COUNT, r8);     // Catch: Throwable -> L9 Exception -> L83
        r115.put(KEY_DEBUG_MERGE_COUNT, r3);     // Catch: Throwable -> L9 Exception -> L83
        r115.put(KEY_DEBUG_SECOND_LEFT_COUNT, r12);     // Catch: Throwable -> L9 Exception -> L83
        r115.put(KEY_DEBUG_LEFT_COUNT, r23);     // Catch: Throwable -> L9 Exception -> L82
    L58:
        if (r113.has("seq_no") == false) goto L60;
        r15.add(String.valueOf(r113.get("seq_no")));     // Catch: Throwable -> L9
    L60:
        r14 = r20;
    L56:
        r20 = r14;
    L46:
        r110 = r110;
        r20 = r14;
    L45:
        r1 = r1;
        goto L46
    L35:
        if (ApmBaseContext.isDebugMode() == false) goto L70;
        Logger.d(DowngradeDataStorage.TAG, r113.toString());     // Catch: Throwable -> L9
    L70:
        r14 = r14;
        r110 = r110 + 1;     // Catch: Throwable -> L9
        r16 = r111;
        r18 = r112;
        r1 = r1;
    L69:
        r112 = r18;
        goto L70
    L71:
        r2 = r19;
        goto L20
    L72:
        HashMap r21 = r14;
        HashMap r0 = new HashMap();     // Catch: Throwable -> L9
        Iterator r24 = r21.keySet().iterator();     // Catch: Throwable -> L9
    L74:
        if (r24.hasNext() == false) goto L77;
        UploadLogInfo r25 = (UploadLogInfo) r24.next();     // Catch: Throwable -> L9
        r0.put(r25, r25.serialize((HashMap) r21.get(r25)));     // Catch: Throwable -> L9
        goto L74
    L77:
        if (ApmAlogHelper.getInnerLogger() == null) goto L79;
        ApmAlogHelper.getInnerLogger().d(Constants.TAG, "seqNoList:" + r15.toString());     // Catch: Throwable -> L9
    L79:
        return r0;
    L17:
        r12 = 0;
    L9:
        th = move-exception;
        Logger.e(Constants.TAG, "LogSender serialize failed.", th);
        return null;
    }
}
