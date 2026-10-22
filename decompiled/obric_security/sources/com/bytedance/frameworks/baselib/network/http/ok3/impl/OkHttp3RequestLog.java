package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.frameworks.baselib.network.config.InsecureRequestControlConfig;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.frameworks.baselib.network.http.ok3.IOkHttpAppInfoProvider;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.Ipv6ConnectionManager;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.metadispatch.TTMetaDispatchLog;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchActionInfo;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatcher;
import com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionManager;
import com.bytedance.frameworks.baselib.network.http.util.HttpHost;
import com.bytedance.frameworks.baselib.network.http.util.ProcessUtils;
import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import com.bytedance.ttnet.utils.MultiProcessFileUtils;
import com.obric.securitycenter.nodisturb.ProviderConstants;
import com.ttnet.org.chromium.net.NetError;
import com.ttnet.org.chromium.net.impl.URLDispatch;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import okhttp3.CipherSuite;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.TlsVersion;
import okio.ByteString;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class OkHttp3RequestLog {
    private static final int MAX_ABSDK_VERSION_LENGTH = 5;
    private final AtomicLong mCallEnd;
    private long mCallStart;
    private CipherSuite mCipherSuite;
    private final List<Pair<InetSocketAddress, Integer>> mConnectAttemptsList;
    private long mConnectEnd;
    private long mConnectStart;
    private long mConnectionAcquired;
    private String mContentType;
    private BaseRequestContext mCtx;
    private final List<DispatchActionInfo> mDispatchActionChain;
    private long mDispatchTiming;
    private boolean mDispatched;
    private long mDnsEnd;
    private String mDnsInfoJson;
    private long mDnsStart;
    private String mFinalScheme;
    private Socket mFinalSocket;
    private HandshakeType mHandShakeType;
    private int mHostReplaceMapSize;
    private boolean mHostReplaceMaped;
    private int mHttpCode;
    private boolean mIsFromCache;
    private boolean mIsFromNetwork;
    private LoadState mLoadState;
    private TTMetaDispatchLog mMetaDispatchLog;
    private String mMethod;
    private int mNetError;
    private String mOriginUrl;
    private Protocol mProtocol;
    private Proxy.Type mProxyType;
    private final List<RedirectInfo> mRedirectInfoList;
    private int mRedirectTimes;
    private String mRemoteIp;
    private long mRequestBodyBytes;
    private long mRequestBodyEnd;
    private long mRequestBodyStart;
    private Headers mRequestHeaders;
    private long mRequestHeadersEnd;
    private long mRequestHeadersStart;
    private long mResponseBodyBytes;
    private long mResponseBodyEnd;
    private long mResponseBodyStart;
    private Headers mResponseHeaders;
    private long mResponseHeadersEnd;
    private long mResponseHeadersStart;
    private long mSslEnd;
    private long mSslStart;
    private Status mStatus;
    private TlsVersion mTlsVersion;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.ok3.impl.OkHttp3RequestLog$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$okhttp3$Protocol = null;

        static {
            int[] r0 = new int[Protocol.values().length];
            $SwitchMap$okhttp3$Protocol = r0;
            r0[Protocol.HTTP_1_0.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$okhttp3$Protocol[Protocol.HTTP_1_1.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$okhttp3$Protocol[Protocol.HTTP_2.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$okhttp3$Protocol[Protocol.SPDY_3.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$okhttp3$Protocol[Protocol.QUIC.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    private static long validateAndSetDuration(long r3, long r5) {
        if (r5 != (-1)) goto L5;
    L8:
        return -1;
    L5:
        if (r3 == (-1)) goto L8;
        return r3 - r5;
    }

    public OkHttp3RequestLog() {
        this.mCallStart = -1;
        this.mDnsStart = -1;
        this.mDnsEnd = -1;
        this.mConnectStart = -1;
        this.mConnectEnd = -1;
        this.mSslStart = -1;
        this.mSslEnd = -1;
        this.mRequestHeadersStart = -1;
        this.mRequestHeadersEnd = -1;
        this.mRequestBodyStart = -1;
        this.mRequestBodyEnd = -1;
        this.mResponseHeadersStart = -1;
        this.mResponseHeadersEnd = -1;
        this.mResponseBodyStart = -1;
        this.mResponseBodyEnd = -1;
        this.mCallEnd = new AtomicLong(-1);
        this.mConnectionAcquired = -1;
        this.mDispatchTiming = -1;
        this.mConnectAttemptsList = new ArrayList();
        this.mProxyType = Proxy.Type.DIRECT;
        this.mHandShakeType = HandshakeType.HANDSHAKE_UNKNOWN;
        this.mRequestBodyBytes = 0;
        this.mHttpCode = -1;
        this.mResponseBodyBytes = 0;
        this.mProtocol = null;
        this.mFinalScheme = "";
        this.mIsFromCache = false;
        this.mIsFromNetwork = false;
        this.mRemoteIp = "";
        this.mContentType = "";
        this.mRedirectTimes = 0;
        this.mRedirectInfoList = new ArrayList();
        this.mLoadState = LoadState.IDLE;
        this.mMethod = "";
        this.mNetError = -1;
        this.mStatus = Status.UNKNOWN;
        this.mOriginUrl = "";
        this.mDispatched = false;
        this.mHostReplaceMaped = false;
        this.mDispatchActionChain = new ArrayList();
        this.mHostReplaceMapSize = 0;
        this.mDnsInfoJson = "";
    }

    public void setRequestInfo(BaseHttpRequestInfo r7, Context r8) {
        r7.remoteIp = this.mRemoteIp;
        r7.dnsTime = validateAndSetDuration(this.mDnsEnd, this.mDnsStart);
        r7.connectTime = validateAndSetDuration(this.mSslStart, this.mConnectStart);
        r7.sslTime = validateAndSetDuration(this.mSslEnd, this.mSslStart);
        r7.sendTime = validateAndSetDuration(this.mRequestHeadersEnd, this.mRequestHeadersStart) + validateAndSetDuration(this.mRequestBodyEnd, this.mRequestBodyStart);
        r7.pushTime = -1;
        r7.receiveTime = validateAndSetDuration(this.mResponseHeadersEnd, this.mRequestHeadersEnd);
        if (this.mConnectStart == (-1)) goto L5;
    L7:
        boolean r2 = false;
    L8:
        r7.isSocketReused = r2;
        r7.ttfbMs = -1;
        r7.totalTime = validateAndSetDuration(this.mCallEnd.get(), this.mCallStart);
        r7.sentByteCount = this.mRequestBodyBytes;
        r7.receivedByteCount = this.mResponseBodyBytes;
        r7.responseBodyByteCount = this.mResponseBodyBytes;
        r7.requestLog = constructRequestLog(r8);
        r7.retryAttempts = -1;
        Headers r9 = this.mRequestHeaders;
        if (r9 == null) goto L11;
        r7.requestHeaders = formatJsonHeaders(r9);
        r7.sentByteCount += this.mRequestHeaders.byteCount();
    L11:
        Headers r10 = this.mResponseHeaders;
        if (r10 == null) goto L14;
        r7.responseHeaders = formatJsonHeaders(r10);
        r7.receivedByteCount += this.mResponseHeaders.byteCount();
    L14:
        r7.contentType = this.mContentType;
        r7.nativePostTaskStartTime = -1;
        r7.nativeRequestStartTime = -1;
        r7.nativeWaitContext = -1;
        return;
    L5:
        if (this.mConnectionAcquired == (-1)) goto L7;
        r2 = true;
        goto L8
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

    private String constructRequestLog(Context r20) {
        String r2 = "Cookie";
        JSONObject r8 = new JSONObject();
        JSONObject r9 = new JSONObject();     // Catch: JSONException -> L274
        String r10 = URLDispatcher.inst().getTncAbTest();     // Catch: JSONException -> L274
        ArrayList r11 = new ArrayList();     // Catch: JSONException -> L274
        if (TextUtils.isEmpty(r10) == true) goto L8;
        String[] r12 = r10.split(",");     // Catch: JSONException -> L274
        if (r12 == null) goto L8;
        r11.addAll(Arrays.asList(r12));     // Catch: JSONException -> L274
    L8:
        IOkHttpAppInfoProvider r13 = SsOkHttp3Client.getOkHttpAppInfoProvider();     // Catch: JSONException -> L274
        if (r13 == null) goto L24;
        List<String> r14 = r13.getAbSdkVersion();     // Catch: JSONException -> L274
        if (r14 == null) goto L24;
        if (r14.size() > 5) goto L15;
    L17:
        Iterator<String> r15 = r14.iterator();     // Catch: JSONException -> L274
        int r16 = 0;
    L19:
        if (r15.hasNext() == false) goto L24;
        String r17 = r15.next();     // Catch: JSONException -> L274
        r16 = r16 + 1;     // Catch: JSONException -> L274
        if (r16 > 5) goto L24;
        r11.add(r17);     // Catch: JSONException -> L274
        goto L19
    L15:
        if (Logger.debug() == false) goto L17;
        Logger.d("ok3log", "ab sdk version count must less than 5");     // Catch: JSONException -> L274
    L24:
        JSONArray r18 = new JSONArray();     // Catch: JSONException -> L274
        Iterator r19 = r11.iterator();     // Catch: JSONException -> L274
    L26:
        if (r19.hasNext() == false) goto L30;
        String r110 = (String) r19.next();     // Catch: JSONException -> L274
        if (TextUtils.isEmpty(r110) == true) goto L26;
        r18.put(r110);     // Catch: JSONException -> L274
        goto L26
    L30:
        r9.put(BaseHttpRequestInfo.KEY_HIT, r18);     // Catch: JSONException -> L274
        r8.put(BaseHttpRequestInfo.KEY_ABTEST, r9);     // Catch: JSONException -> L274
        JSONObject r21 = new JSONObject();     // Catch: JSONException -> L274
        r21.put("load_state", this.mLoadState.ordinal());     // Catch: JSONException -> L274
        r21.put("method", this.mMethod);     // Catch: JSONException -> L274
        if (this.mStatus != Status.IO_PENDING) goto L33;
        boolean r111 = true;
    L34:
        r21.put("is_pending", r111);     // Catch: JSONException -> L274
        r21.put("status", this.mStatus);     // Catch: JSONException -> L274
        if (this.mStatus == Status.SUCCESS) goto L39;
        r21.put("net_error", this.mNetError);     // Catch: JSONException -> L274
    L39:
        if (TextUtils.isEmpty(this.mOriginUrl) == true) goto L49;
        Uri r112 = Uri.parse(this.mOriginUrl);     // Catch: JSONException -> L274
        if (r112 == null) goto L49;
        if (TextUtils.isEmpty(r112.getScheme()) == true) goto L49;
        if (TextUtils.isEmpty(r112.getHost()) == true) goto L49;
        if (r112.getPath() == null) goto L49;
        r21.put("origin_url", r112.getScheme() + "://" + r112.getHost() + r112.getPath());     // Catch: JSONException -> L274
    L49:
        r21.put("redirect_times", this.mRedirectTimes);     // Catch: JSONException -> L274
        JSONArray r113 = new JSONArray();     // Catch: JSONException -> L274
        JSONArray r114 = new JSONArray();     // Catch: JSONException -> L274
        Iterator<RedirectInfo> r115 = this.mRedirectInfoList.iterator();     // Catch: JSONException -> L274
    L52:
        if (r115.hasNext() == false) goto L66;
        RedirectInfo r116 = r115.next();     // Catch: JSONException -> L274
        Iterator<RedirectInfo> r117 = r115;
        JSONObject r118 = new JSONObject();     // Catch: JSONException -> L274
        String r119 = r2;
        r118.put(AlogMonitor.ALOG_RESULT_CODE, r116.mCode);     // Catch: JSONException -> L274
        r118.put("method", r116.mMethod);     // Catch: JSONException -> L274
        r118.put("internal", r116.mInternal);     // Catch: JSONException -> L274
        if (r116.mUrl == null) goto L65;
        Uri r3 = Uri.parse(r116.mUrl);     // Catch: JSONException -> L274
        if (r3 == null) goto L65;
        if (TextUtils.isEmpty(r3.getScheme()) == true) goto L65;
        if (TextUtils.isEmpty(r3.getHost()) == true) goto L65;
        String r120 = r3.getScheme() + "://" + r3.getHost();     // Catch: JSONException -> L274
        r114.put(r120);     // Catch: JSONException -> L274
        if (r3.getPath() == null) goto L64;
        r120 = r120 + r3.getPath();     // Catch: JSONException -> L274
    L64:
        r118.put("url", r120);     // Catch: JSONException -> L274
    L65:
        r113.put(r118);     // Catch: JSONException -> L274
        r115 = r117;
        r2 = r119;
        goto L52
    L66:
        String r121 = r2;
        r21.put("redirect_info", r113);     // Catch: JSONException -> L274
        r21.put("redirecting_list", r114);     // Catch: JSONException -> L274
        r21.put("dispatched", this.mDispatched);     // Catch: JSONException -> L274
        r8.put(TraceStatsConsts.STATS_BASE_MODULE, r21);     // Catch: JSONException -> L274
        JSONObject r4 = new JSONObject();     // Catch: JSONException -> L274
        r4.put(AlogMonitor.ALOG_RESULT_CODE, this.mHttpCode);     // Catch: JSONException -> L274
        r4.put("connection_info", transProtocolToEnum(this.mProtocol).mValue);     // Catch: JSONException -> L274
        Headers r7 = this.mRequestHeaders;     // Catch: JSONException -> L274
        if (r7 == null) goto L69;
        long r122 = r7.byteCount();     // Catch: JSONException -> L274
    L70:
        r4.put("sent_bytes", this.mRequestBodyBytes + r122);     // Catch: JSONException -> L274
        Headers r22 = this.mResponseHeaders;     // Catch: JSONException -> L274
        if (r22 == null) goto L73;
        long r123 = r22.byteCount();     // Catch: JSONException -> L274
    L74:
        r4.put("received_bytes", this.mResponseBodyBytes + r123);     // Catch: JSONException -> L274
        r4.put("cached", this.mIsFromCache);     // Catch: JSONException -> L274
        r4.put("network_accessed", this.mIsFromNetwork);     // Catch: JSONException -> L274
        if (this.mProxyType == Proxy.Type.DIRECT) goto L77;
        boolean r124 = true;
    L78:
        r4.put("via_proxy", r124);     // Catch: JSONException -> L274
        Headers r23 = this.mResponseHeaders;     // Catch: JSONException -> L274
        if (r23 == null) goto L93;
        List<String> r24 = r23.values("Set-Cookie");     // Catch: JSONException -> L274
        if (CollectionUtils.isEmpty(r24) == true) goto L83;
        boolean r125 = true;
    L84:
        r4.put("set_cookie", r125);     // Catch: JSONException -> L274
        if (r125 == false) goto L93;
        r4.put("set_cookie_lines", r24.size());     // Catch: JSONException -> L274
        Iterator<String> r25 = r24.iterator();     // Catch: JSONException -> L274
        long r126 = 0;
    L88:
        if (r25.hasNext() == false) goto L92;
        String r127 = r25.next();     // Catch: JSONException -> L274
        if (r127 == null) goto L88;
        r126 = r126 + ((long) r127.length());     // Catch: JSONException -> L274
        goto L88
    L92:
        r4.put("set_cookie_bytes", r126);     // Catch: JSONException -> L274
        goto L93
    L83:
        r125 = false;
    L93:
        r8.put(ApmTrafficStats.TTNET_RESPONSE, r4);     // Catch: JSONException -> L274
        JSONObject r5 = new JSONObject();     // Catch: JSONException -> L274
        if (this.mResponseHeaders == null) goto L117;
        int r26 = 0;
    L98:
        if (r26 >= this.mResponseHeaders.size()) goto L110;
        String r128 = this.mResponseHeaders.name(r26);     // Catch: JSONException -> L274
        String r129 = this.mResponseHeaders.value(r26);     // Catch: JSONException -> L274
        if (TextUtils.isEmpty(r128) == true) goto L109;
        String r130 = r128.toLowerCase();     // Catch: JSONException -> L274
        if (TextUtils.isEmpty(r130) == true) goto L109;
        if (r130.startsWith("x-tt-") == false) goto L109;
        if (TextUtils.isEmpty(r129) == true) goto L109;
        r5.put(r128, r129);     // Catch: JSONException -> L274
    L109:
        r26 = r26 + 1;     // Catch: JSONException -> L274
        goto L98
    L110:
        String r27 = this.mResponseHeaders.get("tt-idc-switch");     // Catch: JSONException -> L274
        if (TextUtils.isEmpty(r27) == true) goto L113;
        r5.put("tt-idc-switch", r27);     // Catch: JSONException -> L274
    L113:
        String r6 = this.mResponseHeaders.get("server-timing");     // Catch: JSONException -> L274
        if (TextUtils.isEmpty(r6) == true) goto L116;
        r5.put("server-timing", r6);     // Catch: JSONException -> L274
    L116:
        r8.put("header", r5);     // Catch: JSONException -> L274
    L118:
        JSONObject r28 = new JSONObject();     // Catch: JSONException -> L274
        r28.put("libcore", "okhttp");     // Catch: JSONException -> L274
        r28.put("core_ver", SsOkHttp3Client.getOkVersion());     // Catch: JSONException -> L274
        r28.put("is_main_process", ProcessUtils.isMainProcessByProcessFlag(r20));     // Catch: JSONException -> L274
        r28.put("ttnet_version", "4.2.228.16-pico");     // Catch: JSONException -> L274
        r28.put(ICronetClient.KEY_RETRY_ATTEMPTS, -1);     // Catch: JSONException -> L274
        BaseRequestContext r29 = this.mCtx;     // Catch: JSONException -> L274
        if (r29 != null) goto L121;
    L123:
        r8.put("other", r28);     // Catch: JSONException -> L274
        JSONObject r30 = new JSONObject();     // Catch: JSONException -> L274
        JSONObject r31 = new JSONObject();     // Catch: JSONException -> L274
        r31.put(MultiProcessFileUtils.KEY_DNS, validateAndSetDuration(this.mDnsEnd, this.mDnsStart));     // Catch: JSONException -> L274
        r31.put("tcp", validateAndSetDuration(this.mSslStart, this.mConnectStart));     // Catch: JSONException -> L274
        r31.put("ssl", validateAndSetDuration(this.mSslEnd, this.mSslStart));     // Catch: JSONException -> L274
        r31.put(CommonKey.KEY_SEND, validateAndSetDuration(this.mRequestHeadersEnd, this.mRequestHeadersStart) + validateAndSetDuration(this.mRequestBodyEnd, this.mRequestBodyStart));     // Catch: JSONException -> L274
        long r32 = validateAndSetDuration(this.mResponseHeadersEnd, this.mRequestHeadersEnd);     // Catch: JSONException -> L274
        r31.put(ICronetClient.KEY_TTFB, r32);     // Catch: JSONException -> L274
        r31.put("header_recv", validateAndSetDuration(this.mResponseHeadersEnd, this.mResponseHeadersStart));     // Catch: JSONException -> L274
        r31.put("body_recv", validateAndSetDuration(this.mResponseBodyEnd, this.mResponseBodyStart));     // Catch: JSONException -> L274
        r31.put("dispatch", this.mDispatchTiming);     // Catch: JSONException -> L274
        getServerTimingInfo(r6, r31, r32);     // Catch: JSONException -> L274
        TTMetaDispatchLog r33 = this.mMetaDispatchLog;     // Catch: JSONException -> L274
        if (r33 != null) goto L127;
    L129:
        r30.put("detailed_duration", r31);     // Catch: JSONException -> L274
        JSONObject r34 = new JSONObject();     // Catch: JSONException -> L274
        r34.put("start_time", this.mCallStart);     // Catch: JSONException -> L274
        r34.put("duration", validateAndSetDuration(this.mCallEnd.get(), this.mCallStart));     // Catch: JSONException -> L274
        r34.put("request_sent_time", this.mRequestHeadersStart);     // Catch: JSONException -> L274
        r34.put("response_recv_time", this.mResponseHeadersStart);     // Catch: JSONException -> L274
        r30.put("request", r34);     // Catch: JSONException -> L274
        r8.put("timing", r30);     // Catch: JSONException -> L274
        JSONObject r35 = new JSONObject();     // Catch: JSONException -> L274
        Socket r36 = this.mFinalSocket;     // Catch: JSONException -> L274
        if (r36 == null) goto L148;
        InetAddress r37 = r36.getInetAddress();     // Catch: JSONException -> L274
        if (r37 == null) goto L148;
        AddressFamily r38 = AddressFamily.ADDRESS_FAMILY_UNSPECIFIED;     // Catch: JSONException -> L274
        if ((r37 instanceof Inet4Address) == false) goto L137;
        r38 = AddressFamily.ADDRESS_FAMILY_IPV4;     // Catch: JSONException -> L274
    L139:
        r35.put("address_family", r38.ordinal());     // Catch: JSONException -> L274
        if (this.mConnectStart == (-1)) goto L142;
    L144:
        boolean r39 = false;
    L145:
        r35.put(ICronetClient.KEY_SOCKET_REUSED, r39);     // Catch: JSONException -> L274
        if (r37.getHostAddress() == null) goto L148;
        r35.put("remote", r37.getHostAddress());     // Catch: JSONException -> L274
        goto L148
    L142:
        if (this.mConnectionAcquired == (-1)) goto L144;
        r39 = true;
        goto L145
    L137:
        if ((r37 instanceof Inet6Address) == false) goto L139;
        r38 = AddressFamily.ADDRESS_FAMILY_IPV6;     // Catch: JSONException -> L274
    L148:
        JSONArray r40 = new JSONArray();     // Catch: JSONException -> L274
        Iterator<Pair<InetSocketAddress, Integer>> r41 = this.mConnectAttemptsList.iterator();     // Catch: JSONException -> L274
    L150:
        if (r41.hasNext() == false) goto L152;
        Pair<InetSocketAddress, Integer> r42 = r41.next();     // Catch: JSONException -> L274
        JSONObject r131 = new JSONObject();     // Catch: JSONException -> L274
        r131.put(ProviderConstants.Sms.ADDRESS, ((InetSocketAddress) r42.first).toString().substring(1));     // Catch: JSONException -> L274
        r131.put("result", r42.second);     // Catch: JSONException -> L274
        r40.put(r131);     // Catch: JSONException -> L274
        goto L150
    L152:
        r35.put("connection_attempts", r40);     // Catch: JSONException -> L274
        r8.put("socket", r35);     // Catch: JSONException -> L274
        JSONObject r43 = new JSONObject();     // Catch: JSONException -> L274
        r43.put("handshake_type", this.mHandShakeType.ordinal());     // Catch: JSONException -> L274
        r43.put("cipher_suite", this.mCipherSuite);     // Catch: JSONException -> L274
        r43.put("ssl_version", this.mTlsVersion);     // Catch: JSONException -> L274
        r8.put("ssl", r43);     // Catch: JSONException -> L274
        JSONObject r44 = new JSONObject();     // Catch: JSONException -> L274
        JSONArray r45 = new JSONArray();     // Catch: JSONException -> L274
        if (this.mHostReplaceMaped == false) goto L157;
        boolean r46 = true;
        r44.put("host_replace_map", 1);     // Catch: JSONException -> L274
        r44.put("host_replace_map_size", this.mHostReplaceMapSize);     // Catch: JSONException -> L274
        boolean r47 = false;
    L179:
        r44.put(DBHelper.BATTERY_COL_SOURCE, URLDispatcher.inst().getTncUpdateSource());     // Catch: JSONException -> L274
        r44.put("update_time", URLDispatcher.inst().getTncUpdateTime());     // Catch: JSONException -> L274
        r44.put(URLDispatch.KEY_EPOCH, URLDispatcher.inst().getEpoch());     // Catch: JSONException -> L274
        r8.put("url_dispatch", r44);     // Catch: JSONException -> L274
        if (TextUtils.isEmpty(URLDispatcher.inst().getTncEtag()) == true) goto L183;
        r8.put("tt_tnc_etag", URLDispatcher.inst().getTncEtag());     // Catch: JSONException -> L274
    L183:
        if (this.mMetaDispatchLog == null) goto L208;
        JSONObject r48 = new JSONObject();     // Catch: JSONException -> L274
        if (this.mMetaDispatchLog.headerAdd == null) goto L190;
        if (this.mMetaDispatchLog.headerAdd.isEmpty() == true) goto L190;
        r48.put("header_add", this.mMetaDispatchLog.headerAdd);     // Catch: JSONException -> L274
    L190:
        if (this.mMetaDispatchLog.headerRm == null) goto L195;
        if (this.mMetaDispatchLog.headerRm.isEmpty() == true) goto L195;
        r48.put("header_rm", this.mMetaDispatchLog.headerRm);     // Catch: JSONException -> L274
    L195:
        if (this.mMetaDispatchLog.queryAdd == null) goto L200;
        if (this.mMetaDispatchLog.queryAdd.isEmpty() == true) goto L200;
        r48.put("query_add", this.mMetaDispatchLog.queryAdd);     // Catch: JSONException -> L274
    L200:
        if (this.mMetaDispatchLog.queryRm == null) goto L205;
        if (this.mMetaDispatchLog.queryRm.isEmpty() == true) goto L205;
        r48.put("query_rm", this.mMetaDispatchLog.queryRm);     // Catch: JSONException -> L274
    L205:
        if (r48.length() <= 0) goto L208;
        r8.put("meta_dp", r48);     // Catch: JSONException -> L274
    L208:
        if (TextUtils.isEmpty(this.mDnsInfoJson) == false) goto L281;
    L210:
        JSONObject r49 = new JSONObject();     // Catch: JSONException -> L274
        BaseRequestContext r50 = this.mCtx;     // Catch: JSONException -> L274
        if (r50 != null) goto L213;
        long r51 = 0;
    L225:
        r8.put("socket_timeout_param", r49);     // Catch: JSONException -> L274
        JSONObject r52 = new JSONObject();     // Catch: JSONException -> L274
        r52.put("ipv4_reachable", NetworkUtils.isNetworkAvailable(r20));     // Catch: JSONException -> L274
        r52.put("ipv6_reachable", Ipv6ConnectionManager.getIpv6GloballyReachable().get());     // Catch: JSONException -> L274
        r8.put("ifconfig", r52);     // Catch: JSONException -> L274
        if (SsOkHttp3Client.getOk3TncBridge() == null) goto L231;
        Object r53 = SsOkHttp3Client.getOk3TncBridge().getTNCInfo();     // Catch: JSONException -> L274
        if (r53 == null) goto L231;
        r8.put("tnc", r53);     // Catch: JSONException -> L274
    L231:
        if (StoreRegionManager.inst().getStoreIdcInfo() == null) goto L234;
        r8.put(CronetDataStorageAccess.STORE_IDC, StoreRegionManager.inst().getStoreIdcInfo());     // Catch: JSONException -> L274
    L234:
        if (this.mRequestHeaders == null) goto L277;
        JSONObject r54 = new JSONObject();     // Catch: JSONException -> L274
        List<String> r55 = this.mRequestHeaders.values(r121);     // Catch: JSONException -> L274
        if (CollectionUtils.isEmpty(r55) == true) goto L238;
        boolean r132 = r46;
    L239:
        r54.put(r121, r132);     // Catch: JSONException -> L274
        if (r132 == false) goto L248;
        Iterator<String> r56 = r55.iterator();     // Catch: JSONException -> L274
    L243:
        if (r56.hasNext() == false) goto L247;
        String r57 = r56.next();     // Catch: JSONException -> L274
        if (r57 == null) goto L243;
        r51 = r51 + ((long) r57.length());     // Catch: JSONException -> L274
        goto L243
    L247:
        r54.put("add_cookie_bytes", r51);     // Catch: JSONException -> L274
    L248:
        String r58 = this.mRequestHeaders.get("x-tt-token");     // Catch: JSONException -> L274
        if (r58 == null) goto L254;
        if (r58.isEmpty() == true) goto L254;
        r54.put("token_md5", ByteString.encodeUtf8(r58).md5().hex());     // Catch: JSONException -> L274
    L254:
        if (HttpHost.DEFAULT_SCHEME_NAME.equalsIgnoreCase(this.mFinalScheme) == false) goto L272;
        if (r55 != null) goto L257;
    L265:
        Set<String> r1 = InsecureRequestControlConfig.getInsecureHeaders(this.mRequestHeaders);     // Catch: JSONException -> L274
        if (r1 == null) goto L272;
        JSONArray r59 = new JSONArray();     // Catch: JSONException -> L274
        Iterator<String> r60 = r1.iterator();     // Catch: JSONException -> L274
    L269:
        if (r60.hasNext() == false) goto L271;
        r59.put(r60.next());     // Catch: JSONException -> L274
        goto L269
    L271:
        r54.put("insecure_headers", r59);     // Catch: JSONException -> L274
        goto L272
    L257:
        if (r55.isEmpty() == true) goto L265;
        Set<String> r61 = InsecureRequestControlConfig.getInSecureCookies(r55);     // Catch: JSONException -> L274
        if (r61 == null) goto L265;
        JSONArray r62 = new JSONArray();     // Catch: JSONException -> L274
        Iterator<String> r63 = r61.iterator();     // Catch: JSONException -> L274
    L262:
        if (r63.hasNext() == false) goto L264;
        r62.put(r63.next());     // Catch: JSONException -> L274
        goto L262
    L264:
        r54.put("insecure_cookies", r62);     // Catch: JSONException -> L274
    L272:
        r8.put("session", r54);     // Catch: JSONException -> L274
        goto L277
    L238:
        r132 = r47;
    L277:
        return r8.toString();
    L213:
        if (r50.protect_timeout <= 0) goto L216;
        r49.put("protect", this.mCtx.protect_timeout);     // Catch: JSONException -> L274
    L216:
        if (this.mCtx.socket_connect_timeout <= 0) goto L219;
        r49.put("connect", this.mCtx.socket_connect_timeout);     // Catch: JSONException -> L274
    L219:
        if (this.mCtx.timeout_read <= 0) goto L221;
        r49.put(ProviderConstants.Sms.READ, this.mCtx.timeout_read);     // Catch: JSONException -> L274
    L221:
        r51 = 0;
        if (this.mCtx.timeout_write <= 0) goto L225;
        r49.put("write", this.mCtx.timeout_write);     // Catch: JSONException -> L274
        goto L225
    L281:
        r8.put(MultiProcessFileUtils.KEY_DNS, new JSONObject(this.mDnsInfoJson));     // Catch: JSONException -> L278
        goto L210
    L157:
        r46 = true;
        List<DispatchActionInfo> r64 = this.mDispatchActionChain;     // Catch: JSONException -> L274
        if (r64 == null) goto L178;
        Iterator<DispatchActionInfo> r65 = r64.iterator();     // Catch: JSONException -> L274
    L161:
        if (r65.hasNext() == false) goto L178;
        DispatchActionInfo r133 = r65.next();     // Catch: JSONException -> L274
        JSONObject r134 = new JSONObject();     // Catch: JSONException -> L274
        if (r133.mActionHit == false) goto L161;
        r134.put("priority", r133.mPriority);     // Catch: JSONException -> L274
        r134.put("type", r133.mStrategyType);     // Catch: JSONException -> L274
        r134.put("action_hit", r133.mActionHit);     // Catch: JSONException -> L274
        if (TextUtils.isEmpty(r133.mDispatchedUrl) == true) goto L170;
        Uri r135 = Uri.parse(r133.mDispatchedUrl);     // Catch: JSONException -> L274
        if (r135.getHost() == null) goto L171;
        r134.put("replace_host", r135.getHost());     // Catch: JSONException -> L274
    L171:
        r134.put("feedback", r133.mNeedFeedBack);     // Catch: JSONException -> L274
        if (r133.mRuleid <= 0) goto L175;
        r134.put("rule_id", r133.mRuleid);     // Catch: JSONException -> L274
    L175:
        if (TextUtils.isEmpty(r133.mServiceName) == true) goto L177;
        r134.put("service_name", r133.mServiceName);     // Catch: JSONException -> L274
    L177:
        r45.put(r134);     // Catch: JSONException -> L274
        goto L161
    L170:
        r134.put("replace_host", "");     // Catch: JSONException -> L274
    L178:
        r44.put("action_info", r45);     // Catch: JSONException -> L274
        r44.put("empty_action", URLDispatcher.inst().isDispatchActionsEmpty());     // Catch: JSONException -> L274
        r47 = false;
        r44.put("host_replace_map", 0);     // Catch: JSONException -> L274
        goto L179
    L127:
        if (r33.dispatchCostMs < 0) goto L129;
        r31.put("meta_dp", this.mMetaDispatchLog.dispatchCostMs);     // Catch: JSONException -> L274
        goto L129
    L121:
        if (r29.okHttpRequestClientBuilderHook == null) goto L123;
        r28.put("hook", 1);     // Catch: JSONException -> L274
        goto L123
    L117:
        r6 = "";
        goto L118
    L77:
        r124 = false;
        goto L78
    L73:
        r123 = 0;
        goto L74
    L69:
        r122 = 0;
        goto L70
    L33:
        r111 = false;
    L274:
        e = move-exception;
        e.printStackTrace();
        goto L277
    }

    private void getServerTimingInfo(String r12, JSONObject r13, long r14) throws JSONException {
        HashMap r11 = new HashMap();
        ServerTimingInfo r0 = new ServerTimingInfo();
        if (TextUtils.isEmpty(r12) == true) goto L18;
        String[] r15 = r12.split(",");
        if (r15 == null) goto L18;
        int r1 = r15.length;
        int r5 = 0;
    L7:
        if (r5 >= r1) goto L18;
        String[] r6 = r15[r5].split(";");
        if (r6 == null) goto L17;
        if (r6.length != 2) goto L17;
        if (TextUtils.isEmpty(r6[0]) == true) goto L17;
        if (TextUtils.isEmpty(r6[1]) == true) goto L17;
        r11.put(r6[0], r6[1]);
    L17:
        r5 = r5 + 1;
    L18:
        Iterator r16 = r11.entrySet().iterator();
    L20:
        if (r16.hasNext() == false) goto L42;
        Map.Entry r17 = (Map.Entry) r16.next();
        String r9 = ((String) r17.getKey()).trim();
        String r18 = ((String) r17.getValue()).trim();
        if (r9.equalsIgnoreCase("cdn-cache") == true) goto L23;
        if (r9.equalsIgnoreCase("edge") == true) goto L31;
        if (r9.equalsIgnoreCase("origin") == true) goto L34;
        if (r9.equalsIgnoreCase("inner") == true) goto L37;
        if (TextUtils.isEmpty(r9) == true) goto L20;
        r13.put(r9, validateAndGetServerTiming(r18));
        goto L20
    L37:
        r0.mInner = validateAndGetServerTiming(r18);
        goto L20
    L34:
        r0.mOrigin = validateAndGetServerTiming(r18);
        goto L20
    L31:
        r0.mEdge = validateAndGetServerTiming(r18);
        goto L20
    L23:
        r0.mPassedCdn = true;
        String[] r19 = r18.split("=");
        if (r19.length != 2) goto L28;
        if (r19[1].equalsIgnoreCase(BaseHttpRequestInfo.KEY_HIT) == false) goto L28;
        r0.mCdnHitCache = true;
    L28:
        r0.mCdnHitCache = false;
        goto L20
    L42:
        if (r0.mPassedCdn == false) goto L52;
        if (r0.mCdnHitCache == false) goto L52;
        r13.put("edge", r0.mEdge);
        r13.put("cdn-cache", BaseHttpRequestInfo.KEY_HIT);
        if (r14 != (-1)) goto L48;
    L50:
        r13.put("rtt", r0.mRtt);
        return;
    L48:
        if (r14 <= r0.mEdge) goto L50;
        r0.mRtt = r14 - r0.mEdge;
    L52:
        if (r0.mPassedCdn == false) goto L63;
        r13.put("edge", r0.mEdge);
        r13.put("cdn-cache", "miss");
        if (r0.mOrigin <= r0.mInner) goto L56;
        r13.put("origin", r0.mOrigin - r0.mInner);
    L57:
        r13.put("inner", r0.mInner);
        if (r14 != (-1)) goto L60;
    L62:
        r13.put("rtt", r0.mRtt);
        return;
    L60:
        if (r14 <= (r0.mOrigin + r0.mEdge)) goto L62;
        r0.mRtt = (r14 - r0.mOrigin) - r0.mEdge;
        goto L62
    L56:
        r13.put("origin", -1);
        goto L57
    L63:
        r13.put("inner", r0.mInner);
        if (r14 != (-1)) goto L66;
    L68:
        r13.put("rtt", r0.mRtt);
        return;
    L66:
        if (r14 <= r0.mInner) goto L68;
        r0.mRtt = r14 - r0.mInner;
        goto L68
    }

    public void setRequestTimeout(BaseRequestContext r1) {
        this.mCtx = r1;
    }

    private static long validateAndGetServerTiming(String r6) {
        String[] r7 = r6.split("=");
        if (r7.length == 2) goto L12;
        return -1;
    L12:
        long r0 = Long.parseLong(r7[1]);     // Catch: NumberFormatException -> L11
        if (r0 >= 0) goto L10;
        return -1;
    L10:
        return r0;
    L16:
        return -1;
    }

    private static ConnectionInfo transProtocolToEnum(Protocol r1) {
        if (r1 == null) goto L4;
        int r2 = AnonymousClass1.$SwitchMap$okhttp3$Protocol[r1.ordinal()];
        if (r2 == 1) goto L26;
        if (r2 == 2) goto L24;
        if (r2 == 3) goto L22;
        if (r2 == 4) goto L20;
        if (r2 == 5) goto L18;
        return ConnectionInfo.CONNECTION_INFO_UNKNOWN;
    L18:
        return ConnectionInfo.CONNECTION_INFO_QUIC_UNKNOWN_VERSION;
    L20:
        return ConnectionInfo.CONNECTION_INFO_DEPRECATED_SPDY3;
    L22:
        return ConnectionInfo.CONNECTION_INFO_HTTP2;
    L24:
        return ConnectionInfo.CONNECTION_INFO_HTTP1_1;
    L26:
        return ConnectionInfo.CONNECTION_INFO_HTTP1_0;
    L4:
        return ConnectionInfo.CONNECTION_INFO_UNKNOWN;
    }

    public void callStart() {
        this.mCallStart = System.currentTimeMillis();
        this.mStatus = Status.IO_PENDING;
    }

    public void dnsStart() {
        this.mDnsStart = System.currentTimeMillis();
        this.mLoadState = LoadState.RESOLVING_HOST;
    }

    public void dnsEnd() {
        this.mDnsEnd = System.currentTimeMillis();
    }

    public void dnsEnd(String r3) {
        this.mDnsEnd = System.currentTimeMillis();
        this.mDnsInfoJson = r3;
    }

    public void connectStart() {
        this.mConnectStart = System.currentTimeMillis();
        this.mLoadState = LoadState.CONNECTING;
    }

    public void secureConnectStart() {
        this.mSslStart = System.currentTimeMillis();
        this.mLoadState = LoadState.SSL_HANDSHAKE;
    }

    public void secureConnectEnd() {
        this.mSslEnd = System.currentTimeMillis();
    }

    public void connectEnd(Proxy r3) {
        this.mConnectEnd = System.currentTimeMillis();
        if (r3 == null) goto L6;
        this.mProxyType = r3.type();
        return;
    }

    public void connectFailed(InetSocketAddress r5, IOException r6, String r7) {
        this.mConnectEnd = System.currentTimeMillis();
        if (r5 == null) goto L8;
        if (this.mCallEnd.get() != (-1)) goto L8;
        this.mConnectAttemptsList.add(new Pair(r5, Integer.valueOf(convertExceptionToErrorCode(r6))));
    L8:
        if (TextUtils.isEmpty(this.mDnsInfoJson) == true) goto L10;
        return;
    L10:
        if (TextUtils.isEmpty(r7) == true) goto L14;
        this.mDnsInfoJson = r7;
        return;
    }

    public void connectionAcquired(Connection r5) {
        if (r5 != null) goto L4;
    L13:
        this.mConnectionAcquired = System.currentTimeMillis();
        return;
    L4:
        if (this.mCallEnd.get() != (-1)) goto L13;
        if (r5.socket() != null) goto L8;
    L12:
        this.mFinalSocket = r5.socket();
        goto L13
    L8:
        if (r5.socket().getInetAddress() == null) goto L12;
        if (r5.socket().getInetAddress().getHostAddress() == null) goto L12;
        this.mRemoteIp = r5.socket().getInetAddress().getHostAddress();
        goto L12
    }

    public void requestHeadersStart() {
        this.mLoadState = LoadState.SENDING_REQUEST;
        this.mRequestHeadersStart = System.currentTimeMillis();
    }

    public void requestHeadersEnd(Request r5) {
        this.mRequestHeadersEnd = System.currentTimeMillis();
        if (r5 != null) goto L5;
    L9:
        this.mLoadState = LoadState.WAITING_FOR_RESPONSE;
        return;
    L5:
        if (this.mCallEnd.get() != (-1)) goto L9;
        this.mRequestHeaders = r5.headers();
        if (r5.url() == null) goto L9;
        this.mFinalScheme = r5.url().scheme();
        goto L9
    }

    public void requestBodyStart() {
        this.mRequestBodyStart = System.currentTimeMillis();
    }

    public void requestBodyEnd(long r3) {
        this.mRequestBodyEnd = System.currentTimeMillis();
        this.mRequestBodyBytes = r3;
    }

    public void responseHeadersStart() {
        this.mResponseHeadersStart = System.currentTimeMillis();
    }

    public void responseHeadersEnd(Response r5) {
        this.mResponseHeadersEnd = System.currentTimeMillis();
        if (this.mSslEnd == (-1)) goto L5;
        this.mHandShakeType = HandshakeType.HANDSHAKE_FULL;
    L6:
        if (r5 != null) goto L8;
        return;
    L8:
        if (this.mCallEnd.get() != (-1)) goto L27;
        this.mHttpCode = r5.code();
        this.mProtocol = r5.protocol();
        if (r5.handshake() == null) goto L14;
        this.mTlsVersion = r5.handshake().tlsVersion();
        this.mCipherSuite = r5.handshake().cipherSuite();
    L14:
        if (r5.isRedirect() == false) goto L20;
        this.mRedirectTimes++;
        RedirectInfo r0 = new RedirectInfo();
        r0.mCode = r5.code();
        r0.mMethod = r5.request().method();
        String r1 = r5.header(BatteryTypeInf.BATTERY_LOC_API);
        if (TextUtils.isEmpty(r1) == true) goto L18;
        r0.mUrl = r1;
    L18:
        this.mRedirectInfoList.add(r0);
    L20:
        if (r5.isSuccessful() == false) goto L24;
        String r2 = r5.header("content-type");
        if (TextUtils.isEmpty(r2) == true) goto L24;
        this.mContentType = r2;
    L24:
        this.mResponseHeaders = r5.headers();
        return;
    L27:
        return;
    L5:
        this.mHandShakeType = HandshakeType.HANDSHAKE_RESUME;
        goto L6
    }

    public void responseBodyStart() {
        this.mLoadState = LoadState.READING_RESPONSE;
        this.mResponseBodyStart = System.currentTimeMillis();
    }

    public void responseBodyEnd(long r3) {
        this.mResponseBodyEnd = System.currentTimeMillis();
        this.mResponseBodyBytes = r3;
    }

    public void callFailed(IOException r4) {
        this.mCallEnd.set(System.currentTimeMillis());
        this.mLoadState = LoadState.IDLE;
        if (r4 != null) goto L5;
    L9:
        this.mStatus = Status.FAILED;
    L10:
        this.mNetError = convertExceptionToErrorCode(r4);
        return;
    L5:
        if (TextUtils.isEmpty(r4.getMessage()) == true) goto L9;
        if (r4.getMessage().contains("Canceled") == false) goto L9;
        this.mStatus = Status.CANCELED;
        goto L10
    }

    public void callEnd() {
        this.mCallEnd.set(System.currentTimeMillis());
        this.mLoadState = LoadState.IDLE;
        this.mStatus = Status.SUCCESS;
    }

    public void setResponseSource(Response r4) {
        boolean r1 = true;
        if (r4.cacheResponse() == null) goto L5;
        boolean r0 = true;
    L6:
        this.mIsFromCache = r0;
        if (r4.networkResponse() != null) goto L10;
        r1 = false;
    L10:
        this.mIsFromNetwork = r1;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void recordDispatchLog(String r3, String r4, long r5, boolean r7, List<DispatchActionInfo> r8) {
        RedirectInfo r0 = new RedirectInfo();
        r0.mCode = 307;
        r0.mInternal = true;
        r0.mMethod = r3;
        r0.mUrl = r4;
        this.mRedirectInfoList.add(r0);
        this.mRedirectTimes++;
        this.mDispatchTiming = r5;
        this.mDispatched = true;
        if (r7 == false) goto L5;
        this.mHostReplaceMaped = true;
        this.mHostReplaceMapSize = URLDispatcher.inst().getHostReplaceMap().size();
        return;
    L5:
        this.mDispatchActionChain.addAll(r8);
        this.mHostReplaceMaped = false;
    }

    public void recordMetaDispatchLog(TTMetaDispatchLog r1) {
        this.mMetaDispatchLog = r1;
    }

    public void setNetError(int r1) {
        this.mNetError = r1;
    }

    public void setOriginUrl(String r1, String r2) {
        this.mOriginUrl = r1;
        this.mMethod = r2;
    }

    public boolean isRequestFinished() {
        if (this.mCallEnd.get() == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isRequestTimeout(IOException r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if ("Canceled#Reason=-192".equals(r4.getMessage()) == false) goto L9;
        return true;
    L9:
        if ((r4 instanceof InterruptedIOException) == false) goto L17;
        Throwable r5 = r4.getCause();
        if (r5 == null) goto L17;
        if (TextUtils.isEmpty(r5.getMessage()) == true) goto L17;
        if ("Canceled#Reason=-192".equals(r5.getMessage()) == false) goto L17;
        return true;
    L17:
        return false;
    }

    public static int convertExceptionToErrorCode(IOException r2) {
        if ((r2 instanceof SSLHandshakeException) == false) goto L6;
        return NetError.ERR_SSL_HANDSHAKE_NOT_COMPLETED;
    L6:
        if ((r2 instanceof SSLKeyException) == false) goto L9;
        return NetError.ERR_SSL_BAD_PEER_PUBLIC_KEY;
    L9:
        if ((r2 instanceof SSLProtocolException) == false) goto L12;
        return NetError.ERR_SSL_PROTOCOL_ERROR;
    L12:
        if ((r2 instanceof SSLPeerUnverifiedException) == false) goto L15;
        return NetError.ERR_SSL_DECRYPT_ERROR_ALERT;
    L15:
        if ((r2 instanceof UnknownHostException) == false) goto L18;
        return NetError.ERR_NAME_NOT_RESOLVED;
    L18:
        if ((r2 instanceof ConnectException) == false) goto L21;
        return convertConnectException(r2, -104);
    L21:
        if ((r2 instanceof PortUnreachableException) == false) goto L24;
        return NetError.ERR_ADDRESS_INVALID;
    L24:
        if ((r2 instanceof NoRouteToHostException) == false) goto L27;
        return NetError.ERR_ADDRESS_UNREACHABLE;
    L27:
        if ((r2 instanceof BindException) == false) goto L30;
        return NetError.ERR_ADDRESS_IN_USE;
    L30:
        if ((r2 instanceof SocketException) == false) goto L33;
        return convertConnectException(r2, -15);
    L33:
        if ((r2 instanceof MalformedURLException) == false) goto L36;
        return -300;
    L36:
        if ((r2 instanceof SocketTimeoutException) == false) goto L39;
        return NetError.ERR_CONNECTION_TIMED_OUT;
    L39:
        if ((r2 instanceof ProtocolException) == false) goto L42;
        return -901;
    L42:
        if ((r2 instanceof HttpRetryException) == false) goto L50;
        String r3 = r2.getMessage();
        if (TextUtils.isEmpty(r3) == true) goto L68;
        if (r3.contains("Too many follow-up requests") == false) goto L68;
        return NetError.ERR_TOO_MANY_REDIRECTS;
    L68:
        return NetError.ERR_TTNET_UNSUPPORTED_REDIRECT;
    L50:
        if ((r2 instanceof UnknownServiceException) == false) goto L52;
        return -902;
    L52:
        return -1;
    }

    private static int convertConnectException(IOException r2, int r3) {
        if (r2 != null) goto L21;
        return r3;
    L21:
        int r0 = convertConnectionExceptionInternal(r2.getMessage(), r3);     // Catch: Throwable -> L18
        if (r0 == r3) goto L19;
        return r0;
    L19:
        Throwable r4 = r2.getCause();     // Catch: Throwable -> L15
        if (r4 != null) goto L10;
        return r0;
    L10:
        String r5 = r4.getMessage();     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r5) == false) goto L13;
        return r0;
    L13:
        return convertConnectionExceptionInternal(r5, r3);
    L15:
        r3 = r0;
    L17:
        return r3;
    }

    private static int convertConnectionExceptionInternal(String r1, int r2) {
        if (TextUtils.isEmpty(r1) == false) goto L6;
        return r2;
    L6:
        if (r1.contains("ECONNRESET") == false) goto L8;
    L39:
        return -101;
    L8:
        if (r1.contains("Connection reset") == true) goto L39;
        if (r1.contains("reset by peer") == true) goto L39;
        if (r1.contains("ECONNREFUSED") == false) goto L16;
        return -102;
    L16:
        if (r1.contains("CONNECTION_ABORTED") == false) goto L18;
    L38:
        return -103;
    L18:
        if (r1.contains("connection abort") == true) goto L38;
        if (r1.contains("ENETDOWN") == false) goto L23;
    L37:
        return NetError.ERR_INTERNET_DISCONNECTED;
    L23:
        if (r1.contains("Network is unreachable") == true) goto L37;
        if (r1.contains("EHOSTUNREACH") == false) goto L28;
    L36:
        return NetError.ERR_ADDRESS_UNREACHABLE;
    L28:
        if (r1.contains("ENETUNREACH") == true) goto L36;
        if (r1.contains("EADDRNOTAVAIL") == false) goto L34;
        return NetError.ERR_ADDRESS_INVALID;
    L34:
        if (r1.contains("EADDRINUSE") == false) goto L43;
        return NetError.ERR_ADDRESS_IN_USE;
    L43:
        return r2;
    }
}
