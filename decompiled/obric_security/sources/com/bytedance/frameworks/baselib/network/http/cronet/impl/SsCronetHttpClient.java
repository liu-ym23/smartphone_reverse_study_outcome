package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.BaseHttpClient;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.ConstantsDefined;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetThreadConfig;
import com.bytedance.frameworks.baselib.network.http.retrofit.SsHttpExecutor;
import com.bytedance.frameworks.baselib.network.http.util.ProcessUtils;
import com.bytedance.frameworks.baselib.network.queryfilter.QueryFilterEngine;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.SsCall;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SsCronetHttpClient extends BaseHttpClient implements ICronetClient.ICronetBootFailureCheckerProvider, ICronetClient.ICronetThreadStackOptFailureCheckerProvider {
    private static final String CONCURRENT_NO_RETRY_SWITCH = "no_retry=1";
    private static final String CRONET_CLIENT_CLASS = "org.chromium.CronetClient";
    private static final int CRONET_INPUTSTREAM_BUFF_SIZE_MAX = 20971520;
    private static final int CRONET_INPUTSTREAM_BUFF_SIZE_MIN = 8192;
    private static final int CRONET_OUTPUTSTREAM_BUFF_SIZE_MAX = 10485760;
    private static final int CRONET_OUTPUTSTREAM_BUFF_SIZE_MIN = 16384;
    private static final int INVALID_BUFFER_SIZE = 0;
    private static final String KEY_CRONET_INPUTSTREAM_BUFF_SIZE = "cronet_inputstream_buff_size";
    private static final String KEY_CRONET_OUTPUTSTREAM_BUFF_SIZE = "post_body_buffer_size";
    private static final String KEY_PATH_CRONET_INPUTSTREAM_BUFF_SIZE = "path_cronet_inputstream_buff_size";
    public static final String TAG = "SsCronetHttpClient";
    private static volatile boolean sBypassOfflineCheckEnabled = true;
    private static Context sContext = null;
    private static volatile ICronetAppProvider sCronetAppProvider = null;
    private static ICronetBootFailureChecker sCronetBootFailureChecker = null;
    private static ICronetClient sCronetClient = null;
    private static ICronetHttpDnsConfig sCronetHttpDnsConfig = null;
    private static volatile int sCronetInputstreamBuffSize = 0;
    private static ConcurrentHashMap<String, Integer> sCronetOutputStreamBufferMap = null;
    private static ICronetThreadStackOptFailureChecker sCronetThreadOptFailureChecker = null;
    private static ITncInfoGet sCronetTncInfoGet = null;
    private static String sCustomCronetClientClass = "";
    private static volatile String sInputStreamBufferConfig;
    private static volatile SsCronetHttpClient sInstance;
    private static Map<String, Integer> sPathCronetInputStreamBufferSizeMap;
    private static volatile String sPostBodyBufferConfig;

    public interface ICronetBootFailureChecker {
        boolean isCronetBootFailureExpected();
    }

    public interface ICronetHttpDnsConfig {
        boolean isCronetHttpDnsOpen();
    }

    public interface ICronetThreadStackOptFailureChecker {
        String getThreadStackInitReason();

        boolean isCronetThreadStackOptFailureExpected();
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

    protected static boolean isCustomCronetInputStreamSizeValid(int r1) {
        if (r1 > 0) goto L4;
    L6:
        return false;
    L4:
        if (r1 > CRONET_INPUTSTREAM_BUFF_SIZE_MAX) goto L6;
        return true;
    }

    protected static boolean isValidCronetOutputstreamBufferSize(int r1) {
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
        sPathCronetInputStreamBufferSizeMap = new ConcurrentHashMap();
    }

    public static void setCronetAppInfoProvider(ICronetAppProvider r0) {
        sCronetAppProvider = r0;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient.ICronetBootFailureCheckerProvider
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

    public static void setCronetThreadOptFailureChecker(ICronetThreadStackOptFailureChecker r0) {
        sCronetThreadOptFailureChecker = r0;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient.ICronetThreadStackOptFailureCheckerProvider
    public boolean isCronetThreadStackOptFailureExpected() {
        ICronetThreadStackOptFailureChecker r0 = sCronetThreadOptFailureChecker;
        if (r0 != null) goto L6;
        return false;
    L6:
        return r0.isCronetThreadStackOptFailureExpected();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient.ICronetThreadStackOptFailureCheckerProvider
    public String getThreadStackInitReason() {
        ICronetThreadStackOptFailureChecker r0 = sCronetThreadOptFailureChecker;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getThreadStackInitReason();
    }

    public static void setCronetTncInfoGet(ITncInfoGet r0) {
        sCronetTncInfoGet = r0;
    }

    public static ITncInfoGet getCronetTncInfoGet() {
        return sCronetTncInfoGet;
    }

    public static void setCustomCronetClientClass(String r0) {
        sCustomCronetClientClass = r0;
    }

    public static void setBypassOfflineCheck(boolean r0) {
        sBypassOfflineCheckEnabled = r0;
    }

    public static boolean getGlobalBypassOfflineCheck() {
        return sBypassOfflineCheckEnabled;
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

    protected static int getCronetInputstreamBuffSize(String r1, BaseHttpRequestInfo r2) {
        if (isCronetInputStreamSizeValid(sCronetInputstreamBuffSize) == false) goto L7;
        return sCronetInputstreamBuffSize;
    L7:
        if (TextUtils.isEmpty(r1) == false) goto L9;
    L18:
        if (r2 != null) goto L20;
        return 0;
    L20:
        if (r2.reqContext != 0) goto L22;
        return 0;
    L22:
        if (isCronetInputStreamSizeValid(r2.reqContext.input_stream_buffer_size) == true) goto L28;
        if (r2.reqContext.ignoreCheckMinInputStreamBufferSize == true) goto L26;
        return 0;
    L26:
        if (isCustomCronetInputStreamSizeValid(r2.reqContext.input_stream_buffer_size) == true) goto L28;
        return 0;
    L28:
        return r2.reqContext.input_stream_buffer_size;
    L9:
        if (sPathCronetInputStreamBufferSizeMap.isEmpty() == true) goto L18;
        if (sPathCronetInputStreamBufferSizeMap.containsKey(r1) == false) goto L18;
        Integer r3 = sPathCronetInputStreamBufferSizeMap.get(r1);
        if (r3 == null) goto L18;
        if (isCronetInputStreamSizeValid(r3.intValue()) == false) goto L18;
        return r3.intValue();
    }

    protected static int getCronetOutputStreamBufferSize(String r2, int r3) {
        if (isValidCronetOutputstreamBufferSize(r3) == true) goto L7;
        r3 = 0;
    L7:
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return r3;
    L10:
        if (sCronetOutputStreamBufferMap.containsKey(r2) == false) goto L16;
        Integer r4 = sCronetOutputStreamBufferMap.get(r2);
        if (r4 != null) goto L14;
        r3 = 0;
        goto L16
    L14:
        r3 = r4.intValue();
    L16:
        if (isValidCronetOutputstreamBufferSize(r3) == true) goto L18;
        return 0;
    L18:
        return r3;
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

    private static void updateInputStreamBufferConfig(JSONObject r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        sPathCronetInputStreamBufferSizeMap.clear();
        Iterator<String> r0 = r4.keys();
    L6:
        if (r0.hasNext() == false) goto L13;
        String r1 = r0.next();
        if (TextUtils.isEmpty(r1) == true) goto L6;
        int r2 = r4.optInt(r1);
        if (isCustomCronetInputStreamSizeValid(r2) == false) goto L6;
        sPathCronetInputStreamBufferSizeMap.put(r1, Integer.valueOf(r2));
        goto L6
    }

    public static void tryUpdateBodyBufferSizeConfig(JSONObject r7, SharedPreferences r8) {
        if (r7 == null) goto L18;
        sCronetInputstreamBuffSize = r7.optInt(KEY_CRONET_INPUTSTREAM_BUFF_SIZE, 0);
        JSONObject r5 = r7.optJSONObject(KEY_CRONET_OUTPUTSTREAM_BUFF_SIZE);     // Catch: Throwable -> L26
        if (r5 == null) goto L8;
        updatePostBodyBufferConfig(r5);     // Catch: Throwable -> L26
        sPostBodyBufferConfig = r5.toString();     // Catch: Throwable -> L26
    L9:
        JSONObject r9 = r7.optJSONObject(KEY_PATH_CRONET_INPUTSTREAM_BUFF_SIZE);     // Catch: Throwable -> L26
        if (r9 == null) goto L17;
        String r6 = r9.toString();     // Catch: Throwable -> L26
        if (sInputStreamBufferConfig != null) goto L14;
    L16:
        updateInputStreamBufferConfig(r9);     // Catch: Throwable -> L26
        sInputStreamBufferConfig = r6;     // Catch: Throwable -> L26
        goto L18
    L14:
        if (r6.equals(sInputStreamBufferConfig) == false) goto L16;
        return;
    L17:
        sPathCronetInputStreamBufferSizeMap.clear();     // Catch: Throwable -> L26
        sInputStreamBufferConfig = "";     // Catch: Throwable -> L26
        goto L18
    L8:
        sCronetOutputStreamBufferMap.clear();     // Catch: Throwable -> L26
        sPostBodyBufferConfig = "";     // Catch: Throwable -> L26
    L18:
        if (r8 == null) goto L34;
        sCronetInputstreamBuffSize = r8.getInt(KEY_CRONET_INPUTSTREAM_BUFF_SIZE, 0);
        String r10 = r8.getString(KEY_CRONET_OUTPUTSTREAM_BUFF_SIZE, "");
        if (TextUtils.isEmpty(r10) == false) goto L29;
    L22:
        String r11 = r8.getString(KEY_PATH_CRONET_INPUTSTREAM_BUFF_SIZE, "");
        if (TextUtils.isEmpty(r11) == true) goto L35;
        updateInputStreamBufferConfig(new JSONObject(r11));     // Catch: Throwable -> L28
        return;
    L36:
        return;
    L35:
        return;
    L29:
        updatePostBodyBufferConfig(new JSONObject(r10));     // Catch: Throwable -> L27
        goto L22
    }

    public static void onSaveConfigToSP(SharedPreferences.Editor r2) {
        r2.putInt(KEY_CRONET_INPUTSTREAM_BUFF_SIZE, sCronetInputstreamBuffSize);
        if (sPostBodyBufferConfig == null) goto L6;
        r2.putString(KEY_CRONET_OUTPUTSTREAM_BUFF_SIZE, sPostBodyBufferConfig);
    L6:
        if (sInputStreamBufferConfig == null) goto L9;
        r2.putString(KEY_PATH_CRONET_INPUTSTREAM_BUFF_SIZE, sInputStreamBufferConfig);
        return;
    }

    private SsCronetHttpClient(Context r1) {
        sContext = r1.getApplicationContext();
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
        return new CronetSsCall(r6);
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

    public void tryCreateCronetEngine(boolean r13, boolean r14, boolean r15, boolean r16, boolean r17, ICronetAppProvider r18) {
        tryResolveImpl();
        ICronetClient r1 = sCronetClient;
        if (r1 == null) goto L6;
        r1.setCronetBootFailureCheckerProvider(this);
        sCronetClient.setCronetThreadStackOptFailureCheckerProvider(this);
        sCronetClient.tryCreateCronetEngine(sContext, r13, r14, r15, r16, NetworkParams.getUserAgent(), new SsHttpExecutor(), r17, r18);
        return;
    }

    protected static HttpURLConnection openConnection(String r10, BaseHttpRequestInfo r11) throws IOException {
        tryResolveImpl();
        ICronetClient r0 = sCronetClient;
        if (r0 == null) goto L11;
        r0.setCronetBootFailureCheckerProvider(sInstance);
        sCronetClient.setCronetThreadStackOptFailureCheckerProvider(sInstance);
        ICronetClient r2 = sCronetClient;
        Context r3 = sContext;
        ICronetHttpDnsConfig r1 = sCronetHttpDnsConfig;
        if (r1 != null) goto L7;
        boolean r4 = false;
    L8:
        HttpURLConnection r12 = r2.openConnection(r3, r10, r4, NetworkParams.getUserAgent(), r11.useCronetInputStreamWithTTBuffer, new SsHttpExecutor(), sCronetAppProvider);
        r12.setConnectTimeout(NetworkParams.getConnectTimeout());
        r12.setReadTimeout(NetworkParams.getIoTimeout());
        return r12;
    L7:
        r4 = r1.isCronetHttpDnsOpen();
        goto L8
    L11:
        throw new IllegalArgumentException("CronetClient is null");
    }

    public static Context getContext() {
        return sContext;
    }

    public static ICronetClient getCronetClient() {
        return sCronetClient;
    }

    private static void checkCronetClientCreated() {
        if (sCronetClient == null) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public static String getCronetVersion() throws Exception {
        checkCronetClientCreated();
        return sCronetClient.getCronetVersion();
    }

    protected static Map<String, Object> getRequestMetricsMap(HttpURLConnection r1) {
        ICronetClient r0 = sCronetClient;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRequestMetricsMap(r1);
    }

    public static int getCronetInternalErrorCode(HttpURLConnection r1) {
        return sCronetClient.getCronetInternalErrorCode(r1);
    }

    public void triggerGetDomain(boolean r1) {
        if (sCronetClient != null) goto L6;
        return;
    L6:
        if (ProcessUtils.isMainProcessByProcessFlag(sContext) == true) goto L8;
        return;
    L8:
        sCronetClient.triggerGetDomain(r1);
    }

    public void runInBackGround(boolean r1) {
        if (sCronetClient != null) goto L6;
        return;
    L6:
        if (ProcessUtils.isMainProcessByProcessFlag(sContext) == true) goto L8;
        return;
    L8:
        sCronetClient.runInBackGround(r1);
    }

    public void addClientOpaqueData(String[] r9, byte[] r10, byte[] r11, long r12, long r14) {
        if (sCronetClient != null) goto L6;
        return;
    L6:
        if (ProcessUtils.isMainProcessByProcessFlag(sContext) == true) goto L8;
        return;
    L8:
        sCronetClient.addClientOpaqueData(r9, r10, r11, r12, r14);
    }

    public void clearClientOpaqueData() {
        if (sCronetClient != null) goto L6;
        return;
    L6:
        if (ProcessUtils.isMainProcessByProcessFlag(sContext) == true) goto L8;
        return;
    L8:
        sCronetClient.clearClientOpaqueData();
    }

    public void removeClientOpaqueData(String r1) {
        if (sCronetClient != null) goto L6;
        return;
    L6:
        if (ProcessUtils.isMainProcessByProcessFlag(sContext) == true) goto L8;
        return;
    L8:
        sCronetClient.removeClientOpaqueData(r1);
    }

    public static TTDispatchResult ttUrlDispatch(String r1, int r2, boolean r3) throws Exception {
        checkCronetClientCreated();
        return sCronetClient.ttUrlDispatch(r1, r2, r3);
    }

    public void preconnectUrl(String r1, Map<String, String> r2) throws Exception {
        checkCronetClientCreated();
        sCronetClient.preconnectUrl(r1, r2);
    }

    public void tryStartNetDetect(String[] r1, int r2, int r3) throws Exception {
        checkCronetClientCreated();
        sCronetClient.tryStartNetDetect(r1, r2, r3);
    }

    public void ttDnsResolve(String r1, int r2, String r3, Map<String, String> r4) throws Exception {
        checkCronetClientCreated();
        sCronetClient.ttDnsResolve(r1, r2, r3, r4);
    }

    public void getMappingRequestState(String r1) {
        checkCronetClientCreated();
        sCronetClient.getMappingRequestState(r1);
    }

    public int getEffectiveConnectionType() throws Exception {
        checkCronetClientCreated();
        return sCronetClient.getEffectiveConnectionType();
    }

    public void notifyTNCConfigUpdated(String r8, String r9, String r10, String r11, String r12, String r13) throws Exception {
        checkCronetClientCreated();
        sCronetClient.notifyTNCConfigUpdated(r8, r9, r10, r11, r12, r13);
    }

    public static void notifyStoreRegionUpdated(String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22) throws Exception {
        checkCronetClientCreated();
        sCronetClient.notifyStoreRegionUpdated(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public void setProxy(String r1) throws Exception {
        checkCronetClientCreated();
        sCronetClient.setProxy(r1);
    }

    public NetworkQuality getNetworkQuality() throws Exception {
        checkCronetClientCreated();
        return sCronetClient.getNetworkQuality();
    }

    public PacketLossMetrics getPacketLossRateMetrics(int r1) throws Exception {
        checkCronetClientCreated();
        return sCronetClient.getPacketLossRateMetrics(r1);
    }

    public Map<String, NetworkQuality> getGroupRttEstimates() throws Exception {
        checkCronetClientCreated();
        return sCronetClient.getGroupRttEstimates();
    }

    public void setHostResolverRules(String r1) throws Exception {
        checkCronetClientCreated();
        sCronetClient.setHostResolverRules(r1);
    }

    public void setAlogFuncAddr(long r1) throws Exception {
        checkCronetClientCreated();
        sCronetClient.setAlogFuncAddr(r1);
    }

    public void setZstdFuncAddr(long r18, long r20, long r22, long r24, long r26, long r28, long r30, long r32) throws Exception {
        checkCronetClientCreated();
        sCronetClient.setZstdFuncAddr(r18, r20, r22, r24, r26, r28, r30, r32);
    }

    public void startThrottle(String[] r1, int r2, long r3) {
        checkCronetClientCreated();
        sCronetClient.startThrottle(r1, r2, r3);
    }

    public void stopThrottle(String[] r1, int r2) {
        checkCronetClientCreated();
        sCronetClient.stopThrottle(r1, r2);
    }

    public static void setBestHostWithRouteSelectionName(String r1, String r2) throws Exception {
        checkCronetClientCreated();
        sCronetClient.setBestHostWithRouteSelectionName(r1, r2);
    }

    public void setCookieInitCompleted() {
        checkCronetClientCreated();
        sCronetClient.setCookieInitCompleted();
    }

    public boolean notifySwitchToMultiNetwork(boolean r1) throws Exception {
        checkCronetClientCreated();
        return sCronetClient.notifySwitchToMultiNetwork(r1);
    }

    public void triggerSwitchingToCellular() throws Exception {
        checkCronetClientCreated();
        sCronetClient.triggerSwitchingToCellular();
    }

    public int getNetworkQualityLevel() throws Exception {
        checkCronetClientCreated();
        return sCronetClient.getNetworkQualityLevel();
    }

    public int getEffectiveHttpRttMs() throws Exception {
        checkCronetClientCreated();
        return sCronetClient.getEffectiveHttpRttMs();
    }

    public int getEffectiveTransportRttMs() throws Exception {
        checkCronetClientCreated();
        return sCronetClient.getEffectiveTransportRttMs();
    }

    public int getEffectiveRxThroughputKbps() throws Exception {
        checkCronetClientCreated();
        return sCronetClient.getEffectiveRxThroughputKbps();
    }

    public void reportNetDiagnosisUserLog(String r1) throws Exception {
        checkCronetClientCreated();
        sCronetClient.reportNetDiagnosisUserLog(r1);
    }

    public void enableTTBizHttpDns(boolean r8, String r9, String r10, String r11, boolean r12, String r13) throws Exception {
        checkCronetClientCreated();
        sCronetClient.enableTTBizHttpDns(r8, r9, r10, r11, r12, r13);
    }

    public static void bindBigCore(TTNetThreadConfig.ThreadType r1) throws Exception {
        checkCronetClientCreated();
        sCronetClient.bindBigCore(r1);
    }

    public static void bindLittleCore(TTNetThreadConfig.ThreadType r1) throws Exception {
        checkCronetClientCreated();
        sCronetClient.bindLittleCore(r1);
    }

    public static void resetCoreBind(TTNetThreadConfig.ThreadType r1) throws Exception {
        checkCronetClientCreated();
        sCronetClient.resetCoreBind(r1);
    }

    public void setSlaSamplingSetting(JSONObject r1) throws Exception {
        checkCronetClientCreated();
        sCronetClient.setSlaSamplingSetting(r1);
    }
}
