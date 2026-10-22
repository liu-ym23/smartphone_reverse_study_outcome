package com.bytedance.frameworks.baselib.network.http;

import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.retrofit2.RetrofitMetrics;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
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
    public boolean accountRetry;
    public long appLevelRequestStart;
    public boolean bdTuringRetry;
    public long beforeAllInterceptors;
    public boolean bypassApiReport;
    public long completeReadResponse;
    public long connectTime;
    public String contentType;
    public int customInputStreamSize;
    public long dnsTime;
    public boolean downloadFile;
    public boolean executeTuringCallback;
    public JSONObject extraInfo;
    public String fallbackMessage;
    public int fallbackReason;
    public boolean fromCache;
    public volatile AtomicBoolean hasReportStreamingApiAll;
    public boolean hasSampled;
    public int httpClientType;
    public boolean isSocketReused;

    @Nullable
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
    public long requestEndAppResumeState;
    public String requestHeaders;
    public String requestLog;
    public long requestRetryStart;
    public long requestStart;
    public long requestStartAppResumeState;
    public long responseBack;
    public long responseBodyByteCount;
    public String responseHeaders;
    public long retryAttempts;
    public String retryByHeaderFilterKey;
    public long retryForAccountCallbackDuration;
    public RotationHostRetryHandler rotationHostPathRetryHandler;
    public boolean rotationHostRetry;
    public long sendTime;
    public long sentByteCount;
    public long sslTime;
    public long totalTime;
    public String traceCode;
    public long ttfbMs;
    public long turingCallbackDuration;

    @Nullable
    public URL url;
    public boolean useCronetInputStreamWithTTBuffer;

    public interface ICreate {
        BaseHttpRequestInfo create();
    }

    static {
        sCreate = new AnonymousClass1();
    }

    public BaseHttpRequestInfo() {
        this.useCronetInputStreamWithTTBuffer = false;
        this.customInputStreamSize = -1;
        this.requestStartAppResumeState = -1;
        this.requestEndAppResumeState = -1;
        this.recycleCount = -1;
        this.fromCache = false;
        this.httpClientType = -1;
        this.fallbackReason = -1;
        this.fallbackMessage = "";
        this.extraInfo = new JSONObject();
        this.downloadFile = false;
        this.executeTuringCallback = false;
        this.turingCallbackDuration = -1;
        this.bdTuringRetry = false;
        this.accountRetry = false;
        this.retryForAccountCallbackDuration = -1;
        this.rotationHostRetry = false;
        this.hasReportStreamingApiAll = new AtomicBoolean(false);
        this.contentType = "";
        this.traceCode = "";
    }

    public static BaseHttpRequestInfo createHttpRequestInfo() {
        return sCreate.create();
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

    public static void setCreate(ICreate r0) {
        if (r0 == null) goto L5;
        sCreate = r0;
        return;
    }
}
