package com.bytedance.ttnet;

import android.app.Application;
import android.bluetooth.client.pbap.BluetoothPbapClient;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.ReflectException;
import com.bytedance.frameworks.baselib.network.LifeCycleMonitor;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.ConstantsDefined;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetThreadConfig;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.NetworkQuality;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.PacketLossMetrics;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.TTDispatchResult;
import com.bytedance.frameworks.baselib.network.http.impl.PersistentCookieStore;
import com.bytedance.frameworks.baselib.network.http.impl.SSCookieHandler;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.SsOkHttp3Client;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchResult;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatcher;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLRequest;
import com.bytedance.frameworks.baselib.network.http.util.BoeUtils;
import com.bytedance.frameworks.baselib.network.http.util.ProcessUtils;
import com.bytedance.frameworks.baselib.network.queryfilter.QueryFilterStateListener;
import com.bytedance.keva.KevaBuilder;
import com.bytedance.retrofit2.RetrofitLogger;
import com.bytedance.ttnet.clientkey.ClientKeyManager;
import com.bytedance.ttnet.config.AppConfig;
import com.bytedance.ttnet.config.SDKConfig;
import com.bytedance.ttnet.debug.DebugMode;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.bytedance.ttnet.httpdns.TTDnsOuterService;
import com.bytedance.ttnet.httpdns.TTDnsResult;
import com.bytedance.ttnet.okhttp.OkHttpAppInfoProvider;
import com.bytedance.ttnet.tnc.TNCManager;
import com.bytedance.ttnet.utils.RequestTicketUtil;
import com.bytedance.ttnet.utils.TtnetUtil;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.CookieHandler;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UnknownFormatConversionException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class TTNetInit {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String DOMAIN_BOE_HTTPS_KEY = "boe_https";
    public static final String DOMAIN_BOE_KEY = "boe";
    public static final String DOMAIN_HTTPDNS_KEY = "httpdns";

    @Deprecated
    public static final String DOMAIN_NETLOG_KEY = "netlog";
    private static final int INIT_TIMEOUT_VALUE = 5;
    private static final String OKHTTP_DISPATCH_FAILED = "okhttp dispatch failed.";
    private static final String RETURN_WRONG_FORMAT = "Conversion = 'ttUrlDispatch returns wrong format'";
    private static final String TAG = "TTNetInit";
    private static final String TTNET_CRONET_NOT_INITIALIZED = "cronet not init.";
    private static volatile ENV env = null;
    private static volatile boolean sApiHttpInterceptEnabled = false;
    private static volatile int sAppSecurityLevel = 0;
    private static volatile String sClientIPString = null;
    private static volatile boolean sCookieLogReportEnabled = false;
    private static long sCookieManagerInitStartTime = 0;
    public static ICronetAppProvider sCronetProvider = null;
    private static volatile int sDelayTime = 10;
    public static Map<String, String> sGetDomainRegionMap;
    private static ITTNetDepend sITTNetDepend;
    private static volatile CountDownLatch sLatchInitCompleted;
    public static LifeCycleMonitor sLifeCycleMonitor;
    private static volatile boolean sListenAppStateIndependently;
    private static volatile boolean sMainThreadInitCookieEnabled;
    private static volatile long sMaxHttpDiskCacheSize;
    private static volatile boolean sNotifiedColdStartFinsish;
    private static volatile List<String> sPublicIPv4List;
    private static volatile List<String> sPublicIPv6List;
    private static ITTSystemApiSandbox sSystemApiSandbox;
    private static TTNetThreadConfigInfoManager sTTNetThreadConfigInfoManager;

    public static final enum ENV extends Enum<ENV> {
        private static final /* synthetic */ ENV[] $VALUES = null;
        public static final ENV DEBUG = null;
        public static final ENV RELEASE = null;

        static {
            ENV r0 = new ENV("DEBUG", 0);
            DEBUG = r0;
            ENV r1 = new ENV("RELEASE", 1);
            RELEASE = r1;
            $VALUES = new ENV[]{r0, r1};
        }

        private ENV(String r1, int r2) {
            super(r1, r2);
        }

        public static ENV valueOf(String r1) {
            return (ENV) Enum.valueOf(ENV.class, r1);
        }

        public static ENV[] values() {
            return (ENV[]) $VALUES.clone();
        }
    }

    @Deprecated
    public static void doCommand(Context r0, String r1) {
    }

    @Deprecated
    public static void setALogFuncAddr(long r0) throws Exception {
    }

    @Deprecated
    public static void setEnableURLDispatcher(boolean r0) throws Exception {
    }

    public static void setFirstRequestWaitTime(long r0) {
    }

    public static void setHttpDnsForTesting(boolean r0, boolean r1, boolean r2) throws Exception {
    }

    @Deprecated
    public static boolean urlDispatchEnabled() {
        return true;
    }

    public TTNetInit() {
    }

    static /* synthetic */ void access$000(Context r0, boolean r1, boolean r2) {
        tryInitCookieManager(r0, r1, r2);
    }

    static /* synthetic */ void access$100() {
        setCookieInitCompleted();
    }

    static {
        sLatchInitCompleted = new CountDownLatch(1);
        sApiHttpInterceptEnabled = false;
        sCookieLogReportEnabled = false;
        sListenAppStateIndependently = false;
        sMainThreadInitCookieEnabled = true;
        sMaxHttpDiskCacheSize = BluetoothPbapClient.VCARD_ATTR_CLASS;
        sAppSecurityLevel = 0;
        sLifeCycleMonitor = new LifeCycleMonitor();
        TTALog.init();
        env = ENV.RELEASE;
        sNotifiedColdStartFinsish = false;
        sClientIPString = "";
        sCookieManagerInitStartTime = 0;
    }

    public static ENV getEnv() {
        return env;
    }

    public static void setEnv(ENV r0) {
        env = r0;
    }

    public static void setListenAppStateIndependently(boolean r0) {
        sListenAppStateIndependently = r0;
    }

    public static boolean getListenAppStateIndependently() {
        return sListenAppStateIndependently;
    }

    public static void setMaxHttpDiskCacheSize(long r2) {
        if (r2 <= 0) goto L6;
        sMaxHttpDiskCacheSize = r2;
        return;
    }

    public static long getMaxHttpDiskCacheSize() {
        return sMaxHttpDiskCacheSize;
    }

    public static void setAppSecurityLevel(int r0) {
        sAppSecurityLevel = r0;
    }

    public static int getAppSecurityLevel() {
        return sAppSecurityLevel;
    }

    public static void setTTNetDepend(ITTNetDepend r6) {
        sITTNetDepend = r6;
        Map<String, String> r0 = getTTNetDepend().getTTNetServiceDomainMap();
        if (TextUtils.isEmpty(r0.get(DOMAIN_HTTPDNS_KEY)) == false) goto L5;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L19;
        Object r2 = sITTNetDepend;
        if ((r2 instanceof AbsOptionalTTNetDepend) == true) goto L15;
    L17:
        HttpRequestInfo.injectCreate();
        BoeUtils.setBoeSuffix(r0.get(DOMAIN_BOE_KEY));
        BoeUtils.setBoeHttpsSuffix(r0.get(DOMAIN_BOE_HTTPS_KEY));
        OkHttpAppInfoProvider.inst().setTTNetDepend(r6);
        return;
    L15:
        if (((AbsOptionalTTNetDepend) r2).isPrivacyAccessEnabled() == true) goto L17;
        setAppSecurityLevel(sAppSecurityLevel | 1);
        goto L17
    L19:
        sITTNetDepend = null;
        throw new IllegalArgumentException("You must set HttpDns, NetLog and BOE service domain, please refer to TTNet access documents.");
    L5:
        if (TextUtils.isEmpty(r0.get(DOMAIN_BOE_KEY)) == true) goto L7;
    L9:
        r1 = false;
        goto L11
    L7:
        if (TextUtils.isEmpty(r0.get(DOMAIN_BOE_HTTPS_KEY)) == false) goto L9;
        goto L9
    }

    public static void setTTNetThreadConfigInfoManager(TTNetThreadConfigInfoManager r0) {
        sTTNetThreadConfigInfoManager = r0;
    }

    public static List<TTNetThreadConfig> getThreadConfigInfoList() {
        TTNetThreadConfigInfoManager r0 = sTTNetThreadConfigInfoManager;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getThreadConfigInfoList();
    }

    public static TTNetThreadConfig.Callback getThreadConfigCallbackImpl() {
        TTNetThreadConfigInfoManager r0 = sTTNetThreadConfigInfoManager;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getThreadConfigCallbackImpl();
    }

    public static ITTNetDepend getTTNetDepend() {
        ITTNetDepend r0 = sITTNetDepend;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("sITTNetDepend is null");
    }

    public static void setCronetDepend(ICronetAppProvider r1) {
        if (r1 == null) goto L6;
        sCronetProvider = r1;
        TNCManager.initStoreRegionModule(r1);
        OkHttpAppInfoProvider.inst().setCronetProvider(r1);
        SsCronetHttpClient.setCronetAppInfoProvider(r1);
        SsOkHttp3Client.injectAppInfoProvider(OkHttpAppInfoProvider.inst());
        return;
    L6:
        throw new IllegalArgumentException("cronetDepend is null");
    }

    public static ICronetAppProvider getCronetProvider() {
        return sCronetProvider;
    }

    public static void setSystemApiSandbox(ITTSystemApiSandbox r0) {
        sSystemApiSandbox = r0;
    }

    public static ITTSystemApiSandbox getSystemApiSandbox() {
        return sSystemApiSandbox;
    }

    public static void setGetDomainRegionMap(Map<String, String> r1) {
        if (r1 == null) goto L6;
        sGetDomainRegionMap = r1;
        return;
    L6:
        throw new IllegalArgumentException("getDomainRegionMap is null");
    }

    public static String getGetDomainConfigByRegion(String r1) {
        Map<String, String> r0 = sGetDomainRegionMap;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return null;
    L7:
        if (sCronetProvider != null) goto L9;
        return null;
    L9:
        if (TextUtils.isEmpty(r1) == false) goto L12;
        return null;
    L12:
        return sGetDomainRegionMap.get(r1.toLowerCase());
    }

    public static void enableCookieLogReport(boolean r0) {
        sCookieLogReportEnabled = r0;
    }

    public static boolean cookieLogReportEnabled() {
        return sCookieLogReportEnabled;
    }

    public static void getInitCompletedLatch() {
        sLatchInitCompleted.await(5, TimeUnit.SECONDS);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    private static void countDownInitCompletedLatch() {
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (sLatchInitCompleted.getCount() <= 0) goto L11;
        sLatchInitCompleted.countDown();     // Catch: Exception -> L6
        return;
    }

    public static void tryInitTTNet(final Context r3, Application r4, NetworkParams.ApiProcessHook<HttpRequestInfo> r5, NetworkParams.MonitorProcessHook<HttpRequestInfo> r6, NetworkParams.CommandListener r7, final boolean r8, boolean... r9) {
        TTNetInitMetrics.inst().initTTNetStartTime = System.currentTimeMillis();
        TTNetInitMetrics.inst().initTTNetStart = System.nanoTime();
        if (r3 == null) goto L36;
        SDKConfig.registerSdk();
        DebugMode.openIfDebug(r3);
        RetrofitLogger.setLogLevel(Logger.getLogLevel());
        NetworkParams.setApiProcessHook(r5);
        HttpRequestInfo.injectCreate();
        KevaBuilder.getInstance().setContext(r3);
        if (r9 != null) goto L7;
    L9:
        boolean r10 = false;
    L10:
        boolean r0 = ProcessUtils.isMainProcessByProcessFlag(r3);
        if (r0 == false) goto L13;
        final String r1 = "NetWork-AsyncInit";
        new AnonymousClass1(r1, r3, r8).start();
    L20:
        TNCManager.getInstance().initTnc(r3, r0);
        URLDispatcher.inst().setContext(r3);
        AppConfig.getInstance(r3);
        TTNetInitMetrics.inst().initMSSdkFromTTNet(r3);
        NetworkParams.setMonitorProcessHook(r6);
        countDownInitCompletedLatch();
        if (r0 == true) goto L24;
        TTNetInitMetrics.inst().isMainProcess = false;
        TTNetInitMetrics.inst().initTTNetEnd = System.nanoTime();
        return;
    L24:
        NetworkParams.setCommandListener(r7);
        if (RequestTicketUtil.getRequestTicketProcessor() != null) goto L27;
        RequestTicketUtil.setRequestTicketProcessor(new AnonymousClass3(r3));
    L27:
        sLifeCycleMonitor.addListener(QueryFilterStateListener.getInstance());
        if (r4 == null) goto L31;
        r4.registerActivityLifecycleCallbacks(sLifeCycleMonitor);
    L31:
        if (HttpClient.isCronetClientEnable() == true) goto L33;
        Log.d("TTNetInit", "cronet disable");
        notifyColdStartFinish();
    L33:
        TTNetInitMetrics.inst().initTTNetEnd = System.nanoTime();
        return;
    L13:
        if (r10 == false) goto L15;
    L18:
        final boolean r11 = true;
    L19:
        final String r2 = "NetWork-AsyncInit-other";
        new AnonymousClass2(r2, r3, r11, r8).start();
        goto L20
    L15:
        if (ProcessUtils.isMessageProcess(r3) == true) goto L18;
        r11 = false;
        goto L19
    L7:
        if (r9.length <= 0) goto L9;
        r10 = r9[0];
        goto L10
    L36:
        throw new IllegalArgumentException("tryInitTTNet context is null");
    }

    public static void notifyColdStartFinish() {
        if (sITTNetDepend != null) goto L5;
        return;
    L5:
        if (sNotifiedColdStartFinsish == true) goto L9;
        sNotifiedColdStartFinsish = true;
        sITTNetDepend.onColdStartFinish();
        return;
    }

    public static void onClientIPChanged(String r0) {
        if (r0 == null) goto L5;
        sClientIPString = r0;
        return;
    }

    public static String getClientIpString() {
        return sClientIPString;
    }

    public static void onPublicIPsChanged(List<String> r0, List<String> r1) {
        sPublicIPv4List = r0;
        sPublicIPv6List = r1;
    }

    public static List<String> getPublicIPv4List() {
        return sPublicIPv4List;
    }

    public static List<String> getPublicIPv6List() {
        return sPublicIPv6List;
    }

    public static void setCookieHandler(final Context r8) {
        CookieHandler r0 = CookieHandler.getDefault();     // Catch: Throwable -> L22
        if (r0 == null) goto L9;
        if ((r0 instanceof SSCookieHandler) == false) goto L9;
        NetworkParams.setCookieMgrInited(true);     // Catch: Throwable -> L22
        setCookieInitCompleted();     // Catch: Throwable -> L22
        return;
    L9:
        if (sCookieManagerInitStartTime > 0) goto L13;
        NetworkParams.setCookieMgrInited(true);     // Catch: Throwable -> L22
        setCookieInitCompleted();     // Catch: Throwable -> L22
        return;
    L13:
        if (TTNetInitMetrics.inst().initCookieManagerStart != 0) goto L26;
        TTNetInitMetrics r1 = TTNetInitMetrics.inst();     // Catch: Throwable -> L22
        r1.initCookieManagerStart = System.nanoTime();     // Catch: Throwable -> L22
    L26:
        CookieManager r2 = CookieManager.getInstance();     // Catch: Throwable -> L17
    L16:
        CookieManager r5 = r2;
        CookieHandler.setDefault(new SSCookieHandler(r8, sDelayTime, r5, getTTNetDepend().getCookieFlushPathList(), new AnonymousClass4(r8)));     // Catch: Throwable -> L22
        NetworkParams.setCookieMgrInited(true);     // Catch: Throwable -> L22
        setCookieInitCompleted();     // Catch: Throwable -> L22
        TTNetInitMetrics r3 = TTNetInitMetrics.inst();     // Catch: Throwable -> L22
        r3.initCookieManagerEnd = System.nanoTime();     // Catch: Throwable -> L22
        return;
    L17:
        th = move-exception;
        sDelayTime = 0;     // Catch: Throwable -> L22
        CookieInitFailedReport(r8, th.getMessage());     // Catch: Throwable -> L22
        r2 = null;
    L22:
        th = move-exception;
        CookieInitFailedReport(r8, th.getMessage());
        th.printStackTrace();
    }

    public static void trySetDefaultUserAgent(String r0) {
        NetworkParams.setDefaultUserAgent(r0);
    }

    public static void setMainThreadInitCookieEnabled(boolean r0) {
        sMainThreadInitCookieEnabled = r0;
    }

    private static void tryInitCookieManager(final Context r6, final boolean r7, final boolean r8) {
        if (Logger.debug() == false) goto L34;
        Logger.d(TAG, "tryInitCookieManager needSetCookieHandler:" + r7 + ", isMain:" + r8);
    L34:
        sCookieManagerInitStartTime = System.currentTimeMillis();     // Catch: Throwable -> L15
        if (r7 == true) goto L8;
        NetworkParams.setCookieMgrInited(true);     // Catch: Throwable -> L15
        setCookieInitCompleted();     // Catch: Throwable -> L15
    L32:
        ClientKeyManager.inst().InitClientKeyAndSessionInfo(r8);
        return;
    L8:
        if (TTNetInitMetrics.inst().initCookieManagerStart != 0) goto L10;
        TTNetInitMetrics.inst().initCookieManagerStart = System.nanoTime();     // Catch: Throwable -> L15
    L10:
        CookieSyncManager.createInstance(r6);     // Catch: Throwable -> L15
        CookieManager r2 = CookieManager.getInstance();     // Catch: Throwable -> L15
        r2.setAcceptCookie(true);     // Catch: Throwable -> L15
        setCookieHandler(r6);     // Catch: Throwable -> L15
        if (Logger.debug() == false) goto L32;
        Logger.d("Process", " CookieManager = " + r2.toString() + " pid = " + Process.myPid());     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.printStackTrace();
        if (ProcessUtils.isMainProcessByProcessFlag(r6) == false) goto L32;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) goto L32;
        if (sMainThreadInitCookieEnabled == false) goto L23;
        new Handler(Looper.getMainLooper()).post(new AnonymousClass5(r6, r7, r8));
    L23:
        JSONObject r9 = new JSONObject();
        r9.put("error", th.getMessage());     // Catch: JSONException -> L26
    L28:
        ITTNetDepend r1 = sITTNetDepend;
        if (r1 == null) goto L31;
        r1.monitorLogSend("async_init_cookie_manager_fail", r9);
    L31:
        CookieInitFailedReport(r6, th.getMessage());
    L26:
        e = move-exception;
        e.printStackTrace();
        goto L28
    }

    private static void CookieInitFailedReport(Context r3, String r4) {
        JSONObject r1 = new JSONObject();
        r1.put("init", "failed");     // Catch: JSONException -> L5
        r1.put("exception", r4);     // Catch: JSONException -> L5
    L7:
        getTTNetDepend().mobOnEvent(r3, "TTNET-COOKIE", "init", r1);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static void useCustomizedCookieStoreName() {
        PersistentCookieStore.useCustomizedCookieStoreName();
    }

    public static void triggerGetDomain(Context r0, boolean r1) {
        SsCronetHttpClient.inst(r0).triggerGetDomain(r1);
    }

    public static void trigerGetDomain(Context r1) {
        triggerGetDomain(r1, false);
    }

    public static void runInBackGround(Context r0, boolean r1) {
        SsCronetHttpClient.inst(r0).runInBackGround(r1);
    }

    public static void addClientOpaqueData(Context r8, String[] r9, byte[] r10, byte[] r11, long r12, long r14) {
        SsCronetHttpClient.inst(r8).addClientOpaqueData(r9, r10, r11, r12, r14);
    }

    public static void addClientOpaqueData(Context r8, String[] r9, byte[] r10, byte[] r11) {
        SsCronetHttpClient.inst(r8).addClientOpaqueData(r9, r10, r11, 0, 0);
    }

    public static void clearClientOpaqueData(Context r0) {
        SsCronetHttpClient.inst(r0).clearClientOpaqueData();
    }

    public static void removeClientOpaqueData(Context r0, String r1) {
        SsCronetHttpClient.inst(r0).removeClientOpaqueData(r1);
    }

    public static void setProxy(String r1) throws Exception {
        if (TTNetInitMetrics.isCronetInitSuccess() == false) goto L5;
        SsCronetHttpClient.inst(getTTNetDepend().getContext()).setProxy(r1);
        return;
    L5:
        SsOkHttp3Client.inst(getTTNetDepend().getContext());
        SsOkHttp3Client.setProxy(r1);
    }

    @Deprecated
    public static List<InetAddress> dnsLookup(String r3) throws Exception {
        if (TTNetInitMetrics.isCronetInitSuccess() == false) goto L24;
        TTDnsResult r0 = TTDnsResolve(r3, 0);
        if (r0.ret != 0) goto L22;
        if (r0.iplist == null) goto L22;
        if (r0.iplist.isEmpty() == true) goto L22;
        ArrayList r1 = new ArrayList();
        Iterator<String> r2 = r0.iplist.iterator();
    L12:
        if (r2.hasNext() == false) goto L17;
        byte[] r4 = InetAddress.getByName(r2.next()).getAddress();
        if (r4 == null) goto L12;
        r1.add(InetAddress.getByAddress(r3, r4));
        goto L12
    L17:
        if (r1.isEmpty() == true) goto L20;
        return r1;
    L20:
        throw new UnknownHostException(r3);
    L22:
        throw new UnknownHostException(r3);
    L24:
        throw new IllegalStateException("Cronet engine has not been initialized and completed.");
    }

    public static NetworkQuality getNetworkQuality() throws Exception {
        return SsCronetHttpClient.inst(getTTNetDepend().getContext()).getNetworkQuality();
    }

    public static PacketLossMetrics getPacketLossRateMetrics(int r1) throws Exception {
        return SsCronetHttpClient.inst(getTTNetDepend().getContext()).getPacketLossRateMetrics(r1);
    }

    public static Map<String, NetworkQuality> getGroupRttEstimates() throws Exception {
        return SsCronetHttpClient.inst(getTTNetDepend().getContext()).getGroupRttEstimates();
    }

    public static void preInitCronetKernel() throws Exception {
        int r0 = -1;
    L7:
        th = move-exception;
        if ((th instanceof IllegalArgumentException) == false) goto L11;
        r0 = 3;
    L11:
        String r2 = TtnetUtil.outputThrowableStackTrace(th);
        if (r2.length() <= 1024) goto L14;
        r2 = r2.substring(0, 1024);
    L14:
        feedBackCronetInitFailedLog(r0, r2);
        throw th;
    L4:
        if (getCronetHttpClient(TTNetInitMetrics.CronetInitMode.PRE_INIT) != null) goto L18;
        r0 = SsOkHttp3Client.getFallbackReason();     // Catch: Throwable -> L7
        feedBackCronetInitFailedLog(r0, "");     // Catch: Throwable -> L7
        return;
    }

    private static void feedBackCronetInitFailedLog(int r2, String r3) {
        JSONObject r0 = new JSONObject();
        r0.put("fallback", r2);     // Catch: JSONException -> L10
        r0.put("exception", r3);     // Catch: JSONException -> L10
        r0.put("model", Build.MODEL);     // Catch: JSONException -> L10
        String r4 = "";
        String[] r5 = Build.SUPPORTED_ABIS;     // Catch: JSONException -> L10
        if (r5 != null) goto L6;
    L8:
        r0.put("abis", r4);     // Catch: JSONException -> L10
        getTTNetDepend().monitorLogSend("cronet_failed", r0);     // Catch: JSONException -> L10
        return;
    L6:
        if (r5.length <= 0) goto L8;
        r4 = Arrays.asList(r5).toString();     // Catch: JSONException -> L10
    }

    public static void forceInitCronetKernel() throws Exception {
        if (TTNetInitMetrics.inst().mode != TTNetInitMetrics.CronetInitMode.NONE) goto L5;
        TTNetInitMetrics r0 = TTNetInitMetrics.inst();
        r0.mode = TTNetInitMetrics.CronetInitMode.FORCE_INIT;
    L5:
        SsCronetHttpClient.inst(getTTNetDepend().getContext()).tryCreateCronetEngine(false, false, false, AppConfig.getInstance(getTTNetDepend().getContext()).isCronetHttpDnsOpen(), true, sCronetProvider);
    }

    @Deprecated
    public static void setHostResolverRulesForTesting(String r1) throws Exception {
        SsCronetHttpClient r0 = getCronetHttpClient(TTNetInitMetrics.CronetInitMode.DEPRECATED_API);
        if (r0 == null) goto L6;
        r0.setHostResolverRules(r1);
        return;
    }

    public static boolean tryStartTTNetDetect(String[] r2, int r3, int r4) {
        if (r2 != null) goto L5;
    L16:
        return false;
    L5:
        if (r2.length <= 0) goto L16;
        if (r3 <= 0) goto L16;
        if (r3 > 180) goto L16;
        if (r4 < 0) goto L16;
        SsCronetHttpClient.inst(getTTNetDepend().getContext()).tryStartNetDetect(r2, r3, r4);     // Catch: Throwable -> L14
        return true;
    L14:
        th = move-exception;
        th.printStackTrace();
        goto L16
    }

    public static TTDnsResult TTDnsResolve(String r1, int r2) throws Exception {
        return TTDnsResolve(r1, r2, null);
    }

    public static TTDnsResult TTDnsResolve(String r1, int r2, Map<String, String> r3) throws Exception {
        if (TTNetInitMetrics.isCronetInitSuccess() == false) goto L7;
        return TTDnsOuterService.getInstance().TTDnsResolve(r1, r2, r3);
    L7:
        throw new IllegalStateException("Cronet engine has not been initialized and completed.");
    }

    public static void getMappingRequestState(String r1) {
        SsCronetHttpClient.inst(getTTNetDepend().getContext()).getMappingRequestState(r1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public static void setDelayTime(int r0) {
        sDelayTime = r0;
    }

    public static void setBypassOfflineCheck(boolean r0) {
        SsCronetHttpClient.setBypassOfflineCheck(r0);
    }

    @Deprecated
    public static long getALogFuncAddr() {
        return TTALog.getALogFuncAddr();
    }

    public static void enableApiHttpIntercept(boolean r0) {
        sApiHttpInterceptEnabled = r0;
    }

    public static boolean apiHttpInterceptEnabled() {
        return sApiHttpInterceptEnabled;
    }

    public static void monitorLogSend(String r1, JSONObject r2) {
        ITTNetDepend r0 = sITTNetDepend;
        if (r0 == null) goto L6;
        r0.monitorLogSend(r1, r2);
        return;
    }

    private static SsCronetHttpClient getCronetHttpClient(TTNetInitMetrics.CronetInitMode r7) throws Exception {
        if (TTNetInitMetrics.inst().mode != TTNetInitMetrics.CronetInitMode.NONE) goto L6;
        TTNetInitMetrics.inst().mode = r7;
    L6:
        if (HttpClient.isCronetClientEnable() == false) goto L9;
        SsCronetHttpClient r8 = SsCronetHttpClient.inst(getTTNetDepend().getContext());
        r8.tryCreateCronetEngine(false, true, false, AppConfig.getInstance(getTTNetDepend().getContext()).isCronetHttpDnsOpen(), false, sCronetProvider);
        return r8;
    L9:
        return null;
    }

    public static void enableTTBizHttpDns(boolean r8, String r9, String r10, String r11, boolean r12, String r13) {
        if (r8 == true) goto L4;
    L17:
        SsCronetHttpClient r1 = getCronetHttpClient(TTNetInitMetrics.CronetInitMode.BIZ_HTTPDNS_API);     // Catch: Throwable -> L14
        if (r1 == null) goto L21;
        r1.enableTTBizHttpDns(r8, r9, r10, r11, r12, r13);     // Catch: Throwable -> L14
        return;
    L21:
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L4:
        if (TextUtils.isEmpty(r9) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r10) == false) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r11) == false) goto L17;
    }

    public static int getEffectiveConnectionType() {
        return SsCronetHttpClient.inst(getTTNetDepend().getContext()).getEffectiveConnectionType();
    L4:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public static TTDispatchResult ttUrlDispatch(String r1) throws Exception {
        return ttUrlDispatchInternal(r1, -1);
    }

    private static TTDispatchResult ttUrlDispatchInternal(String r7, int r8) throws Exception {
        if (AppConfig.getInstance(getTTNetDepend().getContext()).isChromiumOpen() == true) goto L11;
        DispatchResult r9 = URLDispatcher.inst().getDispatchResultForUrl(new URLRequest(r7, null, null));
        if (r9 == null) goto L9;
        return new TTDispatchResult(r7, r9.mDispatchedURL, String.valueOf(URLDispatcher.inst().getEpoch()), URLDispatcher.inst().getTncEtag(), TTDispatchResult.DispatchState.SUCCESS);
    L9:
        throw new IllegalArgumentException(OKHTTP_DISPATCH_FAILED);
    L11:
        if (TTNetInitMetrics.isCronetInitSuccess() == false) goto L17;
        new URL(r7).toURI();     // Catch: Exception -> L14
        return SsCronetHttpClient.ttUrlDispatch(r7, r8);
    L14:
        e = move-exception;
        throw e;
    L17:
        throw new IllegalStateException(TTNET_CRONET_NOT_INITIALIZED);
    }

    public static TTDispatchResult ttUrlDispatchV2(String r2, int r3) {
        new URL(r2).toURI();     // Catch: Exception -> L37
        return ttUrlDispatchInternal(r2, r3);
    L5:
        e = move-exception;
        String r0 = e.getMessage();
        if ((e instanceof ReflectException) == false) goto L11;
        return convertReflectException(r2, e);
    L11:
        if ((e instanceof IllegalArgumentException) == false) goto L17;
        if (OKHTTP_DISPATCH_FAILED.equals(r0) == false) goto L17;
        return new TTDispatchResult(r2, TTDispatchResult.DispatchState.OKHTTP_DISPATCH_FAILED);
    L17:
        if ((e instanceof IllegalStateException) == false) goto L23;
        if (TTNET_CRONET_NOT_INITIALIZED.equals(r0) == false) goto L23;
        return new TTDispatchResult(r2, TTDispatchResult.DispatchState.CRONET_NOT_INIT);
    L23:
        if ((e instanceof UnknownFormatConversionException) == false) goto L29;
        if (RETURN_WRONG_FORMAT.equals(r0) == false) goto L29;
        return new TTDispatchResult(r2, TTDispatchResult.DispatchState.WRONG_FORMAT);
    L29:
        if ((e instanceof URISyntaxException) == true) goto L36;
        if ((e instanceof MalformedURLException) == true) goto L36;
        return new TTDispatchResult(r2, TTDispatchResult.DispatchState.NOT_REACHED);
    L36:
        return new TTDispatchResult(r2, TTDispatchResult.DispatchState.INVALID_FINAL_URL);
    L38:
        return new TTDispatchResult(r2, TTDispatchResult.DispatchState.INVALID_ORIGIN_URL);
    }

    private static TTDispatchResult convertReflectException(String r2, Exception r3) {
        Throwable r4 = r3.getCause();
        if ((r4 instanceof InvocationTargetException) == false) goto L5;
        Throwable r5 = r4.getCause();
        if (r5 == null) goto L9;
        String r0 = r5.getMessage();
    L11:
        if ((r5 instanceof SocketTimeoutException) == false) goto L17;
        if (ApmTrafficStats.KEY_TRAFFIC_SOURCE_TTNET.equals(r0) == false) goto L17;
        return new TTDispatchResult(r2, TTDispatchResult.DispatchState.TIMEOUT);
    L17:
        if ((r5 instanceof UnsupportedOperationException) == false) goto L23;
        if (ConstantsDefined.CRONET_NOT_INITIALIZED.equals(r0) == false) goto L23;
        return new TTDispatchResult(r2, TTDispatchResult.DispatchState.CRONET_NOT_INIT);
    L23:
        if ((r5 instanceof IllegalStateException) == false) goto L29;
        if ("Engine is shut down.".equals(r0) == false) goto L29;
        return new TTDispatchResult(r2, TTDispatchResult.DispatchState.CRONET_NOT_INIT);
    L29:
        return new TTDispatchResult(r2, TTDispatchResult.DispatchState.NOT_REACHED);
    L9:
        r0 = "";
        goto L11
    L5:
        return new TTDispatchResult(r2, TTDispatchResult.DispatchState.NOT_REACHED);
    }

    public static void preconnectUrl(String r1) throws Exception {
        preconnectUrl(r1, null);
    }

    public static void preconnectUrl(String r1, Map<String, String> r2) throws Exception {
        if (TTNetInitMetrics.isCronetInitSuccess() == false) goto L9;
        new URL(r1).toURI();     // Catch: Exception -> L6
        SsCronetHttpClient.inst(getTTNetDepend().getContext()).preconnectUrl(r1, r2);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        throw e;
    L9:
        throw new IllegalStateException("Cronet engine has not been initialized and completed.");
    }

    public static void setProcessFlag(int r0) {
        ProcessUtils.setProcessFlag(r0);
    }

    public static void setZstdFuncAddr(long r18, long r20, long r22, long r24, long r26, long r28, long r30, long r32) throws Exception {
        SsCronetHttpClient r1 = getCronetHttpClient(TTNetInitMetrics.CronetInitMode.ZSTD_API);
        if (r1 != null) goto L5;
        return;
    L5:
        if (Logger.debug() == false) goto L8;
        Logger.d("TTNet_ZSTD", " createDCtxAddr:" + r18 + " decompressStreamAddr:" + r20 + " freeDctxAddr:" + r22 + " isErrorAddr:" + r24 + " createDDictAddr:" + r26 + " dctxRefDDictAddr:" + r28 + " freeDDictAddr:" + r30 + " dctxResetAddr:" + r32);
    L8:
        r1.setZstdFuncAddr(r18, r20, r22, r24, r26, r28, r30, r32);
    }

    private static void setCookieInitCompleted() {
        SsCronetHttpClient r0 = getCronetHttpClient(TTNetInitMetrics.CronetInitMode.COOKIE_INIT_COMPLETE_API);     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.setCookieInitCompleted();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public static void clearTNCFileBeforeStart(Context r3) {
        if (r3 == null) goto L9;
        File r0 = new File(r3.getFilesDir(), "server.json");     // Catch: Throwable -> L10
        if (r0.exists() == false) goto L6;
        r0.delete();     // Catch: Throwable -> L10
    L6:
        r3.getSharedPreferences(AppConfig.getSsAppConfigFileName(), 0).edit().clear().apply();
        r3.getSharedPreferences(TNCManager.TNC_SP_NAME, 0).edit().clear().apply();
        return;
    L9:
        throw new IllegalArgumentException("context is null");
    }
}
