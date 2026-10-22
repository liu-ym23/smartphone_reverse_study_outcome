package com.bytedance.apm6.consumer.slardar.send;

import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.header.HeaderInfo;
import com.bytedance.apm6.consumer.slardar.header.HeaderManager;
import com.bytedance.apm6.consumer.slardar.header.HeaderUtils;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.tob.IReportDataService;
import com.bytedance.apm6.util.BatchLogWrapUtils;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.Tools;
import com.bytedance.apm6.util.log.Logger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
interface UploadLogInfo {

    public static class ExceptionLogInfo implements UploadLogInfo {
        @Override // com.bytedance.apm6.consumer.slardar.send.UploadLogInfo
        public String getName() {
            return "exception";
        }

        public ExceptionLogInfo() {
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.UploadLogInfo
        public List<String> getUrls() {
            return LogReportController.getInstance().getExceptionUrlList();
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.UploadLogInfo
        public byte[] serialize(HashMap<Long, JSONArray> r6) {
            JSONObject r5 = new JSONObject();     // Catch: Exception -> L14
            JSONArray r0 = new JSONArray();     // Catch: Exception -> L14
            Iterator<Long> r1 = r6.keySet().iterator();     // Catch: Exception -> L14
        L4:
            if (r1.hasNext() == false) goto L12;
            JSONArray r2 = r6.get(r1.next());     // Catch: Exception -> L14
            if (r2 == null) goto L4;
            int r3 = 0;
        L10:
            if (r3 >= r2.length()) goto L4;
            r0.put(r2.get(r3));     // Catch: Exception -> L14
            r3 = r3 + 1;     // Catch: Exception -> L14
            goto L10
        L12:
            r5.put("header", HeaderUtils.serialize(HeaderManager.getInstance().getHeaderInfo(String.valueOf(HeaderUtils.getUniqueHeaderId()))));     // Catch: Exception -> L14
            r5.put("data", r0);     // Catch: Exception -> L14
            return Tools.safeGetBytes(r5.toString());
        L14:
            return null;
        }
    }

    public static class MonitorLogInfo implements UploadLogInfo {
        @Override // com.bytedance.apm6.consumer.slardar.send.UploadLogInfo
        public String getName() {
            return "log";
        }

        public MonitorLogInfo() {
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.UploadLogInfo
        public List<String> getUrls() {
            return LogReportController.getInstance().getReportList();
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.UploadLogInfo
        public byte[] serialize(HashMap<Long, JSONArray> r7) {
            JSONArray r6 = new JSONArray();     // Catch: Exception -> L27
            Iterator<Long> r0 = r7.keySet().iterator();     // Catch: Exception -> L27
        L5:
            if (r0.hasNext() == false) goto L12;
            Long r1 = r0.next();     // Catch: Exception -> L27
            HeaderInfo r4 = HeaderManager.getInstance().getHeaderInfo(String.valueOf(r1));     // Catch: Exception -> L27
            if (r4 == null) goto L9;
            JSONObject r5 = new JSONObject();     // Catch: Exception -> L27
            r5.put("data", r7.get(r1));     // Catch: Exception -> L27
            r5.put("header", HeaderUtils.serialize(r4));     // Catch: Exception -> L27
            r6.put(r5);     // Catch: Exception -> L27
            goto L5
        L9:
            if (ApmContext.isDebugMode() == false) goto L5;
            Logger.w(Constants.TAG, "HeaderInfo null for key " + r1);     // Catch: Exception -> L27
            goto L5
        L12:
            JSONArray r8 = DropDataMonitor.getInstance().getItems();     // Catch: Exception -> L27
            if (r8 != null) goto L15;
        L19:
            JSONObject r9 = new JSONObject();     // Catch: Exception -> L27
            r9.put("list", r6);     // Catch: Exception -> L27
            if (ApmContext.isDebugMode() == false) goto L22;
            Logger.d(Constants.TAG, "request:" + r9);     // Catch: Exception -> L27
        L22:
            IReportDataService r10 = (IReportDataService) ServiceManager.getService(IReportDataService.class);     // Catch: Exception -> L27
            if (r10 == null) goto L25;
            r9 = r10.changeReportData(r9);     // Catch: Exception -> L27
        L25:
            return Tools.safeGetBytes(r9.toString());
        L15:
            if (r8.length() <= 0) goto L19;
            HeaderInfo r2 = HeaderManager.getInstance().getHeaderInfo(String.valueOf(HeaderUtils.getUniqueHeaderId()));     // Catch: Exception -> L27
            if (r2 == null) goto L19;
            JSONObject r3 = new JSONObject();     // Catch: Exception -> L27
            r3.put("data", r8);     // Catch: Exception -> L27
            r3.put("header", HeaderUtils.serialize(r2));     // Catch: Exception -> L27
            r6.put(r3);     // Catch: Exception -> L27
        L27:
            return null;
        }
    }

    public static class TraceLogInfo implements UploadLogInfo {
        @Override // com.bytedance.apm6.consumer.slardar.send.UploadLogInfo
        public String getName() {
            return TraceStatsConsts.STATS_KEY_TRACE;
        }

        public TraceLogInfo() {
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.UploadLogInfo
        public List<String> getUrls() {
            return LogReportController.getInstance().getTraceUrlList();
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.UploadLogInfo
        public byte[] serialize(HashMap<Long, JSONArray> r10) {
            JSONObject r9 = new JSONObject();     // Catch: Exception -> L29
            JSONArray r0 = new JSONArray();     // Catch: Exception -> L29
            Iterator<Long> r1 = r10.keySet().iterator();     // Catch: Exception -> L29
        L4:
            if (r1.hasNext() == false) goto L25;
            JSONArray r2 = r10.get(r1.next());     // Catch: Exception -> L29
            if (r2 == null) goto L4;
            int r3 = 0;
        L10:
            if (r3 >= r2.length()) goto L4;
            List<Object> r4 = BatchLogWrapUtils.stripData(r2.getJSONObject(r3));     // Catch: Exception -> L21
            if (ListUtils.isEmpty(r4) == true) goto L23;
            Iterator<Object> r5 = r4.iterator();     // Catch: Exception -> L21
        L16:
            if (r5.hasNext() == false) goto L23;
            Object r6 = r5.next();     // Catch: Exception -> L21
            r0.put(r6);     // Catch: Exception -> L21
            if (ApmContext.isDebugMode() == false) goto L16;
            Logger.d(Constants.TAG, ":" + r6);     // Catch: Exception -> L21
        L23:
            r3 = r3 + 1;     // Catch: Exception -> L29
        L21:
            e = move-exception;
            Logger.e(Constants.TAG, "serialize", e);     // Catch: Exception -> L29
            goto L23
        L25:
            if (ApmContext.isDebugMode() == false) goto L27;
            Logger.d(Constants.TAG, "jsonArray:" + r0);     // Catch: Exception -> L29
        L27:
            r9.put("header", HeaderUtils.serialize(HeaderManager.getInstance().getHeaderInfo(String.valueOf(HeaderUtils.getUniqueHeaderId()))));     // Catch: Exception -> L29
            r9.put("data", r0);     // Catch: Exception -> L29
            return Tools.safeGetBytes(r9.toString());
        L29:
            return null;
        }
    }

    String getName();

    List<String> getUrls();

    byte[] serialize(HashMap<Long, JSONArray> r1);
}
