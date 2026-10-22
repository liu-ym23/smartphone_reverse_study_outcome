package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.android.settings.utils.HanziToPinyin;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.frameworks.baselib.network.connectionclass.DeviceBandwidthSampler;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.IHttpClient;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.RequestRetryResult;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.frameworks.baselib.network.http.exception.NotAllowUseNetworkException;
import com.bytedance.frameworks.baselib.network.http.ok3.IOkHttpAppInfoProvider;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.HttpDns;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchResult;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatcher;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLRequest;
import com.bytedance.frameworks.baselib.network.http.parser.MimeType;
import com.bytedance.frameworks.baselib.network.http.parser.StreamParser;
import com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionManager;
import com.bytedance.frameworks.baselib.network.http.util.BoeUtils;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.frameworks.baselib.network.queryfilter.QueryFilterEngine;
import com.bytedance.platform.godzilla.common.Constant;
import com.bytedance.retrofit2.IRequestInfo;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.retrofit2.ttnet.SsCallTTNetExtend;
import com.bytedance.retrofit2.ttnet.TTNetExceptionStorage;
import com.loopj.android.http.RequestParams;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import obric.time.HttpHeadTimeFetcher;
import okhttp3.Call;
import okhttp3.Challenge;
import okhttp3.Credentials;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.Route;
import okhttp3.internal.Version;
import okhttp3.internal.http.HttpMethod;
import org.apache.commons.io.IOUtils;
import org.apache.commons.math3.geometry.VectorFormat;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class SsOkHttp3Client implements IHttpClient {
    public static final int FALL_BACK_REASON_BOOT = 3;
    public static final int FALL_BACK_REASON_CONFIG = 4;
    public static final int FALL_BACK_REASON_CRONET_EXCEPTION = 7;
    public static final int FALL_BACK_REASON_FORCE = 0;
    public static final int FALL_BACK_REASON_MODEL = 8;
    public static final int FALL_BACK_REASON_NO_PLUGIN = 6;
    public static final int FALL_BACK_REASON_NULL_APPCONFIG = 9;
    public static final int FALL_BACK_REASON_NULL_CONFIG = 5;
    public static final int FALL_BACK_REASON_VERSION = 1;
    public static final int FALL_BACK_REASON_X86 = 2;
    public static final String OK3_VERSION = "tt-ok/3.12.13.2-rc.2";
    public static final String TAG = "SsOkHttp3Client";
    private static final int VERSION_CODE_UNINITIALIZED = 0;
    private static final int WAIT_REQUEST_FINISHED_TIME_MS = 500;
    private static Context sContext = null;
    private static volatile String sDefaultUA = "";
    private static volatile String sFallbackMessage = "";
    private static volatile int sFallbackReason = -1;
    private static volatile SsOkHttp3Client sInstance = null;
    private static volatile boolean sNotAllowUseNetwork = false;
    private static Ok3TncBridge sOk3TncBridge = null;
    private static OkHttp3Builder sOkHttp3Builder = null;
    private static volatile IOkHttpAppInfoProvider sOkHttpAppInfoProvider = null;
    private static String sOkVersion = "tt-ok/3.10.0.2";
    private static volatile Proxy sProxy;
    private static int sVersionCode;
    private static final Object sVersionCodeLock = null;

    public static class Ok3SsCall implements SsCall, SsCallTTNetExtend, IRequestInfo, WeakHandler.IHandler {
        ResponseBody body;
        boolean bypassNetworkStatusCheck;
        boolean canceled;
        OkHttpClient client;
        private final WeakHandler mHandler;
        private String mNeedRemoveRetryByHeaderKey;
        private boolean mNeedRemoveTuringHeader;
        volatile OkHttp3RequestLog okHttp3RequestLog;
        Request okRequest;
        Response okResponse;
        Call rawCall;
        BaseHttpRequestInfo reqInfo;
        RetrofitMetrics retrofitMetrics;
        com.bytedance.retrofit2.client.Request retrofitRequest;
        long start;
        String traceCode;

        @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
        public void handleMsg(Message r1) {
        }

        @Override // com.bytedance.retrofit2.client.SsCall
        public boolean setThrottleNetSpeed(long r1) {
            return false;
        }

        static /* synthetic */ void access$2000(Ok3SsCall r0, boolean r1) {
            r0.collectAndReport(r1);
        }

        public Ok3SsCall(com.bytedance.retrofit2.client.Request r19) throws IOException {
            this.client = null;
            this.reqInfo = BaseHttpRequestInfo.createHttpRequestInfo();
            this.start = 0;
            this.body = null;
            this.traceCode = null;
            this.bypassNetworkStatusCheck = false;
            this.retrofitMetrics = null;
            this.okHttp3RequestLog = null;
            this.canceled = false;
            this.mNeedRemoveTuringHeader = false;
            this.mHandler = new WeakHandler(HttpDns.getService().getHttpDnsHandlerThread().getLooper(), this);
            this.client = SsOkHttp3Client.access$200().build(false);
            SsOkHttp3Client.access$300(r19.getExtraInfo());
            this.retrofitRequest = r19;
            String r6 = r19.getUrl();
            RetrofitMetrics r7 = r19.getMetrics();
            this.retrofitMetrics = r7;
            this.reqInfo.metrics = r7;
            RetrofitMetrics r8 = this.retrofitMetrics;
            if (r8 == null) goto L5;
            this.reqInfo.appLevelRequestStart = r8.appLevelRequestStart;
            this.reqInfo.beforeAllInterceptors = this.retrofitMetrics.beforeAllInterceptors;
        L5:
            this.okHttp3RequestLog = new OkHttp3RequestLog();
            this.okHttp3RequestLog.setOriginUrl(r6, this.retrofitRequest.getMethod());
            long r9 = System.currentTimeMillis();
            this.start = r9;
            this.reqInfo.requestStart = r9;
            this.reqInfo.httpClientType = 1;
            this.reqInfo.fallbackReason = SsOkHttp3Client.access$400();
            this.reqInfo.fallbackMessage = SsOkHttp3Client.access$500();
            if (this.retrofitRequest.isResponseStreaming() == false) goto L8;
            this.reqInfo.downloadFile = true;
        L74:
            OkHttpClient.Builder r10 = this.client.newBuilder();     // Catch: Exception -> L67
            r10.connectTimeout(NetworkParams.getConnectTimeout(), TimeUnit.MILLISECONDS);     // Catch: Exception -> L67
            r10.readTimeout(NetworkParams.getIoTimeout(), TimeUnit.MILLISECONDS);     // Catch: Exception -> L67
            r10.writeTimeout(NetworkParams.getIoTimeout(), TimeUnit.MILLISECONDS);     // Catch: Exception -> L67
            r10.proxy(SsOkHttp3Client.access$600());     // Catch: Exception -> L67
            r10.enableBoe(BoeUtils.isOkhttpBoeProxyEnabled());     // Catch: Exception -> L67
            if ((r19.getExtraInfo() instanceof BaseRequestContext) == false) goto L44;
            this.reqInfo.reqContext = (T) r19.getExtraInfo();     // Catch: Exception -> L67
            BaseRequestContext r11 = this.reqInfo.reqContext;     // Catch: Exception -> L67
            if (r11.timeout_connect > 0) goto L18;
            if (r11.timeout_read > 0) goto L18;
            if (r11.timeout_write > 0) goto L18;
        L26:
            this.bypassNetworkStatusCheck = r11.bypass_network_status_check;     // Catch: Exception -> L67
            if (r11.followRedirectInternal == true) goto L30;
            r10.followRedirects(false);     // Catch: Exception -> L67
        L30:
            if (r11.byPassProxy == false) goto L32;
            r10.proxy(Proxy.NO_PROXY);     // Catch: Exception -> L67
        L32:
            final BaseRequestContext.AuthCredentials r2 = r11.authCredentials;     // Catch: Exception -> L67
            if (r2 != null) goto L35;
        L39:
            BaseRequestContext.IOkHttpRequestClientBuilderHook r3 = r11.okHttpRequestClientBuilderHook;     // Catch: Exception -> L67
            if (r3 == null) goto L42;
            r3.addBuilderConfig(r10);     // Catch: Exception -> L67
        L42:
            this.okHttp3RequestLog.setRequestTimeout(r11);     // Catch: Exception -> L67
            goto L44
        L35:
            if (r2.username == null) goto L39;
            if (r2.password == null) goto L39;
            r10.proxyAuthenticator(new SsOkHttp3Client$Ok3SsCall$$ExternalSyntheticLambda1(r2));     // Catch: Exception -> L67
        L18:
            if (r11.timeout_connect <= 0) goto L21;
            r10.connectTimeout(r11.timeout_connect, TimeUnit.MILLISECONDS);     // Catch: Exception -> L67
        L21:
            if (r11.timeout_write <= 0) goto L24;
            r10.writeTimeout(r11.timeout_write, TimeUnit.MILLISECONDS);     // Catch: Exception -> L67
        L24:
            if (r11.timeout_read <= 0) goto L26;
            r10.readTimeout(r11.timeout_read, TimeUnit.MILLISECONDS);     // Catch: Exception -> L67
        L44:
            if (this.client.eventListenerFactory() == null) goto L46;
            EventListener r4 = this.client.eventListenerFactory().create(this.client.newCall(new Request.Builder().url(r6).build()));     // Catch: Exception -> L67
        L47:
            r10.eventListener(new OkHttp3EventListener(r4, this.okHttp3RequestLog));     // Catch: Exception -> L67
            this.client = r10.build();     // Catch: Exception -> L67
            ArrayList r5 = new ArrayList();     // Catch: Exception -> L67
            if (r19.isBypassDispatch() == true) goto L50;
            r6 = doOkHttpDispatch(r6, r19.getMethod(), r5);     // Catch: Exception -> L67
        L50:
            r6 = BoeUtils.tryAddOkhttpBoeSuffix(SsOkHttp3Client.access$000(), r6, this.retrofitRequest.getHeaders());     // Catch: Exception -> L67
            Request.Builder r12 = new Request.Builder().originUrl(this.retrofitRequest.getUrl()).url(r6);     // Catch: Exception -> L67
            Iterator<Header> r13 = r5.iterator();     // Catch: Exception -> L67
        L52:
            if (r13.hasNext() == false) goto L55;
            Header r14 = r13.next();     // Catch: Exception -> L67
            r12.addHeader(r14.getName(), r14.getValue());     // Catch: Exception -> L67
            goto L52
        L55:
            if (HttpMethod.permitsRequestBody(this.retrofitRequest.getMethod()) == true) goto L57;
            Request.Builder r0 = r12.method(this.retrofitRequest.getMethod(), null);     // Catch: Exception -> L67
        L58:
            List<Header> r15 = this.retrofitRequest.getHeaders();     // Catch: Exception -> L67
            if (this.retrofitRequest.getBody() != null) goto L61;
        L65:
            Request r1 = SsOkHttp3Client.access$700(r0, r15);     // Catch: Exception -> L67
            this.okRequest = r1;     // Catch: Exception -> L67
            this.rawCall = this.client.newCall(r1);     // Catch: Exception -> L67
            BaseHttpRequestInfo r16 = this.reqInfo;     // Catch: Exception -> L67
            r16.extraInfo = SsOkHttp3Client.access$800(this.okRequest, r16);     // Catch: Exception -> L67
            return;
        L61:
            if (this.retrofitRequest.isPureRequest() == true) goto L65;
            String r17 = this.retrofitRequest.getBody().md5Stub();     // Catch: Exception -> L67
            if (r17 == null) goto L65;
            r0.addHeader("X-SS-STUB", r17);     // Catch: Exception -> L67
            goto L65
        L57:
            r0 = r12.method(this.retrofitRequest.getMethod(), createRequestBody(this.retrofitRequest.getBody(), this.retrofitRequest.getRequestBody()));     // Catch: Exception -> L67
            goto L58
        L46:
            r4 = null;
        L67:
            e = move-exception;
            SsOkHttp3Client.access$900(this.okRequest, r6, this.start, this.reqInfo, this.traceCode, e, this.rawCall, this.okResponse, this.retrofitMetrics, this.okHttp3RequestLog);
            if ((e instanceof TTNetExceptionStorage) == true) goto L71;
            TTNetExceptionStorage r18 = new TTNetExceptionStorage(e.getMessage(), e.getCause());
            r18.setInfo(true, false, true, r6, this.traceCode, this.reqInfo);
            throw r18;
        L71:
            throw ((IOException) e);
        L8:
            this.reqInfo.downloadFile = false;
            goto L74
        }

        static /* synthetic */ Request lambda$new$0(BaseRequestContext.AuthCredentials r4, Route r5, Response r6) throws IOException {
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

        private void retryCurrentRequestOneTime(Map<String, String> r5, Map<String, String> r6) throws IOException {
            Call r0 = this.rawCall;
            if (r0 == null) goto L5;
            r0.cancel();
        L5:
            SsOkHttp3Client.access$1000(this.okResponse.body());
            Request.Builder r1 = this.okRequest.newBuilder();
            if (r5 != null) goto L8;
        L17:
            if (r6 != null) goto L19;
        L28:
            Request r7 = r1.build();
            this.okRequest = r7;
            Call r8 = this.client.newCall(r7);
            this.rawCall = r8;
            BaseHttpRequestInfo r9 = this.reqInfo;
            r9.requestHeaders = SsOkHttp3Client.access$1100(r8.request().headers());
            this.okResponse = SsOkHttp3Client.access$1200(this.client, this.rawCall);
            return;
        L19:
            if (r6.isEmpty() == true) goto L28;
            Iterator<Map.Entry<String, String>> r10 = r6.entrySet().iterator();
        L22:
            if (r10.hasNext() == false) goto L28;
            Map.Entry<String, String> r11 = r10.next();
            String r2 = r11.getKey();
            String r12 = r11.getValue();
            if (TextUtils.isEmpty(r2) == true) goto L22;
            if (TextUtils.isEmpty(r12) == true) goto L22;
            r1.header(r2, r12);
            goto L22
        L8:
            if (r5.isEmpty() == true) goto L17;
            Iterator<Map.Entry<String, String>> r13 = r5.entrySet().iterator();
        L11:
            if (r13.hasNext() == false) goto L17;
            Map.Entry<String, String> r3 = r13.next();
            String r4 = r3.getKey();
            String r14 = r3.getValue();
            if (TextUtils.isEmpty(r4) == true) goto L11;
            if (TextUtils.isEmpty(r14) == true) goto L11;
            r1.addHeader(r4, r14);
            goto L11
        }

        private void retryRequestFromTuringHeader() throws IOException {
            Map<String, List<String>> r0 = this.okResponse.headers().toMultimap();
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.containsKey(NetworkParams.BDTURING_VERIFY_HEADER) == false) goto L28;
            Request r2 = this.okRequest;
            if (r2 == null) goto L10;
            String r3 = r2.header(NetworkParams.BYPASS_BDTURING_HEADER_KEY);
        L12:
            if (TextUtils.isEmpty(r3) == false) goto L14;
        L16:
            long r4 = SystemClock.uptimeMillis();
            RequestRetryResult r5 = NetworkParams.shouldRetryRequestFromTuringHeaders(this.okResponse.code(), r0);
            BaseHttpRequestInfo r6 = this.reqInfo;
            r6.turingCallbackDuration = SystemClock.uptimeMillis() - r4;
            if (r5.isRequestRetryEnabled() == false) goto L23;
            this.reqInfo.executeTuringCallback = true;
            this.reqInfo.bdTuringRetry = true;
            Map<String, String> r1 = r5.getAddRequestHeaders();
            if (r1 != null) goto L21;
            r1 = new HashMap();
        L21:
            r1.put(NetworkParams.RETRY_REQUEST_BY_BDTURING_HEADER, "1");
            retryCurrentRequestOneTime(r1, updateAccountRetryRequestHeader(r5));
        L25:
            BaseHttpRequestInfo r7 = this.reqInfo;
            r7.extraInfo = SsOkHttp3Client.access$800(this.okRequest, r7);
            return;
        L23:
            if (r0.containsKey(NetworkParams.BDTURING_VERIFY_HEADER) == true) goto L25;
            this.reqInfo.executeTuringCallback = true;
            this.mNeedRemoveTuringHeader = true;
            goto L25
        L14:
            if (r3.equalsIgnoreCase("1") == false) goto L16;
            return;
        L10:
            r3 = null;
            goto L12
        }

        private void retryRequestByHeader() throws IOException {
            RequestRetryResult r0 = NetworkParams.shouldRetryRequestByHeader(this.reqInfo, this.okResponse.code(), new SsOkHttp3Client$Ok3SsCall$$ExternalSyntheticLambda0(this), this.okResponse.headers().toMultimap());
            if (r0.isRequestRetryEnabled() == false) goto L6;
            Map<String, String> r1 = updateAccountRetryRequestHeader(r0);
            retryCurrentRequestOneTime(r0.getAddRequestHeaders(), r1);
        L10:
            BaseHttpRequestInfo r2 = this.reqInfo;
            r2.extraInfo = SsOkHttp3Client.access$800(this.okRequest, r2);
            return;
        L6:
            if (StringUtils.isEmpty(this.reqInfo.retryByHeaderFilterKey) == true) goto L10;
            if (r0.isRemoveHitResponseHeaderIfNotRetry() == false) goto L10;
            this.mNeedRemoveRetryByHeaderKey = this.reqInfo.retryByHeaderFilterKey;
            goto L10
        }

        /* JADX INFO: renamed from: lambda$retryRequestByHeader$1$com-bytedance-frameworks-baselib-network-http-ok3-impl-SsOkHttp3Client$Ok3SsCall, reason: not valid java name */
        /* synthetic */ String m890x8d7cb046(String r1) {
            Request r0 = this.okRequest;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.header(r1);
        }

        private Map<String, String> updateAccountRetryRequestHeader(RequestRetryResult r8) {
            if (r8 != null) goto L5;
        L13:
            return null;
        L5:
            if (r8.isRequestRetryEnabled() == false) goto L13;
            Request r9 = this.okRequest;
            if (r9 == null) goto L13;
            RequestRetryResult r7 = NetworkParams.shouldRetryForAccountRequest(r9.url().toString(), this.okResponse.code(), true, this.reqInfo, this.retrofitRequest.getHeaders(), this.okResponse.headers().toMultimap());
            if (r7 == null) goto L13;
            return r7.getAddRequestHeaders();
        }

        private void retryForAccountRequest() throws IOException {
            Request r0 = this.okRequest;
            if (r0 != null) goto L5;
            return;
        L5:
            RequestRetryResult r1 = NetworkParams.shouldRetryForAccountRequest(r0.url().toString(), this.okResponse.code(), false, this.reqInfo, this.retrofitRequest.getHeaders(), this.okResponse.headers().toMultimap());
            if (r1 != null) goto L8;
        L10:
            BaseHttpRequestInfo r2 = this.reqInfo;
            r2.extraInfo = SsOkHttp3Client.access$800(this.okRequest, r2);
            return;
        L8:
            if (r1.isRequestRetryEnabled() == false) goto L10;
            this.reqInfo.bdTuringRetry = true;
            retryCurrentRequestOneTime(null, r1.getAddRequestHeaders());
            goto L10
        }

        @Override // com.bytedance.retrofit2.client.SsCall
        public com.bytedance.retrofit2.client.Response execute() throws IOException {
            String r13 = this.retrofitRequest.getUrl();
            if (SsOkHttp3Client.access$1300() == true) goto L120;
            Call r0 = this.rawCall;
            if (r0 == null) goto L12;
            if (r0.isCanceled() == false) goto L12;
            throw new IOException("request canceled");
        L12:
            if (this.bypassNetworkStatusCheck == false) goto L14;
        L20:
            boolean r14 = true;
            boolean r11 = false;
        L82:
            e = e;
            boolean r15 = false;
        L121:
        L108:
            th = th;
            r11 = r15;
        L111:
            if (this.retrofitRequest.isResponseStreaming() == false) goto L113;
            if (r14 == true) goto L113;
        L115:
            if (this.retrofitRequest.isResponseStreaming() == true) goto L118;
            if (r11 == false) goto L118;
            DeviceBandwidthSampler.getInstance().stopSampling();
        L118:
            throw th;
        L113:
            SsOkHttp3Client.access$1000(this.body);
            goto L115
        L85:
            if (SsOkHttp3Client.access$1500() == null) goto L88;
            SsOkHttp3Client.access$1500().onOk3Timeout(this.okRequest, e);     // Catch: Throwable -> L108
        L88:
            if ((e instanceof HttpResponseException) == false) goto L94;
            HttpResponseException r2 = (HttpResponseException) e;     // Catch: Throwable -> L108
            if (r2.getStatusCode() != 304) goto L94;
            throw r2;     // Catch: Throwable -> L108
        L94:
            if ((e instanceof IOException) == true) goto L96;
        L99:
            SsOkHttp3Client.access$900(this.okRequest, r13, this.start, this.reqInfo, this.traceCode, e, this.rawCall, this.okResponse, this.retrofitMetrics, this.okHttp3RequestLog);     // Catch: Throwable -> L108
            if (this.retrofitRequest.isResponseStreaming() == false) goto L103;
            this.reqInfo.hasReportStreamingApiAll.set(true);     // Catch: Throwable -> L108
        L103:
            if ((e instanceof TTNetExceptionStorage) == false) goto L106;
            ((TTNetExceptionStorage) e).setInfo(true, false, true, r13, this.traceCode, this.reqInfo);     // Catch: Throwable -> L108
            throw e;     // Catch: Throwable -> L108
        L106:
            TTNetExceptionStorage r9 = new TTNetExceptionStorage(e.getMessage(), e.getCause());     // Catch: Throwable -> L108
            r9.setInfo(true, false, true, r13, this.traceCode, this.reqInfo);     // Catch: Throwable -> L108
            throw r9;     // Catch: Throwable -> L108
        L96:
            if ("Canceled".equals(e.getMessage()) == false) goto L99;
            throw e;     // Catch: Throwable -> L108
        L80:
            th = th;
            r14 = false;
            goto L111
        L22:
            if (this.retrofitRequest.isResponseStreaming() == true) goto L29;
            NetworkParams.ConnectionQualitySamplerHook r1 = NetworkParams.getConnectionQualitySamplerHook();     // Catch: Throwable -> L80 Exception -> L82
            if (r1 == null) goto L29;
            if (r1.shouldSampling(r13) == false) goto L29;
            DeviceBandwidthSampler.getInstance().startSampling();     // Catch: Throwable -> L80 Exception -> L82
            boolean r12 = true;
        L122:
            this.reqInfo.requestHeaders = SsOkHttp3Client.access$1100(this.rawCall.request().headers());     // Catch: Throwable -> L76 Exception -> L78
            this.okResponse = SsOkHttp3Client.access$1200(this.client, this.rawCall);     // Catch: Throwable -> L76 Exception -> L78
            retryRequestFromTuringHeader();     // Catch: Throwable -> L76 Exception -> L78
            if (this.reqInfo.executeTuringCallback == true) goto L34;
            retryRequestByHeader();     // Catch: Throwable -> L76 Exception -> L78
        L34:
            if (this.reqInfo.bdTuringRetry == true) goto L36;
            retryForAccountRequest();     // Catch: Throwable -> L76 Exception -> L78
        L36:
            this.okHttp3RequestLog.setResponseSource(this.okResponse);     // Catch: Throwable -> L76 Exception -> L78
            this.reqInfo.responseBack = System.currentTimeMillis();     // Catch: Throwable -> L76 Exception -> L78
            this.reqInfo.responseHeaders = SsOkHttp3Client.access$1100(this.okResponse.headers());     // Catch: Throwable -> L76 Exception -> L78
            String r3 = SsOkHttp3Client.access$1400(this.okResponse, this.reqInfo);     // Catch: Throwable -> L76 Exception -> L78
            this.traceCode = r3;     // Catch: Throwable -> L76 Exception -> L78
            RetrofitMetrics r4 = this.retrofitMetrics;     // Catch: Throwable -> L76 Exception -> L78
            if (r4 == null) goto L40;
            r4.traceCode = r3;     // Catch: Throwable -> L76 Exception -> L78
        L40:
            if (SsOkHttp3Client.access$1500() == null) goto L42;
            SsOkHttp3Client.access$1500().onOk3Response(this.okRequest, this.okResponse);     // Catch: Throwable -> L76 Exception -> L78
        L42:
            int r5 = this.okResponse.code();     // Catch: Throwable -> L76 Exception -> L78
            String r16 = this.okResponse.header("Content-Type");     // Catch: Throwable -> L76 Exception -> L78
            if (this.okResponse.body() != null) goto L46;
            this.reqInfo.responseBodyByteCount = -1;     // Catch: Throwable -> L76 Exception -> L78
        L46:
            if (this.retrofitRequest.isResponseStreaming() == false) goto L65;
            boolean r6 = "gzip".equalsIgnoreCase(this.okResponse.header("Content-Encoding"));     // Catch: Throwable -> L76 Exception -> L78
            Map<String, List<String>> r7 = this.okResponse.headers().toMultimap();     // Catch: Throwable -> L76 Exception -> L78
            if (r5 < 200) goto L52;
            if (r5 >= 300) goto L52;
        L53:
            TypedInput r8 = createResponseBody(this.okResponse.body(), r7, r6);     // Catch: Throwable -> L76 Exception -> L78
            if (r8 == null) goto L56;
        L58:
            TypedInput r10 = r8;
        L66:
            com.bytedance.retrofit2.client.Response r17 = new com.bytedance.retrofit2.client.Response(r13, r5, this.okResponse.message(), createHeaders(this.okResponse.headers()), r10);     // Catch: Throwable -> L76 Exception -> L78
            r17.setExtraInfo(this.reqInfo);     // Catch: Throwable -> L76 Exception -> L78
            r17.setTraceCode(this.traceCode);     // Catch: Throwable -> L76 Exception -> L78
            if (this.retrofitRequest.isResponseStreaming() == true) goto L72;
            SsOkHttp3Client.access$1000(this.body);
        L72:
            if (this.retrofitRequest.isResponseStreaming() == true) goto L75;
            if (r12 == false) goto L75;
            DeviceBandwidthSampler.getInstance().stopSampling();
        L75:
            return r17;
        L56:
            if (SsOkHttp3Client.access$1700(this.reqInfo) == false) goto L58;
            r8 = new TypedByteArray(r16, new byte[0], new String[0]);     // Catch: Throwable -> L76 Exception -> L78
        L52:
            if (SsOkHttp3Client.access$1600(this.reqInfo) == true) goto L53;
            String r18 = this.okResponse.message();     // Catch: Throwable -> L76 Exception -> L78
            int r19 = this.retrofitRequest.getMaxLength();     // Catch: Throwable -> L76 Exception -> L78
            ResponseBody r110 = this.okResponse.body();     // Catch: Throwable -> L76 Exception -> L78
            if (r110 == null) goto L62;
            String r20 = SsOkHttp3Client.access$1800(r6, r7, r19, r110.byteStream(), r16, r13, this.retrofitMetrics, this.reqInfo);     // Catch: Throwable -> L76 Exception -> L78
            StreamParser.safeClose(r110);     // Catch: Throwable -> L76 Exception -> L78
        L63:
            HttpResponseException r21 = new HttpResponseException(r5, r18, HttpResponseException.getPathFromUrlString(r13), r20);     // Catch: Throwable -> L76 Exception -> L78
            this.reqInfo.hasReportStreamingApiAll.set(true);     // Catch: Throwable -> L76 Exception -> L78
            r21.setInfo(true, true, false, r13, this.traceCode, this.reqInfo);     // Catch: Throwable -> L76 Exception -> L78
            throw r21;     // Catch: Throwable -> L76 Exception -> L78
        L62:
            r20 = null;
            goto L63
        L65:
            r10 = new TypedByteArray(r16, SsOkHttp3Client.access$1900(r13, this.retrofitRequest.getMaxLength(), this.okResponse, this.start, this.reqInfo, this.traceCode, this.retrofitMetrics, this.okHttp3RequestLog), new String[0]);     // Catch: Throwable -> L76 Exception -> L78
        L78:
            e = e;
            r15 = r12;
        L76:
            th = th;
            r14 = false;
            r11 = r12;
            goto L111
        L29:
            r12 = false;
            goto L122
        L14:
            if (SsOkHttp3Client.access$000() == null) goto L20;
            if (NetworkUtils.isNetworkAvailable(SsOkHttp3Client.access$000()) == true) goto L20;
            throw new NetworkNotAvailabeException("network not available for " + this.retrofitRequest.getPath());
        L120:
            throw new NotAllowUseNetworkException("request is not allowed using network");
        }

        @Override // com.bytedance.retrofit2.client.SsCall
        public void cancel() {
            Call r0 = this.rawCall;
            if (r0 == null) goto L14;
            r0.cancel();
            if (this.retrofitRequest.isResponseStreaming() == true) goto L7;
        L12:
            this.canceled = true;
            return;
        L7:
            if (this.canceled == true) goto L12;
            BaseHttpRequestInfo r1 = this.reqInfo;
            r1.requestEnd = System.currentTimeMillis();
            if (this.okHttp3RequestLog.isRequestFinished() == true) goto L11;
            this.mHandler.postDelayed(new AnonymousClass1(this), 500);
            goto L12
        L11:
            collectAndReport(true);
            goto L12
        }

        private void collectAndReport(boolean r10) {
            if (r10 == false) goto L4;
            SsOkHttp3Client.access$2100(this.reqInfo, this.retrofitMetrics, this.okHttp3RequestLog);
        L6:
            if (this.reqInfo.reqContext != 0) goto L8;
        L9:
            long r0 = this.reqInfo.requestEnd;
            long r4 = this.start;
            NetworkParams.monitorApiSample(r0 - r4, r4, this.retrofitRequest.getUrl(), this.traceCode, this.reqInfo);
            return;
        L8:
            if (this.reqInfo.reqContext.is_need_monitor_in_cancel == true) goto L9;
            return;
        L4:
            SsOkHttp3Client.access$2100(this.reqInfo, this.retrofitMetrics, null);
            goto L6
        }

        @Override // com.bytedance.retrofit2.ttnet.SsCallTTNetExtend
        public void cancelNormalRequest(Throwable r9, boolean r10) {
            Call r0 = this.rawCall;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.cancel();
            if (this.canceled == false) goto L8;
            return;
        L8:
            BaseHttpRequestInfo r1 = this.reqInfo;
            r1.requestEnd = System.currentTimeMillis();
            if (this.reqInfo.reqContext != 0) goto L11;
        L12:
            NetworkParams.reportOneNormalRequest(r9, this.traceCode, this.start, this.retrofitRequest, this.reqInfo, Boolean.valueOf(r10));
        L13:
            this.canceled = true;
            return;
        L11:
            if (this.reqInfo.reqContext.is_need_monitor_in_cancel == false) goto L13;
            goto L12
        }

        @Override // com.bytedance.retrofit2.client.SsCall
        public com.bytedance.retrofit2.client.Request getRequest() {
            return this.retrofitRequest;
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

        private TypedInput createResponseBody(final ResponseBody r5, final Map<String, List<String>> r6, final boolean r7) throws IOException {
            if (r5.contentLength() != 0) goto L7;
            return null;
        L7:
            return new AnonymousClass3(this, r5, r6, r7);
        }

        private List<Header> createHeaders(Headers r9) {
            int r0 = r9.size();
            ArrayList r1 = new ArrayList(r0);
            int r3 = 0;
        L3:
            if (r3 >= r0) goto L23;
            String r4 = r9.name(r3);
            if (r4 == null) goto L21;
            boolean r6 = true;
            if (this.mNeedRemoveTuringHeader == true) goto L9;
        L11:
            boolean r5 = false;
        L12:
            String r7 = this.mNeedRemoveRetryByHeaderKey;
            if (r7 != null) goto L15;
        L17:
            r6 = false;
        L19:
            if ((r5 | r6) == false) goto L21;
        L22:
            r3 = r3 + 1;
            goto L3
        L15:
            if (r4.equalsIgnoreCase(r7) == false) goto L17;
        L9:
            if (r4.equalsIgnoreCase(NetworkParams.BDTURING_VERIFY_HEADER) == false) goto L11;
            r5 = true;
        L21:
            r1.add(new Header(r9.name(r3), r9.value(r3)));
            goto L22
        L23:
            return r1;
        }

        @Override // com.bytedance.retrofit2.IRequestInfo
        public Object getRequestInfo() {
            return this.reqInfo;
        }

        private String doOkHttpDispatch(String r12, String r13, List<Header> r14) throws Exception {
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
        L17:
            throw new Exception(r16.append(r17).append(", ").append(r15.mDropCode).toString());
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
            Logger.d(SsOkHttp3Client.TAG, "fallback to host replace map");
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
    }

    static /* synthetic */ Context access$000() {
        return sContext;
    }

    static /* synthetic */ IOkHttpAppInfoProvider access$100() {
        return sOkHttpAppInfoProvider;
    }

    static /* synthetic */ void access$1000(ResponseBody r0) {
        processFinally(r0);
    }

    static /* synthetic */ String access$1100(Headers r0) {
        return formatJsonHeaders(r0);
    }

    static /* synthetic */ Response access$1200(OkHttpClient r0, Call r1) throws IOException {
        return processExecute(r0, r1);
    }

    static /* synthetic */ boolean access$1300() {
        return sNotAllowUseNetwork;
    }

    static /* synthetic */ String access$1400(Response r0, BaseHttpRequestInfo r1) {
        return processAfterExecute(r0, r1);
    }

    static /* synthetic */ Ok3TncBridge access$1500() {
        return sOk3TncBridge;
    }

    static /* synthetic */ boolean access$1600(BaseHttpRequestInfo r0) {
        return IsForceHandleResponse(r0);
    }

    static /* synthetic */ boolean access$1700(BaseHttpRequestInfo r0) {
        return isForceConstructResponse(r0);
    }

    static /* synthetic */ String access$1800(boolean r0, Map r1, int r2, InputStream r3, String r4, String r5, RetrofitMetrics r6, BaseHttpRequestInfo r7) throws IOException {
        return processHttpErrorResponse(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    static /* synthetic */ byte[] access$1900(String r0, int r1, Response r2, long r3, BaseHttpRequestInfo r5, String r6, RetrofitMetrics r7, OkHttp3RequestLog r8) throws IOException {
        return processResponse(r0, r1, r2, r3, r5, r6, r7, r8);
    }

    static /* synthetic */ OkHttp3Builder access$200() {
        return sOkHttp3Builder;
    }

    static /* synthetic */ void access$2100(BaseHttpRequestInfo r0, RetrofitMetrics r1, OkHttp3RequestLog r2) {
        getRequestMetrics(r0, r1, r2);
    }

    static /* synthetic */ void access$300(Object r0) {
        tryNecessaryInit(r0);
    }

    static /* synthetic */ int access$400() {
        return sFallbackReason;
    }

    static /* synthetic */ String access$500() {
        return sFallbackMessage;
    }

    static /* synthetic */ Proxy access$600() {
        return sProxy;
    }

    static /* synthetic */ Request access$700(Request.Builder r0, List r1) throws IOException {
        return processBeforeExecute(r0, r1);
    }

    static /* synthetic */ JSONObject access$800(Request r0, BaseHttpRequestInfo r1) {
        return createExtraInfo(r0, r1);
    }

    static /* synthetic */ void access$900(Request r0, String r1, long r2, BaseHttpRequestInfo r4, String r5, Exception r6, Call r7, Response r8, RetrofitMetrics r9, OkHttp3RequestLog r10) {
        processException(r0, r1, r2, r4, r5, r6, r7, r8, r9, r10);
    }

    static {
        sVersionCodeLock = new Object();
    }

    public static SsOkHttp3Client inst(Context r2) {
        if (sInstance != null) goto L15;
        monitor-enter(SsOkHttp3Client.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SsOkHttp3Client(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(SsOkHttp3Client.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private SsOkHttp3Client(Context r5) {
        String r0 = Version.userAgent();     // Catch: Throwable -> L5
    L11:
        if (TextUtils.isEmpty(r0) == false) goto L13;
    L17:
        sContext = r5.getApplicationContext();
        sOkHttp3Builder = new OkHttp3Builder();
        URLDispatcher.inst().loadLocalConfig(sContext);
        HttpDns.getService().setHttpDnsDepend(new AnonymousClass1(this));
        return;
    L13:
        if (r0.startsWith("okhttp/") == false) goto L15;
        String r1 = r0.replaceFirst("okhttp/", "tt-ok/");
    L16:
        sOkVersion = r1;
        goto L17
    L15:
        r1 = "tt-ok/" + r0;
    L5:
        r0 = null;
        Field r2 = Class.forName("okhttp3.internal.Util").getDeclaredField("userAgent");     // Catch: Throwable -> L8
        r2.setAccessible(true);     // Catch: Throwable -> L8
        r0 = (String) r2.get(null);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L11
    }

    public OkHttpClient getOkHttpClient() throws IllegalArgumentException {
        return getOkHttpClient(true);
    }

    public OkHttpClient getOkHttpClient(boolean r1) throws IllegalArgumentException {
        OkHttp3Builder r0 = sOkHttp3Builder;
        if (r0 == null) goto L7;
        return r0.build(r1);
    L7:
        throw new IllegalArgumentException("SsOkHttp3Client is not init !!!");
    }

    private static void getRequestInfo(String r3, BaseHttpRequestInfo r4) {
        if (StringUtils.isEmpty(r3) == true) goto L16;
        if (r4 == null) goto L18;
        if (Logger.debug() == false) goto L9;
        Logger.d(TAG, "getRequestInfo remoteIp = " + r3);     // Catch: Throwable -> L13
    L9:
        r4.remoteIp = r3;     // Catch: Throwable -> L13
        if (r4.reqContext == 0) goto L17;
        r4.reqContext.remoteIp = r3;     // Catch: Throwable -> L13
        return;
    L17:
        return;
    L19:
        return;
    L18:
        return;
    }

    private static String getHostAddress(Exception r5) {
        if (r5 != null) goto L5;
    L18:
        return "";
    L5:
        if (TextUtils.isEmpty(r5.getMessage()) == true) goto L18;
        String[] r6 = r5.getMessage().split("\\|");     // Catch: Throwable -> L16
        if (r6 == null) goto L18;
        if (r6.length < 2) goto L18;
        if (Logger.debug() == false) goto L14;
        Logger.d(TAG, "getHostAddress remoteIp = " + r6[0]);     // Catch: Throwable -> L16
    L14:
        return r6[0];
    L16:
        th = move-exception;
        th.printStackTrace();
        goto L18
    }

    private static Request processBeforeExecute(Request.Builder r5, List<Header> r6) throws IOException {
        if (r5 != null) goto L5;
        return null;
    L5:
        r5.addHeader("Accept-Encoding", "gzip");
        boolean r0 = true;
        boolean r2 = false;
        if (r6 == null) goto L19;
        Iterator<Header> r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L19;
        Header r3 = r7.next();
        if (StringUtils.isEmpty(r3.getName()) == true) goto L9;
        if (StringUtils.isEmpty(r3.getValue()) == true) goto L9;
        if ("User-Agent".equals(r3.getName()) == false) goto L18;
        r2 = true;
    L18:
        r5.header(r3.getName(), r3.getValue());
    L19:
        if (r2 == true) goto L23;
        String r8 = NetworkParams.getUserAgent();
        if (StringUtils.isEmpty(r8) == true) goto L23;
        r5.header("User-Agent", r8 + HanziToPinyin.Token.SEPARATOR + sOkVersion);
    L24:
        if (r0 == true) goto L29;
        String r9 = getDefaultOkhttpUA(sContext);
        if (TextUtils.isEmpty(r9) == true) goto L29;
        r5.header("User-Agent", r9);
    L29:
        return r5.build();
    L23:
        r0 = r2;
        goto L24
    }

    private static String getDefaultOkhttpUA(Context r3) {
        if (TextUtils.isEmpty(sDefaultUA) == false) goto L12;
        StringBuilder r4 = new StringBuilder();
        r4.append(sContext.getPackageName());
        r4.append(IOUtils.DIR_SEPARATOR_UNIX);
        r4.append(versionFromContext(sContext));
        r4.append(" (Linux; U; Android ");
        r4.append(Build.VERSION.RELEASE);
        r4.append(VectorFormat.DEFAULT_SEPARATOR);
        r4.append(Locale.getDefault().toString());
        String r1 = Build.MODEL;
        if (r1.length() <= 0) goto L7;
        r4.append(VectorFormat.DEFAULT_SEPARATOR);
        r4.append(r1);
    L7:
        String r0 = Build.ID;
        if (r0.length() <= 0) goto L10;
        r4.append("; Build/");
        r4.append(r0);
    L10:
        r4.append(";");
        r4.append(sOkVersion);
        r4.append(')');
        sDefaultUA = r4.toString();
    L12:
        return sDefaultUA;
    }

    private static int versionFromContext(Context r3) {
        Object r0 = sVersionCodeLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (sVersionCode == 0) goto L16;
    L9:
        int r4 = sVersionCode;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r4;
    L16:
        sVersionCode = r3.getPackageManager().getPackageInfo(r3.getPackageName(), 0).versionCode;     // Catch: PackageManager.NameNotFoundException -> L15 Throwable -> L12
        goto L9
    }

    private static Response processExecute(OkHttpClient r0, Call r1) throws IOException {
        if (r0 == null) goto L7;
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1.execute();
    L7:
        return null;
    }

    private static String processAfterExecute(Response r1, BaseHttpRequestInfo r2) {
        if (r1 != null) goto L5;
        return null;
    L5:
        getRequestInfo(r1.header("x-net-info.remoteaddr"), r2);
        if (r2 == null) goto L11;
        if (r2.reqContext == 0) goto L11;
        T r3 = r2.reqContext;
        r3.status = r1.code();
    L11:
        return r1.header("X-TT-LOGID");
    }

    private static boolean IsForceHandleResponse(BaseHttpRequestInfo r1) {
        if (r1 != null) goto L4;
        return false;
    L4:
        if (r1.reqContext != 0) goto L6;
        return false;
    L6:
        if (r1.reqContext.force_handle_response == false) goto L13;
        return true;
    L13:
        return false;
    }

    private static boolean shouldReadErrorResponse(BaseHttpRequestInfo r1) {
        if (r1 != null) goto L4;
        return false;
    L4:
        if (r1.reqContext != 0) goto L6;
        return false;
    L6:
        if (r1.reqContext.read_error_response == false) goto L13;
        return true;
    L13:
        return false;
    }

    private static boolean isForceConstructResponse(BaseHttpRequestInfo r1) {
        if (r1 != null) goto L4;
        return false;
    L4:
        if (r1.reqContext != 0) goto L6;
        return false;
    L6:
        if (r1.reqContext.streaming_force_return_response == false) goto L13;
        return true;
    L13:
        return false;
    }

    private static byte[] processResponse(String r15, int r16, Response r17, long r18, BaseHttpRequestInfo r20, String r21, RetrofitMetrics r22, OkHttp3RequestLog r23) throws IOException {
        if (r17 == null) goto L5;
        int r12 = r17.code();
        ResponseBody r13 = r17.body();
        Map<String, List<String>> r3 = r17.headers().toMultimap();
        boolean r2 = "gzip".equals(r17.header("Content-Encoding"));
        String r14 = r17.header("Content-Type");
        r20.fallbackReason = sFallbackReason;
        r20.fallbackMessage = sFallbackMessage;
        if (r12 != 200) goto L9;
    L22:
        if (r13 == null) goto L40;
        r20.completeReadResponse = System.currentTimeMillis();
        InputStream r19 = r13.byteStream();
        int[] r110 = new int[1];
        r110[0] = 0;     // Catch: Throwable -> L36
        byte[] r4 = StreamParser.readResponse(r2, r3, r16, r19, r110, r22);     // Catch: Throwable -> L36
        StreamParser.safeClose(r19);
        int r5 = r110[0];
        byte[] r6 = new byte[r5];
        if (r4 == null) goto L30;
        if (r5 <= 0) goto L30;
        System.arraycopy(r4, 0, r6, 0, r5);
    L30:
        if (StreamParser.testIsSSBinary(r14) == false) goto L32;
        StreamParser.decodeSSBinary(r6, r5);
    L32:
        long r7 = System.currentTimeMillis() - r18;
        r20.requestEnd = System.currentTimeMillis();
        getRequestMetrics(r20, r22, r23);
        StoreRegionManager.inst().updateStoreRegionForOkHttp(r17, r15, r6);     // Catch: Throwable -> L41
    L34:
        NetworkParams.handleApiOk(r15, r7, r20);
        return r6;
    L36:
        th = move-exception;
        StreamParser.safeClose(r19);
        throw th;
    L40:
        return new byte[0];
    L9:
        if (IsForceHandleResponse(r20) == true) goto L22;
        if (r12 != 304) goto L14;
        r20.completeReadResponse = System.currentTimeMillis();
        long r8 = System.currentTimeMillis() - r18;
        r20.requestEnd = System.currentTimeMillis();
        getRequestMetrics(r20, r22, r23);
        NetworkParams.handleApiOk(r15, r8, r20);
    L14:
        String r10 = r17.message();
        if (r13 == null) goto L17;
        String r1 = processHttpErrorResponse(r2, r3, r16, r13.byteStream(), r14, r15, r22, r20);
        StreamParser.safeClose(r13);
    L18:
        HttpResponseException r9 = new HttpResponseException(r12, r10, HttpResponseException.getPathFromUrlString(r15), r1);
        if (r12 != 304) goto L46;
        r9.setInfo(true, true, false, r15, r21, r20);
        throw r9;
    L46:
        throw r9;
    L17:
        r1 = null;
        goto L18
    L5:
        return new byte[0];
    }

    private static void getRequestMetrics(BaseHttpRequestInfo r2, RetrofitMetrics r3, OkHttp3RequestLog r4) {
        if (r2 == null) goto L16;
        if (r3 == null) goto L17;
        r2.metrics = r3;
        r3.fallbackReason = r2.fallbackReason;
        r3.fallbackMessage = r2.fallbackMessage;
        r3.executeCallEndTime = SystemClock.uptimeMillis();
        r3.retrofitLogReportTime = System.currentTimeMillis();
        r3.ttnetVersion = "4.2.211.1-rc.0";
        r2.extraInfo.put("retrofit", r3.getRetrofitLog());     // Catch: JSONException -> L8
    L10:
        if (r4 != null) goto L12;
        return;
    L12:
        r4.setRequestInfo(r2, sContext);
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    L17:
        return;
    }

    private static String processHttpErrorResponse(boolean r10, Map<String, List<String>> r11, int r12, InputStream r13, String r14, String r15, RetrofitMetrics r16, BaseHttpRequestInfo r17) throws IOException {
        String r1 = null;
        if (r13 != null) goto L5;
        return null;
    L5:
        int[] r8 = new int[1];
        r8[0] = 0;     // Catch: Throwable -> L35
        byte[] r2 = StreamParser.readResponse(r10, r11, r12, r13, r8, r16);     // Catch: Throwable -> L35
        StreamParser.safeClose(r13);
        int r3 = r8[0];
        byte[] r4 = new byte[r3];
        if (r2 == null) goto L11;
        if (r3 <= 0) goto L11;
        System.arraycopy(r2, 0, r4, 0, r3);
    L11:
        if (r3 > 0) goto L13;
    L34:
        return r1;
    L13:
        if (StringUtils.isEmpty(r14) == true) goto L34;
        if (Logger.debug() == false) goto L17;
    L38:
        MimeType r5 = new MimeType(r14);     // Catch: Throwable -> L32
        if ("text".equalsIgnoreCase(r5.getPrimaryType()) == false) goto L21;
    L22:
        String r6 = r5.getParameter("charset");     // Catch: Throwable -> L32
        if (StringUtils.isEmpty(r6) == false) goto L26;
        r6 = Constant.CHARSET_UTF_8;
    L26:
        if (shouldReadErrorResponse(r17) == false) goto L29;
        r1 = new String(r4, r6);     // Catch: Throwable -> L32
    L29:
        if (Logger.debug() == false) goto L34;
        Logger.d(TAG, " response body = " + new String(r4, r6) + " for url = " + r15);     // Catch: Throwable -> L32
        goto L34
    L21:
        if (RequestParams.APPLICATION_JSON.equalsIgnoreCase(r5.getBaseType()) == false) goto L34;
    L32:
        th = move-exception;
        th.printStackTrace();
        goto L34
    L17:
        if (shouldReadErrorResponse(r17) == false) goto L34;
    L35:
        th = move-exception;
        StreamParser.safeClose(r13);
        throw th;
    }

    private static void processException(Request r2, String r3, long r4, BaseHttpRequestInfo r6, String r7, Exception r8, Call r9, Response r10, RetrofitMetrics r11, OkHttp3RequestLog r12) {
        if (r3 == null) goto L31;
        if (r8 == null) goto L33;
        if (r6 != null) goto L29;
    L9:
        String r5 = r8.getMessage();     // Catch: Throwable -> L19
        Throwable r13 = r8.getCause();     // Catch: Throwable -> L19
        if (TextUtils.isEmpty(r5) == true) goto L15;
        if (r13 == null) goto L15;
        if (TextUtils.isEmpty(r13.getMessage()) == true) goto L15;
        r5 = r5 + ", cause = " + r13.getMessage();     // Catch: Throwable -> L19
    L15:
        r6.extraInfo.put(BaseHttpRequestInfo.KEY_EXCEPTION, r5);     // Catch: Throwable -> L19
        String r14 = getAllHeaderFieldsString(r10);     // Catch: Throwable -> L19
        if (StringUtils.isEmpty(r14) == true) goto L21;
        r6.extraInfo.put("response-headers", r14);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.printStackTrace();
    L21:
        if (r6 != null) goto L23;
    L25:
        long r0 = System.currentTimeMillis() - r4;
        r6.requestEnd = System.currentTimeMillis();
        r6.fallbackReason = sFallbackReason;
        r6.fallbackMessage = sFallbackMessage;
        getRequestMetrics(r6, r11, r12);
        NetworkParams.handleApiError(r3, r8, r0, r6);
        if (r9 == null) goto L32;
        r9.cancel();
        return;
    L32:
        return;
    L23:
        if (StringUtils.isEmpty(r6.remoteIp) == false) goto L25;
        getRequestInfo(getHostAddress(r8), r6);
        goto L25
    L29:
        if (r6.extraInfo != null) goto L9;
        r6.extraInfo = createExtraInfo(r2, r6);     // Catch: Throwable -> L19
        goto L9
    L33:
        return;
    }

    private static String getAllHeaderFieldsString(Response r9) {
        if (r9 != null) goto L35;
        return "";
    L35:
        Headers r10 = r9.headers();     // Catch: Throwable -> L32
        if (r10 != null) goto L8;
        return "";
    L8:
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L32
        Iterator<String> r2 = r10.names().iterator();     // Catch: Throwable -> L32
    L10:
        if (r2.hasNext() == false) goto L30;
        String r3 = r2.next();     // Catch: Throwable -> L32
        if (StringUtils.isEmpty(r3) == true) goto L10;
        List<String> r4 = r10.values(r3);     // Catch: Throwable -> L32
        if (r4 == null) goto L10;
        if (r4.isEmpty() == true) goto L10;
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L32
        Iterator<String> r6 = r4.iterator();     // Catch: Throwable -> L32
        int r7 = 0;
    L21:
        if (r6.hasNext() == false) goto L29;
        String r8 = r6.next();     // Catch: Throwable -> L32
        if (StringUtils.isEmpty(r8) == true) goto L21;
        if (r7 != 0) goto L27;
        r5.append(r8);     // Catch: Throwable -> L32
    L28:
        r7 = r7 + 1;     // Catch: Throwable -> L32
        goto L21
    L27:
        r5.append(VectorFormat.DEFAULT_SEPARATOR).append(r8);     // Catch: Throwable -> L32
        goto L28
    L29:
        r1.put(r3, r5.toString());     // Catch: Throwable -> L32
        goto L10
    L30:
        return r1.toString();
    L32:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    private static void processFinally(ResponseBody r0) {
        if (r0 != null) goto L4;
        return;
    L4:
        StreamParser.safeClose(r0);
    }

    private static JSONObject createExtraInfo(Request r6, BaseHttpRequestInfo r7) {
        JSONObject r0 = new JSONObject();
        if (r6 != null) goto L25;
        return r0;
    L25:
        r0.put(BaseHttpRequestInfo.KEY_HTTP_CLIENT, TAG);     // Catch: Exception -> L22
        r0.put(BaseHttpRequestInfo.KEY_HTTP_CLIENT_VERSION, sOkVersion);     // Catch: Exception -> L22
        r0.put(BaseHttpRequestInfo.KEY_USER_AGENT, r6.header("User-Agent"));     // Catch: Exception -> L22
        if (r7.executeTuringCallback == false) goto L10;
        r0.put("turing_callback", r7.turingCallbackDuration);     // Catch: Exception -> L22
    L10:
        if (r7.bdTuringRetry == false) goto L13;
        r0.put("turing_retry", "1");     // Catch: Exception -> L22
    L13:
        if (r7.retryByHeaderCallbackDuration < 0) goto L16;
        r0.put("turing_callback", r7.retryByHeaderCallbackDuration);     // Catch: Exception -> L22
    L16:
        if (r7.retryForAccountCallbackDuration < 0) goto L19;
        r0.put("retry_for_account_cost", r7.retryForAccountCallbackDuration);     // Catch: Exception -> L22
    L19:
        if (r7.retryByHeaderFilterKey == null) goto L24;
        r0.put("retry_by_header", r7.retryByHeaderFilterKey);     // Catch: Exception -> L22
    L24:
        return r0;
    L22:
        e = move-exception;
        e.printStackTrace();
        goto L24
    }

    @Override // com.bytedance.retrofit2.client.Client
    public SsCall newSsCall(com.bytedance.retrofit2.client.Request r6) throws IOException {
        com.bytedance.retrofit2.client.Request r5 = StoreRegionManager.inst().addStoreRegionHeaderForOkHttp(r6);     // Catch: Throwable -> L12
        if (r5 == null) goto L5;
        r6 = r5;
    L5:
        long r0 = SystemClock.uptimeMillis();
        com.bytedance.retrofit2.client.Request r7 = QueryFilterEngine.inst().filterQuery(r6);
        if (r6.getMetrics() == null) goto L8;
        RetrofitMetrics r2 = r6.getMetrics();
        r2.queryFilterDuration = SystemClock.uptimeMillis() - r0;
    L8:
        if (r7 == null) goto L11;
        r6 = r7;
    L11:
        return new Ok3SsCall(r6);
    }

    public void setOk3TncBridge(Ok3TncBridge r1) {
        sOk3TncBridge = r1;
    }

    public static Ok3TncBridge getOk3TncBridge() {
        return sOk3TncBridge;
    }

    public static void setNotAllowUseNetwork(boolean r0) {
        sNotAllowUseNetwork = r0;
    }

    public static void setFallbackReason(int r0) {
        sFallbackReason = r0;
    }

    public static int getFallbackReason() {
        return sFallbackReason;
    }

    public static void setFallbackMessage(String r0) {
        sFallbackMessage = r0;
    }

    public static void setProxy(String r7) throws IllegalArgumentException {
        if (r7 != null) goto L5;
        sProxy = null;
        return;
    L5:
        String[] r0 = r7.split(";");
        if (r0.length <= 0) goto L30;
        String[] r1 = r0[0].trim().split("=");
        if (r1.length != 2) goto L28;
        String r3 = r1[0].trim().toLowerCase();
        String[] r2 = r1[1].trim().split(":");
        if (r2.length != 2) goto L26;
        InetSocketAddress r4 = new InetSocketAddress(r2[0], Integer.parseInt(r2[1]));
        if (r3.equals("http") == false) goto L14;
    L23:
        sProxy = new Proxy(Proxy.Type.HTTP, r4);
        return;
    L14:
        if (r3.equals(HttpHeadTimeFetcher.FETCHER_TYPE) == true) goto L23;
        if (r3.equals("socks") == false) goto L19;
    L22:
        sProxy = new Proxy(Proxy.Type.SOCKS, r4);
        return;
    L19:
        if (r3.equals("socks4") == true) goto L22;
        if (r3.equals("socks5") == true) goto L22;
        return;
    L26:
        throw new IllegalArgumentException("Invalid proxy rule:" + r7);
    L28:
        throw new IllegalArgumentException("Invalid proxy rule:" + r7);
    L30:
        throw new IllegalArgumentException("Invalid proxy rule:" + r7);
    }

    private static String formatJsonHeaders(Headers r4) {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L17
        Iterator<Map.Entry<String, List<String>>> r5 = r4.toMultimap().entrySet().iterator();     // Catch: Exception -> L17
    L4:
        if (r5.hasNext() == false) goto L15;
        Map.Entry<String, List<String>> r1 = r5.next();     // Catch: Exception -> L17
        String r2 = r1.getKey();     // Catch: Exception -> L17
        List<String> r3 = r1.getValue();     // Catch: Exception -> L17
        if (TextUtils.isEmpty(r2) == true) goto L4;
        if (r3 == null) goto L4;
        if (r3.size() <= 0) goto L4;
        Iterator<String> r6 = r3.iterator();     // Catch: Exception -> L17
    L13:
        if (r6.hasNext() == false) goto L4;
        r0.put(r2, r6.next());     // Catch: Exception -> L17
        goto L13
    L15:
        return r0.toString();
    L17:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static void injectAppInfoProvider(IOkHttpAppInfoProvider r0) {
        sOkHttpAppInfoProvider = r0;
    }

    private static void tryNecessaryInit(Object r0) {
        NetworkParams.tryApiProcessHookInit();
        tryCookieManagerInit(r0);
    }

    private static void tryCookieManagerInit(Object r0) {
        if (NetworkParams.interceptCookie(r0) == true) goto L6;
        NetworkParams.tryCookieManagerInit();
        return;
    }

    public static String getOkVersion() {
        return sOkVersion;
    }

    public static IOkHttpAppInfoProvider getOkHttpAppInfoProvider() {
        return sOkHttpAppInfoProvider;
    }
}
