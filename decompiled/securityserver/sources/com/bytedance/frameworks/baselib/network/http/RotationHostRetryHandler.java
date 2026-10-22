package com.bytedance.frameworks.baselib.network.http;

import com.bytedance.retrofit2.RetrofitMetrics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class RotationHostRetryHandler {
    private final List<BaseRequestContext.RotationHostRetryInfo> mRetryHostInfoList;
    private int mRetryIndex;
    private final List<RetryMetrics> mRetryMetricsList;

    public static class RetryMetrics {
        public long callbackDuration;
        public int code;
        public String host;
        public long lastRequestDuration;
        public String path;
        public boolean retry;

        public RetryMetrics(String r1, String r2, int r3, long r4, long r6, boolean r8) {
            this.host = r1;
            this.path = r2;
            this.code = r3;
            this.callbackDuration = r4;
            this.lastRequestDuration = r6;
            this.retry = r8;
        }
    }

    public RotationHostRetryHandler(List<BaseRequestContext.RotationHostRetryInfo> r3) {
        ArrayList r0 = new ArrayList();
        this.mRetryHostInfoList = r0;
        this.mRetryIndex = 0;
        this.mRetryMetricsList = new CopyOnWriteArrayList();
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.isEmpty() == true) goto L10;
        r0.addAll(r3);
        return;
    }

    public JSONObject constructJsonLog() {
        if (this.mRetryMetricsList.isEmpty() == false) goto L6;
        return null;
    L6:
        JSONObject r0 = new JSONObject();
        Iterator<RetryMetrics> r6 = this.mRetryMetricsList.iterator();     // Catch: JSONException -> L13
    L9:
        if (r6.hasNext() == false) goto L12;
        RetryMetrics r1 = r6.next();     // Catch: JSONException -> L13
        JSONObject r2 = new JSONObject();     // Catch: JSONException -> L13
        r2.put("callback_duration", r1.callbackDuration);     // Catch: JSONException -> L13
        r2.put("request_duration", r1.lastRequestDuration);     // Catch: JSONException -> L13
        r2.put("code", r1.code);     // Catch: JSONException -> L13
        r0.put(r1.host + r1.path, r2);     // Catch: JSONException -> L13
    L12:
        return r0;
    }

    public BaseRequestContext.RotationHostRetryInfo getNextRetryHostInfo() {
        if (this.mRetryIndex < this.mRetryHostInfoList.size()) goto L6;
        return null;
    L6:
        List<BaseRequestContext.RotationHostRetryInfo> r0 = this.mRetryHostInfoList;
        int r1 = this.mRetryIndex;
        this.mRetryIndex = r1 + 1;
        return r0.get(r1);
    }

    public boolean noRemainingRetryHost() {
        if (this.mRetryHostInfoList.isEmpty() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mRetryIndex >= this.mRetryHostInfoList.size()) goto L8;
        return false;
    }

    public void recordMetrics(String r12, String r13, int r14, long r15, RequestRetryResult r17, BaseHttpRequestInfo r18) {
        if (r17 != null) goto L5;
    L8:
        boolean r1 = false;
    L7:
        boolean r10 = r1;
        long r2 = r18.requestRetryStart;
        if (r2 > 0) goto L13;
        r2 = r18.requestStart;
    L13:
        RetryMetrics r3 = new RetryMetrics(r12, r13, r14, r15, System.currentTimeMillis() - r2, r10);
        this.mRetryMetricsList.add(r3);
        RetrofitMetrics r0 = r18.metrics;
        if (r0 == null) goto L17;
        r0.rotationHostRetryInfo = constructJsonLog();
        return;
    L17:
        return;
    L5:
        if (r17.isRequestRetryEnabled() == false) goto L8;
        r1 = true;
        goto L7
    }
}
