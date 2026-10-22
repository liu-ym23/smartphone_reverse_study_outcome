package com.bytedance.ttnet.config;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.utility.persistent.SharedPrefsEditorCompat;
import com.bytedance.frameworks.baselib.network.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.connectionclass.ConnectionClassManager;
import com.bytedance.frameworks.baselib.network.connectionclass.ConnectionQuality;
import com.bytedance.frameworks.baselib.network.dispatcher.RequestQueue;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.commonparam.CommonParamConfig;
import com.bytedance.frameworks.baselib.network.http.commonparam.CommonParamManager;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetSsCallConfig;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.bytedance.frameworks.baselib.network.http.exception.NotAllowApiHttpException;
import com.bytedance.frameworks.baselib.network.http.impl.CookieManagerWrap;
import com.bytedance.frameworks.baselib.network.http.impl.SSCookieHandler;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.OkHttp3Builder;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.SsOkHttp3Client;
import com.bytedance.frameworks.baselib.network.http.parser.StreamParser;
import com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionManager;
import com.bytedance.frameworks.baselib.network.http.util.ProcessUtils;
import com.bytedance.frameworks.baselib.network.http.util.URIUtils;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.frameworks.baselib.network.queryfilter.QueryFilterEngine;
import com.bytedance.frameworks.core.encrypt.RequestEncryptUtils;
import com.bytedance.ttnet.AppConsts;
import com.bytedance.ttnet.HttpClient;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.debug.DebugMode;
import com.bytedance.ttnet.retrofit.SsInterceptor;
import com.bytedance.ttnet.tnc.TNCManager;
import com.bytedance.ttnet.utils.CdnCacheVerifyUtils;
import com.bytedance.ttnet.utils.RequestTicketUtil;
import com.bytedance.ttnet.utils.TtnetUtil;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AppConfig implements NetworkParams.ApiRequestInterceptor, WeakHandler.IHandler, RequestEncryptUtils.IEncryptConfig, HttpClient.IHttpClientConfig, SsCronetHttpClient.ICronetHttpDnsConfig, SsCronetHttpClient.ICronetBootFailureChecker, ConnectionClassManager.ConnectionClassStateChangeListener, NetworkParams.ConnectionQualitySamplerHook, SsCronetHttpClient.ITncInfoGet, NetworkParams.CdnConnectionQualitySamplerHook, NetworkParams.CookieShareInterceptor {
    static final int CONTINUOUS_FAILURES_TO_CLOSE_CRONET = 5;
    static final int CRONET_TRY_REBOOT_HOURS = 1;
    private static final int INVALID_VALUE = Integer.MIN_VALUE;
    static final String KEY_ADD_DEVICE_FINGERPRINT_OPEN = "add_device_fingerprint_open";
    static final String KEY_ADD_SS_QUERIES_HEADER_OPEN = "add_ss_queries_header_open";
    static final String KEY_ADD_SS_QUERIES_OPEN = "add_ss_queries_open";
    static final String KEY_ADD_SS_QUERIES_PLAINTEXT_OPEN = "add_ss_queries_plaintext_open";
    static final String KEY_API_HTTP_HOST_LIST = "api_http_host_list";
    static final String KEY_CDN_SAMPLE_BAND_WIDTH_ENABLED = "cdn_sample_band_width_enabled";
    static final String KEY_CHROMIUM_BOOT_FAILURES = "chromium_boot_failures";
    static final String KEY_CHROMIUM_BOOT_FAILURES_TIMESTAMP = "chromium_boot_failures_timestamp";
    static final String KEY_COLLECT_RECENT_PAGE_INFO_ENABLE = "collect_recent_page_info_enable";
    static final String KEY_COMMON_PARAMS_CONFIG = "add_common_params";
    static final String KEY_CONCURRENT_REQUEST_CONFIG = "concurrent_request_config";
    static final String KEY_CRASH_DETECT_INTERVAL_MS = "crash_detect_interval_ms";
    static final String KEY_CRASH_LIMIT_TIMES = "crash_limit_times";
    static final String KEY_CRONET_SO_PATH = "cronet_so_path";
    static final String KEY_CRONET_VERSION = "cronet_version";
    static final String KEY_DESTROY_DELTA_MILLIS = "destroy_delta_millis";
    static final String KEY_DETECT_NATIVE_PAGE = "detect_native_page";
    static final String KEY_DETECT_OPEN = "detect_open";
    static final String KEY_DISABLE_FRAMED_TRANSPORT = "disable_framed_transport";
    static final String KEY_DISABLE_ROTATION_HOST_RETRY = "disable_rotating_host_path_retry";
    static final String KEY_DYNAMIC_ADJUST_THREADPOOL_SIZE_OPEN = "dynamic_adjust_threadpool_size_open";
    static final String KEY_ENCRYPT_SWITCH = "android_log_encrypt_switch";
    static final String KEY_HTTP_DNS_ENABLED = "http_dns_enabled";
    static final String KEY_HTTP_SHOW_HIJACK = "http_show_hijack";
    static final String KEY_HTTP_VERIFY_SIGN = "http_verify_sign";
    static final String KEY_IMAGE_TTNET_ENABLED = "image_ttnet_enabled";
    static final String KEY_OK_HTTP3_OPEN = "ok_http3_open";
    static final String KEY_OK_HTTP_OPEN = "ok_http_open";
    static final String KEY_PRIVATE_PROTOCOL_ENABLED = "private_protocol_enabled";
    static final String KEY_SAMPLE_BAND_WIDTH_ENABLED = "sample_band_width_enabled";
    static final String KEY_SHARE_COOKIE_HOST_LIST = "share_cookie_host_list";
    static final String KEY_TNC_HOST_ARRAYS = "send_tnc_host_arrays";
    static final String KEY_TNC_SUMMARY = "tnc_summary";
    static final String KEY_TNC_UPDATE_INTERVAL = "tnc_update_interval";
    static final String KEY_USE_HTTP_DNS = "use_http_dns";
    static final String KEY_USE_HTTP_DNS_REFETCH_ON_EXPIRE = "use_http_dns_refetch_on_expire";
    static final int MSG_CONFIG_ERROR = 102;
    static final int MSG_CONFIG_OK = 101;
    static final int MSG_TNC_COLDSTART_DELAY = 104;
    static final int MSG_TNC_POLLING = 103;
    static final String SP_SS_APP_CONFIG = "ss_app_config";
    private static final String SYNC_MAIN_PROCESS_CONFIG_ACTION = "com.bytedance.ttnet.config.appconfig.SYNC_MAIN_PROCESS_CONFIG";
    static final String TAG = "AppConfig";
    private static String mFrontierUrls = "";
    private static AppConfig mInstance = null;
    private static ArrayList<String> sBlockModelList = null;
    static boolean sCronetUnsupportedModel = false;
    static boolean sDisableFallbackReasonBoot = false;
    static boolean sEnableFallbackReasonBootFix = true;
    static boolean sForceNotUseCronet = false;
    private static boolean sForceNotUseCronetHttpDns = false;
    private static String sPackageName = null;
    private static boolean sTestDeviceFingerPrint = false;
    private static boolean sTestSsQueries = false;
    private static int sUseHttpDns = -1;
    private static int sUseHttpDnsRefetchOnExpire = -1;
    private JSONObject mABTest;
    private int mAddDeviceFingerprintOpen;
    private int mAddSsQueriesHeaderOpen;
    private int mAddSsQueriesOpen;
    private int mAddSsQueriesPlaintextOpen;
    private List<String> mApiHttpHostList;
    private int mCdnSampleBandWidthEnabled;
    private volatile int mChromiumBootFailures;
    private long mChromiumBootFailuresTimestamp;
    private int mCollectRecentPageInfoEnable;
    private AtomicBoolean mConfigUpdating;
    private final Context mContext;
    private String mCronetSoPath;
    private int mCronetVersion;
    private int mDetectNativePage;
    private int mDetectOpen;
    private int mDynamicAdjustThreadPoolSizeOpen;
    private volatile int mEncryptSwitch;
    private volatile boolean mEncryptSwitchFromSP;
    final WeakHandler mHandler;
    private int mHttpDnsEnabled;
    private int mImageTtnetEnabled;
    private final boolean mIsMainProcess;
    private AtomicLong mLastRefreshTime;
    private volatile boolean mLocalLoaded;
    private final Object mLock;
    private int mOkHttp3Open;
    private int mOkHttpOpen;
    private AtomicBoolean mPreloadBootFailureInfo;
    private int mSampleBandWidthEnabled;
    private List<String> mShareCookieHostList;
    private String mTncEtag;
    private final List<String> mTncHostArrays;
    private String mTncSummary;
    private final AtomicInteger mTncUpdateInterval;

    static final class SyncConfigBroadcastReceiver extends BroadcastReceiver {
        SyncConfigBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            if (AppConfig.SYNC_MAIN_PROCESS_CONFIG_ACTION.equals(r2.getAction()) == false) goto L8;
            final String r3 = "SyncMainProcessConfig";
            new AnonymousClass1(this, r3).start();
            return;
        }
    }

    @Deprecated
    public static boolean getHttpVerifySign() {
        return true;
    }

    @Deprecated
    public static boolean getHttpsRetryHttp() {
        return false;
    }

    @Deprecated
    public static boolean getHttpsShowHijack() {
        return true;
    }

    @Deprecated
    public static boolean getHttpsToHttp() {
        return false;
    }

    public static String getSsAppConfigFileName() {
        return SP_SS_APP_CONFIG;
    }

    @Deprecated
    public void enableNewCronetBootFallback(boolean r1) {
    }

    public void handleConfigUpdate(String r1) {
    }

    @Deprecated
    public List<InetAddress> resolveInetAddressesFromHttpDns(String r1) {
        return null;
    }

    @Deprecated
    public void setCronetTryRebootHours(int r1) {
    }

    @Deprecated
    public void setForceSwitch(boolean r1) {
    }

    @Deprecated
    public void setForceUseCronet(boolean r1) {
    }

    @Deprecated
    public void setForceUseCronetOn4X(boolean r1) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.ApiRequestInterceptor
    public String tryDnsMapping(String r1, String[] r2) {
        return r1;
    }

    static /* synthetic */ Context access$000(AppConfig r0) {
        return r0.mContext;
    }

    static /* synthetic */ String access$100() {
        return sPackageName;
    }

    public static AppConfig getInstance(Context r4) {
        monitor-enter(AppConfig.class);
    L26:
        th = move-exception;
        throw th;
    L5:
        if (mInstance != null) goto L23;
        boolean r1 = ProcessUtils.isMainProcessByProcessFlag(r4);     // Catch: Throwable -> L26
        mInstance = new AppConfig(r4.getApplicationContext(), r1);     // Catch: Throwable -> L26
        if (sBlockModelList.contains(Build.MODEL) == false) goto L9;
        sCronetUnsupportedModel = true;     // Catch: Throwable -> L26
    L9:
        sPackageName = r4.getPackageName();     // Catch: Throwable -> L26
        if (r1 == false) goto L14;
        RequestEncryptUtils.setEncryptConfig(mInstance);     // Catch: Throwable -> L26
        SsCronetHttpClient.setCronetHttpDnsConfig(mInstance);     // Catch: Throwable -> L26
        SsCronetHttpClient.setCronetBootFailureChecker(mInstance);     // Catch: Throwable -> L26
        SsCronetHttpClient.setCronetTncInfoGet(mInstance);     // Catch: Throwable -> L26
        HttpClient.setHttpClientConfig(mInstance);     // Catch: Throwable -> L26
        ConnectionClassManager.getInstance().register(mInstance);     // Catch: Throwable -> L26
        NetworkParams.setConnectionQualitySamplerHook(mInstance);     // Catch: Throwable -> L26
        NetworkParams.setCdnConnectionQualitySamplerHook(mInstance);     // Catch: Throwable -> L26
        if (NetworkParams.getCookieShareInterceptor() != null) goto L22;
        NetworkParams.setCookieShareInterceptor(mInstance);     // Catch: Throwable -> L26
    L22:
        TTNetInitMetrics r2 = TTNetInitMetrics.inst();     // Catch: Throwable -> L26
        r2.initMultiProcStackOptConfigStart = System.nanoTime();     // Catch: Throwable -> L26
        SsCronetHttpClient.setCronetThreadOptFailureChecker(MultiProcStackOptConfig.inst(r4));     // Catch: Throwable -> L26
        TTNetInitMetrics r3 = TTNetInitMetrics.inst();     // Catch: Throwable -> L26
        r3.initMultiProcStackOptConfigEnd = System.nanoTime();     // Catch: Throwable -> L26
        NetworkParams.setApiRequestInterceptor(mInstance);     // Catch: Throwable -> L26
        ImageStrategyController.Init(r4);     // Catch: Throwable -> L26
        goto L23
    L14:
        IntentFilter r5 = new IntentFilter();     // Catch: Throwable -> L26
        r5.addAction(SYNC_MAIN_PROCESS_CONFIG_ACTION);     // Catch: Throwable -> L26
        TtnetUtil.registerNonExportedBroadcastReceiver(r4, new SyncConfigBroadcastReceiver(), r5);     // Catch: Throwable -> L17
    L19:
        SyncMultiProcessConfig r6 = SyncMultiProcessConfig.inst();     // Catch: Throwable -> L26
        RequestEncryptUtils.setEncryptConfig(r6);     // Catch: Throwable -> L26
        SsCronetHttpClient.setCronetHttpDnsConfig(r6);     // Catch: Throwable -> L26
        SsCronetHttpClient.setCronetBootFailureChecker(r6);     // Catch: Throwable -> L26
        HttpClient.setHttpClientConfig(r6);     // Catch: Throwable -> L26
        if (NetworkParams.getCookieShareInterceptor() != null) goto L22;
        NetworkParams.setCookieShareInterceptor(r6);     // Catch: Throwable -> L26
        goto L22
    L17:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L26
    L23:
        AppConfig r7 = mInstance;     // Catch: Throwable -> L26
        monitor-exit(AppConfig.class);     // Catch: Throwable -> L26
        return r7;
    }

    private AppConfig(Context r5, boolean r6) {
        this.mLastRefreshTime = new AtomicLong(0);
        this.mConfigUpdating = new AtomicBoolean(false);
        this.mLock = new Object();
        this.mLocalLoaded = false;
        this.mOkHttpOpen = 0;
        this.mOkHttp3Open = 0;
        this.mChromiumBootFailures = -1;
        this.mChromiumBootFailuresTimestamp = 0;
        this.mPreloadBootFailureInfo = new AtomicBoolean(false);
        this.mHttpDnsEnabled = 0;
        this.mDetectOpen = 0;
        this.mDetectNativePage = 1;
        this.mCollectRecentPageInfoEnable = 1;
        this.mAddSsQueriesOpen = 0;
        this.mAddSsQueriesHeaderOpen = 0;
        this.mAddSsQueriesPlaintextOpen = 1;
        this.mImageTtnetEnabled = 1;
        this.mSampleBandWidthEnabled = 1;
        this.mCdnSampleBandWidthEnabled = 1;
        this.mAddDeviceFingerprintOpen = 1;
        this.mDynamicAdjustThreadPoolSizeOpen = 1;
        this.mCronetSoPath = "";
        this.mShareCookieHostList = new CopyOnWriteArrayList();
        this.mCronetVersion = 0;
        this.mApiHttpHostList = new CopyOnWriteArrayList();
        this.mTncEtag = "";
        this.mTncUpdateInterval = new AtomicInteger(10800);
        this.mTncHostArrays = new CopyOnWriteArrayList();
        this.mHandler = new WeakHandler(Looper.getMainLooper(), this);
        this.mContext = r5;
        this.mIsMainProcess = r6;
    }

    public void tryRefreshConfig(TNCManager.TNCUpdateSource r2) {
        tryRefreshConfig(r2, false);
    }

    public void tryRefreshConfig(TNCManager.TNCUpdateSource r1, boolean r2) {
        tryRefreshConfigInternal(r1, r2);
    }

    private void tryRefreshConfigInternal(TNCManager.TNCUpdateSource r3, boolean r4) {
        if (this.mIsMainProcess == false) goto L6;
        doRefresh(r3, r4);
        return;
    L6:
        if (this.mLastRefreshTime.get() > 0) goto L13;
        final String r5 = "LoadDomainConfig4Other-Thread";
        new AnonymousClass1(this, r5).start();     // Catch: Throwable -> L9
        return;
    L14:
        return;
    }

    synchronized void tryLoadDomainConfig4OtherProcess() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if ((System.currentTimeMillis() - this.mLastRefreshTime.get()) <= (((long) this.mTncUpdateInterval.get()) * 1000)) goto L15;
        this.mLastRefreshTime.set(System.currentTimeMillis());     // Catch: Throwable -> L17
        int r0 = TTNetInit.getTTNetDepend().getProviderInt(this.mContext, KEY_DISABLE_FRAMED_TRANSPORT, 0);     // Catch: Exception -> L20 Throwable -> L17
        if (r0 <= 0) goto L13;
        OkHttp3Builder.disableFramedTransport(r0);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();     // Catch: Exception -> L20 Throwable -> L17
    L13:
        if (TNCManager.getInstance().getTNCConfigHandler() == null) goto L15;
        TNCManager.getInstance().getTNCConfigHandler().loadLocalConfigForOtherProcess(this.mLastRefreshTime.get());     // Catch: Exception -> L20 Throwable -> L17
    L15:
        monitor-exit(this);
    }

    public boolean doRefresh(final TNCManager.TNCUpdateSource r5, final boolean r6) {
        if (Logger.debug() == false) goto L6;
        Logger.d("TNCManager", "doRefresh: updating state " + this.mConfigUpdating.get());
    L6:
        if (this.mConfigUpdating.compareAndSet(false, true) == false) goto L8;
    L13:
        final String r1 = "AppConfigThread";
        new AnonymousClass2(this, r1, r5, r6).start();
        return true;
    L8:
        if (r5 == TNCManager.TNCUpdateSource.TTCRONETFAILED) goto L13;
        if (Logger.debug() == false) goto L12;
        Logger.d("TNCManager", "doRefresh, already running " + r5);
    L12:
        return false;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r5) {
        switch(r5.what) {
            case 101: goto L17;
            case 102: goto L14;
            case 103: goto L10;
            case 104: goto L6;
            default: goto L25;
        };
    L17:
        this.mLastRefreshTime.set(System.currentTimeMillis());
        if (Logger.debug() == false) goto L20;
        Logger.d("TNCManager", "doRefresh, succ");
    L20:
        this.mConfigUpdating.set(false);
        return;
    L25:
        return;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d("TNCManager", "did is empty, delay request tnc");
    L8:
        tryRefreshConfig(TNCManager.TNCUpdateSource.TTSERVER);
        return;
    L10:
        if (Logger.debug() == false) goto L12;
        Logger.d("TNCManager", "do tnc polling");
    L12:
        tryRefreshConfig(TNCManager.TNCUpdateSource.TTPOLL);
        return;
    L14:
        if (Logger.debug() == false) goto L16;
        Logger.d("TNCManager", "doRefresh, error");
    L16:
        this.mConfigUpdating.set(false);
    }

    public void tryLoadLocalConfig() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L78:
        th = move-exception;
        throw th;
    L5:
        if (this.mLocalLoaded == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L78
        return;
    L8:
        boolean r1 = true;
        this.mLocalLoaded = true;     // Catch: Throwable -> L78
        monitor-exit(r0);     // Catch: Throwable -> L78
        SharedPreferences r2 = this.mContext.getSharedPreferences(SP_SS_APP_CONFIG, 0);
        this.mOkHttpOpen = r2.getInt(KEY_OK_HTTP_OPEN, 0);
        this.mOkHttp3Open = r2.getInt(KEY_OK_HTTP3_OPEN, 0);
        this.mCronetVersion = r2.getInt(KEY_CRONET_VERSION, 0);
        this.mHttpDnsEnabled = r2.getInt(KEY_HTTP_DNS_ENABLED, 0);
        this.mDetectOpen = r2.getInt(KEY_DETECT_OPEN, 0);
        this.mDetectNativePage = r2.getInt(KEY_DETECT_NATIVE_PAGE, 1);
        this.mCollectRecentPageInfoEnable = r2.getInt(KEY_COLLECT_RECENT_PAGE_INFO_ENABLE, 1);
        this.mAddSsQueriesOpen = r2.getInt(KEY_ADD_SS_QUERIES_OPEN, 0);
        this.mAddSsQueriesHeaderOpen = r2.getInt(KEY_ADD_SS_QUERIES_HEADER_OPEN, 0);
        this.mAddSsQueriesPlaintextOpen = r2.getInt(KEY_ADD_SS_QUERIES_PLAINTEXT_OPEN, 1);
        this.mAddDeviceFingerprintOpen = r2.getInt(KEY_ADD_DEVICE_FINGERPRINT_OPEN, 1);
        this.mDynamicAdjustThreadPoolSizeOpen = r2.getInt(KEY_DYNAMIC_ADJUST_THREADPOOL_SIZE_OPEN, 1);
        if (this.mChromiumBootFailures >= 0) goto L14;
        this.mChromiumBootFailures = r2.getInt(KEY_CHROMIUM_BOOT_FAILURES, 0);
    L14:
        if (this.mDynamicAdjustThreadPoolSizeOpen <= 0) goto L16;
        boolean r3 = true;
    L17:
        RequestQueue.setDynamicAdjustThreadPoolSizeOpen(r3);
        this.mImageTtnetEnabled = r2.getInt(KEY_IMAGE_TTNET_ENABLED, 1);
        this.mSampleBandWidthEnabled = r2.getInt(KEY_SAMPLE_BAND_WIDTH_ENABLED, 1);
        this.mCdnSampleBandWidthEnabled = r2.getInt(KEY_CDN_SAMPLE_BAND_WIDTH_ENABLED, 1);
        sUseHttpDns = r2.getInt(KEY_USE_HTTP_DNS, -1);
        sUseHttpDnsRefetchOnExpire = r2.getInt(KEY_USE_HTTP_DNS_REFETCH_ON_EXPIRE, -1);
        StreamParser.onConfigUpdate(r2);
        SsCronetHttpClient.tryUpdateBodyBufferSizeConfig(null, r2);
        CdnCacheVerifyUtils.onLocalConfigUpdate(r2);
        if (this.mAddSsQueriesOpen <= 0) goto L20;
    L21:
        SsInterceptor.EnableEncryptQuery(true);
    L22:
        mFrontierUrls = r2.getString("frontier_urls", "");
        this.mCronetSoPath = r2.getString(KEY_CRONET_SO_PATH, "");
        String r4 = r2.getString(KEY_API_HTTP_HOST_LIST, "");
        if (StringUtils.isEmpty(r4) == true) goto L30;
        String[] r5 = r4.split(",");
        int r6 = r5.length;
        int r7 = 0;
    L25:
        if (r7 >= r6) goto L30;
        String r8 = r5[r7];
        if (StringUtils.isEmpty(r8) == true) goto L29;
        this.mApiHttpHostList.add(r8.trim());
    L29:
        r7 = r7 + 1;
    L30:
        CronetSsCallConfig.inst().onNetConfigChanged(r2.getString(KEY_CONCURRENT_REQUEST_CONFIG, ""));
        String r9 = r2.getString(KEY_COMMON_PARAMS_CONFIG, "");
        CommonParamConfig r10 = CommonParamManager.inst().getCommonParamConfig();
        if (r10 == null) goto L33;
        r10.onNetConfigChanged(r9);
    L33:
        QueryFilterEngine.inst().parseL0ParamsString(r2.getString(QueryFilterEngine.KEY_L0_PARAMS, ""));
        int r11 = r2.getInt(QueryFilterEngine.KEY_QUERY_FILTER_ENABLED, Integer.MIN_VALUE);
        String r12 = r2.getString(QueryFilterEngine.KEY_QUERY_FILTER_CONFIG, "");
        if (r11 == Integer.MIN_VALUE) goto L40;
        QueryFilterEngine r13 = QueryFilterEngine.inst();
        if (r11 <= 0) goto L38;
        boolean r14 = true;
    L39:
        r13.enableQueryFilterEngine(r14);
        QueryFilterEngine.inst().onNetConfigChanged(r12);
        goto L40
    L38:
        r14 = false;
    L40:
        String r15 = r2.getString(KEY_SHARE_COOKIE_HOST_LIST, "");
        TtnetUtil.parseShareCookieHostList(r15, this.mShareCookieHostList);
        String r16 = TTNetInit.getTTNetDepend().getShareCookieMainDomain();
        if (StringUtils.isEmpty(r16) == true) goto L46;
        if (TtnetUtil.inCookieHostList(r16, this.mShareCookieHostList) == true) goto L46;
        this.mShareCookieHostList.add(r16);
    L46:
        if (r2.getInt(KEY_PRIVATE_PROTOCOL_ENABLED, 1) < 1) goto L48;
        boolean r17 = true;
    L49:
        NetworkParams.setPrivateProtocolEnabled(r17);
        int r18 = r2.getInt(KEY_DESTROY_DELTA_MILLIS, 100);
        if (r18 < 0) goto L53;
        NetworkParams.setDestroyDeltaMillis(r18);
    L53:
        if (r2.getInt(KEY_DISABLE_ROTATION_HOST_RETRY, -1) >= 1) goto L56;
        r1 = false;
    L56:
        NetworkParams.setDisableRotationHostRetryByTnc(r1);
        this.mTncUpdateInterval.set(r2.getInt(KEY_TNC_UPDATE_INTERVAL, 10800));
        String r19 = r2.getString(KEY_TNC_HOST_ARRAYS, "");
        if (TextUtils.isEmpty(r19) == true) goto L59;
        String[] r20 = r19.split(",");
        this.mTncHostArrays.clear();
        this.mTncHostArrays.addAll(Arrays.asList(r20));
    L59:
        this.mTncSummary = r2.getString(KEY_TNC_SUMMARY, "");
        if (TNCManager.getInstance().getTNCConfigHandler() == null) goto L62;
        TNCManager.getInstance().getTNCConfigHandler().loadLocalConfig(this.mLastRefreshTime.get());
    L62:
        int r21 = r2.getInt(KEY_DISABLE_FRAMED_TRANSPORT, 0);
        if (r21 <= 0) goto L69;
        OkHttp3Builder.disableFramedTransport(r21);     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        th.printStackTrace();
    L69:
        if (this.mIsMainProcess == false) goto L89;
        final LinkedHashMap r22 = new LinkedHashMap();     // Catch: Throwable -> L75
        if (StringUtils.isEmpty(mFrontierUrls) == true) goto L73;
        r22.put("frontier_urls", mFrontierUrls);     // Catch: Throwable -> L75
    L73:
        r22.put(KEY_HTTP_DNS_ENABLED, Integer.valueOf(this.mHttpDnsEnabled));     // Catch: Throwable -> L75
        r22.put(KEY_ADD_SS_QUERIES_OPEN, Integer.valueOf(this.mAddSsQueriesOpen));     // Catch: Throwable -> L75
        r22.put(KEY_ADD_SS_QUERIES_HEADER_OPEN, Integer.valueOf(this.mAddSsQueriesHeaderOpen));     // Catch: Throwable -> L75
        r22.put(KEY_ADD_SS_QUERIES_PLAINTEXT_OPEN, Integer.valueOf(this.mAddSsQueriesPlaintextOpen));     // Catch: Throwable -> L75
        r22.put(KEY_CHROMIUM_BOOT_FAILURES, Integer.valueOf(this.mChromiumBootFailures));     // Catch: Throwable -> L75
        r22.put(KEY_SHARE_COOKIE_HOST_LIST, r15);     // Catch: Throwable -> L75
        r22.put(KEY_DISABLE_FRAMED_TRANSPORT, Integer.valueOf(r21));     // Catch: Throwable -> L75
        final String r23 = "SaveMapToProvider-Thread";
        new AnonymousClass3(this, r23, r22).start();     // Catch: Throwable -> L75
        return;
    L75:
        th = move-exception;
        th.printStackTrace();
        return;
    L89:
        return;
    L48:
        r17 = false;
        goto L49
    L20:
        if (this.mAddSsQueriesHeaderOpen <= 0) goto L22;
    L16:
        r3 = false;
        goto L17
    }

    @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.ApiRequestInterceptor
    @Deprecated
    public List<InetAddress> resolveInetAddresses(String r2) {
        if (StringUtils.isEmpty(r2) == false) goto L5;
        return null;
    L5:
        if (this.mIsMainProcess == true) goto L8;
        return null;
    L8:
        return resolveInetAddressesFromHttpDns(r2);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.ConnectionQualitySamplerHook
    public boolean shouldSampling(String r3) {
        if (StringUtils.isEmpty(r3) == false) goto L6;
        return false;
    L6:
        if (this.mSampleBandWidthEnabled > 0) goto L21;
        return false;
    L21:
        URI r2 = URIUtils.safeCreateUri(r3);     // Catch: Throwable -> L18
        if (r2 != null) goto L11;
        return false;
    L11:
        String r4 = r2.getHost();     // Catch: Throwable -> L18
        if (StringUtils.isEmpty(r4) == false) goto L14;
        return false;
    L14:
        if (r4.endsWith(AppConsts.getHostSuffix()) == false) goto L20;
        return true;
    L20:
        return false;
    L18:
        th = move-exception;
        th.printStackTrace();
        goto L20
    }

    @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.CdnConnectionQualitySamplerHook
    public boolean cdnShouldSampling(String r3) {
        if (StringUtils.isEmpty(r3) == false) goto L6;
        return false;
    L6:
        if (this.mCdnSampleBandWidthEnabled > 0) goto L21;
        return false;
    L21:
        URI r2 = URIUtils.safeCreateUri(r3);     // Catch: Throwable -> L18
        if (r2 != null) goto L11;
        return false;
    L11:
        String r4 = r2.getHost();     // Catch: Throwable -> L18
        if (StringUtils.isEmpty(r4) == false) goto L14;
        return false;
    L14:
        if (r4.endsWith(AppConsts.getCdnHostSuffix()) == false) goto L20;
        return true;
    L20:
        return false;
    L18:
        th = move-exception;
        th.printStackTrace();
        goto L20
    }

    public String filterUrl(String r3) {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L7;
        return filterUrlOnUIThread(r3);
    L7:
        return filterUrl(r3, null);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.ApiRequestInterceptor
    @Deprecated
    public String filterUrl(String r1, BaseRequestContext r2) {
        if (StringUtils.isEmpty(r1) == false) goto L14;
        return r1;
    L14:
    L10:
        th = move-exception;
        th.printStackTrace();
    L12:
        return r1;
    L6:
        if (this.mIsMainProcess == false) goto L8;
        tryLoadLocalConfig();     // Catch: Throwable -> L10
    L13:
        goto L12
    L8:
        tryLoadDomainConfig4OtherProcess();     // Catch: Throwable -> L10
        goto L13
    }

    @Deprecated
    public String filterUrlOnUIThread(String r1) {
        if (StringUtils.isEmpty(r1) == false) goto L10;
        return r1;
    L10:
        return TNCManager.getInstance().handleHostMapping(r1);
    L7:
        th = move-exception;
        th.printStackTrace();
        return r1;
    }

    public boolean isNeedHttpDnsRefetchOnExpire() {
        if (sUseHttpDnsRefetchOnExpire <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public synchronized int getCronetVersion() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mLocalLoaded == false) goto L8;
        int r0 = this.mCronetVersion;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r0;
    L8:
        int r1 = this.mContext.getSharedPreferences(SP_SS_APP_CONFIG, 0).getInt(KEY_CRONET_VERSION, 0);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.ApiRequestInterceptor
    public boolean isOkHttpOpen() {
        if (this.mOkHttpOpen <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.ApiRequestInterceptor
    public boolean isOkHttp3Open() {
        if (Logger.debug() == false) goto L6;
        return true;
    L6:
        if (this.mOkHttp3Open > 0) goto L10;
        return false;
    L10:
        return true;
    }

    public void setDisableFallbackReasonBoot(boolean r1) {
        sDisableFallbackReasonBoot = r1;
    }

    public void setEnableFallbackReasonBootFix(boolean r1) {
        sEnableFallbackReasonBootFix = r1;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.ApiRequestInterceptor
    public void monitorApiHttp(String r3, String r4, boolean r5) throws IOException {
        if (this.mApiHttpHostList.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<String> r2 = this.mApiHttpHostList.iterator();
    L7:
        if (r2.hasNext() == false) goto L29;
        String r0 = r2.next();
        if (StringUtils.isEmpty(r0) == true) goto L7;
        if (r3.endsWith(r0) == false) goto L7;
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L20
        r6.put("url", r3 + r4);     // Catch: Throwable -> L20
        r6.put("replace", r5);     // Catch: Throwable -> L20
        TTNetInit.monitorLogSend("api_http", r6);     // Catch: Throwable -> L20
    L14:
        if (TTNetInit.apiHttpInterceptEnabled() == false) goto L19;
        if (r5 == false) goto L18;
        return;
    L18:
        throw new NotAllowApiHttpException("Api http request is not allowed to be executed");
    L19:
        return;
    }

    public void setForceNotUseCronet(boolean r1) {
        sForceNotUseCronet = r1;
    }

    static {
        ArrayList<String> r0 = new ArrayList();
        sBlockModelList = r0;
        sCronetUnsupportedModel = false;
        r0.add("MI PAD 2");
        sBlockModelList.add("YT3-X90L");
        sBlockModelList.add("YT3-X90F");
        sBlockModelList.add("GT-810");
        sForceNotUseCronetHttpDns = false;
        sTestSsQueries = false;
        sTestDeviceFingerPrint = false;
    }

    public void preloadCronetBootFailureInfo() {
        SharedPreferences r0 = this.mContext.getSharedPreferences(SP_SS_APP_CONFIG, 0);
        if (this.mChromiumBootFailures >= 0) goto L6;
        this.mChromiumBootFailures = r0.getInt(KEY_CHROMIUM_BOOT_FAILURES, 0);
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d(TAG, "mChromiumBootFailures is " + this.mChromiumBootFailures);
    L8:
        this.mChromiumBootFailuresTimestamp = r0.getLong(KEY_CHROMIUM_BOOT_FAILURES_TIMESTAMP, 0);
        if (this.mChromiumBootFailures > 5) goto L11;
        return;
    L11:
        if ((System.currentTimeMillis() - this.mChromiumBootFailuresTimestamp) <= TimeUnit.HOURS.toMillis(1)) goto L15;
        this.mChromiumBootFailures = 5;
        return;
    }

    @Override // com.bytedance.ttnet.HttpClient.IHttpClientConfig
    public boolean isChromiumOpen() {
        if (sEnableFallbackReasonBootFix == false) goto L8;
        if (this.mPreloadBootFailureInfo.compareAndSet(false, true) == false) goto L8;
        preloadCronetBootFailureInfo();
    L8:
        if (sForceNotUseCronet == false) goto L12;
        SsOkHttp3Client.setFallbackReason(0);
        return false;
    L12:
        if (sCronetUnsupportedModel == false) goto L16;
        SsOkHttp3Client.setFallbackReason(8);
        return false;
    L16:
        if (isCronetUnsupportedABI() == false) goto L19;
        return false;
    L19:
        if (sDisableFallbackReasonBoot == true) goto L25;
        if (this.mChromiumBootFailures <= 5) goto L25;
        SsOkHttp3Client.setFallbackReason(3);
        Logger.e(TAG, "After five consecutive crashes of cronet, you must reinstall app to enable cronet, or wait until several hours");
        return false;
    L25:
        if (TTNetInit.getTTNetDepend().isCronetPluginInstalled() == true) goto L28;
        SsOkHttp3Client.setFallbackReason(6);
        return false;
    L28:
        return true;
    }

    private static boolean isCronetUnsupportedABIv2() {
        String[] r0 = Build.SUPPORTED_ABIS;
        int r1 = r0.length;
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L9;
        if (r0[r3].contains("arm") == true) goto L7;
        r3 = r3 + 1;
        goto L4
    L7:
        boolean r2 = true;
    L11:
        if (r2 == false) goto L16;
        if (SsOkHttp3Client.getFallbackReason() != 2) goto L21;
        SsOkHttp3Client.setFallbackReason(-1);
    L21:
        if (Logger.debug() == false) goto L24;
        Logger.d(TAG, "use isCronetUnsupportedABIv2, result is " + (!r2));
    L24:
        return !r2;
    L16:
        if (DebugMode.x86Support() == false) goto L19;
        Logger.d(TAG, "x86 support");
        return false;
    L19:
        SsOkHttp3Client.setFallbackReason(2);
        goto L21
    L9:
        r2 = false;
        goto L11
    }

    public static boolean isCronetUnsupportedABI() {
        if (ExperimentalSwitches.isEnableWithContainArmabi() == false) goto L25;
        return isCronetUnsupportedABIv2();
    L25:
        String r2 = Build.SUPPORTED_ABIS[0];     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(r2) == false) goto L11;
        return false;
    L11:
        if ("x86".equalsIgnoreCase(r2) == true) goto L16;
        if ("x86_64".equalsIgnoreCase(r2) == true) goto L16;
    L24:
        return false;
    L16:
        if (DebugMode.x86Support() == false) goto L19;
        Logger.d(TAG, "x86 support");     // Catch: Throwable -> L22
        return false;
    L19:
        Logger.w(TAG, "Cronet unsupported CPU arch: " + r2);     // Catch: Throwable -> L22
        SsOkHttp3Client.setFallbackReason(2);     // Catch: Throwable -> L22
        return true;
    L22:
        th = move-exception;
        th.printStackTrace();
        goto L24
    }

    public void setForceNotUseCronetHttpDns(boolean r1) {
        sForceNotUseCronetHttpDns = r1;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient.ICronetHttpDnsConfig
    public boolean isCronetHttpDnsOpen() {
        if (sForceNotUseCronetHttpDns == false) goto L6;
        return false;
    L6:
        if (this.mHttpDnsEnabled <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient.ICronetBootFailureChecker
    public boolean isCronetBootFailureExpected() {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "isCronetBootFailureExpected...");
    L5:
        boolean r3 = false;
        SharedPreferences r0 = this.mContext.getSharedPreferences(SP_SS_APP_CONFIG, 0);
        if (sEnableFallbackReasonBootFix == true) goto L16;
        if (this.mChromiumBootFailures >= 0) goto L10;
        this.mChromiumBootFailures = r0.getInt(KEY_CHROMIUM_BOOT_FAILURES, 0);
    L10:
        this.mChromiumBootFailuresTimestamp = r0.getLong(KEY_CHROMIUM_BOOT_FAILURES_TIMESTAMP, 0);
        if (this.mChromiumBootFailures <= 5) goto L16;
        if ((System.currentTimeMillis() - this.mChromiumBootFailuresTimestamp) <= TimeUnit.HOURS.toMillis(1)) goto L16;
        this.mChromiumBootFailures = 5;
    L16:
        if (isChromiumOpen() == false) goto L24;
        SharedPreferences.Editor r1 = r0.edit();
        r3 = true;
        r1.putInt(KEY_CHROMIUM_BOOT_FAILURES, this.mChromiumBootFailures + 1);
        r1.putLong(KEY_CHROMIUM_BOOT_FAILURES_TIMESTAMP, System.currentTimeMillis());
        if (Logger.debug() == false) goto L20;
        Logger.d(TAG, "KEY_CHROMIUM_BOOT_FAILURES inc...");
    L20:
        SharedPrefsEditorCompat.apply(r1);
        final LinkedHashMap r2 = new LinkedHashMap();
        r2.put(KEY_CHROMIUM_BOOT_FAILURES, Integer.valueOf(this.mChromiumBootFailures + 1));
        if (TTNetInit.getCronetProvider().getOptInit() == false) goto L23;
        final String r4 = "SaveMapToProvider-Thread";
        new AnonymousClass4(this, r4, r2).start();
        goto L24
    L23:
        TTNetInit.getTTNetDepend().saveMapToProvider(this.mContext, r2);
    L24:
        return r3;
    }

    public boolean isDetectOpen() {
        if (this.mDetectOpen <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static void setTestQuery(boolean r0) {
        sTestSsQueries = r0;
    }

    @Override // com.bytedance.frameworks.core.encrypt.RequestEncryptUtils.IEncryptConfig
    public boolean isSsQueriesOpen() {
        if (sTestSsQueries == false) goto L6;
        return true;
    L6:
        if (this.mAddSsQueriesOpen > 0) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.bytedance.frameworks.core.encrypt.RequestEncryptUtils.IEncryptConfig
    public boolean isSsQueriesHeaderOpen() {
        if (sTestSsQueries == false) goto L6;
        return false;
    L6:
        if (this.mAddSsQueriesHeaderOpen <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.frameworks.core.encrypt.RequestEncryptUtils.IEncryptConfig
    public boolean isSsQueriesPlaintextOpen() {
        if (sTestSsQueries == false) goto L6;
        return true;
    L6:
        if (this.mAddSsQueriesPlaintextOpen > 0) goto L10;
        return false;
    L10:
        return true;
    }

    public static void setTestFingerPrint(boolean r0) {
        sTestDeviceFingerPrint = r0;
    }

    public boolean isDeviceFingerPrintOpen() {
        if (sTestDeviceFingerPrint == false) goto L6;
        return true;
    L6:
        if (this.mAddDeviceFingerprintOpen > 0) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean isImageTtnetEnabled() {
        if (this.mImageTtnetEnabled <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isDetectNativePage() {
        if (this.mDetectNativePage <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isCollectRecentPageInfoEnable() {
        if (this.mCollectRecentPageInfoEnable <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    void updateConfig(TNCManager.TNCUpdateSource r5, boolean r6) {
        if (Logger.debug() == false) goto L6;
        Logger.d("TNCManager", "doRefresh, actual request");
    L6:
        if (NetworkUtils.isNetworkAvailable(this.mContext) == true) goto L8;
        return;
    L8:
        tryLoadLocalConfig();
        if (isChromiumOpen() == true) goto L11;
    L14:
        if (r6 == true) goto L16;
    L22:
        int r7 = 101;
        if (TNCManager.getInstance().getDomainInternal(this.mContext, true, r5, this.mTncSummary) == true) goto L29;
        Logger.d(TAG, "tnc reqeust through okhttp failed, fallback to HttpUrlConnection");
        if (TNCManager.getInstance().getDomainInternal(this.mContext, false, TNCManager.TNCUpdateSource.PORTRETRY, this.mTncSummary) == true) goto L29;
        r7 = 102;
    L29:
        this.mHandler.sendEmptyMessage(r7);
        this.mHandler.removeMessages(103);
        this.mHandler.sendEmptyMessageDelayed(103, ((long) this.mTncUpdateInterval.get()) * 1000);
        return;
    L16:
        if (isDidEmpty() == false) goto L22;
        if (Logger.debug() == false) goto L20;
        Logger.d("TNCManager", "did is empty, delay 5s send tnc again");
    L20:
        this.mHandler.sendEmptyMessageDelayed(104, 5000);
        this.mConfigUpdating.set(false);
        return;
    L11:
        if (r5 == TNCManager.TNCUpdateSource.TTCRONETFAILED) goto L14;
        this.mConfigUpdating.set(false);
    }

    private boolean isDidEmpty() {
        if (getConfigServers() != null) goto L5;
    L26:
        return true;
    L5:
        if (getConfigServers().length < 1) goto L26;
        String r5 = getConfigServers()[0];
        if (TextUtils.isEmpty(r5) == false) goto L10;
        return true;
    L10:
        String r6 = "https://" + r5 + "/get_domains/v5/";
        String r3 = NetworkParams.addCommonParams(r6, true);
        if (r6.equals(r3) == false) goto L13;
        return true;
    L13:
        LinkedHashMap r7 = new LinkedHashMap();
        UrlUtils.parseUrlWithValueList(r3, r7);     // Catch: Exception -> L27
        if (r7.containsKey("device_id") == true) goto L17;
        return true;
    L17:
        List r8 = (List) r7.get("device_id");     // Catch: Exception -> L27
        if (r8 != null) goto L20;
        return true;
    L20:
        Iterator r9 = r8.iterator();     // Catch: Exception -> L27
    L22:
        if (r9.hasNext() == false) goto L26;
        if (((String) r9.next()).equals("0") == true) goto L22;
        return false;
    }

    public String[] getConfigServers() {
        String[] r1 = TTNetInit.getTTNetDepend().getConfigServers();
        if (r1 == null) goto L7;
        if (r1.length <= 0) goto L7;
        return r1;
    L7:
        return new String[0];
    }

    public void handleConfigUpdate(String r8, Object r9) {
        if (JsonOptConfig.isValid(r9) == true) goto L22;
        return;
    L22:
        boolean r10 = handleResponse(r9, TNCManager.TNCUpdateSource.TTCRONET, System.currentTimeMillis(), false);     // Catch: Exception -> L7
    L9:
        if (r10 == false) goto L11;
        int r11 = 101;
    L20:
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L14
        r0.put("from", "cronet");     // Catch: Throwable -> L14
        TTNetInit.getTTNetDepend().onAppConfigUpdated(this.mContext, r0);     // Catch: Throwable -> L14
    L24:
        handleConfigUpdate(r8);     // Catch: Throwable -> L19
    L17:
        this.mHandler.sendEmptyMessage(r11);
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        goto L24
    L11:
        r11 = 102;
    L7:
        e = move-exception;
        e.printStackTrace();
        r10 = false;
        goto L9
    }

    public void resetCronetBootSucceed() {
    L11:
        th = move-exception;
        th.printStackTrace();
        return;
    L4:
        if (Logger.debug() == false) goto L7;
        Logger.d(TAG, "KEY_CHROMIUM_BOOT_FAILURES set 0");     // Catch: Throwable -> L11
    L7:
        if (this.mChromiumBootFailures != 0) goto L9;
        return;
    L9:
        this.mChromiumBootFailures = 0;     // Catch: Throwable -> L11
        SharedPreferences.Editor r2 = this.mContext.getSharedPreferences(SP_SS_APP_CONFIG, 0).edit();     // Catch: Throwable -> L11
        r2.putInt(KEY_CHROMIUM_BOOT_FAILURES, 0);     // Catch: Throwable -> L11
        SharedPrefsEditorCompat.apply(r2);     // Catch: Throwable -> L11
        LinkedHashMap r3 = new LinkedHashMap();     // Catch: Throwable -> L11
        r3.put(KEY_CHROMIUM_BOOT_FAILURES, 0);     // Catch: Throwable -> L11
        TTNetInit.getTTNetDepend().saveMapToProvider(this.mContext, r3);     // Catch: Throwable -> L11
    }

    private void reportShareCookieLog(JSONObject r3, String r4) {
        if (r3 != null) goto L8;
        return;
    L8:
        r3.put("return", r4);     // Catch: JSONException -> L7
        r3.put("CurrentShareCookieHostList", this.mShareCookieHostList.toString());     // Catch: JSONException -> L7
    L5:
        TTNetInit.getTTNetDepend().mobOnEvent(TTNetInit.getTTNetDepend().getContext(), "handleResponse", "shareCookieHostList", r3);
    }

    public boolean handleResponse(Object r39, TNCManager.TNCUpdateSource r40, long r41, boolean r43) throws Exception {
        JSONObject r9 = new JSONObject();
        if ((r39 instanceof String) == false) goto L10;
        String r0 = (String) r39;
        if (StringUtils.isEmpty(r0) == false) goto L8;
        reportShareCookieLog(r9, "empty response.");
        return false;
    L8:
        JSONObject r5 = new JSONObject(r0);
    L16:
        if (r5 != null) goto L19;
        reportShareCookieLog(r9, "object is null.");
        return false;
    L19:
        this.mTncSummary = r5.optString("summary");
        JSONObject r11 = r5.getJSONObject("data");
        sUseHttpDns = r11.optInt(KEY_USE_HTTP_DNS, -1);
        sUseHttpDnsRefetchOnExpire = r11.optInt(KEY_COLLECT_RECENT_PAGE_INFO_ENABLE, -1);
        int r6 = r11.optInt(KEY_OK_HTTP_OPEN, 0);
        int r7 = r11.optInt(KEY_OK_HTTP3_OPEN, 0);
        int r8 = r11.optInt(KEY_CRONET_VERSION, 0);
        int r10 = r11.optInt(KEY_HTTP_DNS_ENABLED, 0);
        int r12 = r11.optInt(KEY_DETECT_OPEN, 0);
        int r13 = r11.optInt(KEY_DETECT_NATIVE_PAGE, 1);
        int r14 = r11.optInt(KEY_COLLECT_RECENT_PAGE_INFO_ENABLE, 1);
        int r4 = r11.optInt(KEY_ADD_SS_QUERIES_OPEN, 0);
        int r15 = r11.optInt(KEY_ADD_SS_QUERIES_HEADER_OPEN, 0);
        int r2 = r11.optInt(KEY_ADD_SS_QUERIES_PLAINTEXT_OPEN, 1);
        int r16 = r11.optInt(KEY_ADD_DEVICE_FINGERPRINT_OPEN, 1);
        int r3 = r11.optInt(KEY_IMAGE_TTNET_ENABLED, 1);
        int r1 = r11.optInt(KEY_SAMPLE_BAND_WIDTH_ENABLED, 1);
        int r17 = r11.optInt(KEY_CDN_SAMPLE_BAND_WIDTH_ENABLED, 1);
        int r18 = r11.optInt(KEY_DYNAMIC_ADJUST_THREADPOOL_SIZE_OPEN, 1);
        int r19 = r11.optInt(KEY_HTTP_SHOW_HIJACK, 1);
        int r20 = r11.optInt(KEY_HTTP_VERIFY_SIGN, 1);
        int r21 = r11.optInt(KEY_TNC_UPDATE_INTERVAL, -1);
        if (r21 <= 0) goto L22;
        this.mTncUpdateInterval.set(r21);
    L22:
        int r22 = r11.optInt(KEY_PRIVATE_PROTOCOL_ENABLED, 1);
        if (r22 < 1) goto L25;
        boolean r23 = true;
    L26:
        NetworkParams.setPrivateProtocolEnabled(r23);
        int r110 = r11.optInt(KEY_DESTROY_DELTA_MILLIS, 100);
        if (r110 < 0) goto L29;
        NetworkParams.setDestroyDeltaMillis(r110);
    L29:
        int r111 = r11.optInt(KEY_DISABLE_ROTATION_HOST_RETRY, -1);
        if (r111 < 1) goto L32;
        boolean r24 = true;
    L33:
        NetworkParams.setDisableRotationHostRetryByTnc(r24);
        JSONArray r25 = r11.optJSONArray(KEY_TNC_HOST_ARRAYS);
        if (r25 == null) goto L44;
        this.mTncHostArrays.clear();
        int r26 = 0;
    L37:
        if (r26 >= r25.length()) goto L43;
        if (TextUtils.isEmpty(r25.optString(r26)) == true) goto L42;
        this.mTncHostArrays.add(r25.optString(r26));
    L42:
        r26 = r26 + 1;
        r16 = r16;
        goto L37
    L43:
        int r28 = r16;
    L45:
        int r27 = r11.optInt(KEY_CRASH_LIMIT_TIMES, 0);
        int r29 = r11.optInt(KEY_CRASH_DETECT_INTERVAL_MS, 5000);
        monitor-enter(this);
        this.mOkHttpOpen = r6;     // Catch: Throwable -> L153
        this.mOkHttp3Open = r7;     // Catch: Throwable -> L153
        this.mCronetVersion = r8;     // Catch: Throwable -> L153
        this.mHttpDnsEnabled = r10;     // Catch: Throwable -> L153
        this.mDetectOpen = r12;     // Catch: Throwable -> L153
        this.mDetectNativePage = r13;     // Catch: Throwable -> L153
        this.mCollectRecentPageInfoEnable = r14;     // Catch: Throwable -> L153
        this.mAddSsQueriesOpen = r4;     // Catch: Throwable -> L153
        this.mAddSsQueriesHeaderOpen = r15;     // Catch: Throwable -> L153
        this.mAddSsQueriesPlaintextOpen = r2;     // Catch: Throwable -> L153
        int r112 = r28;
        this.mAddDeviceFingerprintOpen = r112;     // Catch: Throwable -> L153
        this.mDynamicAdjustThreadPoolSizeOpen = r18;     // Catch: Throwable -> L153
        this.mImageTtnetEnabled = r3;     // Catch: Throwable -> L153
        this.mSampleBandWidthEnabled = r1;     // Catch: Throwable -> L153
        this.mCdnSampleBandWidthEnabled = r17;     // Catch: Throwable -> L153
        monitor-exit(this);     // Catch: Throwable -> L153
        if (r18 <= 0) goto L51;
        boolean r30 = true;
    L52:
        RequestQueue.setDynamicAdjustThreadPoolSizeOpen(r30);
        if (r11.optInt("enable_req_ticket", 1) <= 0) goto L55;
        boolean r31 = true;
    L56:
        RequestTicketUtil.setEnable(r31);
        CdnCacheVerifyUtils.CdnCacheVerifyConfig r32 = CdnCacheVerifyUtils.onServerConfigUpdate(r11);
        if (this.mAddSsQueriesOpen <= 0) goto L59;
    L62:
        boolean r113 = true;
        SsInterceptor.EnableEncryptQuery(true);
    L63:
        StreamParser.onServerConfigUpdate(r11);
        SsCronetHttpClient.tryUpdateBodyBufferSizeConfig(r11, null);
        String r33 = r11.optString("frontier_urls", "");
        String r34 = r11.optString(KEY_SHARE_COOKIE_HOST_LIST, "");
        TTNetInit.getTTNetDepend().onShareCookieConfigUpdated(r34);
        String r35 = r11.optString(KEY_API_HTTP_HOST_LIST, "");
        String r36 = r11.optString(KEY_CONCURRENT_REQUEST_CONFIG, "");
        CronetSsCallConfig.inst().onNetConfigChanged(r36);
        String r37 = r11.optString(KEY_COMMON_PARAMS_CONFIG, "");
        CommonParamConfig r38 = CommonParamManager.inst().getCommonParamConfig();
        if (r38 == null) goto L66;
        r38.onNetConfigChanged(r37);
    L66:
        String r42 = r11.optString(QueryFilterEngine.KEY_L0_PARAMS, "");
        QueryFilterEngine.inst().parseL0ParamsString(r42);
        int r114 = r11.optInt(QueryFilterEngine.KEY_QUERY_FILTER_ENABLED, Integer.MIN_VALUE);
        String r44 = JsonOptConfig.optString(r39, r11, new String[]{"data", QueryFilterEngine.KEY_QUERY_FILTER_CONFIG});
        if (r114 == Integer.MIN_VALUE) goto L73;
        QueryFilterEngine r45 = QueryFilterEngine.inst();
        if (r114 <= 0) goto L71;
        boolean r46 = r113;
    L72:
        r45.enableQueryFilterEngine(r46);
        QueryFilterEngine.inst().onNetConfigChanged(r44);
        goto L73
    L71:
        r46 = false;
    L73:
        this.mEncryptSwitch = r11.optInt("disable_encrypt_switch", 0);
        this.mCronetSoPath = r11.optString(KEY_CRONET_SO_PATH, "");
        if (this.mEncryptSwitch != 2) goto L76;
        int r115 = 0;
        SharedPreferences.Editor r47 = this.mContext.getSharedPreferences("app_log_encrypt_switch_count", 0).edit();
        r47.putInt("app_log_encrypt_faild_count", 0);
        SharedPrefsEditorCompat.apply(r47);
    L77:
        int r48 = r11.optInt(KEY_DISABLE_FRAMED_TRANSPORT, r115);
        if (r48 > 0) goto L160;
    L83:
        monitor-enter(this);
        SharedPreferences r49 = this.mContext.getSharedPreferences(SP_SS_APP_CONFIG, 0);     // Catch: Throwable -> L150
        String r116 = r49.getString(KEY_SHARE_COOKIE_HOST_LIST, "");     // Catch: Throwable -> L150
        SharedPreferences.Editor r50 = r49.edit();     // Catch: Throwable -> L150
        r50.putString(CdnCacheVerifyUtils.KEY_TTNET_RESPONSE_VERIFY, r32.verifyRegexsStr);     // Catch: Throwable -> L150
        r50.putInt(CdnCacheVerifyUtils.KEY_TTNET_RESPONSE_VERIFY_ENABLED, r32.ttnetResponseVerifyEnabled);     // Catch: Throwable -> L150
        StreamParser.onSaveConfigToSP(r50);     // Catch: Throwable -> L150
        SsCronetHttpClient.onSaveConfigToSP(r50);     // Catch: Throwable -> L150
        r50.putInt(KEY_OK_HTTP_OPEN, r6);     // Catch: Throwable -> L150
        r50.putInt(KEY_OK_HTTP3_OPEN, r7);     // Catch: Throwable -> L150
        r50.putInt(KEY_CRONET_VERSION, r8);     // Catch: Throwable -> L150
        r50.putInt(KEY_HTTP_DNS_ENABLED, r10);     // Catch: Throwable -> L150
        r50.putInt(KEY_DETECT_OPEN, r12);     // Catch: Throwable -> L150
        r50.putInt(KEY_DETECT_NATIVE_PAGE, r13);     // Catch: Throwable -> L150
        r50.putInt(KEY_COLLECT_RECENT_PAGE_INFO_ENABLE, r14);     // Catch: Throwable -> L150
        r50.putInt(KEY_ADD_SS_QUERIES_OPEN, r4);     // Catch: Throwable -> L150
        r50.putInt(KEY_ADD_SS_QUERIES_HEADER_OPEN, r15);     // Catch: Throwable -> L150
        r50.putInt(KEY_ADD_SS_QUERIES_PLAINTEXT_OPEN, r2);     // Catch: Throwable -> L150
        r50.putInt(KEY_ADD_DEVICE_FINGERPRINT_OPEN, r112);     // Catch: Throwable -> L150
        r50.putInt(KEY_DYNAMIC_ADJUST_THREADPOOL_SIZE_OPEN, r18);     // Catch: Throwable -> L150
        r50.putInt(KEY_IMAGE_TTNET_ENABLED, r3);     // Catch: Throwable -> L150
        r50.putInt(KEY_USE_HTTP_DNS, sUseHttpDns);     // Catch: Throwable -> L150
        r50.putInt(KEY_USE_HTTP_DNS_REFETCH_ON_EXPIRE, sUseHttpDnsRefetchOnExpire);     // Catch: Throwable -> L150
        r50.putInt(KEY_HTTP_SHOW_HIJACK, r19);     // Catch: Throwable -> L150
        r50.putInt(KEY_HTTP_VERIFY_SIGN, r20);     // Catch: Throwable -> L150
        r50.putInt(KEY_CRASH_LIMIT_TIMES, r27);     // Catch: Throwable -> L150
        r50.putInt(KEY_CRASH_DETECT_INTERVAL_MS, r29);     // Catch: Throwable -> L150
        r50.putString("frontier_urls", r33);     // Catch: Throwable -> L150
        r50.putString(KEY_CRONET_SO_PATH, this.mCronetSoPath);     // Catch: Throwable -> L150
        r50.putString(KEY_SHARE_COOKIE_HOST_LIST, r34);     // Catch: Throwable -> L150
        r9.put("oldShareCookieHosts", r116);     // Catch: Throwable -> L150
        r9.put("newShareCookieHosts", r34);     // Catch: Throwable -> L150
        if (TextUtils.isEmpty(r34) == true) goto L87;
        this.mShareCookieHostList.clear();     // Catch: Throwable -> L150
        TtnetUtil.parseShareCookieHostList(r34, this.mShareCookieHostList);     // Catch: Throwable -> L150
    L87:
        String r51 = TTNetInit.getTTNetDepend().getShareCookieMainDomain();     // Catch: Throwable -> L150
        if (StringUtils.isEmpty(r51) == false) goto L90;
    L92:
        r50.putString(KEY_API_HTTP_HOST_LIST, r35);     // Catch: Throwable -> L150
        r50.putString(KEY_CONCURRENT_REQUEST_CONFIG, r36);     // Catch: Throwable -> L150
        r50.putString(KEY_COMMON_PARAMS_CONFIG, r37);     // Catch: Throwable -> L150
        r50.putString(QueryFilterEngine.KEY_QUERY_FILTER_CONFIG, r44);     // Catch: Throwable -> L150
        r50.putString(QueryFilterEngine.KEY_L0_PARAMS, r42);     // Catch: Throwable -> L150
        r50.putInt(QueryFilterEngine.KEY_QUERY_FILTER_ENABLED, r114);     // Catch: Throwable -> L150
        String[] r52 = r35.split(",");     // Catch: Throwable -> L150
        int r117 = r52.length;     // Catch: Throwable -> L150
        int r118 = 0;
    L93:
        if (r118 >= r117) goto L101;
        int r119 = r117;
        String r120 = r52[r118];     // Catch: Throwable -> L150
        if (StringUtils.isEmpty(r120) == true) goto L99;
        String[] r121 = r52;
        if (TtnetUtil.inCookieHostList(r120, this.mApiHttpHostList) == true) goto L100;
        String r53 = r120.trim();     // Catch: Throwable -> L150
        this.mApiHttpHostList.add(r53);     // Catch: Throwable -> L150
    L100:
        r118 = r118 + 1;     // Catch: Throwable -> L150
        r117 = r119;
        r52 = r121;
        goto L93
    L99:
        r121 = r52;
        goto L100
    L101:
        r50.putInt(KEY_ENCRYPT_SWITCH, this.mEncryptSwitch);     // Catch: Throwable -> L150
        r50.putInt(KEY_IMAGE_TTNET_ENABLED, this.mImageTtnetEnabled);     // Catch: Throwable -> L150
        r50.putInt(KEY_SAMPLE_BAND_WIDTH_ENABLED, this.mSampleBandWidthEnabled);     // Catch: Throwable -> L150
        r50.putInt(KEY_CDN_SAMPLE_BAND_WIDTH_ENABLED, this.mCdnSampleBandWidthEnabled);     // Catch: Throwable -> L150
        r50.putInt(KEY_DISABLE_FRAMED_TRANSPORT, r48);     // Catch: Throwable -> L150
        r50.putInt(KEY_TNC_UPDATE_INTERVAL, this.mTncUpdateInterval.get());     // Catch: Throwable -> L150
        r50.putInt(KEY_PRIVATE_PROTOCOL_ENABLED, r22);     // Catch: Throwable -> L150
        r50.putInt(KEY_DESTROY_DELTA_MILLIS, r110);     // Catch: Throwable -> L150
        r50.putInt(KEY_DISABLE_ROTATION_HOST_RETRY, r111);     // Catch: Throwable -> L150
        StringBuilder r54 = new StringBuilder();     // Catch: Throwable -> L150
        int r122 = 0;
    L103:
        if (r122 >= this.mTncHostArrays.size()) goto L108;
        r54.append(this.mTncHostArrays.get(r122));     // Catch: Throwable -> L150
        if (r122 == this.mTncHostArrays.size()) goto L107;
        r54.append(',');     // Catch: Throwable -> L150
    L107:
        r122 = r122 + 1;     // Catch: Throwable -> L150
        goto L103
    L108:
        String r55 = r54.toString();     // Catch: Throwable -> L150
        if (TextUtils.isEmpty(r55) == true) goto L112;
        r50.putString(KEY_TNC_HOST_ARRAYS, r55);     // Catch: Throwable -> L150
    L112:
        if (TextUtils.isEmpty(this.mTncSummary) == true) goto L114;
        r50.putString(KEY_TNC_SUMMARY, this.mTncSummary);     // Catch: Throwable -> L150
    L114:
        SharedPrefsEditorCompat.apply(r50);     // Catch: Throwable -> L150
        LinkedHashMap r56 = new LinkedHashMap();     // Catch: Throwable -> L125
        if (StringUtils.isEmpty(r33) == false) goto L118;
    L120:
        r56.put(KEY_HTTP_DNS_ENABLED, Integer.valueOf(r10));     // Catch: Throwable -> L125
        r56.put(KEY_ADD_SS_QUERIES_OPEN, Integer.valueOf(r4));     // Catch: Throwable -> L125
        r56.put(KEY_ADD_SS_QUERIES_HEADER_OPEN, Integer.valueOf(r15));     // Catch: Throwable -> L125
        r56.put(KEY_ADD_SS_QUERIES_PLAINTEXT_OPEN, Integer.valueOf(r2));     // Catch: Throwable -> L125
        r56.put(KEY_SHARE_COOKIE_HOST_LIST, r34);     // Catch: Throwable -> L125
        r56.put(KEY_DISABLE_FRAMED_TRANSPORT, Integer.valueOf(r48));     // Catch: Throwable -> L125
        r56.put(QueryFilterEngine.KEY_QUERY_FILTER_CONFIG, r44);     // Catch: Throwable -> L125
        r56.put(QueryFilterEngine.KEY_L0_PARAMS, r42);     // Catch: Throwable -> L125
        r56.put(QueryFilterEngine.KEY_QUERY_FILTER_ENABLED, Integer.valueOf(r114));     // Catch: Throwable -> L125
        r56.put(KEY_PRIVATE_PROTOCOL_ENABLED, Integer.valueOf(r22));     // Catch: Throwable -> L125
        r56.put(KEY_DISABLE_ROTATION_HOST_RETRY, Integer.valueOf(r111));     // Catch: Throwable -> L125
        TTNetInit.getTTNetDepend().saveMapToProvider(this.mContext, r56);     // Catch: Throwable -> L125
        Intent r57 = new Intent(SYNC_MAIN_PROCESS_CONFIG_ACTION);     // Catch: Throwable -> L125
        if (TextUtils.isEmpty(sPackageName) == true) goto L123;
        r57.setPackage(sPackageName);     // Catch: Throwable -> L125
    L123:
        this.mContext.sendBroadcast(r57);     // Catch: Throwable -> L125
    L127:
        monitor-exit(this);     // Catch: Throwable -> L150
        if (StringUtils.isEmpty(r34) == true) goto L132;
        ShareCookieHostsSync.inst().onShareCookieHostsChanged(r116, r34);
    L132:
        if (ImageStrategyController.getInstance() == null) goto L134;
        JSONObject r58 = r11;
        ImageStrategyController.getInstance().updateConfig(r58);
    L136:
        if (TNCManager.getInstance().getTNCConfigHandler() != null) goto L138;
        r113 = r113;
    L148:
        reportShareCookieLog(r9, "return true");
        return r113;
    L138:
        if (JsonOptConfig.isTNCJsonOptEnable() == true) goto L140;
    L144:
        JSONObject r123 = r58;
        TNCManager.getInstance().getTNCConfigHandler().handleConfigChanged(r123, r40, this.mTncEtag, "", r41);
    L145:
        if (r43 == false) goto L148;
        StoreRegionManager.inst().setReceivedTNCRegionConfig();
        goto L148
    L140:
        if ((r39 instanceof JsonOptConfig.JsonWrapper) == false) goto L144;
        if (ExperimentalSwitches.isEnableTNCJsonoptRefine() == false) goto L144;
        TNCManager.getInstance().getTNCConfigHandler().handleConfigChanged(r39, r40, this.mTncEtag, "", r41);
        goto L145
    L134:
        r58 = r11;
        goto L136
    L118:
        if (r33.equals(mFrontierUrls) == true) goto L120;
        mFrontierUrls = r33;     // Catch: Throwable -> L125
        r56.put("frontier_urls", r33);     // Catch: Throwable -> L125
    L125:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L150
        goto L127
    L90:
        if (TtnetUtil.inCookieHostList(r51, this.mShareCookieHostList) == true) goto L92;
        this.mShareCookieHostList.add(r51);     // Catch: Throwable -> L150
    L150:
        th = move-exception;
        throw th;
    L160:
        OkHttp3Builder.disableFramedTransport(r48);     // Catch: Throwable -> L81
    L81:
        th = move-exception;
        th.printStackTrace();
        goto L83
    L76:
        r115 = 0;
        goto L77
    L59:
        if (this.mAddSsQueriesHeaderOpen > 0) goto L62;
        r113 = true;
        goto L63
    L55:
        r31 = false;
        goto L56
    L51:
        r30 = false;
    L153:
        th = move-exception;
        throw th;
    L44:
        r28 = r16;
        goto L45
    L32:
        r24 = false;
        goto L33
    L25:
        r23 = false;
        goto L26
    L10:
        if ((r39 instanceof JSONObject) == false) goto L13;
        r5 = (JSONObject) r39;
        goto L16
    L13:
        if ((r39 instanceof JsonOptConfig.JsonWrapper) == false) goto L15;
        r5 = ((JsonOptConfig.JsonWrapper) r39).jsonObject();
        goto L16
    L15:
        r5 = null;
        goto L16
    }

    public boolean getEncryptSwitch() {
        getEncryptSwitchFromSP();
        if (this.mEncryptSwitch != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void getEncryptSwitchFromSP() {
        if (this.mEncryptSwitchFromSP == false) goto L5;
        return;
    L5:
        this.mEncryptSwitch = this.mContext.getSharedPreferences(SP_SS_APP_CONFIG, 0).getInt(KEY_ENCRYPT_SWITCH, 0);
        this.mEncryptSwitchFromSP = true;
    }

    public void setEncryptSwitch(int r2) {
        if (this.mEncryptSwitch == r2) goto L6;
        this.mEncryptSwitch = r2;
        return;
    }

    public String getCronetSoPath() {
        return this.mCronetSoPath;
    }

    @Override // com.bytedance.frameworks.baselib.network.connectionclass.ConnectionClassManager.ConnectionClassStateChangeListener
    public void onBandwidthStateChange(ConnectionQuality r2) {
        if (Logger.debug() == false) goto L7;
        if (r2 == null) goto L8;
        Logger.d(TAG, "onBandwidthStateChange bandwidthState = " + r2);
        return;
    L8:
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.CookieShareInterceptor
    public List<String> getShareCookie(CookieManager r5, CookieManagerWrap r6, URI r7) {
        if (r7 == null) goto L42;
        if (r5 != null) goto L43;
        if (r6 == null) goto L42;
    L43:
        String r1 = r7.getHost();     // Catch: Exception -> L9
    L11:
        if (StringUtils.isEmpty(r1) == true) goto L42;
        if (TtnetUtil.inCookieHostList(r1, this.mShareCookieHostList) == false) goto L42;
        if (StringUtils.isEmpty(TTNetInit.getTTNetDepend().getShareCookieMainDomain()) == false) goto L18;
        return null;
    L18:
        ArrayList r4 = new ArrayList();
        if (r5 == null) goto L25;
        String r8 = r5.getCookie(r7.getScheme() + "://" + TTNetInit.getTTNetDepend().getShareCookieMainDomain());
        if (StringUtils.isEmpty(r8) == true) goto L25;
        r4.add(r8);
        return r4;
    L25:
        if (Lists.isEmpty(r4) == false) goto L49;
        if (r6 == null) goto L50;
        Map<String, List<String>> r9 = r6.get(URI.create(r7.getScheme() + "://" + TTNetInit.getTTNetDepend().getShareCookieMainDomain()), new LinkedHashMap());     // Catch: Throwable -> L37
        if (r9 != null) goto L30;
        return r4;
    L30:
        if (r9.isEmpty() == true) goto L52;
        List<String> r10 = r9.get("Cookie");     // Catch: Throwable -> L37
        if (r10 == null) goto L41;
        r10.add(SSCookieHandler.REQUEST_COOKIE_SOURCE_INTERCEPT_BACKUP_FLAG);     // Catch: Throwable -> L35
    L35:
        Throwable th = th;
    L39:
        th.printStackTrace();
    L41:
        return r10;
    L52:
        return r4;
    L37:
        th = move-exception;
        r10 = r4;
        th = th;
        goto L39
    L50:
        return r4;
    L49:
        return r4;
    L9:
        r1 = null;
    L42:
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.CookieShareInterceptor
    public List<String> getShareCookieHostList(String r2) {
        if (TtnetUtil.inCookieHostList(r2, this.mShareCookieHostList) == true) goto L5;
        return null;
    L5:
        return this.mShareCookieHostList;
    }

    public void setShareCookieHostList(ArrayList<String> r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.isEmpty() == true) goto L22;
        Iterator<String> r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L23;
        String r0 = r4.next();
        if (StringUtils.isEmpty(r0) == true) goto L8;
        if (TtnetUtil.inCookieHostList(r0, this.mShareCookieHostList) == true) goto L8;
        String r1 = r0.trim();
        this.mShareCookieHostList.add(r1);
        goto L8
    L23:
        return;
    }

    public List<String> getShareCookieHostList() {
        ArrayList r0 = new ArrayList();
        Iterator<String> r3 = this.mShareCookieHostList.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        String r1 = r3.next();
        if (TextUtils.isEmpty(r1) == true) goto L4;
        r0.add(r1);
        goto L4
    L8:
        return r0;
    }

    public void setTncEtag(String r1) {
        this.mTncEtag = r1;
    }

    public void setTncABTest(String r2) {
        this.mABTest = BaseHttpRequestInfo.getABTestInfo(r2);
        TNCManager.getInstance().getTNCConfigHandler().setTncAbTest(r2);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient.ITncInfoGet
    public JSONObject getABTest() {
        return this.mABTest;
    }

    public List<String> getTncHostArrays() {
        return this.mTncHostArrays;
    }

    public String getTncRules() {
        return this.mTncSummary;
    }

    public static List<String> getFrontierUrls() {
        if (TextUtils.isEmpty(mFrontierUrls) == false) goto L12;
        return null;
    L12:
        JSONArray r0 = new JSONArray(mFrontierUrls);     // Catch: Exception -> L11
        ArrayList r2 = new ArrayList();     // Catch: Exception -> L11
        int r3 = 0;
    L7:
        if (r3 >= r0.length()) goto L10;
        r2.add(r0.getString(r3));     // Catch: Exception -> L11
        r3 = r3 + 1;
        goto L7
    L10:
        return r2;
    L11:
        return null;
    }
}
