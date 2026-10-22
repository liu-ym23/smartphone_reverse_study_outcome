package com.bytedance.frameworks.baselib.network.http;

import android.os.Looper;
import android.os.SystemClock;
import android.webkit.CookieManager;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.impl.CookieManagerWrap;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.SsHttpCall;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.ttnet.ExceptionReportable;
import com.bytedance.retrofit2.ttnet.TTNetExceptionStorage;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkParams {
    public static final String BDTURING_VERIFY_HEADER = "bdturing-verify";
    public static final String BYPASS_BDTURING_HEADER_KEY = "x-tt-bypass-bdturing";
    private static final String BYPASS_RETRY_BY_HEADER_KEY_PREFIX = "x-tt-bypass-retry-by-";
    public static final String BYPASS_RETRY_FOR_ACCOUNT_KEY = "x-tt-bypass-retry-for-account";
    public static final int CONNECT_TIMEOUT = 15000;
    public static final int IO_TIMEOUT = 15000;
    public static final String PNAME_REMOTE_ADDRESS = "x-net-info.remoteaddr";
    public static final String RETRY_FOR_ACCOUNT_REQUEST_KEY = "x-tt-retry-for-account";
    public static final String RETRY_REQUEST_BY_BDTURING_HEADER = "x-tt-bdturing-retry";
    private static final String RETRY_REQUEST_BY_HEADER_KEY_PREFIX = "x-tt-retry-by-";
    private static final String RETRY_REQUEST_BY_HEADER_RESPONSE_KEYWORD = "verify";
    private static final int WAIT_COOKIE_INIT_TIME = 5000;
    private static volatile addResponseHeadersCallback sAddResponseHeadersCallback;
    private static AddSecurityFactorProcessCallback sAddSecurityFactorProcessCallback;
    private static AllErrorReportHook sAllErrorReportHook;
    private static ApiRequestInterceptor sApiInterceptor;
    private static ApiProcessHook sApiProcessHook;
    private static AppCookieStore sAppCookieStore;
    private static CdnConnectionQualitySamplerHook sCdnConnectionQualitySamplerHook;
    private static CommandListener sCommandListener;
    private static ConnectionQualitySamplerHook sConnectionQualitySamplerHook;
    private static CountDownLatch sCookieInitedCountDown;
    private static final Object sCookieLock = null;
    private static volatile AtomicBoolean sCookieMgrInited;
    private static CookieShareInterceptor sCookieShareInterceptor;
    private static boolean sEnableMainThreadCheck;
    private static MonitorProcessHook sMonitorProcessHook;
    private static volatile boolean sNewCookieBlockPositionEnabled;
    private static OldMonitorProcessHook sOldMonitorProcessHook;
    private static boolean sPrivateProtocolEnabled;
    private static volatile RetryForAccountRequestCallback sRetryForAccountRequestCallback;
    private static final Map<String, RetryRequestByHeaderCallback> sRetryRequestByHeaderCallbackMap = null;
    private static volatile RetryRequestByTuringHeaderCallback sRetryRequestCallback;
    private static StreamProcessor sStreamProcessor;
    private static final TTNetCallMonitor sTTNetCallMonitor = null;
    private static volatile int sUseDnsMapping;
    private static String sUserAgent;

    public interface AddSecurityFactorProcessCallback {
        Map<String, String> onCallToAddSecurityFactor(String r1, Map<String, List<String>> r2);
    }

    public interface AllErrorReportHook {
        boolean isAllErrorReport();
    }

    public interface ApiProcessHook<T extends BaseHttpRequestInfo> {
        String addCommonParams(String r1, boolean r2);

        default Map<String, String> addCommonParamsByLevel(String r1, boolean r2, int r3) {
            return null;
        }

        String addRequestVertifyParams(String r1, boolean r2, Object... r3);

        @Deprecated
        Map<String, String> getCommonParamsByLevel(int r1);

        @Deprecated
        void handleApiError(String r1, Throwable r2, long r3, T r5);

        @Deprecated
        void handleApiOk(String r1, long r2, T r4);

        void onTryInit();

        void putCommonParams(Map<String, String> r1, boolean r2);
    }

    public interface ApiRequestInterceptor<T extends BaseRequestContext> {
        String filterUrl(String r1, T r2);

        boolean isOkHttp3Open();

        boolean isOkHttpOpen();

        void monitorApiHttp(String r1, String r2, boolean r3) throws IOException;

        @Deprecated
        List<InetAddress> resolveInetAddresses(String r1);

        @Deprecated
        String tryDnsMapping(String r1, String[] r2);
    }

    public interface AppCookieStore {
        Map<String, List<String>> get(URI r1, Map<String, List<String>> r2);

        void put(URI r1, Map<String, List<String>> r2);
    }

    public interface CdnConnectionQualitySamplerHook {
        boolean cdnShouldSampling(String r1);
    }

    public interface CommandListener {
        String getHeaderKey();

        void onCommandReceived(List<String> r1);
    }

    public interface ConnectionQualitySamplerHook {
        boolean shouldSampling(String r1);
    }

    public interface CookieShareInterceptor {
        List<String> getShareCookie(CookieManager r1, CookieManagerWrap r2, URI r3);

        List<String> getShareCookieHostList(String r1);
    }

    public interface GetRequestHeaderValueCallback {
        String onGetRequestHeaderValue(String r1);
    }

    public interface MonitorProcessHook<T extends BaseHttpRequestInfo> {
        default boolean handleApiSample(String r1, String r2) {
            return false;
        }

        void monitorApiError(long r1, long r3, String r5, String r6, T r7, Throwable r8);

        void monitorApiOk(long r1, long r3, String r5, String r6, T r7);
    }

    public interface OldMonitorProcessHook {
        boolean getOldmonitorSwitch();
    }

    public interface RetryForAccountRequestCallback {
        RequestRetryResult onCallToRetryForAccountRequest(String r1, List<Header> r2, Map<String, List<String>> r3, boolean r4);
    }

    public interface RetryRequestByHeaderCallback {
        RequestRetryResult onCallToRetryRequestByHeader(Map<String, List<String>> r1);
    }

    public interface RetryRequestByTuringHeaderCallback {
        RequestRetryResult onCallToRetryRequestByTuringHeader(Map<String, List<String>> r1);
    }

    public interface StreamProcessor {
        InputStream processInputStream(InputStream r1, Map<String, List<String>> r2, RetrofitMetrics r3);
    }

    public static final class TTNetCallMonitor implements SsHttpCall.IHttpCallMonitor {
        public TTNetCallMonitor() {
        }

        @Override // com.bytedance.retrofit2.SsHttpCall.IHttpCallMonitor
        public void monitorApiOK(long r9, long r11, String r13, String r14, Object r15) {
            if (NetworkParams.access$000() != null) goto L5;
            return;
        L5:
            if (r15 == null) goto L11;
            BaseHttpRequestInfo r7 = (BaseHttpRequestInfo) r15;
            if (StringUtils.isEmpty(r7.requestLog) == true) goto L12;
            NetworkParams.access$000().monitorApiOk(r9, r11, r13, r14, r7);
            return;
        L12:
            return;
        }

        @Override // com.bytedance.retrofit2.SsHttpCall.IHttpCallMonitor
        public void monitorApiError(long r11, long r13, String r15, String r16, Object r17, Throwable r18) {
            if (NetworkParams.access$000() != null) goto L5;
            return;
        L5:
            if (r17 == null) goto L11;
            BaseHttpRequestInfo r8 = (BaseHttpRequestInfo) r17;
            if (StringUtils.isEmpty(r8.requestLog) == true) goto L12;
            NetworkParams.access$000().monitorApiError(r11, r13, r15, r16, r8, r18);
            return;
        L12:
            return;
        }

        @Override // com.bytedance.retrofit2.SsHttpCall.IHttpCallMonitor
        public boolean handleApiSample(String r1, String r2) {
            if (NetworkParams.access$000() != null) goto L7;
            return false;
        L7:
            return NetworkParams.access$000().handleApiSample(r1, r2);
        }

        @Override // com.bytedance.retrofit2.SsHttpCall.IHttpCallMonitor
        public boolean isAllErrorReport() {
            if (NetworkParams.access$100() != null) goto L7;
            return false;
        L7:
            return NetworkParams.access$100().isAllErrorReport();
        }
    }

    public interface addResponseHeadersCallback {
        boolean onCallToRetryRequestByTuringHeader(Map<String, List<String>> r1);
    }

    public static int getConnectTimeout() {
        return 15000;
    }

    public static int getIoTimeout() {
        return 15000;
    }

    @Deprecated
    public static void setDynamicTimeOutEnable(boolean r0) {
    }

    public NetworkParams() {
    }

    static /* synthetic */ MonitorProcessHook access$000() {
        return sMonitorProcessHook;
    }

    static /* synthetic */ AllErrorReportHook access$100() {
        return sAllErrorReportHook;
    }

    public static void setAllErrorReportHook(AllErrorReportHook r0) {
        sAllErrorReportHook = r0;
    }

    static {
        sTTNetCallMonitor = new TTNetCallMonitor();
        sStreamProcessor = null;
        sUserAgent = null;
        sCookieMgrInited = new AtomicBoolean(false);
        sCookieLock = new Object();
        sCookieInitedCountDown = new CountDownLatch(1);
        sUseDnsMapping = -1;
        sRetryRequestByHeaderCallbackMap = new ConcurrentHashMap();
        sNewCookieBlockPositionEnabled = false;
        sEnableMainThreadCheck = false;
        sPrivateProtocolEnabled = true;
    }

    public static void setConnectionQualitySamplerHook(ConnectionQualitySamplerHook r0) {
        sConnectionQualitySamplerHook = r0;
    }

    public static ConnectionQualitySamplerHook getConnectionQualitySamplerHook() {
        return sConnectionQualitySamplerHook;
    }

    public static void setCdnConnectionQualitySamplerHook(CdnConnectionQualitySamplerHook r0) {
        sCdnConnectionQualitySamplerHook = r0;
    }

    public static CdnConnectionQualitySamplerHook getCdnConnectionQualitySamplerHook() {
        return sCdnConnectionQualitySamplerHook;
    }

    public static void setStreamProcessor(StreamProcessor r0) {
        sStreamProcessor = r0;
    }

    public static StreamProcessor getStreamProcessor() {
        return sStreamProcessor;
    }

    public static String getUserAgent() {
        return sUserAgent;
    }

    public static void setDefaultUserAgent(String r6) {
        if (r6 != null) goto L19;
    L16:
        sUserAgent = r6;
        return;
    L19:
        if (r6.length() <= 0) goto L16;
        char[] r0 = r6.toCharArray();     // Catch: Exception -> L18
        int r1 = r0.length;     // Catch: Exception -> L18
        int r2 = 0;
        boolean r3 = false;
    L6:
        if (r2 >= r1) goto L13;
        char r4 = r0[r2];     // Catch: Exception -> L18
        if (r4 >= ' ') goto L10;
    L11:
        r0[r2] = '?';     // Catch: Exception -> L18
        r3 = true;
    L12:
        r2 = r2 + 1;     // Catch: Exception -> L18
        goto L6
    L10:
        if (r4 <= '~') goto L12;
    L13:
        if (r3 == false) goto L16;
        r6 = new String(r0);     // Catch: Exception -> L18
        goto L16
    }

    public static void setCommandListener(CommandListener r0) {
        sCommandListener = r0;
    }

    public static CommandListener getCommandListener() {
        return sCommandListener;
    }

    public static void setApiProcessHook(ApiProcessHook r0) {
        sApiProcessHook = r0;
    }

    public static void setMonitorProcessHook(MonitorProcessHook r0) {
        sMonitorProcessHook = r0;
        SsHttpCall.setCallMonitor(sTTNetCallMonitor);
    }

    public static void setOldMonitorProcessHook(OldMonitorProcessHook r0) {
        sOldMonitorProcessHook = r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void reportOneNormalRequest(Throwable r10, String r11, long r12, Request r14, BaseHttpRequestInfo r15, Boolean r16) {
        if (r10 != 0) goto L6;
        monitorApiSample(r15.requestEnd - r12, r12, r14.getUrl(), r11, r15);
        return;
    L6:
        if ((r10 instanceof TTNetExceptionStorage) == false) goto L16;
        TTNetExceptionStorage r9 = (TTNetExceptionStorage) r10;
        if (r9.needReport == false) goto L16;
        if (r9.reportMonitorOk == false) goto L13;
        monitorApiSample(r15.requestEnd - r12, r12, r14.getUrl(), r11, r15);
    L13:
        if (r9.reportMonitorError == false) goto L25;
        monitorApiError(r15.requestEnd - r12, r12, r14.getUrl(), r11, r15, r10);
        return;
    L25:
        return;
    L16:
        if ((r10 instanceof ExceptionReportable) == false) goto L21;
        if (((ExceptionReportable) r10).shouldReport() == false) goto L27;
        monitorApiError(r15.requestEnd - r12, r12, r14.getUrl(), r11, r15, r10);
        return;
    L27:
        return;
    L21:
        if (r16.booleanValue() == false) goto L29;
        monitorApiError(r15.requestEnd - r12, r12, r14.getUrl(), r11, r15, r10);
        return;
    }

    public static void handleApiError(String r7, Throwable r8, long r9, BaseHttpRequestInfo r11) {
        if (StringUtils.isEmpty(r7) == true) goto L13;
        if (r8 == null) goto L17;
        ApiProcessHook r1 = sApiProcessHook;
        OldMonitorProcessHook r0 = sOldMonitorProcessHook;
        if (r1 == null) goto L14;
        if (r0 != null) goto L10;
        return;
    L10:
        if (r0.getOldmonitorSwitch() == false) goto L16;
        r1.handleApiError(r7, r8, r9, r11);
        return;
    L16:
        return;
    L14:
        return;
    L17:
        return;
    }

    public static void monitorApiError(long r9, long r11, String r13, String r14, BaseHttpRequestInfo r15, Throwable r16) {
        if (r15 != null) goto L5;
        return;
    L5:
        if (StringUtils.isEmpty(r15.requestLog) == false) goto L8;
        return;
    L8:
        if (StringUtils.isEmpty(r13) == true) goto L19;
        if (r16 == null) goto L22;
        MonitorProcessHook r0 = sMonitorProcessHook;
        if (r0 != null) goto L14;
        return;
    L14:
        if (r15.downloadFile == false) goto L16;
        r15.hasReportStreamingApiAll.set(true);
    L16:
        r0.monitorApiError(r9, r11, r13, r14, r15, r16);
        return;
    L22:
        return;
    }

    public static void handleApiOk(String r4, long r5, BaseHttpRequestInfo r7) {
        ApiProcessHook r0 = sApiProcessHook;
        OldMonitorProcessHook r1 = sOldMonitorProcessHook;
        if (StringUtils.isEmpty(r4) == false) goto L5;
        return;
    L5:
        if (r5 <= 0) goto L13;
        if (r0 == null) goto L14;
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.getOldmonitorSwitch() == false) goto L16;
        r0.handleApiOk(r4, r5, r7);
        return;
    L16:
        return;
    L14:
        return;
    }

    public static void monitorApiSample(long r9, long r11, String r13, String r14, BaseHttpRequestInfo r15) {
        if (r15 != null) goto L4;
        return;
    L4:
        if (StringUtils.isEmpty(r15.requestLog) == true) goto L25;
        MonitorProcessHook r1 = sMonitorProcessHook;
        if (StringUtils.isEmpty(r13) == false) goto L9;
        return;
    L9:
        if (r9 <= 0) goto L22;
        if (r1 != null) goto L12;
        return;
    L12:
        if (r15.downloadFile == false) goto L16;
        if (r15.hasReportStreamingApiAll.get() == false) goto L16;
        return;
    L16:
        if (r15.downloadFile == false) goto L18;
        r15.hasReportStreamingApiAll.set(true);
    L18:
        r1.monitorApiOk(r9, r11, r13, r14, r15);
        return;
    L22:
        return;
    }

    public static boolean handleApiSample(String r2, String r3) {
        MonitorProcessHook r0 = sMonitorProcessHook;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (StringUtils.isEmpty(r2) == false) goto L7;
        return false;
    L7:
        if (StringUtils.isEmpty(r3) == false) goto L9;
        return false;
    L9:
        return r0.handleApiSample(r2, r3);
    }

    public static void setCookieMgrInited(boolean r1) {
        if (sCookieMgrInited.get() != r1) goto L5;
        return;
    L5:
        sCookieMgrInited.getAndSet(r1);
        cookieInitedCountDown();
        if (r1 == true) goto L9;
        sCookieInitedCountDown = new CountDownLatch(1);
        return;
    }

    private static void cookieInitedCountDown() {
        CountDownLatch r0 = sCookieInitedCountDown;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getCount() <= 0) goto L9;
        sCookieInitedCountDown.countDown();
        return;
    }

    public static CookieManager tryNecessaryInit() {
        return tryNecessaryInit("");
    }

    public static CookieManager tryNecessaryInit(String r0) {
        tryApiProcessHookInit();
        return tryCookieManagerInit();
    }

    public static void tryApiProcessHookInit() {
        ApiProcessHook r0 = sApiProcessHook;
        if (r0 == null) goto L6;
        r0.onTryInit();
        return;
    }

    public static CookieManager tryCookieManagerInit() {
        Object r0 = sCookieLock;
        monitor-enter(r0);
    L21:
        th = move-exception;
        throw th;
    L6:
        if (sCookieMgrInited.get() == false) goto L26;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L21
        CookieManager r1 = CookieManager.getInstance();     // Catch: Throwable -> L19
        if (r1.acceptCookie() == true) goto L34;
        r1.setAcceptCookie(true);     // Catch: Throwable -> L24
        return r1;
    L34:
        return r1;
    L36:
        return r1;
    L19:
        return null;
    L26:
        CountDownLatch r2 = sCookieInitedCountDown;     // Catch: Exception -> L25 Throwable -> L21
        if (r2 == null) goto L12;
        r2.await(5000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L25 Throwable -> L21
        if (sCookieInitedCountDown.getCount() != 1) goto L12;
        sCookieInitedCountDown.countDown();     // Catch: Exception -> L25 Throwable -> L21
    L12:
        sCookieMgrInited.getAndSet(true);     // Catch: Throwable -> L21
        goto L13
    }

    @Deprecated
    public static void setUseDnsMapping(int r0) {
        sUseDnsMapping = r0;
    }

    @Deprecated
    public static boolean getUseDnsMapping() {
        if (sUseDnsMapping == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static void setApiRequestInterceptor(ApiRequestInterceptor r0) {
        sApiInterceptor = r0;
    }

    public static ApiRequestInterceptor getApiRequestInterceptor() {
        return sApiInterceptor;
    }

    public static void setCookieShareInterceptor(CookieShareInterceptor r0) {
        sCookieShareInterceptor = r0;
    }

    public static CookieShareInterceptor getCookieShareInterceptor() {
        return sCookieShareInterceptor;
    }

    public static void setAppCookieStore(AppCookieStore r0) {
        sAppCookieStore = r0;
    }

    public static AppCookieStore getAppCookieStore() {
        return sAppCookieStore;
    }

    public static String filterUrl(String r1) {
        return filterUrl(r1, null);
    }

    public static String filterUrl(String r1, BaseRequestContext r2) {
        if (StringUtils.isEmpty(r1) == false) goto L5;
        return r1;
    L5:
        ApiRequestInterceptor r0 = sApiInterceptor;
        if (r0 != null) goto L8;
        return r1;
    L8:
        return r0.filterUrl(r1, r2);
    }

    public static void monitorApiHttp(String r1, String r2, boolean r3) throws IOException {
        if (StringUtils.isEmpty(r1) == false) goto L5;
        return;
    L5:
        if (StringUtils.isEmpty(r2) == true) goto L13;
        ApiRequestInterceptor r0 = sApiInterceptor;
        if (r0 == null) goto L12;
        r0.monitorApiHttp(r1, r2, r3);
        return;
    L12:
        return;
    }

    public static String addCommonParams(String r1, boolean r2) {
        ApiProcessHook r0 = sApiProcessHook;
        if (r0 != null) goto L5;
        return r1;
    L5:
        return r0.addCommonParams(r1, r2);
    }

    public static Map<String, String> addCommonParamsByLevel(String r1, boolean r2, int r3) {
        ApiProcessHook r0 = sApiProcessHook;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.addCommonParamsByLevel(r1, r2, r3);
    }

    public static Map<String, String> getCommonParamsByLevel(int r1) {
        ApiProcessHook r0 = sApiProcessHook;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getCommonParamsByLevel(r1);
    }

    public static String tryAddRequestVertifyParams(String r1, boolean r2, Object... r3) {
        ApiProcessHook r0 = sApiProcessHook;
        if (r0 != null) goto L5;
        return r1;
    L5:
        return r0.addRequestVertifyParams(r1, r2, r3);
    }

    public static void putCommonParams(Map<String, String> r1, boolean r2) {
        ApiProcessHook r0 = sApiProcessHook;
        if (r0 == null) goto L6;
        r0.putCommonParams(r1, r2);
        return;
    }

    @Deprecated
    public static synchronized void setAddResponseHeadersCallback(addResponseHeadersCallback r1) {
        monitor-enter(NetworkParams.class);
        sAddResponseHeadersCallback = r1;     // Catch: Throwable -> L7
        monitor-exit(NetworkParams.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void setRetryRequestCallback(RetryRequestByTuringHeaderCallback r1) {
        monitor-enter(NetworkParams.class);
        sRetryRequestCallback = r1;     // Catch: Throwable -> L7
        monitor-exit(NetworkParams.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean addRetryRequestByHeaderCallback(String r4, RetryRequestByHeaderCallback r5) {
        monitor-enter(NetworkParams.class);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (StringUtils.isEmpty(r4) == true) goto L19;
        if (r5 == null) goto L19;
        Iterator<String> r1 = sRetryRequestByHeaderCallbackMap.keySet().iterator();     // Catch: Throwable -> L21
    L10:
        if (r1.hasNext() == false) goto L15;
        if (r1.next().equalsIgnoreCase(r4) == false) goto L10;
        monitor-exit(NetworkParams.class);
        return false;
    L15:
        sRetryRequestByHeaderCallbackMap.put(r4, r5);     // Catch: Throwable -> L21
        monitor-exit(NetworkParams.class);
        return true;
    L19:
        monitor-exit(NetworkParams.class);
        return false;
    }

    public static synchronized boolean removeRetryRequestByHeaderCallback(String r5) {
        monitor-enter(NetworkParams.class);
    L20:
        th = move-exception;
        throw th;
    L6:
        if (StringUtils.isEmpty(r5) == false) goto L9;
        monitor-exit(NetworkParams.class);
        return false;
    L9:
        Iterator<String> r1 = sRetryRequestByHeaderCallbackMap.keySet().iterator();     // Catch: Throwable -> L20
    L11:
        if (r1.hasNext() == false) goto L18;
        String r3 = r1.next();     // Catch: Throwable -> L20
        if (r3.equalsIgnoreCase(r5) == false) goto L11;
        sRetryRequestByHeaderCallbackMap.remove(r3);     // Catch: Throwable -> L20
        monitor-exit(NetworkParams.class);
        return true;
    L18:
        monitor-exit(NetworkParams.class);
        return false;
    }

    private static synchronized Map.Entry<String, RetryRequestByHeaderCallback> getRetryRequestByHeaderCallbackEntry(Set<String> r6) {
        monitor-enter(NetworkParams.class);
        Iterator<Map.Entry<String, RetryRequestByHeaderCallback>> r1 = sRetryRequestByHeaderCallbackMap.entrySet().iterator();     // Catch: Throwable -> L19
    L6:
        if (r1.hasNext() == false) goto L16;
        Map.Entry<String, RetryRequestByHeaderCallback> r2 = r1.next();     // Catch: Throwable -> L19
        Iterator<String> r3 = r6.iterator();     // Catch: Throwable -> L19
    L9:
        if (r3.hasNext() == false) goto L6;
        String r4 = r3.next();     // Catch: Throwable -> L19
        if (StringUtils.isEmpty(r4) == true) goto L9;
        if (r4.equalsIgnoreCase(r2.getKey()) == false) goto L9;
        monitor-exit(NetworkParams.class);
        return r2;
    L16:
        monitor-exit(NetworkParams.class);
        return null;
    L19:
        th = move-exception;
        throw th;
    }

    private static RequestRetryResult onCallToResponseCallback(Map<String, List<String>> r2) {
        if (sRetryRequestCallback == null) goto L7;
        RequestRetryResult r0 = sRetryRequestCallback.onCallToRetryRequestByTuringHeader(r2);
        r2.remove(BDTURING_VERIFY_HEADER);
        return r0;
    L7:
        if (sAddResponseHeadersCallback == null) goto L11;
        boolean r1 = sAddResponseHeadersCallback.onCallToRetryRequestByTuringHeader(r2);
        r2.remove(BDTURING_VERIFY_HEADER);
        return new RequestRetryResult(r1);
    L11:
        return new RequestRetryResult(false);
    }

    public static RequestRetryResult shouldRetryRequestFromTuringHeaders(int r1, Map<String, List<String>> r2) {
        if (r1 != 200) goto L10;
        if (Looper.getMainLooper() == Looper.myLooper()) goto L10;
        return onCallToResponseCallback(r2);
    L10:
        return new RequestRetryResult(false);
    }

    public static RequestRetryResult shouldRetryRequestByHeader(BaseHttpRequestInfo r8, int r9, GetRequestHeaderValueCallback r10, Map<String, List<String>> r11) {
        boolean r1 = false;
        RequestRetryResult r0 = new RequestRetryResult(false);
        if (r9 == 200) goto L5;
    L42:
        return r0;
    L5:
        if (Looper.getMainLooper() == Looper.myLooper()) goto L42;
        if (r11 == null) goto L42;
        if (r11.isEmpty() == true) goto L42;
        if (sRetryRequestByHeaderCallbackMap.isEmpty() == true) goto L42;
        Iterator<String> r12 = r11.keySet().iterator();
    L14:
        if (r12.hasNext() == false) goto L20;
        String r2 = r12.next();
        if (StringUtils.isEmpty(r2) == true) goto L14;
        if (r2.toLowerCase().contains(RETRY_REQUEST_BY_HEADER_RESPONSE_KEYWORD) == false) goto L14;
        r1 = true;
    L20:
        if (r1 == true) goto L22;
        return r0;
    L22:
        Map.Entry<String, RetryRequestByHeaderCallback> r13 = getRetryRequestByHeaderCallbackEntry(r11.keySet());
        if (r13 != null) goto L26;
        return r0;
    L26:
        if (r10 == null) goto L32;
        String r14 = r10.onGetRequestHeaderValue(BYPASS_RETRY_BY_HEADER_KEY_PREFIX + r13.getKey());
        if (StringUtils.isEmpty(r14) == true) goto L32;
        if ("1".equalsIgnoreCase(r14) == false) goto L32;
        return r0;
    L32:
        RetryRequestByHeaderCallback r15 = r13.getValue();
        if (r15 != null) goto L35;
        return r0;
    L35:
        r8.retryByHeaderFilterKey = r13.getKey();
        long r4 = SystemClock.uptimeMillis();
        RequestRetryResult r16 = r15.onCallToRetryRequestByHeader(r11);
        r8.retryByHeaderCallbackDuration = SystemClock.uptimeMillis() - r4;
        if (r16.isRequestRetryEnabled() == false) goto L41;
        r8.bdTuringRetry = true;
        Map<String, String> r17 = r16.getAddRequestHeaders();
        if (r17 != null) goto L40;
        r17 = new HashMap();
    L40:
        r17.put(RETRY_REQUEST_BY_HEADER_KEY_PREFIX + r13.getKey(), "1");
        r16.setAddRequestHeaders(r17);
    L41:
        return r16;
    }

    public static synchronized boolean setRetryForAccountRequestCallback(RetryForAccountRequestCallback r2) {
        monitor-enter(NetworkParams.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (sRetryForAccountRequestCallback == null) goto L9;
        monitor-exit(NetworkParams.class);
        return false;
    L9:
        sRetryForAccountRequestCallback = r2;     // Catch: Throwable -> L13
        monitor-exit(NetworkParams.class);
        return true;
    }

    public static void setAddSecurityFactorProcessCallback(AddSecurityFactorProcessCallback r0) {
        sAddSecurityFactorProcessCallback = r0;
    }

    public static Map<String, String> tryAddSecurityFactor(String r1, Map<String, List<String>> r2) {
        AddSecurityFactorProcessCallback r0 = sAddSecurityFactorProcessCallback;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.onCallToAddSecurityFactor(r1, r2);
    }

    public static void setNewCookieBlockPositionEnabled(boolean r0) {
        sNewCookieBlockPositionEnabled = r0;
    }

    public static boolean newCookieBlockPositionEnabled() {
        return sNewCookieBlockPositionEnabled;
    }

    public static boolean interceptCookie(Object r1) {
        if (r1 != null) goto L4;
    L8:
        return false;
    L4:
        if ((r1 instanceof BaseRequestContext) == false) goto L8;
        if (((BaseRequestContext) r1).bypassCookie == false) goto L8;
        return true;
    }

    public static void setEnableMainThreadCheck(boolean r0) {
        sEnableMainThreadCheck = r0;
    }

    public static boolean getEnableMainThreadCheck() {
        return sEnableMainThreadCheck;
    }

    public static void setPrivateProtocolEnabled(boolean r0) {
        sPrivateProtocolEnabled = r0;
    }

    public static boolean isPrivateProtocolEnabled() {
        return sPrivateProtocolEnabled;
    }

    public static RequestRetryResult shouldRetryForAccountRequest(String r5, int r6, boolean r7, BaseHttpRequestInfo r8, List<Header> r9, Map<String, List<String>> r10) {
        if (sRetryForAccountRequestCallback != null) goto L5;
        return null;
    L5:
        if (r6 == 200) goto L7;
        return null;
    L7:
        if (Looper.getMainLooper() == Looper.myLooper()) goto L43;
        RequestRetryResult r11 = new RequestRetryResult(false);
        if (r9 == null) goto L21;
        Iterator<Header> r1 = r9.iterator();
    L13:
        if (r1.hasNext() == false) goto L21;
        Header r2 = r1.next();
        if (r2 == null) goto L13;
        if (BYPASS_RETRY_FOR_ACCOUNT_KEY.equalsIgnoreCase(r2.getName()) == false) goto L13;
        if ("1".equals(r2.getValue()) == false) goto L13;
        return r11;
    L21:
        long r3 = SystemClock.uptimeMillis();
        r11 = sRetryForAccountRequestCallback.onCallToRetryForAccountRequest(r5, r9, r10, r7);     // Catch: Throwable -> L31
    L23:
        r8.retryForAccountCallbackDuration = SystemClock.uptimeMillis() - r3;
        Map<String, String> r12 = r11.getAddRequestHeaders();
        if (r12 != null) goto L26;
    L28:
        return r11;
    L26:
        if (r12.isEmpty() == true) goto L28;
        HashMap r13 = new HashMap(r12);
        r13.put(RETRY_FOR_ACCOUNT_REQUEST_KEY, "1");
        r11.setAddRequestHeaders(r13);
        goto L28
    L43:
        return null;
    }
}
