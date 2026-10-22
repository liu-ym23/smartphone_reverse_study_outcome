package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import android.net.Uri;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.dispatcher.ApiTask;
import com.bytedance.frameworks.baselib.network.dispatcher.IRequest;
import com.bytedance.frameworks.baselib.network.dispatcher.RequestQueue;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.mime.TypedInput;
import com.ttnet.org.chromium.net.impl.NetworkExceptionImpl;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

/* JADX INFO: loaded from: classes.dex */
class ConcurrentCronetSsCall extends BaseCronetSsCall implements WeakHandler.IHandler {
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
    private boolean mBypassRouteSelectionEnabled;
    private CountDownLatch mCallExecuteLatch;
    private volatile boolean mCleanUpDone;
    private long mConnectTimeInterval;
    private List<ConnectionAttempts> mConnectionAttempts;
    private final Object mConnectionLock;
    private volatile AtomicInteger mCurrentUrlIndex;
    private boolean mEnableRequestReportFix;
    private volatile int mFailedTimes;
    private ConnectionAttempts mFirstAttempt;
    private volatile HttpURLConnection mFirstFailedConnection;
    private String mFirstUrl;
    private WeakHandler mHandler;
    private String mOriginUrl;
    private List<HttpURLConnection> mPendingURLConnections;
    private long mRequestMaxWaitTime;
    private String mRsName;
    private String mRuleId;
    private Set<String> mSentHosts;
    private long mTNCRequestMaxWaitTime;
    private String mTransactionId;
    private List<String> mUrlList;
    private volatile HttpURLConnection mWinnerConnection;
    private volatile int mWinnerIndex;

    public static class ConnectionAttempts {
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

        public ConnectionAttempts(String r4) {
            this.mId = -1;
            this.mDomain = r4;
            this.mStartTime = System.currentTimeMillis();
            this.mNetError = 0;
            this.mResponseCode = -1;
            this.mDispatchedHost = "";
            this.mDispatchTime = -1;
            this.sentAlready = Boolean.FALSE;
            this.mCleanUpTime = -1;
        }

        public JSONObject toJson() {
            JSONObject r0 = new JSONObject();
            r0.put("host", this.mDomain);     // Catch: JSONException -> L18
            r0.put("start", this.mStartTime);     // Catch: JSONException -> L18
            r0.put(TraceStatsConsts.STATS_KEY_END, this.mEndTime);     // Catch: JSONException -> L18
            r0.put("net_error", this.mNetError);     // Catch: JSONException -> L18
            r0.put("code", this.mResponseCode);     // Catch: JSONException -> L18
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

    static {
        mHandlerThread = new HandlerThread("Concurrent-Handler");
        mCallFailureMessage = null;
        int r1 = NetworkExceptionImpl.b;     // Catch: ClassNotFoundException -> L5
        sCronetExceptionCls = NetworkExceptionImpl.class;     // Catch: ClassNotFoundException -> L5
    L7:
        mHandlerThread.start();
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public ConcurrentCronetSsCall(Request r10, CronetSsCallConfig.UrlMatchRule r11) {
        super(r10);
        this.mSentHosts = new CopyOnWriteArraySet();
        this.mFirstUrl = "";
        this.mFirstAttempt = null;
        this.mUrlList = new ArrayList();
        this.mConnectionLock = new Object();
        int r2 = 0;
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
        String r0 = r10.getUrl();
        this.mOriginUrl = r0;
        Uri r1 = Uri.parse(r0);
        String r3 = r1.getScheme();
        String r4 = a.a.B(r3, "://", r1.getHost());
        String r5 = r1.getQuery();
        Iterator<String> r6 = r11.getDomainList().iterator();
    L4:
        if (r6.hasNext() == false) goto L15;
        String r7 = this.mOriginUrl.replaceFirst(r4, a.a.B(r3, "://", r6.next()));
        if (TextUtils.isEmpty(r5) == true) goto L14;
        if (r5.contains("concurrent=") == true) goto L10;
        r7 = r7 + "&concurrent=" + r2;
    L10:
        if (r2 <= 0) goto L14;
        if (r5.contains("is_retry=") == true) goto L14;
        r7 = a.a.j(r7, "&is_retry=1");
    L14:
        r2 = r2 + 1;
        this.mUrlList.add(r7);
        goto L4
    L15:
        this.mTransactionId = UUID.randomUUID().toString();
        this.mRuleId = r11.mRuleId;
        this.mRsName = r11.mRefineRsName;
        this.mConnectTimeInterval = r11.mConnectTimeInterval;
        mRetryForNot2xxCode = r11.mRetryForNot2xxCode;
        this.mBypassRouteSelectionEnabled = r11.mBypassRouteSelectionEnabled;
        this.mTNCRequestMaxWaitTime = r11.mTNCRequestMaxWaitTime;
        this.mEnableRequestReportFix = r11.mEnableRequestReportFix;
        computeRequestMaxWaitTime(r10);
        if (Logger.debug() == false) goto L18;
        Logger.d(TAG, "Request max wait time milliseconds: " + this.mRequestMaxWaitTime + ", user max wait time: " + this.mTNCRequestMaxWaitTime + ", connect interval milliseconds: " + this.mConnectTimeInterval);
    L18:
        RetrofitMetrics r12 = this.requestInfo.metrics;
        if (r12 == null) goto L27;
        r12.transactionId = this.mTransactionId;
        r12.isConcurrent = true;
        return;
    }

    private void accelerateNextTaskWhenFailed() {
        Message r0 = Message.obtain();
        r0.what = 1;
        r0.obj = this;
        this.mHandler.sendMessage(r0);
    }

    public static /* synthetic */ void b(ConcurrentCronetSsCall r0) {
        r0.lambda$doApiTask$0();
    }

    private void cleanupMessagesAndPendingConnections() {
        this.mHandler.removeCallbacksAndMessages(null);
        Object r0 = this.mConnectionLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mCleanUpDone == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        Iterator<HttpURLConnection> r1 = this.mPendingURLConnections.iterator();     // Catch: Throwable -> L8
    L12:
        if (r1.hasNext() == false) goto L25;
        HttpURLConnection r2 = r1.next();     // Catch: Throwable -> L8
        if (r2 == null) goto L12;
        Iterator<ConnectionAttempts> r3 = this.mConnectionAttempts.iterator();     // Catch: Throwable -> L8
    L17:
        if (r3.hasNext() == false) goto L24;
        ConnectionAttempts r4 = r3.next();     // Catch: Throwable -> L8
        if (r4.mId != r2.hashCode()) goto L17;
        r4.mEndTime = System.currentTimeMillis();     // Catch: Throwable -> L8
        if (this.mEnableRequestReportFix == false) goto L23;
        r4.mCleanUpTime = System.currentTimeMillis();     // Catch: Throwable -> L8
        goto L24
    L23:
        r4.mNetError = CANCELED_INTERNAL;     // Catch: Throwable -> L8
        r4.mException = new IOException("cleanupMessagesAndPendingConnections");     // Catch: Throwable -> L8
    L24:
        r2.disconnect();     // Catch: Throwable -> L8
        this.mPendingURLConnections.remove(r2);     // Catch: Throwable -> L8
        goto L12
    L25:
        RetrofitMetrics r5 = this.requestInfo.metrics;     // Catch: Throwable -> L8
        if (r5 == null) goto L28;
        r5.concurrentRequest = reportConcurrentRequestMetrics();     // Catch: Throwable -> L8
    L28:
        this.mCleanUpDone = true;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private void computeRequestMaxWaitTime(Request r7) {
        this.mRequestMaxWaitTime = NetworkParams.getIoTimeout() + NetworkParams.getConnectTimeout();
        if ((r7.getExtraInfo() instanceof BaseRequestContext) == false) goto L12;
        BaseRequestContext r8 = (BaseRequestContext) r7.getExtraInfo();
        long r0 = r8.protect_timeout;
        if (r0 <= 0) goto L7;
        this.mRequestMaxWaitTime = r0;
        goto L12
    L7:
        long r1 = r8.timeout_connect;
        if (r1 <= 0) goto L12;
        long r4 = r8.timeout_read;
        if (r4 <= 0) goto L12;
        this.mRequestMaxWaitTime = r1 + r4;
    L12:
        this.mRequestMaxWaitTime += 1000;
    }

    private String dispatch(String r5, ConnectionAttempts r6) {
        if (r6 != null) goto L5;
        return "";
    L5:
        long r0 = System.currentTimeMillis();
        String r4 = SsCronetHttpClient.ttUrlDispatch(r5, -1, true).getFinalUrl();     // Catch: Exception -> L17
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

    private void doApiTask() {
        ApiTask r6 = new ApiTask("Concurrent-Call", IRequest.Priority.IMMEDIATE, 0, new a(this), this.requestInfo.downloadFile);
        RequestQueue.getDefaultRequestQueue().add(r6);
        scheduleApiTask(this.mConnectTimeInterval);
    }

    private void doApiTaskAndCancelDelayedTask() {
        if (this.mHandler.obtainMessage(0) == null) goto L6;
        this.mHandler.removeMessages(0);
        doApiTask();
        return;
    }

    private IOException handleException(Exception r9, String r10, HttpURLConnection r11, boolean r12) {
        if (this.mEnableRequestReportFix == true) goto L13;
        if ((r9 instanceof IOException) == false) goto L13;
        if (r9.getMessage() == null) goto L13;
        if (r9.getMessage().startsWith(CANCELED_EXCEPTION_MESSAGE) == false) goto L13;
        return (IOException) r9;
    L13:
        if (CRONET_EXCEPTION_CLASS_NAME.equals(r9.getClass().getName()) == false) goto L15;
    L18:
        int r0 = SsCronetHttpClient.getCronetInternalErrorCode(r11);
    L20:
        if (TextUtils.isEmpty(r10) == false) goto L22;
        r10 = this.mOriginUrl;
    L22:
        String r5 = r10;
        if (r12 == false) goto L25;
        BaseSsCall.updateRequestInfoWithException(r5, this.requestInfo, this, this, r9);
    L38:
        checkNetworkAvailableAfterRequest(this.retrofitRequest, r9);     // Catch: NetworkNotAvailabeException -> L36
        CronetIOException r13 = new CronetIOException(r9, this.requestInfo, r0);
        if (r12 == true) goto L31;
        BaseHttpRequestInfo r7 = this.requestInfo;
        r13.setInfo(false, false, false, r5, r7.traceCode, r7);
    L35:
        return r13;
    L31:
        if (this.retrofitRequest.isResponseStreaming() == false) goto L33;
        this.requestInfo.hasReportStreamingApiAll.set(true);
    L33:
        BaseHttpRequestInfo r8 = this.requestInfo;
        r13.setInfo(true, false, true, r5, r8.traceCode, r8);
    L36:
        e = move-exception;
        return e;
    L25:
        if (r11 == null) goto L38;
        r11.disconnect();
        goto L38
    L15:
        if ("com.ttnet.org.chromium.net.impl.QuicExceptionImpl".equals(r9.getClass().getName()) == true) goto L18;
        r0 = 0;
        goto L20
    }

    private /* synthetic */ void lambda$doApiTask$0() {
        long r4 = SystemClock.uptimeMillis();
        HttpURLConnection r6 = null;
        String r7 = null;
        r6 = null;
        r6 = null;
        r6 = null;
        Object r8 = this.mConnectionLock;     // Catch: IOException -> L99
        monitor-enter(r8);     // Catch: IOException -> L99
    L90:
        th = th;
        String r9 = null;
        ConnectionAttempts r10 = null;
    L95:
        monitor-exit(r8);     // Catch: Throwable -> L32
        throw th;     // Catch: IOException -> L97
    L97:
        e = e;
    L101:
        Object r2 = this.mConnectionLock;
        monitor-enter(r2);
        int r3 = -1;
        Class r11 = sCronetExceptionCls;     // Catch: Throwable -> L160
        if (r11 == null) goto L163;
        if (r11.isInstance(e) == false) goto L163;
        r3 = ((Integer) Reflect.on(e).call("getCronetInternalErrorCode").get()).intValue();     // Catch: Throwable -> L160
        if (Logger.debug() == false) goto L163;
        Logger.d(TAG, "cronet error code: " + r3);     // Catch: Throwable -> L160
    L163:
    L116:
        th = move-exception;
        throw th;
    L112:
        if (this.mFirstFailedConnection != null) goto L120;
        if (Logger.debug() == false) goto L118;
        Logger.d(TAG, "Get first failed connection " + r6.getURL().toString());     // Catch: Throwable -> L116
    L118:
        this.mFirstFailedConnection = r6;     // Catch: Throwable -> L116
    L122:
        if (r6 == null) goto L127;
        r6.disconnect();     // Catch: Throwable -> L116
        if (r10 == null) goto L126;
        r10.mException = handleException(e, r9, r6, false);     // Catch: Throwable -> L116
        r10.mNetError = r3;     // Catch: Throwable -> L116
        r10.mEndTime = System.currentTimeMillis();     // Catch: Throwable -> L116
    L126:
        this.mPendingURLConnections.remove(r6);     // Catch: Throwable -> L116
    L127:
        int r0 = this.mFailedTimes + 1;     // Catch: Throwable -> L116
        this.mFailedTimes = r0;     // Catch: Throwable -> L116
        if (r0 < this.mUrlList.size()) goto L136;
        if (Logger.debug() == false) goto L132;
        Logger.d(TAG, "Try all urls failed countdown.");     // Catch: Throwable -> L116
    L132:
        this.mCallExecuteLatch.countDown();     // Catch: Throwable -> L116
        monitor-exit(r2);     // Catch: Throwable -> L116
        return;
    L136:
        if (this.mEnableRequestReportFix == false) goto L146;
        if (this.canceled == false) goto L146;
        if (Logger.debug() == false) goto L142;
        Logger.d(TAG, "User canceled.");     // Catch: Throwable -> L116
    L142:
        this.mCallExecuteLatch.countDown();     // Catch: Throwable -> L116
        monitor-exit(r2);     // Catch: Throwable -> L116
        return;
    L146:
        if (CronetSsCallConfig.inst().inBlockErrorCode(r3, this.mRuleId) == false) goto L154;
        if (Logger.debug() == false) goto L150;
        Logger.d(TAG, "inBlockErrorCode countdown.");     // Catch: Throwable -> L116
    L150:
        this.mCallExecuteLatch.countDown();     // Catch: Throwable -> L116
        monitor-exit(r2);     // Catch: Throwable -> L116
        return;
    L154:
        if ((SystemClock.uptimeMillis() - r4) >= this.mConnectTimeInterval) goto L156;
        accelerateNextTaskWhenFailed();     // Catch: Throwable -> L116
    L156:
        monitor-exit(r2);     // Catch: Throwable -> L116
        return;
    L120:
        if (Logger.debug() == false) goto L122;
        Logger.d(TAG, "Get non first failed connection " + r6.getURL().toString());     // Catch: Throwable -> L116
        goto L122
    L6:
        if (this.mCurrentUrlIndex.get() < this.mUrlList.size()) goto L8;
    L92:
        this.mHandler.removeCallbacksAndMessages(null);     // Catch: Throwable -> L90
        monitor-exit(r8);     // Catch: Throwable -> L90
        return;
    L8:
        if (this.mWinnerConnection != null) goto L92;
        if (this.mCallExecuteLatch.getCount() == 0) goto L92;
        if (this.canceled == true) goto L92;
        int r12 = this.mCurrentUrlIndex.get();     // Catch: Throwable -> L90
        r9 = this.mUrlList.get(r12);     // Catch: Throwable -> L90
    L19:
        th = th;
        r10 = null;
        goto L95
    L16:
        if (this.mRsName == null) goto L21;
        if (r12 <= 0) goto L21;
        UrlBuilder r13 = new UrlBuilder(r9);     // Catch: Throwable -> L19
        r13.addParam("bypass_rs", "1");     // Catch: Throwable -> L19
        r9 = r13.build();     // Catch: Throwable -> L19
    L21:
        r10 = new ConnectionAttempts(new URL(r9).getHost());     // Catch: Throwable -> L19
        this.mConnectionAttempts.add(r10);     // Catch: Throwable -> L32
        if (this.mRsName == null) goto L41;
        if (dropIfDuplicate(r9, r10).booleanValue() == false) goto L41;
        if (r12 <= 0) goto L41;
        this.mFailedTimes++;     // Catch: Throwable -> L32
        if (this.mFailedTimes >= this.mUrlList.size()) goto L30;
        this.mCurrentUrlIndex.incrementAndGet();     // Catch: Throwable -> L32
        accelerateNextTaskWhenFailed();     // Catch: Throwable -> L32
        monitor-exit(r8);     // Catch: Throwable -> L32
        return;
    L30:
        if (Logger.debug() == false) goto L34;
        Logger.d(TAG, "Try all urls failed countdown.");     // Catch: Throwable -> L32
    L34:
        this.mCallExecuteLatch.countDown();     // Catch: Throwable -> L32
        monitor-exit(r8);     // Catch: Throwable -> L32
        return;
    L41:
        if (Logger.debug() == false) goto L43;
        Logger.d(TAG, "ConstructURLConnection and execute index: " + this.mCurrentUrlIndex.get() + " url: " + r9);     // Catch: Throwable -> L32
    L43:
        HttpURLConnection r5 = constructConnection(r9, this.requestInfo);     // Catch: Throwable -> L32
        configureConnection(this.retrofitRequest, this.requestInfo, r5, null);     // Catch: Throwable -> L49
        if (this.mBypassRouteSelectionEnabled == true) goto L47;
    L51:
        r5.setRequestProperty(REQUEST_HEADERS_TRANSACTION_ID, this.mTransactionId);     // Catch: Throwable -> L49
        this.mCurrentUrlIndex.incrementAndGet();     // Catch: Throwable -> L49
        this.mPendingURLConnections.add(r5);     // Catch: Throwable -> L49
        r10.mId = r5.hashCode();     // Catch: Throwable -> L49
        monitor-exit(r8);     // Catch: Throwable -> L49
        this.responseCode = executeConnection(r5);     // Catch: IOException -> L70
        r10.mResponseCode = this.responseCode;     // Catch: IOException -> L70
        r10.mEndTime = System.currentTimeMillis();     // Catch: IOException -> L70
        if (shouldRetryApiTaskFromHttpCode(this.responseCode, r5.getHeaderField(API_SOURCE_5XX_CODE), this.mRuleId) == true) goto L72;
        Object r14 = this.mConnectionLock;     // Catch: IOException -> L70
        monitor-enter(r14);     // Catch: IOException -> L70
    L62:
        th = move-exception;
        throw th;     // Catch: IOException -> L70
    L58:
        if (this.mWinnerConnection != null) goto L65;
        this.mWinnerConnection = r5;     // Catch: Throwable -> L62
        this.mWinnerIndex = r12;     // Catch: Throwable -> L62
        this.mOriginUrl = r9;     // Catch: Throwable -> L62
        if (Logger.debug() == false) goto L64;
        Logger.d(TAG, "winnerindex is " + this.mWinnerIndex);     // Catch: Throwable -> L62
    L64:
        this.mCallExecuteLatch.countDown();     // Catch: Throwable -> L62
    L66:
        monitor-exit(r14);     // Catch: Throwable -> L62
    L181:
        return;
    L65:
        r5.disconnect();     // Catch: Throwable -> L62
        this.mPendingURLConnections.remove(r5);     // Catch: Throwable -> L62
        goto L66
    L72:
        String r15 = r5.getResponseMessage();     // Catch: IOException -> L70
        int r16 = this.retrofitRequest.getMaxLength();     // Catch: Throwable -> L76
        InputStream r1 = r5.getInputStream();     // Catch: Throwable -> L76 Exception -> L78
    L75:
        InputStream r17 = r1;
        String r18 = r5.getHeaderField("Content-Type");     // Catch: Throwable -> L76
        if (TextUtils.isEmpty(r18) == false) goto L82;
        r18 = r5.getHeaderField("Content-Type".toLowerCase());     // Catch: Throwable -> L76
    L82:
        r7 = BaseSsCall.processHttpErrorResponse(this.requestInfo, r5.getHeaderFields(), r16, r17, r18, false);     // Catch: Throwable -> L76
    L89:
        throw new HttpResponseException(this.responseCode, r15, this.retrofitRequest.getPath(), r7);     // Catch: IOException -> L70
    L78:
        r1 = r5.getErrorStream();     // Catch: Throwable -> L76
    L76:
        th = move-exception;
        th.printStackTrace();     // Catch: IOException -> L70
        StringBuilder r19 = new StringBuilder("reason = ");     // Catch: IOException -> L70
        if (r15 != null) goto L87;
        r15 = "";
    L87:
        r19.append(r15);     // Catch: IOException -> L70
        r19.append("  exception = ");     // Catch: IOException -> L70
        r19.append(th.getMessage());     // Catch: IOException -> L70
        r15 = r19.toString();     // Catch: IOException -> L70
    L70:
        e = e;
        r6 = r5;
        goto L101
    L47:
        if (this.mRsName != null) goto L51;
        r5.setRequestProperty(REQUEST_HEADERS_BYPASS_ROUTE_SELECTION, "1");     // Catch: Throwable -> L49
    L49:
        th = th;
        r6 = r5;
    L32:
        th = th;
    L99:
        e = e;
        r9 = null;
        r10 = null;
        goto L101
    }

    private JSONObject reportConcurrentRequestMetrics() {
        JSONObject r0 = new JSONObject();
        r0.put("concurrent", this.mConnectionAttempts.size() - 1);     // Catch: JSONException -> L8
        r0.put("duration", System.currentTimeMillis() - this.requestInfo.requestStart);     // Catch: JSONException -> L8
        if (this.mEnableRequestReportFix == true) goto L6;
    L10:
        JSONArray r1 = new JSONArray();     // Catch: JSONException -> L8
        Iterator<ConnectionAttempts> r6 = this.mConnectionAttempts.iterator();     // Catch: JSONException -> L8
    L12:
        if (r6.hasNext() == false) goto L14;
        r1.put(r6.next().toJson());     // Catch: JSONException -> L8
        goto L12
    L14:
        r0.put("tasks", r1);     // Catch: JSONException -> L8
    L17:
        return r0;
    L6:
        if (TextUtils.isEmpty(mCallFailureMessage) == true) goto L10;
        r0.put("call_msg", mCallFailureMessage);     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    private void scheduleApiTask(long r3) {
        Message r0 = Message.obtain();
        r0.what = 0;
        r0.obj = this;
        this.mHandler.sendMessageDelayed(r0, r3);
    }

    private void setRouteSelectionBestHost(String r1, String r2) {
        SsCronetHttpClient.setBestHostWithRouteSelectionName(r1, r2);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
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

    @Override // com.bytedance.retrofit2.client.SsCall
    public void cancel() {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "cancel countdown.");
    L5:
        Object r0 = this.mConnectionLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.mEnableRequestReportFix == true) goto L12;
        this.mCallExecuteLatch.countDown();     // Catch: Throwable -> L10
    L12:
        cleanupMessagesAndPendingConnections();     // Catch: Throwable -> L10
        cancelInner(this.mWinnerConnection);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    @Override // com.bytedance.retrofit2.ttnet.SsCallTTNetExtend
    public void cancelNormalRequest(Throwable r3, boolean r4) {
        Object r0 = this.mConnectionLock;
        monitor-enter(r0);
        this.mCallExecuteLatch.countDown();     // Catch: Throwable -> L7
        cleanupMessagesAndPendingConnections();     // Catch: Throwable -> L7
        cancelNormalRequestInner(this.mWinnerConnection, r3, r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.BaseCronetSsCall
    public HttpURLConnection connection() {
        if (this.mWinnerConnection == null) goto L6;
        return this.mWinnerConnection;
    L6:
        return this.mFirstFailedConnection;
    }

    @Override // com.bytedance.retrofit2.IMetricsCollect
    public void doCollect() {
        BaseSsCall.getRequestMetrics(this.requestInfo, this);
    }

    public Boolean dropIfDuplicate(String r4, ConnectionAttempts r5) {
        if (TTNetInitMetrics.isCronetInitSuccess() == false) goto L24;
        if (r5 == null) goto L24;
        new URL(r4).toURI();     // Catch: Exception -> L10
        if (this.mCurrentUrlIndex.get() != 0) goto L13;
        this.mFirstUrl = r4;     // Catch: Exception -> L10
        this.mFirstAttempt = r5;     // Catch: Exception -> L10
        return Boolean.FALSE;
    L13:
        if (this.mCurrentUrlIndex.get() != 1) goto L15;
        this.mSentHosts.add(dispatch(this.mFirstUrl, this.mFirstAttempt));     // Catch: Exception -> L10
    L15:
        dispatch(r4, r5);     // Catch: Exception -> L10
        if (this.mSentHosts.contains(r5.mDispatchedHost) == false) goto L19;
        Boolean r3 = Boolean.TRUE;     // Catch: Exception -> L10
        r5.sentAlready = r3;     // Catch: Exception -> L10
        return r3;
    L19:
        this.mSentHosts.add(r5.mDispatchedHost);     // Catch: Exception -> L10
        return Boolean.FALSE;
    L10:
        e = move-exception;
        e.printStackTrace();
        return Boolean.TRUE;
    L24:
        if (Logger.debug() == false) goto L27;
        Logger.e(TAG, "cronet did not init, dispatch fail");
    L27:
        return Boolean.TRUE;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall, com.bytedance.retrofit2.client.SsCall
    public Response execute() {
        RetrofitMetrics r1 = this.requestInfo.metrics;
        if (r1 == null) goto L6;
        r1.callExecuteStartTime = System.currentTimeMillis();
    L6:
        if (this.canceled == true) goto L78;
        BaseSsCall.tryNecessaryInit(this.retrofitRequest, this.requestInfo);
        BaseSsCall.checkNetworkAvailableBeforeRequest(bypassNetworkStatusCheck(), getContext(), this.retrofitRequest.getPath());
        doApiTask();
        boolean r9 = true;
        long r2 = this.mRequestMaxWaitTime;     // Catch: Exception -> L11
        if (this.mEnableRequestReportFix == false) goto L13;
        r2 = Math.max(r2, this.mTNCRequestMaxWaitTime);     // Catch: Exception -> L11
    L13:
        this.mCallExecuteLatch.await(r2, TimeUnit.MILLISECONDS);     // Catch: Exception -> L11
        this.mCallExecuteLatch.countDown();     // Catch: Exception -> L11
        Object r3 = this.mConnectionLock;     // Catch: Exception -> L11
        monitor-enter(r3);     // Catch: Exception -> L11
    L22:
        th = move-exception;
        throw th;     // Catch: Exception -> L11
    L16:
        if (this.mEnableRequestReportFix == true) goto L25;
        if (this.canceled == false) goto L25;
        throw new IOException(CANCELED_EXCEPTION_MESSAGE);     // Catch: Throwable -> L22
    L25:
        if (this.mWinnerConnection != null) goto L38;
        CronetSsCallConfig.inst().notifyConcurrentRequestFinished(this.mRuleId, false);     // Catch: Throwable -> L22
        if (this.mConnectionAttempts.size() <= 0) goto L34;
        if (this.mConnectionAttempts.get(0).mException == null) goto L34;
        throw this.mConnectionAttempts.get(0).mException;     // Catch: Throwable -> L22
    L34:
        if (this.mEnableRequestReportFix == false) goto L37;
        mCallFailureMessage = "All urls have been tried and timed out by max wait time.";     // Catch: Throwable -> L22
    L39:
        monitor-exit(r3);     // Catch: Throwable -> L22
        cleanupMessagesAndPendingConnections();
    L50:
        e = move-exception;
    L61:
        th = th;
    L63:
        if (this.retrofitRequest.isResponseStreaming() == false) goto L65;
        if (r9 == true) goto L65;
    L66:
        throw th;
    L65:
        safeClose();
        goto L66
    L60:
        throw handleException(e, this.mOriginUrl, this.mWinnerConnection, true);     // Catch: Throwable -> L61
    L48:
        th = th;
        r9 = false;
        goto L63
    L42:
        if (this.mWinnerIndex > 0) goto L44;
    L53:
        CronetSsCallConfig.inst().notifyConcurrentRequestFinished(this.mRuleId, true);     // Catch: Throwable -> L48 Exception -> L50
        List<String> r0 = retryRequestOnceIfNeeded(this.retrofitRequest, this.requestInfo, this, true, true);     // Catch: Throwable -> L48 Exception -> L50
        onFinalResponseReceived(this.requestInfo, this);     // Catch: Throwable -> L48 Exception -> L50
        TypedInput r4 = BaseSsCall.processResponseBody(this.mOriginUrl, this.retrofitRequest, this.requestInfo, this, this, this, false);     // Catch: Throwable -> L48 Exception -> L50
        onResponseBodyProcessed(r4);     // Catch: Throwable -> L48 Exception -> L50
        Response r5 = new Response(this.mOriginUrl, this.responseCode, this.mWinnerConnection.getResponseMessage(), BaseSsCall.createHeaders(this, r0), r4);     // Catch: Throwable -> L48 Exception -> L50
        r5.setExtraInfo(this.requestInfo);     // Catch: Throwable -> L48 Exception -> L50
    L55:
        if (this.retrofitRequest.isResponseStreaming() == true) goto L58;
        safeClose();
    L58:
        return r5;
    L44:
        if (TextUtils.isEmpty(this.mRsName) == true) goto L53;
        if (Logger.debug() == false) goto L52;
        Logger.e(TAG, "winner is " + this.mWinnerIndex + " url is " + this.mWinnerConnection.getURL().getHost());     // Catch: Throwable -> L48 Exception -> L50
    L52:
        setRouteSelectionBestHost(new URL(this.mUrlList.get(this.mWinnerIndex)).getHost(), this.mRsName);     // Catch: Throwable -> L48 Exception -> L50
        goto L53
    L37:
        throw handleException(new IOException("All urls have been tried and timed out by max wait time."), this.mOriginUrl, this.mWinnerConnection, false);     // Catch: Throwable -> L22
    L38:
        this.mPendingURLConnections.remove(this.mWinnerConnection);     // Catch: Throwable -> L22
    L11:
        e = move-exception;
        cleanupMessagesAndPendingConnections();
        if (this.mWinnerConnection != null) goto L76;
        if (this.mFirstFailedConnection == null) goto L76;
        throw handleException(e, this.mOriginUrl, this.mFirstFailedConnection, true);
    L76:
        throw handleException(e, this.mOriginUrl, this.mWinnerConnection, true);
    L78:
        throw new IOException(CANCELED_EXCEPTION_MESSAGE);
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r2) {
        if (r2 == null) goto L22;
        Object r1 = r2.obj;
        if ((r1 instanceof ConcurrentCronetSsCall) == false) goto L23;
        int r3 = r2.what;     // Catch: Throwable -> L12
        if (r3 != 0) goto L9;
        ((ConcurrentCronetSsCall) r1).doApiTask();     // Catch: Throwable -> L12
    L18:
        return;
    L9:
        if (r3 != 1) goto L18;
        ((ConcurrentCronetSsCall) r1).doApiTaskAndCancelDelayedTask();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    L23:
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.BaseCronetSsCall, com.bytedance.retrofit2.client.SsCall
    public boolean setThrottleNetSpeed(long r3) {
        super.setThrottleNetSpeed(r3);
        if (this.mWinnerConnection != null) goto L11;
        return true;
    L11:
        Reflect.on(this.mWinnerConnection).call("setThrottleNetSpeed", new Class[]{Long.TYPE}, new Object[]{Long.valueOf(r3)});     // Catch: Throwable -> L6
        return true;
    L6:
        th = move-exception;
        th.printStackTrace();
        return false;
    }
}
