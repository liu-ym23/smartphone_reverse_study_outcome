package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.constraintlayout.core.state.b;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.BaseHttpClient;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall;
import com.bytedance.frameworks.baselib.network.http.parser.RequestTimeoutParser;
import com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionManager;
import com.bytedance.retrofit2.IMetricsCollect;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.mime.AbsTypedOutput;
import com.bytedance.retrofit2.mime.TTRequestCompressManager;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.retrofit2.ttnet.TTNetExceptionStorage;
import com.ss.android.http.legacy.protocol.HTTP;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseCronetSsCall extends BaseSsCall implements IMetricsCollect {
    private static final String BODY_CONTENT_ENCODING = "x-bd-content-encoding";
    private static final int CHUNK_SIZE = 4096;
    private static final String INTERNET_DISCONNECTED = "net::ERR_INTERNET_DISCONNECTED";
    private static final String TAG = "BaseCronetSsCall";
    protected static volatile boolean TNC_USE_ZERO_COPY_READ = true;
    protected static volatile boolean USER_USE_ZERO_COPY_READ = false;
    private static final String USE_TTNET_CONTENT_ENCODING = "x-metasec-content-encoding";
    protected volatile int responseCode;
    private volatile long throttleNetSpeed;

    public BaseCronetSsCall(Request r4) {
        super(r4);
        this.responseCode = 0;
        this.throttleNetSpeed = 0;
        BaseHttpRequestInfo r0 = this.requestInfo;     // Catch: Exception -> L5
        r0.httpClientType = 0;     // Catch: Exception -> L5
        r0.requestStartAppResumeState = BaseHttpClient.GetAppActivityResumeState();     // Catch: Exception -> L5
        this.requestInfo.extraInfo.put(BaseHttpRequestInfo.KEY_HTTP_CLIENT, SsCronetHttpClient.TAG);     // Catch: Exception -> L5
        this.requestInfo.extraInfo.put(BaseHttpRequestInfo.KEY_HTTP_CLIENT_VERSION, SsCronetHttpClient.getCronetVersion());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public static /* synthetic */ void a(String r0, String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10) {
        lambda$onResponseBodyProcessed$0(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    private static void addABTestInfo(JSONObject r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (SsCronetHttpClient.getCronetTncInfoGet() == null) goto L7;
        JSONObject r0 = SsCronetHttpClient.getCronetTncInfoGet().getABTest();
    L8:
        if (r0 == null) goto L16;
        r2.put(BaseHttpRequestInfo.KEY_ABTEST, r0);     // Catch: JSONException -> L11
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L16:
        return;
    L7:
        r0 = null;
        goto L8
    }

    private void checkCronetNetworkAvailableAfterRequest(boolean r2, String r3, String r4) {
        if (r2 == true) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return;
    L6:
        if (r3.contains(INTERNET_DISCONNECTED) == false) goto L12;
        NetworkNotAvailabeException r1 = new NetworkNotAvailabeException("network not available for " + r4 + ", message:" + r3);
        r1.setShouldReport(true);
        throw r1;
    }

    private int getCustomInputStreamBufferSize(Request r1) {
        return SsCronetHttpClient.getCronetInputstreamBuffSize(r1.getPath(), this.requestInfo);
    }

    private static String getRequestBodyStub(TypedOutput r2) {
        if ((r2 instanceof AbsTypedOutput) == false) goto L5;
        AbsTypedOutput r0 = (AbsTypedOutput) r2;
        if (TextUtils.isEmpty(r0.bodyCompressType()) == true) goto L9;
        String r3 = r0.getBodyMd5Stub();
        if (TextUtils.isEmpty(r3) == false) goto L13;
        Logger.e(TAG, "Request compress body md5 shouldn't be null.");
    L13:
        return r3;
    L9:
        return r2.md5Stub();
    L5:
        return r2.md5Stub();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> T getValue(Object r1, Class<T> r2, T r3) {
        if (r1 != 0) goto L4;
    L6:
        return r3;
    L4:
        if (r1.getClass().equals(r2) == false) goto L6;
        return r1;
    }

    private static /* synthetic */ void lambda$onResponseBodyProcessed$0(String r0, String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10) {
        SsCronetHttpClient.notifyStoreRegionUpdated(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    private static void recordContentEncodingError(Request r2) {
        if (r2.getMetrics() != null) goto L5;
        return;
    L5:
        Header r0 = r2.getFirstHeader(BODY_CONTENT_ENCODING);
        if (r0 != null) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r0.getValue()) == true) goto L19;
        JSONObject r3 = r2.getMetrics().requestCompressInfo;
        if (r3 != null) goto L16;
        return;
    L16:
        r3.put("encode", r0.getValue());     // Catch: JSONException -> L15
        r3.put("disableReason", TTRequestCompressManager.DisableCompress.REMOVE_ENCODING.getReason());     // Catch: JSONException -> L15
        return;
    L20:
        return;
    }

    private static void recordRequestCompressInfo(long r3, long r5, int r7, long r8, Request r10, TTRequestCompressManager.CompressData r11) {
        if (r10.getMetrics() != null) goto L5;
        return;
    L5:
        JSONObject r1 = new JSONObject();
        r1.put("beforeSize", r3);     // Catch: JSONException -> L10
        if (r7 == 0) goto L12;
        r1.put("disableReason", r7);     // Catch: JSONException -> L10
    L12:
        if (r11 != null) goto L36;
        r10.getMetrics().requestCompressInfo = r1;
        return;
    L36:
    L18:
        e = move-exception;
        e.printStackTrace();
    L32:
        r10.getMetrics().requestCompressInfo = r1;
        return;
    L16:
        if (TextUtils.isEmpty(r11.contentEncoding) == true) goto L20;
        r1.put("type", r11.contentEncoding);     // Catch: JSONException -> L18
        r1.put("afterSize", r5);     // Catch: JSONException -> L18
    L20:
        int r4 = r11.failedCode;     // Catch: JSONException -> L18
        if (r4 == 0) goto L29;
        r1.put("disableReason", r4);     // Catch: JSONException -> L18
        if (r11.failedCode == TTRequestCompressManager.DisableCompress.GZIP_PREFIX_MISMATCH.getReason()) goto L27;
        if (r11.failedCode != TTRequestCompressManager.DisableCompress.ZSTD_PREFIX_MISMATCH.getReason()) goto L29;
    L27:
        if (TextUtils.isEmpty(r11.failedPrefixData) == true) goto L29;
        r1.put("prefix", r11.failedPrefixData);     // Catch: JSONException -> L18
    L29:
        r1.put("duration", System.currentTimeMillis() - r8);     // Catch: JSONException -> L18
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public static void setTncUseZeroCopyRead(boolean r0) {
        TNC_USE_ZERO_COPY_READ = r0;
    }

    public static void setUseZeroCopyRead(boolean r0) {
        USER_USE_ZERO_COPY_READ = r0;
    }

    private static boolean shouldUseTTNetContentEncoding(Request r1) {
        Header r2 = r1.getFirstHeader(USE_TTNET_CONTENT_ENCODING);
        if (r2 != null) goto L7;
        return false;
    L7:
        return "1".equals(r2.getValue());
    }

    private static String tryCompressRequestBody(TypedOutput r11, Request r12) {
        if ((r11 instanceof AbsTypedOutput) == false) goto L22;
        if (r12 == null) goto L22;
        AbsTypedOutput r0 = (AbsTypedOutput) r11;
        if (TextUtils.isEmpty(r0.bodyCompressType()) == false) goto L9;
        long r2 = r11.length();
        long r7 = System.currentTimeMillis();
        if (r0.isBodyEncrypted() == true) goto L13;
    L16:
        TTRequestCompressManager.CompressData r9 = r0.compressRequestBody(r12.getHost(), r12.getPath(), shouldUseTTNetContentEncoding(r12));
        if (r9 != null) goto L20;
        recordRequestCompressInfo(r2, 0, TTRequestCompressManager.DisableCompress.DATA_NULL.getReason(), r7, r12, null);
        return null;
    L20:
        recordRequestCompressInfo(r2, r11.length(), 0, r7, r12, r9);
        return r9.contentEncoding;
    L13:
        if (TTRequestCompressManager.isBodyOptEnabled() == false) goto L16;
        recordRequestCompressInfo(r2, 0, TTRequestCompressManager.DisableCompress.BODY_ENCRYPTED.getReason(), r7, r12, null);
        return null;
    L9:
        return r0.bodyCompressType();
    L22:
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    public boolean bypassNetworkStatusCheck() {
        if (this.bypassNetworkStatusCheck == false) goto L5;
    L8:
        return true;
    L5:
        if (SsCronetHttpClient.getGlobalBypassOfflineCheck() == true) goto L8;
        return false;
    }

    public void cancelInner(HttpURLConnection r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (this.canceled == true) goto L17;
        r10.disconnect();
        this.canceled = true;
        if (this.retrofitRequest.isResponseStreaming() == false) goto L16;
        doCollect();
        BaseHttpRequestInfo r11 = this.requestInfo;
        r11.requestEnd = System.currentTimeMillis();
        BaseHttpRequestInfo r12 = this.requestInfo;
        r12.requestStartAppResumeState = BaseHttpClient.GetAppActivityResumeState();
        T r13 = this.requestInfo.reqContext;
        if (r13 != 0) goto L11;
    L12:
        NetworkParams.monitorApiOk(this.retrofitRequest.getUrl(), this.requestInfo);
    L13:
        StreamTrafficObservable r1 = StreamTrafficObservable.inst();
        String r2 = this.retrofitRequest.getUrl();
        BaseHttpRequestInfo r9 = this.requestInfo;
        r1.onStreamTrafficChanged(r2, r9.sentByteCount, r9.receivedByteCount, r9.contentType, r9.requestLog);
        return;
    L11:
        if (r13.is_need_monitor_in_cancel == false) goto L13;
    L16:
        return;
    }

    public void cancelNormalRequestInner(HttpURLConnection r9, Throwable r10, boolean r11) {
        if (r9 != null) goto L4;
        return;
    L4:
        if (this.canceled == true) goto L17;
        r9.disconnect();
        this.canceled = true;
        doCollect();
        BaseHttpRequestInfo r12 = this.requestInfo;
        r12.requestEnd = System.currentTimeMillis();
        BaseHttpRequestInfo r13 = this.requestInfo;
        r13.requestStartAppResumeState = BaseHttpClient.GetAppActivityResumeState();
        BaseHttpRequestInfo r14 = this.requestInfo;
        T r0 = r14.reqContext;
        if (r0 != 0) goto L9;
    L10:
        NetworkParams.reportOneNormalRequest(this.retrofitRequest, r14, r10, Boolean.valueOf(r11));
    L12:
        if (this.retrofitRequest.isResponseStreaming() == false) goto L16;
        StreamTrafficObservable r1 = StreamTrafficObservable.inst();
        String r2 = this.retrofitRequest.getUrl();
        BaseHttpRequestInfo r8 = this.requestInfo;
        r1.onStreamTrafficChanged(r2, r8.sentByteCount, r8.receivedByteCount, r8.contentType, r8.requestLog);
        return;
    L16:
        return;
    L9:
        if (r0.is_need_monitor_in_cancel == false) goto L12;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    public void checkNetworkAvailableAfterRequest(Request r2, Exception r3) {
        checkCronetNetworkAvailableAfterRequest(SsCronetHttpClient.getGlobalBypassOfflineCheck(), r3.getMessage(), this.retrofitRequest.getPath());
    }

    public void configureConnection(Request r20, BaseHttpRequestInfo r21, HttpURLConnection r22, Map<String, String> r23) {
        long r4 = SystemClock.uptimeMillis();
        r22.setRequestMethod(r20.getMethod());
        r22.setDoInput(true);
        r22.setInstanceFollowRedirects(true);
        T r0 = r21.reqContext;
        if (r0 == 0) goto L5;
        r22.setInstanceFollowRedirects(r0.followRedirectInternal);
    L5:
        String r1 = r20.getPath();
        T r7 = r21.reqContext;
        if (r7 != 0) goto L8;
        int r8 = 0;
    L9:
        int r2 = SsCronetHttpClient.getCronetOutputStreamBufferSize(r1, r8);
        if (r2 <= 0) goto L18;
        Reflect.on(r22).call("setOutputStreamBufferSize", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r2)});     // Catch: Throwable -> L15
        if (r20.getMetrics() == null) goto L18;
        r20.getMetrics().postBodyBufferSize = r2;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.printStackTrace();
    L18:
        if (r21.customInputStreamSize > 0) goto L194;
    L23:
        T r9 = r21.reqContext;
        if (r9 == 0) goto L80;
        long r10 = r9.timeout_connect;
        if (r10 <= 0) goto L28;
        r22.setConnectTimeout((int) r10);
    L28:
        long r11 = r9.timeout_read;
        if (r11 <= 0) goto L32;
        r22.setReadTimeout((int) r11);
    L32:
        if (r9.protect_timeout > 0) goto L196;
    L48:
        String r13 = "setSocketWriteTimeout";
    L49:
        int r12 = r9.request_type_flags;
        int r3 = r9.request_flag;
        if (r9.enable_http_cache == true) goto L52;
    L53:
        r3 = r3 | 16;
    L55:
        if (r9.byPassProxy == false) goto L57;
        r3 = r3 | 128;
    L57:
        if (r3 <= 0) goto L63;
        Reflect.on(r22).call("setRequestFlag", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r3)});     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        th.printStackTrace();
    L63:
        if (r9.isCustomizedCookie == false) goto L65;
        r12 = r12 | 2;
    L65:
        if (r12 > 0) goto L198;
    L70:
        BaseRequestContext.AuthCredentials r5 = r9.authCredentials;
        if (r5 != null) goto L73;
    L81:
        T r6 = r21.reqContext;
        if (r6 != 0) goto L84;
    L85:
        RequestTimeoutParser.SocketTimeoutParam r14 = new RequestTimeoutParser.SocketTimeoutParam();
        int r15 = RequestTimeoutParser.getRequestTimeout(r22.getURL(), r14);
        r22.addRequestProperty("x-ttnet-bypass-to", Integer.toString(r15));
        if (r15 <= 0) goto L200;
        Reflect r16 = Reflect.on(r22);     // Catch: Throwable -> L90
        Class r17 = Integer.TYPE;     // Catch: Throwable -> L90
        r16.call("setRequestTimeout", new Class[]{r17}, new Object[]{Integer.valueOf(r15 * 1000)});     // Catch: Throwable -> L90
        r22.setConnectTimeout(0);     // Catch: Throwable -> L90
        r22.setReadTimeout(0);     // Catch: Throwable -> L90
        if (r14.connectTimeout <= 0) goto L93;
        Reflect.on(r22).call("setSocketConnectTimeout", new Class[]{r17}, new Object[]{Integer.valueOf(r14.connectTimeout * 1000)});     // Catch: Throwable -> L90
    L93:
        if (r14.readTimeout <= 0) goto L96;
        Reflect.on(r22).call("setSocketReadTimeout", new Class[]{r17}, new Object[]{Integer.valueOf(r14.readTimeout * 1000)});     // Catch: Throwable -> L90
    L96:
        if (r14.writeTimeout <= 0) goto L200;
        Reflect.on(r22).call(r13, new Class[]{r17}, new Object[]{Integer.valueOf(r14.writeTimeout * 1000)});     // Catch: Throwable -> L90
    L90:
        th = move-exception;
        th.printStackTrace();
    L200:
        Reflect.on(r22).call("setRequestPriority", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r20.getRequestPriorityLevel())});     // Catch: Throwable -> L102
    L104:
        T r18 = r21.reqContext;
        if (r18 == 0) goto L110;
        long r19 = r18.throttle_net_speed;
        long r24 = 0;
        if (r19 > 0) goto L113;
    L111:
        r19 = this.throttleNetSpeed;
    L113:
        if (r19 > r24) goto L182;
    L118:
        Iterator<Header> r25 = r20.getHeaders().iterator();
        String r26 = "";
    L120:
        if (r25.hasNext() == false) goto L136;
        Header r27 = r25.next();
        if (StringUtils.isEmpty(r27.getName()) == true) goto L120;
        if (StringUtils.isEmpty(r27.getValue()) == true) goto L120;
        if (TTRequestCompressManager.isBodyOptEnabled() == false) goto L132;
        if (BODY_CONTENT_ENCODING.equalsIgnoreCase(r27.getName()) == true) goto L120;
    L132:
        if ("User-Agent".equalsIgnoreCase(r27.getName()) == false) goto L134;
        r26 = r27.getValue();
    L134:
        r22.setRequestProperty(r27.getName(), r27.getValue());
        goto L120
    L136:
        if (StringUtils.isEmpty(r26) == false) goto L186;
        r26 = NetworkParams.getUserAgent();
        if (StringUtils.isEmpty(r26) == true) goto L186;
        r26 = r26 + " cronet/" + SsCronetHttpClient.getCronetVersion();     // Catch: Exception -> L141
    L143:
        r22.setRequestProperty("User-Agent", r26);
    L141:
        e = move-exception;
        e.printStackTrace();
    L186:
        r21.extraInfo.put(BaseHttpRequestInfo.KEY_USER_AGENT, r26);     // Catch: Exception -> L146
    L148:
        TypedOutput r28 = r20.getBody();
        if (r28 == null) goto L163;
        r22.setDoOutput(true);
        r22.setRequestProperty("Content-Type", r28.mimeType());
        String r29 = getRequestBodyStub(r28);
        if (r29 == null) goto L153;
        r22.setRequestProperty("X-SS-STUB", r29);
    L153:
        String r30 = tryCompressRequestBody(r28, r20);
        if (TextUtils.isEmpty(r30) == true) goto L157;
        r22.setRequestProperty(BODY_CONTENT_ENCODING, r30);
    L159:
        long r31 = r28.length();
        if (r31 == (-1)) goto L162;
        r22.setFixedLengthStreamingMode((int) r31);
        r22.setRequestProperty(HTTP.CONTENT_LEN, String.valueOf(r31));
        goto L163
    L162:
        r22.setChunkedStreamingMode(4096);
        goto L163
    L157:
        if (TTRequestCompressManager.isBodyOptEnabled() == false) goto L159;
        recordContentEncodingError(r20);
    L163:
        if (r23 != null) goto L165;
    L174:
        r21.url = r22.getURL();
        RetrofitMetrics r32 = r21.metrics;
        if (r32 == null) goto L219;
        r32.prepareRequestDuration = SystemClock.uptimeMillis() - r4;
        r21.metrics.url = r21.url;
        return;
    L219:
        return;
    L165:
        if (r23.isEmpty() == true) goto L174;
        Iterator<Map.Entry<String, String>> r33 = r23.entrySet().iterator();
    L168:
        if (r33.hasNext() == false) goto L174;
        Map.Entry<String, String> r34 = r33.next();
        String r35 = r34.getKey();
        String r36 = r34.getValue();
        if (TextUtils.isEmpty(r35) == true) goto L168;
        if (TextUtils.isEmpty(r36) == true) goto L168;
        r22.setRequestProperty(r35, r36);
    L146:
        e = move-exception;
        e.printStackTrace();
        goto L148
    L182:
        Reflect.on(r22).call("setThrottleNetSpeed", new Class[]{Integer.TYPE}, new Object[]{Long.valueOf(r19)});     // Catch: Throwable -> L116
    L116:
        th = move-exception;
        th.printStackTrace();
        goto L118
    L110:
        r24 = 0;
    L102:
        th = move-exception;
        th.printStackTrace();
        goto L104
    L84:
        if (r6.protect_timeout > 0) goto L200;
    L73:
        if (r5.username == null) goto L81;
        if (r5.password == null) goto L81;
        Reflect.on(r22).call("setAuthCredentials", new Class[]{String.class, String.class}, new Object[]{r5.username, r5.password});     // Catch: Throwable -> L78
    L78:
        th = move-exception;
        th.printStackTrace();
        goto L81
    L198:
        Reflect.on(r22).call("setRequestTypeFlags", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r12)});     // Catch: Throwable -> L68
    L68:
        th = move-exception;
        th.printStackTrace();
        goto L70
    L52:
        if ((r12 & 1) > 0) goto L55;
    L196:
        Reflect r37 = Reflect.on(r22);     // Catch: Throwable -> L40
        Class r38 = Integer.TYPE;     // Catch: Throwable -> L40
        r37.call("setRequestTimeout", new Class[]{r38}, new Object[]{Integer.valueOf((int) r9.protect_timeout)});     // Catch: Throwable -> L40
        r22.setConnectTimeout(0);     // Catch: Throwable -> L40
        r22.setReadTimeout(0);     // Catch: Throwable -> L40
        if (r9.socket_connect_timeout <= 0) goto L36;
    L42:
        Reflect.on(r22).call("setSocketConnectTimeout", new Class[]{r38}, new Object[]{Integer.valueOf((int) r9.socket_connect_timeout)});     // Catch: Throwable -> L40
        Reflect.on(r22).call("setSocketReadTimeout", new Class[]{r38}, new Object[]{Integer.valueOf((int) r9.socket_read_timeout)});     // Catch: Throwable -> L40
        r13 = "setSocketWriteTimeout";
        Reflect.on(r22).call(r13, new Class[]{r38}, new Object[]{Integer.valueOf((int) r9.socket_write_timeout)});     // Catch: Throwable -> L46
    L46:
        th = th;
    L47:
        th.printStackTrace();
        goto L49
    L36:
        if (r9.socket_read_timeout > 0) goto L42;
        if (r9.socket_write_timeout <= 0) goto L48;
    L40:
        th = th;
        r13 = "setSocketWriteTimeout";
        goto L47
    L80:
        r13 = "setSocketWriteTimeout";
        goto L81
    L194:
        Reflect.on(r22).call("setInputStreamBufferSize", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r21.customInputStreamSize)});     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.printStackTrace();
        goto L23
    L8:
        r8 = r7.output_stream_buffer_size;
        goto L9
    }

    public abstract HttpURLConnection connection();

    public HttpURLConnection constructConnection(String r5, BaseHttpRequestInfo r6) {
        long r0 = SystemClock.uptimeMillis();
        HttpURLConnection r4 = SsCronetHttpClient.openConnection(r5, r6);
        RetrofitMetrics r7 = r6.metrics;
        if (r7 == null) goto L5;
        r7.openConnectionDuration = SystemClock.uptimeMillis() - r0;
    L5:
        return r4;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public long contentLength() {
        if (connection() != null) goto L7;
        return 0;
    L7:
        return connection().getContentLength();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public String contentType() {
        return responseHeaderValue("Content-Type");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public InputStream errorStream() {
        if (connection() != null) goto L7;
        return null;
    L7:
        return connection().getErrorStream();
    }

    public int executeConnection(HttpURLConnection r2) {
        TypedOutput r1 = this.retrofitRequest.getBody();
        if (r1 == null) goto L6;
        r1.writeTo(r2.getOutputStream());
    L6:
        return r2.getResponseCode();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    public void executeNetworkRequest() {
        this.responseCode = executeConnection(connection());
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public boolean fromCache() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    public Context getContext() {
        return SsCronetHttpClient.getContext();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public InputStream inputStream() {
        if (connection() != null) goto L7;
        return null;
    L7:
        return connection().getInputStream();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public boolean isGzip() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    public void onResponseBodyProcessed(TypedInput r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (this.retrofitRequest.isResponseStreaming() == false) goto L6;
        return;
    L6:
        if ((r4 instanceof TypedByteArray) == false) goto L14;
        StoreRegionManager.inst().updateStoreRegionForCronet(connection(), ((TypedByteArray) r4).getBytes(), new b(7));     // Catch: Throwable -> L9
        return;
    L15:
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    public void prepareNetworkRequest(String r8, Request r9, BaseHttpRequestInfo r10, Map<String, String> r11) {
        r10.customInputStreamSize = getCustomInputStreamBufferSize(r9);     // Catch: Exception -> L12
        if (TNC_USE_ZERO_COPY_READ == true) goto L6;
    L14:
        boolean r2 = false;
    L15:
        r10.useCronetInputStreamWithTTBuffer = r2;     // Catch: Exception -> L12
        if (Logger.debug() == false) goto L18;
        Logger.e(TAG, "url is " + r8 + " useCronetInputStreamWithTTBuffer: " + r10.useCronetInputStreamWithTTBuffer);     // Catch: Exception -> L12
    L18:
        HttpURLConnection r0 = constructConnection(r8, r10);     // Catch: Exception -> L12
        configureConnection(r9, r10, r0, r11);     // Catch: Exception -> L12
        setConnection(r0);     // Catch: Exception -> L12
        return;
    L6:
        if (USER_USE_ZERO_COPY_READ == false) goto L14;
        if (r10.customInputStreamSize > 0) goto L14;
        if (r10.downloadFile == true) goto L14;
        r2 = true;
    L12:
        e = move-exception;
        BaseSsCall.updateRequestInfoWithException(r8, r10, this, this, e);
        this.canceled = true;
        if ((e instanceof TTNetExceptionStorage) == false) goto L23;
        throw e;
    L23:
        TTNetExceptionStorage r7 = new TTNetExceptionStorage(e.getMessage(), e.getCause());
        r7.setInfo(true, false, true, r8, r10.traceCode, r10);
        throw r7;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public int responseCode() {
        return this.responseCode;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public String responseHeaderValue(String r3) {
        if (connection() != null) goto L6;
        return null;
    L6:
        String r0 = connection().getHeaderField(r3);
        if (TextUtils.isEmpty(r0) == true) goto L9;
        return r0;
    L9:
        return connection().getHeaderField(r3.toLowerCase());
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public Map<String, List<String>> responseHeaders() {
        if (connection() != null) goto L7;
        return null;
    L7:
        return connection().getHeaderFields();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public String responseMessage() {
        if (connection() != null) goto L7;
        return "";
    L7:
        return connection().getResponseMessage();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public void safeClose() {
        if (connection() == null) goto L6;
        connection().disconnect();
        return;
    }

    public void setConnection(HttpURLConnection r1) {
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public boolean setThrottleNetSpeed(long r1) {
        this.throttleNetSpeed = r1;
        return true;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.RequestLogProvider
    public void updateRequestInfoWithRequestLog(BaseHttpRequestInfo r11) {
        Map<String, Object> r10 = SsCronetHttpClient.getRequestMetricsMap(connection());
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isEmpty() == true) goto L16;
        r11.remoteIp = (String) getValue(r10.get(ICronetClient.KEY_REMOTE_IP), String.class, "");
        r11.dnsTime = ((Long) getValue(r10.get(ICronetClient.KEY_DNS_TIME), Long.class, -1L)).longValue();
        r11.connectTime = ((Long) getValue(r10.get(ICronetClient.KEY_CONNECT_TIME), Long.class, -1L)).longValue();
        r11.sslTime = ((Long) getValue(r10.get(ICronetClient.KEY_SSL_TIME), Long.class, -1L)).longValue();
        r11.sendTime = ((Long) getValue(r10.get(ICronetClient.KEY_SEND_TIME), Long.class, -1L)).longValue();
        r11.pushTime = ((Long) getValue(r10.get(ICronetClient.KEY_PUSH_TIME), Long.class, -1L)).longValue();
        r11.receiveTime = ((Long) getValue(r10.get(ICronetClient.KEY_RECEIVE_TIME), Long.class, -1L)).longValue();
        Object r0 = r10.get(ICronetClient.KEY_SOCKET_REUSED);
        Boolean r5 = Boolean.FALSE;
        r11.isSocketReused = ((Boolean) getValue(r0, Boolean.class, r5)).booleanValue();
        r11.ttfbMs = ((Long) getValue(r10.get(ICronetClient.KEY_TTFB), Long.class, -1L)).longValue();
        r11.totalTime = ((Long) getValue(r10.get(ICronetClient.KEY_TOTAL_TIME), Long.class, -1L)).longValue();
        r11.sentByteCount = ((Long) getValue(r10.get(ICronetClient.KEY_SEND_BYTE_COUNT), Long.class, -1L)).longValue();
        r11.receivedByteCount = ((Long) getValue(r10.get(ICronetClient.KEY_RECEIVED_BYTE_COUNT), Long.class, -1L)).longValue();
        r11.requestLog = (String) getValue(r10.get("request_log"), String.class, "");
        r11.retryAttempts = ((Long) getValue(r10.get(ICronetClient.KEY_RETRY_ATTEMPTS), Long.class, -1L)).longValue();
        r11.requestHeaders = (String) getValue(r10.get(ICronetClient.KEY_REQUEST_HEADERS), String.class, "");
        r11.responseHeaders = (String) getValue(r10.get(ICronetClient.KEY_RESPONSE_HEADERS), String.class, "");
        r11.nativePostTaskStartTime = ((Long) getValue(r10.get(ICronetClient.KEY_POST_TASK_START), Long.class, -1L)).longValue();
        r11.nativeRequestStartTime = ((Long) getValue(r10.get(ICronetClient.KEY_REQUEST_START), Long.class, -1L)).longValue();
        r11.nativeWaitContext = ((Long) getValue(r10.get(ICronetClient.KEY_WAIT_CONTEXT), Long.class, -1L)).longValue();
        r11.hasSampled = ((Boolean) getValue(r10.get(ICronetClient.KEY_PRE_SAMPLING_REPORTABLE), Boolean.class, r5)).booleanValue();
        r11.bypassApiReport = ((Boolean) getValue(r10.get(ICronetClient.KEY_BYPASS_API_REPORT), Boolean.class, r5)).booleanValue();
        RetrofitMetrics r1 = r11.metrics;
        if (r1 == null) goto L11;
        r1.upperAddCookieDurationUs = ((Long) getValue(r10.get(ICronetClient.KEY_UPPER_ADD_COOKIE_US), Long.class, -1L)).longValue();
        RetrofitMetrics r2 = r11.metrics;
        r2.upperSaveCookieDurationUs = ((Long) getValue(r10.get(ICronetClient.KEY_UPPER_SAVE_COOKIE_US), Long.class, -1L)).longValue();
        RetrofitMetrics r3 = r11.metrics;
        r3.requestCookieSourceType = ((Integer) getValue(r10.get(ICronetClient.KEY_REQ_COOKIE_SOURCE_TYPE), Integer.class, -1)).intValue();
    L11:
        if (TextUtils.isEmpty(r11.requestLog) == false) goto L15;
        addABTestInfo(r11.extraInfo);
        return;
    L15:
        return;
    }
}
