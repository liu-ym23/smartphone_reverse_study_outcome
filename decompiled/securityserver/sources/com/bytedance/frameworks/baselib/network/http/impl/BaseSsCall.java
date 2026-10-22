package com.bytedance.frameworks.baselib.network.http.impl;

import a.a;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.connectionclass.DeviceBandwidthSampler;
import com.bytedance.frameworks.baselib.network.http.BaseHttpClient;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.RequestRetryResult;
import com.bytedance.frameworks.baselib.network.http.RotationHostRetryHandler;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.frameworks.baselib.network.http.parser.MimeType;
import com.bytedance.frameworks.baselib.network.http.parser.StreamParser;
import com.bytedance.platform.godzilla.common.Constant;
import com.bytedance.retrofit2.IRequestInfo;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.ttnet.SsCallTTNetExtend;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseSsCall implements SsCall, SsCallTTNetExtend, IRequestInfo, HttpResponseProvider, RequestLogProvider {
    private static volatile boolean TNC_USE_OKIO_READ = true;
    private static volatile boolean USER_USE_OKIO_READ = false;
    protected boolean bypassNetworkStatusCheck;
    protected volatile boolean canceled;
    protected BaseHttpRequestInfo requestInfo;
    protected Request retrofitRequest;

    public BaseSsCall(Request r5) {
        this.bypassNetworkStatusCheck = false;
        this.canceled = false;
        this.retrofitRequest = r5;
        BaseHttpRequestInfo r1 = BaseHttpRequestInfo.createHttpRequestInfo();
        this.requestInfo = r1;
        r1.metrics = r5.getMetrics();
        BaseHttpRequestInfo r6 = this.requestInfo;
        RetrofitMetrics r2 = r6.metrics;
        if (r2 == null) goto L5;
        r6.appLevelRequestStart = r2.appLevelRequestStart;
        r6.beforeAllInterceptors = r2.beforeAllInterceptors;
    L5:
        r6.requestStart = System.currentTimeMillis();
        if (this.retrofitRequest.isResponseStreaming() == false) goto L8;
        this.requestInfo.downloadFile = true;
    L10:
        if ((this.retrofitRequest.getExtraInfo() instanceof BaseRequestContext) == false) goto L19;
        BaseHttpRequestInfo r7 = this.requestInfo;
        r7.reqContext = (T) this.retrofitRequest.getExtraInfo();
        T r8 = this.requestInfo.reqContext;
        this.bypassNetworkStatusCheck = r8.bypass_network_status_check;
        List<BaseRequestContext.RotationHostRetryInfo> r9 = r8.rotationHostRetryInfoList;
        if (r9 != null) goto L14;
        return;
    L14:
        if (r9.size() > 0) goto L16;
        return;
    L16:
        if (r9.size() > 3) goto L22;
        BaseHttpRequestInfo r4 = this.requestInfo;
        r4.rotationHostPathRetryHandler = new RotationHostRetryHandler(r9);
        return;
    L22:
        return;
    L19:
        return;
    L8:
        this.requestInfo.downloadFile = false;
        goto L10
    }

    public static void checkNetworkAvailableBeforeRequest(boolean r0, Context r1, String r2) {
        if (r0 == true) goto L9;
        if (r1 != null) goto L5;
        return;
    L5:
        if (NetworkUtils.isNetworkAvailable(r1) == false) goto L8;
        return;
    L8:
        throw new NetworkNotAvailabeException(a.A("network not available for ", r2));
    }

    public static List<Header> createHeaders(HttpResponseProvider r5, List<String> r6) {
        Map<String, List<String>> r7 = r5.responseHeaders();
        if (r7 != null) goto L6;
        return null;
    L6:
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<String, List<String>>> r8 = r7.entrySet().iterator();
    L8:
        if (r8.hasNext() == false) goto L24;
        Map.Entry<String, List<String>> r1 = r8.next();
        String r2 = r1.getKey();
        if (r2 == null) goto L20;
        if (r6 == null) goto L20;
        if (r6.isEmpty() == true) goto L20;
        Iterator<String> r3 = r6.iterator();
    L16:
        if (r3.hasNext() == false) goto L20;
        if (r2.equalsIgnoreCase(r3.next()) == false) goto L16;
    L20:
        Iterator<String> r4 = r1.getValue().iterator();
    L22:
        if (r4.hasNext() == false) goto L8;
        r0.add(new Header(r2, r4.next()));
        goto L22
    L24:
        return r0;
    }

    public static TypedInput createStreamingResponseBody(final Request r7, final BaseHttpRequestInfo r8, final HttpResponseProvider r9, final SsCall r10, final boolean r11) {
        if (r9.contentLength() != 0) goto L7;
        r10.cancel();
        return null;
    L7:
        return new AnonymousClass1(r9, r8, r11, r7, r10);
    }

    private static String getAllHeaderFieldsString(Map<String, List<String>> r8) {
        if (r8 != null) goto L38;
    L37:
        return "";
    L38:
    L29:
        th = move-exception;
        th.printStackTrace();
        goto L37
    L5:
        if (r8.isEmpty() == true) goto L37;
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L29
        Iterator<Map.Entry<String, List<String>>> r9 = r8.entrySet().iterator();     // Catch: Throwable -> L29
    L9:
        if (r9.hasNext() == false) goto L34;
        Map.Entry<String, List<String>> r2 = r9.next();     // Catch: Throwable -> L29
        if (r2 == null) goto L9;
        String r3 = r2.getKey();     // Catch: Throwable -> L29
        if (StringUtils.isEmpty(r3) == true) goto L9;
        List<String> r4 = r2.getValue();     // Catch: Throwable -> L29
        if (r4 == null) goto L9;
        if (r4.isEmpty() == true) goto L9;
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L29
        Iterator<String> r6 = r4.iterator();     // Catch: Throwable -> L29
        int r7 = 0;
    L23:
        if (r6.hasNext() == false) goto L33;
        String r10 = r6.next();     // Catch: Throwable -> L29
        if (StringUtils.isEmpty(r10) == true) goto L23;
        if (r7 != 0) goto L31;
        r5.append(r10);     // Catch: Throwable -> L29
    L32:
        r7 = r7 + 1;     // Catch: Throwable -> L29
        goto L23
    L31:
        r5.append("; ");     // Catch: Throwable -> L29
        r5.append(r10);     // Catch: Throwable -> L29
        goto L32
    L33:
        r1.put(r3, r5.toString());     // Catch: Throwable -> L29
        goto L9
    L34:
        return r1.toString();
    }

    private static String getHostAddress(Exception r3) {
        if (r3 != null) goto L19;
        return "";
    L19:
        String r1 = r3.getMessage();     // Catch: Throwable -> L14
        if (r1 != null) goto L8;
    L16:
        return "";
    L8:
        if (TextUtils.isEmpty(r3.getMessage()) == true) goto L16;
        String[] r4 = r1.split("\\|");     // Catch: Throwable -> L14
        if (r4.length < 2) goto L18;
        return r4[0];
    L18:
        return "";
    L14:
        th = move-exception;
        th.printStackTrace();
        goto L18
    }

    private static void getRemoteIp(String r1, BaseHttpRequestInfo r2) {
        if (StringUtils.isEmpty(r1) == false) goto L10;
        return;
    L10:
        r2.remoteIp = r1;     // Catch: Throwable -> L9
        T r3 = r2.reqContext;     // Catch: Throwable -> L9
        if (r3 == 0) goto L12;
        r3.remoteIp = r1;     // Catch: Throwable -> L9
        return;
    L12:
        return;
    }

    public static void getRequestMetrics(BaseHttpRequestInfo r5, RequestLogProvider r6) {
        if (r6 != null) goto L35;
    L6:
        RetrofitMetrics r7 = r5.metrics;     // Catch: Throwable -> L4
        if (r7 == null) goto L37;
        r7.cronetInitStart = TTNetInitMetrics.inst().createEngineStart;     // Catch: Throwable -> L4
        RetrofitMetrics r8 = r5.metrics;     // Catch: Throwable -> L4
        r8.cronetInitEnd = TTNetInitMetrics.inst().cronetInitEnd;     // Catch: Throwable -> L4
        RetrofitMetrics r9 = r5.metrics;     // Catch: Throwable -> L4
        r9.executeCallEndTime = SystemClock.uptimeMillis();     // Catch: Throwable -> L4
        RetrofitMetrics r10 = r5.metrics;     // Catch: Throwable -> L4
        r10.retrofitLogReportTime = System.currentTimeMillis();     // Catch: Throwable -> L4
        RetrofitMetrics r11 = r5.metrics;     // Catch: Throwable -> L4
        r11.ttnetVersion = "4.2.228.16-pico";     // Catch: Throwable -> L4
        r11.extra.put(RetrofitMetrics.ExtraKeys.SENT_BYTE_COUNT, Long.valueOf(r5.sentByteCount));     // Catch: Throwable -> L4
        r5.metrics.extra.put(RetrofitMetrics.ExtraKeys.RECEIVED_BYTE_COUNT, Long.valueOf(r5.receivedByteCount));     // Catch: Throwable -> L4
        JSONObject r12 = r5.extraInfo;     // Catch: Throwable -> L4
        long r0 = r5.turingCallbackDuration;     // Catch: Throwable -> L4
        if (r0 < 0) goto L11;
        r12.put("turing_callback", r0);     // Catch: Throwable -> L4
    L11:
        long r1 = r5.retryForAccountCallbackDuration;     // Catch: Throwable -> L4
        if (r1 < 0) goto L16;
        r12.put("retry_for_account_cost", r1);     // Catch: Throwable -> L4
    L16:
        if (r5.bdTuringRetry == false) goto L19;
        r12.put("turing_retry", "1");     // Catch: Throwable -> L4
    L19:
        if (r5.accountRetry == false) goto L21;
        r12.put("account_retry", "1");     // Catch: Throwable -> L4
    L21:
        String r2 = r5.retryByHeaderFilterKey;     // Catch: Throwable -> L4
        if (r2 == null) goto L24;
        r12.put("retry_by_header", r2);     // Catch: Throwable -> L4
    L24:
        RotationHostRetryHandler r3 = r5.rotationHostPathRetryHandler;     // Catch: Throwable -> L4
        if (r3 == null) goto L31;
        JSONObject r4 = r3.constructJsonLog();     // Catch: Throwable -> L4
        if (r4 == null) goto L31;
        if (r4.length() <= 0) goto L31;
        r12.put("rotation_host_retry", r4);     // Catch: Throwable -> L4
        r5.metrics.rotationHostRetryInfo = r4;     // Catch: Throwable -> L4
    L31:
        r12.put("retrofit", r5.metrics.getRetrofitLog());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
        return;
    L37:
        return;
    L35:
        r6.updateRequestInfoWithRequestLog(r5);     // Catch: Throwable -> L4
        goto L6
    }

    private static boolean isForceConstructResponse(BaseHttpRequestInfo r0) {
        if (r0 == null) goto L8;
        T r1 = r0.reqContext;
        if (r1 == 0) goto L8;
        if (r1.streaming_force_return_response == false) goto L8;
        return true;
    L8:
        return false;
    }

    private static boolean isForceHandleResponse(BaseHttpRequestInfo r0) {
        if (r0 == null) goto L8;
        T r1 = r0.reqContext;
        if (r1 == 0) goto L8;
        if (r1.force_handle_response == false) goto L8;
        return true;
    L8:
        return false;
    }

    public static String processHttpErrorResponse(BaseHttpRequestInfo r8, Map<String, List<String>> r9, int r10, InputStream r11, String r12, boolean r13) {
        if (r11 != null) goto L47;
        return null;
    L47:
    L10:
        e = move-exception;
        throw new IOException(e);     // Catch: Throwable -> L8
    L6:
        if (r8.useCronetInputStreamWithTTBuffer == false) goto L12;
        byte[] r14 = StreamParser.readResponseWithZeroCopy(r13, r9, r10, r11, r8.metrics);     // Catch: Throwable -> L8 Exception -> L10
    L17:
        StreamParser.safeClose(r11);
        if (r14.length > 0) goto L20;
        return null;
    L20:
        if (StringUtils.isEmpty(r12) == false) goto L22;
        return null;
    L22:
        if (Logger.debug() == false) goto L24;
    L45:
        MimeType r15 = new MimeType(r12);     // Catch: Throwable -> L30
        if ("text".equalsIgnoreCase(r15.getPrimaryType()) == false) goto L28;
    L32:
        String r16 = r15.getParameter("charset");     // Catch: Throwable -> L30
        if (StringUtils.isEmpty(r16) == false) goto L36;
        r16 = Constant.CHARSET_UTF_8;
    L36:
        if (shouldReadErrorResponse(r8) == false) goto L53;
        return new String(r14, r16);
    L53:
        return null;
    L28:
        if ("application/json".equalsIgnoreCase(r15.getBaseType()) == true) goto L32;
        return null;
    L30:
        th = move-exception;
        th.printStackTrace();
        return null;
    L24:
        if (shouldReadErrorResponse(r8) == true) goto L45;
        return null;
    L12:
        int[] r1 = new int[1];     // Catch: Throwable -> L8 Exception -> L10
        byte[] r17 = StreamParser.readResponse(r13, r9, r10, r11, r1, r8.metrics);     // Catch: Throwable -> L8 Exception -> L10
        int r18 = r1[0];     // Catch: Throwable -> L8 Exception -> L10
        byte[] r2 = new byte[r18];     // Catch: Throwable -> L8 Exception -> L10
        if (r17 == null) goto L16;
        if (r18 <= 0) goto L16;
        System.arraycopy(r17, 0, r2, 0, r18);     // Catch: Throwable -> L8 Exception -> L10
    L16:
        r14 = r2;
    L8:
        th = move-exception;
        StreamParser.safeClose(r11);
        throw th;
    }

    public static byte[] processNonStreamingResponse(String r9, int r10, BaseHttpRequestInfo r11, HttpResponseProvider r12, RequestLogProvider r13) {
        if (r12.responseCode() != 200) goto L5;
    L25:
        r11.completeReadResponse = System.currentTimeMillis();
        InputStream r0 = r12.inputStream();     // Catch: Exception -> L28
    L59:
    L35:
        th = move-exception;
        StreamParser.safeClose(r0);
        throw th;
    L37:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L35
    L33:
        if (r11.useCronetInputStreamWithTTBuffer == false) goto L40;
        byte[] r14 = StreamParser.readResponseWithZeroCopy(r12.isGzip(), r12.responseHeaders(), r10, r0, r11.metrics);     // Catch: Throwable -> L35 Exception -> L37
    L49:
        StreamParser.safeClose(r0);
        if (StreamParser.testIsSSBinary(r12.contentType()) == false) goto L52;
        StreamParser.decodeSSBinary(r14, r14.length);
    L52:
        r11.requestEnd = System.currentTimeMillis();
        r11.requestEndAppResumeState = BaseHttpClient.GetAppActivityResumeState();
        getRequestMetrics(r11, r13);
        NetworkParams.handleApiOk(r9, r11);
        return r14;
    L40:
        if (TNC_USE_OKIO_READ == true) goto L42;
    L44:
        int[] r7 = new int[1];     // Catch: Throwable -> L35 Exception -> L37
        byte[] r15 = StreamParser.readResponse(r12.isGzip(), r12.responseHeaders(), r10, r0, r7, r11.metrics);     // Catch: Throwable -> L35 Exception -> L37
        int r2 = r7[0];     // Catch: Throwable -> L35 Exception -> L37
        byte[] r3 = new byte[r2];     // Catch: Throwable -> L35 Exception -> L37
        if (r15 == null) goto L48;
        if (r2 <= 0) goto L48;
        System.arraycopy(r15, 0, r3, 0, r2);     // Catch: Throwable -> L35 Exception -> L37
    L48:
        r14 = r3;
        goto L49
    L42:
        if (USER_USE_OKIO_READ == false) goto L44;
        r14 = StreamParser.readResponseWithOkio(r12.isGzip(), r12.responseHeaders(), r10, r0, r11.metrics);     // Catch: Throwable -> L35 Exception -> L37
    L28:
        e = move-exception;
        if (isForceHandleResponse(r11) == false) goto L58;
        r0 = r12.errorStream();
        goto L59
    L58:
        throw e;
    L5:
        if (isForceHandleResponse(r11) == true) goto L25;
        if (r12.responseCode() != 304) goto L10;
        r11.completeReadResponse = System.currentTimeMillis();
        r11.requestEnd = System.currentTimeMillis();
        r11.requestEndAppResumeState = BaseHttpClient.GetAppActivityResumeState();
        getRequestMetrics(r11, r13);
        NetworkParams.handleApiOk(r9, r11);
    L10:
        String r16 = null;
        InputStream r1 = r12.inputStream();     // Catch: Throwable -> L13 Exception -> L15
    L12:
        InputStream r5 = r1;
        if (r5 == null) goto L18;
        r16 = processHttpErrorResponse(r11, r12.responseHeaders(), r10, r5, r12.contentType(), r12.isGzip());     // Catch: Throwable -> L13
    L18:
        r12.safeClose();     // Catch: Throwable -> L13
        String r17 = "";
    L21:
        HttpResponseException r4 = new HttpResponseException(r12.responseCode(), r17, HttpResponseException.getPathFromUrlString(r9), r16);
        if (r12.responseCode() != 304) goto L65;
        r4.setInfo(true, true, false, r9, r11.traceCode, r11);
        throw r4;
    L65:
        throw r4;
    L15:
        r1 = r12.errorStream();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.printStackTrace();
        r17 = "reason = " + r12.responseMessage() + "  exception = " + th.getMessage();
        goto L21
    }

    public static TypedInput processResponseBody(String r7, Request r8, BaseHttpRequestInfo r9, HttpResponseProvider r10, RequestLogProvider r11, SsCall r12, boolean r13) {
        if (r8.isResponseStreaming() == false) goto L30;
        boolean r14 = isForceHandleResponse(r9);
        if (r10.responseCode() >= 200) goto L7;
    L8:
        if (r14 == false) goto L13;
    L9:
        TypedInput r15 = createStreamingResponseBody(r8, r9, r10, r12, r14);
        if (r15 != null) goto L36;
        if (r13 == true) goto L38;
        return r15;
    L38:
        return new TypedByteArray(r10.contentType(), new byte[0], new String[0]);
    L36:
        return r15;
    L13:
        String r16 = null;
        InputStream r17 = r10.inputStream();     // Catch: Throwable -> L16 Exception -> L18
    L15:
        InputStream r4 = r17;
        if (r4 == null) goto L21;
        r16 = processHttpErrorResponse(r9, r10.responseHeaders(), r8.getMaxLength(), r4, r10.contentType(), r10.isGzip());     // Catch: Throwable -> L16
    L21:
        r10.safeClose();
        String r18 = "";
    L24:
        HttpResponseException r19 = new HttpResponseException(r10.responseCode(), r18, r8.getPath(), r16);
        r9.hasReportStreamingApiAll.set(true);
        r19.setInfo(true, true, false, r7, r9.traceCode, r9);
        throw r19;
    L18:
        r17 = r10.errorStream();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L26
        r18 = "reason = " + r10.responseMessage() + "  exception = " + th.getMessage();     // Catch: Throwable -> L26
        r10.safeClose();
    L26:
        th = move-exception;
        r10.safeClose();
        throw th;
    L7:
        if (r10.responseCode() < 300) goto L9;
    L30:
        return new TypedByteArray(r10.contentType(), processNonStreamingResponse(r7, r8.getMaxLength(), r9, r10, r11), new String[0]);
    }

    public static void setTncUseOkioRead(boolean r0) {
        TNC_USE_OKIO_READ = r0;
    }

    public static void setUseOkioRead(boolean r0) {
        USER_USE_OKIO_READ = r0;
    }

    private static boolean shouldReadErrorResponse(BaseHttpRequestInfo r0) {
        if (r0 == null) goto L8;
        T r1 = r0.reqContext;
        if (r1 == 0) goto L8;
        if (r1.read_error_response == false) goto L8;
        return true;
    L8:
        return false;
    }

    public static void tryNecessaryInit(Request r4, BaseHttpRequestInfo r5) {
        long r0 = SystemClock.uptimeMillis();
        NetworkParams.tryApiProcessHookInit();
        if (NetworkParams.interceptCookie(r4.getExtraInfo()) == true) goto L5;
        NetworkParams.tryCookieManagerInit();
    L5:
        RetrofitMetrics r6 = r5.metrics;
        if (r6 == null) goto L9;
        r6.tryNecessaryInitDuration = SystemClock.uptimeMillis() - r0;
        return;
    }

    private void tryRotationHostRetryOnGetResponseCodeException(Request r8, int r9, BaseHttpRequestInfo r10, HttpResponseProvider r11, IOException r12, boolean r13) {
        RequestRetryResult r14 = NetworkParams.shouldRetryRequestOnceTime(r8, r9, r10, r8.getHeaders(), null, r13, false);
        if (r14 != null) goto L5;
        throw r12;
    L5:
        if (r14.isRequestRetryEnabled() == true) goto L7;
        throw r12;
    L7:
        if (r10.rotationHostRetry == false) goto L12;
        retryCurrentRequestOneTime(r8.newBuilder().url(r14.getNextRetryUrl()).build(), r10, r11, r14.getAddRequestHeaders());
        return;
    L12:
        throw r12;
    }

    public static void updateRequestInfoWithException(String r3, BaseHttpRequestInfo r4, HttpResponseProvider r5, RequestLogProvider r6, Exception r7) {
        String r0 = getAllHeaderFieldsString(r5.responseHeaders());     // Catch: Throwable -> L5
        if (StringUtils.isEmpty(r0) == true) goto L7;
        r4.extraInfo.put("response-headers", r0);     // Catch: Throwable -> L5
    L7:
        String r1 = r7.getMessage();     // Catch: Throwable -> L5
        Throwable r2 = r7.getCause();     // Catch: Throwable -> L5
        if (TextUtils.isEmpty(r1) == true) goto L13;
        if (r2 == null) goto L13;
        if (TextUtils.isEmpty(r2.getMessage()) == true) goto L13;
        r1 = r1 + ", cause = " + r2.getMessage();     // Catch: Throwable -> L5
    L13:
        r4.extraInfo.put(BaseHttpRequestInfo.KEY_EXCEPTION, r1);     // Catch: Throwable -> L5
    L14:
        r5.safeClose();
        if (StringUtils.isEmpty(r4.remoteIp) == false) goto L20;
        getRemoteIp(getHostAddress(r7), r4);
    L20:
        r4.requestEnd = System.currentTimeMillis();
        if (r4.downloadFile == false) goto L23;
        r4.hasReportStreamingApiAll.set(true);
    L23:
        getRequestMetrics(r4, r6);
        NetworkParams.handleApiError(r3, r7, r4);
        return;
    L5:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        r5.safeClose();
        throw th;
    }

    public boolean bypassNetworkStatusCheck() {
        return false;
    }

    public void checkNetworkAvailableAfterRequest(Request r1, Exception r2) {
    }

    public IOException convertException(Exception r2) {
        return new IOException(r2.getMessage(), r2.getCause());
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public Response execute() {
        RetrofitMetrics r0 = this.requestInfo.metrics;
        if (r0 == null) goto L6;
        r0.callExecuteStartTime = System.currentTimeMillis();
    L6:
        if (this.canceled == true) goto L70;
        onExecuteStart();
        tryNecessaryInit(this.retrofitRequest, this.requestInfo);
        checkNetworkAvailableBeforeRequest(bypassNetworkStatusCheck(), getContext(), this.retrofitRequest.getPath());
        prepareNetworkRequest(this.retrofitRequest.getUrl(), this.retrofitRequest, this.requestInfo, null);
        boolean r9 = false;
    L18:
        e = e;
    L71:
        onProcessExceptionStart(e);     // Catch: Throwable -> L47
        if ((e instanceof HttpResponseException) == false) goto L50;
        if (((HttpResponseException) e).getStatusCode() != 304) goto L50;
        throw e;     // Catch: Throwable -> L47
    L50:
        if ((e instanceof IOException) == true) goto L52;
    L55:
        updateRequestInfoWithException(this.retrofitRequest.getUrl(), this.requestInfo, this, this, e);     // Catch: Throwable -> L47
        checkNetworkAvailableAfterRequest(this.retrofitRequest, e);     // Catch: Throwable -> L47
        if (this.retrofitRequest.isResponseStreaming() == false) goto L59;
        this.requestInfo.hasReportStreamingApiAll.set(true);     // Catch: Throwable -> L47
    L59:
        throw convertException(e);     // Catch: Throwable -> L47
    L52:
        if ("Canceled".equals(e.getMessage()) == false) goto L55;
        throw e;     // Catch: Throwable -> L47
    L47:
        th = th;
        boolean r11 = r9;
        r9 = true;
    L61:
        if (this.retrofitRequest.isResponseStreaming() == false) goto L63;
        if (r9 == true) goto L63;
    L65:
        if (this.retrofitRequest.isResponseStreaming() == true) goto L68;
        if (r11 == false) goto L68;
        DeviceBandwidthSampler.getInstance().stopSampling();
    L68:
        throw th;
    L63:
        safeClose();
    L16:
        th = th;
        r11 = false;
        goto L61
    L9:
        if (this.retrofitRequest.isResponseStreaming() == true) goto L20;
        NetworkParams.ConnectionQualitySamplerHook r1 = NetworkParams.getConnectionQualitySamplerHook();     // Catch: Throwable -> L16 Exception -> L18
        if (r1 == null) goto L20;
        if (r1.shouldSampling(this.retrofitRequest.getUrl()) == false) goto L20;
        DeviceBandwidthSampler.getInstance().startSampling();     // Catch: Throwable -> L16 Exception -> L18
        r11 = true;
    L76:
        List<String> r12 = new ArrayList();     // Catch: Throwable -> L24 Exception -> L26
        executeNetworkRequest();     // Catch: Throwable -> L24 Exception -> L26 IOException -> L28
        r12 = retryRequestOnceIfNeeded(this.retrofitRequest, this.requestInfo, this, true, false);     // Catch: Throwable -> L24 Exception -> L26 IOException -> L28
    L31:
        onFinalResponseReceived(this.requestInfo, this);     // Catch: Throwable -> L24 Exception -> L26
        String r2 = this.retrofitRequest.getUrl();     // Catch: Throwable -> L24 Exception -> L26
        Request r3 = this.retrofitRequest;     // Catch: Throwable -> L24 Exception -> L26
        BaseHttpRequestInfo r4 = this.requestInfo;     // Catch: Throwable -> L24 Exception -> L26
        TypedInput r5 = processResponseBody(r2, r3, r4, this, this, this, isForceConstructResponse(r4));     // Catch: Throwable -> L24 Exception -> L26
        onResponseBodyProcessed(r5);     // Catch: Throwable -> L24 Exception -> L26
        Response r6 = new Response(this.retrofitRequest.getUrl(), responseCode(), responseMessage(), createHeaders(this, r12), r5);     // Catch: Throwable -> L24 Exception -> L26
        r6.setExtraInfo(this.requestInfo);     // Catch: Throwable -> L24 Exception -> L26
        r6.setTraceCode(this.requestInfo.traceCode);     // Catch: Throwable -> L24 Exception -> L26
    L33:
        if (this.retrofitRequest.isResponseStreaming() == true) goto L37;
        safeClose();
    L37:
        if (this.retrofitRequest.isResponseStreaming() == true) goto L40;
        if (r11 == false) goto L40;
        DeviceBandwidthSampler.getInstance().stopSampling();
    L40:
        return r6;
    L28:
        e = move-exception;
        tryRotationHostRetryOnGetResponseCodeException(this.retrofitRequest, getStatusCodeFromException(e), this.requestInfo, this, e, true);     // Catch: Throwable -> L24 Exception -> L26
    L26:
        e = e;
        r9 = r11;
    L24:
        th = th;
        goto L61
    L20:
        r11 = false;
        goto L76
    L70:
        throw new IOException("request canceled");
    }

    public abstract void executeNetworkRequest();

    public abstract Context getContext();

    @Override // com.bytedance.retrofit2.client.SsCall
    public Request getRequest() {
        return this.retrofitRequest;
    }

    @Override // com.bytedance.retrofit2.IRequestInfo
    public Object getRequestInfo() {
        return this.requestInfo;
    }

    public int getStatusCodeFromException(IOException r1) {
        return -1;
    }

    public void onExecuteStart() {
    }

    public void onFinalResponseReceived(BaseHttpRequestInfo r3, HttpResponseProvider r4) {
        r3.responseBack = System.currentTimeMillis();
        r3.contentType = BaseHttpClient.getContentBaseType(r4.contentType());
        getRemoteIp(r4.responseHeaderValue("x-net-info.remoteaddr"), r3);
        T r2 = r3.reqContext;
        if (r2 == 0) goto L5;
        r2.status = r4.responseCode();
    L5:
        String r5 = r4.responseHeaderValue("X-TT-LOGID");
        r3.traceCode = r5;
        if (r5 != null) goto L8;
        r3.traceCode = "";
    L8:
        RetrofitMetrics r6 = r3.metrics;
        if (r6 == null) goto L11;
        r6.traceCode = r3.traceCode;
    L11:
        r3.fromCache = r4.fromCache();
    }

    public void onProcessExceptionStart(Exception r1) {
    }

    public void onResponseBodyProcessed(TypedInput r1) {
    }

    public abstract void prepareNetworkRequest(String r1, Request r2, BaseHttpRequestInfo r3, Map<String, String> r4);

    public void retryCurrentRequestOneTime(Request r8, BaseHttpRequestInfo r9, HttpResponseProvider r10, Map<String, String> r11) {
        r10.safeClose();
        r9.requestRetryStart = System.currentTimeMillis();
        prepareNetworkRequest(r8.getUrl(), r8, r9, r11);
        executeNetworkRequest();     // Catch: IOException -> L5
        retryRequestOnceIfNeeded(r8, r9, this, false, false);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        tryRotationHostRetryOnGetResponseCodeException(r8, getStatusCodeFromException(e), r9, r10, e, false);
    }

    public List<String> retryRequestOnceIfNeeded(Request r8, BaseHttpRequestInfo r9, HttpResponseProvider r10, boolean r11, boolean r12) {
        RequestRetryResult r13 = NetworkParams.shouldRetryRequestOnceTime(r8, r10.responseCode(), r9, r8.getHeaders(), r10.responseHeaders(), r11, r12);
        ArrayList r14 = null;
        if (r13 == null) goto L12;
        if (r13.isRequestRetryEnabled() == false) goto L12;
        if (r9.rotationHostRetry == false) goto L9;
        r8 = r8.newBuilder().url(r13.getNextRetryUrl()).build();
    L9:
        retryCurrentRequestOneTime(r8, r9, r10, r13.getAddRequestHeaders());
        return null;
    L12:
        if (StringUtils.isEmpty(r9.retryByHeaderFilterKey) == true) goto L19;
        if (r13 != null) goto L15;
    L16:
        r14 = new ArrayList();
        if (StringUtils.isEmpty(r9.retryByHeaderFilterKey) == true) goto L19;
        r14.add(r9.retryByHeaderFilterKey);
        goto L19
    L15:
        if (r13.isRemoveHitResponseHeaderIfNotRetry() == true) goto L16;
    L19:
        return r14;
    }
}
