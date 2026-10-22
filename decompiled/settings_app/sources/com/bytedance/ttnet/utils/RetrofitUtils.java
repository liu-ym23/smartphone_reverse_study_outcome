package com.bytedance.ttnet.utils;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.connectionclass.CdnDeviceBandwidthSampler;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.parser.CacheControlParser;
import com.bytedance.frameworks.baselib.network.http.parser.MimeType;
import com.bytedance.frameworks.baselib.network.http.parser.StreamParser;
import com.bytedance.frameworks.baselib.network.http.retrofit.RequestVertifyInterceptor;
import com.bytedance.frameworks.baselib.network.http.retrofit.SsHttpExecutor;
import com.bytedance.frameworks.baselib.network.http.retrofit.converter.gson.GsonConverterFactory;
import com.bytedance.frameworks.baselib.network.http.util.IDownloadPublisher;
import com.bytedance.frameworks.baselib.network.http.util.LRUCache;
import com.bytedance.frameworks.baselib.network.http.util.TaskInfo;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.CallAdapter;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.IMetricsCollect;
import com.bytedance.retrofit2.IRequestInfo;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Client;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.INetworkApi;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.http.RequestContext;
import com.bytedance.ttnet.retrofit.SsInterceptor;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.zip.Deflater;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class RetrofitUtils {
    public static final int CONNECT_TIMEOUT = 15000;
    public static final String CONTENT_TYPE_JSON = "application/json; charset=utf-8";
    public static final String HNAME_CACHE_CONTROL = "Cache-Control";
    public static final String HNAME_ETAG = "ETag";
    public static final String HNAME_IF_MODIFIED_SINCE = "If-Modified-Since";
    public static final String HNAME_IF_NONE_MATCH = "If-None-Match";
    public static final String HNAME_LAST_MODIFIED = "Last-Modified";
    public static final int IO_TIMEOUT = 15000;
    public static final String PNAME_REMOTE_ADDRESS = "x-net-info.remoteaddr";
    private static final String TAG = "RetrofitUtils";
    private static volatile CopyOnWriteArrayList<Interceptor> sInterceptors;
    private static LRUCache<String, Retrofit> sOKRetrofitCache;
    private static LRUCache<String, Retrofit> sRetrofitCache;

    public static final enum CompressType extends Enum<CompressType> {
        private static final /* synthetic */ CompressType[] $VALUES = null;
        public static final CompressType DEFLATER = null;
        public static final CompressType GZIP = null;
        public static final CompressType NONE = null;
        final int nativeInt;

        public static CompressType valueOf(String r1) {
            return (CompressType) Enum.valueOf(CompressType.class, r1);
        }

        public static CompressType[] values() {
            return (CompressType[]) $VALUES.clone();
        }

        static {
            CompressType r0 = new CompressType("NONE", 0, 0);
            NONE = r0;
            CompressType r1 = new CompressType("GZIP", 1, 1);
            GZIP = r1;
            CompressType r3 = new CompressType("DEFLATER", 2, 2);
            DEFLATER = r3;
            $VALUES = new CompressType[]{r0, r1, r3};
        }

        private CompressType(String r1, int r2, int r3) {
            super(r1, r2);
            this.nativeInt = r3;
        }
    }

    public RetrofitUtils() {
    }

    private static void getOutIp(BaseHttpRequestInfo r4, String[] r5, List<Header> r6, RequestContext r7, Exception r8) {
        String r0 = null;
        if (r6 == null) goto L13;
    L31:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        if (r6.size() <= 0) goto L13;
        Iterator<Header> r9 = r6.iterator();     // Catch: Throwable -> L31
    L8:
        if (r9.hasNext() == false) goto L13;
        Header r1 = r9.next();     // Catch: Throwable -> L31
        if ("x-net-info.remoteaddr".equalsIgnoreCase(r1.getName()) == false) goto L8;
        r0 = r1.getValue();     // Catch: Throwable -> L31
    L13:
        if (StringUtils.isEmpty(r0) == false) goto L17;
        if (r7 == null) goto L17;
        r0 = r7.remoteIp;     // Catch: Throwable -> L31
    L17:
        if (StringUtils.isEmpty(r0) == false) goto L20;
        r0 = getHostAddress(r8);     // Catch: Throwable -> L31
    L20:
        if (StringUtils.isEmpty(r0) == false) goto L22;
        return;
    L22:
        if (r5 != null) goto L24;
    L26:
        if (r4 == null) goto L41;
        r4.remoteIp = r0;     // Catch: Throwable -> L31
        if (r4.reqContext == 0) goto L42;
        r4.reqContext.remoteIp = r0;     // Catch: Throwable -> L31
        return;
    L42:
        return;
    L41:
        return;
    L24:
        if (r5.length <= 0) goto L26;
        r5[0] = r0;     // Catch: Throwable -> L31
        goto L26
    }

    public static String getHostAddress(Exception r5) {
        if (r5 != null) goto L17;
        return "";
    L17:
        String[] r6 = r5.getMessage().split("\\|");     // Catch: Throwable -> L14
        if (r6 != null) goto L8;
    L16:
        return "";
    L8:
        if (r6.length < 2) goto L16;
        if (Logger.debug() == false) goto L12;
        Logger.d(TAG, "getHostAddress remoteIp = " + r6[0]);     // Catch: Throwable -> L14
    L12:
        return r6[0];
    L14:
        th = move-exception;
        th.printStackTrace();
        goto L16
    }

    public static String getHeaderValueIgnoreCase(List<Header> r2, String r3) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.isEmpty() == false) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(r3) == true) goto L23;
        Iterator<Header> r4 = r2.iterator();
    L10:
        if (r4.hasNext() == false) goto L15;
        Header r0 = r4.next();
        if (r3.equalsIgnoreCase(r0.getName()) == false) goto L10;
        return r0.getValue();
    L15:
        return "";
    L23:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v21 */
    /* JADX WARN: Type inference failed for: r15v22 */
    /* JADX WARN: Type inference failed for: r15v23 */
    /* JADX WARN: Type inference failed for: r15v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r30v0 */
    /* JADX WARN: Type inference failed for: r30v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r30v12 */
    /* JADX WARN: Type inference failed for: r30v13 */
    /* JADX WARN: Type inference failed for: r30v14 */
    /* JADX WARN: Type inference failed for: r30v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r30v4 */
    /* JADX WARN: Type inference failed for: r30v5 */
    /* JADX WARN: Type inference failed for: r40v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r41v1, types: [com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo] */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7, types: [com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo] */
    /* JADX WARN: Type inference failed for: r7v8 */
    @Deprecated
    public static boolean downloadFile(int r33, final String r34, String r35, String r36, String r37, IDownloadPublisher<String> r38, String r39, TaskInfo r40, List<Header> r41, String[] r42, int[] r43) throws Exception {
        String r3 = "Content-Type";
        boolean r7 = false;
        if (StringUtils.isEmpty(r34) == false) goto L5;
        return false;
    L5:
        LinkedHashMap r12 = new LinkedHashMap();
        Pair<String, String> r6 = UrlUtils.parseUrl(r34, r12);
        if (r6 != null) goto L8;
        return false;
    L8:
        String r8 = (String) r6.first;
        String r11 = (String) r6.second;
        INetworkApi r9 = (INetworkApi) createSsService(r8, INetworkApi.class);
        RequestContext r10 = new RequestContext();
        r10.is_need_monitor_in_cancel = false;
        if (r9 == null) goto L192;
        Call<TypedInput> r15 = null;
        final Call<TypedInput> r13 = r9.downloadFile(false, r33, r11, r12, r41, r10);     // Catch: Throwable -> L172
        if (r40 != null) goto L230;
    L224:
    L170:
        th = th;
        InputStream r27 = null;
        r15 = r13;
    L174:
        r7 = false;
    L226:
    L180:
        th = move-exception;
        if (r7 == false) goto L211;
        CdnDeviceBandwidthSampler.getInstance().stopSampling();
    L211:
        StreamParser.safeClose(r27);     // Catch: Throwable -> L188
        if (r15 == null) goto L234;
        r15.cancel();     // Catch: Throwable -> L188
        throw th;
    L234:
        throw th;
    L188:
        th = move-exception;
        th.printStackTrace();
        throw th;
    L176:
        if ((th instanceof Exception) == false) goto L179;
        throw th;     // Catch: Throwable -> L180
    L179:
        throw new Exception(th.getMessage(), th.getCause());     // Catch: Throwable -> L180
    L25:
        if (NetworkUtils.isNetworkAvailable(TTNetInit.getTTNetDepend().getContext()) == false) goto L222;
        long r14 = System.currentTimeMillis();     // Catch: Throwable -> L170
        NetworkParams.CdnConnectionQualitySamplerHook r16 = NetworkParams.getCdnConnectionQualitySamplerHook();     // Catch: Throwable -> L170
        if (r16 != null) goto L36;
    L39:
        boolean r17 = false;
    L216:
        SsResponse<TypedInput> r18 = r13.execute();     // Catch: Throwable -> L166
        if (r18 != null) goto L206;
        if (r17 == false) goto L213;
        CdnDeviceBandwidthSampler.getInstance().stopSampling();
    L213:
        StreamParser.safeClose(null);     // Catch: Throwable -> L48
        if (r13 == null) goto L50;
        r13.cancel();     // Catch: Throwable -> L48
    L50:
        return false;
    L48:
        th = move-exception;
        th.printStackTrace();
        goto L50
    L206:
        long r19 = System.currentTimeMillis();     // Catch: Exception -> L134 Throwable -> L166
        Object r20 = r18.raw().getExtraInfo();     // Catch: Exception -> L132 Throwable -> L166
    L199:
        if ((r20 instanceof BaseHttpRequestInfo) == true) goto L193;
        BaseHttpRequestInfo r21 = null;
    L63:
        if (r21 != null) goto L232;
    L215:
        TypedInput r110 = r18.body();     // Catch: Exception -> L126 Throwable -> L128
        if (r110 == null) goto L72;
        r27 = r110.in();     // Catch: Throwable -> L57 Exception -> L66
    L209:
        List<Header> r111 = r18.headers();     // Catch: Exception -> L124 Throwable -> L164
        String r112 = getHeaderValueIgnoreCase(r111, "X-TT-LOGID");     // Catch: Exception -> L121 Throwable -> L164
        String r30 = getHeaderValueIgnoreCase(r111, "Content-Type");     // Catch: Exception -> L118 Throwable -> L164
        r3 = "Content-Type";
        getOutIp(r21, r42, r111, r10, null);     // Catch: Exception -> L116 Throwable -> L164
        int r4 = r18.code();     // Catch: Exception -> L116 Throwable -> L164
        if (r4 != 200) goto L108;
        if (r110 == null) goto L108;
        long r113 = r110.length();     // Catch: Exception -> L114 Throwable -> L164
        if (r43 != null) goto L85;
    L89:
        boolean r5 = StreamParser.stream2File(r27, r110.length(), new AnonymousClass1(r34, r13), r33, r35, r36, r37, r38, r39, r40);     // Catch: Exception -> L114 Throwable -> L164
        if (r5 == true) goto L92;
    L98:
        if (r17 == false) goto L201;
        CdnDeviceBandwidthSampler.getInstance().stopSampling();
    L201:
        StreamParser.safeClose(r27);     // Catch: Throwable -> L104
        if (r13 == null) goto L106;
        r13.cancel();     // Catch: Throwable -> L104
    L106:
        return r5;
    L104:
        th = move-exception;
        th.printStackTrace();
        goto L106
    L92:
        if ((r13 instanceof IMetricsCollect) == false) goto L94;
        ((IMetricsCollect) r13).doCollect();     // Catch: Exception -> L114 Throwable -> L164
    L94:
        long r114 = System.currentTimeMillis();     // Catch: Exception -> L114 Throwable -> L164
        if (r21 == null) goto L97;
        r21.requestEnd = r114;     // Catch: Exception -> L114 Throwable -> L164
        r21.contentType = SsCronetHttpClient.getContentBaseType(r30);     // Catch: Exception -> L114 Throwable -> L164
    L97:
        NetworkParams.monitorApiSample(r114 - r14, r14, r34, r112, r21);     // Catch: Exception -> L114 Throwable -> L164
        goto L98
    L85:
        if (r43.length <= 0) goto L89;
        r43[0] = 0;     // Catch: Exception -> L114 Throwable -> L164
        if (r113 > 2147483647L) goto L89;
        r43[0] = (int) r113;     // Catch: Exception -> L114 Throwable -> L164
    L108:
        if (r4 != 200) goto L113;
        if (r110 != null) goto L113;
        throw new IllegalArgumentException("HTTP TypedInput may not be null");     // Catch: Exception -> L114 Throwable -> L164
    L113:
        throw new HttpResponseException(r4, "get url = " + r34 + " exception");     // Catch: Exception -> L114 Throwable -> L164
    L114:
        e = e;
    L120:
        String r115 = r112;
        String r31 = r30;
    L123:
        r19 = r19;
        List<Header> r22 = r111;
        ?? r23 = r21;
        ?? r116 = r115;
        ?? r32 = r31;
    L138:
        boolean r24 = StringUtils.isEmpty(r116);     // Catch: Throwable -> L164
        ?? r117 = r116;
        if (r24 == false) goto L141;
        r117 = getHeaderValueIgnoreCase(r22, "X-TT-LOGID");     // Catch: Throwable -> L164
    L141:
        boolean r25 = StringUtils.isEmpty(r32);     // Catch: Throwable -> L164
        ?? r310 = r32;
        if (r25 == false) goto L144;
        r310 = getHeaderValueIgnoreCase(r22, r3);     // Catch: Throwable -> L164
    L144:
        if (r23 != 0) goto L151;
        if ((r13 instanceof IRequestInfo) == false) goto L151;
        Object r26 = ((IRequestInfo) r13).getRequestInfo();     // Catch: Throwable -> L164
        if ((r26 instanceof BaseHttpRequestInfo) == false) goto L151;
        r23 = (BaseHttpRequestInfo) r26;     // Catch: Throwable -> L164
    L151:
        if ((r13 instanceof IMetricsCollect) == false) goto L153;
        ((IMetricsCollect) r13).doCollect();     // Catch: Throwable -> L164
    L153:
        getOutIp(r23, r42, r22, r10, e);     // Catch: Throwable -> L164
        long r2 = System.currentTimeMillis();     // Catch: Throwable -> L164
        if (r23 != 0) goto L156;
    L162:
        NetworkParams.monitorApiError(r2 - r14, r14, r34, r117, r23, e);     // Catch: Throwable -> L164
        throw e;     // Catch: Throwable -> L164
    L156:
        if (r23.completeReadResponse > 0) goto L158;
        r23.completeReadResponse = r19;     // Catch: Throwable -> L164
    L158:
        r23.requestEnd = r2;     // Catch: Throwable -> L164
        if (r23.extraInfo == null) goto L161;
        r23.extraInfo.put(BaseHttpRequestInfo.KEY_EXCEPTION, e.getMessage());     // Catch: Throwable -> L164
    L161:
        r23.contentType = SsCronetHttpClient.getContentBaseType(r310);     // Catch: Throwable -> L164
    L116:
        e = e;
    L118:
        e = e;
        r3 = "Content-Type";
        r30 = null;
    L121:
        e = e;
        r3 = "Content-Type";
        r111 = r111;
        r115 = null;
        r31 = null;
    L124:
        e = e;
        r3 = "Content-Type";
        r22 = null;
        r116 = 0;
        r32 = 0;
        r19 = r19;
        r23 = r21;
    L164:
        th = th;
    L169:
        r15 = r13;
        r7 = r17;
        goto L226
    L57:
        th = th;
        r15 = r13;
        r7 = r17;
        r27 = null;
    L66:
        e = e;
        r22 = null;
        BaseHttpRequestInfo r28 = r21;
    L61:
        r116 = 0;
        r32 = 0;
        r23 = r28;
        goto L138
    L72:
        r27 = null;
        goto L209
    L126:
        e = e;
        r3 = "Content-Type";
        r22 = null;
        List<Header> r118 = null;
        Object r29 = r21;
    L137:
        r32 = r118;
        r23 = r29;
        r116 = r118;
        goto L138
    L232:
        r21.completeReadResponse = r19;     // Catch: Throwable -> L57 Exception -> L66
        goto L215
    L193:
        r21 = (BaseHttpRequestInfo) r20;     // Catch: Throwable -> L57 Exception -> L59
    L59:
        e = e;
        r22 = null;
        r28 = null;
    L128:
        th = th;
        InputStream r44 = null;
    L168:
        r27 = r44;
    L130:
        e = e;
        r22 = null;
    L136:
        List<Header> r45 = r22;
        r118 = r45;
        r29 = r45;
    L132:
        e = e;
        r22 = null;
    L134:
        e = e;
        r22 = null;
        r19 = -1;
    L166:
        th = th;
        r44 = null;
        goto L168
    L36:
        if (r16.cdnShouldSampling(r34) == false) goto L39;
        CdnDeviceBandwidthSampler.getInstance().startSampling();     // Catch: Throwable -> L22
        r17 = true;
    L22:
        th = th;
        r27 = null;
        r15 = r13;
        goto L226
    L222:
        StreamParser.safeClose(null);     // Catch: Throwable -> L30
        if (r13 == null) goto L32;
        r13.cancel();     // Catch: Throwable -> L30
    L32:
        return false;
    L30:
        th = move-exception;
        th.printStackTrace();
        goto L32
    L230:
        if (r40.isCanceled() == false) goto L224;
        StreamParser.safeClose(null);     // Catch: Throwable -> L19
        if (r13 == null) goto L21;
        r13.cancel();     // Catch: Throwable -> L19
    L21:
        return false;
    L19:
        th = move-exception;
        th.printStackTrace();
    L172:
        th = th;
        r27 = null;
        goto L174
    L192:
        return false;
    }

    public static Pair<byte[], String> tryCompressData(byte[] r6, CompressType r7) throws IOException {
        byte[] r1 = null;
        if (r6 != null) goto L5;
        return null;
    L5:
        int r2 = r6.length;
        if (CompressType.GZIP != r7) goto L19;
        if (r2 <= 128) goto L19;
        ByteArrayOutputStream r8 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r3 = new GZIPOutputStream(r8);
        r3.write(r6);     // Catch: Throwable -> L11
        r3.close();
        r1 = r8.toByteArray();
        String r9 = "gzip";
    L28:
        return new Pair(r1, r9);
    L11:
        th = move-exception;
        Logger.w(TAG, "compress with gzip exception: " + th);     // Catch: Throwable -> L15
        r3.close();
        return null;
    L15:
        th = move-exception;
        r3.close();
        throw th;
    L19:
        if (CompressType.DEFLATER != r7) goto L26;
        if (r2 <= 128) goto L26;
        ByteArrayOutputStream r10 = new ByteArrayOutputStream(8192);
        Deflater r0 = new Deflater();
        r0.setInput(r6);
        r0.finish();
        byte[] r11 = new byte[8192];
    L23:
        if (r0.finished() == true) goto L25;
        r10.write(r11, 0, r0.deflate(r11));
        goto L23
    L25:
        r0.end();
        r1 = r10.toByteArray();
        r9 = "deflate";
    L26:
        r9 = null;
        goto L28
    }

    public static void addCacheValidationHeaders(List<Header> r2, String r3, String r4) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (StringUtils.isEmpty(r3) == true) goto L8;
        r2.add(new Header("If-None-Match", r3));
    L8:
        if (StringUtils.isEmpty(r4) == true) goto L11;
        r2.add(new Header("If-Modified-Since", r4));
        return;
    }

    public static Pair<String, String> parseContentType(String r3) {
        String r0 = null;
        if (r3 != null) goto L17;
        return null;
    L17:
        MimeType r1 = new MimeType(r3);     // Catch: Throwable -> L10
        String r4 = r1.getBaseType();     // Catch: Throwable -> L10
        r0 = r1.getParameter("charset");     // Catch: Throwable -> L8
    L14:
        return new Pair(r4, r0);
    L8:
        th = th;
    L12:
        th.printStackTrace();
    L10:
        th = th;
        r4 = null;
        goto L12
    }

    public static String getEtag(List<Header> r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        Header r3 = getFirstHeader(r2, "ETag");
        if (r3 != null) goto L8;
        return null;
    L8:
        return r3.getValue();
    }

    public static String getLastModified(List<Header> r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        Header r3 = getFirstHeader(r2, "Last-Modified");
        if (r3 != null) goto L8;
        return null;
    L8:
        return r3.getValue();
    }

    public static Header getFirstHeader(List<Header> r3, String r4) {
        if (r3 != null) goto L5;
    L13:
        return null;
    L5:
        if (StringUtils.isEmpty(r4) == true) goto L13;
        Iterator<Header> r5 = r3.iterator();
    L9:
        if (r5.hasNext() == false) goto L13;
        Header r1 = r5.next();
        if (r4.equalsIgnoreCase(r1.getName()) == false) goto L9;
        return r1;
    }

    public static long extractMaxAge(List<Header> r4) {
        if (r4 != null) goto L5;
        return -1;
    L5:
        Header r5 = getFirstHeader(r4, "Cache-Control");
        if (r5 != null) goto L15;
        return -1;
    L15:
        String r6 = new CacheControlParser(r5.getValue()).getValue(CacheControlParser.Directive.MAXAGE);     // Catch: Exception -> L12
        if (r6 == null) goto L17;
        return Long.parseLong(r6);
    L17:
        return -1;
    L12:
        e = move-exception;
        Logger.w(TAG, "extract max-age exception: " + e);
        return -1;
    }

    public static void setTimeout(URLConnection r1) {
        if (r1 == null) goto L5;
        r1.setConnectTimeout(15000);
        r1.setReadTimeout(15000);
        return;
    }

    static {
        sInterceptors = new CopyOnWriteArrayList();
        Retrofit.setCommonInterceptor(sInterceptors);
        sRetrofitCache = new LRUCache(10);
        sOKRetrofitCache = new LRUCache(10);
    }

    public static synchronized void addInterceptor(Interceptor r2) {
        monitor-enter(RetrofitUtils.class);
        if (r2 != null) goto L16;
        monitor-exit(RetrofitUtils.class);
        return;
    L16:
    L13:
        th = move-exception;
        throw th;
    L8:
        if (sInterceptors.contains(r2) == true) goto L10;
        sInterceptors.add(r2);     // Catch: Throwable -> L13
    L10:
        TtnetUtil.safeAddInterceptorInRetrofitCache(sRetrofitCache, r2);     // Catch: Throwable -> L13
        TtnetUtil.safeAddInterceptorInRetrofitCache(sOKRetrofitCache, r2);     // Catch: Throwable -> L13
        monitor-exit(RetrofitUtils.class);
    }

    public static synchronized void removeInterceptor(Interceptor r2) {
        monitor-enter(RetrofitUtils.class);
        if (r2 != null) goto L17;
        monitor-exit(RetrofitUtils.class);
        return;
    L17:
    L14:
        th = move-exception;
        throw th;
    L8:
        if (sInterceptors.contains(r2) == true) goto L11;
        monitor-exit(RetrofitUtils.class);
        return;
    L11:
        sInterceptors.remove(r2);     // Catch: Throwable -> L14
        TtnetUtil.safeRemoveInterceptorInRetrofitCache(sRetrofitCache, r2);     // Catch: Throwable -> L14
        TtnetUtil.safeRemoveInterceptorInRetrofitCache(sOKRetrofitCache, r2);     // Catch: Throwable -> L14
        monitor-exit(RetrofitUtils.class);
    }

    public static synchronized Retrofit getSsRetrofit(String r3) {
        monitor-enter(RetrofitUtils.class);
    L16:
        th = move-exception;
        throw th;
    L6:
        if (StringUtils.isEmpty(r3) == false) goto L9;
        monitor-exit(RetrofitUtils.class);
        return null;
    L9:
        Retrofit r1 = sRetrofitCache.get(r3);     // Catch: Throwable -> L16
        if (r1 == null) goto L13;
        monitor-exit(RetrofitUtils.class);
        return r1;
    L13:
        Retrofit r2 = createSsRetrofit(r3, null, null, null);     // Catch: Throwable -> L16
        sRetrofitCache.put(r3, r2);     // Catch: Throwable -> L16
        monitor-exit(RetrofitUtils.class);
        return r2;
    }

    public static synchronized Retrofit createSsRetrofit(String r2, List<Interceptor> r3, Converter.Factory r4) {
        monitor-enter(RetrofitUtils.class);
        Retrofit r5 = createSsRetrofit(r2, r3, r4, null);     // Catch: Throwable -> L8
        monitor-exit(RetrofitUtils.class);
        return r5;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized Retrofit createSsRetrofit(String r2, List<Interceptor> r3, Converter.Factory r4, CallAdapter.Factory r5) {
        monitor-enter(RetrofitUtils.class);
        Retrofit r6 = createRetrofit(r2, r3, r4, r5, new AnonymousClass2());     // Catch: Throwable -> L7
        monitor-exit(RetrofitUtils.class);
        return r6;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized Retrofit createTTNetRetrofit(String r2, List<Interceptor> r3, List<Converter.Factory> r4, List<CallAdapter.Factory> r5) {
        monitor-enter(RetrofitUtils.class);
        Retrofit r6 = createRetrofit(r3, r4, r5, new AnonymousClass3(), r2);     // Catch: Throwable -> L7
        monitor-exit(RetrofitUtils.class);
        return r6;
    L7:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public static synchronized Retrofit getOkRetrofit(String r3) {
        monitor-enter(RetrofitUtils.class);
    L16:
        th = move-exception;
        throw th;
    L6:
        if (StringUtils.isEmpty(r3) == false) goto L9;
        monitor-exit(RetrofitUtils.class);
        return null;
    L9:
        Retrofit r1 = sOKRetrofitCache.get(r3);     // Catch: Throwable -> L16
        if (r1 == null) goto L13;
        monitor-exit(RetrofitUtils.class);
        return r1;
    L13:
        Retrofit r2 = createOkRetrofit(r3, null, null, null);     // Catch: Throwable -> L16
        sOKRetrofitCache.put(r3, r2);     // Catch: Throwable -> L16
        monitor-exit(RetrofitUtils.class);
        return r2;
    }

    @Deprecated
    public static synchronized Retrofit createOkRetrofit(String r2, List<Interceptor> r3, Converter.Factory r4, CallAdapter.Factory r5) {
        monitor-enter(RetrofitUtils.class);
        Retrofit r6 = createRetrofit(r2, r3, r4, r5, new AnonymousClass4());     // Catch: Throwable -> L7
        monitor-exit(RetrofitUtils.class);
        return r6;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized Retrofit createRetrofit(String r3, List<Interceptor> r4, Converter.Factory r5, CallAdapter.Factory r6, Client.Provider r7) {
        monitor-enter(RetrofitUtils.class);
        ArrayList r1 = null;
        if (r5 != null) goto L17;
        ArrayList r2 = null;
    L10:
        if (r6 == null) goto L12;
        r1 = new ArrayList();     // Catch: Throwable -> L7
        r1.add(r6);     // Catch: Throwable -> L7
    L12:
        Retrofit r8 = createRetrofit(r4, r2, r1, r7, r3);     // Catch: Throwable -> L7
        monitor-exit(RetrofitUtils.class);
        return r8;
    L7:
        th = move-exception;
        throw th;
    L17:
        r2 = new ArrayList();     // Catch: Throwable -> L7
        r2.add(r5);     // Catch: Throwable -> L7
        goto L10
    }

    public static synchronized Retrofit createRetrofit(List<Interceptor> r3, List<Converter.Factory> r4, List<CallAdapter.Factory> r5, Client.Provider r6, String r7) {
        monitor-enter(RetrofitUtils.class);
        if (r6 == null) goto L56;
    L6:
        Retrofit.Builder r8 = new Retrofit.Builder().setEndpoint(r7).client(r6).httpExecutor(new SsHttpExecutor());     // Catch: Throwable -> L53
        if (r4 != null) goto L10;
        r4 = new ArrayList();     // Catch: Throwable -> L53
    L10:
        if (r4.isEmpty() == false) goto L12;
        r4.add(GsonConverterFactory.create());     // Catch: Throwable -> L53
    L12:
        Iterator<Converter.Factory> r9 = r4.iterator();     // Catch: Throwable -> L53
    L14:
        if (r9.hasNext() == false) goto L16;
        r8.addConverterFactory(r9.next());     // Catch: Throwable -> L53
        goto L14
    L16:
        if (r5 != null) goto L18;
    L23:
        LinkedList r10 = new LinkedList();     // Catch: Throwable -> L53
        if (r3 != null) goto L26;
    L38:
        boolean r11 = false;
    L39:
        if (r11 == true) goto L42;
        r10.add(0, new SsInterceptor());     // Catch: Throwable -> L53
    L42:
        if (sInterceptors != null) goto L44;
    L46:
        r10.add(new RequestVertifyInterceptor());     // Catch: Throwable -> L53
        Iterator r12 = r10.iterator();     // Catch: Throwable -> L53
    L48:
        if (r12.hasNext() == false) goto L50;
        r8.addInterceptor((Interceptor) r12.next());     // Catch: Throwable -> L53
        goto L48
    L50:
        Retrofit r13 = r8.build();     // Catch: Throwable -> L53
        monitor-exit(RetrofitUtils.class);
        return r13;
    L53:
        th = move-exception;
        throw th;
    L44:
        if (sInterceptors.size() <= 0) goto L46;
        r10.addAll(sInterceptors);     // Catch: Throwable -> L53
        goto L46
    L26:
        if (r3.size() <= 0) goto L38;
        Iterator<Interceptor> r14 = r3.iterator();     // Catch: Throwable -> L53
        r11 = false;
    L29:
        if (r14.hasNext() == false) goto L39;
        Interceptor r1 = r14.next();     // Catch: Throwable -> L53
        if ((r1 instanceof SsInterceptor) == true) goto L32;
        if ((r1 instanceof RequestVertifyInterceptor) == true) goto L29;
    L37:
        r10.add(r1);     // Catch: Throwable -> L53
        goto L29
    L32:
        if (r11 == true) goto L29;
        r10.add(r1);     // Catch: Throwable -> L53
        r11 = true;
        goto L37
    L18:
        if (r5.isEmpty() == true) goto L23;
        Iterator<CallAdapter.Factory> r15 = r5.iterator();     // Catch: Throwable -> L53
    L21:
        if (r15.hasNext() == false) goto L23;
        r8.addCallAdapterFactory(r15.next());     // Catch: Throwable -> L53
        goto L21
    L56:
        r6 = new AnonymousClass5();     // Catch: Throwable -> L53
        goto L6
    }

    public static synchronized <S> S createSsService(String r1, Class<S> r2) {
        monitor-enter(RetrofitUtils.class);
        S r3 = (S) createService(getSsRetrofit(r1), r2);
        monitor-exit(RetrofitUtils.class);
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized <S> S createOkService(String r1, Class<S> r2) {
        monitor-enter(RetrofitUtils.class);
        S r3 = (S) createService(getOkRetrofit(r1), r2);
        monitor-exit(RetrofitUtils.class);
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized <S> S createService(Retrofit r1, Class<S> r2) {
        monitor-enter(RetrofitUtils.class);
        if (r1 != null) goto L14;
        monitor-exit(RetrofitUtils.class);
        return null;
    L14:
        S r3 = (S) r1.create(r2);
        monitor-exit(RetrofitUtils.class);
        return r3;
    L8:
        th = move-exception;
        throw th;
    }
}
