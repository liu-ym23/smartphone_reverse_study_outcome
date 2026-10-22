package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import android.content.Context;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.constraintlayout.core.state.a;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.exception.NotAllowUseNetworkException;
import com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall;
import com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.HttpDns;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.metadispatch.TTMetaDispatchLog;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.metadispatch.TTMetaDispatchManager;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchResult;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatcher;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLRequest;
import com.bytedance.frameworks.baselib.network.http.parser.StreamParser;
import com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionManager;
import com.bytedance.frameworks.baselib.network.http.util.BoeUtils;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.retrofit2.ttnet.TTNetExceptionStorage;
import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Challenge;
import okhttp3.Credentials;
import okhttp3.EventListener;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.http.HttpMethod;
import okhttp3.ttnet.TTNetUtils;

/* JADX INFO: loaded from: classes.dex */
public class Ok3SsCall extends BaseSsCall implements WeakHandler.IHandler {
    public static final String TAG = "Ok3SsCall";
    private static final int WAIT_REQUEST_FINISHED_TIME_MS = 500;
    OkHttpClient client;
    private final WeakHandler mHandler;
    volatile OkHttp3RequestLog okHttp3RequestLog;
    Request okRequest;
    Response okResponse;
    Call rawCall;

    public Ok3SsCall(com.bytedance.retrofit2.client.Request r3) {
        super(r3);
        this.client = null;
        this.okHttp3RequestLog = null;
        BaseHttpRequestInfo r4 = this.requestInfo;     // Catch: Exception -> L5
        r4.httpClientType = 1;     // Catch: Exception -> L5
        r4.extraInfo.put(BaseHttpRequestInfo.KEY_HTTP_CLIENT, SsOkHttp3Client.TAG);     // Catch: Exception -> L5
        this.requestInfo.extraInfo.put(BaseHttpRequestInfo.KEY_HTTP_CLIENT_VERSION, SsOkHttp3Client.getOkVersion());     // Catch: Exception -> L5
    L7:
        BaseHttpRequestInfo r5 = this.requestInfo;
        r5.fallbackReason = SsOkHttp3Client.getFallbackReason();
        BaseHttpRequestInfo r6 = this.requestInfo;
        r6.fallbackMessage = SsOkHttp3Client.getFallbackMessage();
        BaseHttpRequestInfo r7 = this.requestInfo;
        RetrofitMetrics r0 = r7.metrics;
        if (r0 == null) goto L10;
        r0.fallbackReason = r7.fallbackReason;
        r0.fallbackMessage = r7.fallbackMessage;
    L10:
        this.mHandler = new WeakHandler(HttpDns.getService().getHttpDnsHandlerThread().getLooper(), this);
        String r8 = this.retrofitRequest.getUrl();
        this.okHttp3RequestLog = new OkHttp3RequestLog();
        this.okHttp3RequestLog.setOriginUrl(r8, this.retrofitRequest.getMethod());
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static /* synthetic */ Request a(BaseRequestContext.AuthCredentials r0, Route r1, Response r2) {
        return lambda$configureOkRequest$0(r0, r1, r2);
    }

    public static /* synthetic */ void access$000(Ok3SsCall r0, boolean r1) {
        r0.collectAndReport(r1);
    }

    private void collectAndReport(boolean r2) {
        if (r2 == false) goto L4;
        BaseSsCall.getRequestMetrics(this.requestInfo, this);
    L5:
        T r3 = this.requestInfo.reqContext;
        if (r3 != 0) goto L8;
    L9:
        NetworkParams.monitorApiOk(this.retrofitRequest.getUrl(), this.requestInfo);
        return;
    L8:
        if (r3.is_need_monitor_in_cancel == true) goto L9;
        return;
    L4:
        BaseSsCall.getRequestMetrics(this.requestInfo, null);
        goto L5
    }

    private void configureOkRequest(com.bytedance.retrofit2.client.Request r10, BaseHttpRequestInfo r11, Map<String, String> r12) {
        OkHttpClient.Builder r0 = this.client.newBuilder();
        T r1 = r11.reqContext;
        if (r1 == 0) goto L5;
        r0.followRedirects(r1.followRedirectInternal);
    L5:
        long r2 = NetworkParams.getConnectTimeout();
        TimeUnit r3 = TimeUnit.MILLISECONDS;
        r0.connectTimeout(r2, r3);
        r0.readTimeout(NetworkParams.getIoTimeout(), r3);
        r0.writeTimeout(NetworkParams.getIoTimeout(), r3);
        r0.proxy(SsOkHttp3Client.getProxy());
        r0.enableBoe(BoeUtils.isOkhttpBoeProxyEnabled());
        BaseRequestContext r4 = r11.reqContext;
        if (r4 == null) goto L30;
        long r5 = r4.timeout_connect;
        if (r5 <= 0) goto L10;
        r0.connectTimeout(r5, r3);
    L10:
        long r6 = r4.timeout_write;
        if (r6 <= 0) goto L13;
        r0.writeTimeout(r6, r3);
    L13:
        long r7 = r4.timeout_read;
        if (r7 <= 0) goto L17;
        r0.readTimeout(r7, r3);
    L17:
        if (r4.byPassProxy == false) goto L19;
        r0.proxy(Proxy.NO_PROXY);
    L19:
        BaseRequestContext.AuthCredentials r8 = r4.authCredentials;
        if (r8 != null) goto L22;
    L26:
        BaseRequestContext.IOkHttpRequestClientBuilderHook r9 = r4.okHttpRequestClientBuilderHook;
        if (r9 == null) goto L29;
        r9.addBuilderConfig(r0);
    L29:
        this.okHttp3RequestLog.setRequestTimeout(r4);
        goto L30
    L22:
        if (r8.username == null) goto L26;
        if (r8.password == null) goto L26;
        r0.proxyAuthenticator(new a(r8));
    L30:
        String r13 = r10.getUrl();
        String r14 = null;
        if (this.client.eventListenerFactory() == null) goto L33;
        EventListener r15 = this.client.eventListenerFactory().create(this.client.newCall(new Request.Builder().url(r13).build()));
    L34:
        r0.eventListener(new OkHttp3EventListener(r15, this.okHttp3RequestLog));
        this.client = r0.build();
        ArrayList r16 = new ArrayList();
        if (r10.isBypassDispatch() == false) goto L102;
    L40:
        ArrayList r17 = new ArrayList();
        long r18 = SystemClock.uptimeMillis();
        TTMetaDispatchLog r19 = new TTMetaDispatchLog();
        String r20 = TTMetaDispatchManager.getInstance().dispatch(r13, r10, r19, r17);
        r19.dispatchCostMs = SystemClock.uptimeMillis() - r18;
        this.okHttp3RequestLog.recordMetaDispatchLog(r19);
        boolean r21 = r17.isEmpty();
        List r22 = r17;
        if (r21 == false) goto L43;
        r22 = r10.getHeaders();
    L43:
        Request.Builder r23 = new Request.Builder().url(BoeUtils.tryAddOkhttpBoeSuffix(SsOkHttp3Client.getContext(), r20, r22));
        Iterator r24 = r16.iterator();
    L45:
        if (r24.hasNext() == false) goto L48;
        Header r25 = (Header) r24.next();
        r23.addHeader(r25.getName(), r25.getValue());
        goto L45
    L48:
        if (Logger.debug() == false) goto L51;
        r23.addHeader("fallback-reason", SsOkHttp3Client.getFallbackReasonHeaderValue(r10));
    L51:
        if (HttpMethod.permitsRequestBody(r10.getMethod()) == true) goto L53;
        Request.Builder r26 = r23.method(r10.getMethod(), null);
    L55:
        if (r10.getBody() != null) goto L57;
    L61:
        r26.addHeader("Accept-Encoding", "gzip");
        Iterator r110 = r22.iterator();
    L63:
        if (r110.hasNext() == false) goto L74;
        Header r27 = (Header) r110.next();
        if (StringUtils.isEmpty(r27.getName()) == true) goto L63;
        if (StringUtils.isEmpty(r27.getValue()) == true) goto L63;
        if ("User-Agent".equals(r27.getName()) == false) goto L72;
        r14 = r27.getValue();
    L72:
        r26.header(r27.getName(), r27.getValue());
        goto L63
    L74:
        if (StringUtils.isEmpty(r14) == false) goto L79;
        r14 = NetworkParams.getUserAgent();
        if (StringUtils.isEmpty(r14) == true) goto L79;
        StringBuilder r111 = a.a.t(r14, " ");
        r111.append(SsOkHttp3Client.getOkVersion());
        r14 = r111.toString();
        r26.header("User-Agent", r14);
    L79:
        if (StringUtils.isEmpty(r14) == false) goto L100;
        r14 = SsOkHttp3Client.getDefaultOkhttpUA();
        if (TextUtils.isEmpty(r14) == true) goto L100;
        r26.header("User-Agent", r14);
    L100:
        r11.extraInfo.put(BaseHttpRequestInfo.KEY_USER_AGENT, r14);     // Catch: Exception -> L85
    L87:
        if (r12 != null) goto L89;
    L98:
        Request r112 = r26.build();
        this.okRequest = r112;
        this.rawCall = this.client.newCall(r112);
        return;
    L89:
        if (r12.isEmpty() == true) goto L98;
        Iterator<Map.Entry<String, String>> r113 = r12.entrySet().iterator();
    L92:
        if (r113.hasNext() == false) goto L98;
        Map.Entry<String, String> r114 = r113.next();
        String r115 = r114.getKey();
        String r116 = r114.getValue();
        if (TextUtils.isEmpty(r115) == true) goto L92;
        if (TextUtils.isEmpty(r116) == true) goto L92;
        r26.addHeader(r115, r116);
    L85:
        e = move-exception;
        e.printStackTrace();
        goto L87
    L57:
        if (r10.isPureRequest() == true) goto L61;
        String r117 = r10.getBody().md5Stub();
        if (r117 == null) goto L61;
        r26.addHeader("X-SS-STUB", r117);
        goto L61
    L53:
        r26 = r23.method(r10.getMethod(), createRequestBody(r10.getBody(), r10.getRequestBody()));
        goto L55
    L102:
        r13 = doOkHttpDispatch(r13, r10.getMethod(), r16);     // Catch: Exception -> L38
    L38:
        e = move-exception;
        e.printStackTrace();
        goto L40
    L33:
        r15 = null;
        goto L34
    }

    private void constructOkHttpClient() {
        this.client = SsOkHttp3Client.constructOkHttpClient();
    }

    private static RequestBody createRequestBody(final TypedOutput r1, RequestBody r2) {
        if (r2 == null) goto L4;
        return r2;
    L4:
        if (r1 == null) goto L6;
        final MediaType r3 = MediaType.parse(r1.mimeType());
        return new AnonymousClass2(r3, r1);
    L6:
        return RequestBody.create(null, "body=null");
    }

    private String doOkHttpDispatch(String r12, String r13, List<Header> r14) {
        if (URLDispatcher.inst().isDispatchActionsEmpty() == true) goto L22;
        long r0 = System.currentTimeMillis();
        DispatchResult r15 = URLDispatcher.inst().getDispatchResultForUrl(new URLRequest(r12, r13, r14));
        long r2 = System.currentTimeMillis();
        if (r15 == null) goto L30;
        this.okHttp3RequestLog.recordDispatchLog(this.retrofitRequest.getMethod(), r15.mDispatchedURL, r2 - r0, false, r15.mDispatchActionChain);
        if (r12.equals(r15.mDispatchedURL) == false) goto L9;
        return r12;
    L9:
        if (r15.mDispatchedURL.isEmpty() == false) goto L19;
        if (r15.mActionRuleIdList.isEmpty() == true) goto L19;
        this.okHttp3RequestLog.setNetError(r15.mDropCode);
        StringBuilder r16 = new StringBuilder("ERR_TTNET_TRAFFIC_CONTROL_DROP");
        if (r15.mDropCode != (-555)) goto L15;
        String r17 = "";
    L16:
        r16.append(r17);
        r16.append(", ");
        r16.append(r15.mDropCode);
        throw new Exception(r16.toString());
    L15:
        r17 = "_" + (-r15.mDropCode);
    L19:
        if (UrlUtils.isValidUrl(r15.mDispatchedURL) == true) goto L33;
        return r12;
    L33:
        return r15.mDispatchedURL;
    L30:
        return r12;
    L22:
        if (Logger.debug() == false) goto L24;
        Logger.d(TAG, "fallback to host replace map");
    L24:
        long r18 = System.currentTimeMillis();
        String r1 = URLDispatcher.inst().handleHostMapping(r12);
        long r3 = System.currentTimeMillis();
        if (r12.equals(r1) == false) goto L27;
        return r12;
    L27:
        if (UrlUtils.isValidUrl(r1) == false) goto L35;
        this.okHttp3RequestLog.recordDispatchLog(this.retrofitRequest.getMethod(), r1, r3 - r18, true, null);
        return r1;
    L35:
        return r12;
    }

    private static /* synthetic */ Request lambda$configureOkRequest$0(BaseRequestContext.AuthCredentials r4, Route r5, Response r6) {
        Iterator<Challenge> r7 = r6.challenges().iterator();
    L4:
        if (r7.hasNext() == false) goto L13;
        Challenge r0 = r7.next();
        if ("Basic".equalsIgnoreCase(r0.scheme()) == false) goto L4;
        String r8 = Credentials.basic(r4.username, r4.password, r0.charset());
        if (TextUtils.equals(r8, r6.request().header("Proxy-Authorization")) == false) goto L12;
        return null;
    L12:
        return r6.request().newBuilder().header("Proxy-Authorization", r8).build();
    L13:
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    public boolean bypassNetworkStatusCheck() {
        return this.bypassNetworkStatusCheck;
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public void cancel() {
        Call r0 = this.rawCall;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isCanceled() == true) goto L17;
        this.rawCall.cancel();
        this.canceled = true;
        if (this.retrofitRequest.isResponseStreaming() == false) goto L15;
        BaseHttpRequestInfo r1 = this.requestInfo;
        r1.requestEnd = System.currentTimeMillis();
        if (this.okHttp3RequestLog.isRequestFinished() == true) goto L12;
        this.mHandler.postDelayed(new AnonymousClass1(this), 500);
        return;
    L12:
        collectAndReport(true);
        return;
    L15:
        return;
    }

    @Override // com.bytedance.retrofit2.ttnet.SsCallTTNetExtend
    public void cancelNormalRequest(Throwable r4, boolean r5) {
        Call r0 = this.rawCall;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isCanceled() == true) goto L15;
        this.rawCall.cancel();
        this.canceled = true;
        BaseHttpRequestInfo r1 = this.requestInfo;
        r1.requestEnd = System.currentTimeMillis();
        BaseHttpRequestInfo r2 = this.requestInfo;
        T r3 = r2.reqContext;
        if (r3 != 0) goto L10;
    L11:
        NetworkParams.reportOneNormalRequest(this.retrofitRequest, r2, r4, Boolean.valueOf(r5));
        return;
    L10:
        if (r3.is_need_monitor_in_cancel == true) goto L11;
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public long contentLength() {
        Response r0 = this.okResponse;
        if (r0 != null) goto L5;
    L7:
        return 0;
    L5:
        if (r0.body() == null) goto L7;
        return this.okResponse.body().contentLength();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public String contentType() {
        Response r0 = this.okResponse;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.body() == null) goto L12;
        MediaType r2 = this.okResponse.body().contentType();
        if (r2 != null) goto L10;
        return null;
    L10:
        return r2.toString();
    L12:
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    public IOException convertException(Exception r18) {
        if ((r18 instanceof TTNetExceptionStorage) == false) goto L6;
        TTNetExceptionStorage r1 = (TTNetExceptionStorage) r18;
        String r7 = this.retrofitRequest.getUrl();
        BaseHttpRequestInfo r9 = this.requestInfo;
        r1.setInfo(true, false, true, r7, r9.traceCode, r9);
        return r1;
    L6:
        TTNetExceptionStorage r2 = new TTNetExceptionStorage(r18.getMessage(), r18.getCause());
        String r14 = this.retrofitRequest.getUrl();
        BaseHttpRequestInfo r0 = this.requestInfo;
        r2.setInfo(true, false, true, r14, r0.traceCode, r0);
        return r2;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public InputStream errorStream() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    public void executeNetworkRequest() {
        Call r0 = this.rawCall;
        if (r0 == null) goto L6;
        this.okResponse = r0.execute();
        this.okHttp3RequestLog.setResponseSource(this.okResponse);
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public boolean fromCache() {
        Response r0 = this.okResponse;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.cacheResponse() != null) goto L9;
        return false;
    L9:
        if (this.okResponse.networkResponse() != null) goto L11;
        return true;
    L11:
        if (this.okResponse.code() == 304) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    public Context getContext() {
        return SsOkHttp3Client.getContext();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    public int getStatusCodeFromException(IOException r1) {
        return TTNetUtils.convertExceptionToErrorCode(r1);
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r1) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public InputStream inputStream() {
        Response r0 = this.okResponse;
        if (r0 != null) goto L5;
    L7:
        return null;
    L5:
        if (r0.body() == null) goto L7;
        return this.okResponse.body().byteStream();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public boolean isGzip() {
        return "gzip".equalsIgnoreCase(this.okResponse.header("Content-Encoding"));
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    public void onExecuteStart() {
        if (SsOkHttp3Client.getNotAllowUseNetwork() == true) goto L6;
        return;
    L6:
        throw new NotAllowUseNetworkException("request is not allowed using network");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    public void onFinalResponseReceived(BaseHttpRequestInfo r1, HttpResponseProvider r2) {
        super.onFinalResponseReceived(r1, r2);
        if (SsOkHttp3Client.getOk3TncBridge() == null) goto L6;
        SsOkHttp3Client.getOk3TncBridge().onOk3Response(this.okRequest, this.okResponse);
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    public void onProcessExceptionStart(Exception r2) {
        if (SsOkHttp3Client.getOk3TncBridge() == null) goto L6;
        SsOkHttp3Client.getOk3TncBridge().onOk3Timeout(this.okRequest, r2);
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    public void onResponseBodyProcessed(TypedInput r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (this.retrofitRequest.isResponseStreaming() == false) goto L6;
        return;
    L6:
        if ((r3 instanceof TypedByteArray) == false) goto L14;
        StoreRegionManager.inst().updateStoreRegionForOkHttp(this.okResponse, this.retrofitRequest.getUrl(), ((TypedByteArray) r3).getBytes());     // Catch: Throwable -> L9
        return;
    L15:
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    public void prepareNetworkRequest(String r8, com.bytedance.retrofit2.client.Request r9, BaseHttpRequestInfo r10, Map<String, String> r11) {
        constructOkHttpClient();     // Catch: Exception -> L4
        configureOkRequest(r9, r10, r11);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        BaseSsCall.updateRequestInfoWithException(r9.getUrl(), r10, this, this, e);
        if ((e instanceof TTNetExceptionStorage) == true) goto L8;
        TTNetExceptionStorage r7 = new TTNetExceptionStorage(e.getMessage(), e.getCause());
        r7.setInfo(true, false, true, r9.getUrl(), r10.traceCode, r10);
        throw r7;
    L8:
        throw ((IOException) e);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public int responseCode() {
        Response r0 = this.okResponse;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.code();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public String responseHeaderValue(String r1) {
        Response r0 = this.okResponse;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.header(r1);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public Map<String, List<String>> responseHeaders() {
        Response r0 = this.okResponse;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.headers().toMultimap();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public String responseMessage() {
        Response r0 = this.okResponse;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.message();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.HttpResponseProvider
    public void safeClose() {
        Response r0 = this.okResponse;
        if (r0 != null) goto L5;
    L7:
        Call r1 = this.rawCall;
        if (r1 == null) goto L11;
        r1.cancel();
        return;
    L11:
        return;
    L5:
        if (r0.body() == null) goto L7;
        StreamParser.safeClose(this.okResponse.body());
        goto L7
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public boolean setThrottleNetSpeed(long r1) {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.RequestLogProvider
    public void updateRequestInfoWithRequestLog(BaseHttpRequestInfo r2) {
        if (this.okHttp3RequestLog == null) goto L6;
        this.okHttp3RequestLog.setRequestInfo(r2, SsOkHttp3Client.getContext());
        return;
    }
}
