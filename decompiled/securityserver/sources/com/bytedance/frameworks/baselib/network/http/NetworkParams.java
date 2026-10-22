package com.bytedance.frameworks.baselib.network.http;

import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.impl.CookieManagerWrap;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.SsHttpCall;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.ttnet.ExceptionReportable;
import com.bytedance.retrofit2.ttnet.TTNetExceptionStorage;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class NetworkParams {
    public static final String BDTURING_VERIFY_HEADER = "bdturing-verify";
    public static final String BYPASS_BDTURING_HEADER_KEY = "x-tt-bypass-bdturing";
    private static final String BYPASS_RETRY_BY_HEADER_KEY_PREFIX = "x-tt-bypass-retry-by-";
    public static final String BYPASS_RETRY_FOR_ACCOUNT_KEY = "x-tt-bypass-retry-for-account";
    public static final int CONNECT_TIMEOUT = 15000;
    public static final int IO_TIMEOUT = 15000;
    public static final int MAX_ROTATION_HOST_PATH_RETRY_COUNT = 3;
    public static final String PNAME_REMOTE_ADDRESS = "x-net-info.remoteaddr";
    public static final String RETRY_FOR_ACCOUNT_REQUEST_KEY = "x-tt-retry-for-account";
    public static final String RETRY_REQUEST_BY_BDTURING_HEADER = "x-tt-bdturing-retry";
    private static final String RETRY_REQUEST_BY_HEADER_KEY_PREFIX = "x-tt-retry-by-";
    private static final String RETRY_REQUEST_BY_HEADER_RESPONSE_KEYWORD = "verify";
    private static final int WAIT_COOKIE_INIT_TIME = 5000;
    private static AddOecSecurityFactorProcessCallback sAddOecSecurityFactorProcessCallback;
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
    private static CookieUpdateListener sCookieUpdateListener;
    private static int sDestroyDeltaMillis;
    private static AtomicBoolean sDisableRotationHostRetryByTnc;
    private static boolean sEnableMainThreadCheck;
    private static MonitorProcessHook sMonitorProcessHook;
    private static OldMonitorProcessHook sOldMonitorProcessHook;
    private static boolean sPrivateProtocolEnabled;
    private static volatile RetryForAccountRequestCallback sRetryForAccountRequestCallback;
    private static final Map<String, RetryRequestByHeaderCallback> sRetryRequestByHeaderCallbackMap = null;
    private static volatile RetryRequestByRotationHostListCallback sRetryRequestByRotationHostRetryListCallback;
    private static volatile RetryRequestByTuringHeaderCallback sRetryRequestCallback;
    private static StreamProcessor sStreamProcessor;
    private static final TTNetCallMonitor sTTNetCallMonitor = null;
    private static volatile int sUseDnsMapping;
    private static String sUserAgent;

    public interface AddOecSecurityFactorProcessCallback {
        Map<String, String> onCallToAddSecurityFactor(String r1, Map<String, List<String>> r2);
    }

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

        void monitorApiHttp(String r1, String r2, boolean r3);

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

    public interface CookieUpdateListener {
        void onCookieBatchUpdate(Set<String> r1);

        void onCookieUpdate(String r1, String r2);
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

    public interface RetryRequestByRotationHostListCallback {
        RequestRetryResult onCallToRetryRequestByRotationHostRetryList(String r1, String r2, BaseHttpRequestInfo r3, int r4, List<Header> r5, Map<String, List<String>> r6);
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

        private void processCastError(Object r2) {
            BaseHttpRequestInfo r3 = (BaseHttpRequestInfo) r2;
            if (r3.url == null) goto L6;
            Logger.e("TTNetCallMonitor", "monitor cast error" + r3.url.getPath());
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

        @Override // com.bytedance.retrofit2.SsHttpCall.IHttpCallMonitor
        public void monitorApiError(long r12, long r14, String r16, String r17, Object r18, Throwable r19) {
            if (NetworkParams.access$000() != null) goto L5;
            return;
        L5:
            if (r18 == null) goto L17;
            BaseHttpRequestInfo r1 = (BaseHttpRequestInfo) r18;
            if (StringUtils.isEmpty(r1.requestLog) == false) goto L9;
            return;
        L9:
            if (r1.bypassApiReport == true) goto L19;
            NetworkParams.access$000().monitorApiError(r12, r14, r16, r17, (BaseHttpRequestInfo) r18, r19);     // Catch: ClassCastException -> L13
            return;
        L13:
            processCastError(r18);
            return;
        L19:
            return;
        }

        @Override // com.bytedance.retrofit2.SsHttpCall.IHttpCallMonitor
        public void monitorApiOK(long r11, long r13, String r15, String r16, Object r17) {
            if (NetworkParams.access$000() != null) goto L5;
            return;
        L5:
            if (r17 == null) goto L17;
            BaseHttpRequestInfo r1 = (BaseHttpRequestInfo) r17;
            if (StringUtils.isEmpty(r1.requestLog) == false) goto L9;
            return;
        L9:
            if (r1.bypassApiReport == true) goto L19;
            NetworkParams.access$000().monitorApiOk(r11, r13, r15, r16, (BaseHttpRequestInfo) r17);     // Catch: ClassCastException -> L13
            return;
        L13:
            processCastError(r17);
            return;
        L19:
            return;
        }
    }

    public interface addResponseHeadersCallback {
        boolean onCallToRetryRequestByTuringHeader(Map<String, List<String>> r1);
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
        sEnableMainThreadCheck = false;
        sPrivateProtocolEnabled = true;
        sDestroyDeltaMillis = 100;
        sDisableRotationHostRetryByTnc = new AtomicBoolean(false);
    }

    public NetworkParams() {
    }

    public static /* synthetic */ MonitorProcessHook access$000() {
        return sMonitorProcessHook;
    }

    public static /* synthetic */ AllErrorReportHook access$100() {
        return sAllErrorReportHook;
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

    public static synchronized boolean addRetryRequestByHeaderCallback(String r4, RetryRequestByHeaderCallback r5) {
        monitor-enter(NetworkParams.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (StringUtils.isEmpty(r4) == true) goto L21;
        if (r5 == null) goto L21;
        Iterator<String> r1 = sRetryRequestByHeaderCallbackMap.keySet().iterator();     // Catch: Throwable -> L15
    L10:
        if (r1.hasNext() == false) goto L17;
        if (r1.next().equalsIgnoreCase(r4) == false) goto L10;
        monitor-exit(NetworkParams.class);
        return false;
    L17:
        sRetryRequestByHeaderCallbackMap.put(r4, r5);     // Catch: Throwable -> L15
        monitor-exit(NetworkParams.class);
        return true;
    L21:
        monitor-exit(NetworkParams.class);
        return false;
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

    public static String filterUrl(String r1) {
        return filterUrl(r1, null);
    }

    public static ApiRequestInterceptor getApiRequestInterceptor() {
        return sApiInterceptor;
    }

    public static AppCookieStore getAppCookieStore() {
        return sAppCookieStore;
    }

    public static CdnConnectionQualitySamplerHook getCdnConnectionQualitySamplerHook() {
        return sCdnConnectionQualitySamplerHook;
    }

    public static CommandListener getCommandListener() {
        return sCommandListener;
    }

    public static Map<String, String> getCommonParamsByLevel(int r1) {
        ApiProcessHook r0 = sApiProcessHook;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getCommonParamsByLevel(r1);
    }

    public static int getConnectTimeout() {
        return 15000;
    }

    public static ConnectionQualitySamplerHook getConnectionQualitySamplerHook() {
        return sConnectionQualitySamplerHook;
    }

    public static CookieShareInterceptor getCookieShareInterceptor() {
        return sCookieShareInterceptor;
    }

    public static CookieUpdateListener getCookieUpdateListener() {
        return sCookieUpdateListener;
    }

    public static int getDestroyDeltaMillis() {
        return sDestroyDeltaMillis;
    }

    public static boolean getEnableMainThreadCheck() {
        return sEnableMainThreadCheck;
    }

    public static int getIoTimeout() {
        return 15000;
    }

    private static synchronized Map.Entry<String, RetryRequestByHeaderCallback> getRetryRequestByHeaderCallbackEntry(Set<String> r6) {
        monitor-enter(NetworkParams.class);
        Iterator<Map.Entry<String, RetryRequestByHeaderCallback>> r1 = sRetryRequestByHeaderCallbackMap.entrySet().iterator();     // Catch: Throwable -> L16
    L6:
        if (r1.hasNext() == false) goto L18;
        Map.Entry<String, RetryRequestByHeaderCallback> r2 = r1.next();     // Catch: Throwable -> L16
        Iterator<String> r3 = r6.iterator();     // Catch: Throwable -> L16
    L9:
        if (r3.hasNext() == false) goto L6;
        String r4 = r3.next();     // Catch: Throwable -> L16
        if (StringUtils.isEmpty(r4) == true) goto L9;
        if (r4.equalsIgnoreCase(r2.getKey()) == false) goto L9;
        monitor-exit(NetworkParams.class);
        return r2;
    L18:
        monitor-exit(NetworkParams.class);
        return null;
    L16:
        th = move-exception;
        throw th;
    }

    public static StreamProcessor getStreamProcessor() {
        return sStreamProcessor;
    }

    @Deprecated
    public static boolean getUseDnsMapping() {
        if (sUseDnsMapping == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static String getUserAgent() {
        return sUserAgent;
    }

    @Deprecated
    public static void handleApiError(String r7, Throwable r8, BaseHttpRequestInfo r9) {
        if (StringUtils.isEmpty(r7) == true) goto L17;
        if (r8 == null) goto L22;
        if (r9 != null) goto L8;
        return;
    L8:
        if (r9.bypassApiReport == true) goto L23;
        ApiProcessHook r1 = sApiProcessHook;
        OldMonitorProcessHook r0 = sOldMonitorProcessHook;
        if (r1 == null) goto L19;
        if (r0 != null) goto L14;
        return;
    L14:
        if (r0.getOldmonitorSwitch() == false) goto L21;
        r1.handleApiError(r7, r8, r9.requestEnd - r9.requestStart, r9);
        return;
    L21:
        return;
    L19:
        return;
    L23:
        return;
    L22:
        return;
    }

    @Deprecated
    public static void handleApiOk(String r6, BaseHttpRequestInfo r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        if (r7.bypassApiReport == true) goto L22;
        ApiProcessHook r0 = sApiProcessHook;
        OldMonitorProcessHook r1 = sOldMonitorProcessHook;
        long r2 = r7.requestEnd - r7.requestStart;
        if (StringUtils.isEmpty(r6) == false) goto L9;
        return;
    L9:
        if (r2 <= 0) goto L18;
        if (r0 == null) goto L19;
        if (r1 != null) goto L13;
        return;
    L13:
        if (r1.getOldmonitorSwitch() == false) goto L21;
        r0.handleApiOk(r6, r2, r7);
        return;
    L21:
        return;
    L19:
        return;
    L18:
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

    public static boolean interceptCookie(Object r1) {
        if (r1 != null) goto L4;
    L8:
        return false;
    L4:
        if ((r1 instanceof BaseRequestContext) == false) goto L8;
        if (((BaseRequestContext) r1).bypassCookie == false) goto L8;
        return true;
    }

    public static boolean isPrivateProtocolEnabled() {
        return sPrivateProtocolEnabled;
    }

    public static void monitorApiError(long r9, long r11, String r13, String r14, BaseHttpRequestInfo r15, Throwable r16) {
        if (r15 != null) goto L5;
        return;
    L5:
        if (StringUtils.isEmpty(r15.requestLog) == false) goto L7;
        return;
    L7:
        if (r15.bypassApiReport == false) goto L10;
        return;
    L10:
        if (StringUtils.isEmpty(r13) == true) goto L22;
        if (r16 == null) goto L25;
        MonitorProcessHook r0 = sMonitorProcessHook;
        if (r0 != null) goto L16;
        return;
    L16:
        if (r15.downloadFile == false) goto L18;
        r15.hasReportStreamingApiAll.set(true);
    L18:
        r0.monitorApiError(r9, r11, r13, r14, r15, r16);
        return;
    L25:
        return;
    }

    public static void monitorApiHttp(String r1, String r2, boolean r3) {
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

    public static void monitorApiOk(String r9, BaseHttpRequestInfo r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.bypassApiReport == true) goto L9;
        long r0 = r10.requestEnd;
        long r4 = r10.requestStart;
        monitorApiSample(r0 - r4, r4, r9, r10.traceCode, r10);
        return;
    }

    public static void monitorApiSample(long r9, long r11, String r13, String r14, BaseHttpRequestInfo r15) {
        if (r15 != null) goto L4;
        return;
    L4:
        if (StringUtils.isEmpty(r15.requestLog) == false) goto L6;
        return;
    L6:
        if (r15.bypassApiReport == true) goto L28;
        MonitorProcessHook r1 = sMonitorProcessHook;
        if (StringUtils.isEmpty(r13) == false) goto L11;
        return;
    L11:
        if (r9 <= 0) goto L25;
        if (r1 != null) goto L14;
        return;
    L14:
        if (r15.downloadFile == false) goto L18;
        if (r15.hasReportStreamingApiAll.get() == false) goto L18;
        return;
    L18:
        if (r15.downloadFile == false) goto L20;
        r15.hasReportStreamingApiAll.set(true);
    L20:
        r1.monitorApiOk(r9, r11, r13, r14, r15);
        return;
    L25:
        return;
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

    public static void putCommonParams(Map<String, String> r1, boolean r2) {
        ApiProcessHook r0 = sApiProcessHook;
        if (r0 == null) goto L6;
        r0.putCommonParams(r1, r2);
        return;
    }

    public static synchronized boolean removeRetryRequestByHeaderCallback(String r5) {
        monitor-enter(NetworkParams.class);
    L18:
        th = move-exception;
        throw th;
    L6:
        if (StringUtils.isEmpty(r5) == false) goto L9;
        monitor-exit(NetworkParams.class);
        return false;
    L9:
        Iterator<String> r1 = sRetryRequestByHeaderCallbackMap.keySet().iterator();     // Catch: Throwable -> L18
    L11:
        if (r1.hasNext() == false) goto L20;
        String r3 = r1.next();     // Catch: Throwable -> L18
        if (r3.equalsIgnoreCase(r5) == false) goto L11;
        sRetryRequestByHeaderCallbackMap.remove(r3);     // Catch: Throwable -> L18
        monitor-exit(NetworkParams.class);
        return true;
    L20:
        monitor-exit(NetworkParams.class);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void reportOneNormalRequest(Request r2, BaseHttpRequestInfo r3, Throwable r4, Boolean r5) {
        if (r4 != 0) goto L5;
        monitorApiOk(r2.getUrl(), r3);
        return;
    L5:
        if ((r4 instanceof TTNetExceptionStorage) == false) goto L15;
        TTNetExceptionStorage r0 = (TTNetExceptionStorage) r4;
        if (r0.needReport == false) goto L15;
        if (r0.reportMonitorOk == false) goto L12;
        monitorApiOk(r2.getUrl(), r3);
    L12:
        if (r0.reportMonitorError == false) goto L24;
        monitorApiError(r2.getUrl(), r3, r4);
        return;
    L24:
        return;
    L15:
        if ((r4 instanceof ExceptionReportable) == false) goto L20;
        if (((ExceptionReportable) r4).shouldReport() == false) goto L26;
        monitorApiError(r2.getUrl(), r3, r4);
        return;
    L26:
        return;
    L20:
        if (r5.booleanValue() == false) goto L28;
        monitorApiError(r2.getUrl(), r3, r4);
        return;
    }

    public static void setAddOecSecurityFactorProcessCallback(AddOecSecurityFactorProcessCallback r0) {
        sAddOecSecurityFactorProcessCallback = r0;
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

    public static void setAddSecurityFactorProcessCallback(AddSecurityFactorProcessCallback r0) {
        sAddSecurityFactorProcessCallback = r0;
    }

    public static void setAllErrorReportHook(AllErrorReportHook r0) {
        sAllErrorReportHook = r0;
    }

    public static void setApiProcessHook(ApiProcessHook r0) {
        sApiProcessHook = r0;
    }

    public static void setApiRequestInterceptor(ApiRequestInterceptor r0) {
        sApiInterceptor = r0;
    }

    public static void setAppCookieStore(AppCookieStore r0) {
        sAppCookieStore = r0;
    }

    public static void setCdnConnectionQualitySamplerHook(CdnConnectionQualitySamplerHook r0) {
        sCdnConnectionQualitySamplerHook = r0;
    }

    public static void setCommandListener(CommandListener r0) {
        sCommandListener = r0;
    }

    public static void setConnectionQualitySamplerHook(ConnectionQualitySamplerHook r0) {
        sConnectionQualitySamplerHook = r0;
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

    public static void setCookieShareInterceptor(CookieShareInterceptor r0) {
        sCookieShareInterceptor = r0;
    }

    public static void setCookieUpdateListener(CookieUpdateListener r0) {
        sCookieUpdateListener = r0;
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

    public static void setDestroyDeltaMillis(int r0) {
        sDestroyDeltaMillis = r0;
    }

    public static void setDisableRotationHostRetryByTnc(boolean r1) {
        sDisableRotationHostRetryByTnc.set(r1);
    }

    @Deprecated
    public static void setDynamicTimeOutEnable(boolean r0) {
    }

    public static void setEnableMainThreadCheck(boolean r0) {
        sEnableMainThreadCheck = r0;
    }

    public static void setMonitorProcessHook(MonitorProcessHook r0) {
        sMonitorProcessHook = r0;
        SsHttpCall.setCallMonitor(sTTNetCallMonitor);
    }

    @Deprecated
    public static void setNewCookieBlockPositionEnabled(boolean r0) {
    }

    public static void setOldMonitorProcessHook(OldMonitorProcessHook r0) {
        sOldMonitorProcessHook = r0;
    }

    public static void setPrivateProtocolEnabled(boolean r0) {
        sPrivateProtocolEnabled = r0;
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

    public static synchronized boolean setRetryRequestByRotationHostRetryListCallback(RetryRequestByRotationHostListCallback r2) {
        monitor-enter(NetworkParams.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (sRetryRequestByRotationHostRetryListCallback == null) goto L9;
        monitor-exit(NetworkParams.class);
        return false;
    L9:
        sRetryRequestByRotationHostRetryListCallback = r2;     // Catch: Throwable -> L13
        monitor-exit(NetworkParams.class);
        return true;
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

    public static void setStreamProcessor(StreamProcessor r0) {
        sStreamProcessor = r0;
    }

    @Deprecated
    public static void setUseDnsMapping(int r0) {
        sUseDnsMapping = r0;
    }

    private static RequestRetryResult shouldRetryForAccountRequest(String r6, BaseHttpRequestInfo r7, boolean r8, List<Header> r9, Map<String, List<String>> r10) {
        RequestRetryResult r0 = new RequestRetryResult(false);
        if (sRetryForAccountRequestCallback != null) goto L6;
        return r0;
    L6:
        if (r9 == null) goto L17;
        Iterator<Header> r2 = r9.iterator();
    L9:
        if (r2.hasNext() == false) goto L17;
        Header r3 = r2.next();
        if (r3 == null) goto L9;
        if (BYPASS_RETRY_FOR_ACCOUNT_KEY.equalsIgnoreCase(r3.getName()) == false) goto L9;
        if ("1".equals(r3.getValue()) == false) goto L9;
        return r0;
    L17:
        long r4 = SystemClock.uptimeMillis();
        r0 = sRetryForAccountRequestCallback.onCallToRetryForAccountRequest(r6, r9, r10, r8);     // Catch: Throwable -> L29
    L19:
        r7.retryForAccountCallbackDuration = SystemClock.uptimeMillis() - r4;
        if (r8 == true) goto L28;
        if (r0 == null) goto L28;
        if (r0.isRequestRetryEnabled() == false) goto L28;
        HashMap r11 = new HashMap();
        r11.put(RETRY_FOR_ACCOUNT_REQUEST_KEY, "1");
        if (r0.getAddRequestHeaders() == null) goto L27;
        r11.putAll(r0.getAddRequestHeaders());
    L27:
        r0.setAddRequestHeaders(r11);
        r7.accountRetry = true;
    L28:
        return r0;
    }

    private static RequestRetryResult shouldRetryRequestByHeader(BaseHttpRequestInfo r7, List<Header> r8, Map<String, List<String>> r9) {
        RequestRetryResult r0 = new RequestRetryResult(false);
        if (r9 != null) goto L5;
    L43:
        return r0;
    L5:
        if (r9.isEmpty() == true) goto L43;
        if (sRetryRequestByHeaderCallbackMap.isEmpty() == true) goto L43;
        Iterator<String> r1 = r9.keySet().iterator();
    L11:
        if (r1.hasNext() == false) goto L43;
        String r2 = r1.next();
        if (StringUtils.isEmpty(r2) == true) goto L11;
        if (r2.toLowerCase().contains(RETRY_REQUEST_BY_HEADER_RESPONSE_KEYWORD) == false) goto L11;
        Map.Entry<String, RetryRequestByHeaderCallback> r3 = getRetryRequestByHeaderCallbackEntry(r9.keySet());
        if (r3 != null) goto L20;
        return r0;
    L20:
        if (r8 == null) goto L31;
        String r4 = BYPASS_RETRY_BY_HEADER_KEY_PREFIX + r3.getKey();
        Iterator<Header> r10 = r8.iterator();
    L23:
        if (r10.hasNext() == false) goto L31;
        Header r5 = r10.next();
        if (r5 == null) goto L23;
        if (r4.equalsIgnoreCase(r5.getName()) == false) goto L23;
        if ("1".equals(r5.getValue()) == false) goto L23;
        return r0;
    L31:
        RetryRequestByHeaderCallback r11 = r3.getValue();
        if (r11 != null) goto L34;
        return r0;
    L34:
        long r6 = SystemClock.uptimeMillis();
        RequestRetryResult r12 = r11.onCallToRetryRequestByHeader(r9);
        r7.turingCallbackDuration = SystemClock.uptimeMillis() - r6;
        r7.retryByHeaderFilterKey = r3.getKey();
        if (r12 != null) goto L37;
    L42:
        return r12;
    L37:
        if (r12.isRequestRetryEnabled() == false) goto L42;
        r7.bdTuringRetry = true;
        Map<String, String> r13 = r12.getAddRequestHeaders();
        if (r13 != null) goto L41;
        r13 = new HashMap();
    L41:
        r13.put(RETRY_REQUEST_BY_HEADER_KEY_PREFIX + r3.getKey(), "1");
        r12.setAddRequestHeaders(r13);
        goto L42
    }

    private static RequestRetryResult shouldRetryRequestByRotationHost(Request r16, BaseHttpRequestInfo r17, int r18, List<Header> r19, Map<String, List<String>> r20, boolean r21) {
        RequestRetryResult r10 = new RequestRetryResult(false);
        if (r21 == false) goto L5;
    L38:
        return r10;
    L5:
        if (r17.bdTuringRetry == true) goto L38;
        if (r17.accountRetry == true) goto L38;
        if (sDisableRotationHostRetryByTnc.get() == true) goto L38;
        if (sRetryRequestByRotationHostRetryListCallback == null) goto L38;
        RotationHostRetryHandler r8 = r17.rotationHostPathRetryHandler;
        if (r8 != null) goto L17;
        return r10;
    L17:
        if (r8.noRemainingRetryHost() == false) goto L20;
        r8.recordMetrics(r16.getHost(), r16.getPath(), r18, -1, r10, r17);
        return r10;
    L20:
        String r2 = r16.getUrl();
        BaseRequestContext.RotationHostRetryInfo r0 = r8.getNextRetryHostInfo();
        if (r0 != null) goto L23;
        return r10;
    L23:
        String r1 = r0.host;
        String r3 = r0.path;
        if (TextUtils.isEmpty(r1) == true) goto L38;
        if (TextUtils.isEmpty(r3) == true) goto L38;
        String r11 = r16.getHost();
        String r12 = r16.getPath();
        String r13 = r2.replaceFirst(r11, r1).replaceFirst(r12, r3);
        long r14 = SystemClock.elapsedRealtime();
        r10 = sRetryRequestByRotationHostRetryListCallback.onCallToRetryRequestByRotationHostRetryList(r2, r13, r17, r18, r19, r20);     // Catch: Throwable -> L31
    L33:
        r8.recordMetrics(r11, r12, r18, SystemClock.elapsedRealtime() - r14, r10, r17);
        if (r10 == null) goto L38;
        if (r10.isRequestRetryEnabled() == false) goto L38;
        r17.rotationHostRetry = true;
        r10.setNextRetryUrl(r13);
    L31:
        th = move-exception;
        th.printStackTrace();
        goto L33
    }

    private static RequestRetryResult shouldRetryRequestFromTuringHeader(BaseHttpRequestInfo r7, List<Header> r8, Map<String, List<String>> r9) {
        RequestRetryResult r0 = new RequestRetryResult(false);
        if (r9 != null) goto L5;
    L30:
        return r0;
    L5:
        if (r9.containsKey(BDTURING_VERIFY_HEADER) == false) goto L30;
        if (r8 == null) goto L19;
        Iterator<Header> r10 = r8.iterator();
    L11:
        if (r10.hasNext() == false) goto L19;
        Header r3 = r10.next();
        if (r3 == null) goto L11;
        if (BYPASS_BDTURING_HEADER_KEY.equalsIgnoreCase(r3.getName()) == false) goto L11;
        if ("1".equals(r3.getValue()) == false) goto L11;
        return r0;
    L19:
        TreeMap r11 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        r11.putAll(r9);
        long r4 = SystemClock.uptimeMillis();
        RequestRetryResult r12 = onCallToResponseCallback(r11);
        r7.turingCallbackDuration = SystemClock.uptimeMillis() - r4;
        if (r11.containsKey(BDTURING_VERIFY_HEADER) == true) goto L22;
        r7.executeTuringCallback = true;
        r7.retryByHeaderFilterKey = BDTURING_VERIFY_HEADER;
    L22:
        if (r12 != null) goto L24;
    L29:
        return r12;
    L24:
        if (r12.isRequestRetryEnabled() == false) goto L29;
        r7.bdTuringRetry = true;
        HashMap r13 = new HashMap();
        r13.put(RETRY_REQUEST_BY_BDTURING_HEADER, "1");
        if (r12.getAddRequestHeaders() == null) goto L28;
        r13.putAll(r12.getAddRequestHeaders());
    L28:
        r12.setAddRequestHeaders(r13);
        goto L29
    }

    public static RequestRetryResult shouldRetryRequestOnceTime(Request r6, int r7, BaseHttpRequestInfo r8, List<Header> r9, Map<String, List<String>> r10, boolean r11, boolean r12) {
        boolean r1 = false;
        RequestRetryResult r0 = new RequestRetryResult(false);
        r8.rotationHostRetry = false;
        if (Looper.getMainLooper() != Looper.myLooper()) goto L6;
        return r0;
    L6:
        if (r7 != 200) goto L33;
        if (r11 == false) goto L33;
        RequestRetryResult r13 = shouldRetryRequestFromTuringHeader(r8, r9, r10);
        if (r8.executeTuringCallback == true) goto L12;
        r13 = shouldRetryRequestByHeader(r8, r9, r10);
    L12:
        if (r13 != null) goto L14;
    L16:
        RequestRetryResult r2 = shouldRetryForAccountRequest(r6.getUrl(), r8, r1, r9, r10);
        if (r1 == true) goto L19;
        r13 = r2;
    L26:
        if (r13 == null) goto L31;
        if (r13.isRequestRetryEnabled() == false) goto L31;
        return r13;
    L31:
        return shouldRetryRequestByRotationHost(r6, r8, r7, r9, r10, r12);
    L19:
        if (r2 == null) goto L26;
        if (r2.getAddRequestHeaders() == null) goto L26;
        HashMap r3 = new HashMap();
        if (r13.getAddRequestHeaders() == null) goto L25;
        r3.putAll(r13.getAddRequestHeaders());
    L25:
        r3.putAll(r2.getAddRequestHeaders());
        r13.setAddRequestHeaders(r3);
        goto L26
    L14:
        if (r13.isRequestRetryEnabled() == false) goto L16;
        r1 = true;
    L33:
        return shouldRetryRequestByRotationHost(r6, r8, r7, r9, r10, r12);
    }

    public static Map<String, String> tryAddOecSecurityFactor(String r1, Map<String, List<String>> r2) {
        AddOecSecurityFactorProcessCallback r0 = sAddOecSecurityFactorProcessCallback;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.onCallToAddSecurityFactor(r1, r2);
    }

    public static String tryAddRequestVertifyParams(String r1, boolean r2, Object... r3) {
        ApiProcessHook r0 = sApiProcessHook;
        if (r0 != null) goto L5;
        return r1;
    L5:
        return r0.addRequestVertifyParams(r1, r2, r3);
    }

    public static Map<String, String> tryAddSecurityFactor(String r1, Map<String, List<String>> r2) {
        AddSecurityFactorProcessCallback r0 = sAddSecurityFactorProcessCallback;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.onCallToAddSecurityFactor(r1, r2);
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
    L13:
        th = move-exception;
        throw th;
    L6:
        if (sCookieMgrInited.get() == false) goto L30;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L13
        CookieManager r1 = CookieManager.getInstance();     // Catch: Throwable -> L22
        if (r1.acceptCookie() == true) goto L36;
        r1.setAcceptCookie(true);     // Catch: Throwable -> L26
        return r1;
    L36:
        return r1;
    L38:
        return r1;
    L22:
        return null;
    L30:
        CountDownLatch r2 = sCookieInitedCountDown;     // Catch: Throwable -> L13 Exception -> L27
        if (r2 == null) goto L15;
        r2.await(PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L13 Exception -> L27
        if (sCookieInitedCountDown.getCount() != 1) goto L15;
        sCookieInitedCountDown.countDown();     // Catch: Throwable -> L13 Exception -> L27
    L15:
        sCookieMgrInited.getAndSet(true);     // Catch: Throwable -> L13
        goto L16
    }

    public static CookieManager tryNecessaryInit() {
        return tryNecessaryInit("");
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

    public static CookieManager tryNecessaryInit(String r0) {
        tryApiProcessHookInit();
        return tryCookieManagerInit();
    }

    public static void monitorApiError(String r10, BaseHttpRequestInfo r11, Throwable r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        long r0 = r11.requestEnd;
        long r4 = r11.requestStart;
        monitorApiError(r0 - r4, r4, r10, r11.traceCode, r11, r12);
    }
}
