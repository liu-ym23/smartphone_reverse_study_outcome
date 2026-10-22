package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import android.net.Uri;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.android.settings.wifi.WifiAuthorizeUtils;
import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.dispatcher.ApiTask;
import com.bytedance.frameworks.baselib.network.dispatcher.IRequest;
import com.bytedance.frameworks.baselib.network.dispatcher.RequestQueue;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.RequestRetryResult;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
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
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
class ConcurrentCronetSsCall implements SsCall, SsCallTTNetExtend, IMetricsCollect, IRequestInfo, WeakHandler.IHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String API_SOURCE_5XX_CODE = "tt-api-source-5xx";
    private static final String CANCELED_EXCEPTION_MESSAGE = "request canceled";
    private static final int CANCELED_INTERNAL = -999;
    private static final String CRONET_EXCEPTION_CLASS_NAME = "com.ttnet.org.chromium.net.impl.NetworkExceptionImpl";
    private static final int MSG_API_DELAY = 0;
    private static final int MSG_API_IMMEDIATE = 1;
    private static final String REQUEST_HEADERS_BYPASS_ROUTE_SELECTION = "x-tt-bp-rs";
    private static final String REQUEST_HEADERS_TRANSACTION_ID = "transaction-id";
    private static final String TAG = "ConcurrentCronetSsCall";
    private static final int TIME_DELTA = 1;
    private static String mCallFailureMessage;
    private static HandlerThread mHandlerThread;
    private static boolean mRetryForNot2xxCode;
    private static Class sCronetExceptionCls;
    private boolean mBypassNetworkStatusCheck;
    private boolean mBypassRouteSelectionEnabled;
    private CountDownLatch mCallExecuteLatch;
    private volatile boolean mCanceled;
    private volatile boolean mCleanUpDone;
    private long mConnectTimeInterval;
    private List<ConnectionAttempts> mConnectionAttempts;
    private final Object mConnectionLock;
    private String mContentType;
    private volatile AtomicInteger mCurrentUrlIndex;
    private boolean mEnableRequestReportFix;
    private volatile int mFailedTimes;
    private ConnectionAttempts mFirstAttempt;
    private volatile HttpURLConnection mFirstFailedConnection;
    private String mFirstUrl;
    private WeakHandler mHandler;
    private String mNeedRemoveRetryByHeaderKey;
    private boolean mNeedRemoveTuringHeader;
    private String mOriginUrl;
    private List<HttpURLConnection> mPendingURLConnections;
    private BaseHttpRequestInfo mReqInfo;
    private long mRequestMaxWaitTime;
    private RetrofitMetrics mRetrofitMetrics;
    private Request mRetrofitRequest;
    private String mRsName;
    private String mRuleId;
    private Set<String> mSentHosts;
    private long mStartTime;
    private long mTNCRequestMaxWaitTime;
    private volatile long mThrottleNetSpeed;
    private String mTraceCode;
    private String mTransactionId;
    private List<String> mUrlList;
    private volatile HttpURLConnection mWinnerConnection;
    private volatile int mWinnerIndex;

    static class ConnectionAttempts {
        long mCleanUpTime;
        long mDispatchTime;
        String mDispatchedHost;
        String mDomain;
        long mEndTime;
        IOException mException;
        int mId;
        int mNetError;
        int mResponseCode;
        long mStartTime;
        Boolean sentAlready;

        ConnectionAttempts(String r4) {
            this.mId = -1;
            this.mDomain = r4;
            this.mStartTime = System.currentTimeMillis();
            this.mNetError = 0;
            this.mResponseCode = -1;
            this.mDispatchedHost = "";
            this.mDispatchTime = -1;
            this.sentAlready = false;
            this.mCleanUpTime = -1;
        }

        JSONObject toJson() {
            JSONObject r0 = new JSONObject();
            r0.put(WifiAuthorizeUtils.AUTO_LOGIN_HOST, this.mDomain);     // Catch: JSONException -> L18
            r0.put("start", this.mStartTime);     // Catch: JSONException -> L18
            r0.put(TraceStatsConsts.STATS_KEY_END, this.mEndTime);     // Catch: JSONException -> L18
            r0.put("net_error", this.mNetError);     // Catch: JSONException -> L18
            r0.put(AlogMonitor.ALOG_RESULT_CODE, this.mResponseCode);     // Catch: JSONException -> L18
            IOException r1 = this.mException;     // Catch: JSONException -> L18
            if (r1 == null) goto L11;
            String r2 = r1.getMessage();     // Catch: JSONException -> L18
            if (TextUtils.isEmpty(r2) == false) goto L8;
        L10:
            r0.put("exception", r2);     // Catch: JSONException -> L18
            goto L11
        L8:
            if (r2.length() <= 64) goto L10;
            r2 = r2.substring(0, 64);     // Catch: JSONException -> L18
        L11:
            r0.put("dispatch", this.mDispatchTime);     // Catch: JSONException -> L18
            r0.put("dpHost", this.mDispatchedHost);     // Catch: JSONException -> L18
            if (this.sentAlready.booleanValue() == false) goto L14;
            r0.put("sentAlready", true);     // Catch: JSONException -> L18
        L14:
            long r3 = this.mCleanUpTime;     // Catch: JSONException -> L18
            if (r3 <= 0) goto L17;
            r0.put("cleanUpTime", r3);     // Catch: JSONException -> L18
        L17:
            return r0;
        }
    }

    static /* synthetic */ RetrofitMetrics access$000(ConcurrentCronetSsCall r0) {
        return r0.mRetrofitMetrics;
    }

    static /* synthetic */ BaseHttpRequestInfo access$100(ConcurrentCronetSsCall r0) {
        return r0.mReqInfo;
    }

    static {
        mHandlerThread = new HandlerThread("Concurrent-Handler");
        mCallFailureMessage = null;
        sCronetExceptionCls = Class.forName(CRONET_EXCEPTION_CLASS_NAME);     // Catch: ClassNotFoundException -> L5
    L7:
        mHandlerThread.start();
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public ConcurrentCronetSsCall(Request r11, CronetSsCallConfig.UrlMatchRule r12) {
        this.mThrottleNetSpeed = 0;
        this.mBypassNetworkStatusCheck = false;
        this.mCanceled = false;
        this.mReqInfo = BaseHttpRequestInfo.createHttpRequestInfo();
        this.mSentHosts = new CopyOnWriteArraySet();
        this.mFirstUrl = "";
        this.mFirstAttempt = null;
        this.mUrlList = new ArrayList();
        this.mConnectionLock = new Object();
        this.mCurrentUrlIndex = new AtomicInteger(0);
        this.mPendingURLConnections = new CopyOnWriteArrayList();
        this.mCleanUpDone = false;
        this.mWinnerConnection = null;
        this.mWinnerIndex = -1;
        this.mFirstFailedConnection = null;
        this.mConnectionAttempts = new CopyOnWriteArrayList();
        this.mFailedTimes = 0;
        this.mCallExecuteLatch = new CountDownLatch(1);
        this.mHandler = new WeakHandler(mHandlerThread.getLooper(), this);
        this.mEnableRequestReportFix = false;
        this.mTNCRequestMaxWaitTime = 0;
        this.mNeedRemoveTuringHeader = false;
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "Request url: " + r11.getUrl());
    L5:
        this.mRetrofitRequest = r11;
        RetrofitMetrics r0 = r11.getMetrics();
        this.mRetrofitMetrics = r0;
        this.mReqInfo.metrics = r0;
        String r1 = r11.getUrl();
        this.mOriginUrl = r1;
        Uri r2 = Uri.parse(r1);
        String r3 = r2.getScheme();
        String r4 = r3 + "://" + r2.getHost();
        String r5 = r2.getQuery();
        Iterator<String> r6 = r12.getDomainList().iterator();
        int r7 = 0;
    L7:
        if (r6.hasNext() == false) goto L18;
        String r8 = this.mOriginUrl.replaceFirst(r4, r3 + "://" + r6.next());
        if (TextUtils.isEmpty(r5) == true) goto L17;
        if (r5.contains("concurrent=") == true) goto L13;
        r8 = r8 + "&concurrent=" + r7;
    L13:
        if (r7 <= 0) goto L17;
        if (r5.contains("is_retry=") == true) goto L17;
        r8 = r8 + "&is_retry=1";
    L17:
        r7 = r7 + 1;
        this.mUrlList.add(r8);
        goto L7
    L18:
        this.mTransactionId = UUID.randomUUID().toString();
        this.mRuleId = r12.mRuleId;
        this.mRsName = r12.mRefineRsName;
        this.mConnectTimeInterval = r12.mConnectTimeInterval;
        mRetryForNot2xxCode = r12.mRetryForNot2xxCode;
        this.mBypassRouteSelectionEnabled = r12.mBypassRouteSelectionEnabled;
        this.mTNCRequestMaxWaitTime = r12.mTNCRequestMaxWaitTime;
        this.mEnableRequestReportFix = r12.mEnableRequestReportFix;
        computeRequestMaxWaitTime(r11);
        if (Logger.debug() == false) goto L21;
        Logger.d(TAG, "Request max wait time milliseconds: " + this.mRequestMaxWaitTime + ", user max wait time: " + this.mTNCRequestMaxWaitTime + ", connect interval milliseconds: " + this.mConnectTimeInterval);
    L21:
        RetrofitMetrics r13 = this.mRetrofitMetrics;
        if (r13 == null) goto L24;
        r13.transactionId = this.mTransactionId;
        this.mRetrofitMetrics.isConcurrent = true;
        this.mReqInfo.appLevelRequestStart = this.mRetrofitMetrics.appLevelRequestStart;
        this.mReqInfo.beforeAllInterceptors = this.mRetrofitMetrics.beforeAllInterceptors;
    L24:
        long r9 = System.currentTimeMillis();
        this.mStartTime = r9;
        this.mReqInfo.requestStart = r9;
        this.mReqInfo.httpClientType = 0;
        if (this.mRetrofitRequest.isResponseStreaming() == false) goto L27;
        this.mReqInfo.downloadFile = true;
    L29:
        if ((r11.getExtraInfo() instanceof BaseRequestContext) == false) goto L37;
        this.mReqInfo.reqContext = (T) r11.getExtraInfo();
        this.mBypassNetworkStatusCheck = this.mReqInfo.reqContext.bypass_network_status_check;
        return;
    L37:
        return;
    L27:
        this.mReqInfo.downloadFile = false;
        goto L29
    }

    private void computeRequestMaxWaitTime(Request r5) {
        this.mRequestMaxWaitTime = NetworkParams.getConnectTimeout() + NetworkParams.getIoTimeout();
        if ((r5.getExtraInfo() instanceof BaseRequestContext) == false) goto L12;
        BaseRequestContext r6 = (BaseRequestContext) r5.getExtraInfo();
        if (r6.protect_timeout <= 0) goto L8;
        this.mRequestMaxWaitTime = r6.protect_timeout;
        goto L12
    L8:
        if (r6.timeout_connect <= 0) goto L12;
        if (r6.timeout_read <= 0) goto L12;
        this.mRequestMaxWaitTime = r6.timeout_connect + r6.timeout_read;
    L12:
        this.mRequestMaxWaitTime += 1000;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if ((r2.obj instanceof ConcurrentCronetSsCall) == false) goto L22;
        int r1 = r2.what;     // Catch: Throwable -> L14
        if (r1 != 0) goto L9;
        ((ConcurrentCronetSsCall) r2.obj).doApiTask();     // Catch: Throwable -> L14
    L17:
        return;
    L9:
        if (r1 != 1) goto L17;
        ((ConcurrentCronetSsCall) r2.obj).doApiTaskAndCancelDelayedTask();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    private static boolean shouldRetryApiTaskFromHttpCode(int r3, String r4, String r5) {
        if (r3 < 200) goto L6;
        if (r3 >= 300) goto L6;
        return false;
    L6:
        if (r4 != null) goto L8;
    L10:
        if (r3 < 300) goto L17;
        if (r3 >= 600) goto L17;
        if (mRetryForNot2xxCode == true) goto L17;
        return false;
    L17:
        if (CronetSsCallConfig.inst().inBlockErrorCode(r3, r5) == false) goto L19;
        return false;
    L19:
        return true;
    L8:
        if (r4.equals("1") == false) goto L10;
        return false;
    }

    private void doApiTask() {
        ApiTask r6 = new ApiTask("Concurrent-Call", IRequest.Priority.IMMEDIATE, 0, new ConcurrentCronetSsCall$$ExternalSyntheticLambda0(this), this.mReqInfo.downloadFile);
        RequestQueue.getDefaultRequestQueue().add(r6);
        scheduleApiTask(this.mConnectTimeInterval);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [com.bytedance.frameworks.baselib.network.http.cronet.impl.ConcurrentCronetSsCall$ConnectionAttempts] */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5, types: [com.bytedance.frameworks.baselib.network.http.cronet.impl.ConcurrentCronetSsCall$ConnectionAttempts, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r18v5 */
    /* JADX WARN: Type inference failed for: r18v6 */
    /* JADX WARN: Type inference failed for: r18v7 */
    /* JADX WARN: Type inference failed for: r18v8 */
    /* JADX WARN: Type inference failed for: r18v9 */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.bytedance.frameworks.baselib.network.http.cronet.impl.ConcurrentCronetSsCall] */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX INFO: renamed from: lambda$doApiTask$0$com-bytedance-frameworks-baselib-network-http-cronet-impl-ConcurrentCronetSsCall, reason: not valid java name */
    /* synthetic */ void m888x9b991af3() {
        long r4 = SystemClock.uptimeMillis();
        Object r7 = this.mConnectionLock;     // Catch: IOException -> L122
        monitor-enter(r7);     // Catch: IOException -> L122
    L113:
        th = th;
        HttpURLConnection r2 = null;
    L115:
        HttpURLConnection r6 = r2;
        HttpURLConnection r9 = r6;
        ?? r15 = r9;
        ?? r10 = r9;
    L212:
        monitor-exit(r7);     // Catch: Throwable -> L120
        throw th;     // Catch: IOException -> L118
    L118:
        e = e;
    L124:
        Object r3 = this.mConnectionLock;
        monitor-enter(r3);
        int r5 = -1;
        Class r8 = sCronetExceptionCls;     // Catch: Throwable -> L182
        if (r8 == null) goto L216;
        if (r8.isInstance(e) == false) goto L216;
        r5 = ((Integer) Reflect.on(e).call("getCronetInternalErrorCode").get()).intValue();     // Catch: Throwable -> L182
        if (Logger.debug() == false) goto L216;
        Logger.d(TAG, "cronet error code: " + r5);     // Catch: Throwable -> L182
    L216:
    L179:
        th = move-exception;
        throw th;
    L135:
        if (this.mFirstFailedConnection != null) goto L141;
        if (Logger.debug() == false) goto L139;
        Logger.d(TAG, "Get first failed connection " + r6.getURL().toString());     // Catch: Throwable -> L179
    L139:
        this.mFirstFailedConnection = r6;     // Catch: Throwable -> L179
    L143:
        if (r6 == null) goto L148;
        r6.disconnect();     // Catch: Throwable -> L179
        if (r15 == 0) goto L147;
        r15.mException = processException(e, r10, r6, false);     // Catch: Throwable -> L179
        r15.mNetError = r5;     // Catch: Throwable -> L179
        r15.mEndTime = System.currentTimeMillis();     // Catch: Throwable -> L179
    L147:
        this.mPendingURLConnections.remove(r6);     // Catch: Throwable -> L179
    L148:
        int r0 = this.mFailedTimes + 1;     // Catch: Throwable -> L179
        this.mFailedTimes = r0;     // Catch: Throwable -> L179
        if (r0 < this.mUrlList.size()) goto L157;
        if (Logger.debug() == false) goto L153;
        Logger.d(TAG, "Try all urls failed countdown.");     // Catch: Throwable -> L179
    L153:
        this.mCallExecuteLatch.countDown();     // Catch: Throwable -> L179
        monitor-exit(r3);     // Catch: Throwable -> L179
        return;
    L157:
        if (this.mEnableRequestReportFix == false) goto L167;
        if (this.mCanceled == false) goto L167;
        if (Logger.debug() == false) goto L163;
        Logger.d(TAG, "User canceled.");     // Catch: Throwable -> L179
    L163:
        this.mCallExecuteLatch.countDown();     // Catch: Throwable -> L179
        monitor-exit(r3);     // Catch: Throwable -> L179
        return;
    L167:
        if (CronetSsCallConfig.inst().inBlockErrorCode(r5, this.mRuleId) == false) goto L175;
        if (Logger.debug() == false) goto L171;
        Logger.d(TAG, "inBlockErrorCode countdown.");     // Catch: Throwable -> L179
    L171:
        this.mCallExecuteLatch.countDown();     // Catch: Throwable -> L179
        monitor-exit(r3);     // Catch: Throwable -> L179
        return;
    L175:
        if ((SystemClock.uptimeMillis() - r4) >= this.mConnectTimeInterval) goto L177;
        accelerateNextTaskWhenFailed();     // Catch: Throwable -> L179
    L177:
        monitor-exit(r3);     // Catch: Throwable -> L179
        return;
    L141:
        if (Logger.debug() == false) goto L143;
        Logger.d(TAG, "Get non first failed connection " + r6.getURL().toString());     // Catch: Throwable -> L179
    L120:
        th = th;
        goto L212
    L6:
        if (this.mCurrentUrlIndex.get() < this.mUrlList.size()) goto L187;
    L106:
        r2 = null;
        this.mHandler.removeCallbacksAndMessages(null);     // Catch: Throwable -> L111
        monitor-exit(r7);     // Catch: Throwable -> L111
        return;
    L111:
        th = th;
        goto L115
    L187:
    L103:
        th = th;
        r6 = null;
        ?? r11 = 0;
    L105:
        r15 = 0;
        r10 = r11;
        goto L212
    L8:
        if (this.mWinnerConnection != null) goto L106;
        if (this.mCallExecuteLatch.getCount() == 0) goto L106;
        if (this.mCanceled == true) goto L106;
        int r12 = this.mCurrentUrlIndex.get();     // Catch: Throwable -> L103
        r10 = this.mUrlList.get(r12);     // Catch: Throwable -> L103
        r10 = r10;
        r10 = r10;
        if (this.mRsName == null) goto L19;
        if (r12 <= 0) goto L19;
        UrlBuilder r13 = new UrlBuilder(r10);     // Catch: Throwable -> L101
        r13.addParam("bypass_rs", "1");     // Catch: Throwable -> L101
        r10 = r13.build();     // Catch: Throwable -> L101
    L19:
        r15 = new ConnectionAttempts(new URL(r10).getHost());     // Catch: Throwable -> L101
        this.mConnectionAttempts.add((ConnectionAttempts) r15);     // Catch: Throwable -> L98
        if (this.mRsName == null) goto L39;
    L36:
        th = th;
    L100:
        r6 = null;
        r10 = r10;
        r15 = r15;
        goto L212
    L23:
        if (dropIfDuplicate(r10, r15).booleanValue() == false) goto L39;
        if (r12 <= 0) goto L39;
        this.mFailedTimes++;     // Catch: Throwable -> L36
        if (this.mFailedTimes >= this.mUrlList.size()) goto L28;
        this.mCurrentUrlIndex.incrementAndGet();     // Catch: Throwable -> L36
        accelerateNextTaskWhenFailed();     // Catch: Throwable -> L36
        monitor-exit(r7);     // Catch: Throwable -> L36
        return;
    L28:
        if (Logger.debug() == false) goto L30;
        Logger.d(TAG, "Try all urls failed countdown.");     // Catch: Throwable -> L36
    L30:
        this.mCallExecuteLatch.countDown();     // Catch: Throwable -> L36
        monitor-exit(r7);     // Catch: Throwable -> L36
        return;
    L39:
        if (Logger.debug() == false) goto L41;
        Logger.d(TAG, "ConstructURLConnection and execute index: " + this.mCurrentUrlIndex.get() + " url: " + r10);     // Catch: Throwable -> L36
    L41:
        HttpURLConnection r14 = SsCronetHttpClient.constructURLConnection(r10, this.mRetrofitRequest, this.mReqInfo, this.mThrottleNetSpeed);     // Catch: Throwable -> L98
    L95:
        th = th;
    L97:
        r6 = r14;
        r10 = r10;
        r15 = r15;
        goto L212
    L43:
        if (this.mBypassRouteSelectionEnabled == true) goto L198;
    L50:
        r14.setRequestProperty(REQUEST_HEADERS_TRANSACTION_ID, this.mTransactionId);     // Catch: Throwable -> L95
        this.mCurrentUrlIndex.incrementAndGet();     // Catch: Throwable -> L95
        this.mPendingURLConnections.add(r14);     // Catch: Throwable -> L95
        r15.mId = r14.hashCode();     // Catch: Throwable -> L95
        monitor-exit(r7);     // Catch: Throwable -> L95
        int r16 = SsCronetHttpClient.processExecute(this.mRetrofitRequest, r14);     // Catch: IOException -> L92
        r15.mResponseCode = r16;     // Catch: IOException -> L92
        r15.mEndTime = System.currentTimeMillis();     // Catch: IOException -> L92
        if (shouldRetryApiTaskFromHttpCode(r16, r14.getHeaderField(API_SOURCE_5XX_CODE), this.mRuleId) == false) goto L208;
        String r17 = r14.getResponseMessage();     // Catch: IOException -> L92
        int r18 = this.mRetrofitRequest.getMaxLength();     // Catch: Throwable -> L82
        InputStream r1 = r14.getInputStream();     // Catch: Exception -> L75 Throwable -> L82
    L76:
        ?? r19 = r15;
        String r20 = SsCronetHttpClient.processHttpErrorResponse(false, r14.getHeaderFields(), r18, r1, SsCronetHttpClient.getHeaderValueIgnoreCase(r14, "Content-Type"), r10, this.mRetrofitMetrics, this.mReqInfo);     // Catch: Throwable -> L80
        r19 = r19;
    L89:
        throw new HttpResponseException(r16, r17, this.mRetrofitRequest.getPath(), r20);     // Catch: IOException -> L90
    L90:
        e = e;
        r6 = r14;
        r15 = r19;
    L80:
        th = th;
    L202:
        th.printStackTrace();     // Catch: IOException -> L90
        StringBuilder r21 = new StringBuilder("reason = ");     // Catch: IOException -> L90
        if (r17 != null) goto L87;
        r17 = "";
    L87:
        r17 = r21.append(r17).append("  exception = ").append(th.getMessage()).toString();     // Catch: IOException -> L90
        r20 = null;
        r19 = r19;
    L75:
        r1 = r14.getErrorStream();     // Catch: Throwable -> L82
    L82:
        th = th;
        r19 = r15;
        goto L202
    L208:
        Object r22 = this.mConnectionLock;     // Catch: IOException -> L69
        monitor-enter(r22);     // Catch: IOException -> L69
    L66:
        th = move-exception;
        throw th;     // Catch: IOException -> L69
    L57:
        if (this.mWinnerConnection != null) goto L62;
        this.mWinnerConnection = r14;     // Catch: Throwable -> L66
        this.mWinnerIndex = r12;     // Catch: Throwable -> L66
        this.mOriginUrl = r10;     // Catch: Throwable -> L66
        if (Logger.debug() == false) goto L61;
        Logger.d(TAG, "winnerindex is " + this.mWinnerIndex);     // Catch: Throwable -> L66
    L61:
        this.mCallExecuteLatch.countDown();     // Catch: Throwable -> L66
    L64:
        monitor-exit(r22);     // Catch: Throwable -> L66
    L222:
        return;
    L62:
        if (r14 == null) goto L64;
        r14.disconnect();     // Catch: Throwable -> L66
        this.mPendingURLConnections.remove(r14);     // Catch: Throwable -> L66
    L69:
        e = e;
    L94:
        r6 = r14;
    L92:
        e = e;
        goto L94
    L198:
    L48:
        th = th;
        goto L97
    L45:
        if (this.mRsName != null) goto L50;
        r14.setRequestProperty(REQUEST_HEADERS_BYPASS_ROUTE_SELECTION, "1");     // Catch: Throwable -> L48
    L98:
        th = th;
    L101:
        th = th;
        r6 = null;
        r11 = r10;
    L122:
        e = e;
        r6 = null;
        r10 = 0;
        r15 = 0;
        goto L124
    }

    private void accelerateNextTaskWhenFailed() {
        Message r0 = Message.obtain();
        r0.what = 1;
        r0.obj = this;
        this.mHandler.sendMessage(r0);
    }

    private void doApiTaskAndCancelDelayedTask() {
        if (this.mHandler.obtainMessage(0) == null) goto L6;
        this.mHandler.removeMessages(0);
        doApiTask();
        return;
    }

    private void scheduleApiTask(long r3) {
        Message r0 = Message.obtain();
        r0.what = 0;
        r0.obj = this;
        this.mHandler.sendMessageDelayed(r0, r3);
    }

    private void cleanupMessagesAndPendingConnections() {
        this.mHandler.removeCallbacksAndMessages(null);
        Object r0 = this.mConnectionLock;
        monitor-enter(r0);
    L26:
        th = move-exception;
        throw th;
    L5:
        if (this.mCleanUpDone == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L26
        return;
    L8:
        Iterator<HttpURLConnection> r1 = this.mPendingURLConnections.iterator();     // Catch: Throwable -> L26
    L10:
        if (r1.hasNext() == false) goto L23;
        HttpURLConnection r2 = r1.next();     // Catch: Throwable -> L26
        if (r2 == null) goto L10;
        Iterator<ConnectionAttempts> r3 = this.mConnectionAttempts.iterator();     // Catch: Throwable -> L26
    L15:
        if (r3.hasNext() == false) goto L22;
        ConnectionAttempts r4 = r3.next();     // Catch: Throwable -> L26
        if (r4.mId != r2.hashCode()) goto L15;
        r4.mEndTime = System.currentTimeMillis();     // Catch: Throwable -> L26
        if (this.mEnableRequestReportFix == false) goto L21;
        r4.mCleanUpTime = System.currentTimeMillis();     // Catch: Throwable -> L26
        goto L22
    L21:
        r4.mNetError = -999;     // Catch: Throwable -> L26
        r4.mException = new IOException("cleanupMessagesAndPendingConnections");     // Catch: Throwable -> L26
    L22:
        r2.disconnect();     // Catch: Throwable -> L26
        this.mPendingURLConnections.remove(r2);     // Catch: Throwable -> L26
        goto L10
    L23:
        RetrofitMetrics r5 = this.mRetrofitMetrics;     // Catch: Throwable -> L26
        r5.concurrentRequest = reportConcurrentRequestMetrics();     // Catch: Throwable -> L26
        this.mCleanUpDone = true;     // Catch: Throwable -> L26
        monitor-exit(r0);     // Catch: Throwable -> L26
    }

    private int retryCurrentRequestOneTime(Map<String, String> r10) throws IOException {
        if (this.mWinnerConnection == null) goto L5;
        this.mWinnerConnection.disconnect();
    L5:
        String r0 = this.mRetrofitRequest.getUrl();
        this.mWinnerConnection = SsCronetHttpClient.constructURLConnection(r0, this.mRetrofitRequest, this.mReqInfo, this.mThrottleNetSpeed);     // Catch: Exception -> L9
        SsCronetHttpClient.setRequestHeaders(this.mWinnerConnection, r10);     // Catch: Exception -> L9
        return SsCronetHttpClient.processExecute(this.mRetrofitRequest, this.mWinnerConnection);
    L9:
        e = move-exception;
        SsCronetHttpClient.processException(r0, this.mStartTime, this.mReqInfo, this.mTraceCode, e, this.mWinnerConnection, this.mRetrofitMetrics);
        this.mCanceled = true;
        if ((e instanceof TTNetExceptionStorage) == false) goto L13;
        throw e;
    L13:
        TTNetExceptionStorage r8 = new TTNetExceptionStorage(e.getMessage(), e.getCause());
        r8.setInfo(true, false, true, r0, this.mTraceCode, this.mReqInfo);
        throw r8;
    }

    private int retryRequestFromTuringHeader(int r4) throws IOException {
        RequestRetryResult r0 = SsCronetHttpClient.shouldRetryRequestFromTuringHeader(this.mRetrofitRequest.getHeaders(), this.mWinnerConnection, this.mReqInfo, r4);
        if (r0.isRequestRetryEnabled() == false) goto L7;
        return retryCurrentRequestOneTime(r0.getAddRequestHeaders());
    L7:
        if (this.mReqInfo.executeTuringCallback == false) goto L9;
        this.mNeedRemoveTuringHeader = true;
    L9:
        return r4;
    }

    private int retryRequestByHeader(int r4) throws IOException {
        RequestRetryResult r0 = SsCronetHttpClient.shouldRetryRequestByHeader(this.mRetrofitRequest.getHeaders(), this.mWinnerConnection, this.mReqInfo, r4);
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
        RequestRetryResult r0 = NetworkParams.shouldRetryForAccountRequest(this.mWinnerConnection.getURL().toString(), r8, false, this.mReqInfo, this.mRetrofitRequest.getHeaders(), this.mWinnerConnection.getHeaderFields());
        if (r0 != null) goto L5;
    L8:
        return r8;
    L5:
        if (r0.isRequestRetryEnabled() == false) goto L8;
        this.mReqInfo.bdTuringRetry = true;
        return retryCurrentRequestOneTime(r0.getAddRequestHeaders());
    }

    private JSONObject reportConcurrentRequestMetrics() {
        JSONObject r0 = new JSONObject();
        r0.put("concurrent", this.mConnectionAttempts.size() - 1);     // Catch: JSONException -> L14
        r0.put("duration", System.currentTimeMillis() - this.mStartTime);     // Catch: JSONException -> L14
        if (this.mEnableRequestReportFix == true) goto L6;
    L8:
        JSONArray r1 = new JSONArray();     // Catch: JSONException -> L14
        Iterator<ConnectionAttempts> r6 = this.mConnectionAttempts.iterator();     // Catch: JSONException -> L14
    L10:
        if (r6.hasNext() == false) goto L12;
        r1.put(r6.next().toJson());     // Catch: JSONException -> L14
        goto L10
    L12:
        r0.put("tasks", r1);     // Catch: JSONException -> L14
    L16:
        return r0;
    L6:
        if (TextUtils.isEmpty(mCallFailureMessage) == true) goto L8;
        r0.put("call_msg", mCallFailureMessage);     // Catch: JSONException -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public Response execute() throws IOException {
        RetrofitMetrics r3 = this.mRetrofitMetrics;
        if (r3 == null) goto L6;
        r3.callExecuteStartTime = System.currentTimeMillis();
    L6:
        if (this.mCanceled == true) goto L117;
        if (Logger.debug() == false) goto L10;
        Logger.d(TAG, "Execute url: " + this.mOriginUrl);
    L10:
        String r5 = null;
        SsCronetHttpClient.checkNetworkAvailable(this.mBypassNetworkStatusCheck, null, this.mRetrofitRequest.getPath());
        doApiTask();
        boolean r4 = true;
        long r6 = this.mRequestMaxWaitTime;     // Catch: Exception -> L107
        if (this.mEnableRequestReportFix == false) goto L14;
        r6 = Math.max(r6, this.mTNCRequestMaxWaitTime);     // Catch: Exception -> L107
    L14:
        this.mCallExecuteLatch.await(r6, TimeUnit.MILLISECONDS);     // Catch: Exception -> L107
        this.mCallExecuteLatch.countDown();     // Catch: Exception -> L107
        Object r7 = this.mConnectionLock;     // Catch: Exception -> L107
        monitor-enter(r7);     // Catch: Exception -> L107
    L104:
        th = move-exception;
        throw th;     // Catch: Exception -> L107
    L17:
        if (this.mEnableRequestReportFix == true) goto L24;
        if (this.mCanceled == false) goto L24;
        throw new IOException(CANCELED_EXCEPTION_MESSAGE);     // Catch: Throwable -> L104
    L24:
        if (this.mWinnerConnection != null) goto L37;
        CronetSsCallConfig.inst().notifyConcurrentRequestFinished(this.mRuleId, false);     // Catch: Throwable -> L104
        if (this.mConnectionAttempts.size() <= 0) goto L33;
        if (this.mConnectionAttempts.get(0).mException == null) goto L33;
        throw this.mConnectionAttempts.get(0).mException;     // Catch: Throwable -> L104
    L33:
        if (this.mEnableRequestReportFix == false) goto L36;
        mCallFailureMessage = "All urls have been tried and timed out by max wait time.";     // Catch: Throwable -> L104
    L38:
        monitor-exit(r7);     // Catch: Throwable -> L104
        cleanupMessagesAndPendingConnections();
    L95:
        e = move-exception;
    L98:
        th = th;
    L100:
        if (this.mRetrofitRequest.isResponseStreaming() == false) goto L102;
        if (r4 == true) goto L102;
    L103:
        throw th;
    L102:
        SsCronetHttpClient.processFinally(this.mWinnerConnection);
        goto L103
    L97:
        throw processException(e, this.mOriginUrl, this.mWinnerConnection, true);     // Catch: Throwable -> L98
    L93:
        th = th;
        r4 = false;
        goto L100
    L41:
        if (this.mWinnerIndex > 0) goto L43;
    L48:
        CronetSsCallConfig.inst().notifyConcurrentRequestFinished(this.mRuleId, true);     // Catch: Throwable -> L93 Exception -> L95
        int r0 = retryRequestFromTuringHeader(this.mWinnerConnection.getResponseCode());     // Catch: Throwable -> L93 Exception -> L95
        if (this.mReqInfo.executeTuringCallback == true) goto L52;
        r0 = retryRequestByHeader(r0);     // Catch: Throwable -> L93 Exception -> L95
    L52:
        if (this.mReqInfo.bdTuringRetry == true) goto L54;
        r0 = retryForAccountRequest(r0);     // Catch: Throwable -> L93 Exception -> L95
    L54:
        int r8 = r0;
        this.mReqInfo.responseBack = System.currentTimeMillis();     // Catch: Throwable -> L93 Exception -> L95
        this.mReqInfo.recycleCount = -1;     // Catch: Throwable -> L93 Exception -> L95
        String r1 = SsCronetHttpClient.processAfterExecute(this.mWinnerConnection, this.mReqInfo, r8);     // Catch: Throwable -> L93 Exception -> L95
        this.mTraceCode = r1;     // Catch: Throwable -> L93 Exception -> L95
        RetrofitMetrics r9 = this.mRetrofitMetrics;     // Catch: Throwable -> L93 Exception -> L95
        if (r9 == null) goto L57;
        r9.traceCode = r1;     // Catch: Throwable -> L93 Exception -> L95
    L57:
        this.mContentType = SsCronetHttpClient.getHeaderValueIgnoreCase(this.mWinnerConnection, "Content-Type");     // Catch: Throwable -> L93 Exception -> L95
        if (this.mRetrofitRequest.isResponseStreaming() == true) goto L60;
        int r10 = this.mRetrofitRequest.getMaxLength();     // Catch: Throwable -> L93 Exception -> L95
        this.mReqInfo.contentType = SsCronetHttpClient.getContentBaseType(this.mContentType);     // Catch: Throwable -> L93 Exception -> L95
        TypedInput r13 = new TypedByteArray(this.mContentType, SsCronetHttpClient.processResponse(this.mOriginUrl, r10, this.mWinnerConnection, this.mStartTime, this.mReqInfo, this.mTraceCode, r8, this.mRetrofitMetrics), new String[0]);     // Catch: Throwable -> L93 Exception -> L95
    L81:
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L93 Exception -> L95
        if (this.mNeedRemoveTuringHeader == false) goto L85;
        r2.add(NetworkParams.BDTURING_VERIFY_HEADER);     // Catch: Throwable -> L93 Exception -> L95
    L85:
        if (StringUtils.isEmpty(this.mNeedRemoveRetryByHeaderKey) == true) goto L87;
        r2.add(this.mNeedRemoveRetryByHeaderKey);     // Catch: Throwable -> L93 Exception -> L95
    L87:
        Response r11 = new Response(this.mOriginUrl, r8, this.mWinnerConnection.getResponseMessage(), SsCronetHttpClient.createHeaders(this.mWinnerConnection, r2), r13);     // Catch: Throwable -> L93 Exception -> L95
        r11.setExtraInfo(this.mReqInfo);     // Catch: Throwable -> L93 Exception -> L95
        if (this.mRetrofitRequest.isResponseStreaming() == true) goto L92;
        SsCronetHttpClient.processFinally(this.mWinnerConnection);
    L92:
        return r11;
    L60:
        if (r8 < 200) goto L64;
        if (r8 >= 300) goto L64;
    L65:
        r13 = createResponseBody(this.mWinnerConnection);     // Catch: Throwable -> L93 Exception -> L95
    L64:
        if (SsCronetHttpClient.isForceHandleResponse(this.mReqInfo) == true) goto L65;
        String r12 = this.mWinnerConnection.getResponseMessage();     // Catch: Throwable -> L93 Exception -> L95
        int r14 = this.mRetrofitRequest.getMaxLength();     // Catch: Throwable -> L73
        InputStream r15 = this.mWinnerConnection.getInputStream();     // Catch: Exception -> L70 Throwable -> L73
    L71:
        r5 = SsCronetHttpClient.processHttpErrorResponse(false, this.mWinnerConnection.getHeaderFields(), r14, r15, this.mContentType, this.mOriginUrl, this.mRetrofitMetrics, this.mReqInfo);     // Catch: Throwable -> L73
    L78:
        this.mWinnerConnection.disconnect();     // Catch: Throwable -> L93 Exception -> L95
        HttpResponseException r16 = new HttpResponseException(r8, r12, this.mRetrofitRequest.getPath(), r5);     // Catch: Throwable -> L93 Exception -> L95
        this.mReqInfo.hasReportStreamingApiAll.set(true);     // Catch: Throwable -> L93 Exception -> L95
        r16.setInfo(true, true, false, this.mRetrofitRequest.getUrl(), this.mTraceCode, this.mReqInfo);     // Catch: Throwable -> L93 Exception -> L95
        throw r16;     // Catch: Throwable -> L93 Exception -> L95
    L70:
        r15 = this.mWinnerConnection.getErrorStream();     // Catch: Throwable -> L73
    L73:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L93 Exception -> L95
        StringBuilder r17 = new StringBuilder("reason = ");     // Catch: Throwable -> L93 Exception -> L95
        if (r12 != null) goto L77;
        r12 = "";
    L77:
        r12 = r17.append(r12).append("  exception = ").append(th.getMessage()).toString();     // Catch: Throwable -> L93 Exception -> L95
        goto L78
    L43:
        if (TextUtils.isEmpty(this.mRsName) == true) goto L48;
        if (Logger.debug() == false) goto L47;
        Logger.e(TAG, "winner is " + this.mWinnerIndex + " url is " + this.mWinnerConnection.getURL().getHost());     // Catch: Throwable -> L93 Exception -> L95
    L47:
        setRouteSelectionBestHost(new URL(this.mUrlList.get(this.mWinnerIndex)).getHost(), this.mRsName);     // Catch: Throwable -> L93 Exception -> L95
        goto L48
    L36:
        throw processException(new IOException("All urls have been tried and timed out by max wait time."), this.mOriginUrl, this.mWinnerConnection, false);     // Catch: Throwable -> L104
    L37:
        this.mPendingURLConnections.remove(this.mWinnerConnection);     // Catch: Throwable -> L104
    L107:
        e = move-exception;
        cleanupMessagesAndPendingConnections();
        if (this.mWinnerConnection != null) goto L115;
        if (this.mFirstFailedConnection == null) goto L115;
        throw processException(e, this.mOriginUrl, this.mFirstFailedConnection, true);
    L115:
        throw processException(e, this.mOriginUrl, this.mWinnerConnection, true);
    L117:
        throw new IOException(CANCELED_EXCEPTION_MESSAGE);
    }

    private IOException processException(Exception r10, String r11, HttpURLConnection r12, boolean r13) {
        if (this.mEnableRequestReportFix == true) goto L13;
        if ((r10 instanceof IOException) == false) goto L13;
        if (r10.getMessage() == null) goto L13;
        if (r10.getMessage().startsWith(CANCELED_EXCEPTION_MESSAGE) == false) goto L13;
        return (IOException) r10;
    L13:
        if (CRONET_EXCEPTION_CLASS_NAME.equals(r10.getClass().getName()) == false) goto L15;
    L18:
        int r0 = SsCronetHttpClient.getCronetInternalErrorCode(r12);
    L20:
        if (TextUtils.isEmpty(r11) == false) goto L22;
        r11 = this.mOriginUrl;
    L22:
        if (r13 == false) goto L24;
        String r1 = r11;
        SsCronetHttpClient.processException(r1, this.mStartTime, this.mReqInfo, this.mTraceCode, r10, r12, this.mRetrofitMetrics);
    L26:
        String r14 = r10.getMessage();
        SsCronetHttpClient.checkNetworkAvailable(this.mBypassNetworkStatusCheck, r14, this.mRetrofitRequest.getPath());     // Catch: NetworkNotAvailabeException -> L36
        CronetIOException r15 = new CronetIOException(r10, this.mReqInfo, this.mTraceCode, r0);
        if (r13 == true) goto L31;
        String r5 = r11;
        r15.setInfo(false, false, false, r5, this.mTraceCode, this.mReqInfo);
    L35:
        return r15;
    L31:
        if (this.mRetrofitRequest.isResponseStreaming() == false) goto L33;
        this.mReqInfo.hasReportStreamingApiAll.set(true);
    L33:
        String r6 = r11;
        r15.setInfo(true, false, true, r6, this.mTraceCode, this.mReqInfo);
    L36:
        e = move-exception;
        return e;
    L24:
        if (r12 == null) goto L26;
        r12.disconnect();
        goto L26
    L15:
        if ("com.ttnet.org.chromium.net.impl.QuicExceptionImpl".equals(r10.getClass().getName()) == true) goto L18;
        r0 = 0;
        goto L20
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public void cancel() {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "cancel countdown.");
    L5:
        Object r1 = this.mConnectionLock;
        monitor-enter(r1);
    L25:
        th = move-exception;
        throw th;
    L8:
        if (this.mEnableRequestReportFix == true) goto L10;
        this.mCallExecuteLatch.countDown();     // Catch: Throwable -> L25
    L10:
        cleanupMessagesAndPendingConnections();     // Catch: Throwable -> L25
        if (this.mWinnerConnection == null) goto L22;
        this.mWinnerConnection.disconnect();     // Catch: Throwable -> L25
        if (this.mRetrofitRequest.isResponseStreaming() == false) goto L22;
        if (this.mCanceled == true) goto L22;
        doCollect();     // Catch: Throwable -> L25
        BaseHttpRequestInfo r2 = this.mReqInfo;     // Catch: Throwable -> L25
        r2.contentType = SsCronetHttpClient.getContentBaseType(this.mContentType);     // Catch: Throwable -> L25
        BaseHttpRequestInfo r3 = this.mReqInfo;     // Catch: Throwable -> L25
        r3.requestEnd = System.currentTimeMillis();     // Catch: Throwable -> L25
        if (this.mReqInfo.reqContext != 0) goto L19;
    L20:
        long r4 = this.mReqInfo.requestEnd;     // Catch: Throwable -> L25
        long r6 = this.mStartTime;     // Catch: Throwable -> L25
        NetworkParams.monitorApiSample(r4 - r6, r6, this.mRetrofitRequest.getUrl(), this.mTraceCode, this.mReqInfo);     // Catch: Throwable -> L25
    L21:
        StreamTrafficObservable.inst().onStreamTrafficChanged(this.mRetrofitRequest.getUrl(), this.mReqInfo.sentByteCount, this.mReqInfo.receivedByteCount, this.mReqInfo.contentType, this.mReqInfo.requestLog);     // Catch: Throwable -> L25
        goto L22
    L19:
        if (this.mReqInfo.reqContext.is_need_monitor_in_cancel == false) goto L21;
    L22:
        this.mCanceled = true;     // Catch: Throwable -> L25
        monitor-exit(r1);     // Catch: Throwable -> L25
    }

    @Override // com.bytedance.retrofit2.ttnet.SsCallTTNetExtend
    public void cancelNormalRequest(Throwable r10, boolean r11) {
        Object r0 = this.mConnectionLock;
        monitor-enter(r0);
        this.mCallExecuteLatch.countDown();     // Catch: Throwable -> L23
        cleanupMessagesAndPendingConnections();     // Catch: Throwable -> L23
        if (this.mWinnerConnection != null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L23
        return;
    L8:
        this.mWinnerConnection.disconnect();     // Catch: Throwable -> L23
        if (this.mCanceled == false) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L23
        return;
    L12:
        doCollect();     // Catch: Throwable -> L23
        BaseHttpRequestInfo r1 = this.mReqInfo;     // Catch: Throwable -> L23
        r1.contentType = SsCronetHttpClient.getContentBaseType(this.mContentType);     // Catch: Throwable -> L23
        BaseHttpRequestInfo r2 = this.mReqInfo;     // Catch: Throwable -> L23
        r2.requestEnd = System.currentTimeMillis();     // Catch: Throwable -> L23
        if (this.mReqInfo.reqContext != 0) goto L15;
    L16:
        NetworkParams.reportOneNormalRequest(r10, this.mTraceCode, this.mStartTime, this.mRetrofitRequest, this.mReqInfo, Boolean.valueOf(r11));     // Catch: Throwable -> L23
    L18:
        if (this.mRetrofitRequest.isResponseStreaming() == false) goto L20;
        StreamTrafficObservable.inst().onStreamTrafficChanged(this.mRetrofitRequest.getUrl(), this.mReqInfo.sentByteCount, this.mReqInfo.receivedByteCount, this.mReqInfo.contentType, this.mReqInfo.requestLog);     // Catch: Throwable -> L23
    L20:
        this.mCanceled = true;     // Catch: Throwable -> L23
        monitor-exit(r0);     // Catch: Throwable -> L23
        return;
    L15:
        if (this.mReqInfo.reqContext.is_need_monitor_in_cancel == false) goto L18;
    L23:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public boolean setThrottleNetSpeed(long r6) {
        this.mThrottleNetSpeed = r6;
        if (this.mWinnerConnection != null) goto L11;
    L10:
        return true;
    L11:
        Reflect.on(this.mWinnerConnection).call("setThrottleNetSpeed", new Class[]{Long.TYPE}, new Object[]{Long.valueOf(r6)});     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public Request getRequest() {
        return this.mRetrofitRequest;
    }

    private TypedInput createResponseBody(final HttpURLConnection r3) throws IOException {
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.getContentLength() != 0) goto L10;
        cancel();
        return null;
    L10:
        return new AnonymousClass1(this, r3);
    }

    @Override // com.bytedance.retrofit2.IMetricsCollect
    public void doCollect() {
        SsCronetHttpClient.getRequestMetrics(this.mWinnerConnection, this.mReqInfo, this.mRetrofitMetrics);
    }

    @Override // com.bytedance.retrofit2.IRequestInfo
    public Object getRequestInfo() {
        return this.mReqInfo;
    }

    public Boolean dropIfDuplicate(String r6, ConnectionAttempts r7) {
        if (TTNetInitMetrics.isCronetInitSuccess() == false) goto L23;
        if (r7 == null) goto L23;
        new URL(r6).toURI();     // Catch: Exception -> L19
        if (this.mCurrentUrlIndex.get() != 0) goto L11;
        this.mFirstUrl = r6;     // Catch: Exception -> L19
        this.mFirstAttempt = r7;     // Catch: Exception -> L19
        return false;
    L11:
        if (this.mCurrentUrlIndex.get() != 1) goto L13;
        this.mSentHosts.add(dispatch(this.mFirstUrl, this.mFirstAttempt));     // Catch: Exception -> L19
    L13:
        dispatch(r6, r7);     // Catch: Exception -> L19
        if (this.mSentHosts.contains(r7.mDispatchedHost) == false) goto L17;
        r7.sentAlready = true;     // Catch: Exception -> L19
        return true;
    L17:
        this.mSentHosts.add(r7.mDispatchedHost);     // Catch: Exception -> L19
        return false;
    L19:
        e = move-exception;
        e.printStackTrace();
        return true;
    L23:
        if (Logger.debug() == false) goto L25;
        Logger.e(TAG, "cronet did not init, dispatch fail");
    L25:
        return true;
    }

    private String dispatch(String r5, ConnectionAttempts r6) {
        if (r6 != null) goto L5;
        return "";
    L5:
        long r0 = System.currentTimeMillis();
        String r4 = SsCronetHttpClient.ttUrlDispatch(r5, -1).getFinalUrl();     // Catch: Exception -> L17
        r6.mDispatchTime = System.currentTimeMillis() - r0;
        r6.mDispatchedHost = new URI(r4).getHost();     // Catch: URISyntaxException -> L14
        if (Logger.debug() == false) goto L13;
        Logger.e(TAG, "url is " + r5 + " dispatchedUrl is " + r4);
    L13:
        return r6.mDispatchedHost;
    L14:
        e = move-exception;
        throw new RuntimeException(e);
    L17:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private void setRouteSelectionBestHost(String r1, String r2) {
        SsCronetHttpClient.setBestHostWithRouteSelectionName(r1, r2);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
