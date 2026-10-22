package com.bytedance.frameworks.baselib.network.http;

import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.retrofit2.RetrofitMetrics;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class BaseHttpRequestInfo<T extends BaseRequestContext> {
    public static final int HTTP_CLIENT_TYPE_CRONET = 0;
    public static final int HTTP_CLIENT_TYPE_OK3 = 1;
    public static final String KEY_ABTEST = "ab_test";
    public static final String KEY_COOKIE = "cookie";
    public static final String KEY_EXCEPTION = "ex";
    public static final String KEY_HIT = "hit";
    public static final String KEY_HTTP_CLIENT = "hc";
    public static final String KEY_HTTP_CLIENT_VERSION = "hcv";
    public static final String KEY_USER_AGENT = "ua";
    private static volatile ICreate sCreate;
    public long appLevelRequestStart;
    public boolean bdTuringRetry;
    public long beforeAllInterceptors;
    public long completeReadResponse;
    public long connectTime;
    public String contentType;
    public long dnsTime;
    public boolean downloadFile;
    public boolean executeTuringCallback;
    public JSONObject extraInfo;
    public String fallbackMessage;
    public int fallbackReason;
    public volatile AtomicBoolean hasReportStreamingApiAll;
    public int httpClientType;
    public boolean isSocketReused;
    public RetrofitMetrics metrics;
    public long nativePostTaskStartTime;
    public long nativeRequestStartTime;
    public long nativeWaitContext;
    public long pushTime;
    public long receiveTime;
    public long receivedByteCount;
    public int recycleCount;
    public String remoteIp;
    public T reqContext;
    public long requestEnd;
    public String requestHeaders;
    public String requestLog;
    public long requestStart;
    public long responseBack;
    public long responseBodyByteCount;
    public String responseHeaders;
    public long retryAttempts;
    public long retryByHeaderCallbackDuration;
    public String retryByHeaderFilterKey;
    public long retryForAccountCallbackDuration;
    public long sendTime;
    public long sentByteCount;
    public long sslTime;
    public long totalTime;
    public long ttfbMs;
    public long turingCallbackDuration;

    public interface ICreate {
        BaseHttpRequestInfo create();
    }

    public BaseHttpRequestInfo() {
        this.httpClientType = -1;
        this.fallbackReason = -1;
        this.fallbackMessage = "";
        this.downloadFile = false;
        this.executeTuringCallback = false;
        this.turingCallbackDuration = -1;
        this.retryForAccountCallbackDuration = -1;
        this.bdTuringRetry = false;
        this.retryByHeaderCallbackDuration = -1;
        this.hasReportStreamingApiAll = new AtomicBoolean(false);
        this.contentType = "";
    }

    static {
        sCreate = new AnonymousClass1();
    }

    public static void setCreate(ICreate r0) {
        if (r0 == null) goto L5;
        sCreate = r0;
        return;
    }

    public static JSONObject getABTestInfo(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return null;
    L6:
        String[] r5 = r4.split(",");
        JSONArray r0 = new JSONArray();
        int r1 = r5.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L9;
        r0.put(r5[r2]);
        r2 = r2 + 1;
        goto L7
    L9:
        JSONObject r6 = new JSONObject();
        r6.put(KEY_HIT, r0);     // Catch: JSONException -> L12
    L14:
        return r6;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    public static BaseHttpRequestInfo createHttpRequestInfo() {
        return sCreate.create();
    }
}
