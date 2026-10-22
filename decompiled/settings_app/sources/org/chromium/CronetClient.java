package org.chromium;

import android.bluetooth.client.pbap.BluetoothPbapClient;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.common.utility.io.FileUtils;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskManager;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskType;
import com.bytedance.frameworks.baselib.network.http.cronet.ConstantsDefined;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.frameworks.baselib.network.http.cronet.TTAppStateManager;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetAppInfoSubset;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetThreadConfig;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.PacketLossMetrics;
import com.bytedance.frameworks.baselib.network.http.util.BoeUtils;
import com.bytedance.frameworks.baselib.network.http.util.ProcessUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.retrofit2.mime.TTRequestCompressManager;
import com.ttnet.org.chromium.base.Logger;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.ExperimentalCronetEngine;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import com.ttnet.org.chromium.net.TTAppSecurityManager;
import com.ttnet.org.chromium.net.TTNetVersion;
import com.ttnet.org.chromium.net.TTThreadConfigInfoProvider;
import com.ttnet.org.chromium.net.impl.CronetUrlRequest;
import com.ttnet.org.chromium.net.impl.CronetUrlRequestMapping;
import com.ttnet.org.chromium.net.impl.URLDispatch;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class CronetClient implements ICronetClient {
    private static final String BORINGSSL_LIBRARY_NAME = "ttboringssl";
    private static final String CRYPTO_LIBRARY_NAME = "ttcrypto";
    private static final int INVALID_THREAD_PRIORITY = 20;
    private static final String KEY_CRASH_DETECT_INTERVAL_MS = "crash_detect_interval_ms";
    private static final String KEY_CRASH_LIMIT_TIMES = "crash_limit_times";
    private static final String KEY_REQUEST_LOG = "request_log";
    private static final String KEY_TTNET_CRASH_TIMES = "ttnet_crash_times";
    private static final String SP_SS_APP_CONFIG = "ss_app_config";
    public static final String TAG = "CronetClient";
    private static final String TTNET_ALOG_CLASS = "com.bytedance.ttnet.TTALog";
    private static final String TTNET_BOE_FLAG = "ttnet_boe.flag";
    private static final String TTNET_CACHE_DIR = "ttnet_storage/";
    private static final String TTNET_CONFIG_FILE = "ttnet_config.json";
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private static volatile ICronetAppProvider sCronetAppProvider = null;
    private static ICronetClient.ICronetBootFailureChecker sCronetBootFailureChecker = null;
    private static volatile CronetEngine sCronetEngine = null;
    private static volatile int sNetworkThreadPriority = 20;
    private static volatile RequestFinishedInfo.Listener sRequestFinishedInfoListener;
    private int mCrashDetectTimerInterval;
    private int mCrashLimitTimes;
    private int mTTNetCrashTimes;

    static {
    }

    private long getCostTime(long r3, long r5) {
        if (r5 != (-1)) goto L5;
    L11:
        return -1;
    L5:
        if (r3 == (-1)) goto L11;
        if (r5 > r3) goto L11;
        return r3 - r5;
    }

    public static void setHttpDnsForTesting(boolean r0, boolean r1, boolean r2) throws Exception {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public String getCronetVersion() {
        return TTNetVersion.VERSION;
    }

    public CronetClient() {
        this.mCrashLimitTimes = 0;
        this.mCrashDetectTimerInterval = 5000;
    }

    static /* synthetic */ long access$000(CronetClient r0, long r1, long r3) {
        return r0.getCostTime(r1, r3);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public HttpURLConnection openConnection(Context r13, String r14, boolean r15, String r16, Executor r17, ICronetAppProvider r18) throws IOException {
    L7:
        th = move-exception;
        if ((th instanceof MalformedURLException) == false) goto L11;
        throw th;
    L11:
        if ((th instanceof UnsupportedOperationException) == false) goto L19;
        if (th.getMessage() == null) goto L19;
        if (th.getMessage().contains("Unexpected protocol") == false) goto L19;
        throw new IOException("MalformedURLException", th);
    L19:
        throw new IOException(th);
    L3:
        if (TTNetInitMetrics.inst().mode != TTNetInitMetrics.CronetInitMode.NONE) goto L5;
        TTNetInitMetrics r0 = TTNetInitMetrics.inst();     // Catch: Throwable -> L7
        r0.mode = TTNetInitMetrics.CronetInitMode.LAZY_INIT;     // Catch: Throwable -> L7
    L5:
        tryCreateCronetEngine(r13, false, false, false, r15, r16, r17, false, r18);     // Catch: Throwable -> L7
        return (HttpURLConnection) sCronetEngine.openConnection(new URL(r14));
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setCronetBootFailureChecker(ICronetClient.ICronetBootFailureChecker r1) {
        sCronetBootFailureChecker = r1;
    }

    public static void setNetworkThreadPriority(int r0) {
        sNetworkThreadPriority = r0;
    }

    private void detectCronetColdStartCrash(final Context r11, ExperimentalCronetEngine.Builder r12) {
        SharedPreferences r0 = r11.getSharedPreferences(SP_SS_APP_CONFIG, 0);
        int r3 = r0.getInt(KEY_CRASH_LIMIT_TIMES, 0);
        this.mCrashLimitTimes = r3;
        if (r3 > 0) goto L8;
        int r4 = r0.getInt(KEY_TTNET_CRASH_TIMES, 0);
        this.mTTNetCrashTimes = r4;
        if (r4 <= 0) goto L28;
        SharedPreferences.Editor r1 = r0.edit();
        r1.putInt(KEY_TTNET_CRASH_TIMES, 0);
        r1.apply();
        return;
    L28:
        return;
    L8:
        this.mTTNetCrashTimes = r0.getInt(KEY_TTNET_CRASH_TIMES, 0);
        int r2 = r0.getInt(KEY_CRASH_DETECT_INTERVAL_MS, 5000);
        this.mCrashDetectTimerInterval = r2;
        if (r2 > 0) goto L12;
        this.mCrashDetectTimerInterval = 5000;
    L12:
        if (Logger.debug() == false) goto L15;
        Logger.d(TAG, "processname is " + ProcessUtils.getCurProcessName(r11) + " count is " + this.mTTNetCrashTimes + " limit is " + this.mCrashLimitTimes + " interval is " + this.mCrashDetectTimerInterval);
    L15:
        if (this.mTTNetCrashTimes < this.mCrashLimitTimes) goto L21;
        if (Logger.debug() == false) goto L19;
        Logger.d(TAG, "processname is " + ProcessUtils.getCurProcessName(r11) + "set secure mode true");
    L19:
        r12.enableTncSecureMode(true);
    L21:
        if (ProcessUtils.isMainProcessByProcessFlag(r11) == true) goto L23;
        return;
    L23:
        final SharedPreferences.Editor r7 = r0.edit();
        int r5 = this.mTTNetCrashTimes + 1;
        this.mTTNetCrashTimes = r5;
        r7.putInt(KEY_TTNET_CRASH_TIMES, r5);
        r7.commit();
        if (Logger.debug() == false) goto L26;
        Logger.d(TAG, "processname is " + ProcessUtils.getCurProcessName(r11) + " save count " + this.mTTNetCrashTimes);
    L26:
        NetworkAsyncTaskManager r8 = NetworkAsyncTaskManager.inst(NetworkAsyncTaskType.NETWORK);
        final long r6 = this.mCrashDetectTimerInterval;
        final long r9 = 0;
        r8.postTask(new AnonymousClass1(this, r6, r9, r11, r7));
    }

    private TTAppInfoProvider.AppInfo convertToCronetAppInfo(TTNetAppInfoSubset r2) {
        TTAppInfoProvider.AppInfo r1 = new TTAppInfoProvider.AppInfo();
        r1.setAppId(r2.mAppId);
        r1.setDevicePlatform(r2.mDevicePlatform);
        r1.setVersionCode(r2.mVersionCode);
        r1.setChannel(r2.mChannel);
        r1.setAbSdkVersion(r2.mAbSdkVersion);
        r1.setHostFirst(r2.mHostFirst);
        r1.setHostSecond(r2.mHostSecond);
        r1.setHostThird(r2.mHostThird);
        r1.setDomainHttpDns(r2.mDomainHttpDns);
        r1.setDomainBoe(r2.mDomainBoe);
        r1.setDomainBoeHttps(r2.mDomainBoeHttps);
        r1.setRegion(r2.mRegion);
        r1.setSysRegion(r2.mSysRegion);
        r1.setCarrierRegion(r2.mCarrierRegion);
        r1.setInitRegion(r2.mInitRegion);
        r1.setHttpDnsRequestFlags(r2.mHttpDnsRequestFlags);
        return r1;
    }

    ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> convertToCronetThreadConfigInfoList(ArrayList<TTNetThreadConfig> r6) {
        if (r6 != null) goto L4;
        return null;
    L4:
        if (r6.isEmpty() == true) goto L31;
        ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> r5 = new ArrayList();
        EnumSet r0 = EnumSet.noneOf(TTNetThreadConfig.ThreadType.class);
        Iterator<TTNetThreadConfig> r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L21;
        TTNetThreadConfig r1 = r7.next();
        if (r1.mThreadPriority >= (-20)) goto L12;
    L14:
        boolean r2 = false;
    L15:
        if (r2 == false) goto L8;
        if (r0.contains(r1.mThreadType) == true) goto L8;
        TTThreadConfigInfoProvider.ThreadConfigInfo r3 = new TTThreadConfigInfoProvider.ThreadConfigInfo();
        r3.setThreadType(TTThreadConfigInfoProvider.ThreadType.values()[r1.mThreadType.ordinal()]);
        r3.setThreadPriority(r1.mThreadPriority);
        r5.add(r3);
        r0.add(r1.mThreadType);
        goto L8
    L12:
        if (r1.mThreadPriority > 19) goto L14;
        r2 = true;
        goto L15
    L21:
        return r5;
    L31:
        return null;
    }

    TTThreadConfigInfoProvider.Callback convertToCronetThreadConfigCallback(final TTNetThreadConfig.Callback r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new AnonymousClass2(this, r2);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void tryCreateCronetEngine(Context r17, boolean r18, boolean r19, boolean r20, boolean r21, String r22, Executor r23, boolean r24, ICronetAppProvider r25) {
        if (sCronetEngine == null) goto L5;
        return;
    L5:
        monitor-enter(CronetClient.class);
    L145:
        th = move-exception;
        throw th;
    L7:
        if (sCronetEngine != null) goto L140;
        Log.w(TAG, "CronetClient tryCreateCronetEngine");     // Catch: Throwable -> L145
        TTNetInitMetrics.inst().createEngineStartTime = System.currentTimeMillis();     // Catch: Throwable -> L145
        TTNetInitMetrics.inst().createEngineStart = System.nanoTime();     // Catch: Throwable -> L145
        if (r24 == true) goto L17;
        ICronetClient.ICronetBootFailureChecker r0 = sCronetBootFailureChecker;     // Catch: Throwable -> L145
        if (r0 == null) goto L17;
        if (r0.isCronetBootFailureExpected() == true) goto L17;
        Log.w(TAG, "isCronetBootFailureExpected return false.");     // Catch: Throwable -> L145
        throw new IllegalArgumentException("isCronetBootFailureExpected return false.");     // Catch: Throwable -> L145
    L17:
        TTNetInitMetrics.inst().constructAppInfoSubsetStart = System.nanoTime();     // Catch: Throwable -> L145
        boolean r5 = CronetAppProviderManager.inst().getOptInit();     // Catch: Throwable -> L145
        if (r5 == false) goto L20;
        TTNetAppInfoSubset r1 = r25.getAppInfoSubset();     // Catch: Throwable -> L145
    L21:
        TTNetAppInfoSubset r6 = r1;
        TTNetInitMetrics.inst().constructAppInfoSubsetEnd = System.nanoTime();     // Catch: Throwable -> L145
        TTNetInitMetrics.inst().constructThreadConfigListStart = TTNetInitMetrics.inst().constructAppInfoSubsetEnd;     // Catch: Throwable -> L145
        ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> r7 = convertToCronetThreadConfigInfoList(getThreadConfigInfoList());     // Catch: Throwable -> L145
        TTNetInitMetrics.inst().constructThreadConfigListEnd = System.nanoTime();     // Catch: Throwable -> L145
        TTNetInitMetrics.inst().constructThreadConfigCallbackStart = TTNetInitMetrics.inst().constructThreadConfigListEnd;     // Catch: Throwable -> L145
        TTThreadConfigInfoProvider.Callback r8 = convertToCronetThreadConfigCallback(getThreadConfigCallbackImpl());     // Catch: Throwable -> L145
        TTNetInitMetrics.inst().constructThreadConfigCallbackEnd = System.nanoTime();     // Catch: Throwable -> L145
        TTNetInitMetrics.inst().buildContextConfigStart = TTNetInitMetrics.inst().constructAppInfoSubsetEnd;     // Catch: Throwable -> L145
        ExperimentalCronetEngine.Builder r10 = new ExperimentalCronetEngine.Builder(r17, r5).enableQuic(r18).enableHttp2(r19).enableSdch(r20).enableHttpDns(r21).listenAppStateIndependently(getListenAppStateIndependently()).enableNetworkQualityEstimator(true);     // Catch: Throwable -> L145
        if (CronetDependManager.inst().loggerDebug() == false) goto L24;
        r10.enableVerboseLog();     // Catch: Throwable -> L145
    L24:
        r10.setTTNetInitStart(Math.min(TTNetInitMetrics.inst().initTTNetStart, TTNetInitMetrics.inst().createEngineStart));     // Catch: Throwable -> L145
        detectCronetColdStartCrash(r17, r10);     // Catch: Throwable -> L145
        String r11 = "";
        r11 = r17.getCacheDir().getPath() + LibrarianImpl.Constants.SEPARATOR;     // Catch: Throwable -> L27
        r10.setStoragePath(r11 + TTNET_CACHE_DIR);     // Catch: Throwable -> L27
        r10.enableHttpCache(3, getMaxHttpDiskCacheSize());     // Catch: Throwable -> L27
    L30:
        if (sNetworkThreadPriority >= (-20)) goto L32;
    L34:
        int r2 = getAppSecurityLevel();     // Catch: Throwable -> L145
        if (r2 <= 0) goto L38;
        r10.setAppSecurityLevel(r2);     // Catch: Throwable -> L145
    L38:
        if (CronetAppProviderManager.inst().isEnableBrotli() == false) goto L41;
        r10.enableBrotli(true);     // Catch: Throwable -> L145
    L41:
        if (CronetAppProviderManager.inst().isEnableQuic() == false) goto L44;
        r10.enableQuic(true);     // Catch: Throwable -> L145
    L44:
        if (CronetAppProviderManager.inst().isEnableHttp2() == false) goto L46;
        r10.enableHttp2(true);     // Catch: Throwable -> L145
    L46:
        TTAppSecurityManager.getInstance().setSystemApiSandbox(CronetSystemApiSandbox.inst());     // Catch: Throwable -> L145
        r10.setAppInfoProvider(CronetAppInfoProvider.inst(r17));     // Catch: Throwable -> L145
        r10.setEventListener(CronetEventListener.inst());     // Catch: Throwable -> L145
        r10.setIsMainProcess(ProcessUtils.isMainProcessByProcessFlag(r17));     // Catch: Throwable -> L145
        r10.setProcessName(ProcessUtils.getCurProcessName(r17));     // Catch: Throwable -> L145
        if (ProcessUtils.isMainProcessByProcessFlag(r17) == false) goto L49;
        r10.setAppMonitorProvider(CronetAppMonitorProvider.inst());     // Catch: Throwable -> L145
        CronetEventListener.inst().setIsMainProcess(true);     // Catch: Throwable -> L145
    L49:
        if (r5 == false) goto L51;
        r10.setTTAppInfoColdStartSubset(convertToCronetAppInfo(r6));     // Catch: Throwable -> L145
    L51:
        r10.setOptInit(r5);     // Catch: Throwable -> L145
        r10.setOptNqeInit(r25.getOptNqeDefault(), r25.getOptNqePersist());     // Catch: Throwable -> L145
        r10.setThreadConfigInfoList(r7);     // Catch: Throwable -> L145
        r10.setThreadConfigCallbackImpl(r8);     // Catch: Throwable -> L145
        r10.setLazyInitIPC(r25.getLazyInitCronetIPC());     // Catch: Throwable -> L145
        if (TextUtils.isEmpty(r22) == true) goto L54;
        r10.setUserAgent(r22 + " cronet/TTNetVersion:06c5b28f 2024-10-21 QuicVersion:d9628e3d 2024-10-11");     // Catch: Throwable -> L145
    L54:
        String r3 = getDomainConfigByRegion();     // Catch: Throwable -> L145
        if (TextUtils.isEmpty(r3) == false) goto L58;
        r3 = CronetAppProviderManager.inst().getGetDomainDefaultJSON();     // Catch: Throwable -> L145
    L58:
        if (TextUtils.isEmpty(r3) == true) goto L60;
        r10.setGetDomainDefaultJSON(r3);     // Catch: Throwable -> L145
    L60:
        ArrayList<byte[]> r4 = CronetAppProviderManager.inst().getOpaqueData();     // Catch: Throwable -> L145
        if (r4 != null) goto L63;
    L65:
        Map<String[], Pair<byte[], byte[]>> r9 = CronetAppProviderManager.inst().getClientOpaqueData();     // Catch: Throwable -> L145
        if (r9 != null) goto L68;
    L70:
        Map<String, Pair<Integer, Integer>> r12 = CronetAppProviderManager.inst().getQuicHint();     // Catch: Throwable -> L145
        if (r12 == null) goto L79;
        if (r12.isEmpty() == true) goto L79;
        Iterator<Map.Entry<String, Pair<Integer, Integer>>> r13 = r12.entrySet().iterator();     // Catch: Throwable -> L145
    L76:
        if (r13.hasNext() == false) goto L79;
        Map.Entry<String, Pair<Integer, Integer>> r14 = r13.next();     // Catch: Throwable -> L145
        r10.addQuicHint(r14.getKey(), ((Integer) r14.getValue().first).intValue(), ((Integer) r14.getValue().second).intValue());     // Catch: Throwable -> L145
    L79:
        if (CronetAppProviderManager.inst().needCustomLoadLibrary() == false) goto L81;
        r10.setLibraryLoader(new AnonymousClass3(this));     // Catch: Throwable -> L145
    L81:
        String r15 = CronetAppProviderManager.inst().getCronetSoPath();     // Catch: Throwable -> L145
        if (TextUtils.isEmpty(r15) == true) goto L86;
        String r16 = r15.substring(r15.lastIndexOf(File.separator) + 1);     // Catch: Throwable -> L145
        String r26 = r17.getCacheDir().getAbsolutePath();     // Catch: Throwable -> L145
        if (FileUtils.copyFile(r15, r26, r16) == false) goto L86;
        r10.setCronetSoPath(r26 + File.separator + r16);     // Catch: Throwable -> L145
    L86:
        boolean r27 = CronetAppProviderManager.inst().isBOEProxyEnabled();     // Catch: Throwable -> L145
        if (r27 == false) goto L89;
        r10.enableBoeProxy(true);     // Catch: Throwable -> L145
    L89:
        if (r27 == true) goto L101;
        String r28 = BoeUtils.getConfigFromAssets(r17, TTNET_CONFIG_FILE);     // Catch: Throwable -> L145
        if (TextUtils.isEmpty(r28) == true) goto L101;
        JSONObject r29 = new JSONObject(r28);     // Catch: Throwable -> L99
        String r30 = r29.optString("ttnet_proxy", "");     // Catch: Throwable -> L99
        if (TextUtils.isEmpty(r30) == true) goto L95;
        r10.setProxyConfig(r30);     // Catch: Throwable -> L99
    L95:
        r27 = r29.optBoolean("boe_proxy_enabled", false);     // Catch: Throwable -> L99
        if (r27 == false) goto L101;
        r10.enableBoeProxy(true);     // Catch: Throwable -> L99
    L99:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L145
    L101:
        if (r27 == true) goto L105;
        r27 = BoeUtils.isBoeProxyEnabledByBoeFlag(r17);     // Catch: Throwable -> L145
        if (r27 == false) goto L105;
        r10.enableBoeProxy(true);     // Catch: Throwable -> L145
    L105:
        if (r27 == false) goto L112;
        String r31 = CronetAppProviderManager.inst().getBypassBOEJSON();     // Catch: Throwable -> L145
        if (TextUtils.isEmpty(r31) == true) goto L109;
        r10.setBypassBOEJSON(r31);     // Catch: Throwable -> L145
    L109:
        String r32 = getProxyConfig(r11);     // Catch: Throwable -> L145
        if (TextUtils.isEmpty(r32) == true) goto L112;
        Log.e(TAG, "set proxy config: " + r32);     // Catch: Throwable -> L145
        r10.setProxyConfig(r32);     // Catch: Throwable -> L145
    L112:
        String r33 = CronetAppProviderManager.inst().getStoreIdcRuleJSON();     // Catch: Throwable -> L145
        if (TextUtils.isEmpty(r33) == true) goto L154;
        r10.setStoreIdcRuleJSON(r33);     // Catch: Throwable -> L145
    L154:
        long r34 = getALogFuncAddr();     // Catch: Exception -> L119 Throwable -> L145
        if (r34 == 0) goto L121;
        Log.e(TAG, "set alog address: " + r34);     // Catch: Exception -> L119 Throwable -> L145
        r10.setALogFuncAddr(r34);     // Catch: Exception -> L119 Throwable -> L145
    L121:
        TTNetInitMetrics.inst().buildContextConfigEnd = System.nanoTime();     // Catch: Throwable -> L145
        TTNetInitMetrics.inst().buildBuilderStart = TTNetInitMetrics.inst().buildContextConfigEnd;     // Catch: Throwable -> L145
        sCronetEngine = r10.build();     // Catch: Throwable -> L145
        TTNetInitMetrics.inst().buildBuilderEnd = System.nanoTime();     // Catch: Throwable -> L145
        if (CronetDependManager.inst().loggerDebug() == false) goto L124;
        Logger.setLogLevel(2);     // Catch: Throwable -> L145
    L126:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L140;
        ExperimentalCronetEngine r35 = (ExperimentalCronetEngine) sCronetEngine;     // Catch: Throwable -> L145
        long r36 = getALogFuncAddr();     // Catch: Throwable -> L137
        if (r36 == 0) goto L131;
        Log.e(TAG, "ensure setting alog address: " + r36);     // Catch: Throwable -> L137
        r35.setAlogFuncAddr(r36);     // Catch: Throwable -> L137
    L131:
        int r37 = TTAppStateManager.getAppStartUpState();     // Catch: Throwable -> L137
        if (r37 < 0) goto L135;
        if (r37 > 2) goto L135;
        r35.setAppStartUpState(r37);     // Catch: Throwable -> L137
    L135:
        TTNetInitMetrics.inst().initMSSdk(r17, r35.getOpaqueFuncAddress());     // Catch: Throwable -> L137
    L137:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L145
        goto L140
    L124:
        Logger.setLogLevel(4);     // Catch: Throwable -> L145
    L119:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L145
        goto L121
    L68:
        if (r9.isEmpty() == true) goto L70;
        r10.setClientOpaqueData(r9);     // Catch: Throwable -> L145
        goto L70
    L63:
        if (r4.isEmpty() == true) goto L65;
        r10.setOpaqueData(r4);     // Catch: Throwable -> L145
        goto L65
    L32:
        if (sNetworkThreadPriority > 19) goto L34;
        r10.setThreadPriority(sNetworkThreadPriority);     // Catch: Throwable -> L145
    L27:
        th = move-exception;
        Log.w(TAG, "ExperimentalCronetEngine.Builder enable HTTP Cache failed.");     // Catch: Throwable -> L145
        th.printStackTrace();     // Catch: Throwable -> L145
        r10.enableHttpCache(0, 0);     // Catch: Throwable -> L145
        goto L30
    L20:
        r1 = null;
    L140:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L142;
        ExperimentalCronetEngine r38 = (ExperimentalCronetEngine) sCronetEngine;     // Catch: Throwable -> L145
        tryCreateRequestFinishedInfoListener(r23);     // Catch: Throwable -> L145
        r38.addRequestFinishedListener(sRequestFinishedInfoListener);     // Catch: Throwable -> L145
    L142:
        TTRequestCompressManager.setCompressDataCallback(new AnonymousClass4(this));     // Catch: Throwable -> L145
        TTNetInitMetrics.inst().createEngineEnd = System.nanoTime();     // Catch: Throwable -> L145
        monitor-exit(CronetClient.class);     // Catch: Throwable -> L145
    }

    public static CronetEngine getCronetEngine() {
        if (sCronetEngine == null) goto L7;
        return sCronetEngine;
    L7:
        throw new NullPointerException("Cronet engine is null.");
    }

    public static void triggerGetDomain(Context r2, boolean r3) {
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (ProcessUtils.isMainProcessByProcessFlag(r2) == true) goto L6;
        return;
    L6:
        if (CronetDependManager.inst().loggerDebug() == false) goto L9;
        CronetDependManager.inst().loggerD(TAG, "triggerGetDomain start");     // Catch: Throwable -> L12
    L9:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L17;
        ((ExperimentalCronetEngine) sCronetEngine).triggerGetDomain(r3);     // Catch: Throwable -> L12
        return;
    }

    public static void runInBackGround(Context r2, boolean r3) {
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (ProcessUtils.isMainProcessByProcessFlag(r2) == true) goto L6;
        return;
    L6:
        if (CronetDependManager.inst().loggerDebug() == false) goto L9;
        CronetDependManager.inst().loggerD(TAG, "runInBackGround start");     // Catch: Throwable -> L12
    L9:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L17;
        ((ExperimentalCronetEngine) sCronetEngine).runInBackGround(r3);     // Catch: Throwable -> L12
        return;
    }

    public static void addClientOpaqueData(Context r8, String[] r9, byte[] r10, byte[] r11, long r12, long r14) {
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (ProcessUtils.isMainProcessByProcessFlag(r8) == true) goto L6;
        return;
    L6:
        if (CronetDependManager.inst().loggerDebug() == false) goto L9;
        CronetDependManager.inst().loggerD(TAG, "addClientOpaqueData start");     // Catch: Throwable -> L12
    L9:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L17;
        ((ExperimentalCronetEngine) sCronetEngine).addClientOpaqueData(r9, r10, r11, r12, r14);     // Catch: Throwable -> L12
        return;
    }

    public static void clearClientOpaqueData(Context r2) {
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (ProcessUtils.isMainProcessByProcessFlag(r2) == true) goto L6;
        return;
    L6:
        if (CronetDependManager.inst().loggerDebug() == false) goto L9;
        CronetDependManager.inst().loggerD(TAG, "clearClientOpaqueData start");     // Catch: Throwable -> L12
    L9:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L17;
        ((ExperimentalCronetEngine) sCronetEngine).clearClientOpaqueData();     // Catch: Throwable -> L12
        return;
    }

    public static void removeClientOpaqueData(Context r2, String r3) {
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (ProcessUtils.isMainProcessByProcessFlag(r2) == true) goto L6;
        return;
    L6:
        if (CronetDependManager.inst().loggerDebug() == false) goto L9;
        CronetDependManager.inst().loggerD(TAG, "removeClientOpaqueData start");     // Catch: Throwable -> L12
    L9:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L17;
        ((ExperimentalCronetEngine) sCronetEngine).removeClientOpaqueData(r3);     // Catch: Throwable -> L12
        return;
    }

    public static void setProxy(String r1) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setProxy(r1);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public static String[] ttUrlDispatch(String r2, int r3) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        Map<String, String> r4 = ((ExperimentalCronetEngine) sCronetEngine).ttUrlDispatch(r2, r3);
        return new String[]{r4.get(URLDispatch.KEY_FINAL_URL), r4.get(URLDispatch.KEY_EPOCH), r4.get(URLDispatch.KEY_ETAG)};
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public static void preconnectUrl(String r2, Map<String, String> r3) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).preconnectUrl(r2, 1, r3);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public static int[] getNetworkQuality() throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ExperimentalCronetEngine r1 = (ExperimentalCronetEngine) sCronetEngine;
        return new int[]{r1.getTransportRttMs(), r1.getHttpRttMs(), r1.getDownstreamThroughputKbps()};
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public static PacketLossMetrics getPacketLossRateMetrics(int r4) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        PacketLossMetrics r0 = new PacketLossMetrics();
        ExperimentalCronetEngine r1 = (ExperimentalCronetEngine) sCronetEngine;
        r0.protocol = r4;
        r0.upstreamLossRate = r1.getUpstreamPacketLossRate(r4);
        r0.upstreamLossRateVariance = r1.getUpstreamPacketLossRateVariance(r4);
        r0.downstreamLossRate = r1.getDownstreamPacketLossRate(r4);
        r0.downstreamLossRateVariance = r1.getDownstreamPacketLossRateVariance(r4);
        return r0;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public static Map<String, int[]> getGroupRTTEstimates() throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        return ((ExperimentalCronetEngine) sCronetEngine).getGroupRttEstimates();
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public static void setHostResolverRules(String r1) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setHostResolverRules(r1);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public static void tryStartNetDetect(String[] r1, int r2, int r3) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).tryStartNetDetect(r1, r2, r3);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public static void ttDnsResolve(String r1, int r2, String r3, Map<String, String> r4) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).ttDnsResolve(r1, r2, r3, r4);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public static void getMappingRequestState(final String r2) {
        CronetUrlRequest r0 = CronetUrlRequestMapping.GetRequest(r2);     // Catch: Throwable -> L6
        if (r0 == null) goto L11;
        r0.getStatus(new AnonymousClass5(r2));     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public static int getEffectiveConnectionType() throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        return ((ExperimentalCronetEngine) sCronetEngine).getEffectiveConnectionType();
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public static void notifyTNCConfigUpdated(String r8, String r9, String r10, String r11, String r12, String r13) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).notifyTNCConfigUpdated(r8, r9, r10, r11, r12, r13);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public static void notifyStoreRegionUpdated(String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).updateStoreRegionFromServer(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    private void tryCreateRequestFinishedInfoListener(final Executor r3) {
        if (sRequestFinishedInfoListener == null) goto L5;
        return;
    L5:
        monitor-enter(CronetClient.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sRequestFinishedInfoListener != null) goto L9;
        sRequestFinishedInfoListener = new AnonymousClass6(this, r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(CronetClient.class);     // Catch: Throwable -> L11
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public boolean isCronetHttpURLConnection(HttpURLConnection r1) {
        return r1 instanceof CronetHttpURLConnection;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void getRequestMetrics(HttpURLConnection r7, Map<String, Object> r8) {
        if (r7 == null) goto L20;
        if (r8 != null) goto L6;
        return;
    L6:
        if ((r7 instanceof CronetHttpURLConnection) == true) goto L18;
        return;
    L18:
        CronetHttpURLConnection r9 = (CronetHttpURLConnection) r7;     // Catch: Throwable -> L15
        RequestFinishedInfo r0 = r9.getRequestFinishedInfo();     // Catch: Throwable -> L15
        if (r0 != null) goto L11;
    L13:
        r8.put("request_log", r9.getRequestLog());     // Catch: Throwable -> L15
        return;
    L11:
        if (r0.getMetrics() == null) goto L13;
        RequestFinishedInfo.Metrics r1 = r0.getMetrics();     // Catch: Throwable -> L15
        r8.put(ICronetClient.KEY_REMOTE_IP, r1.getPeerAddr() + ":" + r1.getPeerPort());     // Catch: Throwable -> L15
        r8.put(ICronetClient.KEY_DNS_TIME, Long.valueOf(getCostTime(getTime(r1.getDnsEnd()), getTime(r1.getDnsStart()))));     // Catch: Throwable -> L15
        r8.put(ICronetClient.KEY_CONNECT_TIME, Long.valueOf(getCostTime(getTime(r1.getConnectEnd()), getTime(r1.getConnectStart()))));     // Catch: Throwable -> L15
        r8.put(ICronetClient.KEY_SSL_TIME, Long.valueOf(getCostTime(getTime(r1.getSslEnd()), getTime(r1.getSslStart()))));     // Catch: Throwable -> L15
        r8.put(ICronetClient.KEY_SEND_TIME, Long.valueOf(getCostTime(getTime(r1.getSendingEnd()), getTime(r1.getSendingStart()))));     // Catch: Throwable -> L15
        r8.put(ICronetClient.KEY_PUSH_TIME, Long.valueOf(getCostTime(getTime(r1.getPushEnd()), getTime(r1.getPushStart()))));     // Catch: Throwable -> L15
        r8.put(ICronetClient.KEY_RECEIVE_TIME, Long.valueOf(getCostTime(getTime(r1.getRequestEnd()), getTime(r1.getResponseStart()))));     // Catch: Throwable -> L15
        r8.put(ICronetClient.KEY_SOCKET_REUSED, Boolean.valueOf(r1.getSocketReused()));     // Catch: Throwable -> L15
        r8.put(ICronetClient.KEY_TTFB, Long.valueOf(getValue(r1.getTtfbMs())));     // Catch: Throwable -> L15
        r8.put("total_time", Long.valueOf(getValue(r1.getTotalTimeMs())));     // Catch: Throwable -> L15
        r8.put(ICronetClient.KEY_SEND_BYTE_COUNT, Long.valueOf(getValue(r1.getSentByteCount())));     // Catch: Throwable -> L15
        r8.put(ICronetClient.KEY_RECEIVED_BYTE_COUNT, Long.valueOf(getValue(r1.getReceivedByteCount())));     // Catch: Throwable -> L15
        r8.put(ICronetClient.KEY_RETRY_ATTEMPTS, Long.valueOf(getValue(r1.getRetryAttempts())));     // Catch: Throwable -> L15
        r8.put(ICronetClient.KEY_REQUEST_HEADERS, r1.getRequestHeaders());     // Catch: Throwable -> L15
        r8.put(ICronetClient.KEY_RESPONSE_HEADERS, r1.getResponseHeaders());     // Catch: Throwable -> L15
        r8.put(ICronetClient.KEY_REQUEST_START, Long.valueOf(getTime(r1.getRequestStart())));     // Catch: Throwable -> L15
        r8.put(ICronetClient.KEY_POST_TASK_START, Long.valueOf(getTime(r1.getPostTaskStartMs())));     // Catch: Throwable -> L15
        r8.put(ICronetClient.KEY_WAIT_CONTEXT, Long.valueOf(getCostTime(getTime(r1.getRequestStart()), getTime(r1.getPostTaskStartMs()))));     // Catch: Throwable -> L15
        r8.put(ICronetClient.KEY_UPPER_ADD_COOKIE_US, r1.getAddCookieCostUs());     // Catch: Throwable -> L15
        r8.put(ICronetClient.KEY_UPPER_SAVE_COOKIE_US, r1.getSaveCookieCostUs());     // Catch: Throwable -> L15
        r8.put(ICronetClient.KEY_REQ_COOKIE_SOURCE_TYPE, r1.getRequestCookieSource());     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getCronetInternalErrorCode(HttpURLConnection r2) {
        if ((r2 instanceof CronetHttpURLConnection) == true) goto L6;
        return 0;
    L6:
        return ((CronetHttpURLConnection) r2).getCronetInternalErrorCode();
    L11:
        return 0;
    }

    private long getTime(Date r1) {
        if (r1 != null) goto L6;
        return -1;
    L6:
        return r1.getTime();
    }

    private long getValue(Long r1) {
        if (r1 != null) goto L6;
        return -1;
    L6:
        return r1.longValue();
    }

    public static void setAlogFuncAddr(long r1) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setAlogFuncAddr(r1);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public static void setZstdFuncAddr(long r18, long r20, long r22, long r24, long r26, long r28, long r30, long r32) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setZstdFuncAddr(r18, r20, r22, r24, r26, r28, r30, r32);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public static void startThrottle(String[] r1, int r2, long r3) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).startThrottle(r1, r2, r3);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public static void stopThrottle(String[] r1, int r2) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).stopThrottle(r1, r2);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public static void setBestHostWithRouteSelectionName(String r1, String r2) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setRouteSelectionBestHost(r1, r2);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public static void setCookieInitCompleted() {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setCookieInitCompleted();
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public static void reportNetDiagnosisUserLog(String r1) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).reportNetDiagnosisUserLog(r1);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public static boolean notifySwitchToMultiNetwork(boolean r1) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).notifySwitchToMultiNetwork(r1);
        return true;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public static void triggerSwitchingToCellular() throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).triggerWiFiToCellularByThirdParty();
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public static int getNetworkQualityLevel() throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        return ((ExperimentalCronetEngine) sCronetEngine).getNetworkQualityLevel();
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public static int getEffectiveHttpRttMs() throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        return ((ExperimentalCronetEngine) sCronetEngine).getEffectiveHttpRtt();
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public static int getEffectiveTransportRttMs() throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        return ((ExperimentalCronetEngine) sCronetEngine).getEffectiveTransportRtt();
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public static int getEffectiveRxThroughputKbps() throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        return ((ExperimentalCronetEngine) sCronetEngine).getEffectiveRxThroughput();
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public static void setAppStartUpState(int r1) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setAppStartUpState(r1);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public static void enableTTBizHttpDns(boolean r8, String r9, String r10, String r11, boolean r12, String r13) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).enableTTBizHttpDns(r8, r9, r10, r11, r12, r13);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public static void bindBigCore(int r1) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).bindBigCore(r1);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public static void bindLittleCore(int r1) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).bindLittleCore(r1);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public static void resetCoreBind(int r1) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).resetCoreBind(r1);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    private static long getALogFuncAddr() throws Exception {
        return ((Long) Reflect.on(Class.forName(TTNET_ALOG_CLASS).newInstance()).call("getALogFuncAddr").get()).longValue();
    }

    private static boolean getListenAppStateIndependently() {
        return ((Boolean) Reflect.on(Class.forName(TTNET_INIT_CLASS).newInstance()).call("getListenAppStateIndependently").get()).booleanValue();
    L4:
        return false;
    }

    private static String getDomainConfigByRegion() {
        String r0 = CronetAppProviderManager.inst().getCarrierRegion();
        String r1 = CronetAppProviderManager.inst().getSysRegion();
        String r2 = CronetAppProviderManager.inst().getRegion();
        if (TextUtils.isEmpty(r0) == false) goto L10;
        if (TextUtils.isEmpty(r1) == true) goto L8;
        r0 = r1;
        goto L10
    L8:
        r0 = r2;
    L10:
        if (TextUtils.isEmpty(r0) == false) goto L15;
        return null;
    L15:
        return (String) Reflect.on(Class.forName(TTNET_INIT_CLASS).newInstance()).call("getGetDomainConfigByRegion", new Class[]{String.class}, new Object[]{r0}).get();
    L14:
        return null;
    }

    private static long getMaxHttpDiskCacheSize() {
        return ((Long) Reflect.on(Class.forName(TTNET_INIT_CLASS).newInstance()).call("getMaxHttpDiskCacheSize").get()).longValue();
    L4:
        return BluetoothPbapClient.VCARD_ATTR_CLASS;
    }

    private static int getAppSecurityLevel() {
        return ((Integer) Reflect.on(Class.forName(TTNET_INIT_CLASS).newInstance()).call("getAppSecurityLevel").get()).intValue();
    L4:
        return 0;
    }

    private static ArrayList<TTNetThreadConfig> getThreadConfigInfoList() {
        return (ArrayList) Reflect.on(Class.forName(TTNET_INIT_CLASS).newInstance()).call("getThreadConfigInfoList").get();
    L4:
        return null;
    }

    private static TTNetThreadConfig.Callback getThreadConfigCallbackImpl() {
        return (TTNetThreadConfig.Callback) Reflect.on(Class.forName(TTNET_INIT_CLASS).newInstance()).call("getThreadConfigCallbackImpl").get();
    L4:
        return null;
    }

    private String getProxyConfig(String r5) {
        String r0 = "";
        if (TextUtils.isEmpty(r5) == true) goto L34;
        BufferedReader r4 = null;
        File r1 = new File(r5 + TTNET_CONFIG_FILE);     // Catch: Throwable -> L21
        if (r1.exists() == false) goto L16;
        BufferedReader r6 = new BufferedReader(new FileReader(r1));     // Catch: Throwable -> L21
        StringBuilder r7 = new StringBuilder();     // Catch: Throwable -> L14
    L9:
        String r2 = r6.readLine();     // Catch: Throwable -> L14
        if (r2 == null) goto L12;
        r7.append(r2);     // Catch: Throwable -> L14
        goto L9
    L12:
        r0 = new JSONObject(r7.toString()).optString("ttnet_proxy", "");     // Catch: Throwable -> L14
        r4 = r6;
    L14:
        Throwable th = th;
    L42:
        th.printStackTrace();     // Catch: Throwable -> L27
        if (r6 == null) goto L34;
        r6.close();     // Catch: IOException -> L19
    L35:
    L27:
        th = move-exception;
        if (r6 != null) goto L40;
    L33:
        throw th;
    L40:
        r6.close();     // Catch: IOException -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
    L16:
        if (r4 == null) goto L34;
        r4.close();     // Catch: IOException -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
    L21:
        th = move-exception;
        r6 = null;
        th = th;
    L34:
        return r0;
    }
}
