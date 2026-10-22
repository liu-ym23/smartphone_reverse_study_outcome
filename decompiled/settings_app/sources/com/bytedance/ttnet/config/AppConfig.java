package com.bytedance.ttnet.config;

import android.app.Application;
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
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.utility.persistent.SharedPrefsEditorCompat;
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
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
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
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
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
    static final String KEY_DETECT_NATIVE_PAGE = "detect_native_page";
    static final String KEY_DETECT_OPEN = "detect_open";
    static final String KEY_DISABLE_FRAMED_TRANSPORT = "disable_framed_transport";
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
    private static AppConfig mInstance = null;
    private static ArrayList<String> sBlockModelList = null;
    static boolean sCronetUnsupportedModel = false;
    static boolean sDisableFallbackReasonBoot = false;
    static boolean sEnableFallbackReasonBootFix = false;
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
    private String mFrontierUrls;
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
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            com_bytedance_ttnet_config_AppConfig$SyncConfigBroadcastReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
        }

        SyncConfigBroadcastReceiver() {
        }

        public void com_bytedance_ttnet_config_AppConfig$SyncConfigBroadcastReceiver__onReceive$___twin___(Context r1, Intent r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            if (AppConfig.SYNC_MAIN_PROCESS_CONFIG_ACTION.equals(r2.getAction()) == false) goto L8;
            final String r3 = "SyncMainProcessConfig";
            new AnonymousClass1(this, r3).start();
            return;
        }

        @Insert("onReceive")
        public static void com_bytedance_ttnet_config_AppConfig$SyncConfigBroadcastReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(SyncConfigBroadcastReceiver r7, Context r8, Intent r9) {
            Intrinsics.checkNotNullParameter(r8, "context");
            String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
            SyncConfigBroadcastReceiver r1 = r7;
            String r2 = r1.getClass().getName();
            String r3 = r1.getClass().getSimpleName();
            boolean r4 = Intrinsics.areEqual(SettingsInitialize.class, r1.getClass());
            String r5 = null;
            if (r9 == null) goto L5;
            String r6 = r9.getAction();
        L7:
            if (ArraysKt.contains(r0, r6) == false) goto L13;
            StringBuilder r10 = new StringBuilder("onReceive allowList ");
            if (r9 == null) goto L11;
            r5 = r9.getAction();
        L11:
            OLog.i("PrivacyHookForReceiver", r10.append(r5).toString());
            r7.com_bytedance_ttnet_config_AppConfig$SyncConfigBroadcastReceiver__onReceive$___twin___(r8, r9);
            return;
        L13:
            GrantUtil r11 = GrantUtil.INSTANCE;
            Application r12 = SettingsApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
            if (r11.isSetupCompelete(r12) == true) goto L16;
            OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
            r7.com_bytedance_ttnet_config_AppConfig$SyncConfigBroadcastReceiver__onReceive$___twin___(r8, r9);
            return;
        L16:
            String r13 = r3;
            if (r13 != null) goto L19;
        L22:
            boolean r14 = true;
        L23:
            if (r14 == false) goto L26;
            OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
            r7.com_bytedance_ttnet_config_AppConfig$SyncConfigBroadcastReceiver__onReceive$___twin___(r8, r9);
            return;
        L26:
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
            if (r4 == true) goto L30;
            OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
            return;
        L30:
            GrantUtil.INSTANCE.applicationInit();
            r7.com_bytedance_ttnet_config_AppConfig$SyncConfigBroadcastReceiver__onReceive$___twin___(r8, r9);
            return;
        L19:
            if (r13.length() == 0) goto L22;
            r14 = false;
            goto L23
        L5:
            r6 = null;
            goto L7
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
        NetworkParams.setApiRequestInterceptor(mInstance);     // Catch: Throwable -> L26
        ImageStrategyController.Init(r4);     // Catch: Throwable -> L26
        goto L23
    L14:
        IntentFilter r2 = new IntentFilter();     // Catch: Throwable -> L26
        r2.addAction(SYNC_MAIN_PROCESS_CONFIG_ACTION);     // Catch: Throwable -> L26
        TtnetUtil.registerNonExportedBroadcastReceiver(r4, new SyncConfigBroadcastReceiver(), r2);     // Catch: Throwable -> L17
    L19:
        SyncMultiProcessConfig r3 = SyncMultiProcessConfig.inst();     // Catch: Throwable -> L26
        RequestEncryptUtils.setEncryptConfig(r3);     // Catch: Throwable -> L26
        SsCronetHttpClient.setCronetHttpDnsConfig(r3);     // Catch: Throwable -> L26
        SsCronetHttpClient.setCronetBootFailureChecker(r3);     // Catch: Throwable -> L26
        HttpClient.setHttpClientConfig(r3);     // Catch: Throwable -> L26
        if (NetworkParams.getCookieShareInterceptor() != null) goto L22;
        NetworkParams.setCookieShareInterceptor(r3);     // Catch: Throwable -> L26
        goto L22
    L17:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L26
    L23:
        AppConfig r5 = mInstance;     // Catch: Throwable -> L26
        monitor-exit(AppConfig.class);     // Catch: Throwable -> L26
        return r5;
    }

    private AppConfig(Context r6, boolean r7) {
        this.mLastRefreshTime = new AtomicLong(0);
        this.mConfigUpdating = new AtomicBoolean(false);
        this.mLock = new Object();
        this.mLocalLoaded = false;
        this.mFrontierUrls = "";
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
        this.mContext = r6;
        this.mIsMainProcess = r7;
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
        final String r1 = "AppConfigThread";
        new AnonymousClass2(this, r1, r5, r6).start();
        return true;
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.d("TNCManager", "doRefresh, already running");
    L10:
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
    L71:
        th = move-exception;
        throw th;
    L5:
        if (this.mLocalLoaded == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L71
        return;
    L8:
        boolean r1 = true;
        this.mLocalLoaded = true;     // Catch: Throwable -> L71
        monitor-exit(r0);     // Catch: Throwable -> L71
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
        this.mFrontierUrls = r2.getString("frontier_urls", "");
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
        if (r2.getInt(KEY_PRIVATE_PROTOCOL_ENABLED, 1) >= 1) goto L49;
        r1 = false;
    L49:
        NetworkParams.setPrivateProtocolEnabled(r1);
        this.mTncUpdateInterval.set(r2.getInt(KEY_TNC_UPDATE_INTERVAL, 10800));
        String r17 = r2.getString(KEY_TNC_HOST_ARRAYS, "");
        if (TextUtils.isEmpty(r17) == true) goto L52;
        String[] r18 = r17.split(",");
        this.mTncHostArrays.clear();
        this.mTncHostArrays.addAll(Arrays.asList(r18));
    L52:
        this.mTncSummary = r2.getString(KEY_TNC_SUMMARY, "");
        if (TNCManager.getInstance().getTNCConfigHandler() == null) goto L55;
        TNCManager.getInstance().getTNCConfigHandler().loadLocalConfig(this.mLastRefreshTime.get());
    L55:
        int r19 = r2.getInt(KEY_DISABLE_FRAMED_TRANSPORT, 0);
        if (r19 <= 0) goto L62;
        OkHttp3Builder.disableFramedTransport(r19);     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        th.printStackTrace();
    L62:
        if (this.mIsMainProcess == false) goto L82;
        final LinkedHashMap r20 = new LinkedHashMap();     // Catch: Throwable -> L68
        if (StringUtils.isEmpty(this.mFrontierUrls) == true) goto L66;
        r20.put("frontier_urls", this.mFrontierUrls);     // Catch: Throwable -> L68
    L66:
        r20.put(KEY_HTTP_DNS_ENABLED, Integer.valueOf(this.mHttpDnsEnabled));     // Catch: Throwable -> L68
        r20.put(KEY_ADD_SS_QUERIES_OPEN, Integer.valueOf(this.mAddSsQueriesOpen));     // Catch: Throwable -> L68
        r20.put(KEY_ADD_SS_QUERIES_HEADER_OPEN, Integer.valueOf(this.mAddSsQueriesHeaderOpen));     // Catch: Throwable -> L68
        r20.put(KEY_ADD_SS_QUERIES_PLAINTEXT_OPEN, Integer.valueOf(this.mAddSsQueriesPlaintextOpen));     // Catch: Throwable -> L68
        r20.put(KEY_CHROMIUM_BOOT_FAILURES, Integer.valueOf(this.mChromiumBootFailures));     // Catch: Throwable -> L68
        r20.put(KEY_SHARE_COOKIE_HOST_LIST, r15);     // Catch: Throwable -> L68
        r20.put(KEY_DISABLE_FRAMED_TRANSPORT, Integer.valueOf(r19));     // Catch: Throwable -> L68
        final String r21 = "SaveMapToProvider-Thread";
        new AnonymousClass3(this, r21, r20).start();     // Catch: Throwable -> L68
        return;
    L68:
        th = move-exception;
        th.printStackTrace();
        return;
    L82:
        return;
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
        if (this.mChromiumBootFailures >= 0) goto L5;
        this.mChromiumBootFailures = r0.getInt(KEY_CHROMIUM_BOOT_FAILURES, 0);
    L5:
        this.mChromiumBootFailuresTimestamp = r0.getLong(KEY_CHROMIUM_BOOT_FAILURES_TIMESTAMP, 0);
        if (this.mChromiumBootFailures > 5) goto L8;
        return;
    L8:
        if ((System.currentTimeMillis() - this.mChromiumBootFailuresTimestamp) <= TimeUnit.HOURS.toMillis(1)) goto L12;
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

    public static boolean isCronetUnsupportedABI() {
        String r2 = Build.SUPPORTED_ABIS[0];     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return false;
    L7:
        if ("x86".equalsIgnoreCase(r2) == true) goto L12;
        if ("x86_64".equalsIgnoreCase(r2) == true) goto L12;
    L20:
        return false;
    L12:
        if (DebugMode.x86Support() == false) goto L15;
        Logger.d(TAG, "x86 support");     // Catch: Throwable -> L18
        return false;
    L15:
        Logger.w(TAG, "Cronet unsupported CPU arch: " + r2);     // Catch: Throwable -> L18
        SsOkHttp3Client.setFallbackReason(2);     // Catch: Throwable -> L18
        return true;
    L18:
        th = move-exception;
        th.printStackTrace();
        goto L20
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
        if (isChromiumOpen() == false) goto L12;
        this.mConfigUpdating.set(false);
        return;
    L12:
        if (r6 == true) goto L14;
    L20:
        int r7 = 101;
        if (TNCManager.getInstance().getDomainInternal(this.mContext, true, r5, this.mTncSummary) == true) goto L27;
        Logger.d(TAG, "tnc reqeust through okhttp failed, fallback to HttpUrlConnection");
        if (TNCManager.getInstance().getDomainInternal(this.mContext, false, TNCManager.TNCUpdateSource.PORTRETRY, this.mTncSummary) == true) goto L27;
        r7 = 102;
    L27:
        this.mHandler.sendEmptyMessage(r7);
        this.mHandler.removeMessages(103);
        this.mHandler.sendEmptyMessageDelayed(103, ((long) this.mTncUpdateInterval.get()) * 1000);
        return;
    L14:
        if (isDidEmpty() == false) goto L20;
        if (Logger.debug() == false) goto L18;
        Logger.d("TNCManager", "did is empty, delay 5s send tnc again");
    L18:
        this.mHandler.sendEmptyMessageDelayed(104, 5000);
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
        SharedPreferences r1 = this.mContext.getSharedPreferences(SP_SS_APP_CONFIG, 0);     // Catch: Throwable -> L8
        SharedPreferences.Editor r2 = r1.edit();     // Catch: Throwable -> L8
        r2.putInt(KEY_CHROMIUM_BOOT_FAILURES, 0);     // Catch: Throwable -> L8
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "KEY_CHROMIUM_BOOT_FAILURES set 0");     // Catch: Throwable -> L8
    L6:
        SharedPrefsEditorCompat.apply(r2);     // Catch: Throwable -> L8
        this.mChromiumBootFailures = r1.getInt(KEY_CHROMIUM_BOOT_FAILURES, 0);     // Catch: Throwable -> L8
        LinkedHashMap r3 = new LinkedHashMap();     // Catch: Throwable -> L8
        r3.put(KEY_CHROMIUM_BOOT_FAILURES, Integer.valueOf(this.mChromiumBootFailures));     // Catch: Throwable -> L8
        TTNetInit.getTTNetDepend().saveMapToProvider(this.mContext, r3);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        th.printStackTrace();
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

    public boolean handleResponse(Object r37, TNCManager.TNCUpdateSource r38, long r39, boolean r41) throws Exception {
        JSONObject r9 = new JSONObject();
        if ((r37 instanceof String) == false) goto L10;
        String r0 = (String) r37;
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
        JSONArray r24 = r11.optJSONArray(KEY_TNC_HOST_ARRAYS);
        if (r24 == null) goto L37;
        this.mTncHostArrays.clear();
        int r110 = 0;
    L30:
        if (r110 >= r24.length()) goto L37;
        if (TextUtils.isEmpty(r24.optString(r110)) == true) goto L35;
        this.mTncHostArrays.add(r24.optString(r110));
    L35:
        r110 = r110 + 1;
        r16 = r16;
    L37:
        int r26 = r16;
        int r25 = r11.optInt(KEY_CRASH_LIMIT_TIMES, 0);
        int r27 = r11.optInt(KEY_CRASH_DETECT_INTERVAL_MS, 5000);
        monitor-enter(this);
        this.mOkHttpOpen = r6;     // Catch: Throwable -> L145
        this.mOkHttp3Open = r7;     // Catch: Throwable -> L145
        this.mCronetVersion = r8;     // Catch: Throwable -> L145
        this.mHttpDnsEnabled = r10;     // Catch: Throwable -> L145
        this.mDetectOpen = r12;     // Catch: Throwable -> L145
        this.mDetectNativePage = r13;     // Catch: Throwable -> L145
        this.mCollectRecentPageInfoEnable = r14;     // Catch: Throwable -> L145
        this.mAddSsQueriesOpen = r4;     // Catch: Throwable -> L145
        this.mAddSsQueriesHeaderOpen = r15;     // Catch: Throwable -> L145
        this.mAddSsQueriesPlaintextOpen = r2;     // Catch: Throwable -> L145
        this.mAddDeviceFingerprintOpen = r26;     // Catch: Throwable -> L145
        this.mDynamicAdjustThreadPoolSizeOpen = r18;     // Catch: Throwable -> L145
        this.mImageTtnetEnabled = r3;     // Catch: Throwable -> L145
        this.mSampleBandWidthEnabled = r1;     // Catch: Throwable -> L145
        this.mCdnSampleBandWidthEnabled = r17;     // Catch: Throwable -> L145
        monitor-exit(this);     // Catch: Throwable -> L145
        if (r18 <= 0) goto L43;
        boolean r28 = true;
    L44:
        RequestQueue.setDynamicAdjustThreadPoolSizeOpen(r28);
        if (r11.optInt("enable_req_ticket", 1) <= 0) goto L47;
        boolean r29 = true;
    L48:
        RequestTicketUtil.setEnable(r29);
        CdnCacheVerifyUtils.CdnCacheVerifyConfig r30 = CdnCacheVerifyUtils.onServerConfigUpdate(r11);
        if (this.mAddSsQueriesOpen <= 0) goto L51;
    L54:
        boolean r111 = true;
        SsInterceptor.EnableEncryptQuery(true);
    L55:
        StreamParser.onServerConfigUpdate(r11);
        SsCronetHttpClient.tryUpdateBodyBufferSizeConfig(r11, null);
        String r31 = r11.optString("frontier_urls", "");
        String r32 = r11.optString(KEY_SHARE_COOKIE_HOST_LIST, "");
        TTNetInit.getTTNetDepend().onShareCookieConfigUpdated(r32);
        String r33 = r11.optString(KEY_API_HTTP_HOST_LIST, "");
        String r34 = r11.optString(KEY_CONCURRENT_REQUEST_CONFIG, "");
        CronetSsCallConfig.inst().onNetConfigChanged(r34);
        String r35 = r11.optString(KEY_COMMON_PARAMS_CONFIG, "");
        CommonParamConfig r36 = CommonParamManager.inst().getCommonParamConfig();
        if (r36 == null) goto L58;
        r36.onNetConfigChanged(r35);
    L58:
        String r40 = r11.optString(QueryFilterEngine.KEY_L0_PARAMS, "");
        QueryFilterEngine.inst().parseL0ParamsString(r40);
        int r112 = r11.optInt(QueryFilterEngine.KEY_QUERY_FILTER_ENABLED, Integer.MIN_VALUE);
        String r42 = JsonOptConfig.optString(r37, r11, new String[]{"data", QueryFilterEngine.KEY_QUERY_FILTER_CONFIG});
        if (r112 == Integer.MIN_VALUE) goto L65;
        QueryFilterEngine r43 = QueryFilterEngine.inst();
        if (r112 <= 0) goto L63;
        boolean r44 = r111;
    L64:
        r43.enableQueryFilterEngine(r44);
        QueryFilterEngine.inst().onNetConfigChanged(r42);
        goto L65
    L63:
        r44 = false;
    L65:
        this.mEncryptSwitch = r11.optInt("disable_encrypt_switch", 0);
        this.mCronetSoPath = r11.optString(KEY_CRONET_SO_PATH, "");
        if (this.mEncryptSwitch != 2) goto L68;
        int r113 = 0;
        SharedPreferences.Editor r45 = this.mContext.getSharedPreferences("app_log_encrypt_switch_count", 0).edit();
        r45.putInt("app_log_encrypt_faild_count", 0);
        SharedPrefsEditorCompat.apply(r45);
    L69:
        int r46 = r11.optInt(KEY_DISABLE_FRAMED_TRANSPORT, r113);
        if (r46 > 0) goto L152;
    L75:
        monitor-enter(this);
        SharedPreferences r47 = this.mContext.getSharedPreferences(SP_SS_APP_CONFIG, 0);     // Catch: Throwable -> L142
        String r114 = r47.getString(KEY_SHARE_COOKIE_HOST_LIST, "");     // Catch: Throwable -> L142
        SharedPreferences.Editor r48 = r47.edit();     // Catch: Throwable -> L142
        r48.putString(CdnCacheVerifyUtils.KEY_TTNET_RESPONSE_VERIFY, r30.verifyRegexsStr);     // Catch: Throwable -> L142
        r48.putInt(CdnCacheVerifyUtils.KEY_TTNET_RESPONSE_VERIFY_ENABLED, r30.ttnetResponseVerifyEnabled);     // Catch: Throwable -> L142
        StreamParser.onSaveConfigToSP(r48);     // Catch: Throwable -> L142
        SsCronetHttpClient.onSaveConfigToSP(r48);     // Catch: Throwable -> L142
        r48.putInt(KEY_OK_HTTP_OPEN, r6);     // Catch: Throwable -> L142
        r48.putInt(KEY_OK_HTTP3_OPEN, r7);     // Catch: Throwable -> L142
        r48.putInt(KEY_CRONET_VERSION, r8);     // Catch: Throwable -> L142
        r48.putInt(KEY_HTTP_DNS_ENABLED, r10);     // Catch: Throwable -> L142
        r48.putInt(KEY_DETECT_OPEN, r12);     // Catch: Throwable -> L142
        r48.putInt(KEY_DETECT_NATIVE_PAGE, r13);     // Catch: Throwable -> L142
        r48.putInt(KEY_COLLECT_RECENT_PAGE_INFO_ENABLE, r14);     // Catch: Throwable -> L142
        r48.putInt(KEY_ADD_SS_QUERIES_OPEN, r4);     // Catch: Throwable -> L142
        r48.putInt(KEY_ADD_SS_QUERIES_HEADER_OPEN, r15);     // Catch: Throwable -> L142
        r48.putInt(KEY_ADD_SS_QUERIES_PLAINTEXT_OPEN, r2);     // Catch: Throwable -> L142
        r48.putInt(KEY_ADD_DEVICE_FINGERPRINT_OPEN, r26);     // Catch: Throwable -> L142
        r48.putInt(KEY_DYNAMIC_ADJUST_THREADPOOL_SIZE_OPEN, r18);     // Catch: Throwable -> L142
        r48.putInt(KEY_IMAGE_TTNET_ENABLED, r3);     // Catch: Throwable -> L142
        r48.putInt(KEY_USE_HTTP_DNS, sUseHttpDns);     // Catch: Throwable -> L142
        r48.putInt(KEY_USE_HTTP_DNS_REFETCH_ON_EXPIRE, sUseHttpDnsRefetchOnExpire);     // Catch: Throwable -> L142
        r48.putInt(KEY_HTTP_SHOW_HIJACK, r19);     // Catch: Throwable -> L142
        r48.putInt(KEY_HTTP_VERIFY_SIGN, r20);     // Catch: Throwable -> L142
        r48.putInt(KEY_CRASH_LIMIT_TIMES, r25);     // Catch: Throwable -> L142
        r48.putInt(KEY_CRASH_DETECT_INTERVAL_MS, r27);     // Catch: Throwable -> L142
        r48.putString("frontier_urls", r31);     // Catch: Throwable -> L142
        r48.putString(KEY_CRONET_SO_PATH, this.mCronetSoPath);     // Catch: Throwable -> L142
        r48.putString(KEY_SHARE_COOKIE_HOST_LIST, r32);     // Catch: Throwable -> L142
        r9.put("oldShareCookieHosts", r114);     // Catch: Throwable -> L142
        r9.put("newShareCookieHosts", r32);     // Catch: Throwable -> L142
        if (TextUtils.isEmpty(r32) == true) goto L79;
        this.mShareCookieHostList.clear();     // Catch: Throwable -> L142
        TtnetUtil.parseShareCookieHostList(r32, this.mShareCookieHostList);     // Catch: Throwable -> L142
    L79:
        String r49 = TTNetInit.getTTNetDepend().getShareCookieMainDomain();     // Catch: Throwable -> L142
        if (StringUtils.isEmpty(r49) == false) goto L82;
    L84:
        r48.putString(KEY_API_HTTP_HOST_LIST, r33);     // Catch: Throwable -> L142
        r48.putString(KEY_CONCURRENT_REQUEST_CONFIG, r34);     // Catch: Throwable -> L142
        r48.putString(KEY_COMMON_PARAMS_CONFIG, r35);     // Catch: Throwable -> L142
        r48.putString(QueryFilterEngine.KEY_QUERY_FILTER_CONFIG, r42);     // Catch: Throwable -> L142
        r48.putString(QueryFilterEngine.KEY_L0_PARAMS, r40);     // Catch: Throwable -> L142
        r48.putInt(QueryFilterEngine.KEY_QUERY_FILTER_ENABLED, r112);     // Catch: Throwable -> L142
        String[] r50 = r33.split(",");     // Catch: Throwable -> L142
        int r115 = r50.length;     // Catch: Throwable -> L142
        int r116 = 0;
    L85:
        if (r116 >= r115) goto L93;
        int r117 = r115;
        String r118 = r50[r116];     // Catch: Throwable -> L142
        if (StringUtils.isEmpty(r118) == true) goto L91;
        String[] r119 = r50;
        if (TtnetUtil.inCookieHostList(r118, this.mApiHttpHostList) == true) goto L92;
        String r51 = r118.trim();     // Catch: Throwable -> L142
        this.mApiHttpHostList.add(r51);     // Catch: Throwable -> L142
    L92:
        r116 = r116 + 1;     // Catch: Throwable -> L142
        r115 = r117;
        r50 = r119;
        goto L85
    L91:
        r119 = r50;
        goto L92
    L93:
        r48.putInt(KEY_ENCRYPT_SWITCH, this.mEncryptSwitch);     // Catch: Throwable -> L142
        r48.putInt(KEY_IMAGE_TTNET_ENABLED, this.mImageTtnetEnabled);     // Catch: Throwable -> L142
        r48.putInt(KEY_SAMPLE_BAND_WIDTH_ENABLED, this.mSampleBandWidthEnabled);     // Catch: Throwable -> L142
        r48.putInt(KEY_CDN_SAMPLE_BAND_WIDTH_ENABLED, this.mCdnSampleBandWidthEnabled);     // Catch: Throwable -> L142
        r48.putInt(KEY_DISABLE_FRAMED_TRANSPORT, r46);     // Catch: Throwable -> L142
        r48.putInt(KEY_TNC_UPDATE_INTERVAL, this.mTncUpdateInterval.get());     // Catch: Throwable -> L142
        r48.putInt(KEY_PRIVATE_PROTOCOL_ENABLED, r22);     // Catch: Throwable -> L142
        StringBuilder r52 = new StringBuilder();     // Catch: Throwable -> L142
        int r53 = 0;
    L95:
        if (r53 >= this.mTncHostArrays.size()) goto L100;
        r52.append(this.mTncHostArrays.get(r53));     // Catch: Throwable -> L142
        if (r53 == this.mTncHostArrays.size()) goto L99;
        r52.append(',');     // Catch: Throwable -> L142
    L99:
        r53 = r53 + 1;     // Catch: Throwable -> L142
        goto L95
    L100:
        String r54 = r52.toString();     // Catch: Throwable -> L142
        if (TextUtils.isEmpty(r54) == true) goto L104;
        r48.putString(KEY_TNC_HOST_ARRAYS, r54);     // Catch: Throwable -> L142
    L104:
        if (TextUtils.isEmpty(this.mTncSummary) == true) goto L106;
        r48.putString(KEY_TNC_SUMMARY, this.mTncSummary);     // Catch: Throwable -> L142
    L106:
        SharedPrefsEditorCompat.apply(r48);     // Catch: Throwable -> L142
        LinkedHashMap r55 = new LinkedHashMap();     // Catch: Throwable -> L117
        if (StringUtils.isEmpty(r31) == false) goto L110;
    L112:
        r55.put(KEY_HTTP_DNS_ENABLED, Integer.valueOf(r10));     // Catch: Throwable -> L117
        r55.put(KEY_ADD_SS_QUERIES_OPEN, Integer.valueOf(r4));     // Catch: Throwable -> L117
        r55.put(KEY_ADD_SS_QUERIES_HEADER_OPEN, Integer.valueOf(r15));     // Catch: Throwable -> L117
        r55.put(KEY_ADD_SS_QUERIES_PLAINTEXT_OPEN, Integer.valueOf(r2));     // Catch: Throwable -> L117
        r55.put(KEY_SHARE_COOKIE_HOST_LIST, r32);     // Catch: Throwable -> L117
        r55.put(KEY_DISABLE_FRAMED_TRANSPORT, Integer.valueOf(r46));     // Catch: Throwable -> L117
        r55.put(QueryFilterEngine.KEY_QUERY_FILTER_CONFIG, r42);     // Catch: Throwable -> L117
        r55.put(QueryFilterEngine.KEY_L0_PARAMS, r40);     // Catch: Throwable -> L117
        r55.put(QueryFilterEngine.KEY_QUERY_FILTER_ENABLED, Integer.valueOf(r112));     // Catch: Throwable -> L117
        r55.put(KEY_PRIVATE_PROTOCOL_ENABLED, Integer.valueOf(r22));     // Catch: Throwable -> L117
        TTNetInit.getTTNetDepend().saveMapToProvider(this.mContext, r55);     // Catch: Throwable -> L117
        Intent r56 = new Intent(SYNC_MAIN_PROCESS_CONFIG_ACTION);     // Catch: Throwable -> L117
        if (TextUtils.isEmpty(sPackageName) == true) goto L115;
        r56.setPackage(sPackageName);     // Catch: Throwable -> L117
    L115:
        this.mContext.sendBroadcast(r56);     // Catch: Throwable -> L117
    L119:
        monitor-exit(this);     // Catch: Throwable -> L142
        if (StringUtils.isEmpty(r32) == true) goto L124;
        ShareCookieHostsSync.inst().onShareCookieHostsChanged(r114, r32);
    L124:
        if (ImageStrategyController.getInstance() == null) goto L126;
        JSONObject r57 = r11;
        ImageStrategyController.getInstance().updateConfig(r57);
    L128:
        if (TNCManager.getInstance().getTNCConfigHandler() != null) goto L130;
        r111 = r111;
    L140:
        reportShareCookieLog(r9, "return true");
        return r111;
    L130:
        if (JsonOptConfig.isTNCJsonOptEnable() == true) goto L132;
    L136:
        JSONObject r120 = r57;
        TNCManager.getInstance().getTNCConfigHandler().handleConfigChanged(r120, r38, this.mTncEtag, "", r39);
    L137:
        if (r41 == false) goto L140;
        StoreRegionManager.inst().setReceivedTNCRegionConfig();
        goto L140
    L132:
        if ((r37 instanceof JsonOptConfig.JsonWrapper) == false) goto L136;
        if (ExperimentalSwitches.isEnableTNCJsonoptRefine() == false) goto L136;
        TNCManager.getInstance().getTNCConfigHandler().handleConfigChanged(r37, r38, this.mTncEtag, "", r39);
        goto L137
    L126:
        r57 = r11;
        goto L128
    L110:
        if (r31.equals(this.mFrontierUrls) == true) goto L112;
        this.mFrontierUrls = r31;     // Catch: Throwable -> L117
        r55.put("frontier_urls", r31);     // Catch: Throwable -> L117
    L117:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L142
        goto L119
    L82:
        if (TtnetUtil.inCookieHostList(r49, this.mShareCookieHostList) == true) goto L84;
        this.mShareCookieHostList.add(r49);     // Catch: Throwable -> L142
    L142:
        th = move-exception;
        throw th;
    L152:
        OkHttp3Builder.disableFramedTransport(r46);     // Catch: Throwable -> L73
    L73:
        th = move-exception;
        th.printStackTrace();
        goto L75
    L68:
        r113 = 0;
        goto L69
    L51:
        if (this.mAddSsQueriesHeaderOpen > 0) goto L54;
        r111 = true;
        goto L55
    L47:
        r29 = false;
        goto L48
    L43:
        r28 = false;
    L145:
        th = move-exception;
        throw th;
    L25:
        r23 = false;
        goto L26
    L10:
        if ((r37 instanceof JSONObject) == false) goto L13;
        r5 = (JSONObject) r37;
        goto L16
    L13:
        if ((r37 instanceof JsonOptConfig.JsonWrapper) == false) goto L15;
        r5 = ((JsonOptConfig.JsonWrapper) r37).jsonObject();
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
}
