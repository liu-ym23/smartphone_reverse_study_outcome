package com.ss.android.common.util;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.Pair;
import android.webkit.CookieManager;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.connectionclass.CdnDeviceBandwidthSampler;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.parser.StreamParser;
import com.bytedance.frameworks.baselib.network.http.util.IDownloadPublisher;
import com.bytedance.frameworks.baselib.network.http.util.TaskInfo;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.IMetricsCollect;
import com.bytedance.retrofit2.IRequestInfo;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.retrofit2.mime.TypedString;
import com.bytedance.ttnet.INetworkApi;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.bytedance.ttnet.http.IRequestHolder;
import com.bytedance.ttnet.http.RequestContext;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.ss.android.common.NetworkResponseInfo;
import com.ss.android.http.legacy.Header;
import com.ss.android.http.legacy.HeaderElement;
import com.ss.android.http.legacy.NameValuePair;
import com.ss.android.http.legacy.message.BasicHeader;
import com.ss.android.http.legacy.message.BasicNameValuePair;
import com.ss.android.http.legacy.message.HeaderGroup;
import com.ss.android.http.legacy.params.HttpProtocolParams;
import com.ss.android.http.legacy.utils.URLEncodedUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.GZIPOutputStream;
import org.apache.http.params.HttpParams;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkUtils {
    public static final int CONNECT_TIMEOUT = 15000;
    public static final String CONTENT_TYPE_JSON = "application/json; charset=utf-8";
    private static final boolean DEBUG_MOBILE = false;
    public static final long DEFAULT_CONN_POOL_TIMEOUT = 15000;
    public static final int DEFAULT_MAX_CONNECTIONS_PER_ROUTE = 4;
    private static final String ENAME_MAX_AGE = "max-age";
    public static final String HNAME_CACHE_CONTROL = "Cache-Control";
    public static final String HNAME_ETAG = "ETag";
    public static final String HNAME_IF_MODIFIED_SINCE = "If-Modified-Since";
    public static final String HNAME_IF_NONE_MATCH = "If-None-Match";
    public static final String HNAME_LAST_MODIFIED = "Last-Modified";
    public static final int IO_TIMEOUT = 15000;
    public static final String[] L0_PARAM_LIST = null;
    public static final String PNAME_REMOTE_ADDRESS = "x-snssdk.remoteaddr";
    public static final int SOCKET_BUFFER_SIZE = 8192;
    private static final String TAG = "NetworkUtils";
    public static final boolean USE_KEEP_ALIVE = true;
    public static final boolean USE_PROXY = false;
    private static volatile boolean mAllowKeepAlive = true;
    private static Context sAppContext = null;
    private static volatile boolean sHasRebuildSsl = false;
    private static NetworkTypeInterceptor sNetworkTypeInterceptor = null;
    private static volatile boolean sPostContainsL0 = false;
    private static volatile int sUseDnsMapping;

    public interface NetworkTypeInterceptor {
        com.bytedance.common.utility.NetworkUtils.NetworkType getNetworkType();
    }

    static {
        L0_PARAM_LIST = new String[]{"mac_address", "oaid", "openudid", "uuid", "imei"};
        sUseDnsMapping = -1;
    }

    public NetworkUtils() {
    }

    public static void addCacheValidationHeaders(List<Header> r2, String r3, String r4) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (StringUtils.isEmpty(r3) == true) goto L8;
        r2.add(new BasicHeader("If-None-Match", r3));
    L8:
        if (StringUtils.isEmpty(r4) == true) goto L11;
        r2.add(new BasicHeader("If-Modified-Since", r4));
        return;
    }

    public static String addCommonParams(String r0, boolean r1) {
        return NetworkParams.addCommonParams(r0, r1);
    }

    /* JADX WARN: Not initialized variable reg: 18, insn: 0x0133: MOVE (r5 I:??[OBJECT, ARRAY]) = (r18 I:??[OBJECT, ARRAY]), block:B:89:0x0130 */
    @Deprecated
    public static byte[] downloadFile(int r20, final String r21) {
        Call<TypedInput> r3 = null;
        String r4 = null;
        r4 = null;
        r4 = null;
        r4 = null;
        if (StringUtils.isEmpty(r21) == false) goto L5;
        return null;
    L5:
        LinkedHashMap r2 = new LinkedHashMap();
        Pair<String, String> r5 = UrlUtils.parseUrl(r21, r2);
        if (r5 != null) goto L8;
        return null;
    L8:
        String r6 = (String) r5.first;
        String r7 = (String) r5.second;
        INetworkApi r8 = (INetworkApi) RetrofitUtils.createSsService(r6, INetworkApi.class);
        if (r8 == null) goto L146;
        boolean r9 = false;
        final Call<TypedInput> r10 = r8.downloadFile(false, r20, r7, r2);     // Catch: Throwable -> L128
    L28:
        th = th;
        InputStream r19 = null;
        r3 = r10;
    L171:
    L133:
        th = move-exception;
        if (r9 == false) goto L176;
        CdnDeviceBandwidthSampler.getInstance().stopSampling();
    L176:
        StreamParser.safeClose(r19);     // Catch: Throwable -> L143
        if (r3 == null) goto L179;
        r3.cancel();     // Catch: Throwable -> L143
        throw th;
    L179:
        throw th;
    L143:
        th = move-exception;
        th.printStackTrace();
        throw th;
    L131:
        if ((th instanceof Exception) == false) goto L136;
        throw th;     // Catch: Throwable -> L133
    L136:
        throw new Exception(th.getMessage(), th.getCause());     // Catch: Throwable -> L133
    L13:
        if (com.bytedance.common.utility.NetworkUtils.isNetworkAvailable(TTNetInit.getTTNetDepend().getContext()) == false) goto L158;
        long r11 = System.currentTimeMillis();     // Catch: Throwable -> L28
        NetworkParams.CdnConnectionQualitySamplerHook r12 = NetworkParams.getCdnConnectionQualitySamplerHook();     // Catch: Throwable -> L28
        if (r12 != null) goto L24;
    L27:
        boolean r13 = r9;
        SsResponse<TypedInput> r14 = r10.execute();     // Catch: Throwable -> L44
        if (r14 != null) goto L161;
        if (r13 == false) goto L150;
        CdnDeviceBandwidthSampler.getInstance().stopSampling();
    L150:
        StreamParser.safeClose(null);     // Catch: Throwable -> L36
        r10.cancel();     // Catch: Throwable -> L36
    L38:
        return null;
    L36:
        th = move-exception;
        th.printStackTrace();
        goto L38
    L161:
        long r15 = System.currentTimeMillis();     // Catch: Throwable -> L44 Exception -> L103
        Object r16 = r14.raw().getExtraInfo();     // Catch: Throwable -> L44 Exception -> L47
        if ((r16 instanceof BaseHttpRequestInfo) == false) goto L49;
        BaseHttpRequestInfo r17 = (BaseHttpRequestInfo) r16;     // Catch: Throwable -> L44 Exception -> L47
    L167:
        TypedInput r18 = r14.body();     // Catch: Throwable -> L44 Exception -> L54
        if (r18 == null) goto L56;
        InputStream r22 = r18.in();     // Catch: Throwable -> L44 Exception -> L54
    L148:
        List<com.bytedance.retrofit2.client.Header> r23 = r14.headers();     // Catch: Throwable -> L63 Exception -> L101
        String r110 = RetrofitUtils.getHeaderValueIgnoreCase(r23, "X-TT-LOGID");     // Catch: Throwable -> L63 Exception -> L99
        getOutIp(r17, r23, null);     // Catch: Throwable -> L63 Exception -> L90
        int r24 = r14.code();     // Catch: Throwable -> L63 Exception -> L90
        if (r17 == null) goto L147;
        r17.completeReadResponse = r15;     // Catch: Throwable -> L63 Exception -> L65
    L65:
        e = e;
        r4 = r110;
    L67:
        Exception r25 = e;
    L106:
        if (StringUtils.isEmpty(r4) == false) goto L108;
        String r26 = RetrofitUtils.getHeaderValueIgnoreCase(r23, "X-TT-LOGID");     // Catch: Throwable -> L86
    L109:
        if (r17 != null) goto L116;
        if ((r10 instanceof IRequestInfo) == false) goto L116;
        Object r0 = ((IRequestInfo) r10).getRequestInfo();     // Catch: Throwable -> L86
        if ((r0 instanceof BaseHttpRequestInfo) == false) goto L116;
        r17 = (BaseHttpRequestInfo) r0;     // Catch: Throwable -> L86
    L116:
        if ((r10 instanceof IMetricsCollect) == false) goto L118;
        ((IMetricsCollect) r10).doCollect();     // Catch: Throwable -> L86
    L118:
        getOutIp(r17, r23, r25);     // Catch: Throwable -> L86
        long r1 = System.currentTimeMillis();     // Catch: Throwable -> L86
        if (r17 != null) goto L121;
    L126:
        String r27 = r26;
        Exception r28 = r25;
        NetworkParams.monitorApiError(r1 - r11, r11, r21, r27, r17, r28);     // Catch: Throwable -> L86
        throw r28;     // Catch: Throwable -> L86
    L121:
        if (r17.completeReadResponse > 0) goto L123;
        r17.completeReadResponse = r15;     // Catch: Throwable -> L86
    L123:
        r17.requestEnd = r1;     // Catch: Throwable -> L86
        JSONObject r29 = r17.extraInfo;     // Catch: Throwable -> L86
        if (r29 == null) goto L126;
        r29.put(BaseHttpRequestInfo.KEY_EXCEPTION, r25.getMessage());     // Catch: Throwable -> L86
        goto L126
    L108:
        r26 = r4;
    L147:
        if (r24 != 200) goto L93;
        if (r18 == null) goto L93;
        byte[] r111 = StreamParser.stream2ByteArray(r20, r22, r18.length(), new AnonymousClass1(r21, r10));     // Catch: Throwable -> L63 Exception -> L90
        if ((r10 instanceof IMetricsCollect) == false) goto L74;
        ((IMetricsCollect) r10).doCollect();     // Catch: Throwable -> L63 Exception -> L65
    L74:
        long r30 = System.currentTimeMillis();     // Catch: Throwable -> L63 Exception -> L90
        if (r17 == null) goto L77;
        r17.requestEnd = r30;     // Catch: Throwable -> L63 Exception -> L65
    L77:
        InputStream r112 = r22;
        NetworkParams.monitorApiSample(r30 - r11, r11, r21, r110, r17);     // Catch: Throwable -> L86 Exception -> L88
        if (r13 == false) goto L152;
        CdnDeviceBandwidthSampler.getInstance().stopSampling();
    L152:
        StreamParser.safeClose(r112);     // Catch: Throwable -> L83
        r10.cancel();     // Catch: Throwable -> L83
    L85:
        return r111;
    L83:
        th = move-exception;
        th.printStackTrace();
    L93:
        if (r24 != 200) goto L98;
        if (r18 != null) goto L98;
        throw new IllegalArgumentException("HTTP TypedInput may not be null");     // Catch: Throwable -> L86 Exception -> L88
    L98:
        throw new HttpResponseException(r24, "get url = " + r21 + " exception");     // Catch: Throwable -> L86 Exception -> L88
    L88:
        e = move-exception;
        r25 = e;
        r4 = r110;
        r23 = r18;
    L90:
        e = move-exception;
        r25 = e;
        r4 = r110;
    L99:
        e = e;
    L101:
        e = move-exception;
        r25 = e;
        r23 = null;
    L63:
        th = th;
        r19 = r22;
    L46:
        r3 = r10;
        r9 = r13;
        goto L171
    L56:
        r22 = null;
    L54:
        e = move-exception;
        r25 = e;
        r23 = null;
        goto L106
    L49:
        r17 = null;
    L47:
        e = e;
    L48:
        r25 = e;
        r23 = null;
        r17 = null;
    L103:
        e = e;
        r15 = -1;
    L86:
        th = th;
    L44:
        th = th;
        r19 = null;
        goto L46
    L24:
        if (r12.cdnShouldSampling(r21) == false) goto L27;
        CdnDeviceBandwidthSampler.getInstance().startSampling();     // Catch: Throwable -> L28
        r9 = true;
        goto L27
    L158:
        StreamParser.safeClose(null);     // Catch: Throwable -> L18
        if (r10 == null) goto L20;
        r10.cancel();     // Catch: Throwable -> L18
    L20:
        return null;
    L18:
        th = move-exception;
        th.printStackTrace();
    L128:
        th = th;
        r19 = null;
        goto L171
    L146:
        return null;
    }

    @Deprecated
    public static String executeGet(int r1, String r2) {
        return executeGet(r1, r2, true, true);
    }

    @Deprecated
    public static NetworkResponseInfo executeGetResult(int r8, String r9, boolean r10, boolean r11, List<Header> r12, HeaderGroup r13, boolean r14, RequestContext r15) {
        NetworkResponseInfo r16 = new NetworkResponseInfo();
        if (StringUtils.isEmpty(r9) == false) goto L6;
        r16.setResult(null);
        return r16;
    L6:
        LinkedHashMap r5 = new LinkedHashMap();
        Pair<String, String> r17 = UrlUtils.parseUrl(r9, r5);
        if (r17 != null) goto L10;
        r16.setResult(null);
        return r16;
    L10:
        String r18 = (String) r17.first;
        String r4 = (String) r17.second;
        INetworkApi r1 = (INetworkApi) RetrofitUtils.createSsService(r18, INetworkApi.class);
        LinkedList r6 = new LinkedList();
        if (r12 != null) goto L13;
    L18:
        if (r1 == null) goto L36;
        SsResponse<String> r19 = r1.doGet(r11, r8, r4, r5, r6, r15).execute();
        if (r13 == null) goto L35;
        List<com.bytedance.retrofit2.client.Header> r20 = r19.headers();
        if (r20 == null) goto L35;
        if (r20.isEmpty() == true) goto L35;
        Iterator<com.bytedance.retrofit2.client.Header> r21 = r20.iterator();
    L27:
        if (r21.hasNext() == false) goto L35;
        com.bytedance.retrofit2.client.Header r110 = r21.next();
        String r111 = r110.getName();
        if ("ETag".equalsIgnoreCase(r111) == true) goto L34;
        if ("Last-Modified".equalsIgnoreCase(r111) == true) goto L34;
        if ("Cache-Control".equalsIgnoreCase(r111) == false) goto L27;
    L34:
        r13.addHeader(new BasicHeader(r110.getName(), r110.getValue()));
    L35:
        r16.setResult(r19.body());
        r16.setResultCode(r19.code());
    L36:
        return r16;
    L13:
        if (r12.isEmpty() == true) goto L18;
        Iterator<Header> r22 = r12.iterator();
    L16:
        if (r22.hasNext() == false) goto L18;
        Header r112 = r22.next();
        r6.add(new com.bytedance.retrofit2.client.Header(r112.getName(), r112.getValue()));
        goto L16
    }

    @Deprecated
    public static String executePost(int r1, String r2, List<BasicNameValuePair> r3) {
        return executePost(r1, r2, r3, null, null);
    }

    public static byte[] executeRequestForGetPost(String r9, List<BasicNameValuePair> r10, Map<String, String> r11, Map<String, String> r12, IRequestHolder[] r13) {
        if (StringUtils.isEmpty(r9) == true) goto L5;
        LinkedHashMap r0 = new LinkedHashMap();
        Pair<String, String> r14 = UrlUtils.parseUrl(r9, r0);
        if (r14 == null) goto L9;
        String r2 = (String) r14.first;
        String r15 = (String) r14.second;
        INetworkApi r3 = (INetworkApi) RetrofitUtils.createSsService(r2, INetworkApi.class);
        if (r3 == null) goto L13;
        LinkedList r7 = new LinkedList();
        if (r11 != null) goto L17;
    L22:
        if (r10 != null) goto L24;
        final Call<String> r16 = r3.doGet(true, -1, r15, r0, r7, null);
    L31:
        if (r13 != null) goto L33;
    L35:
        SsResponse<String> r17 = r16.execute();
        if (r12 == null) goto L45;
        List<com.bytedance.retrofit2.client.Header> r18 = r17.headers();
        if (r18 == null) goto L45;
        if (r18.size() <= 0) goto L45;
        Iterator<com.bytedance.retrofit2.client.Header> r19 = r18.iterator();
    L43:
        if (r19.hasNext() == false) goto L45;
        com.bytedance.retrofit2.client.Header r110 = r19.next();
        r12.put(r110.getName(), r110.getValue());
    L45:
        String r20 = r17.body();
        if (r20 != null) goto L49;
        return new byte[0];
    L49:
        return r20.getBytes();
    L33:
        if (r13.length <= 0) goto L35;
        r13[0] = new AnonymousClass4(r16);
        goto L35
    L24:
        LinkedHashMap r6 = new LinkedHashMap();
        if (r10.isEmpty() == true) goto L30;
        Iterator<BasicNameValuePair> r111 = r10.iterator();
    L28:
        if (r111.hasNext() == false) goto L30;
        BasicNameValuePair r4 = r111.next();
        r6.put(r4.getName(), r4.getValue());
    L30:
        NetworkParams.putCommonParams(r6, true);
        removeL0Params(r10, r6);
        r16 = r3.doPost(-1, r15, r0, r6, r7, null);
        goto L31
    L17:
        if (r11.isEmpty() == true) goto L22;
        Iterator<Map.Entry<String, String>> r112 = r11.entrySet().iterator();
    L20:
        if (r112.hasNext() == false) goto L22;
        Map.Entry<String, String> r5 = r112.next();
        r7.add(new com.bytedance.retrofit2.client.Header(r5.getKey(), r5.getValue()));
        goto L20
    L13:
        return new byte[0];
    L9:
        return new byte[0];
    L5:
        return new byte[0];
    }

    public static long extractMaxAge(HeaderGroup r7) {
        if (r7 != null) goto L5;
        return -1;
    L5:
        Header r8 = r7.getFirstHeader("Cache-Control");
        if (r8 != null) goto L24;
        return -1;
    L24:
        HeaderElement[] r9 = r8.getElements();     // Catch: Exception -> L18
        if (r9 == null) goto L23;
        int r2 = r9.length;     // Catch: Exception -> L18
        int r3 = 0;
    L11:
        if (r3 >= r2) goto L23;
        HeaderElement r4 = r9[r3];     // Catch: Exception -> L18
        if (ENAME_MAX_AGE.equals(r4.getName()) == true) goto L14;
        r3 = r3 + 1;
        goto L11
    L14:
        String r10 = r4.getValue();     // Catch: Exception -> L18
        if (r10 == null) goto L20;
        return Long.parseLong(r10);
    L20:
        return -1;
    L23:
        return -1;
    L18:
        e = move-exception;
        Logger.w(TAG, "extract max-age exception: " + e);
        goto L23
    }

    public static String filterUrl(String r1) {
        return filterUrl(r1, null);
    }

    public static boolean getAllowKeepAlive() {
        return mAllowKeepAlive;
    }

    public static NetworkParams.ApiRequestInterceptor getApiRequestInterceptor() {
        return NetworkParams.getApiRequestInterceptor();
    }

    public static Context getAppContext() {
        return sAppContext;
    }

    public static String getEtag(HeaderGroup r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        Header r3 = r2.getFirstHeader("ETag");
        if (r3 != null) goto L8;
        return null;
    L8:
        return r3.getValue();
    }

    public static boolean getHasRebuildSsl() {
        return sHasRebuildSsl;
    }

    public static String getLastModified(HeaderGroup r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        Header r3 = r2.getFirstHeader("Last-Modified");
        if (r3 != null) goto L8;
        return null;
    L8:
        return r3.getValue();
    }

    public static String getMacAddress(Context r0) {
        return com.bytedance.common.utility.NetworkUtils.getMacAddress(r0);
    }

    public static String getNetworkAccessType(Context r0) {
        return com.bytedance.common.utility.NetworkUtils.getNetworkAccessType(r0);
    }

    public static String getNetworkOperatorCode(Context r1) {
        return ((TelephonyManager) r1.getSystemService("phone")).getNetworkOperator();
    L4:
        return "unkown";
    }

    public static com.bytedance.common.utility.NetworkUtils.NetworkType getNetworkType(Context r0) {
        return com.bytedance.common.utility.NetworkUtils.getNetworkType(r0);
    }

    public static com.bytedance.common.utility.NetworkUtils.NetworkType getNetworkTypeFast(Context r0) {
        return com.bytedance.common.utility.NetworkUtils.getNetworkTypeFast(r0);
    }

    private static void getOutIp(BaseHttpRequestInfo r4, List<com.bytedance.retrofit2.client.Header> r5, Exception r6) {
        String r0 = null;
        if (r5 == null) goto L15;
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        if (r5.size() <= 0) goto L15;
        Iterator<com.bytedance.retrofit2.client.Header> r7 = r5.iterator();     // Catch: Throwable -> L12
    L8:
        if (r7.hasNext() == false) goto L15;
        com.bytedance.retrofit2.client.Header r1 = r7.next();     // Catch: Throwable -> L12
        if (PNAME_REMOTE_ADDRESS.equalsIgnoreCase(r1.getName()) == false) goto L8;
        r0 = r1.getValue();     // Catch: Throwable -> L12
    L15:
        if (StringUtils.isEmpty(r0) == false) goto L18;
        r0 = RetrofitUtils.getHostAddress(r6);     // Catch: Throwable -> L12
    L18:
        if (StringUtils.isEmpty(r0) == false) goto L20;
        return;
    L20:
        if (r4 == null) goto L34;
        r4.remoteIp = r0;     // Catch: Throwable -> L12
        T r8 = r4.reqContext;     // Catch: Throwable -> L12
        if (r8 == 0) goto L35;
        r8.remoteIp = r0;     // Catch: Throwable -> L12
        return;
    L35:
        return;
    }

    public static boolean getUseDnsMapping() {
        if (sUseDnsMapping == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static String getUserAgent() {
        return NetworkParams.getUserAgent();
    }

    public static boolean is2G(Context r0) {
        return com.bytedance.common.utility.NetworkUtils.is2G(r0);
    }

    public static boolean isNetworkAvailable(Context r0) {
        return com.bytedance.common.utility.NetworkUtils.isNetworkAvailable(r0);
    }

    public static boolean isWifi(Context r0) {
        return com.bytedance.common.utility.NetworkUtils.isWifi(r0);
    }

    private static String joinCommonParams(String r2, List<BasicNameValuePair> r3) {
        if (StringUtils.isEmpty(r2) == true) goto L14;
        if (r3 != null) goto L6;
        return r2;
    L6:
        if (r3.isEmpty() == true) goto L16;
        StringBuilder r0 = new StringBuilder(r2);
        if (r2.indexOf(63) >= 0) goto L11;
        r0.append("?");
    L12:
        r0.append(URLEncodedUtils.format(r3, "UTF-8"));
        return r0.toString();
    L11:
        r0.append("&");
        goto L12
    L16:
        return r2;
    L14:
        return r2;
    }

    public static void monitorApiError(long r0, long r2, String r4, String r5, HttpRequestInfo r6, Throwable r7) {
        NetworkParams.monitorApiError(r0, r2, r4, r5, r6, r7);
    }

    public static void monitorApiSample(long r0, long r2, String r4, String r5, HttpRequestInfo r6) {
        NetworkParams.monitorApiSample(r0, r2, r4, r5, r6);
    }

    public static Pair<String, String> parseContentType(String r7) {
        String r0 = null;
        if (r7 != null) goto L5;
        return null;
    L5:
        HeaderElement[] r8 = new BasicHeader("Content-Type", r7).getElements();
        if (r8.length != 0) goto L8;
        return null;
    L8:
        int r1 = 0;
        HeaderElement r9 = r8[0];
        String r2 = r9.getName();
        NameValuePair[] r10 = r9.getParameters();
        if (r10 == null) goto L17;
        int r3 = r10.length;
    L11:
        if (r1 >= r3) goto L17;
        NameValuePair r4 = r10[r1];
        if ("charset".equalsIgnoreCase(r4.getName()) == true) goto L14;
        r1 = r1 + 1;
        goto L11
    L14:
        r0 = r4.getValue();
    L17:
        return new Pair(r2, r0);
    }

    @Deprecated
    public static String postData(int r5, String r6, String r7, byte[] r8, String r9, Map<String, String> r10, IRequestHolder[] r11, Header... r12) {
        if (StringUtils.isEmpty(r6) == false) goto L5;
        return null;
    L5:
        LinkedHashMap r0 = new LinkedHashMap();
        if (r10 != null) goto L8;
    L13:
        r0.put(r7, new TypedByteArray(null, r8, new String[]{r9}));
        return executePost(r5, r6, r0, r11, r12);
    L8:
        if (r10.isEmpty() == true) goto L13;
        Iterator<Map.Entry<String, String>> r13 = r10.entrySet().iterator();
    L11:
        if (r13.hasNext() == false) goto L13;
        Map.Entry<String, String> r2 = r13.next();
        r0.put(r2.getKey(), new TypedString(r2.getValue()));
        goto L11
    }

    @Deprecated
    public static String postFile(int r5, String r6, String r7, String r8, Map<String, String> r9, IRequestHolder[] r10) {
        if (StringUtils.isEmpty(r6) == false) goto L5;
        return null;
    L5:
        LinkedHashMap r0 = new LinkedHashMap();
        if (r9 != null) goto L8;
    L13:
        r0.put(r7, new TypedFile(null, new File(r8)));
        return executePost(r5, r6, r0, r10, new Header[0]);
    L8:
        if (r9.isEmpty() == true) goto L13;
        Iterator<Map.Entry<String, String>> r11 = r9.entrySet().iterator();
    L11:
        if (r11.hasNext() == false) goto L13;
        Map.Entry<String, String> r2 = r11.next();
        r0.put(r2.getKey(), new TypedString(r2.getValue()));
        goto L11
    }

    public static void putCommonParams(List<BasicNameValuePair> r3, boolean r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        NetworkParams.putCommonParams(r0, r4);
        Iterator r5 = r0.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L13;
        Map.Entry r1 = (Map.Entry) r5.next();
        if (r1 == null) goto L4;
        if (StringUtils.isEmpty((String) r1.getKey()) == true) goto L4;
        if (StringUtils.isEmpty((String) r1.getValue()) == true) goto L4;
        r3.add(new BasicNameValuePair((String) r1.getKey(), (String) r1.getValue()));
        goto L4
    }

    private static void removeL0Params(List<BasicNameValuePair> r8, Map<String, String> r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        if (sPostContainsL0 == true) goto L35;
        String[] r0 = L0_PARAM_LIST;
        int r1 = r0.length;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L36;
        String r4 = r0[r3];
        if (r4 == null) goto L23;
        if (r9.containsKey(r4) == false) goto L23;
        if (r8 != null) goto L13;
    L20:
        boolean r6 = false;
    L21:
        if (r6 == true) goto L23;
        r9.remove(r4);
        goto L23
    L13:
        if (r8.isEmpty() == true) goto L20;
        Iterator<BasicNameValuePair> r5 = r8.iterator();
        r6 = false;
    L16:
        if (r5.hasNext() == false) goto L21;
        if (r4.equals(r5.next().getName()) == false) goto L16;
        r6 = true;
    L23:
        r3 = r3 + 1;
        goto L6
    L36:
        return;
    }

    public static void setAllowKeepAlive(boolean r0) {
        mAllowKeepAlive = r0;
    }

    public static void setApiProcessHook(NetworkParams.ApiProcessHook r0) {
        NetworkParams.setApiProcessHook(r0);
    }

    public static void setApiRequestInterceptor(NetworkParams.ApiRequestInterceptor r0) {
        NetworkParams.setApiRequestInterceptor(r0);
    }

    public static void setAppContext(Context r0) {
        sAppContext = r0;
    }

    public static void setDefaultUserAgent(String r0) {
        NetworkParams.setDefaultUserAgent(r0);
    }

    public static void setHasRebuildSsl(boolean r0) {
        sHasRebuildSsl = r0;
    }

    public static void setMonitorProcessHook(NetworkParams.MonitorProcessHook r0) {
        NetworkParams.setMonitorProcessHook(r0);
    }

    public static void setNetworkTypeInterceptor(NetworkTypeInterceptor r0) {
        sNetworkTypeInterceptor = r0;
    }

    public static void setOldMonitorProcessHook(NetworkParams.OldMonitorProcessHook r0) {
        NetworkParams.setOldMonitorProcessHook(r0);
    }

    public static void setPostContainsL0(boolean r0) {
        sPostContainsL0 = r0;
    }

    public static void setTimeout(URLConnection r1) {
        if (r1 == null) goto L5;
        r1.setConnectTimeout(15000);
        r1.setReadTimeout(15000);
        return;
    }

    public static void setUseDnsMapping(int r0) {
        sUseDnsMapping = r0;
    }

    public static void setUserAgent(HttpParams r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        String r0 = NetworkParams.getUserAgent();
        if (StringUtils.isEmpty(r0) == true) goto L8;
        HttpProtocolParams.setUserAgent(r2, r0);
        return;
    }

    public static Pair<byte[], String> tryCompressData(byte[] r7, com.bytedance.common.utility.NetworkUtils.CompressType r8) {
        String r1 = null;
        if (r7 != null) goto L6;
        new Pair(r7, null);
    L6:
        if (r7 != null) goto L37;
        int r3 = 0;
    L10:
        if (com.bytedance.common.utility.NetworkUtils.CompressType.GZIP != r8) goto L26;
        if (r3 <= 128) goto L26;
        ByteArrayOutputStream r9 = new ByteArrayOutputStream(8192);     // Catch: Throwable -> L16
        GZIPOutputStream r2 = new GZIPOutputStream(r9);     // Catch: Throwable -> L16
        r2.write(r7);     // Catch: Throwable -> L18
        r2.close();     // Catch: Throwable -> L16
        r7 = r9.toByteArray();     // Catch: Throwable -> L16
        r1 = "gzip";
    L36:
        return new Pair(r7, r1);
    L18:
        th = move-exception;
        Logger.w(TAG, "compress with gzip exception: " + th);     // Catch: Throwable -> L22
        Pair<byte[], String> r10 = new Pair(r7, null);     // Catch: Throwable -> L22
        r2.close();     // Catch: Throwable -> L16
        return r10;
    L22:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.printStackTrace();
    L26:
        if (com.bytedance.common.utility.NetworkUtils.CompressType.DEFLATER != r8) goto L36;
        if (r3 <= 128) goto L36;
        ByteArrayOutputStream r11 = new ByteArrayOutputStream(8192);     // Catch: Throwable -> L16
        Deflater r0 = new Deflater();     // Catch: Throwable -> L16
        r0.setInput(r7);     // Catch: Throwable -> L16
        r0.finish();     // Catch: Throwable -> L16
        byte[] r4 = new byte[8192];     // Catch: Throwable -> L16
    L30:
        if (r0.finished() == true) goto L32;
        r11.write(r4, 0, r0.deflate(r4));     // Catch: Throwable -> L16
        goto L30
    L32:
        r0.end();     // Catch: Throwable -> L16
        r7 = r11.toByteArray();     // Catch: Throwable -> L16
        r1 = "deflate";
        goto L36
    L37:
        r3 = r7.length;     // Catch: Throwable -> L16
        goto L10
    }

    public static String tryDnsMapping(String r4, String[] r5) {
        if (sUseDnsMapping > 0) goto L5;
        return r4;
    L5:
        if (r5 != null) goto L7;
    L45:
        return r4;
    L7:
        if (r5.length <= 0) goto L45;
        if (r4 != null) goto L11;
    L13:
        Context r0 = sAppContext;
        if (r0 == null) goto L16;
        com.bytedance.common.utility.NetworkUtils.NetworkType r1 = getNetworkType(r0.getApplicationContext());
    L17:
        if (r1 != null) goto L20;
        return r4;
    L20:
        if (com.bytedance.common.utility.NetworkUtils.NetworkType.WIFI != r1) goto L23;
        int r2 = 1;
    L36:
        if ((r2 & sUseDnsMapping) != 0) goto L38;
        return r4;
    L38:
        NetworkParams.ApiRequestInterceptor r3 = NetworkParams.getApiRequestInterceptor();
        if (r3 == null) goto L45;
        String r6 = r3.tryDnsMapping(r4, r5);
        if (StringUtils.isEmpty(r6) == false) goto L44;
        r5[0] = null;
        return r4;
    L44:
        return r6;
    L23:
        if (com.bytedance.common.utility.NetworkUtils.NetworkType.MOBILE_3G != r1) goto L25;
    L34:
        r2 = 2;
        goto L36
    L25:
        if (com.bytedance.common.utility.NetworkUtils.NetworkType.MOBILE_4G == r1) goto L34;
        if (com.bytedance.common.utility.NetworkUtils.NetworkType.MOBILE != r1) goto L30;
    L33:
        r2 = 4;
        goto L36
    L30:
        if (com.bytedance.common.utility.NetworkUtils.NetworkType.MOBILE_2G == r1) goto L33;
        r2 = 0;
        goto L36
    L16:
        r1 = null;
        goto L17
    L11:
        if (r4.startsWith("https://") == false) goto L13;
        return r4;
    }

    public static CookieManager tryNecessaryInit() {
        return NetworkParams.tryNecessaryInit();
    }

    public byte[] tryGunzipContent(byte[] r1) {
        return null;
    }

    @Deprecated
    public static String executeGet(int r1, String r2, boolean r3) {
        return executeGet(r1, r2, r3, true);
    }

    @Deprecated
    public static String executePost(int r1, String r2, List<BasicNameValuePair> r3, IRequestHolder[] r4) {
        return executePost(r1, r2, r3, r4, null);
    }

    public static String filterUrl(String r0, RequestContext r1) {
        return NetworkParams.filterUrl(r0, r1);
    }

    public static String getNetworkAccessType(com.bytedance.common.utility.NetworkUtils.NetworkType r0) {
        return com.bytedance.common.utility.NetworkUtils.getNetworkAccessType(r0);
    }

    @Deprecated
    public static String executeGet(int r8, String r9, boolean r10, boolean r11) {
        return executeGet(r8, r9, r10, r11, null, null, true, null);
    }

    @Deprecated
    public static String executePost(int r9, String r10, List<BasicNameValuePair> r11, IRequestHolder[] r12, RequestContext r13) {
        if (StringUtils.isEmpty(r10) == false) goto L5;
        return null;
    L5:
        LinkedHashMap r5 = new LinkedHashMap();
        Pair<String, String> r14 = UrlUtils.parseUrl(r10, r5);
        if (r14 != null) goto L8;
        return null;
    L8:
        String r0 = (String) r14.first;
        String r4 = (String) r14.second;
        INetworkApi r2 = (INetworkApi) RetrofitUtils.createSsService(r0, INetworkApi.class);
        LinkedHashMap r6 = new LinkedHashMap();
        if (r11 != null) goto L11;
    L16:
        NetworkParams.putCommonParams(r6, true);
        removeL0Params(r11, r6);
        if (r2 == null) goto L26;
        final Call<String> r15 = r2.doPost(r9, r4, r5, r6, null, r13);
        if (r12 == null) goto L24;
        if (r12.length <= 0) goto L24;
        r12[0] = new AnonymousClass2(r15);
    L24:
        return r15.execute().body();
    L26:
        return null;
    L11:
        if (r11.isEmpty() == true) goto L16;
        Iterator<BasicNameValuePair> r16 = r11.iterator();
    L14:
        if (r16.hasNext() == false) goto L16;
        BasicNameValuePair r1 = r16.next();
        r6.put(r1.getName(), r1.getValue());
        goto L14
    }

    @Deprecated
    public static String executeGet(int r0, String r1, boolean r2, boolean r3, List<Header> r4, HeaderGroup r5, boolean r6, RequestContext r7) {
        NetworkResponseInfo r8 = executeGetResult(r0, r1, r2, r3, r4, r5, r6, r7);
        if (r8 != null) goto L5;
        return null;
    L5:
        return r8.getResult();
    }

    @Deprecated
    public static String postFile(int r3, String r4, String r5, String r6) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put(r5, new TypedFile(null, new File(r6)));
        return executePost(r3, r4, r0, null, new Header[0]);
    }

    @Deprecated
    public static String executePost(int r2, String r3, Map<String, TypedOutput> r4) {
        return executePost(r2, r3, r4, null, new Header[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public static String executePost(int r10, String r11, Map<String, TypedOutput> r12, IRequestHolder[] r13, Header... r14) {
        if (StringUtils.isEmpty(r11) == false) goto L5;
        return null;
    L5:
        LinkedHashMap r5 = new LinkedHashMap();
        Pair<String, String> r15 = UrlUtils.parseUrl(r11, r5);
        if (r15 != null) goto L8;
        return null;
    L8:
        String r0 = (String) r15.first;
        String r4 = (String) r15.second;
        INetworkApi r2 = (INetworkApi) RetrofitUtils.createSsService(r0, INetworkApi.class);
        LinkedList r7 = new LinkedList();
        if (r14 != null) goto L11;
    L15:
        LinkedHashMap r16 = new LinkedHashMap();
        NetworkParams.putCommonParams(r16, true);
        removeL0Params(null, r16);
        if (r16.isEmpty() == true) goto L24;
        Iterator r17 = r16.entrySet().iterator();
    L19:
        if (r17.hasNext() == false) goto L24;
        Map.Entry r1 = (Map.Entry) r17.next();
        if (r1 == null) goto L19;
        r12.put(r1.getKey(), new TypedString((String) r1.getValue()));
    L24:
        if (r2 == null) goto L38;
        final Call<String> r18 = r2.postMultiPart(r10, r4, r5, r12, r7);
        if (r13 == null) goto L31;
        if (r13.length <= 0) goto L31;
        r13[0] = new AnonymousClass3(r18);
    L31:
        return r18.execute().body();
    L38:
        return null;
    L11:
        if (r14.length == 0) goto L15;
        int r3 = r14.length;
        int r6 = 0;
    L13:
        if (r6 >= r3) goto L15;
        Header r8 = r14[r6];
        r7.add(new com.bytedance.retrofit2.client.Header(r8.getName(), r8.getValue()));
        r6 = r6 + 1;
        goto L13
    }

    @Deprecated
    public static String executePost(int r8, String r9, byte[] r10, com.bytedance.common.utility.NetworkUtils.CompressType r11, String r12) {
        if (StringUtils.isEmpty(r9) == false) goto L5;
        return null;
    L5:
        Pair<byte[], String> r13 = tryCompressData(r10, r11);
        if (r13 != null) goto L8;
        return null;
    L8:
        byte[] r14 = (byte[]) r13.first;
        String r15 = (String) r13.second;
        ArrayList r7 = new ArrayList();
        if (r15 == null) goto L11;
        r7.add(new com.bytedance.retrofit2.client.Header("Content-Encoding", r15));
    L11:
        if (r12 != null) goto L13;
    L15:
        LinkedHashMap r5 = new LinkedHashMap();
        Pair<String, String> r16 = UrlUtils.parseUrl(r9, r5);
        if (r16 != null) goto L18;
        return null;
    L18:
        String r17 = (String) r16.first;
        String r4 = (String) r16.second;
        INetworkApi r2 = (INetworkApi) RetrofitUtils.createSsService(r17, INetworkApi.class);
        if (r2 != null) goto L21;
        return null;
    L21:
        return r2.postBody(r8, r4, r5, new TypedByteArray(null, r14, new String[0]), r7).execute().body();
    L13:
        if (r12.length() <= 0) goto L15;
        r7.add(new com.bytedance.retrofit2.client.Header("Content-Type", r12));
        goto L15
    }

    @Deprecated
    public static boolean downloadFile(int r11, String r12, String r13, String r14, String r15, IDownloadPublisher<String> r16, String r17, TaskInfo r18, List<BasicNameValuePair> r19, String[] r20, int[] r21) {
        LinkedList r8 = new LinkedList();
        if (r19 == null) goto L11;
        if (r19.isEmpty() == true) goto L11;
        Iterator<BasicNameValuePair> r0 = r19.iterator();
    L8:
        if (r0.hasNext() == false) goto L11;
        BasicNameValuePair r1 = r0.next();
        r8.add(new com.bytedance.retrofit2.client.Header(r1.getName(), r1.getValue()));
    L11:
        return RetrofitUtils.downloadFile(r11, r12, r13, r14, r15, r16, r17, r18, r8, r20, r21);
    }
}
