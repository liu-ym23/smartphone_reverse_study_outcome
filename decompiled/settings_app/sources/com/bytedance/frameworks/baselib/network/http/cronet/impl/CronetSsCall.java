package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.connectionclass.DeviceBandwidthSampler;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.RequestRetryResult;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.retrofit2.IMetricsCollect;
import com.bytedance.retrofit2.IRequestInfo;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.ttnet.SsCallTTNetExtend;
import com.bytedance.retrofit2.ttnet.TTNetExceptionStorage;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
class CronetSsCall implements SsCall, SsCallTTNetExtend, IMetricsCollect, IRequestInfo {
    private static final String TAG = "CronetSsCall";
    private static ICronetClient sCronetClient;
    boolean mBypassNetworkStatusCheck;
    boolean mCanceled;
    HttpURLConnection mConnection;
    private String mContentType;
    private String mNeedRemoveRetryByHeaderKey;
    private boolean mNeedRemoveTuringHeader;
    BaseHttpRequestInfo mReqInfo;
    RetrofitMetrics mRetrofitMetrics;
    Request mRetrofitRequest;
    long mStartTime;
    private volatile long mThrottleNetSpeed;
    String mTraceCode;

    static {
    }

    public CronetSsCall(Request r13, ICronetClient r14) throws IOException {
        this.mReqInfo = BaseHttpRequestInfo.createHttpRequestInfo();
        this.mTraceCode = null;
        this.mCanceled = false;
        this.mBypassNetworkStatusCheck = false;
        this.mThrottleNetSpeed = 0;
        this.mNeedRemoveTuringHeader = false;
        this.mRetrofitRequest = r13;
        sCronetClient = r14;
        String r15 = r13.getUrl();
        this.mConnection = null;
        RetrofitMetrics r0 = r13.getMetrics();
        this.mRetrofitMetrics = r0;
        this.mReqInfo.metrics = r0;
        RetrofitMetrics r1 = this.mRetrofitMetrics;
        if (r1 == null) goto L5;
        BaseHttpRequestInfo r2 = this.mReqInfo;
        r2.appLevelRequestStart = r1.appLevelRequestStart;
        BaseHttpRequestInfo r3 = this.mReqInfo;
        r3.beforeAllInterceptors = this.mRetrofitMetrics.beforeAllInterceptors;
    L5:
        long r4 = System.currentTimeMillis();
        this.mStartTime = r4;
        this.mReqInfo.requestStart = r4;
        this.mReqInfo.httpClientType = 0;
        if (this.mRetrofitRequest.isResponseStreaming() == false) goto L8;
        this.mReqInfo.downloadFile = true;
    L10:
        if ((r13.getExtraInfo() instanceof BaseRequestContext) == false) goto L20;
        BaseHttpRequestInfo r5 = this.mReqInfo;
        r5.reqContext = (T) r13.getExtraInfo();
        this.mBypassNetworkStatusCheck = this.mReqInfo.reqContext.bypass_network_status_check;
    L20:
        this.mConnection = SsCronetHttpClient.constructURLConnection(r15, r13, this.mReqInfo, this.mThrottleNetSpeed);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        SsCronetHttpClient.processException(r15, this.mStartTime, this.mReqInfo, this.mTraceCode, e, this.mConnection, this.mRetrofitMetrics);
        this.mCanceled = true;
        if ((e instanceof TTNetExceptionStorage) == false) goto L18;
        throw e;
    L18:
        TTNetExceptionStorage r6 = new TTNetExceptionStorage(e.getMessage(), e.getCause());
        r6.setInfo(true, false, true, r15, this.mTraceCode, this.mReqInfo);
        throw r6;
    L8:
        this.mReqInfo.downloadFile = false;
        goto L10
    }

    private int retryCurrentRequestOneTime(Map<String, String> r10) throws IOException {
        HttpURLConnection r0 = this.mConnection;
        if (r0 == null) goto L5;
        r0.disconnect();
    L5:
        String r1 = this.mRetrofitRequest.getUrl();
        HttpURLConnection r2 = SsCronetHttpClient.constructURLConnection(r1, this.mRetrofitRequest, this.mReqInfo, this.mThrottleNetSpeed);     // Catch: Exception -> L9
        this.mConnection = r2;     // Catch: Exception -> L9
        SsCronetHttpClient.setRequestHeaders(r2, r10);     // Catch: Exception -> L9
        return SsCronetHttpClient.processExecute(this.mRetrofitRequest, this.mConnection);
    L9:
        e = move-exception;
        SsCronetHttpClient.processException(r1, this.mStartTime, this.mReqInfo, this.mTraceCode, e, this.mConnection, this.mRetrofitMetrics);
        this.mCanceled = true;
        if ((e instanceof TTNetExceptionStorage) == false) goto L13;
        throw e;
    L13:
        TTNetExceptionStorage r8 = new TTNetExceptionStorage(e.getMessage(), e.getCause());
        r8.setInfo(true, false, true, r1, this.mTraceCode, this.mReqInfo);
        throw r8;
    }

    private int retryRequestFromTuringHeader(int r4) throws IOException {
        RequestRetryResult r0 = SsCronetHttpClient.shouldRetryRequestFromTuringHeader(this.mRetrofitRequest.getHeaders(), this.mConnection, this.mReqInfo, r4);
        if (r0.isRequestRetryEnabled() == false) goto L7;
        return retryCurrentRequestOneTime(r0.getAddRequestHeaders());
    L7:
        if (this.mReqInfo.executeTuringCallback == false) goto L9;
        this.mNeedRemoveTuringHeader = true;
    L9:
        return r4;
    }

    private int retryRequestByHeader(int r4) throws IOException {
        RequestRetryResult r0 = SsCronetHttpClient.shouldRetryRequestByHeader(this.mRetrofitRequest.getHeaders(), this.mConnection, this.mReqInfo, r4);
        if (r0.isRequestRetryEnabled() == false) goto L7;
        return retryCurrentRequestOneTime(r0.getAddRequestHeaders());
    L7:
        if (StringUtils.isEmpty(this.mReqInfo.retryByHeaderFilterKey) == false) goto L9;
    L11:
        return r4;
    L9:
        if (r0.isRemoveHitResponseHeaderIfNotRetry() == false) goto L11;
        this.mNeedRemoveRetryByHeaderKey = this.mReqInfo.retryByHeaderFilterKey;
        goto L11
    }

    private int retryForAccountRequest(int r8) throws IOException {
        RequestRetryResult r0 = NetworkParams.shouldRetryForAccountRequest(this.mConnection.getURL().toString(), r8, false, this.mReqInfo, this.mRetrofitRequest.getHeaders(), this.mConnection.getHeaderFields());
        if (r0 != null) goto L5;
    L8:
        return r8;
    L5:
        if (r0.isRequestRetryEnabled() == false) goto L8;
        this.mReqInfo.bdTuringRetry = true;
        return retryCurrentRequestOneTime(r0.getAddRequestHeaders());
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public Response execute() throws IOException {
        RetrofitMetrics r0 = this.mRetrofitMetrics;
        if (r0 == null) goto L5;
        r0.callExecuteStartTime = System.currentTimeMillis();
    L5:
        String r12 = this.mRetrofitRequest.getUrl();
        if (this.mCanceled == true) goto L148;
        String r11 = null;
        SsCronetHttpClient.checkNetworkAvailable(this.mBypassNetworkStatusCheck, null, this.mRetrofitRequest.getPath());
        int r14 = 1;
        boolean r15 = false;
        if (this.mRetrofitRequest.isResponseStreaming() == false) goto L157;
    L18:
        boolean r16 = false;
    L151:
        int r1 = retryRequestFromTuringHeader(SsCronetHttpClient.processExecute(this.mRetrofitRequest, this.mConnection));     // Catch: Throwable -> L101 Exception -> L104
        if (this.mReqInfo.executeTuringCallback == true) goto L26;
        r1 = retryRequestByHeader(r1);     // Catch: Throwable -> L23 Exception -> L104
    L23:
        th = th;
        r14 = 0;
    L137:
        r15 = r16;
    L139:
        if (this.mRetrofitRequest.isResponseStreaming() == false) goto L141;
        if (r14 != 0) goto L141;
    L143:
        if (this.mRetrofitRequest.isResponseStreaming() == true) goto L146;
        if (r15 == false) goto L146;
        DeviceBandwidthSampler.getInstance().stopSampling();
    L146:
        throw th;
    L141:
        SsCronetHttpClient.processFinally(this.mConnection);
    L26:
        if (this.mReqInfo.bdTuringRetry == true) goto L28;
        r1 = retryForAccountRequest(r1);     // Catch: Throwable -> L23 Exception -> L104
    L28:
        int r10 = r1;
        this.mReqInfo.responseBack = System.currentTimeMillis();     // Catch: Throwable -> L101 Exception -> L104
        this.mReqInfo.recycleCount = -1;     // Catch: Throwable -> L101 Exception -> L104
        String r2 = SsCronetHttpClient.processAfterExecute(this.mConnection, this.mReqInfo, r10);     // Catch: Throwable -> L101 Exception -> L104
        this.mTraceCode = r2;     // Catch: Throwable -> L101 Exception -> L104
        RetrofitMetrics r3 = this.mRetrofitMetrics;     // Catch: Throwable -> L101 Exception -> L104
        if (r3 == null) goto L32;
        r3.traceCode = r2;     // Catch: Throwable -> L23 Exception -> L104
    L32:
        this.mContentType = SsCronetHttpClient.getHeaderValueIgnoreCase(this.mConnection, "Content-Type");     // Catch: Throwable -> L101 Exception -> L104
        if (this.mRetrofitRequest.isResponseStreaming() == true) goto L159;
        int r17 = r10;
        int r4 = this.mRetrofitRequest.getMaxLength();     // Catch: Throwable -> L97 Exception -> L99
        this.mReqInfo.contentType = SsCronetHttpClient.getContentBaseType(this.mContentType);     // Catch: Throwable -> L97 Exception -> L99
        int r9 = 0;
        TypedInput r8 = new TypedByteArray(this.mContentType, SsCronetHttpClient.processResponse(r12, r4, this.mConnection, this.mStartTime, this.mReqInfo, this.mTraceCode, r17, this.mRetrofitMetrics), new String[0]);     // Catch: Throwable -> L93 Exception -> L95
    L77:
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L93 Exception -> L95
        if (this.mNeedRemoveTuringHeader == false) goto L81;
        r5.add(NetworkParams.BDTURING_VERIFY_HEADER);     // Catch: Throwable -> L93 Exception -> L95
    L81:
        if (StringUtils.isEmpty(this.mNeedRemoveRetryByHeaderKey) == true) goto L83;
        r5.add(this.mNeedRemoveRetryByHeaderKey);     // Catch: Throwable -> L93 Exception -> L95
    L83:
        Response r6 = new Response(r12, r17, this.mConnection.getResponseMessage(), SsCronetHttpClient.createHeaders(this.mConnection, r5), r8);     // Catch: Throwable -> L93 Exception -> L95
        r6.setExtraInfo(this.mReqInfo);     // Catch: Throwable -> L93 Exception -> L95
        r6.setTraceCode(this.mTraceCode);     // Catch: Throwable -> L93 Exception -> L95
    L85:
        if (this.mRetrofitRequest.isResponseStreaming() == true) goto L89;
        SsCronetHttpClient.processFinally(this.mConnection);
    L89:
        if (this.mRetrofitRequest.isResponseStreaming() == true) goto L92;
        if (r16 == false) goto L92;
        DeviceBandwidthSampler.getInstance().stopSampling();
    L92:
        return r6;
    L95:
        e = e;
    L162:
    L136:
        th = th;
        goto L137
    L111:
        if ((e instanceof HttpResponseException) == false) goto L117;
        HttpResponseException r7 = (HttpResponseException) e;     // Catch: Throwable -> L136
        if (r7.getStatusCode() != 304) goto L117;
        throw r7;     // Catch: Throwable -> L136
    L117:
        if ((e instanceof IOException) == false) goto L123;
        if ("request canceled".equals(e.getMessage()) == false) goto L123;
        throw e;     // Catch: Throwable -> L136
    L123:
        if ("com.ttnet.org.chromium.net.urlconnection.TTRequestCanceledException".equals(e.getClass().getName()) == false) goto L125;
        doCollect();     // Catch: Throwable -> L136
        int r18 = SsCronetHttpClient.getCronetInternalErrorCode(this.mConnection);     // Catch: Throwable -> L136
    L127:
        if ("com.ttnet.org.chromium.net.impl.NetworkExceptionImpl".equals(e.getClass().getName()) == false) goto L129;
    L130:
        r18 = SsCronetHttpClient.getCronetInternalErrorCode(this.mConnection);     // Catch: Throwable -> L136
    L131:
        SsCronetHttpClient.processException(r12, this.mStartTime, this.mReqInfo, this.mTraceCode, e, this.mConnection, this.mRetrofitMetrics);     // Catch: Throwable -> L136
        SsCronetHttpClient.checkNetworkAvailable(this.mBypassNetworkStatusCheck, e.getMessage(), this.mRetrofitRequest.getPath());     // Catch: Throwable -> L136
        if (this.mRetrofitRequest.isResponseStreaming() == false) goto L134;
        this.mReqInfo.hasReportStreamingApiAll.set(true);     // Catch: Throwable -> L136
    L134:
        CronetIOException r13 = new CronetIOException(e, this.mReqInfo, this.mTraceCode, r18);     // Catch: Throwable -> L136
        r13.setInfo(true, false, true, r12, this.mTraceCode, this.mReqInfo);     // Catch: Throwable -> L136
        throw r13;     // Catch: Throwable -> L136
    L129:
        if ("com.ttnet.org.chromium.net.impl.QuicExceptionImpl".equals(e.getClass().getName()) == false) goto L131;
    L125:
        r18 = r9;
    L93:
        th = th;
    L103:
        r14 = r9;
    L97:
        th = th;
        r9 = 0;
        goto L103
    L159:
        boolean r19 = "gzip".equalsIgnoreCase(SsCronetHttpClient.getHeaderValueIgnoreCase(this.mConnection, "Content-Encoding"));     // Catch: Throwable -> L71 Exception -> L104
        ICronetClient r20 = sCronetClient;     // Catch: Throwable -> L71 Exception -> L104
        if (r20 != null) goto L37;
    L39:
        boolean r21 = r19;
    L41:
        if (r10 < 200) goto L45;
        if (r10 >= 300) goto L45;
    L46:
        TypedInput r22 = createResponseBody(this.mConnection, r21);     // Catch: Throwable -> L23 Exception -> L104
        if (r22 == null) goto L49;
    L51:
        r8 = r22;
        r9 = 0;
        r17 = r10;
        goto L77
    L49:
        if (SsCronetHttpClient.isForceConstructResponse(this.mReqInfo) == false) goto L51;
        r22 = new TypedByteArray(this.mContentType, new byte[0], new String[0]);     // Catch: Throwable -> L23 Exception -> L104
    L45:
        if (SsCronetHttpClient.isForceHandleResponse(this.mReqInfo) == true) goto L46;
        String r110 = this.mConnection.getResponseMessage();     // Catch: Throwable -> L71 Exception -> L104
        int r23 = this.mRetrofitRequest.getMaxLength();     // Catch: Throwable -> L63
        InputStream r24 = this.mConnection.getInputStream();     // Catch: Exception -> L56 Throwable -> L63
    L57:
        int r111 = r10;
        r11 = SsCronetHttpClient.processHttpErrorResponse(r21, this.mConnection.getHeaderFields(), r23, r24, this.mContentType, r12, this.mRetrofitMetrics, this.mReqInfo);     // Catch: Throwable -> L61
    L60:
        String r25 = r110;
        this.mConnection.disconnect();     // Catch: Throwable -> L71 Exception -> L99
        HttpResponseException r26 = new HttpResponseException(r111, r25, this.mRetrofitRequest.getPath(), r11);     // Catch: Throwable -> L71 Exception -> L99
        this.mReqInfo.hasReportStreamingApiAll.set(true);     // Catch: Throwable -> L71 Exception -> L99
        r26.setInfo(true, true, false, r12, this.mTraceCode, this.mReqInfo);     // Catch: Throwable -> L71 Exception -> L99
        throw r26;     // Catch: Throwable -> L71 Exception -> L99
    L61:
        th = th;
    L65:
        th.printStackTrace();     // Catch: Throwable -> L71 Exception -> L99
        StringBuilder r27 = new StringBuilder("reason = ");     // Catch: Throwable -> L71 Exception -> L99
        if (r110 != null) goto L68;
        r110 = "";
    L68:
        r110 = r27.append(r110).append("  exception = ").append(th.getMessage()).toString();     // Catch: Throwable -> L71 Exception -> L99
    L56:
        r24 = this.mConnection.getErrorStream();     // Catch: Throwable -> L63
    L63:
        th = th;
        r111 = r10;
        goto L65
    L37:
        if (r20.isCronetHttpURLConnection(this.mConnection) == false) goto L39;
        r21 = false;
    L71:
        th = th;
        r15 = r16;
        r14 = 0;
    L99:
        e = e;
        r9 = 0;
    L101:
        th = th;
        r9 = 0;
    L104:
        e = e;
        r9 = 0;
        goto L162
    L157:
        NetworkParams.ConnectionQualitySamplerHook r28 = NetworkParams.getConnectionQualitySamplerHook();     // Catch: Throwable -> L16 Exception -> L108
        if (r28 == null) goto L18;
        if (r28.shouldSampling(r12) == false) goto L18;
        DeviceBandwidthSampler.getInstance().startSampling();     // Catch: Throwable -> L16 Exception -> L108
        r16 = true;
        goto L151
    L16:
        th = th;
        r14 = 0;
    L108:
        e = e;
        r9 = 0;
        r16 = false;
    L106:
        th = th;
        r14 = 0;
        r15 = false;
        goto L139
    L148:
        throw new IOException("request canceled");
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public void cancel() {
        HttpURLConnection r1 = this.mConnection;
        if (r1 == null) goto L16;
        r1.disconnect();
        if (this.mRetrofitRequest.isResponseStreaming() == true) goto L7;
    L14:
        this.mCanceled = true;
        return;
    L7:
        if (this.mCanceled == true) goto L14;
        doCollect();
        BaseHttpRequestInfo r2 = this.mReqInfo;
        r2.contentType = SsCronetHttpClient.getContentBaseType(this.mContentType);
        BaseHttpRequestInfo r3 = this.mReqInfo;
        r3.requestEnd = System.currentTimeMillis();
        if (this.mReqInfo.reqContext != 0) goto L11;
    L12:
        long r4 = this.mReqInfo.requestEnd;
        long r5 = this.mStartTime;
        NetworkParams.monitorApiSample(r4 - r5, r5, this.mRetrofitRequest.getUrl(), this.mTraceCode, this.mReqInfo);
    L13:
        StreamTrafficObservable.inst().onStreamTrafficChanged(this.mRetrofitRequest.getUrl(), this.mReqInfo.sentByteCount, this.mReqInfo.receivedByteCount, this.mReqInfo.contentType, this.mReqInfo.requestLog);
        goto L14
    L11:
        if (this.mReqInfo.reqContext.is_need_monitor_in_cancel == false) goto L13;
    }

    @Override // com.bytedance.retrofit2.ttnet.SsCallTTNetExtend
    public void cancelNormalRequest(Throwable r9, boolean r10) {
        HttpURLConnection r0 = this.mConnection;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.disconnect();
        if (this.mCanceled == false) goto L8;
        return;
    L8:
        doCollect();
        BaseHttpRequestInfo r1 = this.mReqInfo;
        r1.contentType = SsCronetHttpClient.getContentBaseType(this.mContentType);
        BaseHttpRequestInfo r2 = this.mReqInfo;
        r2.requestEnd = System.currentTimeMillis();
        if (this.mReqInfo.reqContext != 0) goto L11;
    L12:
        NetworkParams.reportOneNormalRequest(r9, this.mTraceCode, this.mStartTime, this.mRetrofitRequest, this.mReqInfo, Boolean.valueOf(r10));
    L14:
        if (this.mRetrofitRequest.isResponseStreaming() == false) goto L16;
        StreamTrafficObservable.inst().onStreamTrafficChanged(this.mRetrofitRequest.getUrl(), this.mReqInfo.sentByteCount, this.mReqInfo.receivedByteCount, this.mReqInfo.contentType, this.mReqInfo.requestLog);
    L16:
        this.mCanceled = true;
        return;
    L11:
        if (this.mReqInfo.reqContext.is_need_monitor_in_cancel == false) goto L14;
        goto L12
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public boolean setThrottleNetSpeed(long r6) {
        this.mThrottleNetSpeed = r6;
        HttpURLConnection r5 = this.mConnection;
        if (r5 != null) goto L11;
    L10:
        return true;
    L11:
        Reflect.on(r5).call("setThrottleNetSpeed", new Class[]{Long.TYPE}, new Object[]{Long.valueOf(r6)});     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public Request getRequest() {
        return this.mRetrofitRequest;
    }

    private TypedInput createResponseBody(final HttpURLConnection r3, final boolean r4) throws IOException {
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.getContentLength() != 0) goto L10;
        cancel();
        return null;
    L10:
        return new AnonymousClass1(this, r3, r4);
    }

    @Override // com.bytedance.retrofit2.IMetricsCollect
    public void doCollect() {
        SsCronetHttpClient.getRequestMetrics(this.mConnection, this.mReqInfo, this.mRetrofitMetrics);
    }

    @Override // com.bytedance.retrofit2.IRequestInfo
    public Object getRequestInfo() {
        return this.mReqInfo;
    }
}
