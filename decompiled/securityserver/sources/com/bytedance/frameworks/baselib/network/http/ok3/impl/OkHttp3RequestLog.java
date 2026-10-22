package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
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
    public static /* synthetic */ class AnonymousClass1 {
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

    private String constructRequestLog(Context r19) {
        String r2 = "Cookie";
        JSONObject r8 = new JSONObject();
        JSONObject r9 = new JSONObject();     // Catch: JSONException -> L8
        String r10 = URLDispatcher.inst().getTncAbTest();     // Catch: JSONException -> L8
        ArrayList r11 = new ArrayList();     // Catch: JSONException -> L8
        if (TextUtils.isEmpty(r10) == true) goto L10;
        String[] r12 = r10.split(",");     // Catch: JSONException -> L8
        if (r12 == null) goto L10;
        r11.addAll(Arrays.asList(r12));     // Catch: JSONException -> L8
    L10:
        IOkHttpAppInfoProvider r13 = SsOkHttp3Client.getOkHttpAppInfoProvider();     // Catch: JSONException -> L8
        if (r13 == null) goto L26;
        List<String> r14 = r13.getAbSdkVersion();     // Catch: JSONException -> L8
        if (r14 == null) goto L26;
        if (r14.size() > 5) goto L17;
    L19:
        Iterator<String> r15 = r14.iterator();     // Catch: JSONException -> L8
        int r16 = 0;
    L21:
        if (r15.hasNext() == false) goto L26;
        String r17 = r15.next();     // Catch: JSONException -> L8
        r16 = r16 + 1;     // Catch: JSONException -> L8
        if (r16 > 5) goto L26;
        r11.add(r17);     // Catch: JSONException -> L8
        goto L21
    L17:
        if (Logger.debug() == false) goto L19;
        Logger.d("ok3log", "ab sdk version count must less than 5");     // Catch: JSONException -> L8
    L26:
        JSONArray r18 = new JSONArray();     // Catch: JSONException -> L8
        Iterator r110 = r11.iterator();     // Catch: JSONException -> L8
    L28:
        if (r110.hasNext() == false) goto L32;
        String r111 = (String) r110.next();     // Catch: JSONException -> L8
        if (TextUtils.isEmpty(r111) == true) goto L28;
        r18.put(r111);     // Catch: JSONException -> L8
        goto L28
    L32:
        r9.put(BaseHttpRequestInfo.KEY_HIT, r18);     // Catch: JSONException -> L8
        r8.put(BaseHttpRequestInfo.KEY_ABTEST, r9);     // Catch: JSONException -> L8
        JSONObject r20 = new JSONObject();     // Catch: JSONException -> L8
        r20.put("load_state", this.mLoadState.ordinal());     // Catch: JSONException -> L8
        r20.put("method", this.mMethod);     // Catch: JSONException -> L8
        if (this.mStatus != Status.IO_PENDING) goto L35;
        boolean r112 = true;
    L36:
        r20.put("is_pending", r112);     // Catch: JSONException -> L8
        r20.put("status", this.mStatus);     // Catch: JSONException -> L8
        if (this.mStatus == Status.SUCCESS) goto L41;
        r20.put("net_error", this.mNetError);     // Catch: JSONException -> L8
    L41:
        if (TextUtils.isEmpty(this.mOriginUrl) == true) goto L51;
        Uri r113 = Uri.parse(this.mOriginUrl);     // Catch: JSONException -> L8
        if (r113 == null) goto L51;
        if (TextUtils.isEmpty(r113.getScheme()) == true) goto L51;
        if (TextUtils.isEmpty(r113.getHost()) == true) goto L51;
        if (r113.getPath() == null) goto L51;
        r20.put("origin_url", r113.getScheme() + "://" + r113.getHost() + r113.getPath());     // Catch: JSONException -> L8
    L51:
        r20.put("redirect_times", this.mRedirectTimes);     // Catch: JSONException -> L8
        JSONArray r114 = new JSONArray();     // Catch: JSONException -> L8
        JSONArray r115 = new JSONArray();     // Catch: JSONException -> L8
        Iterator<RedirectInfo> r116 = this.mRedirectInfoList.iterator();     // Catch: JSONException -> L8
    L54:
        if (r116.hasNext() == false) goto L68;
        RedirectInfo r117 = r116.next();     // Catch: JSONException -> L8
        Iterator<RedirectInfo> r118 = r116;
        JSONObject r119 = new JSONObject();     // Catch: JSONException -> L8
        String r120 = r2;
        r119.put("code", r117.mCode);     // Catch: JSONException -> L8
        r119.put("method", r117.mMethod);     // Catch: JSONException -> L8
        r119.put("internal", r117.mInternal);     // Catch: JSONException -> L8
        String r3 = r117.mUrl;     // Catch: JSONException -> L8
        if (r3 == null) goto L67;
        Uri r4 = Uri.parse(r3);     // Catch: JSONException -> L8
        if (r4 == null) goto L67;
        if (TextUtils.isEmpty(r4.getScheme()) == true) goto L67;
        if (TextUtils.isEmpty(r4.getHost()) == true) goto L67;
        String r121 = r4.getScheme() + "://" + r4.getHost();     // Catch: JSONException -> L8
        r115.put(r121);     // Catch: JSONException -> L8
        if (r4.getPath() == null) goto L66;
        r121 = r121 + r4.getPath();     // Catch: JSONException -> L8
    L66:
        r119.put("url", r121);     // Catch: JSONException -> L8
    L67:
        r114.put(r119);     // Catch: JSONException -> L8
        r116 = r118;
        r2 = r120;
        goto L54
    L68:
        String r122 = r2;
        r20.put("redirect_info", r114);     // Catch: JSONException -> L8
        r20.put("redirecting_list", r115);     // Catch: JSONException -> L8
        r20.put("dispatched", this.mDispatched);     // Catch: JSONException -> L8
        r8.put(TraceStatsConsts.STATS_BASE_MODULE, r20);     // Catch: JSONException -> L8
        JSONObject r5 = new JSONObject();     // Catch: JSONException -> L8
        r5.put("code", this.mHttpCode);     // Catch: JSONException -> L8
        r5.put("connection_info", transProtocolToEnum(this.mProtocol).mValue);     // Catch: JSONException -> L8
        Headers r7 = this.mRequestHeaders;     // Catch: JSONException -> L8
        if (r7 == null) goto L71;
        long r123 = r7.byteCount();     // Catch: JSONException -> L8
    L72:
        r5.put("sent_bytes", this.mRequestBodyBytes + r123);     // Catch: JSONException -> L8
        Headers r21 = this.mResponseHeaders;     // Catch: JSONException -> L8
        if (r21 == null) goto L75;
        long r124 = r21.byteCount();     // Catch: JSONException -> L8
    L76:
        r5.put("received_bytes", this.mResponseBodyBytes + r124);     // Catch: JSONException -> L8
        r5.put("cached", this.mIsFromCache);     // Catch: JSONException -> L8
        r5.put("network_accessed", this.mIsFromNetwork);     // Catch: JSONException -> L8
        if (this.mProxyType == Proxy.Type.DIRECT) goto L79;
        boolean r125 = true;
    L80:
        r5.put("via_proxy", r125);     // Catch: JSONException -> L8
        Headers r22 = this.mResponseHeaders;     // Catch: JSONException -> L8
        if (r22 == null) goto L91;
        List<String> r23 = r22.values("Set-Cookie");     // Catch: JSONException -> L8
        boolean r126 = !CollectionUtils.isEmpty(r23);     // Catch: JSONException -> L8
        r5.put("set_cookie", r126);     // Catch: JSONException -> L8
        if (r126 == false) goto L91;
        r5.put("set_cookie_lines", r23.size());     // Catch: JSONException -> L8
        Iterator<String> r24 = r23.iterator();     // Catch: JSONException -> L8
        long r127 = 0;
    L86:
        if (r24.hasNext() == false) goto L90;
        String r128 = r24.next();     // Catch: JSONException -> L8
        if (r128 == null) goto L86;
        r127 = r127 + ((long) r128.length());     // Catch: JSONException -> L8
        goto L86
    L90:
        r5.put("set_cookie_bytes", r127);     // Catch: JSONException -> L8
    L91:
        r8.put(ApmTrafficStats.TTNET_RESPONSE, r5);     // Catch: JSONException -> L8
        JSONObject r6 = new JSONObject();     // Catch: JSONException -> L8
        if (this.mResponseHeaders == null) goto L115;
        int r25 = 0;
    L96:
        if (r25 >= this.mResponseHeaders.size()) goto L108;
        String r129 = this.mResponseHeaders.name(r25);     // Catch: JSONException -> L8
        String r130 = this.mResponseHeaders.value(r25);     // Catch: JSONException -> L8
        if (TextUtils.isEmpty(r129) == true) goto L107;
        String r131 = r129.toLowerCase();     // Catch: JSONException -> L8
        if (TextUtils.isEmpty(r131) == true) goto L107;
        if (r131.startsWith("x-tt-") == false) goto L107;
        if (TextUtils.isEmpty(r130) == true) goto L107;
        r6.put(r129, r130);     // Catch: JSONException -> L8
    L107:
        r25 = r25 + 1;     // Catch: JSONException -> L8
        goto L96
    L108:
        String r26 = this.mResponseHeaders.get("tt-idc-switch");     // Catch: JSONException -> L8
        if (TextUtils.isEmpty(r26) == true) goto L111;
        r6.put("tt-idc-switch", r26);     // Catch: JSONException -> L8
    L111:
        String r27 = this.mResponseHeaders.get("server-timing");     // Catch: JSONException -> L8
        if (TextUtils.isEmpty(r27) == true) goto L114;
        r6.put("server-timing", r27);     // Catch: JSONException -> L8
    L114:
        r8.put("header", r6);     // Catch: JSONException -> L8
    L116:
        JSONObject r28 = new JSONObject();     // Catch: JSONException -> L8
        r28.put("libcore", "okhttp");     // Catch: JSONException -> L8
        r28.put("core_ver", SsOkHttp3Client.getOkVersion());     // Catch: JSONException -> L8
        r28.put("is_main_process", ProcessUtils.isMainProcessByProcessFlag(r19));     // Catch: JSONException -> L8
        r28.put("ttnet_version", "4.2.228.16-pico");     // Catch: JSONException -> L8
        r28.put(ICronetClient.KEY_RETRY_ATTEMPTS, -1);     // Catch: JSONException -> L8
        BaseRequestContext r29 = this.mCtx;     // Catch: JSONException -> L8
        if (r29 != null) goto L119;
    L121:
        r8.put("other", r28);     // Catch: JSONException -> L8
        JSONObject r30 = new JSONObject();     // Catch: JSONException -> L8
        JSONObject r31 = new JSONObject();     // Catch: JSONException -> L8
        r31.put(MultiProcessFileUtils.KEY_DNS, validateAndSetDuration(this.mDnsEnd, this.mDnsStart));     // Catch: JSONException -> L8
        r31.put("tcp", validateAndSetDuration(this.mSslStart, this.mConnectStart));     // Catch: JSONException -> L8
        r31.put("ssl", validateAndSetDuration(this.mSslEnd, this.mSslStart));     // Catch: JSONException -> L8
        r31.put(CommonKey.KEY_SEND, validateAndSetDuration(this.mRequestHeadersEnd, this.mRequestHeadersStart) + validateAndSetDuration(this.mRequestBodyEnd, this.mRequestBodyStart));     // Catch: JSONException -> L8
        long r32 = validateAndSetDuration(this.mResponseHeadersEnd, this.mRequestHeadersEnd);     // Catch: JSONException -> L8
        r31.put(ICronetClient.KEY_TTFB, r32);     // Catch: JSONException -> L8
        r31.put("header_recv", validateAndSetDuration(this.mResponseHeadersEnd, this.mResponseHeadersStart));     // Catch: JSONException -> L8
        r31.put("body_recv", validateAndSetDuration(this.mResponseBodyEnd, this.mResponseBodyStart));     // Catch: JSONException -> L8
        r31.put("dispatch", this.mDispatchTiming);     // Catch: JSONException -> L8
        getServerTimingInfo(r27, r31, r32);     // Catch: JSONException -> L8
        TTMetaDispatchLog r33 = this.mMetaDispatchLog;     // Catch: JSONException -> L8
        if (r33 == null) goto L127;
        long r34 = r33.dispatchCostMs;     // Catch: JSONException -> L8
        if (r34 < 0) goto L127;
        r31.put("meta_dp", r34);     // Catch: JSONException -> L8
    L127:
        r30.put("detailed_duration", r31);     // Catch: JSONException -> L8
        JSONObject r35 = new JSONObject();     // Catch: JSONException -> L8
        r35.put("start_time", this.mCallStart);     // Catch: JSONException -> L8
        r35.put("duration", validateAndSetDuration(this.mCallEnd.get(), this.mCallStart));     // Catch: JSONException -> L8
        r35.put("request_sent_time", this.mRequestHeadersStart);     // Catch: JSONException -> L8
        r35.put("response_recv_time", this.mResponseHeadersStart);     // Catch: JSONException -> L8
        r30.put("request", r35);     // Catch: JSONException -> L8
        r8.put("timing", r30);     // Catch: JSONException -> L8
        JSONObject r36 = new JSONObject();     // Catch: JSONException -> L8
        Socket r37 = this.mFinalSocket;     // Catch: JSONException -> L8
        if (r37 == null) goto L146;
        InetAddress r38 = r37.getInetAddress();     // Catch: JSONException -> L8
        if (r38 == null) goto L146;
        AddressFamily r39 = AddressFamily.ADDRESS_FAMILY_UNSPECIFIED;     // Catch: JSONException -> L8
        if ((r38 instanceof Inet4Address) == false) goto L135;
        r39 = AddressFamily.ADDRESS_FAMILY_IPV4;     // Catch: JSONException -> L8
    L137:
        r36.put("address_family", r39.ordinal());     // Catch: JSONException -> L8
        if (this.mConnectStart == (-1)) goto L140;
    L142:
        boolean r40 = false;
    L143:
        r36.put(ICronetClient.KEY_SOCKET_REUSED, r40);     // Catch: JSONException -> L8
        if (r38.getHostAddress() == null) goto L146;
        r36.put("remote", r38.getHostAddress());     // Catch: JSONException -> L8
        goto L146
    L140:
        if (this.mConnectionAcquired == (-1)) goto L142;
        r40 = true;
        goto L143
    L135:
        if ((r38 instanceof Inet6Address) == false) goto L137;
        r39 = AddressFamily.ADDRESS_FAMILY_IPV6;     // Catch: JSONException -> L8
    L146:
        JSONArray r41 = new JSONArray();     // Catch: JSONException -> L8
        Iterator<Pair<InetSocketAddress, Integer>> r42 = this.mConnectAttemptsList.iterator();     // Catch: JSONException -> L8
    L148:
        if (r42.hasNext() == false) goto L150;
        Pair<InetSocketAddress, Integer> r43 = r42.next();     // Catch: JSONException -> L8
        JSONObject r132 = new JSONObject();     // Catch: JSONException -> L8
        r132.put("address", ((InetSocketAddress) r43.first).toString().substring(1));     // Catch: JSONException -> L8
        r132.put("result", r43.second);     // Catch: JSONException -> L8
        r41.put(r132);     // Catch: JSONException -> L8
        goto L148
    L150:
        r36.put("connection_attempts", r41);     // Catch: JSONException -> L8
        r8.put("socket", r36);     // Catch: JSONException -> L8
        JSONObject r44 = new JSONObject();     // Catch: JSONException -> L8
        r44.put("handshake_type", this.mHandShakeType.ordinal());     // Catch: JSONException -> L8
        r44.put("cipher_suite", this.mCipherSuite);     // Catch: JSONException -> L8
        r44.put("ssl_version", this.mTlsVersion);     // Catch: JSONException -> L8
        r8.put("ssl", r44);     // Catch: JSONException -> L8
        JSONObject r45 = new JSONObject();     // Catch: JSONException -> L8
        JSONArray r46 = new JSONArray();     // Catch: JSONException -> L8
        if (this.mHostReplaceMaped == true) goto L154;
        List<DispatchActionInfo> r47 = this.mDispatchActionChain;     // Catch: JSONException -> L8
        if (r47 == null) goto L176;
        Iterator<DispatchActionInfo> r48 = r47.iterator();     // Catch: JSONException -> L8
    L159:
        if (r48.hasNext() == false) goto L176;
        DispatchActionInfo r49 = r48.next();     // Catch: JSONException -> L8
        JSONObject r133 = new JSONObject();     // Catch: JSONException -> L8
        if (r49.mActionHit == false) goto L159;
        r133.put("priority", r49.mPriority);     // Catch: JSONException -> L8
        r133.put("type", r49.mStrategyType);     // Catch: JSONException -> L8
        r133.put("action_hit", r49.mActionHit);     // Catch: JSONException -> L8
        if (TextUtils.isEmpty(r49.mDispatchedUrl) == true) goto L168;
        Uri r134 = Uri.parse(r49.mDispatchedUrl);     // Catch: JSONException -> L8
        if (r134.getHost() == null) goto L169;
        r133.put("replace_host", r134.getHost());     // Catch: JSONException -> L8
    L169:
        r133.put("feedback", r49.mNeedFeedBack);     // Catch: JSONException -> L8
        long r135 = r49.mRuleid;     // Catch: JSONException -> L8
        if (r135 <= 0) goto L173;
        r133.put("rule_id", r135);     // Catch: JSONException -> L8
    L173:
        if (TextUtils.isEmpty(r49.mServiceName) == true) goto L175;
        r133.put("service_name", r49.mServiceName);     // Catch: JSONException -> L8
    L175:
        r46.put(r133);     // Catch: JSONException -> L8
        goto L159
    L168:
        r133.put("replace_host", "");     // Catch: JSONException -> L8
    L176:
        r45.put("action_info", r46);     // Catch: JSONException -> L8
        r45.put("empty_action", URLDispatcher.inst().isDispatchActionsEmpty());     // Catch: JSONException -> L8
        r45.put("host_replace_map", 0);     // Catch: JSONException -> L8
    L177:
        r45.put(DBHelper.BATTERY_COL_SOURCE, URLDispatcher.inst().getTncUpdateSource());     // Catch: JSONException -> L8
        r45.put("update_time", URLDispatcher.inst().getTncUpdateTime());     // Catch: JSONException -> L8
        r45.put(URLDispatch.KEY_EPOCH, URLDispatcher.inst().getEpoch());     // Catch: JSONException -> L8
        r8.put("url_dispatch", r45);     // Catch: JSONException -> L8
        if (TextUtils.isEmpty(URLDispatcher.inst().getTncEtag()) == true) goto L181;
        r8.put("tt_tnc_etag", URLDispatcher.inst().getTncEtag());     // Catch: JSONException -> L8
    L181:
        if (this.mMetaDispatchLog == null) goto L206;
        JSONObject r50 = new JSONObject();     // Catch: JSONException -> L8
        Set<String> r51 = this.mMetaDispatchLog.headerAdd;     // Catch: JSONException -> L8
        if (r51 != null) goto L185;
    L187:
        Set<String> r52 = this.mMetaDispatchLog.headerRm;     // Catch: JSONException -> L8
        if (r52 != null) goto L190;
    L192:
        Set<String> r53 = this.mMetaDispatchLog.queryAdd;     // Catch: JSONException -> L8
        if (r53 != null) goto L195;
    L197:
        Set<String> r54 = this.mMetaDispatchLog.queryRm;     // Catch: JSONException -> L8
        if (r54 == null) goto L203;
        if (r54.isEmpty() == true) goto L203;
        r50.put("query_rm", this.mMetaDispatchLog.queryRm);     // Catch: JSONException -> L8
    L203:
        if (r50.length() <= 0) goto L206;
        r8.put("meta_dp", r50);     // Catch: JSONException -> L8
        goto L206
    L195:
        if (r53.isEmpty() == true) goto L197;
        r50.put("query_add", this.mMetaDispatchLog.queryAdd);     // Catch: JSONException -> L8
        goto L197
    L190:
        if (r52.isEmpty() == true) goto L192;
        r50.put("header_rm", this.mMetaDispatchLog.headerRm);     // Catch: JSONException -> L8
        goto L192
    L185:
        if (r51.isEmpty() == true) goto L187;
        r50.put("header_add", this.mMetaDispatchLog.headerAdd);     // Catch: JSONException -> L8
    L206:
        if (TextUtils.isEmpty(this.mDnsInfoJson) == false) goto L272;
    L208:
        JSONObject r55 = new JSONObject();     // Catch: JSONException -> L8
        BaseRequestContext r56 = this.mCtx;     // Catch: JSONException -> L8
        if (r56 == null) goto L222;
        long r57 = r56.protect_timeout;     // Catch: JSONException -> L8
        if (r57 <= 0) goto L213;
        r55.put("protect", r57);     // Catch: JSONException -> L8
    L213:
        long r58 = this.mCtx.socket_connect_timeout;     // Catch: JSONException -> L8
        if (r58 <= 0) goto L216;
        r55.put("connect", r58);     // Catch: JSONException -> L8
    L216:
        long r59 = this.mCtx.timeout_read;     // Catch: JSONException -> L8
        if (r59 <= 0) goto L219;
        r55.put("read", r59);     // Catch: JSONException -> L8
    L219:
        long r60 = this.mCtx.timeout_write;     // Catch: JSONException -> L8
        long r61 = 0;
        if (r60 <= 0) goto L223;
        r55.put("write", r60);     // Catch: JSONException -> L8
    L223:
        r8.put("socket_timeout_param", r55);     // Catch: JSONException -> L8
        JSONObject r62 = new JSONObject();     // Catch: JSONException -> L8
        r62.put("ipv4_reachable", NetworkUtils.isNetworkAvailable(r19));     // Catch: JSONException -> L8
        r62.put("ipv6_reachable", Ipv6ConnectionManager.getIpv6GloballyReachable().get());     // Catch: JSONException -> L8
        r8.put("ifconfig", r62);     // Catch: JSONException -> L8
        if (SsOkHttp3Client.getOk3TncBridge() == null) goto L229;
        Object r63 = SsOkHttp3Client.getOk3TncBridge().getTNCInfo();     // Catch: JSONException -> L8
        if (r63 == null) goto L229;
        r8.put("tnc", r63);     // Catch: JSONException -> L8
    L229:
        if (StoreRegionManager.inst().getStoreIdcInfo() == null) goto L232;
        r8.put(CronetDataStorageAccess.STORE_IDC, StoreRegionManager.inst().getStoreIdcInfo());     // Catch: JSONException -> L8
    L232:
        if (this.mRequestHeaders == null) goto L270;
        JSONObject r64 = new JSONObject();     // Catch: JSONException -> L8
        List<String> r65 = this.mRequestHeaders.values(r122);     // Catch: JSONException -> L8
        boolean r66 = !CollectionUtils.isEmpty(r65);     // Catch: JSONException -> L8
        r64.put(r122, r66);     // Catch: JSONException -> L8
        if (r66 == false) goto L242;
        Iterator<String> r67 = r65.iterator();     // Catch: JSONException -> L8
        long r68 = r61;
    L237:
        if (r67.hasNext() == false) goto L241;
        String r69 = r67.next();     // Catch: JSONException -> L8
        if (r69 == null) goto L237;
        r68 = r68 + ((long) r69.length());     // Catch: JSONException -> L8
        goto L237
    L241:
        r64.put("add_cookie_bytes", r68);     // Catch: JSONException -> L8
    L242:
        String r70 = this.mRequestHeaders.get("x-tt-token");     // Catch: JSONException -> L8
        if (r70 == null) goto L248;
        if (r70.isEmpty() == true) goto L248;
        r64.put("token_md5", ByteString.encodeUtf8(r70).md5().hex());     // Catch: JSONException -> L8
    L248:
        if (HttpHost.DEFAULT_SCHEME_NAME.equalsIgnoreCase(this.mFinalScheme) == false) goto L266;
        if (r65 != null) goto L251;
    L259:
        Set<String> r1 = InsecureRequestControlConfig.getInsecureHeaders(this.mRequestHeaders);     // Catch: JSONException -> L8
        if (r1 == null) goto L266;
        JSONArray r71 = new JSONArray();     // Catch: JSONException -> L8
        Iterator<String> r72 = r1.iterator();     // Catch: JSONException -> L8
    L263:
        if (r72.hasNext() == false) goto L265;
        r71.put(r72.next());     // Catch: JSONException -> L8
        goto L263
    L265:
        r64.put("insecure_headers", r71);     // Catch: JSONException -> L8
        goto L266
    L251:
        if (r65.isEmpty() == true) goto L259;
        Set<String> r73 = InsecureRequestControlConfig.getInSecureCookies(r65);     // Catch: JSONException -> L8
        if (r73 == null) goto L259;
        JSONArray r74 = new JSONArray();     // Catch: JSONException -> L8
        Iterator<String> r75 = r73.iterator();     // Catch: JSONException -> L8
    L256:
        if (r75.hasNext() == false) goto L258;
        r74.put(r75.next());     // Catch: JSONException -> L8
        goto L256
    L258:
        r64.put("insecure_cookies", r74);     // Catch: JSONException -> L8
    L266:
        r8.put("session", r64);     // Catch: JSONException -> L8
    L270:
        return r8.toString();
    L222:
        r61 = 0;
        goto L223
    L272:
        r8.put(MultiProcessFileUtils.KEY_DNS, new JSONObject(this.mDnsInfoJson));     // Catch: JSONException -> L271
        goto L208
    L154:
        r45.put("host_replace_map", 1);     // Catch: JSONException -> L8
        r45.put("host_replace_map_size", this.mHostReplaceMapSize);     // Catch: JSONException -> L8
        goto L177
    L119:
        if (r29.okHttpRequestClientBuilderHook == null) goto L121;
        r28.put("hook", 1);     // Catch: JSONException -> L8
        goto L121
    L115:
        r27 = "";
        goto L116
    L79:
        r125 = false;
        goto L80
    L75:
        r124 = 0;
        goto L76
    L71:
        r123 = 0;
        goto L72
    L35:
        r112 = false;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L270
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

    private static String formatJsonHeaders(Headers r4) {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L15
        Iterator<Map.Entry<String, List<String>>> r5 = r4.toMultimap().entrySet().iterator();     // Catch: Exception -> L15
    L4:
        if (r5.hasNext() == false) goto L17;
        Map.Entry<String, List<String>> r1 = r5.next();     // Catch: Exception -> L15
        String r2 = r1.getKey();     // Catch: Exception -> L15
        List<String> r3 = r1.getValue();     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r2) == true) goto L4;
        if (r3 == null) goto L4;
        if (r3.size() <= 0) goto L4;
        Iterator<String> r6 = r3.iterator();     // Catch: Exception -> L15
    L13:
        if (r6.hasNext() == false) goto L4;
        r0.put(r2, r6.next());     // Catch: Exception -> L15
        goto L13
    L17:
        return r0.toString();
    L15:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    private void getServerTimingInfo(String r12, JSONObject r13, long r14) {
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
        if (r16.hasNext() == false) goto L41;
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
    L41:
        boolean r110 = r0.mPassedCdn;
        if (r110 == true) goto L44;
    L51:
        if (r110 == false) goto L62;
        r13.put("edge", r0.mEdge);
        r13.put("cdn-cache", "miss");
        long r7 = r0.mOrigin;
        long r10 = r0.mInner;
        if (r7 <= r10) goto L55;
        r13.put("origin", r7 - r10);
    L56:
        r13.put("inner", r0.mInner);
        if (r14 == (-1)) goto L61;
        long r2 = r0.mOrigin;
        long r3 = r0.mEdge;
        if (r14 <= (r2 + r3)) goto L61;
        r0.mRtt = (r14 - r2) - r3;
    L61:
        r13.put("rtt", r0.mRtt);
        return;
    L55:
        r13.put("origin", -1);
        goto L56
    L62:
        r13.put("inner", r0.mInner);
        if (r14 == (-1)) goto L67;
        long r4 = r0.mInner;
        if (r14 <= r4) goto L67;
        r0.mRtt = r14 - r4;
    L67:
        r13.put("rtt", r0.mRtt);
        return;
    L44:
        if (r0.mCdnHitCache == false) goto L51;
        r13.put("edge", r0.mEdge);
        r13.put("cdn-cache", BaseHttpRequestInfo.KEY_HIT);
        if (r14 == (-1)) goto L50;
        long r8 = r0.mEdge;
        if (r14 <= r8) goto L50;
        r0.mRtt = r14 - r8;
    L50:
        r13.put("rtt", r0.mRtt);
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

    private static long validateAndSetDuration(long r3, long r5) {
        if (r5 != (-1)) goto L5;
    L8:
        return -1;
    L5:
        if (r3 == (-1)) goto L8;
        return r3 - r5;
    }

    public void callEnd() {
        this.mCallEnd.set(System.currentTimeMillis());
        this.mLoadState = LoadState.IDLE;
        this.mStatus = Status.SUCCESS;
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

    public void callStart() {
        this.mCallStart = System.currentTimeMillis();
        this.mStatus = Status.IO_PENDING;
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

    public void connectStart() {
        this.mConnectStart = System.currentTimeMillis();
        this.mLoadState = LoadState.CONNECTING;
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

    public void dnsEnd() {
        this.mDnsEnd = System.currentTimeMillis();
    }

    public void dnsStart() {
        this.mDnsStart = System.currentTimeMillis();
        this.mLoadState = LoadState.RESOLVING_HOST;
    }

    public boolean isRequestFinished() {
        if (this.mCallEnd.get() == (-1)) goto L5;
        return true;
    L5:
        return false;
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

    public void requestBodyEnd(long r3) {
        this.mRequestBodyEnd = System.currentTimeMillis();
        this.mRequestBodyBytes = r3;
    }

    public void requestBodyStart() {
        this.mRequestBodyStart = System.currentTimeMillis();
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

    public void requestHeadersStart() {
        this.mLoadState = LoadState.SENDING_REQUEST;
        this.mRequestHeadersStart = System.currentTimeMillis();
    }

    public void responseBodyEnd(long r3) {
        this.mResponseBodyEnd = System.currentTimeMillis();
        this.mResponseBodyBytes = r3;
    }

    public void responseBodyStart() {
        this.mLoadState = LoadState.READING_RESPONSE;
        this.mResponseBodyStart = System.currentTimeMillis();
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

    public void responseHeadersStart() {
        this.mResponseHeadersStart = System.currentTimeMillis();
    }

    public void secureConnectEnd() {
        this.mSslEnd = System.currentTimeMillis();
    }

    public void secureConnectStart() {
        this.mSslStart = System.currentTimeMillis();
        this.mLoadState = LoadState.SSL_HANDSHAKE;
    }

    public void setNetError(int r1) {
        this.mNetError = r1;
    }

    public void setOriginUrl(String r1, String r2) {
        this.mOriginUrl = r1;
        this.mMethod = r2;
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
        long r3 = this.mResponseBodyBytes;
        r7.receivedByteCount = r3;
        r7.responseBodyByteCount = r3;
        r7.requestLog = constructRequestLog(r8);
        r7.retryAttempts = -1;
        Headers r9 = this.mRequestHeaders;
        if (r9 == null) goto L11;
        r7.requestHeaders = formatJsonHeaders(r9);
        long r4 = r7.sentByteCount;
        r7.sentByteCount = this.mRequestHeaders.byteCount() + r4;
    L11:
        Headers r10 = this.mResponseHeaders;
        if (r10 == null) goto L14;
        r7.responseHeaders = formatJsonHeaders(r10);
        long r5 = r7.receivedByteCount;
        r7.receivedByteCount = this.mResponseHeaders.byteCount() + r5;
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

    public void setRequestTimeout(BaseRequestContext r1) {
        this.mCtx = r1;
    }

    public void setResponseSource(Response r4) {
        boolean r1 = false;
        if (r4.cacheResponse() == null) goto L5;
        boolean r0 = true;
    L6:
        this.mIsFromCache = r0;
        if (r4.networkResponse() == null) goto L9;
        r1 = true;
    L9:
        this.mIsFromNetwork = r1;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void dnsEnd(String r3) {
        this.mDnsEnd = System.currentTimeMillis();
        this.mDnsInfoJson = r3;
    }
}
