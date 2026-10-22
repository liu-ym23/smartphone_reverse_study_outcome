package com.bytedance.frameworks.baselib.network.http.cronet;

import android.content.Context;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.NetworkQuality;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.PacketLossMetrics;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.TTDispatchResult;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface ICronetClient {
    public static final String KEY_BYPASS_API_REPORT = "bypass_api_report";
    public static final String KEY_CONNECT_TIME = "connect_time";
    public static final String KEY_DNS_TIME = "dns_time";
    public static final String KEY_POST_TASK_START = "post_task_start";
    public static final String KEY_PRE_SAMPLING_REPORTABLE = "pre_sampling_reportable";
    public static final String KEY_PUSH_TIME = "push_time";
    public static final String KEY_RECEIVED_BYTE_COUNT = "received_byte_count";
    public static final String KEY_RECEIVE_TIME = "receive_time";
    public static final String KEY_REMOTE_IP = "remote_ip";
    public static final String KEY_REQUEST_HEADERS = "request_headers";
    public static final String KEY_REQUEST_LOG = "request_log";
    public static final String KEY_REQUEST_START = "request_start";
    public static final String KEY_REQ_COOKIE_SOURCE_TYPE = "req_cookie_source_type";
    public static final String KEY_RESPONSE_HEADERS = "response_headers";
    public static final String KEY_RETRY_ATTEMPTS = "retry_attempts";
    public static final String KEY_SEND_BYTE_COUNT = "send_byte_count";
    public static final String KEY_SEND_TIME = "send_time";
    public static final String KEY_SOCKET_REUSED = "socket_reused";
    public static final String KEY_SSL_TIME = "ssl_time";
    public static final String KEY_TOTAL_TIME = "total_time";
    public static final String KEY_TTFB = "ttfb";
    public static final String KEY_UPPER_ADD_COOKIE_US = "upper_add_cookie_us";
    public static final String KEY_UPPER_SAVE_COOKIE_US = "upper_save_cookie_us";
    public static final String KEY_WAIT_CONTEXT = "wait_ctx";

    public interface ICronetBootFailureCheckerProvider {
        boolean isCronetBootFailureExpected();
    }

    public interface ICronetThreadStackOptFailureCheckerProvider {
        String getThreadStackInitReason();

        boolean isCronetThreadStackOptFailureExpected();
    }

    void addClientOpaqueData(String[] r1, byte[] r2, byte[] r3, long r4, long r6);

    void bindBigCore(TTNetThreadConfig.ThreadType r1) throws Exception;

    void bindLittleCore(TTNetThreadConfig.ThreadType r1) throws Exception;

    void clearClientOpaqueData();

    void enableTTBizHttpDns(boolean r1, String r2, String r3, String r4, boolean r5, String r6) throws Exception;

    int getCronetInternalErrorCode(HttpURLConnection r1);

    String getCronetVersion();

    int getEffectiveConnectionType() throws Exception;

    int getEffectiveHttpRttMs() throws Exception;

    int getEffectiveRxThroughputKbps() throws Exception;

    int getEffectiveTransportRttMs() throws Exception;

    Map<String, NetworkQuality> getGroupRttEstimates() throws Exception;

    void getMappingRequestState(String r1);

    NetworkQuality getNetworkQuality() throws Exception;

    int getNetworkQualityLevel() throws Exception;

    PacketLossMetrics getPacketLossRateMetrics(int r1) throws Exception;

    Map<String, Object> getRequestMetricsMap(HttpURLConnection r1);

    boolean isCronetHttpURLConnection(HttpURLConnection r1);

    void notifyStoreRegionUpdated(String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11) throws Exception;

    boolean notifySwitchToMultiNetwork(boolean r1) throws Exception;

    void notifyTNCConfigUpdated(String r1, String r2, String r3, String r4, String r5, String r6) throws Exception;

    HttpURLConnection openConnection(Context r1, String r2, boolean r3, String r4, boolean r5, Executor r6, ICronetAppProvider r7) throws IOException;

    void preconnectUrl(String r1, Map<String, String> r2) throws Exception;

    void removeClientOpaqueData(String r1);

    void reportNetDiagnosisUserLog(String r1) throws Exception;

    void resetCoreBind(TTNetThreadConfig.ThreadType r1) throws Exception;

    void runInBackGround(boolean r1);

    void setAlogFuncAddr(long r1) throws Exception;

    void setBestHostWithRouteSelectionName(String r1, String r2) throws Exception;

    void setCookieInitCompleted();

    void setCronetBootFailureCheckerProvider(ICronetBootFailureCheckerProvider r1);

    void setCronetThreadStackOptFailureCheckerProvider(ICronetThreadStackOptFailureCheckerProvider r1);

    void setHostResolverRules(String r1) throws Exception;

    void setHttpDnsForTesting(boolean r1, boolean r2, boolean r3) throws Exception;

    void setProxy(String r1) throws Exception;

    void setSlaSamplingSetting(JSONObject r1) throws Exception;

    void setZstdFuncAddr(long r1, long r3, long r5, long r7, long r9, long r11, long r13, long r15) throws Exception;

    void startThrottle(String[] r1, int r2, long r3);

    void stopThrottle(String[] r1, int r2);

    void triggerGetDomain(boolean r1);

    void triggerSwitchingToCellular();

    void tryCreateCronetEngine(Context r1, boolean r2, boolean r3, boolean r4, boolean r5, String r6, Executor r7, boolean r8, ICronetAppProvider r9);

    void tryStartNetDetect(String[] r1, int r2, int r3) throws Exception;

    void ttDnsResolve(String r1, int r2, String r3, Map<String, String> r4) throws Exception;

    TTDispatchResult ttUrlDispatch(String r1, int r2, boolean r3) throws Exception;
}
