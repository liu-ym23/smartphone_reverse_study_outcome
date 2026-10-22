package com.bytedance.apm.agent.instrumentation.okhttp3;

import android.util.Log;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.agent.instrumentation.transaction.TransactionData;
import com.bytedance.apm.agent.instrumentation.transaction.TransactionState;
import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.constant.TrafficConsts;
import com.bytedance.apm.logging.DebugLogger;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import java.io.IOException;
import okhttp3.FormBody;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MonitorRecorder {
    private static final String TAG = "MonitorRecorder";

    public MonitorRecorder() {
    }

    public static void recordRequest(Request r2, TransactionState r3) {
        if (r2 == null) goto L19;
        if (r3 == null) goto L23;
        r3.addAssistData("NetworkLib", "OkHttp3");
        r3.setUrl(r2.url().toString());
        r3.setMethod(r2.method());
        r3.setStartTime(System.currentTimeMillis());
        r3.setCarrier("");
        r3.setWanType("");
        RequestBody r4 = r2.body();
        if (r4 != null) goto L8;
        return;
    L8:
        if ((r4 instanceof FormBody) == false) goto L11;
        r3.setBytesSent(((FormBody) r4).contentLength());
        return;
    L11:
        if ((r4 instanceof MultipartBody) == false) goto L22;
        r3.setBytesSent(r4.contentLength());     // Catch: IOException -> L14
        return;
    L14:
        e = move-exception;
        Log.d("TransactionData:", "can not get MultipartBody content length", e);
        return;
    L22:
        return;
    L23:
        return;
    }

    public static void recordResponse(Response r2, TransactionState r3) {
        if (r2 == null) goto L9;
        if (r3 == null) goto L11;
        r3.setStatusCode(r2.code());
        if (r2.body() == null) goto L10;
        r3.setBytesReceived(r2.body().contentLength());
        return;
    L10:
        return;
    L11:
        return;
    }

    public static void reportExceptionMonitor(TransactionState r0, Exception r1) {
    }

    public static void reportMonitorData(TransactionState r0, Response r1) {
        if (r0 == null) goto L7;
        if (r1 == null) goto L8;
        reportMonitorData(r0, "okhttp");
        return;
    L8:
        return;
    }

    public static void reportMonitorData(TransactionState r13, String r14) {
        if (r13 != null) goto L4;
        return;
    L4:
        TransactionData r0 = r13.end();
        if (ApmContext.isDebugMode() == false) goto L18;
        Logger.i(DebugLogger.TAG_NET, new String[]{"auto plugin, reportMonitorData: " + r0.toString()});
    L18:
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L11
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L11
        r2.put("sent_bytes", r0.getBytesSent());     // Catch: Exception -> L11
        r2.put("received_bytes", r0.getBytesReceived());     // Catch: Exception -> L11
        r1.put(ApmTrafficStats.TTNET_RESPONSE, r2);     // Catch: Exception -> L11
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L11
        r12.put("request_log", r1);     // Catch: Exception -> L11
        r12.put(TrafficConsts.KEY_NET_CONSUME_TYPE, r14);     // Catch: Exception -> L11
        long r4 = r0.getTotalTime();     // Catch: Exception -> L11
        if (r13.getStartTime() != 0) goto L13;
        long r15 = r0.getRequestStart();     // Catch: Exception -> L11
    L14:
        MonitorTool.monitorSLA(r4, r15, r0.getUrl(), "", "", r0.getStatusCode(), r12);     // Catch: Exception -> L11
        return;
    L13:
        r15 = r13.getStartTime();     // Catch: Exception -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
    }
}
