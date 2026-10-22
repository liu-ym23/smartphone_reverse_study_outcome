package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import android.content.Context;
import android.icu.text.PluralRules;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.bdinstall.BuildConfig;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.frameworks.baselib.network.config.InsecureRequestControlConfig;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.frameworks.baselib.network.http.ok3.IOkHttpAppInfoProvider;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.Ipv6ConnectionManager;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchActionInfo;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatcher;
import com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionManager;
import com.bytedance.frameworks.baselib.network.http.util.ProcessUtils;
import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import com.bytedance.ttnet.utils.MultiProcessFileUtils;
import com.google.common.net.HttpHeaders;
import com.obric.capabilitykit.common.Ext;
import com.qti.snapdragon.sdk.display.ColorManager;
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

/* JADX INFO: loaded from: classes3.dex */
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
        r7.requestHeaders = r9.toString();
        r7.sentByteCount += this.mRequestHeaders.byteCount();
    L11:
        Headers r10 = this.mResponseHeaders;
        if (r10 == null) goto L14;
        r7.responseHeaders = r10.toString();
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

    private String constructRequestLog(Context r19) {
        String r2 = "Cookie";
        JSONObject r8 = new JSONObject();
        JSONObject r9 = new JSONObject();     // Catch: JSONException -> L243
        String r10 = URLDispatcher.inst().getTncAbTest();     // Catch: JSONException -> L243
        ArrayList r11 = new ArrayList();     // Catch: JSONException -> L243
        if (TextUtils.isEmpty(r10) == true) goto L8;
        String[] r12 = r10.split(",");     // Catch: JSONException -> L243
        if (r12 == null) goto L8;
        r11.addAll(Arrays.asList(r12));     // Catch: JSONException -> L243
    L8:
        IOkHttpAppInfoProvider r13 = SsOkHttp3Client.getOkHttpAppInfoProvider();     // Catch: JSONException -> L243
        if (r13 == null) goto L24;
        List<String> r14 = r13.getAbSdkVersion();     // Catch: JSONException -> L243
        if (r14 == null) goto L24;
        if (r14.size() > 5) goto L15;
    L17:
        Iterator<String> r15 = r14.iterator();     // Catch: JSONException -> L243
        int r16 = 0;
    L19:
        if (r15.hasNext() == false) goto L24;
        String r17 = r15.next();     // Catch: JSONException -> L243
        r16 = r16 + 1;     // Catch: JSONException -> L243
        if (r16 > 5) goto L24;
        r11.add(r17);     // Catch: JSONException -> L243
        goto L19
    L15:
        if (Logger.debug() == false) goto L17;
        Logger.d("ok3log", "ab sdk version count must less than 5");     // Catch: JSONException -> L243
    L24:
        JSONArray r18 = new JSONArray();     // Catch: JSONException -> L243
        Iterator r110 = r11.iterator();     // Catch: JSONException -> L243
    L26:
        if (r110.hasNext() == false) goto L30;
        String r111 = (String) r110.next();     // Catch: JSONException -> L243
        if (TextUtils.isEmpty(r111) == true) goto L26;
        r18.put(r111);     // Catch: JSONException -> L243
        goto L26
    L30:
        r9.put(BaseHttpRequestInfo.KEY_HIT, r18);     // Catch: JSONException -> L243
        r8.put(BaseHttpRequestInfo.KEY_ABTEST, r9);     // Catch: JSONException -> L243
        JSONObject r20 = new JSONObject();     // Catch: JSONException -> L243
        r20.put("load_state", this.mLoadState.ordinal());     // Catch: JSONException -> L243
        r20.put("method", this.mMethod);     // Catch: JSONException -> L243
        if (this.mStatus != Status.IO_PENDING) goto L33;
        boolean r112 = true;
    L34:
        r20.put("is_pending", r112);     // Catch: JSONException -> L243
        r20.put("status", this.mStatus);     // Catch: JSONException -> L243
        if (this.mStatus == Status.SUCCESS) goto L39;
        r20.put("net_error", this.mNetError);     // Catch: JSONException -> L243
    L39:
        if (TextUtils.isEmpty(this.mOriginUrl) == true) goto L49;
        Uri r113 = Uri.parse(this.mOriginUrl);     // Catch: JSONException -> L243
        if (r113 == null) goto L49;
        if (TextUtils.isEmpty(r113.getScheme()) == true) goto L49;
        if (TextUtils.isEmpty(r113.getHost()) == true) goto L49;
        if (r113.getPath() == null) goto L49;
        r20.put("origin_url", r113.getScheme() + "://" + r113.getHost() + r113.getPath());     // Catch: JSONException -> L243
    L49:
        r20.put("redirect_times", this.mRedirectTimes);     // Catch: JSONException -> L243
        JSONArray r114 = new JSONArray();     // Catch: JSONException -> L243
        JSONArray r115 = new JSONArray();     // Catch: JSONException -> L243
        Iterator<RedirectInfo> r116 = this.mRedirectInfoList.iterator();     // Catch: JSONException -> L243
    L52:
        if (r116.hasNext() == false) goto L66;
        RedirectInfo r117 = r116.next();     // Catch: JSONException -> L243
        Iterator<RedirectInfo> r118 = r116;
        JSONObject r119 = new JSONObject();     // Catch: JSONException -> L243
        String r120 = r2;
        r119.put(AlogMonitor.ALOG_RESULT_CODE, r117.mCode);     // Catch: JSONException -> L243
        r119.put("method", r117.mMethod);     // Catch: JSONException -> L243
        r119.put("internal", r117.mInternal);     // Catch: JSONException -> L243
        if (r117.mUrl == null) goto L65;
        Uri r3 = Uri.parse(r117.mUrl);     // Catch: JSONException -> L243
        if (r3 == null) goto L65;
        if (TextUtils.isEmpty(r3.getScheme()) == true) goto L65;
        if (TextUtils.isEmpty(r3.getHost()) == true) goto L65;
        String r121 = r3.getScheme() + "://" + r3.getHost();     // Catch: JSONException -> L243
        r115.put(r121);     // Catch: JSONException -> L243
        if (r3.getPath() == null) goto L64;
        r121 = r121 + r3.getPath();     // Catch: JSONException -> L243
    L64:
        r119.put("url", r121);     // Catch: JSONException -> L243
    L65:
        r114.put(r119);     // Catch: JSONException -> L243
        r116 = r118;
        r2 = r120;
        goto L52
    L66:
        String r122 = r2;
        r20.put("redirect_info", r114);     // Catch: JSONException -> L243
        r20.put("redirecting_list", r115);     // Catch: JSONException -> L243
        r20.put("dispatched", this.mDispatched);     // Catch: JSONException -> L243
        r8.put(TraceStatsConsts.STATS_BASE_MODULE, r20);     // Catch: JSONException -> L243
        JSONObject r4 = new JSONObject();     // Catch: JSONException -> L243
        r4.put(AlogMonitor.ALOG_RESULT_CODE, this.mHttpCode);     // Catch: JSONException -> L243
        r4.put("connection_info", transProtocolToEnum(this.mProtocol).mValue);     // Catch: JSONException -> L243
        Headers r7 = this.mRequestHeaders;     // Catch: JSONException -> L243
        if (r7 == null) goto L69;
        long r123 = r7.byteCount();     // Catch: JSONException -> L243
    L70:
        r4.put("sent_bytes", this.mRequestBodyBytes + r123);     // Catch: JSONException -> L243
        Headers r21 = this.mResponseHeaders;     // Catch: JSONException -> L243
        if (r21 == null) goto L73;
        long r124 = r21.byteCount();     // Catch: JSONException -> L243
    L74:
        r4.put("received_bytes", this.mResponseBodyBytes + r124);     // Catch: JSONException -> L243
        r4.put("cached", this.mIsFromCache);     // Catch: JSONException -> L243
        r4.put("network_accessed", this.mIsFromNetwork);     // Catch: JSONException -> L243
        if (this.mProxyType == Proxy.Type.DIRECT) goto L77;
        boolean r125 = true;
    L78:
        r4.put("via_proxy", r125);     // Catch: JSONException -> L243
        Headers r22 = this.mResponseHeaders;     // Catch: JSONException -> L243
        if (r22 == null) goto L93;
        List<String> r23 = r22.values("Set-Cookie");     // Catch: JSONException -> L243
        if (CollectionUtils.isEmpty(r23) == true) goto L83;
        boolean r126 = true;
    L84:
        r4.put("set_cookie", r126);     // Catch: JSONException -> L243
        if (r126 == false) goto L93;
        r4.put("set_cookie_lines", r23.size());     // Catch: JSONException -> L243
        Iterator<String> r24 = r23.iterator();     // Catch: JSONException -> L243
        long r127 = 0;
    L88:
        if (r24.hasNext() == false) goto L92;
        String r128 = r24.next();     // Catch: JSONException -> L243
        if (r128 == null) goto L88;
        r127 = r127 + ((long) r128.length());     // Catch: JSONException -> L243
        goto L88
    L92:
        r4.put("set_cookie_bytes", r127);     // Catch: JSONException -> L243
        goto L93
    L83:
        r126 = false;
    L93:
        r8.put(ApmTrafficStats.TTNET_RESPONSE, r4);     // Catch: JSONException -> L243
        JSONObject r5 = new JSONObject();     // Catch: JSONException -> L243
        if (this.mResponseHeaders == null) goto L117;
        int r25 = 0;
    L98:
        if (r25 >= this.mResponseHeaders.size()) goto L110;
        String r129 = this.mResponseHeaders.name(r25);     // Catch: JSONException -> L243
        String r130 = this.mResponseHeaders.value(r25);     // Catch: JSONException -> L243
        if (TextUtils.isEmpty(r129) == true) goto L109;
        String r131 = r129.toLowerCase();     // Catch: JSONException -> L243
        if (TextUtils.isEmpty(r131) == true) goto L109;
        if (r131.startsWith("x-tt-") == false) goto L109;
        if (TextUtils.isEmpty(r130) == true) goto L109;
        r5.put(r129, r130);     // Catch: JSONException -> L243
    L109:
        r25 = r25 + 1;     // Catch: JSONException -> L243
        goto L98
    L110:
        String r26 = this.mResponseHeaders.get("tt-idc-switch");     // Catch: JSONException -> L243
        if (TextUtils.isEmpty(r26) == true) goto L113;
        r5.put("tt-idc-switch", r26);     // Catch: JSONException -> L243
    L113:
        String r6 = this.mResponseHeaders.get("server-timing");     // Catch: JSONException -> L243
        if (TextUtils.isEmpty(r6) == true) goto L116;
        r5.put("server-timing", r6);     // Catch: JSONException -> L243
    L116:
        r8.put("header", r5);     // Catch: JSONException -> L243
    L118:
        JSONObject r27 = new JSONObject();     // Catch: JSONException -> L243
        r27.put("libcore", "okhttp");     // Catch: JSONException -> L243
        r27.put("core_ver", SsOkHttp3Client.getOkVersion());     // Catch: JSONException -> L243
        r27.put("is_main_process", ProcessUtils.isMainProcessByProcessFlag(r19));     // Catch: JSONException -> L243
        r27.put("ttnet_version", "4.2.211.1-rc.0");     // Catch: JSONException -> L243
        r27.put(ICronetClient.KEY_RETRY_ATTEMPTS, -1);     // Catch: JSONException -> L243
        BaseRequestContext r28 = this.mCtx;     // Catch: JSONException -> L243
        if (r28 != null) goto L121;
    L123:
        r8.put(PluralRules.KEYWORD_OTHER, r27);     // Catch: JSONException -> L243
        JSONObject r29 = new JSONObject();     // Catch: JSONException -> L243
        JSONObject r30 = new JSONObject();     // Catch: JSONException -> L243
        r30.put(MultiProcessFileUtils.KEY_DNS, validateAndSetDuration(this.mDnsEnd, this.mDnsStart));     // Catch: JSONException -> L243
        r30.put("tcp", validateAndSetDuration(this.mSslStart, this.mConnectStart));     // Catch: JSONException -> L243
        r30.put("ssl", validateAndSetDuration(this.mSslEnd, this.mSslStart));     // Catch: JSONException -> L243
        r30.put(CommonKey.KEY_SEND, validateAndSetDuration(this.mRequestHeadersEnd, this.mRequestHeadersStart) + validateAndSetDuration(this.mRequestBodyEnd, this.mRequestBodyStart));     // Catch: JSONException -> L243
        long r31 = validateAndSetDuration(this.mResponseHeadersEnd, this.mRequestHeadersEnd);     // Catch: JSONException -> L243
        r30.put(ICronetClient.KEY_TTFB, r31);     // Catch: JSONException -> L243
        r30.put("header_recv", validateAndSetDuration(this.mResponseHeadersEnd, this.mResponseHeadersStart));     // Catch: JSONException -> L243
        r30.put("body_recv", validateAndSetDuration(this.mResponseBodyEnd, this.mResponseBodyStart));     // Catch: JSONException -> L243
        r30.put("dispatch", this.mDispatchTiming);     // Catch: JSONException -> L243
        getServerTimingInfo(r6, r30, r31);     // Catch: JSONException -> L243
        r29.put("detailed_duration", r30);     // Catch: JSONException -> L243
        JSONObject r32 = new JSONObject();     // Catch: JSONException -> L243
        r32.put("start_time", this.mCallStart);     // Catch: JSONException -> L243
        r32.put("duration", validateAndSetDuration(this.mCallEnd.get(), this.mCallStart));     // Catch: JSONException -> L243
        r32.put("request_sent_time", this.mRequestHeadersStart);     // Catch: JSONException -> L243
        r32.put("response_recv_time", this.mResponseHeadersStart);     // Catch: JSONException -> L243
        r29.put(Ext.KEY_REQUEST, r32);     // Catch: JSONException -> L243
        r8.put("timing", r29);     // Catch: JSONException -> L243
        JSONObject r33 = new JSONObject();     // Catch: JSONException -> L243
        Socket r34 = this.mFinalSocket;     // Catch: JSONException -> L243
        if (r34 == null) goto L142;
        InetAddress r35 = r34.getInetAddress();     // Catch: JSONException -> L243
        if (r35 == null) goto L142;
        AddressFamily r36 = AddressFamily.ADDRESS_FAMILY_UNSPECIFIED;     // Catch: JSONException -> L243
        if ((r35 instanceof Inet4Address) == false) goto L131;
        r36 = AddressFamily.ADDRESS_FAMILY_IPV4;     // Catch: JSONException -> L243
    L133:
        r33.put("address_family", r36.ordinal());     // Catch: JSONException -> L243
        if (this.mConnectStart == (-1)) goto L136;
    L138:
        boolean r37 = false;
    L139:
        r33.put(ICronetClient.KEY_SOCKET_REUSED, r37);     // Catch: JSONException -> L243
        if (r35.getHostAddress() == null) goto L142;
        r33.put("remote", r35.getHostAddress());     // Catch: JSONException -> L243
        goto L142
    L136:
        if (this.mConnectionAcquired == (-1)) goto L138;
        r37 = true;
        goto L139
    L131:
        if ((r35 instanceof Inet6Address) == false) goto L133;
        r36 = AddressFamily.ADDRESS_FAMILY_IPV6;     // Catch: JSONException -> L243
    L142:
        JSONArray r38 = new JSONArray();     // Catch: JSONException -> L243
        Iterator<Pair<InetSocketAddress, Integer>> r39 = this.mConnectAttemptsList.iterator();     // Catch: JSONException -> L243
    L144:
        if (r39.hasNext() == false) goto L146;
        Pair<InetSocketAddress, Integer> r40 = r39.next();     // Catch: JSONException -> L243
        JSONObject r41 = new JSONObject();     // Catch: JSONException -> L243
        r41.put("address", ((InetSocketAddress) r40.first).toString().substring(1));     // Catch: JSONException -> L243
        r41.put("result", r40.second);     // Catch: JSONException -> L243
        r38.put(r41);     // Catch: JSONException -> L243
        goto L144
    L146:
        r33.put("connection_attempts", r38);     // Catch: JSONException -> L243
        r8.put("socket", r33);     // Catch: JSONException -> L243
        JSONObject r42 = new JSONObject();     // Catch: JSONException -> L243
        r42.put("handshake_type", this.mHandShakeType.ordinal());     // Catch: JSONException -> L243
        r42.put("cipher_suite", this.mCipherSuite);     // Catch: JSONException -> L243
        r42.put("ssl_version", this.mTlsVersion);     // Catch: JSONException -> L243
        r8.put("ssl", r42);     // Catch: JSONException -> L243
        JSONObject r43 = new JSONObject();     // Catch: JSONException -> L243
        JSONArray r44 = new JSONArray();     // Catch: JSONException -> L243
        if (this.mHostReplaceMaped == false) goto L151;
        boolean r45 = true;
        r43.put("host_replace_map", 1);     // Catch: JSONException -> L243
        r43.put("host_replace_map_size", this.mHostReplaceMapSize);     // Catch: JSONException -> L243
        boolean r46 = false;
    L173:
        r43.put("source", URLDispatcher.inst().getTncUpdateSource());     // Catch: JSONException -> L243
        r43.put("update_time", URLDispatcher.inst().getTncUpdateTime());     // Catch: JSONException -> L243
        r43.put(URLDispatch.KEY_EPOCH, URLDispatcher.inst().getEpoch());     // Catch: JSONException -> L243
        r8.put("url_dispatch", r43);     // Catch: JSONException -> L243
        if (TextUtils.isEmpty(URLDispatcher.inst().getTncEtag()) == true) goto L177;
        r8.put("tt_tnc_etag", URLDispatcher.inst().getTncEtag());     // Catch: JSONException -> L243
    L177:
        if (TextUtils.isEmpty(this.mDnsInfoJson) == false) goto L250;
    L179:
        JSONObject r47 = new JSONObject();     // Catch: JSONException -> L243
        BaseRequestContext r48 = this.mCtx;     // Catch: JSONException -> L243
        if (r48 != null) goto L182;
        long r49 = 0;
    L194:
        r8.put("socket_timeout_param", r47);     // Catch: JSONException -> L243
        JSONObject r50 = new JSONObject();     // Catch: JSONException -> L243
        r50.put("ipv4_reachable", NetworkUtils.isNetworkAvailable(r19));     // Catch: JSONException -> L243
        r50.put("ipv6_reachable", Ipv6ConnectionManager.getIpv6GloballyReachable().get());     // Catch: JSONException -> L243
        r8.put("ifconfig", r50);     // Catch: JSONException -> L243
        if (SsOkHttp3Client.getOk3TncBridge() == null) goto L200;
        Object r51 = SsOkHttp3Client.getOk3TncBridge().getTNCInfo();     // Catch: JSONException -> L243
        if (r51 == null) goto L200;
        r8.put("tnc", r51);     // Catch: JSONException -> L243
    L200:
        if (StoreRegionManager.inst().getStoreIdcInfo() == null) goto L203;
        r8.put(CronetDataStorageAccess.STORE_IDC, StoreRegionManager.inst().getStoreIdcInfo());     // Catch: JSONException -> L243
    L203:
        if (this.mRequestHeaders == null) goto L246;
        JSONObject r52 = new JSONObject();     // Catch: JSONException -> L243
        List<String> r53 = this.mRequestHeaders.values(r122);     // Catch: JSONException -> L243
        if (CollectionUtils.isEmpty(r53) == true) goto L207;
        boolean r132 = r45;
    L208:
        r52.put(r122, r132);     // Catch: JSONException -> L243
        if (r132 == false) goto L217;
        Iterator<String> r54 = r53.iterator();     // Catch: JSONException -> L243
    L212:
        if (r54.hasNext() == false) goto L216;
        String r55 = r54.next();     // Catch: JSONException -> L243
        if (r55 == null) goto L212;
        r49 = r49 + ((long) r55.length());     // Catch: JSONException -> L243
        goto L212
    L216:
        r52.put("add_cookie_bytes", r49);     // Catch: JSONException -> L243
    L217:
        String r56 = this.mRequestHeaders.get("x-tt-token");     // Catch: JSONException -> L243
        if (r56 == null) goto L223;
        if (r56.isEmpty() == true) goto L223;
        r52.put("token_md5", ByteString.encodeUtf8(r56).md5().hex());     // Catch: JSONException -> L243
    L223:
        if ("http".equalsIgnoreCase(this.mFinalScheme) == false) goto L241;
        if (r53 != null) goto L226;
    L234:
        Set<String> r1 = InsecureRequestControlConfig.getInsecureHeaders(this.mRequestHeaders);     // Catch: JSONException -> L243
        if (r1 == null) goto L241;
        JSONArray r57 = new JSONArray();     // Catch: JSONException -> L243
        Iterator<String> r58 = r1.iterator();     // Catch: JSONException -> L243
    L238:
        if (r58.hasNext() == false) goto L240;
        r57.put(r58.next());     // Catch: JSONException -> L243
        goto L238
    L240:
        r52.put("insecure_headers", r57);     // Catch: JSONException -> L243
        goto L241
    L226:
        if (r53.isEmpty() == true) goto L234;
        Set<String> r59 = InsecureRequestControlConfig.getInSecureCookies(r53);     // Catch: JSONException -> L243
        if (r59 == null) goto L234;
        JSONArray r60 = new JSONArray();     // Catch: JSONException -> L243
        Iterator<String> r61 = r59.iterator();     // Catch: JSONException -> L243
    L231:
        if (r61.hasNext() == false) goto L233;
        r60.put(r61.next());     // Catch: JSONException -> L243
        goto L231
    L233:
        r52.put("insecure_cookies", r60);     // Catch: JSONException -> L243
    L241:
        r8.put("session", r52);     // Catch: JSONException -> L243
        goto L246
    L207:
        r132 = r46;
    L246:
        return r8.toString();
    L182:
        if (r48.protect_timeout <= 0) goto L185;
        r47.put("protect", this.mCtx.protect_timeout);     // Catch: JSONException -> L243
    L185:
        if (this.mCtx.socket_connect_timeout <= 0) goto L188;
        r47.put("connect", this.mCtx.socket_connect_timeout);     // Catch: JSONException -> L243
    L188:
        if (this.mCtx.timeout_read <= 0) goto L190;
        r47.put("read", this.mCtx.timeout_read);     // Catch: JSONException -> L243
    L190:
        r49 = 0;
        if (this.mCtx.timeout_write <= 0) goto L194;
        r47.put("write", this.mCtx.timeout_write);     // Catch: JSONException -> L243
        goto L194
    L250:
        r8.put(MultiProcessFileUtils.KEY_DNS, new JSONObject(this.mDnsInfoJson));     // Catch: JSONException -> L247
        goto L179
    L151:
        r45 = true;
        List<DispatchActionInfo> r62 = this.mDispatchActionChain;     // Catch: JSONException -> L243
        if (r62 == null) goto L172;
        Iterator<DispatchActionInfo> r63 = r62.iterator();     // Catch: JSONException -> L243
    L155:
        if (r63.hasNext() == false) goto L172;
        DispatchActionInfo r64 = r63.next();     // Catch: JSONException -> L243
        JSONObject r133 = new JSONObject();     // Catch: JSONException -> L243
        if (r64.mActionHit == false) goto L155;
        r133.put("priority", r64.mPriority);     // Catch: JSONException -> L243
        r133.put("type", r64.mStrategyType);     // Catch: JSONException -> L243
        r133.put("action_hit", r64.mActionHit);     // Catch: JSONException -> L243
        if (TextUtils.isEmpty(r64.mDispatchedUrl) == true) goto L164;
        Uri r134 = Uri.parse(r64.mDispatchedUrl);     // Catch: JSONException -> L243
        if (r134.getHost() == null) goto L165;
        r133.put("replace_host", r134.getHost());     // Catch: JSONException -> L243
    L165:
        r133.put("feedback", r64.mNeedFeedBack);     // Catch: JSONException -> L243
        if (r64.mRuleid <= 0) goto L169;
        r133.put("rule_id", r64.mRuleid);     // Catch: JSONException -> L243
    L169:
        if (TextUtils.isEmpty(r64.mServiceName) == true) goto L171;
        r133.put("service_name", r64.mServiceName);     // Catch: JSONException -> L243
    L171:
        r44.put(r133);     // Catch: JSONException -> L243
        goto L155
    L164:
        r133.put("replace_host", "");     // Catch: JSONException -> L243
    L172:
        r43.put("action_info", r44);     // Catch: JSONException -> L243
        r43.put("empty_action", URLDispatcher.inst().isDispatchActionsEmpty());     // Catch: JSONException -> L243
        r46 = false;
        r43.put("host_replace_map", 0);     // Catch: JSONException -> L243
        goto L173
    L121:
        if (r28.okHttpRequestClientBuilderHook == null) goto L123;
        r27.put("hook", 1);     // Catch: JSONException -> L243
        goto L123
    L117:
        r6 = "";
        goto L118
    L77:
        r125 = false;
        goto L78
    L73:
        r124 = 0;
        goto L74
    L69:
        r123 = 0;
        goto L70
    L33:
        r112 = false;
    L243:
        e = move-exception;
        e.printStackTrace();
        goto L246
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
        if (r9.equalsIgnoreCase(HttpHeaders.ReferrerPolicyValues.ORIGIN) == true) goto L34;
        if (r9.equalsIgnoreCase(BuildConfig.FLAVOR_type) == true) goto L37;
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
        r13.put(HttpHeaders.ReferrerPolicyValues.ORIGIN, r0.mOrigin - r0.mInner);
    L57:
        r13.put(BuildConfig.FLAVOR_type, r0.mInner);
        if (r14 != (-1)) goto L60;
    L62:
        r13.put("rtt", r0.mRtt);
        return;
    L60:
        if (r14 <= (r0.mOrigin + r0.mEdge)) goto L62;
        r0.mRtt = (r14 - r0.mOrigin) - r0.mEdge;
        goto L62
    L56:
        r13.put(HttpHeaders.ReferrerPolicyValues.ORIGIN, -1);
        goto L57
    L63:
        r13.put(BuildConfig.FLAVOR_type, r0.mInner);
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
        String r1 = r5.header("location");
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
        return convertConnectException(r2, NetError.ERR_CONNECTION_FAILED);
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
        return NetError.ERR_INVALID_URL;
    L36:
        if ((r2 instanceof SocketTimeoutException) == false) goto L39;
        return NetError.ERR_CONNECTION_TIMED_OUT;
    L39:
        if ((r2 instanceof ProtocolException) == false) goto L42;
        return ColorManager.RET_NOT_SUPPORTED;
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
        return ColorManager.RET_VALUE_OUT_OF_RANGE;
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
        return NetError.ERR_CONNECTION_REFUSED;
    L16:
        if (r1.contains("CONNECTION_ABORTED") == false) goto L18;
    L38:
        return NetError.ERR_CONNECTION_ABORTED;
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
