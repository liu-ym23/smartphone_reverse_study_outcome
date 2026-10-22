package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.IHttpClient;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.RequestRetryResult;
import com.bytedance.frameworks.baselib.network.http.cronet.ConstantsDefined;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetThreadConfig;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.frameworks.baselib.network.http.parser.MimeType;
import com.bytedance.frameworks.baselib.network.http.parser.StreamParser;
import com.bytedance.frameworks.baselib.network.http.retrofit.SsHttpExecutor;
import com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionManager;
import com.bytedance.frameworks.baselib.network.queryfilter.QueryFilterEngine;
import com.bytedance.platform.godzilla.common.Constant;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.retrofit2.mime.AbsTypedOutput;
import com.bytedance.retrofit2.mime.TTRequestCompressManager;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.loopj.android.http.RequestParams;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UnknownFormatConversionException;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.math3.geometry.VectorFormat;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class SsCronetHttpClient implements IHttpClient, ICronetClient.ICronetBootFailureChecker {
    private static final int CHUNK_SIZE = 4096;
    private static final String CONCURRENT_NO_RETRY_SWITCH = "no_retry=1";
    private static final String CRONET_CLIENT_CLASS = "org.chromium.CronetClient";
    private static final int CRONET_INPUTSTREAM_BUFF_SIZE_MAX = 20971520;
    private static final int CRONET_INPUTSTREAM_BUFF_SIZE_MIN = 8192;
    private static final int CRONET_OUTPUTSTREAM_BUFF_SIZE_MAX = 10485760;
    private static final int CRONET_OUTPUTSTREAM_BUFF_SIZE_MIN = 16384;
    private static final String INTERNET_DISCONNECTED = "net::ERR_INTERNET_DISCONNECTED";
    private static final String KEY_CRONET_INPUTSTREAM_BUFF_SIZE = "cronet_inputstream_buff_size";
    private static final String KEY_CRONET_OUTPUTSTREAM_BUFF_SIZE = "post_body_buffer_size";
    private static final String KEY_REQUEST_LOG = "request_log";
    public static final String TAG = "SsCronetHttpClient";
    private static final String USE_TTNET_CONTENT_ENCODING = "x-metasec-content-encoding";
    private static volatile boolean sBypassOfflineCheckEnabled = true;
    private static Context sContext = null;
    private static volatile ICronetAppProvider sCronetAppProvider = null;
    private static ICronetBootFailureChecker sCronetBootFailureChecker = null;
    private static ICronetClient sCronetClient = null;
    private static ICronetHttpDnsConfig sCronetHttpDnsConfig = null;
    private static volatile int sCronetInputstreamBuffSize = 0;
    private static ConcurrentHashMap<String, Integer> sCronetOutputStreamBufferMap = null;
    private static ITncInfoGet sCronetTncInfoGet = null;
    private static String sCustomCronetClientClass = "";
    private static volatile SsCronetHttpClient sInstance;
    private static volatile String sPostBodyBufferConfig;

    public interface ICronetBootFailureChecker {
        boolean isCronetBootFailureExpected();
    }

    public interface ICronetHttpDnsConfig {
        boolean isCronetHttpDnsOpen();
    }

    public interface ITncInfoGet {
        JSONObject getABTest();
    }

    protected static boolean isCronetInputStreamSizeValid(int r1) {
        if (r1 >= 8192) goto L5;
    L7:
        return false;
    L5:
        if (r1 > CRONET_INPUTSTREAM_BUFF_SIZE_MAX) goto L7;
        return true;
    }

    private static boolean isValidCronetOutputstreamBufferSize(int r1) {
        if (r1 >= 16384) goto L5;
    L7:
        return false;
    L5:
        if (r1 > CRONET_OUTPUTSTREAM_BUFF_SIZE_MAX) goto L7;
        return true;
    }

    public void setHttpDnsForTesting(boolean r1, boolean r2, boolean r3) throws Exception {
    }

    static {
        sCronetOutputStreamBufferMap = new ConcurrentHashMap();
    }

    public static void setCronetAppInfoProvider(ICronetAppProvider r0) {
        sCronetAppProvider = r0;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient.ICronetBootFailureChecker
    public boolean isCronetBootFailureExpected() {
        ICronetBootFailureChecker r0 = sCronetBootFailureChecker;
        if (r0 != null) goto L6;
        return false;
    L6:
        return r0.isCronetBootFailureExpected();
    }

    public static void setCronetBootFailureChecker(ICronetBootFailureChecker r0) {
        sCronetBootFailureChecker = r0;
    }

    public static void setCronetHttpDnsConfig(ICronetHttpDnsConfig r0) {
        sCronetHttpDnsConfig = r0;
    }

    public static void setCronetTncInfoGet(ITncInfoGet r0) {
        sCronetTncInfoGet = r0;
    }

    public static void setCustomCronetClientClass(String r0) {
        sCustomCronetClientClass = r0;
    }

    public static SsCronetHttpClient inst(Context r2) {
        if (sInstance != null) goto L15;
        monitor-enter(SsCronetHttpClient.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SsCronetHttpClient(r2);     // Catch: Throwable -> L11
        tryResolveImpl();     // Catch: Throwable -> L11
    L9:
        monitor-exit(SsCronetHttpClient.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private static void updatePostBodyBufferConfig(JSONObject r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        sCronetOutputStreamBufferMap.clear();
        Iterator<String> r0 = r4.keys();
    L6:
        if (r0.hasNext() == false) goto L12;
        String r1 = r0.next();
        int r2 = r4.optInt(r1);
        if (TextUtils.isEmpty(r1) == true) goto L6;
        if (isValidCronetOutputstreamBufferSize(r2) == false) goto L6;
        sCronetOutputStreamBufferMap.put(r1, Integer.valueOf(r2));
        goto L6
    }

    public static void tryUpdateBodyBufferSizeConfig(JSONObject r5, SharedPreferences r6) {
        if (r5 == null) goto L9;
        sCronetInputstreamBuffSize = r5.optInt(KEY_CRONET_INPUTSTREAM_BUFF_SIZE, 0);
        JSONObject r7 = r5.optJSONObject(KEY_CRONET_OUTPUTSTREAM_BUFF_SIZE);     // Catch: Throwable -> L15
        if (r7 == null) goto L8;
        updatePostBodyBufferConfig(r7);     // Catch: Throwable -> L15
        sPostBodyBufferConfig = r7.toString();     // Catch: Throwable -> L15
    L19:
        goto L9
    L8:
        sCronetOutputStreamBufferMap.clear();     // Catch: Throwable -> L15
        sPostBodyBufferConfig = "";     // Catch: Throwable -> L15
    L9:
        if (r6 == null) goto L22;
        sCronetInputstreamBuffSize = r6.getInt(KEY_CRONET_INPUTSTREAM_BUFF_SIZE, 0);
        String r8 = r6.getString(KEY_CRONET_OUTPUTSTREAM_BUFF_SIZE, "");
        if (TextUtils.isEmpty(r8) == false) goto L17;
        return;
    L17:
        updatePostBodyBufferConfig(new JSONObject(r8));     // Catch: Throwable -> L16
        return;
    L23:
        return;
    }

    public static void onSaveConfigToSP(SharedPreferences.Editor r2) {
        r2.putInt(KEY_CRONET_INPUTSTREAM_BUFF_SIZE, sCronetInputstreamBuffSize);
        if (sPostBodyBufferConfig == null) goto L6;
        r2.putString(KEY_CRONET_OUTPUTSTREAM_BUFF_SIZE, sPostBodyBufferConfig);
        return;
    }

    protected static boolean isForceHandleResponse(BaseHttpRequestInfo r1) {
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

    protected static boolean isForceConstructResponse(BaseHttpRequestInfo r1) {
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

    private static void tryResolveImpl() {
        if (sCronetClient == null) goto L5;
        return;
    L5:
        if (StringUtils.isEmpty(sCustomCronetClientClass) == true) goto L7;
        String r0 = sCustomCronetClientClass;
    L8:
        Logger.w(TAG, "tryResolveImpl:" + r0);
        Object r1 = Class.forName(r0).newInstance();     // Catch: Throwable -> L13
        if ((r1 instanceof ICronetClient) == false) goto L19;
        sCronetClient = (ICronetClient) r1;     // Catch: Throwable -> L13
        return;
    L19:
        return;
    L13:
        th = move-exception;
        Logger.w(TAG, "load CronetClient exception: " + th);
        return;
    L7:
        r0 = CRONET_CLIENT_CLASS;
        goto L8
    }

    private SsCronetHttpClient(Context r1) {
        sContext = r1.getApplicationContext();
    }

    public void tryCreateCronetEngine(boolean r12, boolean r13, boolean r14, boolean r15, boolean r16, ICronetAppProvider r17) {
        tryResolveImpl();
        ICronetClient r0 = sCronetClient;
        if (r0 == null) goto L6;
        r0.setCronetBootFailureChecker(this);
        sCronetClient.tryCreateCronetEngine(sContext, r12, r13, r14, r15, NetworkParams.getUserAgent(), new SsHttpExecutor(), r16, r17);
        return;
    }

    public void triggerGetDomain(boolean r7) {
        ICronetClient r6 = sCronetClient;     // Catch: Throwable -> L10
        if (r6 != null) goto L5;
        return;
    L5:
        if (sContext == null) goto L15;
        Reflect.on(r6).call("triggerGetDomain", new Class[]{Context.class, Boolean.TYPE}, new Object[]{sContext, Boolean.valueOf(r7)});     // Catch: Throwable -> L10
        return;
    L15:
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void runInBackGround(boolean r7) {
        ICronetClient r6 = sCronetClient;     // Catch: Throwable -> L10
        if (r6 != null) goto L5;
        return;
    L5:
        if (sContext == null) goto L15;
        Reflect.on(r6).call("runInBackGround", new Class[]{Context.class, Boolean.TYPE}, new Object[]{sContext, Boolean.valueOf(r7)});     // Catch: Throwable -> L10
        return;
    L15:
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void addClientOpaqueData(String[] r12, byte[] r13, byte[] r14, long r15, long r17) {
        ICronetClient r1 = sCronetClient;     // Catch: Throwable -> L11
        if (r1 != null) goto L6;
        return;
    L6:
        if (sContext == null) goto L16;
        Reflect.on(r1).call("addClientOpaqueData", new Class[]{Context.class, String[].class, byte[].class, byte[].class, Long.TYPE, Long.TYPE}, new Object[]{sContext, r12, r13, r14, Long.valueOf(r15), Long.valueOf(r17)});     // Catch: Throwable -> L11
        return;
    L16:
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
    }

    public void clearClientOpaqueData() {
        ICronetClient r5 = sCronetClient;     // Catch: Throwable -> L10
        if (r5 != null) goto L5;
        return;
    L5:
        if (sContext == null) goto L15;
        Reflect.on(r5).call("clearClientOpaqueData", new Class[]{Context.class}, new Object[]{sContext});     // Catch: Throwable -> L10
        return;
    L15:
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void removeClientOpaqueData(String r7) {
        ICronetClient r6 = sCronetClient;     // Catch: Throwable -> L10
        if (r6 != null) goto L5;
        return;
    L5:
        if (sContext == null) goto L15;
        Reflect.on(r6).call("removeClientOpaqueData", new Class[]{Context.class, String.class}, new Object[]{sContext, r7});     // Catch: Throwable -> L10
        return;
    L15:
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public static TTDispatchResult ttUrlDispatch(String r12, int r13) throws Exception {
        ICronetClient r0 = sCronetClient;
        if (r0 == null) goto L16;
        String[] r14 = (String[]) Reflect.on(r0).call("ttUrlDispatch", new Class[]{String.class, Integer.TYPE}, new Object[]{r12, Integer.valueOf(r13)}).get();
        if (r14.length != 3) goto L14;
        if (TextUtils.isEmpty(r14[0]) == true) goto L14;
        new URL(r14[0]).toURI();     // Catch: Exception -> L11
        return new TTDispatchResult(r12, r14[0], r14[1], r14[2], TTDispatchResult.DispatchState.SUCCESS);
    L11:
        e = move-exception;
        throw e;
    L14:
        throw new UnknownFormatConversionException("ttUrlDispatch returns wrong format");
    L16:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public void preconnectUrl(String r6, Map<String, String> r7) throws Exception {
        ICronetClient r5 = sCronetClient;
        if (r5 == null) goto L7;
        Reflect.on(r5).call("preconnectUrl", new Class[]{String.class, Map.class}, new Object[]{r6, r7}).get();
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public void tryStartNetDetect(String[] r7, int r8, int r9) throws Exception {
        ICronetClient r6 = sCronetClient;
        if (r6 == null) goto L7;
        Reflect.on(r6).call("tryStartNetDetect", new Class[]{String[].class, Integer.TYPE, Integer.TYPE}, new Object[]{r7, Integer.valueOf(r8), Integer.valueOf(r9)}).get();
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public void ttDnsResolve(String r8, int r9, String r10, Map<String, String> r11) throws Exception {
        ICronetClient r7 = sCronetClient;
        if (r7 == null) goto L7;
        Reflect.on(r7).call("ttDnsResolve", new Class[]{String.class, Integer.TYPE, String.class, Map.class}, new Object[]{r8, Integer.valueOf(r9), r10, r11}).get();
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    private void checkCronetClientCreated() {
        if (sCronetClient == null) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public void getMappingRequestState(String r5) {
        checkCronetClientCreated();
        Reflect.on(sCronetClient).call("getMappingRequestState", new Class[]{String.class}, new Object[]{r5}).get();
    }

    public int getEffectiveConnectionType() throws Exception {
        checkCronetClientCreated();
        return ((Integer) Reflect.on(sCronetClient).call("getEffectiveConnectionType").get()).intValue();
    }

    public void notifyTNCConfigUpdated(String r10, String r11, String r12, String r13, String r14, String r15) throws Exception {
        checkCronetClientCreated();
        Reflect.on(sCronetClient).call("notifyTNCConfigUpdated", new Class[]{String.class, String.class, String.class, String.class, String.class, String.class}, new Object[]{r10, r11, r12, r13, r14, r15}).get();
    }

    public static void notifyStoreRegionUpdated(String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23) throws Exception {
        ICronetClient r0 = sCronetClient;
        if (r0 == null) goto L7;
        Reflect.on(r0).call("notifyStoreRegionUpdated", new Class[]{String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class}, new Object[]{r14, r15, r16, r17, r18, r19, r20, r21, r22, r23}).get();
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public void setProxy(String r5) throws Exception {
        checkCronetClientCreated();
        Reflect.on(sCronetClient).call("setProxy", new Class[]{String.class}, new Object[]{r5}).get();
    }

    public NetworkQuality getNetworkQuality() throws Exception {
        checkCronetClientCreated();
        int[] r2 = (int[]) Reflect.on(sCronetClient).call("getNetworkQuality").get();
        if (r2.length != 3) goto L7;
        NetworkQuality r0 = new NetworkQuality();
        r0.transportRttMs = r2[0];
        r0.httpRttMs = r2[1];
        r0.downstreamThroughputKbps = r2[2];
        return r0;
    L7:
        throw new UnknownFormatConversionException("getNetworkQuality returns wrong format");
    }

    public PacketLossMetrics getPacketLossRateMetrics(int r5) throws Exception {
        checkCronetClientCreated();
        return (PacketLossMetrics) Reflect.on(sCronetClient).call("getPacketLossRateMetrics", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r5)}).get();
    }

    public Map<String, NetworkQuality> getGroupRttEstimates() throws Exception {
        checkCronetClientCreated();
        HashMap r5 = new HashMap();
        Iterator r0 = ((Map) Reflect.on(sCronetClient).call("getGroupRTTEstimates").get()).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) r0.next();
        if (((int[]) r1.getValue()).length != 2) goto L9;
        NetworkQuality r2 = new NetworkQuality();
        r2.transportRttMs = ((int[]) r1.getValue())[0];
        r2.httpRttMs = ((int[]) r1.getValue())[1];
        r2.downstreamThroughputKbps = -1;
        r5.put((String) r1.getKey(), r2);
        goto L4
    L9:
        throw new UnknownFormatConversionException("getGroupRttEstimates returns wrong format");
    L10:
        return r5;
    }

    public String getCronetVersion() throws Exception {
        checkCronetClientCreated();
        return (String) Reflect.on(sCronetClient).call("getCronetVersion").get();
    }

    public void setHostResolverRules(String r5) throws Exception {
        checkCronetClientCreated();
        Reflect.on(sCronetClient).call("setHostResolverRules", new Class[]{String.class}, new Object[]{r5});
    }

    @Override // com.bytedance.retrofit2.client.Client
    public SsCall newSsCall(Request r6) throws IOException {
        long r0 = SystemClock.uptimeMillis();
        Request r5 = QueryFilterEngine.inst().filterQuery(r6);
        if (r6.getMetrics() == null) goto L5;
        RetrofitMetrics r2 = r6.getMetrics();
        r2.queryFilterDuration = SystemClock.uptimeMillis() - r0;
    L5:
        if (r5 == null) goto L8;
        r6 = r5;
    L8:
        if (CronetSsCallConfig.inst().isConcurrentRequestEnabled() == false) goto L20;
        if (r6.getUrl().contains(CONCURRENT_NO_RETRY_SWITCH) == true) goto L20;
        CronetSsCallConfig.UrlMatchRule r7 = CronetSsCallConfig.inst().getUrlMatchRuleFromRequest(r6);
        if (r7 == null) goto L20;
        if (r7.getDomainList() == null) goto L20;
        if (r7.getDomainList().size() < 2) goto L20;
        return new ConcurrentCronetSsCall(r6, r7);
    L20:
        return new CronetSsCall(r6, sCronetClient);
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
        if (r5 != null) goto L20;
        return "";
    L20:
        String r6 = r5.getMessage();     // Catch: Throwable -> L17
        if (r6 != null) goto L8;
        return "";
    L8:
        String[] r7 = r6.split("\\|");     // Catch: Throwable -> L17
        if (r7 != null) goto L11;
    L19:
        return "";
    L11:
        if (r7.length < 2) goto L19;
        if (Logger.debug() == false) goto L15;
        Logger.d(TAG, "getHostAddress remoteIp = " + r7[0]);     // Catch: Throwable -> L17
    L15:
        return r7[0];
    L17:
        th = move-exception;
        th.printStackTrace();
        goto L19
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

    protected static void getRequestMetrics(HttpURLConnection r7, BaseHttpRequestInfo r8, RetrofitMetrics r9) {
        if (r8 != null) goto L5;
        return;
    L5:
        r8.metrics = r9;
    L34:
        th = move-exception;
        th.printStackTrace();
        return;
    L7:
        if (sCronetClient == null) goto L13;
        LinkedHashMap r1 = new LinkedHashMap();     // Catch: Throwable -> L34
        sCronetClient.getRequestMetrics(r7, r1);     // Catch: Throwable -> L34
        if (r1.isEmpty() == true) goto L13;
        r8.remoteIp = (String) getValue(r1.get(ICronetClient.KEY_REMOTE_IP), String.class, "");     // Catch: Throwable -> L34
        r8.dnsTime = ((Long) getValue(r1.get(ICronetClient.KEY_DNS_TIME), Long.class, -1L)).longValue();     // Catch: Throwable -> L34
        r8.connectTime = ((Long) getValue(r1.get(ICronetClient.KEY_CONNECT_TIME), Long.class, -1L)).longValue();     // Catch: Throwable -> L34
        r8.sslTime = ((Long) getValue(r1.get(ICronetClient.KEY_SSL_TIME), Long.class, -1L)).longValue();     // Catch: Throwable -> L34
        r8.sendTime = ((Long) getValue(r1.get(ICronetClient.KEY_SEND_TIME), Long.class, -1L)).longValue();     // Catch: Throwable -> L34
        r8.pushTime = ((Long) getValue(r1.get(ICronetClient.KEY_PUSH_TIME), Long.class, -1L)).longValue();     // Catch: Throwable -> L34
        r8.receiveTime = ((Long) getValue(r1.get(ICronetClient.KEY_RECEIVE_TIME), Long.class, -1L)).longValue();     // Catch: Throwable -> L34
        r8.isSocketReused = ((Boolean) getValue(r1.get(ICronetClient.KEY_SOCKET_REUSED), Boolean.class, false)).booleanValue();     // Catch: Throwable -> L34
        r8.ttfbMs = ((Long) getValue(r1.get(ICronetClient.KEY_TTFB), Long.class, -1L)).longValue();     // Catch: Throwable -> L34
        r8.totalTime = ((Long) getValue(r1.get("total_time"), Long.class, -1L)).longValue();     // Catch: Throwable -> L34
        r8.sentByteCount = ((Long) getValue(r1.get(ICronetClient.KEY_SEND_BYTE_COUNT), Long.class, -1L)).longValue();     // Catch: Throwable -> L34
        r8.receivedByteCount = ((Long) getValue(r1.get(ICronetClient.KEY_RECEIVED_BYTE_COUNT), Long.class, -1L)).longValue();     // Catch: Throwable -> L34
        r8.requestLog = (String) getValue(r1.get("request_log"), String.class, "");     // Catch: Throwable -> L34
        r8.retryAttempts = ((Long) getValue(r1.get(ICronetClient.KEY_RETRY_ATTEMPTS), Long.class, -1L)).longValue();     // Catch: Throwable -> L34
        r8.requestHeaders = (String) getValue(r1.get(ICronetClient.KEY_REQUEST_HEADERS), String.class, "");     // Catch: Throwable -> L34
        r8.responseHeaders = (String) getValue(r1.get(ICronetClient.KEY_RESPONSE_HEADERS), String.class, "");     // Catch: Throwable -> L34
        r8.nativePostTaskStartTime = ((Long) getValue(r1.get(ICronetClient.KEY_POST_TASK_START), Long.class, -1L)).longValue();     // Catch: Throwable -> L34
        r8.nativeRequestStartTime = ((Long) getValue(r1.get(ICronetClient.KEY_REQUEST_START), Long.class, -1L)).longValue();     // Catch: Throwable -> L34
        r8.nativeWaitContext = ((Long) getValue(r1.get(ICronetClient.KEY_WAIT_CONTEXT), Long.class, -1L)).longValue();     // Catch: Throwable -> L34
        if (r9 == null) goto L13;
        r9.upperAddCookieDurationUs = ((Long) getValue(r1.get(ICronetClient.KEY_UPPER_ADD_COOKIE_US), Long.class, -1L)).longValue();     // Catch: Throwable -> L34
        r9.upperSaveCookieDurationUs = ((Long) getValue(r1.get(ICronetClient.KEY_UPPER_SAVE_COOKIE_US), Long.class, -1L)).longValue();     // Catch: Throwable -> L34
        r9.requestCookieSourceType = ((Integer) getValue(r1.get(ICronetClient.KEY_REQ_COOKIE_SOURCE_TYPE), Integer.class, -1)).intValue();     // Catch: Throwable -> L34
    L13:
        if (r9 == null) goto L39;
        r9.cronetInitStart = TTNetInitMetrics.inst().createEngineStart;     // Catch: Throwable -> L34
        r9.cronetInitEnd = TTNetInitMetrics.inst().cronetInitEnd;     // Catch: Throwable -> L34
        r9.fallbackReason = r8.fallbackReason;     // Catch: Throwable -> L34
        r9.executeCallEndTime = SystemClock.uptimeMillis();     // Catch: Throwable -> L34
        r9.retrofitLogReportTime = System.currentTimeMillis();     // Catch: Throwable -> L34
        r9.ttnetVersion = "4.2.211.1-rc.0";     // Catch: Throwable -> L34
        r9.extra.put(RetrofitMetrics.ExtraKeys.SENT_BYTE_COUNT, Long.valueOf(r8.sentByteCount));     // Catch: Throwable -> L34
        r9.extra.put(RetrofitMetrics.ExtraKeys.RECEIVED_BYTE_COUNT, Long.valueOf(r8.receivedByteCount));     // Catch: Throwable -> L34
        JSONObject r10 = r8.extraInfo;     // Catch: Throwable -> L34
        if (r8.executeTuringCallback == false) goto L19;
        r10.put("turing_callback", r8.turingCallbackDuration);     // Catch: Throwable -> L34
    L19:
        if (r8.retryByHeaderCallbackDuration < 0) goto L22;
        r10.put("turing_callback", r8.retryByHeaderCallbackDuration);     // Catch: Throwable -> L34
    L22:
        if (r8.retryForAccountCallbackDuration < 0) goto L25;
        r10.put("retry_for_account_cost", r8.retryForAccountCallbackDuration);     // Catch: Throwable -> L34
    L25:
        if (r8.bdTuringRetry == false) goto L28;
        r10.put("turing_retry", "1");     // Catch: Throwable -> L34
    L28:
        if (r8.retryByHeaderFilterKey == null) goto L30;
        r10.put("retry_by_header", r8.retryByHeaderFilterKey);     // Catch: Throwable -> L34
    L30:
        r10.put("retrofit", r9.getRetrofitLog());     // Catch: Throwable -> L34
        if (TextUtils.isEmpty(r8.requestLog) == false) goto L40;
        addABTestInfo(r10);     // Catch: Throwable -> L34
        return;
    L40:
        return;
    }

    protected static HttpURLConnection openConnection(String r9) throws IOException {
        tryResolveImpl();
        ICronetClient r0 = sCronetClient;
        if (r0 == null) goto L11;
        r0.setCronetBootFailureChecker(sInstance);
        ICronetClient r2 = sCronetClient;
        Context r3 = sContext;
        ICronetHttpDnsConfig r1 = sCronetHttpDnsConfig;
        if (r1 != null) goto L7;
        boolean r4 = false;
    L8:
        HttpURLConnection r10 = r2.openConnection(r3, r9, r4, NetworkParams.getUserAgent(), new SsHttpExecutor(), sCronetAppProvider);
        r10.setConnectTimeout(NetworkParams.getConnectTimeout());
        r10.setReadTimeout(NetworkParams.getIoTimeout());
        return r10;
    L7:
        r4 = r1.isCronetHttpDnsOpen();
        goto L8
    L11:
        throw new IllegalArgumentException("CronetClient is null");
    }

    protected static HttpURLConnection constructURLConnection(String r19, Request r20, BaseHttpRequestInfo r21, long r22) throws IOException {
        long r2 = SystemClock.uptimeMillis();
        tryNecessaryInit(r20);
        long r4 = SystemClock.uptimeMillis();
        HttpURLConnection r6 = openConnection(r19);
        long r7 = SystemClock.uptimeMillis();
        if (isCronetInputStreamSizeValid(sCronetInputstreamBuffSize) == true) goto L119;
    L8:
        r6.setInstanceFollowRedirects(true);
        if ((r21.reqContext instanceof BaseRequestContext) == false) goto L82;
        T r14 = r21.reqContext;
        int r15 = r14.output_stream_buffer_size;
        if (r14.timeout_connect <= 0) goto L14;
        r6.setConnectTimeout((int) r14.timeout_connect);
    L14:
        if (r14.timeout_read <= 0) goto L17;
        r6.setReadTimeout((int) r14.timeout_read);
    L17:
        if (r14.protect_timeout > 0) goto L107;
        long r16 = r7;
    L35:
        if (isCronetInputStreamSizeValid(sCronetInputstreamBuffSize) == false) goto L37;
    L42:
        int r8 = r14.request_type_flags;
        int r0 = r14.request_flag;
        if (r14.enable_http_cache == true) goto L45;
    L46:
        r0 = r0 | 16;
    L48:
        if (r14.byPassProxy == false) goto L50;
        r0 = r0 | 128;
    L50:
        if (r0 <= 0) goto L56;
        Reflect.on(r6).call("setRequestFlag", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r0)});     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        th.printStackTrace();
    L56:
        if (r14.isCustomizedCookie == false) goto L58;
        r8 = r8 | 2;
    L58:
        if (r8 <= 0) goto L64;
        Reflect.on(r6).call("setRequestTypeFlags", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r8)});     // Catch: Throwable -> L61
    L61:
        th = move-exception;
        th.printStackTrace();
    L64:
        if (r14.throttle_net_speed > 0) goto L66;
    L68:
        long r9 = r22;
    L70:
        if (r14.followRedirectInternal == true) goto L72;
        r6.setInstanceFollowRedirects(false);
    L72:
        BaseRequestContext.AuthCredentials r1 = r14.authCredentials;
        if (r1 != null) goto L75;
    L83:
        int r3 = getCronetOutputStreamBufferSize(r20.getPath(), r15);
        if (isValidCronetOutputstreamBufferSize(r3) == false) goto L115;
        Reflect.on(r6).call("setOutputStreamBufferSize", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r3)});     // Catch: Throwable -> L89
        if (r20.getMetrics() == null) goto L115;
        r20.getMetrics().postBodyBufferSize = r3;     // Catch: Throwable -> L89
    L89:
        th = move-exception;
        th.printStackTrace();
    L115:
        Reflect.on(r6).call("setRequestPriority", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r20.getRequestPriorityLevel())});     // Catch: Throwable -> L93
    L96:
        if (r9 > 0) goto L121;
    L101:
        long r10 = SystemClock.uptimeMillis();
        prepareRequest(r6, r20);
        r21.extraInfo = createExtraInfo(r6);
        if (r21 != null) goto L104;
    L106:
        return r6;
    L104:
        if (r21.metrics == null) goto L106;
        r21.metrics.tryNecessaryInitDuration = r4 - r2;
        r21.metrics.openConnectionDuration = r16 - r4;
        r21.metrics.setConnectionDuration = r10 - r16;
        r21.metrics.prepareRequestDuration = SystemClock.uptimeMillis() - r10;
        goto L106
    L121:
        Reflect.on(r6).call("setThrottleNetSpeed", new Class[]{Integer.TYPE}, new Object[]{Long.valueOf(r9)});     // Catch: Throwable -> L99
    L99:
        th = move-exception;
        th.printStackTrace();
    L93:
        th = move-exception;
        th.printStackTrace();
        goto L96
    L75:
        if (r1.username == null) goto L83;
        if (r1.password == null) goto L83;
        Reflect.on(r6).call("setAuthCredentials", new Class[]{String.class, String.class}, new Object[]{r1.username, r1.password});     // Catch: Throwable -> L80
    L80:
        th = move-exception;
        th.printStackTrace();
        goto L83
    L66:
        if (r22 != 0) goto L68;
        r9 = r14.throttle_net_speed;
        goto L70
    L45:
        if ((r8 & 1) > 0) goto L48;
    L37:
        if (isCronetInputStreamSizeValid(r14.input_stream_buffer_size) == false) goto L42;
        Reflect.on(r6).call("setInputStreamBufferSize", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r14.input_stream_buffer_size)});     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        th.printStackTrace();
        goto L42
    L107:
        Reflect r5 = Reflect.on(r6);     // Catch: Throwable -> L30
        Class<?>[] r12 = {Integer.TYPE};     // Catch: Throwable -> L30
        Object[] r11 = new Object[1];     // Catch: Throwable -> L30
        r16 = r7;
        r11[0] = Integer.valueOf((int) r14.protect_timeout);     // Catch: Throwable -> L28
        r5.call("setRequestTimeout", r12, r11);     // Catch: Throwable -> L28
        r6.setConnectTimeout(0);     // Catch: Throwable -> L28
        r6.setReadTimeout(0);     // Catch: Throwable -> L28
        if (r14.socket_connect_timeout <= 0) goto L23;
    L26:
        Reflect.on(r6).call("setSocketConnectTimeout", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf((int) r14.socket_connect_timeout)});     // Catch: Throwable -> L28
        Reflect.on(r6).call("setSocketReadTimeout", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf((int) r14.socket_read_timeout)});     // Catch: Throwable -> L28
        Reflect.on(r6).call("setSocketWriteTimeout", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf((int) r14.socket_write_timeout)});     // Catch: Throwable -> L28
        goto L35
    L23:
        if (r14.socket_read_timeout > 0) goto L26;
        if (r14.socket_write_timeout <= 0) goto L35;
    L28:
        th = th;
    L32:
        th.printStackTrace();
    L30:
        th = th;
        r16 = r7;
        goto L32
    L82:
        r16 = r7;
        r9 = r22;
        r15 = 0;
        goto L83
    L119:
        Reflect.on(r6).call("setInputStreamBufferSize", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(getCronetInputstreamBuffSize())});     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        th.printStackTrace();
        goto L8
    }

    protected static void prepareRequest(HttpURLConnection r6, Request r7) throws IOException {
        r6.setRequestMethod(r7.getMethod());
        r6.setDoInput(true);
        Iterator<Header> r1 = r7.getHeaders().iterator();
        boolean r2 = false;
    L4:
        if (r1.hasNext() == false) goto L14;
        Header r3 = r1.next();
        if (StringUtils.isEmpty(r3.getName()) == true) goto L4;
        if (StringUtils.isEmpty(r3.getValue()) == true) goto L4;
        if ("User-Agent".equalsIgnoreCase(r3.getName()) == false) goto L13;
        r2 = true;
    L13:
        r6.setRequestProperty(r3.getName(), r3.getValue());
        goto L4
    L14:
        if (r2 == true) goto L21;
        String r4 = NetworkParams.getUserAgent();
        if (StringUtils.isEmpty(r4) == true) goto L21;
        if (sCronetClient == null) goto L20;
        r4 = r4 + " cronet/" + sCronetClient.getCronetVersion();
    L20:
        r6.setRequestProperty("User-Agent", r4);
    L21:
        TypedOutput r5 = r7.getBody();
        if (r5 == null) goto L41;
        r6.setDoOutput(true);
        r6.setRequestProperty("Content-Type", r5.mimeType());
        String r0 = getRequestBodyStub(r5);
        if (r0 == null) goto L26;
        r6.setRequestProperty("X-SS-STUB", r0);
    L26:
        String r8 = tryCompressRequestBody(r5, r7);
        if (TextUtils.isEmpty(r8) == true) goto L29;
        r6.setRequestProperty("x-bd-content-encoding", r8);
    L29:
        long r9 = r5.length();
        if (r9 == (-1)) goto L32;
        r6.setFixedLengthStreamingMode((int) r9);
        r6.setRequestProperty("Content-Length", String.valueOf(r9));
        return;
    L32:
        r6.setChunkedStreamingMode(4096);
        return;
    }

    private static boolean shouldUseTTNetContentEncoding(Request r1) {
        Header r2 = r1.getFirstHeader(USE_TTNET_CONTENT_ENCODING);
        if (r2 != null) goto L7;
        return false;
    L7:
        return "1".equals(r2.getValue());
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

    private static String tryCompressRequestBody(TypedOutput r8, Request r9) {
        if ((r8 instanceof AbsTypedOutput) == false) goto L25;
        if (r9 == null) goto L29;
        AbsTypedOutput r0 = (AbsTypedOutput) r8;
        if (TextUtils.isEmpty(r0.bodyCompressType()) == false) goto L9;
        long r1 = System.currentTimeMillis();
        long r3 = r8.length();
        String r2 = r0.compressRequestBody(r9.getHost(), r9.getPath(), shouldUseTTNetContentEncoding(r9));
        if (r9.getMetrics() == null) goto L24;
        JSONObject r5 = new JSONObject();
        r5.put("beforeSize", r3);     // Catch: JSONException -> L22
        if (TextUtils.isEmpty(r2) == true) goto L17;
        r5.put("type", r2);     // Catch: JSONException -> L22
        r5.put("afterSize", r8.length());     // Catch: JSONException -> L22
    L17:
        if (TTRequestCompressManager.sGlobalCompressDisabled.booleanValue() == false) goto L19;
        r5.put("disableReason", TTRequestCompressManager.DisableCompress.GLOBAL_DISABLE.getReason());     // Catch: JSONException -> L22
    L20:
        r9.getMetrics().requestCompressInfo = r5;     // Catch: JSONException -> L22
        goto L24
    L19:
        r5.put("duration", System.currentTimeMillis() - r1);     // Catch: JSONException -> L22
    L22:
        e = move-exception;
        e.printStackTrace();
    L24:
        return r2;
    L9:
        return r0.bodyCompressType();
    L29:
        return null;
    L25:
        return null;
    }

    protected static int processExecute(Request r7, HttpURLConnection r8) throws IOException {
        if (r7 == null) goto L20;
        if (r8 == null) goto L22;
        TypedOutput r0 = r7.getBody();
        if (r0 == null) goto L9;
        r0.writeTo(r8.getOutputStream());
    L9:
        if (NetworkParams.newCookieBlockPositionEnabled() == false) goto L19;
        if (NetworkParams.interceptCookie(r7.getExtraInfo()) == true) goto L19;
        long r1 = SystemClock.uptimeMillis();
        NetworkParams.tryCookieManagerInit();
        if (r7.getMetrics() == null) goto L16;
        r7.getMetrics().tryNecessaryInitDuration += SystemClock.uptimeMillis() - r1;
    L16:
        if (Logger.debug() == false) goto L19;
        Logger.d(TAG, "newCookieBlockPositionEnabled true:" + r7.getUrl());
    L19:
        return r8.getResponseCode();
    L22:
        return -1;
    L20:
        return -1;
    }

    protected static String getHeaderValueIgnoreCase(HttpURLConnection r2, String r3) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (TextUtils.isEmpty(r3) == true) goto L13;
        String r0 = r2.getHeaderField(r3);
        if (TextUtils.isEmpty(r0) == true) goto L9;
        return r0;
    L9:
        return r2.getHeaderField(r3.toLowerCase());
    L13:
        return null;
    }

    protected static String processAfterExecute(HttpURLConnection r1, BaseHttpRequestInfo r2, int r3) {
        if (r1 != null) goto L5;
        return null;
    L5:
        getRequestInfo(getHeaderValueIgnoreCase(r1, "x-net-info.remoteaddr"), r2);
        if (r2 == null) goto L11;
        if (r2.reqContext == 0) goto L11;
        r2.reqContext.status = r3;
    L11:
        return getHeaderValueIgnoreCase(r1, "X-TT-LOGID");
    }

    protected static byte[] processResponse(String r16, int r17, HttpURLConnection r18, long r19, BaseHttpRequestInfo r21, String r22, int r23, RetrofitMetrics r24) throws IOException {
        if (r18 == null) goto L5;
        boolean r0 = "gzip".equals(getHeaderValueIgnoreCase(r18, "Content-Encoding"));
        ICronetClient r1 = sCronetClient;
        if (r1 != null) goto L9;
    L11:
        boolean r2 = r0;
    L12:
        String r13 = getHeaderValueIgnoreCase(r18, "Content-Type");
        if (r23 != 200) goto L15;
    L38:
        r21.completeReadResponse = System.currentTimeMillis();
        InputStream r3 = r18.getInputStream();     // Catch: Exception -> L41
    L40:
        InputStream r12 = r3;
        int[] r4 = new int[1];
        r4[0] = 0;     // Catch: Throwable -> L60
        if (r24 == null) goto L49;
        r24.url = r18.getURL();     // Catch: Throwable -> L60
    L49:
        byte[] r5 = StreamParser.readResponse(r2, r18.getHeaderFields(), r17, r12, r4, r24);     // Catch: Throwable -> L60
        StreamParser.safeClose(r12);
        int r6 = r4[0];
        byte[] r7 = new byte[r6];
        if (r5 == null) goto L55;
        if (r6 <= 0) goto L55;
        System.arraycopy(r5, 0, r7, 0, r6);
    L55:
        if (StreamParser.testIsSSBinary(r13) == false) goto L57;
        StreamParser.decodeSSBinary(r7, r6);
    L57:
        long r8 = System.currentTimeMillis() - r19;
        r21.requestEnd = System.currentTimeMillis();
        getRequestMetrics(r18, r21, r24);
        NetworkParams.handleApiOk(r16, r8, r21);
        StoreRegionManager.inst().updateStoreRegionForCronet(r18, r7, new SsCronetHttpClient$$ExternalSyntheticLambda0());     // Catch: Throwable -> L64
    L59:
        return r7;
    L60:
        th = move-exception;
        StreamParser.safeClose(r12);
        throw th;
    L41:
        e = move-exception;
        if (isForceHandleResponse(r21) == false) goto L63;
        r3 = r18.getErrorStream();
        goto L40
    L63:
        throw e;
    L15:
        if (isForceHandleResponse(r21) == true) goto L38;
        if (r23 != 304) goto L20;
        r21.completeReadResponse = System.currentTimeMillis();
        long r9 = System.currentTimeMillis() - r19;
        r21.requestEnd = System.currentTimeMillis();
        getRequestMetrics(r18, r21, r24);
        NetworkParams.handleApiOk(r16, r9, r21);
    L20:
        String r15 = r18.getResponseMessage();
        InputStream r10 = r18.getInputStream();     // Catch: Throwable -> L23 Exception -> L25
    L26:
        String r11 = processHttpErrorResponse(r2, r18.getHeaderFields(), r17, r10, r13, r16, r24, r21);     // Catch: Throwable -> L23
    L32:
        if (r18 == null) goto L34;
        r18.disconnect();
    L34:
        HttpResponseException r14 = new HttpResponseException(r23, r15, HttpResponseException.getPathFromHttpURLConnection(r18), r11);
        if (r23 != 304) goto L74;
        r14.setInfo(true, true, false, r16, r22, r21);
        throw r14;
    L74:
        throw r14;
    L23:
        th = move-exception;
        th.printStackTrace();
        StringBuilder r20 = new StringBuilder("reason = ");
        if (r15 != null) goto L31;
        r15 = "";
    L31:
        r15 = r20.append(r15).append("  exception = ").append(th.getMessage()).toString();
        r11 = null;
    L25:
        r10 = r18.getErrorStream();     // Catch: Throwable -> L23
        goto L26
    L9:
        if (r1.isCronetHttpURLConnection(r18) == false) goto L11;
        r2 = false;
        goto L12
    L5:
        return new byte[0];
    }

    static /* synthetic */ void lambda$processResponse$0(String r0, String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9) {
        notifyStoreRegionUpdated(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    protected static String processHttpErrorResponse(boolean r10, Map<String, List<String>> r11, int r12, InputStream r13, String r14, String r15, RetrofitMetrics r16, BaseHttpRequestInfo r17) throws IOException {
        String r1 = null;
        if (r13 != null) goto L5;
        return null;
    L5:
        int[] r8 = new int[1];
        r8[0] = 0;     // Catch: Throwable -> L39
        byte[] r2 = StreamParser.readResponse(r10, r11, r12, r13, r8, r16);     // Catch: Throwable -> L39
        StreamParser.safeClose(r13);
        int r3 = r8[0];
        byte[] r4 = new byte[r3];
        if (r2 == null) goto L11;
        if (r3 <= 0) goto L11;
        System.arraycopy(r2, 0, r4, 0, r3);
    L11:
        if (r3 > 0) goto L13;
    L38:
        return r1;
    L13:
        if (StringUtils.isEmpty(r14) == true) goto L38;
        if (Logger.debug() == false) goto L17;
    L44:
        MimeType r5 = new MimeType(r14);     // Catch: Throwable -> L36
        if ("text".equalsIgnoreCase(r5.getPrimaryType()) == false) goto L21;
    L22:
        String r6 = r5.getParameter("charset");     // Catch: Throwable -> L36
        if (StringUtils.isEmpty(r6) == false) goto L26;
        r6 = Constant.CHARSET_UTF_8;
    L26:
        if (shouldReadErrorResponse(r17) == false) goto L29;
        r1 = new String(r4, r6);     // Catch: Throwable -> L36
    L29:
        if (Logger.debug() == false) goto L38;
        StringBuilder r0 = new StringBuilder(" response body = ").append(new String(r4, r6)).append(" for url = ");     // Catch: Throwable -> L36
        if (r15 != null) goto L33;
        String r7 = "";
    L34:
        Logger.d(TAG, r0.append(r7).toString());     // Catch: Throwable -> L36
        goto L38
    L33:
        r7 = r15;
        goto L34
    L21:
        if (RequestParams.APPLICATION_JSON.equalsIgnoreCase(r5.getBaseType()) == false) goto L38;
    L36:
        th = move-exception;
        th.printStackTrace();
        goto L38
    L17:
        if (shouldReadErrorResponse(r17) == false) goto L38;
    L39:
        th = move-exception;
        StreamParser.safeClose(r13);
        throw th;
    }

    protected static void processException(String r2, long r3, BaseHttpRequestInfo r5, String r6, Exception r7, HttpURLConnection r8, RetrofitMetrics r9) {
        if (r2 == null) goto L26;
        if (r7 == null) goto L27;
        if (r5 == null) goto L29;
    L13:
        th = move-exception;
        th.printStackTrace();
    L16:
        if (StringUtils.isEmpty(r5.remoteIp) == false) goto L18;
        getRequestInfo(getHostAddress(r7), r5);
    L18:
        long r0 = System.currentTimeMillis() - r3;
        r5.requestEnd = System.currentTimeMillis();
        getRequestMetrics(r8, r5, r9);
        NetworkParams.handleApiError(r2, r7, r0, r5);
        if (r5.downloadFile == false) goto L21;
        r5.hasReportStreamingApiAll.set(true);
    L21:
        if (r8 == null) goto L28;
        r8.disconnect();
        return;
    L28:
        return;
    L7:
        if (r5.extraInfo != null) goto L9;
        r5.extraInfo = createExtraInfo(r8);     // Catch: Throwable -> L13
    L9:
        r5.extraInfo.put(BaseHttpRequestInfo.KEY_EXCEPTION, r7.getMessage());     // Catch: Throwable -> L13
        String r10 = getAllHeaderFieldsString(r8);     // Catch: Throwable -> L13
        if (StringUtils.isEmpty(r10) == true) goto L16;
        r5.extraInfo.put("response-headers", r10);     // Catch: Throwable -> L13
        goto L16
    L29:
        return;
    L27:
        return;
    }

    private static String getAllHeaderFieldsString(HttpURLConnection r8) {
        if (r8 != null) goto L41;
        return "";
    L41:
        Map<String, List<String>> r9 = r8.getHeaderFields();     // Catch: Throwable -> L38
        if (r9 != null) goto L8;
    L37:
        return "";
    L8:
        if (r9.isEmpty() == true) goto L37;
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L38
        Iterator<Map.Entry<String, List<String>>> r10 = r9.entrySet().iterator();     // Catch: Throwable -> L38
    L12:
        if (r10.hasNext() == false) goto L35;
        Map.Entry<String, List<String>> r2 = r10.next();     // Catch: Throwable -> L38
        if (r2 == null) goto L12;
        String r3 = r2.getKey();     // Catch: Throwable -> L38
        if (StringUtils.isEmpty(r3) == true) goto L12;
        List<String> r4 = r2.getValue();     // Catch: Throwable -> L38
        if (r4 == null) goto L12;
        if (r4.isEmpty() == true) goto L12;
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L38
        Iterator<String> r6 = r4.iterator();     // Catch: Throwable -> L38
        int r7 = 0;
    L26:
        if (r6.hasNext() == false) goto L34;
        String r11 = r6.next();     // Catch: Throwable -> L38
        if (StringUtils.isEmpty(r11) == true) goto L26;
        if (r7 != 0) goto L32;
        r5.append(r11);     // Catch: Throwable -> L38
    L33:
        r7 = r7 + 1;     // Catch: Throwable -> L38
        goto L26
    L32:
        r5.append(VectorFormat.DEFAULT_SEPARATOR).append(r11);     // Catch: Throwable -> L38
        goto L33
    L34:
        r1.put(r3, r5.toString());     // Catch: Throwable -> L38
        goto L12
    L35:
        return r1.toString();
    L38:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    protected static void processFinally(HttpURLConnection r0) {
        if (r0 != null) goto L4;
        return;
    L4:
        if (r0 == null) goto L7;
        r0.disconnect();
        return;
    }

    protected static JSONObject createExtraInfo(HttpURLConnection r3) {
        JSONObject r0 = new JSONObject();
        if (r3 != null) goto L13;
        return r0;
    L13:
        r0.put(BaseHttpRequestInfo.KEY_HTTP_CLIENT, TAG);     // Catch: Exception -> L10
        ICronetClient r1 = sCronetClient;     // Catch: Exception -> L10
        if (r1 == null) goto L8;
        r0.put(BaseHttpRequestInfo.KEY_HTTP_CLIENT_VERSION, r1.getCronetVersion());     // Catch: Exception -> L10
    L8:
        r0.put(BaseHttpRequestInfo.KEY_USER_AGENT, r3.getRequestProperty("User-Agent"));     // Catch: Exception -> L10
    L12:
        return r0;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    private static void addABTestInfo(JSONObject r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        ITncInfoGet r0 = sCronetTncInfoGet;
        if (r0 == null) goto L7;
        JSONObject r1 = r0.getABTest();
    L8:
        if (r1 == null) goto L16;
        r2.put(BaseHttpRequestInfo.KEY_ABTEST, r1);     // Catch: JSONException -> L11
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L16:
        return;
    L7:
        r1 = null;
        goto L8
    }

    protected static int getCronetInputstreamBuffSize() {
        return sCronetInputstreamBuffSize;
    }

    protected static int getCronetOutputStreamBufferSize(String r1, int r2) {
        if (isValidCronetOutputstreamBufferSize(r2) == true) goto L7;
        r2 = 0;
    L7:
        if (TextUtils.isEmpty(r1) == false) goto L10;
        return r2;
    L10:
        if (sCronetOutputStreamBufferMap.containsKey(r1) == true) goto L12;
        return r2;
    L12:
        return sCronetOutputStreamBufferMap.get(r1).intValue();
    }

    protected static void checkNetworkAvailable(boolean r2, String r3, String r4) throws NetworkNotAvailabeException {
        if (sBypassOfflineCheckEnabled == true) goto L13;
        if (r2 == true) goto L13;
        Context r5 = sContext;
        if (r5 == null) goto L13;
        if (NetworkUtils.isNetworkAvailable(r5) == true) goto L13;
        throw new NetworkNotAvailabeException("network not available for " + r4);
    L13:
        if (sBypassOfflineCheckEnabled == true) goto L15;
        return;
    L15:
        if (TextUtils.isEmpty(r3) == false) goto L17;
        return;
    L17:
        if (r3.contains(INTERNET_DISCONNECTED) == false) goto L23;
        NetworkNotAvailabeException r6 = new NetworkNotAvailabeException("network not available for " + r4 + ", message:" + r3);
        r6.setShouldReport(true);
        throw r6;
    }

    public static void setBypassOfflineCheck(boolean r0) {
        sBypassOfflineCheckEnabled = r0;
    }

    public void setAlogFuncAddr(long r5) throws Exception {
        ICronetClient r4 = sCronetClient;
        if (r4 == null) goto L7;
        Reflect.on(r4).call("setAlogFuncAddr", new Class[]{Long.TYPE}, new Object[]{Long.valueOf(r5)});
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public void setZstdFuncAddr(long r13, long r15, long r17, long r19, long r21, long r23, long r25, long r27) throws Exception {
        ICronetClient r0 = sCronetClient;
        if (r0 == null) goto L7;
        Reflect.on(r0).call("setZstdFuncAddr", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Long.TYPE, Long.TYPE, Long.TYPE, Long.TYPE, Long.TYPE}, new Object[]{Long.valueOf(r13), Long.valueOf(r15), Long.valueOf(r17), Long.valueOf(r19), Long.valueOf(r21), Long.valueOf(r23), Long.valueOf(r25), Long.valueOf(r27)});
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public void startThrottle(String[] r7, int r8, long r9) {
        ICronetClient r6 = sCronetClient;
        if (r6 == null) goto L7;
        Reflect.on(r6).call("startThrottle", new Class[]{String[].class, Integer.TYPE, Long.TYPE}, new Object[]{r7, Integer.valueOf(r8), Long.valueOf(r9)});
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public void stopThrottle(String[] r6, int r7) {
        ICronetClient r5 = sCronetClient;
        if (r5 == null) goto L7;
        Reflect.on(r5).call("stopThrottle", new Class[]{String[].class, Integer.TYPE}, new Object[]{r6, Integer.valueOf(r7)});
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public static void setBestHostWithRouteSelectionName(String r6, String r7) throws Exception {
        ICronetClient r0 = sCronetClient;
        if (r0 == null) goto L7;
        Reflect.on(r0).call("setBestHostWithRouteSelectionName", new Class[]{String.class, String.class}, new Object[]{r6, r7});
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public void setCookieInitCompleted() {
        ICronetClient r1 = sCronetClient;
        if (r1 == null) goto L7;
        Reflect.on(r1).call("setCookieInitCompleted");
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public boolean notifySwitchToMultiNetwork(boolean r5) throws Exception {
        ICronetClient r4 = sCronetClient;
        if (r4 == null) goto L7;
        return ((Boolean) Reflect.on(r4).call("notifySwitchToMultiNetwork", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(r5)}).get()).booleanValue();
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public void triggerSwitchingToCellular() throws Exception {
        ICronetClient r1 = sCronetClient;
        if (r1 == null) goto L7;
        Reflect.on(r1).call("triggerSwitchingToCellular").get();
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public int getNetworkQualityLevel() throws Exception {
        ICronetClient r1 = sCronetClient;
        if (r1 == null) goto L7;
        return ((Integer) Reflect.on(r1).call("getNetworkQualityLevel").get()).intValue();
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public int getEffectiveHttpRttMs() throws Exception {
        ICronetClient r1 = sCronetClient;
        if (r1 == null) goto L7;
        return ((Integer) Reflect.on(r1).call("getEffectiveHttpRttMs").get()).intValue();
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public int getEffectiveTransportRttMs() throws Exception {
        ICronetClient r1 = sCronetClient;
        if (r1 == null) goto L7;
        return ((Integer) Reflect.on(r1).call("getEffectiveTransportRttMs").get()).intValue();
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public int getEffectiveRxThroughputKbps() throws Exception {
        ICronetClient r1 = sCronetClient;
        if (r1 == null) goto L7;
        return ((Integer) Reflect.on(r1).call("getEffectiveRxThroughputKbps").get()).intValue();
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public void reportNetDiagnosisUserLog(String r5) throws Exception {
        ICronetClient r4 = sCronetClient;
        if (r4 == null) goto L7;
        Reflect.on(r4).call("reportNetDiagnosisUserLog", new Class[]{String.class}, new Object[]{r5});
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public void enableTTBizHttpDns(boolean r10, String r11, String r12, String r13, boolean r14, String r15) throws Exception {
        ICronetClient r9 = sCronetClient;
        if (r9 == null) goto L7;
        Reflect.on(r9).call("enableTTBizHttpDns", new Class[]{Boolean.TYPE, String.class, String.class, String.class, Boolean.TYPE, String.class}, new Object[]{Boolean.valueOf(r10), r11, r12, r13, Boolean.valueOf(r14), r15}).get();
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public static void bindBigCore(TTNetThreadConfig.ThreadType r5) {
        ICronetClient r0 = sCronetClient;
        if (r0 == null) goto L7;
        Reflect.on(r0).call("bindBigCore", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r5.ordinal())});
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public static void bindLittleCore(TTNetThreadConfig.ThreadType r5) {
        ICronetClient r0 = sCronetClient;
        if (r0 == null) goto L7;
        Reflect.on(r0).call("bindLittleCore", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r5.ordinal())});
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public static void resetCoreBind(TTNetThreadConfig.ThreadType r5) {
        ICronetClient r0 = sCronetClient;
        if (r0 == null) goto L7;
        Reflect.on(r0).call("resetCoreBind", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r5.ordinal())});
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public static String getContentBaseType(String r2) {
    L7:
        e = move-exception;
        e.printStackTrace();
        return "";
    L4:
        if (StringUtils.isEmpty(r2) == true) goto L12;
        return new MimeType(r2).getBaseType();
    L12:
        return "";
    }

    static List<Header> createHeaders(HttpURLConnection r5, List<String> r6) {
        if (r5 != null) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<String, List<String>>> r7 = r5.getHeaderFields().entrySet().iterator();
    L7:
        if (r7.hasNext() == false) goto L26;
        Map.Entry<String, List<String>> r1 = r7.next();
        String r2 = r1.getKey();
        if (r2 == null) goto L22;
        if (r6 == null) goto L22;
        if (r6.isEmpty() == true) goto L22;
        Iterator<String> r3 = r6.iterator();
    L15:
        if (r3.hasNext() == false) goto L19;
        if (r2.equalsIgnoreCase(r3.next()) == false) goto L15;
        boolean r4 = true;
    L20:
        if (r4 == false) goto L22;
    L19:
        r4 = false;
    L22:
        Iterator<String> r8 = r1.getValue().iterator();
    L24:
        if (r8.hasNext() == false) goto L7;
        r0.add(new Header(r2, r8.next()));
        goto L24
    L26:
        return r0;
    }

    static void setRequestHeaders(HttpURLConnection r3, Map<String, String> r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r4 != null) goto L6;
        return;
    L6:
        if (r4.isEmpty() == true) goto L24;
        Iterator<Map.Entry<String, String>> r5 = r4.entrySet().iterator();
    L10:
        if (r5.hasNext() == false) goto L25;
        Map.Entry<String, String> r0 = r5.next();
        String r1 = r0.getKey();
        String r2 = r0.getValue();
        if (TextUtils.isEmpty(r1) == true) goto L10;
        if (TextUtils.isEmpty(r2) == true) goto L10;
        r3.setRequestProperty(r1, r2);
        goto L10
    L25:
        return;
    }

    static RequestRetryResult shouldRetryRequestFromTuringHeader(List<Header> r9, HttpURLConnection r10, BaseHttpRequestInfo r11, int r12) {
        RequestRetryResult r0 = new RequestRetryResult(false);
        Map<String, List<String>> r1 = r10.getHeaderFields();
        if (r1 != null) goto L5;
    L28:
        return r0;
    L5:
        if (r1.containsKey(NetworkParams.BDTURING_VERIFY_HEADER) == false) goto L28;
        String r3 = r10.getRequestProperty(NetworkParams.BYPASS_BDTURING_HEADER_KEY);
        if (TextUtils.isEmpty(r3) == false) goto L10;
    L12:
        TreeMap r2 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        r2.putAll(r1);
        long r4 = SystemClock.uptimeMillis();
        RequestRetryResult r5 = NetworkParams.shouldRetryRequestFromTuringHeaders(r12, r2);
        r11.turingCallbackDuration = SystemClock.uptimeMillis() - r4;
        if (r2.containsKey(NetworkParams.BDTURING_VERIFY_HEADER) == true) goto L15;
        r11.executeTuringCallback = true;
    L15:
        if (r5 != null) goto L17;
    L27:
        return r5;
    L17:
        if (r5.isRequestRetryEnabled() == false) goto L27;
        r11.bdTuringRetry = true;
        HashMap r6 = new HashMap();
        r6.put(NetworkParams.RETRY_REQUEST_BY_BDTURING_HEADER, "1");
        if (r5.getAddRequestHeaders() == null) goto L21;
        r6.putAll(r5.getAddRequestHeaders());
    L21:
        RequestRetryResult r13 = NetworkParams.shouldRetryForAccountRequest(r10.getURL().toString(), r12, true, r11, r9, r10.getHeaderFields());
        if (r13 != null) goto L24;
    L26:
        r5.setAddRequestHeaders(r6);
        goto L27
    L24:
        if (r13.getAddRequestHeaders() == null) goto L26;
        r6.putAll(r13.getAddRequestHeaders());
        goto L26
    L10:
        if (r3.equalsIgnoreCase("1") == false) goto L12;
        return r0;
    }

    static RequestRetryResult shouldRetryRequestByHeader(List<Header> r8, final HttpURLConnection r9, BaseHttpRequestInfo r10, int r11) {
        TreeMap r0 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        r0.putAll(r9.getHeaderFields());
        RequestRetryResult r1 = NetworkParams.shouldRetryRequestByHeader(r10, r11, new SsCronetHttpClient$$ExternalSyntheticLambda1(r9), r0);
        if (r1 != null) goto L5;
    L14:
        return r1;
    L5:
        if (r1.isRequestRetryEnabled() == false) goto L14;
        RequestRetryResult r12 = NetworkParams.shouldRetryForAccountRequest(r9.getURL().toString(), r11, true, r10, r8, r9.getHeaderFields());
        if (r12 == null) goto L14;
        if (r12.getAddRequestHeaders() == null) goto L14;
        HashMap r13 = new HashMap(r12.getAddRequestHeaders());
        if (r1.getAddRequestHeaders() == null) goto L13;
        r13.putAll(r1.getAddRequestHeaders());
    L13:
        r1.setAddRequestHeaders(r13);
        goto L14
    }

    static /* synthetic */ String lambda$shouldRetryRequestByHeader$1(HttpURLConnection r0, String r1) {
        return r0.getRequestProperty(r1);
    }

    public static Context getContext() {
        return sContext;
    }

    public static ICronetClient getCronetClient() {
        return sCronetClient;
    }

    private static void tryNecessaryInit(Request r2) {
        NetworkParams.tryApiProcessHookInit();
        if (NetworkParams.newCookieBlockPositionEnabled() == false) goto L5;
        return;
    L5:
        if (NetworkParams.interceptCookie(r2.getExtraInfo()) == true) goto L11;
        NetworkParams.tryCookieManagerInit();
        if (Logger.debug() == false) goto L12;
        Logger.d(TAG, "newCookieBlockPositionEnabled false:" + r2.getUrl());
        return;
    L12:
        return;
    }

    public static int getCronetInternalErrorCode(HttpURLConnection r1) {
        return sCronetClient.getCronetInternalErrorCode(r1);
    }
}
